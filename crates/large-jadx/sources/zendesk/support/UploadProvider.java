package zendesk.support;

import com.zendesk.service.f;
import java.io.File;

/* loaded from: classes3.dex */
public interface UploadProvider {
    public abstract void deleteAttachment(String string, f<Void> f2);

    public abstract void uploadAttachment(String string, File file2, String string3, f<zendesk.support.UploadResponse> f4);
}
