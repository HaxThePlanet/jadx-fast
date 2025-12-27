package f.c.a.d.e.b;

import android.os.IBinder;
import android.os.IInterface;
import f.c.a.d.b.e.a;
import f.c.a.d.b.e.c;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public final class g extends a implements IInterface {
    g(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
    }

    @Override // f.c.a.d.b.e.a
    public final void p2(j jVar, f fVar) {
        final android.os.Parcel parcel = j();
        c.b(parcel, jVar);
        c.c(parcel, fVar);
        m(12, parcel);
    }
}
