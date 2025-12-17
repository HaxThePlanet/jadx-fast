package app.dogo.com.dogo_android.q.p;

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
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0008\u0010\u0012\u001a\u00020\u0013H\u0014J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewFullscreenScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "openDogParents", "", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "(ZLapp/dogo/com/dogo_android/repository/domain/ProfilePreview;)V", "getOpenDogParents", "()Z", "setOpenDogParents", "(Z)V", "getProfilePreview", "()Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "setProfilePreview", "(Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;)V", "component1", "component2", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class y extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.q.p.y> CREATOR;
    private boolean a;
    private ProfilePreview b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.q.p.y> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.q.p.y a(Parcel parcel) {
            int i;
            Parcelable.Creator cREATOR;
            Object obj4;
            n.f(parcel, "parcel");
            i = parcel.readInt() != 0 ? 1 : 0;
            if (parcel.readInt() == 0) {
                obj4 = 0;
            } else {
                obj4 = ProfilePreview.CREATOR.createFromParcel(parcel);
            }
            y yVar = new y(i, (ProfilePreview)obj4);
            return yVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.q.p.y[] b(int i) {
            return new y[i];
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
        y.a aVar = new y.a();
        y.CREATOR = aVar;
    }

    public y() {
        final int i2 = 0;
        super(0, i2, 3, i2);
    }

    public y(boolean z, ProfilePreview profilePreview2) {
        super();
        this.a = z;
        this.b = profilePreview2;
    }

    public y(boolean z, ProfilePreview profilePreview2, int i3, g g4) {
        int obj1;
        int obj2;
        obj1 = i3 & 1 != 0 ? 0 : obj1;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(obj1, obj2);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final void b(boolean z) {
        this.a = z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        x xVar = new x();
        return xVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return j3.B.f();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof y) {
            return i2;
        }
        if (this.a != object.a) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProfilePreview getProfilePreview() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        boolean z;
        int i;
        if (this.a) {
            z = 1;
        }
        ProfilePreview profilePreview = this.b;
        if (profilePreview == null) {
            i = 0;
        } else {
            i = profilePreview.hashCode();
        }
        return i2 += i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogPreviewFullscreenScreen(openDogParents=");
        stringBuilder.append(this.a);
        stringBuilder.append(", profilePreview=");
        stringBuilder.append(this.b);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int obj4;
        n.f(parcel, "out");
        parcel.writeInt(this.a);
        ProfilePreview profilePreview = this.b;
        if (profilePreview == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            profilePreview.writeToParcel(parcel, i2);
        }
    }
}
