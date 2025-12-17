package zendesk.core;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* loaded from: classes3.dex */
class BlipsRequest {

    @SerializedName("appId")
    private String appId;
    private String channel;
    @SerializedName("pageView")
    private zendesk.core.BlipsRequest.ApiPageView pageView;
    @SerializedName("schemaVersion")
    private String schemaVersion;
    private String timestamp;
    private String url;
    @SerializedName("userAction")
    private zendesk.core.BlipsRequest.ApiUserAction userAction;
    @SerializedName("userId")
    private Long userId;
    private String uuid;
    private String version;

    static class ApiPageView {

        @SerializedName("navigatorLanguage")
        private String navigatorLanguage;
        @SerializedName("pageId")
        private Long pageId;
        @SerializedName("pageLocale")
        private String pageLocale;
        @SerializedName("pageTitle")
        private String pageTitle;
        private Map<String, Object> value;
        ApiPageView(String string, String string2, Long long3, String string4, Map<String, Object> map5) {
            super();
            this.navigatorLanguage = string;
            this.pageTitle = string2;
            this.value = map5;
            this.pageId = long3;
            this.pageLocale = string4;
        }

        String getNavigatorLanguage() {
            return this.navigatorLanguage;
        }

        Long getPageId() {
            return this.pageId;
        }

        String getPageLocale() {
            return this.pageLocale;
        }

        String getPageTitle() {
            return this.pageTitle;
        }

        Map<String, Object> getValue() {
            return this.value;
        }
    }

    static class ApiUserAction {

        private String action;
        private String category;
        private String label;
        private Map<String, Object> value;
        ApiUserAction(String string, String string2, String string3, Map<String, Object> map4) {
            super();
            this.category = string;
            this.action = string2;
            this.label = string3;
            this.value = map4;
        }

        String getAction() {
            return this.action;
        }

        String getCategory() {
            return this.category;
        }

        String getLabel() {
            return this.label;
        }

        Map<String, Object> getValue() {
            return this.value;
        }
    }
    private BlipsRequest() {
        super();
        this.schemaVersion = "1";
    }

    static zendesk.core.BlipsRequest buildPageView(String string, String string2, Long long3, String string4, String string5, String string6, String string7, String string8, String string9, Long long10, String string11, Map<String, Object> map12) {
        BlipsRequest blipsRequest = new BlipsRequest();
        blipsRequest.uuid = string;
        blipsRequest.timestamp = string2;
        blipsRequest.userId = long3;
        blipsRequest.appId = string4;
        blipsRequest.version = string5;
        blipsRequest.channel = string6;
        blipsRequest.url = string7;
        super(string8, string9, long10, string11, map12);
        blipsRequest.pageView = obj7;
        return blipsRequest;
    }

    static zendesk.core.BlipsRequest buildUserAction(String string, String string2, Long long3, String string4, String string5, String string6, String string7, String string8, String string9, Map<String, Object> map10) {
        BlipsRequest blipsRequest = new BlipsRequest();
        blipsRequest.uuid = string;
        blipsRequest.timestamp = string2;
        blipsRequest.userId = long3;
        blipsRequest.appId = string4;
        blipsRequest.version = string5;
        blipsRequest.channel = string6;
        BlipsRequest.ApiUserAction obj1 = new BlipsRequest.ApiUserAction(string7, string8, string9, map10);
        blipsRequest.userAction = obj1;
        return blipsRequest;
    }

    String getAppId() {
        return this.appId;
    }

    String getChannel() {
        return this.channel;
    }

    zendesk.core.BlipsRequest.ApiPageView getPageView() {
        return this.pageView;
    }

    String getSchemaVersion() {
        return this.schemaVersion;
    }

    String getTimestamp() {
        return this.timestamp;
    }

    String getUrl() {
        return this.url;
    }

    zendesk.core.BlipsRequest.ApiUserAction getUserAction() {
        return this.userAction;
    }

    Long getUserId() {
        return this.userId;
    }

    String getUuid() {
        return this.uuid;
    }

    String getVersion() {
        return this.version;
    }
}
