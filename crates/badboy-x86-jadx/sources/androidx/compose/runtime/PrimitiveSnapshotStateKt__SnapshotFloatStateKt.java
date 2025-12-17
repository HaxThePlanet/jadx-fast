package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a#\u0010\u0004\u001a\u00020\u0003*\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\u0008\u001a\u0006\u0012\u0002\u0008\u00030\tH\u0086\n\u001a+\u0010\n\u001a\u00020\u000b*\u00020\u00012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\u0008\u001a\u0006\u0012\u0002\u0008\u00030\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n¨\u0006\u000c", d2 = {"mutableFloatStateOf", "Landroidx/compose/runtime/MutableFloatState;", "value", "", "getValue", "Landroidx/compose/runtime/FloatState;", "thisObj", "", "property", "Lkotlin/reflect/KProperty;", "setValue", "", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/PrimitiveSnapshotStateKt")
final class PrimitiveSnapshotStateKt__SnapshotFloatStateKt {
    public static final float getValue(androidx.compose.runtime.FloatState $this$getValue, Object thisObj, KProperty<?> property) {
        final int i = 0;
        return $this$getValue.getFloatValue();
    }

    public static final androidx.compose.runtime.MutableFloatState mutableFloatStateOf(float value) {
        return ActualAndroid_androidKt.createSnapshotMutableFloatState(value);
    }

    public static final void setValue(androidx.compose.runtime.MutableFloatState $this$setValue, Object thisObj, KProperty<?> property, float value) {
        final int i = 0;
        $this$setValue.setFloatValue(value);
    }
}
