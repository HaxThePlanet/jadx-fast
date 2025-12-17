package zendesk.support;

import java.util.List;

/* loaded from: classes3.dex */
interface RequestSessionCache {
    public abstract boolean containsAllTicketForms(List<Long> list);

    public abstract List<zendesk.support.TicketForm> getTicketFormsById(List<Long> list);

    public abstract void updateTicketFormCache(List<zendesk.support.TicketForm> list);
}
