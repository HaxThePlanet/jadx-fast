package zendesk.support;

import g.a;
import j.a.a;
import zendesk.core.ActionHandlerRegistry;

/* loaded from: classes3.dex */
public final class DeepLinkingBroadcastReceiver_MembersInjector implements a<zendesk.support.DeepLinkingBroadcastReceiver> {

    private final a<ActionHandlerRegistry> registryProvider;
    public DeepLinkingBroadcastReceiver_MembersInjector(a<ActionHandlerRegistry> a) {
        super();
        this.registryProvider = a;
    }

    public static a<zendesk.support.DeepLinkingBroadcastReceiver> create(a<ActionHandlerRegistry> a) {
        DeepLinkingBroadcastReceiver_MembersInjector deepLinkingBroadcastReceiver_MembersInjector = new DeepLinkingBroadcastReceiver_MembersInjector(a);
        return deepLinkingBroadcastReceiver_MembersInjector;
    }

    public static void injectRegistry(zendesk.support.DeepLinkingBroadcastReceiver deepLinkingBroadcastReceiver, ActionHandlerRegistry actionHandlerRegistry2) {
        deepLinkingBroadcastReceiver.registry = actionHandlerRegistry2;
    }

    @Override // g.a
    public void injectMembers(Object object) {
        injectMembers((DeepLinkingBroadcastReceiver)object);
    }

    @Override // g.a
    public void injectMembers(zendesk.support.DeepLinkingBroadcastReceiver deepLinkingBroadcastReceiver) {
        DeepLinkingBroadcastReceiver_MembersInjector.injectRegistry(deepLinkingBroadcastReceiver, (ActionHandlerRegistry)this.registryProvider.get());
    }
}
