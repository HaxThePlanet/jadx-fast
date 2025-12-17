package zendesk.support;

import com.google.gson.annotations.SerializedName;
import f.g.e.a;
import java.util.Date;
import java.util.List;

/* loaded from: classes3.dex */
class RawTicketForm {

    private Date createdAt;
    private boolean endUserVisible;
    private long id;
    private boolean inAllBrands;
    private boolean inAllOrganizations;
    @SerializedName("active")
    private boolean isActive;
    @SerializedName("default")
    private boolean isDefault;
    private String name;
    private int position;
    private String rawDisplayName;
    private String rawName;
    private List<Long> restrictedBrandIds;
    private List<Long> restrictedOrganizationIds;
    private List<Long> ticketFieldIds;
    private Date updatedAt;
    private String url;
    public static zendesk.support.TicketForm create(zendesk.support.RawTicketForm rawTicketForm, List<zendesk.support.TicketField> list2) {
        TicketForm ticketForm = new TicketForm(rawTicketForm.getId(), obj2, rawTicketForm.getName(), list2);
        return ticketForm;
    }

    long getId() {
        return this.id;
    }

    String getName() {
        return this.name;
    }

    List<Long> getTicketFieldIds() {
        return a.c(this.ticketFieldIds);
    }
}
