package app.dogo.com.dogo_android.dogcreation.k;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.d.a;
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

/* compiled from: DogCreationGenderViewModel.kt */
@Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B/\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0006\u0010\u001c\u001a\u00020\u0011J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013R\u0017\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0018R\u001d\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00110\u001a0\u0015¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0018R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/gender/DogCreationGenderViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "initialGender", "Lapp/dogo/com/dogo_android/enums/DogGender;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/enums/DogGender;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "pickerPosition", "Landroidx/lifecycle/MutableLiveData;", "", "getPickerPosition", "()Landroidx/lifecycle/MutableLiveData;", "savingState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSavingState", "isUserSignedIn", "saveDogGender", "", "dogId", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class DogCreationGenderViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final g2 authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final o3 connectivityService;
    /* renamed from: c, reason: from kotlin metadata */
    private final j2 dogUpdateInteractor;
    /* renamed from: d, reason: from kotlin metadata */
    private final x<y<Boolean>> exceptionHandler = new x<>();
    private final f.d.a.a<Boolean> e = new a<>();
    private final x<Integer> f = new x<>();
    private final CoroutineExceptionHandler g = new f$b();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ f a;
        public b(CoroutineExceptionHandler.a exc, f fVar) {
            this.a = fVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(kotlin.b0.g context, Throwable exception) {
            this.a.m().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.dogcreation.gender.DogCreationGenderViewModel$saveDogGender$1", f = "DogCreationGenderViewModel.kt", l = 41, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super w>, Object> {

        final /* synthetic */ String $dogId;
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
                    f.this.m().postValue(new LoadResult_Success(b.a(true)));
                    f.this.isUserSignedIn().postValue(b.a(true));
                    return w.a;
                }
            }
            q.b(object);
            if (!(f.this.m().getValue() instanceof LoadResult_Loading)) {
                f.this.m().postValue(LoadResult_Loading.a);
                if (f.this.dogUpdateInteractor.getActiveNetworkType()) {
                    if ((Integer)f.this.l().getValue() == null) {
                        Integer num = b.c(i);
                    }
                    str = "pickerPosition.value ?: 0 + 1";
                    n.e(value, str);
                    this.label = i;
                    if (f.this.authService.i(this.$dogId, DogGender.INSTANCE.genderIntToEnum(value.intValue()), this) == obj2) {
                        return obj2;
                    }
                } else {
                    f.this.connectivityService.setTrainingReminderUserProperties("dog_creation_gender");
                    f.this.m().postValue(new LoadResult_Error(new UnknownHostException()));
                }
            }
        }

        a(String str, kotlin.b0.d<? super f.a> dVar) {
            this.$dogId = str;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (kotlinx.coroutines.f.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new kotlinx.coroutines.f.a(f.this, this.$dogId, dVar);
        }
    }
    public f(app.dogo.com.dogo_android.k.d dVar, g2 g2Var, h2 h2Var, o3 o3Var, j2 j2Var) {
        int h2Var32;
        n.f(g2Var, "dogUpdateInteractor");
        n.f(h2Var, "authService");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        super();
        this.authService = g2Var;
        this.connectivityService = o3Var;
        this.dogUpdateInteractor = j2Var;
        x xVar = new x();
        f.d.a.a aVar2 = new a();
        h2Var32 = 0;
        if (dVar == null) {
        } else {
            h2Var32 = dVar.ordinal();
        }
        x xVar2 = new x(Integer.valueOf(g.b(h2Var32 - 1, h2Var32)));
        app.dogo.com.dogo_android.dogcreation.k.f.b coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 saveDogGender(f dogId) {
        return dogId.dogUpdateInteractor;
    }

    public static final /* synthetic */ g2 i(f fVar) {
        return fVar.authService;
    }

    public static final /* synthetic */ o3 j(f fVar) {
        return fVar.connectivityService;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: k, reason: from kotlin metadata */
    public final f.d.a.a<Boolean> isUserSignedIn() {
        return this.e;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> l() {
        return this.f;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> m() {
        return this.exceptionHandler;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void n(String str) {
        n.f(str, "dogId");
        kotlinx.coroutines.internal.k.d(f0.a(this), this.g, null, new kotlinx.coroutines.f.a(this, str, null), 2, null);
    }
}
