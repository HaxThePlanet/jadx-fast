package androidx.lifecycle.internal;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.savedstate.SavedStateRegistry.SavedStateProvider;
import androidx.savedstate.SavedStateWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010%\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\"\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0008\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0016\u0008\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u000cH\u0007J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0004H\u0087\u0002J)\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u0002H\u00190\u0018\"\u0004\u0008\u0000\u0010\u00192\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u0002H\u0019H\u0007¢\u0006\u0002\u0010\u001bJ)\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u0002H\u00190\u000e\"\u0004\u0008\u0000\u0010\u00192\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u0002H\u0019H\u0007¢\u0006\u0002\u0010\u001dJ\u000e\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u001fH\u0007J\u001e\u0010 \u001a\u0004\u0018\u0001H\u0019\"\u0004\u0008\u0000\u0010\u00192\u0006\u0010\u0016\u001a\u00020\u0004H\u0087\u0002¢\u0006\u0002\u0010!J&\u0010\"\u001a\u00020#\"\u0004\u0008\u0000\u0010\u00192\u0006\u0010\u0016\u001a\u00020\u00042\u0008\u0010$\u001a\u0004\u0018\u0001H\u0019H\u0087\u0002¢\u0006\u0002\u0010%J\u001d\u0010&\u001a\u0004\u0018\u0001H\u0019\"\u0004\u0008\u0000\u0010\u00192\u0006\u0010\u0016\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010!J\u0018\u0010'\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u000cH\u0007J\u0010\u0010)\u001a\u00020#2\u0006\u0010\u0016\u001a\u00020\u0004H\u0007R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000c0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e0\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R%\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e0\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\nR\u0011\u0010\u0011\u001a\u00020\u000c¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006*", d2 = {"Landroidx/lifecycle/internal/SavedStateHandleImpl;", "", "initialState", "", "", "<init>", "(Ljava/util/Map;)V", "regular", "", "getRegular", "()Ljava/util/Map;", "providers", "Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "flows", "Lkotlinx/coroutines/flow/MutableStateFlow;", "mutableFlows", "getMutableFlows", "savedStateProvider", "getSavedStateProvider", "()Landroidx/savedstate/SavedStateRegistry$SavedStateProvider;", "contains", "", "key", "getStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "T", "initialValue", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/StateFlow;", "getMutableStateFlow", "(Ljava/lang/String;Ljava/lang/Object;)Lkotlinx/coroutines/flow/MutableStateFlow;", "keys", "", "get", "(Ljava/lang/String;)Ljava/lang/Object;", "set", "", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "remove", "setSavedStateProvider", "provider", "clearSavedStateProvider", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SavedStateHandleImpl {

    private final Map<String, MutableStateFlow<Object>> flows;
    private final Map<String, MutableStateFlow<Object>> mutableFlows;
    private final Map<String, SavedStateRegistry.SavedStateProvider> providers;
    private final Map<String, Object> regular;
    private final SavedStateRegistry.SavedStateProvider savedStateProvider;
    public static Bundle $r8$lambda$-OwJNegmCu5Gt1ZLmTJOtaJJkzo(androidx.lifecycle.internal.SavedStateHandleImpl savedStateHandleImpl) {
        return SavedStateHandleImpl.savedStateProvider$lambda$0(savedStateHandleImpl);
    }

    public SavedStateHandleImpl() {
        final int i = 0;
        super(i, 1, i);
    }

    public SavedStateHandleImpl(Map<String, ? extends Object> initialState) {
        Intrinsics.checkNotNullParameter(initialState, "initialState");
        super();
        this.regular = MapsKt.toMutableMap(initialState);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.providers = (Map)linkedHashMap;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        this.flows = (Map)linkedHashMap2;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        this.mutableFlows = (Map)linkedHashMap3;
        SavedStateHandleImpl$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new SavedStateHandleImpl$$ExternalSyntheticLambda0(this);
        this.savedStateProvider = externalSyntheticLambda0;
    }

    public SavedStateHandleImpl(Map map, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        Map obj1;
        if (i2 &= 1 != 0) {
            obj1 = MapsKt.emptyMap();
        }
        super(obj1);
    }

    private static final Bundle savedStateProvider$lambda$0(androidx.lifecycle.internal.SavedStateHandleImpl this$0) {
        Object value2;
        boolean value3;
        Object key2;
        kotlin.Pair[] $i$f$toTypedArray;
        Object state;
        int arr;
        ArrayList list;
        ArrayList arrayList;
        Map map;
        int i;
        Iterator iterator;
        boolean next;
        kotlin.Pair pair;
        Object key;
        Object value;
        Iterator iterator2 = MapsKt.toMap(this$0.mutableFlows).entrySet().iterator();
        for (Map.Entry next4 : iterator2) {
            this$0.set((String)next4.getKey(), (MutableStateFlow)next4.getValue().getValue());
        }
        Iterator iterator3 = MapsKt.toMap(this$0.providers).entrySet().iterator();
        for (Map.Entry next3 : iterator3) {
            this$0.set((String)next3.getKey(), (SavedStateRegistry.SavedStateProvider)next3.getValue().saveState());
        }
        Map regular = this$0.regular;
        int i2 = 0;
        arr = 0;
        if (regular.isEmpty()) {
            $i$f$toTypedArray = new Pair[arr];
        } else {
            Map map4 = regular;
            int i4 = 0;
            arrayList = new ArrayList(map4.size());
            i = 0;
            iterator = map4.entrySet().iterator();
            for (Map.Entry next : iterator) {
                int i8 = 0;
                (Collection)arrayList.add(TuplesKt.to((String)next.getKey(), next.getValue()));
            }
            int i3 = 0;
            $i$f$toTypedArray = (Collection)(List)arrayList.toArray(new Pair[arr]);
        }
        Bundle bundleOf = BundleKt.bundleOf((Pair[])Arrays.copyOf($i$f$toTypedArray, $i$f$toTypedArray.length));
        int i5 = 0;
        int i6 = 0;
        Bundle constructor-impl = SavedStateWriter.constructor-impl(bundleOf);
        int i7 = 0;
        return bundleOf;
    }

    public final void clearSavedStateProvider(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.providers.remove(key);
    }

    public final boolean contains(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.regular.containsKey(key);
    }

    public final <T> T get(String key) {
        Object value;
        int i;
        Intrinsics.checkNotNullParameter(key, "key");
        value = this.mutableFlows.get(key);
        if ((MutableStateFlow)value != null) {
            if ((MutableStateFlow)value.getValue() == null) {
                value = this.regular.get(key);
            }
        } else {
        }
        return value;
    }

    public final Map<String, MutableStateFlow<Object>> getMutableFlows() {
        return this.mutableFlows;
    }

    public final <T> MutableStateFlow<T> getMutableStateFlow(String key, T initialValue) {
        Object mutableStateFlow;
        boolean regular;
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Map mutableFlows = this.mutableFlows;
        final int i = 0;
        final Object obj2 = mutableFlows.get(key);
        if (obj2 == null) {
            int i2 = 0;
            if (!this.regular.containsKey(key)) {
                this.regular.put(key, initialValue);
            }
            mutableFlows.put(key, StateFlowKt.MutableStateFlow(this.regular.get(key)));
        } else {
            mutableStateFlow = obj2;
        }
        Intrinsics.checkNotNull((MutableStateFlow)mutableStateFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.MutableStateFlow<T of androidx.lifecycle.internal.SavedStateHandleImpl.getMutableStateFlow>");
        return mutableStateFlow;
    }

    public final Map<String, Object> getRegular() {
        return this.regular;
    }

    public final SavedStateRegistry.SavedStateProvider getSavedStateProvider() {
        return this.savedStateProvider;
    }

    public final <T> StateFlow<T> getStateFlow(String key, T initialValue) {
        Object mutableStateFlow;
        boolean regular;
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Map flows = this.flows;
        int i = 0;
        final Object obj2 = flows.get(key);
        if (obj2 == null) {
            int i2 = 0;
            if (!this.regular.containsKey(key)) {
                this.regular.put(key, initialValue);
            }
            flows.put(key, StateFlowKt.MutableStateFlow(this.regular.get(key)));
        } else {
            mutableStateFlow = obj2;
        }
        StateFlow stateFlow = FlowKt.asStateFlow((MutableStateFlow)mutableStateFlow);
        Intrinsics.checkNotNull(stateFlow, "null cannot be cast to non-null type kotlinx.coroutines.flow.StateFlow<T of androidx.lifecycle.internal.SavedStateHandleImpl.getStateFlow>");
        return stateFlow;
    }

    public final Set<String> keys() {
        return SetsKt.plus(this.regular.keySet(), (Iterable)this.providers.keySet());
    }

    public final <T> T remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.flows.remove(key);
        this.mutableFlows.remove(key);
        return this.regular.remove(key);
    }

    public final SavedStateRegistry.SavedStateProvider savedStateProvider() {
        return this.savedStateProvider;
    }

    public final <T> void set(String key, T value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.regular.put(key, value);
        Object obj = this.flows.get(key);
        if ((MutableStateFlow)obj != null) {
            (MutableStateFlow)obj.setValue(value);
        }
        Object obj2 = this.mutableFlows.get(key);
        if ((MutableStateFlow)obj2 != null) {
            (MutableStateFlow)obj2.setValue(value);
        }
    }

    public final void setSavedStateProvider(String key, SavedStateRegistry.SavedStateProvider provider) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(provider, "provider");
        this.providers.put(key, provider);
    }
}
