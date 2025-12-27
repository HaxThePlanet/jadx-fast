package f.c.a.d.e.b;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import f.c.a.d.b.e.c;

/* compiled from: com.google.android.gms:play-services-base@@17.6.0 */
/* loaded from: classes2.dex */
public abstract class e extends f.c.a.d.b.e.b implements f {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // f.c.a.d.b.e.b
    protected final boolean p2(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 3:
                android.os.Parcelable parcelable = c.a(parcel, b.CREATOR);
                break;
            case 4:
                parcelable = c.a(parcel, Status.CREATOR);
                break;
            case 5:
                return false;
            case 6:
                parcelable = c.a(parcel, Status.CREATOR);
                break;
            case 7:
                parcelable = c.a(parcel, GoogleSignInAccount.CREATOR);
                break;
            case 8:
                U((l)c.a(parcel, l.CREATOR));
                break;
            default:
                parcelable = c.a(parcel, h.CREATOR);
        }
        parcel2.writeNoException();
        return true;
    }
}
