package zendesk.support.request;

import java.io.Serializable;

/* loaded from: classes3.dex */
class StateMessageStatus implements Serializable {

    static final int DELIVERED = 2;
    static final int ERROR = 1;
    static final int PENDING = 3;
    private final String errorResponse;
    private final int status;
    private StateMessageStatus(int i, String string2) {
        super();
        this.status = i;
        this.errorResponse = string2;
    }

    static zendesk.support.request.StateMessageStatus delivered() {
        StateMessageStatus stateMessageStatus = new StateMessageStatus(2, 0);
        return stateMessageStatus;
    }

    static zendesk.support.request.StateMessageStatus error(String string) {
        StateMessageStatus stateMessageStatus = new StateMessageStatus(1, string);
        return stateMessageStatus;
    }

    static zendesk.support.request.StateMessageStatus pending() {
        StateMessageStatus stateMessageStatus = new StateMessageStatus(3, 0);
        return stateMessageStatus;
    }

    @Override // java.io.Serializable
    String getErrorResponse() {
        return this.errorResponse;
    }

    @Override // java.io.Serializable
    int getStatus() {
        return this.status;
    }

    @Override // java.io.Serializable
    public String toString() {
        String str;
        int i;
        int status = this.status;
        if (status != 1) {
            if (status != 2) {
                str = status != 3 ? "Unknown" : "Pending";
            } else {
                str = "Delivered";
            }
        } else {
            str = "Error";
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MessageState{status=");
        stringBuilder.append(str);
        stringBuilder.append(", errorResponse=");
        stringBuilder.append(this.errorResponse);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
