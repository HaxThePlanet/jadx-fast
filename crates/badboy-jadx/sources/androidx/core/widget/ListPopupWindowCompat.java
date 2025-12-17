package androidx.core.widget;

import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListPopupWindow;
import androidx.annotation.ReplaceWith;

/* loaded from: classes5.dex */
public final class ListPopupWindowCompat {
    @ReplaceWith(expression = "listPopupWindow.createDragToOpenListener(src)")
    @Deprecated
    public static View.OnTouchListener createDragToOpenListener(ListPopupWindow listPopupWindow, View src) {
        return listPopupWindow.createDragToOpenListener(src);
    }

    @Deprecated
    public static View.OnTouchListener createDragToOpenListener(Object listPopupWindow, View src) {
        return ListPopupWindowCompat.createDragToOpenListener((ListPopupWindow)listPopupWindow, src);
    }
}
