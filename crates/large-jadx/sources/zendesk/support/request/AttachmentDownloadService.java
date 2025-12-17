package zendesk.support.request;

import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.zendesk.service.b;
import com.zendesk.service.f;
import f.g.c.a;
import java.io.IOException;
import java.util.concurrent.Executor;
import l.g;
import l.q;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import zendesk.belvedere.s;
import zendesk.support.Streams;

/* loaded from: classes3.dex */
class AttachmentDownloadService {

    private final Executor executor;
    private final OkHttpClient okHttpClient;

    private static class SaveToFileTask implements Runnable {

        private final f<s> callback;
        private final s destFile;
        private final ResponseBody responseBody;
        private SaveToFileTask(ResponseBody responseBody, s s2, f<s> f3) {
            super();
            this.responseBody = responseBody;
            this.destFile = s2;
            this.callback = f3;
        }

        SaveToFileTask(ResponseBody responseBody, s s2, f f3, zendesk.support.request.AttachmentDownloadService.1 attachmentDownloadService$14) {
            super(responseBody, s2, f3);
        }

        @Override // java.lang.Runnable
        public void run() {
            int destFile;
            Throwable responseBody;
            ResponseBody responseBody2;
            l.h source;
            String str;
            int arr;
            int i;
            String message;
            Throwable th2;
            destFile = 0;
            g gVar = q.c(q.f(this.destFile.e()));
            gVar.W0(this.responseBody.source());
            Streams.closeQuietly(gVar);
            Streams.closeQuietly(this.responseBody);
            f callback = this.callback;
            if (callback != null) {
                if (destFile == null) {
                    callback.onSuccess(this.destFile);
                } else {
                    callback.onError(destFile);
                }
            }
        }
    }
    AttachmentDownloadService(OkHttpClient okHttpClient, Executor executor2) {
        super();
        this.okHttpClient = okHttpClient;
        this.executor = executor2;
    }

    void downloadAttachment(String string, f<ResponseBody> f2) {
        Request.Builder builder = new Request.Builder();
        AttachmentDownloadService.1 anon = new AttachmentDownloadService.1(this, f2);
        FirebasePerfOkHttpClient.enqueue(this.okHttpClient.newCall(builder.get().url(string).build()), anon);
    }

    void storeAttachment(ResponseBody responseBody, s s2, f<s> f3) {
        AttachmentDownloadService.SaveToFileTask saveToFileTask = new AttachmentDownloadService.SaveToFileTask(responseBody, s2, f3, 0);
        this.executor.execute(saveToFileTask);
    }
}
