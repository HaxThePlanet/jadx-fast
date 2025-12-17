package androidx.compose.ui.focus;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u001e\u0008f\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\u000c\u001a\u0004\u0008\u0004\u0010\u0005\"\u0004\u0008\u0006\u0010\u0007R$\u0010\n\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000eR$\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008\u0010\u0010\u000c\"\u0004\u0008\u0011\u0010\u000eRB\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00122\u0012\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00128W@WX\u0097\u000e¢\u0006\u0012\u0012\u0004\u0008\u0015\u0010\u0016\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001aRB\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00122\u0012\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\t0\u00128W@WX\u0097\u000e¢\u0006\u0012\u0012\u0004\u0008\u001c\u0010\u0016\u001a\u0004\u0008\u001d\u0010\u0018\"\u0004\u0008\u001e\u0010\u001aR$\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008 \u0010\u000c\"\u0004\u0008!\u0010\u000eR$\u0010\"\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008#\u0010\u000c\"\u0004\u0008$\u0010\u000eR$\u0010%\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008&\u0010\u000c\"\u0004\u0008'\u0010\u000eR$\u0010(\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008)\u0010\u000c\"\u0004\u0008*\u0010\u000eR$\u0010+\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008,\u0010\u000c\"\u0004\u0008-\u0010\u000eR$\u0010.\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\u000c\u001a\u0004\u0008/\u0010\u000c\"\u0004\u00080\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u00061À\u0006\u0001", d2 = {"Landroidx/compose/ui/focus/FocusProperties;", "", "canFocus", "", "getCanFocus", "()Z", "setCanFocus", "(Z)V", "<anonymous parameter 0>", "Landroidx/compose/ui/focus/FocusRequester;", "down", "getDown", "()Landroidx/compose/ui/focus/FocusRequester;", "setDown", "(Landroidx/compose/ui/focus/FocusRequester;)V", "end", "getEnd", "setEnd", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusDirection;", "enter", "getEnter$annotations", "()V", "getEnter", "()Lkotlin/jvm/functions/Function1;", "setEnter", "(Lkotlin/jvm/functions/Function1;)V", "exit", "getExit$annotations", "getExit", "setExit", "left", "getLeft", "setLeft", "next", "getNext", "setNext", "previous", "getPrevious", "setPrevious", "right", "getRight", "setRight", "start", "getStart", "setStart", "up", "getUp", "setUp", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FocusProperties {
    public static void getEnter$annotations() {
    }

    public static void getExit$annotations() {
    }

    public abstract boolean getCanFocus();

    public androidx.compose.ui.focus.FocusRequester getDown() {
        return FocusRequester.Companion.getDefault();
    }

    public androidx.compose.ui.focus.FocusRequester getEnd() {
        return FocusRequester.Companion.getDefault();
    }

    public Function1<androidx.compose.ui.focus.FocusDirection, androidx.compose.ui.focus.FocusRequester> getEnter() {
        return (Function1)FocusProperties.enter.1.INSTANCE;
    }

    public Function1<androidx.compose.ui.focus.FocusDirection, androidx.compose.ui.focus.FocusRequester> getExit() {
        return (Function1)FocusProperties.exit.1.INSTANCE;
    }

    public androidx.compose.ui.focus.FocusRequester getLeft() {
        return FocusRequester.Companion.getDefault();
    }

    public androidx.compose.ui.focus.FocusRequester getNext() {
        return FocusRequester.Companion.getDefault();
    }

    public androidx.compose.ui.focus.FocusRequester getPrevious() {
        return FocusRequester.Companion.getDefault();
    }

    public androidx.compose.ui.focus.FocusRequester getRight() {
        return FocusRequester.Companion.getDefault();
    }

    public androidx.compose.ui.focus.FocusRequester getStart() {
        return FocusRequester.Companion.getDefault();
    }

    public androidx.compose.ui.focus.FocusRequester getUp() {
        return FocusRequester.Companion.getDefault();
    }

    public abstract void setCanFocus(boolean z);

    public void setDown(androidx.compose.ui.focus.FocusRequester focusRequester) {
    }

    public void setEnd(androidx.compose.ui.focus.FocusRequester focusRequester) {
    }

    public void setEnter(Function1<? super androidx.compose.ui.focus.FocusDirection, androidx.compose.ui.focus.FocusRequester> function1) {
    }

    public void setExit(Function1<? super androidx.compose.ui.focus.FocusDirection, androidx.compose.ui.focus.FocusRequester> function1) {
    }

    public void setLeft(androidx.compose.ui.focus.FocusRequester focusRequester) {
    }

    public void setNext(androidx.compose.ui.focus.FocusRequester focusRequester) {
    }

    public void setPrevious(androidx.compose.ui.focus.FocusRequester focusRequester) {
    }

    public void setRight(androidx.compose.ui.focus.FocusRequester focusRequester) {
    }

    public void setStart(androidx.compose.ui.focus.FocusRequester focusRequester) {
    }

    public void setUp(androidx.compose.ui.focus.FocusRequester focusRequester) {
    }
}
