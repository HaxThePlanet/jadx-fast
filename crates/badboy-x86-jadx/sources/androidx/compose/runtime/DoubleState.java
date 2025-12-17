package androidx.compose.runtime;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0008\u0007\u0008g\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001R\u0012\u0010\u0003\u001a\u00020\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\tÀ\u0006\u0003", d2 = {"Landroidx/compose/runtime/DoubleState;", "Landroidx/compose/runtime/State;", "", "doubleValue", "getDoubleValue", "()D", "value", "getValue", "()Ljava/lang/Double;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DoubleState extends androidx.compose.runtime.State<Double> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Double getValue(androidx.compose.runtime.DoubleState $this) {
            return Double.valueOf(DoubleState.access$getValue$jd($this));
        }
    }
    public static double access$getValue$jd(androidx.compose.runtime.DoubleState $this) {
        return super.getValue().doubleValue();
    }

    @Override // androidx.compose.runtime.State
    public abstract double getDoubleValue();

    @Override // androidx.compose.runtime.State
    public Double getValue() {
        return Double.valueOf(getDoubleValue());
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        return getValue();
    }
}
