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
import e.a.a.a.b.b.w;
import f.d.a.a;
import i.b.a0;
import i.b.b;
import i.b.g0;
import i.b.j0.a;
import i.b.r0.a;
import i.b.s0.a;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.l;
import kotlin.w;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J\u0008\u0010<\u001a\u00020\u0005H\u0002J\u0010\u0010=\u001a\n\u0012\u0004\u0012\u00020:\u0018\u000104H\u0002J\u000e\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u0005J\u0006\u0010@\u001a\u00020AJ\u000e\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020\u0005J\u0010\u0010D\u001a\u00020A2\u0006\u0010E\u001a\u00020FH\u0002R\u001a\u0010\u0019\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\u001eR\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020!0 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010(R\u001d\u0010)\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u001b0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010(R\u0019\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010&0%¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010(R\u0017\u0010-\u001a\u0008\u0012\u0004\u0012\u00020\u00050 ¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010#R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010/\u001a\u0008\u0012\u0004\u0012\u0002000\u001a¢\u0006\u0008\n\u0000\u001a\u0004\u00081\u00102R\u001d\u00103\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u000205040%¢\u0006\u0008\n\u0000\u001a\u0004\u00086\u0010(R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u00108R\u001d\u00109\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020:040%¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010(R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006G", d2 = {"Lapp/dogo/com/dogo_android/library/tricks/TrickListViewModel;", "Lapp/dogo/com/dogo_android/util/base_classes/DisposableViewModel;", "category", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "trickTag", "", "getLibraryTrickListInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;", "predefinedContentRepository", "Lapp/dogo/com/dogo_android/repository/local/PredefinedContentRepository;", "shouldShowWorkoutUnlockedInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/ShouldShowWorkoutUnlockedInteractor;", "workoutSessionInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "rateRepository", "Lapp/dogo/com/dogo_android/repository/local/RateRepository;", "dogLocalEntityDao", "Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;", "connectivityService", "Lapp/dogo/com/dogo_android/service/ConnectivityService;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;Lapp/dogo/com/dogo_android/repository/local/PredefinedContentRepository;Lapp/dogo/com/dogo_android/repository/interactor/ShouldShowWorkoutUnlockedInteractor;Lapp/dogo/com/dogo_android/repository/interactor/WorkoutSessionInteractor;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/tracking/Tracker;Lapp/dogo/com/dogo_android/repository/local/RateRepository;Lapp/dogo/android/persistencedb/room/dao/DogLocalEntityDao;Lapp/dogo/com/dogo_android/service/ConnectivityService;)V", "_result", "Landroidx/lifecycle/MutableLiveData;", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "getCategory", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "onError", "Lcom/hadilq/liveevent/LiveEvent;", "", "getOnError", "()Lcom/hadilq/liveevent/LiveEvent;", "rateUsPopUp", "Landroidx/lifecycle/LiveData;", "Lapp/dogo/com/dogo_android/service/RateItService$RateSource;", "getRateUsPopUp", "()Landroidx/lifecycle/LiveData;", "result", "getResult", "sharePopUp", "getSharePopUp", "shouldShowWorkoutUnlocked", "getShouldShowWorkoutUnlocked", "tagSelection", "", "getTagSelection", "()Landroidx/lifecycle/MutableLiveData;", "tags", "", "Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "getTags", "getTrickTag", "()Ljava/lang/String;", "tricks", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "getTricks", "getActiveTagId", "getFilteredTricks", "getWorkoutUnlockSourceBlocking", "dogId", "loadList", "", "trackTrickTapped", "trickId", "triggerWorkoutUnlockIfNeeded", "trickListData", "Lapp/dogo/com/dogo_android/repository/domain/TrickListData;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class r extends s {

    private final TrickItem.TrickCategory a;
    private final String b;
    private final q2 c;
    private final h1 d;
    private final l3 e;
    private final r3 f;
    private final p1 g;
    private final o3 h;
    private final k1 i;
    private final w j;
    private final j2 k;
    private final x<y<LibrarySection>> l;
    private final LiveData<y<LibrarySection>> m;
    private final a<String> n;
    private final x<Integer> o;
    private final LiveData<q2.a> p;
    private final LiveData<q2.a> q;
    private final a<Throwable> r;
    private final LiveData<List<LibraryTag>> s;
    private final LiveData<List<TrickItem>> t;

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class a extends p implements l<Throwable, w> {

        final app.dogo.com.dogo_android.n.m.r this$0;
        a(app.dogo.com.dogo_android.n.m.r r) {
            this.this$0 = r;
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
            this.this$0.m().postValue(throwable);
            y.a aVar2 = new y.a(throwable);
            r.h(this.this$0).postValue(aVar2);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n", d2 = {"<anonymous>", "", "it", "Lapp/dogo/com/dogo_android/repository/domain/TrickListData;", "kotlin.jvm.PlatformType"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements l<TrickListData, w> {

        final app.dogo.com.dogo_android.n.m.r this$0;
        b(app.dogo.com.dogo_android.n.m.r r) {
            this.this$0 = r;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(TrickListData trickListData) {
            final LibrarySection section = trickListData.getSection();
            n.d(section);
            y.c cVar = new y.c(section);
            r.h(this.this$0).postValue(cVar);
            n.e(trickListData, "it");
            r.i(this.this$0, trickListData);
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((TrickListData)object);
            return w.a;
        }
    }
    public r(TrickItem.TrickCategory trickItem$TrickCategory, String string2, q2 q23, h1 h14, l3 l35, r3 r36, p1 p17, o3 o38, k1 k19, w w10, j2 j211) {
        n.f(trickCategory, "category");
        n.f(q23, "getLibraryTrickListInteractor");
        n.f(h14, "predefinedContentRepository");
        n.f(l35, "shouldShowWorkoutUnlockedInteractor");
        n.f(r36, "workoutSessionInteractor");
        n.f(p17, "userRepository");
        n.f(o38, "tracker");
        n.f(k19, "rateRepository");
        n.f(w10, "dogLocalEntityDao");
        n.f(j211, "connectivityService");
        super();
        this.a = trickCategory;
        this.b = string2;
        this.c = q23;
        this.d = h14;
        this.e = l35;
        this.f = r36;
        this.g = p17;
        this.h = o38;
        this.i = k19;
        this.j = w10;
        this.k = j211;
        x obj2 = new x();
        this.l = obj2;
        this.m = obj2;
        obj2 = new a();
        this.n = obj2;
        obj2 = new x();
        this.o = obj2;
        this.p = k19.a();
        this.q = k19.b();
        obj2 = new a();
        this.r = obj2;
        obj2 = new v();
        m obj4 = new m(this, obj2);
        obj2.b(getResult(), obj4);
        w obj3 = w.a;
        this.s = obj2;
        obj2 = new v();
        obj4 = new f(this, obj2);
        obj2.b(q(), obj4);
        obj4 = new h(this, obj2);
        obj2.b(getResult(), obj4);
        this.t = obj2;
    }

    public static TrickListData A(String string, LibrarySection librarySection2, Boolean boolean3) {
        return r.H(string, librarySection2, boolean3);
    }

    public static void B(app.dogo.com.dogo_android.n.m.r r, v v2, y y3) {
        r.I(r, v2, y3);
    }

    private static final g0 D(app.dogo.com.dogo_android.n.m.r r, LibrarySection librarySection2) {
        n.f(r, "this$0");
        n.f(librarySection2, "trickSection");
        g gVar = new g(r, librarySection2);
        return r.g.v().flatMap(gVar);
    }

    private static final g0 E(app.dogo.com.dogo_android.n.m.r r, LibrarySection librarySection2, String string3) {
        n.f(r, "this$0");
        n.f(librarySection2, "$trickSection");
        n.f(string3, "dogId");
        l lVar = new l(string3, librarySection2);
        return r.f.O().s(i.a).d(r.e.d().onErrorReturn(k.a).map(lVar));
    }

    private static final boolean F(Throwable throwable) {
        n.f(throwable, "it");
        a.d(throwable);
        return 1;
    }

    private static final Boolean G(Throwable throwable) {
        n.f(throwable, "it");
        a.d(throwable);
        return Boolean.FALSE;
    }

    private static final TrickListData H(String string, LibrarySection librarySection2, Boolean boolean3) {
        n.f(string, "$dogId");
        n.f(librarySection2, "$trickSection");
        n.f(boolean3, "it");
        super(string, librarySection2, 0, boolean3.booleanValue(), 4, 0);
        return trickListData;
    }

    private static final void I(app.dogo.com.dogo_android.n.m.r r, v v2, y y3) {
        Object obj1;
        int obj3;
        n.f(r, "this$0");
        n.f(v2, "$this_apply");
        if (y3 instanceof y.c) {
        } else {
            obj3 = 0;
        }
        if (obj3 == null) {
        } else {
            obj3 = obj3.a();
            if ((LibrarySection)obj3 == null) {
            } else {
                v2.postValue(p.t0(p.b(r.d.a()), (LibrarySection)obj3.getTags()));
            }
        }
    }

    private static final void K(app.dogo.com.dogo_android.n.m.r r, v v2, Integer integer3) {
        n.f(r, "this$0");
        n.f(v2, "$this_apply");
        v2.postValue(r.l());
    }

    private static final void L(app.dogo.com.dogo_android.n.m.r r, v v2, y y3) {
        n.f(r, "this$0");
        n.f(v2, "$this_apply");
        v2.postValue(r.l());
    }

    private final void M(TrickListData trickListData) {
        boolean shouldShowWorkoutUnlocked;
        String obj2;
        if (trickListData.getShouldShowWorkoutUnlocked()) {
            this.n.postValue(trickListData.getDogId());
        }
    }

    public static final x h(app.dogo.com.dogo_android.n.m.r r) {
        return r.l;
    }

    public static final void i(app.dogo.com.dogo_android.n.m.r r, TrickListData trickListData2) {
        r.M(trickListData2);
    }

    private final String j() {
        Object valueOf;
        int intValue;
        String str;
        if ((Integer)this.o.getValue() == null) {
            valueOf = 0;
        }
        Object value = this.s.getValue();
        str = "id_all";
        if ((List)value == null) {
        } else {
            intValue = p.a0((List)value, valueOf.intValue());
            if ((LibraryTag)intValue == null) {
            } else {
                intValue = (LibraryTag)intValue.getId();
                if (intValue == null) {
                } else {
                    str = intValue;
                }
            }
        }
        return str;
    }

    private final List<TrickItem> l() {
        Object value;
        int tricks;
        Object iterator2;
        int arrayList;
        boolean next;
        Iterator iterator;
        boolean empty;
        int i;
        arrayList = 0;
        if (value instanceof y.c) {
        } else {
            value = arrayList;
        }
        if (value == null) {
            return arrayList;
        } else {
            value = value.a();
            if ((LibrarySection)value == null) {
            }
        }
        String str = j();
        if (n.b(str, "id_all")) {
            if ((LibrarySection)value.getTricks() == null) {
                tricks = p.g();
            }
        } else {
            iterator2 = value.getTricks();
            if (iterator2 == null) {
            } else {
                arrayList = new ArrayList();
                iterator2 = iterator2.iterator();
                while (iterator2.hasNext()) {
                    next = iterator2.next();
                    iterator = (TrickItem)next.getTags();
                    i = 0;
                    if (iterator instanceof Collection != null && iterator.isEmpty()) {
                    } else {
                    }
                    iterator = iterator.iterator();
                    while (iterator.hasNext()) {
                        if (n.b((LibraryTag)iterator.next().getId(), str)) {
                            break loop_18;
                        } else {
                        }
                    }
                    if (i != 0) {
                    }
                    arrayList.add(next);
                    if (n.b((LibraryTag)iterator.next().getId(), str)) {
                    } else {
                    }
                    i = 1;
                    if (iterator.isEmpty()) {
                    } else {
                    }
                }
            }
            if (arrayList == null) {
                tricks = p.g();
            } else {
                tricks = arrayList;
            }
        }
        return tricks;
    }

    public static void u(app.dogo.com.dogo_android.n.m.r r, v v2, Integer integer3) {
        r.K(r, v2, integer3);
    }

    public static g0 v(app.dogo.com.dogo_android.n.m.r r, LibrarySection librarySection2, String string3) {
        return r.E(r, librarySection2, string3);
    }

    public static void w(app.dogo.com.dogo_android.n.m.r r, v v2, y y3) {
        r.L(r, v2, y3);
    }

    public static boolean x(Throwable throwable) {
        return r.F(throwable);
    }

    public static g0 y(app.dogo.com.dogo_android.n.m.r r, LibrarySection librarySection2) {
        return r.D(r, librarySection2);
    }

    public static Boolean z(Throwable throwable) {
        return r.G(throwable);
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void C() {
        Object disposable;
        Object aVar;
        Object unknownHostException;
        app.dogo.com.dogo_android.n.m.r.b bVar;
        kotlinx.coroutines.m0 m0Var;
        this.l.postValue(y.b.a);
        if (!this.k.a()) {
            this.h.s("good_example_video");
            UnknownHostException unknownHostException2 = new UnknownHostException();
            this.r.postValue(unknownHostException2);
            unknownHostException = new UnknownHostException();
            aVar = new y.a(unknownHostException);
            this.l.postValue(aVar);
        } else {
            j jVar = new j(this);
            a0 observeOn = this.c.i(this.a, this.b, f0.a(this)).flatMap(jVar).subscribeOn(a.b()).observeOn(a.b());
            n.e(observeOn, "getLibraryTrickListInteractor.getSectionDataSingle(category, trickTag, viewModelScope)\n                    .flatMap { trickSection ->\n                        userRepository.getCurrentDogIdSingle().flatMap { dogId ->\n                            workoutSessionInteractor.updateWorkoutCacheIfUnlockedAndUnlockScreenNotYetShown()\n                                .onErrorComplete {\n                                    Timber.e(it)\n                                    true\n                                }.andThen(\n                                    shouldShowWorkoutUnlockedInteractor.shouldShowWorkoutUnlocked().onErrorReturn {\n                                        Timber.e(it)\n                                        false\n                                    }.map {\n                                        TrickListData(dogId = dogId, section = trickSection, shouldShowWorkoutUnlocked = it)\n                                    }\n                                )\n                        }\n                    }\n                    .subscribeOn(Schedulers.io())\n                    .observeOn(Schedulers.io())");
            unknownHostException = new r.a(this);
            bVar = new r.b(this);
            getDisposable().b(a.g(observeOn, unknownHostException, bVar));
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final void J(String string) {
        n.f(string, "trickId");
        n2 n2Var = new n2();
        this.h.d(d0.d.c(n2Var, string));
    }

    public final LiveData<y<LibrarySection>> getResult() {
        return this.m;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final TrickItem.TrickCategory k() {
        return this.a;
    }

    public final a<Throwable> m() {
        return this.r;
    }

    public final LiveData<q2.a> n() {
        return this.p;
    }

    public final LiveData<q2.a> o() {
        return this.q;
    }

    public final a<String> p() {
        return this.n;
    }

    public final x<Integer> q() {
        return this.o;
    }

    public final LiveData<List<LibraryTag>> r() {
        return this.s;
    }

    public final LiveData<List<TrickItem>> s() {
        return this.t;
    }

    @Override // app.dogo.com.dogo_android.util.e0.s
    public final String t(String string) {
        Object obj2;
        n.f(string, "dogId");
        obj2 = this.j.g(string).blockingGet();
        n.e((String)obj2, "source");
        if (z ^= 1 != 0) {
        } else {
            obj2 = "dashboard";
        }
        return obj2;
    }
}
