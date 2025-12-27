package f.c.a.e.b0;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import androidx.core.graphics.drawable.b;
import f.c.a.e.d0.g;
import f.c.a.e.d0.k;
import f.c.a.e.d0.n;

/* compiled from: RippleDrawableCompat.java */
/* loaded from: classes2.dex */
public class a extends Drawable implements n, b {

    private a.b a;

    static class a {
    }

    static final class b extends Drawable.ConstantState {

        g a;
        boolean b;
        public b(g gVar) {
            super();
            this.a = gVar;
            this.b = false;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public a a() {
            return new a(new a.b(this), null);
        }

        public b(a.b bVar) {
            super();
            this.a = (g)bVar.a.getConstantState().newDrawable();
            this.b = bVar.b;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return 0;
        }
    }
    /* synthetic */ a(a.b bVar, a.a aVar) {
        this(bVar);
    }

    @Override // android.graphics.drawable.Drawable
    public a a() {
        this.a = new a.b(this.a);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (bVar.b) {
            bVar.a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.a.a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.a.a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange;
        onStateChange = super.onStateChange(iArr);
        if (this.a.a.setState(iArr)) {
        }
        final boolean z2 = b.e(iArr);
        if (bVar2.b != z2) {
            this.a.b = z2;
        } else {
        }
        return onStateChange;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.a.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.a.a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setShapeAppearanceModel(k kVar) {
        this.a.a.setShapeAppearanceModel(kVar);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        this.a.a.setTint(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList list) {
        this.a.a.setTintList(list);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.a.a.setTintMode(mode);
    }

    public a(k kVar) {
        this(new a.b(new g(kVar)));
    }

    private a(a.b bVar) {
        super();
        this.a = bVar;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }
}
