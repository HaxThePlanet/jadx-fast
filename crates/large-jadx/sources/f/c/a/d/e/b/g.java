package f.c.a.d.e.b;

import android.os.IBinder;
import android.os.IInterface;
import f.c.a.d.b.e.a;
import f.c.a.d.b.e.c;

/* loaded from: classes2.dex */
public final class g extends a implements IInterface {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // f.c.a.d.b.e.a
    public final void p2(f.c.a.d.e.b.j j, f.c.a.d.e.b.f f2) {
        final android.os.Parcel parcel = j();
        c.b(parcel, j);
        c.c(parcel, f2);
        m(12, parcel);
    }
}
