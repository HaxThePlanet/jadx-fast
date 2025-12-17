package zendesk.support;

import f.g.e.a;
import java.util.List;

/* loaded from: classes3.dex */
public class TicketForm {

    private long id;
    private String name;
    private List<zendesk.support.TicketField> ticketFields;
    public TicketForm(long l, String string2, List<zendesk.support.TicketField> list3) {
        super();
        this.id = l;
        this.name = list3;
        this.ticketFields = a.c(obj4);
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<zendesk.support.TicketField> getTicketFields() {
        return a.c(this.ticketFields);
    }
}
