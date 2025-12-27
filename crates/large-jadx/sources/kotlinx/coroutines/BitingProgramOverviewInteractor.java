package app.dogo.com.dogo_android.s.a;

import app.dogo.android.persistencedb.room.entity.TrickEntity;
import app.dogo.com.dogo_android.model.trainingprogram.ProgramModel;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.ArticleWithStatus;
import app.dogo.com.dogo_android.repository.domain.BitingProgramProgress;
import app.dogo.com.dogo_android.repository.domain.BitingProgramProgressKt;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateData;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.CertificateState;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations;
import app.dogo.com.dogo_android.s.b.i1;
import app.dogo.com.dogo_android.s.b.j1;
import app.dogo.com.dogo_android.s.b.o1;
import app.dogo.com.dogo_android.s.b.p1;
import app.dogo.com.dogo_android.s.b.y0;
import app.dogo.com.dogo_android.service.r2;
import app.dogo.com.dogo_android.util.h0.m1;
import app.dogo.com.dogo_android.y.k.a;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.m0;

/* compiled from: BitingProgramOverviewInteractor.kt */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/BitingProgramOverviewInteractor;", "", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "articlesRepository", "Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;", "remoteConfig", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "zendeskInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/ZendeskInteractor;", "programContentRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "dispatchers", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/repository/interactor/ZendeskInteractor;Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getBitingProgramOverviewItem", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "progress", "Lapp/dogo/com/dogo_android/repository/domain/BitingProgramProgress;", "(Lapp/dogo/com/dogo_android/repository/domain/BitingProgramProgress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: z1, reason: from kotlin metadata */
public final class BitingProgramOverviewInteractor {

    /* renamed from: a, reason: from kotlin metadata */
    private final j1 articlesRepository;
    /* renamed from: b, reason: from kotlin metadata */
    private final p1 dispatchers;
    /* renamed from: c, reason: from kotlin metadata */
    private final y0 programContentRepository;
    /* renamed from: d, reason: from kotlin metadata */
    private final r2 programRepository;
    /* renamed from: e, reason: from kotlin metadata */
    private final o1 remoteConfig;
    /* renamed from: f, reason: from kotlin metadata */
    private final s3 subscribeInteractor;
    /* renamed from: g, reason: from kotlin metadata */
    private final i1 tricksRepository;
    /* renamed from: h, reason: from kotlin metadata */
    private final n3 userRepository;
    /* renamed from: i, reason: from kotlin metadata */
    private final h0 zendeskInteractor;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.BitingProgramOverviewInteractor$getBitingProgramOverviewItem$2", f = "BitingProgramOverviewInteractor.kt", l = 36, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super SpecialProgramOverviewItem>, Object> {

        final /* synthetic */ BitingProgramProgress $progress;
        Object L$0;
        Object L$1;
        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object blockingGet;
            Object blockingGet2;
            SpecialProgramOverviewItem.CertificateState uNLOCKED2;
            Object object2;
            int i3 = 10;
            Object value2;
            boolean hasNext;
            ArrayList arrayList2;
            int i6;
            Map map2;
            int i7;
            kotlin.d0.d.g gVar;
            String str2;
            String str3;
            String str4;
            boolean z;
            int i8;
            List list2;
            List list3;
            boolean z2;
            int i9;
            List list4;
            app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory trickCategory;
            boolean z3;
            app.dogo.com.dogo_android.repository.domain.TrickItem.VimeoData vimeoData;
            boolean z4;
            String str5;
            List list5;
            String str6;
            int i10;
            int i11;
            Object obj;
            final Object object3 = this;
            Object obj2 = b.d();
            int i = 1;
            if (object3.label != 0) {
                if (object3.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    object2 = object;
                    Object blockingGet3 = object3.this$0.remoteConfig.l().blockingGet();
                    Object blockingGet4 = object3.this$0.subscribeInteractor.f().blockingGet();
                    Object blockingGet5 = object3.this$0.userRepository.q().blockingGet();
                    Map map = null;
                    SpecialProgramKnowledgeHolder specialProgramKnowledgeHolder = new SpecialProgramKnowledgeHolder(blockingGet2.getId(), map, 2, map);
                    specialProgramKnowledgeHolder.addAll(object3.$progress.getTricks());
                    n.e(blockingGet3, "programTricks");
                    i3 = 10;
                    ArrayList arrayList3 = new ArrayList(p.r(blockingGet3, i3));
                    Iterator it3 = blockingGet3.iterator();
                    while (it3.hasNext()) {
                        Object item2 = it3.next();
                        TrickItemWithVariations cacheValid = app.dogo.com.dogo_android.util.extensionfunction.m1.isCacheValid(item2, b.c(value2.getKnowledge()), value2.getVariations());
                        List variations = cacheValid.getVariations();
                        arrayList2 = new ArrayList(p.r(variations, i3));
                        Iterator it2 = variations.iterator();
                        while (it2.hasNext()) {
                            str2 = null;
                            str3 = null;
                            str4 = null;
                            z = false;
                            i8 = 0;
                            list2 = null;
                            list3 = null;
                            z2 = false;
                            i9 = 0;
                            list4 = null;
                            trickCategory = null;
                            int i4 = 4;
                            vimeoData = null;
                            z4 = false;
                            str5 = null;
                            list5 = null;
                            str6 = null;
                            i10 = 0;
                            i11 = 1040383;
                            obj = null;
                            arrayList2.add(TrickItem.copy$default((TrickItem)it2.next(), null, null, null, null, null, false, null, null, null, false, 0, null, null, z3, vimeoData, z4, str5, list5, str6, i10, i11, obj));
                            i3 = 10;
                        }
                        i = 1;
                        arrayList3.add(TrickItemWithVariations.copy$default(cacheValid, map, arrayList2, i, map));
                        i3 = 10;
                        str2 = null;
                        str3 = null;
                        str4 = null;
                        z = false;
                        i8 = 0;
                        list2 = null;
                        list3 = null;
                        z2 = false;
                        i9 = 0;
                        list4 = null;
                        trickCategory = null;
                        i4 = 4;
                        vimeoData = null;
                        z4 = false;
                        str5 = null;
                        list5 = null;
                        str6 = null;
                        i10 = 0;
                        i11 = 1040383;
                        obj = null;
                        arrayList2.add(TrickItem.copy$default((TrickItem)it2.next(), null, null, null, null, null, false, null, null, null, false, 0, null, null, z3, vimeoData, z4, str5, list5, str6, i10, i11, obj));
                        i3 = 10;
                    }
                    SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem_ProgramProgressData = new SpecialProgramOverviewItem_ProgramProgressData(object3.$progress.getArticleCompletionPercentage(), object3.$progress.getArticlesAreCompleted(), object3.$progress.getTrickCompletionPercentage(), object3.$progress.getTricksAreCompleted());
                    n.e(blockingGet, "articles");
                    ArrayList arrayList = new ArrayList(p.r(blockingGet, 10));
                    Iterator it = blockingGet.iterator();
                    while (it.hasNext()) {
                        Object item = it.next();
                        arrayList.add(new ArticleWithStatus(item, object3.$progress.getReadArticles().contains(item.getArticleId())));
                    }
                    SpecialProgramOverviewItem.CertificateState r2 = object3.$progress.getProgramIsCompleted() ? SpecialProgramOverviewItem_CertificateState.UNLOCKED : SpecialProgramOverviewItem_CertificateState.LOCKED;
                    SpecialProgramOverviewItem_CertificateData specialProgramOverviewItem_CertificateData = new SpecialProgramOverviewItem_CertificateData(blockingGet2.getId(), object2.getCertificatePaperImage(), null, object3.$progress.getProgramIsCompleted(), object2.getCertificatePlaceholderImage(), object3.$progress.getCertificateImageUrl(), object3.$progress.getCertificatePdfUrl(), object2.getCertificateRequirements(), object2.getName(), blockingGet2.getName(), specialProgramOverviewItem_ProgramProgressData, (object3.$progress.getProgramIsCompleted() ? SpecialProgramOverviewItem_CertificateState.UNLOCKED : SpecialProgramOverviewItem_CertificateState.LOCKED), 4, null);
                    n.e(blockingGet4, "unreadMessageCount");
                    n.e(blockingGet5, "isPremium");
                    SpecialProgramOverviewItem specialProgramOverviewItem = new SpecialProgramOverviewItem("id_nipping_program", blockingGet4.intValue(), p.D0(arrayList3, new kotlinx.coroutines.z1.a.a()), object3.this$0.programRepository.l(), null, arrayList, null, new SpecialProgramOverviewItem_ProgramData(object2.getCenteredImage(), object2.getName(), object2.getDescription()), blockingGet5.booleanValue(), object3.$progress.isEnrolled(), (object3.$progress.getProgramIsCompleted() ? SpecialProgramOverviewItem_CertificateState.UNLOCKED : SpecialProgramOverviewItem_CertificateState.LOCKED), specialProgramOverviewItem_ProgramProgressData, false, null, 12368, null);
                    return specialProgramOverviewItem;
                }
            }
            q.b(object);
            blockingGet = object3.this$0.programContentRepository.h().blockingGet();
            object3.L$0 = (DogProfile)object3.this$0.dispatchers.w().blockingGet();
            object3.L$1 = blockingGet;
            object3.label = i;
            str = "id_nipping_program";
            if (object3.this$0.tricksRepository.g(str, object3) == obj2) {
                return obj2;
            }
        }

        a(BitingProgramProgress bitingProgramProgress, d<? super z1.a> dVar) {
            this.$progress = bitingProgramProgress;
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super SpecialProgramOverviewItem> dVar) {
            return (kotlinx.coroutines.z1.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.z1.a(z1.this, this.$progress, dVar);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.BitingProgramOverviewInteractor$getBitingProgramOverviewItem$4", f = "BitingProgramOverviewInteractor.kt", l = {106, 107, 109}, m = "invokeSuspend")
    static final class b extends kotlin.b0.k.a.k implements kotlin.d0.c.p<m0, d<? super SpecialProgramOverviewItem>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object object2;
            BitingProgramProgress bitingProgramProgressItem = null;
            String str3;
            int i2 = 1;
            long l = 0;
            String str = null;
            List list = null;
            List list2 = null;
            boolean z = false;
            boolean z2 = false;
            boolean z3 = false;
            int i3 = 0;
            int i4 = 0;
            boolean z4 = false;
            int i5 = 0;
            kotlin.d0.d.g gVar = null;
            int i6 = 8191;
            int i7 = 0;
            final Object object3 = this;
            Object obj = b.d();
            final int i9 = 3;
            int i = 2;
            i2 = 1;
            if (object3.label != 0) {
                if (object3.label != i2) {
                    if (object3.label != i) {
                        if (object3.label != i9) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            q.b(object);
                            object2 = object;
                            return object2;
                        }
                    }
                    q.b(object);
                    object2 = object;
                } else {
                    q.b(object);
                    object2 = object;
                    object3.label = i;
                    if (object3.this$0.articlesRepository.q((String)str3, object3) == obj) {
                        return obj;
                    }
                }
            } else {
                q.b(object);
                object3.label = i2;
                if (object3.this$0.dispatchers.u(object3) == obj) {
                    return obj;
                }
            }
            app.dogo.externalmodel.model.BitingProgressModel bitingProgressModel = (DogoProgram_BitingProgram)object2.c();
            if (bitingProgressModel == null) {
                int i8 = 0;
            } else {
                bitingProgramProgressItem = BitingProgramProgressKt.toBitingProgramProgressItem(bitingProgressModel);
            }
            if (object3.label == null) {
                l = 0L;
                str = null;
                list = null;
                list2 = null;
                z = false;
                z2 = false;
                z3 = false;
                i3 = 0;
                i4 = 0;
                z4 = false;
                i5 = 0;
                gVar = null;
                i6 = 8191;
                i7 = 0;
                bitingProgramProgressItem = new BitingProgramProgress(null, l, l2, str, str5, list, list2, z, z2, z3, i3, i4, z4, i5, gVar, i6, i7);
            }
            object3.label = i9;
            return object3.this$0.j(bitingProgramProgressItem, object3) == obj ? obj : object2;
        }

        b(d<? super z1.b> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, d<? super SpecialProgramOverviewItem> dVar) {
            return (kotlinx.coroutines.z1.b)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final d<w> create(Object object, d<?> dVar) {
            return new kotlinx.coroutines.z1.b(z1.this, dVar);
        }
    }
    public z1(j1 j1Var, p1 p1Var, y0 y0Var, r2 r2Var, o1 o1Var, s3 s3Var, i1 i1Var, n3 n3Var, h0 h0Var) {
        n.f(j1Var, "programRepository");
        n.f(p1Var, "userRepository");
        n.f(y0Var, "articlesRepository");
        n.f(r2Var, "remoteConfig");
        n.f(o1Var, "tricksRepository");
        n.f(s3Var, "zendeskInteractor");
        n.f(i1Var, "programContentRepository");
        n.f(n3Var, "subscribeInteractor");
        n.f(h0Var, "dispatchers");
        super();
        this.articlesRepository = j1Var;
        this.dispatchers = p1Var;
        this.programContentRepository = y0Var;
        this.programRepository = r2Var;
        this.remoteConfig = o1Var;
        this.subscribeInteractor = s3Var;
        this.tricksRepository = i1Var;
        this.userRepository = n3Var;
        this.zendeskInteractor = h0Var;
    }

    /* renamed from: a, reason: from kotlin metadata */
    /* suspend */ public static final /* synthetic */ y0 getBitingProgramOverviewItem(z1 progress) {
        return progress.programContentRepository;
    }

    public static final /* synthetic */ Object b(z1 z1Var, BitingProgramProgress bitingProgramProgress, d dVar) {
        return z1Var.j(bitingProgramProgress, dVar);
    }

    public static final /* synthetic */ i1 c(z1 z1Var) {
        return z1Var.tricksRepository;
    }

    public static final /* synthetic */ j1 d(z1 z1Var) {
        return z1Var.articlesRepository;
    }

    public static final /* synthetic */ r2 e(z1 z1Var) {
        return z1Var.programRepository;
    }

    public static final /* synthetic */ n3 f(z1 z1Var) {
        return z1Var.userRepository;
    }

    public static final /* synthetic */ o1 g(z1 z1Var) {
        return z1Var.remoteConfig;
    }

    public static final /* synthetic */ p1 h(z1 z1Var) {
        return z1Var.dispatchers;
    }

    public static final /* synthetic */ s3 i(z1 z1Var) {
        return z1Var.subscribeInteractor;
    }

    private final Object j(BitingProgramProgress bitingProgramProgress, d<? super SpecialProgramOverviewItem> dVar) {
        return kotlinx.coroutines.internal.k.e(this.zendeskInteractor, new kotlinx.coroutines.z1.a(this, bitingProgramProgress, null), dVar);
    }

    public final Object k(d<? super SpecialProgramOverviewItem> dVar) {
        return kotlinx.coroutines.internal.k.e(this.zendeskInteractor, new kotlinx.coroutines.z1.b(this, null), dVar);
    }

    public /* synthetic */ z1(j1 j1Var, p1 p1Var, y0 y0Var, r2 r2Var, o1 o1Var, s3 s3Var, i1 i1Var, n3 n3Var, h0 h0Var, int i, kotlin.d0.d.g gVar) {
        h0 h0Var92;
        h0Var92 = i & 256 != 0 ? h0Var92 : h0Var;
        this(j1Var, p1Var, y0Var, r2Var, o1Var, s3Var, i1Var, n3Var, h0Var92);
    }
}
