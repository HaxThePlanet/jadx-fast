package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.n;
import l.d0;
import l.e0;
import l.f;
import l.f.a;
import l.h;
import l.i;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0012\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0018\u00002\u00020\u0001:\u00011B/\u0012\u0006\u0010\u000c\u001a\u00020\u000b\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010\u0014\u001a\u00020\u000b\u0012\u0006\u0010\u001b\u001a\u00020\u000b¢\u0006\u0004\u0008/\u00100J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0004J\u000f\u0010\u0008\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0008\u0010\u0004J\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\u0008\t\u0010\u0004J\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\n\u0010\u0004R\u0016\u0010\u000c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000c\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0014\u0010\rR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001b\u0010\rR\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u001c\u0010\rR\u0019\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\u001e\u0010\u001f\u001a\u0004\u0008 \u0010!R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008#\u0010$R\u0016\u0010%\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008%\u0010\u0013R\u0018\u0010'\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008'\u0010(R\u0016\u0010)\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008)\u0010\rR\u0016\u0010+\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008+\u0010,R\u0016\u0010-\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008-\u0010\rR\u0016\u0010.\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008.\u0010\r¨\u00062", d2 = {"Lokhttp3/internal/ws/WebSocketReader;", "Ljava/io/Closeable;", "Lkotlin/w;", "readHeader", "()V", "readControlFrame", "readMessageFrame", "readUntilNonControlFrame", "readMessage", "processNextFrame", "close", "", "isClient", "Z", "", "frameLength", "J", "Ll/f;", "messageFrameBuffer", "Ll/f;", "perMessageDeflate", "Lokhttp3/internal/ws/MessageInflater;", "messageInflater", "Lokhttp3/internal/ws/MessageInflater;", "", "opcode", "I", "noContextTakeover", "isControlFrame", "Ll/h;", "source", "Ll/h;", "getSource", "()Ll/h;", "", "maskKey", "[B", "controlFrameBuffer", "Ll/f$a;", "maskCursor", "Ll/f$a;", "readingCompressedMessage", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "frameCallback", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "closed", "isFinalFrame", "<init>", "(ZLl/h;Lokhttp3/internal/ws/WebSocketReader$FrameCallback;ZZ)V", "FrameCallback", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class WebSocketReader implements Closeable {

    private boolean closed;
    private final f controlFrameBuffer;
    private final okhttp3.internal.ws.WebSocketReader.FrameCallback frameCallback;
    private long frameLength;
    private final boolean isClient;
    private boolean isControlFrame;
    private boolean isFinalFrame;
    private final f.a maskCursor;
    private final byte[] maskKey;
    private final f messageFrameBuffer;
    private okhttp3.internal.ws.MessageInflater messageInflater;
    private final boolean noContextTakeover;
    private int opcode;
    private final boolean perMessageDeflate;
    private boolean readingCompressedMessage;
    private final h source;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008f\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0007H&¢\u0006\u0004\u0008\u0005\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\u0008\u000b\u0010\tJ\u0017\u0010\u000c\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\u0008\u000c\u0010\tJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0010\u0010\u0011¨\u0006\u0012", d2 = {"Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "", "", "text", "Lkotlin/w;", "onReadMessage", "(Ljava/lang/String;)V", "Ll/i;", "bytes", "(Ll/i;)V", "payload", "onReadPing", "onReadPong", "", "code", "reason", "onReadClose", "(ILjava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public interface FrameCallback {
        public abstract void onReadClose(int i, String string2);

        public abstract void onReadMessage(String string);

        public abstract void onReadMessage(i i);

        public abstract void onReadPing(i i);

        public abstract void onReadPong(i i);
    }
    public WebSocketReader(boolean z, h h2, okhttp3.internal.ws.WebSocketReader.FrameCallback webSocketReader$FrameCallback3, boolean z4, boolean z5) {
        f.a obj3;
        int obj4;
        n.f(h2, "source");
        n.f(frameCallback3, "frameCallback");
        super();
        this.isClient = z;
        this.source = h2;
        this.frameCallback = frameCallback3;
        this.perMessageDeflate = z4;
        this.noContextTakeover = z5;
        obj3 = new f();
        this.controlFrameBuffer = obj3;
        obj3 = new f();
        this.messageFrameBuffer = obj3;
        obj4 = z ? obj3 : new byte[obj4];
        this.maskKey = obj4;
        if (z) {
        } else {
            obj3 = new f.a();
        }
        this.maskCursor = obj3;
    }

    private final void readControlFrame() {
        long frameLength;
        okhttp3.internal.ws.WebSocketReader.FrameCallback frameCallback;
        short short;
        f.a maskCursor;
        Object str;
        int codeExceptionMessage;
        int maskKey;
        f controlFrameBuffer;
        int i;
        frameLength = this.frameLength;
        codeExceptionMessage = 0;
        this.source.k0(this.controlFrameBuffer, frameLength);
        if (Long.compare(frameLength, codeExceptionMessage) > 0 && !this.isClient) {
            this.source.k0(this.controlFrameBuffer, frameLength);
            if (!this.isClient) {
                f.a maskCursor3 = this.maskCursor;
                n.d(maskCursor3);
                this.controlFrameBuffer.E(maskCursor3);
                this.maskCursor.f(codeExceptionMessage);
                maskKey = this.maskKey;
                n.d(maskKey);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, maskKey);
                this.maskCursor.close();
            }
        }
        switch (opcode) {
            case 8:
                short = 1005;
                maskKey = this.controlFrameBuffer.size();
                str = this.controlFrameBuffer.r1();
                codeExceptionMessage = WebSocketProtocol.INSTANCE.closeCodeExceptionMessage(this.controlFrameBuffer.readShort());
                ProtocolException protocolException3 = new ProtocolException(codeExceptionMessage);
                throw protocolException3;
                str = "";
                this.frameCallback.onReadClose(short, str);
                this.closed = true;
                ProtocolException protocolException2 = new ProtocolException("Malformed close payload length of 1.");
                throw protocolException2;
            case 9:
                this.frameCallback.onReadPing(this.controlFrameBuffer.Y0());
                break;
            case 10:
                this.frameCallback.onReadPong(this.controlFrameBuffer.Y0());
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown control opcode: ");
                stringBuilder.append(Util.toHexString(this.opcode));
                ProtocolException protocolException = new ProtocolException(stringBuilder.toString());
                throw protocolException;
        }
    }

    private final void readHeader() {
        int i6;
        int i5;
        int i3;
        int cmp;
        boolean isControlFrame;
        int i7;
        int i;
        int maskKey;
        String str;
        long l;
        int i4;
        int i2;
        int i8;
        if (this.closed) {
        } else {
            this.source.timeout().clearTimeout();
            final int i19 = 255;
            int i18 = Util.and(this.source.readByte(), i19);
            this.source.timeout().timeout(this.source.timeout().timeoutNanos(), obj1);
            i6 = i18 & 15;
            this.opcode = i6;
            i4 = 0;
            int i20 = 1;
            i7 = i18 & 128 != 0 ? i20 : i4;
            this.isFinalFrame = i7;
            i2 = i18 & 8 != 0 ? i20 : i4;
            this.isControlFrame = i2;
            if (i2 != 0) {
                if (i7 == 0) {
                } else {
                }
                ProtocolException protocolException = new ProtocolException("Control frames must be final.");
                throw protocolException;
            }
            i = i18 & 64 != 0 ? i20 : i4;
            String str9 = "Unexpected rsv1 flag";
            if (i6 != i20 && i6 != 2) {
                if (i6 != 2) {
                    if (i != 0) {
                    } else {
                        i5 = i18 & 32 != 0 ? i20 : i4;
                        if (i5 != 0) {
                        } else {
                            i3 = i18 & 16 != 0 ? i20 : i4;
                            if (i3 != 0) {
                            } else {
                                int i11 = Util.and(this.source.readByte(), i19);
                                if (i11 & 128 != 0) {
                                    i4 = i20;
                                }
                                if (i4 == this.isClient) {
                                    str = this.isClient ? "Server-sent frames must not be masked." : "Client-sent frames must be masked.";
                                    ProtocolException protocolException5 = new ProtocolException(str);
                                    throw protocolException5;
                                }
                                maskKey = 127;
                                l = (long)i12;
                                this.frameLength = l;
                                if (Long.compare(l, l3) == 0) {
                                    this.frameLength = (long)i14;
                                } else {
                                    if (Long.compare(l, l2) == 0) {
                                        long long = this.source.readLong();
                                        this.frameLength = long;
                                        if (Long.compare(long, l) < 0) {
                                        } else {
                                        }
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("Frame length 0x");
                                        stringBuilder.append(Util.toHexString(this.frameLength));
                                        stringBuilder.append(" > 0x7FFFFFFFFFFFFFFF");
                                        ProtocolException protocolException4 = new ProtocolException(stringBuilder.toString());
                                        throw protocolException4;
                                    }
                                }
                                if (this.isControlFrame) {
                                    if (Long.compare(frameLength, l) > 0) {
                                    } else {
                                    }
                                    ProtocolException protocolException3 = new ProtocolException("Control frame must be less than 125B.");
                                    throw protocolException3;
                                }
                                if (i4 != 0) {
                                    maskKey = this.maskKey;
                                    n.d(maskKey);
                                    this.source.readFully(maskKey);
                                }
                            }
                            ProtocolException protocolException2 = new ProtocolException("Unexpected rsv3 flag");
                            throw protocolException2;
                        }
                        ProtocolException protocolException6 = new ProtocolException("Unexpected rsv2 flag");
                        throw protocolException6;
                    }
                    ProtocolException protocolException7 = new ProtocolException(str9);
                    throw protocolException7;
                }
            }
            if (i != 0) {
                if (!this.perMessageDeflate) {
                } else {
                    i6 = i20;
                    this.readingCompressedMessage = i6;
                }
                ProtocolException protocolException8 = new ProtocolException(str9);
                throw protocolException8;
            }
            try {
                i6 = i4;
                this.readingCompressedMessage = i6;
                if (i18 & 32 != 0) {
                } else {
                }
                i5 = i20;
                i5 = i4;
                if (i18 & 16 != 0) {
                } else {
                }
                i3 = i20;
                i3 = i4;
                i11 = Util.and(this.source.readByte(), i19);
                if (i11 & 128 != 0) {
                }
                i4 = i20;
            }
        }
        IOException iOException = new IOException("closed");
        throw iOException;
    }

    private final void readMessage() {
        long frameLength;
        f.a maskCursor;
        int maskKey;
        f messageFrameBuffer;
        while (!this.closed) {
            frameLength = this.frameLength;
            maskKey = this.source;
            maskKey.k0(this.messageFrameBuffer, frameLength);
            if (Long.compare(frameLength, i2) > 0 && !this.isClient) {
            }
            readUntilNonControlFrame();
            maskKey = this.source;
            maskKey.k0(this.messageFrameBuffer, frameLength);
            if (!this.isClient) {
            }
            f.a maskCursor3 = this.maskCursor;
            n.d(maskCursor3);
            this.messageFrameBuffer.E(maskCursor3);
            this.maskCursor.f(size -= messageFrameBuffer);
            maskKey = this.maskKey;
            n.d(maskKey);
            WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, maskKey);
            this.maskCursor.close();
        }
        IOException iOException = new IOException("closed");
        throw iOException;
    }

    private final void readMessageFrame() {
        okhttp3.internal.ws.WebSocketReader.FrameCallback frameCallback;
        Object iVar;
        int i;
        boolean readingCompressedMessage;
        boolean messageFrameBuffer;
        int opcode = this.opcode;
        int i2 = 1;
        if (opcode != i2) {
            if (opcode != 2) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown opcode: ");
            stringBuilder.append(Util.toHexString(opcode));
            ProtocolException protocolException = new ProtocolException(stringBuilder.toString());
            throw protocolException;
        }
        readMessage();
        if (this.readingCompressedMessage) {
            if (this.messageInflater != null) {
            } else {
                readingCompressedMessage = new MessageInflater(this.noContextTakeover);
                this.messageInflater = readingCompressedMessage;
            }
            readingCompressedMessage.inflate(this.messageFrameBuffer);
        }
        if (opcode == i2) {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.r1());
        } else {
            this.frameCallback.onReadMessage(this.messageFrameBuffer.Y0());
        }
    }

    private final void readUntilNonControlFrame() {
        boolean isControlFrame;
        while (!this.closed) {
            readHeader();
            if (!this.isControlFrame) {
                break;
            } else {
            }
            readControlFrame();
        }
    }

    @Override // java.io.Closeable
    public void close() {
        final okhttp3.internal.ws.MessageInflater messageInflater = this.messageInflater;
        if (messageInflater != null) {
            messageInflater.close();
        }
    }

    @Override // java.io.Closeable
    public final h getSource() {
        return this.source;
    }

    @Override // java.io.Closeable
    public final void processNextFrame() {
        readHeader();
        if (this.isControlFrame) {
            readControlFrame();
        } else {
            readMessageFrame();
        }
    }
}
