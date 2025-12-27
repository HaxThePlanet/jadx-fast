package f.c.a.d.b.b;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* loaded from: classes2.dex */
public abstract class g extends a implements h {
    public g() {
        super("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverResultCallback");
    }

    @Override // f.c.a.d.b.b.a
    protected final boolean j(int i, Parcel parcel, Parcel parcel2, int i2) {
        final int i3 = 1;
        if (i == i3) {
            l((Status)d.a(parcel, Status.CREATOR));
            return true;
        }
        return false;
    }
}
