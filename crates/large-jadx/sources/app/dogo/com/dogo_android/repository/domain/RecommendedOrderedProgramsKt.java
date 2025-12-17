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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u001a\u0012\u0010\u0004\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\u0008", d2 = {"toEntity", "Lapp/dogo/android/persistencedb/room/entity/RecommendedListOrderEntity;", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms;", "toItem", "toRecommendedOrderedPrograms", "Lapp/dogo/externalmodel/model/SurveyAnswerResponseModel;", "dogId", "", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class RecommendedOrderedProgramsKt {
    public static final RecommendedListOrderEntity toEntity(app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms recommendedOrderedPrograms) {
        int valueOf;
        RecommendedListOrderEntity.ProgramCompatibility programCompatibility;
        String programId;
        n.f(recommendedOrderedPrograms, "<this>");
        java.util.List obj5 = recommendedOrderedPrograms.getProgramCompatibilityMatchList();
        ArrayList arrayList = new ArrayList(p.r(obj5, 10));
        obj5 = obj5.iterator();
        for (RecommendedOrderedPrograms.ProgramCompatibilityMatchList next2 : obj5) {
            programCompatibility = new RecommendedListOrderEntity.ProgramCompatibility(next2.getProgramId(), Integer.valueOf(next2.getCompatibility()));
            arrayList.add(programCompatibility);
        }
        obj5 = new RecommendedListOrderEntity(recommendedOrderedPrograms.getDogId(), arrayList);
        return obj5;
    }

    public static final app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms toItem(RecommendedListOrderEntity recommendedListOrderEntity) {
        int intValue;
        app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms.ProgramCompatibilityMatchList programCompatibilityMatchList;
        String programId;
        n.f(recommendedListOrderEntity, "<this>");
        java.util.List obj9 = recommendedListOrderEntity.getRecommendedProgramIds();
        ArrayList arrayList = new ArrayList(p.r(obj9, 10));
        obj9 = obj9.iterator();
        while (obj9.hasNext()) {
            Object next2 = obj9.next();
            Integer compatibility = next2.getCompatibility();
            if (compatibility == null) {
            } else {
            }
            intValue = compatibility.intValue();
            programCompatibilityMatchList = new RecommendedOrderedPrograms.ProgramCompatibilityMatchList((RecommendedListOrderEntity.ProgramCompatibility)next2.getProgramId(), intValue);
            arrayList.add(programCompatibilityMatchList);
            intValue = 0;
        }
        super(recommendedListOrderEntity.getDogId(), arrayList, 0, 0, 0, 28, 0);
        return obj9;
    }

    public static final app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms toRecommendedOrderedPrograms(SurveyAnswerResponseModel surveyAnswerResponseModel, String string2) {
        int intValue;
        app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms.ProgramCompatibilityMatchList programCompatibilityMatchList;
        String programId;
        n.f(surveyAnswerResponseModel, "<this>");
        n.f(string2, "dogId");
        java.util.List obj9 = surveyAnswerResponseModel.getPrograms_v2();
        ArrayList arrayList = new ArrayList(p.r(obj9, 10));
        obj9 = obj9.iterator();
        while (obj9.hasNext()) {
            Object next2 = obj9.next();
            Integer compatibility = next2.getCompatibility();
            if (compatibility == null) {
            } else {
            }
            intValue = compatibility.intValue();
            programCompatibilityMatchList = new RecommendedOrderedPrograms.ProgramCompatibilityMatchList((SurveyAnswerResponseModel.ProgramCompatibility)next2.getProgramId(), intValue);
            arrayList.add(programCompatibilityMatchList);
            intValue = 0;
        }
        super(string2, arrayList, 0, surveyAnswerResponseModel.getSurveyTaken(), 0, 20, 0);
        return obj9;
    }
}
