package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.j.b;
import androidx.lifecycle.n;
import androidx.lifecycle.q;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements n {

    private static int b;
    private static Field c;
    private static Field v;
    private static Field w;
    private Activity a;
    static {
    }

    ImmLeaksCleaner(Activity activity) {
        super();
        this.a = activity;
    }

    private static void e() {
        ImmLeaksCleaner.b = 2;
        Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
        ImmLeaksCleaner.v = declaredField;
        int i2 = 1;
        declaredField.setAccessible(i2);
        Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
        ImmLeaksCleaner.w = declaredField2;
        declaredField2.setAccessible(i2);
        Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
        ImmLeaksCleaner.c = declaredField3;
        declaredField3.setAccessible(i2);
        ImmLeaksCleaner.b = i2;
    }

    @Override // androidx.lifecycle.n
    public void c(q q, j.b j$b2) {
        Field field;
        int i;
        int obj3;
        int obj4;
        if (b2 != j.b.ON_DESTROY) {
        }
        if (ImmLeaksCleaner.b == 0) {
            ImmLeaksCleaner.e();
        }
        obj3 = this.a.getSystemService("input_method");
        obj4 = ImmLeaksCleaner.c.get((InputMethodManager)obj3);
        if (ImmLeaksCleaner.b == 1 && obj4 == null) {
            obj3 = this.a.getSystemService("input_method");
            obj4 = ImmLeaksCleaner.c.get((InputMethodManager)obj3);
            if (obj4 == null) {
            }
            Object obj = ImmLeaksCleaner.v.get(obj3);
            synchronized (obj4) {
            }
        }
    }
}
