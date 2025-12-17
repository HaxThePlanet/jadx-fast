package com.bumptech.glide.n;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class e implements com.bumptech.glide.n.a {

    private static final String u = "e";
    private int[] a;
    private final int[] b;
    private final com.bumptech.glide.n.a.a c;
    private ByteBuffer d;
    private byte[] e;
    private short[] f;
    private byte[] g;
    private byte[] h;
    private byte[] i;
    private int[] j;
    private int k;
    private com.bumptech.glide.n.c l;
    private Bitmap m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    private Boolean s;
    private Bitmap.Config t;
    static {
    }

    public e(com.bumptech.glide.n.a.a a$a) {
        super();
        this.b = new int[256];
        this.t = Bitmap.Config.ARGB_8888;
        this.c = a;
        c obj2 = new c();
        this.l = obj2;
    }

    public e(com.bumptech.glide.n.a.a a$a, com.bumptech.glide.n.c c2, ByteBuffer byteBuffer3, int i4) {
        super(a);
        p(c2, byteBuffer3, i4);
    }

    private int h(int i, int i2, int i3) {
        int i4;
        int i11;
        int i7;
        int i5;
        int i9;
        int i10;
        int i6;
        int i8;
        int length2;
        int[] length;
        int obj12;
        final int i12 = 0;
        i4 = i;
        i6 = i10;
        while (i4 < i19 += i) {
            length2 = this.i;
            if (i4 < length2.length) {
            }
            if (i4 < i2) {
            }
            i8 = this.a[b2 &= 255];
            if (i8 != 0) {
            }
            i4++;
            i7 += i27;
            i5 += i29;
            i9 += length;
            i10 += i8;
            i6++;
        }
        i += i3;
        obj12 = obj10;
        while (obj12 < i13 += obj10) {
            i11 = this.i;
            if (obj12 < i11.length) {
            }
            if (obj12 < i2) {
            }
            i4 = this.a[b &= 255];
            if (i4 != 0) {
            }
            obj12++;
            i7 += i21;
            i5 += i23;
            i9 += length2;
            i10 += i4;
            i6++;
        }
        if (i6 == 0) {
            return i12;
        }
        return obj10 |= i18;
    }

    private void i(com.bumptech.glide.n.b b) {
        Boolean valueOf;
        int i5;
        int i9;
        int i8;
        int tRUE;
        int i;
        int tRUE2;
        int i2;
        int booleanValue;
        int i3;
        int i14;
        Boolean bool2;
        int z;
        int i15;
        int i13;
        int i11;
        int i12;
        int i6;
        Boolean bool;
        int i4;
        int i7;
        int i10;
        final Object obj = this;
        Object obj2 = b;
        final int[] iArr = obj.j;
        final int i20 = obj.p;
        i16 /= i20;
        i21 /= i20;
        i23 /= i20;
        i2 = obj.k == 0 ? 1 : 0;
        final int i31 = obj.r;
        bool2 = obj.s;
        i13 = 8;
        booleanValue = 0;
        i3 = 0;
        i6 = 1;
        while (booleanValue < i5) {
            bool = bool2;
            if (obj2.e) {
            } else {
            }
            i7 = i5;
            i9 = i3;
            i3 = booleanValue;
            i3 += i8;
            i15 = 1;
            if (i20 == i15) {
            } else {
            }
            i12 = 0;
            if (i14 < obj.q) {
            } else {
            }
            i10 = i9;
            i11 = i8;
            i4 = i;
            bool2 = bool;
            booleanValue++;
            i8 = i11;
            i = i4;
            i5 = i7;
            i3 = i10;
            i14 *= i31;
            i4 = i28 + i26;
            i28 += i31;
            if (i29 < i4 + i) {
            }
            i10 = i9;
            if (i12 != 0) {
            } else {
            }
            i11 = i8;
            i8 = i4;
            while (i8 < i15) {
                tRUE2 = obj.h(i14, i19 += i14, obj2.c);
                if (tRUE2 != 0) {
                } else {
                }
                if (i2 != 0 && bool == null) {
                }
                i14 += i20;
                i8++;
                i = i4;
                if (bool == null) {
                }
                bool = tRUE2;
                iArr[i8] = tRUE2;
            }
            tRUE2 = obj.h(i14, i9, obj2.c);
            if (tRUE2 != 0) {
            } else {
            }
            if (i2 != 0 && bool == null) {
            }
            i14 += i20;
            i8++;
            i = i4;
            if (bool == null) {
            }
            bool = tRUE2;
            iArr[i8] = tRUE2;
            i9 = i4;
            while (i9 < i15) {
                tRUE = obj.a[b2 &= 255];
                if (tRUE != 0) {
                } else {
                }
                if (i2 != 0 && bool == null) {
                }
                i14 += i20;
                i9++;
                i8 = i12;
                if (bool == null) {
                }
                bool = tRUE;
                iArr[i9] = tRUE;
            }
            tRUE = iArr2[b2 &= 255];
            if (tRUE != 0) {
            } else {
            }
            if (i2 != 0 && bool == null) {
            }
            i14 += i20;
            i9++;
            i8 = i12;
            if (bool == null) {
            }
            bool = tRUE;
            iArr[i9] = tRUE;
            i15 = i29;
            i12 = i15;
            if (i3 >= i5) {
            } else {
            }
            i7 = i5;
            i9 = i3 + i13;
            i7 = i5;
            i5 = i6 + 1;
            if (i5 != 2) {
            } else {
            }
            i6 = i5;
            i3 = z;
            if (i5 != 3) {
            } else {
            }
            i6 = i5;
            i13 = z;
            i3 = 2;
            if (i5 != 4) {
            } else {
            }
            i6 = i5;
            i3 = 1;
            i13 = 2;
            i6 = i5;
        }
        Boolean bool3 = bool2;
        if (obj.s == null) {
            if (bool3 == null) {
                booleanValue = 0;
            } else {
                booleanValue = bool3.booleanValue();
            }
            obj.s = Boolean.valueOf(booleanValue);
        }
    }

    private void j(com.bumptech.glide.n.b b) {
        Object obj;
        Boolean booleanValue;
        int i;
        int i7;
        int i10;
        int i2;
        int i9;
        int i3;
        int i6;
        int i4;
        int i5;
        int i8;
        int i11;
        int i12;
        final Object obj2 = this;
        obj = b;
        i = obj.d;
        i10 = obj2.k == 0 ? 1 : 0;
        final int i19 = obj2.r;
        i4 = 0;
        i5 = -1;
        while (i4 < i) {
            i20 *= i19;
            i12 = i8 + i15;
            int i17 = i8 + i19;
            if (i17 < i12 + i14) {
            }
            i18 *= i4;
            i6 = i12;
            while (i6 < i2) {
                byte b2 = obj2.i[i3];
                i7 = b2 & 255;
                if (i7 != i5) {
                }
                i3++;
                i6++;
                obj = b;
                i = i12;
                i7 = obj2.a[i7];
                if (i7 != 0) {
                } else {
                }
                i5 = b2;
                obj2.j[i6] = i7;
            }
            i11 = i;
            i4++;
            obj = b;
            b2 = bArr[i3];
            i7 = b2 & 255;
            if (i7 != i5) {
            }
            i3++;
            i6++;
            obj = b;
            i = i12;
            i7 = iArr2[i7];
            if (i7 != 0) {
            } else {
            }
            i5 = b2;
            iArr[i6] = i7;
            i2 = i17;
        }
        booleanValue = obj2.s;
        if (booleanValue != null) {
            if (!booleanValue.booleanValue()) {
                if (obj2.s == null && i10 != 0 && i5 != -1) {
                    if (i10 != 0) {
                        i9 = i5 != -1 ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        obj2.s = Boolean.valueOf(i9);
    }

    private void k(com.bumptech.glide.n.b b) {
        Object obj;
        int i13;
        int i23;
        int length;
        ByteBuffer byteBuffer;
        int i15;
        int i11;
        short[] sArr2;
        short[] sArr;
        int i;
        int i19;
        byte i10;
        byte[] bArr;
        byte[] bArr3;
        byte[] bArr2;
        int i24;
        int i17;
        int i8;
        int i26;
        int i25;
        int i12;
        int i9;
        int i7;
        byte b2;
        int i5;
        int i2;
        int i3;
        int i6;
        int i16;
        int i20;
        int i22;
        int i18;
        int i14;
        int i4;
        int i21;
        int i27;
        int i28;
        byte[] bArr4;
        obj = this;
        Object obj2 = b;
        if (obj2 != null) {
            obj.d.position(obj2.j);
        }
        if (obj2 == null) {
            com.bumptech.glide.n.c cVar = obj.l;
            i15 = cVar.f;
            i23 = cVar.g;
        } else {
            i15 = obj2.c;
            i23 = obj2.d;
        }
        i15 *= i23;
        length = obj.i;
        if (length != null) {
            if (length.length < i30) {
                obj.i = obj.c.e(i30);
            }
        } else {
        }
        byte[] bArr5 = obj.i;
        i = 4096;
        if (obj.f == null) {
            obj.f = new short[i];
        }
        sArr = obj.f;
        if (obj.g == null) {
            obj.g = new byte[i];
        }
        byte[] bArr6 = obj.g;
        if (obj.h == null) {
            obj.h = new byte[4097];
        }
        bArr2 = obj.h;
        int i36 = o();
        i26 = 1;
        final int i37 = i26 << i36;
        i36 += i26;
        i40 -= i26;
        i9 = 0;
        i7 = i9;
        while (i7 < i37) {
            sArr[i7] = i9;
            bArr6[i7] = (byte)i7;
            i7++;
        }
        i4 = i24;
        i18 = i12;
        i21 = i41;
        i28 = i27;
        i14 = i5;
        while (i9 < i30) {
            if (i3 == 0) {
                break;
            } else {
            }
            i20 += i32;
            i6++;
            i3--;
            i19 = i43;
            i25 = i18;
            i2 = i14;
            i13 = i4;
            int i44 = i24;
            i17 = i28;
            while (i19 >= i13) {
                i4 = i12;
                int i39 = i20 & i21;
                i20 >>= i13;
                i19 -= i13;
                i28 = i19;
                if (i2 == -1) {
                } else {
                }
                if (i39 >= i25) {
                } else {
                }
                i8 = i39;
                while (i8 >= i37) {
                    bArr2[i27] = bArr6[i8];
                    i27++;
                    i8 = sArr[i8];
                }
                i10 = (byte)i17;
                bArr5[i22] = i10;
                i9++;
                while (i27 > 0) {
                    bArr5[i22++] = bArr2[i27--];
                    i9++;
                }
                int i34 = 4096;
                sArr[i25] = (short)i2;
                bArr6[i25] = i10;
                i25++;
                if (i25 < i34 && i25 & i21 == 0 && i25 < i34) {
                }
                i2 = i39;
                i12 = i4;
                i19 = i28;
                bArr2 = bArr4;
                sArr[i25] = (short)i2;
                bArr6[i25] = i10;
                i25++;
                if (i25 & i21 == 0) {
                }
                if (i25 < i34) {
                }
                i13++;
                i21 += i25;
                bArr5[i22++] = bArr2[i27--];
                bArr2[i27] = bArr6[i8];
                i27++;
                i8 = sArr[i8];
                bArr2[i27] = (byte)i17;
                i27++;
                i8 = i2;
                bArr5[i22] = bArr6[i39];
                i22++;
                i9++;
                i2 = i17;
                i12 = i4;
                i19 = i28;
                i21 = i41;
                i13 = i44;
                i12 = i25;
                i2 = -1;
            }
            i4 = i13;
            i18 = i25;
            i16 = i45;
            i = 4096;
            i26 = 1;
            obj = this;
            i28 = i17;
            i24 = i44;
            i14 = i2;
            i5 = -1;
            i4 = i12;
            i39 = i20 & i21;
            i20 >>= i13;
            i19 -= i13;
            if (i39 == i37) {
            } else {
            }
            if (i39 == i37 + 1) {
            } else {
            }
            i28 = i19;
            if (i2 == -1) {
            } else {
            }
            if (i39 >= i25) {
            } else {
            }
            i8 = i39;
            while (i8 >= i37) {
                bArr2[i27] = bArr6[i8];
                i27++;
                i8 = sArr[i8];
            }
            i10 = (byte)i17;
            bArr5[i22] = i10;
            i9++;
            while (i27 > 0) {
                bArr5[i22++] = bArr2[i27--];
                i9++;
            }
            i34 = 4096;
            sArr[i25] = (short)i2;
            bArr6[i25] = i10;
            i25++;
            if (i25 < i34 && i25 & i21 == 0 && i25 < i34) {
            }
            i2 = i39;
            i12 = i4;
            i19 = i28;
            bArr2 = bArr4;
            sArr[i25] = (short)i2;
            bArr6[i25] = i10;
            i25++;
            if (i25 & i21 == 0) {
            }
            if (i25 < i34) {
            }
            i13++;
            i21 += i25;
            bArr5[i22++] = bArr2[i27--];
            bArr2[i27] = bArr6[i8];
            i27++;
            i8 = sArr[i8];
            bArr2[i27] = (byte)i17;
            i27++;
            i8 = i2;
            bArr5[i22] = bArr6[i39];
            i22++;
            i9++;
            i2 = i17;
            i12 = i4;
            i19 = i28;
            i16 = i19;
            i28 = i17;
            i18 = i25;
            i24 = i44;
            i12 = i4;
            i = 4096;
            i26 = 1;
            i4 = i13;
            i14 = i2;
            i5 = -1;
            obj = this;
            i21 = i41;
            i13 = i44;
            i12 = i25;
            i2 = -1;
            if (n() <= 0) {
                break;
            } else {
            }
            i6 = 0;
        }
        Arrays.fill(bArr5, i22, i30, 0);
    }

    private Bitmap m() {
        Bitmap.Config config;
        Boolean booleanValue;
        booleanValue = this.s;
        if (booleanValue != null) {
            if (booleanValue.booleanValue()) {
                config = Bitmap.Config.ARGB_8888;
            } else {
                config = this.t;
            }
        } else {
        }
        Bitmap bitmap = this.c.a(this.r, this.q, config);
        bitmap.setHasAlpha(true);
        return bitmap;
    }

    private int n() {
        final int i = o();
        if (i <= 0) {
            return i;
        }
        final ByteBuffer byteBuffer = this.d;
        byteBuffer.get(this.e, 0, Math.min(i, byteBuffer.remaining()));
        return i;
    }

    private int o() {
        return b &= 255;
    }

    private Bitmap q(com.bumptech.glide.n.b b, com.bumptech.glide.n.b b2) {
        int i9;
        int i4;
        int i;
        int i5;
        com.bumptech.glide.n.c z;
        com.bumptech.glide.n.a.a aVar;
        int i6;
        int i7;
        int i8;
        int i2;
        int i3;
        Bitmap obj10;
        Object obj11;
        final int[] iArr2 = this.j;
        i9 = 0;
        Bitmap bitmap2 = this.m;
        if (b2 == null && bitmap2 != null) {
            bitmap2 = this.m;
            if (bitmap2 != null) {
                this.c.c(bitmap2);
            }
            this.m = 0;
            Arrays.fill(iArr2, i9);
        }
        i5 = 3;
        if (b2 != null && b2.g == i5 && this.m == null) {
            if (b2.g == i5) {
                if (this.m == null) {
                    Arrays.fill(iArr2, i9);
                }
            }
        }
        aVar = b2.g;
        if (b2 != null && aVar > 0) {
            aVar = b2.g;
            if (aVar > 0) {
                if (aVar == 2) {
                    if (!b.f) {
                        z = this.l;
                        if (b.k != null && z.j == b.h) {
                            if (z.j == b.h) {
                            } else {
                                i9 = aVar;
                            }
                        } else {
                        }
                    }
                    int i14 = this.p;
                    aVar = this.r;
                    while (i6 < i12 += i6) {
                        aVar = i6;
                        while (aVar < i6 + i7) {
                            iArr2[aVar] = i9;
                            aVar++;
                        }
                        i6 += obj11;
                        iArr2[aVar] = i9;
                        aVar++;
                    }
                } else {
                    i9 = this.m;
                    if (aVar == i5 && i9 != null) {
                        i9 = this.m;
                        if (i9 != null) {
                            i2 = this.r;
                            i9.getPixels(iArr2, 0, i2, 0, 0, i2, this.q);
                        }
                    }
                }
            }
        }
        k(b);
        i4 = 1;
        if (!b.e) {
            if (this.p != i4) {
                i(b);
            } else {
                j(b);
            }
        } else {
        }
        if (this.n) {
            obj10 = b.g;
            if (obj10 != null) {
                if (obj10 == i4 && this.m == null) {
                    if (this.m == null) {
                        this.m = m();
                    }
                    i2 = this.r;
                    this.m.setPixels(iArr2, 0, i2, 0, 0, i2, this.q);
                }
            } else {
            }
        }
        obj10 = m();
        int i22 = this.r;
        obj10.setPixels(iArr2, 0, i22, 0, 0, i22, this.q);
        return obj10;
    }

    @Override // com.bumptech.glide.n.a
    public Bitmap a() {
        int i;
        int tRUE;
        boolean loggable3;
        boolean z;
        boolean loggable2;
        int i2;
        boolean loggable;
        int i4;
        byte[] bArr;
        int i3;
        Object obj;
        List list;
        int[] iArr;
        int i6 = 3;
        i2 = 1;
        synchronized (this) {
            try {
                i = e.u;
                if (this.k < 0 && Log.isLoggable(i, i6)) {
                }
                i = e.u;
                if (Log.isLoggable(i, i6)) {
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Unable to decode frame, frameCount=");
                stringBuilder3.append(cVar2.c);
                stringBuilder3.append(", framePointer=");
                stringBuilder3.append(this.k);
                Log.d(i, stringBuilder3.toString());
                this.o = i2;
                int i5 = this.o;
                int i7 = 0;
                if (i5 != i2) {
                }
                i4 = 2;
                if (i5 == i4) {
                } else {
                }
                tRUE = 0;
                this.o = tRUE;
                if (this.e == null) {
                }
                this.e = this.c.e(255);
                Object obj2 = cVar3.e.get(this.k);
                i10 -= i2;
                if (i11 >= 0) {
                } else {
                }
                obj = cVar4.e.get(i11);
                obj = i7;
                if (obj2.k != null) {
                } else {
                }
                iArr = cVar5.a;
                this.a = iArr;
                String str = e.u;
                if (iArr == null && Log.isLoggable(str, i6)) {
                }
                str = e.u;
                if (Log.isLoggable(str, i6)) {
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("No valid color table found for frame #");
                stringBuilder.append(this.k);
                Log.d(str, stringBuilder.toString());
                this.o = i2;
                return i7;
                System.arraycopy(iArr, tRUE, this.b, tRUE, iArr.length);
                z = this.b;
                this.a = z;
                z[obj2.h] = tRUE;
                if (obj2.f && obj2.g == i4 && this.k == 0) {
                }
                System.arraycopy(iArr, tRUE, this.b, tRUE, iArr.length);
                z = this.b;
                this.a = z;
                z[obj2.h] = tRUE;
                if (obj2.g == i4) {
                }
                if (this.k == 0) {
                }
                this.s = Boolean.TRUE;
                return q((b)obj2, obj);
                String str2 = e.u;
                if (Log.isLoggable(str2, i6)) {
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Unable to decode frame, status=");
                stringBuilder2.append(this.o);
                Log.d(str2, stringBuilder2.toString());
                return i7;
                throw th;
            }
        }
    }

    @Override // com.bumptech.glide.n.a
    public void b() {
        this.k = i2 %= i4;
    }

    @Override // com.bumptech.glide.n.a
    public int c() {
        return cVar.c;
    }

    @Override // com.bumptech.glide.n.a
    public void clear() {
        Object bitmap;
        com.bumptech.glide.n.a.a aVar;
        int i = 0;
        this.l = i;
        byte[] bArr2 = this.i;
        if (bArr2 != null) {
            this.c.d(bArr2);
        }
        int[] iArr = this.j;
        if (iArr != null) {
            this.c.f(iArr);
        }
        bitmap = this.m;
        if (bitmap != null) {
            this.c.c(bitmap);
        }
        this.m = i;
        this.d = i;
        this.s = i;
        byte[] bArr = this.e;
        if (bArr != null) {
            this.c.d(bArr);
        }
    }

    @Override // com.bumptech.glide.n.a
    public int d() {
        int i;
        i = this.k;
        if (cVar.c > 0 && i < 0) {
            i = this.k;
            if (i < 0) {
            }
            return l(i);
        }
        return 0;
    }

    @Override // com.bumptech.glide.n.a
    public void e(Bitmap.Config bitmap$Config) {
        Bitmap.Config config2;
        if (config != Bitmap.Config.ARGB_8888) {
            if (config != Bitmap.Config.RGB_565) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported format: ");
            stringBuilder.append(config);
            stringBuilder.append(", must be one of ");
            stringBuilder.append(Bitmap.Config.ARGB_8888);
            stringBuilder.append(" or ");
            stringBuilder.append(Bitmap.Config.RGB_565);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        this.t = config;
    }

    @Override // com.bumptech.glide.n.a
    public void f() {
        this.k = -1;
    }

    @Override // com.bumptech.glide.n.a
    public int g() {
        return this.k;
    }

    @Override // com.bumptech.glide.n.a
    public int getByteSize() {
        return i += i3;
    }

    @Override // com.bumptech.glide.n.a
    public ByteBuffer getData() {
        return this.d;
    }

    @Override // com.bumptech.glide.n.a
    public int l(int i) {
        com.bumptech.glide.n.c cVar;
        int i2;
        int obj3;
        cVar = this.l;
        if (i >= 0 && i < cVar.c) {
            cVar = this.l;
            if (i < cVar.c) {
                obj3 = obj3.i;
            } else {
                obj3 = -1;
            }
        } else {
        }
        return obj3;
    }

    @Override // com.bumptech.glide.n.a
    public void p(com.bumptech.glide.n.c c, ByteBuffer byteBuffer2, int i3) {
        int next;
        ByteOrder lITTLE_ENDIAN;
        Iterator obj4;
        synchronized (this) {
            int obj5 = Integer.highestOneBit(i3);
            next = 0;
            this.o = next;
            this.l = c;
            this.k = -1;
            obj4 = byteBuffer2.asReadOnlyBuffer();
            this.d = obj4;
            obj4.position(next);
            this.d.order(ByteOrder.LITTLE_ENDIAN);
            this.n = next;
            obj4 = c.e.iterator();
            while (obj4.hasNext()) {
                if (next2.g == 3) {
                    break;
                } else {
                }
            }
            this.p = obj5;
            obj4 = c.f;
            this.r = obj4 / obj5;
            int obj3 = c.g;
            this.q = obj3 / obj5;
            this.i = this.c.e(obj4 *= obj3);
            this.j = this.c.b(obj4 *= obj5);
        }
    }
}
