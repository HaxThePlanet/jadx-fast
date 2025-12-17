package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import okhttp3.Protocol;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001c\u001bB7\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0010\u0012\n\u0010\u0014\u001a\u0006\u0012\u0002\u0008\u00030\u0013\u0012\n\u0010\u0018\u001a\u0006\u0012\u0002\u0008\u00030\u0013¢\u0006\u0004\u0008\u0019\u0010\u001aJ/\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¢\u0006\u0004\u0008\n\u0010\u000bJ\u0017\u0010\u000c\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u000c\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\u0014\u001a\u0006\u0012\u0002\u0008\u00030\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0016\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0017\u0010\u0012R\u001a\u0010\u0018\u001a\u0006\u0012\u0002\u0008\u00030\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0018\u0010\u0015¨\u0006\u001d", d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform;", "Lokhttp3/internal/platform/Platform;", "Ljavax/net/ssl/SSLSocket;", "sslSocket", "", "hostname", "", "Lokhttp3/Protocol;", "protocols", "Lkotlin/w;", "configureTlsExtensions", "(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;Ljava/util/List;)V", "afterHandshake", "(Ljavax/net/ssl/SSLSocket;)V", "getSelectedProtocol", "(Ljavax/net/ssl/SSLSocket;)Ljava/lang/String;", "Ljava/lang/reflect/Method;", "putMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "clientProviderClass", "Ljava/lang/Class;", "getMethod", "removeMethod", "serverProviderClass", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/Class;Ljava/lang/Class;)V", "Companion", "AlpnProvider", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class Jdk8WithJettyBootPlatform extends okhttp3.internal.platform.Platform {

    public static final okhttp3.internal.platform.Jdk8WithJettyBootPlatform.Companion Companion;
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    @Metadata(bv = {1, 0, 3}, d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\t\u0008\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\u0008\u001b\u0010\u001cJ2\u0010\u0008\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\u0008\u0008\u0010\tR\u001c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u000c\u0010\rR$\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u0010\u0010\u0011\"\u0004\u0008\u0012\u0010\u0013R\"\u0010\u0015\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u0015\u0010\u0016\u001a\u0004\u0008\u0017\u0010\u0018\"\u0004\u0008\u0019\u0010\u001a¨\u0006\u001d", d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$AlpnProvider;", "Ljava/lang/reflect/InvocationHandler;", "", "proxy", "Ljava/lang/reflect/Method;", "method", "", "args", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;", "", "", "protocols", "Ljava/util/List;", "selected", "Ljava/lang/String;", "getSelected", "()Ljava/lang/String;", "setSelected", "(Ljava/lang/String;)V", "", "unsupported", "Z", "getUnsupported", "()Z", "setUnsupported", "(Z)V", "<init>", "(Ljava/util/List;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    private static final class AlpnProvider implements InvocationHandler {

        private final List<String> protocols;
        private String selected;
        private boolean unsupported;
        public AlpnProvider(List<String> list) {
            n.f(list, "protocols");
            super();
            this.protocols = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final String getSelected() {
            return this.selected;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final boolean getUnsupported() {
            return this.unsupported;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object object, Method method2, Object[] object3Arr3) {
            boolean length;
            boolean returnType;
            String str;
            boolean z;
            boolean z2;
            boolean z3;
            Class<String> contains;
            Object[] obj9;
            n.f(object, "proxy");
            n.f(method2, "method");
            int obj7 = 0;
            if (object3Arr3 != null) {
            } else {
                obj9 = new Object[obj7];
            }
            length = method2.getName();
            returnType = method2.getReturnType();
            if (n.b(length, "supports") && n.b(Boolean.TYPE, returnType)) {
                if (n.b(Boolean.TYPE, returnType)) {
                    return Boolean.TRUE;
                }
            }
            final int i = 0;
            final int i2 = 1;
            if (n.b(length, "unsupported") && n.b(Void.TYPE, returnType)) {
                if (n.b(Void.TYPE, returnType)) {
                    this.unsupported = i2;
                    return i;
                }
            }
            if (n.b(length, "protocols")) {
                z3 = obj9.length == 0 ? i2 : obj7;
                if (z3 != 0) {
                    return this.protocols;
                }
            }
            final String str9 = "null cannot be cast to non-null type kotlin.String";
            if (!n.b(length, "selectProtocol")) {
                Object obj8 = obj9[obj7];
                Objects.requireNonNull(obj8, "null cannot be cast to non-null type kotlin.collections.List<*>");
                obj9 = (List)obj8.size();
                if (n.b(length, "select") && n.b(String.class, returnType) && obj9.length == i2 && obj instanceof List != null && obj9 >= 0) {
                    if (n.b(String.class, returnType)) {
                        if (obj9.length == i2) {
                            if (obj instanceof List != null) {
                                obj8 = obj9[obj7];
                                Objects.requireNonNull(obj8, "null cannot be cast to non-null type kotlin.collections.List<*>");
                                obj9 = (List)obj8.size();
                                if (obj9 >= 0) {
                                    length = obj7;
                                    returnType = obj8.get(length);
                                    Objects.requireNonNull(returnType, str9);
                                    while (this.protocols.contains((String)returnType) != null) {
                                        length++;
                                        returnType = obj8.get(length);
                                        Objects.requireNonNull(returnType, str9);
                                    }
                                    this.selected = returnType;
                                    return returnType;
                                }
                                obj7 = this.protocols.get(obj7);
                                this.selected = (String)obj7;
                                return obj7;
                            }
                        }
                    }
                }
            } else {
            }
            if (!n.b(length, "protocolSelected")) {
                if (n.b(length, "selected") && obj9.length == i2) {
                    if (obj9.length == i2) {
                        obj7 = obj9[obj7];
                        Objects.requireNonNull(obj7, str9);
                        this.selected = (String)obj7;
                        return i;
                    }
                }
            } else {
            }
            return method2.invoke(this, Arrays.copyOf(obj9, obj9.length));
        }

        @Override // java.lang.reflect.InvocationHandler
        public final void setSelected(String string) {
            this.selected = string;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final void setUnsupported(boolean z) {
            this.unsupported = z;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004¨\u0006\u0007", d2 = {"Lokhttp3/internal/platform/Jdk8WithJettyBootPlatform$Companion;", "", "Lokhttp3/internal/platform/Platform;", "buildIfSupported", "()Lokhttp3/internal/platform/Platform;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public final okhttp3.internal.platform.Platform buildIfSupported() {
            String property = System.getProperty("java.specification.version", "unknown");
            int i = 0;
            n.e(property, "jvmVersion");
            if (Integer.parseInt(property) >= 9) {
                return i;
            }
            String str2 = "org.eclipse.jetty.alpn.ALPN";
            int i3 = 1;
            Class forName = Class.forName("org.eclipse.jetty.alpn.ALPN", i3, i);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str2);
            stringBuilder.append("$Provider");
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str2);
            stringBuilder2.append("$ClientProvider");
            final Class forName3 = Class.forName(stringBuilder2.toString(), i3, i);
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str2);
            stringBuilder3.append("$ServerProvider");
            final Class forName4 = Class.forName(stringBuilder3.toString(), i3, i);
            Class[] arr2 = new Class[2];
            int i5 = 0;
            arr2[i5] = SSLSocket.class;
            arr2[i3] = Class.forName(stringBuilder.toString(), i3, i);
            Method method = forName.getMethod("put", arr2);
            Class[] arr3 = new Class[i3];
            arr3[i5] = SSLSocket.class;
            final Method method3 = forName.getMethod("get", arr3);
            Class[] arr = new Class[i3];
            arr[i5] = SSLSocket.class;
            final Method method4 = forName.getMethod("remove", arr);
            n.e(method, "putMethod");
            n.e(method3, "getMethod");
            n.e(method4, "removeMethod");
            n.e(forName3, "clientProviderClass");
            n.e(forName4, "serverProviderClass");
            super(method, method3, method4, forName3, forName4);
            return jdk8WithJettyBootPlatform;
        }
    }
    static {
        Jdk8WithJettyBootPlatform.Companion companion = new Jdk8WithJettyBootPlatform.Companion(0);
        Jdk8WithJettyBootPlatform.Companion = companion;
    }

    public Jdk8WithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> class4, Class<?> class5) {
        n.f(method, "putMethod");
        n.f(method2, "getMethod");
        n.f(method3, "removeMethod");
        n.f(class4, "clientProviderClass");
        n.f(class5, "serverProviderClass");
        super();
        this.putMethod = method;
        this.getMethod = method2;
        this.removeMethod = method3;
        this.clientProviderClass = class4;
        this.serverProviderClass = class5;
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(SSLSocket sSLSocket) {
        final String str = "failed to remove ALPN";
        n.f(sSLSocket, "sslSocket");
        Object[] arr = new Object[1];
        this.removeMethod.invoke(0, sSLSocket);
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String string2, List<? extends Protocol> list3) {
        final String obj8 = "failed to set ALPN";
        n.f(sSLSocket, "sslSocket");
        n.f(list3, "protocols");
        int i = 2;
        Class[] arr2 = new Class[i];
        final int i3 = 0;
        arr2[i3] = this.clientProviderClass;
        final int i4 = 1;
        arr2[i4] = this.serverProviderClass;
        Jdk8WithJettyBootPlatform.AlpnProvider alpnProvider = new Jdk8WithJettyBootPlatform.AlpnProvider(Platform.Companion.alpnProtocolNames(list3));
        Object[] arr = new Object[i];
        arr[i3] = sSLSocket;
        arr[i4] = Proxy.newProxyInstance(Platform.class.getClassLoader(), arr2, alpnProvider);
        this.putMethod.invoke(0, arr);
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sSLSocket) {
        boolean unsupported;
        String obj10;
        final String str = "failed to get ALPN selected protocol";
        n.f(sSLSocket, "sslSocket");
        Object[] arr = new Object[1];
        obj10 = 0;
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.getMethod.invoke(obj10, sSLSocket));
        if (invocationHandler == null) {
        } else {
            if (!(Jdk8WithJettyBootPlatform.AlpnProvider)invocationHandler.getUnsupported() && invocationHandler.getSelected() == null) {
                if (invocationHandler.getSelected() == null) {
                    Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, 0, 6, 0);
                    return obj10;
                }
            }
            if (invocationHandler.getUnsupported()) {
            } else {
                obj10 = invocationHandler.getSelected();
            }
            try {
                return obj10;
                obj10 = new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
                throw obj10;
                AssertionError assertionError = new AssertionError(obj0, sSLSocket);
                throw assertionError;
                assertionError = new AssertionError(obj0, sSLSocket);
                throw assertionError;
            }
        }
    }
}
