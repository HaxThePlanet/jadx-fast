package androidx.core.util;

import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¨\u0006\u0004", d2 = {"asConsumer", "Ljava/util/function/Consumer;", "T", "Lkotlin/coroutines/Continuation;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ConsumerKt {
    public static final <T> Consumer<T> asConsumer(Continuation<? super T> $this$asConsumer) {
        ContinuationConsumer continuationConsumer = new ContinuationConsumer($this$asConsumer);
        return (Consumer)continuationConsumer;
    }
}
