package app.dogo.com.dogo_android.y.e0;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.y.p;

/* compiled from: ProgramTrickTryScreen.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0017\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0008\u0010\u0011\u001a\u00020\u0012H\u0014J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0016HÖ\u0001R\u0014\u0010\u0008\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/trainingprogram/tricktry/ProgramTrickTryScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "trainingSession", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "saveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "fragmentReturnTag", "", "fragmentParentReturnTag", "(Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/String;Ljava/lang/String;)V", "getFragmentParentReturnTag", "()Ljava/lang/String;", "getFragmentReturnTag", "getSaveInfo", "()Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "getTrainingSession", "()Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d, reason: from kotlin metadata */
public class ProgramTrickTryScreen extends j {

    public static final Parcelable.Creator<d> CREATOR = new d$a<>();
    private final TrainingSession a;
    private final ProgramSaveInfo b;
    private final String c;
    private final String v;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<d> {
        public final d a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new ProgramTrickTryScreen((TrainingSession)TrainingSession.CREATOR.createFromParcel(parcel), (ProgramSaveInfo)ProgramSaveInfo.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readString());
        }

        public final d[] b(int i) {
            return new d[i];
        }
    }
    public d(TrainingSession trainingSession, ProgramSaveInfo programSaveInfo, String str, String str2) {
        n.f(trainingSession, "trainingSession");
        n.f(programSaveInfo, "saveInfo");
        n.f(str, "fragmentReturnTag");
        n.f(str2, "fragmentParentReturnTag");
        super();
        this.a = trainingSession;
        this.b = programSaveInfo;
        this.c = str;
        this.v = str2;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public ProgramSaveInfo createFragment() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public TrainingSession b() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new ProgramTrickTryFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.trickDetailsIntroduction.withParameters(u.a(new EP_TrickId(), (TrickItem)p.X(b().getTrainingTricksList()).getId()));
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentParentReturnTag() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public String getFragmentReturnTag() {
        return this.c;
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
        parcel.writeString(this.v);
    }
}
