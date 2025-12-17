package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.Volatile;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\u0008\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000b\u001a\u00020\u0005J\u0008\u0010\u000c\u001a\u00020\rH\u0016R\t\u0010\u0007\u001a\u00020\u0008X\u0082\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/CompletedExceptionally;", "", "cause", "", "handled", "", "(Ljava/lang/Throwable;Z)V", "_handled", "Lkotlinx/atomicfu/AtomicBoolean;", "getHandled", "()Z", "makeHandled", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class CompletedExceptionally {

    private static final AtomicIntegerFieldUpdater _handled$FU;
    @Volatile
    private volatile int _handled;
    public final Throwable cause;
    static {
        CompletedExceptionally._handled$FU = AtomicIntegerFieldUpdater.newUpdater(CompletedExceptionally.class, "_handled");
    }

    public CompletedExceptionally(Throwable cause, boolean handled) {
        super();
        this.cause = cause;
        this._handled = handled;
    }

    public CompletedExceptionally(Throwable throwable, boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(throwable, obj2);
    }

    public final boolean getHandled() {
        int i;
        i = CompletedExceptionally._handled$FU.get(this) != 0 ? 1 : 0;
        return i;
    }

    public final boolean makeHandled() {
        return CompletedExceptionally._handled$FU.compareAndSet(this, 0, 1);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(DebugStringsKt.getClassSimpleName(this)).append('[').append(this.cause).append(']').toString();
    }
}
