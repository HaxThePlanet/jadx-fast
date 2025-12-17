package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.FlowCollector;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\">\u0010\u0000\u001a,\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001X\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"emitFun", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", "", "Lkotlin/coroutines/Continuation;", "", "getEmitFun$annotations", "()V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SafeCollectorKt {

    private static final Function3<FlowCollector<Object>, Object, Continuation<? super Unit>, Object> emitFun;
    static {
        kotlinx.coroutines.flow.internal.SafeCollectorKt.emitFun.1 iNSTANCE = SafeCollectorKt.emitFun.1.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        SafeCollectorKt.emitFun = (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE, 3);
    }

    public static final Function3 access$getEmitFun$p() {
        return SafeCollectorKt.emitFun;
    }

    private static void getEmitFun$annotations() {
    }
}
