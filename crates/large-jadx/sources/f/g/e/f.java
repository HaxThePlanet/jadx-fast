package f.g.e;

/* compiled from: ObjectUtils.java */
/* loaded from: classes2.dex */
public final class f {
    public static boolean a(Object... objectArr) {
        int i;
        i = 0;
        for (Object obj : objectArr) {
            if (obj == null) {
                return false;
            }
        }
        return true;
    }

    public static String b(Object object) {
        return f.c(object, "null");
    }

    public static String c(Object object, String str) {
        String object2;
        if (object != null) {
            object2 = object.toString();
        }
        return object2;
    }
}
