package app.dogo.com.dogo_android.welcome_v2;

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
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0003\u001a\u00020\u0004H\u0014J\u0008\u0010\u0005\u001a\u00020\u0006H\u0016J\t\u0010\u0007\u001a\u00020\u0008HÖ\u0001J\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0008HÖ\u0001¨\u0006\u000e", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingStartScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "()V", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class r0 extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.welcome_v2.r0> CREATOR;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.welcome_v2.r0> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.welcome_v2.r0 a(Parcel parcel) {
            n.f(parcel, "parcel");
            parcel.readInt();
            r0 obj2 = new r0();
            return obj2;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.welcome_v2.r0[] b(int i) {
            return new r0[i];
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
        r0.a aVar = new r0.a();
        r0.CREATOR = aVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        q0 q0Var = new q0();
        return q0Var;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return j3.d.f();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeInt(1);
    }
}
