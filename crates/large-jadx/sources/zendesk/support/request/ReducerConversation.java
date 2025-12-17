package zendesk.support.request;

import android.net.Uri;
import f.g.e.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import o.b.a;
import o.b.n;
import zendesk.belvedere.s;
import zendesk.support.CommentsResponse;
import zendesk.support.Request;
import zendesk.support.RequestStatus;

/* loaded from: classes3.dex */
class ReducerConversation extends n<zendesk.support.request.StateConversation> {
    @Override // o.b.n
    public Object getInitialState() {
        return getInitialState();
    }

    @Override // o.b.n
    public zendesk.support.request.StateConversation getInitialState() {
        StateConversation stateConversation = new StateConversation();
        return stateConversation;
    }

    @Override // o.b.n
    public Object reduce(Object object, a a2) {
        return reduce((StateConversation)object, a2);
    }

    public zendesk.support.request.StateConversation reduce(zendesk.support.request.StateConversation stateConversation, a<?> a2) {
        boolean actionType;
        String str;
        zendesk.support.request.StateIdMapper attachmentIdMapper;
        int i2;
        int updatedAttachment;
        long key;
        int value;
        actionType.hashCode();
        i2 = -1;
        switch (actionType) {
            case "REQUEST_CLOSED":
                i2 = 0;
                break;
            case "CREATE_COMMENT_SUCCESS":
                i2 = 1;
                break;
            case "CREATE_COMMENT_ERROR":
                i2 = 2;
                break;
            case "LOAD_COMMENTS_UPDATE_SUCCESS":
                i2 = 3;
                break;
            case "DELETE_MESSAGE":
                i2 = 4;
                break;
            case "CREATE_REQUEST_SUCCESS":
                i2 = 5;
                break;
            case "LOAD_COMMENTS_INITIAL_SUCCESS":
                i2 = 6;
                break;
            case "START_CONFIG":
                i2 = 7;
                break;
            case "ATTACHMENT_DOWNLOADED":
                i2 = 8;
                break;
            case "CLEAR_MESSAGES":
                i2 = 9;
                break;
            case "LOAD_REQUEST_SUCCESS":
                i2 = 10;
                break;
            case "CREATE_REQUEST_ERROR":
                i2 = 11;
                break;
            case "LOAD_COMMENTS_FROM_CACHE_SUCCESS":
                i2 = 12;
                break;
            case "CREATE_COMMENT":
                i2 = 13;
                break;
            case "CREATE_REQUEST":
                i2 = 14;
                break;
            default:
        }
        switch (i2) {
            case 0:
                return stateConversation.newBuilder().setStatus(RequestStatus.Closed).build();
            case 1:
                Object obj7 = a2.getData();
                attachmentIdMapper = stateConversation.getAttachmentIdMapper();
                Iterator iterator2 = obj7.getLocalToRemoteAttachments().getLocalToRemoteIdMap().entrySet().iterator();
                Object next4 = iterator2.next();
                attachmentIdMapper = attachmentIdMapper.addIdMapping((Long)(Map.Entry)next4.getValue(), (Long)next4.getKey());
                return stateConversation.newBuilder().setRemoteId(obj7.getRequestId()).setMessageIdMapper(stateConversation.getMessageIdMapper().addIdMapping(Long.valueOf((ActionCreateComment.CreateCommentResult)obj7.getCommentRemoteId()), Long.valueOf(obj7.getMessage().getId()))).setAttachmentIdMapper(attachmentIdMapper).setMessages(StateMessageMergeUtil.mergeMessages(stateConversation.getMessages(), Collections.singletonList(obj7.getMessage()))).build();
            case 2:
                return stateConversation.newBuilder().setMessages(StateMessageMergeUtil.mergeMessages(stateConversation.getMessages(), Collections.singletonList((StateMessage)a2.getData()))).build();
            case 3:
                obj7 = a2.getData();
                List comments = (CommentsResponse)obj7.a.getComments();
                Collections.reverse(comments);
                d.h.k.d convert2 = StateRequestAttachment.convert(comments, (Map)obj7.b, stateConversation.getAttachmentIdMapper());
                d.h.k.d convert = StateMessage.convert(comments, stateConversation.getMessageIdMapper(), (Map)convert2.a);
                return stateConversation.newBuilder().setMessages(StateMessageMergeUtil.mergeMessages(stateConversation.getMessages(), (List)convert.a)).setAttachmentIdMapper((StateIdMapper)convert2.b.copy()).setMessageIdMapper((StateIdMapper)convert.b.copy()).setUsers(StateMessageMergeUtil.mergeUsers(stateConversation.getUsers(), StateRequestUser.convert((CommentsResponse)obj7.a.getUsers()))).build();
            case 4:
                return stateConversation.newBuilder().setMessages(StateMessageMergeUtil.removeMessageById((StateMessage)a2.getData().getId(), str)).build();
            case 5:
                obj7 = a2.getData();
                return stateConversation.newBuilder().setLocalId((RequestConfiguration)obj7.getLocalRequestId()).setRemoteId(obj7.getRequestId()).setStatus(obj7.getRequestStatus()).setHasAgentReplies(obj7.hasAgentReplies()).build();
            case 6:
                obj7 = a2.getData();
                obj7 = obj7.b;
                List messages3 = stateConversation.getMessages();
                ArrayList arrayList = new ArrayList(messages3.size());
                Iterator iterator = messages3.iterator();
                arrayList.add((StateMessage)iterator.next().withUpdatedAttachment((StateRequestAttachment)obj7.a.newBuilder().setLocalFile((s)obj7.e()).setLocalUri(obj7.n().toString()).build()));
                return stateConversation.newBuilder().setMessages(arrayList).build();
            case 7:
                obj7 = new StateIdMapper();
                obj7 = new StateIdMapper();
                return stateConversation.newBuilder().setMessages(Collections.emptyList()).setMessageIdMapper(obj7).setAttachmentIdMapper(obj7).build();
            case 8:
                obj7 = a2.getData();
                return stateConversation.newBuilder().setStatus((Request)obj7.getStatus()).setHasAgentReplies(a.i(obj7.getLastCommentingAgents())).build();
            case 9:
                obj7 = a2.getData();
                return stateConversation.newBuilder().setMessages((StateConversation)obj7.getMessages()).setAttachmentIdMapper(obj7.getAttachmentIdMapper()).setMessageIdMapper(obj7.getMessageIdMapper()).setUsers(obj7.getUsers()).build();
            case 10:
                List obj6 = a.c(stateConversation.getMessages());
                obj6.add((StateMessage)a2.getData());
                return stateConversation.newBuilder().setMessages(obj6).build();
            default:
                return null;
        }
    }
}
