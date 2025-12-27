package app.dogo.com.dogo_android.q.s;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogParentUIState;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.a.f2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.i0;
import app.dogo.com.dogo_android.w.o3;
import i.b.a0;
import i.b.b;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: DogParentsViewModel.kt */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u001dR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0010R\u0017\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "dogParentInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogParentInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Lapp/dogo/com/dogo_android/repository/interactor/DogParentInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "inviteLoadState", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "getInviteLoadState", "()Landroidx/lifecycle/MutableLiveData;", "onDeleteError", "Lcom/hadilq/liveevent/LiveEvent;", "", "getOnDeleteError", "()Lcom/hadilq/liveevent/LiveEvent;", "ownersResult", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState;", "getOwnersResult", "showInvite", "", "getShowInvite", "createInvite", "", "deleteOwner", "ownerId", "loadData", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class DogParentsViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final DogProfile connectivityService;
    /* renamed from: b, reason: from kotlin metadata */
    private final f2 dogParentInteractor;
    /* renamed from: c, reason: from kotlin metadata */
    private final o3 dogProfile;
    private final j2 d;
    private final x<y<DogParentUIState>> e = new x<>();
    private final x<y<Boolean>> f = new x<>();
    private final f.d.a.a<Throwable> g = new a<>();
    /* renamed from: h, reason: from kotlin metadata */
    private final f.d.a.a<String> tracker = new a<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            f.this.j().postValue(new LoadResult_Error(th));
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<String, w> {
        @Override // kotlin.d0.d.p
        public final void a(String str) {
            f.this.j().postValue(new LoadResult_Success(Boolean.TRUE));
            f.this.m().postValue(str);
        }

        b() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            f.this.k().postValue(th);
        }

        c() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            f.this.l().postValue(new LoadResult_Error(th));
        }

        d() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements l<DogParentUIState, w> {
        @Override // kotlin.d0.d.p
        public final void a(DogParentUIState dogParentUIState) {
            f.this.l().postValue(new LoadResult_Success(dogParentUIState));
        }

        e() {
            super(1);
        }
    }
    public f(DogProfile dogProfile, f2 f2Var, o3 o3Var, j2 j2Var) {
        n.f(dogProfile, "dogProfile");
        n.f(f2Var, "dogParentInteractor");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        super();
        this.connectivityService = dogProfile;
        this.dogParentInteractor = f2Var;
        this.dogProfile = o3Var;
        this.d = j2Var;
        x xVar = new x();
        x xVar2 = new x();
        f.d.a.a aVar = new a();
        f.d.a.a aVar2 = new a();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: h, reason: from kotlin metadata */
    public final void createInvite() {
        z = this.f.getValue() instanceof LoadResult_Loading;
        if (!(this.f.getValue() instanceof oadResult_Loading)) {
            this.f.setValue(LoadResult_Loading.a);
            if (!this.d.a()) {
                this.dogProfile.setTrainingReminderUserProperties("dog_parents");
                this.f.postValue(new LoadResult_Error(new UnknownHostException()));
            } else {
                this.dogProfile.logEvent(E_Profile.b);
                a0 observable2 = this.dogParentInteractor.a(this.connectivityService).subscribeOn(a.b()).observeOn(a.b());
                n.e(observable2, "dogParentInteractor.createInviteLink(dogProfile)\n                        .subscribeOn(Schedulers.io())\n                        .observeOn(Schedulers.io())");
                getDisposable().b(a.g(observable2, new app.dogo.com.dogo_android.profile.ownerList.f.a(this), new app.dogo.com.dogo_android.profile.ownerList.f.b(this)));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: i, reason: from kotlin metadata */
    public final void deleteOwner(String ownerId) {
        n.f(ownerId, "ownerId");
        b bVar4 = this.dogParentInteractor.k(this.connectivityService.getId(), ownerId).y(a.b()).h(5L, TimeUnit.SECONDS).q(a.b());
        n.e(bVar4, "dogParentInteractor.removeDogParent(dogProfile.id, ownerId)\n                .subscribeOn(Schedulers.io())\n                .delay(5, TimeUnit.SECONDS)\n                .observeOn(Schedulers.io())");
        kotlin.d0.c.a aVar = null;
        getDisposable().b(a.h(bVar4, new app.dogo.com.dogo_android.profile.ownerList.f.c(this), aVar, 2, aVar));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> j() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Throwable> k() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<DogParentUIState>> l() {
        return this.e;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<String> m() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n() {
        z = this.e.getValue() instanceof LoadResult_Loading;
        if (!(this.e.getValue() instanceof oadResult_Loading)) {
            this.e.postValue(LoadResult_Loading.a);
            a0 observable2 = this.dogParentInteractor.d(this.connectivityService.getId()).subscribeOn(a.b()).observeOn(a.b());
            n.e(observable2, "dogParentInteractor.getDogParentUiState(dogProfile.id)\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(Schedulers.io())");
            getDisposable().b(a.g(observable2, new app.dogo.com.dogo_android.profile.ownerList.f.d(this), new app.dogo.com.dogo_android.profile.ownerList.f.e(this)));
        }
    }
}
