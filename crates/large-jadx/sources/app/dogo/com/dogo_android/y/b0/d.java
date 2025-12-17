package app.dogo.com.dogo_android.y.b0;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\n\u0008\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010\u0017\u001a\u00020\u0018H\u0014J\u0008\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0008\u001a\u00020\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/questioncorrectanswer/ProgramQuestionCorrectAnswerScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "programQuestion", "Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "fragmentReturnTag", "", "changedFirstLessonFlow", "", "trainingSession", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "(Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;ZLapp/dogo/com/dogo_android/repository/domain/TrainingSession;)V", "getChangedFirstLessonFlow", "()Z", "getFragmentReturnTag", "()Ljava/lang/String;", "getProgramQuestion", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramQuestion;", "getProgramSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getTrainingSession", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.y.b0.d> CREATOR;
    private final ProgramQuestion a;
    private final ProgramSaveInfo b;
    private final String c;
    private final boolean v;
    private final TrainingSession w;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.y.b0.d> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.b0.d a(Parcel parcel) {
            int i;
            Parcelable.Creator cREATOR;
            Object obj8;
            n.f(parcel, "parcel");
            i = parcel.readInt() != 0 ? 1 : 0;
            if (parcel.readInt() == 0) {
                obj8 = 0;
            } else {
                obj8 = TrainingSession.CREATOR.createFromParcel(parcel);
            }
            super((ProgramQuestion)ProgramQuestion.CREATOR.createFromParcel(parcel), (ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), parcel.readString(), i, (TrainingSession)obj8);
            return dVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.y.b0.d[] b(int i) {
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

    public d(ProgramQuestion programQuestion, ProgramSaveInfo programSaveInfo2, String string3, boolean z4, TrainingSession trainingSession5) {
        n.f(programQuestion, "programQuestion");
        n.f(programSaveInfo2, "programSaveInfo");
        n.f(string3, "fragmentReturnTag");
        super();
        this.a = programQuestion;
        this.b = programSaveInfo2;
        this.c = string3;
        this.v = z4;
        this.w = trainingSession5;
    }

    public d(ProgramQuestion programQuestion, ProgramSaveInfo programSaveInfo2, String string3, boolean z4, TrainingSession trainingSession5, int i6, g g7) {
        int obj10;
        int obj11;
        obj10 = i6 & 8 != 0 ? 0 : obj10;
        obj11 = i6 & 16 != 0 ? 0 : obj11;
        super(programQuestion, programSaveInfo2, string3, obj10, obj11);
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final boolean a() {
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
        c cVar = new c();
        return cVar;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return j3.Y.f();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final TrainingSession d() {
        return this.w;
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
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int obj4;
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, i2);
        this.b.writeToParcel(parcel, i2);
        parcel.writeString(this.c);
        parcel.writeInt(this.v);
        TrainingSession trainingSession = this.w;
        if (trainingSession == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            trainingSession.writeToParcel(parcel, i2);
        }
    }
}
