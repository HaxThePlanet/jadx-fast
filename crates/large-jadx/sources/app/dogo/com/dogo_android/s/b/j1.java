package app.dogo.com.dogo_android.s.b;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.android.network.DogoApiClient;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.LessonModel;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel.ModuleModel;
import app.dogo.com.dogo_android.n.m.t.h;
import app.dogo.com.dogo_android.n.m.t.h.b;
import app.dogo.com.dogo_android.n.m.t.i;
import app.dogo.com.dogo_android.n.m.t.i.a;
import app.dogo.com.dogo_android.n.m.t.i.b;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.h;
import app.dogo.com.dogo_android.util.z;
import app.dogo.com.dogo_android.w.e2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q0;
import app.dogo.com.dogo_android.w.q3;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.w1;
import app.dogo.com.dogo_android.y.i;
import app.dogo.com.dogo_android.y.k;
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
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.q;
import kotlin.w;
import kotlin.y.j0;
import kotlin.y.p;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.r1;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\r\u0018\u0000 Z2\u00020\u0001:\u0002Z[B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0008\u0008\u0002\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u001a\u0010 \u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J!\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0019\u0010.\u001a\u00020/2\u0006\u0010$\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J\u001f\u00100\u001a\u0008\u0012\u0004\u0012\u00020\u001c012\u0006\u0010$\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0019\u00102\u001a\u0002032\u0006\u0010$\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J!\u00104\u001a\u0002052\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010(J!\u00106\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010(J/\u00107\u001a\u0008\u0012\u0004\u0012\u000208012\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010:J\u000c\u0010;\u001a\u0008\u0012\u0004\u0012\u00020\u00130<J\u0019\u0010=\u001a\u00020>2\u0006\u0010$\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0006\u0010?\u001a\u00020#J\u001c\u0010@\u001a\u00020#2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0002J\u0006\u0010A\u001a\u00020#J1\u0010B\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010DJ\u0018\u0010E\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001b\u0010F\u001a\u0004\u0018\u00010\u00172\u0006\u0010+\u001a\u00020GH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010HJ&\u0010I\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u001cJ1\u0010J\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010DJ\u0019\u0010K\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u001cH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010%J)\u0010L\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u00109\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010:J9\u0010M\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\n\u0008\u0002\u0010N\u001a\u0004\u0018\u00010O2\n\u0008\u0002\u0010P\u001a\u0004\u0018\u00010OH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010QJ9\u0010R\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001c2\u0006\u0010U\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010VJ?\u0010W\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001c2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010S\u001a\u00020\u001c2\u0006\u0010T\u001a\u00020\u001c2\u000c\u0010X\u001a\u0008\u0012\u0004\u0012\u00020\u001c01H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010YR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\\", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "dogLogRepository", "Lapp/dogo/com/dogo_android/repository/local/DogLogRepository;", "programContentRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;", "externalScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/repository/local/DogLogRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;Lkotlinx/coroutines/CoroutineScope;)V", "lessonCompletion", "Landroidx/lifecycle/MutableLiveData;", "", "programAppState", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository$ProgramStateHolder;", "convertWrapperToDogoProgram", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram;", "wrapper", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper;", "(Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "detectLessonCompletion", "", "oldState", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "newState", "detectLessonMastery", "detectProgramCompletion", "doInitialProgramSyncIfNeeded", "", "dogId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ensureProgramIsActive", "programId", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findTrickLesson", "Lapp/dogo/com/dogo_android/repository/domain/ProgramSaveInfo;", "rating", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$ClassicProgram;", "(Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating$ClassicProgram;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPrograms", "Lapp/dogo/com/dogo_android/trainingprogram/AllDogoPrograms;", "getAllStartedPrograms", "", "getBitingProgram", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$BitingProgram;", "getClassicProgram", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$ClassicProgram;", "getClassicProgramProgressRemote", "getExamHistory", "Lapp/dogo/externalmodel/model/responses/ProgramProgress$ExamSubmission;", "trickId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLessonCompletionLiveData", "Landroidx/lifecycle/LiveData;", "getPottyProgramProgress", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$PottyProgram;", "invalidateCache", "processProgramChanges", "resetLessonCompletion", "saveExamUpload", "examId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveProgressResponseToCache", "saveTrickKnowledge", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;", "(Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveUserExamFeedbackInBackground", "saveUsersExamFeedbackGiven", "syncProgressFromRemote", "updateExamReviewed", "updateProgramState", "startTimeMs", "", "stopTimeMs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateQuestionState", "moduleId", "lessonId", "questionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTaskState", "taskIds", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ProgramStateHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j1 {

    public static final app.dogo.com.dogo_android.s.b.j1.a Companion;
    private static final long j;
    private final DogoApiClient a;
    private final o3 b;
    private final v2 c;
    private final app.dogo.com.dogo_android.s.b.o1 d;
    private final app.dogo.com.dogo_android.s.b.f1 e;
    private final app.dogo.com.dogo_android.s.b.i1 f;
    private final m0 g;
    private final app.dogo.com.dogo_android.s.b.j1.b h;
    private final x<Boolean> i;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\u00020\u00082\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0008R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0013", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ProgramRepository$Companion;", "", "()V", "BITING_PROGRAM_ID", "", "CLASSIC_PROGRAM_TYPE", "POTTY_PROGRAM_ID", "PROGRAM_WITH_EXAM_CACHE_LIFETIME", "", "getPROGRAM_WITH_EXAM_CACHE_LIFETIME", "()J", "convertRatingResultToProgramWrapper", "Lapp/dogo/com/dogo_android/trainingprogram/ProgramProgressWrapper;", "rating", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults;", "getTrainingDurationInSeconds", "knowledge", "", "trickTimeInSeconds", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public static final m a(app.dogo.com.dogo_android.s.b.j1.a j1$a, i i2) {
            return a.b(i2);
        }

        private final m b(i i) {
            m.b bVar;
            ProgramProgress obj2;
            if (i instanceof i.a) {
                bVar = new m.a((i.a)i.b());
                return bVar;
            } else {
                if (i instanceof i.b) {
                    bVar = new m.b((i.b)i.b());
                } else {
                    if (!i instanceof i.c) {
                    } else {
                        bVar = 0;
                    }
                }
            }
            obj2 = new NoWhenBranchMatchedException();
            throw obj2;
        }

        public final long c() {
            return j1.e();
        }

        public final long d(int i, long l2) {
            long i2;
            int i3;
            int obj3;
            int obj4;
            if (i != 3) {
                i2 = 4;
                if (i != i2 && i != 5) {
                    if (i != 5) {
                    } else {
                        l2 /= i2;
                    }
                } else {
                }
            } else {
                l2 /= i2;
            }
            return obj4;
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\nR\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u001d\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0007R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0007¨\u0006\u0016", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ProgramRepository$ProgramStateHolder;", "", "()V", "bitingProgram", "Lapp/dogo/com/dogo_android/util/SimpleSessionCache;", "Lapp/dogo/externalmodel/model/BitingProgressModel;", "getBitingProgram", "()Lapp/dogo/com/dogo_android/util/SimpleSessionCache;", "classicPrograms", "", "", "Lapp/dogo/com/dogo_android/util/ClassicProgramCache;", "getClassicPrograms", "()Ljava/util/Map;", "pottyProgram", "Lapp/dogo/externalmodel/model/PottyProgramProgressModel$ProgramStatus;", "getPottyProgram", "programSyncState", "", "getProgramSyncState", "isProgramSynced", "dogId", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class b {

        private final z<PottyProgramProgressModel.ProgramStatus> a;
        private final z<BitingProgressModel> b;
        private final Map<String, h> c;
        private final z<Boolean> d;
        public b() {
            super();
            final int i = -1;
            z zVar = new z(i, obj2);
            this.a = zVar;
            z zVar2 = new z(i, obj2);
            this.b = zVar2;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            this.c = linkedHashMap;
            z zVar3 = new z(i, obj2);
            this.d = zVar3;
        }

        public final z<BitingProgressModel> a() {
            return this.b;
        }

        public final Map<String, h> b() {
            return this.c;
        }

        public final z<PottyProgramProgressModel.ProgramStatus> c() {
            return this.a;
        }

        public final z<Boolean> d() {
            return this.d;
        }

        public final boolean e(String string) {
            n.f(string, "dogId");
            return n.b(this.d.a(string, 0), Boolean.TRUE);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {270, 274, 278}, m = "convertWrapperToDogoProgram")
    static final class c extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        c(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.c> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return j1.a(this.this$0, 0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {256, 262}, m = "ensureProgramIsActive")
    static final class d extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        d(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.d> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return j1.b(this.this$0, i2, i2, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = 159, m = "findTrickLesson")
    static final class e extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        e(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.e> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return j1.c(this.this$0, 0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {201, 202, 203, 204, 205}, m = "getAllPrograms")
    static final class f extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        f(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.f> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.o(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = 196, m = "getAllStartedPrograms")
    static final class g extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        g(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.g> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.p(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = 229, m = "getBitingProgram")
    static final class h extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        h(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.h> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.q(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {181, 186, 188}, m = "getClassicProgram")
    static final class i extends d {

        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        i(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.i> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return this.this$0.r(i2, i2, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = 291, m = "getClassicProgramProgressRemote")
    static final class j extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        j(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.j> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return j1.d(this.this$0, i2, i2, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = 148, m = "getExamHistory")
    static final class k extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        k(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.k> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return this.this$0.t(i2, i2, i2, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = 233, m = "getPottyProgramProgress")
    static final class l extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        l(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.l> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.v(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {141, 144}, m = "saveExamUpload")
    static final class m extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        m(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.m> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj7 |= i;
            return this.this$0.z(0, 0, 0, 0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {117, 129, 133, 134}, m = "saveTrickKnowledge")
    static final class n extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        n(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.n> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.B(0, this);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class o extends a implements CoroutineExceptionHandler {
        public o(CoroutineExceptionHandler.a coroutineExceptionHandler$a) {
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            a.d(throwable2);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {174, 177}, m = "saveUsersExamFeedbackGiven")
    static final class q extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        q(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.q> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj7 |= i;
            return j1.f(this.this$0, 0, 0, 0, 0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = 371, m = "syncProgressFromRemote")
    static final class r extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        r(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.r> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return j1.g(this.this$0, 0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {152, 155}, m = "updateExamReviewed")
    static final class s extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        s(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.s> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return this.this$0.F(i2, i2, i2, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {99, 103, 107, 112}, m = "updateProgramState")
    static final class t extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        t(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.t> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj7 |= i;
            return this.this$0.G(0, 0, 0, 0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {78, 88, 89}, m = "updateQuestionState")
    static final class u extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        u(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.u> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj8 |= i;
            return this.this$0.I(0, 0, 0, 0, 0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository", f = "ProgramRepository.kt", l = {63, 73, 74}, m = "updateTaskState")
    static final class v extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        v(app.dogo.com.dogo_android.s.b.j1 j1, d<? super app.dogo.com.dogo_android.s.b.j1.v> d2) {
            this.this$0 = j1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj8 |= i;
            return this.this$0.J(0, 0, 0, 0, 0, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramRepository$saveUserExamFeedbackInBackground$1", f = "ProgramRepository.kt", l = 58, m = "invokeSuspend")
    static final class p extends k implements p<m0, d<? super w>, Object> {

        final String $dogId;
        final String $examId;
        final String $programId;
        final String $trickId;
        int label;
        final app.dogo.com.dogo_android.s.b.j1 this$0;
        p(app.dogo.com.dogo_android.s.b.j1 j1, String string2, String string3, String string4, String string5, d<? super app.dogo.com.dogo_android.s.b.j1.p> d6) {
            this.this$0 = j1;
            this.$dogId = string2;
            this.$programId = string3;
            this.$trickId = string4;
            this.$examId = string5;
            super(2, d6);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (j1.p)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            super(this.this$0, this.$dogId, this.$programId, this.$trickId, this.$examId, d2);
            return obj8;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label;
            int i;
            String $programId;
            String $trickId;
            String $examId;
            Object obj;
            Object obj8;
            Object obj2 = b.d();
            label = this.label;
            i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    q.b(object);
                    return w.a;
                }
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
            }
            q.b(object);
            this.label = i;
            if (j1.f(this.this$0, this.$dogId, this.$programId, this.$trickId, this.$examId, this) == obj2) {
                return obj2;
            }
        }
    }
    static {
        j1.a aVar = new j1.a(0);
        j1.Companion = aVar;
        j1.j = TimeUnit.MINUTES.toMillis(5);
    }

    public j1(DogoApiClient dogoApiClient, o3 o32, v2 v23, app.dogo.com.dogo_android.s.b.o1 o14, app.dogo.com.dogo_android.s.b.f1 f15, app.dogo.com.dogo_android.s.b.i1 i16, m0 m07) {
        n.f(dogoApiClient, "apiClient");
        n.f(o32, "tracker");
        n.f(v23, "timeUtils");
        n.f(o14, "tricksRepository");
        n.f(f15, "dogLogRepository");
        n.f(i16, "programContentRepository");
        n.f(m07, "externalScope");
        super();
        this.a = dogoApiClient;
        this.b = o32;
        this.c = v23;
        this.d = o14;
        this.e = f15;
        this.f = i16;
        this.g = m07;
        j1.b obj2 = new j1.b();
        this.h = obj2;
        obj2 = new x();
        this.i = obj2;
    }

    public j1(DogoApiClient dogoApiClient, o3 o32, v2 v23, app.dogo.com.dogo_android.s.b.o1 o14, app.dogo.com.dogo_android.s.b.f1 f15, app.dogo.com.dogo_android.s.b.i1 i16, m0 m07, int i8, g g9) {
        r1 i;
        r1 r1Var;
        r1Var = i8 & 64 != 0 ? i : m07;
        super(dogoApiClient, o32, v23, o14, f15, i16, r1Var);
    }

    private final void A(String string, m m2) {
        long l;
        String str;
        Object hVar;
        ProgramProgress programProgress;
        Object obj6;
        Object obj7;
        l = this.c.g();
        if (m2 instanceof m.b) {
            str = (m.b)m2.b().getId();
            if ((h)this.h.b().get(str) == null) {
                hVar = new h();
            }
            hVar.f(string, l, obj1);
            this.h.b().put(str, hVar);
            x(hVar.j(string), hVar.j(string));
        } else {
            if (m2 instanceof m.a) {
                this.h.a().f(string, l, obj1);
            } else {
                if (m2 instanceof m.c) {
                    this.h.c().f(string, l, obj1);
                    this.e.k(string, m2.b().getLogs());
                }
            }
        }
    }

    private final Object D(String string, String string2, String string3, String string4, d<? super k> d5) {
        boolean qVar2;
        int label2;
        DogoApiClient label;
        int i2;
        Object i3;
        int i;
        String str2;
        String str;
        app.dogo.com.dogo_android.s.b.j1.q qVar;
        int obj10;
        Object obj11;
        m.b obj12;
        ProgramProgress obj13;
        Object obj14;
        qVar2 = d5;
        label2 = qVar2.label;
        i2 = Integer.MIN_VALUE;
        if (d5 instanceof j1.q && label2 & i2 != 0) {
            qVar2 = d5;
            label2 = qVar2.label;
            i2 = Integer.MIN_VALUE;
            if (label2 & i2 != 0) {
                qVar2.label = label2 -= i2;
            } else {
                qVar2 = new j1.q(this, d5);
            }
        } else {
        }
        obj14 = qVar2.result;
        final Object obj = b.d();
        label = qVar2.label;
        final int i4 = 2;
        i3 = 1;
        if (label != 0) {
            if (label != i3) {
                if (label != i4) {
                } else {
                    q.b(obj14);
                    return obj14;
                }
                obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj10;
            }
            obj10 = qVar2.L$1;
            obj11 = qVar2.L$0;
            q.b(obj14);
        } else {
            q.b(obj14);
            qVar2.L$0 = this;
            qVar2.L$1 = string;
            qVar2.label = i3;
            if (this.a.updateExamUserFeedback(string, string2, string3, string4, qVar2) == obj) {
                return obj;
            }
            obj11 = this;
        }
        obj12 = new m.b((ClassicProgramResponse)obj14.getProgress());
        obj11.A(obj10, obj12);
        obj10 = 0;
        qVar2.L$0 = obj10;
        qVar2.L$1 = obj10;
        qVar2.label = i4;
        if (obj11.h(obj12, qVar2) == obj) {
            return obj;
        }
    }

    private final Object E(String string, d<? super app.dogo.com.dogo_android.s.b.j1.b> d2) {
        boolean rVar;
        Object l$0;
        int label;
        Object id_nipping_program;
        int i;
        int label2;
        boolean aVar;
        int i2;
        m.b bVar;
        Object obj6;
        Object obj7;
        rVar = d2;
        label = rVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof j1.r && label & i != 0) {
            rVar = d2;
            label = rVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                rVar.label = label -= i;
            } else {
                rVar = new j1.r(this, d2);
            }
        } else {
        }
        obj7 = rVar.result;
        Object obj = b.d();
        label2 = rVar.label;
        int i4 = 1;
        if (label2 != 0) {
            if (label2 != i4) {
            } else {
                obj6 = rVar.L$1;
                l$0 = rVar.L$0;
                q.b(obj7);
                Iterator iterator = (AllProgramProgressResponse)obj7.getClassic().values().iterator();
                for (ProgramProgress label2 : iterator) {
                    bVar = new m.b(label2);
                    l$0.A(obj6, bVar);
                }
                id_nipping_program = obj7.getSpecial().getId_nipping_program();
                if (id_nipping_program == null) {
                } else {
                    aVar = new m.a(id_nipping_program);
                    l$0.A(obj6, aVar);
                }
                obj7 = obj7.getSpecial().getId_potty_program();
                if (obj7 == null) {
                } else {
                    id_nipping_program = new m.c(obj7);
                    l$0.A(obj6, id_nipping_program);
                }
                l$0.h.d().f(obj6, 0, aVar);
                return l$0.h;
            }
            obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj6;
        }
        q.b(obj7);
        rVar.L$0 = this;
        rVar.L$1 = string;
        rVar.label = i4;
        if (this.a.getAllProgramProgress(string, rVar) == obj) {
            return obj;
        }
        l$0 = this;
    }

    public static Object H(app.dogo.com.dogo_android.s.b.j1 j1, String string2, String string3, Long long4, Long long5, d d6, int i7, Object object8) {
        int i;
        int i2;
        final int i3 = 0;
        i = i7 & 4 != 0 ? i3 : long4;
        i2 = i7 & 8 != 0 ? i3 : long5;
        return j1.G(string2, string3, i, i2, d6);
    }

    public static final Object a(app.dogo.com.dogo_android.s.b.j1 j1, m m2, d d3) {
        return j1.h(m2, d3);
    }

    public static final Object b(app.dogo.com.dogo_android.s.b.j1 j1, String string2, String string3, d d4) {
        return j1.m(string2, string3, d4);
    }

    public static final Object c(app.dogo.com.dogo_android.s.b.j1 j1, h.b h$b2, d d3) {
        return j1.n(b2, d3);
    }

    public static final Object d(app.dogo.com.dogo_android.s.b.j1 j1, String string2, String string3, d d4) {
        return j1.s(string2, string3, d4);
    }

    public static final long e() {
        return j1.j;
    }

    public static final Object f(app.dogo.com.dogo_android.s.b.j1 j1, String string2, String string3, String string4, String string5, d d6) {
        return j1.D(string2, string3, string4, string5, d6);
    }

    public static final Object g(app.dogo.com.dogo_android.s.b.j1 j1, String string2, d d3) {
        return j1.E(string2, d3);
    }

    private final Object h(m m, d<? super k> d2) {
        boolean cVar2;
        k cVar;
        int label2;
        int i2;
        String label;
        int i;
        Object obj7;
        Object obj8;
        cVar2 = d2;
        label2 = cVar2.label;
        i2 = Integer.MIN_VALUE;
        if (d2 instanceof j1.c && label2 & i2 != 0) {
            cVar2 = d2;
            label2 = cVar2.label;
            i2 = Integer.MIN_VALUE;
            if (label2 & i2 != 0) {
                cVar2.label = label2 -= i2;
            } else {
                cVar2 = new j1.c(this, d2);
            }
        } else {
        }
        obj8 = cVar2.result;
        Object obj = b.d();
        label = cVar2.label;
        int i3 = 3;
        final int i4 = 2;
        final int i5 = 1;
        if (label != 0) {
            if (label != i5) {
                if (label != i4) {
                    if (label != i3) {
                    } else {
                        obj7 = cVar2.L$0;
                        q.b(obj8);
                        cVar = new k.c((ProgramModel)obj8, (m.c)obj7.b());
                    }
                    obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj7;
                }
                obj7 = cVar2.L$0;
                q.b(obj8);
                cVar = new k.b((ProgramModel)obj8, (m.b)obj7.b());
            } else {
                obj7 = cVar2.L$0;
                q.b(obj8);
                cVar = new k.a((ProgramModel)obj8, (m.a)obj7.b());
            }
            return cVar;
        } else {
            q.b(obj8);
            if (m instanceof m.a) {
                cVar2.L$0 = m;
                cVar2.label = i5;
                if (this.f.g("id_nipping_program", cVar2) == obj) {
                    return obj;
                }
            } else {
                if (m instanceof m.b) {
                    cVar2.L$0 = m;
                    cVar2.label = i4;
                    if (this.f.g((m.b)m.b().getId(), cVar2) == obj) {
                        return obj;
                    }
                } else {
                    if (!m instanceof m.c) {
                    } else {
                        cVar2.L$0 = m;
                        cVar2.label = i3;
                        if (this.f.g("id_potty_program", cVar2) == obj) {
                            return obj;
                        }
                    }
                }
            }
        }
        obj7 = new NoWhenBranchMatchedException();
        throw obj7;
    }

    private final String i(ProgramProgress programProgress, ProgramProgress programProgress2) {
        Object lessons2;
        boolean next2;
        int i3;
        boolean next4;
        int i;
        boolean passed2;
        int i2;
        boolean next;
        boolean next3;
        Object lessons;
        boolean passed;
        ArrayList obj7;
        ArrayList arrayList = new ArrayList();
        Iterator obj6 = programProgress.getModules().iterator();
        while (obj6.hasNext()) {
            lessons2 = obj6.next();
            if ((ProgramProgress.ModuleProgress)lessons2 == null) {
            } else {
            }
            lessons2 = (ProgramProgress.ModuleProgress)lessons2.getLessons();
            if (lessons2 == null) {
            } else {
            }
            i = p.U(lessons2);
            if (i == 0) {
            }
            p.y(arrayList, i);
            i = p.g();
        }
        obj6 = new ArrayList();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            next2 = iterator.next();
            if ((ProgramProgress.LessonProgress)next2.isPassed()) {
            }
            obj6.add(next2);
        }
        int i4 = 10;
        ArrayList arrayList2 = new ArrayList(p.r(obj6, i4));
        obj6 = obj6.iterator();
        for (ProgramProgress.LessonProgress next8 : obj6) {
            arrayList2.add(next8.getId());
        }
        obj7 = new ArrayList();
        obj6 = programProgress2.getModules().iterator();
        while (obj6.hasNext()) {
            lessons = obj6.next();
            if ((ProgramProgress.ModuleProgress)lessons == null) {
            } else {
            }
            lessons = (ProgramProgress.ModuleProgress)lessons.getLessons();
            if (lessons == null) {
            } else {
            }
            next = p.U(lessons);
            if (next == null) {
            }
            p.y(obj7, next);
            next = p.g();
            next = i;
        }
        obj6 = new ArrayList();
        obj7 = obj7.iterator();
        while (obj7.hasNext()) {
            next3 = obj7.next();
            if ((ProgramProgress.LessonProgress)next3.isPassed()) {
            }
            obj6.add(next3);
        }
        obj7 = new ArrayList(p.r(obj6, i4));
        obj6 = obj6.iterator();
        for (ProgramProgress.LessonProgress next6 : obj6) {
            obj7.add(next6.getId());
        }
        obj6 = obj7.iterator();
        while (obj6.hasNext()) {
            obj7 = obj6.next();
            if (contains ^= 1) {
                break;
            } else {
            }
        }
        return (String)i;
    }

    private final String j(ProgramProgress programProgress, ProgramProgress programProgress2) {
        Object lessons2;
        boolean next3;
        int i2;
        boolean next;
        int i;
        boolean mastered2;
        int i3;
        boolean next2;
        boolean next4;
        Object lessons;
        boolean mastered;
        ArrayList obj7;
        ArrayList arrayList = new ArrayList();
        Iterator obj6 = programProgress.getModules().iterator();
        while (obj6.hasNext()) {
            lessons2 = obj6.next();
            if ((ProgramProgress.ModuleProgress)lessons2 == null) {
            } else {
            }
            lessons2 = (ProgramProgress.ModuleProgress)lessons2.getLessons();
            if (lessons2 == null) {
            } else {
            }
            i = p.U(lessons2);
            if (i == 0) {
            }
            p.y(arrayList, i);
            i = p.g();
        }
        obj6 = new ArrayList();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            next3 = iterator.next();
            if ((ProgramProgress.LessonProgress)next3.isMastered()) {
            }
            obj6.add(next3);
        }
        int i4 = 10;
        ArrayList arrayList2 = new ArrayList(p.r(obj6, i4));
        obj6 = obj6.iterator();
        for (ProgramProgress.LessonProgress next8 : obj6) {
            arrayList2.add(next8.getId());
        }
        obj7 = new ArrayList();
        obj6 = programProgress2.getModules().iterator();
        while (obj6.hasNext()) {
            lessons = obj6.next();
            if ((ProgramProgress.ModuleProgress)lessons == null) {
            } else {
            }
            lessons = (ProgramProgress.ModuleProgress)lessons.getLessons();
            if (lessons == null) {
            } else {
            }
            next2 = p.U(lessons);
            if (next2 == null) {
            }
            p.y(obj7, next2);
            next2 = p.g();
            next2 = i;
        }
        obj6 = new ArrayList();
        obj7 = obj7.iterator();
        while (obj7.hasNext()) {
            next4 = obj7.next();
            if ((ProgramProgress.LessonProgress)next4.isMastered()) {
            }
            obj6.add(next4);
        }
        obj7 = new ArrayList(p.r(obj6, i4));
        obj6 = obj6.iterator();
        for (ProgramProgress.LessonProgress next6 : obj6) {
            obj7.add(next6.getId());
        }
        obj6 = obj7.iterator();
        while (obj6.hasNext()) {
            obj7 = obj6.next();
            if (contains ^= 1) {
                break;
            } else {
            }
        }
        return (String)i;
    }

    private final boolean k(ProgramProgress programProgress, ProgramProgress programProgress2) {
        boolean obj1;
        if (!programProgress.isPassed() && programProgress2.isPassed()) {
            obj1 = programProgress2.isPassed() ? 1 : 0;
        } else {
        }
        return obj1;
    }

    private final Object l(String string, d<? super w> d2) {
        Object obj1 = o(string, d2);
        if (obj1 == b.d()) {
            return obj1;
        }
        return w.a;
    }

    private final Object m(String string, String string2, d<? super w> d3) {
        boolean dVar;
        Object e2Var;
        int label2;
        app.dogo.com.dogo_android.s.b.j1 label;
        int i7;
        Object i2;
        int i4;
        Object i3;
        Object obj;
        int i5;
        int i;
        int i6;
        Object obj2;
        Object obj11;
        Object obj12;
        u2 obj13;
        dVar = d3;
        label2 = dVar.label;
        i7 = Integer.MIN_VALUE;
        if (d3 instanceof j1.d && label2 & i7 != 0) {
            dVar = d3;
            label2 = dVar.label;
            i7 = Integer.MIN_VALUE;
            if (label2 & i7 != 0) {
                dVar.label = label2 -= i7;
            } else {
                dVar = new j1.d(this, d3);
            }
        } else {
        }
        final app.dogo.com.dogo_android.s.b.j1.d dVar2 = dVar;
        obj13 = dVar2.result;
        e2Var = b.d();
        label = dVar2.label;
        i2 = 2;
        i3 = 1;
        if (label != 0) {
            if (label != i3) {
                if (label != i2) {
                } else {
                    obj11 = dVar2.L$1;
                    obj12 = dVar2.L$0;
                    q.b(obj13);
                    e2Var = new e2();
                    obj12.b.d(q0.g.c(e2Var, obj11));
                    return w.a;
                }
                obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj11;
            }
            obj12 = obj11;
            q.b(obj13);
            obj = obj11;
            obj11 = label;
        } else {
            q.b(obj13);
            dVar2.L$0 = this;
            dVar2.L$1 = string;
            dVar2.L$2 = string2;
            dVar2.label = i3;
            if (o(string, dVar2) == e2Var) {
                return e2Var;
            }
            obj = string;
            obj11 = this;
        }
        label = (k.b)(i)obj13.d().get(obj12) != null ? i3 : 0;
        dVar2.L$0 = obj11;
        dVar2.L$1 = obj12;
        dVar2.L$2 = 0;
        dVar2.label = i2;
        if (label != 0 && obj13 ^= i3 != 0 && j1.H(obj11, obj, obj12, b.d(obj11.c.g()), 0, dVar2, 8, 0) == e2Var) {
            if (obj13 ^= i3 != 0) {
                dVar2.L$0 = obj11;
                dVar2.L$1 = obj12;
                dVar2.L$2 = 0;
                dVar2.label = i2;
                if (j1.H(obj11, obj, obj12, b.d(obj11.c.g()), 0, dVar2, 8, 0) == e2Var) {
                    return e2Var;
                }
                obj12 = obj11;
                obj11 = obj2;
            }
        }
    }

    private final Object n(h.b h$b, d<? super ProgramSaveInfo> d2) {
        boolean eVar;
        Object obj2;
        int label;
        Object obj;
        int i;
        int booleanValue;
        Object iterator;
        int i3;
        int booleanValue2;
        boolean booleanValue3;
        int i2;
        String str;
        Object obj8;
        Object obj9;
        eVar = d2;
        label = eVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof j1.e && label & i != 0) {
            eVar = d2;
            label = eVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                eVar.label = label -= i;
            } else {
                eVar = new j1.e(this, d2);
            }
        } else {
        }
        obj9 = eVar.result;
        obj = b.d();
        booleanValue = eVar.label;
        booleanValue2 = 1;
        if (booleanValue != 0) {
            if (booleanValue != booleanValue2) {
            } else {
                obj8 = eVar.L$0;
                q.b(obj9);
                obj9 = (ProgramModel)obj9.getModules().iterator();
                obj = null;
                while (obj9.hasNext()) {
                    iterator = (ProgramModel.ModuleModel)obj9.next().getLessons();
                    i2 = 0;
                    if (iterator instanceof Collection != null && iterator.isEmpty()) {
                    } else {
                    }
                    iterator = iterator.iterator();
                    while (iterator.hasNext()) {
                        if (b.a((ProgramModel.LessonModel)iterator.next().getTricks().containsKey(obj8.c())).booleanValue()) {
                            break loop_16;
                        } else {
                        }
                    }
                    obj = null;
                    if (b.a((ProgramModel.LessonModel)iterator.next().getTricks().containsKey(obj8.c())).booleanValue()) {
                    } else {
                    }
                    i2 = booleanValue2;
                    if (iterator.isEmpty()) {
                    } else {
                    }
                }
                eVar = obj;
                if ((ProgramModel.ModuleModel)eVar == null) {
                    booleanValue = obj;
                    if ((ProgramModel.ModuleModel)eVar == null) {
                        obj2 = obj;
                    } else {
                        obj2 = (ProgramModel.ModuleModel)eVar.getId();
                    }
                    if (obj2 == null) {
                        obj2 = obj8.e();
                    }
                    if (booleanValue == 0) {
                    } else {
                        obj = booleanValue.getId();
                    }
                    if (obj == null) {
                        obj = obj8.d();
                    }
                    obj8 = new ProgramSaveInfo(obj8.f(), obj2, obj, obj8.a());
                    return obj8;
                } else {
                }
                obj8 = new NoSuchElementException("Collection contains no element matching the predicate.");
                throw obj8;
            }
            obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj8;
        }
        q.b(obj9);
        eVar.L$0 = b;
        eVar.label = booleanValue2;
        if (this.f.g(b.f(), eVar) == obj) {
            return obj;
        }
    }

    private final Object s(String string, String string2, d<? super ProgramProgress> d3) {
        boolean jVar;
        int label;
        int i;
        int i2;
        Object obj5;
        Object obj6;
        Object obj7;
        jVar = d3;
        label = jVar.label;
        i = Integer.MIN_VALUE;
        if (d3 instanceof j1.j && label & i != 0) {
            jVar = d3;
            label = jVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                jVar.label = label -= i;
            } else {
                jVar = new j1.j(this, d3);
            }
        } else {
        }
        obj7 = jVar.result;
        Object obj = b.d();
        int label2 = jVar.label;
        int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                obj5 = jVar.L$1;
                obj6 = jVar.L$0;
                q.b(obj7);
                m.b bVar = new m.b((ClassicProgramResponse)obj7.getProgress());
                obj6.A(obj5, bVar);
                return bVar.b();
            }
            obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj7);
        jVar.L$0 = this;
        jVar.L$1 = string;
        jVar.label = i3;
        if (this.a.getProgramProgress(string, string2, jVar) == obj) {
            return obj;
        }
        obj6 = this;
    }

    private final void x(ProgramProgress programProgress, ProgramProgress programProgress2) {
        Object str;
        Object e2Var;
        o3 o3Var;
        u2 w1Var;
        w1 w1Var2;
        ProgramProgress obj6;
        Object obj7;
        str = i(programProgress, programProgress2);
        e2Var = j(programProgress, programProgress2);
        if (programProgress != null && programProgress2 != null && str != null) {
            if (programProgress2 != null) {
                str = i(programProgress, programProgress2);
                e2Var = j(programProgress, programProgress2);
                if (str != null) {
                    w1Var2 = new w1();
                    this.b.d(q0.k.c(w1Var2, str));
                }
                if (e2Var != null) {
                    w1Var = new w1();
                    this.b.d(q0.l.c(w1Var, e2Var));
                    this.i.postValue(Boolean.TRUE);
                }
                if (k(programProgress, programProgress2)) {
                    e2Var = new e2();
                    this.b.d(q0.A.c(e2Var, programProgress2.getId()));
                }
            }
        }
    }

    public final Object B(h h, d<? super k> d2) {
        Object l$1;
        Object result;
        Object obj2;
        boolean nVar;
        int label2;
        int i4;
        Object label;
        int i;
        int companion;
        int bVar;
        int i3;
        h.b bVar2;
        String str;
        int i2;
        String str2;
        String programId;
        String moduleId;
        String lessonId;
        Object obj;
        final app.dogo.com.dogo_android.s.b.j1 j1Var = this;
        l$1 = h;
        Object obj5 = d2;
        nVar = obj5;
        label2 = nVar.label;
        i4 = Integer.MIN_VALUE;
        if (obj5 instanceof j1.n && label2 & i4 != 0) {
            nVar = obj5;
            label2 = nVar.label;
            i4 = Integer.MIN_VALUE;
            if (label2 & i4 != 0) {
                nVar.label = label2 -= i4;
            } else {
                nVar = new j1.n(j1Var, obj5);
            }
        } else {
        }
        result = nVar.result;
        Object obj7 = b.d();
        label = nVar.label;
        int i5 = 4;
        final int i6 = 3;
        companion = 2;
        bVar = 1;
        i3 = 0;
        if (label != 0) {
            if (label != bVar) {
                if (label != companion) {
                    if (label != i6) {
                        if (label != i5) {
                        } else {
                            q.b(result);
                            i3 = result;
                        }
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw illegalStateException;
                    }
                    l$1 = nVar.L$1;
                    label = nVar.L$0;
                    q.b(result);
                    nVar.L$0 = i3;
                    nVar.L$1 = i3;
                    nVar.label = i5;
                    if (label.h(l$1, nVar) == obj7) {
                        return obj7;
                    }
                } else {
                    l$1 = nVar.L$1;
                    label = nVar.L$0;
                    q.b(result);
                    result = j1.a.a(j1.Companion, (i)result);
                    label.A(l$1.a(), result);
                    nVar.L$0 = label;
                    nVar.L$1 = result;
                    nVar.label = i6;
                    if (result != null && label.m(l$1.a(), result.a(), nVar) == obj7) {
                        label.A(l$1.a(), result);
                        nVar.L$0 = label;
                        nVar.L$1 = result;
                        nVar.label = i6;
                        if (label.m(l$1.a(), result.a(), nVar) == obj7) {
                            return obj7;
                        }
                        l$1 = result;
                    }
                }
            } else {
                l$1 = nVar.L$1;
                label = nVar.L$0;
                q.b(result);
                super(l$1.a(), l$1.b(), l$1.c(), (ProgramSaveInfo)result.getProgramId(), result.getModuleId(), result.getLessonId());
                obj2 = l$1;
                l$1 = bVar;
                nVar.L$0 = label;
                nVar.L$1 = obj2;
                nVar.label = companion;
                Object obj3 = label.d.E(l$1, nVar);
                if (obj3 == obj7) {
                    return obj7;
                }
                result = obj3;
                l$1 = obj;
            }
        } else {
            q.b(result);
            if (l$1 instanceof h.b) {
                nVar.L$0 = j1Var;
                nVar.L$1 = l$1;
                nVar.label = bVar;
                if (j1Var.n((h.b)l$1, nVar) == obj7) {
                    return obj7;
                }
                label = j1Var;
            } else {
                label = j1Var;
                obj2 = l$1;
            }
        }
        return i3;
    }

    public final void C(String string, String string2, String string3, String string4) {
        n.f(string, "dogId");
        n.f(string2, "programId");
        n.f(string3, "trickId");
        n.f(string4, "examId");
        j1.o oVar = new j1.o(CoroutineExceptionHandler.r);
        super(this, string, string2, string3, string4, 0);
        k.d(this.g, oVar, 0, pVar, 2, 0);
    }

    public final Object F(String string, String string2, String string3, d<? super k> d4) {
        boolean sVar;
        int label;
        int i2;
        int i;
        int obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        sVar = d4;
        label = sVar.label;
        i2 = Integer.MIN_VALUE;
        if (d4 instanceof j1.s && label & i2 != 0) {
            sVar = d4;
            label = sVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                sVar.label = label -= i2;
            } else {
                sVar = new j1.s(this, d4);
            }
        } else {
        }
        obj9 = sVar.result;
        Object obj = b.d();
        int label2 = sVar.label;
        int i3 = 2;
        final int i4 = 1;
        if (label2 != 0) {
            if (label2 != i4) {
                if (label2 != i3) {
                } else {
                    q.b(obj9);
                    return obj9;
                }
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
            }
            obj6 = sVar.L$1;
            obj7 = sVar.L$0;
            q.b(obj9);
        } else {
            q.b(obj9);
            sVar.L$0 = this;
            sVar.L$1 = string;
            sVar.label = i4;
            if (this.a.updateExamBadge(string, string2, string3, sVar) == obj) {
                return obj;
            }
            obj7 = this;
        }
        obj8 = new m.b((ClassicProgramResponse)obj9.getProgress());
        obj7.A(obj6, obj8);
        obj6 = 0;
        sVar.L$0 = obj6;
        sVar.L$1 = obj6;
        sVar.label = i3;
        if (obj7.h(obj8, sVar) == obj) {
            return obj;
        }
    }

    public final Object G(String string, String string2, Long long3, Long long4, d<? super k> d5) {
        boolean tVar;
        int label;
        int i;
        int i2;
        Object obj8;
        Object obj9;
        m obj10;
        Object obj11;
        Object obj12;
        tVar = d5;
        label = tVar.label;
        i = Integer.MIN_VALUE;
        if (d5 instanceof j1.t && label & i != 0) {
            tVar = d5;
            label = tVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                tVar.label = label -= i;
            } else {
                tVar = new j1.t(this, d5);
            }
        } else {
        }
        obj12 = tVar.result;
        Object obj = b.d();
        int label2 = tVar.label;
        int i3 = 4;
        final int i4 = 3;
        final int i5 = 2;
        final int i6 = 1;
        if (label2 != 0) {
            if (label2 != i6) {
                if (label2 != i5) {
                    if (label2 != i4) {
                        if (label2 != i3) {
                        } else {
                            q.b(obj12);
                            return obj12;
                        }
                        obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj8;
                    }
                    obj8 = tVar.L$1;
                    obj9 = tVar.L$0;
                    q.b(obj12);
                    obj10 = new m.b((ClassicProgramResponse)obj12.getProgress());
                } else {
                    obj8 = tVar.L$1;
                    obj9 = tVar.L$0;
                    q.b(obj12);
                    obj10 = new m.c((PottyProgramProgressModel)obj12.getProgress());
                }
            } else {
                obj8 = tVar.L$1;
                obj9 = tVar.L$0;
                q.b(obj12);
                obj10 = new m.a((BitingProgramProgressResponse)obj12.getProgress());
            }
        } else {
            q.b(obj12);
            obj12 = new ProgramStatusRequest(long3, long4);
            if (n.b(string2, "id_nipping_program")) {
                tVar.L$0 = this;
                tVar.L$1 = string;
                tVar.label = i6;
                if (this.a.updateBitingProgramState(string, obj12, tVar) == obj) {
                    return obj;
                }
                obj9 = this;
            } else {
                if (n.b(string2, "id_potty_program")) {
                    tVar.L$0 = this;
                    tVar.L$1 = string;
                    tVar.label = i5;
                    if (this.a.updatePottyProgramState(string, obj12, tVar) == obj) {
                        return obj;
                    }
                    obj9 = this;
                } else {
                    tVar.L$0 = this;
                    tVar.L$1 = string;
                    tVar.label = i4;
                    if (this.a.updateClassicProgramState(string, string2, obj12, tVar) == obj) {
                        return obj;
                    }
                    obj9 = this;
                }
            }
        }
        obj9.A(obj8, obj10);
        obj8 = 0;
        tVar.L$0 = obj8;
        tVar.L$1 = obj8;
        tVar.label = i3;
        if (obj9.h(obj10, tVar) == obj) {
            return obj;
        }
    }

    public final Object I(String string, String string2, String string3, String string4, String string5, d<? super w> d6) {
        boolean uVar;
        int label;
        int i;
        SaveProgramQuestionRequest saveProgramQuestionRequest;
        int i2;
        Object obj7;
        Object obj8;
        int obj9;
        String obj10;
        Object obj12;
        uVar = d6;
        label = uVar.label;
        i = Integer.MIN_VALUE;
        if (d6 instanceof j1.u && label & i != 0) {
            uVar = d6;
            label = uVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                uVar.label = label -= i;
            } else {
                uVar = new j1.u(this, d6);
            }
        } else {
        }
        obj12 = uVar.result;
        Object obj = b.d();
        saveProgramQuestionRequest = uVar.label;
        int i3 = 3;
        final int i4 = 2;
        final int i5 = 1;
        if (saveProgramQuestionRequest != null) {
            if (saveProgramQuestionRequest != i5) {
                if (saveProgramQuestionRequest != i4) {
                    if (saveProgramQuestionRequest != i3) {
                    } else {
                        q.b(obj12);
                        return w.a;
                    }
                    obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj7;
                }
                obj7 = uVar.L$1;
                obj8 = uVar.L$0;
                q.b(obj12);
            } else {
                obj7 = uVar.L$1;
                obj8 = uVar.L$0;
                q.b(obj12);
                obj9 = new m.b((ClassicProgramResponse)obj12.getProgress());
                obj8.A(obj7, obj9);
                uVar.L$0 = obj8;
                uVar.L$1 = obj9;
                uVar.label = i4;
                if (obj8.m(obj7, obj9.a(), uVar) == obj) {
                    return obj;
                }
                obj7 = obj9;
            }
        } else {
            q.b(obj12);
            saveProgramQuestionRequest = new SaveProgramQuestionRequest(string5, string3, string4);
            uVar.L$0 = this;
            uVar.L$1 = string;
            uVar.label = i5;
            if (this.a.saveProgramQuestion(string, string2, saveProgramQuestionRequest, uVar) == obj) {
                return obj;
            }
            obj8 = this;
        }
        obj9 = 0;
        uVar.L$0 = obj9;
        uVar.L$1 = obj9;
        uVar.label = i3;
        if (obj8.h(obj7, uVar) == obj) {
            return obj;
        }
    }

    public final Object J(String string, String string2, String string3, String string4, List<String> list5, d<? super w> d6) {
        boolean vVar;
        int label;
        int i2;
        SaveProgramTaskRequest saveProgramTaskRequest;
        int i;
        Object obj7;
        Object obj8;
        int obj9;
        String obj10;
        Object obj12;
        vVar = d6;
        label = vVar.label;
        i2 = Integer.MIN_VALUE;
        if (d6 instanceof j1.v && label & i2 != 0) {
            vVar = d6;
            label = vVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                vVar.label = label -= i2;
            } else {
                vVar = new j1.v(this, d6);
            }
        } else {
        }
        obj12 = vVar.result;
        Object obj = b.d();
        saveProgramTaskRequest = vVar.label;
        int i3 = 3;
        final int i4 = 2;
        final int i5 = 1;
        if (saveProgramTaskRequest != null) {
            if (saveProgramTaskRequest != i5) {
                if (saveProgramTaskRequest != i4) {
                    if (saveProgramTaskRequest != i3) {
                    } else {
                        q.b(obj12);
                        return w.a;
                    }
                    obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj7;
                }
                obj7 = vVar.L$1;
                obj8 = vVar.L$0;
                q.b(obj12);
            } else {
                obj7 = vVar.L$1;
                obj8 = vVar.L$0;
                q.b(obj12);
                obj9 = new m.b((ClassicProgramResponse)obj12.getProgress());
                obj8.A(obj7, obj9);
                vVar.L$0 = obj8;
                vVar.L$1 = obj9;
                vVar.label = i4;
                if (obj8.m(obj7, obj9.a(), vVar) == obj) {
                    return obj;
                }
                obj7 = obj9;
            }
        } else {
            q.b(obj12);
            saveProgramTaskRequest = new SaveProgramTaskRequest(list5, string3, string4);
            vVar.L$0 = this;
            vVar.L$1 = string;
            vVar.label = i5;
            if (this.a.saveProgramTask(string, string2, saveProgramTaskRequest, vVar) == obj) {
                return obj;
            }
            obj8 = this;
        }
        obj9 = 0;
        vVar.L$0 = obj9;
        vVar.L$1 = obj9;
        vVar.label = i3;
        if (obj8.h(obj7, vVar) == obj) {
            return obj;
        }
    }

    public final Object o(String string, d<? super i> d2) {
        boolean fVar;
        Object l$03;
        int label;
        Object l$3;
        int i;
        Object l$02;
        Object l$12;
        Object l$2;
        int i2;
        Object l$1;
        Object l$13;
        Object l$0;
        int i3;
        Object bVar;
        app.dogo.com.dogo_android.s.b.i1 oVar;
        int i4;
        String str;
        Object obj;
        Object obj11;
        Object obj12;
        fVar = d2;
        label = fVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof j1.f && label & i != 0) {
            fVar = d2;
            label = fVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                fVar.label = label -= i;
            } else {
                fVar = new j1.f(this, d2);
            }
        } else {
        }
        obj12 = fVar.result;
        Object obj3 = b.d();
        int label2 = fVar.label;
        int i5 = 5;
        l$13 = 4;
        l$0 = 3;
        bVar = 2;
        oVar = 1;
        if (label2 != 0) {
            if (label2 != oVar) {
                if (label2 != bVar) {
                    if (label2 != l$0) {
                        if (label2 != l$13) {
                            if (label2 != i5) {
                            } else {
                                obj11 = fVar.L$4;
                                l$3 = fVar.L$3;
                                l$2 = fVar.L$2;
                                l$1 = fVar.L$1;
                                l$03 = fVar.L$0;
                                q.b(obj12);
                                ArrayList arrayList = new ArrayList(p.r(l$3, 10));
                                Iterator iterator = l$3.iterator();
                                while (iterator.hasNext()) {
                                    Object next2 = iterator.next();
                                    Object obj8 = l$2.b().get((ProgramModel)next2.getId());
                                    if ((h)obj8 == null) {
                                    } else {
                                    }
                                    i4 = (h)obj8.j(l$1);
                                    bVar = new k.b(next2, i4);
                                    oVar = new o(next2.getId(), bVar);
                                    arrayList.add(oVar);
                                    i4 = 0;
                                }
                                long l2 = l$03.c.g();
                                k.c cVar = new k.c((ProgramModel)obj12, (PottyProgramProgressModel.ProgramStatus)l$2.c().a(l$1, l2));
                                obj12 = new k.a(obj11, (BitingProgressModel)l$2.a().a(l$1, l$03.c.g()));
                                obj11 = new i(j0.s(arrayList), obj12, cVar);
                                l$03.b.q(q3.CurrentProgramId, obj11.b());
                                return obj11;
                            }
                            obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            throw obj11;
                        }
                        obj11 = fVar.L$3;
                        l$2 = fVar.L$2;
                        l$13 = fVar.L$1;
                        l$0 = fVar.L$0;
                        q.b(obj12);
                    } else {
                        obj11 = fVar.L$2;
                        l$12 = fVar.L$1;
                        l$0 = fVar.L$0;
                        q.b(obj12);
                        fVar.L$0 = l$0;
                        fVar.L$1 = l$12;
                        fVar.L$2 = obj11;
                        fVar.L$3 = (List)obj12;
                        fVar.label = l$13;
                        Object obj5 = l$0.f.g("id_nipping_program", fVar);
                        if (obj5 == obj3) {
                            return obj3;
                        }
                        l$2 = obj11;
                        obj11 = obj12;
                        obj12 = obj5;
                        l$13 = obj;
                    }
                } else {
                    obj11 = fVar.L$2;
                    l$12 = fVar.L$1;
                    bVar = fVar.L$0;
                    q.b(obj12);
                    fVar.L$0 = bVar;
                    fVar.L$1 = l$12;
                    fVar.L$2 = obj11;
                    fVar.label = l$0;
                    if (bVar.f.c((List)obj12, fVar) == obj3) {
                        return obj3;
                    }
                    l$0 = bVar;
                }
            } else {
                obj11 = fVar.L$1;
                l$02 = fVar.L$0;
                q.b(obj12);
                fVar.L$0 = l$02;
                fVar.L$1 = obj11;
                fVar.L$2 = obj12;
                fVar.label = bVar;
                Object obj7 = l$02.p(obj11, fVar);
                if (obj7 == obj3) {
                    return obj3;
                }
                l$12 = obj11;
                obj11 = obj12;
                obj12 = obj7;
                bVar = obj;
            }
        } else {
            q.b(obj12);
            if (!this.h.e(string)) {
                fVar.L$0 = this;
                fVar.L$1 = string;
                fVar.label = oVar;
                if (E(string, fVar) == obj3) {
                    return obj3;
                }
                l$02 = this;
            } else {
                obj12 = this.h;
                l$02 = this;
            }
        }
        fVar.L$0 = l$0;
        fVar.L$1 = l$13;
        fVar.L$2 = l$2;
        fVar.L$3 = obj11;
        fVar.L$4 = (ProgramModel)obj12;
        fVar.label = i5;
        Object obj2 = l$0.f.g("id_potty_program", fVar);
        if (obj2 == obj3) {
            return obj3;
        }
        l$3 = obj11;
        obj11 = obj12;
        obj12 = obj2;
        l$1 = l$13;
        l$03 = l$0;
    }

    public final Object p(String string, d<? super List<String>> d2) {
        boolean gVar;
        ArrayList arrayList;
        int i2;
        int label;
        int size;
        boolean booleanValue;
        boolean started;
        int i;
        int label2;
        int i3;
        Object obj5;
        Object obj6;
        gVar = d2;
        label = gVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof j1.g && label & i != 0) {
            gVar = d2;
            label = gVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                gVar.label = label -= i;
            } else {
                gVar = new j1.g(this, d2);
            }
        } else {
        }
        obj6 = gVar.result;
        Object obj = b.d();
        label2 = gVar.label;
        int i5 = 1;
        if (label2 != 0) {
            if (label2 != i5) {
            } else {
                obj5 = gVar.L$0;
                q.b(obj6);
                obj6 = obj6.b();
                arrayList = new ArrayList(obj6.size());
                obj6 = obj6.entrySet().iterator();
                for (Map.Entry next4 : obj6) {
                    arrayList.add((h)next4.getValue().j(obj5));
                }
                obj5 = new ArrayList();
                obj6 = arrayList.iterator();
                while (obj6.hasNext()) {
                    arrayList = obj6.next();
                    started = arrayList;
                    label2 = 0;
                    if ((ProgramProgress)started == null) {
                    } else {
                    }
                    if ((ProgramProgress)started.isStarted() == i5) {
                    }
                    if (b.a(label2).booleanValue()) {
                    }
                    obj5.add(arrayList);
                    label2 = i5;
                }
                obj5 = p.U(obj5);
                obj6 = new ArrayList(p.r(obj5, 10));
                obj5 = obj5.iterator();
                for (ProgramProgress next3 : obj5) {
                    obj6.add(next3.getId());
                }
                return obj6;
            }
            obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj6);
        if (!this.h.e(string)) {
            gVar.L$0 = string;
            gVar.label = i5;
            if (E(string, gVar) == obj) {
                return obj;
            }
        } else {
            obj6 = this.h;
        }
    }

    public final Object q(String string, d<? super k.a> d2) {
        boolean hVar;
        int label;
        int i2;
        int i;
        Object obj6;
        hVar = d2;
        label = hVar.label;
        i2 = Integer.MIN_VALUE;
        if (d2 instanceof j1.h && label & i2 != 0) {
            hVar = d2;
            label = hVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                hVar.label = label -= i2;
            } else {
                hVar = new j1.h(this, d2);
            }
        } else {
        }
        obj6 = hVar.result;
        Object obj = b.d();
        int label2 = hVar.label;
        int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                q.b(obj6);
                return (i)obj6.c();
            }
            IllegalStateException obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj6);
        hVar.label = i3;
        if (o(string, hVar) == obj) {
            return obj;
        }
    }

    public final Object r(String string, String string2, d<? super k.b> d3) {
        boolean iVar;
        int label2;
        int i;
        Object label;
        int i4;
        Object l$2;
        int i2;
        Object l$1;
        app.dogo.com.dogo_android.s.b.j1 l$0;
        int i3;
        boolean z;
        Object obj;
        Object obj12;
        Object obj13;
        Object obj14;
        iVar = d3;
        label2 = iVar.label;
        i = Integer.MIN_VALUE;
        if (d3 instanceof j1.i && label2 & i != 0) {
            iVar = d3;
            label2 = iVar.label;
            i = Integer.MIN_VALUE;
            if (label2 & i != 0) {
                iVar.label = label2 -= i;
            } else {
                iVar = new j1.i(this, d3);
            }
        } else {
        }
        obj14 = iVar.result;
        Object obj2 = b.d();
        label = iVar.label;
        int i5 = 3;
        l$2 = 2;
        i2 = 1;
        if (label != 0) {
            if (label != i2) {
                if (label != l$2) {
                    if (label != i5) {
                    } else {
                        obj12 = iVar.L$0;
                        q.b(obj14);
                        obj13 = new k.b(obj12, obj14);
                        return obj13;
                    }
                    obj12 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj12;
                }
                obj12 = iVar.J$0;
                label = iVar.L$3;
                l$2 = iVar.L$2;
                l$1 = iVar.L$1;
                l$0 = iVar.L$0;
                q.b(obj14);
            } else {
                obj13 = obj12;
                obj12 = iVar.L$1;
                q.b(obj14);
                l$0 = label;
                i3 = l$0.c.g();
                iVar.L$0 = l$0;
                iVar.L$1 = obj12;
                iVar.L$2 = obj13;
                iVar.L$3 = (h)l$0.h.b().get(obj13);
                iVar.J$0 = i3;
                iVar.label = l$2;
                if (l$0.f.g(obj13, iVar) == obj2) {
                    return obj2;
                }
                l$1 = obj12;
                l$2 = obj13;
                obj12 = i3;
            }
        } else {
            q.b(obj14);
            iVar.L$0 = this;
            iVar.L$1 = string;
            iVar.L$2 = string2;
            iVar.label = i2;
            if (l(string, iVar) == obj2) {
                return obj2;
            }
            l$0 = this;
        }
        if (label == null) {
            i2 = i3;
        } else {
        }
        if (i2 == 0) {
            iVar.L$0 = (ProgramModel)obj14;
            obj12 = 0;
            iVar.L$1 = obj12;
            iVar.L$2 = obj12;
            iVar.L$3 = obj12;
            iVar.label = i5;
            obj12 = l$0.s(l$1, l$2, iVar);
            if (obj12 == obj2) {
                return obj2;
            }
            obj14 = obj12;
            obj12 = obj;
        } else {
            obj14 = obj12;
            obj12 = obj;
        }
    }

    public final Object t(String string, String string2, String string3, d<? super List<ProgramProgress.ExamSubmission>> d4) {
        boolean kVar;
        int label;
        int i2;
        int i;
        Object obj8;
        kVar = d4;
        label = kVar.label;
        i2 = Integer.MIN_VALUE;
        if (d4 instanceof j1.k && label & i2 != 0) {
            kVar = d4;
            label = kVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                kVar.label = label -= i2;
            } else {
                kVar = new j1.k(this, d4);
            }
        } else {
        }
        obj8 = kVar.result;
        Object obj = b.d();
        int label2 = kVar.label;
        int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                q.b(obj8);
                return (ExamHistoryResponse)obj8.getExamHistory();
            }
            IllegalStateException obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj8);
        kVar.label = i3;
        if (this.a.getExamHistory(string, string2, string3, kVar) == obj) {
            return obj;
        }
    }

    public final LiveData<Boolean> u() {
        return this.i;
    }

    public final Object v(String string, d<? super k.c> d2) {
        boolean lVar;
        int label;
        int i;
        int i2;
        Object obj6;
        lVar = d2;
        label = lVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof j1.l && label & i != 0) {
            lVar = d2;
            label = lVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                lVar.label = label -= i;
            } else {
                lVar = new j1.l(this, d2);
            }
        } else {
        }
        obj6 = lVar.result;
        Object obj = b.d();
        int label2 = lVar.label;
        int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                q.b(obj6);
                return (i)obj6.e();
            }
            IllegalStateException obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj6);
        lVar.label = i3;
        if (o(string, lVar) == obj) {
            return obj;
        }
    }

    public final void w() {
        this.h.d().e();
    }

    public final void y() {
        this.i.postValue(Boolean.FALSE);
    }

    public final Object z(String string, String string2, String string3, String string4, d<? super k> d5) {
        boolean mVar2;
        int label;
        DogoApiClient label2;
        int i3;
        Object i2;
        int i;
        String str;
        String str2;
        app.dogo.com.dogo_android.s.b.j1.m mVar;
        int obj10;
        Object obj11;
        m.b obj12;
        ProgramProgress obj13;
        Object obj14;
        mVar2 = d5;
        label = mVar2.label;
        i3 = Integer.MIN_VALUE;
        if (d5 instanceof j1.m && label & i3 != 0) {
            mVar2 = d5;
            label = mVar2.label;
            i3 = Integer.MIN_VALUE;
            if (label & i3 != 0) {
                mVar2.label = label -= i3;
            } else {
                mVar2 = new j1.m(this, d5);
            }
        } else {
        }
        obj14 = mVar2.result;
        final Object obj = b.d();
        label2 = mVar2.label;
        final int i4 = 2;
        i2 = 1;
        if (label2 != 0) {
            if (label2 != i2) {
                if (label2 != i4) {
                } else {
                    q.b(obj14);
                    return obj14;
                }
                obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj10;
            }
            obj10 = mVar2.L$1;
            obj11 = mVar2.L$0;
            q.b(obj14);
        } else {
            q.b(obj14);
            mVar2.L$0 = this;
            mVar2.L$1 = string;
            mVar2.label = i2;
            if (this.a.saveExamUpload(string, string2, string3, string4, mVar2) == obj) {
                return obj;
            }
            obj11 = this;
        }
        obj12 = new m.b((ClassicProgramResponse)obj14.getProgress());
        obj11.A(obj10, obj12);
        obj10 = 0;
        mVar2.L$0 = obj10;
        mVar2.L$1 = obj10;
        mVar2.label = i4;
        if (obj11.h(obj12, mVar2) == obj) {
            return obj;
        }
    }
}
