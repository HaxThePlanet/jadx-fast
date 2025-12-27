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
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;

/* compiled from: DogPreviewNameViewModel.kt */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0016J\u0006\u0010\u001e\u001a\u00020\u0011J\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u001d\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u001a0\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0018R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewNameViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "nameField", "Landroidx/lifecycle/MutableLiveData;", "", "getNameField", "()Landroidx/lifecycle/MutableLiveData;", "saveState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSaveState", "isNameValid", "name", "isUserSignedIn", "saveDogName", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e0, reason: from kotlin metadata */
public final class DogPreviewNameViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final DogProfile authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final g2 connectivityService;
    /* renamed from: c, reason: from kotlin metadata */
    private final h2 dogProfile;
    /* renamed from: d, reason: from kotlin metadata */
    private final o3 dogUpdateInteractor;
    /* renamed from: e, reason: from kotlin metadata */
    private final j2 exceptionHandler;
    private final x<String> f = new x<>();
    private final x<y<Boolean>> g = new x<>();
    private final f.d.a.a<Boolean> h = new a<>();
    /* renamed from: i, reason: from kotlin metadata */
    private final CoroutineExceptionHandler tracker = new e0$b();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ e0 a;
        public b(CoroutineExceptionHandler.a exc, e0 e0Var) {
            this.a = e0Var;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.n().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.profile.dogprofile.DogPreviewNameViewModel$saveDogName$1", f = "DogPreviewNameViewModel.kt", l = 42, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        final /* synthetic */ String $name;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            String $name2;
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    e0.this.n().postValue(new LoadResult_Success(b.a(true)));
                    e0.this.l().postValue(b.a(true));
                    return w.a;
                }
            }
            q.b(object);
            e0.this.n().postValue(LoadResult_Loading.a);
            if (e0.this.exceptionHandler.getActiveNetworkType()) {
                this.label = i;
                if (e0.this.connectivityService.k(e0.this.authService.getId(), this.$name, this) == obj2) {
                    return obj2;
                }
            } else {
                e0.this.dogUpdateInteractor.setTrainingReminderUserProperties("dog_preview_name");
                e0.this.n().postValue(new LoadResult_Error(new UnknownHostException()));
            }
        }

        a(String str, d<? super e0.a> dVar) {
            this.$name = str;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.profile.dogprofile.e0.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.profile.dogprofile.e0.a(e0.this, this.$name, dVar);
        }
    }
    public e0(DogProfile dogProfile, g2 g2Var, h2 h2Var, o3 o3Var, j2 j2Var) {
        n.f(dogProfile, "dogProfile");
        n.f(g2Var, "dogUpdateInteractor");
        n.f(h2Var, "authService");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        super();
        this.authService = dogProfile;
        this.connectivityService = g2Var;
        this.dogProfile = h2Var;
        this.dogUpdateInteractor = o3Var;
        this.exceptionHandler = j2Var;
        x xVar2 = new x(app.dogo.com.dogo_android.util.extensionfunction.j1.w0(dogProfile.getName()));
        x xVar = new x();
        f.d.a.a aVar = new a();
        app.dogo.com.dogo_android.q.p.e0.b coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 isNameValid(e0 name) {
        return name.exceptionHandler;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ DogProfile saveDogName(e0 name) {
        return name.authService;
    }

    public static final /* synthetic */ g2 j(e0 e0Var) {
        return e0Var.connectivityService;
    }

    public static final /* synthetic */ o3 k(e0 e0Var) {
        return e0Var.dogUpdateInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserSignedIn() {
        return this.dogProfile.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> l() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<String> m() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> n() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean o(String str) {
        int i;
        boolean z = true;
        int length;
        n.f(str, "name");
        i = 0;
        int r0 = str.length() > 0 ? 1 : i;
        if (i != 0) {
            i = 21;
            if (str.length() > 21) {
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p(String str) {
        n.f(str, "name");
        kotlinx.coroutines.internal.k.d(f0.a(this), this.tracker, null, new app.dogo.com.dogo_android.profile.dogprofile.e0.a(this, str, null), 2, null);
    }
}
