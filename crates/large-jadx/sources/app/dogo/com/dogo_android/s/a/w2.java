package app.dogo.com.dogo_android.s.a;

import app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity;
import app.dogo.android.persistencedb.room.entity.RecommendedListOrderEntity.ProgramCompatibility;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.repository.domain.BitingProgramProgress;
import app.dogo.com.dogo_android.repository.domain.BitingProgramProgressKt;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgressKt;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State;
import app.dogo.com.dogo_android.s.b.h1;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.y.i;
import app.dogo.com.dogo_android.y.k;
import app.dogo.com.dogo_android.y.k.a;
import app.dogo.com.dogo_android.y.k.b;
import app.dogo.com.dogo_android.y.k.c;
import app.dogo.externalmodel.model.responses.ProgramProgress;
import e.a.a.a.b.b.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
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
import kotlin.z.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00102\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0017H\u0002J2\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0002J!\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00102\u0008\u0008\u0002\u0010#\u001a\u00020!H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010$R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetProgramListInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "predefinedContentRepository", "Lapp/dogo/com/dogo_android/repository/local/PredefinedContentRepository;", "dogRecommendedProgramOrderDao", "Lapp/dogo/android/persistencedb/room/dao/DogRecommendedProgramOrderDao;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "getProgramOverviewInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramOverviewInteractor;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/repository/local/PredefinedContentRepository;Lapp/dogo/android/persistencedb/room/dao/DogRecommendedProgramOrderDao;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/GetProgramOverviewInteractor;)V", "addComingSoonProgramCards", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "listOfPrograms", "getBitingProgramItemDescriptionOrEmpty", "program", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$BitingProgram;", "getPottyProgramItemDescriptionOrEmpty", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$PottyProgram;", "getProgramStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem$State;", "programId", "", "progress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "activeProgramId", "recommendedProgramId", "showBigRecommendedCard", "", "getProgramsListData", "specialImageForRecommended", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class w2 {

    private final p1 a;
    private final j1 b;
    private final h1 c;
    private final y d;
    private final r2 e;
    private final app.dogo.com.dogo_android.s.a.x2 f;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class a implements Comparator {
        public final int compare(T t, T t2) {
            return a.c(Integer.valueOf(j1.F((ProgramDescriptionItem)t)), Integer.valueOf(j1.F((ProgramDescriptionItem)t2)));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 5, 1})
    public static final class b implements Comparator {

        final Comparator a;
        final RecommendedListOrderEntity b;
        public b(Comparator comparator, RecommendedListOrderEntity recommendedListOrderEntity2) {
            this.a = comparator;
            this.b = recommendedListOrderEntity2;
            super();
        }

        public final int compare(T t, T t2) {
            int compare;
            int i2;
            boolean next2;
            boolean next;
            int i;
            String str;
            Object obj7;
            Object obj8;
            if (this.a.compare(t, t2) != 0) {
            } else {
                Iterator iterator = this.b.getRecommendedProgramIds().iterator();
                next2 = i2;
                for (RecommendedListOrderEntity.ProgramCompatibility next4 : iterator) {
                    next2++;
                }
                next2 = i;
                Iterator iterator2 = this.b.getRecommendedProgramIds().iterator();
                while (iterator2.hasNext()) {
                    if (n.b((RecommendedListOrderEntity.ProgramCompatibility)iterator2.next().getProgramId(), (ProgramDescriptionItem)t2.getId()) != 0) {
                        break;
                    } else {
                    }
                    i2++;
                }
                compare = a.c(Integer.valueOf(next2), Integer.valueOf(i));
            }
            return compare;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 5, 1})
    public static final class c implements Comparator {

        final Comparator a;
        public c(Comparator comparator) {
            this.a = comparator;
            super();
        }

        public final int compare(T t, T t2) {
            int compare;
            Object obj2;
            Object obj3;
            if (this.a.compare(t, t2) != 0) {
            } else {
                compare = a.c((ProgramDescriptionItem)t.getName(), (ProgramDescriptionItem)t2.getName());
            }
            return compare;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {1, 5, 1})
    public static final class d implements Comparator {

        final Comparator a;
        public d(Comparator comparator) {
            this.a = comparator;
            super();
        }

        public final int compare(T t, T t2) {
            int compare;
            Object obj3;
            Object obj4;
            if (this.a.compare(t, t2) != 0) {
            } else {
                compare = a.c(Long.valueOf((ProgramDescriptionItem)t2.getProgramStartTimeMs()), Long.valueOf((ProgramDescriptionItem)t.getProgramStartTimeMs()));
            }
            return compare;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetProgramListInteractor", f = "GetProgramListInteractor.kt", l = {26, 27, 28}, m = "getProgramsListData")
    static final class e extends d {

        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.w2 this$0;
        e(app.dogo.com.dogo_android.s.a.w2 w2, d<? super app.dogo.com.dogo_android.s.a.w2.e> d2) {
            this.this$0 = w2;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.e(false, this);
        }
    }
    public w2(p1 p1, j1 j12, h1 h13, y y4, r2 r25, app.dogo.com.dogo_android.s.a.x2 x26) {
        n.f(p1, "userRepository");
        n.f(j12, "programRepository");
        n.f(h13, "predefinedContentRepository");
        n.f(y4, "dogRecommendedProgramOrderDao");
        n.f(r25, "remoteConfigService");
        n.f(x26, "getProgramOverviewInteractor");
        super();
        this.a = p1;
        this.b = j12;
        this.c = h13;
        this.d = y4;
        this.e = r25;
        this.f = x26;
    }

    private final List<ProgramDescriptionItem> a(List<ProgramDescriptionItem> list) {
        String str;
        boolean next;
        int i;
        ArrayList arrayList = new ArrayList(p.r(list, 10));
        Iterator iterator2 = list.iterator();
        for (ProgramDescriptionItem next3 : iterator2) {
            arrayList.add(next3.getId());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator iterator = this.c.b().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (contains ^= 1 != 0) {
            }
            arrayList2.add(next);
        }
        return p.t0(list, arrayList2);
    }

    private final ProgramDescriptionItem b(k.a k$a) {
        int bitingProgramProgressItem;
        int startedTimeMs;
        ProgramDescriptionItem.State iN_PROGRESS;
        int i;
        boolean programIsCompleted;
        int progress;
        app.dogo.externalmodel.model.BitingProgressModel bitingProgressModel = a.c();
        if (bitingProgressModel == null) {
            bitingProgramProgressItem = 0;
        } else {
            bitingProgramProgressItem = BitingProgramProgressKt.toBitingProgramProgressItem(bitingProgressModel);
        }
        int i2 = 1;
        if (bitingProgramProgressItem == 0) {
            progress = i;
        } else {
        }
        if (progress != 0) {
            iN_PROGRESS = ProgramDescriptionItem.State.COMPLETED;
        } else {
            if (bitingProgramProgressItem == 0) {
            } else {
                if (bitingProgramProgressItem.hasProgress() == i2) {
                    i = i2;
                }
            }
            iN_PROGRESS = i != 0 ? ProgramDescriptionItem.State.IN_PROGRESS : ProgramDescriptionItem.State.NOT_STARTED;
        }
        if (bitingProgramProgressItem == 0) {
            startedTimeMs = 0;
        } else {
            startedTimeMs = bitingProgramProgressItem.getStartedTimeMs();
        }
        return j1.c(a.a(), iN_PROGRESS, false, false, startedTimeMs, obj7, 1, 0, 0, 98);
    }

    private final ProgramDescriptionItem c(k.c k$c) {
        PottyProgramProgress pottyProgramProgressItem;
        int startedTimeMs;
        int i;
        ProgramDescriptionItem.State nOT_STARTED;
        boolean active;
        app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus programStatus = c.c();
        if (programStatus == null) {
            pottyProgramProgressItem = 0;
        } else {
            pottyProgramProgressItem = PottyProgramProgressKt.toPottyProgramProgressItem(programStatus);
        }
        i = 0;
        int i2 = 1;
        if (pottyProgramProgressItem == null) {
        } else {
            if (pottyProgramProgressItem.isActive() == i2) {
                i = i2;
            }
        }
        nOT_STARTED = i != 0 ? ProgramDescriptionItem.State.IN_PROGRESS : ProgramDescriptionItem.State.NOT_STARTED;
        if (pottyProgramProgressItem == null) {
            startedTimeMs = 0;
        } else {
            startedTimeMs = pottyProgramProgressItem.getStartedTimeMs();
        }
        return j1.c(c.a(), nOT_STARTED, false, false, startedTimeMs, obj7, 1, 0, 0, 98);
    }

    private final ProgramDescriptionItem.State d(String string, ProgramProgress programProgress2, String string3, String string4, boolean z5) {
        int i;
        boolean passed;
        int i2;
        boolean obj4;
        final boolean obj7 = n.b(string, string4);
        final int i3 = 1;
        if (programProgress2 == null) {
            i2 = i;
        } else {
        }
        if (i2 != 0) {
            obj4 = ProgramDescriptionItem.State.COMPLETED;
        } else {
            if (n.b(string, string3)) {
                if (programProgress2 == null) {
                } else {
                    if (programProgress2.isStarted() == i3) {
                        i = i3;
                    }
                }
                if (i != 0) {
                    obj4 = ProgramDescriptionItem.State.IN_PROGRESS;
                } else {
                    if (obj7 != null && !z5) {
                        if (!z5) {
                            obj4 = ProgramDescriptionItem.State.RECOMMENDED;
                        } else {
                            if (obj7 != null && z5) {
                                obj4 = z5 ? ProgramDescriptionItem.State.RECOMMENDED_BIG : ProgramDescriptionItem.State.NOT_STARTED;
                            } else {
                            }
                        }
                    } else {
                    }
                }
            } else {
            }
        }
        return obj4;
    }

    public static Object f(app.dogo.com.dogo_android.s.a.w2 w2, boolean z2, d d3, int i4, Object object5) {
        int obj1;
        final int obj4 = 1;
        if (i4 &= obj4 != 0) {
            obj1 = obj4;
        }
        return w2.e(obj1, d3);
    }

    public final Object e(boolean z, d<? super List<ProgramDescriptionItem>> d2) {
        Object result;
        Object eVar;
        Object l$02;
        int label;
        boolean z$0;
        int i10;
        boolean z$02;
        Object l$1;
        int i11;
        int next;
        int i12;
        Object l$0;
        Object programId;
        Object iterator;
        int programState;
        Collection values;
        int i13;
        ProgramProgress started;
        boolean booleanValue2;
        int i14;
        Object obj2;
        boolean booleanValue;
        Object completeTimeMs;
        int i8;
        int i7;
        y cmp;
        ProgramProgress programProgress;
        int i6;
        String str;
        long longValue;
        Object startTimeMs;
        int i3;
        int i5;
        ArrayList arrayList;
        app.dogo.com.dogo_android.repository.domain.ProgramOverview programOverview;
        int i15;
        int i9;
        Object obj;
        int i2;
        int i;
        int i4;
        Object obj3;
        final app.dogo.com.dogo_android.s.a.w2 w2Var = this;
        Object obj4 = d2;
        eVar = obj4;
        label = eVar.label;
        i10 = Integer.MIN_VALUE;
        if (obj4 instanceof w2.e && label & i10 != 0) {
            eVar = obj4;
            label = eVar.label;
            i10 = Integer.MIN_VALUE;
            if (label & i10 != 0) {
                eVar.label = label -= i10;
            } else {
                eVar = new w2.e(w2Var, obj4);
            }
        } else {
        }
        result = eVar.result;
        Object obj6 = b.d();
        int label2 = eVar.label;
        int i17 = 3;
        next = 2;
        i12 = 1;
        if (label2 != 0) {
            if (label2 != i12) {
                if (label2 != next) {
                    if (label2 != i17) {
                    } else {
                        z$0 = eVar.Z$0;
                        l$1 = eVar.L$1;
                        l$02 = eVar.L$0;
                        q.b(result);
                        ProgramDescriptionItem programDescriptionItem = l$02.c(l$1.e());
                        final ProgramDescriptionItem programDescriptionItem2 = l$02.b(l$1.c());
                        programId = p.Z((RecommendedListOrderEntity)result.getRecommendedProgramIds());
                        final String str4 = "";
                        if ((RecommendedListOrderEntity.ProgramCompatibility)programId == null) {
                            obj = str4;
                        } else {
                        }
                        iterator = l$1.d().values();
                        final int i23 = 0;
                        final int i24 = 0;
                        if (iterator instanceof Collection != null && iterator.isEmpty()) {
                            if (iterator.isEmpty()) {
                                programState = i12;
                            } else {
                                iterator = iterator.iterator();
                                while (iterator.hasNext()) {
                                    completeTimeMs = iterator.next();
                                    if ((k.b)completeTimeMs.c() != null && Long.compare(startTimeMs2, i23) != 0) {
                                    } else {
                                    }
                                    i8 = i12;
                                    if (Long.compare(startTimeMs2, i23) != 0) {
                                    } else {
                                    }
                                    if (Long.compare(startTimeMs3, i23) != 0 && completeTimeMs.c().getCompleteTimeMs() != null) {
                                    } else {
                                    }
                                    i8 = i24;
                                    if (completeTimeMs.c().getCompleteTimeMs() != null) {
                                    } else {
                                    }
                                }
                            }
                        } else {
                        }
                        booleanValue = ProgramDescriptionItem.State.IN_PROGRESS;
                        if (programState != 0 && programDescriptionItem.getProgramState() != booleanValue && programDescriptionItem2.getProgramState() != booleanValue && programDescriptionItem2.getProgramState() != ProgramDescriptionItem.State.COMPLETED) {
                            booleanValue = ProgramDescriptionItem.State.IN_PROGRESS;
                            if (programDescriptionItem.getProgramState() != booleanValue) {
                                if (programDescriptionItem2.getProgramState() != booleanValue) {
                                    i2 = programDescriptionItem2.getProgramState() != ProgramDescriptionItem.State.COMPLETED ? i12 : i24;
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                        values = l$1.d().values();
                        arrayList = new ArrayList(p.r(values, 10));
                        final Iterator iterator3 = values.iterator();
                        while (iterator3.hasNext()) {
                            Object obj9 = next3;
                            String str3 = l$1.b();
                            if (str3 == null) {
                            } else {
                            }
                            str = str3;
                            i3 = i2;
                            started = obj9.c();
                            if (started == null) {
                            } else {
                            }
                            if (started.isStarted() == i12) {
                            } else {
                            }
                            i13 = i24;
                            if (i13 == 0 && l$02.e.d0()) {
                            } else {
                            }
                            i6 = i24;
                            programProgress = obj9.c();
                            if (programProgress == null) {
                            } else {
                            }
                            programProgress = b.d(programProgress.getStartTimeMs());
                            if (programProgress == null) {
                            } else {
                            }
                            longValue = programProgress.longValue();
                            ArrayList list5 = arrayList;
                            list5.add(j1.c(obj9.a(), l$02.d((k.b)obj9.a().getId(), obj9.c(), str, obj, i3), z$0, i6, longValue, i3, 0, 0, l$02.f.a(obj9.a()), 48));
                            arrayList = list5;
                            i12 = 1;
                            longValue = i23;
                            if (l$02.e.d0()) {
                            } else {
                            }
                            i6 = i12;
                            i13 = i12;
                            str = str4;
                        }
                        ProgramDescriptionItem[] arr = new ProgramDescriptionItem[next];
                        arr[i24] = programDescriptionItem;
                        int i16 = 1;
                        arr[i16] = programDescriptionItem2;
                        ArrayList arrayList2 = new ArrayList();
                        Iterator iterator2 = p.j(arr).iterator();
                        while (iterator2.hasNext()) {
                            next = iterator2.next();
                            if ((ProgramDescriptionItem)next.getId().length() > 0) {
                            } else {
                            }
                            i14 = i24;
                            if (b.a(i14).booleanValue()) {
                            }
                            arrayList2.add(next);
                            i14 = i16;
                        }
                        w2.a aVar = new w2.a();
                        w2.d dVar = new w2.d(aVar);
                        w2.b bVar = new w2.b(dVar, result);
                        w2.c cVar = new w2.c(bVar);
                        return p.D0(l$02.a(p.t0(arrayList, arrayList2)), cVar);
                    }
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw illegalStateException;
                }
                z$02 = eVar.Z$0;
                q.b(result);
                obj2 = l$12;
                l$0 = obj3;
            } else {
                z$02 = eVar.Z$0;
                l$0 = eVar.L$0;
                q.b(result);
                eVar.L$0 = l$0;
                eVar.L$1 = (String)result;
                eVar.Z$0 = z$02;
                eVar.label = next;
                Object obj8 = l$0.b.o(result, eVar);
                if (obj8 == obj6) {
                    return obj6;
                }
                obj2 = result;
                result = obj3;
            }
        } else {
            q.b(result);
            eVar.L$0 = w2Var;
            eVar.Z$0 = z;
            eVar.label = i12;
            if (w2Var.a.u(eVar) == obj6) {
                return obj6;
            }
            l$0 = w2Var;
        }
        eVar.L$0 = l$0;
        eVar.L$1 = (i)result;
        eVar.Z$0 = z$02;
        eVar.label = i17;
        Object obj5 = l$0.d.b(obj2, eVar);
        if (obj5 == obj6) {
            return obj6;
        }
        z$0 = z$02;
        l$1 = result;
        result = obj5;
        l$02 = l$0;
    }
}
