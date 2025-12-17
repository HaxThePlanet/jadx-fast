package app.dogo.com.dogo_android.y.p;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0008\u0010\u0011\u001a\u00020\u0012H\u0014J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/examscompleted/ProgramExamsCompletedScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "programExamInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "dogName", "", "fragmentReturnTag", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;Ljava/lang/String;Ljava/lang/String;)V", "getDogName", "()Ljava/lang/String;", "getFragmentReturnTag", "getProgramExamInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.y.p.d> CREATOR;
    private final ProgramExamSummary a;
    private final String b;
    private final String c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.y.p.d> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.p.d a(Parcel parcel) {
            n.f(parcel, "parcel");
            d dVar = new d((ProgramExamSummary)ProgramExamSummary.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString());
            return dVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.p.d[] b(int i) {
            return new d[i];
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
        d.a aVar = new d.a();
        d.CREATOR = aVar;
    }

    public d(ProgramExamSummary programExamSummary, String string2, String string3) {
        n.f(programExamSummary, "programExamInfo");
        n.f(string2, "dogName");
        n.f(string3, "fragmentReturnTag");
        super();
        this.a = programExamSummary;
        this.b = string2;
        this.c = string3;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final String a() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProgramExamSummary b() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        c cVar = new c();
        return cVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return j3.b0.f();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100352;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, i2);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
