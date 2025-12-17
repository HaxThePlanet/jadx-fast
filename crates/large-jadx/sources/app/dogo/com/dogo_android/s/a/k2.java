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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rH\u0002J(\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\u0008R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetDashboardExamCardInteractor;", "", "getProgramLessonsListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;", "(Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;)V", "buildExamItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "dogId", "", "lessonId", "program", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "progress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "getDashboardExamItem", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k2 {

    private final app.dogo.com.dogo_android.s.a.v2 a;
    public k2(app.dogo.com.dogo_android.s.a.v2 v2) {
        n.f(v2, "getProgramLessonsListInteractor");
        super();
        this.a = v2;
    }

    private final ProgramExamSummary a(String string, String string2, ProgramModel programModel3, ProgramProgress programProgress4) {
        Object obj;
        Object iterator2;
        Object next2;
        int i2;
        int i;
        int i3;
        Iterator iterator;
        int next5;
        int next;
        boolean next3;
        boolean next4;
        boolean modules;
        int tRUE;
        app.dogo.com.dogo_android.s.a.v2 aPPROVED;
        int i4;
        String str;
        String str2 = string;
        obj = string2;
        iterator2 = programModel3.getModules().iterator();
        i2 = 1;
        i = 0;
        i3 = 0;
        for (Object next2 : iterator2) {
            Iterator iterator6 = (ProgramModel.ModuleModel)next2.getLessons().iterator();
            for (Object next : iterator6) {
            }
            next = i3;
            if (next != 0) {
            } else {
            }
            next5 = i;
            i2 = 1;
            i = 0;
            i3 = 0;
            next5 = i2;
            if (n.b((ProgramModel.LessonModel)iterator6.next().getId(), obj)) {
            } else {
            }
        }
        next2 = i3;
        if ((ProgramModel.ModuleModel)next2 == 0) {
            next2 = iterator2;
        }
        Iterator iterator4 = next2.getLessons().iterator();
        for (Object next5 : iterator4) {
        }
        next5 = i3;
        if ((ProgramModel.LessonModel)next5 == 0) {
            next5 = obj;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator3 = programModel3.getModules().iterator();
        while (iterator3.hasNext()) {
            Object next10 = iterator3.next();
            if (programProgress4 == null) {
            } else {
            }
            modules = programProgress4.getModules();
            if (!modules) {
            } else {
            }
            Iterator iterator7 = modules.iterator();
            while (iterator7.hasNext()) {
                Object obj4 = tRUE;
                if ((ProgramProgress.ModuleProgress)obj4 == null) {
                } else {
                }
                i4 = (ProgramProgress.ModuleProgress)obj4.getId();
                i4 = i3;
            }
            tRUE = i3;
            modules = this;
            p.y(arrayList2, modules.a.n(str2, programModel3.getId(), next10, tRUE));
            obj4 = tRUE;
            if ((ProgramProgress.ModuleProgress)obj4 == null) {
            } else {
            }
            i4 = (ProgramProgress.ModuleProgress)obj4.getId();
            if (n.b(i4, next10.getId())) {
            } else {
            }
            i4 = i3;
            modules = this;
            tRUE = i3;
        }
        boolean z = this;
        ArrayList arrayList = new ArrayList();
        iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            next3 = iterator.next();
            if ((ProgramExam)next3.getStatus() == ProgramExam.Status.APPROVED) {
            } else {
            }
            tRUE = i;
            if (tRUE != 0) {
            }
            arrayList.add(next3);
            tRUE = i2;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator iterator5 = arrayList2.iterator();
        while (iterator5.hasNext()) {
            iterator = iterator5.next();
            if (n.b((ProgramExam)iterator.getHasNewUpdates(), Boolean.TRUE)) {
            }
            arrayList3.add(iterator);
        }
        ProgramSaveInfo programSaveInfo = new ProgramSaveInfo(programModel3.getId(), next2.getId(), next5.getId(), str2);
        super(programSaveInfo, Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList3.size()), programModel3.getCardBackgroundColor(), programModel3.getCertificateLaurelsImage(), programModel3.getCertificatePaperImage(), 0, 0, 0, 896, 0);
        return programExamSummary;
    }

    public final ProgramExamSummary b(String string, ProgramModel programModel2, ProgramProgress programProgress3, String string4) {
        n.f(string, "dogId");
        n.f(programModel2, "program");
        n.f(string4, "lessonId");
        return a(string, string4, programModel2, programProgress3);
    }
}
