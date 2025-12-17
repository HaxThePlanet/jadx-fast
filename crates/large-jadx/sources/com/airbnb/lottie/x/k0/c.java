package com.airbnb.lottie.x.k0;

import java.io.Closeable;
import java.util.Arrays;
import l.f;
import l.g;
import l.h;
import l.t;

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
        private a(String[] stringArr, t t2) {
            super();
            this.a = stringArr;
            this.b = t2;
        }

        public static com.airbnb.lottie.x.k0.c.a a(String... stringArr) {
            int i;
            l.i iVar;
            try {
                l.i[] arr = new i[stringArr.length];
                f fVar = new f();
                i = 0;
                for (Object obj : stringArr) {
                    c.a(fVar, obj);
                    fVar.readByte();
                    arr[i] = fVar.Y0();
                }
                c.a(fVar, stringArr[i]);
                fVar.readByte();
                arr[i] = fVar.Y0();
                i++;
                c.a aVar = new c.a((String[])stringArr.clone(), t.q(arr));
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
    static {
        int i;
        String[] strArr;
        String format;
        String str;
        c.y = new String[128];
        int i3 = 0;
        i = i3;
        while (i <= 31) {
            Object[] arr = new Object[1];
            arr[i3] = Integer.valueOf(i);
            c.y[i] = String.format("\\u%04x", arr);
            i++;
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

    private static void J(g g, String string2) {
        int i2;
        int i;
        String charAt;
        int i3;
        final int i4 = 34;
        g.c0(i4);
        final int length = string2.length();
        i = i2;
        while (i2 < length) {
            charAt = string2.charAt(i2);
            if (charAt < 128) {
            } else {
            }
            if (charAt == 8232) {
            } else {
            }
            if (charAt == 8233) {
            }
            i2++;
            charAt = "\\u2029";
            if (i < i2) {
            }
            g.E0(charAt);
            i = i2 + 1;
            g.U0(string2, i, i2);
            charAt = "\\u2028";
            if (c.y[charAt] == null) {
            } else {
            }
        }
        if (i < length) {
            g.U0(string2, i, length);
        }
        g.c0(i4);
    }

    static void a(g g, String string2) {
        c.J(g, string2);
    }

    public static com.airbnb.lottie.x.k0.c r(h h) {
        e eVar = new e(h);
        return eVar;
    }

    @Override // java.io.Closeable
    public abstract int E(com.airbnb.lottie.x.k0.c.a c$a);

    @Override // java.io.Closeable
    public abstract void F();

    @Override // java.io.Closeable
    public abstract void H();

    @Override // java.io.Closeable
    final com.airbnb.lottie.x.k0.b K(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        b bVar = new b(stringBuilder.toString());
        throw bVar;
    }

    @Override // java.io.Closeable
    public abstract void c();

    @Override // java.io.Closeable
    public abstract void e();

    @Override // java.io.Closeable
    public abstract void f();

    @Override // java.io.Closeable
    public final String getPath() {
        return d.a(this.a, this.b, this.c, this.v);
    }

    @Override // java.io.Closeable
    public abstract void i();

    @Override // java.io.Closeable
    public abstract boolean j();

    @Override // java.io.Closeable
    public abstract boolean k();

    @Override // java.io.Closeable
    public abstract double m();

    @Override // java.io.Closeable
    public abstract int n();

    @Override // java.io.Closeable
    public abstract String o();

    @Override // java.io.Closeable
    public abstract String q();

    @Override // java.io.Closeable
    public abstract com.airbnb.lottie.x.k0.c.b w();

    @Override // java.io.Closeable
    final void x(int i) {
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
            a obj4 = new a(stringBuilder.toString());
            throw obj4;
        }
        int i4 = this.a;
        this.a = i4 + 1;
        this.b[i4] = i;
    }
}
