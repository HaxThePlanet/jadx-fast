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
import e.a.a.a.b.d.g;
import i.b.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlin.y.p;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0016H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/BitingProgramOverviewInteractor;", "", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "articlesRepository", "Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;", "remoteConfig", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "tricksRepository", "Lapp/dogo/com/dogo_android/repository/local/TricksRepository;", "zendeskInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/ZendeskInteractor;", "programContentRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "dispatchers", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/TricksRepository;Lapp/dogo/com/dogo_android/repository/interactor/ZendeskInteractor;Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getBitingProgramOverviewItem", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "progress", "Lapp/dogo/com/dogo_android/repository/domain/BitingProgramProgress;", "(Lapp/dogo/com/dogo_android/repository/domain/BitingProgramProgress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class z1 {

    private final j1 a;
    private final p1 b;
    private final y0 c;
    private final r2 d;
    private final o1 e;
    private final app.dogo.com.dogo_android.s.a.s3 f;
    private final i1 g;
    private final app.dogo.com.dogo_android.s.a.n3 h;
    private final h0 i;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.BitingProgramOverviewInteractor$getBitingProgramOverviewItem$2", f = "BitingProgramOverviewInteractor.kt", l = 36, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super SpecialProgramOverviewItem>, Object> {

        final BitingProgramProgress $progress;
        Object L$0;
        Object L$1;
        int label;
        final app.dogo.com.dogo_android.s.a.z1 this$0;
        a(app.dogo.com.dogo_android.s.a.z1 z1, BitingProgramProgress bitingProgramProgress2, d<? super app.dogo.com.dogo_android.s.a.z1.a> d3) {
            this.this$0 = z1;
            this.$progress = bitingProgramProgress2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super SpecialProgramOverviewItem> d2) {
            return (z1.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            z1.a obj3 = new z1.a(this.this$0, this.$progress, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$1;
            Object blockingGet2;
            SpecialProgramOverviewItem.CertificateState uNLOCKED;
            int i9;
            Object blockingGet;
            Object obj;
            String str;
            int next;
            int i20;
            int i21;
            boolean tricksAreCompleted;
            int contains;
            int i15;
            Object trickAndVariationKnowledge;
            boolean articleId;
            Object trickId;
            List variations;
            ArrayList arrayList;
            int i28;
            int i12;
            int i5;
            int i26;
            int i24;
            int i22;
            int i14;
            int i13;
            int i4;
            int i7;
            int i25;
            int i6;
            int i27;
            int i2;
            int i10;
            int i3;
            int i17;
            int i23;
            int i18;
            int i8;
            int i16;
            int i19;
            int i;
            int i11;
            final Object obj2 = this;
            Object obj3 = b.d();
            int label = obj2.label;
            i9 = 1;
            if (label != 0) {
                if (label != i9) {
                } else {
                    l$1 = obj2.L$1;
                    blockingGet2 = obj2.L$0;
                    q.b(object);
                    obj = object;
                    Object blockingGet3 = z1.g(obj2.this$0).l().blockingGet();
                    Object blockingGet4 = z1.i(obj2.this$0).f().blockingGet();
                    Object blockingGet5 = z1.f(obj2.this$0).q().blockingGet();
                    contains = 0;
                    SpecialProgramKnowledgeHolder specialProgramKnowledgeHolder = new SpecialProgramKnowledgeHolder(blockingGet2.getId(), contains, 2, contains);
                    specialProgramKnowledgeHolder.addAll(obj2.$progress.getTricks());
                    n.e((List)blockingGet3, "programTricks");
                    ArrayList arrayList3 = new ArrayList(p.r(blockingGet3, 10));
                    Iterator iterator3 = blockingGet3.iterator();
                    while (iterator3.hasNext()) {
                        Object next4 = iterator3.next();
                        if ((SpecialProgramKnowledgeHolder.TrickAndVariationKnowledge)specialProgramKnowledgeHolder.getTricks().get((g)next4.d().getTrickId()) == null) {
                        }
                        i15 = m1.F(next4, b.c(trickAndVariationKnowledge.getKnowledge()), trickAndVariationKnowledge.getVariations());
                        variations = i15.getVariations();
                        arrayList = new ArrayList(p.r(variations, i20));
                        Iterator iterator2 = variations.iterator();
                        while (iterator2.hasNext()) {
                            if (trickAndVariationKnowledge.getKnowledge() < 4) {
                            } else {
                            }
                            i3 = i21;
                            arrayList.add(TrickItem.copy$default((TrickItem)iterator2.next(), 0, 0, 0, 0, false, 0, 0, 0, 0, obj27, 0, 0, 0, false, i3, false, 0, 0, 0, 0, 0, 1040383));
                            i20 = 10;
                            i3 = 1;
                        }
                        int i32 = 1;
                        arrayList3.add(TrickItemWithVariations.copy$default(i15, contains, arrayList, i32, contains));
                        i9 = i32;
                        i20 = 10;
                        if (trickAndVariationKnowledge.getKnowledge() < 4) {
                        } else {
                        }
                        i3 = i21;
                        arrayList.add(TrickItem.copy$default((TrickItem)iterator2.next(), 0, 0, 0, 0, false, 0, 0, 0, 0, obj27, 0, 0, 0, false, i3, false, 0, 0, 0, 0, 0, 1040383));
                        i20 = 10;
                        i3 = 1;
                        super(next4.d().getTrickId(), 0, 0, 6, 0);
                    }
                    z1.a.a aVar = new z1.a.a();
                    SpecialProgramOverviewItem.ProgramProgressData programProgressData = new SpecialProgramOverviewItem.ProgramProgressData(obj2.$progress.getArticleCompletionPercentage(), obj2.$progress.getArticlesAreCompleted(), obj2.$progress.getTrickCompletionPercentage(), obj2.$progress.getTricksAreCompleted());
                    SpecialProgramOverviewItem.ProgramData programData2 = new SpecialProgramOverviewItem.ProgramData(obj.getCenteredImage(), (ProgramModel)obj.getName(), obj.getDescription());
                    n.e(l$1, "articles");
                    ArrayList arrayList2 = new ArrayList(p.r(l$1, 10));
                    Iterator iterator = l$1.iterator();
                    for (Article next : iterator) {
                        tricksAreCompleted = new ArticleWithStatus(next, obj2.$progress.getReadArticles().contains(next.getArticleId()));
                        arrayList2.add(tricksAreCompleted);
                    }
                    uNLOCKED = obj2.$progress.getProgramIsCompleted() ? SpecialProgramOverviewItem.CertificateState.UNLOCKED : SpecialProgramOverviewItem.CertificateState.LOCKED;
                    super(blockingGet2.getId(), obj.getCertificatePaperImage(), 0, obj2.$progress.getProgramIsCompleted(), obj.getCertificatePlaceholderImage(), obj2.$progress.getCertificateImageUrl(), obj2.$progress.getCertificatePdfUrl(), obj.getCertificateRequirements(), obj.getName(), blockingGet2.getName(), programProgressData, uNLOCKED, 4, 0);
                    n.e((Integer)blockingGet4, "unreadMessageCount");
                    n.e((Boolean)blockingGet5, "isPremium");
                    super("id_nipping_program", blockingGet4.intValue(), p.D0(arrayList3, aVar), z1.e(obj2.this$0).l(), 0, arrayList2, 0, programData2, blockingGet5.booleanValue(), obj2.$progress.isEnrolled(), certificateData, programProgressData, 0, 0, 12368, 0);
                    return specialProgramOverviewItem;
                }
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw illegalStateException;
            }
            q.b(object);
            blockingGet = z1.a(obj2.this$0).h().blockingGet();
            obj2.L$0 = (DogProfile)z1.h(obj2.this$0).w().blockingGet();
            obj2.L$1 = (List)blockingGet;
            obj2.label = i9;
            if (z1.c(obj2.this$0).g("id_nipping_program", obj2) == obj3) {
                return obj3;
            }
            l$1 = blockingGet;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.BitingProgramOverviewInteractor$getBitingProgramOverviewItem$4", f = "BitingProgramOverviewInteractor.kt", l = {106, 107, 109}, m = "invokeSuspend")
    static final class b extends k implements p<m0, d<? super SpecialProgramOverviewItem>, Object> {

        int label;
        final app.dogo.com.dogo_android.s.a.z1 this$0;
        b(app.dogo.com.dogo_android.s.a.z1 z1, d<? super app.dogo.com.dogo_android.s.a.z1.b> d2) {
            this.this$0 = z1;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super SpecialProgramOverviewItem> d2) {
            return (z1.b)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            z1.b obj2 = new z1.b(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj2;
            BitingProgramProgress bitingProgramProgressItem;
            Object obj;
            Object obj3;
            int this$0;
            int i9;
            int i12;
            int i14;
            int i13;
            int i2;
            int i5;
            int i7;
            int i;
            int i8;
            int i10;
            int i11;
            int i15;
            int i3;
            int i4;
            int i6;
            final Object obj4 = this;
            Object obj5 = b.d();
            int label = obj4.label;
            final int i16 = 3;
            this$0 = 2;
            i9 = 1;
            if (label != 0) {
                if (label != i9) {
                    if (label != this$0) {
                        if (label != i16) {
                        } else {
                            q.b(object);
                            obj3 = object;
                            return obj3;
                        }
                        IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        throw illegalStateException;
                    }
                    q.b(object);
                    obj2 = object;
                } else {
                    q.b(object);
                    obj = object;
                    obj4.label = this$0;
                    if (z1.d(obj4.this$0).q((String)obj, obj4) == obj5) {
                        return obj5;
                    }
                }
            } else {
                q.b(object);
                obj4.label = i9;
                if (z1.h(obj4.this$0).u(obj4) == obj5) {
                    return obj5;
                }
            }
            app.dogo.externalmodel.model.BitingProgressModel bitingProgressModel = (k.a)obj2.c();
            if (bitingProgressModel == null) {
                bitingProgramProgressItem = 0;
            } else {
                bitingProgramProgressItem = BitingProgramProgressKt.toBitingProgramProgressItem(bitingProgressModel);
            }
            if (bitingProgramProgressItem == null) {
                super(0, 0, obj7, 0, obj9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8191, 0);
            }
            obj4.label = i16;
            if (z1.b(obj4.this$0, bitingProgramProgressItem, obj4) == obj5) {
                return obj5;
            }
        }
    }
    public z1(j1 j1, p1 p12, y0 y03, r2 r24, o1 o15, app.dogo.com.dogo_android.s.a.s3 s36, i1 i17, app.dogo.com.dogo_android.s.a.n3 n38, h0 h09) {
        n.f(j1, "programRepository");
        n.f(p12, "userRepository");
        n.f(y03, "articlesRepository");
        n.f(r24, "remoteConfig");
        n.f(o15, "tricksRepository");
        n.f(s36, "zendeskInteractor");
        n.f(i17, "programContentRepository");
        n.f(n38, "subscribeInteractor");
        n.f(h09, "dispatchers");
        super();
        this.a = j1;
        this.b = p12;
        this.c = y03;
        this.d = r24;
        this.e = o15;
        this.f = s36;
        this.g = i17;
        this.h = n38;
        this.i = h09;
    }

    public z1(j1 j1, p1 p12, y0 y03, r2 r24, o1 o15, app.dogo.com.dogo_android.s.a.s3 s36, i1 i17, app.dogo.com.dogo_android.s.a.n3 n38, h0 h09, int i10, g g11) {
        h0 i;
        h0 h0Var;
        if (i2 &= 256 != 0) {
            h0Var = i;
        } else {
            h0Var = h09;
        }
        super(j1, p12, y03, r24, o15, s36, i17, n38, h0Var);
    }

    public static final y0 a(app.dogo.com.dogo_android.s.a.z1 z1) {
        return z1.c;
    }

    public static final Object b(app.dogo.com.dogo_android.s.a.z1 z1, BitingProgramProgress bitingProgramProgress2, d d3) {
        return z1.j(bitingProgramProgress2, d3);
    }

    public static final i1 c(app.dogo.com.dogo_android.s.a.z1 z1) {
        return z1.g;
    }

    public static final j1 d(app.dogo.com.dogo_android.s.a.z1 z1) {
        return z1.a;
    }

    public static final r2 e(app.dogo.com.dogo_android.s.a.z1 z1) {
        return z1.d;
    }

    public static final app.dogo.com.dogo_android.s.a.n3 f(app.dogo.com.dogo_android.s.a.z1 z1) {
        return z1.h;
    }

    public static final o1 g(app.dogo.com.dogo_android.s.a.z1 z1) {
        return z1.e;
    }

    public static final p1 h(app.dogo.com.dogo_android.s.a.z1 z1) {
        return z1.b;
    }

    public static final app.dogo.com.dogo_android.s.a.s3 i(app.dogo.com.dogo_android.s.a.z1 z1) {
        return z1.f;
    }

    private final Object j(BitingProgramProgress bitingProgramProgress, d<? super SpecialProgramOverviewItem> d2) {
        z1.a aVar = new z1.a(this, bitingProgramProgress, 0);
        return k.e(this.i, aVar, d2);
    }

    public final Object k(d<? super SpecialProgramOverviewItem> d) {
        z1.b bVar = new z1.b(this, 0);
        return k.e(this.i, bVar, d);
    }
}
