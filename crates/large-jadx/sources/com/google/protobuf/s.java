package com.google.protobuf;

import android.accounts.Account;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
final class s extends com.google.protobuf.r<com.google.protobuf.z.d> {

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            s.a.a = iArr;
            iArr[y1.b.DOUBLE.ordinal()] = 1;
            s.a.a[y1.b.FLOAT.ordinal()] = 2;
            s.a.a[y1.b.INT64.ordinal()] = 3;
            s.a.a[y1.b.UINT64.ordinal()] = 4;
            s.a.a[y1.b.INT32.ordinal()] = 5;
            s.a.a[y1.b.FIXED64.ordinal()] = 6;
            s.a.a[y1.b.FIXED32.ordinal()] = 7;
            s.a.a[y1.b.BOOL.ordinal()] = 8;
            s.a.a[y1.b.UINT32.ordinal()] = 9;
            s.a.a[y1.b.SFIXED32.ordinal()] = 10;
            s.a.a[y1.b.SFIXED64.ordinal()] = 11;
            s.a.a[y1.b.SINT32.ordinal()] = 12;
            s.a.a[y1.b.SINT64.ordinal()] = 13;
            s.a.a[y1.b.ENUM.ordinal()] = 14;
            s.a.a[y1.b.BYTES.ordinal()] = 15;
            s.a.a[y1.b.STRING.ordinal()] = 16;
            s.a.a[y1.b.GROUP.ordinal()] = 17;
            s.a.a[y1.b.MESSAGE.ordinal()] = 18;
        }
    }
    int a(Map.Entry<?, ?> map$Entry) {
        return (z.d)entry.getKey().getNumber();
    }

    @Override // com.google.protobuf.r
    Object b(com.google.protobuf.q q, com.google.protobuf.t0 t02, int i3) {
        return q.a(t02, i3);
    }

    com.google.protobuf.v<com.google.protobuf.z.d> c(Object object) {
        return object.extensions;
    }

    com.google.protobuf.v<com.google.protobuf.z.d> d(Object object) {
        return (z.c)object.b();
    }

    @Override // com.google.protobuf.r
    boolean e(com.google.protobuf.t0 t0) {
        return t0 instanceof z.c;
    }

    @Override // com.google.protobuf.r
    void f(Object object) {
        c(object).t();
    }

    <UT, UB> UB g(com.google.protobuf.j1 j1, Object object2, com.google.protobuf.q q3, com.google.protobuf.v<com.google.protobuf.z.d> v4, UB ub5, com.google.protobuf.s1<UT, UB> s16) {
        int ordinal;
        int valueOf;
        boolean packed;
        com.google.protobuf.y1.b bVar;
        com.google.protobuf.y1.b eNUM;
        com.google.protobuf.c0.d obj5;
        ArrayList obj7;
        Object obj9;
        com.google.protobuf.s1 obj10;
        ordinal = (z.e)object2.d();
        if (object2.d.b() && object2.d.isPacked()) {
            if (object2.d.isPacked()) {
                switch (obj7) {
                    case 1:
                        obj7 = new ArrayList();
                        j1.L(obj7);
                        break;
                    case 2:
                        obj7 = new ArrayList();
                        j1.G(obj7);
                        break;
                    case 3:
                        obj7 = new ArrayList();
                        j1.p(obj7);
                        break;
                    case 4:
                        obj7 = new ArrayList();
                        j1.m(obj7);
                        break;
                    case 5:
                        obj7 = new ArrayList();
                        j1.r(obj7);
                        break;
                    case 6:
                        obj7 = new ArrayList();
                        j1.O(obj7);
                        break;
                    case 7:
                        obj7 = new ArrayList();
                        j1.u(obj7);
                        break;
                    case 8:
                        obj7 = new ArrayList();
                        j1.x(obj7);
                        break;
                    case 9:
                        obj7 = new ArrayList();
                        j1.g(obj7);
                        break;
                    case 10:
                        obj7 = new ArrayList();
                        j1.d(obj7);
                        break;
                    case 11:
                        obj7 = new ArrayList();
                        j1.q(obj7);
                        break;
                    case 12:
                        obj7 = new ArrayList();
                        j1.a(obj7);
                        break;
                    case 13:
                        obj7 = new ArrayList();
                        j1.e(obj7);
                        break;
                    case 14:
                        obj7 = new ArrayList();
                        j1.s(obj7);
                        obj9 = n1.z(ordinal, obj7, object2.d.c(), ub5, s16);
                        break;
                    default:
                        obj7 = new StringBuilder();
                        obj7.append("Type cannot be packed: ");
                        obj7.append(object2.d.d());
                        obj5 = new IllegalStateException(obj7.toString());
                        throw obj5;
                }
                v4.x(object2.d, obj7);
                return obj9;
            }
        }
        valueOf = 0;
        if (object2.b() == y1.b.ENUM) {
            obj5 = j1.H();
            if (object2.d.c().findValueByNumber(obj5) == null) {
                return n1.L(ordinal, obj5, ub5, s16);
            }
            valueOf = Integer.valueOf(obj5);
        } else {
            switch (obj10) {
                case 1:
                    valueOf = Double.valueOf(j1.readDouble());
                    break;
                case 2:
                    valueOf = Float.valueOf(j1.readFloat());
                    break;
                case 3:
                    valueOf = Long.valueOf(j1.M());
                    break;
                case 4:
                    valueOf = Long.valueOf(j1.b());
                    break;
                case 5:
                    valueOf = Integer.valueOf(j1.H());
                    break;
                case 6:
                    valueOf = Long.valueOf(j1.c());
                    break;
                case 7:
                    valueOf = Integer.valueOf(j1.i());
                    break;
                case 8:
                    valueOf = Boolean.valueOf(j1.j());
                    break;
                case 9:
                    valueOf = Integer.valueOf(j1.o());
                    break;
                case 10:
                    valueOf = Integer.valueOf(j1.J());
                    break;
                case 11:
                    valueOf = Long.valueOf(j1.l());
                    break;
                case 12:
                    valueOf = Integer.valueOf(j1.v());
                    break;
                case 13:
                    valueOf = Long.valueOf(j1.w());
                    break;
                case 14:
                    obj5 = new IllegalStateException("Shouldn't reach here.");
                    throw obj5;
                case 15:
                    valueOf = j1.F();
                    break;
                case 16:
                    valueOf = j1.y();
                    break;
                case 17:
                    valueOf = j1.z(object2.c().getClass(), q3);
                    break;
                case 18:
                    valueOf = j1.h(object2.c().getClass(), q3);
                    break;
                default:
            }
        }
        if (object2.e()) {
            v4.a(object2.d, valueOf);
        } else {
            obj5 = s.a.a[object2.b().ordinal()];
            if (obj5 != 17 && obj5 != 18) {
                if (obj5 != 18) {
                } else {
                    obj5 = v4.i(object2.d);
                    if (obj5 != null) {
                        valueOf = c0.h(obj5, valueOf);
                    }
                }
            } else {
            }
            v4.x(object2.d, valueOf);
        }
    }

    void h(com.google.protobuf.j1 j1, Object object2, com.google.protobuf.q q3, com.google.protobuf.v<com.google.protobuf.z.d> v4) {
        v4.x(object2.d, j1.h((z.e)object2.c().getClass(), q3));
    }

    void i(com.google.protobuf.j j, Object object2, com.google.protobuf.q q3, com.google.protobuf.v<com.google.protobuf.z.d> v4) {
        com.google.protobuf.t0 partial = (z.e)object2.c().newBuilderForType().buildPartial();
        com.google.protobuf.g obj3 = g.P(ByteBuffer.wrap(j.O()), true);
        g1.a().b(partial, obj3, q3);
        v4.x(object2.d, partial);
        if (obj3.A() != Integer.MAX_VALUE) {
        } else {
        }
        throw InvalidProtocolBufferException.b();
    }

    void j(com.google.protobuf.z1 z1, Map.Entry<?, ?> map$Entry2) {
        int number;
        boolean z;
        double doubleValue;
        int ordinal;
        boolean empty;
        Object obj6;
        number = entry2.getKey();
        if ((z.d)number.b()) {
            ordinal = 0;
            switch (doubleValue) {
                case 1:
                    n1.P(number.getNumber(), (List)entry2.getValue(), z1, number.isPacked());
                    break;
                case 2:
                    n1.T(number.getNumber(), (List)entry2.getValue(), z1, number.isPacked());
                    break;
                case 3:
                    n1.W(number.getNumber(), (List)entry2.getValue(), z1, number.isPacked());
                    break;
                case 4:
                    n1.e0(number.getNumber(), (List)entry2.getValue(), z1, number.isPacked());
                    break;
                case 5:
                    n1.V(number.getNumber(), (List)entry2.getValue(), z1, number.isPacked());
                    break;
                case 6:
                    n1.S(number.getNumber(), (List)entry2.getValue(), z1, number.isPacked());
                    break;
                case 7:
                    n1.R(number.getNumber(), (List)entry2.getValue(), z1, number.isPacked());
                    break;
                case 8:
                    n1.N(number.getNumber(), (List)entry2.getValue(), z1, number.isPacked());
                    break;
                case 9:
                    n1.d0(number.getNumber(), (List)entry2.getValue(), z1, number.isPacked());
                    break;
                case 10:
                    n1.Y(number.getNumber(), (List)entry2.getValue(), z1, number.isPacked());
                    break;
                case 11:
                    n1.Z(number.getNumber(), (List)entry2.getValue(), z1, number.isPacked());
                    break;
                case 12:
                    n1.a0(number.getNumber(), (List)entry2.getValue(), z1, number.isPacked());
                    break;
                case 13:
                    n1.b0(number.getNumber(), (List)entry2.getValue(), z1, number.isPacked());
                    break;
                case 14:
                    n1.V(number.getNumber(), (List)entry2.getValue(), z1, number.isPacked());
                    break;
                case 15:
                    n1.O(number.getNumber(), (List)entry2.getValue(), z1);
                    break;
                case 16:
                    n1.c0(number.getNumber(), (List)entry2.getValue(), z1);
                    break;
                case 17:
                    doubleValue = entry2.getValue();
                    n1.U(number.getNumber(), (List)entry2.getValue(), z1, g1.a().d(doubleValue.get(ordinal).getClass()));
                    break;
                case 18:
                    doubleValue = entry2.getValue();
                    n1.X(number.getNumber(), (List)entry2.getValue(), z1, g1.a().d(doubleValue.get(ordinal).getClass()));
                    break;
                default:
            }
        } else {
            ordinal = number.d().ordinal();
            switch (doubleValue) {
                case 1:
                    z1.g(number.getNumber(), (Double)entry2.getValue().doubleValue());
                    break;
                case 2:
                    z1.G(number.getNumber(), (Float)entry2.getValue().floatValue());
                    break;
                case 3:
                    z1.q(number.getNumber(), (Long)entry2.getValue().longValue());
                    break;
                case 4:
                    z1.o(number.getNumber(), (Long)entry2.getValue().longValue());
                    break;
                case 5:
                    z1.w(number.getNumber(), (Integer)entry2.getValue().intValue());
                    break;
                case 6:
                    z1.k(number.getNumber(), (Long)entry2.getValue().longValue());
                    break;
                case 7:
                    z1.f(number.getNumber(), (Integer)entry2.getValue().intValue());
                    break;
                case 8:
                    z1.r(number.getNumber(), (Boolean)entry2.getValue().booleanValue());
                    break;
                case 9:
                    z1.d(number.getNumber(), (Integer)entry2.getValue().intValue());
                    break;
                case 10:
                    z1.t(number.getNumber(), (Integer)entry2.getValue().intValue());
                    break;
                case 11:
                    z1.z(number.getNumber(), (Long)entry2.getValue().longValue());
                    break;
                case 12:
                    z1.N(number.getNumber(), (Integer)entry2.getValue().intValue());
                    break;
                case 13:
                    z1.F(number.getNumber(), (Long)entry2.getValue().longValue());
                    break;
                case 14:
                    z1.w(number.getNumber(), (Integer)entry2.getValue().intValue());
                    break;
                case 15:
                    z1.v(number.getNumber(), (j)entry2.getValue());
                    break;
                case 16:
                    z1.n(number.getNumber(), (String)entry2.getValue());
                    break;
                case 17:
                    z1.s(number.getNumber(), entry2.getValue(), g1.a().d(entry2.getValue().getClass()));
                    break;
                case 18:
                    z1.j(number.getNumber(), entry2.getValue(), g1.a().d(entry2.getValue().getClass()));
                    break;
                default:
            }
        }
    }
}
