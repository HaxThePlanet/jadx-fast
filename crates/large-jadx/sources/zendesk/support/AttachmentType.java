package zendesk.support;

/* loaded from: classes3.dex */
public enum AttachmentType {

    INLINE("inline"),
    BLOCK("block");

    private String attachmentType;
    @Override // java.lang.Enum
    public String getAttachmentType() {
        return this.attachmentType;
    }
}
