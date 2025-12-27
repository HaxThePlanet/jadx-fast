package app.dogo.com.dogo_android.o;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.v.b.c;
import app.dogo.com.dogo_android.w.a0;
import app.dogo.com.dogo_android.w.o3;
import i.b.b;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: NewsletterBenefitsViewModel.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/newsletterbenefits/NewsletterBenefitsViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_policySave", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "policySave", "Landroidx/lifecycle/LiveData;", "getPolicySave", "()Landroidx/lifecycle/LiveData;", "setUserNewsletterAccepted", "", "setUserNewsletterSeen", "updateChallengePolicyStatus", "status", "Lapp/dogo/com/dogo_android/temp/User$PolicyStatus;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class NewsletterBenefitsViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final p1 authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final o3 connectivityService;
    private final j2 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final x<y<Boolean>> tracker = new x<>();
    /* renamed from: e, reason: from kotlin metadata */
    private final LiveData<y<Boolean>> userRepository = new x<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            e.this.tracker.postValue(new LoadResult_Error(th));
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            e.this.tracker.postValue(new LoadResult_Success(Boolean.TRUE));
        }

        b() {
            super(0);
        }
    }
    public e(p1 p1Var, h2 h2Var, o3 o3Var, j2 j2Var) {
        n.f(p1Var, "userRepository");
        n.f(h2Var, "authService");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        super();
        this.authService = p1Var;
        this.connectivityService = o3Var;
        this.c = j2Var;
        final x xVar = new x();
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ x updateChallengePolicyStatus(e status) {
        return status.tracker;
    }

    private final void l(b.c cVar) {
        this.tracker.postValue(LoadResult_Loading.a);
        if (!this.c.a()) {
            this.connectivityService.setTrainingReminderUserProperties("newsletter_benefits");
            this.tracker.postValue(new LoadResult_Error(new UnknownHostException()));
        } else {
            b bVar5 = this.authService.y0("marketing_emails_v1", cVar).q(a.b()).y(a.b());
            n.e(bVar5, "userRepository.updatePolicy(User.NEWSLETTER_POLICY_ID, status)\n                    .observeOn(Schedulers.io())\n                    .subscribeOn(Schedulers.io())");
            getDisposable().b(a.d(bVar5, new app.dogo.com.dogo_android.newsletterbenefits.e.a(this), new app.dogo.com.dogo_android.newsletterbenefits.e.b(this)));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: i, reason: from kotlin metadata */
    public final LiveData<y<Boolean>> setUserNewsletterAccepted() {
        return this.userRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j() {
        this.connectivityService.logEvent(E_General.o);
        l(User_PolicyStatus.ACCEPTED);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k() {
        this.connectivityService.logEvent(E_General.p);
        l(User_PolicyStatus.SEEN);
    }
}
