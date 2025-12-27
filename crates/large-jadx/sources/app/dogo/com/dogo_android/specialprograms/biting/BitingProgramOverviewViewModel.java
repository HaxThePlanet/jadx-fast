package app.dogo.com.dogo_android.u.m;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.s.a.z1;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.e2;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q1;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.w0;
import app.dogo.com.dogo_android.w.w2;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;

/* compiled from: BitingProgramOverviewViewModel.kt */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\r\u0018\u00002\u00020\u0001:\u00015B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u001fJ\u0006\u0010#\u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%J\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020%J\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020)J\u0006\u0010.\u001a\u00020\u001fJ\u0016\u0010/\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020)2\u0006\u00100\u001a\u00020)J\u0006\u00101\u001a\u00020\u001fJ\u0010\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u001bH\u0002J\u0010\u00104\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u001bH\u0002R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/BitingProgramOverviewInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "timeUtilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lapp/dogo/com/dogo_android/repository/interactor/BitingProgramOverviewInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "certificateUnlockedTrigger", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewViewModel$CertificateUnlockState;", "getCertificateUnlockedTrigger", "()Lcom/hadilq/liveevent/LiveEvent;", "resultExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "results", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "getResults", "()Landroidx/lifecycle/MutableLiveData;", "enrollToProgramEnrollment", "", "getZendeskUnreadMessagesData", "", "loadData", "retry", "shouldDisplayUnlockHelplineScreen", "", "isPremiumUser", "trackArticleTapped", "articleId", "", "trackCertificateTapped", "locked", "trackCoreTrickTapped", "trickId", "trackHelpClick", "trackVariationTapped", "variationId", "unEnrollFromProgramEnrollment", "updateCertificateAnimationState", "programViewItem", "updateResults", "CertificateUnlockState", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: p, reason: from kotlin metadata */
public final class BitingProgramOverviewViewModel extends s {

    private final z1 a;
    /* renamed from: b, reason: from kotlin metadata */
    private final p1 connectivityService;
    /* renamed from: c, reason: from kotlin metadata */
    private final o3 interactor;
    /* renamed from: d, reason: from kotlin metadata */
    private final j2 programRepository;
    /* renamed from: e, reason: from kotlin metadata */
    private final j1 remoteConfigService;
    /* renamed from: f, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.service.v2 resultExceptionHandler;
    private final r2 g;
    /* renamed from: h, reason: from kotlin metadata */
    private final androidx.lifecycle.x<y<SpecialProgramOverviewItem>> timeUtilities = new x<>();
    /* renamed from: i, reason: from kotlin metadata */
    private final f.d.a.a<p.a> tracker = new a<>();
    /* renamed from: j, reason: from kotlin metadata */
    private final CoroutineExceptionHandler userRepository = new p$d();

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewViewModel$CertificateUnlockState;", "", "(Ljava/lang/String;I)V", "NOT_UNLOCKED", "FRESH_UNLOCK", "ALREADY_UNLOCKED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum a {

        ALREADY_UNLOCKED,
        FRESH_UNLOCK,
        NOT_UNLOCKED;
        private static final /* synthetic */ p.a[] $values() {
            app.dogo.com.dogo_android.u.m.p.a[] arr = new p.a[3];
            return new p.a[] { BitingProgramOverviewViewModel_CertificateUnlockState.NOT_UNLOCKED, BitingProgramOverviewViewModel_CertificateUnlockState.FRESH_UNLOCK, BitingProgramOverviewViewModel_CertificateUnlockState.ALREADY_UNLOCKED };
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ p a;
        public d(CoroutineExceptionHandler.a exc, p pVar) {
            this.a = pVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.q().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.biting.BitingProgramOverviewViewModel$enrollToProgramEnrollment$1", f = "BitingProgramOverviewViewModel.kt", l = {77, 79, 80}, m = "invokeSuspend")
    static final class b extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

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
                            p.this.trackArticleTapped((SpecialProgramOverviewItem)specialProgramOverviewItem);
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
                    str = "id_nipping_program";
                    if (ProgramRepository.H(p.this.remoteConfigService, (String)obj3, str, b.d(p.this.resultExceptionHandler.g()), l2, this, i2, obj) == obj4) {
                        return obj4;
                    }
                }
            } else {
                q.b(object);
                p.this.q().postValue(LoadResult_Loading.a);
                this.label = i;
                if (p.this.connectivityService.u(this) == obj4) {
                    return obj4;
                }
            }
            this.label = i3;
            if (p.this.a.k(this) == obj4) {
                return obj4;
            }
        }

        b(d<? super p.b> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.specialprograms.biting.p.b)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.specialprograms.biting.p.b(p.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.biting.BitingProgramOverviewViewModel$loadData$1", f = "BitingProgramOverviewViewModel.kt", l = 49, m = "invokeSuspend")
    static final class c extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

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
                    p.this.trackArticleTapped((SpecialProgramOverviewItem)specialProgramOverviewItem);
                    return w.a;
                }
            }
            q.b(object);
            p.this.q().postValue(LoadResult_Loading.a);
            if (p.this.programRepository.a()) {
                this.label = i;
                if (p.this.a.k(this) == obj) {
                    return obj;
                }
            } else {
                p.this.interactor.s("biting_overview");
                p.this.q().postValue(new LoadResult_Error(new UnknownHostException()));
            }
        }

        c(d<? super p.c> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.specialprograms.biting.p.c)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.specialprograms.biting.p.c(p.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.biting.BitingProgramOverviewViewModel$unEnrollFromProgramEnrollment$1", f = "BitingProgramOverviewViewModel.kt", l = {91, 93, 94}, m = "invokeSuspend")
    static final class e extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

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
                            p.this.trackArticleTapped((SpecialProgramOverviewItem)specialProgramOverviewItem);
                            return w.a;
                        }
                    }
                    q.b(object);
                } else {
                    q.b(object);
                    i3 = 4;
                    obj = null;
                    this.label = i5;
                    str = "id_nipping_program";
                    if (ProgramRepository.H(p.this.remoteConfigService, (String)obj3, str, null, b.d(p.this.resultExceptionHandler.g()), this, i3, obj) == obj4) {
                        return obj4;
                    }
                }
            } else {
                q.b(object);
                p.this.q().postValue(LoadResult_Loading.a);
                this.label = i;
                if (p.this.connectivityService.u(this) == obj4) {
                    return obj4;
                }
            }
            this.label = i4;
            if (p.this.a.k(this) == obj4) {
                return obj4;
            }
        }

        e(d<? super p.e> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.specialprograms.biting.p.e)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.specialprograms.biting.p.e(p.this, dVar);
        }
    }
    public p(z1 z1Var, p1 p1Var, o3 o3Var, j2 j2Var, j1 j1Var, app.dogo.com.dogo_android.service.v2 v2Var, r2 r2Var) {
        n.f(z1Var, "interactor");
        n.f(p1Var, "userRepository");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        n.f(j1Var, "programRepository");
        n.f(v2Var, "timeUtilities");
        n.f(r2Var, "remoteConfigService");
        super();
        this.a = z1Var;
        this.connectivityService = p1Var;
        this.interactor = o3Var;
        this.programRepository = j2Var;
        this.remoteConfigService = j1Var;
        this.resultExceptionHandler = v2Var;
        this.g = r2Var;
        androidx.lifecycle.x xVar = new x();
        f.d.a.a aVar = new a();
        final app.dogo.com.dogo_android.u.m.p.d coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }

    /* renamed from: A, reason: from kotlin metadata */
    private final void shouldDisplayUnlockHelplineScreen(SpecialProgramOverviewItem isPremiumUser) {
        Object value;
        int i = 1;
        value = this.tracker.getValue();
        i = 1;
        i = 0;
        if (value == null) {
            int r3 = isPremiumUser.getCertificate().isCertificateUnlocked() ? 1 : i;
        }
        final app.dogo.com.dogo_android.u.m.p.a nOT_UNLOCKED2 = BitingProgramOverviewViewModel_CertificateUnlockState.NOT_UNLOCKED;
        if (value == BitingProgramOverviewViewModel_CertificateUnlockState.NOT_UNLOCKED) {
            if (!(isPremiumUser.getCertificate().isCertificateUnlocked())) {
            }
        }
        if (i != 0) {
            this.tracker.postValue(BitingProgramOverviewViewModel_CertificateUnlockState.ALREADY_UNLOCKED);
        } else {
            if (i != 0) {
                this.tracker.postValue(BitingProgramOverviewViewModel_CertificateUnlockState.FRESH_UNLOCK);
            } else {
                if (isPremiumUser.getCertificate().isCertificateUnlocked()) {
                    this.tracker.postValue(BitingProgramOverviewViewModel_CertificateUnlockState.ALREADY_UNLOCKED);
                } else {
                    this.tracker.postValue(BitingProgramOverviewViewModel_CertificateUnlockState.NOT_UNLOCKED);
                }
            }
        }
    }

    /* renamed from: B, reason: from kotlin metadata */
    private final void trackArticleTapped(SpecialProgramOverviewItem articleId) {
        this.timeUtilities.postValue(new LoadResult_Success(articleId));
        shouldDisplayUnlockHelplineScreen(articleId);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 trackCertificateTapped(p locked) {
        return locked.programRepository;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ z1 trackCoreTrickTapped(p trickId) {
        return trickId.a;
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final /* synthetic */ j1 updateCertificateAnimationState(p programViewItem) {
        return programViewItem.remoteConfigService;
    }

    /* renamed from: k, reason: from kotlin metadata */
    public static final /* synthetic */ app.dogo.com.dogo_android.service.v2 updateResults(p programViewItem) {
        return programViewItem.resultExceptionHandler;
    }

    public static final /* synthetic */ o3 l(p pVar) {
        return pVar.interactor;
    }

    public static final /* synthetic */ p1 m(p pVar) {
        return pVar.connectivityService;
    }

    /* renamed from: n, reason: from kotlin metadata */
    public static final /* synthetic */ void trackVariationTapped(p trickId, SpecialProgramOverviewItem variationId) {
        trickId.trackArticleTapped(variationId);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: o, reason: from kotlin metadata */
    public final void enrollToProgramEnrollment() {
        z = this.timeUtilities.getValue() instanceof LoadResult_Loading;
        if (!(this.timeUtilities.getValue() instanceof oadResult_Loading)) {
            this.interactor.d(E_BitingProgram.b.d(u.a(new EP_Type(), "remove")));
            kotlinx.coroutines.o0 o0Var = null;
            int i = 2;
            Object obj = null;
            kotlinx.coroutines.internal.k.d(f0.a(this), this.userRepository, o0Var, new app.dogo.com.dogo_android.specialprograms.biting.p.b(this, null), i, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<p.a> p() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final androidx.lifecycle.x<y<SpecialProgramOverviewItem>> q() {
        return this.timeUtilities;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final int r() {
        int i = 0;
        int unreadZendeskMessages = 0;
        LoadResult_Success r0 = this.timeUtilities.getValue() instanceof LoadResult_Success ? (oadResult_Success)this.timeUtilities.getValue() : 0;
        unreadZendeskMessages = 0;
        if (this.timeUtilities != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                unreadZendeskMessages = component1.getUnreadZendeskMessages();
            }
        }
        return unreadZendeskMessages;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s() {
        final d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.userRepository, dVar, new app.dogo.com.dogo_android.specialprograms.biting.p.c(this, dVar), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean t(boolean z) {
        boolean z3 = false;
        z = this.g.T() && !z ? 1 : 0;
        return (this.g.T() && !z ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(String str) {
        n.f(str, "articleId");
        this.interactor.d(E_BitingProgram.f.d(u.a(new EP_ArticleId(), str)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v(boolean z) {
        this.interactor.d(E_BitingProgram.a.d(u.a(new EP_Type(), Boolean.valueOf(z))));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w(String str) {
        n.f(str, "trickId");
        this.interactor.d(E_BitingProgram.d.withParameters(u.a(new EP_ProgramId(), "id_nipping_program"), u.a(new EP_TrickId(), str)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        this.interactor.d(E_Dashboard.o);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(String str, String str2) {
        n.f(str, "trickId");
        n.f(str2, "variationId");
        this.interactor.d(E_BitingProgram.e.withParameters(u.a(new EP_ProgramId(), "id_nipping_program"), u.a(new EP_TrickId(), str), u.a(new EP_Id(), str2)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z() {
        z = this.timeUtilities.getValue() instanceof LoadResult_Loading;
        if (!(this.timeUtilities.getValue() instanceof oadResult_Loading)) {
            this.interactor.d(E_BitingProgram.b.d(u.a(new EP_Type(), "remove")));
            kotlinx.coroutines.o0 o0Var = null;
            int i = 2;
            Object obj = null;
            kotlinx.coroutines.internal.k.d(f0.a(this), this.userRepository, o0Var, new app.dogo.com.dogo_android.specialprograms.biting.p.e(this, null), i, obj);
        }
    }
}
