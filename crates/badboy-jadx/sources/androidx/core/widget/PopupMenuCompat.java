package androidx.core.widget;

import android.view.View.OnTouchListener;
import android.widget.PopupMenu;

/* loaded from: classes5.dex */
public final class PopupMenuCompat {
    public static View.OnTouchListener getDragToOpenListener(Object popupMenu) {
        return (PopupMenu)popupMenu.getDragToOpenListener();
    }
}
