package androidx.compose.ui.input.pointer;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0000\u0008\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0008\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"Landroidx/compose/ui/input/pointer/PointerInputResetException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "()V", "fillInStackTrace", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PointerInputResetException extends CancellationException {
    public PointerInputResetException() {
        super("Pointer input was reset");
    }

    @Override // java.util.concurrent.CancellationException
    public Throwable fillInStackTrace() {
        setStackTrace(SuspendingPointerInputFilterKt.access$getEmptyStackTraceElements$p());
        return (Throwable)this;
    }
}
