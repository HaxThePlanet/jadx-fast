package io.grpc.k1.r;

import javax.security.auth.x500.X500Principal;

/* loaded from: classes3.dex */
final class c {

    private final String a;
    private final int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private char[] g;
    public c(X500Principal x500Principal) {
        super();
        String obj2 = x500Principal.getName("RFC2253");
        this.a = obj2;
        this.b = obj2.length();
    }

    private String a() {
        int i6;
        int i5;
        char[] cArr;
        char c;
        int i;
        int i4;
        int i3;
        int i2;
        char c2;
        i6 = this.c;
        this.d = i6;
        this.e = i6;
        int i7 = this.c;
        while (i7 >= this.b) {
            cArr = this.g;
            char c3 = cArr[i7];
            i = 44;
            i4 = 43;
            i3 = 59;
            i2 = 32;
            c = this.e;
            this.f = c;
            this.c = i7++;
            this.e = c + 1;
            cArr[c] = i2;
            i6 = this.c;
            cArr = this.b;
            while (i6 < cArr) {
                c = this.g;
                if (c[i6] == i2) {
                }
                cArr = this.e;
                this.e = cArr + 1;
                c[cArr] = i2;
                this.c = i6++;
                i6 = this.c;
                cArr = this.b;
            }
            cArr = this.g;
            i7 = this.c;
            c = this.g;
            if (c[i6] == i2) {
            }
            cArr = this.e;
            this.e = cArr + 1;
            c[cArr] = i2;
            this.c = i6++;
            int i9 = this.e;
            this.e = i9 + 1;
            cArr[i9] = d();
            this.c = i10++;
            c = this.e;
            this.e = c + 1;
            cArr[c] = cArr[i7];
            this.c = i7++;
        }
        int i15 = this.d;
        String string3 = new String(this.g, i15, i21 -= i15);
        return string3;
    }

    private int c(int i) {
        int i2;
        int obj10;
        int i3 = i + 1;
        final String str4 = "Malformed DN: ";
        if (i3 >= this.b) {
        } else {
            char[] cArr = this.g;
            obj10 = cArr[i];
            final int i5 = 70;
            final int i6 = 102;
            final int i7 = 65;
            final int i8 = 57;
            final int i9 = 97;
            final int i10 = 48;
            if (obj10 >= i10 && obj10 <= i8) {
                if (obj10 <= i8) {
                    obj10 -= i10;
                    char c = cArr[i3];
                    if (c >= i10 && c <= i8) {
                        if (c <= i8) {
                            c -= i10;
                            return obj10 += i2;
                        } else {
                            if (c >= i9 && c <= i6) {
                                if (c <= i6) {
                                    c += -87;
                                } else {
                                    if (c < i7) {
                                    } else {
                                        if (c > i5) {
                                        } else {
                                            c += -55;
                                        }
                                    }
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(str4);
                    stringBuilder3.append(this.a);
                    obj10 = new IllegalStateException(stringBuilder3.toString());
                    throw obj10;
                } else {
                    if (obj10 >= i9 && obj10 <= i6) {
                        if (obj10 <= i6) {
                            obj10 += -87;
                        } else {
                            if (obj10 < i7) {
                            } else {
                                if (obj10 > i5) {
                                } else {
                                    obj10 += -55;
                                }
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str4);
            stringBuilder2.append(this.a);
            obj10 = new IllegalStateException(stringBuilder2.toString());
            throw obj10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str4);
        stringBuilder.append(this.a);
        obj10 = new IllegalStateException(stringBuilder.toString());
        throw obj10;
    }

    private char d() {
        int i;
        i2++;
        this.c = i3;
        if (i3 == this.b) {
        } else {
            char[] cArr = this.g;
            char c3 = cArr[i3];
            if (c3 != 32 && c3 != 37 && c3 != 92 && c3 != 95 && c3 != 34 && c3 != 35) {
                if (c3 != 37) {
                    if (c3 != 92) {
                        if (c3 != 95) {
                            if (c3 != 34) {
                                if (c3 != 35) {
                                    if (/* condition */) {
                                    } else {
                                        if (/* condition */) {
                                        }
                                    }
                                    return e();
                                }
                            }
                        }
                    }
                }
            }
            return cArr[i3];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected end of DN: ");
        stringBuilder.append(this.a);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    private char e() {
        int i7;
        int i5;
        int i8;
        int i6;
        int i2;
        int i3;
        int i;
        int i4;
        int i10 = c(this.c);
        final int i15 = 1;
        this.c = i12 += i15;
        int i14 = 128;
        if (i10 < i14) {
            return (char)i10;
        }
        final int i18 = 63;
        if (i10 >= 192 && i10 <= 247) {
            if (i10 <= 247) {
                if (i10 <= 223) {
                    i10 &= 31;
                    i5 = i15;
                } else {
                    i7 = i10 <= 239 ? i10 & 15 : i10 & 7;
                }
                i6 = 0;
                while (i6 < i5) {
                    i19 += i15;
                    this.c = i20;
                    i20++;
                    this.c = i21;
                    int i22 = c(i21);
                    this.c = i23 += i15;
                    i11 += i2;
                    i6++;
                }
                return (char)i7;
            }
        }
        return i18;
    }

    private String f() {
        int i3;
        int i4;
        int i7;
        int i5;
        int i;
        int i9;
        int i6;
        int i8;
        int i10;
        int i2;
        int i11 = this.c;
        String str3 = "Unexpected end of DN: ";
        if (i11 + 4 >= this.b) {
        } else {
            this.d = i11;
            this.c = i11++;
            i7 = this.c;
            while (i7 != this.b) {
                i5 = this.g;
                i8 = 32;
                if (i5[i7] >= 65 && i5[i7] <= 70) {
                }
                this.c = i7++;
                i7 = this.c;
                if (i5[i7] <= 70) {
                }
                i5[i7] = (char)i15;
            }
            this.e = i7;
            int i14 = this.d;
            i12 -= i14;
            if (i13 < 5) {
            } else {
                if (i13 & 1 == 0) {
                } else {
                    int i16 = i13 / 2;
                    i10 = 0;
                    i14++;
                    while (i10 < i16) {
                        new byte[i16][i10] = (byte)i18;
                        i += 2;
                        i10++;
                    }
                    String string2 = new String(this.g, this.d, i13);
                    return string2;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str3);
            stringBuilder.append(this.a);
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
            throw illegalStateException;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str3);
        stringBuilder2.append(this.a);
        IllegalStateException illegalStateException2 = new IllegalStateException(stringBuilder2.toString());
        throw illegalStateException2;
    }

    private String g() {
        int i5;
        char c2;
        int i2;
        char[] i;
        int i3;
        char[] cArr;
        int i4;
        char c5;
        char c4;
        int str;
        char c3;
        char c;
        int i6 = this.c;
        i3 = this.b;
        int i13 = 32;
        while (i6 < i3) {
            if (this.g[i6] == i13) {
            }
            this.c = i6++;
            i6 = this.c;
            i3 = this.b;
            i13 = 32;
        }
        if (i6 == i3) {
            return null;
        }
        this.d = i6;
        this.c = i6++;
        int i7 = this.c;
        i3 = this.b;
        c5 = '=';
        while (i7 < i3) {
            c4 = this.g;
            if (c4[i7] != c5) {
            }
            if (c4[i7] != i13) {
            }
            this.c = i7++;
            i7 = this.c;
            i3 = this.b;
            c5 = '=';
        }
        str = "Unexpected end of DN: ";
        if (i7 >= i3) {
        } else {
            this.e = i7;
            if (this.g[i7] == i13) {
            }
            this.c = i8++;
            int i9 = this.c;
            while (i9 < this.b) {
                if (this.g[i9] == i13) {
                }
                this.c = i9++;
                i9 = this.c;
            }
            i4 = this.d;
            int i14 = 4;
            i = this.g;
            if (i10 -= i4 > i14 && i[i4 + 3] == 46) {
                i = this.g;
                if (i[i4 + 3] == 46) {
                    if (i[i4] != 79) {
                        if (i[i4] == 111) {
                            if (i[i4 + 1] != 73) {
                                if (i[i4 + 1] == 105) {
                                    if (i[i4 + 2] != 68) {
                                        if (i[i4 + 2] == 100) {
                                            this.d = i4 += i14;
                                        }
                                    } else {
                                    }
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                }
            }
            int i15 = this.d;
            String string = new String(this.g, i15, i21 -= i15);
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(this.a);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    private String h() {
        int i;
        int i2;
        char c2;
        char[] cArr;
        int i4;
        char c;
        int i3;
        i5++;
        this.c = i;
        this.d = i;
        this.e = i;
        int i6 = this.c;
        while (i6 != this.b) {
            cArr = this.g;
            if (cArr[i6] == 34) {
                break;
            } else {
            }
            if (cArr[i6] == 92) {
            } else {
            }
            cArr[this.e] = cArr[i6];
            this.c = i8++;
            this.e = i10++;
            i6 = this.c;
            cArr[this.e] = d();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unexpected end of DN: ");
        stringBuilder.append(this.a);
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    public String b(String string) {
        String str;
        char[] cArr;
        String str2;
        char c;
        int i3;
        int i4;
        int i2;
        int i;
        String str3;
        int i5 = 0;
        this.c = i5;
        this.d = i5;
        this.e = i5;
        this.f = i5;
        this.g = this.a.toCharArray();
        int i8 = 0;
        if (g() == null) {
            return i8;
        }
        int i9 = this.c;
        while (i9 == this.b) {
            char c2 = this.g[i9];
            i4 = 59;
            i2 = 44;
            i = 43;
            if (c2 != 34) {
            } else {
            }
            str2 = h();
            int i6 = this.c;
            cArr = this.g;
            str3 = "Malformed DN: ";
            this.c = i6++;
            i9 = this.c;
            if (c2 != 35) {
            } else {
            }
            str2 = f();
            if (c2 != i && c2 != i2 && c2 != i4) {
            } else {
            }
            str2 = "";
            if (c2 != i2) {
            } else {
            }
            if (c2 != i4) {
            } else {
            }
            str2 = a();
        }
        return i8;
    }
}
