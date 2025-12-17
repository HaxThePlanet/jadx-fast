package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* loaded from: classes.dex */
@Metadata(d1 = "androidx/compose/runtime/SnapshotLongStateKt__SnapshotLongStateKt", k = 4, mv = {1, 8, 0}, xi = 48)
public final class SnapshotLongStateKt {
    public static final long getValue(androidx.compose.runtime.LongState $this$getValue, Object thisObj, KProperty<?> property) {
        return SnapshotLongStateKt__SnapshotLongStateKt.getValue($this$getValue, thisObj, property);
    }

    public static final androidx.compose.runtime.MutableLongState mutableLongStateOf(long value) {
        return SnapshotLongStateKt__SnapshotLongStateKt.mutableLongStateOf(value);
    }

    public static final void setValue(androidx.compose.runtime.MutableLongState $this$setValue, Object thisObj, KProperty<?> property, long value) {
        SnapshotLongStateKt__SnapshotLongStateKt.setValue($this$setValue, thisObj, property, value);
    }
}
