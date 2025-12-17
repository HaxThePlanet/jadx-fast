package zendesk.support;

import g.a;
import j.a.a;
import java.util.List;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;

/* loaded from: classes3.dex */
public final class SdkDependencyProvider_MembersInjector implements a<zendesk.support.SdkDependencyProvider> {

    private final a<List<ActionHandler>> actionHandlersProvider;
    private final a<ActionHandlerRegistry> registryProvider;
    public SdkDependencyProvider_MembersInjector(a<ActionHandlerRegistry> a, a<List<ActionHandler>> a2) {
        super();
        this.registryProvider = a;
        this.actionHandlersProvider = a2;
    }

    public static a<zendesk.support.SdkDependencyProvider> create(a<ActionHandlerRegistry> a, a<List<ActionHandler>> a2) {
        SdkDependencyProvider_MembersInjector sdkDependencyProvider_MembersInjector = new SdkDependencyProvider_MembersInjector(a, a2);
        return sdkDependencyProvider_MembersInjector;
    }

    public static void injectActionHandlers(zendesk.support.SdkDependencyProvider sdkDependencyProvider, List<ActionHandler> list2) {
        sdkDependencyProvider.actionHandlers = list2;
    }

    public static void injectRegistry(zendesk.support.SdkDependencyProvider sdkDependencyProvider, ActionHandlerRegistry actionHandlerRegistry2) {
        sdkDependencyProvider.registry = actionHandlerRegistry2;
    }

    @Override // g.a
    public void injectMembers(Object object) {
        injectMembers((SdkDependencyProvider)object);
    }

    @Override // g.a
    public void injectMembers(zendesk.support.SdkDependencyProvider sdkDependencyProvider) {
        SdkDependencyProvider_MembersInjector.injectRegistry(sdkDependencyProvider, (ActionHandlerRegistry)this.registryProvider.get());
        SdkDependencyProvider_MembersInjector.injectActionHandlers(sdkDependencyProvider, (List)this.actionHandlersProvider.get());
    }
}
