package f.g.e;

/* loaded from: classes2.dex */
public final class f {
    public static boolean a(Object... objectArr) {
        int i;
        Object obj;
        final int i2 = 0;
        i = i2;
        while (i < objectArr.length) {
            i++;
        }
        return 1;
    }

    public static String b(Object object) {
        return f.c(object, "null");
    }

    public static String c(Object object, String string2) {
        String obj1;
        if (object == null) {
        } else {
            obj1 = object.toString();
        }
        return obj1;
    }
}
