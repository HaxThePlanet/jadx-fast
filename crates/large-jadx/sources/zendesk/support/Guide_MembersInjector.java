package zendesk.support;

import g.a;
import j.a.a;

/* loaded from: classes3.dex */
public final class Guide_MembersInjector implements a<zendesk.support.Guide> {

    private final a<zendesk.support.HelpCenterBlipsProvider> blipsProvider;
    private final a<zendesk.support.GuideModule> guideModuleProvider;
    public Guide_MembersInjector(a<zendesk.support.GuideModule> a, a<zendesk.support.HelpCenterBlipsProvider> a2) {
        super();
        this.guideModuleProvider = a;
        this.blipsProvider = a2;
    }

    public static a<zendesk.support.Guide> create(a<zendesk.support.GuideModule> a, a<zendesk.support.HelpCenterBlipsProvider> a2) {
        Guide_MembersInjector guide_MembersInjector = new Guide_MembersInjector(a, a2);
        return guide_MembersInjector;
    }

    public static void injectBlipsProvider(zendesk.support.Guide guide, zendesk.support.HelpCenterBlipsProvider helpCenterBlipsProvider2) {
        guide.blipsProvider = helpCenterBlipsProvider2;
    }

    public static void injectGuideModule(zendesk.support.Guide guide, zendesk.support.GuideModule guideModule2) {
        guide.guideModule = guideModule2;
    }

    @Override // g.a
    public void injectMembers(Object object) {
        injectMembers((Guide)object);
    }

    @Override // g.a
    public void injectMembers(zendesk.support.Guide guide) {
        Guide_MembersInjector.injectGuideModule(guide, (GuideModule)this.guideModuleProvider.get());
        Guide_MembersInjector.injectBlipsProvider(guide, (HelpCenterBlipsProvider)this.blipsProvider.get());
    }
}
