package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.d0.d.n;
import okhttp3.internal.Util;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0011\u0018\u00002\u00020\u0001B{\u0012\u0006\u0010F\u001a\u000209\u0012\u0006\u0010G\u001a\u000202\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0008\u0010%\u001a\u0004\u0018\u00010\"\u0012\u0008\u0010)\u001a\u0004\u0018\u00010&\u0012\u0008\u0010-\u001a\u0004\u0018\u00010*\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0008\u0010!\u001a\u0004\u0018\u00010\u001e\u0012\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u000c\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\u0008H\u0010IJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\u0008\u0007\u0010\u0008J\u000f\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u000f\u0010\u0011\u001a\u00020\u000eH\u0007¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0015\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0012H\u0007¢\u0006\u0004\u0008\u0014\u0010\u0015J\u0015\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u0012H\u0007¢\u0006\u0004\u0008\u0018\u0010\u0015J\u000f\u0010\u001d\u001a\u00020\u001aH\u0007¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0011\u0010!\u001a\u0004\u0018\u00010\u001eH\u0007¢\u0006\u0004\u0008\u001f\u0010 J\u0011\u0010%\u001a\u0004\u0018\u00010\"H\u0007¢\u0006\u0004\u0008#\u0010$J\u0011\u0010)\u001a\u0004\u0018\u00010&H\u0007¢\u0006\u0004\u0008'\u0010(J\u0011\u0010-\u001a\u0004\u0018\u00010*H\u0007¢\u0006\u0004\u0008+\u0010,J\u001a\u00100\u001a\u00020/2\u0008\u0010.\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\u00080\u00101J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\u00083\u00104J\u0017\u00108\u001a\u00020/2\u0006\u00105\u001a\u00020\u0000H\u0000¢\u0006\u0004\u00086\u00107J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\u0008:\u0010;R\u0019\u0010\u001d\u001a\u00020\u001a8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u001d\u0010<\u001a\u0004\u0008\u001d\u0010\u001cR\u001b\u0010)\u001a\u0004\u0018\u00010&8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008)\u0010=\u001a\u0004\u0008)\u0010(R\u0019\u0010\u0011\u001a\u00020\u000e8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0011\u0010>\u001a\u0004\u0008\u0011\u0010\u0010R\u001f\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00170\u00128G@\u0006¢\u0006\u000c\n\u0004\u0008\u0019\u0010?\u001a\u0004\u0008\u0019\u0010\u0015R\u0019\u0010\u0005\u001a\u00020\u00028G@\u0006¢\u0006\u000c\n\u0004\u0008\u0005\u0010@\u001a\u0004\u0008\u0005\u0010\u0004R\u001b\u0010-\u001a\u0004\u0018\u00010*8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008-\u0010A\u001a\u0004\u0008-\u0010,R\u001b\u0010!\u001a\u0004\u0018\u00010\u001e8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008!\u0010B\u001a\u0004\u0008!\u0010 R\u0019\u0010\r\u001a\u00020\n8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\r\u0010C\u001a\u0004\u0008\r\u0010\u000cR\u001b\u0010%\u001a\u0004\u0018\u00010\"8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008%\u0010D\u001a\u0004\u0008%\u0010$R\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\t\u0010E\u001a\u0004\u0008\t\u0010\u0008R\u001f\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u00128G@\u0006¢\u0006\u000c\n\u0004\u0008\u0016\u0010?\u001a\u0004\u0008\u0016\u0010\u0015¨\u0006J", d2 = {"Lokhttp3/Address;", "", "Lokhttp3/HttpUrl;", "-deprecated_url", "()Lokhttp3/HttpUrl;", "url", "Lokhttp3/Dns;", "-deprecated_dns", "()Lokhttp3/Dns;", "dns", "Ljavax/net/SocketFactory;", "-deprecated_socketFactory", "()Ljavax/net/SocketFactory;", "socketFactory", "Lokhttp3/Authenticator;", "-deprecated_proxyAuthenticator", "()Lokhttp3/Authenticator;", "proxyAuthenticator", "", "Lokhttp3/Protocol;", "-deprecated_protocols", "()Ljava/util/List;", "protocols", "Lokhttp3/ConnectionSpec;", "-deprecated_connectionSpecs", "connectionSpecs", "Ljava/net/ProxySelector;", "-deprecated_proxySelector", "()Ljava/net/ProxySelector;", "proxySelector", "Ljava/net/Proxy;", "-deprecated_proxy", "()Ljava/net/Proxy;", "proxy", "Ljavax/net/ssl/SSLSocketFactory;", "-deprecated_sslSocketFactory", "()Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "Ljavax/net/ssl/HostnameVerifier;", "-deprecated_hostnameVerifier", "()Ljavax/net/ssl/HostnameVerifier;", "hostnameVerifier", "Lokhttp3/CertificatePinner;", "-deprecated_certificatePinner", "()Lokhttp3/CertificatePinner;", "certificatePinner", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "that", "equalsNonHost$okhttp", "(Lokhttp3/Address;)Z", "equalsNonHost", "", "toString", "()Ljava/lang/String;", "Ljava/net/ProxySelector;", "Ljavax/net/ssl/HostnameVerifier;", "Lokhttp3/Authenticator;", "Ljava/util/List;", "Lokhttp3/HttpUrl;", "Lokhttp3/CertificatePinner;", "Ljava/net/Proxy;", "Ljavax/net/SocketFactory;", "Ljavax/net/ssl/SSLSocketFactory;", "Lokhttp3/Dns;", "uriHost", "uriPort", "<init>", "(Ljava/lang/String;ILokhttp3/Dns;Ljavax/net/SocketFactory;Ljavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lokhttp3/CertificatePinner;Lokhttp3/Authenticator;Ljava/net/Proxy;Ljava/util/List;Ljava/util/List;Ljava/net/ProxySelector;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Address {

    private final okhttp3.CertificatePinner certificatePinner;
    private final List<okhttp3.ConnectionSpec> connectionSpecs;
    private final okhttp3.Dns dns;
    private final HostnameVerifier hostnameVerifier;
    private final List<okhttp3.Protocol> protocols;
    private final Proxy proxy;
    private final okhttp3.Authenticator proxyAuthenticator;
    private final ProxySelector proxySelector;
    private final SocketFactory socketFactory;
    private final SSLSocketFactory sslSocketFactory;
    private final okhttp3.HttpUrl url;
    public Address(String string, int i2, okhttp3.Dns dns3, SocketFactory socketFactory4, SSLSocketFactory sSLSocketFactory5, HostnameVerifier hostnameVerifier6, okhttp3.CertificatePinner certificatePinner7, okhttp3.Authenticator authenticator8, Proxy proxy9, List<? extends okhttp3.Protocol> list10, List<okhttp3.ConnectionSpec> list11, ProxySelector proxySelector12) {
        String obj5;
        n.f(string, "uriHost");
        n.f(dns3, "dns");
        n.f(socketFactory4, "socketFactory");
        n.f(authenticator8, "proxyAuthenticator");
        n.f(list10, "protocols");
        n.f(list11, "connectionSpecs");
        n.f(proxySelector12, "proxySelector");
        super();
        this.dns = dns3;
        this.socketFactory = socketFactory4;
        this.sslSocketFactory = sSLSocketFactory5;
        this.hostnameVerifier = hostnameVerifier6;
        this.certificatePinner = certificatePinner7;
        this.proxyAuthenticator = authenticator8;
        this.proxy = proxy9;
        this.proxySelector = proxySelector12;
        HttpUrl.Builder obj4 = new HttpUrl.Builder();
        obj5 = sSLSocketFactory5 != null ? "https" : "http";
        this.url = obj4.scheme(obj5).host(string).port(i2).build();
        this.protocols = Util.toImmutableList(list10);
        this.connectionSpecs = Util.toImmutableList(list11);
    }

    public final okhttp3.CertificatePinner -deprecated_certificatePinner() {
        return this.certificatePinner;
    }

    public final List<okhttp3.ConnectionSpec> -deprecated_connectionSpecs() {
        return this.connectionSpecs;
    }

    public final okhttp3.Dns -deprecated_dns() {
        return this.dns;
    }

    public final HostnameVerifier -deprecated_hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<okhttp3.Protocol> -deprecated_protocols() {
        return this.protocols;
    }

    public final Proxy -deprecated_proxy() {
        return this.proxy;
    }

    public final okhttp3.Authenticator -deprecated_proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector -deprecated_proxySelector() {
        return this.proxySelector;
    }

    public final SocketFactory -deprecated_socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory -deprecated_sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public final okhttp3.HttpUrl -deprecated_url() {
        return this.url;
    }

    public final okhttp3.CertificatePinner certificatePinner() {
        return this.certificatePinner;
    }

    public final List<okhttp3.ConnectionSpec> connectionSpecs() {
        return this.connectionSpecs;
    }

    public final okhttp3.Dns dns() {
        return this.dns;
    }

    public boolean equals(Object object) {
        boolean z;
        okhttp3.HttpUrl url;
        int obj3;
        if (object instanceof Address && n.b(this.url, object.url) && equalsNonHost$okhttp((Address)object)) {
            if (n.b(this.url, object.url)) {
                obj3 = equalsNonHost$okhttp((Address)object) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj3;
    }

    public final boolean equalsNonHost$okhttp(okhttp3.Address address) {
        boolean port;
        Object proxyAuthenticator;
        Object obj3;
        n.f(address, "that");
        if (n.b(this.dns, address.dns) && n.b(this.proxyAuthenticator, address.proxyAuthenticator) && n.b(this.protocols, address.protocols) && n.b(this.connectionSpecs, address.connectionSpecs) && n.b(this.proxySelector, address.proxySelector) && n.b(this.proxy, address.proxy) && n.b(this.sslSocketFactory, address.sslSocketFactory) && n.b(this.hostnameVerifier, address.hostnameVerifier) && n.b(this.certificatePinner, address.certificatePinner) && this.url.port() == address.url.port()) {
            if (n.b(this.proxyAuthenticator, address.proxyAuthenticator)) {
                if (n.b(this.protocols, address.protocols)) {
                    if (n.b(this.connectionSpecs, address.connectionSpecs)) {
                        if (n.b(this.proxySelector, address.proxySelector)) {
                            if (n.b(this.proxy, address.proxy)) {
                                if (n.b(this.sslSocketFactory, address.sslSocketFactory)) {
                                    if (n.b(this.hostnameVerifier, address.hostnameVerifier)) {
                                        if (n.b(this.certificatePinner, address.certificatePinner)) {
                                            obj3 = this.url.port() == address.url.port() ? 1 : 0;
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    public int hashCode() {
        return i29 += i10;
    }

    public final HostnameVerifier hostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final List<okhttp3.Protocol> protocols() {
        return this.protocols;
    }

    public final Proxy proxy() {
        return this.proxy;
    }

    public final okhttp3.Authenticator proxyAuthenticator() {
        return this.proxyAuthenticator;
    }

    public final ProxySelector proxySelector() {
        return this.proxySelector;
    }

    public final SocketFactory socketFactory() {
        return this.socketFactory;
    }

    public final SSLSocketFactory sslSocketFactory() {
        return this.sslSocketFactory;
    }

    public String toString() {
        StringBuilder stringBuilder;
        Object proxySelector;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Address{");
        stringBuilder2.append(this.url.host());
        stringBuilder2.append(':');
        stringBuilder2.append(this.url.port());
        stringBuilder2.append(", ");
        if (this.proxy != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("proxy=");
            proxySelector = this.proxy;
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append("proxySelector=");
            proxySelector = this.proxySelector;
        }
        stringBuilder.append(proxySelector);
        stringBuilder2.append(stringBuilder.toString());
        stringBuilder2.append("}");
        return stringBuilder2.toString();
    }

    public final okhttp3.HttpUrl url() {
        return this.url;
    }
}
