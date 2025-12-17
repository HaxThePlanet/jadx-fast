package zendesk.support;

import android.content.Context;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.SdkStartUpProvider;
import zendesk.core.Zendesk;

/* loaded from: classes3.dex */
public final class SupportSdkStartupProvider extends SdkStartUpProvider {

    private zendesk.support.CreateRequestActionHandler createRequestActionHandler;
    private zendesk.support.RequestListActionHandler requestListActionHandler;
    @Override // zendesk.core.SdkStartUpProvider
    protected void onStartUp(Context context) {
        ActionHandlerRegistry actionHandlerRegistry = Zendesk.INSTANCE.actionHandlerRegistry();
        zendesk.support.CreateRequestActionHandler createRequestActionHandler = this.createRequestActionHandler;
        if (createRequestActionHandler != null) {
            actionHandlerRegistry.remove(createRequestActionHandler);
        }
        zendesk.support.RequestListActionHandler requestListActionHandler = this.requestListActionHandler;
        if (requestListActionHandler != null) {
            actionHandlerRegistry.remove(requestListActionHandler);
        }
        CreateRequestActionHandler createRequestActionHandler2 = new CreateRequestActionHandler(context);
        this.createRequestActionHandler = createRequestActionHandler2;
        RequestListActionHandler obj3 = new RequestListActionHandler();
        this.requestListActionHandler = obj3;
        actionHandlerRegistry.add(this.createRequestActionHandler);
        actionHandlerRegistry.add(this.requestListActionHandler);
    }
}
