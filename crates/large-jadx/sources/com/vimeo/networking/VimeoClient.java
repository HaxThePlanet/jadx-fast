package com.vimeo.networking;

import com.google.gson.Gson;
import com.vimeo.networking.callbacks.AuthCallback;
import com.vimeo.networking.callbacks.ModelCallback;
import com.vimeo.networking.callbacks.VimeoCallback;
import com.vimeo.networking.logging.ClientLogger;
import com.vimeo.networking.logging.LoggingInterceptor;
import com.vimeo.networking.model.Comment;
import com.vimeo.networking.model.PictureResource;
import com.vimeo.networking.model.PinCodeInfo;
import com.vimeo.networking.model.Privacy.PrivacyValue;
import com.vimeo.networking.model.User;
import com.vimeo.networking.model.Video;
import com.vimeo.networking.model.VimeoAccount;
import com.vimeo.networking.model.error.ErrorCode;
import com.vimeo.networking.model.error.VimeoError;
import com.vimeo.networking.model.search.SearchResponse;
import com.vimeo.networking.utils.VimeoNetworkUtil;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.CacheControl.Builder;
import okhttp3.Credentials;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response.Builder;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

/* compiled from: VimeoClient.java */
/* loaded from: classes2.dex */
public final class VimeoClient {

    private static volatile boolean mContinuePinCodeAuthorizationRefreshCycle;
    private static VimeoClient mSharedInstance;
    private final Cache mCache;
    private final Configuration mConfiguration;
    private String mCurrentCodeGrantState;
    private final Gson mGson;
    private Timer mPinCodeAuthorizationTimer;
    private final Retrofit mRetrofit;
    private VimeoAccount mVimeoAccount;
    private final VimeoService mVimeoService;

    private static class PinCodePollingTimerTask extends TimerTask {

        private final WeakReference<AuthCallback> mAuthCallbackWeakReference = new WeakReference<>();
        private final long mExpiresInNano;
        private final PinCodeInfo mPinCodeInfo;
        private final String mScope;
        private final Timer mTimer;
        private final WeakReference<VimeoClient> mVimeoClient = new WeakReference<>();
        PinCodePollingTimerTask(PinCodeInfo pinCodeInfo, Timer timer, int i, AuthCallback authCallback, VimeoClient vimeoClient, String str) {
            super();
            this.mTimer = timer;
            this.mPinCodeInfo = pinCodeInfo;
            this.mExpiresInNano = System.nanoTime() + TimeUnit.SECONDS.toNanos((long)i);
            WeakReference weakReference = new WeakReference(authCallback);
            WeakReference weakReference2 = new WeakReference(vimeoClient);
            this.mScope = str;
        }

        @Override // java.util.TimerTask
        public void run() {
            boolean z2;
            Object obj = this.mAuthCallbackWeakReference.get();
            Object obj2 = this.mVimeoClient.get();
            long time = System.nanoTime();
            if (VimeoClient.mContinuePinCodeAuthorizationRefreshCycle) {
                if (!(time >= this.mExpiresInNano || !(obj != null && obj2 != null))) {
                    if (VimeoClient.mContinuePinCodeAuthorizationRefreshCycle) {
                        VimeoClient.mContinuePinCodeAuthorizationRefreshCycle = 0;
                        this.mTimer.cancel();
                        if (obj != null) {
                            if (time >= this.mExpiresInNano) {
                                VimeoError vimeoError = new VimeoError("Pin code expired.");
                                vimeoError.setErrorCode(ErrorCode.UNABLE_TO_LOGIN_PINCODE_EXPIRED);
                                obj.failure(vimeoError);
                            }
                        }
                    }
                }
            }
        }
    }

    private static class AccountCallback extends VimeoCallback<VimeoAccount> {

        private final AuthCallback mCallback;
        private final VimeoClient mClient;
        private String mEmail;
        public AccountCallback(AuthCallback authCallback) {
            super();
            if (vimeoClient == null) {
                throw new AssertionError("Client and Callback must not be null");
            } else {
                if (authCallback != null) {
                    this.mClient = vimeoClient;
                    this.mCallback = authCallback;
                    return;
                }
            }
        }

        @Override // com.vimeo.networking.callbacks.VimeoCallback
        public void failure(VimeoError th) {
            this.mCallback.failure(th);
        }

        @Override // com.vimeo.networking.callbacks.VimeoCallback
        public void success(VimeoAccount vimeoAccount) {
            String uri2;
            if (vimeoAccount.getUser() == null || this.mEmail != null) {
                this.mClient.saveAccount(vimeoAccount, this.mEmail);
            } else {
                if (this.mEmail.isEmpty()) {
                    uri2 = vimeoAccount.getUser().name != null ? user4.name : user3.uri;
                    this.mClient.saveAccount(vimeoAccount, uri2);
                }
            }
            this.mCallback.success();
        }

        public AccountCallback(String str, AuthCallback authCallback) {
            super();
            if (vimeoClient == null) {
                throw new AssertionError("Client and Callback must not be null");
            } else {
                if (authCallback != null) {
                    this.mClient = vimeoClient;
                    this.mEmail = str;
                    this.mCallback = authCallback;
                    return;
                }
            }
        }

        @Deprecated
        public AccountCallback(String str, String str2, AuthCallback authCallback) {
            this(vimeoClient, str, authCallback);
        }
    }

    private static class PinCodeAccountCallback extends VimeoClient.AccountCallback {

        private final Timer mTimer;
        public PinCodeAccountCallback(AuthCallback authCallback, Timer timer) {
            super(vimeoClient, authCallback);
            this.mTimer = timer;
        }

        private void cancelPolling() {
            VimeoClient.mContinuePinCodeAuthorizationRefreshCycle = 0;
            if (this.mTimer != null) {
                this.mTimer.cancel();
            }
        }

        @Override // com.vimeo.networking.VimeoClient$AccountCallback
        public void failure(VimeoError th) {
            if (VimeoClient.mContinuePinCodeAuthorizationRefreshCycle) {
                int i = 400;
                if (th.getHttpStatusCode() == 400) {
                    return;
                }
                cancelPolling();
                super.failure(th);
            }
        }

        @Override // com.vimeo.networking.VimeoClient$AccountCallback
        public void success(VimeoAccount vimeoAccount) {
            if (VimeoClient.mContinuePinCodeAuthorizationRefreshCycle) {
                cancelPolling();
                super.success(vimeoAccount);
            }
        }
    }
    private VimeoClient(Configuration configuration) {
        super();
        this.mConfiguration = configuration;
        this.mGson = VimeoNetworkUtil.getGson();
        this.mCache = configuration.getCache();
        Retrofit retrofit = createRetrofit();
        this.mRetrofit = retrofit;
        this.mVimeoService = (VimeoService)retrofit.create(VimeoService.class);
        ClientLogger.setLogProvider(configuration.logProvider);
        ClientLogger.setLogLevel(configuration.logLevel);
        setVimeoAccount(configuration.loadAccount());
    }

    private Call<Object> DELETE(String str, String str2, Map<String, String> map, VimeoCallback<Object> vimeoCallback, boolean z) {
        final Call call = this.mVimeoService.DELETE(str, str2, map);
        if (z) {
            call.enqueue(vimeoCallback);
        }
        return call;
    }

    private Call<Object> POST(String str, String str2, String str3, HashMap<String, String> hashMap, VimeoCallback<Object> vimeoCallback) {
        final Call call = this.mVimeoService.POST(str, str2, str3, hashMap);
        call.enqueue(vimeoCallback);
        return call;
    }

    private Call<Object> PUT(String str, String str2, Map<String, String> map, VimeoCallback<Object> vimeoCallback, boolean z) {
        final Call call = this.mVimeoService.PUT(str, str2, map);
        if (z) {
            call.enqueue(vimeoCallback);
        }
        return call;
    }

    static /* synthetic */ Configuration access$000(VimeoClient vimeoClient) {
        return vimeoClient.mConfiguration;
    }

    static /* synthetic */ boolean access$100() {
        return VimeoClient.mContinuePinCodeAuthorizationRefreshCycle;
    }

    static /* synthetic */ boolean access$102(boolean z) {
        VimeoClient.mContinuePinCodeAuthorizationRefreshCycle = z;
        return z;
    }

    static /* synthetic */ String access$200(VimeoClient vimeoClient) {
        return vimeoClient.getBasicAuthHeader();
    }

    static /* synthetic */ VimeoService access$300(VimeoClient vimeoClient) {
        return vimeoClient.mVimeoService;
    }

    static /* synthetic */ Timer access$400(VimeoClient vimeoClient) {
        return vimeoClient.mPinCodeAuthorizationTimer;
    }

    static /* synthetic */ Timer access$402(VimeoClient vimeoClient, Timer timer) {
        vimeoClient.mPinCodeAuthorizationTimer = timer;
        return timer;
    }

    static /* synthetic */ VimeoClient access$500() {
        return VimeoClient.mSharedInstance;
    }

    static /* synthetic */ Gson access$600(VimeoClient vimeoClient) {
        return vimeoClient.mGson;
    }

    private String createCacheControlString(CacheControl cacheControl) {
        CacheControl cacheControl_Builder;
        if (cacheControl == null) {
            cacheControl_Builder = new CacheControl_Builder().maxAge(this.mConfiguration.cacheMaxAge, TimeUnit.SECONDS).build();
        } else {
            if (cacheControl.onlyIfCached()) {
                CacheControl.Builder cacheControlBuilder = VimeoNetworkUtil.getCacheControlBuilder(cacheControl);
                int i = -1;
                if (cacheControl.maxAgeSeconds() == -1) {
                    cacheControlBuilder.maxAge(this.mConfiguration.cacheMaxAge, TimeUnit.SECONDS);
                }
                cacheControlBuilder.maxStale(0, TimeUnit.SECONDS);
                cacheControl_Builder = cacheControlBuilder.build();
            }
        }
        return cacheControl_Builder.toString();
    }

    private OkHttpClient createOkHttpClient() {
        com.vimeo.networking.RetrofitClientBuilder retrofitClientBuilder = new RetrofitClientBuilder();
        sECONDS2 = TimeUnit.SECONDS;
        retrofitClientBuilder.setCache(this.mCache).addNetworkInterceptor(new VimeoClient.AnonymousClass2(this)).setReadTimeout(this.mConfiguration.timeout, sECONDS2).setConnectionTimeout(this.mConfiguration.timeout, sECONDS2).addInterceptor(new LoggingInterceptor()).addInterceptor(new VimeoClient.AnonymousClass1(this)).addNetworkInterceptors(this.mConfiguration.networkInterceptors).addInterceptors(this.mConfiguration.interceptors);
        if (this.mConfiguration.certPinningEnabled) {
            try {
                retrofitClientBuilder.pinCertificates();
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder();
                String message = "Exception when pinning certificate: ";
                message = e.getMessage();
                stringBuilder = message + message;
                ClientLogger.e(stringBuilder, e);
            }
        }
        return retrofitClientBuilder.build();
    }

    private Retrofit createRetrofit() {
        return new Retrofit.Builder().baseUrl(this.mConfiguration.baseURLString).client(createOkHttpClient()).addConverterFactory(GsonConverterFactory.create(this.mGson)).build();
    }

    private String getBasicAuthHeader() {
        return Credentials.basic(mConfiguration2.clientID, mConfiguration2.clientSecret);
    }

    public static VimeoClient getInstance() {
        com.vimeo.networking.VimeoClient mSharedInstance2 = VimeoClient.mSharedInstance;
        if (VimeoClient.mSharedInstance == null) {
            throw new AssertionError("Instance must be configured before use");
        } else {
            return VimeoClient.mSharedInstance;
        }
    }

    private VimeoCallback<Object> getRetrofitCallback(ModelCallback<Object> modelCallback) {
        return new VimeoClient.AnonymousClass5(this, modelCallback);
    }

    public static void initialize(Configuration configuration) {
        VimeoClient.mSharedInstance = new VimeoClient(configuration);
    }

    public Call<Object> activatePictureResource(String str, ModelCallback modelCallback) {
        if (str != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("active", Boolean.TRUE);
            Call edit = this.mVimeoService.edit(getAuthHeader(), str, hashMap);
            edit.enqueue(getRetrofitCallback(modelCallback));
            return edit;
        }
        modelCallback.failure(new VimeoError("uri cannot be empty!"));
        return null;
    }

    public Call<VimeoAccount> authenticateWithCodeGrant(String str, AuthCallback authCallback) {
        if (authCallback == null) {
            throw new AssertionError("Callback cannot be null");
        } else {
            String str3 = null;
            authCallback.failure(new VimeoError("uri must not be null"));
            return str3;
        }
    }

    public Call<VimeoAccount> authorizeWithClientCredentialsGrant(AuthCallback authCallback) {
        if (authCallback == null) {
            throw new AssertionError("Callback cannot be null");
        } else {
            Call authorizeWithClientCredentialsGrant = this.mVimeoService.authorizeWithClientCredentialsGrant(getBasicAuthHeader(), "client_credentials", this.mConfiguration.scope);
            authorizeWithClientCredentialsGrant.enqueue(new VimeoClient.AccountCallback(this, authCallback));
            return authorizeWithClientCredentialsGrant;
        }
    }

    public VimeoAccount authorizeWithClientCredentialsGrantSync() {
        Object body;
        Throwable th;
        String str = null;
        boolean successful;
        String str2;
        Throwable obj;
        str2 = "client_credentials";
        str = null;
        try {
            retrofit2.Response execute = this.mVimeoService.authorizeWithClientCredentialsGrant(getBasicAuthHeader(), str2, this.mConfiguration.scope).execute();
        } catch (java.io.IOException ioException) {
        }
        return str;
    }

    public void cancelPinCodeLogin() {
        VimeoClient.mContinuePinCodeAuthorizationRefreshCycle = false;
        if (this.mPinCodeAuthorizationTimer != null) {
            this.mPinCodeAuthorizationTimer.cancel();
        }
    }

    public void clearRequestCache() {
        try {
            this.mCache.evictAll();
            ClientLogger.e("Attempt to clear null cache");
        } catch (java.io.IOException ioException) {
            StringBuilder stringBuilder = new StringBuilder();
            String message = "Cache clearing error: ";
            message = ioException.getMessage();
            stringBuilder = message + message;
            ClientLogger.e(stringBuilder, ioException);
        }
    }

    public Call<Comment> comment(String str, String str2, String str3, ModelCallback<Comment> modelCallback) {
        if (modelCallback == null) {
            throw new AssertionError("Callback cannot be null");
        } else {
            modelCallback.failure(new VimeoError("uri cannot be empty!"));
            return null;
        }
    }

    public Call<PictureResource> createPictureResource(String str, ModelCallback<PictureResource> modelCallback) {
        if (str != null) {
            Call pictureResource = this.mVimeoService.createPictureResource(getAuthHeader(), str);
            pictureResource.enqueue(modelCallback);
            return pictureResource;
        }
        modelCallback.failure(new VimeoError("uri cannot be empty!"));
        return null;
    }

    Map<String, String> createQueryMap(String str, Map<String, String> map, String str2) {
        boolean empty;
        HashMap hashMap;
        if (map == null || map.isEmpty()) {
        }
        if (str != null && !str.isEmpty()) {
            hashMap.put("query", str);
        }
        if (str2 != null && !str2.isEmpty()) {
            hashMap.put("fields", str2);
        }
        return hashMap;
    }

    public Call<Object> deleteContent(String str, Map<String, String> map, ModelCallback modelCallback, boolean z) {
        HashMap map22;
        if (modelCallback == null) {
            throw new AssertionError("Callback cannot be null");
        } else {
            modelCallback.failure(new VimeoError("uri cannot be empty!"));
            return null;
        }
    }

    public void deletePictureResource(String str, ModelCallback modelCallback) {
        if (str != null) {
            deleteContent(str, modelCallback);
            return;
        }
        modelCallback.failure(new VimeoError("uri cannot be empty!"));
    }

    public void deleteVideo(String str, Map<String, String> map, ModelCallback modelCallback) {
        deleteContent(str, map, modelCallback, true);
    }

    public Call<Object> editUser(String str, String str2, String str3, String str4, ModelCallback<Object> modelCallback) {
        String str5;
        if (modelCallback == null) {
            throw new AssertionError("Callback cannot be null");
        } else {
            int i = 0;
            modelCallback.failure(new VimeoError("uri cannot be empty!"));
            return null;
        }
    }

    public Call<Object> editVideo(String str, String str2, String str3, String str4, Privacy.PrivacyValue privacyValue, HashMap<String, Object> hashMap, ModelCallback<Object> modelCallback) {
        String str5;
        HashMap hashMap2;
        if (modelCallback == null) {
            throw new AssertionError("Callback cannot be null");
        } else {
            final int i = 0;
            modelCallback.failure(new VimeoError("uri cannot be empty!"));
            return null;
        }
    }

    public Call<Void> emptyResponsePost(String str, HashMap<String, String> hashMap, VimeoCallback<Void> vimeoCallback) {
        if (vimeoCallback == null) {
            throw new AssertionError("Callback cannot be null");
        } else {
            if (str == null) {
                vimeoCallback.failure(new VimeoError("uri cannot be empty!"));
                return null;
            }
            if (hashMap == null) {
                hashMap = new HashMap();
            }
            Call emptyResponsePost = this.mVimeoService.emptyResponsePost(getAuthHeader(), str, hashMap);
            emptyResponsePost.enqueue(vimeoCallback);
            return emptyResponsePost;
        }
    }

    public Call<VimeoAccount> exchangeOAuthOneToken(String str, String str2, AuthCallback authCallback) {
        if (authCallback == null) {
            throw new AssertionError("Callback cannot be null");
        } else {
            Call exchangeOAuthOneToken = this.mVimeoService.exchangeOAuthOneToken(getBasicAuthHeader(), "vimeo_oauth1", str, str2, this.mConfiguration.scope);
            exchangeOAuthOneToken.enqueue(new VimeoClient.AccountCallback(this, authCallback));
            return exchangeOAuthOneToken;
        }
    }

    public Call<Object> fetchCachedContent(String str, ModelCallback modelCallback) {
        return fetchContent(str, CacheControl.FORCE_CACHE, modelCallback);
    }

    public Call<Object> fetchCachedSortedContent(String str, ModelCallback modelCallback, String str2) {
        return this.fetchContent(str, CacheControl.FORCE_CACHE, modelCallback, null, new SearchRefinementBuilder(Vimeo.RefineSort.DEFAULT).build(), str2);
    }

    public Call<Object> fetchContent(String str, CacheControl cacheControl, ModelCallback modelCallback, String str2, Map<String, String> map, String str3) {
        if (str.isEmpty()) {
            modelCallback.failure(new VimeoError("Uri cannot be empty!"));
            return null;
        }
        Call call = this.mVimeoService.GET(getAuthHeader(), str, createQueryMap(str2, map, str3), createCacheControlString(cacheControl));
        call.enqueue(getRetrofitCallback(modelCallback));
        return call;
    }

    public retrofit2.Response<Object> fetchContentSync(String str, CacheControl cacheControl, String str2, Map<String, String> map, String str3) {
        if (str == null) {
            throw new AssertionError("uri cannot be null or empty");
        } else {
            if (!str.isEmpty()) {
                try {
                } catch (java.io.IOException unused) {
                    str = null;
                    return str;
                }
                return this.mVimeoService.GET(getAuthHeader(), str, createQueryMap(str2, map, str3), createCacheControlString(cacheControl)).execute();
            }
        }
    }

    public void fetchCurrentUser(ModelCallback<User> modelCallback) {
        fetchContent("me", CacheControl.FORCE_NETWORK, modelCallback);
    }

    public Call<Object> fetchNetworkContent(String str, ModelCallback modelCallback) {
        return fetchContent(str, CacheControl.FORCE_NETWORK, modelCallback);
    }

    public Call<Object> fetchNetworkSortedContent(String str, ModelCallback modelCallback, String str2) {
        return this.fetchContent(str, CacheControl.FORCE_NETWORK, modelCallback, null, new SearchRefinementBuilder(Vimeo.RefineSort.DEFAULT).build(), str2);
    }

    public retrofit2.Response<Video> fetchVideoSync(String str, String str2) {
        return fetchVideoSync(str, CacheControl.FORCE_NETWORK, str2);
    }

    public Call<Object> follow(String str, ModelCallback modelCallback, boolean z) {
        return putContent(str, null, modelCallback, z);
    }

    public String getAcceptHeader() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "application/vnd.vimeo.*+json; version=";
        str = str2 + this.mConfiguration.apiVersionString;
        return str;
    }

    public String getAuthHeader() {
        String basicAuthHeader;
        if (this.mVimeoAccount == null || !this.mVimeoAccount.isAuthenticated()) {
            basicAuthHeader = getBasicAuthHeader();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            String str = "Bearer ";
            String accessToken = this.mVimeoAccount.getAccessToken();
            basicAuthHeader = str + accessToken;
        }
        return basicAuthHeader;
    }

    public String getCodeGrantAuthorizationURI() {
        this.mCurrentCodeGrantState = UUID.randomUUID().toString();
        HttpUrl parse = HttpUrl.parse(this.mConfiguration.baseURLString);
        return new HttpUrl_Builder().scheme(parse.scheme()).host(parse.host()).encodedPath("/oauth/authorize").addQueryParameter("redirect_uri", this.mConfiguration.codeGrantRedirectURI).addQueryParameter("response_type", "code").addQueryParameter("state", this.mCurrentCodeGrantState).addQueryParameter("scope", this.mConfiguration.scope).addQueryParameter("client_id", this.mConfiguration.clientID).build().toString();
    }

    public Configuration getConfiguration() {
        return this.mConfiguration;
    }

    public Retrofit getRetrofit() {
        return this.mRetrofit;
    }

    public String getUserAgent() {
        return this.mConfiguration.userAgentString;
    }

    public VimeoAccount getVimeoAccount() {
        if (this.mVimeoAccount == null) {
            throw new AssertionError("Account should never be null");
        } else {
            return this.mVimeoAccount;
        }
    }

    public Call<VimeoAccount> join(String str, String str2, String str3, AuthCallback authCallback) {
        ErrorCode iNVALID_INPUT_NO_NAME2;
        ErrorCode iNVALID_INPUT_NO_EMAIL2;
        String str5;
        if (authCallback == null) {
            throw new AssertionError("Callback cannot be null");
        } else {
            final String str6 = "password";
            final String str7 = "email";
            final String str8 = "name";
            str4 = "Name, email, and password must be set.";
            VimeoError vimeoError = new VimeoError(str4);
            if (str == null || str.isEmpty()) {
                str4 = "An empty or null name was provided.";
                vimeoError.addInvalidParameter(str8, ErrorCode.INVALID_INPUT_NO_NAME, str4);
            }
            if (str2 == null || str2.isEmpty()) {
                str5 = "An empty or null email was provided.";
                vimeoError.addInvalidParameter(str7, ErrorCode.INVALID_INPUT_NO_EMAIL, str5);
            }
            if (str3 == null || str3.isEmpty()) {
                str5 = "An empty or null password was provided.";
                vimeoError.addInvalidParameter(str6, ErrorCode.INVALID_INPUT_NO_PASSWORD, str5);
            }
            authCallback.failure(vimeoError);
            return null;
        }
    }

    public Call<VimeoAccount> joinWithFacebookToken(String str, String str2, AuthCallback authCallback) {
        if (authCallback == null) {
            throw new AssertionError("Callback cannot be null");
        } else {
            String str4 = "token";
            str3 = "Facebook authentication error.";
            VimeoError vimeoError = new VimeoError(str3);
            if (str == null || str.isEmpty()) {
                str3 = "An empty or null Facebook access token was provided.";
                vimeoError.addInvalidParameter(str4, ErrorCode.UNABLE_TO_LOGIN_NO_TOKEN, str3);
            }
            authCallback.failure(vimeoError);
            return null;
        }
    }

    public Call<Object> likeVideo(String str, String str2, ModelCallback modelCallback) {
        final HashMap hashMap = new HashMap();
        if (str2 != null) {
            str3 = "password";
            hashMap.put(str3, str2);
        }
        return putContent(str, hashMap, modelCallback, true);
    }

    public Call<VimeoAccount> logIn(String str, String str2, AuthCallback authCallback) {
        String str3;
        ErrorCode iNVALID_INPUT_NO_EMAIL2;
        if (authCallback == null) {
            throw new AssertionError("Callback cannot be null");
        } else {
            str3 = "Email and password must be set.";
            VimeoError vimeoError = new VimeoError(str3);
            if (str == null || str.isEmpty()) {
                str3 = "username";
                str4 = "An empty or null email was provided.";
                vimeoError.addInvalidParameter(str3, ErrorCode.INVALID_INPUT_NO_EMAIL, str4);
            }
            if (str2 == null || str2.isEmpty()) {
                str6 = "password";
                str3 = "An empty or null password was provided.";
                vimeoError.addInvalidParameter(str6, ErrorCode.INVALID_INPUT_NO_PASSWORD, str3);
            }
            authCallback.failure(vimeoError);
            return null;
        }
    }

    public Call<PinCodeInfo> logInWithPinCode(ModelCallback<PinCodeInfo> modelCallback, AuthCallback authCallback) {
        VimeoClient.mContinuePinCodeAuthorizationRefreshCycle = false;
        if (this.mPinCodeAuthorizationTimer != null) {
            this.mPinCodeAuthorizationTimer.cancel();
        }
        Call pinCodeInfo = this.mVimeoService.getPinCodeInfo(getBasicAuthHeader(), "device_grant", this.mConfiguration.scope);
        VimeoClient.AnonymousClass4 anonymousClass4 = new VimeoClient.AnonymousClass4(this, PinCodeInfo.class, modelCallback, authCallback, scope2);
        pinCodeInfo.enqueue(anonymousClass4);
        return pinCodeInfo;
    }

    public Call<Object> logOut(VimeoCallback<Object> vimeoCallback) {
        final VimeoAccount vimeoAccount = null;
        if (this.mConfiguration.accessToken != null) {
            if (this.mConfiguration.accessToken.equals(this.mVimeoAccount.getAccessToken()) && vimeoCallback != null) {
                accessToken = "You can't log out of the account provided through the configuration builder. This is to ensure the access token generated in the developer console isn't accidentally invalidated. ";
                vimeoCallback.failure(new VimeoError(accessToken));
                return vimeoAccount;
            }
        }
        Call logOut = this.mVimeoService.logOut(getAuthHeader());
        logOut.enqueue(new VimeoClient.AnonymousClass3(this, vimeoCallback));
        this.mConfiguration.deleteAccount(this.mVimeoAccount);
        setVimeoAccount(vimeoAccount);
        return logOut;
    }

    public Call<VimeoAccount> loginWithFacebookToken(String str, String str2, AuthCallback authCallback) {
        if (authCallback == null) {
            throw new AssertionError("Callback cannot be null");
        } else {
            str3 = "Facebook authentication error.";
            VimeoError vimeoError = new VimeoError(str3);
            if (str == null || str.isEmpty()) {
                str3 = "token";
                str4 = "An empty or null Facebook access token was provided.";
                vimeoError.addInvalidParameter(str3, ErrorCode.UNABLE_TO_LOGIN_NO_TOKEN, str4);
            }
            authCallback.failure(vimeoError);
            return null;
        }
    }

    public Call<Object> postContent(String str, CacheControl cacheControl, HashMap<String, String> hashMap, VimeoCallback vimeoCallback) {
        String cacheControl22;
        HashMap hashMap32;
        if (hashMap == null) {
            hashMap32 = new HashMap();
        }
        cacheControl22 = cacheControl != null ? cacheControl22 : 0;
        return this.POST(getAuthHeader(), str, cacheControl22, hashMap32, vimeoCallback);
    }

    public Call<Object> putContent(String str, Map<String, String> map, ModelCallback modelCallback, boolean z) {
        HashMap map22;
        if (modelCallback == null) {
            throw new AssertionError("Callback cannot be null");
        } else {
            modelCallback.failure(new VimeoError("uri cannot be empty!"));
            return null;
        }
    }

    @Deprecated
    public void saveAccount(VimeoAccount vimeoAccount, String str, String str2) {
        saveAccount(vimeoAccount, str);
    }

    public Call<Object> search(String str, String str2, ModelCallback modelCallback, Map<String, String> map, String str3) {
        Map map42;
        modelCallback.failure(new VimeoError("Query cannot be empty!"));
        return null;
    }

    public void setVimeoAccount(VimeoAccount vimeoAccount) {
        VimeoAccount vimeoAccount2;
        if (vimeoAccount == null) {
            if (mConfiguration2.accessToken != null) {
                String accessToken2 = null;
                this.mConfiguration.saveAccount(new VimeoAccount(this.mConfiguration.accessToken), accessToken2);
            }
        }
        this.mVimeoAccount = vimeoAccount2;
    }

    public Call<VimeoAccount> singleSignOnTokenExchange(String str, AuthCallback authCallback) {
        if (authCallback == null) {
            throw new AssertionError("Callback cannot be null");
        } else {
            Call ssoTokenExchange = this.mVimeoService.ssoTokenExchange(getBasicAuthHeader(), str, this.mConfiguration.scope);
            ssoTokenExchange.enqueue(new VimeoClient.AccountCallback(this, authCallback));
            return ssoTokenExchange;
        }
    }

    public Call<Object> unfollow(String str, ModelCallback modelCallback, boolean z) {
        return deleteContent(str, modelCallback, z);
    }

    public Call<Object> unlikeVideo(String str, String str2, ModelCallback modelCallback) {
        final HashMap hashMap = new HashMap();
        if (str2 != null) {
            str3 = "password";
            hashMap.put(str3, str2);
        }
        return deleteContent(str, hashMap, modelCallback, true);
    }

    public Call<Object> unwatchLaterVideo(String str, String str2, ModelCallback modelCallback) {
        final HashMap hashMap = new HashMap();
        if (str2 != null) {
            str3 = "password";
            hashMap.put(str3, str2);
        }
        return deleteContent(str, hashMap, modelCallback, true);
    }

    public Call<Object> updateFollow(boolean z, String str, ModelCallback modelCallback) {
        return updateFollow(z, str, modelCallback, true);
    }

    public Call<Object> updateLikeVideo(boolean z, String str, String str2, ModelCallback modelCallback) {
        if (z) {
            return likeVideo(str, str2, modelCallback);
        }
        return unlikeVideo(str, str2, modelCallback);
    }

    public Call<Object> updateWatchLaterVideo(boolean z, String str, String str2, ModelCallback modelCallback) {
        if (z) {
            return watchLaterVideo(str, str2, modelCallback);
        }
        return unwatchLaterVideo(str, str2, modelCallback);
    }

    public Call<Object> watchLaterVideo(String str, String str2, ModelCallback modelCallback) {
        final HashMap hashMap = new HashMap();
        if (str2 != null) {
            str3 = "password";
            hashMap.put(str3, str2);
        }
        return putContent(str, hashMap, modelCallback, true);
    }

    public retrofit2.Response<Video> fetchVideoSync(String str, CacheControl cacheControl, String str2) {
        str2 = null;
        try {
        } catch (java.io.IOException unused) {
            return obj;
        }
        return this.mVimeoService.getVideo(getAuthHeader(), createCacheControlString(cacheControl), str, createQueryMap(str2, str2, str2)).execute();
    }

    public void saveAccount(VimeoAccount vimeoAccount, String str) {
        setVimeoAccount(vimeoAccount);
        this.mConfiguration.saveAccount(vimeoAccount, str);
    }

    public Call<Object> updateFollow(boolean z, String str, ModelCallback modelCallback, boolean z2) {
        if (z) {
            return follow(str, modelCallback, z2);
        }
        return unfollow(str, modelCallback, z2);
    }

    public Call<Object> deleteContent(String str, ModelCallback modelCallback, boolean z) {
        return deleteContent(str, null, modelCallback, z);
    }

    public Call<Object> deleteContent(String str, ModelCallback modelCallback) {
        return deleteContent(str, modelCallback, true);
    }

    public Call<Object> fetchContent(String str, CacheControl cacheControl, ModelCallback modelCallback) {
        return this.fetchContent(str, cacheControl, modelCallback, null, null, null);
    }

    Call<SearchResponse> search(Map<String, String> map, ModelCallback<SearchResponse> modelCallback) {
        final Call search = this.mVimeoService.search(getAuthHeader(), map);
        search.enqueue(modelCallback);
        return search;
    }

    public Call<Object> fetchContent(String str, CacheControl cacheControl, ModelCallback modelCallback, String str2) {
        return this.fetchContent(str, cacheControl, modelCallback, null, null, str2);
    }

    public VimeoAccount logIn(String str, String str2) {
        int i = 0;
        VimeoAccount vimeoAccount = null;
        boolean successful;
        com.vimeo.networking.VimeoService mVimeoService2;
        retrofit2.Response execute;
        i = 0;
        return i;
    }
}
