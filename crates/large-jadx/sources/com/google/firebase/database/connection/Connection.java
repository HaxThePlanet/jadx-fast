package com.google.firebase.database.connection;

import com.google.firebase.database.logging.LogWrapper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
class Connection implements com.google.firebase.database.connection.WebsocketConnection.Delegate {

    private static final String REQUEST_PAYLOAD = "d";
    private static final String REQUEST_TYPE = "t";
    private static final String REQUEST_TYPE_DATA = "d";
    private static final String SERVER_CONTROL_MESSAGE = "c";
    private static final String SERVER_CONTROL_MESSAGE_DATA = "d";
    private static final String SERVER_CONTROL_MESSAGE_HELLO = "h";
    private static final String SERVER_CONTROL_MESSAGE_RESET = "r";
    private static final String SERVER_CONTROL_MESSAGE_SHUTDOWN = "s";
    private static final String SERVER_CONTROL_MESSAGE_TYPE = "t";
    private static final String SERVER_DATA_MESSAGE = "d";
    private static final String SERVER_ENVELOPE_DATA = "d";
    private static final String SERVER_ENVELOPE_TYPE = "t";
    private static final String SERVER_HELLO_HOST = "h";
    private static final String SERVER_HELLO_SESSION_ID = "s";
    private static final String SERVER_HELLO_TIMESTAMP = "ts";
    private static long connectionIds;
    private com.google.firebase.database.connection.WebsocketConnection conn;
    private com.google.firebase.database.connection.Connection.Delegate delegate;
    private com.google.firebase.database.connection.HostInfo hostInfo;
    private final LogWrapper logger;
    private com.google.firebase.database.connection.Connection.State state;

    public interface Delegate {
        public abstract void onCacheHost(String string);

        public abstract void onDataMessage(Map<String, Object> map);

        public abstract void onDisconnect(com.google.firebase.database.connection.Connection.DisconnectReason connection$DisconnectReason);

        public abstract void onKill(String string);

        public abstract void onReady(long l, String string2);
    }

    public static enum DisconnectReason {

        SERVER_RESET,
        OTHER;
    }

    private static enum State {

        REALTIME_CONNECTING,
        REALTIME_CONNECTED,
        REALTIME_DISCONNECTED;
    }
    static {
    }

    public Connection(com.google.firebase.database.connection.ConnectionContext connectionContext, com.google.firebase.database.connection.HostInfo hostInfo2, String string3, com.google.firebase.database.connection.Connection.Delegate connection$Delegate4, String string5, String string6) {
        super();
        long connectionIds = Connection.connectionIds;
        Connection.connectionIds = i += connectionIds;
        this.hostInfo = hostInfo2;
        this.delegate = delegate4;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("conn_");
        stringBuilder.append(connectionIds);
        LogWrapper obj11 = new LogWrapper(connectionContext.getLogger(), "Connection", stringBuilder.toString());
        this.logger = obj11;
        this.state = Connection.State.REALTIME_CONNECTING;
        super(connectionContext, hostInfo2, string3, string6, this, string5);
        this.conn = obj11;
    }

    private void onConnectionReady(long l, String string2) {
        boolean logsDebug;
        Object[] arr;
        String str;
        if (this.logger.logsDebug()) {
            this.logger.debug("realtime connection established", new Object[0]);
        }
        this.state = Connection.State.REALTIME_CONNECTED;
        this.delegate.onReady(l, string2);
    }

    private void onConnectionShutdown(String string) {
        boolean logsDebug;
        Object[] arr;
        String str;
        if (this.logger.logsDebug()) {
            this.logger.debug("Connection shutdown command received. Shutting down...", new Object[0]);
        }
        this.delegate.onKill(string);
        close();
    }

    private void onControlMessage(Map<String, Object> map) {
        boolean logsDebug;
        boolean logsDebug2;
        int arr;
        int i;
        StringBuilder stringBuilder;
        String str;
        Object obj5;
        i = 0;
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Got control message: ");
            stringBuilder2.append(map.toString());
            this.logger.debug(stringBuilder2.toString(), new Object[i]);
        }
        logsDebug2 = map.get("t");
        if ((String)logsDebug2 != null) {
            str = "d";
            if ((String)logsDebug2.equals("s")) {
                onConnectionShutdown((String)map.get(str));
            } else {
                if (logsDebug2.equals("r")) {
                    onReset((String)map.get(str));
                } else {
                    if (logsDebug2.equals("h")) {
                        onHandshake((Map)map.get(str));
                    } else {
                        if (this.logger.logsDebug()) {
                            StringBuilder stringBuilder4 = new StringBuilder();
                            stringBuilder4.append("Ignoring unknown control message: ");
                            stringBuilder4.append(logsDebug2);
                            this.logger.debug(stringBuilder4.toString(), new Object[i]);
                        }
                    }
                }
            }
        } else {
            if (this.logger.logsDebug()) {
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Got invalid control message: ");
                stringBuilder3.append(map.toString());
                this.logger.debug(stringBuilder3.toString(), new Object[i]);
            }
            close();
        }
    }

    private void onDataMessage(Map<String, Object> map) {
        boolean logsDebug;
        String string;
        Object[] arr;
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("received data message: ");
            stringBuilder.append(map.toString());
            this.logger.debug(stringBuilder.toString(), new Object[0]);
        }
        this.delegate.onDataMessage(map);
    }

    private void onHandshake(Map<String, Object> map) {
        Object state;
        this.delegate.onCacheHost((String)map.get("h"));
        if (this.state == Connection.State.REALTIME_CONNECTING) {
            this.conn.start();
            onConnectionReady((Long)map.get("ts").longValue(), obj1);
        }
    }

    private void onReset(String string) {
        boolean logsDebug;
        String string2;
        Object[] arr;
        if (this.logger.logsDebug()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Got a reset; killing connection to ");
            stringBuilder.append(this.hostInfo.getHost());
            stringBuilder.append("; Updating internalHost to ");
            stringBuilder.append(string);
            this.logger.debug(stringBuilder.toString(), new Object[0]);
        }
        this.delegate.onCacheHost(string);
        close(Connection.DisconnectReason.SERVER_RESET);
    }

    private void sendData(Map<String, Object> map, boolean z2) {
        String str;
        Object rEALTIME_CONNECTED;
        Object obj4;
        Object[] obj5;
        final int i2 = 0;
        if (this.state != Connection.State.REALTIME_CONNECTED) {
            this.logger.debug("Tried to send on an unconnected connection", new Object[i2]);
        } else {
            if (z2) {
                this.logger.debug("Sending data (contents hidden)", new Object[i2]);
            } else {
                str = new Object[1];
                str[i2] = map;
                this.logger.debug("Sending data: %s", str);
            }
            this.conn.send(map);
        }
    }

    @Override // com.google.firebase.database.connection.WebsocketConnection$Delegate
    public void close() {
        close(Connection.DisconnectReason.OTHER);
    }

    @Override // com.google.firebase.database.connection.WebsocketConnection$Delegate
    public void close(com.google.firebase.database.connection.Connection.DisconnectReason connection$DisconnectReason) {
        boolean logsDebug;
        com.google.firebase.database.connection.WebsocketConnection conn;
        Object delegate;
        Object[] arr;
        String str;
        final com.google.firebase.database.connection.Connection.State rEALTIME_DISCONNECTED = Connection.State.REALTIME_DISCONNECTED;
        if (this.state != rEALTIME_DISCONNECTED && this.logger.logsDebug()) {
            if (this.logger.logsDebug()) {
                this.logger.debug("closing realtime connection", new Object[0]);
            }
            this.state = rEALTIME_DISCONNECTED;
            conn = this.conn;
            if (conn != null) {
                conn.close();
                this.conn = 0;
            }
            this.delegate.onDisconnect(disconnectReason);
        }
    }

    @Override // com.google.firebase.database.connection.WebsocketConnection$Delegate
    public void injectConnectionFailure() {
        close();
    }

    @Override // com.google.firebase.database.connection.WebsocketConnection$Delegate
    public void onDisconnect(boolean z) {
        int arr;
        Object rEALTIME_CONNECTING;
        boolean obj3;
        this.conn = 0;
        arr = 0;
        if (z == null && this.state == Connection.State.REALTIME_CONNECTING) {
            if (this.state == Connection.State.REALTIME_CONNECTING) {
                if (this.logger.logsDebug()) {
                    this.logger.debug("Realtime connection failed", new Object[arr]);
                }
            } else {
                if (this.logger.logsDebug()) {
                    this.logger.debug("Realtime connection lost", new Object[arr]);
                }
            }
        } else {
        }
        close();
    }

    public void onMessage(Map<String, Object> map) {
        boolean logsDebug;
        int arr;
        int i;
        StringBuilder stringBuilder;
        Object arr2;
        String equals;
        Object obj5;
        logsDebug = "d";
        i = 0;
        arr2 = map.get("t");
        if ((String)arr2 != null) {
            if ((String)arr2.equals(logsDebug)) {
                onDataMessage((Map)map.get(logsDebug));
            } else {
                try {
                    if (arr2.equals("c")) {
                    } else {
                    }
                    onControlMessage((Map)map.get(logsDebug));
                    if (this.logger.logsDebug()) {
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Ignoring unknown server message type: ");
                    stringBuilder2.append(arr2);
                    this.logger.debug(stringBuilder2.toString(), new Object[i]);
                    if (this.logger.logsDebug()) {
                    }
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Failed to parse server message: missing message type:");
                    stringBuilder3.append(map.toString());
                    this.logger.debug(stringBuilder3.toString(), new Object[i]);
                    close();
                    LogWrapper logger = this.logger;
                    logger = logger.logsDebug();
                    if (logger != null) {
                    }
                    logger = this.logger;
                    stringBuilder = new StringBuilder();
                    stringBuilder.append("Failed to parse server message: ");
                    map = map.toString();
                    stringBuilder.append(map);
                    map = stringBuilder.toString();
                    arr = new Object[arr];
                    logger.debug(map, arr);
                    close();
                }
            }
        } else {
        }
    }

    @Override // com.google.firebase.database.connection.WebsocketConnection$Delegate
    public void open() {
        boolean logsDebug;
        Object[] arr;
        String str;
        if (this.logger.logsDebug()) {
            this.logger.debug("Opening a connection", new Object[0]);
        }
        this.conn.open();
    }

    public void sendRequest(Map<String, Object> map, boolean z2) {
        HashMap hashMap = new HashMap();
        final String str2 = "d";
        hashMap.put("t", str2);
        hashMap.put(str2, map);
        sendData(hashMap, z2);
    }
}
