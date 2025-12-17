package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class CallbackToFutureAdapter {

    public static final class Completer {

        private boolean attemptedSetting;
        private androidx.concurrent.futures.ResolvableFuture<Void> cancellationFuture;
        androidx.concurrent.futures.CallbackToFutureAdapter.SafeFuture<T> future;
        Object tag;
        Completer() {
            super();
            this.cancellationFuture = ResolvableFuture.create();
        }

        private void setCompletedNormally() {
            final int i = 0;
            this.tag = i;
            this.future = i;
            this.cancellationFuture = i;
        }

        public void addCancellationListener(Runnable runnable, Executor executor) {
            final androidx.concurrent.futures.ResolvableFuture cancellationFuture = this.cancellationFuture;
            if (cancellationFuture != null) {
                cancellationFuture.addListener(runnable, executor);
            }
        }

        protected void finalize() {
            boolean futureGarbageCollectedException;
            boolean cancellationFuture;
            String string;
            Object tag;
            final androidx.concurrent.futures.CallbackToFutureAdapter.SafeFuture future = this.future;
            if (future != null && !future.isDone()) {
                if (!future.isDone()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    futureGarbageCollectedException = new CallbackToFutureAdapter.FutureGarbageCollectedException(stringBuilder.append("The completer object was garbage collected - this future would otherwise never complete. The tag was: ").append(this.tag).toString());
                    future.setException(futureGarbageCollectedException);
                }
            }
            cancellationFuture = this.cancellationFuture;
            if (!this.attemptedSetting && cancellationFuture != null) {
                cancellationFuture = this.cancellationFuture;
                if (cancellationFuture != null) {
                    cancellationFuture.set(0);
                }
            }
        }

        void fireCancellationListeners() {
            final int i = 0;
            this.tag = i;
            this.future = i;
            this.cancellationFuture.set(i);
        }

        public boolean set(T t) {
            int i;
            boolean z;
            this.attemptedSetting = true;
            final androidx.concurrent.futures.CallbackToFutureAdapter.SafeFuture future = this.future;
            if (future != null && future.set(t)) {
                if (future.set(t)) {
                } else {
                    i = 0;
                }
            } else {
            }
            if (i != 0) {
                setCompletedNormally();
            }
            return i;
        }

        public boolean setCancelled() {
            int i;
            boolean cancelWithoutNotifyingCompleter;
            i = 1;
            this.attemptedSetting = i;
            final androidx.concurrent.futures.CallbackToFutureAdapter.SafeFuture future = this.future;
            if (future != null && future.cancelWithoutNotifyingCompleter(i)) {
                if (future.cancelWithoutNotifyingCompleter(i)) {
                } else {
                    i = 0;
                }
            } else {
            }
            if (i != 0) {
                setCompletedNormally();
            }
            return i;
        }

        public boolean setException(Throwable t) {
            int i;
            boolean exception;
            this.attemptedSetting = true;
            final androidx.concurrent.futures.CallbackToFutureAdapter.SafeFuture future = this.future;
            if (future != null && future.setException(t)) {
                if (future.setException(t)) {
                } else {
                    i = 0;
                }
            } else {
            }
            if (i != 0) {
                setCompletedNormally();
            }
            return i;
        }
    }

    static final class FutureGarbageCollectedException extends Throwable {
        FutureGarbageCollectedException(String message) {
            super(message);
        }

        @Override // java.lang.Throwable
        public Throwable fillInStackTrace() {
            return this;
            synchronized (this) {
                return this;
            }
        }
    }

    public interface Resolver {
        public abstract Object attachCompleter(androidx.concurrent.futures.CallbackToFutureAdapter.Completer<T> callbackToFutureAdapter$Completer) throws Exception;
    }

    private static final class SafeFuture implements ListenableFuture<T> {

        final WeakReference<androidx.concurrent.futures.CallbackToFutureAdapter.Completer<T>> completerWeakReference;
        private final androidx.concurrent.futures.AbstractResolvableFuture<T> delegate;
        SafeFuture(androidx.concurrent.futures.CallbackToFutureAdapter.Completer<T> callbackToFutureAdapter$Completer) {
            super();
            CallbackToFutureAdapter.SafeFuture.1 anon = new CallbackToFutureAdapter.SafeFuture.1(this);
            this.delegate = anon;
            WeakReference weakReference = new WeakReference(completer);
            this.completerWeakReference = weakReference;
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable listener, Executor executor) {
            this.delegate.addListener(listener, executor);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public boolean cancel(boolean mayInterruptIfRunning) {
            Object obj = this.completerWeakReference.get();
            boolean cancel = this.delegate.cancel(mayInterruptIfRunning);
            if (cancel && (CallbackToFutureAdapter.Completer)obj != null) {
                if ((CallbackToFutureAdapter.Completer)obj != null) {
                    (CallbackToFutureAdapter.Completer)obj.fireCancellationListeners();
                }
            }
            return cancel;
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        boolean cancelWithoutNotifyingCompleter(boolean shouldInterrupt) {
            return this.delegate.cancel(shouldInterrupt);
        }

        public T get() throws java.lang.InterruptedException, ExecutionException {
            return this.delegate.get();
        }

        public T get(long timeout, TimeUnit unit) throws java.lang.InterruptedException, ExecutionException, TimeoutException {
            return this.delegate.get(timeout, unit);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public boolean isCancelled() {
            return this.delegate.isCancelled();
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public boolean isDone() {
            return this.delegate.isDone();
        }

        boolean set(T t) {
            return this.delegate.set(t);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        boolean setException(Throwable t) {
            return this.delegate.setException(t);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public String toString() {
            return this.delegate.toString();
        }
    }
    public static <T> ListenableFuture<T> getFuture(androidx.concurrent.futures.CallbackToFutureAdapter.Resolver<T> callbackToFutureAdapter$Resolver) {
        Object attachCompleter;
        CallbackToFutureAdapter.Completer completer = new CallbackToFutureAdapter.Completer();
        CallbackToFutureAdapter.SafeFuture safeFuture = new CallbackToFutureAdapter.SafeFuture(completer);
        completer.future = safeFuture;
        completer.tag = resolver.getClass();
        attachCompleter = resolver.attachCompleter(completer);
        if (attachCompleter != null) {
            completer.tag = attachCompleter;
        }
        return safeFuture;
    }
}
