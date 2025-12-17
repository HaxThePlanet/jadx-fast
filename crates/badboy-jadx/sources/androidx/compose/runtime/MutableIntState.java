package androidx.compose.runtime;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\n\u0008g\u0018\u00002\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u0002R\u0018\u0010\u0004\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R$\u0010\t\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038W@WX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\n\u0010\u000b\"\u0004\u0008\u000c\u0010\u0008ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\rÀ\u0006\u0003", d2 = {"Landroidx/compose/runtime/MutableIntState;", "Landroidx/compose/runtime/IntState;", "Landroidx/compose/runtime/MutableState;", "", "intValue", "getIntValue", "()I", "setIntValue", "(I)V", "value", "getValue", "()Ljava/lang/Integer;", "setValue", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface MutableIntState extends androidx.compose.runtime.IntState, androidx.compose.runtime.MutableState<Integer> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Integer getValue(androidx.compose.runtime.MutableIntState $this) {
            return Integer.valueOf(MutableIntState.access$getValue$jd($this));
        }

        @Deprecated
        public static void setValue(androidx.compose.runtime.MutableIntState $this, int value) {
            MutableIntState.access$setValue$jd($this, value);
        }
    }
    public static int access$getValue$jd(androidx.compose.runtime.MutableIntState $this) {
        return super.getValue().intValue();
    }

    public static void access$setValue$jd(androidx.compose.runtime.MutableIntState $this, int value) {
        super.setValue(value);
    }

    @Override // androidx.compose.runtime.IntState
    public abstract int getIntValue();

    @Override // androidx.compose.runtime.IntState
    public Integer getValue() {
        return Integer.valueOf(getIntValue());
    }

    @Override // androidx.compose.runtime.IntState
    public Object getValue() {
        return getValue();
    }

    @Override // androidx.compose.runtime.IntState
    public abstract void setIntValue(int i);

    @Override // androidx.compose.runtime.IntState
    public void setValue(int value) {
        setIntValue(value);
    }

    @Override // androidx.compose.runtime.IntState
    public void setValue(Object <set-?>) {
        setValue((Number)<set-?>.intValue());
    }
}
