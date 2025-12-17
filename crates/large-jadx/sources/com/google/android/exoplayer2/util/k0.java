package com.google.android.exoplayer2.util;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
final class k0 implements com.google.android.exoplayer2.util.s {

    private static final List<com.google.android.exoplayer2.util.k0.b> b;
    private final Handler a;

    static class a {
    }

    private static final class b implements com.google.android.exoplayer2.util.s.a {

        private Message a;
        b(com.google.android.exoplayer2.util.k0.a k0$a) {
            super();
        }

        private void b() {
            this.a = 0;
            k0.l(this);
        }

        @Override // com.google.android.exoplayer2.util.s$a
        public void a() {
            final Message message = this.a;
            g.e(message);
            (Message)message.sendToTarget();
            b();
        }

        @Override // com.google.android.exoplayer2.util.s$a
        public boolean c(Handler handler) {
            final Message message = this.a;
            g.e(message);
            b();
            return handler.sendMessageAtFrontOfQueue((Message)message);
        }

        @Override // com.google.android.exoplayer2.util.s$a
        public com.google.android.exoplayer2.util.k0.b d(Message message, com.google.android.exoplayer2.util.k0 k02) {
            this.a = message;
            return this;
        }
    }
    static {
        ArrayList arrayList = new ArrayList(50);
        k0.b = arrayList;
    }

    public k0(Handler handler) {
        super();
        this.a = handler;
    }

    static void l(com.google.android.exoplayer2.util.k0.b k0$b) {
        k0.n(b);
    }

    private static com.google.android.exoplayer2.util.k0.b m() {
        Object bVar;
        int i;
        final List list = k0.b;
        synchronized (list) {
            bVar = new k0.b(0);
            try {
                return bVar;
                throw th;
            }
        }
    }

    private static void n(com.google.android.exoplayer2.util.k0.b k0$b) {
        final List list = k0.b;
        synchronized (list) {
            list.add(b);
        }
    }

    @Override // com.google.android.exoplayer2.util.s
    public com.google.android.exoplayer2.util.s.a a(int i, int i2, int i3) {
        final com.google.android.exoplayer2.util.k0.b bVar = k0.m();
        bVar.d(this.a.obtainMessage(i, i2, i3), this);
        return bVar;
    }

    @Override // com.google.android.exoplayer2.util.s
    public boolean b(Runnable runnable) {
        return this.a.post(runnable);
    }

    @Override // com.google.android.exoplayer2.util.s
    public com.google.android.exoplayer2.util.s.a c(int i) {
        final com.google.android.exoplayer2.util.k0.b bVar = k0.m();
        bVar.d(this.a.obtainMessage(i), this);
        return bVar;
    }

    @Override // com.google.android.exoplayer2.util.s
    public boolean d(com.google.android.exoplayer2.util.s.a s$a) {
        return (k0.b)a.c(this.a);
    }

    @Override // com.google.android.exoplayer2.util.s
    public boolean e(int i) {
        return this.a.hasMessages(i);
    }

    @Override // com.google.android.exoplayer2.util.s
    public boolean f(int i) {
        return this.a.sendEmptyMessage(i);
    }

    @Override // com.google.android.exoplayer2.util.s
    public com.google.android.exoplayer2.util.s.a g(int i, int i2, int i3, Object object4) {
        final com.google.android.exoplayer2.util.k0.b bVar = k0.m();
        bVar.d(this.a.obtainMessage(i, i2, i3, object4), this);
        return bVar;
    }

    @Override // com.google.android.exoplayer2.util.s
    public boolean h(int i, long l2) {
        return this.a.sendEmptyMessageAtTime(i, l2);
    }

    @Override // com.google.android.exoplayer2.util.s
    public void i(int i) {
        this.a.removeMessages(i);
    }

    @Override // com.google.android.exoplayer2.util.s
    public com.google.android.exoplayer2.util.s.a j(int i, Object object2) {
        final com.google.android.exoplayer2.util.k0.b bVar = k0.m();
        bVar.d(this.a.obtainMessage(i, object2), this);
        return bVar;
    }

    @Override // com.google.android.exoplayer2.util.s
    public void k(Object object) {
        this.a.removeCallbacksAndMessages(object);
    }
}
