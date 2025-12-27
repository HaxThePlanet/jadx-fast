package f.c.a.e.z;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.widget.p;
import androidx.core.widget.e;
import f.c.a.e.a0.c;
import f.c.a.e.b;
import f.c.a.e.k;

/* compiled from: MaterialRadioButton.java */
/* loaded from: classes2.dex */
public class a extends p {

    private static final int x = 0;
    private static final int[][] y;
    private ColorStateList v;
    private boolean w;
    static {
        a.x = k.v;
        int[][] iArr = new int[4];
        a.y = new int[] { new int[] { 0x0101009e /* Unknown resource */, 0x010100a0 /* Unknown resource */ }, new int[] { 0x0101009e /* Unknown resource */, -16842912 }, new int[] { -16842910, 0x010100a0 /* Unknown resource */ }, new int[] { -16842910, -16842912 } };
    }

    public a(Context context, AttributeSet set) {
        this(context, set, b.L);
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.v == null) {
            int i11 = a.d(this, b.n);
            int i2 = a.d(this, b.q);
            arr = a.y;
            int[] iArr = new int[arr.length];
            iArr[0] = a.h(i2, a.d(this, b.l), 1f);
            iArr[1] = a.h(i2, i11, 0.54f);
            float f = 0.38f;
            iArr[2] = a.h(i2, i11, f);
            iArr[3] = a.h(i2, i11, f);
            this.v = new ColorStateList(arr, iArr);
        }
        return this.v;
    }

    @Override // androidx.appcompat.widget.p
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.w && e.b(this) == null) {
            boolean z = true;
            setUseMaterialThemeColors(z);
        }
    }

    @Override // androidx.appcompat.widget.p
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
        final TypedArray typedArray = l.h(context2, set, l.e3, i, i, new int[i2]);
        final int i5 = l.f3;
        if (typedArray.hasValue(i5)) {
            e.c(this, c.a(context2, typedArray, l.f3));
        }
        this.w = typedArray.getBoolean(l.g3, false);
        typedArray.recycle();
    }
}
