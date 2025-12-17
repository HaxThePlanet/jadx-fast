package app.dogo.com.dogo_android.q.p;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewNameScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "(Lapp/dogo/com/dogo_android/repository/domain/DogProfile;)V", "getDogProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d0 extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.q.p.d0> CREATOR;
    private final DogProfile a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.q.p.d0> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.q.p.d0 a(Parcel parcel) {
            n.f(parcel, "parcel");
            d0 d0Var = new d0((DogProfile)DogProfile.CREATOR.createFromParcel(parcel));
            return d0Var;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.q.p.d0[] b(int i) {
            return new d0[i];
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
        d0.a aVar = new d0.a();
        d0.CREATOR = aVar;
    }

    public d0(DogProfile dogProfile) {
        n.f(dogProfile, "dogProfile");
        super();
        this.a = dogProfile;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final DogProfile a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        c0 c0Var = new c0();
        return c0Var;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return j3.o.f();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, i2);
    }
}
