package com.squareup.moshi;

import java.io.IOException;
import java.util.Objects;
import l.b0;
import l.g;

/* compiled from: JsonUtf8Writer.java */
/* loaded from: classes2.dex */
final class l extends o {

    private static final String[] E;
    private final g B;
    private String C = ":";
    private String D;
    static {
        int i;
        l.E = new String[128];
        i = 0;
        while (i <= 31) {
            Object[] arr = new Object[1];
            arr[i] = Integer.valueOf(i);
            str = "\\u%04x";
            l.E[i] = String.format(str, arr);
            i = i + 1;
        }
        String[] strArr3 = l.E;
        strArr3[34] = "\\\"";
        strArr3[92] = "\\\\";
        strArr3[9] = "\\t";
        strArr3[8] = "\\b";
        strArr3[10] = "\\n";
        strArr3[13] = "\\r";
        strArr3[12] = "\\f";
    }

    l(g gVar) {
        super();
        Objects.requireNonNull(gVar, "sink == null");
        this.B = gVar;
        w(6);
    }

    private void T() {
        int i2 = q();
        if (i2 == 5) {
            int i = 44;
            this.B.c0(i);
            Y();
            x(4);
            return;
        }
        throw new IllegalStateException("Nesting problem.");
    }

    private void U() {
        int i;
        int i2 = 1;
        int i3 = 5;
        i = q();
        i2 = 1;
        i3 = 7;
        i3 = 2;
        if (!(i == 1 || i != i3)) {
            if (i != 4 && i != 9) {
                if (i != 6 && i == 7) {
                    if (!this.x) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                }
            }
            i3 = 5;
            this.B.E0(this.C);
        } else {
            Y();
        }
        x(i3);
    }

    private o V(int i, int i2, char c) {
        final int i3 = q();
        if (i3 != i2) {
            if (i3 != i) {
                throw new IllegalStateException("Nesting problem.");
            }
        }
        if (this.D != null) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "Dangling name: ";
            i2 = str3 + this.D;
            throw new IllegalStateException(i2);
        } else {
            if (this.a == ~i4) {
                this.A = ~i4;
                return this;
            }
            this.a--;
            this.c[i10] = 0;
            int i11 = i10 - 1;
            this.v[i11] = iArr[i11] + 1;
            if (i3 == i2) {
                Y();
            }
            this.B.c0(c);
            return this;
        }
    }

    private void Y() {
        int i = 1;
        if (this.w == null) {
            return;
        }
        this.B.c0(10);
        i = 1;
        while (i < this.a) {
            this.B.E0(this.w);
            i = i + 1;
        }
    }

    private o e0(int i, int i2, char c) {
        if (this.a == this.A) {
            this.A = ~i7;
            return this;
        }
        U();
        e();
        w(i);
        this.v[this.a - 1] = 0;
        this.B.c0(c);
        return this;
    }

    static void g0(g gVar, String str) {
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

    private void j0() {
        if (this.D != null) {
            T();
            l.g0(this.B, this.D);
            String str = null;
            this.D = str;
        }
    }

    @Override // com.squareup.moshi.o
    public o H(double d) {
        if (!this.x) {
            if (Double.isNaN(d)) {
                final StringBuilder stringBuilder = new StringBuilder();
                final String str = "Numeric values must be finite, but was ";
                d = str + d;
                throw new IllegalArgumentException(d);
            }
        }
        if (this.z) {
            this.z = false;
            m(Double.toString(d));
            return this;
        }
        j0();
        U();
        this.B.E0(Double.toString(d));
        int i5 = this.a - 1;
        this.v[i5] = iArr[i5] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o J(long j) {
        if (this.z) {
            this.z = false;
            m(Long.toString(j));
            return this;
        }
        j0();
        U();
        this.B.E0(Long.toString(j));
        int i5 = this.a - 1;
        this.v[i5] = iArr[i5] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o K(Number number) {
        if (number == null) {
            n();
            return this;
        }
        String object = number.toString();
        if (!this.x) {
            if (object.equals("-Infinity")) {
                StringBuilder stringBuilder = new StringBuilder();
                final String str4 = "Numeric values must be finite, but was ";
                number = str4 + number;
                throw new IllegalArgumentException(number);
            }
        }
        if (this.z) {
            this.z = false;
            m(object);
            return this;
        }
        j0();
        U();
        this.B.E0(object);
        int i2 = this.a - 1;
        this.v[i2] = iArr[i2] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o L(String str) {
        if (str == null) {
            n();
            return this;
        }
        if (this.z) {
            this.z = false;
            m(str);
            return this;
        }
        j0();
        U();
        l.g0(this.B, str);
        int i3 = this.a - 1;
        this.v[i3] = iArr[i3] + 1;
        return this;
    }

    @Override // com.squareup.moshi.o
    public o M(boolean z) {
        String str;
        if (this.z) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Boolean cannot be used as a map key in JSON at path ";
            String path = getPath();
            r0 = str2 + path;
            throw new IllegalStateException(r0);
        } else {
            j0();
            U();
            z = z ? "true" : "false";
            this.B.E0((z ? "true" : "false"));
            int i2 = this.a - 1;
            z[i2] = (z ? "true" : "false")[i2] + 1;
            return this;
        }
    }

    @Override // com.squareup.moshi.o
    public o a() {
        if (this.z) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Array cannot be used as a map key in JSON at path ";
            String path = getPath();
            r1 = str + path;
            throw new IllegalStateException(r1);
        } else {
            j0();
            e0(1, 2, '[');
            return this;
        }
    }

    @Override // com.squareup.moshi.o
    public o c() {
        if (this.z) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Object cannot be used as a map key in JSON at path ";
            String path = getPath();
            r1 = str + path;
            throw new IllegalStateException(r1);
        } else {
            j0();
            e0(3, 5, '{');
            return this;
        }
    }

    @Override // com.squareup.moshi.o
    public void close() throws IOException {
        this.B.close();
        int i2 = 1;
        if (this.a > i2) {
            throw new IOException("Incomplete document");
        } else {
            this.a = 0;
            return;
        }
    }

    @Override // com.squareup.moshi.o
    public o f() {
        V(1, 2, ']');
        return this;
    }

    @Override // com.squareup.moshi.o
    public void flush() {
        if (this.a == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            this.B.flush();
            return;
        }
    }

    @Override // com.squareup.moshi.o
    public o i() {
        this.z = false;
        V(3, 5, '}');
        return this;
    }

    @Override // com.squareup.moshi.o
    public o m(String str) {
        int i = 3;
        Objects.requireNonNull(str, "name == null");
        if (this.a == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        } else {
            int i3 = q();
            i = 3;
            i = 5;
            if (!(i3 != 3 && i3 == 5)) {
                if (this.D == null) {
                    if (!this.z) {
                        this.D = str;
                        this.c[this.a - 1] = str;
                        return this;
                    }
                }
            }
            throw new IllegalStateException("Nesting problem.");
        }
    }

    @Override // com.squareup.moshi.o
    public o n() {
        if (this.z) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "null cannot be used as a map key in JSON at path ";
            String path = getPath();
            r1 = str3 + path;
            throw new IllegalStateException(r1);
        } else {
            if (this.D != null && this.y) {
                j0();
            }
            U();
            this.B.E0("null");
            int i3 = this.a - 1;
            this.v[i3] = iArr[i3] + 1;
            return this;
        }
    }
}
