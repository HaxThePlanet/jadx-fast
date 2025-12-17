package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.Role.Companion;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aO\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\r2\n\u0008\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0016H\u0007¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0008\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006\u0018", d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioButtonRippleRadius", "RadioButtonSize", "RadioRadius", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/RadioButtonColors;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/RadioButtonColors;Landroidx/compose/runtime/Composer;II)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RadioButtonKt {

    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize;
    private static final float RadioButtonPadding;
    private static final float RadioButtonRippleRadius;
    private static final float RadioButtonSize;
    private static final float RadioRadius;
    private static final float RadioStrokeWidth;
    static {
        int i6 = 0;
        RadioButtonKt.RadioButtonRippleRadius = Dp.constructor-impl((float)i);
        int i7 = 0;
        RadioButtonKt.RadioButtonPadding = Dp.constructor-impl((float)i2);
        int i8 = 0;
        RadioButtonKt.RadioButtonSize = Dp.constructor-impl((float)i3);
        int i12 = 0;
        RadioButtonKt.RadioRadius = Dp.constructor-impl(radioButtonSize / f6);
        int i10 = 0;
        RadioButtonKt.RadioButtonDotSize = Dp.constructor-impl((float)i4);
        int i11 = 0;
        RadioButtonKt.RadioStrokeWidth = Dp.constructor-impl((float)i5);
    }

    public static final void RadioButton(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, androidx.compose.material.RadioButtonColors colors, Composer $composer, int $changed, int i9) {
        int arg0$iv;
        Modifier companion3;
        Object selectableModifier;
        boolean traceInProgress2;
        Modifier minimumInteractiveComponentSize;
        Modifier requiredSize-3ABfNKs;
        Object obj5;
        int $dirty2;
        Object $dirty3;
        Object $dirty;
        int i3;
        int i11;
        Object modifier2;
        boolean modifier3;
        int i6;
        Object obj;
        Object obj2;
        boolean enabled3;
        int enabled2;
        Object radioButtonColors;
        androidx.compose.runtime.State i;
        int i12;
        int dotRadius;
        boolean traceInProgress;
        float $i$f$getDp;
        boolean str;
        float constructor-impl;
        int radioColor;
        int i10;
        int i2;
        int rememberedValue;
        int i7;
        Object obj3;
        int i5;
        Composer restartGroup;
        int i8;
        Object colors2;
        int changed;
        int skipping;
        int defaultsInvalid;
        int radioColor2;
        Object i4;
        int companion2;
        int companion;
        int radioButton-o7Vup1c;
        Object obj4;
        androidx.compose.runtime.State state;
        int i13;
        androidx.compose.ui.Modifier.Companion obj24;
        requiredSize-3ABfNKs = selected;
        i = $changed;
        traceInProgress2 = 1314435585;
        restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(RadioButton)P(5,4,3,1,2)78@3689L8,80@3722L164,84@3915L29,114@4883L385,101@4476L792:RadioButton.kt#jmzs0o");
        $dirty2 = $changed;
        i6 = 2;
        if (i9 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i & 6 == 0) {
                i3 = restartGroup.changed(requiredSize-3ABfNKs) ? 4 : i6;
                $dirty2 |= i3;
            }
        }
        if (i9 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i & 48 == 0) {
                i11 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty2 |= i11;
            }
        }
        int i18 = i9 & 4;
        if (i18 != 0) {
            $dirty2 |= 384;
            obj2 = modifier;
        } else {
            if (i & 384 == 0) {
                i12 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i12;
            } else {
                obj2 = modifier;
            }
        }
        dotRadius = i9 & 8;
        if (dotRadius != 0) {
            $dirty2 |= 3072;
            str = enabled;
        } else {
            if (i & 3072 == 0) {
                i2 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i2;
            } else {
                str = enabled;
            }
        }
        rememberedValue = i9 & 16;
        if (rememberedValue != 0) {
            $dirty2 |= 24576;
            obj3 = interactionSource;
        } else {
            if (i & 24576 == 0) {
                i8 = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty2 |= i8;
            } else {
                obj3 = interactionSource;
            }
        }
        if (i41 &= i == 0) {
            if (i9 & 32 == 0) {
                changed = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                colors2 = colors;
            }
            $dirty2 |= changed;
        } else {
            colors2 = colors;
        }
        if (i46 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                radioButton-o7Vup1c = -458753;
                if (i & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i18 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj2;
                        }
                        enabled3 = dotRadius != 0 ? 1 : str;
                        obj4 = rememberedValue != 0 ? dotRadius : obj3;
                        if (i9 & 32 != 0) {
                            Composer composer2 = restartGroup;
                            restartGroup = composer2;
                            i4 = modifier2;
                            modifier3 = enabled3;
                            obj5 = obj4;
                            enabled2 = $dirty4;
                            $dirty3 = dotRadius;
                        } else {
                            i4 = modifier2;
                            modifier3 = enabled3;
                            obj5 = obj4;
                            enabled2 = $dirty2;
                            $dirty3 = colors;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i9 & 32 != 0) {
                            $dirty2 &= radioButton-o7Vup1c;
                        }
                        i4 = obj2;
                        modifier3 = str;
                        obj5 = obj3;
                        enabled2 = $dirty2;
                        $dirty3 = colors2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, enabled2, -1, "androidx.compose.material.RadioButton (RadioButton.kt:79)");
                }
                if (requiredSize-3ABfNKs) {
                    constructor-impl = 0;
                    $i$f$getDp = arg0$iv;
                } else {
                    int i22 = 0;
                    $i$f$getDp = constructor-impl;
                }
                int i25 = 0;
                int i31 = 0;
                companion2 = i47;
                int i14 = i13;
                androidx.compose.runtime.State animateDpAsState-AjpBEmI = AnimateAsStateKt.animateDpAsState-AjpBEmI($i$f$getDp, (AnimationSpec)AnimationSpecKt.tween$default(100, i25, i31, 6, i31), i31, 0, restartGroup, 48, 12);
                androidx.compose.runtime.State radioColor3 = $dirty3.radioColor(modifier3, requiredSize-3ABfNKs, restartGroup, i28 |= i35);
                if (onClick != null) {
                    restartGroup.startReplaceGroup(1892955885);
                    ComposerKt.sourceInformation(restartGroup, "93@4270L139");
                    androidx.compose.runtime.State state3 = animateDpAsState-AjpBEmI;
                    obj4 = state4;
                    i = state;
                    colors2 = $dirty3;
                    i7 = i6;
                    i5 = companion2;
                    radioColor = i14;
                    dotRadius = enabled2;
                    companion3 = SelectableKt.selectable-O2vRcR0((Modifier)Modifier.Companion, requiredSize-3ABfNKs, obj5, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, RadioButtonKt.RadioButtonRippleRadius, 0, state3, restartGroup, 54), modifier3, Role.box-impl(Role.Companion.getRadioButton-o7Vup1c()), onClick);
                    restartGroup.endReplaceGroup();
                } else {
                    colors2 = $dirty3;
                    i7 = i6;
                    obj4 = animateDpAsState-AjpBEmI;
                    i = radioColor3;
                    i5 = companion2;
                    radioColor = i14;
                    dotRadius = enabled2;
                    restartGroup.startReplaceGroup(1893376059);
                    restartGroup.endReplaceGroup();
                    companion3 = Modifier.Companion;
                }
                if (onClick != null) {
                    minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize((Modifier)Modifier.Companion);
                } else {
                    minimumInteractiveComponentSize = Modifier.Companion;
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 61091208, "CC(remember):RadioButton.kt#9igjgp");
                obj3 = obj4;
                Composer composer = restartGroup;
                int i21 = 0;
                rememberedValue = composer.rememberedValue();
                skipping = 0;
                if (changed2 |= changed4 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        radioColor = 0;
                        obj24 = companion3;
                        selectableModifier = new RadioButtonKt.RadioButton.1.1(i, obj3);
                        composer.updateRememberedValue((Function1)selectableModifier);
                    } else {
                        obj24 = companion3;
                        selectableModifier = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.requiredSize-3ABfNKs(PaddingKt.padding-3ABfNKs(SizeKt.wrapContentSize$default(i4.then(minimumInteractiveComponentSize).then(companion3), Alignment.Companion.getCenter(), radioColor, i7, i5), RadioButtonKt.RadioButtonPadding), RadioButtonKt.RadioButtonSize), (Function1)selectableModifier, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj5;
                i10 = dotRadius;
                $dirty = i4;
                radioButtonColors = colors2;
            } else {
                restartGroup.skipToGroupEnd();
                modifier3 = str;
                obj = obj3;
                i10 = $dirty2;
                $dirty = obj2;
                radioButtonColors = colors2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new RadioButtonKt.RadioButton.2(selected, onClick, $dirty, modifier3, obj, radioButtonColors, $changed, i9);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final float access$getRadioRadius$p() {
        return RadioButtonKt.RadioRadius;
    }

    public static final float access$getRadioStrokeWidth$p() {
        return RadioButtonKt.RadioStrokeWidth;
    }
}
