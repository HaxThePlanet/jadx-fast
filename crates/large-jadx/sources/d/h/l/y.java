package d.h.l;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public final class y {
    public static boolean a(ViewParent viewParent, View view2, float f3, float f4, boolean z5) {
        Object obj2;
        View obj3;
        float obj4;
        float obj5;
        if (Build.VERSION.SDK_INT >= 21) {
            return viewParent.onNestedFling(view2, f3, f4, z5);
        }
        if (viewParent instanceof o) {
            return (o)viewParent.onNestedFling(view2, f3, f4, z5);
        }
        return 0;
    }

    public static boolean b(ViewParent viewParent, View view2, float f3, float f4) {
        Object obj2;
        View obj3;
        float obj4;
        float obj5;
        if (Build.VERSION.SDK_INT >= 21) {
            return viewParent.onNestedPreFling(view2, f3, f4);
        }
        if (viewParent instanceof o) {
            return (o)viewParent.onNestedPreFling(view2, f3, f4);
        }
        return 0;
    }

    public static void c(ViewParent viewParent, View view2, int i3, int i4, int[] i5Arr5, int i6) {
        boolean i5;
        Object obj;
        View view;
        int i2;
        int i7;
        int[] iArr;
        int i;
        Object obj7;
        View obj8;
        int obj9;
        int obj10;
        boolean obj12;
        if (viewParent instanceof m) {
            (m)viewParent.onNestedPreScroll(view2, i3, i4, i5Arr5, i6);
        } else {
            if (!i6) {
                if (Build.VERSION.SDK_INT >= 21) {
                    viewParent.onNestedPreScroll(view2, i3, i4, i5Arr5);
                } else {
                    if (viewParent instanceof o) {
                        (o)viewParent.onNestedPreScroll(view2, i3, i4, i5Arr5);
                    }
                }
            }
        }
    }

    public static void d(ViewParent viewParent, View view2, int i3, int i4, int i5, int i6, int i7, int[] i8Arr8) {
        boolean sDK_INT;
        Object obj;
        int i2;
        Object str;
        View view;
        int i9;
        int i;
        int i8;
        int i11;
        int i10;
        obj = viewParent;
        if (obj instanceof n) {
            (n)obj.onNestedScroll(view2, i3, i4, i5, i6, i7, i8Arr8);
        } else {
            int i12 = 0;
            i8Arr8[i12] = i14 += i5;
            int i13 = 1;
            i8Arr8[i13] = i16 += i6;
            if (obj instanceof m) {
                (m)obj.onNestedScroll(view2, i3, i4, i5, i6, i7);
            } else {
                if (i7 == 0) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        viewParent.onNestedScroll(view2, i3, i4, i5, i6);
                    } else {
                        if (obj instanceof o) {
                            (o)obj.onNestedScroll(view2, i3, i4, i5, i6);
                        }
                    }
                }
            }
        }
    }

    public static void e(ViewParent viewParent, View view2, View view3, int i4, int i5) {
        boolean i;
        Object obj1;
        View obj2;
        View obj3;
        int obj4;
        int obj5;
        if (viewParent instanceof m) {
            (m)viewParent.onNestedScrollAccepted(view2, view3, i4, i5);
        } else {
            if (i5 == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    viewParent.onNestedScrollAccepted(view2, view3, i4);
                } else {
                    if (viewParent instanceof o) {
                        (o)viewParent.onNestedScrollAccepted(view2, view3, i4);
                    }
                }
            }
        }
    }

    public static boolean f(ViewParent viewParent, View view2, View view3, int i4, int i5) {
        boolean i;
        Object obj1;
        View obj2;
        View obj3;
        int obj4;
        int obj5;
        if (viewParent instanceof m) {
            return (m)viewParent.onStartNestedScroll(view2, view3, i4, i5);
        }
        if (i5 == 0 && Build.VERSION.SDK_INT >= 21) {
            if (Build.VERSION.SDK_INT >= 21) {
                return viewParent.onStartNestedScroll(view2, view3, i4);
            }
            if (viewParent instanceof o) {
                return (o)viewParent.onStartNestedScroll(view2, view3, i4);
            }
        }
        return 0;
    }

    public static void g(ViewParent viewParent, View view2, int i3) {
        boolean i;
        Object obj1;
        View obj2;
        int obj3;
        if (viewParent instanceof m) {
            (m)viewParent.onStopNestedScroll(view2, i3);
        } else {
            if (i3 == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    viewParent.onStopNestedScroll(view2);
                } else {
                    if (viewParent instanceof o) {
                        (o)viewParent.onStopNestedScroll(view2);
                    }
                }
            }
        }
    }
}
