package d.u;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* loaded from: classes.dex */
class d0 implements d.u.e0 {

    private final ViewOverlay a;
    d0(View view) {
        super();
        this.a = view.getOverlay();
    }

    @Override // d.u.e0
    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // d.u.e0
    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }
}
