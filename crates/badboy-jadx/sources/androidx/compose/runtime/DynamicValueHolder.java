package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u000f\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0003J\u001f\u0010\t\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u000e\u0008\u0002\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0015\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013J\u001c\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00152\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0017H\u0016J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u001a", d2 = {"Landroidx/compose/runtime/DynamicValueHolder;", "T", "Landroidx/compose/runtime/ValueHolder;", "state", "Landroidx/compose/runtime/MutableState;", "(Landroidx/compose/runtime/MutableState;)V", "getState", "()Landroidx/compose/runtime/MutableState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "readValue", "map", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)Ljava/lang/Object;", "toProvided", "Landroidx/compose/runtime/ProvidedValue;", "local", "Landroidx/compose/runtime/CompositionLocal;", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DynamicValueHolder<T>  implements androidx.compose.runtime.ValueHolder<T> {

    public static final int $stable;
    private final androidx.compose.runtime.MutableState<T> state;
    static {
    }

    public DynamicValueHolder(androidx.compose.runtime.MutableState<T> state) {
        super();
        this.state = state;
    }

    public static androidx.compose.runtime.DynamicValueHolder copy$default(androidx.compose.runtime.DynamicValueHolder dynamicValueHolder, androidx.compose.runtime.MutableState mutableState2, int i3, Object object4) {
        androidx.compose.runtime.MutableState obj1;
        if (i3 &= 1 != 0) {
            obj1 = dynamicValueHolder.state;
        }
        return dynamicValueHolder.copy(obj1);
    }

    public final androidx.compose.runtime.MutableState<T> component1() {
        return this.state;
    }

    public final androidx.compose.runtime.DynamicValueHolder<T> copy(androidx.compose.runtime.MutableState<T> mutableState) {
        DynamicValueHolder dynamicValueHolder = new DynamicValueHolder(mutableState);
        return dynamicValueHolder;
    }

    @Override // androidx.compose.runtime.ValueHolder
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof DynamicValueHolder) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.state, obj.state)) {
            return i2;
        }
        return i;
    }

    public final androidx.compose.runtime.MutableState<T> getState() {
        return this.state;
    }

    @Override // androidx.compose.runtime.ValueHolder
    public int hashCode() {
        return this.state.hashCode();
    }

    public T readValue(androidx.compose.runtime.PersistentCompositionLocalMap map) {
        return this.state.getValue();
    }

    public androidx.compose.runtime.ProvidedValue<T> toProvided(androidx.compose.runtime.CompositionLocal<T> local) {
        ProvidedValue providedValue = new ProvidedValue(local, 0, 0, 0, this.state, 0, 1);
        return providedValue;
    }

    @Override // androidx.compose.runtime.ValueHolder
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DynamicValueHolder(state=").append(this.state).append(')').toString();
    }
}
