package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.tokens.RadioButtonTokens;
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
@Metadata(d1 = "\u00008\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aO\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0008\u0018\u00010\u000c2\u0008\u0008\u0002\u0010\r\u001a\u00020\u000e2\u0008\u0008\u0002\u0010\u000f\u001a\u00020\n2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0007¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0010\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006\u0015", d2 = {"RadioAnimationDuration", "", "RadioButtonDotSize", "Landroidx/compose/ui/unit/Dp;", "F", "RadioButtonPadding", "RadioStrokeWidth", "RadioButton", "", "selected", "", "onClick", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/RadioButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/RadioButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RadioButtonKt {

    private static final int RadioAnimationDuration = 100;
    private static final float RadioButtonDotSize;
    private static final float RadioButtonPadding;
    private static final float RadioStrokeWidth;
    static {
        int i4 = 0;
        RadioButtonKt.RadioButtonPadding = Dp.constructor-impl((float)i);
        int i5 = 0;
        RadioButtonKt.RadioButtonDotSize = Dp.constructor-impl((float)i2);
        int i6 = 0;
        RadioButtonKt.RadioStrokeWidth = Dp.constructor-impl((float)i3);
    }

    public static final void RadioButton(boolean selected, Function0<Unit> onClick, Modifier modifier, boolean enabled, androidx.compose.material3.RadioButtonColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i9) {
        float arg0$iv;
        Modifier companion;
        Object selectableModifier;
        boolean traceInProgress;
        Modifier minimumInteractiveComponentSize;
        Modifier requiredSize-3ABfNKs;
        Object obj3;
        int $dirty4;
        boolean $dirty2;
        Object $dirty;
        int i3;
        int i11;
        Object modifier3;
        boolean modifier2;
        Object obj5;
        int colors3;
        Object colors4;
        Object obj;
        int i7;
        int $dirty3;
        Object obj4;
        boolean dotRadius;
        boolean traceInProgress2;
        float other$iv;
        int i8;
        Object str;
        int constructor-impl;
        Object radioColor;
        int colors2;
        int changed;
        int i10;
        Object obj2;
        int i;
        int i5;
        int skipping;
        int defaultsInvalid;
        int empty;
        int radioColor2;
        androidx.compose.runtime.State i6;
        Object rememberedValue;
        int i2;
        androidx.compose.ui.Modifier.Companion companion2;
        int radioButton-o7Vup1c;
        androidx.compose.runtime.State state3;
        androidx.compose.runtime.State state;
        androidx.compose.runtime.State state4;
        androidx.compose.runtime.State state2;
        int i4;
        androidx.compose.ui.Modifier.Companion obj26;
        int obj30;
        requiredSize-3ABfNKs = selected;
        final int i22 = $changed;
        traceInProgress = 408580840;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(RadioButton)P(5,4,3,1)80@3770L8,84@3868L176,88@4073L29,119@5097L415,106@4679L833:RadioButton.kt#uh7d8r");
        $dirty4 = $changed;
        rememberedValue = 2;
        if (i9 & 1 != 0) {
            $dirty4 |= 6;
        } else {
            if (i22 & 6 == 0) {
                i3 = restartGroup.changed(requiredSize-3ABfNKs) ? 4 : rememberedValue;
                $dirty4 |= i3;
            }
        }
        if (i9 & 2 != 0) {
            $dirty4 |= 48;
        } else {
            if (i22 & 48 == 0) {
                i11 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty4 |= i11;
            }
        }
        int i16 = i9 & 4;
        if (i16 != 0) {
            $dirty4 |= 384;
            obj5 = modifier;
        } else {
            if (i22 & 384 == 0) {
                i7 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty4 |= i7;
            } else {
                obj5 = modifier;
            }
        }
        int i20 = i9 & 8;
        if (i20 != 0) {
            $dirty4 |= 3072;
            dotRadius = enabled;
        } else {
            if (i22 & 3072 == 0) {
                i8 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty4 |= i8;
            } else {
                dotRadius = enabled;
            }
        }
        if (i22 & 24576 == 0) {
            if (i9 & 16 == 0) {
                changed = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                str = colors;
            }
            $dirty4 |= changed;
        } else {
            str = colors;
        }
        i10 = i9 & 32;
        int i40 = 196608;
        if (i10 != 0) {
            $dirty4 |= i40;
            obj2 = interactionSource;
        } else {
            if (i40 &= i22 == 0) {
                i5 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty4 |= i5;
            } else {
                obj2 = interactionSource;
            }
        }
        if (i45 &= $dirty4 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                obj30 = -57345;
                int i49 = 6;
                if (i22 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i16 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = obj5;
                        }
                        if (i20 != 0) {
                            dotRadius = obj5;
                        }
                        if (i9 & 16 != 0) {
                            $dirty4 &= obj30;
                            str = colors3;
                        }
                        if (i10 != 0) {
                            $dirty3 = $dirty4;
                            obj3 = i19;
                            $dirty2 = dotRadius;
                            colors4 = str;
                        } else {
                            $dirty3 = $dirty4;
                            $dirty2 = dotRadius;
                            colors4 = str;
                            obj3 = obj2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i9 & 16 != 0) {
                            $dirty4 &= obj30;
                        }
                        $dirty3 = $dirty4;
                        modifier3 = obj5;
                        $dirty2 = dotRadius;
                        colors4 = str;
                        obj3 = obj2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty3, -1, "androidx.compose.material3.RadioButton (RadioButton.kt:82)");
                }
                if (requiredSize-3ABfNKs) {
                    constructor-impl = 0;
                    other$iv = arg0$iv;
                } else {
                    int i25 = 0;
                    other$iv = constructor-impl;
                }
                int i28 = 0;
                int i33 = 0;
                int i52 = i50;
                int i12 = i4;
                androidx.compose.runtime.State animateDpAsState-AjpBEmI = AnimateAsStateKt.animateDpAsState-AjpBEmI(other$iv, (AnimationSpec)AnimationSpecKt.tween$default(100, i28, i33, i49, i33), i33, 0, restartGroup, 48, 12);
                androidx.compose.runtime.State radioColor$material3_release = colors4.radioColor$material3_release($dirty2, requiredSize-3ABfNKs, restartGroup, i31 |= i37);
                restartGroup.startReplaceGroup(1327106656);
                ComposerKt.sourceInformation(restartGroup, "98@4448L164");
                if (onClick != null) {
                    int i48 = 0;
                    androidx.compose.runtime.State other$iv2 = animateDpAsState-AjpBEmI;
                    state4 = state3;
                    state2 = state;
                    radioColor = colors4;
                    empty = i12;
                    i10 = modifier3;
                    i = i52;
                    dotRadius = $dirty3;
                    companion = SelectableKt.selectable-O2vRcR0((Modifier)Modifier.Companion, requiredSize-3ABfNKs, obj3, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, Dp.constructor-impl(stateLayerSize-D9Ej5fM / f3), 0, other$iv2, restartGroup, 54), $dirty2, Role.box-impl(Role.Companion.getRadioButton-o7Vup1c()), onClick);
                } else {
                    empty = i12;
                    i10 = modifier3;
                    state4 = animateDpAsState-AjpBEmI;
                    state2 = radioColor$material3_release;
                    i = i52;
                    modifier2 = $dirty2;
                    radioColor = colors4;
                    dotRadius = $dirty3;
                    companion = Modifier.Companion;
                }
                restartGroup.endReplaceGroup();
                if (onClick != null) {
                    minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize((Modifier)Modifier.Companion);
                } else {
                    minimumInteractiveComponentSize = Modifier.Companion;
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1327137161, "CC(remember):RadioButton.kt#9igjgp");
                i6 = state2;
                obj2 = state4;
                Composer composer = restartGroup;
                int i21 = 0;
                rememberedValue = composer.rememberedValue();
                i2 = 0;
                if (changed2 |= changed4 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        obj26 = companion;
                        selectableModifier = new RadioButtonKt.RadioButton.1.1(i6, obj2);
                        composer.updateRememberedValue((Function1)selectableModifier);
                    } else {
                        obj26 = companion;
                        selectableModifier = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.requiredSize-3ABfNKs(PaddingKt.padding-3ABfNKs(SizeKt.wrapContentSize$default(i10.then(minimumInteractiveComponentSize).then(companion), Alignment.Companion.getCenter(), empty, rememberedValue, i), RadioButtonKt.RadioButtonPadding), RadioButtonTokens.INSTANCE.getIconSize-D9Ej5fM()), (Function1)selectableModifier, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj4 = obj3;
                obj = radioColor;
                $dirty = i10;
                colors2 = dotRadius;
            } else {
                restartGroup.skipToGroupEnd();
                colors2 = $dirty4;
                $dirty = obj5;
                obj = obj6;
                modifier2 = dotRadius;
                obj4 = obj2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new RadioButtonKt.RadioButton.2(selected, onClick, $dirty, modifier2, obj, obj4, i22, i9);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    public static final float access$getRadioStrokeWidth$p() {
        return RadioButtonKt.RadioStrokeWidth;
    }
}
