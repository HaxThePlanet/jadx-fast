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
import okhttp3.Response;
import okhttp3.Response.Builder;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes2.dex */
public final class VimeoClient {

    private static volatile boolean mContinuePinCodeAuthorizationRefreshCycle;
    private static com.vimeo.networking.VimeoClient mSharedInstance;
    private final Cache mCache;
    private final com.vimeo.networking.Configuration mConfiguration;
    private String mCurrentCodeGrantState;
    private final Gson mGson;
    private Timer mPinCodeAuthorizationTimer;
    private final Retrofit mRetrofit;
    private VimeoAccount mVimeoAccount;
    private final com.vimeo.networking.VimeoService mVimeoService;

    private static class PinCodePollingTimerTask extends TimerTask {

        private final WeakReference<AuthCallback> mAuthCallbackWeakReference;
        private final long mExpiresInNano;
        private final PinCodeInfo mPinCodeInfo;
        private final String mScope;
        private final Timer mTimer;
        private final WeakReference<com.vimeo.networking.VimeoClient> mVimeoClient;
        PinCodePollingTimerTask(PinCodeInfo pinCodeInfo, Timer timer2, int i3, AuthCallback authCallback4, com.vimeo.networking.VimeoClient vimeoClient5, String string6) {
            super();
            this.mTimer = timer2;
            this.mPinCodeInfo = pinCodeInfo;
            this.mExpiresInNano = obj4 += nanos;
            WeakReference obj4 = new WeakReference(authCallback4);
            this.mAuthCallbackWeakReference = obj4;
            obj4 = new WeakReference(vimeoClient5);
            this.mVimeoClient = obj4;
            this.mScope = string6;
        }

        @Override // java.util.TimerTask
        public void run() {
            boolean vimeoError;
            long uNABLE_TO_LOGIN_PINCODE_EXPIRED;
            com.vimeo.networking.VimeoClient.PinCodeAccountCallback pinCodeAccountCallback;
            boolean mExpiresInNano;
            com.vimeo.networking.VimeoService service;
            String str;
            String str2;
            String userCode;
            String deviceCode;
            String mScope;
            Object obj = this.mAuthCallbackWeakReference.get();
            vimeoError = this.mVimeoClient.get();
            uNABLE_TO_LOGIN_PINCODE_EXPIRED = System.nanoTime();
            if (VimeoClient.access$100() && Long.compare(uNABLE_TO_LOGIN_PINCODE_EXPIRED, mExpiresInNano2) < 0 && (AuthCallback)obj != null) {
                if (Long.compare(uNABLE_TO_LOGIN_PINCODE_EXPIRED, mExpiresInNano2) < 0) {
                    if ((AuthCallback)obj != null) {
                        if ((VimeoClient)vimeoError == null) {
                            VimeoClient.access$102(false);
                            this.mTimer.cancel();
                            if (VimeoClient.access$100() && (AuthCallback)obj != null && Long.compare(uNABLE_TO_LOGIN_PINCODE_EXPIRED, mExpiresInNano) >= 0) {
                                VimeoClient.access$102(false);
                                this.mTimer.cancel();
                                if ((AuthCallback)obj != null) {
                                    if (Long.compare(uNABLE_TO_LOGIN_PINCODE_EXPIRED, mExpiresInNano) >= 0) {
                                        vimeoError = new VimeoError("Pin code expired.");
                                        vimeoError.setErrorCode(ErrorCode.UNABLE_TO_LOGIN_PINCODE_EXPIRED);
                                        (AuthCallback)obj.failure(vimeoError);
                                    }
                                }
                            }
                        } else {
                            pinCodeAccountCallback = new VimeoClient.PinCodeAccountCallback(vimeoError, obj, this.mTimer);
                            VimeoClient.access$300((VimeoClient)vimeoError).logInWithPinCode(VimeoClient.access$200(vimeoError), "device_grant", this.mPinCodeInfo.getUserCode(), this.mPinCodeInfo.getDeviceCode(), this.mScope).enqueue(pinCodeAccountCallback);
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        }
    }

    private static class AccountCallback extends VimeoCallback<VimeoAccount> {

        private final AuthCallback mCallback;
        private final com.vimeo.networking.VimeoClient mClient;
        private String mEmail;
        public AccountCallback(com.vimeo.networking.VimeoClient vimeoClient, AuthCallback authCallback2) {
            super();
            if (vimeoClient == null) {
            } else {
                if (authCallback2 == null) {
                } else {
                    this.mClient = vimeoClient;
                    this.mCallback = authCallback2;
                }
            }
            AssertionError obj1 = new AssertionError("Client and Callback must not be null");
            throw obj1;
        }

        public AccountCallback(com.vimeo.networking.VimeoClient vimeoClient, String string2, AuthCallback authCallback3) {
            super();
            if (vimeoClient == null) {
            } else {
                if (authCallback3 == null) {
                } else {
                    this.mClient = vimeoClient;
                    this.mEmail = string2;
                    this.mCallback = authCallback3;
                }
            }
            AssertionError obj1 = new AssertionError("Client and Callback must not be null");
            throw obj1;
        }

        @Deprecated
        public AccountCallback(com.vimeo.networking.VimeoClient vimeoClient, String string2, String string3, AuthCallback authCallback4) {
            super(vimeoClient, string2, authCallback4);
        }

        @Override // com.vimeo.networking.callbacks.VimeoCallback
        public void failure(VimeoError vimeoError) {
            this.mCallback.failure(vimeoError);
        }

        @Override // com.vimeo.networking.callbacks.VimeoCallback
        public void success(VimeoAccount vimeoAccount) {
            User mEmail;
            String mClient2;
            Object mClient;
            if (vimeoAccount.getUser() != null) {
                mEmail = this.mEmail;
                if (mEmail != null) {
                    if (mEmail.isEmpty()) {
                        if (user.name != null) {
                            mClient2 = user3.name;
                        } else {
                            mClient2 = user2.uri;
                        }
                        this.mClient.saveAccount(vimeoAccount, mClient2);
                    } else {
                        this.mClient.saveAccount(vimeoAccount, this.mEmail);
                    }
                } else {
                }
            } else {
            }
            this.mCallback.success();
        }

        @Override // com.vimeo.networking.callbacks.VimeoCallback
        public void success(Object object) {
            success((VimeoAccount)object);
        }
    }

    private static class PinCodeAccountCallback extends com.vimeo.networking.VimeoClient.AccountCallback {

        private final Timer mTimer;
        public PinCodeAccountCallback(com.vimeo.networking.VimeoClient vimeoClient, AuthCallback authCallback2, Timer timer3) {
            super(vimeoClient, authCallback2);
            this.mTimer = timer3;
        }

        private void cancelPolling() {
            VimeoClient.access$102(false);
            Timer mTimer = this.mTimer;
            if (mTimer != null) {
                mTimer.cancel();
            }
        }

        @Override // com.vimeo.networking.VimeoClient$AccountCallback
        public void failure(VimeoError vimeoError) {
            boolean httpStatusCode;
            int i;
            if (VimeoClient.access$100() && vimeoError.getHttpStatusCode() == 400) {
                if (vimeoError.getHttpStatusCode() == 400) {
                }
                cancelPolling();
                super.failure(vimeoError);
            }
        }

        @Override // com.vimeo.networking.VimeoClient$AccountCallback
        public void success(VimeoAccount vimeoAccount) {
            if (VimeoClient.access$100()) {
                cancelPolling();
                super.success(vimeoAccount);
            }
        }

        @Override // com.vimeo.networking.VimeoClient$AccountCallback
        public void success(Object object) {
            success((VimeoAccount)object);
        }
    }
    private VimeoClient(com.vimeo.networking.Configuration configuration) {
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

    private Call<Object> DELETE(String string, String string2, Map<String, String> map3, VimeoCallback<Object> vimeoCallback4, boolean z5) {
        final Call obj2 = this.mVimeoService.DELETE(string, string2, map3);
        if (z5) {
            obj2.enqueue(vimeoCallback4);
        }
        return obj2;
    }

    private Call<Object> POST(String string, String string2, String string3, HashMap<String, String> hashMap4, VimeoCallback<Object> vimeoCallback5) {
        final Call obj2 = this.mVimeoService.POST(string, string2, string3, hashMap4);
        obj2.enqueue(vimeoCallback5);
        return obj2;
    }

    private Call<Object> PUT(String string, String string2, Map<String, String> map3, VimeoCallback<Object> vimeoCallback4, boolean z5) {
        final Call obj2 = this.mVimeoService.PUT(string, string2, map3);
        if (z5) {
            obj2.enqueue(vimeoCallback4);
        }
        return obj2;
    }

    static com.vimeo.networking.Configuration access$000(com.vimeo.networking.VimeoClient vimeoClient) {
        return vimeoClient.mConfiguration;
    }

    static boolean access$100() {
        return VimeoClient.mContinuePinCodeAuthorizationRefreshCycle;
    }

    static boolean access$102(boolean z) {
        VimeoClient.mContinuePinCodeAuthorizationRefreshCycle = z;
        return z;
    }

    static String access$200(com.vimeo.networking.VimeoClient vimeoClient) {
        return vimeoClient.getBasicAuthHeader();
    }

    static com.vimeo.networking.VimeoService access$300(com.vimeo.networking.VimeoClient vimeoClient) {
        return vimeoClient.mVimeoService;
    }

    static Timer access$400(com.vimeo.networking.VimeoClient vimeoClient) {
        return vimeoClient.mPinCodeAuthorizationTimer;
    }

    static Timer access$402(com.vimeo.networking.VimeoClient vimeoClient, Timer timer2) {
        vimeoClient.mPinCodeAuthorizationTimer = timer2;
        return timer2;
    }

    static com.vimeo.networking.VimeoClient access$500() {
        return VimeoClient.mSharedInstance;
    }

    static Gson access$600(com.vimeo.networking.VimeoClient vimeoClient) {
        return vimeoClient.mGson;
    }

    private String createCacheControlString(CacheControl cacheControl) {
        int cacheControlBuilder;
        int sECONDS;
        TimeUnit sECONDS2;
        int obj3;
        if (cacheControl != null) {
            cacheControlBuilder = VimeoNetworkUtil.getCacheControlBuilder(cacheControl);
            if (cacheControl.onlyIfCached() && cacheControl.maxAgeSeconds() == -1) {
                cacheControlBuilder = VimeoNetworkUtil.getCacheControlBuilder(cacheControl);
                if (cacheControl.maxAgeSeconds() == -1) {
                    cacheControlBuilder.maxAge(obj3.cacheMaxAge, TimeUnit.SECONDS);
                }
                cacheControlBuilder.maxStale(0, TimeUnit.SECONDS);
                obj3 = cacheControlBuilder.build();
            }
        } else {
            obj3 = new CacheControl.Builder();
            obj3 = obj3.maxAge(mConfiguration.cacheMaxAge, TimeUnit.SECONDS).build();
        }
        return obj3.toString();
    }

    private OkHttpClient createOkHttpClient() {
        boolean certPinningEnabled;
        java.util.List interceptors;
        TimeUnit sECONDS;
        RetrofitClientBuilder retrofitClientBuilder = new RetrofitClientBuilder();
        VimeoClient.2 anon = new VimeoClient.2(this);
        sECONDS = TimeUnit.SECONDS;
        LoggingInterceptor loggingInterceptor = new LoggingInterceptor();
        VimeoClient.1 anon2 = new VimeoClient.1(this);
        retrofitClientBuilder.setCache(this.mCache).addNetworkInterceptor(anon).setReadTimeout(mConfiguration2.timeout, sECONDS).setConnectionTimeout(mConfiguration3.timeout, sECONDS).addInterceptor(loggingInterceptor).addInterceptor(anon2).addNetworkInterceptors(mConfiguration4.networkInterceptors).addInterceptors(mConfiguration5.interceptors);
        if (mConfiguration.certPinningEnabled) {
            retrofitClientBuilder.pinCertificates();
        }
        return retrofitClientBuilder.build();
    }

    private Retrofit createRetrofit() {
        Retrofit.Builder builder = new Retrofit.Builder();
        return builder.baseUrl(mConfiguration.baseURLString).client(createOkHttpClient()).addConverterFactory(GsonConverterFactory.create(this.mGson)).build();
    }

    private String getBasicAuthHeader() {
        com.vimeo.networking.Configuration mConfiguration = this.mConfiguration;
        return Credentials.basic(mConfiguration.clientID, mConfiguration.clientSecret);
    }

    public static com.vimeo.networking.VimeoClient getInstance() {
        com.vimeo.networking.VimeoClient mSharedInstance = VimeoClient.mSharedInstance;
        if (mSharedInstance == null) {
        } else {
            return mSharedInstance;
        }
        AssertionError assertionError = new AssertionError("Instance must be configured before use");
        throw assertionError;
    }

    private VimeoCallback<Object> getRetrofitCallback(ModelCallback<Object> modelCallback) {
        VimeoClient.5 anon = new VimeoClient.5(this, modelCallback);
        return anon;
    }

    public static void initialize(com.vimeo.networking.Configuration configuration) {
        VimeoClient vimeoClient = new VimeoClient(configuration);
        VimeoClient.mSharedInstance = vimeoClient;
    }

    public Call<Object> activatePictureResource(String string, ModelCallback modelCallback2) {
        boolean empty;
        if (string != null && string.trim().isEmpty()) {
            if (string.trim().isEmpty()) {
            }
            HashMap hashMap = new HashMap();
            hashMap.put("active", Boolean.TRUE);
            Call obj4 = this.mVimeoService.edit(getAuthHeader(), string, hashMap);
            obj4.enqueue(getRetrofitCallback(modelCallback2));
            return obj4;
        }
        obj4 = new VimeoError("uri cannot be empty!");
        modelCallback2.failure(obj4);
        return 0;
    }

    public Call<VimeoAccount> authenticateWithCodeGrant(String string, AuthCallback authCallback2) {
        boolean empty;
        String mCurrentCodeGrantState;
        Object obj5;
        if (authCallback2 == null) {
        } else {
            int i = 0;
            if (string != null) {
                if (string.isEmpty()) {
                } else {
                    obj5 = VimeoNetworkUtil.getSimpleQueryMap(string);
                    Object obj = obj5.get("code");
                    obj5 = obj5.get("state");
                    if (obj != null && !(String)obj.isEmpty() && obj5 != null && !(String)obj5.isEmpty() && !obj5.equals(this.mCurrentCodeGrantState)) {
                        if (!obj.isEmpty()) {
                            if (obj5 != null) {
                                if (!obj5.isEmpty()) {
                                    if (!obj5.equals(this.mCurrentCodeGrantState)) {
                                    }
                                    this.mCurrentCodeGrantState = i;
                                    obj5 = this.mVimeoService.authenticateWithCodeGrant(getBasicAuthHeader(), obj5.codeGrantRedirectURI, obj, "authorization_code");
                                    VimeoClient.AccountCallback accountCallback = new VimeoClient.AccountCallback(this, authCallback2);
                                    obj5.enqueue(accountCallback);
                                    return obj5;
                                }
                            }
                        }
                    }
                }
                this.mCurrentCodeGrantState = i;
                obj5 = new VimeoError("Code grant code/state is null or state has changed");
                authCallback2.failure(obj5);
                return i;
            }
            obj5 = new VimeoError("uri must not be null");
            authCallback2.failure(obj5);
            return i;
        }
        obj5 = new AssertionError("Callback cannot be null");
        throw obj5;
    }

    public Call<VimeoAccount> authorizeWithClientCredentialsGrant(AuthCallback authCallback) {
        if (authCallback == null) {
        } else {
            Call authorizeWithClientCredentialsGrant = this.mVimeoService.authorizeWithClientCredentialsGrant(getBasicAuthHeader(), "client_credentials", mConfiguration.scope);
            VimeoClient.AccountCallback accountCallback = new VimeoClient.AccountCallback(this, authCallback);
            authorizeWithClientCredentialsGrant.enqueue(accountCallback);
            return authorizeWithClientCredentialsGrant;
        }
        AssertionError obj5 = new AssertionError("Callback cannot be null");
        throw obj5;
    }

    public VimeoAccount authorizeWithClientCredentialsGrantSync() {
        Object execute;
        Throwable th2;
        int i;
        boolean successful;
        String str;
        Throwable th3;
        execute = this.mVimeoService.authorizeWithClientCredentialsGrant(getBasicAuthHeader(), "client_credentials", mConfiguration.scope).execute();
        if (execute.isSuccessful()) {
            saveAccount((VimeoAccount)execute.body(), 0);
            i = execute;
        }
        return i;
    }

    public void cancelPinCodeLogin() {
        VimeoClient.mContinuePinCodeAuthorizationRefreshCycle = false;
        Timer mPinCodeAuthorizationTimer = this.mPinCodeAuthorizationTimer;
        if (mPinCodeAuthorizationTimer != null) {
            mPinCodeAuthorizationTimer.cancel();
        }
    }

    public void clearRequestCache() {
        Object mCache;
        StringBuilder string;
        String message;
        try {
            mCache = this.mCache;
            if (mCache != null) {
            } else {
            }
            mCache.evictAll();
            ClientLogger.e("Attempt to clear null cache");
            string = new StringBuilder();
            message = "Cache clearing error: ";
            string.append(message);
            message = th.getMessage();
            string.append(message);
            string = string.toString();
            ClientLogger.e(string, th);
        }
    }

    public Call<Comment> comment(String string, String string2, String string3, ModelCallback<Comment> modelCallback4) {
        boolean empty;
        String str;
        if (modelCallback4 == null) {
        } else {
            if (string != null && !string.isEmpty() && string2 != null) {
                if (!string.isEmpty()) {
                    if (string2 != null) {
                        if (string2.isEmpty()) {
                        } else {
                            HashMap hashMap = new HashMap();
                            if (string3 != null) {
                                hashMap.put("password", string3);
                            }
                        }
                        HashMap obj5 = new HashMap();
                        obj5.put("text", string2);
                        Call obj3 = this.mVimeoService.comment(getAuthHeader(), string, hashMap, obj5);
                        obj3.enqueue(modelCallback4);
                        return obj3;
                    }
                }
            }
            obj3 = new VimeoError("uri cannot be empty!");
            modelCallback4.failure(obj3);
            return 0;
        }
        obj3 = new AssertionError("Callback cannot be null");
        throw obj3;
    }

    public Call<PictureResource> createPictureResource(String string, ModelCallback<PictureResource> modelCallback2) {
        boolean empty;
        if (string != null && string.trim().isEmpty()) {
            if (string.trim().isEmpty()) {
            }
            Call obj3 = this.mVimeoService.createPictureResource(getAuthHeader(), string);
            obj3.enqueue(modelCallback2);
            return obj3;
        }
        obj3 = new VimeoError("uri cannot be empty!");
        modelCallback2.failure(obj3);
        return 0;
    }

    Map<String, String> createQueryMap(String string, Map<String, String> map2, String string3) {
        HashMap hashMap;
        boolean empty;
        Object obj3;
        HashMap obj4;
        hashMap = new HashMap();
        if (map2 != null && !map2.isEmpty()) {
            if (!map2.isEmpty()) {
            } else {
                obj4 = hashMap;
            }
        } else {
        }
        if (string != null && !string.isEmpty()) {
            if (!string.isEmpty()) {
                obj4.put("query", string);
            }
        }
        if (string3 != null && !string3.isEmpty()) {
            if (!string3.isEmpty()) {
                obj4.put("fields", string3);
            }
        }
        return obj4;
    }

    public Call<Object> deleteContent(String string, ModelCallback modelCallback2) {
        return deleteContent(string, modelCallback2, true);
    }

    public Call<Object> deleteContent(String string, ModelCallback modelCallback2, boolean z3) {
        return deleteContent(string, 0, modelCallback2, z3);
    }

    public Call<Object> deleteContent(String string, Map<String, String> map2, ModelCallback modelCallback3, boolean z4) {
        boolean empty;
        HashMap obj8;
        if (modelCallback3 == null) {
        } else {
            if (string != null) {
                if (string.isEmpty()) {
                } else {
                    if (map2 == null) {
                        obj8 = new HashMap();
                    }
                }
                return this.DELETE(getAuthHeader(), string, obj8, getRetrofitCallback(modelCallback3), z4);
            }
            VimeoError obj7 = new VimeoError("uri cannot be empty!");
            modelCallback3.failure(obj7);
            return 0;
        }
        obj7 = new AssertionError("Callback cannot be null");
        throw obj7;
    }

    public void deletePictureResource(String string, ModelCallback modelCallback2) {
        boolean empty;
        if (string != null && string.trim().isEmpty()) {
            if (string.trim().isEmpty()) {
            }
            deleteContent(string, modelCallback2);
        }
        VimeoError obj2 = new VimeoError("uri cannot be empty!");
        modelCallback2.failure(obj2);
    }

    public void deleteVideo(String string, Map<String, String> map2, ModelCallback modelCallback3) {
        deleteContent(string, map2, modelCallback3, true);
    }

    public Call<Object> editUser(String string, String string2, String string3, String string4, ModelCallback<Object> modelCallback5) {
        boolean empty;
        Object obj4;
        if (modelCallback5 == null) {
        } else {
            int i = 0;
            if (string != null) {
                if (string.isEmpty()) {
                } else {
                    if (string2 == null && string3 == null && string4 == null) {
                        if (string3 == null) {
                            if (string4 == null) {
                                VimeoError obj3 = new VimeoError("name, location, and bio cannot all be empty!");
                                modelCallback5.failure(obj3);
                                return i;
                            }
                        }
                    }
                    HashMap hashMap = new HashMap();
                    if (string2 != null) {
                        hashMap.put("name", string2);
                    }
                    if (string3 != null) {
                        hashMap.put("location", string3);
                    }
                    if (string4 != null) {
                        hashMap.put("bio", string4);
                    }
                }
                obj3 = this.mVimeoService.edit(getAuthHeader(), string, hashMap);
                obj3.enqueue(getRetrofitCallback(modelCallback5));
                return obj3;
            }
            obj3 = new VimeoError("uri cannot be empty!");
            modelCallback5.failure(obj3);
            return i;
        }
        obj3 = new AssertionError("Callback cannot be null");
        throw obj3;
    }

    public Call<Object> editVideo(String string, String string2, String string3, String string4, Privacy.PrivacyValue privacy$PrivacyValue5, HashMap<String, Object> hashMap6, ModelCallback<Object> modelCallback7) {
        boolean empty;
        Object obj4;
        Object obj5;
        Object obj6;
        HashMap obj8;
        if (modelCallback7 == null) {
        } else {
            final int i = 0;
            if (string != null) {
                if (string.isEmpty()) {
                } else {
                    if (string2 == null && string3 == null && privacyValue5 == null) {
                        if (string3 == null) {
                            if (privacyValue5 == null) {
                                VimeoError obj3 = new VimeoError("title, description, and privacyValue cannot be empty!");
                                modelCallback7.failure(obj3);
                                return i;
                            }
                        }
                    }
                    if (hashMap6 == null) {
                        obj8 = new HashMap();
                    }
                    if (string2 != null) {
                        obj8.put("name", string2);
                    }
                    if (string3 != null) {
                        obj8.put("description", string3);
                    }
                    if (privacyValue5 != null && privacyValue5 == Privacy.PrivacyValue.PASSWORD && string4 == null) {
                        if (privacyValue5 == Privacy.PrivacyValue.PASSWORD) {
                            if (string4 == null) {
                                obj3 = new VimeoError("Password cannot be null password privacy type");
                                modelCallback7.failure(obj3);
                                return i;
                            }
                            obj8.put("password", string4);
                        }
                        obj5 = new HashMap();
                        obj5.put("view", privacyValue5.getText());
                        obj8.put("privacy", obj5);
                    }
                }
                obj3 = this.mVimeoService.edit(getAuthHeader(), string, obj8);
                obj3.enqueue(getRetrofitCallback(modelCallback7));
                return obj3;
            }
            obj3 = new VimeoError("uri cannot be empty!");
            modelCallback7.failure(obj3);
            return i;
        }
        obj3 = new AssertionError("Callback cannot be null");
        throw obj3;
    }

    public Call<Void> emptyResponsePost(String string, HashMap<String, String> hashMap2, VimeoCallback<Void> vimeoCallback3) {
        HashMap obj4;
        if (vimeoCallback3 == null) {
        } else {
            if (string == null) {
                VimeoError obj3 = new VimeoError("uri cannot be empty!");
                vimeoCallback3.failure(obj3);
                return 0;
            }
            if (hashMap2 == null) {
                obj4 = new HashMap();
            }
            obj3 = this.mVimeoService.emptyResponsePost(getAuthHeader(), string, obj4);
            obj3.enqueue(vimeoCallback3);
            return obj3;
        }
        obj3 = new AssertionError("Callback cannot be null");
        throw obj3;
    }

    public Call<VimeoAccount> exchangeOAuthOneToken(String string, String string2, AuthCallback authCallback3) {
        if (authCallback3 == null) {
        } else {
            Call obj7 = this.mVimeoService.exchangeOAuthOneToken(getBasicAuthHeader(), "vimeo_oauth1", string, string2, mConfiguration.scope);
            VimeoClient.AccountCallback obj8 = new VimeoClient.AccountCallback(this, authCallback3);
            obj7.enqueue(obj8);
            return obj7;
        }
        obj7 = new AssertionError("Callback cannot be null");
        throw obj7;
    }

    public Call<Object> fetchCachedContent(String string, ModelCallback modelCallback2) {
        return fetchContent(string, CacheControl.FORCE_CACHE, modelCallback2);
    }

    public Call<Object> fetchCachedSortedContent(String string, ModelCallback modelCallback2, String string3) {
        SearchRefinementBuilder searchRefinementBuilder = new SearchRefinementBuilder(Vimeo.RefineSort.DEFAULT);
        return this.fetchContent(string, CacheControl.FORCE_CACHE, modelCallback2, 0, searchRefinementBuilder.build(), string3);
    }

    public Call<Object> fetchContent(String string, CacheControl cacheControl2, ModelCallback modelCallback3) {
        return this.fetchContent(string, cacheControl2, modelCallback3, 0, 0, 0);
    }

    public Call<Object> fetchContent(String string, CacheControl cacheControl2, ModelCallback modelCallback3, String string4) {
        return this.fetchContent(string, cacheControl2, modelCallback3, 0, 0, string4);
    }

    public Call<Object> fetchContent(String string, CacheControl cacheControl2, ModelCallback modelCallback3, String string4, Map<String, String> map5, String string6) {
        if (string.isEmpty()) {
            VimeoError obj2 = new VimeoError("Uri cannot be empty!");
            modelCallback3.failure(obj2);
            return 0;
        }
        obj2 = this.mVimeoService.GET(getAuthHeader(), string, createQueryMap(string4, map5, string6), createCacheControlString(cacheControl2));
        obj2.enqueue(getRetrofitCallback(modelCallback3));
        return obj2;
    }

    public Response<Object> fetchContentSync(String string, CacheControl cacheControl2, String string3, Map<String, String> map4, String string5) {
        boolean empty;
        if (string == null) {
        } else {
            if (string.isEmpty()) {
            } else {
                return this.mVimeoService.GET(getAuthHeader(), string, createQueryMap(string3, map4, string5), createCacheControlString(cacheControl2)).execute();
            }
        }
        AssertionError obj2 = new AssertionError("uri cannot be null or empty");
        throw obj2;
    }

    public void fetchCurrentUser(ModelCallback<User> modelCallback) {
        fetchContent("me", CacheControl.FORCE_NETWORK, modelCallback);
    }

    public Call<Object> fetchNetworkContent(String string, ModelCallback modelCallback2) {
        return fetchContent(string, CacheControl.FORCE_NETWORK, modelCallback2);
    }

    public Call<Object> fetchNetworkSortedContent(String string, ModelCallback modelCallback2, String string3) {
        SearchRefinementBuilder searchRefinementBuilder = new SearchRefinementBuilder(Vimeo.RefineSort.DEFAULT);
        return this.fetchContent(string, CacheControl.FORCE_NETWORK, modelCallback2, 0, searchRefinementBuilder.build(), string3);
    }

    public Response<Video> fetchVideoSync(String string, String string2) {
        return fetchVideoSync(string, CacheControl.FORCE_NETWORK, string2);
    }

    public Response<Video> fetchVideoSync(String string, CacheControl cacheControl2, String string3) {
        final int i = 0;
        return this.mVimeoService.getVideo(getAuthHeader(), createCacheControlString(cacheControl2), string, createQueryMap(i, i, string3)).execute();
    }

    public Call<Object> follow(String string, ModelCallback modelCallback2, boolean z3) {
        return putContent(string, 0, modelCallback2, z3);
    }

    public String getAcceptHeader() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("application/vnd.vimeo.*+json; version=");
        stringBuilder.append(mConfiguration.apiVersionString);
        return stringBuilder.toString();
    }

    public String getAuthHeader() {
        VimeoAccount mVimeoAccount;
        String basicAuthHeader;
        String accessToken;
        mVimeoAccount = this.mVimeoAccount;
        if (mVimeoAccount != null && mVimeoAccount.isAuthenticated()) {
            if (mVimeoAccount.isAuthenticated()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Bearer ");
                stringBuilder.append(this.mVimeoAccount.getAccessToken());
                basicAuthHeader = stringBuilder.toString();
            } else {
                basicAuthHeader = getBasicAuthHeader();
            }
        } else {
        }
        return basicAuthHeader;
    }

    public String getCodeGrantAuthorizationURI() {
        this.mCurrentCodeGrantState = UUID.randomUUID().toString();
        HttpUrl parse = HttpUrl.parse(mConfiguration.baseURLString);
        HttpUrl.Builder builder = new HttpUrl.Builder();
        return builder.scheme(parse.scheme()).host(parse.host()).encodedPath("/oauth/authorize").addQueryParameter("redirect_uri", mConfiguration2.codeGrantRedirectURI).addQueryParameter("response_type", "code").addQueryParameter("state", this.mCurrentCodeGrantState).addQueryParameter("scope", mConfiguration3.scope).addQueryParameter("client_id", mConfiguration4.clientID).build().toString();
    }

    public com.vimeo.networking.Configuration getConfiguration() {
        return this.mConfiguration;
    }

    public Retrofit getRetrofit() {
        return this.mRetrofit;
    }

    public String getUserAgent() {
        return mConfiguration.userAgentString;
    }

    public VimeoAccount getVimeoAccount() {
        VimeoAccount mVimeoAccount = this.mVimeoAccount;
        if (mVimeoAccount == null) {
        } else {
            return mVimeoAccount;
        }
        AssertionError assertionError = new AssertionError("Account should never be null");
        throw assertionError;
    }

    public Call<VimeoAccount> join(String string, String string2, String string3, AuthCallback authCallback4) {
        boolean empty;
        String str;
        Object obj6;
        Object obj7;
        if (authCallback4 == null) {
        } else {
            final String str2 = "password";
            final String str3 = "email";
            final String str4 = "name";
            if (string != null && !string.isEmpty() && string2 != null && !string2.isEmpty() && string3 != null && string3.isEmpty()) {
                if (!string.isEmpty()) {
                    if (string2 != null) {
                        if (!string2.isEmpty()) {
                            if (string3 != null) {
                                if (string3.isEmpty()) {
                                }
                                HashMap hashMap = new HashMap();
                                hashMap.put(str4, string);
                                hashMap.put(str3, string2);
                                hashMap.put(str2, string3);
                                hashMap.put("scope", obj6.scope);
                                obj6 = this.mVimeoService.join(getBasicAuthHeader(), hashMap);
                                VimeoClient.AccountCallback obj8 = new VimeoClient.AccountCallback(this, string2, authCallback4);
                                obj6.enqueue(obj8);
                                return obj6;
                            }
                        }
                    }
                }
            }
            VimeoError vimeoError = new VimeoError("Name, email, and password must be set.");
            if (string != null) {
                if (string.isEmpty()) {
                    vimeoError.addInvalidParameter(str4, ErrorCode.INVALID_INPUT_NO_NAME, "An empty or null name was provided.");
                }
            } else {
            }
            if (string2 != null) {
                if (string2.isEmpty()) {
                    vimeoError.addInvalidParameter(str3, ErrorCode.INVALID_INPUT_NO_EMAIL, "An empty or null email was provided.");
                }
            } else {
            }
            if (string3 != null) {
                if (string3.isEmpty()) {
                    vimeoError.addInvalidParameter(str2, ErrorCode.INVALID_INPUT_NO_PASSWORD, "An empty or null password was provided.");
                }
            } else {
            }
            authCallback4.failure(vimeoError);
            return 0;
        }
        obj6 = new AssertionError("Callback cannot be null");
        throw obj6;
    }

    public Call<VimeoAccount> joinWithFacebookToken(String string, String string2, AuthCallback authCallback3) {
        boolean empty;
        String str;
        Object obj3;
        if (authCallback3 == null) {
        } else {
            String str2 = "token";
            if (string != null && string.isEmpty()) {
                if (string.isEmpty()) {
                }
                HashMap hashMap = new HashMap();
                hashMap.put(str2, string);
                hashMap.put("scope", obj3.scope);
                obj3 = this.mVimeoService.join(getBasicAuthHeader(), hashMap);
                VimeoClient.AccountCallback accountCallback = new VimeoClient.AccountCallback(this, string2, authCallback3);
                obj3.enqueue(accountCallback);
                return obj3;
            }
            VimeoError obj4 = new VimeoError("Facebook authentication error.");
            if (string != null) {
                if (string.isEmpty()) {
                    obj4.addInvalidParameter(str2, ErrorCode.UNABLE_TO_LOGIN_NO_TOKEN, "An empty or null Facebook access token was provided.");
                }
            } else {
            }
            authCallback3.failure(obj4);
            return 0;
        }
        obj3 = new AssertionError("Callback cannot be null");
        throw obj3;
    }

    public Call<Object> likeVideo(String string, String string2, ModelCallback modelCallback3) {
        String str;
        HashMap hashMap = new HashMap();
        if (string2 != null) {
            hashMap.put("password", string2);
        }
        return putContent(string, hashMap, modelCallback3, true);
    }

    public VimeoAccount logIn(String string, String string2) {
        int i;
        StringBuilder successful;
        Object mVimeoService;
        String basicAuthHeader;
        String str2;
        String str3;
        String str;
        String scope;
        Object obj10;
        i = 0;
        if (string != null && !string.isEmpty() && string2 != null) {
            if (!string.isEmpty()) {
                if (string2 != null) {
                    if (string2.isEmpty()) {
                    } else {
                        obj10 = this.mVimeoService.logIn(getBasicAuthHeader(), string, string2, "password", mConfiguration.scope).execute();
                        if (obj10.isSuccessful()) {
                            i = obj10;
                        }
                        saveAccount(i, string);
                    }
                }
            }
        }
        return i;
    }

    public Call<VimeoAccount> logIn(String string, String string2, AuthCallback authCallback3) {
        boolean empty;
        String str;
        String str2;
        String obj8;
        String obj9;
        if (authCallback3 == null) {
        } else {
            if (string != null && !string.isEmpty() && string2 != null && string2.isEmpty()) {
                if (!string.isEmpty()) {
                    if (string2 != null) {
                        if (string2.isEmpty()) {
                        }
                        obj9 = this.mVimeoService.logIn(getBasicAuthHeader(), string, string2, "password", mConfiguration.scope);
                        VimeoClient.AccountCallback accountCallback = new VimeoClient.AccountCallback(this, string, authCallback3);
                        obj9.enqueue(accountCallback);
                        return obj9;
                    }
                }
            }
            VimeoError vimeoError = new VimeoError("Email and password must be set.");
            if (string != null) {
                if (string.isEmpty()) {
                    vimeoError.addInvalidParameter("username", ErrorCode.INVALID_INPUT_NO_EMAIL, "An empty or null email was provided.");
                }
            } else {
            }
            if (string2 != null) {
                if (string2.isEmpty()) {
                    vimeoError.addInvalidParameter("password", ErrorCode.INVALID_INPUT_NO_PASSWORD, "An empty or null password was provided.");
                }
            } else {
            }
            authCallback3.failure(vimeoError);
            return 0;
        }
        obj8 = new AssertionError("Callback cannot be null");
        throw obj8;
    }

    public Call<PinCodeInfo> logInWithPinCode(ModelCallback<PinCodeInfo> modelCallback, AuthCallback authCallback2) {
        VimeoClient.mContinuePinCodeAuthorizationRefreshCycle = false;
        Timer mPinCodeAuthorizationTimer = this.mPinCodeAuthorizationTimer;
        if (mPinCodeAuthorizationTimer != null) {
            mPinCodeAuthorizationTimer.cancel();
        }
        final String scope = mConfiguration.scope;
        Call pinCodeInfo = this.mVimeoService.getPinCodeInfo(getBasicAuthHeader(), "device_grant", scope);
        super(this, PinCodeInfo.class, modelCallback, authCallback2, scope);
        pinCodeInfo.enqueue(anon);
        return pinCodeInfo;
    }

    public Call<Object> logOut(VimeoCallback<Object> vimeoCallback) {
        String accessToken2;
        String accessToken;
        accessToken2 = mConfiguration.accessToken;
        final int i = 0;
        if (accessToken2 != null && accessToken2.equals(this.mVimeoAccount.getAccessToken()) && vimeoCallback != null) {
            if (accessToken2.equals(this.mVimeoAccount.getAccessToken())) {
                if (vimeoCallback != null) {
                    accessToken2 = new VimeoError("You can't log out of the account provided through the configuration builder. This is to ensure the access token generated in the developer console isn't accidentally invalidated. ");
                    vimeoCallback.failure(accessToken2);
                }
                return i;
            }
        }
        Call logOut = this.mVimeoService.logOut(getAuthHeader());
        VimeoClient.3 anon = new VimeoClient.3(this, vimeoCallback);
        logOut.enqueue(anon);
        this.mConfiguration.deleteAccount(this.mVimeoAccount);
        setVimeoAccount(i);
        return logOut;
    }

    public Call<VimeoAccount> loginWithFacebookToken(String string, String string2, AuthCallback authCallback3) {
        boolean empty;
        String str;
        String str2;
        String obj5;
        if (authCallback3 == null) {
        } else {
            if (string != null && string.isEmpty()) {
                if (string.isEmpty()) {
                }
                obj5 = this.mVimeoService.logInWithFacebook(getBasicAuthHeader(), "facebook", string, mConfiguration.scope);
                VimeoClient.AccountCallback accountCallback = new VimeoClient.AccountCallback(this, string2, authCallback3);
                obj5.enqueue(accountCallback);
                return obj5;
            }
            VimeoError obj6 = new VimeoError("Facebook authentication error.");
            if (string != null) {
                if (string.isEmpty()) {
                    obj6.addInvalidParameter("token", ErrorCode.UNABLE_TO_LOGIN_NO_TOKEN, "An empty or null Facebook access token was provided.");
                }
            } else {
            }
            authCallback3.failure(obj6);
            return 0;
        }
        obj5 = new AssertionError("Callback cannot be null");
        throw obj5;
    }

    public Call<Object> postContent(String string, CacheControl cacheControl2, HashMap<String, String> hashMap3, VimeoCallback vimeoCallback4) {
        String str;
        String obj8;
        HashMap obj9;
        if (hashMap3 == null) {
            obj9 = new HashMap();
        }
        if (cacheControl2 != null) {
            str = obj8;
        } else {
            str = obj9;
        }
        return this.POST(getAuthHeader(), string, str, obj9, vimeoCallback4);
    }

    public Call<Object> putContent(String string, Map<String, String> map2, ModelCallback modelCallback3, boolean z4) {
        boolean empty;
        HashMap obj8;
        if (modelCallback3 == null) {
        } else {
            if (string != null) {
                if (string.isEmpty()) {
                } else {
                    if (map2 == null) {
                        obj8 = new HashMap();
                    }
                }
                return this.PUT(getAuthHeader(), string, obj8, getRetrofitCallback(modelCallback3), z4);
            }
            VimeoError obj7 = new VimeoError("uri cannot be empty!");
            modelCallback3.failure(obj7);
            return 0;
        }
        obj7 = new AssertionError("Callback cannot be null");
        throw obj7;
    }

    public void saveAccount(VimeoAccount vimeoAccount, String string2) {
        setVimeoAccount(vimeoAccount);
        this.mConfiguration.saveAccount(vimeoAccount, string2);
    }

    @Deprecated
    public void saveAccount(VimeoAccount vimeoAccount, String string2, String string3) {
        saveAccount(vimeoAccount, string2);
    }

    public Call<Object> search(String string, String string2, ModelCallback modelCallback3, Map<String, String> map4, String string5) {
        Object rELEVANCE;
        boolean empty;
        boolean text;
        Map obj13;
        if (string2 != null) {
            if (string2.isEmpty()) {
            } else {
                if (map4 == null) {
                    obj13 = new SearchRefinementBuilder(Vimeo.RefineSort.RELEVANCE);
                    obj13 = obj13.build();
                } else {
                    rELEVANCE = "sort";
                    if (!map4.containsKey(rELEVANCE)) {
                        map4.put(rELEVANCE, Vimeo.RefineSort.RELEVANCE.getText());
                    }
                }
            }
            return this.fetchContent(string, CacheControl.FORCE_NETWORK, modelCallback3, string2, obj13, string5);
        }
        VimeoError obj10 = new VimeoError("Query cannot be empty!");
        modelCallback3.failure(obj10);
        return 0;
    }

    Call<SearchResponse> search(Map<String, String> map, ModelCallback<SearchResponse> modelCallback2) {
        final Call obj3 = this.mVimeoService.search(getAuthHeader(), map);
        obj3.enqueue(modelCallback2);
        return obj3;
    }

    public void setVimeoAccount(VimeoAccount vimeoAccount) {
        com.vimeo.networking.Configuration mConfiguration;
        String accessToken;
        VimeoAccount obj3;
        obj3 = new VimeoAccount(mConfiguration2.accessToken);
        mConfiguration = this.mConfiguration;
        if (vimeoAccount == null && mConfiguration.accessToken != null) {
            obj3 = new VimeoAccount(mConfiguration2.accessToken);
            mConfiguration = this.mConfiguration;
            if (mConfiguration.accessToken != null) {
                mConfiguration.saveAccount(obj3, 0);
            }
        }
        this.mVimeoAccount = obj3;
    }

    public Call<VimeoAccount> singleSignOnTokenExchange(String string, AuthCallback authCallback2) {
        if (authCallback2 == null) {
        } else {
            Call obj4 = this.mVimeoService.ssoTokenExchange(getBasicAuthHeader(), string, mConfiguration.scope);
            VimeoClient.AccountCallback accountCallback = new VimeoClient.AccountCallback(this, authCallback2);
            obj4.enqueue(accountCallback);
            return obj4;
        }
        obj4 = new AssertionError("Callback cannot be null");
        throw obj4;
    }

    public Call<Object> unfollow(String string, ModelCallback modelCallback2, boolean z3) {
        return deleteContent(string, modelCallback2, z3);
    }

    public Call<Object> unlikeVideo(String string, String string2, ModelCallback modelCallback3) {
        String str;
        HashMap hashMap = new HashMap();
        if (string2 != null) {
            hashMap.put("password", string2);
        }
        return deleteContent(string, hashMap, modelCallback3, true);
    }

    public Call<Object> unwatchLaterVideo(String string, String string2, ModelCallback modelCallback3) {
        String str;
        HashMap hashMap = new HashMap();
        if (string2 != null) {
            hashMap.put("password", string2);
        }
        return deleteContent(string, hashMap, modelCallback3, true);
    }

    public Call<Object> updateFollow(boolean z, String string2, ModelCallback modelCallback3) {
        return updateFollow(z, string2, modelCallback3, true);
    }

    public Call<Object> updateFollow(boolean z, String string2, ModelCallback modelCallback3, boolean z4) {
        if (z) {
            return follow(string2, modelCallback3, z4);
        }
        return unfollow(string2, modelCallback3, z4);
    }

    public Call<Object> updateLikeVideo(boolean z, String string2, String string3, ModelCallback modelCallback4) {
        if (z) {
            return likeVideo(string2, string3, modelCallback4);
        }
        return unlikeVideo(string2, string3, modelCallback4);
    }

    public Call<Object> updateWatchLaterVideo(boolean z, String string2, String string3, ModelCallback modelCallback4) {
        if (z) {
            return watchLaterVideo(string2, string3, modelCallback4);
        }
        return unwatchLaterVideo(string2, string3, modelCallback4);
    }

    public Call<Object> watchLaterVideo(String string, String string2, ModelCallback modelCallback3) {
        String str;
        HashMap hashMap = new HashMap();
        if (string2 != null) {
            hashMap.put("password", string2);
        }
        return putContent(string, hashMap, modelCallback3, true);
    }
}
