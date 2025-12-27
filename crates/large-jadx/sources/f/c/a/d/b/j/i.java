package f.c.a.d.b.j;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes2.dex */
public final class i extends a implements h {
    i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.safetynet.internal.ISafetyNetService");
    }

    @Override // f.c.a.d.b.j.a
    public final void Y(f fVar, byte[] bArr, String str) {
        final Parcel parcel = j();
        c.b(parcel, fVar);
        parcel.writeByteArray(bArr);
        parcel.writeString(str);
        m(7, parcel);
    }
}
