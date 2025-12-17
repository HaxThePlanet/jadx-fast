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
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B'\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0008\u0010\u0016\u001a\u00020\u0017H\u0014J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "openDogParents", "", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "destination", "(ZLapp/dogo/com/dogo_android/repository/domain/ProfilePreview;Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;)V", "getDestination", "()Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "getOpenDogParents", "()Z", "setOpenDogParents", "(Z)V", "getProfilePreview", "()Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "setProfilePreview", "(Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;)V", "component1", "component2", "component3", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f0 extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.q.p.f0> CREATOR;
    private boolean a;
    private ProfilePreview b;
    private final j c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.q.p.f0> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.q.p.f0 a(Parcel parcel) {
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            i = parcel.readInt() != 0 ? 1 : 0;
            if (parcel.readInt() == 0) {
                fromParcel = 0;
            } else {
                fromParcel = ProfilePreview.CREATOR.createFromParcel(parcel);
            }
            f0 f0Var = new f0(i, (ProfilePreview)fromParcel, (j)parcel.readParcelable(f0.class.getClassLoader()));
            return f0Var;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.q.p.f0[] b(int i) {
            return new f0[i];
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
        f0.a aVar = new f0.a();
        f0.CREATOR = aVar;
    }

    public f0() {
        super(0, 0, 0, 7, 0);
    }

    public f0(boolean z, ProfilePreview profilePreview2, j j3) {
        super();
        this.a = z;
        this.b = profilePreview2;
        this.c = j3;
    }

    public f0(boolean z, ProfilePreview profilePreview2, j j3, int i4, g g5) {
        int obj2;
        int obj3;
        int obj4;
        obj2 = i4 & 1 != 0 ? 0 : obj2;
        final int i = 0;
        obj3 = i4 & 2 != 0 ? i : obj3;
        obj4 = i4 &= 4 != 0 ? i : obj4;
        super(obj2, obj3, obj4);
    }

    public static app.dogo.com.dogo_android.q.p.f0 b(app.dogo.com.dogo_android.q.p.f0 f0, boolean z2, ProfilePreview profilePreview3, j j4, int i5, Object object6) {
        boolean obj1;
        ProfilePreview obj2;
        j obj3;
        if (i5 & 1 != 0) {
            obj1 = f0.a;
        }
        if (i5 & 2 != 0) {
            obj2 = f0.b;
        }
        if (i5 &= 4 != 0) {
            obj3 = f0.c;
        }
        return f0.a(obj1, obj2, obj3);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final app.dogo.com.dogo_android.q.p.f0 a(boolean z, ProfilePreview profilePreview2, j j3) {
        f0 f0Var = new f0(z, profilePreview2, j3);
        return f0Var;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final j c() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        w wVar = new w();
        return wVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return j3.B.f();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean d() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final void e(boolean z) {
        this.a = z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof f0) {
            return i2;
        }
        if (this.a != object.a) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (!n.b(this.c, object.c)) {
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
        int i2;
        if (this.a) {
            z = 1;
        }
        ProfilePreview profilePreview = this.b;
        if (profilePreview == null) {
            i = i2;
        } else {
            i = profilePreview.hashCode();
        }
        j jVar = this.c;
        if (jVar == null) {
        } else {
            i2 = jVar.hashCode();
        }
        return i5 += i2;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogPreviewScreen(openDogParents=");
        stringBuilder.append(this.a);
        stringBuilder.append(", profilePreview=");
        stringBuilder.append(this.b);
        stringBuilder.append(", destination=");
        stringBuilder.append(this.c);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        int profilePreview;
        int i;
        n.f(parcel, "out");
        parcel.writeInt(this.a);
        profilePreview = this.b;
        if (profilePreview == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            profilePreview.writeToParcel(parcel, i2);
        }
        parcel.writeParcelable(this.c, i2);
    }
}
