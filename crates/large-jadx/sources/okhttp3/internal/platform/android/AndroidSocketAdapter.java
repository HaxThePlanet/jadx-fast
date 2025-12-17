package okhttp3.internal.platform.android;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import okhttp3.Protocol;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.AndroidPlatform.Companion;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0017\u0012\u000e\u0010\u001a\u001a\n\u0012\u0006\u0008\u0000\u0012\u00020\u00050\u0019¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u0007\u0010\u0008J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0008\u0010\n\u001a\u0004\u0018\u00010\t2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000bH\u0016¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008\u0011\u0010\u0012R\u001e\u0010\u0015\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0015\u0010\u0016R\u001e\u0010\u0017\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0017\u0010\u0016R\u001e\u0010\u0018\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0018\u0010\u0016R\u001e\u0010\u001a\u001a\n\u0012\u0006\u0008\u0000\u0012\u00020\u00050\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u001c\u0010\u0016¨\u0006 ", d2 = {"Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "", "isSupported", "()Z", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "matchesSocket", "(Ljavax/net/ssl/SSLSocket;)Z", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/w;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljava/lang/reflect/Method;", "kotlin.jvm.PlatformType", "getAlpnSelectedProtocol", "Ljava/lang/reflect/Method;", "setHostname", "setAlpnProtocols", "Ljava/lang/Class;", "sslSocketClass", "Ljava/lang/Class;", "setUseSessionTickets", "<init>", "(Ljava/lang/Class;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public class AndroidSocketAdapter implements okhttp3.internal.platform.android.SocketAdapter {

    public static final okhttp3.internal.platform.android.AndroidSocketAdapter.Companion Companion;
    private static final okhttp3.internal.platform.android.DeferredSocketAdapter.Factory playProviderFactory;
    private final Method getAlpnSelectedProtocol;
    private final Method setAlpnProtocols;
    private final Method setHostname;
    private final Method setUseSessionTickets;
    private final Class<? super SSLSocket> sslSocketClass;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0011\u0010\u0012J\u001f\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0006\u0008\u0000\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\u0008\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0008¢\u0006\u0004\u0008\u000b\u0010\u000cR\u0019\u0010\r\u001a\u00020\n8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u0013", d2 = {"Lokhttp3/internal/platform/android/AndroidSocketAdapter$Companion;", "", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "actualSSLSocketClass", "Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "build", "(Ljava/lang/Class;)Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "", "packageName", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "factory", "(Ljava/lang/String;)Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "playProviderFactory", "Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "getPlayProviderFactory", "()Lokhttp3/internal/platform/android/DeferredSocketAdapter$Factory;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public static final okhttp3.internal.platform.android.AndroidSocketAdapter access$build(okhttp3.internal.platform.android.AndroidSocketAdapter.Companion androidSocketAdapter$Companion, Class class2) {
            return companion.build(class2);
        }

        private final okhttp3.internal.platform.android.AndroidSocketAdapter build(Class<? super SSLSocket> class) {
            Object superclass;
            int i;
            String str;
            superclass = class;
            while (superclass != null) {
            }
            n.d(superclass);
            AndroidSocketAdapter obj4 = new AndroidSocketAdapter(superclass);
            return obj4;
        }

        public final okhttp3.internal.platform.android.DeferredSocketAdapter.Factory factory(String string) {
            n.f(string, "packageName");
            AndroidSocketAdapter.Companion.factory.1 anon = new AndroidSocketAdapter.Companion.factory.1(string);
            return anon;
        }

        public final okhttp3.internal.platform.android.DeferredSocketAdapter.Factory getPlayProviderFactory() {
            return AndroidSocketAdapter.access$getPlayProviderFactory$cp();
        }
    }
    static {
        AndroidSocketAdapter.Companion companion = new AndroidSocketAdapter.Companion(0);
        AndroidSocketAdapter.Companion = companion;
        AndroidSocketAdapter.playProviderFactory = companion.factory("com.google.android.gms.org.conscrypt");
    }

    public AndroidSocketAdapter(Class<? super SSLSocket> class) {
        n.f(class, "sslSocketClass");
        super();
        this.sslSocketClass = class;
        int i = 1;
        Class[] arr2 = new Class[i];
        final int i2 = 0;
        arr2[i2] = Boolean.TYPE;
        Method declaredMethod = class.getDeclaredMethod("setUseSessionTickets", arr2);
        n.e(declaredMethod, "sslSocketClass.getDeclar…:class.javaPrimitiveType)");
        this.setUseSessionTickets = declaredMethod;
        Class[] arr3 = new Class[i];
        arr3[i2] = String.class;
        this.setHostname = class.getMethod("setHostname", arr3);
        this.getAlpnSelectedProtocol = class.getMethod("getAlpnSelectedProtocol", new Class[i2]);
        Class[] arr = new Class[i];
        arr[i2] = byte[].class;
        this.setAlpnProtocols = class.getMethod("setAlpnProtocols", arr);
    }

    public static final okhttp3.internal.platform.android.DeferredSocketAdapter.Factory access$getPlayProviderFactory$cp() {
        return AndroidSocketAdapter.playProviderFactory;
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string2, List<? extends Protocol> list3) {
        Method setUseSessionTickets;
        boolean matchesSocket;
        Platform.Companion companion;
        Object[] arr;
        Boolean tRUE;
        int i;
        Object obj7;
        Object obj8;
        n.f(sSLSocket, "sslSocket");
        n.f(list3, "protocols");
        int i2 = 1;
        arr = new Object[i2];
        i = 0;
        arr[i] = Boolean.TRUE;
        this.setUseSessionTickets.invoke(sSLSocket, arr);
        if (matchesSocket(sSLSocket) && string2 != null) {
            i2 = 1;
            arr = new Object[i2];
            i = 0;
            arr[i] = Boolean.TRUE;
            this.setUseSessionTickets.invoke(sSLSocket, arr);
            if (string2 != null) {
                arr = new Object[i2];
                arr[i] = string2;
                this.setHostname.invoke(sSLSocket, arr);
            }
            matchesSocket = new Object[i2];
            matchesSocket[i] = Platform.Companion.concatLengthPrefixed(list3);
            this.setAlpnProtocols.invoke(sSLSocket, matchesSocket);
        }
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        Object getAlpnSelectedProtocol;
        int i;
        Object[] string;
        Object obj4;
        n.f(sSLSocket, "sslSocket");
        if (!matchesSocket(sSLSocket)) {
            return null;
        }
        obj4 = this.getAlpnSelectedProtocol.invoke(sSLSocket, new Object[0]);
        if ((byte[])obj4 != null) {
            getAlpnSelectedProtocol = StandardCharsets.UTF_8;
            n.e(getAlpnSelectedProtocol, "StandardCharsets.UTF_8");
            string = new String((byte[])obj4, getAlpnSelectedProtocol);
            i = string;
        }
        return i;
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean isSupported() {
        return AndroidPlatform.Companion.isSupported();
    }

    @Override // okhttp3.internal.platform.android.SocketAdapter
    public boolean matchesSocket(SSLSocket sSLSocket) {
        n.f(sSLSocket, "sslSocket");
        return this.sslSocketClass.isInstance(sSLSocket);
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
