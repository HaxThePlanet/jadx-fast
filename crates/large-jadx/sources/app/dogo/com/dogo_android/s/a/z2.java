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
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u001f\u0010\r\u001a\u00020\u000e2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0011\u0010\u0018\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0011\u0010\u001b\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ \u0010\u001c\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u001fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetRecommendedProgramRequestInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "cloudFunctionsService", "Lapp/dogo/com/dogo_android/service/CloudFunctionsService;", "dogRecommendedProgramOrderDao", "Lapp/dogo/android/persistencedb/room/dao/DogRecommendedProgramOrderDao;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/service/CloudFunctionsService;Lapp/dogo/android/persistencedb/room/dao/DogRecommendedProgramOrderDao;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;)V", "getOrderedRecommendedPrograms", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedProgramData;", "programs", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendedProgramFit", "", "programId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecommendedProgramOrder", "Lapp/dogo/com/dogo_android/repository/domain/RecommendedOrderedPrograms;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getWhitelistedRecommendedProgramOrder", "submitRecommendedProgram", "Lio/reactivex/Single;", "answers", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class z2 {

    private final p1 a;
    private final i2 b;
    private final y c;
    private final r2 d;
    private final j1 e;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetRecommendedProgramRequestInteractor", f = "GetRecommendedProgramRequestInteractor.kt", l = 78, m = "getRecommendedProgramFit")
    static final class a extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.z2 this$0;
        a(app.dogo.com.dogo_android.s.a.z2 z2, d<? super app.dogo.com.dogo_android.s.a.z2.a> d2) {
            this.this$0 = z2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.b(0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetRecommendedProgramRequestInteractor", f = "GetRecommendedProgramRequestInteractor.kt", l = {29, 30, 32, 33}, m = "getRecommendedProgramOrder")
    static final class b extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.z2 this$0;
        b(app.dogo.com.dogo_android.s.a.z2 z2, d<? super app.dogo.com.dogo_android.s.a.z2.b> d2) {
            this.this$0 = z2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return z2.a(this.this$0, this);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetRecommendedProgramRequestInteractor", f = "GetRecommendedProgramRequestInteractor.kt", l = {44, 45}, m = "getWhitelistedRecommendedProgramOrder")
    static final class c extends d {

        Object L$0;
        Object L$1;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.z2 this$0;
        c(app.dogo.com.dogo_android.s.a.z2 z2, d<? super app.dogo.com.dogo_android.s.a.z2.c> d2) {
            this.this$0 = z2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.d(this);
        }
    }
    public z2(p1 p1, i2 i22, y y3, r2 r24, j1 j15) {
        n.f(p1, "userRepository");
        n.f(i22, "cloudFunctionsService");
        n.f(y3, "dogRecommendedProgramOrderDao");
        n.f(r24, "remoteConfigService");
        n.f(j15, "programRepository");
        super();
        this.a = p1;
        this.b = i22;
        this.c = y3;
        this.d = r24;
        this.e = j15;
    }

    public static final Object a(app.dogo.com.dogo_android.s.a.z2 z2, d d2) {
        return z2.c(d2);
    }

    private final Object c(d<? super RecommendedOrderedPrograms> d) {
        boolean bVar;
        int label;
        Object item;
        int i2;
        boolean surveyAnswered;
        Object l$0;
        int i;
        int entity;
        Object l$02;
        Object l$03;
        boolean empty;
        Object obj;
        int obj10;
        bVar = d;
        label = bVar.label;
        i2 = Integer.MIN_VALUE;
        if (d instanceof z2.b && label & i2 != 0) {
            bVar = d;
            label = bVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                bVar.label = label -= i2;
            } else {
                bVar = new z2.b(this, d);
            }
        } else {
        }
        obj10 = bVar.result;
        Object obj3 = b.d();
        surveyAnswered = bVar.label;
        entity = 4;
        l$02 = 3;
        l$03 = 2;
        final int i3 = 1;
        if (surveyAnswered != 0) {
            if (surveyAnswered != i3) {
                if (surveyAnswered != l$03) {
                    if (surveyAnswered != l$02) {
                        if (surveyAnswered != entity) {
                        } else {
                            item = bVar.L$1;
                            bVar = bVar.L$0;
                            q.b(obj10);
                            if (!item.isSurveyAnswered()) {
                                if (obj10 ^= i3 != 0) {
                                    bVar = new RecommendedListOrderEntity[i3];
                                    bVar[0] = RecommendedOrderedProgramsKt.toEntity(item);
                                    bVar.c.a(bVar);
                                }
                            } else {
                            }
                        }
                        obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw obj10;
                    }
                    surveyAnswered = bVar.L$1;
                    l$02 = bVar.L$0;
                    q.b(obj10);
                    bVar.L$0 = l$02;
                    bVar.L$1 = (RecommendedOrderedPrograms)obj10;
                    bVar.label = entity;
                    Object obj2 = l$02.e.o(surveyAnswered, bVar);
                    if (obj2 == obj3) {
                        return obj3;
                    }
                    item = obj10;
                    obj10 = obj2;
                    bVar = l$02;
                } else {
                    surveyAnswered = bVar.L$1;
                    l$03 = bVar.L$0;
                    q.b(obj10);
                    if ((RecommendedListOrderEntity)obj10.isEmpty()) {
                        bVar.L$0 = l$03;
                        bVar.L$1 = surveyAnswered;
                        bVar.label = l$02;
                        if (l$03.b.l(surveyAnswered, bVar) == obj3) {
                            return obj3;
                        }
                        l$02 = l$03;
                    } else {
                        item = RecommendedOrderedProgramsKt.toItem(obj10);
                    }
                }
            } else {
                l$0 = bVar.L$0;
                q.b(obj10);
                bVar.L$0 = l$0;
                bVar.L$1 = (String)obj10;
                bVar.label = l$03;
                Object obj4 = l$0.c.b(obj10, bVar);
                if (obj4 == obj3) {
                    return obj3;
                }
                surveyAnswered = obj10;
                obj10 = obj4;
                l$03 = obj;
            }
        } else {
            q.b(obj10);
            bVar.L$0 = this;
            bVar.label = i3;
            if (this.a.u(bVar) == obj3) {
                return obj3;
            }
            l$0 = this;
        }
        return item;
    }

    public static g0 e(app.dogo.com.dogo_android.s.a.z2 z2, Map map2, String string3) {
        return z2.g(z2, map2, string3);
    }

    private static final g0 g(app.dogo.com.dogo_android.s.a.z2 z2, Map map2, String string3) {
        n.f(z2, "this$0");
        n.f(map2, "$answers");
        n.f(string3, "dogId");
        return z2.b.p(string3, map2);
    }

    public final Object b(String string, d<? super Integer> d2) {
        boolean aVar;
        int label;
        Object booleanValue;
        int i2;
        int i;
        Object obj5;
        Object obj6;
        aVar = d2;
        label = aVar.label;
        i2 = Integer.MIN_VALUE;
        if (d2 instanceof z2.a && label & i2 != 0) {
            aVar = d2;
            label = aVar.label;
            i2 = Integer.MIN_VALUE;
            if (label & i2 != 0) {
                aVar.label = label -= i2;
            } else {
                aVar = new z2.a(this, d2);
            }
        } else {
        }
        obj6 = aVar.result;
        booleanValue = b.d();
        int label2 = aVar.label;
        int i3 = 1;
        if (label2 != 0) {
            if (label2 != i3) {
            } else {
                obj5 = aVar.L$0;
                q.b(obj6);
                obj6 = (RecommendedOrderedPrograms)obj6.getProgramCompatibilityMatchList().iterator();
                for (Object aVar : obj6) {
                }
                aVar = 0;
                obj5 = 0;
                if ((RecommendedOrderedPrograms.ProgramCompatibilityMatchList)aVar == 0) {
                } else {
                    obj6 = b.c((RecommendedOrderedPrograms.ProgramCompatibilityMatchList)aVar.getCompatibility());
                    if (obj6 == null) {
                    } else {
                        obj5 = obj6.intValue();
                    }
                }
                return b.c(obj5);
            }
            obj5 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj5;
        }
        q.b(obj6);
        aVar.L$0 = string;
        aVar.label = i3;
        if (d(aVar) == booleanValue) {
            return booleanValue;
        }
    }

    public final Object d(d<? super RecommendedOrderedPrograms> d) {
        boolean cVar;
        Object l$0;
        int label2;
        Object l$1;
        int i4;
        Object label;
        int i3;
        j1 i;
        int copy$default;
        String dogId;
        String programId;
        int i2;
        Object obj14;
        cVar = d;
        label2 = cVar.label;
        i4 = Integer.MIN_VALUE;
        if (d instanceof z2.c && label2 & i4 != 0) {
            cVar = d;
            label2 = cVar.label;
            i4 = Integer.MIN_VALUE;
            if (label2 & i4 != 0) {
                cVar.label = label2 -= i4;
            } else {
                cVar = new z2.c(this, d);
            }
        } else {
        }
        obj14 = cVar.result;
        Object obj2 = b.d();
        label = cVar.label;
        i = 1;
        final int i6 = 2;
        if (label != 0) {
            if (label != i) {
                if (label != i6) {
                } else {
                    l$1 = cVar.L$1;
                    l$0 = cVar.L$0;
                    q.b(obj14);
                    List programCompatibilityMatchList = l$1.getProgramCompatibilityMatchList();
                    ArrayList arrayList = new ArrayList(p.r(programCompatibilityMatchList, 10));
                    Iterator iterator = programCompatibilityMatchList.iterator();
                    while (iterator.hasNext()) {
                        copy$default = iterator.next();
                        dogId = l$0.d.N().get((RecommendedOrderedPrograms.ProgramCompatibilityMatchList)copy$default.getProgramId());
                        if (dogId != null && l$0.d.M().contains((String)dogId) && !(List)obj14.contains(copy$default.getProgramId())) {
                        }
                        arrayList.add(copy$default);
                        if (l$0.d.M().contains(dogId)) {
                        }
                        if (!obj14.contains(copy$default.getProgramId())) {
                        }
                        copy$default = RecommendedOrderedPrograms.ProgramCompatibilityMatchList.copy$default(copy$default, dogId, 0, i6, 0);
                    }
                    super(l$1.getDogId(), arrayList, 0, l$1.isSurveyAnswered(), 0, 20, 0);
                    return obj14;
                }
                obj14 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj14;
            }
            label = cVar.L$0;
            q.b(obj14);
        } else {
            q.b(obj14);
            cVar.L$0 = this;
            cVar.label = i;
            if (c(cVar) == obj2) {
                return obj2;
            }
            label = this;
        }
        cVar.L$0 = label;
        cVar.L$1 = obj14;
        cVar.label = i6;
        Object obj = label.e.p((RecommendedOrderedPrograms)obj14.getDogId(), cVar);
        if (obj == obj2) {
            return obj2;
        }
        l$1 = obj14;
        obj14 = obj;
        l$0 = label;
    }

    public final a0<RecommendedOrderedPrograms> f(Map<String, String> map) {
        n.f(map, "answers");
        w wVar = new w(this, map);
        final a0 obj3 = this.a.v().flatMap(wVar);
        n.e(obj3, "userRepository.getCurrentDogIdSingle().flatMap { dogId ->\n            cloudFunctionsService.submitRecommendedProgram(dogId, answers)\n        }");
        return obj3;
    }
}
