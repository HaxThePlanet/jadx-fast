package d.u;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import d.h.l.u;

/* compiled from: SidePropagation.java */
/* loaded from: classes.dex */
public class m extends n0 {

    private float b = 3f;
    private int c = 80;
    public m() {
        super();
    }

    private int h(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i10 = 0;
        int i11 = 8388611;
        int i12;
        i = 5;
        i = 3;
        i10 = 0;
        i10 = 1;
        i11 = 8388611;
        if (this.c == 8388611) {
            if (u.B(view) != i10) {
            }
            int r0 = i;
        }
        if (this.c == i) {
            i17 = i7 - i;
            i16 = i4 - i2;
            i10 = i17 + Math.abs(i16);
        } else {
            if (this.c == i) {
                i13 = i - i5;
                i16 = i4 - i2;
                i10 = i13 + Math.abs(i16);
            } else {
                if (this.c == 48) {
                    i18 = i8 - i2;
                    i15 = i3 - i;
                    i10 = i18 + Math.abs(i15);
                } else {
                    int abs = 80;
                    if (this.c == 80) {
                        i14 = i2 - i6;
                        i15 = i3 - i;
                        i10 = i14 + Math.abs(i15);
                    }
                }
            }
        }
        return i10;
    }

    private int i(ViewGroup viewGroup) {
        int i = 3;
        if (this.c != 3 && this.c != 5 && this.c != 8388611 && this.c != 8388613) {
            return viewGroup.getHeight();
        }
        return viewGroup.getWidth();
    }

    @Override // d.u.n0
    public long c(ViewGroup viewGroup, o oVar, u uVar, u uVar2) {
        d.u.u uVar32;
        long l = 300;
        int centerX;
        int i;
        final Object viewGroup3 = this;
        uVar32 = uVar;
        final long l5 = 0L;
        if (uVar32 == null && uVar2 == null) {
            return l5;
        }
        Rect rect = oVar.t();
        i = 1;
        if (uVar2 == null || viewGroup3.e(uVar32) == 0) {
            i = -1;
        }
        centerX = 2;
        int[] iArr = new int[centerX];
        viewGroup.getLocationOnScreen(iArr);
        int i12 = iArr[0] + Math.round(viewGroup.getTranslationX());
        int i13 = iArr[i] + Math.round(viewGroup.getTranslationY());
        final int i14 = i12 + viewGroup.getWidth();
        final int i15 = i13 + viewGroup.getHeight();
        if (rect != null) {
        } else {
            centerX = (i12 + i14) / centerX;
            centerX = (i13 + i15) / centerX;
        }
        l = oVar.s();
        if (l < l5) {
            int i6 = 300;
        }
        return (long)(Math.round((float)(l * (long)i) / viewGroup3.b * (float)(this.h(viewGroup, i2, i3, centerX, centerX, i12, i13, i14, i15)) / (float)i(viewGroup)));
    }

    @Override // d.u.n0
    public void j(int i) {
        this.c = i;
    }
}
