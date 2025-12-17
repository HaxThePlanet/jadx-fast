package app.dogo.com.dogo_android.q.r;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000cHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/profile/information/UserInformationScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "(Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;)V", "getProfilePreview", "()Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.q.r.c> CREATOR;
    private final ProfilePreview a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.q.r.c> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.q.r.c a(Parcel parcel) {
            int cREATOR;
            int obj3;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                obj3 = 0;
            } else {
                obj3 = ProfilePreview.CREATOR.createFromParcel(parcel);
            }
            c cVar = new c((ProfilePreview)obj3);
            return cVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.q.r.c[] b(int i) {
            return new c[i];
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
        c.a aVar = new c.a();
        c.CREATOR = aVar;
    }

    public c() {
        final int i = 0;
        super(i, 1, i);
    }

    public c(ProfilePreview profilePreview) {
        super();
        this.a = profilePreview;
    }

    public c(ProfilePreview profilePreview, int i2, g g3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        b bVar = new b();
        return bVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return j3.i.f();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProfilePreview getProfilePreview() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int obj4;
        n.f(parcel, "out");
        ProfilePreview profilePreview = this.a;
        if (profilePreview == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            profilePreview.writeToParcel(parcel, i2);
        }
    }
}
