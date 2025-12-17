package zendesk.core;

import com.zendesk.service.b;
import com.zendesk.service.d;
import com.zendesk.service.d.b;
import com.zendesk.service.f;
import f.g.c.a;
import f.g.e.d;
import f.g.e.g;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
class ZendeskPushRegistrationProvider implements zendesk.core.PushRegistrationProvider, zendesk.core.PushRegistrationProviderInternal {

    private static final String LOG_TAG = "PushRegistrationProvider";
    private static final d.b<zendesk.core.PushRegistrationResponseWrapper, String> PUSH_RESPONSE_EXTRACTOR;
    private final zendesk.core.BlipsCoreProvider blipsProvider;
    private final zendesk.core.IdentityManager identityManager;
    private final Locale locale;
    private final zendesk.core.PushDeviceIdStorage pushIdStorage;
    private final zendesk.core.PushRegistrationService pushService;
    private final zendesk.core.SettingsProvider settingsProvider;

    static enum TokenType {

        Identifier(false),
        UrbanAirshipChannelId("urban_airship_channel_id");

        final String name;
        @Override // java.lang.Enum
        String getName() {
            return this.name;
        }
    }
    static {
        ZendeskPushRegistrationProvider.4 anon = new ZendeskPushRegistrationProvider.4();
        ZendeskPushRegistrationProvider.PUSH_RESPONSE_EXTRACTOR = anon;
    }

    ZendeskPushRegistrationProvider(zendesk.core.PushRegistrationService pushRegistrationService, zendesk.core.IdentityManager identityManager2, zendesk.core.SettingsProvider settingsProvider3, zendesk.core.BlipsCoreProvider blipsCoreProvider4, zendesk.core.PushDeviceIdStorage pushDeviceIdStorage5, Locale locale6) {
        super();
        this.pushService = pushRegistrationService;
        this.identityManager = identityManager2;
        this.settingsProvider = settingsProvider3;
        this.blipsProvider = blipsCoreProvider4;
        this.pushIdStorage = pushDeviceIdStorage5;
        this.locale = locale6;
    }

    static Locale access$000(zendesk.core.ZendeskPushRegistrationProvider zendeskPushRegistrationProvider) {
        return zendeskPushRegistrationProvider.locale;
    }

    static zendesk.core.PushRegistrationRequest access$100(zendesk.core.ZendeskPushRegistrationProvider zendeskPushRegistrationProvider, String string2, Locale locale3, zendesk.core.AuthenticationType authenticationType4, zendesk.core.ZendeskPushRegistrationProvider.TokenType zendeskPushRegistrationProvider$TokenType5) {
        return zendeskPushRegistrationProvider.getPushRegistrationRequest(string2, locale3, authenticationType4, tokenType5);
    }

    static boolean access$200(zendesk.core.ZendeskPushRegistrationProvider zendeskPushRegistrationProvider) {
        return zendeskPushRegistrationProvider.hasNoStoredAccessToken();
    }

    static void access$300(zendesk.core.ZendeskPushRegistrationProvider zendeskPushRegistrationProvider, zendesk.core.PushRegistrationRequest pushRegistrationRequest2, f f3) {
        zendeskPushRegistrationProvider.storePendingPushRegistrationRequest(pushRegistrationRequest2, f3);
    }

    static void access$400(zendesk.core.ZendeskPushRegistrationProvider zendeskPushRegistrationProvider, zendesk.core.PushRegistrationRequest pushRegistrationRequest2, f f3) {
        zendeskPushRegistrationProvider.sendPushRegistrationRequest(pushRegistrationRequest2, f3);
    }

    static zendesk.core.PushDeviceIdStorage access$500(zendesk.core.ZendeskPushRegistrationProvider zendeskPushRegistrationProvider) {
        return zendeskPushRegistrationProvider.pushIdStorage;
    }

    static zendesk.core.BlipsCoreProvider access$600(zendesk.core.ZendeskPushRegistrationProvider zendeskPushRegistrationProvider) {
        return zendeskPushRegistrationProvider.blipsProvider;
    }

    static void access$700(zendesk.core.ZendeskPushRegistrationProvider zendeskPushRegistrationProvider, String string2) {
        zendeskPushRegistrationProvider.onSuccessfulRegistration(string2);
    }

    private boolean checkForStoredPushRegistration(String string, f<String> f2) {
        boolean bVar;
        boolean registeredDeviceId;
        boolean obj5;
        String obj6;
        final int i = 1;
        final String str = "PushRegistrationProvider";
        final int i2 = 0;
        obj5 = "Invalid identifier provided.";
        if (!g.c(string) && f2 != null) {
            obj5 = "Invalid identifier provided.";
            if (f2 != null) {
                bVar = new b(obj5);
                f2.onError(bVar);
            }
            a.k(str, obj5, new Object[i2]);
            return i;
        }
        if (this.pushIdStorage.hasRegisteredDeviceId() != null && string.equals(this.pushIdStorage.getRegisteredDeviceId()) != null && f2 != null) {
            if (string.equals(this.pushIdStorage.getRegisteredDeviceId()) != null) {
                if (f2 != null) {
                    f2.onSuccess(string);
                }
                a.b(str, "Skipping registration because device is already registered with this ID.", new Object[i2]);
                return i;
            }
        }
        if (this.pushIdStorage.hasRegisteredDeviceId() != null) {
            this.pushIdStorage.removeRegisteredDeviceId();
            a.b(str, "Removing stored push registration response because a new one has been provided.", new Object[i2]);
        }
        return i2;
    }

    private void getAuthTypeAndRequest(String string, zendesk.core.ZendeskPushRegistrationProvider.TokenType zendeskPushRegistrationProvider$TokenType2, f<String> f3) {
        if (checkForStoredPushRegistration(string, f3)) {
        }
        super(this, f3, f3, string, tokenType2);
        this.settingsProvider.getCoreSettings(anon2);
    }

    private zendesk.core.PushRegistrationRequest getPushRegistrationRequest(String string, Locale locale2, zendesk.core.AuthenticationType authenticationType3, zendesk.core.ZendeskPushRegistrationProvider.TokenType zendeskPushRegistrationProvider$TokenType4) {
        Object obj2;
        PushRegistrationRequest pushRegistrationRequest = new PushRegistrationRequest();
        pushRegistrationRequest.setIdentifier(string);
        pushRegistrationRequest.setLocale(d.d(locale2));
        if (tokenType4 == ZendeskPushRegistrationProvider.TokenType.UrbanAirshipChannelId) {
            pushRegistrationRequest.setTokenType(tokenType4.name);
        }
        if (AuthenticationType.ANONYMOUS == authenticationType3) {
            pushRegistrationRequest.setSdkGuid(this.identityManager.getSdkGuid());
        }
        return pushRegistrationRequest;
    }

    private boolean hasNoStoredAccessToken() {
        int i;
        i = this.identityManager.getStoredAccessTokenAsBearerToken() == null ? 1 : 0;
        return i;
    }

    private void onSuccessfulRegistration(String string) {
        this.pushIdStorage.storeRegisteredDeviceId(string);
        this.pushIdStorage.removePushRegistrationRequest();
        this.blipsProvider.corePushEnabled();
    }

    private void sendPushRegistrationRequest(zendesk.core.PushRegistrationRequest pushRegistrationRequest, f<String> f2) {
        PushRegistrationRequestWrapper pushRegistrationRequestWrapper = new PushRegistrationRequestWrapper(pushRegistrationRequest);
        ZendeskPushRegistrationProvider.3 anon = new ZendeskPushRegistrationProvider.3(this, f2, f2);
        d dVar = new d(anon, ZendeskPushRegistrationProvider.PUSH_RESPONSE_EXTRACTOR);
        this.pushService.registerDevice(pushRegistrationRequestWrapper).enqueue(dVar);
    }

    private void storePendingPushRegistrationRequest(zendesk.core.PushRegistrationRequest pushRegistrationRequest, f<String> f2) {
        Object obj2;
        this.pushIdStorage.storePushRegistrationRequest(pushRegistrationRequest);
        if (f2 != null) {
            f2.onSuccess(pushRegistrationRequest.getIdentifier());
        }
    }

    @Override // zendesk.core.PushRegistrationProvider
    public boolean isRegisteredForPush() {
        return this.pushIdStorage.hasRegisteredDeviceId();
    }

    public void registerWithDeviceIdentifier(String string, f<String> f2) {
        getAuthTypeAndRequest(string, ZendeskPushRegistrationProvider.TokenType.Identifier, f2);
    }

    public void registerWithUAChannelId(String string, f<String> f2) {
        getAuthTypeAndRequest(string, ZendeskPushRegistrationProvider.TokenType.UrbanAirshipChannelId, f2);
    }

    @Override // zendesk.core.PushRegistrationProvider
    public String sendPushRegistrationRequest(zendesk.core.PushRegistrationRequest pushRegistrationRequest) {
        Object registrationResponse;
        zendesk.core.PushRegistrationRequestWrapper pushRegistrationRequestWrapper;
        String str;
        Response obj4;
        try {
            pushRegistrationRequestWrapper = new PushRegistrationRequestWrapper(pushRegistrationRequest);
            obj4 = this.pushService.registerDevice(pushRegistrationRequestWrapper).execute();
            if (obj4.body() != null && (PushRegistrationResponseWrapper)obj4.body().getRegistrationResponse() != null) {
            }
            if ((PushRegistrationResponseWrapper)obj4.body().getRegistrationResponse() != null) {
            }
            obj4 = (PushRegistrationResponseWrapper)obj4.body().getRegistrationResponse().getIdentifier();
            onSuccessfulRegistration(obj4);
            return obj4;
            int arr = 0;
            arr = new Object[arr];
            a.d("PushRegistrationProvider", "Push registration request failed.", pushRegistrationRequest, arr);
            return "";
        }
    }

    public void unregisterDevice(f<Void> f) {
        Object registeredDeviceId;
        d dVar;
        zendesk.core.ZendeskPushRegistrationProvider.2 anon;
        registeredDeviceId = this.pushIdStorage.getRegisteredDeviceId();
        if (registeredDeviceId != null) {
            anon = new ZendeskPushRegistrationProvider.2(this, f, this.identityManager.getUserId(), f);
            dVar = new d(anon);
            this.pushService.unregisterDevice(registeredDeviceId).enqueue(dVar);
        }
    }
}
