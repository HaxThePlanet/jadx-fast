package okhttp3.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import l.f;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000(\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0012\n\u0002\u0008\u0007\u001a\u0013\u0010\u0001\u001a\u0004\u0018\u00010\u0000*\u00020\u0000¢\u0006\u0004\u0008\u0001\u0010\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0000H\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005\u001a)\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\u0008\u000b\u0010\u000c\u001a7\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\u0008\u0010\u0010\u0011\u001a\u0017\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013¨\u0006\u0014", d2 = {"", "toCanonicalHost", "(Ljava/lang/String;)Ljava/lang/String;", "", "containsInvalidHostnameAsciiCodes", "(Ljava/lang/String;)Z", "input", "", "pos", "limit", "Ljava/net/InetAddress;", "decodeIpv6", "(Ljava/lang/String;II)Ljava/net/InetAddress;", "", "address", "addressOffset", "decodeIpv4Suffix", "(Ljava/lang/String;II[BI)Z", "inet6AddressToAscii", "([B)Ljava/lang/String;", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String string) {
        int i3;
        int i8;
        int i6;
        int i7;
        int i2;
        int i5;
        int i9;
        int i;
        int i4;
        final int i10 = 0;
        i3 = i10;
        while (i3 < string.length()) {
            char charAt = string.charAt(i3);
            i4 = 1;
            i3++;
        }
        return i10;
    }

    private static final boolean decodeIpv4Suffix(String string, int i2, int i3, byte[] b4Arr4, int i5) {
        int i7;
        byte b;
        int i6;
        int i8;
        int charAt;
        int i9;
        char charAt2;
        int i4;
        int i;
        int obj8;
        i7 = i5;
        i6 = 0;
        while (obj8 < i3) {
            i8 = obj8;
            i9 = i6;
            while (i8 < i3) {
                charAt2 = string.charAt(i8);
                i4 = 48;
                i8++;
            }
            b4Arr4[i7] = (byte)i9;
            i7 = obj8;
            obj8 = i8;
            i6 = 0;
            charAt2 = string.charAt(i8);
            i4 = 48;
            i8++;
            obj8++;
        }
        if (i7 == i5 += 4) {
            i6 = 1;
        }
        return i6;
    }

    private static final InetAddress decodeIpv6(String string, int i2, int i3) {
        byte decodeIpv4Suffix;
        int i14;
        int hexDigit;
        byte b;
        int i4;
        int i11;
        int i9;
        int i10;
        int i;
        int i12;
        int i5;
        int i6;
        int i8;
        int i7;
        int i13;
        final String str4 = string;
        final int i23 = i3;
        i10 = 16;
        final byte[] bArr = new byte[i10];
        final int i25 = -1;
        i12 = i2;
        i8 = i6;
        i5 = 0;
        i7 = 0;
        while (i12 < i23) {
            i9 = i12 + 2;
            i8 = i12;
            i12 = i8;
            i14 = 0;
            while (i12 < i23) {
                hexDigit = Util.parseHexDigit(str4.charAt(i12));
                if (hexDigit == i25) {
                    break loop_21;
                } else {
                }
                i16 += hexDigit;
                i12++;
            }
            int i20 = i12 - i8;
            hexDigit = i5 + 1;
            bArr[i5] = (byte)i22;
            i5 = hexDigit + 1;
            bArr[hexDigit] = (byte)i17;
            i7 = 0;
            hexDigit = Util.parseHexDigit(str4.charAt(i12));
            if (hexDigit == i25) {
            } else {
            }
            i16 += hexDigit;
            i12++;
            i12++;
            i = i9;
            i5 += 2;
            i8 = i;
            i6 = i5;
        }
        if (i5 != i10 && i6 == i25) {
            if (i6 == i25) {
                return i7;
            }
            int i18 = i5 - i6;
            System.arraycopy(bArr, i6, bArr, i18 - 16, i18);
            Arrays.fill(bArr, i6, i24 += i6, (byte)i19);
        }
        return InetAddress.getByAddress(bArr);
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i2;
        int length;
        int i;
        byte b;
        byte b2;
        i4 = -1;
        i6 = i5;
        int i9 = 16;
        while (i5 < bArr.length) {
            i2 = i5;
            while (i2 < i9) {
                if (bArr[i2] == 0) {
                }
                if (bArr[i2 + 1] == 0) {
                }
                i2 += 2;
            }
            i = i2 - i5;
            if (i > i6 && i >= 4) {
            }
            i5 = i2 + 2;
            i9 = 16;
            if (i >= 4) {
            }
            i4 = i5;
            i6 = i;
            if (bArr[i2] == 0) {
            }
            if (bArr[i2 + 1] == 0) {
            }
            i2 += 2;
        }
        f fVar = new f();
        while (i3 < bArr.length) {
            length = 58;
            if (i3 == i4) {
            } else {
            }
            if (i3 > 0) {
            }
            int i10 = 255;
            b2 = bArr[i3 + 1];
            fVar.C0((long)length);
            i3 += 2;
            fVar.z0(length);
            fVar.z0(length);
            if (i3 += i6 == i9) {
            }
            fVar.z0(length);
        }
        return fVar.r1();
    }

    public static final String toCanonicalHost(String string) {
        boolean z;
        InetAddress decodeIpv6;
        int i2;
        int i;
        n.f(string, "$this$toCanonicalHost");
        i2 = 0;
        int i4 = 2;
        i = 0;
        final int i7 = 1;
        if (l.R(string, ":", i2, i4, i)) {
            if (l.M(string, "[", i2, i4, i) && l.w(string, "]", i2, i4, i)) {
                if (l.w(string, "]", i2, i4, i)) {
                    decodeIpv6 = HostnamesKt.decodeIpv6(string, i7, length3 -= i7);
                } else {
                    decodeIpv6 = HostnamesKt.decodeIpv6(string, i2, string.length());
                }
            } else {
            }
            byte[] address = decodeIpv6.getAddress();
            if (decodeIpv6 != null && address.length == 16) {
                address = decodeIpv6.getAddress();
                if (address.length == 16) {
                    n.e(address, "address");
                    return HostnamesKt.inet6AddressToAscii(address);
                }
                if (address.length != 4) {
                } else {
                    return decodeIpv6.getHostAddress();
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid IPv6 address: '");
                stringBuilder.append(string);
                stringBuilder.append('\'');
                AssertionError assertionError = new AssertionError(stringBuilder.toString());
                throw assertionError;
            }
            return i;
        }
        String obj5 = IDN.toASCII(string);
        n.e(obj5, "IDN.toASCII(host)");
        Locale uS = Locale.US;
        n.e(uS, "Locale.US");
        if (obj5 == null) {
        } else {
            obj5 = obj5.toLowerCase(uS);
            n.e(obj5, "(this as java.lang.String).toLowerCase(locale)");
            if (obj5.length() == 0) {
                i2 = i7;
            }
            if (i2 != 0) {
                return i;
            }
            if (HostnamesKt.containsInvalidHostnameAsciiCodes(obj5)) {
            } else {
                i = obj5;
            }
            return i;
        }
        obj5 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        throw obj5;
    }
}
