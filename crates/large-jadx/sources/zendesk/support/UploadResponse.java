package zendesk.support;

import java.util.Date;

/* loaded from: classes3.dex */
public class UploadResponse {

    private zendesk.support.Attachment attachment;
    private Date expiresAt;
    private String token;
    public zendesk.support.Attachment getAttachment() {
        return this.attachment;
    }

    public Date getExpiresAt() {
        int date;
        long time;
        if (this.expiresAt == null) {
            date = 0;
        } else {
            date = new Date(this.expiresAt.getTime(), obj2);
        }
        return date;
    }

    public String getToken() {
        return this.token;
    }
}
