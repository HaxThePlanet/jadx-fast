package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import l.i;
import l.i.a;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\n\n\u0002\u0010\u0011\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0016\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008-\u0010.J5\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0004¢\u0006\u0004\u0008\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0004\u0008\u000c\u0010\rJ\u001d\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u0004¢\u0006\u0004\u0008\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0013\u0010\u0012R\u001c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0017\u0010\u0012R\u0016\u0010\u0018\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u0018\u0010\u0012R\u0016\u0010\u001a\u001a\u00020\u00198\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u001c\u0010\u0012R\u0016\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\u001d\u0010\u0012R\u001e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001e\u0010\u0016R\u001c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001f\u0010\u0016R\u0016\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008 \u0010\u0012R\u0016\u0010!\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008!\u0010\u0012R\u0016\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008\"\u0010\u0012R\u0016\u0010#\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008#\u0010\u0012R\u0016\u0010$\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008$\u0010\u0012R\u0016\u0010%\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008%\u0010\u0012R\u0016\u0010&\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008&\u0010\u0012R\u0016\u0010'\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008'\u0010\u0012R\u0016\u0010(\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008(\u0010\u0012R\u0016\u0010)\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008)\u0010\u0012R\u0016\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008*\u0010\u0012R\u0016\u0010+\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008+\u0010\u0012R\u0016\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\u0008,\u0010\u0012¨\u0006/", d2 = {"Lokhttp3/internal/http2/Http2;", "", "", "inbound", "", "streamId", "length", "type", "flags", "", "frameLog", "(ZIIII)Ljava/lang/String;", "formattedType$okhttp", "(I)Ljava/lang/String;", "formattedType", "formatFlags", "(II)Ljava/lang/String;", "FLAG_PADDED", "I", "FLAG_END_STREAM", "", "FRAME_NAMES", "[Ljava/lang/String;", "FLAG_NONE", "TYPE_WINDOW_UPDATE", "Ll/i;", "CONNECTION_PREFACE", "Ll/i;", "TYPE_DATA", "FLAG_END_HEADERS", "FLAGS", "BINARY", "TYPE_PRIORITY", "INITIAL_MAX_FRAME_SIZE", "TYPE_PUSH_PROMISE", "TYPE_HEADERS", "TYPE_GOAWAY", "FLAG_ACK", "FLAG_END_PUSH_PROMISE", "FLAG_COMPRESSED", "TYPE_CONTINUATION", "TYPE_RST_STREAM", "FLAG_PRIORITY", "TYPE_SETTINGS", "TYPE_PING", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Http2 {

    private static final String[] BINARY = null;
    public static final i CONNECTION_PREFACE = null;
    private static final String[] FLAGS = null;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_COMPRESSED = 32;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    private static final String[] FRAME_NAMES = null;
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final okhttp3.internal.http2.Http2 INSTANCE = null;
    public static final int TYPE_CONTINUATION = 9;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PING = 6;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_WINDOW_UPDATE = 8;
    static {
        int i2;
        int[] fLAGS2;
        int i;
        int i5;
        String str2;
        String str8;
        String str4;
        String str5;
        String format;
        String fLAGS;
        int i4;
        String str6;
        String str;
        String string;
        int fLAGS3;
        int i3;
        StringBuilder stringBuilder;
        String str3;
        String str7;
        Http2 http2 = new Http2();
        Http2.INSTANCE = http2;
        Http2.CONNECTION_PREFACE = i.v.d("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        Http2.FRAME_NAMES = /* result */;
        Http2.FLAGS = new String[64];
        int i7 = 256;
        String[] strArr3 = new String[i7];
        i = 0;
        i5 = i;
        int i9 = 1;
        while (i5 < i7) {
            Object[] arr = new Object[i9];
            String binaryString = Integer.toBinaryString(i5);
            n.e(binaryString, "Integer.toBinaryString(it)");
            arr[i] = binaryString;
            strArr3[i5] = l.F(Util.format("%8s", arr), ' ', '0', null, 4, 0);
            i5++;
            i9 = 1;
        }
        Http2.BINARY = strArr3;
        String[] fLAGS4 = Http2.FLAGS;
        fLAGS4[i] = "";
        fLAGS4[i9] = "END_STREAM";
        fLAGS2 = new int[i9];
        fLAGS2[i] = i9;
        int i10 = 8;
        fLAGS4[i10] = "PADDED";
        i2 = i;
        str8 = "|PADDED";
        while (i2 < i9) {
            int i14 = fLAGS2[i2];
            fLAGS = Http2.FLAGS;
            fLAGS[i14 | 8] = n.o(fLAGS[i14], str8);
            i2++;
            str8 = "|PADDED";
        }
        String[] fLAGS5 = Http2.FLAGS;
        fLAGS5[4] = "END_HEADERS";
        fLAGS5[32] = "PRIORITY";
        fLAGS5[36] = "END_HEADERS|PRIORITY";
        int i8 = 3;
        int[] iArr = new int[i8];
        iArr = new int[]{4, 32, 36};
        i4 = i;
        while (i4 < i8) {
            str6 = iArr[i4];
            str = i;
            while (str < i9) {
                int i15 = fLAGS2[str];
                fLAGS3 = Http2.FLAGS;
                int i16 = i15 | str6;
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(fLAGS3[i15]);
                str3 = "|";
                stringBuilder2.append(str3);
                stringBuilder2.append(fLAGS3[str6]);
                fLAGS3[i16] = stringBuilder2.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append(fLAGS3[i15]);
                stringBuilder.append(str3);
                stringBuilder.append(fLAGS3[str6]);
                stringBuilder.append(str8);
                fLAGS3[i16 |= i10] = stringBuilder.toString();
                str++;
            }
            i4++;
            i15 = fLAGS2[str];
            fLAGS3 = Http2.FLAGS;
            i16 = i15 | str6;
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(fLAGS3[i15]);
            str3 = "|";
            stringBuilder2.append(str3);
            stringBuilder2.append(fLAGS3[str6]);
            fLAGS3[i16] = stringBuilder2.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(fLAGS3[i15]);
            stringBuilder.append(str3);
            stringBuilder.append(fLAGS3[str6]);
            stringBuilder.append(str8);
            fLAGS3[i16 |= i10] = stringBuilder.toString();
            str++;
        }
        while (i < fLAGS6.length) {
            fLAGS2 = Http2.FLAGS;
            if (fLAGS2[i] == 0) {
            }
            i++;
            fLAGS2[i] = Http2.BINARY[i];
        }
    }

    public final String formatFlags(int i, int i2) {
        int i5;
        int i6;
        String str;
        int i8;
        String str2;
        String str4;
        String str3;
        int i7;
        int i4;
        int i3;
        String obj8;
        if (i2 == 0) {
            return "";
        }
        if (i != 2 && i != 3) {
            if (i != 3) {
                if (i != 4 && i != 6) {
                    if (i != 6) {
                        if (i != 7 && i != 8) {
                            if (i != 8) {
                                String[] fLAGS = Http2.FLAGS;
                                if (i2 < fLAGS.length) {
                                    n.d(fLAGS[i2]);
                                } else {
                                    str = Http2.BINARY[i2];
                                }
                                str2 = str;
                                if (i == 5 && i2 & 4 != 0) {
                                    if (i2 & 4 != 0) {
                                        str2 = l.G(str2, "HEADERS", "PUSH_PROMISE", false, 4, 0);
                                    } else {
                                        if (i == 0 && i2 & 32 != 0) {
                                            if (i2 & 32 != 0) {
                                                str2 = l.G(str2, "PRIORITY", "COMPRESSED", false, 4, 0);
                                            }
                                        }
                                    }
                                } else {
                                }
                                return str2;
                            }
                        }
                    } else {
                        obj8 = i2 == 1 ? "ACK" : obj8[i2];
                    }
                } else {
                }
                return obj8;
            }
        }
        return Http2.BINARY[i2];
    }

    public final String formattedType$okhttp(int i) {
        String[] fRAME_NAMES;
        int length;
        String obj3;
        fRAME_NAMES = Http2.FRAME_NAMES;
        if (i < fRAME_NAMES.length) {
            obj3 = fRAME_NAMES[i];
        } else {
            fRAME_NAMES = new Object[1];
            obj3 = Util.format("0x%02x", Integer.valueOf(i));
        }
        return obj3;
    }

    public final String frameLog(boolean z, int i2, int i3, int i4, int i5) {
        String obj3;
        obj3 = z ? "<<" : ">>";
        Object[] obj7 = new Object[5];
        return Util.format("%s 0x%08x %5d %-13s %s", obj3, Integer.valueOf(i2), Integer.valueOf(i3), formattedType$okhttp(i4), formatFlags(i4, i5));
    }
}
