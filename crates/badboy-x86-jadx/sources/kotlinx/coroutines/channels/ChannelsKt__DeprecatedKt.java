package kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u001f\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0008\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u001aJ\u0010\u0000\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u00072\u001a\u0010\u0008\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\n0\t\"\u0006\u0012\u0002\u0008\u00030\nH\u0001¢\u0006\u0002\u0010\u000b\u001a!\u0010\u000c\u001a\u00020\r\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a1\u0010\u0010\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007*\u0006\u0012\u0002\u0008\u00030\nH\u0001\u001a!\u0010\u0011\u001a\u00020\u0012\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a\u001e\u0010\u0013\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\nH\u0007\u001aZ\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\u0008\u0000\u0010\u000e\"\u0004\u0008\u0001\u0010\u0015*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010\u0018\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00150\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a0\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\u001e\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001aT\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a)\u0010!\u001a\u0002H\u000e\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\"\u001a\u00020\u0012H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010#\u001a+\u0010$\u001a\u0004\u0018\u0001H\u000e\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\"\u001a\u00020\u0012H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010#\u001aT\u0010%\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ai\u0010&\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u001727\u0010 \u001a3\u0008\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\"\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0'H\u0007ø\u0001\u0000¢\u0006\u0002\u0010(\u001aT\u0010)\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a$\u0010*\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\n\"\u0008\u0008\u0000\u0010\u000e*\u00020\u001b*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\nH\u0001\u001aA\u0010+\u001a\u0002H,\"\u0008\u0008\u0000\u0010\u000e*\u00020\u001b\"\u0010\u0008\u0001\u0010,*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u000e0-*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a?\u0010+\u001a\u0002H,\"\u0008\u0008\u0000\u0010\u000e*\u00020\u001b\"\u000e\u0008\u0001\u0010,*\u0008\u0012\u0004\u0012\u0002H\u000e00*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0087@ø\u0001\u0000¢\u0006\u0002\u00101\u001a!\u00102\u001a\u0002H\u000e\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a#\u00103\u001a\u0004\u0018\u0001H\u000e\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a`\u00104\u001a\u0008\u0012\u0004\u0012\u0002H50\n\"\u0004\u0008\u0000\u0010\u000e\"\u0004\u0008\u0001\u00105*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172(\u00106\u001a$\u0008\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H50\n0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a)\u00107\u001a\u00020\u0012\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u00108\u001a\u0002H\u000eH\u0087@ø\u0001\u0000¢\u0006\u0002\u00109\u001a!\u0010:\u001a\u0002H\u000e\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a)\u0010;\u001a\u00020\u0012\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u00108\u001a\u0002H\u000eH\u0087@ø\u0001\u0000¢\u0006\u0002\u00109\u001a#\u0010<\u001a\u0004\u0018\u0001H\u000e\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aZ\u0010=\u001a\u0008\u0012\u0004\u0012\u0002H50\n\"\u0004\u0008\u0000\u0010\u000e\"\u0004\u0008\u0001\u00105*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\"\u00106\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001ao\u0010>\u001a\u0008\u0012\u0004\u0012\u0002H50\n\"\u0004\u0008\u0000\u0010\u000e\"\u0004\u0008\u0001\u00105*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u001727\u00106\u001a3\u0008\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\"\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0'H\u0001ø\u0001\u0000¢\u0006\u0002\u0010(\u001au\u0010?\u001a\u0008\u0012\u0004\u0012\u0002H50\n\"\u0004\u0008\u0000\u0010\u000e\"\u0008\u0008\u0001\u00105*\u00020\u001b*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u001729\u00106\u001a5\u0008\u0001\u0012\u0013\u0012\u00110\u0012¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(\"\u0012\u0004\u0012\u0002H\u000e\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0'H\u0007ø\u0001\u0000¢\u0006\u0002\u0010(\u001a`\u0010@\u001a\u0008\u0012\u0004\u0012\u0002H50\n\"\u0004\u0008\u0000\u0010\u000e\"\u0008\u0008\u0001\u00105*\u00020\u001b*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172$\u00106\u001a \u0008\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H50\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a?\u0010A\u001a\u0004\u0018\u0001H\u000e\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u001a\u0010B\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u000e0Cj\n\u0012\u0006\u0008\u0000\u0012\u0002H\u000e`DH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010E\u001a?\u0010F\u001a\u0004\u0018\u0001H\u000e\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u001a\u0010B\u001a\u0016\u0012\u0006\u0008\u0000\u0012\u0002H\u000e0Cj\n\u0012\u0006\u0008\u0000\u0012\u0002H\u000e`DH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010E\u001a!\u0010G\u001a\u00020\r\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a$\u0010H\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\n\"\u0008\u0008\u0000\u0010\u000e*\u00020\u001b*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u000e0\nH\u0007\u001a!\u0010I\u001a\u0002H\u000e\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a#\u0010J\u001a\u0004\u0018\u0001H\u000e\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a0\u0010K\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010\u001e\u001a\u00020\u00122\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001aT\u0010L\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0\n\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u00172\"\u0010 \u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\r0\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a9\u0010M\u001a\u0002H,\"\u0004\u0008\u0000\u0010\u000e\"\u000e\u0008\u0001\u0010,*\u0008\u0012\u0004\u0012\u0002H\u000e00*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0081@ø\u0001\u0000¢\u0006\u0002\u00101\u001a;\u0010N\u001a\u0002H,\"\u0004\u0008\u0000\u0010\u000e\"\u0010\u0008\u0001\u0010,*\n\u0012\u0006\u0008\u0000\u0012\u0002H\u000e0-*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0006\u0010.\u001a\u0002H,H\u0081@ø\u0001\u0000¢\u0006\u0002\u0010/\u001a?\u0010O\u001a\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002HQ0P\"\u0004\u0008\u0000\u0010\u0015\"\u0004\u0008\u0001\u0010Q*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002HQ0R0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001aU\u0010O\u001a\u0002HS\"\u0004\u0008\u0000\u0010\u0015\"\u0004\u0008\u0001\u0010Q\"\u0018\u0008\u0002\u0010S*\u0012\u0012\u0006\u0008\u0000\u0012\u0002H\u0015\u0012\u0006\u0008\u0000\u0012\u0002HQ0T*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0015\u0012\u0004\u0012\u0002HQ0R0\n2\u0006\u0010.\u001a\u0002HSH\u0081@ø\u0001\u0000¢\u0006\u0002\u0010U\u001a'\u0010V\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0W\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a'\u0010X\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0Y\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\nH\u0081@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a'\u0010Z\u001a\u0008\u0012\u0004\u0012\u0002H\u000e0[\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\nH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u001a.\u0010\\\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u000e0]0\n\"\u0004\u0008\u0000\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001a?\u0010^\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H50R0\n\"\u0004\u0008\u0000\u0010\u000e\"\u0004\u0008\u0001\u00105*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u000c\u0010_\u001a\u0008\u0012\u0004\u0012\u0002H50\nH\u0087\u0004\u001az\u0010^\u001a\u0008\u0012\u0004\u0012\u0002HQ0\n\"\u0004\u0008\u0000\u0010\u000e\"\u0004\u0008\u0001\u00105\"\u0004\u0008\u0002\u0010Q*\u0008\u0012\u0004\u0012\u0002H\u000e0\n2\u000c\u0010_\u001a\u0008\u0012\u0004\u0012\u0002H50\n2\u0008\u0008\u0002\u0010\u0016\u001a\u00020\u001726\u00106\u001a2\u0012\u0013\u0012\u0011H\u000e¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(`\u0012\u0013\u0012\u0011H5¢\u0006\u000c\u0008\u0003\u0012\u0008\u0008\u0004\u0012\u0004\u0008\u0008(a\u0012\u0004\u0012\u0002HQ0\u0019H\u0001\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006b", d2 = {"consumesAll", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "channels", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", "any", "", "E", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumes", "count", "", "distinct", "distinctBy", "K", "context", "Lkotlin/coroutines/CoroutineContext;", "selector", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "drop", "n", "dropWhile", "predicate", "elementAt", "index", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function3;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filterNot", "filterNotNull", "filterNotNullTo", "C", "", "destination", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "first", "firstOrNull", "flatMap", "R", "transform", "indexOf", "element", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapNotNull", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minWith", "none", "requireNoNulls", "single", "singleOrNull", "take", "takeWhile", "toChannel", "toCollection", "toMap", "", "V", "Lkotlin/Pair;", "M", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMutableList", "", "toMutableSet", "", "toSet", "", "withIndex", "Lkotlin/collections/IndexedValue;", "zip", "other", "a", "b", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/channels/ChannelsKt")
final class ChannelsKt__DeprecatedKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object any(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, Continuation continuation2) {
        boolean anon;
        Throwable e$iv;
        int cOROUTINE_SUSPENDED;
        int i4;
        Object l$0;
        int i3;
        Object obj;
        int i2;
        Object next;
        int i;
        int obj8;
        Object obj9;
        anon = continuation2;
        i4 = Integer.MIN_VALUE;
        if (continuation2 instanceof ChannelsKt__DeprecatedKt.any.1 && label &= i4 != 0) {
            anon = continuation2;
            i4 = Integer.MIN_VALUE;
            if (label &= i4 != 0) {
                anon.label = obj9 -= i4;
            } else {
                anon = new ChannelsKt__DeprecatedKt.any.1(continuation2);
            }
        } else {
        }
        obj9 = anon.result;
        cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                l$0 = receiveChannel;
                obj8 = 0;
                i3 = 0;
                i2 = 0;
                anon.L$0 = l$0;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
            case 1:
                obj8 = 0;
                cOROUTINE_SUSPENDED = 0;
                l$0 = anon.L$0;
                i3 = 0;
                ResultKt.throwOnFailure(obj9);
                next = obj9;
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        ChannelsKt.cancelConsumed(l$0, i3);
        return next;
    }

    public static final Function1<Throwable, Unit> consumes(kotlinx.coroutines.channels.ReceiveChannel<?> $this$consumes) {
        ChannelsKt__DeprecatedKt.consumes.1 anon = new ChannelsKt__DeprecatedKt.consumes.1($this$consumes);
        return (Function1)anon;
    }

    public static final Function1<Throwable, Unit> consumesAll(kotlinx.coroutines.channels.ReceiveChannel<?>... channels) {
        ChannelsKt__DeprecatedKt.consumesAll.1 anon = new ChannelsKt__DeprecatedKt.consumesAll.1(channels);
        return (Function1)anon;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object count(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, Continuation continuation2) {
        boolean $result;
        Object $continuation2;
        Throwable e$iv$iv;
        Object $continuation;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.count.1 anon;
        Throwable th;
        int count;
        Object $i$f$consume2;
        int $i$f$consume;
        int $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
        int i4;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        int i3;
        Object cause$iv$iv3;
        kotlinx.coroutines.channels.ReceiveChannel cause$iv$iv2;
        Object cause$iv$iv;
        int $this$consume$iv$iv2;
        Object $this$consume$iv$iv;
        Object count2;
        Object iterator;
        int i;
        int i2;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.count.1 anon2;
        int obj13;
        Object obj14;
        $result = continuation2;
        th = Integer.MIN_VALUE;
        if (continuation2 instanceof ChannelsKt__DeprecatedKt.count.1 && label &= th != 0) {
            $result = continuation2;
            th = Integer.MIN_VALUE;
            if (label &= th != 0) {
                $result.label = obj14 -= th;
            } else {
                $result = new ChannelsKt__DeprecatedKt.count.1(continuation2);
            }
        } else {
        }
        obj14 = $result.result;
        final int i6 = 1;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj14);
                Ref.IntRef intRef = new Ref.IntRef();
                i3 = 0;
                count = obj13;
                obj13 = i8;
                $i$f$consume = i10;
                $this$consume$iv$iv = $this$consumeEach_u24lambda_u241$iv;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2 = iterator;
                break;
            case 1:
                obj13 = 0;
                ResultKt.throwOnFailure(obj14);
                iterator = l$0;
                count2 = l$1;
                $this$consume$iv$iv2 = i9;
                cause$iv$iv3 = l$2;
                i4 = i7;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = i5;
                $i$f$consume2 = $continuation;
                anon = $result;
                $continuation2 = obj14;
                obj14 = cause$iv$iv3.next();
                i = 0;
                iterator.element = element += i6;
                obj14 = $continuation2;
                $result = anon;
                $continuation = $i$f$consume2;
                count = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
                $i$f$consume = i4;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2 = cause$iv$iv3;
                i3 = $this$consume$iv$iv2;
                cause$iv$iv = count2;
                $this$consume$iv$iv = iterator;
                obj14 = Unit.INSTANCE;
                ChannelsKt.cancelConsumed(count2, $this$consume$iv$iv2);
                return Boxing.boxInt(iterator.element);
            default:
                obj13 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj13;
        }
        $result.L$0 = $this$consume$iv$iv;
        $result.L$1 = cause$iv$iv;
        $result.L$2 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
        $result.label = i6;
        Object next = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2.hasNext($result);
        if (next == $continuation) {
            return $continuation;
        } else {
            $continuation2 = obj14;
            obj14 = next;
            iterator = $this$consume$iv$iv;
            count2 = cause$iv$iv;
            $this$consume$iv$iv2 = i3;
            cause$iv$iv3 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
            i4 = $i$f$consume;
            $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = count;
            $i$f$consume2 = $continuation;
            anon = anon2;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel distinct(kotlinx.coroutines.channels.ReceiveChannel $this$distinct) {
        final int i = 0;
        ChannelsKt__DeprecatedKt.distinct.1 anon = new ChannelsKt__DeprecatedKt.distinct.1(i);
        return ChannelsKt.distinctBy$default($this$distinct, i, (Function2)anon, 1, i);
    }

    public static final <E, K> kotlinx.coroutines.channels.ReceiveChannel<E> distinctBy(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$distinctBy, CoroutineContext context, Function2<? super E, ? super Continuation<? super K>, ? extends Object> selector) {
        ChannelsKt__DeprecatedKt.distinctBy.1 anon = new ChannelsKt__DeprecatedKt.distinctBy.1($this$distinctBy, selector, 0);
        return ProduceKt.produce$default((CoroutineScope)GlobalScope.INSTANCE, context, 0, 0, ChannelsKt.consumes($this$distinctBy), (Function2)anon, 6, 0);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel distinctBy$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        kotlinx.coroutines.CoroutineDispatcher obj1;
        if (i4 &= 1 != 0) {
            obj1 = Dispatchers.getUnconfined();
        }
        return ChannelsKt.distinctBy(receiveChannel, obj1, function23);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel drop(kotlinx.coroutines.channels.ReceiveChannel $this$drop, int n, CoroutineContext context) {
        ChannelsKt__DeprecatedKt.drop.1 anon = new ChannelsKt__DeprecatedKt.drop.1(n, $this$drop, 0);
        return ProduceKt.produce$default((CoroutineScope)GlobalScope.INSTANCE, context, 0, 0, ChannelsKt.consumes($this$drop), (Function2)anon, 6, 0);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel drop$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, int i2, CoroutineContext coroutineContext3, int i4, Object object5) {
        kotlinx.coroutines.CoroutineDispatcher obj2;
        if (i4 &= 2 != 0) {
            obj2 = Dispatchers.getUnconfined();
        }
        return ChannelsKt.drop(receiveChannel, i2, obj2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel dropWhile(kotlinx.coroutines.channels.ReceiveChannel $this$dropWhile, CoroutineContext context, Function2 predicate) {
        ChannelsKt__DeprecatedKt.dropWhile.1 anon = new ChannelsKt__DeprecatedKt.dropWhile.1($this$dropWhile, predicate, 0);
        return ProduceKt.produce$default((CoroutineScope)GlobalScope.INSTANCE, context, 0, 0, ChannelsKt.consumes($this$dropWhile), (Function2)anon, 6, 0);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel dropWhile$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        kotlinx.coroutines.CoroutineDispatcher obj1;
        if (i4 &= 1 != 0) {
            obj1 = Dispatchers.getUnconfined();
        }
        return ChannelsKt.dropWhile(receiveChannel, obj1, function23);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object elementAt(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, int i2, Continuation continuation3) {
        boolean $result;
        Object $continuation;
        int obj2;
        Object $continuation3;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.elementAt.1 anon;
        int i;
        int $this$elementAt_u24lambda_u240;
        Object count;
        Throwable $i$a$ConsumeChannelsKt__DeprecatedKt$elementAt$2;
        int index2;
        Object index;
        int i4;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        Object obj;
        Object $this$consume$iv;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel3;
        int $this$consume$iv2;
        Object cause$iv;
        kotlinx.coroutines.channels.ChannelIterator iterator;
        int i3;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.elementAt.1 anon2;
        int obj12;
        int obj13;
        Object obj14;
        $result = continuation3;
        i = Integer.MIN_VALUE;
        if (continuation3 instanceof ChannelsKt__DeprecatedKt.elementAt.1 && label &= i != 0) {
            $result = continuation3;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                $result.label = obj14 -= i;
            } else {
                $result = new ChannelsKt__DeprecatedKt.elementAt.1(continuation3);
            }
        } else {
        }
        obj14 = $result.result;
        final int i5 = 46;
        final String str = "ReceiveChannel doesn't contain element at index ";
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj14);
                obj12 = 0;
                $this$consume$iv2 = 0;
                $i$a$ConsumeChannelsKt__DeprecatedKt$elementAt$2 = i2;
                obj13 = $this$elementAt_u24lambda_u2402;
                $this$elementAt_u24lambda_u240 = i7;
                index = iterator;
                StringBuilder stringBuilder2 = new StringBuilder();
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder2.append(str).append(i2).append(i5).toString());
                throw indexOutOfBoundsException;
            case 1:
                obj12 = 0;
                obj13 = 0;
                ResultKt.throwOnFailure(obj14);
                iterator = i8;
                cause$iv = l$0;
                $this$consume$iv = l$1;
                i4 = i$0;
                index2 = i$1;
                count = $continuation3;
                anon = $result;
                $continuation = obj14;
                ChannelsKt.cancelConsumed(cause$iv, iterator);
                return $this$consume$iv.next();
                obj14 = $continuation;
                $result = anon;
                $continuation3 = count;
                $i$a$ConsumeChannelsKt__DeprecatedKt$elementAt$2 = i4;
                index = $this$consume$iv;
                obj = cause$iv;
                $this$consume$iv2 = iterator;
                $this$elementAt_u24lambda_u240 = i3;
                Object obj4 = cause$iv;
                int i9 = iterator;
                StringBuilder stringBuilder = new StringBuilder();
                obj14 = new IndexOutOfBoundsException(stringBuilder.append(str).append(i4).append(i5).toString());
                throw obj14;
            default:
                obj12 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj12;
        }
        $result.L$0 = obj;
        $result.L$1 = index;
        $result.I$0 = $i$a$ConsumeChannelsKt__DeprecatedKt$elementAt$2;
        $result.I$1 = $this$elementAt_u24lambda_u240;
        $result.label = 1;
        Object next = index.hasNext($result);
        if (next == $continuation3) {
            return $continuation3;
        } else {
            $continuation = obj14;
            obj14 = next;
            iterator = $this$consume$iv2;
            cause$iv = obj;
            $this$consume$iv = index;
            i4 = $i$a$ConsumeChannelsKt__DeprecatedKt$elementAt$2;
            index2 = $this$elementAt_u24lambda_u240;
            count = $continuation3;
            anon = anon2;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object elementAtOrNull(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, int i2, Continuation continuation3) {
        boolean $result;
        Object $continuation;
        int obj;
        Object $continuation3;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.elementAtOrNull.1 anon;
        int i;
        int $i$f$consume;
        Object count;
        Throwable th;
        int $this$elementAtOrNull_u24lambda_u241;
        int cause$iv;
        int $i$a$ConsumeChannelsKt__DeprecatedKt$elementAtOrNull$2;
        int index2;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        Throwable index;
        int $this$consume$iv;
        int i4;
        kotlinx.coroutines.channels.ChannelIterator iterator;
        int i3;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.elementAtOrNull.1 anon2;
        int obj11;
        int obj12;
        Object obj13;
        $result = continuation3;
        i = Integer.MIN_VALUE;
        if (continuation3 instanceof ChannelsKt__DeprecatedKt.elementAtOrNull.1 && label &= i != 0) {
            $result = continuation3;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                $result.label = obj13 -= i;
            } else {
                $result = new ChannelsKt__DeprecatedKt.elementAtOrNull.1(continuation3);
            }
        } else {
        }
        obj13 = $result.result;
        final int i6 = 0;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj13);
                ChannelsKt.cancelConsumed(receiveChannel, i6);
                return i6;
                index = receiveChannel;
                iterator = receiveChannel.iterator();
                $this$elementAtOrNull_u24lambda_u241 = obj11;
                obj11 = i7;
                $i$a$ConsumeChannelsKt__DeprecatedKt$elementAtOrNull$2 = i2;
                obj12 = i5;
                $i$f$consume = i4;
                break;
            case 1:
                obj11 = 0;
                obj12 = 0;
                ResultKt.throwOnFailure(obj13);
                iterator = l$1;
                i4 = l$0;
                index2 = i6;
                $this$consume$iv = i$0;
                cause$iv = i$1;
                count = $continuation3;
                anon = $result;
                $continuation = obj13;
                ChannelsKt.cancelConsumed(i4, index2);
                return iterator.next();
                $this$elementAtOrNull_u24lambda_u241 = index2;
                obj13 = $continuation;
                $result = anon;
                $continuation3 = count;
                $i$a$ConsumeChannelsKt__DeprecatedKt$elementAtOrNull$2 = $this$consume$iv;
                index = i4;
                $i$f$consume = i3;
                ChannelsKt.cancelConsumed(i4, index2);
                return i6;
            default:
                obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj11;
        }
        $result.L$0 = index;
        $result.L$1 = iterator;
        $result.I$0 = $i$a$ConsumeChannelsKt__DeprecatedKt$elementAtOrNull$2;
        $result.I$1 = $i$f$consume;
        $result.label = 1;
        Object next = iterator.hasNext($result);
        if (next == $continuation3) {
            return $continuation3;
        } else {
            $continuation = obj13;
            obj13 = next;
            i4 = index;
            $this$consume$iv = $i$a$ConsumeChannelsKt__DeprecatedKt$elementAtOrNull$2;
            index2 = $this$elementAtOrNull_u24lambda_u241;
            cause$iv = $i$f$consume;
            count = $continuation3;
            anon = anon2;
        }
    }

    public static final <E> kotlinx.coroutines.channels.ReceiveChannel<E> filter(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$filter, CoroutineContext context, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        ChannelsKt__DeprecatedKt.filter.1 anon = new ChannelsKt__DeprecatedKt.filter.1($this$filter, predicate, 0);
        return ProduceKt.produce$default((CoroutineScope)GlobalScope.INSTANCE, context, 0, 0, ChannelsKt.consumes($this$filter), (Function2)anon, 6, 0);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel filter$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        kotlinx.coroutines.CoroutineDispatcher obj1;
        if (i4 &= 1 != 0) {
            obj1 = Dispatchers.getUnconfined();
        }
        return ChannelsKt.filter(receiveChannel, obj1, function23);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel filterIndexed(kotlinx.coroutines.channels.ReceiveChannel $this$filterIndexed, CoroutineContext context, Function3 predicate) {
        ChannelsKt__DeprecatedKt.filterIndexed.1 anon = new ChannelsKt__DeprecatedKt.filterIndexed.1($this$filterIndexed, predicate, 0);
        return ProduceKt.produce$default((CoroutineScope)GlobalScope.INSTANCE, context, 0, 0, ChannelsKt.consumes($this$filterIndexed), (Function2)anon, 6, 0);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel filterIndexed$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function3 function33, int i4, Object object5) {
        kotlinx.coroutines.CoroutineDispatcher obj1;
        if (i4 &= 1 != 0) {
            obj1 = Dispatchers.getUnconfined();
        }
        return ChannelsKt.filterIndexed(receiveChannel, obj1, function33);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel filterNot(kotlinx.coroutines.channels.ReceiveChannel $this$filterNot, CoroutineContext context, Function2 predicate) {
        ChannelsKt__DeprecatedKt.filterNot.1 anon = new ChannelsKt__DeprecatedKt.filterNot.1(predicate, 0);
        return ChannelsKt.filter($this$filterNot, context, (Function2)anon);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel filterNot$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        kotlinx.coroutines.CoroutineDispatcher obj1;
        if (i4 &= 1 != 0) {
            obj1 = Dispatchers.getUnconfined();
        }
        return ChannelsKt.filterNot(receiveChannel, obj1, function23);
    }

    public static final <E> kotlinx.coroutines.channels.ReceiveChannel<E> filterNotNull(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$filterNotNull) {
        int i = 0;
        ChannelsKt__DeprecatedKt.filterNotNull.1 anon = new ChannelsKt__DeprecatedKt.filterNotNull.1(i);
        kotlinx.coroutines.channels.ReceiveChannel filter$default = ChannelsKt.filter$default($this$filterNotNull, i, (Function2)anon, 1, i);
        Intrinsics.checkNotNull(filter$default, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E of kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNull>");
        return filter$default;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object filterNotNullTo(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, Collection collection2, Continuation continuation3) {
        boolean $result;
        Object $continuation;
        Throwable e$iv$iv;
        Object $continuation3;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNullTo.1 anon2;
        int $i$f$consumeEach2;
        int $i$f$consumeEach;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
        int i3;
        Throwable th;
        int i;
        Object cause$iv$iv2;
        Throwable cause$iv$iv3;
        Object cause$iv$iv;
        int $this$consume$iv$iv2;
        Object $this$consume$iv$iv;
        Object destination;
        Object iterator;
        int i2;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNullTo.1 anon;
        int obj10;
        int obj11;
        Object obj12;
        $result = continuation3;
        $i$f$consumeEach2 = Integer.MIN_VALUE;
        if (continuation3 instanceof ChannelsKt__DeprecatedKt.filterNotNullTo.1 && label &= $i$f$consumeEach2 != 0) {
            $result = continuation3;
            $i$f$consumeEach2 = Integer.MIN_VALUE;
            if (label &= $i$f$consumeEach2 != 0) {
                $result.label = obj12 -= $i$f$consumeEach2;
            } else {
                $result = new ChannelsKt__DeprecatedKt.filterNotNullTo.1(continuation3);
            }
        } else {
        }
        obj12 = $result.result;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj12);
                i = 0;
                obj11 = obj10;
                obj10 = i5;
                $i$f$consumeEach = i7;
                $this$consume$iv$iv = $this$consumeEach_u24lambda_u241$iv;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2 = iterator;
                break;
            case 1:
                obj10 = 0;
                obj11 = 0;
                ResultKt.throwOnFailure(obj12);
                iterator = l$0;
                destination = l$1;
                $this$consume$iv$iv2 = i6;
                cause$iv$iv2 = l$2;
                i3 = i4;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = $continuation3;
                anon2 = $result;
                $continuation = obj12;
                obj12 = cause$iv$iv2.next();
                i2 = 0;
                iterator.add(obj12);
                obj12 = $continuation;
                $result = anon2;
                $continuation3 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
                $i$f$consumeEach = i3;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2 = cause$iv$iv2;
                i = $this$consume$iv$iv2;
                cause$iv$iv = destination;
                $this$consume$iv$iv = iterator;
                obj12 = Unit.INSTANCE;
                ChannelsKt.cancelConsumed(destination, $this$consume$iv$iv2);
                return iterator;
            default:
                obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj10;
        }
        $result.L$0 = $this$consume$iv$iv;
        $result.L$1 = cause$iv$iv;
        $result.L$2 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
        $result.label = 1;
        Object next = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2.hasNext($result);
        if (next == $continuation3) {
            return $continuation3;
        } else {
            $continuation = obj12;
            obj12 = next;
            iterator = $this$consume$iv$iv;
            destination = cause$iv$iv;
            $this$consume$iv$iv2 = i;
            cause$iv$iv2 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
            i3 = $i$f$consumeEach;
            $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = $continuation3;
            anon2 = anon;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object filterNotNullTo(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlinx.coroutines.channels.SendChannel sendChannel2, Continuation continuation3) {
        boolean $result;
        Object $continuation2;
        Throwable e$iv$iv;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.filterNotNullTo.3 anon;
        Object $continuation3;
        int $i$f$consumeEach2;
        Object $i$f$consumeEach;
        int i;
        int l$2;
        int destination;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
        int i3;
        Object l$1;
        kotlinx.coroutines.channels.ChannelIterator destination2;
        Object l$0;
        int i2;
        Object send;
        Throwable th;
        int obj11;
        Object obj12;
        Object obj13;
        $result = continuation3;
        $i$f$consumeEach2 = Integer.MIN_VALUE;
        if (continuation3 instanceof ChannelsKt__DeprecatedKt.filterNotNullTo.3 && label &= $i$f$consumeEach2 != 0) {
            $result = continuation3;
            $i$f$consumeEach2 = Integer.MIN_VALUE;
            if (label &= $i$f$consumeEach2 != 0) {
                $result.label = obj13 -= $i$f$consumeEach2;
            } else {
                $result = new ChannelsKt__DeprecatedKt.filterNotNullTo.3(continuation3);
            }
        } else {
        }
        obj13 = $result.result;
        $continuation3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj13);
                i3 = 0;
                destination = 0;
                destination2 = receiveChannel.iterator();
                obj13 = obj11;
                obj11 = i4;
                $i$f$consumeEach = $continuation3;
                anon = $result;
                $continuation2 = th;
                break;
            case 1:
                obj11 = 0;
                obj12 = 0;
                l$2 = $result.L$2;
                i3 = 0;
                l$1 = l$12;
                ResultKt.throwOnFailure(obj13);
                l$0 = $this$consume$iv$iv;
                destination = i5;
                $i$f$consumeEach = $continuation3;
                anon = $result;
                $continuation2 = obj13;
                obj13 = l$2.next();
                anon.L$0 = l$0;
                anon.L$1 = l$1;
                anon.L$2 = l$2;
                anon.label = 2;
                return $i$f$consumeEach;
                obj13 = $continuation2;
                $result = anon;
                $continuation3 = $i$f$consumeEach;
                i = destination;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = l$2;
                l$2 = i2;
                obj13 = obj12;
                obj12 = l$0;
                destination2 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
                destination = i;
                $i$f$consumeEach = $continuation3;
                anon = $result;
                $continuation2 = th;
                obj13 = obj12;
                obj12 = l$0;
                destination2 = l$2;
                obj13 = Unit.INSTANCE;
                ChannelsKt.cancelConsumed(l$1, i3);
                return l$0;
            case 2:
                obj11 = 0;
                obj12 = 0;
                i = 0;
                l$2 = 0;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = $result.L$2;
                i3 = 0;
                l$1 = $result.L$1;
                l$0 = $result.L$0;
                ResultKt.throwOnFailure(obj13);
                obj13 = obj12;
                obj12 = l$0;
                destination2 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
                destination = i;
                $i$f$consumeEach = $continuation3;
                anon = $result;
                $continuation2 = th;
                break;
            default:
                obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj11;
        }
        anon.L$0 = obj12;
        anon.L$1 = l$1;
        anon.L$2 = destination2;
        anon.label = 1;
        Object next = destination2.hasNext(anon);
        if (next == $i$f$consumeEach) {
            return $i$f$consumeEach;
        } else {
            l$0 = obj12;
            obj12 = obj13;
            obj13 = next;
            l$2 = th;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object first(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, Continuation continuation2) {
        boolean anon;
        Throwable e$iv;
        int i;
        int th;
        Object $this$first_u24lambda_u242;
        Object l$0;
        int i3;
        int i2;
        Object next;
        int obj7;
        Object obj8;
        anon = continuation2;
        th = Integer.MIN_VALUE;
        if (continuation2 instanceof ChannelsKt__DeprecatedKt.first.1 && label &= th != 0) {
            anon = continuation2;
            th = Integer.MIN_VALUE;
            if (label &= th != 0) {
                anon.label = obj8 -= th;
            } else {
                anon = new ChannelsKt__DeprecatedKt.first.1(continuation2);
            }
        } else {
        }
        obj8 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj8);
                l$0 = receiveChannel;
                obj7 = 0;
                i3 = 0;
                $this$first_u24lambda_u242 = iterator;
                anon.L$0 = l$0;
                anon.L$1 = $this$first_u24lambda_u242;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                i = i2;
                break;
            case 1:
                obj7 = 0;
                i = 0;
                $this$first_u24lambda_u242 = anon.L$1;
                l$0 = anon.L$0;
                i3 = 0;
                ResultKt.throwOnFailure(obj8);
                next = obj8;
                break;
            default:
                obj7 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj7;
        }
        if (!(Boolean)next.booleanValue()) {
        } else {
            ChannelsKt.cancelConsumed(l$0, i3);
            return $this$first_u24lambda_u242.next();
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("ReceiveChannel is empty.");
        throw noSuchElementException;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object firstOrNull(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, Continuation continuation2) {
        boolean anon;
        Throwable e$iv;
        int i2;
        int cause$iv;
        int iterator;
        Throwable th;
        int next;
        Object l$0;
        Object next2;
        int i;
        Object iterator2;
        int obj8;
        Object obj9;
        anon = continuation2;
        cause$iv = Integer.MIN_VALUE;
        if (continuation2 instanceof ChannelsKt__DeprecatedKt.firstOrNull.1 && label &= cause$iv != 0) {
            anon = continuation2;
            cause$iv = Integer.MIN_VALUE;
            if (label &= cause$iv != 0) {
                anon.label = obj9 -= cause$iv;
            } else {
                anon = new ChannelsKt__DeprecatedKt.firstOrNull.1(continuation2);
            }
        } else {
        }
        obj9 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                l$0 = receiveChannel;
                obj8 = 0;
                iterator = 0;
                iterator2 = l$0.iterator();
                anon.L$0 = l$0;
                anon.L$1 = iterator2;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                i2 = i;
                break;
            case 1:
                obj8 = 0;
                i2 = 0;
                l$0 = anon.L$0;
                ResultKt.throwOnFailure(obj9);
                next2 = obj9;
                iterator2 = l$1;
                iterator = next;
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        if (!(Boolean)next2.booleanValue()) {
        } else {
            next = iterator2.next();
        }
        ChannelsKt.cancelConsumed(l$0, iterator);
        return next;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel flatMap(kotlinx.coroutines.channels.ReceiveChannel $this$flatMap, CoroutineContext context, Function2 transform) {
        ChannelsKt__DeprecatedKt.flatMap.1 anon = new ChannelsKt__DeprecatedKt.flatMap.1($this$flatMap, transform, 0);
        return ProduceKt.produce$default((CoroutineScope)GlobalScope.INSTANCE, context, 0, 0, ChannelsKt.consumes($this$flatMap), (Function2)anon, 6, 0);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel flatMap$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        kotlinx.coroutines.CoroutineDispatcher obj1;
        if (i4 &= 1 != 0) {
            obj1 = Dispatchers.getUnconfined();
        }
        return ChannelsKt.flatMap(receiveChannel, obj1, function23);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object indexOf(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, Object object2, Continuation continuation3) {
        Object obj2;
        boolean anon;
        int i5;
        Object $result;
        int $i$f$consume;
        int $result2;
        Object $i$f$consumeEach;
        int i;
        int $i$f$consumeEach2;
        int $i$f$consume3;
        int $i$f$consume2;
        int $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
        int i2;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        Object obj3;
        Object $this$consume$iv$iv;
        Object $this$consume$iv$iv2;
        Object index;
        Object index2;
        Object element2;
        Object obj8;
        int element;
        Object cause$iv$iv;
        kotlinx.coroutines.channels.ChannelIterator iterator;
        Object obj;
        int i4;
        boolean equal;
        int i3;
        obj2 = continuation3;
        anon = obj2;
        $i$f$consume = Integer.MIN_VALUE;
        if (obj2 instanceof ChannelsKt__DeprecatedKt.indexOf.1 && label2 &= $i$f$consume != 0) {
            anon = obj2;
            $i$f$consume = Integer.MIN_VALUE;
            if (label2 &= $i$f$consume != 0) {
                anon.label = label -= $i$f$consume;
            } else {
                anon = new ChannelsKt__DeprecatedKt.indexOf.1(obj2);
            }
        } else {
        }
        $result = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final int i9 = 1;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result);
                Ref.IntRef intRef = new Ref.IntRef();
                element = 0;
                $this$consume$iv$iv2 = intRef;
                $i$f$consume2 = i13;
                index2 = obj5;
                $i$f$consumeEach2 = $this$consumeEach$iv;
                $result2 = i12;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2 = iterator;
                break;
            case 1:
                ResultKt.throwOnFailure($result);
                iterator = i14;
                cause$iv$iv = l$0;
                element2 = l$1;
                index = l$2;
                $this$consume$iv$iv = l$3;
                i2 = i11;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = i10;
                $i$f$consume3 = i8;
                $i$f$consumeEach = $result;
                i4 = 0;
                ChannelsKt.cancelConsumed(index, iterator);
                return Boxing.boxInt(element2.element);
                element2.element = element4 += i9;
                $result = $i$f$consumeEach;
                $result2 = $i$f$consume3;
                $i$f$consumeEach2 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
                $i$f$consume2 = i2;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2 = $this$consume$iv$iv;
                obj3 = index;
                $this$consume$iv$iv2 = element2;
                index2 = cause$iv$iv;
                element = iterator;
                Unit iNSTANCE = Unit.INSTANCE;
                ChannelsKt.cancelConsumed(index, iterator);
                return Boxing.boxInt(-1);
            default:
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw illegalStateException;
        }
        anon.L$0 = index2;
        anon.L$1 = $this$consume$iv$iv2;
        anon.L$2 = obj3;
        anon.L$3 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
        anon.label = i9;
        Object next2 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2.hasNext(anon);
        if (next2 == cOROUTINE_SUSPENDED) {
            return cOROUTINE_SUSPENDED;
        } else {
            $i$f$consumeEach = $result;
            $result = next2;
            iterator = element;
            cause$iv$iv = index2;
            element2 = $this$consume$iv$iv2;
            index = obj3;
            $this$consume$iv$iv = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
            i2 = $i$f$consume2;
            $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = $i$f$consumeEach2;
            $i$f$consume3 = i3;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object last(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, Continuation continuation2) {
        boolean $result;
        Object $continuation;
        Throwable e$iv;
        Object $continuation3;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.last.1 anon;
        int th;
        Object $i$a$ConsumeChannelsKt__DeprecatedKt$last$2;
        int i3;
        Object $i$a$ConsumeChannelsKt__DeprecatedKt$last$23;
        int iterator;
        Object $i$a$ConsumeChannelsKt__DeprecatedKt$last$22;
        int last;
        Object iterator4;
        Object iterator2;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        Object iterator3;
        Object $this$consume$iv2;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel3;
        int $this$consume$iv;
        Object cause$iv;
        int i;
        int i2;
        int obj9;
        Object obj10;
        $result = continuation2;
        th = Integer.MIN_VALUE;
        if (continuation2 instanceof ChannelsKt__DeprecatedKt.last.1 && label &= th != 0) {
            $result = continuation2;
            th = Integer.MIN_VALUE;
            if (label &= th != 0) {
                $result.label = obj10 -= th;
            } else {
                $result = new ChannelsKt__DeprecatedKt.last.1(continuation2);
            }
        } else {
        }
        obj10 = $result.result;
        $continuation3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                iterator3 = receiveChannel;
                obj9 = 0;
                $this$consume$iv = 0;
                iterator = 0;
                iterator4 = iterator3.iterator();
                $result.L$0 = iterator3;
                $result.L$1 = iterator4;
                $result.label = 1;
                return $continuation3;
            case 1:
                obj9 = 0;
                $this$consume$iv = 0;
                iterator3 = l$0;
                ResultKt.throwOnFailure(obj10);
                iterator4 = l$1;
                iterator = i6;
                $i$a$ConsumeChannelsKt__DeprecatedKt$last$2 = obj10;
                break;
            case 2:
                obj9 = 0;
                ResultKt.throwOnFailure(obj10);
                i = i7;
                cause$iv = l$02;
                $this$consume$iv2 = l$12;
                iterator2 = l$2;
                last = i4;
                $i$a$ConsumeChannelsKt__DeprecatedKt$last$23 = $continuation3;
                anon = $result;
                $continuation = obj10;
                $result.L$0 = iterator3;
                $result.L$1 = iterator4;
                $result.L$2 = $i$a$ConsumeChannelsKt__DeprecatedKt$last$22;
                $result.label = 2;
                Object next2 = iterator4.hasNext($result);
                return $continuation3;
                $continuation = obj10;
                obj10 = next2;
                i = $this$consume$iv;
                cause$iv = iterator3;
                $this$consume$iv2 = iterator4;
                iterator2 = $i$a$ConsumeChannelsKt__DeprecatedKt$last$22;
                last = i3;
                $i$a$ConsumeChannelsKt__DeprecatedKt$last$23 = $continuation3;
                anon = i2;
                $i$a$ConsumeChannelsKt__DeprecatedKt$last$22 = obj10;
                obj10 = $continuation;
                $result = anon;
                $continuation3 = $i$a$ConsumeChannelsKt__DeprecatedKt$last$23;
                i3 = last2;
                iterator4 = $this$consume$iv2;
                iterator3 = cause$iv;
                $this$consume$iv = i;
                ChannelsKt.cancelConsumed(cause$iv, i);
                return iterator2;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        if (!(Boolean)$i$a$ConsumeChannelsKt__DeprecatedKt$last$2.booleanValue()) {
        } else {
            $i$a$ConsumeChannelsKt__DeprecatedKt$last$22 = next;
            i3 = i2;
        }
        NoSuchElementException $continuation4 = new NoSuchElementException("ReceiveChannel is empty.");
        throw $continuation4;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object lastIndexOf(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, Object object2, Continuation continuation3) {
        Object obj;
        boolean anon;
        int i2;
        Object $result2;
        Object it;
        int $i$f$consume2;
        int $result;
        Object $i$f$consumeEach;
        int i3;
        int $i$f$consumeEach4;
        int $i$f$consume3;
        int $i$f$consume;
        int $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
        int i4;
        kotlinx.coroutines.channels.ReceiveChannel $i$f$consumeEach2;
        int $i$f$consumeEach3;
        Object cause$iv$iv;
        kotlinx.coroutines.channels.ReceiveChannel cause$iv$iv3;
        Object cause$iv$iv2;
        int $this$consume$iv$iv2;
        Object $this$consume$iv$iv;
        Object index2;
        Object index;
        Object lastIndex;
        Object lastIndex2;
        Object element;
        Object iterator;
        int i;
        boolean equal;
        int i5;
        obj = continuation3;
        anon = obj;
        $i$f$consume2 = Integer.MIN_VALUE;
        if (obj instanceof ChannelsKt__DeprecatedKt.lastIndexOf.1 && label2 &= $i$f$consume2 != 0) {
            anon = obj;
            $i$f$consume2 = Integer.MIN_VALUE;
            if (label2 &= $i$f$consume2 != 0) {
                anon.label = label -= $i$f$consume2;
            } else {
                anon = new ChannelsKt__DeprecatedKt.lastIndexOf.1(obj);
            }
        } else {
        }
        $result2 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final int i8 = 1;
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure($result2);
                Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = -1;
                Ref.IntRef intRef2 = new Ref.IntRef();
                index = intRef;
                $i$f$consume = i15;
                lastIndex2 = obj3;
                $i$f$consumeEach4 = $this$consumeEach$iv;
                $result = i13;
                $i$f$consumeEach3 = i14;
                $this$consume$iv$iv = intRef2;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = iterator;
                break;
            case 1:
                ResultKt.throwOnFailure($result2);
                iterator = l$0;
                element = l$1;
                lastIndex = l$2;
                index2 = l$3;
                $this$consume$iv$iv2 = i12;
                cause$iv$iv = l$4;
                i4 = i10;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2 = i9;
                $i$f$consume3 = i7;
                $i$f$consumeEach = $result2;
                i = 0;
                element.element = lastIndex.element;
                lastIndex.element = element3 += i8;
                $result2 = $i$f$consumeEach;
                $result = $i$f$consume3;
                $i$f$consumeEach4 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
                $i$f$consume = i4;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = cause$iv$iv;
                $i$f$consumeEach3 = $this$consume$iv$iv2;
                cause$iv$iv2 = index2;
                $this$consume$iv$iv = lastIndex;
                index = element;
                lastIndex2 = iterator;
                Unit iNSTANCE = Unit.INSTANCE;
                ChannelsKt.cancelConsumed(index2, $this$consume$iv$iv2);
                return Boxing.boxInt(element.element);
            default:
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw illegalStateException;
        }
        anon.L$0 = lastIndex2;
        anon.L$1 = index;
        anon.L$2 = $this$consume$iv$iv;
        anon.L$3 = cause$iv$iv2;
        anon.L$4 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
        anon.label = i8;
        Object next = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv.hasNext(anon);
        if (next == cOROUTINE_SUSPENDED) {
            return cOROUTINE_SUSPENDED;
        } else {
            $i$f$consumeEach = $result2;
            $result2 = next;
            iterator = lastIndex2;
            element = index;
            lastIndex = $this$consume$iv$iv;
            index2 = cause$iv$iv2;
            $this$consume$iv$iv2 = $i$f$consumeEach3;
            cause$iv$iv = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
            i4 = $i$f$consume;
            $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2 = $i$f$consumeEach4;
            $i$f$consume3 = i5;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object lastOrNull(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, Continuation continuation2) {
        boolean $result;
        Object $continuation2;
        Object obj;
        Object $continuation;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.lastOrNull.1 anon;
        int i2;
        int $i$f$consume2;
        Object $i$f$consume3;
        Throwable th;
        int $i$f$consume;
        int cause$iv;
        Object $this$lastOrNull_u24lambda_u247;
        Object iterator;
        int last;
        int i;
        kotlinx.coroutines.channels.ChannelIterator $i$a$ConsumeChannelsKt__DeprecatedKt$lastOrNull$2;
        Object iterator3;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        Object iterator2;
        Object $this$consume$iv;
        Object next;
        boolean booleanValue;
        kotlinx.coroutines.channels.ChannelIterator it;
        int obj9;
        Object obj10;
        $result = continuation2;
        i2 = Integer.MIN_VALUE;
        if (continuation2 instanceof ChannelsKt__DeprecatedKt.lastOrNull.1 && label &= i2 != 0) {
            $result = continuation2;
            i2 = Integer.MIN_VALUE;
            if (label &= i2 != 0) {
                $result.label = obj10 -= i2;
            } else {
                $result = new ChannelsKt__DeprecatedKt.lastOrNull.1(continuation2);
            }
        } else {
        }
        obj10 = $result.result;
        $continuation = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = 0;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                iterator2 = receiveChannel;
                $i$f$consume2 = 0;
                obj9 = 0;
                i = 0;
                $this$lastOrNull_u24lambda_u247 = iterator4;
                $result.L$0 = iterator2;
                $result.L$1 = $this$lastOrNull_u24lambda_u247;
                $result.label = 1;
                return $continuation;
            case 1:
                $i$f$consume2 = 0;
                $this$lastOrNull_u24lambda_u247 = $result.L$1;
                ResultKt.throwOnFailure(obj10);
                next = obj10;
                iterator2 = l$0;
                i = obj9;
                obj9 = i4;
                break;
            case 2:
                obj9 = 0;
                ResultKt.throwOnFailure(obj10);
                booleanValue = l$02;
                $this$consume$iv = l$1;
                iterator3 = l$2;
                last = i4;
                cause$iv = i3;
                $i$f$consume3 = $continuation;
                anon = $result;
                $continuation2 = obj10;
                $result.L$0 = iterator2;
                $result.L$1 = $i$a$ConsumeChannelsKt__DeprecatedKt$lastOrNull$2;
                $result.L$2 = iterator;
                $result.label = 2;
                Object next2 = $i$a$ConsumeChannelsKt__DeprecatedKt$lastOrNull$2.hasNext($result);
                return $continuation;
                $continuation2 = obj10;
                obj10 = next2;
                booleanValue = iterator2;
                $this$consume$iv = $i$a$ConsumeChannelsKt__DeprecatedKt$lastOrNull$2;
                iterator3 = iterator;
                last = $i$f$consume;
                cause$iv = $i$f$consume2;
                $i$f$consume3 = $continuation;
                anon = it;
                iterator = obj10;
                obj10 = $continuation2;
                $result = anon;
                $continuation = $i$f$consume3;
                $i$f$consume2 = cause$iv;
                $i$f$consume = last2;
                $i$a$ConsumeChannelsKt__DeprecatedKt$lastOrNull$2 = $this$consume$iv;
                iterator2 = booleanValue;
                ChannelsKt.cancelConsumed(booleanValue, last);
                return iterator3;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        if (!(Boolean)next.booleanValue()) {
            ChannelsKt.cancelConsumed(iterator2, obj9);
            return i4;
        }
        $i$f$consume = obj9;
        iterator = obj9;
        obj9 = i;
        $i$a$ConsumeChannelsKt__DeprecatedKt$lastOrNull$2 = it;
    }

    public static final <E, R> kotlinx.coroutines.channels.ReceiveChannel<R> map(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$map, CoroutineContext context, Function2<? super E, ? super Continuation<? super R>, ? extends Object> transform) {
        ChannelsKt__DeprecatedKt.map.1 anon = new ChannelsKt__DeprecatedKt.map.1($this$map, transform, 0);
        return ProduceKt.produce$default((CoroutineScope)GlobalScope.INSTANCE, context, 0, 0, ChannelsKt.consumes($this$map), (Function2)anon, 6, 0);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel map$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        kotlinx.coroutines.CoroutineDispatcher obj1;
        if (i4 &= 1 != 0) {
            obj1 = Dispatchers.getUnconfined();
        }
        return ChannelsKt.map(receiveChannel, obj1, function23);
    }

    public static final <E, R> kotlinx.coroutines.channels.ReceiveChannel<R> mapIndexed(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$mapIndexed, CoroutineContext context, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> transform) {
        ChannelsKt__DeprecatedKt.mapIndexed.1 anon = new ChannelsKt__DeprecatedKt.mapIndexed.1($this$mapIndexed, transform, 0);
        return ProduceKt.produce$default((CoroutineScope)GlobalScope.INSTANCE, context, 0, 0, ChannelsKt.consumes($this$mapIndexed), (Function2)anon, 6, 0);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel mapIndexed$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function3 function33, int i4, Object object5) {
        kotlinx.coroutines.CoroutineDispatcher obj1;
        if (i4 &= 1 != 0) {
            obj1 = Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexed(receiveChannel, obj1, function33);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel mapIndexedNotNull(kotlinx.coroutines.channels.ReceiveChannel $this$mapIndexedNotNull, CoroutineContext context, Function3 transform) {
        return ChannelsKt.filterNotNull(ChannelsKt.mapIndexed($this$mapIndexedNotNull, context, transform));
    }

    public static kotlinx.coroutines.channels.ReceiveChannel mapIndexedNotNull$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function3 function33, int i4, Object object5) {
        kotlinx.coroutines.CoroutineDispatcher obj1;
        if (i4 &= 1 != 0) {
            obj1 = Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexedNotNull(receiveChannel, obj1, function33);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel mapNotNull(kotlinx.coroutines.channels.ReceiveChannel $this$mapNotNull, CoroutineContext context, Function2 transform) {
        return ChannelsKt.filterNotNull(ChannelsKt.map($this$mapNotNull, context, transform));
    }

    public static kotlinx.coroutines.channels.ReceiveChannel mapNotNull$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        kotlinx.coroutines.CoroutineDispatcher obj1;
        if (i4 &= 1 != 0) {
            obj1 = Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapNotNull(receiveChannel, obj1, function23);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object maxWith(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, Comparator comparator2, Continuation continuation3) {
        boolean $result;
        Object $continuation;
        Object obj2;
        Object $continuation3;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.maxWith.1 anon;
        int i;
        int iterator3;
        Object next;
        Object max;
        Throwable th2;
        int max2;
        Object cause$iv;
        Object next2;
        kotlinx.coroutines.channels.ChannelIterator it;
        int iterator;
        Throwable th;
        Object comparator;
        Object $this$consume$iv;
        Object $i$a$ConsumeChannelsKt__DeprecatedKt$maxWith$2;
        Object comparator3;
        Object iterator2;
        int compare;
        Object obj;
        int obj10;
        int obj11;
        Object obj12;
        $result = continuation3;
        i = Integer.MIN_VALUE;
        if (continuation3 instanceof ChannelsKt__DeprecatedKt.maxWith.1 && label &= i != 0) {
            $result = continuation3;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                $result.label = obj12 -= i;
            } else {
                $result = new ChannelsKt__DeprecatedKt.maxWith.1(continuation3);
            }
        } else {
        }
        obj12 = $result.result;
        $continuation3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = 0;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj12);
                Object obj4 = comparator2;
                obj11 = 0;
                iterator3 = 0;
                iterator2 = receiveChannel.iterator();
                $result.L$0 = obj4;
                $result.L$1 = receiveChannel;
                $result.L$2 = iterator2;
                $result.label = 1;
                return $continuation3;
                comparator = receiveChannel;
                obj10 = i4;
                $i$a$ConsumeChannelsKt__DeprecatedKt$maxWith$2 = obj;
                break;
            case 1:
                obj11 = 0;
                obj10 = 0;
                ResultKt.throwOnFailure(obj12);
                iterator2 = l$2;
                iterator3 = i2;
                $i$a$ConsumeChannelsKt__DeprecatedKt$maxWith$2 = l$0;
                comparator = l$1;
                next2 = obj12;
                break;
            case 2:
                obj10 = 0;
                obj11 = 0;
                ResultKt.throwOnFailure(obj12);
                iterator2 = l$02;
                comparator3 = l$12;
                $this$consume$iv = l$22;
                iterator = i2;
                cause$iv = l$3;
                max = $continuation3;
                anon = $result;
                $continuation = obj12;
                $result.L$0 = $i$a$ConsumeChannelsKt__DeprecatedKt$maxWith$2;
                $result.L$1 = comparator;
                $result.L$2 = it;
                $result.L$3 = next;
                $result.label = 2;
                Object next3 = it.hasNext($result);
                return $continuation3;
                $continuation = obj12;
                obj12 = next3;
                iterator2 = $i$a$ConsumeChannelsKt__DeprecatedKt$maxWith$2;
                comparator3 = comparator;
                $this$consume$iv = it;
                iterator = max2;
                cause$iv = next;
                max = $continuation3;
                anon = obj;
                obj12 = $this$consume$iv.next();
                max2 = iterator;
                next = obj12;
                obj12 = $continuation;
                $result = anon;
                $continuation3 = obj3;
                it = $this$consume$iv;
                comparator = comparator3;
                $i$a$ConsumeChannelsKt__DeprecatedKt$maxWith$2 = iterator2;
                obj12 = $continuation;
                $result = anon;
                $continuation3 = max;
                next = cause$iv;
                max2 = iterator;
                it = $this$consume$iv;
                comparator = comparator3;
                $i$a$ConsumeChannelsKt__DeprecatedKt$maxWith$2 = iterator2;
                ChannelsKt.cancelConsumed(comparator3, iterator);
                return cause$iv;
            default:
                obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj10;
        }
        if (!(Boolean)next2.booleanValue()) {
            ChannelsKt.cancelConsumed(comparator, iterator3);
            return i2;
        }
        max2 = iterator3;
        next = iterator2.next();
        it = iterator2;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object minWith(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, Comparator comparator2, Continuation continuation3) {
        boolean $result;
        Object $continuation3;
        Object obj;
        Object $continuation;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.minWith.1 anon;
        int i;
        int iterator3;
        Object next;
        Object min2;
        Throwable th;
        int min;
        Object cause$iv;
        Object next2;
        kotlinx.coroutines.channels.ChannelIterator it;
        int iterator;
        Throwable th2;
        Object comparator;
        Object $this$consume$iv;
        Object $i$a$ConsumeChannelsKt__DeprecatedKt$minWith$2;
        Object comparator3;
        Object iterator2;
        int compare;
        Object obj2;
        int obj10;
        int obj11;
        Object obj12;
        $result = continuation3;
        i = Integer.MIN_VALUE;
        if (continuation3 instanceof ChannelsKt__DeprecatedKt.minWith.1 && label &= i != 0) {
            $result = continuation3;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                $result.label = obj12 -= i;
            } else {
                $result = new ChannelsKt__DeprecatedKt.minWith.1(continuation3);
            }
        } else {
        }
        obj12 = $result.result;
        $continuation = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = 0;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj12);
                Object obj4 = comparator2;
                obj11 = 0;
                iterator3 = 0;
                iterator2 = receiveChannel.iterator();
                $result.L$0 = obj4;
                $result.L$1 = receiveChannel;
                $result.L$2 = iterator2;
                $result.label = 1;
                return $continuation;
                comparator = receiveChannel;
                obj10 = i4;
                $i$a$ConsumeChannelsKt__DeprecatedKt$minWith$2 = obj2;
                break;
            case 1:
                obj11 = 0;
                obj10 = 0;
                ResultKt.throwOnFailure(obj12);
                iterator2 = l$2;
                iterator3 = i2;
                $i$a$ConsumeChannelsKt__DeprecatedKt$minWith$2 = l$0;
                comparator = l$1;
                next2 = obj12;
                break;
            case 2:
                obj10 = 0;
                obj11 = 0;
                ResultKt.throwOnFailure(obj12);
                iterator2 = l$02;
                comparator3 = l$12;
                $this$consume$iv = l$22;
                iterator = i2;
                cause$iv = l$3;
                min2 = $continuation;
                anon = $result;
                $continuation3 = obj12;
                $result.L$0 = $i$a$ConsumeChannelsKt__DeprecatedKt$minWith$2;
                $result.L$1 = comparator;
                $result.L$2 = it;
                $result.L$3 = next;
                $result.label = 2;
                Object next3 = it.hasNext($result);
                return $continuation;
                $continuation3 = obj12;
                obj12 = next3;
                iterator2 = $i$a$ConsumeChannelsKt__DeprecatedKt$minWith$2;
                comparator3 = comparator;
                $this$consume$iv = it;
                iterator = min;
                cause$iv = next;
                min2 = $continuation;
                anon = obj2;
                obj12 = $this$consume$iv.next();
                min = iterator;
                next = obj12;
                obj12 = $continuation3;
                $result = anon;
                $continuation = obj3;
                it = $this$consume$iv;
                comparator = comparator3;
                $i$a$ConsumeChannelsKt__DeprecatedKt$minWith$2 = iterator2;
                obj12 = $continuation3;
                $result = anon;
                $continuation = min2;
                next = cause$iv;
                min = iterator;
                it = $this$consume$iv;
                comparator = comparator3;
                $i$a$ConsumeChannelsKt__DeprecatedKt$minWith$2 = iterator2;
                ChannelsKt.cancelConsumed(comparator3, iterator);
                return cause$iv;
            default:
                obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj10;
        }
        if (!(Boolean)next2.booleanValue()) {
            ChannelsKt.cancelConsumed(comparator, iterator3);
            return i2;
        }
        min = iterator3;
        next = iterator2.next();
        it = iterator2;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object none(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, Continuation continuation2) {
        boolean anon;
        Throwable e$iv;
        int i3;
        int i;
        Object l$0;
        int i5;
        int i4;
        Object obj;
        int i2;
        Object next;
        int obj8;
        Object obj9;
        anon = continuation2;
        i = Integer.MIN_VALUE;
        if (continuation2 instanceof ChannelsKt__DeprecatedKt.none.1 && label &= i != 0) {
            anon = continuation2;
            i = Integer.MIN_VALUE;
            if (label &= i != 0) {
                anon.label = obj9 -= i;
            } else {
                anon = new ChannelsKt__DeprecatedKt.none.1(continuation2);
            }
        } else {
        }
        obj9 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj9);
                l$0 = receiveChannel;
                obj8 = 0;
                i4 = 0;
                anon.L$0 = l$0;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                i3 = i2;
                break;
            case 1:
                obj8 = 0;
                i3 = 0;
                l$0 = anon.L$0;
                i4 = 0;
                ResultKt.throwOnFailure(obj9);
                next = obj9;
                break;
            default:
                obj8 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj8;
        }
        if (!(Boolean)next.booleanValue()) {
        } else {
            i5 = 0;
        }
        ChannelsKt.cancelConsumed(l$0, i4);
        return Boxing.boxBoolean(i5);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Left for binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel requireNoNulls(kotlinx.coroutines.channels.ReceiveChannel $this$requireNoNulls) {
        final int i = 0;
        ChannelsKt__DeprecatedKt.requireNoNulls.1 anon = new ChannelsKt__DeprecatedKt.requireNoNulls.1($this$requireNoNulls, i);
        return ChannelsKt.map$default($this$requireNoNulls, i, (Function2)anon, 1, i);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object single(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, Continuation continuation2) {
        boolean anon;
        Throwable e$iv;
        int i2;
        int th;
        Object $i$a$ConsumeChannelsKt__DeprecatedKt$single$22;
        int i3;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        Object single;
        Object $this$consume$iv;
        int i;
        Object $i$a$ConsumeChannelsKt__DeprecatedKt$single$2;
        Object iterator;
        Object next;
        Object obj;
        int obj9;
        Object obj10;
        anon = continuation2;
        th = Integer.MIN_VALUE;
        if (continuation2 instanceof ChannelsKt__DeprecatedKt.single.1 && label &= th != 0) {
            anon = continuation2;
            th = Integer.MIN_VALUE;
            if (label &= th != 0) {
                anon.label = obj10 -= th;
            } else {
                anon = new ChannelsKt__DeprecatedKt.single.1(continuation2);
            }
        } else {
        }
        obj10 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj10);
                Object obj3 = receiveChannel;
                obj9 = 0;
                i = 0;
                iterator = obj3.iterator();
                anon.L$0 = obj3;
                anon.L$1 = iterator;
                anon.label = 1;
                Object next2 = iterator.hasNext(anon);
                return cOROUTINE_SUSPENDED;
                $this$consume$iv = next2;
                i3 = i5;
                $i$a$ConsumeChannelsKt__DeprecatedKt$single$2 = obj;
                break;
            case 1:
                obj9 = 0;
                i3 = 0;
                i = 0;
                $i$a$ConsumeChannelsKt__DeprecatedKt$single$2 = anon.L$0;
                ResultKt.throwOnFailure(obj10);
                iterator = l$1;
                $this$consume$iv = obj10;
                break;
            case 2:
                obj9 = 0;
                i2 = 0;
                $i$a$ConsumeChannelsKt__DeprecatedKt$single$22 = anon.L$1;
                single = anon.L$0;
                i = 0;
                ResultKt.throwOnFailure(obj10);
                next = obj10;
                ChannelsKt.cancelConsumed(single, i);
                return $i$a$ConsumeChannelsKt__DeprecatedKt$single$22;
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ReceiveChannel has more than one element.");
                throw illegalArgumentException;
            default:
                obj9 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj9;
        }
        if (!(Boolean)$this$consume$iv.booleanValue()) {
        } else {
            Object next3 = iterator.next();
            anon.L$0 = $i$a$ConsumeChannelsKt__DeprecatedKt$single$2;
            anon.L$1 = next3;
            anon.label = 2;
            if (iterator.hasNext(anon) == cOROUTINE_SUSPENDED) {
                return cOROUTINE_SUSPENDED;
            }
            i2 = i3;
            $i$a$ConsumeChannelsKt__DeprecatedKt$single$22 = next3;
            single = $i$a$ConsumeChannelsKt__DeprecatedKt$single$2;
        }
        NoSuchElementException $i$a$ConsumeChannelsKt__DeprecatedKt$single$23 = new NoSuchElementException("ReceiveChannel is empty.");
        throw $i$a$ConsumeChannelsKt__DeprecatedKt$single$23;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object singleOrNull(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, Continuation continuation2) {
        boolean anon;
        Throwable th2;
        int i;
        int cause$iv;
        Object $i$f$consume;
        int cause$iv2;
        Throwable th3;
        kotlinx.coroutines.channels.ReceiveChannel receiveChannel2;
        Object cause$iv3;
        int $this$consume$iv;
        int single;
        Object next;
        Object $i$a$ConsumeChannelsKt__DeprecatedKt$singleOrNull$2;
        Object iterator;
        Object next2;
        Throwable th;
        int obj10;
        Object obj11;
        anon = continuation2;
        cause$iv = Integer.MIN_VALUE;
        if (continuation2 instanceof ChannelsKt__DeprecatedKt.singleOrNull.1 && label &= cause$iv != 0) {
            anon = continuation2;
            cause$iv = Integer.MIN_VALUE;
            if (label &= cause$iv != 0) {
                anon.label = obj11 -= cause$iv;
            } else {
                anon = new ChannelsKt__DeprecatedKt.singleOrNull.1(continuation2);
            }
        } else {
        }
        obj11 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        final int i4 = 0;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj11);
                Throwable th4 = receiveChannel;
                iterator = th4.iterator();
                anon.L$0 = th4;
                anon.L$1 = iterator;
                anon.label = 1;
                return cOROUTINE_SUSPENDED;
                cause$iv2 = obj10;
                obj10 = i6;
                $i$a$ConsumeChannelsKt__DeprecatedKt$singleOrNull$2 = th4;
                $this$consume$iv = th;
                break;
            case 1:
                ResultKt.throwOnFailure(obj11);
                cause$iv2 = obj10;
                obj10 = i7;
                iterator = l$1;
                $i$a$ConsumeChannelsKt__DeprecatedKt$singleOrNull$2 = l$0;
                next = obj11;
                $this$consume$iv = i4;
                break;
            case 2:
                obj10 = 0;
                i = 0;
                $i$f$consume = anon.L$1;
                cause$iv3 = anon.L$0;
                ResultKt.throwOnFailure(obj11);
                next2 = obj11;
                single = i4;
                ChannelsKt.cancelConsumed(cause$iv3, single);
                return i4;
                ChannelsKt.cancelConsumed(cause$iv3, single);
                return $i$f$consume;
            default:
                obj10 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj10;
        }
        if (!(Boolean)next.booleanValue()) {
            ChannelsKt.cancelConsumed($i$a$ConsumeChannelsKt__DeprecatedKt$singleOrNull$2, $this$consume$iv);
            return i4;
        }
        Object next3 = iterator.next();
        anon.L$0 = $i$a$ConsumeChannelsKt__DeprecatedKt$singleOrNull$2;
        anon.L$1 = next3;
        anon.label = 2;
        if (iterator.hasNext(anon) == cOROUTINE_SUSPENDED) {
            return cOROUTINE_SUSPENDED;
        }
        i = cause$iv2;
        $i$f$consume = next3;
        single = $this$consume$iv;
        cause$iv3 = $i$a$ConsumeChannelsKt__DeprecatedKt$singleOrNull$2;
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel take(kotlinx.coroutines.channels.ReceiveChannel $this$take, int n, CoroutineContext context) {
        ChannelsKt__DeprecatedKt.take.1 anon = new ChannelsKt__DeprecatedKt.take.1(n, $this$take, 0);
        return ProduceKt.produce$default((CoroutineScope)GlobalScope.INSTANCE, context, 0, 0, ChannelsKt.consumes($this$take), (Function2)anon, 6, 0);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel take$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, int i2, CoroutineContext coroutineContext3, int i4, Object object5) {
        kotlinx.coroutines.CoroutineDispatcher obj2;
        if (i4 &= 2 != 0) {
            obj2 = Dispatchers.getUnconfined();
        }
        return ChannelsKt.take(receiveChannel, i2, obj2);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel takeWhile(kotlinx.coroutines.channels.ReceiveChannel $this$takeWhile, CoroutineContext context, Function2 predicate) {
        ChannelsKt__DeprecatedKt.takeWhile.1 anon = new ChannelsKt__DeprecatedKt.takeWhile.1($this$takeWhile, predicate, 0);
        return ProduceKt.produce$default((CoroutineScope)GlobalScope.INSTANCE, context, 0, 0, ChannelsKt.consumes($this$takeWhile), (Function2)anon, 6, 0);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel takeWhile$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, Function2 function23, int i4, Object object5) {
        kotlinx.coroutines.CoroutineDispatcher obj1;
        if (i4 &= 1 != 0) {
            obj1 = Dispatchers.getUnconfined();
        }
        return ChannelsKt.takeWhile(receiveChannel, obj1, function23);
    }

    public static final <E, C extends kotlinx.coroutines.channels.SendChannel<? super E>> Object toChannel(kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, C c2, Continuation<? super C> continuation3) {
        boolean anon;
        Object $continuation;
        Throwable e$iv$iv;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.toChannel.1 anon2;
        int $i$f$consumeEach;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
        int i2;
        Object l$2;
        int destination;
        int i3;
        Object l$1;
        Object destination2;
        Object obj;
        int i;
        Object send;
        Throwable th;
        int obj11;
        Object obj12;
        Object obj13;
        anon = continuation3;
        $i$f$consumeEach = Integer.MIN_VALUE;
        if (continuation3 instanceof ChannelsKt__DeprecatedKt.toChannel.1 && label &= $i$f$consumeEach != 0) {
            anon = continuation3;
            $i$f$consumeEach = Integer.MIN_VALUE;
            if (label &= $i$f$consumeEach != 0) {
                anon.label = obj13 -= $i$f$consumeEach;
            } else {
                anon = new ChannelsKt__DeprecatedKt.toChannel.1(continuation3);
            }
        } else {
        }
        obj13 = anon.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj13);
                i3 = 0;
                destination = 0;
                destination2 = receiveChannel.iterator();
                obj13 = obj11;
                obj11 = i5;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = cOROUTINE_SUSPENDED;
                anon2 = anon;
                $continuation = th;
                break;
            case 1:
                obj11 = 0;
                obj12 = 0;
                l$2 = anon.L$2;
                i3 = 0;
                l$1 = l$12;
                ResultKt.throwOnFailure(obj13);
                obj = $this$consume$iv$iv;
                destination = i6;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = cOROUTINE_SUSPENDED;
                anon2 = anon;
                $continuation = obj13;
                anon2.L$0 = obj;
                anon2.L$1 = l$1;
                anon2.L$2 = l$2;
                anon2.label = 2;
                return $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
                obj13 = obj12;
                obj12 = obj;
                destination2 = l$2;
                i2 = i;
                obj13 = Unit.INSTANCE;
                ChannelsKt.cancelConsumed(l$1, i3);
                return obj;
            case 2:
                obj11 = 0;
                i2 = 0;
                i3 = 0;
                l$1 = anon.L$1;
                ResultKt.throwOnFailure(obj13);
                obj13 = obj12;
                obj12 = l$0;
                destination2 = l$22;
                destination = i4;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = cOROUTINE_SUSPENDED;
                anon2 = anon;
                $continuation = th;
                break;
            default:
                obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj11;
        }
        anon2.L$0 = obj12;
        anon2.L$1 = l$1;
        anon2.L$2 = destination2;
        anon2.label = 1;
        Object next = destination2.hasNext(anon2);
        if (next == $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv) {
            return $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
        } else {
            obj = obj12;
            obj12 = obj13;
            obj13 = next;
            l$2 = th;
        }
    }

    public static final <E, C extends Collection<? super E>> Object toCollection(kotlinx.coroutines.channels.ReceiveChannel<? extends E> receiveChannel, C c2, Continuation<? super C> continuation3) {
        boolean $result;
        Object $continuation2;
        Throwable e$iv$iv;
        Object $continuation;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.toCollection.1 collection2;
        int $i$f$consumeEach2;
        int $i$f$consumeEach;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
        int i2;
        Throwable th;
        int i;
        Object cause$iv$iv3;
        Throwable cause$iv$iv;
        Object cause$iv$iv2;
        int $this$consume$iv$iv2;
        Object $this$consume$iv$iv;
        Object destination;
        Object iterator;
        Object obj;
        int i3;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.toCollection.1 collection;
        int obj11;
        int obj12;
        Object obj13;
        $result = continuation3;
        $i$f$consumeEach2 = Integer.MIN_VALUE;
        if (continuation3 instanceof ChannelsKt__DeprecatedKt.toCollection.1 && label &= $i$f$consumeEach2 != 0) {
            $result = continuation3;
            $i$f$consumeEach2 = Integer.MIN_VALUE;
            if (label &= $i$f$consumeEach2 != 0) {
                $result.label = obj13 -= $i$f$consumeEach2;
            } else {
                $result = new ChannelsKt__DeprecatedKt.toCollection.1(continuation3);
            }
        } else {
        }
        obj13 = $result.result;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj13);
                i = 0;
                obj12 = obj11;
                obj11 = i5;
                $i$f$consumeEach = i7;
                $this$consume$iv$iv = $this$consumeEach_u24lambda_u241$iv;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2 = iterator;
                break;
            case 1:
                obj11 = 0;
                obj12 = 0;
                ResultKt.throwOnFailure(obj13);
                iterator = l$0;
                destination = l$1;
                $this$consume$iv$iv2 = i6;
                cause$iv$iv3 = l$2;
                i2 = i4;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = $continuation;
                collection2 = $result;
                $continuation2 = obj13;
                i3 = 0;
                iterator.add(cause$iv$iv3.next());
                obj13 = $continuation2;
                $result = collection2;
                $continuation = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
                $i$f$consumeEach = i2;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2 = cause$iv$iv3;
                i = $this$consume$iv$iv2;
                cause$iv$iv2 = destination;
                $this$consume$iv$iv = iterator;
                obj13 = Unit.INSTANCE;
                ChannelsKt.cancelConsumed(destination, $this$consume$iv$iv2);
                return iterator;
            default:
                obj11 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj11;
        }
        $result.L$0 = $this$consume$iv$iv;
        $result.L$1 = cause$iv$iv2;
        $result.L$2 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
        $result.label = 1;
        Object next = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2.hasNext($result);
        if (next == $continuation) {
            return $continuation;
        } else {
            $continuation2 = obj13;
            obj13 = next;
            iterator = $this$consume$iv$iv;
            destination = cause$iv$iv2;
            $this$consume$iv$iv2 = i;
            cause$iv$iv3 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
            i2 = $i$f$consumeEach;
            $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = $continuation;
            collection2 = collection;
        }
    }

    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(kotlinx.coroutines.channels.ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m2, Continuation<? super M> continuation3) {
        boolean $result;
        Object $continuation2;
        Throwable e$iv$iv;
        Object $continuation3;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.toMap.2 map;
        int $i$f$consumeEach;
        int $i$f$consumeEach2;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
        Object $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
        int i2;
        Throwable th;
        int i;
        Object cause$iv$iv2;
        Throwable cause$iv$iv3;
        Object cause$iv$iv;
        int $this$consume$iv$iv2;
        Object $this$consume$iv$iv;
        Object destination;
        Object iterator;
        Object obj;
        int i3;
        Object first;
        Object second;
        kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt.toMap.2 map2;
        int obj13;
        int obj14;
        Object obj15;
        $result = continuation3;
        $i$f$consumeEach = Integer.MIN_VALUE;
        if (continuation3 instanceof ChannelsKt__DeprecatedKt.toMap.2 && label &= $i$f$consumeEach != 0) {
            $result = continuation3;
            $i$f$consumeEach = Integer.MIN_VALUE;
            if (label &= $i$f$consumeEach != 0) {
                $result.label = obj15 -= $i$f$consumeEach;
            } else {
                $result = new ChannelsKt__DeprecatedKt.toMap.2(continuation3);
            }
        } else {
        }
        obj15 = $result.result;
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj15);
                i = 0;
                obj14 = obj13;
                obj13 = i5;
                $i$f$consumeEach2 = i7;
                $this$consume$iv$iv = $this$consumeEach_u24lambda_u241$iv;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2 = iterator;
                break;
            case 1:
                obj13 = 0;
                obj14 = 0;
                ResultKt.throwOnFailure(obj15);
                iterator = l$0;
                destination = l$1;
                $this$consume$iv$iv2 = i6;
                cause$iv$iv2 = l$2;
                i2 = i4;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = $continuation3;
                map = $result;
                $continuation2 = obj15;
                obj = obj15;
                i3 = 0;
                iterator.put((Pair)obj.getFirst(), obj.getSecond());
                obj15 = $continuation2;
                $result = map;
                $continuation3 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv;
                $i$f$consumeEach2 = i2;
                $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2 = cause$iv$iv2;
                i = $this$consume$iv$iv2;
                cause$iv$iv = destination;
                $this$consume$iv$iv = iterator;
                obj15 = Unit.INSTANCE;
                ChannelsKt.cancelConsumed(destination, $this$consume$iv$iv2);
                return iterator;
            default:
                obj13 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj13;
        }
        $result.L$0 = $this$consume$iv$iv;
        $result.L$1 = cause$iv$iv;
        $result.L$2 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
        $result.label = 1;
        Object next = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2.hasNext($result);
        if (next == $continuation3) {
            return $continuation3;
        } else {
            $continuation2 = obj15;
            obj15 = next;
            iterator = $this$consume$iv$iv;
            destination = cause$iv$iv;
            $this$consume$iv$iv2 = i;
            cause$iv$iv2 = $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv2;
            i2 = $i$f$consumeEach2;
            $i$a$ConsumeChannelsKt__Channels_commonKt$consumeEach$2$iv = $continuation3;
            map = map2;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object toMap(kotlinx.coroutines.channels.ReceiveChannel $this$toMap, Continuation $completion) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        return ChannelsKt.toMap($this$toMap, (Map)linkedHashMap, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object toMutableList(kotlinx.coroutines.channels.ReceiveChannel $this$toMutableList, Continuation $completion) {
        ArrayList arrayList = new ArrayList();
        return ChannelsKt.toCollection($this$toMutableList, (Collection)arrayList, $completion);
    }

    public static final <E> Object toMutableSet(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$toMutableSet, Continuation<? super Set<E>> $completion) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        return ChannelsKt.toCollection($this$toMutableSet, (Collection)linkedHashSet, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final Object toSet(kotlinx.coroutines.channels.ReceiveChannel $this$toSet, Continuation $completion) {
        return ChannelsKt.toMutableSet($this$toSet, $completion);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel withIndex(kotlinx.coroutines.channels.ReceiveChannel $this$withIndex, CoroutineContext context) {
        ChannelsKt__DeprecatedKt.withIndex.1 anon = new ChannelsKt__DeprecatedKt.withIndex.1($this$withIndex, 0);
        return ProduceKt.produce$default((CoroutineScope)GlobalScope.INSTANCE, context, 0, 0, ChannelsKt.consumes($this$withIndex), (Function2)anon, 6, 0);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel withIndex$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, CoroutineContext coroutineContext2, int i3, Object object4) {
        kotlinx.coroutines.CoroutineDispatcher obj1;
        if (i3 &= 1 != 0) {
            obj1 = Dispatchers.getUnconfined();
        }
        return ChannelsKt.withIndex(receiveChannel, obj1);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final kotlinx.coroutines.channels.ReceiveChannel zip(kotlinx.coroutines.channels.ReceiveChannel $this$zip, kotlinx.coroutines.channels.ReceiveChannel other) {
        return ChannelsKt.zip$default($this$zip, other, 0, (Function2)ChannelsKt__DeprecatedKt.zip.1.INSTANCE, 2, 0);
    }

    public static final <E, R, V> kotlinx.coroutines.channels.ReceiveChannel<V> zip(kotlinx.coroutines.channels.ReceiveChannel<? extends E> $this$zip, kotlinx.coroutines.channels.ReceiveChannel<? extends R> other, CoroutineContext context, Function2<? super E, ? super R, ? extends V> transform) {
        kotlinx.coroutines.channels.ReceiveChannel[] arr = new ReceiveChannel[2];
        ChannelsKt__DeprecatedKt.zip.2 anon = new ChannelsKt__DeprecatedKt.zip.2(other, $this$zip, transform, 0);
        return ProduceKt.produce$default((CoroutineScope)GlobalScope.INSTANCE, context, 0, 0, ChannelsKt.consumesAll($this$zip, other), (Function2)anon, 6, 0);
    }

    public static kotlinx.coroutines.channels.ReceiveChannel zip$default(kotlinx.coroutines.channels.ReceiveChannel receiveChannel, kotlinx.coroutines.channels.ReceiveChannel receiveChannel2, CoroutineContext coroutineContext3, Function2 function24, int i5, Object object6) {
        kotlinx.coroutines.CoroutineDispatcher obj2;
        if (i5 &= 2 != 0) {
            obj2 = Dispatchers.getUnconfined();
        }
        return ChannelsKt.zip(receiveChannel, receiveChannel2, obj2, function24);
    }
}
