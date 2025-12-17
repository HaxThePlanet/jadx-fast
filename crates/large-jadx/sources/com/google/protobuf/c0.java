package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.List;
import java.util.Objects;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class c0 {

    static final Charset a;
    public static final byte[] b;
    public static final ByteBuffer c;

    public interface c {
        public abstract int getNumber();
    }

    public interface d {
        public abstract T findValueByNumber(int i);
    }

    public interface e {
        public abstract boolean isInRange(int i);
    }

    public static class h extends AbstractList<T> {

        private final List<F> a;
        private final com.google.protobuf.c0.h.a<F, T> b;
        public h(List<F> list, com.google.protobuf.c0.h.a<F, T> c0$h$a2) {
            super();
            this.a = list;
            this.b = a2;
        }

        public T get(int i) {
            return this.b.convert(this.a.get(i));
        }

        @Override // java.util.AbstractList
        public int size() {
            return this.a.size();
        }
    }

    public interface j extends List<E>, RandomAccess {
        @Override // java.util.List
        public abstract void F();

        public abstract com.google.protobuf.c0.j<E> c(int i);

        @Override // java.util.List
        public abstract boolean c2();
    }

    public interface a extends com.google.protobuf.c0.j<Boolean> {
        @Override // com.google.protobuf.c0$j
        public abstract com.google.protobuf.c0.a c(int i);
    }

    public interface b extends com.google.protobuf.c0.j<Double> {
        @Override // com.google.protobuf.c0$j
        public abstract com.google.protobuf.c0.b c(int i);
    }

    public interface f extends com.google.protobuf.c0.j<Float> {
        @Override // com.google.protobuf.c0$j
        public abstract com.google.protobuf.c0.f c(int i);
    }

    public interface g extends com.google.protobuf.c0.j<Integer> {
        @Override // com.google.protobuf.c0$j
        public abstract int M(int i, int i2);

        @Override // com.google.protobuf.c0$j
        public abstract void V(int i);

        @Override // com.google.protobuf.c0$j
        public abstract com.google.protobuf.c0.g c(int i);

        @Override // com.google.protobuf.c0$j
        public abstract int getInt(int i);
    }

    public interface i extends com.google.protobuf.c0.j<Long> {
        @Override // com.google.protobuf.c0$j
        public abstract com.google.protobuf.c0.i c(int i);
    }
    static {
        c0.a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        c0.b = bArr;
        c0.c = ByteBuffer.wrap(bArr);
        k.k(bArr);
    }

    static <T> T a(T t) {
        Objects.requireNonNull(t);
        return t;
    }

    static <T> T b(T t, String string2) {
        Objects.requireNonNull(t, string2);
        return t;
    }

    public static int c(boolean z) {
        int obj0;
        obj0 = z ? 1231 : 1237;
        return obj0;
    }

    public static int d(byte[] bArr) {
        return c0.e(bArr, 0, bArr.length);
    }

    static int e(byte[] bArr, int i2, int i3) {
        int obj0;
        if (c0.i(i3, bArr, i2, i3) == 0) {
            obj0 = 1;
        }
        return obj0;
    }

    public static int f(long l) {
        return (int)obj2;
    }

    public static boolean g(byte[] bArr) {
        return x1.s(bArr);
    }

    static Object h(Object object, Object object2) {
        return (t0)object.toBuilder().mergeFrom((t0)object2).buildPartial();
    }

    static int i(int i, byte[] b2Arr2, int i3, int i4) {
        int i2;
        byte b;
        int obj2;
        i2 = i3;
        while (i2 < i3 + i4) {
            obj2 += b;
            i2++;
        }
        return obj2;
    }

    public static String j(byte[] bArr) {
        String string = new String(bArr, c0.a);
        return string;
    }
}
