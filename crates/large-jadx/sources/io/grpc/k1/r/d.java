package io.grpc.k1.r;

import java.security.cert.CertificateParsingException;
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
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* compiled from: OkHostnameVerifier.java */
/* loaded from: classes3.dex */
public final class d implements HostnameVerifier {

    public static final d a = new d();
    private static final Pattern b;
    static {
        d.b = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    private d() {
        super();
    }

    private static List<String> a(X509Certificate x509Certificate, int i) {
        int value = 1;
        final ArrayList arrayList = new ArrayList();
        try {
            Collection subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            Iterator it = subjectAlternativeNames.iterator();
            Object item = it.next();
            i = 2;
            Object item2 = item.get(0);
            value = 1;
            item = item.get(value);
            arrayList.add(item);
        } catch (java.security.cert.CertificateParsingException unused) {
            x509Certificate = Collections.emptyList();
            return x509Certificate;
        }
        return arrayList;
    }

    static boolean c(String str) {
        return d.b.matcher(str).matches();
    }

    private boolean d(String str, String str2) {
        String str3;
        String str4;
        final boolean z = false;
        return false;
    }

    private boolean e(String str, X509Certificate x509Certificate) {
        int i;
        String str3 = str.toLowerCase(Locale.US);
        List list = d.a(x509Certificate, 2);
        i = 1;
        i = 0;
        while (i < list.size()) {
            if (d(str3, (String)list.get(i))) {
                return true;
            }
        }
        if (i == 0) {
            String str2 = new c(x509Certificate.getSubjectX500Principal()).b("cn");
            if (str2 != null) {
                return d(str3, str2);
            }
        }
        return false;
    }

    private boolean f(String str, X509Certificate x509Certificate) {
        int i;
        final List list = d.a(x509Certificate, 7);
        i = 0;
        while (i < list.size()) {
            if (str.equalsIgnoreCase((String)list.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean b(String str, X509Certificate x509Certificate) {
        boolean z;
        if (d.c(str)) {
            z = f(str, x509Certificate);
        } else {
            z = e(str, x509Certificate);
        }
        return z;
    }

    public boolean verify(String str, SSLSession sSLSession) throws javax.net.ssl.SSLPeerUnverifiedException {
        try {
        } catch (javax.net.ssl.SSLException unused) {
            return z;
        }
        return b(str, (X509Certificate)sSLSession.getPeerCertificates()[0]);
    }
}
