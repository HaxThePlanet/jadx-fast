package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.b0.g;
import kotlinx.coroutines.m0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0008\u001a\u00020\tH\u0016R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\n", d2 = {"Lkotlinx/coroutines/internal/ContextScope;", "Lkotlinx/coroutines/CoroutineScope;", "context", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlin/coroutines/CoroutineContext;)V", "coroutineContext", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f implements m0 {

    private final g a;
    public f(g g) {
        super();
        this.a = g;
    }

    @Override // kotlinx.coroutines.m0
    public g r() {
        return this.a;
    }

    @Override // kotlinx.coroutines.m0
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CoroutineScope(coroutineContext=");
        stringBuilder.append(r());
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
