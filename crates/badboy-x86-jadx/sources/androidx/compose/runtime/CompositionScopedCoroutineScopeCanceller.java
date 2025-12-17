package androidx.compose.runtime;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0016J\u0008\u0010\t\u001a\u00020\u0008H\u0016J\u0008\u0010\n\u001a\u00020\u0008H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000b", d2 = {"Landroidx/compose/runtime/CompositionScopedCoroutineScopeCanceller;", "Landroidx/compose/runtime/RememberObserver;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lkotlinx/coroutines/CoroutineScope;)V", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "onAbandoned", "", "onForgotten", "onRemembered", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CompositionScopedCoroutineScopeCanceller implements androidx.compose.runtime.RememberObserver {

    public static final int $stable = 8;
    private final CoroutineScope coroutineScope;
    static {
        final int i = 8;
    }

    public CompositionScopedCoroutineScopeCanceller(CoroutineScope coroutineScope) {
        super();
        this.coroutineScope = coroutineScope;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onAbandoned() {
        LeftCompositionCancellationException leftCompositionCancellationException = new LeftCompositionCancellationException();
        CoroutineScopeKt.cancel(this.coroutineScope, (CancellationException)leftCompositionCancellationException);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onForgotten() {
        LeftCompositionCancellationException leftCompositionCancellationException = new LeftCompositionCancellationException();
        CoroutineScopeKt.cancel(this.coroutineScope, (CancellationException)leftCompositionCancellationException);
    }

    @Override // androidx.compose.runtime.RememberObserver
    public void onRemembered() {
    }
}
