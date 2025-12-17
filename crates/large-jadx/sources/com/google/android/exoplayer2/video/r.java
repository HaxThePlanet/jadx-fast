package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.e0;
import com.google.android.exoplayer2.util.j;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class r {

    public final List<byte[]> a;
    public final int b;
    public final String c;
    private r(List<byte[]> list, int i2, String string3) {
        super();
        this.a = list;
        this.b = i2;
        this.c = string3;
    }

    public static com.google.android.exoplayer2.video.r a(d0 d0) {
        int i10;
        List singletonList;
        int i2;
        int i4;
        int i13;
        int i14;
        int i3;
        int i;
        int i5;
        int i8;
        int i6;
        int i12;
        int i11;
        int i7;
        int i9;
        Throwable obj = d0;
        obj.J(21);
        final int i19 = d0.x();
        final int i21 = 0;
        i2 = i10;
        int i22 = 1;
        while (i10 < i19) {
            obj.J(i22);
            i13 = i21;
            while (i13 < d0.D()) {
                i3 = d0.D();
                i2 += i5;
                obj.J(i3);
                i13++;
            }
            i10++;
            i22 = 1;
            i3 = d0.D();
            i2 += i5;
            obj.J(i3);
            i13++;
        }
        obj.I(d0.e());
        byte[] bArr = new byte[i2];
        i8 = i14;
        i = 0;
        while (i14 < i19) {
            i11 = i21;
            while (i11 < d0.D()) {
                i7 = d0.D();
                byte[] bArr3 = a0.a;
                System.arraycopy(bArr3, i21, bArr, i8, bArr3.length);
                i8 += length2;
                System.arraycopy(d0.d(), d0.e(), bArr, i24, i7);
                if (i25 &= 127 == 33 && i11 == 0) {
                }
                i24 += i7;
                obj.J(i7);
                i11++;
                if (i11 == 0) {
                }
                e0 e0Var = new e0(bArr, i24, i24 + i7);
                i = i10;
            }
            i14++;
            i7 = d0.D();
            bArr3 = a0.a;
            System.arraycopy(bArr3, i21, bArr, i8, bArr3.length);
            i8 += length2;
            System.arraycopy(d0.d(), d0.e(), bArr, i24, i7);
            if (i25 &= 127 == 33 && i11 == 0) {
            }
            i24 += i7;
            obj.J(i7);
            i11++;
            if (i11 == 0) {
            }
            e0Var = new e0(bArr, i24, i24 + i7);
            i = i10;
        }
        if (i2 == 0) {
            singletonList = 0;
        } else {
            singletonList = Collections.singletonList(bArr);
        }
        r rVar = new r(singletonList, i17 += i22, i);
        return rVar;
    }
}
