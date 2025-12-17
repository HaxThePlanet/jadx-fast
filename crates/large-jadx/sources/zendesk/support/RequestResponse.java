package zendesk.support;

import f.g.e.a;
import java.util.List;

/* loaded from: classes3.dex */
class RequestResponse {

    private List<zendesk.support.User> lastCommentingAgents;
    private zendesk.support.Request request;
    List<zendesk.support.User> getLastCommentingAgents() {
        return a.c(this.lastCommentingAgents);
    }

    zendesk.support.Request getRequest() {
        return this.request;
    }
}
