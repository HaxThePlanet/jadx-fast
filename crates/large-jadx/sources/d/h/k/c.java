package d.h.k;

import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public class c {
    public static boolean a(Object object, Object object2) {
        Object obj2;
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.equals(object, object2);
        }
        if (object != object2) {
            if (object != null && object.equals(object2)) {
                if (object.equals(object2)) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
        } else {
        }
        return obj2;
    }

    public static int b(Object... objectArr) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.hash(objectArr);
        }
        return Arrays.hashCode(objectArr);
    }

    public static String c(Object object, String string2) {
        String obj1;
        if (object != null) {
            obj1 = object.toString();
        }
        return obj1;
    }
}
