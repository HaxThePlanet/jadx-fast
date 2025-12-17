package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.snapping.LazyListSnapLayoutInfoProviderKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.material3.tokens.DatePickerModalTokens;
import androidx.compose.material3.tokens.DividerTokens;
import androidx.compose.material3.tokens.ElevationTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0018\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0003\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J6\u0010\u001d\u001a\u00020\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\u0008'\u0010(J$\u0010)\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\"2\u0008\u0008\u0002\u0010%\u001a\u00020&H\u0007ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+J\r\u0010,\u001a\u00020\u0019H\u0007¢\u0006\u0002\u0010-J\u008e\u0002\u0010,\u001a\u00020\u00192\u0008\u0008\u0002\u0010.\u001a\u00020/2\u0008\u0008\u0002\u00100\u001a\u00020/2\u0008\u0008\u0002\u00101\u001a\u00020/2\u0008\u0008\u0002\u00102\u001a\u00020/2\u0008\u0008\u0002\u00103\u001a\u00020/2\u0008\u0008\u0002\u00104\u001a\u00020/2\u0008\u0008\u0002\u00105\u001a\u00020/2\u0008\u0008\u0002\u00106\u001a\u00020/2\u0008\u0008\u0002\u00107\u001a\u00020/2\u0008\u0008\u0002\u00108\u001a\u00020/2\u0008\u0008\u0002\u00109\u001a\u00020/2\u0008\u0008\u0002\u0010:\u001a\u00020/2\u0008\u0008\u0002\u0010;\u001a\u00020/2\u0008\u0008\u0002\u0010<\u001a\u00020/2\u0008\u0008\u0002\u0010=\u001a\u00020/2\u0008\u0008\u0002\u0010>\u001a\u00020/2\u0008\u0008\u0002\u0010?\u001a\u00020/2\u0008\u0008\u0002\u0010@\u001a\u00020/2\u0008\u0008\u0002\u0010A\u001a\u00020/2\u0008\u0008\u0002\u0010B\u001a\u00020/2\u0008\u0008\u0002\u0010C\u001a\u00020/2\u0008\u0008\u0002\u0010D\u001a\u00020/2\u0008\u0008\u0002\u0010E\u001a\u00020/2\u0008\u0008\u0002\u0010F\u001a\u00020/2\n\u0008\u0002\u0010G\u001a\u0004\u0018\u00010HH\u0007ø\u0001\u0000¢\u0006\u0004\u0008I\u0010JJ$\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010K\u001a\u00020\r2\u0008\u0008\u0002\u0010L\u001a\u00020\r2\u0008\u0008\u0002\u0010M\u001a\u00020\rJ'\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u000e\u0008\u0002\u0010R\u001a\u0008\u0012\u0004\u0012\u00020T0SH\u0001¢\u0006\u0004\u0008U\u0010VR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u0008ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\u0008\t\u0010\nR\u000e\u0010\u000c\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158G¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8AX\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u001c\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006W", d2 = {"Landroidx/compose/material3/DatePickerDefaults;", "", "()V", "AllDates", "Landroidx/compose/material3/SelectableDates;", "getAllDates", "()Landroidx/compose/material3/SelectableDates;", "TonalElevation", "Landroidx/compose/ui/unit/Dp;", "getTonalElevation-D9Ej5fM", "()F", "F", "YearAbbrMonthDaySkeleton", "", "YearMonthSkeleton", "YearMonthWeekdayDaySkeleton", "YearRange", "Lkotlin/ranges/IntRange;", "getYearRange", "()Lkotlin/ranges/IntRange;", "shape", "Landroidx/compose/ui/graphics/Shape;", "getShape", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/Shape;", "defaultDatePickerColors", "Landroidx/compose/material3/DatePickerColors;", "Landroidx/compose/material3/ColorScheme;", "getDefaultDatePickerColors", "(Landroidx/compose/material3/ColorScheme;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "DatePickerHeadline", "", "selectedDateMillis", "", "displayMode", "Landroidx/compose/material3/DisplayMode;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "modifier", "Landroidx/compose/ui/Modifier;", "DatePickerHeadline-3kbWawI", "(Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DatePickerTitle", "DatePickerTitle-hOD91z4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "colors", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DatePickerColors;", "containerColor", "Landroidx/compose/ui/graphics/Color;", "titleContentColor", "headlineContentColor", "weekdayContentColor", "subheadContentColor", "navigationContentColor", "yearContentColor", "disabledYearContentColor", "currentYearContentColor", "selectedYearContentColor", "disabledSelectedYearContentColor", "selectedYearContainerColor", "disabledSelectedYearContainerColor", "dayContentColor", "disabledDayContentColor", "selectedDayContentColor", "disabledSelectedDayContentColor", "selectedDayContainerColor", "disabledSelectedDayContainerColor", "todayContentColor", "todayDateBorderColor", "dayInSelectionRangeContentColor", "dayInSelectionRangeContainerColor", "dividerColor", "dateTextFieldColors", "Landroidx/compose/material3/TextFieldColors;", "colors-bSRYm20", "(JJJJJJJJJJJJJJJJJJJJJJJJLandroidx/compose/material3/TextFieldColors;Landroidx/compose/runtime/Composer;IIII)Landroidx/compose/material3/DatePickerColors;", "yearSelectionSkeleton", "selectedDateSkeleton", "selectedDateDescriptionSkeleton", "rememberSnapFlingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "decayAnimationSpec", "Landroidx/compose/animation/core/DecayAnimationSpec;", "", "rememberSnapFlingBehavior$material3_release", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/animation/core/DecayAnimationSpec;Landroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/gestures/FlingBehavior;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DatePickerDefaults {

    public static final int $stable = 0;
    private static final androidx.compose.material3.SelectableDates AllDates = null;
    public static final androidx.compose.material3.DatePickerDefaults INSTANCE = null;
    private static final float TonalElevation = 0f;
    public static final String YearAbbrMonthDaySkeleton = "yMMMd";
    public static final String YearMonthSkeleton = "yMMMM";
    public static final String YearMonthWeekdayDaySkeleton = "yMMMMEEEEd";
    private static final IntRange YearRange;
    static {
        DatePickerDefaults datePickerDefaults = new DatePickerDefaults();
        DatePickerDefaults.INSTANCE = datePickerDefaults;
        IntRange intRange = new IntRange(1900, 2100);
        DatePickerDefaults.YearRange = intRange;
        DatePickerDefaults.TonalElevation = ElevationTokens.INSTANCE.getLevel0-D9Ej5fM();
        DatePickerDefaults.AllDates.1 anon = new DatePickerDefaults.AllDates.1();
        DatePickerDefaults.AllDates = (SelectableDates)anon;
    }

    public static androidx.compose.material3.DatePickerFormatter dateFormatter$default(androidx.compose.material3.DatePickerDefaults datePickerDefaults, String string2, String string3, String string4, int i5, Object object6) {
        String obj1;
        String obj2;
        String obj3;
        if (i5 & 1 != 0) {
            obj1 = "yMMMM";
        }
        if (i5 & 2 != 0) {
            obj2 = "yMMMd";
        }
        if (i5 &= 4 != 0) {
            obj3 = "yMMMMEEEEd";
        }
        return datePickerDefaults.dateFormatter(obj1, obj2, obj3);
    }

    public final void DatePickerHeadline-3kbWawI(Long selectedDateMillis, int displayMode, androidx.compose.material3.DatePickerFormatter dateFormatter, Modifier modifier, Composer $composer, int $changed, int i7) {
        Object anon2;
        Object anon;
        Object obj;
        java.util.Locale defaultLocale;
        int $dirty2;
        int $dirty;
        boolean traceInProgress2;
        int i2;
        int i9;
        int i;
        int str;
        boolean changedInstance;
        Object verboseDateDescription;
        String string-2EP1pXo3;
        int i4;
        int i8;
        Object $composer2;
        int i10;
        boolean traceInProgress;
        Object companion;
        int modifier2;
        Object empty;
        int i6;
        String string-2EP1pXo;
        int headlineDescription6;
        int string-2EP1pXo2;
        int headlineDescription13;
        int i3;
        int headlineDescription10;
        int headlineDescription4;
        int headlineDescription5;
        Composer.Companion companion2;
        int headlineDescription2;
        int headlineDescription7;
        int headlineDescription3;
        int headlineDescription8;
        int headlineDescription9;
        int headlineDescription16;
        int headlineDescription12;
        int headlineDescription11;
        int headlineDescription17;
        Composer composer;
        int headlineDescription18;
        int headlineDescription14;
        int headlineDescription;
        int headlineDescription15;
        int i5;
        obj = selectedDateMillis;
        i4 = displayMode;
        anon = dateFormatter;
        i8 = $changed;
        defaultLocale = 1502835813;
        $composer2 = $composer.startRestartGroup(defaultLocale);
        ComposerKt.sourceInformation($composer2, "C(DatePickerHeadline)P(3,1:c#material3.DisplayMode)651@31604L15,684@32955L135,681@32858L268:DatePicker.kt#uh7d8r");
        $dirty2 = $changed;
        if (i7 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i8 & 6 == 0) {
                i2 = $composer2.changed(obj) ? 4 : 2;
                $dirty2 |= i2;
            }
        }
        if (i7 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i8 & 48 == 0) {
                i9 = $composer2.changed(i4) ? 32 : 16;
                $dirty2 |= i9;
            }
        }
        if (i7 & 4 != 0) {
            $dirty2 |= 384;
        } else {
            if (i8 & 384 == 0) {
                if (i8 & 512 == 0) {
                    changedInstance = $composer2.changed(anon);
                } else {
                    changedInstance = $composer2.changedInstance(anon);
                }
                i = changedInstance != null ? 256 : 128;
                $dirty2 |= i;
            }
        }
        str = i7 & 8;
        if (str != null) {
            $dirty2 |= 3072;
            verboseDateDescription = modifier;
        } else {
            if (i8 & 3072 == 0) {
                i10 = $composer2.changed(modifier) ? 2048 : 1024;
                $dirty2 |= i10;
            } else {
                verboseDateDescription = modifier;
            }
        }
        traceInProgress = $dirty2;
        if (traceInProgress & 1171 == 1170) {
            if (!$composer2.getSkipping()) {
                if (str != null) {
                    companion = $dirty;
                } else {
                    companion = verboseDateDescription;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(defaultLocale, traceInProgress, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:650)");
                }
                empty = 0;
                defaultLocale = CalendarLocale_androidKt.defaultLocale($composer2, empty);
                $dirty = DatePickerFormatter.formatDate$default(anon, obj, defaultLocale, false, 4, 0);
                int i13 = 1;
                $composer2.startReplaceGroup(1148829161);
                string-2EP1pXo = "";
                ComposerKt.sourceInformation($composer2, string-2EP1pXo);
                if (anon.formatDate(obj, defaultLocale, i13) == null) {
                    if (DisplayMode.equals-impl0(i4, DisplayMode.Companion.getPicker-jFl-4v0())) {
                        $composer2.startReplaceGroup(1148836960);
                        ComposerKt.sourceInformation($composer2, "661@32047L51");
                        androidx.compose.material3.internal.Strings.Companion companion6 = Strings.Companion;
                        string-2EP1pXo2 = 0;
                        string-2EP1pXo3 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_picker_no_selection_description), $composer2, empty);
                        $composer2.endReplaceGroup();
                    } else {
                        if (DisplayMode.equals-impl0(i4, DisplayMode.Companion.getInput-jFl-4v0())) {
                            $composer2.startReplaceGroup(1148839931);
                            ComposerKt.sourceInformation($composer2, "662@32140L46");
                            androidx.compose.material3.internal.Strings.Companion companion5 = Strings.Companion;
                            string-2EP1pXo2 = 0;
                            string-2EP1pXo3 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_no_input_description), $composer2, empty);
                            $composer2.endReplaceGroup();
                        } else {
                            $composer2.startReplaceGroup(1254372529);
                            $composer2.endReplaceGroup();
                            string-2EP1pXo3 = string-2EP1pXo;
                        }
                    }
                }
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(1148844497);
                ComposerKt.sourceInformation($composer2, string-2EP1pXo);
                if ($dirty == null) {
                    if (DisplayMode.equals-impl0(i4, DisplayMode.Companion.getPicker-jFl-4v0())) {
                        $composer2.startReplaceGroup(1148847346);
                        ComposerKt.sourceInformation($composer2, "669@32372L37");
                        androidx.compose.material3.internal.Strings.Companion companion12 = Strings.Companion;
                        headlineDescription13 = 0;
                        string-2EP1pXo2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_picker_headline), $composer2, empty);
                        $composer2.endReplaceGroup();
                    } else {
                        if (DisplayMode.equals-impl0(i4, DisplayMode.Companion.getInput-jFl-4v0())) {
                            $composer2.startReplaceGroup(1148849873);
                            ComposerKt.sourceInformation($composer2, "670@32451L36");
                            androidx.compose.material3.internal.Strings.Companion companion11 = Strings.Companion;
                            headlineDescription13 = 0;
                            string-2EP1pXo2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_headline), $composer2, empty);
                            $composer2.endReplaceGroup();
                        } else {
                            $composer2.startReplaceGroup(1254671121);
                            $composer2.endReplaceGroup();
                            string-2EP1pXo2 = string-2EP1pXo;
                        }
                    }
                } else {
                    string-2EP1pXo2 = $dirty;
                }
                $composer2.endReplaceGroup();
                if (DisplayMode.equals-impl0(i4, DisplayMode.Companion.getPicker-jFl-4v0())) {
                    $composer2.startReplaceGroup(1148856029);
                    ComposerKt.sourceInformation($composer2, "676@32643L48");
                    androidx.compose.material3.internal.Strings.Companion companion8 = Strings.Companion;
                    i3 = 0;
                    string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_picker_headline_description), $composer2, empty);
                    $composer2.endReplaceGroup();
                } else {
                    if (DisplayMode.equals-impl0(i4, DisplayMode.Companion.getInput-jFl-4v0())) {
                        $composer2.startReplaceGroup(1148858780);
                        ComposerKt.sourceInformation($composer2, "677@32729L47");
                        androidx.compose.material3.internal.Strings.Companion companion7 = Strings.Companion;
                        i3 = 0;
                        string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_headline_description), $composer2, empty);
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(1254953841);
                        $composer2.endReplaceGroup();
                    }
                }
                String format = String.format(string-2EP1pXo, Arrays.copyOf(/* result */, i13));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                ComposerKt.sourceInformationMarkerStart($composer2, 1148866100, "CC(remember):DatePicker.kt#9igjgp");
                Composer composer2 = $composer2;
                int i30 = 0;
                Object rememberedValue = composer2.rememberedValue();
                int i31 = 0;
                if (!$composer2.changed(format)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon2 = new DatePickerDefaults.DatePickerHeadline.1.1(format);
                        composer2.updateRememberedValue((Function1)anon2);
                    } else {
                        anon2 = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                i6 = 0;
                anon = str27;
                headlineDescription15 = i5;
                TextKt.Text--4IGK_g(string-2EP1pXo2, SemanticsModifierKt.semantics$default(companion, i6, (Function1)anon2, 1, 0), 0, i6, 0, string-2EP1pXo2, 0, 0, 0, 0, companion2, 0, false, 0, obj22, 0, 0, 1, 0, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                verboseDateDescription = str;
            } else {
                $composer2.skipToGroupEnd();
                composer = $composer2;
                headlineDescription15 = traceInProgress;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new DatePickerDefaults.DatePickerHeadline.2(this, obj, i4, dateFormatter, verboseDateDescription, i8, i7);
            endRestartGroup.updateScope((Function2)anon);
        }
    }

    public final void DatePickerTitle-hOD91z4(int displayMode, Modifier modifier, Composer $composer, int $changed, int i5) {
        int traceInProgress2;
        Composer $composer3;
        Composer this_$iv;
        int $dirty2;
        Object $dirty;
        int i6;
        int modifier2;
        Object obj;
        boolean traceInProgress;
        int i21;
        Composer $composer2;
        int skipping;
        int i3;
        int i4;
        int i16;
        int i;
        int i2;
        int i10;
        int i19;
        int i8;
        int i11;
        int i13;
        int i12;
        int i7;
        int i20;
        int i17;
        Composer composer;
        int i18;
        int i14;
        int i9;
        int i15;
        final int i24 = displayMode;
        traceInProgress2 = 327413563;
        this_$iv = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(this_$iv, "C(DatePickerTitle)P(0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
        $dirty2 = $changed;
        if (i5 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if ($changed & 6 == 0) {
                i6 = this_$iv.changed(i24) ? 4 : 2;
                $dirty2 |= i6;
            }
        }
        modifier2 = i5 & 2;
        if (modifier2 != 0) {
            $dirty2 |= 48;
            obj = modifier;
        } else {
            if ($changed & 48 == 0) {
                i21 = this_$iv.changed(modifier) ? 32 : 16;
                $dirty2 |= i21;
            } else {
                obj = modifier;
            }
        }
        if ($dirty2 & 19 == 18) {
            if (!this_$iv.getSkipping()) {
                if (modifier2 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty2, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerTitle (DatePicker.kt:625)");
                }
                obj = 0;
                if (DisplayMode.equals-impl0(i24, DisplayMode.Companion.getPicker-jFl-4v0())) {
                    this_$iv.startReplaceGroup(406433164);
                    ComposerKt.sourceInformation(this_$iv, "628@30634L43,628@30622L77");
                    androidx.compose.material3.internal.Strings.Companion companion2 = Strings.Companion;
                    composer = this_$iv;
                    i15 = $dirty2;
                    TextKt.Text--4IGK_g(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_picker_title), this_$iv, obj), modifier2, 0, 0, 0, obj8, 0, 0, 0, 0, obj13, 0, false, 0, obj17, 0, 0, 0, 0, 0, 0);
                    $composer3 = composer;
                    $composer3.endReplaceGroup();
                    $composer2 = $composer3;
                } else {
                    $composer3 = this_$iv;
                    if (DisplayMode.equals-impl0(i24, DisplayMode.Companion.getInput-jFl-4v0())) {
                        $composer3.startReplaceGroup(406437227);
                        ComposerKt.sourceInformation($composer3, "630@30761L42,630@30749L76");
                        androidx.compose.material3.internal.Strings.Companion companion3 = Strings.Companion;
                        int i25 = 0;
                        int m3c_date_input_title = R.string.m3c_date_input_title;
                        composer = $composer3;
                        TextKt.Text--4IGK_g(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(m3c_date_input_title), $composer3, obj), modifier2, 0, m3c_date_input_title, 0, obj8, 0, 0, 0, 0, obj13, 0, false, 0, obj17, 0, 0, 0, 0, 0, 0);
                        composer.endReplaceGroup();
                    } else {
                        $composer2 = $composer3;
                        $composer2.startReplaceGroup(-285264893);
                        $composer2.endReplaceGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = modifier2;
            } else {
                this_$iv.skipToGroupEnd();
                $composer2 = this_$iv;
                i15 = $dirty2;
                $dirty = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new DatePickerDefaults.DatePickerTitle.1(this, i24, $dirty, $changed, i5);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public final androidx.compose.material3.DatePickerColors colors(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = -275219611;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(colors)428@18618L11,428@18630L23:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:428)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme($composer, 6), $composer, i3 &= 112);
    }

    public final androidx.compose.material3.DatePickerColors colors-bSRYm20(long containerColor, long titleContentColor, long headlineContentColor, long weekdayContentColor, long subheadContentColor, long navigationContentColor, long yearContentColor, long disabledYearContentColor, long currentYearContentColor, long selectedYearContentColor, long disabledSelectedYearContentColor, long selectedYearContainerColor, long disabledSelectedYearContainerColor, long dayContentColor, long disabledDayContentColor, long selectedDayContentColor, long disabledSelectedDayContentColor, long selectedDayContainerColor, long disabledSelectedDayContainerColor, long todayContentColor, long todayDateBorderColor, long dayInSelectionRangeContentColor, long dayInSelectionRangeContainerColor, long dividerColor, androidx.compose.material3.TextFieldColors dateTextFieldColors, Composer $composer, int $changed, int $changed1, int $changed2, int i30) {
        int i;
        boolean traceInProgress;
        int unspecified-0d7_KjU12;
        int unspecified-0d7_KjU19;
        int unspecified-0d7_KjU2;
        int unspecified-0d7_KjU16;
        int unspecified-0d7_KjU13;
        int unspecified-0d7_KjU18;
        int unspecified-0d7_KjU24;
        int unspecified-0d7_KjU3;
        long unspecified-0d7_KjU8;
        int unspecified-0d7_KjU15;
        long unspecified-0d7_KjU4;
        int unspecified-0d7_KjU10;
        long unspecified-0d7_KjU22;
        int unspecified-0d7_KjU;
        int unspecified-0d7_KjU20;
        int unspecified-0d7_KjU14;
        int unspecified-0d7_KjU11;
        int unspecified-0d7_KjU21;
        int unspecified-0d7_KjU23;
        int unspecified-0d7_KjU17;
        int unspecified-0d7_KjU5;
        int unspecified-0d7_KjU9;
        int unspecified-0d7_KjU6;
        int unspecified-0d7_KjU7;
        int i2;
        int i3;
        long l4;
        long l24;
        long l5;
        long l14;
        long l15;
        long l6;
        long l7;
        long l22;
        long l19;
        long l12;
        long l23;
        long l;
        long l8;
        long l9;
        long l11;
        long l13;
        long l21;
        long l2;
        long l16;
        long l18;
        long l17;
        long l10;
        long l3;
        long l20;
        int i4;
        final Composer composer = obj105;
        int i5 = obj109;
        int i6 = 1991626358;
        ComposerKt.sourceInformationMarkerStart(composer, i6, "C(colors)P(0:c#ui.graphics.Color,20:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,19:c#ui.graphics.Color,14:c#ui.graphics.Color,24:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,18:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,9:c#ui.graphics.Color,3:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,21:c#ui.graphics.Color,22:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color)497@22914L11,497@22926L23:DatePicker.kt#uh7d8r");
        if (i5 & 1 != 0) {
            l4 = unspecified-0d7_KjU12;
        } else {
            l4 = containerColor;
        }
        if (i5 & 2 != 0) {
            l24 = unspecified-0d7_KjU19;
        } else {
            l24 = headlineContentColor;
        }
        if (i5 & 4 != 0) {
            l5 = unspecified-0d7_KjU2;
        } else {
            l5 = subheadContentColor;
        }
        if (i5 & 8 != 0) {
            l14 = unspecified-0d7_KjU16;
        } else {
            l14 = yearContentColor;
        }
        if (i5 & 16 != 0) {
            l15 = unspecified-0d7_KjU13;
        } else {
            l15 = currentYearContentColor;
        }
        if (i5 & 32 != 0) {
            l6 = unspecified-0d7_KjU18;
        } else {
            l6 = disabledSelectedYearContentColor;
        }
        if (i5 & 64 != 0) {
            l7 = unspecified-0d7_KjU24;
        } else {
            l7 = disabledSelectedYearContainerColor;
        }
        if (i5 & 128 != 0) {
            l22 = unspecified-0d7_KjU3;
        } else {
            l22 = disabledDayContentColor;
        }
        if (i5 & 256 != 0) {
            l19 = unspecified-0d7_KjU8;
        } else {
            l19 = disabledSelectedDayContentColor;
        }
        if (i5 & 512 != 0) {
            l12 = unspecified-0d7_KjU15;
        } else {
            l12 = disabledSelectedDayContainerColor;
        }
        if (i5 & 1024 != 0) {
            l23 = unspecified-0d7_KjU4;
        } else {
            l23 = todayDateBorderColor;
        }
        if (i5 & 2048 != 0) {
            l = unspecified-0d7_KjU10;
        } else {
            l = dayInSelectionRangeContainerColor;
        }
        if (i5 & 4096 != 0) {
            l8 = unspecified-0d7_KjU22;
        } else {
            l8 = dateTextFieldColors;
        }
        if (i5 & 8192 != 0) {
            l9 = unspecified-0d7_KjU;
        } else {
            l9 = $changed;
        }
        if (i5 & 16384 != 0) {
            l11 = unspecified-0d7_KjU20;
        } else {
            l11 = $changed2;
        }
        if (i10 &= i5 != 0) {
            l13 = unspecified-0d7_KjU14;
        } else {
            l13 = obj86;
        }
        if (i11 &= i5 != 0) {
            l21 = unspecified-0d7_KjU11;
        } else {
            l21 = obj88;
        }
        if (i12 &= i5 != 0) {
            l2 = unspecified-0d7_KjU21;
        } else {
            l2 = obj90;
        }
        if (i13 &= i5 != 0) {
            l16 = unspecified-0d7_KjU23;
        } else {
            l16 = obj92;
        }
        if (i14 &= i5 != 0) {
            l18 = unspecified-0d7_KjU17;
        } else {
            l18 = obj94;
        }
        if (i15 &= i5 != 0) {
            l17 = unspecified-0d7_KjU5;
        } else {
            l17 = obj96;
        }
        if (i16 &= i5 != 0) {
            l3 = unspecified-0d7_KjU9;
        } else {
            l3 = obj98;
        }
        if (i17 &= i5 != 0) {
            l10 = unspecified-0d7_KjU6;
        } else {
            l10 = obj100;
        }
        if (i18 &= i5 != 0) {
            l20 = unspecified-0d7_KjU7;
        } else {
            l20 = obj102;
        }
        i4 = i5 &= i19 != 0 ? i : obj104;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i6, obj106, obj107, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:497)");
        } else {
            i2 = obj106;
            i3 = obj107;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, i8 &= 112).copy-tNwlRmA(l4, obj7, l24, obj9, l5, obj11, l14, obj13, l15, obj15, l6, obj17, l7, obj19, l22, obj21, l19, obj23, l12, obj25, l23, obj27, l, obj29, l8);
    }

    public final androidx.compose.material3.DatePickerFormatter dateFormatter(String yearSelectionSkeleton, String selectedDateSkeleton, String selectedDateDescriptionSkeleton) {
        DatePickerFormatterImpl datePickerFormatterImpl = new DatePickerFormatterImpl(yearSelectionSkeleton, selectedDateSkeleton, selectedDateDescriptionSkeleton);
        return (DatePickerFormatter)datePickerFormatterImpl;
    }

    public final androidx.compose.material3.SelectableDates getAllDates() {
        return DatePickerDefaults.AllDates;
    }

    public final androidx.compose.material3.DatePickerColors getDefaultDatePickerColors(androidx.compose.material3.ColorScheme $this$defaultDatePickerColors, Composer $composer, int $changed) {
        androidx.compose.material3.DatePickerColors defaultDatePickerColorsCached$material3_release;
        boolean traceInProgress;
        Object datePickerColors;
        String str;
        long token10;
        long token9;
        long token7;
        long token13;
        long onSurfaceVariant-0d7_KjU;
        long token6;
        long copy-wmQWz5c$default2;
        long token8;
        int i15;
        long token3;
        int i12;
        long copy-wmQWz5c$default5;
        int i3;
        long token5;
        int i;
        long copy-wmQWz5c$default3;
        int i10;
        long token;
        int i4;
        long copy-wmQWz5c$default6;
        int i6;
        long token4;
        int i8;
        long copy-wmQWz5c$default4;
        int i2;
        long token14;
        int i5;
        long copy-wmQWz5c$default;
        int i11;
        long token15;
        int i13;
        long token2;
        int i7;
        long token12;
        int i14;
        long token11;
        long token16;
        androidx.compose.material3.TextFieldColors defaultOutlinedTextFieldColors;
        int i9;
        final androidx.compose.material3.ColorScheme colorScheme = $this$defaultDatePickerColors;
        final Composer composer = $composer;
        final int i16 = $changed;
        int i17 = 1180555308;
        ComposerKt.sourceInformationMarkerStart(composer, i17, "C:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i17, i16, -1, "androidx.compose.material3.DatePickerDefaults.<get-defaultDatePickerColors> (DatePicker.kt:527)");
        }
        composer.startReplaceGroup(-653687021);
        ComposerKt.sourceInformation(composer, "*585@28652L30");
        if (colorScheme.getDefaultDatePickerColorsCached$material3_release() == null) {
            i3 = 0;
            i15 = 0;
            i12 = 0;
            i = 0;
            i10 = 0;
            i4 = 0;
            i6 = 0;
            i8 = 0;
            i2 = 0;
            i5 = 0;
            i11 = 0;
            i14 = 0;
            i13 = 0;
            i7 = 0;
            datePickerColors = new DatePickerColors(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getContainerColor()), obj6, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getHeaderSupportingTextColor()), obj8, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getHeaderHeadlineColor()), obj10, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextColor()), obj12, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadColor()), obj14, colorScheme.getOnSurfaceVariant-0d7_KjU(), obj16, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), obj18, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), obj20, 1052938076, i15, 0, i12, 14), obj20, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), i15, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), i12, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), i3, 1052938076, i, 0, i10, 14), i3, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), i, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), i10, 1052938076, i4, 0, i6, 14), i10, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), i4, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), i6, 1052938076, i8, 0, i2, 14), i6, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), i8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), i2, 1052938076, i5, 0, i11, 14), i2, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), i5, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), i11, 1052938076, i13, 0, i7, 14), i11, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), i13, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineColor()), i7, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getRangeSelectionActiveIndicatorContainerColor()), i14, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionDateInRangeLabelTextColor()), obj50, ColorSchemeKt.fromToken(colorScheme, DividerTokens.INSTANCE.getColor()), obj52, OutlinedTextFieldDefaults.INSTANCE.getDefaultOutlinedTextFieldColors(colorScheme, composer, i19 |= 48), 0);
            str = 0;
            colorScheme.setDefaultDatePickerColorsCached$material3_release(datePickerColors);
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return defaultDatePickerColorsCached$material3_release;
    }

    public final Shape getShape(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 700927667;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C730@34663L5:DatePicker.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.DatePickerDefaults.<get-shape> (DatePicker.kt:730)");
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return ShapesKt.getValue(DatePickerModalTokens.INSTANCE.getContainerShape(), $composer, 6);
    }

    public final float getTonalElevation-D9Ej5fM() {
        return DatePickerDefaults.TonalElevation;
    }

    public final IntRange getYearRange() {
        return DatePickerDefaults.YearRange;
    }

    public final FlingBehavior rememberSnapFlingBehavior$material3_release(LazyListState lazyListState, DecayAnimationSpec<Float> decayAnimationSpec, Composer $composer, int $changed, int i5) {
        Object snapFlingBehavior;
        int i2;
        DecayAnimationSpec decayAnimationSpec2;
        boolean traceInProgress;
        int changed;
        int i3;
        String str;
        Object empty;
        androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior.1.snapLayoutInfoProvider.1 anon;
        androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior.1.snapLayoutInfoProvider.1 date;
        int i;
        Object obj = lazyListState;
        final Composer composer = $composer;
        final int i6 = $changed;
        int i7 = -2036003494;
        ComposerKt.sourceInformationMarkerStart(composer, i7, "C(rememberSnapFlingBehavior)P(1)704@33614L669:DatePicker.kt#uh7d8r");
        final int i12 = 0;
        final int i13 = 0;
        if (i5 & 2 != 0) {
            decayAnimationSpec2 = DecayAnimationSpecKt.exponentialDecay$default(i12, i12, 3, i13);
        } else {
            decayAnimationSpec2 = decayAnimationSpec;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i7, i6, -1, "androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior (DatePicker.kt:703)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 2078670519, "CC(remember):DatePicker.kt#9igjgp");
        int i15 = 4;
        if (i14 ^= 6 > i15) {
            if (!composer.changed(obj)) {
                i3 = i6 & 6 == i15 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer2 = $composer;
        int i16 = 0;
        final Object rememberedValue = composer2.rememberedValue();
        final int i17 = 0;
        if (changed2 |= i3 == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                anon = new DatePickerDefaults.rememberSnapFlingBehavior.1.snapLayoutInfoProvider.1(LazyListSnapLayoutInfoProviderKt.SnapLayoutInfoProvider$default(obj, i13, 2, i13));
                composer2.updateRememberedValue(SnapFlingBehaviorKt.snapFlingBehavior((SnapLayoutInfoProvider)anon, decayAnimationSpec2, (AnimationSpec)AnimationSpecKt.spring$default(i12, 1137180672, i13, 5, i13)));
            } else {
                snapFlingBehavior = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (FlingBehavior)(TargetedFlingBehavior)snapFlingBehavior;
    }
}
