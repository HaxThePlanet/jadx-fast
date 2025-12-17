package com.google.firebase.database.connection;

import com.google.firebase.database.connection.util.StringListReader;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.tubesock.WebSocket;
import com.google.firebase.database.tubesock.WebSocketEventHandler;
import com.google.firebase.database.tubesock.WebSocketException;
import com.google.firebase.database.tubesock.WebSocketMessage;
import com.google.firebase.database.util.JsonMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
class WebsocketConnection {

    private static final long CONNECT_TIMEOUT_MS = 30000L;
    private static final long KEEP_ALIVE_TIMEOUT_MS = 45000L;
    private static final int MAX_FRAME_SIZE = 16384;
    private static long connectionId;
    private com.google.firebase.database.connection.WebsocketConnection.WSClient conn;
    private ScheduledFuture<?> connectTimeout;
    private final com.google.firebase.database.connection.ConnectionContext connectionContext;
    private com.google.firebase.database.connection.WebsocketConnection.Delegate delegate;
    private boolean everConnected = false;
    private final ScheduledExecutorService executorService;
    private StringListReader frameReader;
    private boolean isClosed = false;
    private ScheduledFuture<?> keepAlive;
    private final LogWrapper logger;
    private long totalFrames = 0;

    public interface Delegate {
        public abstract void onDisconnect(boolean z);

        public abstract void onMessage(Map<String, Object> map);
    }

    private interface WSClient {
        public abstract void close();

        public abstract void connect();

        public abstract void send(String string);
    }

    private class WSClientTubesock implements com.google.firebase.database.connection.WebsocketConnection.WSClient, WebSocketEventHandler {

        final com.google.firebase.database.connection.WebsocketConnection this$0;
        private WebSocket ws;
        private WSClientTubesock(com.google.firebase.database.connection.WebsocketConnection websocketConnection, WebSocket webSocket2) {
            this.this$0 = websocketConnection;
            super();
            this.ws = webSocket2;
            webSocket2.setEventHandler(this);
        }

        WSClientTubesock(com.google.firebase.database.connection.WebsocketConnection websocketConnection, WebSocket webSocket2, com.google.firebase.database.connection.WebsocketConnection.1 websocketConnection$13) {
            super(websocketConnection, webSocket2);
        }

        private void shutdown() {
            WebSocket socket;
            com.google.firebase.database.connection.WebsocketConnection connection;
            String str;
            this.ws.close();
            this.ws.blockClose();
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection$WSClient
        public void close() {
            this.ws.close();
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection$WSClient
        public void connect() {
            WebSocket socket;
            com.google.firebase.database.connection.WebsocketConnection connection;
            int arr;
            String str;
            try {
                this.ws.connect();
                connection = this.this$0;
                connection = WebsocketConnection.access$200(connection);
                connection = connection.logsDebug();
                if (connection != null) {
                }
                connection = this.this$0;
                connection = WebsocketConnection.access$200(connection);
                arr = 0;
                arr = new Object[arr];
                connection.debug("Error connecting", th, arr);
                shutdown();
            }
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection$WSClient
        public void onClose() {
            WebsocketConnection.WSClientTubesock.3 anon = new WebsocketConnection.WSClientTubesock.3(this);
            WebsocketConnection.access$400(this.this$0).execute(anon);
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection$WSClient
        public void onError(WebSocketException webSocketException) {
            WebsocketConnection.WSClientTubesock.4 anon = new WebsocketConnection.WSClientTubesock.4(this, webSocketException);
            WebsocketConnection.access$400(this.this$0).execute(anon);
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection$WSClient
        public void onLogMessage(String string) {
            boolean logsDebug;
            Object[] arr;
            String str;
            String obj4;
            if (WebsocketConnection.access$200(this.this$0).logsDebug()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Tubesock: ");
                stringBuilder.append(string);
                WebsocketConnection.access$200(this.this$0).debug(stringBuilder.toString(), new Object[0]);
            }
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection$WSClient
        public void onMessage(WebSocketMessage webSocketMessage) {
            boolean logsDebug;
            String string;
            Object[] arr;
            final String obj4 = webSocketMessage.getText();
            if (WebsocketConnection.access$200(this.this$0).logsDebug()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("ws message: ");
                stringBuilder.append(obj4);
                WebsocketConnection.access$200(this.this$0).debug(stringBuilder.toString(), new Object[0]);
            }
            WebsocketConnection.WSClientTubesock.2 anon = new WebsocketConnection.WSClientTubesock.2(this, obj4);
            WebsocketConnection.access$400(this.this$0).execute(anon);
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection$WSClient
        public void onOpen() {
            WebsocketConnection.WSClientTubesock.1 anon = new WebsocketConnection.WSClientTubesock.1(this);
            WebsocketConnection.access$400(this.this$0).execute(anon);
        }

        @Override // com.google.firebase.database.connection.WebsocketConnection$WSClient
        public void send(String string) {
            this.ws.send(string);
        }
    }
    static {
    }

    public WebsocketConnection(com.google.firebase.database.connection.ConnectionContext connectionContext, com.google.firebase.database.connection.HostInfo hostInfo2, String string3, String string4, com.google.firebase.database.connection.WebsocketConnection.Delegate websocketConnection$Delegate5, String string6) {
        super();
        int i = 0;
        int i2 = 0;
        this.connectionContext = connectionContext;
        this.executorService = connectionContext.getExecutorService();
        this.delegate = delegate5;
        long connectionId = WebsocketConnection.connectionId;
        WebsocketConnection.connectionId = i3 += connectionId;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ws_");
        stringBuilder.append(connectionId);
        LogWrapper obj9 = new LogWrapper(connectionContext.getLogger(), "WebSocket", stringBuilder.toString());
        this.logger = obj9;
        this.conn = createConnection(hostInfo2, string3, string4, string6);
    }

    static ScheduledFuture access$000(com.google.firebase.database.connection.WebsocketConnection websocketConnection) {
        return websocketConnection.connectTimeout;
    }

    static boolean access$102(com.google.firebase.database.connection.WebsocketConnection websocketConnection, boolean z2) {
        websocketConnection.everConnected = z2;
        return z2;
    }

    static LogWrapper access$200(com.google.firebase.database.connection.WebsocketConnection websocketConnection) {
        return websocketConnection.logger;
    }

    static void access$300(com.google.firebase.database.connection.WebsocketConnection websocketConnection) {
        websocketConnection.resetKeepAlive();
    }

    static ScheduledExecutorService access$400(com.google.firebase.database.connection.WebsocketConnection websocketConnection) {
        return websocketConnection.executorService;
    }

    static void access$500(com.google.firebase.database.connection.WebsocketConnection websocketConnection, String string2) {
        websocketConnection.handleIncomingFrame(string2);
    }

    static void access$600(com.google.firebase.database.connection.WebsocketConnection websocketConnection) {
        websocketConnection.onClosed();
    }

    static void access$800(com.google.firebase.database.connection.WebsocketConnection websocketConnection) {
        websocketConnection.closeIfNeverConnected();
    }

    static com.google.firebase.database.connection.WebsocketConnection.WSClient access$900(com.google.firebase.database.connection.WebsocketConnection websocketConnection) {
        return websocketConnection.conn;
    }

    private void appendFrame(String string) {
        boolean logsDebug;
        int delegate;
        Object string2;
        int arr;
        int obj5;
        this.frameReader.addString(string);
        totalFrames -= i2;
        this.totalFrames = delegate;
        this.frameReader.freeze();
        obj5 = JsonMapper.parseJson(this.frameReader.toString());
        this.frameReader = 0;
        if (Long.compare(delegate, arr) == 0 && this.logger.logsDebug()) {
            this.frameReader.freeze();
            obj5 = JsonMapper.parseJson(this.frameReader.toString());
            this.frameReader = 0;
            if (this.logger.logsDebug()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("handleIncomingFrame complete frame: ");
                stringBuilder.append(obj5);
                this.logger.debug(stringBuilder.toString(), new Object[0]);
            }
            this.delegate.onMessage(obj5);
        }
    }

    private void closeIfNeverConnected() {
        boolean logsDebug;
        boolean everConnected;
        Object[] arr;
        String str;
        if (!this.everConnected && !this.isClosed && this.logger.logsDebug()) {
            if (!this.isClosed) {
                if (this.logger.logsDebug()) {
                    this.logger.debug("timed out on connect", new Object[0]);
                }
                this.conn.close();
            }
        }
    }

    private com.google.firebase.database.connection.WebsocketConnection.WSClient createConnection(com.google.firebase.database.connection.HostInfo hostInfo, String string2, String string3, String string4) {
        String obj3;
        if (string2 != null) {
        } else {
            obj3 = hostInfo.getHost();
        }
        obj3 = new HashMap();
        obj3.put("User-Agent", this.connectionContext.getUserAgent());
        obj3.put("X-Firebase-GMPID", this.connectionContext.getApplicationId());
        obj3.put("X-Firebase-AppCheck", string3);
        int i = 0;
        WebSocket obj4 = new WebSocket(this.connectionContext, HostInfo.getConnectionUrl(obj3, hostInfo.isSecure(), hostInfo.getNamespace(), string4), i, obj3);
        WebsocketConnection.WSClientTubesock obj2 = new WebsocketConnection.WSClientTubesock(this, obj4, i);
        return obj2;
    }

    private String extractFrameCount(String string) {
        int int = Integer.parseInt(string);
        if (string.length() <= 6 && int > 0) {
            int = Integer.parseInt(string);
            if (int > 0) {
                handleNewFrameCount(int);
            }
            return null;
        }
        handleNewFrameCount(1);
        return string;
    }

    private void handleIncomingFrame(String string) {
        boolean isClosed;
        String obj2;
        if (!this.isClosed) {
            resetKeepAlive();
            if (isBuffering()) {
                appendFrame(string);
            } else {
                obj2 = extractFrameCount(string);
                if (obj2 != null) {
                    appendFrame(obj2);
                }
            }
        }
    }

    private void handleNewFrameCount(int i) {
        long string;
        Object[] arr;
        boolean obj4;
        this.totalFrames = (long)i;
        obj4 = new StringListReader();
        this.frameReader = obj4;
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("HandleNewFrameCount: ");
            stringBuilder.append(this.totalFrames);
            this.logger.debug(stringBuilder.toString(), new Object[0]);
        }
    }

    private boolean isBuffering() {
        int i;
        i = this.frameReader != null ? 1 : 0;
        return i;
    }

    private Runnable nop() {
        WebsocketConnection.2 anon = new WebsocketConnection.2(this);
        return anon;
    }

    private void onClosed() {
        boolean logsDebug;
        Object[] arr;
        String str;
        final int i2 = 0;
        if (!this.isClosed && this.logger.logsDebug()) {
            if (this.logger.logsDebug()) {
                this.logger.debug("closing itself", new Object[i2]);
            }
            shutdown();
        }
        this.conn = 0;
        ScheduledFuture keepAlive = this.keepAlive;
        if (keepAlive != null) {
            keepAlive.cancel(i2);
        }
    }

    private void resetKeepAlive() {
        boolean isClosed;
        boolean logsDebug;
        Runnable runnable;
        int arr;
        String string;
        long delay;
        TimeUnit mILLISECONDS;
        if (!this.isClosed) {
            ScheduledFuture keepAlive = this.keepAlive;
            arr = 0;
            if (keepAlive != null) {
                keepAlive.cancel(arr);
                if (this.logger.logsDebug()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Reset keepAlive. Remaining: ");
                    mILLISECONDS = TimeUnit.MILLISECONDS;
                    stringBuilder.append(this.keepAlive.getDelay(mILLISECONDS));
                    this.logger.debug(stringBuilder.toString(), new Object[arr]);
                }
            } else {
                if (this.logger.logsDebug()) {
                    this.logger.debug("Reset keepAlive", new Object[arr]);
                }
            }
            this.keepAlive = this.executorService.schedule(nop(), 45000, delay);
        }
    }

    private void shutdown() {
        this.isClosed = true;
        this.delegate.onDisconnect(this.everConnected);
    }

    private static String[] splitIntoFrames(String string, int i2) {
        int i4;
        int i3;
        int i;
        if (string.length() <= i2) {
            String[] obj5 = new String[1];
            return obj5;
        }
        ArrayList arrayList = new ArrayList();
        while (i4 < string.length()) {
            i3 = i4 + i2;
            arrayList.add(string.substring(i4, Math.min(i3, string.length())));
            i4 = i3;
        }
        return (String[])arrayList.toArray(new String[arrayList.size()]);
    }

    public void close() {
        boolean logsDebug;
        Object[] arr;
        String str;
        if (this.logger.logsDebug()) {
            this.logger.debug("websocket is being closed", new Object[0]);
        }
        int i = 1;
        this.isClosed = i;
        this.conn.close();
        ScheduledFuture connectTimeout = this.connectTimeout;
        if (connectTimeout != null) {
            connectTimeout.cancel(i);
        }
        ScheduledFuture keepAlive = this.keepAlive;
        if (keepAlive != null) {
            keepAlive.cancel(i);
        }
    }

    public void open() {
        this.conn.connect();
        WebsocketConnection.1 anon = new WebsocketConnection.1(this);
        this.connectTimeout = this.executorService.schedule(anon, 30000, obj4);
    }

    public void send(Map<String, Object> map) {
        String[] splitIntoFrames;
        int length2;
        int i;
        int string;
        int length;
        int length3;
        Map obj5;
        resetKeepAlive();
        splitIntoFrames = WebsocketConnection.splitIntoFrames(JsonMapper.serializeJson(map), 16384);
        if (splitIntoFrames.length > 1) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("");
            stringBuilder2.append(splitIntoFrames.length);
            this.conn.send(stringBuilder2.toString());
        }
        i = 0;
        try {
            for (Object length3 : th) {
                this.conn.send(length3);
            }
            this.conn.send(splitIntoFrames[i]);
            i++;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to serialize message: ");
            map = map.toString();
            stringBuilder.append(map);
            map = stringBuilder.toString();
            this.logger.error(map, th);
            shutdown();
        }
    }

    public void start() {
    }
}
