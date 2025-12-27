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

/* compiled from: DogPreviewFullscreenScreen.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0008\u0010\u0012\u001a\u00020\u0013H\u0014J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewFullscreenScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "openDogParents", "", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "(ZLapp/dogo/com/dogo_android/repository/domain/ProfilePreview;)V", "getOpenDogParents", "()Z", "setOpenDogParents", "(Z)V", "getProfilePreview", "()Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "setProfilePreview", "(Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;)V", "component1", "component2", "copy", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: y, reason: from kotlin metadata */
public final /* data */ class DogPreviewFullscreenScreen extends j {

    public static final Parcelable.Creator<y> CREATOR = new y$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private boolean openDogParents;
    /* renamed from: b, reason: from kotlin metadata */
    private ProfilePreview profilePreview;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<y> {
        public final y a(Parcel parcel) {
            boolean z = true;
            ProfilePreview profilePreview = null;
            n.f(parcel, "parcel");
            int r1 = parcel.readInt() != 0 ? 1 : 0;
            if (parcel.readInt() == 0) {
                int i3 = 0;
            } else {
                Object fromParcel = ProfilePreview.CREATOR.createFromParcel(parcel);
            }
            DogPreviewFullscreenScreen dogPreviewFullscreenScreen = new DogPreviewFullscreenScreen(z, (ProfilePreview)profilePreview);
            return dogPreviewFullscreenScreen;
        }

        public final y[] b(int i) {
            return new y[i];
        }
    }
    public /* synthetic */ y(boolean z, ProfilePreview profilePreview, int i, g gVar) {
        boolean z2 = false;
        i = i & 1 != 0 ? 0 : i;
        int i2 = i & 2 != 0 ? 0 : i2;
        this(z2, profilePreview);
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final boolean component1() {
        return this.openDogParents;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: b, reason: from kotlin metadata */
    /* operator */ public final void equals(boolean other) {
        this.openDogParents = other;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new DogPreviewFullscreenFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.breedSearch.f();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProfilePreview getProfilePreview() {
        return this.profilePreview;
    }

    public y(boolean z, ProfilePreview profilePreview) {
        super();
        this.openDogParents = z;
        this.profilePreview = profilePreview;
    }


    public y() {
        final ProfilePreview profilePreview = null;
        this(false, profilePreview, 3, profilePreview);
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
        final boolean z3 = false;
        if (!(object instanceof DogPreviewFullscreenScreen)) {
            return false;
        }
        if (this.openDogParents != object.openDogParents) {
            return false;
        }
        return n.b(this.profilePreview, object.profilePreview) == null ? z3 : z;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int hashCode() {
        boolean openDogParents2 = true;
        int i = 0;
        if (this.openDogParents) {
            int i2 = 1;
        }
        if (this.profilePreview == null) {
            i = 0;
        } else {
            i = this.profilePreview.hashCode();
        }
        return (openDogParents2 * 31) + i;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogPreviewFullscreenScreen(openDogParents=";
        String str3 = ", profilePreview=";
        str = str2 + this.openDogParents + str3 + this.profilePreview + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.openDogParents);
        if (this.profilePreview == null) {
            int i2 = 0;
            parcel.writeInt(i2);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.profilePreview.writeToParcel(parcel, flags);
        }
    }
}
