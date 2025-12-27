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

/* compiled from: DogPreviewBreedScreen.kt */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0014", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBreedScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "(Lapp/dogo/com/dogo_android/repository/domain/DogProfile;)V", "getDogProfile", "()Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "getInitialFilterValue", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: t, reason: from kotlin metadata */
public final class DogPreviewBreedScreen extends j {

    public static final Parcelable.Creator<t> CREATOR = new t$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final DogProfile dogProfile;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<t> {
        public final t a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new DogPreviewBreedScreen((DogProfile)DogProfile.CREATOR.createFromParcel(parcel));
        }

        public final t[] b(int i) {
            return new t[i];
        }
    }
    public t(DogProfile dogProfile) {
        n.f(dogProfile, "dogProfile");
        super();
        this.dogProfile = dogProfile;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final DogProfile createFragment() {
        return this.dogProfile;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String b() {
        String customBreed;
        if (this.dogProfile.getCustomBreed() == null) {
            customBreed = "";
        }
        return customBreed;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new DogPreviewBreedFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.h.f();
    }


    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.dogProfile.writeToParcel(parcel, flags);
    }
}
