package zendesk.support;

/* loaded from: classes3.dex */
class AttachmentSettings {

    private static zendesk.support.AttachmentSettings DEFAULT;
    private boolean enabled;
    private long maxAttachmentSize;
    static {
        AttachmentSettings attachmentSettings = new AttachmentSettings(0, 0, obj3);
        AttachmentSettings.DEFAULT = attachmentSettings;
    }

    AttachmentSettings(boolean z, long l2) {
        super();
        this.enabled = z;
        this.maxAttachmentSize = l2;
    }

    static zendesk.support.AttachmentSettings defaultSettings() {
        return AttachmentSettings.DEFAULT;
    }

    long getMaxAttachmentSize() {
        return this.maxAttachmentSize;
    }

    boolean isEnabled() {
        return this.enabled;
    }
}
