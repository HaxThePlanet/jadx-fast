package zendesk.support;

import java.util.Locale;

/* loaded from: classes3.dex */
class ApplicationScope {

    private final Locale locale;
    private final zendesk.support.ZendeskTracker zendeskTracker;

    static class Builder {

        private Locale locale;
        private zendesk.support.ZendeskTracker zendeskTracker;
        Builder() {
            super();
            this.locale = Locale.getDefault();
            ZendeskTracker.DefaultTracker defaultTracker = new ZendeskTracker.DefaultTracker();
            this.zendeskTracker = defaultTracker;
        }

        Builder(zendesk.support.ApplicationScope applicationScope) {
            super();
            this.locale = applicationScope.getLocale();
        }

        static Locale access$000(zendesk.support.ApplicationScope.Builder applicationScope$Builder) {
            return builder.locale;
        }

        static zendesk.support.ZendeskTracker access$100(zendesk.support.ApplicationScope.Builder applicationScope$Builder) {
            return builder.zendeskTracker;
        }

        zendesk.support.ApplicationScope build() {
            ApplicationScope applicationScope = new ApplicationScope(this, 0);
            return applicationScope;
        }

        zendesk.support.ApplicationScope.Builder locale(Locale locale) {
            this.locale = locale;
            return this;
        }

        zendesk.support.ApplicationScope.Builder zendeskTracker(zendesk.support.ZendeskTracker zendeskTracker) {
            this.zendeskTracker = zendeskTracker;
            return this;
        }
    }
    private ApplicationScope(zendesk.support.ApplicationScope.Builder applicationScope$Builder) {
        super();
        this.locale = ApplicationScope.Builder.access$000(builder);
        this.zendeskTracker = ApplicationScope.Builder.access$100(builder);
    }

    ApplicationScope(zendesk.support.ApplicationScope.Builder applicationScope$Builder, zendesk.support.ApplicationScope.1 applicationScope$12) {
        super(builder);
    }

    public Locale getLocale() {
        return this.locale;
    }

    public zendesk.support.ZendeskTracker getZendeskTracker() {
        return this.zendeskTracker;
    }

    public zendesk.support.ApplicationScope.Builder newBuilder() {
        ApplicationScope.Builder builder = new ApplicationScope.Builder(this);
        return builder;
    }
}
