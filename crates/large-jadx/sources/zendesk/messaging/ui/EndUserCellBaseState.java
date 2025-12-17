package zendesk.messaging.ui;

import zendesk.messaging.MessagingItem.Query.Status;

/* loaded from: classes3.dex */
abstract class EndUserCellBaseState {

    private final String id;
    private final zendesk.messaging.ui.MessageActionListener messageActionListener;
    private final zendesk.messaging.ui.MessagingCellProps props;
    private final MessagingItem.Query.Status status;
    EndUserCellBaseState(String string, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, MessagingItem.Query.Status messagingItem$Query$Status3, zendesk.messaging.ui.MessageActionListener messageActionListener4) {
        super();
        this.id = string;
        this.props = messagingCellProps2;
        this.status = status3;
        this.messageActionListener = messageActionListener4;
    }

    public boolean equals(Object object) {
        int i2;
        boolean equals2;
        boolean equals;
        int i;
        Class class;
        Object class2;
        int obj5;
        i2 = 1;
        if (this == object) {
            return i2;
        }
        final int i3 = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                String str = this.id;
                if (str != null) {
                    if (!str.equals(object.id)) {
                        return i3;
                    }
                } else {
                    if (object.id != null) {
                    }
                }
                zendesk.messaging.ui.MessagingCellProps props = this.props;
                if (props != null) {
                    if (!props.equals(object.props)) {
                        return i3;
                    }
                } else {
                    if (object.props != null) {
                    }
                }
                if (this.status != object.status) {
                    return i3;
                }
                i = this.messageActionListener != null ? i2 : i3;
                obj5 = object.messageActionListener == null ? i2 : i3;
                if (i == obj5) {
                } else {
                    i2 = i3;
                }
            }
            return i2;
        }
        return i3;
    }

    String getId() {
        return this.id;
    }

    zendesk.messaging.ui.MessageActionListener getMessageActionListener() {
        return this.messageActionListener;
    }

    zendesk.messaging.ui.MessagingCellProps getProps() {
        return this.props;
    }

    MessagingItem.Query.Status getStatus() {
        return this.status;
    }

    public int hashCode() {
        int i2;
        int i;
        int i3;
        int i4;
        String str = this.id;
        i = 0;
        if (str != null) {
            i2 = str.hashCode();
        } else {
            i2 = i;
        }
        zendesk.messaging.ui.MessagingCellProps props = this.props;
        if (props != null) {
            i3 = props.hashCode();
        } else {
            i3 = i;
        }
        MessagingItem.Query.Status status = this.status;
        if (status != null) {
            i4 = status.hashCode();
        } else {
            i4 = i;
        }
        zendesk.messaging.ui.MessageActionListener messageActionListener = this.messageActionListener;
        if (messageActionListener != null) {
            i = messageActionListener.hashCode();
        }
        return i9 += i;
    }
}
