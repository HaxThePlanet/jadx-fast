package zendesk.support;

import f.g.e.a;
import java.util.List;

/* loaded from: classes3.dex */
class RequestsResponse extends zendesk.support.ResponseWrapper {

    private List<zendesk.support.User> lastCommentingAgents;
    private List<zendesk.support.Request> requests;
    List<zendesk.support.User> getLastCommentingAgents() {
        return a.c(this.lastCommentingAgents);
    }

    List<zendesk.support.Request> getRequests() {
        return a.c(this.requests);
    }
}
