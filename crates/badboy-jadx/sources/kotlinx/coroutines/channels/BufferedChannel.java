package kotlinx.coroutines.channels;

import _COROUTINE.ArtificialStackFrames;
import android.app.Notification.Action;
import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.InlineList;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectClause2Impl;
import kotlinx.coroutines.selects.SelectImplementation;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.TrySelectDetailedResult;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000À\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008#\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008!\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u000e\n\u0002\u0008\"\u0008\u0010\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002:\u0004Þ\u0001ß\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\"\u0008\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0008¢\u0006\u0002\u0010\tJ\u0010\u0010P\u001a\u00020\u001c2\u0006\u0010Q\u001a\u00020\u0010H\u0002J\u0006\u0010R\u001a\u00020\u0007J\u0010\u0010R\u001a\u00020\u001c2\u0008\u0010S\u001a\u0004\u0018\u00010\u0016J\u0016\u0010R\u001a\u00020\u00072\u000e\u0010S\u001a\n\u0018\u00010Tj\u0004\u0018\u0001`UJ\u0017\u0010V\u001a\u00020\u001c2\u0008\u0010S\u001a\u0004\u0018\u00010\u0016H\u0010¢\u0006\u0002\u0008WJ\u001e\u0010X\u001a\u00020\u00072\u000c\u0010Y\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010K\u001a\u00020\u0010H\u0002J\u0006\u0010Z\u001a\u00020\u0007J\u0012\u0010[\u001a\u00020\u001c2\u0008\u0010S\u001a\u0004\u0018\u00010\u0016H\u0016J\u000e\u0010\\\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001a\u0010]\u001a\u00020\u001c2\u0008\u0010S\u001a\u0004\u0018\u00010\u00162\u0006\u0010R\u001a\u00020\u001cH\u0014J\u0010\u0010^\u001a\u00020\u00072\u0006\u0010_\u001a\u00020\u0010H\u0002J\u0016\u0010`\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010_\u001a\u00020\u0010H\u0002J\u0008\u0010a\u001a\u00020\u0007H\u0002J\u0010\u0010b\u001a\u00020\u00072\u0006\u0010c\u001a\u00020\u0010H\u0004J\u0008\u0010d\u001a\u00020\u0007H\u0002J.\u0010e\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\u000c\u0010g\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010h\u001a\u00020\u0010H\u0002J&\u0010i\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\u000c\u0010g\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J&\u0010j\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00142\u0006\u0010f\u001a\u00020\u00102\u000c\u0010g\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\r\u0010k\u001a\u00020\u001cH\u0000¢\u0006\u0002\u0008lJ\u0012\u0010m\u001a\u00020\u00072\u0008\u0008\u0002\u0010n\u001a\u00020\u0010H\u0002J\u0008\u0010o\u001a\u00020\u0007H\u0002J-\u0010p\u001a\u00020\u00072#\u0010q\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\u000c\u0008:\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(S\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J&\u0010r\u001a\u00020\u001c2\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0006\u0010u\u001a\u00020\u0010H\u0002J\u0018\u0010v\u001a\u00020\u001c2\u0006\u0010w\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000f\u0010x\u001a\u0008\u0012\u0004\u0012\u00028\u00000yH\u0096\u0002J\u0016\u0010z\u001a\u00020\u00102\u000c\u0010Y\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u0008\u0010{\u001a\u00020\u0007H\u0002J\u0008\u0010|\u001a\u00020\u0007H\u0002J\u0008\u0010}\u001a\u00020\u0007H\u0002J\u001e\u0010~\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00102\u000c\u0010g\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u0008\u0010\u007f\u001a\u00020\u0007H\u0014J\"\u0010\u0080\u0001\u001a\u00020\u00072\u0014\u0010\u0081\u0001\u001a\u000f\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000,0\u0082\u0001H\u0002ø\u0001\u0000J\u0019\u0010\u0083\u0001\u001a\u00020\u00072\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0082\u0001H\u0002J\u0015\u0010\u0084\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\u0008\u000309H\u0002J$\u0010\u0085\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u00002\n\u0010<\u001a\u0006\u0012\u0002\u0008\u000309H\u0002¢\u0006\u0003\u0010\u0087\u0001J\u001c\u0010\u0088\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u0089\u0001J(\u0010\u008a\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u000e\u0010\u0081\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070\u0082\u0001H\u0002¢\u0006\u0003\u0010\u008b\u0001J\t\u0010\u008c\u0001\u001a\u00020\u0007H\u0014J\t\u0010\u008d\u0001\u001a\u00020\u0007H\u0014J!\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u000c2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000c2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u000cH\u0002J!\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u000c2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000c2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u000cH\u0002J!\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u000c2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000c2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u000cH\u0002J!\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u000c2\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000c2\t\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u000cH\u0002J\u0013\u0010\u0094\u0001\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u0095\u0001J%\u0010\u0096\u0001\u001a\u0008\u0012\u0004\u0012\u00028\u00000,H\u0096@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0006\u0008\u0097\u0001\u0010\u0095\u0001JD\u0010\u0098\u0001\u001a\u0008\u0012\u0004\u0012\u00028\u00000,2\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0082@ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0006\u0008\u009a\u0001\u0010\u009b\u0001J\u008c\u0002\u0010\u009c\u0001\u001a\u0003H\u009d\u0001\"\u0005\u0008\u0001\u0010\u009d\u00012\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u000c2$\u0010\u009f\u0001\u001a\u001f\u0012\u0014\u0012\u00128\u0000¢\u0006\r\u0008:\u0012\t\u0008;\u0012\u0005\u0008\u0008(\u0086\u0001\u0012\u0005\u0012\u0003H\u009d\u00010\u00062V\u0010 \u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\u0008:\u0012\t\u0008;\u0012\u0005\u0008\u0008(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\u0008:\u0012\t\u0008;\u0012\u0005\u0008\u0008(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\u0008:\u0012\t\u0008;\u0012\u0005\u0008\u0008(\u0099\u0001\u0012\u0005\u0012\u0003H\u009d\u0001082\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012X\u0008\u0002\u0010¥\u0001\u001aQ\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\u0008:\u0012\t\u0008;\u0012\u0005\u0008\u0008(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\u0008:\u0012\t\u0008;\u0012\u0005\u0008\u0008(¢\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\u0008:\u0012\t\u0008;\u0012\u0005\u0008\u0008(\u0099\u0001\u0012\u0005\u0012\u0003H\u009d\u000108H\u0082\u0008¢\u0006\u0003\u0010¦\u0001Jh\u0010§\u0001\u001a\u00020\u00072\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\u0008\u0010\u009e\u0001\u001a\u00030¨\u00012#\u0010\u009f\u0001\u001a\u001e\u0012\u0014\u0012\u00128\u0000¢\u0006\r\u0008:\u0012\t\u0008;\u0012\u0005\u0008\u0008(\u0086\u0001\u0012\u0004\u0012\u00020\u00070\u00062\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\u0082\u0008J2\u0010©\u0001\u001a\u00028\u00002\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010\u009b\u0001J \u0010ª\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\u0008\u0003092\t\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u000cH\u0002J \u0010«\u0001\u001a\u00020\u00072\n\u0010<\u001a\u0006\u0012\u0002\u0008\u0003092\t\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u000cH\u0014J\u0017\u0010¬\u0001\u001a\u00020\u00072\u000c\u0010Y\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0014H\u0002J\u001c\u0010­\u0001\u001a\u00020\u00072\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010\u0089\u0001J\u001f\u0010®\u0001\u001a\u00020\u001c2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0090@ø\u0001\u0000¢\u0006\u0006\u0008¯\u0001\u0010\u0089\u0001J\u0082\u0002\u0010°\u0001\u001a\u0003H\u009d\u0001\"\u0005\u0008\u0001\u0010\u009d\u00012\u0007\u0010\u0086\u0001\u001a\u00028\u00002\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u000c2\u000f\u0010±\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012A\u0010 \u0001\u001a<\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\u0008:\u0012\t\u0008;\u0012\u0005\u0008\u0008(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\u0008:\u0012\t\u0008;\u0012\u0005\u0008\u0008(¢\u0001\u0012\u0005\u0012\u0003H\u009d\u00010²\u00012\u000f\u0010£\u0001\u001a\n\u0012\u0005\u0012\u0003H\u009d\u00010¤\u00012o\u0008\u0002\u0010¥\u0001\u001ah\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00028\u00000\u0014¢\u0006\r\u0008:\u0012\t\u0008;\u0012\u0005\u0008\u0008(¡\u0001\u0012\u0014\u0012\u00120\u0004¢\u0006\r\u0008:\u0012\t\u0008;\u0012\u0005\u0008\u0008(¢\u0001\u0012\u0014\u0012\u00128\u0000¢\u0006\r\u0008:\u0012\t\u0008;\u0012\u0005\u0008\u0008(\u0086\u0001\u0012\u0014\u0012\u00120\u0010¢\u0006\r\u0008:\u0012\t\u0008;\u0012\u0005\u0008\u0008(´\u0001\u0012\u0005\u0012\u0003H\u009d\u00010³\u0001H\u0084\u0008¢\u0006\u0003\u0010µ\u0001Jb\u0010¶\u0001\u001a\u00020\u00072\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\u0008\u0010\u009e\u0001\u001a\u00030¨\u00012\u000e\u0010±\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u00012\u000e\u0010£\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070¤\u0001H\u0082\u0008¢\u0006\u0003\u0010·\u0001J;\u0010¸\u0001\u001a\u00020\u00072\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u0010H\u0082@ø\u0001\u0000¢\u0006\u0003\u0010¹\u0001J\u000f\u0010º\u0001\u001a\u00020\u001cH\u0010¢\u0006\u0003\u0008»\u0001J\u0012\u0010º\u0001\u001a\u00020\u001c2\u0007\u0010¼\u0001\u001a\u00020\u0010H\u0003J\n\u0010½\u0001\u001a\u00030¾\u0001H\u0016J\u0010\u0010¿\u0001\u001a\u00030¾\u0001H\u0000¢\u0006\u0003\u0008À\u0001J!\u0010Á\u0001\u001a\u0008\u0012\u0004\u0012\u00028\u00000,H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0006\u0008Â\u0001\u0010Ã\u0001J*\u0010Ä\u0001\u001a\u0008\u0012\u0004\u0012\u00020\u00070,2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0016ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0006\u0008Å\u0001\u0010Æ\u0001J(\u0010Ç\u0001\u001a\u00020\u001c2\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010È\u0001\u001a\u00020\u0010H\u0002J(\u0010É\u0001\u001a\u00020\u001c2\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010È\u0001\u001a\u00020\u0010H\u0002J5\u0010Ê\u0001\u001a\u0004\u0018\u00010\u000c2\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u000cH\u0002J5\u0010Ë\u0001\u001a\u0004\u0018\u00010\u000c2\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0099\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u000cH\u0002JK\u0010Ì\u0001\u001a\u00020\u00042\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u000c2\u0007\u0010Í\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Î\u0001JK\u0010Ï\u0001\u001a\u00020\u00042\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u00042\u0007\u0010\u0086\u0001\u001a\u00028\u00002\u0007\u0010´\u0001\u001a\u00020\u00102\t\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u000c2\u0007\u0010Í\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0003\u0010Î\u0001J\u0012\u0010Ð\u0001\u001a\u00020\u00072\u0007\u0010Ñ\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010Ò\u0001\u001a\u00020\u00072\u0007\u0010Ñ\u0001\u001a\u00020\u0010H\u0002J\u0017\u0010Ó\u0001\u001a\u00020\u00072\u0006\u0010u\u001a\u00020\u0010H\u0000¢\u0006\u0003\u0008Ô\u0001J$\u0010Õ\u0001\u001a\u00020\u0007*\u00030¨\u00012\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J$\u0010Ö\u0001\u001a\u00020\u0007*\u00030¨\u00012\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002J\u000e\u0010×\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u000e\u0010Ø\u0001\u001a\u00020\u0007*\u00030¨\u0001H\u0002J\u0017\u0010Ù\u0001\u001a\u00020\u0007*\u00030¨\u00012\u0007\u0010Ú\u0001\u001a\u00020\u001cH\u0002J\u001c\u0010Û\u0001\u001a\u00020\u001c*\u00020\u000c2\u0007\u0010\u0086\u0001\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010Ü\u0001J#\u0010Ý\u0001\u001a\u00020\u001c*\u00020\u000c2\u000c\u0010s\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00142\u0006\u0010t\u001a\u00020\u0004H\u0002R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u000bX\u0082\u0004R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010\u000f\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u000bX\u0082\u0004R\t\u0010\u001a\u001a\u00020\u000eX\u0082\u0004R\u001a\u0010\u001b\u001a\u00020\u001c8VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u001d\u0010\u001e\u001a\u0004\u0008\u001b\u0010\u001fR\u001a\u0010 \u001a\u00020\u001c8VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008!\u0010\u001e\u001a\u0004\u0008 \u0010\u001fR\u0014\u0010\"\u001a\u00020\u001c8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\"\u0010\u001fR\u001a\u0010#\u001a\u00020\u001c8VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008$\u0010\u001e\u001a\u0004\u0008#\u0010\u001fR\u0014\u0010%\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008%\u0010\u001fR \u0010&\u001a\u0008\u0012\u0004\u0012\u00028\u00000'8VX\u0096\u0004¢\u0006\u000c\u0012\u0004\u0008(\u0010\u001e\u001a\u0004\u0008)\u0010*R)\u0010+\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000,0'8VX\u0096\u0004ø\u0001\u0000¢\u0006\u000c\u0012\u0004\u0008-\u0010\u001e\u001a\u0004\u0008.\u0010*R\"\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000'8VX\u0096\u0004¢\u0006\u000c\u0012\u0004\u00080\u0010\u001e\u001a\u0004\u00081\u0010*R,\u00102\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u0000038VX\u0096\u0004¢\u0006\u000c\u0012\u0004\u00084\u0010\u001e\u001a\u0004\u00085\u00106R*\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u00088\u0000X\u0081\u0004¢\u0006\u0002\n\u0000Ru\u00107\u001ac\u0012\u0017\u0012\u0015\u0012\u0002\u0008\u000309¢\u0006\u000c\u0008:\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(<\u0012\u0015\u0012\u0013\u0018\u00010\u000c¢\u0006\u000c\u0008:\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(=\u0012\u0015\u0012\u0013\u0018\u00010\u000c¢\u0006\u000c\u0008:\u0012\u0008\u0008;\u0012\u0004\u0008\u0008(>\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u000108j\u0004\u0018\u0001`?X\u0082\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008@\u0010\u001eR\u0014\u0010A\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008B\u0010\u0018R\u0015\u0010C\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\t\u0010D\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010E\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008F\u0010\u0012R\u0014\u0010G\u001a\u00020\u00168DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008H\u0010\u0018R\u0015\u0010I\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\u00140\u000bX\u0082\u0004R\t\u0010J\u001a\u00020\u000eX\u0082\u0004R\u0014\u0010K\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008L\u0010\u0012R\u0018\u0010M\u001a\u00020\u001c*\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008M\u0010NR\u0018\u0010O\u001a\u00020\u001c*\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008O\u0010N\u0082\u0002\u000f\n\u0002\u0008\u0019\n\u0002\u0008!\n\u0005\u0008¡\u001e0\u0001¨\u0006à\u0001", d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", "capacity", "", "onUndeliveredElement", "Lkotlin/Function1;", "", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "(ILkotlin/jvm/functions/Function1;)V", "_closeCause", "Lkotlinx/atomicfu/AtomicRef;", "", "bufferEnd", "Lkotlinx/atomicfu/AtomicLong;", "bufferEndCounter", "", "getBufferEndCounter", "()J", "bufferEndSegment", "Lkotlinx/coroutines/channels/ChannelSegment;", "closeCause", "", "getCloseCause", "()Ljava/lang/Throwable;", "closeHandler", "completedExpandBuffersAndPauseFlag", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isClosedForSend", "isClosedForSend$annotations", "isConflatedDropOldest", "isEmpty", "isEmpty$annotations", "isRendezvousOrUnlimited", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "Lkotlinx/coroutines/channels/ChannelResult;", "getOnReceiveCatching$annotations", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onUndeliveredElementReceiveCancellationConstructor", "Lkotlin/Function3;", "Lkotlinx/coroutines/selects/SelectInstance;", "Lkotlin/ParameterName;", "name", "select", "param", "internalResult", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "receiveException", "getReceiveException", "receiveSegment", "receivers", "receiversCounter", "getReceiversCounter$kotlinx_coroutines_core", "sendException", "getSendException", "sendSegment", "sendersAndCloseStatus", "sendersCounter", "getSendersCounter$kotlinx_coroutines_core", "isClosedForReceive0", "(J)Z", "isClosedForSend0", "bufferOrRendezvousSend", "curSenders", "cancel", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelSuspendedReceiveRequests", "lastSegment", "checkSegmentStructureInvariants", "close", "closeLinkedList", "closeOrCancelImpl", "completeCancel", "sendersCur", "completeClose", "completeCloseOrCancel", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "globalCellIndex", "expandBuffer", "findSegmentBufferEnd", "id", "startFrom", "currentBufferEndCounter", "findSegmentReceive", "findSegmentSend", "hasElements", "hasElements$kotlinx_coroutines_core", "incCompletedExpandBufferAttempts", "nAttempts", "invokeCloseHandler", "invokeOnClose", "handler", "isCellNonEmpty", "segment", "index", "globalIndex", "isClosed", "sendersAndCloseStatusCur", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "markAllEmptyCellsAsClosed", "markCancellationStarted", "markCancelled", "markClosed", "moveSegmentBufferEndToSpecifiedOrLast", "onClosedIdempotent", "onClosedReceiveCatchingOnNoWaiterSuspend", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "onClosedReceiveOnNoWaiterSuspend", "onClosedSelectOnReceive", "onClosedSelectOnSend", "element", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "onClosedSend", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedSendOnNoWaiterSuspend", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "onReceiveDequeued", "onReceiveEnqueued", "processResultSelectReceive", "ignoredParam", "selectResult", "processResultSelectReceiveCatching", "processResultSelectReceiveOrNull", "processResultSelectSend", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveCatching", "receiveCatching-JP2dKIU", "receiveCatchingOnNoWaiterSuspend", "r", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveImpl", "R", "waiter", "onElementRetrieved", "onSuspend", "segm", "i", "onClosed", "Lkotlin/Function0;", "onNoWaiterSuspend", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "receiveImplOnNoWaiter", "Lkotlinx/coroutines/Waiter;", "receiveOnNoWaiterSuspend", "registerSelectForReceive", "registerSelectForSend", "removeUnprocessedElements", "send", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "sendImpl", "onRendezvousOrBuffered", "Lkotlin/Function2;", "Lkotlin/Function4;", "s", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "sendImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "sendOnNoWaiterSuspend", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldSendSuspend", "shouldSendSuspend$kotlinx_coroutines_core", "curSendersAndCloseStatus", "toString", "", "toStringDebug", "toStringDebug$kotlinx_coroutines_core", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "trySend", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "updateCellExpandBuffer", "b", "updateCellExpandBufferSlow", "updateCellReceive", "updateCellReceiveSlow", "updateCellSend", "closed", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "updateReceiversCounterIfLower", "value", "updateSendersCounterIfLower", "waitExpandBufferCompletion", "waitExpandBufferCompletion$kotlinx_coroutines_core", "prepareReceiverForSuspension", "prepareSenderForSuspension", "resumeReceiverOnClosedChannel", "resumeSenderOnCancelledChannel", "resumeWaiterOnClosedChannel", "receiver", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "tryResumeSender", "BufferedChannelIterator", "SendBroadcast", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class BufferedChannel<E>  implements kotlinx.coroutines.channels.Channel<E> {

    private static final AtomicReferenceFieldUpdater _closeCause$FU;
    private static final AtomicLongFieldUpdater bufferEnd$FU;
    private static final AtomicReferenceFieldUpdater bufferEndSegment$FU;
    private static final AtomicReferenceFieldUpdater closeHandler$FU;
    private static final AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$FU;
    private static final AtomicReferenceFieldUpdater receiveSegment$FU;
    private static final AtomicLongFieldUpdater receivers$FU;
    private static final AtomicReferenceFieldUpdater sendSegment$FU;
    private static final AtomicLongFieldUpdater sendersAndCloseStatus$FU;
    @Volatile
    private volatile Object _closeCause;
    @Volatile
    private volatile long bufferEnd;
    @Volatile
    private volatile Object bufferEndSegment;
    private final int capacity;
    @Volatile
    private volatile Object closeHandler;
    @Volatile
    private volatile long completedExpandBuffersAndPauseFlag;
    public final Function1<E, Unit> onUndeliveredElement;
    private final Function3<SelectInstance<?>, Object, Object, Function1<Throwable, Unit>> onUndeliveredElementReceiveCancellationConstructor;
    @Volatile
    private volatile Object receiveSegment;
    @Volatile
    private volatile long receivers;
    @Volatile
    private volatile Object sendSegment;
    @Volatile
    private volatile long sendersAndCloseStatus;

    @Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u0008\u0082\u0004\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0011\u0010\t\u001a\u00020\u0006H\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\nJ/\u0010\u000b\u001a\u00020\u00062\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00028\u00000\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u000c\u001a\u0006\u0012\u0002\u0008\u00030\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0016\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u0017J\u0008\u0010\u0018\u001a\u00020\u0006H\u0002J\u0008\u0010\u0019\u001a\u00020\u0014H\u0002J\u0013\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00028\u0000¢\u0006\u0002\u0010\u001cJ\u0006\u0010\u001d\u001a\u00020\u0014R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u001e", d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", "", "receiveResult", "", "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextOnNoWaiterSuspend", "segment", "Lkotlinx/coroutines/channels/ChannelSegment;", "index", "", "r", "", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnCancellation", "", "Lkotlinx/coroutines/internal/Segment;", "next", "()Ljava/lang/Object;", "onClosedHasNext", "onClosedHasNextNoWaiterSuspend", "tryResumeHasNext", "element", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class BufferedChannelIterator implements kotlinx.coroutines.channels.ChannelIterator<E>, Waiter {

        private CancellableContinuationImpl<? super Boolean> continuation;
        private Object receiveResult;
        final kotlinx.coroutines.channels.BufferedChannel<E> this$0;
        public BufferedChannelIterator(kotlinx.coroutines.channels.BufferedChannel this$0) {
            this.this$0 = this$0;
            super();
            this.receiveResult = BufferedChannelKt.access$getNO_RECEIVE_RESULT$p();
        }

        public static final Object access$hasNextOnNoWaiterSuspend(kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator $this, kotlinx.coroutines.channels.ChannelSegment segment, int index, long r, Continuation $completion) {
            return $this.hasNextOnNoWaiterSuspend(segment, index, r, $completion);
        }

        public static final void access$onClosedHasNextNoWaiterSuspend(kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator $this) {
            $this.onClosedHasNextNoWaiterSuspend();
        }

        public static final void access$setContinuation$p(kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator $this, CancellableContinuationImpl <set-?>) {
            $this.continuation = <set-?>;
        }

        public static final void access$setReceiveResult$p(kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator $this, Object <set-?>) {
            $this.receiveResult = <set-?>;
        }

        private final Object hasNextOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, long r, Continuation<? super Boolean> $completion) {
            Function1 onUndeliveredElement;
            int i;
            int id$iv$iv;
            int cmp;
            Continuation updCellResult$iv$iv2;
            kotlinx.coroutines.channels.BufferedChannel buf;
            Object segment$iv$iv;
            kotlinx.coroutines.channels.ChannelSegment channelSegment;
            int i$iv$iv;
            Object segment$iv$iv2;
            long bindCancellationFun;
            Object closedForReceive;
            int i3;
            int i2;
            long r$iv$iv;
            int i4;
            int $i$f$suspendCancellableCoroutineReusable;
            Continuation continuation;
            int sendersCounter$kotlinx_coroutines_core;
            Object updCellResult$iv$iv;
            final Object obj2 = this;
            kotlinx.coroutines.channels.BufferedChannel this$0 = obj2.this$0;
            id$iv$iv = 0;
            updCellResult$iv$iv2 = obj30;
            final int i8 = 0;
            CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(updCellResult$iv$iv2));
            final CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation;
            final int i9 = 0;
            BufferedChannel.BufferedChannelIterator.access$setContinuation$p(obj2, cancellableContinuationImpl);
            final kotlinx.coroutines.channels.BufferedChannel buf2 = this$0;
            final int i10 = 0;
            final Object obj5 = closedForReceive;
            if (obj5 == BufferedChannelKt.access$getSUSPEND$p()) {
                BufferedChannel.access$prepareReceiverForSuspension(buf2, (Waiter)obj2, segment, index);
                $i$f$suspendCancellableCoroutineReusable = id$iv$iv;
                continuation = updCellResult$iv$iv2;
            } else {
                i$iv$iv = index;
                i3 = 1;
                if (obj5 == BufferedChannelKt.access$getFAILED$p() && Long.compare(r, sendersCounter$kotlinx_coroutines_core2) < 0) {
                    if (Long.compare(r, sendersCounter$kotlinx_coroutines_core2) < 0) {
                        segment.cleanPrev();
                    }
                    i2 = 0;
                    segment$iv$iv2 = BufferedChannel.access$getReceiveSegment$FU$p().get(buf2);
                    while (buf2.isClosedForReceive()) {
                        r$iv$iv = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(buf2);
                        closedForReceive = BufferedChannelKt.SEGMENT_SIZE;
                        bindCancellationFun = r$iv$iv / l3;
                        $i$f$suspendCancellableCoroutineReusable = id$iv$iv;
                        continuation = updCellResult$iv$iv2;
                        segment$iv$iv = segment$iv$iv2;
                        segment$iv$iv2 = r$iv$iv;
                        i$iv$iv = sendersCounter$kotlinx_coroutines_core;
                        r$iv$iv = l2;
                        id$iv$iv = 0;
                        updCellResult$iv$iv2 = BufferedChannel.access$updateCellReceive(buf2, segment$iv$iv, i$iv$iv, segment$iv$iv2, bindCancellationFun);
                        if (Long.compare(segment$iv$iv2, sendersCounter$kotlinx_coroutines_core) < 0) {
                        }
                        i$iv$iv = index;
                        segment$iv$iv2 = segment$iv$iv;
                        id$iv$iv = $i$f$suspendCancellableCoroutineReusable;
                        updCellResult$iv$iv2 = continuation;
                        segment$iv$iv = segment;
                        segment$iv$iv.cleanPrev();
                        cmp = BufferedChannel.access$findSegmentReceive(buf2, bindCancellationFun, closedForReceive);
                        segment$iv$iv2 = cmp;
                        id$iv$iv = $i$f$suspendCancellableCoroutineReusable;
                        updCellResult$iv$iv2 = continuation;
                    }
                    onUndeliveredElement = 0;
                    BufferedChannel.BufferedChannelIterator.access$onClosedHasNextNoWaiterSuspend(obj2);
                    $i$f$suspendCancellableCoroutineReusable = id$iv$iv;
                    continuation = updCellResult$iv$iv2;
                }
                $i$f$suspendCancellableCoroutineReusable = id$iv$iv;
                continuation = updCellResult$iv$iv2;
                segment.cleanPrev();
                id$iv$iv = obj5;
                updCellResult$iv$iv2 = 0;
                BufferedChannel.BufferedChannelIterator.access$setReceiveResult$p(obj2, id$iv$iv);
                segment$iv$iv = 0;
                BufferedChannel.BufferedChannelIterator.access$setContinuation$p(obj2, segment$iv$iv);
                onUndeliveredElement = this$0.onUndeliveredElement;
                if (onUndeliveredElement != null) {
                    bindCancellationFun = OnUndeliveredElementKt.bindCancellationFun(onUndeliveredElement, id$iv$iv, cancellableContinuationImpl.getContext());
                } else {
                    bindCancellationFun = segment$iv$iv;
                }
                cancellableContinuationImpl.resume(Boxing.boxBoolean(i3), bindCancellationFun);
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(obj30);
            }
            return result;
        }

        private final boolean onClosedHasNext() {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = this.this$0.getCloseCause();
            if (closeCause != null) {
            } else {
                return 0;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(closeCause);
        }

        private final void onClosedHasNextNoWaiterSuspend() {
            CancellableContinuationImpl cancellableContinuationImpl;
            Object constructor-impl;
            Throwable th;
            boolean rECOVER_STACK_TRACES;
            final CancellableContinuationImpl continuation = this.continuation;
            Intrinsics.checkNotNull(continuation);
            this.continuation = 0;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = this.this$0.getCloseCause();
            if (closeCause == null) {
                kotlin.Result.Companion companion = Result.Companion;
                (Continuation)continuation.resumeWith(Result.constructor-impl(false));
            } else {
                int i2 = 0;
                if (DebugKt.getRECOVER_STACK_TRACES()) {
                    if (!cancellableContinuationImpl2 instanceof CoroutineStackFrame) {
                        th = closeCause;
                    } else {
                        th = StackTraceRecoveryKt.access$recoverFromStackFrame(closeCause, (CoroutineStackFrame)(Continuation)continuation);
                    }
                } else {
                }
                kotlin.Result.Companion $i$f$recoverStackTrace = Result.Companion;
                (Continuation)continuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(th)));
            }
        }

        public Object hasNext(Continuation<? super Boolean> $completion) {
            Object segment$iv;
            kotlinx.coroutines.channels.BufferedChannel buf;
            long r$iv;
            Boolean boxBoolean;
            int i2;
            long i$iv;
            Object cmp;
            int waiter$iv;
            int i;
            Object obj;
            int i4;
            long l2;
            int i3;
            long l;
            final Object obj2 = this;
            waiter$iv = 0;
            final int i9 = 0;
            segment$iv = BufferedChannel.access$getReceiveSegment$FU$p().get(obj2.this$0);
            while (buf.isClosedForReceive()) {
                r$iv = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(buf);
                i = r$iv / l4;
                i2 = i$iv;
                i$iv = l;
                r$iv = segment$iv;
                obj = BufferedChannel.access$updateCellReceive(buf, r$iv, i2, i$iv, cmp);
                l2 = i$iv;
                waiter$iv = buf;
                cmp = r$iv;
                if (Long.compare(l2, sendersCounter$kotlinx_coroutines_core) < 0) {
                }
                segment$iv = cmp;
                buf = waiter$iv;
                waiter$iv = i4;
                cmp.cleanPrev();
                cmp = BufferedChannel.access$findSegmentReceive(buf, i, obj10);
                segment$iv = cmp;
            }
            int i7 = 0;
            boxBoolean = Boxing.boxBoolean(obj2.onClosedHasNext());
            return boxBoolean;
        }

        public void invokeOnCancellation(Segment<?> segment, int index) {
            final CancellableContinuationImpl continuation = this.continuation;
            if (continuation != null) {
                continuation.invokeOnCancellation(segment, index);
            }
        }

        public E next() {
            int i;
            final Object receiveResult = this.receiveResult;
            i = receiveResult != BufferedChannelKt.access$getNO_RECEIVE_RESULT$p() ? 1 : 0;
            if (i == 0) {
            } else {
                this.receiveResult = BufferedChannelKt.access$getNO_RECEIVE_RESULT$p();
                if (receiveResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
                } else {
                    return receiveResult;
                }
                throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.access$getReceiveException(this.this$0));
            }
            int i2 = 0;
            IllegalStateException $i$a$CheckBufferedChannel$BufferedChannelIterator$next$1 = new IllegalStateException("`hasNext()` has not been invoked".toString());
            throw $i$a$CheckBufferedChannel$BufferedChannelIterator$next$1;
        }

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public Object next(Continuation $completion) {
            return ChannelIterator.DefaultImpls.next(this, $completion);
        }

        public final boolean tryResumeHasNext(E element) {
            int bindCancellationFun;
            final CancellableContinuationImpl continuation = this.continuation;
            Intrinsics.checkNotNull(continuation);
            this.continuation = 0;
            this.receiveResult = element;
            Function1 onUndeliveredElement = this$0.onUndeliveredElement;
            if (onUndeliveredElement != null) {
                bindCancellationFun = OnUndeliveredElementKt.bindCancellationFun(onUndeliveredElement, element, continuation.getContext());
            }
            return BufferedChannelKt.access$tryResume0((CancellableContinuation)continuation, true, bindCancellationFun);
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public final void tryResumeHasNextOnClosedChannel() {
            CancellableContinuationImpl cancellableContinuationImpl;
            Object constructor-impl;
            Throwable th;
            boolean rECOVER_STACK_TRACES;
            final CancellableContinuationImpl continuation = this.continuation;
            Intrinsics.checkNotNull(continuation);
            this.continuation = 0;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = this.this$0.getCloseCause();
            if (closeCause == null) {
                kotlin.Result.Companion companion = Result.Companion;
                (Continuation)continuation.resumeWith(Result.constructor-impl(false));
            } else {
                int i2 = 0;
                if (DebugKt.getRECOVER_STACK_TRACES()) {
                    if (!cancellableContinuationImpl2 instanceof CoroutineStackFrame) {
                        th = closeCause;
                    } else {
                        th = StackTraceRecoveryKt.access$recoverFromStackFrame(closeCause, (CoroutineStackFrame)(Continuation)continuation);
                    }
                } else {
                }
                kotlin.Result.Companion $i$f$recoverStackTrace = Result.Companion;
                (Continuation)continuation.resumeWith(Result.constructor-impl(ResultKt.createFailure(th)));
            }
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0008\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0096\u0001R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/CancellableContinuation;)V", "getCont", "()Lkotlinx/coroutines/CancellableContinuation;", "invokeOnCancellation", "", "segment", "Lkotlinx/coroutines/internal/Segment;", "index", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SendBroadcast implements Waiter {

        private final CancellableContinuationImpl<Boolean> $$delegate_0;
        private final CancellableContinuation<Boolean> cont;
        public SendBroadcast(CancellableContinuation<? super Boolean> cont) {
            super();
            this.cont = cont;
            Intrinsics.checkNotNull(cont, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.$$delegate_0 = (CancellableContinuationImpl)cont;
        }

        public final CancellableContinuation<Boolean> getCont() {
            return this.cont;
        }

        public void invokeOnCancellation(Segment<?> segment, int i2) {
            this.$$delegate_0.invokeOnCancellation(segment, i2);
        }
    }
    static {
        final Class<kotlinx.coroutines.channels.BufferedChannel> obj6 = BufferedChannel.class;
        BufferedChannel.sendersAndCloseStatus$FU = AtomicLongFieldUpdater.newUpdater(obj6, "sendersAndCloseStatus");
        BufferedChannel.receivers$FU = AtomicLongFieldUpdater.newUpdater(obj6, "receivers");
        BufferedChannel.bufferEnd$FU = AtomicLongFieldUpdater.newUpdater(obj6, "bufferEnd");
        BufferedChannel.completedExpandBuffersAndPauseFlag$FU = AtomicLongFieldUpdater.newUpdater(obj6, "completedExpandBuffersAndPauseFlag");
        BufferedChannel.sendSegment$FU = AtomicReferenceFieldUpdater.newUpdater(obj6, Object.class, "sendSegment");
        BufferedChannel.receiveSegment$FU = AtomicReferenceFieldUpdater.newUpdater(obj6, Object.class, "receiveSegment");
        BufferedChannel.bufferEndSegment$FU = AtomicReferenceFieldUpdater.newUpdater(obj6, Object.class, "bufferEndSegment");
        BufferedChannel._closeCause$FU = AtomicReferenceFieldUpdater.newUpdater(obj6, Object.class, "_closeCause");
        BufferedChannel.closeHandler$FU = AtomicReferenceFieldUpdater.newUpdater(obj6, Object.class, "closeHandler");
    }

    public BufferedChannel(int capacity, Function1<? super E, Unit> onUndeliveredElement) {
        int i;
        kotlinx.coroutines.channels.ChannelSegment channelSegment;
        String str;
        int anon;
        super();
        this.capacity = capacity;
        this.onUndeliveredElement = onUndeliveredElement;
        i = this.capacity >= 0 ? 1 : 0;
        if (i == 0) {
        } else {
            this.bufferEnd = BufferedChannelKt.access$initialBufferEnd(this.capacity);
            this.completedExpandBuffersAndPauseFlag = getBufferEndCounter();
            Object obj2 = this;
            ChannelSegment channelSegment2 = new ChannelSegment(0, obj4, 0, obj2, 3);
            obj2.sendSegment = channelSegment2;
            obj2.receiveSegment = channelSegment2;
            if (isRendezvousOrUnlimited()) {
                Intrinsics.checkNotNull(BufferedChannelKt.access$getNULL_SEGMENT$p(), "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
            } else {
                channelSegment = channelSegment2;
            }
            obj2.bufferEndSegment = channelSegment;
            if (obj2.onUndeliveredElement != null) {
                str = 0;
                anon = new BufferedChannel.onUndeliveredElementReceiveCancellationConstructor.1.1(this);
            } else {
                anon = 0;
            }
            obj2.onUndeliveredElementReceiveCancellationConstructor = anon;
            obj2._closeCause = BufferedChannelKt.access$getNO_CLOSE_CAUSE$p();
        }
        int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Invalid channel capacity: ").append(obj.capacity).append(", should be >=0").toString().toString());
        throw illegalArgumentException;
    }

    public BufferedChannel(int i, Function1 function12, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(i, obj2);
    }

    public static final kotlinx.coroutines.channels.ChannelSegment access$findSegmentReceive(kotlinx.coroutines.channels.BufferedChannel $this, long id, kotlinx.coroutines.channels.ChannelSegment startFrom) {
        return $this.findSegmentReceive(id, startFrom);
    }

    public static final kotlinx.coroutines.channels.ChannelSegment access$findSegmentSend(kotlinx.coroutines.channels.BufferedChannel $this, long id, kotlinx.coroutines.channels.ChannelSegment startFrom) {
        return $this.findSegmentSend(id, startFrom);
    }

    public static final Throwable access$getReceiveException(kotlinx.coroutines.channels.BufferedChannel $this) {
        return $this.getReceiveException();
    }

    public static final AtomicReferenceFieldUpdater access$getReceiveSegment$FU$p() {
        return BufferedChannel.receiveSegment$FU;
    }

    public static final AtomicLongFieldUpdater access$getReceivers$FU$p() {
        return BufferedChannel.receivers$FU;
    }

    public static final AtomicReferenceFieldUpdater access$getSendSegment$FU$p() {
        return BufferedChannel.sendSegment$FU;
    }

    public static final AtomicLongFieldUpdater access$getSendersAndCloseStatus$FU$p() {
        return BufferedChannel.sendersAndCloseStatus$FU;
    }

    public static final boolean access$isClosedForSend0(kotlinx.coroutines.channels.BufferedChannel $this, long $receiver) {
        return $this.isClosedForSend0($receiver);
    }

    public static final void access$onClosedReceiveCatchingOnNoWaiterSuspend(kotlinx.coroutines.channels.BufferedChannel $this, CancellableContinuation cont) {
        $this.onClosedReceiveCatchingOnNoWaiterSuspend(cont);
    }

    public static final void access$onClosedReceiveOnNoWaiterSuspend(kotlinx.coroutines.channels.BufferedChannel $this, CancellableContinuation cont) {
        $this.onClosedReceiveOnNoWaiterSuspend(cont);
    }

    public static final Object access$onClosedSend(kotlinx.coroutines.channels.BufferedChannel $this, Object element, Continuation $completion) {
        return $this.onClosedSend(element, $completion);
    }

    public static final void access$onClosedSendOnNoWaiterSuspend(kotlinx.coroutines.channels.BufferedChannel $this, Object element, CancellableContinuation cont) {
        $this.onClosedSendOnNoWaiterSuspend(element, cont);
    }

    public static final void access$prepareReceiverForSuspension(kotlinx.coroutines.channels.BufferedChannel $this, Waiter $receiver, kotlinx.coroutines.channels.ChannelSegment segment, int index) {
        $this.prepareReceiverForSuspension($receiver, segment, index);
    }

    public static final void access$prepareSenderForSuspension(kotlinx.coroutines.channels.BufferedChannel $this, Waiter $receiver, kotlinx.coroutines.channels.ChannelSegment segment, int index) {
        $this.prepareSenderForSuspension($receiver, segment, index);
    }

    public static final Object access$processResultSelectReceive(kotlinx.coroutines.channels.BufferedChannel $this, Object ignoredParam, Object selectResult) {
        return $this.processResultSelectReceive(ignoredParam, selectResult);
    }

    public static final Object access$processResultSelectReceiveCatching(kotlinx.coroutines.channels.BufferedChannel $this, Object ignoredParam, Object selectResult) {
        return $this.processResultSelectReceiveCatching(ignoredParam, selectResult);
    }

    public static final Object access$processResultSelectReceiveOrNull(kotlinx.coroutines.channels.BufferedChannel $this, Object ignoredParam, Object selectResult) {
        return $this.processResultSelectReceiveOrNull(ignoredParam, selectResult);
    }

    public static final Object access$processResultSelectSend(kotlinx.coroutines.channels.BufferedChannel $this, Object ignoredParam, Object selectResult) {
        return $this.processResultSelectSend(ignoredParam, selectResult);
    }

    public static final Object access$receiveCatchingOnNoWaiterSuspend-GKJJFZk(kotlinx.coroutines.channels.BufferedChannel $this, kotlinx.coroutines.channels.ChannelSegment segment, int index, long r, Continuation $completion) {
        return $this.receiveCatchingOnNoWaiterSuspend-GKJJFZk(segment, index, r, $completion);
    }

    public static final Object access$receiveOnNoWaiterSuspend(kotlinx.coroutines.channels.BufferedChannel $this, kotlinx.coroutines.channels.ChannelSegment segment, int index, long r, Continuation $completion) {
        return $this.receiveOnNoWaiterSuspend(segment, index, r, $completion);
    }

    public static final void access$registerSelectForReceive(kotlinx.coroutines.channels.BufferedChannel $this, SelectInstance select, Object ignoredParam) {
        $this.registerSelectForReceive(select, ignoredParam);
    }

    public static final Object access$sendOnNoWaiterSuspend(kotlinx.coroutines.channels.BufferedChannel $this, kotlinx.coroutines.channels.ChannelSegment segment, int index, Object element, long s, Continuation $completion) {
        return $this.sendOnNoWaiterSuspend(segment, index, element, s, $completion);
    }

    public static final Object access$updateCellReceive(kotlinx.coroutines.channels.BufferedChannel $this, kotlinx.coroutines.channels.ChannelSegment segment, int index, long r, Object waiter) {
        return $this.updateCellReceive(segment, index, r, waiter);
    }

    public static final int access$updateCellSend(kotlinx.coroutines.channels.BufferedChannel $this, kotlinx.coroutines.channels.ChannelSegment segment, int index, Object element, long s, Object waiter, boolean closed) {
        return $this.updateCellSend(segment, index, element, s, waiter, closed);
    }

    private final boolean bufferOrRendezvousSend(long curSenders) {
        int i;
        int cmp;
        long l;
        if (Long.compare(curSenders, bufferEndCounter) >= 0) {
            if (Long.compare(curSenders, i2) < 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private final void cancelSuspendedReceiveRequests(kotlinx.coroutines.channels.ChannelSegment<E> lastSegment, long sendersCounter) {
        Object suspendedReceivers;
        int i;
        Object segment;
        kotlinx.coroutines.internal.ConcurrentLinkedListNode prev;
        int i2;
        int index;
        int state$kotlinx_coroutines_core;
        int i$iv;
        long l;
        int i3 = 0;
        i = 1;
        suspendedReceivers = InlineList.constructor-impl$default(i3, i, i3);
        segment = lastSegment;
        i2 = -1;
        while (segment != null) {
            sEGMENT_SIZE -= i;
            while (i2 < index) {
                if (Long.compare(i6, sendersCounter) >= 0) {
                }
                state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
                while (state$kotlinx_coroutines_core != 0) {
                    state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                } else {
                }
                segment.onSlotCleaned();
                index--;
                if (state$kotlinx_coroutines_core == BufferedChannelKt.access$getIN_BUFFER$p()) {
                } else {
                }
                if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                } else {
                }
                if (state$kotlinx_coroutines_core instanceof Waiter) {
                } else {
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                } else {
                }
                suspendedReceivers = InlineList.plus-FjFbRPM(suspendedReceivers, state$kotlinx_coroutines_core);
                segment.onCancelledRequest(index, i);
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                } else {
                }
                suspendedReceivers = InlineList.plus-FjFbRPM(suspendedReceivers, i7.waiter);
                segment.onCancelledRequest(index, i);
            }
            segment = prev;
            i2 = -1;
            if (Long.compare(i6, sendersCounter) >= 0) {
            }
            state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            while (state$kotlinx_coroutines_core != 0) {
                state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            }
            if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
            } else {
            }
            segment.onSlotCleaned();
            index--;
            if (state$kotlinx_coroutines_core == BufferedChannelKt.access$getIN_BUFFER$p()) {
            } else {
            }
            if (state$kotlinx_coroutines_core instanceof WaiterEB) {
            } else {
            }
            if (state$kotlinx_coroutines_core instanceof Waiter) {
            } else {
            }
            if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
            } else {
            }
            suspendedReceivers = InlineList.plus-FjFbRPM(suspendedReceivers, state$kotlinx_coroutines_core);
            segment.onCancelledRequest(index, i);
            if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
            } else {
            }
            suspendedReceivers = InlineList.plus-FjFbRPM(suspendedReceivers, i7.waiter);
            segment.onCancelledRequest(index, i);
        }
        int i4 = 0;
        if (suspendedReceivers != null) {
            if (suspendedReceivers instanceof ArrayList == null) {
                i2 = 0;
                resumeReceiverOnClosedChannel((Waiter)suspendedReceivers);
            } else {
                Intrinsics.checkNotNull(suspendedReceivers, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                state$kotlinx_coroutines_core = suspendedReceivers;
                size -= i;
                while (i2 < i$iv) {
                    l = 0L;
                    resumeReceiverOnClosedChannel((Waiter)state$kotlinx_coroutines_core.get(i$iv));
                    i$iv--;
                }
            }
        }
    }

    private final kotlinx.coroutines.channels.ChannelSegment<E> closeLinkedList() {
        Object lastSegment;
        int i = 0;
        Object obj = BufferedChannel.sendSegment$FU.get(this);
        int i2 = 0;
        if (Long.compare(l, l3) > 0) {
            lastSegment = obj;
        }
        Object obj2 = BufferedChannel.receiveSegment$FU.get(this);
        int i3 = 0;
        if (Long.compare(l2, l4) > 0) {
            lastSegment = obj2;
        }
        return (ChannelSegment)ConcurrentLinkedListKt.close((ConcurrentLinkedListNode)lastSegment);
    }

    private final void completeCancel(long sendersCur) {
        removeUnprocessedElements(completeClose(sendersCur));
    }

    private final kotlinx.coroutines.channels.ChannelSegment<E> completeClose(long sendersCur) {
        boolean markAllEmptyCellsAsClosed;
        int cmp;
        final kotlinx.coroutines.channels.ChannelSegment linkedList = closeLinkedList();
        markAllEmptyCellsAsClosed = markAllEmptyCellsAsClosed(linkedList);
        if (isConflatedDropOldest() && Long.compare(markAllEmptyCellsAsClosed, i) != 0) {
            markAllEmptyCellsAsClosed = markAllEmptyCellsAsClosed(linkedList);
            if (Long.compare(markAllEmptyCellsAsClosed, i) != 0) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(markAllEmptyCellsAsClosed);
            }
        }
        cancelSuspendedReceiveRequests(linkedList, sendersCur);
        return linkedList;
    }

    private final void completeCloseOrCancel() {
        isClosedForSend();
    }

    private final void expandBuffer() {
        Object segmentBufferEnd;
        int next;
        Object obj;
        int i;
        Object segment;
        long andIncrement;
        long sendersCounter$kotlinx_coroutines_core;
        int i2;
        int i3;
        int i4;
        boolean cellExpandBuffer;
        if (isRendezvousOrUnlimited()) {
        }
        segment = segmentBufferEnd;
        andIncrement = BufferedChannel.bufferEnd$FU.getAndIncrement(this);
        i = andIncrement / l;
        i2 = 0;
        i3 = 1;
        i4 = 0;
        while (Long.compare(sendersCounter$kotlinx_coroutines_core, andIncrement) <= 0) {
            obj = this;
            BufferedChannel.incCompletedExpandBufferAttempts$default(this, i4, obj12, i3);
            andIncrement = BufferedChannel.bufferEnd$FU.getAndIncrement(this);
            i = andIncrement / l;
            i2 = 0;
            i3 = 1;
            i4 = 0;
            segmentBufferEnd = this.findSegmentBufferEnd(i, obj3, segment);
            segment = segmentBufferEnd;
        }
        if (Long.compare(l2, i) < 0 && segment.getNext() != null) {
            if (segment.getNext() != null) {
                moveSegmentBufferEndToSpecifiedOrLast(i, obj3);
            }
        }
        BufferedChannel.incCompletedExpandBufferAttempts$default(this, i4, obj12, i3);
    }

    private final kotlinx.coroutines.channels.ChannelSegment<E> findSegmentBufferEnd(long id, kotlinx.coroutines.channels.ChannelSegment<E> startFrom, long currentBufferEndCounter) {
        int sEGMENT_SIZE;
        boolean aSSERTIONS_ENABLED;
        int cmp;
        Object segmentInternal;
        int to$iv$iv;
        boolean tryIncPointers$kotlinx_coroutines_core;
        int i5;
        int i4;
        Object obj;
        Segment i2;
        int i;
        long l;
        int i3;
        final Object obj2 = this;
        final Segment segment2 = id;
        AtomicReferenceFieldUpdater bufferEndSegment$FU = BufferedChannel.bufferEndSegment$FU;
        cmp = 0;
        segmentInternal = ConcurrentLinkedListKt.findSegmentInternal((Segment)currentBufferEndCounter, segment2, obj7);
        while (!SegmentOrClosed.isClosed-impl(segmentInternal)) {
            Segment segment-impl2 = SegmentOrClosed.getSegment-impl(segmentInternal);
            i5 = 0;
            i4 = 0;
            obj = bufferEndSegment$FU.get(obj2);
            i = 0;
            while (Long.compare(l, l6) >= 0) {
                if (segment-impl2.decPointers$kotlinx_coroutines_core()) {
                }
                obj = bufferEndSegment$FU.get(obj2);
                i = 0;
                segment-impl2.remove();
            }
            if (!segment-impl2.tryIncPointers$kotlinx_coroutines_core()) {
            } else {
            }
            if (AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(bufferEndSegment$FU, obj2, (Segment)obj, segment-impl2)) {
            } else {
            }
            if (segment-impl2.decPointers$kotlinx_coroutines_core()) {
            }
            segment-impl2.remove();
            if (obj.decPointers$kotlinx_coroutines_core()) {
            }
            to$iv$iv = 1;
            if (to$iv$iv != 0) {
                break;
            } else {
            }
            segmentInternal = ConcurrentLinkedListKt.findSegmentInternal((Segment)currentBufferEndCounter, segment2, obj7);
            obj.remove();
            to$iv$iv = 0;
            to$iv$iv = 1;
        }
        Object obj3 = segmentInternal;
        final int i8 = 0;
        int i9 = 0;
        i2 = 0;
        if (SegmentOrClosed.isClosed-impl(obj3)) {
            obj2.completeCloseOrCancel();
            moveSegmentBufferEndToSpecifiedOrLast(id, startFrom);
            BufferedChannel.incCompletedExpandBufferAttempts$default(obj2, i9, i4, 1);
        } else {
            i = segment-impl;
            if (Long.compare(l2, segment2) > 0) {
                if (BufferedChannel.bufferEnd$FU.compareAndSet(obj2, i6 += obj21, cmp)) {
                    obj2.incCompletedExpandBufferAttempts(i7 -= obj21);
                } else {
                    BufferedChannel.incCompletedExpandBufferAttempts$default(obj2, i9, i4, 1);
                }
            } else {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    aSSERTIONS_ENABLED = 0;
                    i3 = Long.compare(l4, segment2) == 0 ? sEGMENT_SIZE : 0;
                    if (i3 == 0) {
                    } else {
                    }
                    AssertionError assertionError = new AssertionError();
                    throw assertionError;
                }
                i2 = i;
            }
        }
        return i2;
    }

    private final kotlinx.coroutines.channels.ChannelSegment<E> findSegmentReceive(long id, kotlinx.coroutines.channels.ChannelSegment<E> startFrom) {
        Segment segment;
        int segment-impl;
        boolean aSSERTIONS_ENABLED;
        int i3;
        boolean rendezvousOrUnlimited;
        int cmp;
        int i2;
        Object segmentInternal;
        Segment sendersCounter$kotlinx_coroutines_core;
        long l;
        int i5;
        int tryIncPointers$kotlinx_coroutines_core;
        int i4;
        Object obj;
        int i;
        segment = id;
        final Object obj2 = obj17;
        AtomicReferenceFieldUpdater receiveSegment$FU = BufferedChannel.receiveSegment$FU;
        i2 = 0;
        segmentInternal = ConcurrentLinkedListKt.findSegmentInternal((Segment)obj2, segment, obj1);
        while (!SegmentOrClosed.isClosed-impl(segmentInternal)) {
            sendersCounter$kotlinx_coroutines_core = SegmentOrClosed.getSegment-impl(segmentInternal);
            tryIncPointers$kotlinx_coroutines_core = 0;
            i4 = 0;
            obj = receiveSegment$FU.get(this);
            i = 0;
            while (Long.compare(l, l2) >= 0) {
                if (sendersCounter$kotlinx_coroutines_core.decPointers$kotlinx_coroutines_core()) {
                }
                segment = id;
                obj = receiveSegment$FU.get(this);
                i = 0;
                sendersCounter$kotlinx_coroutines_core.remove();
            }
            if (!sendersCounter$kotlinx_coroutines_core.tryIncPointers$kotlinx_coroutines_core()) {
            } else {
            }
            if (AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(receiveSegment$FU, this, (Segment)obj, sendersCounter$kotlinx_coroutines_core)) {
            } else {
            }
            if (sendersCounter$kotlinx_coroutines_core.decPointers$kotlinx_coroutines_core()) {
            }
            segment = id;
            sendersCounter$kotlinx_coroutines_core.remove();
            if (obj.decPointers$kotlinx_coroutines_core()) {
            }
            segment = 1;
            if (segment != 0) {
                break;
            } else {
            }
            segment = id;
            segmentInternal = ConcurrentLinkedListKt.findSegmentInternal((Segment)obj2, segment, obj1);
            obj.remove();
            segment = 0;
            segment = 1;
        }
        int i6 = 0;
        i3 = 0;
        if (SegmentOrClosed.isClosed-impl(segmentInternal)) {
            completeCloseOrCancel();
            if (Long.compare(cmp, sendersCounter$kotlinx_coroutines_core) < 0) {
                obj2.cleanPrev();
            }
        } else {
            segment-impl = SegmentOrClosed.getSegment-impl(segmentInternal);
            if (!isRendezvousOrUnlimited() && Long.compare(id, i7) <= 0) {
                if (Long.compare(id, i7) <= 0) {
                    rendezvousOrUnlimited = BufferedChannel.bufferEndSegment$FU;
                    i2 = 0;
                    sendersCounter$kotlinx_coroutines_core = 0;
                    l = rendezvousOrUnlimited.get(this);
                    i5 = 0;
                    while (Long.compare(l10, obj) < 0) {
                        if ((Segment)segment-impl.tryIncPointers$kotlinx_coroutines_core()) {
                            break;
                        }
                        if (AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(rendezvousOrUnlimited, this, (Segment)l, (Segment)segment-impl)) {
                            break;
                        } else {
                        }
                        if ((Segment)segment-impl.decPointers$kotlinx_coroutines_core()) {
                        }
                        l = rendezvousOrUnlimited.get(this);
                        i5 = 0;
                        (Segment)segment-impl.remove();
                    }
                }
            }
            if (Long.compare(atomicfu$handler$iv, id) > 0) {
                updateReceiversCounterIfLower(l4 *= l8);
                if (Long.compare(i9, sendersCounter$kotlinx_coroutines_core) < 0) {
                    segment-impl.cleanPrev();
                }
            } else {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    aSSERTIONS_ENABLED = 0;
                    l = Long.compare(l6, id) == 0 ? 1 : 0;
                    if (l == 0) {
                    } else {
                    }
                    AssertionError assertionError = new AssertionError();
                    throw assertionError;
                }
                i3 = segment-impl;
            }
        }
        return i3;
    }

    private final kotlinx.coroutines.channels.ChannelSegment<E> findSegmentSend(long id, kotlinx.coroutines.channels.ChannelSegment<E> startFrom) {
        Segment segment;
        int segment-impl;
        boolean aSSERTIONS_ENABLED;
        int i;
        int cmp;
        Object segmentInternal;
        Segment receiversCounter$kotlinx_coroutines_core;
        long l;
        int i3;
        int i4;
        Object obj;
        int i2;
        segment = id;
        final Object obj2 = obj17;
        AtomicReferenceFieldUpdater sendSegment$FU = BufferedChannel.sendSegment$FU;
        segmentInternal = ConcurrentLinkedListKt.findSegmentInternal((Segment)obj2, segment, obj1);
        while (!SegmentOrClosed.isClosed-impl(segmentInternal)) {
            receiversCounter$kotlinx_coroutines_core = SegmentOrClosed.getSegment-impl(segmentInternal);
            i3 = 0;
            i4 = 0;
            obj = sendSegment$FU.get(this);
            i2 = 0;
            while (Long.compare(l, l2) >= 0) {
                if (receiversCounter$kotlinx_coroutines_core.decPointers$kotlinx_coroutines_core()) {
                }
                segment = id;
                obj = sendSegment$FU.get(this);
                i2 = 0;
                receiversCounter$kotlinx_coroutines_core.remove();
            }
            if (!receiversCounter$kotlinx_coroutines_core.tryIncPointers$kotlinx_coroutines_core()) {
            } else {
            }
            if (AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(sendSegment$FU, this, (Segment)obj, receiversCounter$kotlinx_coroutines_core)) {
            } else {
            }
            if (receiversCounter$kotlinx_coroutines_core.decPointers$kotlinx_coroutines_core()) {
            }
            segment = id;
            receiversCounter$kotlinx_coroutines_core.remove();
            if (obj.decPointers$kotlinx_coroutines_core()) {
            }
            segment = 1;
            if (segment != 0) {
                break;
            } else {
            }
            segment = id;
            segmentInternal = ConcurrentLinkedListKt.findSegmentInternal((Segment)obj2, segment, obj1);
            obj.remove();
            segment = 0;
            segment = 1;
        }
        int i5 = 0;
        i = 0;
        if (SegmentOrClosed.isClosed-impl(segmentInternal)) {
            completeCloseOrCancel();
            if (Long.compare(cmp, receiversCounter$kotlinx_coroutines_core) < 0) {
                obj2.cleanPrev();
            }
        } else {
            segment-impl = SegmentOrClosed.getSegment-impl(segmentInternal);
            if (Long.compare(l4, id) > 0) {
                updateSendersCounterIfLower(l5 *= l9);
                if (Long.compare(i7, receiversCounter$kotlinx_coroutines_core) < 0) {
                    (ChannelSegment)segment-impl.cleanPrev();
                }
            } else {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    aSSERTIONS_ENABLED = 0;
                    l = Long.compare(l7, id) == 0 ? 1 : 0;
                    if (l == 0) {
                    } else {
                    }
                    AssertionError assertionError = new AssertionError();
                    throw assertionError;
                }
                i = segment-impl;
            }
        }
        return i;
    }

    private final Object getAndUpdate$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, ? extends Object> function12, Object object3) {
        Object obj;
        boolean z;
        final int i = 0;
        obj = atomicReferenceFieldUpdater.get(object3);
        while (AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(atomicReferenceFieldUpdater, object3, obj, function12.invoke(obj))) {
            obj = atomicReferenceFieldUpdater.get(object3);
        }
        return obj;
    }

    private final long getBufferEndCounter() {
        return BufferedChannel.bufferEnd$FU.get(this);
    }

    public static void getOnReceive$annotations() {
    }

    public static void getOnReceiveCatching$annotations() {
    }

    public static void getOnReceiveOrNull$annotations() {
    }

    public static void getOnSend$annotations() {
    }

    private static void getOnUndeliveredElementReceiveCancellationConstructor$annotations() {
    }

    private final Throwable getReceiveException() {
        Object closedReceiveChannelException;
        String str;
        if (getCloseCause() == null) {
            closedReceiveChannelException = new ClosedReceiveChannelException("Channel was closed");
        }
        return closedReceiveChannelException;
    }

    private final void incCompletedExpandBufferAttempts(long nAttempts) {
        int $this$ebPauseExpandBuffers$iv;
        int i;
        int cmp;
        int i2;
        final Object obj = this;
        int i3 = 0;
        i = 0;
        final long l4 = 4611686018427387904L;
        final int i6 = 0;
        final int i5 = 1;
        final int i7 = 0;
        $this$ebPauseExpandBuffers$iv = Long.compare(i4, i6) != 0 ? i5 : i7;
        if ($this$ebPauseExpandBuffers$iv != 0) {
        }
    }

    static void incCompletedExpandBufferAttempts$default(kotlinx.coroutines.channels.BufferedChannel bufferedChannel, long l2, int i3, Object object4) {
        int obj1;
        if (obj4 != null) {
        } else {
            if (object4 &= 1 != 0) {
                obj1 = 1;
            }
            bufferedChannel.incCompletedExpandBufferAttempts(obj1);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        throw obj0;
    }

    private final void invokeCloseHandler() {
        Object obj;
        boolean z;
        int i;
        kotlinx.coroutines.internal.Symbol symbol;
        AtomicReferenceFieldUpdater closeHandler$FU = BufferedChannel.closeHandler$FU;
        Object obj3 = this;
        final int i3 = 0;
        obj = closeHandler$FU.get(this);
        i = 0;
        do {
            obj = closeHandler$FU.get(this);
            i = 0;
            symbol = BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p();
            if (!AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(closeHandler$FU, this, obj, symbol)) {
            }
            symbol = BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p();
        } while (obj == null);
        if (obj == null) {
        }
        Object beforeCheckcastToFunctionOfArity = TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1);
        (Function1)obj.invoke(getCloseCause());
    }

    private final boolean isCellNonEmpty(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, long globalIndex) {
        Object state$kotlinx_coroutines_core;
        int i;
        boolean casState$kotlinx_coroutines_core;
        state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        i = 0;
        while (state$kotlinx_coroutines_core != null) {
            state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            i = 0;
        }
        final int i2 = 1;
        if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
            return i2;
        }
        if (state$kotlinx_coroutines_core == BufferedChannelKt.access$getINTERRUPTED_SEND$p()) {
            return i;
        }
        if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
            return i;
        }
        if (state$kotlinx_coroutines_core == BufferedChannelKt.access$getDONE_RCV$p()) {
            return i;
        }
        if (state$kotlinx_coroutines_core == BufferedChannelKt.access$getPOISONED$p()) {
            return i;
        }
        if (state$kotlinx_coroutines_core == BufferedChannelKt.access$getRESUMING_BY_EB$p()) {
            return i2;
        }
        if (state$kotlinx_coroutines_core == BufferedChannelKt.access$getRESUMING_BY_RCV$p()) {
            return i;
        }
        if (Long.compare(globalIndex, receiversCounter$kotlinx_coroutines_core) == 0) {
            i = i2;
        }
        return i;
    }

    private final boolean isClosed(long sendersAndCloseStatusCur, boolean isClosedForReceive) {
        int $this$sendersCloseStatus$iv;
        int i;
        int i3;
        int i2;
        final int i8 = 0;
        final int i9 = 60;
        long l = 1152921504606846975L;
        i = 1;
        i3 = 0;
        switch ($this$sendersCloseStatus$iv) {
            case 0:
                i = i3;
                break;
            case 1:
                i = i3;
                break;
            case 2:
                int i5 = 0;
                completeClose(i2 & l);
                i = i3;
                break;
            case 3:
                int i6 = 0;
                completeCancel(i3 & l);
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                int i11 = 0;
                IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("unexpected close status: ").append((int)i12).toString().toString());
                throw illegalStateException;
        }
        return i;
    }

    public static void isClosedForReceive$annotations() {
    }

    private final boolean isClosedForReceive0(long $this$isClosedForReceive0) {
        return isClosed($this$isClosedForReceive0, obj3);
    }

    public static void isClosedForSend$annotations() {
    }

    private final boolean isClosedForSend0(long $this$isClosedForSend0) {
        return isClosed($this$isClosedForSend0, obj3);
    }

    public static void isEmpty$annotations() {
    }

    private final boolean isRendezvousOrUnlimited() {
        int i;
        int cmp;
        final long bufferEndCounter = getBufferEndCounter();
        final int i2 = 0;
        if (Long.compare(bufferEndCounter, i3) != 0) {
            if (Long.compare(bufferEndCounter, l) == 0) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    private final void loop$atomicfu(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Unit> function12, Object object3) {
        Long valueOf;
        final int i = 0;
        while (true) {
            function12.invoke(Long.valueOf(atomicLongFieldUpdater.get(object3)));
        }
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function12, Object object3) {
        Object obj;
        final int i = 0;
        while (true) {
            function12.invoke(atomicReferenceFieldUpdater.get(object3));
        }
    }

    private final long markAllEmptyCellsAsClosed(kotlinx.coroutines.channels.ChannelSegment<E> lastSegment) {
        Object segment;
        kotlinx.coroutines.internal.ConcurrentLinkedListNode prev;
        int index;
        int state$kotlinx_coroutines_core;
        boolean casState$kotlinx_coroutines_core;
        int i;
        int cmp;
        segment = lastSegment;
        while (/* condition */) {
            state$kotlinx_coroutines_core = -1;
            while (-1 < index) {
                i2 += l3;
                if (Long.compare(i, receiversCounter$kotlinx_coroutines_core) >= 0) {
                }
                state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
                while (state$kotlinx_coroutines_core != 0) {
                    state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
                }
                segment.onSlotCleaned();
                index--;
                state$kotlinx_coroutines_core = -1;
            }
            prev = segment.getPrev();
            segment = prev;
            sEGMENT_SIZE--;
            i2 += l3;
            if (Long.compare(i, receiversCounter$kotlinx_coroutines_core) >= 0) {
            }
            state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            while (state$kotlinx_coroutines_core != 0) {
                state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            }
            segment.onSlotCleaned();
            index--;
        }
        return state$kotlinx_coroutines_core;
    }

    private final void markCancellationStarted() {
        Object $i$a$Update$atomicfuBufferedChannel$markCancellationStarted$1;
        boolean compareAndSet;
        long cur;
        long l;
        int $i$f$getSendersCounter;
        long l2;
        final AtomicLongFieldUpdater sendersAndCloseStatus$FU = BufferedChannel.sendersAndCloseStatus$FU;
        final Object obj = this;
        final int i2 = 0;
        long l3 = sendersAndCloseStatus$FU.get(this);
        long l4 = l3;
        int i = 0;
        int i3 = 0;
        while ((int)i6 == 0) {
            int i4 = 0;
            l3 = sendersAndCloseStatus$FU.get(this);
            l4 = l3;
            i = 0;
            i3 = 0;
        }
    }

    private final void markCancelled() {
        Object $i$a$Update$atomicfuBufferedChannel$markCancelled$1;
        boolean compareAndSet;
        long cur;
        int $this$sendersCounter$iv;
        int $i$f$getSendersCounter;
        long l;
        final AtomicLongFieldUpdater sendersAndCloseStatus$FU = BufferedChannel.sendersAndCloseStatus$FU;
        final Object obj = this;
        final int i2 = 0;
        long l2 = sendersAndCloseStatus$FU.get(this);
        int i = 0;
        int i3 = 0;
        while (sendersAndCloseStatus$FU.compareAndSet(this, l2, obj3)) {
            l2 = sendersAndCloseStatus$FU.get(this);
            i = 0;
            i3 = 0;
        }
    }

    private final void markClosed() {
        Object $i$a$Update$atomicfuBufferedChannel$markClosed$1;
        boolean compareAndSet;
        long cur;
        long l;
        long l3;
        int i;
        long l2;
        final AtomicLongFieldUpdater sendersAndCloseStatus$FU = BufferedChannel.sendersAndCloseStatus$FU;
        final Object obj2 = this;
        final int i3 = 0;
        while (/* condition */) {
            int i5 = 0;
            l = BufferedChannelKt.access$constructSendersAndCloseStatus(l2 & l3, l3);
            long l4 = sendersAndCloseStatus$FU.get(this);
            long l5 = l4;
            int i2 = 0;
            int i6 = 0;
            l3 = 1152921504606846975L;
            int i4 = 0;
            l = BufferedChannelKt.access$constructSendersAndCloseStatus(l2 & l3, l3);
        }
    }

    private final void moveSegmentBufferEndToSpecifiedOrLast(long id, kotlinx.coroutines.channels.ChannelSegment<E> startFrom) {
        Object segment;
        kotlinx.coroutines.internal.ConcurrentLinkedListNode bufferEndSegment$FU;
        int i4;
        int i3;
        Object obj;
        int i;
        int tryIncPointers$kotlinx_coroutines_core;
        int i2;
        long l;
        segment = obj13;
        while (Long.compare(l2, id) < 0) {
            bufferEndSegment$FU = segment.getNext();
            if ((ChannelSegment)bufferEndSegment$FU == null) {
                break;
            } else {
            }
            segment = bufferEndSegment$FU;
        }
        do {
            while (segment.isRemoved()) {
                bufferEndSegment$FU = segment.getNext();
                if ((ChannelSegment)bufferEndSegment$FU == 0) {
                    break loop_6;
                } else {
                }
                segment = bufferEndSegment$FU;
            }
            bufferEndSegment$FU = BufferedChannel.bufferEndSegment$FU;
            i4 = 0;
            i3 = 0;
            obj = bufferEndSegment$FU.get(this);
            i = 0;
            i2 = 1;
            while (Long.compare(l3, l) >= 0) {
                if ((Segment)segment.decPointers$kotlinx_coroutines_core()) {
                }
                obj = bufferEndSegment$FU.get(this);
                i = 0;
                i2 = 1;
                (Segment)segment.remove();
            }
            if (!(Segment)segment.tryIncPointers$kotlinx_coroutines_core()) {
            } else {
            }
            if (AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(bufferEndSegment$FU, this, (Segment)obj, (Segment)segment)) {
            } else {
            }
            if ((Segment)segment.decPointers$kotlinx_coroutines_core()) {
            }
            (Segment)segment.remove();
            if (obj.decPointers$kotlinx_coroutines_core()) {
            }
            if (i2 == 0) {
            }
            obj.remove();
            i2 = 0;
            bufferEndSegment$FU = segment.getNext();
            if ((ChannelSegment)(ChannelSegment)bufferEndSegment$FU == 0) {
            } else {
            }
            segment = bufferEndSegment$FU;
        } while (/* condition */);
    }

    private final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> cont) {
        kotlin.Result.Companion companion = Result.Companion;
        (Continuation)cont.resumeWith(Result.constructor-impl(ChannelResult.box-impl(ChannelResult.Companion.closed-JP2dKIU(getCloseCause()))));
    }

    private final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation<? super E> cont) {
        kotlin.Result.Companion companion = Result.Companion;
        (Continuation)cont.resumeWith(Result.constructor-impl(ResultKt.createFailure(getReceiveException())));
    }

    private final void onClosedSelectOnReceive(SelectInstance<?> select) {
        select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final void onClosedSelectOnSend(E element, SelectInstance<?> select) {
        kotlin.coroutines.CoroutineContext context;
        Function1 onUndeliveredElement = this.onUndeliveredElement;
        if (onUndeliveredElement != null) {
            OnUndeliveredElementKt.callUndeliveredElement(onUndeliveredElement, element, select.getContext());
        }
        select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final Object onClosedSend(E element, Continuation<? super Unit> $completion) {
        Object it;
        int sendException;
        int i;
        CancellableContinuationImpl cancellableContinuationImpl;
        int i2;
        int constructor-impl;
        Object constructor-impl2;
        boolean rECOVER_STACK_TRACES2;
        Throwable th;
        boolean rECOVER_STACK_TRACES;
        CancellableContinuationImpl cancellableContinuationImpl2;
        int i3 = 0;
        int i4 = 0;
        CancellableContinuationImpl cancellableContinuationImpl3 = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl3.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl4 = cancellableContinuationImpl3;
        int i6 = 0;
        it = this.onUndeliveredElement;
        i2 = 0;
        it = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(it, element, i2, 2, i2);
        if (it != null && it != null) {
            i2 = 0;
            it = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(it, element, i2, 2, i2);
            if (it != null) {
                sendException = 0;
                ExceptionsKt.addSuppressed((Throwable)it, getSendException());
                cancellableContinuationImpl = cancellableContinuationImpl4;
                constructor-impl = 0;
                kotlin.Result.Companion companion2 = Result.Companion;
                int i8 = 0;
                if (DebugKt.getRECOVER_STACK_TRACES()) {
                    if (!cancellableContinuationImpl instanceof CoroutineStackFrame) {
                        th = it;
                    } else {
                        th = StackTraceRecoveryKt.access$recoverFromStackFrame((Throwable)it, (CoroutineStackFrame)(Continuation)cancellableContinuationImpl);
                    }
                } else {
                }
                cancellableContinuationImpl.resumeWith(Result.constructor-impl(ResultKt.createFailure(th)));
            } else {
                it = cancellableContinuationImpl4;
                sendException = getSendException();
                cancellableContinuationImpl = 0;
                kotlin.Result.Companion companion = Result.Companion;
                int i7 = 0;
                if (DebugKt.getRECOVER_STACK_TRACES()) {
                    if (!it instanceof CoroutineStackFrame) {
                        constructor-impl2 = sendException;
                    } else {
                        constructor-impl2 = StackTraceRecoveryKt.access$recoverFromStackFrame(sendException, (CoroutineStackFrame)(Continuation)it);
                    }
                } else {
                }
                it.resumeWith(Result.constructor-impl(ResultKt.createFailure(constructor-impl2)));
            }
        } else {
        }
        Object uCont$iv = cancellableContinuationImpl3.getResult();
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return uCont$iv;
        }
        return Unit.INSTANCE;
    }

    private final void onClosedSendOnNoWaiterSuspend(E element, CancellableContinuation<? super Unit> cont) {
        kotlin.coroutines.CoroutineContext context;
        Throwable exception$iv;
        boolean rECOVER_STACK_TRACES;
        Function1 onUndeliveredElement = this.onUndeliveredElement;
        if (onUndeliveredElement != null) {
            OnUndeliveredElementKt.callUndeliveredElement(onUndeliveredElement, element, cont.getContext());
        }
        int i = 0;
        if (DebugKt.getRECOVER_STACK_TRACES()) {
            if (!obj2 instanceof CoroutineStackFrame) {
            } else {
                exception$iv = rECOVER_STACK_TRACES;
            }
        }
        kotlin.Result.Companion $i$f$recoverStackTrace = Result.Companion;
        (Continuation)cont.resumeWith(Result.constructor-impl(ResultKt.createFailure(exception$iv)));
    }

    private final void prepareReceiverForSuspension(Waiter $this$prepareReceiverForSuspension, kotlinx.coroutines.channels.ChannelSegment<E> segment, int index) {
        onReceiveEnqueued();
        $this$prepareReceiverForSuspension.invokeOnCancellation((Segment)segment, index);
    }

    private final void prepareSenderForSuspension(Waiter $this$prepareSenderForSuspension, kotlinx.coroutines.channels.ChannelSegment<E> segment, int index) {
        $this$prepareSenderForSuspension.invokeOnCancellation((Segment)segment, sEGMENT_SIZE += index);
    }

    private final Object processResultSelectReceive(Object ignoredParam, Object selectResult) {
        if (selectResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
        } else {
            return selectResult;
        }
        throw getReceiveException();
    }

    private final Object processResultSelectReceiveCatching(Object ignoredParam, Object selectResult) {
        Object success-JP2dKIU;
        Throwable closeCause;
        if (selectResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
            success-JP2dKIU = ChannelResult.Companion.closed-JP2dKIU(getCloseCause());
        } else {
            success-JP2dKIU = ChannelResult.Companion.success-JP2dKIU(selectResult);
        }
        return ChannelResult.box-impl(success-JP2dKIU);
    }

    private final Object processResultSelectReceiveOrNull(Object ignoredParam, Object selectResult) {
        int i;
        if (selectResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
            if (getCloseCause() != null) {
            } else {
                i = 0;
                return i;
            }
            throw getReceiveException();
        }
        i = selectResult;
    }

    private final Object processResultSelectSend(Object ignoredParam, Object selectResult) {
        if (selectResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
        } else {
            return this;
        }
        throw getSendException();
    }

    static <E> Object receive$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> $this, Continuation<? super E> $completion) {
        Object segment$iv;
        int i;
        long andIncrement;
        int i2;
        Object cmp;
        int cmp2;
        final Object obj = $this;
        final int i4 = 0;
        segment$iv = BufferedChannel.access$getReceiveSegment$FU$p().get(obj);
        while (!obj.isClosedForReceive()) {
            andIncrement = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(obj);
            i2 = andIncrement / l;
            i = (int)i5;
            cmp = BufferedChannel.access$updateCellReceive(obj, segment$iv, i, andIncrement, obj4);
            if (Long.compare(andIncrement, sendersCounter$kotlinx_coroutines_core) < 0) {
            }
            segment$iv.cleanPrev();
            cmp = BufferedChannel.access$findSegmentReceive(obj, i2, obj8);
            segment$iv = cmp;
        }
        int i$iv = 0;
        throw StackTraceRecoveryKt.recoverStackTrace($this.getReceiveException());
    }

    static <E> Object receiveCatching-JP2dKIU$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> bufferedChannel, Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> continuation2) {
        boolean anon;
        int i;
        Object $i$a$ReceiveImplBufferedChannel$receiveCatching$5;
        int i3;
        Object $this;
        int updCellResult$iv;
        Object segment$iv;
        int closeCause;
        long andIncrement;
        int i2;
        int id$iv;
        kotlinx.coroutines.internal.Symbol symbol;
        long cmp;
        int i4;
        int obj13;
        Object obj14;
        anon = continuation2;
        updCellResult$iv = Integer.MIN_VALUE;
        if (continuation2 instanceof BufferedChannel.receiveCatching.1 && label &= updCellResult$iv != 0) {
            anon = continuation2;
            updCellResult$iv = Integer.MIN_VALUE;
            if (label &= updCellResult$iv != 0) {
                anon.label = obj14 -= updCellResult$iv;
            } else {
                anon = new BufferedChannel.receiveCatching.1(bufferedChannel, continuation2);
            }
        } else {
        }
        final kotlinx.coroutines.channels.BufferedChannel.receiveCatching.1 buf = anon;
        obj14 = buf.result;
        Object cOROUTINE_SUSPENDED = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label2) {
            case 0:
                ResultKt.throwOnFailure(obj14);
                $this = bufferedChannel;
                i2 = $this;
                obj13 = 0;
                segment$iv = BufferedChannel.access$getReceiveSegment$FU$p().get(i2);
                int i5 = 0;
                $i$a$ReceiveImplBufferedChannel$receiveCatching$5 = ChannelResult.Companion.closed-JP2dKIU($this.getCloseCause());
                andIncrement = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(i2);
                id$iv = andIncrement / l;
                closeCause = (int)i9;
                cmp = BufferedChannel.access$findSegmentReceive(i2, id$iv, symbol);
                id$iv = segment$iv;
                id$iv = segment$iv;
                updCellResult$iv = BufferedChannel.access$updateCellReceive(i2, id$iv, closeCause, andIncrement, obj11);
                id$iv.cleanPrev();
                segment$iv = id$iv;
                buf.label = 1;
                return cOROUTINE_SUSPENDED;
                i = i2;
                id$iv.cleanPrev();
                int i7 = 0;
                $i$a$ReceiveImplBufferedChannel$receiveCatching$5 = $this;
                return $i$a$ReceiveImplBufferedChannel$receiveCatching$5;
                int i6 = 0;
                IllegalStateException illegalStateException = new IllegalStateException("unexpected".toString());
                throw illegalStateException;
            case 1:
                obj13 = 0;
                i = 0;
                ResultKt.throwOnFailure(obj14);
                $this = (ChannelResult)obj14.unbox-impl();
                break;
            default:
                obj13 = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw obj13;
        }
        $i$a$ReceiveImplBufferedChannel$receiveCatching$5 = $this;
    }

    private final Object receiveCatchingOnNoWaiterSuspend-GKJJFZk(kotlinx.coroutines.channels.ChannelSegment<E> channelSegment, int i2, long l3, Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> continuation4) {
        Object obj;
        int i6;
        boolean anon;
        int i10;
        kotlinx.coroutines.channels.BufferedChannel buf;
        Object result;
        kotlinx.coroutines.channels.ReceiveCatching _this;
        int i8;
        Object cOROUTINE_SUSPENDED;
        int cmp;
        long j$0;
        int segment$iv$iv;
        Object onUndeliveredElement;
        Object context;
        int i5;
        CancellableContinuationImpl cancellableContinuationImpl;
        int i11;
        CancellableContinuationImpl orCreateCancellableContinuation;
        int i9;
        kotlinx.coroutines.channels.ReceiveCatching receiveCatching;
        kotlinx.coroutines.internal.Symbol bindCancellationFun;
        int i7;
        long andIncrement;
        int i;
        int i3;
        int i4;
        Object obj21;
        Object obj22;
        int obj23;
        long obj24;
        Object obj26;
        obj = obj26;
        anon = obj;
        i8 = Integer.MIN_VALUE;
        if (obj instanceof BufferedChannel.receiveCatchingOnNoWaiterSuspend.1 && label2 &= i8 != 0) {
            anon = obj;
            i8 = Integer.MIN_VALUE;
            if (label2 &= i8 != 0) {
                anon.label = label -= i8;
                buf = this;
            } else {
                anon = new BufferedChannel.receiveCatchingOnNoWaiterSuspend.1(this, obj);
            }
        } else {
        }
        cOROUTINE_SUSPENDED = anon.result;
        Object cOROUTINE_SUSPENDED2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (label3) {
            case 0:
                ResultKt.throwOnFailure(cOROUTINE_SUSPENDED);
                _this = this;
                int i15 = i2;
                Object obj2 = channelSegment;
                long l = l3;
                anon.L$0 = _this;
                anon.L$1 = obj2;
                anon.I$0 = i15;
                anon.J$0 = l;
                anon.label = 1;
                i11 = 0;
                orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted((Continuation)anon));
                cancellableContinuationImpl = orCreateCancellableContinuation;
                i9 = 0;
                Intrinsics.checkNotNull(cancellableContinuationImpl, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel.receiveCatchingOnNoWaiterSuspend_GKJJFZk$lambda$35>>");
                receiveCatching = new ReceiveCatching(cancellableContinuationImpl);
                i7 = 0;
                obj23 = i15;
                obj22 = obj2;
                obj24 = l;
                obj21 = obj3;
                j$0 = BufferedChannel.access$updateCellReceive(obj21, obj22, obj23, obj24, continuation4);
                context = obj21;
                onUndeliveredElement = obj22;
                BufferedChannel.access$prepareReceiverForSuspension(context, (Waiter)receiveCatching, onUndeliveredElement, obj23);
                i3 = cOROUTINE_SUSPENDED;
                i = i7;
                onUndeliveredElement.cleanPrev();
                j$0 = 0;
                segment$iv$iv = BufferedChannel.access$getReceiveSegment$FU$p().get(context);
                segment$iv$iv = 0;
                BufferedChannel.access$onClosedReceiveCatchingOnNoWaiterSuspend(_this, (CancellableContinuation)cancellableContinuationImpl);
                i3 = cOROUTINE_SUSPENDED;
                i = i7;
                andIncrement = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(context);
                i = i7;
                bindCancellationFun = andIncrement / l2;
                i3 = cOROUTINE_SUSPENDED;
                i4 = j$0;
                obj23 = i14;
                cmp = BufferedChannel.access$findSegmentReceive(context, bindCancellationFun, i7);
                i7 = i;
                cOROUTINE_SUSPENDED = i3;
                j$0 = i4;
                segment$iv$iv = cmp;
                cOROUTINE_SUSPENDED = BufferedChannel.access$updateCellReceive(context, segment$iv$iv, obj23, andIncrement, continuation4);
                bindCancellationFun = receiveCatching;
                bindCancellationFun = 0;
                BufferedChannel.access$prepareReceiverForSuspension(context, bindCancellationFun, segment$iv$iv, obj23);
                _this = 0;
                segment$iv$iv.cleanPrev();
                i7 = i;
                cOROUTINE_SUSPENDED = i3;
                j$0 = i4;
                segment$iv$iv.cleanPrev();
                j$0 = 0;
                onUndeliveredElement = _this.onUndeliveredElement;
                bindCancellationFun = OnUndeliveredElementKt.bindCancellationFun(onUndeliveredElement, cOROUTINE_SUSPENDED, cancellableContinuationImpl.getContext());
                bindCancellationFun = 0;
                cancellableContinuationImpl.resume(ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(cOROUTINE_SUSPENDED)), bindCancellationFun);
                int i12 = 0;
                IllegalStateException illegalStateException2 = new IllegalStateException("unexpected".toString());
                throw illegalStateException2;
                i3 = cOROUTINE_SUSPENDED;
                i = i7;
                onUndeliveredElement.cleanPrev();
                cOROUTINE_SUSPENDED = 0;
                onUndeliveredElement = _this.onUndeliveredElement;
                bindCancellationFun = OnUndeliveredElementKt.bindCancellationFun(onUndeliveredElement, j$0, cancellableContinuationImpl.getContext());
                bindCancellationFun = 0;
                cancellableContinuationImpl.resume(ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(j$0)), bindCancellationFun);
                result = orCreateCancellableContinuation.getResult();
                DebugProbesKt.probeCoroutineSuspended((Continuation)anon);
                return cOROUTINE_SUSPENDED2;
                i6 = i5;
                break;
            case 1:
                i6 = 0;
                j$0 = anon.J$0;
                int i$0 = anon.I$0;
                Object l$1 = anon.L$1;
                Object l$0 = anon.L$0;
                ResultKt.throwOnFailure(cOROUTINE_SUSPENDED);
                i3 = result;
                break;
            default:
                IllegalStateException illegalStateException = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                throw illegalStateException;
        }
        return (ChannelResult)result.unbox-impl();
    }

    private final <R> R receiveImpl(Object waiter, Function1<? super E, ? extends R> onElementRetrieved, Function3<? super kotlinx.coroutines.channels.ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> onSuspend, Function0<? extends R> onClosed, Function3<? super kotlinx.coroutines.channels.ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> onNoWaiterSuspend) {
        Object obj2;
        Object segment;
        int i2;
        long andIncrement;
        Object cmp;
        int i;
        long l;
        int cmp2;
        int obj3;
        Object obj;
        Object invoke;
        Object obj4;
        Object obj5;
        final int i3 = 0;
        segment = BufferedChannel.access$getReceiveSegment$FU$p().get(this);
        while (isClosedForReceive()) {
            andIncrement = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(this);
            i = andIncrement / l2;
            i2 = (int)i4;
            l = BufferedChannel.access$updateCellReceive(this, segment, i2, andIncrement, obj4);
            obj4 = onSuspend;
            if (Long.compare(andIncrement, sendersCounter$kotlinx_coroutines_core) < 0) {
            }
            segment.cleanPrev();
            cmp = BufferedChannel.access$findSegmentReceive(this, i, obj8);
            segment = cmp;
        }
        return onClosed.invoke();
    }

    static Object receiveImpl$default(kotlinx.coroutines.channels.BufferedChannel $this, Object waiter, Function1 onElementRetrieved, Function3 onSuspend, Function0 onClosed, Function3 onNoWaiterSuspend, int i7, Object object8) {
        Object obj2;
        int iNSTANCE;
        Object segment;
        int i;
        long andIncrement;
        Object cmp;
        kotlinx.coroutines.channels.BufferedChannel.receiveImpl.1 buf;
        int i3;
        Object obj;
        int cmp2;
        int obj3;
        int i2;
        Object invoke;
        Object obj5;
        if (object8 != null) {
        } else {
            if (i7 & 16 != 0) {
                buf = iNSTANCE;
            } else {
                buf = onNoWaiterSuspend;
            }
            final int i4 = 0;
            segment = BufferedChannel.access$getReceiveSegment$FU$p().get($this);
            while ($this.isClosedForReceive()) {
                andIncrement = BufferedChannel.access$getReceivers$FU$p().getAndIncrement($this);
                i3 = andIncrement / l;
                i = (int)i5;
                obj = BufferedChannel.access$updateCellReceive($this, segment, i, andIncrement, obj4);
                obj5 = onSuspend;
                if (Long.compare(andIncrement, sendersCounter$kotlinx_coroutines_core) < 0) {
                }
                segment.cleanPrev();
                cmp = BufferedChannel.access$findSegmentReceive($this, i3, obj9);
                segment = cmp;
            }
            return onClosed.invoke();
        }
        int obj4 = onElementRetrieved;
        Object obj6 = onSuspend;
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
        throw unsupportedOperationException;
    }

    private final void receiveImplOnNoWaiter(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, long r, Waiter waiter, Function1<? super E, Unit> onElementRetrieved, Function0<Unit> onClosed) {
        Object segment$iv;
        int closedForReceive;
        long andIncrement;
        kotlinx.coroutines.channels.BufferedChannel buf;
        kotlinx.coroutines.channels.ChannelSegment channelSegment;
        int i;
        int i2;
        Object cmp;
        Unit $i$a$ReceiveImpl$defaultBufferedChannel$receiveImplOnNoWaiter$1;
        int i3;
        kotlinx.coroutines.channels.BufferedChannel buf2 = this;
        final Waiter waiter2 = onElementRetrieved;
        final Object obj = onClosed;
        final int i4 = 0;
        final Object obj2 = BufferedChannel.access$updateCellReceive(this, segment, index, r, waiter);
        if (obj2 == BufferedChannelKt.access$getSUSPEND$p()) {
            BufferedChannel.access$prepareReceiverForSuspension(buf2, waiter2, segment, index);
        } else {
            buf = segment;
            channelSegment = index;
            if (obj2 == BufferedChannelKt.access$getFAILED$p() && Long.compare(r, sendersCounter$kotlinx_coroutines_core) < 0) {
                if (Long.compare(r, sendersCounter$kotlinx_coroutines_core) < 0) {
                    buf.cleanPrev();
                }
                i = 0;
                segment$iv = BufferedChannel.access$getReceiveSegment$FU$p().get(buf2);
                while (buf2.isClosedForReceive()) {
                    andIncrement = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(buf2);
                    i2 = andIncrement / l;
                    closedForReceive = (int)i5;
                    cmp = BufferedChannel.access$updateCellReceive(buf2, segment$iv, closedForReceive, andIncrement, obj4);
                    if (Long.compare(andIncrement, sendersCounter$kotlinx_coroutines_core2) < 0) {
                    }
                    segment$iv.cleanPrev();
                    cmp = BufferedChannel.access$findSegmentReceive(buf2, i2, obj13);
                    segment$iv = cmp;
                }
                obj25.invoke();
            }
            buf.cleanPrev();
            obj.invoke(obj2);
        }
    }

    private final Object receiveOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, long r, Continuation<? super E> $completion) {
        int id$iv$iv;
        Continuation context;
        int updCellResult$iv$iv;
        int cmp;
        CancellableContinuationImpl orCreateCancellableContinuation;
        Object segment$iv$iv;
        kotlinx.coroutines.channels.ChannelSegment channelSegment;
        Object i$iv$iv;
        long sendersCounter$kotlinx_coroutines_core;
        long cancellableContinuationImpl;
        Object i$iv$iv2;
        kotlinx.coroutines.channels.BufferedChannel buf2;
        Object buf;
        int bindCancellationFun;
        int i;
        int $i$f$suspendCancellableCoroutineReusable;
        Continuation continuation;
        int i2;
        CancellableContinuationImpl cancellableContinuationImpl2;
        int sendersCounter$kotlinx_coroutines_core2;
        final kotlinx.coroutines.channels.BufferedChannel buf3 = this;
        id$iv$iv = 0;
        context = obj29;
        updCellResult$iv$iv = 0;
        orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(context));
        CancellableContinuationImpl cancellableContinuationImpl3 = orCreateCancellableContinuation;
        final int i6 = 0;
        final kotlinx.coroutines.channels.BufferedChannel buf4 = this;
        final int i7 = 0;
        final Object obj = i$iv$iv2;
        if (obj == BufferedChannelKt.access$getSUSPEND$p()) {
            BufferedChannel.access$prepareReceiverForSuspension(buf4, (Waiter)cancellableContinuationImpl3, segment, index);
            $i$f$suspendCancellableCoroutineReusable = id$iv$iv;
            continuation = context;
            i2 = updCellResult$iv$iv;
            cancellableContinuationImpl2 = orCreateCancellableContinuation;
        } else {
            buf = segment;
            i$iv$iv = index;
            bindCancellationFun = 0;
            if (obj == BufferedChannelKt.access$getFAILED$p() && Long.compare(r, sendersCounter$kotlinx_coroutines_core) < 0) {
                if (Long.compare(r, sendersCounter$kotlinx_coroutines_core) < 0) {
                    buf.cleanPrev();
                }
                i = 0;
                segment$iv$iv = BufferedChannel.access$getReceiveSegment$FU$p().get(buf4);
                while (buf4.isClosedForReceive()) {
                    sendersCounter$kotlinx_coroutines_core = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(buf4);
                    $i$f$suspendCancellableCoroutineReusable = id$iv$iv;
                    continuation = context;
                    id$iv$iv = sendersCounter$kotlinx_coroutines_core / $i$f$suspendCancellableCoroutineReusable2;
                    i2 = updCellResult$iv$iv;
                    cancellableContinuationImpl2 = orCreateCancellableContinuation;
                    i$iv$iv = i$iv$iv2;
                    updCellResult$iv$iv = BufferedChannel.access$updateCellReceive(buf4, segment$iv$iv, i$iv$iv, sendersCounter$kotlinx_coroutines_core, obj11);
                    if (Long.compare(sendersCounter$kotlinx_coroutines_core, sendersCounter$kotlinx_coroutines_core2) < 0) {
                    }
                    i$iv$iv = index;
                    id$iv$iv = $i$f$suspendCancellableCoroutineReusable;
                    context = continuation;
                    updCellResult$iv$iv = i2;
                    orCreateCancellableContinuation = cancellableContinuationImpl2;
                    segment$iv$iv.cleanPrev();
                    cmp = BufferedChannel.access$findSegmentReceive(buf4, id$iv$iv, context);
                    segment$iv$iv = cmp;
                    id$iv$iv = $i$f$suspendCancellableCoroutineReusable;
                    context = continuation;
                    updCellResult$iv$iv = i2;
                    orCreateCancellableContinuation = cancellableContinuationImpl2;
                }
                sendersCounter$kotlinx_coroutines_core = 0;
                BufferedChannel.access$onClosedReceiveOnNoWaiterSuspend(buf3, (CancellableContinuation)cancellableContinuationImpl3);
                $i$f$suspendCancellableCoroutineReusable = id$iv$iv;
                continuation = context;
                i2 = updCellResult$iv$iv;
                cancellableContinuationImpl2 = orCreateCancellableContinuation;
            }
            $i$f$suspendCancellableCoroutineReusable = id$iv$iv;
            continuation = context;
            i2 = updCellResult$iv$iv;
            cancellableContinuationImpl2 = orCreateCancellableContinuation;
            buf.cleanPrev();
            id$iv$iv = obj;
            context = 0;
            Function1 onUndeliveredElement = buf3.onUndeliveredElement;
            if (onUndeliveredElement != null) {
                bindCancellationFun = OnUndeliveredElementKt.bindCancellationFun(onUndeliveredElement, id$iv$iv, cancellableContinuationImpl3.getContext());
            }
            cancellableContinuationImpl3.resume(id$iv$iv, bindCancellationFun);
        }
        try {
            Object result = cancellableContinuationImpl2.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            DebugProbesKt.probeCoroutineSuspended(obj29);
            return result;
        } catch (Throwable th) {
        }
        cancellableContinuationImpl2.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
        throw th;
    }

    private final void registerSelectForReceive(SelectInstance<?> select, Object ignoredParam) {
        Object segment$iv;
        int i2;
        kotlinx.coroutines.channels.ChannelSegment cmp;
        Object obj;
        kotlinx.coroutines.channels.ChannelSegment channelSegment;
        int i;
        long andIncrement;
        SelectInstance selectInstance;
        int i3;
        SelectInstance obj13;
        final int i4 = 0;
        segment$iv = BufferedChannel.access$getReceiveSegment$FU$p().get(this);
        while (isClosedForReceive()) {
            andIncrement = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(this);
            i3 = andIncrement / l;
            i = (int)i6;
            channelSegment = segment$iv;
            selectInstance = obj13;
            obj13 = BufferedChannel.access$updateCellReceive(this, channelSegment, i, andIncrement, obj7);
            if (Long.compare(andIncrement, sendersCounter$kotlinx_coroutines_core) < 0) {
            }
            segment$iv = channelSegment;
            obj13 = selectInstance;
            channelSegment.cleanPrev();
            cmp = BufferedChannel.access$findSegmentReceive(this, i3, obj10);
            channelSegment = segment$iv;
        }
        cmp = 0;
        onClosedSelectOnReceive(obj13);
        obj = this;
        selectInstance = obj13;
    }

    private final void removeUnprocessedElements(kotlinx.coroutines.channels.ChannelSegment<E> lastSegment) {
        int undeliveredElementException;
        Object suspendedSenders;
        int i;
        Object segment;
        kotlinx.coroutines.internal.ConcurrentLinkedListNode index;
        int element$kotlinx_coroutines_core;
        int i2;
        int i$iv;
        long state$kotlinx_coroutines_core;
        kotlinx.coroutines.internal.Symbol casState$kotlinx_coroutines_core2;
        boolean z;
        boolean casState$kotlinx_coroutines_core;
        final Function1 onUndeliveredElement = this.onUndeliveredElement;
        undeliveredElementException = 0;
        int i3 = 0;
        i = 1;
        suspendedSenders = InlineList.constructor-impl$default(i3, i, i3);
        segment = lastSegment;
        while (/* condition */) {
            element$kotlinx_coroutines_core = -1;
            while (element$kotlinx_coroutines_core < index) {
                i7 += state$kotlinx_coroutines_core;
                state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
                while (state$kotlinx_coroutines_core != BufferedChannelKt.access$getDONE_RCV$p()) {
                    state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
                    if (Long.compare(i2, receiversCounter$kotlinx_coroutines_core2) >= 0) {
                        break loop_4;
                    }
                    if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                    } else {
                    }
                    casState$kotlinx_coroutines_core2 = state$kotlinx_coroutines_core;
                    casState$kotlinx_coroutines_core2 = l3.waiter;
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.access$getRESUMING_BY_EB$p()) {
                        break loop_4;
                    }
                    if (Long.compare(i2, receiversCounter$kotlinx_coroutines_core) >= 0) {
                        break loop_4;
                    }
                }
                segment.onSlotCleaned();
                index--;
                element$kotlinx_coroutines_core = -1;
                if (Long.compare(i2, receiversCounter$kotlinx_coroutines_core2) >= 0) {
                    break loop_2;
                }
                if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                } else {
                }
                casState$kotlinx_coroutines_core2 = state$kotlinx_coroutines_core;
                if (onUndeliveredElement != null) {
                }
                suspendedSenders = InlineList.plus-FjFbRPM(suspendedSenders, casState$kotlinx_coroutines_core2);
                segment.cleanElement$kotlinx_coroutines_core(index);
                segment.onSlotCleaned();
                undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(onUndeliveredElement, segment.getElement$kotlinx_coroutines_core(index), undeliveredElementException);
                casState$kotlinx_coroutines_core2 = l3.waiter;
                if (state$kotlinx_coroutines_core != BufferedChannelKt.access$getRESUMING_BY_EB$p()) {
                    break loop_2;
                }
                if (Long.compare(i2, receiversCounter$kotlinx_coroutines_core) >= 0) {
                    break loop_2;
                }
                if (onUndeliveredElement != null) {
                }
                segment.cleanElement$kotlinx_coroutines_core(index);
                segment.onSlotCleaned();
                undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(onUndeliveredElement, segment.getElement$kotlinx_coroutines_core(index), undeliveredElementException);
            }
            index = segment.getPrev();
            if ((ChannelSegment)index != null) {
            }
            segment = index;
            sEGMENT_SIZE -= i;
            i7 += state$kotlinx_coroutines_core;
            state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            while (state$kotlinx_coroutines_core != BufferedChannelKt.access$getDONE_RCV$p()) {
                state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
                if (Long.compare(i2, receiversCounter$kotlinx_coroutines_core2) >= 0) {
                    break loop_4;
                }
                if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                } else {
                }
                casState$kotlinx_coroutines_core2 = state$kotlinx_coroutines_core;
                casState$kotlinx_coroutines_core2 = l3.waiter;
                if (state$kotlinx_coroutines_core != BufferedChannelKt.access$getRESUMING_BY_EB$p()) {
                    break loop_4;
                }
                if (Long.compare(i2, receiversCounter$kotlinx_coroutines_core) >= 0) {
                    break loop_4;
                }
            }
            if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                break;
            } else {
            }
            if (state$kotlinx_coroutines_core != BufferedChannelKt.access$getIN_BUFFER$p()) {
                break;
            } else {
            }
            segment.onSlotCleaned();
            index--;
            if (state$kotlinx_coroutines_core != 0) {
                break;
            } else {
            }
            if (!state$kotlinx_coroutines_core instanceof Waiter) {
                break;
            } else {
            }
            if (Long.compare(i2, receiversCounter$kotlinx_coroutines_core2) >= 0) {
                break;
            }
            if (state$kotlinx_coroutines_core instanceof WaiterEB) {
            } else {
            }
            casState$kotlinx_coroutines_core2 = state$kotlinx_coroutines_core;
            if (onUndeliveredElement != null) {
            }
            suspendedSenders = InlineList.plus-FjFbRPM(suspendedSenders, casState$kotlinx_coroutines_core2);
            segment.cleanElement$kotlinx_coroutines_core(index);
            segment.onSlotCleaned();
            undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(onUndeliveredElement, segment.getElement$kotlinx_coroutines_core(index), undeliveredElementException);
            casState$kotlinx_coroutines_core2 = l3.waiter;
            if (!state$kotlinx_coroutines_core instanceof WaiterEB) {
                break;
            } else {
            }
            if (state$kotlinx_coroutines_core != BufferedChannelKt.access$getRESUMING_BY_EB$p()) {
                break;
            }
            if (state$kotlinx_coroutines_core == BufferedChannelKt.access$getRESUMING_BY_RCV$p()) {
                break;
            } else {
            }
            if (Long.compare(i2, receiversCounter$kotlinx_coroutines_core) >= 0) {
                break;
            }
            if (onUndeliveredElement != null) {
            }
            segment.cleanElement$kotlinx_coroutines_core(index);
            segment.onSlotCleaned();
            undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(onUndeliveredElement, segment.getElement$kotlinx_coroutines_core(index), undeliveredElementException);
        }
        int i5 = 0;
        if (suspendedSenders != null) {
            if (suspendedSenders instanceof ArrayList == null) {
                element$kotlinx_coroutines_core = 0;
                resumeSenderOnCancelledChannel((Waiter)suspendedSenders);
            } else {
                Intrinsics.checkNotNull(suspendedSenders, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
                i2 = suspendedSenders;
                size -= i;
                while (element$kotlinx_coroutines_core < i$iv) {
                    state$kotlinx_coroutines_core = 0L;
                    resumeSenderOnCancelledChannel((Waiter)i2.get(i$iv));
                    i$iv--;
                }
            }
        }
        if (undeliveredElementException != null) {
        } else {
        }
        int i6 = 0;
        throw undeliveredElementException;
    }

    private final void resumeReceiverOnClosedChannel(Waiter $this$resumeReceiverOnClosedChannel) {
        resumeWaiterOnClosedChannel($this$resumeReceiverOnClosedChannel, true);
    }

    private final void resumeSenderOnCancelledChannel(Waiter $this$resumeSenderOnCancelledChannel) {
        resumeWaiterOnClosedChannel($this$resumeSenderOnCancelledChannel, false);
    }

    private final void resumeWaiterOnClosedChannel(Waiter $this$resumeWaiterOnClosedChannel, boolean receiver) {
        Object cont;
        Throwable receiveException;
        Object cHANNEL_CLOSED;
        Throwable closeCause;
        if ($this$resumeWaiterOnClosedChannel instanceof BufferedChannel.SendBroadcast) {
            kotlin.Result.Companion companion = Result.Companion;
            (Continuation)(BufferedChannel.SendBroadcast)$this$resumeWaiterOnClosedChannel.getCont().resumeWith(Result.constructor-impl(false));
        } else {
            if ($this$resumeWaiterOnClosedChannel instanceof CancellableContinuation) {
                kotlin.Result.Companion companion2 = Result.Companion;
                if (receiver) {
                    receiveException = getReceiveException();
                } else {
                    receiveException = getSendException();
                }
                (Continuation)$this$resumeWaiterOnClosedChannel.resumeWith(Result.constructor-impl(ResultKt.createFailure(receiveException)));
            } else {
                if ($this$resumeWaiterOnClosedChannel instanceof ReceiveCatching) {
                    kotlin.Result.Companion companion3 = Result.Companion;
                    (Continuation)obj2.cont.resumeWith(Result.constructor-impl(ChannelResult.box-impl(ChannelResult.Companion.closed-JP2dKIU(getCloseCause()))));
                } else {
                    if ($this$resumeWaiterOnClosedChannel instanceof BufferedChannel.BufferedChannelIterator) {
                        (BufferedChannel.BufferedChannelIterator)$this$resumeWaiterOnClosedChannel.tryResumeHasNextOnClosedChannel();
                    } else {
                        if ($this$resumeWaiterOnClosedChannel instanceof SelectInstance == null) {
                        } else {
                            (SelectInstance)$this$resumeWaiterOnClosedChannel.trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Unexpected waiter: ").append($this$resumeWaiterOnClosedChannel).toString().toString());
        throw illegalStateException;
    }

    static <E> Object send$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> $this, E element, Continuation<? super Unit> $completion) {
        int $i$f$sendImpl2;
        Object segment$iv;
        int i;
        Object aSSERTIONS_ENABLED;
        int $i$f$getSendersCounter;
        boolean z;
        long andIncrement;
        int i3;
        int cOROUTINE_SUSPENDED2;
        Object cOROUTINE_SUSPENDED;
        int i4;
        Object obj;
        int i2;
        Continuation continuation;
        int $i$f$sendImpl;
        final Object obj2 = $this;
        $i$f$sendImpl2 = 0;
        segment$iv = BufferedChannel.access$getSendSegment$FU$p().get(obj2);
        andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement(obj2);
        int i8 = 0;
        $i$f$getSendersCounter = l & l4;
        z = BufferedChannel.access$isClosedForSend0(obj2, andIncrement);
        i3 = $i$f$getSendersCounter / l2;
        i = (int)i6;
        while (Long.compare(cOROUTINE_SUSPENDED2, i3) != 0) {
            aSSERTIONS_ENABLED = BufferedChannel.access$findSegmentSend(obj2, i3, obj12);
            segment$iv = aSSERTIONS_ENABLED;
            $i$f$sendImpl = $i$f$sendImpl2;
            $i$f$sendImpl2 = $i$f$sendImpl;
            andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement(obj2);
            i8 = 0;
            $i$f$getSendersCounter = l & l4;
            z = BufferedChannel.access$isClosedForSend0(obj2, andIncrement);
            i3 = $i$f$getSendersCounter / l2;
            i = (int)i6;
            segment$iv.cleanPrev();
            $i$f$sendImpl = $i$f$sendImpl2;
        }
        aSSERTIONS_ENABLED = 0;
        cOROUTINE_SUSPENDED2 = $this.onClosedSend(element, $completion);
        if (cOROUTINE_SUSPENDED2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return cOROUTINE_SUSPENDED2;
        }
        return Unit.INSTANCE;
    }

    static <E> Object sendBroadcast$suspendImpl(kotlinx.coroutines.channels.BufferedChannel<E> $this, E element, Continuation<? super Boolean> $completion) {
        int i2;
        Object segment$iv;
        Continuation id$iv;
        long l2;
        int i;
        kotlinx.coroutines.channels.ChannelSegment cmp;
        CancellableContinuationImpl cancellableContinuationImpl;
        boolean z;
        int i$iv;
        int i3;
        Object constructor-impl;
        int companion;
        long l;
        int s$iv;
        long receiversCounter$kotlinx_coroutines_core;
        final Object obj = $this;
        final int i8 = 0;
        final int i9 = 0;
        i$iv = 1;
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), i$iv);
        final CancellableContinuationImpl cancellableContinuationImpl3 = cancellableContinuationImpl2;
        cancellableContinuationImpl3.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl4 = cancellableContinuationImpl3;
        final int i10 = 0;
        constructor-impl = 0;
        i2 = obj.onUndeliveredElement == null ? i$iv : constructor-impl;
        if (i2 == 0) {
        } else {
            BufferedChannel.SendBroadcast sendBroadcast = new BufferedChannel.SendBroadcast((CancellableContinuation)cancellableContinuationImpl4);
            final int i11 = 0;
            segment$iv = BufferedChannel.access$getSendSegment$FU$p().get(obj);
            long andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement(obj);
            int i7 = 0;
            l3 &= l4;
            z = BufferedChannel.access$isClosedForSend0(obj, andIncrement);
            companion = i$iv;
            l = andIncrement;
            id$iv = $this$sendersCounter$iv$iv / sendersAndCloseStatusCur$iv;
            s$iv = $this$sendersCounter$iv$iv;
            while (Long.compare(i$iv2, id$iv) != 0) {
                cmp = BufferedChannel.access$findSegmentSend(obj, id$iv, l2);
                segment$iv = cmp;
                cmp = s$iv;
                s$iv = id$iv;
                id$iv = i3;
                i$iv = companion;
                andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement(obj);
                i7 = 0;
                l3 &= l4;
                z = BufferedChannel.access$isClosedForSend0(obj, andIncrement);
                companion = i$iv;
                l = andIncrement;
                id$iv = $this$sendersCounter$iv$iv / sendersAndCloseStatusCur$iv;
                s$iv = $this$sendersCounter$iv$iv;
                segment$iv.cleanPrev();
                i$iv = companion;
            }
            cmp = 0;
            companion = Result.Companion;
            (Continuation)cancellableContinuationImpl4.resumeWith(Result.constructor-impl(Boxing.boxBoolean(constructor-impl)));
            Object result = cancellableContinuationImpl3.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended($completion);
            }
            return result;
        }
        int segment$iv2 = 0;
        IllegalStateException $i$a$CheckBufferedChannel$sendBroadcast$2$1 = new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`".toString());
        throw $i$a$CheckBufferedChannel$sendBroadcast$2$1;
    }

    public static Object sendImpl$default(kotlinx.coroutines.channels.BufferedChannel $this, Object element, Object waiter, Function0 onRendezvousOrBuffered, Function2 onSuspend, Function0 onClosed, Function4 onNoWaiterSuspend, int i8, Object object9) {
        int iNSTANCE;
        Object segment;
        int i;
        kotlinx.coroutines.channels.ChannelSegment cmp;
        int i2;
        int $i$f$getSendersCounter;
        long l;
        Object obj;
        boolean z;
        kotlinx.coroutines.channels.BufferedChannel.sendImpl.1 buf;
        long andIncrement;
        int i3;
        long l2;
        int i4;
        final Object obj3 = $this;
        if (object9 != null) {
        } else {
            if (i8 & 32 != 0) {
                buf = iNSTANCE;
            } else {
                buf = onNoWaiterSuspend;
            }
            final int i7 = 0;
            segment = BufferedChannel.access$getSendSegment$FU$p().get(obj3);
            andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement(obj3);
            int i6 = 0;
            l = 1152921504606846975L;
            $i$f$getSendersCounter = l3 & l;
            z = BufferedChannel.access$isClosedForSend0(obj3, andIncrement);
            i3 = $i$f$getSendersCounter / l4;
            i = (int)i5;
            while (Long.compare(l2, i3) != 0) {
                cmp = BufferedChannel.access$findSegmentSend(obj3, i3, obj13);
                segment = cmp;
                obj = waiter;
                i4 = element;
                l2 = onSuspend;
                andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement(obj3);
                i6 = 0;
                l = 1152921504606846975L;
                $i$f$getSendersCounter = l3 & l;
                z = BufferedChannel.access$isClosedForSend0(obj3, andIncrement);
                i3 = $i$f$getSendersCounter / l4;
                i = (int)i5;
                segment.cleanPrev();
                i4 = element;
                l2 = onSuspend;
            }
            return onClosed.invoke();
        }
        int i10 = element;
        Object obj4 = waiter;
        long l6 = onSuspend;
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        throw unsupportedOperationException;
    }

    private final void sendImplOnNoWaiter(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, E element, long s, Waiter waiter, Function0<Unit> onRendezvousOrBuffered, Function0<Unit> onClosed) {
        Object segment$iv2;
        Object segment$iv;
        kotlinx.coroutines.channels.ChannelSegment cmp;
        int channelSegment;
        int $i$a$SendImpl$defaultBufferedChannel$sendImplOnNoWaiter$1;
        int i4;
        Object $i$f$getSendersCounter;
        long l;
        Object i$iv;
        int i5;
        int i3;
        long andIncrement;
        int i;
        int receiversCounter$kotlinx_coroutines_core;
        final int i12 = 0;
        final Object obj = this;
        String str = "unexpected";
        switch (i5) {
            case 0:
                channelSegment = index;
                i$iv = onRendezvousOrBuffered;
                segment.cleanPrev();
                onClosed.invoke();
                break;
            case 1:
                segment$iv = segment;
                channelSegment = index;
                i$iv = onRendezvousOrBuffered;
                onClosed.invoke();
                break;
            case 2:
                BufferedChannel.access$prepareSenderForSuspension(obj, onRendezvousOrBuffered, segment, index);
                break;
            case 3:
                kotlinx.coroutines.channels.BufferedChannel buf2 = segment;
                kotlinx.coroutines.channels.ChannelSegment channelSegment2 = index;
                Object obj2 = onRendezvousOrBuffered;
                IllegalStateException illegalStateException = new IllegalStateException(str.toString());
                throw illegalStateException;
            case 4:
                i$iv = onRendezvousOrBuffered;
                segment.cleanPrev();
                obj25.invoke();
                segment$iv = segment;
                channelSegment = index;
                break;
            default:
                segment.cleanPrev();
                i3 = 0;
                segment$iv2 = BufferedChannel.access$getSendSegment$FU$p().get(obj);
                andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement(obj);
                int i10 = 0;
                l = 1152921504606846975L;
                $i$f$getSendersCounter = l2 & l;
                i5 = BufferedChannel.access$isClosedForSend0(obj, andIncrement);
                i = $i$f$getSendersCounter / l3;
                cmp = BufferedChannel.access$findSegmentSend(obj, i, obj14);
                obj25.invoke();
                i$iv = onRendezvousOrBuffered;
                segment$iv2 = cmp;
                cmp = i$iv;
                i$iv = onRendezvousOrBuffered;
                segment$iv2.cleanPrev();
                segment$iv2.cleanPrev();
                obj25.invoke();
                int i8 = 0;
                IllegalStateException illegalStateException2 = new IllegalStateException(str.toString());
                throw illegalStateException2;
                segment$iv2.onSlotCleaned();
                obj25.invoke();
                i4 = i$iv;
                i4 = 0;
                BufferedChannel.access$prepareSenderForSuspension(obj, i4, segment$iv2, cmp);
                int i9 = 0;
                $i$a$SendImpl$defaultBufferedChannel$sendImplOnNoWaiter$1 = Unit.INSTANCE;
                onClosed.invoke();
                segment$iv2.cleanPrev();
                onClosed.invoke();
                segment$iv = segment;
                channelSegment = index;
        }
    }

    private final Object sendOnNoWaiterSuspend(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, E element, long s, Continuation<? super Unit> $completion) {
        Object cont2;
        CancellableContinuationImpl i$iv$iv2;
        int i;
        kotlinx.coroutines.channels.BufferedChannel buf;
        Object segment$iv$iv;
        Object segment$iv$iv2;
        kotlinx.coroutines.channels.ChannelSegment channelSegment;
        int i$iv$iv;
        kotlinx.coroutines.channels.ChannelSegment closed$iv$iv;
        int i5;
        Object id$iv$iv;
        long constructor-impl;
        CancellableContinuationImpl cmp;
        int i4;
        Object iNSTANCE;
        int i2;
        CancellableContinuationImpl cont;
        long l;
        Object s$iv$iv;
        int receiversCounter$kotlinx_coroutines_core;
        int i3;
        final kotlinx.coroutines.channels.BufferedChannel buf2 = this;
        final int i13 = 0;
        final int i14 = 0;
        final CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(obj33));
        i$iv$iv2 = orCreateCancellableContinuation;
        final int i15 = 0;
        Object obj = this;
        final int i16 = 0;
        final int i11 = element;
        iNSTANCE = "unexpected";
        switch (cmp) {
            case 0:
                i$iv$iv = index;
                segment.cleanPrev();
                cont2 = 0;
                kotlin.Result.Companion companion = Result.Companion;
                (Continuation)i$iv$iv2.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                Object result = orCreateCancellableContinuation.getResult();
                DebugProbesKt.probeCoroutineSuspended(obj33);
                return result;
            case 1:
                segment$iv$iv = segment;
                i$iv$iv = index;
                cont2 = 0;
                kotlin.Result.Companion companion2 = Result.Companion;
                (Continuation)i$iv$iv2.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                result = orCreateCancellableContinuation.getResult();
                DebugProbesKt.probeCoroutineSuspended(obj33);
                return result;
            case 2:
                BufferedChannel.access$prepareSenderForSuspension(obj, (Waiter)i$iv$iv2, segment, index);
                result = orCreateCancellableContinuation.getResult();
                DebugProbesKt.probeCoroutineSuspended(obj33);
                return result;
            case 3:
                kotlinx.coroutines.channels.BufferedChannel buf4 = segment;
                kotlinx.coroutines.channels.ChannelSegment channelSegment2 = index;
                CancellableContinuationImpl cancellableContinuationImpl4 = i$iv$iv2;
                IllegalStateException cont4 = new IllegalStateException(iNSTANCE.toString());
                throw cont4;
            case 4:
                segment.cleanPrev();
                cont2 = 0;
                BufferedChannel.access$onClosedSendOnNoWaiterSuspend(buf2, i11, (CancellableContinuation)i$iv$iv2);
                segment$iv$iv = segment;
                i$iv$iv = index;
                result = orCreateCancellableContinuation.getResult();
                DebugProbesKt.probeCoroutineSuspended(obj33);
                return result;
            default:
                segment.cleanPrev();
                i2 = 0;
                segment$iv$iv2 = BufferedChannel.access$getSendSegment$FU$p().get(obj);
                long andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement(obj);
                int i10 = 0;
                l2 &= l4;
                closed$iv$iv = BufferedChannel.access$isClosedForSend0(obj, andIncrement);
                cont = i$iv$iv2;
                l = andIncrement;
                id$iv$iv = $this$sendersCounter$iv$iv$iv / sendersAndCloseStatusCur$iv$iv;
                s$iv$iv = $this$sendersCounter$iv$iv$iv;
                cmp = BufferedChannel.access$findSegmentSend(obj, id$iv$iv, obj7);
                cmp = 0;
                BufferedChannel.access$onClosedSendOnNoWaiterSuspend(buf2, i11, (CancellableContinuation)cont);
                segment$iv$iv = segment;
                i$iv$iv = index;
                i$iv$iv2 = cont;
                segment$iv$iv2 = cmp;
                s$iv$iv = id$iv$iv;
                id$iv$iv = i3;
                i4 = closed$iv$iv;
                closed$iv$iv = cont2;
                segment$iv$iv2.cleanPrev();
                segment$iv$iv2.cleanPrev();
                cont2 = 0;
                BufferedChannel.access$onClosedSendOnNoWaiterSuspend(buf2, i11, (CancellableContinuation)cont);
                segment$iv$iv = segment;
                i$iv$iv = index;
                int i17 = i8;
                IllegalStateException illegalStateException = new IllegalStateException(iNSTANCE.toString());
                throw illegalStateException;
                segment$iv$iv2.onSlotCleaned();
                cont2 = 0;
                BufferedChannel.access$onClosedSendOnNoWaiterSuspend(buf2, i11, (CancellableContinuation)cont);
                segment$iv$iv = segment;
                i$iv$iv = index;
                i = cont;
                i = 0;
                BufferedChannel.access$prepareSenderForSuspension(obj, i, segment$iv$iv2, closed$iv$iv);
                cont2 = 0;
                segment$iv$iv = segment;
                i$iv$iv = index;
                kotlin.Result.Companion companion4 = Result.Companion;
                receiversCounter$kotlinx_coroutines_core = i9;
                (Continuation)cont.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                segment$iv$iv = segment;
                i$iv$iv = index;
                segment$iv$iv2.cleanPrev();
                kotlin.Result.Companion companion3 = Result.Companion;
                receiversCounter$kotlinx_coroutines_core = i7;
                (Continuation)cont.resumeWith(Result.constructor-impl(Unit.INSTANCE));
                segment$iv$iv = segment;
                i$iv$iv = index;
                i$iv$iv2 = cont;
                result = orCreateCancellableContinuation.getResult();
                DebugProbesKt.probeCoroutineSuspended(obj33);
                return result;
        }
        return Unit.INSTANCE;
    }

    private final boolean shouldSendSuspend(long curSendersAndCloseStatus) {
        if (isClosedForSend0(curSendersAndCloseStatus)) {
            return 0;
        }
        final int i3 = 0;
        return bufferOrRendezvousSend ^= 1;
    }

    private final boolean tryResumeReceiver(Object $this$tryResumeReceiver, E element) {
        boolean tryResumeHasNext;
        int bindCancellationFun;
        Object onUndeliveredElement;
        Function1 onUndeliveredElement2;
        if ($this$tryResumeReceiver instanceof SelectInstance != null) {
            tryResumeHasNext = (SelectInstance)$this$tryResumeReceiver.trySelect(this, element);
            return tryResumeHasNext;
        } else {
            bindCancellationFun = 0;
            if ($this$tryResumeReceiver instanceof ReceiveCatching) {
                Intrinsics.checkNotNull($this$tryResumeReceiver, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
                Object obj = $this$tryResumeReceiver;
                onUndeliveredElement2 = this.onUndeliveredElement;
                if (onUndeliveredElement2 != null) {
                    bindCancellationFun = OnUndeliveredElementKt.bindCancellationFun(onUndeliveredElement2, element, obj8.cont.getContext());
                }
                tryResumeHasNext = BufferedChannelKt.access$tryResume0((CancellableContinuation)obj2.cont, ChannelResult.box-impl(ChannelResult.Companion.success-JP2dKIU(element)), bindCancellationFun);
            } else {
                if ($this$tryResumeReceiver instanceof BufferedChannel.BufferedChannelIterator) {
                    Intrinsics.checkNotNull($this$tryResumeReceiver, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
                    Object obj3 = $this$tryResumeReceiver;
                    tryResumeHasNext = (BufferedChannel.BufferedChannelIterator)$this$tryResumeReceiver.tryResumeHasNext(element);
                } else {
                    if (!$this$tryResumeReceiver instanceof CancellableContinuation) {
                    } else {
                        Intrinsics.checkNotNull($this$tryResumeReceiver, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
                        Object obj5 = $this$tryResumeReceiver;
                        onUndeliveredElement = this.onUndeliveredElement;
                        if (onUndeliveredElement != null) {
                            bindCancellationFun = OnUndeliveredElementKt.bindCancellationFun(onUndeliveredElement, element, (CancellableContinuation)$this$tryResumeReceiver.getContext());
                        }
                        tryResumeHasNext = BufferedChannelKt.access$tryResume0((CancellableContinuation)$this$tryResumeReceiver, element, bindCancellationFun);
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Unexpected receiver type: ").append($this$tryResumeReceiver).toString().toString());
        throw illegalStateException;
    }

    private final boolean tryResumeSender(Object $this$tryResumeSender, kotlinx.coroutines.channels.ChannelSegment<E> segment, int index) {
        int trySelectResult;
        TrySelectDetailedResult sUCCESSFUL;
        int iNSTANCE;
        sUCCESSFUL = 2;
        int i = 0;
        if ($this$tryResumeSender instanceof CancellableContinuation) {
            Intrinsics.checkNotNull($this$tryResumeSender, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            Object obj4 = $this$tryResumeSender;
            trySelectResult = BufferedChannelKt.tryResume0$default((CancellableContinuation)$this$tryResumeSender, Unit.INSTANCE, i, sUCCESSFUL, i);
            return trySelectResult;
        } else {
            iNSTANCE = 1;
            if ($this$tryResumeSender instanceof SelectInstance != null) {
                Intrinsics.checkNotNull($this$tryResumeSender, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
                Object obj = $this$tryResumeSender;
                TrySelectDetailedResult trySelectDetailed = (SelectImplementation)$this$tryResumeSender.trySelectDetailed(this, Unit.INSTANCE);
                if (trySelectDetailed == TrySelectDetailedResult.REREGISTER) {
                    segment.cleanElement$kotlinx_coroutines_core(index);
                }
                trySelectResult = trySelectDetailed == TrySelectDetailedResult.SUCCESSFUL ? iNSTANCE : 0;
            } else {
                if (!$this$tryResumeSender instanceof BufferedChannel.SendBroadcast) {
                } else {
                    trySelectResult = BufferedChannelKt.tryResume0$default((BufferedChannel.SendBroadcast)$this$tryResumeSender.getCont(), Boolean.valueOf(iNSTANCE), i, sUCCESSFUL, i);
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Unexpected waiter: ").append($this$tryResumeSender).toString().toString());
        throw illegalStateException;
    }

    private final void update$atomicfu(AtomicLongFieldUpdater atomicLongFieldUpdater, Function1<? super Long, Long> function12, Object object3) {
        Object obj2;
        Object obj;
        long l;
        long longValue;
        Object obj8;
        Object obj10;
        final int i = 0;
        l = obj8.get(obj10);
        obj2 = obj8;
        obj = obj10;
        while (obj2.compareAndSet(obj, l, obj4)) {
            obj8 = obj2;
            obj10 = obj;
            l = obj8.get(obj10);
            obj2 = obj8;
            obj = obj10;
        }
    }

    private final boolean updateCellExpandBuffer(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, long b) {
        boolean casState$kotlinx_coroutines_core;
        int i;
        final Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (state$kotlinx_coroutines_core instanceof Waiter && Long.compare(b, l) >= 0 && segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.access$getRESUMING_BY_EB$p())) {
            if (Long.compare(b, l) >= 0) {
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.access$getRESUMING_BY_EB$p())) {
                    if (tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
                        segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.BUFFERED);
                        i = 1;
                    } else {
                        segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                        segment.onCancelledRequest(index, false);
                    }
                    return i;
                }
            }
        }
        return updateCellExpandBufferSlow(segment, index, b);
    }

    private final boolean updateCellExpandBufferSlow(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, long b) {
        Object state$kotlinx_coroutines_core;
        kotlinx.coroutines.internal.Symbol casState$kotlinx_coroutines_core;
        kotlinx.coroutines.internal.Symbol symbol;
        kotlinx.coroutines.internal.Symbol bUFFERED;
        int i2;
        int i;
        long l;
        state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        i2 = 0;
        i = 1;
        while (state$kotlinx_coroutines_core instanceof Waiter) {
            state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            i2 = 0;
            i = 1;
            WaiterEB waiterEB = new WaiterEB((Waiter)state$kotlinx_coroutines_core);
        }
        return i;
    }

    private final Object updateCellReceive(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, long r, Object waiter) {
        kotlinx.coroutines.internal.Symbol senders;
        int casState$kotlinx_coroutines_core;
        long l;
        final Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (state$kotlinx_coroutines_core == null) {
            int i = 0;
            if (Long.compare(r, senders) >= 0 && obj11 == null) {
                if (obj11 == null) {
                    return BufferedChannelKt.access$getSUSPEND_NO_WAITER$p();
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, obj11)) {
                    expandBuffer();
                    return BufferedChannelKt.access$getSUSPEND$p();
                }
            }
        } else {
            if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED && segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.access$getDONE_RCV$p())) {
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.access$getDONE_RCV$p())) {
                    expandBuffer();
                    return segment.retrieveElement$kotlinx_coroutines_core(index);
                }
            }
        }
        return updateCellReceiveSlow(segment, index, r, waiter);
    }

    private final Object updateCellReceiveSlow(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, long r, Object waiter) {
        Object state$kotlinx_coroutines_core;
        boolean $this$sendersCounter$iv;
        Object waiter2;
        boolean casState$kotlinx_coroutines_core;
        Object retrieveElement$kotlinx_coroutines_core;
        long l;
        state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        while (state$kotlinx_coroutines_core != null) {
            state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            int i2 = 0;
        }
        expandBuffer();
        return segment.retrieveElement$kotlinx_coroutines_core(index);
    }

    private final int updateCellSend(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, E element, long s, Object waiter, boolean closed) {
        boolean casState$kotlinx_coroutines_core;
        int i2;
        boolean bufferOrRendezvousSend;
        boolean andSetState$kotlinx_coroutines_core;
        int i;
        segment.storeElement$kotlinx_coroutines_core(index, element);
        if (obj12 != null) {
            Object obj = obj12;
            boolean obj12 = closed;
            long obj10 = s;
            Object obj9 = element;
            int obj8 = index;
            kotlinx.coroutines.channels.ChannelSegment obj7 = segment;
            kotlinx.coroutines.channels.ChannelSegment obj6 = this;
            return updateCellSendSlow(segment, index, element, s, waiter, closed);
        }
        obj12 = closed;
        obj10 = s;
        obj9 = element;
        obj8 = index;
        obj7 = segment;
        obj6 = this;
        Object state$kotlinx_coroutines_core = obj7.getState$kotlinx_coroutines_core(obj8);
        casState$kotlinx_coroutines_core = 1;
        if (state$kotlinx_coroutines_core == null) {
            i = 0;
            if (bufferOrRendezvousSend(obj10)) {
                if (obj7.casState$kotlinx_coroutines_core(obj8, i, BufferedChannelKt.BUFFERED)) {
                    return casState$kotlinx_coroutines_core;
                }
            } else {
                if (obj12 == null) {
                    return 3;
                }
                if (obj7.casState$kotlinx_coroutines_core(obj8, i, obj12)) {
                    return 2;
                }
            }
        } else {
            if (state$kotlinx_coroutines_core instanceof Waiter) {
                obj7.cleanElement$kotlinx_coroutines_core(obj8);
                if (tryResumeReceiver(state$kotlinx_coroutines_core, obj9)) {
                    obj7.setState$kotlinx_coroutines_core(obj8, BufferedChannelKt.access$getDONE_RCV$p());
                    onReceiveDequeued();
                    i2 = 0;
                } else {
                    if (obj7.getAndSetState$kotlinx_coroutines_core(obj8, BufferedChannelKt.access$getINTERRUPTED_RCV$p()) != BufferedChannelKt.access$getINTERRUPTED_RCV$p()) {
                        obj7.onCancelledRequest(obj8, casState$kotlinx_coroutines_core);
                    }
                    i2 = 5;
                }
                return i2;
            }
        }
        return updateCellSendSlow(obj7, obj8, obj9, obj10, obj10, obj12);
    }

    private final int updateCellSendSlow(kotlinx.coroutines.channels.ChannelSegment<E> segment, int index, E element, long s, Object waiter, boolean closed) {
        Object state$kotlinx_coroutines_core;
        boolean casState$kotlinx_coroutines_core2;
        boolean $i$a$AssertBufferedChannel$updateCellSendSlow$1;
        Object waiter2;
        int i2;
        int casState$kotlinx_coroutines_core;
        boolean bufferOrRendezvousSend;
        kotlinx.coroutines.internal.Symbol cHANNEL_CLOSED;
        kotlinx.coroutines.internal.Symbol tryResumeReceiver;
        int i;
        state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        casState$kotlinx_coroutines_core2 = 4;
        i2 = 0;
        casState$kotlinx_coroutines_core = 1;
        while (state$kotlinx_coroutines_core == null) {
            i = 0;
            state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            casState$kotlinx_coroutines_core2 = 4;
            i2 = 0;
            casState$kotlinx_coroutines_core = 1;
        }
        return casState$kotlinx_coroutines_core;
    }

    private final void updateReceiversCounterIfLower(long value) {
        AtomicLongFieldUpdater receivers$FU;
        Object obj;
        long l;
        long l2;
        int i;
        long obj11;
        final Object obj2 = this;
        final int i2 = 0;
        l = BufferedChannel.receivers$FU.get(this);
        i = 0;
        while (Long.compare(l, obj11) >= 0) {
            l2 = obj11;
            obj11 = l2;
            l = receivers$FU2.get(this);
            i = 0;
        }
    }

    private final void updateSendersCounterIfLower(long value) {
        boolean compareAndSet;
        Object obj;
        long l2;
        long l;
        int i3;
        int i4;
        int i;
        int i2;
        final Object obj2 = this;
        final int i5 = 0;
        l2 = BufferedChannel.sendersAndCloseStatus$FU.get(this);
        i4 = 0;
        int i6 = 0;
        i = $this$sendersCounter$iv;
        while (Long.compare(i, value) >= 0) {
            int i7 = 0;
            i3 = 60;
            l2 = sendersAndCloseStatus$FU.get(this);
            i4 = 0;
            i6 = 0;
            i = $this$sendersCounter$iv;
        }
    }

    @Override // kotlinx.coroutines.channels.Channel
    public final void cancel() {
        cancelImpl$kotlinx_coroutines_core(0);
    }

    @Override // kotlinx.coroutines.channels.Channel
    public final void cancel(CancellationException cause) {
        cancelImpl$kotlinx_coroutines_core((Throwable)cause);
    }

    @Override // kotlinx.coroutines.channels.Channel
    public final boolean cancel(Throwable cause) {
        return cancelImpl$kotlinx_coroutines_core(cause);
    }

    @Override // kotlinx.coroutines.channels.Channel
    public boolean cancelImpl$kotlinx_coroutines_core(Throwable cause) {
        CancellationException cancellationException;
        String str;
        if (cause == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        } else {
            cancellationException = cause;
        }
        return closeOrCancelImpl(cancellationException, true);
    }

    @Override // kotlinx.coroutines.channels.Channel
    public final void checkSegmentStructureInvariants() {
        int i6;
        int i2;
        Object segment;
        kotlinx.coroutines.channels.ChannelSegment channelSegment;
        Iterator interruptedOrClosedCells;
        int i;
        kotlinx.coroutines.internal.ConcurrentLinkedListNode prev;
        ArrayList arrayList;
        int i4;
        int i3;
        Object obj;
        long l;
        Object minElem$iv;
        long it;
        int state$kotlinx_coroutines_core;
        Object next;
        boolean equal4;
        boolean equal3;
        boolean equal2;
        int equal;
        long it2;
        int i5;
        int cmp;
        int i10 = 0;
        int i13 = 1;
        if (isRendezvousOrUnlimited()) {
            i6 = BufferedChannel.bufferEndSegment$FU.get(this) == BufferedChannelKt.access$getNULL_SEGMENT$p() ? i13 : i10;
            if (i6 == 0) {
            } else {
                kotlinx.coroutines.channels.ChannelSegment[] arr = new ChannelSegment[3];
                arr[i10] = BufferedChannel.receiveSegment$FU.get(this);
                arr[i13] = BufferedChannel.sendSegment$FU.get(this);
                arr[2] = BufferedChannel.bufferEndSegment$FU.get(this);
                int i14 = 0;
                arrayList = new ArrayList();
                int i16 = 0;
                state$kotlinx_coroutines_core = (Iterable)CollectionsKt.listOf(arr).iterator();
                while (state$kotlinx_coroutines_core.hasNext()) {
                    next = state$kotlinx_coroutines_core.next();
                    i5 = 0;
                    if ((ChannelSegment)next != BufferedChannelKt.access$getNULL_SEGMENT$p()) {
                    } else {
                    }
                    it2 = i10;
                    if (it2 != 0) {
                    }
                    (Collection)arrayList.add(next);
                    it2 = i13;
                }
                int i8 = 0;
                interruptedOrClosedCells = (Iterable)(List)arrayList.iterator();
                if (!interruptedOrClosedCells.hasNext()) {
                } else {
                    if (!interruptedOrClosedCells.hasNext()) {
                    } else {
                        state$kotlinx_coroutines_core = 0;
                        it = obj8.id;
                        Object next6 = interruptedOrClosedCells.next();
                        i5 = 0;
                        it2 = obj9.id;
                        do {
                            next6 = interruptedOrClosedCells.next();
                            i5 = 0;
                            it2 = obj9.id;
                            if (interruptedOrClosedCells.hasNext()) {
                            }
                            minElem$iv = next6;
                            it = it2;
                        } while (Long.compare(it, it2) > 0);
                    }
                    i2 = (ChannelSegment)minElem$iv.getPrev() == null ? i13 : i10;
                    if (i2 == 0) {
                    } else {
                        segment = minElem$iv;
                        while (segment.getNext() != null) {
                            kotlinx.coroutines.internal.ConcurrentLinkedListNode next3 = segment.getNext();
                            Intrinsics.checkNotNull(next3);
                            if ((ChannelSegment)next3.getPrev() != null) {
                            } else {
                            }
                            i = i13;
                            interruptedOrClosedCells = 0;
                            i4 = 0;
                            while (i4 < BufferedChannelKt.SEGMENT_SIZE) {
                                state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(i4);
                                i4++;
                                if (Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getINTERRUPTED_RCV$p())) {
                                } else {
                                }
                                equal3 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                                if (equal3) {
                                } else {
                                }
                                equal2 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED());
                                it2 = "Check failed.";
                                if (Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getPOISONED$p())) {
                                } else {
                                }
                                equal = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getDONE_RCV$p());
                                if (segment.getElement$kotlinx_coroutines_core(i4) == null) {
                                } else {
                                }
                                equal4 = i10;
                                equal4 = i13;
                                equal = i13;
                                if (segment.getElement$kotlinx_coroutines_core(i4) == null) {
                                } else {
                                }
                                equal4 = i10;
                                interruptedOrClosedCells++;
                                equal4 = i13;
                                equal2 = i13;
                                equal3 = i13;
                            }
                            arrayList = segment.getNext();
                            Intrinsics.checkNotNull(arrayList);
                            segment = arrayList;
                            if (segment != BufferedChannel.receiveSegment$FU.get(this) && segment != BufferedChannel.sendSegment$FU.get(this)) {
                            } else {
                            }
                            i3 = i13;
                            if (segment != BufferedChannel.sendSegment$FU.get(this)) {
                            } else {
                            }
                            if (segment == BufferedChannel.bufferEndSegment$FU.get(this)) {
                            } else {
                            }
                            i3 = i10;
                            state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(i4);
                            i4++;
                            if (Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getINTERRUPTED_RCV$p())) {
                            } else {
                            }
                            equal3 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                            if (equal3) {
                            } else {
                            }
                            equal2 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED());
                            it2 = "Check failed.";
                            if (Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getPOISONED$p())) {
                            } else {
                            }
                            equal = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getDONE_RCV$p());
                            if (segment.getElement$kotlinx_coroutines_core(i4) == null) {
                            } else {
                            }
                            equal4 = i10;
                            equal4 = i13;
                            equal = i13;
                            if (segment.getElement$kotlinx_coroutines_core(i4) == null) {
                            } else {
                            }
                            equal4 = i10;
                            interruptedOrClosedCells++;
                            equal4 = i13;
                            equal2 = i13;
                            equal3 = i13;
                            kotlinx.coroutines.internal.ConcurrentLinkedListNode next4 = segment.getNext();
                            Intrinsics.checkNotNull(next4);
                            if ((ChannelSegment)next4.getPrev() == segment) {
                            } else {
                            }
                            i = i10;
                        }
                    }
                    int segment2 = 0;
                    StringBuilder stringBuilder = new StringBuilder();
                    IllegalStateException illegalStateException4 = new IllegalStateException(stringBuilder.append("All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: ").append(this).toString().toString());
                    throw illegalStateException4;
                }
                NoSuchElementException noSuchElementException = new NoSuchElementException();
                throw noSuchElementException;
            }
            int i9 = 0;
            StringBuilder stringBuilder2 = new StringBuilder();
            IllegalStateException illegalStateException5 = new IllegalStateException(stringBuilder2.append("bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: ").append(this).toString().toString());
            throw illegalStateException5;
        }
        i6 = Long.compare(channelSegment, l) <= 0 ? i13 : i10;
        if (i6 == 0) {
        } else {
        }
        int $i$f$minByOrThrow = 0;
        StringBuilder stringBuilder3 = new StringBuilder();
        IllegalStateException illegalStateException6 = new IllegalStateException(stringBuilder3.append("bufferEndSegment should not have lower id than receiveSegment.\nChannel state: ").append(this).toString().toString());
        throw illegalStateException6;
    }

    @Override // kotlinx.coroutines.channels.Channel
    public boolean close(Throwable cause) {
        return closeOrCancelImpl(cause, false);
    }

    @Override // kotlinx.coroutines.channels.Channel
    protected boolean closeOrCancelImpl(Throwable cause, boolean cancel) {
        if (cancel) {
            markCancellationStarted();
        }
        boolean z = AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(BufferedChannel._closeCause$FU, this, BufferedChannelKt.access$getNO_CLOSE_CAUSE$p(), cause);
        if (cancel) {
            markCancelled();
        } else {
            markClosed();
        }
        completeCloseOrCancel();
        final int i = 0;
        onClosedIdempotent();
        if (z) {
            invokeCloseHandler();
        }
        return z;
    }

    @Override // kotlinx.coroutines.channels.Channel
    protected final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long globalCellIndex) {
        boolean $i$a$AssertBufferedChannel$dropFirstElementUntilTheSpecifiedCellIsInTheBuffer$1;
        Object segment;
        boolean compareAndSet;
        long l;
        Object segmentReceive;
        long i;
        long l2;
        int onUndeliveredElement;
        int i3;
        int i4;
        int i2;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i5 = 0;
            if (!isConflatedDropOldest()) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        segment = BufferedChannel.receiveSegment$FU.get(this);
        i = BufferedChannel.receivers$FU.get(this);
        while (Long.compare(globalCellIndex, l4) < 0) {
            segmentReceive = this;
            l = segmentReceive;
            i = BufferedChannel.receivers$FU.get(this);
            i4 = i / l5;
            onUndeliveredElement = segment.id;
            segmentReceive = segment;
            l2 = i;
            Object cellReceive = l.updateCellReceive(segmentReceive, (int)i8, l2, onUndeliveredElement);
            segmentReceive.cleanPrev();
            onUndeliveredElement = l.onUndeliveredElement;
            segment = segmentReceive;
            i2 = 0;
            onUndeliveredElement = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(onUndeliveredElement, cellReceive, i2, 2, i2);
            if (Long.compare(i, sendersCounter$kotlinx_coroutines_core) < 0) {
            }
            segmentReceive.cleanPrev();
            segmentReceive = findSegmentReceive(i4, obj9);
            segment = segmentReceive;
        }
    }

    @Override // kotlinx.coroutines.channels.Channel
    protected final Throwable getCloseCause() {
        return (Throwable)BufferedChannel._closeCause$FU.get(this);
    }

    public SelectClause1<E> getOnReceive() {
        kotlinx.coroutines.channels.BufferedChannel.onReceive.1 iNSTANCE = BufferedChannel.onReceive.1.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        int i = 3;
        kotlinx.coroutines.channels.BufferedChannel.onReceive.2 iNSTANCE2 = BufferedChannel.onReceive.2.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        SelectClause1Impl selectClause1Impl = new SelectClause1Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE, i), (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE2, i), this.onUndeliveredElementReceiveCancellationConstructor);
        return (SelectClause1)selectClause1Impl;
    }

    public SelectClause1<kotlinx.coroutines.channels.ChannelResult<E>> getOnReceiveCatching() {
        kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.1 iNSTANCE = BufferedChannel.onReceiveCatching.1.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        int i = 3;
        kotlinx.coroutines.channels.BufferedChannel.onReceiveCatching.2 iNSTANCE2 = BufferedChannel.onReceiveCatching.2.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        SelectClause1Impl selectClause1Impl = new SelectClause1Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE, i), (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE2, i), this.onUndeliveredElementReceiveCancellationConstructor);
        return (SelectClause1)selectClause1Impl;
    }

    public SelectClause1<E> getOnReceiveOrNull() {
        kotlinx.coroutines.channels.BufferedChannel.onReceiveOrNull.1 iNSTANCE = BufferedChannel.onReceiveOrNull.1.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        int i = 3;
        kotlinx.coroutines.channels.BufferedChannel.onReceiveOrNull.2 iNSTANCE2 = BufferedChannel.onReceiveOrNull.2.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        SelectClause1Impl selectClause1Impl = new SelectClause1Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE, i), (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE2, i), this.onUndeliveredElementReceiveCancellationConstructor);
        return (SelectClause1)selectClause1Impl;
    }

    public SelectClause2<E, kotlinx.coroutines.channels.BufferedChannel<E>> getOnSend() {
        kotlinx.coroutines.channels.BufferedChannel.onSend.1 iNSTANCE = BufferedChannel.onSend.1.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        int i = 3;
        kotlinx.coroutines.channels.BufferedChannel.onSend.2 iNSTANCE2 = BufferedChannel.onSend.2.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        SelectClause2Impl selectClause2Impl = new SelectClause2Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE, i), (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE2, i), 0, 8, 0);
        return (SelectClause2)selectClause2Impl;
    }

    @Override // kotlinx.coroutines.channels.Channel
    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return BufferedChannel.receivers$FU.get(this);
    }

    @Override // kotlinx.coroutines.channels.Channel
    protected final Throwable getSendException() {
        Object closedSendChannelException;
        String str;
        if (getCloseCause() == null) {
            closedSendChannelException = new ClosedSendChannelException("Channel was closed");
        }
        return closedSendChannelException;
    }

    @Override // kotlinx.coroutines.channels.Channel
    public final long getSendersCounter$kotlinx_coroutines_core() {
        final int i = 0;
        return l &= l2;
    }

    @Override // kotlinx.coroutines.channels.Channel
    public final boolean hasElements$kotlinx_coroutines_core() {
        Object segment;
        AtomicLongFieldUpdater receivers$FU;
        int segmentReceive;
        Object obj;
        long receiversCounter$kotlinx_coroutines_core;
        int i;
        long sendersCounter$kotlinx_coroutines_core;
        int i2;
        int i3;
        segment = BufferedChannel.receiveSegment$FU.get(this);
        receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
        obj = 0;
        while (Long.compare(sendersCounter$kotlinx_coroutines_core, receiversCounter$kotlinx_coroutines_core) <= 0) {
            i2 = receiversCounter$kotlinx_coroutines_core / l2;
            segment.cleanPrev();
            BufferedChannel.receivers$FU.compareAndSet(this, receiversCounter$kotlinx_coroutines_core, obj4);
            segment = BufferedChannel.receiveSegment$FU.get(this);
            receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            obj = 0;
            segmentReceive = findSegmentReceive(i2, obj10);
            segment = segmentReceive;
        }
        return obj;
    }

    public void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        Object obj;
        int i;
        boolean z;
        kotlinx.coroutines.internal.Symbol symbol;
        kotlinx.coroutines.internal.Symbol symbol2;
        if (AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(BufferedChannel.closeHandler$FU, this, 0, handler)) {
        }
        Object obj2 = this;
        final int i3 = 0;
        obj = BufferedChannel.closeHandler$FU.get(this);
        i = 0;
        while (obj == BufferedChannelKt.access$getCLOSE_HANDLER_CLOSED$p()) {
            obj = closeHandler$FU2.get(this);
            i = 0;
        }
        if (obj == BufferedChannelKt.access$getCLOSE_HANDLER_INVOKED$p()) {
            IllegalStateException illegalStateException2 = new IllegalStateException("Another handler was already registered and successfully invoked".toString());
            throw illegalStateException2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Another handler is already registered: ").append(obj).toString().toString());
        throw illegalStateException;
    }

    @Override // kotlinx.coroutines.channels.Channel
    public boolean isClosedForReceive() {
        return isClosedForReceive0(BufferedChannel.sendersAndCloseStatus$FU.get(this));
    }

    @Override // kotlinx.coroutines.channels.Channel
    public boolean isClosedForSend() {
        return isClosedForSend0(BufferedChannel.sendersAndCloseStatus$FU.get(this));
    }

    @Override // kotlinx.coroutines.channels.Channel
    protected boolean isConflatedDropOldest() {
        return 0;
    }

    @Override // kotlinx.coroutines.channels.Channel
    public boolean isEmpty() {
        final int i2 = 0;
        if (isClosedForReceive()) {
            return i2;
        }
        if (hasElements$kotlinx_coroutines_core()) {
            return i2;
        }
        return closedForReceive2 ^= 1;
    }

    public kotlinx.coroutines.channels.ChannelIterator<E> iterator() {
        BufferedChannel.BufferedChannelIterator bufferedChannelIterator = new BufferedChannel.BufferedChannelIterator(this);
        return (ChannelIterator)bufferedChannelIterator;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(...))
    public boolean offer(E element) {
        return Channel.DefaultImpls.offer(this, element);
    }

    @Override // kotlinx.coroutines.channels.Channel
    protected void onClosedIdempotent() {
    }

    @Override // kotlinx.coroutines.channels.Channel
    protected void onReceiveDequeued() {
    }

    @Override // kotlinx.coroutines.channels.Channel
    protected void onReceiveEnqueued() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(...))
    public E poll() {
        return Channel.DefaultImpls.poll(this);
    }

    public Object receive(Continuation<? super E> continuation) {
        return BufferedChannel.receive$suspendImpl(this, continuation);
    }

    public Object receiveCatching-JP2dKIU(Continuation<? super kotlinx.coroutines.channels.ChannelResult<? extends E>> continuation) {
        return BufferedChannel.receiveCatching-JP2dKIU$suspendImpl(this, continuation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(...))
    public Object receiveOrNull(Continuation<? super E> $completion) {
        return Channel.DefaultImpls.receiveOrNull(this, $completion);
    }

    protected void registerSelectForSend(SelectInstance<?> select, Object element) {
        Object segment$iv;
        int i2;
        int element$iv;
        SelectInstance selectInstance;
        int $this$sendersCounter$iv$iv;
        boolean z;
        long andIncrement;
        int i;
        int iNSTANCE;
        int element$iv2;
        final Object obj = this;
        final SelectInstance selectInstance2 = select;
        final Object obj2 = element;
        element$iv = element;
        final int i5 = 0;
        segment$iv = BufferedChannel.access$getSendSegment$FU$p().get(obj);
        andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement(obj);
        int i4 = 0;
        l &= l2;
        z = BufferedChannel.access$isClosedForSend0(obj, andIncrement);
        i = $this$sendersCounter$iv$iv / l3;
        i2 = (int)i6;
        while (Long.compare(l5, i) != 0) {
            iNSTANCE = BufferedChannel.access$findSegmentSend(obj, i, obj13);
            segment$iv = iNSTANCE;
            element$iv2 = element$iv;
            element$iv = element$iv2;
            andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement(obj);
            i4 = 0;
            l &= l2;
            z = BufferedChannel.access$isClosedForSend0(obj, andIncrement);
            i = $this$sendersCounter$iv$iv / l3;
            i2 = (int)i6;
            segment$iv.cleanPrev();
            element$iv2 = element$iv;
        }
        iNSTANCE = 0;
        obj.onClosedSelectOnSend(obj2, selectInstance2);
    }

    public Object send(E e, Continuation<? super Unit> continuation2) {
        return BufferedChannel.send$suspendImpl(this, e, continuation2);
    }

    public Object sendBroadcast$kotlinx_coroutines_core(E e, Continuation<? super Boolean> continuation2) {
        return BufferedChannel.sendBroadcast$suspendImpl(this, e, continuation2);
    }

    protected final <R> R sendImpl(E element, Object waiter, Function0<? extends R> onRendezvousOrBuffered, Function2<? super kotlinx.coroutines.channels.ChannelSegment<E>, ? super Integer, ? extends R> onSuspend, Function0<? extends R> onClosed, Function4<? super kotlinx.coroutines.channels.ChannelSegment<E>, ? super Integer, ? super E, ? super Long, ? extends R> onNoWaiterSuspend) {
        Object segment;
        int i2;
        int cmp;
        Object obj2;
        int $i$f$getSendersCounter;
        long l;
        Object obj;
        boolean z;
        long andIncrement;
        int i;
        long l2;
        int i3;
        Object obj5;
        final Object obj3 = this;
        final int i6 = 0;
        segment = BufferedChannel.access$getSendSegment$FU$p().get(obj3);
        andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement(obj3);
        int i5 = 0;
        l = 1152921504606846975L;
        $i$f$getSendersCounter = l3 & l;
        z = BufferedChannel.access$isClosedForSend0(obj3, andIncrement);
        i = $i$f$getSendersCounter / l4;
        i2 = (int)i4;
        while (Long.compare(l2, i) != 0) {
            cmp = BufferedChannel.access$findSegmentSend(obj3, i, obj12);
            segment = cmp;
            obj = waiter;
            i3 = element;
            l2 = onSuspend;
            obj5 = onNoWaiterSuspend;
            andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement(obj3);
            i5 = 0;
            l = 1152921504606846975L;
            $i$f$getSendersCounter = l3 & l;
            z = BufferedChannel.access$isClosedForSend0(obj3, andIncrement);
            i = $i$f$getSendersCounter / l4;
            i2 = (int)i4;
            segment.cleanPrev();
            i3 = element;
            l2 = onSuspend;
            obj5 = onNoWaiterSuspend;
        }
        return onClosed.invoke();
    }

    @Override // kotlinx.coroutines.channels.Channel
    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return shouldSendSuspend(BufferedChannel.sendersAndCloseStatus$FU.get(this));
    }

    @Override // kotlinx.coroutines.channels.Channel
    public String toString() {
        Object string2;
        char charAt;
        String $this$sendersCloseStatus$iv;
        Object segment;
        int append;
        boolean equal3;
        boolean equal5;
        boolean equal;
        boolean equal2;
        boolean equal4;
        int str;
        Iterator i3;
        ArrayList sEGMENT_SIZE;
        int i4;
        Object minElem$iv;
        long it3;
        int i2;
        Iterator iterator;
        Object next;
        boolean it;
        int it2;
        int cmp;
        kotlinx.coroutines.channels.ChannelSegment channelSegment;
        int string;
        int cmp2;
        int cmp4;
        int cmp5;
        int cmp3;
        int i;
        string2 = this;
        StringBuilder stringBuilder2 = new StringBuilder();
        int i10 = 0;
        switch ($this$sendersCloseStatus$iv) {
            case 2:
                stringBuilder2.append("closed,");
                break;
            case 3:
                stringBuilder2.append("cancelled,");
                break;
            default:
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder2.append(stringBuilder3.append("capacity=").append(string2.capacity).append(',').toString());
        stringBuilder2.append("data=[");
        kotlinx.coroutines.channels.ChannelSegment[] arr = new ChannelSegment[3];
        int i14 = 0;
        arr[i14] = BufferedChannel.receiveSegment$FU.get(string2);
        i4 = 1;
        arr[i4] = BufferedChannel.sendSegment$FU.get(string2);
        arr[2] = BufferedChannel.bufferEndSegment$FU.get(string2);
        int i11 = 0;
        ArrayList arrayList = new ArrayList();
        i2 = 0;
        iterator = (Iterable)CollectionsKt.listOf(arr).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            cmp = 0;
            if ((ChannelSegment)next != BufferedChannelKt.access$getNULL_SEGMENT$p()) {
            } else {
            }
            it2 = i14;
            if (it2 != 0) {
            }
            (Collection)arrayList.add(next);
            it2 = i4;
        }
        int i8 = 0;
        i3 = (Iterable)(List)arrayList.iterator();
        if (!i3.hasNext()) {
        } else {
            if (!i3.hasNext()) {
            } else {
                i2 = 0;
                it3 = obj4.id;
                Object next3 = i3.next();
                it2 = 0;
                it = obj6.id;
                while (Long.compare(it3, it) > 0) {
                    minElem$iv = next3;
                    it3 = it;
                    if (i3.hasNext() != null) {
                    }
                    i = i4;
                    string2 = this;
                    next3 = i3.next();
                    it2 = 0;
                    it = obj6.id;
                }
            }
            long receiversCounter$kotlinx_coroutines_core = string2.getReceiversCounter$kotlinx_coroutines_core();
            long sendersCounter$kotlinx_coroutines_core = string2.getSendersCounter$kotlinx_coroutines_core();
            segment = obj5;
            while (/* condition */) {
                while (i3 < sEGMENT_SIZE) {
                    string = i4;
                    i16 += l2;
                    Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(i3);
                    Object element$kotlinx_coroutines_core = segment.getElement$kotlinx_coroutines_core(i3);
                    i = string;
                    if (state$kotlinx_coroutines_core instanceof CancellableContinuation) {
                    } else {
                    }
                    if (state$kotlinx_coroutines_core instanceof SelectInstance != null) {
                    } else {
                    }
                    if (state$kotlinx_coroutines_core instanceof ReceiveCatching) {
                    } else {
                    }
                    if (state$kotlinx_coroutines_core instanceof BufferedChannel.SendBroadcast) {
                    } else {
                    }
                    if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                    } else {
                    }
                    if (Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getRESUMING_BY_RCV$p())) {
                    } else {
                    }
                    append = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getRESUMING_BY_EB$p());
                    if (append) {
                    } else {
                    }
                    if (state$kotlinx_coroutines_core == null) {
                    } else {
                    }
                    equal3 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getIN_BUFFER$p());
                    if (equal3) {
                    } else {
                    }
                    equal5 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getDONE_RCV$p());
                    if (equal5) {
                    } else {
                    }
                    equal = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getPOISONED$p());
                    if (equal) {
                    } else {
                    }
                    equal2 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getINTERRUPTED_RCV$p());
                    if (equal2) {
                    } else {
                    }
                    equal4 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                    if (equal4) {
                    } else {
                    }
                    append = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED());
                    if (append == 0) {
                    }
                    i3++;
                    append = 44;
                    string2 = this;
                    sEGMENT_SIZE = i2;
                    i4 = i;
                    string = state$kotlinx_coroutines_core.toString();
                    if (element$kotlinx_coroutines_core != null) {
                    } else {
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder2.append(stringBuilder.append(string).append(',').toString());
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder2.append(stringBuilder4.append('(').append(string).append(',').append(element$kotlinx_coroutines_core).append("),").toString());
                    append = i;
                    equal4 = i;
                    equal2 = i;
                    equal = i;
                    equal5 = i;
                    equal3 = i;
                    string = "resuming_sender";
                    append = i;
                    StringBuilder stringBuilder5 = new StringBuilder();
                    string = stringBuilder5.append("EB(").append(state$kotlinx_coroutines_core).append(')').toString();
                    string = "sendBroadcast";
                    string = "receiveCatching";
                    if (Long.compare(minElem$iv, receiversCounter$kotlinx_coroutines_core) < 0 && Long.compare(minElem$iv, sendersCounter$kotlinx_coroutines_core) >= 0) {
                    } else {
                    }
                    if (Long.compare(minElem$iv, sendersCounter$kotlinx_coroutines_core) < 0 && Long.compare(minElem$iv, receiversCounter$kotlinx_coroutines_core) >= 0) {
                    } else {
                    }
                    string = "select";
                    if (Long.compare(minElem$iv, receiversCounter$kotlinx_coroutines_core) >= 0) {
                    } else {
                    }
                    string = "onSend";
                    if (Long.compare(minElem$iv, sendersCounter$kotlinx_coroutines_core) >= 0) {
                    } else {
                    }
                    string = "onReceive";
                    if (Long.compare(minElem$iv, receiversCounter$kotlinx_coroutines_core) < 0 && Long.compare(minElem$iv, sendersCounter$kotlinx_coroutines_core) >= 0) {
                    } else {
                    }
                    if (Long.compare(minElem$iv, sendersCounter$kotlinx_coroutines_core) < 0 && Long.compare(minElem$iv, receiversCounter$kotlinx_coroutines_core) >= 0) {
                    } else {
                    }
                    string = "cont";
                    if (Long.compare(minElem$iv, receiversCounter$kotlinx_coroutines_core) >= 0) {
                    } else {
                    }
                    string = "send";
                    if (Long.compare(minElem$iv, sendersCounter$kotlinx_coroutines_core) >= 0) {
                    } else {
                    }
                    string = "receive";
                }
                string2 = segment.getNext();
                if ((ChannelSegment)string2 != null) {
                }
                append = 44;
                segment = string2;
                string2 = this;
                i4 = i;
                i3 = 0;
                sEGMENT_SIZE = BufferedChannelKt.SEGMENT_SIZE;
                string = i4;
                i16 += l2;
                if (Long.compare(minElem$iv, sendersCounter$kotlinx_coroutines_core) >= 0) {
                    break;
                } else {
                }
                state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(i3);
                element$kotlinx_coroutines_core = segment.getElement$kotlinx_coroutines_core(i3);
                i = string;
                if (state$kotlinx_coroutines_core instanceof CancellableContinuation) {
                } else {
                }
                if (state$kotlinx_coroutines_core instanceof SelectInstance != null) {
                } else {
                }
                if (state$kotlinx_coroutines_core instanceof ReceiveCatching) {
                } else {
                }
                if (state$kotlinx_coroutines_core instanceof BufferedChannel.SendBroadcast) {
                } else {
                }
                if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                } else {
                }
                if (Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getRESUMING_BY_RCV$p())) {
                } else {
                }
                append = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getRESUMING_BY_EB$p());
                if (append) {
                } else {
                }
                if (state$kotlinx_coroutines_core == null) {
                } else {
                }
                equal3 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getIN_BUFFER$p());
                if (equal3) {
                } else {
                }
                equal5 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getDONE_RCV$p());
                if (equal5) {
                } else {
                }
                equal = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getPOISONED$p());
                if (equal) {
                } else {
                }
                equal2 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getINTERRUPTED_RCV$p());
                if (equal2) {
                } else {
                }
                equal4 = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.access$getINTERRUPTED_SEND$p());
                if (equal4) {
                } else {
                }
                append = Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED());
                if (append == 0) {
                }
                i3++;
                append = 44;
                string2 = this;
                sEGMENT_SIZE = i2;
                i4 = i;
                string = state$kotlinx_coroutines_core.toString();
                if (element$kotlinx_coroutines_core != null) {
                } else {
                }
                stringBuilder = new StringBuilder();
                stringBuilder2.append(stringBuilder.append(string).append(',').toString());
                stringBuilder4 = new StringBuilder();
                stringBuilder2.append(stringBuilder4.append('(').append(string).append(',').append(element$kotlinx_coroutines_core).append("),").toString());
                append = i;
                equal4 = i;
                equal2 = i;
                equal = i;
                equal5 = i;
                equal3 = i;
                string = "resuming_sender";
                append = i;
                stringBuilder5 = new StringBuilder();
                string = stringBuilder5.append("EB(").append(state$kotlinx_coroutines_core).append(')').toString();
                string = "sendBroadcast";
                string = "receiveCatching";
                if (Long.compare(minElem$iv, receiversCounter$kotlinx_coroutines_core) < 0 && Long.compare(minElem$iv, sendersCounter$kotlinx_coroutines_core) >= 0) {
                } else {
                }
                if (Long.compare(minElem$iv, sendersCounter$kotlinx_coroutines_core) < 0 && Long.compare(minElem$iv, receiversCounter$kotlinx_coroutines_core) >= 0) {
                } else {
                }
                string = "select";
                if (Long.compare(minElem$iv, receiversCounter$kotlinx_coroutines_core) >= 0) {
                } else {
                }
                string = "onSend";
                if (Long.compare(minElem$iv, sendersCounter$kotlinx_coroutines_core) >= 0) {
                } else {
                }
                string = "onReceive";
                if (Long.compare(minElem$iv, receiversCounter$kotlinx_coroutines_core) < 0 && Long.compare(minElem$iv, sendersCounter$kotlinx_coroutines_core) >= 0) {
                } else {
                }
                if (Long.compare(minElem$iv, sendersCounter$kotlinx_coroutines_core) < 0 && Long.compare(minElem$iv, receiversCounter$kotlinx_coroutines_core) >= 0) {
                } else {
                }
                string = "cont";
                if (Long.compare(minElem$iv, receiversCounter$kotlinx_coroutines_core) >= 0) {
                } else {
                }
                string = "send";
                if (Long.compare(minElem$iv, sendersCounter$kotlinx_coroutines_core) >= 0) {
                } else {
                }
                string = "receive";
                if (Long.compare(minElem$iv, receiversCounter$kotlinx_coroutines_core) >= 0) {
                    break;
                } else {
                }
            }
            i = string;
            if (StringsKt.last((CharSequence)stringBuilder2) == 44) {
                Intrinsics.checkNotNullExpressionValue(stringBuilder2.deleteCharAt(length--), "this.deleteCharAt(index)");
            }
            stringBuilder2.append("]");
            return stringBuilder2.toString();
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    @Override // kotlinx.coroutines.channels.Channel
    public final String toStringDebug$kotlinx_coroutines_core() {
        String $i$f$getSendersCloseStatus;
        boolean rendezvousOrUnlimited;
        Object segment;
        String hexAddress;
        Iterator iterator2;
        ArrayList str;
        String str3;
        int hexAddress2;
        int i2;
        Object minElem$iv;
        long it2;
        int i;
        Iterator iterator;
        Object next;
        boolean it;
        int it3;
        int valueOf;
        kotlinx.coroutines.channels.ChannelSegment string;
        String str2;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        int i9 = 0;
        int i11 = 60;
        int i7 = 44;
        stringBuilder.append(stringBuilder2.append("S=").append(getSendersCounter$kotlinx_coroutines_core()).append(",R=").append(getReceiversCounter$kotlinx_coroutines_core()).append(",B=").append(getBufferEndCounter()).append(",B'=").append(BufferedChannel.completedExpandBuffersAndPauseFlag$FU.get(this)).append(",C=").append((int)i14).append(i7).toString());
        int i3 = 0;
        switch ($i$f$getSendersCloseStatus) {
            case 1:
                stringBuilder.append("CANCELLATION_STARTED,");
                break;
            case 2:
                stringBuilder.append("CLOSED,");
                break;
            case 3:
                stringBuilder.append("CANCELLED,");
                break;
            default:
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder.append(stringBuilder3.append("SEND_SEGM=").append(DebugStringsKt.getHexAddress(BufferedChannel.sendSegment$FU.get(this))).append(",RCV_SEGM=").append(DebugStringsKt.getHexAddress(BufferedChannel.receiveSegment$FU.get(this))).toString());
        if (!isRendezvousOrUnlimited()) {
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder.append(stringBuilder4.append(",EB_SEGM=").append(DebugStringsKt.getHexAddress(BufferedChannel.bufferEndSegment$FU.get(this))).toString());
        }
        stringBuilder.append("  ");
        kotlinx.coroutines.channels.ChannelSegment[] arr = new ChannelSegment[3];
        int i10 = 0;
        arr[i10] = BufferedChannel.receiveSegment$FU.get(this);
        int i13 = 1;
        arr[i13] = BufferedChannel.sendSegment$FU.get(this);
        arr[2] = BufferedChannel.bufferEndSegment$FU.get(this);
        int i8 = 0;
        ArrayList arrayList = new ArrayList();
        i = 0;
        iterator = (Iterable)CollectionsKt.listOf(arr).iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            valueOf = 0;
            if ((ChannelSegment)next != BufferedChannelKt.access$getNULL_SEGMENT$p()) {
            } else {
            }
            it3 = i10;
            if (it3 != 0) {
            }
            (Collection)arrayList.add(next);
            it3 = i13;
        }
        int i5 = 0;
        iterator2 = (Iterable)(List)arrayList.iterator();
        if (!iterator2.hasNext()) {
        } else {
            if (!iterator2.hasNext()) {
            } else {
                i = 0;
                it2 = obj7.id;
                Object next4 = iterator2.next();
                it3 = 0;
                it = obj9.id;
                do {
                    next4 = iterator2.next();
                    it3 = 0;
                    it = obj9.id;
                    if (iterator2.hasNext() != null) {
                    }
                    minElem$iv = next4;
                    it2 = it;
                } while (Long.compare(it2, it) > 0);
            }
            int i6 = 0;
            segment = obj8;
            StringBuilder stringBuilder5 = new StringBuilder();
            while (segment.isRemoved()) {
                str3 = "*";
                kotlinx.coroutines.internal.ConcurrentLinkedListNode prev = segment.getPrev();
                if ((ChannelSegment)prev != null) {
                } else {
                }
                hexAddress2 = minElem$iv;
                stringBuilder.append(stringBuilder5.append(DebugStringsKt.getHexAddress(segment)).append("=[").append(str3).append(segment.id).append(",prev=").append(hexAddress2).append(i7).toString());
                i2 = i10;
                while (i2 < BufferedChannelKt.SEGMENT_SIZE) {
                    it2 = i2;
                    i = 0;
                    it = segment.getState$kotlinx_coroutines_core(it2);
                    if (it instanceof CancellableContinuation) {
                    } else {
                    }
                    if (it instanceof SelectInstance != null) {
                    } else {
                    }
                    if (it instanceof ReceiveCatching) {
                    } else {
                    }
                    if (it instanceof BufferedChannel.SendBroadcast) {
                    } else {
                    }
                    if (it instanceof WaiterEB) {
                    } else {
                    }
                    valueOf = String.valueOf(it);
                    StringBuilder stringBuilder8 = new StringBuilder();
                    stringBuilder.append(stringBuilder8.append('[').append(it2).append("]=(").append(valueOf).append(i7).append(segment.getElement$kotlinx_coroutines_core(it2)).append("),").toString());
                    i2++;
                    StringBuilder stringBuilder7 = new StringBuilder();
                    valueOf = stringBuilder7.append("EB(").append(it).append(')').toString();
                    valueOf = "send(broadcast)";
                    valueOf = "receiveCatching";
                    valueOf = "select";
                    valueOf = "cont";
                }
                StringBuilder stringBuilder6 = new StringBuilder();
                kotlinx.coroutines.internal.ConcurrentLinkedListNode next2 = segment.getNext();
                if ((ChannelSegment)next2 != null) {
                }
                stringBuilder.append(stringBuilder6.append("next=").append(minElem$iv).append("]  ").toString());
                iterator2 = segment.getNext();
                if ((ChannelSegment)iterator2 != null) {
                }
                segment = iterator2;
                stringBuilder5 = new StringBuilder();
                str3 = "";
                minElem$iv = DebugStringsKt.getHexAddress((ChannelSegment)next2);
                it2 = i2;
                i = 0;
                it = segment.getState$kotlinx_coroutines_core(it2);
                if (it instanceof CancellableContinuation) {
                } else {
                }
                if (it instanceof SelectInstance != null) {
                } else {
                }
                if (it instanceof ReceiveCatching) {
                } else {
                }
                if (it instanceof BufferedChannel.SendBroadcast) {
                } else {
                }
                if (it instanceof WaiterEB) {
                } else {
                }
                valueOf = String.valueOf(it);
                stringBuilder8 = new StringBuilder();
                stringBuilder.append(stringBuilder8.append('[').append(it2).append("]=(").append(valueOf).append(i7).append(segment.getElement$kotlinx_coroutines_core(it2)).append("),").toString());
                i2++;
                stringBuilder7 = new StringBuilder();
                valueOf = stringBuilder7.append("EB(").append(it).append(')').toString();
                valueOf = "send(broadcast)";
                valueOf = "receiveCatching";
                valueOf = "select";
                valueOf = "cont";
                hexAddress2 = DebugStringsKt.getHexAddress((ChannelSegment)prev);
            }
            return stringBuilder.toString();
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    @Override // kotlinx.coroutines.channels.Channel
    public Object tryReceive-PtdJZtk() {
        Object globalIndex;
        int i;
        Object $i$a$ReceiveImpl$defaultBufferedChannel$tryReceive$3;
        int cmp;
        Object success-JP2dKIU;
        int i4;
        Throwable closeCause;
        int i2;
        Object obj;
        long l;
        kotlinx.coroutines.channels.ChannelResult.Companion companion;
        Object segment$iv;
        int i3;
        final Object obj2 = this;
        final long l7 = BufferedChannel.sendersAndCloseStatus$FU.get(obj2);
        if (obj2.isClosedForReceive0(l7)) {
            return ChannelResult.Companion.closed-JP2dKIU(obj2.getCloseCause());
        }
        cmp = 0;
        closeCause = 1152921504606846975L;
        if (Long.compare(l6, i9) >= 0) {
            return ChannelResult.Companion.failure-PtdJZtk();
        }
        final kotlinx.coroutines.internal.Symbol symbol3 = BufferedChannelKt.access$getINTERRUPTED_RCV$p();
        final int i10 = 0;
        globalIndex = BufferedChannel.access$getReceiveSegment$FU$p().get(obj2);
        while (obj2.isClosedForReceive()) {
            long andIncrement = BufferedChannel.access$getReceivers$FU$p().getAndIncrement(obj2);
            i2 = andIncrement / l8;
            obj = andIncrement;
            i = (int)i8;
            long l5 = obj;
            obj = BufferedChannel.access$updateCellReceive(obj2, globalIndex, i, l5, closeCause);
            l = l5;
            segment$iv = globalIndex;
            i3 = i;
            if (Long.compare(l, sendersCounter$kotlinx_coroutines_core) < 0) {
            }
            globalIndex = segment$iv;
            segment$iv.cleanPrev();
            cmp = BufferedChannel.access$findSegmentReceive(obj2, i2, obj14);
            globalIndex = cmp;
        }
        int i6 = 0;
        $i$a$ReceiveImpl$defaultBufferedChannel$tryReceive$3 = ChannelResult.Companion.closed-JP2dKIU(obj2.getCloseCause());
        return $i$a$ReceiveImpl$defaultBufferedChannel$tryReceive$3;
    }

    public Object trySend-JP2dKIU(E element) {
        Object segment$iv;
        Object obj;
        Object $i$a$SendImpl$defaultBufferedChannel$trySend$3;
        int i;
        int i4;
        Object $i$a$SendImpl$defaultBufferedChannel$trySend$1;
        int i5;
        int i2;
        boolean z;
        long andIncrement;
        int i3;
        long l;
        Throwable sendException2;
        Object sendException;
        if (shouldSendSuspend(BufferedChannel.sendersAndCloseStatus$FU.get(this))) {
            return ChannelResult.Companion.failure-PtdJZtk();
        }
        final kotlinx.coroutines.internal.Symbol symbol2 = symbol;
        int i6 = 0;
        segment$iv = BufferedChannel.access$getSendSegment$FU$p().get(this);
        andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement(this);
        i4 = 0;
        l6 &= l3;
        z = BufferedChannel.access$isClosedForSend0(this, andIncrement);
        i3 = i2 / l4;
        i = (int)i7;
        while (Long.compare(l, i3) != 0) {
            obj = BufferedChannel.access$findSegmentSend(this, i3, obj12);
            segment$iv = obj;
            segment$iv = obj;
            andIncrement = BufferedChannel.access$getSendersAndCloseStatus$FU$p().getAndIncrement(this);
            i4 = 0;
            l6 &= l3;
            z = BufferedChannel.access$isClosedForSend0(this, andIncrement);
            i3 = i2 / l4;
            i = (int)i7;
            obj = segment$iv;
            obj.cleanPrev();
        }
        int i8 = 0;
        $i$a$SendImpl$defaultBufferedChannel$trySend$3 = ChannelResult.Companion.closed-JP2dKIU(getSendException());
        return $i$a$SendImpl$defaultBufferedChannel$trySend$3;
    }

    @Override // kotlinx.coroutines.channels.Channel
    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long globalIndex) {
        boolean rendezvousOrUnlimited;
        AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$FU;
        int $i$f$getEbPauseExpandBuffers;
        Object obj;
        long bufferEndCounter2;
        int ebCompletedAndBit;
        int $this$ebCompletedCounter$iv;
        long l3;
        int it;
        int cmp;
        int i4;
        long ebCompleted;
        long bufferEndCounter3;
        Object bufferEndCounter4;
        long bufferEndCounter;
        int $this$ebCompletedCounter$iv2;
        long l2;
        int $i$f$getEbCompletedCounter;
        int i3;
        int i;
        int i2;
        int i5;
        long l4;
        long l;
        if (this.isRendezvousOrUnlimited()) {
        }
        while (Long.compare(bufferEndCounter2, globalIndex) > 0) {
            obj = this;
        }
        final int i12 = 0;
        ebCompletedAndBit = i12;
        ebCompleted = 4611686018427387903L;
        while (ebCompletedAndBit < BufferedChannelKt.access$getEXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS$p()) {
            l3 = ebCompletedAndBit;
            it = 0;
            bufferEndCounter3 = obj.getBufferEndCounter();
            int i11 = 0;
            ebCompletedAndBit++;
            ebCompleted = 4611686018427387903L;
        }
        completedExpandBuffersAndPauseFlag$FU = BufferedChannel.completedExpandBuffersAndPauseFlag$FU;
        bufferEndCounter4 = this;
        final int i16 = 0;
        long l5 = completedExpandBuffersAndPauseFlag$FU.get(obj);
        bufferEndCounter = 0;
        int i17 = 0;
        $i$f$getEbCompletedCounter = 1;
        while (completedExpandBuffersAndPauseFlag$FU.compareAndSet(obj, l5, l3) != 0) {
            l4 = ebCompleted;
            obj = this;
            l5 = completedExpandBuffersAndPauseFlag$FU.get(obj);
            bufferEndCounter = 0;
            i17 = 0;
            $i$f$getEbCompletedCounter = 1;
        }
        bufferEndCounter4 = obj.getBufferEndCounter();
        bufferEndCounter = BufferedChannel.completedExpandBuffersAndPauseFlag$FU.get(obj);
        int i7 = 0;
        i9 &= ebCompleted;
        int i8 = 0;
        while (Long.compare(i3, i) != 0) {
            $i$f$getEbPauseExpandBuffers = $i$f$getEbCompletedCounter;
            if (Long.compare(bufferEndCounter4, $this$ebCompletedCounter$iv) != 0) {
            }
            l4 = ebCompleted;
            if ($i$f$getEbPauseExpandBuffers == 0) {
            } else {
            }
            ebCompletedAndBit = bufferEndCounter;
            obj = this;
            ebCompleted = l4;
            bufferEndCounter4 = obj.getBufferEndCounter();
            bufferEndCounter = BufferedChannel.completedExpandBuffersAndPauseFlag$FU.get(obj);
            i7 = 0;
            i9 &= ebCompleted;
            i8 = 0;
            $i$f$getEbPauseExpandBuffers = i12;
            BufferedChannel.completedExpandBuffersAndPauseFlag$FU.compareAndSet(this, bufferEndCounter, l3);
            ebCompleted = l4;
            if (Long.compare(bufferEndCounter4, it) != 0) {
            }
        }
        AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$FU3 = BufferedChannel.completedExpandBuffersAndPauseFlag$FU;
        Object obj2 = this;
        final int i18 = 0;
        long l6 = completedExpandBuffersAndPauseFlag$FU3.get(obj);
        $i$f$getEbCompletedCounter = 0;
        i5 = 0;
        l4 = ebCompleted;
        while (completedExpandBuffersAndPauseFlag$FU3.compareAndSet(obj, l6, l3)) {
            obj = this;
            $this$ebCompletedCounter$iv = i15;
            ebCompleted = l4;
            l6 = completedExpandBuffersAndPauseFlag$FU3.get(obj);
            $i$f$getEbCompletedCounter = 0;
            i5 = 0;
            l4 = ebCompleted;
        }
    }
}
