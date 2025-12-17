package app.dogo.com.dogo_android.s.b;

import app.dogo.android.network.DogoApiClient;
import app.dogo.android.persistencedb.room.entity.TrickEntity;
import app.dogo.android.persistencedb.room.entity.TrickProgressEntity;
import app.dogo.android.persistencedb.room.entity.TrickProgressEntity.Companion;
import app.dogo.android.persistencedb.room.entity.TrickProgressEntity.TrickKnowledgeViewData;
import app.dogo.android.persistencedb.room.entity.TrickTagEntity;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickCategory;
import app.dogo.com.dogo_android.model.trainingprogram.TrickModel.TrickTag;
import app.dogo.com.dogo_android.n.m.t.h;
import app.dogo.com.dogo_android.n.m.t.h.a;
import app.dogo.com.dogo_android.n.m.t.h.b;
import app.dogo.com.dogo_android.n.m.t.i;
import app.dogo.com.dogo_android.n.m.t.i.a;
import app.dogo.com.dogo_android.n.m.t.i.b;
import app.dogo.com.dogo_android.n.m.t.i.c;
import app.dogo.com.dogo_android.service.n2;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.h0.m1;
import app.dogo.com.dogo_android.util.z;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.q3;
import app.dogo.externalmodel.model.TrickKnowledgeEvent;
import app.dogo.externalmodel.model.requests.SaveProgramTrickKnowledgeRequest;
import app.dogo.externalmodel.model.requests.SaveSpecialProgramTrickKnowledgeRequest;
import app.dogo.externalmodel.model.requests.SaveTrickKnowledgeRequest;
import app.dogo.externalmodel.model.responses.GetTrickKnowledgeResponse;
import e.a.a.a.b.b.m0;
import e.a.a.a.b.b.o0;
import e.a.a.a.b.b.s0;
import e.a.a.a.b.d.g;
import i.b.a0;
import i.b.b;
import i.b.d;
import i.b.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.o;
import kotlin.q;
import kotlin.w;
import kotlin.y.j0;
import kotlin.y.p;
import kotlin.z.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u0000 B2\u00020\u0001:\u0001BBO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u000c\u0010 \u001a\u0008\u0012\u0004\u0012\u00020!0\u0016H\u0002J \u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020%0$0#2\u0006\u0010\u001f\u001a\u00020\u0017J\u0012\u0010&\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020'0\u00160#J\u0012\u0010(\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020)0\u00160#J\u0012\u0010*\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020)0\u00160#J\u001f\u0010+\u001a\u0008\u0012\u0004\u0012\u00020,0\u00162\u0006\u0010\u001f\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0019\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010-J\u001c\u00103\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020)0\u00160#2\u0006\u00104\u001a\u00020\u0017H\u0002J\u0012\u00105\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020'0\u00160#J&\u00106\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020'0\u00160#2\u0006\u00107\u001a\u00020\u00172\n\u0008\u0002\u00108\u001a\u0004\u0018\u00010\u0017J\u0019\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010=J\u0016\u0010>\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0017J\u0010\u0010?\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u000e\u0010@\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0017J\u0018\u0010A\u001a\u0008\u0012\u0004\u0012\u00020)0\u0016*\u0008\u0012\u0004\u0012\u00020)0\u0016H\u0002R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u00168F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006C", d2 = {"Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "trickKnowledgeDao", "Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;", "workoutEntityDao", "Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;", "tricksDao", "Lapp/dogo/android/persistencedb/room/dao/TrickEntityDao;", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;Lapp/dogo/android/persistencedb/room/dao/TrickEntityDao;Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/tracking/Tracker;Lkotlinx/coroutines/CoroutineDispatcher;)V", "disabledClickerForTricksList", "", "", "getDisabledClickerForTricksList", "()Ljava/util/List;", "knowledgeSyncState", "Lapp/dogo/com/dogo_android/util/SimpleSessionCache;", "", "cacheKnowledgeResponse", "Lio/reactivex/Completable;", "dogId", "tricks", "Lapp/dogo/externalmodel/model/TrickKnowledgeEvent;", "getAllTrickKnowledge", "Lio/reactivex/Single;", "", "", "getAllTrickModels", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "getAllTricks", "Lapp/dogo/android/persistencedb/room/relations/TrickFullEntity;", "getBitingProgramTricks", "getRecentlyViewedTricks", "Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrick", "trickId", "getTrickCategory", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickCategory;", "categoryId", "getTricksByTag", "tagId", "getTricksData", "getTricksWithCategoryAndTag", "category", "trickTag", "saveTrickKnowledge", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults;", "rating", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;", "(Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTrickView", "syncDogKnowledgeFromRemote", "syncDogKnowledgeIfNeeded", "applyTrickOverrides", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o1 {

    public static final app.dogo.com.dogo_android.s.b.o1.a Companion;
    private final p2 a;
    private final r2 b;
    private final o0 c;
    private final s0 d;
    private final m0 e;
    private final DogoApiClient f;
    private final v2 g;
    private final o3 h;
    private final h0 i;
    private final z<Boolean> j;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/repository/local/TricksRepository$Companion;", "", "()V", "BITING_TRICK_TAG_ID", "", "CLICKER_ID", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class d implements Comparator {
        public final int compare(T t, T t2) {
            int intValue;
            int obj2;
            obj2 = (TrickModel)t.getSortOrder();
            if (obj2 == null) {
                obj2 = intValue;
            } else {
                obj2 = obj2.intValue();
            }
            Integer obj3 = (TrickModel)t2.getSortOrder();
            if (obj3 == null) {
            } else {
                intValue = obj3.intValue();
            }
            return a.c(Integer.valueOf(obj2), Integer.valueOf(intValue));
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TricksRepository", f = "TricksRepository.kt", l = 91, m = "getTrick")
    static final class b extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.o1 this$0;
        b(app.dogo.com.dogo_android.s.b.o1 o1, d<? super app.dogo.com.dogo_android.s.b.o1.b> d2) {
            this.this$0 = o1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.o(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TricksRepository", f = "TricksRepository.kt", l = 79, m = "getTrickCategory")
    static final class c extends d {

        int label;
        Object result;
        final app.dogo.com.dogo_android.s.b.o1 this$0;
        c(app.dogo.com.dogo_android.s.b.o1 o1, d<? super app.dogo.com.dogo_android.s.b.o1.c> d2) {
            this.this$0 = o1;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.p(0, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TricksRepository$saveTrickKnowledge$2", f = "TricksRepository.kt", l = {111, 121, 133}, m = "invokeSuspend")
    static final class e extends k implements p<m0, d<? super i>, Object> {

        final h $rating;
        int label;
        final app.dogo.com.dogo_android.s.b.o1 this$0;
        e(h h, app.dogo.com.dogo_android.s.b.o1 o12, d<? super app.dogo.com.dogo_android.s.b.o1.e> d3) {
            this.$rating = h;
            this.this$0 = o12;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super i> d2) {
            return (o1.e)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            o1.e obj3 = new o1.e(this.$rating, this.this$0, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            i cVar;
            int label;
            int saveTrickKnowledgeRequest;
            int i3;
            int i4;
            int i2;
            int i;
            String str2;
            String str;
            String str3;
            SaveProgramTrickKnowledgeRequest saveProgramTrickKnowledgeRequest;
            Object obj12;
            Object obj = b.d();
            label = this.label;
            saveTrickKnowledgeRequest = 3;
            i3 = 2;
            i4 = 1;
            if (label != 0) {
                if (label != i4) {
                    if (label != i3) {
                        if (label != saveTrickKnowledgeRequest) {
                        } else {
                            q.b(object);
                            cVar = new i.b((ClassicProgramCombinedResponse)obj12);
                        }
                        obj12 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj12;
                    }
                    q.b(object);
                    cVar = new i.a((BitingProgramCombinedResponse)obj12);
                } else {
                    q.b(object);
                    cVar = new i.c((GetTrickKnowledgeResponse)obj12);
                }
                o1.a(this.this$0, this.$rating.a(), cVar.a()).e();
                o1.c(this.this$0).g(this.$rating.a()).e();
                return cVar;
            } else {
                q.b(object);
                obj12 = this.$rating;
                if (obj12 instanceof h.c) {
                    saveTrickKnowledgeRequest = new SaveTrickKnowledgeRequest(this.$rating.c(), this.$rating.b());
                    this.label = i4;
                    if (o1.b(this.this$0).saveTrickKnowledge(this.$rating.a(), saveTrickKnowledgeRequest, this) == obj) {
                        return obj;
                    }
                } else {
                    if (obj12 instanceof h.a) {
                        if (i4 ^= z3 != 0) {
                            i4 = (h.a)this.$rating.d();
                        } else {
                            i4 = 0;
                        }
                        saveTrickKnowledgeRequest = new SaveSpecialProgramTrickKnowledgeRequest(this.$rating.c(), this.$rating.b(), "id_nipping_program", i4);
                        this.label = i3;
                        if (o1.b(this.this$0).saveBitingProgramKnowledge(this.$rating.a(), saveTrickKnowledgeRequest, this) == obj) {
                            return obj;
                        }
                    } else {
                        if (!obj12 instanceof h.b) {
                        } else {
                            super(this.$rating.c(), this.$rating.b(), (h.b)this.$rating.f(), (h.b)this.$rating.e(), (h.b)this.$rating.d());
                            this.label = saveTrickKnowledgeRequest;
                            if (o1.b(this.this$0).saveClassicProgramTrickKnowledge(this.$rating.a(), (h.b)this.$rating.f(), saveProgramTrickKnowledgeRequest, this) == obj) {
                                return obj;
                            }
                        }
                    }
                }
            }
            obj12 = new NoWhenBranchMatchedException();
            throw obj12;
        }
    }
    static {
        o1.a aVar = new o1.a(0);
        o1.Companion = aVar;
    }

    public o1(p2 p2, r2 r22, o0 o03, s0 s04, m0 m05, DogoApiClient dogoApiClient6, v2 v27, o3 o38, h0 h09) {
        n.f(p2, "preferenceService");
        n.f(r22, "remoteConfigService");
        n.f(o03, "trickKnowledgeDao");
        n.f(s04, "workoutEntityDao");
        n.f(m05, "tricksDao");
        n.f(dogoApiClient6, "apiClient");
        n.f(v27, "timeUtils");
        n.f(o38, "tracker");
        n.f(h09, "dispatcher");
        super();
        this.a = p2;
        this.b = r22;
        this.c = o03;
        this.d = s04;
        this.e = m05;
        this.f = dogoApiClient6;
        this.g = v27;
        this.h = o38;
        this.i = h09;
        z obj2 = new z(-1, o03);
        this.j = obj2;
    }

    public o1(p2 p2, r2 r22, o0 o03, s0 s04, m0 m05, DogoApiClient dogoApiClient6, v2 v27, o3 o38, h0 h09, int i10, g g11) {
        h0 i;
        h0 h0Var;
        if (i2 &= 256 != 0) {
            h0Var = i;
        } else {
            h0Var = h09;
        }
        super(p2, r22, o03, s04, m05, dogoApiClient6, v27, o38, h0Var);
    }

    public static List A(List list) {
        return o1.t(list);
    }

    public static List B(String string, String string2, List list3) {
        return o1.v(string, string2, list3);
    }

    public static List C(List list) {
        return o1.i(list);
    }

    public static void D(app.dogo.com.dogo_android.s.b.o1 o1, String string2, d d3) {
        o1.J(o1, string2, d3);
    }

    private final b G(String string) {
        c0 c0Var = new c0(this, string);
        final b obj3 = this.f.fetchTricksKnowledgeSingle(string).flatMapCompletable(c0Var);
        n.e(obj3, "apiClient.fetchTricksKnowledgeSingle(dogId).flatMapCompletable { remoteKnowledge ->\n            tracker.setUserProperty(UserProperty.TricksRated, remoteKnowledge.tricks.size)\n            cacheKnowledgeResponse(dogId, remoteKnowledge.tricks)\n        }");
        return obj3;
    }

    private static final f H(app.dogo.com.dogo_android.s.b.o1 o1, String string2, GetTrickKnowledgeResponse getTrickKnowledgeResponse3) {
        n.f(o1, "this$0");
        n.f(string2, "$dogId");
        n.f(getTrickKnowledgeResponse3, "remoteKnowledge");
        o1.h.q(q3.TricksRated, Integer.valueOf(getTrickKnowledgeResponse3.getTricks().size()));
        return o1.e(string2, getTrickKnowledgeResponse3.getTricks());
    }

    private static final void J(app.dogo.com.dogo_android.s.b.o1 o1, String string2, d d3) {
        n.f(o1, "this$0");
        n.f(string2, "$dogId");
        n.f(d3, "it");
        o1.j.f(string2, 0, obj1);
    }

    public static final b a(app.dogo.com.dogo_android.s.b.o1 o1, String string2, List list3) {
        return o1.e(string2, list3);
    }

    public static final DogoApiClient b(app.dogo.com.dogo_android.s.b.o1 o1) {
        return o1.f;
    }

    public static final s0 c(app.dogo.com.dogo_android.s.b.o1 o1) {
        return o1.d;
    }

    private final List<g> d(List<g> list) {
        Iterable iterable;
        Object obj;
        boolean copy$default;
        String trickId;
        int i;
        int i10;
        int i20;
        int i18;
        int i6;
        int i14;
        int i13;
        int i5;
        int i3;
        int i7;
        int i16;
        int i9;
        int i8;
        int i2;
        int i15;
        int i19;
        int i4;
        int i11;
        int i12;
        int i17;
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            obj = next2;
            if (empty ^= 1 != 0) {
            } else {
            }
            iterable = this;
            arrayList.add(obj);
            if (iterable.b.k().contains(obj.d().getTrickId())) {
            }
            i = 0;
            i10 = 0;
            i20 = 0;
            i6 = 0;
            obj = g.b(obj, TrickEntity.copy$default(obj.d(), i, i10, i20, 0, i6, 0, 0, 0, false, false, 0, obj17, 0, 0, 0, 0, 0, 0, 0, 260095), p.g(), i, i10, i20, 28, i6);
        }
        Object obj2 = this;
        return arrayList;
    }

    private final b e(String string, List<TrickKnowledgeEvent> list2) {
        int rateDataFormTrickKnowledgeEvent;
        TrickProgressEntity.Companion companion;
        ArrayList arrayList = new ArrayList(p.r(list2, 10));
        final Iterator obj6 = list2.iterator();
        for (TrickKnowledgeEvent next2 : obj6) {
            arrayList.add(TrickProgressEntity.Companion.rateDataFormTrickKnowledgeEvent(string, next2));
        }
        return this.c.b(arrayList);
    }

    private static final Map g(List list) {
        int valueOf;
        o oVar;
        String trickId;
        n.f(list, "trickList");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator obj4 = list.iterator();
        for (TrickProgressEntity next2 : obj4) {
            oVar = new o(next2.getTrickId(), Integer.valueOf(next2.getKnowledge()));
            arrayList.add(oVar);
        }
        return j0.s(arrayList);
    }

    private static final List i(List list) {
        int i;
        n.f(list, "it");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        final Iterator obj2 = list.iterator();
        for (g next2 : obj2) {
            arrayList.add(m1.H(next2));
        }
        return arrayList;
    }

    private static final List k(app.dogo.com.dogo_android.s.b.o1 o1, List list2) {
        n.f(o1, "this$0");
        n.f(list2, "it");
        return o1.d(list2);
    }

    private final a0<List<g>> q(String string) {
        f0 f0Var = new f0(string);
        final a0 obj3 = j().map(f0Var);
        n.e(obj3, "getAllTricks().map { list ->\n            list.filter { article -> article.tags.any { it.tagId == tagId } }\n        }");
        return obj3;
    }

    private static final List r(String string, List list2) {
        Object next;
        List iterator;
        boolean empty;
        int i;
        n.f(string, "$tagId");
        n.f(list2, "list");
        ArrayList arrayList = new ArrayList();
        final Iterator obj6 = list2.iterator();
        while (obj6.hasNext()) {
            next = obj6.next();
            iterator = (g)next.c();
            i = 0;
            if (iterator instanceof Collection != null && iterator.isEmpty()) {
            } else {
            }
            iterator = iterator.iterator();
            while (iterator.hasNext()) {
                if (n.b((TrickTagEntity)iterator.next().getTagId(), string)) {
                    break loop_6;
                } else {
                }
            }
            if (i != 0) {
            }
            arrayList.add(next);
            if (n.b((TrickTagEntity)iterator.next().getTagId(), string)) {
            } else {
            }
            i = 1;
            if (iterator.isEmpty()) {
            } else {
            }
        }
        return arrayList;
    }

    private static final List t(List list) {
        int i2;
        boolean next;
        boolean z;
        int i;
        int i3;
        n.f(list, "tricks");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator obj5 = list.iterator();
        for (g next3 : obj5) {
            arrayList.add(m1.H(next3));
        }
        obj5 = new ArrayList();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            z = next;
            i3 = 1;
            if (empty2 ^= i3 == 0) {
            }
            if (i3 != 0) {
            }
            obj5.add(next);
            if (empty ^= i3 != 0) {
            } else {
            }
            i3 = 0;
        }
        o1.d dVar = new o1.d();
        return p.D0(obj5, dVar);
    }

    private static final List v(String string, String string2, List list3) {
        ArrayList arrayList;
        Object next;
        boolean contains;
        int i;
        Object arrayList2;
        int next2;
        int i2;
        n.f(string, "$category");
        n.f(list3, "tricks");
        arrayList = new ArrayList();
        Iterator obj7 = list3.iterator();
        i = 1;
        while (obj7.hasNext()) {
            next = obj7.next();
            if (z ^= i != 0) {
            }
            if (i != 0) {
            }
            i = 1;
            arrayList.add(next);
            i = n.b((TrickModel)next.getCategory().getId(), string);
        }
        ArrayList obj5 = new ArrayList();
        obj7 = arrayList.iterator();
        while (obj7.hasNext()) {
            arrayList = obj7.next();
            if (string2 != null) {
            } else {
            }
            contains = i;
            if (contains) {
            }
            obj5.add(arrayList);
            List tags = (TrickModel)arrayList.getTags();
            arrayList2 = new ArrayList(p.r(tags, 10));
            Iterator iterator = tags.iterator();
            for (TrickModel.TrickTag next4 : iterator) {
                arrayList2.add(next4.getId());
            }
            contains = arrayList2.contains(string2);
            arrayList2.add((TrickModel.TrickTag)iterator.next().getId());
        }
        return obj5;
    }

    public static f w(app.dogo.com.dogo_android.s.b.o1 o1, String string2, GetTrickKnowledgeResponse getTrickKnowledgeResponse3) {
        return o1.H(o1, string2, getTrickKnowledgeResponse3);
    }

    public static List x(app.dogo.com.dogo_android.s.b.o1 o1, List list2) {
        return o1.k(o1, list2);
    }

    public static Map y(List list) {
        return o1.g(list);
    }

    public static List z(String string, List list2) {
        return o1.r(string, list2);
    }

    public final Object E(h h, d<? super i> d2) {
        o1.e eVar = new o1.e(h, this, 0);
        return k.e(this.i, eVar, d2);
    }

    public final b F(String string, String string2) {
        n.f(string, "dogId");
        n.f(string2, "trickId");
        final long l2 = this.g.g();
        final TrickProgressEntity.TrickKnowledgeViewData[] arr = new TrickProgressEntity.TrickKnowledgeViewData[1];
        super(string2, string, l2, obj5, l2, obj7);
        return this.c.i(trickKnowledgeViewData);
    }

    public final b I(String string) {
        String str;
        Object j0Var;
        b obj4;
        n.f(string, "dogId");
        if (!n.b(this.j.a(string, 0), Boolean.TRUE)) {
            j0Var = new j0(this, string);
            n.e(G(string).c(j0Var), "{\n            syncDogKnowledgeFromRemote(dogId).andThen {\n                knowledgeSyncState.setData(dogId, 0, true)\n            }\n        }");
        } else {
            n.e(b.f(), "{\n            Completable.complete()\n        }");
        }
        return obj4;
    }

    public final a0<Map<String, Integer>> f(String string) {
        n.f(string, "dogId");
        a0 obj3 = I(string).d(this.c.d(string).map(e0.a));
        n.e(obj3, "syncDogKnowledgeIfNeeded(dogId).andThen(\n            trickKnowledgeDao.getAllDogTrickKnowledge(dogId).map { trickList ->\n                trickList.map { Pair(it.trickId, it.knowledge) }.toMap()\n            }\n        )");
        return obj3;
    }

    public final a0<List<TrickModel>> h() {
        a0 a0Var2 = j().map(i0.a);
        n.e(a0Var2, "getAllTricks().map { it.map { trick -> trick.toTrickModel() } }");
        return a0Var2;
    }

    public final a0<List<g>> j() {
        d0 d0Var = new d0(this);
        a0 a0Var2 = this.e.y(n2.a.a(this.a.W())).map(d0Var);
        n.e(a0Var2, "tricksDao.getAllLocalisedTricks(correctedLocale).map { it.applyTrickOverrides() }");
        return a0Var2;
    }

    public final a0<List<g>> l() {
        return q("id_exercise_biting");
    }

    public final List<String> m() {
        return this.b.L();
    }

    public final Object n(String string, d<? super List<TrickProgressEntity>> d2) {
        return this.c.c(string, (int)l, d2);
    }

    public final Object o(String string, d<? super g> d2) {
        boolean bVar;
        int label;
        int i;
        int label2;
        int i2;
        Object obj5;
        Object obj6;
        bVar = d2;
        label = bVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof o1.b && label & i != 0) {
            bVar = d2;
            label = bVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                bVar.label = label -= i;
            } else {
                bVar = new o1.b(this, d2);
            }
        } else {
        }
        obj6 = bVar.result;
        Object obj = b.d();
        label2 = bVar.label;
        int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                obj5 = bVar.L$0;
                q.b(obj6);
                return p.X(obj5.d((List)obj6));
            }
            obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj6);
        bVar.L$0 = this;
        bVar.label = i3;
        if (this.e.t(n2.a.a(this.a.W()), string, bVar) == obj) {
            return obj;
        }
        obj5 = this;
    }

    public final Object p(String string, d<? super TrickModel.TrickCategory> d2) {
        boolean cVar;
        int label;
        int i;
        int label2;
        int i2;
        Object obj6;
        cVar = d2;
        label = cVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof o1.c && label & i != 0) {
            cVar = d2;
            label = cVar.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                cVar.label = label -= i;
            } else {
                cVar = new o1.c(this, d2);
            }
        } else {
        }
        obj6 = cVar.result;
        Object obj = b.d();
        label2 = cVar.label;
        int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                q.b(obj6);
                return m1.u((TrickCategoryEntity)obj6);
            }
            IllegalStateException obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj6);
        cVar.label = i3;
        if (this.e.o(string, n2.a.a(this.a.W()), cVar) == obj) {
            return obj;
        }
    }

    public final a0<List<TrickModel>> s() {
        a0 a0Var2 = j().map(g0.a);
        n.e(a0Var2, "getAllTricks().map { tricks ->\n            tricks.map { it.toTrickModel() }.filter { it.trickSteps.isNotEmpty() || it.videoSteps.isNotEmpty() }.sortedBy {\n                it.sortOrder ?: Int.MAX_VALUE\n            }\n        }");
        return a0Var2;
    }

    public final a0<List<TrickModel>> u(String string, String string2) {
        n.f(string, "category");
        h0 h0Var = new h0(string, string2);
        final a0 obj3 = s().map(h0Var);
        n.e(obj3, "getTricksData().map { tricks ->\n            tricks\n                .filter { if (category.isNotBlank()) it.category.id == category else true }\n                .filter { if (trickTag != null) trickTag in it.tags.map { tag -> tag.id } else true }\n        }");
        return obj3;
    }
}
