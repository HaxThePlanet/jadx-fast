package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.d0.d.n;
import okhttp3.Protocol;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\u0008\u001a\u0010\u001bJ\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\t\u0010\nJ/\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u000b2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\u0008\u0011\u0010\u0012J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0013\u0010\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0018\u0010\u0019¨\u0006\u001d", d2 = {"Lokhttp3/internal/platform/android/DeferredSocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "getDelegate", "(Ljavax/net/ssl/SSLSocket;)Lokhttp3/internal/platform/android/SocketAdapter;", "", "isSupported", "()Z", "matchesSocket", "(Ljavax/net/ssl/SSLSocket;)Z", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/w;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "delegate", "Lokhttp3/internal/platform/android/SocketAdapter;", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "socketAdapterFactory", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "<init>", "(Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;)V", "Factory", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class DeferredSocketAdapter implements okhttp3.internal.platform.android.SocketAdapter {

    private okhttp3.internal.platform.android.SocketAdapter delegate;
    private final okhttp3.internal.platform.android.DeferredSocketAdapter.Factory socketAdapterFactory;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0017\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\u0008\u0008\u0010\t¨\u0006\n", d2 = {"Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "matchesSocket", "(Ljavax/net/ssl/SSLSocket;)Z", "Lokhttp3/internal/platform/android/SocketAdapter;", "create", "(Ljavax/net/ssl/SSLSocket;)Lokhttp3/internal/platform/android/SocketAdapter;", "okhttp"}, k = 1, mv = {1, 4, 0})
    public interface Factory {
        public abstract okhttp3.internal.platform.android.SocketAdapter create(SSLSocket sSLSocket);

        public abstract boolean matchesSocket(SSLSocket sSLSocket);
    }
    public DeferredSocketAdapter(okhttp3.internal.platform.android.DeferredSocketAdapter.Factory deferredSocketAdapter$Factory) {
        n.f(factory, "socketAdapterFactory");
        super();
        this.socketAdapterFactory = factory;
    }

    private final okhttp3.internal.platform.android.SocketAdapter getDelegate(SSLSocket sSLSocket) {
        okhttp3.internal.platform.android.SocketAdapter socketAdapterFactory;
        Object obj2;
        synchronized (this) {
            try {
                if (this.socketAdapterFactory.matchesSocket(sSLSocket)) {
                }
                this.delegate = this.socketAdapterFactory.create(sSLSocket);
                return this.delegate;
                throw sSLSocket;
            }
        }
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string2, List<? extends Protocol> list3) {
        n.f(sSLSocket, "sslSocket");
        n.f(list3, "protocols");
        okhttp3.internal.platform.android.SocketAdapter delegate = getDelegate(sSLSocket);
        if (delegate != null) {
            delegate.configureTlsExtensions(sSLSocket, string2, list3);
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        String obj2;
        n.f(sSLSocket, "sslSocket");
        okhttp3.internal.platform.android.SocketAdapter delegate = getDelegate(sSLSocket);
        if (delegate != null) {
            obj2 = delegate.getSelectedProtocol(sSLSocket);
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return 1;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(SSLSocket sSLSocket) {
        n.f(sSLSocket, "sslSocket");
        return this.socketAdapterFactory.matchesSocket(sSLSocket);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        n.f(sSLSocketFactory, "sslSocketFactory");
        return SocketAdapter.DefaultImpls.matchesSocketFactory(this, sSLSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        n.f(sSLSocketFactory, "sslSocketFactory");
        return SocketAdapter.DefaultImpls.trustManager(this, sSLSocketFactory);
    }
}
