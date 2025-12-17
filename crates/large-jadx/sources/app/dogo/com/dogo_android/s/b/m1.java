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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\n0\t0\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Lapp/dogo/com/dogo_android/repository/local/SurveyRepository;", "", "onboardingSurveyEntityDao", "Lapp/dogo/android/persistencedb/room/dao/OnboardingSurveyEntityDao;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/android/persistencedb/room/dao/OnboardingSurveyEntityDao;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "getQuestions", "Lio/reactivex/Single;", "", "Lapp/dogo/com/dogo_android/model/survey/SurveyQuestionModel;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class m1 {

    private final c0 a;
    private final p2 b;
    public m1(c0 c0, p2 p22) {
        n.f(c0, "onboardingSurveyEntityDao");
        n.f(p22, "preferenceService");
        super();
        this.a = c0;
        this.b = p22;
    }

    private static final List b(List list) {
        int i;
        n.f(list, "list");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        final Iterator obj2 = list.iterator();
        for (d next2 : obj2) {
            arrayList.add(m1.t(next2));
        }
        return arrayList;
    }

    public static List c(List list) {
        return m1.b(list);
    }

    public final a0<List<SurveyQuestionModel>> a() {
        a0 a0Var2 = this.a.e(n2.a.a(this.b.W())).map(a0.a);
        n.e(a0Var2, "onboardingSurveyEntityDao.getAllOnboardingQuestions(correctedLocale).map { list ->\n            list.map {\n                it.toModel()\n            }\n        }");
        return a0Var2;
    }
}
