package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class o {

    private static final int[] a;

    static class a {
    }

    public static final class b {

        public final int a;
        public final int b;
        public final int c;
        public final int d;
        private b(int i, int i2, int i3, int i4, int i5) {
            super();
            this.b = i2;
            this.a = i3;
            this.c = i4;
            this.d = i5;
        }

        b(int i, int i2, int i3, int i4, int i5, com.google.android.exoplayer2.audio.o.a o$a6) {
            super(i, i2, i3, i4, i5);
        }
    }
    static {
        int[] iArr = new int[14];
        iArr = new int[]{2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};
        o.a = iArr;
    }

    public static void a(int i, d0 d02) {
        d02.E(7);
        final byte[] obj3 = d02.d();
        obj3[0] = -84;
        obj3[1] = 64;
        int i14 = -1;
        obj3[2] = i14;
        obj3[3] = i14;
        obj3[4] = (byte)i8;
        obj3[5] = (byte)i10;
        obj3[6] = (byte)obj2;
    }

    public static i1 b(d0 d0, String string2, String string3, t t4) {
        int obj1;
        int i = 1;
        d0.J(i);
        obj1 = obj1 >>= 5 == i ? 48000 : 44100;
        i1.b bVar = new i1.b();
        bVar.S(string2);
        bVar.e0("audio/ac4");
        bVar.H(2);
        bVar.f0(obj1);
        bVar.L(t4);
        bVar.V(string3);
        return bVar.E();
    }

    public static int c(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        byteBuffer.get(bArr);
        byteBuffer.position(byteBuffer.position());
        c0 obj2 = new c0(bArr);
        return obj2.d;
    }

    public static com.google.android.exoplayer2.audio.o.b d(c0 c0) {
        int i8;
        int i6;
        int[] i9;
        int i4;
        int i3;
        int i7;
        int i5;
        boolean z;
        int i10;
        int i;
        int i11;
        int length;
        int i2;
        int obj10;
        int i12 = 16;
        final int i17 = 4;
        if (c0.h(i12) == 65535) {
            i8 = c0.h(24);
            i7 = 7;
        } else {
            i7 = i17;
        }
        if (c0.h(i12) == 44097) {
            i6 += 2;
        }
        i9 = 2;
        i4 = c0.h(i9);
        int i20 = 3;
        if (i4 == i20) {
            i4 += i5;
        }
        if (c0.g() && c0.h(i20) > 0) {
            if (c0.h(i20) > 0) {
                c0.q(i9);
            }
        }
        i = 48000;
        length = 44100;
        i2 = c0.g() ? i : length;
        obj10 = c0.h(i17);
        i10 = 0;
        if (i2 == length && obj10 == 13) {
            if (obj10 == 13) {
                i11 = obj10;
            } else {
                i = o.a;
                if (i2 == i && obj10 < i.length) {
                    i = o.a;
                    if (obj10 < i.length) {
                        i3 %= 5;
                        i = 8;
                        if (i3 != 1) {
                            length = 11;
                            if (i3 != i9) {
                                if (i3 != i20) {
                                    if (i3 != i17) {
                                    } else {
                                        if (obj10 != i20 && obj10 != i) {
                                            if (obj10 != i) {
                                                if (obj10 == length) {
                                                    i10++;
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    }
                                } else {
                                    if (obj10 != i20) {
                                        if (obj10 == i) {
                                        }
                                    } else {
                                    }
                                }
                            } else {
                                if (obj10 != i) {
                                    if (obj10 == length) {
                                    }
                                } else {
                                }
                            }
                        } else {
                        }
                    }
                }
                i11 = i10;
            }
        } else {
        }
        super(i4, 2, i2, i6, i11, 0);
        return obj10;
    }

    public static int e(byte[] bArr, int i2) {
        int i;
        int i3;
        int i4;
        int obj4;
        if (bArr.length < 7) {
            return -1;
        }
        final int i17 = 4;
        if (i7 |= i13 == 65535) {
            i10 |= obj4;
        } else {
            i3 = i17;
        }
        if (i2 == 44097) {
            i3 += 2;
        }
        return i += i3;
    }

    private static int f(c0 c0, int i2) {
        int i;
        boolean z;
        i = 0;
        i += i5;
        while (!c0.g()) {
            i4 <<= i2;
            i += i5;
        }
        return i3;
    }
}
