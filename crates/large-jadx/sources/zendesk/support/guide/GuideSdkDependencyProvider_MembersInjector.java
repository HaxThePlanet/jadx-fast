package zendesk.support.guide;

import g.a;
import j.a.a;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;

/* loaded from: classes3.dex */
public final class GuideSdkDependencyProvider_MembersInjector implements a<zendesk.support.guide.GuideSdkDependencyProvider> {

    private final a<ActionHandler> actionHandlerProvider;
    private final a<ActionHandlerRegistry> registryProvider;
    public GuideSdkDependencyProvider_MembersInjector(a<ActionHandlerRegistry> a, a<ActionHandler> a2) {
        super();
        this.registryProvider = a;
        this.actionHandlerProvider = a2;
    }

    public static a<zendesk.support.guide.GuideSdkDependencyProvider> create(a<ActionHandlerRegistry> a, a<ActionHandler> a2) {
        GuideSdkDependencyProvider_MembersInjector guideSdkDependencyProvider_MembersInjector = new GuideSdkDependencyProvider_MembersInjector(a, a2);
        return guideSdkDependencyProvider_MembersInjector;
    }

    public static void injectActionHandler(Object object, ActionHandler actionHandler2) {
        object.actionHandler = actionHandler2;
    }

    public static void injectRegistry(Object object, ActionHandlerRegistry actionHandlerRegistry2) {
        object.registry = actionHandlerRegistry2;
    }

    @Override // g.a
    public void injectMembers(Object object) {
        injectMembers((GuideSdkDependencyProvider)object);
    }

    @Override // g.a
    public void injectMembers(zendesk.support.guide.GuideSdkDependencyProvider guideSdkDependencyProvider) {
        GuideSdkDependencyProvider_MembersInjector.injectRegistry(guideSdkDependencyProvider, (ActionHandlerRegistry)this.registryProvider.get());
        GuideSdkDependencyProvider_MembersInjector.injectActionHandler(guideSdkDependencyProvider, (ActionHandler)this.actionHandlerProvider.get());
    }
}
