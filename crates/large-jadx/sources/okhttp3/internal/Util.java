package okhttp3.internal;

import java.io.Closeable;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.b;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.f0;
import kotlin.d0.d.g0;
import kotlin.d0.d.l;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.io.b;
import kotlin.k0.d;
import kotlin.k0.h;
import kotlin.k0.l;
import kotlin.w;
import kotlin.y.h0;
import kotlin.y.i;
import kotlin.y.j0;
import kotlin.y.p;
import l.d0;
import l.e0;
import l.f;
import l.g;
import l.h;
import l.i;
import l.i.a;
import l.t;
import l.t.a;
import okhttp3.EventListener;
import okhttp3.EventListener.Factory;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Headers.Companion;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Companion;
import okhttp3.RequestBody;
import okhttp3.RequestBody.Companion;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.ResponseBody.Companion;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;

/* loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000Â\u0002\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u000e\n\u0002\u0010\u000c\n\u0002\u0008\u0008\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0005\n\u0002\u0008\u0003\n\u0002\u0010\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010$\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010!\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0012\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a%\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000¢\u0006\u0004\u0008\u0005\u0010\u0006\u001a\u001d\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\u0008\u000c\u0010\r\u001a;\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u000e*\u0008\u0012\u0004\u0012\u00020\u00070\u000e2\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0008\u0000\u0012\u00020\u00070\u0010¢\u0006\u0004\u0008\u0012\u0010\u0013\u001a7\u0010\u0014\u001a\u00020\t*\u0008\u0012\u0004\u0012\u00020\u00070\u000e2\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0008\u0000\u0012\u00020\u00070\u0010¢\u0006\u0004\u0008\u0014\u0010\u0015\u001a\u001b\u0010\u0018\u001a\u00020\u0007*\u00020\u00162\u0008\u0008\u0002\u0010\u0017\u001a\u00020\t¢\u0006\u0004\u0008\u0018\u0010\u0019\u001a-\u0010\u001c\u001a\u00020\u001b*\u0008\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u001a\u001a\u00020\u00072\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u0010¢\u0006\u0004\u0008\u001c\u0010\u001d\u001a%\u0010\u001e\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u000e*\u0008\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\u0008\u001e\u0010\u001f\u001a%\u0010\"\u001a\u00020\u001b*\u00020\u00072\u0008\u0008\u0002\u0010 \u001a\u00020\u001b2\u0008\u0008\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\u0008\"\u0010#\u001a%\u0010$\u001a\u00020\u001b*\u00020\u00072\u0008\u0008\u0002\u0010 \u001a\u00020\u001b2\u0008\u0008\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\u0008$\u0010#\u001a%\u0010%\u001a\u00020\u0007*\u00020\u00072\u0008\u0008\u0002\u0010 \u001a\u00020\u001b2\u0008\u0008\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\u0008%\u0010&\u001a-\u0010(\u001a\u00020\u001b*\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0008\u0008\u0002\u0010 \u001a\u00020\u001b2\u0008\u0008\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\u0008(\u0010)\u001a-\u0010(\u001a\u00020\u001b*\u00020\u00072\u0006\u0010+\u001a\u00020*2\u0008\u0008\u0002\u0010 \u001a\u00020\u001b2\u0008\u0008\u0002\u0010!\u001a\u00020\u001b¢\u0006\u0004\u0008(\u0010,\u001a\u0011\u0010-\u001a\u00020\u001b*\u00020\u0007¢\u0006\u0004\u0008-\u0010.\u001a\u0011\u0010/\u001a\u00020\t*\u00020\u0007¢\u0006\u0004\u0008/\u00100\u001a\u0015\u00101\u001a\u00020\t2\u0006\u0010\u0008\u001a\u00020\u0007¢\u0006\u0004\u00081\u00100\u001a)\u00102\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0012\u00104\u001a\n\u0012\u0006\u0008\u0001\u0012\u0002030\u000e\"\u000203¢\u0006\u0004\u00082\u00105\u001a\u0019\u00109\u001a\u000207*\u0002062\u0006\u00108\u001a\u000207¢\u0006\u0004\u00089\u0010:\u001a'\u0010>\u001a\u00020\u001b2\u0006\u0010\u0008\u001a\u00020\u00072\u0006\u0010;\u001a\u00020\u00002\u0008\u0010=\u001a\u0004\u0018\u00010<¢\u0006\u0004\u0008>\u0010?\u001a\u0011\u0010@\u001a\u00020\u001b*\u00020*¢\u0006\u0004\u0008@\u0010A\u001a\u0017\u0010E\u001a\u00020D*\u0008\u0012\u0004\u0012\u00020C0B¢\u0006\u0004\u0008E\u0010F\u001a\u0017\u0010G\u001a\u0008\u0012\u0004\u0012\u00020C0B*\u00020D¢\u0006\u0004\u0008G\u0010H\u001a\u0019\u0010I\u001a\u00020\t*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\u0016¢\u0006\u0004\u0008I\u0010J\u001a\u0011\u0010M\u001a\u00020L*\u00020K¢\u0006\u0004\u0008M\u0010N\u001a\u001c\u0010Q\u001a\u00020\u001b*\u00020O2\u0006\u0010P\u001a\u00020\u001bH\u0086\u0004¢\u0006\u0004\u0008Q\u0010R\u001a\u001c\u0010Q\u001a\u00020\u001b*\u00020S2\u0006\u0010P\u001a\u00020\u001bH\u0086\u0004¢\u0006\u0004\u0008Q\u0010T\u001a\u001c\u0010Q\u001a\u00020\u0000*\u00020\u001b2\u0006\u0010P\u001a\u00020\u0000H\u0086\u0004¢\u0006\u0004\u0008Q\u0010U\u001a\u0019\u0010X\u001a\u00020\u0004*\u00020V2\u0006\u0010W\u001a\u00020\u001b¢\u0006\u0004\u0008X\u0010Y\u001a\u0011\u0010Z\u001a\u00020\u001b*\u000206¢\u0006\u0004\u0008Z\u0010[\u001a!\u0010^\u001a\u00020\t*\u00020\\2\u0006\u0010;\u001a\u00020\u001b2\u0006\u0010]\u001a\u00020<¢\u0006\u0004\u0008^\u0010_\u001a!\u0010a\u001a\u00020\t*\u00020\\2\u0006\u0010`\u001a\u00020\u001b2\u0006\u0010]\u001a\u00020<¢\u0006\u0004\u0008a\u0010_\u001a\u0011\u0010c\u001a\u00020\u0007*\u00020b¢\u0006\u0004\u0008c\u0010d\u001a\u0019\u0010f\u001a\u00020\t*\u00020b2\u0006\u0010e\u001a\u000206¢\u0006\u0004\u0008f\u0010g\u001a!\u0010j\u001a\u00020\u00042\u000c\u0010i\u001a\u0008\u0012\u0004\u0012\u00020\u00040hH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008j\u0010k\u001a)\u0010l\u001a\u00020\u00042\u0006\u0010\u0008\u001a\u00020\u00072\u000c\u0010i\u001a\u0008\u0012\u0004\u0012\u00020\u00040hH\u0086\u0008ø\u0001\u0000¢\u0006\u0004\u0008l\u0010m\u001a\u0019\u0010^\u001a\u00020\u001b*\u00020n2\u0006\u0010o\u001a\u00020O¢\u0006\u0004\u0008^\u0010p\u001a\u001b\u0010q\u001a\u00020\u001b*\u00020\u00072\u0008\u0008\u0002\u0010 \u001a\u00020\u001b¢\u0006\u0004\u0008q\u0010r\u001a\u0011\u0010t\u001a\u00020\u0000*\u00020s¢\u0006\u0004\u0008t\u0010u\u001a\u0019\u0010w\u001a\u00020\u0000*\u00020\u00072\u0006\u0010v\u001a\u00020\u0000¢\u0006\u0004\u0008w\u0010x\u001a\u001b\u0010y\u001a\u00020\u001b*\u0004\u0018\u00010\u00072\u0006\u0010v\u001a\u00020\u001b¢\u0006\u0004\u0008y\u0010r\u001a#\u0010{\u001a\u0008\u0012\u0004\u0012\u00028\u00000B\"\u0004\u0008\u0000\u0010z*\u0008\u0012\u0004\u0012\u00028\u00000B¢\u0006\u0004\u0008{\u0010|\u001a/\u0010~\u001a\u0008\u0012\u0004\u0012\u00028\u00000B\"\u0004\u0008\u0000\u0010z2\u0012\u0010}\u001a\n\u0012\u0006\u0008\u0001\u0012\u00028\u00000\u000e\"\u00028\u0000H\u0007¢\u0006\u0004\u0008~\u0010\u007f\u001a<\u0010\u0083\u0001\u001a\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0082\u0001\"\u0005\u0008\u0000\u0010\u0080\u0001\"\u0005\u0008\u0001\u0010\u0081\u0001*\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0082\u0001¢\u0006\u0006\u0008\u0083\u0001\u0010\u0084\u0001\u001a\u0015\u0010\u0086\u0001\u001a\u00020\u0004*\u00030\u0085\u0001¢\u0006\u0006\u0008\u0086\u0001\u0010\u0087\u0001\u001a\u0014\u0010\u0086\u0001\u001a\u00020\u0004*\u00020b¢\u0006\u0006\u0008\u0086\u0001\u0010\u0088\u0001\u001a\u0015\u0010\u0086\u0001\u001a\u00020\u0004*\u00030\u0089\u0001¢\u0006\u0006\u0008\u0086\u0001\u0010\u008a\u0001\u001a\u001f\u0010\u008e\u0001\u001a\u00020\t*\u00030\u008b\u00012\u0008\u0010\u008d\u0001\u001a\u00030\u008c\u0001¢\u0006\u0006\u0008\u008e\u0001\u0010\u008f\u0001\u001a\u0014\u0010\u0090\u0001\u001a\u00020\u0007*\u00020\u0000¢\u0006\u0006\u0008\u0090\u0001\u0010\u0091\u0001\u001a\u0014\u0010\u0090\u0001\u001a\u00020\u0007*\u00020\u001b¢\u0006\u0006\u0008\u0090\u0001\u0010\u0092\u0001\u001a\u0017\u0010\u0093\u0001\u001a\u00020\u0004*\u000203H\u0086\u0008¢\u0006\u0006\u0008\u0093\u0001\u0010\u0094\u0001\u001a\u0017\u0010\u0095\u0001\u001a\u00020\u0004*\u000203H\u0086\u0008¢\u0006\u0006\u0008\u0095\u0001\u0010\u0094\u0001\u001a\u0017\u0010\u0096\u0001\u001a\u00020\u0004*\u000203H\u0086\u0008¢\u0006\u0006\u0008\u0096\u0001\u0010\u0094\u0001\u001a:\u0010\u009b\u0001\u001a\u0004\u0018\u00018\u0000\"\u0004\u0008\u0000\u0010z2\u0007\u0010\u0097\u0001\u001a\u0002032\u000e\u0010\u0099\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0098\u00012\u0007\u0010\u009a\u0001\u001a\u00020\u0007¢\u0006\u0006\u0008\u009b\u0001\u0010\u009c\u0001\u001a-\u0010 \u0001\u001a\u00020\u0004\"\u0005\u0008\u0000\u0010\u009d\u0001*\t\u0012\u0004\u0012\u00028\u00000\u009e\u00012\u0007\u0010\u009f\u0001\u001a\u00028\u0000H\u0000¢\u0006\u0006\u0008 \u0001\u0010¡\u0001\u001a\u0017\u0010¢\u0001\u001a\u00020\u0004*\u000203H\u0080\u0008¢\u0006\u0006\u0008¢\u0001\u0010\u0094\u0001\u001a\u0017\u0010£\u0001\u001a\u00020\u0004*\u000203H\u0080\u0008¢\u0006\u0006\u0008£\u0001\u0010\u0094\u0001\u001a0\u0010¨\u0001\u001a\u00030§\u0001*\u00080¤\u0001j\u0003`¥\u00012\u0013\u0010¦\u0001\u001a\u000e\u0012\n\u0012\u00080¤\u0001j\u0003`¥\u00010B¢\u0006\u0006\u0008¨\u0001\u0010©\u0001\u001aC\u0010­\u0001\u001a\u0008\u0012\u0004\u0012\u00028\u00000B\"\u0004\u0008\u0000\u0010z*\t\u0012\u0004\u0012\u00028\u00000ª\u00012\u0014\u0010¬\u0001\u001a\u000f\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\t0«\u0001H\u0086\u0008ø\u0001\u0000¢\u0006\u0006\u0008­\u0001\u0010®\u0001\"\u001a\u0010°\u0001\u001a\u00030¯\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0008\n\u0006\u0008°\u0001\u0010±\u0001\"\u001a\u0010³\u0001\u001a\u00030²\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008³\u0001\u0010´\u0001\"\u0019\u0010µ\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086T¢\u0006\u0008\n\u0006\u0008µ\u0001\u0010¶\u0001\"\u0019\u0010·\u0001\u001a\u00020\t8\u0000@\u0001X\u0081\u0004¢\u0006\u0008\n\u0006\u0008·\u0001\u0010¸\u0001\"\u001a\u0010º\u0001\u001a\u00030¹\u00018\u0002@\u0002X\u0082\u0004¢\u0006\u0008\n\u0006\u0008º\u0001\u0010»\u0001\"\u0019\u0010¼\u0001\u001a\u00020D8\u0006@\u0007X\u0087\u0004¢\u0006\u0008\n\u0006\u0008¼\u0001\u0010½\u0001\"\u001a\u0010¿\u0001\u001a\u00030¾\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0008\n\u0006\u0008¿\u0001\u0010À\u0001\"\u0019\u0010Á\u0001\u001a\u00020\u00078\u0000@\u0001X\u0081\u0004¢\u0006\u0008\n\u0006\u0008Á\u0001\u0010¶\u0001\"\u001a\u0010Ã\u0001\u001a\u00030Â\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0008\n\u0006\u0008Ã\u0001\u0010Ä\u0001\"\u001a\u0010Æ\u0001\u001a\u00030Å\u00018\u0006@\u0007X\u0087\u0004¢\u0006\u0008\n\u0006\u0008Æ\u0001\u0010Ç\u0001\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006È\u0001", d2 = {"", "arrayLength", "offset", "count", "Lkotlin/w;", "checkOffsetAndCount", "(JJJ)V", "", "name", "", "daemon", "Ljava/util/concurrent/ThreadFactory;", "threadFactory", "(Ljava/lang/String;Z)Ljava/util/concurrent/ThreadFactory;", "", "other", "Ljava/util/Comparator;", "comparator", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "hasIntersection", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "Lokhttp3/HttpUrl;", "includeDefaultPort", "toHostHeader", "(Lokhttp3/HttpUrl;Z)Ljava/lang/String;", "value", "", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "concat", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "startIndex", "endIndex", "indexOfFirstNonAsciiWhitespace", "(Ljava/lang/String;II)I", "indexOfLastNonAsciiWhitespace", "trimSubstring", "(Ljava/lang/String;II)Ljava/lang/String;", "delimiters", "delimiterOffset", "(Ljava/lang/String;Ljava/lang/String;II)I", "", "delimiter", "(Ljava/lang/String;CII)I", "indexOfControlOrNonAscii", "(Ljava/lang/String;)I", "canParseAsIpAddress", "(Ljava/lang/String;)Z", "isSensitiveHeader", "format", "", "args", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Ll/h;", "Ljava/nio/charset/Charset;", "default", "readBomAsCharset", "(Ll/h;Ljava/nio/charset/Charset;)Ljava/nio/charset/Charset;", "duration", "Ljava/util/concurrent/TimeUnit;", "unit", "checkDuration", "(Ljava/lang/String;JLjava/util/concurrent/TimeUnit;)I", "parseHexDigit", "(C)I", "", "Lokhttp3/internal/http2/Header;", "Lokhttp3/Headers;", "toHeaders", "(Ljava/util/List;)Lokhttp3/Headers;", "toHeaderList", "(Lokhttp3/Headers;)Ljava/util/List;", "canReuseConnectionFor", "(Lokhttp3/HttpUrl;Lokhttp3/HttpUrl;)Z", "Lokhttp3/EventListener;", "Lokhttp3/EventListener$Factory;", "asFactory", "(Lokhttp3/EventListener;)Lokhttp3/EventListener$Factory;", "", "mask", "and", "(BI)I", "", "(SI)I", "(IJ)J", "Ll/g;", "medium", "writeMedium", "(Ll/g;I)V", "readMedium", "(Ll/h;)I", "Ll/d0;", "timeUnit", "skipAll", "(Ll/d0;ILjava/util/concurrent/TimeUnit;)Z", "timeout", "discard", "Ljava/net/Socket;", "peerName", "(Ljava/net/Socket;)Ljava/lang/String;", "source", "isHealthy", "(Ljava/net/Socket;Ll/h;)Z", "Lkotlin/Function0;", "block", "ignoreIoExceptions", "(Lkotlin/d0/c/a;)V", "threadName", "(Ljava/lang/String;Lkotlin/d0/c/a;)V", "Ll/f;", "b", "(Ll/f;B)I", "indexOfNonWhitespace", "(Ljava/lang/String;I)I", "Lokhttp3/Response;", "headersContentLength", "(Lokhttp3/Response;)J", "defaultValue", "toLongOrDefault", "(Ljava/lang/String;J)J", "toNonNegativeInt", "T", "toImmutableList", "(Ljava/util/List;)Ljava/util/List;", "elements", "immutableListOf", "([Ljava/lang/Object;)Ljava/util/List;", "K", "V", "", "toImmutableMap", "(Ljava/util/Map;)Ljava/util/Map;", "Ljava/io/Closeable;", "closeQuietly", "(Ljava/io/Closeable;)V", "(Ljava/net/Socket;)V", "Ljava/net/ServerSocket;", "(Ljava/net/ServerSocket;)V", "Lokhttp3/internal/io/FileSystem;", "Ljava/io/File;", "file", "isCivilized", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;)Z", "toHexString", "(J)Ljava/lang/String;", "(I)Ljava/lang/String;", "wait", "(Ljava/lang/Object;)V", "notify", "notifyAll", "instance", "Ljava/lang/Class;", "fieldType", "fieldName", "readFieldOrNull", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "E", "", "element", "addIfAbsent", "(Ljava/util/List;Ljava/lang/Object;)V", "assertThreadHoldsLock", "assertThreadDoesntHoldLock", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "", "withSuppressed", "(Ljava/lang/Exception;Ljava/util/List;)Ljava/lang/Throwable;", "", "Lkotlin/Function1;", "predicate", "filterList", "(Ljava/lang/Iterable;Lkotlin/d0/c/l;)Ljava/util/List;", "Ljava/util/TimeZone;", "UTC", "Ljava/util/TimeZone;", "Lkotlin/k0/h;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/k0/h;", "userAgent", "Ljava/lang/String;", "assertionsEnabled", "Z", "Ll/t;", "UNICODE_BOMS", "Ll/t;", "EMPTY_HEADERS", "Lokhttp3/Headers;", "", "EMPTY_BYTE_ARRAY", "[B", "okHttpName", "Lokhttp3/ResponseBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "Lokhttp3/RequestBody;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "okhttp"}, k = 2, mv = {1, 4, 0})
public final class Util {

    public static final byte[] EMPTY_BYTE_ARRAY = null;
    public static final Headers EMPTY_HEADERS = null;
    public static final RequestBody EMPTY_REQUEST = null;
    public static final ResponseBody EMPTY_RESPONSE = null;
    private static final t UNICODE_BOMS = null;
    public static final TimeZone UTC = null;
    private static final h VERIFY_AS_IP_ADDRESS = null;
    public static final boolean assertionsEnabled = false;
    public static final String okHttpName = null;
    public static final String userAgent = "okhttp/4.9.2";
    static {
        int i = 0;
        byte[] bArr = new byte[i];
        Util.EMPTY_BYTE_ARRAY = bArr;
        Util.EMPTY_HEADERS = Headers.Companion.of(new String[i]);
        int i3 = 0;
        final int i11 = 1;
        Util.EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, i3, i11, i3);
        Util.EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, i3, 0, 0, 7, 0);
        i[] arr = new i[5];
        i.a aVar2 = i.v;
        arr[i] = aVar2.b("efbbbf");
        arr[i11] = aVar2.b("feff");
        arr[2] = aVar2.b("fffe");
        arr[3] = aVar2.b("0000ffff");
        arr[4] = aVar2.b("ffff0000");
        Util.UNICODE_BOMS = t.v.d(arr);
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        n.d(timeZone);
        Util.UTC = timeZone;
        h hVar = new h("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        Util.VERIFY_AS_IP_ADDRESS = hVar;
        Class<okhttp3.OkHttpClient> obj2 = OkHttpClient.class;
        Util.assertionsEnabled = i;
        String name = OkHttpClient.class.getName();
        n.e(name, "OkHttpClient::class.java.name");
        Util.okHttpName = l.v0(l.u0(name, "okhttp3."), "Client");
    }

    public static final <E> void addIfAbsent(List<E> list, E e2) {
        n.f(list, "$this$addIfAbsent");
        if (!list.contains(e2)) {
            list.add(e2);
        }
    }

    public static final int and(byte b, int i2) {
        return b &= i2;
    }

    public static final int and(short s, int i2) {
        return s &= i2;
    }

    public static final long and(int i, long l2) {
        return l & l2;
    }

    public static final EventListener.Factory asFactory(EventListener eventListener) {
        n.f(eventListener, "$this$asFactory");
        Util.asFactory.1 anon = new Util.asFactory.1(eventListener);
        return anon;
    }

    public static final void assertThreadDoesntHoldLock(Object object) {
        boolean assertionsEnabled;
        n.f(object, "$this$assertThreadDoesntHoldLock");
        if (Util.assertionsEnabled) {
            if (Thread.holdsLock(object)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST NOT hold lock on ");
            stringBuilder.append(object);
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }
    }

    public static final void assertThreadHoldsLock(Object object) {
        boolean assertionsEnabled;
        n.f(object, "$this$assertThreadHoldsLock");
        if (Util.assertionsEnabled) {
            if (!Thread.holdsLock(object)) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Thread ");
            Thread currentThread = Thread.currentThread();
            n.e(currentThread, "Thread.currentThread()");
            stringBuilder.append(currentThread.getName());
            stringBuilder.append(" MUST hold lock on ");
            stringBuilder.append(object);
            AssertionError assertionError = new AssertionError(stringBuilder.toString());
            throw assertionError;
        }
    }

    public static final boolean canParseAsIpAddress(String string) {
        n.f(string, "$this$canParseAsIpAddress");
        return Util.VERIFY_AS_IP_ADDRESS.d(string);
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl httpUrl2) {
        int port;
        int host;
        int obj2;
        Object obj3;
        n.f(httpUrl, "$this$canReuseConnectionFor");
        n.f(httpUrl2, "other");
        if (n.b(httpUrl.host(), httpUrl2.host()) && httpUrl.port() == httpUrl2.port() && n.b(httpUrl.scheme(), httpUrl2.scheme())) {
            if (httpUrl.port() == httpUrl2.port()) {
                obj2 = n.b(httpUrl.scheme(), httpUrl2.scheme()) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    public static final int checkDuration(String string, long l2, TimeUnit timeUnit3) {
        int i2;
        int i3;
        int i;
        int obj10;
        n.f(string, "name");
        int i4 = 0;
        final int cmp = Long.compare(l2, i4);
        i2 = 1;
        final int i5 = 0;
        i3 = cmp >= 0 ? i2 : i5;
        if (i3 == 0) {
        } else {
            i = obj10 != null ? i2 : i5;
            if (i == 0) {
            } else {
                long obj8 = obj10.toMillis(l2);
                obj10 = Long.compare(obj8, l) <= 0 ? i2 : i5;
                if (obj10 == null) {
                } else {
                    if (Long.compare(obj8, i4) == 0) {
                        if (cmp <= 0) {
                        } else {
                            i2 = i5;
                        }
                    }
                    if (i2 == 0) {
                    } else {
                        return (int)obj8;
                    }
                    obj8 = new StringBuilder();
                    obj8.append(string);
                    obj8.append(" too small.");
                    obj8 = new IllegalArgumentException(obj8.toString().toString());
                    throw obj8;
                }
                obj8 = new StringBuilder();
                obj8.append(string);
                obj8.append(" too large.");
                obj8 = new IllegalArgumentException(obj8.toString().toString());
                throw obj8;
            }
            IllegalStateException obj7 = new IllegalStateException("unit == null".toString());
            throw obj7;
        }
        obj8 = new StringBuilder();
        obj8.append(string);
        obj8.append(" < 0");
        obj8 = new IllegalStateException(obj8.toString().toString());
        throw obj8;
    }

    public static final void checkOffsetAndCount(long l, long l2, long l3) {
        int cmp;
        int obj4;
        if (Long.compare(i, i2) < 0) {
        } else {
            if (Long.compare(l3, l) > 0) {
            } else {
                if (Long.compare(obj4, obj8) < 0) {
                } else {
                }
            }
        }
        obj4 = new ArrayIndexOutOfBoundsException();
        throw obj4;
    }

    public static final void closeQuietly(Closeable closeable) {
        n.f(closeable, "$this$closeQuietly");
        closeable.close();
    }

    public static final void closeQuietly(ServerSocket serverSocket) {
        n.f(serverSocket, "$this$closeQuietly");
        serverSocket.close();
    }

    public static final void closeQuietly(Socket socket) {
        n.f(socket, "$this$closeQuietly");
        socket.close();
    }

    public static final String[] concat(String[] stringArr, String string2) {
        n.f(stringArr, "$this$concat");
        n.f(string2, "value");
        final Object[] obj1 = Arrays.copyOf(stringArr, length++);
        n.e(obj1, "java.util.Arrays.copyOf(this, newSize)");
        obj1[i.B((String[])obj1)] = string2;
        Objects.requireNonNull(obj1, "null cannot be cast to non-null type kotlin.Array<kotlin.String>");
        return obj1;
    }

    public static final int delimiterOffset(String string, char c2, int i3, int i4) {
        String charAt;
        int obj3;
        n.f(string, "$this$delimiterOffset");
        while (obj3 < i4) {
            obj3++;
        }
        return i4;
    }

    public static final int delimiterOffset(String string, String string2, int i3, int i4) {
        String str;
        int i;
        int i2;
        int i5;
        int obj6;
        n.f(string, "$this$delimiterOffset");
        n.f(string2, "delimiters");
        while (obj6 < i4) {
            obj6++;
        }
        return i4;
    }

    public static int delimiterOffset$default(String string, char c2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = string.length();
        }
        return Util.delimiterOffset(string, c2, obj2, obj3);
    }

    public static int delimiterOffset$default(String string, String string2, int i3, int i4, int i5, Object object6) {
        int obj2;
        int obj3;
        if (i5 & 2 != 0) {
            obj2 = 0;
        }
        if (i5 &= 4 != 0) {
            obj3 = string.length();
        }
        return Util.delimiterOffset(string, string2, obj2, obj3);
    }

    public static final boolean discard(d0 d0, int i2, TimeUnit timeUnit3) {
        boolean obj1;
        n.f(d0, "$this$discard");
        n.f(timeUnit3, "timeUnit");
        obj1 = Util.skipAll(d0, i2, timeUnit3);
        return obj1;
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, l<? super T, Boolean> l2) {
        List arrayList;
        Object next;
        boolean booleanValue;
        n.f(iterable, "$this$filterList");
        n.f(l2, "predicate");
        arrayList = p.g();
        final Iterator obj3 = iterable.iterator();
        while (obj3.hasNext()) {
            next = obj3.next();
            if ((Boolean)l2.invoke(next).booleanValue() && arrayList.isEmpty()) {
            }
            if (arrayList.isEmpty()) {
            }
            Objects.requireNonNull(arrayList, "null cannot be cast to non-null type kotlin.collections.MutableList<T>");
            g0.b(arrayList).add(next);
            arrayList = new ArrayList();
        }
        return arrayList;
    }

    public static final String format(String string, Object... object2Arr2) {
        n.f(string, "format");
        n.f(object2Arr2, "args");
        f0 f0Var = f0.a;
        Object[] obj3 = Arrays.copyOf(object2Arr2, object2Arr2.length);
        final String obj2 = String.format(Locale.US, string, Arrays.copyOf(obj3, obj3.length));
        n.e(obj2, "java.lang.String.format(locale, format, *args)");
        return obj2;
    }

    public static final boolean hasIntersection(String[] stringArr, String[] string2Arr2, Comparator<? super String> comparator3) {
        int length;
        int i;
        Object obj;
        int length2;
        int i2;
        int compare;
        n.f(stringArr, "$this$hasIntersection");
        n.f(comparator3, "comparator");
        final int i3 = 1;
        final int i4 = 0;
        length = stringArr.length == 0 ? i3 : i4;
        if (length == 0 && string2Arr2 != null) {
            if (string2Arr2 != null) {
                length = string2Arr2.length == 0 ? i3 : i4;
                if (length != 0) {
                } else {
                    i = i4;
                    while (i < stringArr.length) {
                        i2 = i4;
                        while (i2 < string2Arr2.length) {
                            i2++;
                        }
                        i++;
                        i2++;
                    }
                }
            }
        }
        return i4;
    }

    public static final long headersContentLength(Response response) {
        int longOrDefault;
        n.f(response, "$this$headersContentLength");
        String obj2 = response.headers().get("Content-Length");
        if (obj2 != null) {
            longOrDefault = Util.toLongOrDefault(obj2, -1);
        }
        return longOrDefault;
    }

    public static final void ignoreIoExceptions(a<w> a) {
        n.f(a, "block");
        a.invoke();
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... tArr) {
        n.f(tArr, "elements");
        Object obj1 = tArr.clone();
        obj1 = Collections.unmodifiableList(p.j(Arrays.copyOf((Object[])obj1, obj1.length)));
        n.e(obj1, "Collections.unmodifiable…istOf(*elements.clone()))");
        return obj1;
    }

    public static final int indexOf(String[] stringArr, String string2, Comparator<String> comparator3) {
        int i;
        int i2;
        n.f(stringArr, "$this$indexOf");
        n.f(string2, "value");
        n.f(comparator3, "comparator");
        final int i3 = 0;
        i = i3;
        while (i < stringArr.length) {
            if (comparator3.compare(stringArr[i], string2) == 0) {
            } else {
            }
            i2 = i3;
            i++;
            i2 = 1;
        }
        i = -1;
        return i;
    }

    public static final int indexOfControlOrNonAscii(String string) {
        int i2;
        int charAt;
        int i;
        n.f(string, "$this$indexOfControlOrNonAscii");
        i2 = 0;
        while (i2 < string.length()) {
            charAt = string.charAt(i2);
            i2++;
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String string, int i2, int i3) {
        String charAt;
        int i;
        int obj3;
        n.f(string, "$this$indexOfFirstNonAsciiWhitespace");
        while (obj3 < i3) {
            charAt = string.charAt(obj3);
            obj3++;
        }
        return i3;
    }

    public static int indexOfFirstNonAsciiWhitespace$default(String string, int i2, int i3, int i4, Object object5) {
        int obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = 0;
        }
        if (i4 &= 2 != 0) {
            obj2 = string.length();
        }
        return Util.indexOfFirstNonAsciiWhitespace(string, obj1, obj2);
    }

    public static final int indexOfLastNonAsciiWhitespace(String string, int i2, int i3) {
        String charAt;
        int i;
        int obj4;
        n.f(string, "$this$indexOfLastNonAsciiWhitespace");
        if (i3-- >= i2) {
        }
        return i2;
    }

    public static int indexOfLastNonAsciiWhitespace$default(String string, int i2, int i3, int i4, Object object5) {
        int obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = 0;
        }
        if (i4 &= 2 != 0) {
            obj2 = string.length();
        }
        return Util.indexOfLastNonAsciiWhitespace(string, obj1, obj2);
    }

    public static final int indexOfNonWhitespace(String string, int i2) {
        char charAt;
        int i;
        int obj4;
        n.f(string, "$this$indexOfNonWhitespace");
        while (obj4 < string.length()) {
            charAt = string.charAt(obj4);
            obj4++;
        }
        return string.length();
    }

    public static int indexOfNonWhitespace$default(String string, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return Util.indexOfNonWhitespace(string, obj1);
    }

    public static final String[] intersect(String[] stringArr, String[] string2Arr2, Comparator<? super String> comparator3) {
        int i;
        Object obj;
        int length;
        int i2;
        int compare;
        n.f(stringArr, "$this$intersect");
        n.f(string2Arr2, "other");
        n.f(comparator3, "comparator");
        ArrayList arrayList = new ArrayList();
        final int i3 = 0;
        i = i3;
        while (i < stringArr.length) {
            obj = stringArr[i];
            i2 = i3;
            while (i2 < string2Arr2.length) {
                if (comparator3.compare(obj, string2Arr2[i2]) == 0) {
                    break loop_3;
                } else {
                }
                i2++;
            }
            i++;
            if (comparator3.compare(obj, string2Arr2[i2]) == 0) {
            } else {
            }
            i2++;
            arrayList.add(obj);
        }
        Object[] obj8 = arrayList.toArray(new String[i3]);
        Objects.requireNonNull(obj8, "null cannot be cast to non-null type kotlin.Array<T>");
        return (String[])obj8;
    }

    public static final boolean isCivilized(FileSystem fileSystem, File file2) {
        n.f(fileSystem, "$this$isCivilized");
        n.f(file2, "file");
        fileSystem.delete(file2);
        b.a(fileSystem.sink(file2), 0);
        return 1;
    }

    public static final boolean isHealthy(Socket socket, h h2) {
        int i;
        n.f(socket, "$this$isHealthy");
        n.f(h2, "source");
        int i3 = 1;
        socket.setSoTimeout(i3);
        socket.setSoTimeout(socket.getSoTimeout());
        i = obj3;
        return i;
    }

    public static final boolean isSensitiveHeader(String string) {
        boolean str;
        int i;
        Object obj2;
        n.f(string, "name");
        i = 1;
        if (!l.x(string, "Authorization", i) && !l.x(string, "Cookie", i) && !l.x(string, "Proxy-Authorization", i)) {
            if (!l.x(string, "Cookie", i)) {
                if (!l.x(string, "Proxy-Authorization", i)) {
                    if (l.x(string, "Set-Cookie", i)) {
                    } else {
                        i = 0;
                    }
                }
            }
        }
        return i;
    }

    public static final void notify(Object object) {
        n.f(object, "$this$notify");
        object.notify();
    }

    public static final void notifyAll(Object object) {
        n.f(object, "$this$notifyAll");
        object.notifyAll();
    }

    public static final int parseHexDigit(char c) {
        int i2;
        int i;
        int obj2;
        i2 = 48;
        if (i2 > c) {
            if (97 > c) {
                if (65 > c) {
                    obj2 = -1;
                } else {
                    obj2 += 10;
                }
            } else {
                if (102 >= c) {
                } else {
                }
            }
        } else {
            if (57 >= c) {
                c -= i2;
            } else {
            }
        }
        return obj2;
    }

    public static final String peerName(Socket socket) {
        String str;
        String obj1;
        n.f(socket, "$this$peerName");
        obj1 = socket.getRemoteSocketAddress();
        if (obj1 instanceof InetSocketAddress) {
            n.e((InetSocketAddress)obj1.getHostName(), "address.hostName");
        } else {
            obj1 = obj1.toString();
        }
        return obj1;
    }

    public static final Charset readBomAsCharset(h h, Charset charset2) {
        int obj1;
        Object obj2;
        n.f(h, "$this$readBomAsCharset");
        n.f(charset2, "default");
        obj1 = h.i2(Util.UNICODE_BOMS);
        if (obj1 != -1) {
            if (obj1 != null) {
                if (obj1 != 1) {
                    if (obj1 != 2) {
                        if (obj1 != 3) {
                            if (obj1 != 4) {
                            } else {
                                obj2 = d.d.b();
                            }
                            obj1 = new AssertionError();
                            throw obj1;
                        }
                        obj2 = d.d.a();
                    } else {
                        n.e(StandardCharsets.UTF_16LE, "UTF_16LE");
                    }
                } else {
                    n.e(StandardCharsets.UTF_16BE, "UTF_16BE");
                }
            } else {
                n.e(StandardCharsets.UTF_8, "UTF_8");
            }
        }
        return obj2;
    }

    public static final <T> T readFieldOrNull(Object object, Class<T> class2, String string3) {
        Class class;
        String str;
        int cast;
        Object obj6;
        final Class<Object> obj = Object.class;
        n.f(object, "instance");
        n.f(class2, "fieldType");
        n.f(string3, "fieldName");
        class = object.getClass();
        int i3 = 1;
        if (z ^= i3 != 0) {
            Field declaredField = class.getDeclaredField(string3);
            n.e(declaredField, "field");
            declaredField.setAccessible(i3);
            Object obj2 = declaredField.get(object);
            if (!class2.isInstance(obj2)) {
            } else {
                cast = class2.cast(obj2);
            }
            return cast;
        }
        String str5 = "delegate";
        obj6 = Util.readFieldOrNull(object, obj, str5);
        if (z2 ^= i3 != 0 && obj6 != null) {
            obj6 = Util.readFieldOrNull(object, obj, str5);
            if (obj6 != null) {
                return Util.readFieldOrNull(obj6, class2, string3);
            }
        }
        return 0;
    }

    public static final int readMedium(h h) {
        n.f(h, "$this$readMedium");
        final int i4 = 255;
        return obj3 |= i3;
    }

    public static final int skipAll(f f, byte b2) {
        int i;
        byte b;
        n.f(f, "$this$skipAll");
        i = 0;
        while (!f.b0()) {
            if (f.n(0) == b2) {
            }
            i++;
            f.readByte();
        }
        return i;
    }

    public static final boolean skipAll(d0 d0, int i2, TimeUnit timeUnit3) {
        long nanoTime;
        boolean deadline;
        long l;
        long read;
        int i3;
        e0 obj11;
        int obj12;
        Object obj13;
        n.f(d0, "$this$skipAll");
        n.f(timeUnit3, "timeUnit");
        nanoTime = System.nanoTime();
        final long l2 = Long.MAX_VALUE;
        if (d0.timeout().hasDeadline()) {
            deadlineNanoTime -= nanoTime;
        } else {
            l = l2;
        }
        d0.timeout().deadlineNanoTime(obj12 += nanoTime);
        obj12 = new f();
        while (Long.compare(read, i3) != null) {
            obj12.a();
        }
        obj12 = 1;
        if (Long.compare(l, l2) == 0) {
            d0.timeout().clearDeadline();
        } else {
            d0.timeout().deadlineNanoTime(nanoTime += l);
        }
        return obj12;
    }

    public static final ThreadFactory threadFactory(String string, boolean z2) {
        n.f(string, "name");
        Util.threadFactory.1 anon = new Util.threadFactory.1(string, z2);
        return anon;
    }

    public static final void threadName(String string, a<w> a2) {
        n.f(string, "name");
        n.f(a2, "block");
        Thread currentThread = Thread.currentThread();
        n.e(currentThread, "currentThread");
        currentThread.setName(string);
        final int obj2 = 1;
        a2.invoke();
        l.b(obj2);
        currentThread.setName(currentThread.getName());
        l.a(obj2);
    }

    public static final List<Header> toHeaderList(Headers headers) {
        int value;
        Header header;
        String name;
        n.f(headers, "$this$toHeaderList");
        kotlin.h0.f fVar = g.l(0, headers.size());
        ArrayList arrayList = new ArrayList(p.r(fVar, 10));
        Iterator iterator = fVar.iterator();
        while (iterator.hasNext()) {
            int i3 = (h0)iterator.d();
            header = new Header(headers.name(i3), headers.value(i3));
            arrayList.add(header);
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> list) {
        String str2;
        String str;
        n.f(list, "$this$toHeaders");
        Headers.Builder builder = new Headers.Builder();
        Iterator obj3 = list.iterator();
        for (Header next2 : obj3) {
            builder.addLenient$okhttp(next2.component1().E(), next2.component2().E());
        }
        return builder.build();
    }

    public static final String toHexString(int i) {
        final String obj1 = Integer.toHexString(i);
        n.e(obj1, "Integer.toHexString(this)");
        return obj1;
    }

    public static final String toHexString(long l) {
        final String obj0 = Long.toHexString(l);
        n.e(obj0, "java.lang.Long.toHexString(this)");
        return obj0;
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z2) {
        String string;
        int defaultPort;
        int scheme;
        int obj5;
        int obj6;
        n.f(httpUrl, "$this$toHostHeader");
        if (l.R(httpUrl.host(), ":", false, 2, 0)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append('[');
            stringBuilder.append(httpUrl.host());
            stringBuilder.append(']');
            string = stringBuilder.toString();
        } else {
            string = httpUrl.host();
        }
        if (z2 == 0) {
            if (httpUrl.port() != HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
                obj6 = new StringBuilder();
                obj6.append(string);
                obj6.append(':');
                obj6.append(httpUrl.port());
                string = obj6.toString();
            }
        } else {
        }
        return string;
    }

    public static String toHostHeader$default(HttpUrl httpUrl, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return Util.toHostHeader(httpUrl, obj1);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        n.f(list, "$this$toImmutableList");
        List obj1 = Collections.unmodifiableList(p.N0(list));
        n.e(obj1, "Collections.unmodifiableList(toMutableList())");
        return obj1;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        boolean empty;
        Map obj1;
        n.f(map, "$this$toImmutableMap");
        if (map.isEmpty()) {
            obj1 = j0.h();
        } else {
            LinkedHashMap linkedHashMap = new LinkedHashMap(map);
            n.e(Collections.unmodifiableMap(linkedHashMap), "Collections.unmodifiableMap(LinkedHashMap(this))");
        }
        return obj1;
    }

    public static final long toLongOrDefault(String string, long l2) {
        n.f(string, "$this$toLongOrDefault");
        return Long.parseLong(string);
    }

    public static final int toNonNegativeInt(String string, int i2) {
        int i;
        if (string != null) {
            final long obj3 = Long.parseLong(string);
            if (Long.compare(obj3, l) > 0) {
                try {
                    if (Long.compare(obj3, i3) < 0) {
                    } else {
                    }
                    i = 0;
                    i = (int)obj3;
                }
            } else {
            }
            return i;
        }
        return i2;
    }

    public static final String trimSubstring(String string, int i2, int i3) {
        n.f(string, "$this$trimSubstring");
        int obj2 = Util.indexOfFirstNonAsciiWhitespace(string, i2, i3);
        final String obj1 = string.substring(obj2, Util.indexOfLastNonAsciiWhitespace(string, obj2, i3));
        n.e(obj1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return obj1;
    }

    public static String trimSubstring$default(String string, int i2, int i3, int i4, Object object5) {
        int obj1;
        int obj2;
        if (i4 & 1 != 0) {
            obj1 = 0;
        }
        if (i4 &= 2 != 0) {
            obj2 = string.length();
        }
        return Util.trimSubstring(string, obj1, obj2);
    }

    public static final void wait(Object object) {
        n.f(object, "$this$wait");
        object.wait();
    }

    public static final Throwable withSuppressed(Exception exception, List<? extends Exception> list2) {
        int size;
        n.f(exception, "$this$withSuppressed");
        n.f(list2, "suppressed");
        if (list2.size() > 1) {
            System.out.println(list2);
        }
        final Iterator obj3 = list2.iterator();
        for (Exception size : obj3) {
            b.a(exception, size);
        }
        return exception;
    }

    public static final void writeMedium(g g, int i2) {
        n.f(g, "$this$writeMedium");
        g.c0(i &= 255);
        g.c0(i4 &= 255);
        g.c0(i2 &= 255);
    }
}
