package com.google.android.material.switchmaterial;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import com.google.android.material.internal.l;
import com.google.android.material.internal.n;
import com.google.android.material.theme.a.a;
import f.c.a.e.b;
import f.c.a.e.d;
import f.c.a.e.k;
import f.c.a.e.l;
import f.c.a.e.r.a;
import f.c.a.e.u.a;

/* loaded from: classes2.dex */
public class SwitchMaterial extends SwitchCompat {

    private static final int o0;
    private static final int[][] p0;
    private final a k0;
    private ColorStateList l0;
    private ColorStateList m0;
    private boolean n0;
    static {
        SwitchMaterial.o0 = k.w;
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
        SwitchMaterial.p0 = iArr;
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.U);
    }

    public SwitchMaterial(Context context, AttributeSet attributeSet2, int i3) {
        final int i2 = SwitchMaterial.o0;
        super(a.c(context, attributeSet2, i3, i2), attributeSet2, i3);
        final Context context2 = getContext();
        a obj7 = new a(context2);
        this.k0 = obj7;
        obj7 = 0;
        final TypedArray obj8 = l.h(context2, attributeSet2, l.s4, i3, i2, new int[obj7]);
        this.n0 = obj8.getBoolean(l.t4, obj7);
        obj8.recycle();
    }

    private ColorStateList getMaterialThemeColorsThumbTintList() {
        ColorStateList colorStateList;
        int i3;
        float dimension;
        int i;
        boolean z;
        int[][] arr;
        int[] iArr;
        int i2;
        int i4;
        int i6 = a.d(this, b.q);
        i3 = a.d(this, b.l);
        if (this.l0 == null && this.k0.d()) {
            i6 = a.d(this, b.q);
            i3 = a.d(this, b.l);
            if (this.k0.d()) {
                dimension += z;
            }
            i = this.k0.c(i6, dimension);
            arr = SwitchMaterial.p0;
            iArr = new int[arr.length];
            iArr[0] = a.h(i6, i3, 1065353216);
            iArr[1] = i;
            iArr[2] = a.h(i6, i3, 1052938076);
            iArr[3] = i;
            colorStateList = new ColorStateList(arr, iArr);
            this.l0 = colorStateList;
        }
        return this.l0;
    }

    private ColorStateList getMaterialThemeColorsTrackTintList() {
        ColorStateList list;
        int[] iArr;
        ColorStateList colorStateList;
        int i;
        int i3;
        int i4;
        int i2;
        if (this.m0 == null) {
            list = SwitchMaterial.p0;
            iArr = new int[list.length];
            int i6 = a.d(this, b.q);
            int i9 = a.d(this, b.l);
            i3 = a.d(this, b.n);
            iArr[0] = a.h(i6, i9, 1057635697);
            iArr[1] = a.h(i6, i3, 1050924810);
            i2 = 1039516303;
            iArr[2] = a.h(i6, i9, i2);
            iArr[3] = a.h(i6, i3, i2);
            colorStateList = new ColorStateList(list, iArr);
            this.m0 = colorStateList;
        }
        return this.m0;
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    protected void onAttachedToWindow() {
        boolean materialThemeColorsThumbTintList;
        boolean materialThemeColorsTrackTintList;
        super.onAttachedToWindow();
        if (this.n0 && getThumbTintList() == null) {
            if (getThumbTintList() == null) {
                setThumbTintList(getMaterialThemeColorsThumbTintList());
            }
        }
        if (this.n0 && getTrackTintList() == null) {
            if (getTrackTintList() == null) {
                setTrackTintList(getMaterialThemeColorsTrackTintList());
            }
        }
    }

    @Override // androidx.appcompat.widget.SwitchCompat
    public void setUseMaterialThemeColors(boolean z) {
        ColorStateList obj1;
        this.n0 = z;
        if (z) {
            setThumbTintList(getMaterialThemeColorsThumbTintList());
            setTrackTintList(getMaterialThemeColorsTrackTintList());
        } else {
            obj1 = 0;
            setThumbTintList(obj1);
            setTrackTintList(obj1);
        }
    }
}
