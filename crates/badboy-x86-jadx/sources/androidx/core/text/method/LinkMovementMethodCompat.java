package androidx.core.text.method;

import android.os.Build.VERSION;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.Touch;
import android.view.MotionEvent;
import android.widget.TextView;

/* loaded from: classes5.dex */
public class LinkMovementMethodCompat extends LinkMovementMethod {

    private static androidx.core.text.method.LinkMovementMethodCompat sInstance;
    public static androidx.core.text.method.LinkMovementMethodCompat getInstance() {
        androidx.core.text.method.LinkMovementMethodCompat linkMovementMethodCompat;
        if (LinkMovementMethodCompat.sInstance == null) {
            linkMovementMethodCompat = new LinkMovementMethodCompat();
            LinkMovementMethodCompat.sInstance = linkMovementMethodCompat;
        }
        return LinkMovementMethodCompat.sInstance;
    }

    @Override // android.text.method.LinkMovementMethod
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        int sDK_INT;
        int isOutOfLineBounds;
        int x;
        int y;
        Layout layout;
        int lineForVertical;
        int cmp;
        float lineRight;
        if (Build.VERSION.SDK_INT < 35) {
            sDK_INT = event.getAction();
            if (sDK_INT != 1) {
                if (sDK_INT == 0) {
                    x2 += scrollX;
                    y2 += scrollY;
                    layout = widget.getLayout();
                    if (y >= 0) {
                        if (y > layout.getHeight()) {
                            isOutOfLineBounds = 1;
                        } else {
                            lineForVertical = layout.getLineForVertical(y);
                            if (Float.compare(f3, lineRight) >= 0) {
                                if (Float.compare(f4, lineRight) > 0) {
                                } else {
                                    isOutOfLineBounds = 0;
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                    if (isOutOfLineBounds != 0) {
                        Selection.removeSelection(buffer);
                        return Touch.onTouchEvent(widget, buffer, event);
                    }
                }
            } else {
            }
        }
        return super.onTouchEvent(widget, buffer, event);
    }
}
