package zendesk.support;

/* loaded from: classes3.dex */
public class TicketFieldOption {

    private long id;
    private boolean isDefault;
    private String name;
    private String value;
    TicketFieldOption(long l, String string2, String string3, boolean z4) {
        super();
        this.id = l;
        this.name = string3;
        this.value = z4;
        this.isDefault = obj5;
    }

    static zendesk.support.TicketFieldOption create(zendesk.support.RawTicketFieldOption rawTicketFieldOption) {
        super(rawTicketFieldOption.getId(), obj2, rawTicketFieldOption.getName(), rawTicketFieldOption.getValue(), rawTicketFieldOption.isDefault());
        return ticketFieldOption;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public boolean isDefault() {
        return this.isDefault;
    }
}
