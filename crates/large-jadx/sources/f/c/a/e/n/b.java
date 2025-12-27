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

/* compiled from: BadgeUtils.java */
/* loaded from: classes2.dex */
public class b {

    public static final boolean a = false;
    static {
        int r0 = Build.VERSION.SDK_INT < 18 ? 1 : 0;
    }

    public static void a(a aVar, View view, FrameLayout frameLayout) {
        b.e(aVar, view, frameLayout);
        if (aVar.i() != null) {
            aVar.i().setForeground(aVar);
            return;
        } else {
            if (!b.a) {
                view.getOverlay().add(aVar);
            }
        }
        throw new IllegalArgumentException("Trying to reference null customBadgeParent");
    }

    public static SparseArray<a> b(Context context, f fVar) {
        int i = 0;
        final SparseArray sparseArray = new SparseArray(fVar.size());
        i = 0;
        while (i < fVar.size()) {
            Object valueAt = fVar.valueAt(i);
            if (valueAt == null) {
                throw new IllegalArgumentException("BadgeDrawable's savedState cannot be null");
            }
        }
        return sparseArray;
    }

    public static f c(SparseArray<a> sparseArray) {
        int i = 0;
        f fVar = new f();
        i = 0;
        while (i < sparseArray.size()) {
            Object valueAt = sparseArray.valueAt(i);
            if (valueAt == null) {
                throw new IllegalArgumentException("badgeDrawable cannot be null");
            }
        }
        return fVar;
    }

    public static void d(a aVar, View view) {
        boolean z;
        if (aVar == null) {
            return;
        }
        if (b.a || aVar.i() != null) {
            aVar.i().setForeground(null);
        }
    }

    public static void e(a aVar, View view, FrameLayout frameLayout) {
        final Rect rect = new Rect();
        view.getDrawingRect(rect);
        aVar.setBounds(rect);
        aVar.L(view, frameLayout);
    }

    public static void f(Rect rect, float f, float f2, float f3, float f4) {
        rect.set((int)(f - f3), (int)(f2 - f4), (int)(f + f3), (int)(f2 + f4));
    }
}
