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
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
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
import kotlin.b0.k.a.f;
import kotlin.d0.d.e0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.z.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: GetProgramLessonsListInteractor.kt */
@Metadata(d1 = "\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010JA\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002¢\u0006\u0002\u0010\u001fJ*\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0002JH\u0010)\u001a\u0008\u0012\u0004\u0012\u00020+0*2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/2\u0008\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002J*\u00105\u001a\u00020+2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u0010.\u001a\u00020/2\u0008\u00100\u001a\u0004\u0018\u000101H\u0002J.\u00106\u001a\u0008\u0012\u0004\u0012\u00020\u00120*2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u0010.\u001a\u00020/2\u0008\u00100\u001a\u0004\u0018\u000101J \u00107\u001a\u00020+2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u00108\u001a\u00020/H\u0002J8\u00109\u001a\u00020+2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001e2\u0006\u00108\u001a\u00020/2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=H\u0002JH\u0010>\u001a\u0008\u0012\u0004\u0012\u00020+0*2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/2\u0008\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u000203H\u0002J!\u0010?\u001a\u00020@2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AJ@\u0010B\u001a\u0008\u0012\u0004\u0012\u00020+0*2\u0006\u0010\"\u001a\u00020#2\u0006\u0010-\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0008\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010C\u001a\u00020#H\u0002J\u001a\u0010D\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0002J*\u0010E\u001a\u00020=2\u0006\u0010-\u001a\u00020\u001e2\u0008\u0010'\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020\u001e2\u0006\u0010H\u001a\u00020\u001eH\u0002J!\u0010I\u001a\u00020@2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010AJ\u0019\u0010J\u001a\u00020K2\u0006\u0010,\u001a\u00020#H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010LJ\u001e\u0010M\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\u0006\u0010,\u001a\u00020#2\u0006\u0010N\u001a\u00020#J\u0010\u0010O\u001a\u00020\u001e2\u0006\u00108\u001a\u00020/H\u0002R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006P", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetProgramLessonsListInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "premiumContentLockInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/PremiumContentLockInteractor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/interactor/PremiumContentLockInteractor;Lkotlinx/coroutines/CoroutineDispatcher;)V", "buildExamData", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "examSubmission", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "trickModel", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "examStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;", "programSaveInfo", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "unlockDate", "", "hasNewUpdates", "", "(Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;Lapp/dogo/com/dogo_android/repository/domain/ProgramExam$Status;Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;Ljava/lang/Long;Z)Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "buildExamItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamSummary;", "dogId", "", "lessonId", "program", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "progress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "buildLessonItems", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson;", "programId", "isDogPremium", "module", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$ModuleModel;", "moduleProgress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ModuleProgress;", "activeLessonIndex", "", "activeLessonModuleIndex", "buildModuleExam", "buildModuleExamList", "buildModuleHeader", "moduleModel", "buildModuleLesson", "lessonModel", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel$LessonModel;", "lessonCompletionStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramLesson$Type;", "buildModuleLessonItems", "buildProgramExamListItem", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamList;", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buildProgramLessonList", "activeLessonId", "findActiveLessonId", "findLessonStatus", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$LessonProgress;", "isLessonUnlocked", "isLessonActive", "getProgramExamList", "getProgramLessonsList", "Lapp/dogo/com/dogo_android/repository/domain/Program;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProgramSaveInfo", "moduleId", "isExamAvailable", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: v2, reason: from kotlin metadata */
public final class GetProgramLessonsListInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final p1 dispatcher;
    /* renamed from: b, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.s.b.j1 isDogPremiumInteractor;
    /* renamed from: c, reason: from kotlin metadata */
    private final r2 preferenceService;
    /* renamed from: d, reason: from kotlin metadata */
    private final d3 premiumContentLockInteractor;
    /* renamed from: e, reason: from kotlin metadata */
    private final p2 programRepository;
    /* renamed from: f, reason: from kotlin metadata */
    private final i3 remoteConfigService;
    /* renamed from: g, reason: from kotlin metadata */
    private final h0 userRepository;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 5, 1})
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.c(Integer.valueOf(app.dogo.com.dogo_android.util.extensionfunction.j1.flatMapNotNull(t2)), Integer.valueOf(app.dogo.com.dogo_android.util.extensionfunction.j1.flatMapNotNull(t)));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 5, 1})
    public static final class b<T> implements Comparator {

        final /* synthetic */ Comparator a;
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare;
            if (this.a.compare(t, t2) == 0) {
                compare = a.c(Long.valueOf(t.getOrderDate()), Long.valueOf(t2.getOrderDate()));
            }
            return compare;
        }

        public b(Comparator comparator) {
            this.a = comparator;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExamList;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetProgramLessonsListInteractor$buildProgramExamListItem$2", f = "GetProgramLessonsListInteractor.kt", l = 208, m = "invokeSuspend")
    static final class c extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super ProgramExamList>, Object> {

        final /* synthetic */ String $dogId;
        final /* synthetic */ String $programId;
        Object L$0;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object object2;
            List lessonStatus;
            boolean booleanValue;
            Iterator it;
            ProgramProgress programProgress;
            ProgramProgress.ModuleProgress item;
            String str;
            Object obj3;
            boolean booleanValue2;
            String str2;
            Object obj;
            Object obj2 = b.d();
            int i = 1;
            str = null;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    Object blockingGet = v2.this.dispatcher.z(this.$dogId).blockingGet();
                    final ArrayList arrayList = new ArrayList();
                    Iterator it2 = obj.a().getModules().iterator();
                    String str5 = "isDogPremium";
                    while (it2.hasNext()) {
                        Object item2 = it2.next();
                        programProgress = obj.c();
                        String r11 = str;
                        n.e(object2, str5);
                        p.y(arrayList, lessonStatus);
                    }
                    n.e(blockingGet, "dogProfile");
                    n.e(object2, str5);
                    return new ProgramExamList(arrayList, v2.this.buildExamItem(this.$dogId, v2.this.buildProgramExamListItem(obj.a(), obj.c()), obj.a(), obj.c()), blockingGet, object2.booleanValue());
                }
            }
            q.b(object);
            object2 = IsDogPremiumInteractor.b(v2.this.premiumContentLockInteractor, str, i, str).blockingGet();
            this.L$0 = object2;
            this.label = i;
            obj = v2.this.isDogPremiumInteractor.r(this.$dogId, this.$programId, this);
            if (obj == obj2) {
                return obj2;
            }
        }

        c(String str, String str2, d<? super v2.c> dVar) {
            this.$dogId = str;
            this.$programId = str2;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super ProgramExamList> dVar) {
            return (kotlinx.coroutines.v2.c)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.v2.c(v2.this, this.$dogId, this.$programId, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/Program;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetProgramLessonsListInteractor$getProgramLessonsList$2", f = "GetProgramLessonsListInteractor.kt", l = {35, 37}, m = "invokeSuspend")
    static final class d extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super Program>, Object> {

        final /* synthetic */ String $programId;
        Object L$0;
        Object L$1;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object blockingGet;
            String str;
            Object object2;
            int i;
            boolean z2;
            boolean booleanValue;
            ProgramModel programModel;
            boolean z3;
            final Object object3 = this;
            Object obj = b.d();
            int i2 = 2;
            i = 1;
            if (object3.label != 0) {
                if (object3.label != i) {
                    if (object3.label != i2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(object);
                        object2 = object;
                        final String moduleHeader = object3.this$0.buildProgramExamListItem(object2.a(), object2.c());
                        n.e(blockingGet, "isDogPremium");
                        List lessonItems = object3.this$0.buildProgramLessonList(str, blockingGet.booleanValue(), object3.$programId, object2.a(), object2.c(), moduleHeader);
                        empty = lessonItems instanceof Collection;
                        i = 0;
                        int r6 = i;
                        if (i != 0) {
                            object3.this$0.programRepository.f1(true);
                        }
                        int r18 = i;
                        Program program = new Program(object2.a().getName(), object2.a().getDescription(), object2.a().getCertificatePaperImage(), lessonItems, i, object3.this$0.buildExamItem(str, moduleHeader, object2.a(), object2.c()));
                        return program;
                    }
                }
                q.b(object);
                object2 = object;
            } else {
                q.b(object);
                object3.label = i;
                if (object3.this$0.dispatcher.u(object3) == obj) {
                    return obj;
                }
            }
            blockingGet = object3.this$0.premiumContentLockInteractor.a(str).blockingGet();
            object3.L$0 = str;
            object3.L$1 = blockingGet;
            object3.label = i2;
            if (object3.this$0.isDogPremiumInteractor.r(str, object3.$programId, object3) == obj) {
                return obj;
            }
        }

        d(String str, d<? super v2.d> dVar) {
            this.$programId = str;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super Program> dVar) {
            return (kotlinx.coroutines.v2.d)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.v2.d(v2.this, this.$programId, dVar);
        }
    }
    public v2(p1 p1Var, app.dogo.com.dogo_android.s.b.j1 j1Var, r2 r2Var, d3 d3Var, p2 p2Var, i3 i3Var, h0 h0Var) {
        n.f(p1Var, "userRepository");
        n.f(j1Var, "programRepository");
        n.f(r2Var, "remoteConfigService");
        n.f(d3Var, "isDogPremiumInteractor");
        n.f(p2Var, "preferenceService");
        n.f(i3Var, "premiumContentLockInteractor");
        n.f(h0Var, "dispatcher");
        super();
        this.dispatcher = p1Var;
        this.isDogPremiumInteractor = j1Var;
        this.preferenceService = r2Var;
        this.premiumContentLockInteractor = d3Var;
        this.programRepository = p2Var;
        this.remoteConfigService = i3Var;
        this.userRepository = h0Var;
    }

    public static final /* synthetic */ ProgramExamSummary a(v2 v2Var, String str, String str2, ProgramModel programModel, ProgramProgress programProgress) {
        return v2Var.buildExamItem(str, str2, programModel, programProgress);
    }

    /* renamed from: b, reason: from kotlin metadata */
    public static final /* synthetic */ List buildLessonItems(v2 dogId, String programId, boolean isDogPremium, String module, ProgramModel moduleProgress, ProgramProgress activeLessonIndex, String activeLessonModuleIndex) {
        return dogId.buildProgramLessonList(programId, isDogPremium, module, moduleProgress, activeLessonIndex, activeLessonModuleIndex);
    }

    /* renamed from: c, reason: from kotlin metadata */
    public static final /* synthetic */ String buildModuleHeader(v2 dogId, ProgramModel programId, ProgramProgress moduleModel) {
        return dogId.buildProgramExamListItem(programId, moduleModel);
    }

    /* renamed from: d, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ p2 getProgramLessonsList(v2 programId) {
        return programId.programRepository;
    }

    /* renamed from: e, reason: from kotlin metadata */
    public static final /* synthetic */ i3 isExamAvailable(v2 moduleModel) {
        return moduleModel.remoteConfigService;
    }

    public static final /* synthetic */ app.dogo.com.dogo_android.s.b.j1 f(v2 v2Var) {
        return v2Var.isDogPremiumInteractor;
    }

    public static final /* synthetic */ r2 g(v2 v2Var) {
        return v2Var.preferenceService;
    }

    public static final /* synthetic */ p1 h(v2 v2Var) {
        return v2Var.dispatcher;
    }

    public static final /* synthetic */ d3 i(v2 v2Var) {
        return v2Var.premiumContentLockInteractor;
    }

    /* renamed from: j, reason: from kotlin metadata */
    private final ProgramExam buildExamData(ProgramProgress.ExamSubmission examSubmission, TrickModel trickModel, ProgramExam.Status examStatus, ProgramSaveInfo programSaveInfo, Long unlockDate, boolean hasNewUpdates) {
        int i = 0;
        int value = 30;
        boolean z = false;
        Boolean tRUE2;
        long value2;
        int i2 = 0;
        String videoThumbnailUrl;
        String videoThumbnailUrl2;
        String reviewComment;
        int i4;
        Object evaluatedByAvatar;
        i = 0;
        int r2 = examSubmission == null ? 0 : i;
        if (examSubmission != null) {
            Long reviewTimeMs = examSubmission.getReviewTimeMs();
            if (reviewTimeMs != null) {
                long value3 = reviewTimeMs.longValue();
            }
        }
        i2 = 0;
        if (examSubmission == null) {
        } else {
            videoThumbnailUrl = examSubmission.getVideoThumbnailUrl();
        }
        if (videoThumbnailUrl == null) {
            videoThumbnailUrl2 = trickModel.getImage();
        } else {
            videoThumbnailUrl2 = examSubmission.getVideoThumbnailUrl();
        }
        if (examSubmission == null) {
        } else {
            reviewComment = examSubmission.getVideoUrl();
        }
        reviewComment = "";
        reviewComment = reviewComment == null ? reviewComment : reviewComment;
        String r16 = reviewComment;
        String examInstructions = trickModel.getExamInstructions();
        String r17 = examInstructions == null ? reviewComment : examInstructions;
        Integer examTimeLimit = trickModel.getExamTimeLimit();
        if (examTimeLimit == null) {
            value = 30;
        } else {
            value = examTimeLimit.intValue();
        }
        if (examSubmission == null) {
            int i3 = 0;
        } else {
            z = n.b(examSubmission.getHasNewFeedback(), Boolean.TRUE);
        }
        String r24 = reviewComment;
        String r25 = reviewComment;
        if (examSubmission != null) {
            Long reviewTimeMs2 = examSubmission.getReviewTimeMs();
        }
        ProgramExam programExam = new ProgramExam(programSaveInfo, trickModel.getId(), trickModel.getImage(), reviewComment, videoThumbnailUrl2, examStatus, trickModel.getName(), Math.max(value2, l, i, obj), str, reviewComment, i4, value, null, bool, Boolean.valueOf(z), Boolean.valueOf(hasNewUpdates), unlockDate, evaluatedByAvatar, reviewComment, i2, false, null, 0, null, 3934208, 0);
        return programExam;
    }

    /* renamed from: k, reason: from kotlin metadata */
    private final ProgramExamSummary buildExamItem(String dogId, String lessonId, ProgramModel program, ProgramProgress progress) {
        int i;
        int i2;
        Object lessonId2;
        boolean z;
        boolean z2;
        ProgramProgress.ModuleProgress item6;
        boolean z3;
        String str;
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
            int r10 = i;
            p.y(arrayList2, this.findLessonStatus(dogId2, program.getId(), item7, i));
        }
        ArrayList arrayList = new ArrayList();
        Iterator item3 = arrayList2.iterator();
        while (item3.hasNext()) {
            Object item5 = item3.next();
            int r9 = i2;
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it4 = arrayList2.iterator();
        while (it4.hasNext()) {
            item3 = it4.next();
        }
        ProgramExamSummary programExamSummary = new ProgramExamSummary(new ProgramSaveInfo(program.getId(), i.getId(), lessonId2.getId(), dogId2), Integer.valueOf(arrayList2.size()), Integer.valueOf(arrayList.size()), Integer.valueOf(arrayList3.size()), program.getCardBackgroundColor(), program.getCertificateLaurelsImage(), program.getCertificatePaperImage(), program.getCertificatePlaceholderImage(), program.getName(), program.getCertificateRequirements());
        return programExamSummary;
    }

    /* renamed from: l, reason: from kotlin metadata */
    private final List<ProgramLesson> buildModuleLessonItems(String dogId, String programId, boolean isDogPremium, ProgramModel.ModuleModel module, ProgramProgress.ModuleProgress moduleProgress, int activeLessonIndex, int activeLessonModuleIndex) {
        int i;
        boolean z;
        ProgramProgress.LessonProgress lessonProgress = null;
        boolean z2 = true;
        final int activeLessonIndex2 = activeLessonIndex;
        final int activeLessonModuleIndex2 = activeLessonModuleIndex;
        List lessons = module.getLessons();
        final ArrayList arrayList = new ArrayList(p.r(lessons, 10));
        Iterator it = lessons.iterator();
        i = 0;
        while (it.hasNext()) {
            i = i + 1;
            if (i < 0) {
                p.q();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) 0;
            }
        }
        return arrayList;
    }

    /* renamed from: m, reason: from kotlin metadata */
    private final ProgramLesson buildModuleExam(String dogId, String programId, ProgramModel.ModuleModel module, ProgramProgress.ModuleProgress moduleProgress) {
        ProgramLesson dogId2 = new ProgramLesson(new ProgramSaveInfo(programId, module.getId(), "", dogId), 0, null, ProgramLesson_Type.EXAM, false, false, findLessonStatus(dogId, programId, module, moduleProgress), false, 182, null);
        return dogId2;
    }

    /* renamed from: o, reason: from kotlin metadata */
    private final ProgramLesson getProgramSaveInfo(String dogId, String programId, ProgramModel.ModuleModel moduleId) {
        ProgramLesson programLesson = new ProgramLesson(new ProgramSaveInfo(programId, moduleId.getId(), "", dogId), moduleId.getIndex() + 1, moduleId.getName(), ProgramLesson_Type.HEADER, false, false, null, false, 240, null);
        return programLesson;
    }

    /* renamed from: p, reason: from kotlin metadata */
    private final ProgramLesson buildModuleLesson(String dogId, String programId, boolean isDogPremium, ProgramModel.ModuleModel moduleModel, ProgramModel.LessonModel lessonModel, ProgramLesson.Type lessonCompletionStatus) {
        ProgramLesson.Type aCTIVE2;
        int i;
        ProgramLesson.Type lessonCompletionStatus2 = lessonCompletionStatus;
        i = 1;
        Map tricks = lessonModel.getTricks();
        ArrayList arrayList = new ArrayList(tricks.size());
        Iterator it = tricks.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((TrickModel)(Map.Entry)it.next().getValue().getName());
        }
        i = 0;
        if (lessonCompletionStatus2 == ProgramLesson_Type.ACTIVE || lessonCompletionStatus2 == ProgramLesson_Type.UNLOCKED) {
        }
        int r8 = i;
        int r10 = i;
        ProgramLesson programLesson = new ProgramLesson(new ProgramSaveInfo(programId, moduleModel.getId(), lessonModel.getId(), dogId), lessonModel.getIndex() + 1, p.h0(arrayList, " , ", null, null, 0, null, null, 62, null), lessonCompletionStatus, i, i, null, i, 64, i);
        return programLesson;
    }

    private final List<ProgramLesson> q(String str, String str2, boolean z, ProgramModel.ModuleModel moduleModel, ProgramProgress.ModuleProgress moduleProgress, int i, int i2) {
        List list;
        final ProgramLesson programSaveInfo = getProgramSaveInfo(str, str2, moduleModel);
        List moduleLessonItems = buildModuleLessonItems(str, str2, z, moduleModel, moduleProgress, i, i2);
        final String str3 = "null cannot be cast to non-null type kotlin.Array<T>";
        i = 0;
        if (y(moduleModel)) {
            e0 e0Var = new e0(3);
            e0Var.a(programSaveInfo);
            Object[] array = moduleLessonItems.toArray(new ProgramLesson[i]);
            Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
            e0Var.b(array);
            e0Var.a(buildModuleExam(str, str2, moduleModel, moduleProgress));
            list = p.j(e0Var.d(new ProgramLesson[e0Var.c()]));
        } else {
            e0 e0Var2 = new e0(2);
            e0Var2.a(programSaveInfo);
            Object[] array2 = moduleLessonItems.toArray(new ProgramLesson[i]);
            Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
            e0Var2.b(array2);
            list = p.j(e0Var2.d(new ProgramLesson[e0Var2.c()]));
        }
        return list;
    }

    /* renamed from: s, reason: from kotlin metadata */
    private final List<ProgramLesson> buildProgramLessonList(String dogId, boolean isDogPremium, String programId, ProgramModel program, ProgramProgress progress, String activeLessonId) {
        int index;
        int i;
        Object item2;
        Object item3;
        boolean z;
        boolean z2;
        ProgramProgress.ModuleProgress moduleProgress;
        Object activeLessonId2 = activeLessonId;
        Iterator it = program.getModules().iterator();
        index = 0;
        i = 0;
        while (it.hasNext()) {
            Iterator it4 = (ProgramModel_ModuleModel)item.getLessons().iterator();
            while (it4.hasNext()) {
                if (n.b((ProgramModel_LessonModel)item4.getId(), activeLessonId2)) {
                    break loop_3;
                }
            }
            int r5 = i != 0 ? 1 : index;
            if (index != 0) {
                break;
            }
        }
        if (i == 0) {
        } else {
            index = i.getIndex();
        }
        Iterator it2 = (ProgramModel_ModuleModel)program.getModules().get(index).getLessons().iterator();
        while (it2.hasNext()) {
            if (n.b((ProgramModel_LessonModel)item2.getId(), activeLessonId2)) {
                break;
            }
        }
        if (item2 == null) {
        } else {
            index = item2.getIndex();
        }
        List modules3 = program.getModules();
        final ArrayList arrayList = new ArrayList(p.r(modules3, 10));
        Iterator it3 = modules3.iterator();
        while (it3.hasNext()) {
            index = index + 1;
            if (index < 0) {
                p.q();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            }
        }
        return p.u(arrayList);
    }

    /* renamed from: t, reason: from kotlin metadata */
    /* suspend */ private final String buildProgramExamListItem(ProgramModel dogId, ProgramProgress programId) {
        int i = 0;
        ArrayList arrayList;
        int nextIndex = -1;
        Iterator it;
        LessonAndProgressModel lessonAndProgressModel;
        ProgramProgress.LessonProgress item;
        boolean hasNext2;
        boolean z;
        String str;
        List modules;
        i = 0;
        int r1 = i;
        if (arrayList == null) {
            List list2 = p.g();
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it5 = dogId.getModules().iterator();
        while (it5.hasNext()) {
            p.y(arrayList2, (ProgramModel_ModuleModel)it5.next().getLessons());
        }
        ArrayList arrayList4 = new ArrayList(p.r(arrayList2, 10));
        it = arrayList2.iterator();
        while (it.hasNext()) {
            Object item4 = it.next();
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                if (n.b((ProgramProgress_LessonProgress)item.getId(), item4.getId())) {
                    break loop_17;
                }
            }
            arrayList4.add(new LessonAndProgressModel(item4, (ProgramProgress_LessonProgress)item));
        }
        ListIterator it3 = arrayList4.listIterator(arrayList4.size());
        hasNext2 = true;
        lessonAndProgressModel = null;
        while (it3.hasPrevious()) {
            ProgramProgress.LessonProgress progressModel = (LessonAndProgressModel)it3.previous().getProgressModel();
            LessonAndProgressModel r2 = lessonAndProgressModel;
            if (it != null) {
                break;
            }
        }
        nextIndex = -1;
        ArrayList arrayList3 = new ArrayList();
        Iterator it6 = arrayList4.iterator();
        while (it6.hasNext()) {
            Object item2 = it6.next();
            if (lessonAndProgressModel < 0) {
                p.q();
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            }
        }
        Object obj3 = p.l0(arrayList3);
        if (obj3 != null) {
            String id2 = obj3.getId();
        }
        if (i == 0) {
            String id = (ProgramModel_LessonModel)p.X((ProgramModel_ModuleModel)p.X(dogId.getModules()).getLessons()).getId();
        }
        return i;
    }

    /* renamed from: u, reason: from kotlin metadata */
    private final ProgramLesson.Type buildModuleExamList(boolean dogId, ProgramProgress.LessonProgress programId, boolean module, boolean moduleProgress) {
        int i = 0;
        ProgramLesson.Type aCTIVE2;
        i = 0;
        i = 1;
        if (programId != null) {
            if (programId.isPassed()) {
            }
        }
        if (i != 0) {
            aCTIVE2 = ProgramLesson_Type.COMPLETED;
        } else {
            if (moduleProgress) {
                aCTIVE2 = ProgramLesson_Type.ACTIVE;
            } else {
                if (module) {
                    aCTIVE2 = ProgramLesson_Type.UNLOCKED;
                } else {
                    dogId = dogId ? ProgramLesson_Type.UNLOCKED : ProgramLesson_Type.LOCKED;
                }
            }
        }
        return (dogId ? ProgramLesson_Type.UNLOCKED : ProgramLesson_Type.LOCKED);
    }

    private final boolean y(ProgramModel.ModuleModel moduleModel) {
        boolean z = false;
        int i;
        i = moduleModel.getExams().isEmpty() ^ 1;
        if (moduleModel.getExams().isEmpty() ^ 1) {
            if (!(this.preferenceService.c0())) {
                int i3 = 0;
            }
        }
        return z;
    }

    /* renamed from: n, reason: from kotlin metadata */
    public final List<ProgramExam> findLessonStatus(String isDogPremium, String progress, ProgramModel.ModuleModel isLessonUnlocked, ProgramProgress.ModuleProgress isLessonActive) {
        Long unlockTimeMs = null;
        int i3 = 0;
        Map exams;
        int i2;
        ProgramProgress.ExamSubmission examSubmission;
        ProgramExam.Status lOCKED2;
        n.f(isDogPremium, "dogId");
        n.f(progress, "programId");
        n.f(isLessonUnlocked, "module");
        List exams2 = isLessonUnlocked.getExams();
        final ArrayList arrayList = new ArrayList(p.r(exams2, 10));
        Iterator it = exams2.iterator();
        while (it.hasNext()) {
            trickModel = it.next();
            i2 = 0;
            int r1 = i2;
            i3 = 0;
            arrayList.add(this.buildExamData(examSubmission, trickModel, lOCKED2, isDogPremium2, unlockTimeMs, i3));
        }
        return p.D0(arrayList, new kotlinx.coroutines.v2.b(new kotlinx.coroutines.v2.a()));
    }

    public final Object r(String str, String str2, d<? super ProgramExamList> dVar) {
        return kotlinx.coroutines.internal.k.e(this.userRepository, new kotlinx.coroutines.v2.c(this, str, str2, null), dVar);
    }

    public final Object v(String str, String str2, d<? super ProgramExamList> dVar) {
        return r(str, str2, dVar);
    }

    /* renamed from: w, reason: from kotlin metadata */
    public final Object findActiveLessonId(String program, d<? super Program> progress) {
        return kotlinx.coroutines.internal.k.e(this.userRepository, new kotlinx.coroutines.v2.d(this, program, null), progress);
    }

    public final ProgramSaveInfo x(String str, String str2, String str3) {
        n.f(str, "dogId");
        n.f(str2, "programId");
        n.f(str3, "moduleId");
        return new ProgramSaveInfo(str2, str3, "", str);
    }

    public /* synthetic */ v2(p1 p1Var, app.dogo.com.dogo_android.s.b.j1 j1Var, r2 r2Var, d3 d3Var, p2 p2Var, i3 i3Var, h0 h0Var, int i, g gVar) {
        h0 h0Var72;
        h0Var72 = i & 64 != 0 ? h0Var72 : h0Var;
        this(p1Var, j1Var, r2Var, d3Var, p2Var, i3Var, h0Var72);
    }
}
