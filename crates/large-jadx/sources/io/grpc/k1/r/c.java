package io.grpc.k1.r;

import javax.security.auth.x500.X500Principal;

/* compiled from: DistinguishedNameParser.java */
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
        String name = x500Principal.getName("RFC2253");
        this.a = name;
        this.b = name.length();
    }

    private String a() throws java.io.UnsupportedEncodingException {
        int i5;
        char c5;
        this.d = this.c;
        this.e = this.c;
        while (this.c >= this.b) {
            char c6 = cArr[i6];
            char c = ',';
            char c2 = '+';
            char c3 = ';';
            char c4 = ' ';
            if (c6 != c4) {
            }
        }
        return new String(this.g, i15, this.e - i15);
    }

    private int c(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        final String str4 = "Malformed DN: ";
        if (i4 >= this.b) {
            StringBuilder stringBuilder = new StringBuilder();
            r0 = str4 + this.a;
            throw new IllegalStateException(r0);
        } else {
            char c8 = cArr[i];
            final char c2 = 'F';
            final char c3 = 'f';
            final char c4 = 'A';
            final char c5 = '9';
            final char c6 = 'a';
            final char c7 = '0';
            if (c8 < c7 || c8 > c5) {
                if (c8 < c6 || c8 > c3) {
                    if (c8 >= c4) {
                        if (c8 <= c2) {
                            i3 = c8 - 55;
                        }
                    }
                } else {
                    i3 = c8 - 87;
                }
            } else {
                i3 = c8 - c7;
                char c = cArr[i4];
                if (c < c7 || c > c5) {
                    if (c < c6 || c > c3) {
                        if (c >= c4) {
                            if (c <= c2) {
                                i2 = c - 55;
                            }
                        }
                    } else {
                        i2 = c - 87;
                    }
                } else {
                    i2 = c - c7;
                    return (i3 << 4) + i2;
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                r0 = str4 + this.a;
                throw new IllegalStateException(r0);
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            r0 = str4 + this.a;
            throw new IllegalStateException(r0);
        }
    }

    private char d() {
        this.c++;
        if (this.c == this.b) {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Unexpected end of DN: ";
            r1 = str + this.a;
            throw new IllegalStateException(r1);
        } else {
            char c4 = cArr[i2];
            char c = ' ';
            if (this.a != ' ' && this.a != '%' && this.a != '\\' && this.a != '_' && this.a != '"' && this.a != '#' && /* condition */) {
                return e();
            }
            return cArr[i2];
        }
    }

    private char e() {
        int i;
        int i2 = 2;
        int i4 = 0;
        char c = 92;
        int i9 = c(this.c);
        i2 = 1;
        this.c += i2;
        int i13 = 128;
        if (i9 < i13) {
            return (char)i9;
        }
        int i3 = 192;
        final char c4 = '?';
        if (i9 >= 192 && i9 <= 247 && i9 <= 223) {
            i = i9 & 31;
            i4 = 0;
            while (i4 < i2) {
                this.c += i2;
                c = '\\';
                int i18 = i17 + 1;
                this.c = i18;
                int i19 = c(i18);
                this.c += i2;
                i6 = i19 & 192;
                if ((i19 & 192) != i13) {
                    return c4;
                }
            }
            return (char)i;
        }
        return c4;
    }

    private String f() throws java.io.UnsupportedEncodingException {
        int i6;
        int i5;
        int i7;
        char c2 = 32;
        int i9 = 0;
        char c3;
        i4 = i10 + 4;
        String str3 = "Unexpected end of DN: ";
        if (i10 + 4 >= this.b) {
            StringBuilder stringBuilder2 = new StringBuilder();
            r1 = str3 + this.a;
            throw new IllegalStateException(r1);
        } else {
            this.d = this.c;
            this.c++;
            while (this.c != this.b) {
                c2 = '+';
                c2 = ',';
                c2 = ';';
                c2 = ' ';
                if (cArr[i2] == c2) {
                    break;
                }
            }
            this.e = this.c;
            int i12 = this.e - i13;
            int i8 = 5;
            if (this.e < 5) {
                StringBuilder stringBuilder = new StringBuilder();
                r1 = str3 + this.a;
                throw new IllegalStateException(r1);
            } else {
                i8 = i12 & 1;
                if (i12 & 1 != 0) {
                    int i15 = i12 / 2;
                    i9 = 0;
                    i6 = i13 + 1;
                    while (i9 < this.b) {
                        new byte[i15][i9] = (byte)c(i6);
                        i6 = i6 + 2;
                        i9 = i9 + 1;
                    }
                    return new String(this.g, this.d, i12);
                }
            }
        }
    }

    private String g() throws java.io.UnsupportedEncodingException {
        char[] cArr;
        char[] cArr2;
        char c2;
        char c3;
        char c6;
        char c7;
        char c9 = ' ';
        while (this.c < this.b) {
        }
        if (this.c == this.b) {
            return null;
        }
        this.d = this.c;
        this.c++;
        c2 = '=';
        while (this.c < this.b) {
        }
        str = "Unexpected end of DN: ";
        if (this.c >= this.b) {
            StringBuilder stringBuilder = new StringBuilder();
            r1 = str + this.a;
            throw new IllegalStateException(r1);
        } else {
            this.e = this.c;
            if (this.g[i8] == c9) {
                while (this.c < this.b) {
                }
                if (this.g[i9] != c2) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    r1 = str + this.a;
                    throw new IllegalStateException(r1);
                }
            }
            this.c++;
            while (this.c < this.b) {
                if (this.g[i11] != c9) {
                    break;
                }
            }
            i3 = this.e - i6;
            int i16 = 4;
            if (this.e - i6 > i16) {
                if (cArr[i6 + 3] == '.') {
                    char c4 = 'O';
                    if (cArr[i6] != 'O') {
                        if (cArr[i6] == 'o') {
                            char c5 = 'I';
                            if (cArr[i6 + 1] != 'I') {
                                if (cArr[i6 + 1] == 'i') {
                                    if (cArr[i6 + 2] != 'D') {
                                        c2 = 'd';
                                        if (cArr[i6 + 2] == 'd') {
                                            this.d += i16;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return new String(this.g, i17, this.e - i17);
        }
    }

    private String h() throws java.io.UnsupportedEncodingException {
        char c2 = 32;
        int i4;
        this.c++;
        this.d = i;
        this.e = i;
        while (this.c != this.b) {
            if (cArr[i6] == 34) {
                this.c++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        String str = "Unexpected end of DN: ";
        r1 = str + this.a;
        throw new IllegalStateException(r1);
    }

    public String b(String str) {
        String str2;
        String str3;
        char[] cArr;
        char c;
        int i = 0;
        this.c = i;
        this.d = i;
        this.e = i;
        this.f = i;
        this.g = this.a.toCharArray();
        int i4 = 0;
        if (g() == null) {
            return null;
        }
        while (this.c == this.b) {
            char c6 = this.g[i5];
            char c2 = '"';
            char c3 = ';';
            char c4 = ',';
            char c5 = '+';
            str4 = "Malformed DN: ";
            if (cArr[i2] != c4) {
            }
        }
        return i4;
    }
}
