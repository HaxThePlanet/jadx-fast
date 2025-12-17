package kotlinx.coroutines.flow;

import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008æ\u0080\u0001\u0018\u0000 \u00082\u00020\u0001:\u0001\u0008J\u001c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\t", d2 = {"Lkotlinx/coroutines/flow/SharingStarted;", "", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "Companion", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SharingStarted {

    public static final kotlinx.coroutines.flow.SharingStarted.Companion Companion;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\u00042\u0008\u0008\u0002\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006¨\u0006\r", d2 = {"Lkotlinx/coroutines/flow/SharingStarted$Companion;", "", "()V", "Eagerly", "Lkotlinx/coroutines/flow/SharingStarted;", "getEagerly", "()Lkotlinx/coroutines/flow/SharingStarted;", "Lazily", "getLazily", "WhileSubscribed", "stopTimeoutMillis", "", "replayExpirationMillis", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final kotlinx.coroutines.flow.SharingStarted.Companion $$INSTANCE;
        private static final kotlinx.coroutines.flow.SharingStarted Eagerly;
        private static final kotlinx.coroutines.flow.SharingStarted Lazily;
        static {
            SharingStarted.Companion companion = new SharingStarted.Companion();
            SharingStarted.Companion.$$INSTANCE = companion;
            StartedEagerly startedEagerly = new StartedEagerly();
            SharingStarted.Companion.Eagerly = (SharingStarted)startedEagerly;
            StartedLazily startedLazily = new StartedLazily();
            SharingStarted.Companion.Lazily = (SharingStarted)startedLazily;
        }

        public static kotlinx.coroutines.flow.SharingStarted WhileSubscribed$default(kotlinx.coroutines.flow.SharingStarted.Companion sharingStarted$Companion, long l2, long l3, int i4, Object object5) {
            int obj1;
            long obj3;
            if (obj5 & 1 != 0) {
                obj1 = 0;
            }
            if (obj5 &= 2 != 0) {
                obj3 = Long.MAX_VALUE;
            }
            return companion.WhileSubscribed(obj1, l3);
        }

        public final kotlinx.coroutines.flow.SharingStarted WhileSubscribed(long stopTimeoutMillis, long replayExpirationMillis) {
            StartedWhileSubscribed startedWhileSubscribed = new StartedWhileSubscribed(stopTimeoutMillis, replayExpirationMillis, obj4, obj5);
            return (SharingStarted)startedWhileSubscribed;
        }

        public final kotlinx.coroutines.flow.SharingStarted getEagerly() {
            return SharingStarted.Companion.Eagerly;
        }

        public final kotlinx.coroutines.flow.SharingStarted getLazily() {
            return SharingStarted.Companion.Lazily;
        }
    }
    static {
        SharingStarted.Companion = SharingStarted.Companion.$$INSTANCE;
    }

    public abstract kotlinx.coroutines.flow.Flow<kotlinx.coroutines.flow.SharingCommand> command(kotlinx.coroutines.flow.StateFlow<Integer> stateFlow);
}
