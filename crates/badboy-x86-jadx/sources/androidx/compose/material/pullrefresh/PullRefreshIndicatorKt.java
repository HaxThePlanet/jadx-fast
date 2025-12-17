package androidx.compose.material.pullrefresh;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.Colors;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.ElevationOverlay;
import androidx.compose.material.ElevationOverlayKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.PathFillType.Companion;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002\u001a*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001e\u001aJ\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00182\u0008\u0008\u0002\u0010\u001b\u001a\u00020\u001c2\u0008\u0008\u0002\u0010\"\u001a\u00020\u001a2\u0008\u0008\u0002\u0010#\u001a\u00020\u001a2\u0008\u0008\u0002\u0010$\u001a\u00020!H\u0007ø\u0001\u0000¢\u0006\u0004\u0008%\u0010&\u001a>\u0010'\u001a\u00020\u0016*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\u0008/\u00100\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0008\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u000c\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u00061²\u0006\n\u00102\u001a\u00020!X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u00020\u0002X\u008a\u0084\u0002", d2 = {"AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "", "ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "Elevation", "IndicatorSize", "MaxAlpha", "MaxProgressArc", "MinAlpha", "SpinnerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "StrokeWidth", "ArrowValues", "Landroidx/compose/material/pullrefresh/ArrowValues;", "progress", "CircularArrowIndicator", "", "state", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "color", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "CircularArrowIndicator-iJQMabo", "(Landroidx/compose/material/pullrefresh/PullRefreshState;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "PullRefreshIndicator", "refreshing", "", "backgroundColor", "contentColor", "scale", "PullRefreshIndicator-jB83MbM", "(ZLandroidx/compose/material/pullrefresh/PullRefreshState;Landroidx/compose/ui/Modifier;JJZLandroidx/compose/runtime/Composer;II)V", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "drawArrow-Bx497Mc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material/pullrefresh/ArrowValues;)V", "material_release", "showElevation", "targetAlpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PullRefreshIndicatorKt {

    private static final TweenSpec<Float> AlphaTween = null;
    private static final float ArcRadius = 0f;
    private static final float ArrowHeight = 0f;
    private static final float ArrowWidth = 0f;
    private static final int CrossfadeDurationMs = 100;
    private static final float Elevation = 0f;
    private static final float IndicatorSize = 0f;
    private static final float MaxAlpha = 1f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final RoundedCornerShape SpinnerShape;
    private static final float StrokeWidth;
    static {
        int i5 = 0;
        PullRefreshIndicatorKt.IndicatorSize = Dp.constructor-impl((float)i);
        PullRefreshIndicatorKt.SpinnerShape = RoundedCornerShapeKt.getCircleShape();
        int i10 = 0;
        PullRefreshIndicatorKt.ArcRadius = Dp.constructor-impl((float)l);
        int i11 = 0;
        PullRefreshIndicatorKt.StrokeWidth = Dp.constructor-impl((float)l2);
        int i6 = 0;
        PullRefreshIndicatorKt.ArrowWidth = Dp.constructor-impl((float)i2);
        int i7 = 0;
        PullRefreshIndicatorKt.ArrowHeight = Dp.constructor-impl((float)i3);
        int i8 = 0;
        PullRefreshIndicatorKt.Elevation = Dp.constructor-impl((float)i4);
        PullRefreshIndicatorKt.AlphaTween = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, 0);
    }

    private static final androidx.compose.material.pullrefresh.ArrowValues ArrowValues(float progress) {
        int $this$fastCoerceAtLeast$iv$iv;
        int i = 1065353216;
        int i5 = 1053609165;
        i3 /= f5;
        int i14 = 0;
        int i17 = 1073741824;
        int i28 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i14) < 0) {
            $this$fastCoerceAtLeast$iv$iv = i14;
        }
        int i29 = 0;
        if (Float.compare($this$fastCoerceAtLeast$iv$iv, i17) > 0) {
            $this$fastCoerceAtLeast$iv$iv = i17;
        }
        i8 *= i24;
        float f9 = (float)i25;
        ArrowValues arrowValues = new ArrowValues(i9, i9 * f9, i30 *= f9, Math.min(i, i4));
        return arrowValues;
    }

    private static final void CircularArrowIndicator-iJQMabo(androidx.compose.material.pullrefresh.PullRefreshState state, long color, Modifier modifier, Composer $composer, int $changed) {
        int traceInProgress;
        int invalid$iv2;
        Object alphaState;
        Object obj2;
        int $dirty2;
        int i4;
        int i;
        int i9;
        boolean $dirty;
        boolean traceInProgress2;
        boolean changedInstance;
        int $this$cache$iv;
        long semantics$default;
        int i8;
        int i6;
        int i3;
        Composer composer;
        int i2;
        Object rememberedValue;
        Object empty;
        Object derivedStateOf;
        int i7;
        Object anon;
        Object obj;
        int invalid$iv;
        int i5;
        Path obj23;
        obj2 = state;
        final Object obj3 = $composer;
        final int i16 = obj24;
        traceInProgress = -486016981;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(CircularArrowIndicator)P(2,0:c#ui.graphics.Color)135@5348L61,137@5434L119,143@5576L74,146@5719L970,146@5689L1000:PullRefreshIndicator.kt#t44y28");
        if (i16 & 6 == 0) {
            i4 = restartGroup.changedInstance(obj2) ? 4 : 2;
            $dirty2 |= i4;
        }
        if (i16 & 48 == 0) {
            i = restartGroup.changed(color) ? 32 : 16;
            $dirty2 |= i;
        } else {
            semantics$default = color;
        }
        if (i16 & 384 == 0) {
            i9 = restartGroup.changed(obj3) ? 256 : 128;
            $dirty2 |= i9;
        }
        if ($dirty2 & 147 == 146) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty2, -1, "androidx.compose.material.pullrefresh.CircularArrowIndicator (PullRefreshIndicator.kt:134)");
                }
                String str2 = "CC(remember):PullRefreshIndicator.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, -659480864, str2);
                invalid$iv2 = 0;
                Composer composer3 = restartGroup;
                int i18 = 0;
                Object rememberedValue2 = composer3.rememberedValue();
                int i23 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    anon = AndroidPath_androidKt.Path();
                    obj = 0;
                    invalid$iv = invalid$iv2;
                    anon.setFillType-oQ8Xj4U(PathFillType.Companion.getEvenOdd-Rg-k1Os());
                    composer3.updateRememberedValue(anon);
                } else {
                    invalid$iv = invalid$iv2;
                    anon = rememberedValue2;
                }
                $this$cache$iv = anon;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, -659478054, str2);
                Composer composer2 = restartGroup;
                int i19 = 0;
                Object rememberedValue3 = composer2.rememberedValue();
                int i24 = 0;
                if (!restartGroup.changed(obj2)) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        int i27 = 0;
                        anon = new PullRefreshIndicatorKt.CircularArrowIndicator.targetAlpha.2.1(obj2);
                        composer2.updateRememberedValue(SnapshotStateKt.derivedStateOf((Function0)anon));
                    } else {
                        derivedStateOf = rememberedValue3;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(PullRefreshIndicatorKt.CircularArrowIndicator_iJQMabo$lambda$6((State)derivedStateOf), (AnimationSpec)PullRefreshIndicatorKt.AlphaTween, 0, 0, 0, restartGroup, 48, 28);
                i8 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -659468083, str2);
                if ($dirty2 & 112 == 32) {
                } else {
                    i3 = i8;
                }
                changedInstance = restartGroup.changedInstance((Path)$this$cache$iv);
                composer = restartGroup;
                i2 = 0;
                rememberedValue = composer.rememberedValue();
                i7 = 0;
                if ($dirty | changedInstance == null) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        invalid$iv = 0;
                        i5 = i13;
                        alphaState = new PullRefreshIndicatorKt.CircularArrowIndicator.2.1(obj2, animateFloatAsState, color, changedInstance, $this$cache$iv);
                        composer.updateRememberedValue((Function1)alphaState);
                    } else {
                        i5 = $dirty2;
                        $dirty2 = animateFloatAsState;
                        alphaState = rememberedValue;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SemanticsModifierKt.semantics$default(obj3, i8, (Function1)PullRefreshIndicatorKt.CircularArrowIndicator.1.INSTANCE, 1, 0), (Function1)alphaState, restartGroup, i8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                i5 = $dirty2;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new PullRefreshIndicatorKt.CircularArrowIndicator.3(state, color, $dirty, obj3, i16);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final float CircularArrowIndicator_iJQMabo$lambda$6(State<Float> $targetAlpha$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$targetAlpha$delegate.getValue().floatValue();
    }

    public static final void PullRefreshIndicator-jB83MbM(boolean refreshing, androidx.compose.material.pullrefresh.PullRefreshState state, Modifier modifier, long backgroundColor, long contentColor, boolean scale, Composer $composer, int $changed, int i9) {
        int i7;
        Integer currentCompositionLocalMap;
        boolean traceInProgress;
        int z2;
        int $composer2;
        int elevation;
        kotlin.jvm.functions.Function0 factory$iv$iv$iv;
        Object $composer3;
        int $dirty2;
        Composer composer;
        Object maybeCachedBoxMeasurePolicy;
        long $dirty;
        int i11;
        int i16;
        Object modifier2;
        int i22;
        int skipping;
        long backgroundColor2;
        long unbox-impl;
        int defaultsInvalid;
        long color;
        Object obj2;
        int i15;
        int i25;
        int i10;
        int changed;
        int i6;
        boolean traceInProgress2;
        Object derivedStateOf;
        float localElevationOverlay;
        boolean z;
        boolean changed2;
        long contentColor2;
        long str;
        int i5;
        boolean z3;
        int i13;
        Object empty;
        Composer composer2;
        Object obj3;
        int i;
        int i8;
        int i3;
        Composer.Companion companion;
        int i26;
        int i2;
        float f;
        int i17;
        int i12;
        int i14;
        int i18;
        int i4;
        Object obj;
        int i23;
        kotlin.jvm.functions.Function0 function0;
        BoxScopeInstance boxScopeInstance;
        Modifier modifier3;
        androidx.compose.runtime.CompositionLocalMap localMap$iv$iv;
        androidx.compose.ui.layout.MeasurePolicy measurePolicy;
        Boolean valueOf;
        int i21;
        TweenSpec tweenSpec;
        int i19;
        androidx.compose.runtime.internal.ComposableLambda composableLambda;
        Composer composer3;
        int i24;
        int i20;
        Composer composer4;
        Object obj44;
        long obj45;
        Alignment obj46;
        float obj47;
        Composer obj48;
        int obj49;
        z2 = refreshing;
        final Object obj4 = state;
        final int i52 = obj51;
        traceInProgress = 308716636;
        Composer restartGroup = i9.startRestartGroup(traceInProgress);
        ComposerKt.sourceInformation(restartGroup, "C(PullRefreshIndicator)P(3,5,2,0:c#ui.graphics.Color,1:c#ui.graphics.Color)79@3427L6,80@3469L32,83@3559L98,90@3942L7,94@4070L1067:PullRefreshIndicator.kt#t44y28");
        $dirty2 = obj51;
        if (obj52 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i52 & 6 == 0) {
                i11 = restartGroup.changed(z2) ? 4 : 2;
                $dirty2 |= i11;
            }
        }
        if (obj52 & 2 != 0) {
            $dirty2 |= 48;
        } else {
            if (i52 & 48 == 0) {
                i16 = restartGroup.changedInstance(obj4) ? 32 : 16;
                $dirty2 |= i16;
            }
        }
        i22 = obj52 & 4;
        if (i22 != 0) {
            $dirty2 |= 384;
            obj2 = modifier;
        } else {
            if (i52 & 384 == 0) {
                i15 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i15;
            } else {
                obj2 = modifier;
            }
        }
        if (i52 & 3072 == 0) {
            if (obj52 & 8 == 0) {
                i25 = restartGroup.changed(backgroundColor) ? 2048 : 1024;
            } else {
                contentColor2 = backgroundColor;
            }
            $dirty2 |= i25;
        } else {
            contentColor2 = backgroundColor;
        }
        if (i52 & 24576 == 0) {
            if (obj52 & 16 == 0) {
                i10 = restartGroup.changed(scale) ? 16384 : 8192;
            } else {
                str = scale;
            }
            $dirty2 |= i10;
        } else {
            str = scale;
        }
        i6 = obj52 & 32;
        int i62 = 196608;
        if (i6 != 0) {
            $dirty2 |= i62;
            z3 = $changed;
        } else {
            if (i62 &= i52 == 0) {
                i13 = restartGroup.changed($changed) ? 131072 : 65536;
                $dirty2 |= i13;
            } else {
                z3 = $changed;
            }
        }
        if (i64 &= $dirty2 == 74898) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                int i67 = -57345;
                empty = 6;
                if (i52 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i22 != 0) {
                            modifier2 = Modifier.Companion;
                        } else {
                            modifier2 = obj2;
                        }
                        if (obj52 & 8 != 0) {
                            backgroundColor2 = MaterialTheme.INSTANCE.getColors(restartGroup, empty).getSurface-0d7_KjU();
                            $dirty2 &= -7169;
                        } else {
                            backgroundColor2 = contentColor2;
                        }
                        if (obj52 & 16 != 0) {
                            contentColor2 = ColorsKt.contentColorFor-ek8zF_U(backgroundColor2, obj2, restartGroup);
                            $dirty2 &= i67;
                        } else {
                            contentColor2 = str;
                        }
                        if (i6 != 0) {
                            z3 = i6;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (obj52 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        if (obj52 & 16 != 0) {
                            $dirty2 &= i67;
                        }
                        modifier2 = obj2;
                        backgroundColor2 = contentColor2;
                        contentColor2 = str;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress, $dirty2, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator (PullRefreshIndicator.kt:82)");
                }
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1619083065, "CC(remember):PullRefreshIndicator.kt#9igjgp");
                i7 = $dirty2 & 14 == 4 ? 1 : 0;
                Composer composer6 = restartGroup;
                int i68 = 0;
                Object rememberedValue2 = composer6.rememberedValue();
                i = 0;
                if (i7 |= changed5 == 0) {
                    i26 = empty;
                    if (rememberedValue2 == Composer.Companion.getEmpty()) {
                        empty = 0;
                        i3 = 0;
                        PullRefreshIndicatorKt.PullRefreshIndicator.showElevation.2.1 anon2 = new PullRefreshIndicatorKt.PullRefreshIndicator.showElevation.2.1(z2, obj4);
                        composer6.updateRememberedValue(SnapshotStateKt.derivedStateOf((Function0)anon2));
                    } else {
                        derivedStateOf = rememberedValue2;
                        i3 = 0;
                    }
                } else {
                    i26 = empty;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i56 = 6;
                i5 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = restartGroup.consume((CompositionLocal)ElevationOverlayKt.getLocalElevationOverlay());
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if ((ElevationOverlay)consume == null) {
                    restartGroup.startReplaceGroup(-1347612331);
                    restartGroup.endReplaceGroup();
                    composer2 = restartGroup;
                    str = backgroundColor2;
                    $composer2 = 0;
                } else {
                    restartGroup.startReplaceGroup(1619096620);
                    ComposerKt.sourceInformation(restartGroup, "91@3984L53");
                    obj48 = restartGroup;
                    obj45 = backgroundColor2;
                    str = obj45;
                    obj48.endReplaceGroup();
                    $composer2 = Color.box-impl((ElevationOverlay)consume.apply-7g2Lkgo(obj45, contentColor, PullRefreshIndicatorKt.Elevation, obj48));
                }
                if ($composer2 != 0) {
                    unbox-impl = $composer2.unbox-impl();
                } else {
                    unbox-impl = str;
                }
                if (PullRefreshIndicatorKt.PullRefreshIndicator_jB83MbM$lambda$1((State)derivedStateOf)) {
                    f = elevation;
                } else {
                    i = 0;
                    f = localElevationOverlay;
                }
                Modifier background-bw27NRU = BackgroundKt.background-bw27NRU(ShadowKt.shadow-s4CzXII$default(PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform(SizeKt.size-3ABfNKs(modifier2, PullRefreshIndicatorKt.IndicatorSize), obj4, z3), f, (Shape)PullRefreshIndicatorKt.SpinnerShape, true, 0, obj25, 0, obj27), unbox-impl, obj2);
                int i51 = i3;
                i8 = 0;
                obj45 = consume;
                ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                Alignment topStart = Alignment.Companion.getTopStart();
                int i36 = 0;
                maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, i36);
                i12 = 0;
                obj46 = topStart;
                obj47 = i36;
                ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                obj48 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, background-bw27NRU);
                obj49 = background-bw27NRU;
                kotlin.jvm.functions.Function0 function02 = constructor;
                i14 = 0;
                ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(function02);
                } else {
                    factory$iv$iv$iv = function02;
                    composer2.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(composer2);
                int i72 = 0;
                function0 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i74 = 0;
                Composer composer7 = constructor-impl;
                int i77 = 0;
                if (!composer7.getInserting()) {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                    if (!Intrinsics.areEqual(composer7.rememberedValue(), Integer.valueOf(obj48))) {
                        composer7.updateRememberedValue(Integer.valueOf(obj48));
                        constructor-impl.apply(Integer.valueOf(obj48), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer = composer7;
                    }
                } else {
                    localMap$iv$iv = currentCompositionLocalMap;
                    measurePolicy = maybeCachedBoxMeasurePolicy;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer5 = composer2;
                i18 = i32;
                ComposerKt.sourceInformationMarkerStart(composer5, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                composer3 = composer5;
                i23 = 0;
                boxScopeInstance = iNSTANCE;
                modifier3 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer5, -1392970137, "C104@4488L643,101@4357L774:PullRefreshIndicator.kt#t44y28");
                obj44 = i40;
                companion = i46;
                int i37 = 0;
                PullRefreshIndicatorKt.PullRefreshIndicator.1.1 anon = new PullRefreshIndicatorKt.PullRefreshIndicator.1.1(contentColor2, obj11, obj4);
                CrossfadeKt.Crossfade(Boolean.valueOf(refreshing), 0, (FiniteAnimationSpec)AnimationSpecKt.tween$default(100, 0, i37, i26, i37), 0, (Function3)ComposableLambdaKt.rememberComposableLambda(1853731063, true, anon, composer5, 54), composer3, i34 |= 24960, 10);
                ComposerKt.sourceInformationMarkerEnd(composer3);
                ComposerKt.sourceInformationMarkerEnd(composer5);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                color = contentColor2;
                $dirty = str;
                $composer3 = obj;
                z = z3;
            } else {
                restartGroup.skipToGroupEnd();
                composer2 = restartGroup;
                i2 = $dirty2;
                $composer3 = obj2;
                $dirty = contentColor2;
                color = str;
                z = z3;
            }
        } else {
        }
        final ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress = new PullRefreshIndicatorKt.PullRefreshIndicator.2(refreshing, obj4, $composer3, $dirty, i22, color, obj2, z, i52, obj52);
            endRestartGroup.updateScope((Function2)traceInProgress);
        }
    }

    private static final boolean PullRefreshIndicator_jB83MbM$lambda$1(State<Boolean> $showElevation$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Boolean)$showElevation$delegate.getValue().booleanValue();
    }

    public static final androidx.compose.material.pullrefresh.ArrowValues access$ArrowValues(float progress) {
        return PullRefreshIndicatorKt.ArrowValues(progress);
    }

    public static final void access$CircularArrowIndicator-iJQMabo(androidx.compose.material.pullrefresh.PullRefreshState state, long color, Modifier modifier, Composer $composer, int $changed) {
        PullRefreshIndicatorKt.CircularArrowIndicator-iJQMabo(state, color, modifier, $composer, $changed);
    }

    public static final void access$drawArrow-Bx497Mc(DrawScope $receiver, Path arrow, Rect bounds, long color, float alpha, androidx.compose.material.pullrefresh.ArrowValues values) {
        PullRefreshIndicatorKt.drawArrow-Bx497Mc($receiver, arrow, bounds, color, alpha, values);
    }

    public static final float access$getArcRadius$p() {
        return PullRefreshIndicatorKt.ArcRadius;
    }

    public static final float access$getStrokeWidth$p() {
        return PullRefreshIndicatorKt.StrokeWidth;
    }

    private static final void drawArrow-Bx497Mc(DrawScope $this$drawArrow_u2dBx497Mc, Path arrow, Rect bounds, long color, float alpha, androidx.compose.material.pullrefresh.ArrowValues values) {
        long previousSize$iv$iv;
        long radius;
        Object obj4;
        long l;
        Object obj5;
        final Object obj = $this$drawArrow_u2dBx497Mc;
        final DrawScope drawScope = arrow;
        drawScope.reset();
        int i = 0;
        drawScope.moveTo(i, i);
        drawScope.lineTo(px-0680j_43 *= scale2, i);
        drawScope.lineTo(i2 /= f2, px-0680j_44 *= scale3);
        int i11 = 1073741824;
        int i19 = f / i11;
        final int i20 = i4 / i11;
        px-0680j_45 /= i11;
        drawScope.translate-k-4lQ0M(OffsetKt.Offset(i5 -= i20, y-impl += i13));
        drawScope.close();
        final Object obj2 = $this$drawArrow_u2dBx497Mc;
        long center-F1C5BW03 = obj2.getCenter-F1C5BW0();
        final int i21 = 0;
        final Object obj3 = obj2;
        final int i22 = 0;
        DrawContext drawContext = obj3.getDrawContext();
        final int i23 = 0;
        drawContext.getCanvas().save();
        int i15 = 0;
        drawContext.getTransform().rotate-Uv8p0NA(obj31.getEndAngle(), center-F1C5BW03);
        int i7 = 0;
        final DrawContext context4 = context;
        final int i24 = i19;
        final int i25 = i20;
        long previousSize$iv$iv2 = center-F1C5BW03;
        DrawScope.drawPath-LG529CI$default(obj3, drawScope, color, i13, values, 0, 0, 0, 56);
        context4.getCanvas().restore();
        context4.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }
}
