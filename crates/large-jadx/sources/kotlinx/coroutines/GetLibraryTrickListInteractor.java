package app.dogo.com.dogo_android.s.a;

import app.dogo.android.persistencedb.room.entity.TrickProgressEntity;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;
import app.dogo.com.dogo_android.repository.domain.LibrarySection.SectionType;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory;
import app.dogo.com.dogo_android.s.b.o1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.h0.j1;
import i.b.a0;
import i.b.c0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.k.a.f;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.z.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: GetLibraryTrickListInteractor.kt */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J%\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ(\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001d\u001a\u00020\u001eJ\u0017\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J+\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0017\u001a\u00020\u00142\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getRecentlyViewedTricksData", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSectionAndCategoryData", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "categoryId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSectionData", "category", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "trickTag", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSectionDataSingle", "Lio/reactivex/Single;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getSimpleTrickListData", "getTrickData", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrickListData", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: q2, reason: from kotlin metadata */
public final class GetLibraryTrickListInteractor {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final q2.a INSTANCE = new q2$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final p1 dispatcher;
    /* renamed from: b, reason: from kotlin metadata */
    private final o1 isDogPremiumInteractor;
    /* renamed from: c, reason: from kotlin metadata */
    private final r2 remoteConfigService;
    /* renamed from: d, reason: from kotlin metadata */
    private final d3 tricksRepository;
    /* renamed from: e, reason: from kotlin metadata */
    private final h0 userRepository;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor$Companion;", "", "()V", "TAG_ID_SIMPLE", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class d<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.c(t.getName(), t2.getName());
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryTrickListInteractor", f = "GetLibraryTrickListInteractor.kt", l = {24, 25}, m = "getSectionAndCategoryData")
    static final class c extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        c(kotlin.b0.d<? super q2.c> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return q2.this.getSectionData(null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryTrickListInteractor", f = "GetLibraryTrickListInteractor.kt", l = 29, m = "getSectionData")
    static final class e extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        e(kotlin.b0.d<? super q2.e> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            TrickItem.TrickCategory trickCategory = null;
            return q2.this.g(trickCategory, trickCategory, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryTrickListInteractor", f = "GetLibraryTrickListInteractor.kt", l = 85, m = "getSimpleTrickListData")
    static final class g extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        g(kotlin.b0.d<? super q2.g> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return q2.this.k(this);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryTrickListInteractor$getRecentlyViewedTricksData$2", f = "GetLibraryTrickListInteractor.kt", l = {53, 54}, m = "invokeSuspend")
    static final class b extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, kotlin.b0.d<? super List<? extends TrickItem>>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj;
            Iterator it;
            TrickModel item;
            boolean booleanValue;
            String trickId;
            Object obj2;
            String str5;
            Object obj3 = b.d();
            int i = 2;
            int i2 = 1;
            if (this.label != 0) {
                if (this.label != i2) {
                    if (this.label != i) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(object);
                        String str = null;
                        Object blockingGet = IsDogPremiumInteractor.b(q2.this.tricksRepository, str, i2, str).blockingGet();
                        Object blockingGet2 = q2.this.isDogPremiumInteractor.s().blockingGet();
                        final ArrayList arrayList = new ArrayList();
                        Iterator it2 = (List)obj2.iterator();
                        while (it2.hasNext()) {
                            Object item2 = it2.next();
                            n.e(blockingGet2, "tricks");
                            it = blockingGet2.iterator();
                            while (it.hasNext()) {
                                if (b.a(n.b((TrickModel)item.getId(), item2.getTrickId())).booleanValue()) {
                                    break loop_13;
                                }
                            }
                        }
                        return arrayList;
                    }
                }
                q.b(object);
            } else {
                q.b(object);
                this.label = i2;
                if (q2.this.dispatcher.u(this) == obj3) {
                    return obj3;
                }
            }
            this.label = i;
            if (q2.this.isDogPremiumInteractor.n((String)str5, this) == obj3) {
                return obj3;
            }
        }

        b(kotlin.b0.d<? super q2.b> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super List<TrickItem>> dVar) {
            return (kotlinx.coroutines.q2.b)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new kotlinx.coroutines.q2.b(q2.this, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryTrickListInteractor$getSectionDataSingle$1$1", f = "GetLibraryTrickListInteractor.kt", l = 43, m = "invokeSuspend")
    static final class f extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, kotlin.b0.d<? super w>, Object> {

        final /* synthetic */ TrickItem.TrickCategory $category;
        final /* synthetic */ c0<LibrarySection> $emitter;
        final /* synthetic */ String $trickTag;
        Object L$0;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            c0 object2;
            Object obj;
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    try {
                        q.b(object);
                    } catch (Exception e) {
                        this.$emitter.onError(e);
                    }
                    object2.onSuccess(obj);
                    return w.a;
                }
            }
            q.b(e);
            try {
                this.L$0 = this.$emitter;
                this.label = i;
                obj = q2.this.g(this.$category, this.$trickTag, this);
                if (obj == obj2) {
                    return obj2;
                }
                object2.onSuccess(obj);
            } catch (Exception e) {
                this.$emitter.onError(e);
            }
        }

        f(c0<LibrarySection> c0Var, q2 q2Var, TrickItem.TrickCategory trickCategory, String str, kotlin.b0.d<? super q2.f> dVar) {
            this.$emitter = c0Var;
            this.$category = trickCategory;
            this.$trickTag = str;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super w> dVar) {
            return (kotlinx.coroutines.q2.f)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            kotlinx.coroutines.q2.f object2 = new kotlinx.coroutines.q2.f(this.$emitter, q2.this, this.$category, this.$trickTag, dVar);
            return object2;
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryTrickListInteractor$getTrickData$2", f = "GetLibraryTrickListInteractor.kt", l = 70, m = "invokeSuspend")
    static final class h extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, kotlin.b0.d<? super List<? extends TrickItem>>, Object> {

        final /* synthetic */ String $category;
        final /* synthetic */ String $trickTag;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            String str5;
            Object obj = b.d();
            int i2 = 1;
            if (this.label != 0) {
                if (this.label != i2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    String str2 = null;
                    Object blockingGet = IsDogPremiumInteractor.b(q2.this.tricksRepository, str2, i2, str2).blockingGet();
                    Object blockingGet2 = q2.this.isDogPremiumInteractor.u(this.$category, this.$trickTag).blockingGet();
                    n.e(blockingGet2, "tricks");
                    ArrayList arrayList = new ArrayList(p.r(blockingGet2, 10));
                    Iterator it = blockingGet2.iterator();
                    while (it.hasNext()) {
                        Object item = it.next();
                        n.e(blockingGet, "isPremium");
                        arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.j1.S0(item, (Integer)(Map)q2.this.isDogPremiumInteractor.f((String)str5).blockingGet().get(item.getId()), q2.this.remoteConfigService.n(), blockingGet.booleanValue()));
                    }
                    return p.D0(arrayList, new kotlinx.coroutines.q2.h.a());
                }
            }
            q.b(object);
            this.label = i2;
            if (q2.this.dispatcher.u(this) == obj) {
                return obj;
            }
        }

        h(String str, String str2, kotlin.b0.d<? super q2.h> dVar) {
            this.$category = str;
            this.$trickTag = str2;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super List<TrickItem>> dVar) {
            return (kotlinx.coroutines.q2.h)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new kotlinx.coroutines.q2.h(q2.this, this.$category, this.$trickTag, dVar);
        }
    }
    public q2(p1 p1Var, o1 o1Var, r2 r2Var, d3 d3Var, h0 h0Var) {
        n.f(p1Var, "userRepository");
        n.f(o1Var, "tricksRepository");
        n.f(r2Var, "remoteConfigService");
        n.f(d3Var, "isDogPremiumInteractor");
        n.f(h0Var, "dispatcher");
        super();
        this.dispatcher = p1Var;
        this.isDogPremiumInteractor = o1Var;
        this.remoteConfigService = r2Var;
        this.tricksRepository = d3Var;
        this.userRepository = h0Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ r2 getSectionAndCategoryData(q2 categoryId) {
        return categoryId.remoteConfigService;
    }

    public static final /* synthetic */ o1 b(q2 q2Var) {
        return q2Var.isDogPremiumInteractor;
    }

    public static final /* synthetic */ p1 c(q2 q2Var) {
        return q2Var.dispatcher;
    }

    public static final /* synthetic */ d3 d(q2 q2Var) {
        return q2Var.tricksRepository;
    }

    public static /* synthetic */ Object h(q2 q2Var, TrickItem.TrickCategory trickCategory, String str, kotlin.b0.d dVar, int i, Object object) {
        if (i & 2 != 0) {
            i = 0;
        }
        return q2Var.g(trickCategory, str, dVar);
    }

    private static final void j(m0 m0Var, q2 q2Var, TrickItem.TrickCategory trickCategory, String str, c0 c0Var) {
        n.f(m0Var, "$scope");
        n.f(q2Var, "this$0");
        n.f(trickCategory, "$category");
        n.f(c0Var, "emitter");
        final kotlin.b0.d dVar = null;
        kotlinx.coroutines.q2.f fVar = new kotlinx.coroutines.q2.f(c0Var, q2Var, trickCategory, str, dVar);
        kotlinx.coroutines.internal.k.d(m0Var, null, null, fVar, 3, dVar);
    }

    /* renamed from: l, reason: from kotlin metadata */
    private final Object getSectionDataSingle(String category, String trickTag, kotlin.b0.d<? super List<TrickItem>> scope) {
        return kotlinx.coroutines.internal.k.e(this.userRepository, new kotlinx.coroutines.q2.h(this, category, trickTag, null), scope);
    }

    static /* synthetic */ Object m(q2 q2Var, String str, String str2, kotlin.b0.d dVar, int i, Object object) {
        if (i & 2 != 0) {
            i = 0;
        }
        return q2Var.getSectionDataSingle(str, str, dVar);
    }

    public final Object e(kotlin.b0.d<? super List<TrickItem>> dVar) {
        return kotlinx.coroutines.internal.k.e(this.userRepository, new kotlinx.coroutines.q2.b(this, null), dVar);
    }

    /* renamed from: f, reason: from kotlin metadata */
    /* suspend */ public final Object getSectionData(String category, kotlin.b0.d<? super LibrarySection> trickTag) {
        app.dogo.com.dogo_android.s.a.q2.c cVar;
        int label2;
        app.dogo.com.dogo_android.s.a.q2 q2Var;
        int i = -2147483648;
        int i2;
        Object result2;
        z = trickTag instanceof kotlinx.coroutines.q2.c;
        if (trickTag instanceof kotlinx.coroutines.q2.c) {
            Object trickTag2 = trickTag;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                trickTag2.label -= i;
            } else {
                cVar = new kotlinx.coroutines.q2.c(this, trickTag);
            }
        }
        final Object obj3 = cVar;
        Object obj2 = b.d();
        int i4 = 2;
        int i5 = 1;
        if (obj3.label != 0) {
            if (obj3.label != i5) {
                if (obj3.label != i4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(obj3.result);
                    return result2;
                }
            }
            q.b(obj3.result);
        } else {
            q.b(obj3.result);
            obj3.L$0 = this;
            obj3.label = i5;
            if (this.isDogPremiumInteractor.p(category, obj3) == obj2) {
                return obj2;
            }
            q2Var = this;
        }
        String str = null;
        int i3 = 2;
        Object obj = null;
        obj3.L$0 = null;
        obj3.label = i4;
        return GetLibraryTrickListInteractor.h(q2Var, category3, str, obj3, i3, obj) == obj2 ? obj2 : result2;
    }

    public final Object g(TrickItem.TrickCategory trickCategory, String str, kotlin.b0.d<? super LibrarySection> dVar) {
        Object dVar32;
        int label2;
        int i = -2147483648;
        int i2;
        Object obj;
        Object sectionDataSingle;
        z = dVar instanceof kotlinx.coroutines.q2.e;
        if (dVar instanceof kotlinx.coroutines.q2.e) {
            dVar32 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar32.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.q2.e eVar = new kotlinx.coroutines.q2.e(this, dVar);
            }
        }
        Object item = b.d();
        int i3 = 1;
        if (dVar32.label != 0) {
            if (dVar32.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar32.result);
                List list = sectionDataSingle;
                ArrayList arrayList2 = new ArrayList();
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    p.y(arrayList2, (TrickItem)it2.next().getTags());
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    item = it.next();
                }
                LibrarySection trickCategory2 = new LibrarySection(null, list, null, obj.getId(), obj.getName(), LibrarySection_SectionType.TRICK, p.D0(arrayList, new kotlinx.coroutines.q2.d()), 5, null);
                return trickCategory2;
            }
        }
        q.b(dVar32.result);
        dVar32.L$0 = trickCategory;
        dVar32.label = i3;
        if (getSectionDataSingle(trickCategory.getId(), str, dVar32) == item) {
            return item;
        }
    }

    public final a0<LibrarySection> i(TrickItem.TrickCategory trickCategory, String str, m0 m0Var) {
        n.f(trickCategory, "category");
        n.f(m0Var, "scope");
        final a0 a0Var = a0.create(new kotlinx.coroutines.m(m0Var, this, trickCategory, str));
        n.e(a0Var, "create { emitter ->\n            scope.launch {\n                try {\n                    emitter.onSuccess(getSectionData(category, trickTag))\n                } catch (e: Exception) {\n                    emitter.onError(e)\n                }\n            }\n        }");
        return a0Var;
    }

    public final Object k(kotlin.b0.d<? super List<TrickItem>> dVar) {
        app.dogo.com.dogo_android.s.a.q2.g gVar;
        int label2;
        int label22;
        int i = -2147483648;
        int i2;
        boolean booleanValue;
        boolean z3 = false;
        int i4 = 2;
        Object result2;
        z = dVar instanceof kotlinx.coroutines.q2.g;
        if (dVar instanceof kotlinx.coroutines.q2.g) {
            Object dVar2 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar2.label -= i;
            } else {
                gVar = new kotlinx.coroutines.q2.g(this, dVar);
            }
        }
        obj = gVar;
        Object obj3 = b.d();
        final int i3 = 1;
        if (obj.label != 0 && obj.label == i3) {
            q.b(obj.result);
            ArrayList arrayList = new ArrayList();
            Iterator it2 = (Iterable)result2.iterator();
            while (it2.hasNext()) {
                Object item = it2.next();
                List tags = (TrickItem)item.getTags();
                booleanValue = tags instanceof Collection;
                int i5 = 0;
            }
            return arrayList;
        }
        q.b(obj.result);
        i4 = 2;
        Object obj2 = null;
        obj.label = i3;
        if (GetLibraryTrickListInteractor.m(this, "id_tricks", null, obj, i4, obj2) == obj3) {
            return obj3;
        }
    }

    public final Object n(kotlin.b0.d<? super List<TrickItem>> dVar) {
        return GetLibraryTrickListInteractor.m(this, "", null, dVar, 2, null);
    }

    public /* synthetic */ q2(p1 p1Var, o1 o1Var, r2 r2Var, d3 d3Var, h0 h0Var, int i, g gVar) {
        h0 h0Var52;
        if (i & 16 != 0) {
            h0Var52 = Dispatchers.b();
        }
        this(p1Var, o1Var, r2Var, d3Var, h0Var52);
    }


    public static /* synthetic */ void o(m0 m0Var, q2 q2Var, TrickItem.TrickCategory trickCategory, String str, c0 c0Var) {
        GetLibraryTrickListInteractor.j(m0Var, q2Var, trickCategory, str, c0Var);
    }
}
