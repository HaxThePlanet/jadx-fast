package d.u;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* loaded from: classes.dex */
class y implements d.u.z {

    private final ViewGroupOverlay a;
    y(ViewGroup viewGroup) {
        super();
        this.a = viewGroup.getOverlay();
    }

    @Override // d.u.z
    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    @Override // d.u.z
    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }

    @Override // d.u.z
    public void c(View view) {
        this.a.add(view);
    }

    @Override // d.u.z
    public void d(View view) {
        this.a.remove(view);
    }
}
