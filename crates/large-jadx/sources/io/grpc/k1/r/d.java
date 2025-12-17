package io.grpc.k1.r;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: classes3.dex */
public final class d implements HostnameVerifier {

    public static final io.grpc.k1.r.d a;
    private static final Pattern b;
    static {
        d dVar = new d();
        d.a = dVar;
        d.b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    private static List<String> a(X509Certificate x509Certificate, int i2) {
        Object next;
        int intValue;
        int i;
        ArrayList arrayList = new ArrayList();
        Collection obj4 = x509Certificate.getSubjectAlternativeNames();
        if (obj4 == null) {
            return Collections.emptyList();
        }
        obj4 = obj4.iterator();
        while (obj4.hasNext()) {
            next = obj4.next();
            if ((List)next != null) {
            }
            if ((List)next.size() < 2) {
            } else {
            }
            intValue = next.get(0);
            if ((Integer)intValue == null) {
            } else {
            }
            next = next.get(1);
            if ((Integer)intValue.intValue() == i2 && (String)next != null) {
            }
            next = next.get(1);
            if ((String)(String)next != null) {
            }
            arrayList.add((String)(String)next);
        }
        return arrayList;
    }

    static boolean c(String string) {
        return d.b.matcher(string).matches();
    }

    private boolean d(String string, String string2) {
        boolean stringBuilder;
        int i;
        int length;
        boolean stringBuilder2;
        boolean startsWith;
        boolean startsWith2;
        int i2;
        int i3;
        String obj8;
        String obj9;
        final int i4 = 0;
        length = ".";
        if (string != null && string.length() != 0 && !string.startsWith(length)) {
            if (string.length() != 0) {
                length = ".";
                if (!string.startsWith(length)) {
                    startsWith = "..";
                    if (string.endsWith(startsWith)) {
                    } else {
                        if (string2 != null && string2.length() != 0 && !string2.startsWith(length)) {
                            if (string2.length() != 0) {
                                if (!string2.startsWith(length)) {
                                    if (string2.endsWith(startsWith)) {
                                    } else {
                                        startsWith2 = 46;
                                        if (!string.endsWith(length)) {
                                            stringBuilder2 = new StringBuilder();
                                            stringBuilder2.append(string);
                                            stringBuilder2.append(startsWith2);
                                            obj8 = stringBuilder2.toString();
                                        }
                                        if (!string2.endsWith(length)) {
                                            stringBuilder = new StringBuilder();
                                            stringBuilder.append(string2);
                                            stringBuilder.append(startsWith2);
                                            obj9 = stringBuilder.toString();
                                        }
                                        obj9 = obj9.toLowerCase(Locale.US);
                                        if (!obj9.contains("*")) {
                                            return obj8.equals(obj9);
                                        }
                                        length = "*.";
                                        if (obj9.startsWith(length)) {
                                            i2 = 1;
                                            i3 = -1;
                                            if (obj9.indexOf(42, i2) != i3) {
                                            } else {
                                                if (obj8.length() < obj9.length()) {
                                                    return i4;
                                                }
                                                if (length.equals(obj9)) {
                                                    return i4;
                                                }
                                                obj9 = obj9.substring(i2);
                                                if (!obj8.endsWith(obj9)) {
                                                    return i4;
                                                }
                                                length2 -= obj9;
                                                if (i > 0 && obj8.lastIndexOf(startsWith2, i -= i2) != i3) {
                                                    if (obj8.lastIndexOf(startsWith2, i -= i2) != i3) {
                                                        return i4;
                                                    }
                                                }
                                            }
                                            return i2;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return i4;
    }

    private boolean e(String string, X509Certificate x509Certificate2) {
        Object cVar;
        int i2;
        int i;
        Object obj8;
        String obj7 = string.toLowerCase(Locale.US);
        cVar = d.a(x509Certificate2, 2);
        final int i4 = 1;
        final int i5 = 0;
        i = i2;
        while (i2 < cVar.size()) {
            i2++;
            i = i4;
        }
        cVar = new c(x509Certificate2.getSubjectX500Principal());
        obj8 = cVar.b("cn");
        if (i == 0 && obj8 != null) {
            cVar = new c(x509Certificate2.getSubjectX500Principal());
            obj8 = cVar.b("cn");
            if (obj8 != null) {
                return d(obj7, obj8);
            }
        }
        return i5;
    }

    private boolean f(String string, X509Certificate x509Certificate2) {
        int i;
        boolean equalsIgnoreCase;
        final List obj6 = d.a(x509Certificate2, 7);
        final int i3 = 0;
        i = i3;
        while (i < obj6.size()) {
            i++;
        }
        return i3;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean b(String string, X509Certificate x509Certificate2) {
        boolean obj2;
        if (d.c(string)) {
            obj2 = f(string, x509Certificate2);
        } else {
            obj2 = e(string, x509Certificate2);
        }
        return obj2;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String string, SSLSession sSLSession2) {
        return b(string, (X509Certificate)sSLSession2.getPeerCertificates()[0]);
    }
}
