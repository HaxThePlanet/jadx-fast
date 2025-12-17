package androidx.compose.ui.viewinterop;

import android.view.View;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource.Companion;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000/\n\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0002*\u0001\u0001\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0008\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0002\u001a\u000c\u0010\u000e\u001a\u00020\u000f*\u00020\u0004H\u0002\u001a\u000c\u0010\u0010\u001a\u00020\u000f*\u00020\u000fH\u0002\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"NoOpScrollConnection", "androidx/compose/ui/viewinterop/AndroidViewHolder_androidKt$NoOpScrollConnection$1", "Landroidx/compose/ui/viewinterop/AndroidViewHolder_androidKt$NoOpScrollConnection$1;", "Unmeasured", "", "toNestedScrollSource", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "type", "(I)I", "layoutAccordingTo", "", "Landroid/view/View;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "toComposeOffset", "", "toComposeVelocity", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AndroidViewHolder_androidKt {

    private static final androidx.compose.ui.viewinterop.AndroidViewHolder_androidKt.NoOpScrollConnection.1 NoOpScrollConnection = null;
    private static final int Unmeasured = Integer.MIN_VALUE;
    static {
        AndroidViewHolder_androidKt.NoOpScrollConnection.1 anon = new AndroidViewHolder_androidKt.NoOpScrollConnection.1();
        AndroidViewHolder_androidKt.NoOpScrollConnection = anon;
    }

    public static final androidx.compose.ui.viewinterop.AndroidViewHolder_androidKt.NoOpScrollConnection.1 access$getNoOpScrollConnection$p() {
        return AndroidViewHolder_androidKt.NoOpScrollConnection;
    }

    public static final void access$layoutAccordingTo(View $receiver, LayoutNode layoutNode) {
        AndroidViewHolder_androidKt.layoutAccordingTo($receiver, layoutNode);
    }

    public static final float access$toComposeOffset(int $receiver) {
        return AndroidViewHolder_androidKt.toComposeOffset($receiver);
    }

    public static final float access$toComposeVelocity(float $receiver) {
        return AndroidViewHolder_androidKt.toComposeVelocity($receiver);
    }

    public static final int access$toNestedScrollSource(int type) {
        return AndroidViewHolder_androidKt.toNestedScrollSource(type);
    }

    private static final void layoutAccordingTo(View $this$layoutAccordingTo, LayoutNode layoutNode) {
        long positionInRoot = LayoutCoordinatesKt.positionInRoot(layoutNode.getCoordinates());
        int i = 0;
        int $this$fastRoundToInt$iv = Math.round(Offset.getX-impl(positionInRoot));
        int i2 = 0;
        int $this$fastRoundToInt$iv2 = Math.round(Offset.getY-impl(positionInRoot));
        $this$layoutAccordingTo.layout($this$fastRoundToInt$iv, $this$fastRoundToInt$iv2, measuredWidth += $this$fastRoundToInt$iv, measuredHeight += $this$fastRoundToInt$iv2);
    }

    private static final float toComposeOffset(int $this$toComposeOffset) {
        return f *= f2;
    }

    private static final float toComposeVelocity(float $this$toComposeVelocity) {
        return i *= $this$toComposeVelocity;
    }

    private static final int toNestedScrollSource(int type) {
        int sideEffect-WNlRxjI;
        if (type == null) {
            sideEffect-WNlRxjI = NestedScrollSource.Companion.getUserInput-WNlRxjI();
        } else {
            sideEffect-WNlRxjI = NestedScrollSource.Companion.getSideEffect-WNlRxjI();
        }
        return sideEffect-WNlRxjI;
    }
}
