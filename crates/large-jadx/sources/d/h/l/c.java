package d.h.l;

import android.os.Build.VERSION;
import android.view.DisplayCutout;
import d.h.k.c;

/* loaded from: classes.dex */
public final class c {

    private final Object a;
    private c(Object object) {
        super();
        this.a = object;
    }

    static d.h.l.c e(Object object) {
        d.h.l.c cVar;
        int obj1;
        if (object == null) {
            obj1 = 0;
        } else {
            cVar = new c(object);
            obj1 = cVar;
        }
        return obj1;
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return (DisplayCutout)this.a.getSafeInsetBottom();
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return (DisplayCutout)this.a.getSafeInsetLeft();
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return (DisplayCutout)this.a.getSafeInsetRight();
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return (DisplayCutout)this.a.getSafeInsetTop();
        }
        return 0;
    }

    public boolean equals(Object object) {
        Class<d.h.l.c> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        if (object != null && c.class != object.getClass()) {
            if (c.class != object.getClass()) {
            }
            return c.a(this.a, object.a);
        }
        return 0;
    }

    public int hashCode() {
        int i;
        Object obj = this.a;
        if (obj == null) {
            i = 0;
        } else {
            i = obj.hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DisplayCutoutCompat{");
        stringBuilder.append(this.a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
