package zendesk.support;

/* loaded from: classes3.dex */
interface HelpCenterSessionCache {
    public abstract zendesk.support.LastSearch getLastSearch();

    public abstract boolean isUniqueSearchResultClick();

    public abstract void setLastSearch(String string, int i2);

    public abstract void unsetUniqueSearchResultClick();
}
