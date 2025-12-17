package zendesk.support;

import com.google.gson.annotations.SerializedName;
import f.g.e.a;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public class Comment {

    @SerializedName("uploads")
    private List<String> attachments;
    private Long authorId;
    private String body;
    private Date createdAt;
    private String htmlBody;
    private Long id;
    @SerializedName("public")
    private boolean isPublic = true;
    private String requestId;
    private String url;
    public Comment() {
        super();
        final int i = 1;
    }

    public List<String> getAttachments() {
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

    public void setAttachments(List<String> list) {
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
}
