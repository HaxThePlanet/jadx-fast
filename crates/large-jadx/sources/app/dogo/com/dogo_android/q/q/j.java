package app.dogo.com.dogo_android.q.q;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogSelectData;
import app.dogo.com.dogo_android.s.a.n3;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.u2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.x;
import f.d.a.a;
import i.b.a0;
import i.b.b;
import i.b.i0.b.a;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020#R\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "sourceScreenName", "", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;)V", "_clickDelay", "Lcom/hadilq/liveevent/LiveEvent;", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "clickDelay", "Landroidx/lifecycle/LiveData;", "getClickDelay", "()Landroidx/lifecycle/LiveData;", "emptyDogId", "getEmptyDogId", "()Ljava/lang/String;", "result", "getResult", "buildEmitProfileChangeMessage", "Landroid/os/Bundle;", "dogId", "requestKey", "getData", "Lapp/dogo/com/dogo_android/repository/domain/DogSelectData;", "refreshData", "", "startOnClickDelay", "trackAddNewDog", "trackSwitchDog", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends s {

    private final String a;
    private final p1 b;
    private final o3 c;
    private final n3 d;
    private final a<String> e;
    private final LiveData<String> f;
    private final x<y<Boolean>> g;
    private final LiveData<y<Boolean>> h;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.q.q.j this$0;
        a(app.dogo.com.dogo_android.q.q.j j) {
            this.this$0 = j;
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
            j.h(this.this$0).postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<Boolean, w> {

        final app.dogo.com.dogo_android.q.q.j this$0;
        b(app.dogo.com.dogo_android.q.q.j j) {
            this.this$0 = j;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Boolean)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Boolean boolean) {
            y.c cVar = new y.c(boolean);
            j.h(this.this$0).postValue(cVar);
        }
    }
    public j(String string, u2 u22, p1 p13, o3 o34, n3 n35) {
        n.f(string, "sourceScreenName");
        n.f(u22, "userLocalCacheService");
        n.f(p13, "userRepository");
        n.f(o34, "tracker");
        n.f(n35, "subscribeInteractor");
        super();
        this.a = string;
        this.b = p13;
        this.c = o34;
        this.d = n35;
        a obj2 = new a();
        this.e = obj2;
        this.f = obj2;
        obj2 = new x();
        this.g = obj2;
        this.h = obj2;
    }

    public static final x h(app.dogo.com.dogo_android.q.q.j j) {
        return j.g;
    }

    public static void l(app.dogo.com.dogo_android.q.q.j j, String string2) {
        j.o(j, string2);
    }

    private static final void o(app.dogo.com.dogo_android.q.q.j j, String string2) {
        n.f(j, "this$0");
        n.f(string2, "$dogId");
        j.e.postValue(string2);
    }

    public final LiveData<y<Boolean>> getResult() {
        return this.h;
    }

    public final LiveData<String> i() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final DogSelectData j() {
        return this.b.A();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String k() {
        return this.b.H().n();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void m() {
        a0 subscribeOn = this.d.q().observeOn(a.b()).subscribeOn(a.b());
        n.e(subscribeOn, "subscribeInteractor.revenueCatSubscribed()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        j.a aVar = new j.a(this);
        j.b bVar2 = new j.b(this);
        getDisposable().b(a.g(subscribeOn, aVar, bVar2));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n(String string) {
        n.f(string, "dogId");
        e eVar = new e(this, string);
        getDisposable().b(b.f().y(a.c()).h(300, obj4).q(a.a()).j(eVar).u());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        this.c.d(x.f);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q() {
        r2 r2Var = new r2();
        this.c.d(x.g.c(r2Var, this.a));
    }
}
