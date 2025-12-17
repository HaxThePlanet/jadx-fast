package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00070\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$OnboardingV2;", "", "()V", "SurveyCompleted", "Lapp/dogo/com/dogo_android/tracking/Event0;", "SurveyQuestionAnswered", "Lapp/dogo/com/dogo_android/tracking/Event2;", "Lapp/dogo/com/dogo_android/tracking/EP$QuestionId;", "Lapp/dogo/com/dogo_android/tracking/EP$AnswerId;", "SurveyQuestionSkipped", "Lapp/dogo/com/dogo_android/tracking/Event1;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g0 {

    public static final app.dogo.com.dogo_android.w.v2<app.dogo.com.dogo_android.w.f2, app.dogo.com.dogo_android.w.u0> a;
    public static final app.dogo.com.dogo_android.w.t2 b;
    public static final app.dogo.com.dogo_android.w.u2<app.dogo.com.dogo_android.w.f2> c;
    static {
        app.dogo.com.dogo_android.w.s2.a companion = s2.Companion;
        f2 f2Var2 = new f2();
        u0 u0Var = new u0();
        g0.a = companion.a("onboarding_survey_question_answered").c(f2Var2, u0Var);
        g0.b = companion.a("onboarding_questionnaire_completed").g(g.a);
        f2 f2Var = new f2();
        g0.c = companion.a("onboarding_survey_question_skipped").b(f2Var);
    }

    private static final app.dogo.com.dogo_android.w.a3 a() {
        return a3.Companion.c();
    }

    public static app.dogo.com.dogo_android.w.a3 b() {
        return g0.a();
    }
}
