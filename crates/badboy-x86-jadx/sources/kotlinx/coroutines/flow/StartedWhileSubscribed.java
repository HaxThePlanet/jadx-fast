package kotlinx.coroutines.flow;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00072\u000c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u000bH\u0017J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013", d2 = {"Lkotlinx/coroutines/flow/StartedWhileSubscribed;", "Lkotlinx/coroutines/flow/SharingStarted;", "stopTimeout", "", "replayExpiration", "(JJ)V", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "equals", "", "other", "", "hashCode", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class StartedWhileSubscribed implements kotlinx.coroutines.flow.SharingStarted {

    private final long replayExpiration;
    private final long stopTimeout;
    public StartedWhileSubscribed(long stopTimeout, long replayExpiration) {
        int i;
        int i2;
        super();
        this.stopTimeout = stopTimeout;
        this.replayExpiration = obj11;
        int i5 = 0;
        final int i6 = 0;
        i = Long.compare(stopTimeout2, i5) >= 0 ? i2 : i6;
        final String str3 = " ms) cannot be negative";
        if (i == 0) {
        } else {
            if (Long.compare(replayExpiration3, i5) >= 0) {
            } else {
                i2 = i6;
            }
            if (i2 == 0) {
            } else {
            }
            int i4 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.append("replayExpiration(").append(this.replayExpiration).append(str3).toString().toString());
            throw illegalArgumentException2;
        }
        int i3 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("stopTimeout(").append(this.stopTimeout).append(str3).toString().toString());
        throw illegalArgumentException;
    }

    public static final long access$getReplayExpiration$p(kotlinx.coroutines.flow.StartedWhileSubscribed $this) {
        return $this.replayExpiration;
    }

    public static final long access$getStopTimeout$p(kotlinx.coroutines.flow.StartedWhileSubscribed $this) {
        return $this.stopTimeout;
    }

    public kotlinx.coroutines.flow.Flow<kotlinx.coroutines.flow.SharingCommand> command(kotlinx.coroutines.flow.StateFlow<Integer> subscriptionCount) {
        final int i = 0;
        StartedWhileSubscribed.command.1 anon = new StartedWhileSubscribed.command.1(this, i);
        StartedWhileSubscribed.command.2 anon2 = new StartedWhileSubscribed.command.2(i);
        return FlowKt.distinctUntilChanged(FlowKt.dropWhile(FlowKt.transformLatest((Flow)subscriptionCount, (Function3)anon), (Function2)anon2));
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public boolean equals(Object other) {
        int i;
        boolean cmp;
        long replayExpiration;
        if (other instanceof StartedWhileSubscribed && Long.compare(stopTimeout, replayExpiration) == 0 && Long.compare(replayExpiration2, replayExpiration) == 0) {
            if (Long.compare(stopTimeout, replayExpiration) == 0) {
                i = Long.compare(replayExpiration2, replayExpiration) == 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public int hashCode() {
        return i2 += i4;
    }

    @Override // kotlinx.coroutines.flow.SharingStarted
    public String toString() {
        int string;
        int string2;
        int stopTimeout;
        long replayExpiration;
        List listBuilder = CollectionsKt.createListBuilder(2);
        List list = listBuilder;
        int i2 = 0;
        String str2 = "ms";
        if (Long.compare(stopTimeout2, stopTimeout) > 0) {
            StringBuilder stringBuilder2 = new StringBuilder();
            list.add(stringBuilder2.append("stopTimeout=").append(this.stopTimeout).append(str2).toString());
        }
        if (Long.compare(replayExpiration, l) < 0) {
            StringBuilder stringBuilder3 = new StringBuilder();
            list.add(stringBuilder3.append("replayExpiration=").append(this.replayExpiration).append(str2).toString());
        }
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SharingStarted.WhileSubscribed(").append(CollectionsKt.joinToString$default((Iterable)CollectionsKt.build(listBuilder), 0, 0, 0, 0, 0, 0, 63, 0)).append(')').toString();
    }
}
