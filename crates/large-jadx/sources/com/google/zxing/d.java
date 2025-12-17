package com.google.zxing;

import com.google.zxing.f.a;
import com.google.zxing.g.b;
import com.google.zxing.h.a;
import com.google.zxing.i.b;
import com.google.zxing.i.d;
import com.google.zxing.i.f;
import com.google.zxing.i.h;
import com.google.zxing.i.j;
import com.google.zxing.i.k;
import com.google.zxing.i.l;
import com.google.zxing.i.o;
import com.google.zxing.i.s;
import com.google.zxing.j.a;
import com.google.zxing.k.a;
import java.util.Map;

/* loaded from: classes2.dex */
public final class d implements com.google.zxing.e {

    static class a {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            d.a.a = iArr;
            iArr[a.EAN_8.ordinal()] = 1;
            d.a.a[a.UPC_E.ordinal()] = 2;
            d.a.a[a.EAN_13.ordinal()] = 3;
            d.a.a[a.UPC_A.ordinal()] = 4;
            d.a.a[a.QR_CODE.ordinal()] = 5;
            d.a.a[a.CODE_39.ordinal()] = 6;
            d.a.a[a.CODE_93.ordinal()] = 7;
            d.a.a[a.CODE_128.ordinal()] = 8;
            d.a.a[a.ITF.ordinal()] = 9;
            d.a.a[a.PDF_417.ordinal()] = 10;
            d.a.a[a.CODABAR.ordinal()] = 11;
            d.a.a[a.DATA_MATRIX.ordinal()] = 12;
            d.a.a[a.AZTEC.ordinal()] = 13;
        }
    }
    public b a(String string, com.google.zxing.a a2, int i3, int i4, Map<com.google.zxing.c, ?> map5) {
        Object oVar;
        switch (i) {
            case 1:
                oVar = new k();
                break;
            case 2:
                oVar = new s();
                break;
            case 3:
                oVar = new j();
                break;
            case 4:
                oVar = new o();
                break;
            case 5:
                oVar = new a();
                break;
            case 6:
                oVar = new f();
                break;
            case 7:
                oVar = new h();
                break;
            case 8:
                oVar = new d();
                break;
            case 9:
                oVar = new l();
                break;
            case 10:
                oVar = new a();
                break;
            case 11:
                oVar = new b();
                break;
            case 12:
                oVar = new a();
                break;
            case 13:
                oVar = new a();
                break;
            default:
                IllegalArgumentException obj8 = new IllegalArgumentException("No encoder available for format ".concat(String.valueOf(a2)));
                throw obj8;
        }
        return oVar.a(string, a2, i3, i4, map5);
    }
}
