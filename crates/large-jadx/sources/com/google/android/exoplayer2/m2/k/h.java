package com.google.android.exoplayer2.m2.k;

import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.m2.d;
import com.google.android.exoplayer2.m2.g;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.common.base.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class h extends g {

    private final com.google.android.exoplayer2.m2.k.h.a a;

    public interface a {
        public abstract boolean a(int i, int i2, int i3, int i4, int i5);
    }

    private static final class b {

        private final int a;
        private final boolean b;
        private final int c;
        public b(int i, boolean z2, int i3) {
            super();
            this.a = i;
            this.b = z2;
            this.c = i3;
        }

        static int a(com.google.android.exoplayer2.m2.k.h.b h$b) {
            return b.a;
        }

        static int b(com.google.android.exoplayer2.m2.k.h.b h$b) {
            return b.c;
        }

        static boolean c(com.google.android.exoplayer2.m2.k.h.b h$b) {
            return b.b;
        }
    }
    static {
        final com.google.android.exoplayer2.m2.k.a aVar = a.a;
    }

    public h() {
        super(0);
    }

    public h(com.google.android.exoplayer2.m2.k.h.a h$a) {
        super();
        this.a = a;
    }

    private static boolean A(d0 d0, int i2, int i3, boolean z4) {
        int i;
        int i6;
        int i7;
        int i5;
        int i8;
        int i9;
        int cmp;
        long l;
        int i10;
        int i4;
        int i11;
        int i12;
        int i13;
        final Object obj = d0;
        final int i14 = i2;
        final int i15 = d0.e();
        i7 = 1;
        while (d0.a() >= i3) {
            int i17 = 3;
            i8 = 0;
            if (i14 >= i17) {
            } else {
            }
            cmp = d0.A();
            l = (long)i24;
            i10 = i8;
            i4 = 0;
            i9 = 4;
            if (i14 == i9) {
            } else {
            }
            if (i14 == i17) {
            } else {
            }
            i7 = i6;
            if (i7 != 0) {
            }
            obj.J((int)l);
            i7 = 1;
            i6 += 4;
            if (i10 & 32 != 0) {
            } else {
            }
            i6 = i8;
            if (i10 & 128 != 0) {
            } else {
            }
            i7 = i8;
            i6 = i7;
            if (i10 & 64 != 0) {
            } else {
            }
            i6 = i8;
            if (i10 & 1 != 0) {
            } else {
            }
            i6 = i7;
            int i25 = 255;
            i23 |= i11;
            cmp = d0.n();
            l = d0.z();
            i10 = d0.D();
        }
        obj.I(i15);
        return i7;
    }

    private static byte[] c(byte[] bArr, int i2, int i3) {
        if (i3 <= i2) {
            return p0.f;
        }
        return Arrays.copyOfRange(bArr, i2, i3);
    }

    private static com.google.android.exoplayer2.m2.k.b e(d0 d0, int i2, int i3) {
        String valueOf;
        int indexOf;
        int i;
        String obj7;
        String obj9;
        final int i4 = d0.x();
        i2--;
        final byte[] bArr = new byte[obj8];
        int i5 = 0;
        d0.j(bArr, i5, obj8);
        obj7 = "image/";
        indexOf = "ISO-8859-1";
        int i11 = 2;
        if (i3 == i11) {
            obj9 = new String(bArr, i5, 3, indexOf);
            obj9 = String.valueOf(b.c(obj9));
            if (obj9.length() != 0) {
                obj7 = obj7.concat(obj9);
            } else {
                obj9 = new String(obj7);
                obj7 = obj9;
            }
            if ("image/jpg".equals(obj7)) {
                obj7 = "image/jpeg";
            }
            obj9 = i11;
        } else {
            String string2 = new String(bArr, i5, h.x(bArr, i5), indexOf);
            valueOf = b.c(string2);
            if (valueOf.indexOf(47) == -1) {
                valueOf = String.valueOf(valueOf);
                if (valueOf.length() != 0) {
                    obj7 = obj7.concat(valueOf);
                } else {
                    valueOf = new String(obj7);
                    obj7 = valueOf;
                }
            } else {
            }
        }
        obj9 += i11;
        int i9 = h.w(bArr, obj9, i4);
        String string = new String(bArr, obj9, i9 - obj9, h.u(i4));
        obj9 = new b(obj7, string, b &= 255, h.c(bArr, i9 += obj9, obj8));
        return obj9;
    }

    private static com.google.android.exoplayer2.m2.k.c f(d0 d0, int i2, String string3) {
        final byte[] bArr = new byte[i2];
        d0.j(bArr, 0, i2);
        c obj2 = new c(string3, bArr);
        return obj2;
    }

    private static com.google.android.exoplayer2.m2.k.d g(d0 d0, int i2, int i3, boolean z4, int i5, com.google.android.exoplayer2.m2.k.h.a h$a6) {
        byte[] bArr;
        int cmp;
        long l;
        long l3;
        com.google.android.exoplayer2.m2.k.h.a aVar;
        long l2;
        com.google.android.exoplayer2.m2.k.i iVar;
        d0 d0Var = d0;
        int i4 = d0.e();
        int i7 = h.x(d0.d(), i4);
        String string = new String(d0.d(), i4, i7 - i4, "ISO-8859-1");
        d0.I(i7++);
        long l4 = d0.z();
        long l6 = 4294967295L;
        final int i13 = -1;
        l2 = Long.compare(l4, l6) == 0 ? i13 : l4;
        long l5 = d0.z();
        l3 = Long.compare(l5, l6) == 0 ? i13 : l5;
        ArrayList arrayList = new ArrayList();
        while (d0.e() < i4 += i2) {
            iVar = h.j(i3, d0, z4, i5, a6);
            if (iVar != null) {
            }
            arrayList.add(iVar);
        }
        super(string, d0.n(), d0.n(), l2, l, l3, i13, (i[])arrayList.toArray(new i[0]));
        return dVar;
    }

    private static com.google.android.exoplayer2.m2.k.e h(d0 d0, int i2, int i3, boolean z4, int i5, com.google.android.exoplayer2.m2.k.h.a h$a6) {
        int i;
        int i9;
        String str;
        int i8;
        int i10;
        int i6;
        int i7;
        String string;
        byte[] bArr;
        int i4;
        d0 d0Var = d0;
        int i11 = d0.e();
        int i13 = h.x(d0.d(), i11);
        str = "ISO-8859-1";
        String string2 = new String(d0.d(), i11, i13 - i11, str);
        int i17 = 1;
        d0Var.I(i13 += i17);
        int i15 = d0.x();
        final int i21 = 0;
        i9 = i15 & 2 != 0 ? i17 : i21;
        i = i15 &= i17 != 0 ? i17 : i21;
        i8 = d0.x();
        final String[] strArr = new String[i8];
        i10 = i21;
        while (i10 < i8) {
            i6 = d0.e();
            int i22 = h.x(d0.d(), i6);
            string = new String(d0.d(), i6, i22 - i6, str);
            strArr[i10] = string;
            d0Var.I(i22 += i17);
            i10++;
        }
        ArrayList arrayList = new ArrayList();
        while (d0.e() < i11 += i2) {
            i7 = h.j(i3, d0Var, z4, i5, a6);
            if (i7 != null) {
            }
            arrayList.add(i7);
        }
        super(string2, i9, i, strArr, (i[])arrayList.toArray(new i[i21]));
        return eVar;
    }

    private static com.google.android.exoplayer2.m2.k.f i(d0 d0, int i2) {
        int i = 4;
        if (i2 < i) {
            return null;
        }
        int i3 = d0.x();
        final String str = h.u(i3);
        int i5 = 3;
        final byte[] bArr2 = new byte[i5];
        final int i7 = 0;
        d0.j(bArr2, i7, i5);
        String string = new String(bArr2, i7, i5);
        i2 -= i;
        byte[] bArr = new byte[obj8];
        d0.j(bArr, i7, obj8);
        int obj7 = h.w(bArr, i7, i3);
        String obj8 = new String(bArr, i7, obj7, str);
        obj7 += i6;
        f fVar = new f(string, obj8, h.o(bArr, obj7, h.w(bArr, obj7, i3), str));
        return fVar;
    }

    private static com.google.android.exoplayer2.m2.k.i j(int i, d0 d02, boolean z3, int i4, com.google.android.exoplayer2.m2.k.h.a h$a5) {
        int string;
        int i23;
        int i15;
        int i6;
        int i3;
        com.google.android.exoplayer2.m2.k.i iVar;
        int i7;
        int i2;
        int str2;
        int i12;
        int i5;
        int i17;
        int stringBuilder;
        String str;
        int i13;
        int i19;
        int i16;
        int i18;
        int i8;
        int i14;
        String str3;
        int i9;
        int i20;
        int i21;
        int i11;
        int i10;
        int i22;
        string = i;
        final d0 d0Var3 = d02;
        final int i50 = d02.x();
        final int i51 = d02.x();
        final int i52 = d02.x();
        i14 = 3;
        if (string >= i14) {
            i9 = i23;
        } else {
            i9 = 0;
        }
        if (string == 4) {
            i15 = d02.B();
            if (!z3) {
                i30 |= i7;
            }
        } else {
            if (string == i14) {
                i15 = d02.B();
            } else {
                i15 = d02.A();
            }
        }
        i21 = i15;
        if (string >= i14) {
            i18 = i15;
        } else {
            i18 = 0;
        }
        final int i54 = 0;
        if (i50 == 0 && i51 == 0 && i52 == 0 && i9 == 0 && i21 == 0 && i18 == 0) {
            if (i51 == 0) {
                if (i52 == 0) {
                    if (i9 == 0) {
                        if (i21 == 0) {
                            if (i18 == 0) {
                                d0Var3.I(d02.f());
                                return i54;
                            }
                        }
                    }
                }
            }
        }
        i16 = i26 + i21;
        str = "Id3Decoder";
        if (i16 > d02.f()) {
            v.h(str, "Frame size exceeds remaining tag data");
            d0Var3.I(d02.f());
            return i54;
        }
        if (a5 != null) {
            str3 = str;
            i22 = i18;
            if (!a5.a(i, i50, i51, i52, i9)) {
                d0Var3.I(i16);
                return i54;
            }
        } else {
            str3 = str;
            i20 = i16;
            i22 = i18;
        }
        i3 = 1;
        if (string == i14) {
            int i34 = i22;
            i17 = i34 & 128 != 0 ? i3 : 0;
            i19 = i34 & 64 != 0 ? i3 : 0;
            i2 = i34 &= 32 != 0 ? i3 : 0;
            i10 = i17;
            i8 = 0;
        } else {
            int i31 = i22;
            if (string == 4) {
                i5 = i31 & 64 != 0 ? i3 : 0;
                i13 = i31 & 8 != 0 ? i3 : 0;
                i16 = i31 & 4 != 0 ? i3 : 0;
                i8 = i31 & 2 != 0 ? i3 : 0;
                i11 = i31 &= i3 != 0 ? i3 : 0;
                i2 = i5;
                i17 = i11;
                i10 = i13;
                i19 = i16;
            } else {
                i2 = 0;
                i17 = 0;
                i19 = 0;
                i8 = 0;
                i10 = 0;
            }
        }
        if (i10 == 0) {
            if (i19 != 0) {
            } else {
                if (i2 != 0) {
                    i21--;
                    d0Var3.J(i3);
                }
                if (i17 != 0) {
                    i21 += -4;
                    d0Var3.J(4);
                }
                if (i8 != 0) {
                    i21 = h.z(d0Var3, i21);
                }
                int i27 = 84;
                str2 = 2;
                stringBuilder = 88;
                if (i50 == i27 && i51 == stringBuilder && i52 == stringBuilder) {
                    if (i51 == stringBuilder) {
                        if (i52 == stringBuilder) {
                            if (string != str2) {
                                if (i9 == stringBuilder) {
                                    iVar = h.q(d0Var3, i21);
                                } else {
                                    if (i50 == i27) {
                                        iVar = h.p(d0Var3, i21, h.v(string, i50, i51, i52, i9));
                                    } else {
                                        i19 = 87;
                                        if (i50 == i19 && i51 == stringBuilder && i52 == stringBuilder) {
                                            if (i51 == stringBuilder) {
                                                if (i52 == stringBuilder) {
                                                    if (string != str2) {
                                                        if (i9 == stringBuilder) {
                                                            iVar = h.s(d0Var3, i21);
                                                        } else {
                                                            if (i50 == i19) {
                                                                iVar = h.r(d0Var3, i21, h.v(string, i50, i51, i52, i9));
                                                            } else {
                                                                stringBuilder = 73;
                                                                i19 = 80;
                                                                if (i50 == i19 && i51 == 82 && i52 == stringBuilder && i9 == 86) {
                                                                    if (i51 == 82) {
                                                                        if (i52 == stringBuilder) {
                                                                            if (i9 == 86) {
                                                                                iVar = h.n(d0Var3, i21);
                                                                            } else {
                                                                                i8 = 79;
                                                                                if (i50 == 71 && i51 == 69 && i52 == i8) {
                                                                                    if (i51 == 69) {
                                                                                        if (i52 == i8) {
                                                                                            if (i9 != 66) {
                                                                                                if (string == str2) {
                                                                                                    iVar = h.k(d0Var3, i21);
                                                                                                } else {
                                                                                                    i16 = 65;
                                                                                                    i14 = 67;
                                                                                                    if (string == str2) {
                                                                                                        if (i50 == i19 && i51 == stringBuilder && i52 == i14) {
                                                                                                            if (i51 == stringBuilder) {
                                                                                                                if (i52 == i14) {
                                                                                                                    iVar = h.e(d0Var3, i21, string);
                                                                                                                } else {
                                                                                                                    stringBuilder = 77;
                                                                                                                    if (i50 == i14 && i51 == i8 && i52 == stringBuilder) {
                                                                                                                        if (i51 == i8) {
                                                                                                                            if (i52 == stringBuilder) {
                                                                                                                                if (i9 != stringBuilder) {
                                                                                                                                    if (string == str2) {
                                                                                                                                        iVar = h.i(d0Var3, i21);
                                                                                                                                    } else {
                                                                                                                                        if (i50 == i14 && i51 == 72 && i52 == i16 && i9 == i19) {
                                                                                                                                            if (i51 == 72) {
                                                                                                                                                if (i52 == i16) {
                                                                                                                                                    if (i9 == i19) {
                                                                                                                                                        iVar = h.g(d02, i21, i, z3, i4, a5);
                                                                                                                                                    } else {
                                                                                                                                                        if (i50 == i14 && i51 == i27 && i52 == i8 && i9 == i14) {
                                                                                                                                                            if (i51 == i27) {
                                                                                                                                                                if (i52 == i8) {
                                                                                                                                                                    if (i9 == i14) {
                                                                                                                                                                        iVar = h.h(d02, i21, i, z3, i4, a5);
                                                                                                                                                                    } else {
                                                                                                                                                                        str2 = 76;
                                                                                                                                                                        if (i50 == stringBuilder && i51 == str2 && i52 == str2 && i9 == i27) {
                                                                                                                                                                            str2 = 76;
                                                                                                                                                                            if (i51 == str2) {
                                                                                                                                                                                if (i52 == str2) {
                                                                                                                                                                                    if (i9 == i27) {
                                                                                                                                                                                        iVar = h.m(d0Var3, i21);
                                                                                                                                                                                    } else {
                                                                                                                                                                                        iVar = h.f(d0Var3, i21, h.v(string, i50, i51, i52, i9));
                                                                                                                                                                                    }
                                                                                                                                                                                } else {
                                                                                                                                                                                }
                                                                                                                                                                            } else {
                                                                                                                                                                            }
                                                                                                                                                                        } else {
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                } else {
                                                                                                                                                                }
                                                                                                                                                            } else {
                                                                                                                                                            }
                                                                                                                                                        } else {
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                } else {
                                                                                                                                                }
                                                                                                                                            } else {
                                                                                                                                            }
                                                                                                                                        } else {
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                } else {
                                                                                                                                }
                                                                                                                            } else {
                                                                                                                            }
                                                                                                                        } else {
                                                                                                                        }
                                                                                                                    } else {
                                                                                                                    }
                                                                                                                }
                                                                                                            } else {
                                                                                                            }
                                                                                                        } else {
                                                                                                        }
                                                                                                    } else {
                                                                                                        if (i50 == i16 && i51 == i19 && i52 == stringBuilder && i9 == i14) {
                                                                                                            if (i51 == i19) {
                                                                                                                if (i52 == stringBuilder) {
                                                                                                                    if (i9 == i14) {
                                                                                                                    } else {
                                                                                                                    }
                                                                                                                } else {
                                                                                                                }
                                                                                                            } else {
                                                                                                            }
                                                                                                        } else {
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            } else {
                                                                                            }
                                                                                        } else {
                                                                                        }
                                                                                    } else {
                                                                                    }
                                                                                } else {
                                                                                }
                                                                            }
                                                                        } else {
                                                                        }
                                                                    } else {
                                                                    }
                                                                } else {
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    }
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                if (iVar == null) {
                    String str5 = h.v(string, i50, i51, i52, i9);
                    stringBuilder = new StringBuilder(length += 50);
                    stringBuilder.append("Failed to decode frame: id=");
                    stringBuilder.append(str5);
                    stringBuilder.append(", frameSize=");
                    stringBuilder.append(i21);
                    v.h(str3, stringBuilder.toString());
                }
            }
            d0Var3.I(i20);
            return iVar;
        }
        v.h(str3, "Skipping unsupported compressed or encrypted frame");
        d0Var3.I(i20);
        return i54;
    }

    private static com.google.android.exoplayer2.m2.k.g k(d0 d0, int i2) {
        int i = d0.x();
        String str = h.u(i);
        i2--;
        final byte[] bArr = new byte[obj7];
        int i4 = 0;
        d0.j(bArr, i4, obj7);
        int obj6 = h.x(bArr, i4);
        String string = new String(bArr, i4, obj6, "ISO-8859-1");
        obj6++;
        int i5 = h.w(bArr, obj6, i);
        i5 += i7;
        int i8 = h.w(bArr, i6, i);
        g gVar = new g(string, h.o(bArr, obj6, i5, str), h.o(bArr, i6, i8, str), h.c(bArr, i8 += i3, obj7));
        return gVar;
    }

    private static com.google.android.exoplayer2.m2.k.h.b l(d0 d0) {
        String valueOf;
        int i2;
        String str;
        int i3;
        int i4;
        int i;
        String obj9;
        i2 = 0;
        str = "Id3Decoder";
        if (d0.a() < 10) {
            v.h(str, "Data too short to be an ID3 tag");
            return i2;
        }
        int i6 = d0.A();
        i3 = 0;
        final int i14 = 1;
        if (i6 != 4801587) {
            obj9 = "Unexpected first three bytes of ID3 tag header: 0x";
            Object[] arr = new Object[i14];
            arr[i3] = Integer.valueOf(i6);
            valueOf = String.valueOf(String.format("%06X", arr));
            if (valueOf.length() != 0) {
                obj9 = obj9.concat(valueOf);
            } else {
                valueOf = new String(obj9);
                obj9 = valueOf;
            }
            v.h(str, obj9);
            return i2;
        }
        int i7 = d0.x();
        d0.J(i14);
        int i13 = d0.x();
        i4 = d0.w();
        final int i15 = 4;
        if (i7 == 2) {
            obj9 = i13 & 64 != 0 ? i14 : i3;
            if (obj9 != null) {
                v.h(str, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return i2;
            }
            if (i7 < i15 && i13 & 128 != 0) {
                if (i13 & 128 != 0) {
                    i3 = i14;
                }
            }
            obj9 = new h.b(i7, i3, i4);
            return obj9;
        } else {
            if (i7 == 3) {
                i2 = i13 & 64 != 0 ? i14 : i3;
                if (i2 != 0) {
                    int i9 = d0.n();
                    d0.J(i9);
                    i4 -= i2;
                }
            } else {
                if (i7 == i15) {
                    i2 = i13 & 64 != 0 ? i14 : i3;
                    if (i2 != 0) {
                        i2 = d0.w();
                        d0.J(i2 + -4);
                        i4 -= i2;
                    }
                    obj9 = i13 & 16 != 0 ? i14 : i3;
                    if (obj9 != null) {
                        i4 += -10;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder(57);
        stringBuilder.append("Skipped ID3 tag with unsupported majorVersion=");
        stringBuilder.append(i7);
        v.h(str, stringBuilder.toString());
        return i2;
    }

    private static com.google.android.exoplayer2.m2.k.k m(d0 d0, int i2) {
        int i;
        int i4;
        int i3;
        int i5 = d0.x();
        int i9 = d0.x();
        c0 c0Var = new c0();
        c0Var.l(d0);
        obj11 /= obj10;
        int[] obj10 = new int[obj11];
        final int[] iArr3 = new int[obj11];
        i = 0;
        while (i < obj11) {
            obj10[i] = c0Var.h(i5);
            iArr3[i] = c0Var.h(i9);
            i++;
        }
        super(d0.D(), d0.A(), d0.A(), obj10, iArr3);
        return obj11;
    }

    private static com.google.android.exoplayer2.m2.k.l n(d0 d0, int i2) {
        final byte[] bArr = new byte[i2];
        final int i = 0;
        d0.j(bArr, i, i2);
        int obj4 = h.x(bArr, i);
        String string = new String(bArr, i, obj4, "ISO-8859-1");
        l obj5 = new l(string, h.c(bArr, obj4++, i2));
        return obj5;
    }

    private static String o(byte[] bArr, int i2, int i3, String string4) {
        int length;
        if (i3 > i2 && i3 > bArr.length) {
            if (i3 > bArr.length) {
            }
            String string = new String(bArr, i2, i3 -= i2, string4);
            return string;
        }
        return "";
    }

    private static com.google.android.exoplayer2.m2.k.m p(d0 d0, int i2, String string3) {
        final int i = 0;
        int i3 = 1;
        if (i2 < i3) {
            return i;
        }
        final int i4 = d0.x();
        i2 -= i3;
        byte[] bArr = new byte[obj6];
        final int i5 = 0;
        d0.j(bArr, i5, obj6);
        String obj6 = new String(bArr, i5, h.w(bArr, i5, i4), h.u(i4));
        m obj5 = new m(string3, i, obj6);
        return obj5;
    }

    private static com.google.android.exoplayer2.m2.k.m q(d0 d0, int i2) {
        int i = 1;
        if (i2 < i) {
            return null;
        }
        int i3 = d0.x();
        final String str2 = h.u(i3);
        i2 -= i;
        byte[] bArr = new byte[obj5];
        int i5 = 0;
        d0.j(bArr, i5, obj5);
        int obj4 = h.w(bArr, i5, i3);
        String obj5 = new String(bArr, i5, obj4, str2);
        obj4 += i6;
        m mVar = new m("TXXX", obj5, h.o(bArr, obj4, h.w(bArr, obj4, i3), str2));
        return mVar;
    }

    private static com.google.android.exoplayer2.m2.k.n r(d0 d0, int i2, String string3) {
        byte[] bArr = new byte[i2];
        final int i3 = 0;
        d0.j(bArr, i3, i2);
        String obj4 = new String(bArr, i3, h.x(bArr, i3), "ISO-8859-1");
        n obj3 = new n(string3, 0, obj4);
        return obj3;
    }

    private static com.google.android.exoplayer2.m2.k.n s(d0 d0, int i2) {
        int i = 1;
        if (i2 < i) {
            return null;
        }
        int i3 = d0.x();
        i2 -= i;
        byte[] bArr = new byte[obj5];
        final int i6 = 0;
        d0.j(bArr, i6, obj5);
        int obj4 = h.w(bArr, i6, i3);
        String obj5 = new String(bArr, i6, obj4, h.u(i3));
        obj4 += i4;
        n nVar = new n("WXXX", obj5, h.o(bArr, obj4, h.x(bArr, obj4), "ISO-8859-1"));
        return nVar;
    }

    private static int t(int i) {
        int i2;
        int obj1;
        if (i != 0) {
            if (i == 3) {
                obj1 = 1;
            } else {
                obj1 = 2;
            }
        } else {
        }
        return obj1;
    }

    private static String u(int i) {
        if (i != 1 && i != 2 && i != 3) {
            if (i != 2) {
                if (i != 3) {
                    return "ISO-8859-1";
                }
                return "UTF-8";
            }
            return "UTF-16BE";
        }
        return "UTF-16";
    }

    private static String v(int i, int i2, int i3, int i4, int i5) {
        Object[] arr;
        String obj5;
        String obj6;
        Object[] obj9;
        final int i6 = 3;
        final int i7 = 1;
        final int i8 = 0;
        final int i9 = 2;
        if (i == i9) {
            obj9 = new Object[i6];
            obj9[i8] = Integer.valueOf(i2);
            obj9[i7] = Integer.valueOf(i3);
            obj9[i9] = Integer.valueOf(i4);
            obj5 = String.format(Locale.US, "%c%c%c", obj9);
        } else {
            arr = new Object[4];
            arr[i8] = Integer.valueOf(i2);
            arr[i7] = Integer.valueOf(i3);
            arr[i9] = Integer.valueOf(i4);
            arr[i6] = Integer.valueOf(i5);
            obj5 = String.format(Locale.US, "%c%c%c%c", arr);
        }
        return obj5;
    }

    private static int w(byte[] bArr, int i2, int i3) {
        int i;
        int i4;
        int obj4;
        if (i3 != 0 && i3 == 3) {
            if (i3 == 3) {
            }
            return bArr.length;
        }
        return h.x(bArr, i2);
    }

    private static int x(byte[] bArr, int i2) {
        for (byte b : bArr) {
        }
        return bArr.length;
    }

    static boolean y(int i, int i2, int i3, int i4, int i5) {
        return 0;
    }

    private static int z(d0 d0, int i2) {
        int i5;
        int i3;
        int i4;
        int i;
        int obj6;
        final byte[] bArr = d0.d();
        final int obj5 = d0.e();
        i5 = obj5;
        i3 = i5 + 1;
        while (i3 < obj5 + obj6) {
            i = 255;
            if (b &= i == i && bArr[i3] == 0) {
            }
            i5 = i3;
            i3 = i5 + 1;
            if (bArr[i3] == 0) {
            }
            System.arraycopy(bArr, i5 += 2, bArr, i3, i8 += -2);
            obj6--;
        }
        return obj6;
    }

    @Override // com.google.android.exoplayer2.m2.g
    protected a b(d d, ByteBuffer byteBuffer2) {
        return d(byteBuffer2.array(), byteBuffer2.limit());
    }

    @Override // com.google.android.exoplayer2.m2.g
    public a d(byte[] bArr, int i2) {
        boolean z;
        int i4;
        int i;
        int i3;
        int obj8;
        ArrayList arrayList = new ArrayList();
        d0 d0Var = new d0(bArr, i2);
        com.google.android.exoplayer2.m2.k.h.b obj7 = h.l(d0Var);
        obj8 = 0;
        if (obj7 == null) {
            return obj8;
        }
        i4 = h.b.a(obj7) == 2 ? 6 : 10;
        i = h.b.b(obj7);
        if (h.b.c(obj7)) {
            i = h.z(d0Var, h.b.b(obj7));
        }
        d0Var.H(i6 += i);
        int i13 = 1;
        int i12 = 4;
        if (!h.A(d0Var, h.b.a(obj7), i4, false) && h.b.a(obj7) == i12 && h.A(d0Var, i12, i4, i13)) {
            i12 = 4;
            if (h.b.a(obj7) == i12) {
                if (h.A(d0Var, i12, i4, i13)) {
                    i3 = i13;
                }
            }
            StringBuilder stringBuilder = new StringBuilder(56);
            stringBuilder.append("Failed to validate ID3 tag with majorVersion=");
            stringBuilder.append(h.b.a(obj7));
            v.h("Id3Decoder", stringBuilder.toString());
            return obj8;
        }
        while (d0Var.a() >= i4) {
            obj8 = h.j(h.b.a(obj7), d0Var, i3, i4, this.a);
            if (obj8 != null) {
            }
            arrayList.add(obj8);
        }
        obj7 = new a(arrayList);
        return obj7;
    }
}
