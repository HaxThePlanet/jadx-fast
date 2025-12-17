package androidx.compose.material.pullrefresh;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref.FloatRef;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a<\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u0008\u0008\u0002\u0010\t\u001a\u00020\n2\u0008\u0008\u0002\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u000e", d2 = {"DragMultiplier", "", "rememberPullRefreshState", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "refreshing", "", "onRefresh", "Lkotlin/Function0;", "", "refreshThreshold", "Landroidx/compose/ui/unit/Dp;", "refreshingOffset", "rememberPullRefreshState-UuyPYSY", "(ZLkotlin/jvm/functions/Function0;FFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/pullrefresh/PullRefreshState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PullRefreshStateKt {

    private static final float DragMultiplier = 0.5f;
    public static final androidx.compose.material.pullrefresh.PullRefreshState rememberPullRefreshState-UuyPYSY(boolean refreshing, Function0<Unit> onRefresh, float refreshThreshold, float refreshingOffset, Composer $composer, int $changed, int i7) {
        Object $i$a$CachePullRefreshStateKt$rememberPullRefreshState$state$1;
        int empty2;
        int i2;
        float refreshThreshold2;
        float refreshingOffset2;
        int changed;
        int i;
        boolean traceInProgress;
        int compositionCoroutineScope;
        String str;
        Object compositionScopedCoroutineScopeCanceller;
        Object empty3;
        Object anon;
        Object empty;
        EmptyCoroutineContext $i$a$RememberCoroutineScopeEffectsKt$rememberCoroutineScope$1;
        float f;
        float f2;
        int obj24;
        final boolean z = refreshing;
        final Composer composer = $composer;
        empty2 = $changed;
        int i4 = -174977512;
        ComposerKt.sourceInformationMarkerStart(composer, i4, "C(rememberPullRefreshState)P(2!1,1:c#ui.unit.Dp,3:c#ui.unit.Dp)65@2636L24,66@2686L31,*70@2802L7,75@2935L104,79@3056L141,79@3045L152:PullRefreshState.kt#t44y28");
        if (i7 & 4 != 0) {
            refreshThreshold2 = PullRefreshDefaults.INSTANCE.getRefreshThreshold-D9Ej5fM();
        } else {
            refreshThreshold2 = refreshThreshold;
        }
        if (i7 & 8 != 0) {
            refreshingOffset2 = PullRefreshDefaults.INSTANCE.getRefreshingOffset-D9Ej5fM();
        } else {
            refreshingOffset2 = refreshingOffset;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i4, empty2, -1, "androidx.compose.material.pullrefresh.rememberPullRefreshState (PullRefreshState.kt:62)");
        }
        compositionCoroutineScope = 0;
        int i18 = 0;
        i2 = Dp.compareTo-0680j_4(refreshThreshold2, Dp.constructor-impl((float)i5)) > 0 ? 1 : i18;
        if (i2 == 0) {
        } else {
            int i6 = i18;
            int i19 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composer, -954363344, "CC(remember):Effects.kt#9igjgp");
            int i22 = 0;
            Composer composer4 = $composer;
            int i28 = 0;
            Object rememberedValue2 = composer4.rememberedValue();
            int i32 = 0;
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                empty = 0;
                int i34 = 0;
                compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope((CoroutineContext)EmptyCoroutineContext.INSTANCE, $composer));
                composer4.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            } else {
                compositionScopedCoroutineScopeCanceller = rememberedValue2;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            kotlinx.coroutines.CoroutineScope coroutineScope = (CompositionScopedCoroutineScopeCanceller)compositionScopedCoroutineScopeCanceller.getCoroutineScope();
            ComposerKt.sourceInformationMarkerEnd(composer);
            Ref.FloatRef floatRef = new Ref.FloatRef();
            Ref.FloatRef floatRef2 = new Ref.FloatRef();
            int i26 = 0;
            int i29 = 0;
            ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            ComposerKt.sourceInformationMarkerEnd(composer);
            Object this_$iv = consume;
            int i27 = 0;
            floatRef.element = (Density)this_$iv.toPx-0680j_4(refreshThreshold2);
            floatRef2.element = this_$iv.toPx-0680j_4(refreshingOffset2);
            String str6 = "CC(remember):PullRefreshState.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composer, 975868558, str6);
            Composer composer5 = $composer;
            empty3 = 0;
            Object rememberedValue3 = composer5.rememberedValue();
            int i33 = 0;
            if (!composer.changed(coroutineScope)) {
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    obj24 = i3;
                    f = refreshThreshold2;
                    f2 = refreshingOffset2;
                    $i$a$CachePullRefreshStateKt$rememberPullRefreshState$state$1 = new PullRefreshState(coroutineScope, SnapshotStateKt.rememberUpdatedState(onRefresh, composer, i8 &= 14), floatRef2.element, floatRef.element);
                    composer5.updateRememberedValue($i$a$CachePullRefreshStateKt$rememberPullRefreshState$state$1);
                } else {
                    f = refreshThreshold2;
                    f2 = refreshingOffset2;
                    $i$a$CachePullRefreshStateKt$rememberPullRefreshState$state$1 = rememberedValue3;
                }
            } else {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, 975872467, str6);
            int i24 = 4;
            if (i17 ^= 6 > i24) {
                if (!composer.changed(z)) {
                    i = $changed & 6 == i24 ? 1 : 0;
                } else {
                }
            } else {
            }
            Composer composer2 = $composer;
            int i25 = 0;
            Object rememberedValue = composer2.rememberedValue();
            int i30 = 0;
            if (i13 |= changed3 == 0) {
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    empty3 = 0;
                    anon = new PullRefreshStateKt.rememberPullRefreshState.3.1($i$a$CachePullRefreshStateKt$rememberPullRefreshState$state$1, z, floatRef, floatRef2);
                    composer2.updateRememberedValue((Function0)anon);
                } else {
                    anon = rememberedValue;
                }
            } else {
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.SideEffect((Function0)anon, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            return $i$a$CachePullRefreshStateKt$rememberPullRefreshState$state$1;
        }
        int state = 0;
        IllegalArgumentException $i$a$RequirePullRefreshStateKt$rememberPullRefreshState$1 = new IllegalArgumentException("The refresh trigger must be greater than zero!".toString());
        throw $i$a$RequirePullRefreshStateKt$rememberPullRefreshState$1;
    }
}
