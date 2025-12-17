package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B3\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0008\u0000\u0012\u00020\u000e0\n\u0012\u000e\u0010\r\u001a\n\u0012\u0006\u0008\u0000\u0012\u00020\u00020\n\u0012\n\u0010\u000b\u001a\u0006\u0012\u0002\u0008\u00030\n¢\u0006\u0004\u0008\u0010\u0010\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0005\u0010\u0006J\u0019\u0010\u0008\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0008\u0010\tR\u001a\u0010\u000b\u001a\u0006\u0012\u0002\u0008\u00030\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000b\u0010\u000cR\u001e\u0010\r\u001a\n\u0012\u0006\u0008\u0000\u0012\u00020\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\r\u0010\u000c¨\u0006\u0013", d2 = {"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter;", "Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "Ljavax/net/ssl/SSLSocketFactory;", "sslSocketFactory", "", "matchesSocketFactory", "(Ljavax/net/ssl/SSLSocketFactory;)Z", "Ljavax/net/ssl/X509TrustManager;", "trustManager", "(Ljavax/net/ssl/SSLSocketFactory;)Ljavax/net/ssl/X509TrustManager;", "Ljava/lang/Class;", "paramClass", "Ljava/lang/Class;", "sslSocketFactoryClass", "Ljavax/net/ssl/SSLSocket;", "sslSocketClass", "<init>", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class StandardAndroidSocketAdapter extends okhttp3.internal.platform.android.AndroidSocketAdapter {

    public static final okhttp3.internal.platform.android.StandardAndroidSocketAdapter.Companion Companion;
    private final Class<?> paramClass;
    private final Class<? super SSLSocketFactory> sslSocketFactoryClass;

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0008\u0008\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\t", d2 = {"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter$Companion;", "", "", "packageName", "Lokhttp3/internal/platform/android/SocketAdapter;", "buildIfSupported", "(Ljava/lang/String;)Lokhttp3/internal/platform/android/SocketAdapter;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public static okhttp3.internal.platform.android.SocketAdapter buildIfSupported$default(okhttp3.internal.platform.android.StandardAndroidSocketAdapter.Companion standardAndroidSocketAdapter$Companion, String string2, int i3, Object object4) {
            String obj1;
            if (i3 &= 1 != 0) {
                obj1 = "com.android.org.conscrypt";
            }
            return companion.buildIfSupported(obj1);
        }

        public final okhttp3.internal.platform.android.SocketAdapter buildIfSupported(String string) {
            Class forName;
            Class forName2;
            okhttp3.internal.platform.android.StandardAndroidSocketAdapter standardAndroidSocketAdapter;
            Class obj5;
            n.f(string, "packageName");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(".OpenSSLSocketImpl");
            forName = Class.forName(stringBuilder.toString());
            if (forName == null) {
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(string);
                stringBuilder2.append(".OpenSSLSocketFactoryImpl");
                forName2 = Class.forName(stringBuilder2.toString());
                if (forName2 == null) {
                } else {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(string);
                    stringBuilder3.append(".SSLParametersImpl");
                    obj5 = Class.forName(stringBuilder3.toString());
                    n.e(obj5, "paramsClass");
                    standardAndroidSocketAdapter = new StandardAndroidSocketAdapter(forName, forName2, obj5);
                    return standardAndroidSocketAdapter;
                }
                obj5 = new NullPointerException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");
                throw obj5;
            }
            obj5 = new NullPointerException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");
            throw obj5;
        }
    }
    static {
        StandardAndroidSocketAdapter.Companion companion = new StandardAndroidSocketAdapter.Companion(0);
        StandardAndroidSocketAdapter.Companion = companion;
    }

    public StandardAndroidSocketAdapter(Class<? super SSLSocket> class, Class<? super SSLSocketFactory> class2, Class<?> class3) {
        n.f(class, "sslSocketClass");
        n.f(class2, "sslSocketFactoryClass");
        n.f(class3, "paramClass");
        super(class);
        this.sslSocketFactoryClass = class2;
        this.paramClass = class3;
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter
    public boolean matchesSocketFactory(SSLSocketFactory sSLSocketFactory) {
        n.f(sSLSocketFactory, "sslSocketFactory");
        return this.sslSocketFactoryClass.isInstance(sSLSocketFactory);
    }

    @Override // okhttp3.internal.platform.android.AndroidSocketAdapter
    public X509TrustManager trustManager(SSLSocketFactory sSLSocketFactory) {
        Object fieldOrNull;
        String str;
        Object obj3;
        n.f(sSLSocketFactory, "sslSocketFactory");
        obj3 = Util.readFieldOrNull(sSLSocketFactory, this.paramClass, "sslParameters");
        n.d(obj3);
        if ((X509TrustManager)Util.readFieldOrNull(obj3, X509TrustManager.class, "x509TrustManager") != null) {
        } else {
            fieldOrNull = obj3;
        }
        return fieldOrNull;
    }
}
