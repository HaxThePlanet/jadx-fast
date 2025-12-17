package androidx.compose.foundation.text.input.internal;

import android.os.CancellationSignal;
import android.view.inputmethod.HandwritingGesture;
import android.view.inputmethod.PreviewableHandwritingGesture;
import java.util.concurrent.Executor;
import java.util.function.IntConsumer;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0007J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0007¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/text/input/internal/Api34PerformHandwritingGestureImpl;", "", "()V", "performHandwritingGesture", "", "session", "Landroidx/compose/foundation/text/input/internal/TextInputSession;", "gesture", "Landroid/view/inputmethod/HandwritingGesture;", "executor", "Ljava/util/concurrent/Executor;", "intConsumer", "Ljava/util/function/IntConsumer;", "previewHandwritingGesture", "", "Landroid/view/inputmethod/PreviewableHandwritingGesture;", "cancellationSignal", "Landroid/os/CancellationSignal;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class Api34PerformHandwritingGestureImpl {

    public static final androidx.compose.foundation.text.input.internal.Api34PerformHandwritingGestureImpl INSTANCE;
    public static void $r8$lambda$45RPB-WRXTKb12BEC5JjhL0Ri18(IntConsumer intConsumer, int i2) {
        Api34PerformHandwritingGestureImpl.performHandwritingGesture$lambda$0(intConsumer, i2);
    }

    static {
        Api34PerformHandwritingGestureImpl api34PerformHandwritingGestureImpl = new Api34PerformHandwritingGestureImpl();
        Api34PerformHandwritingGestureImpl.INSTANCE = api34PerformHandwritingGestureImpl;
    }

    private static final void performHandwritingGesture$lambda$0(IntConsumer $intConsumer, int $result) {
        $intConsumer.accept($result);
    }

    public final void performHandwritingGesture(androidx.compose.foundation.text.input.internal.TextInputSession session, HandwritingGesture gesture, Executor executor, IntConsumer intConsumer) {
        androidx.compose.foundation.text.input.internal.Api34PerformHandwritingGestureImpl$$ExternalSyntheticLambda0 externalSyntheticLambda0;
        final int handwritingGesture = session.performHandwritingGesture(gesture);
        if (intConsumer == null) {
        }
        if (executor != null) {
            externalSyntheticLambda0 = new Api34PerformHandwritingGestureImpl$$ExternalSyntheticLambda0(intConsumer, handwritingGesture);
            executor.execute(externalSyntheticLambda0);
        } else {
            intConsumer.accept(handwritingGesture);
        }
    }

    public final boolean previewHandwritingGesture(androidx.compose.foundation.text.input.internal.TextInputSession session, PreviewableHandwritingGesture gesture, CancellationSignal cancellationSignal) {
        return session.previewHandwritingGesture(gesture, cancellationSignal);
    }
}
