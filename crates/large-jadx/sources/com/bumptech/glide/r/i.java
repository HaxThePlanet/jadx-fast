package com.bumptech.glide.r;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.e;
import com.bumptech.glide.f;
import com.bumptech.glide.h;
import com.bumptech.glide.load.a;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.k;
import com.bumptech.glide.load.engine.k.d;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.n.e.b;
import com.bumptech.glide.r.k.g;
import com.bumptech.glide.r.k.h;
import com.bumptech.glide.r.l.e;
import com.bumptech.glide.t.g;
import com.bumptech.glide.t.l;
import com.bumptech.glide.t.m.b;
import com.bumptech.glide.t.m.c;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class i<R>  implements com.bumptech.glide.r.d, g, com.bumptech.glide.r.h {

    private static final boolean E;
    private int A;
    private int B;
    private boolean C;
    private RuntimeException D;
    private int a;
    private final String b;
    private final c c;
    private final Object d;
    private final com.bumptech.glide.r.f<R> e;
    private final com.bumptech.glide.r.e f;
    private final Context g;
    private final e h;
    private final Object i;
    private final Class<R> j;
    private final com.bumptech.glide.r.a<?> k;
    private final int l;
    private final int m;
    private final h n;
    private final h<R> o;
    private final List<com.bumptech.glide.r.f<R>> p;
    private final e<? super R> q;
    private final Executor r;
    private u<R> s;
    private k.d t;
    private long u;
    private volatile k v;
    private com.bumptech.glide.r.i.a w;
    private Drawable x;
    private Drawable y;
    private Drawable z;

    private static enum a {

        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED;
    }
    static {
        i.E = Log.isLoggable("GlideRequest", 2);
    }

    private i(Context context, e e2, Object object3, Object object4, Class<R> class5, com.bumptech.glide.r.a<?> a6, int i7, int i8, h h9, h<R> h10, com.bumptech.glide.r.f<R> f11, List<com.bumptech.glide.r.f<R>> list12, com.bumptech.glide.r.e e13, k k14, e<? super R> e15, Executor executor16) {
        String valueOf;
        e runtimeException;
        RuntimeException str;
        final Object obj = this;
        super();
        if (i.E) {
            valueOf = String.valueOf(super.hashCode());
        } else {
            valueOf = 0;
        }
        obj.b = valueOf;
        obj.c = c.a();
        obj.d = object3;
        obj.g = context;
        obj.h = e2;
        obj.i = object4;
        obj.j = class5;
        obj.k = a6;
        obj.l = i7;
        obj.m = i8;
        obj.n = h9;
        obj.o = h10;
        obj.e = f11;
        obj.p = list12;
        obj.f = e13;
        obj.v = k14;
        obj.q = e15;
        obj.r = executor16;
        obj.w = i.a.PENDING;
        if (obj.D == null && e2.g().a(d.d.class)) {
            if (e2.g().a(d.d.class)) {
                runtimeException = new RuntimeException("Glide request origin trace");
                obj.D = runtimeException;
            }
        }
    }

    private void A(GlideException glideException, int i2) {
        String string;
        Object iterator;
        String str;
        int i;
        boolean onLoadFailed;
        Object obj;
        h hVar;
        boolean z;
        Throwable obj9;
        int obj10;
        this.c.c();
        Object obj2 = this.d;
        glideException.k(this.D);
        int i3 = this.h.h();
        synchronized (obj2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Load failed for ");
            stringBuilder.append(this.i);
            stringBuilder.append(" with size [");
            stringBuilder.append(this.A);
            stringBuilder.append("x");
            stringBuilder.append(this.B);
            stringBuilder.append("]");
            Log.w("Glide", stringBuilder.toString(), glideException);
            if (i3 <= 4) {
                glideException.g("Glide");
            }
            this.t = 0;
            this.w = i.a.FAILED;
            this.C = true;
            int i4 = 0;
            iterator = this.p;
            if (iterator != null) {
                iterator = iterator.iterator();
                i = i4;
                for (f next : iterator) {
                    i |= onLoadFailed;
                }
            } else {
                i = i4;
            }
            try {
                com.bumptech.glide.r.f fVar = this.e;
                if (fVar != null && fVar.onLoadFailed(glideException, this.i, this.o, t())) {
                } else {
                }
                if (fVar.onLoadFailed(glideException, this.i, this.o, t())) {
                } else {
                }
                obj10 = i4;
                if (i | obj10 == 0) {
                }
                C();
                this.C = i4;
                x();
                b.f("GlideRequest", this.a);
                this.C = obj1;
                throw glideException;
                throw glideException;
            } catch (Throwable th) {
            }
        }
    }

    private void B(u<R> u, R r2, a a3, boolean z4) {
        int str;
        boolean onResourceReady2;
        com.bumptech.glide.r.f onResourceReady;
        long l;
        Object obj;
        h hVar;
        Object obj2;
        boolean z;
        Iterator iterator;
        int i;
        int obj10;
        Object obj12;
        final boolean obj13 = t();
        this.w = i.a.COMPLETE;
        this.s = u;
        if (this.h.h() <= 3) {
            obj10 = new StringBuilder();
            obj10.append("Finished loading ");
            obj10.append(r2.getClass().getSimpleName());
            obj10.append(" from ");
            obj10.append(a3);
            obj10.append(" for ");
            obj10.append(this.i);
            obj10.append(" with size [");
            obj10.append(this.A);
            obj10.append("x");
            obj10.append(this.B);
            obj10.append("] in ");
            obj10.append(g.a(this.u));
            obj10.append(" ms");
            Log.d("Glide", obj10.toString());
        }
        this.C = true;
        final int i4 = 0;
        onResourceReady2 = this.p;
        if (onResourceReady2 != null) {
            iterator = onResourceReady2.iterator();
            i = i4;
            for (f next : iterator) {
                i |= onResourceReady2;
            }
        } else {
            i = i4;
        }
        onResourceReady = this.e;
        if (onResourceReady != null && onResourceReady.onResourceReady(r2, this.i, this.o, a3, obj13)) {
            if (onResourceReady.onResourceReady(r2, this.i, this.o, a3, obj13)) {
            } else {
                obj10 = i4;
            }
        } else {
        }
        if (obj10 |= i == 0) {
            this.o.onResourceReady(r2, this.q.a(a3, obj13));
        }
        this.C = i4;
        y();
        b.f("GlideRequest", this.a);
    }

    private void C() {
        int i;
        if (!m()) {
        }
        i = 0;
        if (this.i == null) {
            i = r();
        }
        if (i == 0) {
            i = q();
        }
        if (i == 0) {
            i = s();
        }
        this.o.onLoadFailed(i);
    }

    private void j() {
        if (this.C) {
        } else {
        }
        IllegalStateException illegalStateException = new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        throw illegalStateException;
    }

    private boolean l() {
        int i;
        com.bumptech.glide.r.e eVar;
        eVar = this.f;
        if (eVar != null) {
            if (eVar.l(this)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private boolean m() {
        int i;
        com.bumptech.glide.r.e eVar;
        eVar = this.f;
        if (eVar != null) {
            if (eVar.f(this)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private boolean n() {
        int i;
        com.bumptech.glide.r.e eVar;
        eVar = this.f;
        if (eVar != null) {
            if (eVar.h(this)) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private void o() {
        k.d dVar;
        j();
        this.c.c();
        this.o.removeCallback(this);
        dVar = this.t;
        if (dVar != null) {
            dVar.a();
            this.t = 0;
        }
    }

    private void p(Object object) {
        Object next;
        boolean z;
        List list = this.p;
        if (list == null) {
        }
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (next instanceof c) {
            }
            (c)(f)next.a(object);
        }
    }

    private Drawable q() {
        Drawable drawable;
        drawable = this.k.r();
        this.x = drawable;
        if (this.x == null && drawable == null && this.k.p() > 0) {
            drawable = this.k.r();
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
        Drawable drawable;
        drawable = this.k.s();
        this.z = drawable;
        if (this.z == null && drawable == null && this.k.t() > 0) {
            drawable = this.k.s();
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
        Drawable drawable;
        drawable = this.k.y();
        this.y = drawable;
        if (this.y == null && drawable == null && this.k.z() > 0) {
            drawable = this.k.y();
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
        int i;
        com.bumptech.glide.r.e eVar;
        eVar = this.f;
        if (eVar != null) {
            if (!eVar.c().b()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
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

    private void v(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" this: ");
        stringBuilder.append(this.b);
        Log.v("GlideRequest", stringBuilder.toString());
    }

    private static int w(int i, float f2) {
        int obj1;
        int obj2;
        if (i == Integer.MIN_VALUE) {
        } else {
            obj1 = Math.round(f2 *= obj1);
        }
        return obj1;
    }

    private void x() {
        final com.bumptech.glide.r.e eVar = this.f;
        if (eVar != null) {
            eVar.a(this);
        }
    }

    private void y() {
        final com.bumptech.glide.r.e eVar = this.f;
        if (eVar != null) {
            eVar.j(this);
        }
    }

    public static <R> com.bumptech.glide.r.i<R> z(Context context, e e2, Object object3, Object object4, Class<R> class5, com.bumptech.glide.r.a<?> a6, int i7, int i8, h h9, h<R> h10, com.bumptech.glide.r.f<R> f11, List<com.bumptech.glide.r.f<R>> list12, com.bumptech.glide.r.e e13, k k14, e<? super R> e15, Executor executor16) {
        super(context, e2, object3, object4, class5, a6, i7, i8, h9, h10, f11, list12, e13, k14, e15, executor16);
        return iVar2;
    }

    @Override // com.bumptech.glide.r.d
    public void a(GlideException glideException) {
        A(glideException, 5);
    }

    @Override // com.bumptech.glide.r.d
    public boolean b() {
        int i;
        final Object obj = this.d;
        synchronized (obj) {
            i = 1;
            try {
                return i;
                throw th;
            }
        }
    }

    public void c(u<?> u, a a2, boolean z3) {
        Object class;
        String str;
        boolean assignableFrom;
        Class class2;
        Object obj7;
        this.c.c();
        int i = 0;
        final Object obj = this.d;
        this.t = i;
        synchronized (obj) {
            obj7 = new StringBuilder();
            obj7.append("Expected to receive a Resource<R> with an object of ");
            obj7.append(this.j);
            obj7.append(" inside, but instead got null.");
            GlideException obj6 = new GlideException(obj7.toString());
            a(obj6);
        }
        this.v.k(u);
    }

    @Override // com.bumptech.glide.r.d
    public void clear() {
        Object obj;
        u uVar;
        boolean z;
        Drawable drawable;
        obj = this.d;
        j();
        this.c.c();
        final com.bumptech.glide.r.i.a cLEARED = i.a.CLEARED;
        synchronized (obj) {
        }
        this.v.k(uVar);
    }

    @Override // com.bumptech.glide.r.d
    public void d() {
        final Object obj = this.d;
        synchronized (obj) {
            clear();
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean e(com.bumptech.glide.r.d d) {
        int size2;
        boolean equals;
        int i;
        int size;
        final Object obj2 = this;
        Object obj = d;
        int i2 = 0;
        if (!obj instanceof i) {
            return i2;
        }
        Object obj3 = obj2.d;
        List list2 = obj2.p;
        synchronized (obj3) {
            size = list2.size();
            final Object obj5 = obj.d;
            List list = obj.p;
            synchronized (obj5) {
                obj5 = obj.d;
                list = obj.p;
            }
        }
        size2 = list.size();
        if (obj2.l == obj.l && obj2.m == obj.m && l.b(obj2.i, obj.i) && obj2.j.equals(obj.j) && obj2.k.equals(obj.k) && obj2.n == obj.n && size == size2) {
            if (obj2.m == obj.m) {
                if (l.b(obj4, obj6)) {
                    if (cls.equals(cls2)) {
                        if (aVar.equals(aVar2)) {
                            try {
                                if (obj2.n == obj.n) {
                                } else {
                                }
                                if (size == size2) {
                                } else {
                                }
                                i = 1;
                                i = 0;
                                return i;
                                throw th;
                                throw th;
                            } catch (Throwable th) {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
    }

    @Override // com.bumptech.glide.r.d
    public void f(int i, int i2) {
        com.bumptech.glide.r.i.a string2;
        String string;
        int string3;
        double d;
        int i3;
        com.bumptech.glide.r.i.a aVar;
        Object obj5;
        Object obj4 = this;
        obj4.c.c();
        Object obj3 = obj4.d;
        boolean z = i.E;
        synchronized (obj3) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Got onSizeReady in ");
            stringBuilder3.append(g.a(obj4.u));
            obj4.v(stringBuilder3.toString());
            if (obj4.w != i.a.WAITING_FOR_SIZE) {
            }
            com.bumptech.glide.r.i.a rUNNING = i.a.RUNNING;
            obj4.w = rUNNING;
            float f = obj4.k.D();
            obj4.A = i.w(i, f);
            obj4.B = i.w(i2, f);
            if (z) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("finished setup for calling load in ");
                stringBuilder2.append(g.a(obj4.u));
                obj4.v(stringBuilder2.toString());
            }
            final Object obj2 = obj4.i;
            Object obj = this;
            obj.t = obj4.v.f(obj4.h, obj2, obj4.k.C(), obj4.A, obj4.B, obj4.k.B(), obj4.j, obj4.n, obj4.k.o(), obj4.k.F(), obj4.k.P(), obj4.k.L(), obj4.k.v(), obj4.k.J(), obj4.k.H(), obj4.k.G(), obj4.k.u(), this, obj4.r);
            if (obj.w != rUNNING) {
                obj.t = 0;
            }
            if (z) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("finished onSizeReady in ");
                stringBuilder.append(g.a(obj.u));
                obj.v(stringBuilder.toString());
            }
            try {
                string = this;
                string = obj15;
                throw th;
            } catch (Throwable th) {
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean g() {
        int i;
        final Object obj = this.d;
        synchronized (obj) {
            i = 1;
            try {
                return i;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public Object h() {
        this.c.c();
        return this.d;
    }

    @Override // com.bumptech.glide.r.d
    public void i() {
        boolean z;
        int i;
        com.bumptech.glide.r.i.a wAITING_FOR_SIZE;
        boolean string;
        int i2;
        Object aVar;
        int i3;
        final Object obj = this.d;
        j();
        this.c.c();
        this.u = g.b();
        Object obj2 = this.i;
        synchronized (obj) {
            if (l.t(this.l, this.m)) {
                this.A = this.l;
                this.B = this.m;
            }
            try {
                if (r() == null) {
                } else {
                }
                i = 5;
                i = 3;
                GlideException glideException = new GlideException("Received null model");
                A(glideException, i);
                com.bumptech.glide.r.i.a aVar2 = this.w;
                com.bumptech.glide.r.i.a rUNNING = i.a.RUNNING;
                if (aVar2 == rUNNING) {
                } else {
                }
                if (aVar2 == i.a.COMPLETE) {
                }
                c(this.s, a.MEMORY_CACHE, false);
                p(obj2);
                this.a = b.b("GlideRequest");
                wAITING_FOR_SIZE = i.a.WAITING_FOR_SIZE;
                this.w = wAITING_FOR_SIZE;
                if (l.t(this.l, this.m)) {
                } else {
                }
                f(this.l, this.m);
                this.o.getSize(this);
                aVar = this.w;
                if (aVar != rUNNING) {
                } else {
                }
                if (aVar == wAITING_FOR_SIZE && m()) {
                }
                if (m()) {
                }
                this.o.onLoadStarted(s());
                if (i.E) {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("finished run method in ");
                stringBuilder.append(g.a(this.u));
                v(stringBuilder.toString());
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot restart a running request");
                throw illegalArgumentException;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean isRunning() {
        int i;
        com.bumptech.glide.r.i.a wAITING_FOR_SIZE;
        final Object obj = this.d;
        com.bumptech.glide.r.i.a aVar = this.w;
        synchronized (obj) {
            if (aVar == i.a.WAITING_FOR_SIZE) {
                i = 1;
            } else {
                try {
                    i = 0;
                    i = 1;
                    return i;
                    throw th;
                }
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public boolean k() {
        int i;
        final Object obj = this.d;
        synchronized (obj) {
            i = 1;
            try {
                return i;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.r.d
    public String toString() {
        Object obj = this.d;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(super.toString());
        stringBuilder.append("[model=");
        stringBuilder.append(this.i);
        stringBuilder.append(", transcodeClass=");
        stringBuilder.append(this.j);
        stringBuilder.append("]");
        return stringBuilder.toString();
        synchronized (obj) {
            obj = this.d;
            stringBuilder = new StringBuilder();
            stringBuilder.append(super.toString());
            stringBuilder.append("[model=");
            stringBuilder.append(this.i);
            stringBuilder.append(", transcodeClass=");
            stringBuilder.append(this.j);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }
}
