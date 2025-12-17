package f.c.a.d.b.b;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public abstract class g extends f.c.a.d.b.b.a implements f.c.a.d.b.b.h {
    public g() {
        super("com.google.android.gms.auth.api.phone.internal.ISmsRetrieverResultCallback");
    }

    @Override // f.c.a.d.b.b.a
    protected final boolean j(int i, Parcel parcel2, Parcel parcel3, int i4) {
        final int obj3 = 1;
        if (i == obj3) {
            l((Status)d.a(parcel2, Status.CREATOR));
            return obj3;
        }
        return 0;
    }
}
