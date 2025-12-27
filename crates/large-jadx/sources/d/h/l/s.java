package d.h.l;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.PointerIcon;

/* compiled from: PointerIconCompat.java */
/* loaded from: classes.dex */
public final class s {

    private Object a;
    private s(Object object) {
        super();
        this.a = object;
    }

    public static s b(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 24) {
            return new s(PointerIcon.getSystemIcon(context, i));
        }
        return new s(null);
    }

    public Object a() {
        return this.a;
    }
}
