package kotlin.reflect.jvm.internal.impl.utils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.d0.c.l;

/* loaded from: classes3.dex */
public class b {

    public interface c {
        public abstract Iterable<? extends N> a(N n);
    }

    public interface d {
        public abstract R a();

        public abstract void b(N n);

        public abstract boolean c(N n);
    }

    public interface e {
        public abstract boolean a(N n);
    }

    public static abstract class b implements kotlin.reflect.jvm.internal.impl.utils.b.d<N, R> {
        public void b(N n) {
        }
    }

    public static class f implements kotlin.reflect.jvm.internal.impl.utils.b.e<N> {

        private final Set<N> a;
        public f() {
            HashSet hashSet = new HashSet();
            super(hashSet);
        }

        public f(Set<N> set) {
            if (set == null) {
            } else {
                super();
                this.a = set;
            }
            b.f.b(0);
            throw 0;
        }

        private static void b(int i) {
            Object[] obj2 = new Object[3];
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "visited", "kotlin/reflect/jvm/internal/impl/utils/DFS$VisitedWithSet", "<init>"));
            throw illegalArgumentException;
        }

        public boolean a(N n) {
            return this.a.add(n);
        }
    }

    static class a extends kotlin.reflect.jvm.internal.impl.utils.b.b<N, Boolean> {

        final l a;
        final boolean[] b;
        a(l l, boolean[] z2Arr2) {
            this.a = l;
            this.b = z2Arr2;
            super();
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public Object a() {
            return d();
        }

        public boolean c(N n) {
            boolean obj3;
            int i = 1;
            final int i2 = 0;
            if ((Boolean)this.a.invoke(n).booleanValue()) {
                this.b[i2] = i;
            }
            return obj3 ^= i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.utils.b$b
        public Boolean d() {
            return Boolean.valueOf(this.b[0]);
        }
    }
    private static void a(int i) {
        String str;
        String obj3;
        Object[] arr = new Object[3];
        int i3 = 0;
        switch (i) {
            case 1:
                arr[i3] = "neighbors";
                break;
            case 2:
                arr[i3] = "visited";
                break;
            case 3:
                arr[i3] = "handler";
                break;
            case 4:
                arr[i3] = "nodes";
                break;
            case 5:
                arr[i3] = "predicate";
                break;
            case 6:
                arr[i3] = "node";
                break;
            default:
                arr[i3] = "current";
        }
        arr[1] = "kotlin/reflect/jvm/internal/impl/utils/DFS";
        int i5 = 2;
        switch (i) {
            case 7:
                arr[i5] = "ifAny";
                break;
            case 8:
                arr[i5] = "dfsFromNode";
                break;
            case 9:
                arr[i5] = "topologicalOrder";
                break;
            case 10:
                arr[i5] = "doDfs";
                break;
            default:
                arr[i5] = "dfs";
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
        throw illegalArgumentException;
    }

    public static <N, R> R b(Collection<N> collection, kotlin.reflect.jvm.internal.impl.utils.b.c<N> b$c2, kotlin.reflect.jvm.internal.impl.utils.b.d<N, R> b$d3) {
        int i = 0;
        if (collection == null) {
        } else {
            if (c2 == null) {
            } else {
                if (d3 == null) {
                } else {
                    b.f fVar = new b.f();
                    return b.c(collection, c2, fVar, d3);
                }
                b.a(6);
                throw i;
            }
            b.a(5);
            throw i;
        }
        b.a(4);
        throw i;
    }

    public static <N, R> R c(Collection<N> collection, kotlin.reflect.jvm.internal.impl.utils.b.c<N> b$c2, kotlin.reflect.jvm.internal.impl.utils.b.e<N> b$e3, kotlin.reflect.jvm.internal.impl.utils.b.d<N, R> b$d4) {
        int next;
        next = 0;
        if (collection == null) {
        } else {
            if (c2 == null) {
            } else {
                if (e3 == null) {
                } else {
                    if (d4 == null) {
                    } else {
                        Iterator obj1 = collection.iterator();
                        for (Object next : obj1) {
                            b.d(next, c2, e3, d4);
                        }
                        return d4.a();
                    }
                    b.a(3);
                    throw next;
                }
                b.a(2);
                throw next;
            }
            b.a(1);
            throw next;
        }
        b.a(0);
        throw next;
    }

    public static <N> void d(N n, kotlin.reflect.jvm.internal.impl.utils.b.c<N> b$c2, kotlin.reflect.jvm.internal.impl.utils.b.e<N> b$e3, kotlin.reflect.jvm.internal.impl.utils.b.d<N, ?> b$d4) {
        Object next;
        int i = 0;
        if (n == null) {
        } else {
            if (c2 == null) {
            } else {
                if (e3 == null) {
                } else {
                    if (d4 == null) {
                    } else {
                        if (!e3.a(n)) {
                        }
                        if (!d4.c(n)) {
                        }
                        Iterator iterator = c2.a(n).iterator();
                        for (Object next : iterator) {
                            b.d(next, c2, e3, d4);
                        }
                        d4.b(n);
                    }
                    b.a(25);
                    throw i;
                }
                b.a(24);
                throw i;
            }
            b.a(23);
            throw i;
        }
        b.a(22);
        throw i;
    }

    public static <N> Boolean e(Collection<N> collection, kotlin.reflect.jvm.internal.impl.utils.b.c<N> b$c2, l<N, Boolean> l3) {
        int i = 0;
        if (collection == null) {
        } else {
            if (c2 == null) {
            } else {
                if (l3 == null) {
                } else {
                    b.a aVar = new b.a(l3, new boolean[1]);
                    return (Boolean)b.b(collection, c2, aVar);
                }
                b.a(9);
                throw i;
            }
            b.a(8);
            throw i;
        }
        b.a(7);
        throw i;
    }
}
