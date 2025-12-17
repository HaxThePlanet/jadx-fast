package zendesk.support.request;

import java.io.Serializable;
import zendesk.support.SupportSdkSettings;

/* loaded from: classes3.dex */
class StateSettings implements Serializable {

    private final boolean attachmentsEnabled;
    private final boolean conversationsEnabled;
    private final boolean hasIdentityEmailAddress;
    private final boolean hasIdentityName;
    private final long maxAttachmentSize;
    private final boolean neverRequestEmail;
    private final String referrerUrl;
    private final boolean settingsLoaded;
    private final boolean showZendeskLogo;
    private final String systemMessage;
    StateSettings() {
        super();
        int i = 0;
        this.settingsLoaded = i;
        this.conversationsEnabled = i;
        this.attachmentsEnabled = i;
        this.maxAttachmentSize = -1;
        int i3 = 1;
        this.neverRequestEmail = i3;
        this.hasIdentityEmailAddress = i;
        this.hasIdentityName = i;
        this.showZendeskLogo = i3;
        String str = "";
        this.referrerUrl = str;
        this.systemMessage = str;
    }

    StateSettings(boolean z, boolean z2, long l3, boolean z4, boolean z5, boolean z6, boolean z7, String string8, String string9) {
        super();
        this.settingsLoaded = true;
        this.conversationsEnabled = z;
        this.attachmentsEnabled = z2;
        this.maxAttachmentSize = l3;
        this.neverRequestEmail = z5;
        this.hasIdentityEmailAddress = z6;
        this.hasIdentityName = z7;
        this.showZendeskLogo = string8;
        this.referrerUrl = string9;
        this.systemMessage = obj11;
    }

    static zendesk.support.request.StateSettings fromSupportSettings(SupportSdkSettings supportSdkSettings, boolean z2, boolean z3) {
        super(supportSdkSettings.isConversationsEnabled(), supportSdkSettings.isAttachmentsEnabled(), supportSdkSettings.getMaxAttachmentSize(), obj4, supportSdkSettings.isNeverAskForEmailEnabled(), z2, z3, supportSdkSettings.isShowReferrerLogoEnabled(), supportSdkSettings.getReferrerUrl(), supportSdkSettings.getRequestSystemMessage());
        return stateSettings;
    }

    @Override // java.io.Serializable
    long getMaxAttachmentSize() {
        return this.maxAttachmentSize;
    }

    @Override // java.io.Serializable
    String getReferrerUrl() {
        return this.referrerUrl;
    }

    @Override // java.io.Serializable
    String getSystemMessage() {
        return this.systemMessage;
    }

    @Override // java.io.Serializable
    boolean hasIdentityEmailAddress() {
        return this.hasIdentityEmailAddress;
    }

    @Override // java.io.Serializable
    boolean hasIdentityName() {
        return this.hasIdentityName;
    }

    @Override // java.io.Serializable
    boolean hasSettings() {
        return this.settingsLoaded;
    }

    @Override // java.io.Serializable
    boolean isAttachmentsEnabled() {
        return this.attachmentsEnabled;
    }

    @Override // java.io.Serializable
    boolean isConversationsEnabled() {
        return this.conversationsEnabled;
    }

    @Override // java.io.Serializable
    boolean isNeverRequestEmailOn() {
        return this.neverRequestEmail;
    }

    @Override // java.io.Serializable
    boolean isShowZendeskLogo() {
        return this.showZendeskLogo;
    }

    @Override // java.io.Serializable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Settings{settingsLoaded=");
        stringBuilder.append(this.settingsLoaded);
        stringBuilder.append(", conversationsEnabled=");
        stringBuilder.append(this.conversationsEnabled);
        stringBuilder.append(", attachmentsEnabled=");
        stringBuilder.append(this.attachmentsEnabled);
        stringBuilder.append(", maxAttachmentSize=");
        stringBuilder.append(this.maxAttachmentSize);
        stringBuilder.append(", neverRequestEmail=");
        stringBuilder.append(this.neverRequestEmail);
        stringBuilder.append(", hasIdentityEmailAddress=");
        stringBuilder.append(this.hasIdentityEmailAddress);
        stringBuilder.append(", hasIdentityName=");
        stringBuilder.append(this.hasIdentityName);
        stringBuilder.append(", referrerUrl=");
        stringBuilder.append(this.referrerUrl);
        stringBuilder.append(", systemMessage=");
        stringBuilder.append(this.systemMessage);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
