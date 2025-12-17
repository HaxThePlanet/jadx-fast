package com.airbnb.lottie.x.k0;

import java.io.EOFException;
import java.util.Objects;
import l.d0;
import l.f;
import l.h;
import l.i;

/* loaded from: classes.dex */
final class e extends com.airbnb.lottie.x.k0.c {

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

    e(h h) {
        super();
        int i = 0;
        Objects.requireNonNull(h, "source == null");
        this.z = h;
        this.A = h.A();
        x(6);
    }

    private void L() {
        if (!this.w) {
        } else {
        }
        K("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw 0;
    }

    private int M() {
        int request;
        int i6;
        int i3;
        f i2;
        int i7;
        int i5;
        int i4;
        int i;
        final Object obj = this;
        request = obj.b;
        i2 = obj.a;
        int i25 = request[i2 + -1];
        int i26 = 0;
        final int i28 = 8;
        final int i30 = 34;
        final int i31 = 93;
        final int i32 = 3;
        final int i33 = 7;
        final int i34 = 59;
        final int i35 = 44;
        i4 = 4;
        i = 2;
        final int i36 = 0;
        final int i29 = 1;
        if (i25 == i29) {
            request[i2 -= i29] = i;
            i6 = obj.V(i29);
            int i18 = g0();
            if (i6 != i30 && i6 != 39 && i6 != i35 && i6 != i34 && i6 != 91 && i6 != i31 && i6 != 123 && i18 != 0) {
                if (i6 != 39) {
                    if (i6 != i35) {
                        if (i6 != i34) {
                            if (i6 != 91) {
                                if (i6 != i31) {
                                    if (i6 != 123) {
                                        i18 = g0();
                                        if (i18 != 0) {
                                            return i18;
                                        }
                                        int i19 = j0();
                                        if (i19 != 0) {
                                            return i19;
                                        }
                                        if (!obj.U(obj.A.n(i26))) {
                                        } else {
                                            L();
                                            int i20 = 10;
                                            obj.B = i20;
                                            return i20;
                                        }
                                        obj.K("Expected value");
                                        throw i36;
                                    }
                                    obj.A.readByte();
                                    obj.B = i29;
                                    return i29;
                                }
                                if (i25 == i29) {
                                    obj.A.readByte();
                                    int i17 = 4;
                                    obj.B = i17;
                                    return i17;
                                }
                            }
                            obj.A.readByte();
                            obj.B = i32;
                            return i32;
                        }
                    }
                    if (i25 != i29) {
                        if (i25 != 2) {
                        } else {
                        }
                        obj.K("Unexpected value");
                        throw i36;
                    }
                    L();
                    obj.B = i33;
                    return i33;
                }
                L();
                obj.A.readByte();
                obj.B = i28;
                return i28;
            }
            obj.A.readByte();
            int i16 = 9;
            obj.B = i16;
            return i16;
        } else {
            if (i25 == i) {
                request = obj.V(i29);
                obj.A.readByte();
                if (request != i35 && request != i34) {
                    if (request != i34) {
                        if (request != i31) {
                        } else {
                            obj.B = i4;
                            return i4;
                        }
                        obj.K("Unterminated array");
                        throw i36;
                    }
                    L();
                }
            } else {
                i = 5;
                if (i25 != i32) {
                    if (i25 == i) {
                    } else {
                        if (i25 == i4) {
                            request[i2 -= i29] = i;
                            request = obj.V(i29);
                            obj.A.readByte();
                            if (request != 58) {
                                if (request != 61) {
                                } else {
                                    L();
                                    if (obj.z.request(1) && obj.A.n(i26) == 62) {
                                        if (obj.A.n(i26) == 62) {
                                            obj.A.readByte();
                                        }
                                    }
                                }
                                obj.K("Expected ':'");
                                throw i36;
                            }
                        } else {
                            if (i25 == 6) {
                                request[i2 -= i29] = i33;
                            } else {
                                if (i25 == i33) {
                                    if (obj.V(false) == -1) {
                                        int i9 = 18;
                                        obj.B = i9;
                                        return i9;
                                    }
                                    L();
                                } else {
                                    if (i25 == i28) {
                                    } else {
                                    }
                                }
                            }
                        }
                    }
                    IllegalStateException illegalStateException = new IllegalStateException("JsonReader is closed");
                    throw illegalStateException;
                }
            }
        }
        request[i2 -= i29] = 4;
        int i10 = 125;
        i3 = obj.V(i29);
        obj.A.readByte();
        if (i25 == i && i3 != i35 && i3 != i34) {
            i3 = obj.V(i29);
            obj.A.readByte();
            if (i3 != i35) {
                if (i3 != i34) {
                    if (i3 != i10) {
                    } else {
                        int i11 = 2;
                        obj.B = i11;
                        return i11;
                    }
                    obj.K("Unterminated object");
                    throw i36;
                }
                L();
            }
        }
        int i22 = obj.V(i29);
        String str7 = "Expected name";
        if (i22 != i30 && i22 != 39 && i22 != i10) {
            if (i22 != 39) {
                str7 = "Expected name";
                if (i22 != i10) {
                    L();
                    if (!obj.U((char)i22)) {
                    } else {
                        int i14 = 14;
                        obj.B = i14;
                        return i14;
                    }
                    obj.K(str7);
                    throw i36;
                }
                if (i25 == i) {
                } else {
                    obj.A.readByte();
                    int i15 = 2;
                    obj.B = i15;
                    return i15;
                }
                obj.K(str7);
                throw i36;
            }
            obj.A.readByte();
            L();
            int i13 = 12;
            obj.B = i13;
            return i13;
        }
        obj.A.readByte();
        int i12 = 13;
        obj.B = i12;
        return i12;
    }

    private int T(String string, com.airbnb.lottie.x.k0.c.a c$a2) {
        int i;
        boolean equals;
        final int i4 = 0;
        i = i4;
        while (i < strArr.length) {
            i++;
        }
        return -1;
    }

    private boolean U(int i) {
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
                                                                    L();
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

    private int V(boolean z) {
        f fVar;
        int i3;
        int i2;
        byte b;
        int i;
        while (/* condition */) {
            b = i3 + 1;
            while (this.z.request((long)b)) {
                i = (long)i3;
                fVar = this.A.n(i);
                i3 = b;
                b = i3 + 1;
            }
            i = (long)i3;
            fVar = this.A.n(i);
            i3 = b;
            this.A.skip((long)i5);
            i2 = 47;
            if (fVar == 35) {
            }
            L();
            v0();
            i3 = i4;
            L();
            b = this.A.n(1);
            this.A.readByte();
            this.A.readByte();
            this.A.readByte();
            this.A.readByte();
            v0();
        }
        if (z) {
        } else {
            return -1;
        }
        EOFException obj7 = new EOFException("End of input");
        throw obj7;
    }

    private String Y(i i) {
        int stringBuilder;
        char c;
        f fVar;
        int i2;
        int i3 = 0;
        stringBuilder = i3;
        long l = this.z.n0(i);
        while (Long.compare(l, i4) != 0) {
            if (stringBuilder == null) {
            }
            stringBuilder.append(this.A.L(l));
            this.A.readByte();
            stringBuilder.append(l0());
            l = this.z.n0(i);
            stringBuilder = new StringBuilder();
        }
        K("Unterminated string");
        throw i3;
    }

    private String e0() {
        String str;
        f cmp;
        final i iVar = e.H;
        long l = this.z.n0(iVar);
        if (Long.compare(l, i) != 0) {
            str = this.A.L(l);
        } else {
            str = this.A.r1();
        }
        return str;
    }

    private int g0() {
        int i3;
        int i;
        int i2;
        int i4;
        String str;
        boolean request;
        String str2;
        int charAt2;
        long l;
        byte b;
        int i5;
        char charAt;
        byte b2 = this.A.n(0);
        int i7 = 0;
        if (b2 != 116) {
            if (b2 == 84) {
                i3 = 5;
                str = "true";
                str2 = "TRUE";
            } else {
                if (b2 != 102) {
                    if (b2 == 70) {
                        i3 = 6;
                        str = "false";
                        str2 = "FALSE";
                    } else {
                        if (b2 != 110 && b2 == 78) {
                            if (b2 == 78) {
                            }
                            return i7;
                        }
                        i3 = 7;
                        str = "null";
                        str2 = "NULL";
                    }
                } else {
                }
            }
        } else {
        }
        final int length = str.length();
        charAt2 = 1;
        while (charAt2 < length) {
            i5 = charAt2 + 1;
            b = this.A.n((long)charAt2);
            charAt2 = i5;
        }
        int i8 = length + 1;
        if (this.z.request((long)i8) && U(this.A.n((long)length))) {
            if (U(this.A.n((long)length))) {
                return i7;
            }
        }
        this.A.skip((long)length);
        this.B = i3;
        return i3;
    }

    private int j0() {
        int cmp4;
        int cmp;
        int cmp2;
        int i7;
        int cmp3;
        int i;
        int i4;
        int i5;
        int i6;
        byte request;
        int i2;
        int i8;
        int i9;
        int i3;
        final Object obj = this;
        cmp4 = 0;
        i5 = cmp4;
        i4 = cmp;
        i6 = i;
        i2 = cmp3 + 1;
        i3 = 2;
        while (!obj.z.request((long)i2)) {
            request = obj.A.n((long)cmp3);
            i9 = 5;
            cmp = 6;
            i = cmp;
            cmp3 = i2;
            cmp = 1;
            i2 = cmp3 + 1;
            i3 = 2;
            i = i9;
            cmp = 6;
            i = 1;
            i6 = 1;
            cmp = 3;
            i5 = (long)cmp;
            i = i3;
            i7 = 0;
            if (i == 3) {
            } else {
            }
            if (i != i9) {
            } else {
            }
            i7 = 0;
            i = 7;
            if (i == 6) {
            } else {
            }
            i7 = 0;
            i = 4;
            i15 -= l2;
            cmp2 = Long.compare(i5, l3);
            if (cmp2 <= 0) {
            } else {
            }
            cmp = 1;
            i4 &= cmp;
            i5 = i8;
            if (cmp2 == 0 && Long.compare(i8, i5) < 0) {
            } else {
            }
            cmp = 0;
            if (Long.compare(i8, i5) < 0) {
            } else {
            }
        }
        if (i == i3) {
            if (i4 != 0) {
                cmp = Long.compare(i5, l4);
                if (cmp == 0) {
                    if (i6 != 0) {
                        if (Long.compare(i5, cmp4) == 0) {
                            if (i6 == 0) {
                                if (i6 != 0) {
                                } else {
                                    i5 = -i5;
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
                obj.C = i5;
                obj.A.skip((long)cmp3);
                int i11 = 16;
                obj.B = i11;
                return i11;
            }
        }
        if (i != i3 && i != 4 && i == 7) {
            if (i != 4) {
                if (i == 7) {
                }
                return 0;
            }
        }
        obj.D = cmp3;
        int i10 = 17;
        obj.B = i10;
        return i10;
    }

    private char l0() {
        int i;
        int i5;
        int i4;
        int i6;
        int i2;
        int i3;
        int i12 = 0;
        if (!this.z.request(1)) {
        } else {
            byte byte = this.A.readByte();
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
                                                        K(stringBuilder3.toString());
                                                        throw i12;
                                                    }
                                                    int i20 = 4;
                                                    if (!this.z.request(i20)) {
                                                    } else {
                                                        i4 = i;
                                                        while (i < 4) {
                                                            byte b = this.A.n((long)i);
                                                            b += -65;
                                                            i2 += i13;
                                                            i4 = (char)i22;
                                                            i++;
                                                            b += -97;
                                                            b += -48;
                                                        }
                                                        this.A.skip(i20);
                                                        return i4;
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
        K("Unterminated escape sequence");
        throw i12;
    }

    private void m0(i i) {
        long l = this.z.n0(i);
        while (Long.compare(l, i4) != 0) {
            final int i6 = 1;
            this.A.skip(l += i6);
            l0();
            l = this.z.n0(i);
        }
        K("Unterminated string");
        throw 0;
    }

    private boolean t0() {
        int i;
        i iVar;
        long size;
        long l;
        iVar = e.J;
        long l2 = this.z.a0(iVar);
        i = Long.compare(l2, i2) != 0 ? 1 : 0;
        f fVar = this.A;
        if (i != 0) {
            l2 += l;
        } else {
            size = fVar.size();
        }
        fVar.skip(size);
        return i;
    }

    private void v0() {
        int size;
        int cmp;
        final i iVar = e.I;
        long l = this.z.n0(iVar);
        final f fVar = this.A;
        if (Long.compare(l, i) != 0) {
            l += cmp;
        } else {
            size = fVar.size();
        }
        fVar.skip(size);
    }

    private void z0() {
        long size;
        final i iVar = e.H;
        final f fVar = this.A;
        if (Long.compare(size, i) != 0) {
        } else {
            size = fVar.size();
        }
        fVar.skip(size);
    }

    @Override // com.airbnb.lottie.x.k0.c
    public int E(com.airbnb.lottie.x.k0.c.a c$a) {
        int i3;
        int i2;
        int i;
        if (this.B == 0) {
            i3 = M();
        }
        i = -1;
        if (i3 >= 12) {
            i2 = 15;
            if (i3 > i2) {
            } else {
                if (i3 == i2) {
                    return T(this.E, a);
                }
                int i4 = this.z.i2(a.b);
                if (i4 != i) {
                    this.B = 0;
                    this.c[i7--] = a.a[i4];
                    return i4;
                }
                String str3 = o();
                int obj5 = T(str3, a);
                if (obj5 == i) {
                    this.B = i2;
                    this.E = str3;
                    this.c[i6--] = this.c[i9--];
                }
            }
            return obj5;
        }
        return i;
    }

    @Override // com.airbnb.lottie.x.k0.c
    public void F() {
        int i2;
        int i;
        if (this.x) {
        } else {
            if (this.B == 0) {
                i2 = M();
            }
            if (i2 == 14) {
                z0();
                this.B = 0;
                this.c[i4--] = "null";
            } else {
                if (i2 == 13) {
                    m0(e.G);
                } else {
                    if (i2 == 12) {
                        m0(e.F);
                    } else {
                        if (i2 != 15) {
                        } else {
                        }
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Expected a name but was ");
            stringBuilder.append(w());
            stringBuilder.append(" at path ");
            stringBuilder.append(getPath());
            a aVar = new a(stringBuilder.toString());
            throw aVar;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Cannot skip unexpected ");
        stringBuilder2.append(w());
        stringBuilder2.append(" at ");
        stringBuilder2.append(getPath());
        a aVar2 = new a(stringBuilder2.toString());
        throw aVar2;
    }

    @Override // com.airbnb.lottie.x.k0.c
    public void H() {
        int i;
        int i4;
        int i3;
        int i2;
        String str;
        String str2;
        if (this.x) {
        } else {
            int i5 = 0;
            i = i5;
            while (this.B == 0) {
                i4 = M();
                i3 = 3;
                i2 = 1;
                str = " at path ";
                str2 = "Expected a value but was ";
                z0();
                this.B = i5;
                m0(e.G);
                m0(e.F);
                this.A.skip((long)i3);
                this.a = i10 -= i2;
                this.a = i9 -= i2;
                x(i3);
                i++;
                x(i2);
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str2);
            stringBuilder2.append(w());
            stringBuilder2.append(str);
            stringBuilder2.append(getPath());
            a aVar2 = new a(stringBuilder2.toString());
            throw aVar2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot skip unexpected ");
        stringBuilder.append(w());
        stringBuilder.append(" at ");
        stringBuilder.append(getPath());
        a aVar = new a(stringBuilder.toString());
        throw aVar;
    }

    @Override // com.airbnb.lottie.x.k0.c
    public void c() {
        int i;
        if (this.B == 0) {
            i = M();
        }
        if (i != 3) {
        } else {
            int i2 = 1;
            x(i2);
            int i3 = 0;
            this.v[i5 -= i2] = i3;
            this.B = i3;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_ARRAY but was ");
        stringBuilder.append(w());
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        a aVar = new a(stringBuilder.toString());
        throw aVar;
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
    public void e() {
        int i;
        if (this.B == 0) {
            i = M();
        }
        if (i != 1) {
        } else {
            x(3);
            this.B = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_OBJECT but was ");
        stringBuilder.append(w());
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        a aVar = new a(stringBuilder.toString());
        throw aVar;
    }

    @Override // com.airbnb.lottie.x.k0.c
    public void f() {
        int i;
        if (this.B == 0) {
            i = M();
        }
        if (i != 4) {
        } else {
            i2--;
            this.a = i3;
            int[] iArr = this.v;
            i3--;
            iArr[i4] = i7++;
            this.B = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_ARRAY but was ");
        stringBuilder.append(w());
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        a aVar = new a(stringBuilder.toString());
        throw aVar;
    }

    @Override // com.airbnb.lottie.x.k0.c
    public void i() {
        int i;
        if (this.B == 0) {
            i = M();
        }
        if (i != 2) {
        } else {
            i2--;
            this.a = i3;
            this.c[i3] = 0;
            int[] iArr = this.v;
            i3--;
            iArr[i4] = i8++;
            this.B = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_OBJECT but was ");
        stringBuilder.append(w());
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        a aVar = new a(stringBuilder.toString());
        throw aVar;
    }

    @Override // com.airbnb.lottie.x.k0.c
    public boolean j() {
        int i2;
        int i;
        int i3;
        if (this.B == 0) {
            i2 = M();
        }
        if (i2 != 2 && i2 != 4 && i2 != 18) {
            if (i2 != 4) {
                i = i2 != 18 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // com.airbnb.lottie.x.k0.c
    public boolean k() {
        int i;
        if (this.B == 0) {
            i = M();
        }
        int i8 = 0;
        final int i11 = 1;
        if (i == 5) {
            this.B = i8;
            int[] iArr = this.v;
            i3 -= i11;
            iArr[i4] = i9 += i11;
            return i11;
        }
        if (i != 6) {
        } else {
            this.B = i8;
            int[] iArr2 = this.v;
            i6 -= i11;
            iArr2[i7] = i12 += i11;
            return i8;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a boolean but was ");
        stringBuilder.append(w());
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        a aVar = new a(stringBuilder.toString());
        throw aVar;
    }

    @Override // com.airbnb.lottie.x.k0.c
    public double m() {
        int i2;
        int i;
        boolean naN;
        long l;
        if (this.B == 0) {
            i2 = M();
        }
        int i7 = 0;
        if (i2 == 16) {
            this.B = i7;
            int[] iArr = this.v;
            i4--;
            iArr[i5] = i8++;
            return (double)l2;
        }
        int i13 = 11;
        final String str4 = " at path ";
        if (i2 == 17) {
            this.E = this.A.L((long)i);
            this.B = i13;
            double double = Double.parseDouble(this.E);
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
                b bVar2 = new b(stringBuilder2.toString());
                throw bVar2;
            }
            this.E = 0;
            this.B = i7;
            int[] iArr2 = this.v;
            i11--;
            iArr2[i12] = i14++;
            return double;
        } else {
            if (i2 == 9) {
                this.E = Y(e.G);
            } else {
                if (i2 == 8) {
                    this.E = Y(e.F);
                } else {
                    if (i2 == 10) {
                        this.E = e0();
                    } else {
                        if (i2 != i13) {
                        } else {
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a double but was ");
        stringBuilder.append(w());
        stringBuilder.append(str4);
        stringBuilder.append(getPath());
        a aVar2 = new a(stringBuilder.toString());
        throw aVar2;
    }

    @Override // com.airbnb.lottie.x.k0.c
    public int n() {
        int i2;
        String str;
        int i;
        long l;
        if (this.B == 0) {
            i2 = M();
        }
        int i10 = 0;
        final String str4 = " at path ";
        String str5 = "Expected an int but was ";
        if (i2 == 16) {
            long l2 = this.C;
            int i15 = (int)l2;
            if (Long.compare(l2, l4) != 0) {
            } else {
                this.B = i10;
                int[] iArr = this.v;
                i5--;
                iArr[i6] = i11++;
                return i15;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str5);
            stringBuilder.append(this.C);
            stringBuilder.append(str4);
            stringBuilder.append(getPath());
            a aVar2 = new a(stringBuilder.toString());
            throw aVar2;
        }
        int i16 = 11;
        if (i2 == 17) {
            this.E = this.A.L((long)i);
            this.B = i16;
            double double = Double.parseDouble(this.E);
            int i17 = (int)double;
            if (Double.compare(d, double) != 0) {
            } else {
                this.E = 0;
                this.B = i10;
                int[] iArr2 = this.v;
                i8--;
                iArr2[i9] = i13++;
                return i17;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str5);
            stringBuilder2.append(this.E);
            stringBuilder2.append(str4);
            stringBuilder2.append(getPath());
            a aVar3 = new a(stringBuilder2.toString());
            throw aVar3;
        } else {
            i = 9;
            if (i2 != i) {
                if (i2 == 8) {
                } else {
                    if (i2 != i16) {
                    } else {
                    }
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(str5);
                stringBuilder3.append(w());
                stringBuilder3.append(str4);
                stringBuilder3.append(getPath());
                a aVar4 = new a(stringBuilder3.toString());
                throw aVar4;
            }
            if (i2 == i) {
                str = Y(e.G);
            } else {
                str = Y(e.F);
            }
        }
        this.E = str;
        this.B = i10;
        int[] iArr3 = this.v;
        i18--;
        iArr3[i19] = i20++;
        return Integer.parseInt(str);
    }

    @Override // com.airbnb.lottie.x.k0.c
    public String o() {
        int i2;
        String str;
        int i;
        if (this.B == 0) {
            i2 = M();
        }
        if (i2 == 14) {
            str = e0();
            this.B = 0;
            this.c[i4--] = str;
            return str;
        } else {
            if (i2 == 13) {
                str = Y(e.G);
            } else {
                if (i2 == 12) {
                    str = Y(e.F);
                } else {
                    if (i2 != 15) {
                    } else {
                        str = this.E;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a name but was ");
        stringBuilder.append(w());
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        a aVar = new a(stringBuilder.toString());
        throw aVar;
    }

    @Override // com.airbnb.lottie.x.k0.c
    public String q() {
        int i2;
        String string;
        int i;
        if (this.B == 0) {
            i2 = M();
        }
        if (i2 == 10) {
            string = e0();
            this.B = 0;
            int[] iArr = this.v;
            i7--;
            iArr[i8] = i9++;
            return string;
        } else {
            if (i2 == 9) {
                string = Y(e.G);
            } else {
                if (i2 == 8) {
                    string = Y(e.F);
                } else {
                    if (i2 == 11) {
                        string = this.E;
                        this.E = 0;
                    } else {
                        i = 16;
                        if (i2 == i) {
                            string = Long.toString(this.C);
                        } else {
                            if (i2 != 17) {
                            } else {
                                string = this.A.L((long)i6);
                            }
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a string but was ");
        stringBuilder.append(w());
        stringBuilder.append(" at path ");
        stringBuilder.append(getPath());
        a aVar = new a(stringBuilder.toString());
        throw aVar;
    }

    @Override // com.airbnb.lottie.x.k0.c
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("JsonReader(");
        stringBuilder.append(this.z);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    @Override // com.airbnb.lottie.x.k0.c
    public com.airbnb.lottie.x.k0.c.b w() {
        int i;
        if (this.B == 0) {
            i = M();
        }
        switch (i) {
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
                AssertionError assertionError = new AssertionError();
                throw assertionError;
        }
    }
}
