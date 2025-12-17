package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.time.Duration;
import kotlin.time.Duration.Companion;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a+\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008\u0019¨\u0006\u0008", d2 = {"WhileSubscribed", "Lkotlinx/coroutines/flow/SharingStarted;", "Lkotlinx/coroutines/flow/SharingStarted$Companion;", "stopTimeout", "Lkotlin/time/Duration;", "replayExpiration", "WhileSubscribed-5qebJ5I", "(Lkotlinx/coroutines/flow/SharingStarted$Companion;JJ)Lkotlinx/coroutines/flow/SharingStarted;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SharingStartedKt {
    public static final kotlinx.coroutines.flow.SharingStarted WhileSubscribed-5qebJ5I(kotlinx.coroutines.flow.SharingStarted.Companion $this$WhileSubscribed_u2d5qebJ5I, long stopTimeout, long replayExpiration) {
        StartedWhileSubscribed startedWhileSubscribed = new StartedWhileSubscribed(Duration.getInWholeMilliseconds-impl(stopTimeout), obj2, Duration.getInWholeMilliseconds-impl(obj8), obj4);
        return (SharingStarted)startedWhileSubscribed;
    }

    public static kotlinx.coroutines.flow.SharingStarted WhileSubscribed-5qebJ5I$default(kotlinx.coroutines.flow.SharingStarted.Companion sharingStarted$Companion, long l2, long l3, int i4, Object object5) {
        long obj1;
        long obj3;
        if (obj5 & 1 != 0) {
            obj1 = Duration.Companion.getZERO-UwyO8pc();
        }
        if (obj5 &= 2 != 0) {
            obj3 = Duration.Companion.getINFINITE-UwyO8pc();
        }
        return SharingStartedKt.WhileSubscribed-5qebJ5I(companion, obj1, l3);
    }
}
