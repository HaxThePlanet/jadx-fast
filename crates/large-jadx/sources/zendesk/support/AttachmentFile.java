package zendesk.support;

import java.io.File;
import java.io.Serializable;

/* loaded from: classes3.dex */
public class AttachmentFile implements Serializable {

    private File file;
    private String fileName;
    private String mimeType;
    public AttachmentFile(String string, String string2, File file3) {
        super();
        this.fileName = string;
        this.mimeType = string2;
        this.file = file3;
    }

    @Override // java.io.Serializable
    public File getFile() {
        return this.file;
    }

    @Override // java.io.Serializable
    public String getFileName() {
        return this.fileName;
    }

    @Override // java.io.Serializable
    public String getMimeType() {
        return this.mimeType;
    }
}
