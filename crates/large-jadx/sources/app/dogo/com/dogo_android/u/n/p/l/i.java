package app.dogo.com.dogo_android.u.n.p.l;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.k.e;
import app.dogo.com.dogo_android.s.b.f1;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.n0.i;
import app.dogo.com.dogo_android.util.n0.i.a;
import app.dogo.com.dogo_android.util.n0.i.b;
import app.dogo.com.dogo_android.v.c;
import app.dogo.com.dogo_android.w.o2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r;
import app.dogo.com.dogo_android.w.u2;
import app.dogo.externalmodel.model.requests.AddDogLogRequest.DogLog;
import f.d.a.a;
import i.b.b;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.u;
import kotlin.w;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0010\u0018\u00002\u00020\u0001BS\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0006\u0010<\u001a\u00020=J\u0008\u0010>\u001a\u00020\u0017H\u0002J\u0006\u0010?\u001a\u00020\u0017J\u0006\u0010@\u001a\u00020=J\u0008\u0010A\u001a\u00020=H\u0002J\u000e\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020\u0005J\u001e\u0010D\u001a\u00020=2\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u000305j\u0008\u0012\u0004\u0012\u00020\u0003`6J\u0016\u0010F\u001a\u00020=2\u0006\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020 J\u0010\u0010I\u001a\u00020=2\u0006\u0010J\u001a\u00020\u0003H\u0002J\u0010\u0010K\u001a\u00020=2\u0006\u0010J\u001a\u00020\u0003H\u0002J\u0008\u0010L\u001a\u00020=H\u0002R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0019R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u001d0\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0019R \u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020 0\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\u0019\"\u0004\u0008\"\u0010#R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u00170%¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u0017\u0010(\u001a\u0008\u0012\u0004\u0012\u00020 0\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u0019R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\u0008\u0012\u0004\u0012\u00020 0\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u0019R\u0013\u0010-\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00100\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u001d0\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010\u0019R\u0017\u00102\u001a\u0008\u0012\u0004\u0012\u00020\u00170%¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010'R\u001e\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u000305j\u0008\u0012\u0004\u0012\u00020\u0003`6X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00107\u001a\u0008\u0012\u0004\u0012\u00020908¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010;R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogEditViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "logId", "", "initialEventTimeMs", "", "initialTagType", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "dogLogRepository", "Lapp/dogo/com/dogo_android/repository/local/DogLogRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Ljava/lang/String;Ljava/lang/Long;Lapp/dogo/com/dogo_android/enums/DogLogTypes;Lapp/dogo/com/dogo_android/repository/local/DogLogRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "buttonEnabledState", "Landroidx/lifecycle/MutableLiveData;", "", "getButtonEnabledState", "()Landroidx/lifecycle/MutableLiveData;", "dateLiveData", "getDateLiveData", "deleteLogResults", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getDeleteLogResults", "dogLogCount", "", "getDogLogCount", "setDogLogCount", "(Landroidx/lifecycle/MutableLiveData;)V", "goBackEvent", "Lcom/hadilq/liveevent/LiveEvent;", "getGoBackEvent", "()Lcom/hadilq/liveevent/LiveEvent;", "hourLiveData", "getHourLiveData", "Ljava/lang/Long;", "minuteLiveData", "getMinuteLiveData", "preselectedTagId", "getPreselectedTagId", "()Ljava/lang/String;", "saveLogResults", "getSaveLogResults", "scrollToButtonEvent", "getScrollToButtonEvent", "selectedDogLogTypes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "types", "", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection;", "getTypes", "()Ljava/util/List;", "deleteLog", "", "isLogTypeSelected", "isNewLog", "saveLog", "setInitialButtonEnableValues", "setSelectedDate", "timestampMs", "setSelectedTag", "tagTypes", "setSelectedTime", "hours", "minutes", "trackPottyLogDeleted", "logType", "trackSaveButtonPressed", "updateButtonEnabledState", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends s {

    private final String a;
    private final Long b;
    private final e c;
    private final f1 d;
    private final j1 e;
    private final p1 f;
    private final v2 g;
    private final o3 h;
    private final j2 i;
    private final x<Integer> j;
    private final x<Integer> k;
    private final x<Long> l;
    private final x<Boolean> m;
    private final a<Boolean> n;
    private final x<y<Boolean>> o;
    private final x<y<Boolean>> p;
    private final a<Boolean> q;
    private final String r;
    private final List<i> s;
    private ArrayList<String> t;
    private x<Integer> u;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.u.n.p.l.i this$0;
        a(app.dogo.com.dogo_android.u.n.p.l.i i) {
            this.this$0 = i;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar = new y.a(throwable);
            this.this$0.m().postValue(aVar);
            a.d(throwable);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final app.dogo.com.dogo_android.u.n.p.l.i this$0;
        b(app.dogo.com.dogo_android.u.n.p.l.i i) {
            this.this$0 = i;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            final Boolean tRUE = Boolean.TRUE;
            y.c cVar = new y.c(tRUE);
            this.this$0.m().postValue(cVar);
            this.this$0.o().postValue(tRUE);
            app.dogo.com.dogo_android.u.n.p.l.i this$03 = this.this$0;
            i.i(this$03, (String)p.X(i.h(this$03)));
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.u.n.p.l.i this$0;
        c(app.dogo.com.dogo_android.u.n.p.l.i i) {
            this.this$0 = i;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            invoke((Throwable)object);
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke(Throwable throwable) {
            n.f(throwable, "it");
            y.a aVar = new y.a(throwable);
            this.this$0.s().postValue(aVar);
            a.d(throwable);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements a<w> {

        final app.dogo.com.dogo_android.u.n.p.l.i this$0;
        d(app.dogo.com.dogo_android.u.n.p.l.i i) {
            this.this$0 = i;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            final Boolean tRUE = Boolean.TRUE;
            y.c cVar = new y.c(tRUE);
            this.this$0.s().postValue(cVar);
            this.this$0.o().postValue(tRUE);
            i.h(this.this$0).clear();
        }
    }
    public i(String string, Long long2, e e3, f1 f14, j1 j15, p1 p16, v2 v27, o3 o38, j2 j29) {
        Object obj2;
        Object obj3;
        String obj7;
        Object obj8;
        n.f(f14, "dogLogRepository");
        n.f(j15, "programRepository");
        n.f(p16, "userRepository");
        n.f(v27, "utilities");
        n.f(o38, "tracker");
        n.f(j29, "connectivityService");
        super();
        this.a = string;
        this.b = long2;
        this.c = e3;
        this.d = f14;
        this.e = j15;
        this.f = p16;
        this.g = v27;
        this.h = o38;
        this.i = j29;
        obj2 = new x();
        this.j = obj2;
        x obj5 = new x();
        this.k = obj5;
        x obj6 = new x();
        this.l = obj6;
        obj7 = new x();
        this.m = obj7;
        obj7 = new a();
        this.n = obj7;
        obj7 = new x();
        this.o = obj7;
        obj7 = new x();
        this.p = obj7;
        obj7 = new a();
        this.q = obj7;
        if (e3 == null) {
            obj7 = 0;
        } else {
            obj7 = e3.getTagId();
        }
        this.r = obj7;
        obj7 = new i[9];
        i.b obj10 = new i.b(e.PEE);
        obj10 = new i.b(e.POOP);
        obj10 = new i.b(e.ACCIDENT_PEE);
        obj10 = new i.b(e.ACCIDENT_POOP);
        obj10 = new i.b(e.EAT);
        obj10 = new i.b(e.DRINK);
        obj10 = new i.b(e.WALK);
        int obj9 = 8;
        obj10 = new i.b(e.SLEEP);
        obj7[obj9] = obj10;
        this.s = p.j(obj7);
        obj7 = new ArrayList();
        this.t = obj7;
        obj7 = new x();
        this.u = obj7;
        obj7 = v27.f();
        if (long2 != null) {
            obj7.setTimeInMillis(long2.longValue());
        }
        obj3 = Integer.valueOf(obj7.get(11));
        obj2.setValue(obj3);
        obj5.setValue(Integer.valueOf(obj7.get(12)));
        obj6.setValue(Long.valueOf(obj7.getTimeInMillis()));
        if (e3 == null) {
        } else {
            this.t.add(e3.getTagId());
        }
        y();
    }

    private final void C(String string) {
        o2 o2Var = new o2();
        this.h.d(r.d.d(u.a(o2Var, string)));
    }

    private final void D(String string) {
        o2 o2Var = new o2();
        this.h.d(r.a.d(u.a(o2Var, string)));
    }

    private final void E() {
        this.m.postValue(Boolean.valueOf(v()));
        this.n.postValue(Boolean.valueOf(v()));
    }

    public static final ArrayList h(app.dogo.com.dogo_android.u.n.p.l.i i) {
        return i.t;
    }

    public static final void i(app.dogo.com.dogo_android.u.n.p.l.i i, String string2) {
        i.C(string2);
    }

    private final boolean v() {
        return empty ^= 1;
    }

    private final void y() {
        boolean z;
        int i;
        if (w() && v()) {
            i = v() ? 1 : 0;
        } else {
        }
        this.m.postValue(Boolean.valueOf(i));
        this.n.postValue(Boolean.valueOf(i));
    }

    public final void A(ArrayList<String> arrayList) {
        n.f(arrayList, "tagTypes");
        this.t = arrayList;
        this.u.postValue(Integer.valueOf(arrayList.size()));
        E();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void B(int i, int i2) {
        this.j.setValue(Integer.valueOf(i));
        this.k.setValue(Integer.valueOf(i2));
        E();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j() {
        Object str;
        boolean disposable;
        Object unknownHostException;
        app.dogo.com.dogo_android.u.n.p.l.i.b bVar;
        if (!value instanceof y.b && !value2 instanceof y.b) {
            if (!value2 instanceof y.b) {
                this.p.postValue(y.b.a);
                if (!this.i.a()) {
                    this.h.s("calendar_log_edit");
                    unknownHostException = new UnknownHostException();
                    disposable = new y.a(unknownHostException);
                    this.p.postValue(disposable);
                } else {
                    String str4 = this.a;
                    n.d(str4);
                    b bVar4 = this.d.c(this.f.H().f(), str4).q(a.b()).y(a.b());
                    n.e(bVar4, "dogLogRepository.deleteDogLog(dogId, logId!!)\n                        .observeOn(Schedulers.io())\n                        .subscribeOn(Schedulers.io())");
                    unknownHostException = new i.a(this);
                    bVar = new i.b(this);
                    getDisposable().b(a.d(bVar4, unknownHostException, bVar));
                }
            }
        }
    }

    public final x<Boolean> k() {
        return this.m;
    }

    public final x<Long> l() {
        return this.l;
    }

    public final x<y<Boolean>> m() {
        return this.p;
    }

    public final x<Integer> n() {
        return this.u;
    }

    public final a<Boolean> o() {
        return this.q;
    }

    public final x<Integer> p() {
        return this.j;
    }

    public final x<Integer> q() {
        return this.k;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String r() {
        return this.r;
    }

    public final x<y<Boolean>> s() {
        return this.o;
    }

    public final a<Boolean> t() {
        return this.n;
    }

    public final List<i> u() {
        return this.s;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean w() {
        int i;
        i = this.a == null ? 1 : 0;
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        boolean disposable;
        b bVar;
        int intValue;
        int next2;
        f1 f1Var;
        int unknownHostException;
        String next;
        String dVar;
        String str;
        Calendar calendar;
        AddDogLogRequest.DogLog dogLog;
        long timeInMillis;
        if (empty ^= 1 != 0) {
            Object value = this.j.getValue();
            n.d(value);
            n.e(value, "hourLiveData.value!!");
            Object value4 = this.k.getValue();
            n.d(value4);
            n.e(value4, "minuteLiveData.value!!");
            Object value5 = this.l.getValue();
            n.d(value5);
            dVar = "dateLiveData.value!!";
            n.e(value5, dVar);
            str = this.f.H().f();
            calendar = this.g.f();
            calendar.setTimeInMillis((Number)value5.longValue());
            calendar.set(11, (Number)value.intValue());
            calendar.set(12, (Number)value4.intValue());
            if (!value2 instanceof y.b && !value3 instanceof y.b) {
                if (!value3 instanceof y.b) {
                    ArrayList list2 = this.t;
                    ArrayList arrayList = new ArrayList(p.r(list2, 10));
                    Iterator iterator = list2.iterator();
                    for (String next2 : iterator) {
                        arrayList.add(next2);
                    }
                    D(arrayList.toString());
                    this.o.postValue(y.b.a);
                    if (!this.i.a()) {
                        this.h.s("calendar_log_edit");
                        unknownHostException = new UnknownHostException();
                        intValue = new y.a(unknownHostException);
                        this.o.postValue(intValue);
                    } else {
                        if (this.a != null) {
                            this.e.w();
                            ArrayList arrayList2 = new ArrayList();
                            Iterator iterator2 = this.t.iterator();
                            for (String dVar : iterator2) {
                                dogLog = new AddDogLogRequest.DogLog(dVar, calendar.getTimeInMillis(), obj8);
                                arrayList2.add(dogLog);
                            }
                            bVar = this.d.l(str, this.a, arrayList2);
                        } else {
                            this.e.w();
                            ArrayList arrayList3 = new ArrayList();
                            Iterator iterator3 = this.t.iterator();
                            for (String dVar : iterator3) {
                                dogLog = new AddDogLogRequest.DogLog(dVar, calendar.getTimeInMillis(), obj8);
                                arrayList3.add(dogLog);
                            }
                            bVar = this.d.a(str, arrayList3);
                        }
                        b bVar4 = bVar.q(a.b()).y(a.b());
                        n.e(bVar4, "if (logId != null) {\n                            programRepository.invalidateCache()\n                            val logs = arrayListOf<AddDogLogRequest.DogLog>()\n                            selectedDogLogTypes.forEach {\n                                logs.add(\n                                    AddDogLogRequest.DogLog(\n                                        type = it,\n                                        eventTimeMs = calendar.timeInMillis\n                                    )\n                                )\n                            }\n                            dogLogRepository.updateDogLog(dogId, logId, logs)\n                        } else {\n                            programRepository.invalidateCache()\n                            val logs = arrayListOf<AddDogLogRequest.DogLog>()\n                            selectedDogLogTypes.forEach {\n                                logs.add(\n                                    AddDogLogRequest.DogLog(\n                                        type = it,\n                                        eventTimeMs = calendar.timeInMillis\n                                    )\n                                )\n                            }\n                            dogLogRepository.addDogLog(dogId, logs)\n                        }.observeOn(Schedulers.io())\n                            .subscribeOn(Schedulers.io())");
                        unknownHostException = new i.c(this);
                        dVar = new i.d(this);
                        getDisposable().b(a.d(bVar4, unknownHostException, dVar));
                    }
                }
            }
        } else {
            unknownHostException = new IllegalArgumentException();
            intValue = new y.a(unknownHostException);
            this.o.postValue(intValue);
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z(long l) {
        this.l.setValue(Long.valueOf(l));
        E();
    }
}
