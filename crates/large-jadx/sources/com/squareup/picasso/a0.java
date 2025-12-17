package com.squareup.picasso;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
class a0 {

    final HandlerThread a;
    final com.squareup.picasso.d b;
    final Handler c;
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

        private final com.squareup.picasso.a0 a;
        a(Looper looper, com.squareup.picasso.a0 a02) {
            super(looper);
            this.a = a02;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int what;
            long aVar;
            com.squareup.picasso.a0 obj4;
            what = message.what;
            if (what != 0) {
                if (what != 1) {
                    if (what != 2) {
                        if (what != 3) {
                            if (what != 4) {
                                aVar = new a0.a.a(this, message);
                                t.p.post(aVar);
                            } else {
                                this.a.l((Long)message.obj);
                            }
                        } else {
                            this.a.i((long)obj4);
                        }
                    } else {
                        this.a.h((long)obj4);
                    }
                } else {
                    this.a.k();
                }
            } else {
                this.a.j();
            }
        }
    }
    a0(com.squareup.picasso.d d) {
        super();
        this.b = d;
        HandlerThread obj3 = new HandlerThread("Picasso-Stats", 10);
        this.a = obj3;
        obj3.start();
        f0.h(obj3.getLooper());
        a0.a aVar = new a0.a(obj3.getLooper(), this);
        this.c = aVar;
    }

    private static long g(int i, long l2) {
        return l2 /= l;
    }

    private void m(Bitmap bitmap, int i2) {
        final Handler handler = this.c;
        handler.sendMessage(handler.obtainMessage(i2, f0.i(bitmap), 0));
    }

    com.squareup.picasso.b0 a() {
        final Object obj = this;
        super(obj.b.a(), obj.b.size(), obj.d, obj5, obj.e, obj7, obj.f, obj9, obj.g, obj11, obj.h, obj13, obj.i, obj15, obj.j, obj17, obj.k, obj19, obj.l, obj.m, obj.n, System.currentTimeMillis(), obj24);
        return b0Var3;
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

    void f(long l) {
        final Handler handler = this.c;
        handler.sendMessage(handler.obtainMessage(4, Long.valueOf(l)));
    }

    void h(long l) {
        i++;
        this.m = i2;
        l2 += l;
        this.g = i3;
        this.j = a0.g(i2, i3);
    }

    void i(long l) {
        this.n = i++;
        l2 += l;
        this.h = i3;
        this.k = a0.g(this.m, i3);
    }

    void j() {
        this.d = l += i2;
    }

    void k() {
        this.e = l += i2;
    }

    void l(Long long) {
        this.l = i++;
        l += longValue;
        this.f = i3;
        this.i = a0.g(this.l, i3);
    }
}
