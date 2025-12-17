package d.h.i;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
class b {
    static Handler a() {
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
