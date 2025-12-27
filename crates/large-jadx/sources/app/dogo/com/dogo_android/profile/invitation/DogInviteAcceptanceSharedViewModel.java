package app.dogo.com.dogo_android.profile.invitation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation;
import app.dogo.com.dogo_android.repository.domain.UserAuthRecord;
import app.dogo.com.dogo_android.s.a.d2;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.o3;
import i.b.a0;
import i.b.b;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: DogInviteAcceptanceSharedViewModel.kt */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u000c\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0014\u0010#\u001a\u00020$2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011J\u0006\u0010&\u001a\u00020\u0015J\u0008\u0010'\u001a\u0004\u0018\u00010\u0012J\u0006\u0010(\u001a\u00020\u0015J\u0006\u0010)\u001a\u00020\u0015J\u0006\u0010*\u001a\u00020\u0015J\u0006\u0010+\u001a\u00020$J\u0006\u0010,\u001a\u00020$J\u0006\u0010-\u001a\u00020$J\u000e\u0010.\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010/\u001a\u00020$R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0017R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u001d\u0010 \u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060", d2 = {"Lapp/dogo/com/dogo_android/profile/invitation/DogInviteAcceptanceSharedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogInviteAcceptanceInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogInviteAcceptanceInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "sharedPreferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/interactor/DogInviteAcceptanceInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "cancelFlowTrigger", "Lcom/hadilq/liveevent/LiveEvent;", "", "getCancelFlowTrigger", "()Lcom/hadilq/liveevent/LiveEvent;", "inviteId", "", "onFlowComplete", "getOnFlowComplete", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "savingAcceptState", "getSavingAcceptState", "()Landroidx/lifecycle/MutableLiveData;", "acceptDogInvite", "", "dogOwnerInvitationResults", "doesUserHaveDogs", "getInviteData", "isDogInviteAccepted", "isUserInfoFilledIn", "isUserLoggedIn", "loadData", "onFlowCancel", "setForceDogCreation", "setInviteId", "setOnboardingAsComplete", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class DogInviteAcceptanceSharedViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final d2 authService;
    private final p1 b;
    /* renamed from: c, reason: from kotlin metadata */
    private final h2 connectivityService;
    /* renamed from: d, reason: from kotlin metadata */
    private final p2 dogInviteAcceptanceInteractor;
    /* renamed from: e, reason: from kotlin metadata */
    private final o3 inviteId;
    private final j2 f;
    private String g;
    private final x<y<DogOwnerInvitation>> h = new x<>();
    /* renamed from: i, reason: from kotlin metadata */
    private final LiveData<y<DogOwnerInvitation>> sharedPreferenceService = new x<>();
    /* renamed from: j, reason: from kotlin metadata */
    private final x<y<Boolean>> tracker = new x<>();
    /* renamed from: k, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> userRepository = new a<>();
    private final f.d.a.a<Boolean> l = new a<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            g.this.n().postValue(new LoadResult_Error(th));
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            g.this.m().postValue(Boolean.TRUE);
        }

        b() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements kotlin.d0.c.l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            g.this.h.postValue(new LoadResult_Error(th));
        }

        c() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.l<DogOwnerInvitation, w> {
        @Override // kotlin.d0.d.p
        public final void a(DogOwnerInvitation dogOwnerInvitation) {
            g.this.h.postValue(new LoadResult_Success(dogOwnerInvitation));
        }

        d() {
            super(1);
        }
    }
    public g(d2 d2Var, p1 p1Var, h2 h2Var, p2 p2Var, o3 o3Var, j2 j2Var) {
        n.f(d2Var, "dogInviteAcceptanceInteractor");
        n.f(p1Var, "userRepository");
        n.f(h2Var, "authService");
        n.f(p2Var, "sharedPreferenceService");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        super();
        this.authService = d2Var;
        this.b = p1Var;
        this.connectivityService = h2Var;
        this.dogInviteAcceptanceInteractor = p2Var;
        this.inviteId = o3Var;
        this.f = j2Var;
        x xVar = new x();
        x xVar2 = new x();
        f.d.a.a aVar = new a();
        f.d.a.a aVar2 = new a();
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ x acceptDogInvite(g dogOwnerInvitationResults) {
        return dogOwnerInvitationResults.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<DogOwnerInvitation>> getResult() {
        return this.sharedPreferenceService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: h, reason: from kotlin metadata */
    public final void setInviteId(y<DogOwnerInvitation> inviteId) {
        int i = 0;
        n.f(inviteId, "dogOwnerInvitationResults");
        if (this.g != null) {
            bVar = LoadResult_Loading.a;
            if (!n.b(n().getValue(), bVar)) {
                z = inviteId instanceof LoadResult_Success;
                inviteId = inviteId instanceof oadResult_Success ? (oadResult_Success)inviteId : 0;
                if (i != 0) {
                    Object component1 = i.component1();
                    if (component1 != null) {
                        n().postValue(LoadResult_Loading.a);
                        this.h.postValue(LoadResult_Loading.a);
                        if (!this.f.getActiveNetworkType()) {
                            this.inviteId.setTrainingReminderUserProperties("dog_invite_acceptance");
                            this.h.postValue(new LoadResult_Error(new UnknownHostException()));
                        } else {
                            b bVar5 = this.authService.a(this.g, component1.getDogId()).y(a.b()).q(a.b());
                            n.e(bVar5, "dogInviteAcceptanceInteractor.acceptDogInvite(it, dogOwnerInvitation.dogId)\n                                .subscribeOn(Schedulers.io())\n                                .observeOn(Schedulers.io())");
                            getDisposable().b(a.d(bVar5, new g.a(this), new g.b(this)));
                        }
                    }
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: j, reason: from kotlin metadata */
    public final boolean doesUserHaveDogs() {
        boolean z = true;
        int r0 = this.b.H().j() > 0 ? 1 : 0;
        return (this.b.H().j() > 0 ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> k() {
        return this.userRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final DogOwnerInvitation l() {
        Object value;
        LoadResult_Success r0 = this.sharedPreferenceService.getValue() instanceof LoadResult_Success ? (oadResult_Success)this.sharedPreferenceService.getValue() : 0;
        if (this.sharedPreferenceService != null) {
        }
        return value;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> m() {
        return this.l;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> n() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean o() {
        boolean z = true;
        int r0 = this.l.getValue() != null ? 1 : 0;
        return (this.l.getValue() != null ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean p() {
        Object obj = null;
        int i = 0;
        UserAuthRecord userAuthRecord = this.connectivityService.A();
        if (userAuthRecord == null) {
            int i3 = 0;
        } else {
            String displayName = userAuthRecord.getDisplayName();
        }
        i = 1;
        if (this.connectivityService == null || l.z(this.connectivityService)) {
        }
        return i ^ i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        return this.connectivityService.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r() {
        if (this.g != null) {
            z = getResult().getValue() instanceof LoadResult_Loading;
            if (!(this.getResult().getValue() instanceof oadResult_Loading)) {
                this.h.postValue(LoadResult_Loading.a);
                if (!this.f.getActiveNetworkType()) {
                    this.inviteId.setTrainingReminderUserProperties("dog_invite_acceptance");
                    this.h.postValue(new LoadResult_Error(new UnknownHostException()));
                } else {
                    a0 observable2 = this.authService.d(this.g).subscribeOn(a.b()).observeOn(a.b());
                    n.e(observable2, "dogInviteAcceptanceInteractor.getDogInvite(id)\n                            .subscribeOn(Schedulers.io())\n                            .observeOn(Schedulers.io())");
                    getDisposable().b(a.g(observable2, new g.c(this), new g.d(this)));
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s() {
        if (!n.b(this.tracker.getValue(), LoadResult_Loading.a)) {
            this.userRepository.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t() {
        this.dogInviteAcceptanceInteractor.U0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(String str) {
        n.f(str, "inviteId");
        this.g = str;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v() {
        this.dogInviteAcceptanceInteractor.T0(false);
    }
}
