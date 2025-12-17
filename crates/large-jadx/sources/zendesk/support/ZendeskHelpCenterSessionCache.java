package zendesk.support;

/* loaded from: classes3.dex */
class ZendeskHelpCenterSessionCache implements zendesk.support.HelpCenterSessionCache {

    public static final zendesk.support.LastSearch DEFAULT_SEARCH;
    private zendesk.support.LastSearch lastSearch;
    private boolean uniqueSearchResultClick = false;
    static {
        LastSearch lastSearch = new LastSearch("", 0);
        ZendeskHelpCenterSessionCache.DEFAULT_SEARCH = lastSearch;
    }

    ZendeskHelpCenterSessionCache() {
        super();
        final int i = 0;
    }

    @Override // zendesk.support.HelpCenterSessionCache
    public zendesk.support.LastSearch getLastSearch() {
        zendesk.support.LastSearch dEFAULT_SEARCH;
        if (this.lastSearch != null) {
        } else {
            dEFAULT_SEARCH = ZendeskHelpCenterSessionCache.DEFAULT_SEARCH;
        }
        return dEFAULT_SEARCH;
    }

    @Override // zendesk.support.HelpCenterSessionCache
    public boolean isUniqueSearchResultClick() {
        return this.uniqueSearchResultClick;
    }

    @Override // zendesk.support.HelpCenterSessionCache
    public void setLastSearch(String string, int i2) {
        LastSearch lastSearch = new LastSearch(string, i2);
        this.lastSearch = lastSearch;
        this.uniqueSearchResultClick = true;
    }

    @Override // zendesk.support.HelpCenterSessionCache
    public void unsetUniqueSearchResultClick() {
        this.uniqueSearchResultClick = false;
    }
}
