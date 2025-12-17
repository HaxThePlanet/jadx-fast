package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000X\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010\u000b\n\u0002\u0008*\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008(\u0008\u0000\u0018\u0000 }*\u0004\u0008\u0000\u0010\u0001*\u0004\u0008\u0001\u0010\u00022\u00020\u0003:\u0002}~B'\u0008\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0008¢\u0006\u0002\u0010\tB/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0008\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000cJ\u0091\u0001\u0010\u0011\u001a\u00020\u00122\u0081\u0001\u0010\u0013\u001a}\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0017\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0018\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0006\u0012\u0004\u0012\u00020\u00120\u0014H\u0000¢\u0006\u0002\u0008\u001aJ\u009c\u0001\u0010\u0011\u001a\u00020\u00122\u0081\u0001\u0010\u0013\u001a}\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0017\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0018\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0015\u0012\u0008\u0008\u0016\u0012\u0004\u0008\u0008(\u0006\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH\u0002J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH\u0002JO\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00082\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0008\u0010$\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010%J\u0008\u0010&\u001a\u00020\u0005H\u0002J\u0015\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010*J\u0017\u0010+\u001a\u0004\u0018\u00018\u00012\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J+\u0010-\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001c2\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010/J#\u00100\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00101J+\u00100\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00102J\u001e\u00103\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00104\u001a\u00020\u0005H\u0002J#\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u00107J\u001c\u00108\u001a\u00020(2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J\r\u0010:\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0008;J\u0015\u0010<\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0000¢\u0006\u0002\u0008=J%\u0010>\u001a\u0004\u0018\u00018\u00012\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010?J\u0015\u0010@\u001a\u00020(2\u0006\u0010 \u001a\u00020\u0005H\u0000¢\u0006\u0002\u0008AJ\u0010\u0010B\u001a\u00020(2\u0006\u0010 \u001a\u00020\u0005H\u0002J1\u0010C\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010 \u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010DJ\u0015\u0010E\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010FJ[\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00028\u00002\u0006\u0010J\u001a\u00028\u00012\u0006\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00028\u00002\u0006\u0010M\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0008\u0010$\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010NJI\u0010O\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010PJ=\u0010Q\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010TJ8\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010V\u001a\u00020W2\u0006\u0010$\u001a\u00020\u000bH\u0002J?\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010TJ7\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010YJ2\u0010Z\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00104\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002J9\u0010[\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010 \u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\\JQ\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010^JK\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S¢\u0006\u0002\u0010`JJ\u0010a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010V\u001a\u00020W2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SJT\u0010b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010V\u001a\u00020W2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002JM\u0010c\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S¢\u0006\u0002\u0010`JE\u0010c\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S¢\u0006\u0002\u0010dJ:\u0010e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002J.\u0010f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000bH\u0002JX\u0010h\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010j\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000bH\u0002J8\u0010k\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010$\u001a\u00020\u000bH\u0002J=\u0010l\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010.\u001a\u00028\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010mJ!\u0010n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010g\u001a\u00020\u0005H\u0000¢\u0006\u0002\u0008oJ\u0015\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0000¢\u0006\u0002\u0008pJ9\u0010q\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001c2\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010rJ9\u0010s\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010tJ1\u0010s\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010uJ&\u0010v\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J&\u0010w\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002JP\u0010x\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010j\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J8\u0010y\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J)\u0010z\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010{J\u0015\u0010|\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010FR0\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00082\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0008@BX\u0080\u000e¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u007f", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "K", "V", "", "dataMap", "", "nodeMap", "buffer", "", "(II[Ljava/lang/Object;)V", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "(II[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "<set-?>", "getBuffer$runtime_release", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "accept", "", "visitor", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "node", "shift", "hash", "accept$runtime_release", "asInsertResult", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "asUpdateResult", "bufferMoveEntryToNode", "keyIndex", "positionMask", "newKeyHash", "newKey", "newValue", "owner", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)[Ljava/lang/Object;", "calculateSize", "collisionContainsKey", "", "key", "(Ljava/lang/Object;)Z", "collisionGet", "(Ljava/lang/Object;)Ljava/lang/Object;", "collisionPut", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "collisionRemove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "collisionRemoveEntryAtIndex", "i", "containsKey", "keyHash", "(ILjava/lang/Object;I)Z", "elementsIdentityEquals", "otherNode", "entryCount", "entryCount$runtime_release", "entryKeyIndex", "entryKeyIndex$runtime_release", "get", "(ILjava/lang/Object;I)Ljava/lang/Object;", "hasEntryAt", "hasEntryAt$runtime_release", "hasNodeAt", "insertEntryAt", "(ILjava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "keyAtIndex", "(I)Ljava/lang/Object;", "makeNode", "keyHash1", "key1", "value1", "keyHash2", "key2", "value2", "(ILjava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "moveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionPut", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionPutAll", "intersectionCounter", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutableCollisionRemove", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionRemoveEntryAtIndex", "mutableInsertEntryAt", "(ILjava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableMoveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutablePut", "(ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutablePutAll", "mutablePutAllFromOtherNodeCell", "mutableRemove", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableRemoveEntryAtIndex", "mutableRemoveNodeAtIndex", "nodeIndex", "mutableReplaceNode", "targetNode", "newNode", "mutableUpdateNodeAtIndex", "mutableUpdateValueAtIndex", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "nodeAtIndex", "nodeAtIndex$runtime_release", "nodeIndex$runtime_release", "put", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "remove", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "removeEntryAtIndex", "removeNodeAtIndex", "replaceNode", "updateNodeAtIndex", "updateValueAtIndex", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "valueAtKeyIndex", "Companion", "ModificationResult", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TrieNode<K, V>  {

    public static final int $stable = 8;
    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode.Companion Companion;
    private static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode EMPTY;
    private Object[] buffer;
    private int dataMap;
    private int nodeMap;
    private final MutabilityOwnership ownedBy;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0008\u0003\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "", "getEMPTY$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode getEMPTY$runtime_release() {
            return TrieNode.access$getEMPTY$cp();
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0000\u0008\u0000\u0018\u0000*\u0004\u0008\u0002\u0010\u0001*\u0004\u0008\u0003\u0010\u00022\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008JA\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002*\u0010\u0010\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0011H\u0086\u0008R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0012", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "K", "V", "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "sizeDelta", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "getNode", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "setNode", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "getSizeDelta", "()I", "replaceNode", "operation", "Lkotlin/Function1;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ModificationResult {

        public static final int $stable = 8;
        private androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> node;
        private final int sizeDelta;
        static {
            final int i = 8;
        }

        public ModificationResult(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> node, int sizeDelta) {
            super();
            this.node = node;
            this.sizeDelta = sizeDelta;
        }

        public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> getNode() {
            return this.node;
        }

        public final int getSizeDelta() {
            return this.sizeDelta;
        }

        public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode.ModificationResult<K, V> replaceNode(Function1<? super androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V>, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V>> operation) {
            final int i = 0;
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode.ModificationResult map = this;
            final int i2 = 0;
            map.setNode((TrieNode)operation.invoke((TrieNode.ModificationResult)map.getNode()));
            return (TrieNode.ModificationResult)this;
        }

        public final void setNode(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> <set-?>) {
            this.node = <set-?>;
        }
    }
    static {
        TrieNode.Companion companion = new TrieNode.Companion(0);
        TrieNode.Companion = companion;
        int i = 8;
        int i3 = 0;
        final int i4 = 0;
        TrieNode trieNode = new TrieNode(i4, i4, new Object[i4]);
        TrieNode.EMPTY = trieNode;
    }

    public TrieNode(int dataMap, int nodeMap, Object[] buffer) {
        super(dataMap, nodeMap, buffer, 0);
    }

    public TrieNode(int dataMap, int nodeMap, Object[] buffer, MutabilityOwnership ownedBy) {
        super();
        this.dataMap = dataMap;
        this.nodeMap = nodeMap;
        this.ownedBy = ownedBy;
        this.buffer = buffer;
    }

    private final void accept(Function5<? super androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> visitor, int hash, int shift) {
        Integer lowestOneBit;
        Integer numberOfTrailingZeros;
        Integer nodeAtIndex$runtime_release;
        Integer valueOf;
        int i;
        int obj8;
        final Object obj = this;
        Function5 function5 = visitor;
        function5.invoke(obj, Integer.valueOf(shift), Integer.valueOf(hash), Integer.valueOf(this.dataMap), Integer.valueOf(this.nodeMap));
        obj8 = obj.nodeMap;
        while (obj8 != null) {
            lowestOneBit = Integer.lowestOneBit(obj8);
            nodeAtIndex$runtime_release(nodeIndex$runtime_release(lowestOneBit)).accept(function5, i2 += hash, shift + 5);
            obj8 -= lowestOneBit;
        }
    }

    public static final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode access$getEMPTY$cp() {
        return TrieNode.EMPTY;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode.ModificationResult<K, V> asInsertResult() {
        TrieNode.ModificationResult modificationResult = new TrieNode.ModificationResult(this, 1);
        return modificationResult;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode.ModificationResult<K, V> asUpdateResult() {
        TrieNode.ModificationResult modificationResult = new TrieNode.ModificationResult(this, 0);
        return modificationResult;
    }

    private final Object[] bufferMoveEntryToNode(int keyIndex, int positionMask, int newKeyHash, K newKey, V newValue, int shift, MutabilityOwnership owner) {
        int i;
        final Object keyAtIndex = keyAtIndex(keyIndex);
        if (keyAtIndex != null) {
            i = keyAtIndex.hashCode();
        } else {
            i = 0;
        }
        return TrieNodeKt.access$replaceEntryWithNode(this.buffer, keyIndex, nodeIndex$runtime_release++, this.makeNode(i, keyAtIndex, valueAtKeyIndex(keyIndex), newKeyHash, newKey, newValue, shift + 5, owner));
    }

    private final int calculateSize() {
        int result;
        int i;
        int size;
        if (this.nodeMap == null) {
            return length /= 2;
        }
        int bitCount = Integer.bitCount(this.dataMap);
        result = bitCount;
        i = bitCount * 2;
        while (i < buffer2.length) {
            result += size;
            i++;
        }
        return result;
    }

    private final boolean collisionContainsKey(K key) {
        int i;
        boolean equal;
        final int i3 = 0;
        IntProgression step = RangesKt.step((IntProgression)RangesKt.until(i3, buffer.length), 2);
        i = step.getFirst();
        final int last = step.getLast();
        int step2 = step.getStep();
        if (step2 > 0) {
            if (i > last && step2 < 0 && last <= i) {
                if (step2 < 0) {
                    if (last <= i) {
                    }
                }
            }
        } else {
        }
        return i3;
    }

    private final V collisionGet(K key) {
        int i;
        boolean equal;
        IntProgression step = RangesKt.step((IntProgression)RangesKt.until(0, buffer.length), 2);
        i = step.getFirst();
        final int last = step.getLast();
        int step2 = step.getStep();
        if (step2 > 0) {
            if (i > last && step2 < 0 && last <= i) {
                if (step2 < 0) {
                    if (last <= i) {
                    }
                }
            }
        } else {
        }
        return 0;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode.ModificationResult<K, V> collisionPut(K key, V value) {
        int i;
        boolean equal;
        int i3 = 0;
        IntProgression step = RangesKt.step((IntProgression)RangesKt.until(i3, buffer.length), 2);
        i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 > 0) {
            if (i > last && step2 < 0 && last <= i) {
                if (step2 < 0) {
                    if (last <= i) {
                    }
                }
            }
        } else {
        }
        TrieNode trieNode = new TrieNode(i3, i3, TrieNodeKt.access$insertEntryAtIndex(this.buffer, i3, key, value));
        return trieNode.asInsertResult();
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> collisionRemove(K key) {
        int i;
        boolean equal;
        IntProgression step = RangesKt.step((IntProgression)RangesKt.until(0, buffer.length), 2);
        i = step.getFirst();
        final int last = step.getLast();
        int step2 = step.getStep();
        if (step2 > 0) {
            if (i > last && step2 < 0 && last <= i) {
                if (step2 < 0) {
                    if (last <= i) {
                    }
                }
            }
        } else {
        }
        return this;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> collisionRemove(K key, V value) {
        int i;
        boolean equal;
        IntProgression step = RangesKt.step((IntProgression)RangesKt.until(0, buffer.length), 2);
        i = step.getFirst();
        final int last = step.getLast();
        int step2 = step.getStep();
        if (step2 > 0) {
            if (i > last && step2 < 0 && last <= i) {
                if (step2 < 0) {
                    if (last <= i) {
                    }
                }
            }
        } else {
        }
        return this;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> collisionRemoveEntryAtIndex(int i) {
        if (buffer.length == 2) {
            return 0;
        }
        final int i4 = 0;
        TrieNode trieNode = new TrieNode(i4, i4, TrieNodeKt.access$removeEntryAtIndex(this.buffer, i));
        return trieNode;
    }

    private final boolean elementsIdentityEquals(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> otherNode) {
        int i;
        Object obj;
        Object obj2;
        final int i2 = 1;
        if (this == otherNode) {
            return i2;
        }
        final int i3 = 0;
        if (this.nodeMap != otherNode.nodeMap) {
            return i3;
        }
        if (this.dataMap != otherNode.dataMap) {
            return i3;
        }
        i = 0;
        while (i < buffer.length) {
            i++;
        }
        return i2;
    }

    private final boolean hasNodeAt(int positionMask) {
        int i;
        i = nodeMap &= positionMask != 0 ? 1 : 0;
        return i;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> insertEntryAt(int positionMask, K key, V value) {
        TrieNode trieNode = new TrieNode(dataMap |= positionMask, this.nodeMap, TrieNodeKt.access$insertEntryAtIndex(this.buffer, entryKeyIndex$runtime_release(positionMask), key, value));
        return trieNode;
    }

    private final K keyAtIndex(int keyIndex) {
        return this.buffer[keyIndex];
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> makeNode(int keyHash1, K key1, V value1, int keyHash2, K key2, V value2, int shift, MutabilityOwnership owner) {
        Object[] arr;
        Object obj2 = key1;
        final Object obj3 = value1;
        final Object obj4 = key2;
        final Object obj5 = value2;
        final int i10 = shift;
        final MutabilityOwnership mutabilityOwnership = owner;
        final int i11 = 0;
        if (i10 > 30) {
            TrieNode trieNode3 = new TrieNode(i11, i11, /* result */, mutabilityOwnership);
            return trieNode3;
        }
        int i3 = keyHash1;
        final int indexSegment = TrieNodeKt.indexSegment(i3, i10);
        final int i5 = keyHash2;
        final int indexSegment2 = TrieNodeKt.indexSegment(i5, i10);
        int i12 = 1;
        if (indexSegment != indexSegment2) {
            int i2 = 3;
            int i7 = 2;
            int i14 = 4;
            if (indexSegment < indexSegment2) {
                arr = new Object[i14];
                arr[i11] = obj2;
                arr[i12] = obj3;
                arr[i7] = obj4;
                arr[i2] = obj5;
            } else {
                arr = new Object[i14];
                arr[i11] = obj4;
                arr[i12] = obj5;
                arr[i7] = obj2;
                arr[i2] = obj3;
            }
            TrieNode trieNode2 = new TrieNode(i8 |= i13, i11, arr, mutabilityOwnership);
            return trieNode2;
        }
        TrieNode trieNode = new TrieNode(i11, i12 << indexSegment, /* result */, mutabilityOwnership);
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> moveEntryToNode(int keyIndex, int positionMask, int newKeyHash, K newKey, V newValue, int shift) {
        final Object obj = this;
        final int i2 = positionMask;
        TrieNode obj10 = new TrieNode(obj11 ^= i2, obj12 |= i2, obj.bufferMoveEntryToNode(keyIndex, i2, newKeyHash, newKey, newValue, shift, 0));
        return obj10;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutableCollisionPut(K key, V value, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder<K, V> mutator) {
        int i;
        boolean equal;
        int i4 = 0;
        IntProgression step = RangesKt.step((IntProgression)RangesKt.until(i4, buffer.length), 2);
        i = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 > 0) {
            if (i > last && step2 < 0 && last <= i) {
                if (step2 < 0) {
                    if (last <= i) {
                    }
                }
            }
        } else {
        }
        mutator.setSize(size++);
        TrieNode trieNode = new TrieNode(i4, i4, TrieNodeKt.access$insertEntryAtIndex(this.buffer, i4, key, value), mutator.getOwnership());
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutableCollisionPutAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> otherNode, DeltaCounter intersectionCounter, MutabilityOwnership owner) {
        int i3;
        int i;
        int i6;
        int i2;
        Object trieNode2;
        int i7;
        int trieNode;
        int j;
        int i4;
        Object obj;
        int i5;
        int i8 = 1;
        final int i10 = 0;
        i3 = this.nodeMap == null ? i8 : i10;
        CommonFunctionsKt.assert(i3);
        i = this.dataMap == null ? i8 : i10;
        CommonFunctionsKt.assert(i);
        i6 = otherNode.nodeMap == null ? i8 : i10;
        CommonFunctionsKt.assert(i6);
        i2 = otherNode.dataMap == null ? i8 : i10;
        CommonFunctionsKt.assert(i2);
        Object[] copyOf = Arrays.copyOf(this.buffer, length += length2);
        String str = "copyOf(this, newSize)";
        Intrinsics.checkNotNullExpressionValue(copyOf, str);
        i7 = buffer4.length;
        IntProgression step = RangesKt.step((IntProgression)RangesKt.until(i10, buffer5.length), 2);
        j = step.getFirst();
        final int last = step.getLast();
        int step2 = step.getStep();
        if (step2 > 0) {
            if (j > last && step2 < 0 && last <= j) {
                if (step2 < 0) {
                    if (last <= j) {
                    }
                }
            }
        } else {
        }
        int i9 = i7;
        if (i9 == buffer6.length) {
            trieNode2 = this;
        } else {
            if (i9 == buffer7.length) {
                trieNode2 = otherNode;
            } else {
                if (i9 == copyOf.length) {
                    trieNode2 = new TrieNode(i10, i10, copyOf, owner);
                } else {
                    j = Arrays.copyOf(copyOf, i9);
                    Intrinsics.checkNotNullExpressionValue(j, str);
                    trieNode = new TrieNode(i10, i10, j, owner);
                    trieNode2 = trieNode;
                }
            }
        }
        return trieNode2;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutableCollisionRemove(K key, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder<K, V> mutator) {
        int i;
        boolean equal;
        IntProgression step = RangesKt.step((IntProgression)RangesKt.until(0, buffer.length), 2);
        i = step.getFirst();
        final int last = step.getLast();
        int step2 = step.getStep();
        if (step2 > 0) {
            if (i > last && step2 < 0 && last <= i) {
                if (step2 < 0) {
                    if (last <= i) {
                    }
                }
            }
        } else {
        }
        return this;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutableCollisionRemove(K key, V value, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder<K, V> mutator) {
        int i;
        boolean equal;
        IntProgression step = RangesKt.step((IntProgression)RangesKt.until(0, buffer.length), 2);
        i = step.getFirst();
        final int last = step.getLast();
        int step2 = step.getStep();
        if (step2 > 0) {
            if (i > last && step2 < 0 && last <= i) {
                if (step2 < 0) {
                    if (last <= i) {
                    }
                }
            }
        } else {
        }
        return this;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutableCollisionRemoveEntryAtIndex(int i, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder<K, V> mutator) {
        mutator.setSize(size--);
        mutator.setOperationResult$runtime_release(valueAtKeyIndex(i));
        if (buffer.length == 2) {
            return 0;
        }
        if (this.ownedBy == mutator.getOwnership()) {
            this.buffer = TrieNodeKt.access$removeEntryAtIndex(this.buffer, i);
            return this;
        }
        final int i5 = 0;
        TrieNode trieNode = new TrieNode(i5, i5, TrieNodeKt.access$removeEntryAtIndex(this.buffer, i), mutator.getOwnership());
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutableInsertEntryAt(int positionMask, K key, V value, MutabilityOwnership owner) {
        final int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(positionMask);
        if (this.ownedBy == owner) {
            this.buffer = TrieNodeKt.access$insertEntryAtIndex(this.buffer, entryKeyIndex$runtime_release, key, value);
            this.dataMap = dataMap |= positionMask;
            return this;
        }
        TrieNode trieNode = new TrieNode(dataMap2 |= positionMask, this.nodeMap, TrieNodeKt.access$insertEntryAtIndex(this.buffer, entryKeyIndex$runtime_release, key, value), owner);
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutableMoveEntryToNode(int keyIndex, int positionMask, int newKeyHash, K newKey, V newValue, int shift, MutabilityOwnership owner) {
        if (this.ownedBy == owner) {
            MutabilityOwnership mutabilityOwnership = owner;
            int obj12 = shift;
            Object obj11 = newValue;
            Object obj10 = newKey;
            int obj9 = newKeyHash;
            int obj8 = positionMask;
            int obj7 = keyIndex;
            Object obj6 = this;
            obj6.buffer = bufferMoveEntryToNode(keyIndex, positionMask, newKeyHash, newKey, newValue, shift, owner);
            obj6.dataMap = dataMap ^= obj8;
            obj6.nodeMap = nodeMap |= obj8;
            return obj6;
        }
        MutabilityOwnership owner2 = owner;
        obj6 = obj7;
        obj7 = obj8;
        obj8 = obj9;
        obj9 = obj10;
        obj10 = obj11;
        obj11 = obj12;
        obj12 = obj11;
        obj11 = obj10;
        obj10 = obj9;
        obj9 = obj8;
        obj8 = obj7;
        obj7 = obj6;
        obj6 = this;
        TrieNode trieNode = new TrieNode(dataMap2 ^= obj8, nodeMap2 |= obj8, bufferMoveEntryToNode(obj6, obj7, obj8, obj9, obj10, obj11, owner2), owner2);
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutablePutAllFromOtherNodeCell(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> otherNode, int positionMask, int shift, DeltaCounter intersectionCounter, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder<K, V> mutator) {
        boolean otherTargetNode;
        int i;
        int mutablePut;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode targetNode;
        int i2;
        boolean key;
        int i3;
        int i4;
        Object keyAtIndex2;
        Object valueAtKeyIndex;
        int i5;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder ownership;
        int entryKeyIndex$runtime_release2;
        int entryKeyIndex$runtime_release;
        Object keyAtIndex;
        Object valueAtKeyIndex2;
        int i6;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder map;
        int i7;
        final Object obj = this;
        final Object obj2 = otherNode;
        final int i11 = positionMask;
        final DeltaCounter deltaCounter = intersectionCounter;
        mutablePut = 0;
        if (obj.hasNodeAt(i11)) {
            targetNode = obj.nodeAtIndex$runtime_release(obj.nodeIndex$runtime_release(i11));
            if (otherNode.hasNodeAt(positionMask)) {
                targetNode = otherTargetNode;
            } else {
                ownership = mutator;
                if (otherNode.hasEntryAt$runtime_release(positionMask)) {
                    otherTargetNode = otherNode.entryKeyIndex$runtime_release(positionMask);
                    keyAtIndex2 = obj2.keyAtIndex(otherTargetNode);
                    if (keyAtIndex2 != null) {
                        mutablePut = keyAtIndex2.hashCode();
                    }
                    mutablePut = targetNode.mutablePut(mutablePut, keyAtIndex2, obj2.valueAtKeyIndex(otherTargetNode), shift + 5, ownership);
                    i3 = mutablePut;
                    i5 = 0;
                    if (mutator.size() == ownership.size()) {
                        deltaCounter.setCount(count2++);
                    }
                    targetNode = mutablePut;
                } else {
                }
            }
        } else {
            if (otherNode.hasNodeAt(positionMask)) {
                entryKeyIndex$runtime_release2 = obj2.nodeAtIndex$runtime_release(otherNode.nodeIndex$runtime_release(positionMask));
                if (obj.hasEntryAt$runtime_release(i11)) {
                    otherTargetNode = obj.entryKeyIndex$runtime_release(i11);
                    keyAtIndex = obj.keyAtIndex(otherTargetNode);
                    if (keyAtIndex != null) {
                        i2 = keyAtIndex.hashCode();
                    } else {
                        i2 = mutablePut;
                    }
                    if (entryKeyIndex$runtime_release2.containsKey(i2, keyAtIndex, shift + 5)) {
                        deltaCounter.setCount(count++);
                        targetNode = entryKeyIndex$runtime_release2;
                    } else {
                        if (keyAtIndex != null) {
                            mutablePut = keyAtIndex.hashCode();
                        }
                        targetNode = entryKeyIndex$runtime_release2.mutablePut(mutablePut, keyAtIndex, obj.valueAtKeyIndex(otherTargetNode), shift + 5, mutator);
                    }
                } else {
                }
            } else {
                entryKeyIndex$runtime_release2 = obj.entryKeyIndex$runtime_release(i11);
                mutablePut = obj.keyAtIndex(entryKeyIndex$runtime_release2);
                entryKeyIndex$runtime_release = otherNode.entryKeyIndex$runtime_release(positionMask);
                keyAtIndex2 = obj2.keyAtIndex(entryKeyIndex$runtime_release);
                if (mutablePut != null) {
                    i4 = mutablePut.hashCode();
                } else {
                    i4 = i;
                }
                if (keyAtIndex2 != null) {
                    i = keyAtIndex2.hashCode();
                }
                targetNode = otherTargetNode;
            }
        }
        return targetNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutableRemoveEntryAtIndex(int keyIndex, int positionMask, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder<K, V> mutator) {
        mutator.setSize(size--);
        mutator.setOperationResult$runtime_release(valueAtKeyIndex(keyIndex));
        if (buffer.length == 2) {
            return 0;
        }
        if (this.ownedBy == mutator.getOwnership()) {
            this.buffer = TrieNodeKt.access$removeEntryAtIndex(this.buffer, keyIndex);
            this.dataMap = dataMap ^= positionMask;
            return this;
        }
        TrieNode trieNode = new TrieNode(dataMap2 ^= positionMask, this.nodeMap, TrieNodeKt.access$removeEntryAtIndex(this.buffer, keyIndex), mutator.getOwnership());
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutableRemoveNodeAtIndex(int nodeIndex, int positionMask, MutabilityOwnership owner) {
        if (buffer.length == 1) {
            return 0;
        }
        if (this.ownedBy == owner) {
            this.buffer = TrieNodeKt.access$removeNodeAtIndex(this.buffer, nodeIndex);
            this.nodeMap = nodeMap ^= positionMask;
            return this;
        }
        TrieNode trieNode = new TrieNode(this.dataMap, nodeMap2 ^= positionMask, TrieNodeKt.access$removeNodeAtIndex(this.buffer, nodeIndex), owner);
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutableReplaceNode(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> targetNode, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> newNode, int nodeIndex, int positionMask, MutabilityOwnership owner) {
        Object mutableUpdateNodeAtIndex;
        if (newNode == null) {
            mutableUpdateNodeAtIndex = mutableRemoveNodeAtIndex(nodeIndex, positionMask, owner);
        } else {
            if (this.ownedBy != owner) {
                if (targetNode != newNode) {
                    mutableUpdateNodeAtIndex = mutableUpdateNodeAtIndex(nodeIndex, newNode, owner);
                } else {
                    mutableUpdateNodeAtIndex = this;
                }
            } else {
            }
        }
        return mutableUpdateNodeAtIndex;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutableUpdateNodeAtIndex(int nodeIndex, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> newNode, MutabilityOwnership owner) {
        int nodeMap;
        int i;
        if (buffer.length == 1 && buffer2.length == 2 && newNode.nodeMap == null) {
            if (buffer2.length == 2) {
                if (newNode.nodeMap == null) {
                    newNode.dataMap = this.nodeMap;
                    return newNode;
                }
            }
        }
        if (this.ownedBy == owner) {
            this.buffer[nodeIndex] = newNode;
            return this;
        }
        Object[] buffer4 = this.buffer;
        Object[] copyOf = Arrays.copyOf(buffer4, buffer4.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[nodeIndex] = newNode;
        TrieNode trieNode = new TrieNode(this.dataMap, this.nodeMap, copyOf, owner);
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutableUpdateValueAtIndex(int keyIndex, V value, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder<K, V> mutator) {
        if (this.ownedBy == mutator.getOwnership()) {
            this.buffer[keyIndex + 1] = value;
            return this;
        }
        mutator.setModCount$runtime_release(modCount$runtime_release++);
        Object[] buffer2 = this.buffer;
        Object[] copyOf = Arrays.copyOf(buffer2, buffer2.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[keyIndex + 1] = value;
        TrieNode trieNode = new TrieNode(this.dataMap, this.nodeMap, copyOf, mutator.getOwnership());
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> removeEntryAtIndex(int keyIndex, int positionMask) {
        if (buffer.length == 2) {
            return 0;
        }
        TrieNode trieNode = new TrieNode(dataMap ^= positionMask, this.nodeMap, TrieNodeKt.access$removeEntryAtIndex(this.buffer, keyIndex));
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> removeNodeAtIndex(int nodeIndex, int positionMask) {
        if (buffer.length == 1) {
            return 0;
        }
        TrieNode trieNode = new TrieNode(this.dataMap, nodeMap ^= positionMask, TrieNodeKt.access$removeNodeAtIndex(this.buffer, nodeIndex));
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> replaceNode(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> targetNode, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> newNode, int nodeIndex, int positionMask) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode nodeAtIndex;
        if (newNode == null) {
            nodeAtIndex = removeNodeAtIndex(nodeIndex, positionMask);
        } else {
            if (targetNode != newNode) {
                nodeAtIndex = updateNodeAtIndex(nodeIndex, positionMask, newNode);
            } else {
                nodeAtIndex = this;
            }
        }
        return nodeAtIndex;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> updateNodeAtIndex(int nodeIndex, int positionMask, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> newNode) {
        int nodeMap;
        final Object[] buffer = newNode.buffer;
        int i2 = 1;
        if (buffer.length == 2 && newNode.nodeMap == null && buffer2.length == i2) {
            if (newNode.nodeMap == null) {
                i2 = 1;
                if (buffer2.length == i2) {
                    newNode.dataMap = this.nodeMap;
                    return newNode;
                }
                TrieNode trieNode2 = new TrieNode(dataMap2 ^= positionMask, nodeMap4 ^= positionMask, TrieNodeKt.access$replaceNodeWithEntry(this.buffer, nodeIndex, entryKeyIndex$runtime_release(positionMask), buffer[0], buffer[i2]));
                return trieNode2;
            }
        }
        Object[] copyOf = Arrays.copyOf(this.buffer, buffer3.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        copyOf[nodeIndex] = newNode;
        TrieNode trieNode = new TrieNode(this.dataMap, this.nodeMap, copyOf);
        return trieNode;
    }

    private final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> updateValueAtIndex(int keyIndex, V value) {
        Object[] buffer = this.buffer;
        Object[] copyOf = Arrays.copyOf(buffer, buffer.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[keyIndex + 1] = value;
        TrieNode trieNode = new TrieNode(this.dataMap, this.nodeMap, copyOf);
        return trieNode;
    }

    private final V valueAtKeyIndex(int keyIndex) {
        return this.buffer[keyIndex + 1];
    }

    public final void accept$runtime_release(Function5<? super androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> visitor) {
        final int i = 0;
        accept(visitor, i, i);
    }

    public final boolean containsKey(int keyHash, K key, int shift) {
        i <<= indexSegment;
        if (hasEntryAt$runtime_release(i2)) {
            return Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release(i2)));
        }
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(i2));
        if (hasNodeAt(i2) && shift == 30) {
            nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(i2));
            if (shift == 30) {
                return nodeAtIndex$runtime_release.collisionContainsKey(key);
            }
            return nodeAtIndex$runtime_release.containsKey(keyHash, key, shift + 5);
        }
        return 0;
    }

    public final int entryCount$runtime_release() {
        return Integer.bitCount(this.dataMap);
    }

    public final int entryKeyIndex$runtime_release(int positionMask) {
        return bitCount *= 2;
    }

    public final V get(int keyHash, K key, int shift) {
        i <<= indexSegment;
        int i3 = 0;
        int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i2);
        if (hasEntryAt$runtime_release(i2) && Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release))) {
            entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i2);
            if (Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release))) {
                return valueAtKeyIndex(entryKeyIndex$runtime_release);
            }
            return i3;
        }
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(i2));
        if (hasNodeAt(i2) && shift == 30) {
            nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(i2));
            if (shift == 30) {
                return nodeAtIndex$runtime_release.collisionGet(key);
            }
            return nodeAtIndex$runtime_release.get(keyHash, key, shift + 5);
        }
        return i3;
    }

    public final Object[] getBuffer$runtime_release() {
        return this.buffer;
    }

    public final boolean hasEntryAt$runtime_release(int positionMask) {
        int i;
        i = dataMap &= positionMask != 0 ? 1 : 0;
        return i;
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutablePut(int keyHash, K key, V value, int shift, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder<K, V> mutator) {
        int i;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder map;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode obj14;
        final int i3 = 1;
        int i4 = i3 << indexSegment;
        int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i4);
        mutator.setOperationResult$runtime_release(valueAtKeyIndex(entryKeyIndex$runtime_release));
        if (hasEntryAt$runtime_release(i4) && Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release)) && valueAtKeyIndex(entryKeyIndex$runtime_release) == value) {
            entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i4);
            if (Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release))) {
                mutator.setOperationResult$runtime_release(valueAtKeyIndex(entryKeyIndex$runtime_release));
                if (valueAtKeyIndex(entryKeyIndex$runtime_release) == value) {
                    return this;
                }
                return mutableUpdateValueAtIndex(entryKeyIndex$runtime_release, value, mutator);
            }
            mutator.setSize(size += i3);
            int i5 = keyHash;
            Object obj5 = key;
            Object obj6 = value;
            int i6 = shift;
            int obj13 = i4;
            int keyPositionMask2 = i5;
            Object keyHash2 = obj5;
            Object key2 = obj6;
            int obj12 = i6;
            return this.mutableMoveEntryToNode(entryKeyIndex$runtime_release, i4, i5, obj5, obj6, i6, mutator.getOwnership());
        }
        Object obj3 = key;
        Object obj4 = value;
        obj12 = shift;
        obj13 = i4;
        if (hasNodeAt(obj13)) {
            int obj11 = nodeIndex$runtime_release(obj13);
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(obj11);
            if (obj12 == 30) {
                obj14 = nodeAtIndex$runtime_release.mutableCollisionPut(obj3, obj4, mutator);
                map = mutator;
            } else {
                obj14 = nodeAtIndex$runtime_release.mutablePut(keyHash, obj3, obj4, obj12 + 5, mutator);
            }
            if (nodeAtIndex$runtime_release == obj14) {
                return this;
            }
            return mutableUpdateNodeAtIndex(obj11, obj14, map.getOwnership());
        }
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder mutator2 = mutator;
        mutator2.setSize(obj11 += i3);
        return mutableInsertEntryAt(obj13, obj3, obj4, mutator2.getOwnership());
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutablePutAll(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> otherNode, int shift, DeltaCounter intersectionCounter, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder<K, V> mutator) {
        int newNodeMap;
        int i7;
        int dataMap;
        int i2;
        int i;
        int entryKeyIndex$runtime_release;
        Object obj;
        int i5;
        int newDataMap;
        Object trieNode;
        int i8;
        int mask$iv3;
        int i9;
        boolean entryAt$runtime_release;
        int str;
        int mask$iv;
        int newDataMap2;
        int lowestOneBit;
        int index$iv2;
        int i6;
        int lowestOneBit3;
        int i4;
        int mask$iv2;
        Object keyAtIndex;
        int index$iv;
        Object lowestOneBit2;
        boolean equal;
        int i3;
        int $this$forEachOneBit$iv;
        Object[] objArr;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode mutablePutAllFromOtherNodeCell;
        final Object obj2 = this;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode map = otherNode;
        final DeltaCounter deltaCounter = intersectionCounter;
        if (obj2 == map) {
            deltaCounter.plusAssign(obj2.calculateSize());
            return obj2;
        }
        if (shift > 30) {
            return obj2.mutableCollisionPutAll(map, deltaCounter, mutator.getOwnership());
        }
        int i11 = 0;
        int newNodeMap2 = nodeMap | nodeMap2;
        int i15 = 0;
        str = 0;
        mask$iv = newNodeMap2;
        newNodeMap = i24;
        newDataMap2 = newDataMap3;
        newDataMap = i25;
        while (newNodeMap != null) {
            lowestOneBit = Integer.lowestOneBit(newNodeMap);
            i6 = lowestOneBit;
            i4 = 0;
            if (Intrinsics.areEqual(obj2.keyAtIndex(obj2.entryKeyIndex$runtime_release(i6)), map.keyAtIndex(map.entryKeyIndex$runtime_release(i6)))) {
            } else {
            }
            mask$iv |= i6;
            newDataMap++;
            newNodeMap ^= lowestOneBit;
            newDataMap2 |= i6;
        }
        i9 = 1;
        i7 = mask$iv & newDataMap2 == 0 ? i9 : 0;
        int i16 = 0;
        if (i7 == 0) {
            PreconditionsKt.throwIllegalStateException("Check failed.");
        }
        if (Intrinsics.areEqual(obj2.ownedBy, mutator.getOwnership()) && obj2.dataMap == newDataMap2 && obj2.nodeMap == mask$iv) {
            if (obj2.dataMap == newDataMap2) {
                if (obj2.nodeMap == mask$iv) {
                    trieNode = obj2;
                } else {
                    trieNode = new TrieNode(newDataMap2, mask$iv, new Object[i12 += bitCount2]);
                }
            } else {
            }
        } else {
        }
        Object obj3 = trieNode;
        lowestOneBit3 = 0;
        mask$iv2 = i2;
        index$iv = i8;
        while (mask$iv2 != 0) {
            lowestOneBit2 = Integer.lowestOneBit(mask$iv2);
            i3 = 0;
            obj3.buffer[i17 - equal] = obj2.mutablePutAllFromOtherNodeCell(map, lowestOneBit2, i5, deltaCounter, mutator);
            index$iv++;
            mask$iv2 ^= lowestOneBit2;
            i5 = shift;
        }
        int i14 = 0;
        mask$iv3 = i;
        index$iv2 = 0;
        while (mask$iv3 != 0) {
            lowestOneBit3 = Integer.lowestOneBit(mask$iv3);
            mask$iv2 = lowestOneBit3;
            lowestOneBit2 = 0;
            equal = index$iv * 2;
            if (!map.hasEntryAt$runtime_release(mask$iv2)) {
            } else {
            }
            $this$forEachOneBit$iv = i;
            i3 = i9;
            entryKeyIndex$runtime_release = map.entryKeyIndex$runtime_release(mask$iv2);
            obj3.buffer[equal] = map.keyAtIndex(entryKeyIndex$runtime_release);
            obj3.buffer[equal + 1] = map.valueAtKeyIndex(entryKeyIndex$runtime_release);
            if (obj2.hasEntryAt$runtime_release(mask$iv2)) {
            }
            index$iv2++;
            mask$iv3 ^= lowestOneBit3;
            i9 = i3;
            i = $this$forEachOneBit$iv;
            deltaCounter.setCount(count++);
            i3 = i9;
            entryAt$runtime_release = obj2.entryKeyIndex$runtime_release(mask$iv2);
            $this$forEachOneBit$iv = i;
            obj3.buffer[equal] = obj2.keyAtIndex(entryAt$runtime_release);
            obj3.buffer[equal + 1] = obj2.valueAtKeyIndex(entryAt$runtime_release);
        }
        int $this$forEachOneBit$iv3 = i;
        obj = obj2.elementsIdentityEquals(obj3) ? obj2 : elementsIdentityEquals2 ? map : obj3;
        return obj;
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutableRemove(int keyHash, K key, int shift, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder<K, V> mutator) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode mutableCollisionRemove;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode map;
        final int i4 = i << indexSegment;
        int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i4);
        if (hasEntryAt$runtime_release(i4) && Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release))) {
            entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i4);
            if (Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release))) {
                return mutableRemoveEntryAtIndex(entryKeyIndex$runtime_release, i4, mutator);
            }
            return this;
        }
        if (hasNodeAt(i4)) {
            final int nodeIndex$runtime_release = nodeIndex$runtime_release(i4);
            final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release);
            if (shift == 30) {
                map = mutableCollisionRemove;
            } else {
                map = mutableCollisionRemove;
            }
            return this.mutableReplaceNode(nodeAtIndex$runtime_release, map, nodeIndex$runtime_release, i4, mutator.getOwnership());
        }
        return this;
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> mutableRemove(int keyHash, K key, V value, int shift, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder<K, V> mutator) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode map;
        Object obj2;
        Object obj;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode mutableCollisionRemove;
        boolean equal;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder map2;
        final int i7 = i << indexSegment;
        int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i7);
        if (hasEntryAt$runtime_release(i7) && Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release)) && Intrinsics.areEqual(value, valueAtKeyIndex(entryKeyIndex$runtime_release))) {
            entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i7);
            if (Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release))) {
                if (Intrinsics.areEqual(value, valueAtKeyIndex(entryKeyIndex$runtime_release))) {
                    return mutableRemoveEntryAtIndex(entryKeyIndex$runtime_release, i7, mutator);
                }
            }
            return this;
        }
        if (hasNodeAt(i7)) {
            final int nodeIndex$runtime_release = nodeIndex$runtime_release(i7);
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release);
            if (shift == 30) {
                map = mutableCollisionRemove;
            } else {
                map = mutableCollisionRemove;
            }
            return this.mutableReplaceNode(nodeAtIndex$runtime_release, map, nodeIndex$runtime_release, i7, mutator.getOwnership());
        }
        return this;
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> nodeAtIndex$runtime_release(int nodeIndex) {
        Object obj = this.buffer[nodeIndex];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (TrieNode)obj;
    }

    public final int nodeIndex$runtime_release(int positionMask) {
        return i -= bitCount;
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode.ModificationResult<K, V> put(int keyHash, K key, V value, int shift) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode.ModificationResult obj14;
        int obj15;
        final int i5 = i << indexSegment;
        int i3 = 0;
        int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i5);
        if (hasEntryAt$runtime_release(i5) && Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release)) && valueAtKeyIndex(entryKeyIndex$runtime_release) == value) {
            entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i5);
            if (Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release))) {
                if (valueAtKeyIndex(entryKeyIndex$runtime_release) == value) {
                    return i3;
                }
                return updateValueAtIndex(entryKeyIndex$runtime_release, value).asUpdateResult();
            }
            return this.moveEntryToNode(entryKeyIndex$runtime_release, i5, keyHash, key, value, shift).asInsertResult();
        }
        Object obj = this;
        Object obj3 = key;
        Object obj5 = value;
        int i8 = shift;
        if (hasNodeAt(i5)) {
            int obj12 = nodeIndex$runtime_release(i5);
            final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode obj13 = nodeAtIndex$runtime_release(obj12);
            if (i8 == 30) {
                if (obj13.collisionPut(obj3, obj5) == null) {
                    return i3;
                }
            } else {
                if (obj13.put(keyHash, obj3, obj5, i8 + 5) == null) {
                    return i3;
                }
            }
            obj15 = obj14;
            int i2 = 0;
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode.ModificationResult map = obj15;
            int i4 = 0;
            final int i10 = 0;
            map.setNode(updateNodeAtIndex(obj12, i5, map.getNode()));
            return obj15;
        }
        return insertEntryAt(i5, obj3, obj5).asInsertResult();
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> remove(int keyHash, K key, int shift) {
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode collisionRemove;
        i <<= indexSegment;
        int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i2);
        if (hasEntryAt$runtime_release(i2) && Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release))) {
            entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i2);
            if (Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release))) {
                return removeEntryAtIndex(entryKeyIndex$runtime_release, i2);
            }
            return this;
        }
        if (hasNodeAt(i2)) {
            int nodeIndex$runtime_release = nodeIndex$runtime_release(i2);
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release);
            if (shift == 30) {
                collisionRemove = nodeAtIndex$runtime_release.collisionRemove(key);
            } else {
                collisionRemove = nodeAtIndex$runtime_release.remove(keyHash, key, shift + 5);
            }
            return replaceNode(nodeAtIndex$runtime_release, collisionRemove, nodeIndex$runtime_release, i2);
        }
        return this;
    }

    public final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K, V> remove(int keyHash, K key, V value, int shift) {
        boolean equal;
        androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode collisionRemove;
        i <<= indexSegment;
        int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i2);
        if (hasEntryAt$runtime_release(i2) && Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release)) && Intrinsics.areEqual(value, valueAtKeyIndex(entryKeyIndex$runtime_release))) {
            entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i2);
            if (Intrinsics.areEqual(key, keyAtIndex(entryKeyIndex$runtime_release))) {
                if (Intrinsics.areEqual(value, valueAtKeyIndex(entryKeyIndex$runtime_release))) {
                    return removeEntryAtIndex(entryKeyIndex$runtime_release, i2);
                }
            }
            return this;
        }
        if (hasNodeAt(i2)) {
            int nodeIndex$runtime_release = nodeIndex$runtime_release(i2);
            androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release);
            if (shift == 30) {
                collisionRemove = nodeAtIndex$runtime_release.collisionRemove(key, value);
            } else {
                collisionRemove = nodeAtIndex$runtime_release.remove(keyHash, key, value, shift + 5);
            }
            return replaceNode(nodeAtIndex$runtime_release, collisionRemove, nodeIndex$runtime_release, i2);
        }
        return this;
    }
}
