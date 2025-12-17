package androidx.compose.ui.res;

import android.content.res.Resources;
import android.util.TypedValue;
import androidx.collection.MutableIntObjectMap;
import kotlin.Metadata;
import kotlin.Unit;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u0008\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0008\u0008\u0001\u0010\u000b\u001a\u00020\u000cR\u0014\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r", d2 = {"Landroidx/compose/ui/res/ResourceIdCache;", "", "()V", "resIdPathMap", "Landroidx/collection/MutableIntObjectMap;", "Landroid/util/TypedValue;", "clear", "", "resolveResourcePath", "res", "Landroid/content/res/Resources;", "id", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ResourceIdCache {

    public static final int $stable = 8;
    private final MutableIntObjectMap<TypedValue> resIdPathMap;
    static {
        final int i = 8;
    }

    public ResourceIdCache() {
        super();
        MutableIntObjectMap mutableIntObjectMap = new MutableIntObjectMap(0, 1, 0);
        this.resIdPathMap = mutableIntObjectMap;
    }

    public final void clear() {
        int i = 0;
        this.resIdPathMap.clear();
        Unit $i$a$SynchronizedResourceIdCache$clear$1 = Unit.INSTANCE;
        return;
        synchronized (this) {
            i = 0;
            this.resIdPathMap.clear();
            $i$a$SynchronizedResourceIdCache$clear$1 = Unit.INSTANCE;
        }
    }

    public final TypedValue resolveResourcePath(Resources res, int id) {
        Object value;
        MutableIntObjectMap resIdPathMap;
        final int i = 0;
        synchronized (this) {
            TypedValue typedValue = new TypedValue();
            value = typedValue;
            res.getValue(id, value, true);
            this.resIdPathMap.put(id, value);
            try {
                return value;
                throw th;
            }
        }
    }
}
