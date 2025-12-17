package zendesk.core;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

/* loaded from: classes3.dex */
public class CoreSettings implements zendesk.core.Settings {

    private zendesk.core.AuthenticationType authentication;
    @SerializedName("brand_id")
    private String brandId;
    private String identifier;
    @SerializedName("updated_at")
    private Date updatedAt;
    CoreSettings(Date date, zendesk.core.AuthenticationType authenticationType2) {
        super();
        this.updatedAt = date;
        this.authentication = authenticationType2;
    }

    @Override // zendesk.core.Settings
    public zendesk.core.AuthenticationType getAuthentication() {
        return this.authentication;
    }

    @Override // zendesk.core.Settings
    Date getUpdatedAt() {
        if (this.updatedAt != null) {
            Date date = new Date(this.updatedAt.getTime(), obj2);
            return date;
        }
        Date date2 = new Date(0, obj2);
        return date2;
    }
}
