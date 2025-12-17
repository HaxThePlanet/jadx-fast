package com.iterable.iterableapi;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
class v0 implements com.iterable.iterableapi.w0.d, Handler.Callback, com.iterable.iterableapi.k0.b, com.iterable.iterableapi.i.c {

    private com.iterable.iterableapi.w0 a;
    private com.iterable.iterableapi.i b;
    private com.iterable.iterableapi.k0 c;
    private com.iterable.iterableapi.a v;
    private final HandlerThread w;
    Handler x;
    private ArrayList<com.iterable.iterableapi.v0.b> y;

    class a implements Runnable {

        final com.iterable.iterableapi.v0.b a;
        final String b;
        final com.iterable.iterableapi.v0.c c;
        final com.iterable.iterableapi.m v;
        a(com.iterable.iterableapi.v0 v0, com.iterable.iterableapi.v0.b v0$b2, String string3, com.iterable.iterableapi.v0.c v0$c4, com.iterable.iterableapi.m m5) {
            this.a = b2;
            this.b = string3;
            this.c = c4;
            this.v = m5;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b, this.c, this.v);
        }
    }

    interface b {
        public abstract void a(String string, com.iterable.iterableapi.v0.c v0$c2, com.iterable.iterableapi.m m3);
    }

    static enum c {

        SUCCESS,
        FAILURE,
        RETRY;
    }
    v0(com.iterable.iterableapi.w0 w0, com.iterable.iterableapi.i i2, com.iterable.iterableapi.k0 k03, com.iterable.iterableapi.a a4) {
        super();
        HandlerThread handlerThread = new HandlerThread("NetworkThread");
        this.w = handlerThread;
        ArrayList arrayList = new ArrayList();
        this.y = arrayList;
        this.a = w0;
        this.b = i2;
        this.c = k03;
        this.v = a4;
        handlerThread.start();
        Handler obj6 = new Handler(handlerThread.getLooper(), this);
        this.x = obj6;
        w0.d(this);
        k03.c(this);
        i2.j(this);
    }

    private void g(String string, com.iterable.iterableapi.v0.c v0$c2, com.iterable.iterableapi.m m3) {
        Handler handler;
        com.iterable.iterableapi.v0.a aVar2;
        Object obj;
        Object obj2;
        String str;
        com.iterable.iterableapi.v0.c cVar;
        com.iterable.iterableapi.m mVar;
        com.iterable.iterableapi.v0.a aVar;
        Iterator iterator = this.y.iterator();
        for (Object next2 : iterator) {
            handler = new Handler(Looper.getMainLooper());
            super(this, (v0.b)next2, string, c2, m3);
            handler.post(aVar);
        }
    }

    private boolean i(String string) {
        return string.contains("failed to connect");
    }

    private boolean j(com.iterable.iterableapi.u0 u0) {
        com.iterable.iterableapi.v0.c fAILURE;
        com.iterable.iterableapi.l lVar;
        com.iterable.iterableapi.l.b oFFLINE;
        String str;
        final int i2 = 0;
        if (u0.n == x0.API) {
            fAILURE = v0.c.FAILURE;
            int i = 0;
            lVar = l.a(h(u0), i, i);
            lVar.c(l.b.OFFLINE);
            com.iterable.iterableapi.m mVar = t0.c(lVar);
            if (mVar != null) {
                fAILURE = mVar.a ? v0.c.SUCCESS : z2 ? v0.c.RETRY : v0.c.FAILURE;
            }
            g(u0.a, fAILURE, mVar);
            if (fAILURE == v0.c.RETRY) {
                try {
                    return i2;
                    this.a.h(u0.a);
                    return 1;
                    return i2;
                }
            }
        }
    }

    private void k() {
        boolean z;
        if (!this.b.m()) {
            j0.a("IterableTaskRunner", "App not in foreground, skipping processing tasks");
        }
        if (!this.v.c()) {
        }
        while (this.c.d()) {
            com.iterable.iterableapi.u0 u0Var = this.a.i();
        }
    }

    private void l() {
        final int i = 100;
        this.x.removeMessages(i);
        this.x.sendEmptyMessage(i);
    }

    private void m() {
        final int i = 100;
        this.x.removeCallbacksAndMessages(Integer.valueOf(i));
        this.x.sendEmptyMessageDelayed(i, 60000);
    }

    @Override // com.iterable.iterableapi.w0$d
    public void a() {
    }

    @Override // com.iterable.iterableapi.w0$d
    public void b(com.iterable.iterableapi.u0 u0) {
        l();
    }

    @Override // com.iterable.iterableapi.w0$d
    public void c() {
    }

    @Override // com.iterable.iterableapi.w0$d
    public void d() {
        l();
    }

    @Override // com.iterable.iterableapi.w0$d
    public void e() {
        l();
    }

    @Override // com.iterable.iterableapi.w0$d
    void f(com.iterable.iterableapi.v0.b v0$b) {
        this.y.add(b);
    }

    @Override // com.iterable.iterableapi.w0$d
    JSONObject h(com.iterable.iterableapi.u0 u0) {
        try {
            JSONObject jSONObject = new JSONObject(u0.l);
            jSONObject.getJSONObject("data").put("createdAt", l /= i2);
            return jSONObject;
            u0.printStackTrace();
            u0 = null;
            return u0;
        }
    }

    @Override // com.iterable.iterableapi.w0$d
    public boolean handleMessage(Message message) {
        if (message.what == 100) {
            k();
            return 1;
        }
        return 0;
    }
}
