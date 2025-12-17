package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u001d\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002Bj\u0008\u0000\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\u0008\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000b\u0012\u0019\u0010\u000c\u001a\u0015\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r¢\u0006\u0002\u0008\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0007¢\u0006\u0002\u0010\u0011J\u0013\u0010*\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0000H\u0000¢\u0006\u0002\u0008+R \u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00078G@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R'\u0010\u000c\u001a\u0015\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u0000\u0018\u00010\r¢\u0006\u0002\u0008\u000fX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00028\u00008@X\u0080\u0004¢\u0006\u000c\u0012\u0004\u0008\u001b\u0010\u001c\u001a\u0004\u0008\u001d\u0010\u001eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0007X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\u0015R\u001c\u0010\u0008\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010#R\u0012\u0010$\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%R\u001c\u0010\n\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000bX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u0017\u0010\u0005\u001a\u00028\u00008F¢\u0006\u000c\u0012\u0004\u0008(\u0010\u001c\u001a\u0004\u0008)\u0010\u001e¨\u0006,", d2 = {"Landroidx/compose/runtime/ProvidedValue;", "T", "", "compositionLocal", "Landroidx/compose/runtime/CompositionLocal;", "value", "explicitNull", "", "mutationPolicy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "state", "Landroidx/compose/runtime/MutableState;", "compute", "Lkotlin/Function1;", "Landroidx/compose/runtime/CompositionLocalAccessorScope;", "Lkotlin/ExtensionFunctionType;", "isDynamic", "(Landroidx/compose/runtime/CompositionLocal;Ljava/lang/Object;ZLandroidx/compose/runtime/SnapshotMutationPolicy;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function1;Z)V", "<set-?>", "canOverride", "getCanOverride", "()Z", "getCompositionLocal", "()Landroidx/compose/runtime/CompositionLocal;", "getCompute$runtime_release", "()Lkotlin/jvm/functions/Function1;", "effectiveValue", "getEffectiveValue$runtime_release$annotations", "()V", "getEffectiveValue$runtime_release", "()Ljava/lang/Object;", "isDynamic$runtime_release", "isStatic", "isStatic$runtime_release", "getMutationPolicy$runtime_release", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "providedValue", "Ljava/lang/Object;", "getState$runtime_release", "()Landroidx/compose/runtime/MutableState;", "getValue$annotations", "getValue", "ifNotAlreadyProvided", "ifNotAlreadyProvided$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ProvidedValue<T>  {

    public static final int $stable = 8;
    private boolean canOverride = true;
    private final androidx.compose.runtime.CompositionLocal<T> compositionLocal;
    private final Function1<androidx.compose.runtime.CompositionLocalAccessorScope, T> compute;
    private final boolean explicitNull;
    private final boolean isDynamic;
    private final androidx.compose.runtime.SnapshotMutationPolicy<T> mutationPolicy;
    private final T providedValue;
    private final androidx.compose.runtime.MutableState<T> state;
    static {
        final int i = 8;
    }

    public ProvidedValue(androidx.compose.runtime.CompositionLocal<T> compositionLocal, T value, boolean explicitNull, androidx.compose.runtime.SnapshotMutationPolicy<T> mutationPolicy, androidx.compose.runtime.MutableState<T> state, Function1<? super androidx.compose.runtime.CompositionLocalAccessorScope, ? extends T> compute, boolean isDynamic) {
        super();
        this.compositionLocal = compositionLocal;
        this.explicitNull = explicitNull;
        this.mutationPolicy = mutationPolicy;
        this.state = state;
        this.compute = compute;
        this.isDynamic = isDynamic;
        this.providedValue = value;
        final int i = 1;
    }

    public static void getEffectiveValue$runtime_release$annotations() {
    }

    public static void getValue$annotations() {
    }

    public final boolean getCanOverride() {
        return this.canOverride;
    }

    public final androidx.compose.runtime.CompositionLocal<T> getCompositionLocal() {
        return this.compositionLocal;
    }

    public final Function1<androidx.compose.runtime.CompositionLocalAccessorScope, T> getCompute$runtime_release() {
        return this.compute;
    }

    public final T getEffectiveValue$runtime_release() {
        Object providedValue;
        if (this.explicitNull) {
            providedValue = 0;
            return providedValue;
        } else {
            if (this.state != null) {
                providedValue = this.state.getValue();
            } else {
                if (this.providedValue == null) {
                } else {
                    providedValue = this.providedValue;
                }
            }
        }
        ComposerKt.composeRuntimeError("Unexpected form of a provided value");
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public final androidx.compose.runtime.SnapshotMutationPolicy<T> getMutationPolicy$runtime_release() {
        return this.mutationPolicy;
    }

    public final androidx.compose.runtime.MutableState<T> getState$runtime_release() {
        return this.state;
    }

    public final T getValue() {
        return this.providedValue;
    }

    public final androidx.compose.runtime.ProvidedValue<T> ifNotAlreadyProvided$runtime_release() {
        Object obj = this;
        final int i = 0;
        this.canOverride = false;
        return (ProvidedValue)this;
    }

    public final boolean isDynamic$runtime_release() {
        return this.isDynamic;
    }

    public final boolean isStatic$runtime_release() {
        int i;
        Object explicitNull;
        if (!this.explicitNull) {
            if (getValue() != null && !this.isDynamic) {
                i = !this.isDynamic ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }
}
