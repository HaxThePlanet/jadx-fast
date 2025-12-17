package zendesk.support.guide;

import com.zendesk.service.f;
import java.util.List;
import zendesk.support.HelpCenterProvider;
import zendesk.support.HelpCenterSearch.Builder;
import zendesk.support.HelpCenterSettings;
import zendesk.support.HelpCenterSettingsProvider;
import zendesk.support.SearchArticle;

/* loaded from: classes3.dex */
class HelpCenterModel implements zendesk.support.guide.HelpCenterMvp.Model {

    private final HelpCenterProvider provider;
    private final HelpCenterSettingsProvider settingsProvider;
    HelpCenterModel(HelpCenterProvider helpCenterProvider, HelpCenterSettingsProvider helpCenterSettingsProvider2) {
        super();
        this.provider = helpCenterProvider;
        this.settingsProvider = helpCenterSettingsProvider2;
    }

    public void getSettings(f<HelpCenterSettings> f) {
        this.settingsProvider.getSettings(f);
    }

    public void search(List<Long> list, List<Long> list2, String string3, String[] string4Arr4, f<List<SearchArticle>> f5) {
        HelpCenterSearch.Builder builder = new HelpCenterSearch.Builder();
        this.provider.searchArticles(builder.withQuery(string3).withCategoryIds(list).withSectionIds(list2).withLabelNames(string4Arr4).build(), f5);
    }
}
