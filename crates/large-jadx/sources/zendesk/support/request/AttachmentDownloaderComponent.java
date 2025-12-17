package zendesk.support.request;

import com.zendesk.service.a;
import com.zendesk.service.f;
import f.g.c.a;
import f.g.e.g;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import o.b.f;
import o.b.k;
import zendesk.belvedere.a;
import zendesk.belvedere.s;

/* loaded from: classes3.dex */
class AttachmentDownloaderComponent implements k<zendesk.support.request.StateConversation> {

    private final zendesk.support.request.ActionFactory actionFactory;
    private final zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader attachmentDownloader;
    private final f dispatcher;
    private final zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloaderSelector selector;

    static class AttachmentDownloader {

        private final zendesk.support.request.AttachmentDownloadService attachmentIo;
        private final a belvedere;
        private final Set<String> downloadingHistory;
        AttachmentDownloader(a a, zendesk.support.request.AttachmentDownloadService attachmentDownloadService2) {
            super();
            this.belvedere = a;
            this.attachmentIo = attachmentDownloadService2;
            HashSet obj1 = new HashSet();
            this.downloadingHistory = obj1;
        }

        static Set access$200(zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader attachmentDownloaderComponent$AttachmentDownloader) {
            return attachmentDownloader.downloadingHistory;
        }

        static void access$300(zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader attachmentDownloaderComponent$AttachmentDownloader, String string2, a a3, f f4) {
            attachmentDownloader.handleError(string2, a3, f4);
        }

        static a access$400(zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader attachmentDownloaderComponent$AttachmentDownloader) {
            return attachmentDownloader.belvedere;
        }

        static zendesk.support.request.AttachmentDownloadService access$500(zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader attachmentDownloaderComponent$AttachmentDownloader) {
            return attachmentDownloader.attachmentIo;
        }

        private void handleError(String string, a a2, f f3) {
            this.downloadingHistory.remove(string);
            if (f3 != null) {
                f3.onError(a2);
            }
        }

        void download(zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader.Request attachmentDownloaderComponent$AttachmentDownloader$Request, f<s> f2) {
            boolean attachmentIo;
            zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader.HttpCallback httpCallback;
            final zendesk.support.request.StateRequestAttachment requestAttachment = request.getRequestAttachment();
            final String url = requestAttachment.getUrl();
            if (!this.downloadingHistory.contains(url)) {
                this.downloadingHistory.add(url);
                httpCallback = new AttachmentDownloaderComponent.AttachmentDownloader.HttpCallback(this, request, requestAttachment, f2);
                this.attachmentIo.downloadAttachment(url, httpCallback);
            }
        }
    }

    static class AttachmentDownloaderSelector {
        public List<zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader.Request> selectData(zendesk.support.request.StateConversation stateConversation) {
            Iterator iterator;
            boolean next;
            long longValue;
            int request;
            boolean remoteId;
            boolean z;
            final zendesk.support.request.StateIdMapper attachmentIdMapper = stateConversation.getAttachmentIdMapper();
            LinkedList linkedList = new LinkedList();
            Iterator obj11 = stateConversation.getMessages().iterator();
            for (StateMessage next3 : obj11) {
                iterator = next3.getAttachments().iterator();
                while (iterator.hasNext()) {
                    next = iterator.next();
                    longValue = (StateRequestAttachment)next.getId();
                    if (next.getLocalFile() != null) {
                    } else {
                    }
                    request = 0;
                    if (request == null && attachmentIdMapper.hasRemoteId(Long.valueOf(longValue)) && g.c(next.getUrl())) {
                    }
                    if (attachmentIdMapper.hasRemoteId(Long.valueOf(longValue))) {
                    }
                    if (g.c(next.getUrl())) {
                    }
                    request = new AttachmentDownloaderComponent.AttachmentDownloader.Request(stateConversation.getLocalId(), attachmentIdMapper.getRemoteId(Long.valueOf(longValue)).longValue(), obj6, next);
                    linkedList.add(request);
                    request = 1;
                }
                next = iterator.next();
                longValue = (StateRequestAttachment)next.getId();
                if (next.getLocalFile() != null) {
                } else {
                }
                request = 0;
                if (request == null && attachmentIdMapper.hasRemoteId(Long.valueOf(longValue)) && g.c(next.getUrl())) {
                }
                if (attachmentIdMapper.hasRemoteId(Long.valueOf(longValue))) {
                }
                if (g.c(next.getUrl())) {
                }
                request = new AttachmentDownloaderComponent.AttachmentDownloader.Request(localId, attachmentIdMapper.getRemoteId(Long.valueOf(longValue)).longValue(), obj6, next);
                linkedList.add(request);
                request = 1;
            }
            return linkedList;
        }
    }

    private class DownloadCallback extends f<s> {

        private final zendesk.support.request.StateRequestAttachment requestAttachment;
        final zendesk.support.request.AttachmentDownloaderComponent this$0;
        DownloadCallback(zendesk.support.request.AttachmentDownloaderComponent attachmentDownloaderComponent, zendesk.support.request.StateRequestAttachment stateRequestAttachment2) {
            this.this$0 = attachmentDownloaderComponent;
            super();
            this.requestAttachment = stateRequestAttachment2;
        }

        @Override // com.zendesk.service.f
        public void onError(a a) {
            Object[] arr = new Object[1];
            a.b("RequestActivity", "Unable to download attachment. Error: %s", a.b());
        }

        @Override // com.zendesk.service.f
        public void onSuccess(Object object) {
            onSuccess((s)object);
        }

        @Override // com.zendesk.service.f
        public void onSuccess(s s) {
            AttachmentDownloaderComponent.access$100(this.this$0).c(AttachmentDownloaderComponent.access$000(this.this$0).attachmentDownloaded(this.requestAttachment, s));
        }
    }
    AttachmentDownloaderComponent(f f, zendesk.support.request.ActionFactory actionFactory2, zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader attachmentDownloaderComponent$AttachmentDownloader3) {
        super();
        this.dispatcher = f;
        this.actionFactory = actionFactory2;
        this.attachmentDownloader = attachmentDownloader3;
        AttachmentDownloaderComponent.AttachmentDownloaderSelector obj1 = new AttachmentDownloaderComponent.AttachmentDownloaderSelector();
        this.selector = obj1;
    }

    static zendesk.support.request.ActionFactory access$000(zendesk.support.request.AttachmentDownloaderComponent attachmentDownloaderComponent) {
        return attachmentDownloaderComponent.actionFactory;
    }

    static f access$100(zendesk.support.request.AttachmentDownloaderComponent attachmentDownloaderComponent) {
        return attachmentDownloaderComponent.dispatcher;
    }

    @Override // o.b.k
    public void update(Object object) {
        update((StateConversation)object);
    }

    @Override // o.b.k
    public void update(zendesk.support.request.StateConversation stateConversation) {
        zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloaderSelector selector;
        zendesk.support.request.AttachmentDownloaderComponent.AttachmentDownloader attachmentDownloader;
        zendesk.support.request.AttachmentDownloaderComponent.DownloadCallback downloadCallback;
        zendesk.support.request.StateRequestAttachment requestAttachment;
        Iterator obj5 = this.selector.selectData(stateConversation).iterator();
        for (AttachmentDownloaderComponent.AttachmentDownloader.Request selector : obj5) {
            downloadCallback = new AttachmentDownloaderComponent.DownloadCallback(this, selector.getRequestAttachment());
            this.attachmentDownloader.download(selector, downloadCallback);
        }
    }
}
