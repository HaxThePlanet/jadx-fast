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
import e.a.a.a.b.b.o0;
import e.a.a.a.b.b.s0;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.o;
import kotlin.q;
import kotlin.w;
import kotlin.y.j0;
import kotlin.z.a;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;

/* compiled from: TricksRepository.kt */
@Metadata(d1 = "\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u0000 B2\u00020\u0001:\u0001BBO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u001e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u000c\u0010 \u001a\u0008\u0012\u0004\u0012\u00020!0\u0016H\u0002J \u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020%0$0#2\u0006\u0010\u001f\u001a\u00020\u0017J\u0012\u0010&\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020'0\u00160#J\u0012\u0010(\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020)0\u00160#J\u0012\u0010*\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020)0\u00160#J\u001f\u0010+\u001a\u0008\u0012\u0004\u0012\u00020,0\u00162\u0006\u0010\u001f\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0019\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010-J\u0019\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0017H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010-J\u001c\u00103\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020)0\u00160#2\u0006\u00104\u001a\u00020\u0017H\u0002J\u0012\u00105\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020'0\u00160#J&\u00106\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020'0\u00160#2\u0006\u00107\u001a\u00020\u00172\n\u0008\u0002\u00108\u001a\u0004\u0018\u00010\u0017J\u0019\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010=J\u0016\u0010>\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u0017J\u0010\u0010?\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u000e\u0010@\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0017J\u0018\u0010A\u001a\u0008\u0012\u0004\u0012\u00020)0\u0016*\u0008\u0012\u0004\u0012\u00020)0\u0016H\u0002R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u00168F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\u0008\u0012\u0004\u0012\u00020\u001c0\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006C", d2 = {"Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "", "preferenceService", "Lapp/dogo/com/dogo_android/service/PreferenceService;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "trickKnowledgeDao", "Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;", "workoutEntityDao", "Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;", "tricksDao", "Lapp/dogo/android/persistencedb/room/dao/TrickEntityDao;", "apiClient", "Lapp/dogo/android/network/DogoApiClient;", "timeUtils", "Lapp/dogo/com/dogo_android/service/Utilities;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/service/PreferenceService;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/android/persistencedb/room/dao/TrickKnowledgeDao;Lapp/dogo/android/persistencedb/room/dao/WorkoutEntityDao;Lapp/dogo/android/persistencedb/room/dao/TrickEntityDao;Lapp/dogo/android/network/DogoApiClient;Lapp/dogo/com/dogo_android/service/Utilities;Lapp/dogo/com/dogo_android/tracking/Tracker;Lkotlinx/coroutines/CoroutineDispatcher;)V", "disabledClickerForTricksList", "", "", "getDisabledClickerForTricksList", "()Ljava/util/List;", "knowledgeSyncState", "Lapp/dogo/com/dogo_android/util/SimpleSessionCache;", "", "cacheKnowledgeResponse", "Lio/reactivex/Completable;", "dogId", "tricks", "Lapp/dogo/externalmodel/model/TrickKnowledgeEvent;", "getAllTrickKnowledge", "Lio/reactivex/Single;", "", "", "getAllTrickModels", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel;", "getAllTricks", "Lapp/dogo/android/persistencedb/room/relations/TrickFullEntity;", "getBitingProgramTricks", "getRecentlyViewedTricks", "Lapp/dogo/android/persistencedb/room/entity/TrickProgressEntity;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTrick", "trickId", "getTrickCategory", "Lapp/dogo/com/dogo_android/model/trainingprogram/TrickModel$TrickCategory;", "categoryId", "getTricksByTag", "tagId", "getTricksData", "getTricksWithCategoryAndTag", "category", "trickTag", "saveTrickKnowledge", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults;", "rating", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;", "(Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRating;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveTrickView", "syncDogKnowledgeFromRemote", "syncDogKnowledgeIfNeeded", "applyTrickOverrides", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o1, reason: from kotlin metadata */
public final class TricksRepository {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final o1.a INSTANCE = new o1$a(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final p2 apiClient;
    private final r2 b;
    /* renamed from: c, reason: from kotlin metadata */
    private final o0 dispatcher;
    /* renamed from: d, reason: from kotlin metadata */
    private final s0 knowledgeSyncState;
    /* renamed from: e, reason: from kotlin metadata */
    private final e.a.a.a.b.b.m0 preferenceService;
    /* renamed from: f, reason: from kotlin metadata */
    private final DogoApiClient remoteConfigService;
    /* renamed from: g, reason: from kotlin metadata */
    private final v2 timeUtils;
    /* renamed from: h, reason: from kotlin metadata */
    private final o3 tracker;
    /* renamed from: i, reason: from kotlin metadata */
    private final h0 trickKnowledgeDao;
    /* renamed from: j, reason: from kotlin metadata */
    private final z<Boolean> tricksDao;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/repository/local/TricksRepository$Companion;", "", "()V", "BITING_TRICK_TAG_ID", "", "CLICKER_ID", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class d<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int value = 2147483647;
            Integer sortOrder = t.getSortOrder();
            value = Integer.MAX_VALUE;
            if (sortOrder == null) {
            } else {
                value = sortOrder.intValue();
            }
            Integer sortOrder2 = t2.getSortOrder();
            if (sortOrder2 != null) {
                value = sortOrder2.intValue();
            }
            return a.c(Integer.valueOf(value), Integer.valueOf(value));
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TricksRepository", f = "TricksRepository.kt", l = 91, m = "getTrick")
    static final class b extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super o1.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return o1.this.o(null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TricksRepository", f = "TricksRepository.kt", l = 79, m = "getTrickCategory")
    static final class c extends kotlin.b0.k.a.d {

        int label;
        /* synthetic */ Object result;
        c(kotlin.b0.d<? super o1.c> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return o1.this.p(null, this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/library/tricks/rate/TrickRatingResults;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.local.TricksRepository$saveTrickKnowledge$2", f = "TricksRepository.kt", l = {111, 121, 133}, m = "invokeSuspend")
    static final class e extends kotlin.b0.k.a.k implements kotlin.d0.c.p<kotlinx.coroutines.m0, kotlin.b0.d<? super i>, Object> {

        final /* synthetic */ h $rating;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) throws NoWhenBranchMatchedException {
            i.c trickRatingResults_Library;
            int label2;
            int i = 3;
            int i2 = 2;
            int i3 = 1;
            String str = null;
            int i4;
            String str2;
            String str3;
            int i5;
            String str4;
            String str5;
            String str6;
            SaveProgramTrickKnowledgeRequest saveProgramTrickKnowledgeRequest;
            GetTrickKnowledgeResponse getTrickKnowledgeResponse;
            app.dogo.externalmodel.model.responses.ClassicProgramCombinedResponse classicProgramCombinedResponse;
            app.dogo.externalmodel.model.responses.BitingProgramCombinedResponse bitingProgramCombinedResponse;
            Object obj = b.d();
            i = 3;
            i2 = 2;
            i3 = 1;
            if (this.label != 0) {
                if (this.label != i3) {
                    if (this.label != i2) {
                        if (this.label != i) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(object);
                            i.b trickRatingResults_ClassicProgram = new TrickRatingResults_ClassicProgram((ClassicProgramCombinedResponse)classicProgramCombinedResponse);
                        }
                    }
                    q.b(object);
                    i.a trickRatingResults_BitingProgram = new TrickRatingResults_BitingProgram((BitingProgramCombinedResponse)bitingProgramCombinedResponse);
                } else {
                    q.b(object);
                    trickRatingResults_Library = new TrickRatingResults_Library((GetTrickKnowledgeResponse)getTrickKnowledgeResponse);
                }
                o1.this.cacheKnowledgeResponse(this.$rating.a(), trickRatingResults_Library.getTrickKnowledge()).e();
                o1.this.knowledgeSyncState.getDogWorkoutInfo(this.$rating.a()).e();
                return trickRatingResults_Library;
            } else {
                q.b(object);
                if ($rating218 instanceof TrickRating_Library) {
                    this.label = i3;
                    if (o1.this.remoteConfigService.saveTrickKnowledge(this.$rating.a(), new SaveTrickKnowledgeRequest(this.$rating.c(), this.$rating.b()), this) == obj) {
                        return obj;
                    }
                } else {
                    if ($rating218 instanceof TrickRating_BitingProgram) {
                        if (i3 ^ l.z((TrickRating_BitingProgram)this.$rating.d()) != 0) {
                            str = (TrickRating_BitingProgram)this.$rating.d();
                        } else {
                            int i7 = 0;
                        }
                        str4 = "id_nipping_program";
                        SaveSpecialProgramTrickKnowledgeRequest saveSpecialProgramTrickKnowledgeRequest = new SaveSpecialProgramTrickKnowledgeRequest(this.$rating.c(), this.$rating.b(), str4, str);
                        this.label = i2;
                        if (o1.this.remoteConfigService.saveBitingProgramKnowledge(this.$rating.a(), saveSpecialProgramTrickKnowledgeRequest, this) == obj) {
                            return obj;
                        }
                    } else {
                        if ($rating218 instanceof TrickRating_ClassicProgram) {
                            saveProgramTrickKnowledgeRequest = new SaveProgramTrickKnowledgeRequest(this.$rating.c(), this.$rating.b(), (TrickRating_ClassicProgram)this.$rating.f(), (TrickRating_ClassicProgram)this.$rating.e(), (TrickRating_ClassicProgram)this.$rating.d());
                            this.label = i;
                            if (o1.this.remoteConfigService.saveClassicProgramTrickKnowledge(this.$rating.a(), (TrickRating_ClassicProgram)this.$rating.f(), saveProgramTrickKnowledgeRequest, this) == obj) {
                                return obj;
                            }
                        }
                    }
                }
            }
            throw new NoWhenBranchMatchedException();
        }

        e(h hVar, o1 o1Var, kotlin.b0.d<? super o1.e> dVar) {
            this.$rating = hVar;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(kotlinx.coroutines.m0 m0Var, kotlin.b0.d<? super i> dVar) {
            return (app.dogo.com.dogo_android.repository.local.o1.e)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new app.dogo.com.dogo_android.repository.local.o1.e(this.$rating, o1.this, dVar);
        }
    }
    public o1(p2 p2Var, r2 r2Var, o0 o0Var, s0 s0Var, e.a.a.a.b.b.m0 m0Var, DogoApiClient dogoApiClient, v2 v2Var, o3 o3Var, h0 h0Var) {
        n.f(p2Var, "preferenceService");
        n.f(r2Var, "remoteConfigService");
        n.f(o0Var, "trickKnowledgeDao");
        n.f(s0Var, "workoutEntityDao");
        n.f(m0Var, "tricksDao");
        n.f(dogoApiClient, "apiClient");
        n.f(v2Var, "timeUtils");
        n.f(o3Var, "tracker");
        n.f(h0Var, "dispatcher");
        super();
        this.apiClient = p2Var;
        this.b = r2Var;
        this.dispatcher = o0Var;
        this.knowledgeSyncState = s0Var;
        this.preferenceService = m0Var;
        this.remoteConfigService = dogoApiClient;
        this.timeUtils = v2Var;
        this.tracker = o3Var;
        this.trickKnowledgeDao = h0Var;
        this.tricksDao = new SimpleSessionCache(-1L, o0Var);
    }

    /* renamed from: G, reason: from kotlin metadata */
    /* suspend */ private final i.b.b getTrick(String trickId) {
        final i.b.b flatMapCompletable = this.remoteConfigService.fetchTricksKnowledgeSingle(trickId).flatMapCompletable(new app.dogo.com.dogo_android.repository.local.c0(this, trickId));
        n.e(flatMapCompletable, "apiClient.fetchTricksKnowledgeSingle(dogId).flatMapCompletable { remoteKnowledge ->\n            tracker.setUserProperty(UserProperty.TricksRated, remoteKnowledge.tricks.size)\n            cacheKnowledgeResponse(dogId, remoteKnowledge.tricks)\n        }");
        return flatMapCompletable;
    }

    private static final i.b.f H(o1 o1Var, String str, GetTrickKnowledgeResponse getTrickKnowledgeResponse) {
        n.f(o1Var, "this$0");
        n.f(str, "$dogId");
        n.f(getTrickKnowledgeResponse, "remoteKnowledge");
        o1Var.tracker.setUserProperty(UserProperty.TricksRated, Integer.valueOf(getTrickKnowledgeResponse.getTricks().size()));
        return o1Var.cacheKnowledgeResponse(str, getTrickKnowledgeResponse.getTricks());
    }

    private static final void J(o1 o1Var, String str, i.b.d dVar) {
        n.f(o1Var, "this$0");
        n.f(str, "$dogId");
        n.f(dVar, "it");
        o1Var.tricksDao.setData(str, 0L, Boolean.TRUE);
    }

    public static final /* synthetic */ i.b.b a(o1 o1Var, String str, List list) {
        return o1Var.cacheKnowledgeResponse(str, list);
    }

    /* renamed from: b, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ DogoApiClient getTrickCategory(o1 categoryId) {
        return categoryId.remoteConfigService;
    }

    /* renamed from: c, reason: from kotlin metadata */
    public static final /* synthetic */ s0 getTricksByTag(o1 tagId) {
        return tagId.knowledgeSyncState;
    }

    /* renamed from: d, reason: from kotlin metadata */
    /* suspend */ private final List<e.a.a.a.b.d.g> saveTrickKnowledge(List<e.a.a.a.b.d.g> rating) {
        Iterable rating2;
        e.a.a.a.b.d.g gVar;
        boolean contains;
        String trickId;
        TrickEntity trickEntity;
        String str;
        String str2;
        int i;
        String str3;
        String str4;
        String str5;
        Integer num;
        Integer num2;
        boolean z;
        boolean z2;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        List list;
        List list2;
        int i2;
        Object obj;
        final ArrayList arrayList = new ArrayList(p.r(rating, 10));
        Iterator it = rating.iterator();
        while (it.hasNext()) {
            gVar = it.next();
            arrayList.add(gVar);
        }
        return arrayList;
    }

    /* renamed from: e, reason: from kotlin metadata */
    private final i.b.b cacheKnowledgeResponse(String dogId, List<TrickKnowledgeEvent> tricks) {
        final ArrayList arrayList = new ArrayList(p.r(tricks, 10));
        final Iterator it = tricks.iterator();
        while (it.hasNext()) {
            arrayList.add(TrickProgressEntity.INSTANCE.rateDataFormTrickKnowledgeEvent(dogId, (TrickKnowledgeEvent)it.next()));
        }
        return this.dispatcher.insertTrickKnowledge(arrayList);
    }

    /* renamed from: g, reason: from kotlin metadata */
    private static final Map syncDogKnowledgeFromRemote(List dogId) {
        n.f(dogId, "trickList");
        ArrayList arrayList = new ArrayList(p.r(dogId, 10));
        Iterator it = dogId.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            arrayList.add(new Pair(item.getTrickId(), Integer.valueOf(item.getKnowledge())));
        }
        return j0.s(arrayList);
    }

    /* renamed from: i, reason: from kotlin metadata */
    private static final List syncDogKnowledgeIfNeeded(List dogId) {
        n.f(dogId, "it");
        ArrayList arrayList = new ArrayList(p.r(dogId, 10));
        final Iterator it = dogId.iterator();
        while (it.hasNext()) {
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.toTrickItem((TrickFullEntity)it.next()));
        }
        return arrayList;
    }

    /* renamed from: k, reason: from kotlin metadata */
    private static final List getTricksWithCategoryAndTag(o1 category, List trickTag) {
        n.f(category, "this$0");
        n.f(trickTag, "it");
        return category.saveTrickKnowledge(trickTag);
    }

    private final a0<List<e.a.a.a.b.d.g>> q(String str) {
        final a0 map = j().map(new app.dogo.com.dogo_android.repository.local.f0(str));
        n.e(map, "getAllTricks().map { list ->\n            list.filter { article -> article.tags.any { it.tagId == tagId } }\n        }");
        return map;
    }

    /* renamed from: r, reason: from kotlin metadata */
    private static final List saveTrickView(String dogId, List trickId) {
        List component1;
        boolean hasNext;
        int i = 0;
        n.f(dogId, "$tagId");
        n.f(trickId, "list");
        ArrayList arrayList = new ArrayList();
        final Iterator it2 = trickId.iterator();
        while (it2.hasNext()) {
            Object item = it2.next();
            component1 = (TrickFullEntity)item.component1();
            hasNext = component1 instanceof Collection;
            i = 0;
        }
        return arrayList;
    }

    private static final List t(List list) {
        Object item;
        int i3 = 1;
        n.f(list, "tricks");
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.m1.toTrickItem((TrickFullEntity)it2.next()));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            item = it.next();
            i3 = 1;
            i2 = item.getTrickSteps().isEmpty() ^ i3;
        }
        return p.D0(arrayList2, new app.dogo.com.dogo_android.repository.local.o1.d());
    }

    private static final List v(String str, String str2, List list) {
        boolean hasNext;
        int i = 1;
        Object item;
        ArrayList arrayList2;
        int i2;
        boolean hasNext2;
        n.f(str, "$category");
        n.f(list, "tricks");
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        i = 1;
        while (it2.hasNext()) {
            item = it2.next();
            i2 = l.z(str) ^ i;
        }
        final ArrayList arrayList3 = new ArrayList();
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            arrayList = it3.next();
        }
        return arrayList3;
    }

    public final Object E(h hVar, kotlin.b0.d<? super i> dVar) {
        return kotlinx.coroutines.internal.k.e(this.trickKnowledgeDao, new app.dogo.com.dogo_android.repository.local.o1.e(hVar, this, null), dVar);
    }

    public final i.b.b F(String str, String str2) {
        n.f(str, "dogId");
        n.f(str2, "trickId");
        final long l = this.timeUtils.g();
        final TrickProgressEntity.TrickKnowledgeViewData[] arr = new TrickProgressEntity.TrickKnowledgeViewData[1];
        TrickProgressEntity_TrickKnowledgeViewData trickProgressEntity_TrickKnowledgeViewData = new TrickProgressEntity_TrickKnowledgeViewData(str2, str, l, l2, l, obj);
        return this.dispatcher.updateTrickKnowledge(trickProgressEntity_TrickKnowledgeViewData);
    }

    public final i.b.b I(String str) {
        i.b.b bVar;
        n.f(str, "dogId");
        if (!n.b(this.tricksDao.getData(str, 0L), Boolean.TRUE)) {
            str2 = "{\n            syncDogKnowledgeFromRemote(dogId).andThen {\n                knowledgeSyncState.setData(dogId, 0, true)\n            }\n        }";
            n.e(getTrick(str).c(new app.dogo.com.dogo_android.repository.local.j0(this, str)), str2);
        } else {
            str2 = "{\n            Completable.complete()\n        }";
            n.e(b.f(), str2);
        }
        return bVar;
    }

    public final a0<Map<String, Integer>> f(String str) {
        n.f(str, "dogId");
        a0 a0Var = I(str).d(this.dispatcher.insertTrickProgressCompletable(str).map(app.dogo.com.dogo_android.repository.local.e0.a));
        n.e(a0Var, "syncDogKnowledgeIfNeeded(dogId).andThen(\n            trickKnowledgeDao.getAllDogTrickKnowledge(dogId).map { trickList ->\n                trickList.map { Pair(it.trickId, it.knowledge) }.toMap()\n            }\n        )");
        return a0Var;
    }

    /* renamed from: h, reason: from kotlin metadata */
    public final a0<List<TrickModel>> getAllTrickModels() {
        a0 map = j().map(app.dogo.com.dogo_android.repository.local.i0.a);
        n.e(map, "getAllTricks().map { it.map { trick -> trick.toTrickModel() } }");
        return map;
    }

    public final a0<List<e.a.a.a.b.d.g>> j() {
        a0 map = this.preferenceService.deleteTrickStep(LocaleService.supportedLocales.getLocaleString(this.apiClient.W())).map(new app.dogo.com.dogo_android.repository.local.d0(this));
        n.e(map, "tricksDao.getAllLocalisedTricks(correctedLocale).map { it.applyTrickOverrides() }");
        return map;
    }

    public final a0<List<e.a.a.a.b.d.g>> l() {
        return q("id_exercise_biting");
    }

    public final List<String> m() {
        return this.b.L();
    }

    public final Object n(String str, kotlin.b0.d<? super List<TrickProgressEntity>> dVar) {
        return this.dispatcher.c(str, (int)this.b.z(), dVar);
    }

    public final Object o(String str, kotlin.b0.d<? super e.a.a.a.b.d.g> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        int i2;
        Object obj;
        List list;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.o1.b;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.o1.b) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.o1.b bVar = new app.dogo.com.dogo_android.repository.local.o1.b(this, dVar);
            }
        }
        Object obj2 = b.d();
        int i3 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar22.result);
                return p.X(obj.saveTrickKnowledge((List)list));
            }
        }
        q.b(dVar22.result);
        dVar22.L$0 = this;
        dVar22.label = i3;
        if (this.preferenceService.t(LocaleService.supportedLocales.getLocaleString(this.apiClient.W()), str, dVar22) == obj2) {
            return obj2;
        }
        app.dogo.com.dogo_android.s.b.o1 str2 = this;
    }

    public final Object p(String str, kotlin.b0.d<? super TrickModel.TrickCategory> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        int i2;
        app.dogo.android.persistencedb.room.entity.TrickCategoryEntity trickCategoryEntity;
        z = dVar instanceof app.dogo.com.dogo_android.repository.local.o1.c;
        if (dVar instanceof app.dogo.com.dogo_android.repository.local.o1.c) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                app.dogo.com.dogo_android.s.b.o1.c cVar = new app.dogo.com.dogo_android.repository.local.o1.c(this, dVar);
            }
        }
        Object obj = b.d();
        int i3 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar22.result);
                return app.dogo.com.dogo_android.util.extensionfunction.m1.u((TrickCategoryEntity)trickCategoryEntity);
            }
        }
        q.b(dVar22.result);
        dVar22.label = i3;
        if (this.preferenceService.o(str, LocaleService.supportedLocales.getLocaleString(this.apiClient.W()), dVar22) == obj) {
            return obj;
        }
    }

    public final a0<List<TrickModel>> s() {
        a0 map = j().map(app.dogo.com.dogo_android.repository.local.g0.a);
        n.e(map, "getAllTricks().map { tricks ->\n            tricks.map { it.toTrickModel() }.filter { it.trickSteps.isNotEmpty() || it.videoSteps.isNotEmpty() }.sortedBy {\n                it.sortOrder ?: Int.MAX_VALUE\n            }\n        }");
        return map;
    }

    public final a0<List<TrickModel>> u(String str, String str2) {
        n.f(str, "category");
        final a0 map = s().map(new app.dogo.com.dogo_android.repository.local.h0(str, str2));
        n.e(map, "getTricksData().map { tricks ->\n            tricks\n                .filter { if (category.isNotBlank()) it.category.id == category else true }\n                .filter { if (trickTag != null) trickTag in it.tags.map { tag -> tag.id } else true }\n        }");
        return map;
    }

    public /* synthetic */ o1(p2 p2Var, r2 r2Var, o0 o0Var, s0 s0Var, e.a.a.a.b.b.m0 m0Var, DogoApiClient dogoApiClient, v2 v2Var, o3 o3Var, h0 h0Var, int i, kotlin.d0.d.g gVar) {
        h0 h0Var92;
        h0Var92 = i & 256 != 0 ? h0Var92 : h0Var;
        this(p2Var, r2Var, o0Var, s0Var, m0Var, dogoApiClient, v2Var, o3Var, h0Var92);
    }


    /* renamed from: A, reason: from kotlin metadata */
    public static /* synthetic */ List getAllTrickKnowledge(List dogId) {
        return TricksRepository.t(dogId);
    }

    public static /* synthetic */ List B(String str, String str2, List list) {
        return TricksRepository.v(str, str2, list);
    }

    /* renamed from: C, reason: from kotlin metadata */
    /* suspend */ public static /* synthetic */ List getRecentlyViewedTricks(List dogId) {
        return TricksRepository.syncDogKnowledgeIfNeeded(dogId);
    }

    public static /* synthetic */ void D(o1 o1Var, String str, i.b.d dVar) {
        TricksRepository.J(o1Var, str, dVar);
    }

    public static /* synthetic */ i.b.f w(o1 o1Var, String str, GetTrickKnowledgeResponse getTrickKnowledgeResponse) {
        return TricksRepository.H(o1Var, str, getTrickKnowledgeResponse);
    }

    public static /* synthetic */ List x(o1 o1Var, List list) {
        return TricksRepository.getTricksWithCategoryAndTag(o1Var, list);
    }

    public static /* synthetic */ Map y(List list) {
        return TricksRepository.syncDogKnowledgeFromRemote(list);
    }

    public static /* synthetic */ List z(String str, List list) {
        return TricksRepository.saveTrickView(str, list);
    }
}
