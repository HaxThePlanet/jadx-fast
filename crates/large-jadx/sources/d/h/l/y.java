package d.h.l;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* compiled from: ViewParentCompat.java */
/* loaded from: classes.dex */
public final class y {
    public static boolean a(ViewParent viewParent, View view, float f, float f2, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
            } catch (java.lang.AbstractMethodError e) {
                f = new StringBuilder();
                f2 = "ViewParent ";
                f.append(f2);
                f.append(viewParent);
                viewParent = " does not implement interface method onNestedFling";
                f.append(viewParent);
                viewParent = f.toString();
                f = "ViewParentCompat";
                Log.e(f, viewParent, e);
            }
            return viewParent.onNestedFling(view, f, f2, z);
        }
        if (viewParent instanceof o) {
            return viewParent.onNestedFling(e, f, f2, z);
        }
        return false;
    }

    public static boolean b(ViewParent viewParent, View view, float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
            } catch (java.lang.AbstractMethodError e) {
                f = new StringBuilder();
                f2 = "ViewParent ";
                f.append(f2);
                f.append(viewParent);
                viewParent = " does not implement interface method onNestedPreFling";
                f.append(viewParent);
                viewParent = f.toString();
                f = "ViewParentCompat";
                Log.e(f, viewParent, e);
            }
            return viewParent.onNestedPreFling(view, f, f2);
        }
        if (viewParent instanceof o) {
            return viewParent.onNestedPreFling(e, f, f2);
        }
        return false;
    }

    public static void c(ViewParent viewParent, View view, int i, int i2, int[] iArr, int i3) {
        z = viewParent instanceof m;
        if (viewParent instanceof m) {
            (m)viewParent.onNestedPreScroll(view, i, i2, iArr, i3);
        } else {
            if (i3 == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        viewParent.onNestedPreScroll(view, i, i2, iArr);
                    } catch (java.lang.AbstractMethodError e) {
                        i = new StringBuilder();
                        i2 = "ViewParent ";
                        i.append(i2);
                        i.append(viewParent);
                        viewParent = " does not implement interface method onNestedPreScroll";
                        i.append(viewParent);
                        viewParent = i.toString();
                        i = "ViewParentCompat";
                        Log.e(i, viewParent, e);
                    }
                } else {
                    z2 = viewParent instanceof o;
                    if (viewParent instanceof o) {
                        viewParent.onNestedPreScroll(e, i, i2, iArr);
                    }
                }
            }
        }
    }

    public static void d(ViewParent viewParent, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        viewParent2 = viewParent;
        z = viewParent2 instanceof n;
        if (viewParent2 instanceof n) {
            viewParent2.onNestedScroll(view, i, i2, i3, i4, i5, iArr);
        } else {
            i2 = 0;
            iArr[i2] = iArr[i2] + i3;
            int i8 = 1;
            i = iArr[i8] + i4;
            iArr[i8] = i;
            z = viewParent2 instanceof m;
            if (viewParent2 instanceof m) {
                (m)viewParent2.onNestedScroll(view, i, i2, i3, i4, i5);
            } else {
                if (i5 == 0) {
                    i = 21;
                    if (Build.VERSION.SDK_INT >= 21) {
                        try {
                            viewParent.onNestedScroll(view, i, i2, i3, i4);
                        } catch (java.lang.AbstractMethodError e) {
                            e = new StringBuilder();
                            String str2 = "ViewParent ";
                            String str = " does not implement interface method onNestedScroll";
                            e = str2 + viewParent + str;
                            str = "ViewParentCompat";
                            Log.e(str, e, e);
                        }
                    } else {
                        z = viewParent2 instanceof o;
                        if (viewParent2 instanceof o) {
                            (o)viewParent2.onNestedScroll(view, i, i2, i3, i4);
                        }
                    }
                }
            }
        }
    }

    public static void e(ViewParent viewParent, View view, View view2, int i, int i2) {
        z = viewParent instanceof m;
        if (viewParent instanceof m) {
            viewParent.onNestedScrollAccepted(view, view2, i, i2);
        } else {
            if (i2 == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        viewParent.onNestedScrollAccepted(view, view2, i);
                    } catch (java.lang.AbstractMethodError e) {
                        view2 = new StringBuilder();
                        i = "ViewParent ";
                        view2.append(i);
                        view2.append(viewParent);
                        viewParent = " does not implement interface method onNestedScrollAccepted";
                        view2.append(viewParent);
                        viewParent = view2.toString();
                        view2 = "ViewParentCompat";
                        Log.e(view2, viewParent, e);
                    }
                } else {
                    z2 = viewParent instanceof o;
                    if (viewParent instanceof o) {
                        viewParent.onNestedScrollAccepted(e, view2, i);
                    }
                }
            }
        }
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i, int i2) {
        z = viewParent instanceof m;
        if (viewParent instanceof m) {
            return viewParent.onStartNestedScroll(view, view2, i, i2);
        }
        if (i2 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                } catch (java.lang.AbstractMethodError e) {
                    view2 = new StringBuilder();
                    i = "ViewParent ";
                    view2.append(i);
                    view2.append(viewParent);
                    viewParent = " does not implement interface method onStartNestedScroll";
                    view2.append(viewParent);
                    viewParent = view2.toString();
                    view2 = "ViewParentCompat";
                    Log.e(view2, viewParent, e);
                }
                return viewParent.onStartNestedScroll(view, view2, i);
            }
            z2 = viewParent instanceof o;
            if (viewParent instanceof o) {
                return viewParent.onStartNestedScroll(e, view2, i);
            }
        }
        return false;
    }

    public static void g(ViewParent viewParent, View view, int i) {
        z = viewParent instanceof m;
        if (viewParent instanceof m) {
            viewParent.onStopNestedScroll(view, i);
        } else {
            if (i == 0) {
                if (Build.VERSION.SDK_INT >= 21) {
                    try {
                        viewParent.onStopNestedScroll(view);
                    } catch (java.lang.AbstractMethodError e) {
                        i = new StringBuilder();
                        i.append("ViewParent ");
                        i.append(viewParent);
                        viewParent = " does not implement interface method onStopNestedScroll";
                        i.append(viewParent);
                        viewParent = i.toString();
                        i = "ViewParentCompat";
                        Log.e(i, viewParent, e);
                    }
                } else {
                    z2 = viewParent instanceof o;
                    if (viewParent instanceof o) {
                        viewParent.onStopNestedScroll(e);
                    }
                }
            }
        }
    }
}
