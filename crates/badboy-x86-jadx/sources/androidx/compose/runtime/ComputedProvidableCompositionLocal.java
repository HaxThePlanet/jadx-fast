package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001e\u0012\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0008\u0006¢\u0006\u0002\u0010\u0007J\u001d\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0010¢\u0006\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00028\u00000\tX\u0090\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0011", d2 = {"Landroidx/compose/runtime/ComputedProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "defaultComputation", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)V", "defaultValueHolder", "Landroidx/compose/runtime/ComputedValueHolder;", "getDefaultValueHolder$runtime_release", "()Landroidx/compose/runtime/ComputedValueHolder;", "defaultProvidedValue", "Landroidx/compose/runtime/ProvidedValue;", "value", "defaultProvidedValue$runtime_release", "(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ComputedProvidableCompositionLocal<T>  extends androidx.compose.runtime.ProvidableCompositionLocal<T> {

    public static final int $stable;
    private final androidx.compose.runtime.ComputedValueHolder<T> defaultValueHolder;
    static {
    }

    public ComputedProvidableCompositionLocal(Function1<? super androidx.compose.runtime.CompositionLocalAccessorScope, ? extends T> defaultComputation) {
        super((Function0)ComputedProvidableCompositionLocal.1.INSTANCE);
        ComputedValueHolder computedValueHolder = new ComputedValueHolder(defaultComputation);
        this.defaultValueHolder = computedValueHolder;
    }

    public androidx.compose.runtime.ProvidedValue<T> defaultProvidedValue$runtime_release(T value) {
        int i;
        i = value == null ? 1 : 0;
        ProvidedValue providedValue = new ProvidedValue((CompositionLocal)this, value, i, 0, 0, 0, 1);
        return providedValue;
    }

    public androidx.compose.runtime.ComputedValueHolder<T> getDefaultValueHolder$runtime_release() {
        return this.defaultValueHolder;
    }

    @Override // androidx.compose.runtime.ProvidableCompositionLocal
    public androidx.compose.runtime.ValueHolder getDefaultValueHolder$runtime_release() {
        return (ValueHolder)getDefaultValueHolder$runtime_release();
    }
}
