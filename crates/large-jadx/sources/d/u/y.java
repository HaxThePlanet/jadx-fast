package d.u;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* compiled from: ViewGroupOverlayApi18.java */
/* loaded from: classes.dex */
class y implements z {

    private final ViewGroupOverlay a;
    y(ViewGroup viewGroup) {
        super();
        this.a = viewGroup.getOverlay();
    }

    public void a(Drawable drawable) {
        this.a.add(drawable);
    }

    public void b(Drawable drawable) {
        this.a.remove(drawable);
    }

    public void c(View view) {
        this.a.add(view);
    }

    public void d(View view) {
        this.a.remove(view);
    }
}
