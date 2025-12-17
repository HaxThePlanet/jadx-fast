package zendesk.support;

import com.google.gson.annotations.SerializedName;
import zendesk.core.Settings;

/* loaded from: classes3.dex */
public class HelpCenterSettings implements Settings {

    private static zendesk.support.HelpCenterSettings DEFAULT;
    @SerializedName("help_center_article_voting_enabled")
    private boolean articleVotingEnabled;
    private boolean enabled;
    private String locale;
    static {
        HelpCenterSettings helpCenterSettings = new HelpCenterSettings();
        HelpCenterSettings.DEFAULT = helpCenterSettings;
    }

    HelpCenterSettings(boolean z, boolean z2, String string3) {
        super();
        this.enabled = z;
        this.articleVotingEnabled = z2;
        this.locale = string3;
    }

    static zendesk.support.HelpCenterSettings defaultSettings() {
        return HelpCenterSettings.DEFAULT;
    }

    @Override // zendesk.core.Settings
    public String getLocale() {
        return this.locale;
    }

    @Override // zendesk.core.Settings
    public boolean isArticleVotingEnabled() {
        return this.articleVotingEnabled;
    }

    @Override // zendesk.core.Settings
    public boolean isEnabled() {
        return this.enabled;
    }
}
