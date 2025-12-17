package okhttp3.internal.tls;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.p;
import l.f0;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008Æ\u0002\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008 \u0010!J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\u0008\n\u0010\u0008J\u0013\u0010\u000b\u001a\u00020\u0002*\u00020\u0002H\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0013\u0010\r\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ#\u0010\n\u001a\u00020\u00062\u0008\u0010\t\u001a\u0004\u0018\u00010\u00022\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\u0008\n\u0010\u0010J%\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\u0008\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\u0008\u0019\u0010\u001aJ\u001d\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\u0008\u0019\u0010\u0008J\u001b\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\u0008\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\u0008\u001f\u0010\u001e¨\u0006\"", d2 = {"Lokhttp3/internal/tls/OkHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "", "ipAddress", "Ljava/security/cert/X509Certificate;", "certificate", "", "verifyIpAddress", "(Ljava/lang/String;Ljava/security/cert/X509Certificate;)Z", "hostname", "verifyHostname", "asciiToLowercase", "(Ljava/lang/String;)Ljava/lang/String;", "isAscii", "(Ljava/lang/String;)Z", "pattern", "(Ljava/lang/String;Ljava/lang/String;)Z", "", "type", "", "getSubjectAltNames", "(Ljava/security/cert/X509Certificate;I)Ljava/util/List;", "host", "Ljavax/net/ssl/SSLSession;", "session", "verify", "(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z", "allSubjectAltNames", "(Ljava/security/cert/X509Certificate;)Ljava/util/List;", "ALT_IPA_NAME", "I", "ALT_DNS_NAME", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class OkHostnameVerifier implements HostnameVerifier {

    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final okhttp3.internal.tls.OkHostnameVerifier INSTANCE;
    static {
        OkHostnameVerifier okHostnameVerifier = new OkHostnameVerifier();
        OkHostnameVerifier.INSTANCE = okHostnameVerifier;
    }

    private final String asciiToLowercase(String string) {
        boolean ascii;
        String str;
        String obj3;
        if (isAscii(string)) {
            Locale uS = Locale.US;
            n.e(uS, "Locale.US");
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            n.e(string.toLowerCase(uS), "(this as java.lang.String).toLowerCase(locale)");
        }
        return obj3;
    }

    private final List<String> getSubjectAltNames(X509Certificate x509Certificate, int i2) {
        Object next;
        int size;
        int i;
        try {
            Collection obj5 = x509Certificate.getSubjectAlternativeNames();
            if (obj5 != null) {
            }
            ArrayList arrayList = new ArrayList();
            obj5 = obj5.iterator();
            for (List next : obj5) {
                i = 1;
                next = next.get(i);
                arrayList.add((String)next);
            }
            next = obj5.next();
            if ((List)next != null) {
            } else {
            }
            if ((List)next.size() < 2) {
            } else {
            }
            i = 1;
            if (z ^= i != 0) {
            } else {
            }
            next = next.get(i);
            if (next != null) {
            } else {
            }
            if (next == null) {
            } else {
            }
            arrayList.add((String)next);
            obj5 = new NullPointerException("null cannot be cast to non-null type kotlin.String");
            throw obj5;
            return arrayList;
            return p.g();
            x509Certificate = p.g();
            return x509Certificate;
        }
    }

    private final boolean isAscii(String string) {
        int i;
        i = 0;
        if (string.length() == (int)l) {
            i = 1;
        }
        return i;
    }

    private final boolean verifyHostname(String string, String string2) {
        int str;
        int length2;
        int i7;
        int i;
        boolean stringBuilder;
        boolean str2;
        int length;
        int length3;
        int i4;
        int i6;
        int i2;
        int i5;
        int i3;
        String obj13;
        String obj14;
        final int i8 = 1;
        final int i9 = 0;
        if (string != null) {
            if (string.length() == 0) {
                str = i8;
            } else {
                str = i9;
            }
        } else {
        }
        str = ".";
        i7 = 2;
        i = 0;
        if (str == null && !l.M(string, str, i9, i7, i)) {
            str = ".";
            i7 = 2;
            i = 0;
            if (!l.M(string, str, i9, i7, i)) {
                str2 = "..";
                if (l.w(string, str2, i9, i7, i)) {
                } else {
                    if (string2 != null) {
                        if (string2.length() == 0) {
                            length = i8;
                        } else {
                            length = i9;
                        }
                    } else {
                    }
                    if (length == 0 && !l.M(string2, str, i9, i7, i)) {
                        if (!l.M(string2, str, i9, i7, i)) {
                            if (l.w(string2, str2, i9, i7, i)) {
                            } else {
                                if (!l.w(string, str, i9, i7, i)) {
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(string);
                                    stringBuilder.append(str);
                                    obj13 = stringBuilder.toString();
                                }
                                str2 = obj13;
                                if (!l.w(string2, str, i9, i7, i)) {
                                    obj13 = new StringBuilder();
                                    obj13.append(string2);
                                    obj13.append(str);
                                    obj14 = obj13.toString();
                                }
                                obj13 = asciiToLowercase(obj14);
                                if (!l.R(obj13, "*", i9, i7, i)) {
                                    return n.b(str2, obj13);
                                }
                                obj14 = "*.";
                                if (l.M(obj13, obj14, i9, i7, i)) {
                                    i3 = -1;
                                    if (l.d0(obj13, '*', 1, false, 4, 0) != i3) {
                                    } else {
                                        if (str2.length() < obj13.length()) {
                                            return i9;
                                        }
                                        if (n.b(obj14, obj13)) {
                                            return i9;
                                        }
                                        Objects.requireNonNull(obj13, "null cannot be cast to non-null type java.lang.String");
                                        obj13 = obj13.substring(i8);
                                        n.e(obj13, "(this as java.lang.String).substring(startIndex)");
                                        if (!l.w(str2, obj13, i9, i7, i)) {
                                            return i9;
                                        }
                                        obj14 -= obj13;
                                        if (obj14 > 0 && l.i0(str2, '.', obj14 + -1, false, 4, 0) != i3) {
                                            if (l.i0(str2, '.', obj14 + -1, false, 4, 0) != i3) {
                                                return i9;
                                            }
                                        }
                                    }
                                    return i8;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i9;
    }

    private final boolean verifyHostname(String string, X509Certificate x509Certificate2) {
        boolean verifyHostname;
        int i;
        okhttp3.internal.tls.OkHostnameVerifier iNSTANCE;
        Object obj5;
        obj5 = getSubjectAltNames(x509Certificate2, 2);
        i = 0;
        if (obj5 instanceof Collection != null && obj5.isEmpty()) {
            if (obj5.isEmpty()) {
            } else {
                obj5 = obj5.iterator();
                while (obj5.hasNext()) {
                    if (OkHostnameVerifier.INSTANCE.verifyHostname(asciiToLowercase(string), (String)obj5.next())) {
                        break;
                    } else {
                    }
                }
            }
        } else {
        }
        return i;
    }

    private final boolean verifyIpAddress(String string, X509Certificate x509Certificate2) {
        boolean empty;
        int i;
        Object obj4;
        obj4 = getSubjectAltNames(x509Certificate2, 7);
        i = 0;
        if (obj4 instanceof Collection != null && obj4.isEmpty()) {
            if (obj4.isEmpty()) {
            } else {
                obj4 = obj4.iterator();
                while (obj4.hasNext()) {
                    if (n.b(HostnamesKt.toCanonicalHost(string), HostnamesKt.toCanonicalHost((String)obj4.next()))) {
                        break;
                    } else {
                    }
                }
            }
        } else {
        }
        return i;
    }

    public final List<String> allSubjectAltNames(X509Certificate x509Certificate) {
        n.f(x509Certificate, "certificate");
        return p.t0(getSubjectAltNames(x509Certificate, 7), getSubjectAltNames(x509Certificate, 2));
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String string, X509Certificate x509Certificate2) {
        boolean obj2;
        n.f(string, "host");
        n.f(x509Certificate2, "certificate");
        if (Util.canParseAsIpAddress(string)) {
            obj2 = verifyIpAddress(string, x509Certificate2);
        } else {
            obj2 = verifyHostname(string, x509Certificate2);
        }
        return obj2;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String string, SSLSession sSLSession2) {
        int i;
        Object obj3;
        Object obj4;
        n.f(string, "host");
        n.f(sSLSession2, "session");
        if (!isAscii(string)) {
            return i;
        } else {
            obj4 = sSLSession2.getPeerCertificates()[0];
            if (obj4 == null) {
            } else {
                i = obj3;
            }
        }
        obj3 = new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        throw obj3;
    }
}
