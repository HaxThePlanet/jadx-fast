package zendesk.core;

import java.util.Map;

/* loaded from: classes3.dex */
public class PageView {

    private String channel;
    private String navigatorLanguage;
    private Long pageId;
    private String pageLocale;
    private String pageTitle;
    private String url;
    private Map<String, Object> value;
    private String version;
    public PageView(String string, String string2, String string3, String string4, String string5, Long long6, String string7) {
        super();
        this.version = string;
        this.channel = string2;
        this.url = string3;
        this.navigatorLanguage = string4;
        this.pageTitle = string5;
        this.pageId = long6;
        this.pageLocale = string7;
    }

    public PageView(String string, String string2, String string3, String string4, String string5, Long long6, String string7, Map<String, Object> map8) {
        super(string, string2, string3, string4, string5, long6, string7);
        this.value = map8;
    }

    public String getChannel() {
        return this.channel;
    }

    public String getNavigatorLanguage() {
        return this.navigatorLanguage;
    }

    public Long getPageId() {
        return this.pageId;
    }

    public String getPageLocale() {
        return this.pageLocale;
    }

    public String getPageTitle() {
        return this.pageTitle;
    }

    public String getUrl() {
        return this.url;
    }

    public Map<String, Object> getValue() {
        return this.value;
    }

    public String getVersion() {
        return this.version;
    }
}
