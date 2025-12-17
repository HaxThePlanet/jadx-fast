package androidx.compose.runtime;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\u00030\u0002H\u0007\u001a\u0012\u0010\u0004\u001a\u00020\u0005*\u0008\u0012\u0004\u0012\u00020\u00060\u0002H\u0007\u001a\u0012\u0010\u0007\u001a\u00020\u0008*\u0008\u0012\u0004\u0012\u00020\t0\u0002H\u0007\u001a\u0012\u0010\n\u001a\u00020\u000b*\u0008\u0012\u0004\u0012\u00020\u000c0\u0002H\u0007¨\u0006\r", d2 = {"asDoubleState", "Landroidx/compose/runtime/DoubleState;", "Landroidx/compose/runtime/State;", "", "asFloatState", "Landroidx/compose/runtime/FloatState;", "", "asIntState", "Landroidx/compose/runtime/IntState;", "", "asLongState", "Landroidx/compose/runtime/LongState;", "", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SnapshotStateExtensionsKt {
    public static final androidx.compose.runtime.DoubleState asDoubleState(androidx.compose.runtime.State<Double> $this$asDoubleState) {
        Object unboxedDoubleState;
        if ($this$asDoubleState instanceof DoubleState) {
            unboxedDoubleState = $this$asDoubleState;
        } else {
            unboxedDoubleState = new UnboxedDoubleState($this$asDoubleState);
        }
        return unboxedDoubleState;
    }

    public static final androidx.compose.runtime.FloatState asFloatState(androidx.compose.runtime.State<Float> $this$asFloatState) {
        Object unboxedFloatState;
        if ($this$asFloatState instanceof FloatState) {
            unboxedFloatState = $this$asFloatState;
        } else {
            unboxedFloatState = new UnboxedFloatState($this$asFloatState);
        }
        return unboxedFloatState;
    }

    public static final androidx.compose.runtime.IntState asIntState(androidx.compose.runtime.State<Integer> $this$asIntState) {
        Object unboxedIntState;
        if ($this$asIntState instanceof IntState) {
            unboxedIntState = $this$asIntState;
        } else {
            unboxedIntState = new UnboxedIntState($this$asIntState);
        }
        return unboxedIntState;
    }

    public static final androidx.compose.runtime.LongState asLongState(androidx.compose.runtime.State<Long> $this$asLongState) {
        Object unboxedLongState;
        if ($this$asLongState instanceof LongState) {
            unboxedLongState = $this$asLongState;
        } else {
            unboxedLongState = new UnboxedLongState($this$asLongState);
        }
        return unboxedLongState;
    }
}
