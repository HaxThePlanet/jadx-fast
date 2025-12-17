package zendesk.messaging.ui;

import zendesk.messaging.MessagingItem.Query.Status;

/* loaded from: classes3.dex */
class EndUserCellMessageState extends zendesk.messaging.ui.EndUserCellBaseState {

    private final String message;
    EndUserCellMessageState(String string, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, MessagingItem.Query.Status messagingItem$Query$Status3, zendesk.messaging.ui.MessageActionListener messageActionListener4, String string5) {
        super(string, messagingCellProps2, status3, messageActionListener4);
        this.message = string5;
    }

    @Override // zendesk.messaging.ui.EndUserCellBaseState
    public boolean equals(Object object) {
        int equals;
        Class<zendesk.messaging.ui.EndUserCellMessageState> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (EndUserCellMessageState.class != object.getClass()) {
            } else {
                if (!super.equals(object)) {
                    return i;
                }
                String message = this.message;
                final String obj5 = object.message;
                if (message != null) {
                    equals = message.equals(obj5);
                } else {
                    if (obj5 == null) {
                    } else {
                        equals = i;
                    }
                }
            }
            return equals;
        }
        return i;
    }

    @Override // zendesk.messaging.ui.EndUserCellBaseState
    String getMessage() {
        return this.message;
    }

    @Override // zendesk.messaging.ui.EndUserCellBaseState
    public int hashCode() {
        int i;
        String message = this.message;
        if (message != null) {
            i = message.hashCode();
        } else {
            i = 0;
        }
        return i3 += i;
    }
}
