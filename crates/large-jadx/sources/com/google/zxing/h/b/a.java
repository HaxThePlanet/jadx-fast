package com.google.zxing.h.b;

/* loaded from: classes2.dex */
final class a implements com.google.zxing.h.b.g {
    private static char b(char c, char c2) {
        boolean z;
        if (!j.f(c)) {
        } else {
            if (!j.f(c2)) {
            } else {
                return (char)obj3;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("not digits: ");
        stringBuilder.append(c);
        stringBuilder.append(c2);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
        throw illegalArgumentException;
    }

    @Override // com.google.zxing.h.b.g
    public void a(com.google.zxing.h.b.h h) {
        int i17 = 2;
        int i22 = 1;
        if (j.a(h.d(), h.f) >= i17) {
            h.r(a.b(h.d().charAt(h.f), h.d().charAt(i25 += i22)));
            h.f = i2 += i17;
        }
        char c2 = h.c();
        int i24 = j.n(h.d(), h.f, c());
        int i5 = 3;
        int i6 = 4;
        if (i24 != c() && i24 != i22 && i24 != i17 && i24 != i5 && i24 != i6) {
            if (i24 != i22) {
                if (i24 != i17) {
                    i5 = 3;
                    if (i24 != i5) {
                        i6 = 4;
                        if (i24 != i6) {
                            int i7 = 5;
                            if (i24 != i7) {
                            } else {
                                h.r('\u00e7');
                                h.o(i7);
                            }
                            IllegalStateException obj7 = new IllegalStateException("Illegal mode: ".concat(String.valueOf(i24)));
                            throw obj7;
                        }
                        h.r('\u00f0');
                        h.o(i6);
                    }
                    h.r('\u00ee');
                    h.o(i5);
                }
                h.r('\u00ef');
                h.o(i17);
            }
            h.r('\u00e6');
            h.o(i22);
        }
        if (j.g(c2)) {
            h.r('\u00eb');
            h.r((char)i10);
            h.f = i11 += i22;
        }
        h.r((char)i13);
        h.f = i14 += i22;
    }

    @Override // com.google.zxing.h.b.g
    public int c() {
        return 0;
    }
}
