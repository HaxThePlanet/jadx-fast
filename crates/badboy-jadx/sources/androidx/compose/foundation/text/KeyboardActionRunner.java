package androidx.compose.foundation.text;

import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusDirection.Companion;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import androidx.compose.ui.text.input.ImeAction;
import androidx.compose.ui.text.input.ImeAction.Companion;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\"\u0004\u0008\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\u000cX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0019", d2 = {"Landroidx/compose/foundation/text/KeyboardActionRunner;", "Landroidx/compose/foundation/text/KeyboardActionScope;", "keyboardController", "Landroidx/compose/ui/platform/SoftwareKeyboardController;", "(Landroidx/compose/ui/platform/SoftwareKeyboardController;)V", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "setFocusManager", "(Landroidx/compose/ui/focus/FocusManager;)V", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "getKeyboardActions", "()Landroidx/compose/foundation/text/KeyboardActions;", "setKeyboardActions", "(Landroidx/compose/foundation/text/KeyboardActions;)V", "defaultKeyboardAction", "", "imeAction", "Landroidx/compose/ui/text/input/ImeAction;", "defaultKeyboardAction-KlQnJC8", "(I)V", "runAction", "runAction-KlQnJC8", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class KeyboardActionRunner implements androidx.compose.foundation.text.KeyboardActionScope {

    public static final int $stable = 8;
    public FocusManager focusManager;
    public androidx.compose.foundation.text.KeyboardActions keyboardActions;
    private final SoftwareKeyboardController keyboardController;
    static {
        final int i = 8;
    }

    public KeyboardActionRunner(SoftwareKeyboardController keyboardController) {
        super();
        this.keyboardController = keyboardController;
    }

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    public void defaultKeyboardAction-KlQnJC8(int imeAction) {
        boolean equals-impl0;
        int keyboardController;
        int previous-dhqQ-8s;
        if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getNext-eUduSuo())) {
            getFocusManager().moveFocus-3ESFkO8(FocusDirection.Companion.getNext-dhqQ-8s());
        } else {
            if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getPrevious-eUduSuo())) {
                getFocusManager().moveFocus-3ESFkO8(FocusDirection.Companion.getPrevious-dhqQ-8s());
            } else {
                if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getDone-eUduSuo())) {
                    keyboardController = this.keyboardController;
                    if (keyboardController != null) {
                        keyboardController.hide();
                    }
                } else {
                    previous-dhqQ-8s = 1;
                    if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getGo-eUduSuo())) {
                        equals-impl0 = previous-dhqQ-8s;
                    } else {
                        equals-impl0 = ImeAction.equals-impl0(imeAction, ImeAction.Companion.getSearch-eUduSuo());
                    }
                    if (equals-impl0) {
                        keyboardController = previous-dhqQ-8s;
                    } else {
                        keyboardController = ImeAction.equals-impl0(imeAction, ImeAction.Companion.getSend-eUduSuo());
                    }
                    if (keyboardController != 0) {
                    } else {
                        previous-dhqQ-8s = ImeAction.equals-impl0(imeAction, ImeAction.Companion.getDefault-eUduSuo());
                    }
                    if (previous-dhqQ-8s != 0) {
                    } else {
                        ImeAction.equals-impl0(imeAction, ImeAction.Companion.getNone-eUduSuo());
                    }
                }
            }
        }
    }

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    public final FocusManager getFocusManager() {
        FocusManager focusManager = this.focusManager;
        if (focusManager != null) {
            return focusManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("focusManager");
        return null;
    }

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    public final androidx.compose.foundation.text.KeyboardActions getKeyboardActions() {
        androidx.compose.foundation.text.KeyboardActions keyboardActions = this.keyboardActions;
        if (keyboardActions != null) {
            return keyboardActions;
        }
        Intrinsics.throwUninitializedPropertyAccessException("keyboardActions");
        return null;
    }

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    public final void runAction-KlQnJC8(int imeAction) {
        Function1 onPrevious;
        boolean equals-impl0;
        int iNSTANCE;
        if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getDone-eUduSuo())) {
            onPrevious = getKeyboardActions().getOnDone();
            if (onPrevious != null) {
                onPrevious.invoke(this);
                iNSTANCE = Unit.INSTANCE;
            }
            if (iNSTANCE == null) {
                defaultKeyboardAction-KlQnJC8(imeAction);
            }
        } else {
            if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getGo-eUduSuo())) {
                onPrevious = getKeyboardActions().getOnGo();
            } else {
                if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getNext-eUduSuo())) {
                    onPrevious = getKeyboardActions().getOnNext();
                } else {
                    if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getPrevious-eUduSuo())) {
                        onPrevious = getKeyboardActions().getOnPrevious();
                    } else {
                        if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getSearch-eUduSuo())) {
                            onPrevious = getKeyboardActions().getOnSearch();
                        } else {
                            if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getSend-eUduSuo())) {
                                onPrevious = getKeyboardActions().getOnSend();
                            } else {
                                if (ImeAction.equals-impl0(imeAction, ImeAction.Companion.getDefault-eUduSuo())) {
                                    equals-impl0 = 1;
                                } else {
                                    equals-impl0 = ImeAction.equals-impl0(imeAction, ImeAction.Companion.getNone-eUduSuo());
                                }
                                if (!equals-impl0) {
                                } else {
                                    onPrevious = iNSTANCE;
                                }
                            }
                        }
                    }
                }
            }
        }
        IllegalStateException keyboardAction = new IllegalStateException("invalid ImeAction".toString());
        throw keyboardAction;
    }

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    public final void setFocusManager(FocusManager <set-?>) {
        this.focusManager = <set-?>;
    }

    @Override // androidx.compose.foundation.text.KeyboardActionScope
    public final void setKeyboardActions(androidx.compose.foundation.text.KeyboardActions <set-?>) {
        this.keyboardActions = <set-?>;
    }
}
