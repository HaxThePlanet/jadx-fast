package androidx.compose.ui.text.input;

import androidx.compose.animation.core.MutatorMutex$$ExternalSyntheticBackportWithForwarding0;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Deprecated(message = "Use PlatformTextInputModifierNode instead.")
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u000c\u001a\u00020\rH\u0007J\u0008\u0010\u000e\u001a\u00020\rH\u0007J\u0008\u0010\u000f\u001a\u00020\rH\u0007JF\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0018\u0010\u0014\u001a\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00170\u0016\u0012\u0004\u0012\u00020\r0\u00152\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\r0\u0015H\u0016J\u0008\u0010\u001a\u001a\u00020\rH\u0007J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016R\"\u0010\u0005\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0007`\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c", d2 = {"Landroidx/compose/ui/text/input/TextInputService;", "", "platformTextInputService", "Landroidx/compose/ui/text/input/PlatformTextInputService;", "(Landroidx/compose/ui/text/input/PlatformTextInputService;)V", "_currentInputSession", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/ui/text/input/TextInputSession;", "Landroidx/compose/ui/text/AtomicReference;", "currentInputSession", "getCurrentInputSession$ui_text_release", "()Landroidx/compose/ui/text/input/TextInputSession;", "hideSoftwareKeyboard", "", "showSoftwareKeyboard", "startInput", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "imeOptions", "Landroidx/compose/ui/text/input/ImeOptions;", "onEditCommand", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/input/EditCommand;", "onImeActionPerformed", "Landroidx/compose/ui/text/input/ImeAction;", "stopInput", "session", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class TextInputService {

    public static final int $stable = 8;
    private final AtomicReference<androidx.compose.ui.text.input.TextInputSession> _currentInputSession;
    private final androidx.compose.ui.text.input.PlatformTextInputService platformTextInputService;
    static {
        final int i = 8;
    }

    public TextInputService(androidx.compose.ui.text.input.PlatformTextInputService platformTextInputService) {
        super();
        this.platformTextInputService = platformTextInputService;
        AtomicReference atomicReference = new AtomicReference(0);
        this._currentInputSession = atomicReference;
    }

    public final androidx.compose.ui.text.input.TextInputSession getCurrentInputSession$ui_text_release() {
        return (TextInputSession)this._currentInputSession.get();
    }

    @Deprecated(message = "Use SoftwareKeyboardController.hide or TextInputSession.hideSoftwareKeyboard instead.", replaceWith = @ReplaceWith(...))
    public final void hideSoftwareKeyboard() {
        this.platformTextInputService.hideSoftwareKeyboard();
    }

    @Deprecated(message = "Use SoftwareKeyboardController.show or TextInputSession.showSoftwareKeyboard instead.", replaceWith = @ReplaceWith(...))
    public final void showSoftwareKeyboard() {
        Object currentInputSession$ui_text_release;
        if (getCurrentInputSession$ui_text_release() != null) {
            this.platformTextInputService.showSoftwareKeyboard();
        }
    }

    public androidx.compose.ui.text.input.TextInputSession startInput(androidx.compose.ui.text.input.TextFieldValue value, androidx.compose.ui.text.input.ImeOptions imeOptions, Function1<? super List<? extends androidx.compose.ui.text.input.EditCommand>, Unit> onEditCommand, Function1<? super androidx.compose.ui.text.input.ImeAction, Unit> onImeActionPerformed) {
        this.platformTextInputService.startInput(value, imeOptions, onEditCommand, onImeActionPerformed);
        TextInputSession textInputSession = new TextInputSession(this, this.platformTextInputService);
        this._currentInputSession.set(textInputSession);
        return textInputSession;
    }

    public final void startInput() {
        this.platformTextInputService.startInput();
        TextInputSession textInputSession = new TextInputSession(this, this.platformTextInputService);
        this._currentInputSession.set(textInputSession);
    }

    public final void stopInput() {
        this.platformTextInputService.stopInput();
    }

    public void stopInput(androidx.compose.ui.text.input.TextInputSession session) {
        boolean platformTextInputService;
        if (MutatorMutex$$ExternalSyntheticBackportWithForwarding0.m(this._currentInputSession, session, 0)) {
            this.platformTextInputService.stopInput();
        }
    }
}
