package app.dogo.com.dogo_android.util.j0;

import app.dogo.com.dogo_android.model.trainingprogram.LessonAndProgressModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel;
import app.dogo.com.dogo_android.model.trainingprogram.TasksModel;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.LessonPositionData;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem.ProgramLessonStatus;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion;
import app.dogo.com.dogo_android.repository.domain.ProgramQuestion.Companion;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks.Type;
import app.dogo.com.dogo_android.repository.domain.TrainingSession;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.y.k;
import app.dogo.com.dogo_android.y.k.b;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.TrickStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;

/* compiled from: LessonItemHelper.kt */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0002J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u000c\u001a\u0004\u0018\u00010\t2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0002J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00102\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ \u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u001a\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0010H\u0002¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/util/helpers/LessonItemHelper;", "", "()V", "buildTasksProgressList", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "lessonModel", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$LessonModel;", "programProgress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "buildTrainingProgressList", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "lessonProgress", "examModuleList", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "findActiveLessonId", "", "program", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$ClassicProgram;", "findNextLessonId", "currentLessonId", "generateLessonItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "dogId", "lessonId", "isActiveProgram", "", "getModuleExamTrickList", "moduleModel", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$ModuleModel;", "moduleProgress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleProgress;", "getNextLessonPositionData", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$LessonPositionData;", "activeLessonId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: a, reason: from kotlin metadata */
public final class LessonItemHelper {

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n", d2 = {"<anonymous>", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "it", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleProgress;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements l<ProgramProgress.ModuleProgress, Iterable<? extends ProgramProgress.LessonProgress>> {

        public static final a.a a = new a$a();
        @Override // kotlin.d0.d.p
        public final Iterable<ProgramProgress.LessonProgress> a(ProgramProgress.ModuleProgress moduleProgress) {
            int i = 0;
            List list;
            if (moduleProgress == null) {
                i = 0;
            } else {
                List lessons = moduleProgress.getLessons();
            }
            if (i == 0) {
                list = p.g();
            }
            return list;
        }


        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n", d2 = {"<anonymous>", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$TrickStatus;", "it", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements l<ProgramProgress.LessonProgress, Iterable<? extends ProgramProgress.TrickStatus>> {

        public static final a.b a = new a$b();
        @Override // kotlin.d0.d.p
        public final Iterable<ProgramProgress.TrickStatus> a(ProgramProgress.LessonProgress lessonProgress) {
            int i = 0;
            List list;
            i = 0;
            if (lessonProgress != null) {
                Map tricks = lessonProgress.getTricks();
                if (tricks != null) {
                    Collection values = tricks.values();
                }
            }
            if (i == 0) {
                list = p.g();
            }
            return list;
        }


        b() {
            super(1);
        }
    }
    /* renamed from: a, reason: from kotlin metadata */
    private final List<ProgramTasks> buildTasksProgressList(ProgramModel.LessonModel lessonModel, ProgramProgress.LessonProgress programProgress) {
        ProgramTasks.Type nOT_STARTED2;
        int i = 0;
        Map tasks;
        Map tasks2 = lessonModel.getTasks();
        final ArrayList arrayList = new ArrayList(tasks2.size());
        Iterator it = tasks2.entrySet().iterator();
        while (it.hasNext()) {
            Object value = it.next();
            i = 0;
            ProgramTasks.Type r1 = i != 0 ? ProgramTasks_Type.COMPLETED : ProgramTasks_Type.NOT_STARTED;
            ProgramTasks programTasks = new ProgramTasks((TasksModel)value.getValue().getId(), (TasksModel)value.getValue().getText(), (i != 0 ? ProgramTasks_Type.COMPLETED : ProgramTasks_Type.NOT_STARTED));
            arrayList.add(programTasks);
        }
        return arrayList;
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final TrainingSession buildTrainingProgressList(ProgramModel.LessonModel lessonModel, ProgramProgress.LessonProgress lessonProgress, List<TrickItem> examModuleList) {
        int i = 0;
        Map tricks;
        Integer num;
        final ArrayList arrayList2 = new ArrayList();
        Iterator it2 = examModuleList.iterator();
        while (it2.hasNext()) {
            Object item = it2.next();
        }
        Map tricks2 = lessonModel.getTricks();
        ArrayList arrayList = new ArrayList(tricks2.size());
        Iterator it = tricks2.entrySet().iterator();
        while (it.hasNext()) {
            Object item2 = it.next();
            i = 0;
            List list = null;
            boolean z = false;
            int i2 = 6;
            Object obj = null;
            TrickItem trickItem = app.dogo.com.dogo_android.util.extensionfunction.j1.T0((TrickModel)examModuleList2, i, list, z, i2, obj);
            boolean hasNext = true;
            trickItem.setNewContent(hasNext);
            arrayList.add(trickItem);
        }
        TrainingSession lessonModel2 = new TrainingSession(arrayList, arrayList2, false, false, 12, null);
        return lessonModel2;
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final String findActiveLessonId(k.b program) {
        String nextLessonId;
        if (findNextLessonId(program, null) == null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = program.a().getModules().iterator();
            while (it.hasNext()) {
                p.y(arrayList, (ProgramModel_ModuleModel)it.next().getLessons());
            }
            nextLessonId = (ProgramModel_LessonModel)p.j0(arrayList).getId();
        }
        return nextLessonId;
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final String findNextLessonId(k.b program, String currentLessonId) {
        List list;
        int cmp;
        String str = null;
        int i;
        Object item3;
        boolean hasNext;
        LessonAndProgressModel lessonAndProgressModel;
        int i3 = 0;
        long lastUserInteractionTimeMs;
        ProgramProgress.LessonProgress item4;
        boolean z;
        String str2;
        ProgramProgress programProgress = program.c();
        i = 0;
        int r0 = i;
        if (list == null) {
            list = p.g();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it8 = program.a().getModules().iterator();
        while (it8.hasNext()) {
            p.y(arrayList, (ProgramModel_ModuleModel)it8.next().getLessons());
        }
        ArrayList arrayList2 = new ArrayList(p.r(arrayList, 10));
        Iterator item2 = arrayList.iterator();
        while (item2.hasNext()) {
            Object item6 = item2.next();
            Iterator it5 = list.iterator();
            while (it5.hasNext()) {
                if (n.b((ProgramProgress_LessonProgress)item4.getId(), item6.getId())) {
                    break loop_14;
                }
            }
            arrayList2.add(new LessonAndProgressModel(item6, (ProgramProgress_LessonProgress)item4));
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            if (n.b((LessonAndProgressModel)item2.getId(), currentLessonId)) {
                break;
            }
        }
        if ((LessonAndProgressModel)i == 0) {
            it = arrayList2.iterator();
            if (!it.hasNext()) {
            } else {
                if (it.hasNext()) {
                    ProgramProgress.LessonProgress progressModel7 = (LessonAndProgressModel)item3.getProgressModel();
                    i3 = 0;
                    if (progressModel7 == null) {
                    } else {
                        lastUserInteractionTimeMs = progressModel7.getLastUserInteractionTimeMs();
                    }
                    item3 = it.next();
                    ProgramProgress.LessonProgress progressModel8 = (LessonAndProgressModel)item3.getProgressModel();
                    do {
                        item3 = it.next();
                        progressModel8 = (LessonAndProgressModel)item3.getProgressModel();
                        lastUserInteractionTimeMs = progressModel8.getLastUserInteractionTimeMs();
                    } while (progressModel8 == null);
                }
            }
            if ((LessonAndProgressModel)item3 == null) {
            }
        }
        Iterator it3 = arrayList2.iterator();
        cmp = 0;
        lastUserInteractionTimeMs = -1L;
        while (it3.hasNext()) {
            if (n.b((LessonAndProgressModel)it3.next().getId(), i.getId())) {
                break;
            }
        }
        cmp = 1;
        r0 = cmp;
        ProgramProgress.LessonProgress progressModel4 = i.getProgressModel();
        int r7 = cmp;
        if (cmp == 0) {
            currentLessonId = cmp;
        }
        ListIterator it6 = arrayList2.listIterator(arrayList2.size());
        while (it6.hasPrevious()) {
            ProgramProgress.LessonProgress progressModel5 = (LessonAndProgressModel)it6.previous().getProgressModel();
            int r8 = cmp;
            if (cmp ^ cmp != 0) {
                break;
            }
        }
        r7 = cmp;
        Iterator it7 = arrayList2.iterator();
        while (it7.hasNext()) {
            Object item5 = it7.next();
            ProgramProgress.LessonProgress progressModel6 = item5.getProgressModel();
            int r11 = cmp;
            if (cmp != 0) {
                break;
            }
        }
        int r6 = cmp;
        if (cmp == 0) {
            if (cmp == 0) {
                str4 = "Collection contains no element matching the predicate.";
                if (cmp != 0) {
                    i4 = lastUserInteractionTimeMs + cmp;
                    Iterator it2 = arrayList2.subList(i4, arrayList2.size()).iterator();
                    while (it2.hasNext()) {
                        Object item = it2.next();
                        ProgramProgress.LessonProgress progressModel = item.getProgressModel();
                        int r1 = cmp;
                        i = cmp ^ cmp;
                        if (r1 ^ cmp != 0) {
                            str = item.getId();
                        }
                    }
                    throw new NoSuchElementException(str4);
                }
                if (cmp != 0) {
                    it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        item = it2.next();
                        ProgramProgress.LessonProgress progressModel2 = item.getProgressModel();
                        r1 = cmp;
                        i = cmp ^ cmp;
                        if (r1 ^ cmp != 0) {
                            str = item.getId();
                        }
                    }
                    throw new NoSuchElementException(str4);
                }
            } else {
                str = i.getId();
            }
        }
        return str;
    }

    /* renamed from: f, reason: from kotlin metadata */
    private final List<TrickItem> getModuleExamTrickList(ProgramModel.ModuleModel moduleModel, ProgramProgress.ModuleProgress moduleProgress) {
        int knowledge = 0;
        Integer item;
        List list = null;
        boolean z2 = false;
        String str;
        int i;
        i = 0;
        moduleProgress = i;
        if (i == 0) {
            List list3 = p.g();
        }
        List exams = moduleModel.getExams();
        ArrayList arrayList = new ArrayList(p.r(exams, 10));
        Iterator it2 = exams.iterator();
        while (it2.hasNext()) {
            trickModel = it2.next();
            Iterator it = i.iterator();
            while (it.hasNext()) {
                if (n.b((ProgramProgress_TrickStatus)item.getId(), trickModel.getId())) {
                    break loop_10;
                }
            }
            list = null;
            z2 = false;
            int i3 = 6;
            Object obj = null;
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.j1.T0(trickModel, Integer.valueOf(knowledge), list, z2, i3, obj));
        }
        return arrayList;
    }

    /* renamed from: g, reason: from kotlin metadata */
    private final ProgramLessonItem.LessonPositionData getNextLessonPositionData(k.b program, String activeLessonId) {
        boolean hasNext;
        Object item = null;
        boolean z;
        boolean hasNext2;
        Iterator it2;
        boolean hasNext3;
        int i;
        String str;
        ArrayList arrayList = new ArrayList();
        Iterator it3 = program.a().getModules().iterator();
        while (it3.hasNext()) {
            p.y(arrayList, (ProgramModel_ModuleModel)it3.next().getLessons());
        }
        Iterator it = arrayList.iterator();
        hasNext = false;
        while (it.hasNext()) {
            if (n.b((ProgramModel_LessonModel)arrayList.getId(), findNextLessonId(program, activeLessonId))) {
                break;
            }
            hasNext = false;
        }
        if (hasNext) {
            i = 1;
            Iterator it4 = program.a().getModules().iterator();
            while (it4.hasNext()) {
                item = it4.next();
                List lessons2 = (ProgramModel_ModuleModel)item.getLessons();
                hasNext3 = lessons2 instanceof Collection;
                i = 0;
                if (i != 0) {
                }
            }
            n.d(item);
            i2 = item.getIndex() + i;
            ProgramLessonItem.LessonPositionData programLessonItem_LessonPositionData = new ProgramLessonItem_LessonPositionData(hasNext.getId(), hasNext.getIndex() + i, i2);
        }
        return hasNext;
    }

    /* renamed from: e, reason: from kotlin metadata */
    public final ProgramLessonItem generateLessonItem(k.b program, String dogId, String lessonId, boolean isActiveProgram) {
        String activeLessonId;
        ProgramProgress programProgress;
        Iterator it3;
        ListIterator listIterator;
        int i;
        ProgramLessonItem.ProgramLessonStatus nOT_STARTED2;
        Object item3;
        ProgramModel.ModuleModel moduleModel;
        app.dogo.externalmodel.model.responses.ProgramProgress.QuestionStatus question = null;
        boolean z2;
        int i2;
        ProgramModel.LessonModel lessonModel;
        long startTimeMs;
        ProgramProgress.ModuleProgress moduleProgress;
        boolean z;
        String str;
        ProgramProgress.LessonProgress lessonProgress;
        String str2;
        String str3;
        boolean hasNext;
        boolean z5;
        boolean z6;
        boolean z7;
        final Object program3 = this;
        k.b program2 = program;
        Object dogId2 = dogId;
        n.f(program2, "program");
        n.f(dogId2, "dogId");
        if (lessonId == null) {
            activeLessonId = findActiveLessonId(program);
        } else {
            Object lessonId2 = lessonId;
        }
        Iterator it = program.a().getModules().iterator();
        i2 = 0;
        i = 1;
        i = 0;
        while (it.hasNext()) {
            Iterator it6 = (ProgramModel_ModuleModel)item3.getLessons().iterator();
            while (it6.hasNext()) {
                if (n.b((ProgramModel_LessonModel)item5.getId(), activeLessonId)) {
                    break loop_6;
                }
            }
            int r9 = i;
            if (i != 0) {
                break;
            }
        }
        if ((ProgramModel_ModuleModel)item3 == null) {
        }
        Iterator it2 = moduleModel.getLessons().iterator();
        while (it2.hasNext()) {
            if (n.b((ProgramModel_LessonModel)item4.getId(), activeLessonId)) {
                break;
            }
        }
        if ((ProgramModel_LessonModel)i2 == 0) {
        }
        programProgress = program.c();
        int r10 = i2;
        int r11 = i2;
        int r15 = i;
        int r16 = i;
        int r4 = i;
        if (i != 0) {
            nOT_STARTED2 = ProgramLessonItem_ProgramLessonStatus.MASTERED;
        } else {
            r4 = i;
            if (i != 0) {
                nOT_STARTED2 = ProgramLessonItem_ProgramLessonStatus.PASSED;
            } else {
                r4 = i;
                r4 = i != 0 ? ProgramLessonItem_ProgramLessonStatus.STARTED : ProgramLessonItem_ProgramLessonStatus.NOT_STARTED;
            }
        }
        if (lessonProgress != null) {
            question = lessonProgress.getQuestion();
        }
        int r6 = i;
        ProgramProgress programProgress2 = program.c();
        long l = 0L;
        if (programProgress2 == null) {
            int i4 = l;
        } else {
            startTimeMs = programProgress2.getStartTimeMs();
        }
        int r28 = i;
        ProgramLessonItem programLessonItem = new ProgramLessonItem(new ProgramSaveInfo(program.a().getId(), moduleModel.getId(), lessonModel.getId(), dogId2), new ProgramLessonItem_LessonPositionData(lessonModel.getId(), lessonModel.getIndex() + i, moduleModel.getIndex() + i), program3.getNextLessonPositionData(program2, activeLessonId), program.a().getName(), program.a().getCardBackgroundColor(), (i != 0 ? ProgramLessonItem_ProgramLessonStatus.STARTED : ProgramLessonItem_ProgramLessonStatus.NOT_STARTED), TrainingSession.copy$default(program3.buildTrainingProgressList(lessonModel, lessonProgress, program3.getModuleExamTrickList(moduleModel, moduleProgress)), null, null, z5, z6, 3, null), program3.buildTasksProgressList(lessonModel, lessonProgress), ProgramQuestion.Companion.fromModel(lessonModel.getQuestion(), i), null, i, isActiveProgram, 512, null);
        return programLessonItem;
    }
}
