package kotlin.io;

import java.io.Closeable;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0001\u001aH\u0010\u0005\u001a\u0002H\u0006\"\n\u0008\u0000\u0010\u0007*\u0004\u0018\u00010\u0002\"\u0004\u0008\u0001\u0010\u0006*\u0002H\u00072\u0012\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u00060\tH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\n\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\u000b", d2 = {"closeFinally", "", "Ljava/io/Closeable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class CloseableKt {
    public static final void closeFinally(Closeable $this$closeFinally, Throwable cause) {
        Throwable th;
        if ($this$closeFinally != null) {
            if (cause == null) {
                $this$closeFinally.close();
            } else {
                $this$closeFinally.close();
            }
        }
    }

    private static final <T extends Closeable, R> R use(T $this$use, Function1<? super T, ? extends R> block) {
        int i;
        Intrinsics.checkNotNullParameter(block, "block");
        final int i4 = 1;
        if (PlatformImplementationsKt.apiVersionIsAtLeast(i4, i4, 0)) {
            CloseableKt.closeFinally($this$use, 0);
        } else {
            if ($this$use != null) {
                $this$use.close();
            }
        }
        return block.invoke($this$use);
    }
}
