package d.u;

import android.os.IBinder;

/* compiled from: WindowIdApi14.java */
/* loaded from: classes.dex */
class o0 implements q0 {

    private final IBinder a;
    o0(IBinder iBinder) {
        super();
        this.a = iBinder;
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        boolean z;
        boolean z2 = false;
        z = object instanceof o0;
        if (object instanceof o0) {
            object = object.a.equals(this.a) ? 1 : 0;
        }
        return (object.a.equals(this.a) ? 1 : 0);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.a.hashCode();
    }
}
