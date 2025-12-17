package androidx.compose.material;

import androidx.compose.ui.graphics.AndroidPathMeasure_androidKt;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathMeasure;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0003\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\r", d2 = {"Landroidx/compose/material/CheckDrawingCache;", "", "checkPath", "Landroidx/compose/ui/graphics/Path;", "pathMeasure", "Landroidx/compose/ui/graphics/PathMeasure;", "pathToDraw", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/PathMeasure;Landroidx/compose/ui/graphics/Path;)V", "getCheckPath", "()Landroidx/compose/ui/graphics/Path;", "getPathMeasure", "()Landroidx/compose/ui/graphics/PathMeasure;", "getPathToDraw", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CheckDrawingCache {

    private final Path checkPath;
    private final PathMeasure pathMeasure;
    private final Path pathToDraw;
    public CheckDrawingCache() {
        super(0, 0, 0, 7, 0);
    }

    public CheckDrawingCache(Path checkPath, PathMeasure pathMeasure, Path pathToDraw) {
        super();
        this.checkPath = checkPath;
        this.pathMeasure = pathMeasure;
        this.pathToDraw = pathToDraw;
    }

    public CheckDrawingCache(Path path, PathMeasure pathMeasure2, Path path3, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
        Path obj1;
        PathMeasure obj2;
        Path obj3;
        if (i4 & 1 != 0) {
            obj1 = AndroidPath_androidKt.Path();
        }
        if (i4 & 2 != 0) {
            obj2 = AndroidPathMeasure_androidKt.PathMeasure();
        }
        if (i4 &= 4 != 0) {
            obj3 = AndroidPath_androidKt.Path();
        }
        super(obj1, obj2, obj3);
    }

    public final Path getCheckPath() {
        return this.checkPath;
    }

    public final PathMeasure getPathMeasure() {
        return this.pathMeasure;
    }

    public final Path getPathToDraw() {
        return this.pathToDraw;
    }
}
