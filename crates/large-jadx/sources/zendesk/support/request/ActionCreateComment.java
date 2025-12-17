package zendesk.support.request;

import com.zendesk.service.a;
import com.zendesk.service.f;
import f.g.c.a;
import f.g.e.a;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import o.b.f;
import o.b.j;
import zendesk.support.Comment;
import zendesk.support.CreateRequest;
import zendesk.support.EndUserComment;
import zendesk.support.Request;
import zendesk.support.RequestProvider;

/* loaded from: classes3.dex */
class ActionCreateComment implements zendesk.support.request.AsyncMiddleware.AsyncAction {

    private final zendesk.support.request.ActionFactory af;
    private f<zendesk.support.request.AttachmentUploadService.AttachmentUploadResult> attachmentCallback;
    private final zendesk.support.request.AttachmentUploadService attachmentUploader;
    private final zendesk.support.request.StateMessage message;
    private final RequestProvider requestProvider;

    static class CreateCommentResult {

        private final long commentRemoteId;
        private final zendesk.support.request.AttachmentUploadService.AttachmentUploadResult localToRemoteAttachments;
        private final zendesk.support.request.StateMessage message;
        private final String requestId;
        CreateCommentResult(zendesk.support.request.StateMessage stateMessage, String string2, long l3, zendesk.support.request.AttachmentUploadService.AttachmentUploadResult attachmentUploadService$AttachmentUploadResult4) {
            super();
            this.message = stateMessage;
            this.requestId = string2;
            this.commentRemoteId = l3;
            this.localToRemoteAttachments = obj5;
        }

        long getCommentRemoteId() {
            return this.commentRemoteId;
        }

        zendesk.support.request.AttachmentUploadService.AttachmentUploadResult getLocalToRemoteAttachments() {
            return this.localToRemoteAttachments;
        }

        zendesk.support.request.StateMessage getMessage() {
            return this.message;
        }

        String getRequestId() {
            return this.requestId;
        }
    }
    ActionCreateComment(zendesk.support.request.ActionFactory actionFactory, RequestProvider requestProvider2, zendesk.support.request.AttachmentUploadService attachmentUploadService3, zendesk.support.request.StateMessage stateMessage4) {
        super();
        this.af = actionFactory;
        this.requestProvider = requestProvider2;
        this.message = stateMessage4;
        this.attachmentUploader = attachmentUploadService3;
    }

    static zendesk.support.request.StateMessage access$000(zendesk.support.request.ActionCreateComment actionCreateComment) {
        return actionCreateComment.message;
    }

    static void access$100(zendesk.support.request.ActionCreateComment actionCreateComment, zendesk.support.request.StateConversation stateConversation2, zendesk.support.request.StateConfig stateConfig3, f f4, zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback5, zendesk.support.request.AttachmentUploadService.AttachmentUploadResult attachmentUploadService$AttachmentUploadResult6) {
        actionCreateComment.createMessage(stateConversation2, stateConfig3, f4, callback5, attachmentUploadResult6);
    }

    static zendesk.support.request.ActionFactory access$200(zendesk.support.request.ActionCreateComment actionCreateComment) {
        return actionCreateComment.af;
    }

    static RequestProvider access$300(zendesk.support.request.ActionCreateComment actionCreateComment) {
        return actionCreateComment.requestProvider;
    }

    private void addComment(zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback, f f2, zendesk.support.request.StateConversation stateConversation3, zendesk.support.request.AttachmentUploadService.AttachmentUploadResult attachmentUploadService$AttachmentUploadResult4) {
        EndUserComment endUserComment = new EndUserComment();
        endUserComment.setValue(this.message.getBody());
        endUserComment.setAttachments(getAttachmentToken(attachmentUploadResult4.getRequestAttachments()));
        String remoteId = stateConversation3.getRemoteId();
        super(this, attachmentUploadResult4, f2, remoteId, stateConversation3, callback);
        this.requestProvider.addComment(remoteId, endUserComment, anon2);
    }

    private void createMessage(zendesk.support.request.StateConversation stateConversation, zendesk.support.request.StateConfig stateConfig2, f f3, zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback4, zendesk.support.request.AttachmentUploadService.AttachmentUploadResult attachmentUploadService$AttachmentUploadResult5) {
        String str;
        long l;
        zendesk.support.request.StateConversation obj7;
        Object[] obj8;
        final int i = 0;
        final int i2 = 1;
        final String str2 = "RequestActivity";
        if (g.c(stateConversation.getRemoteId())) {
            obj8 = new Object[i2];
            obj8[i] = Long.valueOf(this.message.getId());
            a.b(str2, "Adding a comment to an existing request. Message Id %s", obj8);
            addComment(callback4, f3, stateConversation, attachmentUploadResult5);
        } else {
            obj7 = new Object[i2];
            obj7[i] = Long.valueOf(this.message.getId());
            a.b(str2, "Creating a new request. Message Id %s", obj7);
            createRequest(callback4, f3, attachmentUploadResult5, stateConfig2);
        }
    }

    private void createRequest(zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback, f f2, zendesk.support.request.AttachmentUploadService.AttachmentUploadResult attachmentUploadService$AttachmentUploadResult3, zendesk.support.request.StateConfig stateConfig4) {
        boolean tags;
        boolean subject;
        int ticketForm;
        int i;
        List obj9;
        CreateRequest createRequest = new CreateRequest();
        createRequest.setDescription(this.message.getBody());
        createRequest.setAttachments(getAttachmentToken(attachmentUploadResult3.getRequestAttachments()));
        if (a.i(stateConfig4.getTags())) {
            createRequest.setTags(stateConfig4.getTags());
        }
        if (g.c(stateConfig4.getSubject())) {
            createRequest.setSubject(stateConfig4.getSubject());
        }
        if (stateConfig4.getTicketForm() != null && Long.compare(id, i) != 0) {
            if (Long.compare(id, i) != 0) {
                createRequest.setTicketFormId(Long.valueOf(stateConfig4.getTicketForm().getId()));
            }
            createRequest.setCustomFields(stateConfig4.getTicketForm().getTicketFieldsForApi());
        }
        ActionCreateComment.3 anon = new ActionCreateComment.3(this, attachmentUploadResult3, f2, callback);
        this.requestProvider.createRequest(createRequest, anon);
    }

    private List<String> getAttachmentToken(List<zendesk.support.request.StateRequestAttachment> list) {
        String token;
        ArrayList arrayList = new ArrayList();
        final Iterator obj3 = list.iterator();
        for (StateRequestAttachment next2 : obj3) {
            arrayList.add(next2.getToken());
        }
        return arrayList;
    }

    private void waitForAttachments(f f, j j2, zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback3) {
        Object[] obj9 = new Object[1];
        a.b("RequestActivity", "Waiting for attachments to be uploaded. Message Id: %s", Long.valueOf(this.message.getId()));
        super(this, StateConversation.fromState(j2.getState()), StateConfig.fromState(j2.getState()), f, callback3);
        this.attachmentCallback = obj9;
        this.attachmentUploader.setResultListener(obj9);
    }

    @Override // zendesk.support.request.AsyncMiddleware$AsyncAction
    public void actionQueued(f f, j j2) {
        Object attachmentUploader;
        boolean arr;
        String str;
        attachmentUploader = this.message.getAttachments();
        if (a.i(attachmentUploader)) {
            arr = new Object[2];
            a.b("RequestActivity", "Start uploading %d attachments. Message Id: %s", Integer.valueOf(attachmentUploader.size()), Long.valueOf(this.message.getId()));
            this.attachmentUploader.start(StateConversation.fromState(j2.getState()).getLocalId());
        }
        f.c(this.af.createComment(this.message.withPending()));
    }

    @Override // zendesk.support.request.AsyncMiddleware$AsyncAction
    public void execute(f f, j j2, zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback3) {
        waitForAttachments(f, j2, callback3);
    }
}
