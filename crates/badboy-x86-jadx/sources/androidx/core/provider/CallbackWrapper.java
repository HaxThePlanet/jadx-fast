package androidx.core.provider;

import android.graphics.Typeface;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
class CallbackWrapper {

    private final androidx.core.provider.FontsContractCompat.FontRequestCallback mCallback;
    private final Executor mExecutor;
    CallbackWrapper(androidx.core.provider.FontsContractCompat.FontRequestCallback callback) {
        super(callback, RequestExecutor.createHandlerExecutor(CalleeHandler.create()));
    }

    CallbackWrapper(androidx.core.provider.FontsContractCompat.FontRequestCallback callback, Executor executor) {
        super();
        this.mCallback = callback;
        this.mExecutor = executor;
    }

    private void onTypefaceRequestFailed(int reason) {
        CallbackWrapper.2 anon = new CallbackWrapper.2(this, this.mCallback, reason);
        this.mExecutor.execute(anon);
    }

    private void onTypefaceRetrieved(Typeface typeface) {
        CallbackWrapper.1 anon = new CallbackWrapper.1(this, this.mCallback, typeface);
        this.mExecutor.execute(anon);
    }

    void onTypefaceResult(androidx.core.provider.FontRequestWorker.TypefaceResult typefaceResult) {
        Typeface mTypeface;
        if (typefaceResult.isSuccess()) {
            onTypefaceRetrieved(typefaceResult.mTypeface);
        } else {
            onTypefaceRequestFailed(typefaceResult.mResult);
        }
    }
}
