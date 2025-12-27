package f.c.a.e.d0;

import android.view.View;
import com.google.android.material.internal.n;

/* compiled from: MaterialShapeUtils.java */
/* loaded from: classes2.dex */
public class h {
    static d a(int i) {
        if (i != 0 && i != 1) {
            return h.b();
        }
        return new j();
    }

    static d b() {
        return new j();
    }

    static f c() {
        return new f();
    }

    public static void d(View view, float f) {
        final android.graphics.drawable.Drawable background = view.getBackground();
        if (background instanceof g) {
            background.Y(f);
        }
    }

    public static void e(View view) {
        final android.graphics.drawable.Drawable background = view.getBackground();
        if (background instanceof g) {
            h.f(view, background);
        }
    }

    public static void f(View view, g gVar) {
        if (gVar.Q()) {
            gVar.c0(n.d(view));
        }
    }
}
