package zendesk.support.request;

import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
class StateRetryDialog implements zendesk.support.request.StateUi.DialogState, Serializable {

    private final List<zendesk.support.request.StateMessage> message;
    private final boolean visible;
    StateRetryDialog(List<zendesk.support.request.StateMessage> list) {
        super(list, 0);
    }

    private StateRetryDialog(List<zendesk.support.request.StateMessage> list, boolean z2) {
        super();
        this.message = list;
        this.visible = z2;
    }

    List<zendesk.support.request.StateMessage> getMessage() {
        return this.message;
    }

    @Override // zendesk.support.request.StateUi$DialogState
    public boolean isVisible() {
        return this.visible;
    }

    @Override // zendesk.support.request.StateUi$DialogState
    public zendesk.support.request.StateUi.DialogState setVisible(boolean z) {
        StateRetryDialog stateRetryDialog = new StateRetryDialog(this.message, z);
        return stateRetryDialog;
    }
}
