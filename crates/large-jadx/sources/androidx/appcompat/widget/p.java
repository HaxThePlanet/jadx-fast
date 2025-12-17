package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.core.widget.l;
import d.a.a;
import d.a.k.a.a;
import d.h.l.t;

/* loaded from: classes.dex */
public class p extends RadioButton implements l, t {

    private final androidx.appcompat.widget.h a;
    private final androidx.appcompat.widget.e b;
    private final androidx.appcompat.widget.v c;
    public p(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.H);
    }

    public p(Context context, AttributeSet attributeSet2, int i3) {
        super(q0.b(context), attributeSet2, i3);
        o0.a(this, getContext());
        h obj1 = new h(this);
        this.a = obj1;
        obj1.e(attributeSet2, i3);
        obj1 = new e(this);
        this.b = obj1;
        obj1.e(attributeSet2, i3);
        obj1 = new v(this);
        this.c = obj1;
        obj1.m(attributeSet2, i3);
    }

    @Override // android.widget.RadioButton
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e eVar = this.b;
        if (eVar != null) {
            eVar.b();
        }
        androidx.appcompat.widget.v vVar = this.c;
        if (vVar != null) {
            vVar.b();
        }
    }

    @Override // android.widget.RadioButton
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft;
        final androidx.appcompat.widget.h hVar = this.a;
        if (hVar != null) {
            compoundPaddingLeft = hVar.b(super.getCompoundPaddingLeft());
        }
        return compoundPaddingLeft;
    }

    @Override // android.widget.RadioButton
    public ColorStateList getSupportBackgroundTintList() {
        ColorStateList list;
        androidx.appcompat.widget.e eVar = this.b;
        if (eVar != null) {
            list = eVar.c();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // android.widget.RadioButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        PorterDuff.Mode mode;
        androidx.appcompat.widget.e eVar = this.b;
        if (eVar != null) {
            mode = eVar.d();
        } else {
            mode = 0;
        }
        return mode;
    }

    @Override // android.widget.RadioButton
    public ColorStateList getSupportButtonTintList() {
        ColorStateList list;
        androidx.appcompat.widget.h hVar = this.a;
        if (hVar != null) {
            list = hVar.c();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // android.widget.RadioButton
    public PorterDuff.Mode getSupportButtonTintMode() {
        PorterDuff.Mode mode;
        androidx.appcompat.widget.h hVar = this.a;
        if (hVar != null) {
            mode = hVar.d();
        } else {
            mode = 0;
        }
        return mode;
    }

    @Override // android.widget.RadioButton
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        final androidx.appcompat.widget.e eVar = this.b;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.widget.RadioButton
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        final androidx.appcompat.widget.e eVar = this.b;
        if (eVar != null) {
            eVar.g(i);
        }
    }

    @Override // android.widget.RadioButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(a.d(getContext(), i));
    }

    @Override // android.widget.RadioButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        final androidx.appcompat.widget.h obj1 = this.a;
        if (obj1 != null) {
            obj1.f();
        }
    }

    @Override // android.widget.RadioButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        final androidx.appcompat.widget.e eVar = this.b;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // android.widget.RadioButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode) {
        final androidx.appcompat.widget.e eVar = this.b;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // android.widget.RadioButton
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        final androidx.appcompat.widget.h hVar = this.a;
        if (hVar != null) {
            hVar.g(colorStateList);
        }
    }

    @Override // android.widget.RadioButton
    public void setSupportButtonTintMode(PorterDuff.Mode porterDuff$Mode) {
        final androidx.appcompat.widget.h hVar = this.a;
        if (hVar != null) {
            hVar.h(mode);
        }
    }
}
