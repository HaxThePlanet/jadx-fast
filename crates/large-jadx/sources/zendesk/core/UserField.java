package zendesk.core;

import com.google.gson.annotations.SerializedName;
import f.g.e.a;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
public class UserField {

    private Boolean active;
    private Date createdAt;
    private List<zendesk.core.UserFieldOption> customFieldOptions;
    private String description;
    private Long id;
    private String key;
    private Long position;
    private String rawDescription;
    private String rawTitle;
    private String regexpForValidation;
    private Boolean system;
    private String title;
    private Date updatedAt;
    private String url;
    @SerializedName("type")
    private zendesk.core.UserField.UserFieldType userFieldType;

    public static enum UserFieldType {

        Integer,
        Decimal,
        Checkbox,
        Date,
        Text,
        Textarea,
        Dropdown,
        Regexp;
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

    public String getDescription() {
        return this.description;
    }

    public Long getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public Long getPosition() {
        return this.position;
    }

    public String getRawDescription() {
        return this.rawDescription;
    }

    public String getRawTitle() {
        return this.rawTitle;
    }

    public String getRegexpForValidation() {
        return this.regexpForValidation;
    }

    public String getTitle() {
        return this.title;
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

    public List<zendesk.core.UserFieldOption> getUserFieldOptions() {
        return a.c(this.customFieldOptions);
    }

    public zendesk.core.UserField.UserFieldType getUserFieldType() {
        return this.userFieldType;
    }

    public boolean isActive() {
        Boolean booleanValue;
        int i;
        booleanValue = this.active;
        if (booleanValue != null && booleanValue.booleanValue()) {
            i = booleanValue.booleanValue() ? 1 : 0;
        } else {
        }
        return i;
    }

    public boolean isSystem() {
        Boolean booleanValue;
        int i;
        booleanValue = this.system;
        if (booleanValue != null && booleanValue.booleanValue()) {
            i = booleanValue.booleanValue() ? 1 : 0;
        } else {
        }
        return i;
    }
}
