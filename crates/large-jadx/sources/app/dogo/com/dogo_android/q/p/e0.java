package app.dogo.com.dogo_android.q.p;

import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.a.g2;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.w.o3;
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
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0016J\u0006\u0010\u001e\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u001a0\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0018R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewNameViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "nameField", "Landroidx/lifecycle/MutableLiveData;", "", "getNameField", "()Landroidx/lifecycle/MutableLiveData;", "saveState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSaveState", "isNameValid", "name", "isUserSignedIn", "saveDogName", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e0 extends s {

    private final DogProfile a;
    private final g2 b;
    private final h2 c;
    private final o3 d;
    private final j2 e;
    private final x<String> f;
    private final x<y<Boolean>> g;
    private final a<Boolean> h;
    private final CoroutineExceptionHandler i;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.q.p.e0 a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.q.p.e0 e02) {
            this.a = e02;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.n().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.profile.dogprofile.DogPreviewNameViewModel$saveDogName$1", f = "DogPreviewNameViewModel.kt", l = 42, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        final String $name;
        int label;
        final app.dogo.com.dogo_android.q.p.e0 this$0;
        a(app.dogo.com.dogo_android.q.p.e0 e0, String string2, d<? super app.dogo.com.dogo_android.q.p.e0.a> d3) {
            this.this$0 = e0;
            this.$name = string2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (e0.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            e0.a obj3 = new e0.a(this.this$0, this.$name, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object aVar;
            Object unknownHostException;
            int label;
            String $name;
            Object obj5;
            Object obj = b.d();
            label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    q.b(object);
                    y.c cVar = new y.c(b.a(i));
                    this.this$0.n().postValue(cVar);
                    this.this$0.l().postValue(b.a(i));
                    return w.a;
                }
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
            }
            q.b(object);
            this.this$0.n().postValue(y.b.a);
            if (!e0.h(this.this$0).a()) {
                e0.k(this.this$0).s("dog_preview_name");
                unknownHostException = new UnknownHostException();
                aVar = new y.a(unknownHostException);
                this.this$0.n().postValue(aVar);
            } else {
                this.label = i;
                if (e0.j(this.this$0).k(e0.i(this.this$0).getId(), this.$name, this) == obj) {
                    return obj;
                }
            }
        }
    }
    public e0(DogProfile dogProfile, g2 g22, h2 h23, o3 o34, j2 j25) {
        n.f(dogProfile, "dogProfile");
        n.f(g22, "dogUpdateInteractor");
        n.f(h23, "authService");
        n.f(o34, "tracker");
        n.f(j25, "connectivityService");
        super();
        this.a = dogProfile;
        this.b = g22;
        this.c = h23;
        this.d = o34;
        this.e = j25;
        x obj3 = new x(j1.w0(dogProfile.getName()));
        this.f = obj3;
        x obj2 = new x();
        this.g = obj2;
        obj2 = new a();
        this.h = obj2;
        obj3 = new e0.b(CoroutineExceptionHandler.r, this);
        this.i = obj3;
    }

    public static final j2 h(app.dogo.com.dogo_android.q.p.e0 e0) {
        return e0.e;
    }

    public static final DogProfile i(app.dogo.com.dogo_android.q.p.e0 e0) {
        return e0.a;
    }

    public static final g2 j(app.dogo.com.dogo_android.q.p.e0 e0) {
        return e0.b;
    }

    public static final o3 k(app.dogo.com.dogo_android.q.p.e0 e0) {
        return e0.d;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserSignedIn() {
        return this.c.D();
    }

    public final a<Boolean> l() {
        return this.h;
    }

    public final x<String> m() {
        return this.f;
    }

    public final x<y<Boolean>> n() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean o(String string) {
        int i2;
        int i;
        Object obj4;
        n.f(string, "name");
        final int i3 = 0;
        i2 = string.length() > 0 ? i : i3;
        if (i2 != 0 && string.length() <= 21) {
            if (string.length() <= 21) {
            } else {
                i = i3;
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p(String string) {
        n.f(string, "name");
        e0.a aVar = new e0.a(this, string, 0);
        k.d(f0.a(this), this.i, 0, aVar, 2, 0);
    }
}
