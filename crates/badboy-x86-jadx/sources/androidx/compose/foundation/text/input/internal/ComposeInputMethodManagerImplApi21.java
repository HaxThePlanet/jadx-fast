package androidx.compose.foundation.text.input.internal;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManagerImplApi21;", "Landroidx/compose/foundation/text/input/internal/ComposeInputMethodManagerImpl;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "baseInputConnection", "Landroid/view/inputmethod/BaseInputConnection;", "sendKeyEvent", "", "event", "Landroid/view/KeyEvent;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
class ComposeInputMethodManagerImplApi21 extends androidx.compose.foundation.text.input.internal.ComposeInputMethodManagerImpl {

    private BaseInputConnection baseInputConnection;
    public ComposeInputMethodManagerImplApi21(View view) {
        super(view);
    }

    @Override // androidx.compose.foundation.text.input.internal.ComposeInputMethodManagerImpl
    public void sendKeyEvent(KeyEvent event) {
        BaseInputConnection baseInputConnection;
        BaseInputConnection connection;
        int i;
        if (this.baseInputConnection == null) {
            baseInputConnection = new BaseInputConnection(getView(), 0);
            i = 0;
            this.baseInputConnection = baseInputConnection;
        }
        baseInputConnection.sendKeyEvent(event);
    }
}
