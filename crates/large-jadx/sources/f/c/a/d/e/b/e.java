package f.c.a.d.e.b;

import android.os.Parcel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.b;
import f.c.a.d.b.e.b;
import f.c.a.d.b.e.c;

/* loaded from: classes2.dex */
public abstract class e extends b implements f.c.a.d.e.b.f {
    public e() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // f.c.a.d.b.e.b
    protected final boolean p2(int i, Parcel parcel2, Parcel parcel3, int i4) {
        android.os.Parcelable obj1;
        switch (i) {
            case 3:
                obj1 = c.a(parcel2, b.CREATOR);
                obj1 = c.a(parcel2, b.CREATOR);
                break;
            case 4:
                obj1 = c.a(parcel2, Status.CREATOR);
                break;
            case 5:
                return 0;
            case 6:
                obj1 = c.a(parcel2, Status.CREATOR);
                break;
            case 7:
                obj1 = c.a(parcel2, Status.CREATOR);
                obj1 = c.a(parcel2, GoogleSignInAccount.CREATOR);
                break;
            case 8:
                U((l)c.a(parcel2, l.CREATOR));
                break;
            default:
                obj1 = c.a(parcel2, h.CREATOR);
        }
        parcel3.writeNoException();
        return 1;
    }
}
