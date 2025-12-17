package androidx.compose.ui.graphics;

import android.graphics.Path;
import android.graphics.Path.Direction;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a\r\u0010\u0006\u001a\u00020\u0007*\u00020\u0001H\u0086\u0008\u001a\n\u0010\u0008\u001a\u00020\u0001*\u00020\u0007\u001a\u000c\u0010\t\u001a\u00020\n*\u00020\u000bH\u0002¨\u0006\u000c", d2 = {"Path", "Landroidx/compose/ui/graphics/Path;", "throwIllegalStateException", "", "message", "", "asAndroidPath", "Landroid/graphics/Path;", "asComposePath", "toPlatformPathDirection", "Landroid/graphics/Path$Direction;", "Landroidx/compose/ui/graphics/Path$Direction;", "ui-graphics_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidPath_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[Path.Direction.CounterClockwise.ordinal()] = 1;
            iArr[Path.Direction.Clockwise.ordinal()] = 2;
            AndroidPath_androidKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final androidx.compose.ui.graphics.Path Path() {
        final int i = 0;
        AndroidPath androidPath = new AndroidPath(i, 1, i);
        return (Path)androidPath;
    }

    public static final Path.Direction access$toPlatformPathDirection(androidx.compose.ui.graphics.Path.Direction $receiver) {
        return AndroidPath_androidKt.toPlatformPathDirection($receiver);
    }

    public static final Path asAndroidPath(androidx.compose.ui.graphics.Path $this$asAndroidPath) {
        final int i = 0;
        if ($this$asAndroidPath instanceof AndroidPath == null) {
        } else {
            return (AndroidPath)$this$asAndroidPath.getInternalPath();
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
        throw unsupportedOperationException;
    }

    public static final androidx.compose.ui.graphics.Path asComposePath(Path $this$asComposePath) {
        AndroidPath androidPath = new AndroidPath($this$asComposePath);
        return (Path)androidPath;
    }

    public static final void throwIllegalStateException(String message) {
        IllegalStateException illegalStateException = new IllegalStateException(message);
        throw illegalStateException;
    }

    private static final Path.Direction toPlatformPathDirection(androidx.compose.ui.graphics.Path.Direction $this$toPlatformPathDirection) {
        Path.Direction cCW;
        switch (i) {
            case 1:
                cCW = Path.Direction.CCW;
                break;
            case 2:
                cCW = Path.Direction.CW;
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return cCW;
    }
}
