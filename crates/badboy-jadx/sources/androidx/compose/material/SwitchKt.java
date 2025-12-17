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
        int i17;
        int i15;
        Modifier companion2;
        Object it$iv2;
        int anon;
        Modifier minimumInteractiveComponentSize;
        Integer currentCompositionLocalMap;
        Object invalid$iv2;
        boolean traceInProgress;
        Object $i$a$CacheSwitchKt$Switch$1;
        Object obj2;
        Function0 factory$iv$iv$iv;
        Object $composer2;
        int $composer3;
        Object $i$a$CacheSwitchKt$Switch$forceAnimationCheck$2;
        Object anchoredDraggableState;
        int empty;
        Object $composer5;
        int $dirty2;
        boolean traceInProgress2;
        int invalid$iv;
        Composer currentOnCheckedChange$delegate;
        int i20;
        Object it$iv;
        boolean enabled3;
        boolean $dirty;
        int i16;
        int i4;
        Object modifier2;
        Object box-impl;
        Composer composer;
        int valueOf2;
        Object obj5;
        Object $i$a$CacheSwitchKt$Switch$interactionSource$1;
        int $i$a$CacheSwitchKt$Switch$2;
        Object switchColors;
        Object mutableStateOf$default;
        float px-0680j_4;
        int colors2;
        int defaultsInvalid;
        Object obj3;
        Composer $composer4;
        int i10;
        int i18;
        int i;
        boolean z2;
        int i6;
        boolean z;
        int enabled4;
        boolean contentAlignment$iv;
        Object i7;
        int i23;
        Object propagateMinConstraints$iv;
        int changed;
        int measurePolicy$iv;
        androidx.compose.material.AnchoredDraggableState isRtl;
        int enabled2;
        int i21;
        int i13;
        int maxBound;
        int invalid$iv4;
        int i19;
        int companion;
        int anchoredDraggableState2;
        Object obj4;
        State state;
        int i12;
        Object obj6;
        int i11;
        int i2;
        Composer composer2;
        int i14;
        int i22;
        int $this$Switch_u24lambda_u2412;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        boolean z3;
        Object obj;
        androidx.compose.material.AnchoredDraggableState anchoredDraggableState3;
        Boolean valueOf;
        androidx.compose.material.DraggableAnchors draggableAnchors;
        androidx.compose.material.SwitchKt.Switch.anchoredDraggableState.1.2 anon2;
        androidx.compose.material.SwitchKt.Switch.anchoredDraggableState.1.3 companion3;
        TweenSpec invalid$iv3;
        int i3;
        int i8;
        int i5;
        androidx.compose.ui.Modifier.Companion obj45;
        int obj46;
        int obj47;
        int obj48;
        int obj49;
        traceInProgress = checked;
        $composer2 = onCheckedChange;
        px-0680j_4 = $changed;
        anon = 25866825;
        Composer restartGroup = $composer.startRestartGroup(anon);
        ComposerKt.sourceInformation(restartGroup, "C(Switch)P(!1,5,4,2,3)98@4560L8,*103@4753L7,108@5135L34,109@5224L7,110@5301L447,122@5783L37,123@5847L29,124@5920L315,124@5881L354,133@6285L133,133@6240L178,138@6456L7,153@6897L1050:Switch.kt#jmzs0o");
        $dirty2 = $changed;
        if (i9 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (px-0680j_4 & 6 == 0) {
                i16 = restartGroup.changed(traceInProgress) ? 4 : 2;
                $dirty2 |= i16;
            }
        }
        if (i9 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (px-0680j_4 & 48 == 0) {
                i4 = restartGroup.changedInstance($composer2) ? 32 : 16;
                $dirty2 |= i4;
            }
        }
        int i51 = i9 & 4;
        if (i51 != 0) {
            $dirty2 |= 384;
            obj3 = modifier;
        } else {
            if (px-0680j_4 & 384 == 0) {
                i10 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i10;
            } else {
                obj3 = modifier;
            }
        }
        int i76 = i9 & 8;
        if (i76 != 0) {
            $dirty2 |= 3072;
            z2 = enabled;
        } else {
            if (px-0680j_4 & 3072 == 0) {
                i6 = restartGroup.changed(enabled) ? 2048 : 1024;
                $dirty2 |= i6;
            } else {
                z2 = enabled;
            }
        }
        contentAlignment$iv = i9 & 16;
        if (contentAlignment$iv != 0) {
            $dirty2 |= 24576;
            i7 = interactionSource;
        } else {
            if (px-0680j_4 & 24576 == 0) {
                i23 = restartGroup.changed(interactionSource) ? 16384 : 8192;
                $dirty2 |= i23;
            } else {
                i7 = interactionSource;
            }
        }
        if (i84 &= px-0680j_4 == 0) {
            if (i9 & 32 == 0) {
                changed = restartGroup.changed(colors) ? 131072 : 65536;
            } else {
                propagateMinConstraints$iv = colors;
            }
            $dirty2 |= changed;
        } else {
            propagateMinConstraints$iv = colors;
        }
        i90 &= $dirty2;
        if (measurePolicy$iv == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i106 = -458753;
                if (px-0680j_4 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i51 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj3;
                        }
                        z3 = i76 != 0 ? defaultsInvalid : z2;
                        obj = contentAlignment$iv != 0 ? defaultsInvalid : i7;
                        if (i9 & 32 != 0) {
                            composer2 = restartGroup;
                            $composer3 = 2;
                            $composer4 = composer2;
                            i18 = $dirty2;
                            i7 = colors-SQMK_m0;
                            z = z3;
                            colors2 = modifier2;
                        } else {
                            $composer4 = restartGroup;
                            $composer3 = 2;
                            i7 = colors;
                            i18 = $dirty2;
                            colors2 = modifier2;
                            z = z3;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i9 & 32 != 0) {
                            $dirty2 &= i106;
                        }
                        i18 = $dirty2;
                        colors2 = obj3;
                        z = z2;
                        obj = i7;
                        i7 = propagateMinConstraints$iv;
                        $composer4 = restartGroup;
                        $composer3 = 2;
                    }
                } else {
                }
                $composer4.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(anon, i18, -1, "androidx.compose.material.Switch (Switch.kt:99)");
                }
                String str3 = "CC(remember):Switch.kt#9igjgp";
                if (obj == null) {
                    $composer4.startReplaceGroup(-1604953567);
                    ComposerKt.sourceInformation($composer4, "101@4654L39");
                    ComposerKt.sourceInformationMarkerStart($composer4, 779511297, str3);
                    i17 = 0;
                    traceInProgress2 = $composer4;
                    modifier2 = 0;
                    propagateMinConstraints$iv = traceInProgress2.rememberedValue();
                    measurePolicy$iv = 0;
                    if (propagateMinConstraints$iv == Composer.Companion.getEmpty()) {
                        int i62 = 0;
                        traceInProgress2.updateRememberedValue(InteractionSourceKt.MutableInteractionSource());
                    } else {
                        $i$a$CacheSwitchKt$Switch$interactionSource$1 = propagateMinConstraints$iv;
                    }
                    ComposerKt.sourceInformationMarkerEnd($composer4);
                    $composer4.endReplaceGroup();
                } else {
                    $composer4.startReplaceGroup(779510646);
                    $composer4.endReplaceGroup();
                    $i$a$CacheSwitchKt$Switch$interactionSource$1 = obj;
                }
                Object obj10 = $i$a$CacheSwitchKt$Switch$interactionSource$1;
                int i86 = 0;
                int i41 = 0;
                int i52 = 0;
                String str5 = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, str5);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                int i42 = 0;
                float $this$Switch_u24lambda_u241 = (Density)$composer4.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(SwitchKt.ThumbPathLength);
                ComposerKt.sourceInformationMarkerStart($composer4, 779526684, str3);
                int i43 = 0;
                Composer composer4 = $composer4;
                int i92 = 0;
                Object rememberedValue4 = composer4.rememberedValue();
                int i95 = 0;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    obj48 = i40;
                    invalid$iv4 = i43;
                    $i$a$CacheSwitchKt$Switch$forceAnimationCheck$2 = 0;
                    composer4.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(false, $i$a$CacheSwitchKt$Switch$forceAnimationCheck$2, 2, $i$a$CacheSwitchKt$Switch$forceAnimationCheck$2));
                } else {
                    invalid$iv4 = i43;
                    obj47 = 0;
                    invalid$iv = 2;
                    mutableStateOf$default = rememberedValue4;
                }
                obj6 = mutableStateOf$default;
                ComposerKt.sourceInformationMarkerEnd($composer4);
                int i53 = 0;
                int i64 = 0;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, str5);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                int i54 = 0;
                px-0680j_4 = (Density)$composer4.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity()).toPx-0680j_4(SwitchKt.SwitchVelocityThreshold);
                ComposerKt.sourceInformationMarkerStart($composer4, 779532409, str3);
                changed2 |= changed3;
                Composer composer5 = $composer4;
                int i65 = 0;
                Object rememberedValue3 = composer5.rememberedValue();
                int i96 = 0;
                if (empty == 0) {
                    obj48 = empty;
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        companion = invalid$iv5;
                        SwitchKt.Switch.anchoredDraggableState.1.1 $i$a$CacheSwitchKt$Switch$anchoredDraggableState$1 = new SwitchKt.Switch.anchoredDraggableState.1.1(i86, $this$Switch_u24lambda_u241);
                        SwitchKt.Switch.anchoredDraggableState.1.3 anon3 = new SwitchKt.Switch.anchoredDraggableState.1.3(px-0680j_4);
                        anchoredDraggableState3 = new AnchoredDraggableState(Boolean.valueOf(traceInProgress), AnchoredDraggableKt.DraggableAnchors((Function1)$i$a$CacheSwitchKt$Switch$anchoredDraggableState$1), (Function1)SwitchKt.Switch.anchoredDraggableState.1.2.INSTANCE, (Function0)anon3, (AnimationSpec)SwitchKt.AnimationSpec, 0, 32, 0);
                        composer5.updateRememberedValue(anchoredDraggableState3);
                    } else {
                        anchoredDraggableState = rememberedValue3;
                    }
                } else {
                    obj48 = empty;
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState($composer2, $composer4, i44 &= 14);
                State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(Boolean.valueOf(traceInProgress), $composer4, i18 & 14);
                ComposerKt.sourceInformationMarkerStart($composer4, 779552085, str3);
                obj48 = $composer4;
                int i97 = 0;
                float f2 = $this$Switch_u24lambda_u241;
                Object rememberedValue = obj48.rememberedValue();
                int i103 = 0;
                if (i68 |= changed11 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        int i39 = 0;
                        companion = new SwitchKt.Switch.1.1(anchoredDraggableState, rememberUpdatedState2, rememberUpdatedState, (MutableState)obj6, 0);
                        obj48.updateRememberedValue((Function2)companion);
                    } else {
                        $i$a$CacheSwitchKt$Switch$1 = rememberedValue;
                        i12 = rememberUpdatedState;
                        state = rememberUpdatedState2;
                        currentOnCheckedChange$delegate = obj48;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.LaunchedEffect(anchoredDraggableState, (Function2)$i$a$CacheSwitchKt$Switch$1, $composer4, obj47);
                ComposerKt.sourceInformationMarkerStart($composer4, 779563583, str3);
                i21 = 1;
                i20 = i18 & 14 == 4 ? i21 : 0;
                Composer composer6 = $composer4;
                $i$a$CacheSwitchKt$Switch$2 = 0;
                it$iv = composer6.rememberedValue();
                int i101 = 0;
                if (i20 |= changed4 == 0) {
                    obj49 = $i$a$CacheSwitchKt$Switch$2;
                    if (it$iv == Composer.Companion.getEmpty()) {
                        obj4 = it$iv;
                        i11 = $i$f$cache;
                        it$iv = new SwitchKt.Switch.2.1(traceInProgress, anchoredDraggableState, 0);
                        composer6.updateRememberedValue((Function2)it$iv);
                    } else {
                        obj4 = it$iv;
                    }
                } else {
                    obj49 = $i$a$CacheSwitchKt$Switch$2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer4);
                EffectsKt.LaunchedEffect(Boolean.valueOf(traceInProgress), Boolean.valueOf(SwitchKt.Switch$lambda$3(obj6)), (Function2)it$iv, $composer4, i18 & 14);
                int i36 = 0;
                int i49 = 0;
                ComposerKt.sourceInformationMarkerStart($composer4, 2023513938, str5);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                i15 = $composer4.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? i21 : 0;
                int i91 = i15;
                if (onCheckedChange != null) {
                    maxBound = i91;
                    isRtl = anchoredDraggableState5;
                    anchoredDraggableState2 = f;
                    enabled4 = 2;
                    companion2 = ToggleableKt.toggleable-O2vRcR0((Modifier)Modifier.Companion, traceInProgress, obj10, 0, z, Role.box-impl(Role.Companion.getSwitch-o7Vup1c()), onCheckedChange);
                } else {
                    enabled3 = z;
                    anchoredDraggableState2 = f2;
                    obj2 = obj10;
                    enabled4 = 2;
                    maxBound = i91;
                    isRtl = anchoredDraggableState;
                    companion2 = Modifier.Companion;
                }
                if (onCheckedChange != null) {
                    minimumInteractiveComponentSize = InteractiveComponentSizeKt.minimumInteractiveComponentSize((Modifier)Modifier.Companion);
                } else {
                    minimumInteractiveComponentSize = Modifier.Companion;
                }
                if (enabled3 && onCheckedChange != null) {
                    if (onCheckedChange != null) {
                    } else {
                        i21 = 0;
                    }
                } else {
                }
                i19 = obj2;
                androidx.compose.material.AnchoredDraggableState anchoredDraggableState4 = isRtl;
                int i87 = 0;
                Modifier requiredSize-VpY3zN4 = SizeKt.requiredSize-VpY3zN4(PaddingKt.padding-3ABfNKs(SizeKt.wrapContentSize$default(AnchoredDraggableKt.anchoredDraggable(colors2.then(minimumInteractiveComponentSize).then(companion2), isRtl, Orientation.Horizontal, i21, maxBound, i19, false), Alignment.Companion.getCenter(), i87, enabled4, 0), SwitchKt.DefaultSwitchPadding), SwitchKt.SwitchWidth, SwitchKt.SwitchHeight);
                valueOf2 = i87;
                int i71 = 0;
                ComposerKt.sourceInformationMarkerStart($composer4, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart = Alignment.Companion.getTopStart();
                int i88 = 0;
                androidx.compose.ui.layout.MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i88);
                i11 = 0;
                obj45 = companion2;
                obj46 = i32;
                ComposerKt.sourceInformationMarkerStart($composer4, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = $composer4.getCurrentCompositionLocalMap();
                obj47 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier($composer4, requiredSize-VpY3zN4);
                obj48 = requiredSize-VpY3zN4;
                obj49 = constructor;
                i2 = 0;
                ComposerKt.sourceInformationMarkerStart($composer4, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                $composer4.startReusableNode();
                if ($composer4.getInserting()) {
                    $composer4.createNode(obj49);
                } else {
                    factory$iv$iv$iv = obj49;
                    $composer4.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl($composer4);
                int i98 = 0;
                i22 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i104 = 0;
                obj49 = constructor-impl;
                int i105 = 0;
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
                Composer composer3 = $composer4;
                int i50 = 0;
                obj49 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                Composer composer8 = composer3;
                i14 = 0;
                anchoredDraggableState3 = i34;
                ComposerKt.sourceInformationMarkerStart(composer3, -277232920, "C179@7838L42,175@7683L258:Switch.kt#jmzs0o");
                ComposerKt.sourceInformationMarkerStart(composer3, 545251075, str3);
                invalid$iv2 = composer3.changed(anchoredDraggableState4);
                Composer composer7 = composer3;
                int i99 = 0;
                it$iv2 = composer7.rememberedValue();
                anon2 = 0;
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
                enabled2 = composer3;
                $composer2 = i88;
                SwitchKt.SwitchImpl((BoxScope)BoxScopeInstance.INSTANCE, (Boolean)anchoredDraggableState4.getTargetValue().booleanValue(), contentAlignment$iv, i7, (Function0)it$iv2, (InteractionSource)i19, enabled2, i30 |= i80);
                ComposerKt.sourceInformationMarkerEnd(enabled2);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                $composer4.endNode();
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                ComposerKt.sourceInformationMarkerEnd($composer4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                i = anon;
                $composer5 = colors2;
                $dirty = contentAlignment$iv;
                switchColors = i7;
                obj5 = obj;
            } else {
                restartGroup.skipToGroupEnd();
                $composer4 = restartGroup;
                $composer5 = obj7;
                i = $dirty2;
                $dirty = z2;
                obj5 = i7;
                switchColors = propagateMinConstraints$iv;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = $composer4.endRestartGroup();
        if (endRestartGroup != null) {
            anon = new SwitchKt.Switch.4(checked, onCheckedChange, $composer5, $dirty, obj5, switchColors, $changed, i9);
            endRestartGroup.updateScope((Function2)anon);
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
        Object $i$a$CacheSwitchKt$SwitchImpl$2;
        int i7;
        Object invalid$iv2;
        int traceInProgress;
        String str;
        boolean circleShape;
        Object elevationOverlay;
        Object anon;
        float i5;
        int $dirty;
        int skipping;
        boolean traceInProgress2;
        long l;
        int i14;
        int i16;
        int i;
        int i21;
        int i20;
        int i15;
        int thumbRippleRadius;
        int invalid$iv;
        float thumbDefaultElevation;
        long apply-7g2Lkgo;
        int i11;
        int empty;
        Composer restartGroup;
        int i4;
        Object anon2;
        int i2;
        Object $i$a$CacheSwitchKt$SwitchImpl$interactions$1;
        int i6;
        int i12;
        int animateColorAsState-euL9pac;
        State state2;
        State state;
        int i19;
        int i8;
        Composer.Companion companion2;
        int companion;
        int i9;
        Modifier requiredSize-3ABfNKs;
        float f;
        androidx.compose.foundation.shape.RoundedCornerShape roundedCornerShape;
        int i17;
        int i10;
        int i3;
        int i18;
        int i13;
        androidx.compose.runtime.snapshots.SnapshotStateList interactions;
        final Object obj = $this$SwitchImpl;
        circleShape = checked;
        elevationOverlay = enabled;
        final Object obj2 = colors;
        final Object obj3 = thumbValue;
        final Object obj4 = interactionSource;
        i5 = $changed;
        traceInProgress = 70908914;
        restartGroup = $composer.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(SwitchImpl)P(!1,2!1,4)221@9029L46,223@9115L614,223@9081L648,242@9932L28,246@10055L81,243@9965L171,249@10166L28,250@10244L7,*251@10303L7,253@10414L6,252@10353L228,262@10673L43,265@10826L133,259@10586L549:Switch.kt#jmzs0o");
        if (i5 & 6 == 0) {
            i14 = restartGroup.changed(obj) ? 4 : 2;
            $dirty |= i14;
        }
        if (i5 & 48 == 0) {
            i16 = restartGroup.changed(circleShape) ? 32 : 16;
            $dirty |= i16;
        }
        if (i5 & 384 == 0) {
            i = restartGroup.changed(elevationOverlay) ? 256 : 128;
            $dirty |= i;
        }
        if (i5 & 3072 == 0) {
            i21 = restartGroup.changed(obj2) ? 2048 : 1024;
            $dirty |= i21;
        }
        if (i5 & 24576 == 0) {
            i20 = restartGroup.changedInstance(obj3) ? 16384 : 8192;
            $dirty |= i20;
        }
        i11 = 131072;
        if (i36 &= i5 == 0) {
            i15 = restartGroup.changed(obj4) ? i11 : 65536;
            $dirty |= i15;
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
                    $i$a$CacheSwitchKt$SwitchImpl$interactions$1 = rememberedValue3;
                }
                invalid$iv2 = $i$a$CacheSwitchKt$SwitchImpl$interactions$1;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 463290144, str5);
                invalid$iv = i38 &= animateColorAsState-euL9pac == i11 ? 1 : 0;
                Composer composer3 = restartGroup;
                int i66 = 0;
                Object rememberedValue2 = composer3.rememberedValue();
                int i71 = 0;
                if (invalid$iv == 0) {
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        $i$a$CacheSwitchKt$SwitchImpl$interactions$1 = 0;
                        i8 = invalid$iv;
                        anon = new SwitchKt.SwitchImpl.1.1(obj4, (SnapshotStateList)invalid$iv2, 0);
                        composer3.updateRememberedValue((Function2)anon);
                    } else {
                        i8 = invalid$iv;
                        anon = rememberedValue2;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.LaunchedEffect(obj4, (Function2)anon, restartGroup, i40 &= 14);
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
                        $i$a$CacheSwitchKt$SwitchImpl$2 = new SwitchKt.SwitchImpl.2.1(trackColor);
                        composer4.updateRememberedValue((Function1)$i$a$CacheSwitchKt$SwitchImpl$2);
                    } else {
                        $i$a$CacheSwitchKt$SwitchImpl$2 = rememberedValue4;
                    }
                } else {
                    interactions = invalid$iv2;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.fillMaxSize$default(obj.align((Modifier)Modifier.Companion, Alignment.Companion.getCenter()), 0, 1, 0), (Function1)$i$a$CacheSwitchKt$SwitchImpl$2, restartGroup, 0);
                int i64 = 6;
                int i68 = 0;
                int i56 = 2023513938;
                state = thumbColor;
                String thumbColor$delegate = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, i56, thumbColor$delegate);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                Object this_$iv = consume2;
                i4 = 6;
                int i75 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i56, thumbColor$delegate);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i57 = 0;
                float constructor-impl = Dp.constructor-impl(unbox-impl + f);
                companion2 = i33;
                String str6 = str5;
                if (Color.equals-impl0(SwitchKt.SwitchImpl$lambda$17(state), elevationOverlay) && (ElevationOverlay)this_$iv != null) {
                    if ((ElevationOverlay)this_$iv != null) {
                        restartGroup.startReplaceGroup(1478408187);
                        ComposerKt.sourceInformation(restartGroup, "254@10489L36");
                        Object obj6 = this_$iv;
                        str = str3;
                        i7 = 0;
                        i19 = 1;
                        elevationOverlay = obj6;
                        i5 = constructor-impl;
                        restartGroup.endReplaceGroup();
                        l = apply-7g2Lkgo;
                    } else {
                        elevationOverlay = this_$iv;
                        str = str6;
                        i5 = constructor-impl;
                        i7 = 0;
                        i19 = 1;
                        restartGroup.startReplaceGroup(1478489190);
                        restartGroup.endReplaceGroup();
                        l = apply-7g2Lkgo;
                    }
                } else {
                }
                Composer composer5 = restartGroup;
                state2 = trackColor;
                restartGroup = composer5;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 463339429, str);
                i6 = i9 & i30 == 16384 ? i19 : 0;
                Composer composer = restartGroup;
                int i32 = 0;
                Object rememberedValue = composer.rememberedValue();
                int i60 = 0;
                if (i6 == 0) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        empty = 0;
                        anon2 = new SwitchKt.SwitchImpl.3.1(obj3);
                        composer.updateRememberedValue((Function1)anon2);
                    } else {
                        anon2 = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                thumbRippleRadius = SwitchKt.ThumbRippleRadius;
                SpacerKt.Spacer(BackgroundKt.background-bw27NRU(ShadowKt.shadow-s4CzXII$default(SizeKt.requiredSize-3ABfNKs(IndicationKt.indication(OffsetKt.offset(obj.align((Modifier)Modifier.Companion, Alignment.Companion.getCenterStart()), (Function1)anon2), obj4, RippleKt.rippleOrFallbackImplementation-9IZ8Weo(false, thumbRippleRadius, 0, empty, restartGroup, 54)), SwitchKt.ThumbDiameter), f, (Shape)RoundedCornerShapeKt.getCircleShape(), false, 0, obj26, 0, obj28), SwitchKt.SwitchImpl$lambda$18(SingleValueAnimationKt.animateColorAsState-euL9pac(l, apply-7g2Lkgo, 0, 0, 0, composer5, 0)), thumbRippleRadius), restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i9 = animateColorAsState-euL9pac;
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
