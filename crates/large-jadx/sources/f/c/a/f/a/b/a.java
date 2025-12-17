package f.c.a.f.a.b;

import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.a;
import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.d;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;

/* loaded from: classes2.dex */
public final class a {

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001H\u0086@¢\u0006\u0004\u0008\u0005\u0010\u0006", d2 = {"Lcom/google/android/play/core/review/a;", "Lkotlin/b0/d;", "Lcom/google/android/play/core/review/ReviewInfo;", "continuation", "", "requestReview", "(Lcom/google/android/play/core/review/a;Lkotlin/b0/d;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
    @f(c = "com.google.android.play.core.ktx.ReviewManagerKtxKt", f = "ReviewManagerKtx.kt", l = 17, m = "requestReview")
    static final class a extends d {

        Object L$0;
        int label;
        Object result;
        a(d d) {
            super(d);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label = obj2 |= i;
            return a.a(0, this);
        }
    }
    public static final Object a(a a, d<? super ReviewInfo> d2) {
        boolean aVar;
        int label2;
        int i;
        int label;
        int i2;
        Object obj4;
        Object obj5;
        aVar = d2;
        label2 = aVar.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof a.a && label2 & i != 0) {
            aVar = d2;
            label2 = aVar.label;
            i = Integer.MIN_VALUE;
            if (label2 & i != 0) {
                aVar.label = label2 -= i;
            } else {
                aVar = new a.a(d2);
            }
        } else {
        }
        obj5 = aVar.result;
        Object obj = b.d();
        label = aVar.label;
        int i3 = 1;
        if (label != 0) {
            if (label != i3) {
            } else {
                obj4 = aVar.L$0;
                q.b(obj5);
                n.c(obj5, "runTask(requestReviewFlow())");
                return obj5;
            }
            obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj4;
        }
        q.b(obj5);
        obj5 = a.b();
        n.c(obj5, "requestReviewFlow()");
        aVar.L$0 = a;
        aVar.label = i3;
        obj4 = 0;
        if (b.b(obj5, obj4, aVar, 2, obj4) == obj) {
            return obj;
        }
    }
}
