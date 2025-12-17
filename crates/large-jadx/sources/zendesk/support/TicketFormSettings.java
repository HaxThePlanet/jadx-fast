package zendesk.support;

/* loaded from: classes3.dex */
public class TicketFormSettings {

    private static zendesk.support.TicketFormSettings DEFAULT;
    private boolean available;
    static {
        TicketFormSettings ticketFormSettings = new TicketFormSettings(0);
        TicketFormSettings.DEFAULT = ticketFormSettings;
    }

    TicketFormSettings(boolean z) {
        super();
        this.available = z;
    }

    static zendesk.support.TicketFormSettings defaultSettings() {
        return TicketFormSettings.DEFAULT;
    }

    public boolean isAvailable() {
        return this.available;
    }
}
