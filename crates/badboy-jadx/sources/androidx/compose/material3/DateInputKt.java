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
        int traceInProgress;
        Composer errorInvalidNotAllowed;
        Object obj;
        int $composer3;
        Composer composer3;
        Composer errorDatePattern;
        Object obj4;
        int i8;
        Object labelText;
        int $dirty;
        int i10;
        Object singleDateInput-J2x2o4M;
        int i6;
        int i5;
        Object dateInputValidator;
        Object obj2;
        Object obj5;
        int i;
        int i9;
        Object obj3;
        boolean changedInstance;
        Object empty;
        Object dateInputFormat;
        int $composer2;
        Object errorInvalidNotAllowed2;
        int i11;
        Object str3;
        int i7;
        boolean skipping;
        boolean traceInProgress2;
        int defaultLocale;
        int i2;
        Composer $this$cache$iv;
        int errorDateOutOfYearRange;
        String str;
        int empty2;
        String str4;
        String str5;
        String str2;
        int m3c_date_input_invalid_not_allowed;
        int i4;
        int i3;
        int $composer4;
        Object obj6;
        Composer composer;
        Composer composer2;
        Locale obj32;
        obj = selectedDateMillis;
        obj4 = calendarModel;
        obj5 = dateFormatter;
        traceInProgress = $changed;
        $composer3 = 643325609;
        labelText = $composer.startRestartGroup($composer3);
        ComposerKt.sourceInformation(labelText, "C(DateInputContent)P(5,3!1,6,2,4)62@2605L15,64@2655L75,65@2758L45,66@2838L44,67@2916L45,69@2999L551,82@3639L42,86@3836L164,92@4024L62,83@3686L901:DateInput.kt#uh7d8r");
        if (traceInProgress & 6 == 0) {
            i10 = labelText.changed(obj) ? 4 : 2;
            $dirty |= i10;
        }
        if (traceInProgress & 48 == 0) {
            i6 = labelText.changedInstance(onDateSelectionChange) ? 32 : 16;
            $dirty |= i6;
        } else {
            singleDateInput-J2x2o4M = onDateSelectionChange;
        }
        if (traceInProgress & 384 == 0) {
            i5 = labelText.changedInstance(obj4) ? 256 : 128;
            $dirty |= i5;
        }
        if (traceInProgress & 3072 == 0) {
            i = labelText.changedInstance(yearRange) ? 2048 : 1024;
            $dirty |= i;
        } else {
            dateInputValidator = yearRange;
        }
        $composer2 = 32768;
        if (traceInProgress & 24576 == 0) {
            if (traceInProgress & $composer2 == 0) {
                changedInstance = labelText.changed(obj5);
            } else {
                changedInstance = labelText.changedInstance(obj5);
            }
            i9 = changedInstance != null ? 16384 : 8192;
            $dirty |= i9;
        }
        if (i18 &= traceInProgress == 0) {
            i11 = labelText.changed(selectableDates) ? 131072 : 65536;
            $dirty |= i11;
        } else {
            obj3 = selectableDates;
        }
        if (i38 &= traceInProgress == 0) {
            i7 = labelText.changed(colors) ? 1048576 : 524288;
            $dirty |= i7;
        } else {
            str3 = colors;
        }
        if (i41 &= $dirty == 599186) {
            if (!labelText.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart($composer3, $dirty, -1, "androidx.compose.material3.DateInputContent (DateInput.kt:60)");
                }
                Locale defaultLocale2 = CalendarLocale_androidKt.defaultLocale(labelText, 0);
                String str8 = "CC(remember):DateInput.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(labelText, 1825155115, str8);
                obj32 = labelText;
                int i44 = 0;
                Object rememberedValue = obj32.rememberedValue();
                int i49 = 0;
                if (!labelText.changed(defaultLocale2)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i34 = 0;
                        obj32.updateRememberedValue(obj4.getDateInputFormat(defaultLocale2));
                    } else {
                        composer3 = obj32;
                        dateInputFormat = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(labelText);
                androidx.compose.material3.internal.Strings.Companion companion = Strings.Companion;
                int i35 = 0;
                int $i$f$getDateInputInvalidForPattern8iCLdWM = 0;
                String string-2EP1pXo2 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_invalid_for_pattern), labelText, $i$f$getDateInputInvalidForPattern8iCLdWM);
                androidx.compose.material3.internal.Strings.Companion companion5 = Strings.Companion;
                int i45 = 0;
                String string-2EP1pXo4 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_invalid_year_range), labelText, $i$f$getDateInputInvalidForPattern8iCLdWM);
                androidx.compose.material3.internal.Strings.Companion companion7 = Strings.Companion;
                int i50 = 0;
                String string-2EP1pXo = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_invalid_not_allowed), labelText, $i$f$getDateInputInvalidForPattern8iCLdWM);
                ComposerKt.sourceInformationMarkerStart(labelText, 1825166599, str8);
                if (i43 &= $dirty != 16384) {
                    if ($dirty & i47 != 0 && labelText.changed(obj5)) {
                        if (labelText.changed(obj5)) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                    } else {
                    }
                } else {
                }
                $this$cache$iv = labelText;
                int i51 = 0;
                errorInvalidNotAllowed2 = $this$cache$iv.rememberedValue();
                i4 = 0;
                if (changed2 |= i2 == 0) {
                    if (errorInvalidNotAllowed2 == Composer.Companion.getEmpty()) {
                        i3 = 0;
                        dateInputFormat = string-2EP1pXo4;
                        i8 = i52;
                        obj3 = string-2EP1pXo2;
                        obj6 = errorInvalidNotAllowed2;
                        errorDatePattern = composer5;
                        String it$iv = string-2EP1pXo;
                        $composer4 = $dirty;
                        labelText = new DateInputValidator(yearRange, obj3, dateInputFormat, obj5, obj3, dateInputFormat, it$iv, "", 0, 0, 768, 0);
                        errorDateOutOfYearRange = obj3;
                        str = dateInputFormat;
                        str4 = it$iv;
                        $this$cache$iv.updateRememberedValue(labelText);
                    } else {
                        str4 = string-2EP1pXo;
                        $composer4 = $dirty;
                        obj2 = dateInputFormat;
                        obj6 = errorInvalidNotAllowed2;
                        errorInvalidNotAllowed = $this$cache$iv;
                        str = string-2EP1pXo4;
                        i8 = 1;
                        errorDateOutOfYearRange = string-2EP1pXo2;
                        errorDatePattern = labelText;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(errorDatePattern);
                String upperCase = obj2.getPatternWithDelimiters().toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                androidx.compose.material3.internal.Strings.Companion companion2 = Strings.Companion;
                int i13 = 0;
                String string-2EP1pXo3 = Strings_androidKt.getString-2EP1pXo(Strings.constructor-impl(R.string.m3c_date_input_label), errorDatePattern, 0);
                int i20 = 0;
                (DateInputValidator)errorInvalidNotAllowed2.setCurrentStartDateMillis$material3_release(obj);
                DateInputKt.DateInputContent.2 anon = new DateInputKt.DateInputContent.2(string-2EP1pXo3, upperCase);
                int i28 = 54;
                DateInputKt.DateInputContent.3 anon2 = new DateInputKt.DateInputContent.3(upperCase);
                str5 = upperCase;
                str2 = string-2EP1pXo3;
                obj5 = obj2;
                Object dateInputFormat2 = errorInvalidNotAllowed2;
                Composer dateInputValidator2 = errorDatePattern;
                DateInputKt.DateInputTextField-tQNruF0(PaddingKt.padding(SizeKt.fillMaxWidth$default((Modifier)Modifier.Companion, 0, i8, 0), DateInputKt.InputTextFieldPadding), obj, onDateSelectionChange, calendarModel, (Function2)ComposableLambdaKt.rememberComposableLambda(-1819015125, i8, anon, errorDatePattern, i28), (Function2)ComposableLambdaKt.rememberComposableLambda(-564233108, i8, anon2, errorDatePattern, i28), InputIdentifier.Companion.getSingleDateInput-J2x2o4M(), dateInputFormat2, obj5, defaultLocale2, colors, dateInputValidator2, i25 | i33, i26 & 14);
                composer = dateInputValidator2;
                $composer2 = dateInputFormat2;
                dateInputValidator = obj5;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                labelText.skipToGroupEnd();
                composer = labelText;
                $composer4 = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new DateInputKt.DateInputContent.4(selectedDateMillis, onDateSelectionChange, calendarModel, yearRange, dateFormatter, selectableDates, colors, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final void DateInputTextField-tQNruF0(Modifier modifier, Long initialDateMillis, Function1<? super Long, Unit> onDateSelectionChange, CalendarModel calendarModel, Function2<? super Composer, ? super Integer, Unit> label, Function2<? super Composer, ? super Integer, Unit> placeholder, int inputIdentifier, androidx.compose.material3.DateInputValidator dateInputValidator, DateInputFormat dateInputFormat, Locale locale, androidx.compose.material3.DatePickerColors colors, Composer $composer, int $changed, int $changed1) {
        int traceInProgress2;
        boolean traceInProgress;
        int i33;
        Object invalid$iv;
        int i13;
        float $this$dp$iv;
        int i9;
        Object rememberComposableLambda;
        Object empty;
        int $dirty;
        Object obj;
        int $dirty1;
        Object obj6;
        int rememberedValue;
        int i29;
        int empty2;
        Object text$delegate;
        Object obj2;
        int empty3;
        int i4;
        int i19;
        Object obj4;
        Object anon;
        TextFieldValue i30;
        Object obj3;
        Object obj7;
        Object obj5;
        int i34;
        int i24;
        int i10;
        int i20;
        int i37;
        Object semantics$default;
        int i;
        int i5;
        int i14;
        int i18;
        int i25;
        float f;
        Composer composer;
        int i23;
        int i2;
        int i17;
        Composer.Companion companion;
        int i26;
        boolean changed;
        Function2 function2;
        int i7;
        int i21;
        int i32;
        int i36;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        int i8;
        Composer.Companion companion2;
        androidx.compose.material3.DateVisualTransformation date;
        KeyboardOptions keyboardOptions;
        int i22;
        int i11;
        int i27;
        int i15;
        int i31;
        int i3;
        androidx.compose.material3.TextFieldColors dateTextFieldColors;
        Composer composer2;
        int i16;
        int i35;
        int i38;
        int i28;
        int i6;
        int i12;
        int obj54;
        empty = initialDateMillis;
        obj = calendarModel;
        obj2 = dateInputFormat;
        empty3 = locale;
        final int i66 = $changed;
        rememberComposableLambda = $composer.startRestartGroup(-857008589);
        ComposerKt.sourceInformation(rememberComposableLambda, "C(DateInputTextField)P(8,4,9!1,6,10,5:c#material3.InputIdentifier,3,2,7)122@5091L39,124@5207L488,124@5155L540,142@5766L1458,188@7730L60,191@7875L59,140@5701L2642:DateInput.kt#uh7d8r");
        i29 = 2;
        if (i66 & 6 == 0) {
            i4 = rememberComposableLambda.changed(modifier) ? 4 : i29;
            $dirty |= i4;
        } else {
            obj6 = modifier;
        }
        if (i66 & 48 == 0) {
            i19 = rememberComposableLambda.changed(empty) ? 32 : 16;
            $dirty |= i19;
        }
        if (i66 & 384 == 0) {
            i20 = rememberComposableLambda.changedInstance(onDateSelectionChange) ? 256 : 128;
            $dirty |= i20;
        } else {
            obj4 = onDateSelectionChange;
        }
        if (i66 & 3072 == 0) {
            i37 = rememberComposableLambda.changedInstance(obj) ? 2048 : 1024;
            $dirty |= i37;
        }
        if (i66 & 24576 == 0) {
            i = rememberComposableLambda.changedInstance(label) ? 16384 : 8192;
            $dirty |= i;
        } else {
            semantics$default = label;
        }
        if (i66 & i84 == 0) {
            i5 = rememberComposableLambda.changedInstance(placeholder) ? 131072 : 65536;
            $dirty |= i5;
        } else {
            obj3 = placeholder;
        }
        if (i66 & i85 == 0) {
            i14 = rememberComposableLambda.changed(inputIdentifier) ? 1048576 : 524288;
            $dirty |= i14;
        } else {
            rememberedValue = inputIdentifier;
        }
        if (i66 & i86 == 0) {
            i23 = rememberComposableLambda.changed(dateInputValidator) ? 8388608 : 4194304;
            $dirty |= i23;
        } else {
            obj7 = dateInputValidator;
        }
        if (i66 & i92 == 0) {
            i2 = rememberComposableLambda.changed(obj2) ? 67108864 : 33554432;
            $dirty |= i2;
        }
        if (i66 & i93 == 0) {
            i17 = rememberComposableLambda.changedInstance(empty3) ? 536870912 : 268435456;
            $dirty |= i17;
        }
        if ($changed1 & 6 == 0) {
            i25 = rememberComposableLambda.changed(colors) ? 4 : i29;
            $dirty1 |= i25;
        } else {
            obj5 = colors;
        }
        if ($dirty & i89 == 306783378 && $dirty1 & 3 == i29) {
            if ($dirty1 & 3 == i29) {
                if (!rememberComposableLambda.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-857008589, $dirty, $dirty1, "androidx.compose.material3.DateInputTextField (DateInput.kt:121)");
                    }
                    int i40 = 0;
                    Composer composer9 = rememberComposableLambda;
                    Composer composer7 = composer9;
                    String errorText2 = "CC(remember):DateInput.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(composer7, 236419420, errorText2);
                    i33 = $dirty & 112 == 32 ? 1 : 0;
                    int i103 = 234881024;
                    i9 = $dirty & i103 == 67108864 ? 1 : 0;
                    i44 |= changedInstance2;
                    Composer composer4 = composer7;
                    int i97 = 0;
                    Object rememberedValue3 = composer4.rememberedValue();
                    int i106 = 0;
                    if (i45 == 0) {
                        if (rememberedValue3 == Composer.Companion.getEmpty()) {
                            empty2 = 0;
                            i8 = i45;
                            invalid$iv = new DateInputKt.DateInputTextField.text.2.1(empty, obj, obj2, empty3);
                            composer4.updateRememberedValue((Function0)invalid$iv);
                        } else {
                            i8 = i45;
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
                    i34 = $dirty & i103 == 67108864 ? i105 : 0;
                    Object obj11 = obj8;
                    i13 = $dirty & 896 == 256 ? i105 : 0;
                    int i104 = 29360128;
                    i24 = $dirty & i104 == 8388608 ? i105 : 0;
                    int i101 = 3670016;
                    i10 = $dirty & i101 == 1048576 ? i105 : 0;
                    Composer composer8 = composer6;
                    int i82 = 0;
                    Object rememberedValue2 = composer8.rememberedValue();
                    int i87 = 0;
                    if (i49 |= changedInstance4 == 0) {
                        if (rememberedValue2 == Composer.Companion.getEmpty()) {
                            empty = 0;
                            obj = obj2;
                            i6 = $dirty1;
                            i12 = companion;
                            $dirty = new DateInputKt.DateInputTextField.1.1(obj, obj11, obj4, obj, dateInputValidator, rememberedValue, empty3, text$delegate);
                            obj2 = obj;
                            composer8.updateRememberedValue((Function1)$dirty);
                        } else {
                            i12 = $dirty;
                            i6 = $dirty1;
                            obj4 = text$delegate;
                            $dirty1 = obj11;
                            $dirty = rememberedValue2;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer6);
                    if (!StringsKt.isBlank((CharSequence)$dirty1.getValue())) {
                        empty = 0;
                        f = $this$dp$iv;
                    } else {
                        f = $this$dp$iv;
                    }
                    Composer composer3 = composer6;
                    ComposerKt.sourceInformationMarkerStart(composer3, 236499728, str);
                    Composer composer5 = composer3;
                    int i61 = 0;
                    rememberedValue = composer5.rememberedValue();
                    i29 = 0;
                    if (!composer3.changed($dirty1)) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            empty3 = 0;
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
                    DateVisualTransformation dateVisualTransformation = new DateVisualTransformation(obj2);
                    i31 = 0;
                    i3 = 0;
                    keyboardOptions = new KeyboardOptions(0, false, KeyboardType.Companion.getNumber-PjHm6EE(), ImeAction.Companion.getDone-eUduSuo(), i31, i3, 0, 113, 0);
                    composer2 = composer3;
                    OutlinedTextFieldKt.OutlinedTextField(DateInputKt.DateInputTextField_tQNruF0$lambda$4(text$delegate), (Function1)$dirty, SemanticsModifierKt.semantics$default(PaddingKt.padding-qDBjuR0$default(modifier, 0, 0, 0, f, 7, 0), false, (Function1)anon, i58, 0), false, false, 0, label, placeholder, 0, 0, 0, 0, (Function2)ComposableLambdaKt.rememberComposableLambda(-591991974, i58, anon2, composer3, 54), blank2 ^ 1, (VisualTransformation)dateVisualTransformation, keyboardOptions, 0, true, 0, 0, i31, i3, colors.getDateTextFieldColors(), composer2, empty | obj, 12779904, 0, 4001592);
                    composer = composer2;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    rememberComposableLambda.skipToGroupEnd();
                    composer = rememberComposableLambda;
                    i12 = $dirty;
                    i6 = $dirty1;
                }
            } else {
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = composer.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new DateInputKt.DateInputTextField.4(modifier, initialDateMillis, onDateSelectionChange, calendarModel, label, placeholder, inputIdentifier, dateInputValidator, obj2, locale, colors, i66, $changed1);
            endRestartGroup.updateScope((Function2)traceInProgress2);
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
