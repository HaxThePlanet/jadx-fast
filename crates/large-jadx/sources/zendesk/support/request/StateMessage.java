package zendesk.support.request;

import com.zendesk.service.a;
import d.h.k.d;
import f.g.e.g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import zendesk.support.Attachment;
import zendesk.support.CommentResponse;
import zendesk.support.IdUtil;

/* loaded from: classes3.dex */
class StateMessage implements Serializable {

    private final List<zendesk.support.request.StateRequestAttachment> attachments;
    private final Date date;
    private final String htmlBody;
    private final long id;
    private final String plainBody;
    private final zendesk.support.request.StateMessageStatus state;
    private final long userId;
    StateMessage(String string, String string2, Date date3, long l4, long l5, zendesk.support.request.StateMessageStatus stateMessageStatus6, List<zendesk.support.request.StateRequestAttachment> list7) {
        super();
        this.htmlBody = string;
        this.plainBody = string2;
        this.date = date3;
        this.id = l4;
        this.userId = stateMessageStatus6;
        this.state = obj8;
        this.attachments = obj9;
    }

    StateMessage(String string, List<zendesk.support.request.StateRequestAttachment> list2) {
        super();
        this.htmlBody = 0;
        this.plainBody = string;
        Date obj3 = new Date();
        this.date = obj3;
        this.id = IdUtil.newLongId();
        this.userId = -1;
        this.state = StateMessageStatus.pending();
        this.attachments = list2;
    }

    static d<List<zendesk.support.request.StateMessage>, zendesk.support.request.StateIdMapper> convert(List<CommentResponse> list, zendesk.support.request.StateIdMapper stateIdMapper2, Map<Long, zendesk.support.request.StateRequestAttachment> map3) {
        zendesk.support.request.StateIdMapper idMapping;
        Object delivered;
        Object stateMessage;
        Object authorId;
        zendesk.support.request.StateMessage stateMessage2;
        long longValue;
        String htmlBody;
        String valueOf;
        Date createdAt;
        long l;
        long longValue2;
        zendesk.support.request.StateMessageStatus stateMessageStatus;
        ArrayList list2;
        Object obj = map3;
        ArrayList arrayList = new ArrayList(list.size());
        Iterator iterator = list.iterator();
        idMapping = stateIdMapper2;
        while (iterator.hasNext()) {
            delivered = iterator.next();
            stateMessage = (CommentResponse)delivered.getId();
            authorId = delivered.getAuthorId();
            if (stateMessage != null && authorId != null) {
            }
            if (authorId != null) {
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator iterator2 = delivered.getAttachments().iterator();
            boolean next2 = iterator2.hasNext();
            while (next2) {
                htmlBody = iterator2.next();
                if (obj.containsKey((Attachment)htmlBody.getId())) {
                }
                next2 = iterator2.hasNext();
                arrayList2.add(obj.get(htmlBody.getId()));
            }
            if (idMapping.hasLocalId(stateMessage)) {
            } else {
            }
            idMapping = idMapping.addIdMapping(stateMessage, Long.valueOf(IdUtil.newLongId()));
            super(delivered.getHtmlBody(), delivered.getBody(), delivered.getCreatedAt(), longValue, obj12, authorId.longValue(), obj14, StateMessageStatus.delivered(), arrayList2);
            arrayList.add(stateMessage);
            longValue = idMapping.getLocalId(stateMessage).longValue();
            htmlBody = iterator2.next();
            if (obj.containsKey((Attachment)htmlBody.getId())) {
            }
            arrayList2.add(obj.get(htmlBody.getId()));
        }
        return d.a(arrayList, idMapping.copy());
    }

    @Override // java.io.Serializable
    public boolean equals(Object object) {
        int equals3;
        String htmlBody;
        boolean plainBody;
        Date equals;
        boolean equals2;
        Class class;
        Object plainBody2;
        if (this == object) {
            return 1;
        }
        final int i = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (Long.compare(l, l2) != 0) {
                    return i;
                }
                if (Long.compare(userId, userId2) != 0) {
                    return i;
                }
                String htmlBody2 = this.htmlBody;
                if (htmlBody2 != null) {
                    if (!htmlBody2.equals(object.htmlBody)) {
                        return i;
                    }
                } else {
                    if (object.htmlBody != null) {
                    }
                }
                String plainBody3 = this.plainBody;
                if (plainBody3 != null) {
                    if (!plainBody3.equals(object.plainBody)) {
                        return i;
                    }
                } else {
                    if (object.plainBody != null) {
                    }
                }
                Date date = this.date;
                if (date != null) {
                    if (!date.equals(object.date)) {
                        return i;
                    }
                } else {
                    if (object.date != null) {
                    }
                }
                zendesk.support.request.StateMessageStatus state = this.state;
                if (state != null) {
                    if (!state.equals(object.state)) {
                        return i;
                    }
                } else {
                    if (object.state != null) {
                    }
                }
                List attachments = this.attachments;
                final List obj7 = object.attachments;
                if (attachments != null) {
                    equals3 = attachments.equals(obj7);
                } else {
                    if (obj7 == null) {
                    } else {
                        equals3 = i;
                    }
                }
            }
            return equals3;
        }
        return i;
    }

    List<zendesk.support.request.StateRequestAttachment> getAttachments() {
        return this.attachments;
    }

    @Override // java.io.Serializable
    String getBody() {
        String messageBodyForAttachments;
        if (g.c(this.plainBody)) {
            messageBodyForAttachments = this.plainBody;
        } else {
            messageBodyForAttachments = UtilsAttachment.getMessageBodyForAttachments(getAttachments());
        }
        return messageBodyForAttachments;
    }

    @Override // java.io.Serializable
    Date getDate() {
        return this.date;
    }

    @Override // java.io.Serializable
    String getHtmlBody() {
        return this.htmlBody;
    }

    @Override // java.io.Serializable
    long getId() {
        return this.id;
    }

    @Override // java.io.Serializable
    String getPlainBody() {
        return this.plainBody;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateMessageStatus getState() {
        return this.state;
    }

    @Override // java.io.Serializable
    long getUserId() {
        return this.userId;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        Object[] arr = new Object[7];
        int i5 = 2;
        arr[i5] = this.date;
        int i6 = 3;
        arr[i6] = Long.valueOf(this.id);
        arr[4] = Long.valueOf(this.userId);
        arr[5] = this.state;
        arr[6] = this.attachments;
        return Arrays.hashCode(arr);
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Message{htmlBody='");
        stringBuilder.append(this.htmlBody);
        int i = 39;
        stringBuilder.append(i);
        stringBuilder.append(", plainBody='");
        String plainBody = this.plainBody;
        stringBuilder.append(plainBody);
        stringBuilder.append(i);
        stringBuilder.append(", date=");
        stringBuilder.append(this.date);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", state=");
        stringBuilder.append(this.state);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    zendesk.support.request.StateMessage withAttachments(List<zendesk.support.request.StateRequestAttachment> list) {
        super(this.htmlBody, this.plainBody, this.date, this.id, obj5, this.userId, obj7, this.state, list);
        return stateMessage2;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateMessage withDelivered() {
        super(this.htmlBody, this.plainBody, this.date, this.id, obj5, this.userId, obj7, StateMessageStatus.delivered(), this.attachments);
        return stateMessage2;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateMessage withError(a a) {
        super(this.htmlBody, this.plainBody, this.date, this.id, obj5, this.userId, obj7, StateMessageStatus.error(a.b()), this.attachments);
        return stateMessage2;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateMessage withPending() {
        super(this.htmlBody, this.plainBody, this.date, this.id, obj5, this.userId, obj7, StateMessageStatus.pending(), this.attachments);
        return stateMessage2;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateMessage withUpdatedAttachment(zendesk.support.request.StateRequestAttachment stateRequestAttachment) {
        Object next;
        int cmp;
        long l;
        ArrayList arrayList = new ArrayList(this.attachments.size());
        Iterator iterator = this.attachments.iterator();
        while (iterator.hasNext()) {
            if (Long.compare(id, l) == 0) {
            }
            arrayList.add(next);
            next = stateRequestAttachment;
        }
        super(this.htmlBody, this.plainBody, this.date, this.id, obj5, this.userId, obj7, this.state, arrayList);
        return obj11;
    }
}
