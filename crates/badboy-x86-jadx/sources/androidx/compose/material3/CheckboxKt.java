package androidx.compose.material3;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.material3.tokens.CheckboxTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeCap.Companion;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.Role.Companion;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.state.ToggleableStateKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FloatCompanionObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001aU\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u000f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010\u0017\u001a-\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u001b\u001aO\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001a2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001f2\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\r2\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00142\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0007¢\u0006\u0002\u0010 \u001a6\u0010!\u001a\u00020\u000b*\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002ø\u0001\u0000¢\u0006\u0004\u0008)\u0010*\u001a>\u0010+\u001a\u00020\u000b*\u00020\"2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020'2\u0006\u0010/\u001a\u00020'2\u0006\u00100\u001a\u000201H\u0002ø\u0001\u0000¢\u0006\u0004\u00082\u00103\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0008\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00064", d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "colors", "Landroidx/compose/material3/CheckboxColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/CheckboxColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material3/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material3/CheckDrawingCache;)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CheckboxKt {

    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxSize;
    private static final float RadiusSize;
    private static final float StrokeWidth;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int ordinal3;
            int[] iArr = new int[values.length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Off.ordinal()] = 2;
            iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            CheckboxKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        int i5 = 0;
        CheckboxKt.CheckboxDefaultPadding = Dp.constructor-impl((float)i);
        int i6 = 0;
        CheckboxKt.CheckboxSize = Dp.constructor-impl((float)i2);
        int i7 = 0;
        CheckboxKt.StrokeWidth = Dp.constructor-impl((float)i3);
        int i8 = 0;
        CheckboxKt.RadiusSize = Dp.constructor-impl((float)i4);
    }

    public static final void Checkbox(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, androidx.compose.material3.CheckboxColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i9) {
        int i4;
        Object invalid$iv;
        boolean traceInProgress;
        int $dirty;
        Object $dirty2;
        int i5;
        int i;
        int companion;
        int colors3;
        boolean traceInProgress2;
        int i2;
        boolean z;
        int skipping;
        int defaultsInvalid;
        Object obj2;
        Object rememberedValue;
        Object obj4;
        Object obj;
        int i10;
        Object obj3;
        int i7;
        boolean enabled2;
        int i6;
        Object colors2;
        int changed;
        Object i12;
        Object obj5;
        int i3;
        Object empty;
        int i11;
        int i8;
        int obj19;
        final boolean z2 = checked;
        final Object obj6 = onCheckedChange;
        final int i27 = $changed;
        traceInProgress = -1406741137;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(Checkbox)P(!1,5,4,2)96@4296L8,99@4370L356:Checkbox.kt#uh7d8r");
        $dirty = $changed;
        if (i9 & 1 != 0) {
            $dirty |= 6;
        } else {
            if (i27 & 6 == 0) {
                i5 = restartGroup.changed(z2) ? 4 : 2;
                $dirty |= i5;
            }
        }
        rememberedValue = 32;
        if (i9 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i27 & 48 == 0) {
                i = restartGroup.changedInstance(obj6) ? rememberedValue : 16;
                $dirty |= i;
            }
        }
        companion = i9 & 4;
        if (companion != 0) {
            $dirty |= 384;
            obj = modifier;
        } else {
            if (i27 & 384 == 0) {
                i10 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i10;
            } else {
                obj = modifier;
            }
        }
        int i29 = i9 & 8;
        if (i29 != 0) {
            $dirty |= 3072;
            enabled2 = enabled;
        } else {
            if (i27 & 3072 == 0) {
                i6 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i6;
            } else {
                enabled2 = enabled;
            }
        }
        if (i27 & 24576 == 0) {
            if (i9 & 16 == 0) {
                changed = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                colors2 = colors;
            }
            $dirty |= changed;
        } else {
            colors2 = colors;
        }
        i12 = i9 & 32;
        int i35 = 196608;
        if (i12 != 0) {
            $dirty |= i35;
            obj5 = interactionSource;
        } else {
            if (i35 &= i27 == 0) {
                i3 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty |= i3;
            } else {
                obj5 = interactionSource;
            }
        }
        if (i37 &= $dirty == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                empty = -57345;
                if (i27 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (companion != 0) {
                            obj = companion;
                        }
                        if (i29 != 0) {
                            enabled2 = companion;
                        }
                        if (i9 & 16 != 0) {
                            $dirty &= empty;
                            colors2 = colors3;
                        }
                        if (i12 != 0) {
                            obj5 = colors3;
                            i12 = colors2;
                            colors2 = enabled2;
                            enabled2 = obj;
                        } else {
                            i12 = colors2;
                            colors2 = enabled2;
                            enabled2 = obj;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i9 & 16 != 0) {
                            $dirty &= empty;
                        }
                        i12 = colors2;
                        colors2 = enabled2;
                        enabled2 = obj;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty, -1, "androidx.compose.material3.Checkbox (Checkbox.kt:98)");
                }
                restartGroup.startReplaceGroup(1046936362);
                ComposerKt.sourceInformation(restartGroup, "103@4507L29");
                if (obj6 != null) {
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1046937763, "CC(remember):Checkbox.kt#9igjgp");
                    int i25 = 1;
                    i4 = $dirty & 112 == rememberedValue ? i25 : i2;
                    if ($dirty & 14 == 4) {
                        i2 = i25;
                    }
                    i4 |= i2;
                    traceInProgress2 = restartGroup;
                    defaultsInvalid = 0;
                    rememberedValue = traceInProgress2.rememberedValue();
                    int i31 = 0;
                    if (i16 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            empty = 0;
                            obj19 = i16;
                            invalid$iv = new CheckboxKt.Checkbox.1.1(obj6, z2);
                            traceInProgress2.updateRememberedValue((Function0)invalid$iv);
                        } else {
                            obj19 = i16;
                            invalid$iv = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    obj3 = invalid$iv;
                } else {
                    obj3 = invalid$iv;
                }
                restartGroup.endReplaceGroup();
                CheckboxKt.TriStateCheckbox(ToggleableStateKt.ToggleableState(z2), obj3, enabled2, colors2, i12, obj5, restartGroup, i19 | i24, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i7 = $dirty;
                $dirty2 = enabled2;
                z = colors2;
                obj2 = i12;
                obj4 = obj5;
            } else {
                restartGroup.skipToGroupEnd();
                i7 = $dirty;
                $dirty2 = obj;
                z = enabled2;
                obj2 = colors2;
                obj4 = obj5;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new CheckboxKt.Checkbox.2(z2, obj6, $dirty2, z, obj2, obj4, i27, i9);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final void CheckboxImpl(boolean enabled, ToggleableState value, Modifier modifier, androidx.compose.material3.CheckboxColors colors, Composer $composer, int $changed) {
        int i4;
        int $changed$iv$iv;
        int i7;
        Float initialValue$iv$iv;
        Object obj2;
        Object empty;
        boolean traceInProgress3;
        int i12;
        int i8;
        int $composer2;
        Transition $this$animateValue$iv$iv;
        int $dirty2;
        int $dirty;
        boolean traceInProgress2;
        Transition $this$animateValue$iv$iv2;
        int i9;
        int i;
        int i17;
        int i14;
        int it;
        androidx.compose.runtime.State boxColor$material3_release;
        androidx.compose.runtime.State borderColor$material3_release;
        Modifier requiredSize-3ABfNKs;
        int i18;
        Object obj3;
        Composer composer;
        int i3;
        boolean traceInProgress;
        Object rememberedValue;
        int checkDrawingCache;
        int i10;
        Transition companion;
        int i11;
        int i6;
        int i16;
        int $changed$iv$iv2;
        Transition transition;
        Object obj;
        Composer $composer3;
        int i13;
        int i2;
        Transition transition2;
        Transition $this$animateValue$iv$iv3;
        Float num;
        int i5;
        int i15;
        String str;
        androidx.compose.material3.CheckboxKt.CheckboxImpl.1.1 anon;
        androidx.compose.runtime.State state;
        androidx.compose.runtime.State state3;
        androidx.compose.runtime.State state2;
        androidx.compose.runtime.State checkDrawFraction;
        androidx.compose.runtime.State state4;
        Object obj4;
        Float obj43;
        final boolean z = enabled;
        final Object obj5 = value;
        final Object obj6 = modifier;
        final Object obj7 = colors;
        i12 = $changed;
        traceInProgress3 = 2007131616;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress3);
        ComposerKt.sourceInformation(restartGroup, "C(CheckboxImpl)P(1,3,2)272@12420L23,274@12491L499,291@13057L514,306@13593L32,307@13654L21,308@13702L24,309@13756L27,310@13866L538,310@13788L616:Checkbox.kt#uh7d8r");
        rememberedValue = 2;
        if (i12 & 6 == 0) {
            i9 = restartGroup.changed(z) ? 4 : rememberedValue;
            $dirty2 |= i9;
        }
        if (i12 & 48 == 0) {
            i = restartGroup.changed(obj5) ? 32 : 16;
            $dirty2 |= i;
        }
        if (i12 & 384 == 0) {
            i17 = restartGroup.changed(obj6) ? 256 : 128;
            $dirty2 |= i17;
        }
        if (i12 & 3072 == 0) {
            i14 = restartGroup.changed(obj7) ? 2048 : 1024;
            $dirty2 |= i14;
        }
        final int i105 = $dirty2;
        if (i105 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress3, i105, -1, "androidx.compose.material3.CheckboxImpl (Checkbox.kt:271)");
                }
                Transition transition3 = TransitionKt.updateTransition(obj5, 0, restartGroup, i19 &= 14, rememberedValue);
                androidx.compose.material3.CheckboxKt.CheckboxImpl.checkDrawFraction.1 iNSTANCE3 = CheckboxKt.CheckboxImpl.checkDrawFraction.1.INSTANCE;
                int i106 = 0;
                int i107 = 0;
                String str6 = "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1338768149, str6);
                i16 = 57344;
                $this$animateValue$iv$iv2 = transition6;
                int i109 = i82;
                int i110 = 0;
                String str10 = "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -142660079, str10);
                int i116 = 0;
                Composer transition4 = composer6;
                transition4.startReplaceGroup(1800065638);
                String str4 = "C:Checkbox.kt#uh7d8r";
                ComposerKt.sourceInformation(transition4, str4);
                String $composer4 = "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:283)";
                if (ComposerKt.isTraceInProgress()) {
                    $this$animateValue$iv$iv3 = $this$animateValue$iv$iv2;
                    ComposerKt.traceEventStart(1800065638, i115 & 112, -1, $composer4);
                } else {
                    $this$animateValue$iv$iv3 = $this$animateValue$iv$iv2;
                }
                i5 = 0;
                i15 = 1065353216;
                switch (i29) {
                    case 1:
                        i8 = i15;
                        break;
                    case 2:
                        i8 = i5;
                        break;
                    case 3:
                        i8 = i15;
                        break;
                    default:
                        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                transition4.endReplaceGroup();
                i2 = 0;
                Composer initialValue$iv$iv3 = composer5;
                int it2 = 1800065638;
                initialValue$iv$iv3.startReplaceGroup(it2);
                ComposerKt.sourceInformation(initialValue$iv$iv3, str4);
                if (ComposerKt.isTraceInProgress()) {
                    $composer3 = initialValue$iv$iv3;
                    ComposerKt.traceEventStart(it2, i85 &= 112, -1, $composer4);
                } else {
                    $composer3 = initialValue$iv$iv3;
                    $composer2 = -1;
                }
                switch (i21) {
                    case 1:
                        i4 = i15;
                        break;
                    case 2:
                        i4 = i5;
                        break;
                    case 3:
                        i4 = i15;
                        break;
                    default:
                        NoWhenBranchMatchedException noWhenBranchMatchedException4 = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer3.endReplaceGroup();
                obj43 = iNSTANCE3;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                androidx.compose.material3.CheckboxKt.CheckboxImpl.checkCenterGravitationShiftFraction.1 iNSTANCE2 = CheckboxKt.CheckboxImpl.checkCenterGravitationShiftFraction.1.INSTANCE;
                checkDrawingCache = 0;
                i11 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1338768149, str6);
                i24 |= i35;
                $this$animateValue$iv$iv = companion;
                i6 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -142660079, str10);
                Object currentState = $this$animateValue$iv$iv.getCurrentState();
                Composer composer3 = restartGroup;
                int i100 = 0;
                composer3.startReplaceGroup(-1426969489);
                String str11 = str;
                ComposerKt.sourceInformation(composer3, str11);
                if (ComposerKt.isTraceInProgress()) {
                    $changed$iv$iv2 = $changed$iv$iv;
                    transition = $this$animateValue$iv$iv;
                    obj = currentState;
                    ComposerKt.traceEventStart(-1426969489, i66 &= 112, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:300)");
                } else {
                    $changed$iv$iv2 = $changed$iv$iv;
                    transition = $this$animateValue$iv$iv;
                    obj = currentState;
                    it = -1;
                }
                switch (i25) {
                    case 1:
                        i7 = i5;
                        break;
                    case 2:
                        i7 = i5;
                        break;
                    case 3:
                        i7 = i15;
                        break;
                    default:
                        NoWhenBranchMatchedException noWhenBranchMatchedException2 = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3.endReplaceGroup();
                initialValue$iv$iv = Float.valueOf(i7);
                Composer composer4 = restartGroup;
                int i101 = 0;
                int i59 = -1426969489;
                composer4.startReplaceGroup(i59);
                ComposerKt.sourceInformation(composer4, str11);
                if (ComposerKt.isTraceInProgress()) {
                    obj43 = initialValue$iv$iv;
                    ComposerKt.traceEventStart(i59, i68 &= 112, -1, "androidx.compose.material3.CheckboxImpl.<anonymous> (Checkbox.kt:300)");
                } else {
                    obj43 = initialValue$iv$iv;
                }
                switch (i26) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        i5 = i15;
                        break;
                    default:
                        NoWhenBranchMatchedException noWhenBranchMatchedException3 = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer4.endReplaceGroup();
                androidx.compose.material3.CheckboxKt.CheckboxImpl.checkCenterGravitationShiftFraction.1 anon2 = iNSTANCE2;
                empty = state6;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                androidx.compose.runtime.State state5 = transitionAnimation2;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 974828454, "CC(remember):Checkbox.kt#9igjgp");
                int i52 = 0;
                Composer composer2 = restartGroup;
                int i70 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i92 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    int i99 = 0;
                    checkDrawingCache = new CheckDrawingCache(0, 0, 0, 7, 0);
                    composer2.updateRememberedValue(checkDrawingCache);
                } else {
                    obj3 = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                $dirty = obj7.checkmarkColor$material3_release(obj5, restartGroup, i54 |= i62);
                boxColor$material3_release = obj7.boxColor$material3_release(z, obj5, restartGroup, i64 |= i73);
                borderColor$material3_release = obj7.borderColor$material3_release(z, obj5, restartGroup, i75 |= i91);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 974837696, "CC(remember):Checkbox.kt#9igjgp");
                composer = restartGroup;
                i3 = 0;
                rememberedValue = composer.rememberedValue();
                i10 = 0;
                if (i97 |= changed9 == 0) {
                    checkDrawFraction = empty;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int checkDrawFraction2 = 0;
                        anon = new CheckboxKt.CheckboxImpl.1.1(boxColor$material3_release, borderColor$material3_release, $dirty, checkDrawFraction, state5, (CheckDrawingCache)obj3);
                        composer.updateRememberedValue((Function1)anon);
                    } else {
                        state4 = state5;
                        state2 = $dirty;
                        state = boxColor$material3_release;
                        state3 = borderColor$material3_release;
                        obj2 = rememberedValue;
                    }
                } else {
                    checkDrawFraction = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.requiredSize-3ABfNKs(SizeKt.wrapContentSize$default(obj6, Alignment.Companion.getCenter(), false, 2, 0), CheckboxKt.CheckboxSize), (Function1)obj2, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    traceInProgress3 = new CheckboxKt.CheckboxImpl.2(z, obj5, obj6, obj7, $changed);
                    endRestartGroup.updateScope((Function2)traceInProgress3);
                }
            }
            restartGroup.skipToGroupEnd();
        } else {
        }
    }

    public static final void TriStateCheckbox(ToggleableState state, Function0<Unit> onClick, Modifier modifier, boolean enabled, androidx.compose.material3.CheckboxColors colors, MutableInteractionSource interactionSource, Composer $composer, int $changed, int i9) {
        int companion;
        int $dirty2;
        Object traceInProgress;
        Object obj4;
        Modifier minimumInteractiveComponentSize;
        Object obj6;
        Object obj3;
        int i3;
        int i5;
        boolean colors3;
        int $dirty;
        Object modifier2;
        Object colors2;
        Object obj5;
        boolean traceInProgress2;
        int i4;
        Object obj;
        int str;
        boolean z;
        int i2;
        Object constructor-impl;
        int i7;
        int changed;
        int i8;
        Object interactionSource2;
        int i6;
        boolean defaultsInvalid;
        int i;
        Object obj7;
        Object obj2;
        final int i24 = $changed;
        companion = -1608358065;
        final Composer restartGroup = $composer.startRestartGroup(companion);
        ComposerKt.sourceInformation(restartGroup, "C(TriStateCheckbox)P(5,4,3,1)149@6731L8,169@7373L460:Checkbox.kt#uh7d8r");
        $dirty2 = $changed;
        if (i9 & 1 != 0) {
            $dirty2 |= 6;
            obj6 = state;
        } else {
            if (i24 & 6 == 0) {
                i3 = restartGroup.changed(state) ? 4 : 2;
                $dirty2 |= i3;
            } else {
                obj6 = state;
            }
        }
        if (i9 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i24 & 48 == 0) {
                i5 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty2 |= i5;
            }
        }
        int i16 = i9 & 4;
        if (i16 != 0) {
            $dirty2 |= 384;
            colors2 = modifier;
        } else {
            if (i24 & 384 == 0) {
                i4 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i4;
            } else {
                colors2 = modifier;
            }
        }
        str = i9 & 8;
        if (str != null) {
            $dirty2 |= 3072;
            z = enabled;
        } else {
            if (i24 & 3072 == 0) {
                i2 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i2;
            } else {
                z = enabled;
            }
        }
        if (i24 & 24576 == 0) {
            if (i9 & 16 == 0) {
                changed = restartGroup.changed(colors) ? 16384 : 8192;
            } else {
                constructor-impl = colors;
            }
            $dirty2 |= changed;
        } else {
            constructor-impl = colors;
        }
        i8 = i9 & 32;
        int i31 = 196608;
        if (i8 != 0) {
            $dirty2 |= i31;
            interactionSource2 = interactionSource;
        } else {
            if (i31 &= i24 == 0) {
                i6 = restartGroup.changed(interactionSource) ? 131072 : 65536;
                $dirty2 |= i6;
            } else {
                interactionSource2 = interactionSource;
            }
        }
        if (i33 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i = -57345;
                if (i24 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i16 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = colors2;
                        }
                        if (str != null) {
                            z = colors2;
                        }
                        if (i9 & 16 != 0) {
                            $dirty2 &= i;
                            constructor-impl = colors2;
                        }
                        if (i8 != 0) {
                            obj7 = modifier2;
                            obj4 = colors2;
                            obj2 = constructor-impl;
                            $dirty = $dirty2;
                            $dirty2 = z;
                        } else {
                            obj7 = modifier2;
                            obj2 = constructor-impl;
                            obj4 = interactionSource2;
                            $dirty = $dirty2;
                            $dirty2 = z;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i9 & 16 != 0) {
                            $dirty2 &= i;
                        }
                        $dirty = $dirty2;
                        obj7 = colors2;
                        $dirty2 = z;
                        obj2 = constructor-impl;
                        obj4 = interactionSource2;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(companion, $dirty, -1, "androidx.compose.material3.TriStateCheckbox (Checkbox.kt:151)");
                }
                restartGroup.startReplaceGroup(-97239746);
                ComposerKt.sourceInformation(restartGroup, "161@7145L161");
                if (onClick != null) {
                    int i28 = 0;
                    z = $dirty;
                    $dirty = $dirty2;
                    companion = ToggleableKt.triStateToggleable-O2vRcR0((Modifier)Modifier.Companion, obj6, obj4, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, Dp.constructor-impl(stateLayerSize-D9Ej5fM / f), 0, interactionSource2, restartGroup, 54), $dirty, Role.box-impl(Role.Companion.getCheckbox-o7Vup1c()), onClick);
                    interactionSource2 = obj4;
                    $dirty2 = $dirty;
                } else {
                    interactionSource2 = obj4;
                    z = $dirty;
                    companion = Modifier.Companion;
                }
                restartGroup.endReplaceGroup();
                if (onClick != null) {
                    minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize((Modifier)Modifier.Companion);
                } else {
                    minimumInteractiveComponentSize = Modifier.Companion;
                }
                Object obj9 = obj2;
                CheckboxKt.CheckboxImpl($dirty2, state, PaddingKt.padding-3ABfNKs(obj7.then(minimumInteractiveComponentSize).then(companion), CheckboxKt.CheckboxDefaultPadding), obj9, restartGroup, i13 | i20);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj9;
                i7 = z;
                obj3 = obj7;
                colors3 = $dirty2;
                obj = interactionSource2;
            } else {
                restartGroup.skipToGroupEnd();
                obj3 = colors2;
                colors3 = z;
                obj5 = constructor-impl;
                i7 = $dirty2;
                obj = interactionSource2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            companion = new CheckboxKt.TriStateCheckbox.1(state, onClick, obj3, colors3, obj5, obj, i24, i9);
            endRestartGroup.updateScope((Function2)companion);
        }
    }

    public static final void access$CheckboxImpl(boolean enabled, ToggleableState value, Modifier modifier, androidx.compose.material3.CheckboxColors colors, Composer $composer, int $changed) {
        CheckboxKt.CheckboxImpl(enabled, value, modifier, colors, $composer, $changed);
    }

    public static final void access$drawBox-1wkBAMs(DrawScope $receiver, long boxColor, long borderColor, float radius, float strokeWidth) {
        CheckboxKt.drawBox-1wkBAMs($receiver, boxColor, borderColor, radius, strokeWidth);
    }

    public static final void access$drawCheck-3IgeMak(DrawScope $receiver, long checkColor, float checkFraction, float crossCenterGravitation, float strokeWidthPx, androidx.compose.material3.CheckDrawingCache drawingCache) {
        CheckboxKt.drawCheck-3IgeMak($receiver, checkColor, checkFraction, crossCenterGravitation, strokeWidthPx, drawingCache);
    }

    public static final float access$getRadiusSize$p() {
        return CheckboxKt.RadiusSize;
    }

    public static final float access$getStrokeWidth$p() {
        return CheckboxKt.StrokeWidth;
    }

    private static final void drawBox-1wkBAMs(DrawScope $this$drawBox_u2d1wkBAMs, long boxColor, long borderColor, float radius, float strokeWidth) {
        Fill iNSTANCE;
        int i7;
        Object obj;
        DrawScope drawScope;
        int i12;
        long l6;
        long l2;
        Fill fill;
        int i3;
        int i8;
        int i;
        int i11;
        int i6;
        Object obj2;
        long l5;
        long l4;
        long l3;
        long l;
        Stroke stroke;
        int i9;
        int i4;
        int i2;
        int i10;
        int i5;
        final float f = obj45;
        final int i29 = obj46 / i13;
        int i16 = 0;
        final int i14 = obj46;
        Stroke stroke2 = new Stroke(i14, 0, i16, 0, 0, 30, 0);
        float width-impl = Size.getWidth-impl($this$drawBox_u2d1wkBAMs.getSize-NH-jbRc());
        int i22 = 0;
        int i24 = 0;
        int i26 = 2;
        if (Color.equals-impl0(boxColor, borderColor)) {
            DrawScope.drawRoundRect-u-Aw5IA$default($this$drawBox_u2d1wkBAMs, boxColor, obj12, 0, obj14, SizeKt.Size(width-impl, width-impl), obj16, CornerRadiusKt.CornerRadius$default(f, i24, i26, i22), obj18, (DrawStyle)Fill.INSTANCE, 0);
        } else {
            float f2 = (float)i26;
            i10 = 224;
            i5 = 0;
            i9 = 0;
            i4 = 0;
            i2 = 0;
            obj2 = $this$drawBox_u2d1wkBAMs;
            DrawScope.drawRoundRect-u-Aw5IA$default(obj2, boxColor, obj27, OffsetKt.Offset(i14, i14), obj29, SizeKt.Size(width-impl - i27, width-impl - i17), obj31, CornerRadiusKt.CornerRadius$default(Math.max(i24, f - i14), i24, i26, i22), obj33, (DrawStyle)Fill.INSTANCE, i9);
            DrawScope.drawRoundRect-u-Aw5IA$default(obj2, radius, obj27, OffsetKt.Offset(i29, i29), obj29, SizeKt.Size(width-impl - i14, width-impl - i14), obj31, CornerRadiusKt.CornerRadius$default(f - i29, i24, i26, i22), obj33, (DrawStyle)stroke2, i9);
        }
    }

    private static final void drawCheck-3IgeMak(DrawScope $this$drawCheck_u2d3IgeMak, long checkColor, float checkFraction, float crossCenterGravitation, float strokeWidthPx, androidx.compose.material3.CheckDrawingCache drawingCache) {
        float f = strokeWidthPx;
        int i5 = 0;
        Stroke stroke = new Stroke(drawingCache, i5, StrokeCap.Companion.getSquare-KaPHkGw(), 0, 0, 26, 0);
        float width-impl = Size.getWidth-impl($this$drawCheck_u2d3IgeMak.getSize-NH-jbRc());
        int i6 = 1053609165;
        int i16 = 1056964608;
        final Object obj = obj35;
        final int i17 = 0;
        obj.getCheckPath().reset();
        obj.getCheckPath().moveTo(width-impl * i9, width-impl * lerp4);
        obj.getCheckPath().lineTo(width-impl * lerp2, width-impl * lerp3);
        obj.getCheckPath().lineTo(width-impl * i13, width-impl * lerp);
        obj.getPathMeasure().setPath(obj.getCheckPath(), false);
        obj.getPathToDraw().reset();
        final float f3 = width-impl;
        final int i21 = i6;
        obj.getPathMeasure().getSegment(0, length *= crossCenterGravitation, obj.getPathToDraw(), true);
        DrawScope.drawPath-LG529CI$default($this$drawCheck_u2d3IgeMak, obj35.getPathToDraw(), checkColor, obj22, 0, (DrawStyle)stroke, 0, 0, 52);
    }
}
