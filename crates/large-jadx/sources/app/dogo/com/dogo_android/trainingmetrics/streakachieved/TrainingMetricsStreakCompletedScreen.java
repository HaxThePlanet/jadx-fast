package app.dogo.com.dogo_android.x.d;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import app.dogo.com.dogo_android.util.g;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j2;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.m3;
import app.dogo.com.dogo_android.w.o2;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.u;

/* compiled from: TrainingMetricsStreakCompletedScreen.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\u0008\u0010\u0013\u001a\u00020\u0014H\u0014J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\rHÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0014\u0010\u000c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\n¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/streakachieved/TrainingMetricsStreakCompletedScreen;", "Lapp/dogo/com/dogo_android/util/ChainableAppScreen;", "timeMetrics", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "dogName", "", "viewSource", "fragmentReturnTag", "(Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDogName", "()Ljava/lang/String;", "getFragmentReturnTag", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "getTimeMetrics", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "getViewSource", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class TrainingMetricsStreakCompletedScreen extends g {

    public static final Parcelable.Creator<c> CREATOR = new c$a<>();
    private final TrainingTimeMetrics v;
    /* renamed from: w, reason: from kotlin metadata */
    private final String fragmentReturnTag;
    private final String x;
    private final String y;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<c> {
        public final c a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new TrainingMetricsStreakCompletedScreen((TrainingTimeMetrics)TrainingTimeMetrics.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final c[] b(int i) {
            return new c[i];
        }
    }
    public c(TrainingTimeMetrics trainingTimeMetrics, String str, String str2, String str3) {
        n.f(trainingTimeMetrics, "timeMetrics");
        n.f(str, "dogName");
        n.f(str2, "viewSource");
        n.f(str3, "fragmentReturnTag");
        super(str3);
        this.v = trainingTimeMetrics;
        this.fragmentReturnTag = str;
        this.x = str2;
        this.y = str3;
    }

    @Override // app.dogo.com.dogo_android.util.g
    protected Fragment createFragment() {
        return new TrainingMetricsStreakCompletedFragment();
    }

    @Override // app.dogo.com.dogo_android.util.g
    public i3 createTrackingParameters() {
        String str;
        str = "workout";
        if (!(n.b(this.x, str))) {
            str = "training";
        }
        return S.signIn.withParameters(u.a(new EP_Type(), str), u.a(new EP_Streak(), Integer.valueOf(this.v.getCurrentStreak())));
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final String e() {
        return this.fragmentReturnTag;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final TrainingTimeMetrics f() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public String getFragmentReturnTag() {
        return this.y;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public Integer getStatusBarColor() {
        return 2131099720;
    }


    @Override // app.dogo.com.dogo_android.util.g
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.v.writeToParcel(parcel, flags);
        parcel.writeString(this.fragmentReturnTag);
        parcel.writeString(this.x);
        parcel.writeString(this.y);
    }
}
