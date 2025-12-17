package androidx.databinding.k;

import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class e {

    private static final SparseArray<WeakHashMap<View, WeakReference<?>>> a;
    static {
        SparseArray sparseArray = new SparseArray();
        e.a = sparseArray;
    }

    public static <T> T a(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 14) {
            return view.getTag(i2);
        }
        SparseArray sparseArray = e.a;
        final Object obj3 = sparseArray.get(i2);
        int i3 = 0;
        synchronized (sparseArray) {
            return i3;
        }
    }

    public static <T> T b(View view, T t2, int i3) {
        Object weakHashMap;
        Object obj2;
        WeakReference obj4;
        if (Build.VERSION.SDK_INT >= 14) {
            view.setTag(i3, t2);
            return view.getTag(i3);
        }
        SparseArray sparseArray = e.a;
        synchronized (sparseArray) {
            weakHashMap = new WeakHashMap();
            sparseArray.put(i3, weakHashMap);
            if (t2 == null) {
                obj2 = weakHashMap.remove(view);
            } else {
                obj4 = new WeakReference(t2);
                obj2 = weakHashMap.put(view, obj4);
            }
            if (obj2 == null) {
                return 0;
            }
            return obj2.get();
        }
    }
}
