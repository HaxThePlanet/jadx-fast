package kotlinx.coroutines.internal;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0008\n\u0000\u001a\u000c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003", d2 = {"checkParallelism", "", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class LimitedDispatcherKt {
    public static final void checkParallelism(int $this$checkParallelism) {
        int i;
        if ($this$checkParallelism >= 1) {
        } else {
            i = 0;
        }
        if (i == 0) {
        } else {
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Expected positive parallelism level, but got ").append($this$checkParallelism).toString().toString());
        throw illegalArgumentException;
    }
}
