package androidx.compose.ui.graphics;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0008\u0008\u0003\u0010\u0005\u001a\u00020\u0006\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"EmptyPath", "Landroidx/compose/ui/graphics/Path;", "PathHitTester", "Landroidx/compose/ui/graphics/PathHitTester;", "path", "tolerance", "", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PathHitTesterKt {

    private static final androidx.compose.ui.graphics.Path EmptyPath;
    static {
        PathHitTesterKt.EmptyPath = AndroidPath_androidKt.Path();
    }

    public static final androidx.compose.ui.graphics.PathHitTester PathHitTester(androidx.compose.ui.graphics.Path path, float tolerance) {
        PathHitTester pathHitTester = new PathHitTester();
        final int i = 0;
        pathHitTester.updatePath(path, tolerance);
        return pathHitTester;
    }

    public static androidx.compose.ui.graphics.PathHitTester PathHitTester$default(androidx.compose.ui.graphics.Path path, float f2, int i3, Object object4) {
        int obj1;
        if (i3 &= 2 != 0) {
            obj1 = 1056964608;
        }
        return PathHitTesterKt.PathHitTester(path, obj1);
    }

    public static final androidx.compose.ui.graphics.Path access$getEmptyPath$p() {
        return PathHitTesterKt.EmptyPath;
    }
}
