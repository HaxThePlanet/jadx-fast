package com.google.protobuf;

import android.accounts.Account;
import java.util.List;
import java.util.Objects;

/* loaded from: classes2.dex */
final class f {

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            f.a.a = iArr;
            iArr[y1.b.DOUBLE.ordinal()] = 1;
            f.a.a[y1.b.FLOAT.ordinal()] = 2;
            f.a.a[y1.b.INT64.ordinal()] = 3;
            f.a.a[y1.b.UINT64.ordinal()] = 4;
            f.a.a[y1.b.INT32.ordinal()] = 5;
            f.a.a[y1.b.UINT32.ordinal()] = 6;
            f.a.a[y1.b.FIXED64.ordinal()] = 7;
            f.a.a[y1.b.SFIXED64.ordinal()] = 8;
            f.a.a[y1.b.FIXED32.ordinal()] = 9;
            f.a.a[y1.b.SFIXED32.ordinal()] = 10;
            f.a.a[y1.b.BOOL.ordinal()] = 11;
            f.a.a[y1.b.SINT32.ordinal()] = 12;
            f.a.a[y1.b.SINT64.ordinal()] = 13;
            f.a.a[y1.b.ENUM.ordinal()] = 14;
            f.a.a[y1.b.BYTES.ordinal()] = 15;
            f.a.a[y1.b.STRING.ordinal()] = 16;
            f.a.a[y1.b.GROUP.ordinal()] = 17;
            f.a.a[y1.b.MESSAGE.ordinal()] = 18;
        }
    }

    static final class b {

        public int a;
        public long b;
        public Object c;
        public final com.google.protobuf.q d;
        b(com.google.protobuf.q q) {
            super();
            Objects.requireNonNull(q);
            this.d = q;
        }
    }
    static int A(int i, byte[] b2Arr2, int i3, int i4, com.google.protobuf.c0.j<?> c0$j5, com.google.protobuf.f.b f$b6) {
        int i2;
        int i5;
        int obj4;
        obj4 = f.I(b2Arr2, i3, b6);
        (b0)j5.V(k.b(b6.a));
        while (obj4 < i4) {
            if (i != b6.a) {
                break;
            } else {
            }
            obj4 = f.I(b2Arr2, f.I(b2Arr2, obj4, b6), b6);
            j5.V(k.b(b6.a));
        }
        return obj4;
    }

    static int B(int i, byte[] b2Arr2, int i3, int i4, com.google.protobuf.c0.j<?> c0$j5, com.google.protobuf.f.b f$b6) {
        long l;
        long l2;
        int obj4;
        obj4 = f.L(b2Arr2, i3, b6);
        (k0)j5.i(k.c(b6.b));
        while (obj4 < i4) {
            l2 = b6.a;
            if (i != l2) {
                break;
            } else {
            }
            obj4 = f.L(b2Arr2, f.I(b2Arr2, obj4, b6), b6);
            j5.i(k.c(b6.b));
        }
        return obj4;
    }

    static int C(byte[] bArr, int i2, com.google.protobuf.f.b f$b3) {
        int obj4 = f.I(bArr, i2, b3);
        final int i = b3.a;
        if (i < 0) {
        } else {
            if (i == 0) {
                b3.c = "";
                return obj4;
            }
            String string = new String(bArr, obj4, i, c0.a);
            b3.c = string;
            return obj4 += i;
        }
        throw InvalidProtocolBufferException.g();
    }

    static int D(int i, byte[] b2Arr2, int i3, int i4, com.google.protobuf.c0.j<?> c0$j5, com.google.protobuf.f.b f$b6) {
        int i2;
        String string;
        java.nio.charset.Charset charset;
        int obj6;
        i2 = b6.a;
        if (i2 < 0) {
        } else {
            final String str = "";
            if (i2 == 0) {
                j5.add(str);
            } else {
                string = new String(b2Arr2, f.I(b2Arr2, i3, b6), i2, c0.a);
                j5.add(string);
                obj6 += i2;
            }
            while (obj6 < i4) {
                i2 = b6.a;
                if (i2 != 0) {
                    break;
                } else {
                }
                j5.add(str);
            }
            return obj6;
        }
        throw InvalidProtocolBufferException.g();
    }

    static int E(int i, byte[] b2Arr2, int i3, int i4, com.google.protobuf.c0.j<?> c0$j5, com.google.protobuf.f.b f$b6) {
        int i5;
        int i2;
        String string;
        java.nio.charset.Charset charset;
        int obj7;
        obj7 = f.I(b2Arr2, i3, b6);
        i5 = b6.a;
        if (i5 < 0) {
        } else {
            final String str = "";
            if (i5 == 0) {
                j5.add(str);
                while (obj7 < i4) {
                    obj7 = f.I(b2Arr2, f.I(b2Arr2, obj7, b6), b6);
                    i5 = b6.a;
                    j5.add(str);
                }
                return obj7;
            } else {
                if (!x1.t(b2Arr2, obj7, obj7 + i5)) {
                } else {
                    string = new String(b2Arr2, obj7, i5, c0.a);
                    j5.add(string);
                    obj7 = i2;
                }
            }
            throw InvalidProtocolBufferException.d();
        }
        throw InvalidProtocolBufferException.g();
    }

    static int F(byte[] bArr, int i2, com.google.protobuf.f.b f$b3) {
        int obj2 = f.I(bArr, i2, b3);
        final int i = b3.a;
        if (i < 0) {
        } else {
            if (i == 0) {
                b3.c = "";
                return obj2;
            }
            b3.c = x1.h(bArr, obj2, i);
            return obj2 += i;
        }
        throw InvalidProtocolBufferException.g();
    }

    static int G(int i, byte[] b2Arr2, int i3, int i4, com.google.protobuf.t1 t15, com.google.protobuf.f.b f$b6) {
        int i6;
        int i7;
        int i5;
        int i8;
        com.google.protobuf.t1 t1Var;
        com.google.protobuf.f.b bVar;
        int i2;
        com.google.protobuf.j obj10;
        int obj11;
        if (y1.a(i) == 0) {
        } else {
            int i10 = y1.b(i);
            int i14 = 1;
            if (i10 != 0 && i10 != i14 && i10 != 2 && i10 != 3) {
                i14 = 1;
                if (i10 != i14) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 != 5) {
                            } else {
                                t15.q(i, Integer.valueOf(f.h(b2Arr2, i3)));
                                return i3 += 4;
                            }
                            throw InvalidProtocolBufferException.c();
                        }
                        final com.google.protobuf.t1 t1Var2 = t1.n();
                        final int i16 = i11 | 4;
                        i6 = 0;
                        while (obj11 < i4) {
                            i5 = f.I(b2Arr2, obj11, b6);
                            obj11 = b6.a;
                            if (obj11 == i16) {
                                break;
                            } else {
                            }
                            i6 = obj11;
                            obj11 = i2;
                        }
                        if (obj11 > i4) {
                        } else {
                            if (i6 != i16) {
                            } else {
                                t15.q(i, t1Var2);
                                return obj11;
                            }
                        }
                        throw InvalidProtocolBufferException.h();
                    }
                    obj11 = f.I(b2Arr2, i3, b6);
                    int obj12 = b6.a;
                    if (obj12 < 0) {
                    } else {
                        if (obj12 > obj14 -= obj11) {
                        } else {
                            if (obj12 == null) {
                                t15.q(i, j.a);
                            } else {
                                t15.q(i, j.t(b2Arr2, obj11, obj12));
                            }
                            return obj11 += obj12;
                        }
                        throw InvalidProtocolBufferException.m();
                    }
                    throw InvalidProtocolBufferException.g();
                }
                t15.q(i, Long.valueOf(f.j(b2Arr2, i3)));
                return i3 += 8;
            }
            t15.q(i, Long.valueOf(b6.b));
            return f.L(b2Arr2, i3, b6);
        }
        throw InvalidProtocolBufferException.c();
    }

    static int H(int i, byte[] b2Arr2, int i3, com.google.protobuf.f.b f$b4) {
        int i2;
        int obj3;
        i &= 127;
        int i4 = i3 + 1;
        obj3 = b2Arr2[i3];
        if (obj3 >= 0) {
            b4.a = obj1 |= obj2;
            return i4;
        }
        obj1 |= obj3;
        obj3 = i4 + 1;
        byte b = b2Arr2[i4];
        if (b >= 0) {
            b4.a = obj1 |= obj2;
            return obj3;
        }
        obj1 |= i6;
        int i7 = obj3 + 1;
        obj3 = b2Arr2[obj3];
        if (obj3 >= 0) {
            b4.a = obj1 |= obj2;
            return i7;
        }
        obj1 |= obj3;
        byte b2 = b2Arr2[i7];
        if (b2 >= 0) {
            b4.a = obj1 |= obj2;
            return i7 + 1;
        }
        i2 = obj3 + 1;
        while (b2Arr2[obj3] < 0) {
            obj3 = i2;
            i2 = obj3 + 1;
        }
        b4.a = obj1 |= i2;
        return i2;
    }

    static int I(byte[] bArr, int i2, com.google.protobuf.f.b f$b3) {
        final int i = i2 + 1;
        final byte obj2 = bArr[i2];
        if (obj2 >= 0) {
            b3.a = obj2;
            return i;
        }
        return f.H(obj2, bArr, i, b3);
    }

    static int J(int i, byte[] b2Arr2, int i3, int i4, com.google.protobuf.c0.j<?> c0$j5, com.google.protobuf.f.b f$b6) {
        int i2;
        int i5;
        int obj4;
        obj4 = f.I(b2Arr2, i3, b6);
        (b0)j5.V(b6.a);
        while (obj4 < i4) {
            if (i != b6.a) {
                break;
            } else {
            }
            obj4 = f.I(b2Arr2, f.I(b2Arr2, obj4, b6), b6);
            j5.V(b6.a);
        }
        return obj4;
    }

    static int K(long l, byte[] b2Arr2, int i3, com.google.protobuf.f.b f$b4) {
        int i4;
        int i5;
        int i2;
        int i;
        byte b;
        int obj7;
        byte obj10;
        i4 = b4 + 1;
        final int i9 = 7;
        obj7 |= i8;
        i5 = i9;
        while (obj10 < 0) {
            byte b2 = i3[i4];
            obj7 |= i;
            i4 = obj10;
            obj10 = b;
        }
        obj11.b = obj7;
        return i4;
    }

    static int L(byte[] bArr, int i2, com.google.protobuf.f.b f$b3) {
        final int i = i2 + 1;
        final long l = (long)obj6;
        if (Long.compare(l, i3) >= 0) {
            b3.b = l;
            return i;
        }
        return f.K(l, obj2, bArr, i);
    }

    static int M(int i, byte[] b2Arr2, int i3, int i4, com.google.protobuf.c0.j<?> c0$j5, com.google.protobuf.f.b f$b6) {
        long l;
        int i2;
        int obj4;
        obj4 = f.L(b2Arr2, i3, b6);
        (k0)j5.i(b6.b);
        while (obj4 < i4) {
            i2 = b6.a;
            if (i != i2) {
                break;
            } else {
            }
            obj4 = f.L(b2Arr2, f.I(b2Arr2, obj4, b6), b6);
            j5.i(b6.b);
        }
        return obj4;
    }

    static int N(int i, byte[] b2Arr2, int i3, int i4, com.google.protobuf.f.b f$b5) {
        int i2;
        int obj4;
        if (y1.a(i) == 0) {
        } else {
            int i6 = y1.b(i);
            if (i6 != 0 && i6 != 1 && i6 != 2 && i6 != 3) {
                if (i6 != 1) {
                    if (i6 != 2) {
                        if (i6 != 3) {
                            if (i6 != 5) {
                            } else {
                                return i3 += 4;
                            }
                            throw InvalidProtocolBufferException.c();
                        }
                        obj2 |= 4;
                        i2 = 0;
                        while (obj4 < i4) {
                            i2 = b5.a;
                            if (i2 == obj2) {
                                break;
                            } else {
                            }
                            obj4 = f.N(i2, b2Arr2, f.I(b2Arr2, obj4, b5), i4, b5);
                        }
                        if (obj4 > i4) {
                        } else {
                            if (i2 != obj2) {
                            } else {
                                return obj4;
                            }
                        }
                        throw InvalidProtocolBufferException.h();
                    }
                    return obj2 += obj3;
                }
                return i3 += 8;
            }
            return f.L(b2Arr2, i3, b5);
        }
        throw InvalidProtocolBufferException.c();
    }

    static int a(int i, byte[] b2Arr2, int i3, int i4, com.google.protobuf.c0.j<?> c0$j5, com.google.protobuf.f.b f$b6) {
        int i2;
        long l;
        int obj9;
        obj9 = f.L(b2Arr2, i3, b6);
        final int i6 = 0;
        final int i5 = 1;
        final int i7 = 0;
        i2 = Long.compare(l2, i6) != 0 ? i5 : i7;
        (h)j5.i(i2);
        while (obj9 < i4) {
            if (i != b6.a) {
                break;
            } else {
            }
            obj9 = f.L(b2Arr2, f.I(b2Arr2, obj9, b6), b6);
            if (Long.compare(l, i6) != 0) {
            } else {
            }
            i2 = i7;
            j5.i(i2);
            i2 = i5;
        }
        return obj9;
    }

    static int b(byte[] bArr, int i2, com.google.protobuf.f.b f$b3) {
        int obj3 = f.I(bArr, i2, b3);
        final int i = b3.a;
        if (i < 0) {
        } else {
            if (i > length -= obj3) {
            } else {
                if (i == 0) {
                    b3.c = j.a;
                    return obj3;
                }
                b3.c = j.t(bArr, obj3, i);
                return obj3 += i;
            }
            throw InvalidProtocolBufferException.m();
        }
        throw InvalidProtocolBufferException.g();
    }

    static int c(int i, byte[] b2Arr2, int i3, int i4, com.google.protobuf.c0.j<?> c0$j5, com.google.protobuf.f.b f$b6) {
        com.google.protobuf.j i2;
        int i5;
        int obj4;
        obj4 = f.I(b2Arr2, i3, b6);
        i2 = b6.a;
        if (i2 < 0) {
        } else {
            if (i2 > length -= obj4) {
            } else {
                if (i2 == 0) {
                    j5.add(j.a);
                } else {
                    j5.add(j.t(b2Arr2, obj4, i2));
                    obj4 += i2;
                }
                while (obj4 < i4) {
                    obj4 = f.I(b2Arr2, f.I(b2Arr2, obj4, b6), b6);
                    i2 = b6.a;
                    if (i2 != 0) {
                        break;
                    } else {
                    }
                    j5.add(j.a);
                }
                return obj4;
            }
            throw InvalidProtocolBufferException.m();
        }
        throw InvalidProtocolBufferException.g();
    }

    static double d(byte[] bArr, int i2) {
        return Double.longBitsToDouble(f.j(bArr, i2));
    }

    static int e(int i, byte[] b2Arr2, int i3, int i4, com.google.protobuf.c0.j<?> c0$j5, com.google.protobuf.f.b f$b6) {
        double d2;
        double d;
        int obj5;
        (n)j5.h(f.d(b2Arr2, i3));
        i3 += 8;
        while (obj5 < i4) {
            d2 = f.I(b2Arr2, obj5, b6);
            if (i != b6.a) {
                break;
            } else {
            }
            j5.h(f.d(b2Arr2, d2));
            obj5 = d2 + 8;
        }
        return obj5;
    }

    static int f(int i, byte[] b2Arr2, int i3, int i4, com.google.protobuf.z.c<?, ?> z$c5, com.google.protobuf.z.e<?, ?> z$e6, com.google.protobuf.s1<com.google.protobuf.t1, com.google.protobuf.t1> s17, com.google.protobuf.f.b f$b8) {
        int ordinal;
        boolean packed;
        int valueOf;
        int eNUM;
        int i6;
        int i2;
        com.google.protobuf.f.b bVar;
        Object obj7;
        int obj8;
        com.google.protobuf.z.d obj9;
        int obj10;
        Object obj11;
        com.google.protobuf.s1 obj13;
        Object obj14;
        final com.google.protobuf.v extensions = c5.extensions;
        i >>>= 3;
        valueOf = 0;
        if (e6.d.b() && e6.d.isPacked()) {
            if (e6.d.isPacked()) {
                switch (obj10) {
                    case 1:
                        obj7 = new n();
                        obj8 = f.s(b2Arr2, i3, obj7, b8);
                        extensions.x(e6.d, obj7);
                        break;
                    case 2:
                        obj7 = new x();
                        obj8 = f.v(b2Arr2, i3, obj7, b8);
                        extensions.x(e6.d, obj7);
                        break;
                    case 3:
                        obj7 = new k0();
                        obj8 = f.z(b2Arr2, i3, obj7, b8);
                        extensions.x(e6.d, obj7);
                        break;
                    case 4:
                        obj7 = new b0();
                        obj8 = f.y(b2Arr2, i3, obj7, b8);
                        extensions.x(e6.d, obj7);
                        break;
                    case 5:
                        obj7 = new k0();
                        obj8 = f.u(b2Arr2, i3, obj7, b8);
                        extensions.x(e6.d, obj7);
                        break;
                    case 6:
                        obj7 = new b0();
                        obj8 = f.t(b2Arr2, i3, obj7, b8);
                        extensions.x(e6.d, obj7);
                        break;
                    case 7:
                        obj7 = new h();
                        obj8 = f.r(b2Arr2, i3, obj7, b8);
                        extensions.x(e6.d, obj7);
                        break;
                    case 8:
                        obj7 = new b0();
                        obj8 = f.w(b2Arr2, i3, obj7, b8);
                        extensions.x(e6.d, obj7);
                        break;
                    case 9:
                        obj7 = new k0();
                        obj8 = f.x(b2Arr2, i3, obj7, b8);
                        extensions.x(e6.d, obj7);
                        break;
                    case 10:
                        obj10 = new b0();
                        obj8 = f.y(b2Arr2, i3, obj10, b8);
                        obj9 = c5.unknownFields;
                        valueOf = obj9;
                        obj7 = n1.z(obj7, obj10, e6.d.c(), valueOf, s17);
                        c5.unknownFields = (t1)obj7;
                        extensions.x(e6.d, obj10);
                        break;
                    default:
                        obj8 = new StringBuilder();
                        obj8.append("Type cannot be packed: ");
                        obj8.append(e6.d.d());
                        obj7 = new IllegalStateException(obj8.toString());
                        throw obj7;
                }
                return obj8;
            }
        }
        if (e6.b() == y1.b.ENUM) {
            if (e6.d.c().findValueByNumber(b8.a) == null && c5.unknownFields == t1.c()) {
                if (c5.unknownFields == t1.c()) {
                    c5.unknownFields = t1.n();
                }
                n1.L(obj7, b8.a, obj8, s17);
                return f.I(b2Arr2, i3, b8);
            }
            valueOf = Integer.valueOf(b8.a);
        } else {
            switch (obj11) {
                case 1:
                    valueOf = Double.valueOf(f.d(b2Arr2, i3));
                    i3 += 8;
                    break;
                case 2:
                    valueOf = Float.valueOf(f.l(b2Arr2, i3));
                    i3 += 4;
                    break;
                case 3:
                    obj9 = f.L(b2Arr2, i3, b8);
                    valueOf = Long.valueOf(b8.b);
                    break;
                case 4:
                    obj9 = f.I(b2Arr2, i3, b8);
                    valueOf = Integer.valueOf(b8.a);
                    break;
                case 5:
                    valueOf = Long.valueOf(f.j(b2Arr2, i3));
                    i3 += 8;
                    break;
                case 6:
                    valueOf = Integer.valueOf(f.h(b2Arr2, i3));
                    i3 += 4;
                    break;
                case 7:
                    obj9 = f.L(b2Arr2, i3, b8);
                    obj7 = 1;
                    obj7 = 0;
                    valueOf = Boolean.valueOf(obj7);
                    break;
                case 8:
                    obj9 = f.I(b2Arr2, i3, b8);
                    valueOf = Integer.valueOf(k.b(b8.a));
                    break;
                case 9:
                    obj9 = f.L(b2Arr2, i3, b8);
                    valueOf = Long.valueOf(k.c(b8.b));
                    break;
                case 10:
                    obj7 = new IllegalStateException("Shouldn't reach here.");
                    throw obj7;
                case 11:
                    obj9 = f.b(b2Arr2, i3, b8);
                    valueOf = b8.c;
                    break;
                case 12:
                    obj9 = f.C(b2Arr2, i3, b8);
                    valueOf = b8.c;
                    break;
                case 13:
                    obj9 = f.n(g1.a().d(e6.c().getClass()), b2Arr2, i3, i4, obj7 | 4, b8);
                    valueOf = b8.c;
                    break;
                case 14:
                    obj9 = f.p(g1.a().d(e6.c().getClass()), b2Arr2, i3, i4, b8);
                    valueOf = b8.c;
                    break;
                default:
            }
        }
        if (e6.e()) {
            extensions.a(e6.d, valueOf);
        } else {
            obj7 = f.a.a[e6.b().ordinal()];
            if (obj7 != 17 && obj7 != 18) {
                if (obj7 != 18) {
                } else {
                    obj7 = extensions.i(e6.d);
                    if (obj7 != null) {
                        valueOf = c0.h(obj7, valueOf);
                    }
                }
            } else {
            }
            extensions.x(e6.d, valueOf);
        }
        obj8 = obj9;
    }

    static int g(int i, byte[] b2Arr2, int i3, int i4, Object object5, com.google.protobuf.t0 t06, com.google.protobuf.s1<com.google.protobuf.t1, com.google.protobuf.t1> s17, com.google.protobuf.f.b f$b8) {
        com.google.protobuf.z.e eVar = b8.d.a(t06, i >>> 3);
        if (eVar == null) {
            return f.G(i, b2Arr2, i3, i4, w0.w(object5), b8);
        }
        Object obj = object5;
        (z.c)obj.b();
        return f.f(i, b2Arr2, i3, i4, obj, eVar, s17, b8);
    }

    static int h(byte[] bArr, int i2) {
        return obj2 |= i4;
    }

    static int i(int i, byte[] b2Arr2, int i3, int i4, com.google.protobuf.c0.j<?> c0$j5, com.google.protobuf.f.b f$b6) {
        int i2;
        int i5;
        int obj4;
        (b0)j5.V(f.h(b2Arr2, i3));
        i3 += 4;
        while (obj4 < i4) {
            i2 = f.I(b2Arr2, obj4, b6);
            if (i != b6.a) {
                break;
            } else {
            }
            j5.V(f.h(b2Arr2, i2));
            obj4 = i2 + 4;
        }
        return obj4;
    }

    static long j(byte[] bArr, int i2) {
        int i9 = 255;
        return obj7 |= i8;
    }

    static int k(int i, byte[] b2Arr2, int i3, int i4, com.google.protobuf.c0.j<?> c0$j5, com.google.protobuf.f.b f$b6) {
        long l;
        long l2;
        int obj5;
        (k0)j5.i(f.j(b2Arr2, i3));
        i3 += 8;
        while (obj5 < i4) {
            l = f.I(b2Arr2, obj5, b6);
            if (i != b6.a) {
                break;
            } else {
            }
            j5.i(f.j(b2Arr2, l));
            obj5 = l + 8;
        }
        return obj5;
    }

    static float l(byte[] bArr, int i2) {
        return Float.intBitsToFloat(f.h(bArr, i2));
    }

    static int m(int i, byte[] b2Arr2, int i3, int i4, com.google.protobuf.c0.j<?> c0$j5, com.google.protobuf.f.b f$b6) {
        float f;
        int i2;
        int obj4;
        (x)j5.h(f.l(b2Arr2, i3));
        i3 += 4;
        while (obj4 < i4) {
            f = f.I(b2Arr2, obj4, b6);
            if (i != b6.a) {
                break;
            } else {
            }
            j5.h(f.l(b2Arr2, f));
            obj4 = f + 4;
        }
        return obj4;
    }

    static int n(com.google.protobuf.l1 l1, byte[] b2Arr2, int i3, int i4, int i5, com.google.protobuf.f.b f$b6) {
        final Object obj2 = (w0)l1.i();
        l1.c(obj2);
        b6.c = obj2;
        return l1.d0(obj2, b2Arr2, i3, i4, i5, b6);
    }

    static int o(com.google.protobuf.l1 l1, int i2, byte[] b3Arr3, int i4, int i5, com.google.protobuf.c0.j<?> c0$j6, com.google.protobuf.f.b f$b7) {
        Object obj;
        byte[] bArr;
        int i3;
        int i6;
        int i;
        com.google.protobuf.f.b bVar;
        int obj10;
        i7 |= 4;
        obj10 = f.n(l1, b3Arr3, i4, i5, i8, b7);
        j6.add(b7.c);
        while (obj10 < i5) {
            if (i2 != b7.a) {
                break;
            } else {
            }
            obj10 = f.n(l1, b3Arr3, f.I(b3Arr3, obj10, b7), i5, i8, b7);
            j6.add(b7.c);
        }
        return obj10;
    }

    static int p(com.google.protobuf.l1 l1, byte[] b2Arr2, int i3, int i4, com.google.protobuf.f.b f$b5) {
        int i;
        byte obj8;
        int obj9;
        obj8 = b2Arr2[i3];
        if (obj8 < 0) {
            i = f.H(obj8, b2Arr2, i3 + 1, b5);
            obj8 = b5.a;
        }
        final int i2 = i;
        if (obj8 < 0) {
        } else {
            if (obj8 > i4 -= i2) {
            } else {
                obj9 = l1.i();
                obj8 += i2;
                l1.f(obj9, b2Arr2, i2, obj8, b5);
                l1.c(obj9);
                b5.c = obj9;
                return obj8;
            }
        }
        throw InvalidProtocolBufferException.m();
    }

    static int q(com.google.protobuf.l1<?> l1, int i2, byte[] b3Arr3, int i4, int i5, com.google.protobuf.c0.j<?> c0$j6, com.google.protobuf.f.b f$b7) {
        Object obj;
        int i;
        int obj5;
        obj5 = f.p(l1, b3Arr3, i4, i5, b7);
        j6.add(b7.c);
        while (obj5 < i5) {
            if (i2 != b7.a) {
                break;
            } else {
            }
            obj5 = f.p(l1, b3Arr3, f.I(b3Arr3, obj5, b7), i5, b7);
            j6.add(b7.c);
        }
        return obj5;
    }

    static int r(byte[] bArr, int i2, com.google.protobuf.c0.j<?> c0$j3, com.google.protobuf.f.b f$b4) {
        int i;
        int i3;
        int obj6;
        i4 += obj6;
        while (obj6 < i5) {
            obj6 = f.L(bArr, obj6, b4);
            if (Long.compare(l, i3) != 0) {
            } else {
            }
            i = 0;
            (h)j3.i(i);
            i = 1;
        }
        if (obj6 != i5) {
        } else {
            return obj6;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int s(byte[] bArr, int i2, com.google.protobuf.c0.j<?> c0$j3, com.google.protobuf.f.b f$b4) {
        double d;
        int obj3;
        obj5 += obj3;
        while (obj3 < obj5) {
            (n)j3.h(f.d(bArr, obj3));
            obj3 += 8;
        }
        if (obj3 != obj5) {
        } else {
            return obj3;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int t(byte[] bArr, int i2, com.google.protobuf.c0.j<?> c0$j3, com.google.protobuf.f.b f$b4) {
        int i;
        int obj2;
        obj4 += obj2;
        while (obj2 < obj4) {
            (b0)j3.V(f.h(bArr, obj2));
            obj2 += 4;
        }
        if (obj2 != obj4) {
        } else {
            return obj2;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int u(byte[] bArr, int i2, com.google.protobuf.c0.j<?> c0$j3, com.google.protobuf.f.b f$b4) {
        long l;
        int obj3;
        obj5 += obj3;
        while (obj3 < obj5) {
            (k0)j3.i(f.j(bArr, obj3));
            obj3 += 8;
        }
        if (obj3 != obj5) {
        } else {
            return obj3;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int v(byte[] bArr, int i2, com.google.protobuf.c0.j<?> c0$j3, com.google.protobuf.f.b f$b4) {
        float f;
        int obj2;
        obj4 += obj2;
        while (obj2 < obj4) {
            (x)j3.h(f.l(bArr, obj2));
            obj2 += 4;
        }
        if (obj2 != obj4) {
        } else {
            return obj2;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int w(byte[] bArr, int i2, com.google.protobuf.c0.j<?> c0$j3, com.google.protobuf.f.b f$b4) {
        int i;
        int obj3;
        i3 += obj3;
        while (obj3 < i4) {
            obj3 = f.I(bArr, obj3, b4);
            (b0)j3.V(k.b(b4.a));
        }
        if (obj3 != i4) {
        } else {
            return obj3;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int x(byte[] bArr, int i2, com.google.protobuf.c0.j<?> c0$j3, com.google.protobuf.f.b f$b4) {
        long l;
        int obj4;
        i += obj4;
        while (obj4 < i3) {
            obj4 = f.L(bArr, obj4, b4);
            (k0)j3.i(k.c(b4.b));
        }
        if (obj4 != i3) {
        } else {
            return obj4;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int y(byte[] bArr, int i2, com.google.protobuf.c0.j<?> c0$j3, com.google.protobuf.f.b f$b4) {
        int i;
        int obj3;
        i3 += obj3;
        while (obj3 < i4) {
            obj3 = f.I(bArr, obj3, b4);
            (b0)j3.V(b4.a);
        }
        if (obj3 != i4) {
        } else {
            return obj3;
        }
        throw InvalidProtocolBufferException.m();
    }

    static int z(byte[] bArr, int i2, com.google.protobuf.c0.j<?> c0$j3, com.google.protobuf.f.b f$b4) {
        long l;
        int obj4;
        i += obj4;
        while (obj4 < i3) {
            obj4 = f.L(bArr, obj4, b4);
            (k0)j3.i(b4.b);
        }
        if (obj4 != i3) {
        } else {
            return obj4;
        }
        throw InvalidProtocolBufferException.m();
    }
}
