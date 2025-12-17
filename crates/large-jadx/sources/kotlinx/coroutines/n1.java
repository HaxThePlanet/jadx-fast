package kotlinx.coroutines;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u001a\u001e\u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\u0015\u0010\u0007\u001a\u00020\u0008*\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0080\u0008*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\n", d2 = {"CancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "message", "", "cause", "", "addSuppressedThrowable", "", "other", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class n1 {
    public static final CancellationException a(String string, Throwable throwable2) {
        CancellationException cancellationException = new CancellationException(string);
        cancellationException.initCause(throwable2);
        return cancellationException;
    }
}
