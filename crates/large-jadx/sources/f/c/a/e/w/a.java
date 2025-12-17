package f.c.a.e.w;

/* loaded from: classes2.dex */
public final class a {
    public static float a(float f, float f2, float f3, float f4) {
        f4 -= f2;
        return (float)obj0;
    }

    public static float b(float f, float f2, float f3, float f4, float f5, float f6) {
        return a.d(a.a(f, f2, f3, f4), a.a(f, f2, f5, f4), a.a(f, f2, f5, f6), a.a(f, f2, f3, f6));
    }

    public static float c(float f, float f2, float f3) {
        return i3 += obj3;
    }

    private static float d(float f, float f2, float f3, float f4) {
        int cmp;
        float obj1;
        if (Float.compare(f, f2) > 0 && Float.compare(f, f3) > 0 && Float.compare(f, f4) > 0) {
            if (Float.compare(f, f3) > 0) {
                if (Float.compare(f, f4) > 0) {
                } else {
                    if (Float.compare(f2, f3) > 0 && Float.compare(f2, f4) > 0) {
                        obj1 = Float.compare(f2, f4) > 0 ? f2 : obj1 > 0 ? f3 : f4;
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        return obj1;
    }
}
