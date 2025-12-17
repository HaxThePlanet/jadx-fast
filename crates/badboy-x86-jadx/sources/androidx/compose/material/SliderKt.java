package androidx.compose.material;

import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.HoverableKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.FloatRef;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001aS\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00080\u00142\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00162\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00162\u000c\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00192\u0006\u0010\u001a\u001a\u00020\u0008H\u0003¢\u0006\u0002\u0010\u001b\u001a\u007f\u0010\u001c\u001a\u00020\u00122\u000c\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00162\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00080\u0016\u0012\u0004\u0012\u00020\u00120\u00142\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u000e\u0008\u0002\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00162\u0008\u0008\u0003\u0010!\u001a\u00020\"2\u0010\u0008\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\u0008\u0008\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u0010'\u001ak\u0010(\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020\u00082\u0006\u0010*\u001a\u00020\u00082\u000c\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u00080,2\u0006\u0010%\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00082\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u00101\u001a\u00020\u00012\u0006\u00102\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00103\u001a\u007f\u00104\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00082\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00120\u00142\u0008\u0008\u0002\u0010\u001e\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u000e\u0008\u0002\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00162\u0008\u0008\u0003\u0010!\u001a\u00020\"2\u0010\u0008\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\n\u0008\u0002\u00105\u001a\u0004\u0018\u00010/2\u0008\u0008\u0002\u0010%\u001a\u00020&H\u0007¢\u0006\u0002\u00106\u001aK\u00107\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 2\u0006\u00108\u001a\u00020\u00082\u000c\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u00080,2\u0006\u0010%\u001a\u00020&2\u0006\u0010-\u001a\u00020\u00082\u0006\u00105\u001a\u00020/2\u0006\u0010\u001e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u00109\u001aS\u0010:\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010)\u001a\u00020\u00082\u0006\u0010*\u001a\u00020\u00082\u000c\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u00080,2\u0006\u0010;\u001a\u00020\u00082\u0006\u0010<\u001a\u00020\u0008H\u0003¢\u0006\u0002\u0010=\u001a.\u0010>\u001a\u00020\u00122\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u00082\u0006\u0010B\u001a\u00020\u00082\u0006\u0010C\u001a\u00020\u0008H\u0082@¢\u0006\u0002\u0010D\u001a \u0010E\u001a\u00020\u00082\u0006\u0010F\u001a\u00020\u00082\u0006\u0010G\u001a\u00020\u00082\u0006\u0010H\u001a\u00020\u0008H\u0002\u001a0\u0010I\u001a\u00020\u00082\u0006\u0010J\u001a\u00020\u00082\u0006\u0010K\u001a\u00020\u00082\u0006\u0010L\u001a\u00020\u00082\u0006\u0010M\u001a\u00020\u00082\u0006\u0010N\u001a\u00020\u0008H\u0002\u001a<\u0010I\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00162\u0006\u0010J\u001a\u00020\u00082\u0006\u0010K\u001a\u00020\u00082\u000c\u0010O\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00162\u0006\u0010M\u001a\u00020\u00082\u0006\u0010N\u001a\u00020\u0008H\u0002\u001a.\u0010P\u001a\u00020\u00082\u0006\u0010A\u001a\u00020\u00082\u000c\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u00080,2\u0006\u0010Q\u001a\u00020\u00082\u0006\u0010R\u001a\u00020\u0008H\u0002\u001a\u0016\u0010S\u001a\u0008\u0012\u0004\u0012\u00020\u00080,2\u0006\u0010!\u001a\u00020\"H\u0002\u001aF\u0010T\u001a\u00020\u0012*\u00020U2\u0006\u0010\u001e\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\u00032\u0006\u00105\u001a\u00020/2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010W\u001a\u00020\u0003H\u0003ø\u0001\u0000¢\u0006\u0004\u0008X\u0010Y\u001a5\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\u0008\u0018\u00010[*\u00020]2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020aH\u0082@ø\u0001\u0000¢\u0006\u0004\u0008b\u0010c\u001a\u0098\u0001\u0010d\u001a\u00020\u0001*\u00020\u00012\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u000c\u0010e\u001a\u0008\u0012\u0004\u0012\u00020\u00080f2\u000c\u0010g\u001a\u0008\u0012\u0004\u0012\u00020\u00080f2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010h\u001a\u00020 2\u0006\u0010R\u001a\u00020\u00082\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00162\u0018\u0010i\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00120\u00140f2\u001e\u0010j\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00120k0fH\u0002\u001a\\\u0010l\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00082\u0006\u0010\u001f\u001a\u00020 2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00120\u00142\u0010\u0008\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010$2\u000e\u0008\u0002\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00162\u0008\u0008\u0002\u0010!\u001a\u00020\"H\u0002\u001aj\u0010m\u001a\u00020\u0001*\u00020\u00012\u0006\u0010?\u001a\u00020@2\u0006\u00105\u001a\u00020/2\u0006\u0010R\u001a\u00020\u00082\u0006\u0010h\u001a\u00020 2\u000c\u0010n\u001a\u0008\u0012\u0004\u0012\u00020\u00080f2\u0018\u0010i\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\u00120\u00140f2\u000c\u0010o\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00192\u0006\u0010\u001f\u001a\u00020 H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u000b\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u000c\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u000f\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0010\u0010\r\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006p", d2 = {"DefaultSliderConstraints", "Landroidx/compose/ui/Modifier;", "SliderHeight", "Landroidx/compose/ui/unit/Dp;", "F", "SliderMinWidth", "SliderToTickAnimation", "Landroidx/compose/animation/core/TweenSpec;", "", "ThumbDefaultElevation", "ThumbPressedElevation", "ThumbRadius", "getThumbRadius", "()F", "ThumbRippleRadius", "TrackHeight", "getTrackHeight", "CorrectValueSideEffect", "", "scaleToOffset", "Lkotlin/Function1;", "valueRange", "Lkotlin/ranges/ClosedFloatingPointRange;", "trackRange", "valueState", "Landroidx/compose/runtime/MutableState;", "value", "(Lkotlin/jvm/functions/Function1;Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/MutableState;FLandroidx/compose/runtime/Composer;I)V", "RangeSlider", "onValueChange", "modifier", "enabled", "", "steps", "", "onValueChangeFinished", "Lkotlin/Function0;", "colors", "Landroidx/compose/material/SliderColors;", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "positionFractionStart", "positionFractionEnd", "tickFractions", "", "width", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumbSemantics", "endThumbSemantics", "(ZFFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Slider", "interactionSource", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "positionFraction", "(ZFLjava/util/List;Landroidx/compose/material/SliderColors;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "Track", "thumbPx", "trackStrokeWidth", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/SliderColors;ZFFLjava/util/List;FFLandroidx/compose/runtime/Composer;I)V", "animateToTarget", "draggableState", "Landroidx/compose/foundation/gestures/DraggableState;", "current", "target", "velocity", "(Landroidx/compose/foundation/gestures/DraggableState;FFFLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x1", "a2", "b2", "x", "snapValueToTick", "minPx", "maxPx", "stepsToTickFractions", "SliderThumb", "Landroidx/compose/foundation/layout/BoxScope;", "offset", "thumbSize", "SliderThumb-PcYyNuk", "(Landroidx/compose/foundation/layout/BoxScope;Landroidx/compose/ui/Modifier;FLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SliderColors;ZFLandroidx/compose/runtime/Composer;I)V", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderPressDragModifier", "rawOffsetStart", "Landroidx/compose/runtime/State;", "rawOffsetEnd", "isRtl", "gestureEndAction", "onDrag", "Lkotlin/Function2;", "sliderSemantics", "sliderTapModifier", "rawOffset", "pressOffset", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SliderKt {

    private static final Modifier DefaultSliderConstraints;
    private static final float SliderHeight;
    private static final float SliderMinWidth;
    private static final TweenSpec<Float> SliderToTickAnimation;
    private static final float ThumbDefaultElevation;
    private static final float ThumbPressedElevation;
    private static final float ThumbRadius;
    private static final float ThumbRippleRadius;
    private static final float TrackHeight;
    static {
        int i8 = 0;
        SliderKt.ThumbRadius = Dp.constructor-impl((float)i);
        int i9 = 0;
        SliderKt.ThumbRippleRadius = Dp.constructor-impl((float)i2);
        int i10 = 0;
        SliderKt.ThumbDefaultElevation = Dp.constructor-impl((float)i3);
        int i11 = 0;
        SliderKt.ThumbPressedElevation = Dp.constructor-impl((float)i4);
        int i12 = 0;
        SliderKt.TrackHeight = Dp.constructor-impl((float)i5);
        int i13 = 0;
        SliderKt.SliderHeight = Dp.constructor-impl((float)i6);
        int i14 = 0;
        SliderKt.SliderMinWidth = Dp.constructor-impl((float)i7);
        int i15 = 0;
        final int i20 = 0;
        SliderKt.DefaultSliderConstraints = SizeKt.heightIn-VpY3zN4$default(SizeKt.widthIn-VpY3zN4$default((Modifier)Modifier.Companion, SliderKt.SliderMinWidth, i15, 2, i20), i15, SliderKt.SliderHeight, 1, i20);
        TweenSpec tweenSpec = new TweenSpec(100, 0, i20, 6, 0);
        SliderKt.SliderToTickAnimation = tweenSpec;
    }

    private static final void CorrectValueSideEffect(Function1<? super Float, Float> scaleToOffset, ClosedFloatingPointRange<Float> valueRange, ClosedFloatingPointRange<Float> trackRange, MutableState<Float> valueState, float value, Composer $composer, int $changed) {
        int i4;
        int traceInProgress2;
        int $dirty;
        int $dirty2;
        boolean traceInProgress;
        int i12;
        int i10;
        int i9;
        int i5;
        int i6;
        float f;
        int i3;
        int i2;
        int i;
        int i13;
        int rememberedValue;
        int i11;
        Object empty;
        Object obj2;
        Object obj3;
        float i7;
        Object obj4;
        Object obj;
        int i8;
        int str;
        int i14;
        final int i27 = $changed;
        traceInProgress2 = -743965752;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(CorrectValueSideEffect)P(!1,3!1,4)848@33715L300,848@33704L311:Slider.kt#jmzs0o");
        i13 = 4;
        if (i27 & 6 == 0) {
            i10 = restartGroup.changedInstance(scaleToOffset) ? i13 : 2;
            $dirty |= i10;
        } else {
            obj3 = scaleToOffset;
        }
        rememberedValue = 32;
        if (i27 & 48 == 0) {
            i9 = restartGroup.changed(valueRange) ? rememberedValue : 16;
            $dirty |= i9;
        } else {
            obj2 = valueRange;
        }
        i11 = 256;
        if (i27 & 384 == 0) {
            i5 = restartGroup.changed(trackRange) ? i11 : 128;
            $dirty |= i5;
        } else {
            obj = trackRange;
        }
        empty = 2048;
        if (i27 & 3072 == 0) {
            i6 = restartGroup.changed(valueState) ? empty : 1024;
            $dirty |= i6;
        } else {
            obj4 = valueState;
        }
        i7 = 16384;
        if (i27 & 24576 == 0) {
            i8 = restartGroup.changed(value) ? i7 : 8192;
            $dirty |= i8;
        } else {
            f = value;
        }
        int i28 = $dirty;
        if (i28 & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i28, -1, "androidx.compose.material.CorrectValueSideEffect (Slider.kt:847)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1313906175, "CC(remember):Slider.kt#9igjgp");
                i12 = 1;
                str = 0;
                i4 = i28 & 112 == rememberedValue ? i12 : str;
                i3 = i28 & 14 == i13 ? i12 : str;
                i2 = i22 &= i28 == i7 ? i12 : str;
                i = i28 & 7168 == empty ? i12 : str;
                if (i28 & 896 == i11) {
                } else {
                    i12 = str;
                }
                $dirty2 = restartGroup;
                i13 = 0;
                rememberedValue = $dirty2.rememberedValue();
                i11 = 0;
                if (i19 |= i12 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        i14 = 0;
                        empty = new SliderKt.CorrectValueSideEffect.1.1(obj2, obj3, f, obj4, obj);
                        $dirty2.updateRememberedValue((Function0)empty);
                    } else {
                        empty = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.SideEffect((Function0)empty, restartGroup, str);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SliderKt.CorrectValueSideEffect.2(scaleToOffset, valueRange, trackRange, valueState, value, i27);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void RangeSlider(ClosedFloatingPointRange<Float> value, Function1<? super ClosedFloatingPointRange<Float>, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> valueRange, int steps, Function0<Unit> onValueChangeFinished, androidx.compose.material.SliderColors colors, Composer $composer, int $changed, int i11) {
        Object i6;
        boolean traceInProgress2;
        int defaultsInvalid;
        Object valueRange2;
        boolean traceInProgress;
        int i13;
        Composer $composer3;
        int i22;
        Object obj7;
        int $dirty;
        Object $dirty2;
        Object obj6;
        boolean z;
        int i8;
        int i14;
        Object obj8;
        int steps2;
        Object obj5;
        int modifier2;
        int i4;
        Object obj2;
        Object onValueChangeFinished2;
        int i2;
        boolean i9;
        androidx.compose.material.SliderColors sliderColors;
        int i15;
        Object colors2;
        int i17;
        int changed;
        Object $composer4;
        Composer $composer2;
        Object obj;
        int stepsToTickFractions;
        Object empty;
        int i26;
        Object i24;
        int i7;
        int changed2;
        State rememberUpdatedState;
        int i10;
        Object obj3;
        Object obj4;
        boolean z2;
        int i21;
        androidx.compose.material.SliderColors sliderColors2;
        int i12;
        int i25;
        int i16;
        int i3;
        int i18;
        int i;
        Composer composer;
        int i19;
        int i20;
        int i5;
        int i23;
        Modifier obj39;
        int obj40;
        int obj41;
        androidx.compose.runtime.internal.ComposableLambda obj42;
        Composer obj43;
        int obj44;
        int obj45;
        final Object obj9 = onValueChange;
        final int i64 = $changed;
        final int i65 = i11;
        Composer restartGroup = $composer.startRestartGroup(-1556183027);
        ComposerKt.sourceInformation(restartGroup, "C(RangeSlider)P(6,3,2,1,7,5,4)304@13749L8,306@13821L39,307@13918L39,310@14039L35,311@14099L59,319@14350L4956,315@14164L5142:Slider.kt#jmzs0o");
        $dirty = $changed;
        if (i65 & 1 != 0) {
            $dirty |= 6;
            obj6 = value;
        } else {
            if (i64 & 6 == 0) {
                i8 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i8;
            } else {
                obj6 = value;
            }
        }
        if (i65 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i64 & 48 == 0) {
                i14 = restartGroup.changedInstance(obj9) ? 32 : 16;
                $dirty |= i14;
            }
        }
        steps2 = i65 & 4;
        if (steps2 != 0) {
            $dirty |= 384;
            obj5 = modifier;
        } else {
            if (i64 & 384 == 0) {
                i4 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i4;
            } else {
                obj5 = modifier;
            }
        }
        onValueChangeFinished2 = i65 & 8;
        if (onValueChangeFinished2 != 0) {
            $dirty |= 3072;
            i9 = enabled;
        } else {
            if (i64 & 3072 == 0) {
                i15 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i15;
            } else {
                i9 = enabled;
            }
        }
        if (i64 & 24576 == 0) {
            if (i65 & 16 == 0) {
                changed = restartGroup.changed(valueRange) ? 16384 : 8192;
            } else {
                colors2 = valueRange;
            }
            $dirty |= changed;
        } else {
            colors2 = valueRange;
        }
        $composer4 = i65 & 32;
        int i76 = 196608;
        if ($composer4 != 0) {
            $dirty |= i76;
            stepsToTickFractions = steps;
        } else {
            if (i76 &= i64 == 0) {
                i26 = restartGroup.changed(steps) ? 131072 : 65536;
                $dirty |= i26;
            } else {
                stepsToTickFractions = steps;
            }
        }
        i24 = i65 & 64;
        i7 = 1572864;
        if (i24 != 0) {
            $dirty |= i7;
            obj = onValueChangeFinished;
        } else {
            if (i64 & i7 == 0) {
                i7 = restartGroup.changedInstance(onValueChangeFinished) ? 1048576 : 524288;
                $dirty |= i7;
            } else {
                obj = onValueChangeFinished;
            }
        }
        if (i64 & i81 == 0) {
            if (i65 & 128 == 0) {
                changed2 = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                i6 = colors;
            }
            $dirty |= changed2;
        } else {
            i6 = colors;
        }
        composer = restartGroup;
        if ($dirty & rememberUpdatedState == 4793490) {
            if (!composer.getSkipping()) {
                composer.startDefaults();
                int i38 = -29360129;
                i10 = -57345;
                if (i64 & 1 != 0) {
                    if (composer.getDefaultsInvalid()) {
                        if (steps2 != 0) {
                            obj5 = defaultsInvalid;
                        }
                        if (onValueChangeFinished2 != 0) {
                            i9 = defaultsInvalid;
                        }
                        if (i65 & 16 != 0) {
                            valueRange2 = RangesKt.rangeTo(0, 1065353216);
                            $dirty &= i10;
                        } else {
                            valueRange2 = colors2;
                        }
                        steps2 = $composer4 != 0 ? 0 : stepsToTickFractions;
                        onValueChangeFinished2 = i24 != 0 ? 0 : obj;
                        if (i65 & 128 != 0) {
                            i22 = 131072;
                            $composer2 = composer;
                            $dirty &= i23;
                            i21 = steps2;
                            i24 = onValueChangeFinished2;
                            z2 = i9;
                            sliderColors2 = colors-q0g_0yA;
                            colors2 = valueRange2;
                        } else {
                            $composer2 = composer;
                            i22 = 131072;
                            sliderColors2 = colors;
                            colors2 = valueRange2;
                            i21 = steps2;
                            i24 = onValueChangeFinished2;
                            z2 = i9;
                        }
                    } else {
                        composer.skipToGroupEnd();
                        if (i65 & 16 != 0) {
                            $dirty &= i10;
                        }
                        if (i65 & 128 != 0) {
                            sliderColors2 = colors;
                            $dirty = valueRange2;
                            z2 = i9;
                            i24 = obj;
                            i21 = stepsToTickFractions;
                            $composer2 = composer;
                            i22 = 131072;
                        } else {
                            sliderColors2 = colors;
                            z2 = i9;
                            i24 = obj;
                            i21 = stepsToTickFractions;
                            $composer2 = composer;
                            i22 = 131072;
                        }
                    }
                } else {
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1556183027, $dirty, -1, "androidx.compose.material.RangeSlider (Slider.kt:305)");
                }
                String str3 = "CC(remember):Slider.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer2, 394849951, str3);
                int i33 = 0;
                Composer composer4 = $composer2;
                int i59 = 0;
                Object rememberedValue3 = composer4.rememberedValue();
                int i77 = 0;
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    int i40 = 0;
                    composer4.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                } else {
                    obj7 = rememberedValue3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerStart($composer2, 394853055, str3);
                int i35 = 0;
                Composer composer2 = $composer2;
                int i49 = 0;
                Object rememberedValue = composer2.rememberedValue();
                int i71 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    int i79 = 0;
                    composer2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                } else {
                    empty = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                i2 = i21 >= 0 ? 1 : i13;
                if (i2 == 0) {
                } else {
                    ComposerKt.sourceInformationMarkerStart($composer2, 394858867, str3);
                    if (i44 &= $dirty == 131072) {
                        i13 = 1;
                    }
                    Composer composer3 = $composer2;
                    int i54 = 0;
                    Object rememberedValue2 = composer3.rememberedValue();
                    int i72 = 0;
                    if (i13 == 0) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            int i78 = 0;
                            composer3.updateRememberedValue(SliderKt.stepsToTickFractions(i21));
                        } else {
                            stepsToTickFractions = rememberedValue2;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int i60 = 0;
                    int i74 = 0;
                    $composer4 = colors2;
                    $composer3 = composer5;
                    SliderKt.RangeSlider.2 valueRange3 = new SliderKt.RangeSlider.2($composer4, obj6, (List)stepsToTickFractions, i24, SnapshotStateKt.rememberUpdatedState(obj9, $composer2, i50 &= 14), (MutableInteractionSource)obj7, (MutableInteractionSource)empty, z2, i21, sliderColors2);
                    obj43 = $composer3;
                    BoxWithConstraintsKt.BoxWithConstraints(SizeKt.requiredSizeIn-qDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(obj5), Dp.constructor-impl(f2 *= thumbRadius), Dp.constructor-impl(f *= other$iv), 0, 0, 12, 0), 0, false, (Function3)ComposableLambdaKt.rememberComposableLambda(652589923, true, valueRange3, $composer3, 54), obj43, 3072, 6);
                    composer = obj43;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i17 = $dirty;
                    $dirty2 = obj5;
                    obj8 = $composer4;
                    obj2 = i24;
                    z = z2;
                    modifier2 = i21;
                    sliderColors = sliderColors2;
                    ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
                    if (endRestartGroup != null) {
                        traceInProgress2 = new SliderKt.RangeSlider.3(value, obj9, $dirty2, z, obj8, modifier2, obj2, sliderColors, i64, i65);
                        endRestartGroup.updateScope((Function2)traceInProgress2);
                    }
                }
            } else {
                composer.skipToGroupEnd();
                z = i9;
                obj8 = colors2;
                obj2 = obj;
                sliderColors = colors;
                i17 = $dirty;
                $dirty2 = obj5;
                modifier2 = stepsToTickFractions;
            }
        } else {
        }
        int i36 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("steps should be >= 0".toString());
        throw illegalArgumentException;
    }

    private static final void RangeSliderImpl(boolean enabled, float positionFractionStart, float positionFractionEnd, List<Float> tickFractions, androidx.compose.material.SliderColors colors, float width, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, Modifier modifier, Modifier startThumbSemantics, Modifier endThumbSemantics, Composer $composer, int $changed, int $changed1) {
        boolean traceInProgress;
        Object endRestartGroup;
        boolean traceInProgress2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Object $this$RangeSliderImpl_u24lambda_u2412;
        Object then;
        Object invalid$iv;
        float f2;
        Function0 factory$iv$iv$iv2;
        float f6;
        Object restartGroup;
        Composer composer3;
        int $dirty;
        int $dirty1;
        boolean trackStrokeWidth;
        int i16;
        Object obj2;
        int empty2;
        int i4;
        float f3;
        Object empty;
        Object obj3;
        Object measurePolicy$iv;
        Object obj;
        int i19;
        int i6;
        int i7;
        int i21;
        int i14;
        int i15;
        int i20;
        int i5;
        int i2;
        int i13;
        int i3;
        int endContentDescription;
        int i12;
        int i9;
        androidx.compose.ui.layout.MeasurePolicy contentAlignment$iv;
        Modifier propagateMinConstraints$iv;
        int currentCompositeKeyHash;
        int i22;
        int i23;
        int i8;
        int i17;
        Alignment factory$iv$iv$iv;
        int i10;
        float widthDp;
        int localMap$iv$iv2;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        Composer composer2;
        float f7;
        androidx.compose.runtime.CompositionLocalMap $composer$iv;
        float f;
        Modifier modifier2;
        float f4;
        Function0 thumbPx;
        int i18;
        int i11;
        int i;
        Composer composer;
        BoxScopeInstance boxScopeInstance;
        float f5;
        boolean z;
        String obj59;
        f3 = width;
        empty = startInteractionSource;
        obj3 = endInteractionSource;
        measurePolicy$iv = modifier;
        obj = startThumbSemantics;
        final Object obj5 = endThumbSemantics;
        int i24 = $changed;
        restartGroup = $composer.startRestartGroup(-278895713);
        ComposerKt.sourceInformation(restartGroup, "C(RangeSliderImpl)P(1,6,5,9!1,10,7!1,4,8)635@26282L35,636@26350L33,637@26388L1522:Slider.kt#jmzs0o");
        if (i24 & 6 == 0) {
            i19 = restartGroup.changed(enabled) ? 4 : 2;
            $dirty |= i19;
        } else {
            trackStrokeWidth = enabled;
        }
        if (i24 & 48 == 0) {
            i6 = restartGroup.changed(positionFractionStart) ? 32 : 16;
            $dirty |= i6;
        }
        if (i24 & 384 == 0) {
            i16 = restartGroup.changed(positionFractionEnd) ? 256 : 128;
            $dirty |= i16;
        }
        if (i24 & 3072 == 0) {
            i6 = restartGroup.changedInstance(tickFractions) ? 2048 : 1024;
            $dirty |= i6;
        } else {
            obj2 = tickFractions;
        }
        if (i24 & 24576 == 0) {
            i7 = restartGroup.changed(colors) ? 16384 : 8192;
            $dirty |= i7;
        } else {
            then = colors;
        }
        if (i24 & i93 == 0) {
            i21 = restartGroup.changed(f3) ? 131072 : 65536;
            $dirty |= i21;
        }
        int i94 = 1572864;
        if (i24 & i94 == 0) {
            i14 = restartGroup.changed(empty) ? 1048576 : 524288;
            $dirty |= i14;
        }
        if (i24 & i95 == 0) {
            i15 = restartGroup.changed(obj3) ? 8388608 : 4194304;
            $dirty |= i15;
        }
        if (i24 & i96 == 0) {
            i20 = restartGroup.changed(measurePolicy$iv) ? 67108864 : 33554432;
            $dirty |= i20;
        }
        if (i24 & i97 == 0) {
            i5 = restartGroup.changed(obj) ? 536870912 : 268435456;
            $dirty |= i5;
        }
        if ($changed1 & 6 == 0) {
            i2 = restartGroup.changed(obj5) ? 4 : 2;
            $dirty1 |= i2;
        }
        if ($dirty & i13 == 306783378 && $dirty1 & 3 == 2) {
            if ($dirty1 & 3 == 2) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-278895713, $dirty, $dirty1, "androidx.compose.material.RangeSliderImpl (Slider.kt:633)");
                    }
                    int i90 = 6;
                    int i92 = i90;
                    Modifier then3 = measurePolicy$iv.then(SliderKt.DefaultSliderConstraints);
                    i13 = 0;
                    i3 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment topStart = Alignment.Companion.getTopStart();
                    int i38 = 0;
                    androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i38);
                    i9 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                    currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, then3);
                    Function0 function0 = constructor;
                    i8 = 0;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!applier instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    restartGroup.startReusableNode();
                    if (restartGroup.getInserting()) {
                        restartGroup.createNode(function0);
                    } else {
                        factory$iv$iv$iv2 = function0;
                        restartGroup.useNode();
                    }
                    Composer constructor-impl2 = Updater.constructor-impl(restartGroup);
                    int i100 = 0;
                    Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i101 = 0;
                    Composer composer7 = constructor-impl2;
                    int i102 = 0;
                    if (!composer7.getInserting()) {
                        localMap$iv$iv = currentCompositionLocalMap;
                        composer2 = restartGroup;
                        if (!Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            composer7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                            constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer3 = composer7;
                        }
                    } else {
                        localMap$iv$iv = currentCompositionLocalMap;
                        composer2 = restartGroup;
                    }
                    Updater.set-impl(constructor-impl2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    i23 = i26 & 14;
                    Composer composer4 = composer2;
                    i17 = 0;
                    ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance iNSTANCE = BoxScopeInstance.INSTANCE;
                    i6 = i59 | 6;
                    empty2 = composer4;
                    i10 = 0;
                    ComposerKt.sourceInformationMarkerStart(empty2, -757846185, "C*641@26548L7,650@26856L301,665@27253L48,663@27167L369,676@27631L46,674@27545L359:Slider.kt#jmzs0o");
                    int i69 = 0;
                    int i103 = 0;
                    int i104 = 0;
                    int i107 = 0;
                    modifier2 = materializeModifier;
                    int i109 = i61;
                    ComposerKt.sourceInformationMarkerStart(empty2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerEnd(empty2);
                    Object this_$iv = consume;
                    int i105 = i39;
                    widthDp = this_$iv.toDp-u2uoSUM(f3);
                    int i106 = 0;
                    int i71 = 0;
                    int i72 = 0;
                    i18 = 57344;
                    i11 = 458752;
                    endContentDescription = $dirty1;
                    float $dirty12 = f14;
                    thumbPx = function02;
                    factory$iv$iv$iv = alignment;
                    contentAlignment$iv = maybeCachedBoxMeasurePolicy;
                    measurePolicy$iv = str7;
                    f3 = obj59;
                    i = $dirty;
                    float f11 = px-0680j_42;
                    $composer$iv = localMap$iv$iv;
                    localMap$iv$iv2 = i99;
                    propagateMinConstraints$iv = then3;
                    SliderKt.Track(SizeKt.fillMaxSize$default((BoxScope)iNSTANCE.align((Modifier)Modifier.Companion, Alignment.Companion.getCenterStart()), 0, 1, 0), colors, trackStrokeWidth, positionFractionStart, positionFractionEnd, tickFractions, $dirty12, f11, empty2, i44 |= i81);
                    f5 = $dirty12;
                    i4 = f11;
                    trackStrokeWidth = empty2;
                    String str2 = "CC(remember):Slider.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(trackStrokeWidth, -855706137, str2);
                    boolean changed = trackStrokeWidth.changed(f3);
                    Composer composer5 = trackStrokeWidth;
                    int i83 = 0;
                    Object rememberedValue2 = composer5.rememberedValue();
                    int i85 = 0;
                    if (!changed) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            empty2 = 0;
                            z = changed;
                            invalid$iv = new SliderKt.RangeSliderImpl.1.2.1(f3);
                            composer5.updateRememberedValue((Function1)invalid$iv);
                        } else {
                            z = changed;
                            invalid$iv = rememberedValue2;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(trackStrokeWidth);
                    int i62 = 1;
                    $dirty1 = f12;
                    BoxScopeInstance boxScopeInstance2 = boxScopeInstance4;
                    float f10 = f;
                    SliderKt.SliderThumb-PcYyNuk(boxScopeInstance2, FocusableKt.focusable(SemanticsModifierKt.semantics((Modifier)Modifier.Companion, i62, (Function1)invalid$iv), i62, empty).then(obj), f10, empty, colors, enabled, $dirty1, trackStrokeWidth, i31 | i67);
                    f7 = f10;
                    ComposerKt.sourceInformationMarkerStart(trackStrokeWidth, -855694043, str2);
                    Composer composer6 = trackStrokeWidth;
                    int i84 = 0;
                    Object rememberedValue3 = composer6.rememberedValue();
                    int i89 = 0;
                    if (!trackStrokeWidth.changed(measurePolicy$iv)) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            boxScopeInstance = boxScopeInstance2;
                            $this$RangeSliderImpl_u24lambda_u2412 = new SliderKt.RangeSliderImpl.1.3.1(measurePolicy$iv);
                            composer6.updateRememberedValue((Function1)$this$RangeSliderImpl_u24lambda_u2412);
                        } else {
                            boxScopeInstance = boxScopeInstance2;
                            $this$RangeSliderImpl_u24lambda_u2412 = rememberedValue3;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(trackStrokeWidth);
                    int i68 = 1;
                    SliderKt.SliderThumb-PcYyNuk(boxScopeInstance, FocusableKt.focusable(SemanticsModifierKt.semantics((Modifier)Modifier.Companion, i68, (Function1)$this$RangeSliderImpl_u24lambda_u2412), i68, obj3).then(obj5), Dp.constructor-impl(f9 * positionFractionEnd), obj3, colors, enabled, $dirty1, trackStrokeWidth, i35 | i57);
                    ComposerKt.sourceInformationMarkerEnd(trackStrokeWidth);
                    ComposerKt.sourceInformationMarkerEnd(composer4);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    composer2 = restartGroup;
                    i = $dirty;
                    endContentDescription = $dirty1;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new SliderKt.RangeSliderImpl.2(enabled, positionFractionStart, positionFractionEnd, tickFractions, colors, width, startInteractionSource, endInteractionSource, modifier, obj, obj5, $changed, $changed1);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void Slider(float value, Function1<? super Float, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> valueRange, int steps, Function0<Unit> onValueChangeFinished, MutableInteractionSource interactionSource, androidx.compose.material.SliderColors colors, Composer $composer, int $changed, int i12) {
        Object i11;
        Object obj4;
        int traceInProgress;
        int defaultsInvalid;
        int rangeTo;
        int steps2;
        boolean traceInProgress2;
        int i18;
        int i14;
        Composer $composer3;
        int obj3;
        int $dirty2;
        Object $dirty;
        float f;
        boolean z3;
        int i26;
        int i16;
        int onValueChangeFinished2;
        int i28;
        Object obj;
        Object obj2;
        int modifier2;
        int i3;
        int interactionSource3;
        Object interactionSource2;
        boolean empty;
        Object stepsToTickFractions;
        int enabled2;
        int i15;
        Object obj5;
        androidx.compose.material.SliderColors sliderColors;
        int changed;
        int colors-q0g_0yA;
        int i17;
        int i13;
        Object $composer4;
        Composer $composer2;
        int i;
        int i4;
        int rememberedValue;
        int i19;
        int i7;
        int i2;
        int changed2;
        int i8;
        int i21;
        int i22;
        boolean z;
        boolean z2;
        androidx.compose.material.SliderColors i10;
        long rememberUpdatedState;
        int companion;
        int i27;
        int i9;
        int i24;
        int i25;
        int i20;
        Composer composer;
        int i6;
        int i23;
        int i29;
        int i5;
        Modifier obj40;
        int obj41;
        int obj42;
        androidx.compose.runtime.internal.ComposableLambda obj43;
        Composer obj44;
        int obj45;
        int obj46;
        obj3 = onValueChange;
        final int i61 = $changed;
        final int i62 = i12;
        Composer restartGroup = $composer.startRestartGroup(-1962335196);
        ComposerKt.sourceInformation(restartGroup, "C(Slider)P(7,4,3,1,8,6,5,2)158@7608L8,163@7822L35,164@7882L59,180@8384L3006,167@7946L3444:Slider.kt#jmzs0o");
        $dirty2 = $changed;
        if (i62 & 1 != 0) {
            $dirty2 |= 6;
            f = value;
        } else {
            if (i61 & 6 == 0) {
                i26 = restartGroup.changed(value) ? 4 : 2;
                $dirty2 |= i26;
            } else {
                f = value;
            }
        }
        if (i62 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i61 & 48 == 0) {
                i16 = restartGroup.changedInstance(obj3) ? 32 : 16;
                $dirty2 |= i16;
            }
        }
        onValueChangeFinished2 = i62 & 4;
        if (onValueChangeFinished2 != 0) {
            $dirty2 |= 384;
            obj2 = modifier;
        } else {
            if (i61 & 384 == 0) {
                i3 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i3;
            } else {
                obj2 = modifier;
            }
        }
        int i51 = i62 & 8;
        if (i51 != 0) {
            $dirty2 |= 3072;
            empty = enabled;
        } else {
            if (i61 & 3072 == 0) {
                i15 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i15;
            } else {
                empty = enabled;
            }
        }
        if (i61 & 24576 == 0) {
            if (i62 & 16 == 0) {
                changed = restartGroup.changed(valueRange) ? 16384 : 8192;
            } else {
                obj5 = valueRange;
            }
            $dirty2 |= changed;
        } else {
            obj5 = valueRange;
        }
        colors-q0g_0yA = i62 & 32;
        int i73 = 196608;
        if (colors-q0g_0yA != 0) {
            $dirty2 |= i73;
            i = steps;
        } else {
            if (i73 &= i61 == 0) {
                i4 = restartGroup.changed(steps) ? 131072 : 65536;
                $dirty2 |= i4;
            } else {
                i = steps;
            }
        }
        rememberedValue = i62 & 64;
        i19 = 1572864;
        if (rememberedValue != 0) {
            $dirty2 |= i19;
            $composer4 = onValueChangeFinished;
        } else {
            if (i61 & i19 == 0) {
                i19 = restartGroup.changedInstance(onValueChangeFinished) ? 1048576 : 524288;
                $dirty2 |= i19;
            } else {
                $composer4 = onValueChangeFinished;
            }
        }
        int i31 = i62 & 128;
        int i75 = 12582912;
        if (i31 != 0) {
            $dirty2 |= i75;
            i7 = i31;
            i11 = interactionSource;
        } else {
            if (i61 & i75 == 0) {
                i7 = i31;
                i2 = restartGroup.changed(interactionSource) ? 8388608 : 4194304;
                $dirty2 |= i2;
            } else {
                i7 = i31;
                i11 = interactionSource;
            }
        }
        if (i61 & i77 == 0) {
            if (i62 & 256 == 0) {
                changed2 = restartGroup.changed(colors) ? 67108864 : 33554432;
            } else {
                obj4 = colors;
            }
            $dirty2 |= changed2;
        } else {
            obj4 = colors;
        }
        composer = restartGroup;
        if ($dirty2 & i22 == 38347922) {
            if (!composer.getSkipping()) {
                composer.startDefaults();
                int i40 = -234881025;
                i8 = -57345;
                if (i61 & 1 != 0) {
                    if (composer.getDefaultsInvalid()) {
                        if (onValueChangeFinished2 != 0) {
                            obj2 = defaultsInvalid;
                        }
                        if (i51 != 0) {
                            empty = defaultsInvalid;
                        }
                        if (i62 & 16 != 0) {
                            $dirty2 &= i8;
                            obj5 = rangeTo;
                        }
                        steps2 = colors-q0g_0yA != 0 ? 0 : i;
                        onValueChangeFinished2 = rememberedValue != 0 ? 0 : $composer4;
                        interactionSource3 = i7 != 0 ? 0 : interactionSource;
                        if (i62 & 256 != 0) {
                            i18 = 131072;
                            $composer2 = composer;
                            $dirty2 &= i5;
                            i = steps2;
                            i7 = onValueChangeFinished2;
                            z = empty;
                            i10 = colors-q0g_0yA;
                        } else {
                            $composer2 = composer;
                            i18 = 131072;
                            i10 = colors;
                            i = steps2;
                            i7 = onValueChangeFinished2;
                            z = empty;
                        }
                    } else {
                        composer.skipToGroupEnd();
                        if (i62 & 16 != 0) {
                            $dirty2 &= i8;
                        }
                        if (i62 & 256 != 0) {
                            interactionSource3 = interactionSource;
                            i10 = colors;
                            $dirty2 = steps2;
                            z = empty;
                            i7 = $composer4;
                            $composer2 = composer;
                            i18 = 131072;
                        } else {
                            interactionSource3 = interactionSource;
                            i10 = colors;
                            z = empty;
                            i7 = $composer4;
                            $composer2 = composer;
                            i18 = 131072;
                        }
                    }
                } else {
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1962335196, $dirty2, -1, "androidx.compose.material.Slider (Slider.kt:159)");
                }
                String str = "CC(remember):Slider.kt#9igjgp";
                if (interactionSource3 == 0) {
                    $composer2.startReplaceGroup(246071380);
                    ComposerKt.sourceInformation($composer2, "161@7702L39");
                    ComposerKt.sourceInformationMarkerStart($composer2, -407704210, str);
                    onValueChangeFinished2 = 0;
                    empty = $composer2;
                    colors-q0g_0yA = 0;
                    rememberedValue = empty.rememberedValue();
                    int i81 = 0;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i42 = 0;
                        empty.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        i14 = rememberedValue;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    $composer2.endReplaceGroup();
                    i21 = i14;
                } else {
                    $composer2.startReplaceGroup(-407704861);
                    $composer2.endReplaceGroup();
                    i21 = interactionSource3;
                }
                int i41 = i21;
                i17 = i >= 0 ? 1 : i28;
                if (i17 == 0) {
                } else {
                    ComposerKt.sourceInformationMarkerStart($composer2, -407698430, str);
                    if (i34 &= $dirty2 == 131072) {
                        i28 = 1;
                    }
                    Composer composer2 = $composer2;
                    int i67 = 0;
                    Object rememberedValue2 = composer2.rememberedValue();
                    int i78 = 0;
                    if (i28 == 0) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            int i56 = 0;
                            composer2.updateRememberedValue(SliderKt.stepsToTickFractions(i));
                        } else {
                            stepsToTickFractions = rememberedValue2;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    int i68 = 0;
                    int i69 = 0;
                    obj45 = obj5;
                    obj46 = i;
                    obj42 = z;
                    boolean z4 = obj42;
                    $composer4 = obj45;
                    $composer3 = composer3;
                    SliderKt.Slider.2 anon = new SliderKt.Slider.2($composer4, value, (List)stepsToTickFractions, i7, i41, z4, i10, SnapshotStateKt.rememberUpdatedState(obj3, $composer2, i63 &= 14));
                    obj44 = $composer3;
                    BoxWithConstraintsKt.BoxWithConstraints(FocusableKt.focusable(SliderKt.sliderSemantics(SizeKt.requiredSizeIn-qDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(obj2), Dp.constructor-impl(f2 *= thumbRadius), Dp.constructor-impl(f3 *= arg0$iv), 0, 0, 12, 0), f, obj42, obj3, i7, obj45, obj46), z4, i41), 0, false, (Function3)ComposableLambdaKt.rememberComposableLambda(2085116814, true, anon, $composer3, 54), obj44, 3072, 6);
                    composer = obj44;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i13 = $dirty2;
                    $dirty = obj2;
                    z3 = z4;
                    obj = $composer4;
                    sliderColors = i10;
                    modifier2 = obj3;
                    enabled2 = interactionSource3;
                    interactionSource2 = i7;
                    ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
                    if (endRestartGroup != null) {
                        traceInProgress = new SliderKt.Slider.3(value, onValueChange, $dirty, z3, obj, modifier2, interactionSource2, enabled2, sliderColors, i61, i62);
                        endRestartGroup.updateScope((Function2)traceInProgress);
                    }
                }
            } else {
                composer.skipToGroupEnd();
                i13 = $dirty2;
                $dirty = obj2;
                z3 = empty;
                obj = obj5;
                interactionSource2 = $composer4;
                modifier2 = i;
                enabled2 = interactionSource;
                sliderColors = colors;
            }
        } else {
        }
        int i80 = i41;
        int i38 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("steps should be >= 0".toString());
        throw illegalArgumentException;
    }

    private static final void SliderImpl(boolean enabled, float positionFraction, List<Float> tickFractions, androidx.compose.material.SliderColors colors, float width, MutableInteractionSource interactionSource, Modifier modifier, Composer $composer, int $changed) {
        boolean traceInProgress;
        int $dirty2;
        int skipping;
        boolean traceInProgress2;
        Integer valueOf2;
        int f;
        boolean valueOf;
        Composer composer2;
        int i13;
        int i8;
        int i2;
        Object obj;
        Object obj2;
        int i19;
        int i16;
        int i20;
        int i22;
        int propagateMinConstraints$iv;
        float measurePolicy$iv;
        Composer localMap$iv$iv2;
        int i11;
        Object obj3;
        androidx.compose.ui.Modifier.Companion $dirty;
        float f2;
        Object $this$SliderImpl_u24lambda_u248;
        androidx.compose.material.SliderColors sliderColors;
        boolean offset;
        float arg0$iv;
        int i4;
        Composer composer3;
        int i6;
        int i18;
        int i9;
        int i5;
        int i3;
        int currentCompositeKeyHash;
        int i14;
        int i17;
        int i21;
        int i10;
        int i23;
        int i12;
        Modifier localMap$iv$iv;
        float dp-u2uoSUM;
        Alignment trackStrokeWidth;
        int i7;
        int i;
        int i15;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        androidx.compose.runtime.CompositionLocalMap map;
        Modifier modifier2;
        Function0 function0;
        Composer composer;
        Modifier obj52;
        final float f4 = width;
        final Object obj5 = modifier;
        final int i69 = $changed;
        traceInProgress = 1679682785;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(SliderImpl)P(1,4,5!1,6)593@25125L712:Slider.kt#jmzs0o");
        if (i69 & 6 == 0) {
            i13 = restartGroup.changed(enabled) ? 4 : 2;
            $dirty2 |= i13;
        } else {
            valueOf = enabled;
        }
        if (i69 & 48 == 0) {
            i8 = restartGroup.changed(positionFraction) ? 32 : 16;
            $dirty2 |= i8;
        }
        if (i69 & 384 == 0) {
            i2 = restartGroup.changedInstance(tickFractions) ? 256 : 128;
            $dirty2 |= i2;
        } else {
            obj2 = tickFractions;
        }
        if (i69 & 3072 == 0) {
            i19 = restartGroup.changed(colors) ? 2048 : 1024;
            $dirty2 |= i19;
        } else {
            obj = colors;
        }
        if (i69 & 24576 == 0) {
            i16 = restartGroup.changed(f4) ? 16384 : 8192;
            $dirty2 |= i16;
        }
        if (i62 &= i69 == 0) {
            i20 = restartGroup.changed(interactionSource) ? 131072 : 65536;
            $dirty2 |= i20;
        } else {
            obj3 = interactionSource;
        }
        if (i63 &= i69 == 0) {
            i22 = restartGroup.changed(obj5) ? 1048576 : 524288;
            $dirty2 |= i22;
        }
        $dirty = $dirty2;
        if ($dirty3 &= $dirty == 599186) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material.SliderImpl (Slider.kt:592)");
                }
                Modifier then = obj5.then(SliderKt.DefaultSliderConstraints);
                i18 = 0;
                i9 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart = Alignment.Companion.getTopStart();
                int i64 = 0;
                androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i64);
                i3 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, then);
                Function0 function02 = constructor;
                i17 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                valueOf2 = 0;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i70 = 0;
                Composer composer5 = constructor-impl;
                int i74 = 0;
                if (!composer5.getInserting()) {
                    i4 = valueOf2;
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer5;
                    }
                } else {
                    i4 = valueOf2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                i21 = i26 & 14;
                Composer composer4 = restartGroup;
                i10 = 0;
                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                localMap$iv$iv2 = composer4;
                i12 = 0;
                ComposerKt.sourceInformationMarkerStart(localMap$iv$iv2, 1216522066, "C*597@25285L7,606@25530L216,616@25755L76:Slider.kt#jmzs0o");
                int i57 = 0;
                int i71 = 0;
                int i75 = 0;
                int i77 = 0;
                int i78 = i43;
                ComposerKt.sourceInformationMarkerStart(localMap$iv$iv2, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(localMap$iv$iv2);
                Object this_$iv = consume;
                int i76 = i30;
                int i72 = 0;
                int i59 = 0;
                i7 = 57344;
                i = 458752;
                i15 = i64;
                measurePolicy = maybeCachedBoxMeasurePolicy;
                modifier2 = materializeModifier;
                function0 = function03;
                map = map2;
                localMap$iv$iv = obj52;
                trackStrokeWidth = alignment;
                SliderKt.Track(SizeKt.fillMaxSize$default((Modifier)Modifier.Companion, 0, 1, 0), obj, enabled, 0, positionFraction, obj2, this_$iv.toPx-0680j_4(SliderKt.ThumbRadius), (Density)this_$iv.toPx-0680j_4(SliderKt.TrackHeight), localMap$iv$iv2, i35 |= i49);
                i11 = $dirty;
                SliderKt.SliderThumb-PcYyNuk((BoxScope)BoxScopeInstance.INSTANCE, (Modifier)Modifier.Companion, Dp.constructor-impl(f3 * positionFraction), obj3, colors, enabled, Dp.constructor-impl(arg0$iv2 *= f6), localMap$iv$iv2, skipping | f);
                ComposerKt.sourceInformationMarkerEnd(localMap$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i11 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new SliderKt.SliderImpl.2(enabled, positionFraction, tickFractions, colors, f4, interactionSource, obj5, i69);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final void SliderThumb-PcYyNuk(BoxScope $this$SliderThumb_u2dPcYyNuk, Modifier modifier, float offset, MutableInteractionSource interactionSource, androidx.compose.material.SliderColors colors, boolean enabled, float thumbSize, Composer $composer, int $changed) {
        int traceInProgress;
        boolean maybeCachedBoxMeasurePolicy;
        Composer it$iv2;
        Object background-bw27NRU;
        Composer composer;
        int i3;
        Object it$iv;
        float thumbDefaultElevation;
        int elevation;
        Object currentCompositionLocalMap;
        int $dirty;
        boolean skipping;
        boolean traceInProgress2;
        Function0 factory$iv$iv$iv;
        int indication;
        int unbox-impl;
        Object mutableStateListOf;
        float constructor-impl;
        Composer restartGroup;
        int i13;
        int i14;
        int i15;
        int i10;
        int i23;
        int i22;
        int i16;
        int i4;
        int currentCompositeKeyHash;
        float f;
        int str;
        int i17;
        Object obj2;
        int i8;
        int i19;
        int i18;
        Modifier modifier2;
        int i28;
        int i6;
        Alignment alignment;
        int i2;
        Function0 function0;
        BoxScopeInstance boxScopeInstance;
        Composer composer2;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        int i25;
        float thumbRippleRadius;
        int i27;
        Object obj;
        int companion;
        int i9;
        Composer composer3;
        Object it$iv3;
        int i20;
        int i11;
        int i12;
        Modifier modifier3;
        Composer composer4;
        Modifier hoverable$default;
        float f2;
        androidx.compose.foundation.shape.RoundedCornerShape roundedCornerShape;
        int i21;
        int i5;
        int i24;
        int i26;
        int i7;
        int i;
        float obj58;
        background-bw27NRU = $this$SliderThumb_u2dPcYyNuk;
        final Object obj4 = modifier;
        final Object obj5 = interactionSource;
        final Object obj6 = colors;
        final boolean z2 = enabled;
        final float f4 = thumbSize;
        unbox-impl = $changed;
        traceInProgress = 428907178;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(SliderThumb)P(3,4:c#ui.unit.Dp,2!,5:c#ui.unit.Dp)697@28123L1639:Slider.kt#jmzs0o");
        if (unbox-impl & 6 == 0) {
            i13 = restartGroup.changed(background-bw27NRU) ? 4 : 2;
            $dirty |= i13;
        }
        if (unbox-impl & 48 == 0) {
            i14 = restartGroup.changed(obj4) ? 32 : 16;
            $dirty |= i14;
        }
        if (unbox-impl & 384 == 0) {
            i15 = restartGroup.changed(offset) ? 256 : 128;
            $dirty |= i15;
        } else {
            f = offset;
        }
        currentCompositeKeyHash = 2048;
        if (unbox-impl & 3072 == 0) {
            i10 = restartGroup.changed(obj5) ? currentCompositeKeyHash : 1024;
            $dirty |= i10;
        }
        if (unbox-impl & 24576 == 0) {
            i23 = restartGroup.changed(obj6) ? 16384 : 8192;
            $dirty |= i23;
        }
        if (i50 &= unbox-impl == 0) {
            i22 = restartGroup.changed(z2) ? 131072 : 65536;
            $dirty |= i22;
        }
        if (i51 &= unbox-impl == 0) {
            i16 = restartGroup.changed(f4) ? 1048576 : 524288;
            $dirty |= i16;
        }
        int i52 = $dirty;
        if ($dirty2 &= i52 == 599186) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i52, -1, "androidx.compose.material.SliderThumb (Slider.kt:696)");
                }
                int i29 = i;
                Modifier align = background-bw27NRU.align(PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, f, 0, 0, 0, 14, 0), Alignment.Companion.getCenterStart());
                f = i56;
                str = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart = Alignment.Companion.getTopStart();
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
                i19 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, align);
                modifier2 = align;
                Function0 function02 = constructor;
                i18 = 0;
                alignment = topStart;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    restartGroup.useNode();
                }
                Composer constructor-impl2 = Updater.constructor-impl(restartGroup);
                int i66 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i67 = 0;
                Composer composer8 = constructor-impl2;
                int i68 = 0;
                if (!composer8.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    map = currentCompositionLocalMap;
                    if (!Intrinsics.areEqual(composer8.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer8.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer8;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    map = currentCompositionLocalMap;
                }
                Updater.set-impl(constructor-impl2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer5 = restartGroup;
                i28 = i31;
                ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i55 |= 6;
                i2 = 0;
                boxScopeInstance = iNSTANCE;
                i12 = i38;
                Composer composer6 = composer10;
                ComposerKt.sourceInformationMarkerStart(composer6, -756667644, "C701@28254L46,702@28343L658,702@28309L692,725@29357L145,732@29707L19,720@29163L593:Slider.kt#jmzs0o");
                String str3 = "CC(remember):Slider.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(composer6, 806874492, str3);
                Composer composer9 = composer6;
                int i70 = 0;
                companion = i33;
                Object rememberedValue2 = composer9.rememberedValue();
                i9 = 0;
                modifier3 = materializeModifier;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    int i48 = 0;
                    it$iv3 = rememberedValue2;
                    composer9.updateRememberedValue(SnapshotStateKt.mutableStateListOf());
                } else {
                    it$iv2 = composer9;
                    mutableStateListOf = it$iv3;
                }
                Object $this$cache$iv = mutableStateListOf;
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerStart(composer6, 806877952, str3);
                i3 = i52 & 7168 == 2048 ? 1 : 0;
                Composer composer7 = composer6;
                int i62 = 0;
                it$iv = composer7.rememberedValue();
                int i71 = 0;
                composer4 = restartGroup;
                if (i3 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        obj = it$iv;
                        i9 = i49;
                        it$iv = new SliderKt.SliderThumb.1.1.1(obj5, (SnapshotStateList)$this$cache$iv, 0);
                        composer7.updateRememberedValue((Function2)it$iv);
                    } else {
                        obj = it$iv;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(composer6);
                EffectsKt.LaunchedEffect(obj5, (Function2)it$iv, composer6, i44 &= 14);
                thumbDefaultElevation = !(Collection)$this$cache$iv.isEmpty() ? SliderKt.ThumbPressedElevation : SliderKt.ThumbDefaultElevation;
                composer3 = composer6;
                obj2 = $this$cache$iv;
                Composer interactions = composer3;
                restartGroup = 0;
                if (z2) {
                    f2 = obj58;
                } else {
                    indication = 0;
                    f2 = constructor-impl;
                }
                SpacerKt.Spacer(BackgroundKt.background-bw27NRU(ShadowKt.shadow-s4CzXII$default(HoverableKt.hoverable$default(IndicationKt.indication(SizeKt.size-VpY3zN4(obj4, f4, f4), (InteractionSource)obj5, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, SliderKt.ThumbRippleRadius, 0, i9, composer3, 54)), obj5, false, 2, restartGroup), f2, (Shape)RoundedCornerShapeKt.getCircleShape(), false, 0, obj45, 0, obj47), (Color)obj6.thumbColor(z2, interactions, i40 |= i47).getValue().unbox-impl(), restartGroup), interactions, 0);
                ComposerKt.sourceInformationMarkerEnd(interactions);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer4 = restartGroup;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer4.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new SliderKt.SliderThumb.2($this$SliderThumb_u2dPcYyNuk, obj4, offset, obj5, obj6, z2, f4, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final void Track(Modifier modifier, androidx.compose.material.SliderColors colors, boolean enabled, float positionFractionStart, float positionFractionEnd, List<Float> tickFractions, float thumbPx, float trackStrokeWidth, Composer $composer, int $changed) {
        boolean traceInProgress2;
        int i13;
        int i;
        int i2;
        int empty;
        androidx.compose.material.SliderKt.Track.1.1 inactiveTrackColor;
        int $dirty;
        Object obj;
        int i4;
        int i3;
        int i6;
        int i10;
        float f2;
        float activeTickColor;
        boolean traceInProgress;
        float f;
        State trackColor;
        int i7;
        int i5;
        float f4;
        State tickColor;
        int i8;
        float f3;
        Composer composer;
        int i12;
        int i9;
        int i15;
        int i14;
        int companion;
        int i11;
        int obj28;
        final Object obj2 = modifier;
        empty = colors;
        final boolean z = enabled;
        obj = tickFractions;
        traceInProgress2 = $changed;
        inactiveTrackColor = 1833126050;
        final Composer restartGroup = $composer.startRestartGroup(inactiveTrackColor);
        ComposerKt.sourceInformation(restartGroup, "C(Track)P(2!2,4!1,6)748@30055L35,749@30125L34,750@30195L34,751@30263L33,752@30318L1535,752@30301L1552:Slider.kt#jmzs0o");
        if (traceInProgress2 & 6 == 0) {
            i4 = restartGroup.changed(obj2) ? 4 : 2;
            $dirty |= i4;
        }
        if (traceInProgress2 & 48 == 0) {
            i3 = restartGroup.changed(empty) ? 32 : 16;
            $dirty |= i3;
        }
        if (traceInProgress2 & 384 == 0) {
            i6 = restartGroup.changed(z) ? 256 : 128;
            $dirty |= i6;
        }
        if (traceInProgress2 & 3072 == 0) {
            i10 = restartGroup.changed(positionFractionStart) ? 2048 : 1024;
            $dirty |= i10;
        } else {
            f = positionFractionStart;
        }
        if (traceInProgress2 & 24576 == 0) {
            i7 = restartGroup.changed(positionFractionEnd) ? 16384 : 8192;
            $dirty |= i7;
        } else {
            f2 = positionFractionEnd;
        }
        if (i46 &= traceInProgress2 == 0) {
            i5 = restartGroup.changedInstance(obj) ? 131072 : 65536;
            $dirty |= i5;
        }
        if (i47 &= traceInProgress2 == 0) {
            i8 = restartGroup.changed(thumbPx) ? 1048576 : 524288;
            $dirty |= i8;
        } else {
            f4 = thumbPx;
        }
        if (i52 &= traceInProgress2 == 0) {
            i12 = restartGroup.changed(trackStrokeWidth) ? 8388608 : 4194304;
            $dirty |= i12;
        } else {
            f3 = trackStrokeWidth;
        }
        if ($dirty & i9 == 4793490) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(inactiveTrackColor, $dirty, -1, "androidx.compose.material.Track (Slider.kt:747)");
                }
                int i38 = 0;
                State trackColor2 = empty.trackColor(z, i38, restartGroup, i32 |= i37);
                int i56 = 1;
                trackColor = empty.trackColor(z, i56, restartGroup, i44 |= i55);
                tickColor = empty.tickColor(z, i38, restartGroup, i68 | i50);
                activeTickColor = empty.tickColor(z, i56, restartGroup, i71 | i40);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1731271772, "CC(remember):Slider.kt#9igjgp");
                i13 = i16 &= $dirty == 1048576 ? 1 : 0;
                i = i59 &= $dirty == 8388608 ? 1 : 0;
                i2 = i61 &= $dirty == 16384 ? 1 : 0;
                companion = $dirty & 7168 == 2048 ? 1 : 0;
                composer = restartGroup;
                i9 = 0;
                Object rememberedValue = composer.rememberedValue();
                i15 = 0;
                if (i27 |= changed10 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        i14 = $dirty;
                        inactiveTrackColor = new SliderKt.Track.1.1(f4, trackColor2, f3, f2, f, trackColor, tickFractions, tickColor, activeTickColor);
                        composer.updateRememberedValue((Function1)inactiveTrackColor);
                    } else {
                        obj = trackColor2;
                        i14 = $dirty;
                        f3 = activeTickColor;
                        inactiveTrackColor = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(obj2, (Function1)inactiveTrackColor, restartGroup, i14 & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i14 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SliderKt.Track.2(obj2, colors, z, positionFractionStart, positionFractionEnd, tickFractions, thumbPx, trackStrokeWidth, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void access$CorrectValueSideEffect(Function1 scaleToOffset, ClosedFloatingPointRange valueRange, ClosedFloatingPointRange trackRange, MutableState valueState, float value, Composer $composer, int $changed) {
        SliderKt.CorrectValueSideEffect(scaleToOffset, valueRange, trackRange, valueState, value, $composer, $changed);
    }

    public static final void access$RangeSliderImpl(boolean enabled, float positionFractionStart, float positionFractionEnd, List tickFractions, androidx.compose.material.SliderColors colors, float width, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, Modifier modifier, Modifier startThumbSemantics, Modifier endThumbSemantics, Composer $composer, int $changed, int $changed1) {
        SliderKt.RangeSliderImpl(enabled, positionFractionStart, positionFractionEnd, tickFractions, colors, width, startInteractionSource, endInteractionSource, modifier, startThumbSemantics, endThumbSemantics, $composer, $changed, $changed1);
    }

    public static final void access$SliderImpl(boolean enabled, float positionFraction, List tickFractions, androidx.compose.material.SliderColors colors, float width, MutableInteractionSource interactionSource, Modifier modifier, Composer $composer, int $changed) {
        SliderKt.SliderImpl(enabled, positionFraction, tickFractions, colors, width, interactionSource, modifier, $composer, $changed);
    }

    public static final void access$SliderThumb-PcYyNuk(BoxScope $receiver, Modifier modifier, float offset, MutableInteractionSource interactionSource, androidx.compose.material.SliderColors colors, boolean enabled, float thumbSize, Composer $composer, int $changed) {
        SliderKt.SliderThumb-PcYyNuk($receiver, modifier, offset, interactionSource, colors, enabled, thumbSize, $composer, $changed);
    }

    public static final void access$Track(Modifier modifier, androidx.compose.material.SliderColors colors, boolean enabled, float positionFractionStart, float positionFractionEnd, List tickFractions, float thumbPx, float trackStrokeWidth, Composer $composer, int $changed) {
        SliderKt.Track(modifier, colors, enabled, positionFractionStart, positionFractionEnd, tickFractions, thumbPx, trackStrokeWidth, $composer, $changed);
    }

    public static final Object access$animateToTarget(DraggableState draggableState, float current, float target, float velocity, Continuation $completion) {
        return SliderKt.animateToTarget(draggableState, current, target, velocity, $completion);
    }

    public static final Object access$awaitSlop-8vUncbI(AwaitPointerEventScope $receiver, long id, int type, Continuation $completion) {
        return SliderKt.awaitSlop-8vUncbI($receiver, id, type, $completion);
    }

    public static final float access$calcFraction(float a, float b, float pos) {
        return SliderKt.calcFraction(a, b, pos);
    }

    public static final TweenSpec access$getSliderToTickAnimation$p() {
        return SliderKt.SliderToTickAnimation;
    }

    public static final Modifier access$rangeSliderPressDragModifier(Modifier $receiver, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, State rawOffsetStart, State rawOffsetEnd, boolean enabled, boolean isRtl, float maxPx, ClosedFloatingPointRange valueRange, State gestureEndAction, State onDrag) {
        return SliderKt.rangeSliderPressDragModifier($receiver, startInteractionSource, endInteractionSource, rawOffsetStart, rawOffsetEnd, enabled, isRtl, maxPx, valueRange, gestureEndAction, onDrag);
    }

    public static final float access$scale(float a1, float b1, float x1, float a2, float b2) {
        return SliderKt.scale(a1, b1, x1, a2, b2);
    }

    public static final ClosedFloatingPointRange access$scale(float a1, float b1, ClosedFloatingPointRange x, float a2, float b2) {
        return SliderKt.scale(a1, b1, x, a2, b2);
    }

    public static final Modifier access$sliderSemantics(Modifier $receiver, float value, boolean enabled, Function1 onValueChange, Function0 onValueChangeFinished, ClosedFloatingPointRange valueRange, int steps) {
        return SliderKt.sliderSemantics($receiver, value, enabled, onValueChange, onValueChangeFinished, valueRange, steps);
    }

    public static final Modifier access$sliderTapModifier(Modifier $receiver, DraggableState draggableState, MutableInteractionSource interactionSource, float maxPx, boolean isRtl, State rawOffset, State gestureEndAction, MutableState pressOffset, boolean enabled) {
        return SliderKt.sliderTapModifier($receiver, draggableState, interactionSource, maxPx, isRtl, rawOffset, gestureEndAction, pressOffset, enabled);
    }

    public static final float access$snapValueToTick(float current, List tickFractions, float minPx, float maxPx) {
        return SliderKt.snapValueToTick(current, tickFractions, minPx, maxPx);
    }

    private static final Object animateToTarget(DraggableState draggableState, float current, float target, float velocity, Continuation<? super Unit> $completion) {
        SliderKt.animateToTarget.2 anon = new SliderKt.animateToTarget.2(current, target, velocity, 0);
        Object obj8 = DraggableState.drag$default(draggableState, 0, (Function2)anon, $completion, 1, 0);
        if (obj8 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return obj8;
        }
        return Unit.INSTANCE;
    }

    private static final Object awaitSlop-8vUncbI(AwaitPointerEventScope awaitPointerEventScope, long l2, int i3, Continuation<? super Pair<PointerInputChange, Float>> continuation4) {
        boolean anon;
        int i4;
        int label;
        int i;
        int i2;
        androidx.compose.material.SliderKt.awaitSlop.postPointerSlop.1 anon2;
        Object obj7;
        Object obj8;
        int obj9;
        Object obj11;
        anon = obj11;
        i = Integer.MIN_VALUE;
        if (obj11 instanceof SliderKt.awaitSlop.1 && label2 &= i != 0) {
            anon = obj11;
            i = Integer.MIN_VALUE;
            if (label2 &= i != 0) {
                anon.label = obj11 -= i;
            } else {
                anon = new SliderKt.awaitSlop.1(obj11);
            }
        } else {
        }
        final androidx.compose.material.SliderKt.awaitSlop.1 anon3 = anon;
        obj11 = anon3.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                obj7 = new Ref.FloatRef();
                obj8 = new SliderKt.awaitSlop.postPointerSlop.1(obj7);
                anon3.L$0 = obj7;
                anon3.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                obj7 = anon3.L$0;
                ResultKt.throwOnFailure(obj11);
                obj8 = obj11;
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        if ((PointerInputChange)obj8 != null) {
            obj9 = TuplesKt.to((PointerInputChange)obj8, Boxing.boxFloat(obj7.element));
        } else {
            obj9 = 0;
        }
        return obj9;
    }

    private static final float calcFraction(float a, float b, float pos) {
        int i;
        int i2;
        int $this$fastCoerceAtLeast$iv$iv;
        i = Float.compare(i3, i2) == 0 ? 1 : 0;
        if (i != 0) {
        } else {
            i2 = i / i5;
        }
        int i4 = 0;
        final int i6 = 1065353216;
        final int i7 = 0;
        int i8 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i4) < 0) {
            $this$fastCoerceAtLeast$iv$iv = i4;
        }
        int i9 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i6) > 0) {
            $this$fastCoerceAtLeast$iv$iv = i6;
        }
        return $this$fastCoerceAtLeast$iv$iv;
    }

    public static final float getThumbRadius() {
        return SliderKt.ThumbRadius;
    }

    public static final float getTrackHeight() {
        return SliderKt.TrackHeight;
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier $this$rangeSliderPressDragModifier, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, State<Float> rawOffsetStart, State<Float> rawOffsetEnd, boolean enabled, boolean isRtl, float maxPx, ClosedFloatingPointRange<Float> valueRange, State<? extends Function1<? super Boolean, Unit>> gestureEndAction, State<? extends Function2<? super Boolean, ? super Float, Unit>> onDrag) {
        Modifier pointerInput;
        Boolean valueOf;
        Object obj;
        androidx.compose.material.SliderKt.rangeSliderPressDragModifier.1 anon;
        MutableInteractionSource mutableInteractionSource;
        MutableInteractionSource mutableInteractionSource2;
        State state3;
        State state4;
        State state;
        boolean z;
        float f;
        State state2;
        int i;
        if (enabled) {
            anon = new SliderKt.rangeSliderPressDragModifier.1(startInteractionSource, endInteractionSource, rawOffsetStart, rawOffsetEnd, onDrag, isRtl, maxPx, gestureEndAction, 0);
            pointerInput = SuspendingPointerInputFilterKt.pointerInput($this$rangeSliderPressDragModifier, /* result */, (Function2)anon);
        } else {
            obj = valueRange;
            pointerInput = $this$rangeSliderPressDragModifier;
        }
        return pointerInput;
    }

    private static final float scale(float a1, float b1, float x1, float a2, float b2) {
        return MathHelpersKt.lerp(a2, b2, SliderKt.calcFraction(a1, b1, x1));
    }

    private static final ClosedFloatingPointRange<Float> scale(float a1, float b1, ClosedFloatingPointRange<Float> x, float a2, float b2) {
        return RangesKt.rangeTo(SliderKt.scale(a1, b1, (Number)x.getStart().floatValue(), a2, b2), SliderKt.scale(a1, b1, (Number)x.getEndInclusive().floatValue(), a2, b2));
    }

    private static final Modifier sliderSemantics(Modifier $this$sliderSemantics, float value, boolean enabled, Function1<? super Float, Unit> onValueChange, Function0<Unit> onValueChangeFinished, ClosedFloatingPointRange<Float> valueRange, int steps) {
        final ClosedFloatingPointRange num = valueRange;
        final int i = steps;
        SliderKt.sliderSemantics.1 anon = new SliderKt.sliderSemantics.1(enabled, num, i, RangesKt.coerceIn(value, (Number)valueRange.getStart().floatValue(), (Number)valueRange.getEndInclusive().floatValue()), onValueChange, onValueChangeFinished);
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default($this$sliderSemantics, false, (Function1)anon, 1, 0), value, num, i);
    }

    static Modifier sliderSemantics$default(Modifier modifier, float f2, boolean z3, Function1 function14, Function0 function05, ClosedFloatingPointRange closedFloatingPointRange6, int i7, int i8, Object object9) {
        int i;
        ClosedFloatingPointRange num;
        int i2;
        int obj11;
        ClosedFloatingPointRange obj12;
        int obj13;
        i = i8 & 8 != 0 ? obj11 : function05;
        if (i8 & 16 != 0) {
            num = obj12;
        } else {
            num = closedFloatingPointRange6;
        }
        i2 = i8 & 32 != 0 ? obj13 : i7;
        return SliderKt.sliderSemantics(modifier, f2, z3, function14, i, num, i2);
    }

    private static final Modifier sliderTapModifier(Modifier $this$sliderTapModifier, DraggableState draggableState, MutableInteractionSource interactionSource, float maxPx, boolean isRtl, State<Float> rawOffset, State<? extends Function1<? super Float, Unit>> gestureEndAction, MutableState<Float> pressOffset, boolean enabled) {
        Function1 noInspectorInfo;
        DraggableState draggableState2;
        MutableInteractionSource mutableInteractionSource;
        float f;
        boolean z;
        State state2;
        State state;
        MutableState mutableState;
        boolean z2;
        int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new SliderKt.sliderTapModifier$$inlined.debugInspectorInfo.1(draggableState, interactionSource, maxPx, isRtl, rawOffset, gestureEndAction, pressOffset, enabled);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        SliderKt.sliderTapModifier.2 anon = new SliderKt.sliderTapModifier.2(enabled, draggableState, interactionSource, maxPx, isRtl, pressOffset, rawOffset, gestureEndAction);
        return ComposedModifierKt.composed($this$sliderTapModifier, noInspectorInfo, (Function3)anon);
    }

    private static final float snapValueToTick(float current, List<Float> tickFractions, float minPx, float maxPx) {
        int $this$snapValueToTick_u24lambda_u2418;
        int i2;
        Object minElem$iv;
        int i$iv;
        int lastIndex;
        float minValue$iv;
        Object obj;
        int compare;
        int i;
        float f;
        List list = tickFractions;
        i2 = 0;
        if (list.isEmpty()) {
            minElem$iv = 0;
        } else {
            int i4 = 0;
            minValue$iv = Math.abs(lerp -= current);
            lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
            }
        }
        if ((Float)minElem$iv != null) {
            i2 = 0;
            $this$snapValueToTick_u24lambda_u2418 = MathHelpersKt.lerp(minPx, maxPx, (Number)(Float)minElem$iv.floatValue());
        } else {
            $this$snapValueToTick_u24lambda_u2418 = current;
        }
        return $this$snapValueToTick_u24lambda_u2418;
    }

    private static final List<Float> stepsToTickFractions(int steps) {
        Object emptyList;
        ArrayList arrayList;
        int i2;
        Float valueOf;
        int i;
        int i3;
        float f;
        if (steps == 0) {
            emptyList = CollectionsKt.emptyList();
        } else {
            int i4 = steps + 2;
            arrayList = new ArrayList(i4);
            i2 = 0;
            while (i2 < i4) {
                i = 0;
                arrayList.add(Float.valueOf(f2 /= f));
                i2++;
            }
            emptyList = arrayList;
        }
        return emptyList;
    }
}
