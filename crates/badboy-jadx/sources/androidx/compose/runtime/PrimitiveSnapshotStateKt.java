package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* loaded from: classes.dex */
@Metadata(d1 = "androidx/compose/runtime/PrimitiveSnapshotStateKt__SnapshotFloatStateKt", k = 4, mv = {1, 8, 0}, xi = 48)
public final class PrimitiveSnapshotStateKt {
    public static final float getValue(androidx.compose.runtime.FloatState $this$getValue, Object thisObj, KProperty<?> property) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.getValue($this$getValue, thisObj, property);
    }

    public static final androidx.compose.runtime.MutableFloatState mutableFloatStateOf(float value) {
        return PrimitiveSnapshotStateKt__SnapshotFloatStateKt.mutableFloatStateOf(value);
    }

    public static final void setValue(androidx.compose.runtime.MutableFloatState $this$setValue, Object thisObj, KProperty<?> property, float value) {
        PrimitiveSnapshotStateKt__SnapshotFloatStateKt.setValue($this$setValue, thisObj, property, value);
    }
}
