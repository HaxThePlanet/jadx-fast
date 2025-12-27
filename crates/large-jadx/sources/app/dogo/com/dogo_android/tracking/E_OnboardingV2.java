package app.dogo.com.dogo_android.w;

import kotlin.Metadata;

/* compiled from: Events.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00080\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00070\n8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/tracking/E$OnboardingV2;", "", "()V", "SurveyCompleted", "Lapp/dogo/com/dogo_android/tracking/Event0;", "SurveyQuestionAnswered", "Lapp/dogo/com/dogo_android/tracking/Event2;", "Lapp/dogo/com/dogo_android/tracking/EP$QuestionId;", "Lapp/dogo/com/dogo_android/tracking/EP$AnswerId;", "SurveyQuestionSkipped", "Lapp/dogo/com/dogo_android/tracking/Event1;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g0, reason: from kotlin metadata */
public final class E_OnboardingV2 {

    public static final v2<f2, u0> a;
    public static final t2 b;
    public static final u2<f2> c;
    static {
        app.dogo.com.dogo_android.w.s2.a companion2 = Event.Companion;
        E_OnboardingV2.a = companion2.a("onboarding_survey_question_answered").c(new EP_QuestionId(), new EP_AnswerId());
        E_OnboardingV2.b = companion2.a("onboarding_questionnaire_completed").g(app.dogo.com.dogo_android.tracking.g.a);
        E_OnboardingV2.c = companion2.a("onboarding_survey_question_skipped").b(new EP_QuestionId());
    }

    private static final a3 a() {
        return FBEvent.INSTANCE.c();
    }

    public static /* synthetic */ a3 b() {
        return E_OnboardingV2.a();
    }
}
