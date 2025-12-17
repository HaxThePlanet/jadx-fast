package kotlin.i0.z.e.m0.i;

import java.util.Collections;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.k;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.s.a;
import kotlin.i0.z.e.m0.i.v.o.b;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.i0.z.e.m0.l.h1;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.h1.g.a;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.e0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.f;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.j1.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z;

/* loaded from: classes3.dex */
public class c {

    private static class a extends f {
        public a(e e, u0 u02, boolean z3) {
            int i = 0;
            if (e == null) {
            } else {
                if (u02 == null) {
                } else {
                    super(e, 0, g.q.b(), 1, b.a.DECLARATION, u02);
                    o1(Collections.emptyList(), d.k(e, z3));
                }
                c.a.E(1);
                throw i;
            }
            c.a.E(0);
            throw i;
        }

        private static void E(int i) {
            String obj3;
            Object[] arr = new Object[3];
            int i3 = 0;
            final int i4 = 1;
            if (i != i4) {
                arr[i3] = "containingClass";
            } else {
                arr[i3] = "source";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory$DefaultClassConstructorDescriptor";
            arr[2] = "<init>";
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }
    }
    private static void a(int i) {
        String str2;
        int i3;
        String str3;
        String str;
        Object obj11;
        final int i4 = 25;
        final int i5 = 23;
        final int i6 = 12;
        if (i != i6 && i != i5 && i != i4) {
            if (i != i5) {
                str2 = i != i4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            } else {
            }
        } else {
        }
        final int i7 = 2;
        if (i != i6 && i != i5 && i != i4) {
            if (i != i5) {
                i3 = i != i4 ? 3 : i7;
            } else {
            }
        } else {
        }
        Object[] arr = new Object[i3];
        str3 = "kotlin/reflect/jvm/internal/impl/resolve/DescriptorFactory";
        int i8 = 0;
        switch (i) {
            case 1:
                arr[i8] = "annotations";
                break;
            case 2:
                arr[i8] = "parameterAnnotations";
                break;
            case 3:
                arr[i8] = "propertyDescriptor";
                break;
            case 4:
                arr[i8] = "sourceElement";
                break;
            case 5:
                arr[i8] = "visibility";
                break;
            case 6:
                arr[i8] = str3;
                break;
            case 7:
                arr[i8] = "containingClass";
                break;
            case 8:
                arr[i8] = "source";
                break;
            case 9:
                arr[i8] = "enumClass";
                break;
            case 10:
                arr[i8] = "descriptor";
                break;
            default:
                arr[i8] = "owner";
        }
        String str4 = "createEnumValueOfMethod";
        String str5 = "createEnumValuesMethod";
        final String str6 = "createSetter";
        final int i9 = 1;
        if (i != i6) {
            if (i != i5) {
                if (i != i4) {
                    arr[i9] = str3;
                } else {
                    arr[i9] = str4;
                }
            } else {
                arr[i9] = str5;
            }
        } else {
            arr[i9] = str6;
        }
        switch (i) {
            case 3:
                arr[i7] = str6;
                break;
            case 5:
                arr[i7] = "createDefaultGetter";
                break;
            case 6:
                arr[i7] = "createGetter";
                break;
            case 7:
                arr[i7] = "createPrimaryConstructorForObject";
                break;
            case 8:
                arr[i7] = str5;
                break;
            case 9:
                arr[i7] = str4;
                break;
            case 10:
                arr[i7] = "isEnumValuesMethod";
                break;
            case 11:
                arr[i7] = "isEnumValueOfMethod";
                break;
            case 12:
                arr[i7] = "isEnumSpecialMethod";
                break;
            case 13:
                arr[i7] = "createExtensionReceiverParameterForCallable";
                break;
            default:
                arr[i7] = "createDefaultSetter";
        }
        String format = String.format(str2, arr);
        if (i != i6 && i != i5 && i != i4) {
            if (i != i5) {
                if (i != i4) {
                    obj11 = new IllegalArgumentException(format);
                } else {
                    obj11 = new IllegalStateException(format);
                }
            } else {
            }
        } else {
        }
        throw obj11;
    }

    public static c0 b(o0 o0, g g2) {
        int i = 0;
        if (o0 == null) {
        } else {
            if (g2 == null) {
            } else {
                final int i3 = 0;
                return c.g(o0, g2, true, i3, i3);
            }
            c.a(14);
            throw i;
        }
        c.a(13);
        throw i;
    }

    public static d0 c(o0 o0, g g2, g g3) {
        final int i = 0;
        if (o0 == null) {
        } else {
            if (g2 == null) {
            } else {
                if (g3 == null) {
                } else {
                    return c.k(o0, g2, g3, true, false, false, o0.getSource());
                }
                c.a(2);
                throw i;
            }
            c.a(1);
            throw i;
        }
        c.a(0);
        throw i;
    }

    public static t0 d(e e) {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVar = e;
        final int i3 = 0;
        if (mVar == null) {
        } else {
            g.a aVar = g.q;
            f0 f0Var2 = f0.k1(mVar, aVar.b(), k.c, b.a.SYNTHESIZED, e.getSource());
            final int i5 = 0;
            super(f0Var2, i5, 0, aVar.b(), e.j("value"), a.g(e).V(), 0, 0, 0, 0, e.getSource());
            f0 f0Var = f0Var2.m1(0, i5, Collections.emptyList(), Collections.singletonList(k0Var), e.q(), z.FINAL, t.e);
            if (f0Var == null) {
            } else {
                return f0Var;
            }
            c.a(25);
            throw i3;
        }
        c.a(24);
        throw i3;
    }

    public static t0 e(e e) {
        final int i = 0;
        if (e == null) {
        } else {
            f0 obj13 = f0.k1(e, g.q.b(), k.b, b.a.SYNTHESIZED, e.getSource()).m1(0, 0, Collections.emptyList(), Collections.emptyList(), a.g(e).l(h1.INVARIANT, e.q()), z.FINAL, t.e);
            if (obj13 == null) {
            } else {
                return obj13;
            }
            c.a(23);
            throw i;
        }
        c.a(22);
        throw i;
    }

    public static r0 f(a a, b0 b02, g g3) {
        int i;
        e0 e0Var;
        b bVar;
        i = 0;
        if (a == null) {
        } else {
            if (g3 == null) {
            } else {
                if (b02 == null) {
                } else {
                    bVar = new b(a, b02, i);
                    e0Var = new e0(a, bVar, g3);
                    i = e0Var;
                }
                return i;
            }
            c.a(30);
            throw i;
        }
        c.a(29);
        throw i;
    }

    public static c0 g(o0 o0, g g2, boolean z3, boolean z4, boolean z5) {
        final int i = 0;
        if (o0 == null) {
        } else {
            if (g2 == null) {
            } else {
                return c.h(o0, g2, z3, z4, z5, o0.getSource());
            }
            c.a(16);
            throw i;
        }
        c.a(15);
        throw i;
    }

    public static c0 h(o0 o0, g g2, boolean z3, boolean z4, boolean z5, u0 u06) {
        int i = 0;
        if (o0 == null) {
        } else {
            if (g2 == null) {
            } else {
                if (u06 == null) {
                } else {
                    super(o0, g2, o0.i(), o0.getVisibility(), z3, z4, z5, b.a.DECLARATION, 0, u06);
                    return c0Var;
                }
                c.a(19);
                throw i;
            }
            c.a(18);
            throw i;
        }
        c.a(17);
        throw i;
    }

    public static f i(e e, u0 u02) {
        int i = 0;
        if (e == null) {
        } else {
            if (u02 == null) {
            } else {
                c.a aVar = new c.a(e, u02, 0);
                return aVar;
            }
            c.a(21);
            throw i;
        }
        c.a(20);
        throw i;
    }

    public static d0 j(o0 o0, g g2, g g3, boolean z4, boolean z5, boolean z6, u u7, u0 u08) {
        int i6 = 0;
        if (o0 == null) {
        } else {
            if (g2 == null) {
            } else {
                if (g3 == null) {
                } else {
                    if (u7 == null) {
                    } else {
                        if (u08 == null) {
                        } else {
                            super(o0, g2, o0.i(), u7, z4, z5, z6, b.a.DECLARATION, 0, u08);
                            d0Var.Q0(d0.O0(d0Var, o0.getType(), g3));
                            return d0Var;
                        }
                        c.a(11);
                        throw i6;
                    }
                    c.a(10);
                    throw i6;
                }
                c.a(9);
                throw i6;
            }
            c.a(8);
            throw i6;
        }
        c.a(7);
        throw i6;
    }

    public static d0 k(o0 o0, g g2, g g3, boolean z4, boolean z5, boolean z6, u0 u07) {
        final int i = 0;
        if (o0 == null) {
        } else {
            if (g2 == null) {
            } else {
                if (g3 == null) {
                } else {
                    if (u07 == null) {
                    } else {
                        return c.j(o0, g2, g3, z4, z5, z6, o0.getVisibility(), u07);
                    }
                    c.a(6);
                    throw i;
                }
                c.a(5);
                throw i;
            }
            c.a(4);
            throw i;
        }
        c.a(3);
        throw i;
    }

    private static boolean l(x x) {
        int obj2;
        if (!x) {
        } else {
            if (x.f() == b.a.SYNTHESIZED && d.A(x.b())) {
                obj2 = d.A(x.b()) ? 1 : 0;
            } else {
            }
            return obj2;
        }
        c.a(28);
        throw 0;
    }

    public static boolean m(x x) {
        int obj2;
        if (x == null) {
        } else {
            if (x.getName().equals(k.c) && c.l(x)) {
                obj2 = c.l(x) ? 1 : 0;
            } else {
            }
            return obj2;
        }
        c.a(27);
        throw 0;
    }

    public static boolean n(x x) {
        int obj2;
        if (x == null) {
        } else {
            if (x.getName().equals(k.b) && c.l(x)) {
                obj2 = c.l(x) ? 1 : 0;
            } else {
            }
            return obj2;
        }
        c.a(26);
        throw 0;
    }
}
