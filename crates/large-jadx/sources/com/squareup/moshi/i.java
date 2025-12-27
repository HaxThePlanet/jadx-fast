package com.squareup.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import l.f;
import l.h;
import l.t;

/* compiled from: JsonReader.java */
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
        private a(String[] strArr, t tVar) {
            super();
            this.a = strArr;
            this.b = tVar;
        }

        public static i.a a(String... strArr) {
            int i = 0;
            try {
                l.i[] arr = new i[strArr.length];
                f fVar = new f();
                i = 0;
                while (i < strArr.length) {
                    l.g0(fVar, strArr[i]);
                    fVar.readByte();
                    arr[i] = fVar.Y0();
                    i = i + 1;
                }
            } catch (java.io.IOException ioException) {
                throw new AssertionError(ioException);
            }
            return new i.a((String[])strArr.clone(), t.q(arr));
        }
    }

    public enum b {

        BEGIN_ARRAY,
        BEGIN_OBJECT,
        BOOLEAN,
        END_ARRAY,
        END_DOCUMENT,
        END_OBJECT,
        NAME,
        NULL,
        NUMBER,
        STRING;
    }
    i() {
        super();
        int i = 32;
        this.b = new int[i];
        this.c = new String[i];
        this.v = new int[i];
    }

    public static i x(h hVar) {
        return new k(hVar);
    }

    final void H(int i) throws JsonDataException {
        length = iArr.length;
        if (this.a == iArr.length && this.a != 256) {
            this.b = Arrays.copyOf(this.b, iArr.length * 2);
            this.c = (String[])Arrays.copyOf(this.c, strArr.length * 2);
            this.v = Arrays.copyOf(this.v, iArr2.length * 2);
        }
        this.a++;
        this.b[this.a] = i;
    }

    public final void L(boolean z) {
        this.x = z;
    }

    public final void M(boolean z) {
        this.w = z;
    }

    final JsonEncodingException V(String str) throws JsonEncodingException {
        final StringBuilder stringBuilder = new StringBuilder();
        String str2 = " at path ";
        String path = getPath();
        str = str + str2 + path;
        throw new JsonEncodingException(str);
    }

    public final String getPath() {
        return j.a(this.a, this.b, this.c, this.v);
    }

    public final boolean i() {
        return this.x;
    }

    public final boolean k() {
        return this.w;
    }

    public abstract i.b E();

    public abstract void F();

    public abstract int J(i.a aVar);

    public abstract int K(i.a aVar);

    public abstract void T();

    public abstract void U();

    public abstract void a();

    public abstract void c();

    public abstract void e();

    public abstract void f();

    public abstract boolean j();

    public abstract boolean m();

    public abstract double n();

    public abstract int o();

    public abstract long q();

    public abstract <T> T r();

    public abstract String w();
}
