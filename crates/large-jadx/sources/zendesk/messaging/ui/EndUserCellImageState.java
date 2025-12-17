package zendesk.messaging.ui;

import com.squareup.picasso.t;
import zendesk.messaging.Attachment;
import zendesk.messaging.AttachmentSettings;
import zendesk.messaging.MessagingItem.FileQuery.FailureReason;
import zendesk.messaging.MessagingItem.Query.Status;

/* loaded from: classes3.dex */
class EndUserCellImageState extends zendesk.messaging.ui.EndUserCellFileState {

    private final t picasso;
    EndUserCellImageState(String string, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, MessagingItem.Query.Status messagingItem$Query$Status3, zendesk.messaging.ui.MessageActionListener messageActionListener4, Attachment attachment5, MessagingItem.FileQuery.FailureReason messagingItem$FileQuery$FailureReason6, AttachmentSettings attachmentSettings7, t t8) {
        super(string, messagingCellProps2, status3, messageActionListener4, attachment5, failureReason6, attachmentSettings7);
        this.picasso = t8;
    }

    @Override // zendesk.messaging.ui.EndUserCellFileState
    public boolean equals(Object object) {
        int equals;
        Class<zendesk.messaging.ui.EndUserCellImageState> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (EndUserCellImageState.class != object.getClass()) {
            } else {
                if (!super.equals(object)) {
                    return i;
                }
                t picasso = this.picasso;
                final t obj5 = object.picasso;
                if (picasso != null) {
                    equals = picasso.equals(obj5);
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

    @Override // zendesk.messaging.ui.EndUserCellFileState
    public int hashCode() {
        int i;
        t picasso = this.picasso;
        if (picasso != null) {
            i = picasso.hashCode();
        } else {
            i = 0;
        }
        return i3 += i;
    }
}
