package app.dogo.com.dogo_android.repository.domain;

import app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity;
import app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity.ProgramCompatibility;
import app.dogo.externalmodel.model.SurveyAnswerResponseModel;
import app.dogo.externalmodel.model.SurveyAnswerResponseModel.ProgramCompatibility;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: RecommendedOrderedPrograms.kt */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u001a\u0012\u0010\u0004\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0008", d2 = {"toEntity", "Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity;", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms;", "toItem", "toRecommendedOrderedPrograms", "Lapp/dogo/externalmodel/model/SurveyAnswerResponseModel;", "dogId", "", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class RecommendedOrderedProgramsKt {
    public static final RecommendedListOrderEntity toEntity(RecommendedOrderedPrograms recommendedOrderedPrograms) {
        n.f(recommendedOrderedPrograms, "<this>");
        java.util.List programCompatibilityMatchList = recommendedOrderedPrograms.getProgramCompatibilityMatchList();
        final ArrayList arrayList = new ArrayList(p.r(programCompatibilityMatchList, 10));
        Iterator it = programCompatibilityMatchList.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            arrayList.add(new RecommendedListOrderEntity_ProgramCompatibility(item.getProgramId(), Integer.valueOf(item.getCompatibility())));
        }
        return new RecommendedListOrderEntity(recommendedOrderedPrograms.getDogId(), arrayList);
    }

    public static final RecommendedOrderedPrograms toItem(RecommendedListOrderEntity list) {
        int value = 0;
        n.f(list, "<this>");
        java.util.List recommendedProgramIds = list.getRecommendedProgramIds();
        final ArrayList arrayList = new ArrayList(p.r(recommendedProgramIds, 10));
        Iterator it = recommendedProgramIds.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            Integer compatibility = item.getCompatibility();
            RecommendedOrderedPrograms_ProgramCompatibilityMatchList recommendedOrderedPrograms_ProgramCompatibilityMatchList = new RecommendedOrderedPrograms_ProgramCompatibilityMatchList(item.getProgramId(), value);
            arrayList.add(recommendedOrderedPrograms_ProgramCompatibilityMatchList);
        }
        RecommendedOrderedPrograms list2 = new RecommendedOrderedPrograms(list.getDogId(), arrayList, null, false, null, 28, null);
        return list2;
    }

    public static final RecommendedOrderedPrograms toRecommendedOrderedPrograms(SurveyAnswerResponseModel dogId, String str) {
        int value = 0;
        n.f(dogId, "<this>");
        n.f(str, "dogId");
        java.util.List programs_v2 = dogId.getPrograms_v2();
        final ArrayList arrayList = new ArrayList(p.r(programs_v2, 10));
        Iterator it = programs_v2.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            Integer compatibility = item.getCompatibility();
            RecommendedOrderedPrograms_ProgramCompatibilityMatchList recommendedOrderedPrograms_ProgramCompatibilityMatchList = new RecommendedOrderedPrograms_ProgramCompatibilityMatchList(item.getProgramId(), value);
            arrayList.add(recommendedOrderedPrograms_ProgramCompatibilityMatchList);
        }
        RecommendedOrderedPrograms dogId2 = new RecommendedOrderedPrograms(str, arrayList, null, dogId.getSurveyTaken(), null, 20, null);
        return dogId2;
    }
}
