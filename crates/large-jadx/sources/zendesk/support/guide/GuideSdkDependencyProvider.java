package zendesk.support.guide;

import java.util.UUID;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.Zendesk;
import zendesk.support.Guide;
import zendesk.support.GuideModule;

/* loaded from: classes3.dex */
enum GuideSdkDependencyProvider {

    INSTANCE;

    ActionHandler actionHandler;
    private zendesk.support.guide.GuideSdkComponent guideSdkComponent;
    private UUID id;
    ActionHandlerRegistry registry;
    @Override // java.lang.Enum
    public void initForTesting(zendesk.support.guide.GuideSdkComponent guideSdkComponent, UUID uUID2) {
        this.guideSdkComponent = guideSdkComponent;
        this.id = uUID2;
    }

    @Override // java.lang.Enum
    public boolean isInitialized() {
        boolean initialized;
        int i;
        if (Zendesk.INSTANCE.isInitialized() && Guide.INSTANCE.isInitialized()) {
            i = Guide.INSTANCE.isInitialized() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.lang.Enum
    public zendesk.support.guide.GuideSdkComponent provideGuideSdkComponent() {
        Object guideModule;
        boolean actionHandler;
        Object coreModule;
        guideModule = Guide.INSTANCE.guideModule();
        if (guideModule != null) {
            if (!guideModule.getId().equals(this.id)) {
                this.guideSdkComponent = DaggerGuideSdkComponent.builder().coreModule(Zendesk.INSTANCE.coreModule()).guideModule(guideModule).build();
                this.id = guideModule.getId();
                this.guideSdkComponent.inject(this);
                this.registry.add(this.actionHandler);
            }
        } else {
        }
        return this.guideSdkComponent;
    }
}
