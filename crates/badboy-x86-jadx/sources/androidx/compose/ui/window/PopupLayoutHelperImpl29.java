package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0008H\u0016¨\u0006\n", d2 = {"Landroidx/compose/ui/window/PopupLayoutHelperImpl29;", "Landroidx/compose/ui/window/PopupLayoutHelperImpl;", "()V", "setGestureExclusionRects", "", "composeView", "Landroid/view/View;", "width", "", "height", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class PopupLayoutHelperImpl29 extends androidx.compose.ui.window.PopupLayoutHelperImpl {
    @Override // androidx.compose.ui.window.PopupLayoutHelperImpl
    public void setGestureExclusionRects(View composeView, int width, int height) {
        Rect[] arr = new Rect[1];
        final int i2 = 0;
        Rect rect = new Rect(i2, i2, width, height);
        arr[i2] = rect;
        composeView.setSystemGestureExclusionRects(CollectionsKt.mutableListOf(arr));
    }
}
