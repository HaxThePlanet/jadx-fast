package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.model.trainingprogram.LessonAndProgressModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel;
import app.dogo.com.dogo_android.repository.domain.Program;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import app.dogo.com.dogo_android.repository.domain.ProgramExamList;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson;
import app.dogo.com.dogo_android.repository.domain.ProgramLesson.Type;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.y.k;
import app.dogo.com.dogo_android.y.k.b;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission;
import app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.ModuleExam;
import app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.e0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;
import kotlin.z.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010JA\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001fJ*\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0002JH\u0010)\u001a\u0008\u0012\u0004\u0012\u00020+0*2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/2\u0008\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002J*\u00105\u001a\u00020+2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u0010.\u001a\u00020/2\u0008\u00100\u001a\u0004\u0018\u000101H\u0002J.\u00106\u001a\u0008\u0012\u0004\u0012\u00020\u00120*2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u0010.\u001a\u00020/2\u0008\u00100\u001a\u0004\u0018\u000101J \u00107\u001a\u00020+2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u00108\u001a\u00020/H\u0002J8\u00109\u001a\u00020+2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001e2\u0006\u00108\u001a\u00020/2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002JH\u0010>\u001a\u0008\u0012\u0004\u0012\u00020+0*2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/2\u0008\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002J!\u0010?\u001a\u00020@2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AJ@\u0010B\u001a\u0008\u0012\u0004\u0012\u00020+0*2\u0006\u0010\"\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0008\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010C\u001a\u00020#H\u0002J\u001a\u0010D\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0002J*\u0010E\u001a\u00020=2\u0006\u0010-\u001a\u00020\u001e2\u0008\u0010'\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020\u001eH\u0002J!\u0010I\u001a\u00020@2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0019\u0010J\u001a\u00020K2\u0006\u0010,\u001a\u00020#H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u001e\u0010M\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u0010N\u001a\u00020#J\u0010\u0010O\u001a\u00020\u001e2\u0006\u00108\u001a\u00020/H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006P", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "premiumContentLockInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/PremiumContentLockInteractor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/interactor/PremiumContentLockInteractor;Lkotlinx/coroutines/CoroutineDispatcher;)V", "buildExamData", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "examSubmission", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "trickModel", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "examStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "unlockDate", "", "hasNewUpdates", "", "(Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/Long;Z)Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "buildExamItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "dogId", "", "lessonId", "program", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "progress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "buildLessonItems", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson;", "programId", "isDogPremium", "module", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$ModuleModel;", "moduleProgress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleProgress;", "activeLessonIndex", "", "activeLessonModuleIndex", "buildModuleExam", "buildModuleExamList", "buildModuleHeader", "moduleModel", "buildModuleLesson", "lessonModel", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$LessonModel;", "lessonCompletionStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson$Type;", "buildModuleLessonItems", "buildProgramExamListItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamList;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildProgramLessonList", "activeLessonId", "findActiveLessonId", "findLessonStatus", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "isLessonUnlocked", "isLessonActive", "getProgramExamList", "getProgramLessonsList", "Lapp/dogo/com/dogo_android/repository/domain/Program;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProgramSaveInfo", "moduleId", "isExamAvailable", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class v2 {

    private final p1 a;
    private final j1 b;
    private final r2 c;
    private final app.dogo.com.dogo_android.s.a.d3 d;
    private final p2 e;
    private final app.dogo.com.dogo_android.s.a.i3 f;
    private final h0 g;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 5, 1})
    public static final class a implements Comparator {
        public final int compare(T t, T t2) {
            return a.c(Integer.valueOf(j1.G((ProgramExam)t2)), Integer.valueOf(j1.G((ProgramExam)t)));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 5, 1})
    public static final class b implements Comparator {

        final Comparator a;
        public b(Comparator comparator) {
            this.a = comparator;
            super();
        }

        public final int compare(T t, T t2) {
            int compare;
            Object obj3;
            Object obj4;
            if (this.a.compare(t, t2) != 0) {
            } else {
                compare = a.c(Long.valueOf((ProgramExam)t.getOrderDate()), Long.valueOf((ProgramExam)t2.getOrderDate()));
            }
            return compare;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetProgramLessonsListInteractor$buildProgramExamListItem$2", f = "GetProgramLessonsListInteractor.kt", l = 208, m = "invokeSuspend")
    static final class c extends k implements p<m0, d<? super ProgramExamList>, Object> {

        final String $dogId;
        final String $programId;
        Object L$0;
        int label;
        final app.dogo.com.dogo_android.s.a.v2 this$0;
        c(app.dogo.com.dogo_android.s.a.v2 v2, String string2, String string3, d<? super app.dogo.com.dogo_android.s.a.v2.c> d4) {
            this.this$0 = v2;
            this.$dogId = string2;
            this.$programId = string3;
            super(2, d4);
        }

        public final Object c(m0 m0, d<? super ProgramExamList> d2) {
            return (v2.c)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            v2.c obj4 = new v2.c(this.this$0, this.$dogId, this.$programId, d2);
            return obj4;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$0;
            int label;
            String $dogId;
            String $programId;
            List list;
            boolean booleanValue;
            Iterator iterator;
            int next;
            boolean booleanValue2;
            String str2;
            String str;
            Object obj15;
            Object obj = b.d();
            label = this.label;
            int i = 1;
            int i2 = 0;
            if (label != 0) {
                if (label != i) {
                } else {
                    l$0 = this.L$0;
                    q.b(object);
                    Object blockingGet = v2.h(this.this$0).z(this.$dogId).blockingGet();
                    app.dogo.com.dogo_android.s.a.v2 this$05 = this.this$0;
                    ArrayList arrayList = new ArrayList();
                    Iterator iterator2 = (k.b)obj15.a().getModules().iterator();
                    String str6 = "isDogPremium";
                    while (iterator2.hasNext()) {
                        Object next3 = iterator2.next();
                        iterator = obj15.c();
                        if (iterator == null) {
                        } else {
                        }
                        iterator = iterator.getModules();
                        if (iterator == null) {
                        } else {
                        }
                        iterator = iterator.iterator();
                        while (iterator.hasNext()) {
                            Object obj2 = next;
                            if ((ProgramProgress.ModuleProgress)obj2 == null) {
                            } else {
                            }
                            str2 = (ProgramProgress.ModuleProgress)obj2.getId();
                            str2 = i2;
                        }
                        next = i2;
                        n.e(l$0, str6);
                        if (l$0.booleanValue()) {
                        } else {
                        }
                        list = v2.e(this$05).a(this$05.n(this.$dogId, this.$programId, next3, next));
                        p.y(arrayList, list);
                        str6 = "isDogPremium";
                        obj2 = next;
                        if ((ProgramProgress.ModuleProgress)obj2 == null) {
                        } else {
                        }
                        str2 = (ProgramProgress.ModuleProgress)obj2.getId();
                        if (b.a(n.b(str2, next3.getId())).booleanValue()) {
                        } else {
                        }
                        str2 = i2;
                        next = i2;
                    }
                    n.e((DogProfile)blockingGet, "dogProfile");
                    n.e(l$0, str6);
                    ProgramExamList programExamList = new ProgramExamList(arrayList, v2.a(this.this$0, this.$dogId, v2.c(this.this$0, obj15.a(), obj15.c()), obj15.a(), obj15.c()), blockingGet, l$0.booleanValue());
                    return programExamList;
                }
                obj15 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj15;
            }
            q.b(object);
            obj15 = d3.b(v2.i(this.this$0), i2, i, i2).blockingGet();
            this.L$0 = (Boolean)obj15;
            this.label = i;
            label = v2.f(this.this$0).r(this.$dogId, this.$programId, this);
            if (label == obj) {
                return obj;
            }
            l$0 = obj15;
            obj15 = label;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/Program;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetProgramLessonsListInteractor$getProgramLessonsList$2", f = "GetProgramLessonsListInteractor.kt", l = {35, 37}, m = "invokeSuspend")
    static final class d extends k implements p<m0, d<? super Program>, Object> {

        final String $programId;
        Object L$0;
        Object L$1;
        int label;
        final app.dogo.com.dogo_android.s.a.v2 this$0;
        d(app.dogo.com.dogo_android.s.a.v2 v2, String string2, d<? super app.dogo.com.dogo_android.s.a.v2.d> d3) {
            this.this$0 = v2;
            this.$programId = string2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super Program> d2) {
            return (v2.d)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            v2.d obj3 = new v2.d(this.this$0, this.$programId, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object booleanValue;
            Object l$0;
            Object obj;
            Object blockingGet;
            j1 j1Var;
            boolean iterator;
            int i;
            String $programId;
            String booleanValue2;
            int i2;
            ProgramModel cOMPLETED;
            int i3;
            final Object obj2 = this;
            Object obj3 = b.d();
            int label = obj2.label;
            int i4 = 2;
            final int i5 = 1;
            if (label != 0) {
                if (label != i5) {
                    if (label != i4) {
                    } else {
                        booleanValue = obj2.L$1;
                        l$0 = obj2.L$0;
                        q.b(object);
                        obj = object;
                        final String str4 = v2.c(obj2.this$0, (k.b)obj.a(), obj.c());
                        n.e(booleanValue, "isDogPremium");
                        List list = v2.b(obj2.this$0, l$0, booleanValue.booleanValue(), obj2.$programId, obj.a(), obj.c(), str4);
                        int i6 = 0;
                        if (list instanceof Collection != null && list.isEmpty()) {
                            if (list.isEmpty()) {
                                i = i6;
                            } else {
                                iterator = list.iterator();
                                while (iterator.hasNext()) {
                                    if ((ProgramLesson)iterator.next().getType() == ProgramLesson.Type.COMPLETED) {
                                    } else {
                                    }
                                    i2 = i6;
                                    i2 = i5;
                                }
                            }
                        } else {
                        }
                        if (i != 0) {
                            v2.d(obj2.this$0).f1(i5);
                        }
                        if (v2.g(obj2.this$0).b0() && !booleanValue.booleanValue()) {
                            i3 = !booleanValue.booleanValue() ? i5 : i6;
                        } else {
                        }
                        super(obj.a().getName(), obj.a().getDescription(), obj.a().getCertificatePaperImage(), list, i3, v2.a(obj2.this$0, l$0, str4, obj.a(), obj.c()));
                        return program;
                    }
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw illegalStateException;
                }
                q.b(object);
                l$0 = object;
            } else {
                q.b(object);
                obj2.label = i5;
                if (v2.h(obj2.this$0).u(obj2) == obj3) {
                    return obj3;
                }
            }
            blockingGet = v2.i(obj2.this$0).a((String)l$0).blockingGet();
            obj2.L$0 = l$0;
            obj2.L$1 = (Boolean)blockingGet;
            obj2.label = i4;
            if (v2.f(obj2.this$0).r(l$0, obj2.$programId, obj2) == obj3) {
                return obj3;
            }
            booleanValue = blockingGet;
        }
    }
    public v2(p1 p1, j1 j12, r2 r23, app.dogo.com.dogo_android.s.a.d3 d34, p2 p25, app.dogo.com.dogo_android.s.a.i3 i36, h0 h07) {
        n.f(p1, "userRepository");
        n.f(j12, "programRepository");
        n.f(r23, "remoteConfigService");
        n.f(d34, "isDogPremiumInteractor");
        n.f(p25, "preferenceService");
        n.f(i36, "premiumContentLockInteractor");
        n.f(h07, "dispatcher");
        super();
        this.a = p1;
        this.b = j12;
        this.c = r23;
        this.d = d34;
        this.e = p25;
        this.f = i36;
        this.g = h07;
    }

    public v2(p1 p1, j1 j12, r2 r23, app.dogo.com.dogo_android.s.a.d3 d34, p2 p25, app.dogo.com.dogo_android.s.a.i3 i36, h0 h07, int i8, g g9) {
        h0 i;
        h0 h0Var;
        if (i8 & 64 != 0) {
            h0Var = i;
        } else {
            h0Var = h07;
        }
        super(p1, j12, r23, d34, p25, i36, h0Var);
    }

    public static final ProgramExamSummary a(app.dogo.com.dogo_android.s.a.v2 v2, String string2, String string3, ProgramModel programModel4, ProgramProgress programProgress5) {
        return v2.k(string2, string3, programModel4, programProgress5);
    }

    public static final List b(app.dogo.com.dogo_android.s.a.v2 v2, String string2, boolean z3, String string4, ProgramModel programModel5, ProgramProgress programProgress6, String string7) {
        return v2.s(string2, z3, string4, programModel5, programProgress6, string7);
    }

    public static final String c(app.dogo.com.dogo_android.s.a.v2 v2, ProgramModel programModel2, ProgramProgress programProgress3) {
        return v2.t(programModel2, programProgress3);
    }

    public static final p2 d(app.dogo.com.dogo_android.s.a.v2 v2) {
        return v2.e;
    }

    public static final app.dogo.com.dogo_android.s.a.i3 e(app.dogo.com.dogo_android.s.a.v2 v2) {
        return v2.f;
    }

    public static final j1 f(app.dogo.com.dogo_android.s.a.v2 v2) {
        return v2.b;
    }

    public static final r2 g(app.dogo.com.dogo_android.s.a.v2 v2) {
        return v2.c;
    }

    public static final p1 h(app.dogo.com.dogo_android.s.a.v2 v2) {
        return v2.a;
    }

    public static final app.dogo.com.dogo_android.s.a.d3 i(app.dogo.com.dogo_android.s.a.v2 v2) {
        return v2.d;
    }

    private final ProgramExam j(ProgramProgress.ExamSubmission programProgress$ExamSubmission, TrickModel trickModel2, ProgramExam.Status programExam$Status3, ProgramSaveInfo programSaveInfo4, Long long5, boolean z6) {
        int longValue;
        int intValue;
        int i;
        Boolean evaluatedByAvatar;
        long longValue2;
        Long uploadTimeMs;
        Long reviewTimeMs2;
        int reviewTimeMs;
        String videoThumbnailUrl2;
        String videoThumbnailUrl;
        String reviewComment;
        String str3;
        String str4;
        String str2;
        Object str;
        Object bool;
        if (examSubmission == null) {
            longValue2 = longValue;
        } else {
        }
        if (examSubmission == null) {
        } else {
            reviewTimeMs2 = examSubmission.getReviewTimeMs();
            if (reviewTimeMs2 == null) {
            } else {
                longValue = reviewTimeMs2.longValue();
            }
        }
        reviewTimeMs = 0;
        if (examSubmission == null) {
            videoThumbnailUrl2 = reviewTimeMs;
        } else {
            videoThumbnailUrl2 = examSubmission.getVideoThumbnailUrl();
        }
        if (videoThumbnailUrl2 == null) {
            videoThumbnailUrl = trickModel2.getImage();
        } else {
            videoThumbnailUrl = examSubmission.getVideoThumbnailUrl();
        }
        if (examSubmission == null) {
            reviewComment = reviewTimeMs;
        } else {
            reviewComment = examSubmission.getVideoUrl();
        }
        String str5 = "";
        if (reviewComment == null) {
            str3 = str5;
        } else {
            str3 = reviewComment;
        }
        if (examSubmission == null) {
            str4 = str5;
        } else {
        }
        String examInstructions = trickModel2.getExamInstructions();
        str2 = examInstructions == null ? str5 : examInstructions;
        Integer examTimeLimit = trickModel2.getExamTimeLimit();
        if (examTimeLimit == null) {
            intValue = 30;
        } else {
            intValue = examTimeLimit.intValue();
        }
        if (examSubmission == null) {
            i = 0;
        } else {
            i = n.b(examSubmission.getHasNewFeedback(), Boolean.TRUE);
        }
        if (examSubmission == null) {
            str = str5;
        } else {
        }
        if (examSubmission == null) {
            bool = str5;
        } else {
        }
        if (examSubmission == null) {
        } else {
            reviewTimeMs = examSubmission.getReviewTimeMs();
        }
        super(programSaveInfo4, trickModel2.getId(), trickModel2.getImage(), str3, videoThumbnailUrl, status3, trickModel2.getName(), Math.max(longValue2, obj3), obj15, str4, str2, intValue, 0, obj20, Boolean.valueOf(i), Boolean.valueOf(z6), long5, str, bool, reviewTimeMs, 0, 0, 0, 0, 3934208, 0);
        return programExam;
    }

    private final ProgramExamSummary k(String string, String string2, ProgramModel programModel3, ProgramProgress programProgress4) {
        Object obj;
        Object iterator2;
        Object next5;
        int i;
        int i4;
        int i2;
        Iterator iterator;
        int next2;
        int next4;
        boolean next3;
        boolean next;
        boolean tRUE;
        int aPPROVED;
        boolean z;
        int i3;
        String str;
        String str2 = string;
        obj = string2;
        iterator2 = programModel3.getModules().iterator();
        i = 1;
        i4 = 0;
        i2 = 0;
        for (Object next5 : iterator2) {
            Iterator iterator6 = (ProgramModel.ModuleModel)next5.getLessons().iterator();
            for (Object next4 : iterator6) {
            }
            next4 = i2;
            if (next4 != 0) {
            } else {
            }
            next2 = i4;
            i = 1;
            i4 = 0;
            i2 = 0;
            next2 = i;
            if (n.b((ProgramModel.LessonModel)iterator6.next().getId(), obj)) {
            } else {
            }
        }
        next5 = i2;
        if ((ProgramModel.ModuleModel)next5 == 0) {
            next5 = iterator2;
        }
        Iterator iterator4 = next5.getLessons().iterator();
        for (Object next2 : iterator4) {
        }
        next2 = i2;
        if ((ProgramModel.LessonModel)next2 == 0) {
            next2 = obj;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator3 = programModel3.getModules().iterator();
        while (iterator3.hasNext()) {
            Object next10 = iterator3.next();
            if (programProgress4 == null) {
            } else {
            }
            tRUE = programProgress4.getModules();
            if (!tRUE) {
            } else {
            }
            tRUE = tRUE.iterator();
            while (tRUE.hasNext()) {
                Object obj4 = aPPROVED;
                if ((ProgramProgress.ModuleProgress)obj4 == null) {
                } else {
                }
                i3 = (ProgramProgress.ModuleProgress)obj4.getId();
                i3 = i2;
            }
            aPPROVED = i2;
            p.y(arrayList2, this.n(str2, programModel3.getId(), next10, aPPROVED));
            obj4 = aPPROVED;
            if ((ProgramProgress.ModuleProgress)obj4 == null) {
            } else {
            }
            i3 = (ProgramProgress.ModuleProgress)obj4.getId();
            if (n.b(i3, next10.getId())) {
            } else {
            }
            i3 = i2;
            aPPROVED = i2;
        }
        boolean z3 = this;
        ArrayList arrayList = new ArrayList();
        iterator = arrayList2.iterator();
        while (iterator.hasNext()) {
            next3 = iterator.next();
            if ((ProgramExam)next3.getStatus() == ProgramExam.Status.APPROVED) {
            } else {
            }
            tRUE = i4;
            if (tRUE) {
            }
            arrayList.add(next3);
            tRUE = i;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator iterator5 = arrayList2.iterator();
        while (iterator5.hasNext()) {
            iterator = iterator5.next();
            if (n.b((ProgramExam)iterator.getHasNewUpdates(), Boolean.TRUE)) {
            }
            arrayList3.add(iterator);
        }
        ProgramSaveInfo programSaveInfo = new ProgramSaveInfo(programModel3.getId(), next5.getId(), next2.getId(), str2);
        super(programSaveInfo, Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList3.size()), programModel3.getCardBackgroundColor(), programModel3.getCertificateLaurelsImage(), programModel3.getCertificatePaperImage(), programModel3.getCertificatePlaceholderImage(), programModel3.getName(), programModel3.getCertificateRequirements());
        return programExamSummary;
    }

    private final List<ProgramLesson> l(String string, String string2, boolean z3, ProgramModel.ModuleModel programModel$ModuleModel4, ProgramProgress.ModuleProgress programProgress$ModuleProgress5, int i6, int i7) {
        int i2;
        ProgramLesson programLesson;
        int i4;
        int index;
        int i5;
        int i;
        Object obj5;
        int i3;
        String str2;
        int lessons;
        String str;
        boolean z;
        ProgramModel.ModuleModel moduleModel;
        Object obj;
        ProgramLesson.Type type;
        final int i8 = i6;
        final int i9 = i7;
        List lessons2 = moduleModel4.getLessons();
        ArrayList arrayList = new ArrayList(p.r(lessons2, 10));
        Iterator iterator = lessons2.iterator();
        int i12 = 0;
        i2 = i12;
        for (Object next2 : iterator) {
            if (moduleModel4.getIndex() == i9) {
            } else {
            }
            if (moduleModel4.getIndex() < i9) {
            } else {
            }
            i4 = i12;
            if (moduleModel4.getIndex() == i9 && i2 == i8) {
            } else {
            }
            i3 = i12;
            if (moduleProgress5 != null) {
            }
            lessons = moduleProgress5.getLessons();
            if (lessons == 0) {
            } else {
            }
            i = i2;
            arrayList.add(this.p(string, string2, z3, moduleModel4, (ProgramModel.LessonModel)next2, this.u(z3, i, i4, i3)));
            i2 = i5;
            if (i2 == i8) {
            } else {
            }
            i4 = i3;
            if (i2 <= i8) {
            } else {
            }
        }
        Object obj2 = this;
        return arrayList;
    }

    private final ProgramLesson m(String string, String string2, ProgramModel.ModuleModel programModel$ModuleModel3, ProgramProgress.ModuleProgress programProgress$ModuleProgress4) {
        ProgramSaveInfo programSaveInfo = new ProgramSaveInfo(string2, moduleModel3.getId(), "", string);
        super(programSaveInfo, 0, 0, ProgramLesson.Type.EXAM, 0, 0, n(string, string2, moduleModel3, moduleProgress4), 0, 182, 0);
        return obj12;
    }

    private final ProgramLesson o(String string, String string2, ProgramModel.ModuleModel programModel$ModuleModel3) {
        ProgramSaveInfo programSaveInfo = new ProgramSaveInfo(string2, moduleModel3.getId(), "", string);
        super(programSaveInfo, obj13 + 1, moduleModel3.getName(), ProgramLesson.Type.HEADER, 0, 0, 0, 0, 240, 0);
        return programLesson2;
    }

    private final ProgramLesson p(String string, String string2, boolean z3, ProgramModel.ModuleModel programModel$ModuleModel4, ProgramModel.LessonModel programModel$LessonModel5, ProgramLesson.Type programLesson$Type6) {
        ProgramLesson.Type uNLOCKED;
        int size;
        int i;
        int i2;
        int i3;
        ProgramLesson.Type type = type6;
        ProgramSaveInfo programSaveInfo = new ProgramSaveInfo(string2, moduleModel4.getId(), lessonModel5.getId(), string);
        int i4 = 1;
        Map tricks = lessonModel5.getTricks();
        ArrayList arrayList = new ArrayList(tricks.size());
        Iterator iterator = tricks.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            arrayList.add((TrickModel)next2.getValue().getName());
        }
        int i8 = 0;
        if (type != ProgramLesson.Type.ACTIVE) {
            if (type == ProgramLesson.Type.UNLOCKED) {
                i = i4;
            } else {
                i = i8;
            }
        } else {
        }
        i2 = lessonModel5.getIndex() == size2 -= i4 ? i4 : i8;
        if (obj.c.b0() && !z3) {
            i3 = !z3 ? i4 : i8;
        } else {
        }
        super(programSaveInfo, index + 1, p.h0(arrayList, " , ", 0, 0, 0, 0, 0, 62, 0), type6, i, i2, 0, i3, 64, 0);
        return programLesson2;
    }

    private final List<ProgramLesson> q(String string, String string2, boolean z3, ProgramModel.ModuleModel programModel$ModuleModel4, ProgramProgress.ModuleProgress programProgress$ModuleProgress5, int i6, int i7) {
        List obj3;
        e0 obj4;
        Object[] obj5;
        ProgramLesson[] obj6;
        final ProgramLesson programLesson = o(string, string2, moduleModel4);
        obj5 = l(string, string2, z3, moduleModel4, moduleProgress5, i6, i7);
        final String obj9 = "null cannot be cast to non-null type kotlin.Array<T>";
        final int i = 0;
        if (y(moduleModel4)) {
            obj4 = new e0(3);
            obj4.a(programLesson);
            obj5 = obj5.toArray(new ProgramLesson[i]);
            Objects.requireNonNull(obj5, obj9);
            obj4.b(obj5);
            obj4.a(m(string, string2, moduleModel4, moduleProgress5));
            obj3 = p.j(obj4.d(new ProgramLesson[obj4.c()]));
        } else {
            obj3 = new e0(2);
            obj3.a(programLesson);
            obj4 = obj5.toArray(new ProgramLesson[i]);
            Objects.requireNonNull(obj4, obj9);
            obj3.b(obj4);
            obj3 = p.j(obj3.d(new ProgramLesson[obj3.c()]));
        }
        return obj3;
    }

    private final List<ProgramLesson> s(String string, boolean z2, String string3, ProgramModel programModel4, ProgramProgress programProgress5, String string6) {
        int index2;
        int index;
        Object next3;
        int i;
        int i6;
        int next;
        int i5;
        Object modules;
        int next2;
        boolean z;
        boolean z3;
        Object obj;
        int i2;
        int i3;
        int i7;
        int i4;
        Object obj2 = string6;
        Iterator iterator = programModel4.getModules().iterator();
        i = 0;
        i6 = 0;
        for (Object next3 : iterator) {
            Iterator iterator4 = (ProgramModel.ModuleModel)next3.getLessons().iterator();
            for (Object next2 : iterator4) {
            }
            next2 = i6;
            if (next2 != 0) {
            } else {
            }
            next = i;
            i = 0;
            i6 = 0;
            next = 1;
            if (n.b((ProgramModel.LessonModel)iterator4.next().getId(), obj2)) {
            } else {
            }
        }
        next3 = i6;
        if ((ProgramModel.ModuleModel)next3 == 0) {
            index = i;
        } else {
            index = (ProgramModel.ModuleModel)next3.getIndex();
        }
        Iterator iterator2 = (ProgramModel.ModuleModel)programModel4.getModules().get(index).getLessons().iterator();
        for (Object next : iterator2) {
        }
        next = i6;
        if ((ProgramModel.LessonModel)next == 0) {
            index2 = i;
        } else {
            index2 = (ProgramModel.LessonModel)next.getIndex();
        }
        List modules4 = programModel4.getModules();
        ArrayList arrayList = new ArrayList(p.r(modules4, 10));
        Iterator iterator3 = modules4.iterator();
        for (Object modules : iterator3) {
            if (programProgress5 == null) {
            } else {
            }
            modules = programProgress5.getModules();
            if (modules == null) {
            } else {
            }
            i2 = i;
            arrayList.add(this.q(string, string3, z2, (ProgramModel.ModuleModel)modules, i2, index2, index));
            i = i4;
            i2 = i6;
        }
        return p.u(arrayList);
    }

    private final String t(ProgramModel programModel, ProgramProgress programProgress2) {
        int i2;
        ArrayList arrayList;
        int nextIndex;
        boolean next3;
        Iterator iterator;
        ProgramProgress.LessonProgress progressModel;
        List lessons;
        int next2;
        boolean next4;
        LessonAndProgressModel lessonAndProgressModel;
        Object next;
        int i;
        boolean z2;
        boolean next5;
        String str;
        boolean z;
        ProgramProgress.LessonProgress progressModel2;
        Object obj10;
        Object obj11;
        i2 = 0;
        if (programProgress2 == null) {
            arrayList = i2;
        } else {
        }
        if (arrayList == null) {
            arrayList = p.g();
        }
        ArrayList arrayList2 = new ArrayList();
        obj11 = programModel.getModules().iterator();
        for (ProgramModel.ModuleModel next8 : obj11) {
            p.y(arrayList2, next8.getLessons());
        }
        obj11 = new ArrayList(p.r(arrayList2, 10));
        iterator = arrayList2.iterator();
        for (ProgramModel.LessonModel next2 : iterator) {
            Iterator iterator2 = arrayList.iterator();
            for (Object next : iterator2) {
            }
            next = i2;
            lessonAndProgressModel = new LessonAndProgressModel(next2, (ProgramProgress.LessonProgress)next);
            obj11.add(lessonAndProgressModel);
            if (n.b((ProgramProgress.LessonProgress)iterator2.next().getId(), next2.getId())) {
            } else {
            }
        }
        ListIterator listIterator = obj11.listIterator(obj11.size());
        next4 = true;
        lessonAndProgressModel = 0;
        while (listIterator.hasPrevious()) {
            progressModel = (LessonAndProgressModel)listIterator.previous().getProgressModel();
            if (progressModel == null) {
            } else {
            }
            if (progressModel.isStarted() == next4) {
            } else {
            }
            iterator = lessonAndProgressModel;
            next4 = true;
            lessonAndProgressModel = 0;
            iterator = next4;
        }
        nextIndex = -1;
        ArrayList arrayList3 = new ArrayList();
        obj11 = obj11.iterator();
        i = lessonAndProgressModel;
        for (Object next5 : obj11) {
            progressModel2 = (LessonAndProgressModel)next5.getProgressModel();
            if (progressModel2 == null) {
            } else {
            }
            if (progressModel2.isPassed() == next4) {
            } else {
            }
            z = lessonAndProgressModel;
            if (!z && i <= nextIndex) {
            } else {
            }
            z2 = lessonAndProgressModel;
            if (z2) {
            }
            i = str;
            arrayList3.add(next5);
            if (i <= nextIndex) {
            } else {
            }
            z2 = next4;
            z = next4;
        }
        obj11 = p.l0(arrayList3);
        if ((LessonAndProgressModel)obj11 == null) {
        } else {
            i2 = (LessonAndProgressModel)obj11.getId();
        }
        if (i2 == 0) {
            i2 = (ProgramModel.LessonModel)p.X((ProgramModel.ModuleModel)p.X(programModel.getModules()).getLessons()).getId();
        }
        return i2;
    }

    private final ProgramLesson.Type u(boolean z, ProgramProgress.LessonProgress programProgress$LessonProgress2, boolean z3, boolean z4) {
        int i;
        ProgramLesson.Type obj3;
        boolean obj4;
        i = 0;
        final int i2 = 1;
        if (!lessonProgress2) {
        } else {
            if (lessonProgress2.isPassed() == i2) {
                i = i2;
            }
        }
        obj3 = i != 0 ? ProgramLesson.Type.COMPLETED : z4 ? ProgramLesson.Type.ACTIVE : z3 ? ProgramLesson.Type.UNLOCKED : z ? ProgramLesson.Type.UNLOCKED : ProgramLesson.Type.LOCKED;
        return obj3;
    }

    private final boolean y(ProgramModel.ModuleModel programModel$ModuleModel) {
        int i;
        int obj2;
        if (obj2 ^= i != 0 && this.c.c0()) {
            if (this.c.c0()) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public final List<ProgramExam> n(String string, String string2, ProgramModel.ModuleModel programModel$ModuleModel3, ProgramProgress.ModuleProgress programProgress$ModuleProgress4) {
        int i;
        Long unlockTimeMs;
        int booleanValue;
        Map exams;
        int hasNewUpdates;
        ProgramProgress.ExamSubmission examSubmission;
        Object obj;
        ProgramExam.Status lOCKED;
        ProgramSaveInfo programSaveInfo;
        Long num;
        int i2;
        n.f(string, "dogId");
        n.f(string2, "programId");
        n.f(moduleModel3, "module");
        List obj10 = moduleModel3.getExams();
        ArrayList obj11 = new ArrayList(p.r(obj10, 10));
        obj10 = obj10.iterator();
        while (obj10.hasNext()) {
            obj = next2;
            unlockTimeMs = 0;
            if (moduleProgress4 == null) {
            } else {
            }
            exams = moduleProgress4.getExams();
            if (exams == null) {
            } else {
            }
            hasNewUpdates = exams.get((TrickModel)obj.getId());
            if (hasNewUpdates == 0) {
            } else {
            }
            examSubmission = hasNewUpdates.getExamSubmission();
            if (hasNewUpdates == 0) {
            } else {
            }
            if (examSubmission == null) {
            } else {
            }
            lOCKED = j1.p0(examSubmission);
            if (hasNewUpdates == 0) {
            } else {
            }
            unlockTimeMs = hasNewUpdates.getUnlockTimeMs();
            booleanValue = 0;
            if (hasNewUpdates != 0) {
            }
            hasNewUpdates = hasNewUpdates.getHasNewUpdates();
            if (hasNewUpdates == 0) {
            } else {
            }
            booleanValue = hasNewUpdates.booleanValue();
            obj11.add(this.j(examSubmission, obj, lOCKED, x(string, string2, moduleModel3.getId()), unlockTimeMs, booleanValue));
            lOCKED = ProgramExam.Status.READY;
            lOCKED = ProgramExam.Status.LOCKED;
            examSubmission = unlockTimeMs;
            hasNewUpdates = unlockTimeMs;
        }
        v2.a obj9 = new v2.a();
        obj10 = new v2.b(obj9);
        return p.D0(obj11, obj10);
    }

    public final Object r(String string, String string2, d<? super ProgramExamList> d3) {
        v2.c cVar = new v2.c(this, string, string2, 0);
        return k.e(this.g, cVar, d3);
    }

    public final Object v(String string, String string2, d<? super ProgramExamList> d3) {
        return r(string, string2, d3);
    }

    public final Object w(String string, d<? super Program> d2) {
        v2.d dVar = new v2.d(this, string, 0);
        return k.e(this.g, dVar, d2);
    }

    public final ProgramSaveInfo x(String string, String string2, String string3) {
        n.f(string, "dogId");
        n.f(string2, "programId");
        n.f(string3, "moduleId");
        ProgramSaveInfo programSaveInfo = new ProgramSaveInfo(string2, string3, "", string);
        return programSaveInfo;
    }
}
