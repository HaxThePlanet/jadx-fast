package zendesk.core;

import android.os.Build.VERSION;
import f.g.c.a;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Collections;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.ConnectionSpec;
import okhttp3.ConnectionSpec.Builder;
import okhttp3.OkHttpClient.Builder;
import okhttp3.TlsVersion;

/* loaded from: classes3.dex */
class Tls12SocketFactory extends SSLSocketFactory {

    private static final String[] TLS_V12_ONLY;
    final SSLSocketFactory delegate;
    static {
        String[] strArr = new String[1];
        Tls12SocketFactory.TLS_V12_ONLY = strArr;
    }

    public Tls12SocketFactory(SSLSocketFactory sSLSocketFactory) {
        super();
        this.delegate = sSLSocketFactory;
    }

    public static OkHttpClient.Builder enableTls12OnPreLollipop(OkHttpClient.Builder okHttpClient$Builder) {
        Object singletonList;
        Object[] arr;
        String str;
        int tLS_1_3;
        TlsVersion tLS_1_2;
        int i;
        int sDK_INT = Build.VERSION.SDK_INT;
        arr = 1;
        str = "Tls12SocketFactory";
        tLS_1_3 = 0;
        if (sDK_INT >= 16 && sDK_INT < 21) {
            if (sDK_INT < 21) {
                SSLContext instance = SSLContext.getInstance("TLSv1.2");
                int i3 = 0;
                instance.init(i3, i3, i3);
                Tls12SocketFactory tls12SocketFactory = new Tls12SocketFactory(instance.getSocketFactory());
                builder.sslSocketFactory(tls12SocketFactory);
                ConnectionSpec.Builder builder2 = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS);
                TlsVersion[] arr4 = new TlsVersion[arr];
                arr4[tLS_1_3] = TlsVersion.TLS_1_2;
                builder.connectionSpecs(Collections.singletonList(builder2.tlsVersions(arr4).build()));
                a.b(str, "Applied TLS 1.2 patch", new Object[tLS_1_3]);
            } else {
                a.b(str, "Skipping TLS 1.2 patch", new Object[tLS_1_3]);
                ConnectionSpec.Builder builder3 = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS);
                str = new TlsVersion[2];
                str[tLS_1_3] = TlsVersion.TLS_1_2;
                str[arr] = TlsVersion.TLS_1_3;
                builder.connectionSpecs(Collections.singletonList(builder3.tlsVersions(str).build()));
            }
        } else {
        }
        return builder;
    }

    private static Socket patch(Socket socket) {
        boolean z;
        String[] tLS_V12_ONLY;
        if (socket instanceof SSLSocket) {
            (SSLSocket)socket.setEnabledProtocols(Tls12SocketFactory.TLS_V12_ONLY);
        }
        return socket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(String string, int i2) {
        return Tls12SocketFactory.patch(this.delegate.createSocket(string, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(String string, int i2, InetAddress inetAddress3, int i4) {
        return Tls12SocketFactory.patch(this.delegate.createSocket(string, i2, inetAddress3, i4));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) {
        return Tls12SocketFactory.patch(this.delegate.createSocket(inetAddress, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress3, int i4) {
        return Tls12SocketFactory.patch(this.delegate.createSocket(inetAddress, i2, inetAddress3, i4));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String string2, int i3, boolean z4) {
        return Tls12SocketFactory.patch(this.delegate.createSocket(socket, string2, i3, z4));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return this.delegate.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return this.delegate.getSupportedCipherSuites();
    }
}
