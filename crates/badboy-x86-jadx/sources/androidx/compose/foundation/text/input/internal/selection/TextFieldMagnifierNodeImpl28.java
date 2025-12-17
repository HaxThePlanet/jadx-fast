package androidx.compose.foundation.text.input.internal.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.foundation.MagnifierNode;
import androidx.compose.foundation.Magnifier_androidKt;
import androidx.compose.foundation.text.input.internal.TextLayoutState;
import androidx.compose.foundation.text.input.internal.TransformedTextFieldState;
import androidx.compose.foundation.text.selection.SelectionMagnifierKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSize.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.Job.DefaultImpls;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0008\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020!H\u0016J\u0008\u0010\"\u001a\u00020\u001eH\u0002J(\u0010#\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0016J\u000c\u0010$\u001a\u00020\u001e*\u00020%H\u0016J\u000c\u0010&\u001a\u00020\u001e*\u00020'H\u0016R\u001a\u0010\u000c\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R1\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00158B@BX\u0082\u008e\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\u0008\u001b\u0010\u001c\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006(", d2 = {"Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNodeImpl28;", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldMagnifierNode;", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "textFieldState", "Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;", "textFieldSelectionState", "Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;", "textLayoutState", "Landroidx/compose/foundation/text/input/internal/TextLayoutState;", "visible", "", "(Landroidx/compose/foundation/text/input/internal/TransformedTextFieldState;Landroidx/compose/foundation/text/input/internal/selection/TextFieldSelectionState;Landroidx/compose/foundation/text/input/internal/TextLayoutState;Z)V", "animatable", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/animation/core/AnimationVector2D;", "animationJob", "Lkotlinx/coroutines/Job;", "magnifierNode", "Landroidx/compose/foundation/MagnifierNode;", "<set-?>", "Landroidx/compose/ui/unit/IntSize;", "magnifierSize", "getMagnifierSize-YbymL2g", "()J", "setMagnifierSize-ozmzZPI", "(J)V", "magnifierSize$delegate", "Landroidx/compose/runtime/MutableState;", "onAttach", "", "onGloballyPositioned", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "restartAnimationJob", "update", "applySemantics", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldMagnifierNodeImpl28 extends androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode implements CompositionLocalConsumerModifierNode {

    public static final int $stable;
    private final Animatable<Offset, AnimationVector2D> animatable;
    private Job animationJob;
    private final MagnifierNode magnifierNode;
    private final MutableState magnifierSize$delegate;
    private androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState textFieldSelectionState;
    private TransformedTextFieldState textFieldState;
    private TextLayoutState textLayoutState;
    private boolean visible;
    static {
    }

    public TextFieldMagnifierNodeImpl28(TransformedTextFieldState textFieldState, androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState textFieldSelectionState, TextLayoutState textLayoutState, boolean visible) {
        final Object obj = this;
        super();
        obj.textFieldState = textFieldState;
        obj.textFieldSelectionState = textFieldSelectionState;
        obj.textLayoutState = textLayoutState;
        obj.visible = visible;
        int i = 0;
        obj.magnifierSize$delegate = SnapshotStateKt.mutableStateOf$default(IntSize.box-impl(IntSize.Companion.getZero-YbymL2g()), i, 2, i);
        TextLayoutState textLayoutState3 = obj.textLayoutState;
        Animatable animatable = new Animatable(Offset.box-impl(TextFieldMagnifierKt.calculateSelectionMagnifierCenterAndroid-hUlJWOE(obj.textFieldState, obj.textFieldSelectionState, textLayoutState3, obj.getMagnifierSize-YbymL2g())), SelectionMagnifierKt.getUnspecifiedSafeOffsetVectorConverter(), Offset.box-impl(SelectionMagnifierKt.getOffsetDisplacementThreshold()), 0, 8, 0);
        obj.animatable = animatable;
        TextFieldMagnifierNodeImpl28.magnifierNode.1 anon = new TextFieldMagnifierNodeImpl28.magnifierNode.1(obj);
        TextFieldMagnifierNodeImpl28.magnifierNode.2 anon2 = new TextFieldMagnifierNodeImpl28.magnifierNode.2(obj);
        MagnifierNode magnifierNode = new MagnifierNode((Function1)anon, 0, (Function1)anon2, 0, 1, 0, obj14, 0, 0, 0, 0, 1002, 0);
        obj.magnifierNode = (MagnifierNode)obj.delegate((DelegatableNode)magnifierNode);
    }

    public static final Animatable access$getAnimatable$p(androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28 $this) {
        return $this.animatable;
    }

    public static final long access$getMagnifierSize-YbymL2g(androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28 $this) {
        return $this.getMagnifierSize-YbymL2g();
    }

    public static final androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState access$getTextFieldSelectionState$p(androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28 $this) {
        return $this.textFieldSelectionState;
    }

    public static final TransformedTextFieldState access$getTextFieldState$p(androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28 $this) {
        return $this.textFieldState;
    }

    public static final TextLayoutState access$getTextLayoutState$p(androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28 $this) {
        return $this.textLayoutState;
    }

    public static final boolean access$getVisible$p(androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28 $this) {
        return $this.visible;
    }

    public static final void access$setMagnifierSize-ozmzZPI(androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNodeImpl28 $this, long <set-?>) {
        $this.setMagnifierSize-ozmzZPI(<set-?>);
    }

    private final long getMagnifierSize-YbymL2g() {
        final int i = 0;
        final int i2 = 0;
        return (IntSize)(State)this.magnifierSize$delegate.getValue().unbox-impl();
    }

    private final void restartAnimationJob() {
        Job animationJob = this.animationJob;
        final int i2 = 1;
        final int i3 = 0;
        if (animationJob != null) {
            Job.DefaultImpls.cancel$default(animationJob, i3, i2, i3);
        }
        this.animationJob = i3;
        if (!Magnifier_androidKt.isPlatformMagnifierSupported$default(0, i2, i3)) {
        }
        TextFieldMagnifierNodeImpl28.restartAnimationJob.1 anon = new TextFieldMagnifierNodeImpl28.restartAnimationJob.1(this, i3);
        this.animationJob = BuildersKt.launch$default(getCoroutineScope(), 0, 0, (Function2)anon, 3, 0);
    }

    private final void setMagnifierSize-ozmzZPI(long <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.magnifierSize$delegate.setValue(IntSize.box-impl(<set-?>));
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode
    public void applySemantics(SemanticsPropertyReceiver $this$applySemantics) {
        final int i = 0;
        this.magnifierNode.applySemantics($this$applySemantics);
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode
    public void draw(ContentDrawScope $this$draw) {
        $this$draw.drawContent();
        final int i = 0;
        this.magnifierNode.draw($this$draw);
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode
    public void onAttach() {
        restartAnimationJob();
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        this.magnifierNode.onGloballyPositioned(coordinates);
    }

    @Override // androidx.compose.foundation.text.input.internal.selection.TextFieldMagnifierNode
    public void update(TransformedTextFieldState textFieldState, androidx.compose.foundation.text.input.internal.selection.TextFieldSelectionState textFieldSelectionState, TextLayoutState textLayoutState, boolean visible) {
        boolean equal;
        this.textFieldState = textFieldState;
        this.textFieldSelectionState = textFieldSelectionState;
        this.textLayoutState = textLayoutState;
        this.visible = visible;
        if (Intrinsics.areEqual(textFieldState, this.textFieldState) && Intrinsics.areEqual(textFieldSelectionState, this.textFieldSelectionState) && Intrinsics.areEqual(textLayoutState, this.textLayoutState)) {
            if (Intrinsics.areEqual(textFieldSelectionState, textFieldSelectionState2)) {
                if (Intrinsics.areEqual(textLayoutState, textLayoutState2)) {
                    if (visible != this.visible) {
                        restartAnimationJob();
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }
}
