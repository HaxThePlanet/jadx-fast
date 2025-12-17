package zendesk.support;

import com.zendesk.service.f;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public interface RequestProvider {
    public abstract void addComment(String string, zendesk.support.EndUserComment endUserComment2, f<zendesk.support.Comment> f3);

    public abstract void createRequest(zendesk.support.CreateRequest createRequest, f<zendesk.support.Request> f2);

    public abstract void getAllRequests(f<List<zendesk.support.Request>> f);

    public abstract void getComments(String string, f<zendesk.support.CommentsResponse> f2);

    public abstract void getCommentsSince(String string, Date date2, boolean z3, f<zendesk.support.CommentsResponse> f4);

    public abstract void getRequest(String string, f<zendesk.support.Request> f2);

    public abstract void getRequests(String string, f<List<zendesk.support.Request>> f2);

    public abstract void getTicketFormsById(List<Long> list, f<List<zendesk.support.TicketForm>> f2);

    public abstract void getUpdatesForDevice(f<zendesk.support.RequestUpdates> f);

    public abstract void markRequestAsRead(String string, int i2);

    public abstract void markRequestAsUnread(String string);
}
