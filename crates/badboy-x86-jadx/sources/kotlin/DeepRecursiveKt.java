package kotlin;

import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a2\u0010\u0004\u001a\u0002H\u0005\"\u0004\u0008\u0000\u0010\u0006\"\u0004\u0008\u0001\u0010\u0005*\u000e\u0012\u0004\u0012\u0002H\u0006\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\u0008\u001a\u0002H\u0006H\u0087\u0002¢\u0006\u0002\u0010\t\"\u0016\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0003*r\u0008\u0002\u0010\n\"5\u0008\u0001\u0012\u000c\u0012\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b¢\u0006\u0002\u0008\u000e25\u0008\u0001\u0012\u000c\u0012\n\u0012\u0002\u0008\u0003\u0012\u0002\u0008\u00030\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u000b¢\u0006\u0002\u0008\u000e¨\u0006\u000f", d2 = {"UNDEFINED_RESULT", "Lkotlin/Result;", "", "Ljava/lang/Object;", "invoke", "R", "T", "Lkotlin/DeepRecursiveFunction;", "value", "(Lkotlin/DeepRecursiveFunction;Ljava/lang/Object;)Ljava/lang/Object;", "DeepRecursiveFunctionBlock", "Lkotlin/Function3;", "Lkotlin/DeepRecursiveScope;", "Lkotlin/coroutines/Continuation;", "Lkotlin/ExtensionFunctionType;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class DeepRecursiveKt {

    private static final Object UNDEFINED_RESULT;
    static {
        kotlin.Result.Companion companion = Result.Companion;
        DeepRecursiveKt.UNDEFINED_RESULT = Result.constructor-impl(IntrinsicsKt.getCOROUTINE_SUSPENDED());
    }

    public static final Object access$getUNDEFINED_RESULT$p() {
        return DeepRecursiveKt.UNDEFINED_RESULT;
    }

    public static final <T, R> R invoke(kotlin.DeepRecursiveFunction<T, R> $this$invoke, T value) {
        Intrinsics.checkNotNullParameter($this$invoke, "<this>");
        DeepRecursiveScopeImpl deepRecursiveScopeImpl = new DeepRecursiveScopeImpl($this$invoke.getBlock$kotlin_stdlib(), value);
        return deepRecursiveScopeImpl.runCallLoop();
    }
}
