package zendesk.support;

import f.g.e.a;
import java.util.List;

/* loaded from: classes3.dex */
class RawTicketFormResponse {

    private List<zendesk.support.RawTicketField> ticketFields;
    private List<zendesk.support.RawTicketForm> ticketForms;
    List<zendesk.support.RawTicketField> getTicketFields() {
        return a.c(this.ticketFields);
    }

    List<zendesk.support.RawTicketForm> getTicketForms() {
        return a.c(this.ticketForms);
    }
}
