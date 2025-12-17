package zendesk.support;

import f.g.e.a;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class Attachment implements Serializable {

    private String contentType;
    private String contentUrl;
    private String fileName;
    private Long height;
    private Long id;
    private String mappedContentUrl;
    private Long size;
    private List<zendesk.support.Attachment> thumbnails;
    private String url;
    private Long width;
    @Override // java.io.Serializable
    public String getContentType() {
        return this.contentType;
    }

    @Override // java.io.Serializable
    public String getContentUrl() {
        return this.contentUrl;
    }

    @Override // java.io.Serializable
    public String getFileName() {
        return this.fileName;
    }

    @Override // java.io.Serializable
    public Long getHeight() {
        return this.height;
    }

    @Override // java.io.Serializable
    public Long getId() {
        return this.id;
    }

    @Override // java.io.Serializable
    public Long getSize() {
        return this.size;
    }

    public List<zendesk.support.Attachment> getThumbnails() {
        return a.c(this.thumbnails);
    }

    @Override // java.io.Serializable
    public String getUrl() {
        return this.url;
    }

    @Override // java.io.Serializable
    public Long getWidth() {
        return this.width;
    }
}
