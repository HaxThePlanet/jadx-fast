package f.c.a.e.z;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.widget.p;
import androidx.core.widget.e;
import com.google.android.material.internal.l;
import com.google.android.material.theme.a.a;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.k;
import f.c.a.e.l;
import f.c.a.e.r.a;

/* loaded from: classes2.dex */
public class a extends p {

    private static final int x;
    private static final int[][] y;
    private ColorStateList v;
    private boolean w;
    static {
        a.x = k.v;
        int[][] iArr = new int[4];
        int i4 = 2;
        int[] iArr3 = new int[i4];
        iArr3 = new int[]{16842910, 16842912};
        int[] iArr4 = new int[i4];
        iArr4 = new int[]{16842910, -16842912};
        int[] iArr5 = new int[i4];
        iArr5 = new int[]{-16842910, 16842912};
        iArr[i4] = iArr5;
        int[] iArr2 = new int[i4];
        iArr2 = new int[]{-16842910, -16842912};
        iArr[3] = iArr2;
        a.y = iArr;
    }

    public a(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.L);
    }

    public a(Context context, AttributeSet attributeSet2, int i3) {
        Object obj8;
        final int i2 = a.x;
        super(a.c(context, attributeSet2, i3, i2), attributeSet2, i3);
        obj8 = getContext();
        final int i4 = 0;
        final TypedArray obj9 = l.h(obj8, attributeSet2, l.e3, i3, i2, new int[i4]);
        final int obj10 = l.f3;
        if (obj9.hasValue(obj10)) {
            e.c(this, c.a(obj8, obj9, obj10));
        }
        this.w = obj9.getBoolean(l.g3, i4);
        obj9.recycle();
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        ColorStateList colorStateList;
        int i2;
        int i3;
        int[][] arr;
        int[] iArr;
        int i;
        int i4;
        if (this.v == null) {
            int i12 = a.d(this, b.n);
            i3 = a.d(this, b.q);
            arr = a.y;
            iArr = new int[arr.length];
            iArr[0] = a.h(i3, a.d(this, b.l), 1065353216);
            iArr[1] = a.h(i3, i12, 1057635697);
            i = 1052938076;
            iArr[2] = a.h(i3, i12, i);
            iArr[3] = a.h(i3, i12, i);
            colorStateList = new ColorStateList(arr, iArr);
            this.v = colorStateList;
        }
        return this.v;
    }

    @Override // androidx.appcompat.widget.p
    protected void onAttachedToWindow() {
        boolean z;
        super.onAttachedToWindow();
        if (this.w && e.b(this) == null) {
            if (e.b(this) == null) {
                setUseMaterialThemeColors(true);
            }
        }
    }

    @Override // androidx.appcompat.widget.p
    public void setUseMaterialThemeColors(boolean z) {
        ColorStateList obj1;
        this.w = z;
        if (z) {
            e.c(this, getMaterialThemeColorsTintList());
        } else {
            e.c(this, 0);
        }
    }
}
