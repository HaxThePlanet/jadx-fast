package app.dogo.com.dogo_android.q.p;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.d.a;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.a.g2;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import java.net.UnknownHostException;
import kotlin.Metadata;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;

/* compiled from: DogPreviewGenderViewModel.kt */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u001c\u001a\u00020\u0011J\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u001a0\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0018R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewGenderViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "pickerPosition", "Landroidx/lifecycle/MutableLiveData;", "", "getPickerPosition", "()Landroidx/lifecycle/MutableLiveData;", "saveState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSaveState", "isUserSignedIn", "saveDogGender", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: b0, reason: from kotlin metadata */
public final class DogPreviewGenderViewModel extends s {

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
    private final x<Integer> f = new x<>();
    private final x<y<Boolean>> g = new x<>();
    private final f.d.a.a<Boolean> h = new a<>();
    /* renamed from: i, reason: from kotlin metadata */
    private final CoroutineExceptionHandler tracker = new b0$b();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ b0 a;
        public b(CoroutineExceptionHandler.a exc, b0 b0Var) {
            this.a = b0Var;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.n().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.profile.dogprofile.DogPreviewGenderViewModel$saveDogGender$1", f = "DogPreviewGenderViewModel.kt", l = 42, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super w>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            app.dogo.com.dogo_android.k.d genderIntToEnum;
            int intValue;
            Object value;
            String str;
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    b0.this.n().postValue(new LoadResult_Success(b.a(true)));
                    b0.this.saveDogGender().postValue(b.a(true));
                    return w.a;
                }
            }
            q.b(object);
            b0.this.n().postValue(LoadResult_Loading.a);
            if (b0.this.exceptionHandler.getActiveNetworkType()) {
                if ((Integer)b0.this.m().getValue() == null) {
                    Integer num = b.c(i);
                }
                str = "pickerPosition.value ?: 0 + 1";
                n.e(value, str);
                this.label = i;
                if (b0.this.connectivityService.i(b0.this.authService.getId(), DogGender.INSTANCE.genderIntToEnum(value.intValue()), this) == obj2) {
                    return obj2;
                }
            } else {
                b0.this.dogUpdateInteractor.setTrainingReminderUserProperties("dog_preview_gender");
                b0.this.n().postValue(new LoadResult_Error(new UnknownHostException()));
            }
        }

        a(kotlin.b0.d<? super b0.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (app.dogo.com.dogo_android.profile.dogprofile.b0.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new app.dogo.com.dogo_android.profile.dogprofile.b0.a(b0.this, dVar);
        }
    }
    public b0(DogProfile dogProfile, g2 g2Var, h2 h2Var, o3 o3Var, j2 j2Var) {
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
        x xVar2 = new x(Integer.valueOf(g.b(dogProfile.getGender().ordinal() - 1, 0)));
        x xVar = new x();
        f.d.a.a aVar = new a();
        app.dogo.com.dogo_android.q.p.b0.b coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }

    public static final /* synthetic */ j2 h(b0 b0Var) {
        return b0Var.exceptionHandler;
    }

    public static final /* synthetic */ DogProfile i(b0 b0Var) {
        return b0Var.authService;
    }

    public static final /* synthetic */ g2 j(b0 b0Var) {
        return b0Var.connectivityService;
    }

    public static final /* synthetic */ o3 k(b0 b0Var) {
        return b0Var.dogUpdateInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserSignedIn() {
        return this.dogProfile.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: l, reason: from kotlin metadata */
    public final f.d.a.a<Boolean> saveDogGender() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> m() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> n() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void o() {
        final kotlin.b0.d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.tracker, dVar, new app.dogo.com.dogo_android.profile.dogprofile.b0.a(this, dVar), 2, null);
    }
}
