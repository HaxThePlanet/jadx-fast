package f.c.a.e.q;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;

/* loaded from: classes2.dex */
public class b extends FrameLayout implements f.c.a.e.q.d {

    private final f.c.a.e.q.c a;
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
        final f.c.a.e.q.c cVar = this.a;
        if (cVar != null) {
            cVar.c(canvas);
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
    public f.c.a.e.q.d.e getRevealInfo() {
        return this.a.f();
    }

    @Override // android.widget.FrameLayout
    public boolean isOpaque() {
        f.c.a.e.q.c cVar = this.a;
        if (cVar != null) {
            return cVar.g();
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
    public void setRevealInfo(f.c.a.e.q.d.e d$e) {
        this.a.j(e);
    }
}
