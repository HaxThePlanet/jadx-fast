package com.bumptech.glide.r;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.f;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.k.d;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.t.l;
import com.bumptech.glide.t.m.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: SingleRequest.java */
/* loaded from: classes.dex */
public final class i<R> implements d, com.bumptech.glide.r.k.g, h {

    private static final boolean E = false;
    private int A;
    private int B;
    private boolean C;
    private RuntimeException D;
    private int a;
    private final String b;
    private final c c;
    private final Object d;
    private final f<R> e;
    private final e f;
    private final Context g;
    private final com.bumptech.glide.e h;
    private final Object i;
    private final Class<R> j;
    private final a<?> k;
    private final int l;
    private final int m;
    private final com.bumptech.glide.h n;
    private final com.bumptech.glide.r.k.h<R> o;
    private final List<f<R>> p;
    private final com.bumptech.glide.r.l.e<? super R> q;
    private final Executor r;
    private u<R> s;
    private k.d t;
    private long u;
    private volatile k v;
    private i.a w;
    private Drawable x;
    private Drawable y;
    private Drawable z;

    private enum a {

        CLEARED,
        COMPLETE,
        FAILED,
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE;
    }
    static {
        i.E = Log.isLoggable("GlideRequest", 2);
    }

    private i(Context context, com.bumptech.glide.e eVar, Object object, Object object2, Class<R> cls, a<?> aVar, int i, int i2, com.bumptech.glide.h hVar, com.bumptech.glide.r.k.h<R> hVar2, f<R> fVar, List<f<R>> list, e eVar2, k kVar, com.bumptech.glide.r.l.e<? super R> eVar3, Executor executor) {
        String str = null;
        final Object context3 = this;
        super();
        if (i.E) {
            str = String.valueOf(super.hashCode());
        } else {
            i2 = 0;
        }
        context3.b = str;
        context3.c = c.a();
        context3.d = object;
        context3.g = context;
        context3.h = eVar;
        context3.i = object2;
        context3.j = cls;
        context3.k = aVar;
        context3.l = i;
        context3.m = i2;
        context3.n = hVar;
        context3.o = hVar2;
        context3.e = fVar;
        context3.p = list;
        context3.f = eVar2;
        context3.v = kVar;
        context3.q = eVar3;
        context3.r = executor;
        context3.w = i.a.PENDING;
        if (context3.D == null) {
            runtimeException = d.d.class;
            if (eVar.g().a(runtimeException)) {
                context3.D = new RuntimeException("Glide request origin trace");
            }
        }
    }

    private void A(GlideException exc, int i) {
        boolean hasNext;
        Object obj;
        com.bumptech.glide.r.k.h hVar;
        boolean z;
        boolean onLoadFailed2;
        int i4 = 1;
        this.c.c();
        synchronized (obj3) {
            try {
                exc.k(this.D);
                int i5 = this.h.h();
                if (i5 <= i) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str3 = "Load failed for ";
                    String str4 = " with size [";
                    String str5 = "x";
                    str2 = "]";
                    str = str3 + this.i + str4 + this.A + str5 + this.B + str2;
                    Log.w("Glide", str, exc);
                    int i3 = 4;
                    if (i5 <= 4) {
                        exc.g("Glide");
                    }
                }
            } catch (Throwable unused) {
            }
            boolean z3 = false;
            try {
                if (this.p != null) {
                    Iterator it = this.p.iterator();
                    i = z3;
                    while (it.hasNext()) {
                        i = i | (f)it.next().onLoadFailed(exc, this.i, this.o, t());
                    }
                } else {
                    i = z3;
                }
                if (this.e != null) {
                    if (!(this.e.onLoadFailed(exc, this.i, this.o, t()))) {
                        i4 = z3;
                    }
                }
                if (i | i4 == 0) {
                    C();
                }
            } catch (Throwable unused) {
            }
            try {
                this.C = z3;
                x();
                b.f("GlideRequest", this.a);
                return;
            } finally {
                this.C = z2;
                throw exc;
            }
            throw exc;
        }
    }

    private void B(u<R> uVar, R r, a aVar, boolean z) {
        com.bumptech.glide.r.f fVar;
        Object r22;
        Object obj;
        com.bumptech.glide.r.k.h hVar;
        boolean z42;
        int i2;
        int i4 = 1;
        z42 = t();
        this.w = i.a.COMPLETE;
        this.s = uVar;
        int i = 3;
        if (this.h.h() <= 3) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Finished loading ";
            String simpleName = r.getClass().getSimpleName();
            String str2 = " from ";
            String str3 = " for ";
            String str4 = " with size [";
            String str5 = "x";
            String str6 = "] in ";
            double d = g.a(this.u);
            String str7 = " ms";
            str9 = str + simpleName + str2 + aVar + str3 + this.i + str4 + this.A + str5 + this.B + str6 + d + str7;
            Log.d("Glide", str9);
        }
        this.C = true;
        final boolean z2 = false;
        try {
            if (this.p != null) {
                Iterator it = this.p.iterator();
                i2 = z2;
                while (it.hasNext()) {
                    i2 = i2 | (f)it.next().onResourceReady(r, this.i, this.o, aVar, z42);
                }
            } else {
                i2 = z2;
            }
            if (this.e != null) {
                if (!(this.e.onResourceReady(r, this.i, this.o, aVar, z42))) {
                    i4 = z2;
                }
            }
            i5 = i4 | i2;
            if (i4 | i2 == 0) {
                this.o.onResourceReady(r, this.q.a(aVar, z42));
            }
        } finally {
            this.C = z;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) uVar;
        }
        this.C = z2;
        y();
        b.f("GlideRequest", this.a);
    }

    private void C() {
        int i = 0;
        Drawable drawable;
        if (!m()) {
            return;
        }
        i = 0;
        if (this.i == null) {
            Drawable drawable2 = r();
        }
        if (i == 0) {
            Drawable drawable3 = q();
        }
        if (i == 0) {
            drawable = s();
        }
        this.o.onLoadFailed(drawable);
    }

    private void j() {
        if (this.C) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    private boolean l() {
        boolean z2 = false;
        if (this.f == null || this.f.l(this)) {
            int i2 = 1;
        }
        return z2;
    }

    private boolean m() {
        boolean z2 = false;
        if (this.f == null || this.f.f(this)) {
            int i2 = 1;
        }
        return z2;
    }

    private boolean n() {
        boolean z2 = false;
        if (this.f == null || this.f.h(this)) {
            int i2 = 1;
        }
        return z2;
    }

    private void o() {
        j();
        this.c.c();
        this.o.removeCallback(this);
        if (this.t != null) {
            this.t.a();
            k.d dVar = null;
            this.t = dVar;
        }
    }

    private void p(Object object) {
        if (this.p == null) {
            return;
        }
        Iterator it = this.p.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            z = item instanceof c;
        }
    }

    private Drawable q() {
        if (this.x == null) {
            Drawable drawable = this.k.r();
            this.x = drawable;
            if (drawable == null) {
                if (this.k.p() > 0) {
                    this.x = u(this.k.p());
                }
            }
        }
        return this.x;
    }

    private Drawable r() {
        if (this.z == null) {
            Drawable drawable = this.k.s();
            this.z = drawable;
            if (drawable == null) {
                if (this.k.t() > 0) {
                    this.z = u(this.k.t());
                }
            }
        }
        return this.z;
    }

    private Drawable s() {
        if (this.y == null) {
            Drawable drawable = this.k.y();
            this.y = drawable;
            if (drawable == null) {
                if (this.k.z() > 0) {
                    this.y = u(this.k.z());
                }
            }
        }
        return this.y;
    }

    private boolean t() {
        boolean z2 = false;
        if (this.f != null) {
            if (!this.f.c().b()) {
                int i2 = 1;
            } else {
                int i = 0;
            }
        }
        return z2;
    }

    private Drawable u(int i) {
        android.content.res.Resources.Theme theme;
        if (this.k.E() != null) {
            theme = this.k.E();
        } else {
            theme = this.g.getTheme();
        }
        return b.a(this.h, i, theme);
    }

    private void v(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = " this: ";
        str5 = str + str3 + this.b;
        Log.v("GlideRequest", str5);
    }

    private static int w(int i, float f) {
        int rounded;
        if (i != -2147483648) {
            f = f * (float)i;
            rounded = Math.round(f);
        }
        return rounded;
    }

    private void x() {
        if (this.f != null) {
            this.f.a(this);
        }
    }

    private void y() {
        if (this.f != null) {
            this.f.j(this);
        }
    }

    public static <R> i<R> z(Context context, com.bumptech.glide.e eVar, Object object, Object object2, Class<R> cls, a<?> aVar, int i, int i2, com.bumptech.glide.h hVar, com.bumptech.glide.r.k.h<R> hVar2, f<R> fVar, List<f<R>> list, e eVar2, k kVar, com.bumptech.glide.r.l.e<? super R> eVar3, Executor executor) {
        i iVar = new i(context, eVar, object, object2, cls, aVar, i, i2, hVar, hVar2, fVar, list, eVar2, kVar, eVar3, executor);
        return iVar;
    }

    public void a(GlideException exc) {
        A(exc, 5);
    }

    public boolean b() {
        boolean z = false;
        synchronized (obj2) {
            try {
                Throwable th = this.w == i.a.COMPLETE ? 1 : 0;
                return (this.w == i.a.COMPLETE ? 1 : 0);
            } catch (Throwable th) {
            }
            throw (this.w == i.a.COMPLETE ? 1 : 0);
        }
    }

    public void c(u<?> uVar, a aVar, boolean z) {
        String str;
        String str2;
        this.c.c();
        k.d dVar = null;
        synchronized (obj2) {
            try {
                this.t = dVar;
                if (uVar == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str9 = "Expected to receive a Resource<R> with an object of ";
                    String str10 = " inside, but instead got null.";
                    aVar = str9 + this.j + str10;
                    a(new GlideException(aVar));
                    return;
                }
                final Object obj3 = uVar.get();
            } catch (Throwable th) {
            }
            try {
                this.s = dVar;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Expected to receive an object of ");
                stringBuilder2.append(this.j);
                stringBuilder2.append(" but instead got ");
                if (obj3 != null) {
                    Class cls3 = obj3.getClass();
                } else {
                    str = "";
                }
                stringBuilder2.append(str);
                stringBuilder2.append("{");
                stringBuilder2.append(obj3);
                stringBuilder2.append("} inside Resource{");
                stringBuilder2.append(th);
                stringBuilder2.append("}.");
                u uVar2 = obj3 != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.";
                stringBuilder2.append((obj3 != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data."));
                GlideException glideException = new GlideException(this.j.toString());
                a(glideException);
            } catch (Throwable th) {
                uVar2 = th;
            }
            if (th != null) {
                this.v.k(th);
            }
            return;
        }
        if (th != null) {
            this.v.k(th);
        }
    }

    public void clear() {
        u uVar;
        synchronized (obj) {
            try {
                j();
                this.c.c();
                final com.bumptech.glide.r.i.a cLEARED2 = i.a.CLEARED;
                if (this.w == i.a.CLEARED) {
                    return;
                }
                this.s = uVar;
                if (l()) {
                    this.o.onLoadCleared(s());
                }
                b.f("GlideRequest", this.a);
                this.w = i.a.CLEARED;
            } catch (Throwable th) {
            }
        }
        if (this.w != null) {
            this.v.k(uVar);
        }
    }

    public void d() {
        synchronized (obj2) {
            try {
                if (isRunning()) {
                    clear();
                }
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public boolean e(d dVar) {
        int size = 0;
        int i;
        boolean z3 = false;
        int size2;
        final Object dVar3 = this;
        Object dVar2 = dVar;
        size2 = 0;
        if (!(dVar2 instanceof i)) {
            return false;
        }
        synchronized (obj2) {
            try {
                if (dVar3.p != null) {
                    size2 = dVar3.p.size();
                } else {
                }
            } catch (Throwable th) {
            }
        }
        synchronized (obj5) {
            try {
                if (dVar2.p != null) {
                    size = dVar2.p.size();
                } else {
                    size = 0;
                }
            } catch (Throwable th) {
            }
        }
        int r3 = dVar3.l == dVar2.l && dVar3.m == dVar2.m && l.b(dVar3.i, dVar2.i) && dVar3.j.equals(dVar2.j) && dVar3.k.equals(dVar2.k) && dVar3.n == dVar2.n && dVar3.p == dVar2.p ? 1 : 0;
        return (dVar3.l == dVar2.l && dVar3.m == dVar2.m && l.b(dVar3.i, dVar2.i) && dVar3.j.equals(dVar2.j) && dVar3.k.equals(dVar2.k) && dVar3.n == dVar2.n && dVar3.p == dVar2.p ? 1 : 0);
    }

    public void f(int i, int i2) {
        com.bumptech.glide.r.i.a aVar = null;
        Object obj5;
        Object i10 = this;
        i10.c.c();
        synchronized (obj) {
            try {
                boolean z = i.E;
                if (i.E) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    String str6 = "Got onSizeReady in ";
                    double d = g.a(i10.u);
                    str = str6 + d;
                    i10.v(str);
                }
                if (i10.w != i.a.WAITING_FOR_SIZE) {
                    return;
                }
                com.bumptech.glide.r.i.a rUNNING2 = i.a.RUNNING;
                i10.w = rUNNING2;
                float f = i10.k.D();
                i10.A = i.w(i, f);
                i10.B = i.w(i2, f);
                if (i.E) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    String str4 = "finished setup for calling load in ";
                    double d2 = g.a(i10.u);
                    str3 = str4 + d2;
                    i10.v(str3);
                }
            } catch (Throwable unused) {
            }
            try {
            } catch (Throwable unused) {
            }
            com.bumptech.glide.r.h i6 = this;
            try {
                i6.t = i10.v.f(i10.h, i10.i, i10.k.C(), i10.A, i10.B, i10.k.B(), i10.j, i10.n, i10.k.o(), i10.k.F(), i10.k.P(), i10.k.L(), i3, i22, z2, z3, z4, this, executor);
                if (i6.w != rUNNING2) {
                    i6.t = null;
                }
                if (z) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String str5 = "finished onSizeReady in ";
                    double d3 = g.a(i6.u);
                    str2 = str5 + d3;
                    i6.v(str2);
                }
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public boolean g() {
        boolean z = false;
        synchronized (obj2) {
            try {
                Throwable th = this.w == i.a.CLEARED ? 1 : 0;
                return (this.w == i.a.CLEARED ? 1 : 0);
            } catch (Throwable th) {
            }
            throw (this.w == i.a.CLEARED ? 1 : 0);
        }
    }

    public Object h() {
        this.c.c();
        return this.d;
    }

    public void i() {
        int i = 3;
        com.bumptech.glide.r.i.a aVar;
        synchronized (obj2) {
            try {
                j();
                this.c.c();
                this.u = g.b();
                if (this.i == null) {
                    if (l.t(this.l, this.m)) {
                        this.A = this.l;
                        this.B = this.m;
                    }
                    Throwable th = r() == null ? 5 : 3;
                    A(new GlideException("Received null model"), (r() == null ? 5 : 3));
                    return;
                }
                com.bumptech.glide.r.i.a rUNNING2 = i.a.RUNNING;
                if (this.w == i.a.RUNNING) {
                    throw new IllegalArgumentException("Cannot restart a running request");
                } else {
                    if (this.w == i.a.COMPLETE) {
                        c(this.s, a.MEMORY_CACHE, false);
                        return;
                    }
                    p(this.i);
                    this.a = b.b("GlideRequest");
                    wAITING_FOR_SIZE2 = i.a.WAITING_FOR_SIZE;
                    this.w = wAITING_FOR_SIZE2;
                    if (l.t(this.l, this.m)) {
                        f(this.l, this.m);
                    } else {
                        this.o.getSize(this);
                    }
                    if (this.w == i.a.RUNNING || this.w == i.a.WAITING_FOR_SIZE) {
                        if (m()) {
                            this.o.onLoadStarted(s());
                        }
                    }
                    if (i.E) {
                        StringBuilder stringBuilder = new StringBuilder();
                        String str3 = "finished run method in ";
                        double d = g.a(this.u);
                        str2 = str3 + d;
                        v(str2);
                    }
                    return;
                }
            } catch (Throwable th) {
            }
            throw (r() == null ? 5 : 3);
        }
    }

    public boolean isRunning() {
        boolean z = true;
        com.bumptech.glide.r.i.a rUNNING2;
        synchronized (obj2) {
            try {
                if (this.w == i.a.RUNNING || this.w == i.a.WAITING_FOR_SIZE) {
                    int i = 1;
                }
                return z;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    public boolean k() {
        boolean z = false;
        synchronized (obj2) {
            try {
                Throwable th = this.w == i.a.COMPLETE ? 1 : 0;
                return (this.w == i.a.COMPLETE ? 1 : 0);
            } catch (Throwable th) {
            }
            throw (this.w == i.a.COMPLETE ? 1 : 0);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        synchronized (obj2) {
            try {
            } catch (Throwable th) {
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String object = super.toString();
        String str4 = "[model=";
        String str2 = ", transcodeClass=";
        String str3 = "]";
        str = object + str4 + this.i + str2 + this.j + str3;
        return str;
    }
}
