package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008a\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J \u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH&J \u0010\u000c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0012À\u0006\u0001", d2 = {"Landroidx/compose/ui/window/PopupLayoutHelper;", "", "getWindowVisibleDisplayFrame", "", "composeView", "Landroid/view/View;", "outRect", "Landroid/graphics/Rect;", "setGestureExclusionRects", "width", "", "height", "updateViewLayout", "windowManager", "Landroid/view/WindowManager;", "popupView", "params", "Landroid/view/ViewGroup$LayoutParams;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PopupLayoutHelper {
    public abstract void getWindowVisibleDisplayFrame(View view, Rect rect2);

    public abstract void setGestureExclusionRects(View view, int i2, int i3);

    public abstract void updateViewLayout(WindowManager windowManager, View view2, ViewGroup.LayoutParams viewGroup$LayoutParams3);
}
