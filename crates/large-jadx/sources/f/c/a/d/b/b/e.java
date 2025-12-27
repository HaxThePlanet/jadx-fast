package f.c.a.d.b.b;

import android.os.IBinder;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* loaded from: classes2.dex */
public final class e extends c implements f {
    e(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
    }

    @Override // f.c.a.d.b.b.c
    public final void e1(h hVar) {
        final android.os.Parcel parcel = j();
        d.b(parcel, hVar);
        m(1, parcel);
    }
}
