package d.u;

import android.os.IBinder;

/* loaded from: classes.dex */
class o0 implements d.u.q0 {

    private final IBinder a;
    o0(IBinder iBinder) {
        super();
        this.a = iBinder;
    }

    @Override // d.u.q0
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof o0 && object.a.equals(this.a)) {
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
