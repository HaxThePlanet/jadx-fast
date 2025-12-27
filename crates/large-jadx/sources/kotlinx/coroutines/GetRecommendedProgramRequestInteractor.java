package app.dogo.com.dogo_android.s.a;

import app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity;
import app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms;
import app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms.ProgramCompatibilityMatchList;
import app.dogo.com.dogo_android.repository.domain.RecommendedOrderedProgramsKt;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.i2;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.y.i;
import e.a.a.a.b.b.y;
import i.b.a0;
import i.b.g0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.y.p;

/* compiled from: GetRecommendedProgramRequestInteractor.kt */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u001f\u0010\r\u001a\u00020\u000e2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0011\u0010\u001b\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ \u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetRecommendedProgramRequestInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "cloudFunctionsService", "Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "dogRecommendedProgramOrderDao", "Lapp/dogo/android/persistencedb/room/dao/DogRecommendedProgramOrderDao;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/CloudFunctionsService;Lapp/dogo/android/persistencedb/room/dao/DogRecommendedProgramOrderDao;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;)V", "getOrderedRecommendedPrograms", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedProgramData;", "programs", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendedProgramFit", "", "programId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendedProgramOrder", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWhitelistedRecommendedProgramOrder", "submitRecommendedProgram", "Lio/reactivex/Single;", "answers", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: z2, reason: from kotlin metadata */
public final class GetRecommendedProgramRequestInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final p1 cloudFunctionsService;
    /* renamed from: b, reason: from kotlin metadata */
    private final i2 dogRecommendedProgramOrderDao;
    /* renamed from: c, reason: from kotlin metadata */
    private final y programRepository;
    /* renamed from: d, reason: from kotlin metadata */
    private final r2 remoteConfigService;
    /* renamed from: e, reason: from kotlin metadata */
    private final j1 userRepository;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetRecommendedProgramRequestInteractor", f = "GetRecommendedProgramRequestInteractor.kt", l = 78, m = "getRecommendedProgramFit")
    static final class a extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        a(kotlin.b0.d<? super z2.a> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return z2.this.b(null, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetRecommendedProgramRequestInteractor", f = "GetRecommendedProgramRequestInteractor.kt", l = {29, 30, 32, 33}, m = "getRecommendedProgramOrder")
    static final class b extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super z2.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return z2.this.getOrderedRecommendedPrograms(this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetRecommendedProgramRequestInteractor", f = "GetRecommendedProgramRequestInteractor.kt", l = {44, 45}, m = "getWhitelistedRecommendedProgramOrder")
    static final class c extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        c(kotlin.b0.d<? super z2.c> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return z2.this.getRecommendedProgramFit(this);
        }
    }
    public z2(p1 p1Var, i2 i2Var, y yVar, r2 r2Var, j1 j1Var) {
        n.f(p1Var, "userRepository");
        n.f(i2Var, "cloudFunctionsService");
        n.f(yVar, "dogRecommendedProgramOrderDao");
        n.f(r2Var, "remoteConfigService");
        n.f(j1Var, "programRepository");
        super();
        this.cloudFunctionsService = p1Var;
        this.dogRecommendedProgramOrderDao = i2Var;
        this.programRepository = yVar;
        this.remoteConfigService = r2Var;
        this.userRepository = j1Var;
    }

    public static final /* synthetic */ Object a(z2 z2Var, kotlin.b0.d dVar) {
        return z2Var.getOrderedRecommendedPrograms(dVar);
    }

    /* renamed from: c, reason: from kotlin metadata */
    /* suspend */ private final Object getOrderedRecommendedPrograms(kotlin.b0.d<? super RecommendedOrderedPrograms> programs) {
        Object programs2;
        int label2;
        RecommendedOrderedPrograms item;
        int i = -2147483648;
        String programs4;
        int i2;
        j1 userRepository2;
        boolean empty;
        Object programs3;
        RecommendedListOrderEntity recommendedListOrderEntity;
        z = programs instanceof kotlinx.coroutines.z2.b;
        if (programs instanceof kotlinx.coroutines.z2.b) {
            programs2 = programs;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                programs2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.z2.b bVar = new kotlinx.coroutines.z2.b(this, programs);
            }
        }
        Object obj2 = b.d();
        int i3 = 4;
        int i7 = 3;
        int i4 = 2;
        final int i8 = 1;
        if (programs2.label != 0) {
            if (programs2.label != i8) {
                if (programs2.label != i4) {
                    if (programs2.label != i7) {
                        if (programs2.label != i3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(programs2.result);
                            if (!item.isSurveyAnswered()) {
                                i5 = (AllDogoPrograms)programs3.f().isEmpty() ^ i8;
                                if (programs2.result.f().isEmpty() ^ i8) {
                                    RecommendedListOrderEntity[] arr = new RecommendedListOrderEntity[i8];
                                    programs2.programRepository.getRecommenceOrderOrEmpty(RecommendedOrderedProgramsKt.toEntity(item));
                                }
                            }
                        }
                    }
                    q.b(programs2.result);
                    programs2.L$0 = programs2;
                    programs2.L$1 = programs3;
                    programs2.label = i3;
                    programs3 = programs2.userRepository.o(programs4, programs2);
                    if (programs3 == obj2) {
                        return obj2;
                    }
                } else {
                    q.b(programs2.result);
                    if (recommendedListOrderEntity.isEmpty()) {
                        programs2.L$0 = programs2;
                        programs2.L$1 = programs4;
                        programs2.label = i7;
                        if (programs2.dogRecommendedProgramOrderDao.l(programs4, programs2) == obj2) {
                            return obj2;
                        }
                    } else {
                        item = RecommendedOrderedProgramsKt.toItem(recommendedListOrderEntity);
                    }
                }
            } else {
                q.b(programs2.result);
                programs2.L$0 = programs2;
                programs2.L$1 = programs4;
                programs2.label = i4;
                Object obj = programs2.programRepository.b(programs4, programs2);
                if (obj == obj2) {
                    return obj2;
                }
            }
        } else {
            q.b(programs2.result);
            programs2.L$0 = this;
            programs2.label = i8;
            if (this.cloudFunctionsService.u(programs2) == obj2) {
                return obj2;
            }
            app.dogo.com.dogo_android.s.a.z2 programs5 = this;
        }
        return item;
    }

    private static final g0 g(z2 z2Var, Map map, String str) {
        n.f(z2Var, "this$0");
        n.f(map, "$answers");
        n.f(str, "dogId");
        return z2Var.dogRecommendedProgramOrderDao.p(str, map);
    }

    public final Object b(String str, kotlin.b0.d<? super Integer> dVar) {
        Object dVar22;
        int i = 0;
        int label2;
        Object obj;
        int i2 = -2147483648;
        int i3;
        Object obj2;
        int value = 0;
        Object recommendedProgramFit;
        z = dVar instanceof kotlinx.coroutines.z2.a;
        if (dVar instanceof kotlinx.coroutines.z2.a) {
            dVar22 = dVar;
            i2 = Integer.MIN_VALUE;
            i3 = label2 & i2;
            if (label2 & i2 != 0) {
                dVar22.label -= i2;
            } else {
                app.dogo.com.dogo_android.s.a.z2.a aVar = new kotlinx.coroutines.z2.a(this, dVar);
            }
        }
        obj = b.d();
        int i4 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i4) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                q.b(dVar22.result);
                Iterator it = (RecommendedOrderedPrograms)recommendedProgramFit.getProgramCompatibilityMatchList().iterator();
                while (it.hasNext()) {
                    if (b.a(n.b(obj2, (RecommendedOrderedPrograms_ProgramCompatibilityMatchList)dVar22.getProgramId())).booleanValue()) {
                        break;
                    }
                }
                i = 0;
                value = 0;
                if (i != 0) {
                    Integer num = b.c(i.getCompatibility());
                    if (num != null) {
                        value = num.intValue();
                    }
                }
                return b.c(value);
            }
        }
        q.b(dVar22.result);
        dVar22.L$0 = str;
        dVar22.label = i4;
        if (getRecommendedProgramFit(dVar22) == obj) {
            return obj;
        }
    }

    /* renamed from: d, reason: from kotlin metadata */
    /* suspend */ public final Object getRecommendedProgramFit(kotlin.b0.d<? super RecommendedOrderedPrograms> programId) {
        Object programId2;
        app.dogo.com.dogo_android.s.a.z2 z2Var;
        int label2;
        Object programId3;
        int i = -2147483648;
        int i2;
        Object item;
        String dogId;
        String programId5 = null;
        Object obj;
        z = programId instanceof kotlinx.coroutines.z2.c;
        if (programId instanceof kotlinx.coroutines.z2.c) {
            programId2 = programId;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                programId2.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.z2.c cVar = new kotlinx.coroutines.z2.c(this, programId);
            }
        }
        Object obj2 = b.d();
        int i4 = 1;
        final int i6 = 2;
        if (programId2.label != 0) {
            if (programId2.label != i4) {
                if (programId2.label != i6) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(programId2.result);
                    List programCompatibilityMatchList = programId3.getProgramCompatibilityMatchList();
                    final ArrayList arrayList = new ArrayList(p.r(programCompatibilityMatchList, 10));
                    Iterator it = programCompatibilityMatchList.iterator();
                    while (it.hasNext()) {
                        item = it.next();
                        dogId = z2Var.remoteConfigService.N().get(item.getProgramId());
                        arrayList.add(item);
                    }
                    RecommendedOrderedPrograms programId4 = new RecommendedOrderedPrograms(programId3.getDogId(), arrayList, null, programId3.isSurveyAnswered(), null, 20, null);
                    return programId4;
                }
            }
            q.b(programId2.result);
        } else {
            q.b(programId2.result);
            programId2.L$0 = this;
            programId2.label = i4;
            if (getOrderedRecommendedPrograms(programId2) == obj2) {
                return obj2;
            }
            z2Var = this;
        }
        programId2.L$0 = z2Var;
        programId2.L$1 = programId3;
        programId2.label = i6;
        programId3 = z2Var.userRepository.p(programId3.getDogId(), programId2);
        if (programId3 == obj2) {
            return obj2;
        }
    }

    /* renamed from: f, reason: from kotlin metadata */
    public final a0<RecommendedOrderedPrograms> submitRecommendedProgram(Map<String, String> answers) {
        n.f(answers, "answers");
        final a0 flatMapped = this.cloudFunctionsService.v().flatMap(new kotlinx.coroutines.w(this, answers));
        n.e(flatMapped, "userRepository.getCurrentDogIdSingle().flatMap { dogId ->\n            cloudFunctionsService.submitRecommendedProgram(dogId, answers)\n        }");
        return flatMapped;
    }

    public static /* synthetic */ g0 e(z2 z2Var, Map map, String str) {
        return GetRecommendedProgramRequestInteractor.g(z2Var, map, str);
    }
}
