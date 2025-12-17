package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageButton;
import androidx.core.widget.n;
import d.a.a;
import d.h.l.t;

/* loaded from: classes.dex */
public class k extends ImageButton implements t, n {

    private final androidx.appcompat.widget.e a;
    private final androidx.appcompat.widget.l b;
    public k(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.C);
    }

    public k(Context context, AttributeSet attributeSet2, int i3) {
        super(q0.b(context), attributeSet2, i3);
        o0.a(this, getContext());
        e obj1 = new e(this);
        this.a = obj1;
        obj1.e(attributeSet2, i3);
        obj1 = new l(this);
        this.b = obj1;
        obj1.f(attributeSet2, i3);
    }

    @Override // android.widget.ImageButton
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.b();
        }
        androidx.appcompat.widget.l lVar = this.b;
        if (lVar != null) {
            lVar.b();
        }
    }

    @Override // android.widget.ImageButton
    public ColorStateList getSupportBackgroundTintList() {
        ColorStateList list;
        androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            list = eVar.c();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // android.widget.ImageButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        PorterDuff.Mode mode;
        androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            mode = eVar.d();
        } else {
            mode = 0;
        }
        return mode;
    }

    @Override // android.widget.ImageButton
    public ColorStateList getSupportImageTintList() {
        ColorStateList list;
        androidx.appcompat.widget.l lVar = this.b;
        if (lVar != null) {
            list = lVar.c();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // android.widget.ImageButton
    public PorterDuff.Mode getSupportImageTintMode() {
        PorterDuff.Mode mode;
        androidx.appcompat.widget.l lVar = this.b;
        if (lVar != null) {
            mode = lVar.d();
        } else {
            mode = 0;
        }
        return mode;
    }

    @Override // android.widget.ImageButton
    public boolean hasOverlappingRendering() {
        boolean overlappingRendering;
        int i;
        if (this.b.e() && super.hasOverlappingRendering()) {
            i = super.hasOverlappingRendering() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.widget.ImageButton
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.widget.ImageButton
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.g(i);
        }
    }

    @Override // android.widget.ImageButton
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        final androidx.appcompat.widget.l obj1 = this.b;
        if (obj1 != null) {
            obj1.b();
        }
    }

    @Override // android.widget.ImageButton
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        final androidx.appcompat.widget.l obj1 = this.b;
        if (obj1 != null) {
            obj1.b();
        }
    }

    @Override // android.widget.ImageButton
    public void setImageResource(int i) {
        this.b.g(i);
    }

    @Override // android.widget.ImageButton
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        final androidx.appcompat.widget.l obj1 = this.b;
        if (obj1 != null) {
            obj1.b();
        }
    }

    @Override // android.widget.ImageButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // android.widget.ImageButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode) {
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // android.widget.ImageButton
    public void setSupportImageTintList(ColorStateList colorStateList) {
        final androidx.appcompat.widget.l lVar = this.b;
        if (lVar != null) {
            lVar.h(colorStateList);
        }
    }

    @Override // android.widget.ImageButton
    public void setSupportImageTintMode(PorterDuff.Mode porterDuff$Mode) {
        final androidx.appcompat.widget.l lVar = this.b;
        if (lVar != null) {
            lVar.i(mode);
        }
    }
}
