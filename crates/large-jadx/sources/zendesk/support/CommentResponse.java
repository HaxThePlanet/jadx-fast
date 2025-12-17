package zendesk.support;

import com.google.gson.annotations.SerializedName;
import f.g.e.a;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public class CommentResponse {

    private List<zendesk.support.Attachment> attachments;
    private Long authorId;
    private String body;
    private Date createdAt;
    private String htmlBody;
    private Long id;
    @SerializedName("public")
    private boolean isPublic = true;
    private String requestId;
    private String url;
    public CommentResponse() {
        super();
        final int i = 1;
    }

    public List<zendesk.support.Attachment> getAttachments() {
        return a.c(this.attachments);
    }

    public Long getAuthorId() {
        return this.authorId;
    }

    public String getBody() {
        return this.body;
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

    public String getHtmlBody() {
        return this.htmlBody;
    }

    public Long getId() {
        return this.id;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public void setAttachments(List<zendesk.support.Attachment> list) {
        this.attachments = list;
    }

    public void setAuthorId(Long long) {
        this.authorId = long;
    }

    public void setBody(String string) {
        this.body = string;
    }

    public void setCreatedAt(Date date) {
        this.createdAt = date;
    }

    public void setId(Long long) {
        this.id = long;
    }
}
