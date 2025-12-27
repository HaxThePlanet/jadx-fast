package com.airbnb.lottie.x.k0;

import java.io.EOFException;
import java.util.Objects;
import l.d0;
import l.f;
import l.h;
import l.i;

/* compiled from: JsonUtf8Reader.java */
/* loaded from: classes.dex */
final class e extends c {

    private static final i F;
    private static final i G;
    private static final i H;
    private static final i I;
    private static final i J;
    private final f A;
    private int B = 0;
    private long C;
    private int D;
    private String E;
    private final h z;
    static {
        e.F = i.i("'\\");
        e.G = i.i("\"\\");
        e.H = i.i("{}[]:, \n\t\r\u000c/\\;#=");
        e.I = i.i("\n\r");
        e.J = i.i("*/");
    }

    e(h hVar) {
        super();
        Objects.requireNonNull(hVar, "source == null");
        this.z = hVar;
        this.A = hVar.A();
        x(6);
    }

    private void L() {
        if (!this.w) {
            K("Use JsonReader.setLenient(true) to accept malformed JSON");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }
    }

    private int M() {
        final Object obj = this;
        int i31 = iArr[i21 - 1];
        long l = 0L;
        final int i33 = 8;
        final int i35 = 34;
        final int i36 = 93;
        final int i37 = 3;
        final int i38 = 7;
        final int i39 = 59;
        final int i40 = 44;
        int i6 = 4;
        int i7 = 2;
        final int i41 = 0;
        final int i34 = 1;
        if (i31 == i34) {
            obj.b[i21 - i34] = i7;
            int i2 = obj.V(true);
            if (i2 != i35 && i2 != 39) {
                if (i2 != i40 && i2 != i39) {
                    int i4 = 91;
                    if (i2 != 91 && i2 != i36) {
                        if (i2 != 123 && i18 != 0) {
                            return i18;
                        }
                        obj.A.readByte();
                        obj.B = i34;
                        return i34;
                    }
                    obj.A.readByte();
                    obj.B = i37;
                    return i37;
                }
                L();
                obj.B = i38;
                return i38;
            }
            obj.A.readByte();
            int i16 = 9;
            obj.B = i16;
            return i16;
        } else {
            if (i31 == i7) {
                int i = obj.V(true);
                obj.A.readByte();
                if (i != i40 && i != i39) {
                    if (i != i36) {
                        obj.K("Unterminated array");
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i41;
                    } else {
                        obj.B = i6;
                        return i6;
                    }
                }
            }
        }
        i3 = i21 - i34;
        int i5 = 4;
        obj.b[i3] = i5;
        int i10 = 125;
        if (i31 == i7 && i3 != i40 && i3 != i39) {
            if (i3 != i10) {
                obj.K("Unterminated object");
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i41;
            } else {
                int i11 = 2;
                obj.B = i11;
                return i11;
            }
        }
        int i27 = obj.V(true);
        if (i27 != i35 && i27 != 39) {
            String str7 = "Expected name";
            if (i27 != i10) {
                L();
                if (!obj.U((char)i27)) {
                    obj.K(str7);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i41;
                } else {
                    int i14 = 14;
                    obj.B = i14;
                    return i14;
                }
            }
            if (i31 == i7) {
                obj.K(str7);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i41;
            } else {
                obj.A.readByte();
                int i15 = 2;
                obj.B = i15;
                return i15;
            }
        }
        obj.A.readByte();
        int i12 = 13;
        obj.B = i12;
        return i12;
    }

    private int T(String str, c.a aVar) {
        int i;
        i = 0;
        while (i < aVar.a.length) {
            if (str.equals(aVar.a[i])) {
                this.B = i;
                this.c[this.a - 1] = str;
                return i;
            }
        }
        return -1;
    }

    private boolean U(int i) {
        int i2 = 35;
        i2 = 9;
        if (i != 9 && i != 10 && i != 12 && i != 13 && i != 32 && i != 35 && i != 44 && i != 47 && i != 61 && i != 123 && i != 125 && i != 58 && i != 59) {
            switch (i) {
                case 91:
                    return false;
                case 92:
                    L();
                    return false;
                default:
                    return true;
            }
        }
    }

    private int V(boolean z) throws EOFException {
        int i;
        byte b = 47;
        byte b2;
        long l = 42;
        while (/* condition */) {
            b2 = i + 1;
            while (this.z.request((long)b2)) {
                l = (long)i;
                byte b3 = this.A.n(l);
                b = (byte) 10;
                if (b3 != (byte) 10) {
                    b = (byte) 32;
                }
            }
            l = (long)i;
            b3 = this.A.n(l);
            b = (byte) 10;
            if (b3 != (byte) 10) {
                b = (byte) 32;
            }
        }
        if (z) {
            throw new EOFException("End of input");
        } else {
            return -1;
        }
    }

    private String Y(i iVar) {
        int i;
        i = 0;
        long l = this.z.n0(iVar);
        while (l != -1) {
            byte b = (byte) 92;
            if (this.A.n(l) != (byte) 92) {
            }
        }
        K("Unterminated string");
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) i;
    }

    private String e0() {
        String str;
        final i iVar = e.H;
        long l = this.z.n0(iVar);
        if (l != -1) {
            str = this.A.L(l);
        } else {
            str = this.A.r1();
        }
        return str;
    }

    private int g0() {
        int i = 6;
        String str;
        String str2;
        int i2 = 1;
        byte b4;
        byte b5 = this.A.n(0L);
        int i4 = 0;
        byte b = (byte) 116;
        if (b5 == (byte) 116 || b5 == (byte) 84) {
            i = 5;
            str = "true";
            str2 = "TRUE";
        }
        final int length = str.length();
        i2 = 1;
        while (i2 < length) {
            i2 = i2 + 1;
            b4 = this.A.n((long)i2);
            if (b4 != str.charAt(i2) && b4 != str2.charAt(i2)) {
            }
        }
        int i5 = length + 1;
        l = (long)i5;
        if (this.z.request(l)) {
            l = (long)length;
            if (U(this.A.n(l))) {
                return i4;
            }
        }
        this.A.skip((long)length);
        this.B = i;
        return i;
    }

    private int j0() {
        long l = 0;
        int cmp = 1;
        boolean z;
        int i;
        byte b;
        byte b2 = 48;
        final Object obj = this;
        l = 0L;
        cmp = 1;
        cmp = 0;
        i = l;
        cmp = cmp + 1;
        cmp = 2;
        while (!obj.z.request((long)cmp)) {
            b = obj.A.n((long)cmp);
            b2 = (byte) 43;
            cmp = 5;
            if (b != (byte) 43) {
                b2 = (byte) 69;
            }
        }
        if (cmp == cmp && cmp != 0) {
            if (i != -9223372036854775808L || cmp != 0) {
                if (i != l || cmp == 0) {
                    if (cmp == 0) {
                        i = -i;
                    }
                }
            }
            obj.C = i;
            obj.A.skip((long)cmp);
            int i5 = 16;
            obj.B = i5;
            return i5;
        }
        obj.D = cmp;
        int i4 = 17;
        obj.B = i4;
        return i4;
    }

    private char l0() throws EOFException, StringBuilder {
        int i = 0;
        char c;
        int i3;
        int i2;
        byte b2 = 97;
        int i9 = 0;
        if (!this.z.request(1L)) {
            K("Unterminated escape sequence");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i9;
        } else {
            byte _byte = this.A.readByte();
            byte b3 = (byte) 10;
            if (_byte != b3 && _byte != (byte) 34 && _byte != (byte) 39 && _byte != (byte) 47 && _byte != (byte) 92 && _byte != 98) {
                byte b4 = (byte) 102;
                if (_byte != b4 && _byte != 110) {
                    if (_byte != 114 && _byte != 116) {
                        if (_byte != 117 && this.w) {
                            return (char)_byte;
                        }
                        long l = 4L;
                        if (!this.z.request(l)) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            String str4 = "Unterminated escape sequence at path ";
                            String path = getPath();
                            r1 = str4 + path;
                            throw new EOFException(r1);
                        } else {
                            i = 0;
                            while (this.A < 4) {
                                byte b5 = this.A.n((long)i);
                                b2 = (byte) 48;
                            }
                            this.A.skip(l);
                            return c;
                        }
                    }
                    return 13;
                }
                return 12;
            }
            return (char)_byte;
        }
    }

    private void m0(i iVar) {
        long l = this.z.n0(iVar);
        while (l != -1) {
            final long l4 = 1L;
        }
        K("Unterminated string");
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    private boolean t0() {
        boolean z = true;
        long size;
        iVar = e.J;
        long l2 = this.z.a0(iVar);
        int r0 = l2 != -1 ? 1 : 0;
        if (this.z) {
            l = (long)e.J.A();
            size = l2 + l;
        } else {
            size = this.A.size();
        }
        this.A.skip(size);
        return z;
    }

    private void v0() {
        long size;
        final i iVar = e.I;
        long l2 = this.z.n0(iVar);
        if (l2 != -1) {
            long l = 1L;
            size = l2 + l;
        } else {
            size = this.A.size();
        }
        this.A.skip(size);
    }

    private void z0() {
        long size;
        final i iVar = e.H;
        size = this.z.n0(iVar);
        if (size == -1) {
            size = this.A.size();
        }
        this.A.skip(size);
    }

    @Override // com.airbnb.lottie.x.k0.c
    public int E(c.a aVar) {
        int i;
        if (this.B == 0) {
            i = M();
        }
        int i2 = 12;
        int i3 = -1;
        return i3;
    }

    @Override // com.airbnb.lottie.x.k0.c
    public void F() throws a {
        int i;
        if (this.x) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str4 = "Cannot skip unexpected ";
            com.airbnb.lottie.x.k0.c.b bVar2 = w();
            String str5 = " at ";
            String path2 = getPath();
            r1 = str4 + bVar2 + str5 + path2;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new a(r1);
        } else {
            if (this.B == 0) {
                i = M();
            }
            int i2 = 14;
            if (this.B == 14) {
                z0();
                this.B = 0;
                this.c[this.a - 1] = "null";
                return;
            } else {
                i2 = 13;
                if (this.B == 13) {
                    m0(e.G);
                } else {
                    i2 = 12;
                    if (this.B == 12) {
                        m0(e.F);
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Expected a name but was ";
            com.airbnb.lottie.x.k0.c.b bVar = w();
            String str3 = " at path ";
            String path = getPath();
            r1 = str2 + bVar + str3 + path;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new a(r1);
        }
    }

    @Override // com.airbnb.lottie.x.k0.c
    public void H() throws a {
        int i;
        int i2;
        int i3 = 3;
        String str;
        String str2;
        if (this.x) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "Cannot skip unexpected ";
            com.airbnb.lottie.x.k0.c.b bVar = w();
            String str4 = " at ";
            String path = getPath();
            r1 = str3 + bVar + str4 + path;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new a(r1);
        } else {
            i = 0;
            while (this.B == 0) {
                i2 = M();
                i3 = 3;
                int i4 = 1;
                i3 = 4;
                str = " at path ";
                str2 = "Expected a value but was ";
                i3 = 2;
                i3 = 14;
                z0();
                this.B = i;
                if (i == 0) {
                    int i7 = i5 - 1;
                    this.v[i7] = iArr[i7] + i4;
                    this.c[i5 - i4] = "null";
                    return;
                }
                i3 = 10;
                i3 = 9;
                m0(e.G);
                i3 = 13;
                i3 = 8;
                m0(e.F);
                i3 = 12;
                i3 = 18;
                this.A.skip((long)this.D);
                i = i - 1;
                this.a -= i4;
                i = i - 1;
                this.a -= i4;
                x(i3);
                i = i + 1;
                x(i4);
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            com.airbnb.lottie.x.k0.c.b bVar2 = w();
            String path2 = getPath();
            r1 = str2 + bVar2 + str + path2;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new a(r1);
        }
    }

    @Override // com.airbnb.lottie.x.k0.c
    public void c() throws a {
        int i;
        if (this.B == 0) {
            i = M();
        }
        if (this.B != 3) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Expected BEGIN_ARRAY but was ";
            com.airbnb.lottie.x.k0.c.b bVar = w();
            String str2 = " at path ";
            String path = getPath();
            r1 = str + bVar + str2 + path;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new a(r1);
        } else {
            int i2 = 1;
            x(i2);
            int i3 = 0;
            this.v[this.a - i2] = i3;
            this.B = i3;
            return;
        }
    }

    @Override // com.airbnb.lottie.x.k0.c
    public void close() {
        int i = 0;
        this.B = i;
        this.b[i] = 8;
        this.a = 1;
        this.A.a();
        this.z.close();
    }

    @Override // com.airbnb.lottie.x.k0.c
    public void e() throws a {
        int i;
        if (this.B == 0) {
            i = M();
        }
        if (this.B != 1) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Expected BEGIN_OBJECT but was ";
            com.airbnb.lottie.x.k0.c.b bVar = w();
            String str2 = " at path ";
            String path = getPath();
            r1 = str + bVar + str2 + path;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new a(r1);
        } else {
            x(3);
            this.B = 0;
            return;
        }
    }

    @Override // com.airbnb.lottie.x.k0.c
    public void f() throws a {
        int i;
        if (this.B == 0) {
            i = M();
        }
        if (this.B != 4) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Expected END_ARRAY but was ";
            com.airbnb.lottie.x.k0.c.b bVar = w();
            String str2 = " at path ";
            String path = getPath();
            r1 = str + bVar + str2 + path;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new a(r1);
        } else {
            this.a--;
            int i4 = i3 - 1;
            this.v[i4] = iArr[i4] + 1;
            this.B = 0;
            return;
        }
    }

    @Override // com.airbnb.lottie.x.k0.c
    public void i() throws a {
        int i;
        if (this.B == 0) {
            i = M();
        }
        if (this.B != 2) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Expected END_OBJECT but was ";
            com.airbnb.lottie.x.k0.c.b bVar = w();
            String str2 = " at path ";
            String path = getPath();
            r1 = str + bVar + str2 + path;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new a(r1);
        } else {
            this.a--;
            this.c[i3] = 0;
            int i4 = i3 - 1;
            this.v[i4] = iArr[i4] + 1;
            this.B = 0;
            return;
        }
    }

    @Override // com.airbnb.lottie.x.k0.c
    public boolean j() {
        int i;
        boolean z = true;
        int i2 = 2;
        if (this.B == 0) {
            i = M();
        }
        i2 = 2;
        int r0 = this.B != 2 && this.B != 4 && this.B != 18 ? 1 : 0;
        return (this.B != 2 && this.B != 4 && this.B != 18 ? 1 : 0);
    }

    @Override // com.airbnb.lottie.x.k0.c
    public boolean k() throws a {
        int i;
        if (this.B == 0) {
            i = M();
        }
        int i8 = 0;
        final int i11 = 1;
        if (this.B == 5) {
            this.B = i8;
            int i4 = this.a - i11;
            this.v[i4] = iArr[i4] + i11;
            return true;
        }
        if (this.v != 6) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Expected a boolean but was ";
            com.airbnb.lottie.x.k0.c.b bVar = w();
            String str2 = " at path ";
            String path = getPath();
            r1 = str + bVar + str2 + path;
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) new a(r1);
        } else {
            this.B = i8;
            int i7 = this.a - i11;
            this.v[i7] = iArr2[i7] + i11;
            return false;
        }
    }

    @Override // com.airbnb.lottie.x.k0.c
    public double m() throws b, a {
        int i;
        int i2 = 9;
        if (this.B == 0) {
            i = M();
        }
        int i7 = 0;
        if (this.B == 16) {
            this.B = i7;
            int i5 = this.a - 1;
            this.v[i5] = iArr[i5] + 1;
            return (double)this.C;
        }
        String str4 = "Expected a double but was ";
        int i13 = 11;
        final String str7 = " at path ";
        if (this.B == 17) {
            l = (long)this.D;
            this.E = this.A.L(l);
            this.B = i13;
            try {
                double parsed = Double.parseDouble(this.E);
            } catch (java.lang.NumberFormatException unused) {
                StringBuilder stringBuilder = new StringBuilder();
                String path2 = getPath();
                stringBuilder = str3 + this.E + str6 + this.E;
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) new a(stringBuilder);
            }
            if (!this.w && !Double.isNaN(this.A, i2)) {
                if (Double.isInfinite(parsed)) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    String str5 = "JSON forbids NaN and infinities: ";
                    String path = getPath();
                    r0 = str5 + parsed + str7 + path;
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) new b(r0);
                }
            }
            this.E = null;
            this.B = i7;
            int i12 = this.a - 1;
            this.v[i12] = iArr2[i12] + 1;
            return parsed;
        } else {
            i2 = 9;
            if (this.A == 9) {
                this.E = Y(e.G);
            } else {
                i2 = 8;
                if (this.B == 8) {
                    this.E = Y(e.F);
                } else {
                    i2 = 10;
                    if (this.B == 10) {
                        this.E = e0();
                    }
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        com.airbnb.lottie.x.k0.c.b bVar = w();
        String path3 = getPath();
        r1 = str4 + bVar + str7 + path3;
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) new a(r1);
    }

    @Override // com.airbnb.lottie.x.k0.c
    public int n() throws a {
        int i;
        String str2;
        if (this.B == 0) {
            i = M();
        }
        int i11 = 0;
        final String str6 = " at path ";
        String str8 = "Expected an int but was ";
        if (this.B == 16) {
            int i16 = (int)l;
            if (this.C != l) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String path2 = getPath();
                r1 = str8 + this.C + str6 + path2;
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) new a(r1);
            } else {
                this.B = i11;
                int i7 = this.a - 1;
                this.v[i7] = iArr[i7] + 1;
                return i16;
            }
        }
        int i17 = 11;
        if (this.C == 17) {
            l2 = (long)this.D;
            this.E = this.A.L(l2);
            this.B = i17;
            try {
                double parsed = Double.parseDouble(this.E);
            } catch (java.lang.NumberFormatException unused) {
                StringBuilder stringBuilder = new StringBuilder();
                String path = getPath();
                stringBuilder = str7 + this.E + str5 + this.E;
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) new a(stringBuilder);
            }
            if (parsed != this.C) {
                StringBuilder stringBuilder3 = new StringBuilder();
                String path3 = getPath();
                r1 = str8 + this.E + str6 + path3;
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) new a(r1);
            } else {
                this.E = null;
                this.B = i11;
                int i10 = this.a - 1;
                this.v[i10] = iArr2[i10] + 1;
                return (int)parsed;
            }
        } else {
            int i2 = 9;
            if (this.v != i2) {
                StringBuilder stringBuilder4 = new StringBuilder();
                com.airbnb.lottie.x.k0.c.b bVar = w();
                String path4 = getPath();
                r1 = str8 + bVar + str6 + path4;
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) new a(r1);
            }
            if (this.v == i2) {
                str2 = Y(e.G);
            } else {
                str2 = Y(e.F);
            }
            this.E = str2;
            try {
                this.B = i11;
                int i20 = this.a - 1;
                this.v[i20] = iArr3[i20] + 1;
            } catch (java.lang.NumberFormatException unused) {
                stringBuilder = new StringBuilder();
                path = getPath();
                stringBuilder = str7 + this.E + str5 + this.E;
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) new a(stringBuilder);
            }
        }
        return Integer.parseInt(str2);
    }

    @Override // com.airbnb.lottie.x.k0.c
    public String o() throws a {
        int i;
        String str;
        if (this.B == 0) {
            i = M();
        }
        int i2 = 14;
        if (this.B == 14) {
            str = e0();
            this.B = 0;
            this.c[this.a - 1] = str;
            return str;
        } else {
            i2 = 13;
            if (this.B == 13) {
                str = Y(e.G);
            } else {
                i2 = 12;
                if (this.B == 12) {
                    str = Y(e.F);
                } else {
                    i2 = 15;
                    if (e.G == 15) {
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Expected a name but was ";
        com.airbnb.lottie.x.k0.c.b bVar = w();
        String str3 = " at path ";
        String path = getPath();
        r1 = str2 + bVar + str3 + path;
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) new a(r1);
    }

    @Override // com.airbnb.lottie.x.k0.c
    public String q() throws a {
        int i;
        String obj;
        if (this.B == 0) {
            i = M();
        }
        int i2 = 10;
        if (this.B == 10) {
            obj = e0();
            this.B = 0;
            int i8 = this.a - 1;
            this.v[i8] = iArr[i8] + 1;
            return obj;
        } else {
            i2 = 9;
            if (this.B == 9) {
                obj = Y(e.G);
            } else {
                i2 = 8;
                if (this.B == 8) {
                    obj = Y(e.F);
                } else {
                    if (this.B == 11) {
                        this.E = null;
                    } else {
                        i2 = 16;
                        if (e.F == i2) {
                            obj = Long.toString(this.C);
                        } else {
                            if (e.F == 17) {
                                obj = this.A.L((long)this.D);
                            }
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Expected a string but was ";
        com.airbnb.lottie.x.k0.c.b bVar = w();
        String str3 = " at path ";
        String path = getPath();
        r1 = str2 + bVar + str3 + path;
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) new a(r1);
    }

    @Override // com.airbnb.lottie.x.k0.c
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "JsonReader(";
        String str3 = ")";
        str = str2 + this.z + str3;
        return str;
    }

    @Override // com.airbnb.lottie.x.k0.c
    public c.b w() {
        int i2;
        if (this.B == 0) {
            i2 = M();
        }
        switch (i2) {
            case 1:
                return c.b.BEGIN_OBJECT;
            case 2:
                return c.b.END_OBJECT;
            case 3:
                return c.b.BEGIN_ARRAY;
            case 4:
                return c.b.END_ARRAY;
            case 5:
                return c.b.BOOLEAN;
            case 6:
                return c.b.NULL;
            case 7:
                return c.b.STRING;
            case 8:
                return c.b.NAME;
            case 9:
                return c.b.NUMBER;
            case 10:
                return c.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }
}
