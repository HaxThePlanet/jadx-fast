package androidx.compose.ui.graphics;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002", d2 = {"copy", "Landroidx/compose/ui/graphics/Path;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PathKt {
    public static final androidx.compose.ui.graphics.Path copy(androidx.compose.ui.graphics.Path $this$copy) {
        final androidx.compose.ui.graphics.Path path = AndroidPath_androidKt.Path();
        final int i4 = 0;
        Path.addPath-Uv8p0NA$default(path, $this$copy, 0, obj4, 2);
        return path;
    }
}
