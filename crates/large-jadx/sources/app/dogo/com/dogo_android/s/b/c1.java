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
import e.a.a.a.b.b.m0;
import e.a.a.a.b.b.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
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
import kotlin.q;
import kotlin.w;
import kotlin.y.p;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.e3.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.s2;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\r\u0018\u0000  2\u00020\u0001:\u0001 BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u0011\u0010\u0015\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0018\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0019\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001a\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001b\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001c\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001d\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001e\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u001f\u001a\u00020\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ContentRepository;", "", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "trickDao", "Lapp/dogo/android/persistencedb/room/dao/TrickEntityDao;", "onboardingSurveyDao", "Lapp/dogo/android/persistencedb/room/dao/OnboardingSurveyEntityDao;", "programDao", "Lapp/dogo/android/persistencedb/room/dao/ProgramEntityDao;", "questionDao", "Lapp/dogo/android/persistencedb/room/dao/QuestionEntityDao;", "breedEntityDao", "Lapp/dogo/android/persistencedb/room/dao/BreedEntityDao;", "taskDao", "Lapp/dogo/android/persistencedb/room/dao/TaskEntityDao;", "(Lcom/google/firebase/firestore/FirebaseFirestore;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/android/persistencedb/room/dao/TrickEntityDao;Lapp/dogo/android/persistencedb/room/dao/OnboardingSurveyEntityDao;Lapp/dogo/android/persistencedb/room/dao/ProgramEntityDao;Lapp/dogo/android/persistencedb/room/dao/QuestionEntityDao;Lapp/dogo/android/persistencedb/room/dao/BreedEntityDao;Lapp/dogo/android/persistencedb/room/dao/TaskEntityDao;)V", "startContentDatabaseUpdateSequence", "", "updateArticleTagsDatabase", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateArticlesDatabase", "updateBreedDatabase", "updateOnboardingQuestionDatabase", "updateProgramDatabase", "updateQuestionDatabase", "updateTaskDatabase", "updateTrickCategoryDatabase", "updateTrickDatabase", "updateTrickTagsDatabase", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c1 {

    public static final app.dogo.com.dogo_android.s.b.c1.a Companion;
    private final FirebaseFirestore a;
    private final m0 b;
    private final c0 c;
    private final e0 d;
    private final g0 e;
    private final q f;
    private final i0 g;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u000b\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ContentRepository$Companion;", "", "()V", "ARTICLE_GROUP_COLLECTION", "", "ARTICLE_TAG_GROUP_COLLECTION", "BREED_GROUP_COLLECTION", "ONBOARDING_QUESTION_GROUP_COLLECTION", "PROGRAM_GROUP_COLLECTION", "QUESTION_GROUP_COLLECTION", "TASK_GROUP_COLLECTION", "TIMESTAMP", "TRICK_CATEGORY_COLLECTION", "TRICK_GROUP_COLLECTION", "TRICK_TAG_GROUP_COLLECTION", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a) {
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            a.d(throwable2);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {108, 112, 115}, m = "updateArticleTagsDatabase")
    static final class d extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.c1 this$0;
        d(app.dogo.com.dogo_android.s.b.c1 c1, d<? super app.dogo.com.dogo_android.s.b.c1.d> d2) {
            this.this$0 = c1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return c1.a(this.this$0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {94, 98, 100}, m = "updateArticlesDatabase")
    static final class e extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.c1 this$0;
        e(app.dogo.com.dogo_android.s.b.c1 c1, d<? super app.dogo.com.dogo_android.s.b.c1.e> d2) {
            this.this$0 = c1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return c1.b(this.this$0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {154, 158, 161}, m = "updateBreedDatabase")
    static final class f extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.c1 this$0;
        f(app.dogo.com.dogo_android.s.b.c1 c1, d<? super app.dogo.com.dogo_android.s.b.c1.f> d2) {
            this.this$0 = c1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return c1.c(this.this$0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {169, 173, 176}, m = "updateOnboardingQuestionDatabase")
    static final class g extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.c1 this$0;
        g(app.dogo.com.dogo_android.s.b.c1 c1, d<? super app.dogo.com.dogo_android.s.b.c1.g> d2) {
            this.this$0 = c1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return c1.d(this.this$0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {123, 127, 130}, m = "updateProgramDatabase")
    static final class h extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.c1 this$0;
        h(app.dogo.com.dogo_android.s.b.c1 c1, d<? super app.dogo.com.dogo_android.s.b.c1.h> d2) {
            this.this$0 = c1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return c1.e(this.this$0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {80, 84, 86}, m = "updateQuestionDatabase")
    static final class i extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.c1 this$0;
        i(app.dogo.com.dogo_android.s.b.c1 c1, d<? super app.dogo.com.dogo_android.s.b.c1.i> d2) {
            this.this$0 = c1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return c1.f(this.this$0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {139, 143, 146}, m = "updateTaskDatabase")
    static final class j extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.c1 this$0;
        j(app.dogo.com.dogo_android.s.b.c1 c1, d<? super app.dogo.com.dogo_android.s.b.c1.j> d2) {
            this.this$0 = c1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return c1.g(this.this$0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {185, 189, 192}, m = "updateTrickCategoryDatabase")
    static final class k extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.c1 this$0;
        k(app.dogo.com.dogo_android.s.b.c1 c1, d<? super app.dogo.com.dogo_android.s.b.c1.k> d2) {
            this.this$0 = c1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return c1.h(this.this$0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {49, 53, 56}, m = "updateTrickDatabase")
    static final class l extends d {

        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.c1 this$0;
        l(app.dogo.com.dogo_android.s.b.c1 c1, d<? super app.dogo.com.dogo_android.s.b.c1.l> d2) {
            this.this$0 = c1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return c1.i(this.this$0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository", f = "ContentRepository.kt", l = {65, 69, 72}, m = "updateTrickTagsDatabase")
    static final class m extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.c1 this$0;
        m(app.dogo.com.dogo_android.s.b.c1 c1, d<? super app.dogo.com.dogo_android.s.b.c1.m> d2) {
            this.this$0 = c1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return c1.j(this.this$0, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ContentRepository$startContentDatabaseUpdateSequence$1", f = "ContentRepository.kt", l = {211, 212, 213, 214, 215, 216, 219, 220, 223, 226}, m = "invokeSuspend")
    static final class c extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.s.b.c1 this$0;
        c(app.dogo.com.dogo_android.s.b.c1 c1, d<? super app.dogo.com.dogo_android.s.b.c1.c> d2) {
            this.this$0 = c1;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (c1.c)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            c1.c obj2 = new c1.c(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label;
            Object obj4;
            Object obj = b.d();
            final int i = 0;
            switch (label) {
                case 0:
                    q.b(object);
                    a.f("Room update started", new Object[i]);
                    this.label = 1;
                    return obj;
                case 1:
                    q.b(object);
                    break;
                case 2:
                    q.b(object);
                    this.label = 3;
                    return obj;
                    this.label = 4;
                    return obj;
                    this.label = 5;
                    return obj;
                    this.label = 6;
                    return obj;
                    this.label = 7;
                    return obj;
                    this.label = 8;
                    return obj;
                    this.label = 9;
                    return obj;
                    this.label = 10;
                    return obj;
                    a.f("Room update finished", new Object[i]);
                    return w.a;
                case 3:
                    q.b(object);
                    this.label = 4;
                    return obj;
                    this.label = 5;
                    return obj;
                    this.label = 6;
                    return obj;
                    this.label = 7;
                    return obj;
                    this.label = 8;
                    return obj;
                    this.label = 9;
                    return obj;
                    this.label = 10;
                    return obj;
                    a.f("Room update finished", new Object[i]);
                    return w.a;
                case 4:
                    q.b(object);
                    this.label = 5;
                    return obj;
                    this.label = 6;
                    return obj;
                    this.label = 7;
                    return obj;
                    this.label = 8;
                    return obj;
                    this.label = 9;
                    return obj;
                    this.label = 10;
                    return obj;
                    a.f("Room update finished", new Object[i]);
                    return w.a;
                case 5:
                    q.b(object);
                    this.label = 6;
                    return obj;
                    this.label = 7;
                    return obj;
                    this.label = 8;
                    return obj;
                    this.label = 9;
                    return obj;
                    this.label = 10;
                    return obj;
                    a.f("Room update finished", new Object[i]);
                    return w.a;
                case 6:
                    q.b(object);
                    this.label = 7;
                    return obj;
                    this.label = 8;
                    return obj;
                    this.label = 9;
                    return obj;
                    this.label = 10;
                    return obj;
                    a.f("Room update finished", new Object[i]);
                    return w.a;
                case 7:
                    q.b(object);
                    this.label = 8;
                    return obj;
                    this.label = 9;
                    return obj;
                    this.label = 10;
                    return obj;
                    a.f("Room update finished", new Object[i]);
                    return w.a;
                case 8:
                    q.b(object);
                    this.label = 9;
                    return obj;
                    this.label = 10;
                    return obj;
                    a.f("Room update finished", new Object[i]);
                    return w.a;
                case 9:
                    q.b(object);
                    this.label = 10;
                    return obj;
                    a.f("Room update finished", new Object[i]);
                    return w.a;
                case 10:
                    q.b(object);
                    a.f("Room update finished", new Object[i]);
                    return w.a;
                default:
                    obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj4;
            }
            this.label = 2;
            if (c1.d(this.this$0, this) == obj) {
                return obj;
            }
        }
    }
    static {
        c1.a aVar = new c1.a(0);
        c1.Companion = aVar;
    }

    public c1(FirebaseFirestore firebaseFirestore, p2 p22, m0 m03, c0 c04, e0 e05, g0 g06, q q7, i0 i08) {
        n.f(firebaseFirestore, "firestore");
        n.f(p22, "preferenceService");
        n.f(m03, "trickDao");
        n.f(c04, "onboardingSurveyDao");
        n.f(e05, "programDao");
        n.f(g06, "questionDao");
        n.f(q7, "breedEntityDao");
        n.f(i08, "taskDao");
        super();
        this.a = firebaseFirestore;
        this.b = m03;
        this.c = c04;
        this.d = e05;
        this.e = g06;
        this.f = q7;
        this.g = i08;
    }

    public static final Object a(app.dogo.com.dogo_android.s.b.c1 c1, d d2) {
        return c1.l(d2);
    }

    public static final Object b(app.dogo.com.dogo_android.s.b.c1 c1, d d2) {
        return c1.m(d2);
    }

    public static final Object c(app.dogo.com.dogo_android.s.b.c1 c1, d d2) {
        return c1.n(d2);
    }

    public static final Object d(app.dogo.com.dogo_android.s.b.c1 c1, d d2) {
        return c1.o(d2);
    }

    public static final Object e(app.dogo.com.dogo_android.s.b.c1 c1, d d2) {
        return c1.p(d2);
    }

    public static final Object f(app.dogo.com.dogo_android.s.b.c1 c1, d d2) {
        return c1.q(d2);
    }

    public static final Object g(app.dogo.com.dogo_android.s.b.c1 c1, d d2) {
        return c1.r(d2);
    }

    public static final Object h(app.dogo.com.dogo_android.s.b.c1 c1, d d2) {
        return c1.s(d2);
    }

    public static final Object i(app.dogo.com.dogo_android.s.b.c1 c1, d d2) {
        return c1.t(d2);
    }

    public static final Object j(app.dogo.com.dogo_android.s.b.c1 c1, d d2) {
        return c1.u(d2);
    }

    private final Object l(d<? super w> d) {
        boolean dVar;
        int label;
        int i;
        Object[] copyOf;
        Object l$0;
        int i2;
        int i4;
        boolean next;
        int i3;
        int longValue;
        long str2;
        String str;
        Object obj9;
        dVar = d;
        label = dVar.label;
        i = Integer.MIN_VALUE;
        if (d instanceof c1.d && label & i != 0) {
            dVar = d;
            label = dVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                dVar.label = label -= i;
            } else {
                dVar = new c1.d(this, d);
            }
        } else {
        }
        obj9 = dVar.result;
        Object obj = b.d();
        copyOf = dVar.label;
        int i6 = 3;
        i4 = 2;
        next = 1;
        if (copyOf != 0) {
            if (copyOf != next) {
                if (copyOf != i4) {
                    if (copyOf != i6) {
                    } else {
                        q.b(obj9);
                        return w.a;
                    }
                    obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj9;
                }
                l$0 = dVar.L$0;
                q.b(obj9);
            } else {
                l$0 = dVar.L$0;
                q.b(obj9);
                if ((Long)obj9 == null) {
                    longValue = 0;
                } else {
                    longValue = (Long)obj9.longValue();
                }
                obj9 = l$0.a.collectionGroup("articleTagTranslations").whereGreaterThan("updatedAt", b.d(longValue)).get();
                n.e(obj9, "firestore.collectionGroup(ARTICLE_TAG_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()");
                dVar.L$0 = l$0;
                dVar.label = i4;
                if (a.a(obj9, dVar) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(obj9);
            dVar.L$0 = this;
            dVar.label = next;
            if (this.e.h(dVar) == obj) {
                return obj;
            }
            l$0 = this;
        }
        obj9 = (QuerySnapshot)obj9.toObjects(ArticleModel.ArticleTag.class);
        n.e(obj9, "firestore.collectionGroup(ARTICLE_TAG_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()\n                .await()\n                .toObjects(ArticleModel.ArticleTag::class.java)");
        ArrayList arrayList = new ArrayList(p.r(obj9, 10));
        obj9 = obj9.iterator();
        for (ArticleModel.ArticleTag next2 : obj9) {
            n.e(next2, "it");
            arrayList.add(m1.i(next2));
        }
        Object[] array = arrayList.toArray(new ArticleTagEntity[0]);
        if (array == null) {
        } else {
            dVar.L$0 = 0;
            dVar.label = i6;
            if (l$0.e.k((ArticleTagEntity[])Arrays.copyOf((ArticleTagEntity[])array, array.length), dVar) == obj) {
                return obj;
            }
        }
        obj9 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        throw obj9;
    }

    private final Object m(d<? super w> d) {
        boolean eVar;
        int label;
        int i;
        Object l$3;
        Object l$0;
        int i2;
        Object l$2;
        Object l$1;
        long longValue;
        String str;
        Object l$02;
        String str2;
        Object obj9;
        eVar = d;
        label = eVar.label;
        i = Integer.MIN_VALUE;
        if (d instanceof c1.e && label & i != 0) {
            eVar = d;
            label = eVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                eVar.label = label -= i;
            } else {
                eVar = new c1.e(this, d);
            }
        } else {
        }
        obj9 = eVar.result;
        Object obj = b.d();
        int label2 = eVar.label;
        int i3 = 3;
        int i4 = 2;
        str = 1;
        if (label2 != 0) {
            if (label2 != str) {
                if (label2 != i4) {
                    if (label2 != i3) {
                    } else {
                        l$3 = eVar.L$3;
                        l$2 = eVar.L$2;
                        l$1 = eVar.L$1;
                        l$02 = eVar.L$0;
                        q.b(obj9);
                        l$3.add(w.a);
                        l$3 = l$1;
                        if (l$2.hasNext()) {
                            obj9 = l$2.next();
                            n.e((ArticleModel)obj9, "it");
                            eVar.L$0 = l$02;
                            eVar.L$1 = l$3;
                            eVar.L$2 = l$2;
                            eVar.L$3 = l$3;
                            eVar.label = i3;
                            if (l$02.e.e(m1.g(obj9), eVar) == obj) {
                                return obj;
                            } else {
                            }
                        }
                        return w.a;
                    }
                    obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj9;
                }
                l$0 = eVar.L$0;
                q.b(obj9);
            } else {
                l$0 = eVar.L$0;
                q.b(obj9);
                if ((Long)obj9 == null) {
                    longValue = 0;
                } else {
                    longValue = (Long)obj9.longValue();
                }
                obj9 = l$0.a.collectionGroup("articleTranslations").whereGreaterThan("updatedAt", b.d(longValue)).get();
                n.e(obj9, "firestore.collectionGroup(ARTICLE_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()");
                eVar.L$0 = l$0;
                eVar.label = i4;
                if (a.a(obj9, eVar) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(obj9);
            eVar.L$0 = this;
            eVar.label = str;
            if (this.e.c(eVar) == obj) {
                return obj;
            }
            l$0 = this;
        }
        obj9 = (QuerySnapshot)obj9.toObjects(ArticleModel.class);
        n.e(obj9, "firestore.collectionGroup(ARTICLE_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()\n                .await()\n                .toObjects(ArticleModel::class.java)");
        ArrayList arrayList = new ArrayList(p.r(obj9, 10));
        l$02 = l$0;
        l$3 = arrayList;
        l$2 = obj9;
    }

    private final Object n(d<? super w> d) {
        boolean fVar;
        int label;
        int i3;
        Object[] copyOf;
        Object l$0;
        int i;
        int i4;
        boolean next;
        int i2;
        int longValue;
        long str;
        String str2;
        Object obj9;
        fVar = d;
        label = fVar.label;
        i3 = Integer.MIN_VALUE;
        if (d instanceof c1.f && label & i3 != 0) {
            fVar = d;
            label = fVar.label;
            i3 = Integer.MIN_VALUE;
            if (label & i3 != 0) {
                fVar.label = label -= i3;
            } else {
                fVar = new c1.f(this, d);
            }
        } else {
        }
        obj9 = fVar.result;
        Object obj = b.d();
        copyOf = fVar.label;
        int i6 = 3;
        i4 = 2;
        next = 1;
        if (copyOf != 0) {
            if (copyOf != next) {
                if (copyOf != i4) {
                    if (copyOf != i6) {
                    } else {
                        q.b(obj9);
                        return w.a;
                    }
                    obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj9;
                }
                l$0 = fVar.L$0;
                q.b(obj9);
            } else {
                l$0 = fVar.L$0;
                q.b(obj9);
                if ((Long)obj9 == null) {
                    longValue = 0;
                } else {
                    longValue = (Long)obj9.longValue();
                }
                obj9 = l$0.a.collectionGroup("breedTranslations").whereGreaterThan("updatedAt", b.d(longValue)).get();
                n.e(obj9, "firestore.collectionGroup(BREED_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()");
                fVar.L$0 = l$0;
                fVar.label = i4;
                if (a.a(obj9, fVar) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(obj9);
            fVar.L$0 = this;
            fVar.label = next;
            if (this.f.e(fVar) == obj) {
                return obj;
            }
            l$0 = this;
        }
        obj9 = (QuerySnapshot)obj9.toObjects(BreedModel.class);
        n.e(obj9, "firestore.collectionGroup(BREED_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()\n                .await()\n                .toObjects(BreedModel::class.java)");
        ArrayList arrayList = new ArrayList(p.r(obj9, 10));
        obj9 = obj9.iterator();
        for (BreedModel next2 : obj9) {
            n.e(next2, "it");
            arrayList.add(m1.j(next2));
        }
        Object[] array = arrayList.toArray(new BreedEntity[0]);
        if (array == null) {
        } else {
            fVar.L$0 = 0;
            fVar.label = i6;
            if (l$0.f.b((BreedEntity[])Arrays.copyOf((BreedEntity[])array, array.length), fVar) == obj) {
                return obj;
            }
        }
        obj9 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        throw obj9;
    }

    private final Object o(d<? super w> d) {
        boolean gVar;
        int label;
        int i2;
        Object l$3;
        Object l$0;
        int i;
        Object l$2;
        Object l$1;
        long longValue;
        String str2;
        Object l$02;
        String str;
        Object obj9;
        gVar = d;
        label = gVar.label;
        i2 = Integer.MIN_VALUE;
        if (d instanceof c1.g && label & i2 != 0) {
            gVar = d;
            label = gVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                gVar.label = label -= i2;
            } else {
                gVar = new c1.g(this, d);
            }
        } else {
        }
        obj9 = gVar.result;
        Object obj = b.d();
        int label2 = gVar.label;
        int i3 = 3;
        int i4 = 2;
        str2 = 1;
        if (label2 != 0) {
            if (label2 != str2) {
                if (label2 != i4) {
                    if (label2 != i3) {
                    } else {
                        l$3 = gVar.L$3;
                        l$2 = gVar.L$2;
                        l$1 = gVar.L$1;
                        l$02 = gVar.L$0;
                        q.b(obj9);
                        l$3.add(w.a);
                        l$3 = l$1;
                        if (l$2.hasNext()) {
                            obj9 = l$2.next();
                            n.e((SurveyQuestionModel)obj9, "it");
                            gVar.L$0 = l$02;
                            gVar.L$1 = l$3;
                            gVar.L$2 = l$2;
                            gVar.L$3 = l$3;
                            gVar.label = i3;
                            if (l$02.c.b(m1.n(obj9), gVar) == obj) {
                                return obj;
                            } else {
                            }
                        }
                        return w.a;
                    }
                    obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj9;
                }
                l$0 = gVar.L$0;
                q.b(obj9);
            } else {
                l$0 = gVar.L$0;
                q.b(obj9);
                if ((Long)obj9 == null) {
                    longValue = 0;
                } else {
                    longValue = (Long)obj9.longValue();
                }
                obj9 = l$0.a.collectionGroup("onboardingQuestionTranslations").whereGreaterThan("updatedAt", b.d(longValue)).get();
                n.e(obj9, "firestore.collectionGroup(ONBOARDING_QUESTION_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()");
                gVar.L$0 = l$0;
                gVar.label = i4;
                if (a.a(obj9, gVar) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(obj9);
            gVar.L$0 = this;
            gVar.label = str2;
            if (this.c.a(gVar) == obj) {
                return obj;
            }
            l$0 = this;
        }
        obj9 = (QuerySnapshot)obj9.toObjects(SurveyQuestionModel.class);
        n.e(obj9, "firestore.collectionGroup(ONBOARDING_QUESTION_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()\n                .await()\n                .toObjects(SurveyQuestionModel::class.java)");
        ArrayList arrayList = new ArrayList(p.r(obj9, 10));
        l$02 = l$0;
        l$3 = arrayList;
        l$2 = obj9;
    }

    private final Object p(d<? super w> d) {
        boolean hVar;
        int label;
        Object obj;
        int i2;
        Object l$3;
        Object l$02;
        int i;
        Object l$2;
        Object l$1;
        long longValue;
        String str2;
        Object l$0;
        String str;
        Object obj9;
        hVar = d;
        label = hVar.label;
        i2 = Integer.MIN_VALUE;
        if (d instanceof c1.h && label & i2 != 0) {
            hVar = d;
            label = hVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                hVar.label = label -= i2;
            } else {
                hVar = new c1.h(this, d);
            }
        } else {
        }
        obj9 = hVar.result;
        obj = b.d();
        int label2 = hVar.label;
        int i3 = 3;
        int i4 = 2;
        str2 = 1;
        if (label2 != 0) {
            if (label2 != str2) {
                if (label2 != i4) {
                    if (label2 != i3) {
                    } else {
                        l$3 = hVar.L$3;
                        l$2 = hVar.L$2;
                        l$1 = hVar.L$1;
                        l$0 = hVar.L$0;
                        q.b(obj9);
                        l$3.add(w.a);
                        l$3 = l$1;
                        if (l$2.hasNext()) {
                            obj9 = l$2.next();
                            n.e((ProgramModel)obj9, "it");
                            hVar.L$0 = l$0;
                            hVar.L$1 = l$3;
                            hVar.L$2 = l$2;
                            hVar.L$3 = l$3;
                            hVar.label = i3;
                            if (l$0.d.f(m1.x(obj9), hVar) == obj) {
                                return obj;
                            } else {
                            }
                        }
                        return w.a;
                    }
                    obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj9;
                }
                l$02 = hVar.L$0;
                q.b(obj9);
            } else {
                l$02 = hVar.L$0;
                q.b(obj9);
                if ((Long)obj9 == null) {
                    longValue = 0;
                } else {
                    longValue = (Long)obj9.longValue();
                }
                obj9 = l$02.a.collectionGroup("programTranslations").whereGreaterThan("updatedAt", b.d(longValue)).get();
                n.e(obj9, "firestore.collectionGroup(PROGRAM_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()");
                hVar.L$0 = l$02;
                hVar.label = i4;
                if (a.a(obj9, hVar) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(obj9);
            hVar.L$0 = this;
            hVar.label = str2;
            if (this.d.n(hVar) == obj) {
                return obj;
            }
            l$02 = this;
        }
        obj9 = (QuerySnapshot)obj9.toObjects(ProgramModel.class);
        n.e(obj9, "firestore.collectionGroup(PROGRAM_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()\n                .await()\n                .toObjects(ProgramModel::class.java)");
        ArrayList arrayList = new ArrayList(p.r(obj9, 10));
        l$0 = l$02;
        l$3 = arrayList;
        l$2 = obj9;
    }

    private final Object q(d<? super w> d) {
        boolean iVar;
        int label;
        int i;
        Object l$3;
        Object l$02;
        int i2;
        Object l$2;
        Object l$1;
        long longValue;
        String str;
        Object l$0;
        String str2;
        Object obj9;
        iVar = d;
        label = iVar.label;
        i = Integer.MIN_VALUE;
        if (d instanceof c1.i && label & i != 0) {
            iVar = d;
            label = iVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                iVar.label = label -= i;
            } else {
                iVar = new c1.i(this, d);
            }
        } else {
        }
        obj9 = iVar.result;
        Object obj = b.d();
        int label2 = iVar.label;
        int i3 = 3;
        int i4 = 2;
        str = 1;
        if (label2 != 0) {
            if (label2 != str) {
                if (label2 != i4) {
                    if (label2 != i3) {
                    } else {
                        l$3 = iVar.L$3;
                        l$2 = iVar.L$2;
                        l$1 = iVar.L$1;
                        l$0 = iVar.L$0;
                        q.b(obj9);
                        l$3.add(w.a);
                        l$3 = l$1;
                        if (l$2.hasNext()) {
                            obj9 = l$2.next();
                            n.e((QuestionModel)obj9, "it");
                            iVar.L$0 = l$0;
                            iVar.L$1 = l$3;
                            iVar.L$2 = l$2;
                            iVar.L$3 = l$3;
                            iVar.label = i3;
                            if (l$0.e.g(m1.z(obj9), iVar) == obj) {
                                return obj;
                            } else {
                            }
                        }
                        return w.a;
                    }
                    obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj9;
                }
                l$02 = iVar.L$0;
                q.b(obj9);
            } else {
                l$02 = iVar.L$0;
                q.b(obj9);
                if ((Long)obj9 == null) {
                    longValue = 0;
                } else {
                    longValue = (Long)obj9.longValue();
                }
                obj9 = l$02.a.collectionGroup("questionTranslations").whereGreaterThan("updatedAt", b.d(longValue)).get();
                n.e(obj9, "firestore.collectionGroup(QUESTION_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()");
                iVar.L$0 = l$02;
                iVar.label = i4;
                if (a.a(obj9, iVar) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(obj9);
            iVar.L$0 = this;
            iVar.label = str;
            if (this.e.a(iVar) == obj) {
                return obj;
            }
            l$02 = this;
        }
        obj9 = (QuerySnapshot)obj9.toObjects(QuestionModel.class);
        n.e(obj9, "firestore.collectionGroup(QUESTION_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()\n                .await()\n                .toObjects(QuestionModel::class.java)");
        ArrayList arrayList = new ArrayList(p.r(obj9, 10));
        l$0 = l$02;
        l$3 = arrayList;
        l$2 = obj9;
    }

    private final Object r(d<? super w> d) {
        boolean jVar;
        int label;
        int i2;
        Object[] copyOf;
        Object l$0;
        int i;
        int i3;
        boolean next;
        int i4;
        int longValue;
        long str2;
        String str;
        Object obj9;
        jVar = d;
        label = jVar.label;
        i2 = Integer.MIN_VALUE;
        if (d instanceof c1.j && label & i2 != 0) {
            jVar = d;
            label = jVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                jVar.label = label -= i2;
            } else {
                jVar = new c1.j(this, d);
            }
        } else {
        }
        obj9 = jVar.result;
        Object obj = b.d();
        copyOf = jVar.label;
        int i6 = 3;
        i3 = 2;
        next = 1;
        if (copyOf != 0) {
            if (copyOf != next) {
                if (copyOf != i3) {
                    if (copyOf != i6) {
                    } else {
                        q.b(obj9);
                        return w.a;
                    }
                    obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj9;
                }
                l$0 = jVar.L$0;
                q.b(obj9);
            } else {
                l$0 = jVar.L$0;
                q.b(obj9);
                if ((Long)obj9 == null) {
                    longValue = 0;
                } else {
                    longValue = (Long)obj9.longValue();
                }
                obj9 = l$0.a.collectionGroup("taskTranslations").whereGreaterThan("updatedAt", b.d(longValue)).get();
                n.e(obj9, "firestore.collectionGroup(TASK_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()");
                jVar.L$0 = l$0;
                jVar.label = i3;
                if (a.a(obj9, jVar) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(obj9);
            jVar.L$0 = this;
            jVar.label = next;
            if (this.g.b(jVar) == obj) {
                return obj;
            }
            l$0 = this;
        }
        obj9 = (QuerySnapshot)obj9.toObjects(TasksModel.class);
        n.e(obj9, "firestore.collectionGroup(TASK_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()\n                .await()\n                .toObjects(TasksModel::class.java)");
        ArrayList arrayList = new ArrayList(p.r(obj9, 10));
        obj9 = obj9.iterator();
        for (TasksModel next2 : obj9) {
            n.e(next2, "it");
            arrayList.add(m1.B(next2));
        }
        Object[] array = arrayList.toArray(new TaskEntity[0]);
        if (array == null) {
        } else {
            jVar.L$0 = 0;
            jVar.label = i6;
            if (l$0.g.a((TaskEntity[])Arrays.copyOf((TaskEntity[])array, array.length), jVar) == obj) {
                return obj;
            }
        }
        obj9 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        throw obj9;
    }

    private final Object s(d<? super w> d) {
        boolean kVar;
        int label;
        int i;
        Object[] copyOf;
        Object l$0;
        int i2;
        int i3;
        boolean next;
        int i4;
        int longValue;
        long str;
        String str2;
        Object obj9;
        kVar = d;
        label = kVar.label;
        i = Integer.MIN_VALUE;
        if (d instanceof c1.k && label & i != 0) {
            kVar = d;
            label = kVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                kVar.label = label -= i;
            } else {
                kVar = new c1.k(this, d);
            }
        } else {
        }
        obj9 = kVar.result;
        Object obj = b.d();
        copyOf = kVar.label;
        int i6 = 3;
        i3 = 2;
        next = 1;
        if (copyOf != 0) {
            if (copyOf != next) {
                if (copyOf != i3) {
                    if (copyOf != i6) {
                    } else {
                        q.b(obj9);
                        return w.a;
                    }
                    obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj9;
                }
                l$0 = kVar.L$0;
                q.b(obj9);
            } else {
                l$0 = kVar.L$0;
                q.b(obj9);
                if ((Long)obj9 == null) {
                    longValue = 0;
                } else {
                    longValue = (Long)obj9.longValue();
                }
                obj9 = l$0.a.collectionGroup("trickCategoryTranslations").whereGreaterThan("updatedAt", b.d(longValue)).get();
                n.e(obj9, "firestore.collectionGroup(TRICK_CATEGORY_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()");
                kVar.L$0 = l$0;
                kVar.label = i3;
                if (a.a(obj9, kVar) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(obj9);
            kVar.L$0 = this;
            kVar.label = next;
            if (this.b.u(kVar) == obj) {
                return obj;
            }
            l$0 = this;
        }
        obj9 = (QuerySnapshot)obj9.toObjects(TrickModel.TrickCategory.class);
        n.e(obj9, "firestore.collectionGroup(TRICK_CATEGORY_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()\n                .await()\n                .toObjects(TrickModel.TrickCategory::class.java)");
        ArrayList arrayList = new ArrayList(p.r(obj9, 10));
        obj9 = obj9.iterator();
        for (TrickModel.TrickCategory next2 : obj9) {
            n.e(next2, "it");
            arrayList.add(m1.m(next2));
        }
        Object[] array = arrayList.toArray(new TrickCategoryEntity[0]);
        if (array == null) {
        } else {
            kVar.L$0 = 0;
            kVar.label = i6;
            if (l$0.b.l((TrickCategoryEntity[])Arrays.copyOf((TrickCategoryEntity[])array, array.length), kVar) == obj) {
                return obj;
            }
        }
        obj9 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        throw obj9;
    }

    private final Object t(d<? super w> d) {
        boolean lVar;
        int label;
        int i2;
        Object l$3;
        Object l$02;
        int i;
        Object l$2;
        Object l$1;
        long longValue;
        String str2;
        Object l$0;
        String str;
        Object obj9;
        lVar = d;
        label = lVar.label;
        i2 = Integer.MIN_VALUE;
        if (d instanceof c1.l && label & i2 != 0) {
            lVar = d;
            label = lVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                lVar.label = label -= i2;
            } else {
                lVar = new c1.l(this, d);
            }
        } else {
        }
        obj9 = lVar.result;
        Object obj = b.d();
        int label2 = lVar.label;
        int i3 = 3;
        int i4 = 2;
        str2 = 1;
        if (label2 != 0) {
            if (label2 != str2) {
                if (label2 != i4) {
                    if (label2 != i3) {
                    } else {
                        l$3 = lVar.L$3;
                        l$2 = lVar.L$2;
                        l$1 = lVar.L$1;
                        l$0 = lVar.L$0;
                        q.b(obj9);
                        l$3.add(w.a);
                        l$3 = l$1;
                        if (l$2.hasNext()) {
                            obj9 = l$2.next();
                            n.e((TrickModel)obj9, "it");
                            lVar.L$0 = l$0;
                            lVar.L$1 = l$3;
                            lVar.L$2 = l$2;
                            lVar.L$3 = l$3;
                            lVar.label = i3;
                            if (l$0.b.i(m1.D(obj9), lVar) == obj) {
                                return obj;
                            } else {
                            }
                        }
                        return w.a;
                    }
                    obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj9;
                }
                l$02 = lVar.L$0;
                q.b(obj9);
            } else {
                l$02 = lVar.L$0;
                q.b(obj9);
                if ((Long)obj9 == null) {
                    longValue = 0;
                } else {
                    longValue = (Long)obj9.longValue();
                }
                obj9 = l$02.a.collectionGroup("trickTranslations").whereGreaterThan("updatedAt", b.d(longValue)).get();
                n.e(obj9, "firestore.collectionGroup(TRICK_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()");
                lVar.L$0 = l$02;
                lVar.label = i4;
                if (a.a(obj9, lVar) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(obj9);
            lVar.L$0 = this;
            lVar.label = str2;
            if (this.b.j(lVar) == obj) {
                return obj;
            }
            l$02 = this;
        }
        obj9 = (QuerySnapshot)obj9.toObjects(TrickModel.class);
        n.e(obj9, "firestore.collectionGroup(TRICK_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()\n                .await()\n                .toObjects(TrickModel::class.java)");
        ArrayList arrayList = new ArrayList(p.r(obj9, 10));
        l$0 = l$02;
        l$3 = arrayList;
        l$2 = obj9;
    }

    private final Object u(d<? super w> d) {
        boolean mVar;
        int label;
        int i;
        Object[] copyOf;
        Object l$0;
        int i3;
        int i2;
        boolean next;
        int i4;
        int longValue;
        long str;
        String str2;
        Object obj9;
        mVar = d;
        label = mVar.label;
        i = Integer.MIN_VALUE;
        if (d instanceof c1.m && label & i != 0) {
            mVar = d;
            label = mVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                mVar.label = label -= i;
            } else {
                mVar = new c1.m(this, d);
            }
        } else {
        }
        obj9 = mVar.result;
        Object obj = b.d();
        copyOf = mVar.label;
        int i6 = 3;
        i2 = 2;
        next = 1;
        if (copyOf != 0) {
            if (copyOf != next) {
                if (copyOf != i2) {
                    if (copyOf != i6) {
                    } else {
                        q.b(obj9);
                        return w.a;
                    }
                    obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj9;
                }
                l$0 = mVar.L$0;
                q.b(obj9);
            } else {
                l$0 = mVar.L$0;
                q.b(obj9);
                if ((Long)obj9 == null) {
                    longValue = 0;
                } else {
                    longValue = (Long)obj9.longValue();
                }
                obj9 = l$0.a.collectionGroup("trickTagTranslations").whereGreaterThan("updatedAt", b.d(longValue)).get();
                n.e(obj9, "firestore.collectionGroup(TRICK_TAG_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()");
                mVar.L$0 = l$0;
                mVar.label = i2;
                if (a.a(obj9, mVar) == obj) {
                    return obj;
                }
            }
        } else {
            q.b(obj9);
            mVar.L$0 = this;
            mVar.label = next;
            if (this.b.a(mVar) == obj) {
                return obj;
            }
            l$0 = this;
        }
        obj9 = (QuerySnapshot)obj9.toObjects(TrickModel.TrickTag.class);
        n.e(obj9, "firestore.collectionGroup(TRICK_TAG_GROUP_COLLECTION)\n                .whereGreaterThan(TIMESTAMP, timestamp)\n                .get()\n                .await()\n                .toObjects(TrickModel.TrickTag::class.java)");
        ArrayList arrayList = new ArrayList(p.r(obj9, 10));
        obj9 = obj9.iterator();
        for (TrickModel.TrickTag next2 : obj9) {
            n.e(next2, "it");
            arrayList.add(m1.K(next2));
        }
        Object[] array = arrayList.toArray(new TrickTagEntity[0]);
        if (array == null) {
        } else {
            mVar.L$0 = 0;
            mVar.label = i6;
            if (l$0.b.p((TrickTagEntity[])Arrays.copyOf((TrickTagEntity[])array, array.length), mVar) == obj) {
                return obj;
            }
        }
        obj9 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        throw obj9;
    }

    public final void k() {
        c1.b bVar = new c1.b(CoroutineExceptionHandler.r);
        int i = 0;
        c1.c cVar = new c1.c(this, i);
        k.d(n0.a(s2.b(i, 1, i).plus(c1.b()).plus(bVar)), 0, 0, cVar, 3, 0);
    }
}
