package androidx.compose.runtime;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\u0008g\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001R\u0012\u0010\u0003\u001a\u00020\u0002X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00028WX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\tÀ\u0006\u0003", d2 = {"Landroidx/compose/runtime/IntState;", "Landroidx/compose/runtime/State;", "", "intValue", "getIntValue", "()I", "value", "getValue", "()Ljava/lang/Integer;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IntState extends androidx.compose.runtime.State<Integer> {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static Integer getValue(androidx.compose.runtime.IntState $this) {
            return Integer.valueOf(IntState.access$getValue$jd($this));
        }
    }
    public static int access$getValue$jd(androidx.compose.runtime.IntState $this) {
        return super.getValue().intValue();
    }

    @Override // androidx.compose.runtime.State
    public abstract int getIntValue();

    @Override // androidx.compose.runtime.State
    public Integer getValue() {
        return Integer.valueOf(getIntValue());
    }

    @Override // androidx.compose.runtime.State
    public Object getValue() {
        return getValue();
    }
}
