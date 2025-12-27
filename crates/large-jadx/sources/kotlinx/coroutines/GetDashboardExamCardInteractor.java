package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: GetDashboardExamCardInteractor.kt */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0002J(\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetDashboardExamCardInteractor;", "", "getProgramLessonsListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;", "(Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;)V", "buildExamItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "dogId", "", "lessonId", "program", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "progress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "getDashboardExamItem", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: k2, reason: from kotlin metadata */
public final class GetDashboardExamCardInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final v2 getProgramLessonsListInteractor;
    public k2(v2 v2Var) {
        n.f(v2Var, "getProgramLessonsListInteractor");
        super();
        this.getProgramLessonsListInteractor = v2Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final ProgramExamSummary buildExamItem(String dogId, String lessonId, ProgramModel program, ProgramProgress progress) {
        int i;
        int i2;
        Object lessonId2;
        boolean z;
        boolean z2;
        ProgramProgress.ModuleProgress item6;
        app.dogo.com.dogo_android.s.a.v2 getProgramLessonsListInteractor2;
        String str;
        boolean z3;
        String str2;
        String dogId2 = dogId;
        lessonId2 = lessonId;
        Iterator it = program.getModules().iterator();
        i2 = 1;
        i2 = 0;
        i = 0;
        while (it.hasNext()) {
            Iterator it5 = (ProgramModel_ModuleModel)item2.getLessons().iterator();
            while (it5.hasNext()) {
                if (n.b((ProgramModel_LessonModel)item4.getId(), lessonId2)) {
                    break loop_3;
                }
            }
            int r7 = i2;
            if (i2 != 0) {
                break;
            }
        }
        if ((ProgramModel_ModuleModel)i == 0) {
        }
        Iterator it3 = i.getLessons().iterator();
        while (it3.hasNext()) {
            if (n.b((ProgramModel_LessonModel)lessonId2.getId(), lessonId2)) {
                break;
            }
        }
        if ((ProgramModel_LessonModel)lessonId2 == null) {
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = program.getModules().iterator();
        while (it2.hasNext()) {
            Object item7 = it2.next();
            p.y(arrayList2, z2.getProgramLessonsListInteractor.findLessonStatus(dogId2, program.getId(), item7, item6));
        }
        ArrayList arrayList = new ArrayList();
        Iterator item3 = arrayList2.iterator();
        while (item3.hasNext()) {
            Object item5 = item3.next();
            int r10 = i2;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it4 = arrayList2.iterator();
        while (it4.hasNext()) {
            item3 = it4.next();
        }
        ProgramExamSummary programExamSummary = new ProgramExamSummary(new ProgramSaveInfo(program.getId(), i.getId(), lessonId2.getId(), dogId2), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList3.size()), program.getCardBackgroundColor(), program.getCertificateLaurelsImage(), program.getCertificatePaperImage(), null, null, null, 896, null);
        return programExamSummary;
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final ProgramExamSummary getDashboardExamItem(String dogId, ProgramModel program, ProgramProgress progress, String lessonId) {
        n.f(dogId, "dogId");
        n.f(program, "program");
        n.f(lessonId, "lessonId");
        return buildExamItem(dogId, lessonId, program, progress);
    }
}
