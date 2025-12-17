package androidx.compose.material;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\n*\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0006H\u0086\u0004¢\u0006\u0002\u0010\u000cR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\r", d2 = {"Landroidx/compose/material/DraggableAnchorsConfig;", "T", "", "()V", "anchors", "", "", "getAnchors$material_release", "()Ljava/util/Map;", "at", "", "position", "(Ljava/lang/Object;F)V", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DraggableAnchorsConfig<T>  {

    public static final int $stable = 8;
    private final Map<T, Float> anchors;
    static {
        final int i = 8;
    }

    public DraggableAnchorsConfig() {
        super();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.anchors = (Map)linkedHashMap;
    }

    public final void at(T $this$at, float position) {
        this.anchors.put($this$at, Float.valueOf(position));
    }

    public final Map<T, Float> getAnchors$material_release() {
        return this.anchors;
    }
}
