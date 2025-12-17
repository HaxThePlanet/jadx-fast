package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.core.widget.n;
import d.h.l.t;

/* loaded from: classes.dex */
public class AppCompatImageView extends ImageView implements t, n {

    private final androidx.appcompat.widget.e mBackgroundTintHelper;
    private final androidx.appcompat.widget.l mImageHelper;
    public AppCompatImageView(Context context) {
        super(context, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet2, int i3) {
        super(q0.b(context), attributeSet2, i3);
        o0.a(this, getContext());
        e obj1 = new e(this);
        this.mBackgroundTintHelper = obj1;
        obj1.e(attributeSet2, i3);
        obj1 = new l(this);
        this.mImageHelper = obj1;
        obj1.f(attributeSet2, i3);
    }

    @Override // android.widget.ImageView
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.b();
        }
        androidx.appcompat.widget.l mImageHelper = this.mImageHelper;
        if (mImageHelper != null) {
            mImageHelper.b();
        }
    }

    @Override // android.widget.ImageView
    public ColorStateList getSupportBackgroundTintList() {
        ColorStateList list;
        androidx.appcompat.widget.e mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            list = mBackgroundTintHelper.c();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // android.widget.ImageView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        PorterDuff.Mode mode;
        androidx.appcompat.widget.e mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mode = mBackgroundTintHelper.d();
        } else {
            mode = 0;
        }
        return mode;
    }

    @Override // android.widget.ImageView
    public ColorStateList getSupportImageTintList() {
        ColorStateList list;
        androidx.appcompat.widget.l mImageHelper = this.mImageHelper;
        if (mImageHelper != null) {
            list = mImageHelper.c();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // android.widget.ImageView
    public PorterDuff.Mode getSupportImageTintMode() {
        PorterDuff.Mode mode;
        androidx.appcompat.widget.l mImageHelper = this.mImageHelper;
        if (mImageHelper != null) {
            mode = mImageHelper.d();
        } else {
            mode = 0;
        }
        return mode;
    }

    @Override // android.widget.ImageView
    public boolean hasOverlappingRendering() {
        boolean overlappingRendering;
        int i;
        if (this.mImageHelper.e() && super.hasOverlappingRendering()) {
            i = super.hasOverlappingRendering() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.widget.ImageView
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        final androidx.appcompat.widget.e mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.f(drawable);
        }
    }

    @Override // android.widget.ImageView
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        final androidx.appcompat.widget.e mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.g(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        final androidx.appcompat.widget.l obj1 = this.mImageHelper;
        if (obj1 != null) {
            obj1.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        final androidx.appcompat.widget.l obj1 = this.mImageHelper;
        if (obj1 != null) {
            obj1.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        final androidx.appcompat.widget.l mImageHelper = this.mImageHelper;
        if (mImageHelper != null) {
            mImageHelper.g(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        final androidx.appcompat.widget.l obj1 = this.mImageHelper;
        if (obj1 != null) {
            obj1.b();
        }
    }

    @Override // android.widget.ImageView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        final androidx.appcompat.widget.e mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.i(colorStateList);
        }
    }

    @Override // android.widget.ImageView
    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode) {
        final androidx.appcompat.widget.e mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.j(mode);
        }
    }

    @Override // android.widget.ImageView
    public void setSupportImageTintList(ColorStateList colorStateList) {
        final androidx.appcompat.widget.l mImageHelper = this.mImageHelper;
        if (mImageHelper != null) {
            mImageHelper.h(colorStateList);
        }
    }

    @Override // android.widget.ImageView
    public void setSupportImageTintMode(PorterDuff.Mode porterDuff$Mode) {
        final androidx.appcompat.widget.l mImageHelper = this.mImageHelper;
        if (mImageHelper != null) {
            mImageHelper.i(mode);
        }
    }
}
