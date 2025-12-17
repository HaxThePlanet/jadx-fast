package androidx.compose.ui.focus;

import kotlin.Deprecated;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Deprecated(message = "Use FocusProperties instead")
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u001a\u0008\u0007\u0018\u00002\u00020\u0001B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0002B\u000f\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0008\u0010\t\"\u0004\u0008\n\u0010\u000bR$\u0010\u000c\u001a\u00020\u00072\u0006\u0010\u000c\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\r\u0010\t\"\u0004\u0008\u000e\u0010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0010\u0010\t\"\u0004\u0008\u0011\u0010\u000bR$\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0013\u0010\t\"\u0004\u0008\u0014\u0010\u000bR$\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0016\u0010\t\"\u0004\u0008\u0017\u0010\u000bR$\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0019\u0010\t\"\u0004\u0008\u001a\u0010\u000bR$\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u001c\u0010\t\"\u0004\u0008\u001d\u0010\u000bR$\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u001f\u0010\t\"\u0004\u0008 \u0010\u000b¨\u0006!", d2 = {"Landroidx/compose/ui/focus/FocusOrder;", "", "()V", "focusProperties", "Landroidx/compose/ui/focus/FocusProperties;", "(Landroidx/compose/ui/focus/FocusProperties;)V", "down", "Landroidx/compose/ui/focus/FocusRequester;", "getDown", "()Landroidx/compose/ui/focus/FocusRequester;", "setDown", "(Landroidx/compose/ui/focus/FocusRequester;)V", "end", "getEnd", "setEnd", "left", "getLeft", "setLeft", "next", "getNext", "setNext", "previous", "getPrevious", "setPrevious", "right", "getRight", "setRight", "start", "getStart", "setStart", "up", "getUp", "setUp", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FocusOrder {

    public static final int $stable = 8;
    private final androidx.compose.ui.focus.FocusProperties focusProperties;
    static {
        final int i = 8;
    }

    public FocusOrder() {
        FocusPropertiesImpl focusPropertiesImpl = new FocusPropertiesImpl();
        super((FocusProperties)focusPropertiesImpl);
    }

    public FocusOrder(androidx.compose.ui.focus.FocusProperties focusProperties) {
        super();
        this.focusProperties = focusProperties;
    }

    public final androidx.compose.ui.focus.FocusRequester getDown() {
        return this.focusProperties.getDown();
    }

    public final androidx.compose.ui.focus.FocusRequester getEnd() {
        return this.focusProperties.getEnd();
    }

    public final androidx.compose.ui.focus.FocusRequester getLeft() {
        return this.focusProperties.getLeft();
    }

    public final androidx.compose.ui.focus.FocusRequester getNext() {
        return this.focusProperties.getNext();
    }

    public final androidx.compose.ui.focus.FocusRequester getPrevious() {
        return this.focusProperties.getPrevious();
    }

    public final androidx.compose.ui.focus.FocusRequester getRight() {
        return this.focusProperties.getRight();
    }

    public final androidx.compose.ui.focus.FocusRequester getStart() {
        return this.focusProperties.getStart();
    }

    public final androidx.compose.ui.focus.FocusRequester getUp() {
        return this.focusProperties.getUp();
    }

    public final void setDown(androidx.compose.ui.focus.FocusRequester down) {
        this.focusProperties.setDown(down);
    }

    public final void setEnd(androidx.compose.ui.focus.FocusRequester end) {
        this.focusProperties.setEnd(end);
    }

    public final void setLeft(androidx.compose.ui.focus.FocusRequester left) {
        this.focusProperties.setLeft(left);
    }

    public final void setNext(androidx.compose.ui.focus.FocusRequester next) {
        this.focusProperties.setNext(next);
    }

    public final void setPrevious(androidx.compose.ui.focus.FocusRequester previous) {
        this.focusProperties.setPrevious(previous);
    }

    public final void setRight(androidx.compose.ui.focus.FocusRequester right) {
        this.focusProperties.setRight(right);
    }

    public final void setStart(androidx.compose.ui.focus.FocusRequester start) {
        this.focusProperties.setStart(start);
    }

    public final void setUp(androidx.compose.ui.focus.FocusRequester up) {
        this.focusProperties.setUp(up);
    }
}
