package com.google.android.exoplayer2.m2.h;

import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.m2.d;
import com.google.android.exoplayer2.m2.g;
import com.google.android.exoplayer2.util.c0;
import com.google.common.base.d;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class b extends g {
    private static a c(c0 c0) {
        int aVar2;
        int aVar;
        int i5;
        int valueOf;
        int length;
        int i;
        int i3;
        int i2;
        int i4;
        final int i6 = 12;
        c0.q(i6);
        int i8 = 4;
        c0.q(44);
        c0.r(c0.h(i6));
        int i14 = 16;
        c0.q(i14);
        ArrayList arrayList = new ArrayList();
        while (c0.d() < i10 -= i8) {
            c0.q(48);
            aVar2 = 8;
            c0.q(i8);
            i19 += i18;
            valueOf = aVar;
            while (c0.d() < i20) {
                i = c0.h(aVar2);
                i3 = c0.h(aVar2);
                i21 += i3;
                if (i == 2) {
                } else {
                }
                if (i == 21) {
                }
                c0.o(i22 *= 8);
                valueOf = c0.k(i3, d.a);
                c0.q(aVar2);
                if (c0.h(i14) == 3) {
                }
                while (c0.d() < i22) {
                    aVar = c0.k(c0.h(aVar2), d.a);
                    i3 = 0;
                    while (i3 < c0.h(aVar2)) {
                        c0.r(c0.h(aVar2));
                        i3++;
                    }
                    c0.r(c0.h(aVar2));
                    i3++;
                }
                aVar = c0.k(c0.h(aVar2), d.a);
                i3 = 0;
                while (i3 < c0.h(aVar2)) {
                    c0.r(c0.h(aVar2));
                    i3++;
                }
                c0.r(c0.h(aVar2));
                i3++;
            }
            c0.o(i20 *= 8);
            if (aVar != 0 && valueOf != 0) {
            }
            if (valueOf != 0) {
            }
            String valueOf2 = String.valueOf(aVar);
            valueOf = String.valueOf(valueOf);
            if (valueOf.length() != 0) {
            } else {
            }
            valueOf = new String(valueOf2);
            aVar = valueOf;
            aVar2 = new a(c0.h(aVar2), aVar);
            arrayList.add(aVar2);
            aVar = valueOf2.concat(valueOf);
            i = c0.h(aVar2);
            i3 = c0.h(aVar2);
            i21 += i3;
            if (i == 2) {
            } else {
            }
            if (i == 21) {
            }
            c0.o(i22 *= 8);
            valueOf = c0.k(i3, d.a);
            c0.q(aVar2);
            if (c0.h(i14) == 3) {
            }
            while (c0.d() < i22) {
                aVar = c0.k(c0.h(aVar2), d.a);
                i3 = 0;
                while (i3 < c0.h(aVar2)) {
                    c0.r(c0.h(aVar2));
                    i3++;
                }
                c0.r(c0.h(aVar2));
                i3++;
            }
            aVar = c0.k(c0.h(aVar2), d.a);
            i3 = 0;
            while (i3 < c0.h(aVar2)) {
                c0.r(c0.h(aVar2));
                i3++;
            }
            c0.r(c0.h(aVar2));
            i3++;
        }
        if (arrayList.isEmpty()) {
        } else {
            aVar = new a(arrayList);
        }
        return aVar;
    }

    @Override // com.google.android.exoplayer2.m2.g
    protected a b(d d, ByteBuffer byteBuffer2) {
        byte[] array;
        a obj2;
        int obj3;
        if (byteBuffer2.get() == 116) {
            obj2 = new c0(byteBuffer2.array(), byteBuffer2.limit());
            obj2 = b.c(obj2);
        } else {
            obj2 = 0;
        }
        return obj2;
    }
}
