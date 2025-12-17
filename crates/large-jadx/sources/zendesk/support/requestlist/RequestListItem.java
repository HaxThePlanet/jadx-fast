package zendesk.support.requestlist;

import f.g.a.a;
import f.g.e.a;
import f.g.e.g;
import java.util.Date;
import java.util.List;
import zendesk.support.request.RequestConfiguration.Builder;

/* loaded from: classes3.dex */
class RequestListItem {

    private final zendesk.support.requestlist.RequestInfo requestInfo;
    RequestListItem(zendesk.support.requestlist.RequestInfo requestInfo) {
        super();
        this.requestInfo = requestInfo;
    }

    RequestConfiguration.Builder configure(RequestConfiguration.Builder requestConfiguration$Builder) {
        return builder.withRequestInfo(this.requestInfo);
    }

    String getAvatar() {
        if (hasAgentReplied()) {
            return (RequestInfo.AgentInfo)this.requestInfo.getAgentInfos().get(0).getAvatar();
        }
        return "";
    }

    String getFirstMessage() {
        return this.requestInfo.getFirstMessageInfo().getBody();
    }

    long getItemId() {
        int i;
        String localId = this.requestInfo.getLocalId();
        if (g.c(localId)) {
            i = localId.hashCode();
        } else {
            i = this.requestInfo.getRemoteId().hashCode();
        }
        return (long)i;
    }

    List<String> getLastCommentingAgentNames() {
        RequestListItem.1 anon = new RequestListItem.1(this);
        return a.k(this.requestInfo.getAgentInfos(), anon);
    }

    String getLastMessage() {
        return this.requestInfo.getLastMessageInfo().getBody();
    }

    Date getLastUpdated() {
        return this.requestInfo.getLastUpdated();
    }

    boolean hasAgentReplied() {
        return a.i(this.requestInfo.getAgentInfos());
    }

    boolean isClosed() {
        return this.requestInfo.isClosed();
    }

    boolean isFailed() {
        return a.i(this.requestInfo.getFailedMessageIds());
    }

    boolean isUnread() {
        return this.requestInfo.isUnread();
    }
}
