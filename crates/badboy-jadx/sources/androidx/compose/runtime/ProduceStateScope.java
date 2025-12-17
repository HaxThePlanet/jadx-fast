package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008f\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007H¦@¢\u0006\u0002\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\nÀ\u0006\u0001", d2 = {"Landroidx/compose/runtime/ProduceStateScope;", "T", "Landroidx/compose/runtime/MutableState;", "Lkotlinx/coroutines/CoroutineScope;", "awaitDispose", "", "onDispose", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ProduceStateScope<T>  extends androidx.compose.runtime.MutableState<T>, CoroutineScope {
    public abstract Object awaitDispose(Function0<Unit> function0, Continuation<?> continuation2);
}
