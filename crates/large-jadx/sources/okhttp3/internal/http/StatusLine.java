package okhttp3.internal.http;

import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import okhttp3.Protocol;
import okhttp3.Response;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\u0008\u001a\u00020\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0006\u0010\u0007R\u0016\u0010\u0008\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0008\u0010\tR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u000c¨\u0006\u0010", d2 = {"Lokhttp3/internal/http/StatusLine;", "", "", "toString", "()Ljava/lang/String;", "Lokhttp3/Protocol;", "protocol", "Lokhttp3/Protocol;", "message", "Ljava/lang/String;", "", "code", "I", "<init>", "(Lokhttp3/Protocol;ILjava/lang/String;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class StatusLine {

    public static final okhttp3.internal.http.StatusLine.Companion Companion = null;
    public static final int HTTP_CONTINUE = 100;
    public static final int HTTP_MISDIRECTED_REQUEST = 421;
    public static final int HTTP_PERM_REDIRECT = 308;
    public static final int HTTP_TEMP_REDIRECT = 307;
    public final int code;
    public final String message;
    public final Protocol protocol;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0008\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0004\u0008\t\u0010\nR\u0016\u0010\u000c\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000c\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000e\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u000f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0010\u0010\r¨\u0006\u0013", d2 = {"Lokhttp3/internal/http/StatusLine$Companion;", "", "Lokhttp3/Response;", "response", "Lokhttp3/internal/http/StatusLine;", "get", "(Lokhttp3/Response;)Lokhttp3/internal/http/StatusLine;", "", "statusLine", "parse", "(Ljava/lang/String;)Lokhttp3/internal/http/StatusLine;", "", "HTTP_CONTINUE", "I", "HTTP_MISDIRECTED_REQUEST", "HTTP_PERM_REDIRECT", "HTTP_TEMP_REDIRECT", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.http.StatusLine get(Response response) {
            n.f(response, "response");
            StatusLine statusLine = new StatusLine(response.protocol(), response.code(), response.message());
            return statusLine;
        }

        public final okhttp3.internal.http.StatusLine parse(String string) {
            Protocol hTTP_1_0;
            int charAt;
            int i2;
            String str;
            int i;
            String obj9;
            n.f(string, "statusLine");
            i2 = 0;
            int i6 = 2;
            int i7 = 0;
            final int i8 = 32;
            final int i9 = 4;
            final String str6 = "Unexpected status line: ";
            if (l.M(string, "HTTP/1.", i2, i6, i7)) {
                if (string.length() < 9) {
                } else {
                    if (string.charAt(8) != i8) {
                    } else {
                        charAt2 += -48;
                        if (i5 == 0) {
                            hTTP_1_0 = Protocol.HTTP_1_0;
                            str = i + 3;
                            if (string.length() < str) {
                            } else {
                                String substring = string.substring(i, str);
                                n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                if (string.length() > str) {
                                    if (string.charAt(str) != i8) {
                                    } else {
                                        n.e(string.substring(i += i9), "(this as java.lang.String).substring(startIndex)");
                                        StatusLine statusLine = new StatusLine(hTTP_1_0, Integer.parseInt(substring), obj9);
                                        return statusLine;
                                    }
                                    StringBuilder stringBuilder2 = new StringBuilder();
                                    stringBuilder2.append(str6);
                                    stringBuilder2.append(string);
                                    ProtocolException protocolException2 = new ProtocolException(stringBuilder2.toString());
                                    throw protocolException2;
                                }
                                obj9 = "";
                            }
                            StringBuilder stringBuilder3 = new StringBuilder();
                            stringBuilder3.append(str6);
                            stringBuilder3.append(string);
                            ProtocolException protocolException3 = new ProtocolException(stringBuilder3.toString());
                            throw protocolException3;
                        } else {
                            if (i5 != 1) {
                            } else {
                                hTTP_1_0 = Protocol.HTTP_1_1;
                            }
                        }
                        StringBuilder stringBuilder5 = new StringBuilder();
                        stringBuilder5.append(str6);
                        stringBuilder5.append(string);
                        ProtocolException protocolException5 = new ProtocolException(stringBuilder5.toString());
                        throw protocolException5;
                    }
                }
                StringBuilder stringBuilder6 = new StringBuilder();
                stringBuilder6.append(str6);
                stringBuilder6.append(string);
                ProtocolException protocolException6 = new ProtocolException(stringBuilder6.toString());
                throw protocolException6;
            }
            if (!l.M(string, "ICY ", i2, i6, i7)) {
            } else {
                hTTP_1_0 = Protocol.HTTP_1_0;
                i = i9;
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append(str6);
            stringBuilder4.append(string);
            ProtocolException protocolException4 = new ProtocolException(stringBuilder4.toString());
            throw protocolException4;
        }
    }
    static {
        StatusLine.Companion companion = new StatusLine.Companion(0);
        StatusLine.Companion = companion;
    }

    public StatusLine(Protocol protocol, int i2, String string3) {
        n.f(protocol, "protocol");
        n.f(string3, "message");
        super();
        this.protocol = protocol;
        this.code = i2;
        this.message = string3;
    }

    public String toString() {
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            stringBuilder.append("HTTP/1.0");
        } else {
            stringBuilder.append("HTTP/1.1");
        }
        int i = 32;
        stringBuilder.append(i);
        stringBuilder.append(this.code);
        stringBuilder.append(i);
        stringBuilder.append(this.message);
        String string = stringBuilder.toString();
        n.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
