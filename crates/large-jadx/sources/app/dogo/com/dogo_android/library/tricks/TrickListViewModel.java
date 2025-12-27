package app.dogo.com.dogo_android.n.m;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.f0;
import androidx.lifecycle.v;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory;
import app.dogo.com.dogo_android.repository.domain.TrickListData;
import app.dogo.com.dogo_android.s.a.l3;
import app.dogo.com.dogo_android.s.a.q2;
import app.dogo.com.dogo_android.s.a.r3;
import app.dogo.com.dogo_android.s.b.h1;
import app.dogo.com.dogo_android.s.b.k1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.j2;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.util.e0.s;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.y.b;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.w.d0;
import app.dogo.com.dogo_android.w.n2;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u2;
import i.b.a0;
import i.b.b;
import i.b.g0;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: TrickListViewModel.kt */
@Metadata(d1 = "\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0008\u0010<\u001a\u00020\u0005H\u0002J\u0010\u0010=\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000104H\u0002J\u000e\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005J\u0006\u0010@\u001a\u00020AJ\u000e\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020\u0005J\u0010\u0010D\u001a\u00020A2\u0006\u0010E\u001a\u00020FH\u0002R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020!0 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u001d\u0010)\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010(R\u0019\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010(R\u0017\u0010-\u001a\u0008\u0012\u0004\u0012\u00020\u00050 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010#R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010/\u001a\u0008\u0012\u0004\u0012\u0002000\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R\u001d\u00103\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u000205040%¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u0010(R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00108R\u001d\u00109\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020:040%¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010(R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickListViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "category", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "trickTag", "", "getLibraryTrickListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;", "predefinedContentRepository", "Lapp/dogo/com/dogo_android/repository/local/PredefinedContentRepository;", "shouldShowWorkoutUnlockedInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/ShouldShowWorkoutUnlockedInteractor;", "workoutSessionInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "dogLocalEntityDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;Lapp/dogo/com/dogo_android/repository/local/PredefinedContentRepository;Lapp/dogo/com/dogo_android/repository/interactor/ShouldShowWorkoutUnlockedInteractor;Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "getCategory", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "onError", "Lcom/hadilq/liveevent/LiveEvent;", "", "getOnError", "()Lcom/hadilq/liveevent/LiveEvent;", "rateUsPopUp", "Landroidx/lifecycle/LiveData;", "Lapp/dogo/com/dogo_android/service/RateItService$RateSource;", "getRateUsPopUp", "()Landroidx/lifecycle/LiveData;", "result", "getResult", "sharePopUp", "getSharePopUp", "shouldShowWorkoutUnlocked", "getShouldShowWorkoutUnlocked", "tagSelection", "", "getTagSelection", "()Landroidx/lifecycle/MutableLiveData;", "tags", "", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "getTags", "getTrickTag", "()Ljava/lang/String;", "tricks", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "getTricks", "getActiveTagId", "getFilteredTricks", "getWorkoutUnlockSourceBlocking", "dogId", "loadList", "", "trackTrickTapped", "trickId", "triggerWorkoutUnlockIfNeeded", "trickListData", "Lapp/dogo/com/dogo_android/repository/domain/TrickListData;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: r, reason: from kotlin metadata */
public final class TrickListViewModel extends s {

    /* renamed from: a, reason: from kotlin metadata */
    private final TrickItem.TrickCategory category;
    /* renamed from: b, reason: from kotlin metadata */
    private final String connectivityService;
    /* renamed from: c, reason: from kotlin metadata */
    private final q2 dogLocalEntityDao;
    /* renamed from: d, reason: from kotlin metadata */
    private final h1 getLibraryTrickListInteractor;
    private final l3 e;
    /* renamed from: f, reason: from kotlin metadata */
    private final r3 predefinedContentRepository;
    /* renamed from: g, reason: from kotlin metadata */
    private final p1 rateRepository;
    private final o3 h;
    private final k1 i;
    private final e.a.a.a.b.b.w j;
    private final j2 k;
    /* renamed from: l, reason: from kotlin metadata */
    private final x<y<LibrarySection>> shouldShowWorkoutUnlockedInteractor = new x<>();
    private final LiveData<y<LibrarySection>> m = new x<>();
    private final f.d.a.a<String> n = new a<>();
    /* renamed from: o, reason: from kotlin metadata */
    private final x<Integer> tracker = new x<>();
    private final LiveData<q2.a> p;
    /* renamed from: q, reason: from kotlin metadata */
    private final LiveData<q2.a> tricks;
    /* renamed from: r, reason: from kotlin metadata */
    private final f.d.a.a<Throwable> userRepository = new a<>();
    /* renamed from: s, reason: from kotlin metadata */
    private final LiveData<List<LibraryTag>> workoutSessionInteractor = new v<>();
    private final LiveData<List<TrickItem>> t = new v<>();

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends kotlin.d0.d.p implements kotlin.d0.c.l<Throwable, kotlin.w> {
        @Override // kotlin.d0.d.p
        public final void invoke(Throwable th) {
            n.f(th, "it");
            r.this.m().postValue(th);
            r.this.shouldShowWorkoutUnlockedInteractor.postValue(new LoadResult_Error(th));
        }

        a() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/TrickListData;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends kotlin.d0.d.p implements kotlin.d0.c.l<TrickListData, kotlin.w> {
        @Override // kotlin.d0.d.p
        public final void a(TrickListData list) {
            final LibrarySection section = list.getSection();
            n.d(section);
            r.this.shouldShowWorkoutUnlockedInteractor.postValue(new LoadResult_Success(section));
            n.e(list, "it");
            r.this.triggerWorkoutUnlockIfNeeded(list);
        }

        b() {
            super(1);
        }
    }
    public r(TrickItem.TrickCategory trickCategory, String str, q2 q2Var, h1 h1Var, l3 l3Var, r3 r3Var, p1 p1Var, o3 o3Var, k1 k1Var, e.a.a.a.b.b.w wVar, j2 j2Var) {
        n.f(trickCategory, "category");
        n.f(q2Var, "getLibraryTrickListInteractor");
        n.f(h1Var, "predefinedContentRepository");
        n.f(l3Var, "shouldShowWorkoutUnlockedInteractor");
        n.f(r3Var, "workoutSessionInteractor");
        n.f(p1Var, "userRepository");
        n.f(o3Var, "tracker");
        n.f(k1Var, "rateRepository");
        n.f(wVar, "dogLocalEntityDao");
        n.f(j2Var, "connectivityService");
        super();
        this.category = trickCategory;
        this.connectivityService = str;
        this.dogLocalEntityDao = q2Var;
        this.getLibraryTrickListInteractor = h1Var;
        this.e = l3Var;
        this.predefinedContentRepository = r3Var;
        this.rateRepository = p1Var;
        this.h = o3Var;
        this.i = k1Var;
        this.j = wVar;
        this.k = j2Var;
        x xVar = new x();
        f.d.a.a aVar = new a();
        x xVar2 = new x();
        this.p = k1Var.a();
        this.tricks = k1Var.b();
        f.d.a.a aVar2 = new a();
        v vVar = new v();
        vVar.b(getResult(), new app.dogo.com.dogo_android.library.tricks.m(this, vVar));
        v vVar2 = new v();
        vVar2.b(q(), new app.dogo.com.dogo_android.library.tricks.f(this, vVar2));
        vVar2.b(getResult(), new app.dogo.com.dogo_android.library.tricks.h(this, vVar2));
    }

    private static final g0 D(r rVar, LibrarySection librarySection) {
        n.f(rVar, "this$0");
        n.f(librarySection, "trickSection");
        return rVar.rateRepository.v().flatMap(new app.dogo.com.dogo_android.library.tricks.g(rVar, librarySection));
    }

    private static final g0 E(r rVar, LibrarySection librarySection, String str) {
        n.f(rVar, "this$0");
        n.f(librarySection, "$trickSection");
        n.f(str, "dogId");
        return rVar.predefinedContentRepository.O().s(app.dogo.com.dogo_android.library.tricks.i.a).d(rVar.e.d().onErrorReturn(app.dogo.com.dogo_android.library.tricks.k.a).map(new app.dogo.com.dogo_android.library.tricks.l(str, librarySection)));
    }

    /* renamed from: F, reason: from kotlin metadata */
    private static final boolean getWorkoutUnlockSourceBlocking(Throwable dogId) {
        n.f(dogId, "it");
        a.d(dogId);
        return true;
    }

    /* renamed from: G, reason: from kotlin metadata */
    private static final Boolean trackTrickTapped(Throwable trickId) {
        n.f(trickId, "it");
        a.d(trickId);
        return Boolean.FALSE;
    }

    private static final TrickListData H(String str, LibrarySection librarySection, Boolean boolean) {
        n.f(str, "$dogId");
        n.f(librarySection, "$trickSection");
        n.f(boolean, "it");
        TrickListData trickListData = new TrickListData(str, librarySection, null, boolean.booleanValue(), 4, null);
        return trickListData;
    }

    private static final void I(r rVar, v vVar, y yVar) {
        int i = 0;
        n.f(rVar, "this$0");
        n.f(vVar, "$this_apply");
        yVar = yVar instanceof LoadResult_Success ? (oadResult_Success)yVar : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                vVar.postValue(p.t0(p.b(rVar.getLibraryTrickListInteractor.a()), component1.getTags()));
            }
        }
    }

    private static final void K(r rVar, v vVar, Integer integer) {
        n.f(rVar, "this$0");
        n.f(vVar, "$this_apply");
        vVar.postValue(rVar.l());
    }

    private static final void L(r rVar, v vVar, y yVar) {
        n.f(rVar, "this$0");
        n.f(vVar, "$this_apply");
        vVar.postValue(rVar.l());
    }

    /* renamed from: M, reason: from kotlin metadata */
    private final void triggerWorkoutUnlockIfNeeded(TrickListData trickListData) {
        if (trickListData.getShouldShowWorkoutUnlocked()) {
            this.n.postValue(trickListData.getDogId());
        }
    }

    public static final /* synthetic */ x h(r rVar) {
        return rVar.shouldShowWorkoutUnlockedInteractor;
    }

    public static final /* synthetic */ void i(r rVar, TrickListData list) {
        rVar.triggerWorkoutUnlockIfNeeded(list);
    }

    /* renamed from: j, reason: from kotlin metadata */
    private final String getActiveTagId() {
        Object value;
        String str;
        if ((Integer)this.tracker.getValue() == null) {
            Integer num = 0;
        }
        Object value2 = this.workoutSessionInteractor.getValue();
        str = "id_all";
        if (value2 != null) {
            Object obj = p.a0(value2, value.intValue());
            if (obj != null) {
                str = obj.getId();
                if (str != null) {
                }
            }
        }
        return str;
    }

    private final List<TrickItem> l() {
        Object value;
        int i;
        boolean hasNext;
        Iterator it;
        boolean hasNext2;
        int i2;
        i = 0;
        LoadResult_Success r0 = this.m.getValue() instanceof LoadResult_Success ? (oadResult_Success)this.m.getValue() : i;
        if (this.m == null) {
            return null;
        }
        String activeTagId = getActiveTagId();
        if (!n.b(activeTagId, "id_all")) {
            List tricks = value.getTricks();
            if (tricks != null) {
                Iterator it2 = tricks.iterator();
                while (it2.hasNext()) {
                    Object item = it2.next();
                    List tags = (TrickItem)item.getTags();
                    hasNext2 = tags instanceof Collection;
                    i2 = 0;
                }
            }
            if (i == 0) {
                List list = p.g();
            } else {
            }
        } else {
            if (value.getTricks() == null) {
                List list2 = p.g();
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void C() {
        this.shouldShowWorkoutUnlockedInteractor.postValue(LoadResult_Loading.a);
        if (!this.k.a()) {
            this.h.setTrainingReminderUserProperties("good_example_video");
            this.userRepository.postValue(new UnknownHostException());
            this.shouldShowWorkoutUnlockedInteractor.postValue(new LoadResult_Error(new UnknownHostException()));
        } else {
            a0 observable2 = this.dogLocalEntityDao.i(this.category, this.connectivityService, f0.a(this)).flatMap(new app.dogo.com.dogo_android.library.tricks.j(this)).subscribeOn(a.b()).observeOn(a.b());
            n.e(observable2, "getLibraryTrickListInteractor.getSectionDataSingle(category, trickTag, viewModelScope)\n                    .flatMap { trickSection ->\n                        userRepository.getCurrentDogIdSingle().flatMap { dogId ->\n                            workoutSessionInteractor.updateWorkoutCacheIfUnlockedAndUnlockScreenNotYetShown()\n                                .onErrorComplete {\n                                    Timber.e(it)\n                                    true\n                                }.andThen(\n                                    shouldShowWorkoutUnlockedInteractor.shouldShowWorkoutUnlocked().onErrorReturn {\n                                        Timber.e(it)\n                                        false\n                                    }.map {\n                                        TrickListData(dogId = dogId, section = trickSection, shouldShowWorkoutUnlocked = it)\n                                    }\n                                )\n                        }\n                    }\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(Schedulers.io())");
            getDisposable().b(a.g(observable2, new app.dogo.com.dogo_android.library.tricks.r.a(this), new app.dogo.com.dogo_android.library.tricks.r.b(this)));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void J(String str) {
        n.f(str, "trickId");
        this.h.logEvent(E_Library.d.c(new EP_TrickId(), str));
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<y<LibrarySection>> getResult() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final TrickItem.TrickCategory k() {
        return this.category;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<Throwable> m() {
        return this.userRepository;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<q2.a> n() {
        return this.p;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<q2.a> o() {
        return this.tricks;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final f.d.a.a<String> p() {
        return this.n;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final x<Integer> q() {
        return this.tracker;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<List<LibraryTag>> r() {
        return this.workoutSessionInteractor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final LiveData<List<TrickItem>> s() {
        return this.t;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String t(String str) {
        Object blockingGet;
        n.f(str, "dogId");
        blockingGet = this.j.getDogLocalEntityOrEmpty(str).blockingGet();
        n.e(blockingGet, "source");
        if (!l.z(blockingGet) == 0) {
            String str4 = "dashboard";
        }
        return blockingGet;
    }

    public static /* synthetic */ TrickListData A(String str, LibrarySection librarySection, Boolean boolean) {
        return TrickListViewModel.H(str, librarySection, boolean);
    }

    public static /* synthetic */ void B(r rVar, v vVar, y yVar) {
        TrickListViewModel.I(rVar, vVar, yVar);
    }

    public static /* synthetic */ void u(r rVar, v vVar, Integer integer) {
        TrickListViewModel.K(rVar, vVar, integer);
    }

    public static /* synthetic */ g0 v(r rVar, LibrarySection librarySection, String str) {
        return TrickListViewModel.E(rVar, librarySection, str);
    }

    public static /* synthetic */ void w(r rVar, v vVar, y yVar) {
        TrickListViewModel.L(rVar, vVar, yVar);
    }

    public static /* synthetic */ boolean x(Throwable th) {
        return TrickListViewModel.getWorkoutUnlockSourceBlocking(th);
    }

    public static /* synthetic */ g0 y(r rVar, LibrarySection librarySection) {
        return TrickListViewModel.D(rVar, librarySection);
    }

    public static /* synthetic */ Boolean z(Throwable th) {
        return TrickListViewModel.trackTrickTapped(th);
    }
}
