package app.dogo.com.dogo_android.dogcreation.h;

import android.net.Uri;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
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
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: DogCreationAvatarViewModel.kt */
@Metadata(d1 = "\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0008\u0010 \u001a\u0004\u0018\u00010\u0017J\n\u0010!\u001a\u0004\u0018\u00010\u0017H\u0002J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017J\u000e\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0017R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001e0\u001d0\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/avatar/DogCreationAvatarViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogId", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "fireBaseStorageService", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/FireBaseStorageService;Lapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "avatarUriLiveData", "Landroidx/lifecycle/MutableLiveData;", "Landroid/net/Uri;", "getAvatarUriLiveData", "()Landroidx/lifecycle/MutableLiveData;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "savingState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "getSavingState", "getAvatarFromLocalStorage", "getDogAvatarUri", "saveUriToLocalStorage", "", "avatarUri", "uploadAvatarAndUpdateProfile", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g, reason: from kotlin metadata */
public final class DogCreationAvatarViewModel extends s {

    private final String a;
    /* renamed from: b, reason: from kotlin metadata */
    private final p1 connectivityService;
    /* renamed from: c, reason: from kotlin metadata */
    private final p2 dispatcher;
    /* renamed from: d, reason: from kotlin metadata */
    private final l2 dogId;
    /* renamed from: e, reason: from kotlin metadata */
    private final t2 dogUpdateInteractor;
    /* renamed from: f, reason: from kotlin metadata */
    private final o3 exceptionHandler;
    /* renamed from: g, reason: from kotlin metadata */
    private final g2 fireBaseStorageService;
    /* renamed from: h, reason: from kotlin metadata */
    private final j2 preferenceService;
    private final h0 i;
    /* renamed from: j, reason: from kotlin metadata */
    private final x<y<DogProfile>> storageService;
    /* renamed from: k, reason: from kotlin metadata */
    private final x<Uri> tracker;
    /* renamed from: l, reason: from kotlin metadata */
    private final CoroutineExceptionHandler userRepository;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a extends a implements CoroutineExceptionHandler {

        final /* synthetic */ g a;
        public a(CoroutineExceptionHandler.a exc, g gVar) {
            this.a = gVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.s().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dogcreation.avatar.DogCreationAvatarViewModel$uploadAvatarAndUpdateProfile$1", f = "DogCreationAvatarViewModel.kt", l = 50, m = "invokeSuspend")
    static final class b extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        final /* synthetic */ Uri $avatarUri;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            String str;
            Object obj2 = b.d();
            int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    DogProfile dogProfile = g.this.connectivityService.H().getDogProfile(g.this.a);
                    n.d(dogProfile);
                    g.this.dispatcher.getChallengeFilters(dogProfile.getId(), dogProfile.getAvatar());
                    g.this.q().postValue(g.this.getAvatarFromLocalStorage());
                    g.this.s().postValue(new LoadResult_Success(dogProfile));
                    return w.a;
                }
            }
            q.b(object);
            g.this.s().postValue(LoadResult_Loading.a);
            if (g.this.preferenceService.getActiveNetworkType()) {
                this.label = i;
                if (g.this.fireBaseStorageService.d(g.this.a, (Uri)g.this.dogId.p(StoragePath.DogAvatar.setId(g.this.a), this.$avatarUri).blockingGet().toString(), this) == obj2) {
                    return obj2;
                }
            } else {
                g.this.exceptionHandler.setTrainingReminderUserProperties("dog_creation_avatar");
                g.this.s().postValue(new LoadResult_Error(new UnknownHostException()));
            }
        }

        b(Uri uri, d<? super g.b> dVar) {
            this.$avatarUri = uri;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.g.b)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.g.b(g.this, this.$avatarUri, dVar);
        }
    }
    public /* synthetic */ g(String str, p1 p1Var, p2 p2Var, l2 l2Var, t2 t2Var, o3 o3Var, g2 g2Var, j2 j2Var, h0 h0Var, int i, kotlin.d0.d.g gVar) {
        h0 h0Var92;
        h0Var92 = i & 256 != 0 ? h0Var92 : h0Var;
        this(str, p1Var, p2Var, l2Var, t2Var, o3Var, g2Var, j2Var, h0Var92);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 saveUriToLocalStorage(g avatarUri) {
        return avatarUri.preferenceService;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ Uri uploadAvatarAndUpdateProfile(g avatarUri) {
        return avatarUri.getAvatarFromLocalStorage();
    }

    public static final /* synthetic */ String j(g gVar) {
        return gVar.a;
    }

    public static final /* synthetic */ g2 k(g gVar) {
        return gVar.fireBaseStorageService;
    }

    public static final /* synthetic */ l2 l(g gVar) {
        return gVar.dogId;
    }

    public static final /* synthetic */ p2 m(g gVar) {
        return gVar.dispatcher;
    }

    public static final /* synthetic */ o3 n(g gVar) {
        return gVar.exceptionHandler;
    }

    public static final /* synthetic */ p1 o(g gVar) {
        return gVar.connectivityService;
    }

    /* renamed from: r, reason: from kotlin metadata */
    private final Uri getAvatarFromLocalStorage() {
        Uri uri = null;
        final String str2 = "avatar.jpg";
        if (this.dogUpdateInteractor.c(this.a, str2)) {
            uri = this.dogUpdateInteractor.h(this.a, "avatar.jpg");
        } else {
            int i = 0;
        }
        return uri;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final Uri p() {
        return this.dogUpdateInteractor.h(this.a, "avatar.jpg");
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Uri> q() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<DogProfile>> s() {
        return this.storageService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void t(Uri uri) {
        n.f(uri, "avatarUri");
        StorageService.k(this.dogUpdateInteractor, this.a, uri, null, 4, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void u(Uri uri) {
        n.f(uri, "avatarUri");
        kotlinx.coroutines.internal.k.d(f0.a(this), this.i.plus(this.userRepository), null, new kotlinx.coroutines.g.b(this, uri, null), 2, null);
    }

    public g(String str, p1 p1Var, p2 p2Var, l2 l2Var, t2 t2Var, o3 o3Var, g2 g2Var, j2 j2Var, h0 h0Var) {
        n.f(str, "dogId");
        n.f(p1Var, "userRepository");
        n.f(p2Var, "preferenceService");
        n.f(l2Var, "fireBaseStorageService");
        n.f(t2Var, "storageService");
        n.f(o3Var, "tracker");
        n.f(g2Var, "dogUpdateInteractor");
        n.f(j2Var, "connectivityService");
        n.f(h0Var, "dispatcher");
        super();
        this.a = str;
        this.connectivityService = p1Var;
        this.dispatcher = p2Var;
        this.dogId = l2Var;
        this.dogUpdateInteractor = t2Var;
        this.exceptionHandler = o3Var;
        this.fireBaseStorageService = g2Var;
        this.preferenceService = j2Var;
        this.i = h0Var;
        this.storageService = new x();
        x xVar2 = new x(null);
        this.tracker = xVar2;
        this.userRepository = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
        xVar2.setValue(getAvatarFromLocalStorage());
    }
}
