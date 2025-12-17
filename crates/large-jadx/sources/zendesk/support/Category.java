package zendesk.support;

import java.io.Serializable;
import java.util.Date;

/* loaded from: classes3.dex */
public class Category implements Serializable {

    private Date createdAt;
    private String description;
    private String htmlUrl;
    private Long id;
    private String locale;
    private String name;
    private boolean outdated;
    private int position;
    private String sourceLocale;
    private Date updatedAt;
    private String url;
    @Override // java.io.Serializable
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

    @Override // java.io.Serializable
    public String getDescription() {
        return this.description;
    }

    @Override // java.io.Serializable
    public String getHtmlUrl() {
        return this.htmlUrl;
    }

    @Override // java.io.Serializable
    public Long getId() {
        return this.id;
    }

    @Override // java.io.Serializable
    public String getLocale() {
        return this.locale;
    }

    @Override // java.io.Serializable
    public String getName() {
        return this.name;
    }

    @Override // java.io.Serializable
    public int getPosition() {
        return this.position;
    }

    @Override // java.io.Serializable
    public String getSourceLocale() {
        return this.sourceLocale;
    }

    @Override // java.io.Serializable
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

    @Override // java.io.Serializable
    public String getUrl() {
        return this.url;
    }

    @Override // java.io.Serializable
    public boolean isOutdated() {
        return this.outdated;
    }
}
