package zendesk.support;

import f.g.e.g;
import java.util.HashMap;
import java.util.Map;
import zendesk.core.BlipsGroup;
import zendesk.core.BlipsProvider;
import zendesk.core.UserAction;

/* loaded from: classes3.dex */
class ZendeskSupportBlipsProvider implements zendesk.support.SupportBlipsProvider {

    private static final String BLIPS_FIELD_NAME_REQUEST_ID = "requestId";
    private static final String BLIPS_SUPPORT_ACTION_INIT = "init";
    private static final String BLIPS_SUPPORT_ACTION_REQUEST_CREATED = "requestCreated";
    private static final String BLIPS_SUPPORT_ACTION_REQUEST_LIST_VIEWED = "requestListViewed";
    private static final String BLIPS_SUPPORT_ACTION_REQUEST_UPDATED = "requestUpdated";
    private static final String BLIPS_SUPPORT_ACTION_REQUEST_VIEWED = "requestViewed";
    private static final String BLIPS_SUPPORT_CATEGORY = "SupportSDK";
    private static final String BLIPS_SUPPORT_CHANNEL = "support_sdk";
    private static final String BLIPS_SUPPORT_VERSION = "5.0.3";
    private BlipsProvider blipsProvider;
    ZendeskSupportBlipsProvider(BlipsProvider blipsProvider) {
        super();
        this.blipsProvider = blipsProvider;
    }

    private void sendUserAction(BlipsGroup blipsGroup, String string2, Map<String, Object> map3) {
        super("5.0.3", "support_sdk", "SupportSDK", string2, 0, map3);
        this.blipsProvider.sendBlip(userAction2, blipsGroup);
    }

    @Override // zendesk.support.SupportBlipsProvider
    public void requestCreated(String string) {
        if (g.e(string)) {
        }
        HashMap hashMap = new HashMap();
        hashMap.put("requestId", string);
        sendUserAction(BlipsGroup.BEHAVIOURAL, "requestCreated", hashMap);
    }

    @Override // zendesk.support.SupportBlipsProvider
    public void requestListViewed() {
        sendUserAction(BlipsGroup.BEHAVIOURAL, "requestListViewed", 0);
    }

    @Override // zendesk.support.SupportBlipsProvider
    public void requestUpdated(String string) {
        if (g.e(string)) {
        }
        HashMap hashMap = new HashMap();
        hashMap.put("requestId", string);
        sendUserAction(BlipsGroup.BEHAVIOURAL, "requestUpdated", hashMap);
    }

    @Override // zendesk.support.SupportBlipsProvider
    public void requestViewed(String string) {
        if (g.e(string)) {
        }
        HashMap hashMap = new HashMap();
        hashMap.put("requestId", string);
        sendUserAction(BlipsGroup.BEHAVIOURAL, "requestViewed", hashMap);
    }

    @Override // zendesk.support.SupportBlipsProvider
    public void supportSdkInit() {
        sendUserAction(BlipsGroup.REQUIRED, "init", 0);
    }
}
