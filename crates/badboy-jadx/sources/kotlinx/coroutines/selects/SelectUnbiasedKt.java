package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001aE\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u00012\u001f\u0008\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0086Hø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0008", d2 = {"selectUnbiased", "R", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SelectUnbiasedKt {
    public static final <R> Object selectUnbiased(Function1<? super kotlinx.coroutines.selects.SelectBuilder<? super R>, Unit> builder, Continuation<? super R> $completion) {
        final int i = 0;
        UnbiasedSelectImplementation unbiasedSelectImplementation = new UnbiasedSelectImplementation($completion.getContext());
        int i2 = 0;
        builder.invoke(unbiasedSelectImplementation);
        return unbiasedSelectImplementation.doSelect($completion);
    }

    private static final <R> Object selectUnbiased$$forInline(Function1<? super kotlinx.coroutines.selects.SelectBuilder<? super R>, Unit> builder, Continuation<? super R> $completion) {
        int obj0 = 0;
        obj0.getContext();
        throw obj0;
    }
}
