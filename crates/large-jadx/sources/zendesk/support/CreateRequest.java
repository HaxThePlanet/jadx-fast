package zendesk.support;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class CreateRequest {

    private static final transient String METADATA_SDK_KEY = "sdk";
    private zendesk.support.Comment comment;
    private List<zendesk.support.CustomField> customFields;
    private String id;
    private Map<String, Map<String, String>> metadata;
    private String subject;
    private List<String> tags;
    private Long ticketFormId;
    public List<String> getAttachments() {
        zendesk.support.Comment comment = this.comment;
        if (comment == null) {
            return Collections.emptyList();
        }
        return comment.getAttachments();
    }

    public List<zendesk.support.CustomField> getCustomFields() {
        return this.customFields;
    }

    public String getDescription() {
        int body;
        zendesk.support.Comment comment = this.comment;
        if (comment == null) {
            body = 0;
        } else {
            body = comment.getBody();
        }
        return body;
    }

    public String getId() {
        return this.id;
    }

    public String getSubject() {
        return this.subject;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public Long getTicketFormId() {
        return this.ticketFormId;
    }

    public void setAttachments(List<String> list) {
        zendesk.support.Comment comment;
        if (this.comment == null) {
            comment = new Comment();
            this.comment = comment;
        }
        this.comment.setAttachments(list);
    }

    public void setCustomFields(List<zendesk.support.CustomField> list) {
        this.customFields = list;
    }

    public void setDescription(String string) {
        zendesk.support.Comment comment;
        if (this.comment == null) {
            comment = new Comment();
            this.comment = comment;
        }
        this.comment.setBody(string);
    }

    public void setId(String string) {
        this.id = string;
    }

    public void setMetadata(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        this.metadata = hashMap;
        hashMap.put("sdk", map);
    }

    public void setSubject(String string) {
        this.subject = string;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public void setTicketFormId(Long long) {
        this.ticketFormId = long;
    }
}
