package app.dogo.com.dogo_android.dogcreation.h;

import android.net.Uri;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.p;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.a.g2;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.l2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.t2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.o3;
import i.b.a0;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0008\u0010 \u001a\u0004\u0018\u00010\u0017J\n\u0010!\u001a\u0004\u0018\u00010\u0017H\u0002J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017J\u000e\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001e0\u001d0\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/avatar/DogCreationAvatarViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogId", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "fireBaseStorageService", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/FireBaseStorageService;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "avatarUriLiveData", "Landroidx/lifecycle/MutableLiveData;", "Landroid/net/Uri;", "getAvatarUriLiveData", "()Landroidx/lifecycle/MutableLiveData;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "savingState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getSavingState", "getAvatarFromLocalStorage", "getDogAvatarUri", "saveUriToLocalStorage", "", "avatarUri", "uploadAvatarAndUpdateProfile", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g extends s {

    private final String a;
    private final p1 b;
    private final p2 c;
    private final l2 d;
    private final t2 e;
    private final o3 f;
    private final g2 g;
    private final j2 h;
    private final h0 i;
    private final x<y<DogProfile>> j;
    private final x<Uri> k;
    private final CoroutineExceptionHandler l;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.dogcreation.h.g a;
        public a(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.dogcreation.h.g g2) {
            this.a = g2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.s().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dogcreation.avatar.DogCreationAvatarViewModel$uploadAvatarAndUpdateProfile$1", f = "DogCreationAvatarViewModel.kt", l = 50, m = "invokeSuspend")
    static final class b extends k implements p<m0, d<? super w>, Object> {

        final Uri $avatarUri;
        int label;
        final app.dogo.com.dogo_android.dogcreation.h.g this$0;
        b(app.dogo.com.dogo_android.dogcreation.h.g g, Uri uri2, d<? super app.dogo.com.dogo_android.dogcreation.h.g.b> d3) {
            this.this$0 = g;
            this.$avatarUri = uri2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (g.b)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            g.b obj3 = new g.b(this.this$0, this.$avatarUri, d2);
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
            String avatar;
            String str;
            Object obj5;
            Object obj = b.d();
            label = this.label;
            avatar = 1;
            if (label != 0) {
                if (label != avatar) {
                } else {
                    q.b(object);
                    obj5 = g.o(this.this$0).H().k(g.j(this.this$0));
                    n.d(obj5);
                    g.m(this.this$0).E0(obj5.getId(), obj5.getAvatar());
                    this.this$0.q().postValue(g.i(this.this$0));
                    unknownHostException = new y.c(obj5);
                    this.this$0.s().postValue(unknownHostException);
                    return w.a;
                }
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
            }
            q.b(object);
            this.this$0.s().postValue(y.b.a);
            if (!g.h(this.this$0).a()) {
                g.n(this.this$0).s("dog_creation_avatar");
                unknownHostException = new UnknownHostException();
                aVar = new y.a(unknownHostException);
                this.this$0.s().postValue(aVar);
            } else {
                this.label = avatar;
                if (g.k(this.this$0).d(g.j(this.this$0), (Uri)g.l(this.this$0).p(p.DogAvatar.setId(g.j(this.this$0)), this.$avatarUri).blockingGet().toString(), this) == obj) {
                    return obj;
                }
            }
        }
    }
    public g(String string, p1 p12, p2 p23, l2 l24, t2 t25, o3 o36, g2 g27, j2 j28, h0 h09) {
        n.f(string, "dogId");
        n.f(p12, "userRepository");
        n.f(p23, "preferenceService");
        n.f(l24, "fireBaseStorageService");
        n.f(t25, "storageService");
        n.f(o36, "tracker");
        n.f(g27, "dogUpdateInteractor");
        n.f(j28, "connectivityService");
        n.f(h09, "dispatcher");
        super();
        this.a = string;
        this.b = p12;
        this.c = p23;
        this.d = l24;
        this.e = t25;
        this.f = o36;
        this.g = g27;
        this.h = j28;
        this.i = h09;
        x obj2 = new x();
        this.j = obj2;
        obj2 = new x(0);
        this.k = obj2;
        g.a obj4 = new g.a(CoroutineExceptionHandler.r, this);
        this.l = obj4;
        obj2.setValue(r());
    }

    public g(String string, p1 p12, p2 p23, l2 l24, t2 t25, o3 o36, g2 g27, j2 j28, h0 h09, int i10, g g11) {
        h0 i;
        h0 h0Var;
        if (i2 &= 256 != 0) {
            h0Var = i;
        } else {
            h0Var = h09;
        }
        super(string, p12, p23, l24, t25, o36, g27, j28, h0Var);
    }

    public static final j2 h(app.dogo.com.dogo_android.dogcreation.h.g g) {
        return g.h;
    }

    public static final Uri i(app.dogo.com.dogo_android.dogcreation.h.g g) {
        return g.r();
    }

    public static final String j(app.dogo.com.dogo_android.dogcreation.h.g g) {
        return g.a;
    }

    public static final g2 k(app.dogo.com.dogo_android.dogcreation.h.g g) {
        return g.g;
    }

    public static final l2 l(app.dogo.com.dogo_android.dogcreation.h.g g) {
        return g.d;
    }

    public static final p2 m(app.dogo.com.dogo_android.dogcreation.h.g g) {
        return g.c;
    }

    public static final o3 n(app.dogo.com.dogo_android.dogcreation.h.g g) {
        return g.f;
    }

    public static final p1 o(app.dogo.com.dogo_android.dogcreation.h.g g) {
        return g.b;
    }

    private final Uri r() {
        Uri uri;
        String str;
        final String str2 = "avatar.jpg";
        if (this.e.c(this.a, str2)) {
            uri = this.e.h(this.a, str2);
        } else {
            uri = 0;
        }
        return uri;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Uri p() {
        return this.e.h(this.a, "avatar.jpg");
    }

    public final x<Uri> q() {
        return this.k;
    }

    public final x<y<DogProfile>> s() {
        return this.j;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t(Uri uri) {
        n.f(uri, "avatarUri");
        t2.k(this.e, this.a, uri, 0, 4, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(Uri uri) {
        n.f(uri, "avatarUri");
        g.b bVar = new g.b(this, uri, 0);
        k.d(f0.a(this), this.i.plus(this.l), 0, bVar, 2, 0);
    }
}
