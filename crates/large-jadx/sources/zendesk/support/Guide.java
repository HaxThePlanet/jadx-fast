package zendesk.support;

import f.g.c.a;
import java.util.Locale;
import zendesk.core.CoreModule;
import zendesk.core.Zendesk;

/* loaded from: classes3.dex */
public enum Guide {

    INSTANCE;

    zendesk.support.HelpCenterBlipsProvider blipsProvider;
    zendesk.support.GuideModule guideModule;
    private Locale helpCenterLocaleOverride;
    private zendesk.support.HelpCenterTracker helpCenterTracker;
    private boolean initialized;
    @Override // java.lang.Enum
    public Locale getHelpCenterLocaleOverride() {
        return this.helpCenterLocaleOverride;
    }

    @Override // java.lang.Enum
    public zendesk.support.GuideModule guideModule() {
        return this.guideModule;
    }

    @Override // java.lang.Enum
    public void init(Zendesk zendesk) {
        zendesk.support.HelpCenterTracker helpCenterTracker;
        boolean initialized;
        String str;
        int obj3;
        if (this.helpCenterTracker == null) {
            helpCenterTracker = new HelpCenterTracker.DefaultTracker();
            this.helpCenterTracker = helpCenterTracker;
        }
        if (zendesk.isInitialized()) {
            initApplicationScope(zendesk.coreModule());
            this.initialized = true;
        } else {
            a.e("Guide", "Cannot use Guide SDK without initializing Zendesk. Call Zendesk.INSTANCE.init(...)", new Object[0]);
        }
    }

    @Override // java.lang.Enum
    void initApplicationScope(CoreModule coreModule) {
        GuideProviderModule guideProviderModule = new GuideProviderModule(this.helpCenterTracker);
        DaggerGuideSdkProvidersComponent.builder().coreModule(coreModule).guideProviderModule(guideProviderModule).build().inject(this);
    }

    @Override // java.lang.Enum
    void installTracker(zendesk.support.HelpCenterTracker helpCenterTracker) {
        this.helpCenterTracker = helpCenterTracker;
        initApplicationScope(Zendesk.INSTANCE.coreModule());
    }

    @Override // java.lang.Enum
    public boolean isInitialized() {
        return this.initialized;
    }

    @Override // java.lang.Enum
    public zendesk.support.HelpCenterProvider provider() {
        if (!isInitialized()) {
            a.e("Guide", "Cannot get HelpCenterProvider before SDK has been initialized. init() must be called before provider().", new Object[0]);
            return null;
        }
        return this.guideModule.providesHelpCenterProvider();
    }

    @Override // java.lang.Enum
    void reset() {
        int i = 0;
        this.helpCenterTracker = i;
        this.helpCenterLocaleOverride = i;
        this.initialized = false;
    }

    @Override // java.lang.Enum
    public void setHelpCenterLocaleOverride(Locale locale) {
        this.helpCenterLocaleOverride = locale;
        initApplicationScope(Zendesk.INSTANCE.coreModule());
    }
}
