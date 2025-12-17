package app.dogo.com.dogo_android.f.o;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j2;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.m3;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.u;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u000f\u001a\u00020\u0010H\u0014J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\nHÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nHÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\n8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/dailyworkout/workoutcompleted/DailyWorkoutCompletedScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "workoutSession", "Lapp/dogo/com/dogo_android/repository/domain/WorkoutStreakInfo;", "fragmentReturnTag", "", "(Lapp/dogo/com/dogo_android/repository/domain/WorkoutStreakInfo;Ljava/lang/String;)V", "getFragmentReturnTag", "()Ljava/lang/String;", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "getWorkoutSession", "()Lapp/dogo/com/dogo_android/repository/domain/WorkoutStreakInfo;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.f.o.c> CREATOR;
    private final WorkoutStreakInfo a;
    private final String b;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.f.o.c> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.f.o.c a(Parcel parcel) {
            n.f(parcel, "parcel");
            c cVar = new c((WorkoutStreakInfo)WorkoutStreakInfo.CREATOR.createFromParcel(parcel), parcel.readString());
            return cVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.f.o.c[] b(int i) {
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

    public c(WorkoutStreakInfo workoutStreakInfo, String string2) {
        n.f(workoutStreakInfo, "workoutSession");
        n.f(string2, "fragmentReturnTag");
        super();
        this.a = workoutStreakInfo;
        this.b = string2;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final WorkoutStreakInfo a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        b bVar = new b();
        return bVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        o2 o2Var = new o2();
        j2 j2Var = new j2();
        return j3.u0.c(u.a(o2Var, "workout"), u.a(j2Var, Integer.valueOf(this.a.getCurrentStreak())));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131099720;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, i2);
        parcel.writeString(this.b);
    }
}
