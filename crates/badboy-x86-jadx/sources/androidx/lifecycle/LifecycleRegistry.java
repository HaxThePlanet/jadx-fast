package androidx.lifecycle;

import androidx.arch.core.internal.FastSafeIterableMap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0016\u0018\u0000 <2\u00020\u0001:\u0002;<B\u0019\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007B\u0011\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0006\u0010\u0008J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000eH\u0017J\u0010\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\u000eH\u0002J\u0010\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\u000bH\u0002J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u000bH\u0017J\u0008\u0010/\u001a\u00020\u0019H\u0002J\u0010\u00100\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u00101\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\u000bH\u0017J\u0010\u00105\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u00106\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0008\u00107\u001a\u00020\u0019H\u0002J\u0010\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020:H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000c0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\u0016j\u0008\u0012\u0004\u0012\u00020\u000e`\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u001b\u0010\u001c\"\u0004\u0008\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\u000e0 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\"8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008#\u0010$R\u0014\u0010*\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008*\u0010+R\u0014\u00102\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00083\u00104¨\u0006=", d2 = {"Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/Lifecycle;", "provider", "Landroidx/lifecycle/LifecycleOwner;", "enforceMainThread", "", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Z)V", "(Landroidx/lifecycle/LifecycleOwner;)V", "observerMap", "Landroidx/arch/core/internal/FastSafeIterableMap;", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "state", "Landroidx/lifecycle/Lifecycle$State;", "lifecycleOwner", "Ljava/lang/ref/WeakReference;", "addingObserverCounter", "", "handlingEvent", "newEventOccurred", "parentStates", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "markState", "", "currentState", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "setCurrentState", "(Landroidx/lifecycle/Lifecycle$State;)V", "_currentStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "currentStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "handleLifecycleEvent", "event", "Landroidx/lifecycle/Lifecycle$Event;", "moveToState", "next", "isSynced", "()Z", "calculateTargetState", "observer", "addObserver", "popParentState", "pushParentState", "removeObserver", "observerCount", "getObserverCount", "()I", "forwardPass", "backwardPass", "sync", "enforceMainThreadIfNeeded", "methodName", "", "ObserverWithState", "Companion", "lifecycle-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public class LifecycleRegistry extends androidx.lifecycle.Lifecycle {

    public static final androidx.lifecycle.LifecycleRegistry.Companion Companion;
    private final MutableStateFlow<androidx.lifecycle.Lifecycle.State> _currentStateFlow;
    private int addingObserverCounter;
    private final boolean enforceMainThread;
    private boolean handlingEvent;
    private final WeakReference<androidx.lifecycle.LifecycleOwner> lifecycleOwner;
    private boolean newEventOccurred;
    private FastSafeIterableMap<androidx.lifecycle.LifecycleObserver, androidx.lifecycle.LifecycleRegistry.ObserverWithState> observerMap;
    private ArrayList<androidx.lifecycle.Lifecycle.State> parentStates;
    private androidx.lifecycle.Lifecycle.State state;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u001f\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0002\u0008\u000c¨\u0006\r", d2 = {"Landroidx/lifecycle/LifecycleRegistry$Companion;", "", "<init>", "()V", "createUnsafe", "Landroidx/lifecycle/LifecycleRegistry;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "min", "Landroidx/lifecycle/Lifecycle$State;", "state1", "state2", "min$lifecycle_runtime_release", "lifecycle-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        @JvmStatic
        public final androidx.lifecycle.LifecycleRegistry createUnsafe(androidx.lifecycle.LifecycleOwner owner) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(owner, 0, 0);
            return lifecycleRegistry;
        }

        @JvmStatic
        public final androidx.lifecycle.Lifecycle.State min$lifecycle_runtime_release(androidx.lifecycle.Lifecycle.State state1, androidx.lifecycle.Lifecycle.State state2) {
            String compareTo;
            Object obj;
            Intrinsics.checkNotNullParameter(state1, "state1");
            if (state2 != null && state2.compareTo((Enum)state1) < 0) {
                obj = state2.compareTo((Enum)state1) < 0 ? state2 : state1;
            } else {
            }
            return obj;
        }
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0018\u0010\u0013\u001a\u00020\u00142\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0008\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012¨\u0006\u0019", d2 = {"Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "", "observer", "Landroidx/lifecycle/LifecycleObserver;", "initialState", "Landroidx/lifecycle/Lifecycle$State;", "<init>", "(Landroidx/lifecycle/LifecycleObserver;Landroidx/lifecycle/Lifecycle$State;)V", "state", "getState", "()Landroidx/lifecycle/Lifecycle$State;", "setState", "(Landroidx/lifecycle/Lifecycle$State;)V", "lifecycleObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "getLifecycleObserver", "()Landroidx/lifecycle/LifecycleEventObserver;", "setLifecycleObserver", "(Landroidx/lifecycle/LifecycleEventObserver;)V", "dispatchEvent", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-runtime_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ObserverWithState {

        private androidx.lifecycle.LifecycleEventObserver lifecycleObserver;
        private androidx.lifecycle.Lifecycle.State state;
        public ObserverWithState(androidx.lifecycle.LifecycleObserver observer, androidx.lifecycle.Lifecycle.State initialState) {
            Intrinsics.checkNotNullParameter(initialState, "initialState");
            super();
            Intrinsics.checkNotNull(observer);
            this.lifecycleObserver = Lifecycling.lifecycleEventObserver(observer);
            this.state = initialState;
        }

        public final void dispatchEvent(androidx.lifecycle.LifecycleOwner owner, androidx.lifecycle.Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(event, "event");
            androidx.lifecycle.Lifecycle.State targetState = event.getTargetState();
            this.state = LifecycleRegistry.Companion.min$lifecycle_runtime_release(this.state, targetState);
            Intrinsics.checkNotNull(owner);
            this.lifecycleObserver.onStateChanged(owner, event);
            this.state = targetState;
        }

        public final androidx.lifecycle.LifecycleEventObserver getLifecycleObserver() {
            return this.lifecycleObserver;
        }

        public final androidx.lifecycle.Lifecycle.State getState() {
            return this.state;
        }

        public final void setLifecycleObserver(androidx.lifecycle.LifecycleEventObserver <set-?>) {
            Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
            this.lifecycleObserver = <set-?>;
        }

        public final void setState(androidx.lifecycle.Lifecycle.State <set-?>) {
            Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
            this.state = <set-?>;
        }
    }
    static {
        LifecycleRegistry.Companion companion = new LifecycleRegistry.Companion(0);
        LifecycleRegistry.Companion = companion;
    }

    public LifecycleRegistry(androidx.lifecycle.LifecycleOwner provider) {
        Intrinsics.checkNotNullParameter(provider, "provider");
        super(provider, 1);
    }

    private LifecycleRegistry(androidx.lifecycle.LifecycleOwner provider, boolean enforceMainThread) {
        super();
        this.enforceMainThread = enforceMainThread;
        FastSafeIterableMap fastSafeIterableMap = new FastSafeIterableMap();
        this.observerMap = fastSafeIterableMap;
        this.state = Lifecycle.State.INITIALIZED;
        ArrayList arrayList = new ArrayList();
        this.parentStates = arrayList;
        WeakReference weakReference = new WeakReference(provider);
        this.lifecycleOwner = weakReference;
        this._currentStateFlow = StateFlowKt.MutableStateFlow(Lifecycle.State.INITIALIZED);
    }

    public LifecycleRegistry(androidx.lifecycle.LifecycleOwner lifecycleOwner, boolean z2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(lifecycleOwner, z2);
    }

    private final void backwardPass(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        String value;
        boolean newEventOccurred;
        Object key;
        int newEventOccurred2;
        androidx.lifecycle.Lifecycle.State targetState;
        Iterator descendingIterator = this.observerMap.descendingIterator();
        Intrinsics.checkNotNullExpressionValue(descendingIterator, "descendingIterator(...)");
        while (descendingIterator.hasNext()) {
            if (!this.newEventOccurred) {
            }
            Object next = descendingIterator.next();
            Intrinsics.checkNotNull((Map.Entry)next);
            value = next.getValue();
            while ((LifecycleRegistry.ObserverWithState)value.getState().compareTo((Enum)this.state) > 0) {
                newEventOccurred2 = Lifecycle.Event.Companion.downFrom(value.getState());
                pushParentState(newEventOccurred2.getTargetState());
                value.dispatchEvent(lifecycleOwner, newEventOccurred2);
                popParentState();
            }
            newEventOccurred2 = Lifecycle.Event.Companion.downFrom(value.getState());
            pushParentState(newEventOccurred2.getTargetState());
            value.dispatchEvent(lifecycleOwner, newEventOccurred2);
            popParentState();
        }
    }

    private final androidx.lifecycle.Lifecycle.State calculateTargetState(androidx.lifecycle.LifecycleObserver observer) {
        int i;
        Object value;
        int state;
        boolean empty;
        Map.Entry ceil = this.observerMap.ceil(observer);
        value = ceil.getValue();
        if (ceil != null && (LifecycleRegistry.ObserverWithState)value != null) {
            value = ceil.getValue();
            if ((LifecycleRegistry.ObserverWithState)(LifecycleRegistry.ObserverWithState)value != null) {
                state = (LifecycleRegistry.ObserverWithState)(LifecycleRegistry.ObserverWithState)value.getState();
            } else {
                state = i;
            }
        } else {
        }
        if (!(Collection)this.parentStates.isEmpty()) {
            i = this.parentStates.get(size--);
        }
        return LifecycleRegistry.Companion.min$lifecycle_runtime_release(LifecycleRegistry.Companion.min$lifecycle_runtime_release(this.state, state), i);
    }

    @JvmStatic
    public static final androidx.lifecycle.LifecycleRegistry createUnsafe(androidx.lifecycle.LifecycleOwner owner) {
        return LifecycleRegistry.Companion.createUnsafe(owner);
    }

    private final void enforceMainThreadIfNeeded(String methodName) {
        boolean enforceMainThread;
        if (this.enforceMainThread) {
            if (!LifecycleRegistry_androidKt.isMainThread()) {
            } else {
            }
            int i = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Method ").append(methodName).append(" must be called on the main thread").toString().toString());
            throw illegalStateException;
        }
    }

    private final void forwardPass(androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        String value;
        boolean newEventOccurred;
        Object key;
        int newEventOccurred2;
        androidx.lifecycle.Lifecycle.State state;
        androidx.arch.core.internal.SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = this.observerMap.iteratorWithAdditions();
        Intrinsics.checkNotNullExpressionValue(iteratorWithAdditions, "iteratorWithAdditions(...)");
        while ((Iterator)iteratorWithAdditions.hasNext()) {
            if (!this.newEventOccurred) {
            }
            Object next = iteratorWithAdditions.next();
            value = next.getValue();
            while ((LifecycleRegistry.ObserverWithState)value.getState().compareTo((Enum)this.state) < 0) {
                pushParentState(value.getState());
                newEventOccurred2 = Lifecycle.Event.Companion.upFrom(value.getState());
                value.dispatchEvent(lifecycleOwner, newEventOccurred2);
                popParentState();
            }
            pushParentState(value.getState());
            newEventOccurred2 = Lifecycle.Event.Companion.upFrom(value.getState());
            value.dispatchEvent(lifecycleOwner, newEventOccurred2);
            popParentState();
        }
    }

    private final boolean isSynced() {
        int i;
        androidx.lifecycle.Lifecycle.State state;
        if (this.observerMap.size() == 0) {
            return 1;
        }
        Map.Entry eldest = this.observerMap.eldest();
        Intrinsics.checkNotNull(eldest);
        Map.Entry newest = this.observerMap.newest();
        Intrinsics.checkNotNull(newest);
        androidx.lifecycle.Lifecycle.State state3 = (LifecycleRegistry.ObserverWithState)newest.getValue().getState();
        if ((LifecycleRegistry.ObserverWithState)eldest.getValue().getState() == state3 && this.state == state3) {
            if (this.state == state3) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @JvmStatic
    public static final androidx.lifecycle.Lifecycle.State min$lifecycle_runtime_release(androidx.lifecycle.Lifecycle.State state1, androidx.lifecycle.Lifecycle.State state2) {
        return LifecycleRegistry.Companion.min$lifecycle_runtime_release(state1, state2);
    }

    private final void moveToState(androidx.lifecycle.Lifecycle.State next) {
        Object fastSafeIterableMap;
        boolean addingObserverCounter;
        if (this.state == next) {
        }
        LifecycleRegistryKt.checkLifecycleStateTransition((LifecycleOwner)this.lifecycleOwner.get(), this.state, next);
        this.state = next;
        int i2 = 1;
        if (!this.handlingEvent) {
            if (this.addingObserverCounter != 0) {
            } else {
                this.handlingEvent = i2;
                sync();
                this.handlingEvent = false;
                if (this.state == Lifecycle.State.DESTROYED) {
                    fastSafeIterableMap = new FastSafeIterableMap();
                    this.observerMap = fastSafeIterableMap;
                }
            }
        }
        this.newEventOccurred = i2;
    }

    private final void popParentState() {
        this.parentStates.remove(size--);
    }

    private final void pushParentState(androidx.lifecycle.Lifecycle.State state) {
        this.parentStates.add(state);
    }

    private final void sync() {
        Map.Entry newest;
        boolean newEventOccurred;
        androidx.lifecycle.Lifecycle.State state;
        Object obj = this.lifecycleOwner.get();
        if ((LifecycleOwner)obj == null) {
        } else {
            int i = 0;
            while (!isSynced()) {
                this.newEventOccurred = i;
                Map.Entry eldest = this.observerMap.eldest();
                Intrinsics.checkNotNull(eldest);
                if (this.state.compareTo((Enum)(LifecycleRegistry.ObserverWithState)eldest.getValue().getState()) < 0) {
                }
                newest = this.observerMap.newest();
                if (!this.newEventOccurred && newest != null && this.state.compareTo((Enum)(LifecycleRegistry.ObserverWithState)newest.getValue().getState()) > 0) {
                }
                i = 0;
                if (newest != null) {
                }
                if (this.state.compareTo((Enum)(LifecycleRegistry.ObserverWithState)newest.getValue().getState()) > 0) {
                }
                forwardPass((LifecycleOwner)obj);
                backwardPass(obj);
            }
            this.newEventOccurred = i;
            this._currentStateFlow.setValue(getCurrentState());
        }
        IllegalStateException lifecycleOwner2 = new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        throw lifecycleOwner2;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(androidx.lifecycle.LifecycleObserver observer) {
        androidx.lifecycle.Lifecycle.State iNITIALIZED;
        int addingObserverCounter;
        int i;
        int upFrom;
        int compareTo;
        androidx.lifecycle.Lifecycle.State targetState;
        int state;
        Intrinsics.checkNotNullParameter(observer, "observer");
        enforceMainThreadIfNeeded("addObserver");
        iNITIALIZED = this.state == Lifecycle.State.DESTROYED ? Lifecycle.State.DESTROYED : Lifecycle.State.INITIALIZED;
        LifecycleRegistry.ObserverWithState observerWithState = new LifecycleRegistry.ObserverWithState(observer, iNITIALIZED);
        if ((LifecycleRegistry.ObserverWithState)this.observerMap.putIfAbsent(observer, observerWithState) != null) {
        }
        Object obj = this.lifecycleOwner.get();
        if ((LifecycleOwner)obj == null) {
        }
        upFrom = 1;
        if (this.addingObserverCounter == 0) {
            if (this.handlingEvent) {
                i = upFrom;
            } else {
                i = 0;
            }
        } else {
        }
        targetState = calculateTargetState(observer);
        this.addingObserverCounter = addingObserverCounter3 += upFrom;
        while (observerWithState.getState().compareTo((Enum)targetState) < 0) {
            pushParentState(observerWithState.getState());
            upFrom = Lifecycle.Event.Companion.upFrom(observerWithState.getState());
            observerWithState.dispatchEvent((LifecycleOwner)obj, upFrom);
            popParentState();
            targetState = calculateTargetState(observer);
        }
        if (i == 0) {
            sync();
        }
        this.addingObserverCounter = addingObserverCounter2--;
    }

    @Override // androidx.lifecycle.Lifecycle
    public androidx.lifecycle.Lifecycle.State getCurrentState() {
        return this.state;
    }

    public StateFlow<androidx.lifecycle.Lifecycle.State> getCurrentStateFlow() {
        return FlowKt.asStateFlow(this._currentStateFlow);
    }

    @Override // androidx.lifecycle.Lifecycle
    public int getObserverCount() {
        enforceMainThreadIfNeeded("getObserverCount");
        return this.observerMap.size();
    }

    @Override // androidx.lifecycle.Lifecycle
    public void handleLifecycleEvent(androidx.lifecycle.Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(event.getTargetState());
    }

    @Deprecated(message = "Override [currentState].")
    public void markState(androidx.lifecycle.Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        enforceMainThreadIfNeeded("markState");
        setCurrentState(state);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(androidx.lifecycle.LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(observer);
    }

    @Override // androidx.lifecycle.Lifecycle
    public void setCurrentState(androidx.lifecycle.Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(state);
    }
}
