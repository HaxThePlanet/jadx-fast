package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u0015\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u000c\u001a\u00020\rH\u0016¢\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00102\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0012H\u0016R\u001b\u0010\u0006\u001a\u00028\u00008BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\t\u0010\n\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0013", d2 = {"Landroidx/compose/runtime/LazyValueHolder;", "T", "Landroidx/compose/runtime/ValueHolder;", "valueProducer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "current", "getCurrent", "()Ljava/lang/Object;", "current$delegate", "Lkotlin/Lazy;", "readValue", "map", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)Ljava/lang/Object;", "toProvided", "Landroidx/compose/runtime/ProvidedValue;", "local", "Landroidx/compose/runtime/CompositionLocal;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class LazyValueHolder<T>  implements androidx.compose.runtime.ValueHolder<T> {

    public static final int $stable = 8;
    private final Lazy current$delegate;
    static {
        final int i = 8;
    }

    public LazyValueHolder(Function0<? extends T> valueProducer) {
        super();
        this.current$delegate = LazyKt.lazy(valueProducer);
    }

    private final T getCurrent() {
        return this.current$delegate.getValue();
    }

    public T readValue(androidx.compose.runtime.PersistentCompositionLocalMap map) {
        return getCurrent();
    }

    public androidx.compose.runtime.ProvidedValue<T> toProvided(androidx.compose.runtime.CompositionLocal<T> local) {
        ComposerKt.composeRuntimeError("Cannot produce a provider from a lazy value holder");
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }
}
