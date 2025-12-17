package zendesk.support;

import com.zendesk.service.f;
import java.io.File;

/* loaded from: classes3.dex */
class ZendeskUploadProvider implements zendesk.support.UploadProvider {

    private final zendesk.support.ZendeskUploadService uploadService;
    ZendeskUploadProvider(zendesk.support.ZendeskUploadService zendeskUploadService) {
        super();
        this.uploadService = zendeskUploadService;
    }

    public void deleteAttachment(String string, f<Void> f2) {
        this.uploadService.deleteAttachment(string, f2);
    }

    public void uploadAttachment(String string, File file2, String string3, f<zendesk.support.UploadResponse> f4) {
        ZendeskUploadProvider.1 anon = new ZendeskUploadProvider.1(this, f4, f4);
        this.uploadService.uploadAttachment(string, file2, string3, anon);
    }
}
