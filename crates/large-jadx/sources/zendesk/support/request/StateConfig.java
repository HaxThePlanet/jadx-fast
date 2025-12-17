package zendesk.support.request;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import o.b.o;

/* loaded from: classes3.dex */
class StateConfig implements Serializable {

    static final long MAX_ATTACHMENTS_SIZE_UNAVAILABLE = -1L;
    private final zendesk.support.request.StateSettings settings;
    private final String subject;
    private final List<String> tags;
    private final zendesk.support.request.StateRequestTicketForm ticketForm;

    static class Builder {

        private zendesk.support.request.StateSettings settings;
        private String subject;
        private List<String> tags;
        private zendesk.support.request.StateRequestTicketForm ticketForm;
        private Builder(zendesk.support.request.StateSettings stateSettings, List<String> list2, String string3, zendesk.support.request.StateRequestTicketForm stateRequestTicketForm4) {
            super();
            this.settings = stateSettings;
            this.tags = list2;
            this.subject = string3;
            this.ticketForm = stateRequestTicketForm4;
        }

        Builder(zendesk.support.request.StateSettings stateSettings, List list2, String string3, zendesk.support.request.StateRequestTicketForm stateRequestTicketForm4, zendesk.support.request.StateConfig.1 stateConfig$15) {
            super(stateSettings, list2, string3, stateRequestTicketForm4);
        }

        zendesk.support.request.StateConfig build() {
            super(this.settings, this.tags, this.subject, this.ticketForm, 0);
            return stateConfig2;
        }

        zendesk.support.request.StateConfig.Builder setSettings(zendesk.support.request.StateSettings stateSettings) {
            this.settings = stateSettings;
            return this;
        }

        zendesk.support.request.StateConfig.Builder setSubject(String string) {
            this.subject = string;
            return this;
        }

        zendesk.support.request.StateConfig.Builder setTags(List<String> list) {
            this.tags = list;
            return this;
        }

        zendesk.support.request.StateConfig.Builder setTicketForm(zendesk.support.request.StateRequestTicketForm stateRequestTicketForm) {
            this.ticketForm = stateRequestTicketForm;
            return this;
        }
    }
    StateConfig() {
        super();
        StateSettings stateSettings = new StateSettings();
        this.settings = stateSettings;
        ArrayList arrayList = new ArrayList();
        this.tags = arrayList;
        this.subject = "";
        this.ticketForm = 0;
    }

    private StateConfig(zendesk.support.request.StateSettings stateSettings, List<String> list2, String string3, zendesk.support.request.StateRequestTicketForm stateRequestTicketForm4) {
        super();
        this.settings = stateSettings;
        this.tags = list2;
        this.subject = string3;
        this.ticketForm = stateRequestTicketForm4;
    }

    StateConfig(zendesk.support.request.StateSettings stateSettings, List list2, String string3, zendesk.support.request.StateRequestTicketForm stateRequestTicketForm4, zendesk.support.request.StateConfig.1 stateConfig$15) {
        super(stateSettings, list2, string3, stateRequestTicketForm4);
    }

    static zendesk.support.request.StateConfig fromState(o o) {
        Object obj1 = o.b(StateConfig.class);
        if ((StateConfig)obj1 != null) {
            return (StateConfig)obj1;
        }
        obj1 = new StateConfig();
        return obj1;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateSettings getSettings() {
        return this.settings;
    }

    @Override // java.io.Serializable
    String getSubject() {
        return this.subject;
    }

    List<String> getTags() {
        return this.tags;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateRequestTicketForm getTicketForm() {
        return this.ticketForm;
    }

    @Override // java.io.Serializable
    zendesk.support.request.StateConfig.Builder newBuilder() {
        super(this.settings, this.tags, this.subject, this.ticketForm, 0);
        return builder2;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Config{settings=");
        stringBuilder.append(this.settings);
        stringBuilder.append(", subject='");
        stringBuilder.append(this.subject);
        stringBuilder.append('\'');
        stringBuilder.append(", ticketForm=");
        stringBuilder.append(this.ticketForm);
        stringBuilder.append(", tags=");
        stringBuilder.append(this.tags);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
