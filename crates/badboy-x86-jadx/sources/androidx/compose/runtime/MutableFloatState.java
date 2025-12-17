package androidx.compose.runtime;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0008\n\u0008g\u0018\u00002\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u0002R\u0018\u0010\u0004\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R$\u0010\t\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038W@WX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\u0008ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\rÀ\u0006\u0003", d2 = {"Landroidx/compose/runtime/MutableFloatState;", "Landroidx/compose/runtime/FloatState;", "Landroidx/compose/runtime/MutableState;", "", "floatValue", "getFloatValue", "()F", "setFloatValue", "(F)V", "value", "getValue", "()Ljava/lang/Float;", "setValue", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MutableFloatState extends androidx.compose.runtime.FloatState, androidx.compose.runtime.MutableState<Float> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Float getValue(androidx.compose.runtime.MutableFloatState $this) {
            return Float.valueOf(MutableFloatState.access$getValue$jd($this));
        }

        @Deprecated
        public static void setValue(androidx.compose.runtime.MutableFloatState $this, float value) {
            MutableFloatState.access$setValue$jd($this, value);
        }
    }
    public static float access$getValue$jd(androidx.compose.runtime.MutableFloatState $this) {
        return super.getValue().floatValue();
    }

    public static void access$setValue$jd(androidx.compose.runtime.MutableFloatState $this, float value) {
        super.setValue(value);
    }

    @Override // androidx.compose.runtime.FloatState
    public abstract float getFloatValue();

    @Override // androidx.compose.runtime.FloatState
    public Float getValue() {
        return Float.valueOf(getFloatValue());
    }

    @Override // androidx.compose.runtime.FloatState
    public Object getValue() {
        return getValue();
    }

    @Override // androidx.compose.runtime.FloatState
    public abstract void setFloatValue(float f);

    @Override // androidx.compose.runtime.FloatState
    public void setValue(float value) {
        setFloatValue(value);
    }

    @Override // androidx.compose.runtime.FloatState
    public void setValue(Object <set-?>) {
        setValue((Number)<set-?>.floatValue());
    }
}
