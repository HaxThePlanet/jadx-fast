package zendesk.support.guide;

import g.a;
import j.a.a;
import zendesk.core.NetworkInfoProvider;
import zendesk.support.HelpCenterProvider;

/* loaded from: classes3.dex */
public final class HelpCenterFragment_MembersInjector implements a<zendesk.support.guide.HelpCenterFragment> {

    private final a<HelpCenterProvider> helpCenterProvider;
    private final a<NetworkInfoProvider> networkInfoProvider;
    public HelpCenterFragment_MembersInjector(a<HelpCenterProvider> a, a<NetworkInfoProvider> a2) {
        super();
        this.helpCenterProvider = a;
        this.networkInfoProvider = a2;
    }

    public static a<zendesk.support.guide.HelpCenterFragment> create(a<HelpCenterProvider> a, a<NetworkInfoProvider> a2) {
        HelpCenterFragment_MembersInjector helpCenterFragment_MembersInjector = new HelpCenterFragment_MembersInjector(a, a2);
        return helpCenterFragment_MembersInjector;
    }

    public static void injectHelpCenterProvider(zendesk.support.guide.HelpCenterFragment helpCenterFragment, HelpCenterProvider helpCenterProvider2) {
        helpCenterFragment.helpCenterProvider = helpCenterProvider2;
    }

    public static void injectNetworkInfoProvider(zendesk.support.guide.HelpCenterFragment helpCenterFragment, NetworkInfoProvider networkInfoProvider2) {
        helpCenterFragment.networkInfoProvider = networkInfoProvider2;
    }

    @Override // g.a
    public void injectMembers(Object object) {
        injectMembers((HelpCenterFragment)object);
    }

    @Override // g.a
    public void injectMembers(zendesk.support.guide.HelpCenterFragment helpCenterFragment) {
        HelpCenterFragment_MembersInjector.injectHelpCenterProvider(helpCenterFragment, (HelpCenterProvider)this.helpCenterProvider.get());
        HelpCenterFragment_MembersInjector.injectNetworkInfoProvider(helpCenterFragment, (NetworkInfoProvider)this.networkInfoProvider.get());
    }
}
