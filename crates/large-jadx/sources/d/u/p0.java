package d.u;

import android.view.View;
import android.view.WindowId;

/* loaded from: classes.dex */
class p0 implements d.u.q0 {

    private final WindowId a;
    p0(View view) {
        super();
        this.a = view.getWindowId();
    }

    @Override // d.u.q0
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof p0 && object.a.equals(this.a)) {
            obj2 = object.a.equals(this.a) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // d.u.q0
    public int hashCode() {
        return this.a.hashCode();
    }
}
