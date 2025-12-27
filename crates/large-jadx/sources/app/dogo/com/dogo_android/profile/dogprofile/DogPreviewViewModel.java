package app.dogo.com.dogo_android.q.p;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.repository.domain.UserAuthRecord;
import app.dogo.com.dogo_android.s.a.g2;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.l2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.i0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.u2;
import i.b.a0;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: DogPreviewViewModel.kt */
@Metadata(d1 = "\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0012\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u001fH\u0002J\u0006\u00102\u001a\u00020\u0003J\u0006\u00103\u001a\u00020\u0003J\u000e\u00104\u001a\u0002052\u0006\u00101\u001a\u00020\u001fJ\u000e\u00106\u001a\u0002052\u0006\u00107\u001a\u000200J\u0006\u00108\u001a\u000205J\u0018\u00109\u001a\u0002052\u0006\u00107\u001a\u0002002\u0006\u00101\u001a\u00020\u001fH\u0002J\u0006\u0010:\u001a\u000205J\u0006\u0010;\u001a\u000205J\u0018\u0010<\u001a\u0002052\u0006\u00107\u001a\u0002002\u0006\u00101\u001a\u00020\u001fH\u0002R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u001b0\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\u0008 \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u00030%¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010(\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020)0\u001b0\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u001dR\u001b\u0010+\u001a\u000c\u0012\u0008\u0012\u00060,j\u0002`-0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006=", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "isFullScreen", "", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "fireBaseStorageService", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "profilePreviewInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProfilePreviewInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(ZLapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/FireBaseStorageService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/interactor/GetProfilePreviewInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lkotlinx/coroutines/CoroutineDispatcher;)V", "avatarSavingState", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getAvatarSavingState", "()Landroidx/lifecycle/MutableLiveData;", "emptyDogId", "", "getEmptyDogId", "()Ljava/lang/String;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "onAvatarUpload", "Lcom/hadilq/liveevent/LiveEvent;", "getOnAvatarUpload", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "getResult", "showErrorToast", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getShowErrorToast", "getAvatarFromLocalStorage", "Landroid/net/Uri;", "dogId", "isUserNameSet", "isUserSignedIn", "refreshData", "", "saveAndUploadAvatarUri", "avatarUri", "saveForcedDogCreationFlag", "saveUriToLocalStorage", "trackAddNewDog", "trackDeleteDogClicked", "uploadAvatarAndUpdateProfile", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h0, reason: from kotlin metadata */
public final class DogPreviewViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final boolean authService;
    private final app.dogo.com.dogo_android.service.t2 b;
    /* renamed from: c, reason: from kotlin metadata */
    private final l2 connectivityService;
    /* renamed from: d, reason: from kotlin metadata */
    private final p2 dispatcher;
    /* renamed from: e, reason: from kotlin metadata */
    private final p1 dogUpdateInteractor;
    private final app.dogo.com.dogo_android.s.a.t2 f;
    /* renamed from: g, reason: from kotlin metadata */
    private final o3 exceptionHandler;
    /* renamed from: h, reason: from kotlin metadata */
    private final h2 fireBaseStorageService;
    /* renamed from: i, reason: from kotlin metadata */
    private final j2 isFullScreen;
    private final g2 j;
    /* renamed from: k, reason: from kotlin metadata */
    private final h0 preferenceService;
    /* renamed from: l, reason: from kotlin metadata */
    private final x<app.dogo.com.dogo_android.util.e0.y<Boolean>> profilePreviewInteractor;
    private final f.d.a.a<Boolean> m;
    private final x<app.dogo.com.dogo_android.util.e0.y<ProfilePreview>> n;
    /* renamed from: o, reason: from kotlin metadata */
    private final f.d.a.a<Exception> storageService;
    /* renamed from: p, reason: from kotlin metadata */
    private final CoroutineExceptionHandler tracker;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ h0 a;
        public b(CoroutineExceptionHandler.a exc, h0 h0Var) {
            this.a = h0Var;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.t().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ h0 a;
        public c(CoroutineExceptionHandler.a exc, h0 h0Var) {
            this.a = h0Var;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.q().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.profile.dogprofile.DogPreviewViewModel$refreshData$1", f = "DogPreviewViewModel.kt", l = {}, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        final /* synthetic */ String $dogId;
        private /* synthetic */ Object L$0;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                h0.this.t().postValue(new LoadResult_Success((ProfilePreview)h0.this.f.getProfilePreview(this.$dogId, h0.this.authService, (CoroutineScope)this.L$0).blockingGet()));
                return w.a;
            }
        }

        a(String str, d<? super h0.a> dVar) {
            this.$dogId = str;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.profile.dogprofile.h0.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            final app.dogo.com.dogo_android.q.p.h0.a aVar = new app.dogo.com.dogo_android.profile.dogprofile.h0.a(h0.this, this.$dogId, dVar);
            aVar.L$0 = object;
            return aVar;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.profile.dogprofile.DogPreviewViewModel$uploadAvatarAndUpdateProfile$1", f = "DogPreviewViewModel.kt", l = 73, m = "invokeSuspend")
    static final class d extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        final /* synthetic */ Uri $avatarUri;
        final /* synthetic */ String $dogId;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            g2 refreshData;
            String $dogId22;
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    try {
                        q.b(object);
                    } catch (Exception e) {
                    }
                    DogProfile dogProfile = h0.this.dogUpdateInteractor.H().getDogProfile(this.$dogId);
                    if (dogProfile != null) {
                        h0.this.dispatcher.E0(dogProfile.getId(), dogProfile.getAvatar());
                    }
                    h0.this.s().postValue(b.a(true));
                    h0.this.q().postValue(new LoadResult_Success(b.a(true)));
                    h0.this.v(this.$dogId);
                    return w.a;
                }
            }
            q.b(e);
            h0.this.q().postValue(LoadResult_Loading.a);
            if (!h0.this.isFullScreen.getActiveNetworkType()) {
                h0.this.exceptionHandler.setTrainingReminderUserProperties("dog_preview");
                h0.this.q().postValue(new LoadResult_Error(new UnknownHostException()));
            } else {
                try {
                    this.label = i;
                    if (h0.this.j.d(this.$dogId, (Uri)h0.this.connectivityService.p(StoragePath.DogAvatar.setId(this.$dogId), this.$avatarUri).blockingGet().toString(), this) == obj2) {
                        return obj2;
                    }
                    dogProfile = h0.this.dogUpdateInteractor.H().getDogProfile(this.$dogId);
                    h0.this.s().postValue(b.a(true));
                    h0.this.q().postValue(new LoadResult_Success(b.a(true)));
                    h0.this.v(this.$dogId);
                } catch (Exception e) {
                }
                app.dogo.com.dogo_android.q.p.h0 h0Var = h0.this.q();
                h0.this.postValue(new LoadResult_Error(e));
            }
        }

        d(String str, Uri uri, d<? super h0.d> dVar) {
            this.$dogId = str;
            this.$avatarUri = uri;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.profile.dogprofile.h0.d)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.profile.dogprofile.h0.d(h0.this, this.$dogId, this.$avatarUri, dVar);
        }
    }
    public /* synthetic */ h0(boolean z, app.dogo.com.dogo_android.service.t2 t2Var, l2 l2Var, p2 p2Var, p1 p1Var, app.dogo.com.dogo_android.s.a.t2 t2Var2, o3 o3Var, h2 h2Var, j2 j2Var, g2 g2Var, h0 h0Var, int i, kotlin.d0.d.g gVar) {
        h0 h0Var112;
        h0Var112 = i & 1024 != 0 ? h0Var112 : h0Var;
        this(z, t2Var, l2Var, p2Var, p1Var, t2Var2, o3Var, h2Var, j2Var, g2Var, h0Var112);
    }

    /* renamed from: B, reason: from kotlin metadata */
    private final void saveUriToLocalStorage(Uri avatarUri, String dogId) {
        kotlinx.coroutines.internal.k.d(f0.a(this), this.preferenceService.plus(new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this)), null, new app.dogo.com.dogo_android.profile.dogprofile.h0.d(this, dogId, avatarUri, null), 2, null);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 getAvatarFromLocalStorage(h0 dogId) {
        return dogId.isFullScreen;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ g2 refreshData(h0 dogId) {
        return dogId.j;
    }

    /* renamed from: j, reason: from kotlin metadata */
    public static final /* synthetic */ l2 saveAndUploadAvatarUri(h0 avatarUri) {
        return avatarUri.connectivityService;
    }

    public static final /* synthetic */ p2 k(h0 h0Var) {
        return h0Var.dispatcher;
    }

    public static final /* synthetic */ app.dogo.com.dogo_android.s.a.t2 l(h0 h0Var) {
        return h0Var.f;
    }

    public static final /* synthetic */ o3 m(h0 h0Var) {
        return h0Var.exceptionHandler;
    }

    public static final /* synthetic */ p1 n(h0 h0Var) {
        return h0Var.dogUpdateInteractor;
    }

    public static final /* synthetic */ boolean o(h0 h0Var) {
        return h0Var.authService;
    }

    private final Uri p(String str) {
        return this.b.h(str, "avatar.jpg");
    }

    /* renamed from: y, reason: from kotlin metadata */
    private final void uploadAvatarAndUpdateProfile(Uri avatarUri, String dogId) {
        StorageService.k(this.b, dogId, avatarUri, null, 4, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: A, reason: from kotlin metadata */
    public final void isUserNameSet() {
        this.exceptionHandler.logEvent(E_DogProfile.b);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserNameSet() {
        UserAuthRecord userAuthRecord;
        boolean z2 = true;
        userAuthRecord = this.fireBaseStorageService.A();
        int i = 1;
        int r1 = 0;
        return false;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserSignedIn() {
        return this.fireBaseStorageService.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<app.dogo.com.dogo_android.util.e0.y<Boolean>> q() {
        return this.profilePreviewInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String r() {
        return this.dogUpdateInteractor.H().n();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> s() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<app.dogo.com.dogo_android.util.e0.y<ProfilePreview>> t() {
        return this.n;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Exception> u() {
        return this.storageService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v(String str) {
        n.f(str, "dogId");
        kotlinx.coroutines.internal.k.d(f0.a(this), this.preferenceService.plus(this.tracker), null, new app.dogo.com.dogo_android.profile.dogprofile.h0.a(this, str, null), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w(Uri uri) {
        int i;
        DogProfile dogProfile = null;
        n.f(uri, "avatarUri");
        LoadResult_Success r0 = this.n.getValue() instanceof LoadResult_Success ? (oadResult_Success)this.n.getValue() : 0;
        if (this.n != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                dogProfile = component1.getDogProfile();
            }
        }
        if (dogProfile == null) {
            this.storageService.postValue(new IllegalStateException());
        } else {
            uploadAvatarAndUpdateProfile(uri, dogProfile.getId());
            Uri uri2 = p(dogProfile.getId());
            if (uri2 != null) {
                saveUriToLocalStorage(uri2, dogProfile.getId());
            } else {
                this.storageService.postValue(new IllegalStateException());
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        this.dispatcher.U0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z() {
        this.exceptionHandler.logEvent(E_Profile.a.c(new EP_ViewSource(), "dog_profile"));
    }

    public h0(boolean z, app.dogo.com.dogo_android.service.t2 t2Var, l2 l2Var, p2 p2Var, p1 p1Var, app.dogo.com.dogo_android.s.a.t2 t2Var2, o3 o3Var, h2 h2Var, j2 j2Var, g2 g2Var, h0 h0Var) {
        n.f(t2Var, "storageService");
        n.f(l2Var, "fireBaseStorageService");
        n.f(p2Var, "preferenceService");
        n.f(p1Var, "userRepository");
        n.f(t2Var2, "profilePreviewInteractor");
        n.f(o3Var, "tracker");
        n.f(h2Var, "authService");
        n.f(j2Var, "connectivityService");
        n.f(g2Var, "dogUpdateInteractor");
        n.f(h0Var, "dispatcher");
        super();
        this.authService = z;
        this.b = t2Var;
        this.connectivityService = l2Var;
        this.dispatcher = p2Var;
        this.dogUpdateInteractor = p1Var;
        this.f = t2Var2;
        this.exceptionHandler = o3Var;
        this.fireBaseStorageService = h2Var;
        this.isFullScreen = j2Var;
        this.j = g2Var;
        this.preferenceService = h0Var;
        this.profilePreviewInteractor = new x();
        this.m = new a();
        this.n = new x();
        this.storageService = new a();
        this.tracker = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }
}
