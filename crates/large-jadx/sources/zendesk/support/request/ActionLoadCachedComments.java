package zendesk.support.request;

import android.net.Uri;
import f.g.c.a;
import f.g.e.a;
import f.g.e.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import o.b.f;
import o.b.j;
import zendesk.belvedere.a;
import zendesk.belvedere.s;
import zendesk.support.SupportUiStorage;

/* loaded from: classes3.dex */
class ActionLoadCachedComments implements zendesk.support.request.AsyncMiddleware.AsyncAction {

    private final zendesk.support.request.ActionFactory af;
    private final a belvedere;
    private final Executor executorService;
    private final String sdkVersion;
    private final SupportUiStorage supportUiStorage;

    static class LoadComments implements Runnable {

        private final zendesk.support.request.ActionFactory af;
        private final a belvedere;
        private final zendesk.support.request.AsyncMiddleware.Callback callback;
        private final f dispatcher;
        private final String id;
        private final String sdkVersion;
        private final SupportUiStorage supportUiStorage;
        LoadComments(String string, f f2, zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback3, SupportUiStorage supportUiStorage4, zendesk.support.request.ActionFactory actionFactory5, a a6, String string7) {
            super();
            this.id = string;
            this.dispatcher = f2;
            this.callback = callback3;
            this.supportUiStorage = supportUiStorage4;
            this.af = actionFactory5;
            this.belvedere = a6;
            this.sdkVersion = string7;
        }

        private zendesk.support.request.StateMessage findLocalAttachmentForMessage(zendesk.support.request.StateMessage stateMessage, zendesk.support.request.StateIdMapper stateIdMapper2, a a3, String string4) {
            Object attachments;
            boolean arrayList;
            boolean next;
            int attachment;
            boolean localFile;
            String name;
            zendesk.support.request.StateMessage obj7;
            attachments = stateMessage.getAttachments();
            if (a.i(attachments)) {
                arrayList = new ArrayList(stateMessage.getAttachments().size());
                attachments = attachments.iterator();
                while (attachments.hasNext()) {
                    attachment = attachments.next();
                    if (stateIdMapper2.hasRemoteId(Long.valueOf((StateRequestAttachment)attachment.getId()))) {
                    } else {
                    }
                    arrayList.add(attachment);
                    arrayList.add(updateAttachment(attachment, UtilsAttachment.getLocalFile(a3, string4, stateIdMapper2.getRemoteId(Long.valueOf(attachment.getId())).longValue(), obj4)));
                }
                obj7 = stateMessage.withAttachments(arrayList);
            }
            return obj7;
        }

        private zendesk.support.request.StateRequestAttachment updateAttachment(zendesk.support.request.StateRequestAttachment stateRequestAttachment, s s2) {
            File i;
            String obj6;
            if (Long.compare(size, length) == 0) {
                i = s2.e();
                obj6 = s2.n().toString();
            } else {
                obj6 = i;
            }
            return stateRequestAttachment.newBuilder().setLocalFile(i).setLocalUri(obj6).build();
        }

        @Override // java.lang.Runnable
        String getId() {
            return this.id;
        }

        @Override // java.lang.Runnable
        zendesk.support.request.StateConversation resolveAttachments(zendesk.support.request.StateConversation stateConversation) {
            zendesk.support.request.StateMessage localAttachmentForMessage;
            zendesk.support.request.StateIdMapper attachmentIdMapper;
            a belvedere;
            String localId;
            ArrayList arrayList = new ArrayList(stateConversation.getMessages().size());
            Iterator iterator = stateConversation.getMessages().iterator();
            for (StateMessage next2 : iterator) {
                arrayList.add(findLocalAttachmentForMessage(next2, stateConversation.getAttachmentIdMapper(), this.belvedere, stateConversation.getLocalId()));
            }
            return stateConversation.newBuilder().setMessages(arrayList).build();
        }

        @Override // java.lang.Runnable
        public void run() {
            o.b.a commentsFromCacheError;
            Object str;
            zendesk.support.request.StateConversation conversation;
            String version;
            Object read = this.supportUiStorage.read(this.id, ComponentPersistence.RequestPersistenceModel.class);
            int i2 = 0;
            String str4 = "RequestActivity";
            if (read != null && (ComponentPersistence.RequestPersistenceModel)read.getConversation() != null) {
                if (read.getConversation() != null) {
                    if (this.sdkVersion.equals(read.getVersion())) {
                        a.b(str4, "Successfully loaded request from disk", new Object[i2]);
                        commentsFromCacheError = this.af.loadCommentsFromCacheSuccess(resolveAttachments(read.getConversation()));
                    } else {
                        conversation = new Object[2];
                        conversation[i2] = read.getVersion();
                        conversation[1] = "5.0.3";
                        a.b(str4, "Cached version doesn't match with SDK version. Ignoring cached data. [%s, %s]", conversation);
                        commentsFromCacheError = this.af.loadCommentsFromCacheError();
                    }
                } else {
                    a.b(str4, "Unable to loaded request from disk", new Object[i2]);
                    commentsFromCacheError = this.af.loadCommentsFromCacheError();
                }
            } else {
            }
            this.dispatcher.c(commentsFromCacheError);
            this.callback.done();
        }
    }
    ActionLoadCachedComments(zendesk.support.request.ActionFactory actionFactory, SupportUiStorage supportUiStorage2, a a3, Executor executor4, String string5) {
        super();
        this.af = actionFactory;
        this.supportUiStorage = supportUiStorage2;
        this.belvedere = a3;
        this.executorService = executor4;
        this.sdkVersion = string5;
    }

    @Override // zendesk.support.request.AsyncMiddleware$AsyncAction
    public void actionQueued(f f, j j2) {
        f.c(this.af.loadCommentsFromCache());
    }

    @Override // zendesk.support.request.AsyncMiddleware$AsyncAction
    public void execute(f f, j j2, zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback3) {
        Executor executorService;
        zendesk.support.request.ActionLoadCachedComments.LoadComments loadComments;
        String localId;
        f fVar;
        zendesk.support.request.AsyncMiddleware.Callback callback;
        SupportUiStorage supportUiStorage;
        zendesk.support.request.ActionFactory factory;
        a belvedere;
        String sdkVersion;
        zendesk.support.request.ActionLoadCachedComments.LoadComments loadComments2;
        Object obj12;
        obj12 = StateConversation.fromState(j2.getState());
        if (g.c(obj12.getLocalId())) {
            super(obj12.getLocalId(), f, callback3, this.supportUiStorage, this.af, this.belvedere, this.sdkVersion);
            this.executorService.execute(loadComments2);
        } else {
            f.c(this.af.skipAction());
            callback3.done();
        }
    }
}
