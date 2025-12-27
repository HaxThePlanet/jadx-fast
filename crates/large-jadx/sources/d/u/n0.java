package d.u;

import android.view.View;
import java.util.Map;

/* compiled from: VisibilityPropagation.java */
/* loaded from: classes.dex */
public abstract class n0 extends r {

    private static final String[] a;
    static {
        n0.a = new String[] { "android:visibilityPropagation:visibility", "android:visibilityPropagation:center" };
    }

    private static int d(u uVar, int i) {
        i = -1;
        if (uVar == null) {
            return i;
        }
        Object value = uVar.a.get("android:visibilityPropagation:center");
        if (value == null) {
            return i;
        }
        return value[i];
    }

    @Override // d.u.r
    public void a(u uVar) {
        Object value;
        if ((Integer)uVar.a.get("android:visibility:visibility") == null) {
            Integer num = Integer.valueOf(uVar.b.getVisibility());
        }
        uVar.a.put("android:visibilityPropagation:visibility", value);
        int i2 = 2;
        int[] iArr = new int[i2];
        uVar.b.getLocationOnScreen(iArr);
        int i3 = 0;
        iArr[i3] = iArr[i3] + Math.round(uVar.b.getTranslationX());
        iArr[i3] = iArr[i3] + (uVar.b.getWidth() / i2);
        int i4 = 1;
        iArr[i4] = iArr[i4] + Math.round(uVar.b.getTranslationY());
        iArr[i4] = iArr[i4] + (uVar.b.getHeight() / i2);
        uVar.a.put("android:visibilityPropagation:center", iArr);
    }

    @Override // d.u.r
    public String[] b() {
        return n0.a;
    }

    @Override // d.u.r
    public int e(u uVar) {
        final int i = 8;
        if (uVar == null) {
            return i;
        }
        Object value = uVar.a.get("android:visibilityPropagation:visibility");
        if (value == null) {
            return i;
        }
        return value.intValue();
    }

    @Override // d.u.r
    public int f(u uVar) {
        return n0.d(uVar, 0);
    }

    @Override // d.u.r
    public int g(u uVar) {
        return n0.d(uVar, 1);
    }
}
