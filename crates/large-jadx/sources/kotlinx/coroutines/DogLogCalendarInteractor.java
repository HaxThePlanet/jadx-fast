package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.k.e;
import app.dogo.com.dogo_android.k.e.a;
import app.dogo.com.dogo_android.repository.domain.DogLog;
import app.dogo.com.dogo_android.s.b.f1;
import app.dogo.com.dogo_android.s.b.f1.b;
import app.dogo.com.dogo_android.s.b.g1;
import app.dogo.com.dogo_android.s.b.g1.a;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.u.n.p.g.a;
import i.b.a0;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: DogLogCalendarInteractor.kt */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ=\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/DogLogCalendarInteractor;", "", "dogLogRepository", "Lapp/dogo/com/dogo_android/repository/local/DogLogRepository;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "dogLogStyleRepository", "Lapp/dogo/com/dogo_android/repository/local/DogLogStyleRepository;", "dispatchers", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/DogLogRepository;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/local/DogLogStyleRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getCalendarItems", "", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "dogId", "", "forceRemote", "", "daysBeforeToday", "", "daysAfterToday", "(Ljava/lang/String;ZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCalendarItemsForCurrentDog", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e2, reason: from kotlin metadata */
public final class DogLogCalendarInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final f1 dispatchers;
    /* renamed from: b, reason: from kotlin metadata */
    private final p1 dogLogRepository;
    /* renamed from: c, reason: from kotlin metadata */
    private final v2 dogLogStyleRepository;
    /* renamed from: d, reason: from kotlin metadata */
    private final g1 userRepository;
    /* renamed from: e, reason: from kotlin metadata */
    private final h0 utilities;

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogLogCalendarInteractor$getCalendarItems$2", f = "DogLogCalendarInteractor.kt", l = {}, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super List<g.a>>, Object> {

        final /* synthetic */ int $daysAfterToday;
        final /* synthetic */ int $daysBeforeToday;
        final /* synthetic */ String $dogId;
        final /* synthetic */ boolean $forceRemote;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj;
            Object value;
            int i2 = 0;
            int cmp;
            int i3 = 5;
            boolean z = false;
            Object arrayList;
            boolean z2 = true;
            String str;
            String str2;
            long l2;
            e string;
            obj = this;
            b.d();
            if (obj.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(object);
                Object blockingGet = obj.this$0.dispatchers.e(obj.$dogId, obj.$forceRemote).blockingGet();
                Calendar calendar = obj.this$0.dogLogStyleRepository.f();
                int i8 = 11;
                i2 = 0;
                calendar.set(i8, i2);
                int i12 = 12;
                calendar.set(i12, i2);
                final int i13 = 13;
                calendar.set(i13, i2);
                calendar.setTimeInMillis(obj.this$0.dogLogStyleRepository.g());
                i3 = 5;
                calendar.add(i3, -obj.$daysBeforeToday);
                calendar.setTimeInMillis(obj.this$0.dogLogStyleRepository.g());
                calendar.add(i3, obj.$daysAfterToday);
                long timeInMillis4 = calendar.getTimeInMillis();
                ArrayList arrayList2 = new ArrayList();
                calendar.setTimeInMillis(calendar.getTimeInMillis());
                calendar.set(i8, i2);
                calendar.set(i12, i2);
                calendar.set(i13, i2);
                calendar.set(14, i2);
                long l3 = obj.this$0.dogLogStyleRepository.g();
                long timeInMillis3 = calendar.getTimeInMillis();
                while (timeInMillis3 < obj.$daysAfterToday) {
                    long timeInMillis2 = calendar.getTimeInMillis();
                    int i = 1;
                    calendar.add(i3, i);
                    long timeInMillis = calendar.getTimeInMillis();
                    n.e(blockingGet, "dogLogModels");
                    ArrayList arrayList3 = new ArrayList();
                    Iterator it2 = blockingGet.iterator();
                    while (it2.hasNext()) {
                        Object item = it2.next();
                        long l = (DogLogRepository_DogLogEntity)item.c();
                    }
                    arrayList = new ArrayList(p.r(arrayList3, 10));
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        Object item2 = it.next();
                    }
                    item2 = it.next();
                    item = it2.next();
                    l = (DogLogRepository_DogLogEntity)item.c();
                    DogLogCalendarAdapter_CalendarCellItem dogLogCalendarAdapter_CalendarCellItem = new DogLogCalendarAdapter_CalendarCellItem(z, calendar.get(i3), calendar.get(2), calendar.get(7), timeInMillis2, list, arrayList);
                    arrayList2.add(dogLogCalendarAdapter_CalendarCellItem);
                    obj = this;
                    i2 = 0;
                    i3 = 5;
                }
                return arrayList2;
            }
        }

        a(String str, boolean z, int i, int i2, d<? super e2.a> dVar) {
            this.$dogId = str;
            this.$forceRemote = z;
            this.$daysBeforeToday = i;
            this.$daysAfterToday = i2;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super List<g.a>> dVar) {
            return (kotlinx.coroutines.e2.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            kotlinx.coroutines.e2.a object2 = new kotlinx.coroutines.e2.a(e2.this, this.$dogId, this.$forceRemote, this.$daysBeforeToday, this.$daysAfterToday, dVar);
            return object2;
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogLogCalendarInteractor$getCalendarItemsForCurrentDog$2", f = "DogLogCalendarInteractor.kt", l = 102, m = "invokeSuspend")
    static final class b extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super List<? extends g.a>>, Object> {

        final /* synthetic */ boolean $forceRemote;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj2;
            Object obj3 = b.d();
            final int i4 = 1;
            if (this.label != 0 && this.label == i4) {
                q.b(object);
                return obj2;
            }
            q.b(object);
            n.e(object2, "currentDogID");
            int i = 0;
            int i2 = 0;
            int i3 = 12;
            Object obj = null;
            this.label = i4;
            return DogLogCalendarInteractor.f(e2.this, object2, this.$forceRemote, i, i2, this, i3, obj) == obj3 ? obj3 : obj2;
        }

        b(boolean z, d<? super e2.b> dVar) {
            this.$forceRemote = z;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super List<g.a>> dVar) {
            return (kotlinx.coroutines.e2.b)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.e2.b(e2.this, this.$forceRemote, dVar);
        }
    }
    public e2(f1 f1Var, p1 p1Var, v2 v2Var, g1 g1Var, h0 h0Var) {
        n.f(f1Var, "dogLogRepository");
        n.f(p1Var, "userRepository");
        n.f(v2Var, "utilities");
        n.f(g1Var, "dogLogStyleRepository");
        n.f(h0Var, "dispatchers");
        super();
        this.dispatchers = f1Var;
        this.dogLogRepository = p1Var;
        this.dogLogStyleRepository = v2Var;
        this.userRepository = g1Var;
        this.utilities = h0Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ f1 getCalendarItemsForCurrentDog(e2 forceRemote) {
        return forceRemote.dispatchers;
    }

    public static final /* synthetic */ g1 b(e2 e2Var) {
        return e2Var.userRepository;
    }

    public static final /* synthetic */ p1 c(e2 e2Var) {
        return e2Var.dogLogRepository;
    }

    public static final /* synthetic */ v2 d(e2 e2Var) {
        return e2Var.dogLogStyleRepository;
    }

    public static /* synthetic */ Object f(e2 e2Var, String str, boolean z, int i, int i2, d dVar, int i3, Object object) {
        int i42 = 90;
        int i52 = 15;
        if (i3 & 2 != 0) {
            i = 0;
        }
        if (i3 & 4 != 0) {
            i42 = 90;
        }
        if (i3 & 8 != 0) {
            i52 = 15;
        }
        return e2Var.e(str, i, i42, i52, dVar);
    }

    public final Object e(String str, boolean z, int i, int i2, d<? super List<g.a>> dVar) {
        kotlinx.coroutines.e2.a aVar = new kotlinx.coroutines.e2.a(this, str, z, i, i2, null);
        return kotlinx.coroutines.internal.k.e(this.utilities, aVar, dVar);
    }

    public final Object g(boolean z, d<? super List<g.a>> dVar) {
        return kotlinx.coroutines.internal.k.e(this.utilities, new kotlinx.coroutines.e2.b(this, z, null), dVar);
    }

    public /* synthetic */ e2(f1 f1Var, p1 p1Var, v2 v2Var, g1 g1Var, h0 h0Var, int i, g gVar) {
        h0 h0Var52;
        if (i & 16 != 0) {
            h0Var52 = Dispatchers.b();
        }
        this(f1Var, p1Var, v2Var, g1Var, h0Var52);
    }
}
