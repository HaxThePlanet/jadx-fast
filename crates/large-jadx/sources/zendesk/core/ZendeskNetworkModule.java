package zendesk.core;

import android.content.Context;
import com.google.gson.Gson;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes3.dex */
class ZendeskNetworkModule {

    private static final String BASE_OK_HTTP = "BaseOkHttp";
    private static final String CORE_OK_HTTP = "CoreOkHttp";
    static final String CORE_RETROFIT = "CoreRetrofit";
    private static final String MEDIA_OK_HTTP = "MediaOkHttp";
    static final String PUSH_PROVIDER_RETROFIT = "PushProviderRetrofit";
    private static final String STANDARD_OK_HTTP = "StandardOkHttp";
    static final String STANDARD_RETROFIT = "Retrofit";
    static zendesk.core.AcceptLanguageHeaderInterceptor provideAcceptLanguageHeaderInterceptor(Context context) {
        AcceptLanguageHeaderInterceptor acceptLanguageHeaderInterceptor = new AcceptLanguageHeaderInterceptor(context);
        return acceptLanguageHeaderInterceptor;
    }

    static zendesk.core.ZendeskAccessInterceptor provideAccessInterceptor(zendesk.core.IdentityManager identityManager, zendesk.core.AccessProvider accessProvider2, zendesk.core.Storage storage3, zendesk.core.CoreSettingsStorage coreSettingsStorage4) {
        ZendeskAccessInterceptor zendeskAccessInterceptor = new ZendeskAccessInterceptor(identityManager, accessProvider2, storage3, coreSettingsStorage4);
        return zendeskAccessInterceptor;
    }

    static zendesk.core.ZendeskAuthHeaderInterceptor provideAuthHeaderInterceptor(zendesk.core.IdentityManager identityManager) {
        ZendeskAuthHeaderInterceptor zendeskAuthHeaderInterceptor = new ZendeskAuthHeaderInterceptor(identityManager);
        return zendeskAuthHeaderInterceptor;
    }

    static zendesk.core.CachingInterceptor provideCachingInterceptor(zendesk.core.BaseStorage baseStorage) {
        CachingInterceptor cachingInterceptor = new CachingInterceptor(baseStorage);
        return cachingInterceptor;
    }

    static Retrofit provideCoreRetrofit(zendesk.core.ApplicationConfiguration applicationConfiguration, Gson gson2, OkHttpClient okHttpClient3) {
        Retrofit.Builder builder = new Retrofit.Builder();
        return builder.baseUrl(applicationConfiguration.getZendeskUrl()).addConverterFactory(GsonConverterFactory.create(gson2)).client(okHttpClient3).build();
    }

    static zendesk.core.ZendeskPushInterceptor providePushInterceptor(zendesk.core.PushRegistrationProviderInternal pushRegistrationProviderInternal, zendesk.core.PushDeviceIdStorage pushDeviceIdStorage2, zendesk.core.IdentityStorage identityStorage3) {
        ZendeskPushInterceptor zendeskPushInterceptor = new ZendeskPushInterceptor(pushRegistrationProviderInternal, pushDeviceIdStorage2, identityStorage3);
        return zendeskPushInterceptor;
    }

    static Retrofit providePushProviderRetrofit(zendesk.core.ApplicationConfiguration applicationConfiguration, Gson gson2, OkHttpClient okHttpClient3, zendesk.core.ZendeskAuthHeaderInterceptor zendeskAuthHeaderInterceptor4) {
        Retrofit.Builder builder = new Retrofit.Builder();
        return builder.baseUrl(applicationConfiguration.getZendeskUrl()).addConverterFactory(GsonConverterFactory.create(gson2)).client(okHttpClient3.newBuilder().addInterceptor(zendeskAuthHeaderInterceptor4).build()).build();
    }

    static Retrofit provideRetrofit(zendesk.core.ApplicationConfiguration applicationConfiguration, Gson gson2, OkHttpClient okHttpClient3) {
        Retrofit.Builder builder = new Retrofit.Builder();
        return builder.baseUrl(applicationConfiguration.getZendeskUrl()).addConverterFactory(GsonConverterFactory.create(gson2)).client(okHttpClient3).build();
    }

    static zendesk.core.ZendeskSettingsInterceptor provideSettingsInterceptor(zendesk.core.SdkSettingsProviderInternal sdkSettingsProviderInternal, zendesk.core.SettingsStorage settingsStorage2) {
        ZendeskSettingsInterceptor zendeskSettingsInterceptor = new ZendeskSettingsInterceptor(sdkSettingsProviderInternal, settingsStorage2);
        return zendeskSettingsInterceptor;
    }

    static zendesk.core.ZendeskUnauthorizedInterceptor provideZendeskUnauthorizedInterceptor(zendesk.core.SessionStorage sessionStorage) {
        ZendeskUnauthorizedInterceptor zendeskUnauthorizedInterceptor = new ZendeskUnauthorizedInterceptor(sessionStorage);
        return zendeskUnauthorizedInterceptor;
    }

    static zendesk.core.AcceptHeaderInterceptor providesAcceptHeaderInterceptor() {
        AcceptHeaderInterceptor acceptHeaderInterceptor = new AcceptHeaderInterceptor();
        return acceptHeaderInterceptor;
    }

    OkHttpClient provideBaseOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor, zendesk.core.ZendeskOauthIdHeaderInterceptor zendeskOauthIdHeaderInterceptor2, zendesk.core.UserAgentAndClientHeadersInterceptor userAgentAndClientHeadersInterceptor3, ExecutorService executorService4) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit obj4 = TimeUnit.SECONDS;
        int i = 30;
        obj4 = new Dispatcher(executorService4);
        return Tls12SocketFactory.enableTls12OnPreLollipop(builder).addInterceptor(zendeskOauthIdHeaderInterceptor2).addInterceptor(httpLoggingInterceptor).addInterceptor(userAgentAndClientHeadersInterceptor3).connectTimeout(i, obj1).readTimeout(i, obj1).writeTimeout(i, obj1).dispatcher(obj4).build();
    }

    OkHttpClient provideCoreOkHttpClient(OkHttpClient okHttpClient, zendesk.core.AcceptLanguageHeaderInterceptor acceptLanguageHeaderInterceptor2, zendesk.core.AcceptHeaderInterceptor acceptHeaderInterceptor3) {
        return okHttpClient.newBuilder().addInterceptor(acceptLanguageHeaderInterceptor2).addInterceptor(acceptHeaderInterceptor3).build();
    }

    OkHttpClient provideMediaOkHttpClient(OkHttpClient okHttpClient, zendesk.core.ZendeskAccessInterceptor zendeskAccessInterceptor2, zendesk.core.ZendeskAuthHeaderInterceptor zendeskAuthHeaderInterceptor3, zendesk.core.ZendeskSettingsInterceptor zendeskSettingsInterceptor4, zendesk.core.CachingInterceptor cachingInterceptor5, zendesk.core.ZendeskUnauthorizedInterceptor zendeskUnauthorizedInterceptor6) {
        return okHttpClient.newBuilder().addInterceptor(zendeskSettingsInterceptor4).addInterceptor(cachingInterceptor5).addInterceptor(zendeskAccessInterceptor2).addInterceptor(zendeskAuthHeaderInterceptor3).addInterceptor(zendeskUnauthorizedInterceptor6).build();
    }

    OkHttpClient provideOkHttpClient(OkHttpClient okHttpClient, zendesk.core.ZendeskAccessInterceptor zendeskAccessInterceptor2, zendesk.core.ZendeskUnauthorizedInterceptor zendeskUnauthorizedInterceptor3, zendesk.core.ZendeskAuthHeaderInterceptor zendeskAuthHeaderInterceptor4, zendesk.core.ZendeskSettingsInterceptor zendeskSettingsInterceptor5, zendesk.core.AcceptHeaderInterceptor acceptHeaderInterceptor6, zendesk.core.ZendeskPushInterceptor zendeskPushInterceptor7, Cache cache8) {
        return okHttpClient.newBuilder().addInterceptor(zendeskSettingsInterceptor5).addInterceptor(zendeskAccessInterceptor2).addInterceptor(zendeskAuthHeaderInterceptor4).addInterceptor(zendeskUnauthorizedInterceptor3).addInterceptor(acceptHeaderInterceptor6).addInterceptor(zendeskPushInterceptor7).cache(cache8).build();
    }

    zendesk.core.RestServiceProvider provideRestServiceProvider(Retrofit retrofit, OkHttpClient okHttpClient2, OkHttpClient okHttpClient3, OkHttpClient okHttpClient4) {
        ZendeskRestServiceProvider zendeskRestServiceProvider = new ZendeskRestServiceProvider(retrofit, okHttpClient2, okHttpClient3, okHttpClient4);
        return zendeskRestServiceProvider;
    }

    zendesk.core.ZendeskOauthIdHeaderInterceptor provideZendeskBasicHeadersInterceptor(zendesk.core.ApplicationConfiguration applicationConfiguration) {
        ZendeskOauthIdHeaderInterceptor zendeskOauthIdHeaderInterceptor = new ZendeskOauthIdHeaderInterceptor(applicationConfiguration.getOauthClientId());
        return zendeskOauthIdHeaderInterceptor;
    }

    zendesk.core.UserAgentAndClientHeadersInterceptor providesUserAgentHeaderInterceptor() {
        UserAgentAndClientHeadersInterceptor userAgentAndClientHeadersInterceptor = new UserAgentAndClientHeadersInterceptor("4.0.3", "Core");
        return userAgentAndClientHeadersInterceptor;
    }
}
