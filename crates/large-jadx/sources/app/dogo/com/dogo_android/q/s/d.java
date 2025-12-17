package app.dogo.com.dogo_android.q.s;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.e;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0008\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0008\u0010\t\u001a\u00020\nH\u0014J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsScreen;", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "(Lapp/dogo/com/dogo_android/repository/domain/DogProfile;)V", "getDogProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "component1", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends e {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.q.s.d> CREATOR;
    private final DogProfile a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.q.s.d> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.q.s.d a(Parcel parcel) {
            n.f(parcel, "parcel");
            d dVar = new d((DogProfile)DogProfile.CREATOR.createFromParcel(parcel));
            return dVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.q.s.d[] b(int i) {
            return new d[i];
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
        d.a aVar = new d.a();
        d.CREATOR = aVar;
    }

    public d(DogProfile dogProfile) {
        n.f(dogProfile, "dogProfile");
        super();
        this.a = dogProfile;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public final DogProfile a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.e
    protected Fragment createFragment() {
        c cVar = new c();
        return cVar;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public i3 createTrackingParameters() {
        return j3.f.f();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof d) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogParentsScreen(dogProfile=");
        stringBuilder.append(this.a);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, i2);
    }
}
