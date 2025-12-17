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
import kotlin.d0.d.p;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0002J*\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u000c\u001a\u0004\u0018\u00010\t2\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u0004H\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0002J(\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00102\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0019\u001a\u00020\u001aJ \u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u001a\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u0010H\u0002¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/util/helpers/LessonItemHelper;", "", "()V", "buildTasksProgressList", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramTasks;", "lessonModel", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$LessonModel;", "programProgress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "buildTrainingProgressList", "Lapp/dogo/com/dogo_android/repository/domain/TrainingSession;", "lessonProgress", "examModuleList", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "findActiveLessonId", "", "program", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$ClassicProgram;", "findNextLessonId", "currentLessonId", "generateLessonItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem;", "dogId", "lessonId", "isActiveProgram", "", "getModuleExamTrickList", "moduleModel", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$ModuleModel;", "moduleProgress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleProgress;", "getNextLessonPositionData", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLessonItem$LessonPositionData;", "activeLessonId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a {

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n", d2 = {"<anonymous>", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "it", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleProgress;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<ProgramProgress.ModuleProgress, Iterable<? extends ProgramProgress.LessonProgress>> {

        public static final app.dogo.com.dogo_android.util.j0.a.a a;
        static {
            a.a aVar = new a.a();
            a.a.a = aVar;
        }

        a() {
            super(1);
        }

        public final Iterable<ProgramProgress.LessonProgress> a(ProgramProgress.ModuleProgress programProgress$ModuleProgress) {
            int obj1;
            if (moduleProgress == null) {
                obj1 = 0;
            } else {
                obj1 = moduleProgress.getLessons();
            }
            if (obj1 != null) {
            } else {
                obj1 = p.g();
            }
            return obj1;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((ProgramProgress.ModuleProgress)object);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n", d2 = {"<anonymous>", "", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$TrickStatus;", "it", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<ProgramProgress.LessonProgress, Iterable<? extends ProgramProgress.TrickStatus>> {

        public static final app.dogo.com.dogo_android.util.j0.a.b a;
        static {
            a.b bVar = new a.b();
            a.b.a = bVar;
        }

        b() {
            super(1);
        }

        public final Iterable<ProgramProgress.TrickStatus> a(ProgramProgress.LessonProgress programProgress$LessonProgress) {
            int values;
            Map obj2;
            values = 0;
            if (lessonProgress == null) {
            } else {
                obj2 = lessonProgress.getTricks();
                if (obj2 == null) {
                } else {
                    values = obj2.values();
                }
            }
            if (values != 0) {
            } else {
                values = p.g();
            }
            return values;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((ProgramProgress.LessonProgress)object);
        }
    }
    private final List<ProgramTasks> a(ProgramModel.LessonModel programModel$LessonModel, ProgramProgress.LessonProgress programProgress$LessonProgress2) {
        int nOT_STARTED;
        Object next;
        ProgramTasks programTasks;
        String str;
        String text;
        int i;
        Map tasks;
        Map obj8 = lessonModel.getTasks();
        ArrayList arrayList = new ArrayList(obj8.size());
        obj8 = obj8.entrySet().iterator();
        while (obj8.hasNext()) {
            next = obj8.next();
            i = 0;
            if (lessonProgress2 == null) {
            } else {
            }
            tasks = lessonProgress2.getTasks();
            if (tasks == null) {
            } else {
            }
            i = next;
            if (i != 0) {
            } else {
            }
            nOT_STARTED = ProgramTasks.Type.NOT_STARTED;
            programTasks = new ProgramTasks((TasksModel)(Map.Entry)next.getValue().getId(), (TasksModel)next.getValue().getText(), nOT_STARTED);
            arrayList.add(programTasks);
            nOT_STARTED = ProgramTasks.Type.COMPLETED;
        }
        return arrayList;
    }

    private final TrainingSession b(ProgramModel.LessonModel programModel$LessonModel, ProgramProgress.LessonProgress programProgress$LessonProgress2, List<TrickItem> list3) {
        Object next;
        boolean next2;
        int valueOf;
        boolean key;
        Map tricks;
        int i4;
        int i2;
        int i5;
        int i3;
        int i;
        int obj12;
        ArrayList arrayList2 = new ArrayList();
        obj12 = list3.iterator();
        while (obj12.hasNext()) {
            next = obj12.next();
            if (lessonModel.getTricks().containsKey((TrickItem)next.getId())) {
            }
            arrayList2.add(next);
        }
        Map obj10 = lessonModel.getTricks();
        ArrayList arrayList = new ArrayList(obj10.size());
        obj10 = obj10.entrySet().iterator();
        while (obj10.hasNext()) {
            obj12 = obj10.next();
            valueOf = 0;
            if (lessonProgress2 != null) {
            }
            tricks = lessonProgress2.getTricks();
            if (tricks == null) {
            } else {
            }
            tricks = tricks.get((TrickModel)(Map.Entry)obj12.getValue().getId());
            if ((ProgramProgress.TrickStatus)tricks == null) {
            } else {
            }
            valueOf = Integer.valueOf((ProgramProgress.TrickStatus)tricks.getKnowledge());
            obj12 = j1.T0((TrickModel)obj12.getValue(), valueOf, 0, false, 6, 0);
            obj12.setNewContent(true);
            arrayList.add(obj12);
        }
        super(arrayList, arrayList2, 0, 0, 12, 0);
        return obj10;
    }

    private final String c(k.b k$b) {
        String str;
        boolean lessons;
        Object obj3;
        if (d(b, 0) == null) {
            ArrayList arrayList = new ArrayList();
            obj3 = b.a().getModules().iterator();
            for (ProgramModel.ModuleModel next : obj3) {
                p.y(arrayList, next.getLessons());
            }
            str = (ProgramModel.LessonModel)p.j0(arrayList).getId();
        }
        return str;
    }

    private final String d(k.b k$b, String string2) {
        List list;
        Object iterator;
        boolean iterator3;
        int size;
        ProgramProgress modules;
        int i8;
        ProgramProgress.LessonProgress progressModel3;
        int i9;
        int i6;
        ProgramProgress.LessonProgress progressModel5;
        app.dogo.com.dogo_android.util.j0.a.a aVar;
        Iterator iterator2;
        List lessons;
        int next;
        boolean progressModel7;
        int lessonAndProgressModel;
        int i2;
        int next4;
        long lastUserInteractionTimeMs;
        int i4;
        String next3;
        ProgramProgress.LessonProgress progressModel2;
        int i3;
        long nextIndex;
        int i;
        ProgramProgress.LessonProgress progressModel4;
        long lastUserInteractionTimeMs2;
        int i10;
        ProgramProgress.LessonProgress progressModel;
        int i7;
        int next2;
        Object next5;
        int i5;
        ProgramProgress.LessonProgress progressModel6;
        Object obj13;
        int obj14;
        modules = b.c();
        i8 = 0;
        if (modules == null) {
            list = i8;
        } else {
        }
        if (list != null) {
        } else {
            list = p.g();
        }
        ArrayList arrayList = new ArrayList();
        obj13 = b.a().getModules().iterator();
        for (ProgramModel.ModuleModel next12 : obj13) {
            p.y(arrayList, next12.getLessons());
        }
        obj13 = new ArrayList(p.r(arrayList, 10));
        iterator2 = arrayList.iterator();
        for (ProgramModel.LessonModel next : iterator2) {
            Iterator iterator5 = list.iterator();
            for (Object next4 : iterator5) {
            }
            next4 = i8;
            lessonAndProgressModel = new LessonAndProgressModel(next, (ProgramProgress.LessonProgress)next4);
            obj13.add(lessonAndProgressModel);
            if (n.b((ProgramProgress.LessonProgress)iterator5.next().getId(), next.getId())) {
            } else {
            }
        }
        iterator = obj13.iterator();
        for (Object iterator2 : iterator) {
        }
        iterator2 = i8;
        if ((LessonAndProgressModel)iterator2 == 0) {
            iterator = obj13.iterator();
            if (!iterator.hasNext()) {
                iterator2 = i8;
            } else {
                if (!iterator.hasNext()) {
                } else {
                    progressModel7 = (LessonAndProgressModel)iterator.next().getProgressModel();
                    lessonAndProgressModel = 0;
                    if (progressModel7 == null) {
                        lastUserInteractionTimeMs = lessonAndProgressModel;
                    } else {
                        lastUserInteractionTimeMs = progressModel7.getLastUserInteractionTimeMs();
                    }
                    Object next11 = iterator.next();
                    ProgramProgress.LessonProgress progressModel8 = (LessonAndProgressModel)next11.getProgressModel();
                    do {
                        next11 = iterator.next();
                        progressModel8 = (LessonAndProgressModel)next11.getProgressModel();
                        lastUserInteractionTimeMs2 = progressModel8.getLastUserInteractionTimeMs();
                        if (Long.compare(lastUserInteractionTimeMs, lastUserInteractionTimeMs2) < 0) {
                        }
                        if (iterator.hasNext()) {
                        }
                        iterator2 = next11;
                        lastUserInteractionTimeMs = lastUserInteractionTimeMs2;
                        lastUserInteractionTimeMs2 = lessonAndProgressModel;
                    } while (progressModel8 == null);
                }
            }
            if ((LessonAndProgressModel)iterator2 == null) {
                iterator2 = iterator;
            }
        }
        Iterator iterator4 = obj13.iterator();
        int i12 = 0;
        i2 = i12;
        lastUserInteractionTimeMs = -1L;
        for (LessonAndProgressModel next13 : iterator4) {
            i2++;
            lastUserInteractionTimeMs = -1L;
        }
        i2 = lastUserInteractionTimeMs;
        int i13 = 1;
        if (obj13.isEmpty()) {
            size = i13;
        } else {
            iterator3 = obj13.iterator();
            while (iterator3.hasNext() != null) {
                progressModel2 = (LessonAndProgressModel)iterator3.next().getProgressModel();
                if (progressModel2 == null) {
                } else {
                }
                if (progressModel2.isMastered() == i13) {
                } else {
                }
                next3 = i12;
                next3 = i13;
            }
        }
        progressModel4 = iterator2.getProgressModel();
        if (progressModel4 == null) {
            i3 = i12;
        } else {
        }
        if (i3 == 0 && !n.b(string2, iterator2.getId())) {
            obj14 = !n.b(string2, iterator2.getId()) ? i13 : i12;
        } else {
        }
        ListIterator listIterator = obj13.listIterator(obj13.size());
        while (listIterator.hasPrevious()) {
            progressModel = (LessonAndProgressModel)listIterator.previous().getProgressModel();
            if (progressModel == null) {
            } else {
            }
            if (progressModel.isMastered() == i13) {
            } else {
            }
            i10 = i12;
            i10 = i13;
        }
        nextIndex = lastUserInteractionTimeMs;
        i = nextIndex > i2 ? i13 : i12;
        Iterator iterator6 = obj13.iterator();
        i7 = i12;
        while (iterator6.hasNext()) {
            next5 = iterator6.next();
            progressModel6 = (LessonAndProgressModel)next5.getProgressModel();
            if (progressModel6 == null) {
            } else {
            }
            if (progressModel6.isMastered() == i13) {
            } else {
            }
            i5 = i12;
            if (i5 == 0 && !n.b(next5.getId(), iterator2.getId())) {
            } else {
            }
            next2 = i12;
            if (next2 != 0) {
                break;
            } else {
            }
            i7++;
            if (!n.b(next5.getId(), iterator2.getId())) {
            } else {
            }
            next2 = i13;
            i5 = i13;
        }
        i4 = lastUserInteractionTimeMs < i2 ? i13 : i12;
        if (size != 0) {
        } else {
            if (obj14 != null) {
                i8 = iterator2.getId();
            } else {
                obj14 = "Collection contains no element matching the predicate.";
                if (i != 0) {
                    obj13 = obj13.subList(i2 += i13, obj13.size()).iterator();
                    while (obj13.hasNext()) {
                        size = obj13.next();
                        progressModel3 = (LessonAndProgressModel)size.getProgressModel();
                        if (progressModel3 == null) {
                        } else {
                        }
                        if (progressModel3.isMastered() == i13) {
                        } else {
                        }
                        i9 = i12;
                        i9 = i13;
                    }
                    obj13 = new NoSuchElementException(obj14);
                    throw obj13;
                }
                if (i4 != 0) {
                    obj13 = obj13.iterator();
                    while (obj13.hasNext()) {
                        size = obj13.next();
                        progressModel5 = (LessonAndProgressModel)size.getProgressModel();
                        if (progressModel5 == null) {
                        } else {
                        }
                        if (progressModel5.isMastered() == i13) {
                        } else {
                        }
                        i6 = i12;
                        i6 = i13;
                    }
                    obj13 = new NoSuchElementException(obj14);
                    throw obj13;
                }
            }
        }
        return i8;
    }

    private final List<TrickItem> f(ProgramModel.ModuleModel programModel$ModuleModel, ProgramProgress.ModuleProgress programProgress$ModuleProgress2) {
        app.dogo.com.dogo_android.util.j0.a.b bVar;
        int i4;
        int knowledge;
        Object obj;
        Integer valueOf;
        int i;
        int i5;
        int i3;
        int i2;
        List obj11;
        final int i6 = 0;
        if (moduleProgress2 == null) {
            obj11 = i6;
        } else {
        }
        if (obj11 == null) {
            obj11 = p.g();
        }
        List obj10 = moduleModel.getExams();
        ArrayList arrayList = new ArrayList(p.r(obj10, 10));
        obj10 = obj10.iterator();
        for (Object next2 : obj10) {
            obj = next2;
            Iterator iterator = obj11.iterator();
            for (Object valueOf : iterator) {
            }
            valueOf = i6;
            if ((ProgramProgress.TrickStatus)valueOf == null) {
            } else {
            }
            knowledge = (ProgramProgress.TrickStatus)valueOf.getKnowledge();
            arrayList.add(j1.T0(obj, Integer.valueOf(knowledge), 0, false, 6, 0));
            knowledge = 0;
            if (n.b((ProgramProgress.TrickStatus)iterator.next().getId(), obj.getId())) {
            } else {
            }
        }
        return arrayList;
    }

    private final ProgramLessonItem.LessonPositionData g(k.b k$b, String string2) {
        Iterator iterator2;
        ArrayList arrayList;
        List lessons;
        boolean lessonPositionData;
        boolean z;
        Object next;
        Iterator iterator;
        boolean empty;
        int i;
        String str;
        k.b obj10;
        String obj11;
        arrayList = new ArrayList();
        Iterator iterator3 = b.a().getModules().iterator();
        for (ProgramModel.ModuleModel next3 : iterator3) {
            p.y(arrayList, next3.getLessons());
        }
        iterator2 = arrayList.iterator();
        for (Object arrayList : iterator2) {
        }
        arrayList = lessonPositionData;
        if ((ProgramModel.LessonModel)arrayList != null) {
            z = 1;
            obj10 = b.a().getModules().iterator();
            while (obj10.hasNext()) {
                next = obj10.next();
                iterator = (ProgramModel.ModuleModel)next.getLessons();
                i = 0;
                if (iterator instanceof Collection != null && iterator.isEmpty()) {
                } else {
                }
                iterator = iterator.iterator();
                while (iterator.hasNext()) {
                    if (n.b((ProgramModel.LessonModel)iterator.next().getId(), arrayList.getId())) {
                        break loop_15;
                    } else {
                    }
                }
                if (i != 0) {
                    break;
                } else {
                }
                if (n.b((ProgramModel.LessonModel)iterator.next().getId(), arrayList.getId())) {
                } else {
                }
                i = z;
                if (iterator.isEmpty()) {
                } else {
                }
            }
            n.d(lessonPositionData);
            lessonPositionData = new ProgramLessonItem.LessonPositionData((ProgramModel.LessonModel)arrayList.getId(), index += z, obj10 += z);
        }
        return lessonPositionData;
    }

    public final ProgramLessonItem e(k.b k$b, String string2, String string3, boolean z4) {
        String str;
        Object iterator;
        Object iterator2;
        ProgramProgress listIterator;
        int passed;
        int started;
        int i7;
        ProgramLessonItem.ProgramLessonStatus nOT_STARTED;
        Object next;
        int question;
        int i6;
        int i;
        int i5;
        int next3;
        long startTimeMs;
        int next2;
        boolean z;
        String str2;
        int previous;
        String empty;
        String str3;
        Object knowledge;
        int i2;
        int i3;
        int i4;
        final Object obj = this;
        Object obj2 = b;
        Object obj3 = string2;
        n.f(obj2, "program");
        n.f(obj3, "dogId");
        if (string3 == null) {
            str = c(b);
        } else {
            str = string3;
        }
        iterator = b.a().getModules().iterator();
        question = 0;
        i = 1;
        i5 = 0;
        for (Object next : iterator) {
            Iterator iterator3 = (ProgramModel.ModuleModel)next.getLessons().iterator();
            for (Object next2 : iterator3) {
            }
            next2 = question;
            if (next2 != 0) {
            } else {
            }
            next3 = i5;
            question = 0;
            i = 1;
            i5 = 0;
            next3 = i;
            if (n.b((ProgramModel.LessonModel)iterator3.next().getId(), str)) {
            } else {
            }
        }
        next = question;
        if ((ProgramModel.ModuleModel)next == null) {
            next = iterator;
        }
        iterator2 = next.getLessons().iterator();
        for (Object next3 : iterator2) {
        }
        next3 = question;
        if ((ProgramModel.LessonModel)next3 == 0) {
            next3 = iterator2;
        }
        listIterator = b.c();
        if (listIterator == null) {
            next2 = question;
        } else {
        }
        if (next2 == 0) {
            previous = question;
        } else {
        }
        if (next2 == 0) {
            i2 = i5;
        } else {
        }
        if (previous == 0) {
            i3 = i5;
        } else {
        }
        if (previous == 0) {
            passed = i5;
        } else {
        }
        if (passed != 0) {
            nOT_STARTED = ProgramLessonItem.ProgramLessonStatus.MASTERED;
        } else {
            if (previous == 0) {
                started = i5;
            } else {
            }
            if (started != 0) {
                nOT_STARTED = ProgramLessonItem.ProgramLessonStatus.PASSED;
            } else {
                if (previous == 0) {
                    i7 = i5;
                } else {
                }
                nOT_STARTED = i7 != 0 ? ProgramLessonItem.ProgramLessonStatus.STARTED : ProgramLessonItem.ProgramLessonStatus.NOT_STARTED;
            }
        }
        ProgramSaveInfo programSaveInfo = new ProgramSaveInfo(b.a().getId(), next.getId(), next3.getId(), obj3);
        ProgramLessonItem.LessonPositionData lessonPositionData = new ProgramLessonItem.LessonPositionData(next3.getId(), index2 += i, index += i);
        if (previous == 0) {
        } else {
            question = previous.getQuestion();
        }
        i6 = question != null ? i : i5;
        ProgramProgress programProgress = b.c();
        int i9 = 0;
        if (programProgress == null) {
            startTimeMs = i9;
        } else {
            startTimeMs = programProgress.getStartTimeMs();
        }
        i4 = Long.compare(startTimeMs, i9) != 0 ? i : i5;
        super(programSaveInfo, lessonPositionData, obj.g(obj2, str), b.a().getName(), b.a().getCardBackgroundColor(), nOT_STARTED, TrainingSession.copy$default(obj.b(next3, previous, obj.f(next, next2)), 0, 0, i2, i3, 3, 0), obj.a(next3, previous), ProgramQuestion.Companion.fromModel(next3.getQuestion(), i6), 0, i4, z4, 512, 0);
        return programLessonItem;
    }
}
