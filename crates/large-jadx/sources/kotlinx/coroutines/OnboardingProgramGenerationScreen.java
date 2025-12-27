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

/* compiled from: OnboardingProgramGenerationScreen.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0007\u001a\u00020\u0008H\u0014J\u0008\u0010\t\u001a\u00020\nH\u0016J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingProgramGenerationScreen;", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "surveyAnswers", "Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswers;", "(Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswers;)V", "getSurveyAnswers", "()Lapp/dogo/com/dogo_android/repository/domain/SurveyAnswers;", "createFragment", "Landroidx/fragment/app/Fragment;", "createTrackingParameters", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m0, reason: from kotlin metadata */
public final class OnboardingProgramGenerationScreen extends j {

    public static final Parcelable.Creator<m0> CREATOR = new m0$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final SurveyAnswers surveyAnswers;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<m0> {
        public final m0 a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new OnboardingProgramGenerationScreen((SurveyAnswers)SurveyAnswers.CREATOR.createFromParcel(parcel));
        }

        public final m0[] b(int i) {
            return new m0[i];
        }
    }
    public m0(SurveyAnswers surveyAnswers) {
        n.f(surveyAnswers, "surveyAnswers");
        super();
        this.surveyAnswers = surveyAnswers;
    }

    @Override // app.dogo.com.dogo_android.y.j
    /* renamed from: a, reason: from kotlin metadata */
    public final SurveyAnswers createFragment() {
        return this.surveyAnswers;
    }

    @Override // app.dogo.com.dogo_android.y.j
    protected Fragment createFragment() {
        return new OnboardingProgramGenerationFragment();
    }

    @Override // app.dogo.com.dogo_android.y.j
    public i3 createTrackingParameters() {
        return S.dailyGoal.b(new EP_ViewSource(), "onboarding");
    }


    @Override // app.dogo.com.dogo_android.y.j
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.y.j
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.surveyAnswers.writeToParcel(parcel, flags);
    }
}
