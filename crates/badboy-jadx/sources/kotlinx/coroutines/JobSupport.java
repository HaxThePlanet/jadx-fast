package kotlinx.coroutines;

import androidx.concurrent.futures.AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.Element;
import kotlin.coroutines.CoroutineContext.Key;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.Volatile;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.selects.SelectClause0;
import kotlinx.coroutines.selects.SelectClause0Impl;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectClause1Impl;
import kotlinx.coroutines.selects.SelectInstance;

/* loaded from: classes5.dex */
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
@Metadata(d1 = "\u0000â\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0003\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0013\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0001\n\u0002\u0008\u0011\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008\u0017\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\n²\u0001³\u0001´\u0001µ\u0001¶\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J \u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u000b2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020FH\u0002J\u001e\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00112\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u00020\u00110KH\u0002J\u0012\u0010L\u001a\u00020H2\u0008\u00108\u001a\u0004\u0018\u00010\u000bH\u0014J\u000e\u0010M\u001a\u00020\t2\u0006\u0010N\u001a\u00020\u0002J\u0013\u0010O\u001a\u0004\u0018\u00010\u000bH\u0084@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0013\u0010Q\u001a\u0004\u0018\u00010\u000bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0012\u0010R\u001a\u00020\u00052\u0008\u0010S\u001a\u0004\u0018\u00010\u0011H\u0017J\u0018\u0010R\u001a\u00020H2\u000e\u0010S\u001a\n\u0018\u00010Tj\u0004\u0018\u0001`UH\u0016J\u0010\u0010V\u001a\u00020\u00052\u0008\u0010S\u001a\u0004\u0018\u00010\u0011J\u0017\u0010W\u001a\u00020\u00052\u0008\u0010S\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0002\u0008XJ\u0010\u0010Y\u001a\u00020H2\u0006\u0010S\u001a\u00020\u0011H\u0016J\u0014\u0010Z\u001a\u0004\u0018\u00010\u000b2\u0008\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010[\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0011H\u0002J\u0008\u0010\\\u001a\u00020]H\u0014J\u0010\u0010^\u001a\u00020\u00052\u0006\u0010S\u001a\u00020\u0011H\u0016J\u001a\u0010_\u001a\u00020H2\u0006\u00108\u001a\u00020?2\u0008\u0010`\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010a\u001a\u00020H2\u0006\u00108\u001a\u00020b2\u0006\u0010c\u001a\u00020d2\u0008\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010f\u001a\u00020\u00112\u0008\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J&\u0010g\u001a\u00020h2\n\u0008\u0002\u0010i\u001a\u0004\u0018\u00010]2\n\u0008\u0002\u0010S\u001a\u0004\u0018\u00010\u0011H\u0080\u0008¢\u0006\u0002\u0008jJ\u001c\u0010k\u001a\u0004\u0018\u00010\u000b2\u0006\u00108\u001a\u00020b2\u0008\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010l\u001a\u0004\u0018\u00010d2\u0006\u00108\u001a\u00020?H\u0002J\n\u0010m\u001a\u00060Tj\u0002`UJ\u000c\u0010n\u001a\u00060Tj\u0002`UH\u0016J\u000f\u0010o\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0002\u0008pJ\u0008\u0010q\u001a\u0004\u0018\u00010\u0011J \u0010r\u001a\u0004\u0018\u00010\u00112\u0006\u00108\u001a\u00020b2\u000c\u0010J\u001a\u0008\u0012\u0004\u0012\u00020\u00110KH\u0002J\u0012\u0010s\u001a\u0004\u0018\u00010D2\u0006\u00108\u001a\u00020?H\u0002J\u0010\u0010t\u001a\u00020\u00052\u0006\u0010u\u001a\u00020\u0011H\u0014J\u0015\u0010v\u001a\u00020H2\u0006\u0010u\u001a\u00020\u0011H\u0010¢\u0006\u0002\u0008wJ\u0012\u0010x\u001a\u00020H2\u0008\u0010/\u001a\u0004\u0018\u00010\u0001H\u0004JA\u0010y\u001a\u00020z2\u0006\u0010{\u001a\u00020\u00052\u0006\u0010|\u001a\u00020\u00052)\u0010}\u001a%\u0012\u0016\u0012\u0014\u0018\u00010\u0011¢\u0006\r\u0008\u007f\u0012\t\u0008\u0080\u0001\u0012\u0004\u0008\u0008(S\u0012\u0004\u0012\u00020H0~j\u0003`\u0081\u0001J1\u0010y\u001a\u00020z2)\u0010}\u001a%\u0012\u0016\u0012\u0014\u0018\u00010\u0011¢\u0006\r\u0008\u007f\u0012\t\u0008\u0080\u0001\u0012\u0004\u0008\u0008(S\u0012\u0004\u0012\u00020H0~j\u0003`\u0081\u0001J\u0012\u0010\u0082\u0001\u001a\u00020HH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010PJ\t\u0010\u0083\u0001\u001a\u00020\u0005H\u0002J\u0012\u0010\u0084\u0001\u001a\u00020HH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010PJ\"\u0010\u0085\u0001\u001a\u00030\u0086\u00012\u0015\u0010\u0087\u0001\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020H0~H\u0082\u0008J\u0015\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u000b2\u0008\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J\u0019\u0010\u0089\u0001\u001a\u00020\u00052\u0008\u0010e\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0003\u0008\u008a\u0001J\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u000b2\u0008\u0010e\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0003\u0008\u008c\u0001J<\u0010\u008d\u0001\u001a\u00020F2)\u0010}\u001a%\u0012\u0016\u0012\u0014\u0018\u00010\u0011¢\u0006\r\u0008\u007f\u0012\t\u0008\u0080\u0001\u0012\u0004\u0008\u0008(S\u0012\u0004\u0012\u00020H0~j\u0003`\u0081\u00012\u0006\u0010{\u001a\u00020\u0005H\u0002J\u000f\u0010\u008e\u0001\u001a\u00020]H\u0010¢\u0006\u0003\u0008\u008f\u0001J\u0019\u0010\u0090\u0001\u001a\u00020H2\u0006\u0010C\u001a\u00020D2\u0006\u0010S\u001a\u00020\u0011H\u0002J)\u0010\u0091\u0001\u001a\u00020H\"\u000b\u0008\u0000\u0010\u0092\u0001\u0018\u0001*\u00020F2\u0006\u0010C\u001a\u00020D2\u0008\u0010S\u001a\u0004\u0018\u00010\u0011H\u0082\u0008J!\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000b2\t\u0010\u0095\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\"\u0010\u0096\u0001\u001a\u00020H2\u000c\u0010\u0097\u0001\u001a\u0007\u0012\u0002\u0008\u00030\u0098\u00012\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u0012\u0010{\u001a\u00020H2\u0008\u0010S\u001a\u0004\u0018\u00010\u0011H\u0014J\u0013\u0010\u0099\u0001\u001a\u00020H2\u0008\u00108\u001a\u0004\u0018\u00010\u000bH\u0014J\t\u0010\u009a\u0001\u001a\u00020HH\u0014J\u0010\u0010\u009b\u0001\u001a\u00020H2\u0007\u0010\u009c\u0001\u001a\u00020\u0003J\u0012\u0010\u009d\u0001\u001a\u00020H2\u0007\u00108\u001a\u00030\u009e\u0001H\u0002J\u0011\u0010\u009f\u0001\u001a\u00020H2\u0006\u00108\u001a\u00020FH\u0002J\"\u0010 \u0001\u001a\u00020H2\u000c\u0010\u0097\u0001\u001a\u0007\u0012\u0002\u0008\u00030\u0098\u00012\t\u0010\u0094\u0001\u001a\u0004\u0018\u00010\u000bH\u0002J\u0017\u0010¡\u0001\u001a\u00020H2\u0006\u0010E\u001a\u00020FH\u0000¢\u0006\u0003\u0008¢\u0001J\u0007\u0010£\u0001\u001a\u00020\u0005J\u0014\u0010¤\u0001\u001a\u00030¥\u00012\u0008\u00108\u001a\u0004\u0018\u00010\u000bH\u0002J\u0013\u0010¦\u0001\u001a\u00020]2\u0008\u00108\u001a\u0004\u0018\u00010\u000bH\u0002J\t\u0010§\u0001\u001a\u00020]H\u0007J\t\u0010¨\u0001\u001a\u00020]H\u0016J\u001b\u0010©\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u00020?2\u0008\u0010`\u001a\u0004\u0018\u00010\u000bH\u0002J\u0019\u0010ª\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u00020?2\u0006\u0010I\u001a\u00020\u0011H\u0002J\u001f\u0010«\u0001\u001a\u0004\u0018\u00010\u000b2\u0008\u00108\u001a\u0004\u0018\u00010\u000b2\u0008\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J\u001d\u0010¬\u0001\u001a\u0004\u0018\u00010\u000b2\u0006\u00108\u001a\u00020?2\u0008\u0010e\u001a\u0004\u0018\u00010\u000bH\u0002J$\u0010­\u0001\u001a\u00020\u00052\u0006\u00108\u001a\u00020b2\u0006\u0010N\u001a\u00020d2\u0008\u0010e\u001a\u0004\u0018\u00010\u000bH\u0082\u0010J\u0010\u0010®\u0001\u001a\u0004\u0018\u00010d*\u00030¯\u0001H\u0002J\u0017\u0010°\u0001\u001a\u00020H*\u00020D2\u0008\u0010S\u001a\u0004\u0018\u00010\u0011H\u0002J\u001d\u0010±\u0001\u001a\u00060Tj\u0002`U*\u00020\u00112\n\u0008\u0002\u0010i\u001a\u0004\u0018\u00010]H\u0004R\u0011\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0008X\u0082\u0004R\u0011\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0008X\u0082\u0004R\u0017\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00010\r8F¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00058DX\u0084\u0004¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0019\u0010\u0016R\u0011\u0010\u001a\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\u001a\u0010\u0016R\u0011\u0010\u001b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0016R\u0011\u0010\u001c\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\u0008\u001c\u0010\u0016R\u0014\u0010\u001d\u001a\u00020\u00058TX\u0094\u0004¢\u0006\u0006\u001a\u0004\u0008\u001d\u0010\u0016R\u0015\u0010\u001e\u001a\u0006\u0012\u0002\u0008\u00030\u001f8F¢\u0006\u0006\u001a\u0004\u0008 \u0010!R\u001e\u0010\"\u001a\u0006\u0012\u0002\u0008\u00030#8DX\u0084\u0004¢\u0006\u000c\u0012\u0004\u0008$\u0010%\u001a\u0004\u0008&\u0010'R\u0014\u0010(\u001a\u00020\u00058PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008)\u0010\u0016R\u0017\u0010*\u001a\u00020+8F¢\u0006\u000c\u0012\u0004\u0008,\u0010%\u001a\u0004\u0008-\u0010.R\u0016\u0010/\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00080\u00101R(\u00103\u001a\u0004\u0018\u00010\t2\u0008\u00102\u001a\u0004\u0018\u00010\t8@@@X\u0080\u000e¢\u0006\u000c\u001a\u0004\u00084\u00105\"\u0004\u00086\u00107R\u0016\u00108\u001a\u0004\u0018\u00010\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u00089\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010\u0011*\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008<\u0010=R\u0018\u0010>\u001a\u00020\u0005*\u00020?8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008>\u0010@\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006·\u0001", d2 = {"Lkotlinx/coroutines/JobSupport;", "Lkotlinx/coroutines/Job;", "Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/ParentJob;", "active", "", "(Z)V", "_parentHandle", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/ChildHandle;", "_state", "", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "completionCause", "", "getCompletionCause", "()Ljava/lang/Throwable;", "completionCauseHandled", "getCompletionCauseHandled", "()Z", "handlesException", "getHandlesException$kotlinx_coroutines_core", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "key", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "onAwaitInternal", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnAwaitInternal$annotations", "()V", "getOnAwaitInternal", "()Lkotlinx/coroutines/selects/SelectClause1;", "onCancelComplete", "getOnCancelComplete$kotlinx_coroutines_core", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin$annotations", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "parent", "getParent", "()Lkotlinx/coroutines/Job;", "value", "parentHandle", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "state", "getState$kotlinx_coroutines_core", "()Ljava/lang/Object;", "exceptionOrNull", "getExceptionOrNull", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "isCancelling", "Lkotlinx/coroutines/Incomplete;", "(Lkotlinx/coroutines/Incomplete;)Z", "addLastAtomic", "expect", "list", "Lkotlinx/coroutines/NodeList;", "node", "Lkotlinx/coroutines/JobNode;", "addSuppressedExceptions", "", "rootCause", "exceptions", "", "afterCompletion", "attachChild", "child", "awaitInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitSuspend", "cancel", "cause", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelCoroutine", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "cancelInternal", "cancelMakeCompleting", "cancelParent", "cancellationExceptionMessage", "", "childCancelled", "completeStateFinalization", "update", "continueCompleting", "Lkotlinx/coroutines/JobSupport$Finishing;", "lastChild", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "createCauseException", "defaultCancellationException", "Lkotlinx/coroutines/JobCancellationException;", "message", "defaultCancellationException$kotlinx_coroutines_core", "finalizeFinishingState", "firstChild", "getCancellationException", "getChildJobCancellationCause", "getCompletedInternal", "getCompletedInternal$kotlinx_coroutines_core", "getCompletionExceptionOrNull", "getFinalRootCause", "getOrPromoteCancellingList", "handleJobException", "exception", "handleOnCompletionException", "handleOnCompletionException$kotlinx_coroutines_core", "initParentJob", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "joinInternal", "joinSuspend", "loopOnState", "", "block", "makeCancelling", "makeCompleting", "makeCompleting$kotlinx_coroutines_core", "makeCompletingOnce", "makeCompletingOnce$kotlinx_coroutines_core", "makeNode", "nameString", "nameString$kotlinx_coroutines_core", "notifyCancelling", "notifyHandlers", "T", "onAwaitInternalProcessResFunc", "ignoredParam", "result", "onAwaitInternalRegFunc", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "onCompletionInternal", "onStart", "parentCancelled", "parentJob", "promoteEmptyToNodeList", "Lkotlinx/coroutines/Empty;", "promoteSingleToNodeList", "registerSelectForOnJoin", "removeNode", "removeNode$kotlinx_coroutines_core", "start", "startInternal", "", "stateString", "toDebugString", "toString", "tryFinalizeSimpleState", "tryMakeCancelling", "tryMakeCompleting", "tryMakeCompletingSlowPath", "tryWaitForChild", "nextChild", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "notifyCompletion", "toCancellationException", "AwaitContinuation", "ChildCompletion", "Finishing", "SelectOnAwaitCompletionHandler", "SelectOnJoinCompletionHandler", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class JobSupport implements kotlinx.coroutines.Job, kotlinx.coroutines.ChildJob, kotlinx.coroutines.ParentJob {

    private static final AtomicReferenceFieldUpdater _parentHandle$FU;
    private static final AtomicReferenceFieldUpdater _state$FU;
    @Volatile
    private volatile Object _parentHandle;
    @Volatile
    private volatile Object _state;

    @Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0008\u0010\u000c\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e", d2 = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class AwaitContinuation extends kotlinx.coroutines.CancellableContinuationImpl<T> {

        private final kotlinx.coroutines.JobSupport job;
        public AwaitContinuation(Continuation<? super T> delegate, kotlinx.coroutines.JobSupport job) {
            super(delegate, 1);
            this.job = job;
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        public Throwable getContinuationCancellationCause(kotlinx.coroutines.Job parent) {
            boolean rootCause;
            Object state$kotlinx_coroutines_core = this.job.getState$kotlinx_coroutines_core();
            rootCause = (JobSupport.Finishing)state$kotlinx_coroutines_core.getRootCause();
            if (state$kotlinx_coroutines_core instanceof JobSupport.Finishing && rootCause != null) {
                rootCause = (JobSupport.Finishing)state$kotlinx_coroutines_core.getRootCause();
                if (rootCause != null) {
                    final int i = 0;
                    return rootCause;
                }
            }
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                return obj.cause;
            }
            return (Throwable)parent.getCancellationException();
        }

        @Override // kotlinx.coroutines.CancellableContinuationImpl
        protected String nameString() {
            return "AwaitContinuation";
        }
    }

    @Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f", d2 = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ChildCompletion extends kotlinx.coroutines.JobNode {

        private final kotlinx.coroutines.ChildHandleNode child;
        private final kotlinx.coroutines.JobSupport parent;
        private final Object proposedUpdate;
        private final kotlinx.coroutines.JobSupport.Finishing state;
        public ChildCompletion(kotlinx.coroutines.JobSupport parent, kotlinx.coroutines.JobSupport.Finishing state, kotlinx.coroutines.ChildHandleNode child, Object proposedUpdate) {
            super();
            this.parent = parent;
            this.state = state;
            this.child = child;
            this.proposedUpdate = proposedUpdate;
        }

        @Override // kotlinx.coroutines.JobNode
        public Object invoke(Object p1) {
            invoke((Throwable)p1);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.JobNode
        public void invoke(Throwable cause) {
            JobSupport.access$continueCompleting(this.parent, this.state, this.child, this.proposedUpdate);
        }
    }

    @Metadata(d1 = "\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0014\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00060\u0001j\u0002`\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\tJ\u0018\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\t0&j\u0008\u0012\u0004\u0012\u00020\t`'H\u0002J\u0016\u0010(\u001a\u0008\u0012\u0004\u0012\u00020\t0)2\u0008\u0010*\u001a\u0004\u0018\u00010\tJ\u0008\u0010+\u001a\u00020,H\u0016R\u0011\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000cX\u0082\u0004R\t\u0010\r\u001a\u00020\u000eX\u0082\u0004R\u0011\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000cX\u0082\u0004R(\u0010\u0011\u001a\u0004\u0018\u00010\u00012\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u00018B@BX\u0082\u000e¢\u0006\u000c\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0017R$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0006\u0010\u0017\"\u0004\u0008\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u001b\u0010\u0017R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001dR(\u0010\u0008\u001a\u0004\u0018\u00010\t2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\t8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u001e\u0010\u001f\"\u0004\u0008 \u0010!¨\u0006-", d2 = {"Lkotlinx/coroutines/JobSupport$Finishing;", "", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;", "list", "Lkotlinx/coroutines/NodeList;", "isCompleting", "", "rootCause", "", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "_exceptionsHolder", "Lkotlinx/atomicfu/AtomicRef;", "_isCompleting", "Lkotlinx/atomicfu/AtomicBoolean;", "_rootCause", "value", "exceptionsHolder", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "(Ljava/lang/Throwable;)V", "addExceptionLocked", "", "exception", "allocateList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "sealLocked", "", "proposedException", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Finishing implements kotlinx.coroutines.Incomplete {

        private static final AtomicReferenceFieldUpdater _exceptionsHolder$FU;
        private static final AtomicIntegerFieldUpdater _isCompleting$FU;
        private static final AtomicReferenceFieldUpdater _rootCause$FU;
        @Volatile
        private volatile Object _exceptionsHolder;
        @Volatile
        private volatile int _isCompleting;
        @Volatile
        private volatile Object _rootCause;
        private final kotlinx.coroutines.NodeList list;
        static {
            final Class<kotlinx.coroutines.JobSupport.Finishing> obj3 = JobSupport.Finishing.class;
            JobSupport.Finishing._isCompleting$FU = AtomicIntegerFieldUpdater.newUpdater(obj3, "_isCompleting");
            JobSupport.Finishing._rootCause$FU = AtomicReferenceFieldUpdater.newUpdater(obj3, Object.class, "_rootCause");
            JobSupport.Finishing._exceptionsHolder$FU = AtomicReferenceFieldUpdater.newUpdater(obj3, Object.class, "_exceptionsHolder");
        }

        public Finishing(kotlinx.coroutines.NodeList list, boolean isCompleting, Throwable rootCause) {
            super();
            this.list = list;
            this._isCompleting = isCompleting;
            this._rootCause = rootCause;
        }

        private final ArrayList<Throwable> allocateList() {
            ArrayList arrayList = new ArrayList(4);
            return arrayList;
        }

        private final Object getExceptionsHolder() {
            return JobSupport.Finishing._exceptionsHolder$FU.get(this);
        }

        private final void setExceptionsHolder(Object value) {
            JobSupport.Finishing._exceptionsHolder$FU.set(this, value);
        }

        @Override // kotlinx.coroutines.Incomplete
        public final void addExceptionLocked(Throwable exception) {
            Object allocateList;
            ArrayList list;
            int i;
            final Throwable rootCause = getRootCause();
            if (rootCause == null) {
                setRootCause(exception);
            }
            if (exception == rootCause) {
            }
            final Object exceptionsHolder = getExceptionsHolder();
            if (exceptionsHolder == null) {
                setExceptionsHolder(exception);
            } else {
                if (exceptionsHolder instanceof Throwable) {
                    if (exception == exceptionsHolder) {
                    }
                    allocateList = allocateList();
                    list = allocateList;
                    i = 0;
                    list.add(exceptionsHolder);
                    list.add(exception);
                    setExceptionsHolder(allocateList);
                } else {
                    if (exceptionsHolder instanceof ArrayList == null) {
                    } else {
                        (ArrayList)exceptionsHolder.add(exception);
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("State is ").append(exceptionsHolder).toString().toString());
            throw illegalStateException;
        }

        @Override // kotlinx.coroutines.Incomplete
        public kotlinx.coroutines.NodeList getList() {
            return this.list;
        }

        @Override // kotlinx.coroutines.Incomplete
        public final Throwable getRootCause() {
            return (Throwable)JobSupport.Finishing._rootCause$FU.get(this);
        }

        @Override // kotlinx.coroutines.Incomplete
        public boolean isActive() {
            int i;
            i = getRootCause() == null ? 1 : 0;
            return i;
        }

        @Override // kotlinx.coroutines.Incomplete
        public final boolean isCancelling() {
            int i;
            i = getRootCause() != null ? 1 : 0;
            return i;
        }

        @Override // kotlinx.coroutines.Incomplete
        public final boolean isCompleting() {
            int i;
            i = JobSupport.Finishing._isCompleting$FU.get(this) != 0 ? 1 : 0;
            return i;
        }

        @Override // kotlinx.coroutines.Incomplete
        public final boolean isSealed() {
            int i;
            i = getExceptionsHolder() == JobSupportKt.access$getSEALED$p() ? 1 : 0;
            return i;
        }

        public final List<Throwable> sealLocked(Throwable proposedException) {
            Object allocateList;
            ArrayList equal;
            int i2;
            int i;
            Object exceptionsHolder = getExceptionsHolder();
            if (exceptionsHolder == null) {
                allocateList = allocateList();
                Throwable rootCause = getRootCause();
                if (rootCause != null) {
                    i2 = 0;
                    allocateList.add(0, rootCause);
                }
                if (proposedException != null && !Intrinsics.areEqual(proposedException, rootCause)) {
                    if (!Intrinsics.areEqual(proposedException, rootCause)) {
                        allocateList.add(proposedException);
                    }
                }
                setExceptionsHolder(JobSupportKt.access$getSEALED$p());
                return (List)allocateList;
            } else {
                if (exceptionsHolder instanceof Throwable) {
                    i2 = 0;
                    allocateList().add(exceptionsHolder);
                } else {
                    if (exceptionsHolder instanceof ArrayList == null) {
                    } else {
                        allocateList = exceptionsHolder;
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalStateException list = new IllegalStateException(stringBuilder.append("State is ").append(exceptionsHolder).toString().toString());
            throw list;
        }

        @Override // kotlinx.coroutines.Incomplete
        public final void setCompleting(boolean value) {
            JobSupport.Finishing._isCompleting$FU.set(this, value);
        }

        @Override // kotlinx.coroutines.Incomplete
        public final void setRootCause(Throwable value) {
            JobSupport.Finishing._rootCause$FU.set(this, value);
        }

        @Override // kotlinx.coroutines.Incomplete
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Finishing[cancelling=").append(isCancelling()).append(", completing=").append(isCompleting()).append(", rootCause=").append(getRootCause()).append(", exceptions=").append(getExceptionsHolder()).append(", list=").append(getList()).append(']').toString();
        }
    }

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0096\u0002R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lkotlinx/coroutines/JobSupport$SelectOnAwaitCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class SelectOnAwaitCompletionHandler extends kotlinx.coroutines.JobNode {

        private final SelectInstance<?> select;
        final kotlinx.coroutines.JobSupport this$0;
        public SelectOnAwaitCompletionHandler(kotlinx.coroutines.JobSupport this$0, SelectInstance select) {
            this.this$0 = this$0;
            super();
            this.select = select;
        }

        @Override // kotlinx.coroutines.JobNode
        public Object invoke(Object p1) {
            invoke((Throwable)p1);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.JobNode
        public void invoke(Throwable cause) {
            Object unboxState;
            Object state$kotlinx_coroutines_core = this.this$0.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                unboxState = state$kotlinx_coroutines_core;
            } else {
                unboxState = JobSupportKt.unboxState(state$kotlinx_coroutines_core);
            }
            this.select.trySelect(this.this$0, unboxState);
        }
    }

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0008H\u0096\u0002R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\u0008\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lkotlinx/coroutines/JobSupport$SelectOnJoinCompletionHandler;", "Lkotlinx/coroutines/JobNode;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/selects/SelectInstance;)V", "invoke", "", "cause", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class SelectOnJoinCompletionHandler extends kotlinx.coroutines.JobNode {

        private final SelectInstance<?> select;
        final kotlinx.coroutines.JobSupport this$0;
        public SelectOnJoinCompletionHandler(kotlinx.coroutines.JobSupport this$0, SelectInstance select) {
            this.this$0 = this$0;
            super();
            this.select = select;
        }

        @Override // kotlinx.coroutines.JobNode
        public Object invoke(Object p1) {
            invoke((Throwable)p1);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.JobNode
        public void invoke(Throwable cause) {
            this.select.trySelect(this.this$0, Unit.INSTANCE);
        }
    }
    static {
        final Class<kotlinx.coroutines.JobSupport> obj3 = JobSupport.class;
        JobSupport._state$FU = AtomicReferenceFieldUpdater.newUpdater(obj3, Object.class, "_state");
        JobSupport._parentHandle$FU = AtomicReferenceFieldUpdater.newUpdater(obj3, Object.class, "_parentHandle");
    }

    public JobSupport(boolean active) {
        kotlinx.coroutines.Empty empty;
        super();
        if (active) {
            empty = JobSupportKt.access$getEMPTY_ACTIVE$p();
        } else {
            empty = JobSupportKt.access$getEMPTY_NEW$p();
        }
        this._state = empty;
    }

    public static final Object access$awaitSuspend(kotlinx.coroutines.JobSupport $this, Continuation $completion) {
        return $this.awaitSuspend($completion);
    }

    public static final String access$cancellationExceptionMessage(kotlinx.coroutines.JobSupport $this) {
        return $this.cancellationExceptionMessage();
    }

    public static final void access$continueCompleting(kotlinx.coroutines.JobSupport $this, kotlinx.coroutines.JobSupport.Finishing state, kotlinx.coroutines.ChildHandleNode lastChild, Object proposedUpdate) {
        $this.continueCompleting(state, lastChild, proposedUpdate);
    }

    public static final Object access$joinSuspend(kotlinx.coroutines.JobSupport $this, Continuation $completion) {
        return $this.joinSuspend($completion);
    }

    public static final Object access$onAwaitInternalProcessResFunc(kotlinx.coroutines.JobSupport $this, Object ignoredParam, Object result) {
        return $this.onAwaitInternalProcessResFunc(ignoredParam, result);
    }

    public static final void access$onAwaitInternalRegFunc(kotlinx.coroutines.JobSupport $this, SelectInstance select, Object ignoredParam) {
        $this.onAwaitInternalRegFunc(select, ignoredParam);
    }

    public static final void access$registerSelectForOnJoin(kotlinx.coroutines.JobSupport $this, SelectInstance select, Object ignoredParam) {
        $this.registerSelectForOnJoin(select, ignoredParam);
    }

    private final boolean addLastAtomic(Object expect, kotlinx.coroutines.NodeList list, kotlinx.coroutines.JobNode node) {
        LockFreeLinkedListNode prevNode;
        int tryCondAddNext;
        int i;
        final LockFreeLinkedListNode list2 = list;
        final int i2 = 0;
        prevNode = list2;
        tryCondAddNext = 0;
        JobSupport.addLastAtomic$$inlined.addLastIf.1 anon = new JobSupport.addLastAtomic$$inlined.addLastIf.1((LockFreeLinkedListNode)node, this, expect);
        while (/* condition */) {
        }
        i = 1;
        return i;
    }

    private final void addSuppressedExceptions(Throwable rootCause, List<? extends Throwable> exceptions) {
        Throwable unwrapImpl2;
        Object next;
        int i2;
        Throwable unwrapImpl;
        int i;
        if (exceptions.size() <= 1) {
        }
        int i4 = 0;
        IdentityHashMap identityHashMap = new IdentityHashMap(exceptions.size());
        int i5 = 0;
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            unwrapImpl2 = rootCause;
        } else {
            unwrapImpl2 = StackTraceRecoveryKt.unwrapImpl(rootCause);
        }
        Iterator iterator = exceptions.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            i2 = 0;
            if (!DebugKt.getRECOVER_STACK_TRACES()) {
            } else {
            }
            unwrapImpl = StackTraceRecoveryKt.unwrapImpl((Throwable)next);
            if (unwrapImpl != rootCause && unwrapImpl != unwrapImpl2 && unwrapImpl instanceof CancellationException == null && Collections.newSetFromMap((Map)identityHashMap).add(unwrapImpl)) {
            }
            if (unwrapImpl != unwrapImpl2) {
            }
            if (unwrapImpl instanceof CancellationException == null) {
            }
            if (expectedSize$iv.add(unwrapImpl)) {
            }
            i = 0;
            ExceptionsKt.addSuppressed(rootCause, unwrapImpl);
            unwrapImpl = next;
        }
    }

    private final Object awaitSuspend(Continuation<Object> $completion) {
        int i = 0;
        JobSupport.AwaitContinuation awaitContinuation = new JobSupport.AwaitContinuation(IntrinsicsKt.intercepted($completion), this);
        awaitContinuation.initCancellability();
        ResumeAwaitOnCompletion resumeAwaitOnCompletion = new ResumeAwaitOnCompletion((CancellableContinuationImpl)awaitContinuation);
        int i2 = 0;
        CancellableContinuationKt.disposeOnCancellation((CancellableContinuation)awaitContinuation, invokeOnCompletion((Function1)(CompletionHandlerBase)resumeAwaitOnCompletion));
        Object uCont = awaitContinuation.getResult();
        if (uCont == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        return uCont;
    }

    private final Object cancelMakeCompleting(Object cause) {
        Object state$kotlinx_coroutines_core;
        int i;
        kotlinx.coroutines.CompletedExceptionally completedExceptionally;
        boolean completing;
        Object tryMakeCompleting;
        kotlinx.coroutines.internal.Symbol symbol;
        int i3;
        int i2;
        final int i4 = 0;
        state$kotlinx_coroutines_core = this.getState$kotlinx_coroutines_core();
        i = 0;
        while (state$kotlinx_coroutines_core instanceof Incomplete) {
            completedExceptionally = new CompletedExceptionally(createCauseException(cause), 0, 2, 0);
            tryMakeCompleting = tryMakeCompleting(state$kotlinx_coroutines_core, completedExceptionally);
            state$kotlinx_coroutines_core = obj.getState$kotlinx_coroutines_core();
            i = 0;
        }
        return JobSupportKt.access$getCOMPLETING_ALREADY$p();
    }

    private final boolean cancelParent(Throwable cause) {
        int i;
        kotlinx.coroutines.NonDisposableHandle iNSTANCE;
        if (isScopedCoroutine()) {
            return 1;
        }
        boolean z = cause instanceof CancellationException;
        final kotlinx.coroutines.ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            if (parentHandle$kotlinx_coroutines_core == NonDisposableHandle.INSTANCE) {
            } else {
                if (!parentHandle$kotlinx_coroutines_core.childCancelled(cause)) {
                    if (z) {
                    } else {
                        i = 0;
                    }
                }
            }
            return i;
        }
        return z;
    }

    private final void completeStateFinalization(kotlinx.coroutines.Incomplete state, Object update) {
        Object obj;
        Object list;
        int i;
        int cause;
        Object completionHandlerException;
        StringBuilder string;
        String str;
        kotlinx.coroutines.ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            i = 0;
            parentHandle$kotlinx_coroutines_core.dispose();
            setParentHandle$kotlinx_coroutines_core((ChildHandle)NonDisposableHandle.INSTANCE);
        }
        if (update instanceof CompletedExceptionally) {
            obj = update;
        } else {
            obj = cause;
        }
        if (obj != null) {
            cause = obj.cause;
        }
        if (state instanceof JobNode) {
            (JobNode)state.invoke(cause);
        } else {
            list = state.getList();
            if (list != null) {
                notifyCompletion(list, cause);
            }
        }
    }

    private final void continueCompleting(kotlinx.coroutines.JobSupport.Finishing state, kotlinx.coroutines.ChildHandleNode lastChild, Object proposedUpdate) {
        boolean aSSERTIONS_ENABLED;
        int tryWaitForChild;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            tryWaitForChild = getState$kotlinx_coroutines_core() == state ? 1 : 0;
            if (tryWaitForChild == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        kotlinx.coroutines.ChildHandleNode nextChild = nextChild((LockFreeLinkedListNode)lastChild);
        if (nextChild != null && tryWaitForChild(state, nextChild, proposedUpdate)) {
            if (tryWaitForChild(state, nextChild, proposedUpdate)) {
            }
        }
        afterCompletion(finalizeFinishingState(state, proposedUpdate));
    }

    private final Throwable createCauseException(Object cause) {
        boolean z;
        Object message$iv;
        int i;
        int i2;
        kotlinx.coroutines.JobCancellationException jobCancellationException;
        String str;
        kotlinx.coroutines.JobSupport jobSupport;
        z = cause == null ? 1 : cause instanceof Throwable;
        if (z) {
            if ((Throwable)cause == null) {
                int i3 = 0;
                i2 = 0;
                jobCancellationException = new JobCancellationException(JobSupport.access$cancellationExceptionMessage(this), 0, (Job)this);
                message$iv = jobCancellationException;
            }
        } else {
            Intrinsics.checkNotNull(cause, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
            message$iv = (ParentJob)cause.getChildJobCancellationCause();
        }
        return message$iv;
    }

    public static kotlinx.coroutines.JobCancellationException defaultCancellationException$kotlinx_coroutines_core$default(kotlinx.coroutines.JobSupport $this, String message, Throwable cause, int i4, Object object5) {
        int i;
        int obj3;
        int obj4;
        if (object5 != null) {
        } else {
            if (i4 & 1 != 0) {
                obj3 = 0;
            }
            if (i4 &= 2 != 0) {
                obj4 = 0;
            }
            int obj5 = 0;
            if (obj3 == null) {
                i = JobSupport.access$cancellationExceptionMessage($this);
            } else {
                i = obj3;
            }
            JobCancellationException obj6 = new JobCancellationException(i, obj4, (Job)$this);
            return obj6;
        }
        obj5 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: defaultCancellationException");
        throw obj5;
    }

    private final Object finalizeFinishingState(kotlinx.coroutines.JobSupport.Finishing state, Object proposedUpdate) {
        int $i$a$AssertJobSupport$finalizeFinishingState$1;
        boolean aSSERTIONS_ENABLED2;
        boolean $i$a$AssertJobSupport$finalizeFinishingState$3;
        int i4;
        int cause;
        int i3;
        int i2;
        boolean aSSERTIONS_ENABLED;
        Object state$kotlinx_coroutines_core;
        boolean cancelParent;
        Object completedExceptionally;
        int i;
        i2 = 0;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i5 = 0;
            $i$a$AssertJobSupport$finalizeFinishingState$1 = getState$kotlinx_coroutines_core() == state ? i3 : i2;
            if ($i$a$AssertJobSupport$finalizeFinishingState$1 == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED2 = 0;
            if (state.isSealed()) {
            } else {
            }
            AssertionError assertionError2 = new AssertionError();
            throw assertionError2;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i6 = 0;
            if (!state.isCompleting()) {
            } else {
            }
            AssertionError assertionError3 = new AssertionError();
            throw assertionError3;
        }
        cancelParent = 0;
        if (proposedUpdate instanceof CompletedExceptionally) {
            i4 = proposedUpdate;
        } else {
            i4 = cancelParent;
        }
        cause = i4 != 0 ? i4.cause : cancelParent;
        int i7 = 0;
        int i8 = 0;
        i = 0;
        final int i9 = 0;
        List sealLocked = state.sealLocked(cause);
        final Throwable finalRootCause = getFinalRootCause(state, sealLocked);
        synchronized (state) {
            addSuppressedExceptions(finalRootCause, sealLocked);
            if (finalRootCause == null) {
            } else {
                if (finalRootCause == cause) {
                    completedExceptionally = proposedUpdate;
                } else {
                    completedExceptionally = new CompletedExceptionally(finalRootCause, i2, 2, cancelParent);
                }
            }
            if (finalRootCause != null && !cancelParent(finalRootCause)) {
                if (!cancelParent(finalRootCause)) {
                    if (handleJobException(finalRootCause)) {
                    } else {
                        i3 = i2;
                    }
                }
                if (i3 != 0) {
                    Intrinsics.checkNotNull(completedExceptionally, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                    (CompletedExceptionally)completedExceptionally.makeHandled();
                }
            }
            if (!state.isCancelling()) {
                onCancelling(finalRootCause);
            }
            onCompletionInternal(completedExceptionally);
            if (DebugKt.getASSERTIONS_ENABLED()) {
                aSSERTIONS_ENABLED = 0;
                if (!AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport._state$FU, this, state, JobSupportKt.boxIncomplete(completedExceptionally))) {
                } else {
                }
                AssertionError assertionError4 = new AssertionError();
                throw assertionError4;
            }
            completeStateFinalization((Incomplete)state, completedExceptionally);
            return completedExceptionally;
        }
    }

    private final kotlinx.coroutines.ChildHandleNode firstChild(kotlinx.coroutines.Incomplete state) {
        int list;
        int nextChild;
        if (state instanceof ChildHandleNode) {
            list = state;
        } else {
            list = nextChild;
        }
        if (list == null) {
            list = state.getList();
            if (list != null) {
                nextChild = nextChild((LockFreeLinkedListNode)list);
            }
        } else {
            nextChild = list;
        }
        return nextChild;
    }

    private final Throwable getExceptionOrNull(Object $this$exceptionOrNull) {
        Object obj;
        int cause;
        if ($this$exceptionOrNull instanceof CompletedExceptionally) {
            obj = $this$exceptionOrNull;
        } else {
            obj = cause;
        }
        if (obj != null) {
            cause = obj.cause;
        }
        return cause;
    }

    private final Throwable getFinalRootCause(kotlinx.coroutines.JobSupport.Finishing state, List<? extends Throwable> exceptions) {
        boolean i2;
        Object element$iv;
        boolean z;
        Object obj;
        int iterator;
        boolean next;
        boolean z2;
        int i3;
        int i;
        i2 = 0;
        if (exceptions.isEmpty() && state.isCancelling()) {
            if (state.isCancelling()) {
                int i4 = 0;
                int i6 = 0;
                JobCancellationException jobCancellationException = new JobCancellationException(JobSupport.access$cancellationExceptionMessage(this), 0, (Job)this);
                return (Throwable)jobCancellationException;
            }
            return i2;
        }
        int i7 = 0;
        Iterator iterator2 = (Iterable)exceptions.iterator();
        for (Object element$iv : iterator2) {
            iterator = 0;
        }
        element$iv = i2;
        Object $this$firstOrNull$iv = element$iv;
        if ((Throwable)$this$firstOrNull$iv != null) {
            return (Throwable)$this$firstOrNull$iv;
        }
        int i8 = 0;
        Object obj2 = exceptions.get(i8);
        if (obj2 instanceof TimeoutCancellationException != null) {
            obj = 0;
            iterator = (Iterable)exceptions.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                z2 = next;
                i3 = 0;
                if ((Throwable)z2 != (Throwable)obj2 && z2 instanceof TimeoutCancellationException != null) {
                } else {
                }
                i = i8;
                if (z2 instanceof TimeoutCancellationException != null) {
                } else {
                }
                i = 1;
            }
            if ((Throwable)i2) {
                return (Throwable)i2;
            }
        }
        return (Throwable)obj2;
    }

    protected static void getOnAwaitInternal$annotations() {
    }

    public static void getOnJoin$annotations() {
    }

    private final kotlinx.coroutines.NodeList getOrPromoteCancellingList(kotlinx.coroutines.Incomplete state) {
        kotlinx.coroutines.NodeList nodeList;
        if (state.getList() == null) {
            if (state instanceof Empty) {
                nodeList = new NodeList();
            } else {
                if (!state instanceof JobNode) {
                } else {
                    promoteSingleToNodeList((JobNode)state);
                    nodeList = 0;
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("State should have list: ").append(state).toString().toString());
            throw illegalStateException;
        }
        return nodeList;
    }

    private final boolean isCancelling(kotlinx.coroutines.Incomplete $this$isCancelling) {
        boolean cancelling;
        int i;
        if ($this$isCancelling instanceof JobSupport.Finishing && (JobSupport.Finishing)$this$isCancelling.isCancelling()) {
            i = (JobSupport.Finishing)$this$isCancelling.isCancelling() ? 1 : 0;
        } else {
        }
        return i;
    }

    private final boolean joinInternal() {
        Object state$kotlinx_coroutines_core;
        int i;
        int internal;
        final int i2 = 0;
        state$kotlinx_coroutines_core = this.getState$kotlinx_coroutines_core();
        i = 0;
        while (!state$kotlinx_coroutines_core instanceof Incomplete) {
            state$kotlinx_coroutines_core = obj.getState$kotlinx_coroutines_core();
            i = 0;
        }
        return 0;
    }

    private final Object joinSuspend(Continuation<? super Unit> $completion) {
        int i = 0;
        int i2 = 0;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted($completion), 1);
        cancellableContinuationImpl.initCancellability();
        kotlinx.coroutines.CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        int i4 = 0;
        ResumeOnCompletion resumeOnCompletion = new ResumeOnCompletion((Continuation)(CancellableContinuation)cancellableContinuationImpl2);
        int i5 = 0;
        CancellableContinuationKt.disposeOnCancellation(cancellableContinuationImpl2, invokeOnCompletion((Function1)(CompletionHandlerBase)resumeOnCompletion));
        Object uCont$iv = cancellableContinuationImpl.getResult();
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended($completion);
        }
        if (uCont$iv == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return uCont$iv;
        }
        return Unit.INSTANCE;
    }

    private final void loop$atomicfu(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Function1<Object, Unit> function12, Object object3) {
        Object obj;
        final int i = 0;
        while (true) {
            function12.invoke(atomicReferenceFieldUpdater.get(object3));
        }
    }

    private final Void loopOnState(Function1<Object, Unit> block) {
        Object state$kotlinx_coroutines_core;
        final int i = 0;
        while (true) {
            block.invoke(getState$kotlinx_coroutines_core());
        }
    }

    private final Object makeCancelling(Object cause) {
        int tryMakeCancelling;
        int i4;
        Throwable causeException;
        int i3;
        int causeException2;
        Object state$kotlinx_coroutines_core;
        int i2;
        int i6;
        int i5;
        Throwable causeExceptionCache;
        int list;
        int i;
        int i7;
        Object obj;
        int i8;
        Throwable th;
        final Object obj4 = this;
        final int i9 = 0;
        causeException2 = tryMakeCancelling;
        state$kotlinx_coroutines_core = this.getState$kotlinx_coroutines_core();
        i2 = 0;
        while (state$kotlinx_coroutines_core instanceof JobSupport.Finishing) {
            if (causeException2 == 0) {
            } else {
            }
            causeExceptionCache = causeException2;
            CompletedExceptionally completedExceptionally = new CompletedExceptionally(causeException2, 0, 2, 0);
            tryMakeCancelling = obj4.tryMakeCompleting(state$kotlinx_coroutines_core, completedExceptionally);
            causeException2 = causeExceptionCache;
            state$kotlinx_coroutines_core = obj5.getState$kotlinx_coroutines_core();
            i2 = 0;
            causeException = createCauseException(cause);
            causeExceptionCache = causeException;
            i = 0;
            causeException2 = causeException;
        }
        list = 0;
        int i10 = 0;
        i4 = 0;
        synchronized (state$kotlinx_coroutines_core) {
            return JobSupportKt.access$getTOO_LATE_TO_CANCEL$p();
        }
        i5 = 0;
        obj4.notifyCancelling((JobSupport.Finishing)state$kotlinx_coroutines_core.getList(), i6);
        return JobSupportKt.access$getCOMPLETING_ALREADY$p();
    }

    private final kotlinx.coroutines.JobNode makeNode(Function1<? super Throwable, Unit> handler, boolean onCancelling) {
        int invokeOnCompletion;
        boolean i2;
        int i;
        boolean aSSERTIONS_ENABLED;
        boolean z;
        invokeOnCompletion = 0;
        if (onCancelling) {
            if (handler instanceof JobCancellingNode) {
                invokeOnCompletion = handler;
            }
            if (invokeOnCompletion == 0) {
                invokeOnCompletion = new InvokeOnCancelling(handler);
            }
        } else {
            if (handler instanceof JobNode) {
                invokeOnCompletion = handler;
            }
            if (invokeOnCompletion != 0) {
                i = 0;
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    aSSERTIONS_ENABLED = 0;
                    if (i2 instanceof JobCancellingNode) {
                    } else {
                    }
                    AssertionError assertionError = new AssertionError();
                    throw assertionError;
                }
            } else {
                invokeOnCompletion = new InvokeOnCompletion(handler);
            }
        }
        invokeOnCompletion.setJob(this);
        return invokeOnCompletion;
    }

    private final kotlinx.coroutines.ChildHandleNode nextChild(LockFreeLinkedListNode $this$nextChild) {
        LockFreeLinkedListNode cur;
        boolean removed;
        cur = $this$nextChild;
        while (cur.isRemoved()) {
            cur = cur.getPrevNode();
        }
        cur = cur.getNextNode();
        while (!cur.isRemoved()) {
            cur = cur.getNextNode();
        }
        return (ChildHandleNode)cur;
    }

    private final void notifyCancelling(kotlinx.coroutines.NodeList list, Throwable cause) {
        int i3;
        Object obj3;
        int i4;
        Object cur$iv$iv;
        Object obj2;
        int i;
        Object obj;
        int i2;
        int completionHandlerException;
        Throwable string;
        int str;
        final Object obj4 = this;
        final Throwable th2 = cause;
        obj4.onCancelling(th2);
        final int i6 = 0;
        obj3 = list;
        final int i7 = 0;
        Object next = (LockFreeLinkedListHead)obj3.getNext();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        cur$iv$iv = next;
        i4 = i3;
        while (!Intrinsics.areEqual(cur$iv$iv, obj3)) {
            if (cur$iv$iv instanceof JobCancellingNode) {
            }
            cur$iv$iv = cur$iv$iv.getNextNode();
            i = 0;
            (JobNode)cur$iv$iv.invoke(th2);
            obj = unit;
            if ((Throwable)obj != null) {
            } else {
            }
            completionHandlerException = 0;
            string = i2;
            str = 0;
            ExceptionsKt.addSuppressed(string, th);
            if (obj == null) {
            }
            obj = obj3;
            string = new StringBuilder();
            str = "Exception in completion handler ";
            string = string.append(str);
            string = string.append(obj9);
            str = " for ";
            string = string.append(str);
            string = string.append(obj);
            string = string.toString();
            completionHandlerException = new CompletionHandlerException(string, th);
        }
        int i5 = i4;
        if ((Throwable)i5 != 0) {
            obj3 = 0;
            this.handleOnCompletionException$kotlinx_coroutines_core((Throwable)i5);
        }
        obj4.cancelParent(th2);
    }

    private final void notifyCompletion(kotlinx.coroutines.NodeList $this$notifyCompletion, Throwable cause) {
        int i3;
        Object obj2;
        int i;
        Object cur$iv$iv;
        Object obj;
        int i4;
        Throwable th;
        Object obj3;
        int i2;
        int completionHandlerException;
        Throwable string;
        int str;
        final int i6 = 0;
        obj2 = $this$notifyCompletion;
        final int i7 = 0;
        Object next = (LockFreeLinkedListHead)obj2.getNext();
        Intrinsics.checkNotNull(next, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        cur$iv$iv = next;
        i = i3;
        while (!Intrinsics.areEqual(cur$iv$iv, obj2)) {
            if (cur$iv$iv instanceof JobNode) {
            } else {
            }
            th = cause;
            cur$iv$iv = cur$iv$iv.getNextNode();
            i4 = 0;
            (JobNode)cur$iv$iv.invoke(cause);
            obj3 = unit;
            if ((Throwable)obj3 != null) {
            } else {
            }
            completionHandlerException = 0;
            string = i2;
            str = 0;
            ExceptionsKt.addSuppressed(string, th2);
            if (obj3 == null) {
            }
            obj3 = obj1;
            string = new StringBuilder();
            str = "Exception in completion handler ";
            string = string.append(str);
            string = string.append(obj7);
            str = " for ";
            string = string.append(str);
            string = string.append(obj3);
            string = string.toString();
            completionHandlerException = new CompletionHandlerException(string, th2);
        }
        Throwable th3 = cause;
        int i5 = i;
        if ((Throwable)i5 != 0) {
            obj2 = 0;
            this.handleOnCompletionException$kotlinx_coroutines_core((Throwable)i5);
        }
    }

    private final <T extends kotlinx.coroutines.JobNode> void notifyHandlers(kotlinx.coroutines.NodeList list, Throwable cause) {
        int i;
        int i3;
        Object cur$iv;
        String str2;
        String str3;
        Throwable th;
        Object obj;
        int i2;
        int completionHandlerException;
        Throwable string;
        int str;
        final int i4 = 0;
        i = 0;
        Object obj2 = list;
        i3 = 0;
        Intrinsics.checkNotNull((LockFreeLinkedListHead)obj2.getNext(), "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        while (!Intrinsics.areEqual(cur$iv, obj2)) {
            Intrinsics.reifiedOperationMarker(3, "T");
            if (cur$iv instanceof LockFreeLinkedListNode) {
            }
            cur$iv = cur$iv.getNextNode();
            str3 = 0;
            (JobNode)cur$iv.invoke(cause);
            obj = unit;
            if ((Throwable)obj != null) {
            } else {
            }
            completionHandlerException = 0;
            string = i2;
            str = 0;
            ExceptionsKt.addSuppressed(string, th);
            if (obj == null) {
            }
            obj = this;
            string = new StringBuilder();
            str = "Exception in completion handler ";
            string = string.append(str);
            string = string.append(obj5);
            str = " for ";
            string = string.append(str);
            string = string.append((JobSupport)obj);
            string = string.toString();
            completionHandlerException = new CompletionHandlerException(string, th);
        }
        int this_$iv = i;
        if ((Throwable)this_$iv != 0) {
            i3 = 0;
            handleOnCompletionException$kotlinx_coroutines_core((Throwable)(Throwable)this_$iv);
        }
    }

    private final Object onAwaitInternalProcessResFunc(Object ignoredParam, Object result) {
        if (result instanceof CompletedExceptionally) {
        } else {
            return result;
        }
        throw obj.cause;
    }

    private final void onAwaitInternalRegFunc(SelectInstance<?> select, Object ignoredParam) {
        Object state$kotlinx_coroutines_core;
        int internal;
        Object unboxState;
        state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        while (!state$kotlinx_coroutines_core instanceof Incomplete) {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        }
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            unboxState = state$kotlinx_coroutines_core;
        } else {
            unboxState = JobSupportKt.unboxState(state$kotlinx_coroutines_core);
        }
        select.selectInRegistrationPhase(unboxState);
    }

    private final void promoteEmptyToNodeList(kotlinx.coroutines.Empty state) {
        Object inactiveNodeList;
        NodeList nodeList = new NodeList();
        if (state.isActive()) {
            inactiveNodeList = nodeList;
        } else {
            inactiveNodeList = new InactiveNodeList(nodeList);
        }
        AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport._state$FU, this, state, inactiveNodeList);
    }

    private final void promoteSingleToNodeList(kotlinx.coroutines.JobNode state) {
        NodeList nodeList = new NodeList();
        state.addOneIfEmpty((LockFreeLinkedListNode)nodeList);
        AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport._state$FU, this, state, state.getNextNode());
    }

    private final void registerSelectForOnJoin(SelectInstance<?> select, Object ignoredParam) {
        if (!joinInternal()) {
            select.selectInRegistrationPhase(Unit.INSTANCE);
        }
        JobSupport.SelectOnJoinCompletionHandler selectOnJoinCompletionHandler = new JobSupport.SelectOnJoinCompletionHandler(this, select);
        final int i = 0;
        select.disposeOnCompletion(invokeOnCompletion((Function1)(CompletionHandlerBase)selectOnJoinCompletionHandler));
    }

    private final int startInternal(Object state) {
        final int i = -1;
        final int i2 = 1;
        int i3 = 0;
        if (state instanceof Empty && (Empty)state.isActive()) {
            if ((Empty)state.isActive()) {
                return i3;
            }
            if (!AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport._state$FU, this, state, JobSupportKt.access$getEMPTY_ACTIVE$p())) {
                return i;
            }
            onStart();
            return i2;
        }
        if (state instanceof InactiveNodeList != null && !AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport._state$FU, this, state, (InactiveNodeList)state.getList())) {
            if (!AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport._state$FU, this, state, (InactiveNodeList)state.getList())) {
                return i;
            }
            onStart();
            return i2;
        }
        return i3;
    }

    private final String stateString(Object state) {
        boolean cancelling;
        String str;
        str = "Active";
        if (state instanceof JobSupport.Finishing) {
            if ((JobSupport.Finishing)state.isCancelling()) {
                str = "Cancelling";
            } else {
                if ((JobSupport.Finishing)state.isCompleting()) {
                    str = "Completing";
                } else {
                }
            }
        } else {
            if (state instanceof Incomplete) {
                if ((Incomplete)state.isActive()) {
                } else {
                    str = "New";
                }
            } else {
                str = state instanceof CompletedExceptionally ? "Cancelled" : "Completed";
            }
        }
        return str;
    }

    public static CancellationException toCancellationException$default(kotlinx.coroutines.JobSupport jobSupport, Throwable throwable2, String string3, int i4, Object object5) {
        int obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 1 != 0) {
                obj2 = 0;
            }
            return jobSupport.toCancellationException(throwable2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        throw obj0;
    }

    private final boolean tryFinalizeSimpleState(kotlinx.coroutines.Incomplete state, Object update) {
        boolean $i$a$AssertJobSupport$tryFinalizeSimpleState$1;
        boolean aSSERTIONS_ENABLED;
        boolean z;
        final int i3 = 0;
        final int i4 = 1;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i2 = 0;
            if (!state instanceof Empty) {
                if (state instanceof JobNode) {
                    $i$a$AssertJobSupport$tryFinalizeSimpleState$1 = i4;
                } else {
                    $i$a$AssertJobSupport$tryFinalizeSimpleState$1 = i3;
                }
            } else {
            }
            if ($i$a$AssertJobSupport$tryFinalizeSimpleState$1 == 0) {
            } else {
            }
            AssertionError assertionError2 = new AssertionError();
            throw assertionError2;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            if (update instanceof CompletedExceptionally) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        if (!AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport._state$FU, this, state, JobSupportKt.boxIncomplete(update))) {
            return i3;
        }
        onCancelling(0);
        onCompletionInternal(update);
        completeStateFinalization(state, update);
        return i4;
    }

    private final boolean tryMakeCancelling(kotlinx.coroutines.Incomplete state, Throwable rootCause) {
        boolean aSSERTIONS_ENABLED;
        boolean $i$a$AssertJobSupport$tryMakeCancelling$2;
        boolean z;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            if (state instanceof JobSupport.Finishing) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            int i = 0;
            if (!state.isActive()) {
            } else {
            }
            AssertionError assertionError2 = new AssertionError();
            throw assertionError2;
        }
        kotlinx.coroutines.NodeList orPromoteCancellingList = getOrPromoteCancellingList(state);
        int i2 = 0;
        if (orPromoteCancellingList == null) {
            return i2;
        }
        JobSupport.Finishing finishing = new JobSupport.Finishing(orPromoteCancellingList, i2, rootCause);
        if (!AbstractResolvableFuture.SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(JobSupport._state$FU, this, state, finishing)) {
            return i2;
        }
        notifyCancelling(orPromoteCancellingList, rootCause);
        return 1;
    }

    private final Object tryMakeCompleting(Object state, Object proposedUpdate) {
        boolean z;
        if (!state instanceof Incomplete) {
            return JobSupportKt.access$getCOMPLETING_ALREADY$p();
        }
        if (!state instanceof Empty) {
            if (state instanceof JobNode && !state instanceof ChildHandleNode && !proposedUpdate instanceof CompletedExceptionally && tryFinalizeSimpleState((Incomplete)state, proposedUpdate)) {
                if (!state instanceof ChildHandleNode) {
                    if (!proposedUpdate instanceof CompletedExceptionally) {
                        if (tryFinalizeSimpleState((Incomplete)state, proposedUpdate)) {
                            return proposedUpdate;
                        }
                        return JobSupportKt.access$getCOMPLETING_RETRY$p();
                    }
                }
            }
        } else {
        }
        return tryMakeCompletingSlowPath((Incomplete)state, proposedUpdate);
    }

    private final Object tryMakeCompletingSlowPath(kotlinx.coroutines.Incomplete state, Object proposedUpdate) {
        kotlinx.coroutines.Incomplete finishing;
        int i;
        int i3;
        boolean tryWaitForChild;
        boolean z;
        boolean aSSERTIONS_ENABLED;
        boolean sealed;
        int i4;
        int i2;
        Throwable cause;
        kotlinx.coroutines.NodeList orPromoteCancellingList = getOrPromoteCancellingList(state);
        if (orPromoteCancellingList == null) {
            return JobSupportKt.access$getCOMPLETING_RETRY$p();
        }
        i = 0;
        if (state instanceof JobSupport.Finishing) {
            finishing = state;
        } else {
            finishing = i;
        }
        if (finishing == null) {
            finishing = new JobSupport.Finishing(orPromoteCancellingList, 0, i);
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        final int i5 = 0;
        final int i6 = 0;
        final int i7 = 0;
        synchronized (finishing) {
            return JobSupportKt.access$getCOMPLETING_ALREADY$p();
        }
        tryWaitForChild = 0;
        notifyCancelling(orPromoteCancellingList, element);
        kotlinx.coroutines.ChildHandleNode firstChild = firstChild(state);
        if (firstChild != null && tryWaitForChild(finishing, firstChild, proposedUpdate)) {
            if (tryWaitForChild(finishing, firstChild, proposedUpdate)) {
                return JobSupportKt.COMPLETING_WAITING_CHILDREN;
            }
        }
        return finalizeFinishingState(finishing, proposedUpdate);
    }

    private final boolean tryWaitForChild(kotlinx.coroutines.JobSupport.Finishing state, kotlinx.coroutines.ChildHandleNode child, Object proposedUpdate) {
        kotlinx.coroutines.DisposableHandle onCompletion$default;
        kotlinx.coroutines.ChildHandleNode nextChild;
        int i3;
        int i;
        kotlinx.coroutines.JobSupport.ChildCompletion childCompletion;
        int i2;
        int i4;
        Object obj9;
        JobSupport.ChildCompletion childCompletion2 = new JobSupport.ChildCompletion(this, state, obj9, proposedUpdate);
        int i7 = 0;
        while (Job.DefaultImpls.invokeOnCompletion$default((Job)obj9.childJob, false, false, (Function1)(CompletionHandlerBase)childCompletion2, 1, 0) != NonDisposableHandle.INSTANCE) {
            nextChild = nextChild((LockFreeLinkedListNode)obj9);
            obj9 = nextChild;
            childCompletion2 = new JobSupport.ChildCompletion(this, state, obj9, proposedUpdate);
            i7 = 0;
        }
        return 1;
    }

    @Override // kotlinx.coroutines.Job
    protected void afterCompletion(Object state) {
    }

    @Override // kotlinx.coroutines.Job
    public final kotlinx.coroutines.ChildHandle attachChild(kotlinx.coroutines.ChildJob child) {
        ChildHandleNode childHandleNode = new ChildHandleNode(child);
        int i2 = 0;
        kotlinx.coroutines.DisposableHandle onCompletion$default = Job.DefaultImpls.invokeOnCompletion$default((Job)this, true, false, (Function1)(CompletionHandlerBase)childHandleNode, 2, 0);
        Intrinsics.checkNotNull(onCompletion$default, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (ChildHandle)onCompletion$default;
    }

    protected final Object awaitInternal(Continuation<Object> $completion) {
        Object state$kotlinx_coroutines_core;
        int internal;
        state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        while (!state$kotlinx_coroutines_core instanceof Incomplete) {
            state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        }
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            Throwable cause = obj.cause;
            final int i = 0;
            if (!DebugKt.getRECOVER_STACK_TRACES()) {
            } else {
                Object obj2 = $completion;
                final int i2 = 0;
                if (!obj2 instanceof CoroutineStackFrame) {
                    throw cause;
                }
                throw StackTraceRecoveryKt.access$recoverFromStackFrame(cause, (CoroutineStackFrame)obj2);
            }
            throw cause;
        }
        return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public void cancel() {
        Job.DefaultImpls.cancel(this);
    }

    @Override // kotlinx.coroutines.Job
    public void cancel(CancellationException cause) {
        int i2;
        int i;
        int i3;
        kotlinx.coroutines.JobCancellationException jobCancellationException;
        String str;
        kotlinx.coroutines.JobSupport jobSupport;
        if (cause == null) {
            i2 = 0;
            i3 = 0;
            jobCancellationException = new JobCancellationException(JobSupport.access$cancellationExceptionMessage(this), 0, (Job)this);
        } else {
            jobCancellationException = cause;
        }
        cancelInternal((Throwable)jobCancellationException);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Added since 1.2.0 for binary compatibility with versions <= 1.1.x")
    public boolean cancel(Throwable cause) {
        CancellationException message$iv;
        int i2;
        int i;
        kotlinx.coroutines.JobCancellationException jobCancellationException;
        String str;
        kotlinx.coroutines.JobSupport jobSupport;
        final int i3 = 1;
        if (cause != null) {
            int i4 = 0;
            if (JobSupport.toCancellationException$default(this, cause, i4, i3, i4) == null) {
                int i5 = 0;
                i = 0;
                jobCancellationException = new JobCancellationException(JobSupport.access$cancellationExceptionMessage(this), 0, (Job)this);
                message$iv = jobCancellationException;
            }
        } else {
        }
        cancelInternal((Throwable)message$iv);
        return i3;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean cancelCoroutine(Throwable cause) {
        return cancelImpl$kotlinx_coroutines_core(cause);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean cancelImpl$kotlinx_coroutines_core(Object cause) {
        Object finalState;
        boolean onCancelComplete$kotlinx_coroutines_core;
        kotlinx.coroutines.internal.Symbol cOMPLETING_WAITING_CHILDREN;
        int i;
        finalState = JobSupportKt.access$getCOMPLETING_ALREADY$p();
        if (getOnCancelComplete$kotlinx_coroutines_core() && cancelMakeCompleting(cause) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            if (cancelMakeCompleting(cause) == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
                return 1;
            }
        }
        if (finalState == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            finalState = makeCancelling(cause);
        }
        if (finalState == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
        } else {
            if (finalState == JobSupportKt.COMPLETING_WAITING_CHILDREN) {
            } else {
                if (finalState == JobSupportKt.access$getTOO_LATE_TO_CANCEL$p()) {
                    i = 0;
                } else {
                    afterCompletion(finalState);
                }
            }
        }
        return i;
    }

    @Override // kotlinx.coroutines.Job
    public void cancelInternal(Throwable cause) {
        cancelImpl$kotlinx_coroutines_core(cause);
    }

    @Override // kotlinx.coroutines.Job
    protected String cancellationExceptionMessage() {
        return "Job was cancelled";
    }

    @Override // kotlinx.coroutines.Job
    public boolean childCancelled(Throwable cause) {
        boolean cancelImpl$kotlinx_coroutines_core;
        int i;
        if (cause instanceof CancellationException != null) {
            return 1;
        }
        if (cancelImpl$kotlinx_coroutines_core(cause) && getHandlesException$kotlinx_coroutines_core()) {
            if (getHandlesException$kotlinx_coroutines_core()) {
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // kotlinx.coroutines.Job
    public final kotlinx.coroutines.JobCancellationException defaultCancellationException$kotlinx_coroutines_core(String message, Throwable cause) {
        String str;
        final int i = 0;
        if (message == null) {
            str = JobSupport.access$cancellationExceptionMessage(this);
        } else {
            str = message;
        }
        JobCancellationException jobCancellationException = new JobCancellationException(str, cause, (Job)this);
        return jobCancellationException;
    }

    public <R> R fold(R initial, Function2<? super R, ? super CoroutineContext.Element, ? extends R> operation) {
        return Job.DefaultImpls.fold(this, initial, operation);
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return Job.DefaultImpls.get(this, key);
    }

    @Override // kotlinx.coroutines.Job
    public final CancellationException getCancellationException() {
        CancellationException cancellationException$default;
        int str2;
        int string;
        Object str;
        final Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        str2 = "Job is still new or active: ";
        if (state$kotlinx_coroutines_core instanceof JobSupport.Finishing) {
            cancellationException$default = (JobSupport.Finishing)state$kotlinx_coroutines_core.getRootCause();
            if (cancellationException$default == null) {
            } else {
                StringBuilder stringBuilder3 = new StringBuilder();
                if (toCancellationException(cancellationException$default, stringBuilder3.append(DebugStringsKt.getClassSimpleName(this)).append(" is cancelling").toString()) == null) {
                } else {
                    return cancellationException$default;
                }
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            IllegalStateException illegalStateException2 = new IllegalStateException(stringBuilder4.append(str2).append(this).toString().toString());
            throw illegalStateException2;
        }
        if (state$kotlinx_coroutines_core instanceof Incomplete) {
        } else {
            str2 = 0;
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                cancellationException$default = JobSupport.toCancellationException$default(this, obj.cause, str2, 1, str2);
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                cancellationException$default = new JobCancellationException(stringBuilder2.append(DebugStringsKt.getClassSimpleName(this)).append(" has completed normally").toString(), str2, (Job)this);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append(str2).append(this).toString().toString());
        throw illegalStateException;
    }

    @Override // kotlinx.coroutines.Job
    public CancellationException getChildJobCancellationCause() {
        Throwable rootCause;
        int jobCancellationException;
        boolean string;
        kotlinx.coroutines.Job job;
        final Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof JobSupport.Finishing) {
            rootCause = (JobSupport.Finishing)state$kotlinx_coroutines_core.getRootCause();
            if (rootCause instanceof CancellationException != null) {
                jobCancellationException = rootCause;
            }
            if (jobCancellationException == null) {
                StringBuilder stringBuilder2 = new StringBuilder();
                jobCancellationException = new JobCancellationException(stringBuilder2.append("Parent job is ").append(stateString(state$kotlinx_coroutines_core)).toString(), rootCause, (Job)this);
            }
            return jobCancellationException;
        } else {
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                rootCause = obj.cause;
            } else {
                if (state$kotlinx_coroutines_core instanceof Incomplete) {
                } else {
                    rootCause = jobCancellationException;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException rootCause2 = new IllegalStateException(stringBuilder.append("Cannot be cancelling child in this state: ").append(state$kotlinx_coroutines_core).toString().toString());
        throw rootCause2;
    }

    public final Sequence<kotlinx.coroutines.Job> getChildren() {
        JobSupport.children.1 anon = new JobSupport.children.1(this, 0);
        return SequencesKt.sequence((Function2)anon);
    }

    @Override // kotlinx.coroutines.Job
    public final Object getCompletedInternal$kotlinx_coroutines_core() {
        final Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Incomplete) {
        } else {
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            } else {
                return JobSupportKt.unboxState(state$kotlinx_coroutines_core);
            }
            throw obj.cause;
        }
        int i = 0;
        IllegalStateException $i$a$CheckJobSupport$getCompletedInternal$1 = new IllegalStateException("This job has not completed yet".toString());
        throw $i$a$CheckJobSupport$getCompletedInternal$1;
    }

    @Override // kotlinx.coroutines.Job
    protected final Throwable getCompletionCause() {
        Throwable rootCause;
        final Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        String str = "Job is still new or active: ";
        if (state$kotlinx_coroutines_core instanceof JobSupport.Finishing) {
            if ((JobSupport.Finishing)state$kotlinx_coroutines_core.getRootCause() == null) {
            } else {
                return rootCause;
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append(str).append(this).toString().toString());
            throw illegalStateException;
        }
        if (state$kotlinx_coroutines_core instanceof Incomplete) {
        } else {
            if (state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
                rootCause = obj2.cause;
            } else {
                rootCause = 0;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        IllegalStateException illegalStateException2 = new IllegalStateException(stringBuilder2.append(str).append(this).toString().toString());
        throw illegalStateException2;
    }

    @Override // kotlinx.coroutines.Job
    protected final boolean getCompletionCauseHandled() {
        boolean handled;
        int i;
        final Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        final int i2 = 0;
        if (state$kotlinx_coroutines_core instanceof CompletedExceptionally && (CompletedExceptionally)state$kotlinx_coroutines_core.getHandled()) {
            i = (CompletedExceptionally)state$kotlinx_coroutines_core.getHandled() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // kotlinx.coroutines.Job
    public final Throwable getCompletionExceptionOrNull() {
        final Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Incomplete) {
        } else {
            return getExceptionOrNull(state$kotlinx_coroutines_core);
        }
        int i = 0;
        IllegalStateException $i$a$CheckJobSupport$getCompletionExceptionOrNull$1 = new IllegalStateException("This job has not completed yet".toString());
        throw $i$a$CheckJobSupport$getCompletionExceptionOrNull$1;
    }

    @Override // kotlinx.coroutines.Job
    public boolean getHandlesException$kotlinx_coroutines_core() {
        return 1;
    }

    public final CoroutineContext.Key<?> getKey() {
        return (CoroutineContext.Key)Job.Key;
    }

    protected final SelectClause1<?> getOnAwaitInternal() {
        kotlinx.coroutines.JobSupport.onAwaitInternal.1 iNSTANCE = JobSupport.onAwaitInternal.1.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        int i = 3;
        kotlinx.coroutines.JobSupport.onAwaitInternal.2 iNSTANCE2 = JobSupport.onAwaitInternal.2.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'param')] kotlin.Any?, @[ParameterName(name = 'clauseResult')] kotlin.Any?, kotlin.Any?>{ kotlinx.coroutines.selects.SelectKt.ProcessResultFunction }");
        SelectClause1Impl selectClause1Impl = new SelectClause1Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE, i), (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE2, i), 0, 8, 0);
        return (SelectClause1)selectClause1Impl;
    }

    @Override // kotlinx.coroutines.Job
    public boolean getOnCancelComplete$kotlinx_coroutines_core() {
        return 0;
    }

    @Override // kotlinx.coroutines.Job
    public final SelectClause0 getOnJoin() {
        kotlinx.coroutines.JobSupport.onJoin.1 iNSTANCE = JobSupport.onJoin.1.INSTANCE;
        Intrinsics.checkNotNull(iNSTANCE, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = 'clauseObject')] kotlin.Any, @[ParameterName(name = 'select')] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = 'param')] kotlin.Any?, kotlin.Unit>{ kotlinx.coroutines.selects.SelectKt.RegistrationFunction }");
        SelectClause0Impl selectClause0Impl = new SelectClause0Impl(this, (Function3)TypeIntrinsics.beforeCheckcastToFunctionOfArity(iNSTANCE, 3), 0, 4, 0);
        return (SelectClause0)selectClause0Impl;
    }

    @Override // kotlinx.coroutines.Job
    public kotlinx.coroutines.Job getParent() {
        kotlinx.coroutines.Job parent;
        kotlinx.coroutines.ChildHandle parentHandle$kotlinx_coroutines_core = getParentHandle$kotlinx_coroutines_core();
        if (parentHandle$kotlinx_coroutines_core != null) {
            parent = parentHandle$kotlinx_coroutines_core.getParent();
        } else {
            parent = 0;
        }
        return parent;
    }

    @Override // kotlinx.coroutines.Job
    public final kotlinx.coroutines.ChildHandle getParentHandle$kotlinx_coroutines_core() {
        return (ChildHandle)JobSupport._parentHandle$FU.get(this);
    }

    @Override // kotlinx.coroutines.Job
    public final Object getState$kotlinx_coroutines_core() {
        Object obj;
        int i;
        Object obj2;
        final Object obj3 = this;
        final int i2 = 0;
        obj = JobSupport._state$FU.get(this);
        i = 0;
        while (!obj instanceof OpDescriptor) {
            (OpDescriptor)obj.perform(this);
            obj = _state$FU.get(this);
            i = 0;
        }
        return obj;
    }

    @Override // kotlinx.coroutines.Job
    protected boolean handleJobException(Throwable exception) {
        return 0;
    }

    @Override // kotlinx.coroutines.Job
    public void handleOnCompletionException$kotlinx_coroutines_core(Throwable exception) {
        throw exception;
    }

    @Override // kotlinx.coroutines.Job
    protected final void initParentJob(kotlinx.coroutines.Job parent) {
        boolean aSSERTIONS_ENABLED;
        int i;
        boolean iNSTANCE;
        if (DebugKt.getASSERTIONS_ENABLED()) {
            aSSERTIONS_ENABLED = 0;
            i = getParentHandle$kotlinx_coroutines_core() == null ? 1 : 0;
            if (i == 0) {
            } else {
            }
            AssertionError assertionError = new AssertionError();
            throw assertionError;
        }
        if (parent == null) {
            setParentHandle$kotlinx_coroutines_core((ChildHandle)NonDisposableHandle.INSTANCE);
        }
        parent.start();
        kotlinx.coroutines.ChildHandle attachChild = parent.attachChild((ChildJob)this);
        setParentHandle$kotlinx_coroutines_core(attachChild);
        if (isCompleted()) {
            attachChild.dispose();
            setParentHandle$kotlinx_coroutines_core((ChildHandle)NonDisposableHandle.INSTANCE);
        }
    }

    public final kotlinx.coroutines.DisposableHandle invokeOnCompletion(Function1<? super Throwable, Unit> handler) {
        return invokeOnCompletion(false, true, handler);
    }

    public final kotlinx.coroutines.DisposableHandle invokeOnCompletion(boolean onCancelling, boolean invokeImmediately, Function1<? super Throwable, Unit> handler) {
        Throwable lastAtomic;
        int i5;
        boolean z;
        int iNSTANCE;
        boolean $i$a$SynchronizedJobSupport$invokeOnCompletion$1$12;
        Object state$kotlinx_coroutines_core;
        int i;
        kotlinx.coroutines.NodeList cause;
        int rootCause;
        kotlinx.coroutines.NonDisposableHandle handle;
        int i4;
        int i2;
        Object rootCause2;
        int i3;
        int $i$a$SynchronizedJobSupport$invokeOnCompletion$1$1;
        final Object obj4 = this;
        final boolean z4 = onCancelling;
        final kotlinx.coroutines.JobNode node = obj4.makeNode(handler, z4);
        final int i6 = 0;
        state$kotlinx_coroutines_core = this.getState$kotlinx_coroutines_core();
        i = 0;
        while (state$kotlinx_coroutines_core instanceof Empty) {
            obj4.promoteEmptyToNodeList((Empty)state$kotlinx_coroutines_core);
            state$kotlinx_coroutines_core = obj5.getState$kotlinx_coroutines_core();
            i = 0;
            cause = (Incomplete)state$kotlinx_coroutines_core.getList();
            rootCause = 0;
            iNSTANCE = 0;
            handle = NonDisposableHandle.INSTANCE;
            i4 = 0;
            i2 = 0;
            $i$a$SynchronizedJobSupport$invokeOnCompletion$1$12 = 0;
            rootCause = rootCause2;
            $i$a$SynchronizedJobSupport$invokeOnCompletion$1$1 = $i$a$SynchronizedJobSupport$invokeOnCompletion$1$12;
            handle = $i$a$SynchronizedJobSupport$invokeOnCompletion$1$12;
            iNSTANCE = Unit.INSTANCE;
            i3 = 0;
            $i$a$SynchronizedJobSupport$invokeOnCompletion$1$1 = $i$a$SynchronizedJobSupport$invokeOnCompletion$1$12;
            Intrinsics.checkNotNull(state$kotlinx_coroutines_core, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
            obj4.promoteSingleToNodeList((JobNode)state$kotlinx_coroutines_core);
        }
        return (DisposableHandle)node;
    }

    @Override // kotlinx.coroutines.Job
    public boolean isActive() {
        boolean active;
        int i;
        final Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (state$kotlinx_coroutines_core instanceof Incomplete && (Incomplete)state$kotlinx_coroutines_core.isActive()) {
            i = (Incomplete)state$kotlinx_coroutines_core.isActive() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCancelled() {
        boolean cancelling;
        int i;
        final Object state$kotlinx_coroutines_core = getState$kotlinx_coroutines_core();
        if (!state$kotlinx_coroutines_core instanceof CompletedExceptionally) {
            if (state$kotlinx_coroutines_core instanceof JobSupport.Finishing && (JobSupport.Finishing)state$kotlinx_coroutines_core.isCancelling()) {
                if ((JobSupport.Finishing)state$kotlinx_coroutines_core.isCancelling()) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompleted() {
        return z ^= 1;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean isCompletedExceptionally() {
        return state$kotlinx_coroutines_core instanceof CompletedExceptionally;
    }

    @Override // kotlinx.coroutines.Job
    protected boolean isScopedCoroutine() {
        return 0;
    }

    public final Object join(Continuation<? super Unit> $completion) {
        if (!joinInternal()) {
            JobKt.ensureActive($completion.getContext());
            return Unit.INSTANCE;
        }
        Object joinSuspend = joinSuspend($completion);
        if (joinSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return joinSuspend;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.Job
    public final boolean makeCompleting$kotlinx_coroutines_core(Object proposedUpdate) {
        Object state$kotlinx_coroutines_core;
        int i;
        Object tryMakeCompleting;
        kotlinx.coroutines.internal.Symbol symbol;
        int i2;
        final int i3 = 0;
        i = 0;
        tryMakeCompleting = tryMakeCompleting(this.getState$kotlinx_coroutines_core(), proposedUpdate);
        while (tryMakeCompleting == JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            i2 = 1;
            i = 0;
            tryMakeCompleting = tryMakeCompleting(obj.getState$kotlinx_coroutines_core(), proposedUpdate);
        }
        return 0;
    }

    @Override // kotlinx.coroutines.Job
    public final Object makeCompletingOnce$kotlinx_coroutines_core(Object proposedUpdate) {
        Object state$kotlinx_coroutines_core;
        int i;
        Object tryMakeCompleting;
        kotlinx.coroutines.internal.Symbol symbol;
        final int i2 = 0;
        i = 0;
        tryMakeCompleting = tryMakeCompleting(this.getState$kotlinx_coroutines_core(), proposedUpdate);
        while (tryMakeCompleting != JobSupportKt.access$getCOMPLETING_ALREADY$p()) {
            i = 0;
            tryMakeCompleting = tryMakeCompleting(obj.getState$kotlinx_coroutines_core(), proposedUpdate);
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Job ").append(this).append(" is already complete or completing, but is being completed with ").append(proposedUpdate).toString(), getExceptionOrNull(proposedUpdate));
        throw illegalStateException;
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return Job.DefaultImpls.minusKey(this, key);
    }

    @Override // kotlinx.coroutines.Job
    public String nameString$kotlinx_coroutines_core() {
        return DebugStringsKt.getClassSimpleName(this);
    }

    @Override // kotlinx.coroutines.Job
    protected void onCancelling(Throwable cause) {
    }

    @Override // kotlinx.coroutines.Job
    protected void onCompletionInternal(Object state) {
    }

    @Override // kotlinx.coroutines.Job
    protected void onStart() {
    }

    @Override // kotlinx.coroutines.Job
    public final void parentCancelled(kotlinx.coroutines.ParentJob parentJob) {
        cancelImpl$kotlinx_coroutines_core(parentJob);
    }

    @Override // kotlinx.coroutines.Job
    public CoroutineContext plus(CoroutineContext context) {
        return Job.DefaultImpls.plus(this, context);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Operator '+' on two Job objects is meaningless. Job is a coroutine context element and `+` is a set-sum operator for coroutine contexts. The job to the right of `+` just replaces the job the left of `+`.")
    public kotlinx.coroutines.Job plus(kotlinx.coroutines.Job other) {
        return Job.DefaultImpls.plus(this, other);
    }

    @Override // kotlinx.coroutines.Job
    public final void removeNode$kotlinx_coroutines_core(kotlinx.coroutines.JobNode node) {
        Object state$kotlinx_coroutines_core;
        int i;
        boolean z;
        kotlinx.coroutines.Empty empty;
        final int i2 = 0;
        state$kotlinx_coroutines_core = this.getState$kotlinx_coroutines_core();
        i = 0;
        while (state$kotlinx_coroutines_core instanceof JobNode) {
            state$kotlinx_coroutines_core = obj.getState$kotlinx_coroutines_core();
            i = 0;
        }
        if (state$kotlinx_coroutines_core instanceof Incomplete && (Incomplete)state$kotlinx_coroutines_core.getList() != null) {
            if ((Incomplete)state$kotlinx_coroutines_core.getList() != null) {
                node.remove();
            }
        }
    }

    @Override // kotlinx.coroutines.Job
    public final void setParentHandle$kotlinx_coroutines_core(kotlinx.coroutines.ChildHandle value) {
        JobSupport._parentHandle$FU.set(this, value);
    }

    @Override // kotlinx.coroutines.Job
    public final boolean start() {
        Object state$kotlinx_coroutines_core;
        int i;
        int internal;
        final int i2 = 0;
        while (/* condition */) {
            i = 0;
        }
        return 0;
    }

    @Override // kotlinx.coroutines.Job
    protected final CancellationException toCancellationException(Throwable $this$toCancellationException, String message) {
        int this_$iv;
        int i;
        kotlinx.coroutines.JobCancellationException jobCancellationException;
        String str;
        kotlinx.coroutines.JobSupport jobSupport;
        if ($this$toCancellationException instanceof CancellationException != null) {
            this_$iv = $this$toCancellationException;
        } else {
            this_$iv = 0;
        }
        if (this_$iv == 0) {
            kotlinx.coroutines.JobSupport jobSupport2 = this;
            i = 0;
            if (message == null) {
                str = JobSupport.access$cancellationExceptionMessage(jobSupport2);
            } else {
                str = message;
            }
            jobCancellationException = new JobCancellationException(str, $this$toCancellationException, (Job)jobSupport2);
            this_$iv = jobCancellationException;
        }
        return this_$iv;
    }

    @Override // kotlinx.coroutines.Job
    public final String toDebugString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(nameString$kotlinx_coroutines_core()).append('{').append(stateString(getState$kotlinx_coroutines_core())).append('}').toString();
    }

    @Override // kotlinx.coroutines.Job
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(toDebugString()).append('@').append(DebugStringsKt.getHexAddress(this)).toString();
    }
}
