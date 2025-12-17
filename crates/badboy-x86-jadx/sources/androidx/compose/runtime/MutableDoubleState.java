package androidx.compose.runtime;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0008\n\u0008g\u0018\u00002\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u0002R\u0018\u0010\u0004\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R$\u0010\t\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038W@WX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\u0008ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\rÀ\u0006\u0003", d2 = {"Landroidx/compose/runtime/MutableDoubleState;", "Landroidx/compose/runtime/DoubleState;", "Landroidx/compose/runtime/MutableState;", "", "doubleValue", "getDoubleValue", "()D", "setDoubleValue", "(D)V", "value", "getValue", "()Ljava/lang/Double;", "setValue", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MutableDoubleState extends androidx.compose.runtime.DoubleState, androidx.compose.runtime.MutableState<Double> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Double getValue(androidx.compose.runtime.MutableDoubleState $this) {
            return Double.valueOf(MutableDoubleState.access$getValue$jd($this));
        }

        @Deprecated
        public static void setValue(androidx.compose.runtime.MutableDoubleState $this, double value) {
            MutableDoubleState.access$setValue$jd($this, value);
        }
    }
    public static double access$getValue$jd(androidx.compose.runtime.MutableDoubleState $this) {
        return super.getValue().doubleValue();
    }

    public static void access$setValue$jd(androidx.compose.runtime.MutableDoubleState $this, double value) {
        super.setValue(value);
    }

    @Override // androidx.compose.runtime.DoubleState
    public abstract double getDoubleValue();

    @Override // androidx.compose.runtime.DoubleState
    public Double getValue() {
        return Double.valueOf(getDoubleValue());
    }

    @Override // androidx.compose.runtime.DoubleState
    public Object getValue() {
        return getValue();
    }

    @Override // androidx.compose.runtime.DoubleState
    public abstract void setDoubleValue(double d);

    @Override // androidx.compose.runtime.DoubleState
    public void setValue(double value) {
        setDoubleValue(value);
    }

    @Override // androidx.compose.runtime.DoubleState
    public void setValue(Object <set-?>) {
        setValue((Number)<set-?>.doubleValue());
    }
}
