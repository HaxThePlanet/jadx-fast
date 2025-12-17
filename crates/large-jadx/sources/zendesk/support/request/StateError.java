package zendesk.support.request;

import java.io.Serializable;
import o.b.o;

/* loaded from: classes3.dex */
class StateError implements Serializable {

    private final String message;
    private final zendesk.support.request.StateError.ErrorType state;

    static enum ErrorType {

        InitialGetComments,
        InputFormSubmission,
        NoAccess,
        NoError;
    }
    StateError() {
        super(StateError.ErrorType.NoError, "=)");
    }

    StateError(zendesk.support.request.StateError.ErrorType stateError$ErrorType, String string2) {
        super();
        this.state = errorType;
        this.message = string2;
    }

    static zendesk.support.request.StateError fromState(o o) {
        Object obj1 = o.b(StateError.class);
        if ((StateError)obj1 != null) {
            return (StateError)obj1;
        }
        obj1 = new StateError();
        return obj1;
    }

    @Override // java.io.Serializable
    String getMessage() {
        return this.message;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateError.ErrorType getState() {
        return this.state;
    }
}
