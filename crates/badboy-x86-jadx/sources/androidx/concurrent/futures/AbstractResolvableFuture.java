package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class AbstractResolvableFuture<V>  implements ListenableFuture<V> {

    static final androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper ATOMIC_HELPER = null;
    static final boolean GENERATE_CANCELLATION_CAUSES = false;
    private static final Object NULL = null;
    private static final long SPIN_THRESHOLD_NANOS = 1000L;
    private static final Logger log;
    volatile androidx.concurrent.futures.AbstractResolvableFuture.Listener listeners;
    volatile Object value;
    volatile androidx.concurrent.futures.AbstractResolvableFuture.Waiter waiters;

    private static abstract class AtomicHelper {
        AtomicHelper(androidx.concurrent.futures.AbstractResolvableFuture.1 x0) {
            super();
        }

        abstract boolean casListeners(androidx.concurrent.futures.AbstractResolvableFuture<?> abstractResolvableFuture, androidx.concurrent.futures.AbstractResolvableFuture.Listener abstractResolvableFuture$Listener2, androidx.concurrent.futures.AbstractResolvableFuture.Listener abstractResolvableFuture$Listener3);

        abstract boolean casValue(androidx.concurrent.futures.AbstractResolvableFuture<?> abstractResolvableFuture, Object object2, Object object3);

        abstract boolean casWaiters(androidx.concurrent.futures.AbstractResolvableFuture<?> abstractResolvableFuture, androidx.concurrent.futures.AbstractResolvableFuture.Waiter abstractResolvableFuture$Waiter2, androidx.concurrent.futures.AbstractResolvableFuture.Waiter abstractResolvableFuture$Waiter3);

        abstract void putNext(androidx.concurrent.futures.AbstractResolvableFuture.Waiter abstractResolvableFuture$Waiter, androidx.concurrent.futures.AbstractResolvableFuture.Waiter abstractResolvableFuture$Waiter2);

        abstract void putThread(androidx.concurrent.futures.AbstractResolvableFuture.Waiter abstractResolvableFuture$Waiter, Thread thread2);
    }

    private static final class Cancellation {

        static final androidx.concurrent.futures.AbstractResolvableFuture.Cancellation CAUSELESS_CANCELLED = null;
        static final androidx.concurrent.futures.AbstractResolvableFuture.Cancellation CAUSELESS_INTERRUPTED = null;
        final Throwable cause;
        final boolean wasInterrupted;
        static {
            boolean gENERATE_CANCELLATION_CAUSES;
            int i;
            final int i2 = 0;
            if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES) {
            } else {
                AbstractResolvableFuture.Cancellation cancellation = new AbstractResolvableFuture.Cancellation(0, i2);
                AbstractResolvableFuture.Cancellation.CAUSELESS_CANCELLED = cancellation;
                gENERATE_CANCELLATION_CAUSES = new AbstractResolvableFuture.Cancellation(1, i2);
                AbstractResolvableFuture.Cancellation.CAUSELESS_INTERRUPTED = gENERATE_CANCELLATION_CAUSES;
            }
        }

        Cancellation(boolean wasInterrupted, Throwable cause) {
            super();
            this.wasInterrupted = wasInterrupted;
            this.cause = cause;
        }
    }

    private static final class Failure {

        static final androidx.concurrent.futures.AbstractResolvableFuture.Failure FALLBACK_INSTANCE;
        final Throwable exception;
        static {
            AbstractResolvableFuture.Failure.1 anon = new AbstractResolvableFuture.Failure.1("Failure occurred while trying to finish a future.");
            AbstractResolvableFuture.Failure failure = new AbstractResolvableFuture.Failure(anon);
            AbstractResolvableFuture.Failure.FALLBACK_INSTANCE = failure;
        }

        Failure(Throwable exception) {
            super();
            this.exception = (Throwable)AbstractResolvableFuture.checkNotNull(exception);
        }
    }

    private static final class Listener {

        static final androidx.concurrent.futures.AbstractResolvableFuture.Listener TOMBSTONE;
        final Executor executor;
        androidx.concurrent.futures.AbstractResolvableFuture.Listener next;
        final Runnable task;
        static {
            final int i = 0;
            AbstractResolvableFuture.Listener listener = new AbstractResolvableFuture.Listener(i, i);
            AbstractResolvableFuture.Listener.TOMBSTONE = listener;
        }

        Listener(Runnable task, Executor executor) {
            super();
            this.task = task;
            this.executor = executor;
        }
    }

    private static final class SafeAtomicHelper extends androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper {

        final AtomicReferenceFieldUpdater<androidx.concurrent.futures.AbstractResolvableFuture, androidx.concurrent.futures.AbstractResolvableFuture.Listener> listenersUpdater;
        final AtomicReferenceFieldUpdater<androidx.concurrent.futures.AbstractResolvableFuture, Object> valueUpdater;
        final AtomicReferenceFieldUpdater<androidx.concurrent.futures.AbstractResolvableFuture.Waiter, androidx.concurrent.futures.AbstractResolvableFuture.Waiter> waiterNextUpdater;
        final AtomicReferenceFieldUpdater<androidx.concurrent.futures.AbstractResolvableFuture.Waiter, Thread> waiterThreadUpdater;
        final AtomicReferenceFieldUpdater<androidx.concurrent.futures.AbstractResolvableFuture, androidx.concurrent.futures.AbstractResolvableFuture.Waiter> waitersUpdater;
        SafeAtomicHelper(AtomicReferenceFieldUpdater<androidx.concurrent.futures.AbstractResolvableFuture.Waiter, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<androidx.concurrent.futures.AbstractResolvableFuture.Waiter, androidx.concurrent.futures.AbstractResolvableFuture.Waiter> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<androidx.concurrent.futures.AbstractResolvableFuture, androidx.concurrent.futures.AbstractResolvableFuture.Waiter> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<androidx.concurrent.futures.AbstractResolvableFuture, androidx.concurrent.futures.AbstractResolvableFuture.Listener> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<androidx.concurrent.futures.AbstractResolvableFuture, Object> atomicReferenceFieldUpdater5) {
            super(0);
            this.waiterThreadUpdater = atomicReferenceFieldUpdater;
            this.waiterNextUpdater = atomicReferenceFieldUpdater2;
            this.waitersUpdater = atomicReferenceFieldUpdater3;
            this.listenersUpdater = atomicReferenceFieldUpdater4;
            this.valueUpdater = atomicReferenceFieldUpdater5;
        }

        boolean casListeners(androidx.concurrent.futures.AbstractResolvableFuture<?> abstractResolvableFuture, androidx.concurrent.futures.AbstractResolvableFuture.Listener expect, androidx.concurrent.futures.AbstractResolvableFuture.Listener update) {
            return AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(this.listenersUpdater, abstractResolvableFuture, expect, update);
        }

        boolean casValue(androidx.concurrent.futures.AbstractResolvableFuture<?> abstractResolvableFuture, Object expect, Object update) {
            return AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(this.valueUpdater, abstractResolvableFuture, expect, update);
        }

        boolean casWaiters(androidx.concurrent.futures.AbstractResolvableFuture<?> abstractResolvableFuture, androidx.concurrent.futures.AbstractResolvableFuture.Waiter expect, androidx.concurrent.futures.AbstractResolvableFuture.Waiter update) {
            return AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(this.waitersUpdater, abstractResolvableFuture, expect, update);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
        void putNext(androidx.concurrent.futures.AbstractResolvableFuture.Waiter waiter, androidx.concurrent.futures.AbstractResolvableFuture.Waiter newValue) {
            this.waiterNextUpdater.lazySet(waiter, newValue);
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
        void putThread(androidx.concurrent.futures.AbstractResolvableFuture.Waiter waiter, Thread newValue) {
            this.waiterThreadUpdater.lazySet(waiter, newValue);
        }
    }

    private static final class SetFuture implements Runnable {

        final ListenableFuture<? extends V> future;
        final androidx.concurrent.futures.AbstractResolvableFuture<V> owner;
        SetFuture(androidx.concurrent.futures.AbstractResolvableFuture<V> abstractResolvableFuture, ListenableFuture<? extends V> listenableFuture2) {
            super();
            this.owner = abstractResolvableFuture;
            this.future = listenableFuture2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean casValue;
            if (owner.value != this) {
            }
            if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(this.owner, this, AbstractResolvableFuture.getFutureValue(this.future))) {
                AbstractResolvableFuture.complete(this.owner);
            }
        }
    }

    private static final class SynchronizedHelper extends androidx.concurrent.futures.AbstractResolvableFuture.AtomicHelper {
        SynchronizedHelper() {
            super(0);
        }

        boolean casListeners(androidx.concurrent.futures.AbstractResolvableFuture<?> abstractResolvableFuture, androidx.concurrent.futures.AbstractResolvableFuture.Listener expect, androidx.concurrent.futures.AbstractResolvableFuture.Listener update) {
            synchronized (abstractResolvableFuture) {
                try {
                    abstractResolvableFuture.listeners = update;
                    return 1;
                    return 0;
                    throw th;
                }
            }
        }

        boolean casValue(androidx.concurrent.futures.AbstractResolvableFuture<?> abstractResolvableFuture, Object expect, Object update) {
            synchronized (abstractResolvableFuture) {
                try {
                    abstractResolvableFuture.value = update;
                    return 1;
                    return 0;
                    throw th;
                }
            }
        }

        boolean casWaiters(androidx.concurrent.futures.AbstractResolvableFuture<?> abstractResolvableFuture, androidx.concurrent.futures.AbstractResolvableFuture.Waiter expect, androidx.concurrent.futures.AbstractResolvableFuture.Waiter update) {
            synchronized (abstractResolvableFuture) {
                try {
                    abstractResolvableFuture.waiters = update;
                    return 1;
                    return 0;
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
        void putNext(androidx.concurrent.futures.AbstractResolvableFuture.Waiter waiter, androidx.concurrent.futures.AbstractResolvableFuture.Waiter newValue) {
            waiter.next = newValue;
        }

        @Override // androidx.concurrent.futures.AbstractResolvableFuture$AtomicHelper
        void putThread(androidx.concurrent.futures.AbstractResolvableFuture.Waiter waiter, Thread newValue) {
            waiter.thread = newValue;
        }
    }

    private static final class Waiter {

        static final androidx.concurrent.futures.AbstractResolvableFuture.Waiter TOMBSTONE;
        volatile androidx.concurrent.futures.AbstractResolvableFuture.Waiter next;
        volatile Thread thread;
        static {
            AbstractResolvableFuture.Waiter waiter = new AbstractResolvableFuture.Waiter(0);
            AbstractResolvableFuture.Waiter.TOMBSTONE = waiter;
        }

        Waiter() {
            super();
            AbstractResolvableFuture.ATOMIC_HELPER.putThread(this, Thread.currentThread());
        }

        Waiter(boolean unused) {
            super();
        }

        void setNext(androidx.concurrent.futures.AbstractResolvableFuture.Waiter next) {
            AbstractResolvableFuture.ATOMIC_HELPER.putNext(this, next);
        }

        void unpark() {
            int i;
            final Thread thread = this.thread;
            if (thread != null) {
                this.thread = 0;
                LockSupport.unpark(thread);
            }
        }
    }
    static {
        Class<androidx.concurrent.futures.AbstractResolvableFuture> obj;
        int i;
        androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper safeAtomicHelper;
        Object updater2;
        Object sEVERE;
        Object updater;
        AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
        obj = AbstractResolvableFuture.class;
        AbstractResolvableFuture.log = Logger.getLogger(obj.getName());
        i = 0;
        safeAtomicHelper = new AbstractResolvableFuture.SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.Waiter.class, Thread.class, "thread"), AtomicReferenceFieldUpdater.newUpdater(AbstractResolvableFuture.Waiter.class, AbstractResolvableFuture.Waiter.class, "next"), AtomicReferenceFieldUpdater.newUpdater(obj, AbstractResolvableFuture.Waiter.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(obj, AbstractResolvableFuture.Listener.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(obj, Object.class, "value"));
        AbstractResolvableFuture.ATOMIC_HELPER = safeAtomicHelper;
        Class<LockSupport> obj2 = LockSupport.class;
        if (i != 0) {
            AbstractResolvableFuture.log.log(Level.SEVERE, "SafeAtomicHelper is broken!", i);
        }
        Object ensureLoaded = new Object();
        AbstractResolvableFuture.NULL = ensureLoaded;
    }

    private void addDoneString(StringBuilder builder) {
        String str;
        String str2;
        Object uninterruptibly;
        Class append;
        StringBuilder append2;
        Throwable cause;
        String userObjectToString;
        builder.append("SUCCESS, result=[").append(userObjectToString(AbstractResolvableFuture.getUninterruptibly(this))).append("]");
    }

    private static CancellationException cancellationExceptionWithCause(String message, Throwable cause) {
        CancellationException cancellationException = new CancellationException(message);
        cancellationException.initCause(cause);
        return cancellationException;
    }

    static <T> T checkNotNull(T t) {
        if (t == 0) {
        } else {
            return t;
        }
        NullPointerException nullPointerException = new NullPointerException();
        throw nullPointerException;
    }

    private androidx.concurrent.futures.AbstractResolvableFuture.Listener clearListeners(androidx.concurrent.futures.AbstractResolvableFuture.Listener onto) {
        androidx.concurrent.futures.AbstractResolvableFuture.Listener head;
        boolean casListeners;
        androidx.concurrent.futures.AbstractResolvableFuture.Listener reversedList;
        androidx.concurrent.futures.AbstractResolvableFuture.Listener tOMBSTONE;
        while (AbstractResolvableFuture.ATOMIC_HELPER.casListeners(this, this.listeners, AbstractResolvableFuture.Listener.TOMBSTONE)) {
        }
        reversedList = onto;
        while (head != null) {
            tOMBSTONE = head;
            head = head.next;
            tOMBSTONE.next = reversedList;
            reversedList = tOMBSTONE;
        }
        return reversedList;
    }

    static void complete(androidx.concurrent.futures.AbstractResolvableFuture<?> abstractResolvableFuture) {
        int next;
        androidx.concurrent.futures.AbstractResolvableFuture.Listener list;
        Runnable task;
        Runnable executor;
        Object futureValue;
        boolean casValue;
        androidx.concurrent.futures.AbstractResolvableFuture obj6;
        next = 0;
        while (/* condition */) {
            while (next != null) {
                list = next;
                next = next.next;
                task = list.task;
                if (task instanceof AbstractResolvableFuture.SetFuture) {
                    break loop_2;
                } else {
                }
                AbstractResolvableFuture.executeListener(task, list.executor);
                executor = task;
                obj6 = executor.owner;
                if (obj6.value == (AbstractResolvableFuture.SetFuture)executor) {
                    break loop_2;
                } else {
                }
                if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(obj6, (AbstractResolvableFuture.SetFuture)executor, AbstractResolvableFuture.getFutureValue(executor.future))) {
                    break loop_2;
                } else {
                }
            }
            list = next;
            next = next.next;
            task = list.task;
            if (task instanceof AbstractResolvableFuture.SetFuture) {
            } else {
            }
            AbstractResolvableFuture.executeListener(task, list.executor);
            executor = task;
            obj6 = executor.owner;
            if (obj6.value == (AbstractResolvableFuture.SetFuture)executor) {
            } else {
            }
            if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(obj6, (AbstractResolvableFuture.SetFuture)executor, AbstractResolvableFuture.getFutureValue(executor.future))) {
            } else {
            }
            obj6.releaseWaiters();
            obj6.afterDone();
            next = obj6.clearListeners(next);
            obj6 = 0;
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        Throwable th;
        Logger log;
        Level sEVERE;
        StringBuilder string;
        String str;
        try {
            executor.execute(runnable);
            string = new StringBuilder();
            str = "RuntimeException while executing runnable ";
            string = string.append(str);
            string = string.append(runnable);
            str = " with executor ";
            string = string.append(str);
            string = string.append(executor);
            string = string.toString();
            AbstractResolvableFuture.log.log(Level.SEVERE, string, th);
        }
    }

    private V getDoneValue(Object obj) throws ExecutionException {
        if (obj instanceof AbstractResolvableFuture.Cancellation) {
        } else {
            if (obj instanceof AbstractResolvableFuture.Failure) {
            } else {
                if (obj == AbstractResolvableFuture.NULL) {
                    return 0;
                }
                return obj;
            }
            ExecutionException asV = new ExecutionException(obj4.exception);
            throw asV;
        }
        throw AbstractResolvableFuture.cancellationExceptionWithCause("Task was cancelled.", obj3.cause);
    }

    static Object getFutureValue(ListenableFuture<?> listenableFuture) {
        Object v;
        Object nULL;
        boolean z;
        boolean cAUSELESS_CANCELLED;
        Object string;
        v = obj.value;
        z = v;
        if (listenableFuture instanceof AbstractResolvableFuture && v instanceof AbstractResolvableFuture.Cancellation && z.wasInterrupted) {
            v = obj.value;
            if (v instanceof AbstractResolvableFuture.Cancellation) {
                z = v;
                if (z.wasInterrupted) {
                    if (z.cause != null) {
                        cAUSELESS_CANCELLED = new AbstractResolvableFuture.Cancellation(0, z.cause);
                    } else {
                        cAUSELESS_CANCELLED = AbstractResolvableFuture.Cancellation.CAUSELESS_CANCELLED;
                    }
                    v = cAUSELESS_CANCELLED;
                }
            }
            return v;
        }
        if (i2 &= cancelled != 0) {
            return AbstractResolvableFuture.Cancellation.CAUSELESS_CANCELLED;
        }
        Object uninterruptibly = AbstractResolvableFuture.getUninterruptibly(listenableFuture);
        nULL = uninterruptibly == null ? AbstractResolvableFuture.NULL : uninterruptibly;
        return nULL;
    }

    static <V> V getUninterruptibly(Future<V> future) throws ExecutionException {
        int i;
        Throwable th;
        Thread currentThread;
        i = 0;
        try {
            if (i != 0) {
            }
            Thread.currentThread().interrupt();
            return future.get();
        }
        Thread.currentThread().interrupt();
        throw th;
    }

    private void releaseWaiters() {
        androidx.concurrent.futures.AbstractResolvableFuture.Waiter waiters;
        boolean casWaiters;
        androidx.concurrent.futures.AbstractResolvableFuture.Waiter currentWaiter;
        androidx.concurrent.futures.AbstractResolvableFuture.Waiter tOMBSTONE;
        waiters = this.waiters;
        while (AbstractResolvableFuture.ATOMIC_HELPER.casWaiters(this, waiters, AbstractResolvableFuture.Waiter.TOMBSTONE)) {
            waiters = this.waiters;
        }
        currentWaiter = waiters;
        while (currentWaiter != null) {
            currentWaiter.unpark();
            currentWaiter = currentWaiter.next;
        }
    }

    private void removeWaiter(androidx.concurrent.futures.AbstractResolvableFuture.Waiter node) {
        int pred;
        androidx.concurrent.futures.AbstractResolvableFuture.Waiter curr;
        androidx.concurrent.futures.AbstractResolvableFuture.Waiter tOMBSTONE;
        Thread casWaiters;
        node.thread = 0;
        pred = 0;
        while (this.waiters == AbstractResolvableFuture.Waiter.TOMBSTONE) {
            while (curr != null) {
                tOMBSTONE = curr.next;
                curr = tOMBSTONE;
                pred.next = tOMBSTONE;
                pred = curr;
            }
            tOMBSTONE = curr.next;
            curr = tOMBSTONE;
            pred = 0;
            pred.next = tOMBSTONE;
            pred = curr;
        }
    }

    private String userObjectToString(Object o) {
        if (o == this) {
            return "this future";
        }
        return String.valueOf(o);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final void addListener(Runnable listener, Executor executor) {
        androidx.concurrent.futures.AbstractResolvableFuture.Listener oldHead;
        androidx.concurrent.futures.AbstractResolvableFuture.Listener tOMBSTONE;
        androidx.concurrent.futures.AbstractResolvableFuture.Listener tOMBSTONE2;
        AbstractResolvableFuture.checkNotNull(listener);
        AbstractResolvableFuture.checkNotNull(executor);
        if (this.listeners != AbstractResolvableFuture.Listener.TOMBSTONE) {
            tOMBSTONE = new AbstractResolvableFuture.Listener(listener, executor);
            tOMBSTONE.next = oldHead;
            while (AbstractResolvableFuture.ATOMIC_HELPER.casListeners(this, oldHead, tOMBSTONE)) {
                tOMBSTONE.next = oldHead;
            }
        }
        AbstractResolvableFuture.executeListener(listener, executor);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    protected void afterDone() {
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final boolean cancel(boolean mayInterruptIfRunning) {
        Object localValue;
        int rValue;
        int i3;
        int cAUSELESS_INTERRUPTED;
        boolean abstractFuture;
        boolean future;
        String str;
        int i;
        int i2;
        boolean z;
        localValue = this.value;
        rValue = 0;
        final int i4 = 1;
        final int i5 = 0;
        i3 = localValue == null ? i4 : i5;
        if (i3 |= abstractFuture != 0) {
            if (AbstractResolvableFuture.GENERATE_CANCELLATION_CAUSES) {
                abstractFuture = new CancellationException("Future.cancel() was called.");
                cAUSELESS_INTERRUPTED = new AbstractResolvableFuture.Cancellation(mayInterruptIfRunning, abstractFuture);
            } else {
                cAUSELESS_INTERRUPTED = mayInterruptIfRunning ? AbstractResolvableFuture.Cancellation.CAUSELESS_INTERRUPTED : AbstractResolvableFuture.Cancellation.CAUSELESS_CANCELLED;
            }
            abstractFuture = this;
            while (AbstractResolvableFuture.ATOMIC_HELPER.casValue(abstractFuture, localValue, cAUSELESS_INTERRUPTED)) {
                rValue = 1;
                if (mayInterruptIfRunning) {
                }
                AbstractResolvableFuture.complete(abstractFuture);
                if (localValue instanceof AbstractResolvableFuture.SetFuture) {
                    break;
                }
                future = obj.future;
                str = future;
                localValue = str.value;
                if (localValue == null) {
                } else {
                }
                i2 = i5;
                abstractFuture = str;
                i2 = i4;
                abstractFuture.interruptTask();
            }
        }
        return rValue;
    }

    public final V get() throws java.lang.InterruptedException, ExecutionException {
        Object localValue;
        int i3;
        androidx.concurrent.futures.AbstractResolvableFuture.Waiter oldHead;
        androidx.concurrent.futures.AbstractResolvableFuture.Waiter tOMBSTONE2;
        androidx.concurrent.futures.AbstractResolvableFuture.Waiter tOMBSTONE;
        boolean casWaiters;
        int i2;
        int i;
        if (Thread.interrupted()) {
        } else {
            localValue = this.value;
            int i4 = 0;
            final int i5 = 1;
            i3 = localValue != null ? i5 : i4;
            if (i3 &= i7 != 0) {
                return getDoneValue(localValue);
            }
            if (this.waiters != AbstractResolvableFuture.Waiter.TOMBSTONE) {
                tOMBSTONE2 = new AbstractResolvableFuture.Waiter();
                tOMBSTONE2.setNext(oldHead);
                while (AbstractResolvableFuture.ATOMIC_HELPER.casWaiters(this, oldHead, tOMBSTONE2)) {
                    tOMBSTONE2.setNext(oldHead);
                }
                LockSupport.park(this);
                while (!Thread.interrupted()) {
                    localValue = this.value;
                    if (localValue != null) {
                    } else {
                    }
                    i2 = i4;
                    LockSupport.park(this);
                    i2 = i5;
                }
                removeWaiter(tOMBSTONE2);
                InterruptedException interruptedException = new InterruptedException();
                throw interruptedException;
            }
            return getDoneValue(this.value);
        }
        InterruptedException localValue2 = new InterruptedException();
        throw localValue2;
    }

    public final V get(long timeout, TimeUnit unit) throws java.lang.InterruptedException, TimeoutException, ExecutionException {
        String message;
        String message3;
        String message2;
        long overWaitNanos;
        long convert;
        long remainingNanos;
        Object localValue;
        androidx.concurrent.futures.AbstractResolvableFuture.Waiter oldHead;
        int i;
        int tOMBSTONE;
        int i2;
        int casWaiters;
        int cmp;
        int append2;
        StringBuilder append;
        int append3;
        int i4;
        int i7;
        String str;
        int i8;
        long timeoutNanos;
        int cmp2;
        int i5;
        int i6;
        long nanos;
        int i3;
        Object obj = this;
        overWaitNanos = timeout;
        final Object obj2 = obj30;
        convert = obj2.toNanos(overWaitNanos);
        remainingNanos = convert;
        if (Thread.interrupted()) {
        } else {
            localValue = obj.value;
            tOMBSTONE = 1;
            i2 = localValue != null ? tOMBSTONE : 0;
            if (i2 &= i7 != 0) {
                return obj.getDoneValue(localValue);
            }
            casWaiters = 0;
            if (Long.compare(remainingNanos, casWaiters) > 0) {
                nanoTime2 += remainingNanos;
            } else {
                i8 = casWaiters;
            }
            int i13 = 1000;
            if (Long.compare(remainingNanos, i13) >= 0 && obj.waiters != AbstractResolvableFuture.Waiter.TOMBSTONE) {
                if (obj.waiters != AbstractResolvableFuture.Waiter.TOMBSTONE) {
                    tOMBSTONE = new AbstractResolvableFuture.Waiter();
                    tOMBSTONE.setNext(oldHead);
                    while (AbstractResolvableFuture.ATOMIC_HELPER.casWaiters(obj, oldHead, tOMBSTONE)) {
                        casWaiters = i6;
                        tOMBSTONE.setNext(oldHead);
                    }
                    LockSupport.parkNanos(obj, remainingNanos);
                    while (!Thread.interrupted()) {
                        localValue = obj.value;
                        if (localValue != null) {
                        } else {
                        }
                        i4 = 0;
                        LockSupport.parkNanos(obj, remainingNanos);
                        i4 = i5;
                    }
                    obj.removeWaiter(tOMBSTONE);
                    InterruptedException interruptedException2 = new InterruptedException();
                    throw interruptedException2;
                }
                return obj.getDoneValue(obj.value);
            }
            i5 = tOMBSTONE;
            i6 = casWaiters;
            while (Long.compare(remainingNanos, i6) > 0) {
                localValue = obj.value;
                if (localValue != null) {
                } else {
                }
                i = 0;
                remainingNanos = i8 - oldHead;
                i = i5;
            }
            StringBuilder stringBuilder3 = new StringBuilder();
            str = " ";
            final int i15 = i13;
            if (Long.compare(i14, i6) < 0) {
                StringBuilder stringBuilder4 = new StringBuilder();
                int i9 = -remainingNanos;
                timeoutNanos = convert;
                convert = obj2.convert(i9, obj2);
                overWaitNanos = i3 - nanos;
                if (Long.compare(convert, i6) != 0) {
                    if (Long.compare(overWaitNanos, i15) > 0) {
                        cmp2 = i5;
                    } else {
                        cmp2 = 0;
                    }
                } else {
                }
                if (Long.compare(convert, i6) > 0) {
                    StringBuilder stringBuilder7 = new StringBuilder();
                    message3 = stringBuilder7.append(stringBuilder4.append(stringBuilder3.append("Waited ").append(overWaitNanos).append(str).append(obj2.toString().toLowerCase(Locale.ROOT)).toString()).append(" (plus ").toString()).append(convert).append(str).append(obj2.toString().toLowerCase(Locale.ROOT)).toString();
                    if (cmp2 != 0) {
                        StringBuilder stringBuilder8 = new StringBuilder();
                        i5 = message3;
                        message3 = stringBuilder8.append(message3).append(",").toString();
                    } else {
                        i5 = message3;
                    }
                    StringBuilder stringBuilder9 = new StringBuilder();
                    message = stringBuilder9.append(message3).append(str).toString();
                }
                if (cmp2 != 0) {
                    StringBuilder stringBuilder6 = new StringBuilder();
                    message = stringBuilder6.append(message).append(overWaitNanos).append(" nanoseconds ").toString();
                }
                StringBuilder stringBuilder5 = new StringBuilder();
                message2 = stringBuilder5.append(message).append("delay)").toString();
            } else {
                timeoutNanos = convert;
            }
            if (isDone()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                TimeoutException timeoutException2 = new TimeoutException(stringBuilder2.append(message2).append(" but future completed as timeout expired").toString());
                throw timeoutException2;
            }
            StringBuilder stringBuilder = new StringBuilder();
            TimeoutException timeoutException = new TimeoutException(stringBuilder.append(message2).append(" for ").append(obj.toString()).toString());
            throw timeoutException;
        }
        InterruptedException message5 = new InterruptedException();
        throw message5;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    protected void interruptTask() {
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final boolean isCancelled() {
        return value instanceof AbstractResolvableFuture.Cancellation;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public final boolean isDone() {
        int i;
        final Object value = this.value;
        int i2 = 1;
        i = value != null ? i2 : 0;
        return i3 &= i;
    }

    final void maybePropagateCancellationTo(Future<?> future) {
        int i;
        int interrupted;
        i = future != null ? 1 : 0;
        if (i &= cancelled != 0) {
            future.cancel(wasInterrupted());
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    protected String pendingToString() {
        final Object value = this.value;
        if (value instanceof AbstractResolvableFuture.SetFuture) {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("setFuture=[").append(userObjectToString(obj.future)).append("]").toString();
        }
        if (this instanceof ScheduledFuture) {
            StringBuilder stringBuilder2 = new StringBuilder();
            final TimeUnit mILLISECONDS = TimeUnit.MILLISECONDS;
            return stringBuilder2.append("remaining delay=[").append((ScheduledFuture)this.getDelay(mILLISECONDS)).append(" ms]").toString();
        }
        return null;
    }

    protected boolean set(V v) {
        Object nULL;
        nULL = v == null ? AbstractResolvableFuture.NULL : v;
        if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(this, 0, nULL)) {
            AbstractResolvableFuture.complete(this);
            return 1;
        }
        return 0;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    protected boolean setException(Throwable throwable) {
        AbstractResolvableFuture.Failure failure = new AbstractResolvableFuture.Failure((Throwable)AbstractResolvableFuture.checkNotNull(throwable));
        if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(this, 0, failure)) {
            AbstractResolvableFuture.complete(this);
            return 1;
        }
        return 0;
    }

    protected boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        Object localValue;
        Throwable th;
        androidx.concurrent.futures.DirectExecutor iNSTANCE;
        Object value;
        boolean valueToSet;
        int i;
        androidx.concurrent.futures.AbstractResolvableFuture.Failure oomMostLikely;
        androidx.concurrent.futures.AbstractResolvableFuture.Failure aTOMIC_HELPER;
        AbstractResolvableFuture.checkNotNull(listenableFuture);
        int i2 = 0;
        i = 1;
        int i3 = 0;
        if (this.value == null && listenableFuture.isDone() && AbstractResolvableFuture.ATOMIC_HELPER.casValue(this, i3, AbstractResolvableFuture.getFutureValue(listenableFuture))) {
            i = 1;
            i3 = 0;
            if (listenableFuture.isDone()) {
                if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(this, i3, AbstractResolvableFuture.getFutureValue(listenableFuture))) {
                    AbstractResolvableFuture.complete(this);
                    return i;
                }
                return i2;
            }
            value = new AbstractResolvableFuture.SetFuture(this, listenableFuture);
            if (AbstractResolvableFuture.ATOMIC_HELPER.casValue(this, i3, value)) {
                listenableFuture.addListener(value, DirectExecutor.INSTANCE);
                return i;
            }
            localValue = this.value;
        }
        if (localValue instanceof AbstractResolvableFuture.Cancellation) {
            listenableFuture.cancel(obj.wasInterrupted);
        }
        return i2;
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public String toString() {
        String pendingToString;
        StringBuilder string;
        String class;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append2 = stringBuilder.append(super.toString()).append("[status=");
        final String str2 = "]";
        if (isCancelled()) {
            append2.append("CANCELLED");
        } else {
            if (isDone()) {
                addDoneString(append2);
            } else {
                pendingToString = pendingToString();
                if (pendingToString != null && !pendingToString.isEmpty()) {
                    if (!pendingToString.isEmpty()) {
                        append2.append("PENDING, info=[").append(pendingToString).append(str2);
                    } else {
                        if (isDone()) {
                            addDoneString(append2);
                        } else {
                            append2.append("PENDING");
                        }
                    }
                } else {
                }
            }
        }
        return append2.append(str2).toString();
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    protected final boolean wasInterrupted() {
        boolean wasInterrupted;
        int i;
        final Object value = this.value;
        if (value instanceof AbstractResolvableFuture.Cancellation && obj.wasInterrupted) {
            i = obj.wasInterrupted ? 1 : 0;
        } else {
        }
        return i;
    }
}
