package f.c.a.e.d0;

import android.view.View;
import com.google.android.material.internal.n;

/* loaded from: classes2.dex */
public class h {
    static f.c.a.e.d0.d a(int i) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return h.b();
            }
            e obj1 = new e();
            return obj1;
        }
        obj1 = new j();
        return obj1;
    }

    static f.c.a.e.d0.d b() {
        j jVar = new j();
        return jVar;
    }

    static f.c.a.e.d0.f c() {
        f fVar = new f();
        return fVar;
    }

    public static void d(View view, float f2) {
        final android.graphics.drawable.Drawable obj1 = view.getBackground();
        if (obj1 instanceof g) {
            (g)obj1.Y(f2);
        }
    }

    public static void e(View view) {
        final android.graphics.drawable.Drawable background = view.getBackground();
        if (background instanceof g) {
            h.f(view, (g)background);
        }
    }

    public static void f(View view, f.c.a.e.d0.g g2) {
        View obj1;
        if (g2.Q()) {
            g2.c0(n.d(view));
        }
    }
}
