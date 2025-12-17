package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008Â\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J7\u0010\u0005\u001a\u0002H\u0006\"\u0004\u0008\u0000\u0010\u00062!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u0002H\u00060\u0008H\u0096@¢\u0006\u0002\u0010\u000cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Landroidx/compose/runtime/SdkStubsFallbackFrameClock;", "Landroidx/compose/runtime/MonotonicFrameClock;", "()V", "DefaultFrameDelay", "", "withFrameNanos", "R", "onFrame", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "frameTimeNanos", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class SdkStubsFallbackFrameClock implements androidx.compose.runtime.MonotonicFrameClock {

    private static final long DefaultFrameDelay = 16L;
    public static final androidx.compose.runtime.SdkStubsFallbackFrameClock INSTANCE;
    static {
        SdkStubsFallbackFrameClock sdkStubsFallbackFrameClock = new SdkStubsFallbackFrameClock();
        SdkStubsFallbackFrameClock.INSTANCE = sdkStubsFallbackFrameClock;
    }

    public <R> R fold(R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        return MonotonicFrameClock.DefaultImpls.fold(this, initial, operation);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return MonotonicFrameClock.DefaultImpls.get(this, key);
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return MonotonicFrameClock.DefaultImpls.minusKey(this, key);
    }

    @Override // androidx.compose.runtime.MonotonicFrameClock
    public CoroutineContext plus(CoroutineContext context) {
        return MonotonicFrameClock.DefaultImpls.plus(this, context);
    }

    public <R> Object withFrameNanos(Function1<? super Long, ? extends R> onFrame, Continuation<? super R> $completion) {
        SdkStubsFallbackFrameClock.withFrameNanos.2 anon = new SdkStubsFallbackFrameClock.withFrameNanos.2(onFrame, 0);
        return BuildersKt.withContext((CoroutineContext)Dispatchers.getMain(), (Function2)anon, $completion);
    }
}
