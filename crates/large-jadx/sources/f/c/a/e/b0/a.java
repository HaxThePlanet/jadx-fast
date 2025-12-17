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

/* loaded from: classes2.dex */
public class a extends Drawable implements n, b {

    private f.c.a.e.b0.a.b a;

    static class a {
    }

    static final class b extends Drawable.ConstantState {

        g a;
        boolean b;
        public b(f.c.a.e.b0.a.b a$b) {
            super();
            this.a = (g)b.a.getConstantState().newDrawable();
            this.b = b.b;
        }

        public b(g g) {
            super();
            this.a = g;
            this.b = false;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public f.c.a.e.b0.a a() {
            a.b bVar = new a.b(this);
            a aVar = new a(bVar, 0);
            return aVar;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            return a();
        }
    }
    private a(f.c.a.e.b0.a.b a$b) {
        super();
        this.a = b;
    }

    a(f.c.a.e.b0.a.b a$b, f.c.a.e.b0.a.a a$a2) {
        super(b);
    }

    public a(k k) {
        g gVar = new g(k);
        a.b bVar = new a.b(gVar);
        super(bVar);
    }

    @Override // android.graphics.drawable.Drawable
    public f.c.a.e.b0.a a() {
        a.b bVar = new a.b(this.a);
        this.a = bVar;
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Object bVar;
        bVar = this.a;
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
        return bVar.a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        a();
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        bVar.a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean onStateChange;
        int i;
        onStateChange = super.onStateChange(iArr);
        if (bVar.a.setState(iArr)) {
            onStateChange = i;
        }
        final boolean obj5 = b.e(iArr);
        f.c.a.e.b0.a.b bVar2 = this.a;
        if (bVar2.b != obj5) {
            bVar2.b = obj5;
        } else {
            i = onStateChange;
        }
        return i;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        bVar.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        bVar.a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setShapeAppearanceModel(k k) {
        bVar.a.setShapeAppearanceModel(k);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i) {
        bVar.a.setTint(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        bVar.a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode porterDuff$Mode) {
        bVar.a.setTintMode(mode);
    }
}
