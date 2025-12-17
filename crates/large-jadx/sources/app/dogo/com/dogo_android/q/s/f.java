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
import f.d.a.a;
import i.b.a0;
import i.b.b;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u001aJ\u0006\u0010 \u001a\u00020\u001dR\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\r0\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0010R\u0017\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u001a0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "dogParentInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogParentInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Lapp/dogo/com/dogo_android/repository/interactor/DogParentInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "inviteLoadState", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "getInviteLoadState", "()Landroidx/lifecycle/MutableLiveData;", "onDeleteError", "Lcom/hadilq/liveevent/LiveEvent;", "", "getOnDeleteError", "()Lcom/hadilq/liveevent/LiveEvent;", "ownersResult", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState;", "getOwnersResult", "showInvite", "", "getShowInvite", "createInvite", "", "deleteOwner", "ownerId", "loadData", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends s {

    private final DogProfile a;
    private final f2 b;
    private final o3 c;
    private final j2 d;
    private final x<y<DogParentUIState>> e;
    private final x<y<Boolean>> f;
    private final a<Throwable> g;
    private final a<String> h;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.q.s.f this$0;
        a(app.dogo.com.dogo_android.q.s.f f) {
            this.this$0 = f;
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
            this.this$0.j().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<String, w> {

        final app.dogo.com.dogo_android.q.s.f this$0;
        b(app.dogo.com.dogo_android.q.s.f f) {
            this.this$0 = f;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(String string) {
            y.c cVar = new y.c(Boolean.TRUE);
            this.this$0.j().postValue(cVar);
            this.this$0.m().postValue(string);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((String)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.q.s.f this$0;
        c(app.dogo.com.dogo_android.q.s.f f) {
            this.this$0 = f;
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
            this.this$0.k().postValue(throwable);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.q.s.f this$0;
        d(app.dogo.com.dogo_android.q.s.f f) {
            this.this$0 = f;
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
            this.this$0.l().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements l<DogParentUIState, w> {

        final app.dogo.com.dogo_android.q.s.f this$0;
        e(app.dogo.com.dogo_android.q.s.f f) {
            this.this$0 = f;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(DogParentUIState dogParentUIState) {
            y.c cVar = new y.c(dogParentUIState);
            this.this$0.l().postValue(cVar);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((DogParentUIState)object);
            return w.a;
        }
    }
    public f(DogProfile dogProfile, f2 f22, o3 o33, j2 j24) {
        n.f(dogProfile, "dogProfile");
        n.f(f22, "dogParentInteractor");
        n.f(o33, "tracker");
        n.f(j24, "connectivityService");
        super();
        this.a = dogProfile;
        this.b = f22;
        this.c = o33;
        this.d = j24;
        x obj2 = new x();
        this.e = obj2;
        obj2 = new x();
        this.f = obj2;
        obj2 = new a();
        this.g = obj2;
        obj2 = new a();
        this.h = obj2;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void h() {
        boolean disposable;
        Object aVar;
        Object unknownHostException;
        app.dogo.com.dogo_android.q.s.f.b bVar;
        if (!value instanceof y.b) {
            this.f.setValue(y.b.a);
            if (!this.d.a()) {
                this.c.s("dog_parents");
                unknownHostException = new UnknownHostException();
                aVar = new y.a(unknownHostException);
                this.f.postValue(aVar);
            } else {
                this.c.d(i0.b);
                a0 observeOn = this.b.a(this.a).subscribeOn(a.b()).observeOn(a.b());
                n.e(observeOn, "dogParentInteractor.createInviteLink(dogProfile)\n                        .subscribeOn(Schedulers.io())\n                        .observeOn(Schedulers.io())");
                unknownHostException = new f.a(this);
                bVar = new f.b(this);
                getDisposable().b(a.g(observeOn, unknownHostException, bVar));
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void i(String string) {
        n.f(string, "ownerId");
        b obj5 = this.b.k(this.a.getId(), string).y(a.b()).h(5, obj3).q(a.b());
        n.e(obj5, "dogParentInteractor.removeDogParent(dogProfile.id, ownerId)\n                .subscribeOn(Schedulers.io())\n                .delay(5, TimeUnit.SECONDS)\n                .observeOn(Schedulers.io())");
        f.c cVar = new f.c(this);
        int i2 = 0;
        getDisposable().b(a.h(obj5, cVar, i2, 2, i2));
    }

    public final x<y<Boolean>> j() {
        return this.f;
    }

    public final a<Throwable> k() {
        return this.g;
    }

    public final x<y<DogParentUIState>> l() {
        return this.e;
    }

    public final a<String> m() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n() {
        boolean disposable;
        i.b.j0.b bVar;
        app.dogo.com.dogo_android.q.s.f.d dVar;
        app.dogo.com.dogo_android.q.s.f.e eVar;
        if (!value instanceof y.b) {
            this.e.postValue(y.b.a);
            a0 observeOn = this.b.d(this.a.getId()).subscribeOn(a.b()).observeOn(a.b());
            n.e(observeOn, "dogParentInteractor.getDogParentUiState(dogProfile.id)\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(Schedulers.io())");
            dVar = new f.d(this);
            eVar = new f.e(this);
            getDisposable().b(a.g(observeOn, dVar, eVar));
        }
    }
}
