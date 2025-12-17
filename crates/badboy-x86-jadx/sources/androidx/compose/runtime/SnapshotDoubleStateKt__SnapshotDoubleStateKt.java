package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a#\u0010\u0004\u001a\u00020\u0003*\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\u0008\u001a\u0006\u0012\u0002\u0008\u00030\tH\u0086\n\u001a+\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\u0008\u001a\u0006\u0012\u0002\u0008\u00030\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n¨\u0006\u000c", d2 = {"mutableDoubleStateOf", "Landroidx/compose/runtime/MutableDoubleState;", "value", "", "getValue", "Landroidx/compose/runtime/DoubleState;", "thisObj", "", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotDoubleStateKt")
final class SnapshotDoubleStateKt__SnapshotDoubleStateKt {
    public static final double getValue(androidx.compose.runtime.DoubleState $this$getValue, Object thisObj, KProperty<?> property) {
        final int i = 0;
        return $this$getValue.getDoubleValue();
    }

    public static final androidx.compose.runtime.MutableDoubleState mutableDoubleStateOf(double value) {
        return ActualAndroid_androidKt.createSnapshotMutableDoubleState(value);
    }

    public static final void setValue(androidx.compose.runtime.MutableDoubleState $this$setValue, Object thisObj, KProperty<?> property, double value) {
        final int i = 0;
        $this$setValue.setDoubleValue(value);
    }
}
