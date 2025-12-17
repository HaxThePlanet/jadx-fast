package app.dogo.com.dogo_android.y.u;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.util.g;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0008\u0010\u0013\u001a\u00020\u0014H\u0014J\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\t\u0010\u0017\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/lessonexamunlocked/ProgramLessonExamUnlockedScreen;", "Lapp/dogo/com/dogo_android/util/ChainableAppScreen;", "saveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "hasUserUnlockedFirstExam", "", "fragmentReturnTag", "", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;ZLjava/lang/String;)V", "getFragmentReturnTag", "()Ljava/lang/String;", "getHasUserUnlockedFirstExam", "()Z", "getSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends g {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.y.u.e> CREATOR;
    private final ProgramSaveInfo v;
    private final boolean w;
    private final String x;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.y.u.e> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.u.e a(Parcel parcel) {
            int i;
            n.f(parcel, "parcel");
            i = parcel.readInt() != 0 ? 1 : 0;
            e eVar = new e((ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), i, parcel.readString());
            return eVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.u.e[] b(int i) {
            return new e[i];
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
        e.a aVar = new e.a();
        e.CREATOR = aVar;
    }

    public e(ProgramSaveInfo programSaveInfo, boolean z2, String string3) {
        n.f(programSaveInfo, "saveInfo");
        n.f(string3, "fragmentReturnTag");
        super(string3);
        this.v = programSaveInfo;
        this.w = z2;
        this.x = string3;
    }

    @Override // app.dogo.com.dogo_android.util.g
    protected Fragment createFragment() {
        d dVar = new d();
        return dVar;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public i3 createTrackingParameters() {
        return j3.i0.f();
    }

    @Override // app.dogo.com.dogo_android.util.g
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final boolean e() {
        return this.w;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public final ProgramSaveInfo f() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public String getFragmentReturnTag() {
        return this.x;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public Integer getStatusBarColor() {
        return 2131100352;
    }

    @Override // app.dogo.com.dogo_android.util.g
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.v.writeToParcel(parcel, i2);
        parcel.writeInt(this.w);
        parcel.writeString(this.x);
    }
}
