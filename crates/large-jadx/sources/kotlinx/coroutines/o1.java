package kotlinx.coroutines;

import java.io.Closeable;
import kotlin.Metadata;
import kotlin.b0.b;
import kotlin.d0.d.g;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008&\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001\nB\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0008\u001a\u00020\tH&R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u000b", d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Ljava/io/Closeable;", "()V", "executor", "Ljava/util/concurrent/Executor;", "getExecutor", "()Ljava/util/concurrent/Executor;", "close", "", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class o1 extends kotlinx.coroutines.h0 implements Closeable {

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0004¨\u0006\u0005", d2 = {"Lkotlinx/coroutines/ExecutorCoroutineDispatcher$Key;", "Lkotlin/coroutines/AbstractCoroutineContextKey;", "Lkotlinx/coroutines/CoroutineDispatcher;", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends b<kotlinx.coroutines.h0, kotlinx.coroutines.o1> {
        private a() {
            super(h0.a, o1.a.a.a);
        }

        public a(g g) {
            super();
        }
    }
    static {
        o1.a aVar = new o1.a(0);
    }
}
