package app.dogo.com.dogo_android.q.p;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.s.a.g2;
import app.dogo.com.dogo_android.service.h2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.o3;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
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

/* compiled from: DogPreviewBirthdayViewModel.kt */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010(\u001a\u00020)J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020)J\u0006\u0010,\u001a\u00020\u001cJ\u000e\u0010-\u001a\u00020.2\u0006\u0010+\u001a\u00020)R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR \u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008 \u0010\u0015\"\u0004\u0008!\u0010\u0017R\u001d\u0010\"\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0#0\u0012¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u0015R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010%\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008&\u0010\u0015\"\u0004\u0008'\u0010\u0017¨\u0006/", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewBirthdayViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "dogUpdateInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;", "authService", "Lapp/dogo/com/dogo_android/service/AuthService;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/DogProfile;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/interactor/DogUpdateInteractor;Lapp/dogo/com/dogo_android/service/AuthService;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "cal", "Ljava/util/Calendar;", "dayField", "Landroidx/lifecycle/MutableLiveData;", "", "getDayField", "()Landroidx/lifecycle/MutableLiveData;", "setDayField", "(Landroidx/lifecycle/MutableLiveData;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "goToNextScreen", "Lcom/hadilq/liveevent/LiveEvent;", "", "getGoToNextScreen", "()Lcom/hadilq/liveevent/LiveEvent;", "monthField", "getMonthField", "setMonthField", "saveState", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getSaveState", "yearField", "getYearField", "setYearField", "getCurrentlySelectedTimeInMillis", "", "isBirthdayValid", "unixMillis", "isUserSignedIn", "saveBirthday", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: r, reason: from kotlin metadata */
public final class DogPreviewBirthdayViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final DogProfile authService;
    /* renamed from: b, reason: from kotlin metadata */
    private final v2 connectivityService;
    private final g2 c;
    /* renamed from: d, reason: from kotlin metadata */
    private final h2 dogProfile;
    /* renamed from: e, reason: from kotlin metadata */
    private final o3 dogUpdateInteractor;
    /* renamed from: f, reason: from kotlin metadata */
    private final j2 exceptionHandler;
    private final x<y<Boolean>> g = new x<>();
    private final f.d.a.a<Boolean> h = new a<>();
    private x<Integer> i = new x<>();
    /* renamed from: j, reason: from kotlin metadata */
    private x<Integer> tracker = new x<>();
    /* renamed from: k, reason: from kotlin metadata */
    private x<Integer> utilities = new x<>();
    private final Calendar l;
    private final CoroutineExceptionHandler m = new r$b();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ r a;
        public b(CoroutineExceptionHandler.a exc, r rVar) {
            this.a = rVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.p().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.profile.dogprofile.DogPreviewBirthdayViewModel$saveBirthday$1", f = "DogPreviewBirthdayViewModel.kt", l = 53, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, d<? super w>, Object> {

        final /* synthetic */ long $unixMillis;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            g2 g2Var;
            String str;
            String format;
            Boolean bool3 = null;
            d dVar;
            int i = 4;
            Object obj = null;
            Object obj3 = b.d();
            final int i2 = 1;
            if (this.label != 0) {
                if (this.label != i2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    r.this.p().postValue(new LoadResult_Success(b.a(true)));
                    r.this.n().postValue(b.a(true));
                    return w.a;
                }
            }
            q.b(object);
            r.this.p().postValue(LoadResult_Loading.a);
            if (r.this.exceptionHandler.getActiveNetworkType()) {
                bool3 = null;
                i = 4;
                obj = null;
                this.label = i2;
                if (DogUpdateInteractor.f(r.this.c, r.this.authService.getId(), new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(b.d(this.$unixMillis)), bool3, this, i, obj) == obj3) {
                    return obj3;
                }
            } else {
                r.this.dogUpdateInteractor.setTrainingReminderUserProperties("dog_preview_birthday");
                r.this.p().postValue(new LoadResult_Error(new UnknownHostException()));
            }
        }

        a(long j, d<? super r.a> dVar) {
            this.$unixMillis = j;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (app.dogo.com.dogo_android.profile.dogprofile.r.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new app.dogo.com.dogo_android.profile.dogprofile.r.a(r.this, this.$unixMillis, r2, dVar);
        }
    }
    public r(DogProfile dogProfile, v2 v2Var, g2 g2Var, h2 h2Var, o3 o3Var, j2 j2Var) {
        n.f(dogProfile, "dogProfile");
        n.f(v2Var, "utilities");
        n.f(g2Var, "dogUpdateInteractor");
        n.f(h2Var, "authService");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        super();
        this.authService = dogProfile;
        this.connectivityService = v2Var;
        this.c = g2Var;
        this.dogProfile = h2Var;
        this.dogUpdateInteractor = o3Var;
        this.exceptionHandler = j2Var;
        x xVar2 = new x();
        f.d.a.a aVar = new a();
        x xVar3 = new x();
        x xVar4 = new x();
        x xVar5 = new x();
        Calendar calendar = v2Var.f();
        this.l = calendar;
        app.dogo.com.dogo_android.q.p.r.b coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
        if (dogProfile.getBirthday() != null) {
            calendar.setTime(new Date(dogProfile.getBirthday().longValue(), o3Var));
        }
        this.utilities.setValue(Integer.valueOf(calendar.get(1)));
        this.tracker.setValue(Integer.valueOf(calendar.get(2)));
        this.i.setValue(Integer.valueOf(calendar.get(5)));
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 isBirthdayValid(r unixMillis) {
        return unixMillis.exceptionHandler;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ DogProfile saveBirthday(r unixMillis) {
        return unixMillis.authService;
    }

    public static final /* synthetic */ g2 j(r rVar) {
        return rVar.c;
    }

    public static final /* synthetic */ o3 k(r rVar) {
        return rVar.dogUpdateInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean isUserSignedIn() {
        return this.dogProfile.D();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: l, reason: from kotlin metadata */
    public final long getCurrentlySelectedTimeInMillis() {
        Object value;
        Object value2;
        Object value3;
        Integer num = 0;
        if ((Integer)this.utilities.getValue() == null) {
        }
        if ((Integer)this.tracker.getValue() == null) {
        }
        value2 = this.i.getValue();
        if (value2 != null) {
        }
        this.l.set(value.intValue(), value3.intValue(), value2.intValue());
        return this.l.getTime().getTime();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> m() {
        return this.i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> n() {
        return this.h;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> o() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> p() {
        return this.g;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> q() {
        return this.utilities;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean r(long j) {
        boolean z = true;
        long l = this.connectivityService.g();
        j = l > j ? 1 : 0;
        return (l > j ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s(long j) {
        final kotlinx.coroutines.o0 o0Var = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.m, o0Var, new app.dogo.com.dogo_android.profile.dogprofile.r.a(this, j, r8, o0Var), 2, null);
    }
}
