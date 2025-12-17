package zendesk.support;

import zendesk.support.request.RequestComponent;
import zendesk.support.request.RequestModule;
import zendesk.support.requestlist.RequestListComponent;
import zendesk.support.requestlist.RequestListModule;
import zendesk.support.requestlist.RequestListViewModule;

/* loaded from: classes3.dex */
public interface SupportSdkComponent {

    public static final String SUPPORT_MAIN_THREAD_EXECUTOR = "SUPPORT_MAIN_THREAD_EXECUTOR";
    public abstract void inject(zendesk.support.DeepLinkingBroadcastReceiver deepLinkingBroadcastReceiver);

    public abstract void inject(zendesk.support.SdkDependencyProvider sdkDependencyProvider);

    public abstract RequestComponent plus(RequestModule requestModule);

    public abstract RequestListComponent plus(RequestListModule requestListModule, RequestListViewModule requestListViewModule2);
}
