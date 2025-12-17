package app.dogo.com.dogo_android.u.m;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.s.a.z1;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.e2;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q;
import app.dogo.com.dogo_android.w.q1;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.v2;
import app.dogo.com.dogo_android.w.w0;
import app.dogo.com.dogo_android.w.w2;
import app.dogo.com.dogo_android.w.x;
import f.d.a.a;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.u;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\r\u0018\u00002\u00020\u0001:\u00015B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020\u001fJ\u0006\u0010#\u001a\u00020\u001fJ\u000e\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%J\u000e\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020\u001f2\u0006\u0010+\u001a\u00020%J\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020)J\u0006\u0010.\u001a\u00020\u001fJ\u0016\u0010/\u001a\u00020\u001f2\u0006\u0010-\u001a\u00020)2\u0006\u00100\u001a\u00020)J\u0006\u00101\u001a\u00020\u001fJ\u0010\u00102\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u001bH\u0002J\u0010\u00104\u001a\u00020\u001f2\u0006\u00103\u001a\u00020\u001bH\u0002R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a0\u0019¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "interactor", "Lapp/dogo/com/dogo_android/repository/interactor/BitingProgramOverviewInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "timeUtilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lapp/dogo/com/dogo_android/repository/interactor/BitingProgramOverviewInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "certificateUnlockedTrigger", "Lcom/hadilq/liveevent/LiveEvent;", "Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewViewModel$CertificateUnlockState;", "getCertificateUnlockedTrigger", "()Lcom/hadilq/liveevent/LiveEvent;", "resultExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "results", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "getResults", "()Landroidx/lifecycle/MutableLiveData;", "enrollToProgramEnrollment", "", "getZendeskUnreadMessagesData", "", "loadData", "retry", "shouldDisplayUnlockHelplineScreen", "", "isPremiumUser", "trackArticleTapped", "articleId", "", "trackCertificateTapped", "locked", "trackCoreTrickTapped", "trickId", "trackHelpClick", "trackVariationTapped", "variationId", "unEnrollFromProgramEnrollment", "updateCertificateAnimationState", "programViewItem", "updateResults", "CertificateUnlockState", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class p extends s {

    private final z1 a;
    private final p1 b;
    private final o3 c;
    private final j2 d;
    private final j1 e;
    private final v2 f;
    private final r2 g;
    private final x<y<SpecialProgramOverviewItem>> h;
    private final a<app.dogo.com.dogo_android.u.m.p.a> i;
    private final CoroutineExceptionHandler j;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/biting/BitingProgramOverviewViewModel$CertificateUnlockState;", "", "(Ljava/lang/String;I)V", "NOT_UNLOCKED", "FRESH_UNLOCK", "ALREADY_UNLOCKED", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum a {

        NOT_UNLOCKED,
        FRESH_UNLOCK,
        ALREADY_UNLOCKED;
        private static final app.dogo.com.dogo_android.u.m.p.a[] $values() {
            app.dogo.com.dogo_android.u.m.p.a[] arr = new p.a[3];
            return arr;
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.u.m.p a;
        public d(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.u.m.p p2) {
            this.a = p2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.q().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.biting.BitingProgramOverviewViewModel$enrollToProgramEnrollment$1", f = "BitingProgramOverviewViewModel.kt", l = {77, 79, 80}, m = "invokeSuspend")
    static final class b extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.u.m.p this$0;
        b(app.dogo.com.dogo_android.u.m.p p, d<? super app.dogo.com.dogo_android.u.m.p.b> d2) {
            this.this$0 = p;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (p.b)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            p.b obj2 = new p.b(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label;
            int i2;
            Object obj2;
            String str;
            long l;
            int i4;
            Object obj;
            int i;
            int i3;
            Object obj13;
            Object obj3 = b.d();
            label = this.label;
            final int i5 = 3;
            final int i6 = 2;
            i2 = 1;
            if (label != 0) {
                if (label != i2) {
                    if (label != i6) {
                        if (label != i5) {
                        } else {
                            q.b(object);
                            p.n(this.this$0, (SpecialProgramOverviewItem)obj13);
                            return w.a;
                        }
                        obj13 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj13;
                    }
                    q.b(object);
                } else {
                    q.b(object);
                    this.label = i6;
                    if (j1.H(p.j(this.this$0), (String)obj13, "id_nipping_program", b.d(p.k(this.this$0).g()), 0, this, 8, 0) == obj3) {
                        return obj3;
                    }
                }
            } else {
                q.b(object);
                this.this$0.q().postValue(y.b.a);
                this.label = i2;
                if (p.m(this.this$0).u(this) == obj3) {
                    return obj3;
                }
            }
            this.label = i5;
            if (p.i(this.this$0).k(this) == obj3) {
                return obj3;
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.biting.BitingProgramOverviewViewModel$loadData$1", f = "BitingProgramOverviewViewModel.kt", l = 49, m = "invokeSuspend")
    static final class c extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.u.m.p this$0;
        c(app.dogo.com.dogo_android.u.m.p p, d<? super app.dogo.com.dogo_android.u.m.p.c> d2) {
            this.this$0 = p;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (p.c)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            p.c obj2 = new p.c(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object aVar;
            int unknownHostException;
            Object obj4;
            Object obj = b.d();
            unknownHostException = this.label;
            final int i = 1;
            if (unknownHostException != null) {
                if (unknownHostException != i) {
                } else {
                    q.b(object);
                    p.n(this.this$0, (SpecialProgramOverviewItem)obj4);
                    return w.a;
                }
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
            }
            q.b(object);
            this.this$0.q().postValue(y.b.a);
            if (!p.h(this.this$0).a()) {
                p.l(this.this$0).s("biting_overview");
                unknownHostException = new UnknownHostException();
                aVar = new y.a(unknownHostException);
                this.this$0.q().postValue(aVar);
            } else {
                this.label = i;
                if (p.i(this.this$0).k(this) == obj) {
                    return obj;
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.biting.BitingProgramOverviewViewModel$unEnrollFromProgramEnrollment$1", f = "BitingProgramOverviewViewModel.kt", l = {91, 93, 94}, m = "invokeSuspend")
    static final class e extends k implements p<m0, d<? super w>, Object> {

        int label;
        final app.dogo.com.dogo_android.u.m.p this$0;
        e(app.dogo.com.dogo_android.u.m.p p, d<? super app.dogo.com.dogo_android.u.m.p.e> d2) {
            this.this$0 = p;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (p.e)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            p.e obj2 = new p.e(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label;
            int i;
            Object obj2;
            String str;
            long l;
            Long num;
            Object obj;
            int i2;
            int i3;
            Object obj13;
            Object obj3 = b.d();
            label = this.label;
            final int i4 = 3;
            final int i5 = 2;
            i = 1;
            if (label != 0) {
                if (label != i) {
                    if (label != i5) {
                        if (label != i4) {
                        } else {
                            q.b(object);
                            p.n(this.this$0, (SpecialProgramOverviewItem)obj13);
                            return w.a;
                        }
                        obj13 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj13;
                    }
                    q.b(object);
                } else {
                    q.b(object);
                    this.label = i5;
                    if (j1.H(p.j(this.this$0), (String)obj13, "id_nipping_program", 0, b.d(p.k(this.this$0).g()), this, 4, 0) == obj3) {
                        return obj3;
                    }
                }
            } else {
                q.b(object);
                this.this$0.q().postValue(y.b.a);
                this.label = i;
                if (p.m(this.this$0).u(this) == obj3) {
                    return obj3;
                }
            }
            this.label = i4;
            if (p.i(this.this$0).k(this) == obj3) {
                return obj3;
            }
        }
    }
    public p(z1 z1, p1 p12, o3 o33, j2 j24, j1 j15, v2 v26, r2 r27) {
        n.f(z1, "interactor");
        n.f(p12, "userRepository");
        n.f(o33, "tracker");
        n.f(j24, "connectivityService");
        n.f(j15, "programRepository");
        n.f(v26, "timeUtilities");
        n.f(r27, "remoteConfigService");
        super();
        this.a = z1;
        this.b = p12;
        this.c = o33;
        this.d = j24;
        this.e = j15;
        this.f = v26;
        this.g = r27;
        x obj2 = new x();
        this.h = obj2;
        obj2 = new a();
        this.i = obj2;
        p.d obj3 = new p.d(CoroutineExceptionHandler.r, this);
        this.j = obj3;
    }

    private final void A(SpecialProgramOverviewItem specialProgramOverviewItem) {
        Object certificateUnlocked;
        int i2;
        boolean certificateUnlocked2;
        int i;
        a obj6;
        certificateUnlocked = this.i.getValue();
        final int i3 = 0;
        if ((p.a)certificateUnlocked == null && specialProgramOverviewItem.getCertificate().isCertificateUnlocked()) {
            i = specialProgramOverviewItem.getCertificate().isCertificateUnlocked() ? i2 : i3;
        } else {
        }
        final app.dogo.com.dogo_android.u.m.p.a nOT_UNLOCKED = p.a.NOT_UNLOCKED;
        if ((p.a)certificateUnlocked == nOT_UNLOCKED && specialProgramOverviewItem.getCertificate().isCertificateUnlocked()) {
            if (specialProgramOverviewItem.getCertificate().isCertificateUnlocked()) {
            } else {
                i2 = i3;
            }
        } else {
        }
        if (i != 0) {
            this.i.postValue(p.a.ALREADY_UNLOCKED);
        } else {
            if (i2 != 0) {
                this.i.postValue(p.a.FRESH_UNLOCK);
            } else {
                if (specialProgramOverviewItem.getCertificate().isCertificateUnlocked()) {
                    this.i.postValue(p.a.ALREADY_UNLOCKED);
                } else {
                    this.i.postValue(nOT_UNLOCKED);
                }
            }
        }
    }

    private final void B(SpecialProgramOverviewItem specialProgramOverviewItem) {
        y.c cVar = new y.c(specialProgramOverviewItem);
        this.h.postValue(cVar);
        A(specialProgramOverviewItem);
    }

    public static final j2 h(app.dogo.com.dogo_android.u.m.p p) {
        return p.d;
    }

    public static final z1 i(app.dogo.com.dogo_android.u.m.p p) {
        return p.a;
    }

    public static final j1 j(app.dogo.com.dogo_android.u.m.p p) {
        return p.e;
    }

    public static final v2 k(app.dogo.com.dogo_android.u.m.p p) {
        return p.f;
    }

    public static final o3 l(app.dogo.com.dogo_android.u.m.p p) {
        return p.c;
    }

    public static final p1 m(app.dogo.com.dogo_android.u.m.p p) {
        return p.b;
    }

    public static final void n(app.dogo.com.dogo_android.u.m.p p, SpecialProgramOverviewItem specialProgramOverviewItem2) {
        p.B(specialProgramOverviewItem2);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o() {
        boolean z;
        app.dogo.com.dogo_android.w.h3 h3Var;
        m0 m0Var;
        CoroutineExceptionHandler exc;
        int i;
        app.dogo.com.dogo_android.u.m.p.b bVar;
        int i3;
        int i2;
        if (!value instanceof y.b) {
            o2 o2Var = new o2();
            this.c.d(q.b.d(u.a(o2Var, "remove")));
            bVar = new p.b(this, 0);
            k.d(f0.a(this), this.j, 0, bVar, 2, 0);
        }
    }

    public final a<app.dogo.com.dogo_android.u.m.p.a> p() {
        return this.i;
    }

    public final x<y<SpecialProgramOverviewItem>> q() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final int r() {
        int value;
        int unreadZendeskMessages;
        if (value instanceof y.c) {
        } else {
            value = 0;
        }
        unreadZendeskMessages = 0;
        if (value == null) {
        } else {
            value = value.a();
            if ((SpecialProgramOverviewItem)value == null) {
            } else {
                unreadZendeskMessages = (SpecialProgramOverviewItem)value.getUnreadZendeskMessages();
            }
        }
        return unreadZendeskMessages;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s() {
        final int i = 0;
        p.c cVar = new p.c(this, i);
        k.d(f0.a(this), this.j, i, cVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean t(boolean z) {
        int obj2;
        if (this.g.T() && !z) {
            obj2 = !z ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(String string) {
        n.f(string, "articleId");
        w0 w0Var = new w0();
        this.c.d(q.f.d(u.a(w0Var, string)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v(boolean z) {
        o2 o2Var = new o2();
        this.c.d(q.a.d(u.a(o2Var, Boolean.valueOf(z))));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w(String string) {
        n.f(string, "trickId");
        e2 e2Var = new e2();
        n2 n2Var = new n2();
        this.c.d(q.d.d(u.a(e2Var, "id_nipping_program"), u.a(n2Var, string)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        this.c.d(x.o);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void y(String string, String string2) {
        n.f(string, "trickId");
        n.f(string2, "variationId");
        e2 e2Var = new e2();
        n2 n2Var = new n2();
        q1 q1Var = new q1();
        this.c.d(q.e.d(u.a(e2Var, "id_nipping_program"), u.a(n2Var, string), u.a(q1Var, string2)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z() {
        boolean z;
        app.dogo.com.dogo_android.w.h3 h3Var;
        m0 m0Var;
        CoroutineExceptionHandler exc;
        int i;
        app.dogo.com.dogo_android.u.m.p.e eVar;
        int i3;
        int i2;
        if (!value instanceof y.b) {
            o2 o2Var = new o2();
            this.c.d(q.b.d(u.a(o2Var, "remove")));
            eVar = new p.e(this, 0);
            k.d(f0.a(this), this.j, 0, eVar, 2, 0);
        }
    }
}
