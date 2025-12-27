package app.dogo.com.dogo_android.d.e;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ChallengeReportInfo;
import app.dogo.com.dogo_android.util.e;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: ChallengeReportScreen.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/challenge/report/ChallengeReportScreen;", "Lapp/dogo/com/dogo_android/util/AppDialogScreen;", "challengeReportInfo", "Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo;", "(Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo;)V", "getChallengeReportInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ChallengeReportInfo;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public final class ChallengeReportScreen extends e {

    public static final Parcelable.Creator<d> CREATOR = new d$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final ChallengeReportInfo challengeReportInfo;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<d> {
        public final d a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new ChallengeReportScreen((ChallengeReportInfo)ChallengeReportInfo.CREATOR.createFromParcel(parcel));
        }

        public final d[] b(int i) {
            return new d[i];
        }
    }
    public d(ChallengeReportInfo challengeReportInfo) {
        n.f(challengeReportInfo, "challengeReportInfo");
        super();
        this.challengeReportInfo = challengeReportInfo;
    }

    @Override // app.dogo.com.dogo_android.util.e
    /* renamed from: a, reason: from kotlin metadata */
    public final ChallengeReportInfo createFragment() {
        return this.challengeReportInfo;
    }

    @Override // app.dogo.com.dogo_android.util.e
    protected Fragment createFragment() {
        return new ChallengeReportDialog();
    }

    @Override // app.dogo.com.dogo_android.util.e
    public i3 createTrackingParameters() {
        return S.examPreview.withoutParameters();
    }


    @Override // app.dogo.com.dogo_android.util.e
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.e
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.challengeReportInfo.writeToParcel(parcel, flags);
    }
}
