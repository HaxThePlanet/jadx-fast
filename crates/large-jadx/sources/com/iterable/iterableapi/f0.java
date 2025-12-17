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

/* loaded from: classes2.dex */
public class f0 implements com.iterable.iterableapi.i.c {

    private long A;
    private long B;
    private boolean C;
    private final com.iterable.iterableapi.j a;
    private final Context b;
    private final com.iterable.iterableapi.h0 c;
    private final com.iterable.iterableapi.d0 v;
    private final com.iterable.iterableapi.a0 w;
    private final com.iterable.iterableapi.i x;
    private final double y;
    private final List<com.iterable.iterableapi.f0.f> z;

    class c implements Comparator<com.iterable.iterableapi.g0> {
        c(com.iterable.iterableapi.f0 f0) {
            super();
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return m((g0)object, (g0)object2);
        }

        @Override // java.util.Comparator
        public int m(com.iterable.iterableapi.g0 g0, com.iterable.iterableapi.g0 g02) {
            if (Double.compare(d, d3) < 0) {
                return -1;
            }
            if (Double.compare(d2, obj5) == 0) {
                return 0;
            }
            return 1;
        }
    }

    class d implements Runnable {

        final com.iterable.iterableapi.f0 a;
        d(com.iterable.iterableapi.f0 f0) {
            this.a = f0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            f0.f(this.a);
        }
    }

    class e implements Runnable {

        final com.iterable.iterableapi.f0 a;
        e(com.iterable.iterableapi.f0 f0) {
            this.a = f0;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object next;
            List list = f0.g(this.a);
            Iterator iterator = f0.g(this.a).iterator();
            synchronized (list) {
                for (f0.f next : iterator) {
                    next.C();
                }
            }
        }
    }

    public interface f {
        public abstract void C();
    }

    class a implements com.iterable.iterableapi.v {

        final com.iterable.iterableapi.f0 a;
        a(com.iterable.iterableapi.f0 f0) {
            this.a = f0;
            super();
        }

        @Override // com.iterable.iterableapi.v
        public void a(String string) {
            String arrayList;
            JSONObject jSONObject;
            int length;
            int i;
            Object obj5;
            if (string != null && !string.isEmpty()) {
                if (!string.isEmpty()) {
                    arrayList = new ArrayList();
                    jSONObject = new JSONObject(string);
                    obj5 = jSONObject.optJSONArray("inAppMessages");
                    if (obj5 != null) {
                        jSONObject = 0;
                        while (jSONObject < obj5.length()) {
                            length = g0.d(obj5.optJSONObject(jSONObject), 0);
                            if (length != null) {
                            }
                            jSONObject++;
                            arrayList.add(length);
                        }
                        try {
                            f0.b(this.a, arrayList);
                            f0.c(this.a, z0.a());
                            string = string.toString();
                            j0.c("IterableInAppManager", string);
                            this.a.C();
                        }
                    }
                } else {
                }
            } else {
            }
        }
    }

    class b implements com.iterable.iterableapi.w {

        final com.iterable.iterableapi.w a;
        final com.iterable.iterableapi.g0 b;
        final com.iterable.iterableapi.f0 c;
        b(com.iterable.iterableapi.f0 f0, com.iterable.iterableapi.w w2, com.iterable.iterableapi.g0 g03) {
            this.c = f0;
            this.a = w2;
            this.b = g03;
            super();
        }

        @Override // com.iterable.iterableapi.w
        public void a(Uri uri) {
            com.iterable.iterableapi.w wVar = this.a;
            if (wVar != null) {
                wVar.a(uri);
            }
            final com.iterable.iterableapi.g0 g0Var = this.b;
            this.c.p(g0Var, uri);
            f0.e(this.c, z0.a());
            this.c.C();
        }
    }
    f0(com.iterable.iterableapi.j j, com.iterable.iterableapi.d0 d02, double d3) {
        b0 b0Var = new b0(j.t());
        a0 a0Var = new a0(i.l());
        super(j, d02, d3, obj4, b0Var, i.l(), a0Var);
    }

    f0(com.iterable.iterableapi.j j, com.iterable.iterableapi.d0 d02, double d3, com.iterable.iterableapi.h0 h04, com.iterable.iterableapi.i i5, com.iterable.iterableapi.a0 a06) {
        super();
        ArrayList arrayList = new ArrayList();
        this.z = arrayList;
        int i = 0;
        this.A = i;
        this.B = i;
        this.C = false;
        this.a = j;
        this.b = j.t();
        this.v = d02;
        this.y = d3;
        this.c = i5;
        this.w = obj9;
        this.x = a06;
        a06.j(this);
        I();
    }

    private void J(List<com.iterable.iterableapi.g0> list) {
        int next2;
        int i;
        Object next;
        boolean next3;
        int i2;
        int i3;
        String str;
        boolean z;
        HashMap hashMap = new HashMap();
        Iterator obj8 = list.iterator();
        next2 = 0;
        i = next2;
        i2 = 1;
        while (obj8.hasNext()) {
            next = obj8.next();
            hashMap.put((g0)next.i(), next);
            if (this.c.d(next.i()) != null) {
            } else {
            }
            i3 = next2;
            if (i3 == 0) {
            }
            if (i3 != 0) {
            }
            i2 = 1;
            i3 = this.c.d(next.i());
            if (!i3.r() && next.r()) {
            } else {
            }
            str = next2;
            if (str != null) {
            }
            i3.z(next.r());
            i = i2;
            if (next.r()) {
            } else {
            }
            str = i2;
            this.c.f(next);
            v(next);
            i = i2;
            i3 = i2;
        }
        obj8 = this.c.a().iterator();
        while (obj8.hasNext()) {
            next2 = obj8.next();
            if (!hashMap.containsKey((g0)next2.i())) {
            }
            this.c.b(next2);
            i = i2;
        }
        C();
        if (i != 0) {
            u();
        }
    }

    static void b(com.iterable.iterableapi.f0 f0, List list2) {
        f0.J(list2);
    }

    static long c(com.iterable.iterableapi.f0 f0, long l2) {
        f0.A = l2;
        return l2;
    }

    static long e(com.iterable.iterableapi.f0 f0, long l2) {
        f0.B = l2;
        return l2;
    }

    static void f(com.iterable.iterableapi.f0 f0) {
        f0.w();
    }

    static List g(com.iterable.iterableapi.f0 f0) {
        return f0.z;
    }

    private boolean i() {
        int i;
        i = Double.compare(d, d2) >= 0 ? 1 : 0;
        return i;
    }

    private List<com.iterable.iterableapi.g0> m(List<com.iterable.iterableapi.g0> list) {
        f0.c cVar = new f0.c(this);
        Collections.sort(list, cVar);
        return list;
    }

    private double n() {
        return d /= l3;
    }

    private void q(String string, com.iterable.iterableapi.g0 g02) {
        Object iN_APP;
        boolean obj2;
        if ("delete".equals(string)) {
            z(g02, z.DELETE_BUTTON, e0.IN_APP);
        }
    }

    private boolean s(com.iterable.iterableapi.g0 g0) {
        int i;
        long l;
        long time;
        int obj7;
        i = 0;
        if (g0.g() != null && Long.compare(l, time) > 0) {
            if (Long.compare(l, time) > 0) {
                i = 1;
            }
        }
        return i;
    }

    private boolean t() {
        return this.w.a();
    }

    private void v(com.iterable.iterableapi.g0 g0) {
        boolean z;
        if (!g0.r()) {
            this.a.Z(g0);
        }
    }

    private void w() {
        boolean iterator;
        boolean next;
        int i;
        int iMMEDIATE;
        com.iterable.iterableapi.d0.a sHOW;
        String str;
        if (this.x.m() && !t() && i()) {
            if (!t()) {
                if (i()) {
                    if (r()) {
                    } else {
                        j0.g();
                        List list = l();
                        m(list);
                        iterator = list.iterator();
                        while (iterator.hasNext()) {
                            next = iterator.next();
                            if (!(g0)next.q()) {
                                break;
                            } else {
                            }
                            if (!next.n()) {
                                break;
                            } else {
                            }
                            if (next.l() == g0.f.a.IMMEDIATE) {
                                break;
                            } else {
                            }
                            if (!next.r()) {
                                break;
                            } else {
                            }
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Calling onNewInApp on ");
                            stringBuilder.append(next.i());
                            String str4 = "IterableInAppManager";
                            j0.a(str4, stringBuilder.toString());
                            i = this.v.a(next);
                            StringBuilder stringBuilder2 = new StringBuilder();
                            stringBuilder2.append("Response: ");
                            stringBuilder2.append(i);
                            j0.a(str4, stringBuilder2.toString());
                            iMMEDIATE = 1;
                            next.y(iMMEDIATE);
                            if (i == d0.a.SHOW) {
                                break;
                            } else {
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.iterable.iterableapi.i$c
    void A(String string) {
        com.iterable.iterableapi.h0 h0Var;
        final com.iterable.iterableapi.g0 obj2 = this.c.d(string);
        synchronized (this) {
            try {
                this.c.b(obj2);
                u();
                throw string;
            }
        }
    }

    @Override // com.iterable.iterableapi.i$c
    void B() {
        Object next;
        com.iterable.iterableapi.h0 h0Var;
        j0.g();
        Iterator iterator = this.c.a().iterator();
        for (g0 next : iterator) {
            this.c.b(next);
        }
        u();
    }

    @Override // com.iterable.iterableapi.i$c
    void C() {
        boolean handler;
        com.iterable.iterableapi.f0.d dVar;
        long l;
        long l2;
        j0.g();
        if (i()) {
            w();
        } else {
            handler = new Handler(Looper.getMainLooper());
            dVar = new f0.d(this);
            handler.postDelayed(dVar, (long)i3);
        }
    }

    @Override // com.iterable.iterableapi.i$c
    public void D(boolean z) {
        this.C = z;
        if (!z) {
            C();
        }
    }

    @Override // com.iterable.iterableapi.i$c
    public void E(com.iterable.iterableapi.g0 g0, boolean z2) {
        g0.z(z2);
        u();
        return;
        synchronized (this) {
            g0.z(z2);
            u();
        }
    }

    @Override // com.iterable.iterableapi.i$c
    public void F(com.iterable.iterableapi.g0 g0, com.iterable.iterableapi.e0 e02) {
        int i;
        i = e02 == e0.IN_APP ? 1 : 0;
        H(g0, i, 0, e02);
    }

    @Override // com.iterable.iterableapi.i$c
    public void G(com.iterable.iterableapi.g0 g0, boolean z2, com.iterable.iterableapi.w w3) {
        H(g0, z2, w3, e0.IN_APP);
    }

    @Override // com.iterable.iterableapi.i$c
    public void H(com.iterable.iterableapi.g0 g0, boolean z2, com.iterable.iterableapi.w w3, com.iterable.iterableapi.e0 e04) {
        boolean obj5;
        f0.b bVar = new f0.b(this, w3, g0);
        obj5 = 1;
        E(g0, obj5);
        if (this.w.c(g0, e04, bVar) && z2) {
            obj5 = 1;
            E(g0, obj5);
            if (z2) {
                g0.t(obj5);
            }
        }
    }

    @Override // com.iterable.iterableapi.i$c
    void I() {
        j0.g();
        f0.a aVar = new f0.a(this);
        this.a.r(100, aVar);
    }

    @Override // com.iterable.iterableapi.i$c
    public void a() {
    }

    @Override // com.iterable.iterableapi.i$c
    public void d() {
        if (Long.compare(i, i2) > 0) {
            I();
        } else {
            C();
        }
    }

    @Override // com.iterable.iterableapi.i$c
    public void h(com.iterable.iterableapi.f0.f f0$f) {
        final List list = this.z;
        this.z.add(f);
        return;
        synchronized (list) {
            list = this.z;
            this.z.add(f);
        }
    }

    public List<com.iterable.iterableapi.g0> j() {
        Object next;
        boolean z;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.c.a().iterator();
        synchronized (this) {
            try {
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if (!(g0)next.n() && !s(next) && next.o()) {
                    }
                    if (!s(next)) {
                    }
                    if (next.o()) {
                    }
                    arrayList.add(next);
                }
                next = iterator.next();
                if (!(g0)next.n() && !s(next) && next.o()) {
                }
                if (!s(next)) {
                }
                if (next.o()) {
                }
                arrayList.add(next);
                return arrayList;
                throw th;
            }
        }
    }

    @Override // com.iterable.iterableapi.i$c
    com.iterable.iterableapi.g0 k(String string) {
        return this.c.d(string);
        synchronized (this) {
            return this.c.d(string);
        }
    }

    public List<com.iterable.iterableapi.g0> l() {
        Object next;
        boolean z;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.c.a().iterator();
        synchronized (this) {
            try {
                while (iterator.hasNext()) {
                    next = iterator.next();
                    if (!(g0)next.n() && !s(next)) {
                    }
                    if (!s(next)) {
                    }
                    arrayList.add(next);
                }
                next = iterator.next();
                if (!(g0)next.n() && !s(next)) {
                }
                if (!s(next)) {
                }
                arrayList.add(next);
                return arrayList;
                throw th;
            }
        }
    }

    @Override // com.iterable.iterableapi.i$c
    public int o() {
        int i;
        boolean z;
        i = 0;
        Iterator iterator = j().iterator();
        synchronized (this) {
            while (iterator.hasNext()) {
                if (!(g0)iterator.next().r()) {
                }
                i++;
            }
            return i;
        }
    }

    @Override // com.iterable.iterableapi.i$c
    public void p(com.iterable.iterableapi.g0 g0, Uri uri2) {
        boolean iN_APP;
        boolean startsWith;
        String str;
        Object obj4;
        Object obj5;
        j0.g();
        if (uri2 != null && !uri2.toString().isEmpty()) {
            if (!uri2.toString().isEmpty()) {
                obj5 = uri2.toString();
                String str2 = "action://";
                str = "";
                if (obj5.startsWith(str2)) {
                    g.a(this.b, e.a(obj5.replace(str2, str)), h.IN_APP);
                } else {
                    String str3 = "itbl://";
                    if (obj5.startsWith(str3)) {
                        g.a(this.b, e.a(obj5.replace(str3, str)), h.IN_APP);
                    } else {
                        iN_APP = "iterable://";
                        if (obj5.startsWith(iN_APP)) {
                            q(obj5.replace(iN_APP, str), g0);
                        } else {
                            g.a(this.b, e.b(obj5), h.IN_APP);
                        }
                    }
                }
            }
        }
    }

    @Override // com.iterable.iterableapi.i$c
    boolean r() {
        return this.C;
    }

    @Override // com.iterable.iterableapi.i$c
    public void u() {
        Handler handler = new Handler(Looper.getMainLooper());
        f0.e eVar = new f0.e(this);
        handler.post(eVar);
    }

    @Override // com.iterable.iterableapi.i$c
    public void x(com.iterable.iterableapi.f0.f f0$f) {
        final List list = this.z;
        this.z.remove(f);
        return;
        synchronized (list) {
            list = this.z;
            this.z.remove(f);
        }
    }

    @Override // com.iterable.iterableapi.i$c
    public void y(com.iterable.iterableapi.g0 g0) {
        g0.v(true);
        this.a.y(g0.i());
        u();
        return;
        synchronized (this) {
            g0.v(true);
            this.a.y(g0.i());
            u();
        }
    }

    @Override // com.iterable.iterableapi.i$c
    public void z(com.iterable.iterableapi.g0 g0, com.iterable.iterableapi.z z2, com.iterable.iterableapi.e0 e03) {
        j0.g();
        g0.v(true);
        this.a.x(g0, z2, e03);
        u();
        return;
        synchronized (this) {
            j0.g();
            g0.v(true);
            this.a.x(g0, z2, e03);
            u();
        }
    }
}
