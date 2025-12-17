package com.google.firebase.database.tubesock;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.logging.LogWrapper;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;

/* loaded from: classes2.dex */
public class WebSocket {

    static final byte OPCODE_BINARY = (byte) 2;
    static final byte OPCODE_CLOSE = (byte) 8;
    static final byte OPCODE_NONE = (byte) 0;
    static final byte OPCODE_PING = (byte) 9;
    static final byte OPCODE_PONG = (byte) 10;
    static final byte OPCODE_TEXT = (byte) 1;
    private static final int SSL_HANDSHAKE_TIMEOUT_MS = 60000;
    private static final String THREAD_BASE_NAME = "TubeSock";
    private static final Charset UTF8;
    private static final AtomicInteger clientCount;
    private static com.google.firebase.database.tubesock.ThreadInitializer intializer;
    private static ThreadFactory threadFactory;
    private final int clientId;
    private com.google.firebase.database.tubesock.WebSocketEventHandler eventHandler;
    private final com.google.firebase.database.tubesock.WebSocketHandshake handshake;
    private final Thread innerThread;
    private final LogWrapper logger;
    private final com.google.firebase.database.tubesock.WebSocketReceiver receiver;
    private volatile Socket socket;
    private final String sslCacheDirectory;
    private volatile com.google.firebase.database.tubesock.WebSocket.State state;
    private final URI url;
    private final com.google.firebase.database.tubesock.WebSocketWriter writer;

    private static enum State {

        NONE,
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED;
    }
    static {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        WebSocket.clientCount = atomicInteger;
        WebSocket.UTF8 = Charset.forName("UTF-8");
        WebSocket.threadFactory = Executors.defaultThreadFactory();
        WebSocket.1 anon = new WebSocket.1();
        WebSocket.intializer = anon;
    }

    public WebSocket(ConnectionContext connectionContext, URI uRI2) {
        super(connectionContext, uRI2, 0);
    }

    public WebSocket(ConnectionContext connectionContext, URI uRI2, String string3) {
        super(connectionContext, uRI2, string3, 0);
    }

    public WebSocket(ConnectionContext connectionContext, URI uRI2, String string3, Map<String, String> map4) {
        super();
        this.state = WebSocket.State.NONE;
        int i = 0;
        this.socket = i;
        this.eventHandler = i;
        int incrementAndGet = WebSocket.clientCount.incrementAndGet();
        this.clientId = incrementAndGet;
        WebSocket.2 anon = new WebSocket.2(this);
        this.innerThread = WebSocket.getThreadFactory().newThread(anon);
        this.url = uRI2;
        this.sslCacheDirectory = connectionContext.getSslCacheDirectory();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("sk_");
        stringBuilder.append(incrementAndGet);
        LogWrapper logWrapper = new LogWrapper(connectionContext.getLogger(), "WebSocket", stringBuilder.toString());
        this.logger = logWrapper;
        WebSocketHandshake obj5 = new WebSocketHandshake(uRI2, string3, map4);
        this.handshake = obj5;
        obj5 = new WebSocketReceiver(this);
        this.receiver = obj5;
        obj5 = new WebSocketWriter(this, "TubeSock", incrementAndGet);
        this.writer = obj5;
    }

    static void access$000(com.google.firebase.database.tubesock.WebSocket webSocket) {
        webSocket.runReader();
    }

    private void closeSocket() {
        Socket socket;
        com.google.firebase.database.tubesock.WebSocket.State dISCONNECTED;
        com.google.firebase.database.tubesock.WebSocketException webSocketException;
        String str;
        synchronized (this) {
            try {
                this.receiver.stopit();
                this.writer.stopIt();
                if (this.socket != null) {
                }
                this.socket.close();
                webSocketException = new WebSocketException("Failed to close", th);
                this.eventHandler.onError(webSocketException);
            } catch (Exception e) {
            } catch (Throwable th1) {
            }
            this.state = WebSocket.State.DISCONNECTED;
            this.eventHandler.onClose();
        }
    }

    private Socket createSocket() {
        Socket socket;
        int i;
        int verify;
        int session;
        Object sslCacheDirectory;
        boolean logger;
        int sslCacheDirectory2;
        String str;
        String scheme = this.url.getScheme();
        String host = this.url.getHost();
        verify = this.url.getPort();
        String str2 = "unknown host: ";
        session = -1;
        if (scheme != null && scheme.equals("ws")) {
            if (scheme.equals("ws")) {
                if (verify == session) {
                    verify = 80;
                }
                socket = new Socket(host, verify);
                return socket;
            } else {
                if (scheme == null) {
                } else {
                    if (!scheme.equals("wss")) {
                    } else {
                        if (verify == session) {
                            verify = 443;
                        }
                        i = 0;
                        if (this.sslCacheDirectory != null) {
                            logger = new File(this.sslCacheDirectory);
                            sslCacheDirectory = new SSLSessionCache(logger);
                            i = sslCacheDirectory;
                        }
                        if (!HttpsURLConnection.getDefaultHostnameVerifier().verify(host, (SSLSocket)SSLCertificateSocketFactory.getDefault(60000, i).createSocket(host, verify).getSession())) {
                        } else {
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Error while verifying secure socket to ");
                        stringBuilder.append(this.url);
                        WebSocketException webSocketException = new WebSocketException(stringBuilder.toString());
                        throw webSocketException;
                    }
                }
            }
        } else {
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("unsupported protocol: ");
        stringBuilder2.append(scheme);
        WebSocketException webSocketException2 = new WebSocketException(stringBuilder2.toString());
        throw webSocketException2;
    }

    static com.google.firebase.database.tubesock.ThreadInitializer getIntializer() {
        return WebSocket.intializer;
    }

    static ThreadFactory getThreadFactory() {
        return WebSocket.threadFactory;
    }

    private void runReader() {
        com.google.firebase.database.tubesock.WebSocketReceiver receiver;
        DataInputStream dataInputStream;
        com.google.firebase.database.tubesock.WebSocketWriter writer;
        byte[] bArr;
        com.google.firebase.database.tubesock.WebSocketHandshake handshake;
        boolean equals;
        ArrayList arrayList;
        boolean next;
        int lowerCase;
        int i;
        int i3;
        byte str;
        int i2;
        Socket socket = createSocket();
        this.socket = socket;
        synchronized (this) {
            this.socket.close();
            this.socket = 0;
            close();
        }
        i3 = 1;
        while (lowerCase == 0) {
            int read = dataInputStream.read();
            bArr[i] = (byte)read;
            i++;
            i3 = 1;
            String string4 = new String(bArr, WebSocket.UTF8);
            if (string4.trim().equals("")) {
            } else {
            }
            arrayList.add(string4.trim());
            bArr = new byte[i5];
            i = i6;
            lowerCase = i3;
        }
        this.handshake.verifyServerStatusLine((String)arrayList.get(i6));
        arrayList.remove(i6);
        HashMap hashMap = new HashMap();
        Iterator iterator = arrayList.iterator();
        for (String next2 : iterator) {
            String[] split = next2.split(": ", 2);
            i = Locale.US;
            hashMap.put(split[i6].toLowerCase(i), split[i3].toLowerCase(i));
        }
        try {
            this.handshake.verifyServerHandshakeHeaders(hashMap);
            this.writer.setOutput(outputStream);
            this.receiver.setInput(dataInputStream);
            this.state = WebSocket.State.CONNECTED;
            this.writer.getInnerThread().start();
            this.eventHandler.onOpen();
            this.receiver.run();
            throw th;
            RuntimeException eventHandler2 = this.eventHandler;
            StringBuilder string3 = new StringBuilder();
            String message = "error while connecting: ";
            string3.append(message);
            message = th.getMessage();
            string3.append(message);
            string3 = string3.toString();
            WebSocketException webSocketException3 = new WebSocketException(string3, th);
            eventHandler2.onError(webSocketException3);
        }
        close();
    }

    private void send(byte b, byte[] b2Arr2) {
        Object writer;
        com.google.firebase.database.tubesock.WebSocket.State cONNECTED;
        com.google.firebase.database.tubesock.WebSocketEventHandler obj3;
        com.google.firebase.database.tubesock.WebSocketException obj4;
        synchronized (this) {
            try {
                obj4 = new WebSocketException("error while sending data: not connected");
                this.eventHandler.onError(obj4);
                this.writer.send(b, true, b2Arr2);
                b2Arr2 = this.eventHandler;
                WebSocketException webSocketException = new WebSocketException("Failed to send frame", b);
                b2Arr2.onError(webSocketException);
                close();
                throw b;
            } catch (java.io.IOException ioException) {
            } catch (Throwable th1) {
            }
        }
    }

    private void sendCloseHandshake() {
        com.google.firebase.database.tubesock.WebSocketWriter writer;
        int i;
        int i2;
        byte[] bArr;
        try {
            this.state = WebSocket.State.DISCONNECTING;
            this.writer.stopIt();
            this.writer.send(8, true, new byte[0]);
            WebSocketException webSocketException = new WebSocketException("Failed to send close frame", th);
            this.eventHandler.onError(webSocketException);
        }
    }

    public static void setThreadFactory(ThreadFactory threadFactory, com.google.firebase.database.tubesock.ThreadInitializer threadInitializer2) {
        WebSocket.threadFactory = threadFactory;
        WebSocket.intializer = threadInitializer2;
    }

    public void blockClose() {
        Object innerThread;
        if (this.writer.getInnerThread().getState() != Thread.State.NEW) {
            this.writer.getInnerThread().join();
        }
        getInnerThread().join();
    }

    public void close() {
        int i = WebSocket.3.$SwitchMap$com$google$firebase$database$tubesock$WebSocket$State[this.state.ordinal()];
        synchronized (this) {
            try {
                if (i != 2) {
                }
                if (i != 3) {
                }
                if (i != 4) {
                }
                if (i != 5) {
                }
                sendCloseHandshake();
                closeSocket();
                this.state = WebSocket.State.DISCONNECTED;
            }
        }
    }

    public void connect() {
        synchronized (this) {
            try {
                WebSocketException webSocketException = new WebSocketException("connect() already called");
                this.eventHandler.onError(webSocketException);
                close();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("TubeSockReader-");
                stringBuilder.append(this.clientId);
                WebSocket.getIntializer().setName(getInnerThread(), stringBuilder.toString());
                this.state = WebSocket.State.CONNECTING;
                getInnerThread().start();
                throw th;
            }
        }
    }

    com.google.firebase.database.tubesock.WebSocketEventHandler getEventHandler() {
        return this.eventHandler;
    }

    Thread getInnerThread() {
        return this.innerThread;
    }

    void handleReceiverError(com.google.firebase.database.tubesock.WebSocketException webSocketException) {
        this.eventHandler.onError(webSocketException);
        if (this.state == WebSocket.State.CONNECTED) {
            close();
        }
        closeSocket();
    }

    void onCloseOpReceived() {
        closeSocket();
    }

    void pong(byte[] bArr) {
        send(10, bArr);
        return;
        synchronized (this) {
            send(10, bArr);
        }
    }

    public void send(String string) {
        send(1, string.getBytes(WebSocket.UTF8));
        return;
        synchronized (this) {
            send(1, string.getBytes(WebSocket.UTF8));
        }
    }

    public void send(byte[] bArr) {
        send(2, bArr);
        return;
        synchronized (this) {
            send(2, bArr);
        }
    }

    public void setEventHandler(com.google.firebase.database.tubesock.WebSocketEventHandler webSocketEventHandler) {
        this.eventHandler = webSocketEventHandler;
    }
}
