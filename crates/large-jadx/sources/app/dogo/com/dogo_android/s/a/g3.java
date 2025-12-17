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
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
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
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u000c\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0008\u0008\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\u0014H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0019", d2 = {"Lapp/dogo/com/dogo_android/repository/interactor/PottyProgramOverviewInteractor;", "", "programRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;", "userRepository", "Lapp/dogo/com/dogo_android/repository/local/UserRepository;", "articlesRepository", "Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;", "remoteConfig", "Lapp/dogo/com/dogo_android/service/RemoteConfigService;", "reminderRepository", "Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;", "subscribeInteractor", "Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;", "programContentRepository", "Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lapp/dogo/com/dogo_android/repository/local/ProgramRepository;Lapp/dogo/com/dogo_android/repository/local/UserRepository;Lapp/dogo/com/dogo_android/repository/local/ArticlesRepository;Lapp/dogo/com/dogo_android/service/RemoteConfigService;Lapp/dogo/com/dogo_android/repository/local/ReminderRepository;Lapp/dogo/com/dogo_android/repository/interactor/SubscribeInteractor;Lapp/dogo/com/dogo_android/repository/local/ProgramContentRepository;Lkotlinx/coroutines/CoroutineDispatcher;)V", "getPottyProgramOverviewItem", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "pottyProgress", "Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;", "(Lapp/dogo/com/dogo_android/repository/domain/PottyProgramProgress;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class g3 {

    private final j1 a;
    private final p1 b;
    private final y0 c;
    private final r2 d;
    private final l1 e;
    private final app.dogo.com.dogo_android.s.a.n3 f;
    private final i1 g;
    private final h0 h;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.PottyProgramOverviewInteractor", f = "PottyProgramOverviewInteractor.kt", l = {80, 81, 83}, m = "getPottyProgramOverviewItem")
    static final class b extends d {

        Object L$0;
        int label;
        Object result;
        final app.dogo.com.dogo_android.s.a.g3 this$0;
        b(app.dogo.com.dogo_android.s.a.g3 g3, d<? super app.dogo.com.dogo_android.s.a.g3.b> d2) {
            this.this$0 = g3;
            super(d2);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return this.this$0.h(this);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lapp/dogo/com/dogo_android/repository/domain/SpecialProgramOverviewItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.repository.interactor.PottyProgramOverviewInteractor$getPottyProgramOverviewItem$2", f = "PottyProgramOverviewInteractor.kt", l = 33, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super SpecialProgramOverviewItem>, Object> {

        final PottyProgramProgress $pottyProgress;
        Object L$0;
        Object L$1;
        int label;
        final app.dogo.com.dogo_android.s.a.g3 this$0;
        a(app.dogo.com.dogo_android.s.a.g3 g3, PottyProgramProgress pottyProgramProgress2, d<? super app.dogo.com.dogo_android.s.a.g3.a> d3) {
            this.this$0 = g3;
            this.$pottyProgress = pottyProgramProgress2;
            super(2, d3);
        }

        public final Object c(m0 m0, d<? super SpecialProgramOverviewItem> d2) {
            return (g3.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            g3.a obj3 = new g3.a(this.this$0, this.$pottyProgress, d2);
            return obj3;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object l$1;
            boolean enrolled;
            SpecialProgramOverviewItem.CertificateState lOCKED_HIDDEN;
            Object blockingGet;
            int i;
            Object blockingGet2;
            Object obj;
            String str;
            int next;
            String articleWithStatus;
            boolean contains;
            String articleId;
            final Object obj2 = this;
            Object obj3 = b.d();
            int label = obj2.label;
            i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    l$1 = obj2.L$1;
                    blockingGet = obj2.L$0;
                    q.b(object);
                    obj = object;
                    final Object obj4 = blockingGet3;
                    Object blockingGet4 = g3.e(obj2.this$0).q().blockingGet();
                    SpecialProgramOverviewItem.ProgramData programData = new SpecialProgramOverviewItem.ProgramData(obj.getCenteredImage(), (ProgramModel)obj.getName(), obj.getDescription());
                    n.e(l$1, "pottyArticles");
                    ArrayList arrayList = new ArrayList(p.r(l$1, 10));
                    Iterator iterator = l$1.iterator();
                    for (Article next : iterator) {
                        articleWithStatus = new ArticleWithStatus(next, obj2.$pottyProgress.getReadArticles().contains(next.getArticleId()));
                        arrayList.add(articleWithStatus);
                    }
                    if (!obj2.$pottyProgress.isEnrolled()) {
                        if (obj2.$pottyProgress.isActive()) {
                        } else {
                            i = 0;
                        }
                    }
                    lOCKED_HIDDEN = obj2.$pottyProgress.hasReachedPottyGoal() ? SpecialProgramOverviewItem.CertificateState.UNLOCKED : SpecialProgramOverviewItem.CertificateState.LOCKED_HIDDEN;
                    super(blockingGet.getId(), obj.getCertificatePaperImage(), obj.getCertificateLaurelsImage(), obj2.$pottyProgress.isCompleted(), obj.getCertificatePlaceholderImage(), obj2.$pottyProgress.getCertificateImageUrl(), obj2.$pottyProgress.getCertificatePdfUrl(), obj.getCertificateRequirements(), obj.getName(), blockingGet.getName(), 0, lOCKED_HIDDEN, 1024, 0);
                    n.e((List)obj4, "pottyReminders");
                    n.e((Boolean)blockingGet4, "isPremium");
                    super("id_potty_program", 0, 0, g3.d(obj2.this$0).q(), obj2.$pottyProgress, arrayList, obj4, programData, blockingGet4.booleanValue(), i, certificateData, 0, g3.d(obj2.this$0).a0(), obj2.$pottyProgress.fillPottyCheckmarksList(), 2054, 0);
                    return specialProgramOverviewItem;
                }
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw illegalStateException;
            }
            q.b(object);
            blockingGet2 = g3.a(obj2.this$0).l().blockingGet();
            obj2.L$0 = (DogProfile)g3.f(obj2.this$0).w().blockingGet();
            obj2.L$1 = (List)blockingGet2;
            obj2.label = i;
            if (g3.b(obj2.this$0).g("id_potty_program", obj2) == obj3) {
                return obj3;
            }
            l$1 = blockingGet2;
        }
    }
    public g3(j1 j1, p1 p12, y0 y03, r2 r24, l1 l15, app.dogo.com.dogo_android.s.a.n3 n36, i1 i17, h0 h08) {
        n.f(j1, "programRepository");
        n.f(p12, "userRepository");
        n.f(y03, "articlesRepository");
        n.f(r24, "remoteConfig");
        n.f(l15, "reminderRepository");
        n.f(n36, "subscribeInteractor");
        n.f(i17, "programContentRepository");
        n.f(h08, "dispatcher");
        super();
        this.a = j1;
        this.b = p12;
        this.c = y03;
        this.d = r24;
        this.e = l15;
        this.f = n36;
        this.g = i17;
        this.h = h08;
    }

    public g3(j1 j1, p1 p12, y0 y03, r2 r24, l1 l15, app.dogo.com.dogo_android.s.a.n3 n36, i1 i17, h0 h08, int i9, g g10) {
        h0 i;
        h0 h0Var;
        if (i2 &= 128 != 0) {
            h0Var = i;
        } else {
            h0Var = h08;
        }
        super(j1, p12, y03, r24, l15, n36, i17, h0Var);
    }

    public static final y0 a(app.dogo.com.dogo_android.s.a.g3 g3) {
        return g3.c;
    }

    public static final i1 b(app.dogo.com.dogo_android.s.a.g3 g3) {
        return g3.g;
    }

    public static final l1 c(app.dogo.com.dogo_android.s.a.g3 g3) {
        return g3.e;
    }

    public static final r2 d(app.dogo.com.dogo_android.s.a.g3 g3) {
        return g3.d;
    }

    public static final app.dogo.com.dogo_android.s.a.n3 e(app.dogo.com.dogo_android.s.a.g3 g3) {
        return g3.f;
    }

    public static final p1 f(app.dogo.com.dogo_android.s.a.g3 g3) {
        return g3.b;
    }

    private final Object g(PottyProgramProgress pottyProgramProgress, d<? super SpecialProgramOverviewItem> d2) {
        g3.a aVar = new g3.a(this, pottyProgramProgress, 0);
        return k.e(this.h, aVar, d2);
    }

    public final Object h(d<? super SpecialProgramOverviewItem> d) {
        Object result;
        int pottyProgramProgress;
        boolean bVar;
        int label;
        int i15;
        app.dogo.com.dogo_android.s.a.g3 label2;
        int i5;
        int i8;
        j1 i13;
        int i12;
        int i6;
        int i7;
        int i2;
        int i;
        int i9;
        int i17;
        int i3;
        int i10;
        int i11;
        int i14;
        int i16;
        int i4;
        final app.dogo.com.dogo_android.s.a.g3 g3Var = this;
        Object obj = d;
        bVar = obj;
        label = bVar.label;
        i15 = Integer.MIN_VALUE;
        if (obj instanceof g3.b && label & i15 != 0) {
            bVar = obj;
            label = bVar.label;
            i15 = Integer.MIN_VALUE;
            if (label & i15 != 0) {
                bVar.label = label -= i15;
            } else {
                bVar = new g3.b(g3Var, obj);
            }
        } else {
        }
        result = bVar.result;
        Object obj2 = b.d();
        label2 = bVar.label;
        int i18 = 3;
        i8 = 2;
        i13 = 1;
        if (label2 != 0) {
            if (label2 != i13) {
                if (label2 != i8) {
                    if (label2 != i18) {
                    } else {
                        q.b(result);
                        return result;
                    }
                    IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    throw illegalStateException;
                }
                label2 = bVar.L$0;
                q.b(result);
            } else {
                label2 = bVar.L$0;
                q.b(result);
                bVar.L$0 = label2;
                bVar.label = i8;
                if (label2.a.v((String)result, bVar) == obj2) {
                    return obj2;
                }
            }
        } else {
            q.b(result);
            bVar.L$0 = g3Var;
            bVar.label = i13;
            if (g3Var.b.u(bVar) == obj2) {
                return obj2;
            }
            label2 = g3Var;
        }
        app.dogo.externalmodel.model.PottyProgramProgressModel.ProgramStatus programStatus = (k.c)result.c();
        i8 = 0;
        if (programStatus == null) {
            pottyProgramProgress = i8;
        } else {
            pottyProgramProgress = PottyProgramProgressKt.toPottyProgramProgressItem(programStatus);
        }
        if (pottyProgramProgress == 0) {
            super(0, 0, obj10, 0, obj12, 0, 0, 0, 0, 0, 0, 0, 0, 2047, 0);
        }
        bVar.L$0 = i8;
        bVar.label = i18;
        if (label2.g(pottyProgramProgress, bVar) == obj2) {
            return obj2;
        }
    }
}
