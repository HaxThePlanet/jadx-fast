package kotlin.i0.z.e.m0.d.a.e0;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.h;
import kotlin.i0.z.e.m0.i.i;
import kotlin.i0.z.e.m0.i.j;
import kotlin.i0.z.e.m0.j.b.p;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.b.a;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;

/* loaded from: classes3.dex */
public final class a {

    static class a extends h {

        final p a;
        final Set b;
        final boolean c;
        a(p p, Set set2, boolean z3) {
            this.a = p;
            this.b = set2;
            this.c = z3;
            super();
        }

        private static void f(int i) {
            String str;
            String obj7;
            int i2 = 3;
            final Object[] arr = new Object[i2];
            final int i3 = 4;
            final int i4 = 1;
            int i5 = 0;
            final int i6 = 2;
            if (i != i4) {
                if (i != i6) {
                    if (i != i2) {
                        if (i != i3) {
                            arr[i5] = "fakeOverride";
                        } else {
                            arr[i5] = "overridden";
                        }
                    } else {
                        arr[i5] = "member";
                    }
                } else {
                    arr[i5] = "fromCurrent";
                }
            } else {
                arr[i5] = "fromSuper";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
            if (i != i4 && i != i6) {
                if (i != i6) {
                    if (i != i2 && i != i3) {
                        if (i != i3) {
                            arr[i6] = "addFakeOverride";
                        } else {
                            arr[i6] = "setOverriddenDescriptors";
                        }
                    } else {
                    }
                } else {
                    arr[i6] = "conflict";
                }
            } else {
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        @Override // kotlin.i0.z.e.m0.i.h
        public void a(b b) {
            if (b == null) {
            } else {
                a.a.a aVar = new a.a.a(this);
                j.N(b, aVar);
                this.b.add(b);
            }
            a.a.f(0);
            throw 0;
        }

        public void d(b b, Collection<? extends b> collection2) {
            boolean z;
            b.a fAKE_OVERRIDE;
            int i = 0;
            if (b == null) {
            } else {
                if (collection2 == null) {
                } else {
                    if (this.c && b.f() != b.a.FAKE_OVERRIDE) {
                        if (b.f() != b.a.FAKE_OVERRIDE) {
                        }
                    }
                    super.d(b, collection2);
                }
                a.a.f(4);
                throw i;
            }
            a.a.f(3);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.i.h
        public void e(b b, b b2) {
            final int i = 0;
            if (b == null) {
            } else {
                if (b2 == null) {
                } else {
                }
                a.a.f(2);
                throw i;
            }
            a.a.f(1);
            throw i;
        }
    }
    private static void a(int i) {
        String str;
        int i2;
        String str3;
        String str2;
        Object obj7;
        final int i4 = 18;
        str = i != i4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        final int i5 = 2;
        i2 = i != i4 ? 3 : i5;
        Object[] arr = new Object[i2];
        str3 = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        int i6 = 0;
        switch (i) {
            case 1:
                arr[i6] = "membersFromSupertypes";
                break;
            case 2:
                arr[i6] = "membersFromCurrent";
                break;
            case 3:
                arr[i6] = "classDescriptor";
                break;
            case 4:
                arr[i6] = "errorReporter";
                break;
            case 5:
                arr[i6] = "overridingUtil";
                break;
            case 6:
                arr[i6] = "name";
                break;
            case 7:
                arr[i6] = str3;
                break;
            default:
                arr[i6] = "annotationClass";
        }
        String str4 = "resolveOverrides";
        int i7 = 1;
        if (i != i4) {
            arr[i7] = str3;
        } else {
            arr[i7] = str4;
        }
        switch (i) {
            case 6:
                arr[i5] = "resolveOverridesForStaticMembers";
                break;
            case 7:
                arr[i5] = str4;
                break;
            case 9:
                arr[i5] = "getAnnotationParameterByName";
                break;
            default:
                arr[i5] = "resolveOverridesForNonStaticMembers";
        }
        String format = String.format(str, arr);
        if (i != i4) {
            obj7 = new IllegalArgumentException(format);
        } else {
            obj7 = new IllegalStateException(format);
        }
        throw obj7;
    }

    public static c1 b(e e, e e2) {
        int size;
        int equals;
        final int i = 0;
        if (e == null) {
        } else {
            if (e2 == null) {
            } else {
                Collection obj4 = e2.j();
                if (obj4.size() != 1) {
                    return i;
                }
                obj4 = (d)obj4.iterator().next().h().iterator();
                for (c1 size : obj4) {
                }
                return i;
            }
            a.a(20);
            throw i;
        }
        a.a(19);
        throw i;
    }

    private static <D extends b> Collection<D> c(e e, Collection<D> collection2, Collection<D> collection3, e e4, p p5, j j6, boolean z7) {
        int i = 0;
        if (e == null) {
        } else {
            if (collection2 == null) {
            } else {
                if (collection3 == null) {
                } else {
                    if (e4 == null) {
                    } else {
                        if (p5 == null) {
                        } else {
                            if (j6 == null) {
                            } else {
                                LinkedHashSet linkedHashSet = new LinkedHashSet();
                                a.a aVar = new a.a(p5, linkedHashSet, z7);
                                j6.y(e, collection2, collection3, e4, aVar);
                                return linkedHashSet;
                            }
                            a.a(17);
                            throw i;
                        }
                        a.a(16);
                        throw i;
                    }
                    a.a(15);
                    throw i;
                }
                a.a(14);
                throw i;
            }
            a.a(13);
            throw i;
        }
        a.a(12);
        throw i;
    }

    public static <D extends b> Collection<D> d(e e, Collection<D> collection2, Collection<D> collection3, e e4, p p5, j j6) {
        final int i = 0;
        if (e == null) {
        } else {
            if (collection2 == null) {
            } else {
                if (collection3 == null) {
                } else {
                    if (e4 == null) {
                    } else {
                        if (p5 == null) {
                        } else {
                            if (j6 == null) {
                            } else {
                                return a.c(e, collection2, collection3, e4, p5, j6, false);
                            }
                            a.a(5);
                            throw i;
                        }
                        a.a(4);
                        throw i;
                    }
                    a.a(3);
                    throw i;
                }
                a.a(2);
                throw i;
            }
            a.a(1);
            throw i;
        }
        a.a(0);
        throw i;
    }

    public static <D extends b> Collection<D> e(e e, Collection<D> collection2, Collection<D> collection3, e e4, p p5, j j6) {
        final int i = 0;
        if (e == null) {
        } else {
            if (collection2 == null) {
            } else {
                if (collection3 == null) {
                } else {
                    if (e4 == null) {
                    } else {
                        if (p5 == null) {
                        } else {
                            if (j6 == null) {
                            } else {
                                return a.c(e, collection2, collection3, e4, p5, j6, true);
                            }
                            a.a(11);
                            throw i;
                        }
                        a.a(10);
                        throw i;
                    }
                    a.a(9);
                    throw i;
                }
                a.a(8);
                throw i;
            }
            a.a(7);
            throw i;
        }
        a.a(6);
        throw i;
    }
}
