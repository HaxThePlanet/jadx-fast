package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\u00082\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00010\nH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u000b", d2 = {"Lkotlinx/coroutines/internal/MissingMainCoroutineDispatcherFactory;", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "()V", "loadPriority", "", "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "allFactories", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MissingMainCoroutineDispatcherFactory implements kotlinx.coroutines.internal.MainDispatcherFactory {

    public static final kotlinx.coroutines.internal.MissingMainCoroutineDispatcherFactory INSTANCE;
    static {
        MissingMainCoroutineDispatcherFactory missingMainCoroutineDispatcherFactory = new MissingMainCoroutineDispatcherFactory();
        MissingMainCoroutineDispatcherFactory.INSTANCE = missingMainCoroutineDispatcherFactory;
    }

    public MainCoroutineDispatcher createDispatcher(List<? extends kotlinx.coroutines.internal.MainDispatcherFactory> allFactories) {
        final int i = 0;
        MissingMainCoroutineDispatcher missingMainCoroutineDispatcher = new MissingMainCoroutineDispatcher(i, i, 2, i);
        return (MainCoroutineDispatcher)missingMainCoroutineDispatcher;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public int getLoadPriority() {
        return -1;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public String hintOnError() {
        return MainDispatcherFactory.DefaultImpls.hintOnError(this);
    }
}
