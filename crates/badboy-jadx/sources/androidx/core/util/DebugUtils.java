package androidx.core.util;

/* loaded from: classes5.dex */
public class DebugUtils {
    public static void buildShortClassTag(Object cls, StringBuilder out) {
        String simpleName;
        String lastIndexOf;
        int i;
        if (cls == null) {
            out.append("null");
        } else {
            simpleName = cls.getClass().getSimpleName();
            if (simpleName != null) {
                simpleName = cls.getClass().getName();
                lastIndexOf = simpleName.lastIndexOf(46);
                if (simpleName.length() <= 0 && lastIndexOf > 0) {
                    simpleName = cls.getClass().getName();
                    lastIndexOf = simpleName.lastIndexOf(46);
                    if (lastIndexOf > 0) {
                        simpleName = simpleName.substring(lastIndexOf + 1);
                    }
                }
            } else {
            }
            out.append(simpleName);
            out.append('{');
            out.append(Integer.toHexString(System.identityHashCode(cls)));
        }
    }
}
