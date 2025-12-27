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

/* compiled from: DogPreviewScreen.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B'\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0007J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÆ\u0003J+\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÆ\u0001J\u0008\u0010\u0016\u001a\u00020\u0017H\u0014J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u00032\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u001bHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f\"\u0004\u0008\u0010\u0010\u0011¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "openDogParents", "", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "destination", "(ZLapp/dogo/com/dogo_android/repository/domain/ProfilePreview;Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;)V", "getDestination", "()Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "getOpenDogParents", "()Z", "setOpenDogParents", "(Z)V", "getProfilePreview", "()Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "setProfilePreview", "(Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;)V", "component1", "component2", "component3", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f0, reason: from kotlin metadata */
public final /* data */ class DogPreviewScreen extends j {

    public static final Parcelable.Creator<f0> CREATOR = new f0$a<>();
    private boolean a;
    private ProfilePreview b;
    private final j c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<f0> {
        public final f0 a(Parcel parcel) {
            boolean z = true;
            ProfilePreview profilePreview = null;
            n.f(parcel, "parcel");
            int r1 = parcel.readInt() != 0 ? 1 : 0;
            if (parcel.readInt() == 0) {
                int i3 = 0;
            } else {
                Object fromParcel = ProfilePreview.CREATOR.createFromParcel(parcel);
            }
            DogPreviewScreen dogPreviewScreen = new DogPreviewScreen(z, (ProfilePreview)profilePreview, (AppScreen)parcel.readParcelable(DogPreviewScreen.class.getClassLoader()));
            return dogPreviewScreen;
        }

        public final f0[] b(int i) {
            return new f0[i];
        }
    }
    public /* synthetic */ f0(boolean z, ProfilePreview profilePreview, j jVar, int i, g gVar) {
        boolean z2 = false;
        if (i & 1 != 0) {
            int i2 = 0;
        }
        i = 0;
        i = i & 2 != 0 ? i : i;
        i = i & 4 != 0 ? i : i;
        this(z2, profilePreview, jVar);
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: c, reason: from kotlin metadata */
    /* operator */ public final j component1() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new DogPreviewFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.breedSearch.withoutParameters();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean d() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: e, reason: from kotlin metadata */
    /* operator */ public final void equals(boolean other) {
        this.a = other;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProfilePreview getProfilePreview() {
        return this.b;
    }

    public f0(boolean z, ProfilePreview profilePreview, j jVar) {
        super();
        this.a = z;
        this.b = profilePreview;
        this.c = jVar;
    }


    public f0() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ f0 b(f0 f0Var, boolean z, ProfilePreview profilePreview, j jVar, int i, Object object) {
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return f0Var.copy(z, profilePreview, jVar);
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final f0 copy(boolean openDogParents, ProfilePreview profilePreview, j destination) {
        return new DogPreviewScreen(openDogParents, profilePreview, destination);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z5 = false;
        if (!(object instanceof DogPreviewScreen)) {
            return false;
        }
        if (this.a != object.a) {
            return false;
        }
        if (!n.b(this.b, object.b)) {
            return false;
        }
        return !n.b(this.c, object.c) ? z5 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        boolean z = true;
        int i;
        if (this.a) {
            int i6 = 1;
        }
        i = 0;
        if (this.b == null) {
        } else {
            i = this.b.hashCode();
        }
        if (this.c != null) {
            i = this.c.hashCode();
        }
        return (z * 31) + i * 31 + i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogPreviewScreen(openDogParents=";
        String str3 = ", profilePreview=";
        String str4 = ", destination=";
        str = str2 + this.a + str3 + this.b + str4 + this.c + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.a);
        if (this.b == null) {
            int i = 0;
            parcel.writeInt(i);
        } else {
            int i2 = 1;
            parcel.writeInt(i2);
            this.b.writeToParcel(parcel, flags);
        }
        parcel.writeParcelable(this.c, flags);
    }
}
