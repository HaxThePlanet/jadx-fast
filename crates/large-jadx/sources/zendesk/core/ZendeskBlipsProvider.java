package zendesk.core;

import com.zendesk.service.d;
import f.g.e.g;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import retrofit2.Call;

/* loaded from: classes3.dex */
class ZendeskBlipsProvider implements zendesk.core.BlipsProvider, zendesk.core.BlipsCoreProvider {

    static final String ACTION_CORE_INIT = "init";
    static final String ACTION_CORE_PUSH_OFF = "PushOff";
    static final String ACTION_CORE_PUSH_ON = "PushOn";
    static final String BLIPS_CORE_CATEGORY = "CoreSDK";
    private static final String BLIP_VALUE_STRING = "payload";
    private static final String CHANNEL_CORE_SDK = "core_sdk";
    private static final String CODE_FIELD_NAME_STRING = "code";
    private static final String CODE_VALUE_JAVA_STRING = "java";
    private static final String CORE_VERSION_STRING = "4.0.3";
    private static final String DEVICE_INFO_FIELD_STRING = "device";
    private static final String LOG_TAG = "ZendeskBlipsProvider";
    private final String appId;
    private final zendesk.core.BlipsService blipsService;
    private final zendesk.core.CoreSettingsStorage coreSettingsStorage;
    private final zendesk.core.DeviceInfo deviceInfo;
    private final Executor executor;
    private final zendesk.core.IdentityManager identityManager;
    private final zendesk.core.Serializer serializer;
    ZendeskBlipsProvider(zendesk.core.BlipsService blipsService, zendesk.core.DeviceInfo deviceInfo2, zendesk.core.Serializer serializer3, zendesk.core.IdentityManager identityManager4, String string5, zendesk.core.CoreSettingsStorage coreSettingsStorage6, Executor executor7) {
        super();
        this.blipsService = blipsService;
        this.deviceInfo = deviceInfo2;
        this.serializer = serializer3;
        this.identityManager = identityManager4;
        this.appId = string5;
        this.coreSettingsStorage = coreSettingsStorage6;
        this.executor = executor7;
    }

    static zendesk.core.Serializer access$000(zendesk.core.ZendeskBlipsProvider zendeskBlipsProvider) {
        return zendeskBlipsProvider.serializer;
    }

    static zendesk.core.BlipsService access$100(zendesk.core.ZendeskBlipsProvider zendeskBlipsProvider) {
        return zendeskBlipsProvider.blipsService;
    }

    private Map<String, Object> addDeviceInfoToValue(Map<String, Object> map) {
        Map empty;
        HashMap hashMap = new HashMap();
        hashMap.put("device", this.deviceInfo.getInfo());
        if (map != null && !map.isEmpty()) {
            if (!map.isEmpty()) {
                hashMap.put("payload", map);
            }
        }
        return hashMap;
    }

    @Override // zendesk.core.BlipsProvider
    public void coreInitialized() {
        HashMap hashMap = new HashMap();
        hashMap.put("code", "java");
        super("4.0.3", "core_sdk", "CoreSDK", "init", 0, hashMap);
        sendBlip(userAction2, BlipsGroup.REQUIRED);
    }

    @Override // zendesk.core.BlipsProvider
    public void corePushDisabled(Long long) {
        UserAction userAction = new UserAction("4.0.3", "core_sdk", "CoreSDK", "PushOff");
        sendBlip(BlipsGroup.REQUIRED, userAction, long);
    }

    @Override // zendesk.core.BlipsProvider
    public void corePushEnabled() {
        UserAction userAction = new UserAction("4.0.3", "core_sdk", "CoreSDK", "PushOn");
        sendBlip(userAction, BlipsGroup.REQUIRED);
    }

    @Override // zendesk.core.BlipsProvider
    zendesk.core.BlipsRequest createBlipsRequest(zendesk.core.PageView pageView, String string2, String string3, Long long4) {
        Date date = new Date();
        final Object obj = this;
        return BlipsRequest.buildPageView(string2, BlipsFormatHelper.nowAsString(date), long4, string3, pageView.getVersion(), pageView.getChannel(), pageView.getUrl(), pageView.getNavigatorLanguage(), pageView.getPageTitle(), pageView.getPageId(), pageView.getPageLocale(), addDeviceInfoToValue(pageView.getValue()));
    }

    @Override // zendesk.core.BlipsProvider
    zendesk.core.BlipsRequest createBlipsRequest(zendesk.core.UserAction userAction, String string2, String string3, Long long4) {
        Date date = new Date();
        return BlipsRequest.buildUserAction(string2, BlipsFormatHelper.nowAsString(date), long4, string3, userAction.getVersion(), userAction.getChannel(), userAction.getCategory(), userAction.getAction(), userAction.getLabel(), addDeviceInfoToValue(userAction.getValue()));
    }

    @Override // zendesk.core.BlipsProvider
    void dispatchBlip(zendesk.core.BlipsRequest blipsRequest) {
        ZendeskBlipsProvider.1 anon = new ZendeskBlipsProvider.1(this, blipsRequest);
        this.executor.execute(anon);
    }

    @Override // zendesk.core.BlipsProvider
    void sendBlip(zendesk.core.BlipsGroup blipsGroup, zendesk.core.UserAction userAction2, Long long3) {
        Object blipsPermissions;
        boolean obj2;
        if (this.coreSettingsStorage.getBlipsSettings().getBlipsPermissions().isEnabled(blipsGroup) != null && g.c(userAction2.getChannel())) {
            if (g.c(userAction2.getChannel())) {
                dispatchBlip(createBlipsRequest(userAction2, this.identityManager.getBlipsUuid(), this.appId, long3));
            }
        }
    }

    @Override // zendesk.core.BlipsProvider
    public void sendBlip(zendesk.core.PageView pageView, zendesk.core.BlipsGroup blipsGroup2) {
        Object blipsPermissions;
        Long userId;
        Object obj3;
        boolean obj4;
        if (this.coreSettingsStorage.getBlipsSettings().getBlipsPermissions().isEnabled(blipsGroup2) != null && g.c(pageView.getChannel())) {
            if (g.c(pageView.getChannel())) {
                dispatchBlip(createBlipsRequest(pageView, this.identityManager.getBlipsUuid(), this.appId, this.identityManager.getUserId()));
            }
        }
    }

    @Override // zendesk.core.BlipsProvider
    public void sendBlip(zendesk.core.UserAction userAction, zendesk.core.BlipsGroup blipsGroup2) {
        sendBlip(blipsGroup2, userAction, this.identityManager.getUserId());
    }
}
