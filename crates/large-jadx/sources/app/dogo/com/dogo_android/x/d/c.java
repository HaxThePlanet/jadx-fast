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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\u0008\u0010\u0013\u001a\u00020\u0014H\u0014J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\rHÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0007\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0014\u0010\u000c\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\n¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/streakachieved/TrainingMetricsStreakCompletedScreen;", "Lapp/dogo/com/dogo_android/util/ChainableAppScreen;", "timeMetrics", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "dogName", "", "viewSource", "fragmentReturnTag", "(Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDogName", "()Ljava/lang/String;", "getFragmentReturnTag", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "getTimeMetrics", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "getViewSource", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends g {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.x.d.c> CREATOR;
    private final TrainingTimeMetrics v;
    private final String w;
    private final String x;
    private final String y;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.x.d.c> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.x.d.c a(Parcel parcel) {
            n.f(parcel, "parcel");
            c cVar = new c((TrainingTimeMetrics)TrainingTimeMetrics.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString(), parcel.readString());
            return cVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.x.d.c[] b(int i) {
            return new c[i];
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
        c.a aVar = new c.a();
        c.CREATOR = aVar;
    }

    public c(TrainingTimeMetrics trainingTimeMetrics, String string2, String string3, String string4) {
        n.f(trainingTimeMetrics, "timeMetrics");
        n.f(string2, "dogName");
        n.f(string3, "viewSource");
        n.f(string4, "fragmentReturnTag");
        super(string4);
        this.v = trainingTimeMetrics;
        this.w = string2;
        this.x = string3;
        this.y = string4;
    }

    @Override // app.dogo.com.dogo_android.util.g
    protected Fragment createFragment() {
        b bVar = new b();
        return bVar;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public i3 createTrackingParameters() {
        String str;
        o2 o2Var = new o2();
        if (n.b(this.x, "workout")) {
        } else {
            str = "training";
        }
        j2 j2Var = new j2();
        return j3.v0.c(u.a(o2Var, str), u.a(j2Var, Integer.valueOf(this.v.getCurrentStreak())));
    }

    @Override // app.dogo.com.dogo_android.util.g
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final String e() {
        return this.w;
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
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.v.writeToParcel(parcel, i2);
        parcel.writeString(this.w);
        parcel.writeString(this.x);
        parcel.writeString(this.y);
    }
}
