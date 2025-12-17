package zendesk.support.guide;

import g.a;
import j.a.a;
import o.a.b;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.NetworkInfoProvider;
import zendesk.support.HelpCenterProvider;
import zendesk.support.HelpCenterSettingsProvider;

/* loaded from: classes3.dex */
public final class HelpCenterActivity_MembersInjector implements a<zendesk.support.guide.HelpCenterActivity> {

    private final a<ActionHandlerRegistry> actionHandlerRegistryProvider;
    private final a<b> configurationHelperProvider;
    private final a<HelpCenterProvider> helpCenterProvider;
    private final a<NetworkInfoProvider> networkInfoProvider;
    private final a<HelpCenterSettingsProvider> settingsProvider;
    public HelpCenterActivity_MembersInjector(a<HelpCenterProvider> a, a<HelpCenterSettingsProvider> a2, a<NetworkInfoProvider> a3, a<ActionHandlerRegistry> a4, a<b> a5) {
        super();
        this.helpCenterProvider = a;
        this.settingsProvider = a2;
        this.networkInfoProvider = a3;
        this.actionHandlerRegistryProvider = a4;
        this.configurationHelperProvider = a5;
    }

    public static a<zendesk.support.guide.HelpCenterActivity> create(a<HelpCenterProvider> a, a<HelpCenterSettingsProvider> a2, a<NetworkInfoProvider> a3, a<ActionHandlerRegistry> a4, a<b> a5) {
        super(a, a2, a3, a4, a5);
        return helpCenterActivity_MembersInjector;
    }

    public static void injectActionHandlerRegistry(zendesk.support.guide.HelpCenterActivity helpCenterActivity, ActionHandlerRegistry actionHandlerRegistry2) {
        helpCenterActivity.actionHandlerRegistry = actionHandlerRegistry2;
    }

    public static void injectConfigurationHelper(zendesk.support.guide.HelpCenterActivity helpCenterActivity, b b2) {
        helpCenterActivity.configurationHelper = b2;
    }

    public static void injectHelpCenterProvider(zendesk.support.guide.HelpCenterActivity helpCenterActivity, HelpCenterProvider helpCenterProvider2) {
        helpCenterActivity.helpCenterProvider = helpCenterProvider2;
    }

    public static void injectNetworkInfoProvider(zendesk.support.guide.HelpCenterActivity helpCenterActivity, NetworkInfoProvider networkInfoProvider2) {
        helpCenterActivity.networkInfoProvider = networkInfoProvider2;
    }

    public static void injectSettingsProvider(zendesk.support.guide.HelpCenterActivity helpCenterActivity, HelpCenterSettingsProvider helpCenterSettingsProvider2) {
        helpCenterActivity.settingsProvider = helpCenterSettingsProvider2;
    }

    @Override // g.a
    public void injectMembers(Object object) {
        injectMembers((HelpCenterActivity)object);
    }

    @Override // g.a
    public void injectMembers(zendesk.support.guide.HelpCenterActivity helpCenterActivity) {
        HelpCenterActivity_MembersInjector.injectHelpCenterProvider(helpCenterActivity, (HelpCenterProvider)this.helpCenterProvider.get());
        HelpCenterActivity_MembersInjector.injectSettingsProvider(helpCenterActivity, (HelpCenterSettingsProvider)this.settingsProvider.get());
        HelpCenterActivity_MembersInjector.injectNetworkInfoProvider(helpCenterActivity, (NetworkInfoProvider)this.networkInfoProvider.get());
        HelpCenterActivity_MembersInjector.injectActionHandlerRegistry(helpCenterActivity, (ActionHandlerRegistry)this.actionHandlerRegistryProvider.get());
        HelpCenterActivity_MembersInjector.injectConfigurationHelper(helpCenterActivity, (b)this.configurationHelperProvider.get());
    }
}
