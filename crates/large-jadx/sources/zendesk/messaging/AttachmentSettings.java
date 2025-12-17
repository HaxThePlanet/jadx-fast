package zendesk.messaging;

/* loaded from: classes3.dex */
public class AttachmentSettings {

    private final long maxFileSize;
    private final boolean sendingEnabled;
    public AttachmentSettings(long l, boolean z2) {
        super();
        this.maxFileSize = l;
        this.sendingEnabled = obj3;
    }

    public long getMaxFileSize() {
        return this.maxFileSize;
    }

    public boolean isSendingEnabled() {
        return this.sendingEnabled;
    }
}
