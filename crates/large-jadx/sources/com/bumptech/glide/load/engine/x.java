package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;

/* compiled from: ResourceRecycler.java */
/* loaded from: classes.dex */
class x {

    private boolean a;
    private final Handler b = new Handler();

    private static final class a implements Handler.Callback {
        a() {
            super();
        }

        @Override // android.os.Handler$Callback
        public boolean handleMessage(Message message) {
            final int i = 1;
            if (message.what == i) {
                (u)message.obj.a();
                return true;
            }
            return false;
        }
    }
    x() {
        super();
        final Handler handler = new Handler(Looper.getMainLooper(), new x.a());
    }

    synchronized void a(u<?> uVar, boolean z) {
        final boolean z3 = true;
        if (this.a || z) {
            this.b.obtainMessage(z3, uVar).sendToTarget();
        }
    }
}
