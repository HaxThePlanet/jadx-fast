package com.google.zxing.h.b;

/* loaded from: classes2.dex */
final class n extends com.google.zxing.h.b.c {
    @Override // com.google.zxing.h.b.c
    public void a(com.google.zxing.h.b.h h) {
        int i;
        boolean z;
        int i2;
        int i3;
        StringBuilder stringBuilder = new StringBuilder();
        while (h.i()) {
            h.f = i4++;
            c(h.c(), stringBuilder);
            if (length %= 3 == 0) {
                break;
            } else {
            }
            c.g(h, stringBuilder);
            if (j.n(h.d(), h.f, e()) != e()) {
                break;
            } else {
            }
        }
        f(h, stringBuilder);
    }

    @Override // com.google.zxing.h.b.c
    int c(char c, StringBuilder stringBuilder2) {
        int i;
        int i2;
        int obj4;
        final int i3 = 1;
        if (c != 13) {
            if (c != 32) {
                if (c != 42) {
                    if (c != 62) {
                        i = 48;
                        if (c >= i && c <= 57) {
                            if (c <= 57) {
                                stringBuilder2.append((char)obj4);
                            } else {
                                i = 65;
                                if (c < i) {
                                } else {
                                    if (c > 90) {
                                    } else {
                                        stringBuilder2.append((char)obj4);
                                    }
                                }
                            }
                        } else {
                        }
                        j.e(c);
                        throw 0;
                    }
                    stringBuilder2.append('\u0002');
                } else {
                    stringBuilder2.append(i3);
                }
            } else {
                stringBuilder2.append('\u0003');
            }
        } else {
            stringBuilder2.append('\0');
        }
        return i3;
    }

    @Override // com.google.zxing.h.b.c
    public int e() {
        return 3;
    }

    @Override // com.google.zxing.h.b.c
    void f(com.google.zxing.h.b.h h, StringBuilder stringBuilder2) {
        int obj4;
        h.p();
        i -= i3;
        h.f = i4 -= obj4;
        int i6 = 1;
        if (h.f() <= i6 && i2 <= i6) {
            if (i2 <= i6) {
                if (h.f() != i2) {
                    h.r('\u00fe');
                }
            } else {
            }
        } else {
        }
        if (h.e() < 0) {
            h.o(0);
        }
    }
}
