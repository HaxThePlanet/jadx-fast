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

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b0\nH\u0002J\u001a\u0010\r\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000c0\u000b0\n2\u0006\u0010\u000e\u001a\u00020\u000fJ$\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetOnboardingQuestionsInteractor;", "", "surveyRepository", "Lapp/dogo/com/dogo_android/repository/local/SurveyRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/repository/local/SurveyRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "getOnboardingQuestionItems", "Lio/reactivex/Single;", "", "Lapp/dogo/com/dogo_android/repository/domain/SurveyQuestion;", "getOnboardingQuestionsAndInsertDogName", "dogName", "", "insertDogName", "list", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class s2 {

    private final m1 a;
    private final r2 b;
    private final p2 c;
    public s2(m1 m1, r2 r22, p2 p23) {
        n.f(m1, "surveyRepository");
        n.f(r22, "remoteConfigService");
        n.f(p23, "preferenceService");
        super();
        this.a = m1;
        this.b = r22;
        this.c = p23;
    }

    private final a0<List<SurveyQuestion>> a() {
        s sVar = new s(this);
        a0 a0Var2 = this.a.a().map(sVar);
        n.e(a0Var2, "surveyRepository.getQuestions().map { questionModels ->\n            val questionIds = remoteConfigService.getOnboardingQuestions\n            val orderedList = questionIds.mapNotNull { questionId -> questionModels.find { questionId == it.id && it.answers.size > 1 } }\n            val items = orderedList.mapIndexed { index, item -> item.parseItem(index + 1, orderedList.size) }\n            items\n        }");
        return a0Var2;
    }

    private static final List b(app.dogo.com.dogo_android.s.a.s2 s2, List list2) {
        Object next3;
        boolean next;
        int i3;
        int i2;
        Iterator iterator;
        boolean next2;
        Object size;
        boolean z;
        int i;
        n.f(s2, "this$0");
        n.f(list2, "questionModels");
        ArrayList arrayList = new ArrayList();
        Iterator obj9 = s2.b.p().iterator();
        for (String next3 : obj9) {
            iterator = list2.iterator();
            while (iterator.hasNext()) {
                next2 = iterator.next();
                size = next2;
                if (n.b(next3, (SurveyQuestionModel)size.getId()) && size.getAnswers().size() > 1) {
                } else {
                }
                i = i2;
                if (i != 0) {
                    break loop_3;
                } else {
                }
                if (size.getAnswers().size() > 1) {
                } else {
                }
            }
            if ((SurveyQuestionModel)i3 != 0) {
            }
            arrayList.add((SurveyQuestionModel)i3);
            next2 = iterator.next();
            size = next2;
            if (n.b(next3, (SurveyQuestionModel)size.getId()) && size.getAnswers().size() > 1) {
            } else {
            }
            i = i2;
            if (i != 0) {
            } else {
            }
            i3 = next2;
            if (size.getAnswers().size() > 1) {
            } else {
            }
        }
        obj9 = new ArrayList(p.r(arrayList, 10));
        Iterator obj10 = arrayList.iterator();
        for (Object next5 : obj10) {
            iterator = i2 + 1;
            obj9.add(j1.o0((SurveyQuestionModel)next5, iterator, arrayList.size()));
            i2 = iterator;
        }
        return obj9;
    }

    private static final List d(String string, app.dogo.com.dogo_android.s.a.s2 s22, List list3) {
        Object obj3;
        n.f(string, "$dogName");
        n.f(s22, "this$0");
        n.f(list3, "it");
        if (z ^= 1 != 0) {
            obj3 = s22.e(list3, string);
        }
        return obj3;
    }

    private final List<SurveyQuestion> e(List<SurveyQuestion> list, String string2) {
        n2.a eNGLISH;
        Iterable copy$default;
        Object obj;
        int i6;
        int i5;
        int i2;
        int i9;
        int i4;
        String str;
        int i8;
        int i;
        int i7;
        int i3;
        if (n2.a.Companion.a(obj2.c.W()) == null) {
            eNGLISH = n2.a.ENGLISH;
        }
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator = list.iterator();
        for (Object next2 : iterator) {
            obj = next2;
            arrayList.add(SurveyQuestion.copy$default(obj, 0, 0, 0, 0, 0, j1.L((SurveyQuestion)obj.getName(), string2, eNGLISH), 0, 0, 223, 0));
        }
        return arrayList;
    }

    public static List f(String string, app.dogo.com.dogo_android.s.a.s2 s22, List list3) {
        return s2.d(string, s22, list3);
    }

    public static List g(app.dogo.com.dogo_android.s.a.s2 s2, List list2) {
        return s2.b(s2, list2);
    }

    public final a0<List<SurveyQuestion>> c(String string) {
        n.f(string, "dogName");
        r rVar = new r(string, this);
        final a0 obj3 = a().map(rVar);
        n.e(obj3, "getOnboardingQuestionItems().map {\n            if (dogName.isNotBlank()) {\n                insertDogName(it, dogName)\n            } else {\n                it\n            }\n        }");
        return obj3;
    }
}
