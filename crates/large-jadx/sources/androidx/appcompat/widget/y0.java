package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class y0 extends Resources {

    private static boolean b = false;
    private final WeakReference<Context> a;
    static {
    }

    public y0(Context context, Resources resources2) {
        super(resources2.getAssets(), resources2.getDisplayMetrics(), resources2.getConfiguration());
        WeakReference obj4 = new WeakReference(context);
        this.a = obj4;
    }

    public static boolean a() {
        return y0.b;
    }

    public static void b(boolean z) {
        y0.b = z;
    }

    public static boolean c() {
        boolean sDK_INT;
        int i;
        int i2;
        if (y0.a() && Build.VERSION.SDK_INT <= 20) {
            i = Build.VERSION.SDK_INT <= 20 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // android.content.res.Resources
    final Drawable d(int i) {
        return super.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Object obj = this.a.get();
        if ((Context)obj != null) {
            return j0.h().t((Context)obj, this, i);
        }
        return super.getDrawable(i);
    }
}
