package androidx.core.os;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;

/* loaded from: classes5.dex */
public final class HandlerCompat {

    private static final String TAG = "HandlerCompat";

    private static class Api28Impl {
        public static Handler createAsync(Looper looper) {
            return Handler.createAsync(looper);
        }

        public static Handler createAsync(Looper looper, Handler.Callback callback) {
            return Handler.createAsync(looper, callback);
        }

        public static boolean postDelayed(Handler handler, Runnable r, Object token, long delayMillis) {
            return handler.postDelayed(r, token, delayMillis);
        }
    }

    private static class Api29Impl {
        public static boolean hasCallbacks(Handler handler, Runnable r) {
            return handler.hasCallbacks(r);
        }
    }
    public static Handler createAsync(Looper looper) {
        return HandlerCompat.Api28Impl.createAsync(looper);
    }

    public static Handler createAsync(Looper looper, Handler.Callback callback) {
        return HandlerCompat.Api28Impl.createAsync(looper, callback);
    }

    public static boolean hasCallbacks(Handler handler, Runnable r) {
        final int i = 0;
        return HandlerCompat.Api29Impl.hasCallbacks(handler, r);
    }

    public static boolean postDelayed(Handler handler, Runnable r, Object token, long delayMillis) {
        return HandlerCompat.Api28Impl.postDelayed(handler, r, token, delayMillis);
    }
}
