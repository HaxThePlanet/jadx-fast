package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.v;

/* loaded from: classes2.dex */
public final class m {

    private static final int[] a;
    private static final int[] b;

    static class a {
    }

    public static final class b {

        public final int a;
        public final int b;
        public final String c;
        private b(int i, int i2, String string3) {
            super();
            this.a = i;
            this.b = i2;
            this.c = string3;
        }

        b(int i, int i2, String string3, com.google.android.exoplayer2.audio.m.a m$a4) {
            super(i, i2, string3);
        }
    }
    static {
        int[] iArr = new int[13];
        iArr = new int[]{96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
        m.a = iArr;
        int[] iArr2 = new int[16];
        iArr2 = new int[]{0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};
        m.b = iArr2;
    }

    public static byte[] a(int i, int i2, int i3) {
        byte[] bArr = new byte[2];
        return bArr;
    }

    private static int b(c0 c0) {
        int i;
        int obj2;
        if (c0.h(5) == 31) {
            i = obj2 + 32;
        }
        return i;
    }

    public static int c(int i) {
        if (i != 2 && i != 5 && i != 29 && i != 42 && i != 22 && i != 23) {
            if (i != 5) {
                if (i != 29) {
                    if (i != 42) {
                        if (i != 22) {
                            if (i != 23) {
                                return 0;
                            }
                            return 15;
                        }
                        return 1073741824;
                    }
                    return 16;
                }
                return 12;
            }
            return 11;
        }
        return 10;
    }

    private static int d(c0 c0) {
        int i;
        int obj2;
        i = c0.h(4);
        if (i == 15) {
            obj2 = c0.h(24);
            return obj2;
        } else {
            if (i >= 13) {
            } else {
                obj2 = m.a[i];
            }
        }
        obj2 = 0;
        throw ParserException.a(obj2, obj2);
    }

    public static com.google.android.exoplayer2.audio.m.b e(c0 c0, boolean z2) {
        int i;
        int i2;
        int i5;
        int i3;
        int i4;
        c0 obj7;
        int obj8;
        i = m.b(c0);
        i2 = m.d(c0);
        final int i7 = 4;
        i5 = c0.h(i7);
        StringBuilder stringBuilder2 = new StringBuilder(19);
        stringBuilder2.append("mp4a.40.");
        stringBuilder2.append(i);
        if (i != 5) {
            i2 = m.d(c0);
            if (i == 29 && m.b(c0) == 22) {
                i2 = m.d(c0);
                if (m.b(c0) == 22) {
                    i5 = c0.h(i7);
                }
            }
        } else {
        }
        i3 = 3;
        i4 = 2;
        if (z2 != 0 && i != 1 && i != i4 && i != i3 && i != i7 && i != 6 && i != 7 && i != 17) {
            i3 = 3;
            i4 = 2;
            if (i != 1) {
                if (i != i4) {
                    if (i != i3) {
                        if (i != i7) {
                            if (i != 6) {
                                if (i != 7) {
                                    if (i != 17) {
                                        if (/* condition */) {
                                        } else {
                                        }
                                        obj8 = new StringBuilder(42);
                                        obj8.append("Unsupported audio object type: ");
                                        obj8.append(i);
                                        throw ParserException.d(obj8.toString());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (/* condition */) {
                obj7 = c0.h(i4);
                if (obj7 == i4) {
                } else {
                    if (obj7 == i3) {
                    } else {
                    }
                }
                StringBuilder stringBuilder = new StringBuilder(33);
                stringBuilder.append("Unsupported epConfig: ");
                stringBuilder.append(obj7);
                throw ParserException.d(stringBuilder.toString());
            }
        }
        obj7 = m.b[i5];
        int i6 = 0;
        if (obj7 == -1) {
        } else {
            obj8 = new m.b(i2, obj7, stringBuilder2.toString(), i6);
            return obj8;
        }
        throw ParserException.a(i6, i6);
    }

    public static com.google.android.exoplayer2.audio.m.b f(byte[] bArr) {
        c0 c0Var = new c0(bArr);
        return m.e(c0Var, false);
    }

    private static void g(c0 c0, int i2, int i3) {
        boolean str;
        boolean z;
        String str2;
        int obj4;
        int obj5;
        if (c0.g()) {
            v.h("AacUtil", "Unexpected frameLengthFlag = 1");
        }
        if (c0.g()) {
            c0.q(14);
        }
        if (i3 == 0) {
        } else {
            int i = 20;
            final int i4 = 3;
            if (i2 != 6) {
                if (i2 == i) {
                    c0.q(i4);
                }
            } else {
            }
            if (c0.g() && i2 == 22) {
                if (i2 == 22) {
                    c0.q(16);
                }
                if (i2 != 17 && i2 != 19 && i2 != i) {
                    if (i2 != 19) {
                        if (i2 != i) {
                            if (i2 == 23) {
                                c0.q(i4);
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                c0.q(1);
            }
        }
        UnsupportedOperationException obj3 = new UnsupportedOperationException();
        throw obj3;
    }
}
