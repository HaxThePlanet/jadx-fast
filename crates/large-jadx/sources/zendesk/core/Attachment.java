package zendesk.core;

import f.g.e.a;
import java.util.List;

/* loaded from: classes3.dex */
class Attachment {

    private String contentType;
    private String contentUrl;
    private String fileName;
    private Long id;
    private String mappedContentUrl;
    private Long size;
    private List<zendesk.core.Attachment> thumbnails;
    private String url;
    public String getContentType() {
        return this.contentType;
    }

    public String getContentUrl() {
        return this.contentUrl;
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

    public List<zendesk.core.Attachment> getThumbnails() {
        return a.c(this.thumbnails);
    }

    public String getUrl() {
        return this.url;
    }
}
