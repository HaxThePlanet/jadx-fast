package zendesk.support.request;

import o.b.a;
import o.b.n;

/* loaded from: classes3.dex */
class ReducerUiState extends n<zendesk.support.request.StateUi> {
    @Override // o.b.n
    public Object getInitialState() {
        return getInitialState();
    }

    @Override // o.b.n
    public zendesk.support.request.StateUi getInitialState() {
        StateUi stateUi = new StateUi();
        return stateUi;
    }

    @Override // o.b.n
    public Object reduce(Object object, a a2) {
        return reduce((StateUi)object, a2);
    }

    public zendesk.support.request.StateUi reduce(zendesk.support.request.StateUi stateUi, a<?> a2) {
        String actionType = a2.getActionType();
        actionType.hashCode();
        final int i = 0;
        if (!actionType.equals("DIALOG_DISMISSED") && !actionType.equals("SHOW_RETRY_DIALOG")) {
            if (!actionType.equals("SHOW_RETRY_DIALOG")) {
                return i;
            }
            StateRetryDialog stateRetryDialog = new StateRetryDialog((List)a2.getData());
            return stateUi.setDialogState(stateRetryDialog);
        }
        return stateUi.setDialogState(i);
    }
}
