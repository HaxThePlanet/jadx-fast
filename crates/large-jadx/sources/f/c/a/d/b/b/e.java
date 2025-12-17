package f.c.a.d.b.b;

import android.os.IBinder;

/* loaded from: classes2.dex */
public final class e extends f.c.a.d.b.b.c implements f.c.a.d.b.b.f {
    e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
    }

    @Override // f.c.a.d.b.b.c
    public final void e1(f.c.a.d.b.b.h h) {
        final android.os.Parcel parcel = j();
        d.b(parcel, h);
        m(1, parcel);
    }
}
