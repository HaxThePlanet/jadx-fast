package com.squareup.moshi;

import java.io.Closeable;
import java.io.Flushable;
import java.util.Arrays;
import l.g;

/* loaded from: classes2.dex */
public abstract class o implements Closeable, Flushable {

    int A = -1;
    int a = 0;
    int[] b;
    String[] c;
    int[] v;
    String w;
    boolean x;
    boolean y;
    boolean z;
    o() {
        super();
        int i = 0;
        int i2 = 32;
        this.b = new int[i2];
        this.c = new String[i2];
        this.v = new int[i2];
        int i3 = -1;
    }

    public static com.squareup.moshi.o o(g g) {
        l lVar = new l(g);
        return lVar;
    }

    @Override // java.io.Closeable
    public final void E(boolean z) {
        this.x = z;
    }

    @Override // java.io.Closeable
    public final void F(boolean z) {
        this.y = z;
    }

    @Override // java.io.Closeable
    public abstract com.squareup.moshi.o H(double d);

    @Override // java.io.Closeable
    public abstract com.squareup.moshi.o J(long l);

    @Override // java.io.Closeable
    public abstract com.squareup.moshi.o K(Number number);

    @Override // java.io.Closeable
    public abstract com.squareup.moshi.o L(String string);

    @Override // java.io.Closeable
    public abstract com.squareup.moshi.o M(boolean z);

    @Override // java.io.Closeable
    public abstract com.squareup.moshi.o a();

    @Override // java.io.Closeable
    public abstract com.squareup.moshi.o c();

    @Override // java.io.Closeable
    final boolean e() {
        boolean z;
        int copyOf;
        int i;
        int i2 = this.a;
        int[] iArr2 = this.b;
        if (i2 != iArr2.length) {
            return 0;
        }
        if (i2 == 256) {
        } else {
            this.b = Arrays.copyOf(iArr2, length *= 2);
            String[] strArr = this.c;
            this.c = (String[])Arrays.copyOf(strArr, length2 *= 2);
            int[] iArr = this.v;
            this.v = Arrays.copyOf(iArr, length3 *= 2);
            if (this instanceof n) {
                z = this;
                Object[] objArr = z.B;
                z.B = Arrays.copyOf(objArr, length5 *= 2);
            }
            return 1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Nesting too deep at ");
        stringBuilder.append(getPath());
        stringBuilder.append(": circular reference?");
        JsonDataException jsonDataException = new JsonDataException(stringBuilder.toString());
        throw jsonDataException;
    }

    @Override // java.io.Closeable
    public abstract com.squareup.moshi.o f();

    @Override // java.io.Closeable
    public final String getPath() {
        return j.a(this.a, this.b, this.c, this.v);
    }

    @Override // java.io.Closeable
    public abstract com.squareup.moshi.o i();

    @Override // java.io.Closeable
    public final boolean j() {
        return this.y;
    }

    @Override // java.io.Closeable
    public final boolean k() {
        return this.x;
    }

    @Override // java.io.Closeable
    public abstract com.squareup.moshi.o m(String string);

    @Override // java.io.Closeable
    public abstract com.squareup.moshi.o n();

    @Override // java.io.Closeable
    final int q() {
        int i = this.a;
        if (i == 0) {
        } else {
            return this.b[i--];
        }
        IllegalStateException illegalStateException = new IllegalStateException("JsonWriter is closed.");
        throw illegalStateException;
    }

    @Override // java.io.Closeable
    public final void r() {
        int i;
        int i2 = q();
        if (i2 != 5) {
            if (i2 != 3) {
            } else {
            }
            IllegalStateException illegalStateException = new IllegalStateException("Nesting problem.");
            throw illegalStateException;
        }
        this.z = true;
    }

    @Override // java.io.Closeable
    final void w(int i) {
        final int i2 = this.a;
        this.a = i2 + 1;
        this.b[i2] = i;
    }

    @Override // java.io.Closeable
    final void x(int i) {
        this.b[i2--] = i;
    }
}
