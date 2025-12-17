package kotlinx.coroutines.internal;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\u00080\tj\u0002`\n2\u000e\u0010\u000c\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00080\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0005\u001a(\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u00080\u0007\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0008\u0012\u0006\u0012\u0004\u0018\u00010\u00080\tj\u0002`\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Lkotlinx/coroutines/internal/WeakMapCtorCache;", "Lkotlinx/coroutines/internal/CtorCache;", "()V", "cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "get", "key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class WeakMapCtorCache extends kotlinx.coroutines.internal.CtorCache {

    public static final kotlinx.coroutines.internal.WeakMapCtorCache INSTANCE;
    private static final ReentrantReadWriteLock cacheLock;
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionCtors;
    static {
        WeakMapCtorCache weakMapCtorCache = new WeakMapCtorCache();
        WeakMapCtorCache.INSTANCE = weakMapCtorCache;
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        WeakMapCtorCache.cacheLock = reentrantReadWriteLock;
        WeakHashMap weakHashMap = new WeakHashMap();
        WeakMapCtorCache.exceptionCtors = weakHashMap;
    }

    public Function1<Throwable, Throwable> get(Class<? extends Throwable> key) {
        int readHoldCount;
        int i;
        int i2;
        Throwable th;
        int i3;
        ReentrantReadWriteLock.ReadLock lock = WeakMapCtorCache.cacheLock.readLock();
        lock.lock();
        int i4 = 0;
        Object obj = WeakMapCtorCache.exceptionCtors.get(key);
        if ((Function1)obj != null) {
            int i5 = 0;
            lock.unlock();
            return (Function1)obj;
        }
        lock.unlock();
        ReentrantReadWriteLock cacheLock2 = WeakMapCtorCache.cacheLock;
        ReentrantReadWriteLock.ReadLock lock3 = cacheLock2.readLock();
        i2 = 0;
        if (cacheLock2.getWriteHoldCount() == 0) {
            readHoldCount = cacheLock2.getReadHoldCount();
        } else {
            readHoldCount = i2;
        }
        i3 = i2;
        while (i3 < readHoldCount) {
            lock3.unlock();
            i3++;
        }
        ReentrantReadWriteLock.WriteLock lock2 = cacheLock2.writeLock();
        lock2.lock();
        int i6 = 0;
        Object obj2 = WeakMapCtorCache.exceptionCtors.get(key);
        if ((Function1)obj2 != null) {
            int i7 = 0;
            try {
                while (i2 < readHoldCount) {
                    lock3.lock();
                    i2++;
                }
                lock3.lock();
                i2++;
                lock2.unlock();
                return (Function1)obj2;
                Function1 function1 = ExceptionsConstructorKt.access$createConstructor(key);
                final int i8 = 0;
                (Map)WeakMapCtorCache.exceptionCtors.put(key, function1);
                while (i2 < readHoldCount) {
                    lock3.lock();
                    i2++;
                }
                lock3.lock();
                i2++;
                lock2.unlock();
                return function1;
            } catch (Throwable th) {
            }
            if (i >= obj2) {
            } else {
                th2.lock();
                i++;
            }
            obj0.unlock();
            throw th;
        }
    }
}
