package f.c.a.e.n;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewOverlay;
import android.widget.FrameLayout;
import com.google.android.material.internal.f;

/* loaded from: classes2.dex */
public class b {

    public static final boolean a = false;
    static {
        if (Build.VERSION.SDK_INT < 18) {
            int i = 1;
        }
        int i2 = 0;
    }

    public static void a(f.c.a.e.n.a a, View view2, FrameLayout frameLayout3) {
        Object obj1;
        FrameLayout obj2;
        b.e(a, view2, frameLayout3);
        if (a.i() != null) {
            a.i().setForeground(a);
        } else {
            if (b.a) {
            } else {
                view2.getOverlay().add(a);
            }
        }
        IllegalArgumentException obj0 = new IllegalArgumentException("Trying to reference null customBadgeParent");
        throw obj0;
    }

    public static SparseArray<f.c.a.e.n.a> b(Context context, f f2) {
        int i;
        int keyAt;
        f.c.a.e.n.a aVar;
        SparseArray sparseArray = new SparseArray(f2.size());
        i = 0;
        while (i < f2.size()) {
            Object valueAt = f2.valueAt(i);
            sparseArray.put(f2.keyAt(i), a.e(context, (a.b)valueAt));
            i++;
        }
        return sparseArray;
    }

    public static f c(SparseArray<f.c.a.e.n.a> sparseArray) {
        int i;
        int keyAt;
        f.c.a.e.n.a.b bVar;
        f fVar = new f();
        i = 0;
        while (i < sparseArray.size()) {
            Object valueAt = sparseArray.valueAt(i);
            fVar.put(sparseArray.keyAt(i), (a)valueAt.n());
            i++;
        }
        return fVar;
    }

    public static void d(f.c.a.e.n.a a, View view2) {
        FrameLayout z;
        Object obj1;
        ViewOverlay obj2;
        if (a == null) {
        }
        if (!b.a) {
            if (a.i() != null) {
                a.i().setForeground(0);
            } else {
                view2.getOverlay().remove(a);
            }
        } else {
        }
    }

    public static void e(f.c.a.e.n.a a, View view2, FrameLayout frameLayout3) {
        Rect rect = new Rect();
        view2.getDrawingRect(rect);
        a.setBounds(rect);
        a.L(view2, frameLayout3);
    }

    public static void f(Rect rect, float f2, float f3, float f4, float f5) {
        rect.set((int)i, (int)i3, (int)obj3, (int)obj4);
    }
}
