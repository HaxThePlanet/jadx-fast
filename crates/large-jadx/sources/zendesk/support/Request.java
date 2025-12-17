package zendesk.support;

import f.g.e.a;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public class Request {

    private List<Long> collaboratorIds;
    private zendesk.support.EndUserComment comment;
    private Integer commentCount;
    private Date createdAt;
    private List<zendesk.support.CustomField> customFields;
    private String description;
    private Date dueAt;
    private zendesk.support.Comment firstComment;
    private String id;
    private zendesk.support.Comment lastComment;
    private List<zendesk.support.User> lastCommentingAgents;
    private List<Long> lastCommentingAgentsIds;
    private Long organizationId;
    private String priority;
    private Date publicUpdatedAt;
    private Long requesterId;
    private zendesk.support.RequestStatus status;
    private String subject;
    private String type;
    private Date updatedAt;
    private String url;
    Request(String string, zendesk.support.RequestStatus requestStatus2) {
        super();
        this.id = string;
        this.status = requestStatus2;
    }

    public List<Long> getCollaboratorIds() {
        return a.c(this.collaboratorIds);
    }

    public Integer getCommentCount() {
        return this.commentCount;
    }

    public Date getCreatedAt() {
        int date;
        long time;
        if (this.createdAt == null) {
            date = 0;
        } else {
            date = new Date(this.createdAt.getTime(), obj2);
        }
        return date;
    }

    public List<zendesk.support.CustomField> getCustomFields() {
        return this.customFields;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getDueAt() {
        int date;
        long time;
        if (this.dueAt == null) {
            date = 0;
        } else {
            date = new Date(this.dueAt.getTime(), obj2);
        }
        return date;
    }

    public zendesk.support.Comment getFirstComment() {
        return this.firstComment;
    }

    public String getId() {
        return this.id;
    }

    public zendesk.support.Comment getLastComment() {
        return this.lastComment;
    }

    public List<zendesk.support.User> getLastCommentingAgents() {
        return a.c(this.lastCommentingAgents);
    }

    List<Long> getLastCommentingAgentsIds() {
        return a.c(this.lastCommentingAgentsIds);
    }

    public Long getOrganizationId() {
        return this.organizationId;
    }

    public String getPriority() {
        return this.priority;
    }

    public Date getPublicUpdatedAt() {
        if (this.publicUpdatedAt == null) {
            return getUpdatedAt();
        }
        Date date = new Date(this.publicUpdatedAt.getTime(), obj2);
        return date;
    }

    public Long getRequesterId() {
        return this.requesterId;
    }

    public zendesk.support.RequestStatus getStatus() {
        return this.status;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getType() {
        return this.type;
    }

    public Date getUpdatedAt() {
        int date;
        long time;
        if (this.updatedAt == null) {
            date = 0;
        } else {
            date = new Date(this.updatedAt.getTime(), obj2);
        }
        return date;
    }

    public String getUrl() {
        return this.url;
    }

    public void setComment(zendesk.support.EndUserComment endUserComment) {
        this.comment = endUserComment;
    }

    void setLastCommentingAgents(List<zendesk.support.User> list) {
        this.lastCommentingAgents = list;
    }
}
