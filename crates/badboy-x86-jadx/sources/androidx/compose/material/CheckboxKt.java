package androidx.compose.material;

import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
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
@Metadata(d1 = "\u0000h\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001aU\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000c\u0018\u00010\u00102\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u000e2\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010\u0018\u001a-\u0010\u0019\u001a\u00020\u000c2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0003¢\u0006\u0002\u0010\u001c\u001aO\u0010\u001d\u001a\u00020\u000c2\u0006\u0010\u001e\u001a\u00020\u001b2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000c\u0018\u00010 2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u000e2\n\u0008\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\u0010!\u001a6\u0010\"\u001a\u00020\u000c*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0002ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+\u001a>\u0010,\u001a\u00020\u000c*\u00020#2\u0006\u0010-\u001a\u00020%2\u0006\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u00020(2\u0006\u00100\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0002ø\u0001\u0000¢\u0006\u0004\u00083\u00104\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0008\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00065²\u0006\n\u00106\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u00107\u001a\u00020(X\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u0010$\u001a\u00020%X\u008a\u0084\u0002²\u0006\n\u0010&\u001a\u00020%X\u008a\u0084\u0002", d2 = {"BoxInDuration", "", "BoxOutDuration", "CheckAnimationDuration", "CheckboxDefaultPadding", "Landroidx/compose/ui/unit/Dp;", "F", "CheckboxRippleRadius", "CheckboxSize", "RadiusSize", "StrokeWidth", "Checkbox", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/CheckboxColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "CheckboxImpl", "value", "Landroidx/compose/ui/state/ToggleableState;", "(ZLandroidx/compose/ui/state/ToggleableState;Landroidx/compose/ui/Modifier;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;I)V", "TriStateCheckbox", "state", "onClick", "Lkotlin/Function0;", "(Landroidx/compose/ui/state/ToggleableState;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/CheckboxColors;Landroidx/compose/runtime/Composer;II)V", "drawBox", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "boxColor", "Landroidx/compose/ui/graphics/Color;", "borderColor", "radius", "", "strokeWidth", "drawBox-1wkBAMs", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJFF)V", "drawCheck", "checkColor", "checkFraction", "crossCenterGravitation", "strokeWidthPx", "drawingCache", "Landroidx/compose/material/CheckDrawingCache;", "drawCheck-3IgeMak", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFFFLandroidx/compose/material/CheckDrawingCache;)V", "material_release", "checkDrawFraction", "checkCenterGravitationShiftFraction"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class CheckboxKt {

    private static final int BoxInDuration = 50;
    private static final int BoxOutDuration = 100;
    private static final int CheckAnimationDuration = 100;
    private static final float CheckboxDefaultPadding;
    private static final float CheckboxRippleRadius;
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
        int i6 = 0;
        CheckboxKt.CheckboxRippleRadius = Dp.constructor-impl((float)i);
        int i7 = 0;
        CheckboxKt.CheckboxDefaultPadding = Dp.constructor-impl((float)i2);
        int i8 = 0;
        CheckboxKt.CheckboxSize = Dp.constructor-impl((float)i3);
        int i9 = 0;
        CheckboxKt.StrokeWidth = Dp.constructor-impl((float)i4);
        int i10 = 0;
        CheckboxKt.RadiusSize = Dp.constructor-impl((float)i5);
    }

    public static final void Checkbox(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, androidx.compose.material.CheckboxColors colors, Composer $composer, int $changed, int i9) {
        int i4;
        Object invalid$iv;
        boolean traceInProgress;
        int $dirty2;
        Object $dirty;
        int i6;
        int i;
        Object modifier2;
        boolean traceInProgress2;
        int i16;
        boolean z2;
        int skipping;
        int enabled2;
        Object obj3;
        Object rememberedValue;
        Object checkboxColors;
        Object colors-zjMxDiM;
        int i8;
        int i12;
        int i3;
        boolean z;
        int i13;
        boolean i7;
        Object obj;
        int i2;
        Object obj2;
        Composer restartGroup;
        int changed;
        int empty;
        int i11;
        int i14;
        Composer composer;
        int i15;
        int i5;
        int i10;
        Object obj4;
        int obj26;
        final boolean z3 = checked;
        final Object obj5 = onCheckedChange;
        final int i33 = $changed;
        traceInProgress = -2118660998;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(Checkbox)P(!1,5,4,2,3)90@4143L8,92@4160L284:Checkbox.kt#jmzs0o");
        $dirty2 = $changed;
        if (i9 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i33 & 6 == 0) {
                i6 = restartGroup.changed(z3) ? 4 : 2;
                $dirty2 |= i6;
            }
        }
        rememberedValue = 32;
        if (i9 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i33 & 48 == 0) {
                i = restartGroup.changedInstance(obj5) ? rememberedValue : 16;
                $dirty2 |= i;
            }
        }
        int i25 = i9 & 4;
        if (i25 != 0) {
            $dirty2 |= 384;
            colors-zjMxDiM = modifier;
        } else {
            if (i33 & 384 == 0) {
                i8 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i8;
            } else {
                colors-zjMxDiM = modifier;
            }
        }
        i12 = i9 & 8;
        if (i12 != 0) {
            $dirty2 |= 3072;
            z = enabled;
        } else {
            if (i33 & 3072 == 0) {
                i13 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i13;
            } else {
                z = enabled;
            }
        }
        i7 = i9 & 16;
        if (i7 != 0) {
            $dirty2 |= 24576;
            obj = interactionSource;
        } else {
            if (i33 & 24576 == 0) {
                i2 = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty2 |= i2;
            } else {
                obj = interactionSource;
            }
        }
        if (i39 &= i33 == 0) {
            if (i9 & 32 == 0) {
                changed = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                obj2 = colors;
            }
            $dirty2 |= changed;
        } else {
            obj2 = colors;
        }
        if (i43 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i10 = -458753;
                if (i33 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i25 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = colors-zjMxDiM;
                        }
                        enabled2 = i12 != 0 ? 1 : z;
                        obj4 = i7 != 0 ? colors-zjMxDiM : obj;
                        if (i9 & 32 != 0) {
                            composer = restartGroup;
                            restartGroup = composer;
                            $dirty2 &= i10;
                            z = modifier2;
                            i7 = enabled2;
                            obj2 = colors-zjMxDiM;
                            obj = obj4;
                        } else {
                            obj2 = colors;
                            z = modifier2;
                            i7 = enabled2;
                            obj = obj4;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i9 & 32 != 0) {
                            $dirty2 &= i10;
                        }
                        i7 = z;
                        z = colors-zjMxDiM;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty2, -1, "androidx.compose.material.Checkbox (Checkbox.kt:91)");
                }
                if (obj5 != null) {
                    restartGroup.startReplaceGroup(-1450357672);
                    ComposerKt.sourceInformation(restartGroup, "94@4269L29");
                    ComposerKt.sourceInformationMarkerStart(restartGroup, 1477234982, "CC(remember):Checkbox.kt#9igjgp");
                    int i31 = 1;
                    i4 = $dirty2 & 112 == rememberedValue ? i31 : i16;
                    if ($dirty2 & 14 == 4) {
                        i16 = i31;
                    }
                    i4 |= i16;
                    traceInProgress2 = restartGroup;
                    enabled2 = 0;
                    rememberedValue = traceInProgress2.rememberedValue();
                    i12 = 0;
                    if (i20 == 0) {
                        if (rememberedValue == Composer.Companion.getEmpty()) {
                            empty = 0;
                            obj26 = i20;
                            invalid$iv = new CheckboxKt.Checkbox.1.1(obj5, z3);
                            traceInProgress2.updateRememberedValue((Function0)invalid$iv);
                        } else {
                            obj26 = i20;
                            invalid$iv = rememberedValue;
                        }
                    } else {
                    }
                    ComposerKt.sourceInformationMarkerEnd(restartGroup);
                    restartGroup.endReplaceGroup();
                } else {
                    restartGroup.startReplaceGroup(-1450319884);
                    restartGroup.endReplaceGroup();
                    invalid$iv = 0;
                }
                CheckboxKt.TriStateCheckbox(ToggleableStateKt.ToggleableState(z3), invalid$iv, z, i7, obj, obj2, restartGroup, i23 | i30, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i3 = $dirty2;
                $dirty = z;
                z2 = i7;
                obj3 = obj;
                checkboxColors = obj2;
            } else {
                restartGroup.skipToGroupEnd();
                i3 = $dirty2;
                $dirty = colors-zjMxDiM;
                z2 = z;
                obj3 = obj;
                checkboxColors = obj2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new CheckboxKt.Checkbox.2(z3, obj5, $dirty, z2, obj3, checkboxColors, i33, i9);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final void CheckboxImpl(boolean enabled, ToggleableState value, Modifier modifier, androidx.compose.material.CheckboxColors colors, Composer $composer, int $changed) {
        int i5;
        int $changed$iv$iv;
        int i18;
        Float initialValue$iv$iv;
        Object $i$a$CacheCheckboxKt$CheckboxImpl$1;
        Object empty;
        boolean traceInProgress;
        int i7;
        int i12;
        int $composer3;
        Transition $this$animateValue$iv$iv2;
        int $dirty2;
        int $dirty;
        boolean traceInProgress3;
        Transition $this$animateValue$iv$iv;
        int i10;
        int i;
        int i3;
        int i2;
        int it;
        State boxColor;
        State borderColor;
        Modifier requiredSize-3ABfNKs;
        int i13;
        Object $i$a$CacheCheckboxKt$CheckboxImpl$checkCache$1;
        Composer composer;
        int i4;
        boolean traceInProgress2;
        Object rememberedValue;
        int checkDrawingCache;
        int i17;
        Transition companion;
        int i14;
        int i9;
        int i15;
        int $changed$iv$iv2;
        Transition transition2;
        Object obj2;
        Composer $composer2;
        int i11;
        int i16;
        Transition transition;
        Transition $this$animateValue$iv$iv3;
        Float num;
        int i6;
        int i8;
        String str;
        androidx.compose.material.CheckboxKt.CheckboxImpl.1.1 anon;
        Object obj;
        State state2;
        State state;
        State state4;
        State checkDrawFraction$delegate;
        State state3;
        Float obj43;
        final boolean z = enabled;
        final Object obj3 = value;
        final Object obj4 = modifier;
        final Object obj5 = colors;
        i7 = $changed;
        traceInProgress = -2118895727;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(CheckboxImpl)P(1,3,2)263@10929L23,264@10993L443,280@11496L458,295@11976L32,296@12038L21,297@12087L24,298@12142L27,299@12252L508,299@12174L586:Checkbox.kt#jmzs0o");
        rememberedValue = 2;
        if (i7 & 6 == 0) {
            i10 = restartGroup.changed(z) ? 4 : rememberedValue;
            $dirty2 |= i10;
        }
        if (i7 & 48 == 0) {
            i = restartGroup.changed(obj3) ? 32 : 16;
            $dirty2 |= i;
        }
        if (i7 & 384 == 0) {
            i3 = restartGroup.changed(obj4) ? 256 : 128;
            $dirty2 |= i3;
        }
        if (i7 & 3072 == 0) {
            i2 = restartGroup.changed(obj5) ? 2048 : 1024;
            $dirty2 |= i2;
        }
        final int i105 = $dirty2;
        if (i105 & 1171 == 1170) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, i105, -1, "androidx.compose.material.CheckboxImpl (Checkbox.kt:262)");
                }
                Transition transition3 = TransitionKt.updateTransition(obj3, 0, restartGroup, i19 &= 14, rememberedValue);
                androidx.compose.material.CheckboxKt.CheckboxImpl.checkDrawFraction.2 iNSTANCE3 = CheckboxKt.CheckboxImpl.checkDrawFraction.2.INSTANCE;
                int i106 = 0;
                int i107 = 0;
                String str6 = "CC(animateFloat)P(2)1966@80444L78:Transition.kt#pdpnli";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1338768149, str6);
                i15 = 57344;
                $this$animateValue$iv$iv = transition6;
                int i109 = i82;
                int i110 = 0;
                String str10 = "CC(animateValue)P(3,2)1883@77007L32,1884@77062L31,1885@77118L23,1887@77154L89:Transition.kt#pdpnli";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -142660079, str10);
                int i116 = 0;
                Composer transition4 = composer6;
                transition4.startReplaceGroup(-1798345588);
                String str4 = "C:Checkbox.kt#jmzs0o";
                ComposerKt.sourceInformation(transition4, str4);
                String $composer4 = "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:273)";
                if (ComposerKt.isTraceInProgress()) {
                    $this$animateValue$iv$iv3 = $this$animateValue$iv$iv;
                    ComposerKt.traceEventStart(-1798345588, i115 & 112, -1, $composer4);
                } else {
                    $this$animateValue$iv$iv3 = $this$animateValue$iv$iv;
                }
                i6 = 0;
                i8 = 1065353216;
                switch (i29) {
                    case 1:
                        i12 = i8;
                        break;
                    case 2:
                        i12 = i6;
                        break;
                    case 3:
                        i12 = i8;
                        break;
                    default:
                        NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                transition4.endReplaceGroup();
                i16 = 0;
                Composer initialValue$iv$iv3 = composer5;
                int it2 = -1798345588;
                initialValue$iv$iv3.startReplaceGroup(it2);
                ComposerKt.sourceInformation(initialValue$iv$iv3, str4);
                if (ComposerKt.isTraceInProgress()) {
                    $composer2 = initialValue$iv$iv3;
                    ComposerKt.traceEventStart(it2, i85 &= 112, -1, $composer4);
                } else {
                    $composer2 = initialValue$iv$iv3;
                    $composer3 = -1;
                }
                switch (i21) {
                    case 1:
                        i5 = i8;
                        break;
                    case 2:
                        i5 = i6;
                        break;
                    case 3:
                        i5 = i8;
                        break;
                    default:
                        NoWhenBranchMatchedException noWhenBranchMatchedException4 = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer2.endReplaceGroup();
                obj43 = iNSTANCE3;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                androidx.compose.material.CheckboxKt.CheckboxImpl.checkCenterGravitationShiftFraction.2 iNSTANCE2 = CheckboxKt.CheckboxImpl.checkCenterGravitationShiftFraction.2.INSTANCE;
                checkDrawingCache = 0;
                i14 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1338768149, str6);
                i24 |= i35;
                $this$animateValue$iv$iv2 = companion;
                i9 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -142660079, str10);
                Object currentState = $this$animateValue$iv$iv2.getCurrentState();
                Composer composer3 = restartGroup;
                int i100 = 0;
                composer3.startReplaceGroup(-2098942571);
                String str11 = str;
                ComposerKt.sourceInformation(composer3, str11);
                if (ComposerKt.isTraceInProgress()) {
                    $changed$iv$iv2 = $changed$iv$iv;
                    transition2 = $this$animateValue$iv$iv2;
                    obj2 = currentState;
                    ComposerKt.traceEventStart(-2098942571, i66 &= 112, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:289)");
                } else {
                    $changed$iv$iv2 = $changed$iv$iv;
                    transition2 = $this$animateValue$iv$iv2;
                    obj2 = currentState;
                    it = -1;
                }
                switch (i25) {
                    case 1:
                        i18 = i6;
                        break;
                    case 2:
                        i18 = i6;
                        break;
                    case 3:
                        i18 = i8;
                        break;
                    default:
                        NoWhenBranchMatchedException noWhenBranchMatchedException2 = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer3.endReplaceGroup();
                initialValue$iv$iv = Float.valueOf(i18);
                Composer composer4 = restartGroup;
                int i101 = 0;
                int i59 = -2098942571;
                composer4.startReplaceGroup(i59);
                ComposerKt.sourceInformation(composer4, str11);
                if (ComposerKt.isTraceInProgress()) {
                    obj43 = initialValue$iv$iv;
                    ComposerKt.traceEventStart(i59, i68 &= 112, -1, "androidx.compose.material.CheckboxImpl.<anonymous> (Checkbox.kt:289)");
                } else {
                    obj43 = initialValue$iv$iv;
                }
                switch (i26) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        i6 = i8;
                        break;
                    default:
                        NoWhenBranchMatchedException noWhenBranchMatchedException3 = new NoWhenBranchMatchedException();
                        throw noWhenBranchMatchedException3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer4.endReplaceGroup();
                androidx.compose.material.CheckboxKt.CheckboxImpl.checkCenterGravitationShiftFraction.2 anon2 = iNSTANCE2;
                empty = state6;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                State state5 = transitionAnimation2;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 382271049, "CC(remember):Checkbox.kt#9igjgp");
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
                    $i$a$CacheCheckboxKt$CheckboxImpl$checkCache$1 = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                $dirty = obj5.checkmarkColor(obj3, restartGroup, i54 |= i62);
                boxColor = obj5.boxColor(z, obj3, restartGroup, i64 |= i73);
                borderColor = obj5.borderColor(z, obj3, restartGroup, i75 |= i91);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 382280357, "CC(remember):Checkbox.kt#9igjgp");
                composer = restartGroup;
                i4 = 0;
                rememberedValue = composer.rememberedValue();
                i17 = 0;
                if (i97 |= changed9 == 0) {
                    checkDrawFraction$delegate = empty;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int checkDrawFraction$delegate2 = 0;
                        anon = new CheckboxKt.CheckboxImpl.1.1((CheckDrawingCache)$i$a$CacheCheckboxKt$CheckboxImpl$checkCache$1, boxColor, borderColor, $dirty, checkDrawFraction$delegate, state5);
                        composer.updateRememberedValue((Function1)anon);
                    } else {
                        state3 = state5;
                        state4 = $dirty;
                        state2 = boxColor;
                        state = borderColor;
                        $i$a$CacheCheckboxKt$CheckboxImpl$1 = rememberedValue;
                    }
                } else {
                    checkDrawFraction$delegate = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.requiredSize-3ABfNKs(SizeKt.wrapContentSize$default(obj4, Alignment.Companion.getCenter(), false, 2, 0), CheckboxKt.CheckboxSize), (Function1)$i$a$CacheCheckboxKt$CheckboxImpl$1, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    traceInProgress = new CheckboxKt.CheckboxImpl.2(z, obj3, obj4, obj5, $changed);
                    endRestartGroup.updateScope((Function2)traceInProgress);
                }
            }
            restartGroup.skipToGroupEnd();
        } else {
        }
    }

    private static final float CheckboxImpl$lambda$2(State<Float> $checkDrawFraction$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$checkDrawFraction$delegate.getValue().floatValue();
    }

    private static final float CheckboxImpl$lambda$4(State<Float> $checkCenterGravitationShiftFraction$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$checkCenterGravitationShiftFraction$delegate.getValue().floatValue();
    }

    private static final long CheckboxImpl$lambda$6(State<Color> $checkColor$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Color)$checkColor$delegate.getValue().unbox-impl();
    }

    private static final long CheckboxImpl$lambda$7(State<Color> $boxColor$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Color)$boxColor$delegate.getValue().unbox-impl();
    }

    private static final long CheckboxImpl$lambda$8(State<Color> $borderColor$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Color)$borderColor$delegate.getValue().unbox-impl();
    }

    public static final void TriStateCheckbox(ToggleableState state, Function0<Unit> onClick, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, androidx.compose.material.CheckboxColors colors, Composer $composer, int $changed, int i9) {
        int companion;
        int $dirty;
        Object traceInProgress2;
        Object obj4;
        Modifier minimumInteractiveComponentSize;
        Object obj5;
        Object obj3;
        int i;
        int i11;
        boolean colors2;
        int $dirty2;
        Object modifier2;
        Object enabled2;
        Object obj7;
        boolean traceInProgress;
        int i5;
        Object obj;
        int interactionSource3;
        boolean colors-zjMxDiM;
        int i13;
        int i6;
        int checkboxRippleRadius;
        Object interactionSource2;
        int i2;
        Object obj6;
        Composer restartGroup;
        int changed;
        boolean defaultsInvalid;
        int i8;
        Object obj2;
        int i12;
        int i4;
        Composer composer;
        int i3;
        int i10;
        int i7;
        final int i29 = $changed;
        companion = 2031255194;
        restartGroup = $composer.startRestartGroup(companion);
        ComposerKt.sourceInformation(restartGroup, "C(TriStateCheckbox)P(5,4,3,1,2)136@6392L8,154@6932L412:Checkbox.kt#jmzs0o");
        $dirty = $changed;
        if (i9 & 1 != 0) {
            $dirty |= 6;
            obj5 = state;
        } else {
            if (i29 & 6 == 0) {
                i = restartGroup.changed(state) ? 4 : 2;
                $dirty |= i;
            } else {
                obj5 = state;
            }
        }
        if (i9 & 2 != 0) {
            $dirty |= 48;
        } else {
            if (i29 & 48 == 0) {
                i11 = restartGroup.changedInstance(onClick) ? 32 : 16;
                $dirty |= i11;
            }
        }
        int i21 = i9 & 4;
        if (i21 != 0) {
            $dirty |= 384;
            enabled2 = modifier;
        } else {
            if (i29 & 384 == 0) {
                i5 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty |= i5;
            } else {
                enabled2 = modifier;
            }
        }
        interactionSource3 = i9 & 8;
        if (interactionSource3 != 0) {
            $dirty |= 3072;
            colors-zjMxDiM = enabled;
        } else {
            if (i29 & 3072 == 0) {
                i13 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty |= i13;
            } else {
                colors-zjMxDiM = enabled;
            }
        }
        checkboxRippleRadius = i9 & 16;
        if (checkboxRippleRadius != 0) {
            $dirty |= 24576;
            interactionSource2 = interactionSource;
        } else {
            if (i29 & 24576 == 0) {
                i2 = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty |= i2;
            } else {
                interactionSource2 = interactionSource;
            }
        }
        if (i34 &= i29 == 0) {
            if (i9 & 32 == 0) {
                changed = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                obj6 = colors;
            }
            $dirty |= changed;
        } else {
            obj6 = colors;
        }
        i8 = 74898;
        if (i37 &= $dirty == i8) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                i7 = -458753;
                if (i29 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i21 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = enabled2;
                        }
                        enabled2 = interactionSource3 != 0 ? 1 : colors-zjMxDiM;
                        interactionSource3 = checkboxRippleRadius != 0 ? 0 : interactionSource2;
                        if (i9 & 32 != 0) {
                            composer = restartGroup;
                            restartGroup = composer;
                            obj2 = modifier2;
                            obj4 = interactionSource3;
                            i12 = colors-zjMxDiM;
                            $dirty2 = $dirty3;
                            $dirty = enabled2;
                        } else {
                            i12 = colors;
                            obj2 = modifier2;
                            obj4 = interactionSource3;
                            $dirty2 = $dirty;
                            $dirty = enabled2;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i9 & 32 != 0) {
                            $dirty &= i7;
                        }
                        $dirty2 = $dirty;
                        obj2 = enabled2;
                        $dirty = colors-zjMxDiM;
                        obj4 = interactionSource2;
                        i12 = obj6;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(companion, $dirty2, -1, "androidx.compose.material.TriStateCheckbox (Checkbox.kt:137)");
                }
                if (onClick != null) {
                    restartGroup.startReplaceGroup(1923882473);
                    ComposerKt.sourceInformation(restartGroup, "146@6729L136");
                    colors-zjMxDiM = $dirty2;
                    $dirty2 = $dirty;
                    companion = ToggleableKt.triStateToggleable-O2vRcR0((Modifier)Modifier.Companion, obj5, obj4, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, CheckboxKt.CheckboxRippleRadius, 0, obj6, restartGroup, 54), $dirty2, Role.box-impl(Role.Companion.getCheckbox-o7Vup1c()), onClick);
                    interactionSource2 = obj4;
                    $dirty = $dirty2;
                    restartGroup.endReplaceGroup();
                } else {
                    interactionSource2 = obj4;
                    colors-zjMxDiM = $dirty2;
                    restartGroup.startReplaceGroup(1924298803);
                    restartGroup.endReplaceGroup();
                    companion = Modifier.Companion;
                }
                if (onClick != null) {
                    minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize((Modifier)Modifier.Companion);
                } else {
                    minimumInteractiveComponentSize = Modifier.Companion;
                }
                Object obj9 = i12;
                CheckboxKt.CheckboxImpl($dirty, state, PaddingKt.padding-3ABfNKs(obj2.then(minimumInteractiveComponentSize).then(companion), CheckboxKt.CheckboxDefaultPadding), obj9, restartGroup, i18 | i25);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj = obj9;
                i6 = colors-zjMxDiM;
                obj3 = obj2;
                colors2 = $dirty;
                obj7 = interactionSource2;
            } else {
                restartGroup.skipToGroupEnd();
                i6 = $dirty;
                obj3 = enabled2;
                colors2 = colors-zjMxDiM;
                obj = obj6;
                obj7 = interactionSource2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            companion = new CheckboxKt.TriStateCheckbox.1(state, onClick, obj3, colors2, obj7, obj, i29, i9);
            endRestartGroup.updateScope((Function2)companion);
        }
    }

    public static final void access$CheckboxImpl(boolean enabled, ToggleableState value, Modifier modifier, androidx.compose.material.CheckboxColors colors, Composer $composer, int $changed) {
        CheckboxKt.CheckboxImpl(enabled, value, modifier, colors, $composer, $changed);
    }

    public static final float access$CheckboxImpl$lambda$2(State $checkDrawFraction$delegate) {
        return CheckboxKt.CheckboxImpl$lambda$2($checkDrawFraction$delegate);
    }

    public static final float access$CheckboxImpl$lambda$4(State $checkCenterGravitationShiftFraction$delegate) {
        return CheckboxKt.CheckboxImpl$lambda$4($checkCenterGravitationShiftFraction$delegate);
    }

    public static final long access$CheckboxImpl$lambda$6(State $checkColor$delegate) {
        return CheckboxKt.CheckboxImpl$lambda$6($checkColor$delegate);
    }

    public static final long access$CheckboxImpl$lambda$7(State $boxColor$delegate) {
        return CheckboxKt.CheckboxImpl$lambda$7($boxColor$delegate);
    }

    public static final long access$CheckboxImpl$lambda$8(State $borderColor$delegate) {
        return CheckboxKt.CheckboxImpl$lambda$8($borderColor$delegate);
    }

    public static final void access$drawBox-1wkBAMs(DrawScope $receiver, long boxColor, long borderColor, float radius, float strokeWidth) {
        CheckboxKt.drawBox-1wkBAMs($receiver, boxColor, borderColor, radius, strokeWidth);
    }

    public static final void access$drawCheck-3IgeMak(DrawScope $receiver, long checkColor, float checkFraction, float crossCenterGravitation, float strokeWidthPx, androidx.compose.material.CheckDrawingCache drawingCache) {
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
        int i12;
        Object obj;
        DrawScope drawScope;
        int i7;
        long l4;
        long l5;
        Fill fill;
        int i8;
        int i5;
        int i6;
        int i2;
        int i;
        Object obj2;
        long l2;
        long l6;
        long l;
        long l3;
        Stroke stroke;
        int i3;
        int i9;
        int i11;
        int i4;
        int i10;
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
            i4 = 224;
            i10 = 0;
            i3 = 0;
            i9 = 0;
            i11 = 0;
            obj2 = $this$drawBox_u2d1wkBAMs;
            DrawScope.drawRoundRect-u-Aw5IA$default(obj2, boxColor, obj27, OffsetKt.Offset(i14, i14), obj29, SizeKt.Size(width-impl - i27, width-impl - i17), obj31, CornerRadiusKt.CornerRadius$default(Math.max(i24, f - i14), i24, i26, i22), obj33, (DrawStyle)Fill.INSTANCE, i3);
            DrawScope.drawRoundRect-u-Aw5IA$default(obj2, radius, obj27, OffsetKt.Offset(i29, i29), obj29, SizeKt.Size(width-impl - i14, width-impl - i14), obj31, CornerRadiusKt.CornerRadius$default(f - i29, i24, i26, i22), obj33, (DrawStyle)stroke2, i3);
        }
    }

    private static final void drawCheck-3IgeMak(DrawScope $this$drawCheck_u2d3IgeMak, long checkColor, float checkFraction, float crossCenterGravitation, float strokeWidthPx, androidx.compose.material.CheckDrawingCache drawingCache) {
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
