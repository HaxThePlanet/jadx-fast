package d.h.k;

/* compiled from: DebugUtils.java */
/* loaded from: classes.dex */
public class b {
    public static void a(Object object, StringBuilder sb) {
        String simpleName;
        int lastIndexOf;
        if (object == null) {
            str = "null";
            sb.append(str);
        } else {
            simpleName = object.getClass().getSimpleName();
            if (simpleName == null || simpleName.length() <= 0) {
                simpleName = object.getClass().getName();
                lastIndexOf = simpleName.lastIndexOf(46);
                if (lastIndexOf > 0) {
                    lastIndexOf = lastIndexOf + 1;
                    simpleName = simpleName.substring(lastIndexOf);
                }
            }
            sb.append(simpleName);
            char c = '{';
            sb.append(c);
            sb.append(Integer.toHexString(System.identityHashCode(object)));
        }
    }
}
