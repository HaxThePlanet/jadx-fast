package com.skydoves.balloon;

import com.skydoves.balloon.overlay.a;

/* loaded from: classes2.dex */
public final class e {

    public static final int[] a;
    public static final int[] b;
    public static final int[] c;
    public static final int[] d;
    public static final int[] e;
    public static final int[] f;
    public static final int[] g;
    public static final int[] h;
    public static final int[] i;
    public static final int[] j;
    static {
        int[] iArr = new int[values.length];
        e.a = iArr;
        com.skydoves.balloon.a bOTTOM = a.BOTTOM;
        final int i = 1;
        iArr[bOTTOM.ordinal()] = i;
        com.skydoves.balloon.a tOP = a.TOP;
        final int i2 = 2;
        iArr[tOP.ordinal()] = i2;
        com.skydoves.balloon.a lEFT = a.LEFT;
        final int i3 = 3;
        iArr[lEFT.ordinal()] = i3;
        com.skydoves.balloon.a rIGHT = a.RIGHT;
        final int i4 = 4;
        iArr[rIGHT.ordinal()] = i4;
        int[] iArr2 = new int[values2.length];
        e.b = iArr2;
        iArr2[bOTTOM.ordinal()] = i;
        iArr2[lEFT.ordinal()] = i2;
        iArr2[rIGHT.ordinal()] = i3;
        iArr2[tOP.ordinal()] = i4;
        int[] iArr3 = new int[values3.length];
        e.c = iArr3;
        iArr3[bOTTOM.ordinal()] = i;
        iArr3[tOP.ordinal()] = i2;
        iArr3[lEFT.ordinal()] = i3;
        iArr3[rIGHT.ordinal()] = i4;
        int[] iArr4 = new int[values4.length];
        e.d = iArr4;
        com.skydoves.balloon.c aLIGN_BALLOON = c.ALIGN_BALLOON;
        iArr4[aLIGN_BALLOON.ordinal()] = i;
        com.skydoves.balloon.c aLIGN_ANCHOR = c.ALIGN_ANCHOR;
        iArr4[aLIGN_ANCHOR.ordinal()] = i2;
        int[] iArr5 = new int[values5.length];
        e.e = iArr5;
        iArr5[aLIGN_BALLOON.ordinal()] = i;
        iArr5[aLIGN_ANCHOR.ordinal()] = i2;
        int[] iArr6 = new int[values6.length];
        e.f = iArr6;
        iArr6[lEFT.ordinal()] = i;
        iArr6[rIGHT.ordinal()] = i2;
        iArr6[tOP.ordinal()] = i3;
        iArr6[bOTTOM.ordinal()] = i4;
        int[] iArr7 = new int[values7.length];
        e.g = iArr7;
        iArr7[f.ELASTIC.ordinal()] = i;
        iArr7[f.CIRCULAR.ordinal()] = i2;
        iArr7[f.FADE.ordinal()] = i3;
        iArr7[f.OVERSHOOT.ordinal()] = i4;
        iArr7[f.NONE.ordinal()] = 5;
        int[] iArr8 = new int[values8.length];
        e.h = iArr8;
        iArr8[a.FADE.ordinal()] = i;
        int[] iArr9 = new int[values9.length];
        e.i = iArr9;
        iArr9[tOP.ordinal()] = i;
        iArr9[bOTTOM.ordinal()] = i2;
        iArr9[lEFT.ordinal()] = i3;
        iArr9[rIGHT.ordinal()] = i4;
        int[] iArr10 = new int[values10.length];
        e.j = iArr10;
        iArr10[h.HEARTBEAT.ordinal()] = i;
    }
}
