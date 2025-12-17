package androidx.camera.core.impl.o.a;

import com.google.common.util.concurrent.c;
import d.h.k.i;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
abstract class b<V>  implements c<V> {

    static class a extends androidx.camera.core.impl.o.a.b<V> {

        private final Throwable a;
        a(Throwable throwable) {
            super();
            this.a = throwable;
        }

        public V get() {
            ExecutionException executionException = new ExecutionException(this.a);
            throw executionException;
        }

        @Override // androidx.camera.core.impl.o.a.b
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(super.toString());
            stringBuilder.append("[status=FAILURE, cause=[");
            stringBuilder.append(this.a);
            stringBuilder.append("]]");
            return stringBuilder.toString();
        }
    }

    static final class b extends androidx.camera.core.impl.o.a.b<V> {

        static final androidx.camera.core.impl.o.a.b<Object> b;
        private final V a;
        static {
            b.b bVar = new b.b(0);
            b.b.b = bVar;
        }

        b(V v) {
            super();
            this.a = v;
        }

        public V get() {
            return this.a;
        }

        @Override // androidx.camera.core.impl.o.a.b
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(super.toString());
            stringBuilder.append("[status=SUCCESS, result=[");
            stringBuilder.append(this.a);
            stringBuilder.append("]]");
            return stringBuilder.toString();
        }
    }
    public static <V> c<V> a() {
        return b.b.b;
    }

    @Override // com.google.common.util.concurrent.c
    public boolean cancel(boolean z) {
        return 0;
    }

    public abstract V get();

    public V get(long l, TimeUnit timeUnit2) {
        i.c(obj3);
        return get();
    }

    @Override // com.google.common.util.concurrent.c
    public boolean isCancelled() {
        return 0;
    }

    @Override // com.google.common.util.concurrent.c
    public boolean isDone() {
        return 1;
    }
}
