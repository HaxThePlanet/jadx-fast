package app.dogo.com.dogo_android.y.a0;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.w.f2;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: ProgramQuestionScreen.kt */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010\u0017\u001a\u00020\u0018H\u0014J\u0008\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/question/ProgramQuestionScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "programQuestion", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "saveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "fragmentReturnTag", "", "changedFirstLessonFlow", "", "trainingSession", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;ZLapp/dogo/com/dogo_android/repository/domain/TrainingSession;)V", "getChangedFirstLessonFlow", "()Z", "getFragmentReturnTag", "()Ljava/lang/String;", "getProgramQuestion", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "getSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getTrainingSession", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class ProgramQuestionScreen extends j {

    public static final Parcelable.Creator<g> CREATOR = new g$a<>();
    private final ProgramQuestion a;
    private final ProgramSaveInfo b;
    private final String c;
    private final boolean v;
    /* renamed from: w, reason: from kotlin metadata */
    private final TrainingSession trainingSession;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<g> {
        public final g a(Parcel parcel) {
            int i = 1;
            Object fromParcel = null;
            n.f(parcel, "parcel");
            int r1 = parcel.readInt() != 0 ? 1 : 0;
            if (parcel.readInt() == 0) {
                int i2 = 0;
            } else {
                fromParcel = TrainingSession.CREATOR.createFromParcel(parcel);
            }
            ProgramQuestionScreen programQuestionScreen = new ProgramQuestionScreen((ProgramQuestion)ProgramQuestion.CREATOR.createFromParcel(parcel), (ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), parcel.readString(), (parcel.readInt() != 0 ? 1 : 0), (TrainingSession)fromParcel);
            return programQuestionScreen;
        }

        public final g[] b(int i) {
            return new g[i];
        }
    }
    public g(ProgramQuestion programQuestion, ProgramSaveInfo programSaveInfo, String str, boolean z, TrainingSession trainingSession) {
        n.f(programQuestion, "programQuestion");
        n.f(programSaveInfo, "saveInfo");
        n.f(str, "fragmentReturnTag");
        super();
        this.a = programQuestion;
        this.b = programSaveInfo;
        this.c = str;
        this.v = z;
        this.trainingSession = trainingSession;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final boolean createFragment() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProgramQuestion b() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final ProgramSaveInfo c() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new ProgramQuestionFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.emailRegistration.b(new EP_QuestionId(), this.a.getQuestionId());
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final TrainingSession d() {
        return this.trainingSession;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.c;
    }

    public /* synthetic */ g(ProgramQuestion programQuestion, ProgramSaveInfo programSaveInfo, String str, boolean z, TrainingSession trainingSession, int i, g gVar) {
        int i2 = 0;
        i = i & 8 != 0 ? 0 : i;
        i2 = i & 16 != 0 ? 0 : i2;
        this(programQuestion, programSaveInfo, str, i, i2);
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
        if (this.trainingSession == null) {
            int i2 = 0;
            parcel.writeInt(i2);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.trainingSession.writeToParcel(parcel, flags);
        }
    }
}
