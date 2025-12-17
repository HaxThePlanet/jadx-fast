package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.intrinsics.UndispatchedKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u00012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u00032\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\u0008\u0000\u001aM\u0010\u0005\u001a\u0002H\u0006\"\u0004\u0008\u0000\u0010\u00062'\u0010\u0007\u001a#\u0008\u0001\u0012\u0004\u0012\u00020\t\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00060\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0008¢\u0006\u0002\u0008\u000cH\u0086@ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u000e", d2 = {"SupervisorJob", "Lkotlinx/coroutines/CompletableJob;", "parent", "Lkotlinx/coroutines/Job;", "SupervisorJob0", "supervisorScope", "R", "block", "Lkotlin/Function2;", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SupervisorKt {
    public static final kotlinx.coroutines.CompletableJob SupervisorJob(kotlinx.coroutines.Job parent) {
        SupervisorJobImpl supervisorJobImpl = new SupervisorJobImpl(parent);
        return (CompletableJob)supervisorJobImpl;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public static final kotlinx.coroutines.Job SupervisorJob(kotlinx.coroutines.Job parent) {
        return (Job)SupervisorKt.SupervisorJob(parent);
    }

    public static kotlinx.coroutines.CompletableJob SupervisorJob$default(kotlinx.coroutines.Job job, int i2, Object object3) {
        int obj0;
        if (i2 &= 1 != 0) {
            obj0 = 0;
        }
        return SupervisorKt.SupervisorJob(obj0);
    }

    public static kotlinx.coroutines.Job SupervisorJob$default(kotlinx.coroutines.Job job, int i2, Object object3) {
        int obj0;
        if (i2 &= 1 != 0) {
            obj0 = 0;
        }
        return SupervisorKt.SupervisorJob(obj0);
    }

    public static final <R> Object supervisorScope(Function2<? super kotlinx.coroutines.CoroutineScope, ? super Continuation<? super R>, ? extends Object> block, Continuation<? super R> $completion) {
        Continuation continuation = $completion;
        int i = 0;
        SupervisorCoroutine supervisorCoroutine = new SupervisorCoroutine(continuation.getContext(), continuation);
        Object uCont = UndispatchedKt.startUndispatchedOrReturn((ScopeCoroutine)supervisorCoroutine, supervisorCoroutine, block);
        if (uCont == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return uCont;
    }
}
