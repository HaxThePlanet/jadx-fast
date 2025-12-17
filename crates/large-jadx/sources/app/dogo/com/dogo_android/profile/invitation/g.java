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
import f.d.a.a;
import i.b.a0;
import i.b.b;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.l;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u000c\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0014\u0010#\u001a\u00020$2\u000c\u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011J\u0006\u0010&\u001a\u00020\u0015J\u0008\u0010'\u001a\u0004\u0018\u00010\u0012J\u0006\u0010(\u001a\u00020\u0015J\u0006\u0010)\u001a\u00020\u0015J\u0006\u0010*\u001a\u00020\u0015J\u0006\u0010+\u001a\u00020$J\u0006\u0010,\u001a\u00020$J\u0006\u0010-\u001a\u00020$J\u000e\u0010.\u001a\u00020$2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010/\u001a\u00020$R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0017R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u001d¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001fR\u001d\u0010 \u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00150\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\"R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060", d2 = {"Lapp/dogo/com/dogo_android/profile/invitation/DogInviteAcceptanceSharedViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogInviteAcceptanceInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogInviteAcceptanceInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "sharedPreferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/interactor/DogInviteAcceptanceInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "cancelFlowTrigger", "Lcom/hadilq/liveevent/LiveEvent;", "", "getCancelFlowTrigger", "()Lcom/hadilq/liveevent/LiveEvent;", "inviteId", "", "onFlowComplete", "getOnFlowComplete", "result", "Landroidx/lifecycle/LiveData;", "getResult", "()Landroidx/lifecycle/LiveData;", "savingAcceptState", "getSavingAcceptState", "()Landroidx/lifecycle/MutableLiveData;", "acceptDogInvite", "", "dogOwnerInvitationResults", "doesUserHaveDogs", "getInviteData", "isDogInviteAccepted", "isUserInfoFilledIn", "isUserLoggedIn", "loadData", "onFlowCancel", "setForceDogCreation", "setInviteId", "setOnboardingAsComplete", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g extends s {

    private final d2 a;
    private final p1 b;
    private final h2 c;
    private final p2 d;
    private final o3 e;
    private final j2 f;
    private String g;
    private final x<y<DogOwnerInvitation>> h;
    private final LiveData<y<DogOwnerInvitation>> i;
    private final x<y<Boolean>> j;
    private final a<Boolean> k;
    private final a<Boolean> l;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.profile.invitation.g this$0;
        a(app.dogo.com.dogo_android.profile.invitation.g g) {
            this.this$0 = g;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar = new y.a(throwable);
            this.this$0.n().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.profile.invitation.g this$0;
        b(app.dogo.com.dogo_android.profile.invitation.g g) {
            this.this$0 = g;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            this.this$0.m().postValue(Boolean.TRUE);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.profile.invitation.g this$0;
        c(app.dogo.com.dogo_android.profile.invitation.g g) {
            this.this$0 = g;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar = new y.a(throwable);
            g.i(this.this$0).postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements l<DogOwnerInvitation, w> {

        final app.dogo.com.dogo_android.profile.invitation.g this$0;
        d(app.dogo.com.dogo_android.profile.invitation.g g) {
            this.this$0 = g;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(DogOwnerInvitation dogOwnerInvitation) {
            y.c cVar = new y.c(dogOwnerInvitation);
            g.i(this.this$0).postValue(cVar);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((DogOwnerInvitation)object);
            return w.a;
        }
    }
    public g(d2 d2, p1 p12, h2 h23, p2 p24, o3 o35, j2 j26) {
        n.f(d2, "dogInviteAcceptanceInteractor");
        n.f(p12, "userRepository");
        n.f(h23, "authService");
        n.f(p24, "sharedPreferenceService");
        n.f(o35, "tracker");
        n.f(j26, "connectivityService");
        super();
        this.a = d2;
        this.b = p12;
        this.c = h23;
        this.d = p24;
        this.e = o35;
        this.f = j26;
        x obj2 = new x();
        this.h = obj2;
        this.i = obj2;
        obj2 = new x();
        this.j = obj2;
        obj2 = new a();
        this.k = obj2;
        obj2 = new a();
        this.l = obj2;
    }

    public static final x i(app.dogo.com.dogo_android.profile.invitation.g g) {
        return g.h;
    }

    public final LiveData<y<DogOwnerInvitation>> getResult() {
        return this.i;
    }

    public final void h(y<DogOwnerInvitation> y) {
        Object aVar;
        boolean unknownHostException;
        Object bVar;
        int obj4;
        n.f(y, "dogOwnerInvitationResults");
        aVar = this.g;
        if (aVar == null) {
        } else {
            bVar = y.b.a;
            if (!n.b(n().getValue(), bVar)) {
                if (y instanceof y.c) {
                } else {
                    obj4 = 0;
                }
                if (obj4 == null) {
                } else {
                    obj4 = obj4.a();
                    if ((DogOwnerInvitation)obj4 == null) {
                    } else {
                        n().postValue(bVar);
                        this.h.postValue(bVar);
                        if (!this.f.a()) {
                            this.e.s("dog_invite_acceptance");
                            unknownHostException = new UnknownHostException();
                            aVar = new y.a(unknownHostException);
                            this.h.postValue(aVar);
                        } else {
                            obj4 = this.a.a(aVar, (DogOwnerInvitation)obj4.getDogId()).y(a.b()).q(a.b());
                            n.e(obj4, "dogInviteAcceptanceInteractor.acceptDogInvite(it, dogOwnerInvitation.dogId)\n                                .subscribeOn(Schedulers.io())\n                                .observeOn(Schedulers.io())");
                            aVar = new g.a(this);
                            bVar = new g.b(this);
                            getDisposable().b(a.d(obj4, aVar, bVar));
                        }
                    }
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean j() {
        int i;
        i = this.b.H().j() > 0 ? 1 : 0;
        return i;
    }

    public final a<Boolean> k() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final DogOwnerInvitation l() {
        Object value;
        Object i;
        if (value instanceof y.c) {
        } else {
            value = i;
        }
        if (value == null) {
        } else {
            i = value;
        }
        return i;
    }

    public final a<Boolean> m() {
        return this.l;
    }

    public final x<y<Boolean>> n() {
        return this.j;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean o() {
        int i;
        i = this.l.getValue() != null ? 1 : 0;
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean p() {
        String displayName;
        int i;
        UserAuthRecord userAuthRecord = this.c.A();
        if (userAuthRecord == null) {
            displayName = 0;
        } else {
            displayName = userAuthRecord.getDisplayName();
        }
        final int i3 = 1;
        if (displayName != null) {
            if (l.z(displayName)) {
                i = i3;
            } else {
                i = 0;
            }
        } else {
        }
        return i ^= i3;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean q() {
        return this.c.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r() {
        Object str;
        boolean disposable;
        Object unknownHostException;
        app.dogo.com.dogo_android.profile.invitation.g.d dVar;
        str = this.g;
        if (str == null) {
        } else {
            if (!value instanceof y.b) {
                this.h.postValue(y.b.a);
                if (!this.f.a()) {
                    this.e.s("dog_invite_acceptance");
                    unknownHostException = new UnknownHostException();
                    disposable = new y.a(unknownHostException);
                    this.h.postValue(disposable);
                } else {
                    a0 observeOn = this.a.d(str).subscribeOn(a.b()).observeOn(a.b());
                    n.e(observeOn, "dogInviteAcceptanceInteractor.getDogInvite(id)\n                            .subscribeOn(Schedulers.io())\n                            .observeOn(Schedulers.io())");
                    unknownHostException = new g.c(this);
                    dVar = new g.d(this);
                    getDisposable().b(a.g(observeOn, unknownHostException, dVar));
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s() {
        boolean z;
        Object tRUE;
        if (!n.b(this.j.getValue(), y.b.a)) {
            this.k.postValue(Boolean.TRUE);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t() {
        this.d.U0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(String string) {
        n.f(string, "inviteId");
        this.g = string;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v() {
        this.d.T0(false);
    }
}
