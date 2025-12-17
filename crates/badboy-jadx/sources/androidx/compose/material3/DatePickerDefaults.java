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
        Object anon;
        Object anon2;
        Object obj;
        java.util.Locale defaultLocale;
        int $dirty;
        int $dirty2;
        boolean traceInProgress2;
        int i6;
        int i3;
        int i2;
        int str;
        boolean changedInstance;
        Object verboseDateDescription;
        String string-2EP1pXo;
        int i5;
        int i;
        Object $composer2;
        int i9;
        boolean traceInProgress;
        Object companion2;
        int modifier2;
        Object empty;
        int i8;
        String string-2EP1pXo2;
        int headlineDescription;
        int string-2EP1pXo3;
        int headlineDescription2;
        int i10;
        int headlineDescription3;
        int headlineDescription4;
        int headlineDescription7;
        Composer.Companion companion;
        int headlineDescription15;
        int headlineDescription11;
        int headlineDescription10;
        int headlineDescription16;
        int headlineDescription17;
        int headlineDescription12;
        int headlineDescription9;
        int headlineDescription13;
        int headlineDescription14;
        Composer composer;
        int headlineDescription5;
        int headlineDescription8;
        int headlineDescription18;
        int headlineDescription6;
        int i4;
        obj = selectedDateMillis;
        i5 = displayMode;
        anon2 = dateFormatter;
        i = $changed;
        defaultLocale = 1502835813;
        $composer2 = $composer.startRestartGroup(defaultLocale);
        ComposerKt.sourceInformation($composer2, "C(DatePickerHeadline)P(3,1:c#material3.DisplayMode)651@31604L15,684@32955L135,681@32858L268:DatePicker.kt#uh7d8r");
        $dirty = $changed;
        if (i7 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i & 6 == 0) {
                i6 = $composer2.changed(obj) ? 4 : 2;
                $dirty |= i6;
            }
        }
        if (i7 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i & 48 == 0) {
                i3 = $composer2.changed(i5) ? 32 : 16;
                $dirty |= i3;
            }
        }
        if (i7 & 4 != 0) {
            $dirty |= 384;
        } else {
            if (i & 384 == 0) {
                if (i & 512 == 0) {
                    changedInstance = $composer2.changed(anon2);
                } else {
                    changedInstance = $composer2.changedInstance(anon2);
                }
                i2 = changedInstance != null ? 256 : 128;
                $dirty |= i2;
            }
        }
        str = i7 & 8;
        if (str != null) {
            $dirty |= 3072;
            verboseDateDescription = modifier;
        } else {
            if (i & 3072 == 0) {
                i9 = $composer2.changed(modifier) ? 2048 : 1024;
                $dirty |= i9;
            } else {
                verboseDateDescription = modifier;
            }
        }
        traceInProgress = $dirty;
        if (traceInProgress & 1171 == 1170) {
            if (!$composer2.getSkipping()) {
                if (str != null) {
                    companion2 = $dirty2;
                } else {
                    companion2 = verboseDateDescription;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(defaultLocale, traceInProgress, -1, "androidx.compose.material3.DatePickerDefaults.DatePickerHeadline (DatePicker.kt:650)");
                }
                empty = 0;
                defaultLocale = CalendarLocale_androidKt.defaultLocale($composer2, empty);
                $dirty2 = DatePickerFormatter.formatDate$default(anon2, obj, defaultLocale, false, 4, 0);
                int i13 = 1;
                $composer2.startReplaceGroup(1148829161);
                string-2EP1pXo2 = "";
                ComposerKt.sourceInformation($composer2, string-2EP1pXo2);
                if (anon2.formatDate(obj, defaultLocale, i13) == null) {
                    if (DisplayMode.equals-impl0(i5, DisplayMode.Companion.getPicker-jFl-4v0())) {
                        $composer2.startReplaceGroup(1148836960);
                        ComposerKt.sourceInformation($composer2, "661@32047L51");
                        androidx.compose.material3.internal.Strings.Companion companion6 = Strings.Companion;
                        string-2EP1pXo3 = 0;
                        string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_picker_no_selection_description), $composer2, empty);
                        $composer2.endReplaceGroup();
                    } else {
                        if (DisplayMode.equals-impl0(i5, DisplayMode.Companion.getInput-jFl-4v0())) {
                            $composer2.startReplaceGroup(1148839931);
                            ComposerKt.sourceInformation($composer2, "662@32140L46");
                            androidx.compose.material3.internal.Strings.Companion companion5 = Strings.Companion;
                            string-2EP1pXo3 = 0;
                            string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_no_input_description), $composer2, empty);
                            $composer2.endReplaceGroup();
                        } else {
                            $composer2.startReplaceGroup(1254372529);
                            $composer2.endReplaceGroup();
                            string-2EP1pXo = string-2EP1pXo2;
                        }
                    }
                }
                $composer2.endReplaceGroup();
                $composer2.startReplaceGroup(1148844497);
                ComposerKt.sourceInformation($composer2, string-2EP1pXo2);
                if ($dirty2 == null) {
                    if (DisplayMode.equals-impl0(i5, DisplayMode.Companion.getPicker-jFl-4v0())) {
                        $composer2.startReplaceGroup(1148847346);
                        ComposerKt.sourceInformation($composer2, "669@32372L37");
                        androidx.compose.material3.internal.Strings.Companion companion12 = Strings.Companion;
                        headlineDescription2 = 0;
                        string-2EP1pXo3 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_picker_headline), $composer2, empty);
                        $composer2.endReplaceGroup();
                    } else {
                        if (DisplayMode.equals-impl0(i5, DisplayMode.Companion.getInput-jFl-4v0())) {
                            $composer2.startReplaceGroup(1148849873);
                            ComposerKt.sourceInformation($composer2, "670@32451L36");
                            androidx.compose.material3.internal.Strings.Companion companion11 = Strings.Companion;
                            headlineDescription2 = 0;
                            string-2EP1pXo3 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_headline), $composer2, empty);
                            $composer2.endReplaceGroup();
                        } else {
                            $composer2.startReplaceGroup(1254671121);
                            $composer2.endReplaceGroup();
                            string-2EP1pXo3 = string-2EP1pXo2;
                        }
                    }
                } else {
                    string-2EP1pXo3 = $dirty2;
                }
                $composer2.endReplaceGroup();
                if (DisplayMode.equals-impl0(i5, DisplayMode.Companion.getPicker-jFl-4v0())) {
                    $composer2.startReplaceGroup(1148856029);
                    ComposerKt.sourceInformation($composer2, "676@32643L48");
                    androidx.compose.material3.internal.Strings.Companion companion8 = Strings.Companion;
                    i10 = 0;
                    string-2EP1pXo2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_picker_headline_description), $composer2, empty);
                    $composer2.endReplaceGroup();
                } else {
                    if (DisplayMode.equals-impl0(i5, DisplayMode.Companion.getInput-jFl-4v0())) {
                        $composer2.startReplaceGroup(1148858780);
                        ComposerKt.sourceInformation($composer2, "677@32729L47");
                        androidx.compose.material3.internal.Strings.Companion companion7 = Strings.Companion;
                        i10 = 0;
                        string-2EP1pXo2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_headline_description), $composer2, empty);
                        $composer2.endReplaceGroup();
                    } else {
                        $composer2.startReplaceGroup(1254953841);
                        $composer2.endReplaceGroup();
                    }
                }
                String format = String.format(string-2EP1pXo2, Arrays.copyOf(/* result */, i13));
                Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                ComposerKt.sourceInformationMarkerStart($composer2, 1148866100, "CC(remember):DatePicker.kt#9igjgp");
                Composer composer2 = $composer2;
                int i30 = 0;
                Object rememberedValue = composer2.rememberedValue();
                int i31 = 0;
                if (!$composer2.changed(format)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new DatePickerDefaults.DatePickerHeadline.1.1(format);
                        composer2.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($composer2);
                i8 = 0;
                anon2 = str27;
                headlineDescription6 = i4;
                TextKt.Text--4IGK_g(string-2EP1pXo3, SemanticsModifierKt.semantics$default(companion2, i8, (Function1)anon, 1, 0), 0, i8, 0, string-2EP1pXo3, 0, 0, 0, 0, companion, 0, false, 0, obj22, 0, 0, 1, 0, 0, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                verboseDateDescription = str;
            } else {
                $composer2.skipToGroupEnd();
                composer = $composer2;
                headlineDescription6 = traceInProgress;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            anon2 = new DatePickerDefaults.DatePickerHeadline.2(this, obj, i5, dateFormatter, verboseDateDescription, i, i7);
            endRestartGroup.updateScope((Function2)anon2);
        }
    }

    public final void DatePickerTitle-hOD91z4(int displayMode, Modifier modifier, Composer $composer, int $changed, int i5) {
        int traceInProgress2;
        Composer $composer2;
        Composer this_$iv;
        int $dirty2;
        Object $dirty;
        int i8;
        int modifier2;
        Object obj;
        boolean traceInProgress;
        int i14;
        Composer $composer3;
        int skipping;
        int i10;
        int i19;
        int i21;
        int i11;
        int i4;
        int i18;
        int i;
        int i15;
        int i6;
        int i3;
        int i9;
        int i20;
        int i2;
        int i12;
        Composer composer;
        int i7;
        int i13;
        int i17;
        int i16;
        final int i24 = displayMode;
        traceInProgress2 = 327413563;
        this_$iv = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(this_$iv, "C(DatePickerTitle)P(0:c#material3.DisplayMode):DatePicker.kt#uh7d8r");
        $dirty2 = $changed;
        if (i5 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if ($changed & 6 == 0) {
                i8 = this_$iv.changed(i24) ? 4 : 2;
                $dirty2 |= i8;
            }
        }
        modifier2 = i5 & 2;
        if (modifier2 != 0) {
            $dirty2 |= 48;
            obj = modifier;
        } else {
            if ($changed & 48 == 0) {
                i14 = this_$iv.changed(modifier) ? 32 : 16;
                $dirty2 |= i14;
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
                    i16 = $dirty2;
                    TextKt.Text--4IGK_g(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_picker_title), this_$iv, obj), modifier2, 0, 0, 0, obj8, 0, 0, 0, 0, obj13, 0, false, 0, obj17, 0, 0, 0, 0, 0, 0);
                    $composer2 = composer;
                    $composer2.endReplaceGroup();
                    $composer3 = $composer2;
                } else {
                    $composer2 = this_$iv;
                    if (DisplayMode.equals-impl0(i24, DisplayMode.Companion.getInput-jFl-4v0())) {
                        $composer2.startReplaceGroup(406437227);
                        ComposerKt.sourceInformation($composer2, "630@30761L42,630@30749L76");
                        androidx.compose.material3.internal.Strings.Companion companion3 = Strings.Companion;
                        int i25 = 0;
                        int m3c_date_input_title = R.string.m3c_date_input_title;
                        composer = $composer2;
                        TextKt.Text--4IGK_g(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(m3c_date_input_title), $composer2, obj), modifier2, 0, m3c_date_input_title, 0, obj8, 0, 0, 0, 0, obj13, 0, false, 0, obj17, 0, 0, 0, 0, 0, 0);
                        composer.endReplaceGroup();
                    } else {
                        $composer3 = $composer2;
                        $composer3.startReplaceGroup(-285264893);
                        $composer3.endReplaceGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty = modifier2;
            } else {
                this_$iv.skipToGroupEnd();
                $composer3 = this_$iv;
                i16 = $dirty2;
                $dirty = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer3.endRestartGroup();
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
        int i4;
        boolean traceInProgress;
        int unspecified-0d7_KjU22;
        int unspecified-0d7_KjU8;
        int unspecified-0d7_KjU17;
        int unspecified-0d7_KjU23;
        int unspecified-0d7_KjU7;
        int unspecified-0d7_KjU12;
        int unspecified-0d7_KjU16;
        int unspecified-0d7_KjU3;
        long unspecified-0d7_KjU4;
        int unspecified-0d7_KjU15;
        long unspecified-0d7_KjU6;
        int unspecified-0d7_KjU14;
        long unspecified-0d7_KjU5;
        int unspecified-0d7_KjU18;
        int unspecified-0d7_KjU24;
        int unspecified-0d7_KjU;
        int unspecified-0d7_KjU20;
        int unspecified-0d7_KjU13;
        int unspecified-0d7_KjU11;
        int unspecified-0d7_KjU21;
        int unspecified-0d7_KjU9;
        int unspecified-0d7_KjU19;
        int unspecified-0d7_KjU2;
        int unspecified-0d7_KjU10;
        int i;
        int i2;
        long l19;
        long l12;
        long l16;
        long l17;
        long l24;
        long l20;
        long l;
        long l22;
        long l23;
        long l2;
        long l14;
        long l3;
        long l4;
        long l15;
        long l5;
        long l18;
        long l10;
        long l6;
        long l9;
        long l11;
        long l21;
        long l7;
        long l13;
        long l8;
        int i3;
        final Composer composer = obj105;
        int i5 = obj109;
        int i6 = 1991626358;
        ComposerKt.sourceInformationMarkerStart(composer, i6, "C(colors)P(0:c#ui.graphics.Color,20:c#ui.graphics.Color,13:c#ui.graphics.Color,23:c#ui.graphics.Color,19:c#ui.graphics.Color,14:c#ui.graphics.Color,24:c#ui.graphics.Color,11:c#ui.graphics.Color,1:c#ui.graphics.Color,18:c#ui.graphics.Color,10:c#ui.graphics.Color,17:c#ui.graphics.Color,9:c#ui.graphics.Color,3:c#ui.graphics.Color,6:c#ui.graphics.Color,16:c#ui.graphics.Color,8:c#ui.graphics.Color,15:c#ui.graphics.Color,7:c#ui.graphics.Color,21:c#ui.graphics.Color,22:c#ui.graphics.Color,5:c#ui.graphics.Color,4:c#ui.graphics.Color,12:c#ui.graphics.Color)497@22914L11,497@22926L23:DatePicker.kt#uh7d8r");
        if (i5 & 1 != 0) {
            l19 = unspecified-0d7_KjU22;
        } else {
            l19 = containerColor;
        }
        if (i5 & 2 != 0) {
            l12 = unspecified-0d7_KjU8;
        } else {
            l12 = headlineContentColor;
        }
        if (i5 & 4 != 0) {
            l16 = unspecified-0d7_KjU17;
        } else {
            l16 = subheadContentColor;
        }
        if (i5 & 8 != 0) {
            l17 = unspecified-0d7_KjU23;
        } else {
            l17 = yearContentColor;
        }
        if (i5 & 16 != 0) {
            l24 = unspecified-0d7_KjU7;
        } else {
            l24 = currentYearContentColor;
        }
        if (i5 & 32 != 0) {
            l20 = unspecified-0d7_KjU12;
        } else {
            l20 = disabledSelectedYearContentColor;
        }
        if (i5 & 64 != 0) {
            l = unspecified-0d7_KjU16;
        } else {
            l = disabledSelectedYearContainerColor;
        }
        if (i5 & 128 != 0) {
            l22 = unspecified-0d7_KjU3;
        } else {
            l22 = disabledDayContentColor;
        }
        if (i5 & 256 != 0) {
            l23 = unspecified-0d7_KjU4;
        } else {
            l23 = disabledSelectedDayContentColor;
        }
        if (i5 & 512 != 0) {
            l2 = unspecified-0d7_KjU15;
        } else {
            l2 = disabledSelectedDayContainerColor;
        }
        if (i5 & 1024 != 0) {
            l14 = unspecified-0d7_KjU6;
        } else {
            l14 = todayDateBorderColor;
        }
        if (i5 & 2048 != 0) {
            l3 = unspecified-0d7_KjU14;
        } else {
            l3 = dayInSelectionRangeContainerColor;
        }
        if (i5 & 4096 != 0) {
            l4 = unspecified-0d7_KjU5;
        } else {
            l4 = dateTextFieldColors;
        }
        if (i5 & 8192 != 0) {
            l15 = unspecified-0d7_KjU18;
        } else {
            l15 = $changed;
        }
        if (i5 & 16384 != 0) {
            l5 = unspecified-0d7_KjU24;
        } else {
            l5 = $changed2;
        }
        if (i10 &= i5 != 0) {
            l18 = unspecified-0d7_KjU;
        } else {
            l18 = obj86;
        }
        if (i11 &= i5 != 0) {
            l10 = unspecified-0d7_KjU20;
        } else {
            l10 = obj88;
        }
        if (i12 &= i5 != 0) {
            l6 = unspecified-0d7_KjU13;
        } else {
            l6 = obj90;
        }
        if (i13 &= i5 != 0) {
            l9 = unspecified-0d7_KjU11;
        } else {
            l9 = obj92;
        }
        if (i14 &= i5 != 0) {
            l11 = unspecified-0d7_KjU21;
        } else {
            l11 = obj94;
        }
        if (i15 &= i5 != 0) {
            l21 = unspecified-0d7_KjU9;
        } else {
            l21 = obj96;
        }
        if (i16 &= i5 != 0) {
            l13 = unspecified-0d7_KjU19;
        } else {
            l13 = obj98;
        }
        if (i17 &= i5 != 0) {
            l7 = unspecified-0d7_KjU2;
        } else {
            l7 = obj100;
        }
        if (i18 &= i5 != 0) {
            l8 = unspecified-0d7_KjU10;
        } else {
            l8 = obj102;
        }
        i3 = i5 &= i19 != 0 ? i4 : obj104;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i6, obj106, obj107, "androidx.compose.material3.DatePickerDefaults.colors (DatePicker.kt:497)");
        } else {
            i = obj106;
            i2 = obj107;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return this.getDefaultDatePickerColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6), composer, i8 &= 112).copy-tNwlRmA(l19, obj7, l12, obj9, l16, obj11, l17, obj13, l24, obj15, l20, obj17, l, obj19, l22, obj21, l23, obj23, l2, obj25, l14, obj27, l3, obj29, l4);
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
        long token5;
        long token16;
        long token8;
        long token11;
        long onSurfaceVariant-0d7_KjU;
        long token9;
        long copy-wmQWz5c$default2;
        long token10;
        int i3;
        long token;
        int i13;
        long copy-wmQWz5c$default;
        int i14;
        long token6;
        int i7;
        long copy-wmQWz5c$default4;
        int i5;
        long token4;
        int i8;
        long copy-wmQWz5c$default3;
        int i4;
        long token14;
        int i6;
        long copy-wmQWz5c$default6;
        int i;
        long token15;
        int i11;
        long copy-wmQWz5c$default5;
        int i2;
        long token13;
        int i9;
        long token12;
        int i10;
        long token7;
        int i15;
        long token2;
        long token3;
        androidx.compose.material3.TextFieldColors defaultOutlinedTextFieldColors;
        int i12;
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
            i14 = 0;
            i3 = 0;
            i13 = 0;
            i7 = 0;
            i5 = 0;
            i8 = 0;
            i4 = 0;
            i6 = 0;
            i = 0;
            i11 = 0;
            i2 = 0;
            i15 = 0;
            i9 = 0;
            i10 = 0;
            datePickerColors = new DatePickerColors(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getContainerColor()), obj6, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getHeaderSupportingTextColor()), obj8, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getHeaderHeadlineColor()), obj10, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getWeekdaysLabelTextColor()), obj12, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getRangeSelectionMonthSubheadColor()), obj14, colorScheme.getOnSurfaceVariant-0d7_KjU(), obj16, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), obj18, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearUnselectedLabelTextColor()), obj20, 1052938076, i3, 0, i13, 14), obj20, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), i3, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), i13, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedLabelTextColor()), i14, 1052938076, i7, 0, i5, 14), i14, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), i7, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionYearSelectedContainerColor()), i5, 1052938076, i8, 0, i4, 14), i5, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), i8, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateUnselectedLabelTextColor()), i4, 1052938076, i6, 0, i, 14), i4, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), i6, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedLabelTextColor()), i, 1052938076, i11, 0, i2, 14), i, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), i11, Color.copy-wmQWz5c$default(ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateSelectedContainerColor()), i2, 1052938076, i9, 0, i10, 14), i2, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayLabelTextColor()), i9, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getDateTodayContainerOutlineColor()), i10, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getRangeSelectionActiveIndicatorContainerColor()), i15, ColorSchemeKt.fromToken(colorScheme, DatePickerModalTokens.INSTANCE.getSelectionDateInRangeLabelTextColor()), obj50, ColorSchemeKt.fromToken(colorScheme, DividerTokens.INSTANCE.getColor()), obj52, OutlinedTextFieldDefaults.INSTANCE.getDefaultOutlinedTextFieldColors(colorScheme, composer, i19 |= 48), 0);
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
        int i;
        String str;
        Object empty;
        androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior.1.snapLayoutInfoProvider.1 anon;
        androidx.compose.material3.DatePickerDefaults.rememberSnapFlingBehavior.1.snapLayoutInfoProvider.1 date;
        int i3;
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
                i = i6 & 6 == i15 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer2 = $composer;
        int i16 = 0;
        final Object rememberedValue = composer2.rememberedValue();
        final int i17 = 0;
        if (changed2 |= i == 0) {
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
