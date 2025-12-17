package i.b.s0;

import i.b.m0.g.b;
import i.b.m0.g.d;
import i.b.m0.g.e;
import i.b.m0.g.m;
import i.b.m0.g.n;
import i.b.p0.a;
import i.b.z;
import java.util.concurrent.Callable;

/* loaded from: classes3.dex */
public final class a {

    static final z a;
    static final z b;
    static final z c;
    static final z d;

    static final class a {

        static final z a;
        static {
            b bVar = new b();
            a.a.a = bVar;
        }
    }

    static final class b implements Callable<z> {
        @Override // java.util.concurrent.Callable
        public z a() {
            return a.a.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    static final class c implements Callable<z> {
        @Override // java.util.concurrent.Callable
        public z a() {
            return a.d.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    static final class d {

        static final z a;
        static {
            d dVar = new d();
            a.d.a = dVar;
        }
    }

    static final class e {

        static final z a;
        static {
            e eVar = new e();
            a.e.a = eVar;
        }
    }

    static final class f implements Callable<z> {
        @Override // java.util.concurrent.Callable
        public z a() {
            return a.e.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    static final class g {

        static final z a;
        static {
            m mVar = new m();
            a.g.a = mVar;
        }
    }

    static final class h implements Callable<z> {
        @Override // java.util.concurrent.Callable
        public z a() {
            return a.g.a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }
    static {
        a.h hVar = new a.h();
        a.h(hVar);
        a.b bVar = new a.b();
        a.a = a.e(bVar);
        a.c cVar = new a.c();
        a.b = a.f(cVar);
        a.c = n.f();
        a.f fVar = new a.f();
        a.d = a.g(fVar);
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
