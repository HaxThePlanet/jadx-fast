package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
class x {

    private boolean a;
    private final Handler b;

    private static final class a implements Handler.Callback {
        @Override // android.os.Handler$Callback
        public boolean handleMessage(Message message) {
            final int i = 1;
            if (message.what == i) {
                (u)message.obj.a();
                return i;
            }
            return 0;
        }
    }
    x() {
        super();
        x.a aVar = new x.a();
        Handler handler = new Handler(Looper.getMainLooper(), aVar);
        this.b = handler;
    }

    void a(com.bumptech.glide.load.engine.u<?> u, boolean z2) {
        int obj3;
        Handler obj4;
        final int i = 1;
        synchronized (this) {
            try {
                if (z2 != null) {
                } else {
                }
                this.a = i;
                u.a();
                this.a = false;
                this.b.obtainMessage(i, u).sendToTarget();
                throw u;
            }
        }
    }
}
