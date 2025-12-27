package com.squareup.moshi;

import java.io.EOFException;
import java.math.BigDecimal;
import java.util.Objects;
import l.d0;
import l.f;
import l.h;
import l.i;

/* compiled from: JsonUtf8Reader.java */
/* loaded from: classes2.dex */
final class k extends i {

    private static final i F;
    private static final i G;
    private static final i H;
    private static final i I;
    private static final i J;
    private int A = 0;
    private long B;
    private int C;
    private String D;
    private m E;
    private final h y;
    private final f z;
    static {
        k.F = i.i("'\\");
        k.G = i.i("\"\\");
        k.H = i.i("{}[]:, \n\t\r\u000c/\\;#=");
        k.I = i.i("\n\r");
        k.J = i.i("*/");
    }

    k(h hVar) {
        super();
        Objects.requireNonNull(hVar, "source == null");
        this.y = hVar;
        this.z = hVar.h();
        H(6);
    }

    private int A0() {
        int i = 6;
        String str;
        String str2;
        int i2 = 1;
        byte b4;
        byte b5 = this.z.n(0L);
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
            b4 = this.z.n((long)i2);
            if (b4 != str.charAt(i2) && b4 != str2.charAt(i2)) {
            }
        }
        int i5 = length + 1;
        l = (long)i5;
        if (this.y.request(l)) {
            l = (long)length;
            if (l0(this.z.n(l))) {
                return i4;
            }
        }
        this.z.skip((long)length);
        this.A = i;
        return i;
    }

    private int C0() {
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
        while (!obj.y.request((long)cmp)) {
            b = obj.z.n((long)cmp);
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
            obj.B = i;
            obj.z.skip((long)cmp);
            int i5 = 16;
            obj.A = i5;
            return i5;
        }
        obj.C = cmp;
        int i4 = 17;
        obj.A = i4;
        return i4;
    }

    private char G0() throws EOFException, StringBuilder {
        int i = 0;
        char c;
        int i3;
        int i2;
        byte b2 = 97;
        int i9 = 0;
        if (!this.y.request(1L)) {
            V("Unterminated escape sequence");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i9;
        } else {
            byte _byte = this.z.readByte();
            byte b3 = (byte) 10;
            if (_byte != b3 && _byte != (byte) 34 && _byte != (byte) 39 && _byte != (byte) 47 && _byte != (byte) 92 && _byte != 98) {
                byte b4 = (byte) 102;
                if (_byte != b4 && _byte != 110) {
                    if (_byte != 114 && _byte != 116) {
                        if (_byte != 117 && this.w) {
                            return (char)_byte;
                        }
                        long l = 4L;
                        if (!this.y.request(l)) {
                            StringBuilder stringBuilder2 = new StringBuilder();
                            String str4 = "Unterminated escape sequence at path ";
                            String path = getPath();
                            r1 = str4 + path;
                            throw new EOFException(r1);
                        } else {
                            i = 0;
                            while (this.y < 4) {
                                byte b5 = this.z.n((long)i);
                                b2 = (byte) 48;
                            }
                            this.z.skip(l);
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

    private void I0(i iVar) {
        long l = this.y.n0(iVar);
        while (l != -1) {
            final long l4 = 1L;
        }
        V("Unterminated string");
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) 0;
    }

    private boolean J0() {
        boolean z = true;
        long size;
        iVar = k.J;
        long l2 = this.y.a0(iVar);
        int r0 = l2 != -1 ? 1 : 0;
        if (this.y) {
            l = (long)k.J.A();
            size = l2 + l;
        } else {
            size = this.z.size();
        }
        this.z.skip(size);
        return z;
    }

    private void L0() {
        long size;
        final i iVar = k.I;
        long l2 = this.y.n0(iVar);
        if (l2 != -1) {
            long l = 1L;
            size = l2 + l;
        } else {
            size = this.z.size();
        }
        this.z.skip(size);
    }

    private void N0() {
        long size;
        final i iVar = k.H;
        size = this.y.n0(iVar);
        if (size == -1) {
            size = this.z.size();
        }
        this.z.skip(size);
    }

    private void Y() {
        if (!this.w) {
            V("Use JsonReader.setLenient(true) to accept malformed JSON");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }
    }

    private int e0() {
        final Object obj = this;
        int i31 = iArr[i19 - 1];
        long l = 0L;
        final int i34 = 8;
        final int i35 = 9;
        int i6 = 93;
        final int i37 = 3;
        final int i38 = 7;
        final int i39 = 59;
        final int i40 = 44;
        final int i41 = 4;
        int i5 = 2;
        final int i42 = 0;
        final int i36 = 1;
        if (i31 == i36) {
            obj.b[i19 - i36] = i5;
            int i2 = obj.t0(true);
            if (i2 != 34 && i2 != 39) {
                if (i2 != i40 && i2 != i39) {
                    if (i2 != 91 && i2 != 93) {
                        if (i2 != 123 && i16 != 0) {
                            return i16;
                        }
                        obj.z.readByte();
                        obj.A = i36;
                        return i36;
                    }
                    obj.z.readByte();
                    int i15 = 3;
                    obj.A = i15;
                    return i15;
                }
                Y();
                obj.A = i38;
                return i38;
            }
            obj.z.readByte();
            obj.A = i35;
            return i35;
        } else {
            if (i31 == i5) {
                int i = obj.t0(true);
                obj.z.readByte();
                if (i != i40 && i != i39) {
                    if (i != 93) {
                        obj.V("Unterminated array");
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i42;
                    } else {
                        obj.A = i41;
                        return i41;
                    }
                }
            }
        }
        i3 = i19 - i36;
        obj.b[i3] = i41;
        int i9 = 125;
        if (i31 == i5) {
            int i3 = obj.t0(true);
            obj.z.readByte();
            if (i3 != i40 && i3 != i39) {
                if (i3 != i9) {
                    obj.V("Unterminated object");
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i42;
                } else {
                    int i10 = 2;
                    obj.A = i10;
                    return i10;
                }
            }
        }
        int i25 = obj.t0(true);
        if (i25 != 34 && i25 != 39) {
            String str7 = "Expected name";
            if (i25 != i9) {
                Y();
                if (!obj.l0((char)i25)) {
                    obj.V(str7);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i42;
                } else {
                    int i13 = 14;
                    obj.A = i13;
                    return i13;
                }
            }
            if (i31 == i5) {
                obj.V(str7);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i42;
            } else {
                obj.z.readByte();
                int i12 = 2;
                obj.A = i12;
                return i12;
            }
        }
        obj.z.readByte();
        int i14 = 13;
        obj.A = i14;
        return i14;
    }

    private int g0(String str, i.a aVar) {
        int i;
        i = 0;
        while (i < aVar.a.length) {
            if (str.equals(aVar.a[i])) {
                this.A = i;
                this.c[this.a - 1] = str;
                return i;
            }
        }
        return -1;
    }

    private int j0(String str, i.a aVar) {
        int i;
        i = 0;
        while (i < aVar.a.length) {
            if (str.equals(aVar.a[i])) {
                this.A = i;
                int i6 = this.a - 1;
                this.v[i6] = iArr[i6] + 1;
                return i;
            }
        }
        return -1;
    }

    private boolean l0(int i) {
        int i2 = 35;
        i2 = 9;
        if (i != 9 && i != 10 && i != 12 && i != 13 && i != 32 && i != 35 && i != 44 && i != 47 && i != 61 && i != 123 && i != 125 && i != 58 && i != 59) {
            switch (i) {
                case 91:
                    return false;
                case 92:
                    Y();
                    return false;
                default:
                    return true;
            }
        }
    }

    private int t0(boolean z) throws EOFException {
        int i;
        byte b = 47;
        byte b2;
        long l = 42;
        while (/* condition */) {
            b2 = i + 1;
            while (this.y.request((long)b2)) {
                l = (long)i;
                byte b3 = this.z.n(l);
                b = (byte) 10;
                if (b3 != (byte) 10) {
                    b = (byte) 32;
                }
            }
            l = (long)i;
            b3 = this.z.n(l);
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

    private String v0(i iVar) {
        int i;
        i = 0;
        long l = this.y.n0(iVar);
        while (l != -1) {
            byte b = (byte) 92;
            if (this.z.n(l) != (byte) 92) {
            }
        }
        V("Unterminated string");
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) i;
    }

    private String z0() {
        String str;
        final i iVar = k.H;
        long l = this.y.n0(iVar);
        if (l != -1) {
            str = this.z.L(l);
        } else {
            str = this.z.r1();
        }
        return str;
    }

    @Override // com.squareup.moshi.i
    public i.b E() {
        int i2;
        if (this.A == 0) {
            i2 = e0();
        }
        switch (i2) {
            case 1:
                return i.b.BEGIN_OBJECT;
            case 2:
                return i.b.END_OBJECT;
            case 3:
                return i.b.BEGIN_ARRAY;
            case 4:
                return i.b.END_ARRAY;
            case 5:
                return i.b.BOOLEAN;
            case 6:
                return i.b.NULL;
            case 7:
                return i.b.STRING;
            case 8:
                return i.b.NAME;
            case 9:
                return i.b.NUMBER;
            case 10:
                return i.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // com.squareup.moshi.i
    public void F() {
        if (j()) {
            this.D = m0();
            this.A = 11;
        }
    }

    @Override // com.squareup.moshi.i
    public int J(i.a aVar) {
        int i;
        if (this.A == 0) {
            i = e0();
        }
        int i2 = 12;
        int i3 = -1;
        return i3;
    }

    @Override // com.squareup.moshi.i
    public int K(i.a aVar) {
        int i;
        if (this.A == 0) {
            i = e0();
        }
        int i2 = 8;
        int i3 = -1;
        return i3;
    }

    @Override // com.squareup.moshi.i
    public void T() throws JsonDataException {
        int i;
        if (this.x) {
            com.squareup.moshi.i.b bVar = E();
            m0();
            StringBuilder stringBuilder2 = new StringBuilder();
            final String str5 = "Cannot skip unexpected ";
            String str = " at ";
            String path = getPath();
            r0 = str5 + bVar + str + path;
            throw new JsonDataException(r0);
        } else {
            if (this.A == 0) {
                i = e0();
            }
            int i2 = 14;
            if (this.x == 14) {
                N0();
                this.A = 0;
                this.c[this.a - 1] = "null";
                return;
            } else {
                i2 = 13;
                if (this.x == 13) {
                    I0(k.G);
                } else {
                    i2 = 12;
                    if (this.x == 12) {
                        I0(k.F);
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "Expected a name but was ";
            com.squareup.moshi.i.b bVar2 = E();
            String str4 = " at path ";
            String path2 = getPath();
            r1 = str3 + bVar2 + str4 + path2;
            throw new JsonDataException(r1);
        }
    }

    @Override // com.squareup.moshi.i
    public void U() throws JsonDataException {
        int i;
        int i2;
        int i3 = 3;
        String str;
        String str2;
        if (this.x) {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "Cannot skip unexpected ";
            com.squareup.moshi.i.b bVar = E();
            String str4 = " at ";
            String path = getPath();
            r1 = str3 + bVar + str4 + path;
            throw new JsonDataException(r1);
        } else {
            i = 0;
            while (this.A == 0) {
                i2 = e0();
                i3 = 3;
                int i4 = 1;
                i3 = 4;
                str = " at path ";
                str2 = "Expected a value but was ";
                i3 = 2;
                i3 = 14;
                N0();
                this.A = i;
                if (i == 0) {
                    int i7 = i5 - 1;
                    this.v[i7] = iArr[i7] + i4;
                    this.c[i5 - i4] = "null";
                    return;
                }
                i3 = 10;
                i3 = 9;
                I0(k.G);
                i3 = 13;
                i3 = 8;
                I0(k.F);
                i3 = 12;
                i3 = 18;
                this.z.skip((long)this.C);
                i = i - 1;
                this.a -= i4;
                i = i - 1;
                this.a -= i4;
                H(i3);
                i = i + 1;
                H(i4);
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            com.squareup.moshi.i.b bVar2 = E();
            String path2 = getPath();
            r1 = str2 + bVar2 + str + path2;
            throw new JsonDataException(r1);
        }
    }

    @Override // com.squareup.moshi.i
    public void a() throws JsonDataException {
        int i;
        if (this.A == 0) {
            i = e0();
        }
        if (this.A != 3) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Expected BEGIN_ARRAY but was ";
            com.squareup.moshi.i.b bVar = E();
            String str2 = " at path ";
            String path = getPath();
            r1 = str + bVar + str2 + path;
            throw new JsonDataException(r1);
        } else {
            int i2 = 1;
            H(i2);
            int i3 = 0;
            this.v[this.a - i2] = i3;
            this.A = i3;
            return;
        }
    }

    @Override // com.squareup.moshi.i
    public void c() throws JsonDataException {
        int i;
        if (this.A == 0) {
            i = e0();
        }
        if (this.A != 1) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Expected BEGIN_OBJECT but was ";
            com.squareup.moshi.i.b bVar = E();
            String str2 = " at path ";
            String path = getPath();
            r1 = str + bVar + str2 + path;
            throw new JsonDataException(r1);
        } else {
            H(3);
            this.A = 0;
            return;
        }
    }

    @Override // com.squareup.moshi.i
    public void close() {
        int i = 0;
        this.A = i;
        this.b[i] = 8;
        this.a = 1;
        this.z.a();
        this.y.close();
    }

    @Override // com.squareup.moshi.i
    public void e() throws JsonDataException {
        int i;
        if (this.A == 0) {
            i = e0();
        }
        if (this.A != 4) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Expected END_ARRAY but was ";
            com.squareup.moshi.i.b bVar = E();
            String str2 = " at path ";
            String path = getPath();
            r1 = str + bVar + str2 + path;
            throw new JsonDataException(r1);
        } else {
            this.a--;
            int i4 = i3 - 1;
            this.v[i4] = iArr[i4] + 1;
            this.A = 0;
            return;
        }
    }

    @Override // com.squareup.moshi.i
    public void f() throws JsonDataException {
        int i;
        if (this.A == 0) {
            i = e0();
        }
        if (this.A != 2) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Expected END_OBJECT but was ";
            com.squareup.moshi.i.b bVar = E();
            String str2 = " at path ";
            String path = getPath();
            r1 = str + bVar + str2 + path;
            throw new JsonDataException(r1);
        } else {
            this.a--;
            this.c[i3] = 0;
            int i4 = i3 - 1;
            this.v[i4] = iArr[i4] + 1;
            this.A = 0;
            return;
        }
    }

    @Override // com.squareup.moshi.i
    public boolean j() {
        int i;
        boolean z = true;
        int i2 = 2;
        if (this.A == 0) {
            i = e0();
        }
        i2 = 2;
        int r0 = this.A != 2 && this.A != 4 && this.A != 18 ? 1 : 0;
        return (this.A != 2 && this.A != 4 && this.A != 18 ? 1 : 0);
    }

    @Override // com.squareup.moshi.i
    public boolean m() throws JsonDataException {
        int i;
        if (this.A == 0) {
            i = e0();
        }
        int i8 = 0;
        final int i11 = 1;
        if (this.A == 5) {
            this.A = i8;
            int i4 = this.a - i11;
            this.v[i4] = iArr[i4] + i11;
            return true;
        }
        if (this.v != 6) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Expected a boolean but was ";
            com.squareup.moshi.i.b bVar = E();
            String str2 = " at path ";
            String path = getPath();
            r1 = str + bVar + str2 + path;
            throw new JsonDataException(r1);
        } else {
            this.A = i8;
            int i7 = this.a - i11;
            this.v[i7] = iArr2[i7] + i11;
            return false;
        }
    }

    @Override // com.squareup.moshi.i
    public String m0() throws JsonDataException {
        int i;
        String str;
        if (this.A == 0) {
            i = e0();
        }
        int i2 = 14;
        if (this.A == 14) {
            str = z0();
            this.A = 0;
            this.c[this.a - 1] = str;
            return str;
        } else {
            i2 = 13;
            if (this.A == 13) {
                str = v0(k.G);
            } else {
                i2 = 12;
                if (k.G == 12) {
                    str = v0(k.F);
                } else {
                    if (k.G == 15) {
                        this.D = null;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str3 = "Expected a name but was ";
        com.squareup.moshi.i.b bVar = E();
        String str4 = " at path ";
        String path = getPath();
        r1 = str3 + bVar + str4 + path;
        throw new JsonDataException(r1);
    }

    @Override // com.squareup.moshi.i
    public double n() throws JsonEncodingException, JsonDataException {
        int i;
        int i2 = 9;
        if (this.A == 0) {
            i = e0();
        }
        int i7 = 0;
        if (this.A == 16) {
            this.A = i7;
            int i5 = this.a - 1;
            this.v[i5] = iArr[i5] + 1;
            return (double)this.B;
        }
        String str4 = "Expected a double but was ";
        int i13 = 11;
        final String str7 = " at path ";
        if (this.A == 17) {
            l = (long)this.C;
            this.D = this.z.L(l);
            this.A = i13;
            try {
                double parsed = Double.parseDouble(this.D);
            } catch (java.lang.NumberFormatException unused) {
                StringBuilder stringBuilder = new StringBuilder();
                String path2 = getPath();
                stringBuilder = str3 + this.D + str6 + this.D;
                throw new JsonDataException(stringBuilder);
            }
            if (!this.w && !Double.isNaN(this.D, i2)) {
                if (Double.isInfinite(parsed)) {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    String str5 = "JSON forbids NaN and infinities: ";
                    String path = getPath();
                    r0 = str5 + parsed + str7 + path;
                    throw new JsonEncodingException(r0);
                }
            }
            this.D = null;
            this.A = i7;
            int i12 = this.a - 1;
            this.v[i12] = iArr2[i12] + 1;
            return parsed;
        } else {
            i2 = 9;
            if (this.D == 9) {
                this.D = v0(k.G);
            } else {
                i2 = 8;
                if (this.D == 8) {
                    this.D = v0(k.F);
                } else {
                    i2 = 10;
                    if (this.D == 10) {
                        this.D = z0();
                    }
                }
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        com.squareup.moshi.i.b bVar = E();
        String path3 = getPath();
        r1 = str4 + bVar + str7 + path3;
        throw new JsonDataException(r1);
    }

    @Override // com.squareup.moshi.i
    public int o() throws JsonDataException {
        int i;
        String str2;
        if (this.A == 0) {
            i = e0();
        }
        int i11 = 0;
        final String str6 = " at path ";
        String str8 = "Expected an int but was ";
        if (this.A == 16) {
            int i16 = (int)l;
            if (this.B != l) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String path2 = getPath();
                r1 = str8 + this.B + str6 + path2;
                throw new JsonDataException(r1);
            } else {
                this.A = i11;
                int i7 = this.a - 1;
                this.v[i7] = iArr[i7] + 1;
                return i16;
            }
        }
        int i17 = 11;
        if (this.v == 17) {
            l2 = (long)this.C;
            this.D = this.z.L(l2);
            this.A = i17;
            try {
                double parsed = Double.parseDouble(this.D);
            } catch (java.lang.NumberFormatException unused) {
                StringBuilder stringBuilder = new StringBuilder();
                String path = getPath();
                stringBuilder = str7 + this.D + str5 + this.D;
                throw new JsonDataException(stringBuilder);
            }
            if (parsed != this.v) {
                StringBuilder stringBuilder3 = new StringBuilder();
                String path3 = getPath();
                r1 = str8 + this.D + str6 + path3;
                throw new JsonDataException(r1);
            } else {
                this.D = null;
                this.A = i11;
                int i10 = this.a - 1;
                this.v[i10] = iArr2[i10] + 1;
                return (int)parsed;
            }
        } else {
            int i2 = 9;
            if (this.v != i2) {
                StringBuilder stringBuilder4 = new StringBuilder();
                com.squareup.moshi.i.b bVar = E();
                String path4 = getPath();
                r1 = str8 + bVar + str6 + path4;
                throw new JsonDataException(r1);
            }
            if (this.v == i2) {
                str2 = v0(k.G);
            } else {
                str2 = v0(k.F);
            }
            this.D = str2;
            try {
                this.A = i11;
                int i20 = this.a - 1;
                this.v[i20] = iArr3[i20] + 1;
            } catch (java.lang.NumberFormatException unused) {
                stringBuilder = new StringBuilder();
                path = getPath();
                stringBuilder = str7 + this.D + str5 + this.D;
                throw new JsonDataException(stringBuilder);
            }
        }
        return Integer.parseInt(str2);
    }

    @Override // com.squareup.moshi.i
    public long q() throws JsonDataException {
        int i;
        String str;
        if (this.A == 0) {
            i = e0();
        }
        int i8 = 0;
        if (this.A == 16) {
            this.A = i8;
            int i6 = this.a - 1;
            this.v[i6] = iArr[i6] + 1;
            return this.B;
        }
        String str5 = " at path ";
        String str7 = "Expected a long but was ";
        final int i16 = 11;
        if (this.B == 17) {
            this.D = this.z.L((long)this.C);
            this.A = i16;
            try {
            } catch (java.lang.NumberFormatException | java.lang.ArithmeticException unused) {
                StringBuilder stringBuilder = new StringBuilder();
                String path = getPath();
                stringBuilder = str6 + this.D + str4 + this.D;
                throw new JsonDataException(stringBuilder);
            }
            this.D = null;
            this.A = i8;
            int i13 = this.a - 1;
            this.v[i13] = iArr2[i13] + 1;
            return new BigDecimal(this.D).longValueExact();
        } else {
            int i2 = 9;
            if (this.A != i2) {
                int i3 = 8;
                StringBuilder stringBuilder2 = new StringBuilder();
                com.squareup.moshi.i.b bVar = E();
                String path2 = getPath();
                r1 = str7 + bVar + str5 + path2;
                throw new JsonDataException(r1);
            }
            if (this.A == i2) {
                str = v0(k.G);
            } else {
                str = v0(k.F);
            }
            this.D = str;
            try {
                this.A = i8;
                int i18 = this.a - 1;
                this.v[i18] = iArr3[i18] + 1;
            } catch (java.lang.NumberFormatException | java.lang.ArithmeticException unused) {
                stringBuilder = new StringBuilder();
                path = getPath();
                stringBuilder = str6 + this.D + str4 + this.D;
                throw new JsonDataException(stringBuilder);
            }
        }
        return Long.parseLong(str);
    }

    @Override // com.squareup.moshi.i
    public <T> T r() throws JsonDataException {
        int i;
        if (this.A == 0) {
            i = e0();
        }
        if (this.A != 7) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Expected null but was ";
            com.squareup.moshi.i.b bVar = E();
            String str2 = " at path ";
            String path = getPath();
            r1 = str + bVar + str2 + path;
            throw new JsonDataException(r1);
        } else {
            this.A = 0;
            int i6 = this.a - 1;
            this.v[i6] = iArr[i6] + 1;
            return null;
        }
    }

    @Override // com.squareup.moshi.i
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "JsonReader(";
        String str3 = ")";
        str = str2 + this.y + str3;
        return str;
    }

    @Override // com.squareup.moshi.i
    public String w() throws JsonDataException {
        int i;
        String obj;
        if (this.A == 0) {
            i = e0();
        }
        int i2 = 10;
        if (this.A == 10) {
            obj = z0();
            this.A = 0;
            int i8 = this.a - 1;
            this.v[i8] = iArr[i8] + 1;
            return obj;
        } else {
            i2 = 9;
            if (this.A == 9) {
                obj = v0(k.G);
            } else {
                i2 = 8;
                if (k.G == 8) {
                    obj = v0(k.F);
                } else {
                    if (k.G == 11) {
                        this.D = null;
                    } else {
                        i2 = 16;
                        if (this.D == i2) {
                            obj = Long.toString(this.B);
                        } else {
                            if (this.D == 17) {
                                obj = this.z.L((long)this.C);
                            }
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "Expected a string but was ";
        com.squareup.moshi.i.b bVar = E();
        String str3 = " at path ";
        String path = getPath();
        r1 = str2 + bVar + str3 + path;
        throw new JsonDataException(r1);
    }
}
