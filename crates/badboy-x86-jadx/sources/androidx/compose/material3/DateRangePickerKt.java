package androidx.compose.material3;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.CalendarModel_androidKt;
import androidx.compose.material3.internal.CalendarMonth;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¼\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001ak\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00102\u0015\u0008\u0002\u0010\u0011\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012¢\u0006\u0002\u0008\u00132\u0015\u0008\u0002\u0010\u0014\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012¢\u0006\u0002\u0008\u00132\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a°\u0001\u0010\u001a\u001a\u00020\n2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\u000c\u0008!\u0012\u0008\u0008\"\u0012\u0004\u0008\u0008(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\u000c\u0008!\u0012\u0008\u0008\"\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020\n0 2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\u000c\u0008!\u0012\u0008\u0008\"\u0012\u0004\u0008\u0008('\u0012\u0004\u0012\u00020\n0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010.\u001a`\u0010/\u001a\u00020\u000c2\n\u00100\u001a\u000601j\u0002`22\n\u0008\u0002\u00103\u001a\u0004\u0018\u00010\u001c2\n\u0008\u0002\u00104\u001a\u0004\u0018\u00010\u001c2\n\u0008\u0002\u00105\u001a\u0004\u0018\u00010\u001c2\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u00106\u001a\u0002072\u0008\u0008\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0000¢\u0006\u0004\u00088\u00109\u001a½\u0001\u0010:\u001a\u00020\n2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001c2\u0006\u0010;\u001a\u0002072:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\u000c\u0008!\u0012\u0008\u0008\"\u0012\u0004\u0008\u0008(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\u000c\u0008!\u0012\u0008\u0008\"\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020\n0 2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\u000c\u0008!\u0012\u0008\u0008\"\u0012\u0004\u0008\u0008('\u0012\u0004\u0012\u00020\n0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003ø\u0001\u0000¢\u0006\u0004\u0008<\u0010=\u001a°\u0001\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020@2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001c2:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\u000c\u0008!\u0012\u0008\u0008\"\u0012\u0004\u0008\u0008(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\u000c\u0008!\u0012\u0008\u0008\"\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020\n0 2!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\u000c\u0008!\u0012\u0008\u0008\"\u0012\u0004\u0008\u0008('\u0012\u0004\u0012\u00020\n0&2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010,\u001a\u00020-2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003¢\u0006\u0002\u0010A\u001a.\u0010B\u001a\u0008\u0012\u0004\u0012\u00020D0C2\u0006\u0010\u000b\u001a\u00020@2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020HH\u0002\u001aT\u0010J\u001a\u00020\u000c2\n\u0008\u0002\u00103\u001a\u0004\u0018\u00010\u001c2\n\u0008\u0002\u00104\u001a\u0004\u0018\u00010\u001c2\n\u0008\u0002\u00105\u001a\u0004\u0018\u00010\u001c2\u0008\u0008\u0002\u0010*\u001a\u00020+2\u0008\u0008\u0002\u00106\u001a\u0002072\u0008\u0008\u0002\u0010,\u001a\u00020-H\u0007ø\u0001\u0000¢\u0006\u0004\u0008K\u0010L\u001ae\u0010M\u001a\u00020\n2\u0006\u0010N\u001a\u00020\u001c2\u0008\u0010O\u001a\u0004\u0018\u00010\u001c2\u0008\u0010P\u001a\u0004\u0018\u00010\u001c2:\u0010\u001f\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\u000c\u0008!\u0012\u0008\u0008\"\u0012\u0004\u0008\u0008(#\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\u000c\u0008!\u0012\u0008\u0008\"\u0012\u0004\u0008\u0008($\u0012\u0004\u0012\u00020\n0 H\u0002¢\u0006\u0002\u0010Q\u001a&\u0010R\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020WH\u0000ø\u0001\u0000¢\u0006\u0004\u0008X\u0010Y\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0008\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006Z", d2 = {"CalendarMonthSubheadPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getCalendarMonthSubheadPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "DateRangePickerHeadlinePadding", "DateRangePickerTitlePadding", "HeaderHeightOffset", "Landroidx/compose/ui/unit/Dp;", "F", "DateRangePicker", "", "state", "Landroidx/compose/material3/DateRangePickerState;", "modifier", "Landroidx/compose/ui/Modifier;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "title", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "headline", "showModeToggle", "", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Landroidx/compose/material3/DateRangePickerState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/DatePickerFormatter;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerContent", "selectedStartDateMillis", "", "selectedEndDateMillis", "displayedMonthMillis", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startDateMillis", "endDateMillis", "onDisplayedMonthChange", "Lkotlin/Function1;", "monthInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "(Ljava/lang/Long;Ljava/lang/Long;JLkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DateRangePickerState", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "initialSelectedStartDateMillis", "initialSelectedEndDateMillis", "initialDisplayedMonthMillis", "initialDisplayMode", "Landroidx/compose/material3/DisplayMode;", "DateRangePickerState-HVP43zI", "(Ljava/util/Locale;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;)Landroidx/compose/material3/DateRangePickerState;", "SwitchableDateEntryContent", "displayMode", "SwitchableDateEntryContent-RN-2D1Q", "(Ljava/lang/Long;Ljava/lang/Long;JILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "VerticalMonthsList", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "(Landroidx/compose/foundation/lazy/LazyListState;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "customScrollActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "scrollUpLabel", "", "scrollDownLabel", "rememberDateRangePickerState", "rememberDateRangePickerState-IlFM19s", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/ranges/IntRange;ILandroidx/compose/material3/SelectableDates;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DateRangePickerState;", "updateDateSelection", "dateInMillis", "currentStartDateMillis", "currentEndDateMillis", "(JLjava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;)V", "drawRangeBackground", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "selectedRangeInfo", "Landroidx/compose/material3/SelectedRangeInfo;", "color", "Landroidx/compose/ui/graphics/Color;", "drawRangeBackground-mxwnekA", "(Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;Landroidx/compose/material3/SelectedRangeInfo;J)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DateRangePickerKt {

    private static final PaddingValues CalendarMonthSubheadPadding;
    private static final PaddingValues DateRangePickerHeadlinePadding;
    private static final PaddingValues DateRangePickerTitlePadding;
    private static final float HeaderHeightOffset;
    static {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        final int i20 = 0;
        DateRangePickerKt.CalendarMonthSubheadPadding = PaddingKt.PaddingValues-a9UjIt4$default(Dp.constructor-impl((float)i), Dp.constructor-impl((float)$this$dp$iv), 0, Dp.constructor-impl((float)$this$dp$iv2), 4, i20);
        int i8 = 0;
        int i9 = 0;
        int i14 = 0;
        DateRangePickerKt.DateRangePickerTitlePadding = PaddingKt.PaddingValues-a9UjIt4$default(Dp.constructor-impl((float)i2), i14, Dp.constructor-impl((float)$this$dp$iv3), 0, 10, i20);
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        DateRangePickerKt.DateRangePickerHeadlinePadding = PaddingKt.PaddingValues-a9UjIt4$default(Dp.constructor-impl((float)i3), i14, Dp.constructor-impl((float)$this$dp$iv4), Dp.constructor-impl((float)$this$dp$iv5), 2, i20);
        int i13 = 0;
        DateRangePickerKt.HeaderHeightOffset = Dp.constructor-impl((float)i4);
    }

    public static final void DateRangePicker(androidx.compose.material3.DateRangePickerState state, Modifier modifier, androidx.compose.material3.DatePickerFormatter dateFormatter, Function2<? super Composer, ? super Integer, Unit> title, Function2<? super Composer, ? super Integer, Unit> headline, boolean showModeToggle, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed, int i10) {
        boolean traceInProgress2;
        Object dateFormatter2;
        int obj3;
        Object obj4;
        int skipping;
        int defaultsInvalid;
        Object $i$a$CacheDateRangePickerKt$DateRangePicker$1;
        boolean colors2;
        Object $i$a$CacheDateRangePickerKt$DateRangePicker$calendarModel$1;
        Object $composer2;
        int $dirty3;
        Object $dirty2;
        int $dirty;
        int i4;
        Object obj2;
        int i11;
        boolean traceInProgress;
        Object str;
        boolean z;
        int rememberComposableLambda;
        int i2;
        int i17;
        Object obj6;
        int i12;
        Composer composer;
        boolean changedInstance;
        Object title2;
        int i9;
        int title3;
        Object obj7;
        Object obj5;
        int i15;
        int i8;
        boolean showModeToggle2;
        int i6;
        Object value;
        Object rememberedValue;
        int changed;
        float $i$f$minus5rwHm24;
        androidx.compose.runtime.internal.ComposableLambda companion;
        Composer composer2;
        int i13;
        Object obj;
        int i;
        Object iNSTANCE;
        int i5;
        int i3;
        int i14;
        int i7;
        int i16;
        boolean obj28;
        int obj34;
        obj3 = state;
        traceInProgress2 = dateFormatter;
        final int i48 = $changed;
        Composer restartGroup = $composer.startRestartGroup(650830774);
        ComposerKt.sourceInformation(restartGroup, "C(DateRangePicker)P(5,3,1,6,2,4)95@4412L47,96@4500L185,102@4729L352,112@5169L8,114@5206L15,115@5246L62,132@5955L5,136@6111L1139,116@5313L1937:DateRangePicker.kt#uh7d8r");
        $dirty3 = $changed;
        if (i10 & 1 != 0) {
            $dirty3 |= 6;
        } else {
            if (i48 & 6 == 0) {
                i4 = restartGroup.changed(obj3) ? 4 : 2;
                $dirty3 |= i4;
            }
        }
        i11 = i10 & 2;
        if (i11 != 0) {
            $dirty3 |= 48;
            str = modifier;
        } else {
            if (i48 & 48 == 0) {
                i2 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i2;
            } else {
                str = modifier;
            }
        }
        if (i48 & 384 == 0) {
            if (i10 & 4 == 0) {
                if (i48 & 512 == 0) {
                    changedInstance = restartGroup.changed(traceInProgress2);
                } else {
                    changedInstance = restartGroup.changedInstance(traceInProgress2);
                }
                i17 = changedInstance != null ? 256 : 128;
            } else {
            }
            $dirty3 |= i17;
        }
        i12 = i10 & 8;
        if (i12 != 0) {
            $dirty3 |= 3072;
            title2 = title;
        } else {
            if (i48 & 3072 == 0) {
                i9 = restartGroup.changedInstance(title) ? 2048 : 1024;
                $dirty3 |= i9;
            } else {
                title2 = title;
            }
        }
        int i50 = i10 & 16;
        if (i50 != 0) {
            $dirty3 |= 24576;
            obj5 = headline;
        } else {
            if (i48 & 24576 == 0) {
                i15 = restartGroup.changedInstance(headline) ? 16384 : 8192;
                $dirty3 |= i15;
            } else {
                obj5 = headline;
            }
        }
        i8 = i10 & 32;
        int i54 = 196608;
        if (i8 != 0) {
            $dirty3 |= i54;
            showModeToggle2 = showModeToggle;
        } else {
            if (i54 &= i48 == 0) {
                i6 = restartGroup.changed(showModeToggle) ? 131072 : 65536;
                $dirty3 |= i6;
            } else {
                showModeToggle2 = showModeToggle;
            }
        }
        if (i56 &= i48 == 0) {
            if (i10 & 64 == 0) {
                changed = restartGroup.changed(colors) ? 1048576 : 524288;
            } else {
                value = colors;
            }
            $dirty3 |= changed;
        } else {
            value = colors;
        }
        if (i59 &= $dirty3 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                obj34 = -3670017;
                String str4 = "CC(remember):DateRangePicker.kt#9igjgp";
                if (i48 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i11 != 0) {
                            str = defaultsInvalid;
                        }
                        if (i10 & 4 != 0) {
                            ComposerKt.sourceInformationMarkerStart(restartGroup, -1454781303, str4);
                            i11 = restartGroup;
                            obj = 0;
                            Object rememberedValue2 = i11.rememberedValue();
                            i = 0;
                            obj28 = i32;
                            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                                int i33 = 0;
                                i11.updateRememberedValue(DatePickerDefaults.dateFormatter$default(DatePickerDefaults.INSTANCE, 0, 0, 0, 7, 0));
                            } else {
                                $i$a$CacheDateRangePickerKt$DateRangePicker$1 = rememberedValue2;
                            }
                            dateFormatter2 = $i$a$CacheDateRangePickerKt$DateRangePicker$1;
                            ComposerKt.sourceInformationMarkerEnd(restartGroup);
                            $dirty3 &= -897;
                        } else {
                            dateFormatter2 = dateFormatter;
                        }
                        if (i12 != 0) {
                            DateRangePickerKt.DateRangePicker.2 anon2 = new DateRangePickerKt.DateRangePicker.2(obj3);
                            obj28 = $dirty3;
                            title2 = $i$a$CacheDateRangePickerKt$DateRangePicker$1;
                        } else {
                            obj28 = $dirty3;
                            $dirty = 1;
                            i12 = 54;
                        }
                        if (i50 != 0) {
                            DateRangePickerKt.DateRangePicker.3 anon = new DateRangePickerKt.DateRangePicker.3(obj3, dateFormatter2);
                            obj5 = $i$a$CacheDateRangePickerKt$DateRangePicker$1;
                        }
                        if (i8 != 0) {
                            showModeToggle2 = $i$a$CacheDateRangePickerKt$DateRangePicker$1;
                        }
                        if (i10 & 64 != 0) {
                            $dirty3 = obj28 & obj34;
                            showModeToggle2 = colors3;
                            colors2 = z2;
                            obj7 = title2;
                            title2 = str;
                        } else {
                            $dirty3 = obj28;
                            obj7 = title2;
                            colors2 = showModeToggle2;
                            showModeToggle2 = value;
                            title2 = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 4 != 0) {
                            $dirty3 &= -897;
                        }
                        if (i10 & 64 != 0) {
                            dateFormatter2 = dateFormatter;
                            $dirty3 = i37;
                            obj7 = title2;
                            colors2 = showModeToggle2;
                            showModeToggle2 = value;
                            title2 = str;
                        } else {
                            dateFormatter2 = dateFormatter;
                            obj7 = title2;
                            colors2 = showModeToggle2;
                            showModeToggle2 = value;
                            title2 = str;
                        }
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(650830774, $dirty3, -1, "androidx.compose.material3.DateRangePicker (DateRangePicker.kt:113)");
                }
                Locale defaultLocale = CalendarLocale_androidKt.defaultLocale(restartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1454754600, str4);
                composer = restartGroup;
                int i52 = 0;
                rememberedValue = composer.rememberedValue();
                int i60 = 0;
                if (!restartGroup.changed(defaultLocale)) {
                    obj28 = colors2;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int showModeToggle3 = 0;
                        composer.updateRememberedValue(CalendarModel_androidKt.createCalendarModel(defaultLocale));
                    } else {
                        $i$a$CacheDateRangePickerKt$DateRangePicker$calendarModel$1 = rememberedValue;
                    }
                } else {
                    obj28 = colors2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                restartGroup.startReplaceGroup(-1454747621);
                ComposerKt.sourceInformation(restartGroup, "122@5491L323");
                if (obj28 != null) {
                    DateRangePickerKt.DateRangePicker.4 anon4 = new DateRangePickerKt.DateRangePicker.4(obj3);
                    i8 = rememberComposableLambda;
                } else {
                    i8 = rememberComposableLambda;
                }
                restartGroup.endReplaceGroup();
                int i61 = 0;
                DateRangePickerKt.DateRangePicker.5 anon3 = new DateRangePickerKt.DateRangePicker.5(obj3, (CalendarModel)$i$a$CacheDateRangePickerKt$DateRangePicker$calendarModel$1, dateFormatter2, showModeToggle2);
                DatePickerKt.DateEntryContainer-au3_HiA(title2, obj7, obj5, i8, showModeToggle2, TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getRangeSelectionHeaderHeadlineFont(), restartGroup, 6), Dp.constructor-impl(rangeSelectionHeaderContainerHeight-D9Ej5fM - headerHeightOffset), (Function2)ComposableLambdaKt.rememberComposableLambda(-57534331, true, anon3, restartGroup, 54), restartGroup, i22 | obj3);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                title3 = $dirty3;
                $dirty2 = calendarModel;
                z = obj28;
                obj4 = title2;
                obj6 = showModeToggle2;
                $composer2 = obj;
                obj2 = obj5;
            } else {
                restartGroup.skipToGroupEnd();
                composer2 = restartGroup;
                title3 = $dirty3;
                obj4 = str;
                $dirty2 = title2;
                z = showModeToggle2;
                obj6 = value;
                $composer2 = traceInProgress2;
                obj2 = obj5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new DateRangePickerKt.DateRangePicker.6(state, obj4, $composer2, $dirty2, obj2, z, obj6, i48, i10);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    private static final void DateRangePickerContent(Long selectedStartDateMillis, Long selectedEndDateMillis, long displayedMonthMillis, Function2<? super Long, ? super Long, Unit> onDatesSelectionChange, Function1<? super Long, Unit> onDisplayedMonthChange, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerFormatter dateFormatter, androidx.compose.material3.SelectableDates selectableDates, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        int traceInProgress;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int skipping;
        boolean traceInProgress2;
        Integer columnMeasurePolicy;
        Composer composer;
        Object restartGroup;
        Modifier materializeModifier;
        androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap;
        int $dirty;
        Object obj8;
        Object obj7;
        Object obj;
        Object obj5;
        int horizontalAlignment$iv;
        Object obj6;
        int i13;
        Object obj2;
        int i14;
        int i8;
        Object obj3;
        int i15;
        Object obj9;
        int i16;
        int i;
        int i5;
        int i4;
        Object obj4;
        boolean changedInstance;
        int i19;
        int i10;
        int i17;
        CalendarMonth calendar;
        int monthsListState;
        int i11;
        int i2;
        int i6;
        int i3;
        androidx.compose.foundation.layout.Arrangement.Vertical vertical;
        Modifier modifier;
        int i18;
        int i20;
        int i9;
        kotlin.jvm.functions.Function0 function0;
        int i12;
        int i7;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        Composer composer2;
        ColumnScopeInstance columnScopeInstance;
        int obj45;
        materializeModifier = displayedMonthMillis;
        obj7 = yearRange;
        obj = dateFormatter;
        obj5 = selectableDates;
        obj6 = $composer;
        traceInProgress = obj46;
        restartGroup = $changed.startRestartGroup(-787063721);
        ComposerKt.sourceInformation(restartGroup, "C(DateRangePickerContent)P(8,7,3,4,5!1,9,2,6)718@31942L87,719@32034L648:DateRangePicker.kt#uh7d8r");
        if (traceInProgress & 6 == 0) {
            i13 = restartGroup.changed(selectedStartDateMillis) ? 4 : 2;
            $dirty |= i13;
        } else {
            obj8 = selectedStartDateMillis;
        }
        if (traceInProgress & 48 == 0) {
            i14 = restartGroup.changed(selectedEndDateMillis) ? 32 : 16;
            $dirty |= i14;
        } else {
            obj2 = selectedEndDateMillis;
        }
        if (traceInProgress & 384 == 0) {
            i8 = restartGroup.changed(materializeModifier) ? 256 : 128;
            $dirty |= i8;
        }
        if (traceInProgress & 3072 == 0) {
            i15 = restartGroup.changedInstance(onDisplayedMonthChange) ? 2048 : 1024;
            $dirty |= i15;
        } else {
            obj3 = onDisplayedMonthChange;
        }
        if (traceInProgress & 24576 == 0) {
            i16 = restartGroup.changedInstance(calendarModel) ? 16384 : 8192;
            $dirty |= i16;
        } else {
            obj9 = calendarModel;
        }
        if (i71 &= traceInProgress == 0) {
            i = restartGroup.changedInstance(obj7) ? 131072 : 65536;
            $dirty |= i;
        }
        if (i72 &= traceInProgress == 0) {
            i5 = restartGroup.changedInstance(obj) ? 1048576 : 524288;
            $dirty |= i5;
        }
        if (i73 &= traceInProgress == 0) {
            if (i76 &= traceInProgress == 0) {
                changedInstance = restartGroup.changed(obj5);
            } else {
                changedInstance = restartGroup.changedInstance(obj5);
            }
            i4 = changedInstance != null ? 8388608 : 4194304;
            $dirty |= i4;
        }
        if (i74 &= traceInProgress == 0) {
            i19 = restartGroup.changed(colors) ? 67108864 : 33554432;
            $dirty |= i19;
        } else {
            obj4 = colors;
        }
        if (traceInProgress & i78 == 0) {
            i10 = restartGroup.changed(obj6) ? 536870912 : 268435456;
            $dirty |= i10;
        }
        if ($dirty & i17 == 306783378) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-787063721, $dirty, -1, "androidx.compose.material3.DateRangePickerContent (DateRangePicker.kt:715)");
                }
                CalendarMonth month = obj7.getMonth(materializeModifier);
                int i67 = 0;
                calendar = month;
                Modifier padding-VpY3zN4$default = PaddingKt.padding-VpY3zN4$default((Modifier)Modifier.Companion, DatePickerKt.getDatePickerHorizontalPadding(), 0, 2, 0);
                int i38 = 6;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
                androidx.compose.foundation.layout.Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                androidx.compose.ui.Alignment.Horizontal start = Alignment.Companion.getStart();
                i2 = i38;
                columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, start, restartGroup, i80 | i85);
                i6 = 0;
                i3 = i41;
                vertical = top;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                obj45 = currentCompositeKeyHash;
                modifier = padding-VpY3zN4$default;
                kotlin.jvm.functions.Function0 function02 = constructor;
                i20 = 0;
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
                int i83 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i86 = 0;
                Composer composer3 = constructor-impl;
                int i87 = 0;
                if (!composer3.getInserting()) {
                    measurePolicy$iv = columnMeasurePolicy;
                    composer2 = restartGroup;
                    if (!Intrinsics.areEqual(composer3.rememberedValue(), Integer.valueOf(obj45))) {
                        composer3.updateRememberedValue(Integer.valueOf(obj45));
                        constructor-impl.apply(Integer.valueOf(obj45), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer3;
                    }
                } else {
                    measurePolicy$iv = columnMeasurePolicy;
                    composer2 = restartGroup;
                }
                Updater.set-impl(constructor-impl, ComposedModifierKt.materializeModifier(restartGroup, padding-VpY3zN4$default), ComposeUiNode.Companion.getSetModifier());
                skipping = composer2;
                restartGroup = 0;
                i18 = i24;
                ComposerKt.sourceInformationMarkerStart(skipping, -384862393, "C87@4365L9:Column.kt#2w3rfo");
                i12 = i48 | 6;
                obj4 = skipping;
                i7 = 0;
                columnScopeInstance = iNSTANCE;
                ComposerKt.sourceInformationMarkerStart(obj4, 556336155, "C720@32122L31,721@32162L514:DateRangePicker.kt#uh7d8r");
                DatePickerKt.WeekDays(obj6, obj7, obj4, i26 |= i51);
                monthsListState = $dirty;
                androidx.compose.ui.Alignment.Horizontal horizontal = start;
                DateRangePickerKt.VerticalMonthsList(LazyListStateKt.rememberLazyListState(month.indexIn(obj), i67, restartGroup, i67, 2), selectedStartDateMillis, obj2, obj3, obj9, obj7, obj, obj5, colors, obj6, obj4, i36 | i66);
                ComposerKt.sourceInformationMarkerEnd(obj4);
                ComposerKt.sourceInformationMarkerEnd(skipping);
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
                monthsListState = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new DateRangePickerKt.DateRangePickerContent.2(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, currentCompositionLocalMap, onDisplayedMonthChange, calendarModel, yearRange, dateFormatter, selectableDates, colors, $composer, obj46);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final androidx.compose.material3.DateRangePickerState DateRangePickerState-HVP43zI(Locale locale, Long initialSelectedStartDateMillis, Long initialSelectedEndDateMillis, Long initialDisplayedMonthMillis, IntRange yearRange, int initialDisplayMode, androidx.compose.material3.SelectableDates selectableDates) {
        DateRangePickerStateImpl dateRangePickerStateImpl = new DateRangePickerStateImpl(initialSelectedStartDateMillis, initialSelectedEndDateMillis, initialDisplayedMonthMillis, yearRange, initialDisplayMode, selectableDates, locale, 0);
        return (DateRangePickerState)dateRangePickerStateImpl;
    }

    public static androidx.compose.material3.DateRangePickerState DateRangePickerState-HVP43zI$default(Locale locale, Long long2, Long long3, Long long4, IntRange intRange5, int i6, androidx.compose.material3.SelectableDates selectableDates7, int i8, Object object9) {
        int obj2;
        int obj3;
        int obj4;
        IntRange obj5;
        int obj6;
        androidx.compose.material3.SelectableDates obj7;
        final int i = 0;
        if (i8 & 2 != 0) {
            obj2 = i;
        }
        if (i8 & 4 != 0) {
            obj3 = i;
        }
        if (i8 & 8 != 0) {
            obj4 = obj2;
        }
        if (i8 & 16 != 0) {
            obj5 = DatePickerDefaults.INSTANCE.getYearRange();
        }
        if (i8 & 32 != 0) {
            obj6 = DisplayMode.Companion.getPicker-jFl-4v0();
        }
        if (i8 &= 64 != 0) {
            obj7 = DatePickerDefaults.INSTANCE.getAllDates();
        }
        return DateRangePickerKt.DateRangePickerState-HVP43zI(locale, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    private static final void SwitchableDateEntryContent-RN-2D1Q(Long selectedStartDateMillis, Long selectedEndDateMillis, long displayedMonthMillis, int displayMode, Function2<? super Long, ? super Long, Unit> onDatesSelectionChange, Function1<? super Long, Unit> onDisplayedMonthChange, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerFormatter dateFormatter, androidx.compose.material3.SelectableDates selectableDates, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed, int $changed1) {
        Object obj2;
        int traceInProgress2;
        boolean traceInProgress;
        Object endRestartGroup;
        int $dirty;
        int $dirty1;
        Object obj5;
        int i14;
        Object obj6;
        Object obj;
        int i4;
        Object obj7;
        int i15;
        long l;
        int i10;
        Object obj9;
        int i9;
        int i;
        Object obj3;
        int i16;
        Object obj8;
        Composer restartGroup;
        int i12;
        int i13;
        int i2;
        Object obj4;
        int $dirty2;
        int i5;
        int i11;
        int i3;
        Composer composer;
        boolean changedInstance;
        int i6;
        int semantics$default;
        int i7;
        int i8;
        androidx.compose.material3.DisplayMode box-impl;
        int obj32;
        obj9 = selectableDates;
        i12 = $changed1;
        restartGroup = $changed.startRestartGroup(-532789335);
        ComposerKt.sourceInformation(restartGroup, "C(SwitchableDateEntryContent)P(9,8,4,3:c#material3.DisplayMode,5,6!1,10,2,7)672@30082L1249,664@29854L1477:DateRangePicker.kt#uh7d8r");
        if (i12 & 6 == 0) {
            i4 = restartGroup.changed(selectedStartDateMillis) ? 4 : 2;
            $dirty |= i4;
        } else {
            obj5 = selectedStartDateMillis;
        }
        if (i12 & 48 == 0) {
            i15 = restartGroup.changed(selectedEndDateMillis) ? 32 : 16;
            $dirty |= i15;
        } else {
            obj7 = selectedEndDateMillis;
        }
        if (i12 & 384 == 0) {
            i9 = restartGroup.changed(displayedMonthMillis) ? 256 : 128;
            $dirty |= i9;
        } else {
            l = displayedMonthMillis;
        }
        if (i12 & 3072 == 0) {
            i = restartGroup.changed(onDatesSelectionChange) ? 2048 : 1024;
            $dirty |= i;
        } else {
            i13 = onDatesSelectionChange;
        }
        if (i12 & 24576 == 0) {
            i16 = restartGroup.changedInstance(onDisplayedMonthChange) ? 16384 : 8192;
            $dirty |= i16;
        } else {
            obj3 = onDisplayedMonthChange;
        }
        if (i30 &= i12 == 0) {
            i2 = restartGroup.changedInstance(calendarModel) ? 131072 : 65536;
            $dirty |= i2;
        } else {
            obj8 = calendarModel;
        }
        if (i32 &= i12 == 0) {
            i5 = restartGroup.changedInstance(yearRange) ? 1048576 : 524288;
            $dirty |= i5;
        } else {
            obj4 = yearRange;
        }
        if (i12 & i34 == 0) {
            i11 = restartGroup.changedInstance(dateFormatter) ? 8388608 : 4194304;
            $dirty |= i11;
        } else {
            obj6 = dateFormatter;
        }
        if (i12 & i35 == 0) {
            if (i12 & i38 == 0) {
                changedInstance = restartGroup.changed(obj9);
            } else {
                changedInstance = restartGroup.changedInstance(obj9);
            }
            i3 = changedInstance != null ? 67108864 : 33554432;
            $dirty |= i3;
        }
        if (i12 & i36 == 0) {
            i6 = restartGroup.changed(colors) ? 536870912 : 268435456;
            $dirty |= i6;
        } else {
            obj2 = colors;
        }
        if (obj34 & 6 == 0) {
            i7 = restartGroup.changed($composer) ? 4 : 2;
            $dirty1 |= i7;
        } else {
            obj = $composer;
        }
        if ($dirty & i40 == 306783378 && $dirty1 & 3 == 2) {
            if ($dirty1 & 3 == 2) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-532789335, $dirty, $dirty1, "androidx.compose.material3.SwitchableDateEntryContent (DateRangePicker.kt:661)");
                    }
                    int i26 = 0;
                    int $dirty3 = 0;
                    i12 = 1;
                    i8 = $dirty1;
                    DateRangePickerKt.SwitchableDateEntryContent.2 anon = new DateRangePickerKt.SwitchableDateEntryContent.2(selectedStartDateMillis, obj7, l, obj6, obj3, obj8, obj4, obj6, obj9, colors, obj);
                    obj7 = restartGroup;
                    CrossfadeKt.Crossfade(DisplayMode.box-impl(i13), SemanticsModifierKt.semantics$default((Modifier)Modifier.Companion, false, (Function1)DateRangePickerKt.SwitchableDateEntryContent.1.INSTANCE, i12, 0), (FiniteAnimationSpec)AnimationSpecKt.spring$default(i26, i26, $dirty3, 7, $dirty3), 0, (Function3)ComposableLambdaKt.rememberComposableLambda(-1026642619, i12, anon, restartGroup, 54), obj7, i21 | 24960, 8);
                    composer = obj7;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    restartGroup.skipToGroupEnd();
                    $dirty2 = $dirty;
                    i8 = $dirty1;
                    composer = restartGroup;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            obj32 = $dirty2;
            endRestartGroup = new DateRangePickerKt.SwitchableDateEntryContent.3(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, obj6, i13, onDisplayedMonthChange, calendarModel, yearRange, dateFormatter, selectableDates, colors, $composer, $changed1, obj34);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        } else {
            obj32 = $dirty2;
        }
    }

    private static final void VerticalMonthsList(LazyListState lazyListState, Long selectedStartDateMillis, Long selectedEndDateMillis, Function2<? super Long, ? super Long, Unit> onDatesSelectionChange, Function1<? super Long, Unit> onDisplayedMonthChange, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerFormatter dateFormatter, androidx.compose.material3.SelectableDates selectableDates, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        int traceInProgress2;
        Object rememberedValue;
        int i2;
        Object anon;
        int empty;
        Object obj2;
        int $dirty;
        Function1 i8;
        int i13;
        Object obj6;
        Object obj4;
        int i4;
        Object obj7;
        Object obj5;
        int i7;
        Object obj3;
        Object obj9;
        int i16;
        Object obj8;
        int i6;
        int i17;
        int i10;
        int i3;
        int i5;
        Object today;
        boolean changedInstance;
        Object obj;
        int rememberedValue2;
        int i11;
        boolean skipping;
        boolean traceInProgress;
        int i12;
        int str;
        int i15;
        int i14;
        int i;
        boolean z;
        int i9;
        Object companion;
        obj5 = calendarModel;
        obj4 = yearRange;
        obj9 = dateFormatter;
        rememberedValue2 = $changed;
        traceInProgress2 = 1257365001;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(VerticalMonthsList)P(3,8,7,4,5!1,9,2,6)756@33410L158,762@33630L5,762@33637L3748,762@33573L3812,839@37420L228,839@37390L258:DateRangePicker.kt#uh7d8r");
        if (rememberedValue2 & 6 == 0) {
            i13 = restartGroup.changed(lazyListState) ? 4 : 2;
            $dirty |= i13;
        }
        if (rememberedValue2 & 48 == 0) {
            i4 = restartGroup.changed(selectedStartDateMillis) ? 32 : 16;
            $dirty |= i4;
        } else {
            obj6 = selectedStartDateMillis;
        }
        if (rememberedValue2 & 384 == 0) {
            i7 = restartGroup.changed(selectedEndDateMillis) ? 256 : 128;
            $dirty |= i7;
        } else {
            obj7 = selectedEndDateMillis;
        }
        if (rememberedValue2 & 3072 == 0) {
            i16 = restartGroup.changedInstance(onDatesSelectionChange) ? 2048 : 1024;
            $dirty |= i16;
        } else {
            obj3 = onDatesSelectionChange;
        }
        if (rememberedValue2 & 24576 == 0) {
            i6 = restartGroup.changedInstance(onDisplayedMonthChange) ? 16384 : 8192;
            $dirty |= i6;
        } else {
            obj8 = onDisplayedMonthChange;
        }
        if (i33 &= rememberedValue2 == 0) {
            i17 = restartGroup.changedInstance(obj5) ? 131072 : 65536;
            $dirty |= i17;
        }
        if (i34 &= rememberedValue2 == 0) {
            i10 = restartGroup.changedInstance(obj4) ? 1048576 : 524288;
            $dirty |= i10;
        }
        if (i35 &= rememberedValue2 == 0) {
            if (i39 &= rememberedValue2 == 0) {
                changedInstance = restartGroup.changed(obj9);
            } else {
                changedInstance = restartGroup.changedInstance(obj9);
            }
            i3 = changedInstance != null ? 8388608 : 4194304;
            $dirty |= i3;
        }
        if (i36 &= rememberedValue2 == 0) {
            i5 = restartGroup.changed(selectableDates) ? 67108864 : 33554432;
            $dirty |= i5;
        } else {
            obj = selectableDates;
        }
        if (i37 &= rememberedValue2 == 0) {
            i15 = restartGroup.changed(colors) ? 536870912 : 268435456;
            $dirty |= i15;
        } else {
            today = colors;
        }
        if ($dirty & i14 == 306783378) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.VerticalMonthsList (DateRangePicker.kt:753)");
                }
                String str3 = "CC(remember):DateRangePicker.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -2140165432, str3);
                Composer composer = restartGroup;
                i = 0;
                rememberedValue = composer.rememberedValue();
                i9 = 0;
                if (!restartGroup.changed(obj4)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        rememberedValue2 = 0;
                        companion = rememberedValue;
                        composer.updateRememberedValue(obj5.getMonth(obj4.getFirst(), 1));
                    } else {
                        companion = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                i12 = $dirty;
                Object obj12 = obj4;
                DateRangePickerKt.VerticalMonthsList.1 firstMonth = new DateRangePickerKt.VerticalMonthsList.1(obj6, obj7, onDatesSelectionChange, lazyListState, obj12, obj5, (CalendarMonth)rememberedValue, obj9, colors, obj5.getToday(), obj);
                obj4 = obj12;
                obj6 = 1;
                TextKt.ProvideTextStyle(TypographyKt.getValue(DatePickerModalTokens.INSTANCE.getDateLabelTextFont(), restartGroup, 6), (Function2)ComposableLambdaKt.rememberComposableLambda(1090773432, obj6, firstMonth, restartGroup, 54), restartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -2140037042, str3);
                int i25 = 0;
                i2 = i12 & 14 == 4 ? obj6 : i25;
                i11 = i28 &= i12 == 16384 ? obj6 : i25;
                obj9 = restartGroup;
                obj = 0;
                rememberedValue2 = obj9.rememberedValue();
                skipping = 0;
                if (i22 |= changedInstance3 == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        i14 = 0;
                        anon = new DateRangePickerKt.VerticalMonthsList.2.1(lazyListState, onDisplayedMonthChange, obj5, obj4, 0);
                        obj9.updateRememberedValue((Function2)anon);
                    } else {
                        obj2 = lazyListState;
                        anon = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.LaunchedEffect(obj2, (Function2)anon, restartGroup, i12 & 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i12 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new DateRangePickerKt.VerticalMonthsList.3(obj2, selectedStartDateMillis, selectedEndDateMillis, onDatesSelectionChange, onDisplayedMonthChange, calendarModel, yearRange, dateFormatter, selectableDates, colors, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void access$DateRangePickerContent(Long selectedStartDateMillis, Long selectedEndDateMillis, long displayedMonthMillis, Function2 onDatesSelectionChange, Function1 onDisplayedMonthChange, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerFormatter dateFormatter, androidx.compose.material3.SelectableDates selectableDates, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        DateRangePickerKt.DateRangePickerContent(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, onDatesSelectionChange, onDisplayedMonthChange, calendarModel, yearRange, dateFormatter, selectableDates, colors, $composer, $changed);
    }

    public static final void access$SwitchableDateEntryContent-RN-2D1Q(Long selectedStartDateMillis, Long selectedEndDateMillis, long displayedMonthMillis, int displayMode, Function2 onDatesSelectionChange, Function1 onDisplayedMonthChange, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerFormatter dateFormatter, androidx.compose.material3.SelectableDates selectableDates, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed, int $changed1) {
        DateRangePickerKt.SwitchableDateEntryContent-RN-2D1Q(selectedStartDateMillis, selectedEndDateMillis, displayedMonthMillis, displayMode, onDatesSelectionChange, onDisplayedMonthChange, calendarModel, yearRange, dateFormatter, selectableDates, colors, $composer, $changed, $changed1);
    }

    public static final void access$VerticalMonthsList(LazyListState lazyListState, Long selectedStartDateMillis, Long selectedEndDateMillis, Function2 onDatesSelectionChange, Function1 onDisplayedMonthChange, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerFormatter dateFormatter, androidx.compose.material3.SelectableDates selectableDates, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        DateRangePickerKt.VerticalMonthsList(lazyListState, selectedStartDateMillis, selectedEndDateMillis, onDatesSelectionChange, onDisplayedMonthChange, calendarModel, yearRange, dateFormatter, selectableDates, colors, $composer, $changed);
    }

    public static final List access$customScrollActions(LazyListState state, CoroutineScope coroutineScope, String scrollUpLabel, String scrollDownLabel) {
        return DateRangePickerKt.customScrollActions(state, coroutineScope, scrollUpLabel, scrollDownLabel);
    }

    public static final PaddingValues access$getDateRangePickerHeadlinePadding$p() {
        return DateRangePickerKt.DateRangePickerHeadlinePadding;
    }

    public static final PaddingValues access$getDateRangePickerTitlePadding$p() {
        return DateRangePickerKt.DateRangePickerTitlePadding;
    }

    public static final void access$updateDateSelection(long dateInMillis, Long currentStartDateMillis, Long currentEndDateMillis, Function2 onDatesSelectionChange) {
        DateRangePickerKt.updateDateSelection(dateInMillis, currentStartDateMillis, currentEndDateMillis, onDatesSelectionChange);
    }

    private static final List<CustomAccessibilityAction> customScrollActions(LazyListState state, CoroutineScope coroutineScope, String scrollUpLabel, String scrollDownLabel) {
        DateRangePickerKt.customScrollActions.scrollUpAction.1 anon = new DateRangePickerKt.customScrollActions.scrollUpAction.1(state, coroutineScope);
        DateRangePickerKt.customScrollActions.scrollDownAction.1 anon2 = new DateRangePickerKt.customScrollActions.scrollDownAction.1(state, coroutineScope);
        CustomAccessibilityAction[] arr = new CustomAccessibilityAction[2];
        CustomAccessibilityAction customAccessibilityAction = new CustomAccessibilityAction(scrollUpLabel, (Function0)anon);
        CustomAccessibilityAction customAccessibilityAction2 = new CustomAccessibilityAction(scrollDownLabel, (Function0)anon2);
        return CollectionsKt.listOf(customAccessibilityAction, customAccessibilityAction2);
    }

    public static final void drawRangeBackground-mxwnekA(ContentDrawScope $this$drawRangeBackground_u2dmxwnekA, androidx.compose.material3.SelectedRangeInfo selectedRangeInfo, long color) {
        float width-impl;
        float px-0680j_4;
        int startX;
        int i7;
        int i2;
        int endX;
        float f;
        LayoutDirection layoutDirection;
        int size-NH-jbRc2;
        int y;
        float itemContainerWidth;
        int i6;
        long size-NH-jbRc3;
        long size-NH-jbRc;
        long size-NH-jbRc4;
        float f2;
        DrawScope drawScope;
        long l;
        long l2;
        int i3;
        int i4;
        int i5;
        int i8;
        int i9;
        int i;
        width-impl = $this$drawRangeBackground_u2dmxwnekA;
        px-0680j_4 = width-impl.toPx-0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float px-0680j_42 = width-impl.toPx-0680j_4(DatePickerKt.getRecommendedSizeForAccessibility());
        float px-0680j_43 = width-impl.toPx-0680j_4(DatePickerModalTokens.INSTANCE.getDateStateLayerHeight-D9Ej5fM());
        float f4 = (float)i14;
        i12 /= f4;
        float f6 = (float)i20;
        int i21 = f6 * px-0680j_4;
        i18 /= f6;
        long gridStartCoordinates-nOcc-ac = selectedRangeInfo.getGridStartCoordinates-nOcc-ac();
        int i23 = 0;
        int i24 = 0;
        int y-impl = IntOffset.getY-impl(gridStartCoordinates-nOcc-ac);
        long gridEndCoordinates-nOcc-ac = selectedRangeInfo.getGridEndCoordinates-nOcc-ac();
        int i22 = 0;
        int i27 = 0;
        int y-impl2 = IntOffset.getY-impl(gridEndCoordinates-nOcc-ac);
        i7 = selectedRangeInfo.getFirstIsSelectionStart() ? px-0680j_4 / f4 : 0;
        i30 += i13;
        f = selectedRangeInfo.getLastIsSelectionEnd() ? px-0680j_4 / f4 : px-0680j_4;
        i2 = width-impl.getLayoutDirection() == LayoutDirection.Rtl ? i6 : 0;
        if (i2 != 0) {
            startX = width-impl6 - startX;
            endX = layoutDirection - endX;
        }
        if (y-impl == y-impl2) {
            size-NH-jbRc2 = endX - startX;
        } else {
            if (i2 != 0) {
                size-NH-jbRc2 = -startX;
            } else {
                width-impl5 -= startX;
            }
        }
        DrawScope drawScope2 = color;
        DrawScope.drawRect-n-J9OG0$default((DrawScope)width-impl, drawScope2, obj20, OffsetKt.Offset(startX, i31), obj22, SizeKt.Size(size-NH-jbRc2, px-0680j_43), obj24, 0, 0, 0);
        if (y-impl != y-impl2) {
            i35--;
            while (y > 0) {
                DrawScope.drawRect-n-J9OG0$default((DrawScope)width-impl, color, obj33, OffsetKt.Offset(0, i10 += i31), obj35, SizeKt.Size(Size.getWidth-impl($this$drawRangeBackground_u2dmxwnekA.getSize-NH-jbRc()), px-0680j_43), obj37, 0, 0, 0);
                y--;
                width-impl = $this$drawRangeBackground_u2dmxwnekA;
                px-0680j_4 = i6;
            }
            itemContainerWidth = px-0680j_4;
            int itemContainerWidth2 = 0;
            if ($this$drawRangeBackground_u2dmxwnekA.getLayoutDirection() == LayoutDirection.Ltr) {
                width-impl = itemContainerWidth2;
            } else {
                width-impl = Size.getWidth-impl($this$drawRangeBackground_u2dmxwnekA.getSize-NH-jbRc());
            }
            if (i2 != 0) {
                px-0680j_4 = endX - width-impl3;
            } else {
                px-0680j_4 = endX;
            }
            DrawScope.drawRect-n-J9OG0$default((DrawScope)$this$drawRangeBackground_u2dmxwnekA, color, obj33, OffsetKt.Offset(width-impl, i16 += i13), obj35, SizeKt.Size(px-0680j_4, px-0680j_43), obj37, 0, 0, 0);
        } else {
            itemContainerWidth = px-0680j_4;
        }
    }

    public static final PaddingValues getCalendarMonthSubheadPadding() {
        return DateRangePickerKt.CalendarMonthSubheadPadding;
    }

    public static final androidx.compose.material3.DateRangePickerState rememberDateRangePickerState-IlFM19s(Long initialSelectedStartDateMillis, Long initialSelectedEndDateMillis, Long initialDisplayedMonthMillis, IntRange yearRange, int initialDisplayMode, androidx.compose.material3.SelectableDates selectableDates, Composer $composer, int $changed, int i9) {
        int i11;
        int i4;
        int i2;
        int yearRange2;
        int picker-jFl-4v0;
        int i6;
        int allDates;
        boolean traceInProgress;
        String str;
        int changed4;
        int i5;
        boolean changed;
        int i3;
        int changed5;
        int i8;
        int changed3;
        int changed2;
        int empty;
        Object anon;
        int i7;
        int i;
        int i10;
        IntRange intRange;
        int i12;
        androidx.compose.material3.SelectableDates date;
        int i13;
        final Composer composer2 = $composer;
        final int i41 = $changed;
        int i14 = -2012087461;
        ComposerKt.sourceInformationMarkerStart(composer2, i14, "C(rememberDateRangePickerState)P(3,2,1,5,0:c#material3.DisplayMode)262@11757L15,263@11866L435,263@11784L517:DateRangePicker.kt#uh7d8r");
        i7 = i9 & 1 != 0 ? i11 : initialSelectedStartDateMillis;
        i = i9 & 2 != 0 ? i4 : initialSelectedEndDateMillis;
        i10 = i9 & 4 != 0 ? i2 : initialDisplayedMonthMillis;
        if (i9 & 8 != 0) {
            intRange = yearRange2;
        } else {
            intRange = yearRange;
        }
        if (i9 & 16 != 0) {
            i12 = picker-jFl-4v0;
        } else {
            i12 = initialDisplayMode;
        }
        int i16 = 32;
        if (i9 & 32 != 0) {
            date = allDates;
        } else {
            date = selectableDates;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i14, i41, -1, "androidx.compose.material3.rememberDateRangePickerState (DateRangePicker.kt:261)");
        }
        int i15 = 0;
        final Locale defaultLocale = CalendarLocale_androidKt.defaultLocale(composer2, i15);
        int i23 = i15;
        ComposerKt.sourceInformationMarkerStart(composer2, -250595241, "CC(remember):DateRangePicker.kt#9igjgp");
        int i35 = 4;
        empty = 1;
        if (i27 ^= 6 > i35) {
            if (!composer2.changed(i7)) {
                i5 = i41 & 6 == i35 ? empty : i23;
            } else {
            }
        } else {
        }
        if (i36 ^= 48 > i16) {
            if (!composer2.changed(i)) {
                i6 = i41 & 48 == i16 ? empty : i23;
            } else {
            }
        } else {
        }
        int i37 = 256;
        if (i28 ^= 384 > i37) {
            if (!composer2.changed(i10)) {
                i3 = i41 & 384 == i37 ? empty : i23;
            } else {
            }
        } else {
        }
        int i38 = 16384;
        if (i30 ^= 24576 > i38) {
            if (!composer2.changed(i12)) {
                i8 = i41 & 24576 == i38 ? empty : i23;
            } else {
            }
        } else {
        }
        int i39 = 196608;
        int i24 = 131072;
        if (i32 ^= i39 > i24) {
            if (!composer2.changed(date)) {
                if (i41 & i39 == i24) {
                } else {
                    empty = 0;
                }
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        int i33 = 0;
        Object rememberedValue = composer.rememberedValue();
        final int i42 = 0;
        if (i21 |= changedInstance == null) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                i13 = 0;
                anon = new DateRangePickerKt.rememberDateRangePickerState.1.1(i7, i, i10, intRange, i12, date, defaultLocale);
                composer.updateRememberedValue((Function0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (DateRangePickerState)(DateRangePickerStateImpl)RememberSaveableKt.rememberSaveable(new Object[i23], DateRangePickerStateImpl.Companion.Saver(date, defaultLocale), 0, (Function0)anon, composer2, 0, 4);
    }

    private static final void updateDateSelection(long dateInMillis, Long currentStartDateMillis, Long currentEndDateMillis, Function2<? super Long, ? super Long, Unit> onDatesSelectionChange) {
        Long valueOf2;
        int valueOf;
        valueOf2 = 0;
        if (currentEndDateMillis == null) {
            if (onDatesSelectionChange != null) {
                if (currentEndDateMillis != null && onDatesSelectionChange != null) {
                    if (onDatesSelectionChange != null) {
                        obj7.invoke(Long.valueOf(dateInMillis), valueOf2);
                    } else {
                        if (currentEndDateMillis != null && Long.compare(dateInMillis, longValue) >= 0) {
                            if (Long.compare(dateInMillis, longValue) >= 0) {
                                obj7.invoke(currentEndDateMillis, Long.valueOf(dateInMillis));
                            } else {
                                obj7.invoke(Long.valueOf(dateInMillis), valueOf2);
                            }
                        } else {
                        }
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }
}
