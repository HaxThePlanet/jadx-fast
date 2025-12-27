package app.dogo.com.dogo_android.s.a;

import android.content.res.Resources;
import app.dogo.com.dogo_android.repository.domain.LessonIntroduction;
import app.dogo.com.dogo_android.repository.domain.LessonIntroduction.CardType;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: GetProgramLessonIntroductionInteractor.kt */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonIntroductionInteractor;", "", "resources", "Landroid/content/res/Resources;", "(Landroid/content/res/Resources;)V", "getListOfLessonIntroduction", "", "Lapp/dogo/com/dogo_android/repository/domain/LessonIntroduction;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: u2, reason: from kotlin metadata */
public final class GetProgramLessonIntroductionInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final Resources resources;
    public u2(Resources resources) {
        n.f(resources, "resources");
        super();
        this.resources = resources;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final List<LessonIntroduction> getListOfLessonIntroduction() throws android.content.res.Resources.NotFoundException {
        final Object obj = this;
        LessonIntroduction[] arr = new LessonIntroduction[4];
        String string = obj.resources.getString(2131886814);
        n.e(string, "resources.getString(R.string.lesson_title)");
        String string4 = obj.resources.getString(2131886813);
        n.e(string4, "resources.getString(R.string.lesson_onboarding_text)");
        LessonIntroduction lessonIntroduction = new LessonIntroduction("", "", string, string4, LessonIntroduction_CardType.LESSON, "#b2f6db");
        int i8 = 2131887609;
        final String string11 = obj.resources.getString(i8);
        String str4 = "resources.getString(R.string.training_title)";
        n.e(string11, str4);
        final String string12 = obj.resources.getString(2131887493);
        n.e(string12, "resources.getString(R.string.ten_min)");
        final String string13 = obj.resources.getString(i8);
        n.e(string13, str4);
        final String string14 = obj.resources.getString(2131887009);
        n.e(string14, "resources.getString(R.string.onboarding_training_text)");
        LessonIntroduction lessonIntroduction2 = new LessonIntroduction(string11, string12, string13, string14, LessonIntroduction_CardType.TRAINING, "#ffc83c");
        String string2 = obj.resources.getString(2131886436);
        n.e(string2, "resources.getString(R.string.daily_question)");
        String string5 = obj.resources.getString(2131886995);
        n.e(string5, "resources.getString(R.string.onboarding_question_image_text)");
        String string7 = obj.resources.getString(2131886438);
        n.e(string7, "resources.getString(R.string.daily_question_title)");
        String string9 = obj.resources.getString(2131886996);
        n.e(string9, "resources.getString(R.string.onboarding_question_text)");
        LessonIntroduction lessonIntroduction3 = new LessonIntroduction(string2, string5, string7, string9, LessonIntroduction_CardType.QUESTION, "#2176cb");
        int i14 = 2131887575;
        String string3 = obj.resources.getString(i14);
        String str10 = "resources.getString(R.string.training_program_activity)";
        n.e(string3, str10);
        String string6 = obj.resources.getString(2131886982);
        n.e(string6, "resources.getString(R.string.onboarding_activity_text)");
        String string8 = obj.resources.getString(i14);
        n.e(string8, str10);
        String string10 = obj.resources.getString(2131886981);
        n.e(string10, "resources.getString(R.string.onboarding_activity_explanation)");
        LessonIntroduction lessonIntroduction4 = new LessonIntroduction(string3, string6, string8, string10, LessonIntroduction_CardType.ACTIVITY, "#ff6b65");
        return p.j(new LessonIntroduction[] { lessonIntroduction, lessonIntroduction2, lessonIntroduction3, lessonIntroduction4 });
    }
}
