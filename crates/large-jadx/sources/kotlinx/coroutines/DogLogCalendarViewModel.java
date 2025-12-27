package app.dogo.com.dogo_android.u.n.p;

import androidx.lifecycle.f0;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.e;
import app.dogo.com.dogo_android.s.a.e2;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.h1;
import app.dogo.com.dogo_android.util.n0.i.b;
import app.dogo.com.dogo_android.w.h0;
import app.dogo.com.dogo_android.w.o3;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.g;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.x0;

/* compiled from: DogLogCalendarViewModel.kt */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\t\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010&\u001a\u00020\u0017J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\u0008\u0010)\u001a\u00020%H\u0016J\u0016\u0010*\u001a\u00020\u00172\u000c\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0006\u0010,\u001a\u00020\u0017J\u0008\u0010-\u001a\u00020%H\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\u0008\u0012\u0004\u0012\u00020!0\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#¨\u0006.", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "Lapp/dogo/com/dogo_android/util/extensionfunction/CalendarToolTipCallbacks;", "dogLogCalendarInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogLogCalendarInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/repository/interactor/DogLogCalendarInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "results", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "getResults", "()Landroidx/lifecycle/MutableLiveData;", "shouldNavigateToReminders", "Lcom/hadilq/liveevent/LiveEvent;", "", "getShouldNavigateToReminders", "()Lcom/hadilq/liveevent/LiveEvent;", "source", "", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "types", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection$SelectionItem;", "getTypes", "()Ljava/util/List;", "loadData", "", "forceRemote", "loadRemoteData", "retry", "setCalendarIntroductionAsCompleted", "shouldRedirectToReminders", "items", "shouldShowCalendarIntroductionTooltip", "trackTooltipDoneClicked", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: j, reason: from kotlin metadata */
public final class DogLogCalendarViewModel extends s implements h1 {

    /* renamed from: a, reason: from kotlin metadata */
    private final e2 connectivityService;
    /* renamed from: b, reason: from kotlin metadata */
    private final o3 dogLogCalendarInteractor;
    /* renamed from: c, reason: from kotlin metadata */
    private final j2 exceptionHandler;
    /* renamed from: v, reason: from kotlin metadata */
    private final p2 preferenceService;
    private final f.d.a.a<Boolean> w = new a<>();
    private final x<y<List<g.a>>> x = new x<>();
    private final List<i.b> y;
    /* renamed from: z, reason: from kotlin metadata */
    private final CoroutineExceptionHandler tracker = new j$b();

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends kotlin.b0.a implements CoroutineExceptionHandler {

        final /* synthetic */ j a;
        public b(CoroutineExceptionHandler.a exc, j jVar) {
            this.a = jVar;
            super(exc);
        }

        @Override // kotlin.b0.a
        public void handleException(g context, Throwable exception) {
            this.a.m().postValue(new LoadResult_Error(exception));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.potty.calendar.DogLogCalendarViewModel$loadData$1", f = "DogLogCalendarViewModel.kt", l = {55, 59}, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super w>, Object> {

        final /* synthetic */ boolean $forceRemote;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label2;
            int i = 1000;
            Object obj;
            Object obj3 = b.d();
            final int i2 = 2;
            final int i3 = 1;
            if (this.label != 0) {
                if (this.label != i3) {
                    if (this.label != i2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(object);
                        j.this.preferenceService.z1();
                        j.this.n().postValue(b.a(true));
                    }
                }
                q.b(object);
                j.this.m().postValue(new LoadResult_Success(obj));
                if (j.this.t(obj)) {
                    i = 1000;
                    this.label = i2;
                    if (kotlinx.coroutines.internal.x0.a(i, this) == obj3) {
                        return obj3;
                    }
                }
            } else {
                q.b(object);
                j.this.m().postValue(LoadResult_Loading.a);
                if (j.this.exceptionHandler.a()) {
                    this.label = i3;
                    if (j.this.connectivityService.g(this.$forceRemote, this) == obj3) {
                        return obj3;
                    }
                } else {
                    j.this.dogLogCalendarInteractor.setTrainingReminderUserProperties("calendar");
                    j.this.m().postValue(new LoadResult_Error(new UnknownHostException()));
                }
            }
            return w.a;
        }

        a(boolean z, d<? super j.a> dVar) {
            this.$forceRemote = z;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super w> dVar) {
            return (kotlinx.coroutines.j.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.j.a(j.this, this.$forceRemote, dVar);
        }
    }
    public j(e2 e2Var, o3 o3Var, j2 j2Var, p2 p2Var) {
        n.f(e2Var, "dogLogCalendarInteractor");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        n.f(p2Var, "preferenceService");
        super();
        this.connectivityService = e2Var;
        this.dogLogCalendarInteractor = o3Var;
        this.exceptionHandler = j2Var;
        this.preferenceService = p2Var;
        f.d.a.a aVar = new a();
        x xVar = new x();
        i.b[] arr = new i.b[8];
        this.y = p.j(new i.b[] { new DogLogSelection_SelectionItem(DogLogTypes.PEE), new DogLogSelection_SelectionItem(DogLogTypes.POOP), new DogLogSelection_SelectionItem(DogLogTypes.ACCIDENT_PEE), new DogLogSelection_SelectionItem(DogLogTypes.ACCIDENT_POOP), new DogLogSelection_SelectionItem(DogLogTypes.EAT), new DogLogSelection_SelectionItem(DogLogTypes.DRINK), new DogLogSelection_SelectionItem(DogLogTypes.WALK), new DogLogSelection_SelectionItem(DogLogTypes.SLEEP) });
        app.dogo.com.dogo_android.u.n.p.j.b coroutineExceptionHandlerKt_CoroutineExceptionHandler_1 = new CoroutineExceptionHandlerKt_CoroutineExceptionHandler_1(kotlinx.coroutines.internal.CoroutineExceptionHandler.r, this);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ j2 loadData(j forceRemote) {
        return forceRemote.exceptionHandler;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ e2 shouldRedirectToReminders(j items) {
        return items.connectivityService;
    }

    public static final /* synthetic */ p2 j(j jVar) {
        return jVar.preferenceService;
    }

    public static final /* synthetic */ o3 k(j jVar) {
        return jVar.dogLogCalendarInteractor;
    }

    public static final /* synthetic */ boolean l(j jVar, List list) {
        return jVar.t(list);
    }

    public static /* synthetic */ void q(j jVar, boolean z, int i, Object object) {
        if (i & 1 != 0) {
            i = 0;
        }
        jVar.p(z);
    }

    private final boolean t(List<g.a> list) {
        boolean z = false;
        int size;
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            p.y(arrayList, (DogLogCalendarAdapter_CalendarCellItem)it.next().e());
        }
        if (arrayList.size() == 1) {
            if (this.preferenceService.D1()) {
                int i2 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: a, reason: from kotlin metadata */
    public void loadRemoteData() {
        this.preferenceService.x0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public void d() {
        this.dogLogCalendarInteractor.logEvent(E_PottyProgram.b);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<List<g.a>>> m() {
        return this.x;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> n() {
        return this.w;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final List<i.b> o() {
        return this.y;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p(boolean z) {
        final d dVar = null;
        kotlinx.coroutines.internal.k.d(f0.a(this), this.tracker, dVar, new kotlinx.coroutines.j.a(this, z, dVar), 2, null);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r() {
        p(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean u() {
        return !this.preferenceService.j();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s(String str) {
        n.f(str, "<set-?>");
    }
}
