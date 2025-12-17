package app.dogo.com.dogo_android.welcome_v2;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import app.dogo.com.dogo_android.repository.domain.SurveyAnswers;
import app.dogo.com.dogo_android.w.i3;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.l3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.y.j;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingProgramGenerationScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "surveyAnswers", "Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswers;", "(Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswers;)V", "getSurveyAnswers", "()Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswers;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m0 extends j {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.welcome_v2.m0> CREATOR;
    private final SurveyAnswers a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.welcome_v2.m0> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.welcome_v2.m0 a(Parcel parcel) {
            n.f(parcel, "parcel");
            m0 m0Var = new m0((SurveyAnswers)SurveyAnswers.CREATOR.createFromParcel(parcel));
            return m0Var;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.welcome_v2.m0[] b(int i) {
            return new m0[i];
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
        m0.a aVar = new m0.a();
        m0.CREATOR = aVar;
    }

    public m0(SurveyAnswers surveyAnswers) {
        n.f(surveyAnswers, "surveyAnswers");
        super();
        this.a = surveyAnswers;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public final SurveyAnswers a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        l0 l0Var = new l0();
        return l0Var;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        r2 r2Var = new r2();
        return j3.K0.b(r2Var, "onboarding");
    }

    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        this.a.writeToParcel(parcel, i2);
    }
}
