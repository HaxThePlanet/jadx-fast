package app.dogo.com.dogo_android.y.d0;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ProgramTrainingPlanScreen.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0008\u0010\u0017\u001a\u00020\u0018H\u0014J\u0008\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0012HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/trainingsession/ProgramTrainingPlanScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "trainingSession", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "saveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "fragmentParentReturnTag", "", "firstLessonFlow", "", "(Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;Z)V", "getFirstLessonFlow", "()Z", "getFragmentParentReturnTag", "()Ljava/lang/String;", "getSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "statusBarColor", "", "getStatusBarColor", "()Ljava/lang/Integer;", "getTrainingSession", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m, reason: from kotlin metadata */
public final class ProgramTrainingPlanScreen extends j {

    public static final Parcelable.Creator<m> CREATOR = new m$a<>();
    private final TrainingSession a;
    private final ProgramSaveInfo b;
    private final String c;
    private final boolean v;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<m> {
        public final m a(Parcel parcel) {
            boolean z = true;
            n.f(parcel, "parcel");
            parcel = parcel.readInt() != 0 ? 1 : 0;
            ProgramTrainingPlanScreen programTrainingPlanScreen = new ProgramTrainingPlanScreen((TrainingSession)TrainingSession.CREATOR.createFromParcel(parcel), (ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), parcel.readString(), (parcel.readInt() != 0 ? 1 : 0));
            return programTrainingPlanScreen;
        }

        public final m[] b(int i) {
            return new m[i];
        }
    }
    public /* synthetic */ m(TrainingSession trainingSession, ProgramSaveInfo programSaveInfo, String str, boolean z, int i, g gVar) {
        i = i & 8 != 0 ? 0 : i;
        this(trainingSession, programSaveInfo, str, z);
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final ProgramSaveInfo createFragment() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final TrainingSession b() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new ProgramTrainingPlanFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.lessonExamListScreen.withoutParameters();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentParentReturnTag() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public Integer getStatusBarColor() {
        return 2131100352;
    }

    public m(TrainingSession trainingSession, ProgramSaveInfo programSaveInfo, String str, boolean z) {
        n.f(trainingSession, "trainingSession");
        n.f(programSaveInfo, "saveInfo");
        n.f(str, "fragmentParentReturnTag");
        super();
        this.a = trainingSession;
        this.b = programSaveInfo;
        this.c = str;
        this.v = z;
    }


    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, flags);
        this.b.writeToParcel(parcel, flags);
        parcel.writeString(this.c);
        parcel.writeInt(this.v);
    }
}
