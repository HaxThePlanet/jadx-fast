package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.j;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class m {

    public final List<byte[]> a;
    public final int b;
    public final float c;
    public final String d;
    private m(List<byte[]> list, int i2, int i3, int i4, float f5, String string6) {
        super();
        this.a = list;
        this.b = i2;
        this.c = f5;
        this.d = string6;
    }

    private static byte[] a(d0 d0) {
        final int i = d0.D();
        d0.J(i);
        return j.d(d0.d(), d0.e(), i);
    }

    public static com.google.android.exoplayer2.video.m b(d0 d0) {
        int i6;
        int i9;
        int i8;
        int i4;
        byte[] bArr2;
        int i;
        int i2;
        byte[] bArr;
        int i3;
        int i5;
        int i7;
        int obj9;
        d0.J(4);
        int i14 = 3;
        final int i16 = i12 + 1;
        if (i16 == i14) {
        } else {
            try {
                ArrayList arrayList = new ArrayList();
                i13 &= 31;
                i9 = 0;
                i8 = i9;
                while (i8 < i6) {
                    arrayList.add(m.a(d0));
                    i8++;
                }
                arrayList.add(m.a(d0));
                i8++;
                i = i9;
                while (i < d0.x()) {
                    arrayList.add(m.a(d0));
                    i++;
                }
                arrayList.add(m.a(d0));
                i++;
                if (i6 > 0) {
                } else {
                }
                obj9 = a0.i((byte[])arrayList.get(i9), i16, obj9.length);
                i7 = obj9;
                i2 = i6;
                i3 = i9;
                i5 = i4;
                i5 = obj9;
                i7 = i4;
                i3 = i2;
                super(arrayList, i16, i2, i3, i5, i7);
                return obj9;
                obj9 = new IllegalStateException();
                throw obj9;
                d0 = ParserException.a("Error parsing AVC config", d0);
                throw d0;
            }
        }
    }
}
