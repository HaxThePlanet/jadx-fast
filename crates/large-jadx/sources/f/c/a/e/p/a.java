package f.c.a.e.p;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CheckBox;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.widget.e;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.k;

/* compiled from: MaterialCheckBox.java */
/* loaded from: classes2.dex */
public class a extends AppCompatCheckBox {

    private static final int x = 0;
    private static final int[][] y;
    private ColorStateList v;
    private boolean w;
    static {
        a.x = k.u;
        int[][] iArr = new int[4];
        a.y = new int[] { new int[] { 0x0101009e /* Unknown resource */, 0x010100a0 /* Unknown resource */ }, new int[] { 0x0101009e /* Unknown resource */, -16842912 }, new int[] { -16842910, 0x010100a0 /* Unknown resource */ }, new int[] { -16842910, -16842912 } };
    }

    public a(Context context, AttributeSet set) {
        this(context, set, b.h);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.v == null) {
            int[][] arr = a.y;
            int[] iArr = new int[arr.length];
            int i11 = a.d(this, b.q);
            int i2 = a.d(this, b.n);
            iArr[0] = a.h(i11, a.d(this, b.l), 1f);
            iArr[1] = a.h(i11, i2, 0.54f);
            float f = 0.38f;
            iArr[2] = a.h(i11, i2, f);
            iArr[3] = a.h(i11, i2, f);
            this.v = new ColorStateList(arr, iArr);
        }
        return this.v;
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.w && e.b(this) == null) {
            boolean z = true;
            setUseMaterialThemeColors(z);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox
    public void setUseMaterialThemeColors(boolean z) {
        this.w = z;
        if (z) {
            e.c(this, getMaterialThemeColorsTintList());
        } else {
            ColorStateList materialThemeColorsTintList = null;
            e.c(this, materialThemeColorsTintList);
        }
    }

    public a(Context context, AttributeSet set, int i) {
        i = a.x;
        super(a.c(context, set, i, i), set, i);
        Context context2 = getContext();
        final int i2 = 0;
        final TypedArray typedArray = l.h(context2, set, l.b3, i, i, new int[i2]);
        final int i5 = l.c3;
        if (typedArray.hasValue(i5)) {
            e.c(this, c.a(context2, typedArray, l.c3));
        }
        this.w = typedArray.getBoolean(l.d3, false);
        typedArray.recycle();
    }
}
