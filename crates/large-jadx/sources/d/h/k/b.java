package d.h.k;

/* loaded from: classes.dex */
public class b {
    public static void a(Object object, StringBuilder stringBuilder2) {
        int i;
        String simpleName;
        int lastIndexOf;
        String obj2;
        if (object == null) {
            stringBuilder2.append("null");
        } else {
            simpleName = object.getClass().getSimpleName();
            if (simpleName != null) {
                simpleName = object.getClass().getName();
                lastIndexOf = simpleName.lastIndexOf(46);
                if (simpleName.length() <= 0 && lastIndexOf > 0) {
                    simpleName = object.getClass().getName();
                    lastIndexOf = simpleName.lastIndexOf(46);
                    if (lastIndexOf > 0) {
                        simpleName = simpleName.substring(lastIndexOf++);
                    }
                }
            } else {
            }
            stringBuilder2.append(simpleName);
            stringBuilder2.append('{');
            stringBuilder2.append(Integer.toHexString(System.identityHashCode(object)));
        }
    }
}
