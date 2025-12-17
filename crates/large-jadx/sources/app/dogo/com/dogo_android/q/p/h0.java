package app.dogo.com.dogo_android.q.p;

import android.net.Uri;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.p;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.repository.domain.UserAuthRecord;
import app.dogo.com.dogo_android.s.a.g2;
import app.dogo.com.dogo_android.s.a.t2;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.h2;
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
import app.dogo.com.dogo_android.w.i0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.com.dogo_android.w.y;
import f.d.a.a;
import i.b.a0;
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
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0012\u0010/\u001a\u0004\u0018\u0001002\u0006\u00101\u001a\u00020\u001fH\u0002J\u0006\u00102\u001a\u00020\u0003J\u0006\u00103\u001a\u00020\u0003J\u000e\u00104\u001a\u0002052\u0006\u00101\u001a\u00020\u001fJ\u000e\u00106\u001a\u0002052\u0006\u00107\u001a\u000200J\u0006\u00108\u001a\u000205J\u0018\u00109\u001a\u0002052\u0006\u00107\u001a\u0002002\u0006\u00101\u001a\u00020\u001fH\u0002J\u0006\u0010:\u001a\u000205J\u0006\u0010;\u001a\u000205J\u0018\u0010<\u001a\u0002052\u0006\u00107\u001a\u0002002\u0006\u00101\u001a\u00020\u001fH\u0002R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u001b0\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f8F¢\u0006\u0006\u001a\u0004\u0008 \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u00030%¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010(\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020)0\u001b0\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\u001dR\u001b\u0010+\u001a\u000c\u0012\u0008\u0012\u00060,j\u0002`-0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010'R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006=", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "isFullScreen", "", "storageService", "Lapp/dogo/com/dogo_android/service/StorageService;", "fireBaseStorageService", "Lapp/dogo/com/dogo_android/service/FireBaseStorageService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "profilePreviewInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProfilePreviewInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(ZLapp/dogo/com/dogo_android/service/StorageService;Lapp/dogo/com/dogo_android/service/FireBaseStorageService;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/interactor/GetProfilePreviewInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lkotlinx/coroutines/CoroutineDispatcher;)V", "avatarSavingState", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getAvatarSavingState", "()Landroidx/lifecycle/MutableLiveData;", "emptyDogId", "", "getEmptyDogId", "()Ljava/lang/String;", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "onAvatarUpload", "Lcom/hadilq/liveevent/LiveEvent;", "getOnAvatarUpload", "()Lcom/hadilq/liveevent/LiveEvent;", "result", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "getResult", "showErrorToast", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getShowErrorToast", "getAvatarFromLocalStorage", "Landroid/net/Uri;", "dogId", "isUserNameSet", "isUserSignedIn", "refreshData", "", "saveAndUploadAvatarUri", "avatarUri", "saveForcedDogCreationFlag", "saveUriToLocalStorage", "trackAddNewDog", "trackDeleteDogClicked", "uploadAvatarAndUpdateProfile", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h0 extends s {

    private final boolean a;
    private final t2 b;
    private final l2 c;
    private final p2 d;
    private final p1 e;
    private final t2 f;
    private final o3 g;
    private final h2 h;
    private final j2 i;
    private final g2 j;
    private final h0 k;
    private final x<y<Boolean>> l;
    private final a<Boolean> m;
    private final x<y<ProfilePreview>> n;
    private final a<Exception> o;
    private final CoroutineExceptionHandler p;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.q.p.h0 a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.q.p.h0 h02) {
            this.a = h02;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.t().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.q.p.h0 a;
        public c(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.q.p.h0 h02) {
            this.a = h02;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.q().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.profile.dogprofile.DogPreviewViewModel$refreshData$1", f = "DogPreviewViewModel.kt", l = {}, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        final String $dogId;
        private Object L$0;
        int label;
        final app.dogo.com.dogo_android.q.p.h0 this$0;
        a(app.dogo.com.dogo_android.q.p.h0 h0, String string2, d<? super app.dogo.com.dogo_android.q.p.h0.a> d3) {
            this.this$0 = h0;
            this.$dogId = string2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (h0.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            h0.a aVar = new h0.a(this.this$0, this.$dogId, d2);
            aVar.L$0 = object;
            return aVar;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            b.d();
            if (this.label != 0) {
            } else {
                q.b(object);
                y.c cVar = new y.c((ProfilePreview)h0.l(this.this$0).a(this.$dogId, h0.o(this.this$0), (m0)this.L$0).blockingGet());
                this.this$0.t().postValue(cVar);
                return w.a;
            }
            IllegalStateException obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj4;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.profile.dogprofile.DogPreviewViewModel$uploadAvatarAndUpdateProfile$1", f = "DogPreviewViewModel.kt", l = 73, m = "invokeSuspend")
    static final class d extends k implements p<m0, d<? super w>, Object> {

        final Uri $avatarUri;
        final String $dogId;
        int label;
        final app.dogo.com.dogo_android.q.p.h0 this$0;
        d(app.dogo.com.dogo_android.q.p.h0 h0, String string2, Uri uri3, d<? super app.dogo.com.dogo_android.q.p.h0.d> d4) {
            this.this$0 = h0;
            this.$dogId = string2;
            this.$avatarUri = uri3;
            super(2, d4);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (h0.d)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            h0.d obj4 = new h0.d(this.this$0, this.$dogId, this.$avatarUri, d2);
            return obj4;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object $dogId;
            Object $dogId2;
            Object unknownHostException;
            g2 label;
            String $dogId3;
            Object obj5;
            Object obj = b.d();
            label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    q.b(object);
                    obj5 = h0.n(this.this$0).H().k(this.$dogId);
                    if (obj5 == null) {
                    } else {
                        try {
                            h0.k(this.this$0).E0(obj5.getId(), obj5.getAvatar());
                            this.this$0.s().postValue(b.a(i));
                            y.c cVar = new y.c(b.a(i));
                            this.this$0.q().postValue(cVar);
                            this.this$0.v(this.$dogId);
                            app.dogo.com.dogo_android.q.p.h0 h0Var = this.this$0;
                            h0Var = h0Var.q();
                            y.a aVar = new y.a(object);
                            h0Var.postValue(aVar);
                        }
                        return w.a;
                    }
                }
                obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj5;
            }
            q.b(object);
            this.this$0.q().postValue(y.b.a);
            if (!h0.h(this.this$0).a()) {
                h0.m(this.this$0).s("dog_preview");
                unknownHostException = new UnknownHostException();
                $dogId = new y.a(unknownHostException);
                this.this$0.q().postValue($dogId);
            } else {
                this.label = i;
                if (h0.i(this.this$0).d(this.$dogId, (Uri)h0.j(this.this$0).p(p.DogAvatar.setId(this.$dogId), this.$avatarUri).blockingGet().toString(), this) == obj) {
                    return obj;
                }
            }
        }
    }
    public h0(boolean z, t2 t22, l2 l23, p2 p24, p1 p15, t2 t26, o3 o37, h2 h28, j2 j29, g2 g210, h0 h011) {
        n.f(t22, "storageService");
        n.f(l23, "fireBaseStorageService");
        n.f(p24, "preferenceService");
        n.f(p15, "userRepository");
        n.f(t26, "profilePreviewInteractor");
        n.f(o37, "tracker");
        n.f(h28, "authService");
        n.f(j29, "connectivityService");
        n.f(g210, "dogUpdateInteractor");
        n.f(h011, "dispatcher");
        super();
        this.a = z;
        this.b = t22;
        this.c = l23;
        this.d = p24;
        this.e = p15;
        this.f = t26;
        this.g = o37;
        this.h = h28;
        this.i = j29;
        this.j = g210;
        this.k = h011;
        x obj2 = new x();
        this.l = obj2;
        obj2 = new a();
        this.m = obj2;
        obj2 = new x();
        this.n = obj2;
        obj2 = new a();
        this.o = obj2;
        h0.b obj3 = new h0.b(CoroutineExceptionHandler.r, this);
        this.p = obj3;
    }

    public h0(boolean z, t2 t22, l2 l23, p2 p24, p1 p15, t2 t26, o3 o37, h2 h28, j2 j29, g2 g210, h0 h011, int i12, g g13) {
        h0 i;
        h0 h0Var;
        if (i2 &= 1024 != 0) {
            h0Var = i;
        } else {
            h0Var = h011;
        }
        super(z, t22, l23, p24, p15, t26, o37, h28, j29, g210, h0Var);
    }

    private final void B(Uri uri, String string2) {
        h0.c cVar = new h0.c(CoroutineExceptionHandler.r, this);
        h0.d dVar = new h0.d(this, string2, uri, 0);
        k.d(f0.a(this), this.k.plus(cVar), 0, dVar, 2, 0);
    }

    public static final j2 h(app.dogo.com.dogo_android.q.p.h0 h0) {
        return h0.i;
    }

    public static final g2 i(app.dogo.com.dogo_android.q.p.h0 h0) {
        return h0.j;
    }

    public static final l2 j(app.dogo.com.dogo_android.q.p.h0 h0) {
        return h0.c;
    }

    public static final p2 k(app.dogo.com.dogo_android.q.p.h0 h0) {
        return h0.d;
    }

    public static final t2 l(app.dogo.com.dogo_android.q.p.h0 h0) {
        return h0.f;
    }

    public static final o3 m(app.dogo.com.dogo_android.q.p.h0 h0) {
        return h0.g;
    }

    public static final p1 n(app.dogo.com.dogo_android.q.p.h0 h0) {
        return h0.e;
    }

    public static final boolean o(app.dogo.com.dogo_android.q.p.h0 h0) {
        return h0.a;
    }

    private final Uri p(String string) {
        return this.b.h(string, "avatar.jpg");
    }

    private final void y(Uri uri, String string2) {
        t2.k(this.b, string2, uri, 0, 4, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void A() {
        this.g.d(y.b);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserNameSet() {
        UserAuthRecord displayName;
        int i;
        displayName = this.h.A();
        i = 1;
        if (displayName == null) {
            i = i2;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserSignedIn() {
        return this.h.D();
    }

    public final x<y<Boolean>> q() {
        return this.l;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String r() {
        return this.e.H().n();
    }

    public final a<Boolean> s() {
        return this.m;
    }

    public final x<y<ProfilePreview>> t() {
        return this.n;
    }

    public final a<Exception> u() {
        return this.o;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void v(String string) {
        n.f(string, "dogId");
        h0.a aVar = new h0.a(this, string, 0);
        k.d(f0.a(this), this.k.plus(this.p), 0, aVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void w(Uri uri) {
        int value;
        Object illegalStateException;
        DogProfile dogProfile;
        Object obj4;
        n.f(uri, "avatarUri");
        if (value instanceof y.c) {
        } else {
            value = dogProfile;
        }
        if (value == null) {
        } else {
            value = value.a();
            if ((ProfilePreview)value == null) {
            } else {
                dogProfile = (ProfilePreview)value.getDogProfile();
            }
        }
        if (dogProfile != null) {
            y(uri, dogProfile.getId());
            obj4 = p(dogProfile.getId());
            if (obj4 != null) {
                B(obj4, dogProfile.getId());
            } else {
                illegalStateException = new IllegalStateException();
                this.o.postValue(illegalStateException);
            }
        } else {
            illegalStateException = new IllegalStateException();
            this.o.postValue(illegalStateException);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        this.d.U0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z() {
        r2 r2Var = new r2();
        this.g.d(i0.a.c(r2Var, "dog_profile"));
    }
}
