package h.a.b.i;

import androidx.recyclerview.widget.RecyclerView;
import h.a.b.f.a;

/* loaded from: classes2.dex */
public final class a {
    public static String a(Object object) {
        String obj0;
        if (object == null) {
            obj0 = "null";
        } else {
            obj0 = object.getClass().getSimpleName();
        }
        return obj0;
    }

    public static String b(int i) {
        if (i != 1 && i != 2) {
            if (i != 2) {
                return "IDLE";
            }
            return "MULTI";
        }
        return "SINGLE";
    }

    public static int c(RecyclerView recyclerView) {
        a aVar = new a(recyclerView);
        return aVar.c();
    }
}
