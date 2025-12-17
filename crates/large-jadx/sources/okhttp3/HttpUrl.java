package okhttp3;

import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.h0.d;
import kotlin.h0.g;
import kotlin.k0.h;
import kotlin.k0.l;
import kotlin.y.p;
import kotlin.y.q0;
import l.f;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase.Companion;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008%\n\u0002\u0010\"\n\u0002\u0008\u0013\u0018\u0000 W2\u00020\u0001:\u0002XWBc\u0008\u0000\u0012\u0006\u0010*\u001a\u00020\n\u0012\u0006\u0010.\u001a\u00020\n\u0012\u0006\u00102\u001a\u00020\n\u0012\u0006\u00104\u001a\u00020\n\u0012\u0006\u00106\u001a\u00020\u0011\u0012\u000c\u0010?\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000e\u0012\u0010\u0010T\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000e\u0012\u0008\u0010M\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u0003\u001a\u00020\n¢\u0006\u0004\u0008U\u0010VJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0017\u0010\u000c\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\u0008\u000c\u0010\rJ\u001d\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u000e2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\u0008\u000f\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\u0008\u0015\u0010\u0014J\r\u0010\u0016\u001a\u00020\n¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0018\u001a\u00020\n¢\u0006\u0004\u0008\u0019\u0010\u001aJ\r\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\u0008\u001c\u0010\u001dJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\n¢\u0006\u0004\u0008\u001c\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\u0008\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\u0008!\u0010\"J\u000f\u0010#\u001a\u00020\u0011H\u0016¢\u0006\u0004\u0008#\u0010$J\u000f\u0010%\u001a\u00020\nH\u0016¢\u0006\u0004\u0008%\u0010\u0017J\u000f\u0010&\u001a\u0004\u0018\u00010\n¢\u0006\u0004\u0008&\u0010\u0017J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\u0008'\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\u0008(\u0010\u0008J\u000f\u0010*\u001a\u00020\nH\u0007¢\u0006\u0004\u0008)\u0010\u0017J\u000f\u0010,\u001a\u00020\nH\u0007¢\u0006\u0004\u0008+\u0010\u0017J\u000f\u0010.\u001a\u00020\nH\u0007¢\u0006\u0004\u0008-\u0010\u0017J\u000f\u00100\u001a\u00020\nH\u0007¢\u0006\u0004\u0008/\u0010\u0017J\u000f\u00102\u001a\u00020\nH\u0007¢\u0006\u0004\u00081\u0010\u0017J\u000f\u00104\u001a\u00020\nH\u0007¢\u0006\u0004\u00083\u0010\u0017J\u000f\u00106\u001a\u00020\u0011H\u0007¢\u0006\u0004\u00085\u0010$J\u000f\u00108\u001a\u00020\u0011H\u0007¢\u0006\u0004\u00087\u0010$J\u000f\u0010:\u001a\u00020\nH\u0007¢\u0006\u0004\u00089\u0010\u0017J\u0015\u0010=\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0004\u0008;\u0010<J\u0015\u0010?\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000eH\u0007¢\u0006\u0004\u0008>\u0010<J\u0011\u0010A\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\u0008@\u0010\u0017J\u0011\u0010C\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\u0008B\u0010\u0017J\u000f\u0010E\u001a\u00020\u0011H\u0007¢\u0006\u0004\u0008D\u0010$J\u0015\u0010I\u001a\u0008\u0012\u0004\u0012\u00020\n0FH\u0007¢\u0006\u0004\u0008G\u0010HJ\u0011\u0010K\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\u0008J\u0010\u0017J\u0011\u0010M\u001a\u0004\u0018\u00010\nH\u0007¢\u0006\u0004\u0008L\u0010\u0017R\u0015\u0010C\u001a\u0004\u0018\u00010\n8G@\u0006¢\u0006\u0006\u001a\u0004\u0008C\u0010\u0017R\u0019\u0010.\u001a\u00020\n8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008.\u0010N\u001a\u0004\u0008.\u0010\u0017R\u0013\u0010E\u001a\u00020\u00118G@\u0006¢\u0006\u0006\u001a\u0004\u0008E\u0010$R\u0015\u0010K\u001a\u0004\u0018\u00010\n8G@\u0006¢\u0006\u0006\u001a\u0004\u0008K\u0010\u0017R\u0015\u0010A\u001a\u0004\u0018\u00010\n8G@\u0006¢\u0006\u0006\u001a\u0004\u0008A\u0010\u0017R\u0019\u0010I\u001a\u0008\u0012\u0004\u0012\u00020\n0F8G@\u0006¢\u0006\u0006\u001a\u0004\u0008I\u0010HR\u001f\u0010?\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000e8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008?\u0010O\u001a\u0004\u0008?\u0010<R\u0013\u0010,\u001a\u00020\n8G@\u0006¢\u0006\u0006\u001a\u0004\u0008,\u0010\u0017R\u0019\u0010=\u001a\u0008\u0012\u0004\u0012\u00020\n0\u000e8G@\u0006¢\u0006\u0006\u001a\u0004\u0008=\u0010<R\u0013\u00100\u001a\u00020\n8G@\u0006¢\u0006\u0006\u001a\u0004\u00080\u0010\u0017R\u0019\u0010P\u001a\u00020 8\u0006@\u0006¢\u0006\u000c\n\u0004\u0008P\u0010Q\u001a\u0004\u0008P\u0010RR\u0019\u0010*\u001a\u00020\n8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008*\u0010N\u001a\u0004\u0008*\u0010\u0017R\u001b\u0010M\u001a\u0004\u0018\u00010\n8\u0007@\u0006¢\u0006\u000c\n\u0004\u0008M\u0010N\u001a\u0004\u0008M\u0010\u0017R\u0013\u00108\u001a\u00020\u00118G@\u0006¢\u0006\u0006\u001a\u0004\u00088\u0010$R\u0019\u00104\u001a\u00020\n8\u0007@\u0006¢\u0006\u000c\n\u0004\u00084\u0010N\u001a\u0004\u00084\u0010\u0017R\u0019\u00106\u001a\u00020\u00118\u0007@\u0006¢\u0006\u000c\n\u0004\u00086\u0010S\u001a\u0004\u00086\u0010$R \u0010T\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008T\u0010OR\u0019\u00102\u001a\u00020\n8\u0007@\u0006¢\u0006\u000c\n\u0004\u00082\u0010N\u001a\u0004\u00082\u0010\u0017R\u0016\u0010\u0003\u001a\u00020\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008\u0003\u0010NR\u0013\u0010:\u001a\u00020\n8G@\u0006¢\u0006\u0006\u001a\u0004\u0008:\u0010\u0017¨\u0006Y", d2 = {"Lokhttp3/HttpUrl;", "", "Ljava/net/URL;", "url", "()Ljava/net/URL;", "toUrl", "Ljava/net/URI;", "uri", "()Ljava/net/URI;", "toUri", "", "name", "queryParameter", "(Ljava/lang/String;)Ljava/lang/String;", "", "queryParameterValues", "(Ljava/lang/String;)Ljava/util/List;", "", "index", "queryParameterName", "(I)Ljava/lang/String;", "queryParameterValue", "redact", "()Ljava/lang/String;", "link", "resolve", "(Ljava/lang/String;)Lokhttp3/HttpUrl;", "Lokhttp3/HttpUrl$Builder;", "newBuilder", "()Lokhttp3/HttpUrl$Builder;", "(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "topPrivateDomain", "-deprecated_url", "-deprecated_uri", "-deprecated_scheme", "scheme", "-deprecated_encodedUsername", "encodedUsername", "-deprecated_username", "username", "-deprecated_encodedPassword", "encodedPassword", "-deprecated_password", "password", "-deprecated_host", "host", "-deprecated_port", "port", "-deprecated_pathSize", "pathSize", "-deprecated_encodedPath", "encodedPath", "-deprecated_encodedPathSegments", "()Ljava/util/List;", "encodedPathSegments", "-deprecated_pathSegments", "pathSegments", "-deprecated_encodedQuery", "encodedQuery", "-deprecated_query", "query", "-deprecated_querySize", "querySize", "", "-deprecated_queryParameterNames", "()Ljava/util/Set;", "queryParameterNames", "-deprecated_encodedFragment", "encodedFragment", "-deprecated_fragment", "fragment", "Ljava/lang/String;", "Ljava/util/List;", "isHttps", "Z", "()Z", "I", "queryNamesAndValues", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
public final class HttpUrl {

    public static final okhttp3.HttpUrl.Companion Companion = null;
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = null;
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    @Metadata(bv = {1, 0, 3}, d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u00087\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010!\n\u0002\u0008\u0012\u0018\u0000 e2\u00020\u0001:\u0001eB\u0007¢\u0006\u0004\u0008d\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0008\u001a\u00020\u0007H\u0002¢\u0006\u0004\u0008\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u000c2\u0006\u0010\u000b\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ'\u0010\u0012\u001a\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0002¢\u0006\u0004\u0008\u0012\u0010\u0013J7\u0010\u0016\u001a\u00020\u000c2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H\u0002¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\u000cH\u0002¢\u0006\u0004\u0008\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0005¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u0015\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0005¢\u0006\u0004\u0008\u001f\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00002\u0006\u0010 \u001a\u00020\u0005¢\u0006\u0004\u0008 \u0010\u001eJ\u0015\u0010!\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u0005¢\u0006\u0004\u0008!\u0010\u001eJ\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0005¢\u0006\u0004\u0008\"\u0010\u001eJ\u0015\u0010#\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0005¢\u0006\u0004\u0008#\u0010\u001eJ\u0015\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0002¢\u0006\u0004\u0008$\u0010%J\u0015\u0010'\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u0005¢\u0006\u0004\u0008'\u0010\u001eJ\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\u0008\t\u0010\u001eJ\u0015\u0010)\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0005¢\u0006\u0004\u0008)\u0010\u001eJ\u0015\u0010+\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u0005¢\u0006\u0004\u0008+\u0010\u001eJ\u001d\u0010-\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0005¢\u0006\u0004\u0008-\u0010.J\u001d\u0010/\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0005¢\u0006\u0004\u0008/\u0010.J\u0015\u00100\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0002¢\u0006\u0004\u00080\u0010%J\u0015\u00101\u001a\u00020\u00002\u0006\u00101\u001a\u00020\u0005¢\u0006\u0004\u00081\u0010\u001eJ\u0017\u00102\u001a\u00020\u00002\u0008\u00102\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u00082\u0010\u001eJ\u0017\u00103\u001a\u00020\u00002\u0008\u00103\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u00083\u0010\u001eJ\u001f\u00106\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u00052\u0008\u00105\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u00086\u00107J\u001f\u0010:\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u00052\u0008\u00109\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u0008:\u00107J\u001f\u0010;\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u00052\u0008\u00105\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u0008;\u00107J\u001f\u0010<\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u00052\u0008\u00109\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u0008<\u00107J\u0015\u0010=\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0005¢\u0006\u0004\u0008=\u0010\u001eJ\u0015\u0010>\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u0005¢\u0006\u0004\u0008>\u0010\u001eJ\u0017\u0010?\u001a\u00020\u00002\u0008\u0010?\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u0008?\u0010\u001eJ\u0017\u0010@\u001a\u00020\u00002\u0008\u0010@\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u0008@\u0010\u001eJ\u000f\u0010C\u001a\u00020\u0000H\u0000¢\u0006\u0004\u0008A\u0010BJ\r\u0010E\u001a\u00020D¢\u0006\u0004\u0008E\u0010FJ\u000f\u0010G\u001a\u00020\u0005H\u0016¢\u0006\u0004\u0008G\u0010HJ!\u0010L\u001a\u00020\u00002\u0008\u0010I\u001a\u0004\u0018\u00010D2\u0006\u0010\u000f\u001a\u00020\u0005H\u0000¢\u0006\u0004\u0008J\u0010KR\"\u0010$\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008$\u0010M\u001a\u0004\u0008N\u0010\u0004\"\u0004\u0008O\u0010PR\"\u0010\"\u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\"\u0010Q\u001a\u0004\u0008R\u0010H\"\u0004\u0008S\u0010\u000eR\"\u0010*\u001a\u0008\u0012\u0004\u0012\u00020\u00050T8\u0000@\u0000X\u0080\u0004¢\u0006\u000c\n\u0004\u0008*\u0010U\u001a\u0004\u0008V\u0010WR,\u0010X\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010T8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008X\u0010U\u001a\u0004\u0008Y\u0010W\"\u0004\u0008Z\u0010[R$\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008\u001d\u0010Q\u001a\u0004\u0008\\\u0010H\"\u0004\u0008]\u0010\u000eR$\u0010#\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008#\u0010Q\u001a\u0004\u0008^\u0010H\"\u0004\u0008_\u0010\u000eR$\u0010@\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008@\u0010Q\u001a\u0004\u0008`\u0010H\"\u0004\u0008a\u0010\u000eR\"\u0010 \u001a\u00020\u00058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\u0008 \u0010Q\u001a\u0004\u0008b\u0010H\"\u0004\u0008c\u0010\u000e¨\u0006f", d2 = {"Lokhttp3/HttpUrl$Builder;", "", "", "effectivePort", "()I", "", "pathSegments", "", "alreadyEncoded", "addPathSegments", "(Ljava/lang/String;Z)Lokhttp3/HttpUrl$Builder;", "canonicalName", "Lkotlin/w;", "removeAllCanonicalQueryParameters", "(Ljava/lang/String;)V", "input", "startPos", "limit", "resolvePath", "(Ljava/lang/String;II)V", "pos", "addTrailingSlash", "push", "(Ljava/lang/String;IIZZ)V", "isDot", "(Ljava/lang/String;)Z", "isDotDot", "pop", "()V", "scheme", "(Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "username", "encodedUsername", "password", "encodedPassword", "host", "port", "(I)Lokhttp3/HttpUrl$Builder;", "pathSegment", "addPathSegment", "encodedPathSegment", "addEncodedPathSegment", "encodedPathSegments", "addEncodedPathSegments", "index", "setPathSegment", "(ILjava/lang/String;)Lokhttp3/HttpUrl$Builder;", "setEncodedPathSegment", "removePathSegment", "encodedPath", "query", "encodedQuery", "name", "value", "addQueryParameter", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "encodedName", "encodedValue", "addEncodedQueryParameter", "setQueryParameter", "setEncodedQueryParameter", "removeAllQueryParameters", "removeAllEncodedQueryParameters", "fragment", "encodedFragment", "reencodeForUri$okhttp", "()Lokhttp3/HttpUrl$Builder;", "reencodeForUri", "Lokhttp3/HttpUrl;", "build", "()Lokhttp3/HttpUrl;", "toString", "()Ljava/lang/String;", "base", "parse$okhttp", "(Lokhttp3/HttpUrl;Ljava/lang/String;)Lokhttp3/HttpUrl$Builder;", "parse", "I", "getPort$okhttp", "setPort$okhttp", "(I)V", "Ljava/lang/String;", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "", "Ljava/util/List;", "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "encodedQueryNamesAndValues", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "getScheme$okhttp", "setScheme$okhttp", "getHost$okhttp", "setHost$okhttp", "getEncodedFragment$okhttp", "setEncodedFragment$okhttp", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "<init>", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Builder {

        public static final okhttp3.HttpUrl.Builder.Companion Companion = null;
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private String encodedPassword;
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String encodedUsername;
        private String host;
        private int port = -1;
        private String scheme;
        static {
            HttpUrl.Builder.Companion companion = new HttpUrl.Builder.Companion(0);
            HttpUrl.Builder.Companion = companion;
        }

        public Builder() {
            super();
            final String str = "";
            this.encodedUsername = str;
            this.encodedPassword = str;
            int i = -1;
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add(str);
        }

        private final okhttp3.HttpUrl.Builder addPathSegments(String string, boolean z2) {
            int length2;
            int length;
            String str;
            int i;
            int i3;
            int i2;
            boolean z;
            int delimiterOffset;
            final int i4 = 0;
            i = i4;
            delimiterOffset = Util.delimiterOffset(string, "/\\", i, string.length());
            do {
                delimiterOffset = Util.delimiterOffset(string, "/\\", i, string.length());
                i2 = i4;
                this.push(string, i, delimiterOffset, i2, z2);
                if (delimiterOffset + 1 <= string.length()) {
                }
                i2 = length;
            } while (delimiterOffset < string.length());
            return this;
        }

        private final int effectivePort() {
            int defaultPort;
            int scheme;
            if (this.port != -1) {
            } else {
                scheme = this.scheme;
                n.d(scheme);
                defaultPort = HttpUrl.Companion.defaultPort(scheme);
            }
            return defaultPort;
        }

        private final boolean isDot(String string) {
            boolean str;
            int i;
            Object obj3;
            if (!n.b(string, ".")) {
                if (l.x(string, "%2e", true)) {
                } else {
                    i = 0;
                }
            }
            return i;
        }

        private final boolean isDotDot(String string) {
            boolean str;
            int i;
            Object obj3;
            i = 1;
            if (!n.b(string, "..") && !l.x(string, "%2e.", i) && !l.x(string, ".%2e", i)) {
                if (!l.x(string, "%2e.", i)) {
                    if (!l.x(string, ".%2e", i)) {
                        if (l.x(string, "%2e%2e", i)) {
                        } else {
                            i = 0;
                        }
                    }
                }
            }
            return i;
        }

        private final void pop() {
            int i;
            List encodedPathSegments;
            int i2;
            List encodedPathSegments2 = this.encodedPathSegments;
            final int i4 = 1;
            i = (String)encodedPathSegments2.remove(size -= i4).length() == 0 ? i4 : 0;
            String str = "";
            if (i != 0 && empty ^= i4 != 0) {
                if (empty ^= i4 != 0) {
                    encodedPathSegments = this.encodedPathSegments;
                    encodedPathSegments.set(size2 -= i4, str);
                } else {
                    this.encodedPathSegments.add(str);
                }
            } else {
            }
        }

        private final void push(String string, int i2, int i3, boolean z4, boolean z5) {
            Object encodedPathSegments;
            int i4;
            List encodedPathSegments2;
            int i;
            final Object obj = this;
            encodedPathSegments = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, string, i2, i3, " \"<>^`{}|/\\?#", z5, false, false, false, 0, 240, 0);
            if (isDot(encodedPathSegments)) {
            }
            if (isDotDot(encodedPathSegments)) {
                pop();
            }
            List encodedPathSegments3 = obj.encodedPathSegments;
            int i7 = 1;
            i4 = (CharSequence)encodedPathSegments3.get(size -= i7).length() == 0 ? i7 : 0;
            if (i4 != 0) {
                encodedPathSegments2 = obj.encodedPathSegments;
                encodedPathSegments2.set(size2 -= i7, encodedPathSegments);
            } else {
                obj.encodedPathSegments.add(encodedPathSegments);
            }
            if (z4) {
                obj.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String string) {
            int i2;
            boolean empty;
            int i;
            List encodedQueryNamesAndValues = this.encodedQueryNamesAndValues;
            n.d(encodedQueryNamesAndValues);
            int i5 = 2;
            d dVar2 = g.k(g.i(size -= i5, 0), i5);
            i2 = dVar2.d();
            int i7 = dVar2.g();
            int i4 = dVar2.h();
            if (i4 >= 0) {
                if (i2 <= i7) {
                    List encodedQueryNamesAndValues2 = this.encodedQueryNamesAndValues;
                    n.d(encodedQueryNamesAndValues2);
                    while (n.b(string, (String)encodedQueryNamesAndValues2.get(i2))) {
                        List encodedQueryNamesAndValues3 = this.encodedQueryNamesAndValues;
                        n.d(encodedQueryNamesAndValues3);
                        encodedQueryNamesAndValues3.remove(i2 + 1);
                        List encodedQueryNamesAndValues4 = this.encodedQueryNamesAndValues;
                        n.d(encodedQueryNamesAndValues4);
                        encodedQueryNamesAndValues4.remove(i2);
                        List encodedQueryNamesAndValues5 = this.encodedQueryNamesAndValues;
                        n.d(encodedQueryNamesAndValues5);
                        i2 += i4;
                        encodedQueryNamesAndValues2 = this.encodedQueryNamesAndValues;
                        n.d(encodedQueryNamesAndValues2);
                    }
                    this.encodedQueryNamesAndValues = 0;
                }
            } else {
                if (i2 >= i7) {
                }
            }
        }

        private final void resolvePath(String string, int i2, int i3) {
            List encodedPathSegments;
            int i6;
            Object obj;
            String str;
            int i;
            int i5;
            List list;
            int i4;
            int obj12;
            if (i2 == i3) {
            }
            char charAt = string.charAt(i2);
            final String str2 = "";
            final int i7 = 1;
            if (charAt != 47) {
                if (charAt == 92) {
                    this.encodedPathSegments.clear();
                    this.encodedPathSegments.add(str2);
                    obj12++;
                } else {
                    encodedPathSegments = this.encodedPathSegments;
                    encodedPathSegments.set(size -= i7, str2);
                }
            } else {
            }
            i = obj12;
            while (i < i3) {
                obj12 = Util.delimiterOffset(string, "/\\", i, i3);
                if (obj12 < i3) {
                } else {
                }
                encodedPathSegments = 0;
                this.push(string, i, obj12, encodedPathSegments, true);
                if (encodedPathSegments != null) {
                    break;
                }
                i = obj12;
                encodedPathSegments = i7;
            }
        }

        public final okhttp3.HttpUrl.Builder addEncodedPathSegment(String string) {
            n.f(string, "encodedPathSegment");
            this.push(string, 0, string.length(), false, true);
            return this;
        }

        public final okhttp3.HttpUrl.Builder addEncodedPathSegments(String string) {
            n.f(string, "encodedPathSegments");
            return addPathSegments(string, true);
        }

        public final okhttp3.HttpUrl.Builder addEncodedQueryParameter(String string, String string2) {
            Object encodedQueryNamesAndValues;
            String canonicalize$okhttp$default;
            String str2;
            int i;
            int i6;
            String str;
            int i5;
            int i4;
            int i2;
            int i3;
            int i7;
            int i8;
            int i9;
            final Object obj = this;
            n.f(string, "encodedName");
            if (obj.encodedQueryNamesAndValues == null) {
                encodedQueryNamesAndValues = new ArrayList();
                obj.encodedQueryNamesAndValues = encodedQueryNamesAndValues;
            }
            List encodedQueryNamesAndValues2 = obj.encodedQueryNamesAndValues;
            n.d(encodedQueryNamesAndValues2);
            final okhttp3.HttpUrl.Companion companion3 = HttpUrl.Companion;
            encodedQueryNamesAndValues2.add(HttpUrl.Companion.canonicalize$okhttp$default(companion3, string, 0, 0, " \"'<>#&=", true, false, true, false, 0, 211, 0));
            List encodedQueryNamesAndValues3 = obj.encodedQueryNamesAndValues;
            n.d(encodedQueryNamesAndValues3);
            if (string2 != null) {
                canonicalize$okhttp$default = HttpUrl.Companion.canonicalize$okhttp$default(companion3, string2, 0, 0, " \"'<>#&=", true, false, true, false, 0, 211, 0);
            } else {
                canonicalize$okhttp$default = 0;
            }
            encodedQueryNamesAndValues3.add(canonicalize$okhttp$default);
            return obj;
        }

        public final okhttp3.HttpUrl.Builder addPathSegment(String string) {
            n.f(string, "pathSegment");
            this.push(string, 0, string.length(), false, false);
            return this;
        }

        public final okhttp3.HttpUrl.Builder addPathSegments(String string) {
            n.f(string, "pathSegments");
            return addPathSegments(string, false);
        }

        public final okhttp3.HttpUrl.Builder addQueryParameter(String string, String string2) {
            Object encodedQueryNamesAndValues;
            String canonicalize$okhttp$default;
            String str;
            int i6;
            int i;
            String str2;
            int i3;
            int i2;
            int i9;
            int i7;
            int i5;
            int i8;
            int i4;
            final Object obj = this;
            n.f(string, "name");
            if (obj.encodedQueryNamesAndValues == null) {
                encodedQueryNamesAndValues = new ArrayList();
                obj.encodedQueryNamesAndValues = encodedQueryNamesAndValues;
            }
            List encodedQueryNamesAndValues2 = obj.encodedQueryNamesAndValues;
            n.d(encodedQueryNamesAndValues2);
            final okhttp3.HttpUrl.Companion companion3 = HttpUrl.Companion;
            encodedQueryNamesAndValues2.add(HttpUrl.Companion.canonicalize$okhttp$default(companion3, string, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, 0, 219, 0));
            List encodedQueryNamesAndValues3 = obj.encodedQueryNamesAndValues;
            n.d(encodedQueryNamesAndValues3);
            if (string2 != null) {
                canonicalize$okhttp$default = HttpUrl.Companion.canonicalize$okhttp$default(companion3, string2, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, 0, 219, 0);
            } else {
                canonicalize$okhttp$default = 0;
            }
            encodedQueryNamesAndValues3.add(canonicalize$okhttp$default);
            return obj;
        }

        public final okhttp3.HttpUrl build() {
            Object encodedQueryNamesAndValues;
            int percentDecode$okhttp$default2;
            boolean next;
            int percentDecode$okhttp$default;
            ArrayList arrayList;
            okhttp3.HttpUrl.Companion companion;
            String str;
            Object obj;
            int i;
            int i2;
            int i3;
            int i4;
            int i5;
            final Object obj2 = this;
            String scheme = obj2.scheme;
            if (scheme == null) {
            } else {
                int i6 = 0;
                int i7 = 0;
                int i8 = 0;
                int i9 = 7;
                int i11 = 0;
                okhttp3.HttpUrl.Companion companion3 = companion2;
                String host = obj2.host;
                if (host == null) {
                } else {
                    List encodedPathSegments = obj2.encodedPathSegments;
                    next = 10;
                    ArrayList arrayList2 = new ArrayList(p.r(encodedPathSegments, next));
                    Iterator iterator = encodedPathSegments.iterator();
                    for (Object next4 : iterator) {
                        arrayList2.add(HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, (String)next4, 0, 0, false, 7, 0));
                    }
                    encodedQueryNamesAndValues = obj2.encodedQueryNamesAndValues;
                    int i10 = 0;
                    if (encodedQueryNamesAndValues != null) {
                        arrayList = new ArrayList(p.r(encodedQueryNamesAndValues, next));
                        encodedQueryNamesAndValues = encodedQueryNamesAndValues.iterator();
                        while (encodedQueryNamesAndValues.hasNext()) {
                            obj = next2;
                            if ((String)obj != null) {
                            } else {
                            }
                            percentDecode$okhttp$default2 = i10;
                            arrayList.add(percentDecode$okhttp$default2);
                            percentDecode$okhttp$default2 = HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, (String)obj, 0, 0, true, 3, 0);
                        }
                    } else {
                        arrayList = i10;
                    }
                    String encodedFragment = obj2.encodedFragment;
                    if (encodedFragment != null) {
                        str = encodedQueryNamesAndValues;
                    } else {
                        str = i10;
                    }
                    super(scheme, HttpUrl.Companion.percentDecode$okhttp$default(companion3, obj2.encodedUsername, i6, i7, i8, i9, i11), HttpUrl.Companion.percentDecode$okhttp$default(companion3, obj2.encodedPassword, i6, i7, i8, i9, i11), host, effectivePort(), arrayList2, arrayList, str, toString());
                    return httpUrl2;
                }
                IllegalStateException illegalStateException = new IllegalStateException("host == null");
                throw illegalStateException;
            }
            IllegalStateException illegalStateException2 = new IllegalStateException("scheme == null");
            throw illegalStateException2;
        }

        public final okhttp3.HttpUrl.Builder encodedFragment(String string) {
            okhttp3.HttpUrl.Companion companion;
            String str2;
            int i;
            int i3;
            String str;
            int i6;
            int i4;
            int i7;
            int i2;
            int i8;
            int i9;
            int i5;
            String obj13;
            if (string != null) {
                obj13 = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, string, 0, 0, "", true, false, false, true, 0, 179, 0);
            } else {
                obj13 = 0;
            }
            this.encodedFragment = obj13;
            return this;
        }

        public final okhttp3.HttpUrl.Builder encodedPassword(String string) {
            n.f(string, "encodedPassword");
            this.encodedPassword = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, string, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 0, 243, 0);
            return this;
        }

        public final okhttp3.HttpUrl.Builder encodedPath(String string) {
            n.f(string, "encodedPath");
            int i = 0;
            if (!l.M(string, "/", i, 2, 0)) {
            } else {
                resolvePath(string, i, string.length());
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected encodedPath: ");
            stringBuilder.append(string);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString().toString());
            throw illegalArgumentException;
        }

        public final okhttp3.HttpUrl.Builder encodedQuery(String string) {
            okhttp3.HttpUrl.Companion companion;
            String str;
            int i6;
            int i5;
            String str2;
            int i7;
            int i8;
            int i;
            int i2;
            int i9;
            int i3;
            int i4;
            okhttp3.HttpUrl.Companion companion2;
            String obj14;
            companion2 = HttpUrl.Companion;
            obj14 = HttpUrl.Companion.canonicalize$okhttp$default(companion2, string, 0, 0, " \"'<>#", true, false, true, false, 0, 211, 0);
            if (string != null && obj14 != null) {
                companion2 = HttpUrl.Companion;
                obj14 = HttpUrl.Companion.canonicalize$okhttp$default(companion2, string, 0, 0, " \"'<>#", true, false, true, false, 0, 211, 0);
                if (obj14 != null) {
                    obj14 = companion2.toQueryNamesAndValues$okhttp(obj14);
                } else {
                    obj14 = 0;
                }
            } else {
            }
            this.encodedQueryNamesAndValues = obj14;
            return this;
        }

        public final okhttp3.HttpUrl.Builder encodedUsername(String string) {
            n.f(string, "encodedUsername");
            this.encodedUsername = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, string, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 0, 243, 0);
            return this;
        }

        public final okhttp3.HttpUrl.Builder fragment(String string) {
            okhttp3.HttpUrl.Companion companion;
            String str2;
            int i8;
            int i7;
            String str;
            int i4;
            int i3;
            int i2;
            int i;
            int i6;
            int i5;
            int i9;
            String obj13;
            if (string != null) {
                obj13 = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, string, 0, 0, "", false, false, false, true, 0, 187, 0);
            } else {
                obj13 = 0;
            }
            this.encodedFragment = obj13;
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final okhttp3.HttpUrl.Builder host(String string) {
            n.f(string, "host");
            String canonicalHost = HostnamesKt.toCanonicalHost(HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, string, 0, 0, false, 7, 0));
            if (canonicalHost == null) {
            } else {
                this.host = canonicalHost;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected host: ");
            stringBuilder.append(string);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        public final okhttp3.HttpUrl.Builder parse$okhttp(okhttp3.HttpUrl httpUrl, String string2) {
            int indexOfFirstNonAsciiWhitespace$default;
            int canonicalize$okhttp$default;
            int defaultPort;
            String canonicalize$okhttp$default2;
            String encodedPathSegments;
            int delimiterOffset4;
            int stringBuilder;
            int encodedPathSegments2;
            int encodedUsername;
            String delimiterOffset;
            boolean str4;
            int delimiterOffset2;
            int i6;
            int i20;
            int i13;
            String i12;
            int i5;
            okhttp3.HttpUrl.Companion companion;
            int i8;
            int i7;
            String str3;
            int i19;
            int indexOfLastNonAsciiWhitespace$default;
            int delimiterOffset3;
            int i10;
            String str2;
            int i21;
            int i15;
            int i18;
            int i16;
            int i3;
            int i17;
            int i11;
            int i;
            int i2;
            String str;
            int i14;
            int i9;
            int i4;
            final Object obj = this;
            final Object obj2 = string2;
            n.f(obj2, "input");
            i19 = 0;
            int i25 = 0;
            indexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(obj2, i19, i19, 3, i25);
            encodedUsername = 2;
            indexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(obj2, indexOfFirstNonAsciiWhitespace$default, i19, encodedUsername, i25);
            okhttp3.HttpUrl.Builder.Companion companion9 = HttpUrl.Builder.Companion;
            int i26 = HttpUrl.Builder.Companion.access$schemeDelimiterOffset(companion9, obj2, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
            companion = 1;
            if (i26 != -1) {
                if (l.J(obj2, "https:", indexOfFirstNonAsciiWhitespace$default, companion)) {
                    obj.scheme = "https";
                    indexOfFirstNonAsciiWhitespace$default += 6;
                    stringBuilder = HttpUrl.Builder.Companion.access$slashCount(companion9, obj2, indexOfFirstNonAsciiWhitespace$default, indexOfLastNonAsciiWhitespace$default);
                    i5 = 63;
                    if (stringBuilder < encodedUsername && httpUrl != null) {
                        if (httpUrl != null) {
                            if (z ^= companion != 0) {
                                i20 = canonicalize$okhttp$default;
                                i10 = delimiterOffset3;
                                delimiterOffset2 = Util.delimiterOffset(obj2, "@/\\?#", i20, indexOfLastNonAsciiWhitespace$default);
                                while (delimiterOffset2 != indexOfLastNonAsciiWhitespace$default) {
                                    canonicalize$okhttp$default = obj2.charAt(delimiterOffset2);
                                    if (canonicalize$okhttp$default != i7) {
                                    }
                                    if (canonicalize$okhttp$default != i12) {
                                    }
                                    if (canonicalize$okhttp$default != 47) {
                                    }
                                    if (canonicalize$okhttp$default != 92) {
                                    }
                                    if (canonicalize$okhttp$default != i5) {
                                    }
                                    if (canonicalize$okhttp$default != 64) {
                                    } else {
                                    }
                                    String str15 = "%40";
                                    if (delimiterOffset3 == 0) {
                                    } else {
                                    }
                                    i15 = companion;
                                    i16 = indexOfLastNonAsciiWhitespace$default;
                                    int i34 = delimiterOffset2;
                                    StringBuilder stringBuilder5 = new StringBuilder();
                                    stringBuilder5.append(obj.encodedPassword);
                                    stringBuilder5.append(str15);
                                    i19 = stringBuilder5;
                                    str2 = str22;
                                    indexOfLastNonAsciiWhitespace$default = i34;
                                    i19.append(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, string2, i20, i34, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 0, 240, 0));
                                    obj.encodedPassword = i19.toString();
                                    companion = i10;
                                    i20 = indexOfLastNonAsciiWhitespace$default + 1;
                                    i10 = companion;
                                    str3 = str2;
                                    companion = i15;
                                    indexOfLastNonAsciiWhitespace$default = i16;
                                    i12 = 35;
                                    i5 = 63;
                                    i7 = -1;
                                    i19 = 0;
                                    delimiterOffset2 = Util.delimiterOffset(obj2, "@/\\?#", i20, indexOfLastNonAsciiWhitespace$default);
                                    canonicalize$okhttp$default = i7;
                                    delimiterOffset = Util.delimiterOffset(obj2, ':', i20, delimiterOffset2);
                                    okhttp3.HttpUrl.Companion companion12 = HttpUrl.Companion;
                                    i15 = companion;
                                    i16 = indexOfLastNonAsciiWhitespace$default;
                                    if (i10 != 0) {
                                    }
                                    obj.encodedUsername = canonicalize$okhttp$default2;
                                    i19 = i9;
                                    canonicalize$okhttp$default = i4;
                                    if (canonicalize$okhttp$default != i19) {
                                    } else {
                                    }
                                    i8 = delimiterOffset3;
                                    delimiterOffset3 = i8;
                                    str2 = str21;
                                    companion = i15;
                                    indexOfLastNonAsciiWhitespace$default = i19;
                                    obj.encodedPassword = HttpUrl.Companion.canonicalize$okhttp$default(companion12, string2, canonicalize$okhttp$default + 1, i19, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 0, 240, 0);
                                    i8 = i15;
                                    stringBuilder = new StringBuilder();
                                    stringBuilder.append(obj.encodedUsername);
                                    stringBuilder.append(str15);
                                    stringBuilder.append(HttpUrl.Companion.canonicalize$okhttp$default(companion12, string2, i20, delimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 0, 240, 0));
                                    canonicalize$okhttp$default2 = stringBuilder.toString();
                                    i15 = companion;
                                    str2 = str3;
                                    i16 = indexOfLastNonAsciiWhitespace$default;
                                }
                                i21 = companion;
                                str2 = str3;
                                i18 = indexOfLastNonAsciiWhitespace$default;
                                indexOfLastNonAsciiWhitespace$default = delimiterOffset2;
                                okhttp3.HttpUrl.Builder.Companion companion10 = HttpUrl.Builder.Companion;
                                i5 = HttpUrl.Builder.Companion.access$portColonOffset(companion10, obj2, i20, indexOfLastNonAsciiWhitespace$default);
                                companion = i5 + 1;
                                i7 = 34;
                                if (companion < indexOfLastNonAsciiWhitespace$default) {
                                    i19 = i20;
                                    obj.host = HostnamesKt.toCanonicalHost(HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, string2, i20, i5, false, 4, 0));
                                    int i23 = HttpUrl.Builder.Companion.access$parsePort(companion10, obj2, companion, indexOfLastNonAsciiWhitespace$default);
                                    obj.port = i23;
                                    defaultPort = i23 != -1 ? i21 : 0;
                                    if (defaultPort == 0) {
                                    } else {
                                        i12 = str2;
                                        i14 = obj.host != null ? i21 : 0;
                                        if (i14 == 0) {
                                        } else {
                                            indexOfFirstNonAsciiWhitespace$default = indexOfLastNonAsciiWhitespace$default;
                                            int i35 = i18;
                                            delimiterOffset4 = Util.delimiterOffset(obj2, "?#", indexOfFirstNonAsciiWhitespace$default, i35);
                                            obj.resolvePath(obj2, indexOfFirstNonAsciiWhitespace$default, delimiterOffset4);
                                            if (delimiterOffset4 < i35 && obj2.charAt(delimiterOffset4) == 63) {
                                                if (obj2.charAt(delimiterOffset4) == 63) {
                                                    delimiterOffset3 = Util.delimiterOffset(obj2, '#', delimiterOffset4, i35);
                                                    okhttp3.HttpUrl.Companion companion11 = HttpUrl.Companion;
                                                    obj.encodedQueryNamesAndValues = companion11.toQueryNamesAndValues$okhttp(HttpUrl.Companion.canonicalize$okhttp$default(companion11, string2, delimiterOffset4 + 1, delimiterOffset3, " \"'<>#", true, false, true, false, 0, 208, 0));
                                                    delimiterOffset4 = delimiterOffset3;
                                                }
                                            }
                                            if (delimiterOffset4 < i35 && obj2.charAt(delimiterOffset4) == 35) {
                                                if (obj2.charAt(delimiterOffset4) == 35) {
                                                    obj.encodedFragment = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, string2, delimiterOffset4 + 1, i35, "", true, false, false, true, 0, 176, 0);
                                                }
                                            }
                                        }
                                    }
                                    StringBuilder stringBuilder3 = new StringBuilder();
                                    stringBuilder3.append("Invalid URL port: \"");
                                    String substring2 = obj2.substring(companion, indexOfLastNonAsciiWhitespace$default);
                                    n.e(substring2, str2);
                                    stringBuilder3.append(substring2);
                                    stringBuilder3.append(i7);
                                    IllegalArgumentException illegalArgumentException4 = new IllegalArgumentException(stringBuilder3.toString().toString());
                                    throw illegalArgumentException4;
                                }
                                i12 = str2;
                                companion = HttpUrl.Companion;
                                obj.host = HostnamesKt.toCanonicalHost(HttpUrl.Companion.percentDecode$okhttp$default(companion, string2, i20, i5, false, 4, 0));
                                String scheme = obj.scheme;
                                n.d(scheme);
                                obj.port = companion.defaultPort(scheme);
                            } else {
                                obj.encodedUsername = httpUrl.encodedUsername();
                                obj.encodedPassword = httpUrl.encodedPassword();
                                obj.host = httpUrl.host();
                                obj.port = httpUrl.port();
                                obj.encodedPathSegments.clear();
                                obj.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                                if (indexOfFirstNonAsciiWhitespace$default != indexOfLastNonAsciiWhitespace$default) {
                                    if (obj2.charAt(indexOfFirstNonAsciiWhitespace$default) == 35) {
                                        obj.encodedQuery(httpUrl.encodedQuery());
                                    }
                                } else {
                                }
                                i21 = companion;
                                i18 = indexOfLastNonAsciiWhitespace$default;
                            }
                            return obj;
                        } else {
                        }
                    } else {
                    }
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("Invalid URL host: \"");
                    String substring = obj2.substring(i19, i5);
                    n.e(substring, i12);
                    stringBuilder2.append(substring);
                    stringBuilder2.append(i7);
                    IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder2.toString().toString());
                    throw illegalArgumentException3;
                } else {
                    if (!l.J(obj2, "http:", indexOfFirstNonAsciiWhitespace$default, companion)) {
                    } else {
                        obj.scheme = "http";
                        indexOfFirstNonAsciiWhitespace$default += 5;
                    }
                }
                StringBuilder stringBuilder4 = new StringBuilder();
                stringBuilder4.append("Expected URL scheme 'http' or 'https' but was '");
                String substring3 = obj2.substring(i19, i26);
                n.e(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                stringBuilder4.append(substring3);
                stringBuilder4.append("'");
                IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder4.toString());
                throw illegalArgumentException2;
            }
            if (httpUrl == null) {
            } else {
                obj.scheme = httpUrl.scheme();
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            throw illegalArgumentException;
        }

        public final okhttp3.HttpUrl.Builder password(String string) {
            n.f(string, "password");
            this.encodedPassword = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, string, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 0, 251, 0);
            return this;
        }

        public final okhttp3.HttpUrl.Builder port(int i) {
            int i2;
            int i3;
            if (1 > i) {
                i2 = 0;
            } else {
                if (65535 >= i) {
                } else {
                }
            }
            if (i2 == 0) {
            } else {
                this.port = i;
                return this;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected port: ");
            stringBuilder.append(i);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString().toString());
            throw illegalArgumentException;
        }

        public final okhttp3.HttpUrl.Builder query(String string) {
            okhttp3.HttpUrl.Companion companion2;
            String str;
            int i8;
            int i3;
            String str2;
            int i9;
            int i2;
            int i4;
            int i;
            int i5;
            int i6;
            int i7;
            okhttp3.HttpUrl.Companion companion;
            String obj14;
            companion = HttpUrl.Companion;
            obj14 = HttpUrl.Companion.canonicalize$okhttp$default(companion, string, 0, 0, " \"'<>#", false, false, true, false, 0, 219, 0);
            if (string != null && obj14 != null) {
                companion = HttpUrl.Companion;
                obj14 = HttpUrl.Companion.canonicalize$okhttp$default(companion, string, 0, 0, " \"'<>#", false, false, true, false, 0, 219, 0);
                if (obj14 != null) {
                    obj14 = companion.toQueryNamesAndValues$okhttp(obj14);
                } else {
                    obj14 = 0;
                }
            } else {
            }
            this.encodedQueryNamesAndValues = obj14;
            return this;
        }

        public final okhttp3.HttpUrl.Builder reencodeForUri$okhttp() {
            String str;
            int canonicalize$okhttp$default;
            h hVar;
            int i5;
            String str2;
            int size;
            List encodedPathSegments;
            String canonicalize$okhttp$default2;
            Object obj;
            int i4;
            int str3;
            String str4;
            int i2;
            int i6;
            int i3;
            int i8;
            int i9;
            int i;
            int i7;
            final Object obj2 = this;
            String host = obj2.host;
            canonicalize$okhttp$default = 0;
            if (host != null) {
                hVar = new h("[\"<>^`{|}]");
                str = hVar.e(host, "");
            } else {
                str = canonicalize$okhttp$default;
            }
            obj2.host = str;
            size = i5;
            while (size < obj2.encodedPathSegments.size()) {
                encodedPathSegments = obj2.encodedPathSegments;
                encodedPathSegments.set(size, HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, (String)encodedPathSegments.get(size), 0, 0, "[]", true, true, false, false, 0, 227, 0));
                size++;
            }
            List encodedQueryNamesAndValues = obj2.encodedQueryNamesAndValues;
            if (encodedQueryNamesAndValues != null) {
                while (i5 < encodedQueryNamesAndValues.size()) {
                    obj = obj3;
                    if ((String)obj != null) {
                    } else {
                    }
                    encodedPathSegments = canonicalize$okhttp$default;
                    encodedQueryNamesAndValues.set(i5, encodedPathSegments);
                    i5++;
                    encodedPathSegments = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, (String)obj, 0, 0, "\\^`{|}", true, true, true, false, 0, 195, 0);
                }
            }
            String encodedFragment = obj2.encodedFragment;
            if (encodedFragment != null) {
                canonicalize$okhttp$default = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedFragment, 0, 0, " \"#<>\\^`{|}", true, true, false, true, 0, 163, 0);
            }
            obj2.encodedFragment = canonicalize$okhttp$default;
            return obj2;
        }

        public final okhttp3.HttpUrl.Builder removeAllEncodedQueryParameters(String string) {
            n.f(string, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, string, 0, 0, " \"'<>#&=", true, false, true, false, 0, 211, 0));
            return this;
        }

        public final okhttp3.HttpUrl.Builder removeAllQueryParameters(String string) {
            n.f(string, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, string, 0, 0, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, false, 0, 219, 0));
            return this;
        }

        public final okhttp3.HttpUrl.Builder removePathSegment(int i) {
            Object encodedPathSegments;
            boolean obj2;
            this.encodedPathSegments.remove(i);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public final okhttp3.HttpUrl.Builder scheme(String string) {
            String str;
            int i;
            n.f(string, "scheme");
            str = "http";
            i = 1;
            if (l.x(string, str, i)) {
                this.scheme = str;
                return this;
            } else {
                str = "https";
                if (!l.x(string, str, i)) {
                } else {
                    this.scheme = str;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("unexpected scheme: ");
            stringBuilder.append(string);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }

        public final void setEncodedFragment$okhttp(String string) {
            this.encodedFragment = string;
        }

        public final void setEncodedPassword$okhttp(String string) {
            n.f(string, "<set-?>");
            this.encodedPassword = string;
        }

        public final okhttp3.HttpUrl.Builder setEncodedPathSegment(int i, String string2) {
            boolean obj14;
            n.f(string2, "encodedPathSegment");
            String canonicalize$okhttp$default = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, string2, 0, 0, " \"<>^`{}|/\\?#", true, false, false, false, 0, 243, 0);
            this.encodedPathSegments.set(i, canonicalize$okhttp$default);
            if (!isDot(canonicalize$okhttp$default) && !isDotDot(canonicalize$okhttp$default)) {
                obj14 = !isDotDot(canonicalize$okhttp$default) ? 1 : 0;
            } else {
            }
            if (obj14 == null) {
            } else {
                return this;
            }
            obj14 = new StringBuilder();
            obj14.append("unexpected path segment: ");
            obj14.append(string2);
            IllegalArgumentException obj15 = new IllegalArgumentException(obj14.toString().toString());
            throw obj15;
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final okhttp3.HttpUrl.Builder setEncodedQueryParameter(String string, String string2) {
            n.f(string, "encodedName");
            removeAllEncodedQueryParameters(string);
            addEncodedQueryParameter(string, string2);
            return this;
        }

        public final void setEncodedUsername$okhttp(String string) {
            n.f(string, "<set-?>");
            this.encodedUsername = string;
        }

        public final void setHost$okhttp(String string) {
            this.host = string;
        }

        public final okhttp3.HttpUrl.Builder setPathSegment(int i, String string2) {
            boolean dotDot;
            int i2;
            n.f(string2, "pathSegment");
            String canonicalize$okhttp$default = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, string2, 0, 0, " \"<>^`{}|/\\?#", false, false, false, false, 0, 251, 0);
            if (!isDot(canonicalize$okhttp$default) && !isDotDot(canonicalize$okhttp$default)) {
                i2 = !isDotDot(canonicalize$okhttp$default) ? 1 : 0;
            } else {
            }
            if (i2 == 0) {
            } else {
                this.encodedPathSegments.set(i, canonicalize$okhttp$default);
                return this;
            }
            StringBuilder obj14 = new StringBuilder();
            obj14.append("unexpected path segment: ");
            obj14.append(string2);
            IllegalArgumentException obj15 = new IllegalArgumentException(obj14.toString().toString());
            throw obj15;
        }

        public final void setPort$okhttp(int i) {
            this.port = i;
        }

        public final okhttp3.HttpUrl.Builder setQueryParameter(String string, String string2) {
            n.f(string, "name");
            removeAllQueryParameters(string);
            addQueryParameter(string, string2);
            return this;
        }

        public final void setScheme$okhttp(String string) {
            this.scheme = string;
        }

        public String toString() {
            String str;
            int i2;
            int encodedPassword;
            String host;
            int effectivePort;
            String encodedFragment;
            int i3;
            String defaultPort;
            List encodedQueryNamesAndValues;
            int companion;
            int i;
            StringBuilder stringBuilder = new StringBuilder();
            String scheme = this.scheme;
            if (scheme != null) {
                stringBuilder.append(scheme);
                stringBuilder.append("://");
            } else {
                stringBuilder.append("//");
            }
            i3 = 1;
            companion = 0;
            i2 = this.encodedUsername.length() > 0 ? i3 : companion;
            final int i7 = 58;
            if (i2 == 0) {
                i2 = this.encodedPassword.length() > 0 ? i3 : companion;
                if (i2 != 0) {
                    stringBuilder.append(this.encodedUsername);
                    if (this.encodedPassword.length() > 0) {
                    } else {
                        i3 = companion;
                    }
                    if (i3 != 0) {
                        stringBuilder.append(i7);
                        stringBuilder.append(this.encodedPassword);
                    }
                    stringBuilder.append('@');
                }
            } else {
            }
            host = this.host;
            if (host != null) {
                n.d(host);
                if (l.Q(host, i7, companion, 2, 0)) {
                    stringBuilder.append('[');
                    stringBuilder.append(this.host);
                    stringBuilder.append(']');
                } else {
                    stringBuilder.append(this.host);
                }
            }
            if (this.port == -1) {
                if (this.scheme != null) {
                    effectivePort = effectivePort();
                    defaultPort = this.scheme;
                    if (defaultPort != null) {
                        n.d(defaultPort);
                        if (effectivePort != HttpUrl.Companion.defaultPort(defaultPort)) {
                            stringBuilder.append(i7);
                            stringBuilder.append(effectivePort);
                        }
                    } else {
                    }
                }
            } else {
            }
            okhttp3.HttpUrl.Companion companion2 = HttpUrl.Companion;
            companion2.toPathString$okhttp(this.encodedPathSegments, stringBuilder);
            if (this.encodedQueryNamesAndValues != null) {
                stringBuilder.append('?');
                encodedQueryNamesAndValues = this.encodedQueryNamesAndValues;
                n.d(encodedQueryNamesAndValues);
                companion2.toQueryString$okhttp(encodedQueryNamesAndValues, stringBuilder);
            }
            if (this.encodedFragment != null) {
                stringBuilder.append('#');
                stringBuilder.append(this.encodedFragment);
            }
            String string = stringBuilder.toString();
            n.e(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        public final okhttp3.HttpUrl.Builder username(String string) {
            n.f(string, "username");
            this.encodedUsername = HttpUrl.Companion.canonicalize$okhttp$default(HttpUrl.Companion, string, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 0, 251, 0);
            return this;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010!\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u0019\n\u0002\u0008\r\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\t\u0008\u0002¢\u0006\u0004\u0008K\u0010LJ3\u0010\u000b\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0008H\u0002¢\u0006\u0004\u0008\u000b\u0010\u000cJ#\u0010\r\u001a\u00020\u0008*\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¢\u0006\u0004\u0008\r\u0010\u000eJ]\u0010\u0016\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00082\u0006\u0010\u0012\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u00082\u0006\u0010\u0013\u001a\u00020\u00082\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\u0008\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0003H\u0007¢\u0006\u0004\u0008\u0019\u0010\u001aJ%\u0010!\u001a\u00020\n*\u0008\u0012\u0004\u0012\u00020\u00030\u001b2\n\u0010\u001e\u001a\u00060\u001cj\u0002`\u001dH\u0000¢\u0006\u0004\u0008\u001f\u0010 J'\u0010#\u001a\u00020\n*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u001b2\n\u0010\u001e\u001a\u00060\u001cj\u0002`\u001dH\u0000¢\u0006\u0004\u0008\"\u0010 J\u001b\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030$*\u00020\u0003H\u0000¢\u0006\u0004\u0008%\u0010&J\u0013\u0010+\u001a\u00020(*\u00020\u0003H\u0007¢\u0006\u0004\u0008)\u0010*J\u0015\u0010-\u001a\u0004\u0018\u00010(*\u00020\u0003H\u0007¢\u0006\u0004\u0008,\u0010*J\u0015\u0010-\u001a\u0004\u0018\u00010(*\u00020.H\u0007¢\u0006\u0004\u0008)\u0010/J\u0015\u0010-\u001a\u0004\u0018\u00010(*\u000200H\u0007¢\u0006\u0004\u0008)\u00101J\u0017\u0010)\u001a\u00020(2\u0006\u00102\u001a\u00020\u0003H\u0007¢\u0006\u0004\u00083\u0010*J\u0019\u0010,\u001a\u0004\u0018\u00010(2\u0006\u00102\u001a\u00020\u0003H\u0007¢\u0006\u0004\u00084\u0010*J\u0019\u0010)\u001a\u0004\u0018\u00010(2\u0006\u00102\u001a\u00020.H\u0007¢\u0006\u0004\u00083\u0010/J\u0019\u0010)\u001a\u0004\u0018\u00010(2\u0006\u00105\u001a\u000200H\u0007¢\u0006\u0004\u00083\u00101J1\u00108\u001a\u00020\u0003*\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0008\u0008\u0002\u0010\t\u001a\u00020\u0008H\u0000¢\u0006\u0004\u00086\u00107Jc\u0010;\u001a\u00020\u0003*\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0012\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u00082\n\u0008\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0000¢\u0006\u0004\u00089\u0010:R\u0016\u0010<\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008<\u0010=R\u0016\u0010>\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008>\u0010=R\u0016\u0010?\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008?\u0010=R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\u0008A\u0010BR\u0016\u0010C\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008C\u0010=R\u0016\u0010D\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008D\u0010=R\u0016\u0010E\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008E\u0010=R\u0016\u0010F\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008F\u0010=R\u0016\u0010G\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008G\u0010=R\u0016\u0010H\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008H\u0010=R\u0016\u0010I\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008I\u0010=R\u0016\u0010J\u001a\u00020\u00038\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\u0008J\u0010=¨\u0006M", d2 = {"Lokhttp3/HttpUrl$Companion;", "", "Ll/f;", "", "encoded", "", "pos", "limit", "", "plusIsSpace", "Lkotlin/w;", "writePercentDecoded", "(Ll/f;Ljava/lang/String;IIZ)V", "isPercentEncoded", "(Ljava/lang/String;II)Z", "input", "encodeSet", "alreadyEncoded", "strict", "unicodeAllowed", "Ljava/nio/charset/Charset;", "charset", "writeCanonicalized", "(Ll/f;Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)V", "scheme", "defaultPort", "(Ljava/lang/String;)I", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "out", "toPathString$okhttp", "(Ljava/util/List;Ljava/lang/StringBuilder;)V", "toPathString", "toQueryString$okhttp", "toQueryString", "", "toQueryNamesAndValues$okhttp", "(Ljava/lang/String;)Ljava/util/List;", "toQueryNamesAndValues", "Lokhttp3/HttpUrl;", "get", "(Ljava/lang/String;)Lokhttp3/HttpUrl;", "toHttpUrl", "parse", "toHttpUrlOrNull", "Ljava/net/URL;", "(Ljava/net/URL;)Lokhttp3/HttpUrl;", "Ljava/net/URI;", "(Ljava/net/URI;)Lokhttp3/HttpUrl;", "url", "-deprecated_get", "-deprecated_parse", "uri", "percentDecode$okhttp", "(Ljava/lang/String;IIZ)Ljava/lang/String;", "percentDecode", "canonicalize$okhttp", "(Ljava/lang/String;IILjava/lang/String;ZZZZLjava/nio/charset/Charset;)Ljava/lang/String;", "canonicalize", "FORM_ENCODE_SET", "Ljava/lang/String;", "FRAGMENT_ENCODE_SET", "FRAGMENT_ENCODE_SET_URI", "", "HEX_DIGITS", "[C", "PASSWORD_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET", "PATH_SEGMENT_ENCODE_SET_URI", "QUERY_COMPONENT_ENCODE_SET", "QUERY_COMPONENT_ENCODE_SET_URI", "QUERY_COMPONENT_REENCODE_SET", "QUERY_ENCODE_SET", "USERNAME_ENCODE_SET", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion(g g) {
            super();
        }

        public static String canonicalize$okhttp$default(okhttp3.HttpUrl.Companion httpUrl$Companion, String string2, int i3, int i4, String string5, boolean z6, boolean z7, boolean z8, boolean z9, Charset charset10, int i11, Object object12) {
            int i7;
            int length;
            int i2;
            int i;
            int i10;
            int i9;
            int i5;
            int i6;
            int i8;
            int i12 = i11;
            final int i18 = 0;
            i2 = i12 & 1 != 0 ? i18 : i3;
            if (i12 & 2 != 0) {
                i = length;
            } else {
                i = i4;
            }
            i10 = i12 & 8 != 0 ? i18 : z6;
            i9 = i12 & 16 != 0 ? i18 : z7;
            i5 = i12 & 32 != 0 ? i18 : z8;
            i6 = i12 & 64 != 0 ? i18 : z9;
            i8 = i12 &= 128 != 0 ? i7 : charset10;
            return companion.canonicalize$okhttp(string2, i2, i, string5, i10, i9, i5, i6, i8);
        }

        private final boolean isPercentEncoded(String string, int i2, int i3) {
            int i;
            int i4;
            int obj4;
            int obj5;
            int obj6;
            final int i5 = i2 + 2;
            obj6 = -1;
            if (i5 < i3 && string.charAt(i2) == 37 && Util.parseHexDigit(string.charAt(i2 += i)) != obj6 && Util.parseHexDigit(string.charAt(i5)) != obj6) {
                if (string.charAt(i2) == 37) {
                    obj6 = -1;
                    if (Util.parseHexDigit(string.charAt(i2 += i)) != obj6) {
                        if (Util.parseHexDigit(string.charAt(i5)) != obj6) {
                        } else {
                            i = 0;
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        public static String percentDecode$okhttp$default(okhttp3.HttpUrl.Companion httpUrl$Companion, String string2, int i3, int i4, boolean z5, int i6, Object object7) {
            int obj3;
            int obj4;
            int obj5;
            final int i = 0;
            if (i6 & 1 != 0) {
                obj3 = i;
            }
            if (i6 & 2 != 0) {
                obj4 = string2.length();
            }
            if (i6 &= 4 != 0) {
                obj5 = i;
            }
            return companion.percentDecode$okhttp(string2, obj3, obj4, obj5);
        }

        private final void writeCanonicalized(f f, String string2, int i3, int i4, String string5, boolean z6, boolean z7, boolean z8, boolean z9, Charset charset10) {
            int i6;
            int fVar;
            int charCount;
            int str;
            int i7;
            int i;
            boolean percentEncoded;
            int i2;
            java.lang.CharSequence charSequence;
            int i5;
            final Object obj = f;
            final Object obj2 = string2;
            final int i8 = i4;
            final Object obj3 = charset10;
            final int i9 = 0;
            i6 = i3;
            fVar = i9;
            while (i6 < i8) {
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type java.lang.String");
                int codePointAt = obj2.codePointAt(i6);
                if (z6 && codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13) {
                } else {
                }
                if (codePointAt == 43) {
                } else {
                }
                i = 37;
                if (codePointAt >= 32 && codePointAt != 127) {
                } else {
                }
                str = this;
                charSequence = string5;
                if (fVar == 0) {
                }
                if (obj3 != null) {
                } else {
                }
                fVar.g1(codePointAt);
                while (!fVar.b0()) {
                    byte &= 255;
                    f.z0(i);
                    f.z0(HttpUrl.access$getHEX_DIGITS$cp()[i14 &= 15]);
                    f.z0(HttpUrl.access$getHEX_DIGITS$cp()[i12 &= 15]);
                }
                i6 += charCount;
                byte &= 255;
                f.z0(i);
                f.z0(HttpUrl.access$getHEX_DIGITS$cp()[i14 &= 15]);
                f.z0(HttpUrl.access$getHEX_DIGITS$cp()[i12 &= 15]);
                if (n.b(obj3, StandardCharsets.UTF_8)) {
                } else {
                }
                fVar.Q0(obj2, i6, charCount2 += i6, obj3);
                fVar = new f();
                if (codePointAt != 127) {
                } else {
                }
                if (codePointAt >= 128) {
                } else {
                }
                if (!l.Q(string5, (char)codePointAt, false, 2, i9)) {
                } else {
                }
                str = this;
                if (codePointAt == i) {
                } else {
                }
                str = this;
                f.g1(codePointAt);
                if (z6) {
                } else {
                }
                if (z7) {
                } else {
                }
                str = this;
                if (!isPercentEncoded(obj2, i6, i8)) {
                } else {
                }
                if (z9) {
                } else {
                }
                if (z8) {
                } else {
                }
                if (z6) {
                } else {
                }
                str = "%2B";
                f.b1(str);
                str = this;
                charSequence = string5;
                str = "+";
                if (codePointAt != 9) {
                } else {
                }
                if (codePointAt != 10) {
                } else {
                }
                if (codePointAt != 12) {
                } else {
                }
                if (codePointAt != 13) {
                } else {
                }
            }
            int i11 = this;
        }

        private final void writePercentDecoded(f f, String string2, int i3, int i4, boolean z5) {
            int codePointAt;
            int i;
            int hexDigit2;
            int hexDigit;
            int i2;
            int obj8;
            while (obj8 < i4) {
                Objects.requireNonNull(string2, "null cannot be cast to non-null type java.lang.String");
                codePointAt = string2.codePointAt(obj8);
                i = obj8 + 2;
                if (codePointAt == 37 && i < i4) {
                } else {
                }
                if (codePointAt == 43 && z5) {
                } else {
                }
                f.g1(codePointAt);
                obj8 += codePointAt;
                if (z5) {
                } else {
                }
                f.z0(32);
                obj8++;
                i = obj8 + 2;
                if (i < i4) {
                } else {
                }
                hexDigit2 = Util.parseHexDigit(string2.charAt(obj8 + 1));
                hexDigit = Util.parseHexDigit(string2.charAt(i));
                i2 = -1;
                if (hexDigit2 != i2 && hexDigit != i2) {
                } else {
                }
                if (hexDigit != i2) {
                } else {
                }
                f.z0(obj8 += hexDigit);
                obj8 += i;
            }
        }

        public final okhttp3.HttpUrl -deprecated_get(String string) {
            n.f(string, "url");
            return get(string);
        }

        public final okhttp3.HttpUrl -deprecated_get(URI uRI) {
            n.f(uRI, "uri");
            return get(uRI);
        }

        public final okhttp3.HttpUrl -deprecated_get(URL uRL) {
            n.f(uRL, "url");
            return get(uRL);
        }

        public final okhttp3.HttpUrl -deprecated_parse(String string) {
            n.f(string, "url");
            return parse(string);
        }

        public final String canonicalize$okhttp(String string, int i2, int i3, String string4, boolean z5, boolean z6, boolean z7, boolean z8, Charset charset9) {
            String charCount;
            int percentEncoded;
            int i5;
            int i6;
            int i;
            int i4;
            Object obj5;
            Object obj2 = string;
            int i9 = i3;
            Object obj4 = string4;
            n.f(string, "$this$canonicalize");
            n.f(obj4, "encodeSet");
            i5 = i2;
            while (i5 < i9) {
                int codePointAt = string.codePointAt(i5);
                obj5 = this;
                i5 += charCount;
                obj5 = this;
            }
            Object obj6 = this;
            int i8 = i2;
            String substring = string.substring(i2, i3);
            n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return substring;
        }

        public final int defaultPort(String string) {
            String str;
            int i;
            boolean obj3;
            n.f(string, "scheme");
            str = string.hashCode();
            if (str != 3213448) {
                if (str != 99617003) {
                    obj3 = -1;
                } else {
                    if (string.equals("https")) {
                        obj3 = 443;
                    } else {
                    }
                }
            } else {
                if (string.equals("http")) {
                    obj3 = 80;
                } else {
                }
            }
            return obj3;
        }

        public final okhttp3.HttpUrl get(String string) {
            n.f(string, "$this$toHttpUrl");
            HttpUrl.Builder builder = new HttpUrl.Builder();
            return builder.parse$okhttp(0, string).build();
        }

        public final okhttp3.HttpUrl get(URI uRI) {
            n.f(uRI, "$this$toHttpUrlOrNull");
            String obj2 = uRI.toString();
            n.e(obj2, "toString()");
            return parse(obj2);
        }

        public final okhttp3.HttpUrl get(URL uRL) {
            n.f(uRL, "$this$toHttpUrlOrNull");
            String obj2 = uRL.toString();
            n.e(obj2, "toString()");
            return parse(obj2);
        }

        public final okhttp3.HttpUrl parse(String string) {
            okhttp3.HttpUrl obj2;
            n.f(string, "$this$toHttpUrlOrNull");
            obj2 = get(string);
            return obj2;
        }

        public final String percentDecode$okhttp(String string, int i2, int i3, boolean z4) {
            String charAt;
            int i;
            int i4;
            n.f(string, "$this$percentDecode");
            i4 = i2;
            while (i4 < i3) {
                charAt = string.charAt(i4);
                i4++;
            }
            String obj8 = string.substring(i2, i3);
            n.e(obj8, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return obj8;
        }

        public final void toPathString$okhttp(List<String> list, StringBuilder stringBuilder2) {
            int i;
            Object obj;
            n.f(list, "$this$toPathString");
            n.f(stringBuilder2, "out");
            i = 0;
            while (i < list.size()) {
                stringBuilder2.append('/');
                stringBuilder2.append((String)list.get(i));
                i++;
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String string) {
            int i2;
            String substring;
            int i5;
            int length;
            String str;
            int i;
            int i7;
            int i3;
            int i8;
            int i4;
            int i6;
            n.f(string, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            i2 = 0;
            while (i2 <= string.length()) {
                i4 = -1;
                if (l.d0(string, '&', i2, false, 4, 0) == i4) {
                }
                i6 = length;
                i5 = l.d0(string, '=', i2, false, 4, 0);
                str = "(this as java.lang.Strin…ing(startIndex, endIndex)";
                if (i5 != i4) {
                } else {
                }
                String substring3 = string.substring(i2, i6);
                n.e(substring3, str);
                arrayList.add(substring3);
                arrayList.add(0);
                i2 = i6 + 1;
                if (i5 > i6) {
                } else {
                }
                String substring2 = string.substring(i2, i5);
                n.e(substring2, str);
                arrayList.add(substring2);
                substring = string.substring(i5++, i6);
                n.e(substring, str);
                arrayList.add(substring);
                length = string.length();
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(List<String> list, StringBuilder stringBuilder2) {
            int i2;
            Object obj2;
            Object obj;
            int i;
            n.f(list, "$this$toQueryString");
            n.f(stringBuilder2, "out");
            d dVar = g.k(g.l(0, list.size()), 2);
            i2 = dVar.d();
            final int i6 = dVar.g();
            int i3 = dVar.h();
            if (i3 >= 0) {
                if (i2 <= i6) {
                    obj = list.get(i2 + 1);
                    while (i2 > 0) {
                        stringBuilder2.append('&');
                        stringBuilder2.append((String)list.get(i2));
                        if ((String)obj != null) {
                        }
                        if (i2 != i6) {
                        }
                        i2 += i3;
                        obj = list.get(i2 + 1);
                        stringBuilder2.append('=');
                        stringBuilder2.append((String)(String)obj);
                    }
                }
            } else {
                if (i2 >= i6) {
                }
            }
        }
    }
    static {
        HttpUrl.Companion companion = new HttpUrl.Companion(0);
        HttpUrl.Companion = companion;
        char[] cArr = new char[16];
        cArr = new short[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        HttpUrl.HEX_DIGITS = cArr;
    }

    public HttpUrl(String string, String string2, String string3, String string4, int i5, List<String> list6, List<String> list7, String string8, String string9) {
        n.f(string, "scheme");
        n.f(string2, "username");
        n.f(string3, "password");
        n.f(string4, "host");
        n.f(list6, "pathSegments");
        n.f(string9, "url");
        super();
        this.scheme = string;
        this.username = string2;
        this.password = string3;
        this.host = string4;
        this.port = i5;
        this.pathSegments = list6;
        this.queryNamesAndValues = list7;
        this.fragment = string8;
        this.url = string9;
        this.isHttps = n.b(string, "https");
    }

    public static final char[] access$getHEX_DIGITS$cp() {
        return HttpUrl.HEX_DIGITS;
    }

    public static final int defaultPort(String string) {
        return HttpUrl.Companion.defaultPort(string);
    }

    public static final okhttp3.HttpUrl get(String string) {
        return HttpUrl.Companion.get(string);
    }

    public static final okhttp3.HttpUrl get(URI uRI) {
        return HttpUrl.Companion.get(uRI);
    }

    public static final okhttp3.HttpUrl get(URL uRL) {
        return HttpUrl.Companion.get(uRL);
    }

    public static final okhttp3.HttpUrl parse(String string) {
        return HttpUrl.Companion.parse(string);
    }

    public final String -deprecated_encodedFragment() {
        return encodedFragment();
    }

    public final String -deprecated_encodedPassword() {
        return encodedPassword();
    }

    public final String -deprecated_encodedPath() {
        return encodedPath();
    }

    public final List<String> -deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    public final String -deprecated_encodedQuery() {
        return encodedQuery();
    }

    public final String -deprecated_encodedUsername() {
        return encodedUsername();
    }

    public final String -deprecated_fragment() {
        return this.fragment;
    }

    public final String -deprecated_host() {
        return this.host;
    }

    public final String -deprecated_password() {
        return this.password;
    }

    public final List<String> -deprecated_pathSegments() {
        return this.pathSegments;
    }

    public final int -deprecated_pathSize() {
        return pathSize();
    }

    public final int -deprecated_port() {
        return this.port;
    }

    public final String -deprecated_query() {
        return query();
    }

    public final Set<String> -deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    public final int -deprecated_querySize() {
        return querySize();
    }

    public final String -deprecated_scheme() {
        return this.scheme;
    }

    public final URI -deprecated_uri() {
        return uri();
    }

    public final URL -deprecated_url() {
        return url();
    }

    public final String -deprecated_username() {
        return this.username;
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        String url2 = this.url;
        Objects.requireNonNull(url2, "null cannot be cast to non-null type java.lang.String");
        String substring = url2.substring(i2++);
        n.e(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public final String encodedPassword() {
        int i;
        int i4 = 1;
        i = this.password.length() == 0 ? i4 : 0;
        if (i != 0) {
            return "";
        }
        String url3 = this.url;
        Objects.requireNonNull(url3, "null cannot be cast to non-null type java.lang.String");
        String substring = url3.substring(i2 += i4, l.d0(this.url, '@', 0, false, 6, 0));
        n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedPath() {
        int i = l.d0(this.url, '/', length + 3, false, 4, 0);
        String url2 = this.url;
        String url3 = this.url;
        Objects.requireNonNull(url3, "null cannot be cast to non-null type java.lang.String");
        String substring = url3.substring(i, Util.delimiterOffset(url2, "?#", i, url2.length()));
        n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final List<String> encodedPathSegments() {
        int i;
        String delimiterOffset;
        int str;
        int str2;
        String url2 = this.url;
        int delimiterOffset2 = Util.delimiterOffset(url2, "?#", l.d0(this.url, '/', length + 3, false, 4, 0), url2.length());
        ArrayList arrayList = new ArrayList();
        while (i < delimiterOffset2) {
            i++;
            delimiterOffset = Util.delimiterOffset(this.url, '/', i2, delimiterOffset2);
            String url4 = this.url;
            Objects.requireNonNull(url4, "null cannot be cast to non-null type java.lang.String");
            String substring = url4.substring(i2, delimiterOffset);
            n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(substring);
            i = delimiterOffset;
        }
        return arrayList;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        i2++;
        String url2 = this.url;
        String url3 = this.url;
        Objects.requireNonNull(url3, "null cannot be cast to non-null type java.lang.String");
        String substring = url3.substring(i3, Util.delimiterOffset(url2, '#', i3, url2.length()));
        n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public final String encodedUsername() {
        int i;
        i = this.username.length() == 0 ? 1 : 0;
        if (i != 0) {
            return "";
        }
        length2 += 3;
        String url = this.url;
        String url2 = this.url;
        Objects.requireNonNull(url2, "null cannot be cast to non-null type java.lang.String");
        String substring = url2.substring(i2, Util.delimiterOffset(url, ":@", i2, url.length()));
        n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public boolean equals(Object object) {
        boolean url;
        Object obj2;
        if (object instanceof HttpUrl && n.b(object.url, this.url)) {
            obj2 = n.b(object.url, this.url) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final okhttp3.HttpUrl.Builder newBuilder() {
        int port;
        HttpUrl.Builder builder = new HttpUrl.Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        port = this.port != HttpUrl.Companion.defaultPort(this.scheme) ? this.port : -1;
        builder.setPort$okhttp(port);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final okhttp3.HttpUrl.Builder newBuilder(String string) {
        okhttp3.HttpUrl.Builder obj2;
        n.f(string, "link");
        HttpUrl.Builder builder = new HttpUrl.Builder();
        obj2 = builder.parse$okhttp(this, string);
        return obj2;
    }

    public final String password() {
        return this.password;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final int port() {
        return this.port;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        HttpUrl.Companion.toQueryString$okhttp(this.queryNamesAndValues, stringBuilder);
        return stringBuilder.toString();
    }

    public final String queryParameter(String string) {
        int i;
        boolean z;
        n.f(string, "name");
        List queryNamesAndValues = this.queryNamesAndValues;
        final int i3 = 0;
        if (queryNamesAndValues == null) {
            return i3;
        }
        d dVar = g.k(g.l(0, queryNamesAndValues.size()), 2);
        i = dVar.d();
        final int i7 = dVar.g();
        int i2 = dVar.h();
        if (i2 >= 0) {
            if (i <= i7) {
                while (n.b(string, (String)this.queryNamesAndValues.get(i))) {
                    i += i2;
                }
                return (String)this.queryNamesAndValues.get(i++);
            }
        } else {
            if (i >= i7) {
            }
        }
        return i3;
    }

    public final String queryParameterName(int i) {
        final List queryNamesAndValues = this.queryNamesAndValues;
        if (queryNamesAndValues == null) {
        } else {
            Object obj2 = queryNamesAndValues.get(i *= 2);
            n.d(obj2);
            return (String)obj2;
        }
        obj2 = new IndexOutOfBoundsException();
        throw obj2;
    }

    public final Set<String> queryParameterNames() {
        int i;
        Object obj;
        if (this.queryNamesAndValues == null) {
            return q0.b();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        d dVar = g.k(g.l(0, this.queryNamesAndValues.size()), 2);
        i = dVar.d();
        final int i5 = dVar.g();
        int i3 = dVar.h();
        if (i3 >= 0) {
            if (i <= i5) {
                obj = this.queryNamesAndValues.get(i);
                n.d(obj);
                linkedHashSet.add(obj);
                while (i != i5) {
                    i += i3;
                    obj = this.queryNamesAndValues.get(i);
                    n.d(obj);
                    linkedHashSet.add(obj);
                }
            }
        } else {
            if (i >= i5) {
            }
        }
        Set unmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        n.e(unmodifiableSet, "Collections.unmodifiableSet(result)");
        return unmodifiableSet;
    }

    public final String queryParameterValue(int i) {
        final List queryNamesAndValues = this.queryNamesAndValues;
        if (queryNamesAndValues == null) {
        } else {
            return (String)queryNamesAndValues.get(obj2++);
        }
        IndexOutOfBoundsException obj2 = new IndexOutOfBoundsException();
        throw obj2;
    }

    public final List<String> queryParameterValues(String string) {
        int i;
        boolean z;
        int i2;
        n.f(string, "name");
        if (this.queryNamesAndValues == null) {
            return p.g();
        }
        ArrayList arrayList = new ArrayList();
        d dVar = g.k(g.l(0, this.queryNamesAndValues.size()), 2);
        i = dVar.d();
        final int i6 = dVar.g();
        int i4 = dVar.h();
        if (i4 >= 0) {
            if (i <= i6) {
                while (n.b(string, (String)this.queryNamesAndValues.get(i))) {
                    arrayList.add(this.queryNamesAndValues.get(i + 1));
                    if (i != i6) {
                    }
                    i += i4;
                }
            }
        } else {
            if (i >= i6) {
            }
        }
        List obj7 = Collections.unmodifiableList(arrayList);
        n.e(obj7, "Collections.unmodifiableList(result)");
        return obj7;
    }

    public final int querySize() {
        int i;
        List queryNamesAndValues = this.queryNamesAndValues;
        if (queryNamesAndValues != null) {
            size /= 2;
        } else {
            i = 0;
        }
        return i;
    }

    public final String redact() {
        okhttp3.HttpUrl.Builder builder = newBuilder("/...");
        n.d(builder);
        final String str2 = "";
        return builder.username(str2).password(str2).build().toString();
    }

    public final okhttp3.HttpUrl resolve(String string) {
        okhttp3.HttpUrl obj2;
        n.f(string, "link");
        obj2 = newBuilder(string);
        if (obj2 != null) {
            obj2 = obj2.build();
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        int effectiveTldPlusOne;
        String host;
        if (Util.canParseAsIpAddress(this.host)) {
            effectiveTldPlusOne = 0;
        } else {
            effectiveTldPlusOne = PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
        }
        return effectiveTldPlusOne;
    }

    public final URI uri() {
        String string;
        URI uri;
        h hVar;
        String str;
        uri = new URI(newBuilder().reencodeForUri$okhttp().toString());
        return uri;
    }

    public final URL url() {
        try {
            URL url = new URL(this.url);
            return url;
            RuntimeException runtimeException = new RuntimeException(th);
            throw runtimeException;
        }
    }

    public final String username() {
        return this.username;
    }
}
