package com.iterable.iterableapi;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: IterableInAppManager.java */
/* loaded from: classes2.dex */
public class f0 implements i.c {

    private long A;
    private long B;
    private boolean C;
    private final j a;
    private final Context b;
    private final h0 c;
    private final d0 v;
    private final a0 w;
    private final i x;
    private final double y;
    private final List<f0.f> z;

    class c implements Comparator<g0> {
        c() {
            super();
        }

        public int m(g0 g0Var, g0 g0Var2) {
            double d = g0Var.k();
            final double d3 = g0Var2.k();
            if (d < d3) {
                return -1;
            }
            double d2 = g0Var.k();
            double d4 = g0Var2.k();
            if (d2 == d4) {
                return 0;
            }
            return 1;
        }
    }

    class d implements Runnable {

        final /* synthetic */ f0 a;
        d() {
            this.a = f0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.w();
        }
    }

    class e implements Runnable {

        final /* synthetic */ f0 a;
        e() {
            this.a = f0Var;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            List list = this.a.z;
            synchronized (list) {
                try {
                    Iterator it = this.a.z.iterator();
                    while (it.hasNext()) {
                        (f0.f)it.next().C();
                    }
                    return;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
    }

    public interface f {
        void C();
    }

    class a implements v {

        final /* synthetic */ f0 a;
        a() {
            this.a = f0Var;
            super();
        }

        public void a(String str) {
            boolean empty;
            int i = 0;
            com.iterable.iterableapi.h0 h0Var = null;
            if (str == null || str.isEmpty()) {
                this.a.C();
            } else {
                try {
                    ArrayList arrayList = new ArrayList();
                    JSONArray optJSONArray = new JSONObject(str).optJSONArray("inAppMessages");
                    i = 0;
                    while (i < optJSONArray.length()) {
                        h0Var = null;
                        com.iterable.iterableapi.g0 g0Var = g0.d(optJSONArray.optJSONObject(i), h0Var);
                        if (g0Var != null) {
                            arrayList.add(g0Var);
                        }
                        i = i + 1;
                    }
                    this.a.J(arrayList);
                    this.a.A = z0.a();
                } catch (org.json.JSONException jSON) {
                    jSON = jSON.toString();
                    j0.c("IterableInAppManager", jSON);
                }
            }
        }
    }

    class b implements w {

        final /* synthetic */ w a;
        final /* synthetic */ g0 b;
        final /* synthetic */ f0 c;
        b(w wVar, g0 g0Var) {
            this.c = f0Var;
            this.a = wVar;
            this.b = g0Var;
            super();
        }

        public void a(Uri uri) {
            if (this.a != null) {
                this.a.a(uri);
            }
            this.c.p(this.b, uri);
            this.c.B = z0.a();
            this.c.C();
        }
    }
    f0(j jVar, d0 d0Var, double d) {
        this(jVar, d0Var, d, h0Var, new b0(jVar.t()), i.l(), new a0(i.l()));
    }

    private void J(List<g0> list) {
        int i;
        String str;
        final HashMap hashMap = new HashMap();
        Iterator it = list.iterator();
        i = 0;
        i = 1;
        while (it.hasNext()) {
            Object item = it.next();
            hashMap.put(item.i(), item);
            int r5 = i;
        }
        Iterator it2 = this.c.a().iterator();
        while (it2.hasNext()) {
            Object item2 = it2.next();
        }
        C();
        if (i != 0) {
            u();
        }
    }

    static /* synthetic */ void b(f0 f0Var, List list) {
        f0Var.J(list);
    }

    static /* synthetic */ long c(f0 f0Var, long j) {
        f0Var.A = j;
        return j;
    }

    static /* synthetic */ long e(f0 f0Var, long j) {
        f0Var.B = j;
        return j;
    }

    static /* synthetic */ void f(f0 f0Var) {
        f0Var.w();
    }

    static /* synthetic */ List g(f0 f0Var) {
        return f0Var.z;
    }

    private boolean i() {
        boolean z = true;
        double d = n();
        int r0 = d >= this.y ? 1 : 0;
        return (d >= this.y ? 1 : 0);
    }

    private List<g0> m(List<g0> list) {
        Collections.sort(list, new f0.c(this));
        return list;
    }

    private double n() {
        return (double)(z0.a() - this.B) / 1000d;
    }

    private void q(String str, g0 g0Var) {
        str2 = "delete";
        if (str2.equals(str)) {
            z(g0Var, z.DELETE_BUTTON, e0.IN_APP);
        }
    }

    private boolean s(g0 g0Var) {
        boolean z = false;
        int i = 0;
        if (g0Var.g() != null) {
            long l = z0.a();
            long time = g0Var.g().getTime();
            if (l > time) {
                int i2 = 1;
            }
        }
        return z;
    }

    private boolean t() {
        return this.w.a();
    }

    private void v(g0 g0Var) {
        if (!g0Var.r()) {
            this.a.Z(g0Var);
        }
    }

    private void w() {
        boolean z2;
        com.iterable.iterableapi.g0.f.a iMMEDIATE2;
        com.iterable.iterableapi.d0.a sHOW2;
        String str;
    }

    synchronized void A(String str) {
        final com.iterable.iterableapi.g0 g0Var = this.c.d(str);
        if (g0Var != null) {
            this.c.b(g0Var);
        }
        u();
    }

    void B() {
        j0.g();
        Iterator it = this.c.a().iterator();
        while (it.hasNext()) {
            this.c.b((g0)it.next());
        }
        u();
    }

    void C() {
        j0.g();
        if (i()) {
            w();
        } else {
            double d = 1000d;
            l = (long)(this.y - n()) + 2d * d;
            new Handler(Looper.getMainLooper()).postDelayed(new f0.d(this), l);
        }
    }

    public void D(boolean z) {
        this.C = z;
        if (!z) {
            C();
        }
    }

    public synchronized void E(g0 g0Var, boolean z) {
        g0Var.z(z);
        u();
    }

    public void F(g0 g0Var, e0 e0Var) {
        boolean z = true;
        int r0 = e0Var == e0.IN_APP ? 1 : 0;
        H(g0Var, (e0Var == e0.IN_APP ? 1 : 0), null, e0Var);
    }

    public void G(g0 g0Var, boolean z, w wVar) {
        H(g0Var, z, wVar, e0.IN_APP);
    }

    public void H(g0 g0Var, boolean z, w wVar, e0 e0Var) {
        if (this.w.c(g0Var, e0Var, new f0.b(this, wVar, g0Var))) {
            z = true;
            E(g0Var, z);
            if (z) {
                g0Var.t(z);
            }
        }
    }

    void I() {
        j0.g();
        this.a.r(100, new f0.a(this));
    }

    public void d() {
        long l2 = z0.a() - this.A;
        if (l2 > 60000) {
            I();
        } else {
            C();
        }
    }

    public void h(f0.f fVar) {
        synchronized (list) {
            try {
                this.z.add(fVar);
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public synchronized List<g0> j() {
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.c.a().iterator();
        Object item = it.next();
        arrayList.add(item);
        return arrayList;
    }

    synchronized g0 k(String str) {
        return this.c.d(str);
    }

    public synchronized List<g0> l() {
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.c.a().iterator();
        Object item = it.next();
        arrayList.add(item);
        return arrayList;
    }

    public synchronized int o() {
        int i = 0;
        i = 0;
        Iterator it = j().iterator();
        return i;
    }

    public void p(g0 g0Var, Uri uri) {
        j0.g();
        if (uri != null) {
            if (!uri.toString().isEmpty()) {
                String uri3 = uri.toString();
                String str2 = "action://";
                str = "";
                if (uri3.startsWith(str2)) {
                    g.a(this.b, e.a(uri3.replace(str2, str)), h.IN_APP);
                } else {
                    String str3 = "itbl://";
                    if (uri3.startsWith(str3)) {
                        g.a(this.b, e.a(uri3.replace(str3, str)), h.IN_APP);
                    } else {
                        String str4 = "iterable://";
                        if (uri3.startsWith(str4)) {
                            q(uri3.replace(str4, str), g0Var);
                        } else {
                            g.a(this.b, e.b(uri3), h.IN_APP);
                        }
                    }
                }
            }
        }
    }

    boolean r() {
        return this.C;
    }

    public void u() {
        new Handler(Looper.getMainLooper()).post(new f0.e(this));
    }

    public void x(f0.f fVar) {
        synchronized (list) {
            try {
                this.z.remove(fVar);
                return;
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        }
    }

    public synchronized void y(g0 g0Var) {
        g0Var.v(true);
        this.a.y(g0Var.i());
        u();
    }

    public synchronized void z(g0 g0Var, z zVar, e0 e0Var) {
        j0.g();
        g0Var.v(true);
        this.a.x(g0Var, zVar, e0Var);
        u();
    }

    f0(j jVar, d0 d0Var, double d, h0 h0Var, i iVar, a0 a0Var) {
        super();
        this.z = new ArrayList();
        long l = 0L;
        this.A = l;
        this.B = l;
        this.C = false;
        this.a = jVar;
        this.b = jVar.t();
        this.v = d0Var;
        this.y = d;
        this.c = h0Var;
        this.w = a0Var;
        this.x = iVar;
        iVar.j(this);
        I();
    }

    public void a() {
    }
}
