package zendesk.support.request;

import com.zendesk.service.a;
import o.b.a;
import o.b.n;

/* loaded from: classes3.dex */
class ReducerError extends n<zendesk.support.request.StateError> {
    @Override // o.b.n
    public Object getInitialState() {
        return getInitialState();
    }

    @Override // o.b.n
    public zendesk.support.request.StateError getInitialState() {
        StateError stateError = new StateError();
        return stateError;
    }

    @Override // o.b.n
    public Object reduce(Object object, a a2) {
        return reduce((StateError)object, a2);
    }

    public zendesk.support.request.StateError reduce(zendesk.support.request.StateError stateError, a<?> a2) {
        a errorResponse;
        boolean actionType;
        boolean z;
        int initialGetComments;
        int i;
        String str;
        zendesk.support.request.StateError.ErrorType obj5;
        Object obj6;
        boolean z2 = a2 instanceof ActionFactory.ErrorAction;
        errorResponse = (ActionFactory.ErrorAction)a2.getErrorResponse();
        if (z2 && errorResponse.e() && errorResponse.m() == 401) {
            errorResponse = (ActionFactory.ErrorAction)a2.getErrorResponse();
            if (errorResponse.e()) {
                if (errorResponse.m() == 401) {
                    obj5 = new StateError(StateError.ErrorType.NoAccess, errorResponse.b());
                    return obj5;
                }
            }
        }
        actionType.hashCode();
        initialGetComments = -1;
        switch (actionType) {
            case "LOAD_COMMENTS_UPDATE_SUCCESS":
                initialGetComments = 0;
                break;
            case "LOAD_COMMENTS_INITIAL_ERROR":
                initialGetComments = 1;
                break;
            case "LOAD_COMMENT_INITIAL":
                initialGetComments = 2;
                break;
            case "LOAD_COMMENTS_INITIAL_SUCCESS":
                initialGetComments = 3;
                break;
            case "CREATE_REQUEST_ERROR":
                initialGetComments = 4;
                break;
            case "CREATE_COMMENT":
                initialGetComments = 5;
                break;
            default:
        }
        switch (initialGetComments) {
            case 0:
                obj5 = new StateError();
                return obj5;
                obj6 = new StateError(StateError.ErrorType.InputFormSubmission, (ActionFactory.ErrorAction)a2.getErrorResponse().b());
                return obj6;
                obj5 = new StateError();
                return obj5;
            case 1:
                obj6 = new StateError(StateError.ErrorType.InitialGetComments, (ActionFactory.ErrorAction)a2.getErrorResponse().b());
                return obj6;
                obj5 = new StateError();
                return obj5;
                obj6 = new StateError(StateError.ErrorType.InputFormSubmission, (ActionFactory.ErrorAction)a2.getErrorResponse().b());
                return obj6;
                obj5 = new StateError();
                return obj5;
            case 2:
                obj6 = new StateError(StateError.ErrorType.InputFormSubmission, (ActionFactory.ErrorAction)a2.getErrorResponse().b());
                return obj6;
                obj5 = new StateError();
                return obj5;
            case 3:
                obj5 = new StateError();
                return obj5;
            default:
        }
        return null;
    }
}
