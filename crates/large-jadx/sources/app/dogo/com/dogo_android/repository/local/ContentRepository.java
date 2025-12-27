package app.dogo.com.dogo_android.s.b;

import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.h0.m1;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import e.a.a.a.b.b.c0;
import e.a.a.a.b.b.e0;
import e.a.a.a.b.b.g0;
import e.a.a.a.b.b.i0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.s2;

/* compiled from: ContentRepository.kt */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\r\u0018\u0000  2\u00020\u0001:\u0001 BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0011\u0010\u0015\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0018\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0019\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001a\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001b\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001c\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001d\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001e\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001f\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ContentRepository;", "", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "trickDao", "Lapp/dogo/android/persistencedb/room/dao/TrickEntityDao;", "onboardingSurveyDao", "Lapp/dogo/android/persistencedb/room/dao/OnboardingSurveyEntityDao;", "programDao", "Lapp/dogo/android/persistencedb/room/dao/ProgramEntityDao;", "questionDao", "Lapp/dogo/android/persistencedb/room/dao/QuestionEntityDao;", "breedEntityDao", "Lapp/dogo/android/persistencedb/room/dao/BreedEntityDao;", "taskDao", "Lapp/dogo/android/persistencedb/room/dao/TaskEntityDao;", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/android/persistencedb/room/dao/TrickEntityDao;Lapp/dogo/android/persistencedb/room/dao/OnboardingSurveyEntityDao;Lapp/dogo/android/persistencedb/room/dao/ProgramEntityDao;Lapp/dogo/android/persistencedb/room/dao/QuestionEntityDao;Lapp/dogo/android/persistencedb/room/dao/BreedEntityDao;Lapp/dogo/android/persistencedb/room/dao/TaskEntityDao;)V", "startContentDatabaseUpdateSequence", "", "updateArticleTagsDatabase", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateArticlesDatabase", "updateBreedDatabase", "updateOnboardingQuestionDatabase", "updateProgramDatabase", "updateQuestionDatabase", "updateTaskDatabase", "updateTrickCategoryDatabase", "updateTrickDatabase", "updateTrickTagsDatabase", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c1, reason: from kotlin metadata */
public final class ContentRepository {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final c1.a INSTANCE = new c1$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final FirebaseFirestore breedEntityDao;
    /* renamed from: b, reason: from kotlin metadata */
    private final e.a.a.a.b.b.m0 firestore;
    /* renamed from: c, reason: from kotlin metadata */
    private final c0 onboardingSurveyDao;
    /* renamed from: d, reason: from kotlin metadata */
    private final e0 preferenceService;
    /* renamed from: e, reason: from kotlin metadata */
    private final g0 programDao;
    /* renamed from: f, reason: from kotlin metadata */
    private final e.a.a.a.b.b.q questionDao;
    /* renamed from: g, reason: from kotlin metadata */
    private final i0 taskDao;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u000b\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ContentRepository$Companion;", "", "()V", "ARTICLE_GROUP_COLLECTION", "", "ARTICLE_TAG_GROUP_COLLECTION", "BREED_GROUP_COLLECTION", "ONBOARDING_QUESTION_GROUP_COLLECTION", "PROGRAM_GROUP_COLLECTION", "QUESTION_GROUP_COLLECTION", "TASK_GROUP_COLLECTION", "TIMESTAMP", "TRICK_CATEGORY_COLLECTION", "TRICK_GROUP_COLLECTION", "TRICK_TAG_GROUP_COLLECTION", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.a exc) {
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            a.d(exception);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {108, 112, 115}, m = "updateArticleTagsDatabase")
    static final class d extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        d(kotlin.b0.d<? super c1.d> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c1.this.l(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {94, 98, 100}, m = "updateArticlesDatabase")
    static final class e extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        e(kotlin.b0.d<? super c1.e> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c1.this.m(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {154, 158, 161}, m = "updateBreedDatabase")
    static final class f extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        f(kotlin.b0.d<? super c1.f> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c1.this.n(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {169, 173, 176}, m = "updateOnboardingQuestionDatabase")
    static final class g extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        g(kotlin.b0.d<? super c1.g> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c1.this.o(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {123, 127, 130}, m = "updateProgramDatabase")
    static final class h extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        h(kotlin.b0.d<? super c1.h> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c1.this.p(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {80, 84, 86}, m = "updateQuestionDatabase")
    static final class i extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        i(kotlin.b0.d<? super c1.i> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c1.this.q(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {139, 143, 146}, m = "updateTaskDatabase")
    static final class j extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        j(kotlin.b0.d<? super c1.j> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c1.this.r(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {185, 189, 192}, m = "updateTrickCategoryDatabase")
    static final class k extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        k(kotlin.b0.d<? super c1.k> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c1.this.s(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {49, 53, 56}, m = "updateTrickDatabase")
    static final class l extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;
        l(kotlin.b0.d<? super c1.l> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c1.this.t(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {65, 69, 72}, m = "updateTrickTagsDatabase")
    static final class m extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        m(kotlin.b0.d<? super c1.m> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return c1.this.u(this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository$startContentDatabaseUpdateSequence$1", f = "ContentRepository.kt", l = {211, 212, 213, 214, 215, 216, 219, 220, 223, 226}, m = "invokeSuspend")
    static final class c extends kotlin.b0.k.a.k implements kotlin.d0.c.p<kotlinx.coroutines.m0, kotlin.b0.d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj11 = b.d();
            final int i = 0;
            switch (this.label) {
                case 0:
                    q.b(object);
                    a.f("Room update started", new Object[i]);
                    int label2 = 1;
                    this.label = 1;
                    return obj11;
                case 1:
                    q.b(object);
                    break;
                case 2:
                    q.b(object);
                    label2 = 3;
                    this.label = 3;
                    return obj11;
                case 3:
                    q.b(object);
                    label2 = 4;
                    this.label = 4;
                    return obj11;
                case 4:
                    q.b(object);
                    label2 = 5;
                    this.label = 5;
                    return obj11;
                case 5:
                    q.b(object);
                    label2 = 6;
                    this.label = 6;
                    return obj11;
                case 6:
                    q.b(object);
                    label2 = 7;
                    this.label = 7;
                    return obj11;
                case 7:
                    q.b(object);
                    label2 = 8;
                    this.label = 8;
                    return obj11;
                case 8:
                    q.b(object);
                    label2 = 9;
                    this.label = 9;
                    return obj11;
                case 9:
                    q.b(object);
                    label2 = 10;
                    this.label = 10;
                    return obj11;
                case 10:
                    q.b(object);
                    a.f("Room update finished", new Object[i]);
                    return w.a;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            label2 = 2;
            this.label = label2;
            if (c1.this.o(this) == obj11) {
                return obj11;
            }
        }

        c(kotlin.b0.d<? super c1.c> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(kotlinx.coroutines.m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (app.dogo.com.dogo_android.repository.local.c1.c)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new app.dogo.com.dogo_android.repository.local.c1.c(c1.this, dVar);
        }
    }
    public c1(FirebaseFirestore firebaseFirestore, p2 p2Var, e.a.a.a.b.b.m0 m0Var, c0 c0Var, e0 e0Var, g0 g0Var, e.a.a.a.b.b.q qVar, i0 i0Var) {
        n.f(firebaseFirestore, "firestore");
        n.f(p2Var, "preferenceService");
        n.f(m0Var, "trickDao");
        n.f(c0Var, "onboardingSurveyDao");
        n.f(e0Var, "programDao");
        n.f(g0Var, "questionDao");
        n.f(qVar, "breedEntityDao");
        n.f(i0Var, "taskDao");
        super();
        this.breedEntityDao = firebaseFirestore;
        this.firestore = m0Var;
        this.onboardingSurveyDao = c0Var;
        this.preferenceService = e0Var;
        this.programDao = g0Var;
        this.questionDao = qVar;
        this.taskDao = i0Var;
    }

    public static final /* synthetic */ Object a(c1 c1Var, kotlin.b0.d dVar) {
        return c1Var.l(dVar);
    }

    public static final /* synthetic */ Object b(c1 c1Var, kotlin.b0.d dVar) {
        return c1Var.m(dVar);
    }

    public static final /* synthetic */ Object c(c1 c1Var, kotlin.b0.d dVar) {
        return c1Var.n(dVar);
    }

    public static final /* synthetic */ Object d(c1 c1Var, kotlin.b0.d dVar) {
        return c1Var.o(dVar);
    }

    public static final /* synthetic */ Object e(c1 c1Var, kotlin.b0.d dVar) {
        return c1Var.p(dVar);
    }

    public static final /* synthetic */ Object f(c1 c1Var, kotlin.b0.d dVar) {
        return c1Var.q(dVar);
    }

    public static final /* synthetic */ Object g(c1 c1Var, kotlin.b0.d dVar) {
        return c1Var.r(dVar);
    }

    public static final /* synthetic */ Object h(c1 c1Var, kotlin.b0.d dVar) {
        return c1Var.s(dVar);
    }

    public static final /* synthetic */ Object i(c1 c1Var, kotlin.b0.d dVar) {
        return c1Var.t(dVar);
    }

    public static final /* synthetic */ Object j(c1 c1Var, kotlin.b0.d dVar) {
        return c1Var.u(dVar);
    }

    private final Object l(kotlin.b0.d<? super w> dVar) {
        Object dVar2;
        int label2;
        int i = -2147483648;
        app.dogo.com.dogo_android.s.b.c1 c1Var;
        int i2;
        long value = 0;
        String str2;
        String str3;
        Object article;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.c1.d;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.c1.d) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.c1.d dVar3 = new app.dogo.com.dogo_android.repository.local.c1.d(this, dVar);
            }
        }
        Object obj = b.d();
        int i7 = 3;
        int i3 = 2;
        int i4 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i4) {
                if (dVar2.label != i3) {
                    if (dVar2.label != i7) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        try {
                            q.b(dVar2.result);
                        } catch (Exception e) {
                        }
                        return w.a;
                    }
                }
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                }
                a.d(e);
            } else {
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                }
            }
        } else {
            q.b(dVar2.result);
            try {
                dVar2.L$0 = this;
                dVar2.label = i4;
                if (this.programDao.deleteArticle(dVar2) == obj) {
                    return obj;
                }
                c1Var = this;
                if (article == null) {
                    int i8 = 0;
                } else {
                    value = article.longValue();
                }
                str3 = "updatedAt";
                com.google.android.gms.tasks.j jVar = c1Var.breedEntityDao.collectionGroup("articleTagTranslations").whereGreaterThan(str3, b.d(value)).get();
                str = "firestore.collectionGroup(ARTICLE_TAG_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()";
                n.e(jVar, str);
                dVar2.L$0 = c1Var;
                dVar2.label = i3;
                if (a.a(jVar, dVar2) == obj) {
                    return obj;
                }
                while (it.hasNext()) {
                    Object item = it.next();
                    str2 = "it";
                    n.e(item, str2);
                    arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.i(item));
                }
                Object[] array = arrayList.toArray(new ArticleTagEntity[0]);
                dVar2.L$0 = null;
                dVar2.label = i7;
                return obj;
            } catch (Exception e) {
            }
        }
    }

    private final Object m(kotlin.b0.d<? super w> dVar) {
        Object dVar2;
        int label2;
        int i = -2147483648;
        app.dogo.com.dogo_android.s.b.c1 c1Var;
        ArrayList arrayList;
        int i2;
        Iterator dVar3;
        long value = 0;
        int i3;
        String str2;
        Object cleanInsertFullQuestion;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.c1.e;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.c1.e) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.c1.e eVar = new app.dogo.com.dogo_android.repository.local.c1.e(this, dVar);
            }
        }
        Object obj = b.d();
        int i4 = 3;
        int i5 = 2;
        int i6 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i6) {
                if (dVar2.label != i5) {
                    if (dVar2.label != i4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        try {
                            q.b(dVar2.result);
                        } catch (Exception e) {
                            a.d(e);
                        }
                        arrayList.add(w.a);
                        arrayList = i3;
                        if (dVar3.hasNext()) {
                            Object item = dVar3.next();
                            str2 = "it";
                            n.e(item, str2);
                            dVar2.L$0 = c1Var;
                            dVar2.L$1 = arrayList;
                            dVar2.L$2 = dVar3;
                            dVar2.L$3 = arrayList;
                            dVar2.label = i4;
                            if (c1Var.programDao.e(app.dogo.com.dogo_android.util.extensionfunction.m1.g(item), dVar2) == obj) {
                                return obj;
                            }
                        }
                        return w.a;
                    }
                }
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                    a.d(e);
                }
            } else {
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                    a.d(e);
                }
                if (cleanInsertFullQuestion == null) {
                    int i7 = 0;
                } else {
                    value = cleanInsertFullQuestion.longValue();
                }
                str2 = "updatedAt";
                com.google.android.gms.tasks.j jVar = c1Var.breedEntityDao.collectionGroup("articleTranslations").whereGreaterThan(str2, b.d(value)).get();
                str = "firestore.collectionGroup(ARTICLE_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()";
                n.e(jVar, str);
                dVar2.L$0 = c1Var;
                dVar2.label = i5;
                if (a.a(jVar, dVar2) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(dVar2.result);
            try {
                dVar2.L$0 = this;
                dVar2.label = i6;
                if (this.programDao.cleanInsertFullQuestion(dVar2) == obj) {
                    return obj;
                }
                c1Var = this;
                str2 = "updatedAt";
                jVar = c1Var.breedEntityDao.collectionGroup("articleTranslations").whereGreaterThan("updatedAt", b.d(c1Var.programDao, l2)).get();
                str = "firestore.collectionGroup(ARTICLE_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()";
                n.e(jVar, "firestore.collectionGroup(ARTICLE_GROUP_COLLECTION)
                .whereGreaterThan(TIMESTAMP, timestamp)
                .get()");
                dVar2.L$0 = c1Var;
                dVar2.label = i5;
            } catch (Exception e) {
                a.d(e);
            }
        }
    }

    private final Object n(kotlin.b0.d<? super w> dVar) {
        Object dVar2;
        int label2;
        int i = -2147483648;
        app.dogo.com.dogo_android.s.b.c1 c1Var;
        int i2;
        long value = 0;
        String str2;
        String str3;
        Object breedOrEmpty;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.c1.f;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.c1.f) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.c1.f fVar = new app.dogo.com.dogo_android.repository.local.c1.f(this, dVar);
            }
        }
        Object obj = b.d();
        int i7 = 3;
        int i3 = 2;
        int i4 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i4) {
                if (dVar2.label != i3) {
                    if (dVar2.label != i7) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        try {
                            q.b(dVar2.result);
                        } catch (Exception e) {
                        }
                        return w.a;
                    }
                }
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                }
                a.d(e);
            } else {
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                }
            }
        } else {
            q.b(dVar2.result);
            try {
                dVar2.L$0 = this;
                dVar2.label = i4;
                if (this.questionDao.insert(dVar2) == obj) {
                    return obj;
                }
                c1Var = this;
                if (breedOrEmpty == null) {
                    int i8 = 0;
                } else {
                    value = breedOrEmpty.longValue();
                }
                str3 = "updatedAt";
                com.google.android.gms.tasks.j jVar = c1Var.breedEntityDao.collectionGroup("breedTranslations").whereGreaterThan(str3, b.d(value)).get();
                str = "firestore.collectionGroup(BREED_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()";
                n.e(jVar, str);
                dVar2.L$0 = c1Var;
                dVar2.label = i3;
                if (a.a(jVar, dVar2) == obj) {
                    return obj;
                }
                while (it.hasNext()) {
                    Object item = it.next();
                    str2 = "it";
                    n.e(item, str2);
                    arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.j(item));
                }
                Object[] array = arrayList.toArray(new BreedEntity[0]);
                dVar2.L$0 = null;
                dVar2.label = i7;
                return obj;
            } catch (Exception e) {
            }
        }
    }

    private final Object o(kotlin.b0.d<? super w> dVar) {
        Object dVar2;
        int label2;
        int i = -2147483648;
        app.dogo.com.dogo_android.s.b.c1 c1Var;
        ArrayList arrayList;
        int i2;
        Iterator dVar3;
        long value = 0;
        int i3;
        String str2;
        Object cleanInsertFullOnboardingQuestion;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.c1.g;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.c1.g) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.c1.g gVar = new app.dogo.com.dogo_android.repository.local.c1.g(this, dVar);
            }
        }
        Object obj = b.d();
        int i4 = 3;
        int i5 = 2;
        int i6 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i6) {
                if (dVar2.label != i5) {
                    if (dVar2.label != i4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        try {
                            q.b(dVar2.result);
                        } catch (Exception e) {
                            a.d(e);
                        }
                        arrayList.add(w.a);
                        arrayList = i3;
                        if (dVar3.hasNext()) {
                            Object item = dVar3.next();
                            str2 = "it";
                            n.e(item, str2);
                            dVar2.L$0 = c1Var;
                            dVar2.L$1 = arrayList;
                            dVar2.L$2 = dVar3;
                            dVar2.L$3 = arrayList;
                            dVar2.label = i4;
                            if (c1Var.onboardingSurveyDao.getAnswerContent(app.dogo.com.dogo_android.util.extensionfunction.m1.n(item), dVar2) == obj) {
                                return obj;
                            }
                        }
                        return w.a;
                    }
                }
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                    a.d(e);
                }
            } else {
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                    a.d(e);
                }
                if (cleanInsertFullOnboardingQuestion == null) {
                    int i7 = 0;
                } else {
                    value = cleanInsertFullOnboardingQuestion.longValue();
                }
                str2 = "updatedAt";
                com.google.android.gms.tasks.j jVar = c1Var.breedEntityDao.collectionGroup("onboardingQuestionTranslations").whereGreaterThan(str2, b.d(value)).get();
                str = "firestore.collectionGroup(ONBOARDING_QUESTION_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()";
                n.e(jVar, str);
                dVar2.L$0 = c1Var;
                dVar2.label = i5;
                if (a.a(jVar, dVar2) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(dVar2.result);
            try {
                dVar2.L$0 = this;
                dVar2.label = i6;
                if (this.onboardingSurveyDao.cleanInsertFullOnboardingQuestion(dVar2) == obj) {
                    return obj;
                }
                c1Var = this;
                str2 = "updatedAt";
                jVar = c1Var.breedEntityDao.collectionGroup("onboardingQuestionTranslations").whereGreaterThan("updatedAt", b.d(c1Var.onboardingSurveyDao, l2)).get();
                str = "firestore.collectionGroup(ONBOARDING_QUESTION_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()";
                n.e(jVar, "firestore.collectionGroup(ONBOARDING_QUESTION_GROUP_COLLECTION)
                .whereGreaterThan(TIMESTAMP, timestamp)
                .get()");
                dVar2.L$0 = c1Var;
                dVar2.label = i5;
            } catch (Exception e) {
                a.d(e);
            }
        }
    }

    private final Object p(kotlin.b0.d<? super w> dVar) {
        Object dVar2;
        int label2;
        int i = -2147483648;
        app.dogo.com.dogo_android.s.b.c1 c1Var;
        ArrayList arrayList;
        int i2;
        Iterator dVar3;
        long value = 0;
        int i3;
        String str2;
        Object cleanInsertFullLesson;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.c1.h;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.c1.h) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.c1.h hVar = new app.dogo.com.dogo_android.repository.local.c1.h(this, dVar);
            }
        }
        Object obj = b.d();
        int i4 = 3;
        int i5 = 2;
        int i6 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i6) {
                if (dVar2.label != i5) {
                    if (dVar2.label != i4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        try {
                            q.b(dVar2.result);
                        } catch (Exception e) {
                            int arr = 0;
                            arr = new Object[arr];
                            a.e(e, "Halp this", arr);
                        }
                        arrayList.add(w.a);
                        arrayList = i3;
                        if (dVar3.hasNext()) {
                            Object item = dVar3.next();
                            str2 = "it";
                            n.e(item, str2);
                            dVar2.L$0 = c1Var;
                            dVar2.L$1 = arrayList;
                            dVar2.L$2 = dVar3;
                            dVar2.L$3 = arrayList;
                            dVar2.label = i4;
                            if (c1Var.preferenceService.f(app.dogo.com.dogo_android.util.extensionfunction.m1.x(item), dVar2) == obj) {
                                return obj;
                            }
                        }
                        return w.a;
                    }
                }
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                    arr = 0;
                    arr = new Object[arr];
                    a.e(e, "Halp this", arr);
                }
            } else {
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                    arr = 0;
                    arr = new Object[arr];
                    a.e(e, "Halp this", arr);
                }
                if (cleanInsertFullLesson == null) {
                    int i7 = 0;
                } else {
                    value = cleanInsertFullLesson.longValue();
                }
                str2 = "updatedAt";
                com.google.android.gms.tasks.j jVar = c1Var.breedEntityDao.collectionGroup("programTranslations").whereGreaterThan(str2, b.d(value)).get();
                str = "firestore.collectionGroup(PROGRAM_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()";
                n.e(jVar, str);
                dVar2.L$0 = c1Var;
                dVar2.label = i5;
                if (a.a(jVar, dVar2) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(dVar2.result);
            try {
                dVar2.L$0 = this;
                dVar2.label = i6;
                if (this.preferenceService.cleanInsertFullLesson(dVar2) == obj) {
                    return obj;
                }
                c1Var = this;
                str2 = "updatedAt";
                jVar = c1Var.breedEntityDao.collectionGroup("programTranslations").whereGreaterThan("updatedAt", b.d(c1Var.preferenceService, l2)).get();
                str = "firestore.collectionGroup(PROGRAM_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()";
                n.e(jVar, "firestore.collectionGroup(PROGRAM_GROUP_COLLECTION)
                .whereGreaterThan(TIMESTAMP, timestamp)
                .get()");
                dVar2.L$0 = c1Var;
                dVar2.label = i5;
            } catch (Exception e) {
                arr = 0;
                arr = new Object[arr];
                a.e(e, "Halp this", arr);
            }
        }
    }

    private final Object q(kotlin.b0.d<? super w> dVar) {
        Object dVar2;
        int label2;
        int i = -2147483648;
        app.dogo.com.dogo_android.s.b.c1 c1Var;
        ArrayList arrayList;
        int i2;
        Iterator dVar3;
        long value = 0;
        int i3;
        String str2;
        Object cleanInsertFullArticle;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.c1.i;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.c1.i) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.c1.i iVar = new app.dogo.com.dogo_android.repository.local.c1.i(this, dVar);
            }
        }
        Object obj = b.d();
        int i4 = 3;
        int i5 = 2;
        int i6 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i6) {
                if (dVar2.label != i5) {
                    if (dVar2.label != i4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        try {
                            q.b(dVar2.result);
                        } catch (Exception e) {
                            a.d(e);
                        }
                        arrayList.add(w.a);
                        arrayList = i3;
                        if (dVar3.hasNext()) {
                            Object item = dVar3.next();
                            str2 = "it";
                            n.e(item, str2);
                            dVar2.L$0 = c1Var;
                            dVar2.L$1 = arrayList;
                            dVar2.L$2 = dVar3;
                            dVar2.L$3 = arrayList;
                            dVar2.label = i4;
                            if (c1Var.programDao.g(app.dogo.com.dogo_android.util.extensionfunction.m1.z(item), dVar2) == obj) {
                                return obj;
                            }
                        }
                        return w.a;
                    }
                }
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                    a.d(e);
                }
            } else {
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                    a.d(e);
                }
                if (cleanInsertFullArticle == null) {
                    int i7 = 0;
                } else {
                    value = cleanInsertFullArticle.longValue();
                }
                str2 = "updatedAt";
                com.google.android.gms.tasks.j jVar = c1Var.breedEntityDao.collectionGroup("questionTranslations").whereGreaterThan(str2, b.d(value)).get();
                str = "firestore.collectionGroup(QUESTION_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()";
                n.e(jVar, str);
                dVar2.L$0 = c1Var;
                dVar2.label = i5;
                if (a.a(jVar, dVar2) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(dVar2.result);
            try {
                dVar2.L$0 = this;
                dVar2.label = i6;
                if (this.programDao.cleanInsertFullArticle(dVar2) == obj) {
                    return obj;
                }
                c1Var = this;
                str2 = "updatedAt";
                jVar = c1Var.breedEntityDao.collectionGroup("questionTranslations").whereGreaterThan("updatedAt", b.d(c1Var.programDao, l2)).get();
                str = "firestore.collectionGroup(QUESTION_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()";
                n.e(jVar, "firestore.collectionGroup(QUESTION_GROUP_COLLECTION)
                .whereGreaterThan(TIMESTAMP, timestamp)
                .get()");
                dVar2.L$0 = c1Var;
                dVar2.label = i5;
            } catch (Exception e) {
                a.d(e);
            }
        }
    }

    private final Object r(kotlin.b0.d<? super w> dVar) {
        Object dVar2;
        int label2;
        int i = -2147483648;
        app.dogo.com.dogo_android.s.b.c1 c1Var;
        int i2;
        long value = 0;
        String str2;
        String str3;
        Object task;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.c1.j;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.c1.j) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.c1.j jVar = new app.dogo.com.dogo_android.repository.local.c1.j(this, dVar);
            }
        }
        Object obj = b.d();
        int i7 = 3;
        int i3 = 2;
        int i4 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i4) {
                if (dVar2.label != i3) {
                    if (dVar2.label != i7) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        try {
                            q.b(dVar2.result);
                        } catch (Exception e) {
                        }
                        return w.a;
                    }
                }
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                }
                a.d(e);
            } else {
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                }
            }
        } else {
            q.b(dVar2.result);
            try {
                dVar2.L$0 = this;
                dVar2.label = i4;
                if (this.taskDao.deleteTask(dVar2) == obj) {
                    return obj;
                }
                c1Var = this;
                if (task == null) {
                    int i8 = 0;
                } else {
                    value = task.longValue();
                }
                str3 = "updatedAt";
                com.google.android.gms.tasks.j jVar2 = c1Var.breedEntityDao.collectionGroup("taskTranslations").whereGreaterThan(str3, b.d(value)).get();
                str = "firestore.collectionGroup(TASK_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()";
                n.e(jVar2, str);
                dVar2.L$0 = c1Var;
                dVar2.label = i3;
                if (a.a(jVar2, dVar2) == obj) {
                    return obj;
                }
                while (it.hasNext()) {
                    Object item = it.next();
                    str2 = "it";
                    n.e(item, str2);
                    arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.toEntity(item));
                }
                Object[] array = arrayList.toArray(new TaskEntity[0]);
                dVar2.L$0 = null;
                dVar2.label = i7;
                return obj;
            } catch (Exception e) {
            }
        }
    }

    private final Object s(kotlin.b0.d<? super w> dVar) {
        Object dVar2;
        int label2;
        int i = -2147483648;
        app.dogo.com.dogo_android.s.b.c1 c1Var;
        int i2;
        long value = 0;
        String str2;
        String str3;
        Object trickCategory;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.c1.k;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.c1.k) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.c1.k kVar = new app.dogo.com.dogo_android.repository.local.c1.k(this, dVar);
            }
        }
        Object obj = b.d();
        int i7 = 3;
        int i3 = 2;
        int i4 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i4) {
                if (dVar2.label != i3) {
                    if (dVar2.label != i7) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        try {
                            q.b(dVar2.result);
                        } catch (Exception e) {
                        }
                        return w.a;
                    }
                }
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                }
                a.d(e);
            } else {
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                }
            }
        } else {
            q.b(dVar2.result);
            try {
                dVar2.L$0 = this;
                dVar2.label = i4;
                if (this.firestore.deleteTrickCategory(dVar2) == obj) {
                    return obj;
                }
                c1Var = this;
                if (trickCategory == null) {
                    int i8 = 0;
                } else {
                    value = trickCategory.longValue();
                }
                str3 = "updatedAt";
                com.google.android.gms.tasks.j jVar = c1Var.breedEntityDao.collectionGroup("trickCategoryTranslations").whereGreaterThan(str3, b.d(value)).get();
                str = "firestore.collectionGroup(TRICK_CATEGORY_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()";
                n.e(jVar, str);
                dVar2.L$0 = c1Var;
                dVar2.label = i3;
                if (a.a(jVar, dVar2) == obj) {
                    return obj;
                }
                while (it.hasNext()) {
                    Object item = it.next();
                    str2 = "it";
                    n.e(item, str2);
                    arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.m(item));
                }
                Object[] array = arrayList.toArray(new TrickCategoryEntity[0]);
                dVar2.L$0 = null;
                dVar2.label = i7;
                return obj;
            } catch (Exception e) {
            }
        }
    }

    private final Object t(kotlin.b0.d<? super w> dVar) {
        Object dVar2;
        int label2;
        int i = -2147483648;
        app.dogo.com.dogo_android.s.b.c1 c1Var;
        ArrayList arrayList;
        int i2;
        Iterator dVar3;
        long value = 0;
        int i3;
        String str2;
        Object trick;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.c1.l;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.c1.l) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.c1.l lVar = new app.dogo.com.dogo_android.repository.local.c1.l(this, dVar);
            }
        }
        Object obj = b.d();
        int i4 = 3;
        int i5 = 2;
        int i6 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i6) {
                if (dVar2.label != i5) {
                    if (dVar2.label != i4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        try {
                            q.b(dVar2.result);
                        } catch (Exception e) {
                            a.d(e);
                        }
                        arrayList.add(w.a);
                        arrayList = i3;
                        if (dVar3.hasNext()) {
                            Object item = dVar3.next();
                            str2 = "it";
                            n.e(item, str2);
                            dVar2.L$0 = c1Var;
                            dVar2.L$1 = arrayList;
                            dVar2.L$2 = dVar3;
                            dVar2.L$3 = arrayList;
                            dVar2.label = i4;
                            if (c1Var.firestore.i(app.dogo.com.dogo_android.util.extensionfunction.m1.toProgramTask(item), dVar2) == obj) {
                                return obj;
                            }
                        }
                        return w.a;
                    }
                }
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                    a.d(e);
                }
            } else {
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                    a.d(e);
                }
                if (trick == null) {
                    int i7 = 0;
                } else {
                    value = trick.longValue();
                }
                str2 = "updatedAt";
                com.google.android.gms.tasks.j jVar = c1Var.breedEntityDao.collectionGroup("trickTranslations").whereGreaterThan(str2, b.d(value)).get();
                str = "firestore.collectionGroup(TRICK_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()";
                n.e(jVar, str);
                dVar2.L$0 = c1Var;
                dVar2.label = i5;
                if (a.a(jVar, dVar2) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(dVar2.result);
            try {
                dVar2.L$0 = this;
                dVar2.label = i6;
                if (this.firestore.deleteTrick(dVar2) == obj) {
                    return obj;
                }
                c1Var = this;
                str2 = "updatedAt";
                jVar = c1Var.breedEntityDao.collectionGroup("trickTranslations").whereGreaterThan("updatedAt", b.d(c1Var.firestore, l2)).get();
                str = "firestore.collectionGroup(TRICK_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()";
                n.e(jVar, "firestore.collectionGroup(TRICK_GROUP_COLLECTION)
                .whereGreaterThan(TIMESTAMP, timestamp)
                .get()");
                dVar2.L$0 = c1Var;
                dVar2.label = i5;
            } catch (Exception e) {
                a.d(e);
            }
        }
    }

    private final Object u(kotlin.b0.d<? super w> dVar) {
        Object dVar2;
        int label2;
        int i = -2147483648;
        app.dogo.com.dogo_android.s.b.c1 c1Var;
        int i2;
        long value = 0;
        String str2;
        String str3;
        Object cleanInsertFullTrick;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.c1.m;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.c1.m) {
            dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.c1.m mVar = new app.dogo.com.dogo_android.repository.local.c1.m(this, dVar);
            }
        }
        Object obj = b.d();
        int i7 = 3;
        int i3 = 2;
        int i4 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i4) {
                if (dVar2.label != i3) {
                    if (dVar2.label != i7) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        try {
                            q.b(dVar2.result);
                        } catch (Exception e) {
                        }
                        return w.a;
                    }
                }
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                }
                a.d(e);
            } else {
                try {
                    q.b(dVar2.result);
                } catch (Exception e) {
                }
            }
        } else {
            q.b(dVar2.result);
            try {
                dVar2.L$0 = this;
                dVar2.label = i4;
                if (this.firestore.cleanInsertFullTrick(dVar2) == obj) {
                    return obj;
                }
                c1Var = this;
                if (cleanInsertFullTrick == null) {
                    int i8 = 0;
                } else {
                    value = cleanInsertFullTrick.longValue();
                }
                str3 = "updatedAt";
                com.google.android.gms.tasks.j jVar = c1Var.breedEntityDao.collectionGroup("trickTagTranslations").whereGreaterThan(str3, b.d(value)).get();
                str = "firestore.collectionGroup(TRICK_TAG_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()";
                n.e(jVar, str);
                dVar2.L$0 = c1Var;
                dVar2.label = i3;
                if (a.a(jVar, dVar2) == obj) {
                    return obj;
                }
                while (it.hasNext()) {
                    Object item = it.next();
                    str2 = "it";
                    n.e(item, str2);
                    arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.K(item));
                }
                Object[] array = arrayList.toArray(new TrickTagEntity[0]);
                dVar2.L$0 = null;
                dVar2.label = i7;
                return obj;
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: k, reason: from kotlin metadata */
    /* suspend */ public final void startContentDatabaseUpdateSequence() {
        kotlinx.coroutines.y1 y1Var = null;
        kotlinx.coroutines.internal.k.d(kotlinx.coroutines.internal.n0.a(kotlinx.coroutines.internal.s2.b(y1Var, 1, y1Var).plus(Dispatchers.b()).plus(new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r))), null, null, new app.dogo.com.dogo_android.repository.local.c1.c(this, y1Var), 3, null);
    }

}
