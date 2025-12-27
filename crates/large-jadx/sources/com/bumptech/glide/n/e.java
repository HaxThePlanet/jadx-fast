package com.bumptech.glide.n;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: StandardGifDecoder.java */
/* loaded from: classes.dex */
public class e implements a {

    private static final String u = "e";
    private int[] a;
    private final int[] b;
    private final a.a c;
    private ByteBuffer d;
    private byte[] e;
    private short[] f;
    private byte[] g;
    private byte[] h;
    private byte[] i;
    private int[] j;
    private int k;
    private c l;
    private Bitmap m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    private Boolean s;
    private Bitmap.Config t;
    public e(a.a aVar, c cVar, ByteBuffer byteBuffer, int i) {
        this(aVar);
        p(cVar, byteBuffer, i);
    }

    private int h(int i, int i2, int i3) {
        int i5;
        int i4;
        int length;
        int i7;
        int[] iArr;
        int i8;
        i4 = 0;
        i5 = i;
        length = this.p + i;
        while (i5 < this.p + i) {
            length2 = bArr2.length;
        }
        i += i3;
        i6 = this.p + i8;
        while (i8 < this.p + i8) {
            length = bArr.length;
        }
        if (i4 == 0) {
            return i4;
        }
        return (i4 / i4) << 24 | (i4 / i4) << 16 | (i4 / i4) << 8 | (i4 / i4);
    }

    private void i(b bVar) {
        int i;
        int i2;
        int i5 = 0;
        boolean booleanValue = false;
        int i6;
        Boolean tRUE2;
        final Object bVar3 = this;
        Object bVar2 = bVar;
        i = bVar2.d / i11;
        i2 = bVar2.b / i11;
        i2 = bVar2.c / i11;
        int r8 = bVar3.k == 0 ? 1 : 0;
        i2 = 8;
        i2 = 0;
        i2 = 0;
        i = 1;
        while (i2 < bVar2.d) {
            i6 = i2 + i2;
            i2 = 1;
            int r17 = bVar3.p == i2 ? i2 : 0;
            i2 = i2 + 1;
        }
        if (bVar3.s == null && tRUE2 == null) {
            int i19 = 0;
            bVar3.s = Boolean.valueOf(booleanValue);
        }
    }

    private void j(b bVar) {
        Object bVar2;
        Boolean bool2;
        int i = -1;
        int i2;
        int i4 = 1;
        boolean z = false;
        int i5;
        int i6;
        int i7 = 0;
        int i8 = -1;
        final Object bVar3 = this;
        bVar2 = bVar;
        int r7 = bVar3.k == 0 ? 1 : 0;
        i7 = 0;
        i8 = -1;
        while (i7 < bVar2.d) {
            i9 = (i7 + bVar2.b) * i17;
            i2 = i9 + bVar2.a;
            i5 = i2 + bVar2.c;
            i5 = i9 + i17;
            i6 = bVar2.c * i7;
            while (i2 < i5) {
                byte b = bVar3.i[i6];
                i3 = b & 255;
                i6 = i6 + 1;
                i2 = i2 + 1;
                bVar2 = bVar;
            }
            i7 = i7 + 1;
            bVar2 = bVar;
            b = bArr[i6];
            i3 = b & 255;
            i6 = i6 + 1;
            i2 = i2 + 1;
            bVar2 = bVar;
        }
        if (bVar3.s == null || !bVar3.s.booleanValue()) {
            int r8 = bVar3.s == null && bVar3.k != 0 && i8 != -1 ? 1 : 0;
        }
        bVar3.s = Boolean.valueOf((bVar3.s == null && bVar3.k != 0 && i8 != -1 ? 1 : 0));
    }

    private void k(b bVar) {
        Object obj;
        int i;
        int i2;
        int i3;
        int i6;
        byte[] bArr4;
        short s;
        int i7;
        int i10;
        int i9;
        obj = this;
        Object bVar2 = bVar;
        if (bVar2 != null) {
            obj.d.position(bVar2.j);
        }
        if (bVar2 == null) {
        } else {
        }
        i3 *= i2;
        if (obj.i != null) {
            length = bArr.length;
            if (bArr.length < bVar2.c) {
                obj.i = obj.c.e(i12);
            }
        }
        int i5 = 4096;
        if (obj.f == null) {
            obj.f = new short[i5];
        }
        if (obj.g == null) {
            obj.g = new byte[i5];
        }
        if (obj.h == null) {
            obj.h = new byte[4097];
        }
        int i20 = o();
        int i8 = 1;
        final int i21 = i8 << i20;
        i = i21 + 2;
        i = i20 + i8;
        i9 = (i8 << i) - i8;
        s = (short) 0;
        i10 = s;
        while (i10 < i21) {
            obj.f[i10] = s;
            b2 = (byte)i10;
            obj.g[i10] = b2;
            i10 = i10 + 1;
        }
        i7 = -1;
        while (s < bVar2.c) {
            if (s != 0 || this.n() <= 0) {
            }
        }
        Arrays.fill(obj.i, s, i12, (byte) 0);
    }

    private Bitmap m() {
        Bitmap.Config config;
        if (this.s == null || this.s.booleanValue()) {
            config = Bitmap.Config.ARGB_8888;
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
        this.d.get(this.e, 0, Math.min(i, this.d.remaining()));
        return i;
    }

    private int o() {
        return this.d.get() & 255;
    }

    private Bitmap q(b bVar, b bVar2) {
        int i = 0;
        int i3 = 3;
        com.bumptech.glide.n.c cVar;
        com.bumptech.glide.n.a.a aVar;
        int i4;
        int[] iArr2;
        int i6 = 0;
        int i7 = 0;
        int i8;
        Bitmap bitmap2;
        boolean z2;
        int i9;
        i = 0;
        if (bVar2 == null && this.m != null) {
            this.c.c(this.m);
            Bitmap bitmap = null;
            this.m = bitmap;
            Arrays.fill(this.j, i);
        }
        i3 = 3;
        if (bVar2 != null && bVar2.g == i3 && this.m == null) {
            Arrays.fill(this.j, i);
        }
        if (bVar2 != null && bVar2.g > 0 && bVar2.g == 2 && !bVar.f) {
            if (bVar.k != null) {
                if (cVar.j != bVar.h) {
                }
            }
            i6 = bVar2.c / i19;
            i9 = bVar2.a / i19;
            i4 = (bVar2.b / i19) * i4 + i9;
            i3 = (bVar2.d / i19) * i4 + i4;
            while (bVar.h < bVar.f) {
                while (cVar.l < i4 + i6) {
                    this.j[i4] = i;
                    i4 = i4 + 1;
                }
                i4 = i4 + this.r;
                this.j[i4] = i;
                i4 = i4 + 1;
            }
        }
        k(bVar);
        int i2 = 1;
        if (bVar.e || this.p != i2) {
            i(bVar);
        }
        if (this.n && bVar.g != 0 && bVar.g == i2 && this.m == null) {
            this.m = m();
            i6 = 0;
            i7 = 0;
            this.m.setPixels(iArr, 0, i4, i6, i7, this.r, this.q);
        }
        Bitmap bVar3 = m();
        bVar3.setPixels(iArr, 0, i5, 0, 0, this.r, this.q);
        return bVar3;
    }

    public synchronized Bitmap a() {
        boolean loggable3;
        int i5;
        com.bumptech.glide.n.b bVar;
        int[] iArr;
        int i8 = 3;
        int i3 = 1;
        if (this.l.c <= 0 || this.k < 0) {
            str = e.u;
            if (Log.isLoggable(str, i8)) {
                StringBuilder stringBuilder3 = new StringBuilder();
                String str8 = "Unable to decode frame, frameCount=";
                String str9 = ", framePointer=";
                str7 = str8 + this.l.c + str9 + this.k;
                Log.d(e.u, str7);
            }
            this.o = i3;
        }
        int i4 = 0;
        i5 = 2;
        int i2 = 0;
        this.o = i2;
        if (this.e == null) {
            int i6 = 255;
            this.e = this.c.e(i6);
        }
        Object item = this.l.e.get(this.k);
        int i12 = this.k - i3;
        if (this.k >= 0) {
            Object item2 = this.l.e.get(i12);
        } else {
        }
        if (item.k == null) {
        }
        this.a = iArr;
        String str3 = e.u;
        if (Log.isLoggable(str3, i8)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            String str10 = "No valid color table found for frame #";
            str5 = str10 + this.k;
            Log.d(e.u, str5);
        }
        this.o = i3;
        String str2 = e.u;
        if (Log.isLoggable(str2, i8)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str6 = "Unable to decode frame, status=";
            str4 = str6 + this.o;
            Log.d(e.u, str4);
        }
        return i4;
    }

    public void b() {
        this.k = (this.k + 1) % this.l.c;
    }

    public int c() {
        return this.l.c;
    }

    public void clear() {
        com.bumptech.glide.n.a.a aVar;
        com.bumptech.glide.n.c cVar = null;
        this.l = cVar;
        if (this.i != null) {
            this.c.d(this.i);
        }
        if (this.j != null) {
            this.c.f(this.j);
        }
        if (this.m != null) {
            this.c.c(this.m);
        }
        this.m = cVar;
        this.d = cVar;
        this.s = cVar;
        if (this.e != null) {
            this.c.d(this.e);
        }
    }

    public int d() {
        return 0;
    }

    public void e(Bitmap.Config config) {
        this.t = config;
    }

    public void f() {
        this.k = -1;
    }

    public int g() {
        return this.k;
    }

    public int getByteSize() {
        return (this.d.limit() + this.i.length) + (this.j.length * 4);
    }

    public ByteBuffer getData() {
        return this.d;
    }

    public int l(int i) {
        com.bumptech.glide.n.c cVar;
        int i2;
        int i3 = -1;
        if (i >= 0) {
            if (i < cVar.c) {
            } else {
                i3 = -1;
            }
        }
        return i3;
    }

    public synchronized void p(c cVar, ByteBuffer byteBuffer, int i) {
        ByteOrder lITTLE_ENDIAN2;
        if (i <= 0) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                String str = "Sample size must be >=0, not: ";
                byteBuffer = str + i;
                throw new IllegalArgumentException(byteBuffer);
            } catch (Throwable th) {
            }
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) th;
        } else {
            try {
                int highestOneBit = Integer.highestOneBit(i);
                i = 0;
                this.o = i;
                this.l = th;
                this.k = -1;
                ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.d = readOnlyBuffer;
                readOnlyBuffer.position(i);
                this.d.order(ByteOrder.LITTLE_ENDIAN);
                this.n = false;
                Iterator it = th.e.iterator();
                while (it.hasNext()) {
                    lITTLE_ENDIAN2 = 3;
                    if ((b)it.next().g == 3) {
                        this.n = true;
                    }
                }
                this.n = true;
                this.p = highestOneBit;
                this.r = i6 / highestOneBit;
                this.q = i5 / highestOneBit;
                this.i = this.c.e(i6 * i5);
                this.j = this.c.b(this.r * this.q);
            } catch (Throwable th) {
            }
            return;
        }
    }

    public e(a.a aVar) {
        super();
        this.b = new int[256];
        this.t = Bitmap.Config.ARGB_8888;
        this.c = aVar;
        this.l = new c();
    }

}
