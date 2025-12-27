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

/* compiled from: IterableTaskRunner.java */
/* loaded from: classes2.dex */
class v0 implements w0.d, Handler.Callback, k0.b, i.c {

    private w0 a;
    private i b;
    private k0 c;
    private a v;
    private final HandlerThread w = new HandlerThread("NetworkThread");
    Handler x = new Handler();
    private ArrayList<v0.b> y = new ArrayList<>();

    class a implements Runnable {

        final /* synthetic */ v0.b a;
        final /* synthetic */ String b;
        final /* synthetic */ v0.c c;
        final /* synthetic */ m v;
        a(v0.b bVar, String str, v0.c cVar, m mVar) {
            this.a = bVar;
            this.b = str;
            this.c = cVar;
            this.v = mVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b, this.c, this.v);
        }
    }

    interface b {
        void a(String str, v0.c cVar, m mVar);
    }

    enum c {

        FAILURE,
        RETRY,
        SUCCESS;
    }
    v0(w0 w0Var, i iVar, k0 k0Var, a aVar) {
        super();
        HandlerThread handlerThread = new HandlerThread("NetworkThread");
        ArrayList arrayList = new ArrayList();
        this.a = w0Var;
        this.b = iVar;
        this.c = k0Var;
        this.v = aVar;
        handlerThread.start();
        final Handler handler = new Handler(handlerThread.getLooper(), this);
        w0Var.d(this);
        k0Var.c(this);
        iVar.j(this);
    }

    private void g(String str, v0.c cVar, m mVar) {
        Iterator it = this.y.iterator();
        while (it.hasNext()) {
            v0.a aVar = new v0.a(this, (v0.b)it.next(), str, cVar, mVar);
            new Handler(Looper.getMainLooper()).post(aVar);
        }
    }

    private boolean i(String str) {
        return str.contains("failed to connect");
    }

    private boolean j(u0 u0Var) {
        com.iterable.iterableapi.v0.c fAILURE2;
        final boolean z3 = false;
        if (u0Var.n == x0.API) {
            fAILURE2 = v0.c.FAILURE;
            com.iterable.iterableapi.x xVar = null;
            try {
                com.iterable.iterableapi.l lVar = l.a(h(u0Var), xVar, xVar);
                lVar.c(l.b.OFFLINE);
                com.iterable.iterableapi.m mVar = t0.c(lVar);
            } catch (Exception e) {
                j0.d("IterableTaskRunner", "Error while processing request task", e);
                this.v.b();
            }
            if (x0.API != null) {
                if (mVar.a) {
                    fAILURE2 = v0.c.SUCCESS;
                } else {
                    com.iterable.iterableapi.v0.c r0 = i(mVar.e) ? v0.c.RETRY : v0.c.FAILURE;
                }
            }
            g(u0Var.a, r0, mVar);
            if (r0 == v0.c.RETRY) {
                return false;
            }
            this.a.h(u0Var.a);
            return true;
        }
        return false;
    }

    private void k() {
        if (!this.b.m()) {
            j0.a("IterableTaskRunner", "App not in foreground, skipping processing tasks");
            return;
        }
        if (!this.v.c()) {
            return;
        }
        while (this.c.d()) {
            com.iterable.iterableapi.u0 u0Var = this.a.i();
            if (!j(u0Var)) {
                m();
            }
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
        this.x.sendEmptyMessageDelayed(i, 60000L);
    }

    public void b(u0 u0Var) {
        l();
    }

    public void d() {
        l();
    }

    public void e() {
        l();
    }

    void f(v0.b bVar) {
        this.y.add(bVar);
    }

    JSONObject h(u0 u0Var) {
        try {
            final JSONObject jSONObject = new JSONObject(u0Var.l);
            jSONObject.getJSONObject("data").put("createdAt", u0Var.d / 1000L);
        } catch (org.json.JSONException jSON) {
            jSON.printStackTrace();
            jSON = null;
            return jSON;
        }
        return jSONObject;
    }

    @Override // android.os.Handler$Callback
    public boolean handleMessage(Message message) {
        if (message.what == 100) {
            k();
            return true;
        }
        return false;
    }

    public void a() {
    }

    public void c() {
    }
}
