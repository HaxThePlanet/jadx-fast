package com.squareup.moshi;

import java.io.Closeable;
import java.io.Flushable;
import java.util.Arrays;
import l.g;

/* compiled from: JsonWriter.java */
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
        int i2 = 32;
        this.b = new int[i2];
        this.c = new String[i2];
        this.v = new int[i2];
    }

    public static o o(g gVar) {
        return new l(gVar);
    }

    public final void E(boolean z) {
        this.x = z;
    }

    public final void F(boolean z) {
        this.y = z;
    }

    final boolean e() throws JsonDataException {
        if (this.a != iArr2.length) {
            return false;
        }
        int i2 = 256;
        if (this.a == 256) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Nesting too deep at ";
            String path = getPath();
            String str2 = ": circular reference?";
            r1 = str + path + str2;
            throw new JsonDataException(r1);
        } else {
            this.b = Arrays.copyOf(this.b, iArr2.length * 2);
            this.c = (String[])Arrays.copyOf(this.c, strArr.length * 2);
            i = iArr.length * 2;
            this.v = Arrays.copyOf(this.v, i);
            z = this instanceof n;
            if (this instanceof n) {
                Object obj = this;
                i2 = objArr.length * 2;
                obj.B = Arrays.copyOf(obj.B, i2);
            }
            return true;
        }
    }

    public final String getPath() {
        return j.a(this.a, this.b, this.c, this.v);
    }

    public final boolean j() {
        return this.y;
    }

    public final boolean k() {
        return this.x;
    }

    final int q() {
        if (this.a == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            return this.b[i - 1];
        }
    }

    public final void r() {
        int i2 = q();
        int i = 5;
        this.z = true;
    }

    final void w(int i) {
        this.a++;
        this.b[this.a] = i;
    }

    final void x(int i) {
        this.b[this.a - 1] = i;
    }

    public abstract o H(double d);

    public abstract o J(long j);

    public abstract o K(Number number);

    public abstract o L(String str);

    public abstract o M(boolean z);

    public abstract o a();

    public abstract o c();

    public abstract o f();

    public abstract o i();

    public abstract o m(String str);

    public abstract o n();
}
