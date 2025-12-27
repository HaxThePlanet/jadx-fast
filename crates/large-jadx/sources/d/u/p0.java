package d.u;

import android.view.View;
import android.view.WindowId;

/* compiled from: WindowIdApi18.java */
/* loaded from: classes.dex */
class p0 implements q0 {

    private final WindowId a;
    p0(View view) {
        super();
        this.a = view.getWindowId();
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z;
        boolean z2 = false;
        z = object instanceof p0;
        if (object instanceof p0) {
            object = object.a.equals(this.a) ? 1 : 0;
        }
        return (object.a.equals(this.a) ? 1 : 0);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }
}
