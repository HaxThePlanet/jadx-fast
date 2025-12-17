package kotlinx.coroutines.flow;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000x\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0013\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001a¸\u0001\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0003\"\u0004\u0008\u0000\u0010\u0007\"\u0004\u0008\u0001\u0010\u0008\"\u0004\u0008\u0002\u0010\t\"\u0004\u0008\u0003\u0010\n\"\u0004\u0008\u0004\u0010\u000b\"\u0004\u0008\u0005\u0010\u0006*\u0008\u0012\u0004\u0012\u0002H\u00070\u00032\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u00032\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\t0\u00032\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u00032\u000c\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u00032:\u0010\u0010\u001a6\u0008\u0001\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00060\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0011H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a\u009e\u0001\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0003\"\u0004\u0008\u0000\u0010\u0007\"\u0004\u0008\u0001\u0010\u0008\"\u0004\u0008\u0002\u0010\t\"\u0004\u0008\u0003\u0010\n\"\u0004\u0008\u0004\u0010\u0006*\u0008\u0012\u0004\u0012\u0002H\u00070\u00032\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u00032\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\t0\u00032\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\n0\u000324\u0010\u0010\u001a0\u0008\u0001\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00060\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0015H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a\u0084\u0001\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0003\"\u0004\u0008\u0000\u0010\u0007\"\u0004\u0008\u0001\u0010\u0008\"\u0004\u0008\u0002\u0010\t\"\u0004\u0008\u0003\u0010\u0006*\u0008\u0012\u0004\u0012\u0002H\u00070\u00032\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u00032\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u0002H\t0\u00032.\u0010\u0010\u001a*\u0008\u0001\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u0008\u0012\u0004\u0012\u0002H\t\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00060\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0017H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aj\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0003\"\u0004\u0008\u0000\u0010\u0007\"\u0004\u0008\u0001\u0010\u0008\"\u0004\u0008\u0002\u0010\u0006*\u0008\u0012\u0004\u0012\u0002H\u00070\u00032\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00080\u00032(\u0010\u0010\u001a$\u0008\u0001\u0012\u0004\u0012\u0002H\u0007\u0012\u0004\u0012\u0002H\u0008\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00060\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001aI\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0003\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0006*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032#\u0010\u001c\u001a\u001f\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00060\u00030\u001d¢\u0006\u0002\u0008\u001eH\u0007\u001a>\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0003\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0006*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00060\u00030\u001dH\u0007\u001a+\u0010!\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010\"\u001a\u0002H\u0004H\u0007¢\u0006\u0002\u0010#\u001a,\u0010!\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001a&\u0010$\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010%\u001a\u00020&H\u0007\u001a&\u0010'\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010%\u001a\u00020&H\u0007\u001aV\u0010(\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0003\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0006*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032(\u0010 \u001a$\u0008\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00060\u00030\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130)H\u0007ø\u0001\u0000¢\u0006\u0002\u0010*\u001a$\u0010+\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00040\u00030\u0003H\u0007\u001aS\u0010,\u001a\u00020-\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u000321\u0010.\u001a-\u0008\u0001\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008/\u0012\u0008\u00080\u0012\u0004\u0008\u0008(\"\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020-0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130)H\u0007ø\u0001\u0000¢\u0006\u0002\u00101\u001a$\u00102\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00040\u00030\u0003H\u0007\u001a&\u00103\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u00104\u001a\u000205H\u0007\u001a,\u00106\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u000c\u00107\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001a,\u00108\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u000c\u00107\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001a+\u00109\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u00107\u001a\u0002H\u0004H\u0007¢\u0006\u0002\u0010#\u001aA\u00109\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u00107\u001a\u0002H\u00042\u0014\u0008\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020<0\u001dH\u0007¢\u0006\u0002\u0010=\u001a\u001e\u0010>\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001a&\u0010>\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010?\u001a\u00020@H\u0007\u001a&\u0010A\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u00104\u001a\u000205H\u0007\u001a\u001e\u0010B\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001a&\u0010B\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010?\u001a\u00020@H\u0007\u001a~\u0010C\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0003\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0006*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010D\u001a\u0002H\u00062H\u0008\u0001\u0010E\u001aB\u0008\u0001\u0012\u0013\u0012\u0011H\u0006¢\u0006\u000c\u0008/\u0012\u0008\u00080\u0012\u0004\u0008\u0008(F\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008/\u0012\u0008\u00080\u0012\u0004\u0008\u0008(\"\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00060\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010G\u001an\u0010H\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032F\u0010E\u001aB\u0008\u0001\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008/\u0012\u0008\u00080\u0012\u0004\u0008\u0008(F\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008/\u0012\u0008\u00080\u0012\u0004\u0008\u0008(\"\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00040\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010I\u001a&\u0010J\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010K\u001a\u00020@H\u0007\u001a+\u0010L\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010\"\u001a\u0002H\u0004H\u0007¢\u0006\u0002\u0010#\u001a,\u0010L\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001a\u0018\u0010M\u001a\u00020-\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001aD\u0010M\u001a\u00020-\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\"\u0010N\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020-0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130)H\u0007ø\u0001\u0000¢\u0006\u0002\u00101\u001ah\u0010M\u001a\u00020-\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\"\u0010N\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020-0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130)2\"\u0010O\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u00020;\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020-0\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130)H\u0007ø\u0001\u0000¢\u0006\u0002\u0010P\u001a&\u0010Q\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\u0008\u0000\u0010\u0004*\u0008\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u00104\u001a\u000205H\u0007\u001ae\u0010R\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\u0003\"\u0004\u0008\u0000\u0010\u0004\"\u0004\u0008\u0001\u0010\u0006*\u0008\u0012\u0004\u0012\u0002H\u00040\u000327\u0010\u0010\u001a3\u0008\u0001\u0012\u0013\u0012\u0011H\u0004¢\u0006\u000c\u0008/\u0012\u0008\u00080\u0012\u0004\u0008\u0008(\"\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u0002H\u00060\u00030\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00130)H\u0007ø\u0001\u0000¢\u0006\u0002\u0010*\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006S", d2 = {"noImpl", "", "cache", "Lkotlinx/coroutines/flow/Flow;", "T", "combineLatest", "R", "T1", "T2", "T3", "T4", "T5", "other", "other2", "other3", "other4", "transform", "Lkotlin/Function6;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function5;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function4;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function3;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "compose", "transformer", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "concatMap", "mapper", "concatWith", "value", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "delayEach", "timeMillis", "", "delayFlow", "flatMap", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "flatten", "forEach", "", "action", "Lkotlin/ParameterName;", "name", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)V", "merge", "observeOn", "context", "Lkotlin/coroutines/CoroutineContext;", "onErrorResume", "fallback", "onErrorResumeNext", "onErrorReturn", "predicate", "", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "publish", "bufferSize", "", "publishOn", "replay", "scanFold", "initial", "operation", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "scanReduce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "skip", "count", "startWith", "subscribe", "onEach", "onError", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "subscribeOn", "switchMap", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
final class FlowKt__MigrationKt {
    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStared.Lazily' argument'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> cache(kotlinx.coroutines.flow.Flow<? extends T> $this$cache) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(...))
    public static final <T1, T2, R> kotlinx.coroutines.flow.Flow<R> combineLatest(kotlinx.coroutines.flow.Flow<? extends T1> $this$combineLatest, kotlinx.coroutines.flow.Flow<? extends T2> other, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt.combine($this$combineLatest, other, transform);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(...))
    public static final <T1, T2, T3, R> kotlinx.coroutines.flow.Flow<R> combineLatest(kotlinx.coroutines.flow.Flow<? extends T1> $this$combineLatest, kotlinx.coroutines.flow.Flow<? extends T2> other, kotlinx.coroutines.flow.Flow<? extends T3> other2, Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt.combine($this$combineLatest, other, other2, transform);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(...))
    public static final <T1, T2, T3, T4, R> kotlinx.coroutines.flow.Flow<R> combineLatest(kotlinx.coroutines.flow.Flow<? extends T1> $this$combineLatest, kotlinx.coroutines.flow.Flow<? extends T2> other, kotlinx.coroutines.flow.Flow<? extends T3> other2, kotlinx.coroutines.flow.Flow<? extends T4> other3, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt.combine($this$combineLatest, other, other2, other3, transform);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(...))
    public static final <T1, T2, T3, T4, T5, R> kotlinx.coroutines.flow.Flow<R> combineLatest(kotlinx.coroutines.flow.Flow<? extends T1> $this$combineLatest, kotlinx.coroutines.flow.Flow<? extends T2> other, kotlinx.coroutines.flow.Flow<? extends T3> other2, kotlinx.coroutines.flow.Flow<? extends T4> other3, kotlinx.coroutines.flow.Flow<? extends T5> other4, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> transform) {
        return FlowKt.combine($this$combineLatest, other, other2, other3, other4, transform);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(...))
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> compose(kotlinx.coroutines.flow.Flow<? extends T> $this$compose, Function1<? super kotlinx.coroutines.flow.Flow<? extends T>, ? extends kotlinx.coroutines.flow.Flow<? extends R>> transformer) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(...))
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> concatMap(kotlinx.coroutines.flow.Flow<? extends T> $this$concatMap, Function1<? super T, ? extends kotlinx.coroutines.flow.Flow<? extends R>> mapper) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> concatWith(kotlinx.coroutines.flow.Flow<? extends T> $this$concatWith, T value) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> concatWith(kotlinx.coroutines.flow.Flow<? extends T> $this$concatWith, kotlinx.coroutines.flow.Flow<? extends T> other) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> delayEach(kotlinx.coroutines.flow.Flow<? extends T> $this$delayEach, long timeMillis) {
        FlowKt__MigrationKt.delayEach.1 anon = new FlowKt__MigrationKt.delayEach.1(timeMillis, obj4, 0);
        return FlowKt.onEach($this$delayEach, (Function2)anon);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> delayFlow(kotlinx.coroutines.flow.Flow<? extends T> $this$delayFlow, long timeMillis) {
        FlowKt__MigrationKt.delayFlow.1 anon = new FlowKt__MigrationKt.delayFlow.1(timeMillis, obj4, 0);
        return FlowKt.onStart($this$delayFlow, (Function2)anon);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue is 'flatMapConcat'", replaceWith = @ReplaceWith(...))
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> flatMap(kotlinx.coroutines.flow.Flow<? extends T> $this$flatMap, Function2<? super T, ? super Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends Object> mapper) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> flatten(kotlinx.coroutines.flow.Flow<? extends kotlinx.coroutines.flow.Flow<? extends T>> $this$flatten) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(...))
    public static final <T> void forEach(kotlinx.coroutines.flow.Flow<? extends T> $this$forEach, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> merge(kotlinx.coroutines.flow.Flow<? extends kotlinx.coroutines.flow.Flow<? extends T>> $this$merge) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public static final Void noImpl() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Not implemented, should not be called");
        throw unsupportedOperationException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> kotlinx.coroutines.flow.Flow<T> observeOn(kotlinx.coroutines.flow.Flow<? extends T> $this$observeOn, CoroutineContext context) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> onErrorResume(kotlinx.coroutines.flow.Flow<? extends T> $this$onErrorResume, kotlinx.coroutines.flow.Flow<? extends T> fallback) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> onErrorResumeNext(kotlinx.coroutines.flow.Flow<? extends T> $this$onErrorResumeNext, kotlinx.coroutines.flow.Flow<? extends T> fallback) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> onErrorReturn(kotlinx.coroutines.flow.Flow<? extends T> $this$onErrorReturn, T fallback) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> onErrorReturn(kotlinx.coroutines.flow.Flow<? extends T> $this$onErrorReturn, T fallback, Function1<? super Throwable, Boolean> predicate) {
        FlowKt__MigrationKt.onErrorReturn.2 anon = new FlowKt__MigrationKt.onErrorReturn.2(predicate, fallback, 0);
        return FlowKt.catch($this$onErrorReturn, (Function3)anon);
    }

    public static kotlinx.coroutines.flow.Flow onErrorReturn$default(kotlinx.coroutines.flow.Flow flow, Object object2, Function1 function13, int i4, Object object5) {
        kotlinx.coroutines.flow.FlowKt__MigrationKt.onErrorReturn.1 obj2;
        if (i4 &= 2 != 0) {
            obj2 = FlowKt__MigrationKt.onErrorReturn.1.INSTANCE;
        }
        return FlowKt.onErrorReturn(flow, object2, obj2);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> publish(kotlinx.coroutines.flow.Flow<? extends T> $this$publish) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStared.Lazily' argument, \npublish().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> publish(kotlinx.coroutines.flow.Flow<? extends T> $this$publish, int bufferSize) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Collect flow in the desired context instead")
    public static final <T> kotlinx.coroutines.flow.Flow<T> publishOn(kotlinx.coroutines.flow.Flow<? extends T> $this$publishOn, CoroutineContext context) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> replay(kotlinx.coroutines.flow.Flow<? extends T> $this$replay) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStared.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStared.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> replay(kotlinx.coroutines.flow.Flow<? extends T> $this$replay, int bufferSize) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(...))
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> scanFold(kotlinx.coroutines.flow.Flow<? extends T> $this$scanFold, R initial, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> scanReduce(kotlinx.coroutines.flow.Flow<? extends T> $this$scanReduce, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> operation) {
        return FlowKt.runningReduce($this$scanReduce, operation);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> skip(kotlinx.coroutines.flow.Flow<? extends T> $this$skip, int count) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> startWith(kotlinx.coroutines.flow.Flow<? extends T> $this$startWith, T value) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(...))
    public static final <T> kotlinx.coroutines.flow.Flow<T> startWith(kotlinx.coroutines.flow.Flow<? extends T> $this$startWith, kotlinx.coroutines.flow.Flow<? extends T> other) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(kotlinx.coroutines.flow.Flow<? extends T> $this$subscribe) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(kotlinx.coroutines.flow.Flow<? extends T> $this$subscribe, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> onEach) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(kotlinx.coroutines.flow.Flow<? extends T> $this$subscribe, Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> onEach, Function2<? super Throwable, ? super Continuation<? super Unit>, ? extends Object> onError) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'flowOn' instead")
    public static final <T> kotlinx.coroutines.flow.Flow<T> subscribeOn(kotlinx.coroutines.flow.Flow<? extends T> $this$subscribeOn, CoroutineContext context) {
        FlowKt.noImpl();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(...))
    public static final <T, R> kotlinx.coroutines.flow.Flow<R> switchMap(kotlinx.coroutines.flow.Flow<? extends T> $this$switchMap, Function2<? super T, ? super Continuation<? super kotlinx.coroutines.flow.Flow<? extends R>>, ? extends Object> transform) {
        final int i = 0;
        FlowKt__MigrationKt.switchMap$$inlined.flatMapLatest.1 anon = new FlowKt__MigrationKt.switchMap$$inlined.flatMapLatest.1(transform, 0);
        return FlowKt.transformLatest($this$switchMap, (Function3)anon);
    }
}
