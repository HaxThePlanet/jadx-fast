package kotlin.i0.z.e.m0.l.j1;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.i;
import kotlin.i0.z.e.m0.b.k.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.c;
import kotlin.i0.z.e.m0.i.f;
import kotlin.i0.z.e.m0.i.q.n;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.b1;
import kotlin.i0.z.e.m0.l.b1.a;
import kotlin.i0.z.e.m0.l.c0;
import kotlin.i0.z.e.m0.l.c1;
import kotlin.i0.z.e.m0.l.d0;
import kotlin.i0.z.e.m0.l.f;
import kotlin.i0.z.e.m0.l.i0;
import kotlin.i0.z.e.m0.l.k;
import kotlin.i0.z.e.m0.l.l1.b;
import kotlin.i0.z.e.m0.l.l1.c;
import kotlin.i0.z.e.m0.l.l1.d;
import kotlin.i0.z.e.m0.l.l1.e;
import kotlin.i0.z.e.m0.l.l1.f;
import kotlin.i0.z.e.m0.l.l1.h;
import kotlin.i0.z.e.m0.l.l1.i;
import kotlin.i0.z.e.m0.l.l1.j;
import kotlin.i0.z.e.m0.l.l1.k;
import kotlin.i0.z.e.m0.l.l1.l;
import kotlin.i0.z.e.m0.l.l1.m;
import kotlin.i0.z.e.m0.l.l1.o;
import kotlin.i0.z.e.m0.l.l1.p;
import kotlin.i0.z.e.m0.l.l1.p.a;
import kotlin.i0.z.e.m0.l.l1.r;
import kotlin.i0.z.e.m0.l.m1.a;
import kotlin.i0.z.e.m0.l.t0;
import kotlin.i0.z.e.m0.l.v;
import kotlin.i0.z.e.m0.l.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.a0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* loaded from: classes3.dex */
public interface c extends b1, p {

    public static final class a {
        public static boolean A(kotlin.i0.z.e.m0.l.j1.c c, l l2) {
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                return h.D0((t0)l2, k.a.b);
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(l2);
            obj1.append(", ");
            obj1.append(c0.b(l2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean B(kotlin.i0.z.e.m0.l.j1.c c, l l2) {
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                return obj1 instanceof e;
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(l2);
            obj1.append(", ");
            obj1.append(c0.b(l2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean C(kotlin.i0.z.e.m0.l.j1.c c, l l2) {
            boolean aNNOTATION_CLASS;
            f eNUM_ENTRY;
            int obj2;
            int obj3;
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                if (obj2 instanceof e) {
                } else {
                    obj2 = 0;
                }
                if (obj2 == null) {
                    return 0;
                }
                if (a0.a(obj2) && obj2.f() != f.ENUM_ENTRY && obj2.f() != f.ANNOTATION_CLASS) {
                    if (obj2.f() != f.ENUM_ENTRY) {
                        if (obj2.f() != f.ANNOTATION_CLASS) {
                            obj3 = 1;
                        }
                    }
                }
                return obj3;
            }
            obj2 = new StringBuilder();
            obj2.append("ClassicTypeSystemContext couldn't handle: ");
            obj2.append(l2);
            obj2.append(", ");
            obj2.append(c0.b(l2.getClass()));
            obj3 = new IllegalArgumentException(obj2.toString().toString());
            throw obj3;
        }

        public static boolean D(kotlin.i0.z.e.m0.l.j1.c c, l l2) {
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                return (t0)l2.d();
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(l2);
            obj1.append(", ");
            obj1.append(c0.b(l2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean E(kotlin.i0.z.e.m0.l.j1.c c, h h2) {
            n.f(c, "this");
            n.f(h2, "receiver");
            if (!h2 instanceof b0) {
            } else {
                return d0.a((b0)h2);
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(h2);
            obj1.append(", ");
            obj1.append(c0.b(h2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean F(kotlin.i0.z.e.m0.l.j1.c c, l l2) {
            Boolean valueOf;
            int obj1;
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                if (obj1 instanceof e) {
                } else {
                    obj1 = valueOf;
                }
                if (obj1 == null) {
                } else {
                    valueOf = Boolean.valueOf(f.b(obj1));
                }
                return n.b(valueOf, Boolean.TRUE);
            }
            obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(l2);
            obj1.append(", ");
            obj1.append(c0.b(l2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean G(kotlin.i0.z.e.m0.l.j1.c c, l l2) {
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                return l2 instanceof n;
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(l2);
            obj1.append(", ");
            obj1.append(c0.b(l2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean H(kotlin.i0.z.e.m0.l.j1.c c, l l2) {
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                return l2 instanceof a0;
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(l2);
            obj1.append(", ");
            obj1.append(c0.b(l2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean I(kotlin.i0.z.e.m0.l.j1.c c, h h2) {
            return p.a.b(c, h2);
        }

        public static boolean J(kotlin.i0.z.e.m0.l.j1.c c, i i2) {
            n.f(c, "this");
            n.f(i2, "receiver");
            if (!i2 instanceof i0) {
            } else {
                return (i0)i2.M0();
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(i2);
            obj1.append(", ");
            obj1.append(c0.b(i2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean K(kotlin.i0.z.e.m0.l.j1.c c, l l2) {
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                return h.D0((t0)l2, k.a.c);
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(l2);
            obj1.append(", ");
            obj1.append(c0.b(l2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean L(kotlin.i0.z.e.m0.l.j1.c c, h h2) {
            n.f(c, "this");
            n.f(h2, "receiver");
            if (!h2 instanceof b0) {
            } else {
                return c1.l((b0)h2);
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(h2);
            obj1.append(", ");
            obj1.append(c0.b(h2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean M(kotlin.i0.z.e.m0.l.j1.c c, i i2) {
            n.f(c, "this");
            n.f(i2, "receiver");
            if (!i2 instanceof b0) {
            } else {
                return h.y0((b0)i2);
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(i2);
            obj1.append(", ");
            obj1.append(c0.b(i2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean N(kotlin.i0.z.e.m0.l.j1.c c, c c2) {
            n.f(c, "this");
            n.f(c2, "receiver");
            if (!c2 instanceof i) {
            } else {
                return (i)c2.X0();
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(c2);
            obj1.append(", ");
            obj1.append(c0.b(c2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean O(kotlin.i0.z.e.m0.l.j1.c c, i i2) {
            Object str;
            int obj1;
            Object obj2;
            n.f(c, "this");
            n.f(i2, "receiver");
            if (!i2 instanceof i0) {
            } else {
                obj1 = i2;
                if (!d0.a((b0)i2) && !hVar instanceof y0) {
                    obj1 = i2;
                    if (!hVar instanceof y0) {
                        if (obj1.L0().c() == null && !i2 instanceof a && !i2 instanceof i && !i2 instanceof k) {
                            if (!i2 instanceof a) {
                                if (!i2 instanceof i) {
                                    if (!i2 instanceof k) {
                                        obj1 = obj1 instanceof n ? 1 : 0;
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
                } else {
                }
                return obj1;
            }
            obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(i2);
            obj1.append(", ");
            obj1.append(c0.b(i2.getClass()));
            obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean P(kotlin.i0.z.e.m0.l.j1.c c, k k2) {
            n.f(c, "this");
            n.f(k2, "receiver");
            if (!k2 instanceof v0) {
            } else {
                return (v0)k2.c();
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(k2);
            obj1.append(", ");
            obj1.append(c0.b(k2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean Q(kotlin.i0.z.e.m0.l.j1.c c, i i2) {
            n.f(c, "this");
            n.f(i2, "receiver");
            if (!i2 instanceof i0) {
            } else {
                return 0;
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(i2);
            obj1.append(", ");
            obj1.append(c0.b(i2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean R(kotlin.i0.z.e.m0.l.j1.c c, l l2) {
            Boolean obj1;
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                obj1 = (t0)l2.c();
                if (obj1 == null) {
                    obj1 = 0;
                } else {
                    obj1 = Boolean.valueOf(h.I0(obj1));
                }
                return n.b(obj1, Boolean.TRUE);
            }
            obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(l2);
            obj1.append(", ");
            obj1.append(c0.b(l2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static i S(kotlin.i0.z.e.m0.l.j1.c c, f f2) {
            n.f(c, "this");
            n.f(f2, "receiver");
            if (!f2 instanceof v) {
            } else {
                return (v)f2.T0();
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(f2);
            obj1.append(", ");
            obj1.append(c0.b(f2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static i T(kotlin.i0.z.e.m0.l.j1.c c, h h2) {
            return p.a.c(c, h2);
        }

        public static h U(kotlin.i0.z.e.m0.l.j1.c c, c c2) {
            n.f(c, "this");
            n.f(c2, "receiver");
            if (!c2 instanceof i) {
            } else {
                return (i)c2.W0();
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(c2);
            obj1.append(", ");
            obj1.append(c0.b(c2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static h V(kotlin.i0.z.e.m0.l.j1.c c, h h2) {
            n.f(c, "this");
            n.f(h2, "receiver");
            if (!h2 instanceof g1) {
            } else {
                return d.a((g1)h2);
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(h2);
            obj1.append(", ");
            obj1.append(c0.b(h2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static h W(kotlin.i0.z.e.m0.l.j1.c c, h h2) {
            return b1.a.a(c, h2);
        }

        public static f X(kotlin.i0.z.e.m0.l.j1.c c, boolean z2, boolean z3) {
            n.f(c, "this");
            super(z2, z3, 0, 0, 12, 0);
            return obj8;
        }

        public static i Y(kotlin.i0.z.e.m0.l.j1.c c, d d2) {
            n.f(c, "this");
            n.f(d2, "receiver");
            if (!d2 instanceof k) {
            } else {
                return (k)d2.X0();
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(d2);
            obj1.append(", ");
            obj1.append(c0.b(d2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static int Z(kotlin.i0.z.e.m0.l.j1.c c, l l2) {
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                return (t0)l2.getParameters().size();
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(l2);
            obj1.append(", ");
            obj1.append(c0.b(l2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean a(kotlin.i0.z.e.m0.l.j1.c c, l l2, l l3) {
            n.f(c, "this");
            n.f(l2, "c1");
            n.f(l3, "c2");
            String str2 = ", ";
            final String str3 = "ClassicTypeSystemContext couldn't handle: ";
            if (!l2 instanceof t0) {
            } else {
                if (!l3 instanceof t0) {
                } else {
                    return n.b(l2, l3);
                }
                StringBuilder obj2 = new StringBuilder();
                obj2.append(str3);
                obj2.append(l3);
                obj2.append(str2);
                obj2.append(c0.b(l3.getClass()));
                IllegalArgumentException obj3 = new IllegalArgumentException(obj2.toString().toString());
                throw obj3;
            }
            obj2 = new StringBuilder();
            obj2.append(str3);
            obj2.append(l2);
            obj2.append(str2);
            obj2.append(c0.b(l2.getClass()));
            obj3 = new IllegalArgumentException(obj2.toString().toString());
            throw obj3;
        }

        public static Collection<h> a0(kotlin.i0.z.e.m0.l.j1.c c, i i2) {
            n.f(c, "this");
            n.f(i2, "receiver");
            l obj1 = c.b(i2);
            if (!obj1 instanceof n) {
            } else {
                return (n)obj1.k();
            }
            obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(i2);
            obj1.append(", ");
            obj1.append(c0.b(i2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static int b(kotlin.i0.z.e.m0.l.j1.c c, h h2) {
            n.f(c, "this");
            n.f(h2, "receiver");
            if (!h2 instanceof b0) {
            } else {
                return (b0)h2.K0().size();
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(h2);
            obj1.append(", ");
            obj1.append(c0.b(h2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static int b0(kotlin.i0.z.e.m0.l.j1.c c, j j2) {
            return p.a.d(c, j2);
        }

        public static j c(kotlin.i0.z.e.m0.l.j1.c c, i i2) {
            n.f(c, "this");
            n.f(i2, "receiver");
            if (!i2 instanceof i0) {
            } else {
                return (j)i2;
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(i2);
            obj1.append(", ");
            obj1.append(c0.b(i2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static Collection<h> c0(kotlin.i0.z.e.m0.l.j1.c c, l l2) {
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                Collection obj1 = (t0)l2.a();
                n.e(obj1, "this.supertypes");
                return obj1;
            }
            obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(l2);
            obj1.append(", ");
            obj1.append(c0.b(l2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static c d(kotlin.i0.z.e.m0.l.j1.c c, i i2) {
            int obj2;
            n.f(c, "this");
            n.f(i2, "receiver");
            if (!i2 instanceof i0) {
            } else {
                if (i2 instanceof i) {
                } else {
                    obj2 = 0;
                }
                return obj2;
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append((i)i2);
            obj1.append(", ");
            obj1.append(c0.b(i2.getClass()));
            obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static l d0(kotlin.i0.z.e.m0.l.j1.c c, h h2) {
            return p.a.e(c, h2);
        }

        public static d e(kotlin.i0.z.e.m0.l.j1.c c, i i2) {
            int obj2;
            n.f(c, "this");
            n.f(i2, "receiver");
            if (!i2 instanceof i0) {
            } else {
                if (i2 instanceof k) {
                } else {
                    obj2 = 0;
                }
                return obj2;
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append((k)i2);
            obj1.append(", ");
            obj1.append(c0.b(i2.getClass()));
            obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static l e0(kotlin.i0.z.e.m0.l.j1.c c, i i2) {
            n.f(c, "this");
            n.f(i2, "receiver");
            if (!i2 instanceof i0) {
            } else {
                return (i0)i2.L0();
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(i2);
            obj1.append(", ");
            obj1.append(c0.b(i2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static e f(kotlin.i0.z.e.m0.l.j1.c c, f f2) {
            int obj2;
            n.f(c, "this");
            n.f(f2, "receiver");
            if (!f2 instanceof v) {
            } else {
                if (f2 instanceof q) {
                } else {
                    obj2 = 0;
                }
                return obj2;
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append((q)f2);
            obj1.append(", ");
            obj1.append(c0.b(f2.getClass()));
            obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static i f0(kotlin.i0.z.e.m0.l.j1.c c, f f2) {
            n.f(c, "this");
            n.f(f2, "receiver");
            if (!f2 instanceof v) {
            } else {
                return (v)f2.U0();
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(f2);
            obj1.append(", ");
            obj1.append(c0.b(f2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static f g(kotlin.i0.z.e.m0.l.j1.c c, h h2) {
            int obj1;
            n.f(c, "this");
            n.f(h2, "receiver");
            if (!h2 instanceof b0) {
            } else {
                if (obj1 instanceof v) {
                } else {
                    obj1 = 0;
                }
                return obj1;
            }
            obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(h2);
            obj1.append(", ");
            obj1.append(c0.b(h2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static i g0(kotlin.i0.z.e.m0.l.j1.c c, h h2) {
            return p.a.f(c, h2);
        }

        public static i h(kotlin.i0.z.e.m0.l.j1.c c, h h2) {
            int obj1;
            n.f(c, "this");
            n.f(h2, "receiver");
            if (!h2 instanceof b0) {
            } else {
                if (obj1 instanceof i0) {
                } else {
                    obj1 = 0;
                }
                return obj1;
            }
            obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(h2);
            obj1.append(", ");
            obj1.append(c0.b(h2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static h h0(kotlin.i0.z.e.m0.l.j1.c c, h h2, boolean z3) {
            boolean z;
            h obj1;
            Object obj2;
            n.f(c, "this");
            n.f(h2, "receiver");
            if (h2 instanceof i) {
                obj1 = c.c((i)h2, z3);
                return obj1;
            } else {
                if (!h2 instanceof f) {
                } else {
                    obj1 = c.t(c.c(c.e((f)h2), z3), c.c(c.d(h2), z3));
                }
            }
            obj1 = new IllegalStateException("sealed".toString());
            throw obj1;
        }

        public static k i(kotlin.i0.z.e.m0.l.j1.c c, h h2) {
            n.f(c, "this");
            n.f(h2, "receiver");
            if (!h2 instanceof b0) {
            } else {
                return a.a((b0)h2);
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(h2);
            obj1.append(", ");
            obj1.append(c0.b(h2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static i i0(kotlin.i0.z.e.m0.l.j1.c c, i i2, boolean z3) {
            n.f(c, "this");
            n.f(i2, "receiver");
            if (!i2 instanceof i0) {
            } else {
                return (i0)i2.S0(z3);
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(i2);
            obj1.append(", ");
            obj1.append(c0.b(i2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static i j(kotlin.i0.z.e.m0.l.j1.c c, i i2, b b3) {
            n.f(c, "this");
            n.f(i2, "type");
            n.f(b3, "status");
            if (!i2 instanceof i0) {
            } else {
                return k.b((i0)i2, b3);
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(i2);
            obj1.append(", ");
            obj1.append(c0.b(i2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static h k(kotlin.i0.z.e.m0.l.j1.c c, i i2, i i3) {
            n.f(c, "this");
            n.f(i2, "lowerBound");
            n.f(i3, "upperBound");
            final String str4 = ", ";
            final String str5 = "ClassicTypeSystemContext couldn't handle: ";
            if (!i2 instanceof i0) {
            } else {
                if (!i3 instanceof i0) {
                } else {
                    c0 obj3 = c0.a;
                    return c0.d((i0)i2, (i0)i3);
                }
                StringBuilder obj4 = new StringBuilder();
                obj4.append(str5);
                obj4.append(c);
                obj4.append(str4);
                obj4.append(c0.b(c.getClass()));
                obj4 = new IllegalArgumentException(obj4.toString().toString());
                throw obj4;
            }
            obj4 = new StringBuilder();
            obj4.append(str5);
            obj4.append(c);
            obj4.append(str4);
            obj4.append(c0.b(c.getClass()));
            obj4 = new IllegalArgumentException(obj4.toString().toString());
            throw obj4;
        }

        public static k l(kotlin.i0.z.e.m0.l.j1.c c, j j2, int i3) {
            return p.a.a(c, j2, i3);
        }

        public static k m(kotlin.i0.z.e.m0.l.j1.c c, h h2, int i3) {
            n.f(c, "this");
            n.f(h2, "receiver");
            if (!h2 instanceof b0) {
            } else {
                return (k)(b0)h2.K0().get(i3);
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(h2);
            obj1.append(", ");
            obj1.append(c0.b(h2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static c n(kotlin.i0.z.e.m0.l.j1.c c, l l2) {
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                kotlin.reflect.jvm.internal.impl.descriptors.h obj1 = (t0)l2.c();
                Objects.requireNonNull(obj1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return a.j((e)obj1);
            }
            obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(l2);
            obj1.append(", ");
            obj1.append(c0.b(l2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static m o(kotlin.i0.z.e.m0.l.j1.c c, l l2, int i3) {
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                Object obj1 = (t0)l2.getParameters().get(i3);
                n.e(obj1, "this.parameters[index]");
                return (m)obj1;
            }
            obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(l2);
            obj1.append(", ");
            obj1.append(c0.b(l2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static i p(kotlin.i0.z.e.m0.l.j1.c c, l l2) {
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                kotlin.reflect.jvm.internal.impl.descriptors.h obj1 = (t0)l2.c();
                Objects.requireNonNull(obj1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return h.O((e)obj1);
            }
            obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(l2);
            obj1.append(", ");
            obj1.append(c0.b(l2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static i q(kotlin.i0.z.e.m0.l.j1.c c, l l2) {
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                kotlin.reflect.jvm.internal.impl.descriptors.h obj1 = (t0)l2.c();
                Objects.requireNonNull(obj1, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                return h.R((e)obj1);
            }
            obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(l2);
            obj1.append(", ");
            obj1.append(c0.b(l2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static h r(kotlin.i0.z.e.m0.l.j1.c c, m m2) {
            n.f(c, "this");
            n.f(m2, "receiver");
            if (!m2 instanceof z0) {
            } else {
                return a.f((z0)m2);
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(m2);
            obj1.append(", ");
            obj1.append(c0.b(m2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static h s(kotlin.i0.z.e.m0.l.j1.c c, h h2) {
            n.f(c, "this");
            n.f(h2, "receiver");
            if (!h2 instanceof b0) {
            } else {
                return f.e((b0)h2);
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(h2);
            obj1.append(", ");
            obj1.append(c0.b(h2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static h t(kotlin.i0.z.e.m0.l.j1.c c, k k2) {
            n.f(c, "this");
            n.f(k2, "receiver");
            if (!k2 instanceof v0) {
            } else {
                return (v0)k2.getType().O0();
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(k2);
            obj1.append(", ");
            obj1.append(c0.b(k2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static m u(kotlin.i0.z.e.m0.l.j1.c c, l l2) {
            int obj1;
            n.f(c, "this");
            n.f(l2, "receiver");
            if (!l2 instanceof t0) {
            } else {
                if (obj1 instanceof z0) {
                } else {
                    obj1 = 0;
                }
                return obj1;
            }
            obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(l2);
            obj1.append(", ");
            obj1.append(c0.b(l2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static r v(kotlin.i0.z.e.m0.l.j1.c c, k k2) {
            n.f(c, "this");
            n.f(k2, "receiver");
            if (!k2 instanceof v0) {
            } else {
                kotlin.i0.z.e.m0.l.h1 obj1 = (v0)k2.a();
                n.e(obj1, "this.projectionKind");
                return o.a(obj1);
            }
            obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(k2);
            obj1.append(", ");
            obj1.append(c0.b(k2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static r w(kotlin.i0.z.e.m0.l.j1.c c, m m2) {
            n.f(c, "this");
            n.f(m2, "receiver");
            if (!m2 instanceof z0) {
            } else {
                kotlin.i0.z.e.m0.l.h1 obj1 = (z0)m2.l();
                n.e(obj1, "this.variance");
                return o.a(obj1);
            }
            obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(m2);
            obj1.append(", ");
            obj1.append(c0.b(m2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean x(kotlin.i0.z.e.m0.l.j1.c c, h h2, b b3) {
            n.f(c, "this");
            n.f(h2, "receiver");
            n.f(b3, "fqName");
            if (!h2 instanceof b0) {
            } else {
                return (b0)h2.getAnnotations().u1(b3);
            }
            StringBuilder obj1 = new StringBuilder();
            obj1.append("ClassicTypeSystemContext couldn't handle: ");
            obj1.append(h2);
            obj1.append(", ");
            obj1.append(c0.b(h2.getClass()));
            IllegalArgumentException obj2 = new IllegalArgumentException(obj1.toString().toString());
            throw obj2;
        }

        public static boolean y(kotlin.i0.z.e.m0.l.j1.c c, i i2, i i3) {
            int obj2;
            n.f(c, "this");
            n.f(i2, "a");
            n.f(i3, "b");
            String str2 = ", ";
            final String str3 = "ClassicTypeSystemContext couldn't handle: ";
            if (!i2 instanceof i0) {
            } else {
                if (!i3 instanceof i0) {
                } else {
                    obj2 = (i0)i2.K0() == (i0)i3.K0() ? 1 : 0;
                    return obj2;
                }
                obj2 = new StringBuilder();
                obj2.append(str3);
                obj2.append(i3);
                obj2.append(str2);
                obj2.append(c0.b(i3.getClass()));
                IllegalArgumentException obj3 = new IllegalArgumentException(obj2.toString().toString());
                throw obj3;
            }
            obj2 = new StringBuilder();
            obj2.append(str3);
            obj2.append(i2);
            obj2.append(str2);
            obj2.append(c0.b(i2.getClass()));
            obj3 = new IllegalArgumentException(obj2.toString().toString());
            throw obj3;
        }

        public static h z(kotlin.i0.z.e.m0.l.j1.c c, List<? extends h> list2) {
            n.f(c, "this");
            n.f(list2, "types");
            return e.a(list2);
        }
    }
    @Override // kotlin.i0.z.e.m0.l.b1
    public abstract i a(h h);

    @Override // kotlin.i0.z.e.m0.l.b1
    public abstract l b(i i);

    @Override // kotlin.i0.z.e.m0.l.b1
    public abstract i c(i i, boolean z2);

    @Override // kotlin.i0.z.e.m0.l.b1
    public abstract i d(f f);

    @Override // kotlin.i0.z.e.m0.l.b1
    public abstract i e(f f);

    @Override // kotlin.i0.z.e.m0.l.b1
    public abstract h t(i i, i i2);
}
