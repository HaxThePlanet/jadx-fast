package zendesk.support;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.Zendesk;
import zendesk.support.requestlist.RequestListActivity;
import zendesk.support.requestlist.RequestListComponent;
import zendesk.support.requestlist.RequestListConfiguration;
import zendesk.support.requestlist.RequestListModule;
import zendesk.support.requestlist.RequestListViewModule;

/* loaded from: classes3.dex */
public enum SdkDependencyProvider {

    INSTANCE;

    List<ActionHandler> actionHandlers;
    private UUID id;
    ActionHandlerRegistry registry;
    private RequestListModule requestListModule;
    private zendesk.support.SupportSdkComponent supportSdkComponent;
    private void registerActionHandlers() {
        Object next;
        ActionHandlerRegistry registry;
        Iterator iterator = this.actionHandlers.iterator();
        for (ActionHandler next : iterator) {
            this.registry.add(next);
        }
    }

    @Override // java.lang.Enum
    void initForTesting(zendesk.support.SupportSdkComponent supportSdkComponent, UUID uUID2) {
        this.supportSdkComponent = supportSdkComponent;
        this.id = uUID2;
    }

    @Override // java.lang.Enum
    void initForTesting(zendesk.support.SupportSdkComponent supportSdkComponent, UUID uUID2, RequestListModule requestListModule3) {
        initForTesting(supportSdkComponent, uUID2);
        this.requestListModule = requestListModule3;
    }

    @Override // java.lang.Enum
    public boolean isInitialized() {
        int i;
        boolean iNSTANCE;
        boolean initialized;
        iNSTANCE = Support.INSTANCE;
        if (Zendesk.INSTANCE.isInitialized() && iNSTANCE.isInitialized() && iNSTANCE.isAuthenticated()) {
            iNSTANCE = Support.INSTANCE;
            if (iNSTANCE.isInitialized()) {
                i = iNSTANCE.isAuthenticated() ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // java.lang.Enum
    public RequestListComponent provideRequestListComponent(RequestListActivity requestListActivity, RequestListConfiguration requestListConfiguration2) {
        RequestListModule requestListModule;
        if (this.requestListModule == null) {
            requestListModule = new RequestListModule();
            this.requestListModule = requestListModule;
        }
        RequestListViewModule requestListViewModule = new RequestListViewModule(requestListActivity, requestListConfiguration2);
        return provideSupportSdkComponent().plus(this.requestListModule, requestListViewModule);
    }

    @Override // java.lang.Enum
    public zendesk.support.SupportSdkComponent provideSupportSdkComponent() {
        Object supportSdkComponent2;
        boolean equals;
        Object supportSdkComponent;
        zendesk.core.CoreModule coreModule;
        supportSdkComponent2 = Support.INSTANCE.getSupportModule();
        if (this.supportSdkComponent != null) {
            if (!supportSdkComponent2.getId().equals(this.id)) {
                SupportSdkModule supportSdkModule = new SupportSdkModule();
                this.supportSdkComponent = DaggerSupportSdkComponent.builder().coreModule(Zendesk.INSTANCE.coreModule()).supportModule(supportSdkComponent2).supportSdkModule(supportSdkModule).build();
                this.id = supportSdkComponent2.getId();
                this.supportSdkComponent.inject(this);
                registerActionHandlers();
            }
        } else {
        }
        return this.supportSdkComponent;
    }
}
