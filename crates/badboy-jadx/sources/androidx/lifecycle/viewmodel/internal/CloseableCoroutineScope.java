package androidx.lifecycle.viewmodel.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0000\u0008\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007B\u0011\u0008\u0016\u0012\u0006\u0010\u0008\u001a\u00020\u0003¢\u0006\u0004\u0008\u0006\u0010\tJ\u0008\u0010\u000c\u001a\u00020\rH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000e", d2 = {"Landroidx/lifecycle/viewmodel/internal/CloseableCoroutineScope;", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "Lkotlinx/coroutines/CoroutineScope;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "coroutineScope", "(Lkotlinx/coroutines/CoroutineScope;)V", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "close", "", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CloseableCoroutineScope implements java.lang.AutoCloseable, CoroutineScope {

    private final CoroutineContext coroutineContext;
    public CloseableCoroutineScope(CoroutineContext coroutineContext) {
        Intrinsics.checkNotNullParameter(coroutineContext, "coroutineContext");
        super();
        this.coroutineContext = coroutineContext;
    }

    public CloseableCoroutineScope(CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        super(coroutineScope.getCoroutineContext());
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        final int i = 0;
        JobKt.cancel$default(getCoroutineContext(), i, 1, i);
    }

    @Override // java.lang.AutoCloseable
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }
}
