package kotlin.i0.z.e.m0.d.a;

import java.util.HashMap;
import java.util.Map;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.i.d;
import kotlin.i0.z.e.m0.i.v.o.d;
import kotlin.reflect.jvm.internal.impl.descriptors.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.g1;
import kotlin.reflect.jvm.internal.impl.descriptors.k1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.k1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.k1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.r;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;

/* loaded from: classes3.dex */
public class u {

    public static final u a;
    public static final u b;
    public static final u c;
    private static final Map<g1, u> d;

    static class a extends r {
        a(g1 g1) {
            super(g1);
        }

        private static void g(int i) {
            String obj3;
            Object[] arr = new Object[3];
            int i3 = 0;
            final int i4 = 1;
            if (i != i4) {
                arr[i3] = "what";
            } else {
                arr[i3] = "from";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$1";
            arr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.r
        public boolean e(d d, q q2, m m3) {
            int obj1 = 0;
            if (q2 == null) {
            } else {
                if (m3 == null) {
                } else {
                    return u.b(q2, m3);
                }
                u.a.g(1);
                throw obj1;
            }
            u.a.g(0);
            throw obj1;
        }
    }

    static class b extends r {
        b(g1 g1) {
            super(g1);
        }

        private static void g(int i) {
            String obj3;
            Object[] arr = new Object[3];
            int i3 = 0;
            final int i4 = 1;
            if (i != i4) {
                arr[i3] = "what";
            } else {
                arr[i3] = "from";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$2";
            arr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.r
        public boolean e(d d, q q2, m m3) {
            final int i = 0;
            if (q2 == null) {
            } else {
                if (m3 == null) {
                } else {
                    return u.c(d, q2, m3);
                }
                u.b.g(1);
                throw i;
            }
            u.b.g(0);
            throw i;
        }
    }

    static class c extends r {
        c(g1 g1) {
            super(g1);
        }

        private static void g(int i) {
            String obj3;
            Object[] arr = new Object[3];
            int i3 = 0;
            final int i4 = 1;
            if (i != i4) {
                arr[i3] = "what";
            } else {
                arr[i3] = "from";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities$3";
            arr[2] = "isVisible";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.r
        public boolean e(d d, q q2, m m3) {
            final int i = 0;
            if (q2 == null) {
            } else {
                if (m3 == null) {
                } else {
                    return u.c(d, q2, m3);
                }
                u.c.g(1);
                throw i;
            }
            u.c.g(0);
            throw i;
        }
    }
    static {
        u.a aVar = new u.a(a.c);
        u.a = aVar;
        u.b bVar = new u.b(c.c);
        u.b = bVar;
        u.c cVar2 = new u.c(b.c);
        u.c = cVar2;
        HashMap hashMap = new HashMap();
        u.d = hashMap;
        u.f(aVar);
        u.f(bVar);
        u.f(cVar2);
    }

    private static void a(int i) {
        String str;
        int str2;
        int i2;
        String str3;
        Object obj9;
        final int i3 = 6;
        final int i4 = 5;
        if (i != i4 && i != i3) {
            str = i != i3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        } else {
        }
        int i5 = 3;
        final int i6 = 2;
        if (i != i4 && i != i3) {
            i2 = i != i3 ? i5 : i6;
        } else {
        }
        Object[] arr = new Object[i2];
        final String str6 = "kotlin/reflect/jvm/internal/impl/load/java/JavaDescriptorVisibilities";
        int i7 = 0;
        switch (i) {
            case 1:
                arr[i7] = "from";
                break;
            case 2:
                arr[i7] = "first";
                break;
            case 3:
                arr[i7] = "second";
                break;
            case 4:
                arr[i7] = "visibility";
                break;
            case 5:
                arr[i7] = str6;
                break;
            default:
                arr[i7] = "what";
        }
        String str7 = "toDescriptorVisibility";
        int i8 = 1;
        if (i != i4 && i != i3) {
            if (i != i3) {
                arr[i8] = str6;
            } else {
                arr[i8] = str7;
            }
        } else {
        }
        if (i != i6 && i != i5) {
            if (i != i5) {
                if (i != 4) {
                    if (i != i4 && i != i3) {
                        if (i != i3) {
                            arr[i6] = "isVisibleForProtectedAndPackage";
                        }
                    }
                } else {
                    arr[i6] = str7;
                }
            } else {
                arr[i6] = "areInSamePackage";
            }
        } else {
        }
        String format = String.format(str, arr);
        if (i != i4 && i != i3) {
            if (i != i3) {
                obj9 = new IllegalArgumentException(format);
            } else {
                obj9 = new IllegalStateException(format);
            }
        } else {
        }
        throw obj9;
    }

    static boolean b(m m, m m2) {
        return u.d(m, m2);
    }

    static boolean c(d d, q q2, m m3) {
        return u.e(d, q2, m3);
    }

    private static boolean d(m m, m m2) {
        int i;
        m obj2;
        Object obj3;
        final Class<f0> obj = f0.class;
        int i2 = 0;
        if (m == null) {
        } else {
            if (m2 == null) {
            } else {
                i = 0;
                obj2 = d.r(m, obj, i);
                obj3 = d.r(m2, obj, i);
                if (obj3 != null && obj2 != null && (f0)obj2.d().equals((f0)obj3.d())) {
                    if (obj2 != null) {
                        if (obj2.d().equals(obj3.d())) {
                            i = 1;
                        }
                    }
                }
                return i;
            }
            u.a(3);
            throw i2;
        }
        u.a(2);
        throw i2;
    }

    private static boolean e(d d, q q2, m m3) {
        int i = 0;
        if (q2 == null) {
        } else {
            final int i2 = 1;
            if (m3 == null) {
            } else {
                if (u.d(d.M(q2), m3)) {
                    return i2;
                }
                return t.c.e(d, q2, m3);
            }
            u.a(i2);
            throw i;
        }
        u.a(0);
        throw i;
    }

    private static void f(u u) {
        u.d.put(u.b(), u);
    }

    public static u g(g1 g1) {
        final int i = 0;
        if (g1 == null) {
        } else {
            Object obj = u.d.get(g1);
            if ((u)obj == null) {
                u obj2 = t.j(g1);
                if (obj2 == null) {
                } else {
                    return obj2;
                }
                u.a(5);
                throw i;
            }
            if ((u)obj == null) {
            } else {
                return (u)obj;
            }
            u.a(6);
            throw i;
        }
        u.a(4);
        throw i;
    }
}
