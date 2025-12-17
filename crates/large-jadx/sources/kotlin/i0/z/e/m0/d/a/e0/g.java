package kotlin.i0.z.e.m0.d.a.e0;

import kotlin.i0.z.e.m0.d.a.i0.g;
import kotlin.i0.z.e.m0.d.a.i0.l;
import kotlin.i0.z.e.m0.d.a.i0.n;
import kotlin.i0.z.e.m0.d.a.i0.q;
import kotlin.i0.z.e.m0.f.b;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.l;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;

/* loaded from: classes3.dex */
public interface g {

    public static final kotlin.i0.z.e.m0.d.a.e0.g a;

    static class a implements kotlin.i0.z.e.m0.d.a.e0.g {
        private static void f(int i) {
            String str;
            String obj3;
            Object[] arr = new Object[3];
            int i3 = 0;
            switch (i) {
                case 1:
                    arr[i3] = "member";
                    break;
                case 2:
                    arr[i3] = "descriptor";
                    break;
                case 3:
                    arr[i3] = "element";
                    break;
                case 4:
                    arr[i3] = "field";
                    break;
                case 5:
                    arr[i3] = "javaClass";
                    break;
                default:
                    arr[i3] = "fqName";
            }
            arr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/JavaResolverCache$1";
            int i5 = 2;
            switch (i) {
                case 1:
                    arr[i5] = "recordMethod";
                    break;
                case 2:
                    arr[i5] = "recordConstructor";
                    break;
                case 3:
                    arr[i5] = "recordField";
                    break;
                case 4:
                    arr[i5] = "recordClass";
                    break;
                default:
                    arr[i5] = "getClassResolvedFromSource";
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        @Override // kotlin.i0.z.e.m0.d.a.e0.g
        public e a(b b) {
            final int i = 0;
            if (b == null) {
            } else {
                return i;
            }
            g.a.f(0);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.d.a.e0.g
        public void b(l l, l l2) {
            final int i = 0;
            if (l == null) {
            } else {
                if (l2 == null) {
                } else {
                }
                g.a.f(4);
                throw i;
            }
            g.a.f(3);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.d.a.e0.g
        public void c(g g, e e2) {
            final int i = 0;
            if (g == null) {
            } else {
                if (e2 == null) {
                } else {
                }
                g.a.f(8);
                throw i;
            }
            g.a.f(7);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.d.a.e0.g
        public void d(n n, o0 o02) {
            final int i = 0;
            if (n == null) {
            } else {
                if (o02 == null) {
                } else {
                }
                g.a.f(6);
                throw i;
            }
            g.a.f(5);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.d.a.e0.g
        public void e(q q, t0 t02) {
            final int i = 0;
            if (q == null) {
            } else {
                if (t02 == null) {
                } else {
                }
                g.a.f(2);
                throw i;
            }
            g.a.f(1);
            throw i;
        }
    }
    static {
        g.a aVar = new g.a();
        g.a = aVar;
    }

    public abstract e a(b b);

    public abstract void b(l l, l l2);

    public abstract void c(g g, e e2);

    public abstract void d(n n, o0 o02);

    public abstract void e(q q, t0 t02);
}
