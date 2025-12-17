package androidx.compose.foundation.lazy;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer.Companion;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a4\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u0006¢\u0006\u0002\u0008\tH\u0001¢\u0006\u0002\u0010\n¨\u0006\u000b", d2 = {"rememberLazyListItemProviderLambda", "Lkotlin/Function0;", "Landroidx/compose/foundation/lazy/LazyListItemProvider;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/LazyListScope;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)Lkotlin/jvm/functions/Function0;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LazyListItemProviderKt {
    public static final Function0<androidx.compose.foundation.lazy.LazyListItemProvider> rememberLazyListItemProviderLambda(androidx.compose.foundation.lazy.LazyListState state, Function1<? super androidx.compose.foundation.lazy.LazyListScope, Unit> content, Composer $composer, int $changed) {
        boolean traceInProgress;
        int changed;
        int i;
        String str;
        Object empty;
        androidx.compose.foundation.lazy.LazyItemScopeImpl lazyItemScopeImpl;
        androidx.compose.runtime.State derivedStateOf2;
        androidx.compose.runtime.State derivedStateOf;
        Object anon;
        int i2 = -343736148;
        ComposerKt.sourceInformationMarkerStart($composer, i2, "C(rememberLazyListItemProviderLambda)P(1)44@1787L29,45@1828L679:LazyListItemProvider.kt#428nma");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i2, $changed, -1, "androidx.compose.foundation.lazy.rememberLazyListItemProviderLambda (LazyListItemProvider.kt:43)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 464137073, "CC(remember):LazyListItemProvider.kt#9igjgp");
        int i7 = 4;
        if (i6 ^= 6 > i7) {
            if (!$composer.changed(state)) {
                i = $changed & 6 == i7 ? 1 : 0;
            } else {
            }
        } else {
        }
        Composer composer = $composer;
        final int i8 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i9 = 0;
        if (i == 0) {
            if (rememberedValue == Composer.Companion.getEmpty()) {
                empty = 0;
                lazyItemScopeImpl = new LazyItemScopeImpl();
                LazyListItemProviderKt.rememberLazyListItemProviderLambda.1.intervalContentState.1 anon2 = new LazyListItemProviderKt.rememberLazyListItemProviderLambda.1.intervalContentState.1(SnapshotStateKt.rememberUpdatedState(content, $composer, i3 &= 14));
                LazyListItemProviderKt.rememberLazyListItemProviderLambda.1.itemProviderState.1 anon3 = new LazyListItemProviderKt.rememberLazyListItemProviderLambda.1.itemProviderState.1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), (Function0)anon2), state, lazyItemScopeImpl);
                anon = new LazyListItemProviderKt.rememberLazyListItemProviderLambda.1.1(SnapshotStateKt.derivedStateOf(SnapshotStateKt.referentialEqualityPolicy(), (Function0)anon3));
                composer.updateRememberedValue((KProperty0)anon);
            } else {
                anon = rememberedValue;
            }
        } else {
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (Function0)(KProperty0)anon;
    }
}
