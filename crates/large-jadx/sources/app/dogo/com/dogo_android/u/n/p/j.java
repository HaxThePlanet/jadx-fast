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
import f.d.a.a;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import kotlin.y.p;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineExceptionHandler.a;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import kotlinx.coroutines.x0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\t\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010$\u001a\u00020%2\u0008\u0008\u0002\u0010&\u001a\u00020\u0017J\u0006\u0010'\u001a\u00020%J\u0006\u0010(\u001a\u00020%J\u0008\u0010)\u001a\u00020%H\u0016J\u0016\u0010*\u001a\u00020\u00172\u000c\u0010+\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u0011H\u0002J\u0006\u0010,\u001a\u00020\u0017J\u0008\u0010-\u001a\u00020%H\u0016R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00120\u00110\u00100\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001c\u0010\u001d\"\u0004\u0008\u001e\u0010\u001fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\u0008\u0012\u0004\u0012\u00020!0\u0011¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#¨\u0006.", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "Lapp/dogo/com/dogo_android/util/extensionfunction/CalendarToolTipCallbacks;", "dogLogCalendarInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/DogLogCalendarInteractor;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "(Lapp/dogo/com/dogo_android/repository/interactor/DogLogCalendarInteractor;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;Lapp/dogo/com/dogo_android/service/PreferenceService;)V", "exceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "results", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "getResults", "()Landroidx/lifecycle/MutableLiveData;", "shouldNavigateToReminders", "Lcom/hadilq/liveevent/LiveEvent;", "", "getShouldNavigateToReminders", "()Lcom/hadilq/liveevent/LiveEvent;", "source", "", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "types", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection$SelectionItem;", "getTypes", "()Ljava/util/List;", "loadData", "", "forceRemote", "loadRemoteData", "retry", "setCalendarIntroductionAsCompleted", "shouldRedirectToReminders", "items", "shouldShowCalendarIntroductionTooltip", "trackTooltipDoneClicked", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class j extends s implements h1 {

    private final e2 a;
    private final o3 b;
    private final j2 c;
    private final p2 v;
    private final a<Boolean> w;
    private final x<y<List<app.dogo.com.dogo_android.u.n.p.g.a>>> x;
    private final List<i.b> y;
    private final CoroutineExceptionHandler z;

    @Metadata(d1 = "\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\t¸\u0006\u0000", d2 = {"kotlinx/coroutines/CoroutineExceptionHandlerKt$CoroutineExceptionHandler$1", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "handleException", "", "context", "Lkotlin/coroutines/CoroutineContext;", "exception", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends a implements CoroutineExceptionHandler {

        final app.dogo.com.dogo_android.u.n.p.j a;
        public b(CoroutineExceptionHandler.a coroutineExceptionHandler$a, app.dogo.com.dogo_android.u.n.p.j j2) {
            this.a = j2;
            super(a);
        }

        @Override // kotlin.b0.a
        public void handleException(g g, Throwable throwable2) {
            y.a aVar = new y.a(throwable2);
            this.a.m().postValue(aVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.specialprograms.potty.calendar.DogLogCalendarViewModel$loadData$1", f = "DogLogCalendarViewModel.kt", l = {55, 59}, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super w>, Object> {

        final boolean $forceRemote;
        int label;
        final app.dogo.com.dogo_android.u.n.p.j this$0;
        a(app.dogo.com.dogo_android.u.n.p.j j, boolean z2, d<? super app.dogo.com.dogo_android.u.n.p.j.a> d3) {
            this.this$0 = j;
            this.$forceRemote = z2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (j.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            j.a obj3 = new j.a(this.this$0, this.$forceRemote, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object aVar;
            UnknownHostException unknownHostException;
            y.c cVar;
            x obj7;
            aVar = b.d();
            unknownHostException = this.label;
            final int i = 2;
            final int i2 = 1;
            if (unknownHostException != null) {
                if (unknownHostException != i2) {
                    if (unknownHostException != i) {
                    } else {
                        q.b(object);
                        j.j(this.this$0).z1();
                        this.this$0.n().postValue(b.a(i2));
                    }
                    obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj7;
                }
                q.b(object);
                cVar = new y.c((List)obj7);
                this.this$0.m().postValue(cVar);
                this.label = i;
                if (j.l(this.this$0, obj7) && x0.a(1000, obj5) == aVar) {
                    this.label = i;
                    if (x0.a(1000, obj5) == aVar) {
                        return aVar;
                    }
                }
            } else {
                q.b(object);
                this.this$0.m().postValue(y.b.a);
                if (!j.h(this.this$0).a()) {
                    j.k(this.this$0).s("calendar");
                    unknownHostException = new UnknownHostException();
                    aVar = new y.a(unknownHostException);
                    this.this$0.m().postValue(aVar);
                } else {
                    this.label = i2;
                    if (j.i(this.this$0).g(this.$forceRemote, this) == aVar) {
                        return aVar;
                    }
                }
            }
            return w.a;
        }
    }
    public j(e2 e2, o3 o32, j2 j23, p2 p24) {
        n.f(e2, "dogLogCalendarInteractor");
        n.f(o32, "tracker");
        n.f(j23, "connectivityService");
        n.f(p24, "preferenceService");
        super();
        this.a = e2;
        this.b = o32;
        this.c = j23;
        this.v = p24;
        a obj2 = new a();
        this.w = obj2;
        obj2 = new x();
        this.x = obj2;
        obj2 = new i.b[8];
        i.b obj3 = new i.b(e.PEE);
        obj3 = new i.b(e.POOP);
        obj3 = new i.b(e.ACCIDENT_PEE);
        obj3 = new i.b(e.ACCIDENT_POOP);
        obj3 = new i.b(e.EAT);
        obj3 = new i.b(e.DRINK);
        obj3 = new i.b(e.WALK);
        obj3 = new i.b(e.SLEEP);
        this.y = p.j(obj3, obj3, obj3, obj3, obj3, obj3, obj3, obj3);
        obj3 = new j.b(CoroutineExceptionHandler.r, this);
        this.z = obj3;
    }

    public static final j2 h(app.dogo.com.dogo_android.u.n.p.j j) {
        return j.c;
    }

    public static final e2 i(app.dogo.com.dogo_android.u.n.p.j j) {
        return j.a;
    }

    public static final p2 j(app.dogo.com.dogo_android.u.n.p.j j) {
        return j.v;
    }

    public static final o3 k(app.dogo.com.dogo_android.u.n.p.j j) {
        return j.b;
    }

    public static final boolean l(app.dogo.com.dogo_android.u.n.p.j j, List list2) {
        return j.t(list2);
    }

    public static void q(app.dogo.com.dogo_android.u.n.p.j j, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        j.p(obj1);
    }

    private final boolean t(List<app.dogo.com.dogo_android.u.n.p.g.a> list) {
        int i;
        List list2;
        int obj3;
        ArrayList arrayList = new ArrayList();
        obj3 = list.iterator();
        for (g.a next2 : obj3) {
            p.y(arrayList, next2.e());
        }
        if (arrayList.size() == 1 && !this.v.D1()) {
            if (!this.v.D1()) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public void a() {
        this.v.x0(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public void d() {
        this.b.c(h0.b);
    }

    public final x<y<List<app.dogo.com.dogo_android.u.n.p.g.a>>> m() {
        return this.x;
    }

    public final a<Boolean> n() {
        return this.w;
    }

    public final List<i.b> o() {
        return this.y;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void p(boolean z) {
        final int i = 0;
        j.a aVar = new j.a(this, z, i);
        k.d(f0.a(this), this.z, i, aVar, 2, 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void r() {
        p(true);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void s(String string) {
        n.f(string, "<set-?>");
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean u() {
        return z ^= 1;
    }
}
