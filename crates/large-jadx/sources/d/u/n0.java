package d.u;

import android.view.View;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class n0 extends d.u.r {

    private static final String[] a;
    static {
        n0.a = /* result */;
    }

    private static int d(d.u.u u, int i2) {
        final int i = -1;
        if (u == null) {
            return i;
        }
        Object obj2 = u.a.get("android:visibilityPropagation:center");
        if ((int[])obj2 == null) {
            return i;
        }
        return (int[])obj2[i2];
    }

    @Override // d.u.r
    public void a(d.u.u u) {
        Object valueOf;
        View view = u.b;
        if ((Integer)u.a.get("android:visibility:visibility") == null) {
            valueOf = Integer.valueOf(view.getVisibility());
        }
        u.a.put("android:visibilityPropagation:visibility", valueOf);
        int i2 = 2;
        int[] iArr = new int[i2];
        view.getLocationOnScreen(iArr);
        int i3 = 0;
        iArr[i3] = i5 += round;
        iArr[i3] = i7 += i13;
        int i4 = 1;
        iArr[i4] = i9 += round2;
        iArr[i4] = i11 += i;
        u.a.put("android:visibilityPropagation:center", iArr);
    }

    @Override // d.u.r
    public String[] b() {
        return n0.a;
    }

    @Override // d.u.r
    public int e(d.u.u u) {
        final int i = 8;
        if (u == null) {
            return i;
        }
        Object obj3 = u.a.get("android:visibilityPropagation:visibility");
        if ((Integer)obj3 == null) {
            return i;
        }
        return (Integer)obj3.intValue();
    }

    @Override // d.u.r
    public int f(d.u.u u) {
        return n0.d(u, 0);
    }

    @Override // d.u.r
    public int g(d.u.u u) {
        return n0.d(u, 1);
    }
}
