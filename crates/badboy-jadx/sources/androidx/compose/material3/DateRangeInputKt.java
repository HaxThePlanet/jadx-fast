package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
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
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.unit.Dp;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0085\u0001\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00062:\u0010\u0008\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\u000c\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\u000c\u0008\n\u0012\u0008\u0008\u000b\u0012\u0004\u0008\u0008(\r\u0012\u0004\u0012\u00020\u00040\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0001¢\u0006\u0002\u0010\u0018\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u0019", d2 = {"TextFieldSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "DateRangeInputContent", "", "selectedStartDateMillis", "", "selectedEndDateMillis", "onDatesSelectionChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "startDateMillis", "endDateMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Ljava/lang/Long;Ljava/lang/Long;Lkotlin/jvm/functions/Function2;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DateRangeInputKt {

    private static final float TextFieldSpacing;
    static {
        final int i2 = 0;
        DateRangeInputKt.TextFieldSpacing = Dp.constructor-impl((float)i);
    }

    public static final void DateRangeInputContent(Long selectedStartDateMillis, Long selectedEndDateMillis, Function2<? super Long, ? super Long, Unit> onDatesSelectionChange, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerFormatter dateFormatter, androidx.compose.material3.SelectableDates selectableDates, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        Composer composer3;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        int i24;
        int i20;
        Object it$iv;
        boolean traceInProgress;
        Object endRangeText;
        int empty;
        Object $i$a$CacheDateRangeInputKt$DateRangeInputContent$dateInputFormat$1;
        Object $i$a$CacheDateRangeInputKt$DateRangeInputContent$dateInputValidator$1;
        boolean valueOf;
        Object anon;
        Composer composer2;
        Object $dirty;
        Object $composer3;
        int i22;
        int $dirty2;
        int endDateInput-J2x2o4M;
        int i30;
        int i10;
        int i26;
        int i23;
        Object obj4;
        Object obj;
        int defaultLocale;
        boolean traceInProgress2;
        androidx.compose.material3.DatePickerColors date;
        int i29;
        int i11;
        Object verticalAlignment$iv;
        boolean changedInstance;
        int changed;
        int i7;
        int i28;
        int str4;
        int empty2;
        Object obj3;
        int i5;
        int i2;
        Object dateInputValidator;
        int i3;
        Object i9;
        Object i15;
        int i;
        DateInputFormat dateInputFormat2;
        androidx.compose.ui.Alignment.Vertical dateInputFormat;
        Object i4;
        int i6;
        Object string-2EP1pXo;
        String string-2EP1pXo2;
        String string-2EP1pXo3;
        String string-2EP1pXo4;
        int startRangeText;
        int currentCompositeKeyHash;
        int i13;
        int i21;
        androidx.compose.runtime.CompositionLocalMap map;
        Modifier modifier;
        Composer composer;
        String pattern;
        int i31;
        int i14;
        int i27;
        kotlin.jvm.functions.Function0 function0;
        int i16;
        int i19;
        androidx.compose.foundation.layout.Arrangement.HorizontalOrVertical horizontalArrangement$iv;
        RowScopeInstance rowScopeInstance;
        String str;
        int i17;
        int i12;
        int i18;
        int i25;
        Composer $composer$iv;
        Object obj2;
        Composer.Companion companion;
        Composer $composer2;
        int i8;
        String str3;
        String str2;
        Modifier obj60;
        endRangeText = selectedStartDateMillis;
        obj3 = selectedEndDateMillis;
        final Object obj7 = onDatesSelectionChange;
        $dirty = calendarModel;
        endDateInput-J2x2o4M = dateFormatter;
        traceInProgress = $changed;
        anon = -607499086;
        $composer3 = $composer.startRestartGroup(anon);
        ComposerKt.sourceInformation($composer3, "C(DateRangeInputContent)P(6,5,3!1,7,2,4)45@1775L15,47@1825L75,48@1928L45,49@2008L44,50@2086L45,51@2160L50,53@2248L530,70@2991L2331:DateRangeInput.kt#uh7d8r");
        if (traceInProgress & 6 == 0) {
            i30 = $composer3.changed(endRangeText) ? 4 : 2;
            $dirty2 |= i30;
        }
        if (traceInProgress & 48 == 0) {
            i10 = $composer3.changed(obj3) ? 32 : 16;
            $dirty2 |= i10;
        }
        if (traceInProgress & 384 == 0) {
            i26 = $composer3.changedInstance(obj7) ? 256 : 128;
            $dirty2 |= i26;
        }
        if (traceInProgress & 3072 == 0) {
            i23 = $composer3.changedInstance($dirty) ? 2048 : 1024;
            $dirty2 |= i23;
        }
        if (traceInProgress & 24576 == 0) {
            i29 = $composer3.changedInstance(yearRange) ? 16384 : 8192;
            $dirty2 |= i29;
        } else {
            obj4 = yearRange;
        }
        int i87 = 262144;
        if (i75 &= traceInProgress == 0) {
            if (traceInProgress & i87 == 0) {
                changedInstance = $composer3.changed(endDateInput-J2x2o4M);
            } else {
                changedInstance = $composer3.changedInstance(endDateInput-J2x2o4M);
            }
            i11 = changedInstance != null ? 131072 : 65536;
            $dirty2 |= i11;
        }
        if (i76 &= traceInProgress == 0) {
            i5 = $composer3.changed(selectableDates) ? 1048576 : 524288;
            $dirty2 |= i5;
        } else {
            verticalAlignment$iv = selectableDates;
        }
        if (traceInProgress & i101 == 0) {
            i2 = $composer3.changed(colors) ? 8388608 : 4194304;
            $dirty2 |= i2;
        } else {
            obj = colors;
        }
        if ($dirty2 & i3 == 4793490) {
            if (!$composer3.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, $dirty2, -1, "androidx.compose.material3.DateRangeInputContent (DateRangeInput.kt:43)");
                }
                defaultLocale = CalendarLocale_androidKt.defaultLocale($composer3, 0);
                String str12 = "CC(remember):DateRangeInput.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer3, 998328518, str12);
                Composer composer8 = $composer3;
                i15 = 0;
                Object rememberedValue3 = composer8.rememberedValue();
                i4 = 0;
                if (!$composer3.changed(defaultLocale)) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        int i48 = 0;
                        composer8.updateRememberedValue($dirty.getDateInputFormat(defaultLocale));
                    } else {
                        $i$a$CacheDateRangeInputKt$DateRangeInputContent$dateInputFormat$1 = rememberedValue3;
                        composer3 = composer8;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($composer3);
                androidx.compose.material3.internal.Strings.Companion companion2 = Strings.Companion;
                int i80 = 0;
                int $i$f$getDateInputInvalidForPattern8iCLdWM = 0;
                androidx.compose.material3.internal.Strings.Companion companion3 = Strings.Companion;
                int i89 = 0;
                androidx.compose.material3.internal.Strings.Companion companion4 = Strings.Companion;
                int i90 = 0;
                androidx.compose.material3.internal.Strings.Companion companion5 = Strings.Companion;
                int i91 = 0;
                ComposerKt.sourceInformationMarkerStart($composer3, 998342509, str12);
                if (i81 &= $dirty2 != 131072) {
                    if ($dirty2 & i9 != 0 && $composer3.changed(endDateInput-J2x2o4M)) {
                        if ($composer3.changed(endDateInput-J2x2o4M)) {
                            i7 = 1;
                        } else {
                            i7 = 0;
                        }
                    } else {
                    }
                } else {
                }
                Composer composer7 = $composer3;
                int i93 = 0;
                Object rememberedValue = composer7.rememberedValue();
                int i105 = 0;
                if (changed2 |= i7 == 0) {
                    dateInputFormat2 = $i$a$CacheDateRangeInputKt$DateRangeInputContent$dateInputFormat$1;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int dateInputFormat3 = 0;
                        dateInputValidator = new DateInputValidator(obj4, verticalAlignment$iv, dateInputFormat2, endDateInput-J2x2o4M, Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_invalid_for_pattern), $composer3, $i$f$getDateInputInvalidForPattern8iCLdWM), Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_invalid_year_range), $composer3, $i$f$getDateInputInvalidForPattern8iCLdWM), Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_invalid_not_allowed), $composer3, $i$f$getDateInputInvalidForPattern8iCLdWM), Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_range_input_invalid_range_input), $composer3, $i$f$getDateInputInvalidForPattern8iCLdWM), 0, 0, 768, 0);
                        composer7.updateRememberedValue(dateInputValidator);
                    } else {
                        $i$a$CacheDateRangeInputKt$DateRangeInputContent$dateInputValidator$1 = rememberedValue;
                    }
                } else {
                    dateInputFormat2 = $i$a$CacheDateRangeInputKt$DateRangeInputContent$dateInputFormat$1;
                }
                obj4 = $i$a$CacheDateRangeInputKt$DateRangeInputContent$dateInputValidator$1;
                ComposerKt.sourceInformationMarkerEnd($composer3);
                androidx.compose.material3.DateInputValidator date2 = obj4;
                int i49 = 0;
                date2.setCurrentStartDateMillis$material3_release(endRangeText);
                date2.setCurrentEndDateMillis$material3_release(obj3);
                Modifier padding = PaddingKt.padding((Modifier)Modifier.Companion, DateInputKt.getInputTextFieldPadding());
                valueOf = Arrangement.INSTANCE.spacedBy-0680j_4(DateRangeInputKt.TextFieldSpacing);
                i3 = i66;
                i9 = 0;
                ComposerKt.sourceInformationMarkerStart($composer3, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                androidx.compose.ui.Alignment.Vertical top = Alignment.Companion.getTop();
                androidx.compose.ui.layout.MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy((Arrangement.Horizontal)valueOf, top, $composer3, i83 |= i95);
                i6 = 0;
                ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
                androidx.compose.runtime.CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier($composer3, padding);
                i21 = padding;
                kotlin.jvm.functions.Function0 function02 = constructor;
                i14 = 0;
                ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $composer3.startReusableNode();
                if ($composer3.getInserting()) {
                    $composer3.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    $composer3.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl($composer3);
                int i104 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i106 = 0;
                Composer composer9 = constructor-impl;
                int i107 = 0;
                if (!composer9.getInserting()) {
                    horizontalArrangement$iv = valueOf;
                    if (!Intrinsics.areEqual(composer9.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composer9.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        constructor-impl.apply(Integer.valueOf(currentCompositeKeyHash), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer2 = composer9;
                    }
                } else {
                    horizontalArrangement$iv = valueOf;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                i31 = i37 & 14;
                Composer composer4 = $composer3;
                i27 = 0;
                ComposerKt.sourceInformationMarkerStart(composer4, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                i16 = i51 | 6;
                verticalAlignment$iv = composer4;
                rowScopeInstance = iNSTANCE;
                i19 = 0;
                ComposerKt.sourceInformationMarkerStart(verticalAlignment$iv, -1199006788, "C75@3252L56,88@3849L203,79@3446L218,86@3692L62,76@3317L972,98@4317L54,110@4882L199,102@4509L190,108@4727L62,99@4380L936:DateRangeInput.kt#uh7d8r");
                String upperCase = dateInputFormat2.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                androidx.compose.material3.internal.Strings.Companion companion11 = Strings.Companion;
                int i108 = 0;
                String string-2EP1pXo6 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_range_picker_start_headline), verticalAlignment$iv, 0);
                ComposerKt.sourceInformationMarkerStart(verticalAlignment$iv, 1485363141, str12);
                i24 = $dirty2 & 896 == 256 ? 1 : 0;
                i20 = $dirty2 & 112 == 32 ? 1 : 0;
                Composer composer5 = verticalAlignment$iv;
                int i102 = 0;
                it$iv = composer5.rememberedValue();
                int i115 = 0;
                if (i112 | i20 == 0) {
                    $composer2 = $composer3;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        $composer3 = 0;
                        obj2 = it$iv;
                        it$iv = new DateRangeInputKt.DateRangeInputContent.2.1.1(obj7, obj3);
                        composer5.updateRememberedValue((Function1)it$iv);
                    } else {
                        obj2 = it$iv;
                    }
                } else {
                    $composer2 = $composer3;
                }
                ComposerKt.sourceInformationMarkerEnd(verticalAlignment$iv);
                DateRangeInputKt.DateRangeInputContent.2.2 anon2 = new DateRangeInputKt.DateRangeInputContent.2.2(string-2EP1pXo6, upperCase);
                int i53 = 54;
                int startRangeText2 = 1;
                DateRangeInputKt.DateRangeInputContent.2.3 anon3 = new DateRangeInputKt.DateRangeInputContent.2.3(upperCase);
                companion = 1794048;
                modifier = materializeModifier;
                empty2 = 0;
                obj = dateInputFormat2;
                pattern = str14;
                dateInputFormat = vertical2;
                $composer$iv = $composer2;
                map = currentCompositionLocalMap;
                startRangeText = rowMeasurePolicy;
                Long num2 = selectedStartDateMillis;
                DateInputKt.DateInputTextField-tQNruF0(RowScope.weight$default(rowScopeInstance, (Modifier)Modifier.Companion, 1056964608, false, 2, 0), num2, (Function1)it$iv, calendarModel, (Function2)ComposableLambdaKt.rememberComposableLambda(801434508, startRangeText2, anon2, verticalAlignment$iv, i53), (Function2)ComposableLambdaKt.rememberComposableLambda(665407211, startRangeText2, anon3, verticalAlignment$iv, i53), InputIdentifier.Companion.getStartDateInput-J2x2o4M(), (DateInputValidator)obj4, obj, defaultLocale, obj, verticalAlignment$iv, i46 |= i54, i55 &= 14);
                androidx.compose.material3.internal.Strings.Companion companion9 = Strings.Companion;
                int i57 = 0;
                String string-2EP1pXo5 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_range_picker_end_headline), verticalAlignment$iv, empty2);
                Modifier weight$default = RowScope.weight$default(rowScopeInstance, (Modifier)Modifier.Companion, 1056964608, false, 2, 0);
                ComposerKt.sourceInformationMarkerStart(verticalAlignment$iv, 1485396193, str12);
                int i59 = i116;
                i22 = i59 & 896 == 256 ? 1 : empty2;
                if (i59 & 14 == 4) {
                    empty2 = 1;
                }
                Composer composer6 = verticalAlignment$iv;
                int i70 = 0;
                Object rememberedValue4 = composer6.rememberedValue();
                int i99 = 0;
                if (i22 |= empty2 == 0) {
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        empty2 = 0;
                        obj60 = weight$default;
                        anon = new DateRangeInputKt.DateRangeInputContent.2.4.1(obj7, num2);
                        composer6.updateRememberedValue((Function1)anon);
                    } else {
                        obj60 = weight$default;
                        anon = rememberedValue4;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(verticalAlignment$iv);
                obj3 = str3;
                DateRangeInputKt.DateRangeInputContent.2.5 anon4 = new DateRangeInputKt.DateRangeInputContent.2.5(string-2EP1pXo5, obj3);
                int i71 = 54;
                int i85 = 1;
                DateRangeInputKt.DateRangeInputContent.2.6 anon5 = new DateRangeInputKt.DateRangeInputContent.2.6(obj3);
                str = string-2EP1pXo5;
                i8 = i59;
                DateInputKt.DateInputTextField-tQNruF0(obj60, selectedEndDateMillis, (Function1)anon, calendarModel, (Function2)ComposableLambdaKt.rememberComposableLambda(911487285, i85, anon4, verticalAlignment$iv, i71), (Function2)ComposableLambdaKt.rememberComposableLambda(-961726252, i85, anon5, verticalAlignment$iv, i71), InputIdentifier.Companion.getEndDateInput-J2x2o4M(), obj4, obj, defaultLocale, colors, verticalAlignment$iv, i86 |= i73, i74 & 14);
                ComposerKt.sourceInformationMarkerEnd(verticalAlignment$iv);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                $composer$iv.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                ComposerKt.sourceInformationMarkerEnd($composer$iv);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer3.skipToGroupEnd();
                $composer$iv = $composer3;
                i8 = $dirty2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer$iv.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new DateRangeInputKt.DateRangeInputContent.3(selectedStartDateMillis, selectedEndDateMillis, obj7, calendarModel, yearRange, dateFormatter, selectableDates, colors, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }
}
