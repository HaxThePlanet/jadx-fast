package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* compiled from: Stats.java */
/* loaded from: classes2.dex */
class a0 {

    final HandlerThread a = new HandlerThread("Picasso-Stats", 10);
    final d b;
    final Handler c = new a0$a();
    long d;
    long e;
    long f;
    long g;
    long h;
    long i;
    long j;
    long k;
    int l;
    int m;
    int n;

    private static class a extends Handler {

        private final a0 a;
        a(Looper looper, a0 a0Var) {
            super(looper);
            this.a = a0Var;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                this.a.j();
            } else {
                if (message.what == 1) {
                    this.a.k();
                } else {
                    if (message.what == 2) {
                        l = (long)message.arg1;
                        this.a.h(l);
                    } else {
                        if (message.what == 3) {
                            l = (long)message.arg1;
                            this.a.i(l);
                        } else {
                            if (message.what != 4) {
                                t.p.post(new a0.a.a(this, message));
                            } else {
                                this.a.l((Long)message.obj);
                            }
                        }
                    }
                }
            }
        }
    }
    a0(d dVar) {
        super();
        this.b = dVar;
        HandlerThread handlerThread = new HandlerThread("Picasso-Stats", 10);
        handlerThread.start();
        f0.h(handlerThread.getLooper());
        com.squareup.picasso.a0.a aVar = new a0.a(handlerThread.getLooper(), this);
    }

    private static long g(int i, long j) {
        return j / (long)i;
    }

    private void m(Bitmap bitmap, int i) {
        this.c.sendMessage(this.c.obtainMessage(i, f0.i(bitmap), 0));
    }

    b0 a() {
        final Object obj = this;
        b0 b0Var = new b0(i4, obj.b.size(), obj.d, l4, obj.e, l6, obj.f, l8, obj.g, l10, obj.h, i5, obj.i, l13, l, obj2, l2, obj3, i, i2, i3, System.currentTimeMillis(), obj4);
        return b0Var;
    }

    void b(Bitmap bitmap) {
        m(bitmap, 2);
    }

    void c(Bitmap bitmap) {
        m(bitmap, 3);
    }

    void d() {
        this.c.sendEmptyMessage(0);
    }

    void e() {
        this.c.sendEmptyMessage(1);
    }

    void f(long j) {
        this.c.sendMessage(this.c.obtainMessage(4, Long.valueOf(j)));
    }

    void h(long j) {
        this.m++;
        this.g += j;
        this.j = a0.g(i2, l2);
    }

    void i(long j) {
        this.n++;
        this.h += j;
        this.k = a0.g(this.m, l2);
    }

    void j() {
        this.d++;
    }

    void k() {
        this.e++;
    }

    void l(Long long) {
        this.l++;
        this.f += value;
        this.i = a0.g(this.l, l2);
    }
}
