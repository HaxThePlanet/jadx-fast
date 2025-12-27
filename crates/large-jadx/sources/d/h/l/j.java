package d.h.l;

import android.view.MotionEvent;

/* compiled from: MotionEventCompat.java */
/* loaded from: classes.dex */
public final class j {
    public static boolean a(MotionEvent motionEvent, int i) {
        boolean z = true;
        motionEvent = (motionEvent.getSource() & i) == i ? 1 : 0;
        return ((motionEvent.getSource() & i) == i ? 1 : 0);
    }
}
