package com.squareup.moshi;

import java.io.Closeable;
import java.util.Arrays;
import l.f;
import l.h;
import l.t;

/* loaded from: classes2.dex */
public abstract class i implements Closeable {

    int a;
    int[] b;
    String[] c;
    int[] v;
    boolean w;
    boolean x;

    public static final class a {

        final String[] a;
        final t b;
        private a(String[] stringArr, t t2) {
            super();
            this.a = stringArr;
            this.b = t2;
        }

        public static com.squareup.moshi.i.a a(String... stringArr) {
            int i;
            l.i iVar;
            try {
                l.i[] arr = new i[stringArr.length];
                f fVar = new f();
                i = 0;
                for (Object obj : stringArr) {
                    l.g0(fVar, obj);
                    fVar.readByte();
                    arr[i] = fVar.Y0();
                }
                l.g0(fVar, stringArr[i]);
                fVar.readByte();
                arr[i] = fVar.Y0();
                i++;
                i.a aVar = new i.a((String[])stringArr.clone(), t.q(arr));
                return aVar;
                AssertionError assertionError = new AssertionError(stringArr);
                throw assertionError;
            }
        }
    }

    public static enum b {

        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT;
    }
    i() {
        super();
        int i = 32;
        this.b = new int[i];
        this.c = new String[i];
        this.v = new int[i];
    }

    public static com.squareup.moshi.i x(h h) {
        k kVar = new k(h);
        return kVar;
    }

    @Override // java.io.Closeable
    public abstract com.squareup.moshi.i.b E();

    @Override // java.io.Closeable
    public abstract void F();

    @Override // java.io.Closeable
    final void H(int i) {
        int copyOf;
        int[] iArr;
        int length;
        copyOf = this.a;
        iArr = this.b;
        if (copyOf == iArr.length) {
            if (copyOf == 256) {
            } else {
                this.b = Arrays.copyOf(iArr, length2 *= 2);
                String[] strArr = this.c;
                this.c = (String[])Arrays.copyOf(strArr, length3 *= 2);
                int[] iArr2 = this.v;
                this.v = Arrays.copyOf(iArr2, length4 *= 2);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Nesting too deep at ");
            stringBuilder.append(getPath());
            JsonDataException obj4 = new JsonDataException(stringBuilder.toString());
            throw obj4;
        }
        int i4 = this.a;
        this.a = i4 + 1;
        this.b[i4] = i;
    }

    @Override // java.io.Closeable
    public abstract int J(com.squareup.moshi.i.a i$a);

    @Override // java.io.Closeable
    public abstract int K(com.squareup.moshi.i.a i$a);

    @Override // java.io.Closeable
    public final void L(boolean z) {
        this.x = z;
    }

    @Override // java.io.Closeable
    public final void M(boolean z) {
        this.w = z;
    }

    @Override // java.io.Closeable
    public abstract void T();

    @Override // java.io.Closeable
    public abstract void U();

    @Override // java.io.Closeable
    final com.squareup.moshi.JsonEncodingException V(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        JsonEncodingException jsonEncodingException = new JsonEncodingException(stringBuilder.toString());
        throw jsonEncodingException;
    }

    @Override // java.io.Closeable
    public abstract void a();

    @Override // java.io.Closeable
    public abstract void c();

    @Override // java.io.Closeable
    public abstract void e();

    @Override // java.io.Closeable
    public abstract void f();

    @Override // java.io.Closeable
    public final String getPath() {
        return j.a(this.a, this.b, this.c, this.v);
    }

    @Override // java.io.Closeable
    public final boolean i() {
        return this.x;
    }

    @Override // java.io.Closeable
    public abstract boolean j();

    @Override // java.io.Closeable
    public final boolean k() {
        return this.w;
    }

    @Override // java.io.Closeable
    public abstract boolean m();

    @Override // java.io.Closeable
    public abstract double n();

    @Override // java.io.Closeable
    public abstract int o();

    @Override // java.io.Closeable
    public abstract long q();

    public abstract <T> T r();

    @Override // java.io.Closeable
    public abstract String w();
}
