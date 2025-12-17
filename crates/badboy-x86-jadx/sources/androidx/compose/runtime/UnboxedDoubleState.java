package androidx.compose.runtime;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0008\u0008\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0008\u0010\u000c\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\t\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000e", d2 = {"Landroidx/compose/runtime/UnboxedDoubleState;", "Landroidx/compose/runtime/DoubleState;", "baseState", "Landroidx/compose/runtime/State;", "", "(Landroidx/compose/runtime/State;)V", "doubleValue", "getDoubleValue", "()D", "value", "getValue", "()Ljava/lang/Double;", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class UnboxedDoubleState implements androidx.compose.runtime.DoubleState {

    public static final int $stable;
    private final androidx.compose.runtime.State<Double> baseState;
    static {
    }

    public UnboxedDoubleState(androidx.compose.runtime.State<Double> baseState) {
        super();
        this.baseState = baseState;
    }

    @Override // androidx.compose.runtime.DoubleState
    public double getDoubleValue() {
        return (Number)this.baseState.getValue().doubleValue();
    }

    @Override // androidx.compose.runtime.DoubleState
    public Double getValue() {
        return (Double)this.baseState.getValue();
    }

    @Override // androidx.compose.runtime.DoubleState
    public Object getValue() {
        return getValue();
    }

    @Override // androidx.compose.runtime.DoubleState
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("UnboxedDoubleState(baseState=").append(this.baseState).append(")@").append(hashCode()).toString();
    }
}
