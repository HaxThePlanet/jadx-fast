package com.google.protobuf;

/* loaded from: classes2.dex */
class u1 extends com.google.protobuf.s1<com.google.protobuf.t1, com.google.protobuf.t1> {
    @Override // com.google.protobuf.s1
    com.google.protobuf.t1 A(Object object) {
        return object.unknownFields;
    }

    @Override // com.google.protobuf.s1
    int B(com.google.protobuf.t1 t1) {
        return t1.d();
    }

    @Override // com.google.protobuf.s1
    int C(com.google.protobuf.t1 t1) {
        return t1.e();
    }

    @Override // com.google.protobuf.s1
    com.google.protobuf.t1 D(com.google.protobuf.t1 t1, com.google.protobuf.t1 t12) {
        com.google.protobuf.t1 obj2;
        if (t12.equals(t1.c())) {
        } else {
            obj2 = t1.m(t1, t12);
        }
        return obj2;
    }

    @Override // com.google.protobuf.s1
    com.google.protobuf.t1 E() {
        return t1.n();
    }

    @Override // com.google.protobuf.s1
    void F(Object object, com.google.protobuf.t1 t12) {
        G(object, t12);
    }

    @Override // com.google.protobuf.s1
    void G(Object object, com.google.protobuf.t1 t12) {
        object.unknownFields = t12;
    }

    @Override // com.google.protobuf.s1
    com.google.protobuf.t1 H(com.google.protobuf.t1 t1) {
        t1.h();
        return t1;
    }

    @Override // com.google.protobuf.s1
    void I(com.google.protobuf.t1 t1, com.google.protobuf.z1 z12) {
        t1.s(z12);
    }

    @Override // com.google.protobuf.s1
    void J(com.google.protobuf.t1 t1, com.google.protobuf.z1 z12) {
        t1.u(z12);
    }

    @Override // com.google.protobuf.s1
    void a(Object object, int i2, int i3) {
        u((t1)object, i2, i3);
    }

    @Override // com.google.protobuf.s1
    void b(Object object, int i2, long l3) {
        v((t1)object, i2, l3);
    }

    @Override // com.google.protobuf.s1
    void c(Object object, int i2, Object object3) {
        w((t1)object, i2, (t1)object3);
    }

    @Override // com.google.protobuf.s1
    void d(Object object, int i2, com.google.protobuf.j j3) {
        x((t1)object, i2, j3);
    }

    @Override // com.google.protobuf.s1
    void e(Object object, int i2, long l3) {
        y((t1)object, i2, l3);
    }

    @Override // com.google.protobuf.s1
    Object f(Object object) {
        return z(object);
    }

    @Override // com.google.protobuf.s1
    Object g(Object object) {
        return A(object);
    }

    @Override // com.google.protobuf.s1
    int h(Object object) {
        return B((t1)object);
    }

    @Override // com.google.protobuf.s1
    int i(Object object) {
        return C((t1)object);
    }

    @Override // com.google.protobuf.s1
    void j(Object object) {
        A(object).h();
    }

    @Override // com.google.protobuf.s1
    Object k(Object object, Object object2) {
        return D((t1)object, (t1)object2);
    }

    @Override // com.google.protobuf.s1
    Object n() {
        return E();
    }

    @Override // com.google.protobuf.s1
    void o(Object object, Object object2) {
        F(object, (t1)object2);
    }

    @Override // com.google.protobuf.s1
    void p(Object object, Object object2) {
        G(object, (t1)object2);
    }

    @Override // com.google.protobuf.s1
    boolean q(com.google.protobuf.j1 j1) {
        return 0;
    }

    @Override // com.google.protobuf.s1
    Object r(Object object) {
        H((t1)object);
        return object;
    }

    @Override // com.google.protobuf.s1
    void s(Object object, com.google.protobuf.z1 z12) {
        I((t1)object, z12);
    }

    @Override // com.google.protobuf.s1
    void t(Object object, com.google.protobuf.z1 z12) {
        J((t1)object, z12);
    }

    @Override // com.google.protobuf.s1
    void u(com.google.protobuf.t1 t1, int i2, int i3) {
        t1.q(y1.c(i2, 5), Integer.valueOf(i3));
    }

    @Override // com.google.protobuf.s1
    void v(com.google.protobuf.t1 t1, int i2, long l3) {
        t1.q(y1.c(i2, 1), Long.valueOf(l3));
    }

    @Override // com.google.protobuf.s1
    void w(com.google.protobuf.t1 t1, int i2, com.google.protobuf.t1 t13) {
        t1.q(y1.c(i2, 3), t13);
    }

    @Override // com.google.protobuf.s1
    void x(com.google.protobuf.t1 t1, int i2, com.google.protobuf.j j3) {
        t1.q(y1.c(i2, 2), j3);
    }

    @Override // com.google.protobuf.s1
    void y(com.google.protobuf.t1 t1, int i2, long l3) {
        t1.q(y1.c(i2, 0), Long.valueOf(l3));
    }

    @Override // com.google.protobuf.s1
    com.google.protobuf.t1 z(Object object) {
        com.google.protobuf.t1 t1Var;
        if (A(object) == t1.c()) {
            G(object, t1.n());
        }
        return t1Var;
    }
}
