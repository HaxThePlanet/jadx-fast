package d.h.k;

import android.os.Build.VERSION;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: ObjectsCompat.java */
/* loaded from: classes.dex */
public class c {
    public static boolean a(Object object, Object object2) {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.equals(object, object2);
        }
        if (object == object2 || object != null) {
            int i2 = 1;
        } else {
            if (!(object.equals(object2))) {
                int i3 = 0;
            }
        }
        return z;
    }

    public static int b(Object... objectArr) {
        if (Build.VERSION.SDK_INT >= 19) {
            return Objects.hash(objectArr);
        }
        return Arrays.hashCode(objectArr);
    }

    public static String c(Object object, String str) {
        String object2;
        if (object != null) {
            object2 = object.toString();
        }
        return object2;
    }
}
