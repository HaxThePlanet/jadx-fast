package com.google.firebase.database.connection;

import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import com.google.android.gms.tasks.m;
import com.google.firebase.database.connection.util.RetryHelper;
import com.google.firebase.database.connection.util.RetryHelper.Builder;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.util.GAuthToken;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class PersistentConnectionImpl implements com.google.firebase.database.connection.Connection.Delegate, com.google.firebase.database.connection.PersistentConnection {

    private static final long GET_CONNECT_TIMEOUT = 3000L;
    private static final String IDLE_INTERRUPT_REASON = "connection_idle";
    private static final long IDLE_TIMEOUT = 60000L;
    private static final String INVALID_APP_CHECK_TOKEN = "Invalid appcheck token";
    private static final long INVALID_TOKEN_THRESHOLD = 3L;
    private static final String REQUEST_ACTION = "a";
    private static final String REQUEST_ACTION_APPCHECK = "appcheck";
    private static final String REQUEST_ACTION_AUTH = "auth";
    private static final String REQUEST_ACTION_GAUTH = "gauth";
    private static final String REQUEST_ACTION_GET = "g";
    private static final String REQUEST_ACTION_MERGE = "m";
    private static final String REQUEST_ACTION_ONDISCONNECT_CANCEL = "oc";
    private static final String REQUEST_ACTION_ONDISCONNECT_MERGE = "om";
    private static final String REQUEST_ACTION_ONDISCONNECT_PUT = "o";
    private static final String REQUEST_ACTION_PUT = "p";
    private static final String REQUEST_ACTION_QUERY = "q";
    private static final String REQUEST_ACTION_QUERY_UNLISTEN = "n";
    private static final String REQUEST_ACTION_STATS = "s";
    private static final String REQUEST_ACTION_UNAPPCHECK = "unappcheck";
    private static final String REQUEST_ACTION_UNAUTH = "unauth";
    private static final String REQUEST_APPCHECK_TOKEN = "token";
    private static final String REQUEST_AUTHVAR = "authvar";
    private static final String REQUEST_COMPOUND_HASH = "ch";
    private static final String REQUEST_COMPOUND_HASH_HASHES = "hs";
    private static final String REQUEST_COMPOUND_HASH_PATHS = "ps";
    private static final String REQUEST_COUNTERS = "c";
    private static final String REQUEST_CREDENTIAL = "cred";
    private static final String REQUEST_DATA_HASH = "h";
    private static final String REQUEST_DATA_PAYLOAD = "d";
    private static final String REQUEST_ERROR = "error";
    private static final String REQUEST_NUMBER = "r";
    private static final String REQUEST_PATH = "p";
    private static final String REQUEST_PAYLOAD = "b";
    private static final String REQUEST_QUERIES = "q";
    private static final String REQUEST_STATUS = "s";
    private static final String REQUEST_TAG = "t";
    private static final String RESPONSE_FOR_REQUEST = "b";
    private static final String SERVER_ASYNC_ACTION = "a";
    private static final String SERVER_ASYNC_APP_CHECK_REVOKED = "apc";
    private static final String SERVER_ASYNC_AUTH_REVOKED = "ac";
    private static final String SERVER_ASYNC_DATA_MERGE = "m";
    private static final String SERVER_ASYNC_DATA_RANGE_MERGE = "rm";
    private static final String SERVER_ASYNC_DATA_UPDATE = "d";
    private static final String SERVER_ASYNC_LISTEN_CANCELLED = "c";
    private static final String SERVER_ASYNC_PAYLOAD = "b";
    private static final String SERVER_ASYNC_SECURITY_DEBUG = "sd";
    private static final String SERVER_DATA_END_PATH = "e";
    private static final String SERVER_DATA_RANGE_MERGE = "m";
    private static final String SERVER_DATA_START_PATH = "s";
    private static final String SERVER_DATA_TAG = "t";
    private static final String SERVER_DATA_UPDATE_BODY = "d";
    private static final String SERVER_DATA_UPDATE_PATH = "p";
    private static final String SERVER_DATA_WARNINGS = "w";
    private static final String SERVER_KILL_INTERRUPT_REASON = "server_kill";
    private static final String SERVER_RESPONSE_DATA = "d";
    private static final long SUCCESSFUL_CONNECTION_ESTABLISHED_DELAY = 30000L;
    private static final String TOKEN_REFRESH_INTERRUPT_REASON = "token_refresh";
    private static long connectionIds;
    private String appCheckToken;
    private final com.google.firebase.database.connection.ConnectionTokenProvider appCheckTokenProvider;
    private String authToken;
    private final com.google.firebase.database.connection.ConnectionTokenProvider authTokenProvider;
    private String cachedHost;
    private com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionState connectionState = 1;
    private final com.google.firebase.database.connection.ConnectionContext context;
    private long currentGetTokenAttempt = 0;
    private final com.google.firebase.database.connection.PersistentConnection.Delegate delegate;
    private final ScheduledExecutorService executorService;
    private boolean firstConnection = true;
    private boolean forceAppCheckTokenRefresh;
    private boolean forceAuthTokenRefresh;
    private boolean hasOnDisconnects;
    private final com.google.firebase.database.connection.HostInfo hostInfo;
    private ScheduledFuture<?> inactivityTimer = null;
    private HashSet<String> interruptReasons;
    private int invalidAppCheckTokenCount = 0;
    private int invalidAuthTokenCount = 0;
    private long lastConnectionEstablishedTime;
    private String lastSessionId = null;
    private long lastWriteTimestamp;
    private Map<com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec, com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingListen> listens;
    private final LogWrapper logger;
    private List<com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingDisconnect> onDisconnectRequestQueue;
    private Map<Long, com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingGet> outstandingGets;
    private Map<Long, com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingPut> outstandingPuts;
    private long readCounter = 0;
    private com.google.firebase.database.connection.Connection realtime;
    private Map<Long, com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback> requestCBHash;
    private long requestCounter = 0;
    private final RetryHelper retryHelper;
    private long writeCounter = 0;

    private interface ConnectionRequestCallback {
        public abstract void onResponse(Map<String, Object> map);
    }

    private static enum ConnectionState {

        Disconnected,
        GettingToken,
        Connecting,
        Authenticating,
        Connected;
    }

    private static class OutstandingDisconnect {

        private final String action;
        private final Object data;
        private final com.google.firebase.database.connection.RequestResultCallback onComplete;
        private final List<String> path;
        private OutstandingDisconnect(String string, List<String> list2, Object object3, com.google.firebase.database.connection.RequestResultCallback requestResultCallback4) {
            super();
            this.action = string;
            this.path = list2;
            this.data = object3;
            this.onComplete = requestResultCallback4;
        }

        OutstandingDisconnect(String string, List list2, Object object3, com.google.firebase.database.connection.RequestResultCallback requestResultCallback4, com.google.firebase.database.connection.PersistentConnectionImpl.1 persistentConnectionImpl$15) {
            super(string, list2, object3, requestResultCallback4);
        }

        static com.google.firebase.database.connection.RequestResultCallback access$500(com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingDisconnect persistentConnectionImpl$OutstandingDisconnect) {
            return outstandingDisconnect.onComplete;
        }

        public String getAction() {
            return this.action;
        }

        public Object getData() {
            return this.data;
        }

        public com.google.firebase.database.connection.RequestResultCallback getOnComplete() {
            return this.onComplete;
        }

        public List<String> getPath() {
            return this.path;
        }
    }

    private static class OutstandingGet {

        private final com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback onComplete;
        private final Map<String, Object> request;
        private boolean sent;
        private OutstandingGet(String string, Map<String, Object> map2, com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback persistentConnectionImpl$ConnectionRequestCallback3) {
            super();
            this.request = map2;
            this.onComplete = connectionRequestCallback3;
            this.sent = false;
        }

        OutstandingGet(String string, Map map2, com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback persistentConnectionImpl$ConnectionRequestCallback3, com.google.firebase.database.connection.PersistentConnectionImpl.1 persistentConnectionImpl$14) {
            super(string, map2, connectionRequestCallback3);
        }

        static boolean access$2100(com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingGet persistentConnectionImpl$OutstandingGet) {
            return outstandingGet.markSent();
        }

        static Map access$2200(com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingGet persistentConnectionImpl$OutstandingGet) {
            return outstandingGet.getRequest();
        }

        static com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback access$2400(com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingGet persistentConnectionImpl$OutstandingGet) {
            return outstandingGet.getOnComplete();
        }

        private com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback getOnComplete() {
            return this.onComplete;
        }

        private Map<String, Object> getRequest() {
            return this.request;
        }

        private boolean markSent() {
            if (this.sent) {
                return 0;
            }
            int i2 = 1;
            this.sent = i2;
            return i2;
        }
    }

    private static class OutstandingListen {

        private final com.google.firebase.database.connection.ListenHashProvider hashFunction;
        private final com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec query;
        private final com.google.firebase.database.connection.RequestResultCallback resultCallback;
        private final Long tag;
        private OutstandingListen(com.google.firebase.database.connection.RequestResultCallback requestResultCallback, com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec persistentConnectionImpl$QuerySpec2, Long long3, com.google.firebase.database.connection.ListenHashProvider listenHashProvider4) {
            super();
            this.resultCallback = requestResultCallback;
            this.query = querySpec2;
            this.hashFunction = listenHashProvider4;
            this.tag = long3;
        }

        OutstandingListen(com.google.firebase.database.connection.RequestResultCallback requestResultCallback, com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec persistentConnectionImpl$QuerySpec2, Long long3, com.google.firebase.database.connection.ListenHashProvider listenHashProvider4, com.google.firebase.database.connection.PersistentConnectionImpl.1 persistentConnectionImpl$15) {
            super(requestResultCallback, querySpec2, long3, listenHashProvider4);
        }

        static com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec access$700(com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingListen persistentConnectionImpl$OutstandingListen) {
            return outstandingListen.query;
        }

        static com.google.firebase.database.connection.RequestResultCallback access$800(com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingListen persistentConnectionImpl$OutstandingListen) {
            return outstandingListen.resultCallback;
        }

        public com.google.firebase.database.connection.ListenHashProvider getHashFunction() {
            return this.hashFunction;
        }

        public com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec getQuery() {
            return this.query;
        }

        public Long getTag() {
            return this.tag;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.query.toString());
            stringBuilder.append(" (Tag: ");
            stringBuilder.append(this.tag);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }

    private static class OutstandingPut {

        private String action;
        private com.google.firebase.database.connection.RequestResultCallback onComplete;
        private Map<String, Object> request;
        private boolean sent;
        private OutstandingPut(String string, Map<String, Object> map2, com.google.firebase.database.connection.RequestResultCallback requestResultCallback3) {
            super();
            this.action = string;
            this.request = map2;
            this.onComplete = requestResultCallback3;
        }

        OutstandingPut(String string, Map map2, com.google.firebase.database.connection.RequestResultCallback requestResultCallback3, com.google.firebase.database.connection.PersistentConnectionImpl.1 persistentConnectionImpl$14) {
            super(string, map2, requestResultCallback3);
        }

        static com.google.firebase.database.connection.RequestResultCallback access$400(com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingPut persistentConnectionImpl$OutstandingPut) {
            return outstandingPut.onComplete;
        }

        public String getAction() {
            return this.action;
        }

        public com.google.firebase.database.connection.RequestResultCallback getOnComplete() {
            return this.onComplete;
        }

        public Map<String, Object> getRequest() {
            return this.request;
        }

        public void markSent() {
            this.sent = true;
        }

        public boolean wasSent() {
            return this.sent;
        }
    }

    private static class QuerySpec {

        private final List<String> path;
        private final Map<String, Object> queryParams;
        public QuerySpec(List<String> list, Map<String, Object> map2) {
            super();
            this.path = list;
            this.queryParams = map2;
        }

        static List access$100(com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec persistentConnectionImpl$QuerySpec) {
            return querySpec.path;
        }

        static Map access$200(com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec persistentConnectionImpl$QuerySpec) {
            return querySpec.queryParams;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return 1;
            }
            final int i = 0;
            if (!object instanceof PersistentConnectionImpl.QuerySpec) {
                return i;
            }
            if (!this.path.equals(object.path)) {
                return i;
            }
            return this.queryParams.equals(object.queryParams);
        }

        public int hashCode() {
            return i2 += i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ConnectionUtils.pathToString(this.path));
            stringBuilder.append(" (params: ");
            stringBuilder.append(this.queryParams);
            stringBuilder.append(")");
            return stringBuilder.toString();
        }
    }
    static {
    }

    public PersistentConnectionImpl(com.google.firebase.database.connection.ConnectionContext connectionContext, com.google.firebase.database.connection.HostInfo hostInfo2, com.google.firebase.database.connection.PersistentConnection.Delegate persistentConnection$Delegate3) {
        super();
        HashSet hashSet = new HashSet();
        this.interruptReasons = hashSet;
        int i = 1;
        com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionState disconnected = PersistentConnectionImpl.ConnectionState.Disconnected;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        this.delegate = delegate3;
        this.context = connectionContext;
        ScheduledExecutorService obj7 = connectionContext.getExecutorService();
        this.executorService = obj7;
        this.authTokenProvider = connectionContext.getAuthTokenProvider();
        this.appCheckTokenProvider = connectionContext.getAppCheckTokenProvider();
        this.hostInfo = hostInfo2;
        HashMap obj6 = new HashMap();
        this.listens = obj6;
        obj6 = new HashMap();
        this.requestCBHash = obj6;
        obj6 = new HashMap();
        this.outstandingPuts = obj6;
        obj6 = new ConcurrentHashMap();
        this.outstandingGets = obj6;
        obj6 = new ArrayList();
        this.onDisconnectRequestQueue = obj6;
        String str = "ConnectionRetryHelper";
        obj6 = new RetryHelper.Builder(obj7, connectionContext.getLogger(), str);
        this.retryHelper = obj6.withMinDelayAfterFailure(1000).withRetryExponent(4608533498688228557L).withMaxDelay(30000).withJitterFactor(4604480259023595110L).build();
        obj6 = PersistentConnectionImpl.connectionIds;
        PersistentConnectionImpl.connectionIds = i7 += obj6;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("pc_");
        stringBuilder.append(obj6);
        LogWrapper logWrapper = new LogWrapper(connectionContext.getLogger(), "PersistentConnection", stringBuilder.toString());
        this.logger = logWrapper;
        doIdleCheck();
    }

    private void a(com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec persistentConnectionImpl$QuerySpec, k k2, Map map3) {
        com.google.firebase.database.connection.PersistentConnection.Delegate delegate;
        int str;
        int i;
        Object obj4;
        Object obj6;
        str = "d";
        if ((String)map3.get("s").equals("ok")) {
            obj6 = map3.get(str);
            this.delegate.onDataUpdate(PersistentConnectionImpl.QuerySpec.access$100(querySpec), obj6, false, 0);
            k2.c(obj6);
        } else {
            obj4 = new Exception((String)map3.get(str));
            k2.b(obj4);
        }
    }

    static int access$1000(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.invalidAuthTokenCount;
    }

    static int access$1002(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl, int i2) {
        persistentConnectionImpl.invalidAuthTokenCount = i2;
        return i2;
    }

    static int access$1008(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl) {
        final int invalidAuthTokenCount = persistentConnectionImpl.invalidAuthTokenCount;
        persistentConnectionImpl.invalidAuthTokenCount = invalidAuthTokenCount + 1;
        return invalidAuthTokenCount;
    }

    static void access$1100(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl, boolean z2) {
        persistentConnectionImpl.sendAppCheckTokenHelper(z2);
    }

    static String access$1202(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl, String string2) {
        persistentConnectionImpl.authToken = string2;
        return string2;
    }

    static boolean access$1302(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl, boolean z2) {
        persistentConnectionImpl.forceAuthTokenRefresh = z2;
        return z2;
    }

    static com.google.firebase.database.connection.PersistentConnection.Delegate access$1400(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.delegate;
    }

    static LogWrapper access$1500(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.logger;
    }

    static com.google.firebase.database.connection.Connection access$1600(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.realtime;
    }

    static RetryHelper access$1700(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.retryHelper;
    }

    static Map access$1900(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.outstandingPuts;
    }

    static void access$2000(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl) {
        persistentConnectionImpl.doIdleCheck();
    }

    static Map access$2300(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.outstandingGets;
    }

    static void access$2500(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl, List list2, com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec persistentConnectionImpl$QuerySpec3) {
        persistentConnectionImpl.warnOnListenerWarnings(list2, querySpec3);
    }

    static Map access$2600(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.listens;
    }

    static com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingListen access$2700(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl, com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec persistentConnectionImpl$QuerySpec2) {
        return persistentConnectionImpl.removeListen(querySpec2);
    }

    static ScheduledFuture access$2802(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl, ScheduledFuture scheduledFuture2) {
        persistentConnectionImpl.inactivityTimer = scheduledFuture2;
        return scheduledFuture2;
    }

    static boolean access$2900(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl) {
        return persistentConnectionImpl.idleHasTimedOut();
    }

    static com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionState access$902(com.google.firebase.database.connection.PersistentConnectionImpl persistentConnectionImpl, com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionState persistentConnectionImpl$ConnectionState2) {
        persistentConnectionImpl.connectionState = connectionState2;
        return connectionState2;
    }

    private void c(com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingGet persistentConnectionImpl$OutstandingGet, long l2, k k3) {
        String string;
        Object[] arr;
        boolean obj3;
        if (!PersistentConnectionImpl.OutstandingGet.access$2100(outstandingGet)) {
        }
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("get ");
            stringBuilder.append(l2);
            stringBuilder.append(" timed out waiting for connection");
            this.logger.debug(stringBuilder.toString(), new Object[0]);
        }
        this.outstandingGets.remove(Long.valueOf(l2));
        obj3 = new Exception("Client is offline");
        obj6.b(obj3);
    }

    private boolean canSendReads() {
        int i;
        i = this.connectionState == PersistentConnectionImpl.ConnectionState.Connected ? 1 : 0;
        return i;
    }

    private boolean canSendWrites() {
        int i;
        i = this.connectionState == PersistentConnectionImpl.ConnectionState.Connected ? 1 : 0;
        return i;
    }

    private void cancelSentTransactions() {
        Iterator onComplete;
        Object value;
        boolean next;
        boolean sent;
        String str;
        ArrayList arrayList = new ArrayList();
        onComplete = this.outstandingPuts.entrySet().iterator();
        while (onComplete.hasNext()) {
            value = (Map.Entry)onComplete.next().getValue();
            if ((PersistentConnectionImpl.OutstandingPut)value.getRequest().containsKey("h") && value.wasSent()) {
            }
            if (value.wasSent()) {
            }
            arrayList.add(value);
            onComplete.remove();
        }
        Iterator iterator = arrayList.iterator();
        for (PersistentConnectionImpl.OutstandingPut next3 : iterator) {
            next3.getOnComplete().onRequestResult("disconnected", false);
        }
    }

    private boolean connected() {
        int i;
        com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionState authenticating;
        com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionState connectionState = this.connectionState;
        if (connectionState != PersistentConnectionImpl.ConnectionState.Authenticating) {
            if (connectionState == PersistentConnectionImpl.ConnectionState.Connected) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private void doIdleCheck() {
        Object schedule;
        int i;
        com.google.firebase.database.connection.PersistentConnectionImpl.9 interrupted;
        int i2;
        TimeUnit mILLISECONDS;
        if (isIdle()) {
            ScheduledFuture inactivityTimer = this.inactivityTimer;
            if (inactivityTimer != null) {
                inactivityTimer.cancel(false);
            }
            interrupted = new PersistentConnectionImpl.9(this);
            this.inactivityTimer = this.executorService.schedule(interrupted, 60000, obj3);
        } else {
            schedule = "connection_idle";
            if (isInterrupted(schedule)) {
                ConnectionUtils.hardAssert(idle2 ^= 1);
                resume(schedule);
            }
        }
    }

    private void e(boolean z, Map map2) {
        Object arr;
        boolean equals;
        StringBuilder stringBuilder;
        String str;
        String obj7;
        arr = map2.get("s");
        final int i3 = 0;
        if ((String)arr.equals("ok")) {
            this.invalidAppCheckTokenCount = i3;
        } else {
            this.appCheckToken = 0;
            this.forceAppCheckTokenRefresh = true;
            stringBuilder = new StringBuilder();
            stringBuilder.append("App check failed: ");
            stringBuilder.append(arr);
            stringBuilder.append(" (");
            stringBuilder.append((String)map2.get("d"));
            stringBuilder.append(")");
            this.logger.debug(stringBuilder.toString(), new Object[i3]);
        }
        if (z) {
            restoreState();
        }
    }

    private j<String> fetchAppCheckToken(boolean z) {
        k kVar = new k();
        this.logger.debug("Trying to fetch app check token", new Object[0]);
        PersistentConnectionImpl.2 anon = new PersistentConnectionImpl.2(this, kVar);
        this.appCheckTokenProvider.getToken(z, anon);
        return kVar.a();
    }

    private j<String> fetchAuthToken(boolean z) {
        k kVar = new k();
        this.logger.debug("Trying to fetch auth token", new Object[0]);
        PersistentConnectionImpl.1 anon = new PersistentConnectionImpl.1(this, kVar);
        this.authTokenProvider.getToken(z, anon);
        return kVar.a();
    }

    private void g(long l, j j2, j j3, Void void4) {
        long currentGetTokenAttempt;
        int obj5;
        Object[] obj6;
        String obj7;
        Object obj9;
        obj9 = this.connectionState;
        final int i = 0;
        if (obj9 == PersistentConnectionImpl.ConnectionState.GettingToken) {
            if (Long.compare(l, currentGetTokenAttempt) == 0) {
                this.logger.debug("Successfully fetched token, opening connection", new Object[i]);
                openNetworkConnection((String)j3.getResult(), (String)void4.getResult());
            } else {
                obj6 = 1;
                obj5 = obj9 == PersistentConnectionImpl.ConnectionState.Disconnected ? obj6 : i;
                obj6 = new Object[obj6];
                obj6[i] = obj9;
                ConnectionUtils.hardAssert(obj5, "Expected connection state disconnected, but was %s", obj6);
                this.logger.debug("Not opening connection after token refresh, because connection was set to disconnected", new Object[i]);
            }
        } else {
            this.logger.debug("Ignoring getToken result, because this was not the latest attempt.", new Object[i]);
        }
    }

    private Map<String, Object> getPutObject(List<String> list, Object object2, String string3) {
        String obj3;
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(list));
        hashMap.put("d", object2);
        if (string3 != null) {
            hashMap.put("h", string3);
        }
        return hashMap;
    }

    private void handleTimestamp(long l) {
        boolean logsDebug;
        Object[] arr;
        String str;
        if (this.logger.logsDebug()) {
            this.logger.debug("handling timestamp", new Object[0]);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("serverTimeOffset", Long.valueOf(l -= currentTimeMillis));
        this.delegate.onServerInfoUpdate(hashMap);
    }

    private void i(long l, Exception exception2) {
        StringBuilder currentGetTokenAttempt;
        String str;
        LogWrapper obj3;
        Object[] obj4;
        String obj5;
        obj4 = 0;
        if (Long.compare(l, currentGetTokenAttempt) == 0) {
            this.connectionState = PersistentConnectionImpl.ConnectionState.Disconnected;
            currentGetTokenAttempt = new StringBuilder();
            currentGetTokenAttempt.append("Error fetching token: ");
            currentGetTokenAttempt.append(obj5);
            this.logger.debug(currentGetTokenAttempt.toString(), new Object[obj4]);
            tryScheduleReconnect();
        } else {
            this.logger.debug("Ignoring getToken error, because this was not the latest attempt.", new Object[obj4]);
        }
    }

    private boolean idleHasTimedOut() {
        long currentTimeMillis;
        int i2;
        boolean idle;
        int i;
        if (isIdle() && Long.compare(currentTimeMillis, idle) > 0) {
            i2 = Long.compare(currentTimeMillis, idle) > 0 ? 1 : 0;
        } else {
        }
        return i2;
    }

    private boolean isIdle() {
        int i;
        boolean hasOnDisconnects;
        if (this.listens.isEmpty() && this.outstandingGets.isEmpty() && this.requestCBHash.isEmpty() && !this.hasOnDisconnects && this.outstandingPuts.isEmpty()) {
            if (this.outstandingGets.isEmpty()) {
                if (this.requestCBHash.isEmpty()) {
                    if (!this.hasOnDisconnects) {
                        i = this.outstandingPuts.isEmpty() ? 1 : 0;
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

    private void k(boolean z, boolean z2) {
        int i;
        com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionState connectionState = this.connectionState;
        int i3 = 1;
        final int i4 = 0;
        i = connectionState == PersistentConnectionImpl.ConnectionState.Disconnected ? i3 : i4;
        Object[] arr = new Object[i3];
        arr[i4] = connectionState;
        ConnectionUtils.hardAssert(i, "Not in disconnected state: %s", arr);
        this.connectionState = PersistentConnectionImpl.ConnectionState.GettingToken;
        currentGetTokenAttempt += i5;
        this.currentGetTokenAttempt = i2;
        final j authToken = fetchAuthToken(z);
        final j appCheckToken = fetchAppCheckToken(z2);
        j[] obj13 = new j[2];
        obj13[i4] = authToken;
        obj13[i3] = appCheckToken;
        super(this, i2, obj9, authToken, appCheckToken);
        e eVar = new e(this, i2, i);
        m.g(obj13).addOnSuccessListener(this.executorService, bVar).addOnFailureListener(this.executorService, eVar);
    }

    private long nextRequestNumber() {
        final long requestCounter = this.requestCounter;
        this.requestCounter = i += requestCounter;
        return requestCounter;
    }

    private void onAppCheckRevoked(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("App check token revoked: ");
        stringBuilder.append(string);
        stringBuilder.append(" (");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        this.logger.debug(stringBuilder.toString(), new Object[0]);
        this.appCheckToken = 0;
        this.forceAppCheckTokenRefresh = true;
    }

    private void onAuthRevoked(String string, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Auth token revoked: ");
        stringBuilder.append(string);
        stringBuilder.append(" (");
        stringBuilder.append(string2);
        stringBuilder.append(")");
        final int obj5 = 0;
        this.logger.debug(stringBuilder.toString(), new Object[obj5]);
        this.authToken = 0;
        this.forceAuthTokenRefresh = true;
        this.delegate.onConnectionStatus(obj5);
        this.realtime.close();
    }

    private void onDataPush(String string, Map<String, Object> map2) {
        boolean logsDebug;
        boolean equals;
        int stringToPath4;
        String string2;
        boolean equals2;
        List stringToPath3;
        Object[] arr;
        String arrayList;
        String next;
        String str;
        List stringToPath2;
        com.google.firebase.database.connection.RangeMerge rangeMerge;
        int stringToPath;
        Object obj11;
        boolean obj12;
        stringToPath4 = 0;
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("handleServerMessage: ");
            stringBuilder3.append(string);
            stringBuilder3.append(" ");
            stringBuilder3.append(map2);
            this.logger.debug(stringBuilder3.toString(), new Object[stringToPath4]);
        }
        equals = "d";
        arrayList = "t";
        next = "p";
        final String str10 = "m";
        if (!string.equals(equals)) {
            if (string.equals(str10)) {
                obj11 = string.equals(str10);
                stringToPath3 = map2.get(next);
                equals = map2.get(equals);
                if (obj11 != null && equals instanceof Map != null && (Map)equals.size() == 0) {
                    if (equals instanceof Map != null) {
                        if ((Map)equals.size() == 0) {
                            if (this.logger.logsDebug()) {
                                obj12 = new StringBuilder();
                                obj12.append("ignoring empty merge for path ");
                                obj12.append((String)stringToPath3);
                                this.logger.debug(obj12.toString(), new Object[stringToPath4]);
                            }
                        } else {
                            this.delegate.onDataUpdate(ConnectionUtils.stringToPath(stringToPath3), equals, obj11, ConnectionUtils.longFromObject(map2.get(arrayList)));
                        }
                    } else {
                    }
                } else {
                }
            } else {
                str = "s";
                if (string.equals("rm")) {
                    obj11 = map2.get(next);
                    arrayList = new ArrayList();
                    Iterator iterator = (List)map2.get(equals).iterator();
                    while (iterator.hasNext()) {
                        Object next2 = iterator.next();
                        Object obj3 = (Map)next2.get(str);
                        Object obj4 = next2.get("e");
                        if ((String)obj3 != null) {
                        } else {
                        }
                        stringToPath2 = stringToPath;
                        if ((String)obj4 != null) {
                        }
                        rangeMerge = new RangeMerge(stringToPath2, stringToPath, next2.get(str10));
                        arrayList.add(rangeMerge);
                        stringToPath = ConnectionUtils.stringToPath((String)obj4);
                        stringToPath2 = ConnectionUtils.stringToPath((String)obj3);
                    }
                    if (arrayList.isEmpty()) {
                        if (this.logger.logsDebug()) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Ignoring empty range merge for path ");
                            stringBuilder.append(obj11);
                            this.logger.debug(stringBuilder.toString(), new Object[stringToPath4]);
                        }
                    } else {
                        this.delegate.onRangeMergeUpdate(ConnectionUtils.stringToPath((String)obj11), arrayList, ConnectionUtils.longFromObject(map2.get(arrayList)));
                    }
                } else {
                    if (string.equals("c")) {
                        onListenRevoked(ConnectionUtils.stringToPath((String)map2.get(next)));
                    } else {
                        if (string.equals("ac")) {
                            onAuthRevoked((String)map2.get(str), (String)map2.get(equals));
                        } else {
                            if (string.equals("apc")) {
                                onAppCheckRevoked((String)map2.get(str), (String)map2.get(equals));
                            } else {
                                if (string.equals("sd")) {
                                    onSecurityDebugPacket(map2);
                                } else {
                                    if (this.logger.logsDebug()) {
                                        StringBuilder stringBuilder2 = new StringBuilder();
                                        stringBuilder2.append("Unrecognized action from server: ");
                                        stringBuilder2.append(string);
                                        this.logger.debug(stringBuilder2.toString(), new Object[stringToPath4]);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
        }
    }

    private void onListenRevoked(List<String> list) {
        com.google.firebase.database.connection.RequestResultCallback next;
        int i;
        String str;
        Object obj4;
        obj4 = removeListens(list);
        if (obj4 != null) {
            obj4 = obj4.iterator();
            for (PersistentConnectionImpl.OutstandingListen next2 : obj4) {
                PersistentConnectionImpl.OutstandingListen.access$800(next2).onRequestResult("permission_denied", 0);
            }
        }
    }

    private void onSecurityDebugPacket(Map<String, Object> map) {
        this.logger.info((String)map.get("msg"));
    }

    private void putInternal(String string, List<String> list2, Object object3, String string4, com.google.firebase.database.connection.RequestResultCallback requestResultCallback5) {
        final long obj7 = this.writeCounter;
        this.writeCounter = i += obj7;
        PersistentConnectionImpl.OutstandingPut outstandingPut = new PersistentConnectionImpl.OutstandingPut(string, getPutObject(list2, object3, string4), requestResultCallback5, 0);
        this.outstandingPuts.put(Long.valueOf(obj7), outstandingPut);
        if (canSendWrites()) {
            sendPut(obj7);
        }
        this.lastWriteTimestamp = System.currentTimeMillis();
        doIdleCheck();
    }

    private com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingListen removeListen(com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec persistentConnectionImpl$QuerySpec) {
        boolean logsDebug;
        boolean logsDebug2;
        int arr;
        String stringBuilder;
        Object[] arr2;
        Object obj5;
        arr = 0;
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("removing query ");
            stringBuilder2.append(querySpec);
            this.logger.debug(stringBuilder2.toString(), new Object[arr]);
        }
        if (!this.listens.containsKey(querySpec) && this.logger.logsDebug()) {
            if (this.logger.logsDebug()) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Trying to remove listener for QuerySpec ");
                stringBuilder.append(querySpec);
                stringBuilder.append(" but no listener exists.");
                this.logger.debug(stringBuilder.toString(), new Object[arr]);
            }
            return null;
        }
        this.listens.remove(querySpec);
        doIdleCheck();
        return (PersistentConnectionImpl.OutstandingListen)this.listens.get(querySpec);
    }

    private Collection<com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingListen> removeListens(List<String> list) {
        boolean logsDebug;
        String string;
        Iterator iterator;
        Object[] value;
        boolean listens;
        boolean equals;
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("removing all listens at path ");
            stringBuilder.append(list);
            this.logger.debug(stringBuilder.toString(), new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        iterator = this.listens.entrySet().iterator();
        while (iterator.hasNext()) {
            Object next3 = iterator.next();
            if (PersistentConnectionImpl.QuerySpec.access$100((PersistentConnectionImpl.QuerySpec)(Map.Entry)next3.getKey()).equals(list)) {
            }
            arrayList.add((PersistentConnectionImpl.OutstandingListen)next3.getValue());
        }
        final Iterator obj5 = arrayList.iterator();
        for (PersistentConnectionImpl.OutstandingListen next2 : obj5) {
            this.listens.remove(next2.getQuery());
        }
        doIdleCheck();
        return arrayList;
    }

    private void restoreState() {
        boolean logsDebug;
        boolean logsDebug2;
        boolean logsDebug3;
        int next;
        boolean next3;
        Set longValue;
        boolean onComplete;
        boolean next2;
        Set keySet;
        Object[] logsDebug4;
        String string;
        Object[] data;
        com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionState connectionState = this.connectionState;
        int i = 1;
        final int i2 = 0;
        next = connectionState == PersistentConnectionImpl.ConnectionState.Connected ? i : i2;
        logsDebug4 = new Object[i];
        logsDebug4[i2] = connectionState;
        ConnectionUtils.hardAssert(next, "Should be connected if we're restoring state, but we are: %s", logsDebug4);
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring outstanding listens", new Object[i2]);
        }
        Iterator iterator = this.listens.values().iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (this.logger.logsDebug()) {
            }
            sendListen((PersistentConnectionImpl.OutstandingListen)next);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Restoring listen ");
            stringBuilder.append(next.getQuery());
            this.logger.debug(stringBuilder.toString(), new Object[i2]);
        }
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring writes.", new Object[i2]);
        }
        ArrayList arrayList = new ArrayList(this.outstandingPuts.keySet());
        Collections.sort(arrayList);
        Iterator iterator2 = arrayList.iterator();
        for (Long next4 : iterator2) {
            sendPut(next4.longValue());
        }
        Iterator iterator3 = this.onDisconnectRequestQueue.iterator();
        for (PersistentConnectionImpl.OutstandingDisconnect next5 : iterator3) {
            sendOnDisconnect(next5.getAction(), next5.getPath(), next5.getData(), next5.getOnComplete());
        }
        this.onDisconnectRequestQueue.clear();
        if (this.logger.logsDebug()) {
            this.logger.debug("Restoring reads.", new Object[i2]);
        }
        ArrayList arrayList2 = new ArrayList(this.outstandingGets.keySet());
        Collections.sort(arrayList2);
        Iterator iterator4 = arrayList2.iterator();
        for (Long keySet : iterator4) {
            sendGet(keySet);
        }
    }

    private void restoreTokens() {
        boolean logsDebug;
        boolean logsDebug3;
        boolean logsDebug2;
        com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionState authenticating;
        int arr;
        Object[] arr2;
        int str;
        String str2;
        arr = 0;
        if (this.logger.logsDebug()) {
            this.logger.debug("calling restore tokens", new Object[arr]);
        }
        com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionState connectionState = this.connectionState;
        int i = 1;
        str = connectionState == PersistentConnectionImpl.ConnectionState.Connecting ? i : arr;
        final Object[] arr3 = new Object[i];
        arr3[arr] = connectionState;
        ConnectionUtils.hardAssert(str, "Wanted to restore tokens, but was in wrong state: %s", arr3);
        if (this.authToken != null) {
            if (this.logger.logsDebug()) {
                this.logger.debug("Restoring auth.", new Object[arr]);
            }
            this.connectionState = PersistentConnectionImpl.ConnectionState.Authenticating;
            sendAuthAndRestoreState();
        } else {
            if (this.logger.logsDebug()) {
                this.logger.debug("Not restoring auth because auth token is null.", new Object[arr]);
            }
            this.connectionState = PersistentConnectionImpl.ConnectionState.Connected;
            sendAppCheckTokenHelper(i);
        }
    }

    private void sendAction(String string, Map<String, Object> map2, com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback persistentConnectionImpl$ConnectionRequestCallback3) {
        sendSensitive(string, false, map2, connectionRequestCallback3);
    }

    private void sendAppCheckTokenHelper(boolean z) {
        boolean logsDebug;
        Object[] arr;
        int i;
        String str;
        if (this.appCheckToken == null) {
            restoreState();
        }
        final int i2 = 1;
        arr = new Object[i2];
        int i3 = 0;
        arr[i3] = this.connectionState;
        ConnectionUtils.hardAssert(connected(), "Must be connected to send auth, but was: %s", arr);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending app check.", new Object[i3]);
        }
        c cVar = new c(this, z);
        HashMap obj6 = new HashMap();
        i = this.appCheckToken != null ? i2 : i3;
        ConnectionUtils.hardAssert(i, "App check token must be set!", new Object[i3]);
        obj6.put("token", this.appCheckToken);
        sendSensitive("appcheck", i2, obj6, cVar);
    }

    private void sendAuthAndRestoreState() {
        sendAuthHelper(true);
    }

    private void sendAuthHelper(boolean z) {
        boolean logsDebug;
        Object[] arr;
        String str;
        Object tryParseFromString;
        String str2;
        Object auth;
        String token;
        final int i = 1;
        arr = new Object[i];
        token = 0;
        arr[token] = this.connectionState;
        ConnectionUtils.hardAssert(connected(), "Must be connected to send auth, but was: %s", arr);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending auth.", new Object[token]);
        }
        PersistentConnectionImpl.4 anon = new PersistentConnectionImpl.4(this, z);
        HashMap obj6 = new HashMap();
        tryParseFromString = GAuthToken.tryParseFromString(this.authToken);
        auth = "cred";
        if (tryParseFromString != null) {
            obj6.put(auth, tryParseFromString.getToken());
            if (tryParseFromString.getAuth() != null) {
                obj6.put("authvar", tryParseFromString.getAuth());
            }
            sendSensitive("gauth", i, obj6, anon);
        } else {
            obj6.put(auth, this.authToken);
            sendSensitive("auth", i, obj6, anon);
        }
    }

    private void sendConnectStats() {
        boolean persistenceEnabled;
        boolean logsDebug;
        Integer valueOf;
        String replace;
        HashMap hashMap = new HashMap();
        valueOf = 1;
        if (this.context.isPersistenceEnabled()) {
            hashMap.put("persistence.android.enabled", valueOf);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sdk.android.");
        stringBuilder.append(this.context.getClientSdkVersion().replace('.', '-'));
        hashMap.put(stringBuilder.toString(), valueOf);
        if (this.logger.logsDebug()) {
            this.logger.debug("Sending first connection stats", new Object[0]);
        }
        sendStats(hashMap);
    }

    private void sendGet(Long long) {
        boolean logsDebug;
        int i = 0;
        ConnectionUtils.hardAssert(canSendReads(), "sendGet called when we can't send gets", new Object[i]);
        Object obj = this.outstandingGets.get(long);
        if (!PersistentConnectionImpl.OutstandingGet.access$2100((PersistentConnectionImpl.OutstandingGet)obj) && this.logger.logsDebug()) {
            if (this.logger.logsDebug()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("get");
                stringBuilder.append(long);
                stringBuilder.append(" cancelled, ignoring.");
                this.logger.debug(stringBuilder.toString(), new Object[i]);
            }
        }
        PersistentConnectionImpl.6 anon = new PersistentConnectionImpl.6(this, long, obj);
        sendAction("g", PersistentConnectionImpl.OutstandingGet.access$2200(obj), anon);
    }

    private void sendListen(com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingListen persistentConnectionImpl$OutstandingListen) {
        Object hashFunction;
        String str;
        boolean includeCompoundHash;
        Object hashMap;
        String pathToString;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("p", ConnectionUtils.pathToString(PersistentConnectionImpl.QuerySpec.access$100(outstandingListen.getQuery())));
        Long tag = outstandingListen.getTag();
        String str4 = "q";
        if (tag != null) {
            hashMap2.put(str4, PersistentConnectionImpl.QuerySpec.access$200(PersistentConnectionImpl.OutstandingListen.access$700(outstandingListen)));
            hashMap2.put("t", tag);
        }
        hashFunction = outstandingListen.getHashFunction();
        hashMap2.put("h", hashFunction.getSimpleHash());
        if (hashFunction.shouldIncludeCompoundHash()) {
            com.google.firebase.database.connection.CompoundHash compoundHash = hashFunction.getCompoundHash();
            includeCompoundHash = new ArrayList();
            Iterator iterator = compoundHash.getPosts().iterator();
            for (List next2 : iterator) {
                includeCompoundHash.add(ConnectionUtils.pathToString(next2));
            }
            hashMap = new HashMap();
            hashMap.put("hs", compoundHash.getHashes());
            hashMap.put("ps", includeCompoundHash);
            hashMap2.put("ch", hashMap);
        }
        PersistentConnectionImpl.7 anon = new PersistentConnectionImpl.7(this, outstandingListen);
        sendAction(str4, hashMap2, anon);
    }

    private void sendOnDisconnect(String string, List<String> list2, Object object3, com.google.firebase.database.connection.RequestResultCallback requestResultCallback4) {
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(list2));
        hashMap.put("d", object3);
        PersistentConnectionImpl.3 obj4 = new PersistentConnectionImpl.3(this, requestResultCallback4);
        sendAction(string, hashMap, obj4);
    }

    private void sendPut(long l) {
        ConnectionUtils.hardAssert(canSendWrites(), "sendPut called when we can't send writes (we're disconnected or writes are paused).", new Object[0]);
        final Object obj3 = obj;
        String action = obj3.getAction();
        obj3.markSent();
        super(this, action, l, obj5, obj3, (PersistentConnectionImpl.OutstandingPut)obj3.getOnComplete());
        sendAction(action, obj3.getRequest(), anon);
    }

    private void sendSensitive(String string, boolean z2, Map<String, Object> map3, com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionRequestCallback persistentConnectionImpl$ConnectionRequestCallback4) {
        final long nextRequestNumber = nextRequestNumber();
        HashMap hashMap = new HashMap();
        hashMap.put("r", Long.valueOf(nextRequestNumber));
        hashMap.put("a", string);
        hashMap.put("b", map3);
        this.realtime.sendRequest(hashMap, z2);
        this.requestCBHash.put(Long.valueOf(nextRequestNumber), connectionRequestCallback4);
    }

    private void sendStats(Map<String, Integer> map) {
        HashMap hashMap;
        String str;
        com.google.firebase.database.connection.PersistentConnectionImpl.8 obj3;
        if (!map.isEmpty()) {
            hashMap = new HashMap();
            hashMap.put("c", map);
            obj3 = new PersistentConnectionImpl.8(this);
            sendAction("s", hashMap, obj3);
        } else {
            if (this.logger.logsDebug()) {
                this.logger.debug("Not sending stats because stats are empty", new Object[0]);
            }
        }
    }

    private void sendUnAppCheck() {
        int i;
        int i2 = 0;
        ConnectionUtils.hardAssert(connected(), "Must be connected to send unauth.", new Object[i2]);
        i = this.appCheckToken == null ? 1 : i2;
        ConnectionUtils.hardAssert(i, "App check token must not be set.", new Object[i2]);
        sendAction("unappcheck", Collections.emptyMap(), 0);
    }

    private void sendUnauth() {
        int i;
        int i2 = 0;
        ConnectionUtils.hardAssert(connected(), "Must be connected to send unauth.", new Object[i2]);
        i = this.authToken == null ? 1 : i2;
        ConnectionUtils.hardAssert(i, "Auth token must not be set.", new Object[i2]);
        sendAction("unauth", Collections.emptyMap(), 0);
    }

    private void sendUnlisten(com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingListen persistentConnectionImpl$OutstandingListen) {
        String str;
        Object obj4;
        HashMap hashMap = new HashMap();
        hashMap.put("p", ConnectionUtils.pathToString(PersistentConnectionImpl.QuerySpec.access$100(PersistentConnectionImpl.OutstandingListen.access$700(outstandingListen))));
        Long tag = outstandingListen.getTag();
        if (tag != null) {
            hashMap.put("q", PersistentConnectionImpl.QuerySpec.access$200(outstandingListen.getQuery()));
            hashMap.put("t", tag);
        }
        sendAction("n", hashMap, 0);
    }

    private void tryScheduleReconnect() {
        boolean forceAuthTokenRefresh;
        int i;
        boolean forceAppCheckTokenRefresh;
        RetryHelper retryHelper;
        com.google.firebase.database.connection.d dVar;
        Object[] arr;
        String str;
        if (shouldReconnect()) {
            com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionState connectionState = this.connectionState;
            int i2 = 1;
            int i3 = 0;
            i = connectionState == PersistentConnectionImpl.ConnectionState.Disconnected ? i2 : i3;
            Object[] arr2 = new Object[i2];
            arr2[i3] = connectionState;
            ConnectionUtils.hardAssert(i, "Not in disconnected state: %s", arr2);
            this.logger.debug("Scheduling connection attempt", new Object[i3]);
            this.forceAuthTokenRefresh = i3;
            this.forceAppCheckTokenRefresh = i3;
            dVar = new d(this, this.forceAuthTokenRefresh, this.forceAppCheckTokenRefresh);
            this.retryHelper.retry(dVar);
        }
    }

    private void upgradeAppCheck() {
        sendAppCheckTokenHelper(false);
    }

    private void upgradeAuth() {
        sendAuthHelper(false);
    }

    private void warnOnListenerWarnings(List<String> list, com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec persistentConnectionImpl$QuerySpec2) {
        Object logger;
        StringBuilder stringBuilder;
        String str;
        boolean obj4;
        if (list.contains("no_index")) {
            obj4 = new StringBuilder();
            obj4.append("\".indexOn\": \"");
            obj4.append(PersistentConnectionImpl.QuerySpec.access$200(querySpec2).get("i"));
            obj4.append('"');
            stringBuilder = new StringBuilder();
            stringBuilder.append("Using an unspecified index. Your data will be downloaded and filtered on the client. Consider adding '");
            stringBuilder.append(obj4.toString());
            stringBuilder.append("' at ");
            stringBuilder.append(ConnectionUtils.pathToString(PersistentConnectionImpl.QuerySpec.access$100(querySpec2)));
            stringBuilder.append(" to your security and Firebase Database rules for better performance");
            this.logger.warn(stringBuilder.toString());
        }
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void b(com.google.firebase.database.connection.PersistentConnectionImpl.QuerySpec persistentConnectionImpl$QuerySpec, k k2, Map map3) {
        a(querySpec, k2, map3);
    }

    public void compareAndPut(List<String> list, Object object2, String string3, com.google.firebase.database.connection.RequestResultCallback requestResultCallback4) {
        this.putInternal("p", list, object2, string3, requestResultCallback4);
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void d(com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingGet persistentConnectionImpl$OutstandingGet, long l2, k k3) {
        c(outstandingGet, l2, k3);
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void f(boolean z, Map map2) {
        e(z, map2);
    }

    public j<Object> get(List<String> list, Map<String, Object> map2) {
        Object valueOf;
        com.google.firebase.database.connection.f fVar;
        int i;
        Object outstandingGet;
        long l;
        k kVar;
        boolean obj11;
        PersistentConnectionImpl.QuerySpec querySpec = new PersistentConnectionImpl.QuerySpec(list, map2);
        k obj10 = new k();
        final long readCounter = this.readCounter;
        this.readCounter = i2 += readCounter;
        obj11 = new HashMap();
        obj11.put("p", ConnectionUtils.pathToString(PersistentConnectionImpl.QuerySpec.access$100(querySpec)));
        obj11.put("q", PersistentConnectionImpl.QuerySpec.access$200(querySpec));
        fVar = new f(this, querySpec, obj10);
        outstandingGet = new PersistentConnectionImpl.OutstandingGet("g", obj11, fVar, 0);
        this.outstandingGets.put(Long.valueOf(readCounter), outstandingGet);
        if (!connected()) {
            i = this;
            super(i, outstandingGet, readCounter, obj5, obj10);
            this.executorService.schedule(valueOf, 3000, i);
        }
        if (canSendReads()) {
            sendGet(Long.valueOf(readCounter));
        }
        doIdleCheck();
        return obj10.a();
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void h(long l, j j2, j j3, Void void4) {
        g(l, j2, j3, void4);
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void initialize() {
        tryScheduleReconnect();
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void injectConnectionFailure() {
        final com.google.firebase.database.connection.Connection realtime = this.realtime;
        if (realtime != null) {
            realtime.injectConnectionFailure();
        }
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void interrupt(String string) {
        boolean logsDebug;
        String string2;
        Object[] arr;
        int obj4;
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Connection interrupted for: ");
            stringBuilder.append(string);
            this.logger.debug(stringBuilder.toString(), new Object[0]);
        }
        this.interruptReasons.add(string);
        obj4 = this.realtime;
        if (obj4 != null) {
            obj4.close();
            this.realtime = 0;
        } else {
            this.retryHelper.cancel();
            this.connectionState = PersistentConnectionImpl.ConnectionState.Disconnected;
        }
        this.retryHelper.signalSuccess();
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public boolean isInterrupted(String string) {
        return this.interruptReasons.contains(string);
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void j(long l, Exception exception2) {
        i(l, exception2);
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void l(boolean z, boolean z2) {
        k(z, z2);
    }

    public void listen(List<String> list, Map<String, Object> map2, com.google.firebase.database.connection.ListenHashProvider listenHashProvider3, Long long4, com.google.firebase.database.connection.RequestResultCallback requestResultCallback5) {
        String string;
        Object[] string2;
        Object[] arr;
        String str;
        boolean obj8;
        int obj9;
        PersistentConnectionImpl.QuerySpec querySpec = new PersistentConnectionImpl.QuerySpec(list, map2);
        obj9 = 0;
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Listening on ");
            stringBuilder.append(querySpec);
            this.logger.debug(stringBuilder.toString(), new Object[obj9]);
        }
        ConnectionUtils.hardAssert(obj8 ^= 1, "listen() called twice for same QuerySpec.", new Object[obj9]);
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Adding listen query: ");
            stringBuilder2.append(querySpec);
            this.logger.debug(stringBuilder2.toString(), new Object[obj9]);
        }
        super(requestResultCallback5, querySpec, long4, listenHashProvider3, 0);
        this.listens.put(querySpec, obj8);
        if (connected()) {
            sendListen(obj8);
        }
        doIdleCheck();
    }

    public void merge(List<String> list, Map<String, Object> map2, com.google.firebase.database.connection.RequestResultCallback requestResultCallback3) {
        this.putInternal("m", list, map2, 0, requestResultCallback3);
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void onCacheHost(String string) {
        this.cachedHost = string;
    }

    public void onDataMessage(Map<String, Object> map) {
        boolean logsDebug;
        boolean key;
        String str;
        Map requestCBHash;
        Object obj5;
        String str2 = "r";
        key = map.containsKey(str2);
        str = "b";
        if (key != null) {
            logsDebug = this.requestCBHash.remove(Long.valueOf((long)intValue));
            if ((PersistentConnectionImpl.ConnectionRequestCallback)logsDebug != null) {
                (PersistentConnectionImpl.ConnectionRequestCallback)logsDebug.onResponse((Map)map.get(str));
            }
        } else {
            if (map.containsKey("error")) {
            } else {
                String str4 = "a";
                if (map.containsKey(str4)) {
                    onDataPush((String)map.get(str4), (Map)map.get(str));
                } else {
                    if (this.logger.logsDebug()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Ignoring unknown message: ");
                        stringBuilder.append(map);
                        this.logger.debug(stringBuilder.toString(), new Object[0]);
                    }
                }
            }
        }
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void onDisconnect(com.google.firebase.database.connection.Connection.DisconnectReason connection$DisconnectReason) {
        boolean logsDebug;
        int cmp;
        boolean sERVER_RESET;
        int i;
        String string;
        Object[] arr;
        int i2;
        long lastConnectionEstablishedTime;
        Object obj9;
        i = 0;
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Got on disconnect due to ");
            stringBuilder.append(disconnectReason.name());
            this.logger.debug(stringBuilder.toString(), new Object[i]);
        }
        this.connectionState = PersistentConnectionImpl.ConnectionState.Disconnected;
        this.realtime = 0;
        this.hasOnDisconnects = i;
        this.requestCBHash.clear();
        cancelSentTransactions();
        int i4 = 0;
        lastConnectionEstablishedTime = this.lastConnectionEstablishedTime;
        if (shouldReconnect() && Long.compare(lastConnectionEstablishedTime, i4) > 0 && Long.compare(i2, lastConnectionEstablishedTime) > 0) {
            lastConnectionEstablishedTime = this.lastConnectionEstablishedTime;
            if (Long.compare(lastConnectionEstablishedTime, i4) > 0) {
                if (Long.compare(i2, lastConnectionEstablishedTime) > 0) {
                    i = cmp;
                }
            }
            if (disconnectReason != Connection.DisconnectReason.SERVER_RESET) {
                if (i != 0) {
                    this.retryHelper.signalSuccess();
                }
            } else {
            }
            tryScheduleReconnect();
        }
        this.lastConnectionEstablishedTime = i4;
        this.delegate.onDisconnect();
    }

    public void onDisconnectCancel(List<String> list, com.google.firebase.database.connection.RequestResultCallback requestResultCallback2) {
        int onDisconnectRequestQueue;
        Object str;
        String str2;
        List list2;
        int i;
        com.google.firebase.database.connection.RequestResultCallback request;
        int i2;
        com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingDisconnect outstandingDisconnect;
        if (canSendWrites()) {
            sendOnDisconnect("oc", list, 0, requestResultCallback2);
        } else {
            super("oc", list, 0, requestResultCallback2, 0);
            this.onDisconnectRequestQueue.add(outstandingDisconnect);
        }
        doIdleCheck();
    }

    public void onDisconnectMerge(List<String> list, Map<String, Object> map2, com.google.firebase.database.connection.RequestResultCallback requestResultCallback3) {
        Object onDisconnectRequestQueue;
        com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingDisconnect connection;
        String str;
        List list2;
        Object obj;
        com.google.firebase.database.connection.RequestResultCallback request;
        int i;
        com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingDisconnect outstandingDisconnect;
        this.hasOnDisconnects = true;
        if (canSendWrites()) {
            sendOnDisconnect("om", list, map2, requestResultCallback3);
        } else {
            super("om", list, map2, requestResultCallback3, 0);
            this.onDisconnectRequestQueue.add(outstandingDisconnect);
        }
        doIdleCheck();
    }

    public void onDisconnectPut(List<String> list, Object object2, com.google.firebase.database.connection.RequestResultCallback requestResultCallback3) {
        Object onDisconnectRequestQueue;
        com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingDisconnect connection;
        String str;
        List list2;
        Object obj;
        com.google.firebase.database.connection.RequestResultCallback request;
        int i;
        com.google.firebase.database.connection.PersistentConnectionImpl.OutstandingDisconnect outstandingDisconnect;
        this.hasOnDisconnects = true;
        if (canSendWrites()) {
            sendOnDisconnect("o", list, object2, requestResultCallback3);
        } else {
            super("o", list, object2, requestResultCallback3, 0);
            this.onDisconnectRequestQueue.add(outstandingDisconnect);
        }
        doIdleCheck();
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void onKill(String string) {
        boolean invalidAppCheckTokenCount;
        Object logger;
        int cmp;
        Object stringBuilder;
        String str;
        int i;
        Object obj6;
        invalidAppCheckTokenCount = this.invalidAppCheckTokenCount;
        i = 3;
        if (string.equals("Invalid appcheck token") && Long.compare(l, i) < 0) {
            invalidAppCheckTokenCount = this.invalidAppCheckTokenCount;
            i = 3;
            if (Long.compare(l, i) < 0) {
                this.invalidAppCheckTokenCount = invalidAppCheckTokenCount++;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Detected invalid AppCheck token. Reconnecting (");
                stringBuilder2.append(i -= l2);
                stringBuilder2.append(" attempts remaining)");
                this.logger.warn(stringBuilder2.toString());
            } else {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Firebase Database connection was forcefully killed by the server. Will not attempt reconnect. Reason: ");
                stringBuilder.append(string);
                this.logger.warn(stringBuilder.toString());
                interrupt("server_kill");
            }
        } else {
        }
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void onReady(long l, String string2) {
        boolean logsDebug;
        Object[] arr;
        String str;
        final int i = 0;
        if (this.logger.logsDebug()) {
            this.logger.debug("onReady", new Object[i]);
        }
        this.lastConnectionEstablishedTime = System.currentTimeMillis();
        handleTimestamp(l);
        if (this.firstConnection) {
            sendConnectStats();
        }
        restoreTokens();
        this.firstConnection = i;
        this.lastSessionId = obj7;
        this.delegate.onConnect();
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void openNetworkConnection(String string, String string2) {
        Object delegate;
        int i;
        com.google.firebase.database.connection.PersistentConnectionImpl.ConnectionState connectionState = this.connectionState;
        int i2 = 1;
        int i3 = 0;
        i = connectionState == PersistentConnectionImpl.ConnectionState.GettingToken ? i2 : i3;
        Object[] arr = new Object[i2];
        arr[i3] = connectionState;
        ConnectionUtils.hardAssert(i, "Trying to open network connection while in the wrong state: %s", arr);
        if (string == null) {
            this.delegate.onConnectionStatus(i3);
        }
        this.authToken = string;
        this.appCheckToken = string2;
        this.connectionState = PersistentConnectionImpl.ConnectionState.Connecting;
        super(this.context, this.hostInfo, this.cachedHost, this, this.lastSessionId, string2);
        this.realtime = obj8;
        obj8.open();
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void purgeOutstandingWrites() {
        boolean connected;
        Object next2;
        boolean next;
        int i;
        String str;
        com.google.firebase.database.connection.RequestResultCallback request;
        Iterator iterator = this.outstandingPuts.values().iterator();
        i = 0;
        str = "write_canceled";
        while (iterator.hasNext()) {
            next2 = iterator.next();
            if (PersistentConnectionImpl.OutstandingPut.access$400((PersistentConnectionImpl.OutstandingPut)next2) != null) {
            }
            i = 0;
            str = "write_canceled";
            PersistentConnectionImpl.OutstandingPut.access$400(next2).onRequestResult(str, i);
        }
        Iterator iterator2 = this.onDisconnectRequestQueue.iterator();
        while (iterator2.hasNext()) {
            next = iterator2.next();
            if (PersistentConnectionImpl.OutstandingDisconnect.access$500((PersistentConnectionImpl.OutstandingDisconnect)next) != null) {
            }
            PersistentConnectionImpl.OutstandingDisconnect.access$500(next).onRequestResult(str, i);
        }
        this.outstandingPuts.clear();
        this.onDisconnectRequestQueue.clear();
        if (!connected()) {
            this.hasOnDisconnects = false;
        }
        doIdleCheck();
    }

    public void put(List<String> list, Object object2, com.google.firebase.database.connection.RequestResultCallback requestResultCallback3) {
        this.putInternal("p", list, object2, 0, requestResultCallback3);
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void refreshAppCheckToken() {
        this.logger.debug("App check token refresh requested", new Object[0]);
        String str = "token_refresh";
        interrupt(str);
        resume(str);
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void refreshAppCheckToken(String string) {
        this.logger.debug("App check token refreshed.", new Object[0]);
        this.appCheckToken = string;
        if (connected()) {
            if (string != null) {
                upgradeAppCheck();
            } else {
                sendUnAppCheck();
            }
        }
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void refreshAuthToken() {
        this.logger.debug("Auth token refresh requested", new Object[0]);
        String str = "token_refresh";
        interrupt(str);
        resume(str);
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void refreshAuthToken(String string) {
        this.logger.debug("Auth token refreshed.", new Object[0]);
        this.authToken = string;
        if (connected()) {
            if (string != null) {
                upgradeAuth();
            } else {
                sendUnauth();
            }
        }
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void resume(String string) {
        boolean logsDebug;
        Object interruptReasons;
        String string2;
        Object[] arr;
        boolean obj4;
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Connection no longer interrupted for: ");
            stringBuilder.append(string);
            this.logger.debug(stringBuilder.toString(), new Object[0]);
        }
        this.interruptReasons.remove(string);
        if (shouldReconnect() && this.connectionState == PersistentConnectionImpl.ConnectionState.Disconnected) {
            if (this.connectionState == PersistentConnectionImpl.ConnectionState.Disconnected) {
                tryScheduleReconnect();
            }
        }
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    boolean shouldReconnect() {
        int i;
        i = this.interruptReasons.size() == 0 ? 1 : 0;
        return i;
    }

    @Override // com.google.firebase.database.connection.Connection$Delegate
    public void shutdown() {
        interrupt("shutdown");
    }

    public void unlisten(List<String> list, Map<String, Object> map2) {
        Object[] arr;
        boolean obj3;
        Object obj4;
        PersistentConnectionImpl.QuerySpec querySpec = new PersistentConnectionImpl.QuerySpec(list, map2);
        if (this.logger.logsDebug()) {
            obj4 = new StringBuilder();
            obj4.append("unlistening on ");
            obj4.append(querySpec);
            this.logger.debug(obj4.toString(), new Object[0]);
        }
        obj3 = removeListen(querySpec);
        if (obj3 != null && connected()) {
            if (connected()) {
                sendUnlisten(obj3);
            }
        }
        doIdleCheck();
    }
}
