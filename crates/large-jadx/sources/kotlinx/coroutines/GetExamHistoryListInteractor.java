package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.model.trainingprogram.TrickModel;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.s.b.o1;
import app.dogo.com.dogo_android.util.h0.m1;
import app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.z.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: GetExamHistoryListInteractor.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J/\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J,\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000c\u001a\u00020\r2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00130\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetExamHistoryListInteractor;", "", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getExamHistoryList", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "dogId", "", "programId", "trickId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSortedProgramExams", "examModels", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "trickModel", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "setupRetakableExams", "examItems", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n2, reason: from kotlin metadata */
public final class GetExamHistoryListInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final o1 dispatcher;
    /* renamed from: b, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.s.b.j1 programRepository;
    /* renamed from: c, reason: from kotlin metadata */
    private final h0 tricksRepository;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 5, 1})
    public static final class b<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.c(Long.valueOf(t2.getTimestamp()), Long.valueOf(t.getTimestamp()));
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetExamHistoryListInteractor$getExamHistoryList$2", f = "GetExamHistoryListInteractor.kt", l = {22, 23}, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super List<? extends ProgramExam>>, Object> {

        final /* synthetic */ String $dogId;
        final /* synthetic */ String $programId;
        final /* synthetic */ String $trickId;
        Object L$0;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            e.a.a.a.b.d.g gVar;
            List list;
            Object object2;
            Object obj2 = b.d();
            int i2 = 2;
            int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    if (this.label != i2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(object);
                        return n2.this.g(n2.this.getExamHistoryList(this.$dogId, (List)list, app.dogo.com.dogo_android.util.extensionfunction.m1.toTrickItem(gVar)));
                    }
                }
                q.b(object);
            } else {
                q.b(object);
                this.label = i;
                if (n2.this.dispatcher.o(this.$trickId, this) == obj2) {
                    return obj2;
                }
            }
            this.L$0 = object2;
            this.label = i2;
            Object obj = n2.this.programRepository.t(this.$dogId, this.$programId, this.$trickId, this);
            if (obj == obj2) {
                return obj2;
            }
        }

        a(String str, String str2, String str3, d<? super n2.a> dVar) {
            this.$trickId = str;
            this.$dogId = str2;
            this.$programId = str3;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super List<ProgramExam>> dVar) {
            return (kotlinx.coroutines.n2.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            kotlinx.coroutines.n2.a object2 = new kotlinx.coroutines.n2.a(n2.this, this.$trickId, this.$dogId, this.$programId, dVar);
            return object2;
        }
    }
    public n2(o1 o1Var, app.dogo.com.dogo_android.s.b.j1 j1Var, h0 h0Var) {
        n.f(o1Var, "tricksRepository");
        n.f(j1Var, "programRepository");
        n.f(h0Var, "dispatcher");
        super();
        this.dispatcher = o1Var;
        this.programRepository = j1Var;
        this.tricksRepository = h0Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    public static final /* synthetic */ app.dogo.com.dogo_android.s.b.j1 setupRetakableExams(n2 examItems) {
        return examItems.programRepository;
    }

    public static final /* synthetic */ List b(n2 n2Var, String str, List list, TrickModel trickModel) {
        return n2Var.getExamHistoryList(str, list, trickModel);
    }

    public static final /* synthetic */ o1 c(n2 n2Var) {
        return n2Var.dispatcher;
    }

    public static final /* synthetic */ List d(n2 n2Var, List list) {
        return n2Var.g(list);
    }

    /* renamed from: f, reason: from kotlin metadata */
    /* suspend */ private final List<ProgramExam> getExamHistoryList(String dogId, List<ProgramProgress.ExamSubmission> programId, TrickModel trickId) {
        String videoThumbnailUrl;
        int value = 30;
        Long reviewTimeMs = null;
        long value2 = 0;
        long l2;
        Boolean bool;
        ArrayList arrayList = new ArrayList(p.r(programId, 10));
        Iterator it = programId.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            ProgramExam.Status status = app.dogo.com.dogo_android.util.extensionfunction.j1.p0(item);
            videoThumbnailUrl = "";
            String dogId2 = dogId;
            ProgramSaveInfo programSaveInfo = new ProgramSaveInfo(videoThumbnailUrl, videoThumbnailUrl, videoThumbnailUrl, dogId2);
            videoThumbnailUrl = item.getVideoUrl();
            String r8 = videoThumbnailUrl;
            videoThumbnailUrl = item.getVideoThumbnailUrl();
            String r10 = videoThumbnailUrl;
            Long uploadTimeMs = item.getUploadTimeMs();
            Long reviewTimeMs2 = item.getReviewTimeMs();
            long max = Math.max(value2, value2);
            videoThumbnailUrl = item.getReviewComment();
            String r14 = videoThumbnailUrl;
            videoThumbnailUrl = trickId.getExamInstructions();
            String r15 = videoThumbnailUrl;
            Integer examTimeLimit = trickId.getExamTimeLimit();
            videoThumbnailUrl = item.getEvaluatedByAvatar();
            String r23 = videoThumbnailUrl;
            videoThumbnailUrl = item.getEvaluatedByName();
            String r26 = videoThumbnailUrl;
            Long l = null;
            String str2 = null;
            g gVar = null;
            int i3 = 2109440;
            int i4 = 0;
            ProgramExam programExam = new ProgramExam(programSaveInfo, str, image, videoThumbnailUrl, videoThumbnailUrl, status, name, max, max, videoThumbnailUrl, videoThumbnailUrl, value, item.getTimestamp(), bool2, l, str2, item.getUnlockTimeMs(), videoThumbnailUrl, videoThumbnailUrl, reviewTimeMs, item.getExamId(), item.getEvaluatedByEmail(), item.getUserFeedbackSubmitted(), gVar, i3, i4);
            arrayList.add(programExam);
        }
        return p.D0(arrayList, new kotlinx.coroutines.n2.b());
    }

    private final List<ProgramExam> g(List<ProgramExam> list) {
        Iterable list2;
        Object item;
        int i;
        long timestamp;
        boolean hasNext;
        Object item2;
        String str;
        int cmp;
        String str2;
        String str3;
        ProgramExam.Status status;
        String str4;
        String str5;
        String str6;
        int i2;
        long l;
        Boolean bool;
        Long l2;
        String str7;
        String str8;
        Long l3;
        String str9;
        String str10;
        boolean z;
        Boolean bool2;
        Boolean tRUE2;
        Object obj;
        int i3;
        Iterator it = list.iterator();
        i = 0;
        if (!it.hasNext()) {
        } else {
            if (it.hasNext()) {
                timestamp = (ProgramExam)item.getTimestamp();
                item = it.next();
                timestamp = (ProgramExam)item.getTimestamp();
                while (timestamp < timestamp) {
                }
            }
        }
        if (i != 0) {
            ProgramExam.Status status2 = i.getStatus();
        }
        if (i == ProgramExam_Status.REJECTED) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                new ArrayList(p.r(list, 10)).add(item2);
            }
        } else {
        }
        return list2;
    }

    public final Object e(String str, String str2, String str3, d<? super List<ProgramExam>> dVar) {
        kotlinx.coroutines.n2.a aVar = new kotlinx.coroutines.n2.a(this, str3, str, str2, null);
        return kotlinx.coroutines.internal.k.e(this.tricksRepository, aVar, dVar);
    }

    public /* synthetic */ n2(o1 o1Var, app.dogo.com.dogo_android.s.b.j1 j1Var, h0 h0Var, int i, g gVar) {
        if (i & 4 != 0) {
            h0Var = Dispatchers.b();
        }
        this(o1Var, j1Var, h0Var);
    }
}
