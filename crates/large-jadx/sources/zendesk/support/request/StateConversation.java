package zendesk.support.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import o.b.o;
import zendesk.support.RequestStatus;

/* loaded from: classes3.dex */
class StateConversation implements Serializable {

    private final zendesk.support.request.StateIdMapper attachmentIdMapper;
    private final boolean hasAgentReplies;
    private final String localId;
    private final zendesk.support.request.StateIdMapper messageIdMapper;
    private final List<zendesk.support.request.StateMessage> messages;
    private final String remoteId;
    private final RequestStatus status;
    private final List<zendesk.support.request.StateRequestUser> users;

    static class Builder {

        private zendesk.support.request.StateIdMapper attachmentIdMapper;
        private boolean hasAgentReplies;
        private String localId;
        private zendesk.support.request.StateIdMapper messageIdMapper;
        private List<zendesk.support.request.StateMessage> messages;
        private String remoteId;
        private RequestStatus status;
        private List<zendesk.support.request.StateRequestUser> users;
        private Builder(String string, String string2, RequestStatus requestStatus3, boolean z4, List<zendesk.support.request.StateMessage> list5, List<zendesk.support.request.StateRequestUser> list6, zendesk.support.request.StateIdMapper stateIdMapper7, zendesk.support.request.StateIdMapper stateIdMapper8) {
            super();
            this.localId = string;
            this.remoteId = string2;
            this.status = requestStatus3;
            this.hasAgentReplies = z4;
            this.messages = list5;
            this.users = list6;
            this.attachmentIdMapper = stateIdMapper7;
            this.messageIdMapper = stateIdMapper8;
        }

        Builder(String string, String string2, RequestStatus requestStatus3, boolean z4, List list5, List list6, zendesk.support.request.StateIdMapper stateIdMapper7, zendesk.support.request.StateIdMapper stateIdMapper8, zendesk.support.request.StateConversation.1 stateConversation$19) {
            super(string, string2, requestStatus3, z4, list5, list6, stateIdMapper7, stateIdMapper8);
        }

        zendesk.support.request.StateConversation build() {
            super(this.localId, this.remoteId, this.status, this.hasAgentReplies, this.messages, this.users, this.attachmentIdMapper, this.messageIdMapper, 0);
            return stateConversation2;
        }

        zendesk.support.request.StateConversation.Builder setAttachmentIdMapper(zendesk.support.request.StateIdMapper stateIdMapper) {
            this.attachmentIdMapper = stateIdMapper;
            return this;
        }

        zendesk.support.request.StateConversation.Builder setHasAgentReplies(boolean z) {
            this.hasAgentReplies = z;
            return this;
        }

        zendesk.support.request.StateConversation.Builder setLocalId(String string) {
            this.localId = string;
            return this;
        }

        zendesk.support.request.StateConversation.Builder setMessageIdMapper(zendesk.support.request.StateIdMapper stateIdMapper) {
            this.messageIdMapper = stateIdMapper;
            return this;
        }

        zendesk.support.request.StateConversation.Builder setMessages(List<zendesk.support.request.StateMessage> list) {
            this.messages = list;
            return this;
        }

        zendesk.support.request.StateConversation.Builder setRemoteId(String string) {
            this.remoteId = string;
            return this;
        }

        zendesk.support.request.StateConversation.Builder setStatus(RequestStatus requestStatus) {
            this.status = requestStatus;
            return this;
        }

        zendesk.support.request.StateConversation.Builder setUsers(List<zendesk.support.request.StateRequestUser> list) {
            List obj2;
            this.users = list;
            if (!this.hasAgentReplies) {
                this.hasAgentReplies = StateRequestUser.containsAgent(list);
            }
            return this;
        }
    }
    StateConversation() {
        super();
        String str = "";
        this.localId = str;
        this.remoteId = str;
        this.status = 0;
        this.hasAgentReplies = false;
        ArrayList arrayList = new ArrayList();
        this.messages = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.users = arrayList2;
        StateIdMapper stateIdMapper = new StateIdMapper();
        this.attachmentIdMapper = stateIdMapper;
        StateIdMapper stateIdMapper2 = new StateIdMapper();
        this.messageIdMapper = stateIdMapper2;
    }

    private StateConversation(String string, String string2, RequestStatus requestStatus3, boolean z4, List<zendesk.support.request.StateMessage> list5, List<zendesk.support.request.StateRequestUser> list6, zendesk.support.request.StateIdMapper stateIdMapper7, zendesk.support.request.StateIdMapper stateIdMapper8) {
        super();
        this.localId = string;
        this.remoteId = string2;
        this.status = requestStatus3;
        this.hasAgentReplies = z4;
        this.messages = list5;
        this.users = list6;
        this.attachmentIdMapper = stateIdMapper7;
        this.messageIdMapper = stateIdMapper8;
    }

    StateConversation(String string, String string2, RequestStatus requestStatus3, boolean z4, List list5, List list6, zendesk.support.request.StateIdMapper stateIdMapper7, zendesk.support.request.StateIdMapper stateIdMapper8, zendesk.support.request.StateConversation.1 stateConversation$19) {
        super(string, string2, requestStatus3, z4, list5, list6, stateIdMapper7, stateIdMapper8);
    }

    static zendesk.support.request.StateConversation fromState(o o) {
        Object obj1 = o.b(StateConversation.class);
        if ((StateConversation)obj1 != null) {
            return (StateConversation)obj1;
        }
        obj1 = new StateConversation();
        return obj1;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateIdMapper getAttachmentIdMapper() {
        return this.attachmentIdMapper;
    }

    @Override // java.io.Serializable
    String getLocalId() {
        return this.localId;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateIdMapper getMessageIdMapper() {
        return this.messageIdMapper;
    }

    List<zendesk.support.request.StateMessage> getMessages() {
        return this.messages;
    }

    @Override // java.io.Serializable
    String getRemoteId() {
        return this.remoteId;
    }

    @Override // java.io.Serializable
    RequestStatus getStatus() {
        return this.status;
    }

    List<zendesk.support.request.StateRequestUser> getUsers() {
        return this.users;
    }

    @Override // java.io.Serializable
    boolean hasAgentReplies() {
        return this.hasAgentReplies;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateConversation.Builder newBuilder() {
        super(this.localId, this.remoteId, this.status, this.hasAgentReplies, this.messages, this.users, this.attachmentIdMapper, this.messageIdMapper, 0);
        return builder2;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Conversation{localId='");
        stringBuilder.append(this.localId);
        int i = 39;
        stringBuilder.append(i);
        stringBuilder.append(", remoteId='");
        stringBuilder.append(this.remoteId);
        stringBuilder.append(i);
        stringBuilder.append(", messages=");
        stringBuilder.append(this.messages);
        stringBuilder.append(", users=");
        stringBuilder.append(this.users);
        stringBuilder.append(", attachmentIdMapper=");
        stringBuilder.append(this.attachmentIdMapper);
        stringBuilder.append(", messageIdMapper=");
        stringBuilder.append(this.messageIdMapper);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
