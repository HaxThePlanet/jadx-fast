package app.dogo.com.dogo_android.s.b;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.android.network.DogoApiClient;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel;
import app.dogo.com.dogo_android.n.m.t.h.b;
import app.dogo.com.dogo_android.n.m.t.i.a;
import app.dogo.com.dogo_android.n.m.t.i.b;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.z;
import app.dogo.com.dogo_android.w.e2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.q3;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.w1;
import app.dogo.com.dogo_android.y.k.a;
import app.dogo.com.dogo_android.y.k.b;
import app.dogo.com.dogo_android.y.k.c;
import app.dogo.com.dogo_android.y.m;
import app.dogo.com.dogo_android.y.m.a;
import app.dogo.com.dogo_android.y.m.b;
import app.dogo.com.dogo_android.y.m.c;
import app.dogo.externalmodel.model.BitingProgressModel;
import app.dogo.externalmodel.model.PottyProgramProgressModel;
import app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus;
import app.dogo.externalmodel.model.requests.ProgramStatusRequest;
import app.dogo.externalmodel.model.requests.SaveProgramQuestionRequest;
import app.dogo.externalmodel.model.requests.SaveProgramTaskRequest;
import app.dogo.externalmodel.model.responses.AllProgramProgressResponse;
import app.dogo.externalmodel.model.responses.AllProgramProgressResponse.SpecialProgramList;
import app.dogo.externalmodel.model.responses.BitingProgramProgressResponse;
import app.dogo.externalmodel.model.responses.ClassicProgramResponse;
import app.dogo.externalmodel.model.responses.ExamHistoryResponse;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.ExamSubmission;
import app.dogo.externalmodel.model.responses.ProgramProgress.LessonProgress;
import app.dogo.externalmodel.model.responses.ProgramProgress.ModuleProgress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.q;
import kotlin.w;
import kotlin.y.j0;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.r1;

/* compiled from: ProgramRepository.kt */
@Metadata(d1 = "\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\r\u0018\u0000 Z2\u00020\u0001:\u0002Z[B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u001a\u0010 \u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J!\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0019\u0010.\u001a\u00020/2\u0006\u0010$\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J\u001f\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u001c012\u0006\u0010$\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0019\u00102\u001a\u0002032\u0006\u0010$\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J!\u00104\u001a\u0002052\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(J!\u00106\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J/\u00107\u001a\u0008\u0012\u0004\u0012\u000208012\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010:J\u000c\u0010;\u001a\u0008\u0012\u0004\u0012\u00020\u00130<J\u0019\u0010=\u001a\u00020>2\u0006\u0010$\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0006\u0010?\u001a\u00020#J\u001c\u0010@\u001a\u00020#2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0006\u0010A\u001a\u00020#J1\u0010B\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010DJ\u0018\u0010E\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001b\u0010F\u001a\u0004\u0018\u00010\u00172\u0006\u0010+\u001a\u00020GH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010HJ&\u0010I\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u001cJ1\u0010J\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010DJ\u0019\u0010K\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J)\u0010L\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010:J9\u0010M\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\n\u0008\u0002\u0010N\u001a\u0004\u0018\u00010O2\n\u0008\u0002\u0010P\u001a\u0004\u0018\u00010OH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010QJ9\u0010R\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010VJ?\u0010W\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001c2\u000c\u0010X\u001a\u0008\u0012\u0004\u0012\u00020\u001c01H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010YR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\\", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "dogLogRepository", "Lapp/dogo/com/dogo_android/repository/local/DogLogRepository;", "programContentRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;", "externalScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/repository/local/DogLogRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;Lkotlinx/coroutines/CoroutineScope;)V", "lessonCompletion", "Landroidx/lifecycle/MutableLiveData;", "", "programAppState", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository$ProgramStateHolder;", "convertWrapperToDogoProgram", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram;", "wrapper", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper;", "(Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectLessonCompletion", "", "oldState", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "newState", "detectLessonMastery", "detectProgramCompletion", "doInitialProgramSyncIfNeeded", "", "dogId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureProgramIsActive", "programId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findTrickLesson", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "rating", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$ClassicProgram;", "(Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$ClassicProgram;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPrograms", "Lapp/dogo/com/dogo_android/trainingprogram/AllDogoPrograms;", "getAllStartedPrograms", "", "getBitingProgram", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$BitingProgram;", "getClassicProgram", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$ClassicProgram;", "getClassicProgramProgressRemote", "getExamHistory", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "trickId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLessonCompletionLiveData", "Landroidx/lifecycle/LiveData;", "getPottyProgramProgress", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$PottyProgram;", "invalidateCache", "processProgramChanges", "resetLessonCompletion", "saveExamUpload", "examId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveProgressResponseToCache", "saveTrickKnowledge", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;", "(Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveUserExamFeedbackInBackground", "saveUsersExamFeedbackGiven", "syncProgressFromRemote", "updateExamReviewed", "updateProgramState", "startTimeMs", "", "stopTimeMs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateQuestionState", "moduleId", "lessonId", "questionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTaskState", "taskIds", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ProgramStateHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j1, reason: from kotlin metadata */
public final class ProgramRepository {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final j1.a INSTANCE = new j1$a(0);
    private static final long j = 0L;
    /* renamed from: a, reason: from kotlin metadata */
    private final DogoApiClient apiClient;
    /* renamed from: b, reason: from kotlin metadata */
    private final o3 dogLogRepository;
    /* renamed from: c, reason: from kotlin metadata */
    private final v2 externalScope;
    /* renamed from: d, reason: from kotlin metadata */
    private final o1 lessonCompletion;
    /* renamed from: e, reason: from kotlin metadata */
    private final f1 programAppState;
    /* renamed from: f, reason: from kotlin metadata */
    private final i1 programContentRepository;
    /* renamed from: g, reason: from kotlin metadata */
    private final m0 timeUtils;
    /* renamed from: h, reason: from kotlin metadata */
    private final j1.b tracker;
    /* renamed from: i, reason: from kotlin metadata */
    private final x<Boolean> tricksRepository;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\u00020\u00082\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0008R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ProgramRepository$Companion;", "", "()V", "BITING_PROGRAM_ID", "", "CLASSIC_PROGRAM_TYPE", "POTTY_PROGRAM_ID", "PROGRAM_WITH_EXAM_CACHE_LIFETIME", "", "getPROGRAM_WITH_EXAM_CACHE_LIFETIME", "()J", "convertRatingResultToProgramWrapper", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper;", "rating", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults;", "getTrainingDurationInSeconds", "knowledge", "", "trickTimeInSeconds", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public static final /* synthetic */ m getTrainingDurationInSeconds(j1.a knowledge, app.dogo.com.dogo_android.n.m.t.i trickTimeInSeconds) {
            return knowledge.convertRatingResultToProgramWrapper(trickTimeInSeconds);
        }

        /* renamed from: b, reason: from kotlin metadata */
        private final m convertRatingResultToProgramWrapper(app.dogo.com.dogo_android.n.m.t.i rating) throws NoWhenBranchMatchedException {
            m.b programProgressWrapper_ClassicProgramProgress = null;
            if (rating instanceof TrickRatingResults_BitingProgram) {
                m.a programProgressWrapper_BitingProgramProgressWrapper = new ProgramProgressWrapper_BitingProgramProgressWrapper(rating.b());
                return programProgressWrapper_ClassicProgramProgress;
            } else {
                if (rating instanceof TrickRatingResults_ClassicProgram) {
                    programProgressWrapper_ClassicProgramProgress = new ProgramProgressWrapper_ClassicProgramProgress(rating.b());
                } else {
                    if (rating instanceof TrickRatingResults_Library) {
                        int i = 0;
                    }
                }
            }
            throw new NoWhenBranchMatchedException();
        }

        public final long c() {
            return ProgramRepository.j;
        }

        public final long d(int i, long j) {
            int i2 = 5;
            long l2;
            if (i == 3) {
                int i3 = 2;
                l = (long)i3;
                l2 = j / l;
            } else {
                int i5 = 4;
                if (i == i5 || i == 5) {
                    l = (long)i5;
                    l2 = j / l;
                }
            }
            return l2;
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\nR\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u001d\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0007R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0007¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ProgramRepository$ProgramStateHolder;", "", "()V", "bitingProgram", "Lapp/dogo/com/dogo_android/util/SimpleSessionCache;", "Lapp/dogo/externalmodel/model/BitingProgressModel;", "getBitingProgram", "()Lapp/dogo/com/dogo_android/util/SimpleSessionCache;", "classicPrograms", "", "", "Lapp/dogo/com/dogo_android/util/ClassicProgramCache;", "getClassicPrograms", "()Ljava/util/Map;", "pottyProgram", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "getPottyProgram", "programSyncState", "", "getProgramSyncState", "isProgramSynced", "dogId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class b {

        private final z<PottyProgramProgressModel.ProgramStatus> a = new z<>();
        private final z<BitingProgressModel> b = new z<>();
        private final Map<String, app.dogo.com.dogo_android.util.h> c = new LinkedHashMap<>();
        private final z<Boolean> d = new z<>();
        public b() {
            super();
            final long l = -1L;
            z simpleSessionCache = new SimpleSessionCache(l, r2);
            z simpleSessionCache2 = new SimpleSessionCache(l, r2);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            z simpleSessionCache3 = new SimpleSessionCache(l, r2);
        }

        public final z<BitingProgressModel> a() {
            return this.b;
        }

        public final Map<String, app.dogo.com.dogo_android.util.h> b() {
            return this.c;
        }

        public final z<PottyProgramProgressModel.ProgramStatus> c() {
            return this.a;
        }

        public final z<Boolean> d() {
            return this.d;
        }

        /* renamed from: e, reason: from kotlin metadata */
        public final boolean isProgramSynced(String dogId) {
            n.f(dogId, "dogId");
            return n.b(this.d.getData(dogId, 0L), Boolean.TRUE);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {270, 274, 278}, m = "convertWrapperToDogoProgram")
    static final class c extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        c(kotlin.b0.d<? super j1.c> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return j1.this.detectProgramCompletion(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {256, 262}, m = "ensureProgramIsActive")
    static final class d extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        d(kotlin.b0.d<? super j1.d> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            String str = null;
            return j1.this.m(str, str, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = 159, m = "findTrickLesson")
    static final class e extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        e(kotlin.b0.d<? super j1.e> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return j1.this.saveProgressResponseToCache(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {201, 202, 203, 204, 205}, m = "getAllPrograms")
    static final class f extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;
        f(kotlin.b0.d<? super j1.f> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return j1.this.o(null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = 196, m = "getAllStartedPrograms")
    static final class g extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        g(kotlin.b0.d<? super j1.g> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return j1.this.p(null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = 229, m = "getBitingProgram")
    static final class h extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        h(kotlin.b0.d<? super j1.h> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return j1.this.q(null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {181, 186, 188}, m = "getClassicProgram")
    static final class i extends kotlin.b0.k.a.d {

        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        i(kotlin.b0.d<? super j1.i> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            String str = null;
            return j1.this.r(str, str, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = 291, m = "getClassicProgramProgressRemote")
    static final class j extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        j(kotlin.b0.d<? super j1.j> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            String str = null;
            return j1.this.s(str, str, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = 148, m = "getExamHistory")
    static final class k extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        k(kotlin.b0.d<? super j1.k> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            String str = null;
            return j1.this.t(str, str, str, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = 233, m = "getPottyProgramProgress")
    static final class l extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        l(kotlin.b0.d<? super j1.l> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return j1.this.v(null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {141, 144}, m = "saveExamUpload")
    static final class m extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        m(kotlin.b0.d<? super j1.m> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return j1.this.z(null, null, null, null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {117, 129, 133, 134}, m = "saveTrickKnowledge")
    static final class n extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        n(kotlin.b0.d<? super j1.n> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return j1.this.B(null, this);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class o extends kotlin.b0.a implements CoroutineExceptionHandler {
        public o(CoroutineExceptionHandler.a exc) {
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            a.d(exception);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {174, 177}, m = "saveUsersExamFeedbackGiven")
    static final class q extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        q(kotlin.b0.d<? super j1.q> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return j1.this.updateQuestionState(0, 0, 0, 0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = 371, m = "syncProgressFromRemote")
    static final class r extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        r(kotlin.b0.d<? super j1.r> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return j1.this.detectLessonMastery(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {152, 155}, m = "updateExamReviewed")
    static final class s extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        s(kotlin.b0.d<? super j1.s> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            String str = null;
            return j1.this.updateProgramState(str, str, str, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {99, 103, 107, 112}, m = "updateProgramState")
    static final class t extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        t(kotlin.b0.d<? super j1.t> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return j1.this.updateTaskState(null, null, null, null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {78, 88, 89}, m = "updateQuestionState")
    static final class u extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        u(kotlin.b0.d<? super j1.u> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return j1.this.I(null, null, null, null, null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {63, 73, 74}, m = "updateTaskState")
    static final class v extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        v(kotlin.b0.d<? super j1.v> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return j1.this.J(null, null, null, null, null, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository$saveUserExamFeedbackInBackground$1", f = "ProgramRepository.kt", l = 58, m = "invokeSuspend")
    static final class p extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, kotlin.b0.d<? super w>, Object> {

        final /* synthetic */ String $dogId;
        final /* synthetic */ String $examId;
        final /* synthetic */ String $programId;
        final /* synthetic */ String $trickId;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj2 = b.d();
            int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    return w.a;
                }
            }
            q.b(object);
            this.label = i;
            if (j1.this.updateQuestionState(object2, this.$programId, this.$trickId, this.$examId, this) == obj2) {
                return obj2;
            }
        }

        p(String str, String str2, String str3, String str4, kotlin.b0.d<? super j1.p> dVar) {
            this.$dogId = str;
            this.$programId = str2;
            this.$trickId = str3;
            this.$examId = str4;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (app.dogo.com.dogo_android.repository.local.j1.p)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            app.dogo.com.dogo_android.repository.local.j1.p object2 = new app.dogo.com.dogo_android.repository.local.j1.p(j1.this, this.$dogId, this.$programId, this.$trickId, this.$examId, dVar);
            return object2;
        }
    }
    static {
        ProgramRepository.j = TimeUnit.MINUTES.toMillis(5L);
    }

    public j1(DogoApiClient dogoApiClient, o3 o3Var, v2 v2Var, o1 o1Var, f1 f1Var, i1 i1Var, m0 m0Var) {
        n.f(dogoApiClient, "apiClient");
        n.f(o3Var, "tracker");
        n.f(v2Var, "timeUtils");
        n.f(o1Var, "tricksRepository");
        n.f(f1Var, "dogLogRepository");
        n.f(i1Var, "programContentRepository");
        n.f(m0Var, "externalScope");
        super();
        this.apiClient = dogoApiClient;
        this.dogLogRepository = o3Var;
        this.externalScope = v2Var;
        this.lessonCompletion = o1Var;
        this.programAppState = f1Var;
        this.programContentRepository = i1Var;
        this.timeUtils = m0Var;
        this.tracker = new ProgramRepository_ProgramStateHolder();
        this.tricksRepository = new x();
    }

    /* renamed from: A, reason: from kotlin metadata */
    private final void detectLessonCompletion(String oldState, m newState) {
        Object value;
        long l = this.externalScope.g();
        if (newState instanceof ProgramProgressWrapper_ClassicProgramProgress) {
            String str = newState.component1().getId();
            if ((ClassicProgramCache)this.tracker.b().get(str) == null) {
                app.dogo.com.dogo_android.util.h classicProgramCache = new ClassicProgramCache();
            }
            value.setData(oldState, l, newState.component1());
            this.tracker.b().put(str, value);
            x(value.peekData(oldState), value.peekData(oldState));
        } else {
            if (newState instanceof ProgramProgressWrapper_BitingProgramProgressWrapper) {
                this.tracker.a().setData(oldState, l, newState.component1());
            } else {
                if (newState instanceof ProgramProgressWrapper_PottyProgramProgressWrapper) {
                    this.tracker.c().setData(oldState, l, newState.component1());
                    this.programAppState.updateEntityCache(oldState, newState.component1().getLogs());
                }
            }
        }
    }

    /* renamed from: D, reason: from kotlin metadata */
    /* suspend */ private final Object updateQuestionState(String dogId, String programId, String moduleId, String lessonId, kotlin.b0.d<? super app.dogo.com.dogo_android.y.k> questionId) {
        Object questionId2;
        int label2;
        DogoApiClient apiClient2;
        int i = -2147483648;
        String dogId2;
        int i2;
        String programId2;
        String moduleId2;
        String lessonId2;
        kotlin.b0.d dVar;
        String str;
        app.dogo.com.dogo_android.s.b.j1 j1Var;
        Object detectProgramCompletion;
        z = questionId instanceof app.dogo.com.dogo_android.repository.local.j1.q;
        if (questionId instanceof app.dogo.com.dogo_android.repository.local.j1.q) {
            questionId2 = questionId;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                questionId2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.q qVar = new app.dogo.com.dogo_android.repository.local.j1.q(this, questionId);
            }
        }
        final Object obj2 = b.d();
        final int i4 = 2;
        int i3 = 1;
        if (questionId2.label != 0) {
            if (questionId2.label != i3) {
                if (questionId2.label != i4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(questionId2.result);
                    return detectProgramCompletion;
                }
            }
            q.b(questionId2.result);
        } else {
            q.b(questionId2.result);
            questionId2.L$0 = this;
            questionId2.L$1 = dogId;
            questionId2.label = i3;
            if (this.apiClient.updateExamUserFeedback(dogId, programId, moduleId, lessonId, questionId2) == obj2) {
                return obj2;
            }
            j1Var = this;
        }
        m.b programProgressWrapper_ClassicProgramProgress = new ProgramProgressWrapper_ClassicProgramProgress((ClassicProgramResponse)detectProgramCompletion.getProgress());
        j1Var.detectLessonCompletion(str, programProgressWrapper_ClassicProgramProgress);
        Object obj = null;
        questionId2.L$0 = obj;
        questionId2.L$1 = obj;
        questionId2.label = i4;
        return j1Var.detectProgramCompletion(programProgressWrapper_ClassicProgramProgress, questionId2) == obj2 ? obj2 : detectProgramCompletion;
    }

    /* renamed from: E, reason: from kotlin metadata */
    private final Object detectLessonMastery(String oldState, kotlin.b0.d<? super j1.b> newState) {
        Object newState2;
        Object obj;
        int label2;
        int i = -2147483648;
        m.a programProgressWrapper_BitingProgramProgressWrapper;
        int i2;
        String str;
        Object allProgramProgress;
        z = newState instanceof app.dogo.com.dogo_android.repository.local.j1.r;
        if (newState instanceof app.dogo.com.dogo_android.repository.local.j1.r) {
            newState2 = newState;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                newState2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.r rVar = new app.dogo.com.dogo_android.repository.local.j1.r(this, newState);
            }
        }
        Object obj2 = b.d();
        int i4 = 1;
        if (newState2.label != 0) {
            if (newState2.label != i4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(newState2.result);
                Iterator it = allProgramProgress.getClassic().values().iterator();
                while (it.hasNext()) {
                    obj.detectLessonCompletion(str, new ProgramProgressWrapper_ClassicProgramProgress((ProgramProgress)it.next()));
                }
                BitingProgressModel id_nipping_program = allProgramProgress.getSpecial().getId_nipping_program();
                if (id_nipping_program != null) {
                    obj.detectLessonCompletion(str, new ProgramProgressWrapper_BitingProgramProgressWrapper(id_nipping_program));
                }
                PottyProgramProgressModel.ProgramStatus id_potty_program = allProgramProgress.getSpecial().getId_potty_program();
                if (id_potty_program != null) {
                    obj.detectLessonCompletion(str, new ProgramProgressWrapper_PottyProgramProgressWrapper(id_potty_program));
                }
                obj.tracker.d().setData(str, 0L, b.a(true));
                return obj.tracker;
            }
        }
        q.b(newState2.result);
        newState2.L$0 = this;
        newState2.L$1 = oldState;
        newState2.label = i4;
        if (this.apiClient.getAllProgramProgress(oldState, newState2) == obj2) {
            return obj2;
        }
        app.dogo.com.dogo_android.s.b.j1 oldState2 = this;
    }

    public static /* synthetic */ Object H(j1 j1Var, String str, String str2, Long long, Long long2, kotlin.b0.d dVar, int i, Object object) {
        Long long42;
        Long long52;
        i = 0;
        int r4 = i & 4 != 0 ? i : long;
        int r5 = i & 8 != 0 ? i : long2;
        return j1Var.updateTaskState(str, str2, long42, (i & 8 != 0 ? i : long2), dVar);
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ Object getExamHistory(j1 dogId, m programId, kotlin.b0.d trickId) {
        return dogId.detectProgramCompletion(programId, trickId);
    }

    /* renamed from: b, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ Object saveExamUpload(j1 dogId, String programId, String trickId, kotlin.b0.d examId) {
        return dogId.m(programId, trickId, examId);
    }

    /* renamed from: c, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ Object updateExamReviewed(j1 dogId, h.b programId, kotlin.b0.d trickId) {
        return dogId.saveProgressResponseToCache(programId, trickId);
    }

    /* renamed from: d, reason: from kotlin metadata */
    public static final /* synthetic */ Object saveUserExamFeedbackInBackground(j1 dogId, String programId, String trickId, kotlin.b0.d examId) {
        return dogId.s(programId, trickId, examId);
    }

    /* renamed from: e, reason: from kotlin metadata */
    public static final /* synthetic */ long getLessonCompletionLiveData() {
        return ProgramRepository.j;
    }

    public static final /* synthetic */ Object f(j1 j1Var, String str, String str2, String str3, String str4, kotlin.b0.d dVar) {
        return j1Var.updateQuestionState(str, str2, str3, str4, dVar);
    }

    public static final /* synthetic */ Object g(j1 j1Var, String str, kotlin.b0.d dVar) {
        return j1Var.detectLessonMastery(str, dVar);
    }

    /* renamed from: h, reason: from kotlin metadata */
    private final Object detectProgramCompletion(m oldState, kotlin.b0.d<? super app.dogo.com.dogo_android.y.k> newState) throws NoWhenBranchMatchedException {
        Object newState2;
        k.c dogoProgram_PottyProgram;
        int label2;
        int i = -2147483648;
        String str;
        int i2;
        Object obj;
        Object obj2;
        Object obj3;
        ProgramModel programModel;
        z = newState instanceof app.dogo.com.dogo_android.repository.local.j1.c;
        if (newState instanceof app.dogo.com.dogo_android.repository.local.j1.c) {
            newState2 = newState;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                newState2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.c cVar = new app.dogo.com.dogo_android.repository.local.j1.c(this, newState);
            }
        }
        Object obj4 = b.d();
        int i3 = 3;
        final int i4 = 2;
        final int i5 = 1;
        if (newState2.label != 0) {
            if (newState2.label != i5) {
                if (newState2.label != i4) {
                    if (newState2.label != i3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(newState2.result);
                        dogoProgram_PottyProgram = new DogoProgram_PottyProgram((ProgramModel)programModel, (ProgramProgressWrapper_PottyProgramProgressWrapper)obj.component1());
                    }
                }
                q.b(newState2.result);
                k.b dogoProgram_ClassicProgram = new DogoProgram_ClassicProgram((ProgramModel)programModel, (ProgramProgressWrapper_ClassicProgramProgress)obj3.component1());
            } else {
                q.b(newState2.result);
                k.a dogoProgram_BitingProgram = new DogoProgram_BitingProgram((ProgramModel)programModel, (ProgramProgressWrapper_BitingProgramProgressWrapper)obj2.component1());
            }
            return dogoProgram_PottyProgram;
        } else {
            q.b(newState2.result);
            if (oldState instanceof ProgramProgressWrapper_BitingProgramProgressWrapper) {
                newState2.L$0 = oldState;
                newState2.label = i5;
                str = "id_nipping_program";
                if (this.programContentRepository.g(str, newState2) == obj4) {
                    return obj4;
                }
            } else {
                if (oldState instanceof ProgramProgressWrapper_ClassicProgramProgress) {
                    newState2.L$0 = oldState;
                    newState2.label = i4;
                    if (this.programContentRepository.g((ProgramProgressWrapper_ClassicProgramProgress)oldState.component1().getId(), newState2) == obj4) {
                        return obj4;
                    }
                } else {
                    if (oldState instanceof ProgramProgressWrapper_PottyProgramProgressWrapper) {
                        newState2.L$0 = oldState;
                        newState2.label = i3;
                        str = "id_potty_program";
                        if (this.programContentRepository.g(str, newState2) == obj4) {
                            return obj4;
                        }
                    }
                }
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: i, reason: from kotlin metadata */
    /* suspend */ private final String ensureProgramIsActive(ProgramProgress dogId, ProgramProgress programId) {
        Object item;
        boolean hasNext2;
        int i2 = 0;
        List list;
        List list2;
        ArrayList arrayList = new ArrayList();
        Iterator it2 = dogId.getModules().iterator();
        i2 = 0;
        while (it2.hasNext()) {
            item = it2.next();
            p.y(arrayList, list);
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object item2 = it.next();
        }
        int i4 = 10;
        ArrayList arrayList2 = new ArrayList(p.r(arrayList3, i4));
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            arrayList2.add((ProgramProgress_LessonProgress)it3.next().getId());
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator it4 = programId.getModules().iterator();
        while (it4.hasNext()) {
            Object item4 = it4.next();
            int r3 = item4 == null ? 0 : i2;
            p.y(arrayList5, list2);
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it7 = arrayList5.iterator();
        while (it7.hasNext()) {
            Object item3 = it7.next();
        }
        ArrayList programId2 = new ArrayList(p.r(arrayList4, i4));
        Iterator it5 = arrayList4.iterator();
        while (it5.hasNext()) {
            programId2.add((ProgramProgress_LessonProgress)it5.next().getId());
        }
        Iterator it6 = programId2.iterator();
        while (it6.hasNext()) {
            ArrayList programId22 = it6.next();
            hasNext2 = !arrayList2.contains((String)programId22);
            if (!arrayList2.contains(programId22)) {
                ArrayList programId23 = programId22;
            }
        }
        return (String)i2;
    }

    /* renamed from: j, reason: from kotlin metadata */
    /* suspend */ private final String getClassicProgram(ProgramProgress dogId, ProgramProgress programId) {
        Object item;
        boolean hasNext2;
        int i2 = 0;
        List list;
        List list2;
        ArrayList arrayList = new ArrayList();
        Iterator it2 = dogId.getModules().iterator();
        i2 = 0;
        while (it2.hasNext()) {
            item = it2.next();
            p.y(arrayList, list);
        }
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object item2 = it.next();
        }
        int i4 = 10;
        ArrayList arrayList2 = new ArrayList(p.r(arrayList3, i4));
        Iterator it3 = arrayList3.iterator();
        while (it3.hasNext()) {
            arrayList2.add((ProgramProgress_LessonProgress)it3.next().getId());
        }
        ArrayList arrayList5 = new ArrayList();
        Iterator it4 = programId.getModules().iterator();
        while (it4.hasNext()) {
            Object item4 = it4.next();
            int r3 = item4 == null ? 0 : i2;
            p.y(arrayList5, list2);
        }
        ArrayList arrayList4 = new ArrayList();
        Iterator it7 = arrayList5.iterator();
        while (it7.hasNext()) {
            Object item3 = it7.next();
        }
        ArrayList programId2 = new ArrayList(p.r(arrayList4, i4));
        Iterator it5 = arrayList4.iterator();
        while (it5.hasNext()) {
            programId2.add((ProgramProgress_LessonProgress)it5.next().getId());
        }
        Iterator it6 = programId2.iterator();
        while (it6.hasNext()) {
            ArrayList programId22 = it6.next();
            hasNext2 = !arrayList2.contains((String)programId22);
            if (!arrayList2.contains(programId22)) {
                ArrayList programId23 = programId22;
            }
        }
        return (String)i2;
    }

    /* renamed from: k, reason: from kotlin metadata */
    /* suspend */ private final boolean getClassicProgramProgressRemote(ProgramProgress dogId, ProgramProgress programId) {
        boolean z = false;
        dogId = !dogId.isPassed() && programId.isPassed() ? 1 : 0;
        return (!dogId.isPassed() && programId.isPassed() ? 1 : 0);
    }

    /* renamed from: l, reason: from kotlin metadata */
    private final Object processProgramChanges(String oldState, kotlin.b0.d<? super w> newState) {
        Object obj = o(oldState, newState);
        if (obj == b.d()) {
            return obj;
        }
        return w.a;
    }

    private final Object m(String str, String str2, kotlin.b0.d<? super w> dVar) {
        int label2;
        app.dogo.com.dogo_android.s.b.j1 str3;
        int i = 0;
        int i2 = -2147483648;
        String str4;
        int i3;
        String str22;
        Long dVar33;
        Object str5;
        Long l = null;
        int i4 = 8;
        Object obj2 = null;
        Object str23;
        Object result2;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.j1.d;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.j1.d) {
            Object dVar32 = dVar;
            i2 = Integer.MIN_VALUE;
            i3 = label2 & i2;
            if (label2 & i2 != 0) {
                dVar32.label -= i2;
            } else {
                dVar = new app.dogo.com.dogo_android.repository.local.j1.d(this, dVar);
            }
        }
        final Object obj4 = dVar;
        Object obj3 = b.d();
        int i6 = 2;
        i = 1;
        if (obj4.label != 0) {
            if (obj4.label != i) {
                if (obj4.label != i6) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(obj4.result);
                    str3.dogLogRepository.logEvent(E_TrainingProgram.g.c(new EP_ProgramId(), str23));
                    return w.a;
                }
            }
            q.b(obj4.result);
        } else {
            q.b(obj4.result);
            obj4.L$0 = this;
            obj4.L$1 = str;
            obj4.L$2 = str2;
            obj4.label = i;
            if (o(str, obj4) == obj3) {
                return obj3;
            }
            str5 = str;
            str3 = this;
        }
        int r1 = (DogoProgram_ClassicProgram)result2.d().get(str23) != null ? i : 0;
        if (obj4.label != 0 && n.b(result2.b(), str3.dogLogRepository) ^ i != 0) {
            l = null;
            i4 = 8;
            obj2 = null;
            obj4.L$0 = str3;
            obj4.L$1 = str23;
            obj4.L$2 = null;
            obj4.label = i6;
            if (ProgramRepository.H(str3, str5, str23, dVar33, l, obj4, i4, obj2) == obj3) {
                return obj3;
            }
        }
    }

    /* renamed from: n, reason: from kotlin metadata */
    private final Object saveProgressResponseToCache(h.b dogId, kotlin.b0.d<? super ProgramSaveInfo> wrapper) {
        Object wrapper2;
        String str;
        int label2;
        String str2 = null;
        int i = -2147483648;
        int label22;
        boolean booleanValue;
        int i2;
        boolean booleanValue3;
        boolean z2;
        String str4;
        Object obj;
        Object result2;
        Iterator it2;
        z = wrapper instanceof app.dogo.com.dogo_android.repository.local.j1.e;
        if (wrapper instanceof app.dogo.com.dogo_android.repository.local.j1.e) {
            wrapper2 = wrapper;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                wrapper2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.e eVar = new app.dogo.com.dogo_android.repository.local.j1.e(this, wrapper);
            }
        }
        wrapper2 = b.d();
        int i3 = 1;
        if (wrapper2.label != 0) {
            if (wrapper2.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(wrapper2.result);
                it2 = (ProgramModel)result2.getModules().iterator();
                wrapper2 = null;
                while (it2.hasNext()) {
                    List lessons = (ProgramModel_ModuleModel)wrapper2.getLessons();
                    booleanValue3 = lessons instanceof Collection;
                    int i4 = 0;
                    if (b.a(z2).booleanValue()) {
                        break;
                    }
                }
                Object r2 = wrapper2;
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }
        q.b(wrapper2.result);
        wrapper2.L$0 = dogId;
        wrapper2.label = i3;
        if (this.programContentRepository.g(dogId.f(), wrapper2) == wrapper2) {
            return wrapper2;
        }
    }

    private final Object s(String str, String str2, kotlin.b0.d<? super ProgramProgress> dVar) {
        Object dVar32;
        int label2;
        int i = -2147483648;
        int i2;
        String str3;
        Object obj;
        Object programProgress;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.j1.j;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.j1.j) {
            dVar32 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar32.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.j jVar = new app.dogo.com.dogo_android.repository.local.j1.j(this, dVar);
            }
        }
        Object obj2 = b.d();
        int i3 = 1;
        if (dVar32.label != 0) {
            if (dVar32.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar32.result);
                m.b programProgressWrapper_ClassicProgramProgress = new ProgramProgressWrapper_ClassicProgramProgress((ClassicProgramResponse)programProgress.getProgress());
                obj.detectLessonCompletion(str3, programProgressWrapper_ClassicProgramProgress);
                return programProgressWrapper_ClassicProgramProgress.component1();
            }
        }
        q.b(dVar32.result);
        dVar32.L$0 = this;
        dVar32.L$1 = str;
        dVar32.label = i3;
        if (this.apiClient.getProgramProgress(str, str2, dVar32) == obj2) {
            return obj2;
        }
        app.dogo.com.dogo_android.s.b.j1 str5 = this;
    }

    private final void x(ProgramProgress programProgress, ProgramProgress programProgress2) {
        String ensureProgramIsActive;
        String classicProgram;
        o3 dogLogRepository2;
        u2 u2Var;
        w1 eP_LessonId;
        if (programProgress != null && programProgress2 != null) {
            ensureProgramIsActive = ensureProgramIsActive(programProgress, programProgress2);
            classicProgram = getClassicProgram(programProgress, programProgress2);
            if (ensureProgramIsActive != null) {
                this.dogLogRepository.logEvent(E_TrainingProgram.k.c(new EP_LessonId(), ensureProgramIsActive));
            }
            if (classicProgram != null) {
                this.dogLogRepository.logEvent(E_TrainingProgram.l.c(new EP_LessonId(), classicProgram));
                this.tricksRepository.postValue(Boolean.TRUE);
            }
            if (getClassicProgramProgressRemote(programProgress, programProgress2)) {
                this.dogLogRepository.logEvent(E_TrainingProgram.A.c(new EP_ProgramId(), programProgress2.getId()));
            }
        }
    }

    public final Object B(app.dogo.com.dogo_android.n.m.t.h hVar, kotlin.b0.d<? super app.dogo.com.dogo_android.y.k> dVar) {
        Object hVar2;
        m trainingDurationInSeconds;
        h.b trickRating_ClassicProgram;
        Object detectProgramCompletion;
        app.dogo.com.dogo_android.n.m.t.i iVar;
        Object dVar22;
        int label2;
        int i = -2147483648;
        Object obj2;
        int label22;
        int i2;
        int i3 = 2;
        int i4 = 1;
        String str;
        int i5;
        String str2;
        String programId;
        String moduleId;
        String lessonId;
        final app.dogo.com.dogo_android.s.b.j1 j1Var = this;
        hVar2 = hVar;
        dVar22 = dVar;
        z = dVar22 instanceof app.dogo.com.dogo_android.repository.local.j1.n;
        if (dVar22 instanceof app.dogo.com.dogo_android.repository.local.j1.n) {
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.n nVar = new app.dogo.com.dogo_android.repository.local.j1.n(j1Var, dVar22);
            }
        }
        Object obj4 = b.d();
        int i6 = 4;
        final int i7 = 3;
        i3 = 2;
        i4 = 1;
        detectProgramCompletion = null;
        if (dVar22.label != 0) {
            if (dVar22.label != i4) {
                if (dVar22.label != i3) {
                    if (dVar22.label != i7) {
                        if (dVar22.label != i6) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(dVar22.result);
                        }
                    }
                    q.b(dVar22.result);
                    dVar22.L$0 = detectProgramCompletion;
                    dVar22.L$1 = detectProgramCompletion;
                    dVar22.label = i6;
                    if (obj2.detectProgramCompletion(trainingDurationInSeconds, dVar22) == obj4) {
                        return obj4;
                    }
                } else {
                    q.b(dVar22.result);
                    trainingDurationInSeconds = ProgramRepository.INSTANCE.convertRatingResultToProgramWrapper((TrickRatingResults)iVar);
                    if (trainingDurationInSeconds != null) {
                        obj2.detectLessonCompletion(hVar2.a(), trainingDurationInSeconds);
                        dVar22.L$0 = obj2;
                        dVar22.L$1 = trainingDurationInSeconds;
                        dVar22.label = i7;
                        if (obj2.m(hVar2.a(), trainingDurationInSeconds.a(), dVar22) == obj4) {
                            return obj4;
                        }
                    }
                }
            } else {
                q.b(dVar22.result);
                trickRating_ClassicProgram = new TrickRating_ClassicProgram(hVar2.a(), hVar2.b(), hVar2.c(), detectProgramCompletion.getProgramId(), detectProgramCompletion.getModuleId(), detectProgramCompletion.getLessonId());
                dVar22.L$0 = obj2;
                dVar22.L$1 = hVar2;
                dVar22.label = i3;
                Object obj = obj2.lessonCompletion.E(trickRating_ClassicProgram, dVar22);
                if (obj == obj4) {
                    return obj4;
                }
            }
        } else {
            q.b(dVar22.result);
            if (hVar2 instanceof TrickRating_ClassicProgram) {
                dVar22.L$0 = j1Var;
                dVar22.L$1 = hVar2;
                dVar22.label = i4;
                if (j1Var.saveProgressResponseToCache((TrickRating_ClassicProgram)hVar2, dVar22) == obj4) {
                    return obj4;
                }
            } else {
            }
        }
        return detectProgramCompletion;
    }

    /* renamed from: C, reason: from kotlin metadata */
    /* suspend */ public final void saveUsersExamFeedbackGiven(String dogId, String programId, String trickId, String examId) {
        n.f(dogId, "dogId");
        n.f(programId, "programId");
        n.f(trickId, "trickId");
        n.f(examId, "examId");
        app.dogo.com.dogo_android.repository.local.j1.p pVar = new app.dogo.com.dogo_android.repository.local.j1.p(this, dogId, programId, trickId, examId, null);
        kotlinx.coroutines.internal.k.d(this.timeUtils, new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r), null, pVar, 2, null);
    }

    /* renamed from: F, reason: from kotlin metadata */
    /* suspend */ public final Object updateProgramState(String dogId, String programId, String startTimeMs, kotlin.b0.d<? super app.dogo.com.dogo_android.y.k> stopTimeMs) {
        Object stopTimeMs2;
        int label2;
        int i = -2147483648;
        int i2;
        String str;
        app.dogo.com.dogo_android.s.b.j1 j1Var;
        Object detectProgramCompletion;
        z = stopTimeMs instanceof app.dogo.com.dogo_android.repository.local.j1.s;
        if (stopTimeMs instanceof app.dogo.com.dogo_android.repository.local.j1.s) {
            stopTimeMs2 = stopTimeMs;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                stopTimeMs2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.s sVar = new app.dogo.com.dogo_android.repository.local.j1.s(this, stopTimeMs);
            }
        }
        Object obj2 = b.d();
        int i3 = 2;
        final int i4 = 1;
        if (stopTimeMs2.label != 0) {
            if (stopTimeMs2.label != i4) {
                if (stopTimeMs2.label != i3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(stopTimeMs2.result);
                    return detectProgramCompletion;
                }
            }
            q.b(stopTimeMs2.result);
        } else {
            q.b(stopTimeMs2.result);
            stopTimeMs2.L$0 = this;
            stopTimeMs2.L$1 = dogId;
            stopTimeMs2.label = i4;
            if (this.apiClient.updateExamBadge(dogId, programId, startTimeMs, stopTimeMs2) == obj2) {
                return obj2;
            }
            j1Var = this;
        }
        m.b programProgressWrapper_ClassicProgramProgress = new ProgramProgressWrapper_ClassicProgramProgress((ClassicProgramResponse)detectProgramCompletion.getProgress());
        j1Var.detectLessonCompletion(str, programProgressWrapper_ClassicProgramProgress);
        Object obj = null;
        stopTimeMs2.L$0 = obj;
        stopTimeMs2.L$1 = obj;
        stopTimeMs2.label = i3;
        return j1Var.detectProgramCompletion(programProgressWrapper_ClassicProgramProgress, stopTimeMs2) == obj2 ? obj2 : detectProgramCompletion;
    }

    /* renamed from: G, reason: from kotlin metadata */
    /* suspend */ public final Object updateTaskState(String dogId, String programId, Long moduleId, Long lessonId, kotlin.b0.d<? super app.dogo.com.dogo_android.y.k> taskIds) {
        Object taskIds2;
        int label2;
        int i = -2147483648;
        int i2;
        String str;
        Object obj2;
        Object obj4;
        Object obj3;
        Object obj5;
        m.a programProgressWrapper_BitingProgramProgressWrapper;
        BitingProgressModel progress;
        Object detectProgramCompletion;
        z = taskIds instanceof app.dogo.com.dogo_android.repository.local.j1.t;
        if (taskIds instanceof app.dogo.com.dogo_android.repository.local.j1.t) {
            taskIds2 = taskIds;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                taskIds2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.t tVar = new app.dogo.com.dogo_android.repository.local.j1.t(this, taskIds);
            }
        }
        Object obj6 = b.d();
        int i3 = 4;
        final int i4 = 3;
        final int i5 = 2;
        final int i6 = 1;
        if (taskIds2.label != 0) {
            if (taskIds2.label != i6) {
                if (taskIds2.label != i5) {
                    if (taskIds2.label != i4) {
                        if (taskIds2.label != i3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(taskIds2.result);
                            return detectProgramCompletion;
                        }
                    }
                    q.b(taskIds2.result);
                    m.b programProgressWrapper_ClassicProgramProgress = new ProgramProgressWrapper_ClassicProgramProgress((ClassicProgramResponse)detectProgramCompletion.getProgress());
                } else {
                    q.b(taskIds2.result);
                    m.c programProgressWrapper_PottyProgramProgressWrapper = new ProgramProgressWrapper_PottyProgramProgressWrapper((PottyProgramProgressModel)detectProgramCompletion.getProgress());
                }
            } else {
                q.b(taskIds2.result);
                programProgressWrapper_BitingProgramProgressWrapper = new ProgramProgressWrapper_BitingProgramProgressWrapper((BitingProgramProgressResponse)detectProgramCompletion.getProgress());
            }
        } else {
            q.b(taskIds2.result);
            ProgramStatusRequest programStatusRequest = new ProgramStatusRequest(moduleId, lessonId);
            if (n.b(programId, "id_nipping_program")) {
                taskIds2.L$0 = this;
                taskIds2.L$1 = dogId;
                taskIds2.label = i6;
                if (this.apiClient.updateBitingProgramState(dogId, programStatusRequest, taskIds2) == obj6) {
                    return obj6;
                }
                app.dogo.com.dogo_android.s.b.j1 dogId2 = this;
            } else {
                if (n.b(programId, "id_potty_program")) {
                    taskIds2.L$0 = this;
                    taskIds2.L$1 = dogId;
                    taskIds2.label = i5;
                    if (this.apiClient.updatePottyProgramState(dogId, programStatusRequest, taskIds2) == obj6) {
                        return obj6;
                    }
                    dogId2 = this;
                } else {
                    taskIds2.L$0 = this;
                    taskIds2.L$1 = dogId;
                    taskIds2.label = i4;
                    if (this.apiClient.updateClassicProgramState(dogId, programId, programStatusRequest, taskIds2) == obj6) {
                        return obj6;
                    }
                    dogId2 = this;
                }
            }
        }
        obj5.detectLessonCompletion(str, programProgressWrapper_BitingProgramProgressWrapper);
        Object obj = null;
        taskIds2.L$0 = obj;
        taskIds2.L$1 = obj;
        taskIds2.label = i3;
        return obj5.detectProgramCompletion(programProgressWrapper_BitingProgramProgressWrapper, taskIds2) == obj6 ? obj6 : detectProgramCompletion;
    }

    public final Object I(String str, String str2, String str3, String str4, String str5, kotlin.b0.d<? super w> dVar) {
        Object dVar62;
        int label2;
        int i = -2147483648;
        SaveProgramQuestionRequest saveProgramQuestionRequest;
        int i2;
        String str7;
        m.b str32;
        app.dogo.com.dogo_android.s.b.j1 j1Var;
        String str6;
        Object programQuestion;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.j1.u;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.j1.u) {
            dVar62 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar62.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.u uVar = new app.dogo.com.dogo_android.repository.local.j1.u(this, dVar);
            }
        }
        Object obj2 = b.d();
        int i3 = 3;
        final int i4 = 2;
        final int i5 = 1;
        if (dVar62.label != 0) {
            if (dVar62.label != i5) {
                if (dVar62.label != i4) {
                    if (dVar62.label != i3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(dVar62.result);
                        return w.a;
                    }
                }
                q.b(dVar62.result);
            } else {
                q.b(dVar62.result);
                str32 = new ProgramProgressWrapper_ClassicProgramProgress((ClassicProgramResponse)programQuestion.getProgress());
                j1Var.detectLessonCompletion(str7, str32);
                dVar62.L$0 = j1Var;
                dVar62.L$1 = str32;
                dVar62.label = i4;
                if (j1Var.m(str7, str32.a(), dVar62) == obj2) {
                    return obj2;
                }
            }
        } else {
            q.b(dVar62.result);
            dVar62.L$0 = this;
            dVar62.L$1 = str;
            dVar62.label = i5;
            if (this.apiClient.saveProgramQuestion(str, str2, new SaveProgramQuestionRequest(str5, str3, str4), dVar62) == obj2) {
                return obj2;
            }
            j1Var = this;
        }
        Object obj = null;
        dVar62.L$0 = obj;
        dVar62.L$1 = obj;
        dVar62.label = i3;
        if (j1Var.detectProgramCompletion(str32, dVar62) == obj2) {
            return obj2;
        }
    }

    public final Object J(String str, String str2, String str3, String str4, List<String> list, kotlin.b0.d<? super w> dVar) {
        Object dVar62;
        int label2;
        int i = -2147483648;
        SaveProgramTaskRequest saveProgramTaskRequest;
        int i2;
        String str6;
        m.b str32;
        app.dogo.com.dogo_android.s.b.j1 j1Var;
        String str5;
        Object programTask;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.j1.v;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.j1.v) {
            dVar62 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar62.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.v vVar = new app.dogo.com.dogo_android.repository.local.j1.v(this, dVar);
            }
        }
        Object obj2 = b.d();
        int i3 = 3;
        final int i4 = 2;
        final int i5 = 1;
        if (dVar62.label != 0) {
            if (dVar62.label != i5) {
                if (dVar62.label != i4) {
                    if (dVar62.label != i3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(dVar62.result);
                        return w.a;
                    }
                }
                q.b(dVar62.result);
            } else {
                q.b(dVar62.result);
                str32 = new ProgramProgressWrapper_ClassicProgramProgress((ClassicProgramResponse)programTask.getProgress());
                j1Var.detectLessonCompletion(str6, str32);
                dVar62.L$0 = j1Var;
                dVar62.L$1 = str32;
                dVar62.label = i4;
                if (j1Var.m(str6, str32.a(), dVar62) == obj2) {
                    return obj2;
                }
            }
        } else {
            q.b(dVar62.result);
            dVar62.L$0 = this;
            dVar62.L$1 = str;
            dVar62.label = i5;
            if (this.apiClient.saveProgramTask(str, str2, new SaveProgramTaskRequest(list, str3, str4), dVar62) == obj2) {
                return obj2;
            }
            j1Var = this;
        }
        Object obj = null;
        dVar62.L$0 = obj;
        dVar62.L$1 = obj;
        dVar62.label = i3;
        if (j1Var.detectProgramCompletion(str32, dVar62) == obj2) {
            return obj2;
        }
    }

    public final Object o(String str, kotlin.b0.d<? super app.dogo.com.dogo_android.y.i> dVar) {
        Object dVar22;
        Object obj2;
        int label2;
        Iterable iterable;
        int i = -2147483648;
        String str3;
        Object str2;
        int i2;
        app.dogo.com.dogo_android.s.b.i1 programContentRepository22;
        app.dogo.com.dogo_android.s.b.i1 programContentRepository23;
        ProgramProgress peekData = null;
        ProgramModel programModel;
        Object obj4;
        List list;
        ProgramModel programModel2;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.j1.f;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.j1.f) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.f fVar = new app.dogo.com.dogo_android.repository.local.j1.f(this, dVar);
            }
        }
        Object obj5 = b.d();
        int i4 = 5;
        int i5 = 4;
        int i6 = 3;
        int i8 = 2;
        int i9 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i9) {
                if (dVar22.label != i8) {
                    if (dVar22.label != i6) {
                        if (dVar22.label != i5) {
                            if (dVar22.label != i4) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                q.b(dVar22.result);
                                ArrayList arrayList = new ArrayList(p.r(iterable, 10));
                                Iterator it = iterable.iterator();
                                while (it.hasNext()) {
                                    Object item = it.next();
                                    Object value = str2.b().get(item.getId());
                                    DogoProgram_ClassicProgram dogoProgram_ClassicProgram = new DogoProgram_ClassicProgram(item, peekData);
                                    arrayList.add(new Pair(item.getId(), dogoProgram_ClassicProgram));
                                }
                                long l2 = obj2.externalScope.g();
                                app.dogo.com.dogo_android.y.i allDogoPrograms = new AllDogoPrograms(j0.s(arrayList), new DogoProgram_BitingProgram(programModel, (BitingProgressModel)str2.a().getData(str3, obj2.externalScope.g())), new DogoProgram_PottyProgram((ProgramModel)programModel2, (PottyProgramProgressModel_ProgramStatus)str2.c().getData(str3, l2)));
                                obj2.dogLogRepository.setUserProperty(UserProperty.CurrentProgramId, allDogoPrograms.b());
                                return allDogoPrograms;
                            }
                        }
                        q.b(dVar22.result);
                    } else {
                        q.b(dVar22.result);
                        dVar22.L$0 = obj2;
                        dVar22.L$1 = str3;
                        dVar22.L$2 = str2;
                        dVar22.L$3 = str2;
                        dVar22.label = i5;
                        str2 = obj2.programContentRepository.g("id_nipping_program", dVar22);
                        if (str2 == obj5) {
                            return obj5;
                        }
                    }
                } else {
                    q.b(dVar22.result);
                    dVar22.L$0 = obj2;
                    dVar22.L$1 = str3;
                    dVar22.L$2 = str2;
                    dVar22.label = i6;
                    if (obj2.programContentRepository.c((List)list, dVar22) == obj5) {
                        return obj5;
                    }
                }
            } else {
                q.b(dVar22.result);
                dVar22.L$0 = obj2;
                dVar22.L$1 = str3;
                dVar22.L$2 = str2;
                dVar22.label = i8;
                Object obj3 = obj2.p(str3, dVar22);
                if (obj3 == obj5) {
                    return obj5;
                }
            }
        } else {
            q.b(dVar22.result);
            if (!this.tracker.isProgramSynced(str)) {
                dVar22.L$0 = this;
                dVar22.L$1 = str;
                dVar22.label = i9;
                if (detectLessonMastery(str, dVar22) == obj5) {
                    return obj5;
                }
                app.dogo.com.dogo_android.s.b.j1 str6 = this;
            } else {
                str6 = this;
            }
        }
        dVar22.L$0 = obj2;
        dVar22.L$1 = str3;
        dVar22.L$2 = str2;
        dVar22.L$3 = str2;
        dVar22.L$4 = str2;
        dVar22.label = i4;
        Object obj = obj2.programContentRepository.g("id_potty_program", dVar22);
        if (obj == obj5) {
            return obj5;
        }
    }

    public final Object p(String str, kotlin.b0.d<? super List<String>> dVar) {
        Object dVar22;
        int label2;
        int i2 = -2147483648;
        boolean z2 = false;
        int i4;
        Object obj;
        String str2;
        Object detectLessonMastery;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.j1.g;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.j1.g) {
            dVar22 = dVar;
            i2 = Integer.MIN_VALUE;
            i4 = label2 & i2;
            if (label2 & i2 != 0) {
                dVar22.label -= i2;
            } else {
                app.dogo.com.dogo_android.s.b.j1.g gVar = new app.dogo.com.dogo_android.repository.local.j1.g(this, dVar);
            }
        }
        Object obj2 = b.d();
        int i3 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar22.result);
                Map map = detectLessonMastery.b();
                ArrayList arrayList = new ArrayList(map.size());
                Iterator it2 = map.entrySet().iterator();
                while (it2.hasNext()) {
                    arrayList.add((ClassicProgramCache)(Map.Entry)it2.next().getValue().peekData(str2));
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    arrayList = it3.next();
                    int i6 = 0;
                }
                List list = p.U(arrayList2);
                ArrayList arrayList3 = new ArrayList(p.r(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList3.add((ProgramProgress)it.next().getId());
                }
                return arrayList3;
            }
        }
        q.b(dVar22.result);
        if (!this.tracker.isProgramSynced(str)) {
            dVar22.L$0 = str;
            dVar22.label = i3;
            if (detectLessonMastery(str, dVar22) == obj2) {
                return obj2;
            }
        } else {
        }
    }

    public final Object q(String str, kotlin.b0.d<? super k.a> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        int i2;
        Object result2;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.j1.h;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.j1.h) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.h hVar = new app.dogo.com.dogo_android.repository.local.j1.h(this, dVar);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar22.result);
                return (AllDogoPrograms)result2.c();
            }
        }
        q.b(dVar22.result);
        dVar22.label = i3;
        if (o(str, dVar22) == obj) {
            return obj;
        }
    }

    public final Object r(String str, String str2, kotlin.b0.d<? super k.b> dVar) {
        Object dVar32;
        int label2;
        int i = -2147483648;
        Object dVar33;
        int i2;
        String str3;
        int i3 = 1;
        String str4;
        app.dogo.com.dogo_android.s.b.j1 j1Var;
        boolean z2;
        Object dVar34;
        Object str5;
        long l;
        ProgramModel programModel;
        Object str22;
        ProgramProgress str6;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.j1.i;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.j1.i) {
            dVar32 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar32.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.i iVar = new app.dogo.com.dogo_android.repository.local.j1.i(this, dVar);
            }
        }
        Object obj2 = b.d();
        int i4 = 3;
        int i5 = 2;
        i3 = 1;
        if (dVar32.label != 0) {
            if (dVar32.label != i3) {
                if (dVar32.label != i5) {
                    if (dVar32.label != i4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(dVar32.result);
                        return new DogoProgram_ClassicProgram(programModel, str6);
                    }
                }
                q.b(dVar32.result);
            } else {
                q.b(dVar32.result);
                l = j1Var.externalScope.g();
                dVar32.L$0 = j1Var;
                dVar32.L$1 = str5;
                dVar32.L$2 = str22;
                dVar32.L$3 = (ClassicProgramCache)dVar33;
                dVar32.J$0 = l;
                dVar32.label = i5;
                if (j1Var.programContentRepository.g(str22, dVar32) == obj2) {
                    return obj2;
                }
            }
        } else {
            q.b(dVar32.result);
            dVar32.L$0 = this;
            dVar32.L$1 = str;
            dVar32.L$2 = str2;
            dVar32.label = i3;
            if (processProgramChanges(str, dVar32) == obj2) {
                return obj2;
            }
            j1Var = this;
        }
        i3 = 0;
        int r5 = Integer.MIN_VALUE == null ? 0 : i3;
        if (i3 == 0) {
            dVar32.L$0 = dVar34;
            Object obj3 = null;
            dVar32.L$1 = obj3;
            dVar32.L$2 = obj3;
            dVar32.L$3 = obj3;
            dVar32.label = i4;
            dVar34 = j1Var.s(str4, str3, dVar32);
            if (dVar34 == obj2) {
                return obj2;
            }
        } else {
        }
    }

    public final Object t(String str, String str2, String str3, kotlin.b0.d<? super List<ProgramProgress.ExamSubmission>> dVar) {
        Object dVar42;
        int label2;
        int i = -2147483648;
        int i2;
        Object examHistory;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.j1.k;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.j1.k) {
            dVar42 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar42.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.k kVar = new app.dogo.com.dogo_android.repository.local.j1.k(this, dVar);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (dVar42.label != 0) {
            if (dVar42.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar42.result);
                return (ExamHistoryResponse)examHistory.getExamHistory();
            }
        }
        q.b(dVar42.result);
        dVar42.label = i3;
        if (this.apiClient.getExamHistory(str, str2, str3, dVar42) == obj) {
            return obj;
        }
    }

    public final LiveData<Boolean> u() {
        return this.tricksRepository;
    }

    public final Object v(String str, kotlin.b0.d<? super k.c> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        int i2;
        Object result2;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.j1.l;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.j1.l) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.l lVar = new app.dogo.com.dogo_android.repository.local.j1.l(this, dVar);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar22.result);
                return (AllDogoPrograms)result2.e();
            }
        }
        q.b(dVar22.result);
        dVar22.label = i3;
        if (o(str, dVar22) == obj) {
            return obj;
        }
    }

    public final void w() {
        this.tracker.d().e();
    }

    public final void y() {
        this.tricksRepository.postValue(Boolean.FALSE);
    }

    public final Object z(String str, String str2, String str3, String str4, kotlin.b0.d<? super app.dogo.com.dogo_android.y.k> dVar) {
        Object dVar52;
        int label2;
        DogoApiClient apiClient2;
        int i = -2147483648;
        String str5;
        int i2;
        String str22;
        String str32;
        String str42;
        String str6;
        app.dogo.com.dogo_android.s.b.j1 j1Var;
        Object detectProgramCompletion;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.j1.m;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.j1.m) {
            dVar52 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar52.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.j1.m mVar = new app.dogo.com.dogo_android.repository.local.j1.m(this, dVar);
            }
        }
        final Object obj2 = b.d();
        final int i4 = 2;
        int i3 = 1;
        if (dVar52.label != 0) {
            if (dVar52.label != i3) {
                if (dVar52.label != i4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(dVar52.result);
                    return detectProgramCompletion;
                }
            }
            q.b(dVar52.result);
        } else {
            q.b(dVar52.result);
            dVar52.L$0 = this;
            dVar52.L$1 = str;
            dVar52.label = i3;
            if (this.apiClient.saveExamUpload(str, str2, str3, str4, dVar52) == obj2) {
                return obj2;
            }
            j1Var = this;
        }
        m.b programProgressWrapper_ClassicProgramProgress = new ProgramProgressWrapper_ClassicProgramProgress((ClassicProgramResponse)detectProgramCompletion.getProgress());
        j1Var.detectLessonCompletion(str6, programProgressWrapper_ClassicProgramProgress);
        Object obj = null;
        dVar52.L$0 = obj;
        dVar52.L$1 = obj;
        dVar52.label = i4;
        return j1Var.detectProgramCompletion(programProgressWrapper_ClassicProgramProgress, dVar52) == obj2 ? obj2 : detectProgramCompletion;
    }

    public /* synthetic */ j1(DogoApiClient dogoApiClient, o3 o3Var, v2 v2Var, o1 o1Var, f1 f1Var, i1 i1Var, m0 m0Var, int i, kotlin.d0.d.g gVar) {
        Object m0Var72;
        r1 r1Var = i & 64 != 0 ? r1Var : m0Var;
        this(dogoApiClient, o3Var, v2Var, o1Var, f1Var, i1Var, m0Var72);
    }
}
