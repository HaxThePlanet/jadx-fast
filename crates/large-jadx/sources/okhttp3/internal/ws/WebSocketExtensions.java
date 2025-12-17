package okhttp3.internal.ws;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import okhttp3.Headers;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u000e\n\u0002\u0010\u000e\n\u0002\u0008\r\u0008\u0086\u0008\u0018\u0000 #2\u00020\u0001:\u0001#BG\u0012\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u0002\u0012\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0002\u0012\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0008\u0012\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0002\u0012\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0002¢\u0006\u0004\u0008!\u0010\"J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0008HÆ\u0003¢\u0006\u0004\u0008\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u000b\u0010\u0007J\u0012\u0010\u000c\u001a\u0004\u0018\u00010\u0008HÆ\u0003¢\u0006\u0004\u0008\u000c\u0010\nJ\u0010\u0010\r\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\r\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\u0008\u000e\u0010\u0007JP\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u000f\u001a\u00020\u00022\n\u0008\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00082\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00022\n\u0008\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00082\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00022\u0008\u0008\u0002\u0010\u0014\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0008HÖ\u0001¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u001a\u0010\u001d\u001a\u00020\u00022\u0008\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u001d\u0010\u001eR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0010\u0010\u001fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0012\u0010\u001fR\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u000f\u0010 R\u0016\u0010\u0014\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0014\u0010 R\u0016\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0011\u0010 R\u0016\u0010\u0013\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0013\u0010 ¨\u0006$", d2 = {"Lokhttp3/internal/ws/WebSocketExtensions;", "", "", "clientOriginated", "noContextTakeover", "(Z)Z", "component1", "()Z", "", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "perMessageDeflate", "clientMaxWindowBits", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "Z", "<init>", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class WebSocketExtensions {

    public static final okhttp3.internal.ws.WebSocketExtensions.Companion Companion = null;
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\n\u0010\u000bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0008\u001a\u00020\u00078\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u0008\u0010\t¨\u0006\u000c", d2 = {"Lokhttp3/internal/ws/WebSocketExtensions$Companion;", "", "Lokhttp3/Headers;", "responseHeaders", "Lokhttp3/internal/ws/WebSocketExtensions;", "parse", "(Lokhttp3/Headers;)Lokhttp3/internal/ws/WebSocketExtensions;", "", "HEADER_WEB_SOCKET_EXTENSION", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.ws.WebSocketExtensions parse(Headers headers) {
            int i10;
            Object trimSubstring;
            boolean z;
            int i4;
            boolean value;
            int i13;
            int i2;
            int i3;
            int i9;
            int i;
            int i14;
            String str;
            String trimSubstring2;
            int i5;
            int delimiterOffset$default;
            int i8;
            int i11;
            int i6;
            int i7;
            int i12;
            Object obj = headers;
            n.f(obj, "responseHeaders");
            i4 = 0;
            i13 = 0;
            i2 = 0;
            i3 = 0;
            i9 = 0;
            i = 0;
            i14 = 0;
            while (i4 < headers.size()) {
                i5 = 1;
                if (!l.x(obj.name(i4), "Sec-WebSocket-Extensions", i5)) {
                } else {
                }
                value = obj.value(i4);
                str = 0;
                while (str < value.length()) {
                    delimiterOffset$default = Util.delimiterOffset$default(value, ',', str, 0, 4, 0);
                    i8 = 59;
                    int delimiterOffset = Util.delimiterOffset(value, i8, str, delimiterOffset$default);
                    if (l.x(Util.trimSubstring(value, str, delimiterOffset), "permessage-deflate", i5)) {
                    } else {
                    }
                    str = i10;
                    i14 = i5;
                    if (i13 != 0) {
                    }
                    while (i10 < delimiterOffset$default) {
                        int delimiterOffset2 = Util.delimiterOffset(value, i8, i10, delimiterOffset$default);
                        int delimiterOffset3 = Util.delimiterOffset(value, '=', i10, delimiterOffset2);
                        trimSubstring = Util.trimSubstring(value, i10, delimiterOffset3);
                        if (delimiterOffset3 < delimiterOffset2) {
                        } else {
                        }
                        i13 = 0;
                        if (l.x(trimSubstring, "client_max_window_bits", i5)) {
                        } else {
                        }
                        if (l.x(trimSubstring, "client_no_context_takeover", i5)) {
                        } else {
                        }
                        if (l.x(trimSubstring, "server_max_window_bits", i5)) {
                        } else {
                        }
                        if (l.x(trimSubstring, "server_no_context_takeover", i5)) {
                        } else {
                        }
                        i14 = i5;
                        i10 = z;
                        if (i != 0) {
                        }
                        if (i13 != 0) {
                        }
                        i = i5;
                        i14 = i5;
                        i14 = i5;
                        if (i9 != 0) {
                        }
                        if (i13 != 0) {
                        } else {
                        }
                        i9 = 0;
                        if (i9 == null) {
                        }
                        i9 = trimSubstring;
                        i14 = i5;
                        if (i3 != 0) {
                        }
                        if (i13 != 0) {
                        }
                        i3 = i5;
                        i14 = i5;
                        i14 = i5;
                        if (i2 != 0) {
                        }
                        if (i13 != 0) {
                        } else {
                        }
                        i2 = 0;
                        if (i2 == 0) {
                        }
                        i2 = trimSubstring;
                        i14 = i5;
                        i13 = l.w0(Util.trimSubstring(value, delimiterOffset3++, delimiterOffset2), "\"");
                    }
                    str = i10;
                    i13 = i5;
                    delimiterOffset2 = Util.delimiterOffset(value, i8, i10, delimiterOffset$default);
                    delimiterOffset3 = Util.delimiterOffset(value, '=', i10, delimiterOffset2);
                    trimSubstring = Util.trimSubstring(value, i10, delimiterOffset3);
                    if (delimiterOffset3 < delimiterOffset2) {
                    } else {
                    }
                    i13 = 0;
                    if (l.x(trimSubstring, "client_max_window_bits", i5)) {
                    } else {
                    }
                    if (l.x(trimSubstring, "client_no_context_takeover", i5)) {
                    } else {
                    }
                    if (l.x(trimSubstring, "server_max_window_bits", i5)) {
                    } else {
                    }
                    if (l.x(trimSubstring, "server_no_context_takeover", i5)) {
                    } else {
                    }
                    i14 = i5;
                    i10 = z;
                    if (i != 0) {
                    }
                    if (i13 != 0) {
                    }
                    i = i5;
                    i14 = i5;
                    i14 = i5;
                    if (i9 != 0) {
                    }
                    if (i13 != 0) {
                    } else {
                    }
                    i9 = 0;
                    if (i9 == null) {
                    }
                    i9 = trimSubstring;
                    i14 = i5;
                    if (i3 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    i3 = i5;
                    i14 = i5;
                    i14 = i5;
                    if (i2 != 0) {
                    }
                    if (i13 != 0) {
                    } else {
                    }
                    i2 = 0;
                    if (i2 == 0) {
                    }
                    i2 = trimSubstring;
                    i14 = i5;
                    i13 = l.w0(Util.trimSubstring(value, delimiterOffset3++, delimiterOffset2), "\"");
                    i14 = i5;
                }
                i4++;
                delimiterOffset$default = Util.delimiterOffset$default(value, ',', str, 0, 4, 0);
                i8 = 59;
                delimiterOffset = Util.delimiterOffset(value, i8, str, delimiterOffset$default);
                if (l.x(Util.trimSubstring(value, str, delimiterOffset), "permessage-deflate", i5)) {
                } else {
                }
                str = i10;
                i14 = i5;
                if (i13 != 0) {
                }
                while (i10 < delimiterOffset$default) {
                    delimiterOffset2 = Util.delimiterOffset(value, i8, i10, delimiterOffset$default);
                    delimiterOffset3 = Util.delimiterOffset(value, '=', i10, delimiterOffset2);
                    trimSubstring = Util.trimSubstring(value, i10, delimiterOffset3);
                    if (delimiterOffset3 < delimiterOffset2) {
                    } else {
                    }
                    i13 = 0;
                    if (l.x(trimSubstring, "client_max_window_bits", i5)) {
                    } else {
                    }
                    if (l.x(trimSubstring, "client_no_context_takeover", i5)) {
                    } else {
                    }
                    if (l.x(trimSubstring, "server_max_window_bits", i5)) {
                    } else {
                    }
                    if (l.x(trimSubstring, "server_no_context_takeover", i5)) {
                    } else {
                    }
                    i14 = i5;
                    i10 = z;
                    if (i != 0) {
                    }
                    if (i13 != 0) {
                    }
                    i = i5;
                    i14 = i5;
                    i14 = i5;
                    if (i9 != 0) {
                    }
                    if (i13 != 0) {
                    } else {
                    }
                    i9 = 0;
                    if (i9 == null) {
                    }
                    i9 = trimSubstring;
                    i14 = i5;
                    if (i3 != 0) {
                    }
                    if (i13 != 0) {
                    }
                    i3 = i5;
                    i14 = i5;
                    i14 = i5;
                    if (i2 != 0) {
                    }
                    if (i13 != 0) {
                    } else {
                    }
                    i2 = 0;
                    if (i2 == 0) {
                    }
                    i2 = trimSubstring;
                    i14 = i5;
                    i13 = l.w0(Util.trimSubstring(value, delimiterOffset3++, delimiterOffset2), "\"");
                }
                str = i10;
                i13 = i5;
                delimiterOffset2 = Util.delimiterOffset(value, i8, i10, delimiterOffset$default);
                delimiterOffset3 = Util.delimiterOffset(value, '=', i10, delimiterOffset2);
                trimSubstring = Util.trimSubstring(value, i10, delimiterOffset3);
                if (delimiterOffset3 < delimiterOffset2) {
                } else {
                }
                i13 = 0;
                if (l.x(trimSubstring, "client_max_window_bits", i5)) {
                } else {
                }
                if (l.x(trimSubstring, "client_no_context_takeover", i5)) {
                } else {
                }
                if (l.x(trimSubstring, "server_max_window_bits", i5)) {
                } else {
                }
                if (l.x(trimSubstring, "server_no_context_takeover", i5)) {
                } else {
                }
                i14 = i5;
                i10 = z;
                if (i != 0) {
                }
                if (i13 != 0) {
                }
                i = i5;
                i14 = i5;
                i14 = i5;
                if (i9 != 0) {
                }
                if (i13 != 0) {
                } else {
                }
                i9 = 0;
                if (i9 == null) {
                }
                i9 = trimSubstring;
                i14 = i5;
                if (i3 != 0) {
                }
                if (i13 != 0) {
                }
                i3 = i5;
                i14 = i5;
                i14 = i5;
                if (i2 != 0) {
                }
                if (i13 != 0) {
                } else {
                }
                i2 = 0;
                if (i2 == 0) {
                }
                i2 = trimSubstring;
                i14 = i5;
                i13 = l.w0(Util.trimSubstring(value, delimiterOffset3++, delimiterOffset2), "\"");
                i14 = i5;
            }
            super(i13, i2, i3, i9, i, i14);
            return webSocketExtensions;
        }
    }
    static {
        WebSocketExtensions.Companion companion = new WebSocketExtensions.Companion(0);
        WebSocketExtensions.Companion = companion;
    }

    public WebSocketExtensions() {
        super(0, 0, 0, 0, 0, 0, 63, 0);
    }

    public WebSocketExtensions(boolean z, Integer integer2, boolean z3, Integer integer4, boolean z5, boolean z6) {
        super();
        this.perMessageDeflate = z;
        this.clientMaxWindowBits = integer2;
        this.clientNoContextTakeover = z3;
        this.serverMaxWindowBits = integer4;
        this.serverNoContextTakeover = z5;
        this.unknownValues = z6;
    }

    public WebSocketExtensions(boolean z, Integer integer2, boolean z3, Integer integer4, boolean z5, boolean z6, int i7, g g8) {
        int i2;
        int i4;
        int i;
        int i3;
        int obj12;
        int obj13;
        final int i5 = 0;
        obj13 = i7 & 1 != 0 ? i5 : z;
        i4 = i7 & 2 != 0 ? i2 : integer2;
        i = i7 & 4 != 0 ? i5 : z3;
        if (i7 & 8 != 0) {
        } else {
            i2 = integer4;
        }
        i3 = i7 & 16 != 0 ? i5 : z5;
        obj12 = i7 & 32 != 0 ? i5 : z6;
        super(obj13, i4, i, i2, i3, obj12);
    }

    public static okhttp3.internal.ws.WebSocketExtensions copy$default(okhttp3.internal.ws.WebSocketExtensions webSocketExtensions, boolean z2, Integer integer3, boolean z4, Integer integer5, boolean z6, boolean z7, int i8, Object object9) {
        boolean obj5;
        Integer obj6;
        boolean obj7;
        Integer obj8;
        boolean obj9;
        boolean obj10;
        if (i8 & 1 != 0) {
            obj5 = webSocketExtensions.perMessageDeflate;
        }
        if (i8 & 2 != 0) {
            obj6 = webSocketExtensions.clientMaxWindowBits;
        }
        if (i8 & 4 != 0) {
            obj7 = webSocketExtensions.clientNoContextTakeover;
        }
        if (i8 & 8 != 0) {
            obj8 = webSocketExtensions.serverMaxWindowBits;
        }
        if (i8 & 16 != 0) {
            obj9 = webSocketExtensions.serverNoContextTakeover;
        }
        if (i8 & 32 != 0) {
            obj10 = webSocketExtensions.unknownValues;
        }
        return webSocketExtensions.copy(obj5, obj6, obj7, obj8, obj9, obj10);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final okhttp3.internal.ws.WebSocketExtensions copy(boolean z, Integer integer2, boolean z3, Integer integer4, boolean z5, boolean z6) {
        super(z, integer2, z3, integer4, z5, z6);
        return webSocketExtensions;
    }

    public boolean equals(Object object) {
        boolean clientNoContextTakeover2;
        boolean clientNoContextTakeover;
        Object obj3;
        if (this != (WebSocketExtensions)object && object instanceof WebSocketExtensions && this.perMessageDeflate == object.perMessageDeflate && n.b(this.clientMaxWindowBits, object.clientMaxWindowBits) && this.clientNoContextTakeover == object.clientNoContextTakeover && n.b(this.serverMaxWindowBits, object.serverMaxWindowBits) && this.serverNoContextTakeover == object.serverNoContextTakeover && this.unknownValues == object.unknownValues) {
            if (object instanceof WebSocketExtensions) {
                if (this.perMessageDeflate == object.perMessageDeflate) {
                    if (n.b(this.clientMaxWindowBits, object.clientMaxWindowBits)) {
                        if (this.clientNoContextTakeover == object.clientNoContextTakeover) {
                            if (n.b(this.serverMaxWindowBits, object.serverMaxWindowBits)) {
                                if (this.serverNoContextTakeover == object.serverNoContextTakeover) {
                                    if (this.unknownValues == object.unknownValues) {
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public int hashCode() {
        boolean perMessageDeflate;
        int i2;
        int i3;
        boolean clientNoContextTakeover;
        boolean serverNoContextTakeover;
        int i;
        i2 = 1;
        if (this.perMessageDeflate) {
            perMessageDeflate = i2;
        }
        Integer clientMaxWindowBits = this.clientMaxWindowBits;
        if (clientMaxWindowBits != null) {
            i3 = clientMaxWindowBits.hashCode();
        } else {
            i3 = i;
        }
        if (this.clientNoContextTakeover) {
            clientNoContextTakeover = i2;
        }
        Integer serverMaxWindowBits = this.serverMaxWindowBits;
        if (serverMaxWindowBits != null) {
            i = serverMaxWindowBits.hashCode();
        }
        if (this.serverNoContextTakeover) {
            serverNoContextTakeover = i2;
        }
        boolean unknownValues = this.unknownValues;
        if (unknownValues) {
        } else {
            i2 = unknownValues;
        }
        return i12 += i2;
    }

    public final boolean noContextTakeover(boolean z) {
        boolean obj1;
        obj1 = z ? this.clientNoContextTakeover : this.serverNoContextTakeover;
        return obj1;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WebSocketExtensions(perMessageDeflate=");
        stringBuilder.append(this.perMessageDeflate);
        stringBuilder.append(", clientMaxWindowBits=");
        stringBuilder.append(this.clientMaxWindowBits);
        stringBuilder.append(", clientNoContextTakeover=");
        stringBuilder.append(this.clientNoContextTakeover);
        stringBuilder.append(", serverMaxWindowBits=");
        stringBuilder.append(this.serverMaxWindowBits);
        stringBuilder.append(", serverNoContextTakeover=");
        stringBuilder.append(this.serverNoContextTakeover);
        stringBuilder.append(", unknownValues=");
        stringBuilder.append(this.unknownValues);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
