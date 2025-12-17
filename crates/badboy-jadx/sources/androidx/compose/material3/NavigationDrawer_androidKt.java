package androidx.compose.material3;

import androidx.activity.compose.PredictiveBackHandlerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref.FloatRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a.\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\n0\u000e¢\u0006\u0002\u0008\u0010H\u0001¢\u0006\u0002\u0010\u0011\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0006\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\u0008\u0008\u0010\u0003¨\u0006\u0012", d2 = {"PredictiveBackDrawerMaxScaleXDistanceGrow", "Landroidx/compose/ui/unit/Dp;", "getPredictiveBackDrawerMaxScaleXDistanceGrow", "()F", "F", "PredictiveBackDrawerMaxScaleXDistanceShrink", "getPredictiveBackDrawerMaxScaleXDistanceShrink", "PredictiveBackDrawerMaxScaleYDistance", "getPredictiveBackDrawerMaxScaleYDistance", "DrawerPredictiveBackHandler", "", "drawerState", "Landroidx/compose/material3/DrawerState;", "content", "Lkotlin/Function1;", "Landroidx/compose/material3/DrawerPredictiveBackState;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/material3/DrawerState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "material3_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class NavigationDrawer_androidKt {

    private static final float PredictiveBackDrawerMaxScaleXDistanceGrow;
    private static final float PredictiveBackDrawerMaxScaleXDistanceShrink;
    private static final float PredictiveBackDrawerMaxScaleYDistance;
    static {
        int i4 = 0;
        NavigationDrawer_androidKt.PredictiveBackDrawerMaxScaleXDistanceGrow = Dp.constructor-impl((float)i);
        int i5 = 0;
        NavigationDrawer_androidKt.PredictiveBackDrawerMaxScaleXDistanceShrink = Dp.constructor-impl((float)i2);
        int i6 = 0;
        NavigationDrawer_androidKt.PredictiveBackDrawerMaxScaleYDistance = Dp.constructor-impl((float)i3);
    }

    public static final void DrawerPredictiveBackHandler(androidx.compose.material3.DrawerState drawerState, Function3<? super androidx.compose.material3.DrawerPredictiveBackState, ? super Composer, ? super Integer, Unit> content, Composer $composer, int $changed) {
        int traceInProgress2;
        Object $changed$iv;
        Object maxScaleXDistanceShrink;
        int $dirty2;
        boolean $dirty;
        boolean traceInProgress;
        int i7;
        int i2;
        int $i$a$CacheNavigationDrawer_androidKt$DrawerPredictiveBackHandler$3;
        Object $i$f$rememberCoroutineScope;
        int isRtl;
        Ref.FloatRef floatRef;
        Ref.FloatRef it$iv;
        Object empty3;
        Ref.FloatRef it$iv2;
        Object drawerPredictiveBackState;
        int empty2;
        int i5;
        Ref.FloatRef maxScaleYDistance;
        int compositionCoroutineScope;
        int i6;
        Object rememberedValue;
        Object empty;
        int i3;
        Composer.Companion companion;
        int $changed$iv2;
        kotlinx.coroutines.CoroutineScope scope;
        int i4;
        int i8;
        int i;
        Object obj;
        final Object obj3 = drawerState;
        final Object obj5 = content;
        final int i35 = $changed;
        traceInProgress2 = 1444817207;
        final Composer restartGroup = $composer.startRestartGroup(traceInProgress2);
        ComposerKt.sourceInformation(restartGroup, "C(DrawerPredictiveBackHandler)P(1)45@1743L40,46@1800L24,47@1862L7,*51@2024L7,57@2337L1264,57@2285L1316,89@3644L99,89@3607L136,95@3749L34:NavigationDrawer.android.kt#uh7d8r");
        if (i35 & 6 == 0) {
            i7 = restartGroup.changed(obj3) ? 4 : 2;
            $dirty2 |= i7;
        }
        if (i35 & 48 == 0) {
            i2 = restartGroup.changedInstance(obj5) ? 32 : 16;
            $dirty2 |= i2;
        }
        final int i38 = $dirty2;
        if (i38 & 19 == 18) {
            if (!restartGroup.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(traceInProgress2, i38, -1, "androidx.compose.material3.DrawerPredictiveBackHandler (NavigationDrawer.android.kt:44)");
                }
                String str5 = "CC(remember):NavigationDrawer.android.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, 228403032, str5);
                int i10 = 0;
                Composer composer = restartGroup;
                int i14 = 0;
                Object rememberedValue2 = composer.rememberedValue();
                int i18 = 0;
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    empty3 = 0;
                    drawerPredictiveBackState = new DrawerPredictiveBackState();
                    composer.updateRememberedValue(drawerPredictiveBackState);
                } else {
                    drawerPredictiveBackState = rememberedValue2;
                }
                $dirty = drawerPredictiveBackState;
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i11 = i39;
                int i15 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(restartGroup, -954363344, "CC(remember):Effects.kt#9igjgp");
                int i20 = 0;
                Composer composer3 = restartGroup;
                int i29 = 0;
                Object rememberedValue4 = composer3.rememberedValue();
                int i40 = 0;
                if (rememberedValue4 == Composer.Companion.getEmpty()) {
                    empty = 0;
                    int i43 = 0;
                    $changed$iv2 = i11;
                    $changed$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, restartGroup));
                    composer3.updateRememberedValue($changed$iv);
                } else {
                    $changed$iv2 = i11;
                    $changed$iv = rememberedValue4;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                $i$f$rememberCoroutineScope = coroutineScope;
                int i17 = 0;
                int i21 = 0;
                int i22 = 2023513938;
                String str4 = "CC:CompositionLocal.kt#9igjgp";
                ComposerKt.sourceInformationMarkerStart(restartGroup, i22, str4);
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                isRtl = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalLayoutDirection()) == LayoutDirection.Rtl ? 1 : 0;
                floatRef = new Ref.FloatRef();
                Ref.FloatRef floatRef2 = new Ref.FloatRef();
                maxScaleYDistance = new Ref.FloatRef();
                int i41 = 0;
                int i42 = 0;
                ComposerKt.sourceInformationMarkerStart(restartGroup, i22, str4);
                Object consume = restartGroup.consume((CompositionLocal)CompositionLocalsKt.getLocalDensity());
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i30 = 0;
                floatRef.element = (Density)consume.toPx-0680j_4(NavigationDrawer_androidKt.PredictiveBackDrawerMaxScaleXDistanceGrow);
                floatRef2.element = consume.toPx-0680j_4(NavigationDrawer_androidKt.PredictiveBackDrawerMaxScaleXDistanceShrink);
                maxScaleYDistance.element = consume.toPx-0680j_4(NavigationDrawer_androidKt.PredictiveBackDrawerMaxScaleYDistance);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 228423264, str5);
                empty2 = i38 & 14 == 4 ? 1 : 0;
                Composer composer5 = restartGroup;
                int i44 = 0;
                Object rememberedValue3 = composer5.rememberedValue();
                i8 = 0;
                if (i27 |= empty2 == 0) {
                    if (rememberedValue3 == Composer.Companion.getEmpty()) {
                        i = 0;
                        obj = obj4;
                        maxScaleXDistanceShrink = new NavigationDrawer_androidKt.DrawerPredictiveBackHandler.2.1((DrawerPredictiveBackState)$dirty, $i$f$rememberCoroutineScope, obj3, isRtl, floatRef, floatRef2, maxScaleYDistance, 0);
                        composer5.updateRememberedValue((Function2)maxScaleXDistanceShrink);
                    } else {
                        it$iv2 = maxScaleYDistance;
                        it$iv = floatRef2;
                        maxScaleXDistanceShrink = obj;
                    }
                } else {
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                int i32 = 0;
                PredictiveBackHandlerKt.PredictiveBackHandler(obj3.isOpen(), (Function2)maxScaleXDistanceShrink, restartGroup, i32, i32);
                ComposerKt.sourceInformationMarkerStart(restartGroup, 228463923, str5);
                compositionCoroutineScope = i38 & 14 == 4 ? 1 : 0;
                Composer composer4 = restartGroup;
                i6 = 0;
                rememberedValue = composer4.rememberedValue();
                i3 = 0;
                if (compositionCoroutineScope == 0) {
                    scope = $i$f$rememberCoroutineScope;
                    if (rememberedValue == Composer.Companion.getEmpty()) {
                        companion = scope2;
                        i4 = isRtl;
                        $i$a$CacheNavigationDrawer_androidKt$DrawerPredictiveBackHandler$3 = new NavigationDrawer_androidKt.DrawerPredictiveBackHandler.3.1(obj3, $dirty, 0);
                        composer4.updateRememberedValue((Function2)$i$a$CacheNavigationDrawer_androidKt$DrawerPredictiveBackHandler$3);
                    } else {
                        i4 = isRtl;
                        $i$a$CacheNavigationDrawer_androidKt$DrawerPredictiveBackHandler$3 = rememberedValue;
                    }
                } else {
                    scope = $i$f$rememberCoroutineScope;
                }
                ComposerKt.sourceInformationMarkerEnd(restartGroup);
                EffectsKt.LaunchedEffect(Boolean.valueOf(obj3.isClosed()), (Function2)$i$a$CacheNavigationDrawer_androidKt$DrawerPredictiveBackHandler$3, restartGroup, 0);
                obj5.invoke($dirty, restartGroup, Integer.valueOf(i12 |= 6));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                restartGroup.skipToGroupEnd();
            }
        } else {
        }
        ScopeUpdateScope endRestartGroup = restartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            $dirty = new NavigationDrawer_androidKt.DrawerPredictiveBackHandler.4(obj3, obj5, i35);
            endRestartGroup.updateScope((Function2)$dirty);
        }
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceGrow() {
        return NavigationDrawer_androidKt.PredictiveBackDrawerMaxScaleXDistanceGrow;
    }

    public static final float getPredictiveBackDrawerMaxScaleXDistanceShrink() {
        return NavigationDrawer_androidKt.PredictiveBackDrawerMaxScaleXDistanceShrink;
    }

    public static final float getPredictiveBackDrawerMaxScaleYDistance() {
        return NavigationDrawer_androidKt.PredictiveBackDrawerMaxScaleYDistance;
    }
}
