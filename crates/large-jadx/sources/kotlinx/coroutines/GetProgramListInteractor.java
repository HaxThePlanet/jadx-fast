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
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.service.r2;
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
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.y.p;
import kotlin.z.a;

/* compiled from: GetProgramListInteractor.kt */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00102\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0017H\u0002J2\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0002J!\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00102\u0008\u0008\u0002\u0010#\u001a\u00020!H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010$R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/GetProgramListInteractor;", "", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "predefinedContentRepository", "Lapp/dogo/com/dogo_android/repository/local/PredefinedContentRepository;", "dogRecommendedProgramOrderDao", "Lapp/dogo/android/persistencedb/room/dao/DogRecommendedProgramOrderDao;", "remoteConfigService", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "getProgramOverviewInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/GetProgramOverviewInteractor;", "(Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/repository/local/PredefinedContentRepository;Lapp/dogo/android/persistencedb/room/dao/DogRecommendedProgramOrderDao;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/interactor/GetProgramOverviewInteractor;)V", "addComingSoonProgramCards", "", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "listOfPrograms", "getBitingProgramItemDescriptionOrEmpty", "program", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$BitingProgram;", "getPottyProgramItemDescriptionOrEmpty", "Lapp/dogo/com/dogo_android/trainingprogram/DogoProgram$PottyProgram;", "getProgramStatus", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem$State;", "programId", "", "progress", "Lapp/dogo/externalmodel/model/responses/ProgramProgress;", "activeProgramId", "recommendedProgramId", "showBigRecommendedCard", "", "getProgramsListData", "specialImageForRecommended", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: w2, reason: from kotlin metadata */
public final class GetProgramListInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final p1 dogRecommendedProgramOrderDao;
    /* renamed from: b, reason: from kotlin metadata */
    private final app.dogo.com.dogo_android.s.b.j1 getProgramOverviewInteractor;
    /* renamed from: c, reason: from kotlin metadata */
    private final h1 predefinedContentRepository;
    /* renamed from: d, reason: from kotlin metadata */
    private final y programRepository;
    /* renamed from: e, reason: from kotlin metadata */
    private final r2 remoteConfigService;
    /* renamed from: f, reason: from kotlin metadata */
    private final x2 userRepository;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 5, 1})
    public static final class a<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            return a.c(Integer.valueOf(app.dogo.com.dogo_android.util.extensionfunction.j1.createSingle(t)), Integer.valueOf(app.dogo.com.dogo_android.util.extensionfunction.j1.createSingle(t2)));
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 5, 1})
    public static final class b<T> implements Comparator {

        final /* synthetic */ Comparator a;
        final /* synthetic */ RecommendedListOrderEntity b;
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare;
            int i = 0;
            boolean hasNext;
            boolean hasNext2;
            String str;
            if (this.a.compare(t, t2) == 0) {
                Iterator it = this.b.getRecommendedProgramIds().iterator();
                i = 0;
                i = -1;
                while (it.hasNext()) {
                    if (n.b((RecommendedListOrderEntity_ProgramCompatibility)it.next().getProgramId(), t.getId())) {
                        break;
                    }
                }
                Iterator it2 = this.b.getRecommendedProgramIds().iterator();
                while (it2.hasNext()) {
                    if (n.b((RecommendedListOrderEntity_ProgramCompatibility)it2.next().getProgramId(), t2.getId())) {
                    }
                }
                compare = a.c(Integer.valueOf(i), Integer.valueOf(i));
            }
            return compare;
        }

        public b(Comparator comparator, RecommendedListOrderEntity list) {
            this.a = comparator;
            this.b = list;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenBy$1"}, k = 3, mv = {1, 5, 1})
    public static final class c<T> implements Comparator {

        final /* synthetic */ Comparator a;
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare;
            if (this.a.compare(t, t2) == 0) {
                compare = a.c(t.getName(), t2.getName());
            }
            return compare;
        }

        public c(Comparator comparator) {
            this.a = comparator;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$thenByDescending$1"}, k = 3, mv = {1, 5, 1})
    public static final class d<T> implements Comparator {

        final /* synthetic */ Comparator a;
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int compare;
            if (this.a.compare(t, t2) == 0) {
                compare = a.c(Long.valueOf(t2.getProgramStartTimeMs()), Long.valueOf(t.getProgramStartTimeMs()));
            }
            return compare;
        }

        public d(Comparator comparator) {
            this.a = comparator;
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.GetProgramListInteractor", f = "GetProgramListInteractor.kt", l = {26, 27, 28}, m = "getProgramsListData")
    static final class e extends kotlin.b0.k.a.d {

        Object L$0;
        Object L$1;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        e(kotlin.b0.d<? super w2.e> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return w2.this.e(false, this);
        }
    }
    public w2(p1 p1Var, app.dogo.com.dogo_android.s.b.j1 j1Var, h1 h1Var, y yVar, r2 r2Var, x2 x2Var) {
        n.f(p1Var, "userRepository");
        n.f(j1Var, "programRepository");
        n.f(h1Var, "predefinedContentRepository");
        n.f(yVar, "dogRecommendedProgramOrderDao");
        n.f(r2Var, "remoteConfigService");
        n.f(x2Var, "getProgramOverviewInteractor");
        super();
        this.dogRecommendedProgramOrderDao = p1Var;
        this.getProgramOverviewInteractor = j1Var;
        this.predefinedContentRepository = h1Var;
        this.programRepository = yVar;
        this.remoteConfigService = r2Var;
        this.userRepository = x2Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final List<ProgramDescriptionItem> addComingSoonProgramCards(List<ProgramDescriptionItem> listOfPrograms) {
        final ArrayList arrayList = new ArrayList(p.r(listOfPrograms, 10));
        Iterator it2 = listOfPrograms.iterator();
        while (it2.hasNext()) {
            arrayList.add((ProgramDescriptionItem)it2.next().getId());
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = this.predefinedContentRepository.b().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            i = !arrayList.contains((ProgramDescriptionItem)item.getId());
        }
        return p.t0(listOfPrograms, arrayList2);
    }

    /* renamed from: b, reason: from kotlin metadata */
    private final ProgramDescriptionItem getBitingProgramItemDescriptionOrEmpty(k.a program) {
        int i = 0;
        int i2 = 0;
        ProgramDescriptionItem.State iN_PROGRESS2;
        int i3 = 0;
        app.dogo.externalmodel.model.BitingProgressModel bitingProgressModel = program.c();
        if (bitingProgressModel == null) {
            i = 0;
        } else {
            BitingProgramProgress bitingProgramProgressItem = BitingProgramProgressKt.toBitingProgramProgressItem(bitingProgressModel);
        }
        i3 = 0;
        i3 = 1;
        int r3 = i == 0 ? 0 : i3;
        if (i3 != 0) {
            iN_PROGRESS2 = ProgramDescriptionItem_State.COMPLETED;
        } else {
            if (i != 0) {
                if (i.hasProgress()) {
                }
            }
            ProgramDescriptionItem.State r1 = i3 != 0 ? ProgramDescriptionItem_State.IN_PROGRESS : ProgramDescriptionItem_State.NOT_STARTED;
        }
        if (i == 0) {
            i2 = 0;
        } else {
            long startedTimeMs = i.getStartedTimeMs();
        }
        return app.dogo.com.dogo_android.util.extensionfunction.j1.c(program.a(), (i3 != 0 ? ProgramDescriptionItem_State.IN_PROGRESS : ProgramDescriptionItem_State.NOT_STARTED), false, false, i2, true, 0, null, 98, null);
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final ProgramDescriptionItem getPottyProgramItemDescriptionOrEmpty(k.c program) {
        PottyProgramProgress pottyProgramProgressItem = null;
        int i = 0;
        int i2 = 0;
        ProgramDescriptionItem.State nOT_STARTED2;
        app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus programStatus = program.c();
        if (programStatus == null) {
            int i3 = 0;
        } else {
            pottyProgramProgressItem = PottyProgramProgressKt.toPottyProgramProgressItem(programStatus);
        }
        i2 = 0;
        i2 = 1;
        if (pottyProgramProgressItem != null) {
            if (pottyProgramProgressItem.isActive()) {
            }
        }
        ProgramDescriptionItem.State r1 = i2 != 0 ? ProgramDescriptionItem_State.IN_PROGRESS : ProgramDescriptionItem_State.NOT_STARTED;
        if (pottyProgramProgressItem == null) {
            i = 0;
        } else {
            long startedTimeMs = pottyProgramProgressItem.getStartedTimeMs();
        }
        return app.dogo.com.dogo_android.util.extensionfunction.j1.c(program.a(), (i2 != 0 ? ProgramDescriptionItem_State.IN_PROGRESS : ProgramDescriptionItem_State.NOT_STARTED), false, false, i, true, 0, null, 98, null);
    }

    /* renamed from: d, reason: from kotlin metadata */
    private final ProgramDescriptionItem.State getProgramStatus(String programId, ProgramProgress progress, String activeProgramId, String recommendedProgramId, boolean showBigRecommendedCard) {
        int i = 0;
        boolean started;
        ProgramDescriptionItem.State iN_PROGRESS2;
        final boolean z = n.b(programId, recommendedProgramId);
        i = 0;
        i = 1;
        int r2 = progress == null ? 0 : i;
        if (i != 0) {
            iN_PROGRESS2 = ProgramDescriptionItem_State.COMPLETED;
        } else {
            if (n.b(programId, activeProgramId)) {
                if (progress != null) {
                    if (progress.isStarted()) {
                    }
                }
                if (i != 0) {
                    iN_PROGRESS2 = ProgramDescriptionItem_State.IN_PROGRESS;
                } else {
                    if (!z || showBigRecommendedCard) {
                        programId = z && showBigRecommendedCard ? ProgramDescriptionItem_State.RECOMMENDED_BIG : ProgramDescriptionItem_State.NOT_STARTED;
                    } else {
                        programId = ProgramDescriptionItem_State.RECOMMENDED;
                    }
                }
            }
        }
        return (z && showBigRecommendedCard ? ProgramDescriptionItem_State.RECOMMENDED_BIG : ProgramDescriptionItem_State.NOT_STARTED);
    }

    public static /* synthetic */ Object f(w2 w2Var, boolean z, kotlin.b0.d dVar, int i, Object object) {
        final int object52 = 1;
        if (i & object52 != 0) {
        }
        return w2Var.e(z, dVar);
    }

    public final Object e(boolean z, kotlin.b0.d<? super List<ProgramDescriptionItem>> dVar) {
        Object result2;
        String str;
        RecommendedListOrderEntity recommendedListOrderEntity;
        Object dVar22;
        boolean z3;
        int label2;
        int i = -2147483648;
        int i3;
        int i5 = 1;
        app.dogo.com.dogo_android.s.a.w2 w2Var;
        Object obj3;
        boolean z8;
        boolean booleanValue2;
        boolean z9;
        y programRepository2;
        ProgramProgress programProgress2;
        ProgramProgress programProgress3;
        String programId;
        boolean z5;
        boolean z6;
        ArrayList arrayList;
        w2Var = this;
        dVar22 = dVar;
        z2 = dVar22 instanceof kotlinx.coroutines.w2.e;
        if (dVar22 instanceof kotlinx.coroutines.w2.e) {
            i = Integer.MIN_VALUE;
            i3 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                app.dogo.com.dogo_android.s.a.w2.e eVar = new kotlinx.coroutines.w2.e(w2Var, dVar22);
            }
        }
        Object obj7 = b.d();
        int i9 = 3;
        int i4 = 2;
        i5 = 1;
        if (dVar22.label != 0) {
            if (dVar22.label != i5) {
                if (dVar22.label != i4) {
                    if (dVar22.label != i9) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(dVar22.result);
                        ProgramDescriptionItem pottyProgramItemDescriptionOrEmpty = result2.getPottyProgramItemDescriptionOrEmpty(result2.e());
                        final ProgramDescriptionItem bitingProgramItemDescriptionOrEmpty = result2.getBitingProgramItemDescriptionOrEmpty(result2.c());
                        obj3 = p.Z(recommendedListOrderEntity.getRecommendedProgramIds());
                        programId = "";
                        String r21 = programId;
                        Collection values2 = Integer.MIN_VALUE.d().values();
                        booleanValue2 = values2 instanceof Collection;
                        final long l = 0L;
                        i5 = 0;
                        int r8 = i5;
                        if (i5 != 0) {
                            ProgramDescriptionItem.State iN_PROGRESS2 = ProgramDescriptionItem_State.IN_PROGRESS;
                            if (pottyProgramItemDescriptionOrEmpty.getProgramState() != ProgramDescriptionItem_State.IN_PROGRESS && bitingProgramItemDescriptionOrEmpty.getProgramState() != ProgramDescriptionItem_State.IN_PROGRESS) {
                                int r25 = i5;
                            }
                        }
                        Collection values = Integer.MIN_VALUE.d().values();
                        arrayList = new ArrayList(p.r(values, 10));
                        final Iterator it3 = values.iterator();
                        while (it3.hasNext()) {
                            programId = result2.b();
                            String r11 = programId;
                            z7 = i5;
                            ProgramProgress programProgress = item2.c();
                            r8 = i5;
                            programProgress3 = item2.c();
                            long r12 = l;
                            int i7 = 48;
                            int i8 = 0;
                            arrayList.add(app.dogo.com.dogo_android.util.extensionfunction.j1.c(item2.a(), result2.getProgramStatus(item2.a().getId(), item2.c(), programId, programId, z7), z3, z5, l, z7, 0, 0, result2.userRepository.a(item2.a()), 48, 0));
                            i5 = 1;
                        }
                        ProgramDescriptionItem[] arr = new ProgramDescriptionItem[i4];
                        int i2 = 1;
                        arr[i2] = bitingProgramItemDescriptionOrEmpty;
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it2 = p.j(arr).iterator();
                        while (it2.hasNext()) {
                            Object item = it2.next();
                            r8 = (ProgramDescriptionItem)item.getId().length() > 0 ? i2 : i5;
                        }
                        return p.D0(result2.addComingSoonProgramCards(p.t0(arrayList, arrayList2)), new kotlinx.coroutines.w2.c(new kotlinx.coroutines.w2.b(new kotlinx.coroutines.w2.d(new kotlinx.coroutines.w2.a()), recommendedListOrderEntity)));
                    }
                }
                q.b(dVar22.result);
            } else {
                q.b(dVar22.result);
                dVar22.L$0 = w2Var;
                dVar22.L$1 = str;
                dVar22.Z$0 = z3;
                dVar22.label = i4;
                result2 = w2Var.getProgramOverviewInteractor.o(str, dVar22);
                if (result2 == obj7) {
                    return obj7;
                }
            }
        } else {
            q.b(dVar22.result);
            dVar22.L$0 = w2Var;
            dVar22.Z$0 = z;
            dVar22.label = i5;
            if (w2Var.dogRecommendedProgramOrderDao.u(dVar22) == obj7) {
                return obj7;
            }
        }
        dVar22.L$0 = result2;
        dVar22.L$1 = result2;
        dVar22.Z$0 = z3;
        dVar22.label = i9;
        Object obj = result2.programRepository.b(str, dVar22);
        if (obj == obj7) {
            return obj7;
        }
    }
}
