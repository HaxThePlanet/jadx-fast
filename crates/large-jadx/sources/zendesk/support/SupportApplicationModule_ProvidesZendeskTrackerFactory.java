package zendesk.support;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class SupportApplicationModule_ProvidesZendeskTrackerFactory implements b<zendesk.support.ZendeskTracker> {

    private final zendesk.support.SupportApplicationModule module;
    public SupportApplicationModule_ProvidesZendeskTrackerFactory(zendesk.support.SupportApplicationModule supportApplicationModule) {
        super();
        this.module = supportApplicationModule;
    }

    public static zendesk.support.SupportApplicationModule_ProvidesZendeskTrackerFactory create(zendesk.support.SupportApplicationModule supportApplicationModule) {
        SupportApplicationModule_ProvidesZendeskTrackerFactory supportApplicationModule_ProvidesZendeskTrackerFactory = new SupportApplicationModule_ProvidesZendeskTrackerFactory(supportApplicationModule);
        return supportApplicationModule_ProvidesZendeskTrackerFactory;
    }

    public static zendesk.support.ZendeskTracker providesZendeskTracker(zendesk.support.SupportApplicationModule supportApplicationModule) {
        final zendesk.support.ZendeskTracker obj1 = supportApplicationModule.providesZendeskTracker();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (ZendeskTracker)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.ZendeskTracker get() {
        return SupportApplicationModule_ProvidesZendeskTrackerFactory.providesZendeskTracker(this.module);
    }
}
