package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u001c\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0008R\u001a\u0010\t\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0010\u0010\u000c\"\u0004\u0008\u0011\u0010\u000eR,\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\u0013X\u0096\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0015\u0010\u0002\u001a\u0004\u0008\u0016\u0010\u0017\"\u0004\u0008\u0018\u0010\u0019R,\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\n0\u0013X\u0096\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u001b\u0010\u0002\u001a\u0004\u0008\u001c\u0010\u0017\"\u0004\u0008\u001d\u0010\u0019R\u001a\u0010\u001e\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010\u000c\"\u0004\u0008 \u0010\u000eR\u001a\u0010!\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\"\u0010\u000c\"\u0004\u0008#\u0010\u000eR\u001a\u0010$\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008%\u0010\u000c\"\u0004\u0008&\u0010\u000eR\u001a\u0010'\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008(\u0010\u000c\"\u0004\u0008)\u0010\u000eR\u001a\u0010*\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008+\u0010\u000c\"\u0004\u0008,\u0010\u000eR\u001a\u0010-\u001a\u00020\nX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008.\u0010\u000c\"\u0004\u0008/\u0010\u000e¨\u00060", d2 = {"Landroidx/compose/ui/focus/FocusPropertiesImpl;", "Landroidx/compose/ui/focus/FocusProperties;", "()V", "canFocus", "", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "down", "Landroidx/compose/ui/focus/FocusRequester;", "getDown", "()Landroidx/compose/ui/focus/FocusRequester;", "setDown", "(Landroidx/compose/ui/focus/FocusRequester;)V", "end", "getEnd", "setEnd", "enter", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "getEnter$annotations", "getEnter", "()Lkotlin/jvm/functions/Function1;", "setEnter", "(Lkotlin/jvm/functions/Function1;)V", "exit", "getExit$annotations", "getExit", "setExit", "left", "getLeft", "setLeft", "next", "getNext", "setNext", "previous", "getPrevious", "setPrevious", "right", "getRight", "setRight", "start", "getStart", "setStart", "up", "getUp", "setUp", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FocusPropertiesImpl implements androidx.compose.ui.focus.FocusProperties {

    public static final int $stable = 8;
    private boolean canFocus = true;
    private androidx.compose.ui.focus.FocusRequester down;
    private androidx.compose.ui.focus.FocusRequester end;
    private Function1<? super androidx.compose.ui.focus.FocusDirection, androidx.compose.ui.focus.FocusRequester> enter;
    private Function1<? super androidx.compose.ui.focus.FocusDirection, androidx.compose.ui.focus.FocusRequester> exit;
    private androidx.compose.ui.focus.FocusRequester left;
    private androidx.compose.ui.focus.FocusRequester next;
    private androidx.compose.ui.focus.FocusRequester previous;
    private androidx.compose.ui.focus.FocusRequester right;
    private androidx.compose.ui.focus.FocusRequester start;
    private androidx.compose.ui.focus.FocusRequester up;
    static {
        final int i = 8;
    }

    public FocusPropertiesImpl() {
        super();
        int i = 1;
        this.next = FocusRequester.Companion.getDefault();
        this.previous = FocusRequester.Companion.getDefault();
        this.up = FocusRequester.Companion.getDefault();
        this.down = FocusRequester.Companion.getDefault();
        this.left = FocusRequester.Companion.getDefault();
        this.right = FocusRequester.Companion.getDefault();
        this.start = FocusRequester.Companion.getDefault();
        this.end = FocusRequester.Companion.getDefault();
        this.enter = (Function1)FocusPropertiesImpl.enter.1.INSTANCE;
        this.exit = (Function1)FocusPropertiesImpl.exit.1.INSTANCE;
    }

    public static void getEnter$annotations() {
    }

    public static void getExit$annotations() {
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public boolean getCanFocus() {
        return this.canFocus;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public androidx.compose.ui.focus.FocusRequester getDown() {
        return this.down;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public androidx.compose.ui.focus.FocusRequester getEnd() {
        return this.end;
    }

    public Function1<androidx.compose.ui.focus.FocusDirection, androidx.compose.ui.focus.FocusRequester> getEnter() {
        return this.enter;
    }

    public Function1<androidx.compose.ui.focus.FocusDirection, androidx.compose.ui.focus.FocusRequester> getExit() {
        return this.exit;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public androidx.compose.ui.focus.FocusRequester getLeft() {
        return this.left;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public androidx.compose.ui.focus.FocusRequester getNext() {
        return this.next;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public androidx.compose.ui.focus.FocusRequester getPrevious() {
        return this.previous;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public androidx.compose.ui.focus.FocusRequester getRight() {
        return this.right;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public androidx.compose.ui.focus.FocusRequester getStart() {
        return this.start;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public androidx.compose.ui.focus.FocusRequester getUp() {
        return this.up;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setCanFocus(boolean <set-?>) {
        this.canFocus = <set-?>;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setDown(androidx.compose.ui.focus.FocusRequester <set-?>) {
        this.down = <set-?>;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setEnd(androidx.compose.ui.focus.FocusRequester <set-?>) {
        this.end = <set-?>;
    }

    public void setEnter(Function1<? super androidx.compose.ui.focus.FocusDirection, androidx.compose.ui.focus.FocusRequester> <set-?>) {
        this.enter = <set-?>;
    }

    public void setExit(Function1<? super androidx.compose.ui.focus.FocusDirection, androidx.compose.ui.focus.FocusRequester> <set-?>) {
        this.exit = <set-?>;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setLeft(androidx.compose.ui.focus.FocusRequester <set-?>) {
        this.left = <set-?>;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setNext(androidx.compose.ui.focus.FocusRequester <set-?>) {
        this.next = <set-?>;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setPrevious(androidx.compose.ui.focus.FocusRequester <set-?>) {
        this.previous = <set-?>;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setRight(androidx.compose.ui.focus.FocusRequester <set-?>) {
        this.right = <set-?>;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setStart(androidx.compose.ui.focus.FocusRequester <set-?>) {
        this.start = <set-?>;
    }

    @Override // androidx.compose.ui.focus.FocusProperties
    public void setUp(androidx.compose.ui.focus.FocusRequester <set-?>) {
        this.up = <set-?>;
    }
}
