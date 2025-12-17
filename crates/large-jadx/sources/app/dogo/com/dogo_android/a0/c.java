package app.dogo.com.dogo_android.a0;

import androidx.fragment.app.e;
import app.dogo.com.dogo_android.w.j0;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.r2;
import app.dogo.com.dogo_android.w.u2;
import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.a;
import com.google.android.play.core.tasks.d;
import f.c.a.f.a.b.a;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.b0.k.a.k;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.k;
import kotlinx.coroutines.m0;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eJ\u0011\u0010\u000f\u001a\u00020\u000cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/viewmodel/InAppRateRepository;", "", "reviewManager", "Lcom/google/android/play/core/review/ReviewManager;", "tracker", "Lapp/dogo/com/dogo_android/tracking/Tracker;", "(Lcom/google/android/play/core/review/ReviewManager;Lapp/dogo/com/dogo_android/tracking/Tracker;)V", "launchReviewFlow", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "info", "Lcom/google/android/play/core/review/ReviewInfo;", "source", "", "requestReview", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c {

    private final a a;
    private final o3 b;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@", d2 = {"<anonymous>", "Lcom/google/android/play/core/review/ReviewInfo;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    @f(c = "app.dogo.com.dogo_android.viewmodel.InAppRateRepository$requestReview$2", f = "InAppRateRepository.kt", l = 20, m = "invokeSuspend")
    static final class a extends k implements p<m0, d<? super ReviewInfo>, Object> {

        int label;
        final app.dogo.com.dogo_android.a0.c this$0;
        a(app.dogo.com.dogo_android.a0.c c, d<? super app.dogo.com.dogo_android.a0.c.a> d2) {
            this.this$0 = c;
            super(2, d2);
        }

        public final Object c(m0 m0, d<? super ReviewInfo> d2) {
            return (c.a)create(m0, d2).invokeSuspend(w.a);
        }

        public final d<w> create(Object object, d<?> d2) {
            c.a obj2 = new c.a(this.this$0, d2);
            return obj2;
        }

        @Override // kotlin.b0.k.a.k
        public Object invoke(Object object, Object object2) {
            return c((m0)object, (d)object2);
        }

        @Override // kotlin.b0.k.a.k
        public final Object invokeSuspend(Object object) {
            Object obj4;
            Object obj = b.d();
            final int label = this.label;
            final int i = 1;
            if (label != 0) {
                if (label != i) {
                } else {
                    q.b(object);
                    return obj4;
                }
                obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj4;
            }
            q.b(object);
            this.label = i;
            if (a.a(c.a(this.this$0), this) == obj) {
                return obj;
            }
        }
    }
    public c(a a, o3 o32) {
        n.f(a, "reviewManager");
        n.f(o32, "tracker");
        super();
        this.a = a;
        this.b = o32;
    }

    public static final a a(app.dogo.com.dogo_android.a0.c c) {
        return c.a;
    }

    public static void b(app.dogo.com.dogo_android.a0.c c, String string2, Void void3) {
        c.f(c, string2, void3);
    }

    public static void c(Exception exception) {
        c.e(exception);
    }

    private static final void e(Exception exception) {
        a.d(exception);
    }

    private static final void f(app.dogo.com.dogo_android.a0.c c, String string2, Void void3) {
        n.f(c, "this$0");
        n.f(string2, "$source");
        r2 r2Var = new r2();
        c.b.d(j0.e.c(r2Var, string2));
    }

    public final void d(e e, ReviewInfo reviewInfo2, String string3) {
        n.f(e, "activity");
        n.f(reviewInfo2, "info");
        n.f(string3, "source");
        final d obj2 = this.a.a(e, reviewInfo2);
        n.e(obj2, "reviewManager.launchReviewFlow(activity, info)");
        obj2.b(b.a);
        a obj3 = new a(this, string3);
        obj2.d(obj3);
    }

    public final Object g(d<? super ReviewInfo> d) {
        c.a aVar = new c.a(this, 0);
        return k.e(c1.b(), aVar, d);
    }
}
