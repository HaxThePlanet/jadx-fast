package androidx.compose.ui.modifier;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.MapsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u00002\u00020\u0001BW\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003\u00126\u0010\u0006\u001a\u001c\u0012\u0018\u0008\u0001\u0012\u0014\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00030\u0007\"\u0014\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0002\u0010\u0008J\u001a\u0010\u000b\u001a\u00020\u000c2\n\u0010\r\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0090\u0002¢\u0006\u0002\u0008\u000eJ&\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0004\u0008\u0000\u0010\u00102\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u0004H\u0090\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J,\u0010\u0013\u001a\u00020\u0014\"\u0004\u0008\u0000\u0010\u00102\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\u00100\u00042\u0006\u0010\u0015\u001a\u0002H\u0010H\u0090\u0002¢\u0006\u0004\u0008\u0016\u0010\u0017R \u0010\t\u001a\u0014\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"Landroidx/compose/ui/modifier/MultiLocalMap;", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "entry1", "Lkotlin/Pair;", "Landroidx/compose/ui/modifier/ModifierLocal;", "", "entries", "", "(Lkotlin/Pair;[Lkotlin/Pair;)V", "map", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "contains", "", "key", "contains$ui_release", "get", "T", "get$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "set", "", "value", "set$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocal;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MultiLocalMap extends androidx.compose.ui.modifier.ModifierLocalMap {

    public static final int $stable;
    private final SnapshotStateMap<androidx.compose.ui.modifier.ModifierLocal<?>, Object> map;
    static {
    }

    public MultiLocalMap(Pair<? extends androidx.compose.ui.modifier.ModifierLocal<?>, ? extends Object> entry1, Pair<? extends androidx.compose.ui.modifier.ModifierLocal<?>, ? extends Object>... entries) {
        super(0);
        this.map = SnapshotStateKt.mutableStateMapOf();
        (Map)this.map.put(entry1.getFirst(), entry1.getSecond());
        this.map.putAll(MapsKt.toMap(entries));
    }

    public boolean contains$ui_release(androidx.compose.ui.modifier.ModifierLocal<?> key) {
        return this.map.containsKey(key);
    }

    public <T> T get$ui_release(androidx.compose.ui.modifier.ModifierLocal<T> key) {
        Object obj;
        if (this.map.get(key) == null) {
            obj = 0;
        }
        return obj;
    }

    public <T> void set$ui_release(androidx.compose.ui.modifier.ModifierLocal<T> key, T value) {
        (Map)this.map.put(key, value);
    }
}
