package h.a.b.i;

import androidx.recyclerview.widget.RecyclerView;
import h.a.b.f.a;

/* compiled from: LayoutUtils.java */
/* loaded from: classes2.dex */
public final class a {
    public static String a(Object object) {
        String simpleName;
        if (object == null) {
            simpleName = "null";
        } else {
            simpleName = object.getClass().getSimpleName();
        }
        return simpleName;
    }

    public static int c(RecyclerView recyclerView) {
        return new a(recyclerView).c();
    }

    public static String b(int i) {
        if (i != 1 && i != 2) {
            return "IDLE";
        }
        return "SINGLE";
    }
}
