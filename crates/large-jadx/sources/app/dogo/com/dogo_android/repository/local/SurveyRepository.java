package app.dogo.com.dogo_android.s.b;

import app.dogo.com.dogo_android.model.survey.SurveyQuestionModel;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.h0.m1;
import e.a.a.a.b.b.c0;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: SurveyRepository.kt */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t0\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/repository/local/SurveyRepository;", "", "onboardingSurveyEntityDao", "Lapp/dogo/android/persistencedb/room/dao/OnboardingSurveyEntityDao;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/android/persistencedb/room/dao/OnboardingSurveyEntityDao;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "getQuestions", "Lio/reactivex/Single;", "", "Lapp/dogo/com/dogo_android/model/survey/SurveyQuestionModel;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: m1, reason: from kotlin metadata */
public final class SurveyRepository {

    /* renamed from: a, reason: from kotlin metadata */
    private final c0 onboardingSurveyEntityDao;
    /* renamed from: b, reason: from kotlin metadata */
    private final p2 preferenceService;
    public m1(c0 c0Var, p2 p2Var) {
        n.f(c0Var, "onboardingSurveyEntityDao");
        n.f(p2Var, "preferenceService");
        super();
        this.onboardingSurveyEntityDao = c0Var;
        this.preferenceService = p2Var;
    }

    private static final List b(List list) {
        n.f(list, "list");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        final Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.t((OnboardingQuestionFullEntity)it.next()));
        }
        return arrayList;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final a0<List<SurveyQuestionModel>> getQuestions() {
        a0 map = this.onboardingSurveyEntityDao.deleteOnboardingQuestionWithAnswer(LocaleService.supportedLocales.getLocaleString(this.preferenceService.W())).map(app.dogo.com.dogo_android.repository.local.a0.a);
        n.e(map, "onboardingSurveyEntityDao.getAllOnboardingQuestions(correctedLocale).map { list ->\n            list.map {\n                it.toModel()\n            }\n        }");
        return map;
    }

    public static /* synthetic */ List c(List list) {
        return SurveyRepository.b(list);
    }
}
