package f.c.a.e.q;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* compiled from: CircularRevealFrameLayout.java */
/* loaded from: classes2.dex */
public class b extends FrameLayout implements d {

    private final c a;
    @Override // android.widget.FrameLayout
    public void a() {
        this.a.a();
    }

    @Override // android.widget.FrameLayout
    public void b() {
        this.a.b();
    }

    @Override // android.widget.FrameLayout
    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // android.widget.FrameLayout
    public Drawable getCircularRevealOverlayDrawable() {
        return this.a.d();
    }

    @Override // android.widget.FrameLayout
    public int getCircularRevealScrimColor() {
        return this.a.e();
    }

    @Override // android.widget.FrameLayout
    public d.e getRevealInfo() {
        return this.a.f();
    }

    @Override // android.widget.FrameLayout
    public boolean isOpaque() {
        if (this.a != null) {
            return this.a.g();
        }
        return super.isOpaque();
    }

    @Override // android.widget.FrameLayout
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.a.h(drawable);
    }

    @Override // android.widget.FrameLayout
    public void setCircularRevealScrimColor(int i) {
        this.a.i(i);
    }

    @Override // android.widget.FrameLayout
    public void setRevealInfo(d.e eVar) {
        this.a.j(eVar);
    }
}
