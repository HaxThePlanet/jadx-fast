package androidx.compose.material3;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0087\u0001\u0010\u0003\u001a\u00020\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0011\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\u0008\u00152\u0011\u0010\u0016\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\u0008\u00152\u0011\u0010\u0017\u001a\r\u0012\u0004\u0012\u00020\u00040\u0014¢\u0006\u0002\u0008\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J$\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\rH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u001b\u0010\u001c\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u001d", d2 = {"Landroidx/compose/material3/DateRangePickerDefaults;", "", "()V", "DateRangePickerHeadline", "", "selectedStartDateMillis", "", "selectedEndDateMillis", "displayMode", "Landroidx/compose/material3/DisplayMode;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "modifier", "Landroidx/compose/ui/Modifier;", "DateRangePickerHeadline-v84Udv0", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "startDateText", "", "endDateText", "startDatePlaceholder", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "endDatePlaceholder", "datesDelimiter", "DateRangePickerHeadline-0YIUgSQ", "(Ljava/lang/Long;Ljava/lang/Long;ILandroidx/compose/material3/DatePickerFormatter;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DateRangePickerTitle", "DateRangePickerTitle-hOD91z4", "(ILandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DateRangePickerDefaults {

    public static final int $stable;
    public static final androidx.compose.material3.DateRangePickerDefaults INSTANCE;
    static {
        DateRangePickerDefaults dateRangePickerDefaults = new DateRangePickerDefaults();
        DateRangePickerDefaults.INSTANCE = dateRangePickerDefaults;
    }

    private final void DateRangePickerHeadline-0YIUgSQ(Long selectedStartDateMillis, Long selectedEndDateMillis, int displayMode, androidx.compose.material3.DatePickerFormatter dateFormatter, Modifier modifier, String startDateText, String endDateText, Function2<? super Composer, ? super Integer, Unit> startDatePlaceholder, Function2<? super Composer, ? super Integer, Unit> endDatePlaceholder, Function2<? super Composer, ? super Integer, Unit> datesDelimiter, Composer $composer, int $changed, int $changed1) {
        Object traceInProgress2;
        Object endRestartGroup;
        int this_$iv;
        boolean rowMeasurePolicy;
        Object valueOf2;
        Object valueOf;
        boolean $composer$iv;
        boolean traceInProgress;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Object materialized$iv$iv;
        Object it$iv;
        int $dirty;
        int formatterEndDate;
        int $i$f$getDatePickerNoSelectionDescription8iCLdWM;
        Composer composer2;
        Object currentCompositionLocalMap;
        int i36;
        String verboseEndDateDescription2;
        int i27;
        int i34;
        int i15;
        int i42;
        int i21;
        int i4;
        int i16;
        int i6;
        int i29;
        int i;
        int string-2EP1pXo;
        boolean changedInstance;
        Object obj5;
        int i45;
        Object obj8;
        Object obj2;
        Object obj3;
        Object obj6;
        Object obj4;
        Object obj;
        int i13;
        int i38;
        int i35;
        String str;
        int i18;
        int formatterEndDate2;
        int i20;
        int m3c_date_picker_no_selection_description;
        int i23;
        Composer.Companion companion;
        Object obj7;
        int i24;
        int i12;
        int i5;
        int i33;
        androidx.compose.ui.text.style.TextAlign textAlign;
        int i3;
        int i37;
        int i39;
        int i14;
        int i10;
        int i40;
        int i41;
        int i17;
        int i43;
        int i26;
        Composer composer;
        int i30;
        int i11;
        int i22;
        String formatterEndDate3;
        int i31;
        String verboseEndDateDescription;
        String str2;
        String str3;
        int i7;
        int i44;
        int i9;
        int i25;
        kotlin.jvm.functions.Function0 function0;
        int i28;
        int i19;
        int i32;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy$iv;
        androidx.compose.runtime.CompositionLocalMap map;
        int i2;
        int i8;
        RowScopeInstance rowScopeInstance;
        Composer composer3;
        Modifier modifier2;
        java.util.Locale obj74;
        materialized$iv$iv = selectedStartDateMillis;
        i45 = displayMode;
        traceInProgress2 = dateFormatter;
        obj8 = modifier;
        obj2 = startDateText;
        obj3 = endDateText;
        obj6 = startDatePlaceholder;
        obj4 = endDatePlaceholder;
        obj = datesDelimiter;
        i13 = $changed;
        final Composer restartGroup = $composer.startRestartGroup(-820363420);
        ComposerKt.sourceInformation(restartGroup, "C(DateRangePickerHeadline)P(7,6,2:c#material3.DisplayMode!1,5,9,4,8,3)416@19379L15,452@20912L168,450@20838L748:DateRangePicker.kt#uh7d8r");
        i36 = $changed1;
        if (i13 & 6 == 0) {
            i27 = restartGroup.changed(materialized$iv$iv) ? 4 : 2;
            $dirty |= i27;
        }
        if (i13 & 48 == 0) {
            i34 = restartGroup.changed(selectedEndDateMillis) ? 32 : 16;
            $dirty |= i34;
        }
        if (i13 & 384 == 0) {
            i15 = restartGroup.changed(i45) ? 256 : 128;
            $dirty |= i15;
        }
        if (i13 & 3072 == 0) {
            if (i13 & 4096 == 0) {
                changedInstance = restartGroup.changed(traceInProgress2);
            } else {
                changedInstance = restartGroup.changedInstance(traceInProgress2);
            }
            i42 = changedInstance != null ? 2048 : 1024;
            $dirty |= i42;
        }
        if (i13 & 24576 == 0) {
            i21 = restartGroup.changed(obj8) ? 16384 : 8192;
            $dirty |= i21;
        }
        if (i86 &= i13 == 0) {
            i4 = restartGroup.changed(obj2) ? 131072 : 65536;
            $dirty |= i4;
        }
        if (i87 &= i13 == 0) {
            i16 = restartGroup.changed(obj3) ? 1048576 : 524288;
            $dirty |= i16;
        }
        if (i88 &= i13 == 0) {
            i6 = restartGroup.changedInstance(obj6) ? 8388608 : 4194304;
            $dirty |= i6;
        }
        if (i89 &= i13 == 0) {
            i29 = restartGroup.changedInstance(obj4) ? 67108864 : 33554432;
            $dirty |= i29;
        }
        if (i90 &= i13 == 0) {
            i = restartGroup.changedInstance(obj) ? 536870912 : 268435456;
            $dirty |= i;
        }
        if (i91 &= $dirty == 306783378 && i36 & 1 == 0) {
            if (i36 & 1 == 0) {
                if (!restartGroup.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-820363420, $dirty, i36, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:415)");
                    }
                    int i62 = 0;
                    java.util.Locale defaultLocale = CalendarLocale_androidKt.defaultLocale(restartGroup, i62);
                    int $dirty1 = 4;
                    i38 = i92;
                    int $dirty12 = 0;
                    i35 = $dirty;
                    int i96 = i62;
                    str = formatDate$default;
                    Long num2 = selectedEndDateMillis;
                    androidx.compose.material3.DatePickerFormatter date = dateFormatter;
                    formatterEndDate = DatePickerFormatter.formatDate$default(date, num2, defaultLocale, false, $dirty1, $dirty12);
                    restartGroup.startReplaceGroup(1063152176);
                    verboseEndDateDescription2 = "";
                    ComposerKt.sourceInformation(restartGroup, verboseEndDateDescription2);
                    if (date.formatDate(selectedStartDateMillis, defaultLocale, true) == null) {
                        if (DisplayMode.equals-impl0(i45, DisplayMode.Companion.getPicker-jFl-4v0())) {
                            restartGroup.startReplaceGroup(1063160130);
                            ComposerKt.sourceInformation(restartGroup, "430@19972L51");
                            androidx.compose.material3.internal.Strings.Companion companion12 = Strings.Companion;
                            formatterEndDate2 = 0;
                            formatterEndDate3 = formatterEndDate;
                            string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_picker_no_selection_description), restartGroup, 0);
                            restartGroup.endReplaceGroup();
                        } else {
                            formatterEndDate3 = formatterEndDate;
                            if (DisplayMode.equals-impl0(i45, DisplayMode.Companion.getInput-jFl-4v0())) {
                                restartGroup.startReplaceGroup(1063163101);
                                ComposerKt.sourceInformation(restartGroup, "431@20065L46");
                                androidx.compose.material3.internal.Strings.Companion companion9 = Strings.Companion;
                                int i94 = 0;
                                restartGroup.endReplaceGroup();
                                string-2EP1pXo = formatterEndDate;
                            } else {
                                restartGroup.startReplaceGroup(-1401609201);
                                restartGroup.endReplaceGroup();
                                string-2EP1pXo = verboseEndDateDescription2;
                            }
                        }
                    } else {
                        formatterEndDate3 = formatterEndDate;
                    }
                    restartGroup.endReplaceGroup();
                    $i$f$getDatePickerNoSelectionDescription8iCLdWM = date.formatDate(num2, defaultLocale, true);
                    restartGroup.startReplaceGroup(1063168270);
                    ComposerKt.sourceInformation(restartGroup, verboseEndDateDescription2);
                    if ($i$f$getDatePickerNoSelectionDescription8iCLdWM == null) {
                        if (DisplayMode.equals-impl0(i45, DisplayMode.Companion.getPicker-jFl-4v0())) {
                            restartGroup.startReplaceGroup(1063176162);
                            ComposerKt.sourceInformation(restartGroup, "442@20473L51");
                            androidx.compose.material3.internal.Strings.Companion companion3 = Strings.Companion;
                            int i75 = 0;
                            verboseEndDateDescription2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_picker_no_selection_description), restartGroup, 0);
                            restartGroup.endReplaceGroup();
                        } else {
                            if (DisplayMode.equals-impl0(i45, DisplayMode.Companion.getInput-jFl-4v0())) {
                                restartGroup.startReplaceGroup(1063179133);
                                ComposerKt.sourceInformation(restartGroup, "443@20566L46");
                                androidx.compose.material3.internal.Strings.Companion companion5 = Strings.Companion;
                                int i76 = 0;
                                verboseEndDateDescription2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_no_input_description), restartGroup, 0);
                                restartGroup.endReplaceGroup();
                            } else {
                                restartGroup.startReplaceGroup(-1401112209);
                                restartGroup.endReplaceGroup();
                            }
                        }
                    } else {
                        verboseEndDateDescription2 = $i$f$getDatePickerNoSelectionDescription8iCLdWM;
                    }
                    restartGroup.endReplaceGroup();
                    StringBuilder stringBuilder = new StringBuilder();
                    String str10 = ": ";
                    String string = stringBuilder.append(obj2).append(str10).append(string-2EP1pXo).toString();
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String string2 = stringBuilder2.append(obj3).append(str10).append(verboseEndDateDescription2).toString();
                    obj74 = defaultLocale;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1063190327, "CC(remember):DateRangePicker.kt#9igjgp");
                    Composer composer5 = restartGroup;
                    int i97 = 0;
                    it$iv = composer5.rememberedValue();
                    int i102 = 0;
                    if (changed |= changed2 == 0) {
                        verboseEndDateDescription = verboseEndDateDescription2;
                        if (it$iv == Composer.Companion.getEmpty()) {
                            verboseEndDateDescription2 = 0;
                            obj7 = it$iv;
                            it$iv = new DateRangePickerDefaults.DateRangePickerHeadline.4.1(string, string2);
                            composer5.updateRememberedValue((Function1)it$iv);
                        } else {
                            obj7 = it$iv;
                        }
                    } else {
                        verboseEndDateDescription = verboseEndDateDescription2;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    str2 = string;
                    int i98 = 0;
                    str3 = string2;
                    i7 = i63;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 693286680, "CC(Row)P(2,1,3)98@4939L58,99@5002L130:Row.kt#2w3rfo");
                    rowMeasurePolicy = RowKt.rowMeasurePolicy((Arrangement.Horizontal)Arrangement.INSTANCE.spacedBy-0680j_4(Dp.constructor-impl((float)startHeadlineDescription)), Alignment.Companion.getCenterVertically(), restartGroup, i65 |= i100);
                    i9 = i78;
                    ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    currentCompositionLocalMap = restartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, SemanticsModifierKt.clearAndSetSemantics(obj8, (Function1)it$iv));
                    i25 = currentCompositeKeyHash;
                    kotlin.jvm.functions.Function0 function02 = constructor;
                    i28 = 0;
                    i32 = i82;
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
                    i18 = 0;
                    function0 = factory$iv$iv$iv;
                    Updater.set-impl(constructor-impl, rowMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    i20 = 0;
                    m3c_date_picker_no_selection_description = constructor-impl;
                    i23 = 0;
                    companion = m3c_date_picker_no_selection_description.getInserting();
                    if (!companion) {
                        measurePolicy$iv = rowMeasurePolicy;
                        map = currentCompositionLocalMap;
                        if (!Intrinsics.areEqual(m3c_date_picker_no_selection_description.rememberedValue(), Integer.valueOf(i25))) {
                            m3c_date_picker_no_selection_description.updateRememberedValue(Integer.valueOf(i25));
                            constructor-impl.apply(Integer.valueOf(i25), ComposeUiNode.Companion.getSetCompositeKeyHash());
                        } else {
                            composer2 = m3c_date_picker_no_selection_description;
                        }
                    } else {
                        measurePolicy$iv = rowMeasurePolicy;
                        map = currentCompositionLocalMap;
                    }
                    Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    Composer composer4 = restartGroup;
                    $dirty = 0;
                    i2 = i50;
                    ComposerKt.sourceInformationMarkerStart(composer4, -407918630, "C100@5047L9:Row.kt#2w3rfo");
                    i85 |= 6;
                    i8 = 0;
                    rowScopeInstance = iNSTANCE;
                    modifier2 = materializeModifier;
                    materialized$iv$iv = composer;
                    ComposerKt.sourceInformationMarkerStart(materialized$iv$iv, 303323611, "C464@21398L16:DateRangePicker.kt#uh7d8r");
                    if (str != null) {
                        materialized$iv$iv.startReplaceGroup(303346581);
                        ComposerKt.sourceInformation(materialized$iv$iv, "460@21280L31");
                        TextKt.Text--4IGK_g(str, 0, 0, m3c_date_picker_no_selection_description, 0, companion, 0, 0, 0, 0, obj28, 0, false, 0, obj32, 0, 0, 0, 0, 0, 0);
                        materialized$iv$iv.endReplaceGroup();
                    } else {
                        materialized$iv$iv.startReplaceGroup(303414750);
                        ComposerKt.sourceInformation(materialized$iv$iv, "462@21349L22");
                        obj6.invoke(materialized$iv$iv, Integer.valueOf(i58 &= 14));
                        materialized$iv$iv.endReplaceGroup();
                    }
                    obj.invoke(materialized$iv$iv, Integer.valueOf(i51 &= 14));
                    if (formatterEndDate3 != null) {
                        materialized$iv$iv.startReplaceGroup(303539959);
                        ComposerKt.sourceInformation(materialized$iv$iv, "466@21475L29");
                        TextKt.Text--4IGK_g(formatterEndDate3, 0, 0, companion, 0, i12, 0, 0, 0, 0, i37, 0, false, 0, i40, 0, 0, 0, 0, 0, 0);
                        materialized$iv$iv.endReplaceGroup();
                    } else {
                        formatterEndDate2 = formatterEndDate3;
                        materialized$iv$iv.startReplaceGroup(303606144);
                        ComposerKt.sourceInformation(materialized$iv$iv, "468@21542L20");
                        obj4.invoke(materialized$iv$iv, Integer.valueOf(i54 &= 14));
                        materialized$iv$iv.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(materialized$iv$iv);
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
                    obj5 = materialized$iv$iv;
                    i35 = $dirty;
                    i38 = i36;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup = new DateRangePickerDefaults.DateRangePickerHeadline.6(this, obj5, selectedEndDateMillis, i45, dateFormatter, obj8, obj2, obj3, obj6, obj4, obj, i13, $changed1);
            endRestartGroup.updateScope((Function2)endRestartGroup);
        }
    }

    public static final void access$DateRangePickerHeadline-0YIUgSQ(androidx.compose.material3.DateRangePickerDefaults $this, Long selectedStartDateMillis, Long selectedEndDateMillis, int displayMode, androidx.compose.material3.DatePickerFormatter dateFormatter, Modifier modifier, String startDateText, String endDateText, Function2 startDatePlaceholder, Function2 endDatePlaceholder, Function2 datesDelimiter, Composer $composer, int $changed, int $changed1) {
        $this.DateRangePickerHeadline-0YIUgSQ(selectedStartDateMillis, selectedEndDateMillis, displayMode, dateFormatter, modifier, startDateText, endDateText, startDatePlaceholder, endDatePlaceholder, datesDelimiter, $composer, $changed, $changed1);
    }

    public final void DateRangePickerHeadline-v84Udv0(Long selectedStartDateMillis, Long selectedEndDateMillis, int displayMode, androidx.compose.material3.DatePickerFormatter dateFormatter, Modifier modifier, Composer $composer, int $changed, int i8) {
        boolean traceInProgress;
        int $dirty;
        Object companion;
        boolean traceInProgress2;
        Object obj2;
        int i2;
        Object obj4;
        Object obj;
        int i5;
        int i10;
        int i4;
        int i;
        Object startDateText;
        int str;
        boolean changedInstance;
        Object modifier2;
        int i3;
        Object obj3;
        int i9;
        androidx.compose.runtime.internal.ComposableLambda rememberComposableLambda;
        Function2 lambda-1$material3_release;
        int i7;
        int i6;
        Object obj5;
        obj = dateFormatter;
        final int i39 = $changed;
        traceInProgress = -1611069472;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(DateRangePickerHeadline)P(4,3,1:c#material3.DisplayMode)363@16696L47,364@16770L45,373@17203L30,374@17268L28,365@16824L534:DateRangePicker.kt#uh7d8r");
        $dirty = $changed;
        if (i8 & 1 != 0) {
            $dirty |= 6;
            obj2 = selectedStartDateMillis;
        } else {
            if (i39 & 6 == 0) {
                i2 = restartGroup.changed(selectedStartDateMillis) ? 4 : 2;
                $dirty |= i2;
            } else {
                obj2 = selectedStartDateMillis;
            }
        }
        if (i8 & 2 != 0) {
            $dirty |= 48;
            obj4 = selectedEndDateMillis;
        } else {
            if (i39 & 48 == 0) {
                i5 = restartGroup.changed(selectedEndDateMillis) ? 32 : 16;
                $dirty |= i5;
            } else {
                obj4 = selectedEndDateMillis;
            }
        }
        if (i8 & 4 != 0) {
            $dirty |= 384;
            i10 = displayMode;
        } else {
            if (i39 & 384 == 0) {
                i4 = restartGroup.changed(displayMode) ? 256 : 128;
                $dirty |= i4;
            } else {
                i10 = displayMode;
            }
        }
        if (i8 & 8 != 0) {
            $dirty |= 3072;
        } else {
            if (i39 & 3072 == 0) {
                if (i39 & 4096 == 0) {
                    changedInstance = restartGroup.changed(obj);
                } else {
                    changedInstance = restartGroup.changedInstance(obj);
                }
                i = changedInstance != null ? 2048 : 1024;
                $dirty |= i;
            }
        }
        str = i8 & 16;
        if (str != null) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else {
            if (i39 & 24576 == 0) {
                i3 = restartGroup.changed(modifier) ? 16384 : 8192;
                $dirty |= i3;
            } else {
                modifier2 = modifier;
            }
        }
        i9 = 196608;
        if (i8 & 32 != 0) {
            $dirty |= i9;
            obj3 = this;
        } else {
            if (i39 & i9 == 0) {
                i9 = restartGroup.changed(this) ? 131072 : 65536;
                $dirty |= i9;
            } else {
                obj3 = this;
            }
        }
        final int i40 = $dirty;
        if ($dirty2 &= i40 == 74898) {
            if (!restartGroup.getSkipping()) {
                if (str != null) {
                    modifier2 = companion;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i40, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerHeadline (DateRangePicker.kt:362)");
                }
                androidx.compose.material3.internal.Strings.Companion companion2 = Strings.Companion;
                int i11 = 0;
                int $i$f$getDateRangePickerStartHeadline8iCLdWM = 0;
                String string-2EP1pXo2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_range_picker_start_headline), restartGroup, $i$f$getDateRangePickerStartHeadline8iCLdWM);
                androidx.compose.material3.internal.Strings.Companion companion3 = Strings.Companion;
                int i22 = 0;
                String string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_range_picker_end_headline), restartGroup, $i$f$getDateRangePickerStartHeadline8iCLdWM);
                DateRangePickerDefaults.DateRangePickerHeadline.1 anon = new DateRangePickerDefaults.DateRangePickerHeadline.1(string-2EP1pXo2);
                int i24 = 1;
                int i25 = 54;
                DateRangePickerDefaults.DateRangePickerHeadline.2 anon2 = new DateRangePickerDefaults.DateRangePickerHeadline.2(string-2EP1pXo);
                i10 = obj5;
                obj3.DateRangePickerHeadline-0YIUgSQ(obj2, obj4, i10, obj, i10, string-2EP1pXo2, string-2EP1pXo, (Function2)ComposableLambdaKt.rememberComposableLambda(482821121, i24, anon, restartGroup, i25), (Function2)ComposableLambdaKt.rememberComposableLambda(-1522669758, i24, anon2, restartGroup, i25), ComposableSingletons.DateRangePickerKt.INSTANCE.getLambda-1$material3_release(), restartGroup, i30 |= i37, i38 &= 14);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                startDateText = i10;
            } else {
                restartGroup.skipToGroupEnd();
                startDateText = modifier2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new DateRangePickerDefaults.DateRangePickerHeadline.3(this, selectedStartDateMillis, selectedEndDateMillis, displayMode, dateFormatter, startDateText, i39, i8);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public final void DateRangePickerTitle-hOD91z4(int displayMode, Modifier modifier, Composer $composer, int $changed, int i5) {
        int traceInProgress2;
        Composer $composer3;
        Composer this_$iv;
        int $dirty;
        Object $dirty2;
        int i14;
        int modifier2;
        Object obj;
        boolean traceInProgress;
        int i20;
        Composer $composer2;
        int skipping;
        int i15;
        int i4;
        int i;
        int i8;
        int i16;
        int i13;
        int i10;
        int i6;
        int i11;
        int i3;
        int i2;
        int i19;
        int i9;
        int i18;
        Composer composer;
        int i12;
        int i17;
        int i21;
        int i7;
        final int i24 = displayMode;
        traceInProgress2 = -1412719908;
        this_$iv = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(this_$iv, "C(DateRangePickerTitle)P(0:c#material3.DisplayMode):DateRangePicker.kt#uh7d8r");
        $dirty = $changed;
        if (i5 & 1 != 0) {
            $dirty |= 6;
        } else {
            if ($changed & 6 == 0) {
                i14 = this_$iv.changed(i24) ? 4 : 2;
                $dirty |= i14;
            }
        }
        modifier2 = i5 & 2;
        if (modifier2 != 0) {
            $dirty |= 48;
            obj = modifier;
        } else {
            if ($changed & 48 == 0) {
                i20 = this_$iv.changed(modifier) ? 32 : 16;
                $dirty |= i20;
            } else {
                obj = modifier;
            }
        }
        if ($dirty & 19 == 18) {
            if (!this_$iv.getSkipping()) {
                if (modifier2 != 0) {
                    modifier2 = Modifier.Companion;
                } else {
                    modifier2 = obj;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.DateRangePickerDefaults.DateRangePickerTitle (DateRangePicker.kt:334)");
                }
                obj = 0;
                if (DisplayMode.equals-impl0(i24, DisplayMode.Companion.getPicker-jFl-4v0())) {
                    this_$iv.startReplaceGroup(980462952);
                    ComposerKt.sourceInformation(this_$iv, "337@15482L48,337@15477L75");
                    androidx.compose.material3.internal.Strings.Companion companion2 = Strings.Companion;
                    composer = this_$iv;
                    i7 = $dirty;
                    TextKt.Text--4IGK_g(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_range_picker_title), this_$iv, obj), modifier2, 0, 0, 0, obj8, 0, 0, 0, 0, obj13, 0, false, 0, obj17, 0, 0, 0, 0, 0, 0);
                    $composer3 = composer;
                    $composer3.endReplaceGroup();
                    $composer2 = $composer3;
                } else {
                    $composer3 = this_$iv;
                    if (DisplayMode.equals-impl0(i24, DisplayMode.Companion.getInput-jFl-4v0())) {
                        $composer3.startReplaceGroup(980466951);
                        ComposerKt.sourceInformation($composer3, "339@15607L47,339@15602L74");
                        androidx.compose.material3.internal.Strings.Companion companion3 = Strings.Companion;
                        int i25 = 0;
                        int m3c_date_range_input_title = R.string.m3c_date_range_input_title;
                        composer = $composer3;
                        TextKt.Text--4IGK_g(Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(m3c_date_range_input_title), $composer3, obj), modifier2, 0, m3c_date_range_input_title, 0, obj8, 0, 0, 0, 0, obj13, 0, false, 0, obj17, 0, 0, 0, 0, 0, 0);
                        composer.endReplaceGroup();
                    } else {
                        $composer2 = $composer3;
                        $composer2.startReplaceGroup(329785445);
                        $composer2.endReplaceGroup();
                    }
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $dirty2 = modifier2;
            } else {
                this_$iv.skipToGroupEnd();
                $composer2 = this_$iv;
                i7 = $dirty;
                $dirty2 = obj;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new DateRangePickerDefaults.DateRangePickerTitle.1(this, i24, $dirty2, $changed, i5);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }
}
