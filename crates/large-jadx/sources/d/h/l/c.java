package d.h.l;

import android.os.Build.VERSION;
import android.view.DisplayCutout;
import d.h.k.c;

/* compiled from: DisplayCutoutCompat.java */
/* loaded from: classes.dex */
public final class c {

    private final Object a;
    private c(Object object) {
        super();
        this.a = object;
    }

    static c e(Object object) {
        int i = 0;
        object = object == null ? 0 : new c(object);
        return (object == null ? 0 : new c(object));
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
        if (this == object) {
            return true;
        }
        if (object != null) {
            obj = c.class;
            return c.a(this.a, object.a);
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        if (this.a == null) {
            i = 0;
        } else {
            i = this.a.hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DisplayCutoutCompat{";
        String str3 = "}";
        str = str2 + this.a + str3;
        return str;
    }
}
