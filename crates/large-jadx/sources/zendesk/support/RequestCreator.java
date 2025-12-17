package zendesk.support;

import com.zendesk.service.a;
import com.zendesk.service.f;
import f.g.e.a;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import zendesk.support.request.RequestConfiguration;

/* loaded from: classes3.dex */
public class RequestCreator {

    private final zendesk.support.RequestProvider requestProvider;
    private final zendesk.support.UploadProvider uploadProvider;
    public RequestCreator(zendesk.support.RequestProvider requestProvider, zendesk.support.UploadProvider uploadProvider2) {
        super();
        this.requestProvider = requestProvider;
        this.uploadProvider = uploadProvider2;
    }

    static zendesk.support.RequestProvider access$000(zendesk.support.RequestCreator requestCreator) {
        return requestCreator.requestProvider;
    }

    private zendesk.support.CreateRequest buildCreateRequestObject(String string, RequestConfiguration requestConfiguration2) {
        long ticketFormId;
        boolean obj6;
        CreateRequest createRequest = new CreateRequest();
        createRequest.setDescription(string);
        if (g.c(requestConfiguration2.getRequestSubject())) {
            createRequest.setSubject(requestConfiguration2.getRequestSubject());
        }
        if (a.i(requestConfiguration2.getTags())) {
            createRequest.setTags(requestConfiguration2.getTags());
        }
        if (Long.compare(ticketFormId, i) != 0) {
            createRequest.setTicketFormId(Long.valueOf(requestConfiguration2.getTicketFormId()));
        }
        if (a.i(requestConfiguration2.getCustomFields())) {
            createRequest.setCustomFields(requestConfiguration2.getCustomFields());
        }
        return createRequest;
    }

    private void uploadAttachments(zendesk.support.CreateRequest createRequest, List<zendesk.support.AttachmentFile> list2, f<zendesk.support.Request> f3) {
        zendesk.support.RequestCreator.1 request2;
        zendesk.support.RequestCreator request;
        ArrayList list;
        AtomicInteger num;
        int i2;
        zendesk.support.CreateRequest request3;
        f fVar;
        int size;
        Object obj;
        zendesk.support.UploadProvider uploadProvider;
        String fileName;
        java.io.File file;
        String mimeType;
        int i;
        AtomicInteger atomicInteger = new AtomicInteger();
        ArrayList arrayList = new ArrayList(list2.size());
        final Iterator iterator = list2.iterator();
        for (AttachmentFile next2 : iterator) {
            super(this, arrayList, atomicInteger, size, createRequest, f3);
            obj.uploadProvider.uploadAttachment(next2.getFileName(), next2.getFile(), next2.getMimeType(), anon);
            size = i;
        }
        Object obj2 = this;
    }

    void createRequest(String string, RequestConfiguration requestConfiguration2, f<zendesk.support.Request> f3) {
        Object obj3;
        final zendesk.support.CreateRequest obj2 = buildCreateRequestObject(string, requestConfiguration2);
        obj3 = requestConfiguration2.getFilesAsAttachments();
        if (a.i(obj3)) {
            uploadAttachments(obj2, obj3, f3);
        } else {
            this.requestProvider.createRequest(obj2, f3);
        }
    }
}
