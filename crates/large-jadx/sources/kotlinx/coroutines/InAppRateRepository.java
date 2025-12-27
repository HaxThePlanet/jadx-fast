package app.dogo.com.dogo_android.a0;

import androidx.fragment.app.e;
import app.dogo.com.dogo_android.w.j0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.u2;
import com.google.android.play.core.review.ReviewInfo;
import kotlin.Metadata;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.m0;

/* compiled from: InAppRateRepository.kt */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eJ\u0011\u0010\u000f\u001a\u00020\u000cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/InAppRateRepository;", "", "reviewManager", "Lcom/google/android/play/core/review/ReviewManager;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lcom/google/android/play/core/review/ReviewManager;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "launchReviewFlow", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "info", "Lcom/google/android/play/core/review/ReviewInfo;", "source", "", "requestReview", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: c, reason: from kotlin metadata */
public final class InAppRateRepository {

    /* renamed from: a, reason: from kotlin metadata */
    private final com.google.android.play.core.review.a reviewManager;
    /* renamed from: b, reason: from kotlin metadata */
    private final o3 tracker;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lcom/google/android/play/core/review/ReviewInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.InAppRateRepository$requestReview$2", f = "InAppRateRepository.kt", l = 20, m = "invokeSuspend")
    static final class a extends kotlin.b0.k.a.k implements p<m0, kotlin.b0.d<? super ReviewInfo>, Object> {

        int label;
        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj;
            Object obj2 = b.d();
            final int i = 1;
            if (this.label != 0) {
                if (this.label != i) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    q.b(object);
                    return obj;
                }
            }
            q.b(object);
            this.label = i;
            return a.a(c.this.reviewManager, this) == obj2 ? obj2 : obj;
        }

        a(kotlin.b0.d<? super c.a> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.b0.k.a.k
        public final Object c(m0 m0Var, kotlin.b0.d<? super ReviewInfo> dVar) {
            return (kotlinx.coroutines.c.a)create(m0Var, dVar).invokeSuspend(w.a);
        }

        @Override // kotlin.b0.k.a.k
        public final kotlin.b0.d<w> create(Object object, kotlin.b0.d<?> dVar) {
            return new kotlinx.coroutines.c.a(c.this, dVar);
        }
    }
    public c(com.google.android.play.core.review.a aVar, o3 o3Var) {
        n.f(aVar, "reviewManager");
        n.f(o3Var, "tracker");
        super();
        this.reviewManager = aVar;
        this.tracker = o3Var;
    }

    public static final /* synthetic */ com.google.android.play.core.review.a a(c cVar) {
        return cVar.reviewManager;
    }

    private static final void e(Exception exc) {
        a.d(exc);
    }

    private static final void f(c cVar, String str, Void void) {
        n.f(cVar, "this$0");
        n.f(str, "$source");
        cVar.tracker.logEvent(E_RateDialog.e.c(new EP_ViewSource(), str));
    }

    public final void d(e eVar, ReviewInfo reviewInfo, String str) {
        n.f(eVar, "activity");
        n.f(reviewInfo, "info");
        n.f(str, "source");
        final com.google.android.play.core.tasks.d dVar = this.reviewManager.a(eVar, reviewInfo);
        n.e(dVar, "reviewManager.launchReviewFlow(activity, info)");
        dVar.b(kotlinx.coroutines.b.a);
        dVar.d(new kotlinx.coroutines.a(this, str));
    }

    public final Object g(kotlin.b0.d<? super ReviewInfo> dVar) {
        return kotlinx.coroutines.internal.k.e(Dispatchers.b(), new kotlinx.coroutines.c.a(this, null), dVar);
    }

    /* renamed from: b, reason: from kotlin metadata */
    public static /* synthetic */ void launchReviewFlow(c activity, String info, Void source) {
        InAppRateRepository.f(activity, info, source);
    }

    public static /* synthetic */ void c(Exception exc) {
        InAppRateRepository.e(exc);
    }
}
