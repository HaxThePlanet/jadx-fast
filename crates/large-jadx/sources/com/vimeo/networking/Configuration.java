package com.vimeo.networking;

import com.vimeo.networking.logging.LogProvider;
import com.vimeo.networking.model.VimeoAccount;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Cache;
import okhttp3.Interceptor;

/* compiled from: Configuration.java */
/* loaded from: classes2.dex */
public class Configuration {

    private static final int DEFAULT_CACHE_MAX_AGE = 7200;
    private static final int DEFAULT_CACHE_SIZE = 10485760;
    private static final int DEFAULT_TIMEOUT = 60;
    private static final String DEFAULT_USER_AGENT = "sample_user_agent";
    private static final String DEFAULT_VERSION_STRING = "3.2";
    public String accessToken;
    private AccountStore accountStore;
    public String apiVersionString;
    public String baseURLString;
    public File cacheDirectory;
    public int cacheMaxAge;
    public int cacheSize;
    public boolean certPinningEnabled;
    public String clientID;
    public String clientSecret;
    public String codeGrantRedirectURI;
    public GsonDeserializer deserializer;
    public final List<Interceptor> interceptors;
    public Vimeo.LogLevel logLevel;
    public LogProvider logProvider;
    public final List<Interceptor> networkInterceptors;
    public String scope;
    public int timeout;
    public String userAgentString;

    public static class Builder {

        private String accessToken;
        private AccountStore accountStore;
        private String apiVersionString;
        private String baseURLString;
        private File cacheDirectory;
        private int cacheMaxAge;
        private int cacheSize;
        private boolean certPinningEnabled;
        private String clientID;
        private String clientSecret;
        public String codeGrantRedirectUri;
        private GsonDeserializer deserializer;
        private final List<Interceptor> interceptors;
        public Vimeo.LogLevel logLevel;
        public LogProvider logProvider;
        private final List<Interceptor> networkInterceptors;
        private String scope;
        public int timeout;
        private String userAgentString;
        public Builder(String str) {
            super();
            this.baseURLString = "https://api.vimeo.com/";
            this.deserializer = new GsonDeserializer();
            this.apiVersionString = "3.2";
            this.cacheSize = 10485760;
            this.cacheMaxAge = 7200;
            this.userAgentString = "sample_user_agent";
            this.timeout = 60;
            this.networkInterceptors = new ArrayList();
            this.interceptors = new ArrayList();
            StringBuilder stringBuilder = new StringBuilder();
            String str6 = "vimeo";
            String str7 = "://auth";
            str5 = str6 + this.clientID + str7;
            this.codeGrantRedirectUri = str5;
            this.certPinningEnabled = true;
            this.logLevel = Vimeo.LogLevel.DEBUG;
            this.accessToken = str;
        }

        static /* synthetic */ String access$000(Configuration.Builder builder) {
            return builder.baseURLString;
        }

        static /* synthetic */ String access$100(Configuration.Builder builder) {
            return builder.clientID;
        }

        static /* synthetic */ int access$1000(Configuration.Builder builder) {
            return builder.cacheMaxAge;
        }

        static /* synthetic */ String access$1100(Configuration.Builder builder) {
            return builder.userAgentString;
        }

        static /* synthetic */ boolean access$1200(Configuration.Builder builder) {
            return builder.certPinningEnabled;
        }

        static /* synthetic */ List access$1300(Configuration.Builder builder) {
            return builder.networkInterceptors;
        }

        static /* synthetic */ List access$1400(Configuration.Builder builder) {
            return builder.interceptors;
        }

        static /* synthetic */ String access$200(Configuration.Builder builder) {
            return builder.clientSecret;
        }

        static /* synthetic */ String access$300(Configuration.Builder builder) {
            return builder.scope;
        }

        static /* synthetic */ String access$400(Configuration.Builder builder) {
            return builder.accessToken;
        }

        static /* synthetic */ AccountStore access$500(Configuration.Builder builder) {
            return builder.accountStore;
        }

        static /* synthetic */ GsonDeserializer access$600(Configuration.Builder builder) {
            return builder.deserializer;
        }

        static /* synthetic */ String access$700(Configuration.Builder builder) {
            return builder.apiVersionString;
        }

        static /* synthetic */ File access$800(Configuration.Builder builder) {
            return builder.cacheDirectory;
        }

        static /* synthetic */ int access$900(Configuration.Builder builder) {
            return builder.cacheSize;
        }

        public Configuration.Builder addInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.interceptors.add(interceptor);
            }
            return this;
        }

        public Configuration.Builder addInterceptors(List<Interceptor> list) {
            if (list != null) {
                this.interceptors.addAll(list);
            }
            return this;
        }

        public Configuration.Builder addNetworkInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.networkInterceptors.add(interceptor);
            }
            return this;
        }

        public Configuration.Builder addNetworkInterceptors(List<Interceptor> list) {
            if (list != null) {
                this.networkInterceptors.addAll(list);
            }
            return this;
        }

        public Configuration build() {
            return new Configuration(this, null);
        }

        public Configuration.Builder enableCertPinning(boolean z) {
            this.certPinningEnabled = z;
            return this;
        }

        public Configuration.Builder setAccessToken(String str) {
            this.accessToken = str;
            return this;
        }

        public Configuration.Builder setAccountStore(AccountStore accountStore) {
            this.accountStore = accountStore;
            return this;
        }

        public Configuration.Builder setApiVersionString(String str) {
            this.apiVersionString = str;
            return this;
        }

        public Configuration.Builder setBaseUrl(String str) {
            this.baseURLString = str;
            return this;
        }

        public Configuration.Builder setCacheDirectory(File file) {
            this.cacheDirectory = file;
            return this;
        }

        public Configuration.Builder setCacheMaxAge(int i) {
            this.cacheMaxAge = i;
            return this;
        }

        public Configuration.Builder setCacheSize(int i) {
            this.cacheSize = i;
            return this;
        }

        public Configuration.Builder setClientIdAndSecret(String str, String str2) {
            this.clientID = str;
            this.clientSecret = str2;
            return this;
        }

        public Configuration.Builder setCodeGrantRedirectUri(String str) {
            this.codeGrantRedirectUri = str;
            return this;
        }

        public Configuration.Builder setDebugLogger(LogProvider logProvider) {
            this.logProvider = logProvider;
            return this;
        }

        public Configuration.Builder setGsonDeserializer(GsonDeserializer gsonDeserializer) {
            this.deserializer = gsonDeserializer;
            return this;
        }

        public Configuration.Builder setLogLevel(Vimeo.LogLevel logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        public Configuration.Builder setTimeout(int i) {
            this.timeout = i;
            return this;
        }

        public Configuration.Builder setUserAgentString(String str) {
            this.userAgentString = str;
            return this;
        }

        public Builder(String str, String str2, String str3) {
            this(null, str, str2, str3, null, null);
        }

        @Deprecated
        public Builder(String str, String str2, String str3, String str4) {
            this(str, str2, str3, str4, null, null);
        }

        public Builder(String str, String str2, String str3, AccountStore accountStore, GsonDeserializer gsonDeserializer) {
            this(null, str, str2, str3, accountStore, gsonDeserializer);
        }

        @Deprecated
        public Builder(String str, String str2, String str3, String str4, AccountStore accountStore, GsonDeserializer gsonDeserializer) {
            String baseURLString2;
            super();
            this.baseURLString = "https://api.vimeo.com/";
            this.deserializer = new GsonDeserializer();
            this.apiVersionString = "3.2";
            this.cacheSize = 10485760;
            this.cacheMaxAge = 7200;
            this.userAgentString = "sample_user_agent";
            this.timeout = 60;
            this.networkInterceptors = new ArrayList();
            this.interceptors = new ArrayList();
            StringBuilder stringBuilder = new StringBuilder();
            String str9 = "vimeo";
            String str10 = "://auth";
            str8 = str9 + this.clientID + str10;
            this.codeGrantRedirectUri = str8;
            this.certPinningEnabled = true;
            this.logLevel = Vimeo.LogLevel.DEBUG;
            baseURLString2 = str == null ? this.baseURLString : baseURLString2;
            this.baseURLString = baseURLString2;
            this.clientID = str2;
            this.clientSecret = str3;
            this.scope = str4;
            this.accountStore = accountStore;
            this.deserializer = gsonDeserializer;
        }
    }
    /* synthetic */ Configuration(Configuration.Builder builder) {
        this(builder);
    }

    private boolean isValid() {
        boolean z = true;
        if (this.baseURLString != null) {
            if (!this.baseURLString.trim().isEmpty() && this.clientID != null) {
                if (!this.clientID.trim().isEmpty() && this.clientSecret != null) {
                    if (!this.clientSecret.trim().isEmpty() && this.scope != null) {
                        if (!this.scope.trim().isEmpty() || this.accessToken != null) {
                            int i = 1;
                        } else {
                            int r0 = !this.accessToken.trim().isEmpty() ? 1 : 0;
                        }
                    }
                }
            }
        }
        return (!this.accessToken.trim().isEmpty() ? 1 : 0);
    }

    public void deleteAccount(VimeoAccount vimeoAccount) {
        if (this.accountStore != null) {
            this.accountStore.deleteAccount(vimeoAccount);
        }
    }

    public Cache getCache() {
        if (this.cacheDirectory == null) {
            return null;
        }
        return new Cache(this.cacheDirectory, (long)this.cacheSize, r3);
    }

    public VimeoAccount loadAccount() {
        if (this.accountStore == null) {
            return null;
        }
        return this.accountStore.loadAccount();
    }

    @Deprecated
    public void saveAccount(VimeoAccount vimeoAccount, String str, String str2) {
        saveAccount(vimeoAccount, str);
    }

    private Configuration(Configuration.Builder builder) {
        super();
        ArrayList arrayList = new ArrayList();
        this.networkInterceptors = arrayList;
        final ArrayList arrayList2 = new ArrayList();
        this.interceptors = arrayList2;
        this.baseURLString = builder.baseURLString;
        this.clientID = builder.clientID;
        this.clientSecret = builder.clientSecret;
        this.scope = builder.scope;
        this.accessToken = builder.accessToken;
        this.accountStore = builder.accountStore;
        this.deserializer = builder.deserializer;
        if (!isValid()) {
            throw new AssertionError("Built invalid VimeoClientConfiguration");
        } else {
            this.codeGrantRedirectURI = builder.codeGrantRedirectUri;
            this.apiVersionString = builder.apiVersionString;
            this.cacheDirectory = builder.cacheDirectory;
            this.cacheSize = builder.cacheSize;
            this.cacheMaxAge = builder.cacheMaxAge;
            this.userAgentString = builder.userAgentString;
            this.timeout = builder.timeout;
            this.certPinningEnabled = builder.certPinningEnabled;
            this.logProvider = builder.logProvider;
            this.logLevel = builder.logLevel;
            arrayList.addAll(builder.networkInterceptors);
            arrayList2.addAll(builder.interceptors);
            return;
        }
    }

    public void saveAccount(VimeoAccount vimeoAccount, String str) {
        if (this.accountStore != null) {
            this.accountStore.saveAccount(vimeoAccount, str);
        }
    }
}
