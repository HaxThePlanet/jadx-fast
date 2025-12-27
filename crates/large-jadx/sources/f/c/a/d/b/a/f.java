package f.c.a.d.b.a;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes2.dex */
public final class f extends a implements d {
    f(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override // f.c.a.d.b.a.a
    public final String getId() {
        Parcel parcel2 = m(1, j());
        parcel2.recycle();
        return parcel2.readString();
    }

    @Override // f.c.a.d.b.a.a
    public final boolean l0(boolean z) {
        Parcel parcel = j();
        c.a(parcel, true);
        Parcel parcel2 = m(2, parcel);
        parcel2.recycle();
        return c.b(parcel2);
    }

    @Override // f.c.a.d.b.a.a
    public final boolean zzc() {
        Parcel parcel2 = m(6, j());
        parcel2.recycle();
        return c.b(parcel2);
    }
}
