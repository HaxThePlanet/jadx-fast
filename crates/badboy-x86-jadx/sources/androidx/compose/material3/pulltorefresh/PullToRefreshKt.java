package androidx.compose.material3.pulltorefresh;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Alignment.Companion;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Color.Companion;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.PathFillType.Companion;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeCap.Companion;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawTransform;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.node.ComposeUiNode.Companion;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0080\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0010\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u001a\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0002H\u0002\u001a(\u0010\u0017\u001a\u00020\u00182\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a\u007f\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 2\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u00192\u0008\u0008\u0002\u0010\"\u001a\u00020#2\u0008\u0008\u0002\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010&\u001a\u00020'2\u001e\u0008\u0002\u0010(\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00180)¢\u0006\u0002\u0008+¢\u0006\u0002\u0008,2\u001c\u0010-\u001a\u0018\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00180)¢\u0006\u0002\u0008+¢\u0006\u0002\u0008,H\u0007¢\u0006\u0002\u0010.\u001a\u0008\u0010/\u001a\u00020%H\u0007\u001a\r\u00100\u001a\u00020%H\u0007¢\u0006\u0002\u00101\u001aF\u00102\u001a\u00020\u0018*\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\u0008;\u0010<\u001a>\u0010=\u001a\u00020\u0018*\u0002032\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00108\u001a\u00020\u00022\u0006\u00109\u001a\u00020\u00152\u0006\u0010>\u001a\u0002072\u0006\u0010:\u001a\u00020\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\u0008?\u0010@\u001aH\u0010A\u001a\u00020#*\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010B\u001a\u00020 2\u0008\u0008\u0002\u0010C\u001a\u00020\u00042\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u0019H\u0007ø\u0001\u0000¢\u0006\u0004\u0008D\u0010E\u001aN\u0010F\u001a\u00020#*\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020 2\u0008\u0008\u0002\u0010C\u001a\u00020\u00042\u0008\u0008\u0002\u0010G\u001a\u00020H2\u0008\u0008\u0002\u0010I\u001a\u00020\u001b2\u0008\u0008\u0002\u0010J\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\u0008K\u0010L\"\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0008\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000c\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u000e\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\u000f\u0010\u0010\"\u0016\u0010\u0011\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\u0008\u0012\u0010\u0010\"\u0010\u0010\u0013\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006M²\u0006\n\u0010N\u001a\u00020\u0002X\u008a\u0084\u0002", d2 = {"AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "", "ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "DragMultiplier", "MaxAlpha", "MaxProgressArc", "MinAlpha", "SpinnerContainerSize", "getSpinnerContainerSize", "()F", "SpinnerSize", "getSpinnerSize", "StrokeWidth", "ArrowValues", "Landroidx/compose/material3/pulltorefresh/ArrowValues;", "progress", "CircularArrowProgressIndicator", "", "Lkotlin/Function0;", "color", "Landroidx/compose/ui/graphics/Color;", "CircularArrowProgressIndicator-RPmYEkk", "(Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "PullToRefreshBox", "isRefreshing", "", "onRefresh", "modifier", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "contentAlignment", "Landroidx/compose/ui/Alignment;", "indicator", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/BoxScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "content", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/material3/pulltorefresh/PullToRefreshState;Landroidx/compose/ui/Alignment;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "PullToRefreshState", "rememberPullToRefreshState", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/pulltorefresh/PullToRefreshState;", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", "values", "strokeWidth", "drawArrow-uDrxG_w", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;F)V", "drawCircularIndicator", "arcBounds", "drawCircularIndicator-KzyDr3Q", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFLandroidx/compose/material3/pulltorefresh/ArrowValues;Landroidx/compose/ui/geometry/Rect;F)V", "pullToRefresh", "enabled", "threshold", "pullToRefresh-Z4HSEVQ", "(Landroidx/compose/ui/Modifier;ZLandroidx/compose/material3/pulltorefresh/PullToRefreshState;ZFLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/Modifier;", "pullToRefreshIndicator", "shape", "Landroidx/compose/ui/graphics/Shape;", "containerColor", "elevation", "pullToRefreshIndicator-wUdLESc", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material3/pulltorefresh/PullToRefreshState;ZFLandroidx/compose/ui/graphics/Shape;JF)Landroidx/compose/ui/Modifier;", "material3_release", "targetAlpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PullToRefreshKt {

    private static final TweenSpec<Float> AlphaTween = null;
    private static final float ArcRadius = 0f;
    private static final float ArrowHeight = 0f;
    private static final float ArrowWidth = 0f;
    private static final int CrossfadeDurationMs = 100;
    private static final float DragMultiplier = 0.5f;
    private static final float MaxAlpha = 1f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float SpinnerContainerSize;
    private static final float SpinnerSize;
    private static final float StrokeWidth;
    static {
        int i10 = 0;
        PullToRefreshKt.StrokeWidth = Dp.constructor-impl((float)l);
        int i11 = 0;
        PullToRefreshKt.ArcRadius = Dp.constructor-impl((float)l2);
        int i5 = 0;
        PullToRefreshKt.SpinnerSize = Dp.constructor-impl((float)i);
        int i6 = 0;
        PullToRefreshKt.SpinnerContainerSize = Dp.constructor-impl((float)i2);
        int i7 = 0;
        PullToRefreshKt.ArrowWidth = Dp.constructor-impl((float)i3);
        int i8 = 0;
        PullToRefreshKt.ArrowHeight = Dp.constructor-impl((float)i4);
        PullToRefreshKt.AlphaTween = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, 0);
    }

    private static final androidx.compose.material3.pulltorefresh.ArrowValues ArrowValues(float progress) {
        int i = 1065353216;
        int i5 = 1053609165;
        int i10 = 0;
        i3 /= f5;
        float coerceIn = RangesKt.coerceIn(f6 -= i, i10, 1073741824);
        i8 *= i22;
        float f9 = (float)i23;
        ArrowValues arrowValues = new ArrowValues(i9, i9 * f9, i25 *= f9, Math.min(i, i4));
        return arrowValues;
    }

    private static final void CircularArrowProgressIndicator-RPmYEkk(Function0<Float> progress, long color, Composer $composer, int $changed) {
        int traceInProgress2;
        Object path;
        int $dirty;
        Object $dirty2;
        int empty2;
        int i;
        int i3;
        boolean skipping;
        boolean traceInProgress;
        int i9;
        int alphaState;
        int evenOdd-Rg-k1Os;
        int size-3ABfNKs;
        int i5;
        int i2;
        Composer composer;
        int i8;
        Object anon2;
        int i6;
        Object rememberedValue;
        Object empty;
        Object derivedStateOf;
        int i7;
        Object anon;
        Object obj;
        int i10;
        PathFillType.Companion companion2;
        int i4;
        Composer.Companion companion;
        int obj23;
        final Object obj2 = progress;
        final long l = color;
        final int i16 = obj24;
        traceInProgress2 = -569718810;
        final Composer restartGroup = $changed.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(CircularArrowProgressIndicator)P(1,0:c#ui.graphics.Color)562@20583L61,564@20745L76,565@20843L74,567@20982L98,571@21118L443,566@20922L639:PullToRefresh.kt#djiw08");
        if (i16 & 6 == 0) {
            i = restartGroup.changedInstance(obj2) ? 4 : 2;
            $dirty |= i;
        }
        if (i16 & 48 == 0) {
            i3 = restartGroup.changed(l) ? 32 : 16;
            $dirty |= i3;
        }
        if ($dirty & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, $dirty, -1, "androidx.compose.material3.pulltorefresh.CircularArrowProgressIndicator (PullToRefresh.kt:561)");
                }
                String str2 = "CC(remember):PullToRefresh.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1136642763, str2);
                int i12 = 0;
                Composer composer2 = restartGroup;
                int i19 = 0;
                Object rememberedValue2 = composer2.rememberedValue();
                int i29 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    anon = AndroidPath_androidKt.Path();
                    i10 = 0;
                    anon.setFillType-oQ8Xj4U(PathFillType.Companion.getEvenOdd-Rg-k1Os());
                    composer2.updateRememberedValue(anon);
                } else {
                    anon = rememberedValue2;
                }
                Object invalid$iv = anon;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1136647962, str2);
                int i18 = 0;
                Composer composer3 = restartGroup;
                int i20 = 0;
                Object rememberedValue3 = composer3.rememberedValue();
                int i30 = 0;
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    int i35 = 0;
                    anon = new PullToRefreshKt.CircularArrowProgressIndicator.targetAlpha.2.1(obj2);
                    composer3.updateRememberedValue(SnapshotStateKt.derivedStateOf((Function0)anon));
                } else {
                    derivedStateOf = rememberedValue3;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                obj23 = $dirty;
                $dirty2 = 32;
                State animateFloatAsState = AnimateAsStateKt.animateFloatAsState(PullToRefreshKt.CircularArrowProgressIndicator_RPmYEkk$lambda$4((State)derivedStateOf), (AnimationSpec)PullToRefreshKt.AlphaTween, 0, 0, 0, restartGroup, 48, 28);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1136655568, str2);
                i2 = obj23 & 14 == 4 ? 1 : 0;
                Composer composer4 = restartGroup;
                int i37 = 0;
                Object rememberedValue4 = composer4.rememberedValue();
                i4 = 0;
                if (i2 == 0) {
                    if (rememberedValue4 == Composer.Companion.getEmpty()) {
                        $dirty2 = 0;
                        anon2 = new PullToRefreshKt.CircularArrowProgressIndicator.1.1(obj2);
                        composer4.updateRememberedValue((Function1)anon2);
                    } else {
                        anon2 = rememberedValue4;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i13 = 1;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 1136660265, str2);
                i9 = obj23 & 14 == 4 ? i13 : 0;
                i6 = obj23 & 112 == 32 ? i13 : 0;
                composer = restartGroup;
                i8 = 0;
                rememberedValue = composer.rememberedValue();
                i7 = 0;
                if (empty2 | changedInstance == null) {
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        companion2 = 0;
                        alphaState = obj23;
                        path = new PullToRefreshKt.CircularArrowProgressIndicator.2.1(obj2, animateFloatAsState, l, obj4, invalid$iv);
                        composer.updateRememberedValue((Function1)path);
                    } else {
                        skipping = invalid$iv;
                        $dirty = animateFloatAsState;
                        path = rememberedValue;
                        alphaState = obj23;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                CanvasKt.Canvas(SizeKt.size-3ABfNKs(SemanticsModifierKt.semantics((Modifier)Modifier.Companion, i13, (Function1)anon2), PullToRefreshKt.SpinnerSize), (Function1)path, restartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
                alphaState = $dirty;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = new PullToRefreshKt.CircularArrowProgressIndicator.3(obj2, l, obj4, i16);
            endRestartGroup.updateScope((Function2)$dirty);
        }
    }

    private static final float CircularArrowProgressIndicator_RPmYEkk$lambda$4(State<Float> $targetAlpha$delegate) {
        int i = 0;
        final int i2 = 0;
        final int i3 = 0;
        return (Number)$targetAlpha$delegate.getValue().floatValue();
    }

    public static final void PullToRefreshBox(boolean isRefreshing, Function0<Unit> onRefresh, Modifier modifier, androidx.compose.material3.pulltorefresh.PullToRefreshState state, Alignment contentAlignment, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> indicator, Function3<? super BoxScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed, int i10) {
        int traceInProgress2;
        boolean valueOf;
        Function0 factory$iv$iv$iv;
        int $dirty2;
        Object $dirty;
        int i12;
        int i13;
        Object obj5;
        Object modifier3;
        Integer pullToRefresh-Z4HSEVQ$default;
        Object rememberComposableLambda;
        Object obj3;
        boolean traceInProgress;
        Composer composer3;
        int valueOf2;
        Object obj2;
        Object obj6;
        int i11;
        Object str;
        Object obj7;
        int changed;
        int i9;
        Object obj8;
        int i6;
        Object obj;
        int i3;
        int i14;
        Object obj9;
        int i7;
        int i;
        boolean skipping;
        boolean defaultsInvalid;
        int currentCompositionLocalMap;
        int i5;
        Object obj4;
        Modifier modifier2;
        Composer composer2;
        int i8;
        int i2;
        Modifier modifier$iv;
        int i4;
        Composer composer;
        int i15;
        Object obj28;
        int obj29;
        int obj30;
        Object obj31;
        int obj33;
        valueOf = isRefreshing;
        obj8 = content;
        i6 = $changed;
        traceInProgress2 = 1902956467;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(PullToRefreshBox)P(3,5,4,6,1,2)124@5580L28,126@5713L163,135@5931L199:PullToRefresh.kt#djiw08");
        $dirty2 = $changed;
        if (i10 & 1 != 0) {
            $dirty2 |= 6;
        } else {
            if (i6 & 6 == 0) {
                i12 = restartGroup.changed(valueOf) ? 4 : 2;
                $dirty2 |= i12;
            }
        }
        if (i10 & 2 != 0) {
            $dirty2 |= 48;
            obj2 = onRefresh;
        } else {
            if (i6 & 48 == 0) {
                i13 = restartGroup.changedInstance(onRefresh) ? 32 : 16;
                $dirty2 |= i13;
            } else {
                obj2 = onRefresh;
            }
        }
        int i31 = i10 & 4;
        if (i31 != 0) {
            $dirty2 |= 384;
            rememberComposableLambda = modifier;
        } else {
            if (i6 & 384 == 0) {
                i11 = restartGroup.changed(modifier) ? 256 : 128;
                $dirty2 |= i11;
            } else {
                rememberComposableLambda = modifier;
            }
        }
        if (i6 & 3072 == 0) {
            if (i10 & 8 == 0) {
                changed = restartGroup.changed(state) ? 2048 : 1024;
            } else {
                str = state;
            }
            $dirty2 |= changed;
        } else {
            str = state;
        }
        i9 = i10 & 16;
        if (i9 != 0) {
            $dirty2 |= 24576;
            obj = contentAlignment;
        } else {
            if (i6 & 24576 == 0) {
                i3 = restartGroup.changed(contentAlignment) ? 16384 : 8192;
                $dirty2 |= i3;
            } else {
                obj = contentAlignment;
            }
        }
        int i48 = i10 & 32;
        int i50 = 196608;
        if (i48 != 0) {
            $dirty2 |= i50;
            obj9 = indicator;
        } else {
            if (i50 &= i6 == 0) {
                i7 = restartGroup.changedInstance(indicator) ? 131072 : 65536;
                $dirty2 |= i7;
            } else {
                obj9 = indicator;
            }
        }
        int i53 = 1572864;
        if (i10 & 64 != 0) {
            $dirty2 |= i53;
        } else {
            if (i6 & i53 == 0) {
                i = restartGroup.changedInstance(obj8) ? 1048576 : 524288;
                $dirty2 |= i;
            }
        }
        if (i52 &= $dirty2 == 599186) {
            if (!restartGroup.getSkipping()) {
                restartGroup.startDefaults();
                if (i6 & 1 != 0) {
                    if (restartGroup.getDefaultsInvalid()) {
                        if (i31 != 0) {
                            modifier3 = Modifier.Companion;
                        } else {
                            modifier3 = rememberComposableLambda;
                        }
                        if (i10 & 8 != 0) {
                            $dirty2 &= -7169;
                            str = rememberComposableLambda;
                        }
                        if (i9 != 0) {
                            obj = rememberComposableLambda;
                        }
                        if (i48 != 0) {
                            PullToRefreshKt.PullToRefreshBox.1 anon = new PullToRefreshKt.PullToRefreshBox.1(str, valueOf);
                            i14 = $dirty2;
                            obj9 = rememberComposableLambda;
                            $dirty = str;
                        } else {
                            i14 = $dirty2;
                            $dirty = str;
                        }
                    } else {
                        restartGroup.skipToGroupEnd();
                        if (i10 & 8 != 0) {
                            $dirty2 &= -7169;
                        }
                        i14 = $dirty2;
                        modifier3 = rememberComposableLambda;
                        $dirty = str;
                    }
                } else {
                }
                restartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i14, -1, "androidx.compose.material3.pulltorefresh.PullToRefreshBox (PullToRefresh.kt:134)");
                }
                Object obj10 = modifier3;
                pullToRefresh-Z4HSEVQ$default = PullToRefreshKt.pullToRefresh-Z4HSEVQ$default(obj10, valueOf, $dirty, false, 0, obj2, 12, 0);
                i17 &= 112;
                valueOf2 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                skipping = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                obj29 = currentCompositeKeyHash;
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(restartGroup, pullToRefresh-Z4HSEVQ$default);
                obj31 = constructor;
                i5 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!applier instanceof Applier) {
                    ComposablesKt.invalidApplier();
                }
                restartGroup.startReusableNode();
                if (restartGroup.getInserting()) {
                    restartGroup.createNode(obj31);
                } else {
                    factory$iv$iv$iv = obj31;
                    restartGroup.useNode();
                }
                Composer constructor-impl = Updater.constructor-impl(restartGroup);
                int i56 = 0;
                obj31 = factory$iv$iv$iv;
                Updater.set-impl(constructor-impl, BoxKt.maybeCachedBoxMeasurePolicy(obj, false), ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(constructor-impl, restartGroup.getCurrentCompositionLocalMap(), ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                int i57 = 0;
                Composer composer6 = constructor-impl;
                int i58 = 0;
                if (!composer6.getInserting()) {
                    modifier$iv = pullToRefresh-Z4HSEVQ$default;
                    i4 = valueOf2;
                    if (!Intrinsics.areEqual(composer6.rememberedValue(), Integer.valueOf(obj29))) {
                        composer6.updateRememberedValue(Integer.valueOf(obj29));
                        constructor-impl.apply(Integer.valueOf(obj29), ComposeUiNode.Companion.getSetCompositeKeyHash());
                    } else {
                        composer3 = composer6;
                    }
                } else {
                    modifier$iv = pullToRefresh-Z4HSEVQ$default;
                    i4 = valueOf2;
                }
                Updater.set-impl(constructor-impl, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                Composer composer4 = restartGroup;
                modifier2 = materializeModifier;
                ComposerKt.sourceInformationMarkerStart(composer4, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance iNSTANCE = BoxScopeInstance.INSTANCE;
                i38 |= 6;
                i8 = 0;
                i2 = i22;
                i15 = i32;
                Composer composer5 = composer2;
                ComposerKt.sourceInformationMarkerStart(composer5, 1101976897, "C139@6095L9,140@6113L11:PullToRefresh.kt#djiw08");
                obj8.invoke((BoxScope)iNSTANCE, composer5, Integer.valueOf(i23 |= i29));
                obj9.invoke(iNSTANCE, composer5, Integer.valueOf(i25 |= $dirty2));
                ComposerKt.sourceInformationMarkerEnd(composer5);
                ComposerKt.sourceInformationMarkerEnd(composer4);
                restartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                obj5 = obj28;
                obj3 = obj4;
                obj6 = obj;
                obj7 = obj9;
            } else {
                restartGroup.skipToGroupEnd();
                i14 = $dirty2;
                obj5 = rememberComposableLambda;
                obj3 = str;
                obj6 = obj;
                obj7 = obj9;
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            traceInProgress2 = new PullToRefreshKt.PullToRefreshBox.3(isRefreshing, onRefresh, obj5, obj3, obj6, obj7, obj8, i6, i10);
            endRestartGroup.updateScope((Function2)traceInProgress2);
        }
    }

    public static final androidx.compose.material3.pulltorefresh.PullToRefreshState PullToRefreshState() {
        PullToRefreshStateImpl pullToRefreshStateImpl = new PullToRefreshStateImpl();
        return (PullToRefreshState)pullToRefreshStateImpl;
    }

    public static final androidx.compose.material3.pulltorefresh.ArrowValues access$ArrowValues(float progress) {
        return PullToRefreshKt.ArrowValues(progress);
    }

    public static final void access$CircularArrowProgressIndicator-RPmYEkk(Function0 progress, long color, Composer $composer, int $changed) {
        PullToRefreshKt.CircularArrowProgressIndicator-RPmYEkk(progress, color, $composer, $changed);
    }

    public static final void access$drawArrow-uDrxG_w(DrawScope $receiver, Path arrow, Rect bounds, long color, float alpha, androidx.compose.material3.pulltorefresh.ArrowValues values, float strokeWidth) {
        PullToRefreshKt.drawArrow-uDrxG_w($receiver, arrow, bounds, color, alpha, values, strokeWidth);
    }

    public static final void access$drawCircularIndicator-KzyDr3Q(DrawScope $receiver, long color, float alpha, androidx.compose.material3.pulltorefresh.ArrowValues values, Rect arcBounds, float strokeWidth) {
        PullToRefreshKt.drawCircularIndicator-KzyDr3Q($receiver, color, alpha, values, arcBounds, strokeWidth);
    }

    public static final float access$getArcRadius$p() {
        return PullToRefreshKt.ArcRadius;
    }

    public static final float access$getStrokeWidth$p() {
        return PullToRefreshKt.StrokeWidth;
    }

    private static final void drawArrow-uDrxG_w(DrawScope $this$drawArrow_u2duDrxG_w, Path arrow, Rect bounds, long color, float alpha, androidx.compose.material3.pulltorefresh.ArrowValues values, float strokeWidth) {
        Canvas canvas;
        long l;
        Object obj4;
        Object obj5;
        final Object obj = $this$drawArrow_u2duDrxG_w;
        final DrawScope drawScope = arrow;
        float f3 = obj36;
        drawScope.reset();
        int i = 0;
        drawScope.moveTo(i, i);
        final float scale4 = strokeWidth.getScale();
        drawScope.lineTo(i6 /= f2, px-0680j_45 *= scale4);
        drawScope.lineTo(px-0680j_43 *= scale2, i);
        int i9 = 1073741824;
        final int i16 = f / i9;
        drawScope.translate-k-4lQ0M(OffsetKt.Offset(i3 -= i17, y-impl -= px-0680j_46));
        final Object obj2 = $this$drawArrow_u2duDrxG_w;
        long center-F1C5BW03 = obj2.getCenter-F1C5BW0();
        final int i19 = 0;
        final Object obj3 = obj2;
        final int i20 = 0;
        DrawContext drawContext = obj3.getDrawContext();
        final int i21 = 0;
        drawContext.getCanvas().save();
        int i13 = 0;
        drawContext.getTransform().rotate-Uv8p0NA(endAngle - px-0680j_44, center-F1C5BW03);
        Canvas $this$withTransform_u24lambda_u246$iv$iv = obj3;
        int i5 = 0;
        Stroke stroke2 = new Stroke($this$withTransform_u24lambda_u246$iv$iv.toPx-0680j_4(f3), 0, 0, 0, 0, 30, 0);
        int i24 = i16;
        DrawContext context5 = context4;
        long l4 = center-F1C5BW03;
        DrawScope.drawPath-LG529CI$default($this$withTransform_u24lambda_u246$iv$iv, drawScope, color, scale4, values, (DrawStyle)stroke2, 0, 0, 48);
        context5.getCanvas().restore();
        context5.setSize-uvyYCjk(drawContext.getSize-NH-jbRc());
    }

    private static final void drawCircularIndicator-KzyDr3Q(DrawScope $this$drawCircularIndicator_u2dKzyDr3Q, long color, float alpha, androidx.compose.material3.pulltorefresh.ArrowValues values, Rect arcBounds, float strokeWidth) {
        Object obj = $this$drawCircularIndicator_u2dKzyDr3Q;
        final StrokeCap.Companion companion = StrokeCap.Companion;
        final int i8 = 0;
        Stroke stroke = new Stroke(obj.toPx-0680j_4(obj24), 0, companion.getButt-KaPHkGw(), 0, i8, 26, 0);
        DrawScope.drawArc-yD3GUKo$default(obj, color, companion, arcBounds.getStartAngle(), endAngle - startAngle, 0, strokeWidth.getTopLeft-F1C5BW0(), obj7, strokeWidth.getSize-NH-jbRc(), obj9, values, (DrawStyle)stroke, 0);
    }

    public static final float getSpinnerContainerSize() {
        return PullToRefreshKt.SpinnerContainerSize;
    }

    public static final float getSpinnerSize() {
        return PullToRefreshKt.SpinnerSize;
    }

    public static final Modifier pullToRefresh-Z4HSEVQ(Modifier $this$pullToRefresh_u2dZ4HSEVQ, boolean isRefreshing, androidx.compose.material3.pulltorefresh.PullToRefreshState state, boolean enabled, float threshold, Function0<Unit> onRefresh) {
        PullToRefreshElement pullToRefreshElement = new PullToRefreshElement(isRefreshing, onRefresh, enabled, state, threshold, 0);
        return $this$pullToRefresh_u2dZ4HSEVQ.then((Modifier)pullToRefreshElement);
    }

    public static Modifier pullToRefresh-Z4HSEVQ$default(Modifier modifier, boolean z2, androidx.compose.material3.pulltorefresh.PullToRefreshState pullToRefreshState3, boolean z4, float f5, Function0 function06, int i7, Object object8) {
        int i;
        float f;
        int obj9;
        float obj10;
        i = i7 & 4 != 0 ? obj9 : z4;
        if (i7 & 8 != 0) {
            f = obj10;
        } else {
            f = f5;
        }
        return PullToRefreshKt.pullToRefresh-Z4HSEVQ(modifier, z2, pullToRefreshState3, i, f, function06);
    }

    public static final Modifier pullToRefreshIndicator-wUdLESc(Modifier $this$pullToRefreshIndicator_u2dwUdLESc, androidx.compose.material3.pulltorefresh.PullToRefreshState state, boolean isRefreshing, float threshold, Shape shape, long containerColor, float elevation) {
        final Shape shape2 = shape;
        PullToRefreshKt.pullToRefreshIndicator.2 anon = new PullToRefreshKt.pullToRefreshIndicator.2(state, isRefreshing, threshold, obj14, shape2);
        return BackgroundKt.background-bw27NRU(GraphicsLayerModifierKt.graphicsLayer(DrawModifierKt.drawWithContent(SizeKt.size-3ABfNKs($this$pullToRefreshIndicator_u2dwUdLESc, PullToRefreshKt.SpinnerContainerSize), (Function1)PullToRefreshKt.pullToRefreshIndicator.1.INSTANCE), (Function1)anon), containerColor, elevation);
    }

    public static Modifier pullToRefreshIndicator-wUdLESc$default(Modifier modifier, androidx.compose.material3.pulltorefresh.PullToRefreshState pullToRefreshState2, boolean z3, float f4, Shape shape5, long l6, float f7, int i8, Object object9) {
        float f;
        Shape shape;
        long l;
        float f2;
        float obj11;
        Shape obj12;
        long obj13;
        if (object9 & 4 != 0) {
            f = obj11;
        } else {
            f = f4;
        }
        if (object9 & 8 != 0) {
            shape = obj12;
        } else {
            shape = shape5;
        }
        if (object9 & 16 != 0) {
            l = obj13;
        } else {
            l = l6;
        }
        if (object9 & 32 != 0) {
            f2 = obj11;
        } else {
            f2 = i8;
        }
        return PullToRefreshKt.pullToRefreshIndicator-wUdLESc(modifier, pullToRefreshState2, z3, f, shape, l, obj6);
    }

    public static final androidx.compose.material3.pulltorefresh.PullToRefreshState rememberPullToRefreshState(Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        int i = 318623070;
        ComposerKt.sourceInformationMarkerStart($composer, i, "C(rememberPullToRefreshState)513@19156L83:PullToRefresh.kt#djiw08");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i, $changed, -1, "androidx.compose.material3.pulltorefresh.rememberPullToRefreshState (PullToRefresh.kt:512)");
        }
        final Composer composer = $composer;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return (PullToRefreshState)(PullToRefreshStateImpl)RememberSaveableKt.rememberSaveable(new Object[0], PullToRefreshStateImpl.Companion.getSaver(), 0, (Function0)PullToRefreshKt.rememberPullToRefreshState.1.INSTANCE, composer, 3072, 4);
    }
}
