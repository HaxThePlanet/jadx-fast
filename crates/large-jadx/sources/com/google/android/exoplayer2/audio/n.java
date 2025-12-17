package com.google.android.exoplayer2.audio;

import android.accounts.Account;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class n {

    private static final int[] a;
    private static final int[] b;
    private static final int[] c;
    private static final int[] d;
    private static final int[] e;
    private static final int[] f;

    static class a {
    }

    public static final class b {

        public final String a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        private b(String string, int i2, int i3, int i4, int i5, int i6) {
            super();
            this.a = string;
            this.c = i3;
            this.b = i4;
            this.d = i5;
            this.e = i6;
        }

        b(String string, int i2, int i3, int i4, int i5, int i6, com.google.android.exoplayer2.audio.n.a n$a7) {
            super(string, i2, i3, i4, i5, i6);
        }
    }
    static {
        int[] iArr = new int[4];
        iArr = new int[]{1, 2, 3, 6};
        n.a = iArr;
        int i3 = 3;
        int[] iArr5 = new int[i3];
        iArr5 = new int[]{48000, 44100, 32000};
        n.b = iArr5;
        int[] iArr2 = new int[i3];
        iArr2 = new int[]{24000, 22050, 16000};
        n.c = iArr2;
        int[] iArr3 = new int[8];
        iArr3 = new int[]{2, 1, 2, 3, 3, 4, 4, 5};
        n.d = iArr3;
        int i5 = 19;
        int[] iArr6 = new int[i5];
        iArr6 = new int[]{
            32, 40, 48, 56, 64, 80, 96, 112, 128, 160,
            192, 224, 256, 320, 384, 448, 512, 576, 640
        };
        n.e = iArr6;
        int[] iArr4 = new int[i5];
        iArr4 = new int[]{
            69, 87, 104, 121, 139, 174, 208, 243, 278, 348,
            417, 487, 557, 696, 835, 975, 1114, 1253, 1393
        };
        n.f = iArr4;
    }

    public static int a(ByteBuffer byteBuffer) {
        int i2;
        int i3;
        int i;
        final int position = byteBuffer.position();
        i2 = position;
        while (i2 <= limit += -10) {
            i2++;
        }
        return -1;
    }

    private static int b(int i, int i2) {
        int[] iArr;
        int length;
        int length2;
        int i3 = i2 / 2;
        iArr = n.b;
        if (i >= 0 && i < iArr.length && i2 >= 0) {
            iArr = n.b;
            if (i < iArr.length) {
                if (i2 >= 0) {
                    length = n.f;
                    if (i3 >= length.length) {
                    } else {
                        int obj4 = iArr[i];
                        if (obj4 == 44100) {
                            return obj4 *= 2;
                        }
                        int obj5 = n.e[i3];
                        if (obj4 == 32000) {
                            return obj5 *= 6;
                        }
                    }
                    return obj5 *= 4;
                }
            }
        }
        return -1;
    }

    public static i1 c(d0 d0, String string2, String string3, t t4) {
        int i;
        int obj3 = d0.x();
        if (obj3 &= 4 != 0) {
            i++;
        }
        obj3 = new i1.b();
        obj3.S(string2);
        obj3.e0("audio/ac3");
        obj3.H(i);
        obj3.f0(n.b[i3 >>= 6]);
        obj3.L(t4);
        obj3.V(string3);
        return obj3.E();
    }

    public static int d(ByteBuffer byteBuffer) {
        int i2;
        int i;
        int i3;
        int obj3;
        i3 = 3;
        i2 = i5 >>= i3 > 10 ? 1 : 0;
        if (i2 != 0) {
            if (i8 >>= 6 == i3) {
            } else {
                i3 = obj3 >> 4;
            }
            return obj3 *= 256;
        }
        return 1536;
    }

    public static com.google.android.exoplayer2.audio.n.b e(c0 c0) {
        String str2;
        int i6;
        int i20;
        int i2;
        boolean i12;
        int i;
        int i17;
        String str;
        boolean z;
        int i18;
        int i8;
        boolean z4;
        int i19;
        int i7;
        int i5;
        int length;
        int i10;
        int i3;
        int i9;
        int i4;
        int i11;
        int i14;
        int i13;
        boolean z3;
        boolean z2;
        int i15;
        String str3;
        int i16;
        i6 = c0;
        i6.q(40);
        i12 = 5;
        int i30 = 10;
        length = 1;
        i17 = i6.h(i12) > i30 ? length : 0;
        i6.o(c0.e());
        i20 = -1;
        final int i35 = 8;
        final int i36 = 3;
        final int i37 = 2;
        if (i17 != 0) {
            int i26 = 16;
            i6.q(i26);
            int i38 = i6.h(i37);
            if (i38 != 0) {
                if (i38 != length) {
                    if (i38 != i37) {
                    } else {
                        i20 = i37;
                    }
                } else {
                    i20 = length;
                }
            } else {
                i20 = 0;
            }
            i6.q(i36);
            i41 *= i37;
            i9 = i6.h(i37);
            if (i9 == i36) {
                i14 = i42;
                i11 = 6;
                i4 = i36;
            } else {
                i11 = n.a[i6.h(i37)];
                i14 = n.b[i9];
            }
            i5 = i11 * 256;
            i10 = i6.h(i36);
            z3 = c0.g();
            i44 += z3;
            i6.q(i30);
            if (c0.g()) {
                i6.q(i35);
            }
            i6.q(i12);
            if (i10 == 0 && c0.g()) {
                i6.q(i12);
                if (c0.g()) {
                    i6.q(i35);
                }
            }
            if (i20 == length && c0.g()) {
                if (c0.g()) {
                    i6.q(i26);
                }
            }
            i19 = 4;
            if (c0.g() && i10 > i37) {
                if (i10 > i37) {
                    i6.q(i37);
                }
                if (i10 & 1 != 0 && i10 > i37) {
                    if (i10 > i37) {
                        i6.q(6);
                    } else {
                        z = 6;
                    }
                } else {
                }
                if (i10 & 4 != 0) {
                    i6.q(z);
                }
                if (z3 && c0.g()) {
                    if (c0.g()) {
                        i6.q(i12);
                    }
                }
                if (i20 == 0) {
                    if (c0.g()) {
                        i6.q(6);
                    } else {
                        i18 = 6;
                    }
                    if (i10 == 0 && c0.g()) {
                        if (c0.g()) {
                            i6.q(i18);
                        }
                    }
                    if (c0.g()) {
                        i6.q(i18);
                    }
                    i8 = i6.h(i37);
                    if (i8 == length) {
                        i6.q(i12);
                    } else {
                        if (i8 == i37) {
                            i6.q(12);
                        } else {
                            i6.q(i12);
                            if (i8 == i36 && c0.g() && c0.g()) {
                                if (c0.g()) {
                                    i6.q(i12);
                                    if (c0.g()) {
                                        i6.q(i19);
                                    }
                                    if (c0.g()) {
                                        i6.q(i19);
                                    }
                                    if (c0.g()) {
                                        i6.q(i19);
                                    }
                                    if (c0.g()) {
                                        i6.q(i19);
                                    }
                                    if (c0.g()) {
                                        i6.q(i19);
                                    }
                                    if (c0.g()) {
                                        i6.q(i19);
                                    }
                                    if (c0.g()) {
                                        i6.q(i19);
                                    }
                                    if (c0.g() && c0.g()) {
                                        if (c0.g()) {
                                            i6.q(i19);
                                        }
                                        if (c0.g()) {
                                            i6.q(i19);
                                        }
                                    }
                                }
                                i6.q(i12);
                                i6.q(7);
                                if (c0.g() && c0.g() && c0.g()) {
                                    i6.q(i12);
                                    if (c0.g()) {
                                        i6.q(7);
                                        if (c0.g()) {
                                            i6.q(i35);
                                        }
                                    }
                                }
                                i6.q(i29 *= i35);
                                c0.c();
                            }
                        }
                    }
                    length = 14;
                    if (i10 < i37 && c0.g()) {
                        length = 14;
                        if (c0.g()) {
                            i6.q(length);
                        }
                        if (i10 == 0 && c0.g()) {
                            if (c0.g()) {
                                i6.q(length);
                            }
                        }
                    }
                    if (c0.g()) {
                        if (i4 == 0) {
                            i6.q(i12);
                        } else {
                            z = 0;
                            while (z < i11) {
                                if (c0.g() != 0) {
                                }
                                z++;
                                i6.q(i12);
                            }
                        }
                    }
                }
            }
            i6.q(i12);
            if (c0.g() && i10 == i37) {
                i6.q(i12);
                if (i10 == i37) {
                    i6.q(i19);
                }
                if (i10 >= 6) {
                    i6.q(i37);
                }
                if (c0.g()) {
                    i6.q(i35);
                }
                if (i10 == 0 && c0.g()) {
                    if (c0.g()) {
                        i6.q(i35);
                    }
                }
                if (i9 < i36) {
                    c0.p();
                }
            }
            if (i20 == 0 && i4 != i36) {
                if (i4 != i36) {
                    c0.p();
                }
            }
            if (i20 == i37) {
                if (i4 != i36) {
                    if (c0.g()) {
                        i6.q(6);
                    } else {
                        i = 6;
                    }
                } else {
                }
            } else {
            }
            str = 1;
            if (c0.g() && i6.h(i) == str && i6.h(i35) == str) {
                str = 1;
                if (i6.h(i) == str) {
                    str2 = i6.h(i35) == str ? "audio/eac3-joc" : "audio/eac3";
                } else {
                }
            } else {
            }
            str3 = str2;
            i16 = i20;
        } else {
            i6.q(32);
            i2 = i6.h(i37);
            str = i2 == i36 ? 0 : "audio/ac3";
            i3 = n.b(i2, i6.h(6));
            i6.q(i35);
            i19 = i6.h(i36);
            if (i19 & 1 != 0 && i19 != 1) {
                if (i19 != 1) {
                    i6.q(i37);
                }
            }
            if (i19 & 4 != 0) {
                i6.q(i37);
            }
            if (i19 == i37) {
                i6.q(i37);
            }
            int[] iArr2 = n.b;
            i14 = i2 < iArr2.length ? i2 : i20;
            i5 = 1536;
            i15 = i + str2;
            i16 = i20;
            str3 = str;
        }
        super(str3, i16, i15, i14, i3, i5, 0);
        return bVar;
    }

    public static int f(byte[] bArr) {
        int i;
        if (bArr.length < 6) {
            return -1;
        }
        int i11 = 3;
        final int i14 = 1;
        i = i3 >>= i11 > 10 ? i14 : 0;
        if (i != 0) {
            int i6 = 2;
            return obj5 *= i6;
        }
        int i5 = 4;
        return n.b(i12 >> 6, obj5 &= 63);
    }

    public static i1 g(d0 d0, String string2, String string3, t t4) {
        int i3;
        int i2;
        int i;
        String obj5;
        i3 = 2;
        d0.J(i3);
        int i9 = d0.x();
        if (i9 &= 1 != 0) {
            i++;
        }
        if (i12 >>= 1 > 0 && i3 &= i2 != 0) {
            if (i3 &= i2 != 0) {
                i += 2;
            }
        }
        if (d0.a() > 0 && obj5 &= 1 != 0) {
            obj5 = obj5 &= 1 != 0 ? "audio/eac3-joc" : "audio/eac3";
        } else {
        }
        i1.b bVar = new i1.b();
        bVar.S(string2);
        bVar.e0(obj5);
        bVar.H(i);
        bVar.f0(n.b[i6 >>= 6]);
        bVar.L(t4);
        bVar.V(string3);
        return bVar.E();
    }

    public static int h(ByteBuffer byteBuffer, int i2) {
        int i;
        int obj4;
        i = b &= 255 == 187 ? 1 : 0;
        obj4 = i != 0 ? 9 : 8;
        return i7 << obj3;
    }
}
