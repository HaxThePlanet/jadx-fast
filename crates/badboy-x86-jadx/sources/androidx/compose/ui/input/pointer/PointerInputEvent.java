package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f¨\u0006\u0010", d2 = {"Landroidx/compose/ui/input/pointer/PointerInputEvent;", "", "uptime", "", "pointers", "", "Landroidx/compose/ui/input/pointer/PointerInputEventData;", "motionEvent", "Landroid/view/MotionEvent;", "(JLjava/util/List;Landroid/view/MotionEvent;)V", "getMotionEvent", "()Landroid/view/MotionEvent;", "getPointers", "()Ljava/util/List;", "getUptime", "()J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PointerInputEvent {

    public static final int $stable = 8;
    private final MotionEvent motionEvent;
    private final List<androidx.compose.ui.input.pointer.PointerInputEventData> pointers;
    private final long uptime;
    static {
        final int i = 8;
    }

    public PointerInputEvent(long uptime, List<androidx.compose.ui.input.pointer.PointerInputEventData> pointers, MotionEvent motionEvent) {
        super();
        this.uptime = uptime;
        this.pointers = motionEvent;
        this.motionEvent = obj4;
    }

    public final MotionEvent getMotionEvent() {
        return this.motionEvent;
    }

    public final List<androidx.compose.ui.input.pointer.PointerInputEventData> getPointers() {
        return this.pointers;
    }

    public final long getUptime() {
        return this.uptime;
    }
}
