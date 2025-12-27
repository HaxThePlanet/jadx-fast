package app.dogo.com.dogo_android.g.g0;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DashboardSurveyScreen.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0008\u0010\u000f\u001a\u00020\u0010H\u0014J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u000cHÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000cHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u000c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/dashboard/survey/DashboardSurveyScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "dogName", "", "dogId", "fragmentReturnTag", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDogId", "()Ljava/lang/String;", "getDogName", "getFragmentReturnTag", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class DashboardSurveyScreen extends j {

    public static final Parcelable.Creator<j> CREATOR = new j$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String dogId;
    /* renamed from: b, reason: from kotlin metadata */
    private final String dogName;
    /* renamed from: c, reason: from kotlin metadata */
    private final String fragmentReturnTag;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<j> {
        public final j a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new DashboardSurveyScreen(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final j[] b(int i) {
            return new j[i];
        }
    }
    public j(String str, String str2, String str3) {
        n.f(str, "dogName");
        n.f(str2, "dogId");
        n.f(str3, "fragmentReturnTag");
        super();
        this.dogId = str;
        this.dogName = str2;
        this.fragmentReturnTag = str3;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final String createFragment() {
        return this.dogName;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String b() {
        return this.dogId;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new DashboardSurveyFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.clickerSoundSelection.b(new EP_ViewSource(), "dashboard");
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.fragmentReturnTag;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100377;
    }


    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.dogId);
        parcel.writeString(this.dogName);
        parcel.writeString(this.fragmentReturnTag);
    }
}
