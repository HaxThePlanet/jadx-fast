package com.google.protobuf;

import java.util.Iterator;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
final class x0<T>  implements com.google.protobuf.l1<T> {

    private final com.google.protobuf.t0 a;
    private final com.google.protobuf.s1<?, ?> b;
    private final boolean c;
    private final com.google.protobuf.r<?> d;
    private x0(com.google.protobuf.s1<?, ?> s1, com.google.protobuf.r<?> r2, com.google.protobuf.t0 t03) {
        super();
        this.b = s1;
        this.c = r2.e(t03);
        this.d = r2;
        this.a = t03;
    }

    private <UT, UB> int k(com.google.protobuf.s1<UT, UB> s1, T t2) {
        return s1.i(s1.g(t2));
    }

    private <UT, UB, ET extends com.google.protobuf.v.b<ET>> void l(com.google.protobuf.s1<UT, UB> s1, com.google.protobuf.r<ET> r2, T t3, com.google.protobuf.j1 j14, com.google.protobuf.q q5) {
        boolean z;
        com.google.protobuf.j1 j1Var;
        com.google.protobuf.q qVar;
        com.google.protobuf.r rVar;
        com.google.protobuf.v vVar;
        com.google.protobuf.s1 s1Var;
        Object obj;
        final Object obj3 = s1.f(t3);
        while (j14.A() == Integer.MAX_VALUE) {
        }
        s1.o(t3, obj3);
    }

    static <T> com.google.protobuf.x0<T> m(com.google.protobuf.s1<?, ?> s1, com.google.protobuf.r<?> r2, com.google.protobuf.t0 t03) {
        x0 x0Var = new x0(s1, r2, t03);
        return x0Var;
    }

    private <UT, UB, ET extends com.google.protobuf.v.b<ET>> boolean n(com.google.protobuf.j1 j1, com.google.protobuf.q q2, com.google.protobuf.r<ET> r3, com.google.protobuf.v<ET> v4, com.google.protobuf.s1<UT, UB> s15, UB ub6) {
        int i;
        int i2;
        int i4;
        int tag;
        int i3;
        int tag2 = j1.getTag();
        final int i8 = 1;
        Object obj = r3.b(q2, this.a, y1.a(tag2));
        if (tag2 != y1.a && y1.b(tag2) == 2 && obj != null) {
            if (y1.b(tag2) == 2) {
                obj = r3.b(q2, this.a, y1.a(tag2));
                if (obj != null) {
                    r3.h(j1, obj, q2, v4);
                    return i8;
                }
                return s15.m(ub6, j1);
            }
            return j1.I();
        }
        i = 0;
        i4 = i2;
        while (j1.A() == Integer.MAX_VALUE) {
            tag = j1.getTag();
            if (j1.I()) {
                break;
            }
            if (i2 != 0) {
            } else {
            }
            i4 = j1.F();
            r3.h(j1, i2, q2, v4);
            i2 = r3.b(q2, this.a, j1.o());
        }
        if (j1.getTag() != y1.b) {
        } else {
            if (i4 != 0) {
                if (i2 != 0) {
                    r3.i(i4, i2, q2, v4);
                } else {
                    s15.d(ub6, i, i4);
                }
            }
            return i8;
        }
        throw InvalidProtocolBufferException.b();
    }

    private <UT, UB> void o(com.google.protobuf.s1<UT, UB> s1, T t2, com.google.protobuf.z1 z13) {
        s1.s(s1.g(t2), z13);
    }

    public void a(T t, T t2) {
        boolean z;
        n1.G(this.b, t, t2);
        if (this.c) {
            n1.E(this.d, t, t2);
        }
    }

    public void b(T t, com.google.protobuf.z1 z12) {
        Object value;
        int number;
        boolean z;
        com.google.protobuf.y1.c packed;
        com.google.protobuf.y1.c mESSAGE;
        Iterator it = this.d.c(t).s();
        for (Map.Entry next2 : it) {
            Object key = next2.getKey();
            if (next2 instanceof f0.b) {
            } else {
            }
            z12.e(key.getNumber(), next2.getValue());
            z12.e(key.getNumber(), (f0.b)next2.a().e());
        }
        o(this.b, t, z12);
    }

    public void c(T t) {
        this.b.j(t);
        this.d.f(t);
    }

    public final boolean d(T t) {
        return this.d.c(t).p();
    }

    public void e(T t, com.google.protobuf.j1 j12, com.google.protobuf.q q3) {
        this.l(this.b, this.d, t, j12, q3);
    }

    public void f(T t, byte[] b2Arr2, int i3, int i4, com.google.protobuf.f.b f$b5) {
        com.google.protobuf.t1 unknownFields;
        int i6;
        int i;
        byte[] bArr;
        int i2;
        int i7;
        com.google.protobuf.t1 t1Var;
        com.google.protobuf.f.b bVar;
        Object obj;
        int i5;
        int obj13;
        Object obj2 = t;
        if (obj2.unknownFields == t1.c()) {
            obj2.unknownFields = t1.n();
        }
        com.google.protobuf.v obj11 = (z.c)t.b();
        int i8 = 0;
        i6 = i8;
        while (obj13 < i4) {
            i2 = f.I(b2Arr2, obj13, b5);
            obj13 = b5.a;
            i7 = 2;
            if (obj13 != y1.a) {
            } else {
            }
            obj13 = 0;
            bArr = i8;
            while (i2 < i4) {
                i2 = f.I(b2Arr2, i2, b5);
                t1Var = b5.a;
                bVar = y1.a(t1Var);
                obj = y1.b(t1Var);
                if (t1Var == y1.b) {
                    break loop_12;
                } else {
                }
                i2 = f.N(t1Var, b2Arr2, i2, i4, b5);
                i2 = f.I(b2Arr2, i2, b5);
                i6 = this.d.b(b5.d, this.a, b5.a);
                i2 = f.b(b2Arr2, i2, b5);
                bArr = b5.c;
                i2 = f.p(g1.a().d(i6.c().getClass()), b2Arr2, i2, i4, b5);
                obj11.x(i6.d, b5.c);
            }
            if (bArr != 0) {
            }
            obj13 = i2;
            unknownFields.q(y1.c(obj13, i7), bArr);
            i2 = f.I(b2Arr2, i2, b5);
            t1Var = b5.a;
            bVar = y1.a(t1Var);
            obj = y1.b(t1Var);
            if (bVar != i7) {
            } else {
            }
            if (obj == null) {
            } else {
            }
            if (t1Var == y1.b) {
            } else {
            }
            i2 = f.N(t1Var, b2Arr2, i2, i4, b5);
            i2 = f.I(b2Arr2, i2, b5);
            i6 = this.d.b(b5.d, this.a, b5.a);
            if (bVar != 3) {
            } else {
            }
            if (i6 != 0) {
            } else {
            }
            if (obj == i7) {
            } else {
            }
            i2 = f.b(b2Arr2, i2, b5);
            bArr = b5.c;
            i2 = f.p(g1.a().d(i6.c().getClass()), b2Arr2, i2, i4, b5);
            obj11.x(i6.d, b5.c);
            if (y1.b(obj13) == i7) {
            } else {
            }
            obj13 = f.N(obj13, b2Arr2, i2, i4, b5);
            obj = obj3;
            if ((z.e)obj != null) {
            } else {
            }
            obj13 = f.G(obj13, b2Arr2, i2, i4, unknownFields, b5);
            i6 = obj;
            obj13 = f.p(g1.a().d((z.e)obj.c().getClass()), b2Arr2, i2, i4, b5);
            obj11.x(obj.d, b5.c);
        }
        if (obj13 != i4) {
        } else {
        }
        throw InvalidProtocolBufferException.h();
    }

    public boolean g(T t, T t2) {
        if (!this.b.g(t).equals(this.b.g(t2))) {
            return 0;
        }
        if (this.c) {
            return this.d.c(t).equals(this.d.c(t2));
        }
        return 1;
    }

    public int h(T t) {
        int i;
        boolean z;
        Object obj3;
        if (this.c) {
            i += obj3;
        }
        return i;
    }

    public T i() {
        return this.a.newBuilderForType().buildPartial();
    }

    public int j(T t) {
        int i;
        boolean z;
        Object obj3;
        if (this.c) {
            i2 += obj3;
        }
        return i;
    }
}
