package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.LimitedDispatcherKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\u0008\u0010\t\u001a\u00020\nH\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0005R\u0012\u0010\u0003\u001a\u00020\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005¨\u0006\u000c", d2 = {"Lkotlinx/coroutines/MainCoroutineDispatcher;", "Lkotlinx/coroutines/CoroutineDispatcher;", "()V", "immediate", "getImmediate", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "limitedParallelism", "parallelism", "", "toString", "", "toStringInternalImpl", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class MainCoroutineDispatcher extends kotlinx.coroutines.CoroutineDispatcher {
    @Override // kotlinx.coroutines.CoroutineDispatcher
    public abstract kotlinx.coroutines.MainCoroutineDispatcher getImmediate();

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public kotlinx.coroutines.CoroutineDispatcher limitedParallelism(int parallelism) {
        LimitedDispatcherKt.checkParallelism(parallelism);
        return (CoroutineDispatcher)this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String stringInternalImpl;
        String hexAddress;
        if (toStringInternalImpl() == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringInternalImpl = stringBuilder.append(DebugStringsKt.getClassSimpleName(this)).append('@').append(DebugStringsKt.getHexAddress(this)).toString();
        }
        return stringInternalImpl;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    protected final String toStringInternalImpl() {
        kotlinx.coroutines.MainCoroutineDispatcher immediate;
        final kotlinx.coroutines.MainCoroutineDispatcher main = Dispatchers.getMain();
        if (this == main) {
            return "Dispatchers.Main";
        }
        immediate = main.getImmediate();
        if (this == immediate) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }
}
