package zendesk.core;

import java.util.Locale;

/* loaded from: classes3.dex */
class SessionConfiguration {

    private zendesk.core.Identity identity;
    private Locale locale;

    static class Builder {

        private zendesk.core.Identity identity;
        private Locale locale;
        Builder() {
            super();
            SessionConfiguration.Builder.1 anon = new SessionConfiguration.Builder.1(this);
            this.identity = anon;
            this.locale = Locale.getDefault();
        }

        private Builder(zendesk.core.SessionConfiguration sessionConfiguration) {
            super();
            SessionConfiguration.Builder.1 anon = new SessionConfiguration.Builder.1(this);
            this.identity = anon;
            this.locale = Locale.getDefault();
            this.identity = sessionConfiguration.getIdentity();
        }

        Builder(zendesk.core.SessionConfiguration sessionConfiguration, zendesk.core.SessionConfiguration.1 sessionConfiguration$12) {
            super(sessionConfiguration);
        }

        static zendesk.core.Identity access$000(zendesk.core.SessionConfiguration.Builder sessionConfiguration$Builder) {
            return builder.identity;
        }

        static Locale access$100(zendesk.core.SessionConfiguration.Builder sessionConfiguration$Builder) {
            return builder.locale;
        }

        public zendesk.core.SessionConfiguration build() {
            SessionConfiguration sessionConfiguration = new SessionConfiguration(this, 0);
            return sessionConfiguration;
        }

        zendesk.core.SessionConfiguration.Builder setIdentity(zendesk.core.Identity identity) {
            this.identity = identity;
            return this;
        }

        zendesk.core.SessionConfiguration.Builder setLocale(Locale locale) {
            this.locale = locale;
            return this;
        }
    }
    private SessionConfiguration(zendesk.core.SessionConfiguration.Builder sessionConfiguration$Builder) {
        super();
        this.identity = SessionConfiguration.Builder.access$000(builder);
        this.locale = SessionConfiguration.Builder.access$100(builder);
    }

    SessionConfiguration(zendesk.core.SessionConfiguration.Builder sessionConfiguration$Builder, zendesk.core.SessionConfiguration.1 sessionConfiguration$12) {
        super(builder);
    }

    zendesk.core.Identity getIdentity() {
        return this.identity;
    }

    Locale getLocale() {
        return this.locale;
    }

    zendesk.core.SessionConfiguration.Builder newBuilder() {
        SessionConfiguration.Builder builder = new SessionConfiguration.Builder(this, 0);
        return builder;
    }
}
