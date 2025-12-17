package kotlin.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a6\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a6\u0010\u0006\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00072\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0008\u001a6\u0010\t\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001*\u00020\u00022\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u0002H\u00010\u0004H\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\n", d2 = {"read", "T", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "action", "Lkotlin/Function0;", "(Ljava/util/concurrent/locks/ReentrantReadWriteLock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "withLock", "Ljava/util/concurrent/locks/Lock;", "(Ljava/util/concurrent/locks/Lock;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "write", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class LocksKt {
    private static final <T> T read(ReentrantReadWriteLock $this$read, Function0<? extends T> action) {
        Intrinsics.checkNotNullParameter($this$read, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        ReentrantReadWriteLock.ReadLock lock = $this$read.readLock();
        lock.lock();
        lock.unlock();
        return action.invoke();
    }

    private static final <T> T withLock(Lock $this$withLock, Function0<? extends T> action) {
        Intrinsics.checkNotNullParameter($this$withLock, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        $this$withLock.lock();
        $this$withLock.unlock();
        return action.invoke();
    }

    private static final <T> T write(ReentrantReadWriteLock $this$write, Function0<? extends T> action) {
        int readHoldCount;
        int i3;
        int i5;
        int i2;
        Throwable th;
        int i;
        int i4;
        Intrinsics.checkNotNullParameter($this$write, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        ReentrantReadWriteLock.ReadLock lock = $this$write.readLock();
        i5 = 0;
        if ($this$write.getWriteHoldCount() == 0) {
            readHoldCount = $this$write.getReadHoldCount();
        } else {
            readHoldCount = i5;
        }
        i2 = i5;
        while (i2 < readHoldCount) {
            th = i2;
            i = 0;
            lock.unlock();
            i2++;
        }
        ReentrantReadWriteLock.WriteLock lock2 = $this$write.writeLock();
        lock2.lock();
        while (i5 < readHoldCount) {
            i = i5;
            i4 = 0;
            lock.lock();
            i5++;
        }
        lock2.unlock();
        return action.invoke();
    }
}
