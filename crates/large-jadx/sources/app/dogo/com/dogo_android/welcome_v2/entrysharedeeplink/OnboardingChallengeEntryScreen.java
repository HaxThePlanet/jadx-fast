package app.dogo.com.dogo_android.welcome_v2.w0;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: OnboardingChallengeEntryScreen.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0008\u0010\u000b\u001a\u00020\u000cH\u0014J\u0008\u0010\r\u001a\u00020\u000eH\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/entrysharedeeplink/OnboardingChallengeEntryScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "entryId", "", "challengeId", "linkType", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getChallengeId", "()Ljava/lang/String;", "getEntryId", "getLinkType", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class OnboardingChallengeEntryScreen extends j {

    public static final Parcelable.Creator<j> CREATOR = new j$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String challengeId;
    /* renamed from: b, reason: from kotlin metadata */
    private final String entryId;
    /* renamed from: c, reason: from kotlin metadata */
    private final String linkType;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<j> {
        public final j a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new OnboardingChallengeEntryScreen(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final j[] b(int i) {
            return new j[i];
        }
    }
    public j(String str, String str2, String str3) {
        n.f(str, "entryId");
        n.f(str2, "challengeId");
        n.f(str3, "linkType");
        super();
        this.challengeId = str;
        this.entryId = str2;
        this.linkType = str3;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final String createFragment() {
        return this.entryId;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String b() {
        return this.challengeId;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String c() {
        return this.linkType;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new OnboardingChallengeEntryFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.clickerHelp.withoutParameters();
    }


    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.challengeId);
        parcel.writeString(this.entryId);
        parcel.writeString(this.linkType);
    }
}
