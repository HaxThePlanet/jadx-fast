package d.u;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import d.h.l.u;

/* loaded from: classes.dex */
public class m extends d.u.n0 {

    private float b = 3f;
    private int c = 80;
    public m() {
        super();
        int i = 1077936128;
        int i2 = 80;
    }

    private int h(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i11;
        int i10;
        int i12;
        int i;
        int obj7;
        int obj8;
        int obj9;
        int obj10;
        int obj11;
        int obj14;
        int obj15;
        i11 = this.c;
        final int i13 = 5;
        final int i14 = 3;
        i10 = 0;
        i12 = 1;
        if (i11 == 8388611) {
            if (u.B(view) == i12) {
            } else {
                i12 = i10;
            }
            i11 = i12 != 0 ? i13 : i14;
        } else {
        }
        if (i11 != i14) {
            if (i11 != i13) {
                if (i11 != 48) {
                    if (i11 != 80) {
                    } else {
                        i10 = obj9 + obj7;
                    }
                } else {
                    i10 = obj15 + obj7;
                }
            } else {
                i10 = obj8 + obj7;
            }
        } else {
            i10 = obj14 + obj7;
        }
        return i10;
    }

    private int i(ViewGroup viewGroup) {
        int i;
        final int i2 = this.c;
        if (i2 != 3 && i2 != 5 && i2 != 8388611 && i2 != 8388613) {
            if (i2 != 5) {
                if (i2 != 8388611) {
                    if (i2 != 8388613) {
                        return viewGroup.getHeight();
                    }
                }
            }
        }
        return viewGroup.getWidth();
    }

    @Override // d.u.n0
    public long c(ViewGroup viewGroup, d.u.o o2, d.u.u u3, d.u.u u4) {
        d.u.u uVar;
        int centerX;
        int centerY;
        long l;
        int height;
        int i;
        int i2;
        int i3;
        int i4;
        final Object obj2 = this;
        uVar = u3;
        final int i27 = 0;
        if (uVar == null && u4 == null) {
            if (u4 == null) {
                return i27;
            }
        }
        Rect rect = o2.t();
        int i12 = 1;
        if (u4 != null) {
            if (obj2.e(uVar) == 0) {
                i3 = i;
            } else {
                uVar = u4;
                i3 = i12;
            }
        } else {
        }
        centerX = 2;
        int[] iArr = new int[centerX];
        viewGroup.getLocationOnScreen(iArr);
        i22 += round3;
        int i24 = i13 + round2;
        final int i25 = i23 + width;
        final int i26 = i24 + height;
        if (rect != null) {
            i2 = centerX;
            i4 = centerY;
        } else {
            i2 = centerY;
            i4 = height;
        }
        if (Long.compare(l, i27) < 0) {
            l = 300;
        }
        return (long)round;
    }

    @Override // d.u.n0
    public void j(int i) {
        this.c = i;
    }
}
