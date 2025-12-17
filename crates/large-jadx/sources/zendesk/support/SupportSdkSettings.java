package zendesk.support;

import f.g.e.a;
import f.g.e.g;
import java.util.ArrayList;
import java.util.List;
import zendesk.core.AuthenticationType;

/* loaded from: classes3.dex */
public class SupportSdkSettings {

    private final AuthenticationType authenticationType;
    private final zendesk.support.HelpCenterSettings helpCenterSettings;
    private final zendesk.support.SupportSettings mobileSettings;
    public SupportSdkSettings(zendesk.support.SupportSettings supportSettings, zendesk.support.HelpCenterSettings helpCenterSettings2, AuthenticationType authenticationType3) {
        super();
        this.mobileSettings = supportSettings;
        this.helpCenterSettings = helpCenterSettings2;
        this.authenticationType = authenticationType3;
    }

    private zendesk.support.AttachmentSettings getAttachmentSettings() {
        Object mobileSettings;
        int i;
        int attachments;
        mobileSettings = this.mobileSettings;
        if (mobileSettings != null && mobileSettings.getAttachments() != null) {
            i = mobileSettings.getAttachments() != null ? 1 : 0;
        } else {
        }
        if (i != 0) {
            attachments = this.mobileSettings.getAttachments();
        } else {
            attachments = 0;
        }
        return attachments;
    }

    private zendesk.support.ConversationsSettings getConversationsSettings() {
        Object mobileSettings;
        int i;
        int conversations;
        mobileSettings = this.mobileSettings;
        if (mobileSettings != null && mobileSettings.getConversations() != null) {
            i = mobileSettings.getConversations() != null ? 1 : 0;
        } else {
        }
        if (i != 0) {
            conversations = this.mobileSettings.getConversations();
        } else {
            conversations = 0;
        }
        return conversations;
    }

    public AuthenticationType getAuthenticationType() {
        return this.authenticationType;
    }

    public List<String> getContactZendeskTags() {
        int i;
        Object arrayList;
        zendesk.support.SupportSettings mobileSettings;
        mobileSettings = this.mobileSettings;
        if (mobileSettings != null && mobileSettings.getContactUs() != null && a.i(this.mobileSettings.getContactUs().getTags())) {
            if (mobileSettings.getContactUs() != null) {
                i = a.i(this.mobileSettings.getContactUs().getTags()) ? 1 : 0;
            } else {
            }
        } else {
        }
        if (i != 0) {
            arrayList = this.mobileSettings.getContactUs().getTags();
        } else {
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    public String getHelpCenterLocale() {
        Object helpCenterSettings;
        int i;
        String locale;
        helpCenterSettings = this.helpCenterSettings;
        if (helpCenterSettings != null && helpCenterSettings.getLocale() != null) {
            i = helpCenterSettings.getLocale() != null ? 1 : 0;
        } else {
        }
        if (i != 0) {
            locale = this.helpCenterSettings.getLocale();
        } else {
            locale = "";
        }
        return locale;
    }

    public long getMaxAttachmentSize() {
        long maxAttachmentSize;
        zendesk.support.AttachmentSettings attachmentSettings = getAttachmentSettings();
        if (attachmentSettings != null) {
            maxAttachmentSize = attachmentSettings.getMaxAttachmentSize();
        } else {
            maxAttachmentSize = 0;
        }
        return maxAttachmentSize;
    }

    public String getReferrerUrl() {
        zendesk.support.SupportSettings mobileSettings;
        String referrerUrl;
        mobileSettings = this.mobileSettings;
        if (mobileSettings != null && g.c(mobileSettings.getReferrerUrl())) {
            if (g.c(mobileSettings.getReferrerUrl())) {
                referrerUrl = this.mobileSettings.getReferrerUrl();
            } else {
                referrerUrl = "https://www.zendesk.com/embeddables";
            }
        } else {
        }
        return referrerUrl;
    }

    public String getRequestSystemMessage() {
        zendesk.support.SupportSettings mobileSettings;
        String systemMessage;
        mobileSettings = this.mobileSettings;
        if (mobileSettings != null && g.c(mobileSettings.getSystemMessage())) {
            if (g.c(mobileSettings.getSystemMessage())) {
                systemMessage = this.mobileSettings.getSystemMessage();
            } else {
                systemMessage = "";
            }
        } else {
        }
        return systemMessage;
    }

    public boolean hasHelpCenterSettings() {
        int i;
        i = this.helpCenterSettings != null ? 1 : 0;
        return i;
    }

    public boolean isAttachmentsEnabled() {
        zendesk.support.AttachmentSettings attachmentSettings;
        int i;
        attachmentSettings = getAttachmentSettings();
        if (attachmentSettings != null && attachmentSettings.isEnabled()) {
            i = attachmentSettings.isEnabled() ? 1 : 0;
        } else {
        }
        return i;
    }

    public boolean isConversationsEnabled() {
        zendesk.support.ConversationsSettings conversationsSettings;
        int i;
        conversationsSettings = getConversationsSettings();
        if (conversationsSettings != null && conversationsSettings.isEnabled()) {
            i = conversationsSettings.isEnabled() ? 1 : 0;
        } else {
        }
        return i;
    }

    public boolean isHelpCenterArticleVotingEnabled() {
        boolean articleVotingEnabled;
        int i;
        if (hasHelpCenterSettings() && this.helpCenterSettings.isArticleVotingEnabled()) {
            i = this.helpCenterSettings.isArticleVotingEnabled() ? 1 : 0;
        } else {
        }
        return i;
    }

    public boolean isHelpCenterEnabled() {
        zendesk.support.HelpCenterSettings helpCenterSettings;
        int i;
        helpCenterSettings = this.helpCenterSettings;
        if (helpCenterSettings != null && helpCenterSettings.isEnabled()) {
            i = helpCenterSettings.isEnabled() ? 1 : 0;
        } else {
        }
        return i;
    }

    public boolean isNeverAskForEmailEnabled() {
        int i;
        zendesk.support.SupportSettings neverRequestEmailOn;
        neverRequestEmailOn = this.mobileSettings;
        if (neverRequestEmailOn != null) {
            if (neverRequestEmailOn.isNeverRequestEmailOn()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public boolean isShowClosedRequests() {
        int i;
        zendesk.support.SupportSettings showClosedRequests;
        showClosedRequests = this.mobileSettings;
        if (showClosedRequests != null) {
            if (showClosedRequests.isShowClosedRequests()) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    public boolean isShowReferrerLogoEnabled() {
        zendesk.support.SupportSettings showReferrerLogo;
        int i;
        showReferrerLogo = this.mobileSettings;
        if (showReferrerLogo != null && showReferrerLogo.isShowReferrerLogo()) {
            i = showReferrerLogo.isShowReferrerLogo() ? 1 : 0;
        } else {
        }
        return i;
    }

    public boolean isTicketFormSupportAvailable() {
        Object mobileSettings;
        int available;
        int i;
        mobileSettings = this.mobileSettings;
        final int i2 = 0;
        if (mobileSettings != null && mobileSettings.getTicketForms() != null) {
            available = mobileSettings.getTicketForms() != null ? i : i2;
        } else {
        }
        if (available != 0 && this.mobileSettings.getTicketForms().isAvailable()) {
            if (this.mobileSettings.getTicketForms().isAvailable()) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }
}
