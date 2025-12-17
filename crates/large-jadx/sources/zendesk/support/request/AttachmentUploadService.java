package zendesk.support.request;

import android.net.Uri;
import com.zendesk.service.a;
import com.zendesk.service.b;
import com.zendesk.service.f;
import f.g.c.a;
import f.g.e.a;
import f.g.e.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import zendesk.belvedere.a;
import zendesk.belvedere.d;
import zendesk.belvedere.s;
import zendesk.support.Attachment;
import zendesk.support.UploadProvider;
import zendesk.support.UploadResponse;

/* loaded from: classes3.dex */
class AttachmentUploadService {

    private final a belvedere;
    private final List<zendesk.support.request.StateRequestAttachment> errorItems;
    private final List<zendesk.support.request.StateRequestAttachment> itemsForUpload;
    private final Map<Long, Long> localToRemoteMap;
    private final Object lock;
    private final List<zendesk.support.request.StateRequestAttachment> processedItems;
    private List<zendesk.support.request.AttachmentUploadService.ResolveCallback> resolveCallbacks;
    private f<zendesk.support.request.AttachmentUploadService.AttachmentUploadResult> resultListener;
    private String subDirectory;
    private final UploadProvider uploadProvider;

    static class AttachmentUploadResult {

        private final Map<Long, Long> localToRemoteIdMap;
        private final List<zendesk.support.request.StateRequestAttachment> requestAttachments;
        AttachmentUploadResult(List<zendesk.support.request.StateRequestAttachment> list, Map<Long, Long> map2) {
            super();
            this.requestAttachments = list;
            this.localToRemoteIdMap = map2;
        }

        Map<Long, Long> getLocalToRemoteIdMap() {
            return this.localToRemoteIdMap;
        }

        List<zendesk.support.request.StateRequestAttachment> getRequestAttachments() {
            return this.requestAttachments;
        }
    }

    private class AttachmentsCallback extends f<UploadResponse> {

        private final zendesk.support.request.StateRequestAttachment requestAttachment;
        final zendesk.support.request.AttachmentUploadService this$0;
        AttachmentsCallback(zendesk.support.request.AttachmentUploadService attachmentUploadService, zendesk.support.request.StateRequestAttachment stateRequestAttachment2) {
            this.this$0 = attachmentUploadService;
            super();
            this.requestAttachment = stateRequestAttachment2;
        }

        @Override // com.zendesk.service.f
        public void onError(a a) {
            Object[] arr = new Object[2];
            a.k("RequestActivity", "Error uploading file: %s | Error: %s", this.requestAttachment, a.b());
            AttachmentUploadService.access$400(this.this$0, this.requestAttachment);
        }

        @Override // com.zendesk.service.f
        public void onSuccess(Object object) {
            onSuccess((UploadResponse)object);
        }

        @Override // com.zendesk.service.f
        public void onSuccess(UploadResponse uploadResponse) {
            Object[] arr = new Object[2];
            String str2 = "Successfully uploaded file: %s | Result: %s";
            a.b("RequestActivity", str2, this.requestAttachment, uploadResponse);
            AttachmentUploadService.access$500(this.this$0).put(Long.valueOf(this.requestAttachment.getId()), uploadResponse.getAttachment().getId());
            AttachmentUploadService.access$600(this.this$0, this.requestAttachment, uploadResponse);
        }
    }

    private class ResolveCallback extends d<List<s>> {

        private final zendesk.support.request.StateRequestAttachment requestAttachment;
        final zendesk.support.request.AttachmentUploadService this$0;
        private ResolveCallback(zendesk.support.request.AttachmentUploadService attachmentUploadService, zendesk.support.request.StateRequestAttachment stateRequestAttachment2) {
            this.this$0 = attachmentUploadService;
            super();
            this.requestAttachment = stateRequestAttachment2;
        }

        ResolveCallback(zendesk.support.request.AttachmentUploadService attachmentUploadService, zendesk.support.request.StateRequestAttachment stateRequestAttachment2, zendesk.support.request.AttachmentUploadService.1 attachmentUploadService$13) {
            super(attachmentUploadService, stateRequestAttachment2);
        }

        @Override // zendesk.belvedere.d
        public void success(Object object) {
            success((List)object);
        }

        public void success(List<s> list) {
            Object attachmentsCallback;
            int size;
            int name;
            Object localFile;
            Object obj6;
            Uri parsedLocalUri = this.requestAttachment.getParsedLocalUri();
            name = 1;
            localFile = "RequestActivity";
            final int i = 0;
            if (list.size() > 0 && !AttachmentUploadService.access$100(this.this$0)) {
                if (!AttachmentUploadService.access$100(this.this$0)) {
                    Object[] arr = new Object[name];
                    arr[i] = parsedLocalUri;
                    a.k(localFile, "Successfully resolved attachment: %s", arr);
                    obj6 = AttachmentUploadService.access$200(this.this$0, this.requestAttachment, (s)list.get(i));
                    attachmentsCallback = new AttachmentUploadService.AttachmentsCallback(this.this$0, obj6);
                    AttachmentUploadService.access$300(this.this$0).uploadAttachment(obj6.getName(), obj6.getLocalFile(), obj6.getMimeType(), attachmentsCallback);
                } else {
                    obj6 = new Object[name];
                    obj6[i] = parsedLocalUri;
                    a.k(localFile, "Unable to resolve attachment: %s", obj6);
                    AttachmentUploadService.access$400(this.this$0, this.requestAttachment);
                }
            } else {
            }
        }
    }
    AttachmentUploadService(UploadProvider uploadProvider, a a2, List<zendesk.support.request.StateRequestAttachment> list3) {
        super();
        Object object = new Object();
        this.lock = object;
        this.uploadProvider = uploadProvider;
        this.belvedere = a2;
        this.itemsForUpload = list3;
        ArrayList obj2 = new ArrayList(list3.size());
        this.resolveCallbacks = obj2;
        this.subDirectory = UtilsAttachment.getTemporaryRequestCacheDir();
        obj2 = new ArrayList(list3.size());
        this.processedItems = obj2;
        obj2 = new ArrayList(list3.size());
        this.errorItems = obj2;
        obj2 = new HashMap();
        this.localToRemoteMap = obj2;
    }

    static boolean access$100(zendesk.support.request.AttachmentUploadService attachmentUploadService) {
        return attachmentUploadService.isUploadFinished();
    }

    static zendesk.support.request.StateRequestAttachment access$200(zendesk.support.request.AttachmentUploadService attachmentUploadService, zendesk.support.request.StateRequestAttachment stateRequestAttachment2, s s3) {
        return attachmentUploadService.updateRequestAttachment(stateRequestAttachment2, s3);
    }

    static UploadProvider access$300(zendesk.support.request.AttachmentUploadService attachmentUploadService) {
        return attachmentUploadService.uploadProvider;
    }

    static void access$400(zendesk.support.request.AttachmentUploadService attachmentUploadService, zendesk.support.request.StateRequestAttachment stateRequestAttachment2) {
        attachmentUploadService.errorUpload(stateRequestAttachment2);
    }

    static Map access$500(zendesk.support.request.AttachmentUploadService attachmentUploadService) {
        return attachmentUploadService.localToRemoteMap;
    }

    static void access$600(zendesk.support.request.AttachmentUploadService attachmentUploadService, zendesk.support.request.StateRequestAttachment stateRequestAttachment2, UploadResponse uploadResponse3) {
        attachmentUploadService.uploadSuccess(stateRequestAttachment2, uploadResponse3);
    }

    private void errorUpload(zendesk.support.request.StateRequestAttachment stateRequestAttachment) {
        final Object lock = this.lock;
        this.errorItems.add(stateRequestAttachment);
        notifyIfFinished();
        return;
        synchronized (lock) {
            lock = this.lock;
            this.errorItems.add(stateRequestAttachment);
            notifyIfFinished();
        }
    }

    private boolean isUploadFinished() {
        int i;
        int i2;
        final Object lock = this.lock;
        final int i3 = 0;
        synchronized (lock) {
            i = i2;
            try {
                if (!a.i(this.errorItems)) {
                }
                if (i != 0) {
                } else {
                }
                i2 = i3;
                return i2;
                throw th;
            }
        }
    }

    private void notifyIfFinished() {
        f resultListener;
        boolean uploadFinished;
        Object attachmentUploadResult;
        Object str;
        Map localToRemoteMap;
        Object[] arr = new Object[2];
        a.b("RequestActivity", "Notify if finished. Listener: %s, isUploadFinished: %s", this.resultListener, Boolean.valueOf(isUploadFinished()));
        if (isUploadFinished() && this.resultListener != null) {
            if (this.resultListener != null) {
                if (a.g(this.errorItems)) {
                    attachmentUploadResult = new AttachmentUploadService.AttachmentUploadResult(a.c(this.processedItems), this.localToRemoteMap);
                    this.resultListener.onSuccess(attachmentUploadResult);
                } else {
                    attachmentUploadResult = new b("Error uploading attachments.");
                    this.resultListener.onError(attachmentUploadResult);
                }
                this.resultListener = 0;
            }
        }
    }

    private s renameFile(File file, long l2) {
        s obj4;
        obj4 = this.belvedere.d(UtilsAttachment.getAttachmentSubDir(this.subDirectory, l2), file.getName());
        Object[] obj5 = new Object[2];
        a.b("RequestActivity", "Rename local file: %s -> %s", file.getAbsolutePath(), obj4.e().getAbsolutePath());
        if (file.renameTo(obj4.e()) != null) {
        } else {
            obj4 = 0;
        }
        return obj4;
    }

    private zendesk.support.request.StateRequestAttachment updateRequestAttachment(zendesk.support.request.StateRequestAttachment stateRequestAttachment, s s2) {
        return stateRequestAttachment.newBuilder().setLocalFile(s2.e()).setName(s2.j()).setMimeType(s2.i()).setLocalUri(s2.n().toString()).build();
    }

    private void uploadAttachment(zendesk.support.request.StateRequestAttachment stateRequestAttachment) {
        Object[] singletonList;
        boolean uploadFinished;
        Object resolveCallback;
        String subDirectory;
        Object obj4;
        Uri parsedLocalUri = stateRequestAttachment.getParsedLocalUri();
        if (parsedLocalUri != null && !isUploadFinished()) {
            if (!isUploadFinished()) {
                resolveCallback = new AttachmentUploadService.ResolveCallback(this, stateRequestAttachment, 0);
                this.resolveCallbacks.add(resolveCallback);
                this.belvedere.h(Collections.singletonList(parsedLocalUri), this.subDirectory, resolveCallback);
            } else {
                singletonList = new Object[1];
                a.k("RequestActivity", "Unable to parse uri, skipping. | %s", stateRequestAttachment.getLocalUri());
                errorUpload(stateRequestAttachment);
            }
        } else {
        }
    }

    private void uploadSuccess(zendesk.support.request.StateRequestAttachment stateRequestAttachment, UploadResponse uploadResponse2) {
        File localFile;
        String localUri;
        Attachment attachment = uploadResponse2.getAttachment();
        s renameFile = renameFile(stateRequestAttachment.getLocalFile(), attachment.getId().longValue());
        if (renameFile != null) {
            localUri = renameFile.n().toString();
            localFile = renameFile.e();
        } else {
            localUri = stateRequestAttachment.getLocalUri();
            localFile = stateRequestAttachment.getLocalFile();
        }
        Object obj6 = this.lock;
        this.processedItems.add(stateRequestAttachment.newBuilder().setLocalUri(localUri).setLocalFile(localFile).setToken(uploadResponse2.getToken()).setUrl(attachment.getContentUrl()).setMimeType(attachment.getContentType()).setName(attachment.getFileName()).build());
        notifyIfFinished();
        return;
        synchronized (obj6) {
            obj6 = this.lock;
            this.processedItems.add(stateRequestAttachment.newBuilder().setLocalUri(localUri).setLocalFile(localFile).setToken(uploadResponse2.getToken()).setUrl(attachment.getContentUrl()).setMimeType(attachment.getContentType()).setName(attachment.getFileName()).build());
            notifyIfFinished();
        }
    }

    void setResultListener(f<zendesk.support.request.AttachmentUploadService.AttachmentUploadResult> f) {
        this.resultListener = f;
        notifyIfFinished();
    }

    void start(String string) {
        String next;
        String obj3;
        if (g.c(string)) {
            this.subDirectory = UtilsAttachment.getCacheDirForRequestId(string);
        }
        a.b("RequestActivity", "Start uploading attachments", new Object[0]);
        obj3 = this.itemsForUpload.iterator();
        for (StateRequestAttachment next : obj3) {
            uploadAttachment(next);
        }
    }
}
