package androidx.compose.material3;

import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.ProgressSemanticsKt;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.internal.AccessibilityUtilKt;
import androidx.compose.material3.internal.DragGestureDetectorCopyKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.SliderTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.R.string;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.FloatRef;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u001d\n\u0002\u0010\u0014\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u001a\u0098\u0001\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020 2\u0019\u0008\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\u0008$2\u0019\u0008\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\u0008$2\u0019\u0008\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\u0008$H\u0007¢\u0006\u0002\u0010'\u001aä\u0001\u0010\u0016\u001a\u00020\u00172\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u00020*0)2\u0018\u0010+\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020*0)\u0012\u0004\u0012\u00020\u00170#2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00102\u000e\u0008\u0002\u0010,\u001a\u0008\u0012\u0004\u0012\u00020*0)2\u0010\u0008\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010.2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010!\u001a\u00020 2\u0019\u0008\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\u0008$2\u0019\u0008\u0002\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\u0008$2\u0019\u0008\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\u0008$2\u0008\u0008\u0003\u0010/\u001a\u000200H\u0007¢\u0006\u0002\u00101\u001a\u007f\u0010\u0016\u001a\u00020\u00172\u000c\u0010(\u001a\u0008\u0012\u0004\u0012\u00020*0)2\u0018\u0010+\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020*0)\u0012\u0004\u0012\u00020\u00170#2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00102\u000e\u0008\u0002\u0010,\u001a\u0008\u0012\u0004\u0012\u00020*0)2\u0008\u0008\u0003\u0010/\u001a\u0002002\u0010\u0008\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010.2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001eH\u0007¢\u0006\u0002\u00102\u001a\u0080\u0001\u00103\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0017\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\u0008$2\u0017\u0010%\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\u0008$2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\u0008$H\u0003¢\u0006\u0002\u00104\u001as\u00105\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u0002062\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00102\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u00107\u001a\u00020 2\u0019\u0008\u0002\u00108\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\u0008$2\u0019\u0008\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\u0008$H\u0007¢\u0006\u0002\u00109\u001a³\u0001\u00105\u001a\u00020\u00172\u0006\u0010(\u001a\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00170#2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00102\u0010\u0008\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010.2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u00107\u001a\u00020 2\u0008\u0008\u0003\u0010/\u001a\u0002002\u0019\u0008\u0002\u00108\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\u0008$2\u0019\u0008\u0002\u0010&\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\u0008$2\u000e\u0008\u0002\u0010,\u001a\u0008\u0012\u0004\u0012\u00020*0)H\u0007¢\u0006\u0002\u0010:\u001a}\u00105\u001a\u00020\u00172\u0006\u0010(\u001a\u00020*2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00170#2\u0008\u0008\u0002\u0010\u001a\u001a\u00020\u001b2\u0008\u0008\u0002\u0010\u001c\u001a\u00020\u00102\u000e\u0008\u0002\u0010,\u001a\u0008\u0012\u0004\u0012\u00020*0)2\u0008\u0008\u0003\u0010/\u001a\u0002002\u0010\u0008\u0002\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010.2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u001e2\u0008\u0008\u0002\u00107\u001a\u00020 H\u0007¢\u0006\u0002\u0010;\u001a_\u0010<\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u0002062\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u00107\u001a\u00020 2\u0017\u00108\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\u0008$2\u0017\u0010&\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00170#¢\u0006\u0002\u0008$H\u0003¢\u0006\u0002\u0010=\u001a\u001d\u0010>\u001a\u00020\u00112\u0006\u0010?\u001a\u00020*2\u0006\u0010@\u001a\u00020*H\u0001¢\u0006\u0002\u0010A\u001a\u001b\u0010>\u001a\u00020\u00112\u000c\u0010B\u001a\u0008\u0012\u0004\u0012\u00020*0)H\u0001¢\u0006\u0002\u0010C\u001a \u0010D\u001a\u00020*2\u0006\u0010E\u001a\u00020*2\u0006\u0010F\u001a\u00020*2\u0006\u0010G\u001a\u00020*H\u0002\u001a:\u0010H\u001a\u00020\u00112\u0006\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020*2\u0006\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020*H\u0002ø\u0001\u0000¢\u0006\u0004\u0008N\u0010O\u001a0\u0010H\u001a\u00020*2\u0006\u0010I\u001a\u00020*2\u0006\u0010J\u001a\u00020*2\u0006\u0010P\u001a\u00020*2\u0006\u0010L\u001a\u00020*2\u0006\u0010M\u001a\u00020*H\u0002\u001a(\u0010Q\u001a\u00020*2\u0006\u0010R\u001a\u00020*2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020*2\u0006\u0010V\u001a\u00020*H\u0002\u001a\u0010\u0010W\u001a\u00020T2\u0006\u0010/\u001a\u000200H\u0002\u001a5\u0010X\u001a\u0010\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020*\u0018\u00010Y*\u00020[2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020_H\u0082@ø\u0001\u0000¢\u0006\u0004\u0008`\u0010a\u001a\u001c\u0010b\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0010H\u0002\u001a,\u0010c\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u0010H\u0003\u001a\u001c\u0010d\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0010H\u0002\u001a\u001c\u0010e\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u0018\u001a\u0002062\u0006\u0010\u001c\u001a\u00020\u0010H\u0002\u001a$\u0010f\u001a\u00020\u001b*\u00020\u001b2\u0006\u0010\u0018\u001a\u0002062\u0006\u00107\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u0010H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\"\u0010\u0010\u0008\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\t\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\n\u0010\u000b\"\u0016\u0010\u000c\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\r\u0010\u000b\"\u0010\u0010\u000e\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u001e\u0010\u000f\u001a\u00020\u0010*\u00020\u00118@X\u0081\u0004¢\u0006\u000c\u0012\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0014\u0010\u0015\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006g", d2 = {"SliderRangeTolerance", "", "ThumbHeight", "Landroidx/compose/ui/unit/Dp;", "F", "ThumbSize", "Landroidx/compose/ui/unit/DpSize;", "J", "ThumbTrackGapSize", "ThumbWidth", "getThumbWidth", "()F", "TrackHeight", "getTrackHeight", "TrackInsideCornerSize", "isSpecified", "", "Landroidx/compose/material3/SliderRange;", "isSpecified-If1S1O4$annotations", "(J)V", "isSpecified-If1S1O4", "(J)Z", "RangeSlider", "", "state", "Landroidx/compose/material3/RangeSliderState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/SliderColors;", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "startThumb", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "endThumb", "track", "(Landroidx/compose/material3/RangeSliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "value", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "onValueChange", "valueRange", "onValueChangeFinished", "Lkotlin/Function0;", "steps", "", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ILandroidx/compose/runtime/Composer;III)V", "(Lkotlin/ranges/ClosedFloatingPointRange;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/runtime/Composer;II)V", "RangeSliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/RangeSliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "Slider", "Landroidx/compose/material3/SliderState;", "interactionSource", "thumb", "(Landroidx/compose/material3/SliderState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;ILkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/ranges/ClosedFloatingPointRange;Landroidx/compose/runtime/Composer;III)V", "(FLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLkotlin/ranges/ClosedFloatingPointRange;ILkotlin/jvm/functions/Function0;Landroidx/compose/material3/SliderColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "SliderImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/SliderState;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "SliderRange", "start", "endInclusive", "(FF)J", "range", "(Lkotlin/ranges/ClosedFloatingPointRange;)J", "calcFraction", "a", "b", "pos", "scale", "a1", "b1", "x", "a2", "b2", "scale-ziovWd0", "(FFJFF)J", "x1", "snapValueToTick", "current", "tickFractions", "", "minPx", "maxPx", "stepsToTickFractions", "awaitSlop", "Lkotlin/Pair;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "id", "Landroidx/compose/ui/input/pointer/PointerId;", "type", "Landroidx/compose/ui/input/pointer/PointerType;", "awaitSlop-8vUncbI", "(Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;JILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rangeSliderEndThumbSemantics", "rangeSliderPressDragModifier", "rangeSliderStartThumbSemantics", "sliderSemantics", "sliderTapModifier", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SliderKt {

    private static final double SliderRangeTolerance = 0.0001d;
    private static final float ThumbHeight;
    private static final long ThumbSize;
    private static final float ThumbTrackGapSize;
    private static final float ThumbWidth;
    private static final float TrackHeight;
    private static final float TrackInsideCornerSize;
    static {
        SliderKt.TrackHeight = SliderTokens.INSTANCE.getInactiveTrackHeight-D9Ej5fM();
        SliderKt.ThumbWidth = SliderTokens.INSTANCE.getHandleWidth-D9Ej5fM();
        SliderKt.ThumbHeight = SliderTokens.INSTANCE.getHandleHeight-D9Ej5fM();
        SliderKt.ThumbSize = DpKt.DpSize-YgX7TsA(SliderKt.ThumbWidth, SliderKt.ThumbHeight);
        SliderKt.ThumbTrackGapSize = SliderTokens.INSTANCE.getActiveHandleLeadingSpace-D9Ej5fM();
        int i2 = 0;
        SliderKt.TrackInsideCornerSize = Dp.constructor-impl((float)i);
    }

    public static final void RangeSlider(androidx.compose.material3.RangeSliderState state, Modifier modifier, boolean enabled, androidx.compose.material3.SliderColors colors, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, Function3<? super androidx.compose.material3.RangeSliderState, ? super Composer, ? super Integer, Unit> startThumb, Function3<? super androidx.compose.material3.RangeSliderState, ? super Composer, ? super Integer, Unit> endThumb, Function3<? super androidx.compose.material3.RangeSliderState, ? super Composer, ? super Integer, Unit> track, Composer $composer, int $changed, int i12) {
        Object obj9;
        Object obj2;
        Object obj3;
        boolean traceInProgress2;
        int i17;
        int defaultsInvalid;
        int colors2;
        Object colors4;
        Object restartGroup;
        int $dirty2;
        Object $dirty;
        androidx.compose.runtime.internal.ComposableLambda rememberComposableLambda;
        int i18;
        boolean z;
        androidx.compose.runtime.internal.ComposableLambda endThumb2;
        boolean traceInProgress;
        int i14;
        Object str;
        Object obj12;
        int i5;
        Object obj7;
        int i4;
        int rememberedValue;
        boolean z2;
        Object obj;
        int i6;
        Object obj6;
        Object colors3;
        int changed;
        Object obj11;
        int anon;
        Object obj8;
        Object obj4;
        int i2;
        int modifier2;
        Object obj5;
        int $i$a$CacheSliderKt$RangeSlider$13;
        Object obj10;
        Object endInteractionSource2;
        int i7;
        int i16;
        int i8;
        int i11;
        int i;
        int i15;
        int i9;
        int i3;
        int i13;
        Composer composer;
        int i10;
        Composer.Companion companion;
        int obj23;
        final int i60 = $changed;
        final int i61 = i12;
        restartGroup = $composer.startRestartGroup(511405654);
        ComposerKt.sourceInformation(restartGroup, "C(RangeSlider)P(7,4,1!1,5!1,6)616@28157L8,617@28222L39,618@28316L39,619@28414L162,626@28633L160,633@28847L175,643@29089L295:Slider.kt#uh7d8r");
        $dirty2 = $changed;
        if (i61 & 1 != 0) {
            $dirty2 |= 6;
            obj10 = state;
        } else {
            if (i60 & 6 == 0) {
                i18 = restartGroup.changedInstance(state) ? 4 : 2;
                $dirty2 |= i18;
            } else {
                obj10 = state;
            }
        }
        int i36 = i61 & 2;
        if (i36 != 0) {
            $dirty2 |= 48;
            str = modifier;
        } else {
            if (i60 & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i5;
            } else {
                str = modifier;
            }
        }
        rememberedValue = i61 & 4;
        if (rememberedValue != 0) {
            $dirty2 |= 384;
            z2 = enabled;
        } else {
            if (i60 & 384 == 0) {
                i6 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty2 |= i6;
            } else {
                z2 = enabled;
            }
        }
        if (i60 & 3072 == 0) {
            if (i61 & 8 == 0) {
                changed = restartGroup.changed(colors) ? 2048 : 1024;
            } else {
                obj6 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj6 = colors;
        }
        anon = i61 & 16;
        if (anon != 0) {
            $dirty2 |= 24576;
            obj8 = startInteractionSource;
        } else {
            if (i60 & 24576 == 0) {
                i2 = restartGroup.changed(startInteractionSource) ? 16384 : 8192;
                $dirty2 |= i2;
            } else {
                obj8 = startInteractionSource;
            }
        }
        $i$a$CacheSliderKt$RangeSlider$13 = i61 & 32;
        int i64 = 196608;
        if ($i$a$CacheSliderKt$RangeSlider$13 != 0) {
            $dirty2 |= i64;
            endInteractionSource2 = endInteractionSource;
        } else {
            if (i64 &= i60 == 0) {
                i7 = restartGroup.changed(endInteractionSource) ? 131072 : 65536;
                $dirty2 |= i7;
            } else {
                endInteractionSource2 = endInteractionSource;
            }
        }
        i16 = i61 & 64;
        i8 = 1572864;
        if (i16 != 0) {
            $dirty2 |= i8;
            obj9 = startThumb;
        } else {
            if (i60 & i8 == 0) {
                i11 = restartGroup.changedInstance(startThumb) ? 1048576 : 524288;
                $dirty2 |= i11;
            } else {
                obj9 = startThumb;
            }
        }
        int i20 = i61 & 128;
        int i66 = 12582912;
        if (i20 != 0) {
            $dirty2 |= i66;
            i = i20;
            obj2 = endThumb;
        } else {
            if (i60 & i66 == 0) {
                i = i20;
                i15 = restartGroup.changedInstance(endThumb) ? 8388608 : 4194304;
                $dirty2 |= i15;
            } else {
                i = i20;
                obj2 = endThumb;
            }
        }
        int i21 = i61 & 256;
        int i68 = 100663296;
        if (i21 != 0) {
            $dirty2 |= i68;
            i9 = i21;
            obj3 = track;
        } else {
            if (i60 & i68 == 0) {
                i9 = i21;
                i3 = restartGroup.changedInstance(track) ? 67108864 : 33554432;
                $dirty2 |= i3;
            } else {
                i9 = i21;
                obj3 = track;
            }
        }
        if ($dirty2 & i13 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i60 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i36 != 0) {
                            str = defaultsInvalid;
                        }
                        if (rememberedValue != 0) {
                            z2 = defaultsInvalid;
                        }
                        if (i61 & 8 != 0) {
                            $dirty2 &= -7169;
                            obj6 = colors2;
                        }
                        colors4 = "CC(remember):Slider.kt#9igjgp";
                        if (anon != 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 1661349858, colors4);
                            rememberedValue = 0;
                            anon = restartGroup;
                            i13 = 0;
                            endThumb2 = anon.rememberedValue();
                            i10 = 0;
                            obj23 = $dirty2;
                            if (endThumb2 == Composer.Companion.getEmpty()) {
                                int i35 = 0;
                                anon.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                            } else {
                                $dirty2 = endThumb2;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            obj8 = $dirty2;
                        } else {
                            obj23 = $dirty2;
                        }
                        if ($i$a$CacheSliderKt$RangeSlider$13 != 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, 1661352866, colors4);
                            int i31 = 0;
                            $dirty2 = restartGroup;
                            endThumb2 = 0;
                            rememberedValue = $dirty2.rememberedValue();
                            anon = 0;
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                int i63 = 0;
                                $dirty2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                            } else {
                                $i$a$CacheSliderKt$RangeSlider$13 = rememberedValue;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            endInteractionSource2 = colors4;
                        }
                        int endInteractionSource3 = 54;
                        if (i16 != 0) {
                            SliderKt.RangeSlider.14 anon2 = new SliderKt.RangeSlider.14(obj8, obj6, z2);
                            rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1884205643, true, anon2, restartGroup, endInteractionSource3);
                        } else {
                            i4 = 1;
                            rememberComposableLambda = startThumb;
                        }
                        if (i != 0) {
                            SliderKt.RangeSlider.15 anon3 = new SliderKt.RangeSlider.15(endInteractionSource2, obj6, z2);
                            endThumb2 = ComposableLambdaKt.rememberComposableLambda(1016457138, i4, anon3, restartGroup, endInteractionSource3);
                        } else {
                            endThumb2 = endThumb;
                        }
                        if (i9 != 0) {
                            anon = new SliderKt.RangeSlider.16(z2, obj6);
                            i13 = rememberComposableLambda2;
                            i = rememberComposableLambda;
                            i9 = endThumb2;
                            obj5 = str;
                            i16 = obj8;
                            i8 = endInteractionSource2;
                            i17 = 511405654;
                            $dirty2 = obj23;
                            endInteractionSource2 = z2;
                        } else {
                            i13 = track;
                            i = rememberComposableLambda;
                            i9 = endThumb2;
                            obj5 = str;
                            i16 = obj8;
                            i8 = endInteractionSource2;
                            i17 = 511405654;
                            $dirty2 = obj23;
                            endInteractionSource2 = z2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i61 & 8 != 0) {
                            i = startThumb;
                            i9 = endThumb;
                            i13 = track;
                            $dirty2 = i33;
                            obj5 = str;
                            i16 = obj8;
                            i8 = endInteractionSource2;
                            i17 = 511405654;
                            i4 = 1;
                            endInteractionSource2 = z2;
                        } else {
                            i = startThumb;
                            i9 = endThumb;
                            i13 = track;
                            obj5 = str;
                            i16 = obj8;
                            i8 = endInteractionSource2;
                            i17 = 511405654;
                            i4 = 1;
                            endInteractionSource2 = z2;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i17, $dirty2, -1, "androidx.compose.material3.RangeSlider (Slider.kt:640)");
                }
                i14 = obj10.getSteps() >= 0 ? i4 : 0;
                if (i14 == 0) {
                } else {
                    SliderKt.RangeSliderImpl(obj5, obj10, endInteractionSource2, i16, i8, i, i9, i13, restartGroup, i30 | i49);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = $dirty2;
                    $dirty = obj14;
                    obj12 = obj6;
                    z = endInteractionSource2;
                    obj7 = i16;
                    obj = i8;
                    colors3 = i;
                    obj11 = i9;
                    obj4 = i13;
                    ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
                    if (endRestartGroup != null) {
                        traceInProgress2 = new SliderKt.RangeSlider.18(state, $dirty, z, obj12, obj7, obj, colors3, obj11, obj4, i60, i61);
                        endRestartGroup.updateScope((Function2)traceInProgress2);
                    }
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj11 = endThumb;
                composer = restartGroup;
                modifier2 = $dirty2;
                $dirty = str;
                z = z2;
                obj12 = obj6;
                obj7 = obj8;
                obj = endInteractionSource2;
                colors3 = startThumb;
                obj4 = track;
            }
        } else {
        }
        Composer $composer2 = restartGroup;
        int i22 = 0;
        IllegalArgumentException $i$a$RequireSliderKt$RangeSlider$17 = new IllegalArgumentException("steps should be >= 0".toString());
        throw $i$a$RequireSliderKt$RangeSlider$17;
    }

    public static final void RangeSlider(ClosedFloatingPointRange<Float> value, Function1<? super ClosedFloatingPointRange<Float>, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> valueRange, int steps, Function0<Unit> onValueChangeFinished, androidx.compose.material3.SliderColors colors, Composer $composer, int $changed, int i11) {
        Object obj8;
        int traceInProgress2;
        int $dirty3;
        int $dirty5;
        Object $i$a$CacheSliderKt$RangeSlider$startInteractionSource$1;
        int defaultsInvalid;
        Object modifier2;
        Object restartGroup;
        int $dirty;
        int $dirty4;
        int i7;
        int i8;
        Object colors3;
        int i4;
        int rangeTo;
        Object colors2;
        Object $dirty2;
        boolean traceInProgress;
        Object $i$a$CacheSliderKt$RangeSlider$endInteractionSource$1;
        boolean z;
        int i;
        int str;
        Object obj4;
        boolean z2;
        int i9;
        int i3;
        Object obj3;
        Object obj5;
        int changed;
        androidx.compose.material3.SliderColors sliderColors;
        Object obj2;
        int i6;
        Object obj;
        int steps2;
        int i15;
        boolean i10;
        Object onValueChangeFinished2;
        int i5;
        Object i12;
        int changed2;
        int i2;
        Object obj7;
        Object obj6;
        androidx.compose.runtime.internal.ComposableLambda composableLambda2;
        androidx.compose.runtime.internal.ComposableLambda composableLambda3;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i17;
        Composer composer;
        int i16;
        int i13;
        int i14;
        int obj30;
        final int i63 = $changed;
        final int i64 = i11;
        restartGroup = $composer.startRestartGroup(-743091416);
        ComposerKt.sourceInformation(restartGroup, "C(RangeSlider)P(6,3,2,1,7,5,4)408@18812L8,410@18884L39,411@18981L39,423@19399L186,430@19606L184,437@19808L199,413@19026L987:Slider.kt#uh7d8r");
        $dirty = $changed;
        if (i64 & 1 != 0) {
            $dirty |= 6;
            obj2 = value;
        } else {
            if (i63 & 6 == 0) {
                i7 = restartGroup.changed(value) ? 4 : 2;
                $dirty |= i7;
            } else {
                obj2 = value;
            }
        }
        if (i64 & 2 != 0) {
            $dirty |= 48;
            obj = onValueChange;
        } else {
            if (i63 & 48 == 0) {
                i8 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty |= i8;
            } else {
                obj = onValueChange;
            }
        }
        i4 = i64 & 4;
        if (i4 != 0) {
            $dirty |= 384;
            $dirty2 = modifier;
        } else {
            if (i63 & 384 == 0) {
                i = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i;
            } else {
                $dirty2 = modifier;
            }
        }
        str = i64 & 8;
        if (str != null) {
            $dirty |= 3072;
            z2 = enabled;
        } else {
            if (i63 & 3072 == 0) {
                i3 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i3;
            } else {
                z2 = enabled;
            }
        }
        if (i63 & 24576 == 0) {
            if (i64 & 16 == 0) {
                changed = restartGroup.changed(valueRange) ? 16384 : 8192;
            } else {
                obj3 = valueRange;
            }
            $dirty |= changed;
        } else {
            obj3 = valueRange;
        }
        int i59 = i64 & 32;
        int i65 = 196608;
        if (i59 != 0) {
            $dirty |= i65;
            steps2 = steps;
        } else {
            if (i65 &= i63 == 0) {
                i15 = restartGroup.changed(steps) ? 131072 : 65536;
                $dirty |= i15;
            } else {
                steps2 = steps;
            }
        }
        i10 = i64 & 64;
        int i67 = 1572864;
        if (i10 != 0) {
            $dirty |= i67;
            onValueChangeFinished2 = onValueChangeFinished;
        } else {
            if (i67 &= i63 == 0) {
                i5 = restartGroup.changedInstance(onValueChangeFinished) ? 1048576 : 524288;
                $dirty |= i5;
            } else {
                onValueChangeFinished2 = onValueChangeFinished;
            }
        }
        if (i63 & i69 == 0) {
            if (i64 & 128 == 0) {
                changed2 = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                obj8 = colors;
            }
            $dirty |= changed2;
        } else {
            obj8 = colors;
        }
        final int obj36 = $dirty;
        if ($dirty & i2 == 4793490) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i24 = -29360129;
                int i70 = -57345;
                if (i63 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i4 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = $dirty2;
                        }
                        if (str != null) {
                            z2 = i4;
                        }
                        if (i64 & 16 != 0) {
                            $dirty2 = obj36 & i70;
                            obj3 = rangeTo;
                        } else {
                            $dirty2 = obj36;
                        }
                        if (i59 != 0) {
                            steps2 = rangeTo;
                        }
                        if (i10 != 0) {
                            onValueChangeFinished2 = rangeTo;
                        }
                        if (i64 & 128 != 0) {
                            colors3 = SliderDefaults.INSTANCE.colors(restartGroup, 6);
                            i24 &= $dirty2;
                            i10 = z2;
                            i17 = steps2;
                            i12 = onValueChangeFinished2;
                            steps2 = modifier2;
                            onValueChangeFinished2 = obj3;
                            $dirty5 = -743091416;
                        } else {
                            colors3 = colors;
                            $dirty4 = $dirty2;
                            i10 = z2;
                            i17 = steps2;
                            i12 = onValueChangeFinished2;
                            steps2 = modifier2;
                            onValueChangeFinished2 = obj3;
                            $dirty5 = -743091416;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty3 = i64 & 16 != 0 ? obj36 & i70 : obj36;
                        if (i64 & 128 != 0) {
                            $dirty3 &= i24;
                        }
                        colors3 = colors;
                        $dirty4 = $dirty3;
                        i10 = z2;
                        i17 = steps2;
                        i12 = onValueChangeFinished2;
                        $dirty5 = -743091416;
                        steps2 = $dirty2;
                        onValueChangeFinished2 = obj3;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart($dirty5, $dirty4, -1, "androidx.compose.material3.RangeSlider (Slider.kt:409)");
                }
                String str3 = "CC(remember):Slider.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1661051042, str3);
                Composer composer2 = restartGroup;
                int i42 = 0;
                Object rememberedValue = composer2.rememberedValue();
                int i60 = 0;
                obj30 = i21;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    int i22 = 0;
                    composer2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                } else {
                    $i$a$CacheSliderKt$RangeSlider$startInteractionSource$1 = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1661054146, str3);
                Composer composer3 = restartGroup;
                int i43 = 0;
                Object rememberedValue2 = composer3.rememberedValue();
                int i61 = 0;
                obj30 = i29;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    int i30 = 0;
                    composer3.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                } else {
                    $i$a$CacheSliderKt$RangeSlider$endInteractionSource$1 = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                SliderKt.RangeSlider.1 anon = new SliderKt.RangeSlider.1((MutableInteractionSource)$i$a$CacheSliderKt$RangeSlider$startInteractionSource$1, colors3, i10);
                int i56 = 1;
                int i62 = 54;
                SliderKt.RangeSlider.2 anon2 = new SliderKt.RangeSlider.2((MutableInteractionSource)$i$a$CacheSliderKt$RangeSlider$endInteractionSource$1, colors3, i10);
                SliderKt.RangeSlider.3 anon3 = new SliderKt.RangeSlider.3(i10, colors3);
                SliderKt.RangeSlider(obj2, obj, steps2, i10, onValueChangeFinished2, i12, 0, $i$a$CacheSliderKt$RangeSlider$startInteractionSource$1, $i$a$CacheSliderKt$RangeSlider$endInteractionSource$1, (Function3)ComposableLambdaKt.rememberComposableLambda(-811582901, i56, anon, restartGroup, i62), (Function3)ComposableLambdaKt.rememberComposableLambda(-1832060001, i56, anon2, restartGroup, i62), (Function3)ComposableLambdaKt.rememberComposableLambda(377064480, i56, anon3, restartGroup, i62), i17, restartGroup, i38 | i54, i40 | 54, 64);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i6 = $dirty4;
                sliderColors = colors3;
                colors2 = steps2;
                z = i10;
                obj4 = onValueChangeFinished2;
                obj5 = i12;
                i9 = i17;
            } else {
                restartGroup.skipToGroupEnd();
                sliderColors = colors;
                i6 = obj36;
                composer = restartGroup;
                colors2 = $dirty2;
                z = z2;
                obj4 = obj3;
                i9 = steps2;
                obj5 = onValueChangeFinished2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SliderKt.RangeSlider.4(value, onValueChange, colors2, z, obj4, i9, obj5, sliderColors, i63, i64);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void RangeSlider(ClosedFloatingPointRange<Float> value, Function1<? super ClosedFloatingPointRange<Float>, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> valueRange, Function0<Unit> onValueChangeFinished, androidx.compose.material3.SliderColors colors, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, Function3<? super androidx.compose.material3.RangeSliderState, ? super Composer, ? super Integer, Unit> startThumb, Function3<? super androidx.compose.material3.RangeSliderState, ? super Composer, ? super Integer, Unit> endThumb, Function3<? super androidx.compose.material3.RangeSliderState, ? super Composer, ? super Integer, Unit> track, int steps, Composer $composer, int $changed, int $changed1, int i17) {
        int i7;
        int skipping;
        Object valueRange2;
        Object valueRange3;
        int startInteractionSource2;
        int i22;
        int i4;
        Object it$iv;
        int endThumb2;
        Object obj4;
        Object obj10;
        Object obj8;
        Object obj2;
        Object composer;
        int i11;
        ScopeUpdateScope endRestartGroup;
        Object $composer2;
        Object $composer3;
        int $dirty3;
        Object $i$a$CacheSliderKt$RangeSlider$6;
        androidx.compose.runtime.internal.ComposableLambda endInteractionSource3;
        Object endThumb3;
        androidx.compose.runtime.internal.ComposableLambda $dirty;
        int i24;
        int changed3;
        int i;
        Object $i$a$CacheSliderKt$RangeSlider$state$1;
        int empty;
        boolean $dirty2;
        int $dirty1;
        Object $dirty12;
        Object obj7;
        int i18;
        Object obj6;
        Object obj;
        Object modifier2;
        boolean obj5;
        Object enabled2;
        int i14;
        int i3;
        int i25;
        int i10;
        int companion;
        int i9;
        Object onValueChangeFinished3;
        Object onValueChangeFinished2;
        Object obj3;
        Object colors3;
        androidx.compose.runtime.internal.ComposableLambda colors2;
        Object steps2;
        androidx.compose.runtime.internal.ComposableLambda valueRange4;
        Object obj9;
        androidx.compose.runtime.internal.ComposableLambda rememberComposableLambda;
        androidx.compose.runtime.internal.ComposableLambda startThumb2;
        int rememberedValue;
        Object composer3;
        int i23;
        int i15;
        int startInteractionSource3;
        int i2;
        int i12;
        int $dirty13;
        int changed;
        Composer composer2;
        int endInteractionSource2;
        int changed2;
        int i6;
        int companion2;
        int i8;
        int i19;
        int rangeSliderState;
        int floatValue;
        int i13;
        int floatValue2;
        int i16;
        int i20;
        int i5;
        int i21;
        boolean changedInstance;
        ScopeUpdateScope scopeUpdateScope;
        Object obj32;
        int obj33;
        int obj34;
        int obj35;
        Object obj36;
        Object obj37;
        androidx.compose.runtime.internal.ComposableLambda obj38;
        androidx.compose.runtime.internal.ComposableLambda obj39;
        int obj40;
        Composer obj41;
        int obj42;
        Composer obj43;
        final Object obj11 = onValueChange;
        final int i89 = $changed;
        final int i90 = $changed1;
        int i26 = i17;
        $composer2 = $composer.startRestartGroup(-1048796133);
        ComposerKt.sourceInformation($composer2, "C(RangeSlider)P(11,5,4,1,12,6!1,7!1,8!1,10)511@23750L8,512@23815L39,513@23909L39,514@24007L162,521@24226L160,528@24440L175,538@24684L237,549@25005L44,553@25142L291:Slider.kt#uh7d8r");
        $dirty3 = $changed;
        $dirty1 = $changed1;
        if (i26 & 1 != 0) {
            $dirty3 |= 6;
            obj7 = value;
        } else {
            if (i89 & 6 == 0) {
                i14 = $composer2.changed(value) ? 4 : 2;
                $dirty3 |= i14;
            } else {
                obj7 = value;
            }
        }
        if (i26 & 2 != 0) {
            $dirty3 |= 48;
        } else {
            if (i89 & 48 == 0) {
                i3 = $composer2.changedInstance(obj11) ? 32 : 16;
                $dirty3 |= i3;
            }
        }
        companion = i26 & 4;
        if (companion != 0) {
            $dirty3 |= 384;
            obj = modifier;
        } else {
            if (i89 & 384 == 0) {
                i15 = $composer2.changed(modifier) ? 256 : 128;
                $dirty3 |= i15;
            } else {
                obj = modifier;
            }
        }
        startInteractionSource3 = i26 & 8;
        if (startInteractionSource3 != 0) {
            $dirty3 |= 3072;
            obj5 = enabled;
        } else {
            if (i89 & 3072 == 0) {
                changed = $composer2.changed(enabled) ? 2048 : 1024;
                $dirty3 |= changed;
            } else {
                obj5 = enabled;
            }
        }
        if (i89 & 24576 == 0) {
            if (i26 & 16 == 0) {
                changed2 = $composer2.changed(valueRange) ? 16384 : 8192;
            } else {
                steps2 = valueRange;
            }
            $dirty3 |= changed2;
        } else {
            steps2 = valueRange;
        }
        int i97 = i26 & 32;
        companion2 = 196608;
        if (i97 != 0) {
            $dirty3 |= companion2;
            obj3 = onValueChangeFinished;
        } else {
            if (i89 & companion2 == 0) {
                i8 = $composer2.changedInstance(onValueChangeFinished) ? 131072 : 65536;
                $dirty3 |= i8;
            } else {
                obj3 = onValueChangeFinished;
            }
        }
        if (i89 & i98 == 0) {
            if (i26 & 64 == 0) {
                rangeSliderState = $composer2.changed(colors) ? 1048576 : 524288;
            } else {
                obj9 = colors;
            }
            $dirty3 |= rangeSliderState;
        } else {
            obj9 = colors;
        }
        rememberedValue = i26 & 128;
        floatValue = 12582912;
        if (rememberedValue != 0) {
            $dirty3 |= floatValue;
            obj4 = startInteractionSource;
        } else {
            if (i89 & floatValue == 0) {
                i13 = $composer2.changed(startInteractionSource) ? 8388608 : 4194304;
                $dirty3 |= i13;
            } else {
                obj4 = startInteractionSource;
            }
        }
        int i41 = i26 & 256;
        int i99 = 100663296;
        if (i41 != 0) {
            $dirty3 |= i99;
            floatValue2 = i41;
            obj10 = endInteractionSource;
        } else {
            if (i89 & i99 == 0) {
                floatValue2 = i41;
                i16 = $composer2.changed(endInteractionSource) ? 67108864 : 33554432;
                $dirty3 |= i16;
            } else {
                floatValue2 = i41;
                obj10 = endInteractionSource;
            }
        }
        int i42 = i26 & 512;
        int i101 = 805306368;
        if (i42 != 0) {
            $dirty3 |= i101;
            i20 = i42;
            obj8 = startThumb;
        } else {
            if (i89 & i101 == 0) {
                i20 = i42;
                i5 = $composer2.changedInstance(startThumb) ? 536870912 : 268435456;
                $dirty3 |= i5;
            } else {
                i20 = i42;
                obj8 = startThumb;
            }
        }
        int i43 = i26 & 1024;
        if (i43 != 0) {
            $dirty1 |= 6;
            i21 = i43;
            obj2 = endThumb;
        } else {
            if (i90 & 6 == 0) {
                i21 = i43;
                i2 = $composer2.changedInstance(endThumb) ? 4 : 2;
                $dirty1 |= i2;
            } else {
                i21 = i43;
                obj2 = endThumb;
            }
        }
        int i44 = i26 & 2048;
        if (i44 != 0) {
            $dirty1 |= 48;
            i12 = i44;
            composer = track;
        } else {
            if (i90 & 48 == 0) {
                i12 = i44;
                changed = $composer2.changedInstance(track) ? 32 : 16;
                $dirty1 |= changed;
            } else {
                i12 = i44;
                composer = track;
            }
        }
        int i45 = i26 & 4096;
        if (i45 != 0) {
            $dirty1 |= 384;
            i7 = steps;
        } else {
            if (i90 & 384 == 0) {
                endInteractionSource2 = $composer2.changed(steps) ? 256 : 128;
                $dirty1 |= endInteractionSource2;
            } else {
                i7 = steps;
            }
        }
        if ($dirty3 & i93 == 306783378 && $dirty1 & 147 == 146) {
            if ($dirty1 & 147 == 146) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    String str = "CC(remember):Slider.kt#9igjgp";
                    if (i89 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (companion != 0) {
                                obj = companion;
                            }
                            if (startInteractionSource3 != 0) {
                                obj5 = 1;
                            }
                            if (i17 & 16 != 0) {
                                valueRange2 = RangesKt.rangeTo(0, 1065353216);
                                $dirty3 &= i9;
                            } else {
                                valueRange2 = steps2;
                            }
                            onValueChangeFinished3 = i97 != 0 ? 0 : obj3;
                            if (i17 & 64 != 0) {
                                colors3 = SliderDefaults.INSTANCE.colors($composer2, 6);
                                $dirty3 &= steps2;
                            } else {
                                colors3 = obj9;
                            }
                            if (rememberedValue != 0) {
                                ComposerKt.sourceInformationMarkerStart($composer2, 1661208834, str);
                                steps2 = 0;
                                obj9 = $composer2;
                                rememberedValue = 0;
                                obj32 = valueRange2;
                                Object rememberedValue2 = obj9.rememberedValue();
                                startInteractionSource3 = 0;
                                obj33 = $dirty3;
                                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                    int i70 = 0;
                                    obj9.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    $dirty3 = rememberedValue2;
                                }
                                valueRange3 = $dirty3;
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                            } else {
                                obj32 = valueRange2;
                                obj33 = $dirty3;
                                valueRange3 = startInteractionSource;
                            }
                            if (floatValue2 != 0) {
                                ComposerKt.sourceInformationMarkerStart($composer2, 1661211842, str);
                                steps2 = $composer2;
                                obj9 = 0;
                                rememberedValue = steps2.rememberedValue();
                                startInteractionSource3 = 0;
                                obj34 = i68;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i69 = 0;
                                    steps2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    $i$a$CacheSliderKt$RangeSlider$6 = rememberedValue;
                                }
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                            } else {
                                $i$a$CacheSliderKt$RangeSlider$6 = endInteractionSource;
                            }
                            int i85 = 54;
                            if (i20 != 0) {
                                SliderKt.RangeSlider.7 anon = new SliderKt.RangeSlider.7(valueRange3, colors3, obj5);
                                startInteractionSource3 = valueRange3;
                                rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1963073082, true, anon, $composer2, i85);
                            } else {
                                startInteractionSource3 = valueRange3;
                                startInteractionSource2 = 1;
                                rememberComposableLambda = startThumb;
                            }
                            if (i21 != 0) {
                                rememberedValue = new SliderKt.RangeSlider.8($i$a$CacheSliderKt$RangeSlider$6, colors3, obj5);
                                endInteractionSource2 = $i$a$CacheSliderKt$RangeSlider$6;
                                endInteractionSource3 = ComposableLambdaKt.rememberComposableLambda(1908709951, startInteractionSource2, rememberedValue, $composer2, i85);
                            } else {
                                endInteractionSource2 = $i$a$CacheSliderKt$RangeSlider$6;
                                endInteractionSource3 = endThumb;
                            }
                            if (i12 != 0) {
                                rememberedValue = new SliderKt.RangeSlider.9(obj5, colors3);
                                obj34 = endInteractionSource3;
                                endThumb3 = ComposableLambdaKt.rememberComposableLambda(-429193201, startInteractionSource2, rememberedValue, $composer2, i85);
                            } else {
                                obj34 = endInteractionSource3;
                                endThumb3 = track;
                            }
                            if (i45 != 0) {
                                i22 = obj33;
                                composer3 = endThumb3;
                                i12 = i86;
                                steps2 = obj32;
                                $dirty = obj34;
                            } else {
                                steps2 = obj32;
                                i22 = obj33;
                                i12 = steps;
                                composer3 = endThumb3;
                                $dirty = obj34;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (i17 & 16 != 0) {
                                $dirty3 &= i25;
                            }
                            if (i17 & 64 != 0) {
                                $dirty3 &= i10;
                            }
                            startInteractionSource3 = startInteractionSource;
                            endInteractionSource2 = endInteractionSource;
                            composer3 = track;
                            i12 = steps;
                            i22 = $dirty3;
                            onValueChangeFinished3 = obj3;
                            colors3 = obj9;
                            rememberComposableLambda = startThumb;
                            $dirty = endThumb;
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj39 = $dirty;
                        ComposerKt.traceEventStart(-1048796133, i22, $dirty1, "androidx.compose.material3.RangeSlider (Slider.kt:536)");
                    } else {
                        obj39 = $dirty;
                    }
                    ComposerKt.sourceInformationMarkerStart($composer2, 1661236840, str);
                    i24 = $dirty1 & 896 == 256 ? 1 : 0;
                    if (i76 ^= 24576 > 16384) {
                        if (!$composer2.changed(steps2)) {
                            i = i22 & 24576 == 16384 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                    empty = obj32 | i;
                    Composer composer5 = $composer2;
                    int i95 = 0;
                    i6 = i22;
                    Object rememberedValue3 = composer5.rememberedValue();
                    i19 = 0;
                    if (empty == 0) {
                        obj40 = empty;
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            int invalid$iv = 0;
                            obj32 = rangeSliderState;
                            super((Number)value.getStart().floatValue(), (Number)value.getEndInclusive().floatValue(), i12, onValueChangeFinished3, steps2);
                            composer5.updateRememberedValue(obj32);
                        } else {
                            $i$a$CacheSliderKt$RangeSlider$state$1 = rememberedValue3;
                        }
                    } else {
                        obj40 = empty;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    (RangeSliderState)$i$a$CacheSliderKt$RangeSlider$state$1.setOnValueChangeFinished(onValueChangeFinished3);
                    ComposerKt.sourceInformationMarkerStart($composer2, 1661246919, str);
                    i4 = i6 & 112 == 32 ? 1 : 0;
                    Composer composer4 = $composer2;
                    int i77 = 0;
                    it$iv = composer4.rememberedValue();
                    int i96 = 0;
                    if (i4 == 0) {
                        obj43 = $composer2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $composer2 = 0;
                            obj33 = it$iv;
                            it$iv = new SliderKt.RangeSlider.10.1(obj11);
                            composer4.updateRememberedValue((Function1)it$iv);
                        } else {
                            obj33 = it$iv;
                        }
                    } else {
                        obj43 = $composer2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(obj43);
                    $i$a$CacheSliderKt$RangeSlider$state$1.setOnValueChange$material3_release((Function1)it$iv);
                    $i$a$CacheSliderKt$RangeSlider$state$1.setActiveRangeStart((Number)value.getStart().floatValue());
                    $i$a$CacheSliderKt$RangeSlider$state$1.setActiveRangeEnd((Number)value.getEndInclusive().floatValue());
                    obj41 = obj43;
                    obj40 = composer3;
                    SliderKt.RangeSlider($i$a$CacheSliderKt$RangeSlider$state$1, obj, obj5, 0, startInteractionSource3, endInteractionSource2, rememberComposableLambda, obj39, obj40, obj41, i38 |= i58, 8);
                    composer2 = obj41;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    valueRange4 = composableLambda;
                    endThumb2 = $dirty1;
                    $dirty12 = obj12;
                    $composer3 = obj;
                    $dirty2 = obj5;
                    obj6 = onValueChangeFinished3;
                    modifier2 = colors3;
                    colors2 = rememberComposableLambda;
                    enabled2 = startInteractionSource3;
                    i23 = i12;
                    onValueChangeFinished2 = endInteractionSource2;
                    startThumb2 = i11;
                } else {
                    $composer2.skipToGroupEnd();
                    onValueChangeFinished2 = endInteractionSource;
                    i23 = steps;
                    composer2 = $composer2;
                    i6 = $dirty3;
                    endThumb2 = $dirty1;
                    $composer3 = obj;
                    $dirty2 = obj5;
                    obj6 = obj3;
                    $dirty12 = steps2;
                    modifier2 = obj9;
                    enabled2 = startInteractionSource;
                    colors2 = startThumb;
                    valueRange4 = endThumb;
                    startThumb2 = track;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty13 = i91;
            endThumb2 = new SliderKt.RangeSlider.11(value, obj11, $composer3, $dirty2, $dirty12, obj6, modifier2, enabled2, onValueChangeFinished2, colors2, valueRange4, startThumb2, i23, i89, i90, i17);
            endRestartGroup.updateScope((Function2)endThumb2);
        } else {
            $dirty13 = endThumb2;
        }
    }

    private static final void RangeSliderImpl(Modifier modifier, androidx.compose.material3.RangeSliderState state, boolean enabled, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, Function3<? super androidx.compose.material3.RangeSliderState, ? super Composer, ? super Integer, Unit> startThumb, Function3<? super androidx.compose.material3.RangeSliderState, ? super Composer, ? super Integer, Unit> endThumb, Function3<? super androidx.compose.material3.RangeSliderState, ? super Composer, ? super Integer, Unit> track, Composer $composer, int $changed) {
        boolean traceInProgress;
        int i8;
        Object invalid$iv;
        Function0 factory$iv$iv$iv3;
        Function0 factory$iv$iv$iv2;
        int $dirty;
        Object obj8;
        int skipping;
        boolean traceInProgress2;
        Object it$iv;
        Function0 factory$iv$iv$iv;
        Composer materialized$iv$iv;
        Integer currentCompositionLocalMap;
        Object obj;
        Integer topStart;
        int obj7;
        Composer composer5;
        int valueOf2;
        int obj5;
        Object it$iv3;
        Object obj11;
        int obj6;
        int empty2;
        Composer composer8;
        Function0 factory$iv$iv;
        Object it$iv4;
        Object it$iv2;
        Integer currentCompositionLocalMap2;
        Composer composer3;
        int valueOf;
        Object $composer3;
        Object obj9;
        Composer composer6;
        Composer composer;
        Composer composer11;
        Object maybeCachedBoxMeasurePolicy;
        int empty;
        Object currentCompositionLocalMap3;
        int i25;
        int i27;
        int i10;
        int i7;
        int i3;
        int i2;
        int i16;
        int i14;
        int currentCompositeKeyHash2;
        int str2;
        Object $i$f$cache;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap4;
        int empty3;
        String string-2EP1pXo;
        int i9;
        Modifier modifier3;
        int i17;
        int i15;
        Composer composer9;
        int currentCompositeKeyHash;
        int i22;
        Object obj4;
        int companion;
        int i23;
        Modifier modifier6;
        Function0 function0;
        int i11;
        int i18;
        int i4;
        int i5;
        Modifier modifier2;
        int i6;
        boolean z;
        androidx.compose.material3.SliderKt.RangeSliderImpl.2.1 measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        Function0 function02;
        int companion4;
        Object obj10;
        Composer $composer2;
        Object obj3;
        int companion2;
        BoxScopeInstance companion3;
        Object obj2;
        int $i$f$cache2;
        Alignment contentAlignment$iv;
        int i24;
        Modifier modifier5;
        Composer composer2;
        int i12;
        int i26;
        int i19;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        int i13;
        Composer composer10;
        Modifier modifier4;
        String str;
        int i21;
        Composer composer4;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i20;
        Composer composer7;
        int i;
        Modifier obj65;
        final Object obj12 = state;
        materialized$iv$iv = enabled;
        obj = startInteractionSource;
        obj7 = endInteractionSource;
        obj5 = startThumb;
        obj6 = track;
        empty2 = $changed;
        traceInProgress = -1411725677;
        $composer3 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation($composer3, "C(RangeSliderImpl)P(3,6!1,4!1,5)736@32503L7,746@32756L35,747@32824L33,784@34404L2230,749@32863L3771:Slider.kt#uh7d8r");
        if (empty2 & 6 == 0) {
            i25 = $composer3.changed(modifier) ? 4 : 2;
            $dirty |= i25;
        } else {
            obj9 = modifier;
        }
        if (empty2 & 48 == 0) {
            i27 = $composer3.changedInstance(obj12) ? 32 : 16;
            $dirty |= i27;
        }
        if (empty2 & 384 == 0) {
            i10 = $composer3.changed(materialized$iv$iv) ? 256 : 128;
            $dirty |= i10;
        }
        if (empty2 & 3072 == 0) {
            i7 = $composer3.changed(obj) ? 2048 : 1024;
            $dirty |= i7;
        }
        if (empty2 & 24576 == 0) {
            i3 = $composer3.changed(obj7) ? 16384 : 8192;
            $dirty |= i3;
        }
        if (i88 &= empty2 == 0) {
            i2 = $composer3.changedInstance(obj5) ? 131072 : 65536;
            $dirty |= i2;
        }
        if (i89 &= empty2 == 0) {
            i16 = $composer3.changedInstance(endThumb) ? 1048576 : 524288;
            $dirty |= i16;
        }
        if (i90 &= empty2 == 0) {
            i14 = $composer3.changedInstance(obj6) ? 8388608 : 4194304;
            $dirty |= i14;
        }
        currentCompositeKeyHash2 = $dirty;
        if ($dirty2 &= currentCompositeKeyHash2 == 4793490) {
            if (!$composer3.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, currentCompositeKeyHash2, -1, "androidx.compose.material3.RangeSliderImpl (Slider.kt:735)");
                }
                int i42 = 0;
                int i91 = 0;
                ComposerKt.sourceInformationMarkerStart($composer3, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd($composer3);
                int i92 = 0;
                i8 = $composer3.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? 1 : i92;
                obj12.setRtl$material3_release(i8);
                Modifier rangeSliderPressDragModifier = SliderKt.rangeSliderPressDragModifier((Modifier)Modifier.Companion, obj12, obj, obj7, materialized$iv$iv);
                androidx.compose.material3.internal.Strings.Companion companion20 = Strings.Companion;
                int i109 = 0;
                String string-2EP1pXo2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.range_start), $composer3, i92);
                androidx.compose.material3.internal.Strings.Companion companion24 = Strings.Companion;
                int i110 = 0;
                string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.range_end), $composer3, i92);
                int i111 = i92;
                modifier3 = rangeSliderPressDragModifier;
                String pressDrag = "CC(remember):Slider.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer3, 1662324209, pressDrag);
                Composer composer17 = $composer3;
                int i115 = 0;
                it$iv = composer17.rememberedValue();
                int i119 = 0;
                if (!$composer3.changedInstance(obj12)) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        int i71 = 0;
                        obj4 = it$iv;
                        it$iv = new SliderKt.RangeSliderImpl.2.1(obj12);
                        composer17.updateRememberedValue((MeasurePolicy)it$iv);
                    } else {
                        obj4 = it$iv;
                        composer8 = composer17;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                Modifier modifier8 = modifier9;
                i17 = 0;
                i15 = currentCompositeKeyHash2;
                String $dirty3 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, $dirty3);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, i111);
                currentCompositionLocalMap3 = $composer3.getCurrentCompositionLocalMap();
                Modifier materializeModifier3 = ComposedModifierKt.materializeModifier($composer3, modifier8);
                modifier6 = modifier8;
                Function0 function04 = constructor2;
                i23 = 0;
                String str5 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, str5);
                if (!applier4 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(function04);
                } else {
                    factory$iv$iv = function04;
                    $composer3.useNode();
                }
                function0 = factory$iv$iv;
                Composer constructor-impl4 = Updater.constructor-impl($composer3);
                int i121 = 0;
                Updater.set-impl(constructor-impl4, (MeasurePolicy)it$iv, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl4, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i122 = 0;
                Composer composer18 = constructor-impl4;
                int i123 = 0;
                if (!composer18.getInserting()) {
                    measurePolicy$iv = it$iv;
                    map = currentCompositionLocalMap3;
                    if (!Intrinsics.areEqual(composer18.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer18.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl4.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer6 = composer18;
                    }
                } else {
                    measurePolicy$iv = it$iv;
                    map = currentCompositionLocalMap3;
                }
                Updater.set-impl(constructor-impl4, materializeModifier3, ComposeUiNode.Companion.getSetModifier());
                obj11 = $composer3;
                i4 = i44;
                ComposerKt.sourceInformationMarkerStart(obj11, 2110426496, "C755@33080L46,757@33259L100,751@32893L598,768@33689L44,770@33864L98,764@33504L586,777@34103L79:Slider.kt#uh7d8r");
                empty = 0;
                i5 = i62;
                modifier2 = materializeModifier3;
                ComposerKt.sourceInformationMarkerStart(obj11, 1176461672, pressDrag);
                Composer composer19 = obj11;
                int i127 = 0;
                it$iv4 = composer19.rememberedValue();
                companion2 = 0;
                if (!$composer3.changedInstance(obj12)) {
                    if (it$iv4 == Composer.Companion.getEmpty()) {
                        int i87 = 0;
                        obj2 = it$iv4;
                        it$iv4 = new SliderKt.RangeSliderImpl.1.1.1(obj12);
                        composer19.updateRememberedValue((Function1)it$iv4);
                    } else {
                        obj2 = it$iv4;
                        composer = composer19;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(obj11);
                ComposerKt.sourceInformationMarkerStart(obj11, 1176467454, pressDrag);
                Composer composer15 = obj11;
                $i$f$cache = 0;
                it$iv2 = composer15.rememberedValue();
                int i128 = 0;
                if (!obj11.changed(string-2EP1pXo2)) {
                    $i$f$cache2 = $i$f$cache;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        $i$f$cache = 0;
                        obj3 = it$iv2;
                        it$iv2 = new SliderKt.RangeSliderImpl.1.2.1(string-2EP1pXo2);
                        composer15.updateRememberedValue((Function1)it$iv2);
                    } else {
                        obj3 = it$iv2;
                    }
                } else {
                    $i$f$cache2 = $i$f$cache;
                }
                ComposerKt.sourceInformationMarkerEnd(obj11);
                Modifier focusable2 = FocusableKt.focusable(SemanticsModifierKt.semantics(SliderKt.rangeSliderStartThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, RangeSliderComponents.STARTTHUMB), empty, false, 3, empty), (Function1)it$iv4), obj12, materialized$iv$iv), true, (Function1)it$iv2), materialized$iv$iv, obj);
                String str4 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(obj11, 733328855, str4);
                Alignment topStart3 = Alignment.Companion.getTopStart();
                int i124 = i64;
                int $changed$iv4 = 0;
                int i129 = i80;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart3, $changed$iv4);
                int i134 = 0;
                int i136 = $changed$iv4;
                ComposerKt.sourceInformationMarkerStart(obj11, -1323940314, $dirty3);
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(obj11, 0);
                currentCompositionLocalMap2 = obj11.getCurrentCompositionLocalMap();
                Alignment alignment = topStart3;
                Modifier modifier10 = focusable2;
                Function0 function07 = constructor4;
                int i142 = 0;
                ComposerKt.sourceInformationMarkerStart(obj11, -692256719, str5);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                obj11.startReusableNode();
                if (obj11.getInserting()) {
                    obj11.createNode(function07);
                } else {
                    factory$iv$iv$iv = function07;
                    obj11.useNode();
                }
                Function0 function08 = factory$iv$iv$iv;
                Composer constructor-impl2 = Updater.constructor-impl(obj11);
                int i145 = 0;
                str = string-2EP1pXo2;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i147 = 0;
                Composer composer22 = constructor-impl2;
                int i150 = 0;
                if (!composer22.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer22.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        composer22.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash4), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer11 = composer22;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier(obj11, focusable2), ComposeUiNode.Companion.getSetModifier());
                Composer composer13 = obj11;
                int i146 = i48;
                String $changed$iv3 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer13, -2146769399, $changed$iv3);
                BoxScopeInstance iNSTANCE3 = BoxScopeInstance.INSTANCE;
                i149 |= 6;
                i20 = 0;
                i = i81;
                Composer $i$a$LayoutBoxKt$Box$1$iv = composer4;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, 259534201, "C762@33460L17:Slider.kt#uh7d8r");
                obj5.invoke(obj12, $i$a$LayoutBoxKt$Box$1$iv, Integer.valueOf(i67 |= i103));
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                ComposerKt.sourceInformationMarkerEnd(composer13);
                obj11.endNode();
                ComposerKt.sourceInformationMarkerEnd(obj11);
                ComposerKt.sourceInformationMarkerEnd(obj11);
                ComposerKt.sourceInformationMarkerEnd(obj11);
                int i82 = 0;
                ComposerKt.sourceInformationMarkerStart(obj11, 1176481158, pressDrag);
                Composer composer16 = obj11;
                empty3 = 0;
                it$iv3 = composer16.rememberedValue();
                int i125 = 0;
                if (!$composer3.changedInstance(obj12)) {
                    $composer2 = $composer3;
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        $composer3 = 0;
                        obj10 = it$iv3;
                        it$iv3 = new SliderKt.RangeSliderImpl.1.4.1(obj12);
                        composer16.updateRememberedValue((Function1)it$iv3);
                    } else {
                        obj10 = it$iv3;
                    }
                } else {
                    $composer2 = $composer3;
                }
                ComposerKt.sourceInformationMarkerEnd(obj11);
                ComposerKt.sourceInformationMarkerStart(obj11, 1176486812, pressDrag);
                boolean changed = obj11.changed(string-2EP1pXo);
                Composer composer14 = obj11;
                int i72 = 0;
                Object rememberedValue5 = composer14.rememberedValue();
                int i98 = 0;
                if (!changed) {
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        empty3 = 0;
                        z = changed;
                        invalid$iv = new SliderKt.RangeSliderImpl.1.5.1(string-2EP1pXo);
                        composer14.updateRememberedValue((Function1)invalid$iv);
                    } else {
                        z = changed;
                        invalid$iv = rememberedValue5;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(obj11);
                Modifier focusable = FocusableKt.focusable(SemanticsModifierKt.semantics(SliderKt.rangeSliderEndThumbSemantics(OnRemeasuredModifierKt.onSizeChanged(SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, RangeSliderComponents.ENDTHUMB), i82, false, 3, i82), (Function1)it$iv3), obj12, materialized$iv$iv), true, (Function1)invalid$iv), materialized$iv$iv, obj7);
                int i55 = i113;
                valueOf = 0;
                ComposerKt.sourceInformationMarkerStart(obj11, 733328855, str4);
                int i126 = 0;
                ComposerKt.sourceInformationMarkerStart(obj11, -1323940314, $dirty3);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(obj11, 0);
                currentCompositionLocalMap = obj11.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(obj11, focusable);
                obj65 = focusable;
                Function0 function05 = constructor3;
                int i132 = 0;
                ComposerKt.sourceInformationMarkerStart(obj11, -692256719, str5);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                obj11.startReusableNode();
                if (obj11.getInserting()) {
                    obj11.createNode(function05);
                } else {
                    factory$iv$iv$iv3 = function05;
                    obj11.useNode();
                }
                Function0 function06 = factory$iv$iv$iv3;
                Composer constructor-impl = Updater.constructor-impl(obj11);
                int i137 = 0;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i141 = 0;
                Composer composer21 = constructor-impl;
                int i143 = 0;
                if (!composer21.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap;
                    i13 = valueOf;
                    if (!Intrinsics.areEqual(composer21.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer21.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer21;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap;
                    i13 = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                Composer composer12 = obj11;
                int i56 = 0;
                ComposerKt.sourceInformationMarkerStart(composer12, -2146769399, $changed$iv3);
                BoxScopeInstance iNSTANCE2 = BoxScopeInstance.INSTANCE;
                i139 |= 6;
                i26 = 0;
                i19 = i31;
                modifier4 = materializeModifier2;
                Composer materialized$iv$iv2 = composer2;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv2, 260130331, "C775@34061L15:Slider.kt#uh7d8r");
                endThumb.invoke(obj12, materialized$iv$iv2, Integer.valueOf(i33 |= i54));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv2);
                ComposerKt.sourceInformationMarkerEnd(composer12);
                obj11.endNode();
                ComposerKt.sourceInformationMarkerEnd(obj11);
                ComposerKt.sourceInformationMarkerEnd(obj11);
                ComposerKt.sourceInformationMarkerEnd(obj11);
                Modifier layoutId = LayoutIdKt.layoutId((Modifier)Modifier.Companion, RangeSliderComponents.TRACK);
                valueOf2 = 6;
                obj5 = 0;
                ComposerKt.sourceInformationMarkerStart(obj11, 733328855, str4);
                topStart = Alignment.Companion.getTopStart();
                str2 = 0;
                ComposerKt.sourceInformationMarkerStart(obj11, -1323940314, $dirty3);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(obj11, 0);
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(obj11, layoutId);
                obj65 = layoutId;
                Function0 function03 = constructor;
                i9 = 0;
                ComposerKt.sourceInformationMarkerStart(obj11, -692256719, str5);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                obj11.startReusableNode();
                if (obj11.getInserting()) {
                    obj11.createNode(function03);
                } else {
                    factory$iv$iv$iv2 = function03;
                    obj11.useNode();
                }
                Composer constructor-impl3 = Updater.constructor-impl(obj11);
                int i117 = 0;
                function02 = factory$iv$iv$iv2;
                Updater.set-impl(constructor-impl3, BoxKt.maybeCachedBoxMeasurePolicy(topStart, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, obj11.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i120 = 0;
                Composer composer20 = constructor-impl3;
                int i133 = 0;
                if (!composer20.getInserting()) {
                    contentAlignment$iv = topStart;
                    i24 = valueOf2;
                    if (!Intrinsics.areEqual(composer20.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer20.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl3.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer20;
                    }
                } else {
                    contentAlignment$iv = topStart;
                    i24 = valueOf2;
                }
                Updater.set-impl(constructor-impl3, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                obj = obj11;
                obj7 = 0;
                ComposerKt.sourceInformationMarkerStart(obj, -2146769399, $changed$iv3);
                i59 |= 6;
                i18 = 0;
                companion4 = i38;
                companion3 = iNSTANCE;
                modifier5 = materializeModifier;
                materialized$iv$iv = composer9;
                ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 260236382, "C777@34168L12:Slider.kt#uh7d8r");
                track.invoke(obj12, materialized$iv$iv, Integer.valueOf(i40 |= i50));
                ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
                ComposerKt.sourceInformationMarkerEnd(obj);
                obj11.endNode();
                ComposerKt.sourceInformationMarkerEnd(obj11);
                ComposerKt.sourceInformationMarkerEnd(obj11);
                ComposerKt.sourceInformationMarkerEnd(obj11);
                ComposerKt.sourceInformationMarkerEnd(obj11);
                $composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd($composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer3.skipToGroupEnd();
                obj8 = obj6;
                $composer2 = $composer3;
                i15 = currentCompositeKeyHash2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new SliderKt.RangeSliderImpl.3(modifier, obj12, enabled, startInteractionSource, endInteractionSource, startThumb, endThumb, obj8, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void Slider(float value, Function1<? super Float, Unit> onValueChange, Modifier modifier, boolean enabled, Function0<Unit> onValueChangeFinished, androidx.compose.material3.SliderColors colors, MutableInteractionSource interactionSource, int steps, Function3<? super androidx.compose.material3.SliderState, ? super Composer, ? super Integer, Unit> thumb, Function3<? super androidx.compose.material3.SliderState, ? super Composer, ? super Integer, Unit> track, ClosedFloatingPointRange<Float> valueRange, Composer $composer, int $changed, int $changed1, int i15) {
        Object obj5;
        int i16;
        Object obj6;
        Object obj;
        Object obj3;
        boolean it$iv;
        Object endRestartGroup;
        int interactionSource2;
        int i19;
        int changed3;
        int defaultsInvalid;
        int colors2;
        Object interactionSource3;
        int i21;
        Object $composer3;
        Object $composer2;
        int $dirty2;
        boolean steps2;
        int $dirty;
        int steps3;
        int $dirty1;
        Object $dirty12;
        int $dirty13;
        int i9;
        int i;
        Object thumb3;
        Object thumb2;
        int i10;
        int i3;
        Object track2;
        Object rememberComposableLambda;
        int i17;
        Object obj2;
        int colors3;
        Object obj7;
        Object modifier2;
        int i22;
        Object valueRange2;
        Object valueRange3;
        int i7;
        boolean z;
        Object enabled2;
        int i12;
        int rememberedValue;
        Object obj4;
        int $dirty14;
        int i2;
        int i11;
        Composer composer;
        Object interactionSource4;
        int i20;
        int changed2;
        int traceInProgress;
        int i8;
        int companion;
        int companion2;
        int i18;
        int i4;
        int i5;
        int i6;
        int i14;
        int changed;
        int $dirty3;
        int i23;
        int i13;
        Object obj27;
        Object obj28;
        boolean obj29;
        int obj30;
        Object obj31;
        androidx.compose.runtime.internal.ComposableLambda obj32;
        Object obj33;
        Object obj34;
        int obj35;
        int obj36;
        final float f = value;
        final Object obj8 = onValueChange;
        final int i59 = $changed;
        final int i61 = i15;
        $composer2 = $composer.startRestartGroup(1191170377);
        ComposerKt.sourceInformation($composer2, "C(Slider)P(9,4,3,1,5)256@12184L8,257@12244L39,259@12372L157,266@12578L114,272@12779L92,278@12998L184:Slider.kt#uh7d8r");
        $dirty2 = $changed;
        if (i61 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i59 & 6 == 0) {
                i9 = $composer2.changed(f) ? 4 : 2;
                $dirty2 |= i9;
            }
        }
        if (i61 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i59 & 48 == 0) {
                i = $composer2.changedInstance(obj8) ? 32 : 16;
                $dirty2 |= i;
            }
        }
        i3 = i61 & 4;
        if (i3 != 0) {
            $dirty2 |= 384;
            obj7 = modifier;
        } else {
            if (i59 & 384 == 0) {
                i22 = $composer2.changed(modifier) ? 256 : 128;
                $dirty2 |= i22;
            } else {
                obj7 = modifier;
            }
        }
        i7 = i61 & 8;
        if (i7 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else {
            if (i59 & 3072 == 0) {
                i12 = $composer2.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i12;
            } else {
                z = enabled;
            }
        }
        rememberedValue = i61 & 16;
        if (rememberedValue != 0) {
            $dirty2 |= 24576;
            obj4 = onValueChangeFinished;
        } else {
            if (i59 & 24576 == 0) {
                i2 = $composer2.changedInstance(onValueChangeFinished) ? 16384 : 8192;
                $dirty2 |= i2;
            } else {
                obj4 = onValueChangeFinished;
            }
        }
        if (i59 & i63 == 0) {
            if (i61 & 32 == 0) {
                i11 = $composer2.changed(colors) ? 131072 : 65536;
            } else {
                obj2 = colors;
            }
            $dirty2 |= i11;
        } else {
            obj2 = colors;
        }
        i20 = i61 & 64;
        traceInProgress = 1572864;
        if (i20 != 0) {
            $dirty2 |= traceInProgress;
            obj5 = interactionSource;
        } else {
            if (i59 & traceInProgress == 0) {
                i8 = $composer2.changed(interactionSource) ? 1048576 : 524288;
                $dirty2 |= i8;
            } else {
                obj5 = interactionSource;
            }
        }
        i17 = i61 & 128;
        companion2 = 12582912;
        if (i17 != 0) {
            $dirty2 |= companion2;
            i16 = steps;
        } else {
            if (i59 & companion2 == 0) {
                i18 = $composer2.changed(steps) ? 8388608 : 4194304;
                $dirty2 |= i18;
            } else {
                i16 = steps;
            }
        }
        int i25 = i61 & 256;
        int i69 = 100663296;
        if (i25 != 0) {
            $dirty2 |= i69;
            i4 = i25;
            obj6 = thumb;
        } else {
            if (i59 & i69 == 0) {
                i4 = i25;
                i5 = $composer2.changedInstance(thumb) ? 67108864 : 33554432;
                $dirty2 |= i5;
            } else {
                i4 = i25;
                obj6 = thumb;
            }
        }
        int i26 = i61 & 512;
        int i71 = 805306368;
        if (i26 != 0) {
            $dirty2 |= i71;
            i6 = i26;
            obj = track;
        } else {
            if (i59 & i71 == 0) {
                i6 = i26;
                i14 = $composer2.changedInstance(track) ? 536870912 : 268435456;
                $dirty2 |= i14;
            } else {
                i6 = i26;
                obj = track;
            }
        }
        if ($changed1 & 6 == 0) {
            if (i61 & 1024 == 0) {
                changed = $composer2.changed(valueRange) ? 4 : 2;
            } else {
                obj3 = valueRange;
            }
            $dirty1 |= changed;
        } else {
            obj3 = valueRange;
        }
        $dirty3 = $dirty2;
        if ($dirty2 & i73 == 306783378 && $dirty1 & 3 == 2) {
            if ($dirty1 & 3 == 2) {
                if (!$composer2.getSkipping()) {
                    $composer2.startDefaults();
                    companion = -458753;
                    if (i59 & 1 != 0) {
                        if ($composer2.getDefaultsInvalid()) {
                            if (i3 != 0) {
                                obj7 = defaultsInvalid;
                            }
                            if (i7 != 0) {
                                z = defaultsInvalid;
                            }
                            if (rememberedValue != 0) {
                                obj4 = defaultsInvalid;
                            }
                            if (i61 & 32 != 0) {
                                obj2 = colors2;
                                $dirty3 = i3;
                            }
                            if (i20 != 0) {
                                ComposerKt.sourceInformationMarkerStart($composer2, -403537365, "CC(remember):Slider.kt#9igjgp");
                                int i32 = 0;
                                i3 = $composer2;
                                i7 = 0;
                                rememberedValue = i3.rememberedValue();
                                i20 = 0;
                                if (rememberedValue == Composer.Companion.getEmpty()) {
                                    int i42 = 0;
                                    i3.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                                } else {
                                    $dirty = rememberedValue;
                                }
                                interactionSource3 = $dirty;
                                ComposerKt.sourceInformationMarkerEnd($composer2);
                            } else {
                                interactionSource3 = interactionSource;
                            }
                            steps3 = i17 != 0 ? 0 : steps;
                            if (i4 != 0) {
                                SliderKt.Slider.6 anon = new SliderKt.Slider.6(interactionSource3, obj2, z);
                                thumb2 = ComposableLambdaKt.rememberComposableLambda(-1756326375, true, anon, $composer2, 54);
                            } else {
                                thumb2 = thumb;
                            }
                            if (i6 != 0) {
                                SliderKt.Slider.7 anon2 = new SliderKt.Slider.7(z, obj2);
                                interactionSource4 = interactionSource3;
                                rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(2083675534, true, anon2, $composer2, 54);
                            } else {
                                interactionSource4 = interactionSource3;
                                interactionSource2 = 1;
                                rememberComposableLambda = track;
                            }
                            if (i61 & 1024 != 0) {
                                valueRange3 = RangesKt.rangeTo(0, 1065353216);
                                rememberedValue = $dirty15;
                                $dirty13 = $dirty3;
                            } else {
                                valueRange3 = valueRange;
                                rememberedValue = $dirty1;
                                $dirty13 = $dirty3;
                            }
                        } else {
                            $composer2.skipToGroupEnd();
                            if (i61 & 32 != 0) {
                                $dirty3 = i21;
                            }
                            if (i61 & 1024 != 0) {
                                $dirty1 &= -15;
                            }
                            interactionSource4 = interactionSource;
                            steps3 = steps;
                            thumb2 = thumb;
                            rememberComposableLambda = track;
                            valueRange3 = valueRange;
                            rememberedValue = $dirty1;
                            $dirty13 = $dirty3;
                            interactionSource2 = 1;
                        }
                    } else {
                    }
                    $composer2.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        obj32 = thumb2;
                        ComposerKt.traceEventStart(1191170377, $dirty13, rememberedValue, "androidx.compose.material3.Slider (Slider.kt:270)");
                    } else {
                        obj32 = thumb2;
                    }
                    ComposerKt.sourceInformationMarkerStart($composer2, -403520192, "CC(remember):Slider.kt#9igjgp");
                    i19 = i28 &= $dirty13 == 8388608 ? 1 : 0;
                    i23 = 6;
                    if (i44 ^= 6 > 4) {
                        if (!$composer2.changed(valueRange3)) {
                            i13 = rememberedValue & 6 == 4 ? 1 : changed3;
                        } else {
                        }
                    } else {
                    }
                    Composer composer2 = $composer2;
                    int i64 = 0;
                    it$iv = composer2.rememberedValue();
                    i8 = 0;
                    if (obj27 | i13 == 0) {
                        obj36 = $composer2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            $composer2 = 0;
                            obj28 = it$iv;
                            it$iv = new SliderState(f, steps3, obj4, valueRange3);
                            composer2.updateRememberedValue(it$iv);
                        } else {
                            obj28 = it$iv;
                        }
                    } else {
                        obj36 = $composer2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(obj36);
                    (SliderState)it$iv.setOnValueChangeFinished(obj4);
                    it$iv.setOnValueChange$material3_release(obj8);
                    it$iv.setValue(f);
                    obj34 = obj36;
                    obj31 = interactionSource4;
                    SliderKt.Slider(it$iv, obj7, z, 0, obj31, obj32, rememberComposableLambda, obj34, i40 |= i52, 8);
                    composer = obj34;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    track2 = obj9;
                    $composer3 = obj7;
                    modifier2 = composableLambda;
                    thumb3 = obj2;
                    colors3 = steps3;
                    steps2 = z;
                    enabled2 = valueRange3;
                    valueRange2 = composableLambda2;
                    $dirty3 = $dirty13;
                    $dirty12 = obj4;
                    $dirty14 = rememberedValue;
                } else {
                    $composer2.skipToGroupEnd();
                    $dirty14 = $dirty1;
                    $dirty12 = obj10;
                    track2 = interactionSource;
                    valueRange2 = track;
                    composer = $composer2;
                    thumb3 = obj2;
                    $composer3 = obj7;
                    steps2 = z;
                    colors3 = steps;
                    modifier2 = thumb;
                    enabled2 = valueRange;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            obj27 = $dirty14;
            endRestartGroup = new SliderKt.Slider.8(f, obj8, $composer3, steps2, $dirty12, thumb3, track2, colors3, modifier2, valueRange2, enabled2, i59, $changed1, i61);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj27 = $dirty14;
        }
    }

    public static final void Slider(float value, Function1<? super Float, Unit> onValueChange, Modifier modifier, boolean enabled, ClosedFloatingPointRange<Float> valueRange, int steps, Function0<Unit> onValueChangeFinished, androidx.compose.material3.SliderColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i12) {
        Object obj2;
        Object obj5;
        boolean traceInProgress2;
        int defaultsInvalid;
        int rangeTo;
        Object interactionSource2;
        Object $i$a$CacheSliderKt$Slider$1;
        int $dirty5;
        Composer restartGroup;
        int $dirty2;
        int $dirty4;
        int i13;
        int i6;
        Object $dirty3;
        int $dirty;
        Object obj10;
        boolean z;
        int modifier2;
        int i15;
        Object obj6;
        int i19;
        boolean traceInProgress;
        boolean str;
        int i20;
        int i8;
        Object obj3;
        Object obj7;
        boolean changed2;
        Object obj4;
        int i10;
        int i21;
        Object obj8;
        float f;
        int i;
        Object obj;
        int i17;
        int i7;
        Object onValueChangeFinished2;
        int i9;
        int i14;
        int changed;
        int i5;
        int i18;
        int i2;
        Composer.Companion companion;
        int i16;
        androidx.compose.runtime.internal.ComposableLambda composableLambda2;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Object obj9;
        Composer composer;
        int i3;
        int i11;
        int i4;
        androidx.compose.material3.SliderColors obj29;
        final int i70 = $changed;
        final int i71 = i12;
        restartGroup = $composer.startRestartGroup(-202044027);
        ComposerKt.sourceInformation(restartGroup, "C(Slider)P(7,4,3,1,8,6,5)167@8058L8,168@8118L39,179@8458L181,186@8657L122,170@8166L652:Slider.kt#uh7d8r");
        $dirty2 = $changed;
        if (i71 & 1 != 0) {
            $dirty2 |= 6;
            f = value;
        } else {
            if (i70 & 6 == 0) {
                i13 = restartGroup.changed(value) ? 4 : 2;
                $dirty2 |= i13;
            } else {
                f = value;
            }
        }
        if (i71 & 2 != 0) {
            $dirty2 |= 48;
            obj = onValueChange;
        } else {
            if (i70 & 48 == 0) {
                i6 = restartGroup.changedInstance(onValueChange) ? 32 : 16;
                $dirty2 |= i6;
            } else {
                obj = onValueChange;
            }
        }
        int i32 = i71 & 4;
        if (i32 != 0) {
            $dirty2 |= 384;
            obj10 = modifier;
        } else {
            if (i70 & 384 == 0) {
                i15 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i15;
            } else {
                obj10 = modifier;
            }
        }
        i19 = i71 & 8;
        if (i19 != 0) {
            $dirty2 |= 3072;
            str = enabled;
        } else {
            if (i70 & 3072 == 0) {
                i8 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i8;
            } else {
                str = enabled;
            }
        }
        if (i70 & 24576 == 0) {
            if (i71 & 16 == 0) {
                changed2 = restartGroup.changed(valueRange) ? 16384 : 8192;
            } else {
                obj3 = valueRange;
            }
            $dirty2 |= changed2;
        } else {
            obj3 = valueRange;
        }
        i10 = i71 & 32;
        int i68 = 196608;
        if (i10 != 0) {
            $dirty2 |= i68;
            i21 = steps;
        } else {
            if (i68 &= i70 == 0) {
                i17 = restartGroup.changed(steps) ? 131072 : 65536;
                $dirty2 |= i17;
            } else {
                i21 = steps;
            }
        }
        i7 = i71 & 64;
        int i72 = 1572864;
        if (i7 != 0) {
            $dirty2 |= i72;
            onValueChangeFinished2 = onValueChangeFinished;
        } else {
            if (i72 &= i70 == 0) {
                i9 = restartGroup.changedInstance(onValueChangeFinished) ? 1048576 : 524288;
                $dirty2 |= i9;
            } else {
                onValueChangeFinished2 = onValueChangeFinished;
            }
        }
        if (i70 & i74 == 0) {
            if (i71 & 128 == 0) {
                changed = restartGroup.changed(colors) ? 8388608 : 4194304;
            } else {
                obj2 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj2 = colors;
        }
        int i24 = i71 & 256;
        int i75 = 100663296;
        if (i24 != 0) {
            $dirty2 |= i75;
            i5 = i24;
            obj5 = interactionSource;
        } else {
            if (i70 & i75 == 0) {
                i5 = i24;
                i18 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty2 |= i18;
            } else {
                i5 = i24;
                obj5 = interactionSource;
            }
        }
        final int obj36 = $dirty2;
        if ($dirty2 & i2 == 38347922) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i29 = -29360129;
                companion = -57345;
                if (i70 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i32 != 0) {
                            obj10 = defaultsInvalid;
                        }
                        if (i19 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i71 & 16 != 0) {
                            $dirty = obj36 & companion;
                            obj3 = rangeTo;
                        } else {
                            $dirty = obj36;
                        }
                        if (i10 != 0) {
                            i21 = rangeTo;
                        }
                        if (i7 != 0) {
                            onValueChangeFinished2 = rangeTo;
                        }
                        if (i71 & 128 != 0) {
                            interactionSource2 = SliderDefaults.INSTANCE.colors(restartGroup, 6);
                            $dirty &= i29;
                        } else {
                            interactionSource2 = colors;
                        }
                        if (i5 != 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, -403669397, "CC(remember):Slider.kt#9igjgp");
                            int i31 = 0;
                            i19 = restartGroup;
                            i10 = 0;
                            Object rememberedValue = i19.rememberedValue();
                            i5 = 0;
                            if (rememberedValue == Composer.Companion.getEmpty()) {
                                int i26 = 0;
                                i19.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                            } else {
                                $i$a$CacheSliderKt$Slider$1 = rememberedValue;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty4 = $i$a$CacheSliderKt$Slider$1;
                            i7 = obj10;
                            obj9 = obj3;
                            i16 = i21;
                            i14 = onValueChangeFinished2;
                            modifier2 = -202044027;
                            interactionSource2 = obj29;
                            onValueChangeFinished2 = str;
                        } else {
                            obj29 = interactionSource2;
                            $dirty4 = interactionSource;
                            i7 = obj10;
                            obj9 = obj3;
                            i16 = i21;
                            i14 = onValueChangeFinished2;
                            modifier2 = -202044027;
                            onValueChangeFinished2 = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        $dirty5 = i71 & 16 != 0 ? obj36 & companion : obj36;
                        if (i71 & 128 != 0) {
                            $dirty4 = interactionSource;
                            $dirty = $dirty6;
                            i7 = obj10;
                            obj9 = obj3;
                            i16 = i21;
                            i14 = onValueChangeFinished2;
                            modifier2 = -202044027;
                            interactionSource2 = colors;
                            onValueChangeFinished2 = str;
                        } else {
                            $dirty4 = interactionSource;
                            $dirty = $dirty5;
                            i7 = obj10;
                            obj9 = obj3;
                            i16 = i21;
                            i14 = onValueChangeFinished2;
                            modifier2 = -202044027;
                            interactionSource2 = colors;
                            onValueChangeFinished2 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(modifier2, $dirty, -1, "androidx.compose.material3.Slider (Slider.kt:169)");
                }
                SliderKt.Slider.2 anon = new SliderKt.Slider.2($dirty4, interactionSource2, onValueChangeFinished2);
                int i59 = 1;
                int i67 = 54;
                SliderKt.Slider.3 anon2 = new SliderKt.Slider.3(onValueChangeFinished2, interactionSource2);
                i5 = interactionSource2;
                i2 = $dirty4;
                SliderKt.Slider(f, obj, i7, onValueChangeFinished2, i14, i5, i2, i16, (Function3)ComposableLambdaKt.rememberComposableLambda(308249025, i59, anon, restartGroup, i67), (Function3)ComposableLambdaKt.rememberComposableLambda(-1843234110, i59, anon2, restartGroup, i67), obj9, restartGroup, i42 | i58, i43 & 14, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i = $dirty;
                $dirty3 = i7;
                z = onValueChangeFinished2;
                obj7 = i14;
                obj4 = i5;
                obj8 = i2;
                i20 = i16;
                obj6 = obj9;
            } else {
                restartGroup.skipToGroupEnd();
                obj4 = colors;
                i = obj36;
                composer = restartGroup;
                $dirty3 = obj10;
                z = str;
                obj6 = obj3;
                i20 = i21;
                obj7 = onValueChangeFinished2;
                obj8 = interactionSource;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new SliderKt.Slider.4(value, onValueChange, $dirty3, z, obj6, i20, obj7, obj4, obj8, i70, i71);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void Slider(androidx.compose.material3.SliderState state, Modifier modifier, boolean enabled, androidx.compose.material3.SliderColors colors, MutableInteractionSource interactionSource, Function3<? super androidx.compose.material3.SliderState, ? super Composer, ? super Integer, Unit> thumb, Function3<? super androidx.compose.material3.SliderState, ? super Composer, ? super Integer, Unit> track, Composer $composer, int $changed, int i10) {
        int traceInProgress2;
        int modifier2;
        boolean traceInProgress;
        int defaultsInvalid;
        Object $i$a$CacheSliderKt$Slider$9;
        int $dirty;
        int i3;
        int rememberComposableLambda;
        int i2;
        Object obj4;
        Object enabled2;
        boolean z2;
        int i8;
        int colors3;
        Object obj6;
        boolean z;
        int i7;
        Object obj3;
        int i12;
        Object obj;
        Object colors2;
        int changed;
        int i6;
        Object obj7;
        Object interactionSource2;
        Object obj2;
        int i9;
        int i;
        boolean i4;
        Object thumb2;
        int i13;
        Object i11;
        Object obj5;
        int i5;
        int i14;
        Composer.Companion companion;
        Object obj19;
        final int i41 = $changed;
        final Composer restartGroup = $composer.startRestartGroup(-1303883986);
        ComposerKt.sourceInformation(restartGroup, "C(Slider)P(4,3,1)339@15682L8,340@15742L39,341@15830L157,348@16036L114,354@16217L188:Slider.kt#uh7d8r");
        $dirty = $changed;
        if (i10 & 1 != 0) {
            $dirty |= 6;
            obj2 = state;
        } else {
            if (i41 & 6 == 0) {
                i3 = restartGroup.changedInstance(state) ? 4 : 2;
                $dirty |= i3;
            } else {
                obj2 = state;
            }
        }
        int i24 = i10 & 2;
        if (i24 != 0) {
            $dirty |= 48;
            enabled2 = modifier;
        } else {
            if (i41 & 48 == 0) {
                i8 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i8;
            } else {
                enabled2 = modifier;
            }
        }
        colors3 = i10 & 4;
        if (colors3 != 0) {
            $dirty |= 384;
            z = enabled;
        } else {
            if (i41 & 384 == 0) {
                i12 = restartGroup.changed(enabled) ? 256 : 128;
                $dirty |= i12;
            } else {
                z = enabled;
            }
        }
        if (i41 & 3072 == 0) {
            if (i10 & 8 == 0) {
                changed = restartGroup.changed(colors) ? 2048 : 1024;
            } else {
                obj = colors;
            }
            $dirty |= changed;
        } else {
            obj = colors;
        }
        i6 = i10 & 16;
        if (i6 != 0) {
            $dirty |= 24576;
            interactionSource2 = interactionSource;
        } else {
            if (i41 & 24576 == 0) {
                i = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty |= i;
            } else {
                interactionSource2 = interactionSource;
            }
        }
        i4 = i10 & 32;
        int i43 = 196608;
        if (i4 != 0) {
            $dirty |= i43;
            thumb2 = thumb;
        } else {
            if (i43 &= i41 == 0) {
                i13 = restartGroup.changedInstance(thumb) ? 131072 : 65536;
                $dirty |= i13;
            } else {
                thumb2 = thumb;
            }
        }
        i11 = i10 & 64;
        int i45 = 1572864;
        if (i11 != 0) {
            $dirty |= i45;
            obj5 = track;
        } else {
            if (i45 &= i41 == 0) {
                i5 = restartGroup.changedInstance(track) ? 1048576 : 524288;
                $dirty |= i5;
            } else {
                obj5 = track;
            }
        }
        if ($dirty & i14 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i41 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i24 != 0) {
                            $i$a$CacheSliderKt$Slider$9 = Modifier.Companion;
                        } else {
                            $i$a$CacheSliderKt$Slider$9 = enabled2;
                        }
                        enabled2 = colors3 != 0 ? 1 : z;
                        if (i10 & 8 != 0) {
                            $dirty &= -7169;
                            obj = colors3;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, -403425429, "CC(remember):Slider.kt#9igjgp");
                            colors3 = 0;
                            z = restartGroup;
                            i6 = 0;
                            rememberComposableLambda = z.rememberedValue();
                            i14 = 0;
                            obj19 = $i$a$CacheSliderKt$Slider$9;
                            if (rememberComposableLambda == Composer.Companion.getEmpty()) {
                                int i23 = 0;
                                z.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                            } else {
                                $i$a$CacheSliderKt$Slider$9 = rememberComposableLambda;
                            }
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            interactionSource2 = $i$a$CacheSliderKt$Slider$9;
                        } else {
                            obj19 = $i$a$CacheSliderKt$Slider$9;
                        }
                        modifier2 = 54;
                        if (i4 != 0) {
                            SliderKt.Slider.10 anon = new SliderKt.Slider.10(interactionSource2, obj, enabled2);
                            thumb2 = rememberComposableLambda;
                        } else {
                            i7 = 1;
                        }
                        if (i11 != 0) {
                            rememberComposableLambda = new SliderKt.Slider.11(enabled2, obj);
                            obj5 = modifier2;
                            i4 = enabled2;
                            i11 = thumb2;
                            thumb2 = interactionSource2;
                            interactionSource2 = obj19;
                        } else {
                            i4 = enabled2;
                            i11 = thumb2;
                            thumb2 = interactionSource2;
                            interactionSource2 = obj19;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        i4 = z;
                        i11 = thumb2;
                        i7 = 1;
                        thumb2 = interactionSource2;
                        interactionSource2 = enabled2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1303883986, $dirty, -1, "androidx.compose.material3.Slider (Slider.kt:351)");
                }
                i2 = obj2.getSteps() >= 0 ? i7 : 0;
                if (i2 == 0) {
                } else {
                    SliderKt.SliderImpl(interactionSource2, obj2, i4, thumb2, i11, obj5, restartGroup, i21 | i33);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    obj6 = obj;
                    obj4 = interactionSource2;
                    z2 = i4;
                    obj3 = thumb2;
                    colors2 = i11;
                    i9 = $dirty;
                    obj7 = obj5;
                    ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        traceInProgress2 = new SliderKt.Slider.13(state, obj4, z2, obj6, obj3, colors2, obj7, i41, i10);
                        endRestartGroup.updateScope((Function2)traceInProgress2);
                    }
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj4 = enabled2;
                z2 = z;
                obj6 = obj;
                obj3 = interactionSource2;
                colors2 = thumb2;
                i9 = $dirty;
                obj7 = obj5;
            }
        } else {
        }
        int i22 = 0;
        IllegalArgumentException $i$a$RequireSliderKt$Slider$12 = new IllegalArgumentException("steps should be >= 0".toString());
        throw $i$a$RequireSliderKt$Slider$12;
    }

    private static final void SliderImpl(Modifier modifier, androidx.compose.material3.SliderState state, boolean enabled, MutableInteractionSource interactionSource, Function3<? super androidx.compose.material3.SliderState, ? super Composer, ? super Integer, Unit> thumb, Function3<? super androidx.compose.material3.SliderState, ? super Composer, ? super Integer, Unit> track, Composer $composer, int $changed) {
        androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy;
        boolean traceInProgress;
        Object $i$a$CacheSliderKt$SliderImpl$1$1;
        Function0 factory$iv$iv$iv2;
        Object changedInstance;
        Object obj;
        Object anon;
        Function0 factory$iv$iv;
        boolean currentCompositionLocalMap2;
        Function0 factory$iv$iv$iv;
        Composer z;
        int i25;
        int obj4;
        int i16;
        Object valueOf2;
        Composer composer4;
        int i8;
        int $dirty;
        boolean $dirty2;
        Composer composer2;
        Object maybeCachedBoxMeasurePolicy2;
        Object obj2;
        Composer composer9;
        Integer valueOf;
        int i20;
        int i26;
        int i2;
        int i13;
        int i12;
        int i23;
        int topStart;
        boolean traceInProgress2;
        int str;
        Object empty2;
        Composer composer8;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        int currentCompositeKeyHash;
        int empty;
        Modifier materializeModifier;
        Object anon2;
        Modifier i14;
        int i3;
        int i;
        int i22;
        Modifier modifier3;
        Function0 function0;
        Composer.Companion companion;
        Object obj3;
        int i7;
        Composer composer7;
        int i4;
        int i5;
        Modifier modifier4;
        int i10;
        Composer.Companion companion2;
        int i11;
        int $changed$iv;
        boolean invalid$iv;
        int i15;
        Modifier modifier2;
        int i6;
        int i21;
        Function0 function02;
        int i24;
        BoxScopeInstance boxScopeInstance;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        Composer composer3;
        Composer composer6;
        int i19;
        BoxScopeInstance iNSTANCE;
        androidx.compose.runtime.CompositionLocalMap map;
        int i18;
        Composer composer;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        int i9;
        Composer composer5;
        int i17;
        int obj56;
        final Object obj5 = state;
        z = enabled;
        obj4 = interactionSource;
        traceInProgress = thumb;
        i14 = $changed;
        i8 = 1390990089;
        final Composer restartGroup = $composer.startRestartGroup(i8);
        ComposerKt.sourceInformation(restartGroup, "C(SliderImpl)P(2,3)665@29717L7,673@30073L28,698@30935L1093,678@30197L1831:Slider.kt#uh7d8r");
        if (i14 & 6 == 0) {
            i20 = restartGroup.changed(modifier) ? 4 : 2;
            $dirty |= i20;
        } else {
            obj2 = modifier;
        }
        if (i14 & 48 == 0) {
            i26 = restartGroup.changedInstance(obj5) ? 32 : 16;
            $dirty |= i26;
        }
        if (i14 & 384 == 0) {
            i2 = restartGroup.changed(z) ? 256 : 128;
            $dirty |= i2;
        }
        if (i14 & 3072 == 0) {
            i13 = restartGroup.changed(obj4) ? 2048 : 1024;
            $dirty |= i13;
        }
        if (i14 & 24576 == 0) {
            i12 = restartGroup.changedInstance(traceInProgress) ? 16384 : 8192;
            $dirty |= i12;
        }
        if (i65 &= i14 == 0) {
            i23 = restartGroup.changedInstance(track) ? 131072 : 65536;
            $dirty |= i23;
        }
        if (i66 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i8, $dirty, -1, "androidx.compose.material3.SliderImpl (Slider.kt:664)");
                }
                int i67 = 0;
                int i70 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i68 = 0;
                i16 = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? 1 : i68;
                obj5.setRtl$material3_release(i16);
                int i84 = i68;
                Object obj6 = obj5;
                empty2 = "CC(remember):Slider.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 174725888, empty2);
                Composer composer13 = restartGroup;
                int i89 = 0;
                Object rememberedValue6 = composer13.rememberedValue();
                int i92 = 0;
                if (!restartGroup.changedInstance(obj5)) {
                    if (rememberedValue6 == Composer.Companion.getEmpty()) {
                        int i71 = 0;
                        obj3 = obj6;
                        anon = new SliderKt.SliderImpl.drag.1.1(obj5, 0);
                        composer13.updateRememberedValue((Function3)anon);
                    } else {
                        obj3 = obj6;
                        anon = rememberedValue6;
                        composer8 = composer13;
                        i25 = 0;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i88 = 0;
                MutableInteractionSource mutableInteractionSource2 = interactionSource;
                i3 = $dirty;
                String str2 = str8;
                int i90 = 0;
                $dirty2 = enabled;
                Modifier draggable$default = DraggableKt.draggable$default((Modifier)Modifier.Companion, obj3, Orientation.Horizontal, $dirty2, mutableInteractionSource2, obj5.isDragging$material3_release(), 0, (Function3)anon, obj5.isRtl$material3_release(), 32, i88);
                Modifier then2 = FocusableKt.focusable(SliderKt.sliderSemantics(SizeKt.requiredSizeIn-qDBjuR0$default(InteractiveComponentSizeKt.minimumInteractiveComponentSize(modifier), SliderKt.ThumbWidth, SliderKt.TrackHeight, 0, 0, 12, i88), obj5, $dirty2), $dirty2, mutableInteractionSource2).then(SliderKt.sliderTapModifier((Modifier)Modifier.Companion, obj5, obj4, z)).then(draggable$default);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 174754537, str2);
                Composer composer12 = restartGroup;
                int i73 = 0;
                Object rememberedValue5 = composer12.rememberedValue();
                int i83 = 0;
                if (!restartGroup.changedInstance(obj5)) {
                    if (rememberedValue5 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon2 = new SliderKt.SliderImpl.2.1(obj5);
                        composer12.updateRememberedValue((MeasurePolicy)anon2);
                    } else {
                        anon2 = rememberedValue5;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                valueOf = i90;
                String str6 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, str6);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i90);
                androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap3 = restartGroup.getCurrentCompositionLocalMap();
                modifier3 = draggable$default;
                Function0 function03 = constructor;
                i = 0;
                String str3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, str3);
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function03);
                } else {
                    factory$iv$iv = function03;
                    restartGroup.useNode();
                }
                function0 = factory$iv$iv;
                Composer constructor-impl2 = Updater.constructor-impl(restartGroup);
                int i94 = 0;
                modifier4 = then2;
                Updater.set-impl(constructor-impl2, (MeasurePolicy)anon2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap3, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i95 = 0;
                Composer composer14 = constructor-impl2;
                companion2 = 0;
                if (!composer14.getInserting()) {
                    $changed$iv = valueOf;
                    if (!Intrinsics.areEqual(composer14.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer14.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer9 = composer14;
                    }
                } else {
                    $changed$iv = valueOf;
                }
                Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier(restartGroup, then2), ComposeUiNode.Companion.getSetModifier());
                valueOf2 = restartGroup;
                i4 = i41;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -610171494, "C682@30354L85,680@30227L271,688@30511L74:Slider.kt#uh7d8r");
                i5 = i53;
                i7 = i69;
                int $i$a$LayoutSliderKt$SliderImpl$1 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf2, 534510168, str2);
                changedInstance = restartGroup.changedInstance(obj5);
                Composer composer11 = valueOf2;
                int i63 = 0;
                Object rememberedValue4 = composer11.rememberedValue();
                int i96 = 0;
                if (changedInstance == null) {
                    invalid$iv = changedInstance;
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        companion2 = invalid$iv2;
                        $i$a$CacheSliderKt$SliderImpl$1$1 = new SliderKt.SliderImpl.1.1.1(obj5);
                        composer11.updateRememberedValue((Function1)$i$a$CacheSliderKt$SliderImpl$1$1);
                    } else {
                        $i$a$CacheSliderKt$SliderImpl$1$1 = rememberedValue4;
                    }
                } else {
                    invalid$iv = changedInstance;
                }
                ComposerKt.sourceInformationMarkerEnd(valueOf2);
                Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(SizeKt.wrapContentWidth$default(LayoutIdKt.layoutId((Modifier)Modifier.Companion, SliderComponents.THUMB), $i$a$LayoutSliderKt$SliderImpl$1, false, 3, $i$a$LayoutSliderKt$SliderImpl$1), (Function1)$i$a$CacheSliderKt$SliderImpl$1$1);
                String str5 = "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(valueOf2, 733328855, str5);
                Alignment topStart2 = Alignment.Companion.getTopStart();
                int i97 = i42;
                int $changed$iv4 = 0;
                int i99 = i55;
                maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(topStart2, $changed$iv4);
                int i102 = 0;
                int i104 = $changed$iv4;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -1323940314, str6);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(valueOf2, 0);
                currentCompositionLocalMap2 = valueOf2.getCurrentCompositionLocalMap();
                Alignment alignment = topStart2;
                Modifier modifier6 = onSizeChanged;
                Function0 function05 = constructor3;
                int i105 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -692256719, str3);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                valueOf2.startReusableNode();
                if (valueOf2.getInserting()) {
                    valueOf2.createNode(function05);
                } else {
                    factory$iv$iv$iv2 = function05;
                    valueOf2.useNode();
                }
                Function0 function06 = factory$iv$iv$iv2;
                Composer constructor-impl = Updater.constructor-impl(valueOf2);
                int i108 = 0;
                map = currentCompositionLocalMap3;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy2, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i109 = 0;
                Composer composer16 = constructor-impl;
                int i112 = 0;
                if (!composer16.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                    if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash3), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer16;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap2;
                    measurePolicy = maybeCachedBoxMeasurePolicy2;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(valueOf2, onSizeChanged), ComposeUiNode.Companion.getSetModifier());
                Composer composer10 = valueOf2;
                i19 = i35;
                String $changed$iv3 = "C73@3429L9:Box.kt#2w3rfo";
                ComposerKt.sourceInformationMarkerStart(composer10, -2146769399, $changed$iv3);
                iNSTANCE = BoxScopeInstance.INSTANCE;
                i111 |= 6;
                i9 = 0;
                i17 = i56;
                Composer $i$a$LayoutBoxKt$Box$1$iv = composer;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutBoxKt$Box$1$iv, -469300363, "C686@30472L12:Slider.kt#uh7d8r");
                traceInProgress.invoke(obj5, $i$a$LayoutBoxKt$Box$1$iv, Integer.valueOf(i45 |= i78));
                ComposerKt.sourceInformationMarkerEnd($i$a$LayoutBoxKt$Box$1$iv);
                ComposerKt.sourceInformationMarkerEnd(composer10);
                valueOf2.endNode();
                ComposerKt.sourceInformationMarkerEnd(valueOf2);
                ComposerKt.sourceInformationMarkerEnd(valueOf2);
                ComposerKt.sourceInformationMarkerEnd(valueOf2);
                Modifier layoutId2 = LayoutIdKt.layoutId((Modifier)Modifier.Companion, SliderComponents.TRACK);
                int i57 = 6;
                obj2 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf2, 733328855, str5);
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                i11 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -1323940314, str6);
                obj56 = currentCompositeKeyHash2;
                modifier2 = layoutId2;
                Function0 function04 = constructor2;
                i22 = 0;
                ComposerKt.sourceInformationMarkerStart(valueOf2, -692256719, str3);
                if (!applier3 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                valueOf2.startReusableNode();
                if (valueOf2.getInserting()) {
                    valueOf2.createNode(function04);
                } else {
                    factory$iv$iv$iv = function04;
                    valueOf2.useNode();
                }
                Composer constructor-impl3 = Updater.constructor-impl(valueOf2);
                int i93 = 0;
                function02 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl3, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl3, valueOf2.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i103 = 0;
                Composer composer15 = constructor-impl3;
                int i106 = 0;
                if (!composer15.getInserting()) {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    composer3 = valueOf2;
                    if (!Intrinsics.areEqual(composer15.rememberedValue(), Integer.valueOf(obj56))) {
                        composer15.updateRememberedValue(Integer.valueOf(obj56));
                        constructor-impl3.apply(Integer.valueOf(obj56), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer4 = composer15;
                    }
                } else {
                    measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                    composer3 = valueOf2;
                }
                Updater.set-impl(constructor-impl3, ComposedModifierKt.materializeModifier(valueOf2, layoutId2), ComposeUiNode.Companion.getSetModifier());
                z = composer3;
                obj4 = 0;
                ComposerKt.sourceInformationMarkerStart(z, -2146769399, $changed$iv3);
                i51 |= 6;
                composer7 = z;
                i6 = 0;
                i24 = i28;
                boxScopeInstance = iNSTANCE2;
                ComposerKt.sourceInformationMarkerStart(z, -469202155, "C688@30571L12:Slider.kt#uh7d8r");
                track.invoke(obj5, z, Integer.valueOf(i30 |= i37));
                ComposerKt.sourceInformationMarkerEnd(z);
                ComposerKt.sourceInformationMarkerEnd(z);
                composer3.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i3 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new SliderKt.SliderImpl.3(modifier, obj5, enabled, interactionSource, thumb, obj, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final long SliderRange(float start, float endInclusive) {
        boolean naN;
        int i;
        int i3;
        int cmp;
        int i2;
        long l;
        int i6 = 0;
        if (Float.isNaN(start) && Float.isNaN(endInclusive)) {
            i = Float.isNaN(endInclusive) ? i3 : i6;
        } else {
        }
        if (i == 0) {
            if (Double.compare(d, i2) <= 0) {
            } else {
                i3 = i6;
            }
        }
        if (i3 == 0) {
        } else {
            int i5 = 0;
            long l2 = (long)floatToRawIntBits;
            return SliderRange.constructor-impl(i9 | i10);
        }
        int i4 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("start(").append(start).append(") must be <= endInclusive(").append(endInclusive).append(')').toString().toString());
        throw illegalArgumentException;
    }

    public static final long SliderRange(ClosedFloatingPointRange<Float> range) {
        boolean naN;
        int i;
        int i2;
        int cmp;
        int i3;
        long l;
        float floatValue = (Number)range.getStart().floatValue();
        float floatValue2 = (Number)range.getEndInclusive().floatValue();
        int i6 = 0;
        if (Float.isNaN(floatValue) && Float.isNaN(floatValue2)) {
            i = Float.isNaN(floatValue2) ? i2 : i6;
        } else {
        }
        if (i == 0) {
            if (Double.compare(d, i3) <= 0) {
            } else {
                i2 = i6;
            }
        }
        if (i2 == 0) {
        } else {
            int i5 = 0;
            long l2 = (long)floatToRawIntBits;
            return SliderRange.constructor-impl(i9 | i10);
        }
        int i4 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("ClosedFloatingPointRange<Float>.start(").append(floatValue).append(") must be <= ClosedFloatingPoint.endInclusive(").append(floatValue2).append(')').toString().toString());
        throw illegalArgumentException;
    }

    public static final void access$RangeSliderImpl(Modifier modifier, androidx.compose.material3.RangeSliderState state, boolean enabled, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, Function3 startThumb, Function3 endThumb, Function3 track, Composer $composer, int $changed) {
        SliderKt.RangeSliderImpl(modifier, state, enabled, startInteractionSource, endInteractionSource, startThumb, endThumb, track, $composer, $changed);
    }

    public static final void access$SliderImpl(Modifier modifier, androidx.compose.material3.SliderState state, boolean enabled, MutableInteractionSource interactionSource, Function3 thumb, Function3 track, Composer $composer, int $changed) {
        SliderKt.SliderImpl(modifier, state, enabled, interactionSource, thumb, track, $composer, $changed);
    }

    public static final Object access$awaitSlop-8vUncbI(AwaitPointerEventScope $receiver, long id, int type, Continuation $completion) {
        return SliderKt.awaitSlop-8vUncbI($receiver, id, type, $completion);
    }

    public static final float access$calcFraction(float a, float b, float pos) {
        return SliderKt.calcFraction(a, b, pos);
    }

    public static final long access$getThumbSize$p() {
        return SliderKt.ThumbSize;
    }

    public static final float access$getThumbTrackGapSize$p() {
        return SliderKt.ThumbTrackGapSize;
    }

    public static final float access$getTrackInsideCornerSize$p() {
        return SliderKt.TrackInsideCornerSize;
    }

    public static final float access$scale(float a1, float b1, float x1, float a2, float b2) {
        return SliderKt.scale(a1, b1, x1, a2, b2);
    }

    public static final long access$scale-ziovWd0(float a1, float b1, long x, float a2, float b2) {
        return SliderKt.scale-ziovWd0(a1, b1, x, a2, b2);
    }

    public static final float access$snapValueToTick(float current, float[] tickFractions, float minPx, float maxPx) {
        return SliderKt.snapValueToTick(current, tickFractions, minPx, maxPx);
    }

    public static final float[] access$stepsToTickFractions(int steps) {
        return SliderKt.stepsToTickFractions(steps);
    }

    private static final Object awaitSlop-8vUncbI(AwaitPointerEventScope awaitPointerEventScope, long l2, int i3, Continuation<? super Pair<PointerInputChange, Float>> continuation4) {
        boolean anon;
        int i4;
        int label;
        int i2;
        int i;
        androidx.compose.material3.SliderKt.awaitSlop.postPointerSlop.1 anon2;
        Object obj7;
        Object obj8;
        int obj9;
        Object obj11;
        anon = obj11;
        i2 = Integer.MIN_VALUE;
        if (obj11 instanceof SliderKt.awaitSlop.1 && label2 &= i2 != 0) {
            anon = obj11;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon.label = obj11 -= i2;
            } else {
                anon = new SliderKt.awaitSlop.1(obj11);
            }
        } else {
        }
        final androidx.compose.material3.SliderKt.awaitSlop.1 anon3 = anon;
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
        int i2;
        int i;
        int i3;
        final int i6 = 0;
        i2 = Float.compare(i4, i6) == 0 ? 1 : 0;
        if (i2 != 0) {
            i = i6;
        } else {
            i5 /= i3;
        }
        return RangesKt.coerceIn(i, i6, 1065353216);
    }

    public static final float getThumbWidth() {
        return SliderKt.ThumbWidth;
    }

    public static final float getTrackHeight() {
        return SliderKt.TrackHeight;
    }

    public static final boolean isSpecified-If1S1O4(long $this$isSpecified) {
        int i;
        i = Long.compare($this$isSpecified, unspecified-FYbKRX4) != 0 ? 1 : 0;
        return i;
    }

    public static void isSpecified-If1S1O4$annotations(long l) {
    }

    private static final Modifier rangeSliderEndThumbSemantics(Modifier $this$rangeSliderEndThumbSemantics, androidx.compose.material3.RangeSliderState state, boolean enabled) {
        ClosedFloatingPointRange rangeTo = RangesKt.rangeTo(state.getActiveRangeStart(), (Number)state.getValueRange().getEndInclusive().floatValue());
        SliderKt.rangeSliderEndThumbSemantics.1 anon = new SliderKt.rangeSliderEndThumbSemantics.1(enabled, rangeTo, state);
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default($this$rangeSliderEndThumbSemantics, false, (Function1)anon, 1, 0).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), state.getActiveRangeEnd(), rangeTo, state.getEndSteps$material3_release());
    }

    private static final Modifier rangeSliderPressDragModifier(Modifier $this$rangeSliderPressDragModifier, androidx.compose.material3.RangeSliderState state, MutableInteractionSource startInteractionSource, MutableInteractionSource endInteractionSource, boolean enabled) {
        Modifier pointerInput;
        androidx.compose.material3.SliderKt.rangeSliderPressDragModifier.1 anon;
        int i;
        if (enabled) {
            anon = new SliderKt.rangeSliderPressDragModifier.1(state, startInteractionSource, endInteractionSource, 0);
            pointerInput = SuspendingPointerInputFilterKt.pointerInput($this$rangeSliderPressDragModifier, /* result */, (Function2)anon);
        } else {
            pointerInput = $this$rangeSliderPressDragModifier;
        }
        return pointerInput;
    }

    private static final Modifier rangeSliderStartThumbSemantics(Modifier $this$rangeSliderStartThumbSemantics, androidx.compose.material3.RangeSliderState state, boolean enabled) {
        ClosedFloatingPointRange rangeTo = RangesKt.rangeTo((Number)state.getValueRange().getStart().floatValue(), state.getActiveRangeEnd());
        SliderKt.rangeSliderStartThumbSemantics.1 anon = new SliderKt.rangeSliderStartThumbSemantics.1(enabled, rangeTo, state);
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default($this$rangeSliderStartThumbSemantics, false, (Function1)anon, 1, 0).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), state.getActiveRangeStart(), rangeTo, state.getStartSteps$material3_release());
    }

    private static final float scale(float a1, float b1, float x1, float a2, float b2) {
        return MathHelpersKt.lerp(a2, b2, SliderKt.calcFraction(a1, b1, x1));
    }

    private static final long scale-ziovWd0(float a1, float b1, long x, float a2, float b2) {
        return SliderKt.SliderRange(SliderKt.scale(a1, b1, SliderRange.getStart-impl(x), b2, obj7), SliderKt.scale(a1, b1, SliderRange.getEndInclusive-impl(x), b2, obj7));
    }

    private static final Modifier sliderSemantics(Modifier $this$sliderSemantics, androidx.compose.material3.SliderState state, boolean enabled) {
        SliderKt.sliderSemantics.1 anon = new SliderKt.sliderSemantics.1(enabled, state);
        return ProgressSemanticsKt.progressSemantics(SemanticsModifierKt.semantics$default($this$sliderSemantics, false, (Function1)anon, 1, 0).then(AccessibilityUtilKt.getIncreaseHorizontalSemanticsBounds()), state.getValue(), RangesKt.rangeTo((Number)state.getValueRange().getStart().floatValue(), (Number)state.getValueRange().getEndInclusive().floatValue()), state.getSteps());
    }

    private static final Modifier sliderTapModifier(Modifier $this$sliderTapModifier, androidx.compose.material3.SliderState state, MutableInteractionSource interactionSource, boolean enabled) {
        Modifier pointerInput;
        int i;
        if (enabled) {
            SliderKt.sliderTapModifier.1 anon = new SliderKt.sliderTapModifier.1(state, 0);
            pointerInput = SuspendingPointerInputFilterKt.pointerInput($this$sliderTapModifier, state, interactionSource, (Function2)anon);
        } else {
            pointerInput = $this$sliderTapModifier;
        }
        return pointerInput;
    }

    private static final float snapValueToTick(float current, float[] tickFractions, float minPx, float maxPx) {
        int $this$snapValueToTick_u24lambda_u2430;
        int i4;
        int i2;
        int minElem$iv2;
        int minElem$iv;
        int valueOf;
        int lastIndex;
        boolean next;
        IntRange intRange;
        int i;
        float minValue$iv;
        int compare;
        int i3;
        float f;
        float[] fArr = tickFractions;
        i4 = 0;
        valueOf = 1;
        lastIndex = 0;
        i2 = fArr.length == 0 ? valueOf : lastIndex;
        if (i2 != 0) {
            minElem$iv2 = 0;
        } else {
            minElem$iv = fArr[lastIndex];
            lastIndex = ArraysKt.getLastIndex(fArr);
            if (lastIndex == 0) {
                minElem$iv2 = valueOf;
            } else {
                i = 0;
                minValue$iv = Math.abs(lerp -= current);
                intRange = new IntRange(valueOf, lastIndex);
                IntIterator iterator = intRange.iterator();
                while (iterator.hasNext()) {
                    i = fArr[iterator.nextInt()];
                    i3 = 0;
                    f = Math.abs(lerp2 -= current);
                    if (Float.compare(minValue$iv, f) > 0) {
                    }
                    minElem$iv = i;
                    minValue$iv = f;
                }
                minElem$iv2 = valueOf;
            }
        }
        if (minElem$iv2 != 0) {
            i4 = 0;
            $this$snapValueToTick_u24lambda_u2430 = MathHelpersKt.lerp(minPx, maxPx, (Number)minElem$iv2.floatValue());
        } else {
            $this$snapValueToTick_u24lambda_u2430 = current;
        }
        return $this$snapValueToTick_u24lambda_u2430;
    }

    private static final float[] stepsToTickFractions(int steps) {
        float[] fArr2;
        int i;
        int i2;
        float[] fArr;
        int i3;
        float f;
        if (steps == 0) {
            fArr2 = new float[0];
        } else {
            i2 = steps + 2;
            fArr = new float[i2];
            while (i < i2) {
                fArr[i] = f2 /= f;
                i++;
            }
            fArr2 = fArr;
        }
        return fArr2;
    }
}
