package androidx.compose.foundation.text;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.input.InputTransformation;
import androidx.compose.foundation.text.input.InputTransformationKt;
import androidx.compose.foundation.text.input.KeyboardActionHandler;
import androidx.compose.foundation.text.input.TextFieldDecorator;
import androidx.compose.foundation.text.input.TextFieldState;
import androidx.compose.foundation.text.input.TextObfuscationMode;
import androidx.compose.foundation.text.input.TextObfuscationMode.Companion;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyle.Companion;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000~\n\u0000\n\u0002\u0010\u000c\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001aÊ\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t2\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u001328\u0008\u0002\u0010\u0014\u001a2\u0012\u0004\u0012\u00020\u0016\u0012\u001b\u0012\u0019\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017¢\u0006\u000c\u0008\u0019\u0012\u0008\u0008\u001a\u0012\u0004\u0008\u0008(\u001b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015¢\u0006\u0002\u0008\u001c2\n\u0008\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0008\u0002\u0010\u001f\u001a\u00020 2\n\u0008\u0002\u0010!\u001a\u0004\u0018\u00010\"2\u0008\u0008\u0002\u0010#\u001a\u00020$2\u0008\u0008\u0002\u0010%\u001a\u00020\u0001H\u0007ø\u0001\u0000¢\u0006\u0004\u0008&\u0010'\u001a \u0010(\u001a\u00020\u00052\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\u00050\u0017¢\u0006\u0002\u0008*H\u0003¢\u0006\u0002\u0010+\u001a\u001a\u0010,\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\r2\u0008\u0010-\u001a\u0004\u0018\u00010\rH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006.", d2 = {"DefaultObfuscationCharacter", "", "LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS", "", "BasicSecureTextField", "", "state", "Landroidx/compose/foundation/text/input/TextFieldState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "onKeyboardAction", "Landroidx/compose/foundation/text/input/KeyboardActionHandler;", "onTextLayout", "Lkotlin/Function2;", "Landroidx/compose/ui/unit/Density;", "Lkotlin/Function0;", "Landroidx/compose/ui/text/TextLayoutResult;", "Lkotlin/ParameterName;", "name", "getResult", "Lkotlin/ExtensionFunctionType;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "decorator", "Landroidx/compose/foundation/text/input/TextFieldDecorator;", "textObfuscationMode", "Landroidx/compose/foundation/text/input/TextObfuscationMode;", "textObfuscationCharacter", "BasicSecureTextField-Jb9bMDk", "(Landroidx/compose/foundation/text/input/TextFieldState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/text/input/InputTransformation;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/input/KeyboardActionHandler;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/foundation/text/input/TextFieldDecorator;ICLandroidx/compose/runtime/Composer;III)V", "DisableCutCopy", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "then", "next", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BasicSecureTextFieldKt {

    private static final char DefaultObfuscationCharacter = '\u2022';
    private static final long LAST_TYPED_CHARACTER_REVEAL_DURATION_MILLIS = 1500L;
    public static int $r8$lambda$ShVNXLfYsIg4yN1T-sRtbIu2dBU(State state, int i2, int i3) {
        return BasicSecureTextFieldKt.BasicSecureTextField_Jb9bMDk$lambda$4$lambda$3(state, i2, i3);
    }

    public static final void BasicSecureTextField-Jb9bMDk(TextFieldState state, Modifier modifier, boolean enabled, InputTransformation inputTransformation, TextStyle textStyle, androidx.compose.foundation.text.KeyboardOptions keyboardOptions, KeyboardActionHandler onKeyboardAction, Function2<? super Density, ? super Function0<TextLayoutResult>, Unit> onTextLayout, MutableInteractionSource interactionSource, Brush cursorBrush, TextFieldDecorator decorator, int textObfuscationMode, char textObfuscationCharacter, Composer $composer, int $changed, int $changed1, int i17) {
        int i27;
        char c;
        int skipping;
        Object modifier3;
        Composer modifier2;
        int textObfuscationMode2;
        boolean enabled2;
        ScopeUpdateScope endRestartGroup;
        Object i28;
        Object obj2;
        Object obj3;
        Object obj;
        int textObfuscationCharacter2;
        Object it$iv3;
        int codepointTransformation;
        Object obj7;
        boolean $composer3;
        int $dirty3;
        Composer $this$cache$iv;
        Object it$iv2;
        Object $dirty;
        int $dirty12;
        Object it$iv;
        int i13;
        Modifier focusChangeModifier;
        Object $dirty13;
        Object empty;
        Composer composer;
        Object obj4;
        boolean z2;
        Object inputTransformation2;
        int i16;
        Object z;
        Object textStyle2;
        int i3;
        int i8;
        Object keyboardOptions2;
        int i14;
        Object obj6;
        int onKeyboardAction2;
        SolidColor solidColor;
        Object obj5;
        int i30;
        Object solidColor2;
        boolean traceInProgress;
        int i20;
        int i7;
        int companion3;
        int i24;
        int i4;
        int i31;
        androidx.compose.foundation.text.BasicSecureTextFieldKt.BasicSecureTextField.3 $composer2;
        int companion2;
        TextFieldState i34;
        Composer composer2;
        int i9;
        Composer.Companion companion;
        Modifier then;
        int $dirty2;
        int i18;
        int i11;
        int i32;
        boolean i10;
        int i33;
        int i2;
        int i25;
        Object secureTextFieldController;
        int i21;
        int i6;
        Object i26;
        int i;
        int i23;
        int i5;
        int i29;
        int i12;
        int i15;
        int i19;
        int changedInstance;
        int i22;
        int $dirty1;
        ScopeUpdateScope scopeUpdateScope;
        boolean obj34;
        boolean obj36;
        int obj37;
        Object obj38;
        int obj39;
        Object obj40;
        int obj41;
        int obj46;
        Object obj8 = decorator;
        final int i73 = $changed;
        final int i74 = $changed1;
        int i38 = i17;
        Composer restartGroup = $composer.startRestartGroup(1399310985);
        ComposerKt.sourceInformation(restartGroup, "C(BasicSecureTextField)P(9,6,2,3,12,5,7,8,4!2,11:c#foundation.text.input.TextObfuscationMode)131@7694L46,132@7777L60,133@7884L130,133@7842L172,144@8392L129,144@8353L168,150@8557L384,176@9335L825,176@9320L840:BasicSecureTextField.kt#423gt5");
        $dirty3 = $changed;
        $dirty12 = $changed1;
        if (i38 & 1 != 0) {
            $dirty3 |= 6;
            empty = state;
        } else {
            if (i73 & 6 == 0) {
                i8 = restartGroup.changed(state) ? 4 : 2;
                $dirty3 |= i8;
            } else {
                empty = state;
            }
        }
        int i63 = i38 & 2;
        if (i63 != 0) {
            $dirty3 |= 48;
            solidColor2 = modifier;
        } else {
            if (i73 & 48 == 0) {
                i7 = restartGroup.changed(modifier) ? 32 : 16;
                $dirty3 |= i7;
            } else {
                solidColor2 = modifier;
            }
        }
        companion3 = i38 & 4;
        i34 = 128;
        if (companion3 != 0) {
            $dirty3 |= 384;
            z2 = enabled;
        } else {
            if (i73 & 384 == 0) {
                i9 = restartGroup.changed(enabled) ? i4 : i34;
                $dirty3 |= i9;
            } else {
                z2 = enabled;
            }
        }
        then = i38 & 8;
        if (then != 0) {
            $dirty3 |= 3072;
            z = inputTransformation;
        } else {
            if (i73 & 3072 == 0) {
                i32 = restartGroup.changed(inputTransformation) ? 2048 : 1024;
                $dirty3 |= i32;
            } else {
                z = inputTransformation;
            }
        }
        i10 = i38 & 16;
        if (i10 != 0) {
            $dirty3 |= 24576;
            obj6 = textStyle;
        } else {
            if (i73 & 24576 == 0) {
                i25 = restartGroup.changed(textStyle) ? 16384 : 8192;
                $dirty3 |= i25;
            } else {
                obj6 = textStyle;
            }
        }
        secureTextFieldController = i38 & 32;
        i21 = 196608;
        if (secureTextFieldController != 0) {
            $dirty3 |= i21;
            obj5 = keyboardOptions;
        } else {
            if (i73 & i21 == 0) {
                i6 = restartGroup.changed(keyboardOptions) ? 131072 : 65536;
                $dirty3 |= i6;
            } else {
                obj5 = keyboardOptions;
            }
        }
        i26 = i38 & 64;
        i = 1572864;
        if (i26 != 0) {
            $dirty3 |= i;
            i28 = onKeyboardAction;
        } else {
            if (i73 & i == 0) {
                i23 = restartGroup.changed(onKeyboardAction) ? 1048576 : 524288;
                $dirty3 |= i23;
            } else {
                i28 = onKeyboardAction;
            }
        }
        int i40 = i38 & 128;
        int i82 = 12582912;
        if (i40 != 0) {
            $dirty3 |= i82;
            i5 = i40;
            obj2 = onTextLayout;
        } else {
            if (i73 & i82 == 0) {
                i5 = i40;
                i29 = restartGroup.changedInstance(onTextLayout) ? 8388608 : 4194304;
                $dirty3 |= i29;
            } else {
                i5 = i40;
                obj2 = onTextLayout;
            }
        }
        int i41 = i38 & 256;
        int i84 = 100663296;
        if (i41 != 0) {
            $dirty3 |= i84;
            i12 = i41;
            obj3 = interactionSource;
        } else {
            if (i73 & i84 == 0) {
                i12 = i41;
                i15 = restartGroup.changed(interactionSource) ? 67108864 : 33554432;
                $dirty3 |= i15;
            } else {
                i12 = i41;
                obj3 = interactionSource;
            }
        }
        int i42 = i38 & 512;
        int i86 = 805306368;
        if (i42 != 0) {
            $dirty3 |= i86;
            i19 = i42;
            obj = cursorBrush;
        } else {
            if (i73 & i86 == 0) {
                i19 = i42;
                changedInstance = restartGroup.changed(cursorBrush) ? 536870912 : 268435456;
                $dirty3 |= changedInstance;
            } else {
                i19 = i42;
                obj = cursorBrush;
            }
        }
        int i43 = i38 & 1024;
        if (i43 != 0) {
            $dirty12 |= 6;
        } else {
            if (i74 & 6 == 0) {
                if (i74 & 8 == 0) {
                    changedInstance = restartGroup.changed(obj8);
                } else {
                    changedInstance = restartGroup.changedInstance(obj8);
                }
                i18 = changedInstance != null ? 4 : 2;
                $dirty12 |= i18;
            }
        }
        int i35 = i38 & 2048;
        if (i35 != 0) {
            $dirty12 |= 48;
            i11 = i35;
            i27 = textObfuscationMode;
        } else {
            if (i74 & 48 == 0) {
                i11 = i35;
                i33 = restartGroup.changed(textObfuscationMode) ? 32 : 16;
                $dirty12 |= i33;
            } else {
                i11 = i35;
                i27 = textObfuscationMode;
            }
        }
        int i36 = i38 & 4096;
        if (i36 != 0) {
            $dirty12 |= 384;
            i2 = i36;
            c = textObfuscationCharacter;
        } else {
            i2 = i36;
            if (i74 & 384 == 0) {
                if (restartGroup.changed(textObfuscationCharacter)) {
                } else {
                    i4 = i34;
                }
                $dirty12 |= i4;
            } else {
                c = textObfuscationCharacter;
            }
        }
        if ($dirty3 & $composer2 == 306783378 && $dirty12 & 147 == 146) {
            if ($dirty12 & 147 == 146) {
                if (!restartGroup.getSkipping()) {
                    if (i63 != 0) {
                        modifier3 = Modifier.Companion;
                    } else {
                        modifier3 = solidColor2;
                    }
                    enabled2 = companion3 != 0 ? 1 : z2;
                    inputTransformation2 = then != 0 ? 0 : z;
                    if (i10 != 0) {
                        textStyle2 = TextStyle.Companion.getDefault();
                    } else {
                        textStyle2 = obj6;
                    }
                    if (secureTextFieldController != 0) {
                        keyboardOptions2 = KeyboardOptions.Companion.getSecureTextField$foundation_release();
                    } else {
                        keyboardOptions2 = obj5;
                    }
                    onKeyboardAction2 = i26 != 0 ? 0 : onKeyboardAction;
                    i5 = i5 != 0 ? obj5 : onTextLayout;
                    i12 = i12 != 0 ? obj5 : interactionSource;
                    if (i19 != 0) {
                        obj34 = enabled2;
                        i31 = i43;
                        solidColor2 = new SolidColor(Color.Companion.getBlack-0d7_KjU(), i43, 0);
                        i19 = enabled2;
                    } else {
                        obj34 = enabled2;
                        i31 = i43;
                        i19 = cursorBrush;
                    }
                    i22 = i31 != 0 ? enabled2 : decorator;
                    if (i11 != 0) {
                        textObfuscationMode2 = TextObfuscationMode.Companion.getRevealLastTyped-vTwcZD0();
                    } else {
                        textObfuscationMode2 = textObfuscationMode;
                    }
                    textObfuscationCharacter2 = i2 != 0 ? 8226 : textObfuscationCharacter;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1399310985, $dirty3, $dirty12, "androidx.compose.foundation.text.BasicSecureTextField (BasicSecureTextField.kt:130)");
                    }
                    State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Character.valueOf(textObfuscationCharacter2), restartGroup, i67 &= 14);
                    String str2 = "CC(remember):BasicSecureTextField.kt#9igjgp";
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 120982059, str2);
                    int i70 = 0;
                    obj36 = restartGroup;
                    int i75 = 0;
                    it$iv3 = obj36.rememberedValue();
                    int i79 = 0;
                    obj46 = $dirty3;
                    if (it$iv3 == Composer.Companion.getEmpty()) {
                        int i44 = 0;
                        obj38 = it$iv3;
                        it$iv3 = new SecureTextFieldController(rememberUpdatedState);
                        obj36.updateRememberedValue(it$iv3);
                    } else {
                        $this$cache$iv = obj36;
                        obj38 = it$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 120985553, str2);
                    Composer composer4 = restartGroup;
                    int i76 = 0;
                    it$iv2 = composer4.rememberedValue();
                    int i80 = 0;
                    if (!restartGroup.changedInstance((SecureTextFieldController)it$iv3)) {
                        $dirty1 = $dirty12;
                        if (it$iv2 == Composer.Companion.getEmpty()) {
                            obj38 = it$iv2;
                            obj39 = $dirty14;
                            it$iv2 = new BasicSecureTextFieldKt.BasicSecureTextField.1.1(it$iv3, 0);
                            composer4.updateRememberedValue((Function2)it$iv2);
                        } else {
                            obj38 = it$iv2;
                        }
                    } else {
                        $dirty1 = $dirty12;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    EffectsKt.LaunchedEffect(it$iv3, (Function2)it$iv2, restartGroup, 0);
                    boolean equals-impl03 = TextObfuscationMode.equals-impl0(textObfuscationMode2, TextObfuscationMode.Companion.getRevealLastTyped-vTwcZD0());
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 121001808, str2);
                    obj38 = restartGroup;
                    int i77 = 0;
                    it$iv = obj38.rememberedValue();
                    companion2 = 0;
                    if (changed |= changedInstance3 == 0) {
                        if (it$iv == Composer.Companion.getEmpty()) {
                            obj40 = it$iv;
                            obj41 = i58;
                            it$iv = new BasicSecureTextFieldKt.BasicSecureTextField.2.1(equals-impl03, it$iv3, 0);
                            obj38.updateRememberedValue((Function2)it$iv);
                        } else {
                            composer = obj38;
                            obj40 = it$iv;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    int i56 = 0;
                    EffectsKt.LaunchedEffect(Boolean.valueOf(equals-impl03), (Function2)it$iv, restartGroup, i56);
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 121007343, str2);
                    i13 = $dirty1 & 112 == 32 ? 1 : i56;
                    Composer composer3 = restartGroup;
                    int i72 = 0;
                    Object rememberedValue = composer3.rememberedValue();
                    int i78 = 0;
                    if (i13 == 0) {
                        secureTextFieldController = it$iv3;
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            obj38 = secureTextFieldController2;
                            if (TextObfuscationMode.equals-impl0(textObfuscationMode2, TextObfuscationMode.Companion.getRevealLastTyped-vTwcZD0())) {
                                codepointTransformation = secureTextFieldController.getCodepointTransformation();
                            } else {
                                if (TextObfuscationMode.equals-impl0(textObfuscationMode2, TextObfuscationMode.Companion.getHidden-vTwcZD0())) {
                                    codepointTransformation = new BasicSecureTextFieldKt$$ExternalSyntheticLambda0(rememberUpdatedState);
                                } else {
                                    codepointTransformation = 0;
                                }
                            }
                            composer3.updateRememberedValue(codepointTransformation);
                        } else {
                            codepointTransformation = rememberedValue;
                        }
                    } else {
                        secureTextFieldController = it$iv3;
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    if (equals-impl03) {
                        focusChangeModifier = secureTextFieldController.getFocusChangeModifier();
                    } else {
                        focusChangeModifier = Modifier.Companion;
                    }
                    i11 = obj34;
                    i2 = inputTransformation2;
                    i21 = textStyle2;
                    i26 = keyboardOptions2;
                    i = onKeyboardAction2;
                    $composer2 = new BasicSecureTextFieldKt.BasicSecureTextField.3(state, SemanticsModifierKt.semantics(modifier3, true, (Function1)BasicSecureTextFieldKt.BasicSecureTextField.secureTextFieldModifier.1.INSTANCE).then(focusChangeModifier), i11, equals-impl03, i2, secureTextFieldController, i21, i26, i, i5, i12, i19, (CodepointTransformation)codepointTransformation, i22);
                    BasicSecureTextFieldKt.DisableCutCopy((Function2)ComposableLambdaKt.rememberComposableLambda(2023988909, true, $composer2, restartGroup, 54), restartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    i24 = obj37;
                    obj7 = modifier3;
                    i20 = textObfuscationMode2;
                    modifier2 = restartGroup;
                    $composer3 = i11;
                    $dirty = i2;
                    $dirty13 = i21;
                    obj4 = i26;
                    i16 = i;
                    i3 = i5;
                    i14 = i12;
                    solidColor = i19;
                    i30 = i22;
                } else {
                    restartGroup.skipToGroupEnd();
                    i14 = interactionSource;
                    i24 = textObfuscationCharacter;
                    modifier2 = restartGroup;
                    obj46 = $dirty3;
                    $dirty1 = $dirty12;
                    $composer3 = z2;
                    $dirty = z;
                    $dirty13 = obj6;
                    obj4 = obj5;
                    obj7 = solidColor2;
                    i16 = onKeyboardAction;
                    i3 = onTextLayout;
                    solidColor = cursorBrush;
                    i30 = decorator;
                    i20 = textObfuscationMode;
                }
            } else {
            }
        } else {
        }
        endRestartGroup = modifier2.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty2 = obj46;
            composer2 = composer5;
            modifier2 = new BasicSecureTextFieldKt.BasicSecureTextField.4(state, obj7, $composer3, $dirty, $dirty13, obj4, i16, i3, i14, solidColor, i30, i20, i24, i73, i74, i17);
            endRestartGroup.updateScope((Function2)modifier2);
        } else {
            $dirty2 = obj46;
            composer2 = modifier2;
        }
    }

    private static final int BasicSecureTextField_Jb9bMDk$lambda$4$lambda$3(State $obfuscationMaskState, int i2, int i3) {
        return (Character)$obfuscationMaskState.getValue().charValue();
    }

    private static final void DisableCutCopy(Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int this_$iv;
        int $dirty;
        int i2;
        int invalid$iv;
        boolean traceInProgress;
        int traceInProgress2;
        androidx.compose.runtime.internal.ComposableLambda rememberComposableLambda;
        int i3;
        int i;
        Object empty;
        Object anon;
        this_$iv = -1085555050;
        final Composer obj10 = $composer.startRestartGroup(this_$iv);
        ComposerKt.sourceInformation(obj10, "C(DisableCutCopy)311@13911L7,312@13949L680,331@14706L361,331@14634L433:BasicSecureTextField.kt#423gt5");
        traceInProgress2 = 2;
        if ($changed & 6 == 0) {
            i2 = obj10.changedInstance(content) ? 4 : traceInProgress2;
            $dirty |= i2;
        }
        if ($dirty & 3 == traceInProgress2) {
            if (!obj10.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(this_$iv, $dirty, -1, "androidx.compose.foundation.text.DisableCutCopy (BasicSecureTextField.kt:310)");
                }
                int i4 = 0;
                int i6 = 0;
                ComposerKt.sourceInformationMarkerStart(obj10, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                ComposerKt.sourceInformationMarkerEnd(obj10);
                this_$iv = consume;
                ComposerKt.sourceInformationMarkerStart(obj10, -1202776994, "CC(remember):BasicSecureTextField.kt#9igjgp");
                Composer composer = obj10;
                int i8 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i10 = 0;
                if (!obj10.changed((TextToolbar)this_$iv)) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon = new BasicSecureTextFieldKt.DisableCutCopy.copyDisabledToolbar.1.1(this_$iv);
                        composer.updateRememberedValue(anon);
                    } else {
                        anon = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(obj10);
                BasicSecureTextFieldKt.DisableCutCopy.1 anon2 = new BasicSecureTextFieldKt.DisableCutCopy.1(content);
                CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalTextToolbar().provides((BasicSecureTextFieldKt.DisableCutCopy.copyDisabledToolbar.1.1)anon), (Function2)ComposableLambdaKt.rememberComposableLambda(-1448819882, true, anon2, obj10, 54), obj10, $stable |= 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                obj10.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = obj10.endRestartGroup();
        if (endRestartGroup != null) {
            invalid$iv = new BasicSecureTextFieldKt.DisableCutCopy.2(content, $changed);
            endRestartGroup.updateScope((Function2)invalid$iv);
        }
    }

    public static final void access$DisableCutCopy(Function2 content, Composer $composer, int $changed) {
        BasicSecureTextFieldKt.DisableCutCopy(content, $composer, $changed);
    }

    public static final InputTransformation access$then(InputTransformation $receiver, InputTransformation next) {
        return BasicSecureTextFieldKt.then($receiver, next);
    }

    private static final InputTransformation then(InputTransformation $this$then, InputTransformation next) {
        InputTransformation then;
        if ($this$then == null) {
            then = next;
        } else {
            if (next == null) {
                then = $this$then;
            } else {
                then = InputTransformationKt.then($this$then, next);
            }
        }
        return then;
    }
}
