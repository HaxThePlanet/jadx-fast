package zendesk.support;

import zendesk.core.Settings;

/* loaded from: classes3.dex */
class SupportSettings implements Settings {

    private static zendesk.support.SupportSettings DEFAULT;
    private final zendesk.support.AttachmentSettings attachments;
    private final zendesk.support.ContactUsSettings contactUs;
    private final zendesk.support.ConversationsSettings conversations;
    private final boolean neverRequestEmail;
    private final String referrerUrl;
    private final boolean showClosedRequests;
    private final boolean showReferrerLogo;
    private final String systemMessage;
    private final zendesk.support.TicketFormSettings ticketForms;
    static {
        super(ConversationsSettings.defaultSettings(), ContactUsSettings.defaultSettings(), AttachmentSettings.defaultSettings(), TicketFormSettings.defaultSettings(), 1, 1, 0, "", "");
        SupportSettings.DEFAULT = supportSettings;
    }

    SupportSettings(zendesk.support.ConversationsSettings conversationsSettings, zendesk.support.ContactUsSettings contactUsSettings2, zendesk.support.AttachmentSettings attachmentSettings3, zendesk.support.TicketFormSettings ticketFormSettings4, boolean z5, boolean z6, boolean z7, String string8, String string9) {
        super();
        this.conversations = conversationsSettings;
        this.contactUs = contactUsSettings2;
        this.attachments = attachmentSettings3;
        this.ticketForms = ticketFormSettings4;
        this.neverRequestEmail = z5;
        this.showClosedRequests = z6;
        this.showReferrerLogo = z7;
        this.referrerUrl = string8;
        this.systemMessage = string9;
    }

    static zendesk.support.SupportSettings defaultSettings() {
        return SupportSettings.DEFAULT;
    }

    @Override // zendesk.core.Settings
    zendesk.support.AttachmentSettings getAttachments() {
        return this.attachments;
    }

    @Override // zendesk.core.Settings
    zendesk.support.ContactUsSettings getContactUs() {
        return this.contactUs;
    }

    @Override // zendesk.core.Settings
    zendesk.support.ConversationsSettings getConversations() {
        return this.conversations;
    }

    @Override // zendesk.core.Settings
    String getReferrerUrl() {
        return this.referrerUrl;
    }

    @Override // zendesk.core.Settings
    String getSystemMessage() {
        return this.systemMessage;
    }

    @Override // zendesk.core.Settings
    zendesk.support.TicketFormSettings getTicketForms() {
        return this.ticketForms;
    }

    @Override // zendesk.core.Settings
    boolean isNeverRequestEmailOn() {
        return this.neverRequestEmail;
    }

    @Override // zendesk.core.Settings
    boolean isShowClosedRequests() {
        return this.showClosedRequests;
    }

    @Override // zendesk.core.Settings
    boolean isShowReferrerLogo() {
        return this.showReferrerLogo;
    }
}
