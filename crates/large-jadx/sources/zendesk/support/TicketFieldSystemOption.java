package zendesk.support;

/* loaded from: classes3.dex */
public class TicketFieldSystemOption {

    private String name;
    private String value;
    TicketFieldSystemOption(String string, String string2) {
        super();
        this.name = string;
        this.value = string2;
    }

    static zendesk.support.TicketFieldSystemOption create(zendesk.support.RawTicketFieldSystemOption rawTicketFieldSystemOption) {
        TicketFieldSystemOption ticketFieldSystemOption = new TicketFieldSystemOption(rawTicketFieldSystemOption.getName(), rawTicketFieldSystemOption.getValue());
        return ticketFieldSystemOption;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }
}
