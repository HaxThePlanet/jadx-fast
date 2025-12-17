package androidx.databinding;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

/* loaded from: classes.dex */
public class f {

    private static androidx.databinding.d a;
    private static androidx.databinding.e b;
    static {
        DataBinderMapperImpl dataBinderMapperImpl = new DataBinderMapperImpl();
        f.a = dataBinderMapperImpl;
        f.b = 0;
    }

    static <T extends androidx.databinding.ViewDataBinding> T a(androidx.databinding.e e, View view2, int i3) {
        return f.a.b(e, view2, i3);
    }

    static <T extends androidx.databinding.ViewDataBinding> T b(androidx.databinding.e e, View[] view2Arr2, int i3) {
        return f.a.c(e, view2Arr2, i3);
    }

    private static <T extends androidx.databinding.ViewDataBinding> T c(androidx.databinding.e e, ViewGroup viewGroup2, int i3, int i4) {
        int i;
        View childAt;
        int childCount = viewGroup2.getChildCount();
        final int i5 = childCount - i3;
        int i6 = 1;
        if (i5 == i6) {
            return f.a(e, viewGroup2.getChildAt(childCount -= i6), i4);
        }
        View[] arr = new View[i5];
        i = 0;
        while (i < i5) {
            arr[i] = viewGroup2.getChildAt(i + i3);
            i++;
        }
        return f.b(e, arr, i4);
    }

    public static <T extends androidx.databinding.ViewDataBinding> T d(View view) {
        return ViewDataBinding.s(view);
    }

    public static androidx.databinding.e e() {
        return f.b;
    }

    public static <T extends androidx.databinding.ViewDataBinding> T f(LayoutInflater layoutInflater, int i2, ViewGroup viewGroup3, boolean z4, androidx.databinding.e e5) {
        int childCount;
        int i;
        if (viewGroup3 != null && z4) {
            i = z4 ? 1 : childCount;
        } else {
        }
        if (i != 0) {
            childCount = viewGroup3.getChildCount();
        }
        if (i != 0) {
            return f.c(e5, viewGroup3, childCount, i2);
        }
        return f.a(e5, layoutInflater.inflate(i2, viewGroup3, z4), i2);
    }

    public static <T extends androidx.databinding.ViewDataBinding> T g(Activity activity, int i2) {
        return f.h(activity, i2, f.b);
    }

    public static <T extends androidx.databinding.ViewDataBinding> T h(Activity activity, int i2, androidx.databinding.e e3) {
        activity.setContentView(i2);
        return f.c(e3, (ViewGroup)activity.getWindow().getDecorView().findViewById(16908290), 0, i2);
    }
}
