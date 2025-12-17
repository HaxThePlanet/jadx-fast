package zendesk.support.request;

import com.zendesk.service.a;
import com.zendesk.service.f;
import f.g.c.a;
import f.g.e.g;
import o.b.f;
import o.b.j;
import zendesk.support.Request;
import zendesk.support.RequestProvider;

/* loaded from: classes3.dex */
class ActionLoadRequest implements zendesk.support.request.AsyncMiddleware.AsyncAction {

    private final zendesk.support.request.ActionFactory af;
    private final RequestProvider requestProvider;
    ActionLoadRequest(zendesk.support.request.ActionFactory actionFactory, RequestProvider requestProvider2) {
        super();
        this.af = actionFactory;
        this.requestProvider = requestProvider2;
    }

    static zendesk.support.request.ActionFactory access$000(zendesk.support.request.ActionLoadRequest actionLoadRequest) {
        return actionLoadRequest.af;
    }

    @Override // zendesk.support.request.AsyncMiddleware$AsyncAction
    public void actionQueued(f f, j j2) {
        f.c(this.af.loadRequest());
    }

    @Override // zendesk.support.request.AsyncMiddleware$AsyncAction
    public void execute(f f, j j2, zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback3) {
        zendesk.support.request.StateConversation obj6 = StateConversation.fromState(j2.getState());
        String remoteId = obj6.getRemoteId();
        final int i = 0;
        final String str3 = "RequestActivity";
        if (!g.c(remoteId)) {
            a.b(str3, "Skip loading request. No remote id found.", new Object[i]);
            f.c(this.af.skipAction());
            callback3.done();
        }
        if (obj6.getStatus() != null) {
            a.b(str3, "Skip loading request. Request status already available.", new Object[i]);
            f.c(this.af.skipAction());
            callback3.done();
        }
        ActionLoadRequest.1 anon = new ActionLoadRequest.1(this, f, callback3);
        this.requestProvider.getRequest(remoteId, anon);
    }
}
