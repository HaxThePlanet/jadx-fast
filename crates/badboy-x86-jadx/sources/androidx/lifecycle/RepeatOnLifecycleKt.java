package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aC\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042'\u0010\u0005\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\u0008\nH\u0086@¢\u0006\u0002\u0010\u000b\u001aC\u0010\u0000\u001a\u00020\u0001*\u00020\u000c2\u0006\u0010\u0003\u001a\u00020\u00042'\u0010\u0005\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00010\u0008\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0006¢\u0006\u0002\u0008\nH\u0086@¢\u0006\u0002\u0010\r¨\u0006\u000e", d2 = {"repeatOnLifecycle", "", "Landroidx/lifecycle/Lifecycle;", "state", "Landroidx/lifecycle/Lifecycle$State;", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lifecycle-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class RepeatOnLifecycleKt {
    public static final Object repeatOnLifecycle(androidx.lifecycle.Lifecycle $this$repeatOnLifecycle, androidx.lifecycle.Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        int i;
        i = state != Lifecycle.State.INITIALIZED ? 1 : 0;
        if (i == 0) {
        } else {
            if ($this$repeatOnLifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                return Unit.INSTANCE;
            }
            RepeatOnLifecycleKt.repeatOnLifecycle.3 anon = new RepeatOnLifecycleKt.repeatOnLifecycle.3($this$repeatOnLifecycle, state, block, 0);
            Object coroutineScope = CoroutineScopeKt.coroutineScope((Function2)anon, $completion);
            if (coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return coroutineScope;
            }
            return Unit.INSTANCE;
        }
        int i2 = 0;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
        throw illegalArgumentException;
    }

    public static final Object repeatOnLifecycle(androidx.lifecycle.LifecycleOwner $this$repeatOnLifecycle, androidx.lifecycle.Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block, Continuation<? super Unit> $completion) {
        Object repeatOnLifecycle = RepeatOnLifecycleKt.repeatOnLifecycle($this$repeatOnLifecycle.getLifecycle(), state, block, $completion);
        if (repeatOnLifecycle == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return repeatOnLifecycle;
        }
        return Unit.INSTANCE;
    }
}
