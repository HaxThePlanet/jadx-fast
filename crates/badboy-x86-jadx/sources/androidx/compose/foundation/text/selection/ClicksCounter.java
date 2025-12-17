package androidx.compose.foundation.text.selection;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.platform.ViewConfiguration;
import java.util.List;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0013\u001a\u00020\u000cJ\u0016\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\u0013\u001a\u00020\u000cJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019", d2 = {"Landroidx/compose/foundation/text/selection/ClicksCounter;", "", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "clicks", "", "getClicks", "()I", "setClicks", "(I)V", "prevClick", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "getPrevClick", "()Landroidx/compose/ui/input/pointer/PointerInputChange;", "setPrevClick", "(Landroidx/compose/ui/input/pointer/PointerInputChange;)V", "positionIsTolerable", "", "newClick", "timeIsTolerable", "update", "", "event", "Landroidx/compose/ui/input/pointer/PointerEvent;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class ClicksCounter {

    private int clicks;
    private PointerInputChange prevClick;
    private final ViewConfiguration viewConfiguration;
    public ClicksCounter(ViewConfiguration viewConfiguration) {
        super();
        this.viewConfiguration = viewConfiguration;
    }

    public final int getClicks() {
        return this.clicks;
    }

    public final PointerInputChange getPrevClick() {
        return this.prevClick;
    }

    public final boolean positionIsTolerable(PointerInputChange prevClick, PointerInputChange newClick) {
        return SelectionGesturesKt.access$distanceIsTolerable(this.viewConfiguration, prevClick, newClick);
    }

    public final void setClicks(int <set-?>) {
        this.clicks = <set-?>;
    }

    public final void setPrevClick(PointerInputChange <set-?>) {
        this.prevClick = <set-?>;
    }

    public final boolean timeIsTolerable(PointerInputChange prevClick, PointerInputChange newClick) {
        int i;
        i = Long.compare(i2, doubleTapTimeoutMillis) < 0 ? 1 : 0;
        return i;
    }

    public final void update(PointerEvent event) {
        int positionIsTolerable;
        final PointerInputChange prevClick = this.prevClick;
        Object obj = event.getChanges().get(0);
        int i2 = 1;
        if (prevClick != null && timeIsTolerable(prevClick, (PointerInputChange)obj) && positionIsTolerable(prevClick, obj)) {
            if (timeIsTolerable(prevClick, obj)) {
                if (positionIsTolerable(prevClick, obj)) {
                    this.clicks = clicks += i2;
                } else {
                    this.clicks = i2;
                }
            } else {
            }
        } else {
        }
        this.prevClick = obj;
    }
}
