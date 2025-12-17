package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.b0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.z;
import kotlin.k0.l;
import kotlin.w;
import kotlin.y.p;
import l.g;
import l.h;
import l.i;
import l.i.a;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u0002:\n\u0083\u0001\u0082\u0001\u0084\u0001\u0085\u0001\u0086\u0001BC\u0012\u0006\u0010\u007f\u001a\u00020~\u0012\u0006\u0010b\u001a\u00020\u0010\u0012\u0006\u0010^\u001a\u00020]\u0012\u0006\u0010x\u001a\u00020w\u0012\u0006\u0010r\u001a\u00020\u0013\u0012\u0008\u0010|\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010{\u001a\u00020\u0013¢\u0006\u0006\u0008\u0080\u0001\u0010\u0081\u0001J\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0003H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\u0008\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\u0008\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\rH\u0016¢\u0006\u0004\u0008\u0016\u0010\u000fJ\u0015\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\u0008\u0019\u0010\u001aJ!\u0010!\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u001b2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0004\u0008\u001f\u0010 J\u001d\u0010&\u001a\u00020\r2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$¢\u0006\u0004\u0008&\u0010'J\r\u0010(\u001a\u00020\r¢\u0006\u0004\u0008(\u0010\u000fJ\r\u0010)\u001a\u00020\u0004¢\u0006\u0004\u0008)\u0010*J\u001d\u0010.\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010-\u001a\u00020,¢\u0006\u0004\u0008.\u0010/J\r\u00100\u001a\u00020\r¢\u0006\u0004\u00080\u0010\u000fJ\r\u00101\u001a\u00020\t¢\u0006\u0004\u00081\u00102J\r\u00103\u001a\u00020\t¢\u0006\u0004\u00083\u00102J\r\u00104\u001a\u00020\t¢\u0006\u0004\u00084\u00102J\u0017\u00106\u001a\u00020\r2\u0006\u00105\u001a\u00020\"H\u0016¢\u0006\u0004\u00086\u00107J\u0017\u00106\u001a\u00020\r2\u0006\u00108\u001a\u00020\u0007H\u0016¢\u0006\u0004\u00086\u00109J\u0017\u0010;\u001a\u00020\r2\u0006\u0010:\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008;\u00109J\u0017\u0010<\u001a\u00020\r2\u0006\u0010:\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008<\u00109J\u001f\u0010?\u001a\u00020\r2\u0006\u0010=\u001a\u00020\t2\u0006\u0010>\u001a\u00020\"H\u0016¢\u0006\u0004\u0008?\u0010@J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u00105\u001a\u00020\"H\u0016¢\u0006\u0004\u0008\u000b\u0010AJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u0007H\u0016¢\u0006\u0004\u0008\u000b\u0010BJ\u0015\u0010C\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u0007¢\u0006\u0004\u0008C\u0010BJ!\u0010D\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\t2\u0008\u0010>\u001a\u0004\u0018\u00010\"H\u0016¢\u0006\u0004\u0008D\u0010EJ'\u0010D\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\t2\u0008\u0010>\u001a\u0004\u0018\u00010\"2\u0006\u0010F\u001a\u00020\u0013¢\u0006\u0004\u0008D\u0010GJ\u000f\u0010I\u001a\u00020\u0004H\u0000¢\u0006\u0004\u0008H\u0010*J\u000f\u0010K\u001a\u00020\rH\u0000¢\u0006\u0004\u0008J\u0010\u000fJ#\u0010O\u001a\u00020\r2\n\u0010N\u001a\u00060Lj\u0002`M2\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\u0008O\u0010PR\u0018\u0010R\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008R\u0010SR\u0018\u0010T\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008T\u0010UR\u001c\u0010W\u001a\u0008\u0012\u0004\u0012\u00020\u00070V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008W\u0010XR\u0016\u0010Z\u001a\u00020Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008Z\u0010[R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008#\u0010UR\u0016\u00101\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u00081\u0010\\R\u001c\u0010^\u001a\u00020]8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008^\u0010_\u001a\u0004\u0008`\u0010aR\u0016\u0010b\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008b\u0010cR\u0018\u0010e\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008e\u0010fR\u001c\u0010h\u001a\u0008\u0012\u0004\u0012\u00020g0V8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008h\u0010XR\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0014\u0010iR\u0016\u0010j\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008j\u0010kR\u0016\u00104\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u00084\u0010\\R\u0018\u0010m\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008m\u0010nR\u0016\u0010o\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008o\u0010kR\u0016\u00103\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u00083\u0010\\R\u0016\u0010p\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008p\u0010\\R\u0016\u0010q\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008q\u0010UR\u0016\u0010r\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008r\u0010iR\u0016\u0010s\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008s\u0010kR\u0018\u0010u\u001a\u0004\u0018\u00010t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008u\u0010vR\u0016\u0010x\u001a\u00020w8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008x\u0010yR\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008%\u0010zR\u0016\u0010{\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008{\u0010iR\u0018\u0010|\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008|\u0010}¨\u0006\u0087\u0001", d2 = {"Lokhttp3/internal/ws/RealWebSocket;", "Lokhttp3/WebSocket;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "Lokhttp3/internal/ws/WebSocketExtensions;", "", "isValid", "(Lokhttp3/internal/ws/WebSocketExtensions;)Z", "Ll/i;", "data", "", "formatOpcode", "send", "(Ll/i;I)Z", "Lkotlin/w;", "runWriter", "()V", "Lokhttp3/Request;", "request", "()Lokhttp3/Request;", "", "queueSize", "()J", "cancel", "Lokhttp3/OkHttpClient;", "client", "connect", "(Lokhttp3/OkHttpClient;)V", "Lokhttp3/Response;", "response", "Lokhttp3/internal/connection/Exchange;", "exchange", "checkUpgradeSuccess$okhttp", "(Lokhttp3/Response;Lokhttp3/internal/connection/Exchange;)V", "checkUpgradeSuccess", "", "name", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "streams", "initReaderAndWriter", "(Ljava/lang/String;Lokhttp3/internal/ws/RealWebSocket$Streams;)V", "loopReader", "processNextFrame", "()Z", "timeout", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "awaitTermination", "(JLjava/util/concurrent/TimeUnit;)V", "tearDown", "sentPingCount", "()I", "receivedPingCount", "receivedPongCount", "text", "onReadMessage", "(Ljava/lang/String;)V", "bytes", "(Ll/i;)V", "payload", "onReadPing", "onReadPong", "code", "reason", "onReadClose", "(ILjava/lang/String;)V", "(Ljava/lang/String;)Z", "(Ll/i;)Z", "pong", "close", "(ILjava/lang/String;)Z", "cancelAfterCloseMillis", "(ILjava/lang/String;J)Z", "writeOneFrame$okhttp", "writeOneFrame", "writePingFrame$okhttp", "writePingFrame", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "failWebSocket", "(Ljava/lang/Exception;Lokhttp3/Response;)V", "Lokhttp3/internal/ws/WebSocketReader;", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "receivedCloseReason", "Ljava/lang/String;", "Ljava/util/ArrayDeque;", "pongQueue", "Ljava/util/ArrayDeque;", "Lokhttp3/internal/concurrent/TaskQueue;", "taskQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "I", "Lokhttp3/WebSocketListener;", "listener", "Lokhttp3/WebSocketListener;", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "originalRequest", "Lokhttp3/Request;", "Lokhttp3/Call;", "call", "Lokhttp3/Call;", "", "messageAndCloseQueue", "J", "failed", "Z", "Lokhttp3/internal/ws/WebSocketWriter;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "enqueuedClose", "receivedCloseCode", "key", "pingIntervalMillis", "awaitingPong", "Lokhttp3/internal/concurrent/Task;", "writerTask", "Lokhttp3/internal/concurrent/Task;", "Ljava/util/Random;", "random", "Ljava/util/Random;", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "minimumDeflateSize", "extensions", "Lokhttp3/internal/ws/WebSocketExtensions;", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "<init>", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;JLokhttp3/internal/ws/WebSocketExtensions;J)V", "Companion", "Close", "Message", "Streams", "WriterTask", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class RealWebSocket implements WebSocket, okhttp3.internal.ws.WebSocketReader.FrameCallback {

    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000L;
    public static final okhttp3.internal.ws.RealWebSocket.Companion Companion = null;
    public static final long DEFAULT_MINIMUM_DEFLATE_SIZE = 1024L;
    private static final long MAX_QUEUE_SIZE = 16777216L;
    private static final List<Protocol> ONLY_HTTP1;
    private boolean awaitingPong;
    private Call call;
    private boolean enqueuedClose;
    private okhttp3.internal.ws.WebSocketExtensions extensions;
    private boolean failed;
    private final String key;
    private final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue;
    private long minimumDeflateSize;
    private String name;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<i> pongQueue;
    private long queueSize;
    private final Random random;
    private okhttp3.internal.ws.WebSocketReader reader;
    private int receivedCloseCode = -1;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private okhttp3.internal.ws.RealWebSocket.Streams streams;
    private TaskQueue taskQueue;
    private okhttp3.internal.ws.WebSocketWriter writer;
    private Task writerTask;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0007\u0008\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\r\u001a\u00020\u000c¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006R\u001b\u0010\u0008\u001a\u0004\u0018\u00010\u00078\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\u000c8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0013", d2 = {"Lokhttp3/internal/ws/RealWebSocket$Close;", "", "", "code", "I", "getCode", "()I", "Ll/i;", "reason", "Ll/i;", "getReason", "()Ll/i;", "", "cancelAfterCloseMillis", "J", "getCancelAfterCloseMillis", "()J", "<init>", "(ILl/i;J)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Close {

        private final long cancelAfterCloseMillis;
        private final int code;
        private final i reason;
        public Close(int i, i i2, long l3) {
            super();
            this.code = i;
            this.reason = i2;
            this.cancelAfterCloseMillis = l3;
        }

        public final long getCancelAfterCloseMillis() {
            return this.cancelAfterCloseMillis;
        }

        public final int getCode() {
            return this.code;
        }

        public final i getReason() {
            return this.reason;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0004R\u001c\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\t\u0010\n¨\u0006\r", d2 = {"Lokhttp3/internal/ws/RealWebSocket$Companion;", "", "", "CANCEL_AFTER_CLOSE_MILLIS", "J", "DEFAULT_MINIMUM_DEFLATE_SIZE", "MAX_QUEUE_SIZE", "", "Lokhttp3/Protocol;", "ONLY_HTTP1", "Ljava/util/List;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0004\u0008\u000c\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u00078\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u000e", d2 = {"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "", "formatOpcode", "I", "getFormatOpcode", "()I", "Ll/i;", "data", "Ll/i;", "getData", "()Ll/i;", "<init>", "(ILl/i;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Message {

        private final i data;
        private final int formatOpcode;
        public Message(int i, i i2) {
            n.f(i2, "data");
            super();
            this.formatOpcode = i;
            this.data = i2;
        }

        public final i getData() {
            return this.data;
        }

        public final int getFormatOpcode() {
            return this.formatOpcode;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0007\u0008&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\u000c\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006R\u0019\u0010\u0008\u001a\u00020\u00078\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0008\u0010\t\u001a\u0004\u0008\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\u000c8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0013", d2 = {"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "Ll/h;", "source", "Ll/h;", "getSource", "()Ll/h;", "Ll/g;", "sink", "Ll/g;", "getSink", "()Ll/g;", "", "client", "Z", "getClient", "()Z", "<init>", "(ZLl/h;Ll/g;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static abstract class Streams implements Closeable {

        private final boolean client;
        private final g sink;
        private final h source;
        public Streams(boolean z, h h2, g g3) {
            n.f(h2, "source");
            n.f(g3, "sink");
            super();
            this.client = z;
            this.source = h2;
            this.sink = g3;
        }

        @Override // java.io.Closeable
        public final boolean getClient() {
            return this.client;
        }

        @Override // java.io.Closeable
        public final g getSink() {
            return this.sink;
        }

        @Override // java.io.Closeable
        public final h getSource() {
            return this.source;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0008\u0005\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\u0008\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004¨\u0006\u0007", d2 = {"Lokhttp3/internal/ws/RealWebSocket$WriterTask;", "Lokhttp3/internal/concurrent/Task;", "", "runOnce", "()J", "<init>", "(Lokhttp3/internal/ws/RealWebSocket;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private final class WriterTask extends Task {

        final okhttp3.internal.ws.RealWebSocket this$0;
        public WriterTask(okhttp3.internal.ws.RealWebSocket realWebSocket) {
            this.this$0 = realWebSocket;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(RealWebSocket.access$getName$p(realWebSocket));
            stringBuilder.append(" writer");
            super(stringBuilder.toString(), 0, 2, 0);
        }

        @Override // okhttp3.internal.concurrent.Task
        public long runOnce() {
            boolean oneFrame$okhttp;
            okhttp3.internal.ws.RealWebSocket this$0;
            int i;
            try {
                if (this.this$0.writeOneFrame$okhttp()) {
                }
                return 0;
                this.this$0.failWebSocket(th, 0);
                return -1;
            }
        }
    }
    static {
        RealWebSocket.Companion companion = new RealWebSocket.Companion(0);
        RealWebSocket.Companion = companion;
        RealWebSocket.ONLY_HTTP1 = p.b(Protocol.HTTP_1_1);
    }

    public RealWebSocket(TaskRunner taskRunner, Request request2, WebSocketListener webSocketListener3, Random random4, long l5, okhttp3.internal.ws.WebSocketExtensions webSocketExtensions6, long l7) {
        n.f(taskRunner, "taskRunner");
        n.f(request2, "originalRequest");
        n.f(webSocketListener3, "listener");
        n.f(random4, "random");
        super();
        this.originalRequest = request2;
        this.listener = webSocketListener3;
        this.random = random4;
        this.pingIntervalMillis = l5;
        this.extensions = l7;
        this.minimumDeflateSize = obj9;
        this.taskQueue = taskRunner.newQueue();
        ArrayDeque obj2 = new ArrayDeque();
        this.pongQueue = obj2;
        obj2 = new ArrayDeque();
        this.messageAndCloseQueue = obj2;
        obj2 = -1;
        if (!n.b("GET", request2.method())) {
        } else {
            byte[] obj4 = new byte[16];
            random4.nextBytes(obj4);
            obj2 = w.a;
            this.key = i.a.g(i.v, obj4, 0, 0, 3, 0).a();
        }
        obj2 = new StringBuilder();
        obj2.append("Request must be GET: ");
        obj2.append(request2.method());
        IllegalArgumentException obj3 = new IllegalArgumentException(obj2.toString().toString());
        throw obj3;
    }

    public static final okhttp3.internal.ws.WebSocketExtensions access$getExtensions$p(okhttp3.internal.ws.RealWebSocket realWebSocket) {
        return realWebSocket.extensions;
    }

    public static final ArrayDeque access$getMessageAndCloseQueue$p(okhttp3.internal.ws.RealWebSocket realWebSocket) {
        return realWebSocket.messageAndCloseQueue;
    }

    public static final String access$getName$p(okhttp3.internal.ws.RealWebSocket realWebSocket) {
        return realWebSocket.name;
    }

    public static final boolean access$isValid(okhttp3.internal.ws.RealWebSocket realWebSocket, okhttp3.internal.ws.WebSocketExtensions webSocketExtensions2) {
        return realWebSocket.isValid(webSocketExtensions2);
    }

    public static final void access$setExtensions$p(okhttp3.internal.ws.RealWebSocket realWebSocket, okhttp3.internal.ws.WebSocketExtensions webSocketExtensions2) {
        realWebSocket.extensions = webSocketExtensions2;
    }

    public static final void access$setName$p(okhttp3.internal.ws.RealWebSocket realWebSocket, String string2) {
        realWebSocket.name = string2;
    }

    private final boolean isValid(okhttp3.internal.ws.WebSocketExtensions webSocketExtensions) {
        Integer clientMaxWindowBits;
        int i;
        Integer obj4;
        final int i2 = 0;
        if (webSocketExtensions.unknownValues) {
            return i2;
        }
        if (webSocketExtensions.clientMaxWindowBits != null) {
            return i2;
        }
        obj4 = webSocketExtensions.serverMaxWindowBits;
        obj4 = obj4.intValue();
        if (obj4 != null && 8 <= obj4 && 15 < obj4) {
            obj4 = obj4.intValue();
            if (8 <= obj4) {
                if (15 < obj4) {
                }
            }
            return i2;
        }
        return 1;
    }

    private final void runWriter() {
        boolean assertionsEnabled;
        TaskQueue taskQueue;
        int i3;
        int i;
        int i2;
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(this);
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }
        Task writerTask = this.writerTask;
        if (writerTask != null) {
            TaskQueue.schedule$default(this.taskQueue, writerTask, 0, obj5, 2);
        }
    }

    private final boolean send(i i, int i2) {
        boolean enqueuedClose;
        int i5 = 0;
        synchronized (this) {
            try {
                if (this.enqueuedClose) {
                } else {
                }
                if (Long.compare(i6, i8) > 0) {
                }
                close(1001, 0);
                return i5;
                this.queueSize = queueSize += l;
                RealWebSocket.Message message = new RealWebSocket.Message(i2, i);
                this.messageAndCloseQueue.add(message);
                runWriter();
                return 1;
                return i5;
                throw i;
            }
        }
    }

    @Override // okhttp3.WebSocket
    public final void awaitTermination(long l, TimeUnit timeUnit2) {
        n.f(obj4, "timeUnit");
        this.taskQueue.idleLatch().await(l, timeUnit2);
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        final Call call = this.call;
        n.d(call);
        call.cancel();
    }

    @Override // okhttp3.WebSocket
    public final void checkUpgradeSuccess$okhttp(Response response, Exchange exchange2) {
        n.f(response, "response");
        final int i = 39;
        if (response.code() != 101) {
        } else {
            int i4 = 0;
            int i6 = 2;
            String header$default = Response.header$default(response, "Connection", i4, i6, i4);
            String str11 = "Upgrade";
            final int i7 = 1;
            if (!l.x(str11, header$default, i7)) {
            } else {
                String header$default2 = Response.header$default(response, str11, i4, i6, i4);
                if (!l.x("websocket", header$default2, i7)) {
                } else {
                    String obj8 = Response.header$default(response, "Sec-WebSocket-Accept", i4, i6, i4);
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(this.key);
                    stringBuilder2.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
                    String str4 = i.v.d(stringBuilder2.toString()).y().a();
                    if (z ^= i7 != 0) {
                    } else {
                        if (exchange2 == null) {
                        } else {
                        }
                        obj8 = new ProtocolException("Web Socket exchange missing: bad interceptor?");
                        throw obj8;
                    }
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append("Expected 'Sec-WebSocket-Accept' header value '");
                    stringBuilder3.append(str4);
                    stringBuilder3.append("' but was '");
                    stringBuilder3.append(obj8);
                    stringBuilder3.append(i);
                    ProtocolException obj9 = new ProtocolException(stringBuilder3.toString());
                    throw obj9;
                }
                obj9 = new StringBuilder();
                obj9.append("Expected 'Upgrade' header value 'websocket' but was '");
                obj9.append(header$default2);
                obj9.append(i);
                obj8 = new ProtocolException(obj9.toString());
                throw obj8;
            }
            obj9 = new StringBuilder();
            obj9.append("Expected 'Connection' header value 'Upgrade' but was '");
            obj9.append(header$default);
            obj9.append(i);
            obj8 = new ProtocolException(obj9.toString());
            throw obj8;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected HTTP 101 response but was '");
        stringBuilder.append(response.code());
        stringBuilder.append(' ');
        stringBuilder.append(response.message());
        stringBuilder.append(i);
        obj9 = new ProtocolException(stringBuilder.toString());
        throw obj9;
    }

    @Override // okhttp3.WebSocket
    public boolean close(int i, String string2) {
        return close(i, string2, 60000);
    }

    @Override // okhttp3.WebSocket
    public final boolean close(int i, String string2, long l3) {
        int i4;
        int i2;
        int i3;
        boolean obj9;
        WebSocketProtocol.INSTANCE.validateCloseCode(i);
        i4 = 0;
        int i5 = 0;
        final int i6 = 1;
        synchronized (this) {
            try {
                if (Long.compare(l, i3) <= 0) {
                } else {
                }
                i2 = i6;
                i2 = i5;
                if (i2 == 0) {
                } else {
                }
                StringBuilder obj8 = new StringBuilder();
                obj8.append("reason.size() > 123: ");
                obj8.append(string2);
                obj9 = new IllegalArgumentException(obj8.toString().toString());
                throw obj9;
                if (!this.failed && this.enqueuedClose) {
                }
                if (this.enqueuedClose) {
                }
                this.enqueuedClose = i6;
                RealWebSocket.Close close = new RealWebSocket.Close(i, i4, l3, obj11);
                this.messageAndCloseQueue.add(close);
                runWriter();
                return i6;
                return i5;
                throw i;
            }
        }
    }

    @Override // okhttp3.WebSocket
    public final void connect(OkHttpClient okHttpClient) {
        n.f(okHttpClient, "client");
        String str3 = "Sec-WebSocket-Extensions";
        if (this.originalRequest.header(str3) != null) {
            ProtocolException obj5 = new ProtocolException("Request header not permitted: 'Sec-WebSocket-Extensions'");
            failWebSocket(obj5, 0);
        }
        String str4 = "Upgrade";
        Request build = this.originalRequest.newBuilder().header(str4, "websocket").header("Connection", str4).header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").header(str3, "permessage-deflate").build();
        RealCall realCall = new RealCall(okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(RealWebSocket.ONLY_HTTP1).build(), build, 1);
        this.call = realCall;
        n.d(realCall);
        obj5 = new RealWebSocket.connect.1(this, build);
        realCall.enqueue(obj5);
    }

    @Override // okhttp3.WebSocket
    public final void failWebSocket(Exception exception, Response response2) {
        n.f(exception, "e");
        synchronized (this) {
        }
        Util.closeQuietly(streams);
        if (reader != null) {
            Util.closeQuietly(reader);
        }
        try {
            if (writer != null) {
            }
            Util.closeQuietly(writer);
        } catch (Throwable th) {
        }
    }

    @Override // okhttp3.WebSocket
    public final WebSocketListener getListener$okhttp() {
        return this.listener;
    }

    @Override // okhttp3.WebSocket
    public final void initReaderAndWriter(String string, okhttp3.internal.ws.RealWebSocket.Streams realWebSocket$Streams2) {
        Object obj;
        long pingIntervalMillis;
        boolean client;
        int string2;
        Random random;
        boolean noContextTakeover;
        long minimumDeflateSize;
        okhttp3.internal.ws.WebSocketExtensions socket;
        Object webSocketWriter;
        long nanos;
        TaskQueue taskQueue;
        final Object obj2 = this;
        obj = string;
        final Object obj3 = streams2;
        n.f(obj, "name");
        n.f(obj3, "streams");
        final okhttp3.internal.ws.WebSocketExtensions extensions = obj2.extensions;
        n.d(extensions);
        obj2.name = obj;
        obj2.streams = obj3;
        client = streams2.getClient();
        boolean perMessageDeflate = extensions.perMessageDeflate;
        super(client, streams2.getSink(), obj2.random, perMessageDeflate, extensions.noContextTakeover(streams2.getClient()), obj2.minimumDeflateSize, obj8);
        obj2.writer = webSocketWriter;
        RealWebSocket.WriterTask writerTask = new RealWebSocket.WriterTask(obj2);
        obj2.writerTask = writerTask;
        pingIntervalMillis = obj2.pingIntervalMillis;
        synchronized (this) {
            nanos = TimeUnit.MILLISECONDS.toNanos(pingIntervalMillis);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(obj);
            stringBuilder.append(" ping");
            string2 = stringBuilder.toString();
            super(string2, string2, nanos, perMessageDeflate, this, string, streams2, extensions);
            obj2.taskQueue.schedule(anon, nanos);
            if (empty ^= 1 != 0) {
                runWriter();
            }
            w wVar = w.a;
            super(streams2.getClient(), streams2.getSource(), this, extensions.perMessageDeflate, extensions.noContextTakeover(client3 ^= 1));
            obj2.reader = webSocketReader;
        }
    }

    @Override // okhttp3.WebSocket
    public final void loopReader() {
        while (this.receivedCloseCode == -1) {
            okhttp3.internal.ws.WebSocketReader reader = this.reader;
            n.d(reader);
            reader.processNextFrame();
        }
    }

    @Override // okhttp3.WebSocket
    public void onReadClose(int i, String string2) {
        int i3;
        boolean enqueuedClose;
        WebSocketListener listener;
        int i4;
        int reader;
        int i2;
        int writer;
        n.f(string2, "reason");
        int i5 = 0;
        int i6 = -1;
        i2 = i != i6 ? i3 : i5;
        if (i2 == 0) {
        } else {
            synchronized (this) {
                if (i3 == 0) {
                } else {
                    this.receivedCloseCode = i;
                    this.receivedCloseReason = string2;
                    i4 = 0;
                    if (this.enqueuedClose && this.messageAndCloseQueue.isEmpty()) {
                        if (this.messageAndCloseQueue.isEmpty()) {
                            this.streams = i4;
                            reader = this.reader;
                            this.reader = i4;
                            writer = this.writer;
                            this.writer = i4;
                            this.taskQueue.shutdown();
                            i4 = enqueuedClose;
                        } else {
                            writer = reader;
                        }
                    } else {
                    }
                    w wVar = w.a;
                    this.listener.onClosing(this, i, string2);
                    if (i4 != 0) {
                    }
                    if (i4 != 0) {
                        Util.closeQuietly(i4);
                    }
                    try {
                        if (reader != null) {
                        }
                        Util.closeQuietly(reader);
                        if (writer != null) {
                        }
                        Util.closeQuietly(writer);
                        if (obj1 != null) {
                        }
                        Util.closeQuietly(obj1);
                        if (obj2 != null) {
                        }
                        Util.closeQuietly(obj2);
                        if (obj3 == null) {
                        } else {
                        }
                        Util.closeQuietly(obj3);
                        throw i;
                        IllegalStateException obj6 = new IllegalStateException("already closed".toString());
                        throw obj6;
                        throw i;
                        obj6 = new IllegalArgumentException("Failed requirement.".toString());
                        throw obj6;
                    } catch (Throwable th) {
                    }
                }
            }
            this.listener.onClosed(this, i, string2);
        }
    }

    @Override // okhttp3.WebSocket
    public void onReadMessage(String string) {
        n.f(string, "text");
        this.listener.onMessage(this, string);
    }

    @Override // okhttp3.WebSocket
    public void onReadMessage(i i) {
        n.f(i, "bytes");
        this.listener.onMessage(this, i);
    }

    @Override // okhttp3.WebSocket
    public void onReadPing(i i) {
        boolean enqueuedClose;
        n.f(i, "payload");
        synchronized (this) {
            try {
                if (this.enqueuedClose) {
                }
                if (this.messageAndCloseQueue.isEmpty()) {
                }
                this.pongQueue.add(i);
                runWriter();
                this.receivedPingCount = obj2++;
                throw i;
            }
        }
    }

    @Override // okhttp3.WebSocket
    public void onReadPong(i i) {
        n.f(i, "payload");
        this.receivedPongCount = obj2++;
        this.awaitingPong = false;
        return;
        synchronized (this) {
            n.f(i, "payload");
            this.receivedPongCount = obj2++;
            this.awaitingPong = false;
        }
    }

    @Override // okhttp3.WebSocket
    public final boolean pong(i i) {
        boolean enqueuedClose;
        n.f(i, "payload");
        synchronized (this) {
            try {
                if (this.enqueuedClose) {
                }
                if (this.messageAndCloseQueue.isEmpty()) {
                }
                this.pongQueue.add(i);
                runWriter();
                return 1;
                return 0;
                throw i;
            }
        }
    }

    @Override // okhttp3.WebSocket
    public final boolean processNextFrame() {
        int i;
        int receivedCloseCode;
        int i2;
        i = 0;
        okhttp3.internal.ws.WebSocketReader reader = this.reader;
        n.d(reader);
        reader.processNextFrame();
        if (this.receivedCloseCode == -1) {
            try {
                i = 1;
                failWebSocket(th, 0);
                return i;
            }
        }
    }

    @Override // okhttp3.WebSocket
    public long queueSize() {
        return this.queueSize;
        synchronized (this) {
            return this.queueSize;
        }
    }

    @Override // okhttp3.WebSocket
    public final int receivedPingCount() {
        return this.receivedPingCount;
        synchronized (this) {
            return this.receivedPingCount;
        }
    }

    @Override // okhttp3.WebSocket
    public final int receivedPongCount() {
        return this.receivedPongCount;
        synchronized (this) {
            return this.receivedPongCount;
        }
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String string) {
        n.f(string, "text");
        return send(i.v.d(string), 1);
    }

    @Override // okhttp3.WebSocket
    public boolean send(i i) {
        n.f(i, "bytes");
        return send(i, 2);
    }

    @Override // okhttp3.WebSocket
    public final int sentPingCount() {
        return this.sentPingCount;
        synchronized (this) {
            return this.sentPingCount;
        }
    }

    @Override // okhttp3.WebSocket
    public final void tearDown() {
        this.taskQueue.shutdown();
        this.taskQueue.idleLatch().await(10, obj3);
    }

    @Override // okhttp3.WebSocket
    public final boolean writeOneFrame$okhttp() {
        Object b0Var6;
        Object element2;
        int taskQueue;
        b0 b0Var5;
        okhttp3.internal.ws.WebSocketWriter i;
        Object obj2;
        int formatOpcode;
        Object obj3;
        Object receivedCloseCode;
        Object element;
        int receivedCloseReason;
        boolean i2;
        okhttp3.internal.ws.RealWebSocket socket;
        okhttp3.internal.ws.WebSocketWriter writer;
        Object writer2;
        Object b0Var8;
        b0 b0Var7;
        b0 b0Var2;
        Object zVar2;
        Object obj;
        okhttp3.internal.ws.RealWebSocket.writeOneFrame$$inlined.synchronized.lambda.1 socket2;
        long l;
        TaskQueue queue;
        okhttp3.internal.ws.WebSocketWriter writer3;
        b0 b0Var9;
        b0 b0Var;
        b0 b0Var3;
        b0 b0Var4;
        z zVar;
        final Object obj5 = this;
        b0Var6 = new b0();
        taskQueue = 0;
        b0Var6.element = taskQueue;
        zVar2 = new z();
        formatOpcode = -1;
        zVar2.element = formatOpcode;
        b0Var2 = new b0();
        b0Var2.element = taskQueue;
        b0 b0Var19 = new b0();
        b0Var19.element = taskQueue;
        b0Var7 = new b0();
        b0Var7.element = taskQueue;
        b0Var8 = new b0();
        b0Var8.element = taskQueue;
        receivedCloseReason = 0;
        synchronized (this) {
            return receivedCloseReason;
        }
        n.d(writer3);
        writer3.writePong(element);
        b0Var5 = b0Var3;
        Object element5 = b0Var5.element;
        if ((RealWebSocket.Streams)element5 != null) {
            Util.closeQuietly((RealWebSocket.Streams)element5);
        }
        Object element6 = b0Var14.element;
        if ((WebSocketReader)element6 != null) {
            Util.closeQuietly((WebSocketReader)element6);
        }
        Object element7 = b0Var18.element;
        if ((WebSocketWriter)element7 != null) {
            Util.closeQuietly((WebSocketWriter)element7);
        }
        return 1;
    }

    @Override // okhttp3.WebSocket
    public final void writePingFrame$okhttp() {
        okhttp3.internal.ws.WebSocketWriter writer;
        int sentPingCount;
        synchronized (this) {
            try {
                writer = this.writer;
            } catch (java.io.IOException ioException) {
            }
            int i2 = -1;
            sentPingCount = this.awaitingPong ? this.sentPingCount : i2;
            final int i5 = 1;
            this.sentPingCount = sentPingCount2 += i5;
            this.awaitingPong = i5;
            w wVar = w.a;
            if (sentPingCount != i2) {
            }
            writer.writePing(i.c);
        }
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("sent ping but didn't receive pong within ");
            stringBuilder.append(this.pingIntervalMillis);
            stringBuilder.append("ms (after ");
            stringBuilder.append(sentPingCount -= i5);
            stringBuilder.append(" successful ping/pongs)");
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException(stringBuilder.toString());
            failWebSocket(socketTimeoutException, 0);
            writer.writePing(i.c);
            failWebSocket(th, obj3);
            throw th;
        } catch (java.io.IOException ioException) {
        }
    }
}
