package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.a0;
import kotlin.d0.d.b0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;
import l.d0;
import l.f;
import l.g;
import l.h;
import l.i;
import l.q;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskQueue.execute.1;
import okhttp3.internal.concurrent.TaskRunner;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\t\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u001d\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0010%\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010#\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u0000 º\u00012\u00020\u0001:\u0008»\u0001º\u0001¼\u0001½\u0001B\u0015\u0008\u0000\u0012\u0008\u0010·\u0001\u001a\u00030¶\u0001¢\u0006\u0006\u0008¸\u0001\u0010¹\u0001J-\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0008\u001a\u00020\u0007H\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u000e2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000cH\u0002¢\u0006\u0004\u0008\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0017\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u0002¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0002H\u0000¢\u0006\u0004\u0008\u0017\u0010\u0015J\u0017\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0019H\u0000¢\u0006\u0004\u0008\u001b\u0010\u001cJ+\u0010\u001e\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0004\u0008\u001e\u0010\u000bJ#\u0010\n\u001a\u00020\t2\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0004\u0008\n\u0010\u001fJ-\u0010$\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00072\u000c\u0010!\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\u0008\"\u0010#J/\u0010(\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00072\u0008\u0010&\u001a\u0004\u0018\u00010%2\u0006\u0010'\u001a\u00020\u0019¢\u0006\u0004\u0008(\u0010)J\u001f\u0010.\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\u0008,\u0010-J\u001f\u00101\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010/\u001a\u00020*H\u0000¢\u0006\u0004\u00080\u0010-J\u001f\u00105\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u0019H\u0000¢\u0006\u0004\u00083\u00104J%\u00109\u001a\u00020\u000e2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0002¢\u0006\u0004\u00089\u0010:J\r\u0010;\u001a\u00020\u000e¢\u0006\u0004\u0008;\u0010<J\r\u00109\u001a\u00020\u000e¢\u0006\u0004\u00089\u0010<J\r\u0010=\u001a\u00020\u000e¢\u0006\u0004\u0008=\u0010<J\r\u0010>\u001a\u00020\u000e¢\u0006\u0004\u0008>\u0010<J\u0015\u0010?\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020*¢\u0006\u0004\u0008?\u0010@J\u000f\u0010A\u001a\u00020\u000eH\u0016¢\u0006\u0004\u0008A\u0010<J)\u0010A\u001a\u00020\u000e2\u0006\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020*2\u0008\u0010D\u001a\u0004\u0018\u00010\u000cH\u0000¢\u0006\u0004\u0008E\u0010FJ#\u0010J\u001a\u00020\u000e2\u0008\u0008\u0002\u0010G\u001a\u00020\u00072\u0008\u0008\u0002\u0010I\u001a\u00020HH\u0007¢\u0006\u0004\u0008J\u0010KJ\u0015\u0010N\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020L¢\u0006\u0004\u0008N\u0010OJ\u0015\u0010Q\u001a\u00020\u00072\u0006\u0010P\u001a\u00020\u0019¢\u0006\u0004\u0008Q\u0010RJ\u000f\u0010T\u001a\u00020\u000eH\u0000¢\u0006\u0004\u0008S\u0010<J\u0017\u0010W\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0002H\u0000¢\u0006\u0004\u0008U\u0010VJ%\u0010Z\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004H\u0000¢\u0006\u0004\u0008X\u0010YJ-\u0010^\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010[\u001a\u00020\u0007H\u0000¢\u0006\u0004\u0008\\\u0010]J/\u0010c\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010`\u001a\u00020_2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010[\u001a\u00020\u0007H\u0000¢\u0006\u0004\u0008a\u0010bJ\u001f\u0010e\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*H\u0000¢\u0006\u0004\u0008d\u0010-R\u0016\u0010g\u001a\u00020f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008g\u0010hR\"\u0010i\u001a\u00020L8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008i\u0010j\u001a\u0004\u0008k\u0010l\"\u0004\u0008m\u0010OR\u001d\u0010o\u001a\u00060nR\u00020\u00008\u0006@\u0006¢\u0006\u000c\n\u0004\u0008o\u0010p\u001a\u0004\u0008q\u0010rR\u001c\u0010s\u001a\u00020\u00078\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008s\u0010t\u001a\u0004\u0008u\u0010vR\u0016\u0010w\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008w\u0010xR\u0019\u0010y\u001a\u00020L8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008y\u0010j\u001a\u0004\u0008z\u0010lR\"\u0010{\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008{\u0010|\u001a\u0004\u0008}\u0010\u0012\"\u0004\u0008~\u0010\u007fR.\u0010\u0081\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u0080\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\u0008\u0081\u0001\u0010\u0082\u0001\u001a\u0006\u0008\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0085\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\u0008\u0085\u0001\u0010xR\u0017\u0010I\u001a\u00020H8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\u0008I\u0010\u0086\u0001R\u0018\u0010\u0087\u0001\u001a\u00020f8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\u0008\u0087\u0001\u0010hR\"\u0010\u0089\u0001\u001a\u00030\u0088\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\u0008\u0089\u0001\u0010\u008a\u0001\u001a\u0006\u0008\u008b\u0001\u0010\u008c\u0001R\u0018\u0010\u008d\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\u0008\u008d\u0001\u0010tR\"\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\u0008\u008f\u0001\u0010\u0090\u0001\u001a\u0006\u0008\u0091\u0001\u0010\u0092\u0001R\u001a\u0010\u0094\u0001\u001a\u00030\u0093\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008\u0094\u0001\u0010\u0095\u0001R&\u0010\u0096\u0001\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0015\n\u0005\u0008\u0096\u0001\u0010|\u001a\u0005\u0008\u0097\u0001\u0010\u0012\"\u0005\u0008\u0098\u0001\u0010\u007fR\u001f\u0010\u009a\u0001\u001a\u00030\u0099\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\u0008\u009a\u0001\u0010\u009b\u0001\u001a\u0006\u0008\u009c\u0001\u0010\u009d\u0001R \u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u009e\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008\u009f\u0001\u0010 \u0001R)\u0010¢\u0001\u001a\u00020\u00192\u0007\u0010¡\u0001\u001a\u00020\u00198\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\u0008¢\u0001\u0010x\u001a\u0006\u0008£\u0001\u0010¤\u0001R\u0018\u0010¥\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\u0008¥\u0001\u0010xR)\u0010¦\u0001\u001a\u00020\u00192\u0007\u0010¡\u0001\u001a\u00020\u00198\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\u0008¦\u0001\u0010x\u001a\u0006\u0008§\u0001\u0010¤\u0001R\u0018\u0010¨\u0001\u001a\u00020f8\u0002@\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\u0008¨\u0001\u0010hR)\u0010©\u0001\u001a\u00020\u00192\u0007\u0010¡\u0001\u001a\u00020\u00198\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\u0008©\u0001\u0010x\u001a\u0006\u0008ª\u0001\u0010¤\u0001R\u0018\u0010«\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\u0008«\u0001\u0010xR\u0018\u0010¬\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\u0008¬\u0001\u0010xR\u0018\u0010­\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\u0008­\u0001\u0010xR)\u0010®\u0001\u001a\u00020\u00192\u0007\u0010¡\u0001\u001a\u00020\u00198\u0006@BX\u0086\u000e¢\u0006\u000f\n\u0005\u0008®\u0001\u0010x\u001a\u0006\u0008¯\u0001\u0010¤\u0001R\"\u0010±\u0001\u001a\u00030°\u00018\u0000@\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\u0008±\u0001\u0010²\u0001\u001a\u0006\u0008³\u0001\u0010´\u0001R\u0018\u0010µ\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\u0008µ\u0001\u0010x¨\u0006¾\u0001", d2 = {"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "requestHeaders", "", "out", "Lokhttp3/internal/http2/Http2Stream;", "newStream", "(ILjava/util/List;Z)Lokhttp3/internal/http2/Http2Stream;", "Ljava/io/IOException;", "e", "Lkotlin/w;", "failConnection", "(Ljava/io/IOException;)V", "openStreamCount", "()I", "id", "getStream", "(I)Lokhttp3/internal/http2/Http2Stream;", "streamId", "removeStream$okhttp", "removeStream", "", "read", "updateConnectionFlowControl$okhttp", "(J)V", "updateConnectionFlowControl", "pushStream", "(Ljava/util/List;Z)Lokhttp3/internal/http2/Http2Stream;", "outFinished", "alternating", "writeHeaders$okhttp", "(IZLjava/util/List;)V", "writeHeaders", "Ll/f;", "buffer", "byteCount", "writeData", "(IZLl/f;J)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "writeSynResetLater$okhttp", "(ILokhttp3/internal/http2/ErrorCode;)V", "writeSynResetLater", "statusCode", "writeSynReset$okhttp", "writeSynReset", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "(IJ)V", "writeWindowUpdateLater", "reply", "payload1", "payload2", "writePing", "(ZII)V", "writePingAndAwaitPong", "()V", "awaitPong", "flush", "shutdown", "(Lokhttp3/internal/http2/ErrorCode;)V", "close", "connectionCode", "streamCode", "cause", "close$okhttp", "(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V", "sendConnectionPreface", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "start", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "Lokhttp3/internal/http2/Settings;", "settings", "setSettings", "(Lokhttp3/internal/http2/Settings;)V", "nowNs", "isHealthy", "(J)Z", "sendDegradedPingLater$okhttp", "sendDegradedPingLater", "pushedStream$okhttp", "(I)Z", "pushedStream", "pushRequestLater$okhttp", "(ILjava/util/List;)V", "pushRequestLater", "inFinished", "pushHeadersLater$okhttp", "(ILjava/util/List;Z)V", "pushHeadersLater", "Ll/h;", "source", "pushDataLater$okhttp", "(ILl/h;IZ)V", "pushDataLater", "pushResetLater$okhttp", "pushResetLater", "Lokhttp3/internal/concurrent/TaskQueue;", "writerQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "peerSettings", "Lokhttp3/internal/http2/Settings;", "getPeerSettings", "()Lokhttp3/internal/http2/Settings;", "setPeerSettings", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "readerRunnable", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "client", "Z", "getClient$okhttp", "()Z", "intervalPongsReceived", "J", "okHttpSettings", "getOkHttpSettings", "nextStreamId", "I", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "(I)V", "", "streams", "Ljava/util/Map;", "getStreams$okhttp", "()Ljava/util/Map;", "degradedPongsReceived", "Lokhttp3/internal/concurrent/TaskRunner;", "settingsListenerQueue", "", "connectionName", "Ljava/lang/String;", "getConnectionName$okhttp", "()Ljava/lang/String;", "isShutdown", "Ljava/net/Socket;", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "Lokhttp3/internal/http2/PushObserver;", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "lastGoodStreamId", "getLastGoodStreamId$okhttp", "setLastGoodStreamId$okhttp", "Lokhttp3/internal/http2/Http2Writer;", "writer", "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "", "currentPushRequests", "Ljava/util/Set;", "<set-?>", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "degradedPongDeadlineNs", "readBytesTotal", "getReadBytesTotal", "pushQueue", "writeBytesTotal", "getWriteBytesTotal", "intervalPingsSent", "awaitPongsReceived", "degradedPingsSent", "writeBytesMaximum", "getWriteBytesMaximum", "Lokhttp3/internal/http2/Http2Connection$Listener;", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "awaitPingsSent", "Lokhttp3/internal/http2/Http2Connection$Builder;", "builder", "<init>", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "Companion", "Builder", "Listener", "ReaderRunnable", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http2Connection implements Closeable {

    public static final int AWAIT_PING = 3;
    public static final okhttp3.internal.http2.Http2Connection.Companion Companion = null;
    private static final okhttp3.internal.http2.Settings DEFAULT_SETTINGS = null;
    public static final int DEGRADED_PING = 2;
    public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
    public static final int INTERVAL_PING = 1;
    public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private long awaitPingsSent;
    private long awaitPongsReceived;
    private final boolean client;
    private final String connectionName;
    private final Set<Integer> currentPushRequests;
    private long degradedPingsSent;
    private long degradedPongDeadlineNs;
    private long degradedPongsReceived;
    private long intervalPingsSent;
    private long intervalPongsReceived;
    private boolean isShutdown;
    private int lastGoodStreamId;
    private final okhttp3.internal.http2.Http2Connection.Listener listener;
    private int nextStreamId = 2;
    private final okhttp3.internal.http2.Settings okHttpSettings;
    private okhttp3.internal.http2.Settings peerSettings;
    private final okhttp3.internal.http2.PushObserver pushObserver;
    private final TaskQueue pushQueue;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final okhttp3.internal.http2.Http2Connection.ReaderRunnable readerRunnable;
    private final TaskQueue settingsListenerQueue;
    private final Socket socket;
    private final Map<Integer, okhttp3.internal.http2.Http2Stream> streams;
    private final TaskRunner taskRunner;
    private long writeBytesMaximum = 7;
    private long writeBytesTotal;
    private final okhttp3.internal.http2.Http2Writer writer;
    private final TaskQueue writerQueue;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u001b\n\u0002\u0018\u0002\n\u0002\u0008\u000c\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010>\u001a\u00020=¢\u0006\u0004\u0008G\u0010HJ5\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\t\u001a\u00020\u0008H\u0007¢\u0006\u0004\u0008\u0003\u0010\nJ\u0015\u0010\u000c\u001a\u00020\u00002\u0006\u0010\u000c\u001a\u00020\u000b¢\u0006\u0004\u0008\u000c\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\u0008\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\u0008\u0015\u0010\u0016R\"\u0010\t\u001a\u00020\u00088\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\u0008\t\u0010\u0017\u001a\u0004\u0008\u0018\u0010\u0019\"\u0004\u0008\u001a\u0010\u001bR\"\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\u0008\u0007\u0010\u001c\u001a\u0004\u0008\u001d\u0010\u001e\"\u0004\u0008\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\"\u0010#\u001a\u0004\u0008$\u0010%\"\u0004\u0008&\u0010'R\"\u0010\u0012\u001a\u00020\u00118\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u0012\u0010(\u001a\u0004\u0008)\u0010*\"\u0004\u0008+\u0010,R\"\u0010-\u001a\u00020\u00048\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\u0008-\u0010.\u001a\u0004\u0008/\u00100\"\u0004\u00081\u00102R\"\u0010\u000f\u001a\u00020\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u000f\u00103\u001a\u0004\u00084\u00105\"\u0004\u00086\u00107R\"\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080.¢\u0006\u0012\n\u0004\u0008\u0003\u00108\u001a\u0004\u00089\u0010:\"\u0004\u0008;\u0010<R\u001c\u0010>\u001a\u00020=8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008>\u0010?\u001a\u0004\u0008@\u0010AR\"\u0010\u000c\u001a\u00020\u000b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u000c\u0010B\u001a\u0004\u0008C\u0010D\"\u0004\u0008E\u0010F¨\u0006I", d2 = {"Lokhttp3/internal/http2/Http2Connection$Builder;", "", "Ljava/net/Socket;", "socket", "", "peerName", "Ll/h;", "source", "Ll/g;", "sink", "(Ljava/net/Socket;Ljava/lang/String;Ll/h;Ll/g;)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "listener", "(Lokhttp3/internal/http2/Http2Connection$Listener;)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/PushObserver;", "pushObserver", "(Lokhttp3/internal/http2/PushObserver;)Lokhttp3/internal/http2/Http2Connection$Builder;", "", "pingIntervalMillis", "(I)Lokhttp3/internal/http2/Http2Connection$Builder;", "Lokhttp3/internal/http2/Http2Connection;", "build", "()Lokhttp3/internal/http2/Http2Connection;", "Ll/g;", "getSink$okhttp", "()Ll/g;", "setSink$okhttp", "(Ll/g;)V", "Ll/h;", "getSource$okhttp", "()Ll/h;", "setSource$okhttp", "(Ll/h;)V", "", "client", "Z", "getClient$okhttp", "()Z", "setClient$okhttp", "(Z)V", "I", "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "connectionName", "Ljava/lang/String;", "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "Lokhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "Lokhttp3/internal/concurrent/TaskRunner;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "<init>", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        private boolean client;
        public String connectionName;
        private okhttp3.internal.http2.Http2Connection.Listener listener;
        private int pingIntervalMillis;
        private okhttp3.internal.http2.PushObserver pushObserver;
        public g sink;
        public Socket socket;
        public h source;
        private final TaskRunner taskRunner;
        public Builder(boolean z, TaskRunner taskRunner2) {
            n.f(taskRunner2, "taskRunner");
            super();
            this.client = z;
            this.taskRunner = taskRunner2;
            this.listener = Http2Connection.Listener.REFUSE_INCOMING_STREAMS;
            this.pushObserver = PushObserver.CANCEL;
        }

        public static okhttp3.internal.http2.Http2Connection.Builder socket$default(okhttp3.internal.http2.Http2Connection.Builder http2Connection$Builder, Socket socket2, String string3, h h4, g g5, int i6, Object object7) {
            String obj2;
            h obj3;
            g obj4;
            if (i6 & 2 != 0) {
                obj2 = Util.peerName(socket2);
            }
            if (i6 & 4 != 0) {
                obj3 = q.d(q.m(socket2));
            }
            if (i6 &= 8 != 0) {
                obj4 = q.c(q.i(socket2));
            }
            return builder.socket(socket2, obj2, obj3, obj4);
        }

        public final okhttp3.internal.http2.Http2Connection build() {
            Http2Connection http2Connection = new Http2Connection(this);
            return http2Connection;
        }

        public final boolean getClient$okhttp() {
            return this.client;
        }

        public final String getConnectionName$okhttp() {
            String connectionName = this.connectionName;
            if (connectionName == null) {
            } else {
                return connectionName;
            }
            n.w("connectionName");
            throw 0;
        }

        public final okhttp3.internal.http2.Http2Connection.Listener getListener$okhttp() {
            return this.listener;
        }

        public final int getPingIntervalMillis$okhttp() {
            return this.pingIntervalMillis;
        }

        public final okhttp3.internal.http2.PushObserver getPushObserver$okhttp() {
            return this.pushObserver;
        }

        public final g getSink$okhttp() {
            g sink = this.sink;
            if (sink == null) {
            } else {
                return sink;
            }
            n.w("sink");
            throw 0;
        }

        public final Socket getSocket$okhttp() {
            Socket socket = this.socket;
            if (socket == null) {
            } else {
                return socket;
            }
            n.w("socket");
            throw 0;
        }

        public final h getSource$okhttp() {
            h source = this.source;
            if (source == null) {
            } else {
                return source;
            }
            n.w("source");
            throw 0;
        }

        public final TaskRunner getTaskRunner$okhttp() {
            return this.taskRunner;
        }

        public final okhttp3.internal.http2.Http2Connection.Builder listener(okhttp3.internal.http2.Http2Connection.Listener http2Connection$Listener) {
            n.f(listener, "listener");
            this.listener = listener;
            return this;
        }

        public final okhttp3.internal.http2.Http2Connection.Builder pingIntervalMillis(int i) {
            this.pingIntervalMillis = i;
            return this;
        }

        public final okhttp3.internal.http2.Http2Connection.Builder pushObserver(okhttp3.internal.http2.PushObserver pushObserver) {
            n.f(pushObserver, "pushObserver");
            this.pushObserver = pushObserver;
            return this;
        }

        public final void setClient$okhttp(boolean z) {
            this.client = z;
        }

        public final void setConnectionName$okhttp(String string) {
            n.f(string, "<set-?>");
            this.connectionName = string;
        }

        public final void setListener$okhttp(okhttp3.internal.http2.Http2Connection.Listener http2Connection$Listener) {
            n.f(listener, "<set-?>");
            this.listener = listener;
        }

        public final void setPingIntervalMillis$okhttp(int i) {
            this.pingIntervalMillis = i;
        }

        public final void setPushObserver$okhttp(okhttp3.internal.http2.PushObserver pushObserver) {
            n.f(pushObserver, "<set-?>");
            this.pushObserver = pushObserver;
        }

        public final void setSink$okhttp(g g) {
            n.f(g, "<set-?>");
            this.sink = g;
        }

        public final void setSocket$okhttp(Socket socket) {
            n.f(socket, "<set-?>");
            this.socket = socket;
        }

        public final void setSource$okhttp(h h) {
            n.f(h, "<set-?>");
            this.source = h;
        }

        public final okhttp3.internal.http2.Http2Connection.Builder socket(Socket socket) {
            return Http2Connection.Builder.socket$default(this, socket, 0, 0, 0, 14, 0);
        }

        public final okhttp3.internal.http2.Http2Connection.Builder socket(Socket socket, String string2) {
            return Http2Connection.Builder.socket$default(this, socket, string2, 0, 0, 12, 0);
        }

        public final okhttp3.internal.http2.Http2Connection.Builder socket(Socket socket, String string2, h h3) {
            return Http2Connection.Builder.socket$default(this, socket, string2, h3, 0, 8, 0);
        }

        public final okhttp3.internal.http2.Http2Connection.Builder socket(Socket socket, String string2, h h3, g g4) {
            int str;
            String obj2;
            n.f(socket, "socket");
            n.f(string2, "peerName");
            n.f(h3, "source");
            n.f(g4, "sink");
            this.socket = socket;
            if (this.client) {
                obj2 = new StringBuilder();
                obj2.append(Util.okHttpName);
                obj2.append(' ');
                obj2.append(string2);
                obj2 = obj2.toString();
            } else {
                obj2 = new StringBuilder();
                obj2.append("MockWebServer ");
                obj2.append(string2);
                obj2 = obj2.toString();
            }
            this.connectionName = obj2;
            this.source = h3;
            this.sink = g4;
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0008\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\tR\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\n\u0010\tR\u0016\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000b\u0010\tR\u0016\u0010\u000c\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000c\u0010\tR\u0016\u0010\r\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\r\u0010\t¨\u0006\u0010", d2 = {"Lokhttp3/internal/http2/Http2Connection$Companion;", "", "Lokhttp3/internal/http2/Settings;", "DEFAULT_SETTINGS", "Lokhttp3/internal/http2/Settings;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "", "AWAIT_PING", "I", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.http2.Settings getDEFAULT_SETTINGS() {
            return Http2Connection.access$getDEFAULT_SETTINGS$cp();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008&\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0007¢\u0006\u0004\u0008\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\u0008\u000b\u0010\u000c¨\u0006\u0010", d2 = {"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "Lokhttp3/internal/http2/Http2Stream;", "stream", "Lkotlin/w;", "onStream", "(Lokhttp3/internal/http2/Http2Stream;)V", "Lokhttp3/internal/http2/Http2Connection;", "connection", "Lokhttp3/internal/http2/Settings;", "settings", "onSettings", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Settings;)V", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static abstract class Listener {

        public static final okhttp3.internal.http2.Http2Connection.Listener.Companion Companion;
        public static final okhttp3.internal.http2.Http2Connection.Listener REFUSE_INCOMING_STREAMS;
        static {
            Http2Connection.Listener.Companion companion = new Http2Connection.Listener.Companion(0);
            Http2Connection.Listener.Companion = companion;
            Http2Connection.Listener.Companion.REFUSE_INCOMING_STREAMS.1 anon = new Http2Connection.Listener.Companion.REFUSE_INCOMING_STREAMS.1();
            Http2Connection.Listener.REFUSE_INCOMING_STREAMS = anon;
        }

        public void onSettings(okhttp3.internal.http2.Http2Connection http2Connection, okhttp3.internal.http2.Settings settings2) {
            n.f(http2Connection, "connection");
            n.f(settings2, "settings");
        }

        public abstract void onStream(okhttp3.internal.http2.Http2Stream http2Stream);
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0002\u0008\u000c\n\u0002\u0010\u000e\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0086\u0004\u0018\u00002\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u0002B\u0011\u0008\u0000\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\u0008C\u0010DJ\u0010\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J/\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008\r\u0010\u000eJ5\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u00020\u00082\u000c\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\u0008\u0013\u0010\u0014J\u001f\u0010\u0017\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\u0008\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\u0008\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0003H\u0016¢\u0006\u0004\u0008\u001e\u0010\u0005J'\u0010\"\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00082\u0006\u0010!\u001a\u00020\u0008H\u0016¢\u0006\u0004\u0008\"\u0010#J'\u0010'\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00082\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\u0008'\u0010(J\u001f\u0010+\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\u0008+\u0010,J/\u00100\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010-\u001a\u00020\u00082\u0006\u0010.\u001a\u00020\u00082\u0006\u0010/\u001a\u00020\u0006H\u0016¢\u0006\u0004\u00080\u00101J-\u00104\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00082\u0006\u00102\u001a\u00020\u00082\u000c\u00103\u001a\u0008\u0012\u0004\u0012\u00020\u00110\u0010H\u0016¢\u0006\u0004\u00084\u00105J?\u0010<\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00082\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020%2\u0006\u00109\u001a\u0002062\u0006\u0010:\u001a\u00020\u00082\u0006\u0010;\u001a\u00020)H\u0016¢\u0006\u0004\u0008<\u0010=R\u001c\u0010?\u001a\u00020>8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008?\u0010@\u001a\u0004\u0008A\u0010B¨\u0006E", d2 = {"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "Lkotlin/Function0;", "Lkotlin/w;", "invoke", "()V", "", "inFinished", "", "streamId", "Ll/h;", "source", "length", "data", "(ZILl/h;I)V", "associatedStreamId", "", "Lokhttp3/internal/http2/Header;", "headerBlock", "headers", "(ZIILjava/util/List;)V", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "rstStream", "(ILokhttp3/internal/http2/ErrorCode;)V", "clearPrevious", "Lokhttp3/internal/http2/Settings;", "settings", "(ZLokhttp3/internal/http2/Settings;)V", "applyAndAckSettings", "ackSettings", "ack", "payload1", "payload2", "ping", "(ZII)V", "lastGoodStreamId", "Ll/i;", "debugData", "goAway", "(ILokhttp3/internal/http2/ErrorCode;Ll/i;)V", "", "windowSizeIncrement", "windowUpdate", "(IJ)V", "streamDependency", "weight", "exclusive", "priority", "(IIIZ)V", "promisedStreamId", "requestHeaders", "pushPromise", "(IILjava/util/List;)V", "", "origin", "protocol", "host", "port", "maxAge", "alternateService", "(ILjava/lang/String;Ll/i;Ljava/lang/String;IJ)V", "Lokhttp3/internal/http2/Http2Reader;", "reader", "Lokhttp3/internal/http2/Http2Reader;", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "<init>", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public final class ReaderRunnable implements okhttp3.internal.http2.Http2Reader.Handler, a<w> {

        private final okhttp3.internal.http2.Http2Reader reader;
        final okhttp3.internal.http2.Http2Connection this$0;
        public ReaderRunnable(okhttp3.internal.http2.Http2Connection http2Connection, okhttp3.internal.http2.Http2Reader http2Reader2) {
            n.f(http2Reader2, "reader");
            this.this$0 = http2Connection;
            super();
            this.reader = http2Reader2;
        }

        @Override // okhttp3.internal.http2.Http2Reader$Handler
        public void ackSettings() {
        }

        @Override // okhttp3.internal.http2.Http2Reader$Handler
        public void alternateService(int i, String string2, i i3, String string4, int i5, long l6) {
            n.f(string2, "origin");
            n.f(i3, "protocol");
            n.f(string4, "host");
        }

        @Override // okhttp3.internal.http2.Http2Reader$Handler
        public final void applyAndAckSettings(boolean z, okhttp3.internal.http2.Settings settings2) {
            okhttp3.internal.http2.Http2Writer writer;
            int empty;
            int array;
            Object element;
            Object length;
            Object settings;
            int arr;
            int i;
            w wVar;
            int i2;
            boolean z2;
            Object obj3;
            final Object obj2 = this;
            Object obj = settings2;
            n.f(obj, "settings");
            a0 a0Var2 = new a0();
            b0 b0Var3 = new b0();
            b0 b0Var4 = new b0();
            final okhttp3.internal.http2.Http2Writer writer2 = obj2.this$0.getWriter();
            okhttp3.internal.http2.Http2Connection this$010 = obj2.this$0;
            okhttp3.internal.http2.Settings peerSettings = obj2.this$0.getPeerSettings();
            synchronized (writer2) {
                settings = obj;
                b0Var4.element = settings;
                l -= l2;
                a0Var2.element = arr;
                int i4 = 0;
                if (Long.compare(arr, i5) != 0) {
                    if (obj2.this$0.getStreams$okhttp().isEmpty()) {
                    } else {
                        if (obj2.this$0.getStreams$okhttp().values().toArray(new Http2Stream[i4]) == null) {
                        } else {
                            b0Var3.element = array;
                            obj2.this$0.setPeerSettings((Settings)b0Var4.element);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(obj2.this$0.getConnectionName$okhttp());
                            stringBuilder.append(" onSettings");
                            String string = stringBuilder.toString();
                            final int i3 = 1;
                            i2 = i3;
                            super(string, i2, string, i3, this, b0Var4, z, settings2, a0Var2, b0Var3);
                            Http2Connection.access$getSettingsListenerQueue$p(obj2.this$0).schedule(anon, 0);
                            w wVar2 = w.a;
                            obj2.this$0.getWriter().applyAndAckSettings((Settings)b0Var4.element);
                        }
                    }
                    NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    throw nullPointerException;
                }
                array = 0;
            }
            w wVar3 = w.a;
            Object element2 = b0Var3.element;
            if ((Http2Stream[])element2 != null) {
                n.d((Http2Stream[])element2);
                z2 = i6;
                while (z2 < element2.length) {
                    i = element2[z2];
                    i.addBytesToWriteWindow(a0Var2.element);
                    i2 = w.a;
                    z2++;
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader$Handler
        public void data(boolean z, int i2, h h3, int i4) {
            boolean obj3;
            int obj4;
            n.f(h3, "source");
            if (this.this$0.pushedStream$okhttp(i2)) {
                this.this$0.pushDataLater$okhttp(i2, h3, i4, z);
            }
            okhttp3.internal.http2.Http2Stream stream = this.this$0.getStream(i2);
            if (stream == null) {
                this.this$0.writeSynResetLater$okhttp(i2, ErrorCode.PROTOCOL_ERROR);
                long l = (long)i4;
                this.this$0.updateConnectionFlowControl$okhttp(l);
                h3.skip(l);
            }
            stream.receiveData(h3, i4);
            if (z) {
                stream.receiveHeaders(Util.EMPTY_HEADERS, true);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader$Handler
        public final okhttp3.internal.http2.Http2Reader getReader$okhttp() {
            return this.reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader$Handler
        public void goAway(int i, okhttp3.internal.http2.ErrorCode errorCode2, i i3) {
            int i2;
            w wVar;
            int locallyInitiated;
            n.f(errorCode2, "errorCode");
            n.f(i3, "debugData");
            i3.A();
            okhttp3.internal.http2.Http2Connection obj5 = this.this$0;
            Object[] obj6 = this.this$0.getStreams$okhttp().values().toArray(new Http2Stream[0]);
            synchronized (obj5) {
                Http2Connection.access$setShutdown$p(this.this$0, true);
                wVar = w.a;
            }
            while (i2 < obj6.length) {
                wVar = (Http2Stream[])obj6[i2];
                if (wVar.getId() > i && wVar.isLocallyInitiated()) {
                }
                i2++;
                if (wVar.isLocallyInitiated()) {
                }
                wVar.receiveRstStream(ErrorCode.REFUSED_STREAM);
                this.this$0.removeStream$okhttp(wVar.getId());
            }
        }

        public void headers(boolean z, int i2, int i3, List<okhttp3.internal.http2.Header> list4) {
            final Object obj2 = this;
            boolean z2 = z;
            int i12 = i2;
            Object obj = list4;
            n.f(obj, "headerBlock");
            if (obj2.this$0.pushedStream$okhttp(i12)) {
                obj2.this$0.pushHeadersLater$okhttp(i12, obj, z2);
            }
            final okhttp3.internal.http2.Http2Connection this$012 = obj2.this$0;
            final okhttp3.internal.http2.Http2Stream stream3 = obj2.this$0.getStream(i12);
            synchronized (this$012) {
                if (Http2Connection.access$isShutdown$p(obj2.this$0)) {
                }
                if (i12 <= obj2.this$0.getLastGoodStreamId$okhttp()) {
                }
                if (i12 % 2 == nextStreamId$okhttp %= 2) {
                }
                super(i2, obj2.this$0, 0, z, Util.toHeaders(list4));
                obj2.this$0.setLastGoodStreamId$okhttp(i12);
                obj2.this$0.getStreams$okhttp().put(Integer.valueOf(i2), http2Stream);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(obj2.this$0.getConnectionName$okhttp());
                stringBuilder.append('[');
                stringBuilder.append(i12);
                stringBuilder.append("] onStream");
                String string = stringBuilder.toString();
                int i10 = 0;
                int i14 = 1;
                okhttp3.internal.http2.Http2Connection.ReaderRunnable.headers$$inlined.synchronized.lambda.1 reader = anon;
                super(string, i14, string, i14, http2Stream, this, stream3, i2, list4, z);
                Http2Connection.access$getTaskRunner$p(obj2.this$0).newQueue().schedule(anon, 0);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader$Handler
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // okhttp3.internal.http2.Http2Reader$Handler
        public void invoke() {
            okhttp3.internal.http2.ErrorCode cANCEL;
            Throwable th2;
            int i;
            okhttp3.internal.http2.Http2Connection this$0;
            okhttp3.internal.http2.Http2Reader nextFrame;
            okhttp3.internal.http2.ErrorCode nO_ERROR;
            Throwable th;
            okhttp3.internal.http2.ErrorCode iNTERNAL_ERROR = ErrorCode.INTERNAL_ERROR;
            this.reader.readConnectionPreface(this);
            while (this.reader.nextFrame(false, this) != null) {
            }
            try {
                this.this$0.close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, 0);
                this$0 = reader;
                this$0 = reader;
                okhttp3.internal.http2.ErrorCode reader = ErrorCode.PROTOCOL_ERROR;
                this$0 = this.this$0;
                this$0.close$okhttp(reader, reader, th2);
                Util.closeQuietly(this.reader);
                this.this$0.close$okhttp(this$0, reader, th2);
                reader = this.reader;
                Util.closeQuietly(reader);
                throw th;
            } catch (java.io.IOException ioException) {
            } catch (Throwable th1) {
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader$Handler
        public void ping(boolean z, int i2, int i3) {
            int i5;
            String str;
            int i4;
            long l;
            int i;
            String string;
            int i7;
            Object obj;
            int i8;
            int i6;
            okhttp3.internal.http2.Http2Connection.ReaderRunnable.ping$$inlined.execute.1 anon;
            Object obj12;
            w obj13;
            int obj14;
            if (z) {
                obj12 = this.this$0;
                i5 = 1;
                synchronized (obj12) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            obj13 = w.a;
                        } else {
                        }
                        obj13 = new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                        throw obj13;
                    }
                    obj13 = this.this$0;
                    Http2Connection.access$setDegradedPongsReceived$p(obj13, l3 += i5);
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.this$0.getConnectionName$okhttp());
                str = " ping";
                stringBuilder.append(str);
                string = stringBuilder.toString();
                i7 = 1;
                super(string, i7, string, i7, this, i2, i3);
                Http2Connection.access$getWriterQueue$p(this.this$0).schedule(anon, 0);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader$Handler
        public void priority(int i, int i2, int i3, boolean z4) {
        }

        public void pushPromise(int i, int i2, List<okhttp3.internal.http2.Header> list3) {
            n.f(list3, "requestHeaders");
            this.this$0.pushRequestLater$okhttp(i2, list3);
        }

        @Override // okhttp3.internal.http2.Http2Reader$Handler
        public void rstStream(int i, okhttp3.internal.http2.ErrorCode errorCode2) {
            n.f(errorCode2, "errorCode");
            if (this.this$0.pushedStream$okhttp(i)) {
                this.this$0.pushResetLater$okhttp(i, errorCode2);
            }
            final okhttp3.internal.http2.Http2Stream obj2 = this.this$0.removeStream$okhttp(i);
            if (obj2 != null) {
                obj2.receiveRstStream(errorCode2);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader$Handler
        public void settings(boolean z, okhttp3.internal.http2.Settings settings2) {
            n.f(settings2, "settings");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.this$0.getConnectionName$okhttp());
            stringBuilder.append(" applyAndAckSettings");
            final String string = stringBuilder.toString();
            final int i2 = 1;
            super(string, i2, string, i2, this, z, settings2);
            Http2Connection.access$getWriterQueue$p(this.this$0).schedule(anon, 0);
        }

        @Override // okhttp3.internal.http2.Http2Reader$Handler
        public void windowUpdate(int i, long l2) {
            okhttp3.internal.http2.Http2Connection this$0;
            int i2;
            Object obj4;
            int obj5;
            if (i == 0) {
                obj4 = this.this$0;
                this$0 = this.this$0;
                Http2Connection.access$setWriteBytesMaximum$p(this$0, writeBytesMaximum += l2);
                obj5 = this.this$0;
                synchronized (obj4) {
                    obj5.notifyAll();
                    obj5 = w.a;
                }
            }
            try {
                obj4 = this.this$0.getStream(i);
                if (obj4 != null) {
                }
                obj4.addBytesToWriteWindow(l2);
                obj5 = w.a;
                throw l2;
            } catch (Throwable th) {
            }
        }
    }
    static {
        Http2Connection.Companion companion = new Http2Connection.Companion(0);
        Http2Connection.Companion = companion;
        Settings settings = new Settings();
        settings.set(7, 65535);
        settings.set(5, 16384);
        Http2Connection.DEFAULT_SETTINGS = settings;
    }

    public Http2Connection(okhttp3.internal.http2.Http2Connection.Builder http2Connection$Builder) {
        int pingIntervalMillis$okhttp;
        boolean client$okhttp;
        okhttp3.internal.http2.Http2Reader http2Reader;
        int i;
        okhttp3.internal.http2.Http2Connection$$special$$inlined.schedule.1 connection;
        String str;
        String string;
        Object obj;
        long l;
        Object obj13;
        n.f(builder, "builder");
        super();
        boolean client$okhttp2 = builder.getClient$okhttp();
        this.client = client$okhttp2;
        this.listener = builder.getListener$okhttp();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.streams = linkedHashMap;
        String connectionName$okhttp = builder.getConnectionName$okhttp();
        this.connectionName = connectionName$okhttp;
        int i2 = builder.getClient$okhttp() ? 3 : i2;
        int i3 = 2;
        TaskRunner taskRunner$okhttp = builder.getTaskRunner$okhttp();
        this.taskRunner = taskRunner$okhttp;
        final TaskQueue queue2 = taskRunner$okhttp.newQueue();
        this.writerQueue = queue2;
        this.pushQueue = taskRunner$okhttp.newQueue();
        this.settingsListenerQueue = taskRunner$okhttp.newQueue();
        this.pushObserver = builder.getPushObserver$okhttp();
        Settings settings = new Settings();
        if (builder.getClient$okhttp()) {
            settings.set(7, 16777216);
        }
        w wVar = w.a;
        this.okHttpSettings = settings;
        okhttp3.internal.http2.Settings dEFAULT_SETTINGS = Http2Connection.DEFAULT_SETTINGS;
        this.peerSettings = dEFAULT_SETTINGS;
        long l2 = (long)initialWindowSize;
        this.socket = builder.getSocket$okhttp();
        Http2Writer http2Writer = new Http2Writer(builder.getSink$okhttp(), client$okhttp2);
        this.writer = http2Writer;
        h source$okhttp = builder.getSource$okhttp();
        http2Reader = new Http2Reader(source$okhttp, client$okhttp2);
        Http2Connection.ReaderRunnable readerRunnable = new Http2Connection.ReaderRunnable(this, http2Reader);
        this.readerRunnable = readerRunnable;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.currentPushRequests = linkedHashSet;
        if (builder.getPingIntervalMillis$okhttp() != 0) {
            http2Reader = TimeUnit.MILLISECONDS.toNanos((long)obj13);
            obj13 = new StringBuilder();
            obj13.append(connectionName$okhttp);
            obj13.append(" ping");
            string = obj13.toString();
            super(string, string, this, http2Reader, obj11);
            queue2.schedule(obj13, http2Reader);
        }
    }

    public static final void access$failConnection(okhttp3.internal.http2.Http2Connection http2Connection, IOException iOException2) {
        http2Connection.failConnection(iOException2);
    }

    public static final long access$getAwaitPongsReceived$p(okhttp3.internal.http2.Http2Connection http2Connection) {
        return http2Connection.awaitPongsReceived;
    }

    public static final Set access$getCurrentPushRequests$p(okhttp3.internal.http2.Http2Connection http2Connection) {
        return http2Connection.currentPushRequests;
    }

    public static final okhttp3.internal.http2.Settings access$getDEFAULT_SETTINGS$cp() {
        return Http2Connection.DEFAULT_SETTINGS;
    }

    public static final long access$getDegradedPongsReceived$p(okhttp3.internal.http2.Http2Connection http2Connection) {
        return http2Connection.degradedPongsReceived;
    }

    public static final long access$getIntervalPingsSent$p(okhttp3.internal.http2.Http2Connection http2Connection) {
        return http2Connection.intervalPingsSent;
    }

    public static final long access$getIntervalPongsReceived$p(okhttp3.internal.http2.Http2Connection http2Connection) {
        return http2Connection.intervalPongsReceived;
    }

    public static final okhttp3.internal.http2.PushObserver access$getPushObserver$p(okhttp3.internal.http2.Http2Connection http2Connection) {
        return http2Connection.pushObserver;
    }

    public static final TaskQueue access$getSettingsListenerQueue$p(okhttp3.internal.http2.Http2Connection http2Connection) {
        return http2Connection.settingsListenerQueue;
    }

    public static final TaskRunner access$getTaskRunner$p(okhttp3.internal.http2.Http2Connection http2Connection) {
        return http2Connection.taskRunner;
    }

    public static final long access$getWriteBytesMaximum$p(okhttp3.internal.http2.Http2Connection http2Connection) {
        return http2Connection.writeBytesMaximum;
    }

    public static final TaskQueue access$getWriterQueue$p(okhttp3.internal.http2.Http2Connection http2Connection) {
        return http2Connection.writerQueue;
    }

    public static final boolean access$isShutdown$p(okhttp3.internal.http2.Http2Connection http2Connection) {
        return http2Connection.isShutdown;
    }

    public static final void access$setAwaitPongsReceived$p(okhttp3.internal.http2.Http2Connection http2Connection, long l2) {
        http2Connection.awaitPongsReceived = l2;
    }

    public static final void access$setDegradedPongsReceived$p(okhttp3.internal.http2.Http2Connection http2Connection, long l2) {
        http2Connection.degradedPongsReceived = l2;
    }

    public static final void access$setIntervalPingsSent$p(okhttp3.internal.http2.Http2Connection http2Connection, long l2) {
        http2Connection.intervalPingsSent = l2;
    }

    public static final void access$setIntervalPongsReceived$p(okhttp3.internal.http2.Http2Connection http2Connection, long l2) {
        http2Connection.intervalPongsReceived = l2;
    }

    public static final void access$setShutdown$p(okhttp3.internal.http2.Http2Connection http2Connection, boolean z2) {
        http2Connection.isShutdown = z2;
    }

    public static final void access$setWriteBytesMaximum$p(okhttp3.internal.http2.Http2Connection http2Connection, long l2) {
        http2Connection.writeBytesMaximum = l2;
    }

    private final void failConnection(IOException iOException) {
        final okhttp3.internal.http2.ErrorCode pROTOCOL_ERROR = ErrorCode.PROTOCOL_ERROR;
        close$okhttp(pROTOCOL_ERROR, pROTOCOL_ERROR, iOException);
    }

    private final okhttp3.internal.http2.Http2Stream newStream(int i, List<okhttp3.internal.http2.Header> list2, boolean z3) {
        int rEFUSED_STREAM;
        int writer;
        long writeBytesTotal;
        boolean streams;
        w client;
        Object valueOf;
        long writeBytesMaximum;
        okhttp3.internal.http2.Http2Writer obj11;
        int obj13;
        final int i7 = z3 ^ 1;
        final okhttp3.internal.http2.Http2Writer writer2 = this.writer;
        synchronized (writer2) {
            shutdown(ErrorCode.REFUSED_STREAM);
            if (this.isShutdown) {
            } else {
                final int nextStreamId = this.nextStreamId;
                this.nextStreamId = nextStreamId + 2;
                super(nextStreamId, this, i7, 0, 0);
                writer = 1;
                if (z3 != 0 && Long.compare(writeBytesTotal, writeBytesMaximum) < 0) {
                    if (Long.compare(writeBytesTotal, writeBytesMaximum) < 0) {
                        if (Long.compare(writeBytesTotal, writeBytesMaximum) >= 0) {
                            try {
                            } catch (Throwable th) {
                            }
                            obj13 = writer;
                        } else {
                            try {
                                obj13 = 0;
                                obj13 = writer;
                                if (http2Stream.isOpen()) {
                                }
                                this.streams.put(Integer.valueOf(nextStreamId), http2Stream);
                                client = w.a;
                                if (i == 0) {
                                } else {
                                }
                                this.writer.headers(i7, nextStreamId, list2);
                                if (writer ^= client == 0) {
                                } else {
                                }
                                this.writer.pushPromise(i, nextStreamId, list2);
                                if (obj13 != null) {
                                }
                                this.writer.flush();
                                return http2Stream;
                                IllegalArgumentException obj12 = new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
                                throw obj12;
                                obj11 = new ConnectionShutdownException();
                                throw obj11;
                                throw i;
                                throw i;
                            }
                        }
                    } else {
                    }
                } else {
                }
            }
        }
    }

    public static void start$default(okhttp3.internal.http2.Http2Connection http2Connection, boolean z2, TaskRunner taskRunner3, int i4, Object object5) {
        int obj1;
        TaskRunner obj2;
        if (i4 & 1 != 0) {
            obj1 = 1;
        }
        if (i4 &= 2 != 0) {
            obj2 = TaskRunner.INSTANCE;
        }
        http2Connection.start(obj1, obj2);
    }

    @Override // java.io.Closeable
    public final void awaitPong() {
        Throwable cmp;
        long awaitPingsSent;
        synchronized (this) {
            try {
                while (Long.compare(awaitPongsReceived, awaitPingsSent) < 0) {
                    wait();
                }
                wait();
                throw cmp;
            }
        }
    }

    @Override // java.io.Closeable
    public void close() {
        close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, 0);
    }

    @Override // java.io.Closeable
    public final void close$okhttp(okhttp3.internal.http2.ErrorCode errorCode, okhttp3.internal.http2.ErrorCode errorCode2, IOException iOException3) {
        boolean assertionsEnabled;
        int streams;
        w length;
        int i;
        Object obj;
        int obj4;
        n.f(errorCode, "connectionCode");
        n.f(errorCode2, "streamCode");
        if (Util.assertionsEnabled) {
            if (Thread.holdsLock(this)) {
            } else {
            }
            StringBuilder obj5 = new StringBuilder();
            obj5.append("Thread ");
            Thread obj6 = Thread.currentThread();
            n.e(obj6, "Thread.currentThread()");
            obj5.append(obj6.getName());
            obj5.append(" MUST NOT hold lock on ");
            obj5.append(this);
            obj4 = new AssertionError(obj5.toString());
            throw obj4;
        }
        shutdown(errorCode);
        obj4 = 0;
        synchronized (this) {
            if (this.streams.values().toArray(new Http2Stream[0]) == null) {
            } else {
                this.streams.clear();
                length = w.a;
                if (obj4 != null) {
                }
                this.writer.close();
                this.socket.close();
                this.writerQueue.shutdown();
                this.pushQueue.shutdown();
                this.settingsListenerQueue.shutdown();
            }
            obj4 = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            throw obj4;
        }
        while (i < obj4.length) {
            obj4[i].close(errorCode2, iOException3);
            i++;
        }
    }

    @Override // java.io.Closeable
    public final void flush() {
        this.writer.flush();
    }

    @Override // java.io.Closeable
    public final boolean getClient$okhttp() {
        return this.client;
    }

    @Override // java.io.Closeable
    public final String getConnectionName$okhttp() {
        return this.connectionName;
    }

    @Override // java.io.Closeable
    public final int getLastGoodStreamId$okhttp() {
        return this.lastGoodStreamId;
    }

    @Override // java.io.Closeable
    public final okhttp3.internal.http2.Http2Connection.Listener getListener$okhttp() {
        return this.listener;
    }

    @Override // java.io.Closeable
    public final int getNextStreamId$okhttp() {
        return this.nextStreamId;
    }

    @Override // java.io.Closeable
    public final okhttp3.internal.http2.Settings getOkHttpSettings() {
        return this.okHttpSettings;
    }

    @Override // java.io.Closeable
    public final okhttp3.internal.http2.Settings getPeerSettings() {
        return this.peerSettings;
    }

    @Override // java.io.Closeable
    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    @Override // java.io.Closeable
    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    @Override // java.io.Closeable
    public final okhttp3.internal.http2.Http2Connection.ReaderRunnable getReaderRunnable() {
        return this.readerRunnable;
    }

    @Override // java.io.Closeable
    public final Socket getSocket$okhttp() {
        return this.socket;
    }

    @Override // java.io.Closeable
    public final okhttp3.internal.http2.Http2Stream getStream(int i) {
        return (Http2Stream)this.streams.get(Integer.valueOf(i));
        synchronized (this) {
            return (Http2Stream)this.streams.get(Integer.valueOf(i));
        }
    }

    public final Map<Integer, okhttp3.internal.http2.Http2Stream> getStreams$okhttp() {
        return this.streams;
    }

    @Override // java.io.Closeable
    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    @Override // java.io.Closeable
    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    @Override // java.io.Closeable
    public final okhttp3.internal.http2.Http2Writer getWriter() {
        return this.writer;
    }

    @Override // java.io.Closeable
    public final boolean isHealthy(long l) {
        long degradedPongsReceived;
        long obj7;
        final int i = 0;
        synchronized (this) {
            try {
                return i;
            }
            if (Long.compare(l, degradedPongsReceived) >= 0) {
                return i;
            }
            return 1;
        }
    }

    public final okhttp3.internal.http2.Http2Stream newStream(List<okhttp3.internal.http2.Header> list, boolean z2) {
        n.f(list, "requestHeaders");
        return newStream(0, list, z2);
    }

    @Override // java.io.Closeable
    public final int openStreamCount() {
        return this.streams.size();
        synchronized (this) {
            return this.streams.size();
        }
    }

    @Override // java.io.Closeable
    public final void pushDataLater$okhttp(int i, h h2, int i3, boolean z4) {
        n.f(h2, "source");
        f fVar = new f();
        long l = (long)i3;
        h2.V1(l);
        h2.read(fVar, l);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.connectionName);
        stringBuilder.append('[');
        stringBuilder.append(i);
        stringBuilder.append("] onData");
        final String string = stringBuilder.toString();
        final int i5 = 1;
        super(string, i5, string, i5, this, i, fVar, i3, z4);
        this.pushQueue.schedule(anon, 0);
    }

    public final void pushHeadersLater$okhttp(int i, List<okhttp3.internal.http2.Header> list2, boolean z3) {
        n.f(list2, "requestHeaders");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.connectionName);
        stringBuilder.append('[');
        stringBuilder.append(i);
        stringBuilder.append("] onHeaders");
        final String string = stringBuilder.toString();
        final int i4 = 1;
        super(string, i4, string, i4, this, i, list2, z3);
        this.pushQueue.schedule(anon, 0);
    }

    public final void pushRequestLater$okhttp(int i, List<okhttp3.internal.http2.Header> list2) {
        n.f(list2, "requestHeaders");
        synchronized (this) {
            writeSynResetLater$okhttp(i, ErrorCode.PROTOCOL_ERROR);
        }
    }

    @Override // java.io.Closeable
    public final void pushResetLater$okhttp(int i, okhttp3.internal.http2.ErrorCode errorCode2) {
        n.f(errorCode2, "errorCode");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.connectionName);
        stringBuilder.append('[');
        stringBuilder.append(i);
        stringBuilder.append("] onReset");
        final String string = stringBuilder.toString();
        final int i4 = 1;
        super(string, i4, string, i4, this, i, errorCode2);
        this.pushQueue.schedule(anon, 0);
    }

    public final okhttp3.internal.http2.Http2Stream pushStream(int i, List<okhttp3.internal.http2.Header> list2, boolean z3) {
        n.f(list2, "requestHeaders");
        if (client ^= 1 == 0) {
        } else {
            return newStream(i, list2, z3);
        }
        IllegalStateException obj2 = new IllegalStateException("Client cannot push requests.".toString());
        throw obj2;
    }

    @Override // java.io.Closeable
    public final boolean pushedStream$okhttp(int i) {
        int i2;
        int obj2;
        if (i != 0 && i &= i2 == 0) {
            if (i &= i2 == 0) {
            } else {
                i2 = 0;
            }
        } else {
        }
        return i2;
    }

    @Override // java.io.Closeable
    public final okhttp3.internal.http2.Http2Stream removeStream$okhttp(int i) {
        notifyAll();
        return (Http2Stream)this.streams.remove(Integer.valueOf(i));
        synchronized (this) {
            notifyAll();
            return (Http2Stream)this.streams.remove(Integer.valueOf(i));
        }
    }

    @Override // java.io.Closeable
    public final void sendDegradedPingLater$okhttp() {
        long degradedPingsSent = this.degradedPingsSent;
        synchronized (this) {
            try {
                this.degradedPingsSent = degradedPingsSent += i;
                this.degradedPongDeadlineNs = nanoTime += l;
                w wVar = w.a;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(this.connectionName);
                String str = " ping";
                stringBuilder.append(str);
                final String string = stringBuilder.toString();
                final int i7 = 1;
                super(string, i7, string, i7, this);
                this.writerQueue.schedule(anon, 0);
                throw th;
            }
        }
    }

    @Override // java.io.Closeable
    public final void setLastGoodStreamId$okhttp(int i) {
        this.lastGoodStreamId = i;
    }

    @Override // java.io.Closeable
    public final void setNextStreamId$okhttp(int i) {
        this.nextStreamId = i;
    }

    @Override // java.io.Closeable
    public final void setPeerSettings(okhttp3.internal.http2.Settings settings) {
        n.f(settings, "<set-?>");
        this.peerSettings = settings;
    }

    @Override // java.io.Closeable
    public final void setSettings(okhttp3.internal.http2.Settings settings) {
        n.f(settings, "settings");
        okhttp3.internal.http2.Http2Writer writer = this.writer;
        synchronized (writer) {
            this.okHttpSettings.merge(settings);
            w wVar = w.a;
            this.writer.settings(settings);
        }
    }

    @Override // java.io.Closeable
    public final void shutdown(okhttp3.internal.http2.ErrorCode errorCode) {
        n.f(errorCode, "statusCode");
        okhttp3.internal.http2.Http2Writer writer = this.writer;
        synchronized (writer) {
        }
    }

    @Override // java.io.Closeable
    public final void start() {
        final int i2 = 0;
        Http2Connection.start$default(this, false, i2, 3, i2);
    }

    @Override // java.io.Closeable
    public final void start(boolean z) {
        final int i = 0;
        Http2Connection.start$default(this, z, i, 2, i);
    }

    @Override // java.io.Closeable
    public final void start(boolean z, TaskRunner taskRunner2) {
        String str;
        okhttp3.internal.http2.Http2Writer writer;
        int i;
        long l;
        int obj9;
        n.f(taskRunner2, "taskRunner");
        this.writer.connectionPreface();
        this.writer.settings(this.okHttpSettings);
        obj9 = this.okHttpSettings.getInitialWindowSize();
        str = 65535;
        if (z != 0 && obj9 != str) {
            this.writer.connectionPreface();
            this.writer.settings(this.okHttpSettings);
            obj9 = this.okHttpSettings.getInitialWindowSize();
            str = 65535;
            if (obj9 != str) {
                this.writer.windowUpdate(0, (long)obj9);
            }
        }
        final String connectionName = this.connectionName;
        final int i3 = 1;
        super(this.readerRunnable, connectionName, i3, connectionName, i3);
        taskRunner2.newQueue().schedule(obj10, 0);
    }

    @Override // java.io.Closeable
    public final void updateConnectionFlowControl$okhttp(long l) {
        int obj3;
        readBytesTotal += l;
        this.readBytesTotal = i;
        i -= obj3;
        synchronized (this) {
            try {
                writeWindowUpdateLater$okhttp(0, i2);
                this.readBytesAcknowledged = obj3 += i2;
                throw l;
            }
        }
    }

    @Override // java.io.Closeable
    public final void writeData(int i, boolean z2, f f3, long l4) {
        int cmp2;
        int cmp;
        okhttp3.internal.http2.Http2Writer valueOf;
        int cmp3;
        long writeBytesMaximum;
        int obj12;
        final int i2 = 0;
        final int i4 = 0;
        if (Long.compare(l4, i2) == 0) {
            this.writer.data(z2, i, f3, i4);
        }
        while (Long.compare(obj12, i2) > 0) {
            long writeBytesTotal = this.writeBytesTotal;
            writeBytesMaximum = this.writeBytesMaximum;
            while (Long.compare(writeBytesTotal, writeBytesMaximum) >= 0) {
                wait();
                writeBytesTotal = this.writeBytesTotal;
                writeBytesMaximum = this.writeBytesMaximum;
            }
            cmp2 = Math.min((int)l, this.writer.maxDataLength());
            writeBytesMaximum = (long)cmp2;
            this.writeBytesTotal = writeBytesTotal2 += writeBytesMaximum;
            w wVar = w.a;
            if (z2 && Long.compare(obj12, i2) == 0) {
            } else {
            }
            cmp3 = i4;
            this.writer.data(cmp3, i, f3, cmp2);
            if (Long.compare(obj12, i2) == 0) {
            } else {
            }
            cmp3 = 1;
            wait();
        }
    }

    public final void writeHeaders$okhttp(int i, boolean z2, List<okhttp3.internal.http2.Header> list3) {
        n.f(list3, "alternating");
        this.writer.headers(z2, i, list3);
    }

    @Override // java.io.Closeable
    public final void writePing() {
        this.awaitPingsSent = awaitPingsSent += i4;
        writePing(false, 3, 1330343787);
        return;
        synchronized (this) {
            this.awaitPingsSent = awaitPingsSent += i4;
            writePing(false, 3, 1330343787);
        }
    }

    @Override // java.io.Closeable
    public final void writePing(boolean z, int i2, int i3) {
        boolean obj2;
        try {
            this.writer.ping(z, i2, i3);
            failConnection(z);
        }
    }

    @Override // java.io.Closeable
    public final void writePingAndAwaitPong() {
        writePing();
        awaitPong();
    }

    @Override // java.io.Closeable
    public final void writeSynReset$okhttp(int i, okhttp3.internal.http2.ErrorCode errorCode2) {
        n.f(errorCode2, "statusCode");
        this.writer.rstStream(i, errorCode2);
    }

    @Override // java.io.Closeable
    public final void writeSynResetLater$okhttp(int i, okhttp3.internal.http2.ErrorCode errorCode2) {
        n.f(errorCode2, "errorCode");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.connectionName);
        stringBuilder.append('[');
        stringBuilder.append(i);
        stringBuilder.append("] writeSynReset");
        final String string = stringBuilder.toString();
        final int i4 = 1;
        super(string, i4, string, i4, this, i, errorCode2);
        this.writerQueue.schedule(anon, 0);
    }

    @Override // java.io.Closeable
    public final void writeWindowUpdateLater$okhttp(int i, long l2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.connectionName);
        stringBuilder.append('[');
        stringBuilder.append(i);
        stringBuilder.append("] windowUpdate");
        final String string = stringBuilder.toString();
        final int i4 = 1;
        super(string, i4, string, i4, this, i, l2, obj11);
        this.writerQueue.schedule(anon, 0);
    }
}
