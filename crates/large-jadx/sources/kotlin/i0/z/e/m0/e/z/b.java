package kotlin.i0.z.e.m0.e.z;

import kotlin.i0.z.e.m0.e.c.c;
import kotlin.i0.z.e.m0.e.j;
import kotlin.i0.z.e.m0.e.k;
import kotlin.i0.z.e.m0.e.x;
import kotlin.reflect.jvm.internal.impl.protobuf.i.a;

/* loaded from: classes3.dex */
public class b {

    public static final kotlin.i0.z.e.m0.e.z.b.b A;
    public static final kotlin.i0.z.e.m0.e.z.b.b B;
    public static final kotlin.i0.z.e.m0.e.z.b.b C;
    public static final kotlin.i0.z.e.m0.e.z.b.b D;
    public static final kotlin.i0.z.e.m0.e.z.b.b E;
    public static final kotlin.i0.z.e.m0.e.z.b.b F;
    public static final kotlin.i0.z.e.m0.e.z.b.b G;
    public static final kotlin.i0.z.e.m0.e.z.b.b H;
    public static final kotlin.i0.z.e.m0.e.z.b.b I;
    public static final kotlin.i0.z.e.m0.e.z.b.b J;
    public static final kotlin.i0.z.e.m0.e.z.b.b K;
    public static final kotlin.i0.z.e.m0.e.z.b.b L;
    public static final kotlin.i0.z.e.m0.e.z.b.b M;
    public static final kotlin.i0.z.e.m0.e.z.b.b a;
    public static final kotlin.i0.z.e.m0.e.z.b.b b;
    public static final kotlin.i0.z.e.m0.e.z.b.d<x> c;
    public static final kotlin.i0.z.e.m0.e.z.b.d<k> d;
    public static final kotlin.i0.z.e.m0.e.z.b.d<c.c> e;
    public static final kotlin.i0.z.e.m0.e.z.b.b f;
    public static final kotlin.i0.z.e.m0.e.z.b.b g;
    public static final kotlin.i0.z.e.m0.e.z.b.b h;
    public static final kotlin.i0.z.e.m0.e.z.b.b i;
    public static final kotlin.i0.z.e.m0.e.z.b.b j;
    public static final kotlin.i0.z.e.m0.e.z.b.b k;
    public static final kotlin.i0.z.e.m0.e.z.b.b l;
    public static final kotlin.i0.z.e.m0.e.z.b.b m;
    public static final kotlin.i0.z.e.m0.e.z.b.d<j> n;
    public static final kotlin.i0.z.e.m0.e.z.b.b o;
    public static final kotlin.i0.z.e.m0.e.z.b.b p;
    public static final kotlin.i0.z.e.m0.e.z.b.b q;
    public static final kotlin.i0.z.e.m0.e.z.b.b r;
    public static final kotlin.i0.z.e.m0.e.z.b.b s;
    public static final kotlin.i0.z.e.m0.e.z.b.b t;
    public static final kotlin.i0.z.e.m0.e.z.b.b u;
    public static final kotlin.i0.z.e.m0.e.z.b.b v;
    public static final kotlin.i0.z.e.m0.e.z.b.b w;
    public static final kotlin.i0.z.e.m0.e.z.b.b x;
    public static final kotlin.i0.z.e.m0.e.z.b.b y;
    public static final kotlin.i0.z.e.m0.e.z.b.b z;

    static class a {
    }

    public static abstract class d {

        public final int a;
        public final int b;
        private d(int i, int i2) {
            super();
            this.a = i;
            this.b = i2;
        }

        d(int i, int i2, kotlin.i0.z.e.m0.e.z.b.a b$a3) {
            super(i, i2);
        }

        public static <E extends i.a> kotlin.i0.z.e.m0.e.z.b.d<E> a(kotlin.i0.z.e.m0.e.z.b.d<?> b$d, E[] e2Arr2) {
            b.c obj1 = new b.c(i += obj1, e2Arr2);
            return obj1;
        }

        public static kotlin.i0.z.e.m0.e.z.b.b b(kotlin.i0.z.e.m0.e.z.b.d<?> b$d) {
            b.b obj1 = new b.b(i += obj1);
            return obj1;
        }

        public static kotlin.i0.z.e.m0.e.z.b.b c() {
            b.b bVar = new b.b(0);
            return bVar;
        }

        public abstract E d(int i);

        public abstract int e(E e);
    }

    public static class b extends kotlin.i0.z.e.m0.e.z.b.d<Boolean> {
        public b(int i) {
            super(i, 1, 0);
        }

        private static void f(int i) {
            Object[] obj2 = new Object[2];
            IllegalStateException illegalStateException = new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$BooleanFlagField", "get"));
            throw illegalStateException;
        }

        @Override // kotlin.i0.z.e.m0.e.z.b$d
        public Object d(int i) {
            return g(i);
        }

        @Override // kotlin.i0.z.e.m0.e.z.b$d
        public int e(Object object) {
            return h((Boolean)object);
        }

        @Override // kotlin.i0.z.e.m0.e.z.b$d
        public Boolean g(int i) {
            int i2;
            int i5 = 0;
            if (i &= i4 != 0) {
            } else {
                i2 = i5;
            }
            Boolean obj3 = Boolean.valueOf(i2);
            if (obj3 == null) {
            } else {
                return obj3;
            }
            b.b.f(i5);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.e.z.b$d
        public int h(Boolean boolean) {
            int i;
            int obj2;
            if (boolean.booleanValue()) {
                obj2 <<= i;
            } else {
                obj2 = 0;
            }
            return obj2;
        }
    }

    private static class c extends kotlin.i0.z.e.m0.e.z.b.d<E> {

        private final E[] c;
        public c(int i, E[] e2Arr2) {
            super(i, b.c.g(e2Arr2), 0);
            this.c = e2Arr2;
        }

        private static void f(int i) {
            Object[] obj2 = new Object[3];
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "enumEntries", "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags$EnumLiteFlagField", "bitWidth"));
            throw illegalArgumentException;
        }

        private static <E> int g(E[] eArr) {
            int i;
            int i2;
            if (eArr == null) {
            } else {
                int i4 = 1;
                length -= i4;
                if (i3 == 0) {
                    return i4;
                }
                i = 31;
                while (i >= 0) {
                    i--;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Empty enum: ");
                stringBuilder.append(eArr.getClass());
                IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                throw illegalStateException;
            }
            b.c.f(0);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.e.z.b$d
        public Object d(int i) {
            return h(i);
        }

        @Override // kotlin.i0.z.e.m0.e.z.b$d
        public int e(Object object) {
            return i((i.a)object);
        }

        public E h(int i) {
            int i2;
            i.a aVar;
            int number;
            int i7 = 1;
            int i8 = this.a;
            i.a[] objArr = this.c;
            i2 = 0;
            while (i2 < objArr.length) {
                aVar = objArr[i2];
                i2++;
            }
            return 0;
        }

        public int i(E e) {
            return obj2 <<= i;
        }
    }
    static {
        b.a = b.d.c();
        kotlin.i0.z.e.m0.e.z.b.b bVar2 = b.d.c();
        b.b = bVar2;
        kotlin.i0.z.e.m0.e.z.b.d dVar = b.d.a(bVar2, x.values());
        b.c = dVar;
        kotlin.i0.z.e.m0.e.z.b.d dVar3 = b.d.a(dVar, k.values());
        b.d = dVar3;
        kotlin.i0.z.e.m0.e.z.b.d dVar4 = b.d.a(dVar3, c.c.values());
        b.e = dVar4;
        kotlin.i0.z.e.m0.e.z.b.b bVar22 = b.d.b(dVar4);
        b.f = bVar22;
        kotlin.i0.z.e.m0.e.z.b.b bVar23 = b.d.b(bVar22);
        b.g = bVar23;
        kotlin.i0.z.e.m0.e.z.b.b bVar24 = b.d.b(bVar23);
        b.h = bVar24;
        kotlin.i0.z.e.m0.e.z.b.b bVar25 = b.d.b(bVar24);
        b.i = bVar25;
        kotlin.i0.z.e.m0.e.z.b.b bVar26 = b.d.b(bVar25);
        b.j = bVar26;
        b.k = b.d.b(bVar26);
        kotlin.i0.z.e.m0.e.z.b.b bVar11 = b.d.b(dVar);
        b.l = bVar11;
        b.m = b.d.b(bVar11);
        kotlin.i0.z.e.m0.e.z.b.d dVar2 = b.d.a(dVar3, j.values());
        b.n = dVar2;
        kotlin.i0.z.e.m0.e.z.b.b bVar28 = b.d.b(dVar2);
        b.o = bVar28;
        kotlin.i0.z.e.m0.e.z.b.b bVar29 = b.d.b(bVar28);
        b.p = bVar29;
        kotlin.i0.z.e.m0.e.z.b.b bVar30 = b.d.b(bVar29);
        b.q = bVar30;
        kotlin.i0.z.e.m0.e.z.b.b bVar31 = b.d.b(bVar30);
        b.r = bVar31;
        kotlin.i0.z.e.m0.e.z.b.b bVar32 = b.d.b(bVar31);
        b.s = bVar32;
        kotlin.i0.z.e.m0.e.z.b.b bVar33 = b.d.b(bVar32);
        b.t = bVar33;
        kotlin.i0.z.e.m0.e.z.b.b bVar34 = b.d.b(bVar33);
        b.u = bVar34;
        b.v = b.d.b(bVar34);
        kotlin.i0.z.e.m0.e.z.b.b bVar13 = b.d.b(dVar2);
        b.w = bVar13;
        kotlin.i0.z.e.m0.e.z.b.b bVar14 = b.d.b(bVar13);
        b.x = bVar14;
        kotlin.i0.z.e.m0.e.z.b.b bVar15 = b.d.b(bVar14);
        b.y = bVar15;
        kotlin.i0.z.e.m0.e.z.b.b bVar16 = b.d.b(bVar15);
        b.z = bVar16;
        kotlin.i0.z.e.m0.e.z.b.b bVar17 = b.d.b(bVar16);
        b.A = bVar17;
        kotlin.i0.z.e.m0.e.z.b.b bVar18 = b.d.b(bVar17);
        b.B = bVar18;
        kotlin.i0.z.e.m0.e.z.b.b bVar19 = b.d.b(bVar18);
        b.C = bVar19;
        kotlin.i0.z.e.m0.e.z.b.b bVar20 = b.d.b(bVar19);
        b.D = bVar20;
        b.E = b.d.b(bVar20);
        kotlin.i0.z.e.m0.e.z.b.b bVar3 = b.d.b(bVar2);
        b.F = bVar3;
        kotlin.i0.z.e.m0.e.z.b.b bVar4 = b.d.b(bVar3);
        b.G = bVar4;
        b.H = b.d.b(bVar4);
        kotlin.i0.z.e.m0.e.z.b.b bVar6 = b.d.b(dVar3);
        b.I = bVar6;
        kotlin.i0.z.e.m0.e.z.b.b bVar7 = b.d.b(bVar6);
        b.J = bVar7;
        b.K = b.d.b(bVar7);
        kotlin.i0.z.e.m0.e.z.b.b bVar9 = b.d.c();
        b.L = bVar9;
        b.d.b(bVar9);
        b.M = b.d.c();
    }

    private static void a(int i) {
        String str;
        int i2;
        int i3;
        String obj5;
        Object[] arr = new Object[3];
        final int i6 = 1;
        int i7 = 0;
        final int i9 = 2;
        if (i != i6) {
            if (i != i9) {
                if (i != 5) {
                    if (i != 6) {
                        if (i != 8) {
                            if (i != 9) {
                                if (i != 11) {
                                    arr[i7] = "visibility";
                                } else {
                                    arr[i7] = "modality";
                                }
                            } else {
                                arr[i7] = "memberKind";
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
                arr[i7] = "kind";
            }
        } else {
        }
        arr[i6] = "kotlin/reflect/jvm/internal/impl/metadata/deserialization/Flags";
        switch (i) {
            case 3:
                arr[i9] = "getConstructorFlags";
                break;
            case 4:
                arr[i9] = "getFunctionFlags";
                break;
            case 5:
                arr[i9] = "getPropertyFlags";
                break;
            case 6:
                arr[i9] = "getAccessorFlags";
                break;
            default:
                arr[i9] = "getClassFlags";
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
        throw illegalArgumentException;
    }

    public static int b(boolean z, x x2, k k3, boolean z4, boolean z5, boolean z6) {
        int i = 0;
        if (x2 == null) {
        } else {
            if (k3 == null) {
            } else {
                return obj1 |= obj2;
            }
            b.a(11);
            throw i;
        }
        b.a(10);
        throw i;
    }
}
