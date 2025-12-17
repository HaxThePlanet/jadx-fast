package app.dogo.com.dogo_android.profile.invitation;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0004HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/profile/invitation/DogInviteScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "()V", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.profile.invitation.i> CREATOR;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.profile.invitation.i> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.profile.invitation.i a(Parcel parcel) {
            n.f(parcel, "parcel");
            parcel.readInt();
            i obj2 = new i();
            return obj2;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.profile.invitation.i[] b(int i) {
            return new i[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }
    static {
        i.a aVar = new i.a();
        i.CREATOR = aVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        h hVar = new h();
        return hVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return j3.e.f();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100379;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeInt(1);
    }
}
