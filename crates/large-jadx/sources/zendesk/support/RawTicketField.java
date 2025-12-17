package zendesk.support;

import com.google.gson.annotations.SerializedName;
import f.g.e.a;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
class RawTicketField {

    private long accountId;
    @SerializedName("isActive")
    private boolean active;
    @SerializedName("isCollapsedForAgents")
    private boolean collapsedForAgents;
    private Date createdAt;
    private List<zendesk.support.RawTicketFieldOption> customFieldOptions;
    private String defaultContentKey;
    private String description;
    @SerializedName("isEditableInPortal")
    private boolean editableInPortal;
    @SerializedName("isExportable")
    private boolean exportable;
    private long id;
    private int position;
    private String regexpForValidation;
    @SerializedName("isRequired")
    private boolean required;
    @SerializedName("isRequiredInPortal")
    private boolean requiredInPortal;
    private long subTypeId;
    private List<zendesk.support.RawTicketFieldSystemOption> systemFieldOptions;
    private String tag;
    private String title;
    private String titleInPortal;
    private zendesk.support.TicketFieldType type;
    private Date updatedAt;
    @SerializedName("isVisibleInPortal")
    private boolean visibleInPortal;
    List<zendesk.support.RawTicketFieldOption> getCustomFieldOptions() {
        return a.c(this.customFieldOptions);
    }

    String getDescription() {
        return this.description;
    }

    long getId() {
        return this.id;
    }

    String getRegexpForValidation() {
        return this.regexpForValidation;
    }

    List<zendesk.support.RawTicketFieldSystemOption> getSystemFieldOptions() {
        return a.c(this.systemFieldOptions);
    }

    String getTitle() {
        return this.title;
    }

    String getTitleInPortal() {
        return this.titleInPortal;
    }

    zendesk.support.TicketFieldType getType() {
        return this.type;
    }
}
