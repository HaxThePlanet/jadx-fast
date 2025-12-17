package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.reflect.KProperty;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u001c\n\u0000\u001a\u0014\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002H\u0007\u001a-\u0010\u0000\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u0012\u0010\u0003\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002H\u00020\u0004\"\u0002H\u0002H\u0007¢\u0006\u0002\u0010\u0005\u001a \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u0002H\t0\u0007\"\u0004\u0008\u0000\u0010\u0008\"\u0004\u0008\u0001\u0010\tH\u0007\u001aQ\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u0002H\t0\u0007\"\u0004\u0008\u0000\u0010\u0008\"\u0004\u0008\u0001\u0010\t2*\u0010\n\u001a\u0016\u0012\u0012\u0008\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u0002H\t0\u000b0\u0004\"\u000e\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u0002H\t0\u000bH\u0007¢\u0006\u0002\u0010\u000c\u001a1\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u000e\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u000f\u001a\u0002H\u00022\u000e\u0008\u0002\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a!\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0014\"\u0004\u0008\u0000\u0010\u00022\u0006\u0010\u0015\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\u0016\u001a4\u0010\u0017\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u00142\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\u0008\u00030\u001bH\u0086\n¢\u0006\u0002\u0010\u001c\u001a<\u0010\u001d\u001a\u00020\u001e\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020\u000e2\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\u0008\u00030\u001b2\u0006\u0010\u000f\u001a\u0002H\u0002H\u0086\n¢\u0006\u0002\u0010\u001f\u001a\u001c\u0010 \u001a\u0008\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\u0008\u0000\u0010\u0002*\u0008\u0012\u0004\u0012\u0002H\u00020!\u001a4\u0010\"\u001a\u000e\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u0002H\t0\u0007\"\u0004\u0008\u0000\u0010\u0008\"\u0004\u0008\u0001\u0010\t*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u0002H\t0\u000b0#¨\u0006$", d2 = {"mutableStateListOf", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "T", "elements", "", "([Ljava/lang/Object;)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "mutableStateMapOf", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "K", "V", "pairs", "Lkotlin/Pair;", "([Lkotlin/Pair;)Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "mutableStateOf", "Landroidx/compose/runtime/MutableState;", "value", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)Landroidx/compose/runtime/MutableState;", "rememberUpdatedState", "Landroidx/compose/runtime/State;", "newValue", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "getValue", "thisObj", "", "property", "Lkotlin/reflect/KProperty;", "(Landroidx/compose/runtime/State;Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "(Landroidx/compose/runtime/MutableState;Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toMutableStateList", "", "toMutableStateMap", "", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
final class SnapshotStateKt__SnapshotStateKt {
    public static final <T> T getValue(androidx.compose.runtime.State<? extends T> $this$getValue, Object thisObj, KProperty<?> property) {
        final int i = 0;
        return $this$getValue.getValue();
    }

    public static final <T> SnapshotStateList<T> mutableStateListOf() {
        SnapshotStateList snapshotStateList = new SnapshotStateList();
        return snapshotStateList;
    }

    public static final <T> SnapshotStateList<T> mutableStateListOf(T... elements) {
        SnapshotStateList snapshotStateList = new SnapshotStateList();
        final int i = 0;
        snapshotStateList.addAll((Collection)ArraysKt.toList(elements));
        return snapshotStateList;
    }

    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf() {
        SnapshotStateMap snapshotStateMap = new SnapshotStateMap();
        return snapshotStateMap;
    }

    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf(Pair<? extends K, ? extends V>... pairs) {
        SnapshotStateMap snapshotStateMap = new SnapshotStateMap();
        final int i = 0;
        snapshotStateMap.putAll(MapsKt.toMap(pairs));
        return snapshotStateMap;
    }

    public static final <T> androidx.compose.runtime.MutableState<T> mutableStateOf(T value, androidx.compose.runtime.SnapshotMutationPolicy<T> policy) {
        return (MutableState)ActualAndroid_androidKt.createSnapshotMutableState(value, policy);
    }

    public static androidx.compose.runtime.MutableState mutableStateOf$default(Object object, androidx.compose.runtime.SnapshotMutationPolicy snapshotMutationPolicy2, int i3, Object object4) {
        androidx.compose.runtime.SnapshotMutationPolicy obj1;
        if (i3 &= 2 != 0) {
            obj1 = SnapshotStateKt.structuralEqualityPolicy();
        }
        return SnapshotStateKt.mutableStateOf(object, obj1);
    }

    public static final <T> androidx.compose.runtime.State<T> rememberUpdatedState(T newValue, androidx.compose.runtime.Composer $composer, int $changed) {
        boolean traceInProgress;
        String str;
        Object $i$a$CacheSnapshotStateKt__SnapshotStateKt$rememberUpdatedState$1;
        int i;
        int i2;
        int i3 = -1058319986;
        ComposerKt.sourceInformationMarkerStart($composer, i3, "C(rememberUpdatedState)*309@10408L41:SnapshotState.kt#9igjgp");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(i3, $changed, -1, "androidx.compose.runtime.rememberUpdatedState (SnapshotState.kt:309)");
        }
        ComposerKt.sourceInformationMarkerStart($composer, 141205635, "CC(remember):SnapshotState.kt#9igjgp");
        int i5 = 0;
        androidx.compose.runtime.Composer composer = $composer;
        int i7 = 0;
        final Object rememberedValue = composer.rememberedValue();
        final int i8 = 0;
        if (rememberedValue == Composer.Companion.getEmpty()) {
            int i9 = 0;
            i2 = 0;
            composer.updateRememberedValue(SnapshotStateKt.mutableStateOf$default(newValue, i2, 2, i2));
        } else {
            $i$a$CacheSnapshotStateKt__SnapshotStateKt$rememberUpdatedState$1 = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        int i6 = 0;
        (MutableState)$i$a$CacheSnapshotStateKt__SnapshotStateKt$rememberUpdatedState$1.setValue(newValue);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return (State)$i$a$CacheSnapshotStateKt__SnapshotStateKt$rememberUpdatedState$1;
    }

    public static final <T> void setValue(androidx.compose.runtime.MutableState<T> $this$setValue, Object thisObj, KProperty<?> property, T value) {
        final int i = 0;
        $this$setValue.setValue(value);
    }

    public static final <T> SnapshotStateList<T> toMutableStateList(Collection<? extends T> $this$toMutableStateList) {
        SnapshotStateList snapshotStateList = new SnapshotStateList();
        final int i = 0;
        snapshotStateList.addAll($this$toMutableStateList);
        return snapshotStateList;
    }

    public static final <K, V> SnapshotStateMap<K, V> toMutableStateMap(Iterable<? extends Pair<? extends K, ? extends V>> $this$toMutableStateMap) {
        SnapshotStateMap snapshotStateMap = new SnapshotStateMap();
        final int i = 0;
        snapshotStateMap.putAll(MapsKt.toMap($this$toMutableStateMap));
        return snapshotStateMap;
    }
}
