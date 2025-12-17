package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0002\u0018\u00002\u00020\u0001B.\u0012'\u0010\u0002\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0003j\u0002`\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00082\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0096\u0002R/\u0010\u0002\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0003j\u0002`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Lkotlinx/coroutines/InvokeOnCompletion;", "Lkotlinx/coroutines/JobNode;", "handler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "(Lkotlin/jvm/functions/Function1;)V", "invoke", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class InvokeOnCompletion extends kotlinx.coroutines.JobNode {

    private final Function1<Throwable, Unit> handler;
    public InvokeOnCompletion(Function1<? super Throwable, Unit> handler) {
        super();
        this.handler = handler;
    }

    @Override // kotlinx.coroutines.JobNode
    public Object invoke(Object p1) {
        invoke((Throwable)p1);
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.JobNode
    public void invoke(Throwable cause) {
        this.handler.invoke(cause);
    }
}
