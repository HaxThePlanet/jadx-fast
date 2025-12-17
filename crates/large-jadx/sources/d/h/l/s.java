package d.h.l;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.PointerIcon;

/* loaded from: classes.dex */
public final class s {

    private Object a;
    private s(Object object) {
        super();
        this.a = object;
    }

    public static d.h.l.s b(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            s sVar = new s(PointerIcon.getSystemIcon(context, i2));
            return sVar;
        }
        s obj2 = new s(0);
        return obj2;
    }

    public Object a() {
        return this.a;
    }
}
