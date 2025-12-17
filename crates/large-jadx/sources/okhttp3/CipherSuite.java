package okhttp3;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\u0008\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\u0008\u0008\u0010\tJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\u0008\u0006\u0010\u0004R\u0019\u0010\u0005\u001a\u00020\u00028\u0007@\u0006¢\u0006\u000c\n\u0004\u0008\u0005\u0010\u0007\u001a\u0004\u0008\u0005\u0010\u0004¨\u0006\u000b", d2 = {"Lokhttp3/CipherSuite;", "", "", "-deprecated_javaName", "()Ljava/lang/String;", "javaName", "toString", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class CipherSuite {

    public static final okhttp3.CipherSuite.Companion Companion;
    private static final Map<String, okhttp3.CipherSuite> INSTANCES;
    private static final Comparator<String> ORDER_BY_NAME;
    public static final okhttp3.CipherSuite TLS_AES_128_CCM_8_SHA256;
    public static final okhttp3.CipherSuite TLS_AES_128_CCM_SHA256;
    public static final okhttp3.CipherSuite TLS_AES_128_GCM_SHA256;
    public static final okhttp3.CipherSuite TLS_AES_256_GCM_SHA384;
    public static final okhttp3.CipherSuite TLS_CHACHA20_POLY1305_SHA256;
    public static final okhttp3.CipherSuite TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA256;
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_AES_128_GCM_SHA256;
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA256;
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_AES_256_GCM_SHA384;
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DHE_DSS_WITH_DES_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA256;
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_AES_128_GCM_SHA256;
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA256;
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_AES_256_GCM_SHA384;
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
    public static final okhttp3.CipherSuite TLS_DHE_RSA_WITH_DES_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DH_anon_EXPORT_WITH_RC4_40_MD5;
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_3DES_EDE_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA256;
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_AES_128_GCM_SHA256;
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA256;
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_AES_256_GCM_SHA384;
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_DES_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_DH_anon_WITH_RC4_128_MD5;
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256;
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256;
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384;
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384;
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256;
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA;
    public static final okhttp3.CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA;
    public static final okhttp3.CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256;
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256;
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256;
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384;
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384;
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256;
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA;
    public static final okhttp3.CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA;
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256;
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256;
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384;
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384;
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA;
    public static final okhttp3.CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA;
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256;
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256;
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384;
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384;
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA;
    public static final okhttp3.CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA;
    public static final okhttp3.CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_ECDH_anon_WITH_NULL_SHA;
    public static final okhttp3.CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA;
    public static final okhttp3.CipherSuite TLS_EMPTY_RENEGOTIATION_INFO_SCSV;
    public static final okhttp3.CipherSuite TLS_FALLBACK_SCSV;
    public static final okhttp3.CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5;
    public static final okhttp3.CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA;
    public static final okhttp3.CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_MD5;
    public static final okhttp3.CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_SHA;
    public static final okhttp3.CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_MD5;
    public static final okhttp3.CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_KRB5_WITH_DES_CBC_MD5;
    public static final okhttp3.CipherSuite TLS_KRB5_WITH_DES_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_KRB5_WITH_RC4_128_MD5;
    public static final okhttp3.CipherSuite TLS_KRB5_WITH_RC4_128_SHA;
    public static final okhttp3.CipherSuite TLS_PSK_WITH_3DES_EDE_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_PSK_WITH_AES_128_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_PSK_WITH_AES_256_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_PSK_WITH_RC4_128_SHA;
    public static final okhttp3.CipherSuite TLS_RSA_EXPORT_WITH_DES40_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_RSA_EXPORT_WITH_RC4_40_MD5;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA256;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA256;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_CAMELLIA_128_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_CAMELLIA_256_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_DES_CBC_SHA;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_NULL_MD5;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_NULL_SHA;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_NULL_SHA256;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_RC4_128_MD5;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_RC4_128_SHA;
    public static final okhttp3.CipherSuite TLS_RSA_WITH_SEED_CBC_SHA;
    private final String javaName;

    @Metadata(bv = {1, 0, 3}, d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010%\n\u0002\u0008}\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u000b\u0008\u0002¢\u0006\u0006\u0008\u008e\u0001\u0010\u008f\u0001J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001f\u0010\t\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00082\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u000b\u0010\u000cR,\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00020\rj\u0008\u0012\u0004\u0012\u00020\u0002`\u000e8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u0011\u0010\u0012R\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00080\u00138\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0018\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u001a\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u001b\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u001c\u0010\u0017R\u0016\u0010\u001d\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u001d\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u001e\u0010\u0017R\u0016\u0010\u001f\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u001f\u0010\u0017R\u0016\u0010 \u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008 \u0010\u0017R\u0016\u0010!\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008!\u0010\u0017R\u0016\u0010\"\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\"\u0010\u0017R\u0016\u0010#\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008#\u0010\u0017R\u0016\u0010$\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008$\u0010\u0017R\u0016\u0010%\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008%\u0010\u0017R\u0016\u0010&\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008&\u0010\u0017R\u0016\u0010'\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008'\u0010\u0017R\u0016\u0010(\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008(\u0010\u0017R\u0016\u0010)\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008)\u0010\u0017R\u0016\u0010*\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008*\u0010\u0017R\u0016\u0010+\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008+\u0010\u0017R\u0016\u0010,\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008,\u0010\u0017R\u0016\u0010-\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008-\u0010\u0017R\u0016\u0010.\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008.\u0010\u0017R\u0016\u0010/\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008/\u0010\u0017R\u0016\u00100\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u00080\u0010\u0017R\u0016\u00101\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u00081\u0010\u0017R\u0016\u00102\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u00082\u0010\u0017R\u0016\u00103\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u00083\u0010\u0017R\u0016\u00104\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u00084\u0010\u0017R\u0016\u00105\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u00085\u0010\u0017R\u0016\u00106\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u00086\u0010\u0017R\u0016\u00107\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u00087\u0010\u0017R\u0016\u00108\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u00088\u0010\u0017R\u0016\u00109\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u00089\u0010\u0017R\u0016\u0010:\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008:\u0010\u0017R\u0016\u0010;\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008;\u0010\u0017R\u0016\u0010<\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008<\u0010\u0017R\u0016\u0010=\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008=\u0010\u0017R\u0016\u0010>\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008>\u0010\u0017R\u0016\u0010?\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008?\u0010\u0017R\u0016\u0010@\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008@\u0010\u0017R\u0016\u0010A\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008A\u0010\u0017R\u0016\u0010B\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008B\u0010\u0017R\u0016\u0010C\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008C\u0010\u0017R\u0016\u0010D\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008D\u0010\u0017R\u0016\u0010E\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008E\u0010\u0017R\u0016\u0010F\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008F\u0010\u0017R\u0016\u0010G\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008G\u0010\u0017R\u0016\u0010H\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008H\u0010\u0017R\u0016\u0010I\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008I\u0010\u0017R\u0016\u0010J\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008J\u0010\u0017R\u0016\u0010K\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008K\u0010\u0017R\u0016\u0010L\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008L\u0010\u0017R\u0016\u0010M\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008M\u0010\u0017R\u0016\u0010N\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008N\u0010\u0017R\u0016\u0010O\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008O\u0010\u0017R\u0016\u0010P\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008P\u0010\u0017R\u0016\u0010Q\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008Q\u0010\u0017R\u0016\u0010R\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008R\u0010\u0017R\u0016\u0010S\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008S\u0010\u0017R\u0016\u0010T\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008T\u0010\u0017R\u0016\u0010U\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008U\u0010\u0017R\u0016\u0010V\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008V\u0010\u0017R\u0016\u0010W\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008W\u0010\u0017R\u0016\u0010X\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008X\u0010\u0017R\u0016\u0010Y\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008Y\u0010\u0017R\u0016\u0010Z\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008Z\u0010\u0017R\u0016\u0010[\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008[\u0010\u0017R\u0016\u0010\\\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\\\u0010\u0017R\u0016\u0010]\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008]\u0010\u0017R\u0016\u0010^\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008^\u0010\u0017R\u0016\u0010_\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008_\u0010\u0017R\u0016\u0010`\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008`\u0010\u0017R\u0016\u0010a\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008a\u0010\u0017R\u0016\u0010b\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008b\u0010\u0017R\u0016\u0010c\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008c\u0010\u0017R\u0016\u0010d\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008d\u0010\u0017R\u0016\u0010e\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008e\u0010\u0017R\u0016\u0010f\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008f\u0010\u0017R\u0016\u0010g\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008g\u0010\u0017R\u0016\u0010h\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008h\u0010\u0017R\u0016\u0010i\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008i\u0010\u0017R\u0016\u0010j\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008j\u0010\u0017R\u0016\u0010k\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008k\u0010\u0017R\u0016\u0010l\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008l\u0010\u0017R\u0016\u0010m\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008m\u0010\u0017R\u0016\u0010n\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008n\u0010\u0017R\u0016\u0010o\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008o\u0010\u0017R\u0016\u0010p\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008p\u0010\u0017R\u0016\u0010q\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008q\u0010\u0017R\u0016\u0010r\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008r\u0010\u0017R\u0016\u0010s\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008s\u0010\u0017R\u0016\u0010t\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008t\u0010\u0017R\u0016\u0010u\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008u\u0010\u0017R\u0016\u0010v\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008v\u0010\u0017R\u0016\u0010w\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008w\u0010\u0017R\u0016\u0010x\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008x\u0010\u0017R\u0016\u0010y\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008y\u0010\u0017R\u0016\u0010z\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008z\u0010\u0017R\u0016\u0010{\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008{\u0010\u0017R\u0016\u0010|\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008|\u0010\u0017R\u0016\u0010}\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008}\u0010\u0017R\u0016\u0010~\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008~\u0010\u0017R\u0016\u0010\u007f\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\u0008\u007f\u0010\u0017R\u0018\u0010\u0080\u0001\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0007\n\u0005\u0008\u0080\u0001\u0010\u0017R\u0018\u0010\u0081\u0001\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0007\n\u0005\u0008\u0081\u0001\u0010\u0017R\u0018\u0010\u0082\u0001\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0007\n\u0005\u0008\u0082\u0001\u0010\u0017R\u0018\u0010\u0083\u0001\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0007\n\u0005\u0008\u0083\u0001\u0010\u0017R\u0018\u0010\u0084\u0001\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0007\n\u0005\u0008\u0084\u0001\u0010\u0017R\u0018\u0010\u0085\u0001\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0007\n\u0005\u0008\u0085\u0001\u0010\u0017R\u0018\u0010\u0086\u0001\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0007\n\u0005\u0008\u0086\u0001\u0010\u0017R\u0018\u0010\u0087\u0001\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0007\n\u0005\u0008\u0087\u0001\u0010\u0017R\u0018\u0010\u0088\u0001\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0007\n\u0005\u0008\u0088\u0001\u0010\u0017R\u0018\u0010\u0089\u0001\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0007\n\u0005\u0008\u0089\u0001\u0010\u0017R\u0018\u0010\u008a\u0001\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0007\n\u0005\u0008\u008a\u0001\u0010\u0017R\u0018\u0010\u008b\u0001\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0007\n\u0005\u0008\u008b\u0001\u0010\u0017R\u0018\u0010\u008c\u0001\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0007\n\u0005\u0008\u008c\u0001\u0010\u0017R\u0018\u0010\u008d\u0001\u001a\u00020\u00088\u0006@\u0007X\u0087\u0004¢\u0006\u0007\n\u0005\u0008\u008d\u0001\u0010\u0017¨\u0006\u0090\u0001", d2 = {"Lokhttp3/CipherSuite$Companion;", "", "", "javaName", "secondaryName", "(Ljava/lang/String;)Ljava/lang/String;", "", "value", "Lokhttp3/CipherSuite;", "init", "(Ljava/lang/String;I)Lokhttp3/CipherSuite;", "forJavaName", "(Ljava/lang/String;)Lokhttp3/CipherSuite;", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "ORDER_BY_NAME", "Ljava/util/Comparator;", "getORDER_BY_NAME$okhttp", "()Ljava/util/Comparator;", "", "INSTANCES", "Ljava/util/Map;", "TLS_AES_128_CCM_8_SHA256", "Lokhttp3/CipherSuite;", "TLS_AES_128_CCM_SHA256", "TLS_AES_128_GCM_SHA256", "TLS_AES_256_GCM_SHA384", "TLS_CHACHA20_POLY1305_SHA256", "TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", "TLS_DHE_DSS_WITH_DES_CBC_SHA", "TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_DHE_RSA_WITH_DES_CBC_SHA", "TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA", "TLS_DH_anon_EXPORT_WITH_RC4_40_MD5", "TLS_DH_anon_WITH_3DES_EDE_CBC_SHA", "TLS_DH_anon_WITH_AES_128_CBC_SHA", "TLS_DH_anon_WITH_AES_128_CBC_SHA256", "TLS_DH_anon_WITH_AES_128_GCM_SHA256", "TLS_DH_anon_WITH_AES_256_CBC_SHA", "TLS_DH_anon_WITH_AES_256_CBC_SHA256", "TLS_DH_anon_WITH_AES_256_GCM_SHA384", "TLS_DH_anon_WITH_DES_CBC_SHA", "TLS_DH_anon_WITH_RC4_128_MD5", "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_ECDSA_WITH_NULL_SHA", "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_RSA_WITH_NULL_SHA", "TLS_ECDHE_RSA_WITH_RC4_128_SHA", "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_ECDSA_WITH_NULL_SHA", "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_RSA_WITH_NULL_SHA", "TLS_ECDH_RSA_WITH_RC4_128_SHA", "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", "TLS_ECDH_anon_WITH_NULL_SHA", "TLS_ECDH_anon_WITH_RC4_128_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_FALLBACK_SCSV", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", "TLS_KRB5_WITH_DES_CBC_MD5", "TLS_KRB5_WITH_DES_CBC_SHA", "TLS_KRB5_WITH_RC4_128_MD5", "TLS_KRB5_WITH_RC4_128_SHA", "TLS_PSK_WITH_3DES_EDE_CBC_SHA", "TLS_PSK_WITH_AES_128_CBC_SHA", "TLS_PSK_WITH_AES_256_CBC_SHA", "TLS_PSK_WITH_RC4_128_SHA", "TLS_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_RSA_EXPORT_WITH_RC4_40_MD5", "TLS_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_128_CBC_SHA256", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", "TLS_RSA_WITH_DES_CBC_SHA", "TLS_RSA_WITH_NULL_MD5", "TLS_RSA_WITH_NULL_SHA", "TLS_RSA_WITH_NULL_SHA256", "TLS_RSA_WITH_RC4_128_MD5", "TLS_RSA_WITH_RC4_128_SHA", "TLS_RSA_WITH_SEED_CBC_SHA", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public static final okhttp3.CipherSuite access$init(okhttp3.CipherSuite.Companion cipherSuite$Companion, String string2, int i3) {
            return companion.init(string2, i3);
        }

        private final okhttp3.CipherSuite init(String string, int i2) {
            CipherSuite obj3 = new CipherSuite(string, 0);
            CipherSuite.access$getINSTANCES$cp().put(string, obj3);
            return obj3;
        }

        private final String secondaryName(String string) {
            Object stringBuilder;
            int stringBuilder2;
            String obj10;
            stringBuilder = "TLS_";
            stringBuilder2 = 0;
            final int i = 2;
            final int i2 = 0;
            final String str = "(this as java.lang.String).substring(startIndex)";
            final String str2 = "null cannot be cast to non-null type java.lang.String";
            final int i3 = 4;
            final String str3 = "SSL_";
            if (l.M(string, stringBuilder, stringBuilder2, i, i2)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(str3);
                Objects.requireNonNull(string, str2);
                obj10 = string.substring(i3);
                n.e(obj10, str);
                stringBuilder.append(obj10);
                obj10 = stringBuilder.toString();
            } else {
                if (l.M(string, str3, stringBuilder2, i, i2)) {
                    stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(stringBuilder);
                    Objects.requireNonNull(string, str2);
                    obj10 = string.substring(i3);
                    n.e(obj10, str);
                    stringBuilder2.append(obj10);
                    obj10 = stringBuilder2.toString();
                }
            }
            return obj10;
        }

        public final okhttp3.CipherSuite forJavaName(String string) {
            Object cipherSuite;
            String secondaryName;
            Map map;
            n.f(string, "javaName");
            synchronized (this) {
                try {
                    if ((CipherSuite)CipherSuite.access$getINSTANCES$cp().get(secondaryName(string)) == null) {
                    }
                    cipherSuite = new CipherSuite(string, 0);
                    CipherSuite.access$getINSTANCES$cp().put(string, cipherSuite);
                    return cipherSuite;
                    throw string;
                }
            }
        }

        public final Comparator<String> getORDER_BY_NAME$okhttp() {
            return CipherSuite.access$getORDER_BY_NAME$cp();
        }
    }
    static {
        CipherSuite.Companion companion = new CipherSuite.Companion(0);
        CipherSuite.Companion = companion;
        CipherSuite.Companion.ORDER_BY_NAME.1 anon = new CipherSuite.Companion.ORDER_BY_NAME.1();
        CipherSuite.ORDER_BY_NAME = anon;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        CipherSuite.INSTANCES = linkedHashMap;
        CipherSuite.TLS_RSA_WITH_NULL_MD5 = CipherSuite.Companion.access$init(companion, "SSL_RSA_WITH_NULL_MD5", 1);
        CipherSuite.TLS_RSA_WITH_NULL_SHA = CipherSuite.Companion.access$init(companion, "SSL_RSA_WITH_NULL_SHA", 2);
        CipherSuite.TLS_RSA_EXPORT_WITH_RC4_40_MD5 = CipherSuite.Companion.access$init(companion, "SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
        CipherSuite.TLS_RSA_WITH_RC4_128_MD5 = CipherSuite.Companion.access$init(companion, "SSL_RSA_WITH_RC4_128_MD5", 4);
        CipherSuite.TLS_RSA_WITH_RC4_128_SHA = CipherSuite.Companion.access$init(companion, "SSL_RSA_WITH_RC4_128_SHA", 5);
        CipherSuite.TLS_RSA_EXPORT_WITH_DES40_CBC_SHA = CipherSuite.Companion.access$init(companion, "SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
        CipherSuite.TLS_RSA_WITH_DES_CBC_SHA = CipherSuite.Companion.access$init(companion, "SSL_RSA_WITH_DES_CBC_SHA", 9);
        CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA = CipherSuite.Companion.access$init(companion, "SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
        CipherSuite.TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = CipherSuite.Companion.access$init(companion, "SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
        CipherSuite.TLS_DHE_DSS_WITH_DES_CBC_SHA = CipherSuite.Companion.access$init(companion, "SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
        CipherSuite.TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA = CipherSuite.Companion.access$init(companion, "SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
        CipherSuite.TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = CipherSuite.Companion.access$init(companion, "SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
        CipherSuite.TLS_DHE_RSA_WITH_DES_CBC_SHA = CipherSuite.Companion.access$init(companion, "SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
        CipherSuite.TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA = CipherSuite.Companion.access$init(companion, "SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
        CipherSuite.TLS_DH_anon_EXPORT_WITH_RC4_40_MD5 = CipherSuite.Companion.access$init(companion, "SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
        CipherSuite.TLS_DH_anon_WITH_RC4_128_MD5 = CipherSuite.Companion.access$init(companion, "SSL_DH_anon_WITH_RC4_128_MD5", 24);
        CipherSuite.TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA = CipherSuite.Companion.access$init(companion, "SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
        CipherSuite.TLS_DH_anon_WITH_DES_CBC_SHA = CipherSuite.Companion.access$init(companion, "SSL_DH_anon_WITH_DES_CBC_SHA", 26);
        CipherSuite.TLS_DH_anon_WITH_3DES_EDE_CBC_SHA = CipherSuite.Companion.access$init(companion, "SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
        CipherSuite.TLS_KRB5_WITH_DES_CBC_SHA = CipherSuite.Companion.access$init(companion, "TLS_KRB5_WITH_DES_CBC_SHA", 30);
        CipherSuite.TLS_KRB5_WITH_3DES_EDE_CBC_SHA = CipherSuite.Companion.access$init(companion, "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
        CipherSuite.TLS_KRB5_WITH_RC4_128_SHA = CipherSuite.Companion.access$init(companion, "TLS_KRB5_WITH_RC4_128_SHA", 32);
        CipherSuite.TLS_KRB5_WITH_DES_CBC_MD5 = CipherSuite.Companion.access$init(companion, "TLS_KRB5_WITH_DES_CBC_MD5", 34);
        CipherSuite.TLS_KRB5_WITH_3DES_EDE_CBC_MD5 = CipherSuite.Companion.access$init(companion, "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
        CipherSuite.TLS_KRB5_WITH_RC4_128_MD5 = CipherSuite.Companion.access$init(companion, "TLS_KRB5_WITH_RC4_128_MD5", 36);
        CipherSuite.TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA = CipherSuite.Companion.access$init(companion, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
        CipherSuite.TLS_KRB5_EXPORT_WITH_RC4_40_SHA = CipherSuite.Companion.access$init(companion, "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
        CipherSuite.TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5 = CipherSuite.Companion.access$init(companion, "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
        CipherSuite.TLS_KRB5_EXPORT_WITH_RC4_40_MD5 = CipherSuite.Companion.access$init(companion, "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
        CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA = CipherSuite.Companion.access$init(companion, "TLS_RSA_WITH_AES_128_CBC_SHA", 47);
        CipherSuite.TLS_DHE_DSS_WITH_AES_128_CBC_SHA = CipherSuite.Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
        CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA = CipherSuite.Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
        CipherSuite.TLS_DH_anon_WITH_AES_128_CBC_SHA = CipherSuite.Companion.access$init(companion, "TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
        CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA = CipherSuite.Companion.access$init(companion, "TLS_RSA_WITH_AES_256_CBC_SHA", 53);
        CipherSuite.TLS_DHE_DSS_WITH_AES_256_CBC_SHA = CipherSuite.Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
        CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA = CipherSuite.Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
        CipherSuite.TLS_DH_anon_WITH_AES_256_CBC_SHA = CipherSuite.Companion.access$init(companion, "TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
        CipherSuite.TLS_RSA_WITH_NULL_SHA256 = CipherSuite.Companion.access$init(companion, "TLS_RSA_WITH_NULL_SHA256", 59);
        CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA256 = CipherSuite.Companion.access$init(companion, "TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
        CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA256 = CipherSuite.Companion.access$init(companion, "TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
        CipherSuite.TLS_DHE_DSS_WITH_AES_128_CBC_SHA256 = CipherSuite.Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
        CipherSuite.TLS_RSA_WITH_CAMELLIA_128_CBC_SHA = CipherSuite.Companion.access$init(companion, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
        CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA = CipherSuite.Companion.access$init(companion, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
        CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA = CipherSuite.Companion.access$init(companion, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
        CipherSuite.TLS_DHE_RSA_WITH_AES_128_CBC_SHA256 = CipherSuite.Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", 103);
        CipherSuite.TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 = CipherSuite.Companion.access$init(companion, "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
        CipherSuite.TLS_DHE_RSA_WITH_AES_256_CBC_SHA256 = CipherSuite.Companion.access$init(companion, "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
        CipherSuite.TLS_DH_anon_WITH_AES_128_CBC_SHA256 = CipherSuite.Companion.access$init(companion, "TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
        okhttp3.CipherSuite.Companion companion2 = CipherSuite.Companion;
        CipherSuite.TLS_DH_anon_WITH_AES_256_CBC_SHA256 = CipherSuite.Companion.access$init(companion2, "TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
        CipherSuite.TLS_RSA_WITH_CAMELLIA_256_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
        CipherSuite.TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
        CipherSuite.TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
        CipherSuite.TLS_PSK_WITH_RC4_128_SHA = CipherSuite.Companion.access$init(companion2, "TLS_PSK_WITH_RC4_128_SHA", 138);
        CipherSuite.TLS_PSK_WITH_3DES_EDE_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
        CipherSuite.TLS_PSK_WITH_AES_128_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_PSK_WITH_AES_128_CBC_SHA", 140);
        CipherSuite.TLS_PSK_WITH_AES_256_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_PSK_WITH_AES_256_CBC_SHA", 141);
        CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_RSA_WITH_SEED_CBC_SHA", 150);
        CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256 = CipherSuite.Companion.access$init(companion2, "TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
        CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384 = CipherSuite.Companion.access$init(companion2, "TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
        CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 = CipherSuite.Companion.access$init(companion2, "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
        CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 = CipherSuite.Companion.access$init(companion2, "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
        CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 = CipherSuite.Companion.access$init(companion2, "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
        CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 = CipherSuite.Companion.access$init(companion2, "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
        CipherSuite.TLS_DH_anon_WITH_AES_128_GCM_SHA256 = CipherSuite.Companion.access$init(companion2, "TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
        CipherSuite.TLS_DH_anon_WITH_AES_256_GCM_SHA384 = CipherSuite.Companion.access$init(companion2, "TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
        CipherSuite.TLS_EMPTY_RENEGOTIATION_INFO_SCSV = CipherSuite.Companion.access$init(companion2, "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
        CipherSuite.TLS_FALLBACK_SCSV = CipherSuite.Companion.access$init(companion2, "TLS_FALLBACK_SCSV", 22016);
        CipherSuite.TLS_ECDH_ECDSA_WITH_NULL_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
        CipherSuite.TLS_ECDH_ECDSA_WITH_RC4_128_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
        CipherSuite.TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
        CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
        CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
        CipherSuite.TLS_ECDHE_ECDSA_WITH_NULL_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
        CipherSuite.TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
        CipherSuite.TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
        CipherSuite.TLS_ECDH_RSA_WITH_NULL_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
        CipherSuite.TLS_ECDH_RSA_WITH_RC4_128_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
        CipherSuite.TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
        CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
        CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
        CipherSuite.TLS_ECDHE_RSA_WITH_NULL_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
        CipherSuite.TLS_ECDHE_RSA_WITH_RC4_128_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
        CipherSuite.TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
        CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
        CipherSuite.TLS_ECDH_anon_WITH_NULL_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_anon_WITH_NULL_SHA", 49173);
        CipherSuite.TLS_ECDH_anon_WITH_RC4_128_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
        CipherSuite.TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
        CipherSuite.TLS_ECDH_anon_WITH_AES_128_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
        CipherSuite.TLS_ECDH_anon_WITH_AES_256_CBC_SHA = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 = CipherSuite.Companion.access$init(companion2, "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 = CipherSuite.Companion.access$init(companion2, "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
        CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
        CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 = CipherSuite.Companion.access$init(companion2, "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 = CipherSuite.Companion.access$init(companion2, "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
        CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 = CipherSuite.Companion.access$init(companion2, "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
        okhttp3.CipherSuite.Companion companion3 = CipherSuite.Companion;
        CipherSuite.TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 = CipherSuite.Companion.access$init(companion3, "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
        CipherSuite.TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 = CipherSuite.Companion.access$init(companion3, "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = CipherSuite.Companion.access$init(companion3, "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
        CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = CipherSuite.Companion.access$init(companion3, "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
        CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 = CipherSuite.Companion.access$init(companion3, "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
        CipherSuite.TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 = CipherSuite.Companion.access$init(companion3, "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
        CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = CipherSuite.Companion.access$init(companion3, "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
        CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = CipherSuite.Companion.access$init(companion3, "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
        CipherSuite.TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 = CipherSuite.Companion.access$init(companion3, "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
        CipherSuite.TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 = CipherSuite.Companion.access$init(companion3, "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
        CipherSuite.TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA = CipherSuite.Companion.access$init(companion3, "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
        CipherSuite.TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA = CipherSuite.Companion.access$init(companion3, "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
        CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = CipherSuite.Companion.access$init(companion3, "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
        CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = CipherSuite.Companion.access$init(companion3, "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
        CipherSuite.TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = CipherSuite.Companion.access$init(companion3, "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
        CipherSuite.TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256 = CipherSuite.Companion.access$init(companion3, "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
        CipherSuite.TLS_AES_128_GCM_SHA256 = CipherSuite.Companion.access$init(companion3, "TLS_AES_128_GCM_SHA256", 4865);
        CipherSuite.TLS_AES_256_GCM_SHA384 = CipherSuite.Companion.access$init(companion3, "TLS_AES_256_GCM_SHA384", 4866);
        CipherSuite.TLS_CHACHA20_POLY1305_SHA256 = CipherSuite.Companion.access$init(companion3, "TLS_CHACHA20_POLY1305_SHA256", 4867);
        CipherSuite.TLS_AES_128_CCM_SHA256 = CipherSuite.Companion.access$init(companion3, "TLS_AES_128_CCM_SHA256", 4868);
        CipherSuite.TLS_AES_128_CCM_8_SHA256 = CipherSuite.Companion.access$init(companion3, "TLS_AES_128_CCM_8_SHA256", 4869);
    }

    private CipherSuite(String string) {
        super();
        this.javaName = string;
    }

    public CipherSuite(String string, g g2) {
        super(string);
    }

    public static final Map access$getINSTANCES$cp() {
        return CipherSuite.INSTANCES;
    }

    public static final Comparator access$getORDER_BY_NAME$cp() {
        return CipherSuite.ORDER_BY_NAME;
    }

    public static final okhttp3.CipherSuite forJavaName(String string) {
        final Class<okhttp3.CipherSuite> obj = CipherSuite.class;
        return CipherSuite.Companion.forJavaName(string);
        synchronized (obj) {
            obj = CipherSuite.class;
            return CipherSuite.Companion.forJavaName(string);
        }
    }

    public final String -deprecated_javaName() {
        return this.javaName;
    }

    public final String javaName() {
        return this.javaName;
    }

    public String toString() {
        return this.javaName;
    }
}
