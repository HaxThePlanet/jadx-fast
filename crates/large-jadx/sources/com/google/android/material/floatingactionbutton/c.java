package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageButton;
import androidx.core.content.a;
import d.h.k.i;
import f.c.a.e.b0.b;
import f.c.a.e.c;
import f.c.a.e.c0.b;
import f.c.a.e.d0.g;
import f.c.a.e.d0.k;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
class c extends com.google.android.material.floatingactionbutton.b {

    static class a extends g {
        a(k k) {
            super(k);
        }

        @Override // f.c.a.e.d0.g
        public boolean isStateful() {
            return 1;
        }
    }
    c(com.google.android.material.floatingactionbutton.FloatingActionButton floatingActionButton, b b2) {
        super(floatingActionButton, b2);
    }

    private Animator j0(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        int i2 = 1;
        float[] fArr2 = new float[i2];
        final int i3 = 0;
        fArr2[i3] = f;
        float[] fArr = new float[i2];
        fArr[i3] = f2;
        animatorSet.play(ObjectAnimator.ofFloat(this.w, "elevation", fArr2).setDuration(0)).with(ObjectAnimator.ofFloat(this.w, View.TRANSLATION_Z, fArr).setDuration(100));
        animatorSet.setInterpolator(b.D);
        return animatorSet;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void A() {
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void C() {
        f0();
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void E(int[] iArr) {
        int i;
        float f;
        int obj3;
        if (Build.VERSION.SDK_INT == 21) {
            i = 0;
            if (this.w.isEnabled()) {
                this.w.setElevation(this.h);
                if (this.w.isPressed()) {
                    this.w.setTranslationZ(this.j);
                } else {
                    if (!this.w.isFocused()) {
                        if (this.w.isHovered()) {
                            this.w.setTranslationZ(this.i);
                        } else {
                            this.w.setTranslationZ(i);
                        }
                    } else {
                    }
                }
            } else {
                this.w.setElevation(i);
                this.w.setTranslationZ(i);
            }
        }
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void F(float f, float f2, float f3) {
        android.util.Property tRANSLATION_Z;
        StateListAnimator stateListAnimator;
        float[] fArr2;
        com.google.android.material.floatingactionbutton.FloatingActionButton fArr;
        int i3;
        float[] translationZ;
        int i2;
        int i;
        com.google.android.material.floatingactionbutton.FloatingActionButton obj9;
        Animator obj10;
        ArrayList obj11;
        tRANSLATION_Z = Build.VERSION.SDK_INT;
        if (tRANSLATION_Z == 21) {
            this.w.refreshDrawableState();
        } else {
            stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(b.E, j0(f, f3));
            stateListAnimator.addState(b.F, j0(f, f2));
            stateListAnimator.addState(b.G, j0(f, f2));
            stateListAnimator.addState(b.H, j0(f, f2));
            obj10 = new AnimatorSet();
            obj11 = new ArrayList();
            int i4 = 1;
            translationZ = new float[i4];
            i2 = 0;
            translationZ[i2] = f;
            obj11.add(ObjectAnimator.ofFloat(this.w, "elevation", translationZ).setDuration(0));
            i = 100;
            if (tRANSLATION_Z >= 22 && tRANSLATION_Z <= 24) {
                if (tRANSLATION_Z <= 24) {
                    obj9 = this.w;
                    fArr = new float[i4];
                    fArr[i2] = obj9.getTranslationZ();
                    obj11.add(ObjectAnimator.ofFloat(obj9, View.TRANSLATION_Z, fArr).setDuration(i));
                }
            }
            fArr2 = new float[i4];
            i3 = 0;
            fArr2[i2] = i3;
            obj11.add(ObjectAnimator.ofFloat(this.w, View.TRANSLATION_Z, fArr2).setDuration(i));
            obj10.playSequentially((Animator[])obj11.toArray(new Animator[i2]));
            obj10.setInterpolator(b.D);
            stateListAnimator.addState(b.I, obj10);
            stateListAnimator.addState(b.J, j0(i3, i3));
            this.w.setStateListAnimator(stateListAnimator);
        }
        if (Z()) {
            f0();
        }
    }

    @Override // com.google.android.material.floatingactionbutton.b
    boolean K() {
        return 0;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void V(ColorStateList colorStateList) {
        ColorStateList obj3;
        final android.graphics.drawable.Drawable drawable = this.c;
        if (drawable instanceof RippleDrawable) {
            (RippleDrawable)drawable.setColor(b.d(colorStateList));
        } else {
            super.V(colorStateList);
        }
    }

    @Override // com.google.android.material.floatingactionbutton.b
    boolean Z() {
        int i;
        boolean z;
        if (!this.x.b()) {
            if (!b0()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void d0() {
    }

    @Override // com.google.android.material.floatingactionbutton.b
    com.google.android.material.floatingactionbutton.a i0(int i, ColorStateList colorStateList2) {
        android.content.Context context = this.w.getContext();
        k kVar = this.a;
        i.c(kVar);
        a aVar = new a((k)kVar);
        aVar.e(a.d(context, c.f), a.d(context, c.e), a.d(context, c.c), a.d(context, c.d));
        aVar.d((float)i);
        aVar.c(colorStateList2);
        return aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    g l() {
        final k kVar = this.a;
        i.c(kVar);
        c.a aVar = new c.a((k)kVar);
        return aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.b
    public float n() {
        return this.w.getElevation();
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void s(Rect rect) {
        boolean z;
        int sizeDimension;
        if (this.x.b()) {
            super.s(rect);
        } else {
            if (!b0()) {
                i2 /= 2;
                rect.set(z, z, z, z);
            } else {
                z = 0;
                rect.set(z, z, z, z);
            }
        }
    }

    @Override // com.google.android.material.floatingactionbutton.b
    void x(ColorStateList colorStateList, PorterDuff.Mode porterDuff$Mode2, ColorStateList colorStateList3, int i4) {
        g gVar2;
        int context;
        g gVar;
        Object obj3;
        android.graphics.drawable.Drawable[] obj6;
        gVar2 = l();
        this.b = gVar2;
        gVar2.setTintList(colorStateList);
        if (mode2 != null) {
            this.b.setTintMode(mode2);
        }
        this.b.O(this.w.getContext());
        int obj4 = 0;
        if (i4 > 0) {
            this.d = i0(i4, colorStateList);
            obj6 = new Drawable[2];
            com.google.android.material.floatingactionbutton.a aVar = this.d;
            i.c(aVar);
            gVar = this.b;
            i.c(gVar);
            obj3 = new LayerDrawable(obj6);
        } else {
            this.d = obj4;
            obj3 = this.b;
        }
        obj6 = new RippleDrawable(b.d(colorStateList3), obj3, obj4);
        this.c = obj6;
        this.e = obj6;
    }
}
