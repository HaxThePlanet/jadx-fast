package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008&\u0018\u00002\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH'J\u0010\u0010\u000f\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u000eH'R6\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00058G@GX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u0014\u0010\u0010\u001a\u00020\u00118gX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017¨\u0006\u001a", d2 = {"Landroidx/lifecycle/Lifecycle;", "", "<init>", "()V", "value", "Landroidx/lifecycle/AtomicReference;", "internalScopeRef", "getInternalScopeRef", "()Landroidx/lifecycle/AtomicReference;", "setInternalScopeRef", "(Landroidx/lifecycle/AtomicReference;)V", "addObserver", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "removeObserver", "currentState", "Landroidx/lifecycle/Lifecycle$State;", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "currentStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "Event", "State", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class Lifecycle {

    private androidx.lifecycle.AtomicReference<Object> internalScopeRef;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0081\u0002\u0018\u0000 \u000f2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003R\u0011\u0010\u000b\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000ej\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\n¨\u0006\u0010", d2 = {"Landroidx/lifecycle/Lifecycle$Event;", "", "<init>", "(Ljava/lang/String;I)V", "ON_CREATE", "ON_START", "ON_RESUME", "ON_PAUSE", "ON_STOP", "ON_DESTROY", "ON_ANY", "targetState", "Landroidx/lifecycle/Lifecycle$State;", "getTargetState", "()Landroidx/lifecycle/Lifecycle$State;", "Companion", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static enum Event {

        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;
        private static final androidx.lifecycle.Lifecycle.Event[] $values() {
            return /* result */;
        }

        @JvmStatic
        public static final androidx.lifecycle.Lifecycle.Event downFrom(androidx.lifecycle.Lifecycle.State state) {
            return Lifecycle.Event.Companion.downFrom(state);
        }

        @JvmStatic
        public static final androidx.lifecycle.Lifecycle.Event downTo(androidx.lifecycle.Lifecycle.State state) {
            return Lifecycle.Event.Companion.downTo(state);
        }

        public static EnumEntries<androidx.lifecycle.Lifecycle.Event> getEntries() {
            return Lifecycle.Event.$ENTRIES;
        }

        @JvmStatic
        public static final androidx.lifecycle.Lifecycle.Event upFrom(androidx.lifecycle.Lifecycle.State state) {
            return Lifecycle.Event.Companion.upFrom(state);
        }

        @JvmStatic
        public static final androidx.lifecycle.Lifecycle.Event upTo(androidx.lifecycle.Lifecycle.State state) {
            return Lifecycle.Event.Companion.upTo(state);
        }

        @Override // java.lang.Enum
        public final androidx.lifecycle.Lifecycle.State getTargetState() {
            switch (i) {
                case 1:
                    return Lifecycle.State.CREATED;
                case 2:
                    return Lifecycle.State.STARTED;
                case 3:
                    return Lifecycle.State.RESUMED;
                case 4:
                    return Lifecycle.State.DESTROYED;
                case 5:
                    StringBuilder stringBuilder = new StringBuilder();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append(this).append(" has no target state").toString());
                    throw illegalArgumentException;
                default:
                    NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                    throw noWhenBranchMatchedException;
            }
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0086\u0081\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0000j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008¨\u0006\u000c", d2 = {"Landroidx/lifecycle/Lifecycle$State;", "", "<init>", "(Ljava/lang/String;I)V", "DESTROYED", "INITIALIZED", "CREATED", "STARTED", "RESUMED", "isAtLeast", "", "state", "lifecycle-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static enum State {

        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;
        private static final androidx.lifecycle.Lifecycle.State[] $values() {
            return /* result */;
        }

        public static EnumEntries<androidx.lifecycle.Lifecycle.State> getEntries() {
            return Lifecycle.State.$ENTRIES;
        }

        @Override // java.lang.Enum
        public final boolean isAtLeast(androidx.lifecycle.Lifecycle.State state) {
            int i;
            Intrinsics.checkNotNullParameter(state, "state");
            i = compareTo((Enum)state) >= 0 ? 1 : 0;
            return i;
        }
    }
    public static void $r8$lambda$DNZNkfFOuaL0W-XhwA84q2dz864(MutableStateFlow mutableStateFlow, androidx.lifecycle.LifecycleOwner lifecycleOwner2, androidx.lifecycle.Lifecycle.Event lifecycle$Event3) {
        Lifecycle._get_currentStateFlow_$lambda$0(mutableStateFlow, lifecycleOwner2, event3);
    }

    public Lifecycle() {
        super();
        AtomicReference atomicReference = new AtomicReference(0);
        this.internalScopeRef = atomicReference;
    }

    private static final void _get_currentStateFlow_$lambda$0(MutableStateFlow $mutableStateFlow, androidx.lifecycle.LifecycleOwner lifecycleOwner2, androidx.lifecycle.Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(lifecycleOwner2, "<unused var>");
        Intrinsics.checkNotNullParameter(event, "event");
        $mutableStateFlow.setValue(event.getTargetState());
    }

    public abstract void addObserver(androidx.lifecycle.LifecycleObserver lifecycleObserver);

    public abstract androidx.lifecycle.Lifecycle.State getCurrentState();

    public StateFlow<androidx.lifecycle.Lifecycle.State> getCurrentStateFlow() {
        MutableStateFlow mutableStateFlow = StateFlowKt.MutableStateFlow(getCurrentState());
        Lifecycle$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new Lifecycle$$ExternalSyntheticLambda0(mutableStateFlow);
        final int i = 0;
        addObserver((LifecycleObserver)externalSyntheticLambda0);
        return FlowKt.asStateFlow(mutableStateFlow);
    }

    public final androidx.lifecycle.AtomicReference<Object> getInternalScopeRef() {
        return this.internalScopeRef;
    }

    public abstract void removeObserver(androidx.lifecycle.LifecycleObserver lifecycleObserver);

    public final void setInternalScopeRef(androidx.lifecycle.AtomicReference<Object> <set-?>) {
        Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
        this.internalScopeRef = <set-?>;
    }
}
