package zendesk.support;

import java.util.Date;

/* loaded from: classes3.dex */
public class HelpCenterAttachment {

    private Long articleId;
    private String contentType;
    private String contentUrl;
    private Date createdAt;
    private String fileName;
    private Long id;
    private Long size;
    private Date updatedAt;
    private String url;
    public Long getArticleId() {
        return this.articleId;
    }

    public String getContentType() {
        return this.contentType;
    }

    public String getContentUrl() {
        return this.contentUrl;
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

    public String getFileName() {
        return this.fileName;
    }

    public Long getId() {
        return this.id;
    }

    public Long getSize() {
        return this.size;
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
}
