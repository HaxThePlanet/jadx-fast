package androidx.core.os;

import android.os.CancellationSignal;

/* loaded from: classes5.dex */
@Deprecated
public final class CancellationSignal {

    private boolean mCancelInProgress;
    private Object mCancellationSignalObj;
    private boolean mIsCanceled;
    private androidx.core.os.CancellationSignal.OnCancelListener mOnCancelListener;

    public interface OnCancelListener {
        public abstract void onCancel();
    }
    private void waitForCancelFinishedLocked() {
        Throwable mCancelInProgress;
        while (this.mCancelInProgress) {
            wait();
        }
        try {
        }
    }

    public void cancel() {
        Object th;
        synchronized (this) {
            try {
                int i = 1;
                this.mIsCanceled = i;
                this.mCancelInProgress = i;
                androidx.core.os.CancellationSignal.OnCancelListener mOnCancelListener = this.mOnCancelListener;
                final Object mCancellationSignalObj = this.mCancellationSignalObj;
                if (mOnCancelListener != null) {
                }
                mOnCancelListener.onCancel();
                if (mCancellationSignalObj != null) {
                }
                (CancellationSignal)mCancellationSignalObj.cancel();
                this.mCancelInProgress = z;
                notifyAll();
                throw th;
                throw z;
                this.mCancelInProgress = false;
                notifyAll();
                throw z;
                throw listener;
            } catch (Throwable th) {
            }
        }
    }

    public Object getCancellationSignalObject() {
        Object mCancellationSignalObj;
        synchronized (this) {
            try {
                CancellationSignal cancellationSignal = new CancellationSignal();
                this.mCancellationSignalObj = cancellationSignal;
                if (this.mIsCanceled) {
                }
                (CancellationSignal)this.mCancellationSignalObj.cancel();
                return this.mCancellationSignalObj;
                throw th;
            }
        }
    }

    public boolean isCanceled() {
        return this.mIsCanceled;
        synchronized (this) {
            return this.mIsCanceled;
        }
    }

    public void setOnCancelListener(androidx.core.os.CancellationSignal.OnCancelListener listener) {
        waitForCancelFinishedLocked();
        synchronized (this) {
            try {
                this.mOnCancelListener = listener;
                if (this.mIsCanceled && listener == null) {
                }
                if (listener == null) {
                }
                listener.onCancel();
                throw th;
            }
        }
    }

    public void throwIfCanceled() {
        if (isCanceled()) {
        } else {
        }
        OperationCanceledException operationCanceledException = new OperationCanceledException();
        throw operationCanceledException;
    }
}
