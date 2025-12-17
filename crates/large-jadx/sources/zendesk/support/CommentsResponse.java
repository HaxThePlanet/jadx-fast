package zendesk.support;

import f.g.e.a;
import java.util.List;

/* loaded from: classes3.dex */
public class CommentsResponse extends zendesk.support.ResponseWrapper {

    private List<zendesk.support.CommentResponse> comments;
    private List<Object> organizations;
    private List<zendesk.support.User> users;
    public List<zendesk.support.CommentResponse> getComments() {
        return a.c(this.comments);
    }

    public List<Object> getOrganizations() {
        return a.c(this.organizations);
    }

    public List<zendesk.support.User> getUsers() {
        return a.c(this.users);
    }
}
