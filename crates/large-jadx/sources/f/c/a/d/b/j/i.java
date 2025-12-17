package f.c.a.d.b.j;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes2.dex */
public final class i extends f.c.a.d.b.j.a implements f.c.a.d.b.j.h {
    i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.safetynet.internal.ISafetyNetService");
    }

    @Override // f.c.a.d.b.j.a
    public final void Y(f.c.a.d.b.j.f f, byte[] b2Arr2, String string3) {
        final Parcel parcel = j();
        c.b(parcel, f);
        parcel.writeByteArray(b2Arr2);
        parcel.writeString(string3);
        m(7, parcel);
    }
}
