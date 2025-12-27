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

/* compiled from: UserInformationScreen.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000cHÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/profile/information/UserInformationScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "(Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;)V", "getProfilePreview", "()Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class UserInformationScreen extends j {

    public static final Parcelable.Creator<c> CREATOR = new c$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final ProfilePreview profilePreview;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<c> {
        public final c a(Parcel parcel) {
            ProfilePreview profilePreview = null;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                int i = 0;
            } else {
                Object fromParcel = ProfilePreview.CREATOR.createFromParcel(parcel);
            }
            UserInformationScreen userInformationScreen = new UserInformationScreen((ProfilePreview)profilePreview);
            return userInformationScreen;
        }

        public final c[] b(int i) {
            return new c[i];
        }
    }
    public c(ProfilePreview profilePreview) {
        super();
        this.profilePreview = profilePreview;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new UserInformationFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.onboardingPagerBonding.withoutParameters();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProfilePreview getProfilePreview() {
        return this.profilePreview;
    }

    public /* synthetic */ c(ProfilePreview profilePreview, int i, g gVar) {
        ProfilePreview profilePreview2 = null;
        i = i & 1 != 0 ? 0 : i;
        this(profilePreview2);
    }


    public c() {
        final ProfilePreview profilePreview = null;
        this(profilePreview, 1, profilePreview);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
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
