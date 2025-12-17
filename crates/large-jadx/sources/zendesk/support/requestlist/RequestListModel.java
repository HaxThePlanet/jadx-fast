package zendesk.support.requestlist;

import com.zendesk.service.a;
import com.zendesk.service.f;
import f.g.a.a;
import f.g.e.a;
import java.util.List;
import zendesk.core.MemoryCache;
import zendesk.support.AggregatedCallback;
import zendesk.support.SupportBlipsProvider;
import zendesk.support.SupportSdkSettings;
import zendesk.support.SupportSettingsProvider;

/* loaded from: classes3.dex */
class RequestListModel {

    static final String REQUEST_LIST_ITEMS_CACHE_KEY = "request_list_items";
    static final String SETTINGS_CACHE_KEY = "request_list_settings";
    private final SupportBlipsProvider blipsProvider;
    private final MemoryCache cache;
    private final a<zendesk.support.requestlist.RequestInfo, zendesk.support.requestlist.RequestListItem> mapper;
    private final zendesk.support.requestlist.RequestInfoDataSource requestInfoDataSource;
    private final AggregatedCallback<SupportSdkSettings> settingsAggregatedCallback;
    private final SupportSettingsProvider settingsProvider;
    RequestListModel(zendesk.support.requestlist.RequestInfoDataSource requestInfoDataSource, MemoryCache memoryCache2, SupportBlipsProvider supportBlipsProvider3, SupportSettingsProvider supportSettingsProvider4) {
        super();
        AggregatedCallback aggregatedCallback = new AggregatedCallback();
        this.settingsAggregatedCallback = aggregatedCallback;
        RequestListModel.2 anon = new RequestListModel.2(this);
        this.mapper = anon;
        this.requestInfoDataSource = requestInfoDataSource;
        this.cache = memoryCache2;
        this.blipsProvider = supportBlipsProvider3;
        this.settingsProvider = supportSettingsProvider4;
    }

    static List access$000(zendesk.support.requestlist.RequestListModel requestListModel, List list2, boolean z3) {
        return requestListModel.filterClosedRequests(list2, z3);
    }

    static a access$100(zendesk.support.requestlist.RequestListModel requestListModel) {
        return requestListModel.mapper;
    }

    static MemoryCache access$200(zendesk.support.requestlist.RequestListModel requestListModel) {
        return requestListModel.cache;
    }

    private List<zendesk.support.requestlist.RequestInfo> filterClosedRequests(List<zendesk.support.requestlist.RequestInfo> list, boolean z2) {
        if (z2) {
            return list;
        }
        RequestListModel.3 obj2 = new RequestListModel.3(this);
        return a.f(list, obj2);
    }

    void cacheSupportSdkSettings(SupportSdkSettings supportSdkSettings) {
        this.cache.put("request_list_settings", supportSdkSettings);
    }

    void cleanup() {
        this.cache.remove("request_list_settings");
        this.cache.remove("request_list_items");
    }

    List<zendesk.support.requestlist.RequestListItem> getCachedRequestInfos() {
        return (List)this.cache.get("request_list_items");
    }

    SupportSdkSettings getCachedSettings() {
        return (SupportSdkSettings)this.cache.get("request_list_settings");
    }

    void loadItems(boolean z, SupportSdkSettings supportSdkSettings2, f<List<zendesk.support.requestlist.RequestListItem>> f3) {
        zendesk.support.requestlist.RequestListModel.1 anon;
        Object obj2;
        if (z == null) {
            if (getCachedRequestInfos() == null) {
                anon = new RequestListModel.1(this, supportSdkSettings2, f3);
                this.requestInfoDataSource.load(anon);
            } else {
                f3.onSuccess(getCachedRequestInfos());
            }
        } else {
        }
    }

    void loadSettings(f<SupportSdkSettings> f) {
        AggregatedCallback settingsAggregatedCallback;
        boolean obj2;
        if (this.settingsAggregatedCallback.add(f)) {
            this.settingsProvider.getSettings(this.settingsAggregatedCallback);
        }
    }

    void trackRequestListViewed() {
        this.blipsProvider.requestListViewed();
    }
}
