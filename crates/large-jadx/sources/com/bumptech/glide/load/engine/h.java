package com.bumptech.glide.load.engine;

import android.os.Build.VERSION;
import android.util.Log;
import com.bumptech.glide.Registry;
import com.bumptech.glide.Registry.NoResultEncoderAvailableException;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.k;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.resource.bitmap.m;
import com.bumptech.glide.t.g;
import com.bumptech.glide.t.m.a.f;
import com.bumptech.glide.t.m.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: DecodeJob.java */
/* loaded from: classes.dex */
class h<R> implements f.a, Runnable, Comparable<h<?>>, a.f {

    private com.bumptech.glide.load.f A;
    private com.bumptech.glide.h B;
    private n C;
    private int D;
    private int E;
    private j F;
    private com.bumptech.glide.load.h G;
    private h.b<R> H;
    private int I;
    private h.h J;
    private h.g K;
    private long L;
    private boolean M;
    private Object N;
    private Thread O;
    private com.bumptech.glide.load.f P;
    private com.bumptech.glide.load.f Q;
    private Object R;
    private com.bumptech.glide.load.a S;
    private d<?> T;
    private volatile f U;
    private volatile boolean V;
    private volatile boolean W;
    private boolean X;
    private final g<R> a = new g<>();
    private final List<Throwable> b = new ArrayList<>();
    private final com.bumptech.glide.t.m.c c;
    private final h.e v;
    private final d.h.k.f<h<?>> w;
    private final h.d<?> x = new h$d<>();
    private final h.f y = new h$f();
    private com.bumptech.glide.e z;

    static class a {

        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;
        static final /* synthetic */ int[] c;
        static {
            int[] iArr = new int[c.values().length];
            h.a.c = iArr;
            int i2 = 1;
            try {
                iArr[c.SOURCE.ordinal()] = i2;
            } catch (java.lang.NoSuchFieldError unused) {
                int[] iArr5 = new int[h.h.values().length];
                h.a.b = iArr5;
                int i3 = 3;
                int[] iArr10 = new int[h.g.values().length];
                h.a.a = iArr10;
                return;
            }
            int i = 2;
            try {
                h.a.c[c.TRANSFORMED.ordinal()] = i;
            } catch (java.lang.NoSuchFieldError unused) {
                iArr10 = new int[h.g.values().length];
                h.a.a = iArr10;
                return;
            }
        }
    }

    interface b<R> {
        void a(GlideException exc);

        void c(u<R> uVar, com.bumptech.glide.load.a aVar, boolean z);

        void d(h<?> hVar);
    }

    private static class d<Z> {

        private com.bumptech.glide.load.f a;
        private k<Z> b;
        private t<Z> c;
        d() {
            super();
        }

        void a() {
            final com.bumptech.glide.load.f fVar = null;
            this.a = fVar;
            this.b = fVar;
            this.c = fVar;
        }

        void b(h.e eVar, com.bumptech.glide.load.h hVar) {
            b.a("DecodeJob.encode");
            try {
                eVar.a().a(this.a, new e(this.b, this.c, hVar));
            } finally {
                this.c.g();
                b.e();
                throw eVar;
            }
            this.c.g();
            b.e();
        }

        boolean c() {
            boolean z = true;
            int r0 = this.c != null ? 1 : 0;
            return (this.c != null ? 1 : 0);
        }

        <X> void d(com.bumptech.glide.load.f fVar, k<X> kVar, t<X> tVar) {
            this.a = fVar;
            this.b = kVar;
            this.c = tVar;
        }
    }

    interface e {
        com.bumptech.glide.load.engine.a0.a a();
    }

    private static class f {

        private boolean a;
        private boolean b;
        private boolean c;
        f() {
            super();
        }

        private boolean a(boolean z) {
            boolean z4 = true;
            if (this.c || !this.b || this.b) {
                z = this.a ? 1 : 0;
            }
            return (this.a ? 1 : 0);
        }

        synchronized boolean b() {
            this.b = true;
            return a(false);
        }

        synchronized boolean c() {
            this.c = true;
            return a(false);
        }

        synchronized boolean d(boolean z) {
            this.a = true;
            return a(z);
        }

        synchronized void e() {
            final boolean z = false;
            this.b = z;
            this.a = z;
            this.c = z;
        }
    }

    private enum g {

        DECODE_DATA,
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE;
    }

    private enum h {

        DATA_CACHE,
        ENCODE,
        FINISHED,
        INITIALIZE,
        RESOURCE_CACHE,
        SOURCE;
    }

    private final class c<Z> implements i.a<Z> {

        private final com.bumptech.glide.load.a a;
        final /* synthetic */ h b;
        c(com.bumptech.glide.load.a aVar) {
            this.b = hVar;
            super();
            this.a = aVar;
        }

        public u<Z> a(u<Z> uVar) {
            return this.b.A(this.a, uVar);
        }
    }
    h(h.e eVar, d.h.k.f<h<?>> fVar) {
        super();
        com.bumptech.glide.load.engine.g gVar = new g();
        ArrayList arrayList = new ArrayList();
        this.c = c.a();
        com.bumptech.glide.load.engine.h.d dVar = new h.d();
        fVar = new h.f();
        this.v = eVar;
        this.w = fVar;
    }

    private void C() {
        this.y.e();
        this.x.a();
        this.a.a();
        boolean z = false;
        this.V = z;
        final com.bumptech.glide.e eVar = null;
        this.z = eVar;
        this.A = eVar;
        this.G = eVar;
        this.B = eVar;
        this.C = eVar;
        this.H = eVar;
        this.J = eVar;
        this.U = eVar;
        this.O = eVar;
        this.P = eVar;
        this.R = eVar;
        this.S = eVar;
        this.T = eVar;
        this.L = 0L;
        this.W = z;
        this.N = eVar;
        this.b.clear();
        this.w.a(this);
    }

    private void D() {
        int i = 0;
        com.bumptech.glide.load.engine.h.h hVar2;
        this.O = Thread.currentThread();
        this.L = g.b();
        i = 0;
        while (!this.W) {
            this.J = p(this.J);
            this.U = o();
            if (this.J == h.h.SOURCE) {
                c();
                return;
            }
        }
        if (this.J == h.h.FINISHED || this.W) {
            if (this.U == 0) {
                x();
            }
        }
    }

    private <Data, ResourceType> u<R> E(Data data, com.bumptech.glide.load.a aVar, s<Data, ResourceType, R> sVar) {
        final com.bumptech.glide.load.data.e data2 = this.z.i().l(data);
        try {
        } finally {
            data.b();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) aVar;
        }
        data2.b();
        return sVar.a(data2, q(aVar), this.D, this.E, new h.c(this, aVar));
    }

    private void F() {
        int i2 = h.a.a[this.K.ordinal()];
        int i = 1;
        if (h.a.a != 1) {
            i = 2;
            if (h.a.a != 2) {
                i = 3;
                if (h.a.a != 3) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Unrecognized run reason: ";
                    r1 = str + this.K;
                    throw new IllegalStateException(r1);
                } else {
                    n();
                }
            }
            D();
        } else {
            this.J = p(h.h.INITIALIZE);
            this.U = o();
            D();
        }
    }

    private void G() {
        Throwable th = null;
        this.c.c();
        int i3 = 1;
        if (this.V) {
            if (this.b.isEmpty()) {
                int i2 = 0;
            } else {
                i = this.b.size() - i3;
                Object item = this.b.get(i);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.V = true;
    }

    private <Data> u<R> k(d<?> dVar, Data data, com.bumptech.glide.load.a aVar) {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            com.bumptech.glide.load.engine.u uVar = m(data, aVar);
            int i = 2;
            if (Log.isLoggable("DecodeJob", i)) {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Decoded result ";
                str3 = str + uVar;
                t(str3, g.b());
            }
        } finally {
            dVar.b();
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) data;
        }
        dVar.b();
        return uVar;
    }

    private <Data> u<R> m(Data data, com.bumptech.glide.load.a aVar) {
        return E(data, aVar, this.a.h(data.getClass()));
    }

    private void n() {
        d dVar;
        Object obj;
        int i2 = 2;
        if (Log.isLoggable("DecodeJob", i2)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = "data: ";
            String str5 = ", cache key: ";
            String str6 = ", fetcher: ";
            str = str4 + this.R + str5 + this.P + str6 + this.T;
            str2 = "Retrieved data";
            u(str2, this.L, str);
        }
        try {
            com.bumptech.glide.load.engine.u uVar = k(this.T, this.R, this.S);
        } catch (com.bumptech.glide.load.engine.GlideException glide) {
            glide.i(this.Q, this.S);
            this.Q.add(glide);
        }
        if (this.L != null) {
            w(uVar, this.S, this.X);
        } else {
            D();
        }
    }

    private f o() {
        int i = h.a.b[this.J.ordinal()];
        if (h.a.b != 1 && h.a.b != 2) {
            if (h.a.b != 3 && h.a.b == 4) {
                return null;
            }
            return new y(this.a, this);
        }
        return new v(this.a, this);
    }

    private h.h p(h.h hVar) {
        com.bumptech.glide.load.engine.h.h fINISHED2;
        com.bumptech.glide.load.engine.h.h rESOURCE_CACHE2;
        com.bumptech.glide.load.engine.h.h dATA_CACHE2;
        int i2 = h.a.b[hVar.ordinal()];
        if (h.a.b != 1 && h.a.b != 2) {
            int i = 3;
            if (h.a.b != 3 && h.a.b != 4 && h.a.b == 5) {
                if (this.F.b()) {
                    rESOURCE_CACHE2 = h.h.RESOURCE_CACHE;
                } else {
                    rESOURCE_CACHE2 = p(h.h.RESOURCE_CACHE);
                }
                return rESOURCE_CACHE2;
            }
            return h.h.FINISHED;
        }
        if (this.F.a()) {
            dATA_CACHE2 = h.h.DATA_CACHE;
        } else {
            dATA_CACHE2 = p(h.h.DATA_CACHE);
        }
        return dATA_CACHE2;
    }

    private com.bumptech.glide.load.h q(com.bumptech.glide.load.a aVar) {
        boolean z2 = false;
        if (Build.VERSION.SDK_INT < 26) {
            return this.G;
        }
        if (aVar != a.RESOURCE_DISK_CACHE) {
            if (this.a.x()) {
                int i3 = 1;
            } else {
                int i2 = 0;
            }
        }
        com.bumptech.glide.load.g gVar = m.i;
        Object obj = this.G.c(gVar);
        if (obj != null && obj.booleanValue() && this.a) {
            return this.G;
        }
        com.bumptech.glide.load.h hVar2 = new h();
        hVar2.d(this.G);
        hVar2.e(m.i, Boolean.valueOf(z2));
        return hVar2;
    }

    private int r() {
        return this.B.ordinal();
    }

    private void t(String str, long j) {
        u(str, j, null);
    }

    private void u(String str, long j, String str2) {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" in ");
        stringBuilder.append(g.a(j));
        stringBuilder.append(", load key: ");
        stringBuilder.append(this.C);
        if (str2 != null) {
            StringBuilder stringBuilder2 = new StringBuilder();
            str4 = ", ";
            str2 = str4 + str2;
        } else {
            str2 = "";
        }
        stringBuilder.append(str2);
        stringBuilder.append(", thread: ");
        stringBuilder.append(Thread.currentThread().getName());
        Log.v("DecodeJob", stringBuilder.toString());
    }

    private void v(u<R> uVar, com.bumptech.glide.load.a aVar, boolean z) {
        G();
        this.H.c(uVar, aVar, z);
    }

    private void w(u<R> uVar, com.bumptech.glide.load.a aVar, boolean z) {
        int i = 0;
        com.bumptech.glide.load.engine.t uVar2;
        b.a("DecodeJob.notifyEncodeAndRelease");
        try {
            z = uVar instanceof q;
            if (uVar instanceof q) {
                (q)uVar.initialize();
            }
            v(uVar2, aVar, z);
            this.J = h.h.ENCODE;
        } catch (Throwable th) {
        }
        try {
            if (this.x.c()) {
                this.x.b(this.v, this.G);
            }
        } catch (Throwable th) {
        }
        if ("DecodeJob.notifyEncodeAndRelease" != 0) {
            try {
                i.g();
                y();
            } catch (Throwable th) {
            }
            b.e();
            return;
        }
    }

    private void x() {
        G();
        this.H.a(new GlideException("Failed to load resource", new ArrayList(this.b)));
        z();
    }

    private void y() {
        if (this.y.b()) {
            C();
        }
    }

    private void z() {
        if (this.y.c()) {
            C();
        }
    }

    <Z> u<Z> A(com.bumptech.glide.load.a aVar, u<Z> uVar) throws Registry.NoResultEncoderAvailableException {
        com.bumptech.glide.load.engine.u uVar22;
        k kVar = null;
        com.bumptech.glide.load.engine.w aVar2;
        com.bumptech.glide.load.engine.z.b bVar;
        com.bumptech.glide.load.f fVar;
        int i5;
        com.bumptech.glide.load.f fVar2;
        int i6;
        int i7;
        l lVar;
        com.bumptech.glide.load.h hVar;
        com.bumptech.glide.load.c nONE2;
        final Class cls = uVar.get().getClass();
        if (aVar != a.RESOURCE_DISK_CACHE) {
            lVar = this.a.s(cls);
        } else {
            uVar22 = uVar;
        }
        if (!uVar.equals(uVar22)) {
            uVar.a();
        }
        if (this.a.w(uVar22)) {
            nONE2 = this.a.n(uVar22).b(this.G);
        } else {
            nONE2 = c.NONE;
        }
        int i3 = 1;
        i2 = this.a.y(this.P) ^ i3;
        if (this.F.d(i2, aVar, nONE2) && kVar != null) {
            int i9 = h.a.c[nONE2.ordinal()];
            if (h.a.c != i3) {
                if (h.a.c != 2) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str = "Unknown strategy: ";
                    uVar = str + nONE2;
                    throw new IllegalArgumentException(uVar);
                } else {
                    aVar2 = new w(this.a.b(), this.P, this.A, this.D, this.E, lVar, cls, this.G);
                    this.x.d(aVar2, kVar, t.d(uVar22));
                }
            }
            com.bumptech.glide.load.engine.d dVar = new d(this.P, this.A);
        }
        return uVar22;
    }

    void B(boolean z) {
        if (this.y.d(z)) {
            C();
        }
    }

    boolean H() {
        boolean z = false;
        com.bumptech.glide.load.engine.h.h rESOURCE_CACHE2;
        com.bumptech.glide.load.engine.h.h hVar = p(h.h.INITIALIZE);
        if (hVar == h.h.RESOURCE_CACHE || hVar == h.h.DATA_CACHE) {
            int i2 = 1;
        }
        return z;
    }

    public void a(com.bumptech.glide.load.f fVar, Exception exc, d<?> dVar, com.bumptech.glide.load.a aVar) {
        dVar.b();
        final com.bumptech.glide.load.engine.GlideException glideException = new GlideException("Fetching data failed", exc);
        glideException.j(fVar, aVar, dVar.a());
        this.b.add(glideException);
        if (Thread.currentThread() != this.O) {
            this.K = h.g.SWITCH_TO_SOURCE_SERVICE;
            this.H.d(this);
        } else {
            D();
        }
    }

    public void c() {
        this.K = h.g.SWITCH_TO_SOURCE_SERVICE;
        this.H.d(this);
    }

    public void e(com.bumptech.glide.load.f fVar, Object object, d<?> dVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.f fVar2) {
        int i = 0;
        this.P = fVar;
        this.R = object;
        this.T = dVar;
        this.S = aVar;
        this.Q = fVar2;
        i = 0;
        if (fVar != this.a.c().get(i)) {
            i = 1;
        }
        this.X = i;
        if (Thread.currentThread() != this.O) {
            this.K = h.g.DECODE_DATA;
            this.H.d(this);
        } else {
            b.a("DecodeJob.decodeFromRetrievedData");
            try {
                n();
            } finally {
                b.e();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) fVar;
            }
            b.e();
        }
    }

    public com.bumptech.glide.t.m.c f() {
        return this.c;
    }

    public void i() {
        this.W = true;
        if (this.U != null) {
            this.U.cancel();
        }
    }

    public int j(h<?> hVar) {
        int i;
        i = r() - hVar.r();
        if (this.r() - hVar.r() == 0) {
            i = this.I - hVar.I;
        }
        return i;
    }

    @Override // java.lang.Runnable
    public void run() {
        int eNCODE2;
        String str4;
        b.c("DecodeJob#run(reason=%s, model=%s)", this.K, this.N);
        try {
            x();
        } catch (Throwable th) {
        }
        try {
            F();
        } catch (Throwable th) {
        }
        if (this.T != null) {
            this.T.b();
        }
        b.e();
    }

    h<R> s(com.bumptech.glide.e eVar, Object object, n nVar, com.bumptech.glide.load.f fVar, int i, int i2, Class<?> cls, Class<R> cls2, com.bumptech.glide.h hVar, j jVar, Map<Class<?>, l<?>> map, boolean z, boolean z2, boolean z3, com.bumptech.glide.load.h hVar2, h.b<R> bVar, int i3) {
        final Object eVar3 = this;
        eVar3.a.v(eVar, object, fVar, i, i2, jVar, cls, cls2, hVar, hVar2, map, z, z2, eVar3.v);
        eVar3.z = eVar;
        eVar3.A = fVar;
        eVar3.B = hVar;
        eVar3.C = nVar;
        eVar3.D = i;
        eVar3.E = i2;
        eVar3.F = jVar;
        eVar3.M = z3;
        eVar3.G = hVar2;
        eVar3.H = bVar;
        eVar3.I = i3;
        eVar3.K = h.g.INITIALIZE;
        eVar3.N = object;
        return eVar3;
    }
}
