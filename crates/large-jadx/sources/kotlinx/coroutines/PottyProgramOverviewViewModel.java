package app.dogo.com.dogo_android.u.n;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.s.a.g3;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.h0;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r;
import app.dogo.com.dogo_android.w.s0;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.w0;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.m0;

/* compiled from: PottyProgramOverviewViewModel.kt */
@Metadata(d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\t\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\n\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0006\u0010\"\u001a\u00020#J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u001fH\u0002J\u0006\u0010&\u001a\u00020#J\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u001fH\u0002J\u0006\u0010)\u001a\u00020#J\u0006\u0010*\u001a\u00020#J\u000e\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020#2\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u00020#J\u0006\u00102\u001a\u00020#J\u0006\u00103\u001a\u00020#J\u000e\u00104\u001a\u00020#2\u0006\u00105\u001a\u00020-J\u0006\u00106\u001a\u00020#J\u0016\u00107\u001a\u00020#2\u0006\u00108\u001a\u00020-2\u0006\u00109\u001a\u00020\u0017R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008 \u0010!R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/PottyProgramOverviewViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/PottyProgramOverviewInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "timeUtilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "(Lapp/dogo/com/dogo_android/repository/interactor/PottyProgramOverviewInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/service/AuthService;)V", "certificateUnlockedTrigger", "Lcom/hadilq/liveevent/LiveEvent;", "", "getCertificateUnlockedTrigger", "()Lcom/hadilq/liveevent/LiveEvent;", "resultExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "results", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "getResults", "()Landroidx/lifecycle/MutableLiveData;", "enrollToProgramEnrollment", "", "isFirstTimeUnlockedCertificate", "programViewItem", "loadData", "postProgramItem", "item", "retry", "setPottyCertificateUnlockedShowed", "trackArticleTapped", "articleId", "", "trackCalendarCardTapped", "streakCount", "", "trackCertificateTapped", "trackLogActivityClicked", "trackNewReminderTapped", "trackPottyTrackerCardTapped", "action", "unEnrollFromProgramEnrollment", "updateReminderState", "reminderId", "newState", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n, reason: from kotlin metadata */
public final class PottyProgramOverviewViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final g3 authService;
    private final p1 b;
    /* renamed from: c, reason: from kotlin metadata */
    private final o3 connectivityService;
    /* renamed from: d, reason: from kotlin metadata */
    private final l1 interactor;
    /* renamed from: e, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.service.j2 preferenceService;
    /* renamed from: f, reason: from kotlin metadata */
    private final v2 programRepository;
    /* renamed from: g, reason: from kotlin metadata */
    private final p2 reminderRepository;
    /* renamed from: h, reason: from kotlin metadata */
    private final j1 resultExceptionHandler;
    private final h2 i;
    /* renamed from: j, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> timeUtilities = new a<>();
    /* renamed from: k, reason: from kotlin metadata */
    private final x<y<SpecialProgramOverviewItem>> tracker = new x<>();
    /* renamed from: l, reason: from kotlin metadata */
    private final CoroutineExceptionHandler userRepository = new n$c();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ n a;
        public c(CoroutineExceptionHandler.a exc, n nVar) {
            this.a = nVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.s().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.potty.PottyProgramOverviewViewModel$enrollToProgramEnrollment$1", f = "PottyProgramOverviewViewModel.kt", l = {72, 74, 75}, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label2;
            int i = 1;
            String object2;
            String str;
            Long l;
            Long l2 = null;
            d dVar;
            int i2 = 8;
            Object obj = null;
            SpecialProgramOverviewItem specialProgramOverviewItem;
            Object obj3;
            Object obj4 = b.d();
            final int i3 = 3;
            final int i4 = 2;
            i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    if (this.label != i4) {
                        if (this.label != i3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(object);
                            n.this.v((SpecialProgramOverviewItem)specialProgramOverviewItem);
                            return w.a;
                        }
                    }
                    q.b(object);
                } else {
                    q.b(object);
                    l2 = null;
                    i2 = 8;
                    obj = null;
                    this.label = i4;
                    str = "id_potty_program";
                    if (ProgramRepository.H(n.this.resultExceptionHandler, (String)obj3, str, b.d(n.this.programRepository.g()), l2, this, i2, obj) == obj4) {
                        return obj4;
                    }
                }
            } else {
                q.b(object);
                n.this.s().setValue(LoadResult_Loading.a);
                this.label = i;
                if (n.this.b.u(this) == obj4) {
                    return obj4;
                }
            }
            this.label = i3;
            if (n.this.authService.h(this) == obj4) {
                return obj4;
            }
        }

        a(d<? super n.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.n.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.n.a(n.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.potty.PottyProgramOverviewViewModel$loadData$1", f = "PottyProgramOverviewViewModel.kt", l = 54, m = "invokeSuspend")
    static final class b extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label2;
            SpecialProgramOverviewItem specialProgramOverviewItem;
            Object obj = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    n.this.v((SpecialProgramOverviewItem)specialProgramOverviewItem);
                    return w.a;
                }
            }
            q.b(object);
            n.this.s().postValue(LoadResult_Loading.a);
            if (n.this.preferenceService.a()) {
                this.label = i;
                if (n.this.authService.h(this) == obj) {
                    return obj;
                }
            } else {
                n.this.connectivityService.setTrainingReminderUserProperties("potty_overview");
                n.this.s().postValue(new LoadResult_Error(new UnknownHostException()));
            }
        }

        b(d<? super n.b> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.n.b)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.n.b(n.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.potty.PottyProgramOverviewViewModel$unEnrollFromProgramEnrollment$1", f = "PottyProgramOverviewViewModel.kt", l = {85, 87, 88}, m = "invokeSuspend")
    static final class d extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label2;
            int i = 1;
            String object2;
            String str;
            int i2;
            Long l;
            d dVar;
            int i3 = 4;
            Object obj = null;
            SpecialProgramOverviewItem specialProgramOverviewItem;
            Object obj3;
            Object obj4 = b.d();
            final int i4 = 3;
            final int i5 = 2;
            i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    if (this.label != i5) {
                        if (this.label != i4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(object);
                            n.this.v((SpecialProgramOverviewItem)specialProgramOverviewItem);
                            return w.a;
                        }
                    }
                    q.b(object);
                } else {
                    q.b(object);
                    i3 = 4;
                    obj = null;
                    this.label = i5;
                    str = "id_potty_program";
                    if (ProgramRepository.H(n.this.resultExceptionHandler, (String)obj3, str, null, b.d(n.this.programRepository.g()), this, i3, obj) == obj4) {
                        return obj4;
                    }
                }
            } else {
                q.b(object);
                n.this.s().setValue(LoadResult_Loading.a);
                this.label = i;
                if (n.this.b.u(this) == obj4) {
                    return obj4;
                }
            }
            this.label = i4;
            if (n.this.authService.h(this) == obj4) {
                return obj4;
            }
        }

        d(d<? super n.d> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.n.d)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.n.d(n.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.potty.PottyProgramOverviewViewModel$updateReminderState$1", f = "PottyProgramOverviewViewModel.kt", l = {}, m = "invokeSuspend")
    static final class e extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        final /* synthetic */ boolean $newState;
        final /* synthetic */ String $reminderId;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                n.this.interactor.U(n.this.i.v(), this.$reminderId, this.$newState).e();
                return w.a;
            }
        }

        e(String str, boolean z, d<? super n.e> dVar) {
            this.$reminderId = str;
            this.$newState = z;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.n.e)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.n.e(n.this, this.$reminderId, this.$newState, dVar);
        }
    }
    public n(g3 g3Var, p1 p1Var, o3 o3Var, l1 l1Var, app.dogo.com.dogo_android.service.j2 j2Var, v2 v2Var, p2 p2Var, j1 j1Var, h2 h2Var) {
        n.f(g3Var, "interactor");
        n.f(p1Var, "userRepository");
        n.f(o3Var, "tracker");
        n.f(l1Var, "reminderRepository");
        n.f(j2Var, "connectivityService");
        n.f(v2Var, "timeUtilities");
        n.f(p2Var, "preferenceService");
        n.f(j1Var, "programRepository");
        n.f(h2Var, "authService");
        super();
        this.authService = g3Var;
        this.b = p1Var;
        this.connectivityService = o3Var;
        this.interactor = l1Var;
        this.preferenceService = j2Var;
        this.programRepository = v2Var;
        this.reminderRepository = p2Var;
        this.resultExceptionHandler = j1Var;
        this.i = h2Var;
        f.d.a.a aVar = new a();
        x xVar = new x();
        final app.dogo.com.dogo_android.u.n.n.c coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ h2 isFirstTimeUnlockedCertificate(n programViewItem) {
        return programViewItem.i;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ app.dogo.com.dogo_android.service.j2 postProgramItem(n item) {
        return item.preferenceService;
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final /* synthetic */ g3 trackArticleTapped(n articleId) {
        return articleId.authService;
    }

    /* renamed from: k, reason: from kotlin metadata */
    public static final /* synthetic */ j1 trackCalendarCardTapped(n streakCount) {
        return streakCount.resultExceptionHandler;
    }

    /* renamed from: l, reason: from kotlin metadata */
    public static final /* synthetic */ l1 trackPottyTrackerCardTapped(n action) {
        return action.interactor;
    }

    public static final /* synthetic */ v2 m(n nVar) {
        return nVar.programRepository;
    }

    public static final /* synthetic */ o3 n(n nVar) {
        return nVar.connectivityService;
    }

    public static final /* synthetic */ p1 o(n nVar) {
        return nVar.b;
    }

    /* renamed from: p, reason: from kotlin metadata */
    public static final /* synthetic */ void updateReminderState(n reminderId, SpecialProgramOverviewItem newState) {
        reminderId.v(newState);
    }

    private final boolean t(SpecialProgramOverviewItem specialProgramOverviewItem) {
        boolean z = false;
        if (specialProgramOverviewItem.getProgramProgress().hasReachedPottyGoal()) {
            specialProgramOverviewItem = !this.reminderRepository.Q() ? 1 : 0;
        }
        return (!this.reminderRepository.Q() ? 1 : 0);
    }

    private final void v(SpecialProgramOverviewItem specialProgramOverviewItem) {
        this.tracker.setValue(new LoadResult_Success(specialProgramOverviewItem));
        this.timeUtilities.postValue(Boolean.valueOf(t(specialProgramOverviewItem)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: A, reason: from kotlin metadata */
    public final void enrollToProgramEnrollment() {
        this.connectivityService.logEvent(E_Calendar.b.withParameters(u.a(new EP_Type(), "potty")));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void B(String str) {
        n.f(str, "action");
        this.connectivityService.logEvent(E_PottyProgram.e.withParameters(u.a(new EP_Action(), str)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void C() {
        z = this.tracker.getValue() instanceof LoadResult_Loading;
        if (!(this.tracker.getValue() instanceof oadResult_Loading)) {
            kotlinx.coroutines.o0 o0Var = null;
            int i = 2;
            Object obj = null;
            kotlinx.coroutines.internal.k.d(f0.a(this), this.userRepository, o0Var, new kotlinx.coroutines.n.d(this, null), i, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void D(String str, boolean z) {
        n.f(str, "reminderId");
        kotlinx.coroutines.internal.k.d(f0.a(this), Dispatchers.b().plus(this.userRepository), null, new kotlinx.coroutines.n.e(this, str, z, null), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q() {
        z = this.tracker.getValue() instanceof LoadResult_Loading;
        if (!(this.tracker.getValue() instanceof oadResult_Loading)) {
            kotlinx.coroutines.o0 o0Var = null;
            int i = 2;
            Object obj = null;
            kotlinx.coroutines.internal.k.d(f0.a(this), this.userRepository, o0Var, new kotlinx.coroutines.n.a(this, null), i, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> r() {
        return this.timeUtilities;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<SpecialProgramOverviewItem>> s() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u() {
        final d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.userRepository, dVar, new kotlinx.coroutines.n.b(this, dVar), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w() {
        this.reminderRepository.j1(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x(String str) {
        n.f(str, "articleId");
        this.connectivityService.logEvent(E_PottyProgram.c.withParameters(u.a(new EP_ArticleId(), str)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(int i) {
        this.connectivityService.logEvent(E_Calendar.c.withParameters(u.a(new EP_Streak(), Integer.valueOf(i))));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z() {
        this.connectivityService.logEvent(E_PottyProgram.d);
    }
}
