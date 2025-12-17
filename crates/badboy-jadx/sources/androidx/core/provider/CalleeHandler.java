package androidx.core.provider;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes5.dex */
class CalleeHandler {
    static Handler create() {
        Handler handler;
        Looper mainLooper;
        if (Looper.myLooper() == null) {
            handler = new Handler(Looper.getMainLooper());
        } else {
            handler = new Handler();
        }
        return handler;
    }
}
