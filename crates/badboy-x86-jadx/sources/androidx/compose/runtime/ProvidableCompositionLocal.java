package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008'\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0008\u0000\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0008\u001a\u00028\u0000H ¢\u0006\u0004\u0008\t\u0010\nJ\u001c\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0008\u001a\u00028\u0000H\u0086\u0004¢\u0006\u0002\u0010\nJ(\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00072\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00028\u00000\u000e¢\u0006\u0002\u0008\u0010H\u0086\u0004J\u001c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0008\u001a\u00028\u0000H\u0086\u0004¢\u0006\u0002\u0010\nJ1\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00132\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00072\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013H\u0010¢\u0006\u0002\u0008\u0015J\u001c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00132\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0007H\u0002¨\u0006\u0017", d2 = {"Landroidx/compose/runtime/ProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/CompositionLocal;", "defaultFactory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "defaultProvidedValue", "Landroidx/compose/runtime/ProvidedValue;", "value", "defaultProvidedValue$runtime_release", "(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;", "provides", "providesComputed", "compute", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "providesDefault", "updatedStateOf", "Landroidx/compose/runtime/ValueHolder;", "previous", "updatedStateOf$runtime_release", "valueHolderOf", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ProvidableCompositionLocal<T>  extends androidx.compose.runtime.CompositionLocal<T> {

    public static final int $stable;
    static {
    }

    public ProvidableCompositionLocal(Function0<? extends T> defaultFactory) {
        super(defaultFactory, 0);
    }

    private final androidx.compose.runtime.ValueHolder<T> valueHolderOf(androidx.compose.runtime.ProvidedValue<T> value) {
        Object computedValueHolder;
        Object effectiveValue$runtime_release;
        androidx.compose.runtime.SnapshotMutationPolicy mutationPolicy$runtime_release;
        if (value.isDynamic$runtime_release()) {
            if (value.getState$runtime_release() == null && value.getMutationPolicy$runtime_release() == null) {
                if (value.getMutationPolicy$runtime_release() == null) {
                    mutationPolicy$runtime_release = SnapshotStateKt.structuralEqualityPolicy();
                }
                effectiveValue$runtime_release = SnapshotStateKt.mutableStateOf(value.getValue(), mutationPolicy$runtime_release);
            }
            computedValueHolder = new DynamicValueHolder(effectiveValue$runtime_release);
        } else {
            if (value.getCompute$runtime_release() != null) {
                computedValueHolder = new ComputedValueHolder(value.getCompute$runtime_release());
            } else {
                if (value.getState$runtime_release() != null) {
                    computedValueHolder = new DynamicValueHolder(value.getState$runtime_release());
                } else {
                    computedValueHolder = new StaticValueHolder(value.getEffectiveValue$runtime_release());
                }
            }
        }
        return computedValueHolder;
    }

    public abstract androidx.compose.runtime.ProvidedValue<T> defaultProvidedValue$runtime_release(T t);

    public final androidx.compose.runtime.ProvidedValue<T> provides(T value) {
        return defaultProvidedValue$runtime_release(value);
    }

    public final androidx.compose.runtime.ProvidedValue<T> providesComputed(Function1<? super androidx.compose.runtime.CompositionLocalAccessorScope, ? extends T> compute) {
        ProvidedValue providedValue = new ProvidedValue((CompositionLocal)this, 0, 0, 0, 0, compute, 0);
        return providedValue;
    }

    public final androidx.compose.runtime.ProvidedValue<T> providesDefault(T value) {
        return defaultProvidedValue$runtime_release(value).ifNotAlreadyProvided$runtime_release();
    }

    public androidx.compose.runtime.ValueHolder<T> updatedStateOf$runtime_release(androidx.compose.runtime.ProvidedValue<T> value, androidx.compose.runtime.ValueHolder<T> previous) {
        boolean dynamic$runtime_release;
        int valueHolderOf;
        Object compute;
        valueHolderOf = 0;
        if (previous instanceof DynamicValueHolder) {
            if (value.isDynamic$runtime_release()) {
                (DynamicValueHolder)previous.getState().setValue(value.getEffectiveValue$runtime_release());
                valueHolderOf = previous;
            } else {
            }
        } else {
            if (previous instanceof StaticValueHolder) {
                if (value.isStatic$runtime_release() && Intrinsics.areEqual(value.getEffectiveValue$runtime_release(), (StaticValueHolder)previous.getValue())) {
                    if (Intrinsics.areEqual(value.getEffectiveValue$runtime_release(), (StaticValueHolder)previous.getValue())) {
                        valueHolderOf = previous;
                    } else {
                    }
                } else {
                }
            } else {
                if (previous instanceof ComputedValueHolder) {
                    if (value.getCompute$runtime_release() == (ComputedValueHolder)previous.getCompute()) {
                        valueHolderOf = previous;
                    } else {
                    }
                } else {
                }
            }
        }
        if (valueHolderOf == 0) {
            valueHolderOf = valueHolderOf(value);
        }
        return valueHolderOf;
    }
}
