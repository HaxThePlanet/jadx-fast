package app.dogo.com.dogo_android.s.a;

import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.ArticleWithStatus;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgressKt;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData;
import app.dogo.com.dogo_android.s.b.i1;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.l1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.s.b.y0;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.y.k.c;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: PottyProgramOverviewInteractor.kt */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/PottyProgramOverviewInteractor;", "", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "articlesRepository", "Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;", "remoteConfig", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "programContentRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getPottyProgramOverviewItem", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pottyProgress", "Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "(Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: g3, reason: from kotlin metadata */
public final class PottyProgramOverviewInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final j1 articlesRepository;
    /* renamed from: b, reason: from kotlin metadata */
    private final p1 dispatcher;
    /* renamed from: c, reason: from kotlin metadata */
    private final y0 programContentRepository;
    /* renamed from: d, reason: from kotlin metadata */
    private final r2 programRepository;
    /* renamed from: e, reason: from kotlin metadata */
    private final l1 reminderRepository;
    /* renamed from: f, reason: from kotlin metadata */
    private final n3 remoteConfig;
    /* renamed from: g, reason: from kotlin metadata */
    private final i1 subscribeInteractor;
    /* renamed from: h, reason: from kotlin metadata */
    private final h0 userRepository;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.PottyProgramOverviewInteractor", f = "PottyProgramOverviewInteractor.kt", l = {80, 81, 83}, m = "getPottyProgramOverviewItem")
    static final class b extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        b(kotlin.b0.d<? super g3.b> dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return g3.this.h(this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.PottyProgramOverviewInteractor$getPottyProgramOverviewItem$2", f = "PottyProgramOverviewInteractor.kt", l = 33, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, kotlin.b0.d<? super SpecialProgramOverviewItem>, Object> {

        final /* synthetic */ PottyProgramProgress $pottyProgress;
        Object L$0;
        Object L$1;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object blockingGet;
            SpecialProgramOverviewItem.CertificateState uNLOCKED2;
            Object blockingGet2;
            int i = 1;
            Object object2;
            final Object object3 = this;
            Object obj = b.d();
            i = 1;
            if (object3.label != 0) {
                if (object3.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    object2 = object;
                    Object blockingGet4 = object3.this$0.remoteConfig.q().blockingGet();
                    n.e(blockingGet, "pottyArticles");
                    final ArrayList arrayList = new ArrayList(p.r(blockingGet, 10));
                    Iterator it = blockingGet.iterator();
                    while (it.hasNext()) {
                        Object item = it.next();
                        arrayList.add(new ArticleWithStatus(item, object3.$pottyProgress.getReadArticles().contains(item.getArticleId())));
                    }
                    if (!object3.$pottyProgress.isEnrolled()) {
                        if (!(object3.$pottyProgress.isActive())) {
                            i = 0;
                        }
                    }
                    SpecialProgramOverviewItem.CertificateState r1 = object3.$pottyProgress.hasReachedPottyGoal() ? SpecialProgramOverviewItem_CertificateState.UNLOCKED : SpecialProgramOverviewItem_CertificateState.LOCKED_HIDDEN;
                    SpecialProgramOverviewItem_CertificateData specialProgramOverviewItem_CertificateData = new SpecialProgramOverviewItem_CertificateData(object3.label.getId(), object2.getCertificatePaperImage(), object2.getCertificateLaurelsImage(), (object3.$pottyProgress.hasReachedPottyGoal() ? SpecialProgramOverviewItem_CertificateState.UNLOCKED : SpecialProgramOverviewItem_CertificateState.LOCKED_HIDDEN).isCompleted(), object2.getCertificatePlaceholderImage(), (object3.$pottyProgress.hasReachedPottyGoal() ? SpecialProgramOverviewItem_CertificateState.UNLOCKED : SpecialProgramOverviewItem_CertificateState.LOCKED_HIDDEN).getCertificateImageUrl(), (object3.$pottyProgress.hasReachedPottyGoal() ? SpecialProgramOverviewItem_CertificateState.UNLOCKED : SpecialProgramOverviewItem_CertificateState.LOCKED_HIDDEN).getCertificatePdfUrl(), object2.getCertificateRequirements(), object2.getName(), object3.label.getName(), null, (object3.$pottyProgress.hasReachedPottyGoal() ? SpecialProgramOverviewItem_CertificateState.UNLOCKED : SpecialProgramOverviewItem_CertificateState.LOCKED_HIDDEN), 1024, null);
                    n.e(blockingGet3, "pottyReminders");
                    n.e(blockingGet4, "isPremium");
                    SpecialProgramOverviewItem specialProgramOverviewItem = new SpecialProgramOverviewItem("id_potty_program", 0, null, object3.this$0.programRepository.q(), object3.$pottyProgress, arrayList, blockingGet3, new SpecialProgramOverviewItem_ProgramData(object2.getCenteredImage(), object2.getName(), object2.getDescription()), blockingGet4.booleanValue(), i, (object3.$pottyProgress.hasReachedPottyGoal() ? SpecialProgramOverviewItem_CertificateState.UNLOCKED : SpecialProgramOverviewItem_CertificateState.LOCKED_HIDDEN), null, PottyProgramOverviewInteractor.d(object3.this$0).a0(), object3.$pottyProgress.fillPottyCheckmarksList(), 2054, null);
                    return specialProgramOverviewItem;
                }
            }
            q.b(object);
            blockingGet = object3.this$0.programContentRepository.l().blockingGet();
            object3.L$0 = (DogProfile)object3.this$0.dispatcher.w().blockingGet();
            object3.L$1 = blockingGet;
            object3.label = i;
            str = "id_potty_program";
            if (object3.this$0.subscribeInteractor.g(str, object3) == obj) {
                return obj;
            }
        }

        a(PottyProgramProgress pottyProgramProgress, kotlin.b0.d<? super g3.a> dVar) {
            this.$pottyProgress = pottyProgramProgress;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super SpecialProgramOverviewItem> dVar) {
            return (kotlinx.coroutines.g3.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new kotlinx.coroutines.g3.a(g3.this, this.$pottyProgress, dVar);
        }
    }
    public g3(j1 j1Var, p1 p1Var, y0 y0Var, r2 r2Var, l1 l1Var, n3 n3Var, i1 i1Var, h0 h0Var) {
        n.f(j1Var, "programRepository");
        n.f(p1Var, "userRepository");
        n.f(y0Var, "articlesRepository");
        n.f(r2Var, "remoteConfig");
        n.f(l1Var, "reminderRepository");
        n.f(n3Var, "subscribeInteractor");
        n.f(i1Var, "programContentRepository");
        n.f(h0Var, "dispatcher");
        super();
        this.articlesRepository = j1Var;
        this.dispatcher = p1Var;
        this.programContentRepository = y0Var;
        this.programRepository = r2Var;
        this.reminderRepository = l1Var;
        this.remoteConfig = n3Var;
        this.subscribeInteractor = i1Var;
        this.userRepository = h0Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ y0 getPottyProgramOverviewItem(g3 pottyProgress) {
        return pottyProgress.programContentRepository;
    }

    public static final /* synthetic */ i1 b(g3 g3Var) {
        return g3Var.subscribeInteractor;
    }

    public static final /* synthetic */ l1 c(g3 g3Var) {
        return g3Var.reminderRepository;
    }

    public static final /* synthetic */ r2 d(g3 g3Var) {
        return g3Var.programRepository;
    }

    public static final /* synthetic */ n3 e(g3 g3Var) {
        return g3Var.remoteConfig;
    }

    public static final /* synthetic */ p1 f(g3 g3Var) {
        return g3Var.dispatcher;
    }

    private final Object g(PottyProgramProgress pottyProgramProgress, kotlin.b0.d<? super SpecialProgramOverviewItem> dVar) {
        return kotlinx.coroutines.internal.k.e(this.userRepository, new kotlinx.coroutines.g3.a(this, pottyProgramProgress, null), dVar);
    }

    public final Object h(kotlin.b0.d<? super SpecialProgramOverviewItem> dVar) {
        Object result2;
        int i;
        PottyProgramProgress pottyProgramProgress;
        String str4;
        Object dVar2;
        int label2;
        int i2 = -2147483648;
        app.dogo.com.dogo_android.s.a.g3 g3Var;
        int i3;
        j1 articlesRepository2;
        String str = null;
        long l = 0;
        int i4 = 0;
        List list = null;
        List list2 = null;
        boolean z2 = false;
        boolean z3 = false;
        String str2 = null;
        String str3 = null;
        int i5 = 0;
        g gVar = null;
        int i6 = 2047;
        int i7 = 0;
        g3Var = this;
        dVar2 = dVar;
        z = dVar2 instanceof kotlinx.coroutines.g3.b;
        if (dVar2 instanceof kotlinx.coroutines.g3.b) {
            i2 = Integer.MIN_VALUE;
            i3 = label2 & i2;
            if (label2 & i2 != 0) {
                dVar2.label -= i2;
            } else {
                app.dogo.com.dogo_android.s.a.g3.b bVar = new kotlinx.coroutines.g3.b(g3Var, dVar2);
            }
        }
        Object obj3 = b.d();
        int i8 = 3;
        int i9 = 2;
        int i10 = 1;
        if (dVar2.label != 0) {
            if (dVar2.label != i10) {
                if (dVar2.label != i9) {
                    if (dVar2.label != i8) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        q.b(dVar2.result);
                        return result2;
                    }
                }
                q.b(dVar2.result);
            } else {
                q.b(dVar2.result);
                dVar2.L$0 = g3Var;
                dVar2.label = i9;
                if (g3Var.articlesRepository.v((String)str4, dVar2) == obj3) {
                    return obj3;
                }
            }
        } else {
            q.b(dVar2.result);
            dVar2.L$0 = g3Var;
            dVar2.label = i10;
            if (g3Var.dispatcher.u(dVar2) == obj3) {
                return obj3;
            }
        }
        app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus programStatus = (DogoProgram_PottyProgram)result2.c();
        Object obj = null;
        if (programStatus == null) {
            i = obj;
        } else {
            PottyProgramProgress pottyProgramProgressItem = PottyProgramProgressKt.toPottyProgramProgressItem(programStatus);
        }
        if (g3Var.dispatcher == 0) {
            str = null;
            l = 0L;
            i4 = 0;
            list = null;
            list2 = null;
            z2 = false;
            z3 = false;
            str2 = null;
            str3 = null;
            i5 = 0;
            gVar = null;
            i6 = 2047;
            i7 = 0;
            pottyProgramProgress = new PottyProgramProgress(str, l, l2, i4, i11, list, list2, z2, z3, str2, str3, i5, gVar, i6, i7);
        }
        dVar2.L$0 = obj;
        dVar2.label = i8;
        return g3Var.g(pottyProgramProgress, dVar2) == obj3 ? obj3 : result2;
    }

    public /* synthetic */ g3(j1 j1Var, p1 p1Var, y0 y0Var, r2 r2Var, l1 l1Var, n3 n3Var, i1 i1Var, h0 h0Var, int i, g gVar) {
        h0 h0Var82;
        h0Var82 = i & 128 != 0 ? h0Var82 : h0Var;
        this(j1Var, p1Var, y0Var, r2Var, l1Var, n3Var, i1Var, h0Var82);
    }
}
