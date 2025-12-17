package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
@Metadata(d1 = {"kotlinx/coroutines/BuildersKt__BuildersKt", "kotlinx/coroutines/BuildersKt__Builders_commonKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
public final class BuildersKt {
    public static final <T> kotlinx.coroutines.Deferred<T> async(kotlinx.coroutines.CoroutineScope $this$async, CoroutineContext context, kotlinx.coroutines.CoroutineStart start, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) {
        return BuildersKt__Builders_commonKt.async($this$async, context, start, block);
    }

    public static kotlinx.coroutines.Deferred async$default(kotlinx.coroutines.CoroutineScope coroutineScope, CoroutineContext coroutineContext2, kotlinx.coroutines.CoroutineStart coroutineStart3, Function2 function24, int i5, Object object6) {
        return BuildersKt__Builders_commonKt.async$default(coroutineScope, coroutineContext2, coroutineStart3, function24, i5, object6);
    }

    public static final <T> Object invoke(kotlinx.coroutines.CoroutineDispatcher $this$invoke, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> $completion) {
        return BuildersKt__Builders_commonKt.invoke($this$invoke, block, $completion);
    }

    public static final kotlinx.coroutines.Job launch(kotlinx.coroutines.CoroutineScope $this$launch, CoroutineContext context, kotlinx.coroutines.CoroutineStart start, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        return BuildersKt__Builders_commonKt.launch($this$launch, context, start, block);
    }

    public static kotlinx.coroutines.Job launch$default(kotlinx.coroutines.CoroutineScope coroutineScope, CoroutineContext coroutineContext2, kotlinx.coroutines.CoroutineStart coroutineStart3, Function2 function24, int i5, Object object6) {
        return BuildersKt__Builders_commonKt.launch$default(coroutineScope, coroutineContext2, coroutineStart3, function24, i5, object6);
    }

    public static final <T> T runBlocking(CoroutineContext context, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super T>, ? extends Object> block) throws java.lang.InterruptedException {
        return BuildersKt__BuildersKt.runBlocking(context, block);
    }

    public static Object runBlocking$default(CoroutineContext coroutineContext, Function2 function22, int i3, Object object4) throws java.lang.InterruptedException {
        return BuildersKt__BuildersKt.runBlocking$default(coroutineContext, function22, i3, object4);
    }

    public static final <T> Object withContext(CoroutineContext context, Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super T>, ? extends Object> block, Continuation<? super T> $completion) {
        return BuildersKt__Builders_commonKt.withContext(context, block, $completion);
    }
}
