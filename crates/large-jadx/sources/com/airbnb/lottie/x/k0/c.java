package com.airbnb.lottie.x.k0;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import l.f;
import l.g;
import l.h;
import l.t;

/* compiled from: JsonReader.java */
/* loaded from: classes.dex */
public abstract class c implements Closeable {

    private static final String[] y;
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

        public static c.a a(String... strArr) {
            int i = 0;
            try {
                l.i[] arr = new i[strArr.length];
                f fVar = new f();
                i = 0;
                while (i < strArr.length) {
                    c.J(fVar, strArr[i]);
                    fVar.readByte();
                    arr[i] = fVar.Y0();
                    i = i + 1;
                }
            } catch (java.io.IOException ioException) {
                throw new AssertionError(ioException);
            }
            return new c.a((String[])strArr.clone(), t.q(arr));
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
    static {
        int i;
        c.y = new String[128];
        i = 0;
        while (i <= 31) {
            Object[] arr = new Object[1];
            arr[i] = Integer.valueOf(i);
            str = "\\u%04x";
            c.y[i] = String.format(str, arr);
            i = i + 1;
        }
        String[] strArr3 = c.y;
        strArr3[34] = "\\\"";
        strArr3[92] = "\\\\";
        strArr3[9] = "\\t";
        strArr3[8] = "\\b";
        strArr3[10] = "\\n";
        strArr3[13] = "\\r";
        strArr3[12] = "\\f";
    }

    c() {
        super();
        int i = 32;
        this.b = new int[i];
        this.c = new String[i];
        this.v = new int[i];
    }

    private static void J(g gVar, String str) {
        int i = 0;
        char c = 128;
        final int i2 = 34;
        gVar.c0(i2);
        final int length = str.length();
        i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            c = '\u0080';
            i = i + 1;
        }
        if (i < length) {
            gVar.U0(str, i, length);
        }
        gVar.c0(i2);
    }

    static /* synthetic */ void a(g gVar, String str) {
        c.J(gVar, str);
    }

    public static c r(h hVar) {
        return new e(hVar);
    }

    final b K(String str) throws b {
        final StringBuilder stringBuilder = new StringBuilder();
        String str2 = " at path ";
        String path = getPath();
        str = str + str2 + path;
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) new b(str);
    }

    public final String getPath() {
        return d.a(this.a, this.b, this.c, this.v);
    }

    final void x(int i) throws a {
        length = iArr.length;
        if (this.a == iArr.length && this.a != 256) {
            this.b = Arrays.copyOf(this.b, iArr.length * 2);
            this.c = (String[])Arrays.copyOf(this.c, strArr.length * 2);
            this.v = Arrays.copyOf(this.v, iArr2.length * 2);
        }
        this.a++;
        this.b[this.a] = i;
    }

    public abstract int E(c.a aVar);

    public abstract void F();

    public abstract void H();

    public abstract void c();

    public abstract void e();

    public abstract void f();

    public abstract void i();

    public abstract boolean j();

    public abstract boolean k();

    public abstract double m();

    public abstract int n();

    public abstract String o();

    public abstract String q();

    public abstract c.b w();
}
