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
import i.b.b;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.u;
import kotlin.w;

/* compiled from: DogLogEditViewModel.kt */
@Metadata(d1 = "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0010\u0018\u00002\u00020\u0001BS\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0006\u0010<\u001a\u00020=J\u0008\u0010>\u001a\u00020\u0017H\u0002J\u0006\u0010?\u001a\u00020\u0017J\u0006\u0010@\u001a\u00020=J\u0008\u0010A\u001a\u00020=H\u0002J\u000e\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020\u0005J\u001e\u0010D\u001a\u00020=2\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u000305j\u0008\u0012\u0004\u0012\u00020\u0003`6J\u0016\u0010F\u001a\u00020=2\u0006\u0010G\u001a\u00020 2\u0006\u0010H\u001a\u00020 J\u0010\u0010I\u001a\u00020=2\u0006\u0010J\u001a\u00020\u0003H\u0002J\u0010\u0010K\u001a\u00020=2\u0006\u0010J\u001a\u00020\u0003H\u0002J\u0008\u0010L\u001a\u00020=H\u0002R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001b\u0010\u0019R\u001d\u0010\u001c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u001d0\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u0019R \u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020 0\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008!\u0010\u0019\"\u0004\u0008\"\u0010#R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010$\u001a\u0008\u0012\u0004\u0012\u00020\u00170%¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u0017\u0010(\u001a\u0008\u0012\u0004\u0012\u00020 0\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008)\u0010\u0019R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010*R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010+\u001a\u0008\u0012\u0004\u0012\u00020 0\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\u0019R\u0013\u0010-\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010/R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u00100\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u001d0\u0016¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u0010\u0019R\u0017\u00102\u001a\u0008\u0012\u0004\u0012\u00020\u00170%¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010'R\u001e\u00104\u001a\u0012\u0012\u0004\u0012\u00020\u000305j\u0008\u0012\u0004\u0012\u00020\u0003`6X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u00107\u001a\u0008\u0012\u0004\u0012\u00020908¢\u0006\u0008\n\u0000\u001a\u0004\u0008:\u0010;R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006M", d2 = {"Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/logedit/DogLogEditViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "logId", "", "initialEventTimeMs", "", "initialTagType", "Lapp/dogo/com/dogo_android/enums/DogLogTypes;", "dogLogRepository", "Lapp/dogo/com/dogo_android/repository/local/DogLogRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Ljava/lang/String;Ljava/lang/Long;Lapp/dogo/com/dogo_android/enums/DogLogTypes;Lapp/dogo/com/dogo_android/repository/local/DogLogRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "buttonEnabledState", "Landroidx/lifecycle/MutableLiveData;", "", "getButtonEnabledState", "()Landroidx/lifecycle/MutableLiveData;", "dateLiveData", "getDateLiveData", "deleteLogResults", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "getDeleteLogResults", "dogLogCount", "", "getDogLogCount", "setDogLogCount", "(Landroidx/lifecycle/MutableLiveData;)V", "goBackEvent", "Lcom/hadilq/liveevent/LiveEvent;", "getGoBackEvent", "()Lcom/hadilq/liveevent/LiveEvent;", "hourLiveData", "getHourLiveData", "Ljava/lang/Long;", "minuteLiveData", "getMinuteLiveData", "preselectedTagId", "getPreselectedTagId", "()Ljava/lang/String;", "saveLogResults", "getSaveLogResults", "scrollToButtonEvent", "getScrollToButtonEvent", "selectedDogLogTypes", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "types", "", "Lapp/dogo/com/dogo_android/util/recycle_views/DogLogSelection;", "getTypes", "()Ljava/util/List;", "deleteLog", "", "isLogTypeSelected", "isNewLog", "saveLog", "setInitialButtonEnableValues", "setSelectedDate", "timestampMs", "setSelectedTag", "tagTypes", "setSelectedTime", "hours", "minutes", "trackPottyLogDeleted", "logType", "trackSaveButtonPressed", "updateButtonEnabledState", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class DogLogEditViewModel extends s {

    private final String a;
    /* renamed from: b, reason: from kotlin metadata */
    private final Long connectivityService;
    private final e c;
    private final f1 d;
    private final j1 e;
    /* renamed from: f, reason: from kotlin metadata */
    private final p1 dogLogRepository;
    private final v2 g;
    private final o3 h;
    /* renamed from: i, reason: from kotlin metadata */
    private final j2 initialEventTimeMs;
    /* renamed from: j, reason: from kotlin metadata */
    private final x<Integer> initialTagType = new x<>();
    /* renamed from: k, reason: from kotlin metadata */
    private final x<Integer> logId = new x<>();
    private final x<Long> l = new x<>();
    private final x<Boolean> m = new x<>();
    /* renamed from: n, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> programRepository = new a<>();
    private final x<y<Boolean>> o = new x<>();
    private final x<y<Boolean>> p = new x<>();
    /* renamed from: q, reason: from kotlin metadata */
    private final f.d.a.a<Boolean> selectedDogLogTypes = new a<>();
    /* renamed from: r, reason: from kotlin metadata */
    private final String tracker;
    /* renamed from: s, reason: from kotlin metadata */
    private final List<i> types;
    /* renamed from: t, reason: from kotlin metadata */
    private ArrayList<String> userRepository = new ArrayList<>();
    /* renamed from: u, reason: from kotlin metadata */
    private x<Integer> utilities = new x<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            i.this.m().postValue(new LoadResult_Error(th));
            a.d(th);
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            final Boolean tRUE2 = Boolean.TRUE;
            i.this.m().postValue(new LoadResult_Success(tRUE2));
            i.this.o().postValue(tRUE2);
            i.this.setSelectedDate((String)p.X(i.this.userRepository));
        }

        b() {
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements l<Throwable, w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            i.this.s().postValue(new LoadResult_Error(th));
            a.d(th);
        }

        c() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<w> {
        @Override // kotlin.d0.d.p
        public final void invoke() {
            final Boolean tRUE2 = Boolean.TRUE;
            i.this.s().postValue(new LoadResult_Success(tRUE2));
            i.this.o().postValue(tRUE2);
            i.this.userRepository.clear();
        }

        d() {
            super(0);
        }
    }
    public i(String str, Long long, e eVar, f1 f1Var, j1 j1Var, p1 p1Var, v2 v2Var, o3 o3Var, j2 j2Var) {
        String tagId2 = null;
        n.f(f1Var, "dogLogRepository");
        n.f(j1Var, "programRepository");
        n.f(p1Var, "userRepository");
        n.f(v2Var, "utilities");
        n.f(o3Var, "tracker");
        n.f(j2Var, "connectivityService");
        super();
        this.a = str;
        this.connectivityService = long;
        this.c = eVar;
        this.d = f1Var;
        this.e = j1Var;
        this.dogLogRepository = p1Var;
        this.g = v2Var;
        this.h = o3Var;
        this.initialEventTimeMs = j2Var;
        x xVar4 = new x();
        f.d.a.a aVar = new a();
        x xVar5 = new x();
        x xVar6 = new x();
        f.d.a.a aVar2 = new a();
        if (eVar == null) {
            int i6 = 0;
        } else {
            tagId2 = eVar.getTagId();
        }
        this.tracker = tagId2;
        i[] arr = new i[9];
        int i15 = 8;
        arr[i15] = new DogLogSelection_SelectionItem(DogLogTypes.SLEEP);
        this.types = p.j(arr);
        ArrayList arrayList = new ArrayList();
        x xVar7 = new x();
        Calendar calendar = v2Var.f();
        if (long != null) {
            calendar.setTimeInMillis(long.longValue());
        }
        Integer num3 = Integer.valueOf(calendar.get(11));
        new x().setValue(num3);
        new x().setValue(Integer.valueOf(calendar.get(12)));
        new x().setValue(Long.valueOf(calendar.getTimeInMillis()));
        if (eVar != null) {
            this.userRepository.add(eVar.getTagId());
        }
        y();
    }

    /* renamed from: C, reason: from kotlin metadata */
    private final void setSelectedDate(String timestampMs) {
        this.h.logEvent(E_Calendar.d.withParameters(u.a(new EP_Type(), timestampMs)));
    }

    /* renamed from: D, reason: from kotlin metadata */
    private final void setSelectedTag(String tagTypes) {
        this.h.logEvent(E_Calendar.a.withParameters(u.a(new EP_Type(), tagTypes)));
    }

    /* renamed from: E, reason: from kotlin metadata */
    private final void deleteLog() {
        this.m.postValue(Boolean.valueOf(v()));
        this.programRepository.postValue(Boolean.valueOf(v()));
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final /* synthetic */ ArrayList trackPottyLogDeleted(i logType) {
        return logType.userRepository;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public static final /* synthetic */ void setSelectedTime(i hours, String minutes) {
        hours.setSelectedDate(minutes);
    }

    private final boolean v() {
        return !this.userRepository.isEmpty();
    }

    private final void y() {
        boolean z2 = false;
        int r0 = w() && this.v() ? 1 : 0;
        this.m.postValue(Boolean.valueOf(r0));
        this.programRepository.postValue((w() && this.v() ? 1 : 0));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    /* renamed from: A, reason: from kotlin metadata */
    public final void trackSaveButtonPressed(ArrayList<String> logType) {
        n.f(logType, "tagTypes");
        this.userRepository = logType;
        this.utilities.postValue(Integer.valueOf(logType.size()));
        deleteLog();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void B(int i, int i2) {
        this.initialTagType.setValue(Integer.valueOf(i));
        this.logId.setValue(Integer.valueOf(i2));
        deleteLog();
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void j() {
        z = this.p.getValue() instanceof LoadResult_Loading;
        if (!(this.p.getValue() instanceof oadResult_Loading)) {
            z = this.o.getValue() instanceof LoadResult_Loading;
            if (!(this.o.getValue() instanceof oadResult_Loading)) {
                this.p.postValue(LoadResult_Loading.a);
                if (!this.initialEventTimeMs.a()) {
                    this.h.setTrainingReminderUserProperties("calendar_log_edit");
                    this.p.postValue(new LoadResult_Error(new UnknownHostException()));
                } else {
                    n.d(this.a);
                    b bVar4 = this.d.c(this.dogLogRepository.H().f(), this.a).q(a.b()).y(a.b());
                    n.e(bVar4, "dogLogRepository.deleteDogLog(dogId, logId!!)\n                        .observeOn(Schedulers.io())\n                        .subscribeOn(Schedulers.io())");
                    getDisposable().b(a.d(bVar4, new app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.i.a(this), new app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.i.b(this)));
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Boolean> k() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Long> l() {
        return this.l;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> m() {
        return this.p;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> n() {
        return this.utilities;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> o() {
        return this.selectedDogLogTypes;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> p() {
        return this.initialTagType;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> q() {
        return this.logId;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String r() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<y<Boolean>> s() {
        return this.o;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Boolean> t() {
        return this.programRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final List<i> u() {
        return this.types;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final boolean w() {
        boolean z = true;
        int r0 = this.a == null ? 1 : 0;
        return (this.a == null ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void x() {
        b bVar;
        AddDogLogRequest.DogLog addDogLogRequest_DogLog;
        long timeInMillis;
        if (!!this.userRepository.isEmpty()) {
            this.o.postValue(new LoadResult_Error(new IllegalArgumentException()));
        } else {
            Object value = this.initialTagType.getValue();
            n.d(value);
            n.e(value, "hourLiveData.value!!");
            Object value4 = this.logId.getValue();
            n.d(value4);
            n.e(value4, "minuteLiveData.value!!");
            Object value5 = this.l.getValue();
            n.d(value5);
            item = "dateLiveData.value!!";
            n.e(value5, item);
            String str2 = this.dogLogRepository.H().f();
            Calendar calendar = this.g.f();
            calendar.setTimeInMillis(value5.longValue());
            int i = 11;
            calendar.set(i, value.intValue());
            calendar.set(12, value4.intValue());
            z = this.o.getValue() instanceof LoadResult_Loading;
            if (!(this.o.getValue() instanceof oadResult_Loading)) {
                z = this.p.getValue() instanceof LoadResult_Loading;
                if (!(this.p.getValue() instanceof oadResult_Loading)) {
                    ArrayList arrayList = new ArrayList(p.r(this.userRepository, 10));
                    Iterator it = this.userRepository.iterator();
                    while (it.hasNext()) {
                        arrayList.add((String)it.next());
                    }
                    setSelectedTag(arrayList.toString());
                    this.o.postValue(LoadResult_Loading.a);
                    if (!this.initialEventTimeMs.a()) {
                        this.h.setTrainingReminderUserProperties("calendar_log_edit");
                        this.o.postValue(new LoadResult_Error(new UnknownHostException()));
                    } else {
                        if (this.a != null) {
                            this.e.w();
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it2 = this.userRepository.iterator();
                            while (it2.hasNext()) {
                                arrayList2.add(new AddDogLogRequest_DogLog((String)it2.next(), calendar.getTimeInMillis(), r8));
                            }
                            bVar = this.d.l(str2, this.a, arrayList2);
                        } else {
                            this.e.w();
                            ArrayList arrayList3 = new ArrayList();
                            Iterator it3 = this.userRepository.iterator();
                            while (it3.hasNext()) {
                                arrayList3.add(new AddDogLogRequest_DogLog((String)it3.next(), calendar.getTimeInMillis(), r8));
                            }
                            bVar = this.d.a(str2, arrayList3);
                        }
                        b bVar4 = bVar.q(a.b()).y(a.b());
                        n.e(bVar4, "if (logId != null) {\n                            programRepository.invalidateCache()\n                            val logs = arrayListOf<AddDogLogRequest.DogLog>()\n                            selectedDogLogTypes.forEach {\n                                logs.add(\n                                    AddDogLogRequest.DogLog(\n                                        type = it,\n                                        eventTimeMs = calendar.timeInMillis\n                                    )\n                                )\n                            }\n                            dogLogRepository.updateDogLog(dogId, logId, logs)\n                        } else {\n                            programRepository.invalidateCache()\n                            val logs = arrayListOf<AddDogLogRequest.DogLog>()\n                            selectedDogLogTypes.forEach {\n                                logs.add(\n                                    AddDogLogRequest.DogLog(\n                                        type = it,\n                                        eventTimeMs = calendar.timeInMillis\n                                    )\n                                )\n                            }\n                            dogLogRepository.addDogLog(dogId, logs)\n                        }.observeOn(Schedulers.io())\n                            .subscribeOn(Schedulers.io())");
                        getDisposable().b(a.d(bVar4, new app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.i.c(this), new app.dogo.com.dogo_android.specialprograms.potty.calendar.logedit.i.d(this)));
                    }
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void z(long j) {
        this.l.setValue(Long.valueOf(j));
        deleteLog();
    }
}
