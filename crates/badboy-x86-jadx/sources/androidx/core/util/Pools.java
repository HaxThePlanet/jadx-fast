package androidx.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0006", d2 = {"Landroidx/core/util/Pools;", "", "()V", "Pool", "SimplePool", "SynchronizedPool", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Pools {

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008f\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u000f\u0010\u0003\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0008ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\tÀ\u0006\u0001", d2 = {"Landroidx/core/util/Pools$Pool;", "T", "", "acquire", "()Ljava/lang/Object;", "release", "", "instance", "(Ljava/lang/Object;)Z", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Pool {
        public abstract T acquire();

        public abstract boolean release(T t);
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0016\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\u0008\u0008\u0001\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\u000b\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u000cJ\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0008X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Landroidx/core/util/Pools$SimplePool;", "T", "", "Landroidx/core/util/Pools$Pool;", "maxPoolSize", "", "(I)V", "pool", "", "[Ljava/lang/Object;", "poolSize", "acquire", "()Ljava/lang/Object;", "isInPool", "", "instance", "(Ljava/lang/Object;)Z", "release", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class SimplePool implements androidx.core.util.Pools.Pool<T> {

        private final Object[] pool;
        private int poolSize;
        public SimplePool(int maxPoolSize) {
            int i;
            super();
            i = maxPoolSize > 0 ? 1 : 0;
            if (i == 0) {
            } else {
                this.pool = new Object[maxPoolSize];
            }
            int i2 = 0;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("The max pool size must be > 0".toString());
            throw illegalArgumentException;
        }

        private final boolean isInPool(T instance) {
            int i;
            Object obj;
            i = 0;
            while (i < this.poolSize) {
                i++;
            }
            return 0;
        }

        public T acquire() {
            int i2 = 0;
            if (this.poolSize > 0) {
                poolSize2--;
                Object obj = this.pool[i];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
                this.pool[i] = i2;
                this.poolSize = poolSize3--;
                return obj;
            }
            return i2;
        }

        public boolean release(T instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            if (isInPool(instance)) {
            } else {
                if (this.poolSize < pool2.length) {
                    this.pool[this.poolSize] = instance;
                    int i4 = 1;
                    this.poolSize = poolSize2 += i4;
                    return i4;
                }
                return 0;
            }
            int i3 = 0;
            IllegalStateException illegalStateException = new IllegalStateException("Already in the pool!".toString());
            throw illegalStateException;
        }
    }

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008\u0016\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000f\u0010\u0008\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\tJ\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\rR\u000e\u0010\u0007\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Landroidx/core/util/Pools$SynchronizedPool;", "T", "", "Landroidx/core/util/Pools$SimplePool;", "maxPoolSize", "", "(I)V", "lock", "acquire", "()Ljava/lang/Object;", "release", "", "instance", "(Ljava/lang/Object;)Z", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class SynchronizedPool extends androidx.core.util.Pools.SimplePool<T> {

        private final Object lock;
        public SynchronizedPool(int maxPoolSize) {
            super(maxPoolSize);
            Object object = new Object();
            this.lock = object;
        }

        public T acquire() {
            final Object lock = this.lock;
            final int i = 0;
            return super.acquire();
            synchronized (lock) {
                lock = this.lock;
                i = 0;
                return super.acquire();
            }
        }

        public boolean release(T instance) {
            Intrinsics.checkNotNullParameter(instance, "instance");
            Object lock = this.lock;
            final int i = 0;
            return super.release(instance);
            synchronized (lock) {
                Intrinsics.checkNotNullParameter(instance, "instance");
                lock = this.lock;
                i = 0;
                return super.release(instance);
            }
        }
    }
}
