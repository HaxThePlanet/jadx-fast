package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.ToggleableKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeCap.Companion;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.Role.Companion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u001aU\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001a2\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\u001d\u001a\u00020\u00182\n\u0008\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0008\u0008\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u0010\"\u001a?\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00020&2\u0006\u0010\u001e\u001a\u00020'H\u0003¢\u0006\u0002\u0010(\u001a.\u0010)\u001a\u00020\u0016*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\u0008/\u00100\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0008\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u000b\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\u000c\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u0011\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\u0012\u0010\r\"\u0016\u0010\u0013\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\u0014\u0010\r\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00061²\u0006\n\u00102\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\u0018\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001aX\u008a\u0084\u0002²\u0006\n\u00104\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020,X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u00020,X\u008a\u0084\u0002²\u0006\n\u00106\u001a\u00020,X\u008a\u0084\u0002", d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DefaultSwitchPadding", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchHeight", "SwitchPositionalThreshold", "SwitchVelocityThreshold", "SwitchWidth", "ThumbDefaultElevation", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPathLength", "ThumbPressedElevation", "ThumbRippleRadius", "TrackStrokeWidth", "getTrackStrokeWidth", "TrackWidth", "getTrackWidth", "Switch", "", "checked", "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Lkotlin/Function0;", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", "strokeWidth", "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "material_release", "forceAnimationCheck", "currentOnCheckedChange", "currentChecked", "thumbColor", "resolvedThumbColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SwitchKt {

    private static final TweenSpec<Float> AnimationSpec = null;
    private static final float DefaultSwitchPadding = 0f;
    private static final float SwitchHeight = 0f;
    private static final float SwitchPositionalThreshold = 0.7f;
    private static final float SwitchVelocityThreshold;
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation;
    private static final float ThumbDiameter;
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation;
    private static final float ThumbRippleRadius;
    private static final float TrackStrokeWidth;
    private static final float TrackWidth;
    static {
        int i9 = 0;
        SwitchKt.TrackWidth = Dp.constructor-impl((float)i);
        int i10 = 0;
        SwitchKt.TrackStrokeWidth = Dp.constructor-impl((float)i2);
        int i11 = 0;
        SwitchKt.ThumbDiameter = Dp.constructor-impl((float)i3);
        int i12 = 0;
        SwitchKt.ThumbRippleRadius = Dp.constructor-impl((float)i4);
        int i13 = 0;
        SwitchKt.DefaultSwitchPadding = Dp.constructor-impl((float)i5);
        SwitchKt.SwitchWidth = SwitchKt.TrackWidth;
        SwitchKt.SwitchHeight = SwitchKt.ThumbDiameter;
        int i17 = 0;
        SwitchKt.ThumbPathLength = Dp.constructor-impl(trackWidth2 - thumbDiameter2);
        TweenSpec tweenSpec = new TweenSpec(100, 0, 0, 6, 0);
        SwitchKt.AnimationSpec = tweenSpec;
        int i14 = 0;
        SwitchKt.ThumbDefaultElevation = Dp.constructor-impl((float)i6);
        int i15 = 0;
        SwitchKt.ThumbPressedElevation = Dp.constructor-impl((float)i7);
        int i16 = 0;
        SwitchKt.SwitchVelocityThreshold = Dp.constructor-impl((float)i8);
    }

    public static final void Switch(boolean checked, Function1<? super Boolean, Unit> onCheckedChange, Modifier modifier, boolean enabled, MutableInteractionSource interactionSource, androidx.compose.material.SwitchColors colors, Composer $composer, int $changed, int i9) {
        int i2;
        int i8;
        Modifier companion;
        Object it$iv2;
        int anon2;
        Modifier minimumInteractiveComponentSize;
        Integer currentCompositionLocalMap;
        Object invalid$iv2;
        boolean traceInProgress;
        Object obj3;
        Object obj5;
        Function0 factory$iv$iv$iv;
        Object $composer2;
        int $composer3;
        Object empty;
        Object anchoredDraggableState3;
        int empty2;
        Object $composer4;
        int $dirty2;
        boolean traceInProgress2;
        int invalid$iv4;
        Composer currentOnCheckedChange$delegate;
        int i17;
        Object it$iv;
        boolean enabled4;
        boolean $dirty;
        int i12;
        int i18;
        Object modifier2;
        Object box-impl;
        Composer composer;
        int valueOf2;
        Object obj8;
        Object obj6;
        int empty3;
        Object switchColors;
        Object mutableStateOf$default;
        float px-0680j_4;
        int colors2;
        int defaultsInvalid;
        Object obj7;
        Composer $composer5;
        int i10;
        int i5;
        int i19;
        boolean z2;
        int i3;
        boolean z;
        int enabled2;
        boolean contentAlignment$iv;
        Object i11;
        int i4;
        Object propagateMinConstraints$iv;
        int changed;
        int measurePolicy$iv;
        androidx.compose.material.AnchoredDraggableState isRtl;
        int enabled3;
        int i13;
        int i14;
        int maxBound;
        int invalid$iv;
        int i6;
        int companion2;
        int anchoredDraggableState;
        Object obj2;
        State state;
        int i23;
        Object obj4;
        int i20;
        int i7;
        Composer composer2;
        int i21;
        int i22;
        int $this$Switch_u24lambda_u2412;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        boolean z3;
        Object obj;
        androidx.compose.material.AnchoredDraggableState anchoredDraggableState2;
        Boolean valueOf;
        androidx.compose.material.DraggableAnchors draggableAnchors;
        androidx.compose.material.SwitchKt.Switch.anchoredDraggableState.1.2 anon;
        androidx.compose.material.SwitchKt.Switch.anchoredDraggableState.1.3 companion3;
        TweenSpec invalid$iv3;
        int i15;
        int i;
        int i16;
        androidx.compose.ui.Modifier.Companion obj45;
        int obj46;
        int obj47;
        int obj48;
        int obj49;
        traceInProgress = checked;
        $composer2 = onCheckedChange;
        px-0680j_4 = $changed;
        anon2 = 25866825;
        Composer restartGroup = $composer.startRestartGroup(anon2);
        ComposerKt.sourceInformation(restartGroup, "C(Switch)P(!1,5,4,2,3)98@4560L8,*103@4753L7,108@5135L34,109@5224L7,110@5301L447,122@5783L37,123@5847L29,124@5920L315,124@5881L354,133@6285L133,133@6240L178,138@6456L7,153@6897L1050:Switch.kt#jmzs0o");
        $dirty2 = $changed;
        if (i9 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (px-0680j_4 & 6 == 0) {
                i12 = restartGroup.changed(traceInProgress) ? 4 : 2;
                $dirty2 |= i12;
            }
        }
        if (i9 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (px-0680j_4 & 48 == 0) {
                i18 = restartGroup.changedInstance($composer2) ? 32 : 16;
                $dirty2 |= i18;
            }
        }
        int i52 = i9 & 4;
        if (i52 != 0) {
            $dirty2 |= 384;
            obj7 = modifier;
        } else {
            if (px-0680j_4 & 384 == 0) {
                i10 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i10;
            } else {
                obj7 = modifier;
            }
        }
        int i77 = i9 & 8;
        if (i77 != 0) {
            $dirty2 |= 3072;
            z2 = enabled;
        } else {
            if (px-0680j_4 & 3072 == 0) {
                i3 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i3;
            } else {
                z2 = enabled;
            }
        }
        contentAlignment$iv = i9 & 16;
        if (contentAlignment$iv != 0) {
            $dirty2 |= 24576;
            i11 = interactionSource;
        } else {
            if (px-0680j_4 & 24576 == 0) {
                i4 = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty2 |= i4;
            } else {
                i11 = interactionSource;
            }
        }
        if (i85 &= px-0680j_4 == 0) {
            if (i9 & 32 == 0) {
                changed = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                propagateMinConstraints$iv = colors;
            }
            $dirty2 |= changed;
        } else {
            propagateMinConstraints$iv = colors;
        }
        i91 &= $dirty2;
        if (measurePolicy$iv == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i107 = -458753;
                if (px-0680j_4 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i52 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj7;
                        }
                        z3 = i77 != 0 ? defaultsInvalid : z2;
                        obj = contentAlignment$iv != 0 ? defaultsInvalid : i11;
                        if (i9 & 32 != 0) {
                            composer2 = restartGroup;
                            $composer3 = 2;
                            $composer5 = composer2;
                            i5 = $dirty2;
                            i11 = colors-SQMK_m0;
                            z = z3;
                            colors2 = modifier2;
                        } else {
                            $composer5 = restartGroup;
                            $composer3 = 2;
                            i11 = colors;
                            i5 = $dirty2;
                            colors2 = modifier2;
                            z = z3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i9 & 32 != 0) {
                            $dirty2 &= i107;
                        }
                        i5 = $dirty2;
                        colors2 = obj7;
                        z = z2;
                        obj = i11;
                        i11 = propagateMinConstraints$iv;
                        $composer5 = restartGroup;
                        $composer3 = 2;
                    }
                } else {
                }
                $composer5.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon2, i5, -1, "androidx.compose.material.Switch (Switch.kt:99)");
                }
                String str3 = "CC(remember):Switch.kt#9igjgp";
                if (obj == null) {
                    $composer5.startReplaceGroup(-1604953567);
                    ComposerKt.sourceInformation($composer5, "101@4654L39");
                    ComposerKt.sourceInformationMarkerStart($composer5, 779511297, str3);
                    i2 = 0;
                    traceInProgress2 = $composer5;
                    modifier2 = 0;
                    propagateMinConstraints$iv = traceInProgress2.rememberedValue();
                    measurePolicy$iv = 0;
                    if (propagateMinConstraints$iv == Composer.Companion.getEmpty()) {
                        int i63 = 0;
                        traceInProgress2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        obj6 = propagateMinConstraints$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer5);
                    $composer5.endReplaceGroup();
                } else {
                    $composer5.startReplaceGroup(779510646);
                    $composer5.endReplaceGroup();
                    obj6 = obj;
                }
                Object obj12 = obj6;
                int i87 = 0;
                int i41 = 0;
                int i53 = 0;
                String str5 = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, str5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                int i42 = 0;
                float $this$Switch_u24lambda_u241 = (Density)$composer5.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(SwitchKt.ThumbPathLength);
                ComposerKt.sourceInformationMarkerStart($composer5, 779526684, str3);
                int i44 = 0;
                Composer composer4 = $composer5;
                int i93 = 0;
                Object rememberedValue4 = composer4.rememberedValue();
                int i96 = 0;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    obj48 = i40;
                    invalid$iv = i44;
                    empty = 0;
                    composer4.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(false, empty, 2, empty));
                } else {
                    invalid$iv = i44;
                    obj47 = 0;
                    invalid$iv4 = 2;
                    mutableStateOf$default = rememberedValue4;
                }
                obj4 = mutableStateOf$default;
                ComposerKt.sourceInformationMarkerEnd($composer5);
                int i54 = 0;
                int i65 = 0;
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, str5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                int i55 = 0;
                px-0680j_4 = (Density)$composer5.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(SwitchKt.SwitchVelocityThreshold);
                ComposerKt.sourceInformationMarkerStart($composer5, 779532409, str3);
                changed2 |= changed3;
                Composer composer5 = $composer5;
                int i66 = 0;
                Object rememberedValue3 = composer5.rememberedValue();
                int i97 = 0;
                if (empty2 == 0) {
                    obj48 = empty2;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        companion2 = invalid$iv5;
                        SwitchKt.Switch.anchoredDraggableState.1.1 anon3 = new SwitchKt.Switch.anchoredDraggableState.1.1(i87, $this$Switch_u24lambda_u241);
                        SwitchKt.Switch.anchoredDraggableState.1.3 anon4 = new SwitchKt.Switch.anchoredDraggableState.1.3(px-0680j_4);
                        anchoredDraggableState2 = new AnchoredDraggableState(Boolean.valueOf(traceInProgress), AnchoredDraggableKt.DraggableAnchors((Function1)anon3), (Function1)SwitchKt.Switch.anchoredDraggableState.1.2.INSTANCE, (Function0)anon4, (AnimationSpec)SwitchKt.AnimationSpec, 0, 32, 0);
                        composer5.updateRememberedValue(anchoredDraggableState2);
                    } else {
                        anchoredDraggableState3 = rememberedValue3;
                    }
                } else {
                    obj48 = empty2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState($composer2, $composer5, i45 &= 14);
                State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(traceInProgress), $composer5, i5 & 14);
                ComposerKt.sourceInformationMarkerStart($composer5, 779552085, str3);
                obj48 = $composer5;
                int i98 = 0;
                float f2 = $this$Switch_u24lambda_u241;
                Object rememberedValue = obj48.rememberedValue();
                int i104 = 0;
                if (i69 |= changed11 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i39 = 0;
                        companion2 = new SwitchKt.Switch.1.1(anchoredDraggableState3, rememberUpdatedState2, rememberUpdatedState, (MutableState)obj4, 0);
                        obj48.updateRememberedValue((Function2)companion2);
                    } else {
                        obj3 = rememberedValue;
                        i23 = rememberUpdatedState;
                        state = rememberUpdatedState2;
                        currentOnCheckedChange$delegate = obj48;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                EffectsKt.LaunchedEffect(anchoredDraggableState3, (Function2)obj3, $composer5, obj47);
                ComposerKt.sourceInformationMarkerStart($composer5, 779563583, str3);
                i13 = 1;
                i17 = i5 & 14 == 4 ? i13 : 0;
                Composer composer6 = $composer5;
                empty3 = 0;
                it$iv = composer6.rememberedValue();
                int i102 = 0;
                if (i17 |= changed4 == 0) {
                    obj49 = empty3;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        obj2 = it$iv;
                        i20 = $i$f$cache;
                        it$iv = new SwitchKt.Switch.2.1(traceInProgress, anchoredDraggableState3, 0);
                        composer6.updateRememberedValue((Function2)it$iv);
                    } else {
                        obj2 = it$iv;
                    }
                } else {
                    obj49 = empty3;
                }
                ComposerKt.sourceInformationMarkerEnd($composer5);
                EffectsKt.LaunchedEffect(Boolean.valueOf(traceInProgress), Boolean.valueOf(SwitchKt.Switch$lambda$3(obj4)), (Function2)it$iv, $composer5, i5 & 14);
                int i36 = 0;
                int i50 = 0;
                ComposerKt.sourceInformationMarkerStart($composer5, 2023513938, str5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                i8 = $composer5.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? i13 : 0;
                int i92 = i8;
                if (onCheckedChange != null) {
                    maxBound = i92;
                    isRtl = anchoredDraggableState5;
                    anchoredDraggableState = f;
                    enabled2 = 2;
                    companion = ToggleableKt.toggleable-O2vRcR0((Modifier)Modifier.Companion, traceInProgress, obj12, 0, z, Role.box-impl(Role.Companion.getSwitch-o7Vup1c()), onCheckedChange);
                } else {
                    enabled4 = z;
                    anchoredDraggableState = f2;
                    obj5 = obj12;
                    enabled2 = 2;
                    maxBound = i92;
                    isRtl = anchoredDraggableState3;
                    companion = Modifier.Companion;
                }
                if (onCheckedChange != null) {
                    minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize((Modifier)Modifier.Companion);
                } else {
                    minimumInteractiveComponentSize = Modifier.Companion;
                }
                if (enabled4 && onCheckedChange != null) {
                    if (onCheckedChange != null) {
                    } else {
                        i13 = 0;
                    }
                } else {
                }
                i6 = obj5;
                androidx.compose.material.AnchoredDraggableState anchoredDraggableState4 = isRtl;
                int i88 = 0;
                Modifier requiredSize-VpY3zN4 = SizeKt.requiredSize-VpY3zN4(PaddingKt.padding-3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(colors2.then(minimumInteractiveComponentSize).then(companion), isRtl, Orientation.Horizontal, i13, maxBound, i6, false), Alignment.Companion.getCenter(), i88, enabled2, 0), SwitchKt.DefaultSwitchPadding), SwitchKt.SwitchWidth, SwitchKt.SwitchHeight);
                valueOf2 = i88;
                int i72 = 0;
                ComposerKt.sourceInformationMarkerStart($composer5, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart = Alignment.Companion.getTopStart();
                int i89 = 0;
                androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i89);
                i20 = 0;
                obj45 = companion;
                obj46 = i32;
                ComposerKt.sourceInformationMarkerStart($composer5, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = $composer5.getCurrentCompositionLocalMap();
                obj47 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier($composer5, requiredSize-VpY3zN4);
                obj48 = requiredSize-VpY3zN4;
                obj49 = constructor;
                i7 = 0;
                ComposerKt.sourceInformationMarkerStart($composer5, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $composer5.startReusableNode();
                if ($composer5.getInserting()) {
                    $composer5.createNode(obj49);
                } else {
                    factory$iv$iv$iv = obj49;
                    $composer5.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl($composer5);
                int i99 = 0;
                i22 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i105 = 0;
                obj49 = constructor-impl;
                int i106 = 0;
                if (!obj49.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    z3 = valueOf2;
                    if (!Intrinsics.areEqual(obj49.rememberedValue(), Integer.valueOf(obj47))) {
                        obj49.updateRememberedValue(Integer.valueOf(obj47));
                        constructor-impl.apply(Integer.valueOf(obj47), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = obj49;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    z3 = valueOf2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer3 = $composer5;
                int i51 = 0;
                obj49 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                Composer composer8 = composer3;
                i21 = 0;
                anchoredDraggableState2 = i34;
                ComposerKt.sourceInformationMarkerStart(composer3, -277232920, "C179@7838L42,175@7683L258:Switch.kt#jmzs0o");
                ComposerKt.sourceInformationMarkerStart(composer3, 545251075, str3);
                invalid$iv2 = composer3.changed(anchoredDraggableState4);
                Composer composer7 = composer3;
                int i100 = 0;
                it$iv2 = composer7.rememberedValue();
                anon = 0;
                if (!invalid$iv2) {
                    invalid$iv3 = invalid$iv2;
                    if (it$iv2 == Composer.Companion.getEmpty()) {
                        invalid$iv2 = 0;
                        companion3 = it$iv2;
                        it$iv2 = new SwitchKt.Switch.3.1.1(anchoredDraggableState4);
                        composer7.updateRememberedValue((Function0)it$iv2);
                    } else {
                        companion3 = it$iv2;
                    }
                } else {
                    invalid$iv3 = invalid$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                $this$Switch_u24lambda_u2412 = measurePolicy;
                Alignment measurePolicy$iv2 = topStart;
                contentAlignment$iv = z6;
                enabled3 = composer3;
                $composer2 = i89;
                SwitchKt.SwitchImpl((BoxScope)BoxScopeInstance.INSTANCE, (Boolean)anchoredDraggableState4.getTargetValue().booleanValue(), contentAlignment$iv, i11, (Function0)it$iv2, (InteractionSource)i6, enabled3, i30 |= i81);
                ComposerKt.sourceInformationMarkerEnd(enabled3);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                $composer5.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                ComposerKt.sourceInformationMarkerEnd($composer5);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i19 = anon2;
                $composer4 = colors2;
                $dirty = contentAlignment$iv;
                switchColors = i11;
                obj8 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                $composer5 = restartGroup;
                $composer4 = obj9;
                i19 = $dirty2;
                $dirty = z2;
                obj8 = i11;
                switchColors = propagateMinConstraints$iv;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer5.endRestartGroup();
        if (endRestartGroup != null) {
            anon2 = new SwitchKt.Switch.4(checked, onCheckedChange, $composer4, $dirty, obj8, switchColors, $changed, i9);
            endRestartGroup.updateScope((Function2)anon2);
        }
    }

    private static final boolean Switch$lambda$3(MutableState<Boolean> $forceAnimationCheck$delegate) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)(State)$forceAnimationCheck$delegate.getValue().booleanValue();
    }

    private static final void Switch$lambda$4(MutableState<Boolean> $forceAnimationCheck$delegate, boolean value) {
        final int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        $forceAnimationCheck$delegate.setValue(Boolean.valueOf(value));
    }

    private static final Function1<Boolean, Unit> Switch$lambda$7(State<? extends Function1<? super Boolean, Unit>> $currentOnCheckedChange$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Function1)$currentOnCheckedChange$delegate.getValue();
    }

    private static final boolean Switch$lambda$8(State<Boolean> $currentChecked$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$currentChecked$delegate.getValue().booleanValue();
    }

    private static final void SwitchImpl(BoxScope $this$SwitchImpl, boolean checked, boolean enabled, androidx.compose.material.SwitchColors colors, Function0<Float> thumbValue, InteractionSource interactionSource, Composer $composer, int $changed) {
        Object anon;
        int i13;
        Object invalid$iv2;
        int traceInProgress;
        String str;
        boolean circleShape;
        Object elevationOverlay;
        Object anon2;
        float i8;
        int $dirty;
        int skipping;
        boolean traceInProgress2;
        long l;
        int i20;
        int i4;
        int i9;
        int i18;
        int i19;
        int i2;
        int thumbRippleRadius;
        int invalid$iv;
        float thumbDefaultElevation;
        long apply-7g2Lkgo;
        int i14;
        int empty;
        Composer restartGroup;
        int i12;
        Object anon3;
        int i16;
        Object mutableStateListOf;
        int i6;
        int i15;
        int animateColorAsState-euL9pac;
        State state;
        State state2;
        int i21;
        int i;
        Composer.Companion companion2;
        int companion;
        int i5;
        Modifier requiredSize-3ABfNKs;
        float f;
        androidx.compose.foundation.shape.RoundedCornerShape roundedCornerShape;
        int i11;
        int i10;
        int i3;
        int i7;
        int i17;
        androidx.compose.runtime.snapshots.SnapshotStateList interactions;
        final Object obj = $this$SwitchImpl;
        circleShape = checked;
        elevationOverlay = enabled;
        final Object obj2 = colors;
        final Object obj3 = thumbValue;
        final Object obj4 = interactionSource;
        i8 = $changed;
        traceInProgress = 70908914;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(SwitchImpl)P(!1,2!1,4)221@9029L46,223@9115L614,223@9081L648,242@9932L28,246@10055L81,243@9965L171,249@10166L28,250@10244L7,*251@10303L7,253@10414L6,252@10353L228,262@10673L43,265@10826L133,259@10586L549:Switch.kt#jmzs0o");
        if (i8 & 6 == 0) {
            i20 = restartGroup.changed(obj) ? 4 : 2;
            $dirty |= i20;
        }
        if (i8 & 48 == 0) {
            i4 = restartGroup.changed(circleShape) ? 32 : 16;
            $dirty |= i4;
        }
        if (i8 & 384 == 0) {
            i9 = restartGroup.changed(elevationOverlay) ? 256 : 128;
            $dirty |= i9;
        }
        if (i8 & 3072 == 0) {
            i18 = restartGroup.changed(obj2) ? 2048 : 1024;
            $dirty |= i18;
        }
        if (i8 & 24576 == 0) {
            i19 = restartGroup.changedInstance(obj3) ? 16384 : 8192;
            $dirty |= i19;
        }
        i14 = 131072;
        if (i36 &= i8 == 0) {
            i2 = restartGroup.changed(obj4) ? i14 : 65536;
            $dirty |= i2;
        }
        animateColorAsState-euL9pac = $dirty;
        if ($dirty2 &= animateColorAsState-euL9pac == 74898) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, animateColorAsState-euL9pac, -1, "androidx.compose.material.SwitchImpl (Switch.kt:220)");
                }
                String str5 = "CC(remember):Switch.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 463286824, str5);
                int i23 = 0;
                Composer composer2 = restartGroup;
                int i62 = 0;
                Object rememberedValue3 = composer2.rememberedValue();
                int i70 = 0;
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    int i69 = 0;
                    composer2.updateRememberedValue(SnapshotStateKt.mutableStateListOf());
                } else {
                    mutableStateListOf = rememberedValue3;
                }
                invalid$iv2 = mutableStateListOf;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 463290144, str5);
                invalid$iv = i38 &= animateColorAsState-euL9pac == i14 ? 1 : 0;
                Composer composer3 = restartGroup;
                int i66 = 0;
                Object rememberedValue2 = composer3.rememberedValue();
                int i71 = 0;
                if (invalid$iv == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        mutableStateListOf = 0;
                        i = invalid$iv;
                        anon2 = new SwitchKt.SwitchImpl.1.1(obj4, (SnapshotStateList)invalid$iv2, 0);
                        composer3.updateRememberedValue((Function2)anon2);
                    } else {
                        i = invalid$iv;
                        anon2 = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.LaunchedEffect(obj4, (Function2)anon2, restartGroup, i40 &= 14);
                empty2 ^= 1;
                thumbDefaultElevation = i33 != 0 ? SwitchKt.ThumbPressedElevation : SwitchKt.ThumbDefaultElevation;
                f = thumbDefaultElevation;
                State trackColor = obj2.trackColor(elevationOverlay, circleShape, restartGroup, i44 |= i52);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 463319691, str5);
                Composer composer4 = restartGroup;
                int i72 = 0;
                Object rememberedValue4 = composer4.rememberedValue();
                int i74 = 0;
                if (!restartGroup.changed(trackColor)) {
                    interactions = invalid$iv2;
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        companion = interactions2;
                        anon = new SwitchKt.SwitchImpl.2.1(trackColor);
                        composer4.updateRememberedValue((Function1)anon);
                    } else {
                        anon = rememberedValue4;
                    }
                } else {
                    interactions = invalid$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.fillMaxSize$default(obj.align((Modifier)Modifier.Companion, Alignment.Companion.getCenter()), 0, 1, 0), (Function1)anon, restartGroup, 0);
                int i64 = 6;
                int i68 = 0;
                int i56 = 2023513938;
                state2 = thumbColor;
                String thumbColor$delegate = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, i56, thumbColor$delegate);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume2;
                i12 = 6;
                int i75 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i56, thumbColor$delegate);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i57 = 0;
                float constructor-impl = Dp.constructor-impl(unbox-impl + f);
                companion2 = i33;
                String str6 = str5;
                if (Color.equals-impl0(SwitchKt.SwitchImpl$lambda$17(state2), elevationOverlay) && (ElevationOverlay)this_$iv != null) {
                    if ((ElevationOverlay)this_$iv != null) {
                        restartGroup.startReplaceGroup(1478408187);
                        ComposerKt.sourceInformation(restartGroup, "254@10489L36");
                        Object obj6 = this_$iv;
                        str = str3;
                        i13 = 0;
                        i21 = 1;
                        elevationOverlay = obj6;
                        i8 = constructor-impl;
                        restartGroup.endReplaceGroup();
                        l = apply-7g2Lkgo;
                    } else {
                        elevationOverlay = this_$iv;
                        str = str6;
                        i8 = constructor-impl;
                        i13 = 0;
                        i21 = 1;
                        restartGroup.startReplaceGroup(1478489190);
                        restartGroup.endReplaceGroup();
                        l = apply-7g2Lkgo;
                    }
                } else {
                }
                Composer composer5 = restartGroup;
                state = trackColor;
                restartGroup = composer5;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 463339429, str);
                i6 = i5 & i30 == 16384 ? i21 : 0;
                Composer composer = restartGroup;
                int i32 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i60 = 0;
                if (i6 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon3 = new SwitchKt.SwitchImpl.3.1(obj3);
                        composer.updateRememberedValue((Function1)anon3);
                    } else {
                        anon3 = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                thumbRippleRadius = SwitchKt.ThumbRippleRadius;
                SpacerKt.Spacer(BackgroundKt.background-bw27NRU(ShadowKt.shadow-s4CzXII$default(SizeKt.requiredSize-3ABfNKs(IndicationKt.indication(OffsetKt.offset(obj.align((Modifier)Modifier.Companion, Alignment.Companion.getCenterStart()), (Function1)anon3), obj4, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, thumbRippleRadius, 0, empty, restartGroup, 54)), SwitchKt.ThumbDiameter), f, (Shape)RoundedCornerShapeKt.getCircleShape(), false, 0, obj26, 0, obj28), SwitchKt.SwitchImpl$lambda$18(SingleValueAnimationKt.animateColorAsState-euL9pac(l, apply-7g2Lkgo, 0, 0, 0, composer5, 0)), thumbRippleRadius), restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i5 = animateColorAsState-euL9pac;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new SwitchKt.SwitchImpl.4(obj, checked, enabled, obj2, obj3, obj4, $changed);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final long SwitchImpl$lambda$15(State<Color> $trackColor$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Color)$trackColor$delegate.getValue().unbox-impl();
    }

    private static final long SwitchImpl$lambda$17(State<Color> $thumbColor$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Color)$thumbColor$delegate.getValue().unbox-impl();
    }

    private static final long SwitchImpl$lambda$18(State<Color> $resolvedThumbColor$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Color)$resolvedThumbColor$delegate.getValue().unbox-impl();
    }

    public static final boolean access$Switch$lambda$3(MutableState $forceAnimationCheck$delegate) {
        return SwitchKt.Switch$lambda$3($forceAnimationCheck$delegate);
    }

    public static final void access$Switch$lambda$4(MutableState $forceAnimationCheck$delegate, boolean value) {
        SwitchKt.Switch$lambda$4($forceAnimationCheck$delegate, value);
    }

    public static final Function1 access$Switch$lambda$7(State $currentOnCheckedChange$delegate) {
        return SwitchKt.Switch$lambda$7($currentOnCheckedChange$delegate);
    }

    public static final boolean access$Switch$lambda$8(State $currentChecked$delegate) {
        return SwitchKt.Switch$lambda$8($currentChecked$delegate);
    }

    public static final void access$SwitchImpl(BoxScope $receiver, boolean checked, boolean enabled, androidx.compose.material.SwitchColors colors, Function0 thumbValue, InteractionSource interactionSource, Composer $composer, int $changed) {
        SwitchKt.SwitchImpl($receiver, checked, enabled, colors, thumbValue, interactionSource, $composer, $changed);
    }

    public static final long access$SwitchImpl$lambda$15(State $trackColor$delegate) {
        return SwitchKt.SwitchImpl$lambda$15($trackColor$delegate);
    }

    public static final void access$drawTrack-RPmYEkk(DrawScope $receiver, long trackColor, float trackWidth, float strokeWidth) {
        SwitchKt.drawTrack-RPmYEkk($receiver, trackColor, trackWidth, strokeWidth);
    }

    private static final void drawTrack-RPmYEkk(DrawScope $this$drawTrack_u2dRPmYEkk, long trackColor, float trackWidth, float strokeWidth) {
        int i2 = obj21 / f;
        DrawScope.drawLine-NGM6Ib0$default($this$drawTrack_u2dRPmYEkk, trackColor, obj4, OffsetKt.Offset(i2, Offset.getY-impl($this$drawTrack_u2dRPmYEkk.getCenter-F1C5BW0())), obj6, OffsetKt.Offset(strokeWidth - i2, Offset.getY-impl($this$drawTrack_u2dRPmYEkk.getCenter-F1C5BW0())), obj8, obj21, StrokeCap.Companion.getRound-KaPHkGw(), 0, 0, 0);
    }

    public static final float getThumbDiameter() {
        return SwitchKt.ThumbDiameter;
    }

    public static final float getTrackStrokeWidth() {
        return SwitchKt.TrackStrokeWidth;
    }

    public static final float getTrackWidth() {
        return SwitchKt.TrackWidth;
    }
}
