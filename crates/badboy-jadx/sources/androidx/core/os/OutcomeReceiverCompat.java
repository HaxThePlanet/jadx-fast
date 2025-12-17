package androidx.core.os;

/* loaded from: classes5.dex */
public interface OutcomeReceiverCompat<R, E extends Throwable>  {
    public void onError(E e) {
    }

    public abstract void onResult(R r);
}
