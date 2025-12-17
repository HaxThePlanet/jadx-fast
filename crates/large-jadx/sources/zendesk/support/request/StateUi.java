package zendesk.support.request;

import java.io.Serializable;
import o.b.o;

/* loaded from: classes3.dex */
class StateUi implements Serializable {

    private final zendesk.support.request.StateUi.DialogState dialogState;

    interface DialogState {
        public abstract boolean isVisible();

        public abstract zendesk.support.request.StateUi.DialogState setVisible(boolean z);
    }
    StateUi() {
        super();
        this.dialogState = 0;
    }

    StateUi(zendesk.support.request.StateUi.DialogState stateUi$DialogState) {
        super();
        this.dialogState = dialogState;
    }

    static zendesk.support.request.StateUi fromState(o o) {
        Object obj1 = o.b(StateUi.class);
        if ((StateUi)obj1 != null) {
            return (StateUi)obj1;
        }
        obj1 = new StateUi();
        return obj1;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateUi.DialogState getDialogState() {
        return this.dialogState;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateUi setDialogState(zendesk.support.request.StateUi.DialogState stateUi$DialogState) {
        StateUi stateUi = new StateUi(dialogState);
        return stateUi;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UiState{dialogState=");
        stringBuilder.append(this.dialogState);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
