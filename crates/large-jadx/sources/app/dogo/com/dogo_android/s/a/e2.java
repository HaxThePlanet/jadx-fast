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
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ=\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00132\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u00152\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J!\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e2\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/DogLogCalendarInteractor;", "", "dogLogRepository", "Lapp/dogo/com/dogo_android/repository/local/DogLogRepository;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "utilities", "Lapp/dogo/com/dogo_android/service/Utilities;", "dogLogStyleRepository", "Lapp/dogo/com/dogo_android/repository/local/DogLogStyleRepository;", "dispatchers", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/DogLogRepository;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/repository/local/DogLogStyleRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getCalendarItems", "", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "dogId", "", "forceRemote", "", "daysBeforeToday", "", "daysAfterToday", "(Ljava/lang/String;ZIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCalendarItemsForCurrentDog", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e2 {

    private final f1 a;
    private final p1 b;
    private final v2 c;
    private final g1 d;
    private final h0 e;

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogLogCalendarInteractor$getCalendarItems$2", f = "DogLogCalendarInteractor.kt", l = {}, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super List<g.a>>, Object> {

        final int $daysAfterToday;
        final int $daysBeforeToday;
        final String $dogId;
        final boolean $forceRemote;
        int label;
        final app.dogo.com.dogo_android.s.a.e2 this$0;
        a(app.dogo.com.dogo_android.s.a.e2 e2, String string2, boolean z3, int i4, int i5, d<? super app.dogo.com.dogo_android.s.a.e2.a> d6) {
            this.this$0 = e2;
            this.$dogId = string2;
            this.$forceRemote = z3;
            this.$daysBeforeToday = i4;
            this.$daysAfterToday = i5;
            super(2, d6);
        }

        public final Object c(m0 m0, d<? super List<g.a>> d2) {
            return (e2.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            super(this.this$0, this.$dogId, this.$forceRemote, this.$daysBeforeToday, this.$daysAfterToday, d2);
            return obj8;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj3;
            Object obj2;
            v2 arrayList;
            int i6;
            int i3;
            int cmp;
            int i2;
            long timeInMillis;
            g.a aVar;
            int i4;
            int next;
            int i5;
            int i8;
            int i;
            long timeInMillis2;
            v2 booleanValue;
            boolean next2;
            int i7;
            long cmp3;
            String str;
            int cmp2;
            long l;
            e eVar;
            Object obj;
            obj3 = this;
            b.d();
            if (obj3.label != 0) {
            } else {
                q.b(object);
                Object blockingGet = e2.a(obj3.this$0).e(obj3.$dogId, obj3.$forceRemote).blockingGet();
                Calendar calendar = e2.d(obj3.this$0).f();
                int i9 = 11;
                i3 = 0;
                calendar.set(i9, i3);
                int i13 = 12;
                calendar.set(i13, i3);
                final int i14 = 13;
                calendar.set(i14, i3);
                calendar.setTimeInMillis(e2.d(obj3.this$0).g());
                i2 = 5;
                calendar.add(i2, -$daysBeforeToday);
                calendar.setTimeInMillis(e2.d(obj3.this$0).g());
                calendar.add(i2, obj3.$daysAfterToday);
                ArrayList arrayList2 = new ArrayList();
                calendar.setTimeInMillis(calendar.getTimeInMillis());
                calendar.set(i9, i3);
                calendar.set(i13, i3);
                calendar.set(i14, i3);
                calendar.set(14, i3);
                long l2 = e2.d(obj3.this$0).g();
                while (Long.compare(timeInMillis3, timeInMillis4) < 0) {
                    timeInMillis2 = calendar.getTimeInMillis();
                    calendar.add(i2, 1);
                    timeInMillis = calendar.getTimeInMillis();
                    n.e((List)blockingGet, "dogLogModels");
                    ArrayList arrayList3 = new ArrayList();
                    Iterator iterator2 = blockingGet.iterator();
                    while (iterator2.hasNext()) {
                        Object next3 = iterator2.next();
                        cmp3 = (f1.b)next3.c();
                        if (Long.compare(timeInMillis2, cmp3) <= 0 && Long.compare(cmp3, timeInMillis) < 0) {
                        } else {
                        }
                        i7 = i3;
                        if (b.a(i7).booleanValue()) {
                        }
                        i6 = 1;
                        arrayList3.add(next3);
                        if (Long.compare(cmp3, timeInMillis) < 0) {
                        } else {
                        }
                        i7 = 1;
                    }
                    arrayList = new ArrayList(p.r(arrayList3, 10));
                    Iterator iterator = arrayList3.iterator();
                    while (iterator.hasNext()) {
                        next = iterator.next();
                        if ((DogLog.LogStyle)e2.b(obj3.this$0).b().get(next.b()) == null) {
                        }
                        super((f1.b)next.d(), next.a(), next.c(), obj25, e.Companion.a(next.b()), obj2);
                        arrayList.add(dogLog);
                        obj3 = this;
                        i3 = 0;
                        i2 = 5;
                        obj2 = g1.Companion.a();
                    }
                    if (Long.compare(timeInMillis2, l2) <= 0 && Long.compare(l2, timeInMillis) < 0) {
                    } else {
                    }
                    i4 = 0;
                    super(i4, calendar.get(i2), calendar.get(2), calendar.get(7), timeInMillis2, obj20, arrayList);
                    arrayList2.add(aVar2);
                    obj3 = this;
                    i3 = 0;
                    i2 = 5;
                    if (Long.compare(l2, timeInMillis) < 0) {
                    } else {
                    }
                    i4 = 1;
                    next = iterator.next();
                    if ((DogLog.LogStyle)map.get(next.b()) == null) {
                    }
                    super((f1.b)next.d(), next.a(), next.c(), obj25, e.Companion.a(next.b()), obj2);
                    arrayList.add(dogLog);
                    obj3 = this;
                    i3 = 0;
                    i2 = 5;
                    obj2 = g1.Companion.a();
                    next3 = iterator2.next();
                    cmp3 = (f1.b)next3.c();
                    if (Long.compare(timeInMillis2, cmp3) <= 0 && Long.compare(cmp3, timeInMillis) < 0) {
                    } else {
                    }
                    i7 = i3;
                    if (b.a(i7).booleanValue()) {
                    }
                    i6 = 1;
                    arrayList3.add(next3);
                    if (Long.compare(cmp3, timeInMillis) < 0) {
                    } else {
                    }
                    i7 = 1;
                }
                return arrayList2;
            }
            IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw illegalStateException;
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "Lapp/dogo/com/dogo_android/specialprograms/potty/calendar/DogLogCalendarAdapter$CalendarCellItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.DogLogCalendarInteractor$getCalendarItemsForCurrentDog$2", f = "DogLogCalendarInteractor.kt", l = 102, m = "invokeSuspend")
    static final class b extends k implements p<m0, d<? super List<? extends g.a>>, Object> {

        final boolean $forceRemote;
        int label;
        final app.dogo.com.dogo_android.s.a.e2 this$0;
        b(app.dogo.com.dogo_android.s.a.e2 e2, boolean z2, d<? super app.dogo.com.dogo_android.s.a.e2.b> d3) {
            this.this$0 = e2;
            this.$forceRemote = z2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super List<g.a>> d2) {
            return (e2.b)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            e2.b obj3 = new e2.b(this.this$0, this.$forceRemote, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            app.dogo.com.dogo_android.s.a.e2 this$0;
            Object obj;
            boolean $forceRemote;
            int i4;
            int i;
            Object obj2;
            int i3;
            int i2;
            Object obj12;
            Object obj3 = b.d();
            final int label = this.label;
            final int i5 = 1;
            if (label != 0) {
                if (label != i5) {
                } else {
                    q.b(object);
                    return obj12;
                }
                obj12 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj12;
            }
            q.b(object);
            obj = obj12;
            n.e((String)obj, "currentDogID");
            this.label = i5;
            if (e2.f(this.this$0, obj, this.$forceRemote, 0, 0, this, 12, 0) == obj3) {
                return obj3;
            }
        }
    }
    public e2(f1 f1, p1 p12, v2 v23, g1 g14, h0 h05) {
        n.f(f1, "dogLogRepository");
        n.f(p12, "userRepository");
        n.f(v23, "utilities");
        n.f(g14, "dogLogStyleRepository");
        n.f(h05, "dispatchers");
        super();
        this.a = f1;
        this.b = p12;
        this.c = v23;
        this.d = g14;
        this.e = h05;
    }

    public e2(f1 f1, p1 p12, v2 v23, g1 g14, h0 h05, int i6, g g7) {
        h0 obj11;
        if (i6 &= 16 != 0) {
            obj11 = c1.b();
        }
        super(f1, p12, v23, g14, obj11);
    }

    public static final f1 a(app.dogo.com.dogo_android.s.a.e2 e2) {
        return e2.a;
    }

    public static final g1 b(app.dogo.com.dogo_android.s.a.e2 e2) {
        return e2.d;
    }

    public static final p1 c(app.dogo.com.dogo_android.s.a.e2 e2) {
        return e2.b;
    }

    public static final v2 d(app.dogo.com.dogo_android.s.a.e2 e2) {
        return e2.c;
    }

    public static Object f(app.dogo.com.dogo_android.s.a.e2 e2, String string2, boolean z3, int i4, int i5, d d6, int i7, Object object8) {
        int obj8;
        int obj9;
        int obj10;
        if (i7 & 2 != 0) {
            obj8 = 0;
        }
        if (i7 & 4 != 0) {
            obj9 = 90;
        }
        if (i7 & 8 != 0) {
            obj10 = 15;
        }
        return e2.e(string2, obj8, obj9, obj10, d6);
    }

    public final Object e(String string, boolean z2, int i3, int i4, d<? super List<g.a>> d5) {
        super(this, string, z2, i3, i4, 0);
        return k.e(this.e, aVar2, d5);
    }

    public final Object g(boolean z, d<? super List<g.a>> d2) {
        e2.b bVar = new e2.b(this, z, 0);
        return k.e(this.e, bVar, d2);
    }
}
