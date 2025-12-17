package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.d0.d.n;
import l.f.a;
import l.i;
import l.i.a;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\t\n\u0002\u0008\u001c\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008,\u0010-J\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\u000c\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\u0008\u000c\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b¢\u0006\u0004\u0008\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0017\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0018\u0010\u0016R\u0016\u0010\u0019\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u0019\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u001a\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u001b\u0010\u0016R\u0016\u0010\u001c\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u001c\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u001d\u0010\u0016R\u0016\u0010\u001e\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u001e\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\u001f\u0010\u0016R\u0016\u0010 \u001a\u00020\u00128\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008 \u0010\u0014R\u0016\u0010!\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008!\u0010\u0016R\u0016\u0010\"\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008\"\u0010\u0016R\u0016\u0010#\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008#\u0010\u0016R\u0016\u0010$\u001a\u00020\u000b8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008$\u0010%R\u0016\u0010&\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008&\u0010\u0016R\u0016\u0010'\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008'\u0010\u0016R\u0016\u0010(\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008(\u0010\u0016R\u0016\u0010)\u001a\u00020\u00128\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008)\u0010\u0014R\u0016\u0010*\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008*\u0010\u0016R\u0016\u0010+\u001a\u00020\t8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008+\u0010\u0016¨\u0006.", d2 = {"Lokhttp3/internal/ws/WebSocketProtocol;", "", "Ll/f$a;", "cursor", "", "key", "Lkotlin/w;", "toggleMask", "(Ll/f$a;[B)V", "", "code", "", "closeCodeExceptionMessage", "(I)Ljava/lang/String;", "validateCloseCode", "(I)V", "acceptHeader", "(Ljava/lang/String;)Ljava/lang/String;", "", "CLOSE_MESSAGE_MAX", "J", "B1_MASK_LENGTH", "I", "OPCODE_CONTROL_CLOSE", "B0_FLAG_FIN", "PAYLOAD_LONG", "B0_FLAG_RSV3", "B0_MASK_OPCODE", "B1_FLAG_MASK", "CLOSE_CLIENT_GOING_AWAY", "B0_FLAG_RSV1", "OPCODE_CONTROL_PONG", "PAYLOAD_BYTE_MAX", "PAYLOAD_SHORT", "OPCODE_TEXT", "B0_FLAG_RSV2", "ACCEPT_MAGIC", "Ljava/lang/String;", "CLOSE_NO_STATUS_CODE", "OPCODE_BINARY", "OPCODE_CONTINUATION", "PAYLOAD_SHORT_MAX", "OPCODE_FLAG_CONTROL", "OPCODE_CONTROL_PING", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class WebSocketProtocol {

    public static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    public static final int B0_FLAG_FIN = 128;
    public static final int B0_FLAG_RSV1 = 64;
    public static final int B0_FLAG_RSV2 = 32;
    public static final int B0_FLAG_RSV3 = 16;
    public static final int B0_MASK_OPCODE = 15;
    public static final int B1_FLAG_MASK = 128;
    public static final int B1_MASK_LENGTH = 127;
    public static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    public static final long CLOSE_MESSAGE_MAX = 123L;
    public static final int CLOSE_NO_STATUS_CODE = 1005;
    public static final okhttp3.internal.ws.WebSocketProtocol INSTANCE = null;
    public static final int OPCODE_BINARY = 2;
    public static final int OPCODE_CONTINUATION = 0;
    public static final int OPCODE_CONTROL_CLOSE = 8;
    public static final int OPCODE_CONTROL_PING = 9;
    public static final int OPCODE_CONTROL_PONG = 10;
    public static final int OPCODE_FLAG_CONTROL = 8;
    public static final int OPCODE_TEXT = 1;
    public static final long PAYLOAD_BYTE_MAX = 125L;
    public static final int PAYLOAD_LONG = 127;
    public static final int PAYLOAD_SHORT = 126;
    public static final long PAYLOAD_SHORT_MAX = 65535L;
    static {
        WebSocketProtocol webSocketProtocol = new WebSocketProtocol();
        WebSocketProtocol.INSTANCE = webSocketProtocol;
    }

    public final String acceptHeader(String string) {
        n.f(string, "key");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
        return i.v.d(stringBuilder.toString()).y().a();
    }

    public final String closeCodeExceptionMessage(int i) {
        StringBuilder stringBuilder;
        int i2;
        String str;
        String obj3;
        if (i >= 1000) {
            if (i >= 5000) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Code must be in range [1000,5000): ");
                stringBuilder.append(i);
                obj3 = stringBuilder.toString();
            } else {
                if (1004 <= i) {
                    if (1006 < i) {
                        if (1015 > i) {
                            obj3 = 0;
                        } else {
                            if (2999 >= i) {
                                stringBuilder = new StringBuilder();
                                stringBuilder.append("Code ");
                                stringBuilder.append(i);
                                stringBuilder.append(" is reserved and may not be used.");
                                obj3 = stringBuilder.toString();
                            } else {
                            }
                        }
                    } else {
                    }
                } else {
                }
            }
        } else {
        }
        return obj3;
    }

    public final void toggleMask(f.a f$a, byte[] b2Arr2) {
        int i2;
        int i5;
        int i;
        int i4;
        int i3;
        byte b;
        byte b2;
        n.f(a, "cursor");
        n.f(b2Arr2, "key");
        i2 = 0;
        byte[] bArr = a.w;
        i4 = a.x;
        do {
            bArr = a.w;
            i4 = a.x;
            if (a.c() != -1) {
            }
            while (i4 < a.y) {
                i2 %= length;
                bArr[i4] = (byte)i7;
                i4++;
                i6++;
            }
            i2 %= length;
            bArr[i4] = (byte)i7;
            i4++;
            i6++;
        } while (bArr != null);
    }

    public final void validateCloseCode(int i) {
        int i2;
        String obj2 = closeCodeExceptionMessage(i);
        i2 = obj2 == null ? 1 : 0;
        if (i2 == 0) {
        } else {
        }
        n.d(obj2);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(obj2.toString());
        throw illegalArgumentException;
    }
}
