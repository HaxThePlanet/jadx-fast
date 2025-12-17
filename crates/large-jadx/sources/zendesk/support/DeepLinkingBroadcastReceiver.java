package zendesk.support;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import f.g.c.a;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;

/* loaded from: classes3.dex */
public class DeepLinkingBroadcastReceiver extends BroadcastReceiver {

    public static final String EXTRA_BACK_STACK_ACTIVITIES = "extra_follow_up_activities";
    public static final String EXTRA_REQUEST_INTENT = "extra_request_intent";
    private static final String LOG_TAG = "DeepLinkingBroadcastReceiver";
    ActionHandlerRegistry registry;
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent2) {
        Object obj5;
        zendesk.support.SdkDependencyProvider iNSTANCE = SdkDependencyProvider.INSTANCE;
        if (!iNSTANCE.isInitialized()) {
            a.e("DeepLinkingBroadcastReceiver", "Cannot use Support SDK without initializing Zendesk. Call Zendesk.INSTANCE.init(...) and Support.INSTANCE.init(Zendesk)", new Object[0]);
        }
        iNSTANCE.provideSupportSdkComponent().inject(this);
        ActionHandler handlerByAction = this.registry.handlerByAction("request_view_conversation");
        if (handlerByAction != null) {
            handlerByAction.handle(DeepLinkToRequestActionHandler.data((Intent)intent2.getParcelableExtra("extra_request_intent"), intent2.getParcelableArrayListExtra("extra_follow_up_activities")), context);
        }
    }
}
