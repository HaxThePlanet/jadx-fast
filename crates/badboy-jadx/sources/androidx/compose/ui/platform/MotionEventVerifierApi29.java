package androidx.compose.ui.platform;

import android.view.MotionEvent;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008Ã\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0007¨\u0006\t", d2 = {"Landroidx/compose/ui/platform/MotionEventVerifierApi29;", "", "()V", "isValidMotionEvent", "", "event", "Landroid/view/MotionEvent;", "index", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class MotionEventVerifierApi29 {

    public static final androidx.compose.ui.platform.MotionEventVerifierApi29 INSTANCE;
    static {
        MotionEventVerifierApi29 motionEventVerifierApi29 = new MotionEventVerifierApi29();
        MotionEventVerifierApi29.INSTANCE = motionEventVerifierApi29;
    }

    public final boolean isValidMotionEvent(MotionEvent event, int index) {
        float rawX;
        int i;
        float rawY;
        boolean infinite;
        int i2;
        rawX = event.getRawX(index);
        i2 = 1;
        final int i3 = 0;
        if (!Float.isInfinite(rawX) && !Float.isNaN(rawX)) {
            i = !Float.isNaN(rawX) ? i2 : i3;
        } else {
        }
        if (i != 0) {
            rawY = event.getRawY(index);
            if (!Float.isInfinite(rawY) && !Float.isNaN(rawY)) {
                i = !Float.isNaN(rawY) ? i2 : i3;
            } else {
            }
            if (i != 0) {
            } else {
                i2 = i3;
            }
        } else {
        }
        return i2;
    }
}
