package app.dogo.com.dogo_android.s.b;

import app.dogo.android.persistencedb.room.entity.ProgramEntity;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.h0.m1;
import e.a.a.a.b.b.e0;
import e.a.a.a.b.d.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ%\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u000e2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J%\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u000e2\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000eH\u0002J\u0019\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\nH\u0002R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;", "", "programDao", "Lapp/dogo/android/persistencedb/room/dao/ProgramEntityDao;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lapp/dogo/android/persistencedb/room/dao/ProgramEntityDao;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "contentLocale", "", "getContentLocale", "()Ljava/lang/String;", "fetchAllExistingProgramIds", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllClassicPrograms", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "startedProgramIds", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPrograms", "startedClassicProgramIds", "getOverrideProgramId", "programId", "getProgram", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isProgramWhitelisted", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i1 {

    private final e0 a;
    private final p2 b;
    private final r2 c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramContentRepository", f = "ProgramContentRepository.kt", l = 33, m = "fetchAllExistingProgramIds")
    static final class a extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.i1 this$0;
        a(app.dogo.com.dogo_android.s.b.i1 i1, d<? super app.dogo.com.dogo_android.s.b.i1.a> d2) {
            this.this$0 = i1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.b(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramContentRepository", f = "ProgramContentRepository.kt", l = 16, m = "getAllClassicPrograms")
    static final class b extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.i1 this$0;
        b(app.dogo.com.dogo_android.s.b.i1 i1, d<? super app.dogo.com.dogo_android.s.b.i1.b> d2) {
            this.this$0 = i1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.c(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramContentRepository", f = "ProgramContentRepository.kt", l = 20, m = "getAllPrograms")
    static final class c extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.i1 this$0;
        c(app.dogo.com.dogo_android.s.b.i1 i1, d<? super app.dogo.com.dogo_android.s.b.i1.c> d2) {
            this.this$0 = i1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return i1.a(this.this$0, 0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramContentRepository", f = "ProgramContentRepository.kt", l = 29, m = "getProgram")
    static final class d extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.i1 this$0;
        d(app.dogo.com.dogo_android.s.b.i1 i1, d<? super app.dogo.com.dogo_android.s.b.i1.d> d2) {
            this.this$0 = i1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.g(0, this);
        }
    }
    public i1(e0 e0, p2 p22, r2 r23) {
        n.f(e0, "programDao");
        n.f(p22, "preferenceService");
        n.f(r23, "remoteConfigService");
        super();
        this.a = e0;
        this.b = p22;
        this.c = r23;
    }

    public static final Object a(app.dogo.com.dogo_android.s.b.i1 i1, List list2, d d3) {
        return i1.d(list2, d3);
    }

    private final Object d(List<String> list, d<? super List<ProgramModel>> d2) {
        boolean cVar;
        Object next2;
        int i;
        int label2;
        int i2;
        int label;
        Iterator booleanValue2;
        int i4;
        int next;
        boolean booleanValue;
        int programId;
        int i3;
        Object obj6;
        Object obj7;
        cVar = d2;
        label2 = cVar.label;
        i2 = Integer.MIN_VALUE;
        if (d2 instanceof i1.c && label2 & i2 != 0) {
            cVar = d2;
            label2 = cVar.label;
            i2 = Integer.MIN_VALUE;
            if (label2 & i2 != 0) {
                cVar.label = label2 -= i2;
            } else {
                cVar = new i1.c(this, d2);
            }
        } else {
        }
        obj7 = cVar.result;
        Object obj = b.d();
        label = cVar.label;
        next = 1;
        if (label != 0) {
            if (label != next) {
            } else {
                obj6 = cVar.L$1;
                next2 = cVar.L$0;
                q.b(obj7);
                ArrayList arrayList = new ArrayList();
                Iterator iterator2 = (List)obj7.iterator();
                while (iterator2.hasNext()) {
                    next = iterator2.next();
                    if (b.a(next2.h((e)next.b().getProgramId())).booleanValue()) {
                    }
                    arrayList.add(next);
                }
                int i5 = 10;
                ArrayList arrayList3 = new ArrayList(p.r(arrayList, i5));
                Iterator iterator = arrayList.iterator();
                for (e next10 : iterator) {
                    arrayList3.add(next10.b().getProgramId());
                }
                ArrayList arrayList2 = new ArrayList(p.r(arrayList3, i5));
                booleanValue2 = arrayList3.iterator();
                for (String next9 : booleanValue2) {
                    arrayList2.add(next2.f(next9, obj6));
                }
                obj6 = new ArrayList();
                obj7 = obj7.iterator();
                while (obj7.hasNext()) {
                    next2 = obj7.next();
                    if (b.a(arrayList2.contains((e)next2.b().getProgramId())).booleanValue() != null) {
                    }
                    obj6.add(next2);
                }
                obj7 = new ArrayList(p.r(obj6, i5));
                obj6 = obj6.iterator();
                for (e next5 : obj6) {
                    obj7.add(m1.y(next5));
                }
                return obj7;
            }
            obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj6;
        }
        q.b(obj7);
        cVar.L$0 = this;
        cVar.L$1 = list;
        cVar.label = next;
        if (this.a.m(e(), cVar) == obj) {
            return obj;
        }
        next2 = this;
    }

    private final String e() {
        return n2.a.a(this.b.W());
    }

    private final String f(String string, List<String> list2) {
        Object value;
        boolean key;
        Object obj5;
        boolean obj6;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator iterator = this.c.N().entrySet().iterator();
        while (iterator.hasNext()) {
            value = iterator.next();
            if (n.b((Map.Entry)value.getValue(), string)) {
            }
            linkedHashMap.put(value.getKey(), value.getValue());
        }
        Object obj = p.Y(linkedHashMap.keySet());
        if (obj != null && list2.contains((String)obj)) {
            if (list2.contains(obj)) {
                obj5 = obj;
            }
        }
        return obj5;
    }

    private final boolean h(String string) {
        return this.c.M().contains(string);
    }

    public final Object b(d<? super List<String>> d) {
        boolean aVar;
        int label2;
        int programId;
        int i2;
        int label;
        int i;
        Object obj5;
        aVar = d;
        label2 = aVar.label;
        i2 = Integer.MIN_VALUE;
        if (d instanceof i1.a && label2 & i2 != 0) {
            aVar = d;
            label2 = aVar.label;
            i2 = Integer.MIN_VALUE;
            if (label2 & i2 != 0) {
                aVar.label = label2 -= i2;
            } else {
                aVar = new i1.a(this, d);
            }
        } else {
        }
        obj5 = aVar.result;
        Object obj = b.d();
        label = aVar.label;
        int i4 = 1;
        if (label != 0) {
            if (label != i4) {
            } else {
                q.b(obj5);
                ArrayList arrayList = new ArrayList(p.r((Iterable)obj5, 10));
                obj5 = obj5.iterator();
                for (e next2 : obj5) {
                    arrayList.add(next2.b().getProgramId());
                }
                return arrayList;
            }
            obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj5);
        aVar.label = i4;
        if (this.a.m(e(), aVar) == obj) {
            return obj;
        }
    }

    public final Object c(List<String> list, d<? super List<ProgramModel>> d2) {
        boolean bVar;
        int label;
        Object booleanValue;
        int i;
        int i2;
        Object obj6;
        bVar = d2;
        label = bVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof i1.b && label & i != 0) {
            bVar = d2;
            label = bVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                bVar.label = label -= i;
            } else {
                bVar = new i1.b(this, d2);
            }
        } else {
        }
        obj6 = bVar.result;
        booleanValue = b.d();
        int label2 = bVar.label;
        int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                q.b(obj6);
                ArrayList obj5 = new ArrayList();
                obj6 = (Iterable)obj6.iterator();
                while (obj6.hasNext()) {
                    bVar = obj6.next();
                    if (b.a((ProgramModel)bVar.isClassicProgram()).booleanValue() != null) {
                    }
                    obj5.add(bVar);
                }
                return obj5;
            }
            obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj6);
        bVar.label = i3;
        if (d(list, bVar) == booleanValue) {
            return booleanValue;
        }
    }

    public final Object g(String string, d<? super ProgramModel> d2) {
        boolean dVar;
        int label;
        int i;
        int label2;
        int i2;
        Object obj6;
        dVar = d2;
        label = dVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof i1.d && label & i != 0) {
            dVar = d2;
            label = dVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                dVar.label = label -= i;
            } else {
                dVar = new i1.d(this, d2);
            }
        } else {
        }
        obj6 = dVar.result;
        Object obj = b.d();
        label2 = dVar.label;
        int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                q.b(obj6);
                return m1.y((e)obj6);
            }
            IllegalStateException obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj6);
        dVar.label = i3;
        if (this.a.s(e(), string, dVar) == obj) {
            return obj;
        }
    }
}
