package io.grpc;

import com.google.common.base.n;

/* compiled from: InternalConfigSelector.java */
/* loaded from: classes2.dex */
public abstract class f0 {

    public static final a.c<f0> a;

    static class a {
    }

    public static final class b {

        private final d1 a;
        private final Object b;
        public i c;
        /* synthetic */ b(d1 d1Var, Object object, i iVar, f0.a aVar) {
            this(d1Var, object, iVar);
        }

        public static f0.b.a d() {
            return new f0.b.a(null);
        }

        public Object a() {
            return this.b;
        }

        public i b() {
            return this.c;
        }

        public d1 c() {
            return this.a;
        }

        private b(d1 d1Var, Object object, i iVar) {
            super();
            n.p(d1Var, "status");
            this.a = d1Var;
            this.b = object;
            this.c = iVar;
        }
    }
    static {
        f0.a = a.c.a("io.grpc.config-selector");
    }

    public abstract f0.b a(o0.f fVar);
}
