package com.google.protobuf;

/* loaded from: classes2.dex */
final class i1 implements com.google.protobuf.r0 {

    private final com.google.protobuf.t0 a;
    private final String b;
    private final Object[] c;
    private final int d;
    i1(com.google.protobuf.t0 t0, String string2, Object[] object3Arr3) {
        String str;
        int illegalStateException;
        int i;
        int obj5;
        String obj6;
        char obj7;
        super();
        this.a = t0;
        this.b = string2;
        this.c = object3Arr3;
        obj5 = 1;
        obj7 = string2.charAt(0);
        int i2 = 55296;
        if (obj7 < i2) {
            this.d = obj7;
        } else {
            obj7 &= 8191;
            illegalStateException = 13;
            obj5 = obj6.charAt(obj5);
            while (obj5 >= i2) {
                obj7 |= obj5;
                illegalStateException += 13;
                obj5 = i;
                obj5 = obj6.charAt(obj5);
            }
            this.d = obj5 |= obj7;
        }
    }

    @Override // com.google.protobuf.r0
    public boolean a() {
        int i;
        final int i4 = 2;
        i = i2 &= i4 == i4 ? 1 : 0;
        return i;
    }

    @Override // com.google.protobuf.r0
    public com.google.protobuf.t0 b() {
        return this.a;
    }

    @Override // com.google.protobuf.r0
    public com.google.protobuf.f1 c() {
        com.google.protobuf.f1 pROTO2;
        final int i3 = 1;
        pROTO2 = i &= i3 == i3 ? f1.PROTO2 : f1.PROTO3;
        return pROTO2;
    }

    @Override // com.google.protobuf.r0
    Object[] d() {
        return this.c;
    }

    @Override // com.google.protobuf.r0
    String e() {
        return this.b;
    }
}
