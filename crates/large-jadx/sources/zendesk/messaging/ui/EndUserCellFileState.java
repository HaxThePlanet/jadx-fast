package zendesk.messaging.ui;

import zendesk.messaging.Attachment;
import zendesk.messaging.AttachmentSettings;
import zendesk.messaging.MessagingItem.FileQuery.FailureReason;
import zendesk.messaging.MessagingItem.Query.Status;

/* loaded from: classes3.dex */
class EndUserCellFileState extends zendesk.messaging.ui.EndUserCellBaseState {

    private final Attachment attachment;
    private final AttachmentSettings attachmentSettings;
    private final MessagingItem.FileQuery.FailureReason failureReason;
    EndUserCellFileState(String string, zendesk.messaging.ui.MessagingCellProps messagingCellProps2, MessagingItem.Query.Status messagingItem$Query$Status3, zendesk.messaging.ui.MessageActionListener messageActionListener4, Attachment attachment5, MessagingItem.FileQuery.FailureReason messagingItem$FileQuery$FailureReason6, AttachmentSettings attachmentSettings7) {
        super(string, messagingCellProps2, status3, messageActionListener4);
        this.failureReason = failureReason6;
        this.attachmentSettings = attachmentSettings7;
    }

    @Override // zendesk.messaging.ui.EndUserCellBaseState
    public boolean equals(Object object) {
        int equals;
        Class class;
        Class class2;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (!super.equals(object)) {
                    return i;
                }
                Attachment attachment = this.attachment;
                if (attachment != null) {
                } else {
                    if (object.attachment != null) {
                        return i;
                    }
                    if (this.failureReason != object.failureReason) {
                        return i;
                    }
                    AttachmentSettings attachmentSettings = this.attachmentSettings;
                    AttachmentSettings obj5 = object.attachmentSettings;
                    if (attachmentSettings != null) {
                        equals = attachmentSettings.equals(obj5);
                    } else {
                        if (obj5 == null) {
                        } else {
                            equals = i;
                        }
                    }
                    return equals;
                }
            }
            attachment.equals(object.attachment);
            throw 0;
        }
        return i;
    }

    @Override // zendesk.messaging.ui.EndUserCellBaseState
    Attachment getAttachment() {
        return this.attachment;
    }

    @Override // zendesk.messaging.ui.EndUserCellBaseState
    AttachmentSettings getAttachmentSettings() {
        return this.attachmentSettings;
    }

    @Override // zendesk.messaging.ui.EndUserCellBaseState
    MessagingItem.FileQuery.FailureReason getFailureReason() {
        return this.failureReason;
    }

    @Override // zendesk.messaging.ui.EndUserCellBaseState
    public int hashCode() {
        int i;
        int i2;
        Attachment attachment = this.attachment;
        if (attachment != null) {
        } else {
            i = 0;
            MessagingItem.FileQuery.FailureReason failureReason = this.failureReason;
            if (failureReason != null) {
                i2 = failureReason.hashCode();
            } else {
                i2 = i;
            }
            AttachmentSettings attachmentSettings = this.attachmentSettings;
            if (attachmentSettings != null) {
                i = attachmentSettings.hashCode();
            }
            return i9 += i;
        }
        attachment.hashCode();
        throw 0;
    }
}
