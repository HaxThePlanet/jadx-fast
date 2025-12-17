package zendesk.support;

import com.zendesk.service.d;
import com.zendesk.service.f;
import java.io.File;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;

/* loaded from: classes3.dex */
class ZendeskUploadService {

    private static final String LOG_TAG = "ZendeskUploadService";
    private final zendesk.support.UploadService uploadService;
    public ZendeskUploadService(zendesk.support.UploadService uploadService) {
        super();
        this.uploadService = uploadService;
    }

    void deleteAttachment(String string, f<Void> f2) {
        d dVar = new d(f2);
        this.uploadService.deleteAttachment(string).enqueue(dVar);
    }

    void uploadAttachment(String string, File file2, String string3, f<zendesk.support.UploadResponseWrapper> f4) {
        d obj3 = new d(f4);
        this.uploadService.uploadAttachment(string, RequestBody.create(MediaType.parse(string3), file2)).enqueue(obj3);
    }
}
