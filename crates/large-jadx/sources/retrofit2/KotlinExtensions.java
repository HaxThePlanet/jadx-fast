package retrofit2;

import kotlin.Metadata;
import kotlin.b0.d;
import kotlin.b0.j.b;
import kotlin.b0.k.a.h;
import kotlin.d0.d.n;
import kotlin.q;
import kotlin.w;
import kotlinx.coroutines.c1;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0003\u001a\u001c\u0010\u0002\u001a\u00028\u0000\"\u0006\u0008\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\u0086\u0008¢\u0006\u0004\u0008\u0002\u0010\u0003\u001a'\u0010\u0006\u001a\u00028\u0000\"\u0008\u0008\u0000\u0010\u0000*\u00020\u0004*\u0008\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\u0008\u0006\u0010\u0007\u001a+\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\u0008\u0008\u0000\u0010\u0000*\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005H\u0087@ø\u0001\u0000¢\u0006\u0004\u0008\u0008\u0010\u0007\u001a)\u0010\n\u001a\u0008\u0012\u0004\u0012\u00028\u00000\t\"\u0004\u0008\u0000\u0010\u0000*\u0008\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u0007\u001a\u001b\u0010\u000e\u001a\u00020\r*\u00060\u000bj\u0002`\u000cH\u0080@ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0010", d2 = {"T", "Lretrofit2/Retrofit;", "create", "(Lretrofit2/Retrofit;)Ljava/lang/Object;", "", "Lretrofit2/Call;", "await", "(Lretrofit2/Call;Lkotlin/b0/d;)Ljava/lang/Object;", "awaitNullable", "Lretrofit2/Response;", "awaitResponse", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "suspendAndThrow", "(Ljava/lang/Exception;Lkotlin/b0/d;)Ljava/lang/Object;", "retrofit"}, k = 2, mv = {1, 4, 0})
public final class KotlinExtensions {
    public static final <T> Object await(retrofit2.Call<T> call, d<? super T> d2) {
        q qVar = new q(b.c(d2), 1);
        KotlinExtensions.await$$inlined.suspendCancellableCoroutine.lambda.1 anon = new KotlinExtensions.await$$inlined.suspendCancellableCoroutine.lambda.1(call);
        qVar.g(anon);
        KotlinExtensions.await.2.2 anon2 = new KotlinExtensions.await.2.2(qVar);
        call.enqueue(anon2);
        final Object obj3 = qVar.y();
        if (obj3 == b.d()) {
            h.c(d2);
        }
        return obj3;
    }

    public static final <T> Object awaitNullable(retrofit2.Call<T> call, d<? super T> d2) {
        q qVar = new q(b.c(d2), 1);
        KotlinExtensions.await$$inlined.suspendCancellableCoroutine.lambda.2 anon = new KotlinExtensions.await$$inlined.suspendCancellableCoroutine.lambda.2(call);
        qVar.g(anon);
        KotlinExtensions.await.4.2 anon2 = new KotlinExtensions.await.4.2(qVar);
        call.enqueue(anon2);
        final Object obj3 = qVar.y();
        if (obj3 == b.d()) {
            h.c(d2);
        }
        return obj3;
    }

    public static final <T> Object awaitResponse(retrofit2.Call<T> call, d<? super retrofit2.Response<T>> d2) {
        q qVar = new q(b.c(d2), 1);
        KotlinExtensions.awaitResponse$$inlined.suspendCancellableCoroutine.lambda.1 anon = new KotlinExtensions.awaitResponse$$inlined.suspendCancellableCoroutine.lambda.1(call);
        qVar.g(anon);
        KotlinExtensions.awaitResponse.2.2 anon2 = new KotlinExtensions.awaitResponse.2.2(qVar);
        call.enqueue(anon2);
        final Object obj3 = qVar.y();
        if (obj3 == b.d()) {
            h.c(d2);
        }
        return obj3;
    }

    public static final <T> T create(retrofit2.Retrofit retrofit) {
        n.g(retrofit, "$this$create");
        n.l(4, "T");
        throw 0;
    }

    public static final Object suspendAndThrow(Exception exception, d<?> d2) {
        boolean anon;
        int label;
        int i;
        int context;
        int i2;
        int anon2;
        Object obj4;
        Object obj5;
        anon = d2;
        label = anon.label;
        i = Integer.MIN_VALUE;
        if (d2 instanceof KotlinExtensions.suspendAndThrow.1 && label & i != 0) {
            anon = d2;
            label = anon.label;
            i = Integer.MIN_VALUE;
            if (label & i != 0) {
                anon.label = label -= i;
            } else {
                anon = new KotlinExtensions.suspendAndThrow.1(d2);
            }
        } else {
        }
        obj5 = anon.result;
        Object obj = b.d();
        context = anon.label;
        anon2 = 1;
        if (context != null) {
            if (context != anon2) {
            } else {
                obj4 = anon.L$0;
                q.b(obj5);
                return w.a;
            }
            obj4 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            throw obj4;
        }
        q.b(obj5);
        anon.L$0 = exception;
        anon.label = anon2;
        anon2 = new KotlinExtensions.suspendAndThrow$$inlined.suspendCoroutineUninterceptedOrReturn.lambda.1(anon, exception);
        c1.a().K(anon.getContext(), anon2);
        obj4 = b.d();
        if (obj4 == b.d()) {
            h.c(anon);
        }
        if (obj4 == obj) {
            return obj;
        }
    }
}
