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
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.y.p;

/* compiled from: ProgramContentRepository.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ%\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u000e2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J%\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u000e2\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000eH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000eH\u0002J\u0019\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\nH\u0002R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;", "", "programDao", "Lapp/dogo/android/persistencedb/room/dao/ProgramEntityDao;", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "(Lapp/dogo/android/persistencedb/room/dao/ProgramEntityDao;Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;)V", "contentLocale", "", "getContentLocale", "()Ljava/lang/String;", "fetchAllExistingProgramIds", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllClassicPrograms", "Lapp/dogo/com/dogo_android/model/trainingprogram/ProgramModel;", "startedProgramIds", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllPrograms", "startedClassicProgramIds", "getOverrideProgramId", "programId", "getProgram", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isProgramWhitelisted", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i1, reason: from kotlin metadata */
public final class ProgramContentRepository {

    private final e0 a;
    /* renamed from: b, reason: from kotlin metadata */
    private final p2 preferenceService;
    /* renamed from: c, reason: from kotlin metadata */
    private final r2 programDao;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramContentRepository", f = "ProgramContentRepository.kt", l = 33, m = "fetchAllExistingProgramIds")
    static final class a extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        a(kotlin.b0.d<? super i1.a> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return i1.this.getAllPrograms(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramContentRepository", f = "ProgramContentRepository.kt", l = 16, m = "getAllClassicPrograms")
    static final class b extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super i1.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return i1.this.c(null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramContentRepository", f = "ProgramContentRepository.kt", l = 20, m = "getAllPrograms")
    static final class c extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        c(kotlin.b0.d<? super i1.c> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return i1.this.getOverrideProgramId(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.ProgramContentRepository", f = "ProgramContentRepository.kt", l = 29, m = "getProgram")
    static final class d extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        d(kotlin.b0.d<? super i1.d> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return i1.this.g(null, this);
        }
    }
    public i1(e0 e0Var, p2 p2Var, r2 r2Var) {
        n.f(e0Var, "programDao");
        n.f(p2Var, "preferenceService");
        n.f(r2Var, "remoteConfigService");
        super();
        this.a = e0Var;
        this.preferenceService = p2Var;
        this.programDao = r2Var;
    }

    public static final /* synthetic */ Object a(i1 i1Var, List list, kotlin.b0.d dVar) {
        return i1Var.getOverrideProgramId(list, dVar);
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final Object getOverrideProgramId(List<String> programId, kotlin.b0.d<? super List<ProgramModel>> startedProgramIds) {
        Object startedProgramIds2;
        Object item;
        int label2;
        int i2 = -2147483648;
        int i3;
        List list;
        Object result2;
        z = startedProgramIds instanceof app.dogo.com.dogo_android.repository.local.i1.c;
        if (startedProgramIds instanceof app.dogo.com.dogo_android.repository.local.i1.c) {
            startedProgramIds2 = startedProgramIds;
            i2 = Integer.MIN_VALUE;
            i3 = label2 & i2;
            if (label2 & i2 != 0) {
                startedProgramIds2.label -= i2;
            } else {
                app.dogo.com.dogo_android.s.b.i1.c cVar = new app.dogo.com.dogo_android.repository.local.i1.c(this, startedProgramIds);
            }
        }
        Object obj = b.d();
        int i4 = 1;
        if (startedProgramIds2.label != 0) {
            if (startedProgramIds2.label != i4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(startedProgramIds2.result);
                ArrayList arrayList = new ArrayList();
                Iterator it3 = result2.iterator();
                while (it3.hasNext()) {
                    Object item2 = it3.next();
                }
                int i7 = 10;
                ArrayList arrayList3 = new ArrayList(p.r(arrayList, i7));
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    arrayList3.add((ProgramFullEntity)it2.next().b().getProgramId());
                }
                ArrayList arrayList2 = new ArrayList(p.r(arrayList3, i7));
                Iterator it = arrayList3.iterator();
                while (it.hasNext()) {
                    arrayList2.add(item.f((String)it.next(), list));
                }
                ArrayList arrayList4 = new ArrayList();
                Iterator it5 = result2.iterator();
                while (it5.hasNext()) {
                    item = it5.next();
                }
                ArrayList arrayList5 = new ArrayList(p.r(arrayList4, i7));
                Iterator it4 = arrayList4.iterator();
                while (it4.hasNext()) {
                    arrayList5.add(app.dogo.com.dogo_android.util.extensionfunction.m1.y((ProgramFullEntity)it4.next()));
                }
                return arrayList5;
            }
        }
        q.b(startedProgramIds2.result);
        startedProgramIds2.L$0 = this;
        startedProgramIds2.L$1 = programId;
        startedProgramIds2.label = i4;
        if (this.a.m(fetchAllExistingProgramIds(), startedProgramIds2) == obj) {
            return obj;
        }
        app.dogo.com.dogo_android.s.b.i1 programId2 = this;
    }

    /* renamed from: e, reason: from kotlin metadata */
    /* suspend */ private final String fetchAllExistingProgramIds() {
        return LocaleService.a.a(this.preferenceService.W());
    }

    private final String f(String str, List<String> list) {
        Object obj;
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = this.programDao.N().entrySet().iterator();
        while (it.hasNext()) {
            Object value = it.next();
        }
        obj = p.Y(linkedHashMap.keySet());
        if (obj != null && list.contains(obj)) {
        }
        return obj;
    }

    /* renamed from: h, reason: from kotlin metadata */
    /* suspend */ private final boolean getAllClassicPrograms(String startedProgramIds) {
        return this.programDao.M().contains(startedProgramIds);
    }

    /* renamed from: b, reason: from kotlin metadata */
    /* suspend */ public final Object getAllPrograms(kotlin.b0.d<? super List<String>> startedClassicProgramIds) {
        Object startedClassicProgramIds2;
        int label2;
        int i2 = -2147483648;
        int i3;
        Iterable iterable;
        z = startedClassicProgramIds instanceof app.dogo.com.dogo_android.repository.local.i1.a;
        if (startedClassicProgramIds instanceof app.dogo.com.dogo_android.repository.local.i1.a) {
            startedClassicProgramIds2 = startedClassicProgramIds;
            i2 = Integer.MIN_VALUE;
            i3 = label2 & i2;
            if (label2 & i2 != 0) {
                startedClassicProgramIds2.label -= i2;
            } else {
                app.dogo.com.dogo_android.s.b.i1.a aVar = new app.dogo.com.dogo_android.repository.local.i1.a(this, startedClassicProgramIds);
            }
        }
        Object obj = b.d();
        int i5 = 1;
        if (startedClassicProgramIds2.label != 0) {
            if (startedClassicProgramIds2.label != i5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(startedClassicProgramIds2.result);
                ArrayList arrayList = new ArrayList(p.r(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    arrayList.add((ProgramFullEntity)it.next().b().getProgramId());
                }
                return arrayList;
            }
        }
        q.b(startedClassicProgramIds2.result);
        startedClassicProgramIds2.label = i5;
        if (this.a.m(fetchAllExistingProgramIds(), startedClassicProgramIds2) == obj) {
            return obj;
        }
    }

    public final Object c(List<String> list, kotlin.b0.d<? super List<ProgramModel>> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        int i2;
        Object overrideProgramId;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.i1.b;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.i1.b) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.i1.b bVar = new app.dogo.com.dogo_android.repository.local.i1.b(this, dVar);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar22.result);
                ArrayList arrayList = new ArrayList();
                Iterator it = (Iterable)overrideProgramId.iterator();
                while (it.hasNext()) {
                    dVar22 = it.next();
                }
                return arrayList;
            }
        }
        q.b(dVar22.result);
        dVar22.label = i3;
        if (getOverrideProgramId(list, dVar22) == obj) {
            return obj;
        }
    }

    public final Object g(String str, kotlin.b0.d<? super ProgramModel> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        int i2;
        e eVar;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.i1.d;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.i1.d) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                dVar = new app.dogo.com.dogo_android.repository.local.i1.d(this, dVar);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar22.result);
                return app.dogo.com.dogo_android.util.extensionfunction.m1.y((ProgramFullEntity)eVar);
            }
        }
        q.b(dVar22.result);
        dVar22.label = i3;
        if (this.a.s(fetchAllExistingProgramIds(), str, dVar22) == obj) {
            return obj;
        }
    }
}
