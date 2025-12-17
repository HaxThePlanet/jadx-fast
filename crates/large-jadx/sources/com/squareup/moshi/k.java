package com.squareup.moshi;

import java.io.EOFException;
import java.math.BigDecimal;
import java.util.Objects;
import l.d0;
import l.f;
import l.h;
import l.i;

/* loaded from: classes2.dex */
final class k extends com.squareup.moshi.i {

    private static final i F;
    private static final i G;
    private static final i H;
    private static final i I;
    private static final i J;
    private int A = 0;
    private long B;
    private int C;
    private String D;
    private com.squareup.moshi.m E;
    private final h y;
    private final f z;
    static {
        k.F = i.i("'\\");
        k.G = i.i("\"\\");
        k.H = i.i("{}[]:, \n\t\r\u000c/\\;#=");
        k.I = i.i("\n\r");
        k.J = i.i("*/");
    }

    k(h h) {
        super();
        int i = 0;
        Objects.requireNonNull(h, "source == null");
        this.y = h;
        this.z = h.h();
        H(6);
    }

    private int A0() {
        int i3;
        int i2;
        int i4;
        int i;
        String str2;
        boolean request;
        String str;
        int charAt;
        long l;
        byte b;
        int i5;
        char charAt2;
        byte b2 = this.z.n(0);
        int i7 = 0;
        if (b2 != 116) {
            if (b2 == 84) {
                i3 = 5;
                str2 = "true";
                str = "TRUE";
            } else {
                if (b2 != 102) {
                    if (b2 == 70) {
                        i3 = 6;
                        str2 = "false";
                        str = "FALSE";
                    } else {
                        if (b2 != 110 && b2 == 78) {
                            if (b2 == 78) {
                            }
                            return i7;
                        }
                        i3 = 7;
                        str2 = "null";
                        str = "NULL";
                    }
                } else {
                }
            }
        } else {
        }
        final int length = str2.length();
        charAt = 1;
        while (charAt < length) {
            i5 = charAt + 1;
            b = this.z.n((long)charAt);
            charAt = i5;
        }
        int i8 = length + 1;
        if (this.y.request((long)i8) && l0(this.z.n((long)length))) {
            if (l0(this.z.n((long)length))) {
                return i7;
            }
        }
        this.z.skip((long)length);
        this.A = i3;
        return i3;
    }

    private int C0() {
        int cmp2;
        int cmp;
        int cmp4;
        int i9;
        int cmp3;
        int i2;
        int i;
        int i6;
        int i5;
        byte request;
        int i7;
        int i3;
        int i8;
        int i4;
        final Object obj = this;
        cmp2 = 0;
        i6 = cmp2;
        i = cmp;
        i5 = i2;
        i7 = cmp3 + 1;
        i4 = 2;
        while (!obj.y.request((long)i7)) {
            request = obj.z.n((long)cmp3);
            i8 = 5;
            cmp = 6;
            i2 = cmp;
            cmp3 = i7;
            cmp = 1;
            i7 = cmp3 + 1;
            i4 = 2;
            i2 = i8;
            cmp = 6;
            i2 = 1;
            i5 = 1;
            cmp = 3;
            i6 = (long)cmp;
            i2 = i4;
            i9 = 0;
            if (i2 == 3) {
            } else {
            }
            if (i2 != i8) {
            } else {
            }
            i9 = 0;
            i2 = 7;
            if (i2 == 6) {
            } else {
            }
            i9 = 0;
            i2 = 4;
            i15 -= l2;
            cmp4 = Long.compare(i6, l3);
            if (cmp4 <= 0) {
            } else {
            }
            cmp = 1;
            i &= cmp;
            i6 = i3;
            if (cmp4 == 0 && Long.compare(i3, i6) < 0) {
            } else {
            }
            cmp = 0;
            if (Long.compare(i3, i6) < 0) {
            } else {
            }
        }
        if (i2 == i4) {
            if (i != 0) {
                cmp = Long.compare(i6, l4);
                if (cmp == 0) {
                    if (i5 != 0) {
                        if (Long.compare(i6, cmp2) == 0) {
                            if (i5 == 0) {
                                if (i5 != 0) {
                                } else {
                                    i6 = -i6;
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
                obj.B = i6;
                obj.z.skip((long)cmp3);
                int i11 = 16;
                obj.A = i11;
                return i11;
            }
        }
        if (i2 != i4 && i2 != 4 && i2 == 7) {
            if (i2 != 4) {
                if (i2 == 7) {
                }
                return 0;
            }
        }
        obj.C = cmp3;
        int i10 = 17;
        obj.A = i10;
        return i10;
    }

    private char G0() {
        int i;
        int i4;
        int i5;
        int i6;
        int i2;
        int i3;
        int i12 = 0;
        if (!this.y.request(1)) {
        } else {
            byte byte = this.z.readByte();
            int i13 = 10;
            int i15 = 102;
            if (byte != i13 && byte != 34 && byte != 39 && byte != 47 && byte != 92 && byte != 98 && byte != i15 && byte != 110 && byte != 114 && byte != 116 && byte != 117) {
                if (byte != 34) {
                    if (byte != 39) {
                        if (byte != 47) {
                            if (byte != 92) {
                                if (byte != 98) {
                                    i15 = 102;
                                    if (byte != i15) {
                                        if (byte != 110) {
                                            if (byte != 114) {
                                                if (byte != 116) {
                                                    if (byte != 117) {
                                                        if (!this.w) {
                                                        } else {
                                                            return (char)byte;
                                                        }
                                                        StringBuilder stringBuilder3 = new StringBuilder();
                                                        stringBuilder3.append("Invalid escape sequence: \\");
                                                        stringBuilder3.append((char)byte);
                                                        V(stringBuilder3.toString());
                                                        throw i12;
                                                    }
                                                    int i20 = 4;
                                                    if (!this.y.request(i20)) {
                                                    } else {
                                                        i5 = i;
                                                        while (i < 4) {
                                                            byte b = this.z.n((long)i);
                                                            b += -65;
                                                            i2 += i13;
                                                            i5 = (char)i22;
                                                            i++;
                                                            b += -97;
                                                            b += -48;
                                                        }
                                                        this.z.skip(i20);
                                                        return i5;
                                                    }
                                                    StringBuilder stringBuilder2 = new StringBuilder();
                                                    stringBuilder2.append("Unterminated escape sequence at path ");
                                                    stringBuilder2.append(getPath());
                                                    EOFException eOFException = new EOFException(stringBuilder2.toString());
                                                    throw eOFException;
                                                }
                                                return 9;
                                            }
                                            return 13;
                                        }
                                        return i13;
                                    }
                                    return 12;
                                }
                                return 8;
                            }
                        }
                    }
                }
            }
            return (char)byte;
        }
        V("Unterminated escape sequence");
        throw i12;
    }

    private void I0(i i) {
        long l = this.y.n0(i);
        while (Long.compare(l, i4) != 0) {
            final int i6 = 1;
            this.z.skip(l += i6);
            G0();
            l = this.y.n0(i);
        }
        V("Unterminated string");
        throw 0;
    }

    private boolean J0() {
        int i;
        i iVar;
        long size;
        long l;
        iVar = k.J;
        long l2 = this.y.a0(iVar);
        i = Long.compare(l2, i2) != 0 ? 1 : 0;
        f fVar = this.z;
        if (i != 0) {
            l2 += l;
        } else {
            size = fVar.size();
        }
        fVar.skip(size);
        return i;
    }

    private void L0() {
        int size;
        int cmp;
        final i iVar = k.I;
        long l = this.y.n0(iVar);
        final f fVar = this.z;
        if (Long.compare(l, i) != 0) {
            l += cmp;
        } else {
            size = fVar.size();
        }
        fVar.skip(size);
    }

    private void N0() {
        long size;
        final i iVar = k.H;
        final f fVar = this.z;
        if (Long.compare(size, i) != 0) {
        } else {
            size = fVar.size();
        }
        fVar.skip(size);
    }

    private void Y() {
        if (!this.w) {
        } else {
        }
        V("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw 0;
    }

    private int e0() {
        int request;
        int i4;
        int i;
        f i7;
        int i2;
        int i3;
        int i5;
        int i6;
        final Object obj = this;
        request = obj.b;
        i7 = obj.a;
        int i26 = request[i7 + -1];
        i3 = 0;
        final int i29 = 8;
        final int i30 = 9;
        final int i32 = 3;
        final int i33 = 7;
        final int i34 = 59;
        final int i35 = 44;
        final int i36 = 4;
        i5 = 2;
        final int i37 = 0;
        final int i31 = 1;
        if (i26 == i31) {
            request[i7 -= i31] = i5;
            i4 = obj.t0(i31);
            int i17 = A0();
            if (i4 != 34 && i4 != 39 && i4 != i35 && i4 != i34 && i4 != 91 && i4 != 93 && i4 != 123 && i17 != 0) {
                if (i4 != 39) {
                    if (i4 != i35) {
                        if (i4 != i34) {
                            if (i4 != 91) {
                                if (i4 != 93) {
                                    if (i4 != 123) {
                                        i17 = A0();
                                        if (i17 != 0) {
                                            return i17;
                                        }
                                        int i18 = C0();
                                        if (i18 != 0) {
                                            return i18;
                                        }
                                        if (!obj.l0(obj.z.n(i3))) {
                                        } else {
                                            Y();
                                            int i19 = 10;
                                            obj.A = i19;
                                            return i19;
                                        }
                                        obj.V("Expected value");
                                        throw i37;
                                    }
                                    obj.z.readByte();
                                    obj.A = i31;
                                    return i31;
                                }
                                if (i26 == i31) {
                                    obj.z.readByte();
                                    obj.A = i36;
                                    return i36;
                                }
                            }
                            obj.z.readByte();
                            int i16 = 3;
                            obj.A = i16;
                            return i16;
                        }
                    }
                    if (i26 != i31) {
                        if (i26 != 2) {
                        } else {
                        }
                        obj.V("Unexpected value");
                        throw i37;
                    }
                    Y();
                    obj.A = i33;
                    return i33;
                }
                Y();
                obj.z.readByte();
                obj.A = i29;
                return i29;
            }
            obj.z.readByte();
            obj.A = i30;
            return i30;
        } else {
            if (i26 == i5) {
                request = obj.t0(i31);
                obj.z.readByte();
                if (request != i35 && request != i34) {
                    if (request != i34) {
                        if (request != 93) {
                        } else {
                            obj.A = i36;
                            return i36;
                        }
                        obj.V("Unterminated array");
                        throw i37;
                    }
                    Y();
                }
            } else {
                i5 = 5;
                if (i26 != i32) {
                    if (i26 == i5) {
                    } else {
                        if (i26 == i36) {
                            request[i7 -= i31] = i5;
                            request = obj.t0(i31);
                            obj.z.readByte();
                            if (request != 58) {
                                if (request != 61) {
                                } else {
                                    Y();
                                    if (obj.y.request(1) && obj.z.n(i3) == 62) {
                                        if (obj.z.n(i3) == 62) {
                                            obj.z.readByte();
                                        }
                                    }
                                }
                                obj.V("Expected ':'");
                                throw i37;
                            }
                        } else {
                            if (i26 == 6) {
                                request[i7 -= i31] = i33;
                            } else {
                                if (i26 == i33) {
                                    if (obj.t0(false) == -1) {
                                        int i9 = 18;
                                        obj.A = i9;
                                        return i9;
                                    }
                                    Y();
                                } else {
                                    if (i26 == i30) {
                                    } else {
                                        if (i26 == i29) {
                                        } else {
                                        }
                                        IllegalStateException illegalStateException = new IllegalStateException("JsonReader is closed");
                                        throw illegalStateException;
                                    }
                                }
                            }
                        }
                    }
                    obj.E.a();
                    throw i37;
                }
            }
        }
        request[i7 -= i31] = i36;
        int i10 = 125;
        i = obj.t0(i31);
        obj.z.readByte();
        if (i26 == i5 && i != i35 && i != i34) {
            i = obj.t0(i31);
            obj.z.readByte();
            if (i != i35) {
                if (i != i34) {
                    if (i != i10) {
                    } else {
                        int i11 = 2;
                        obj.A = i11;
                        return i11;
                    }
                    obj.V("Unterminated object");
                    throw i37;
                }
                Y();
            }
        }
        int i21 = obj.t0(i31);
        String str7 = "Expected name";
        if (i21 != 34 && i21 != 39 && i21 != i10) {
            if (i21 != 39) {
                str7 = "Expected name";
                if (i21 != i10) {
                    Y();
                    if (!obj.l0((char)i21)) {
                    } else {
                        int i14 = 14;
                        obj.A = i14;
                        return i14;
                    }
                    obj.V(str7);
                    throw i37;
                }
                if (i26 == i5) {
                } else {
                    obj.z.readByte();
                    int i13 = 2;
                    obj.A = i13;
                    return i13;
                }
                obj.V(str7);
                throw i37;
            }
            obj.z.readByte();
            Y();
            int i12 = 12;
            obj.A = i12;
            return i12;
        }
        obj.z.readByte();
        int i15 = 13;
        obj.A = i15;
        return i15;
    }

    private int g0(String string, com.squareup.moshi.i.a i$a2) {
        int i;
        boolean equals;
        final int i4 = 0;
        i = i4;
        while (i < strArr.length) {
            i++;
        }
        return -1;
    }

    private int j0(String string, com.squareup.moshi.i.a i$a2) {
        int i;
        boolean equals;
        final int i4 = 0;
        i = i4;
        while (i < strArr.length) {
            i++;
        }
        return -1;
    }

    private boolean l0(int i) {
        int i2;
        if (i != 9 && i != 10 && i != 12 && i != 13 && i != 32) {
            if (i != 10) {
                if (i != 12) {
                    if (i != 13) {
                        if (i != 32) {
                            if (i != 35) {
                                if (i != 44) {
                                    if (i != 47 && i != 61) {
                                        if (i != 61) {
                                            if (i != 123 && i != 125 && i != 58 && i != 59) {
                                                if (i != 125) {
                                                    if (i != 58) {
                                                        if (i != 59) {
                                                            switch (i) {
                                                                case 91:
                                                                    return 0;
                                                                case 92:
                                                                    Y();
                                                                    return 0;
                                                                default:
                                                                    return 1;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                }
                            } else {
                            }
                        }
                    }
                }
            }
        }
    }

    private int t0(boolean z) {
        f fVar;
        int i;
        int i3;
        byte b;
        int i2;
        while (/* condition */) {
            b = i + 1;
            while (this.y.request((long)b)) {
                i2 = (long)i;
                fVar = this.z.n(i2);
                i = b;
                b = i + 1;
            }
            i2 = (long)i;
            fVar = this.z.n(i2);
            i = b;
            this.z.skip((long)i5);
            i3 = 47;
            if (fVar == 35) {
            }
            Y();
            L0();
            i = i4;
            Y();
            b = this.z.n(1);
            this.z.readByte();
            this.z.readByte();
            this.z.readByte();
            this.z.readByte();
            L0();
        }
        if (z) {
        } else {
            return -1;
        }
        EOFException obj7 = new EOFException("End of input");
        throw obj7;
    }

    private String v0(i i) {
        int stringBuilder;
        char c;
        f fVar;
        int i2;
        int i3 = 0;
        stringBuilder = i3;
        long l = this.y.n0(i);
        while (Long.compare(l, i4) != 0) {
            if (stringBuilder == null) {
            }
            stringBuilder.append(this.z.L(l));
            this.z.readByte();
            stringBuilder.append(G0());
            l = this.y.n0(i);
            stringBuilder = new StringBuilder();
        }
        V("Unterminated string");
        throw i3;
    }

    private String z0() {
        String str;
        f cmp;
        final i iVar = k.H;
        long l = this.y.n0(iVar);
        if (Long.compare(l, i) != 0) {
            str = this.z.L(l);
        } else {
            str = this.z.r1();
        }
        return str;
    }

    @Override // com.squareup.moshi.i
    public com.squareup.moshi.i.b E() {
        int i;
        if (this.A == 0) {
            i = e0();
        }
        switch (i) {
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
                AssertionError assertionError = new AssertionError();
                throw assertionError;
        }
    }

    @Override // com.squareup.moshi.i
    public void F() {
        boolean z;
        if (j()) {
            this.D = m0();
            this.A = 11;
        }
    }

    @Override // com.squareup.moshi.i
    public int J(com.squareup.moshi.i.a i$a) {
        int i;
        int i3;
        int i2;
        if (this.A == 0) {
            i = e0();
        }
        i2 = -1;
        if (i >= 12) {
            i3 = 15;
            if (i > i3) {
            } else {
                if (i == i3) {
                    return g0(this.D, a);
                }
                int i4 = this.y.i2(a.b);
                if (i4 != i2) {
                    this.A = 0;
                    this.c[i7--] = a.a[i4];
                    return i4;
                }
                String str3 = m0();
                int obj5 = g0(str3, a);
                if (obj5 == i2) {
                    this.A = i3;
                    this.D = str3;
                    this.c[i6--] = this.c[i9--];
                }
            }
            return obj5;
        }
        return i2;
    }

    @Override // com.squareup.moshi.i
    public int K(com.squareup.moshi.i.a i$a) {
        int i;
        String str;
        int i3;
        int i2;
        if (this.A == 0) {
            i = e0();
        }
        i2 = -1;
        if (i >= 8) {
            i3 = 11;
            if (i > i3) {
            } else {
                if (i == i3) {
                    return j0(this.D, a);
                }
                int i4 = this.y.i2(a.b);
                if (i4 != i2) {
                    this.A = 0;
                    int[] obj5 = this.v;
                    i6--;
                    obj5[i7] = i9++;
                    return i4;
                }
                str = w();
                obj5 = j0(str, a);
                if (obj5 == i2) {
                    this.A = i3;
                    this.D = str;
                    str = this.v;
                    i5--;
                    str[i3] = i8--;
                }
            }
            return obj5;
        }
        return i2;
    }

    @Override // com.squareup.moshi.i
    public void T() {
        int i2;
        int i;
        if (this.x) {
        } else {
            if (this.A == 0) {
                i2 = e0();
            }
            if (i2 == 14) {
                N0();
                this.A = 0;
                this.c[i4--] = "null";
            } else {
                if (i2 == 13) {
                    I0(k.G);
                } else {
                    if (i2 == 12) {
                        I0(k.F);
                    } else {
                        if (i2 != 15) {
                        } else {
                        }
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected a name but was ");
            stringBuilder.append(E());
            stringBuilder.append(" at path ");
            stringBuilder.append(getPath());
            JsonDataException jsonDataException = new JsonDataException(stringBuilder.toString());
            throw jsonDataException;
        }
        m0();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Cannot skip unexpected ");
        stringBuilder2.append(E());
        stringBuilder2.append(" at ");
        stringBuilder2.append(getPath());
        JsonDataException jsonDataException2 = new JsonDataException(stringBuilder2.toString());
        throw jsonDataException2;
    }

    @Override // com.squareup.moshi.i
    public void U() {
        int i4;
        int i;
        int i3;
        int i2;
        String str;
        String str2;
        if (this.x) {
        } else {
            int i5 = 0;
            i4 = i5;
            while (this.A == 0) {
                i = e0();
                i3 = 3;
                i2 = 1;
                str = " at path ";
                str2 = "Expected a value but was ";
                N0();
                this.A = i5;
                I0(k.G);
                I0(k.F);
                this.z.skip((long)i3);
                this.a = i10 -= i2;
                this.a = i9 -= i2;
                H(i3);
                i4++;
                H(i2);
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str2);
            stringBuilder2.append(E());
            stringBuilder2.append(str);
            stringBuilder2.append(getPath());
            JsonDataException jsonDataException2 = new JsonDataException(stringBuilder2.toString());
            throw jsonDataException2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot skip unexpected ");
        stringBuilder.append(E());
        stringBuilder.append(" at ");
        stringBuilder.append(getPath());
        JsonDataException jsonDataException = new JsonDataException(stringBuilder.toString());
        throw jsonDataException;
    }

    @Override // com.squareup.moshi.i
    public void a() {
        int i;
        if (this.A == 0) {
            i = e0();
        }
        if (i != 3) {
        } else {
            int i2 = 1;
            H(i2);
            int i3 = 0;
            this.v[i5 -= i2] = i3;
            this.A = i3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_ARRAY but was ");
        stringBuilder.append(E());
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        JsonDataException jsonDataException = new JsonDataException(stringBuilder.toString());
        throw jsonDataException;
    }

    @Override // com.squareup.moshi.i
    public void c() {
        int i;
        if (this.A == 0) {
            i = e0();
        }
        if (i != 1) {
        } else {
            H(3);
            this.A = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_OBJECT but was ");
        stringBuilder.append(E());
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        JsonDataException jsonDataException = new JsonDataException(stringBuilder.toString());
        throw jsonDataException;
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
    public void e() {
        int i;
        if (this.A == 0) {
            i = e0();
        }
        if (i != 4) {
        } else {
            i2--;
            this.a = i3;
            int[] iArr = this.v;
            i3--;
            iArr[i4] = i7++;
            this.A = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_ARRAY but was ");
        stringBuilder.append(E());
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        JsonDataException jsonDataException = new JsonDataException(stringBuilder.toString());
        throw jsonDataException;
    }

    @Override // com.squareup.moshi.i
    public void f() {
        int i;
        if (this.A == 0) {
            i = e0();
        }
        if (i != 2) {
        } else {
            i2--;
            this.a = i3;
            this.c[i3] = 0;
            int[] iArr = this.v;
            i3--;
            iArr[i4] = i8++;
            this.A = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_OBJECT but was ");
        stringBuilder.append(E());
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        JsonDataException jsonDataException = new JsonDataException(stringBuilder.toString());
        throw jsonDataException;
    }

    @Override // com.squareup.moshi.i
    public boolean j() {
        int i;
        int i3;
        int i2;
        if (this.A == 0) {
            i = e0();
        }
        if (i != 2 && i != 4 && i != 18) {
            if (i != 4) {
                i3 = i != 18 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i3;
    }

    @Override // com.squareup.moshi.i
    public boolean m() {
        int i;
        if (this.A == 0) {
            i = e0();
        }
        int i8 = 0;
        final int i11 = 1;
        if (i == 5) {
            this.A = i8;
            int[] iArr = this.v;
            i3 -= i11;
            iArr[i4] = i9 += i11;
            return i11;
        }
        if (i != 6) {
        } else {
            this.A = i8;
            int[] iArr2 = this.v;
            i6 -= i11;
            iArr2[i7] = i12 += i11;
            return i8;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a boolean but was ");
        stringBuilder.append(E());
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        JsonDataException jsonDataException = new JsonDataException(stringBuilder.toString());
        throw jsonDataException;
    }

    @Override // com.squareup.moshi.i
    public String m0() {
        int i2;
        String str;
        int i;
        if (this.A == 0) {
            i2 = e0();
        }
        if (i2 == 14) {
            str = z0();
            this.A = 0;
            this.c[i5--] = str;
            return str;
        } else {
            if (i2 == 13) {
                str = v0(k.G);
            } else {
                if (i2 == 12) {
                    str = v0(k.F);
                } else {
                    if (i2 != 15) {
                    } else {
                        str = this.D;
                        this.D = 0;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a name but was ");
        stringBuilder.append(E());
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        JsonDataException jsonDataException = new JsonDataException(stringBuilder.toString());
        throw jsonDataException;
    }

    @Override // com.squareup.moshi.i
    public double n() {
        int i;
        int i2;
        boolean naN;
        long l;
        if (this.A == 0) {
            i = e0();
        }
        int i7 = 0;
        if (i == 16) {
            this.A = i7;
            int[] iArr = this.v;
            i4--;
            iArr[i5] = i8++;
            return (double)l2;
        }
        int i13 = 11;
        final String str4 = " at path ";
        if (i == 17) {
            this.D = this.z.L((long)i2);
            this.A = i13;
            double double = Double.parseDouble(this.D);
            if (!this.w) {
                if (Double.isNaN(double)) {
                } else {
                    if (Double.isInfinite(double)) {
                    } else {
                    }
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("JSON forbids NaN and infinities: ");
                stringBuilder2.append(double);
                stringBuilder2.append(str4);
                stringBuilder2.append(getPath());
                JsonEncodingException jsonEncodingException = new JsonEncodingException(stringBuilder2.toString());
                throw jsonEncodingException;
            }
            this.D = 0;
            this.A = i7;
            int[] iArr2 = this.v;
            i11--;
            iArr2[i12] = i14++;
            return double;
        } else {
            if (i == 9) {
                this.D = v0(k.G);
            } else {
                if (i == 8) {
                    this.D = v0(k.F);
                } else {
                    if (i == 10) {
                        this.D = z0();
                    } else {
                        if (i != i13) {
                        } else {
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a double but was ");
        stringBuilder.append(E());
        stringBuilder.append(str4);
        stringBuilder.append(getPath());
        JsonDataException jsonDataException2 = new JsonDataException(stringBuilder.toString());
        throw jsonDataException2;
    }

    @Override // com.squareup.moshi.i
    public int o() {
        int i;
        String str;
        int i2;
        long l;
        if (this.A == 0) {
            i = e0();
        }
        int i10 = 0;
        final String str4 = " at path ";
        String str5 = "Expected an int but was ";
        if (i == 16) {
            long l2 = this.B;
            int i15 = (int)l2;
            if (Long.compare(l2, l4) != 0) {
            } else {
                this.A = i10;
                int[] iArr = this.v;
                i5--;
                iArr[i6] = i11++;
                return i15;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str5);
            stringBuilder.append(this.B);
            stringBuilder.append(str4);
            stringBuilder.append(getPath());
            JsonDataException jsonDataException2 = new JsonDataException(stringBuilder.toString());
            throw jsonDataException2;
        }
        int i16 = 11;
        if (i == 17) {
            this.D = this.z.L((long)i2);
            this.A = i16;
            double double = Double.parseDouble(this.D);
            int i17 = (int)double;
            if (Double.compare(d, double) != 0) {
            } else {
                this.D = 0;
                this.A = i10;
                int[] iArr2 = this.v;
                i8--;
                iArr2[i9] = i13++;
                return i17;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str5);
            stringBuilder2.append(this.D);
            stringBuilder2.append(str4);
            stringBuilder2.append(getPath());
            JsonDataException jsonDataException3 = new JsonDataException(stringBuilder2.toString());
            throw jsonDataException3;
        } else {
            i2 = 9;
            if (i != i2) {
                if (i == 8) {
                } else {
                    if (i != i16) {
                    } else {
                    }
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str5);
                stringBuilder3.append(E());
                stringBuilder3.append(str4);
                stringBuilder3.append(getPath());
                JsonDataException jsonDataException4 = new JsonDataException(stringBuilder3.toString());
                throw jsonDataException4;
            }
            if (i == i2) {
                str = v0(k.G);
            } else {
                str = v0(k.F);
            }
        }
        this.D = str;
        this.A = i10;
        int[] iArr3 = this.v;
        i18--;
        iArr3[i19] = i20++;
        return Integer.parseInt(str);
    }

    @Override // com.squareup.moshi.i
    public long q() {
        int i;
        String str;
        int i2;
        int i3;
        if (this.A == 0) {
            i = e0();
        }
        int i8 = 0;
        if (i == 16) {
            this.A = i8;
            int[] iArr = this.v;
            i5--;
            iArr[i6] = i9++;
            return this.B;
        }
        final int i16 = 11;
        if (i == 17) {
            this.D = this.z.L((long)i2);
            this.A = i16;
            BigDecimal bigDecimal = new BigDecimal(this.D);
            this.D = 0;
            this.A = i8;
            int[] iArr2 = this.v;
            i12--;
            iArr2[i13] = i14++;
            return bigDecimal.longValueExact();
        } else {
            i2 = 9;
            if (i != i2) {
                if (i == 8) {
                } else {
                    if (i != i16) {
                    } else {
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected a long but was ");
                stringBuilder.append(E());
                stringBuilder.append(" at path ");
                stringBuilder.append(getPath());
                JsonDataException jsonDataException2 = new JsonDataException(stringBuilder.toString());
                throw jsonDataException2;
            }
            if (i == i2) {
                str = v0(k.G);
            } else {
                str = v0(k.F);
            }
        }
        this.D = str;
        this.A = i8;
        int[] iArr3 = this.v;
        i17--;
        iArr3[i18] = i19++;
        return Long.parseLong(str);
    }

    public <T> T r() {
        int i;
        if (this.A == 0) {
            i = e0();
        }
        if (i != 7) {
        } else {
            this.A = 0;
            int[] iArr = this.v;
            i5--;
            iArr[i6] = i7++;
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected null but was ");
        stringBuilder.append(E());
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        JsonDataException jsonDataException = new JsonDataException(stringBuilder.toString());
        throw jsonDataException;
    }

    @Override // com.squareup.moshi.i
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JsonReader(");
        stringBuilder.append(this.y);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override // com.squareup.moshi.i
    public String w() {
        int i;
        String string;
        int i2;
        if (this.A == 0) {
            i = e0();
        }
        if (i == 10) {
            string = z0();
            this.A = 0;
            int[] iArr = this.v;
            i7--;
            iArr[i8] = i9++;
            return string;
        } else {
            if (i == 9) {
                string = v0(k.G);
            } else {
                if (i == 8) {
                    string = v0(k.F);
                } else {
                    if (i == 11) {
                        string = this.D;
                        this.D = 0;
                    } else {
                        i2 = 16;
                        if (i == i2) {
                            string = Long.toString(this.B);
                        } else {
                            if (i != 17) {
                            } else {
                                string = this.z.L((long)i6);
                            }
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a string but was ");
        stringBuilder.append(E());
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        JsonDataException jsonDataException = new JsonDataException(stringBuilder.toString());
        throw jsonDataException;
    }
}
