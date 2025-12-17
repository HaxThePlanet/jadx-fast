package com.google.protobuf;

/* loaded from: classes2.dex */
abstract class s1<T, B>  {
    abstract void a(B b, int i2, int i3);

    abstract void b(B b, int i2, long l3);

    abstract void c(B b, int i2, T t3);

    abstract void d(B b, int i2, com.google.protobuf.j j3);

    abstract void e(B b, int i2, long l3);

    abstract B f(Object object);

    abstract T g(Object object);

    abstract int h(T t);

    abstract int i(T t);

    abstract void j(Object object);

    abstract T k(T t, T t2);

    final void l(B b, com.google.protobuf.j1 j12) {
        int i;
        while (j12.A() != Integer.MAX_VALUE) {
            if (m(b, j12)) {
            }
        }
    }

    final boolean m(B b, com.google.protobuf.j1 j12) {
        int tag = j12.getTag();
        final int i2 = y1.a(tag);
        int i = y1.b(tag);
        final int i3 = 1;
        final int i8 = 4;
        if (i != 0 && i != i3 && i != 2 && i != 3 && i != i8) {
            if (i != i3) {
                if (i != 2) {
                    i8 = 4;
                    if (i != 3) {
                        if (i != i8) {
                            if (i != 5) {
                            } else {
                                a(b, i2, j12.i());
                                return i3;
                            }
                            throw InvalidProtocolBufferException.e();
                        }
                        return 0;
                    }
                    Object obj = n();
                    l(obj, j12);
                    if (y1.c(i2, i8) != j12.getTag()) {
                    } else {
                        c(b, i2, r(obj));
                        return i3;
                    }
                    throw InvalidProtocolBufferException.b();
                }
                d(b, i2, j12.F());
                return i3;
            }
            b(b, i2, j12.c());
            return i3;
        }
        e(b, i2, j12.M());
        return i3;
    }

    abstract B n();

    abstract void o(Object object, B b2);

    abstract void p(Object object, T t2);

    abstract boolean q(com.google.protobuf.j1 j1);

    abstract T r(B b);

    abstract void s(T t, com.google.protobuf.z1 z12);

    abstract void t(T t, com.google.protobuf.z1 z12);
}
