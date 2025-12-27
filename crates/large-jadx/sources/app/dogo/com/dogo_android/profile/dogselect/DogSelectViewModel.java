package app.dogo.com.dogo_android.q.q;

import androidx.lifecycle.LiveData;
import app.dogo.com.dogo_android.repository.domain.DogSelectData;
import app.dogo.com.dogo_android.s.a.n3;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r2;
import i.b.a0;
import i.b.b;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* compiled from: DogSelectViewModel.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020#J\u000e\u0010$\u001a\u00020#2\u0006\u0010\u001e\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020#J\u0006\u0010&\u001a\u00020#R\u0014\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\u0016R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u0014¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "sourceScreenName", "", "userLocalCacheService", "Lapp/dogo/com/dogo_android/service/UserLocalCacheService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/service/UserLocalCacheService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;)V", "_clickDelay", "Lcom/hadilq/liveevent/LiveEvent;", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "clickDelay", "Landroidx/lifecycle/LiveData;", "getClickDelay", "()Landroidx/lifecycle/LiveData;", "emptyDogId", "getEmptyDogId", "()Ljava/lang/String;", "result", "getResult", "buildEmitProfileChangeMessage", "Landroid/os/Bundle;", "dogId", "requestKey", "getData", "Lapp/dogo/com/dogo_android/repository/domain/DogSelectData;", "refreshData", "", "startOnClickDelay", "trackAddNewDog", "trackSwitchDog", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class DogSelectViewModel extends s {

    private final String a;
    private final p1 b;
    private final o3 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final n3 sourceScreenName;
    /* renamed from: e, reason: from kotlin metadata */
    private final f.d.a.a<String> subscribeInteractor = new a<>();
    /* renamed from: f, reason: from kotlin metadata */
    private final LiveData<String> tracker = new a<>();
    /* renamed from: g, reason: from kotlin metadata */
    private final androidx.lifecycle.x<y<Boolean>> userLocalCacheService = new x<>();
    /* renamed from: h, reason: from kotlin metadata */
    private final LiveData<y<Boolean>> userRepository = new x<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            j.this.userLocalCacheService.postValue(new LoadResult_Error(th));
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<Boolean, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Boolean boolean) {
            j.this.userLocalCacheService.postValue(new LoadResult_Success(boolean));
        }

        b() {
            super(1);
        }
    }
    public j(String str, app.dogo.com.dogo_android.service.u2 u2Var, p1 p1Var, o3 o3Var, n3 n3Var) {
        n.f(str, "sourceScreenName");
        n.f(u2Var, "userLocalCacheService");
        n.f(p1Var, "userRepository");
        n.f(o3Var, "tracker");
        n.f(n3Var, "subscribeInteractor");
        super();
        this.a = str;
        this.b = p1Var;
        this.c = o3Var;
        this.sourceScreenName = n3Var;
        f.d.a.a aVar = new a();
        androidx.lifecycle.x xVar = new x();
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ androidx.lifecycle.x startOnClickDelay(j dogId) {
        return dogId.userLocalCacheService;
    }

    private static final void o(j jVar, String str) {
        n.f(jVar, "this$0");
        n.f(str, "$dogId");
        jVar.subscribeInteractor.postValue(str);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<Boolean>> getResult() {
        return this.userRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: i, reason: from kotlin metadata */
    public final LiveData<String> getData() {
        return this.tracker;
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
        a0 observable2 = this.sourceScreenName.q().observeOn(a.b()).subscribeOn(a.b());
        n.e(observable2, "subscribeInteractor.revenueCatSubscribed()\n                .observeOn(Schedulers.io())\n                .subscribeOn(Schedulers.io())");
        getDisposable().b(a.g(observable2, new app.dogo.com.dogo_android.profile.dogselect.j.a(this), new app.dogo.com.dogo_android.profile.dogselect.j.b(this)));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n(String str) {
        n.f(str, "dogId");
        getDisposable().b(b.f().y(a.c()).h(300L, TimeUnit.MILLISECONDS).q(a.a()).j(new app.dogo.com.dogo_android.profile.dogselect.e(this, str)).u());
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p() {
        this.c.logEvent(E_Dashboard.f);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void q() {
        this.c.logEvent(E_Dashboard.g.c(new EP_ViewSource(), this.a));
    }

    /* renamed from: l, reason: from kotlin metadata */
    public static /* synthetic */ void buildEmitProfileChangeMessage(j dogId, String requestKey) {
        DogSelectViewModel.o(dogId, requestKey);
    }
}
