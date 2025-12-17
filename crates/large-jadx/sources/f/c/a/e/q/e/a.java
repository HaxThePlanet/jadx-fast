package f.c.a.e.q.e;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.widget.FrameLayout;
import com.google.android.material.card.MaterialCardView;
import f.c.a.e.q.c;
import f.c.a.e.q.d;
import f.c.a.e.q.d.e;

/* loaded from: classes2.dex */
public class a extends MaterialCardView implements d {

    private final c B;
    @Override // com.google.android.material.card.MaterialCardView
    public void a() {
        this.B.a();
    }

    @Override // com.google.android.material.card.MaterialCardView
    public void b() {
        this.B.b();
    }

    @Override // com.google.android.material.card.MaterialCardView
    public void draw(Canvas canvas) {
        final c cVar = this.B;
        if (cVar != null) {
            cVar.c(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // com.google.android.material.card.MaterialCardView
    public Drawable getCircularRevealOverlayDrawable() {
        return this.B.d();
    }

    @Override // com.google.android.material.card.MaterialCardView
    public int getCircularRevealScrimColor() {
        return this.B.e();
    }

    @Override // com.google.android.material.card.MaterialCardView
    public d.e getRevealInfo() {
        return this.B.f();
    }

    @Override // com.google.android.material.card.MaterialCardView
    public boolean isOpaque() {
        c cVar = this.B;
        if (cVar != null) {
            return cVar.g();
        }
        return super.isOpaque();
    }

    @Override // com.google.android.material.card.MaterialCardView
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.B.h(drawable);
    }

    @Override // com.google.android.material.card.MaterialCardView
    public void setCircularRevealScrimColor(int i) {
        this.B.i(i);
    }

    @Override // com.google.android.material.card.MaterialCardView
    public void setRevealInfo(d.e d$e) {
        this.B.j(e);
    }
}
