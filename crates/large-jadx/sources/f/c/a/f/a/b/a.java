package f.c.a.f.a.b;

import com.google.android.play.core.review.ReviewInfo;
import com.google.android.play.core.review.a;
import kotlin.Metadata;
import kotlin.b0.j.b;
import kotlin.b0.k.a.f;
import kotlin.d0.d.n;
import kotlin.q;

/* compiled from: ReviewManagerKtx.kt */
/* loaded from: classes2.dex */
public final class a {

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001H\u0086@¢\u0006\u0004\u0008\u0005\u0010\u0006", d2 = {"Lcom/google/android/play/core/review/a;", "Lkotlin/b0/d;", "Lcom/google/android/play/core/review/ReviewInfo;", "continuation", "", "requestReview", "(Lcom/google/android/play/core/review/a;Lkotlin/b0/d;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
    @f(c = "com.google.android.play.core.ktx.ReviewManagerKtxKt", f = "ReviewManagerKtx.kt", l = 17, m = "requestReview")
    static final class a extends kotlin.b0.k.a.d {

        Object L$0;
        int label;
        /* synthetic */ Object result;
        a(kotlin.b0.d dVar) {
            super(dVar);
        }

        @Override // kotlin.b0.k.a.d
        public final Object invokeSuspend(Object object) {
            this.result = object;
            this.label |= -2147483648;
            return a.a(null, this);
        }
    }
    public static final Object a(a aVar, kotlin.b0.d<? super ReviewInfo> dVar) {
        Object dVar22;
        int label2;
        int i = -2147483648;
        int i2;
        Object result2;
        z = dVar instanceof a.a;
        if (dVar instanceof a.a) {
            dVar22 = dVar;
            i = Integer.MIN_VALUE;
            i2 = label2 & i;
            if (label2 & i != 0) {
                dVar22.label -= i;
            } else {
                f.c.a.f.a.b.a.a aVar2 = new a.a(dVar);
            }
        }
        Object obj2 = b.d();
        int i3 = 1;
        if (dVar22.label != 0 && dVar22.label == i3) {
            q.b(dVar22.result);
            n.c(result2, "runTask(requestReviewFlow())");
            return result2;
        }
        q.b(dVar22.result);
        dVar = aVar.b();
        n.c(dVar, "requestReviewFlow()");
        int label22 = 2;
        dVar22.L$0 = aVar;
        dVar22.label = i3;
        kotlin.d0.c.a aVar3 = null;
        if (b.b(dVar, aVar3, dVar22, label22, aVar3) == obj2) {
            return obj2;
        }
    }
}
