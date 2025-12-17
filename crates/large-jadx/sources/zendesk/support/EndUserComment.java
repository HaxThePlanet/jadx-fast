package zendesk.support;

import com.google.gson.annotations.SerializedName;
import f.g.e.a;
import java.util.List;

/* loaded from: classes3.dex */
public class EndUserComment {

    @SerializedName("uploads")
    private List<String> attachments;
    private String value;
    public List<String> getAttachments() {
        return a.c(this.attachments);
    }

    public void setAttachments(List<String> list) {
        this.attachments = list;
    }

    public void setValue(String string) {
        this.value = string;
    }
}
