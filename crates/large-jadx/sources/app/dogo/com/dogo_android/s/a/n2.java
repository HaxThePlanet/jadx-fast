package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.model.trainingprogram.TrickModel;
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.repository.domain.ProgramExam.Status;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.o1;
import app.dogo.com.dogo_android.util.h0.j1;
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
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
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
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J/\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J,\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u000c\u001a\u00020\r2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00130\n2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u000c\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0018", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetExamHistoryListInteractor;", "", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getExamHistoryList", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "dogId", "", "programId", "trickId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSortedProgramExams", "examModels", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "trickModel", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "setupRetakableExams", "examItems", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class n2 {

    private final o1 a;
    private final j1 b;
    private final h0 c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 5, 1})
    public static final class b implements Comparator {
        public final int compare(T t, T t2) {
            return a.c(Long.valueOf((ProgramExam)t2.getTimestamp()), Long.valueOf((ProgramExam)t.getTimestamp()));
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramExam;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetExamHistoryListInteractor$getExamHistoryList$2", f = "GetExamHistoryListInteractor.kt", l = {22, 23}, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super List<? extends ProgramExam>>, Object> {

        final String $dogId;
        final String $programId;
        final String $trickId;
        Object L$0;
        int label;
        final app.dogo.com.dogo_android.s.a.n2 this$0;
        a(app.dogo.com.dogo_android.s.a.n2 n2, String string2, String string3, String string4, d<? super app.dogo.com.dogo_android.s.a.n2.a> d5) {
            this.this$0 = n2;
            this.$trickId = string2;
            this.$dogId = string3;
            this.$programId = string4;
            super(2, d5);
        }

        public final Object c(m0 m0, d<? super List<ProgramExam>> d2) {
            return (n2.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            super(this.this$0, this.$trickId, this.$dogId, this.$programId, d2);
            return obj7;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$0;
            int $trickId;
            int $dogId;
            String $programId;
            String $trickId2;
            Object obj7;
            Object obj = b.d();
            $trickId = this.label;
            int i = 2;
            $dogId = 1;
            if ($trickId != 0) {
                if ($trickId != $dogId) {
                    if ($trickId != i) {
                    } else {
                        l$0 = this.L$0;
                        q.b(object);
                        return n2.d(this.this$0, n2.b(this.this$0, this.$dogId, (List)obj7, m1.H(l$0)));
                    }
                    obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj7;
                }
                q.b(object);
            } else {
                q.b(object);
                this.label = $dogId;
                if (n2.c(this.this$0).o(this.$trickId, this) == obj) {
                    return obj;
                }
            }
            this.L$0 = (g)obj7;
            this.label = i;
            $trickId = n2.a(this.this$0).t(this.$dogId, this.$programId, this.$trickId, this);
            if ($trickId == obj) {
                return obj;
            }
            l$0 = obj7;
            obj7 = $trickId;
        }
    }
    public n2(o1 o1, j1 j12, h0 h03) {
        n.f(o1, "tricksRepository");
        n.f(j12, "programRepository");
        n.f(h03, "dispatcher");
        super();
        this.a = o1;
        this.b = j12;
        this.c = h03;
    }

    public n2(o1 o1, j1 j12, h0 h03, int i4, g g5) {
        h0 obj3;
        if (i4 &= 4 != 0) {
            obj3 = c1.b();
        }
        super(o1, j12, obj3);
    }

    public static final j1 a(app.dogo.com.dogo_android.s.a.n2 n2) {
        return n2.b;
    }

    public static final List b(app.dogo.com.dogo_android.s.a.n2 n2, String string2, List list3, TrickModel trickModel4) {
        return n2.f(string2, list3, trickModel4);
    }

    public static final o1 c(app.dogo.com.dogo_android.s.a.n2 n2) {
        return n2.a;
    }

    public static final List d(app.dogo.com.dogo_android.s.a.n2 n2, List list2) {
        return n2.g(list2);
    }

    private final List<ProgramExam> f(String string, List<ProgramProgress.ExamSubmission> list2, TrickModel trickModel3) {
        Iterable programExam;
        Iterable iterable;
        String programId;
        int intValue;
        Long reviewTimeMs;
        ProgramSaveInfo programSaveInfo;
        String str8;
        String str6;
        String moduleId;
        String str2;
        String str11;
        String str3;
        ProgramExam.Status status;
        String str5;
        String str7;
        long l3;
        long l5;
        long l;
        long l4;
        String str14;
        long l2;
        String str10;
        int i6;
        String str4;
        long longValue;
        int i2;
        int i;
        Long num3;
        String str9;
        String str13;
        Long num;
        String str12;
        String examId;
        String evaluatedByEmail;
        boolean z;
        String str;
        int i4;
        int i3;
        int i5;
        boolean userFeedbackSubmitted;
        Long num2;
        ArrayList arrayList = new ArrayList(p.r(list2, 10));
        Iterator iterator = list2.iterator();
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            status = j1.p0((ProgramProgress.ExamSubmission)next2);
            String str15 = "";
            if (next2.getProgramId() == null) {
            }
            String str16 = string;
            if (next2.getModuleId() == null) {
            }
            programSaveInfo = new ProgramSaveInfo(programId, moduleId, str15, str16);
            String videoUrl = next2.getVideoUrl();
            if (videoUrl == null) {
            } else {
            }
            str3 = videoUrl;
            String videoThumbnailUrl = next2.getVideoThumbnailUrl();
            if (videoThumbnailUrl == null) {
            } else {
            }
            str7 = videoThumbnailUrl;
            Long uploadTimeMs = next2.getUploadTimeMs();
            if (uploadTimeMs == null) {
            } else {
            }
            l = longValue;
            Long reviewTimeMs2 = next2.getReviewTimeMs();
            if (reviewTimeMs2 == null) {
            } else {
            }
            l2 = longValue;
            l5 = Math.max(l, l4);
            String reviewComment = next2.getReviewComment();
            if (reviewComment == null) {
            } else {
            }
            str10 = reviewComment;
            String examInstructions = trickModel3.getExamInstructions();
            if (examInstructions == null) {
            } else {
            }
            str4 = examInstructions;
            Integer examTimeLimit = trickModel3.getExamTimeLimit();
            if (examTimeLimit == null) {
            } else {
            }
            intValue = examTimeLimit.intValue();
            String evaluatedByAvatar = next2.getEvaluatedByAvatar();
            if (evaluatedByAvatar == null) {
            } else {
            }
            str12 = evaluatedByAvatar;
            String evaluatedByName = next2.getEvaluatedByName();
            if (evaluatedByName == null) {
            } else {
            }
            str = evaluatedByName;
            if (status != ProgramExam.Status.PENDING) {
            } else {
            }
            reviewTimeMs = 0;
            super(programSaveInfo, next2.getId(), trickModel3.getImage(), str3, str7, status, trickModel3.getName(), l5, l5, str10, str4, intValue, next2.getTimestamp(), obj17, 0, 0, next2.getUnlockTimeMs(), str12, str, reviewTimeMs, next2.getExamId(), next2.getEvaluatedByEmail(), next2.getUserFeedbackSubmitted(), 0, 2109440, 0);
            arrayList.add(programExam);
            reviewTimeMs = next2.getReviewTimeMs();
            str = str15;
            str12 = str15;
            intValue = 30;
            str4 = str15;
            str10 = str15;
            l2 = 0;
            l = 0;
            str7 = str15;
            str3 = str15;
            moduleId = str15;
            programId = str15;
        }
        n2.b bVar = new n2.b();
        return p.D0(arrayList, bVar);
    }

    private final List<ProgramExam> g(List<ProgramExam> list) {
        Object arrayList;
        Object next;
        int iterator;
        long timestamp;
        Object copy$default;
        boolean next2;
        Iterable examId;
        long timestamp2;
        int i12;
        int cmp;
        int i16;
        int i8;
        int i2;
        int i4;
        int i11;
        int i9;
        int i7;
        int i10;
        int i6;
        int i20;
        int i14;
        int i15;
        int i18;
        int i17;
        int i13;
        int i5;
        int i;
        Boolean tRUE;
        int i19;
        int i3;
        Iterator iterator2 = list.iterator();
        if (!iterator2.hasNext()) {
            next = iterator;
        } else {
            if (!iterator2.hasNext()) {
            } else {
                timestamp = (ProgramExam)iterator2.next().getTimestamp();
                Object next5 = iterator2.next();
                timestamp2 = (ProgramExam)next5.getTimestamp();
                while (Long.compare(timestamp, timestamp2) < 0) {
                    next = next5;
                    timestamp = timestamp2;
                    if (iterator2.hasNext()) {
                    }
                    next2 = list;
                    next5 = iterator2.next();
                    timestamp2 = (ProgramExam)next5.getTimestamp();
                }
            }
        }
        if ((ProgramExam)next == 0) {
        } else {
            iterator = (ProgramExam)next.getStatus();
        }
        if (iterator == ProgramExam.Status.REJECTED) {
            arrayList = new ArrayList(p.r(list, 10));
            iterator = list.iterator();
            while (iterator.hasNext()) {
                copy$default = next4;
                if (n.b((ProgramExam)copy$default.getExamId(), next.getExamId())) {
                }
                arrayList.add(copy$default);
                copy$default = ProgramExam.copy$default(copy$default, 0, 0, 0, 0, 0, 0, 0, 0, obj13, 0, 0, 0, 0, obj18, 0, 0, 0, 0, 0, 0, false, 0, 0, Boolean.TRUE);
            }
        } else {
            arrayList = examId;
        }
        return arrayList;
    }

    public final Object e(String string, String string2, String string3, d<? super List<ProgramExam>> d4) {
        super(this, string3, string, string2, 0);
        return k.e(this.c, aVar2, d4);
    }
}
