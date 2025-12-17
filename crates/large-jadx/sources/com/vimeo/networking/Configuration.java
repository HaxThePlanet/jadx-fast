package com.vimeo.networking;

import com.vimeo.networking.logging.LogProvider;
import com.vimeo.networking.model.VimeoAccount;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Cache;
import okhttp3.Interceptor;

/* loaded from: classes2.dex */
public class Configuration {

    private static final int DEFAULT_CACHE_MAX_AGE = 7200;
    private static final int DEFAULT_CACHE_SIZE = 10485760;
    private static final int DEFAULT_TIMEOUT = 60;
    private static final String DEFAULT_USER_AGENT = "sample_user_agent";
    private static final String DEFAULT_VERSION_STRING = "3.2";
    public String accessToken;
    private com.vimeo.networking.AccountStore accountStore;
    public String apiVersionString;
    public String baseURLString;
    public File cacheDirectory;
    public int cacheMaxAge;
    public int cacheSize;
    public boolean certPinningEnabled;
    public String clientID;
    public String clientSecret;
    public String codeGrantRedirectURI;
    public com.vimeo.networking.GsonDeserializer deserializer;
    public final List<Interceptor> interceptors;
    public com.vimeo.networking.Vimeo.LogLevel logLevel;
    public LogProvider logProvider;
    public final List<Interceptor> networkInterceptors;
    public String scope;
    public int timeout;
    public String userAgentString;

    public static class Builder {

        private String accessToken;
        private com.vimeo.networking.AccountStore accountStore;
        private String apiVersionString;
        private String baseURLString;
        private File cacheDirectory;
        private int cacheMaxAge;
        private int cacheSize;
        private boolean certPinningEnabled;
        private String clientID;
        private String clientSecret;
        public String codeGrantRedirectUri;
        private com.vimeo.networking.GsonDeserializer deserializer;
        private final List<Interceptor> interceptors;
        public com.vimeo.networking.Vimeo.LogLevel logLevel;
        public LogProvider logProvider;
        private final List<Interceptor> networkInterceptors;
        private String scope;
        public int timeout;
        private String userAgentString;
        public Builder(String string) {
            super();
            this.baseURLString = "https://api.vimeo.com/";
            GsonDeserializer gsonDeserializer = new GsonDeserializer();
            this.deserializer = gsonDeserializer;
            this.apiVersionString = "3.2";
            this.cacheSize = 10485760;
            this.cacheMaxAge = 7200;
            this.userAgentString = "sample_user_agent";
            this.timeout = 60;
            ArrayList arrayList = new ArrayList();
            this.networkInterceptors = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.interceptors = arrayList2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("vimeo");
            stringBuilder.append(this.clientID);
            stringBuilder.append("://auth");
            this.codeGrantRedirectUri = stringBuilder.toString();
            this.certPinningEnabled = true;
            this.logLevel = Vimeo.LogLevel.DEBUG;
            this.accessToken = string;
        }

        public Builder(String string, String string2, String string3) {
            super(0, string, string2, string3, 0, 0);
        }

        public Builder(String string, String string2, String string3, com.vimeo.networking.AccountStore accountStore4, com.vimeo.networking.GsonDeserializer gsonDeserializer5) {
            super(0, string, string2, string3, accountStore4, gsonDeserializer5);
        }

        @Deprecated
        public Builder(String string, String string2, String string3, String string4) {
            super(string, string2, string3, string4, 0, 0);
        }

        @Deprecated
        public Builder(String string, String string2, String string3, String string4, com.vimeo.networking.AccountStore accountStore5, com.vimeo.networking.GsonDeserializer gsonDeserializer6) {
            String obj3;
            super();
            this.baseURLString = "https://api.vimeo.com/";
            GsonDeserializer gsonDeserializer = new GsonDeserializer();
            this.deserializer = gsonDeserializer;
            this.apiVersionString = "3.2";
            this.cacheSize = 10485760;
            this.cacheMaxAge = 7200;
            this.userAgentString = "sample_user_agent";
            this.timeout = 60;
            ArrayList arrayList = new ArrayList();
            this.networkInterceptors = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.interceptors = arrayList2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("vimeo");
            stringBuilder.append(this.clientID);
            stringBuilder.append("://auth");
            this.codeGrantRedirectUri = stringBuilder.toString();
            this.certPinningEnabled = true;
            this.logLevel = Vimeo.LogLevel.DEBUG;
            obj3 = string == null ? this.baseURLString : obj3;
            this.baseURLString = obj3;
            this.clientID = string2;
            this.clientSecret = string3;
            this.scope = string4;
            this.accountStore = accountStore5;
            this.deserializer = gsonDeserializer6;
        }

        static String access$000(com.vimeo.networking.Configuration.Builder configuration$Builder) {
            return builder.baseURLString;
        }

        static String access$100(com.vimeo.networking.Configuration.Builder configuration$Builder) {
            return builder.clientID;
        }

        static int access$1000(com.vimeo.networking.Configuration.Builder configuration$Builder) {
            return builder.cacheMaxAge;
        }

        static String access$1100(com.vimeo.networking.Configuration.Builder configuration$Builder) {
            return builder.userAgentString;
        }

        static boolean access$1200(com.vimeo.networking.Configuration.Builder configuration$Builder) {
            return builder.certPinningEnabled;
        }

        static List access$1300(com.vimeo.networking.Configuration.Builder configuration$Builder) {
            return builder.networkInterceptors;
        }

        static List access$1400(com.vimeo.networking.Configuration.Builder configuration$Builder) {
            return builder.interceptors;
        }

        static String access$200(com.vimeo.networking.Configuration.Builder configuration$Builder) {
            return builder.clientSecret;
        }

        static String access$300(com.vimeo.networking.Configuration.Builder configuration$Builder) {
            return builder.scope;
        }

        static String access$400(com.vimeo.networking.Configuration.Builder configuration$Builder) {
            return builder.accessToken;
        }

        static com.vimeo.networking.AccountStore access$500(com.vimeo.networking.Configuration.Builder configuration$Builder) {
            return builder.accountStore;
        }

        static com.vimeo.networking.GsonDeserializer access$600(com.vimeo.networking.Configuration.Builder configuration$Builder) {
            return builder.deserializer;
        }

        static String access$700(com.vimeo.networking.Configuration.Builder configuration$Builder) {
            return builder.apiVersionString;
        }

        static File access$800(com.vimeo.networking.Configuration.Builder configuration$Builder) {
            return builder.cacheDirectory;
        }

        static int access$900(com.vimeo.networking.Configuration.Builder configuration$Builder) {
            return builder.cacheSize;
        }

        public com.vimeo.networking.Configuration.Builder addInterceptor(Interceptor interceptor) {
            List interceptors;
            if (interceptor != null) {
                this.interceptors.add(interceptor);
            }
            return this;
        }

        public com.vimeo.networking.Configuration.Builder addInterceptors(List<Interceptor> list) {
            List interceptors;
            if (list != null) {
                this.interceptors.addAll(list);
            }
            return this;
        }

        public com.vimeo.networking.Configuration.Builder addNetworkInterceptor(Interceptor interceptor) {
            List networkInterceptors;
            if (interceptor != null) {
                this.networkInterceptors.add(interceptor);
            }
            return this;
        }

        public com.vimeo.networking.Configuration.Builder addNetworkInterceptors(List<Interceptor> list) {
            List networkInterceptors;
            if (list != null) {
                this.networkInterceptors.addAll(list);
            }
            return this;
        }

        public com.vimeo.networking.Configuration build() {
            Configuration configuration = new Configuration(this, 0);
            return configuration;
        }

        public com.vimeo.networking.Configuration.Builder enableCertPinning(boolean z) {
            this.certPinningEnabled = z;
            return this;
        }

        public com.vimeo.networking.Configuration.Builder setAccessToken(String string) {
            this.accessToken = string;
            return this;
        }

        public com.vimeo.networking.Configuration.Builder setAccountStore(com.vimeo.networking.AccountStore accountStore) {
            this.accountStore = accountStore;
            return this;
        }

        public com.vimeo.networking.Configuration.Builder setApiVersionString(String string) {
            this.apiVersionString = string;
            return this;
        }

        public com.vimeo.networking.Configuration.Builder setBaseUrl(String string) {
            this.baseURLString = string;
            return this;
        }

        public com.vimeo.networking.Configuration.Builder setCacheDirectory(File file) {
            this.cacheDirectory = file;
            return this;
        }

        public com.vimeo.networking.Configuration.Builder setCacheMaxAge(int i) {
            this.cacheMaxAge = i;
            return this;
        }

        public com.vimeo.networking.Configuration.Builder setCacheSize(int i) {
            this.cacheSize = i;
            return this;
        }

        public com.vimeo.networking.Configuration.Builder setClientIdAndSecret(String string, String string2) {
            this.clientID = string;
            this.clientSecret = string2;
            return this;
        }

        public com.vimeo.networking.Configuration.Builder setCodeGrantRedirectUri(String string) {
            this.codeGrantRedirectUri = string;
            return this;
        }

        public com.vimeo.networking.Configuration.Builder setDebugLogger(LogProvider logProvider) {
            this.logProvider = logProvider;
            return this;
        }

        public com.vimeo.networking.Configuration.Builder setGsonDeserializer(com.vimeo.networking.GsonDeserializer gsonDeserializer) {
            this.deserializer = gsonDeserializer;
            return this;
        }

        public com.vimeo.networking.Configuration.Builder setLogLevel(com.vimeo.networking.Vimeo.LogLevel vimeo$LogLevel) {
            this.logLevel = logLevel;
            return this;
        }

        public com.vimeo.networking.Configuration.Builder setTimeout(int i) {
            this.timeout = i;
            return this;
        }

        public com.vimeo.networking.Configuration.Builder setUserAgentString(String string) {
            this.userAgentString = string;
            return this;
        }
    }
    private Configuration(com.vimeo.networking.Configuration.Builder configuration$Builder) {
        super();
        ArrayList arrayList = new ArrayList();
        this.networkInterceptors = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.interceptors = arrayList2;
        this.baseURLString = Configuration.Builder.access$000(builder);
        this.clientID = Configuration.Builder.access$100(builder);
        this.clientSecret = Configuration.Builder.access$200(builder);
        this.scope = Configuration.Builder.access$300(builder);
        this.accessToken = Configuration.Builder.access$400(builder);
        this.accountStore = Configuration.Builder.access$500(builder);
        this.deserializer = Configuration.Builder.access$600(builder);
        if (!isValid()) {
        } else {
            this.codeGrantRedirectURI = builder.codeGrantRedirectUri;
            this.apiVersionString = Configuration.Builder.access$700(builder);
            this.cacheDirectory = Configuration.Builder.access$800(builder);
            this.cacheSize = Configuration.Builder.access$900(builder);
            this.cacheMaxAge = Configuration.Builder.access$1000(builder);
            this.userAgentString = Configuration.Builder.access$1100(builder);
            this.timeout = builder.timeout;
            this.certPinningEnabled = Configuration.Builder.access$1200(builder);
            this.logProvider = builder.logProvider;
            this.logLevel = builder.logLevel;
            arrayList.addAll(Configuration.Builder.access$1300(builder));
            arrayList2.addAll(Configuration.Builder.access$1400(builder));
        }
        AssertionError obj4 = new AssertionError("Built invalid VimeoClientConfiguration");
        throw obj4;
    }

    Configuration(com.vimeo.networking.Configuration.Builder configuration$Builder, com.vimeo.networking.Configuration.1 configuration$12) {
        super(builder);
    }

    private boolean isValid() {
        boolean baseURLString;
        int i;
        baseURLString = this.baseURLString;
        baseURLString = this.clientID;
        baseURLString = this.clientSecret;
        baseURLString = this.scope;
        if (baseURLString != null && !baseURLString.trim().isEmpty() && baseURLString != null && !baseURLString.trim().isEmpty() && baseURLString != null && !baseURLString.trim().isEmpty() && baseURLString != null) {
            if (!baseURLString.trim().isEmpty()) {
                baseURLString = this.clientID;
                if (baseURLString != null) {
                    if (!baseURLString.trim().isEmpty()) {
                        baseURLString = this.clientSecret;
                        if (baseURLString != null) {
                            if (!baseURLString.trim().isEmpty()) {
                                baseURLString = this.scope;
                                if (baseURLString != null) {
                                    if (baseURLString.trim().isEmpty()) {
                                        baseURLString = this.accessToken;
                                        if (baseURLString != null && !baseURLString.trim().isEmpty()) {
                                            i = !baseURLString.trim().isEmpty() ? 1 : 0;
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public void deleteAccount(VimeoAccount vimeoAccount) {
        final com.vimeo.networking.AccountStore accountStore = this.accountStore;
        if (accountStore != null) {
            accountStore.deleteAccount(vimeoAccount);
        }
    }

    public Cache getCache() {
        if (this.cacheDirectory == null) {
            return null;
        }
        Cache cache = new Cache(this.cacheDirectory, (long)cacheSize, obj3);
        return cache;
    }

    public VimeoAccount loadAccount() {
        com.vimeo.networking.AccountStore accountStore = this.accountStore;
        if (accountStore == null) {
            return null;
        }
        return accountStore.loadAccount();
    }

    public void saveAccount(VimeoAccount vimeoAccount, String string2) {
        final com.vimeo.networking.AccountStore accountStore = this.accountStore;
        if (accountStore != null) {
            accountStore.saveAccount(vimeoAccount, string2);
        }
    }

    @Deprecated
    public void saveAccount(VimeoAccount vimeoAccount, String string2, String string3) {
        saveAccount(vimeoAccount, string2);
    }
}
