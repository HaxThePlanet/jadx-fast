package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.model.survey.SurveyQuestionModel;
import app.dogo.com.dogo_android.repository.domain.SurveyQuestion;
import app.dogo.com.dogo_android.s.b.m1;
import app.dogo.com.dogo_android.service.n2.a;
import app.dogo.com.dogo_android.service.n2.a.a;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.h0.j1;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.p;

/* compiled from: GetOnboardingQuestionsInteractor.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b0\nH\u0002J\u001a\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000fJ$\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetOnboardingQuestionsInteractor;", "", "surveyRepository", "Lapp/dogo/com/dogo_android/repository/local/SurveyRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/repository/local/SurveyRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "getOnboardingQuestionItems", "Lio/reactivex/Single;", "", "Lapp/dogo/com/dogo_android/repository/domain/SurveyQuestion;", "getOnboardingQuestionsAndInsertDogName", "dogName", "", "insertDogName", "list", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: s2, reason: from kotlin metadata */
public final class GetOnboardingQuestionsInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final m1 preferenceService;
    /* renamed from: b, reason: from kotlin metadata */
    private final r2 remoteConfigService;
    /* renamed from: c, reason: from kotlin metadata */
    private final p2 surveyRepository;
    public s2(m1 m1Var, r2 r2Var, p2 p2Var) {
        n.f(m1Var, "surveyRepository");
        n.f(r2Var, "remoteConfigService");
        n.f(p2Var, "preferenceService");
        super();
        this.preferenceService = m1Var;
        this.remoteConfigService = r2Var;
        this.surveyRepository = p2Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final a0<List<SurveyQuestion>> getOnboardingQuestionItems() {
        a0 map = this.preferenceService.getQuestions().map(new kotlinx.coroutines.s(this));
        n.e(map, "surveyRepository.getQuestions().map { questionModels ->\n            val questionIds = remoteConfigService.getOnboardingQuestions\n            val orderedList = questionIds.mapNotNull { questionId -> questionModels.find { questionId == it.id && it.answers.size > 1 } }\n            val items = orderedList.mapIndexed { index, item -> item.parseItem(index + 1, orderedList.size) }\n            items\n        }");
        return map;
    }

    /* renamed from: b, reason: from kotlin metadata */
    private static final List insertDogName(s2 list, List dogName) {
        Object item2 = null;
        int i = 0;
        Iterator it;
        boolean hasNext2;
        boolean z;
        n.f(list, "this$0");
        n.f(dogName, "questionModels");
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.remoteConfigService.p().iterator();
        i = 0;
        while (it2.hasNext()) {
            it = dogName.iterator();
            while (it.hasNext()) {
                item2 = it.next();
                i = 1;
                if (i != 0) {
                    break loop_3;
                }
            }
            item2 = it.next();
            i = 1;
        }
        ArrayList arrayList2 = new ArrayList(p.r(arrayList, 10));
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            i = i + 1;
            if (i < 0) {
                p.q();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            }
        }
        return arrayList2;
    }

    private static final List d(String str, s2 s2Var, List list) {
        n.f(str, "$dogName");
        n.f(s2Var, "this$0");
        n.f(list, "it");
        if (!l.z(str) != 0) {
            list = s2Var.e(list, str);
        }
        return list;
    }

    private final List<SurveyQuestion> e(List<SurveyQuestion> list, String str) {
        n2.a eNGLISH2;
        if (LocaleService_SupportedLocales.INSTANCE.a(this.surveyRepository.W()) == null) {
            eNGLISH2 = LocaleService_SupportedLocales.ENGLISH;
        }
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            surveyQuestion = it.next();
            str = null;
            List list3 = null;
            String str3 = null;
            String str4 = null;
            String str5 = null;
            int i = 0;
            int i2 = 0;
            int i3 = 223;
            arrayList.add(SurveyQuestion.copy$default(surveyQuestion, str, list3, str3, str4, str5, app.dogo.com.dogo_android.util.extensionfunction.j1.parseExam(surveyQuestion.getName(), str, eNGLISH2), i, i2, i3, null));
        }
        return arrayList;
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final a0<List<SurveyQuestion>> getOnboardingQuestionsAndInsertDogName(String dogName) {
        n.f(dogName, "dogName");
        final a0 map = getOnboardingQuestionItems().map(new kotlinx.coroutines.r(dogName, this));
        n.e(map, "getOnboardingQuestionItems().map {\n            if (dogName.isNotBlank()) {\n                insertDogName(it, dogName)\n            } else {\n                it\n            }\n        }");
        return map;
    }

    public static /* synthetic */ List f(String str, s2 s2Var, List list) {
        return GetOnboardingQuestionsInteractor.d(str, s2Var, list);
    }

    public static /* synthetic */ List g(s2 s2Var, List list) {
        return GetOnboardingQuestionsInteractor.insertDogName(s2Var, list);
    }
}
