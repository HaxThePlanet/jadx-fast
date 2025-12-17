package zendesk.core;

import android.content.Context;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zendesk.service.g;
import f.g.c.a;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;

/* loaded from: classes3.dex */
class ZendeskApplicationModule {

    static final String APPLICATION_CONTEXT = "application_context";
    static final String BASE_64_SERIALIZER = "base_64_serializer";
    private static final int THREAD_POOL_SIZE = 5;
    private zendesk.core.ApplicationConfiguration applicationConfiguration;
    private Context context;
    ZendeskApplicationModule(Context context, zendesk.core.ApplicationConfiguration applicationConfiguration2) {
        super();
        this.context = context.getApplicationContext();
        this.applicationConfiguration = applicationConfiguration2;
    }

    static zendesk.core.DeviceInfo provideDeviceInfo(Context context) {
        DeviceInfo deviceInfo = new DeviceInfo(context);
        return deviceInfo;
    }

    static ScheduledExecutorService provideExecutor() {
        ZendeskApplicationModule.1 anon = new ZendeskApplicationModule.1();
        return Executors.newScheduledThreadPool(5, anon);
    }

    static ExecutorService provideExecutorService(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService;
    }

    static Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        int[] iArr = new int[2];
        iArr = new int[]{128, 8};
        g gVar = new g();
        return gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).excludeFieldsWithModifiers(iArr).registerTypeAdapter(Date.class, gVar).create();
    }

    static HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor.Level bASIC;
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        bASIC = a.h() ? HttpLoggingInterceptor.Level.BASIC : HttpLoggingInterceptor.Level.NONE;
        httpLoggingInterceptor.setLevel(bASIC);
        return httpLoggingInterceptor;
    }

    static zendesk.core.ZendeskShadow provideZendesk(zendesk.core.Storage storage, zendesk.core.LegacyIdentityMigrator legacyIdentityMigrator2, zendesk.core.IdentityManager identityManager3, zendesk.core.BlipsCoreProvider blipsCoreProvider4, zendesk.core.PushRegistrationProvider pushRegistrationProvider5, zendesk.core.CoreModule coreModule6, zendesk.core.ProviderStore providerStore7) {
        super(storage, legacyIdentityMigrator2, identityManager3, blipsCoreProvider4, pushRegistrationProvider5, coreModule6, providerStore7);
        return zendeskShadow2;
    }

    zendesk.core.ApplicationConfiguration provideApplicationConfiguration() {
        return this.applicationConfiguration;
    }

    Context provideApplicationContext() {
        return this.context;
    }

    zendesk.core.Serializer provideBase64Serializer(zendesk.core.Serializer serializer) {
        ZendeskBase64Serializer zendeskBase64Serializer = new ZendeskBase64Serializer(serializer);
        return zendeskBase64Serializer;
    }

    zendesk.core.ZendeskLocaleConverter provideZendeskLocaleConverter() {
        ZendeskLocaleConverter zendeskLocaleConverter = new ZendeskLocaleConverter();
        return zendeskLocaleConverter;
    }
}
