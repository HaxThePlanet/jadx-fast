package androidx.compose.material3;

import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.MutableIntList;
import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.FocusableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardActions.Companion;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.foundation.text.KeyboardOptions.Companion;
import androidx.compose.material3.internal.AccessibilityServiceStateProvider_androidKt;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.TimeInputTokens;
import androidx.compose.material3.tokens.TimePickerTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.focus.FocusRequester;
import androidx.compose.ui.focus.FocusRequesterModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Offset.Companion;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Brush.Companion;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValue.Companion;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.LineHeightStyle.Alignment;
import androidx.compose.ui.text.style.LineHeightStyle.Alignment.Companion;
import androidx.compose.ui.text.style.LineHeightStyle.Trim;
import androidx.compose.ui.text.style.LineHeightStyle.Trim.Companion;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextAlign.Companion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffset.Companion;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlinx.coroutines.DelayKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Â\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0010\u0006\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\u001a7\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00012\u0011\u0010'\u001a\r\u0012\u0004\u0012\u00020#0(¢\u0006\u0002\u0008)H\u0003ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+\u001a\u001d\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u00100\u001a%\u00101\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\u00104\u001a-\u00105\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020\u001f2\u0006\u00106\u001a\u00020\u00192\u0006\u00102\u001a\u000203H\u0003¢\u0006\u0002\u00107\u001a\u0015\u00108\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0003¢\u0006\u0002\u00109\u001a\u001d\u0010:\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u00100\u001a%\u0010;\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u0010<\u001a1\u0010=\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001f2\u0008\u0008\u0002\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010.\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\u0010>\u001a=\u0010?\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020CH\u0003¢\u0006\u0002\u0010E\u001a)\u0010F\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\u0008\u0008\u0002\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010.\u001a\u00020/H\u0007¢\u0006\u0002\u0010G\u001a%\u0010H\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010.\u001a\u00020/2\u0006\u0010-\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010I\u001a8\u0010J\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\u0008\u0008\u0002\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010.\u001a\u00020/2\u0008\u0008\u0002\u0010K\u001a\u00020LH\u0007ø\u0001\u0000¢\u0006\u0004\u0008M\u0010N\u001a \u0010O\u001a\u00020\u001a2\u0006\u0010P\u001a\u00020\u00192\u0006\u0010Q\u001a\u00020\u00192\u0006\u0010R\u001a\u000203H\u0007\u001ab\u0010S\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u00106\u001a\u00020T2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020#0V2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010W\u001a\u00020X2\u0008\u0008\u0002\u0010Y\u001a\u00020Z2\u0008\u0008\u0002\u0010[\u001a\u00020\\2\u0006\u0010.\u001a\u00020/H\u0003ø\u0001\u0000¢\u0006\u0004\u0008]\u0010^\u001a:\u0010_\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u00106\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010W\u001a\u00020X2\u0006\u0010.\u001a\u00020/H\u0003ø\u0001\u0000¢\u0006\u0004\u0008`\u0010a\u001aQ\u0010b\u001a\u00020#2\u0006\u0010c\u001a\u0002032\u0006\u0010d\u001a\u00020C2\u000c\u0010e\u001a\u0008\u0012\u0004\u0012\u00020#0(2\u0006\u0010.\u001a\u00020/2\u001c\u0010'\u001a\u0018\u0012\u0004\u0012\u00020f\u0012\u0004\u0012\u00020#0V¢\u0006\u0002\u0008)¢\u0006\u0002\u0008gH\u0003¢\u0006\u0002\u0010h\u001a\u001d\u0010i\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u00100\u001a%\u0010j\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010-\u001a\u00020\u001a2\u0006\u0010.\u001a\u00020/H\u0003¢\u0006\u0002\u0010<\u001a1\u0010k\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001f2\u0008\u0008\u0002\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010.\u001a\u00020/2\u0006\u00102\u001a\u000203H\u0001¢\u0006\u0002\u0010>\u001a\u0018\u0010l\u001a\u00020\u00082\u0006\u0010m\u001a\u00020\u00082\u0006\u0010n\u001a\u00020\u0008H\u0002\u001a(\u0010o\u001a\u00020\u00082\u0006\u0010p\u001a\u00020\u00082\u0006\u0010q\u001a\u00020\u00082\u0006\u0010r\u001a\u00020\u00192\u0006\u0010s\u001a\u00020\u0019H\u0002\u001a*\u0010t\u001a\u00020u2\u0006\u0010W\u001a\u00020X2\u0006\u0010R\u001a\u0002032\u0006\u0010v\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\u0008w\u0010x\u001a+\u0010y\u001a\u00020\u001a2\u0008\u0008\u0002\u0010P\u001a\u00020\u00192\u0008\u0008\u0002\u0010Q\u001a\u00020\u00192\u0008\u0008\u0002\u0010R\u001a\u000203H\u0007¢\u0006\u0002\u0010z\u001a`\u0010{\u001a\u00020#2\u0006\u0010W\u001a\u00020X2\u0006\u0010-\u001a\u00020\u001a2\u0006\u00106\u001a\u00020T2\u0006\u0010|\u001a\u00020T2\u0006\u0010}\u001a\u00020\u00192\"\u0010~\u001a\u001e\u0012\u0014\u0012\u00120T¢\u0006\r\u0008\u007f\u0012\t\u0008\u0080\u0001\u0012\u0004\u0008\u0008(6\u0012\u0004\u0012\u00020#0VH\u0002ø\u0001\u0000¢\u0006\u0006\u0008\u0081\u0001\u0010\u0082\u0001\u001a\u001d\u0010\u0083\u0001\u001a\u00020%*\u00020%2\u0006\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020/H\u0002\u001a<\u0010\u0084\u0001\u001a\u00020#*\u00020\u001a2\u0006\u0010n\u001a\u00020\u00082\u0006\u0010m\u001a\u00020\u00082\u0007\u0010\u0085\u0001\u001a\u00020\u00082\u0008\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0002ø\u0001\u0000¢\u0006\u0006\u0008\u0088\u0001\u0010\u0089\u0001\u001aE\u0010\u008a\u0001\u001a\u00020#*\u00020\u001f2\u0006\u0010n\u001a\u00020\u00082\u0006\u0010m\u001a\u00020\u00082\u0007\u0010\u0085\u0001\u001a\u00020\u00082\u0006\u00102\u001a\u0002032\u0008\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0082@ø\u0001\u0000¢\u0006\u0006\u0008\u008b\u0001\u0010\u008c\u0001\u001a\u0016\u0010\u008d\u0001\u001a\u00020%*\u00020%2\u0007\u0010\u008d\u0001\u001a\u000203H\u0003\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u000c\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\r\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u000f\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0010\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0016\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0017\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0018\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001c\"\u0018\u0010\u001d\u001a\u00020\u001e*\u00020\u001f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010!\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u008e\u0001²\u0006\u000b\u0010\u008f\u0001\u001a\u000203X\u008a\u0084\u0002²\u0006\u000b\u0010\u0090\u0001\u001a\u00020TX\u008a\u008e\u0002²\u0006\u000b\u0010\u0091\u0001\u001a\u00020TX\u008a\u008e\u0002²\u0006\u000c\u0010\u0086\u0001\u001a\u00030\u0092\u0001X\u008a\u008e\u0002²\u0006\u000c\u0010\u0093\u0001\u001a\u00030\u0087\u0001X\u008a\u008e\u0002", d2 = {"ClockDisplayBottomMargin", "Landroidx/compose/ui/unit/Dp;", "F", "ClockFaceBottomMargin", "DisplaySeparatorWidth", "ExtraHours", "Landroidx/collection/IntList;", "FullCircle", "", "HalfCircle", "Hours", "InnerCircleRadius", "MaxDistance", "MinimumInteractiveSize", "Minutes", "OuterCircleSizeRadius", "PeriodToggleMargin", "QuarterCircle", "", "RadiansPerHour", "RadiansPerMinute", "SeparatorZIndex", "SupportLabelTop", "TimeInputBottomPadding", "hourForDisplay", "", "Landroidx/compose/material3/TimePickerState;", "getHourForDisplay", "(Landroidx/compose/material3/TimePickerState;)I", "selectorPos", "Landroidx/compose/ui/unit/DpOffset;", "Landroidx/compose/material3/AnalogTimePickerState;", "getSelectorPos", "(Landroidx/compose/material3/AnalogTimePickerState;)J", "CircularLayout", "", "modifier", "Landroidx/compose/ui/Modifier;", "radius", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "CircularLayout-uFdPcIQ", "(Landroidx/compose/ui/Modifier;FLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ClockDisplayNumbers", "state", "colors", "Landroidx/compose/material3/TimePickerColors;", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ClockFace", "autoSwitchToMinute", "", "(Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;I)V", "ClockText", "value", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/AnalogTimePickerState;IZLandroidx/compose/runtime/Composer;I)V", "DisplaySeparator", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "HorizontalClockDisplay", "HorizontalPeriodToggle", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "HorizontalTimePicker", "(Landroidx/compose/material3/AnalogTimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ZLandroidx/compose/runtime/Composer;II)V", "PeriodToggleImpl", "measurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "startShape", "Landroidx/compose/ui/graphics/Shape;", "endShape", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerState;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/ui/layout/MeasurePolicy;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;I)V", "TimeInput", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeInputImpl", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/material3/TimePickerState;Landroidx/compose/runtime/Composer;I)V", "TimePicker", "layoutType", "Landroidx/compose/material3/TimePickerLayoutType;", "TimePicker-mT9BvqQ", "(Landroidx/compose/material3/TimePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/TimePickerColors;ILandroidx/compose/runtime/Composer;II)V", "TimePickerState", "initialHour", "initialMinute", "is24Hour", "TimePickerTextField", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "selection", "Landroidx/compose/material3/TimePickerSelectionMode;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "TimePickerTextField-1vLObsk", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/TimePickerState;ILandroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;Landroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;II)V", "TimeSelector", "TimeSelector-SAnMeKU", "(Landroidx/compose/ui/Modifier;ILandroidx/compose/material3/TimePickerState;ILandroidx/compose/material3/TimePickerColors;Landroidx/compose/runtime/Composer;I)V", "ToggleItem", "checked", "shape", "onClick", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(ZLandroidx/compose/ui/graphics/Shape;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/TimePickerColors;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "VerticalClockDisplay", "VerticalPeriodToggle", "VerticalTimePicker", "atan", "y", "x", "dist", "x1", "y1", "x2", "y2", "numberContentDescription", "", "number", "numberContentDescription-dSwYdS4", "(IZILandroidx/compose/runtime/Composer;I)Ljava/lang/String;", "rememberTimePickerState", "(IIZLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/TimePickerState;", "timeInputOnChange", "prevValue", "max", "onNewValue", "Lkotlin/ParameterName;", "name", "timeInputOnChange-z7XvuPQ", "(ILandroidx/compose/material3/TimePickerState;Landroidx/compose/ui/text/input/TextFieldValue;Landroidx/compose/ui/text/input/TextFieldValue;ILkotlin/jvm/functions/Function1;)V", "drawSelector", "moveSelector", "maxDist", "center", "Landroidx/compose/ui/unit/IntOffset;", "moveSelector-d3b8Pxo", "(Landroidx/compose/material3/TimePickerState;FFFJ)V", "onTap", "onTap-rOwcSBo", "(Landroidx/compose/material3/AnalogTimePickerState;FFFZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "visible", "material3_release", "a11yServicesEnabled", "hourValue", "minuteValue", "Landroidx/compose/ui/geometry/Offset;", "parentCenter"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TimePickerKt {

    private static final float ClockDisplayBottomMargin = 0f;
    private static final float ClockFaceBottomMargin = 0f;
    private static final float DisplaySeparatorWidth = 0f;
    private static final IntList ExtraHours = null;
    private static final float FullCircle = 6.2831855f;
    private static final float HalfCircle = 3.1415927f;
    private static final IntList Hours = null;
    private static final float InnerCircleRadius = 0f;
    private static final float MaxDistance = 0f;
    private static final float MinimumInteractiveSize = 0f;
    private static final IntList Minutes = null;
    private static final float OuterCircleSizeRadius = 0f;
    private static final float PeriodToggleMargin = 0f;
    private static final double QuarterCircle = 1.5707963267948966d;
    private static final float RadiansPerHour = 0.5235988f;
    private static final float RadiansPerMinute = 0.10471976f;
    private static final float SeparatorZIndex = 2f;
    private static final float SupportLabelTop;
    private static final float TimeInputBottomPadding;
    static {
        int i$iv;
        int i4;
        int i;
        int i2;
        int i16 = 0;
        TimePickerKt.OuterCircleSizeRadius = Dp.constructor-impl((float)i5);
        int i17 = 0;
        TimePickerKt.InnerCircleRadius = Dp.constructor-impl((float)i6);
        int i18 = 0;
        TimePickerKt.ClockDisplayBottomMargin = Dp.constructor-impl((float)i7);
        int i19 = 0;
        TimePickerKt.ClockFaceBottomMargin = Dp.constructor-impl((float)i8);
        int i20 = 0;
        TimePickerKt.DisplaySeparatorWidth = Dp.constructor-impl((float)i9);
        int i21 = 0;
        TimePickerKt.SupportLabelTop = Dp.constructor-impl((float)i10);
        int i22 = 0;
        TimePickerKt.TimeInputBottomPadding = Dp.constructor-impl((float)i11);
        int i23 = 0;
        TimePickerKt.MaxDistance = Dp.constructor-impl((float)i12);
        int i24 = 0;
        TimePickerKt.MinimumInteractiveSize = Dp.constructor-impl((float)i13);
        int i14 = 12;
        int[] iArr = new int[i14];
        iArr = new int[]{0, 5, 10, 15, 20, 25, 30, 35, 40, 45, 50, 55};
        TimePickerKt.Minutes = IntListKt.intListOf(iArr);
        int[] iArr2 = new int[i14];
        iArr2 = new int[]{12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        TimePickerKt.Hours = IntListKt.intListOf(iArr2);
        MutableIntList mutableIntList = new MutableIntList(TimePickerKt.Hours.getSize());
        final int i26 = 0;
        final IntList hours2 = TimePickerKt.Hours;
        final int i27 = 0;
        i$iv = 0;
        while (i$iv < hours2._size) {
            i = 0;
            mutableIntList.add(i28 += i14);
            i$iv++;
        }
        TimePickerKt.ExtraHours = (IntList)mutableIntList;
        int i25 = 0;
        TimePickerKt.PeriodToggleMargin = Dp.constructor-impl((float)i15);
    }

    private static final void CircularLayout-uFdPcIQ(Modifier modifier, float radius, Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i6) {
        int traceInProgress;
        int i3;
        int $dirty2;
        Object obj;
        int $dirty;
        Object modifier2;
        float valueOf2;
        int valueOf;
        int currentCompositeKeyHash;
        boolean traceInProgress2;
        Object str;
        int i5;
        int i9;
        int i4;
        int currentCompositionLocalMap;
        int materializeModifier;
        Function0 constructor;
        int empty;
        int i;
        Object anon;
        int i2;
        int i7;
        Composer composer;
        int i8;
        boolean inserting;
        int obj19;
        Object obj22;
        valueOf2 = radius;
        final Object obj3 = content;
        valueOf = $changed;
        traceInProgress = 1548175696;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(CircularLayout)P(1,2:c#ui.unit.Dp)1871@72466L1666,1871@72419L1713:TimePicker.kt#uh7d8r");
        $dirty2 = $changed;
        currentCompositeKeyHash = i6 & 1;
        if (currentCompositeKeyHash != 0) {
            $dirty2 |= 6;
            str = modifier;
        } else {
            if (valueOf & 6 == 0) {
                i5 = restartGroup.changed(modifier) ? 4 : 2;
                $dirty2 |= i5;
            } else {
                str = modifier;
            }
        }
        currentCompositionLocalMap = 32;
        if (i6 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (valueOf & 48 == 0) {
                i9 = restartGroup.changed(valueOf2) ? currentCompositionLocalMap : 16;
                $dirty2 |= i9;
            }
        }
        if (i6 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (valueOf & 384 == 0) {
                i4 = restartGroup.changedInstance(obj3) ? 256 : 128;
                $dirty2 |= i4;
            }
        }
        int i21 = $dirty2;
        if (i21 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (currentCompositeKeyHash != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i21, -1, "androidx.compose.material3.CircularLayout (TimePicker.kt:1870)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, -328610546, "CC(remember):TimePicker.kt#9igjgp");
                int i17 = 0;
                i3 = i21 & 112 == currentCompositionLocalMap ? 1 : i17;
                Composer composer2 = restartGroup;
                int i22 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i24 = 0;
                if (i3 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new TimePickerKt.CircularLayout.1.1(valueOf2);
                        composer2.updateRememberedValue((MeasurePolicy)anon);
                    } else {
                        anon = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i13 |= i20;
                str = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, i17);
                i2 = 0;
                obj19 = i14;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(ComposeUiNode.Companion.getConstructor());
                } else {
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                i7 = 0;
                Updater.set-impl(constructor-impl, (MeasurePolicy)anon, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i = 0;
                composer = constructor-impl;
                i8 = 0;
                if (!composer.getInserting()) {
                    if (!Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        valueOf = composer;
                    }
                } else {
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, modifier2), ComposeUiNode.Companion.getSetModifier());
                obj3.invoke(restartGroup, Integer.valueOf(i15 &= 14));
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj22;
            } else {
                restartGroup.skipToGroupEnd();
                obj = str;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new TimePickerKt.CircularLayout.2(obj, radius, obj3, $changed, i6);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final void ClockDisplayNumbers(androidx.compose.material3.TimePickerState state, androidx.compose.material3.TimePickerColors colors, Composer $composer, int $changed) {
        int traceInProgress;
        int $dirty;
        boolean changedInstance;
        int i;
        int i4;
        int rememberComposableLambda;
        boolean traceInProgress2;
        int i3;
        int str;
        int i2;
        traceInProgress = -934561141;
        final Composer obj8 = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(obj8, "C(ClockDisplayNumbers)P(1)1128@47738L5,1131@47873L775,1127@47654L994:TimePicker.kt#uh7d8r");
        i3 = 2;
        if ($changed & 6 == 0) {
            if ($changed & 8 == 0) {
                changedInstance = obj8.changed(state);
            } else {
                changedInstance = obj8.changedInstance(state);
            }
            i = changedInstance != null ? 4 : i3;
            $dirty |= i;
        }
        if ($changed & 48 == 0) {
            i4 = obj8.changed(colors) ? 32 : 16;
            $dirty |= i4;
        }
        if ($dirty & 19 == 18) {
            if (!obj8.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.ClockDisplayNumbers (TimePicker.kt:1126)");
                }
                ProvidedValue[] arr = new ProvidedValue[i3];
                arr[0] = TextKt.getLocalTextStyle().provides(TypographyKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorLabelTextFont(), obj8, 6));
                int i7 = 1;
                arr[i7] = CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr);
                TimePickerKt.ClockDisplayNumbers.1 anon = new TimePickerKt.ClockDisplayNumbers.1(state, colors);
                CompositionLocalKt.CompositionLocalProvider(arr, (Function2)ComposableLambdaKt.rememberComposableLambda(-477913269, i7, anon, obj8, 54), obj8, $stable |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj8.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj8.endRestartGroup();
        if (endRestartGroup != null) {
            rememberComposableLambda = new TimePickerKt.ClockDisplayNumbers.2(state, colors, $changed);
            endRestartGroup.updateScope((Function2)rememberComposableLambda);
        }
    }

    public static final void ClockFace(androidx.compose.material3.AnalogTimePickerState state, androidx.compose.material3.TimePickerColors colors, boolean autoSwitchToMinute, Composer $composer, int $changed) {
        int traceInProgress2;
        int i5;
        int i3;
        int i6;
        boolean clockFaceValues;
        boolean traceInProgress;
        int drawSelector;
        long l;
        int i;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i4;
        int i2;
        int obj12;
        traceInProgress2 = -1170157036;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(ClockFace)P(2,1)1521@60272L2018,1513@59878L2412:TimePicker.kt#uh7d8r");
        if ($changed & 6 == 0) {
            i5 = restartGroup.changedInstance(state) ? 4 : 2;
            obj12 |= i5;
        }
        if ($changed & 48 == 0) {
            i3 = restartGroup.changed(colors) ? 32 : 16;
            obj12 |= i3;
        }
        if ($changed & 384 == 0) {
            i6 = restartGroup.changed(autoSwitchToMinute) ? 256 : 128;
            obj12 |= i6;
        }
        if (obj12 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, obj12, -1, "androidx.compose.material3.ClockFace (TimePicker.kt:1512)");
                }
                int i8 = 0;
                ClockDialModifier clockDialModifier = new ClockDialModifier(state, autoSwitchToMinute, state.getSelection-yecRtBI(), i8);
                TimePickerKt.ClockFace.1 anon = new TimePickerKt.ClockFace.1(colors, state, autoSwitchToMinute);
                CrossfadeKt.Crossfade(state.getClockFaceValues(), TimePickerKt.drawSelector(SizeKt.size-3ABfNKs(BackgroundKt.background-bw27NRU((Modifier)Modifier.Companion, colors.getClockDialColor-0d7_KjU(), obj3).then((Modifier)clockDialModifier), TimePickerTokens.INSTANCE.getClockDialContainerSize-D9Ej5fM()), state, colors), (FiniteAnimationSpec)AnimationSpecKt.tween$default(200, 0, i8, 6, i8), 0, (Function3)ComposableLambdaKt.rememberComposableLambda(-1022006568, true, anon, restartGroup, 54), restartGroup, 24960, 8);
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
            clockFaceValues = new TimePickerKt.ClockFace.2(state, colors, autoSwitchToMinute, $changed);
            endRestartGroup.updateScope((Function2)clockFaceValues);
        }
    }

    private static final void ClockText(Modifier modifier, androidx.compose.material3.AnalogTimePickerState state, int value, boolean autoSwitchToMinute, Composer $composer, int $changed) {
        Object maxDist;
        int traceInProgress2;
        int $dirty;
        int $dirty2;
        boolean traceInProgress;
        Object invalid$iv2;
        boolean center$delegate;
        Function0 factory$iv$iv$iv;
        kotlinx.coroutines.CoroutineScope coroutineScope2;
        Integer currentCompositionLocalMap;
        Object it$iv;
        boolean selected;
        Composer i;
        int empty2;
        int i19;
        int i36;
        int i35;
        int i17;
        int str3;
        Object mutableStateOf$default;
        Object compositionCoroutineScope;
        Object it$iv2;
        float valueOf;
        Composer composer2;
        Object $i$a$CacheTimePickerKt$ClockText$parentCenter$2;
        Object $changed$iv2;
        boolean $this$cache$iv;
        int i20;
        Object empty3;
        int i2;
        Object it$iv4;
        int empty4;
        Object obj;
        int text;
        int i13;
        int changed;
        Object obj3;
        Alignment scope;
        MeasurePolicy maybeCachedBoxMeasurePolicy;
        boolean z2;
        Modifier modifier3;
        Object empty;
        Composer parentCenter$delegate;
        int i3;
        String str2;
        Modifier clearAndSetSemantics;
        long zero-F1C5BW0;
        String str4;
        Object obj2;
        String str;
        int invalid$iv;
        Object obj4;
        int companion;
        int i31;
        int minute;
        long inserting;
        int $changed$iv;
        int i28;
        Object it$iv3;
        int i23;
        int i4;
        int i14;
        int i5;
        int i7;
        int i21;
        int i6;
        int i10;
        int i27;
        int i22;
        int i15;
        int i12;
        int i8;
        int i11;
        int i30;
        int i34;
        TextStyle value2;
        Composer composer;
        int i33;
        int i24;
        int i32;
        int $i$a$LayoutBoxKt$Box$1$iv;
        boolean z;
        kotlinx.coroutines.CoroutineScope coroutineScope;
        int i16;
        Function0 function0;
        int i18;
        int i29;
        int i9;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        float f;
        Modifier modifier2;
        int i25;
        int i26;
        Composer composer3;
        BoxScopeInstance obj59;
        it$iv = state;
        i = value;
        changed = $changed;
        traceInProgress2 = -206784607;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(ClockText)P(1,2,3)1639@64421L5,*1640@64463L7,1641@64513L40,1642@64578L43,1643@64638L24,1645@64700L142,1665@65318L163,1670@65563L503,1659@65093L1182:TimePicker.kt#uh7d8r");
        i20 = 2;
        if (changed & 6 == 0) {
            i19 = restartGroup.changed(modifier) ? 4 : i20;
            $dirty |= i19;
        } else {
            obj3 = modifier;
        }
        if (changed & 48 == 0) {
            i36 = restartGroup.changedInstance(it$iv) ? 32 : 16;
            $dirty |= i36;
        }
        if (changed & 384 == 0) {
            i35 = restartGroup.changed(i) ? 256 : 128;
            $dirty |= i35;
        }
        if (changed & 3072 == 0) {
            i17 = restartGroup.changed(autoSwitchToMinute) ? 2048 : 1024;
            $dirty |= i17;
        } else {
            z2 = autoSwitchToMinute;
        }
        final int i80 = $dirty;
        if (i80 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i80, -1, "androidx.compose.material3.ClockText (TimePicker.kt:1638)");
                }
                int i81 = 6;
                int i37 = 0;
                int i47 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i38 = 0;
                float $this$ClockText_u24lambda_u2427 = (Density)restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(TimePickerKt.MaxDistance);
                String str6 = "CC(remember):TimePicker.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 297230880, str6);
                int i39 = 0;
                Composer composer5 = restartGroup;
                int i70 = 0;
                Object rememberedValue3 = composer5.rememberedValue();
                int i82 = 0;
                obj59 = i81;
                int i78 = 0;
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    invalid$iv = i39;
                    composer5.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(Offset.box-impl(Offset.Companion.getZero-F1C5BW0()), i78, i20, i78));
                } else {
                    invalid$iv = i39;
                    invalid$iv2 = rememberedValue3;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 297232963, str6);
                int i63 = 0;
                Composer composer6 = restartGroup;
                int i74 = 0;
                Object rememberedValue5 = composer6.rememberedValue();
                int i83 = 0;
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    str4 = str6;
                    invalid$iv = i60;
                    composer6.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(IntOffset.box-impl(IntOffset.Companion.getZero-nOcc-ac()), i78, 2, i78));
                } else {
                    str4 = str6;
                    mutableStateOf$default = rememberedValue5;
                }
                Object obj6 = mutableStateOf$default;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i54 = i48;
                int i64 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                Composer composer9 = restartGroup;
                int i90 = 0;
                Object rememberedValue4 = composer9.rememberedValue();
                int i92 = 0;
                int i96 = i49;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    int i95 = 0;
                    i5 = i53;
                    $changed$iv = i54;
                    $changed$iv2 = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, restartGroup));
                    composer9.updateRememberedValue($changed$iv2);
                } else {
                    $changed$iv = i54;
                    $changed$iv2 = rememberedValue4;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                kotlinx.coroutines.CoroutineScope coroutineScope4 = coroutineScope3;
                String str12 = str4;
                String localString$default3 = CalendarLocale_jvmKt.toLocalString$default(i, 0, 0, false, 7, 0);
                if (TimePickerSelectionMode.equals-impl0(it$iv.getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getMinute-yecRtBI())) {
                    selected = Intrinsics.areEqual(CalendarLocale_jvmKt.toLocalString$default(it$iv.getMinute(), 0, 0, false, 7, 0), localString$default3);
                } else {
                    selected = Intrinsics.areEqual(CalendarLocale_jvmKt.toLocalString$default(it$iv.getHour(), 0, 0, false, 7, 0), localString$default3);
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 297256763, str12);
                Composer composer8 = restartGroup;
                int i88 = 0;
                Alignment alignment = center;
                it$iv2 = composer8.rememberedValue();
                int i93 = 0;
                int i97 = i67;
                if (it$iv2 == Composer.Companion.getEmpty()) {
                    empty3 = 0;
                    it$iv3 = it$iv2;
                    it$iv2 = new TimePickerKt.ClockText.1.1((MutableState)obj6, (MutableState)invalid$iv2);
                    composer8.updateRememberedValue((Function1)it$iv2);
                } else {
                    it$iv3 = it$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i73 = 0;
                Modifier focusable$default = FocusableKt.focusable$default(OnGloballyPositionedModifierKt.onGloballyPositioned(SizeKt.size-3ABfNKs(InteractiveComponentSizeKt.minimumInteractiveComponentSize(obj3), TimePickerKt.MinimumInteractiveSize), (Function1)it$iv2), false, i73, 3, i73);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 297264943, str12);
                i2 = i80 & 7168 == 2048 ? 1 : 0;
                $this$cache$iv = restartGroup;
                int i91 = 0;
                Object rememberedValue2 = $this$cache$iv.rememberedValue();
                int i94 = 0;
                if (i59 | changed6 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        it$iv3 = 0;
                        modifier3 = modifier4;
                        obj2 = rememberedValue2;
                        scope = alignment;
                        str = localString$default3;
                        text = 1;
                        maxDist = new TimePickerKt.ClockText.2.1(selected, coroutineScope4, it$iv, $this$ClockText_u24lambda_u2427, z2, invalid$iv2, obj6);
                        $this$cache$iv.updateRememberedValue((Function1)maxDist);
                    } else {
                        modifier3 = focusable$default;
                        coroutineScope2 = coroutineScope4;
                        obj = obj6;
                        scope = alignment;
                        valueOf = $this$ClockText_u24lambda_u2427;
                        it$iv4 = invalid$iv2;
                        center$delegate = selected;
                        parentCenter$delegate = $this$cache$iv;
                        maxDist = obj2;
                        str = localString$default3;
                        text = 1;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i46 = 48;
                i20 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                i3 = 0;
                z = center$delegate;
                coroutineScope = coroutineScope2;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, SemanticsModifierKt.semantics(modifier3, text, (Function1)maxDist));
                i16 = currentCompositeKeyHash;
                Function0 function02 = constructor;
                i18 = 0;
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
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i84 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(scope, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i86 = 0;
                Composer composer11 = constructor-impl;
                companion = 0;
                inserting = composer11.getInserting();
                if (!inserting) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    f = valueOf;
                    if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(i16))) {
                        composer11.updateRememberedValue(Integer.valueOf(i16));
                        constructor-impl.apply(Integer.valueOf(i16), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer11;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    f = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer4 = restartGroup;
                empty2 = 0;
                modifier2 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i52 |= 6;
                composer = composer4;
                i25 = 0;
                obj59 = iNSTANCE2;
                i26 = i44;
                ComposerKt.sourceInformationMarkerStart(composer4, 1481062706, "C1688@66158L48,1686@66083L186:TimePicker.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(composer4, 879062471, str12);
                $dirty2 = str15;
                Composer composer10 = composer4;
                int i87 = 0;
                it$iv = composer10.rememberedValue();
                int i89 = 0;
                if (!composer4.changed($dirty2)) {
                    $i$a$LayoutBoxKt$Box$1$iv = empty2;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        int $i$a$LayoutBoxKt$Box$1$iv2 = 0;
                        obj4 = it$iv;
                        it$iv = new TimePickerKt.ClockText.3.1.1($dirty2);
                        composer10.updateRememberedValue((Function1)it$iv);
                    } else {
                        obj4 = it$iv;
                        i = composer10;
                    }
                } else {
                    $i$a$LayoutBoxKt$Box$1$iv = empty2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                TextKt.Text--4IGK_g(str, SemanticsModifierKt.clearAndSetSemantics((Modifier)Modifier.Companion, (Function1)it$iv), 0, str, 0, inserting, 0, 0, 0, 0, i10, 0, false, 0, obj30, 0, 0, 0, 0, 0, TypographyKt.getValue(TimePickerTokens.INSTANCE.getClockDialLabelTextFont(), restartGroup, i81));
                ComposerKt.sourceInformationMarkerEnd(composer);
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
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new TimePickerKt.ClockText.4(obj3, state, value, autoSwitchToMinute, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final long ClockText$lambda$29(MutableState<Offset> $center$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Offset)(State)$center$delegate.getValue().unbox-impl();
    }

    private static final void ClockText$lambda$30(MutableState<Offset> $center$delegate, long value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $center$delegate.setValue(Offset.box-impl(value));
    }

    private static final long ClockText$lambda$32(MutableState<IntOffset> $parentCenter$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (IntOffset)(State)$parentCenter$delegate.getValue().unbox-impl();
    }

    private static final void ClockText$lambda$33(MutableState<IntOffset> $parentCenter$delegate, long value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $parentCenter$delegate.setValue(IntOffset.box-impl(value));
    }

    private static final void DisplaySeparator(Modifier modifier, Composer $composer, int $changed) {
        boolean clearAndSetSemantics;
        int traceInProgress2;
        int $dirty;
        int i9;
        int contentAlignment$iv2;
        boolean traceInProgress;
        int propagateMinConstraints$iv;
        long measurePolicy$iv2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        int materialized$iv$iv3;
        long constructor;
        int $composer$iv;
        Composer composer;
        Object rememberedValue;
        androidx.compose.ui.text.font.FontWeight contentAlignment$iv;
        int $composer2;
        int i;
        int i6;
        int propagateMinConstraints$iv2;
        int i5;
        int materialized$iv$iv2;
        int factory$iv$iv$iv;
        Object alignment;
        int $composer$iv2;
        int measurePolicy$iv;
        int localMap$iv$iv;
        int propagateMinConstraints$iv3;
        androidx.compose.ui.graphics.drawscope.DrawStyle materialized$iv$iv;
        TextStyle textStyle;
        Composer $composer$iv3;
        int contentAlignment$iv3;
        int i10;
        int i3;
        int i11;
        int i12;
        int i15;
        int i2;
        int currentCompositeKeyHash;
        int i4;
        int i7;
        Modifier modifier$iv;
        int i14;
        int i8;
        BoxScopeInstance boxScopeInstance;
        int i16;
        Function0 function0;
        Composer composer2;
        MeasurePolicy measurePolicy;
        androidx.compose.runtime.CompositionLocalMap map;
        int i13;
        Modifier modifier2;
        Alignment alignment2;
        Composer obj50;
        final Object obj = modifier;
        final int i17 = $changed;
        traceInProgress2 = 2100674302;
        Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(DisplaySeparator)1326@54104L7,1335@54375L172:TimePicker.kt#uh7d8r");
        propagateMinConstraints$iv = 2;
        if (i17 & 6 == 0) {
            i9 = restartGroup.changed(obj) ? 4 : propagateMinConstraints$iv;
            $dirty |= i9;
        }
        if ($dirty & 3 == propagateMinConstraints$iv) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.DisplaySeparator (TimePicker.kt:1324)");
                }
                int i20 = 6;
                int i21 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                LineHeightStyle lineHeightStyle = new LineHeightStyle(LineHeightStyle.Alignment.Companion.getCenter-PIaL0Z0(), LineHeightStyle.Trim.Companion.getBoth-EVpEnUU(), 0);
                clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(obj, (Function1)TimePickerKt.DisplaySeparator.1.INSTANCE);
                Alignment center = Alignment.Companion.getCenter();
                i11 = i22;
                i12 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                int i24 = 0;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, i24);
                i2 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, clearAndSetSemantics);
                constructor = ComposeUiNode.Companion.getConstructor();
                rememberedValue = 6;
                i7 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(constructor);
                } else {
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i40 = 0;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                obj50 = constructor-impl;
                int i47 = 0;
                if (!obj50.getInserting()) {
                    i5 = rememberedValue;
                    modifier$iv = clearAndSetSemantics;
                    if (!Intrinsics.areEqual(obj50.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        obj50.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = obj50;
                    }
                } else {
                    modifier$iv = clearAndSetSemantics;
                    i5 = rememberedValue;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                i18 &= 14;
                Composer composer4 = restartGroup;
                i14 = 0;
                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                i8 = i42 | 6;
                Composer composer5 = composer4;
                boxScopeInstance = iNSTANCE2;
                i16 = 0;
                ComposerKt.sourceInformationMarkerStart(composer5, -789568360, "C1336@54520L5,1336@54471L70:TimePicker.kt#uh7d8r");
                alignment = alignment3;
                $composer$iv3 = composer5;
                function0 = function02;
                measurePolicy = measurePolicy2;
                map = map2;
                i13 = i55;
                modifier2 = modifier4;
                alignment2 = alignment4;
                TextKt.Text--4IGK_g(":", 0, ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSeparatorColor(), composer5, i5), currentCompositionLocalMap, 0, constructor, 0, 0, 0, 0, 0, 0, false, 0, alignment, 0, 0, 0, 0, 0, TextStyle.copy-p1EtxEg$default((TextStyle)restartGroup.consume((CompositionLocal)TextKt.getLocalTextStyle()), 0, obj10, 0, obj12, 0, 0, 0, 0, 0, 0, obj19, 0, 0, 0, 0, obj24, 0, 0, 0, TextAlign.Companion.getCenter-e0LSkKk(), 0, 0, obj31, 0, 0, lineHeightStyle));
                ComposerKt.sourceInformationMarkerEnd($composer$iv3);
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
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            contentAlignment$iv2 = new TimePickerKt.DisplaySeparator.3(obj, i17);
            endRestartGroup.updateScope((Function2)contentAlignment$iv2);
        }
    }

    private static final void HorizontalClockDisplay(androidx.compose.material3.TimePickerState state, androidx.compose.material3.TimePickerColors colors, Composer $composer, int $changed) {
        int traceInProgress2;
        Function0 factory$iv$iv$iv;
        Modifier size-VpY3zN4;
        Function0 factory$iv$iv$iv2;
        Composer restartGroup;
        int $dirty;
        int i5;
        int i10;
        boolean $i$a$LayoutColumnKt$Column$1$iv;
        boolean traceInProgress;
        boolean valueOf3;
        boolean changedInstance;
        int str;
        Composer composer2;
        Composer composer3;
        Integer valueOf;
        Integer valueOf2;
        Object maybeCachedBoxMeasurePolicy;
        androidx.compose.ui.Alignment.Horizontal start;
        MeasurePolicy columnMeasurePolicy;
        int i9;
        int i6;
        Modifier materializeModifier;
        Object currentCompositionLocalMap;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap2;
        int currentCompositeKeyHash;
        int i7;
        int i3;
        androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical horizontalOrVertical;
        Function0 function0;
        int i4;
        int i12;
        int i22;
        int i15;
        int i16;
        Composer composer;
        int i11;
        ColumnScopeInstance columnScopeInstance;
        int $changed$iv;
        int i19;
        Composer composer5;
        int i21;
        int i18;
        int i2;
        androidx.compose.ui.Modifier.Companion companion;
        int i8;
        int i17;
        Alignment alignment;
        Modifier modifier2;
        TimePickerTokens iNSTANCE;
        int i13;
        Function0 function02;
        int i20;
        BoxScopeInstance boxScopeInstance;
        Composer $composer2;
        int i14;
        Modifier modifier;
        Composer composer4;
        int i;
        int obj52;
        final Object obj = state;
        final Object obj2 = colors;
        final int i23 = $changed;
        traceInProgress2 = 755539561;
        restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(HorizontalClockDisplay)P(1)1087@46270L590:TimePicker.kt#uh7d8r");
        if (i23 & 6 == 0) {
            if (i23 & 8 == 0) {
                changedInstance = restartGroup.changed(obj);
            } else {
                changedInstance = restartGroup.changedInstance(obj);
            }
            i5 = changedInstance != null ? 4 : 2;
            $dirty |= i5;
        }
        if (i23 & 48 == 0) {
            i10 = restartGroup.changed(obj2) ? 32 : 16;
            $dirty |= i10;
        }
        if ($dirty & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.HorizontalClockDisplay (TimePicker.kt:1086)");
                }
                androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                valueOf3 = 48;
                valueOf2 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                maybeCachedBoxMeasurePolicy = Modifier.Companion;
                i6 = 0;
                currentCompositionLocalMap = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositionLocalMap);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                horizontalOrVertical = center;
                Function0 function03 = constructor2;
                i3 = 0;
                i12 = $dirty;
                $dirty = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, $dirty);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function03);
                } else {
                    factory$iv$iv$iv = function03;
                    restartGroup.useNode();
                }
                function0 = factory$iv$iv$iv;
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i61 = 0;
                composer = restartGroup;
                Updater.set-impl(constructor-impl, ColumnKt.columnMeasurePolicy((Arrangement.Vertical)center, Alignment.Companion.getStart(), restartGroup, i53 |= i56), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i62 = 0;
                Composer composer7 = constructor-impl;
                int i63 = 0;
                if (!composer7.getInserting()) {
                    $changed$iv = valueOf3;
                    i19 = valueOf2;
                    if (!Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer7;
                    }
                } else {
                    $changed$iv = valueOf3;
                    i19 = valueOf2;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, (Modifier)maybeCachedBoxMeasurePolicy), ComposeUiNode.Companion.getSetModifier());
                Composer composer6 = composer;
                i15 = i27;
                ComposerKt.sourceInformationMarkerStart(composer6, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                i47 |= 6;
                i11 = 0;
                columnScopeInstance = iNSTANCE3;
                i21 = i41;
                $i$a$LayoutColumnKt$Column$1$iv = i16;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutColumnKt$Column$1$iv, -1556019140, "C1088@46329L34:TimePicker.kt#uh7d8r");
                TimePickerKt.ClockDisplayNumbers(obj, obj2, $i$a$LayoutColumnKt$Column$1$iv, i28 |= restartGroup);
                $i$a$LayoutColumnKt$Column$1$iv.startReplaceGroup(919638492);
                ComposerKt.sourceInformation($i$a$LayoutColumnKt$Column$1$iv, "1090@46407L437");
                if (!obj.is24hour()) {
                    Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, 0, TimePickerKt.PeriodToggleMargin, 0, 0, 13, 0);
                    i16 = 0;
                    i18 = i36;
                    i2 = str;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutColumnKt$Column$1$iv, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment topStart = Alignment.Companion.getTopStart();
                    valueOf = 0;
                    companion = maybeCachedBoxMeasurePolicy;
                    i17 = 0;
                    alignment = topStart;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutColumnKt$Column$1$iv, -1323940314, currentCompositionLocalMap);
                    obj52 = currentCompositeKeyHash2;
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier($i$a$LayoutColumnKt$Column$1$iv, padding-qDBjuR0$default);
                    modifier2 = padding-qDBjuR0$default;
                    Function0 function04 = constructor;
                    i7 = 0;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutColumnKt$Column$1$iv, -692256719, $dirty);
                    if (!applier2 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $i$a$LayoutColumnKt$Column$1$iv.startReusableNode();
                    if ($i$a$LayoutColumnKt$Column$1$iv.getInserting()) {
                        $i$a$LayoutColumnKt$Column$1$iv.createNode(function04);
                    } else {
                        factory$iv$iv$iv2 = function04;
                        $i$a$LayoutColumnKt$Column$1$iv.useNode();
                    }
                    Composer constructor-impl2 = Updater.constructor-impl($i$a$LayoutColumnKt$Column$1$iv);
                    int i60 = 0;
                    function02 = factory$iv$iv$iv2;
                    Updater.set-impl(constructor-impl2, BoxKt.maybeCachedBoxMeasurePolicy(topStart, valueOf), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, $i$a$LayoutColumnKt$Column$1$iv.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i70 = 0;
                    Composer composer9 = constructor-impl2;
                    int i71 = 0;
                    if (!composer9.getInserting()) {
                        $composer2 = $i$a$LayoutColumnKt$Column$1$iv;
                        i14 = valueOf;
                        if (!Intrinsics.areEqual(composer9.rememberedValue(), Integer.valueOf(obj52))) {
                            composer9.updateRememberedValue(Integer.valueOf(obj52));
                            constructor-impl2.apply(Integer.valueOf(obj52), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer3 = composer9;
                        }
                    } else {
                        $composer2 = $i$a$LayoutColumnKt$Column$1$iv;
                        i14 = valueOf;
                    }
                    Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    $dirty = $composer2;
                    i22 = i34;
                    ComposerKt.sourceInformationMarkerStart($dirty, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    i50 |= 6;
                    Composer composer8 = $dirty;
                    i20 = 0;
                    boxScopeInstance = iNSTANCE4;
                    modifier = materializeModifier2;
                    ComposerKt.sourceInformationMarkerStart($dirty, -743649264, "C1091@46484L346:TimePicker.kt#uh7d8r");
                    i = i42;
                    TimePickerKt.HorizontalPeriodToggle(SizeKt.size-VpY3zN4((Modifier)Modifier.Companion, TimePickerTokens.INSTANCE.getPeriodSelectorHorizontalContainerWidth-D9Ej5fM(), TimePickerTokens.INSTANCE.getPeriodSelectorHorizontalContainerHeight-D9Ej5fM()), obj, obj2, $dirty, i40 |= $i$a$LayoutColumnKt$Column$1$iv);
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    $composer2 = $i$a$LayoutColumnKt$Column$1$iv;
                    i2 = str;
                    companion = maybeCachedBoxMeasurePolicy;
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
                i12 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            restartGroup = new TimePickerKt.HorizontalClockDisplay.2(obj, obj2, i23);
            endRestartGroup.updateScope((Function2)restartGroup);
        }
    }

    private static final void HorizontalPeriodToggle(Modifier modifier, androidx.compose.material3.TimePickerState state, androidx.compose.material3.TimePickerColors colors, Composer $composer, int $changed) {
        Shape value;
        int i4;
        boolean changedInstance;
        int i;
        int i3;
        int skipping;
        boolean traceInProgress;
        Object obj;
        int str;
        Object obj3;
        Object obj2;
        androidx.compose.material3.TimePickerKt.HorizontalPeriodToggle.measurePolicy.1.1 time;
        int empty;
        androidx.compose.foundation.shape.CornerBasedShape cornerBasedShape;
        Object iNSTANCE;
        androidx.compose.foundation.shape.CornerBasedShape cornerBasedShape2;
        int i2;
        boolean obj9;
        Object obj10;
        int obj12;
        value = 1261215927;
        final Composer restartGroup = $composer.startRestartGroup(value);
        ComposerKt.sourceInformation(restartGroup, "C(HorizontalPeriodToggle)P(1,2)1160@48810L1014,1188@49871L5,1190@49902L206:TimePicker.kt#uh7d8r");
        if ($changed & 6 == 0) {
            i4 = restartGroup.changed(modifier) ? 4 : 2;
            obj12 |= i4;
        }
        if ($changed & 48 == 0) {
            if ($changed & 64 == 0) {
                changedInstance = restartGroup.changed(state);
            } else {
                changedInstance = restartGroup.changedInstance(state);
            }
            i = changedInstance != null ? 32 : 16;
            obj12 |= i;
        }
        if ($changed & 384 == 0) {
            i3 = restartGroup.changed(colors) ? 256 : 128;
            obj12 |= i3;
        }
        if (obj12 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(value, obj12, -1, "androidx.compose.material3.HorizontalPeriodToggle (TimePicker.kt:1159)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2071625362, "CC(remember):TimePicker.kt#9igjgp");
                int i6 = 0;
                Composer composer = restartGroup;
                int i12 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i15 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty = 0;
                    composer.updateRememberedValue((MeasurePolicy)TimePickerKt.HorizontalPeriodToggle.measurePolicy.1.1.INSTANCE);
                } else {
                    iNSTANCE = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), restartGroup, 6);
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
                TimePickerKt.PeriodToggleImpl(modifier, state, colors, (MeasurePolicy)iNSTANCE, (Shape)ShapesKt.start((CornerBasedShape)value), (Shape)ShapesKt.end(value), restartGroup, i11 | i14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj = modifier;
                obj3 = state;
                obj2 = colors;
            }
        } else {
        }
        obj9 = restartGroup.endRestartGroup();
        if (obj9 != null) {
            obj10 = new TimePickerKt.HorizontalPeriodToggle.1(obj, obj3, obj2, $changed);
            obj9.updateScope((Function2)obj10);
        }
    }

    public static final void HorizontalTimePicker(androidx.compose.material3.AnalogTimePickerState state, Modifier modifier, androidx.compose.material3.TimePickerColors colors, boolean autoSwitchToMinute, Composer $composer, int $changed, int i7) {
        int traceInProgress;
        Function0 factory$iv$iv$iv;
        int $dirty2;
        Object $dirty;
        int i10;
        Object obj2;
        Object modifier2;
        boolean traceInProgress2;
        int valueOf2;
        Object colors2;
        Composer composer;
        Integer valueOf;
        int i5;
        Object obj3;
        int changed;
        int i4;
        boolean skipping;
        int defaultsInvalid;
        int currentCompositionLocalMap;
        Object obj;
        androidx.compose.foundation.layout.Arrangement.Horizontal start;
        MeasurePolicy rowMeasurePolicy;
        int i11;
        int i;
        int i12;
        int i2;
        int i6;
        int i3;
        androidx.compose.ui.Alignment.Vertical vertical;
        int i8;
        Function0 function0;
        int i9;
        RowScopeInstance rowScopeInstance;
        int $changed$iv;
        Modifier modifier3;
        Composer composer2;
        int obj29;
        Object obj30;
        int obj32;
        final Object obj5 = state;
        final boolean z2 = autoSwitchToMinute;
        valueOf2 = $changed;
        traceInProgress = 1432307537;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(HorizontalTimePicker)P(3,2,1)945@40787L8,948@40837L309:TimePicker.kt#uh7d8r");
        $dirty2 = $changed;
        if (i7 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (valueOf2 & 6 == 0) {
                i10 = restartGroup.changedInstance(obj5) ? 4 : 2;
                $dirty2 |= i10;
            }
        }
        int i29 = i7 & 2;
        if (i29 != 0) {
            $dirty2 |= 48;
            colors2 = modifier;
        } else {
            if (valueOf2 & 48 == 0) {
                i5 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i5;
            } else {
                colors2 = modifier;
            }
        }
        if (valueOf2 & 384 == 0) {
            if (i7 & 4 == 0) {
                changed = restartGroup.changed(colors) ? 256 : 128;
            } else {
                obj3 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj3 = colors;
        }
        if (i7 & 8 != 0) {
            $dirty2 |= 3072;
        } else {
            if (valueOf2 & 3072 == 0) {
                i4 = restartGroup.changed(z2) ? 2048 : 1024;
                $dirty2 |= i4;
            }
        }
        if ($dirty2 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i36 = 6;
                if (valueOf2 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i29 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = colors2;
                        }
                        if (i7 & 4 != 0) {
                            $dirty2 &= -897;
                            obj = modifier2;
                            obj3 = colors2;
                        } else {
                            obj = modifier2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i7 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        obj = colors2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty2, -1, "androidx.compose.material3.HorizontalTimePicker (TimePicker.kt:947)");
                }
                Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(obj, 0, 0, 0, TimePickerKt.ClockFaceBottomMargin, 7, 0);
                androidx.compose.ui.Alignment.Vertical centerVertically = Alignment.Companion.getCenterVertically();
                valueOf = 384;
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                i = 0;
                i12 = $dirty2;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                obj29 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, padding-qDBjuR0$default);
                obj30 = padding-qDBjuR0$default;
                Function0 function02 = constructor;
                i2 = 0;
                vertical = centerVertically;
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
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i50 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, restartGroup, i42 |= i46), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i51 = 0;
                Composer composer5 = constructor-impl;
                int i53 = 0;
                if (!composer5.getInserting()) {
                    $changed$iv = valueOf;
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(obj29))) {
                        composer5.updateRememberedValue(Integer.valueOf(obj29));
                        constructor-impl.apply(Integer.valueOf(obj29), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer5;
                    }
                } else {
                    $changed$iv = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                valueOf2 = 0;
                i6 = i16;
                ComposerKt.sourceInformationMarkerStart(composer3, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                i33 |= 6;
                Composer composer4 = composer3;
                i9 = 0;
                rowScopeInstance = iNSTANCE;
                modifier3 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer3, 157723300, "C952@40982L37,953@41028L59,954@41096L44:TimePicker.kt#uh7d8r");
                TimePickerKt.HorizontalClockDisplay((TimePickerState)obj5, obj3, composer3, i22 |= i8);
                SpacerKt.Spacer(SizeKt.width-3ABfNKs((Modifier)Modifier.Companion, TimePickerKt.ClockDisplayBottomMargin), composer3, i36);
                TimePickerKt.ClockFace(obj5, obj3, z2, composer3, i18 |= i28);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = obj;
                obj2 = obj3;
            } else {
                restartGroup.skipToGroupEnd();
                i12 = $dirty2;
                $dirty = colors2;
                obj2 = obj3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new TimePickerKt.HorizontalTimePicker.2(obj5, $dirty, obj2, z2, $changed, i7);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final void PeriodToggleImpl(Modifier modifier, androidx.compose.material3.TimePickerState state, androidx.compose.material3.TimePickerColors colors, MeasurePolicy measurePolicy, Shape startShape, Shape endShape, Composer $composer, int $changed) {
        int $changed2;
        int i13;
        Object it$iv;
        int changedInstance;
        int traceInProgress;
        Object factory$iv$iv3;
        Object contentDescription;
        Object obj4;
        int $dirty;
        Composer composer;
        Object valueOf;
        int i9;
        boolean changedInstance2;
        int i19;
        int i20;
        int i7;
        int i5;
        Object obj;
        Composer composer2;
        Object empty;
        int i6;
        int afternoon;
        boolean traceInProgress2;
        Object obj2;
        int str;
        Object obj3;
        Object anon;
        int i16;
        Function3 lambda-2$material3_release;
        long factory$iv$iv2;
        int empty2;
        int i2;
        Shape shape;
        int i18;
        int i21;
        int i10;
        Composer.Companion currentCompositeKeyHash;
        int i17;
        int i14;
        int i4;
        androidx.compose.foundation.BorderStroke borderStroke;
        int i11;
        androidx.compose.material3.TimePickerKt.PeriodToggleImpl.2.1.1 time;
        int i12;
        int $dirty2;
        int i;
        Composer.Companion companion;
        Function0 factory$iv$iv;
        String str2;
        Modifier fillMaxSize$default;
        long periodSelectorBorderColor-0d7_KjU;
        int i3;
        int i15;
        int i8;
        String obj45;
        obj4 = modifier;
        final Object obj5 = state;
        valueOf = measurePolicy;
        final int i47 = $changed;
        traceInProgress = 1374241901;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(PeriodToggleImpl)P(3,5!1,2,4)1258@51953L5,1259@52008L41,1263@52129L128,1260@52054L1189:TimePicker.kt#uh7d8r");
        if (i47 & 6 == 0) {
            i9 = restartGroup.changed(obj4) ? 4 : 2;
            $dirty |= i9;
        }
        if (i47 & 48 == 0) {
            if (i47 & 64 == 0) {
                changedInstance2 = restartGroup.changed(obj5);
            } else {
                changedInstance2 = restartGroup.changedInstance(obj5);
            }
            i19 = changedInstance2 ? 32 : 16;
            $dirty |= i19;
        }
        if (i47 & 384 == 0) {
            i20 = restartGroup.changed(colors) ? 256 : 128;
            $dirty |= i20;
        } else {
            obj3 = colors;
        }
        if (i47 & 3072 == 0) {
            i7 = restartGroup.changed(valueOf) ? 2048 : 1024;
            $dirty |= i7;
        }
        if (i47 & 24576 == 0) {
            i5 = restartGroup.changed(startShape) ? 16384 : 8192;
            $dirty |= i5;
        } else {
            obj2 = startShape;
        }
        if (i36 &= i47 == 0) {
            i6 = restartGroup.changed(endShape) ? 131072 : 65536;
            $dirty |= i6;
        } else {
            obj = endShape;
        }
        if (i48 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.PeriodToggleImpl (TimePicker.kt:1254)");
                }
                androidx.compose.foundation.BorderStroke borderStroke2 = BorderStrokeKt.BorderStroke-cXLIe8U(TimePickerTokens.INSTANCE.getPeriodSelectorOutlineWidth-D9Ej5fM(), obj3.getPeriodSelectorBorderColor-0d7_KjU());
                int i54 = 6;
                Shape value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), restartGroup, i54);
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
                androidx.compose.material3.internal.Strings.Companion companion4 = Strings.Companion;
                int i58 = 0;
                String string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_time_picker_period_toggle_description), restartGroup, 0);
                String str11 = "CC(remember):TimePicker.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -2132305224, str11);
                obj45 = restartGroup;
                int i68 = 0;
                int i69 = i54;
                Object rememberedValue2 = obj45.rememberedValue();
                int i70 = 0;
                if (!restartGroup.changed(string-2EP1pXo)) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        int i46 = 0;
                        anon = new TimePickerKt.PeriodToggleImpl.1.1(string-2EP1pXo);
                        obj45.updateRememberedValue((Function1)anon);
                    } else {
                        composer2 = obj45;
                        anon = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i38 = 1;
                i10 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, BorderKt.border(SelectableGroupKt.selectableGroup(SemanticsModifierKt.semantics$default(obj4, false, (Function1)anon, i38, 0)), borderStroke2, (Shape)(CornerBasedShape)value));
                Function0 function0 = constructor;
                i17 = 0;
                i4 = i38;
                borderStroke = borderStroke2;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function0);
                } else {
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i40 = 0;
                Updater.set-impl(constructor-impl, valueOf, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i71 = 0;
                Composer composer5 = constructor-impl;
                int i73 = 0;
                if (!composer5.getInserting()) {
                    $dirty2 = $dirty;
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer5;
                    }
                } else {
                    $dirty2 = $dirty;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                factory$iv$iv3 = function0;
                factory$iv$iv2 = restartGroup;
                $dirty = 0;
                ComposerKt.sourceInformationMarkerStart(factory$iv$iv2, 822309452, "C1274@52547L29,1271@52427L283,1279@52723L219,1288@53072L28,1285@52955L272:TimePicker.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(factory$iv$iv2, -250565484, str11);
                i11 = i23;
                if ($dirty2 & 112 != 32) {
                    if ($dirty2 & 64 != 0 && restartGroup.changedInstance(obj5)) {
                        if (restartGroup.changedInstance(obj5)) {
                            i13 = i4;
                        } else {
                            i13 = 0;
                        }
                    } else {
                    }
                } else {
                }
                Composer composer4 = factory$iv$iv2;
                int i72 = 0;
                it$iv = composer4.rememberedValue();
                i = 0;
                if (i13 == 0) {
                    factory$iv$iv = factory$iv$iv3;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        factory$iv$iv3 = 0;
                        companion = it$iv;
                        it$iv = new TimePickerKt.PeriodToggleImpl.2.1.1(obj5);
                        composer4.updateRememberedValue((Function0)it$iv);
                    } else {
                        companion = it$iv;
                    }
                } else {
                    factory$iv$iv = factory$iv$iv3;
                }
                ComposerKt.sourceInformationMarkerEnd(factory$iv$iv2);
                empty = materializeModifier;
                String str3 = string-2EP1pXo;
                valueOf = currentCompositionLocalMap;
                TimePickerKt.ToggleItem(afternoon2 ^= 1, obj2, (Function0)it$iv, obj3, ComposableSingletons.TimePickerKt.INSTANCE.getLambda-1$material3_release(), factory$iv$iv2, i25 |= i45);
                int i56 = i4;
                int i49 = 0;
                SpacerKt.Spacer(BackgroundKt.background-bw27NRU$default(SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex(LayoutIdKt.layoutId((Modifier)Modifier.Companion, "Spacer"), 1073741824), 0, i56, 0), colors.getPeriodSelectorBorderColor-0d7_KjU(), obj35, 0, 2), factory$iv$iv2, i49);
                ComposerKt.sourceInformationMarkerStart(factory$iv$iv2, -250548685, str11);
                if ($dirty2 & 112 != 32) {
                    if ($dirty2 & 64 != 0 && restartGroup.changedInstance(obj5)) {
                        if (restartGroup.changedInstance(obj5)) {
                            i16 = i56;
                        } else {
                            i16 = i14;
                        }
                    } else {
                    }
                } else {
                }
                Composer composer3 = factory$iv$iv2;
                int i53 = 0;
                Object rememberedValue3 = composer3.rememberedValue();
                int i57 = 0;
                if (i16 == 0) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        obj45 = str3;
                        contentDescription = new TimePickerKt.PeriodToggleImpl.2.2.1(obj5);
                        composer3.updateRememberedValue((Function0)contentDescription);
                    } else {
                        obj45 = str3;
                        contentDescription = rememberedValue3;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(factory$iv$iv2);
                TimePickerKt.ToggleItem(obj5.isAfternoon(), obj, (Function0)contentDescription, colors, ComposableSingletons.TimePickerKt.INSTANCE.getLambda-2$material3_release(), factory$iv$iv2, i31 | obj4);
                ComposerKt.sourceInformationMarkerEnd(factory$iv$iv2);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                $dirty2 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new TimePickerKt.PeriodToggleImpl.3(modifier, obj5, colors, measurePolicy, startShape, endShape, i47);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void TimeInput(androidx.compose.material3.TimePickerState state, Modifier modifier, androidx.compose.material3.TimePickerColors colors, Composer $composer, int $changed, int i6) {
        int traceInProgress2;
        int $dirty;
        boolean changedInstance;
        int i;
        androidx.compose.material3.TimePickerDefaults iNSTANCE;
        int companion;
        boolean traceInProgress;
        int i2;
        int i3;
        int changed;
        int defaultsInvalid;
        Object state2;
        int i4;
        int i5;
        Object obj9;
        Object obj10;
        traceInProgress2 = -760850373;
        final Composer obj11 = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(obj11, "C(TimeInput)P(2,1)259@12999L8,261@13017L38:TimePicker.kt#uh7d8r");
        $dirty = $changed;
        if (i6 & 1 != 0) {
            $dirty |= 6;
        } else {
            if ($changed & 6 == 0) {
                if ($changed & 8 == 0) {
                    changedInstance = obj11.changed(state);
                } else {
                    changedInstance = obj11.changedInstance(state);
                }
                i = changedInstance != null ? 4 : 2;
                $dirty |= i;
            }
        }
        companion = i6 & 2;
        if (companion != 0) {
            $dirty |= 48;
        } else {
            if ($changed & 48 == 0) {
                i2 = obj11.changed(modifier) ? 32 : 16;
                $dirty |= i2;
            }
        }
        if ($changed & 384 == 0) {
            if (i6 & 4 == 0 && obj11.changed(colors)) {
                i3 = obj11.changed(colors) ? 256 : 128;
            } else {
            }
            $dirty |= i3;
        }
        if ($dirty & 147 == 146) {
            if (!obj11.getSkipping()) {
                obj11.startDefaults();
                if ($changed & 1 != 0) {
                    if (obj11.getDefaultsInvalid()) {
                        if (companion != 0) {
                            obj9 = companion;
                        }
                        if (i6 & 4 != 0) {
                            obj10 = TimePickerDefaults.INSTANCE.colors(obj11, 6);
                            $dirty &= -897;
                        }
                    } else {
                        obj11.skipToGroupEnd();
                        if (i6 & 4 != 0) {
                        }
                    }
                } else {
                }
                obj11.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.TimeInput (TimePicker.kt:260)");
                }
                TimePickerKt.TimeInputImpl(obj9, obj10, state, obj11, i9 |= companion);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj11.skipToGroupEnd();
            }
        } else {
        }
        obj9 = obj11.endRestartGroup();
        if (obj9 != null) {
            companion = new TimePickerKt.TimeInput.1(state, obj9, obj10, $changed, i6);
            obj9.updateScope((Function2)companion);
        } else {
            state2 = state;
            i4 = $changed;
        }
    }

    private static final void TimeInputImpl(Modifier modifier, androidx.compose.material3.TimePickerColors colors, androidx.compose.material3.TimePickerState state, Composer $composer, int $changed) {
        boolean traceInProgress;
        Object anon;
        Function0 factory$iv$iv$iv;
        Modifier size-VpY3zN4;
        Function0 factory$iv$iv$iv2;
        int $dirty;
        Integer maybeCachedBoxMeasurePolicy;
        int i27;
        int i;
        int i18;
        Composer $changed$iv;
        boolean traceInProgress2;
        int changedInstance;
        int i15;
        boolean changedInstance2;
        int valueOf;
        int changedInstance3;
        Composer composer3;
        Modifier materializeModifier;
        Object anon2;
        androidx.compose.foundation.layout.Arrangement.Horizontal valueOf2;
        Alignment $changed2;
        Object rowMeasurePolicy;
        Composer composer2;
        int minuteValue$delegate;
        int i5;
        MutableState empty2;
        int i10;
        Object currentCompositionLocalMap2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        Object empty;
        int i34;
        int companion;
        int i29;
        int i16;
        int i17;
        int currentCompositeKeyHash;
        androidx.compose.ui.Alignment.Vertical vertical;
        int i2;
        Modifier modifier4;
        int i33;
        Function0 function02;
        int i13;
        int i38;
        int i31;
        int i22;
        TextStyle textStyle;
        int i28;
        int i32;
        RowScopeInstance rowScopeInstance;
        androidx.compose.foundation.layout.Arrangement.Horizontal horizontalArrangement$iv;
        MeasurePolicy measurePolicy;
        Modifier modifier3;
        Composer composer4;
        MutableState mutableState;
        int timeSelectorContentColor-vNxB06k$material3_release;
        int i26;
        int i7;
        int i23;
        Modifier modifier2;
        TimeInputTokens iNSTANCE;
        int i14;
        Function0 function0;
        int i11;
        BoxScopeInstance boxScopeInstance;
        Object measurePolicy$iv;
        Composer $composer2;
        Composer composer;
        int i3;
        int i30;
        int i24;
        int i12;
        int i35;
        int center-e0LSkKk;
        int i6;
        int i36;
        int i25;
        int i8;
        int i19;
        int i20;
        int i9;
        int i37;
        int i21;
        int i4;
        int obj74;
        final Object obj = modifier;
        final Object obj2 = colors;
        final Object obj3 = state;
        final int i86 = $changed;
        traceInProgress = -475657989;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(TimeInputImpl)P(1)965@41356L112,965@41304L164,969@41552L104,969@41500L156,972@41661L4502:TimePicker.kt#uh7d8r");
        if (i86 & 6 == 0) {
            i27 = restartGroup.changed(obj) ? 4 : 2;
            $dirty |= i27;
        }
        if (i86 & 48 == 0) {
            i = restartGroup.changed(obj2) ? 32 : 16;
            $dirty |= i;
        }
        materializeModifier = 256;
        if (i86 & 384 == 0) {
            if (i86 & 512 == 0) {
                changedInstance2 = restartGroup.changed(obj3);
            } else {
                changedInstance2 = restartGroup.changedInstance(obj3);
            }
            i18 = changedInstance2 ? materializeModifier : 128;
            $dirty |= i18;
        }
        if ($dirty & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.TimeInputImpl (TimePicker.kt:963)");
                }
                int i39 = 0;
                String str3 = "CC(remember):TimePicker.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 339122986, str3);
                if ($dirty & 896 != materializeModifier) {
                    if ($dirty & 512 != 0 && restartGroup.changedInstance(obj3)) {
                        if (restartGroup.changedInstance(obj3)) {
                            i15 = 1;
                        } else {
                            i15 = i39;
                        }
                    } else {
                    }
                } else {
                }
                Composer composer7 = restartGroup;
                int i92 = 0;
                Object rememberedValue2 = composer7.rememberedValue();
                int i97 = 0;
                if (i15 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        anon2 = new TimePickerKt.TimeInputImpl.hourValue.2.1(obj3);
                        composer7.updateRememberedValue((Function0)anon2);
                    } else {
                        anon2 = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i103 = 1;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 339129250, str3);
                if ($dirty & 896 != 256) {
                    if ($dirty & 512 != 0 && restartGroup.changedInstance(obj3)) {
                        if (restartGroup.changedInstance(obj3)) {
                            i10 = i103;
                        } else {
                            i10 = i39;
                        }
                    } else {
                    }
                } else {
                }
                Composer composer6 = restartGroup;
                int i71 = 0;
                Object rememberedValue4 = composer6.rememberedValue();
                int i89 = 0;
                if (i10 == 0) {
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new TimePickerKt.TimeInputImpl.minuteValue.2.1(obj3);
                        composer6.updateRememberedValue((Function0)anon);
                    } else {
                        anon = rememberedValue4;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                MutableState mutableState2 = rememberSaveable;
                i5 = $dirty;
                int i94 = i103;
                int i90 = 0;
                Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default(obj, 0, 0, 0, TimePickerKt.TimeInputBottomPadding, 7, 0);
                androidx.compose.ui.Alignment.Vertical top = Alignment.Companion.getTop();
                int i60 = 384;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                valueOf2 = Arrangement.INSTANCE.getStart();
                rowMeasurePolicy = RowKt.rowMeasurePolicy(valueOf2, top, restartGroup, i79 |= i101);
                companion = 0;
                currentCompositionLocalMap2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositionLocalMap2);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                vertical = top;
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(restartGroup, padding-qDBjuR0$default);
                modifier4 = padding-qDBjuR0$default;
                Function0 function03 = constructor2;
                i2 = 0;
                $changed$iv = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, $changed$iv);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function03);
                } else {
                    factory$iv$iv$iv = function03;
                    restartGroup.useNode();
                }
                function02 = factory$iv$iv$iv;
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i108 = 0;
                i28 = i64;
                Updater.set-impl(constructor-impl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i109 = 0;
                Composer composer9 = constructor-impl;
                int i110 = 0;
                if (!composer9.getInserting()) {
                    horizontalArrangement$iv = valueOf2;
                    measurePolicy = rowMeasurePolicy;
                    if (!Intrinsics.areEqual(composer9.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer9;
                    }
                } else {
                    horizontalArrangement$iv = valueOf2;
                    measurePolicy = rowMeasurePolicy;
                }
                Updater.set-impl(constructor-impl, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                valueOf = restartGroup;
                i22 = i45;
                ComposerKt.sourceInformationMarkerStart(valueOf, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                Composer composer8 = valueOf;
                i32 = 0;
                rowScopeInstance = iNSTANCE2;
                modifier3 = materializeModifier2;
                ComposerKt.sourceInformationMarkerStart(valueOf, -1328966913, "C977@41861L5,986@42225L3553,982@42004L3774:TimePicker.kt#uh7d8r");
                TextStyle copy-p1EtxEg$default = TextStyle.copy-p1EtxEg$default(TypographyKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldLabelTextFont(), valueOf, 6), obj2.timeSelectorContentColor-vNxB06k$material3_release(true), obj41, 0, obj43, 0, 0, 0, 0, 0, 0, obj50, 0, 0, 0, 0, obj55, 0, 0, 0, TextAlign.Companion.getCenter-e0LSkKk(), 0, 0, obj62, 0, 0, 0);
                $dirty = new ProvidedValue[2];
                obj74 = i74;
                textStyle = copy-p1EtxEg$default;
                int i75 = 1;
                $dirty[i75] = CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr);
                TimePickerKt.TimeInputImpl.1.1 anon3 = new TimePickerKt.TimeInputImpl.1.1(RememberSaveableKt.rememberSaveable(new Object[i39], TextFieldValue.Companion.getSaver(), 0, (Function0)anon2, restartGroup, 0, 4), obj3, obj2, mutableState2);
                i29 = i84;
                mutableState = mutableState2;
                CompositionLocalKt.CompositionLocalProvider($dirty, (Function2)ComposableLambdaKt.rememberComposableLambda(1306700887, i75, anon3, valueOf, 54), valueOf, $stable |= 48);
                valueOf.startReplaceGroup(511443242);
                ComposerKt.sourceInformation(valueOf, "1073@45823L324");
                if (!obj3.is24hour()) {
                    Modifier padding-qDBjuR0$default2 = PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, TimePickerKt.PeriodToggleMargin, 0, 0, 0, 14, 0);
                    ComposerKt.sourceInformationMarkerStart(valueOf, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    timeSelectorContentColor-vNxB06k$material3_release = i55;
                    maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.Companion.getTopStart(), false);
                    i7 = 0;
                    i23 = i76;
                    ComposerKt.sourceInformationMarkerStart(valueOf, -1323940314, currentCompositionLocalMap2);
                    i16 = currentCompositeKeyHash2;
                    modifier2 = padding-qDBjuR0$default2;
                    int i105 = 6;
                    Function0 function04 = constructor;
                    i17 = 0;
                    ComposerKt.sourceInformationMarkerStart(valueOf, -692256719, $changed$iv);
                    if (!applier2 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    valueOf.startReusableNode();
                    if (valueOf.getInserting()) {
                        valueOf.createNode(function04);
                    } else {
                        factory$iv$iv$iv2 = function04;
                        valueOf.useNode();
                    }
                    Composer constructor-impl2 = Updater.constructor-impl(valueOf);
                    int i107 = 0;
                    function0 = factory$iv$iv$iv2;
                    Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, valueOf.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i116 = 0;
                    Composer composer11 = constructor-impl2;
                    int i118 = 0;
                    if (!composer11.getInserting()) {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        $composer2 = valueOf;
                        if (!Intrinsics.areEqual(composer11.rememberedValue(), Integer.valueOf(i16))) {
                            composer11.updateRememberedValue(Integer.valueOf(i16));
                            constructor-impl2.apply(Integer.valueOf(i16), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer3 = composer11;
                        }
                    } else {
                        measurePolicy$iv = maybeCachedBoxMeasurePolicy;
                        $composer2 = valueOf;
                    }
                    Updater.set-impl(constructor-impl2, ComposedModifierKt.materializeModifier(valueOf, padding-qDBjuR0$default2), ComposeUiNode.Companion.getSetModifier());
                    Composer composer5 = $composer2;
                    i31 = i51;
                    ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    int i106 = 6;
                    i11 = 0;
                    boxScopeInstance = iNSTANCE4;
                    i3 = i61;
                    $changed$iv = composer10;
                    ComposerKt.sourceInformationMarkerStart($changed$iv, -415465671, "C1074@45891L242:TimePicker.kt#uh7d8r");
                    i30 = i68;
                    i13 = 6;
                    TimePickerKt.VerticalPeriodToggle(SizeKt.size-VpY3zN4((Modifier)Modifier.Companion, TimeInputTokens.INSTANCE.getPeriodSelectorContainerWidth-D9Ej5fM(), TimeInputTokens.INSTANCE.getPeriodSelectorContainerHeight-D9Ej5fM()), obj3, obj2, $changed$iv, i58 |= valueOf);
                    ComposerKt.sourceInformationMarkerEnd($changed$iv);
                    ComposerKt.sourceInformationMarkerEnd(composer5);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    $composer2 = valueOf;
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd(valueOf);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i5 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = new TimePickerKt.TimeInputImpl.2(obj, obj2, obj3, i86);
            endRestartGroup.updateScope((Function2)$dirty);
        }
    }

    private static final void TimeInputImpl$lambda$10(MutableState<TextFieldValue> $minuteValue$delegate, TextFieldValue value) {
        final int i2 = i;
        final int i3 = 0;
        $minuteValue$delegate.setValue(value);
    }

    private static final TextFieldValue TimeInputImpl$lambda$6(MutableState<TextFieldValue> $hourValue$delegate) {
        final int i2 = i;
        final int i3 = 0;
        return (TextFieldValue)(State)$hourValue$delegate.getValue();
    }

    private static final void TimeInputImpl$lambda$7(MutableState<TextFieldValue> $hourValue$delegate, TextFieldValue value) {
        final int i2 = i;
        final int i3 = 0;
        $hourValue$delegate.setValue(value);
    }

    private static final TextFieldValue TimeInputImpl$lambda$9(MutableState<TextFieldValue> $minuteValue$delegate) {
        final int i2 = i;
        final int i3 = 0;
        return (TextFieldValue)(State)$minuteValue$delegate.getValue();
    }

    public static final void TimePicker-mT9BvqQ(androidx.compose.material3.TimePickerState state, Modifier modifier, androidx.compose.material3.TimePickerColors colors, int layoutType, Composer $composer, int $changed, int i7) {
        int traceInProgress2;
        int i9;
        int i6;
        int $dirty;
        Object $dirty4;
        int $dirty3;
        int i5;
        Object $dirty2;
        int modifier4;
        Object modifier2;
        boolean changedInstance;
        int i8;
        int changed;
        int i4;
        Object $i$f$cache;
        boolean traceInProgress;
        int i3;
        Object obj;
        int modifier3;
        Object layoutType2;
        int changed2;
        int i10;
        int changed3;
        boolean skipping;
        int defaultsInvalid;
        int i;
        int i2;
        State rememberAccessibilityServiceState;
        Object empty;
        Object analogTimePickerState;
        final Object obj2 = state;
        final int i17 = $changed;
        traceInProgress2 = -619286452;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(TimePicker)P(3,2!,1:c#material3.TimePickerLayoutType)218@11441L8,219@11509L12,221@11558L35,222@11616L48:TimePicker.kt#uh7d8r");
        $dirty = $changed;
        changed = 4;
        if (i7 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i17 & 6 == 0) {
                if (i17 & 8 == 0) {
                    changedInstance = restartGroup.changed(obj2);
                } else {
                    changedInstance = restartGroup.changedInstance(obj2);
                }
                i5 = changedInstance != null ? changed : 2;
                $dirty |= i5;
            }
        }
        int i13 = i7 & 2;
        if (i13 != 0) {
            $dirty |= 48;
            $i$f$cache = modifier;
        } else {
            if (i17 & 48 == 0) {
                i3 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty |= i3;
            } else {
                $i$f$cache = modifier;
            }
        }
        if (i17 & 384 == 0) {
            if (i7 & 4 == 0) {
                changed2 = restartGroup.changed(colors) ? 256 : 128;
            } else {
                obj = colors;
            }
            $dirty |= changed2;
        } else {
            obj = colors;
        }
        if (i17 & 3072 == 0) {
            if (i7 & 8 == 0) {
                changed3 = restartGroup.changed(layoutType) ? 2048 : 1024;
            } else {
                i10 = layoutType;
            }
            $dirty |= changed3;
        } else {
            i10 = layoutType;
        }
        if ($dirty & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i17 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i13 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = $i$f$cache;
                        }
                        defaultsInvalid = 6;
                        if (i7 & 4 != 0) {
                            $i$f$cache = TimePickerDefaults.INSTANCE.colors(restartGroup, defaultsInvalid);
                            $dirty &= -897;
                        } else {
                            $i$f$cache = obj;
                        }
                        if (i7 & 8 != 0) {
                            modifier4 = $dirty5;
                            $dirty3 = layoutType-sDNSZnc;
                            layoutType2 = obj4;
                            i10 = $i$f$cache;
                        } else {
                            layoutType2 = modifier2;
                            modifier4 = $dirty;
                            $dirty3 = i10;
                            i10 = $i$f$cache;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i7 & 4 != 0) {
                            $dirty &= -897;
                        }
                        if (i7 & 8 != 0) {
                            $dirty &= -7169;
                        }
                        modifier4 = $dirty;
                        $dirty3 = i10;
                        i10 = obj;
                        layoutType2 = $i$f$cache;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, modifier4, -1, "androidx.compose.material3.TimePicker (TimePicker.kt:220)");
                }
                i9 = 0;
                rememberAccessibilityServiceState = AccessibilityServiceStateProvider_androidKt.rememberAccessibilityServiceState(i9, i9, restartGroup, i9, 3);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -2089091954, "CC(remember):TimePicker.kt#9igjgp");
                int i29 = 1;
                if (modifier4 & 14 != changed) {
                    if (modifier4 & 8 != 0 && restartGroup.changed(obj2)) {
                        if (restartGroup.changed(obj2)) {
                            i9 = i29;
                        }
                    }
                } else {
                }
                Composer composer = restartGroup;
                int i22 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i30 = 0;
                if (i9 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        analogTimePickerState = new AnalogTimePickerState(obj2);
                        composer.updateRememberedValue(analogTimePickerState);
                    } else {
                        analogTimePickerState = rememberedValue;
                    }
                } else {
                }
                $i$f$cache = analogTimePickerState;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (TimePickerLayoutType.equals-impl0($dirty3, TimePickerLayoutType.Companion.getVertical-QJTpgSE())) {
                    restartGroup.startReplaceGroup(-337235422);
                    ComposerKt.sourceInformation(restartGroup, "224@11728L178");
                    TimePickerKt.VerticalTimePicker((AnalogTimePickerState)$i$f$cache, layoutType2, i10, i29 ^= z2, restartGroup, i6 | i4, 0);
                    restartGroup.endReplaceGroup();
                } else {
                    restartGroup.startReplaceGroup(-337036960);
                    ComposerKt.sourceInformation(restartGroup, "231@11928L180");
                    TimePickerKt.HorizontalTimePicker($i$f$cache, layoutType2, i10, i29 ^= z, restartGroup, i6 | i4, 0);
                    restartGroup.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i8 = $dirty3;
                $dirty4 = layoutType2;
                modifier3 = modifier4;
                $dirty2 = i10;
            } else {
                restartGroup.skipToGroupEnd();
                $dirty2 = obj;
                i8 = i10;
                modifier3 = $dirty;
                $dirty4 = $i$f$cache;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new TimePickerKt.TimePicker.1(obj2, $dirty4, $dirty2, i8, i17, i7);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final androidx.compose.material3.TimePickerState TimePickerState(int initialHour, int initialMinute, boolean is24Hour) {
        TimePickerStateImpl timePickerStateImpl = new TimePickerStateImpl(initialHour, initialMinute, is24Hour);
        return (TimePickerState)timePickerStateImpl;
    }

    private static final void TimePickerTextField-1vLObsk(Modifier modifier, TextFieldValue value, Function1<? super TextFieldValue, Unit> onValueChange, androidx.compose.material3.TimePickerState state, int selection, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, androidx.compose.material3.TimePickerColors colors, Composer $composer, int $changed, int i11) {
        Object $i$a$CacheTimePickerKt$TimePickerTextField$interactionSource$1;
        int i41;
        Object invalid$iv3;
        Function0 factory$iv$iv$iv;
        int i62;
        int hourForDisplay;
        boolean traceInProgress2;
        int this_$iv;
        Object box-impl;
        int skipping;
        boolean traceInProgress;
        Object $i$a$CacheTimePickerKt$TimePickerTextField$focusRequester$1;
        int $composer$iv3;
        Integer currentCompositionLocalMap;
        Object it$iv;
        int i67;
        int changedInstance;
        boolean columnMeasurePolicy;
        Composer composer4;
        int m3c_time_picker_hour;
        androidx.compose.material3.TimePickerState $composer3;
        int i71;
        Composer composer7;
        int $dirty2;
        int this_$iv2;
        Object currentCompositionLocalMap2;
        int $dirty;
        int i52;
        Composer composer2;
        Object valueOf;
        int i42;
        Object obj3;
        int m3c_time_picker_minute_text_field;
        Object invalid$iv;
        Object obj6;
        int $dirty3;
        Object contentDescription2;
        int i79;
        int i15;
        Object measurePolicy$iv;
        Object rememberedValue;
        int i48;
        boolean changedInstance2;
        int i70;
        int i36;
        int str2;
        int i3;
        int i57;
        Object $composer2;
        Composer composer3;
        Object empty;
        int $dirty4;
        int i45;
        int materialized$iv$iv;
        Object anon;
        Object horizontalAlignment$iv;
        int contentAlignment$iv;
        Object focusRequester;
        int i51;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i60;
        Composer propagateMinConstraints$iv;
        Composer composer5;
        int contentDescription;
        int $composer$iv2;
        MeasurePolicy measurePolicy$iv2;
        int interactionSource;
        int i21;
        int i20;
        int i55;
        int i73;
        int currentCompositeKeyHash;
        Function0 function0;
        int i;
        int i28;
        androidx.compose.runtime.CompositionLocalMap map;
        MeasurePolicy localMap$iv$iv;
        int i9;
        int i40;
        String string-2EP1pXo;
        Modifier clearAndSetSemantics;
        long value2;
        int i43;
        int i58;
        int i7;
        int i31;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv2;
        int i32;
        Function0 function02;
        int i33;
        int i53;
        int i46;
        int i38;
        int i30;
        int i10;
        Object obj;
        Composer.Companion companion;
        MeasurePolicy measurePolicy;
        boolean invalid$iv2;
        int i61;
        int i27;
        int i63;
        int i14;
        int i47;
        TextStyle value3;
        Composer composer6;
        int i2;
        int i5;
        int i8;
        ColumnScopeInstance columnScopeInstance;
        int i6;
        int i49;
        androidx.compose.runtime.CompositionLocalMap map2;
        Composer $composer$iv;
        androidx.compose.material3.TextFieldColors field;
        boolean z;
        androidx.compose.foundation.layout.Arrangement.Vertical vertical;
        androidx.compose.ui.Alignment.Horizontal horizontal;
        Modifier modifier2;
        String str3;
        int i56;
        int i35;
        int i13;
        int i16;
        int i37;
        int i24;
        int i50;
        int i39;
        int i54;
        int i81;
        int i25;
        int i4;
        int i23;
        int i69;
        int i80;
        int i12;
        int i82;
        int i64;
        int i19;
        int i29;
        int i59;
        int i76;
        int i26;
        int i75;
        int i34;
        int i68;
        int i74;
        int i44;
        Composer composer;
        int i65;
        int i78;
        int i17;
        int i77;
        int i72;
        int i66;
        int i18;
        Object obj5;
        Object obj2;
        int i22;
        Object obj4;
        String str;
        Modifier obj117;
        androidx.compose.foundation.layout.Arrangement.Vertical obj118;
        Modifier obj120;
        traceInProgress2 = modifier;
        box-impl = value;
        Object obj7 = state;
        i42 = selection;
        Object obj8 = colors;
        invalid$iv3 = $changed;
        rememberedValue = i11;
        Composer restartGroup = $composer.startRestartGroup(1299172990);
        ComposerKt.sourceInformation(restartGroup, "C(TimePickerTextField)P(3,7,4,6,5:c#material3.TimePickerSelectionMode,2,1)1762@68219L39,1763@68284L29,1765@68374L243,1771@68670L3410,1857@72118L103,1857@72086L135:TimePicker.kt#uh7d8r");
        $dirty3 = $changed;
        final int i275 = 4;
        final int i276 = 2;
        if (rememberedValue & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (invalid$iv3 & 6 == 0) {
                i79 = restartGroup.changed(traceInProgress2) ? i275 : i276;
                $dirty3 |= i79;
            }
        }
        if (rememberedValue & 2 != 0) {
            $dirty3 |= 48;
        } else {
            if (invalid$iv3 & 48 == 0) {
                i15 = restartGroup.changed(box-impl) ? 32 : 16;
                $dirty3 |= i15;
            }
        }
        if (rememberedValue & 4 != 0) {
            $dirty3 |= 384;
            measurePolicy$iv = onValueChange;
        } else {
            if (invalid$iv3 & 384 == 0) {
                i48 = restartGroup.changedInstance(onValueChange) ? 256 : 128;
                $dirty3 |= i48;
            } else {
                measurePolicy$iv = onValueChange;
            }
        }
        if (rememberedValue & 8 != 0) {
            $dirty3 |= 3072;
        } else {
            if (invalid$iv3 & 3072 == 0) {
                if (invalid$iv3 & 4096 == 0) {
                    changedInstance2 = restartGroup.changed(obj7);
                } else {
                    changedInstance2 = restartGroup.changedInstance(obj7);
                }
                i70 = changedInstance2 ? 2048 : 1024;
                $dirty3 |= i70;
            }
        }
        if (rememberedValue & 16 != 0) {
            $dirty3 |= 24576;
        } else {
            if (invalid$iv3 & 24576 == 0) {
                i36 = restartGroup.changed(i42) ? 16384 : 8192;
                $dirty3 |= i36;
            }
        }
        str2 = rememberedValue & 32;
        int i170 = 196608;
        if (str2 != null) {
            $dirty3 |= i170;
            empty = keyboardOptions;
        } else {
            if (i170 &= invalid$iv3 == 0) {
                i45 = restartGroup.changed(keyboardOptions) ? 131072 : 65536;
                $dirty3 |= i45;
            } else {
                empty = keyboardOptions;
            }
        }
        anon = rememberedValue & 64;
        int i181 = 1572864;
        if (anon != 0) {
            $dirty3 |= i181;
            horizontalAlignment$iv = keyboardActions;
        } else {
            if (i181 &= invalid$iv3 == 0) {
                contentAlignment$iv = restartGroup.changed(keyboardActions) ? 1048576 : 524288;
                $dirty3 |= contentAlignment$iv;
            } else {
                horizontalAlignment$iv = keyboardActions;
            }
        }
        if (rememberedValue & 128 != 0) {
            i3 = 12582912;
            $dirty3 |= i3;
        } else {
        }
        if (i168 &= $dirty3 == 4793490) {
            if (!restartGroup.getSkipping()) {
                if (str2 != null) {
                    obj5 = skipping;
                } else {
                    obj5 = empty;
                }
                if (anon != 0) {
                    obj2 = skipping;
                } else {
                    obj2 = horizontalAlignment$iv;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1299172990, $dirty3, -1, "androidx.compose.material3.TimePickerTextField (TimePicker.kt:1761)");
                }
                String str17 = "CC(remember):TimePicker.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 882970966, str17);
                int i99 = 0;
                Composer composer13 = restartGroup;
                int i171 = 0;
                Object rememberedValue4 = composer13.rememberedValue();
                int i183 = 0;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    int i83 = 0;
                    composer13.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                } else {
                    $i$a$CacheTimePickerKt$TimePickerTextField$interactionSource$1 = rememberedValue4;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 882973036, str17);
                Composer composer14 = restartGroup;
                int i172 = 0;
                Object rememberedValue5 = composer14.rememberedValue();
                int i184 = 0;
                obj117 = i101;
                if (rememberedValue5 == Composer.Companion.getEmpty()) {
                    int i118 = 0;
                    focusRequester = new FocusRequester();
                    composer14.updateRememberedValue(focusRequester);
                } else {
                    $i$a$CacheTimePickerKt$TimePickerTextField$focusRequester$1 = rememberedValue5;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i173 = 1;
                int i185 = i173;
                int i195 = i185;
                int i201 = i195;
                int i209 = i201;
                int i211 = i209;
                int i213 = i211;
                int i215 = i213;
                String str29 = str28;
                int i223 = i217;
                int i225 = i223;
                int i228 = i225;
                int i230 = i228;
                int i233 = i230;
                int i236 = i233;
                int i238 = i236;
                int i244 = i238;
                int i246 = i244;
                int i248 = i246;
                int i250 = i248;
                int i252 = i250;
                int i254 = i252;
                int i256 = i254;
                int i258 = i256;
                int i261 = i258;
                int i265 = i261;
                i35 = i265;
                i16 = i35;
                i24 = i16;
                i39 = i24;
                i81 = i39;
                i4 = i81;
                i69 = i4;
                i12 = i69;
                i64 = i12;
                i29 = i64;
                i76 = i29;
                i75 = i76;
                i68 = i75;
                i44 = i68;
                i22 = i274;
                String str15 = str62;
                Composer composer19 = restartGroup;
                int $composer4 = 16384;
                androidx.compose.material3.TextFieldColors colors-0hiis_0 = OutlinedTextFieldDefaults.INSTANCE.colors-0hiis_0(obj8.timeSelectorContentColor-vNxB06k$material3_release(i185), i173, 0, i185, 0, i195, 0, i201, obj8.timeSelectorContainerColor-vNxB06k$material3_release(i173), obj21, obj8.timeSelectorContainerColor-vNxB06k$material3_release(i173), obj23, 0, i209, 0, i211, 0, i213, 0, i215, 0, 0, str29, 0, i223, 0, i225, 0, i228, 0, i230, 0, i233, 0, i236, 0, i238, 0, i244, 0, i246, 0, i248, 0, i250, 0, i252, 0, i254, 0, i256);
                Composer composer15 = composer19;
                boolean equals-impl04 = TimePickerSelectionMode.equals-impl0(i42, obj7.getSelection-yecRtBI());
                i21 = i176;
                i20 = 0;
                ComposerKt.sourceInformationMarkerStart(composer15, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                androidx.compose.foundation.layout.Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                androidx.compose.ui.Alignment.Horizontal start = Alignment.Companion.getStart();
                columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, start, composer15, i188 | i197);
                i73 = 0;
                obj117 = $i$a$CacheTimePickerKt$TimePickerTextField$focusRequester$1;
                ComposerKt.sourceInformationMarkerStart(composer15, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer15, 0);
                currentCompositionLocalMap2 = composer15.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer15, traceInProgress2);
                Function0 function03 = constructor;
                i28 = 0;
                ComposerKt.sourceInformationMarkerStart(composer15, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer15.startReusableNode();
                if (composer15.getInserting()) {
                    composer15.createNode(function03);
                } else {
                    factory$iv$iv$iv = function03;
                    composer15.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(composer15);
                i51 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap2, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                i60 = 0;
                composer5 = constructor-impl;
                int i204 = 0;
                if (!composer5.getInserting()) {
                    measurePolicy$iv2 = columnMeasurePolicy;
                    map = currentCompositionLocalMap2;
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer7 = composer5;
                    }
                } else {
                    measurePolicy$iv2 = columnMeasurePolicy;
                    map = currentCompositionLocalMap2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer8 = composer15;
                i9 = 0;
                ComposerKt.sourceInformationMarkerStart(composer8, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                i40 = i126 | 6;
                $dirty2 = $dirty3;
                Composer $dirty6 = composer8;
                columnScopeInstance = iNSTANCE4;
                i6 = 0;
                i49 = i86;
                ComposerKt.sourceInformationMarkerStart($dirty6, -2071429233, "C1788@69244L240,1796@69494L2047,1845@71677L244,1852@71988L5,1853@72059L5,1842@71551L523:TimePicker.kt#uh7d8r");
                $dirty6.startReplaceGroup(2011386807);
                ComposerKt.sourceInformation($dirty6, "1773@68737L450");
                if (!equals-impl04) {
                    if (TimePickerSelectionMode.equals-impl0(i42, TimePickerSelectionMode.Companion.getHour-yecRtBI())) {
                        i71 = hourForDisplay;
                    } else {
                        i71 = hourForDisplay;
                    }
                    i62 = $dirty2;
                    composer = composer15;
                    $composer$iv = i60;
                    map2 = map;
                    $composer2 = obj117;
                    obj117 = materializeModifier;
                    localMap$iv$iv = measurePolicy$iv2;
                    materialized$iv$iv = 0;
                    TimePickerKt.TimeSelector-SAnMeKU(SizeKt.size-VpY3zN4((Modifier)Modifier.Companion, TimeInputTokens.INSTANCE.getTimeFieldContainerWidth-D9Ej5fM(), TimeInputTokens.INSTANCE.getTimeFieldContainerHeight-D9Ej5fM()), i71, state, i42, obj8, $dirty6, i94 |= i51);
                    $composer$iv3 = i42;
                    composer4 = $dirty6;
                } else {
                    $composer$iv = composer8;
                    i62 = $dirty2;
                    $composer$iv3 = i42;
                    composer4 = $dirty6;
                    composer = composer15;
                    map2 = map;
                    $composer2 = obj117;
                    obj117 = materializeModifier;
                    localMap$iv$iv = measurePolicy$iv2;
                    materialized$iv$iv = 0;
                }
                composer4.endReplaceGroup();
                if (TimePickerSelectionMode.equals-impl0($composer$iv3, TimePickerSelectionMode.Companion.getMinute-yecRtBI())) {
                    androidx.compose.material3.internal.Strings.Companion companion20 = Strings.Companion;
                    i52 = 0;
                    this_$iv2 = Strings.constructor-impl(R.string.m3c_time_picker_minute_text_field);
                } else {
                    androidx.compose.material3.internal.Strings.Companion companion19 = Strings.Companion;
                    i52 = 0;
                    this_$iv2 = m3c_time_picker_minute_text_field;
                }
                String string-2EP1pXo2 = Strings_androidKt.getString-2EP1pXo(this_$iv2, composer4, materialized$iv$iv);
                Modifier visible = TimePickerKt.visible((Modifier)Modifier.Companion, equals-impl04);
                int i219 = i143;
                int i220 = 0;
                ComposerKt.sourceInformationMarkerStart(composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart = Alignment.Companion.getTopStart();
                int i150 = 0;
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i150);
                ComposerKt.sourceInformationMarkerStart(composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer4, visible);
                i7 = i140;
                valueOf = constructor2;
                int i227 = 0;
                ComposerKt.sourceInformationMarkerStart(composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier2 instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer4.startReusableNode();
                if (composer4.getInserting()) {
                    composer4.createNode(valueOf);
                } else {
                    composer4.useNode();
                }
                Composer constructor-impl2 = Updater.constructor-impl(composer4);
                int i151 = 0;
                composer6 = composer4;
                Updater.set-impl(constructor-impl2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i202 = 0;
                Composer composer16 = constructor-impl2;
                int i205 = 0;
                if (!composer16.getInserting()) {
                    localMap$iv$iv2 = currentCompositionLocalMap;
                    function02 = valueOf;
                    if (!Intrinsics.areEqual(composer16.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composer16.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        constructor-impl2.apply(Integer.valueOf(currentCompositeKeyHash2), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer16;
                    }
                } else {
                    localMap$iv$iv2 = currentCompositionLocalMap;
                    function02 = valueOf;
                }
                Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                int i231 = i107 & 14;
                Composer composer9 = composer6;
                ComposerKt.sourceInformationMarkerStart(composer9, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                int i234 = i142 | 6;
                Composer composer11 = composer9;
                BoxScopeInstance boxScopeInstance = iNSTANCE5;
                int i237 = 0;
                ComposerKt.sourceInformationMarkerStart(composer11, -1024044049, "C1803@69837L48,1807@70087L7,1814@70388L11,1815@70456L11,1819@70616L915,1797@69540L1991:TimePicker.kt#uh7d8r");
                ComposerKt.sourceInformationMarkerStart(composer11, -1002857443, str15);
                invalid$iv = composer11.changed(string-2EP1pXo2);
                Composer composer12 = composer11;
                int i203 = 0;
                it$iv = composer12.rememberedValue();
                int i206 = 0;
                if (!invalid$iv) {
                    invalid$iv2 = invalid$iv;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        invalid$iv = 0;
                        obj = it$iv;
                        it$iv = new TimePickerKt.TimePickerTextField.1.1.1.1(string-2EP1pXo2);
                        composer12.updateRememberedValue((Function1)it$iv);
                    } else {
                        obj = it$iv;
                    }
                } else {
                    invalid$iv2 = invalid$iv;
                }
                ComposerKt.sourceInformationMarkerEnd(composer11);
                int contentDescription3 = 1;
                int i153 = 6;
                int i207 = 0;
                int i239 = contentDescription3;
                ComposerKt.sourceInformationMarkerStart(composer11, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(composer11);
                kotlin.Pair[] arr = new Pair[6];
                arr[i239] = TuplesKt.to(0.1f, Color.box-impl(Color.Companion.getTransparent-0d7_KjU()));
                kotlin.Pair[] objArr = arr;
                objArr[i276] = TuplesKt.to(0.1f, Color.box-impl(MaterialTheme.INSTANCE.getColorScheme(composer11, 6).getPrimary-0d7_KjU()));
                objArr[3] = TuplesKt.to(0.9f, Color.box-impl(MaterialTheme.INSTANCE.getColorScheme(composer11, 6).getPrimary-0d7_KjU()));
                objArr[i275] = TuplesKt.to(0.9f, Color.box-impl(Color.Companion.getTransparent-0d7_KjU()));
                objArr[5] = TuplesKt.to(1f, Color.box-impl(Color.Companion.getTransparent-0d7_KjU()));
                TimePickerKt.TimePickerTextField.1.1.2 anon2 = new TimePickerKt.TimePickerTextField.1.1.2(box-impl, (MutableInteractionSource)$i$a$CacheTimePickerKt$TimePickerTextField$interactionSource$1, colors-0hiis_0);
                int i96 = i239;
                int i242 = i200;
                propagateMinConstraints$iv = composer11;
                Modifier modifier4 = materializeModifier2;
                modifier2 = obj117;
                vertical = obj118;
                i41 = i96;
                str3 = str14;
                field = field3;
                obj4 = obj10;
                z = z4;
                horizontal = horizontal2;
                measurePolicy$iv = obj2;
                int $dirty5 = 0;
                androidx.compose.runtime.CompositionLocalMap textFieldColors2 = localMap$iv$iv2;
                Function0 focusRequester5 = function02;
                Modifier localMap$iv$iv3 = obj120;
                Alignment factory$iv$iv$iv2 = alignment;
                BasicTextFieldKt.BasicTextField(value, onValueChange, SemanticsModifierKt.semantics$default(SizeKt.size-VpY3zN4(FocusRequesterModifierKt.focusRequester((Modifier)Modifier.Companion, $composer2), TimeInputTokens.INSTANCE.getTimeFieldContainerWidth-D9Ej5fM(), TimeInputTokens.INSTANCE.getTimeFieldContainerHeight-D9Ej5fM()), false, (Function1)it$iv, contentDescription3, 0), true, false, (TextStyle)composer11.consume((CompositionLocal)TextKt.getLocalTextStyle()), obj5, measurePolicy$iv, true, 0, 0, 0, 0, $i$a$CacheTimePickerKt$TimePickerTextField$interactionSource$1, Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, objArr, 0, 0, 0, 14, 0), (Function3)ComposableLambdaKt.rememberComposableLambda(825138052, i96, anon2, composer11, 54), propagateMinConstraints$iv, i136 |= i162, 199680, 7696);
                ComposerKt.sourceInformationMarkerEnd(propagateMinConstraints$iv);
                ComposerKt.sourceInformationMarkerEnd(composer9);
                composer6.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerEnd(composer6);
                i42 = selection;
                if (TimePickerSelectionMode.equals-impl0(i42, TimePickerSelectionMode.Companion.getHour-yecRtBI())) {
                    androidx.compose.material3.internal.Strings.Companion companion9 = Strings.Companion;
                    i67 = 0;
                    this_$iv = Strings.constructor-impl(R.string.m3c_time_picker_hour);
                } else {
                    androidx.compose.material3.internal.Strings.Companion companion8 = Strings.Companion;
                    i67 = 0;
                    this_$iv = m3c_time_picker_hour;
                }
                Composer composer10 = composer6;
                int i180 = 0;
                int i114 = 6;
                TextKt.Text--4IGK_g(Strings_androidKt.getString-2EP1pXo(this_$iv, composer10, i180), SemanticsModifierKt.clearAndSetSemantics(OffsetKt.offset-VpY3zN4$default((Modifier)Modifier.Companion, 0, TimePickerKt.SupportLabelTop, i41, $dirty5), (Function1)TimePickerKt.TimePickerTextField.1.2.INSTANCE), ColorSchemeKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSupportingTextColor(), composer10, i114), 0, 0, i7, 0, 0, 0, 0, 0, 0, false, 0, maybeCachedBoxMeasurePolicy, 0, 0, 0, 0, 0, TypographyKt.getValue(TimeInputTokens.INSTANCE.getTimeFieldSupportingTextFont(), composer10, i114));
                ComposerKt.sourceInformationMarkerEnd(composer6);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer3 = composer;
                ComposerKt.sourceInformationMarkerStart(composer3, 883095798, str15);
                $dirty = obj117;
                if ($dirty & 7168 != 2048) {
                    if ($dirty & 4096 != 0) {
                        if (composer3.changedInstance(state)) {
                            empty = i41;
                        } else {
                            empty = i180;
                        }
                    } else {
                        $composer3 = state;
                    }
                } else {
                    $composer3 = state;
                }
                if (i116 &= $dirty == 16384) {
                } else {
                    i41 = i180;
                }
                i41 |= empty;
                skipping = composer3;
                int i149 = 0;
                rememberedValue = skipping.rememberedValue();
                str2 = 0;
                if (i84 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        obj117 = i84;
                        anon = new TimePickerKt.TimePickerTextField.2.1($composer3, i42, obj4, $dirty5);
                        skipping.updateRememberedValue((Function2)anon);
                    } else {
                        obj117 = i84;
                        anon = rememberedValue;
                        invalid$iv3 = obj4;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                EffectsKt.LaunchedEffect(TimePickerSelectionMode.box-impl(state.getSelection-yecRtBI()), (Function2)anon, composer3, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj6 = measurePolicy$iv;
            } else {
                restartGroup.skipToGroupEnd();
                composer3 = restartGroup;
                $composer3 = obj7;
                $dirty = $dirty3;
                contentDescription2 = empty;
                obj6 = horizontalAlignment$iv;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer3.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty4 = $dirty;
            invalid$iv3 = new TimePickerKt.TimePickerTextField.3(modifier, value, onValueChange, $composer3, i42, contentDescription2, obj6, colors, $changed, i11);
            endRestartGroup.updateScope((Function2)invalid$iv3);
        } else {
            $dirty4 = $dirty;
            obj3 = contentDescription2;
        }
    }

    private static final boolean TimePicker_mT9BvqQ$lambda$0(State<Boolean> $a11yServicesEnabled$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$a11yServicesEnabled$delegate.getValue().booleanValue();
    }

    private static final void TimeSelector-SAnMeKU(Modifier modifier, int value, androidx.compose.material3.TimePickerState state, int selection, androidx.compose.material3.TimePickerColors colors, Composer $composer, int $changed) {
        Object traceInProgress2;
        Object anon;
        Object it$iv;
        Object empty2;
        int i6;
        int this_$iv;
        int i16;
        Object obj;
        int i3;
        int $dirty2;
        boolean $dirty;
        boolean traceInProgress;
        int i8;
        int changedInstance;
        int i5;
        int i9;
        int timeSelectorContentColor-vNxB06k$material3_release;
        int i2;
        boolean changedInstance2;
        int i7;
        int i10;
        int i14;
        int m3c_time_picker_hour_selection;
        Composer $composer2;
        androidx.compose.material3.TimePickerKt.TimeSelector.2.1 $i$f$cache;
        Composer composer4;
        Composer composer2;
        Object empty;
        int $dirty3;
        Shape selected;
        long selectorContentDescription;
        long timeSelectorContainerColor-vNxB06k$material3_release;
        int i13;
        Composer composer;
        int i15;
        int companion2;
        Object obj2;
        int i17;
        int companion;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer3;
        int i12;
        int i11;
        int i4;
        int i;
        Shape obj33;
        empty2 = modifier;
        obj = state;
        i3 = selection;
        traceInProgress2 = colors;
        final int i31 = $changed;
        i6 = -1148055889;
        $composer2 = $composer.startRestartGroup(i6);
        ComposerKt.sourceInformation($composer2, "C(TimeSelector)P(1,4,3,2:c#material3.TimePickerSelectionMode)1351@54864L214,1363@55302L124,1373@55637L5,1367@55446L117,1375@55682L497,1361@55218L961:TimePicker.kt#uh7d8r");
        if (i31 & 6 == 0) {
            i9 = $composer2.changed(empty2) ? 4 : 2;
            $dirty2 |= i9;
        }
        if (i31 & 48 == 0) {
            i2 = $composer2.changed(value) ? 32 : 16;
            $dirty2 |= i2;
        } else {
            timeSelectorContentColor-vNxB06k$material3_release = value;
        }
        if (i31 & 384 == 0) {
            if (i31 & 512 == 0) {
                changedInstance2 = $composer2.changed(obj);
            } else {
                changedInstance2 = $composer2.changedInstance(obj);
            }
            i7 = changedInstance2 ? 256 : 128;
            $dirty2 |= i7;
        }
        if (i31 & 3072 == 0) {
            i10 = $composer2.changed(i3) ? 2048 : 1024;
            $dirty2 |= i10;
        }
        if (i31 & 24576 == 0) {
            i14 = $composer2.changed(traceInProgress2) ? 16384 : 8192;
            $dirty2 |= i14;
        }
        $dirty3 = $dirty2;
        if ($dirty3 & 9363 == 9362) {
            if (!$composer2.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(i6, $dirty3, -1, "androidx.compose.material3.TimeSelector (TimePicker.kt:1348)");
                }
                boolean equals-impl02 = TimePickerSelectionMode.equals-impl0(obj.getSelection-yecRtBI(), i3);
                if (TimePickerSelectionMode.equals-impl0(i3, TimePickerSelectionMode.Companion.getHour-yecRtBI())) {
                    androidx.compose.material3.internal.Strings.Companion companion5 = Strings.Companion;
                    i8 = 0;
                    this_$iv = Strings.constructor-impl(R.string.m3c_time_picker_hour_selection);
                } else {
                    androidx.compose.material3.internal.Strings.Companion companion4 = Strings.Companion;
                    i8 = 0;
                    this_$iv = m3c_time_picker_hour_selection;
                }
                String str3 = string-2EP1pXo;
                timeSelectorContainerColor-vNxB06k$material3_release = traceInProgress2.timeSelectorContainerColor-vNxB06k$material3_release(equals-impl02);
                String str2 = "CC(remember):TimePicker.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer2, 1840519339, str2);
                composer = $composer2;
                int i36 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i38 = 0;
                if (!$composer2.changed(str3)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i35 = 0;
                        anon = new TimePickerKt.TimeSelector.1.1(str3);
                        composer.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                        composer2 = composer;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                int i32 = 1;
                ComposerKt.sourceInformationMarkerStart($composer2, 1840523940, str2);
                i16 = $dirty3 & 7168 == 2048 ? i32 : 0;
                if ($dirty3 & 896 != 256) {
                    if ($dirty3 & 512 != 0 && $composer2.changedInstance(obj)) {
                        if ($composer2.changedInstance(obj)) {
                            i5 = 1;
                        } else {
                            i5 = 0;
                        }
                    } else {
                    }
                } else {
                }
                Composer composer5 = $composer2;
                int i34 = 0;
                it$iv = composer5.rememberedValue();
                int i37 = 0;
                if (i16 |= i5 == 0) {
                    if (it$iv == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        obj2 = it$iv;
                        it$iv = new TimePickerKt.TimeSelector.2.1(i3, obj);
                        composer5.updateRememberedValue((Function0)it$iv);
                    } else {
                        obj2 = it$iv;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                TimePickerKt.TimeSelector.3 anon2 = new TimePickerKt.TimeSelector.3(i3, obj, value, traceInProgress2.timeSelectorContentColor-vNxB06k$material3_release(equals-impl02), m3c_time_picker_hour_selection);
                i6 = str3;
                i = $dirty;
                composer3 = $composer2;
                SurfaceKt.Surface-d85dljk(equals-impl02, (Function0)it$iv, SemanticsModifierKt.semantics(empty2, i32, (Function1)anon), false, ShapesKt.getValue(TimePickerTokens.INSTANCE.getTimeSelectorContainerShape(), $composer2, 6), timeSelectorContainerColor-vNxB06k$material3_release, timeSelectorContainerColor-vNxB06k$material3_release, 0, composer, 0, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-1477282471, true, anon2, $composer2, 54), composer3, 0);
                composer4 = composer3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer2.skipToGroupEnd();
                composer4 = $composer2;
                i = $dirty3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer4.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new TimePickerKt.TimeSelector.4(modifier, value, state, selection, colors, i31);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final void ToggleItem(boolean checked, Shape shape, Function0<Unit> onClick, androidx.compose.material3.TimePickerColors colors, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress;
        Object restartGroup;
        int $dirty;
        int i9;
        Object obj;
        int i10;
        int i6;
        int i3;
        Object obj3;
        int $dirty2;
        int i2;
        int i8;
        Object obj2;
        int i7;
        boolean skipping;
        boolean traceInProgress2;
        int str;
        int i12;
        int i5;
        int i4;
        androidx.compose.foundation.layout.PaddingValues paddingValues;
        int empty;
        int i11;
        Object anon;
        Composer composer;
        Composer composer2;
        int companion;
        int i;
        long l2;
        long l;
        final boolean z = checked;
        final Object obj5 = colors;
        final int i14 = $changed;
        traceInProgress = -1937408098;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(ToggleItem)P(!1,4,3)1310@53677L22,1316@53868L124,1308@53569L429:TimePicker.kt#uh7d8r");
        i10 = 4;
        if (i14 & 6 == 0) {
            i9 = restartGroup.changed(z) ? i10 : 2;
            $dirty |= i9;
        }
        if (i14 & 48 == 0) {
            i3 = restartGroup.changed(shape) ? 32 : 16;
            $dirty |= i3;
        } else {
            obj = shape;
        }
        if (i14 & 384 == 0) {
            i2 = restartGroup.changedInstance(onClick) ? 256 : 128;
            $dirty |= i2;
        } else {
            obj3 = onClick;
        }
        if (i14 & 3072 == 0) {
            i8 = restartGroup.changed(obj5) ? 2048 : 1024;
            $dirty |= i8;
        }
        if (i14 & 24576 == 0) {
            i7 = restartGroup.changedInstance(content) ? 16384 : 8192;
            $dirty |= i7;
        } else {
            obj2 = content;
        }
        if ($dirty & 9363 == 9362) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.ToggleItem (TimePicker.kt:1304)");
                }
                long periodSelectorContentColor-vNxB06k$material3_release = obj5.periodSelectorContentColor-vNxB06k$material3_release(z);
                long periodSelectorContainerColor-vNxB06k$material3_release = obj5.periodSelectorContainerColor-vNxB06k$material3_release(z);
                int i29 = 0;
                i4 = z ? i29 : 1065353216;
                int i35 = 1;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -857429536, "CC(remember):TimePicker.kt#9igjgp");
                i6 = $dirty & 14 == i10 ? i35 : 0;
                Composer composer3 = restartGroup;
                int i38 = 0;
                Object rememberedValue = composer3.rememberedValue();
                int i39 = 0;
                if (i6 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new TimePickerKt.ToggleItem.1.1(z);
                        composer3.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i33 = 0;
                float f = (float)i16;
                Composer composer4 = restartGroup;
                l = periodSelectorContainerColor-vNxB06k$material3_release;
                l2 = periodSelectorContentColor-vNxB06k$material3_release;
                composer2 = composer4;
                ButtonKt.TextButton(onClick, SemanticsModifierKt.semantics$default(SizeKt.fillMaxSize$default(ZIndexModifierKt.zIndex((Modifier)Modifier.Companion, i4), i29, i35, 0), false, (Function1)anon, 1, 0), false, obj, ButtonDefaults.INSTANCE.textButtonColors-ro_MJ88(periodSelectorContainerColor-vNxB06k$material3_release, obj2, periodSelectorContentColor-vNxB06k$material3_release, str, 0, f, 0), 0, 0, PaddingKt.PaddingValues-0680j_4(Dp.constructor-impl(f)), 0, content, composer2, i20 | i26, 356);
                composer = composer2;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                composer = restartGroup;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = $dirty;
            traceInProgress = new TimePickerKt.ToggleItem.2(z, shape, onClick, obj5, content, i14);
            endRestartGroup.updateScope((Function2)traceInProgress);
        } else {
            $dirty2 = $dirty;
        }
    }

    private static final void VerticalClockDisplay(androidx.compose.material3.TimePickerState state, androidx.compose.material3.TimePickerColors colors, Composer $composer, int $changed) {
        int traceInProgress;
        Function0 factory$iv$iv$iv2;
        Modifier size-VpY3zN4;
        Function0 factory$iv$iv$iv;
        Composer restartGroup;
        int $dirty;
        int i6;
        int i22;
        boolean $i$a$LayoutRowKt$Row$1$iv;
        boolean traceInProgress2;
        boolean valueOf3;
        boolean changedInstance;
        int str;
        Composer composer5;
        Composer composer;
        Integer valueOf;
        Integer valueOf2;
        Object maybeCachedBoxMeasurePolicy;
        androidx.compose.ui.Alignment.Vertical top;
        MeasurePolicy rowMeasurePolicy;
        int i12;
        int i8;
        Modifier materializeModifier;
        Object currentCompositionLocalMap2;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        int currentCompositeKeyHash;
        int i2;
        int i19;
        androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical horizontalOrVertical;
        Function0 function0;
        int i;
        int i18;
        int i9;
        int i21;
        int i16;
        Composer composer4;
        int i10;
        RowScopeInstance rowScopeInstance;
        int $changed$iv;
        int i11;
        Composer composer2;
        int i5;
        int i13;
        int i7;
        androidx.compose.ui.Modifier.Companion companion;
        int i3;
        int i20;
        Alignment alignment;
        Modifier modifier2;
        TimePickerTokens iNSTANCE;
        int i14;
        Function0 function02;
        int i17;
        BoxScopeInstance boxScopeInstance;
        Composer $composer2;
        int i4;
        Modifier modifier;
        Composer composer3;
        int i15;
        int obj52;
        final Object obj = state;
        final Object obj2 = colors;
        final int i23 = $changed;
        traceInProgress = 2054675515;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(VerticalClockDisplay)P(1)1107@46965L585:TimePicker.kt#uh7d8r");
        if (i23 & 6 == 0) {
            if (i23 & 8 == 0) {
                changedInstance = restartGroup.changed(obj);
            } else {
                changedInstance = restartGroup.changedInstance(obj);
            }
            i6 = changedInstance != null ? 4 : 2;
            $dirty |= i6;
        }
        if (i23 & 48 == 0) {
            i22 = restartGroup.changed(obj2) ? 32 : 16;
            $dirty |= i22;
        }
        if ($dirty & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.VerticalClockDisplay (TimePicker.kt:1106)");
                }
                androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                valueOf3 = 48;
                valueOf2 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                maybeCachedBoxMeasurePolicy = Modifier.Companion;
                i8 = 0;
                currentCompositionLocalMap2 = "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, currentCompositionLocalMap2);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                horizontalOrVertical = center;
                Function0 function03 = constructor2;
                i19 = 0;
                i18 = $dirty;
                $dirty = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, $dirty);
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(function03);
                } else {
                    factory$iv$iv$iv2 = function03;
                    restartGroup.useNode();
                }
                function0 = factory$iv$iv$iv2;
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i61 = 0;
                composer4 = restartGroup;
                Updater.set-impl(constructor-impl, RowKt.rowMeasurePolicy((Arrangement.Horizontal)center, Alignment.Companion.getTop(), restartGroup, i53 |= i56), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i62 = 0;
                Composer composer7 = constructor-impl;
                int i63 = 0;
                if (!composer7.getInserting()) {
                    $changed$iv = valueOf3;
                    i11 = valueOf2;
                    if (!Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer5 = composer7;
                    }
                } else {
                    $changed$iv = valueOf3;
                    i11 = valueOf2;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, (Modifier)maybeCachedBoxMeasurePolicy), ComposeUiNode.Companion.getSetModifier());
                Composer composer6 = composer4;
                i21 = i27;
                ComposerKt.sourceInformationMarkerStart(composer6, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                i47 |= 6;
                i10 = 0;
                rowScopeInstance = iNSTANCE3;
                i5 = i41;
                $i$a$LayoutRowKt$Row$1$iv = i16;
                ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, -519240274, "C1108@47023L34:TimePicker.kt#uh7d8r");
                TimePickerKt.ClockDisplayNumbers(obj, obj2, $i$a$LayoutRowKt$Row$1$iv, i28 |= restartGroup);
                $i$a$LayoutRowKt$Row$1$iv.startReplaceGroup(-709485014);
                ComposerKt.sourceInformation($i$a$LayoutRowKt$Row$1$iv, "1110@47101L433");
                if (!obj.is24hour()) {
                    Modifier padding-qDBjuR0$default = PaddingKt.padding-qDBjuR0$default((Modifier)Modifier.Companion, TimePickerKt.PeriodToggleMargin, 0, 0, 0, 14, 0);
                    i16 = 0;
                    i13 = i36;
                    i7 = str;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    Alignment topStart = Alignment.Companion.getTopStart();
                    valueOf = 0;
                    companion = maybeCachedBoxMeasurePolicy;
                    i20 = 0;
                    alignment = topStart;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, -1323940314, currentCompositionLocalMap2);
                    obj52 = currentCompositeKeyHash2;
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier($i$a$LayoutRowKt$Row$1$iv, padding-qDBjuR0$default);
                    modifier2 = padding-qDBjuR0$default;
                    Function0 function04 = constructor;
                    i2 = 0;
                    ComposerKt.sourceInformationMarkerStart($i$a$LayoutRowKt$Row$1$iv, -692256719, $dirty);
                    if (!applier2 instanceof Applier) {
                        ComposablesKt.invalidApplier();
                    }
                    $i$a$LayoutRowKt$Row$1$iv.startReusableNode();
                    if ($i$a$LayoutRowKt$Row$1$iv.getInserting()) {
                        $i$a$LayoutRowKt$Row$1$iv.createNode(function04);
                    } else {
                        factory$iv$iv$iv = function04;
                        $i$a$LayoutRowKt$Row$1$iv.useNode();
                    }
                    Composer constructor-impl2 = Updater.constructor-impl($i$a$LayoutRowKt$Row$1$iv);
                    int i60 = 0;
                    function02 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl2, BoxKt.maybeCachedBoxMeasurePolicy(topStart, valueOf), ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl2, $i$a$LayoutRowKt$Row$1$iv.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    int i70 = 0;
                    Composer composer9 = constructor-impl2;
                    int i71 = 0;
                    if (!composer9.getInserting()) {
                        $composer2 = $i$a$LayoutRowKt$Row$1$iv;
                        i4 = valueOf;
                        if (!Intrinsics.areEqual(composer9.rememberedValue(), Integer.valueOf(obj52))) {
                            composer9.updateRememberedValue(Integer.valueOf(obj52));
                            constructor-impl2.apply(Integer.valueOf(obj52), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer = composer9;
                        }
                    } else {
                        $composer2 = $i$a$LayoutRowKt$Row$1$iv;
                        i4 = valueOf;
                    }
                    Updater.set-impl(constructor-impl2, materializeModifier2, ComposeUiNode.Companion.getSetModifier());
                    $dirty = $composer2;
                    i9 = i34;
                    ComposerKt.sourceInformationMarkerStart($dirty, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    i50 |= 6;
                    Composer composer8 = $dirty;
                    i17 = 0;
                    boxScopeInstance = iNSTANCE4;
                    modifier = materializeModifier2;
                    ComposerKt.sourceInformationMarkerStart($dirty, 204292100, "C1111@47180L340:TimePicker.kt#uh7d8r");
                    i15 = i42;
                    TimePickerKt.VerticalPeriodToggle(SizeKt.size-VpY3zN4((Modifier)Modifier.Companion, TimePickerTokens.INSTANCE.getPeriodSelectorVerticalContainerWidth-D9Ej5fM(), TimePickerTokens.INSTANCE.getPeriodSelectorVerticalContainerHeight-D9Ej5fM()), obj, obj2, $dirty, i40 |= $i$a$LayoutRowKt$Row$1$iv);
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    ComposerKt.sourceInformationMarkerEnd($dirty);
                    $composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                } else {
                    $composer2 = $i$a$LayoutRowKt$Row$1$iv;
                    i7 = str;
                    companion = maybeCachedBoxMeasurePolicy;
                }
                $composer2.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd($composer2);
                ComposerKt.sourceInformationMarkerEnd(composer6);
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
                i18 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer4.endRestartGroup();
        if (endRestartGroup != null) {
            restartGroup = new TimePickerKt.VerticalClockDisplay.2(obj, obj2, i23);
            endRestartGroup.updateScope((Function2)restartGroup);
        }
    }

    private static final void VerticalPeriodToggle(Modifier modifier, androidx.compose.material3.TimePickerState state, androidx.compose.material3.TimePickerColors colors, Composer $composer, int $changed) {
        Shape value;
        int i;
        boolean changedInstance;
        int i2;
        int i3;
        int skipping;
        boolean traceInProgress;
        Object obj2;
        int str;
        Object obj3;
        Object obj;
        androidx.compose.material3.TimePickerKt.VerticalPeriodToggle.measurePolicy.1.1 time;
        int empty;
        androidx.compose.foundation.shape.CornerBasedShape cornerBasedShape;
        Object iNSTANCE;
        androidx.compose.foundation.shape.CornerBasedShape cornerBasedShape2;
        int i4;
        boolean obj9;
        Object obj10;
        int obj12;
        value = -1898918107;
        final Composer restartGroup = $composer.startRestartGroup(value);
        ComposerKt.sourceInformation(restartGroup, "C(VerticalPeriodToggle)P(1,2)1206@50268L1021,1234@51336L5,1236@51367L207:TimePicker.kt#uh7d8r");
        if ($changed & 6 == 0) {
            i = restartGroup.changed(modifier) ? 4 : 2;
            obj12 |= i;
        }
        if ($changed & 48 == 0) {
            if ($changed & 64 == 0) {
                changedInstance = restartGroup.changed(state);
            } else {
                changedInstance = restartGroup.changedInstance(state);
            }
            i2 = changedInstance != null ? 32 : 16;
            obj12 |= i2;
        }
        if ($changed & 384 == 0) {
            i3 = restartGroup.changed(colors) ? 256 : 128;
            obj12 |= i3;
        }
        if (obj12 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(value, obj12, -1, "androidx.compose.material3.VerticalPeriodToggle (TimePicker.kt:1205)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1491514731, "CC(remember):TimePicker.kt#9igjgp");
                int i6 = 0;
                Composer composer = restartGroup;
                int i12 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i15 = 0;
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty = 0;
                    composer.updateRememberedValue((MeasurePolicy)TimePickerKt.VerticalPeriodToggle.measurePolicy.1.1.INSTANCE);
                } else {
                    iNSTANCE = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                value = ShapesKt.getValue(TimePickerTokens.INSTANCE.getPeriodSelectorContainerShape(), restartGroup, 6);
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.foundation.shape.CornerBasedShape");
                TimePickerKt.PeriodToggleImpl(modifier, state, colors, (MeasurePolicy)iNSTANCE, (Shape)ShapesKt.top((CornerBasedShape)value), (Shape)ShapesKt.bottom(value), restartGroup, i11 | i14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                obj2 = modifier;
                obj3 = state;
                obj = colors;
            }
        } else {
        }
        obj9 = restartGroup.endRestartGroup();
        if (obj9 != null) {
            obj10 = new TimePickerKt.VerticalPeriodToggle.1(obj2, obj3, obj, $changed);
            obj9.updateScope((Function2)obj10);
        }
    }

    public static final void VerticalTimePicker(androidx.compose.material3.AnalogTimePickerState state, Modifier modifier, androidx.compose.material3.TimePickerColors colors, boolean autoSwitchToMinute, Composer $composer, int $changed, int i7) {
        int traceInProgress;
        Function0 factory$iv$iv$iv;
        int $dirty2;
        Object $dirty;
        int i11;
        Object obj;
        Object modifier2;
        int valueOf;
        Object colors3;
        boolean traceInProgress2;
        Composer composer;
        Object centerHorizontally;
        int i2;
        Object obj3;
        int colors2;
        int changed;
        int i4;
        boolean currentCompositeKeyHash;
        int defaultsInvalid;
        int currentCompositionLocalMap;
        int i12;
        int i8;
        androidx.compose.foundation.layout.Arrangement.Vertical top;
        MeasurePolicy columnMeasurePolicy;
        int i13;
        int i6;
        int i9;
        int i;
        int i10;
        Object obj2;
        int i5;
        Function0 function0;
        int i3;
        ColumnScopeInstance columnScopeInstance;
        androidx.compose.ui.Alignment.Horizontal horizontalAlignment$iv;
        Modifier modifier3;
        Composer composer2;
        int obj29;
        Object obj30;
        int obj32;
        final Object obj5 = state;
        final boolean z2 = autoSwitchToMinute;
        valueOf = $changed;
        traceInProgress = 1249591487;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(VerticalTimePicker)P(3,2,1)927@40188L8,930@40238L379:TimePicker.kt#uh7d8r");
        $dirty2 = $changed;
        if (i7 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (valueOf & 6 == 0) {
                i11 = restartGroup.changedInstance(obj5) ? 4 : 2;
                $dirty2 |= i11;
            }
        }
        int i30 = i7 & 2;
        if (i30 != 0) {
            $dirty2 |= 48;
            colors3 = modifier;
        } else {
            if (valueOf & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty2 |= i2;
            } else {
                colors3 = modifier;
            }
        }
        if (valueOf & 384 == 0) {
            if (i7 & 4 == 0) {
                changed = restartGroup.changed(colors) ? 256 : 128;
            } else {
                obj3 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj3 = colors;
        }
        if (i7 & 8 != 0) {
            $dirty2 |= 3072;
        } else {
            if (valueOf & 3072 == 0) {
                i4 = restartGroup.changed(z2) ? 2048 : 1024;
                $dirty2 |= i4;
            }
        }
        if ($dirty2 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i41 = 6;
                if (valueOf & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i30 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = colors3;
                        }
                        if (i7 & 4 != 0) {
                            $dirty2 &= -897;
                            obj3 = colors3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i7 & 4 != 0) {
                            $dirty2 &= -897;
                        }
                        modifier2 = colors3;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty2, -1, "androidx.compose.material3.VerticalTimePicker (TimePicker.kt:929)");
                }
                Modifier semantics$default = SemanticsModifierKt.semantics$default(modifier2, false, (Function1)TimePickerKt.VerticalTimePicker.1.INSTANCE, 1, 0);
                centerHorizontally = Alignment.Companion.getCenterHorizontally();
                i12 = 384;
                i8 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                i6 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(restartGroup, 0);
                obj29 = $dirty2;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, semantics$default);
                obj30 = semantics$default;
                Function0 function02 = constructor;
                i9 = 0;
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
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i51 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, restartGroup, i46 |= i49), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i52 = 0;
                Composer composer5 = constructor-impl;
                int i54 = 0;
                if (!composer5.getInserting()) {
                    horizontalAlignment$iv = centerHorizontally;
                    if (!Intrinsics.areEqual(composer5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer5;
                    }
                } else {
                    horizontalAlignment$iv = centerHorizontally;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = restartGroup;
                valueOf = 0;
                i = i17;
                ComposerKt.sourceInformationMarkerStart(composer3, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                i36 |= 6;
                Composer composer4 = composer3;
                i3 = 0;
                columnScopeInstance = iNSTANCE2;
                modifier3 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer3, 1628603633, "C934@40388L35,935@40432L60,936@40501L44,937@40554L57:TimePicker.kt#uh7d8r");
                TimePickerKt.VerticalClockDisplay((TimePickerState)obj5, obj3, composer3, i22 |= i5);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, TimePickerKt.ClockDisplayBottomMargin), composer3, i41);
                TimePickerKt.ClockFace(obj5, obj3, z2, composer3, i19 |= i28);
                SpacerKt.Spacer(SizeKt.height-3ABfNKs((Modifier)Modifier.Companion, TimePickerKt.ClockFaceBottomMargin), composer3, 6);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj3;
                $dirty = obj2;
                colors2 = obj29;
            } else {
                restartGroup.skipToGroupEnd();
                obj = obj3;
                colors2 = $dirty2;
                $dirty = colors3;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new TimePickerKt.VerticalTimePicker.3(obj5, $dirty, obj, z2, $changed, i7);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void access$CircularLayout-uFdPcIQ(Modifier modifier, float radius, Function2 content, Composer $composer, int $changed, int $default) {
        TimePickerKt.CircularLayout-uFdPcIQ(modifier, radius, content, $composer, $changed, $default);
    }

    public static final void access$ClockDisplayNumbers(androidx.compose.material3.TimePickerState state, androidx.compose.material3.TimePickerColors colors, Composer $composer, int $changed) {
        TimePickerKt.ClockDisplayNumbers(state, colors, $composer, $changed);
    }

    public static final void access$ClockText(Modifier modifier, androidx.compose.material3.AnalogTimePickerState state, int value, boolean autoSwitchToMinute, Composer $composer, int $changed) {
        TimePickerKt.ClockText(modifier, state, value, autoSwitchToMinute, $composer, $changed);
    }

    public static final long access$ClockText$lambda$29(MutableState $center$delegate) {
        return TimePickerKt.ClockText$lambda$29($center$delegate);
    }

    public static final void access$ClockText$lambda$30(MutableState $center$delegate, long value) {
        TimePickerKt.ClockText$lambda$30($center$delegate, value);
    }

    public static final long access$ClockText$lambda$32(MutableState $parentCenter$delegate) {
        return TimePickerKt.ClockText$lambda$32($parentCenter$delegate);
    }

    public static final void access$ClockText$lambda$33(MutableState $parentCenter$delegate, long value) {
        TimePickerKt.ClockText$lambda$33($parentCenter$delegate, value);
    }

    public static final void access$DisplaySeparator(Modifier modifier, Composer $composer, int $changed) {
        TimePickerKt.DisplaySeparator(modifier, $composer, $changed);
    }

    public static final void access$HorizontalClockDisplay(androidx.compose.material3.TimePickerState state, androidx.compose.material3.TimePickerColors colors, Composer $composer, int $changed) {
        TimePickerKt.HorizontalClockDisplay(state, colors, $composer, $changed);
    }

    public static final void access$HorizontalPeriodToggle(Modifier modifier, androidx.compose.material3.TimePickerState state, androidx.compose.material3.TimePickerColors colors, Composer $composer, int $changed) {
        TimePickerKt.HorizontalPeriodToggle(modifier, state, colors, $composer, $changed);
    }

    public static final void access$PeriodToggleImpl(Modifier modifier, androidx.compose.material3.TimePickerState state, androidx.compose.material3.TimePickerColors colors, MeasurePolicy measurePolicy, Shape startShape, Shape endShape, Composer $composer, int $changed) {
        TimePickerKt.PeriodToggleImpl(modifier, state, colors, measurePolicy, startShape, endShape, $composer, $changed);
    }

    public static final void access$TimeInputImpl(Modifier modifier, androidx.compose.material3.TimePickerColors colors, androidx.compose.material3.TimePickerState state, Composer $composer, int $changed) {
        TimePickerKt.TimeInputImpl(modifier, colors, state, $composer, $changed);
    }

    public static final void access$TimeInputImpl$lambda$10(MutableState $minuteValue$delegate, TextFieldValue value) {
        TimePickerKt.TimeInputImpl$lambda$10($minuteValue$delegate, value);
    }

    public static final TextFieldValue access$TimeInputImpl$lambda$6(MutableState $hourValue$delegate) {
        return TimePickerKt.TimeInputImpl$lambda$6($hourValue$delegate);
    }

    public static final void access$TimeInputImpl$lambda$7(MutableState $hourValue$delegate, TextFieldValue value) {
        TimePickerKt.TimeInputImpl$lambda$7($hourValue$delegate, value);
    }

    public static final TextFieldValue access$TimeInputImpl$lambda$9(MutableState $minuteValue$delegate) {
        return TimePickerKt.TimeInputImpl$lambda$9($minuteValue$delegate);
    }

    public static final void access$TimePickerTextField-1vLObsk(Modifier modifier, TextFieldValue value, Function1 onValueChange, androidx.compose.material3.TimePickerState state, int selection, KeyboardOptions keyboardOptions, KeyboardActions keyboardActions, androidx.compose.material3.TimePickerColors colors, Composer $composer, int $changed, int $default) {
        TimePickerKt.TimePickerTextField-1vLObsk(modifier, value, onValueChange, state, selection, keyboardOptions, keyboardActions, colors, $composer, $changed, $default);
    }

    public static final void access$TimeSelector-SAnMeKU(Modifier modifier, int value, androidx.compose.material3.TimePickerState state, int selection, androidx.compose.material3.TimePickerColors colors, Composer $composer, int $changed) {
        TimePickerKt.TimeSelector-SAnMeKU(modifier, value, state, selection, colors, $composer, $changed);
    }

    public static final void access$ToggleItem(boolean checked, Shape shape, Function0 onClick, androidx.compose.material3.TimePickerColors colors, Function3 content, Composer $composer, int $changed) {
        TimePickerKt.ToggleItem(checked, shape, onClick, colors, content, $composer, $changed);
    }

    public static final void access$VerticalClockDisplay(androidx.compose.material3.TimePickerState state, androidx.compose.material3.TimePickerColors colors, Composer $composer, int $changed) {
        TimePickerKt.VerticalClockDisplay(state, colors, $composer, $changed);
    }

    public static final void access$VerticalPeriodToggle(Modifier modifier, androidx.compose.material3.TimePickerState state, androidx.compose.material3.TimePickerColors colors, Composer $composer, int $changed) {
        TimePickerKt.VerticalPeriodToggle(modifier, state, colors, $composer, $changed);
    }

    public static final float access$atan(float y, float x) {
        return TimePickerKt.atan(y, x);
    }

    public static final float access$getDisplaySeparatorWidth$p() {
        return TimePickerKt.DisplaySeparatorWidth;
    }

    public static final IntList access$getExtraHours$p() {
        return TimePickerKt.ExtraHours;
    }

    public static final IntList access$getHours$p() {
        return TimePickerKt.Hours;
    }

    public static final float access$getInnerCircleRadius$p() {
        return TimePickerKt.InnerCircleRadius;
    }

    public static final float access$getMaxDistance$p() {
        return TimePickerKt.MaxDistance;
    }

    public static final IntList access$getMinutes$p() {
        return TimePickerKt.Minutes;
    }

    public static final float access$getOuterCircleSizeRadius$p() {
        return TimePickerKt.OuterCircleSizeRadius;
    }

    public static final void access$moveSelector-d3b8Pxo(androidx.compose.material3.TimePickerState $receiver, float x, float y, float maxDist, long center) {
        TimePickerKt.moveSelector-d3b8Pxo($receiver, x, y, maxDist, center);
    }

    public static final Object access$onTap-rOwcSBo(androidx.compose.material3.AnalogTimePickerState $receiver, float x, float y, float maxDist, boolean autoSwitchToMinute, long center, Continuation $completion) {
        return TimePickerKt.onTap-rOwcSBo($receiver, x, y, maxDist, autoSwitchToMinute, center, $completion);
    }

    public static final void access$timeInputOnChange-z7XvuPQ(int selection, androidx.compose.material3.TimePickerState state, TextFieldValue value, TextFieldValue prevValue, int max, Function1 onNewValue) {
        TimePickerKt.timeInputOnChange-z7XvuPQ(selection, state, value, prevValue, max, onNewValue);
    }

    private static final float atan(float y, float x) {
        int i;
        f -= i3;
        i = Float.compare(i2, i4) < 0 ? i5 + i2 : i2;
        return i;
    }

    private static final float dist(float x1, float y1, int x2, int y2) {
        return (float)hypot;
    }

    private static final Modifier drawSelector(Modifier $this$drawSelector, androidx.compose.material3.AnalogTimePickerState state, androidx.compose.material3.TimePickerColors colors) {
        TimePickerKt.drawSelector.1 anon = new TimePickerKt.drawSelector.1(state, colors);
        return DrawModifierKt.drawWithContent($this$drawSelector, (Function1)anon);
    }

    public static final int getHourForDisplay(androidx.compose.material3.TimePickerState $this$hourForDisplay) {
        int hour;
        int i;
        if ($this$hourForDisplay.is24hour()) {
            hour4 %= 24;
        } else {
            i = 12;
            if (hour2 %= i == 0) {
                hour = i;
            } else {
                if ($this$hourForDisplay.isAfternoon()) {
                    hour3 -= i;
                } else {
                    hour = $this$hourForDisplay.getHour();
                }
            }
        }
        return hour;
    }

    public static final long getSelectorPos(androidx.compose.material3.AnalogTimePickerState $this$selectorPos) {
        float outerCircleSizeRadius;
        boolean afternoon;
        int hour-yecRtBI;
        hour-yecRtBI = 0;
        float arg0$iv = Dp.constructor-impl(clockDialSelectorHandleContainerSize-D9Ej5fM / f);
        if ($this$selectorPos.is24hour() && $this$selectorPos.isAfternoon() && TimePickerSelectionMode.equals-impl0($this$selectorPos.getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getHour-yecRtBI())) {
            if ($this$selectorPos.isAfternoon()) {
                outerCircleSizeRadius = TimePickerSelectionMode.equals-impl0($this$selectorPos.getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getHour-yecRtBI()) ? TimePickerKt.InnerCircleRadius : TimePickerKt.OuterCircleSizeRadius;
            } else {
            }
        } else {
        }
        int i2 = 0;
        int i3 = 0;
        float $i$f$plus5rwHm24 = Dp.constructor-impl(arg0$iv2 + arg0$iv);
        int i7 = 0;
        int i12 = 0;
        int i11 = 0;
        int i18 = 0;
        int i16 = 0;
        return DpKt.DpOffset-YgX7TsA(Dp.constructor-impl(other$iv + arg0$iv4), Dp.constructor-impl(other$iv2 + arg0$iv6));
    }

    private static final void moveSelector-d3b8Pxo(androidx.compose.material3.TimePickerState $this$moveSelector_u2dd3b8Pxo, float x, float y, float maxDist, long center) {
        int equals-impl0;
        int hour-yecRtBI;
        if (TimePickerSelectionMode.equals-impl0($this$moveSelector_u2dd3b8Pxo.getSelection-yecRtBI(), TimePickerSelectionMode.Companion.getHour-yecRtBI()) && $this$moveSelector_u2dd3b8Pxo.is24hour()) {
            if ($this$moveSelector_u2dd3b8Pxo.is24hour()) {
                equals-impl0 = Float.compare(dist, maxDist) < 0 ? 1 : 0;
                $this$moveSelector_u2dd3b8Pxo.setAfternoon(equals-impl0);
            }
        }
    }

    public static final String numberContentDescription-dSwYdS4(int selection, boolean is24Hour, int number, Composer $composer, int $changed) {
        int this_$iv;
        boolean traceInProgress;
        int i;
        String str;
        int m3c_time_picker_minute_suffix;
        int i2 = 194237364;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(numberContentDescription)P(2:c#material3.TimePickerSelectionMode)1924@74567L21:TimePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.material3.numberContentDescription (TimePicker.kt:1914)");
        }
        if (TimePickerSelectionMode.equals-impl0(selection, TimePickerSelectionMode.Companion.getMinute-yecRtBI())) {
            androidx.compose.material3.internal.Strings.Companion companion2 = Strings.Companion;
            i = 0;
            this_$iv = Strings.constructor-impl(R.string.m3c_time_picker_minute_suffix);
        } else {
            if (is24Hour) {
                androidx.compose.material3.internal.Strings.Companion companion4 = Strings.Companion;
                i = 0;
                this_$iv = Strings.constructor-impl(R.string.m3c_time_picker_hour_24h_suffix);
            } else {
                androidx.compose.material3.internal.Strings.Companion companion3 = Strings.Companion;
                i = 0;
                this_$iv = m3c_time_picker_minute_suffix;
            }
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return Strings_androidKt.getString-qBjtwXw(this_$iv, /* result */, $composer, 0);
    }

    private static final Object onTap-rOwcSBo(androidx.compose.material3.AnalogTimePickerState analogTimePickerState, float f2, float f3, float f4, boolean z5, long l6, Continuation<? super Unit> continuation7) {
        boolean anon;
        int i3;
        int i2;
        int label;
        int i;
        int rint;
        double d;
        double rint2;
        boolean obj8;
        Object obj9;
        int obj10;
        int obj11;
        float obj12;
        Object obj15;
        anon = obj15;
        i2 = Integer.MIN_VALUE;
        if (obj15 instanceof TimePickerKt.onTap.1 && label2 &= i2 != 0) {
            anon = obj15;
            i2 = Integer.MIN_VALUE;
            if (label2 &= i2 != 0) {
                anon.label = obj15 -= i2;
            } else {
                anon = new TimePickerKt.onTap.1(obj15);
            }
        } else {
        }
        obj15 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label) {
            case 0:
                ResultKt.throwOnFailure(obj15);
                label = z5;
                obj11 = TimePickerKt.atan(f3 - obj11, f2 - f);
                int i5 = 1037465424;
                d = 1084227584;
                i = obj11;
                int i6 = 1057360530;
                i = obj11;
                TimePickerKt.moveSelector-d3b8Pxo((TimePickerState)analogTimePickerState, f2, f3, f4, l6);
                anon.L$0 = analogTimePickerState;
                anon.Z$0 = label;
                obj9 = 1;
                anon.label = obj9;
                return cOROUTINE_SUSPENDED;
                obj9 = analogTimePickerState;
                obj8 = label;
                break;
            case 1:
                obj8 = anon.Z$0;
                obj9 = anon.L$0;
                ResultKt.throwOnFailure(obj15);
                break;
            case 2:
                obj8 = anon.Z$0;
                obj9 = anon.L$0;
                ResultKt.throwOnFailure(obj15);
                obj9.setSelection-6_8s6DQ(TimePickerSelectionMode.Companion.getMinute-yecRtBI());
                return Unit.INSTANCE;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        obj11 = TimePickerSelectionMode.Companion.getHour-yecRtBI();
        anon.L$0 = obj9;
        anon.Z$0 = obj8;
        anon.label = 2;
        if (TimePickerSelectionMode.equals-impl0(obj9.getSelection-yecRtBI(), obj11) && obj8 != null && DelayKt.delay(100, obj11) == cOROUTINE_SUSPENDED) {
            if (obj8 != null) {
                anon.L$0 = obj9;
                anon.Z$0 = obj8;
                anon.label = 2;
                if (DelayKt.delay(100, obj11) == cOROUTINE_SUSPENDED) {
                    return cOROUTINE_SUSPENDED;
                }
            }
        }
    }

    public static final androidx.compose.material3.TimePickerState rememberTimePickerState(int initialHour, int initialMinute, boolean is24Hour, Composer $composer, int $changed, int i6) {
        int i2;
        int i3;
        boolean traceInProgress;
        int i4;
        String str;
        int changed2;
        boolean changed;
        int i;
        int changed3;
        boolean z;
        Object empty;
        Object anon;
        int obj12;
        int obj13;
        final int i21 = $changed;
        int i5 = 1237715277;
        ComposerKt.sourceInformationMarkerStart($composer, i5, "C(rememberTimePickerState)572@28878L14,575@29014L185,575@28960L239:TimePicker.kt#uh7d8r");
        if (i6 & 1 != 0) {
            obj12 = 0;
        }
        if (i6 & 2 != 0) {
            obj13 = 0;
        }
        int i9 = 4;
        i4 = 0;
        if (i6 & 4 != 0) {
            z = i3;
        } else {
            z = is24Hour;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i5, i21, -1, "androidx.compose.material3.rememberTimePickerState (TimePicker.kt:573)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, -1964549601, "CC(remember):TimePicker.kt#9igjgp");
        int i19 = 1;
        if (i14 ^= 6 > i9) {
            if (!$composer.changed(obj12)) {
                i2 = i21 & 6 == i9 ? i19 : i4;
            } else {
            }
        } else {
        }
        int i22 = 32;
        if (i15 ^= 48 > i22) {
            if (!$composer.changed(obj13)) {
                i = i21 & 48 == i22 ? i19 : i4;
            } else {
            }
        } else {
        }
        int i23 = 256;
        if (i16 ^= 384 > i23) {
            if (!$composer.changed(z)) {
                if (i21 & 384 == i23) {
                    i4 = i19;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i17 = 0;
        Object rememberedValue = composer.rememberedValue();
        int i24 = 0;
        if (i10 |= i4 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new TimePickerKt.rememberTimePickerState.state.1.1(obj12, obj13, z);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (TimePickerState)(TimePickerStateImpl)RememberSaveableKt.rememberSaveable(new Object[i4], TimePickerStateImpl.Companion.Saver(), 0, (Function0)anon, $composer, 0, 4);
    }

    private static final void timeInputOnChange-z7XvuPQ(int selection, androidx.compose.material3.TimePickerState state, TextFieldValue value, TextFieldValue prevValue, int max, Function1<? super TextFieldValue, Unit> onNewValue) {
        int i;
        int charAt;
        boolean minute-yecRtBI;
        Object value3;
        int valueOf;
        Object value2;
        long selection-d9O1mEE;
        long l;
        long l2;
        int i2;
        int obj12;
        if (Intrinsics.areEqual(value.getText(), prevValue.getText())) {
            onNewValue.invoke(value);
        }
        int i3 = 1;
        valueOf = 0;
        i = (CharSequence)value.getText().length() == 0 ? i3 : valueOf;
        if (i != 0) {
            if (TimePickerSelectionMode.equals-impl0(selection, TimePickerSelectionMode.Companion.getHour-yecRtBI())) {
                state.setHour(valueOf);
            } else {
                state.setMinute(valueOf);
            }
            onNewValue.invoke(TextFieldValue.copy-3r_uNRQ$default(value, "", 0, obj6, 0, 6));
        }
        value2 = value;
        if (value2.getText().length() == 3 && TextRange.getStart-impl(value2.getSelection-d9O1mEE()) == i3) {
            if (TextRange.getStart-impl(value2.getSelection-d9O1mEE()) == i3) {
                obj12 = CharsKt.digitToInt(value2.getText().charAt(valueOf));
            } else {
                obj12 = Integer.parseInt(value2.getText());
            }
        } else {
        }
        if (obj12 <= max) {
            if (TimePickerSelectionMode.equals-impl0(selection, TimePickerSelectionMode.Companion.getHour-yecRtBI())) {
                state.setHour(obj12);
                if (obj12 > i3 && !state.is24hour()) {
                    if (!state.is24hour()) {
                        state.setSelection-6_8s6DQ(TimePickerSelectionMode.Companion.getMinute-yecRtBI());
                    }
                }
            } else {
                state.setMinute(obj12);
            }
            if (value2.getText().length() <= 2) {
                value3 = value2;
            } else {
                value2 = TextFieldValue.copy-3r_uNRQ$default(value2, String.valueOf(value2.getText().charAt(valueOf)), 0, selection-d9O1mEE, 0, 6);
            }
            onNewValue.invoke(value2);
        } else {
            value3 = value2;
        }
    }

    private static final Modifier visible(Modifier $this$visible, boolean visible) {
        Function1 noInspectorInfo;
        final int i = 0;
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            noInspectorInfo = new TimePickerKt.visible$$inlined.debugInspectorInfo.1(visible);
        } else {
            noInspectorInfo = InspectableValueKt.getNoInspectorInfo();
        }
        VisibleModifier visibleModifier = new VisibleModifier(visible, noInspectorInfo);
        return $this$visible.then((Modifier)visibleModifier);
    }
}
