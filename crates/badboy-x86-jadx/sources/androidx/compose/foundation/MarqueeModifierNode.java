package androidx.compose.foundation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier.Node;
import androidx.compose.ui.focus.FocusEventModifierNode;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.ClipOp.Companion;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DrawModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B5\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u000c\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\u0008\u0010:\u001a\u00020;H\u0016J\u0008\u0010<\u001a\u00020;H\u0016J\u0010\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020?H\u0016J\u0008\u0010@\u001a\u00020;H\u0002J\u000e\u0010A\u001a\u00020;H\u0082@¢\u0006\u0002\u0010BJ@\u0010C\u001a\u00020;2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0004\u0008D\u0010EJ\u000c\u0010F\u001a\u00020;*\u00020GH\u0016J\u001c\u0010H\u001a\u00020\u0006*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0006H\u0016J\u001c\u0010M\u001a\u00020\u0006*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010N\u001a\u00020\u0006H\u0016J&\u0010O\u001a\u00020P*\u00020Q2\u0006\u0010J\u001a\u00020R2\u0006\u0010S\u001a\u00020TH\u0016ø\u0001\u0000¢\u0006\u0004\u0008U\u0010VJ\u001c\u0010W\u001a\u00020\u0006*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0006H\u0016J\u001c\u0010X\u001a\u00020\u0006*\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010N\u001a\u00020\u0006H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010\u0007\u001a\u00020\u00082\u0006\u0010\u0012\u001a\u00020\u00088F@FX\u0086\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0013\u0010\u0014\"\u0004\u0008\u0015\u0010\u0016R+\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u001c\u0010\u001d\u001a\u0004\u0008\u001a\u0010\u0014\"\u0004\u0008\u001b\u0010\u0016R+\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008!\u0010\u001d\u001a\u0004\u0008\u001f\u0010\u0014\"\u0004\u0008 \u0010\u0016R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\"\u001a\u00020#8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008$\u0010%R+\u0010'\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020&8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008,\u0010\u0018\u001a\u0004\u0008(\u0010)\"\u0004\u0008*\u0010+R\u000e\u0010\n\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020/0.X\u0082\u0004¢\u0006\u0002\n\u0000R+\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0012\u001a\u00020\u000c8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u00084\u0010\u0018\u001a\u0004\u00080\u00101\"\u0004\u00082\u00103R\u001b\u00105\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u00087\u00108\u001a\u0004\u00086\u0010\u0014R\u0016\u0010\r\u001a\u00020\u000eX\u0082\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u00109\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006Y", d2 = {"Landroidx/compose/foundation/MarqueeModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "iterations", "", "animationMode", "Landroidx/compose/foundation/MarqueeAnimationMode;", "delayMillis", "initialDelayMillis", "spacing", "Landroidx/compose/foundation/MarqueeSpacing;", "velocity", "Landroidx/compose/ui/unit/Dp;", "(IIIILandroidx/compose/foundation/MarqueeSpacing;FLkotlin/jvm/internal/DefaultConstructorMarker;)V", "animationJob", "Lkotlinx/coroutines/Job;", "<set-?>", "getAnimationMode-ZbEOnfQ", "()I", "setAnimationMode-97h66l8", "(I)V", "animationMode$delegate", "Landroidx/compose/runtime/MutableState;", "containerWidth", "getContainerWidth", "setContainerWidth", "containerWidth$delegate", "Landroidx/compose/runtime/MutableIntState;", "contentWidth", "getContentWidth", "setContentWidth", "contentWidth$delegate", "direction", "", "getDirection", "()F", "", "hasFocus", "getHasFocus", "()Z", "setHasFocus", "(Z)V", "hasFocus$delegate", "offset", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/animation/core/AnimationVector1D;", "getSpacing", "()Landroidx/compose/foundation/MarqueeSpacing;", "setSpacing", "(Landroidx/compose/foundation/MarqueeSpacing;)V", "spacing$delegate", "spacingPx", "getSpacingPx", "spacingPx$delegate", "Landroidx/compose/runtime/State;", "F", "onAttach", "", "onDetach", "onFocusEvent", "focusState", "Landroidx/compose/ui/focus/FocusState;", "restartAnimation", "runAnimation", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "update", "update-lWfNwf4", "(IIIILandroidx/compose/foundation/MarqueeSpacing;F)V", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MarqueeModifierNode extends Modifier.Node implements LayoutModifierNode, DrawModifierNode, FocusEventModifierNode {

    private Job animationJob;
    private final MutableState animationMode$delegate;
    private final MutableIntState containerWidth$delegate;
    private final MutableIntState contentWidth$delegate;
    private int delayMillis;
    private final MutableState hasFocus$delegate;
    private int initialDelayMillis;
    private int iterations;
    private final Animatable<Float, AnimationVector1D> offset;
    private final MutableState spacing$delegate;
    private final State spacingPx$delegate;
    private float velocity;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[LayoutDirection.Ltr.ordinal()] = 1;
            iArr[LayoutDirection.Rtl.ordinal()] = 2;
            MarqueeModifierNode.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    private MarqueeModifierNode(int iterations, int animationMode, int delayMillis, int initialDelayMillis, androidx.compose.foundation.MarqueeSpacing spacing, float velocity) {
        super();
        this.iterations = iterations;
        this.delayMillis = delayMillis;
        this.initialDelayMillis = initialDelayMillis;
        this.velocity = velocity;
        int i = 0;
        this.contentWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(i);
        this.containerWidth$delegate = SnapshotIntStateKt.mutableIntStateOf(i);
        int i3 = 0;
        final int i4 = 2;
        this.hasFocus$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i), i3, i4, i3);
        this.spacing$delegate = SnapshotStateKt.mutableStateOf$default(spacing, i3, i4, i3);
        this.animationMode$delegate = SnapshotStateKt.mutableStateOf$default(MarqueeAnimationMode.box-impl(animationMode), i3, i4, i3);
        int i2 = 0;
        this.offset = AnimatableKt.Animatable$default(i2, i2, i4, i3);
        MarqueeModifierNode.spacingPx.2 anon = new MarqueeModifierNode.spacingPx.2(spacing, this);
        this.spacingPx$delegate = SnapshotStateKt.derivedStateOf((Function0)anon);
    }

    public MarqueeModifierNode(int i, int i2, int i3, int i4, androidx.compose.foundation.MarqueeSpacing marqueeSpacing5, float f6, DefaultConstructorMarker defaultConstructorMarker7) {
        super(i, i2, i3, i4, marqueeSpacing5, f6);
    }

    public static final int access$getContainerWidth(androidx.compose.foundation.MarqueeModifierNode $this) {
        return $this.getContainerWidth();
    }

    public static final int access$getContentWidth(androidx.compose.foundation.MarqueeModifierNode $this) {
        return $this.getContentWidth();
    }

    public static final int access$getDelayMillis$p(androidx.compose.foundation.MarqueeModifierNode $this) {
        return $this.delayMillis;
    }

    public static final float access$getDirection(androidx.compose.foundation.MarqueeModifierNode $this) {
        return $this.getDirection();
    }

    public static final boolean access$getHasFocus(androidx.compose.foundation.MarqueeModifierNode $this) {
        return $this.getHasFocus();
    }

    public static final int access$getInitialDelayMillis$p(androidx.compose.foundation.MarqueeModifierNode $this) {
        return $this.initialDelayMillis;
    }

    public static final int access$getIterations$p(androidx.compose.foundation.MarqueeModifierNode $this) {
        return $this.iterations;
    }

    public static final Animatable access$getOffset$p(androidx.compose.foundation.MarqueeModifierNode $this) {
        return $this.offset;
    }

    public static final int access$getSpacingPx(androidx.compose.foundation.MarqueeModifierNode $this) {
        return $this.getSpacingPx();
    }

    public static final float access$getVelocity$p(androidx.compose.foundation.MarqueeModifierNode $this) {
        return $this.velocity;
    }

    public static final Object access$runAnimation(androidx.compose.foundation.MarqueeModifierNode $this, Continuation $completion) {
        return $this.runAnimation($completion);
    }

    private final int getContainerWidth() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.containerWidth$delegate.getIntValue();
    }

    private final int getContentWidth() {
        final int i = 0;
        final int i2 = 0;
        return (IntState)this.contentWidth$delegate.getIntValue();
    }

    private final float getDirection() {
        int i;
        switch (i3) {
            case 1:
                i = 1;
                break;
            case 2:
                i = -1;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return signum *= f;
    }

    private final boolean getHasFocus() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.hasFocus$delegate.getValue().booleanValue();
    }

    private final int getSpacingPx() {
        final int i = 0;
        final int i2 = 0;
        return (Number)this.spacingPx$delegate.getValue().intValue();
    }

    private final void restartAnimation() {
        int launch$default;
        int i5;
        boolean attached;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i2;
        int i;
        androidx.compose.foundation.MarqueeModifierNode.restartAnimation.1 anon;
        int i4;
        int i3;
        final Job animationJob = this.animationJob;
        launch$default = 0;
        if (animationJob != null) {
            Job.DefaultImpls.cancel$default(animationJob, launch$default, 1, launch$default);
        }
        if (isAttached()) {
            attached = new MarqueeModifierNode.restartAnimation.1(animationJob, this, launch$default);
            this.animationJob = BuildersKt.launch$default(getCoroutineScope(), 0, 0, (Function2)attached, 3, 0);
        }
    }

    private final Object runAnimation(Continuation<? super Unit> $completion) {
        if (this.iterations <= 0) {
            return Unit.INSTANCE;
        }
        MarqueeModifierNode.runAnimation.2 anon = new MarqueeModifierNode.runAnimation.2(this, 0);
        Object context = BuildersKt.withContext((CoroutineContext)FixedMotionDurationScale.INSTANCE, (Function2)anon, $completion);
        if (context == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return context;
        }
        return Unit.INSTANCE;
    }

    private final void setContainerWidth(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.containerWidth$delegate.setIntValue(<set-?>);
    }

    private final void setContentWidth(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.contentWidth$delegate.setIntValue(<set-?>);
    }

    private final void setHasFocus(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.hasFocus$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void draw(ContentDrawScope $this$draw) {
        int i3;
        int i10;
        int i;
        int i2;
        int i5;
        DrawTransform transform;
        int obj;
        int spacingPx;
        int i6;
        int $this$draw_u24lambda_u241;
        int clipOffset;
        float f;
        float f2;
        int containerWidth;
        int i4;
        int i8;
        int i11;
        int i7;
        int i9;
        obj = this;
        clipOffset = floatValue * direction4;
        int i14 = 1065353216;
        i6 = 1;
        int i16 = 0;
        i3 = Float.compare(direction, i14) == 0 ? i6 : i16;
        if (i3 != 0) {
            i10 = Float.compare(floatValue2, f) < 0 ? i6 : i16;
        } else {
            i10 = Float.compare(floatValue3, f) < 0 ? i6 : i16;
        }
        i = Float.compare(direction2, i14) == 0 ? i6 : i16;
        if (i != 0) {
            i2 = Float.compare(floatValue4, f2) > 0 ? i6 : i16;
        } else {
            i2 = Float.compare(floatValue5, f2) > 0 ? i6 : i16;
        }
        final int i22 = i2;
        if (Float.compare(direction3, i14) == 0) {
        } else {
            i6 = i16;
        }
        if (i6 != 0) {
            contentWidth2 += spacingPx;
        } else {
            i12 -= spacingPx;
        }
        float f5 = f3;
        final int i23 = $this$draw;
        final int i24 = 0;
        final int i25 = i23;
        final int i26 = 0;
        final DrawContext drawContext3 = i25.getDrawContext();
        final int i27 = 0;
        drawContext3.getCanvas().save();
        transform = 0;
        drawContext3.getTransform().clipRect-N_I0leg(clipOffset, 0, clipOffset + f4, Size.getHeight-impl((DrawScope)i23.getSize-NH-jbRc()), ClipOp.Companion.getIntersect-rtfAjoo());
        $this$draw_u24lambda_u241 = i25;
        final int i30 = 0;
        if (i10 != 0) {
            $this$draw.drawContent();
        }
        if (i22 != 0) {
            i4 = $this$draw_u24lambda_u241;
            obj = 0;
            i8 = 0;
            i4.getDrawContext().getTransform().translate(f5, obj);
            int i13 = i4;
            int i31 = 0;
            $this$draw.drawContent();
            i11 = $this$draw_u24lambda_u241;
            i9 = clipOffset;
            i4.getDrawContext().getTransform().translate(-f5, -obj);
        } else {
            i11 = $this$draw_u24lambda_u241;
            i9 = clipOffset;
        }
        drawContext3.getCanvas().restore();
        drawContext3.setSize-uvyYCjk(drawContext3.getSize-NH-jbRc());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final int getAnimationMode-ZbEOnfQ() {
        final int i = 0;
        final int i2 = 0;
        return (MarqueeAnimationMode)(State)this.animationMode$delegate.getValue().unbox-impl();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final androidx.compose.foundation.MarqueeSpacing getSpacing() {
        final int i = 0;
        final int i2 = 0;
        return (MarqueeSpacing)(State)this.spacing$delegate.getValue();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        return measurable.maxIntrinsicHeight(Integer.MAX_VALUE);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        return measurable.maxIntrinsicWidth(height);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public MeasureResult measure-3p2s80s(MeasureScope $this$measure_u2d3p2s80s, Measurable measurable, long constraints) {
        final int i6 = 0;
        final Object obj = constraints;
        Placeable measure-BRTryo0 = measurable.measure-BRTryo0(Constraints.copy-Zbe2FdA$default(obj, obj1, 0, Integer.MAX_VALUE, 0, 0, 13));
        setContainerWidth(ConstraintsKt.constrainWidth-K40F9xA(obj, obj1));
        setContentWidth(measure-BRTryo0.getWidth());
        MarqueeModifierNode.measure.1 anon = new MarqueeModifierNode.measure.1(measure-BRTryo0, this);
        return MeasureScope.layout$default($this$measure_u2d3p2s80s, getContainerWidth(), measure-BRTryo0.getHeight(), i6, (Function1)anon, 4, 0);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        return measurable.minIntrinsicHeight(Integer.MAX_VALUE);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        return 0;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onAttach() {
        restartAnimation();
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onDetach() {
        int i;
        final Job animationJob = this.animationJob;
        final int i2 = 0;
        if (animationJob != null) {
            Job.DefaultImpls.cancel$default(animationJob, i2, 1, i2);
        }
        this.animationJob = i2;
    }

    @Override // androidx.compose.ui.Modifier$Node
    public void onFocusEvent(FocusState focusState) {
        setHasFocus(focusState.getHasFocus());
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setAnimationMode-97h66l8(int <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.animationMode$delegate.setValue(MarqueeAnimationMode.box-impl(<set-?>));
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void setSpacing(androidx.compose.foundation.MarqueeSpacing <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.spacing$delegate.setValue(<set-?>);
    }

    @Override // androidx.compose.ui.Modifier$Node
    public final void update-lWfNwf4(int iterations, int animationMode, int delayMillis, int initialDelayMillis, androidx.compose.foundation.MarqueeSpacing spacing, float velocity) {
        boolean initialDelayMillis2;
        setSpacing(spacing);
        setAnimationMode-97h66l8(animationMode);
        if (this.iterations == iterations && this.delayMillis == delayMillis && this.initialDelayMillis == initialDelayMillis) {
            if (this.delayMillis == delayMillis) {
                if (this.initialDelayMillis == initialDelayMillis) {
                    if (!Dp.equals-impl0(this.velocity, velocity)) {
                        this.iterations = iterations;
                        this.delayMillis = delayMillis;
                        this.initialDelayMillis = initialDelayMillis;
                        this.velocity = velocity;
                        restartAnimation();
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }
}
