package zendesk.support;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes3.dex */
class RawTicketFieldOption {

    private long id;
    @SerializedName("default")
    private boolean isDefault;
    private String name;
    private String rawName;
    private String value;
    public static zendesk.support.TicketFieldOption create(zendesk.support.RawTicketFieldOption rawTicketFieldOption) {
        super(rawTicketFieldOption.getId(), obj2, rawTicketFieldOption.getName(), rawTicketFieldOption.getValue(), rawTicketFieldOption.isDefault());
        return ticketFieldOption;
    }

    long getId() {
        return this.id;
    }

    String getName() {
        return this.name;
    }

    String getValue() {
        return this.value;
    }

    boolean isDefault() {
        return this.isDefault;
    }
}
