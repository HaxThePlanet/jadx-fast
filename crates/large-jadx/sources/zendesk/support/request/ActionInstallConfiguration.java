package zendesk.support.request;

import f.g.c.a;
import f.g.e.g;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import o.b.f;
import o.b.j;
import zendesk.support.IdUtil;
import zendesk.support.SupportBlipsProvider;
import zendesk.support.SupportUiStorage;

/* loaded from: classes3.dex */
class ActionInstallConfiguration implements zendesk.support.request.AsyncMiddleware.AsyncAction {

    private final zendesk.support.request.ActionFactory af;
    private final SupportBlipsProvider blipsProvider;
    private final Executor executor;
    private final Executor mainThreadExecutor;
    private final zendesk.support.request.RequestConfiguration startConfig;
    private final SupportUiStorage supportUiStorage;
    ActionInstallConfiguration(SupportUiStorage supportUiStorage, zendesk.support.request.RequestConfiguration requestConfiguration2, Executor executor3, Executor executor4, zendesk.support.request.ActionFactory actionFactory5, SupportBlipsProvider supportBlipsProvider6) {
        super();
        this.supportUiStorage = supportUiStorage;
        this.startConfig = requestConfiguration2;
        this.executor = executor3;
        this.mainThreadExecutor = executor4;
        this.af = actionFactory5;
        this.blipsProvider = supportBlipsProvider6;
    }

    static zendesk.support.request.RequestConfiguration access$000(zendesk.support.request.ActionInstallConfiguration actionInstallConfiguration) {
        return actionInstallConfiguration.startConfig;
    }

    static SupportUiStorage access$100(zendesk.support.request.ActionInstallConfiguration actionInstallConfiguration) {
        return actionInstallConfiguration.supportUiStorage;
    }

    static SupportBlipsProvider access$200(zendesk.support.request.ActionInstallConfiguration actionInstallConfiguration) {
        return actionInstallConfiguration.blipsProvider;
    }

    static zendesk.support.request.ActionFactory access$300(zendesk.support.request.ActionInstallConfiguration actionInstallConfiguration) {
        return actionInstallConfiguration.af;
    }

    static Executor access$400(zendesk.support.request.ActionInstallConfiguration actionInstallConfiguration) {
        return actionInstallConfiguration.mainThreadExecutor;
    }

    @Override // zendesk.support.request.AsyncMiddleware$AsyncAction
    public void actionQueued(f f, j j2) {
    }

    @Override // zendesk.support.request.AsyncMiddleware$AsyncAction
    public void execute(f f, j j2, zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback3) {
        ActionInstallConfiguration.1 anon = new ActionInstallConfiguration.1(this, f, callback3);
        this.executor.execute(anon);
    }
}
