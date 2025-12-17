package zendesk.core;

import android.content.Context;
import com.google.gson.JsonElement;
import com.zendesk.service.a;
import com.zendesk.service.d;
import com.zendesk.service.f;
import f.g.c.a;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import retrofit2.Call;
import retrofit2.Response;

/* loaded from: classes3.dex */
class ZendeskSettingsProvider implements zendesk.core.SettingsProvider, zendesk.core.SdkSettingsProviderInternal {

    private static final String LOG_TAG = "ZendeskSdkSettingsProvi";
    static final int SDK_SETTINGS_MAX_AGE_HOURS = 1;
    private final zendesk.core.ActionHandlerRegistry actionHandlerRegistry;
    private final String applicationId;
    private final Context context;
    private final zendesk.core.CoreSettingsStorage coreSettingsStorage;
    private final zendesk.core.Serializer serializer;
    private final zendesk.core.SdkSettingsService settingsService;
    private final zendesk.core.SettingsStorage settingsStorage;
    private final zendesk.core.ZendeskLocaleConverter zendeskLocaleConverter;
    ZendeskSettingsProvider(zendesk.core.SdkSettingsService sdkSettingsService, zendesk.core.SettingsStorage settingsStorage2, zendesk.core.CoreSettingsStorage coreSettingsStorage3, zendesk.core.ActionHandlerRegistry actionHandlerRegistry4, zendesk.core.Serializer serializer5, zendesk.core.ZendeskLocaleConverter zendeskLocaleConverter6, String string7, Context context8) {
        super();
        this.settingsService = sdkSettingsService;
        this.settingsStorage = settingsStorage2;
        this.coreSettingsStorage = coreSettingsStorage3;
        this.actionHandlerRegistry = actionHandlerRegistry4;
        this.serializer = serializer5;
        this.zendeskLocaleConverter = zendeskLocaleConverter6;
        this.applicationId = string7;
        this.context = context8;
    }

    static zendesk.core.ActionHandlerRegistry access$000(zendesk.core.ZendeskSettingsProvider zendeskSettingsProvider) {
        return zendeskSettingsProvider.actionHandlerRegistry;
    }

    static zendesk.core.SettingsStorage access$100(zendesk.core.ZendeskSettingsProvider zendeskSettingsProvider) {
        return zendeskSettingsProvider.settingsStorage;
    }

    static zendesk.core.CoreSettingsStorage access$200(zendesk.core.ZendeskSettingsProvider zendeskSettingsProvider) {
        return zendeskSettingsProvider.coreSettingsStorage;
    }

    static zendesk.core.Serializer access$300(zendesk.core.ZendeskSettingsProvider zendeskSettingsProvider) {
        return zendeskSettingsProvider.serializer;
    }

    private Map<String, JsonElement> getSettingsInternal(Locale locale) {
        Response obj4 = this.settingsService.getSettings(this.zendeskLocaleConverter.toHelpCenterLocaleString(locale), this.applicationId).execute();
        if (obj4.body() != null) {
            try {
                HashMap hashMap = new HashMap((Map)obj4.body());
                return hashMap;
                obj4 = new HashMap(0);
                return obj4;
                locale = new Object[obj0];
                a.e("ZendeskSdkSettingsProvi", "Settings retrieval failed, returning empty map.", locale);
                locale = new HashMap(obj0);
                return locale;
            }
        }
    }

    private void getSettingsInternal(Locale locale, f<Map<String, JsonElement>> f2) {
        d dVar = new d(f2);
        this.settingsService.getSettings(this.zendeskLocaleConverter.toHelpCenterLocaleString(locale), this.applicationId).enqueue(dVar);
    }

    zendesk.core.CoreSettings extractCoreSettings(Map<String, JsonElement> map) {
        String str;
        int obj3;
        if (map == null) {
            obj3 = 0;
        } else {
            obj3 = map.get("core");
        }
        obj3 = this.serializer.deserialize(obj3, CoreSettings.class);
        if ((CoreSettings)obj3 != null) {
            return (CoreSettings)obj3;
        }
        return ZendeskCoreSettingsStorage.DEFAULT_CORE_SETTINGS;
    }

    @Override // zendesk.core.SettingsProvider
    public zendesk.core.BlipsSettings getBlipsSettings() {
        return this.coreSettingsStorage.getBlipsSettings();
    }

    @Override // zendesk.core.SettingsProvider
    public zendesk.core.CoreSettings getCoreSettings() {
        if (this.settingsStorage.areSettingsUpToDate(1, obj3) != null) {
            return this.coreSettingsStorage.getCoreSettings();
        }
        Map settingsInternal = getSettingsInternal(DeviceInfo.getCurrentLocale(this.context));
        if (settingsInternal.isEmpty()) {
            Date date = new Date(0, obj3);
            CoreSettings coreSettings2 = new CoreSettings(date, 0);
            return coreSettings2;
        }
        this.actionHandlerRegistry.updateSettings(settingsInternal);
        this.settingsStorage.storeRawSettings(settingsInternal);
        return extractCoreSettings(settingsInternal);
    }

    public void getCoreSettings(f<zendesk.core.CoreSettings> f) {
        Locale settingsUpToDate;
        Object hOURS;
        if (this.settingsStorage.areSettingsUpToDate(1, obj3) != null) {
            if (f != null) {
                f.onSuccess(this.coreSettingsStorage.getCoreSettings());
            }
        } else {
            hOURS = new ZendeskSettingsProvider.1(this, f);
            getSettingsInternal(DeviceInfo.getCurrentLocale(this.context), hOURS);
        }
    }

    public <E extends zendesk.core.Settings> void getSettingsForSdk(String string, Class<E> class2, f<zendesk.core.SettingsPack<E>> f3) {
        Locale settingsUpToDate;
        Object coreSettings;
        int settingsStorage;
        Object obj5;
        Object obj6;
        if (this.settingsStorage.areSettingsUpToDate(1, obj3) != null) {
            if (f3 != null) {
                settingsUpToDate = new SettingsPack(this.coreSettingsStorage.getCoreSettings(), (Settings)this.settingsStorage.getSettings(string, class2));
                f3.onSuccess(settingsUpToDate);
                this.actionHandlerRegistry.updateSettings(this.settingsStorage.getRawSettings());
            }
        } else {
            coreSettings = new ZendeskSettingsProvider.2(this, f3, string, class2);
            getSettingsInternal(DeviceInfo.getCurrentLocale(this.context), coreSettings);
        }
    }
}
