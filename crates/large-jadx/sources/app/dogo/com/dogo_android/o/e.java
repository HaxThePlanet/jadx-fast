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
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r0\u000cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u000e0\r0\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/newsletterbenefits/NewsletterBenefitsViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_policySave", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "policySave", "Landroidx/lifecycle/LiveData;", "getPolicySave", "()Landroidx/lifecycle/LiveData;", "setUserNewsletterAccepted", "", "setUserNewsletterSeen", "updateChallengePolicyStatus", "status", "Lapp/dogo/com/dogo_android/temp/User$PolicyStatus;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends s {

    private final p1 a;
    private final o3 b;
    private final j2 c;
    private final x<y<Boolean>> d;
    private final LiveData<y<Boolean>> e;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.o.e this$0;
        a(app.dogo.com.dogo_android.o.e e) {
            this.this$0 = e;
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
            e.h(this.this$0).postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.o.e this$0;
        b(app.dogo.com.dogo_android.o.e e) {
            this.this$0 = e;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            y.c cVar = new y.c(Boolean.TRUE);
            e.h(this.this$0).postValue(cVar);
        }
    }
    public e(p1 p1, h2 h22, o3 o33, j2 j24) {
        n.f(p1, "userRepository");
        n.f(h22, "authService");
        n.f(o33, "tracker");
        n.f(j24, "connectivityService");
        super();
        this.a = p1;
        this.b = o33;
        this.c = j24;
        x obj2 = new x();
        this.d = obj2;
        this.e = obj2;
    }

    public static final x h(app.dogo.com.dogo_android.o.e e) {
        return e.d;
    }

    private final void l(b.c b$c) {
        Object disposable;
        Object unknownHostException;
        app.dogo.com.dogo_android.o.e.b bVar;
        Object obj4;
        this.d.postValue(y.b.a);
        if (!this.c.a()) {
            this.b.s("newsletter_benefits");
            unknownHostException = new UnknownHostException();
            disposable = new y.a(unknownHostException);
            this.d.postValue(disposable);
        } else {
            obj4 = this.a.y0("marketing_emails_v1", c).q(a.b()).y(a.b());
            n.e(obj4, "userRepository.updatePolicy(User.NEWSLETTER_POLICY_ID, status)\n                    .observeOn(Schedulers.io())\n                    .subscribeOn(Schedulers.io())");
            unknownHostException = new e.a(this);
            bVar = new e.b(this);
            getDisposable().b(a.d(obj4, unknownHostException, bVar));
        }
    }

    public final LiveData<y<Boolean>> i() {
        return this.e;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j() {
        this.b.c(a0.o);
        l(b.c.ACCEPTED);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void k() {
        this.b.c(a0.p);
        l(b.c.SEEN);
    }
}
