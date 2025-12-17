package androidx.compose.material3;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.internal.CalendarModel;
import androidx.compose.material3.internal.DateInputFormat;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeAction.Companion;
import androidx.compose.ui.text.input.KeyboardType;
import androidx.compose.ui.text.input.KeyboardType.Companion;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.input.TextFieldValue.Companion;
import androidx.compose.ui.unit.Dp;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\u001ad\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\n2#\u0010\u000b\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\u000c\u0008\r\u0012\u0008\u0008\u000e\u0012\u0004\u0008\u0008(\u000f\u0012\u0004\u0012\u00020\u00080\u000c2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\u0010\u001a\u001a\u0098\u0001\u0010\u001b\u001a\u00020\u00082\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00080\u000c2\u0006\u0010\u0010\u001a\u00020\u00112\u0013\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u0008\u0018\u00010 ¢\u0006\u0002\u0008!2\u0013\u0010\"\u001a\u000f\u0012\u0004\u0012\u00020\u0008\u0018\u00010 ¢\u0006\u0002\u0008!2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\n\u0010)\u001a\u00060*j\u0002`+2\u0006\u0010\u0018\u001a\u00020\u0019H\u0001ø\u0001\u0000¢\u0006\u0004\u0008,\u0010-\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0003\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006.²\u0006\n\u0010/\u001a\u000200X\u008a\u008e\u0002", d2 = {"InputTextFieldPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "getInputTextFieldPadding", "()Landroidx/compose/foundation/layout/PaddingValues;", "InputTextNonErroneousBottomPadding", "Landroidx/compose/ui/unit/Dp;", "F", "DateInputContent", "", "selectedDateMillis", "", "onDateSelectionChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dateInMillis", "calendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "yearRange", "Lkotlin/ranges/IntRange;", "dateFormatter", "Landroidx/compose/material3/DatePickerFormatter;", "selectableDates", "Landroidx/compose/material3/SelectableDates;", "colors", "Landroidx/compose/material3/DatePickerColors;", "(Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/ranges/IntRange;Landroidx/compose/material3/DatePickerFormatter;Landroidx/compose/material3/SelectableDates;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;I)V", "DateInputTextField", "modifier", "Landroidx/compose/ui/Modifier;", "initialDateMillis", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "inputIdentifier", "Landroidx/compose/material3/InputIdentifier;", "dateInputValidator", "Landroidx/compose/material3/DateInputValidator;", "dateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "DateInputTextField-tQNruF0", "(Landroidx/compose/ui/Modifier;Ljava/lang/Long;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/internal/CalendarModel;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ILandroidx/compose/material3/DateInputValidator;Landroidx/compose/material3/internal/DateInputFormat;Ljava/util/Locale;Landroidx/compose/material3/DatePickerColors;Landroidx/compose/runtime/Composer;II)V", "material3_release", "text", "Landroidx/compose/ui/text/input/TextFieldValue;"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class DateInputKt {

    private static final PaddingValues InputTextFieldPadding;
    private static final float InputTextNonErroneousBottomPadding;
    static {
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        DateInputKt.InputTextFieldPadding = PaddingKt.PaddingValues-a9UjIt4$default(Dp.constructor-impl((float)i), Dp.constructor-impl((float)$this$dp$iv2), Dp.constructor-impl((float)$this$dp$iv), 0, 8, 0);
        int i6 = 0;
        DateInputKt.InputTextNonErroneousBottomPadding = Dp.constructor-impl((float)i2);
    }

    public static final void DateInputContent(Long selectedDateMillis, Function1<? super Long, Unit> onDateSelectionChange, CalendarModel calendarModel, IntRange yearRange, androidx.compose.material3.DatePickerFormatter dateFormatter, androidx.compose.material3.SelectableDates selectableDates, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed) {
        int traceInProgress2;
        Composer errorInvalidNotAllowed2;
        Object obj2;
        int $composer4;
        Composer composer3;
        Composer errorDatePattern;
        Object obj6;
        int i6;
        Object labelText;
        int $dirty;
        int i7;
        Object singleDateInput-J2x2o4M;
        int i11;
        int i2;
        Object dateInputValidator;
        Object obj;
        Object obj4;
        int i5;
        int i;
        Object obj3;
        boolean changedInstance;
        Object empty2;
        Object dateInputFormat;
        int $composer3;
        Object errorInvalidNotAllowed;
        int i4;
        Object str2;
        int i10;
        boolean skipping;
        boolean traceInProgress;
        int defaultLocale;
        int i3;
        Composer $this$cache$iv;
        int errorDateOutOfYearRange;
        String str3;
        int empty;
        String str;
        String str5;
        String str4;
        int m3c_date_input_invalid_not_allowed;
        int i8;
        int i9;
        int $composer2;
        Object obj5;
        Composer composer;
        Composer composer2;
        Locale obj32;
        obj2 = selectedDateMillis;
        obj6 = calendarModel;
        obj4 = dateFormatter;
        traceInProgress2 = $changed;
        $composer4 = 643325609;
        labelText = $composer.startRestartGroup($composer4);
        ComposerKt.sourceInformation(labelText, "C(DateInputContent)P(5,3!1,6,2,4)62@2605L15,64@2655L75,65@2758L45,66@2838L44,67@2916L45,69@2999L551,82@3639L42,86@3836L164,92@4024L62,83@3686L901:DateInput.kt#uh7d8r");
        if (traceInProgress2 & 6 == 0) {
            i7 = labelText.changed(obj2) ? 4 : 2;
            $dirty |= i7;
        }
        if (traceInProgress2 & 48 == 0) {
            i11 = labelText.changedInstance(onDateSelectionChange) ? 32 : 16;
            $dirty |= i11;
        } else {
            singleDateInput-J2x2o4M = onDateSelectionChange;
        }
        if (traceInProgress2 & 384 == 0) {
            i2 = labelText.changedInstance(obj6) ? 256 : 128;
            $dirty |= i2;
        }
        if (traceInProgress2 & 3072 == 0) {
            i5 = labelText.changedInstance(yearRange) ? 2048 : 1024;
            $dirty |= i5;
        } else {
            dateInputValidator = yearRange;
        }
        $composer3 = 32768;
        if (traceInProgress2 & 24576 == 0) {
            if (traceInProgress2 & $composer3 == 0) {
                changedInstance = labelText.changed(obj4);
            } else {
                changedInstance = labelText.changedInstance(obj4);
            }
            i = changedInstance != null ? 16384 : 8192;
            $dirty |= i;
        }
        if (i19 &= traceInProgress2 == 0) {
            i4 = labelText.changed(selectableDates) ? 131072 : 65536;
            $dirty |= i4;
        } else {
            obj3 = selectableDates;
        }
        if (i40 &= traceInProgress2 == 0) {
            i10 = labelText.changed(colors) ? 1048576 : 524288;
            $dirty |= i10;
        } else {
            str2 = colors;
        }
        if (i43 &= $dirty == 599186) {
            if (!labelText.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart($composer4, $dirty, -1, "androidx.compose.material3.DateInputContent (DateInput.kt:60)");
                }
                Locale defaultLocale2 = CalendarLocale_androidKt.defaultLocale(labelText, 0);
                String str8 = "CC(remember):DateInput.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(labelText, 1825155115, str8);
                obj32 = labelText;
                int i46 = 0;
                Object rememberedValue = obj32.rememberedValue();
                int i51 = 0;
                if (!labelText.changed(defaultLocale2)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i35 = 0;
                        obj32.updateRememberedValue(obj6.getDateInputFormat(defaultLocale2));
                    } else {
                        composer3 = obj32;
                        dateInputFormat = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(labelText);
                androidx.compose.material3.internal.Strings.Companion companion = Strings.Companion;
                int i36 = 0;
                int i37 = 0;
                String string-2EP1pXo2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_invalid_for_pattern), labelText, i37);
                androidx.compose.material3.internal.Strings.Companion companion5 = Strings.Companion;
                int i47 = 0;
                String string-2EP1pXo4 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_invalid_year_range), labelText, i37);
                androidx.compose.material3.internal.Strings.Companion companion7 = Strings.Companion;
                int i52 = 0;
                String string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_invalid_not_allowed), labelText, i37);
                ComposerKt.sourceInformationMarkerStart(labelText, 1825166599, str8);
                if (i45 &= $dirty != 16384) {
                    if ($dirty & i49 != 0 && labelText.changed(obj4)) {
                        if (labelText.changed(obj4)) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                    } else {
                    }
                } else {
                }
                $this$cache$iv = labelText;
                int i53 = 0;
                errorInvalidNotAllowed = $this$cache$iv.rememberedValue();
                i8 = 0;
                if (changed2 |= i3 == 0) {
                    if (errorInvalidNotAllowed == Composer.Companion.getEmpty()) {
                        i9 = 0;
                        dateInputFormat = string-2EP1pXo4;
                        i6 = i54;
                        obj3 = string-2EP1pXo2;
                        obj5 = errorInvalidNotAllowed;
                        errorDatePattern = composer5;
                        String it$iv = string-2EP1pXo;
                        $composer2 = $dirty;
                        labelText = new DateInputValidator(yearRange, obj3, dateInputFormat, obj4, obj3, dateInputFormat, it$iv, "", 0, 0, 768, 0);
                        errorDateOutOfYearRange = obj3;
                        str3 = dateInputFormat;
                        str = it$iv;
                        $this$cache$iv.updateRememberedValue(labelText);
                    } else {
                        str = string-2EP1pXo;
                        $composer2 = $dirty;
                        obj = dateInputFormat;
                        obj5 = errorInvalidNotAllowed;
                        errorInvalidNotAllowed2 = $this$cache$iv;
                        str3 = string-2EP1pXo4;
                        i6 = 1;
                        errorDateOutOfYearRange = string-2EP1pXo2;
                        errorDatePattern = labelText;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(errorDatePattern);
                String upperCase = obj.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                androidx.compose.material3.internal.Strings.Companion companion2 = Strings.Companion;
                int i13 = 0;
                String string-2EP1pXo3 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_label), errorDatePattern, 0);
                int i21 = 0;
                (DateInputValidator)errorInvalidNotAllowed.setCurrentStartDateMillis$material3_release(obj2);
                DateInputKt.DateInputContent.2 anon = new DateInputKt.DateInputContent.2(string-2EP1pXo3, upperCase);
                int i29 = 54;
                DateInputKt.DateInputContent.3 anon2 = new DateInputKt.DateInputContent.3(upperCase);
                str5 = upperCase;
                str4 = string-2EP1pXo3;
                obj4 = obj;
                Object dateInputFormat2 = errorInvalidNotAllowed;
                Composer dateInputValidator2 = errorDatePattern;
                DateInputKt.DateInputTextField-tQNruF0(PaddingKt.padding(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, i6, 0), DateInputKt.InputTextFieldPadding), obj2, onDateSelectionChange, calendarModel, (Function2)ComposableLambdaKt.rememberComposableLambda(-1819015125, i6, anon, errorDatePattern, i29), (Function2)ComposableLambdaKt.rememberComposableLambda(-564233108, i6, anon2, errorDatePattern, i29), InputIdentifier.Companion.getSingleDateInput-J2x2o4M(), dateInputFormat2, obj4, defaultLocale2, colors, dateInputValidator2, i26 | i34, i27 & 14);
                composer = dateInputValidator2;
                $composer3 = dateInputFormat2;
                dateInputValidator = obj4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                labelText.skipToGroupEnd();
                composer = labelText;
                $composer2 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new DateInputKt.DateInputContent.4(selectedDateMillis, onDateSelectionChange, calendarModel, yearRange, dateFormatter, selectableDates, colors, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final void DateInputTextField-tQNruF0(Modifier modifier, Long initialDateMillis, Function1<? super Long, Unit> onDateSelectionChange, CalendarModel calendarModel, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, int inputIdentifier, androidx.compose.material3.DateInputValidator dateInputValidator, DateInputFormat dateInputFormat, Locale locale, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed, int $changed1) {
        int traceInProgress;
        boolean traceInProgress2;
        int i18;
        Object invalid$iv;
        int i;
        float $this$dp$iv;
        int i3;
        Object rememberComposableLambda;
        Object empty2;
        int $dirty;
        Object obj;
        int $dirty1;
        Object obj2;
        int rememberedValue;
        int i33;
        int empty3;
        Object text$delegate;
        Object obj4;
        int empty;
        int i13;
        int i35;
        Object obj7;
        Object anon;
        TextFieldValue i27;
        Object obj5;
        Object obj6;
        Object obj3;
        int i23;
        int i20;
        int i9;
        int i21;
        int i36;
        Object semantics$default;
        int i8;
        int i24;
        int i28;
        int i37;
        int i11;
        float f;
        Composer composer2;
        int i15;
        int i19;
        int i2;
        Composer.Companion companion;
        int i16;
        boolean changed;
        Function2 function2;
        int i12;
        int i34;
        int i29;
        int i30;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i4;
        Composer.Companion companion2;
        androidx.compose.material3.DateVisualTransformation date;
        KeyboardOptions keyboardOptions;
        int i10;
        int i25;
        int i26;
        int i32;
        int i38;
        int i22;
        androidx.compose.material3.TextFieldColors dateTextFieldColors;
        Composer composer;
        int i5;
        int i14;
        int i31;
        int i6;
        int i17;
        int i7;
        int obj54;
        empty2 = initialDateMillis;
        obj = calendarModel;
        obj4 = dateInputFormat;
        empty = locale;
        final int i66 = $changed;
        rememberComposableLambda = $composer.startRestartGroup(-857008589);
        ComposerKt.sourceInformation(rememberComposableLambda, "C(DateInputTextField)P(8,4,9!1,6,10,5:c#material3.InputIdentifier,3,2,7)122@5091L39,124@5207L488,124@5155L540,142@5766L1458,188@7730L60,191@7875L59,140@5701L2642:DateInput.kt#uh7d8r");
        i33 = 2;
        if (i66 & 6 == 0) {
            i13 = rememberComposableLambda.changed(modifier) ? 4 : i33;
            $dirty |= i13;
        } else {
            obj2 = modifier;
        }
        if (i66 & 48 == 0) {
            i35 = rememberComposableLambda.changed(empty2) ? 32 : 16;
            $dirty |= i35;
        }
        if (i66 & 384 == 0) {
            i21 = rememberComposableLambda.changedInstance(onDateSelectionChange) ? 256 : 128;
            $dirty |= i21;
        } else {
            obj7 = onDateSelectionChange;
        }
        if (i66 & 3072 == 0) {
            i36 = rememberComposableLambda.changedInstance(obj) ? 2048 : 1024;
            $dirty |= i36;
        }
        if (i66 & 24576 == 0) {
            i8 = rememberComposableLambda.changedInstance(label) ? 16384 : 8192;
            $dirty |= i8;
        } else {
            semantics$default = label;
        }
        if (i66 & i84 == 0) {
            i24 = rememberComposableLambda.changedInstance(placeholder) ? 131072 : 65536;
            $dirty |= i24;
        } else {
            obj5 = placeholder;
        }
        if (i66 & i85 == 0) {
            i28 = rememberComposableLambda.changed(inputIdentifier) ? 1048576 : 524288;
            $dirty |= i28;
        } else {
            rememberedValue = inputIdentifier;
        }
        if (i66 & i86 == 0) {
            i15 = rememberComposableLambda.changed(dateInputValidator) ? 8388608 : 4194304;
            $dirty |= i15;
        } else {
            obj6 = dateInputValidator;
        }
        if (i66 & i92 == 0) {
            i19 = rememberComposableLambda.changed(obj4) ? 67108864 : 33554432;
            $dirty |= i19;
        }
        if (i66 & i93 == 0) {
            i2 = rememberComposableLambda.changedInstance(empty) ? 536870912 : 268435456;
            $dirty |= i2;
        }
        if ($changed1 & 6 == 0) {
            i11 = rememberComposableLambda.changed(colors) ? 4 : i33;
            $dirty1 |= i11;
        } else {
            obj3 = colors;
        }
        if ($dirty & i89 == 306783378 && $dirty1 & 3 == i33) {
            if ($dirty1 & 3 == i33) {
                if (!rememberComposableLambda.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-857008589, $dirty, $dirty1, "androidx.compose.material3.DateInputTextField (DateInput.kt:121)");
                    }
                    int i40 = 0;
                    Composer composer9 = rememberComposableLambda;
                    Composer composer7 = composer9;
                    String errorText2 = "CC(remember):DateInput.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(composer7, 236419420, errorText2);
                    i18 = $dirty & 112 == 32 ? 1 : 0;
                    int i103 = 234881024;
                    i3 = $dirty & i103 == 67108864 ? 1 : 0;
                    i44 |= changedInstance2;
                    Composer composer4 = composer7;
                    int i97 = 0;
                    Object rememberedValue3 = composer4.rememberedValue();
                    int i106 = 0;
                    if (i45 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            empty3 = 0;
                            i4 = i45;
                            invalid$iv = new DateInputKt.DateInputTextField.text.2.1(empty2, obj, obj4, empty);
                            composer4.updateRememberedValue((Function0)invalid$iv);
                        } else {
                            i4 = i45;
                            invalid$iv = rememberedValue3;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer7);
                    String str = str3;
                    Object obj8 = obj10;
                    Composer errorText3 = composer7;
                    int i105 = 1;
                    text$delegate = RememberSaveableKt.rememberSaveable(new Object[i40], TextFieldValue.Companion.getSaver(), 0, (Function0)invalid$iv, errorText3, 0, 4);
                    Composer composer6 = errorText3;
                    ComposerKt.sourceInformationMarkerStart(composer6, 236438278, str);
                    i23 = $dirty & i103 == 67108864 ? i105 : 0;
                    Object obj11 = obj8;
                    i = $dirty & 896 == 256 ? i105 : 0;
                    int i104 = 29360128;
                    i20 = $dirty & i104 == 8388608 ? i105 : 0;
                    int i101 = 3670016;
                    i9 = $dirty & i101 == 1048576 ? i105 : 0;
                    Composer composer8 = composer6;
                    int i82 = 0;
                    Object rememberedValue2 = composer8.rememberedValue();
                    int i87 = 0;
                    if (i49 |= changedInstance4 == 0) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            empty2 = 0;
                            obj = obj4;
                            i17 = $dirty1;
                            i7 = companion;
                            $dirty = new DateInputKt.DateInputTextField.1.1(obj, obj11, obj7, obj, dateInputValidator, rememberedValue, empty, text$delegate);
                            obj4 = obj;
                            composer8.updateRememberedValue((Function1)$dirty);
                        } else {
                            i7 = $dirty;
                            i17 = $dirty1;
                            obj7 = text$delegate;
                            $dirty1 = obj11;
                            $dirty = rememberedValue2;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    if (!StringsKt.isBlank((CharSequence)$dirty1.getValue())) {
                        empty2 = 0;
                        f = $this$dp$iv;
                    } else {
                        f = $this$dp$iv;
                    }
                    Composer composer3 = composer6;
                    ComposerKt.sourceInformationMarkerStart(composer3, 236499728, str);
                    Composer composer5 = composer3;
                    int i61 = 0;
                    rememberedValue = composer5.rememberedValue();
                    i33 = 0;
                    if (!composer3.changed($dirty1)) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            empty = 0;
                            anon = new DateInputKt.DateInputTextField.2.1($dirty1);
                            composer5.updateRememberedValue((Function1)anon);
                        } else {
                            anon = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    int i58 = 1;
                    DateInputKt.DateInputTextField.3 anon2 = new DateInputKt.DateInputTextField.3($dirty1);
                    DateVisualTransformation dateVisualTransformation = new DateVisualTransformation(obj4);
                    i38 = 0;
                    i22 = 0;
                    keyboardOptions = new KeyboardOptions(0, false, KeyboardType.Companion.getNumber-PjHm6EE(), ImeAction.Companion.getDone-eUduSuo(), i38, i22, 0, 113, 0);
                    composer = composer3;
                    OutlinedTextFieldKt.OutlinedTextField(DateInputKt.DateInputTextField_tQNruF0$lambda$4(text$delegate), (Function1)$dirty, SemanticsModifierKt.semantics$default(PaddingKt.padding-qDBjuR0$default(modifier, 0, 0, 0, f, 7, 0), false, (Function1)anon, i58, 0), false, false, 0, label, placeholder, 0, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-591991974, i58, anon2, composer3, 54), blank2 ^ 1, (VisualTransformation)dateVisualTransformation, keyboardOptions, 0, true, 0, 0, i38, i22, colors.getDateTextFieldColors(), composer, empty2 | obj, 12779904, 0, 4001592);
                    composer2 = composer;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    rememberComposableLambda.skipToGroupEnd();
                    composer2 = rememberComposableLambda;
                    i7 = $dirty;
                    i17 = $dirty1;
                }
            } else {
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new DateInputKt.DateInputTextField.4(modifier, initialDateMillis, onDateSelectionChange, calendarModel, label, placeholder, inputIdentifier, dateInputValidator, obj4, locale, colors, i66, $changed1);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final TextFieldValue DateInputTextField_tQNruF0$lambda$4(MutableState<TextFieldValue> $text$delegate) {
        final int i2 = i;
        final int i3 = 0;
        return (TextFieldValue)(State)$text$delegate.getValue();
    }

    private static final void DateInputTextField_tQNruF0$lambda$5(MutableState<TextFieldValue> $text$delegate, TextFieldValue value) {
        final int i2 = i;
        final int i3 = 0;
        $text$delegate.setValue(value);
    }

    public static final void access$DateInputTextField_tQNruF0$lambda$5(MutableState $text$delegate, TextFieldValue value) {
        DateInputKt.DateInputTextField_tQNruF0$lambda$5($text$delegate, value);
    }

    public static final PaddingValues getInputTextFieldPadding() {
        return DateInputKt.InputTextFieldPadding;
    }
}
