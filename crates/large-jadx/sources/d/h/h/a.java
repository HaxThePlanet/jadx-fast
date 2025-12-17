package d.h.h;

/* loaded from: classes.dex */
public class a {
    public static float a(float f, float f2, float f3) {
        if (Float.compare(f, f2) < 0) {
            return f2;
        }
        if (Float.compare(f, f3) > 0) {
            return f3;
        }
        return f;
    }

    public static int b(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        if (i > i3) {
            return i3;
        }
        return i;
    }
}
