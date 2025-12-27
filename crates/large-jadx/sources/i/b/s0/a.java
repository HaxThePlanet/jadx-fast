package i.b.s0;

import i.b.m0.g.n;
import i.b.p0.a;
import i.b.z;
import java.util.concurrent.Callable;

/* compiled from: Schedulers.java */
/* loaded from: classes3.dex */
public final class a {

    static final z a;
    static final z b;
    static final z c;
    static final z d;

    static final class a {

        static final z a = new b();
    }

    static final class b implements Callable<z> {
        b() {
            super();
        }

        public z a() {
            return a.a.a;
        }
    }

    static final class c implements Callable<z> {
        c() {
            super();
        }

        public z a() {
            return a.d.a;
        }
    }

    static final class d {

        static final z a = new d();
    }

    static final class e {

        static final z a = new e();
    }

    static final class f implements Callable<z> {
        f() {
            super();
        }

        public z a() {
            return a.e.a;
        }
    }

    static final class g {

        static final z a = new m();
    }

    static final class h implements Callable<z> {
        h() {
            super();
        }

        public z a() {
            return a.g.a;
        }
    }
    static {
        a.h(new a.h());
        a.a = a.e(new a.b());
        a.b = a.f(new a.c());
        a.c = n.f();
        a.d = a.g(new a.f());
    }

    public static z a() {
        return a.s(a.a);
    }

    public static z b() {
        return a.u(a.b);
    }

    public static z c() {
        return a.v(a.d);
    }

    public static z d() {
        return a.c;
    }
}
