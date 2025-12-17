package com.google.protobuf;

/* loaded from: classes2.dex */
public class m0<K, V>  {

    private final com.google.protobuf.m0.a<K, V> a;
    private final K b;
    private final V c;

    static class a {

        public final com.google.protobuf.y1.b a;
        public final K b;
        public final com.google.protobuf.y1.b c;
        public final V d;
        public a(com.google.protobuf.y1.b y1$b, K k2, com.google.protobuf.y1.b y1$b3, V v4) {
            super();
            this.a = b;
            this.b = k2;
            this.c = b3;
            this.d = v4;
        }
    }
    private m0(com.google.protobuf.y1.b y1$b, K k2, com.google.protobuf.y1.b y1$b3, V v4) {
        super();
        m0.a aVar = new m0.a(b, k2, b3, v4);
        this.a = aVar;
        this.b = k2;
        this.c = v4;
    }

    static <K, V> int b(com.google.protobuf.m0.a<K, V> m0$a, K k2, V v3) {
        return obj3 += obj2;
    }

    public static <K, V> com.google.protobuf.m0<K, V> d(com.google.protobuf.y1.b y1$b, K k2, com.google.protobuf.y1.b y1$b3, V v4) {
        m0 m0Var = new m0(b, k2, b3, v4);
        return m0Var;
    }

    static <K, V> void e(com.google.protobuf.CodedOutputStream codedOutputStream, com.google.protobuf.m0.a<K, V> m0$a2, K k3, V v4) {
        v.z(codedOutputStream, a2.a, 1, k3);
        v.z(codedOutputStream, a2.c, 2, v4);
    }

    public int a(int i, K k2, V v3) {
        return obj2 += obj3;
    }

    com.google.protobuf.m0.a<K, V> c() {
        return this.a;
    }
}
