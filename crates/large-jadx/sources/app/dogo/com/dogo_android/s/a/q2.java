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
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;
import kotlin.z.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0017\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J%\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ(\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00120\u001c2\u0006\u0010\u0017\u001a\u00020\u00182\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001d\u001a\u00020\u001eJ\u0017\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J+\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0017\u001a\u00020\u00142\n\u0008\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0017\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006$", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "isDogPremiumInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/IsDogPremiumInteractor;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getRecentlyViewedTricksData", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSectionAndCategoryData", "Lapp/dogo/com/dogo_android/repository/domain/LibrarySection;", "categoryId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSectionData", "category", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;", "trickTag", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem$TrickCategory;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSectionDataSingle", "Lio/reactivex/Single;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getSimpleTrickListData", "getTrickData", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrickListData", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class q2 {

    public static final app.dogo.com.dogo_android.s.a.q2.a Companion;
    private final p1 a;
    private final o1 b;
    private final r2 c;
    private final app.dogo.com.dogo_android.s.a.d3 d;
    private final h0 e;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetLibraryTrickListInteractor$Companion;", "", "()V", "TAG_ID_SIMPLE", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class d implements Comparator {
        public final int compare(T t, T t2) {
            return a.c((LibraryTag)t.getName(), (LibraryTag)t2.getName());
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryTrickListInteractor", f = "GetLibraryTrickListInteractor.kt", l = {24, 25}, m = "getSectionAndCategoryData")
    static final class c extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.q2 this$0;
        c(app.dogo.com.dogo_android.s.a.q2 q2, d<? super app.dogo.com.dogo_android.s.a.q2.c> d2) {
            this.this$0 = q2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.f(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryTrickListInteractor", f = "GetLibraryTrickListInteractor.kt", l = 29, m = "getSectionData")
    static final class e extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.q2 this$0;
        e(app.dogo.com.dogo_android.s.a.q2 q2, d<? super app.dogo.com.dogo_android.s.a.q2.e> d2) {
            this.this$0 = q2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            int i2 = 0;
            return this.this$0.g(i2, i2, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryTrickListInteractor", f = "GetLibraryTrickListInteractor.kt", l = 85, m = "getSimpleTrickListData")
    static final class g extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.q2 this$0;
        g(app.dogo.com.dogo_android.s.a.q2 q2, d<? super app.dogo.com.dogo_android.s.a.q2.g> d2) {
            this.this$0 = q2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.k(this);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryTrickListInteractor$getRecentlyViewedTricksData$2", f = "GetLibraryTrickListInteractor.kt", l = {53, 54}, m = "invokeSuspend")
    static final class b extends k implements p<m0, d<? super List<? extends TrickItem>>, Object> {

        int label;
        final app.dogo.com.dogo_android.s.a.q2 this$0;
        b(app.dogo.com.dogo_android.s.a.q2 q2, d<? super app.dogo.com.dogo_android.s.a.q2.b> d2) {
            this.this$0 = q2;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super List<TrickItem>> d2) {
            return (q2.b)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            q2.b obj2 = new q2.b(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int label;
            int i;
            Iterator iterator;
            Object next;
            boolean booleanValue;
            String trickId;
            Object obj11;
            Object obj = b.d();
            label = this.label;
            int i3 = 2;
            int i4 = 1;
            if (label != 0) {
                if (label != i4) {
                    if (label != i3) {
                    } else {
                        q.b(object);
                        int i2 = 0;
                        Object blockingGet = d3.b(q2.d(this.this$0), i2, i4, i2).blockingGet();
                        Object blockingGet2 = q2.b(this.this$0).s().blockingGet();
                        ArrayList arrayList = new ArrayList();
                        obj11 = (List)obj11.iterator();
                        for (TrickProgressEntity next3 : obj11) {
                            n.e((List)blockingGet2, "tricks");
                            iterator = blockingGet2.iterator();
                            for (Object next : iterator) {
                            }
                            next = i2;
                            if ((TrickModel)next == null) {
                            } else {
                            }
                            n.e((Boolean)blockingGet, "isPremium");
                            i = j1.S0((TrickModel)next, b.c(next3.getKnowledge()), q2.a(this.this$0).n(), blockingGet.booleanValue());
                            if (i != 0) {
                            }
                            arrayList.add(i);
                            i = i2;
                            if (b.a(n.b((TrickModel)iterator.next().getId(), next3.getTrickId())).booleanValue()) {
                            } else {
                            }
                        }
                        return arrayList;
                    }
                    obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw obj11;
                }
                q.b(object);
            } else {
                q.b(object);
                this.label = i4;
                if (q2.c(this.this$0).u(this) == obj) {
                    return obj;
                }
            }
            this.label = i3;
            if (q2.b(this.this$0).n((String)obj11, this) == obj) {
                return obj;
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryTrickListInteractor$getSectionDataSingle$1$1", f = "GetLibraryTrickListInteractor.kt", l = 43, m = "invokeSuspend")
    static final class f extends k implements p<m0, d<? super w>, Object> {

        final TrickItem.TrickCategory $category;
        final c0<LibrarySection> $emitter;
        final String $trickTag;
        Object L$0;
        int label;
        final app.dogo.com.dogo_android.s.a.q2 this$0;
        f(c0<LibrarySection> c0, app.dogo.com.dogo_android.s.a.q2 q22, TrickItem.TrickCategory trickItem$TrickCategory3, String string4, d<? super app.dogo.com.dogo_android.s.a.q2.f> d5) {
            this.$emitter = c0;
            this.this$0 = q22;
            this.$category = trickCategory3;
            this.$trickTag = string4;
            super(2, d5);
        }

        public final Object c(m0 m0, d<? super w> d2) {
            return (q2.f)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            super(this.$emitter, this.this$0, this.$category, this.$trickTag, d2);
            return obj7;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$0;
            int label;
            TrickItem.TrickCategory $category;
            String $trickTag;
            Object obj6;
            Object obj = b.d();
            label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    l$0 = this.L$0;
                    q.b(object);
                    l$0.onSuccess(obj6);
                    return w.a;
                }
                obj6 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj6;
            }
            q.b(object);
            obj6 = this.$emitter;
            this.L$0 = obj6;
            this.label = i;
            label = this.this$0.g(this.$category, this.$trickTag, this);
            if (label == obj) {
                return obj;
            }
            l$0 = obj6;
            obj6 = label;
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u008a@", d2 = {"<anonymous>", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetLibraryTrickListInteractor$getTrickData$2", f = "GetLibraryTrickListInteractor.kt", l = 70, m = "invokeSuspend")
    static final class h extends k implements p<m0, d<? super List<? extends TrickItem>>, Object> {

        final String $category;
        final String $trickTag;
        int label;
        final app.dogo.com.dogo_android.s.a.q2 this$0;
        h(app.dogo.com.dogo_android.s.a.q2 q2, String string2, String string3, d<? super app.dogo.com.dogo_android.s.a.q2.h> d4) {
            this.this$0 = q2;
            this.$category = string2;
            this.$trickTag = string3;
            super(2, d4);
        }

        public final Object c(m0 m0, d<? super List<TrickItem>> d2) {
            return (q2.h)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            q2.h obj4 = new q2.h(this.this$0, this.$category, this.$trickTag, d2);
            return obj4;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            int i;
            Object obj;
            List list;
            boolean booleanValue;
            Object obj9;
            Object obj2 = b.d();
            int label = this.label;
            int i3 = 1;
            if (label != 0) {
                if (label != i3) {
                } else {
                    q.b(object);
                    int i2 = 0;
                    Object blockingGet = d3.b(q2.d(this.this$0), i2, i3, i2).blockingGet();
                    Object blockingGet2 = q2.b(this.this$0).u(this.$category, this.$trickTag).blockingGet();
                    n.e((List)blockingGet2, "tricks");
                    ArrayList arrayList = new ArrayList(p.r(blockingGet2, 10));
                    Iterator iterator = blockingGet2.iterator();
                    for (TrickModel next2 : iterator) {
                        n.e((Boolean)blockingGet, "isPremium");
                        arrayList.add(j1.S0(next2, (Integer)(Map)q2.b(this.this$0).f((String)obj9).blockingGet().get(next2.getId()), q2.a(this.this$0).n(), blockingGet.booleanValue()));
                    }
                    obj9 = new q2.h.a();
                    return p.D0(arrayList, obj9);
                }
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
            }
            q.b(object);
            this.label = i3;
            if (q2.c(this.this$0).u(this) == obj2) {
                return obj2;
            }
        }
    }
    static {
        q2.a aVar = new q2.a(0);
        q2.Companion = aVar;
    }

    public q2(p1 p1, o1 o12, r2 r23, app.dogo.com.dogo_android.s.a.d3 d34, h0 h05) {
        n.f(p1, "userRepository");
        n.f(o12, "tricksRepository");
        n.f(r23, "remoteConfigService");
        n.f(d34, "isDogPremiumInteractor");
        n.f(h05, "dispatcher");
        super();
        this.a = p1;
        this.b = o12;
        this.c = r23;
        this.d = d34;
        this.e = h05;
    }

    public q2(p1 p1, o1 o12, r2 r23, app.dogo.com.dogo_android.s.a.d3 d34, h0 h05, int i6, g g7) {
        h0 obj11;
        if (i6 &= 16 != 0) {
            obj11 = c1.b();
        }
        super(p1, o12, r23, d34, obj11);
    }

    public static final r2 a(app.dogo.com.dogo_android.s.a.q2 q2) {
        return q2.c;
    }

    public static final o1 b(app.dogo.com.dogo_android.s.a.q2 q2) {
        return q2.b;
    }

    public static final p1 c(app.dogo.com.dogo_android.s.a.q2 q2) {
        return q2.a;
    }

    public static final app.dogo.com.dogo_android.s.a.d3 d(app.dogo.com.dogo_android.s.a.q2 q2) {
        return q2.d;
    }

    public static Object h(app.dogo.com.dogo_android.s.a.q2 q2, TrickItem.TrickCategory trickItem$TrickCategory2, String string3, d d4, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        return q2.g(trickCategory2, obj2, d4);
    }

    private static final void j(m0 m0, app.dogo.com.dogo_android.s.a.q2 q22, TrickItem.TrickCategory trickItem$TrickCategory3, String string4, c0 c05) {
        n.f(m0, "$scope");
        n.f(q22, "this$0");
        n.f(trickCategory3, "$category");
        n.f(c05, "emitter");
        final int i4 = 0;
        super(c05, q22, trickCategory3, string4, i4);
        k.d(m0, 0, 0, fVar, 3, i4);
    }

    private final Object l(String string, String string2, d<? super List<TrickItem>> d3) {
        q2.h hVar = new q2.h(this, string, string2, 0);
        return k.e(this.e, hVar, d3);
    }

    static Object m(app.dogo.com.dogo_android.s.a.q2 q2, String string2, String string3, d d4, int i5, Object object6) {
        int obj2;
        if (i5 &= 2 != 0) {
            obj2 = 0;
        }
        return q2.l(string2, obj2, d4);
    }

    public static void o(m0 m0, app.dogo.com.dogo_android.s.a.q2 q22, TrickItem.TrickCategory trickItem$TrickCategory3, String string4, c0 c05) {
        q2.j(m0, q22, trickCategory3, string4, c05);
    }

    public final Object e(d<? super List<TrickItem>> d) {
        q2.b bVar = new q2.b(this, 0);
        return k.e(this.e, bVar, d);
    }

    public final Object f(String string, d<? super LibrarySection> d2) {
        boolean cVar;
        int label;
        app.dogo.com.dogo_android.s.a.q2 label2;
        int i5;
        TrickItem.TrickCategory i3;
        int i6;
        int i;
        int i2;
        int i4;
        Object obj8;
        Object obj9;
        cVar = d2;
        label = cVar.label;
        i5 = Integer.MIN_VALUE;
        if (d2 instanceof q2.c && label & i5 != 0) {
            cVar = d2;
            label = cVar.label;
            i5 = Integer.MIN_VALUE;
            if (label & i5 != 0) {
                cVar.label = label -= i5;
            } else {
                cVar = new q2.c(this, d2);
            }
        } else {
        }
        final app.dogo.com.dogo_android.s.a.q2.c cVar2 = cVar;
        obj9 = cVar2.result;
        Object obj = b.d();
        label2 = cVar2.label;
        i3 = 2;
        i = 1;
        if (label2 != 0) {
            if (label2 != i) {
                if (label2 != i3) {
                } else {
                    q.b(obj9);
                    return obj9;
                }
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
            }
            q.b(obj9);
            label2 = obj8;
        } else {
            q.b(obj9);
            cVar2.L$0 = this;
            cVar2.label = i;
            if (this.b.p(string, cVar2) == obj) {
                return obj;
            }
            label2 = this;
        }
        obj8 = new TrickItem.TrickCategory((TrickModel.TrickCategory)obj9.getId(), obj9.getName());
        cVar2.L$0 = 0;
        cVar2.label = i3;
        if (q2.h(label2, obj8, 0, cVar2, 2, 0) == obj) {
            return obj;
        }
    }

    public final Object g(TrickItem.TrickCategory trickItem$TrickCategory, String string2, d<? super LibrarySection> d3) {
        boolean eVar;
        int label;
        Object next;
        int i2;
        int i3;
        int i;
        Object obj11;
        Object obj13;
        eVar = d3;
        label = eVar.label;
        i2 = Integer.MIN_VALUE;
        if (d3 instanceof q2.e && label & i2 != 0) {
            eVar = d3;
            label = eVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                eVar.label = label -= i2;
            } else {
                eVar = new q2.e(this, d3);
            }
        } else {
        }
        obj13 = eVar.result;
        next = b.d();
        int label2 = eVar.label;
        i = 1;
        if (label2 != 0) {
            if (label2 != i) {
            } else {
                obj11 = eVar.L$0;
                q.b(obj13);
                Object obj = obj13;
                ArrayList obj12 = new ArrayList();
                obj13 = (List)obj.iterator();
                for (TrickItem next3 : obj13) {
                    p.y(obj12, next3.getTags());
                }
                obj13 = new HashSet();
                ArrayList arrayList = new ArrayList();
                obj12 = obj12.iterator();
                while (obj12.hasNext()) {
                    next = obj12.next();
                    if (obj13.add((LibraryTag)next.getId()) != 0) {
                    }
                    arrayList.add(next);
                }
                obj12 = new q2.d();
                super(0, obj, 0, obj11.getId(), obj11.getName(), LibrarySection.SectionType.TRICK, p.D0(arrayList, obj12), 5, 0);
                return obj11;
            }
            obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj11;
        }
        q.b(obj13);
        eVar.L$0 = trickCategory;
        eVar.label = i;
        if (l(trickCategory.getId(), string2, eVar) == next) {
            return next;
        }
    }

    public final a0<LibrarySection> i(TrickItem.TrickCategory trickItem$TrickCategory, String string2, m0 m03) {
        n.f(trickCategory, "category");
        n.f(m03, "scope");
        m mVar = new m(m03, this, trickCategory, string2);
        final a0 obj2 = a0.create(mVar);
        n.e(obj2, "create { emitter ->\n            scope.launch {\n                try {\n                    emitter.onSuccess(getSectionData(category, trickTag))\n                } catch (e: Exception) {\n                    emitter.onError(e)\n                }\n            }\n        }");
        return obj2;
    }

    public final Object k(d<? super List<TrickItem>> d) {
        boolean gVar;
        int label;
        int label2;
        int booleanValue2;
        Object iterator;
        int booleanValue;
        app.dogo.com.dogo_android.s.a.q2.g gVar2;
        int str;
        int i;
        Object obj9;
        gVar = d;
        label = gVar.label;
        booleanValue2 = Integer.MIN_VALUE;
        if (d instanceof q2.g && label & booleanValue2 != 0) {
            gVar = d;
            label = gVar.label;
            booleanValue2 = Integer.MIN_VALUE;
            if (label & booleanValue2 != 0) {
                gVar.label = label -= booleanValue2;
            } else {
                gVar = new q2.g(this, d);
            }
        } else {
        }
        gVar2 = gVar;
        obj9 = gVar2.result;
        Object obj = b.d();
        label2 = gVar2.label;
        final int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                q.b(obj9);
                ArrayList arrayList = new ArrayList();
                obj9 = (Iterable)obj9.iterator();
                while (obj9.hasNext()) {
                    label2 = obj9.next();
                    iterator = (TrickItem)label2.getTags();
                    gVar2 = 0;
                    if (iterator instanceof Collection != null && iterator.isEmpty()) {
                    } else {
                    }
                    iterator = iterator.iterator();
                    while (iterator.hasNext()) {
                        if (b.a(n.b((LibraryTag)iterator.next().getId(), "id_simple")).booleanValue()) {
                            break loop_16;
                        } else {
                        }
                    }
                    if (b.a(gVar2).booleanValue() != 0) {
                    }
                    arrayList.add(label2);
                    if (b.a(n.b((LibraryTag)iterator.next().getId(), "id_simple")).booleanValue()) {
                    } else {
                    }
                    gVar2 = i3;
                    if (iterator.isEmpty()) {
                    } else {
                    }
                }
                return arrayList;
            }
            obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj9;
        }
        q.b(obj9);
        gVar2.label = i3;
        if (q2.m(this, "id_tricks", 0, gVar2, 2, 0) == obj) {
            return obj;
        }
    }

    public final Object n(d<? super List<TrickItem>> d) {
        return q2.m(this, "", 0, d, 2, 0);
    }
}
