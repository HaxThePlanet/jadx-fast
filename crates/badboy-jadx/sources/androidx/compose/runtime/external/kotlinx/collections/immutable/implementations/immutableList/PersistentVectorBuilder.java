package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentCollection;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList.Builder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000~\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u001e\n\u0002\u0008\u0007\n\u0002\u0010(\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u000b\n\u0002\u0010)\n\u0000\n\u0002\u0010*\n\u0000\n\u0002\u0010+\n\u0002\u0008\u001d\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010!\n\u0002\u0008\u0018\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003B=\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0010\u0010\u0006\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001fJ\u001d\u0010\u001c\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\"J\u001e\u0010#\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u000b2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000%H\u0016J\u0016\u0010#\u001a\u00020\u001d2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000%H\u0016J\u001d\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010'J\u000e\u0010(\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J=\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0006\u0010+\u001a\u00020\u000b2\u000e\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080-H\u0002¢\u0006\u0002\u0010.J\u0016\u0010/\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u00100J\r\u00101\u001a\u00020\u000bH\u0000¢\u0006\u0002\u00082JG\u00103\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u00082\u0006\u00105\u001a\u000206H\u0002¢\u0006\u0002\u00107J[\u00103\u001a\u00020 2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010!\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0007H\u0002¢\u0006\u0002\u0010<J/\u0010=\u001a\u00020 2\u0010\u0010\u0010\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010>J\u001d\u0010?\u001a\u00020\u001d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0007H\u0002¢\u0006\u0002\u0010@J\u000f\u0010A\u001a\u0008\u0012\u0004\u0012\u00028\u00000BH\u0096\u0002J\u001e\u0010C\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00070D2\u0006\u0010!\u001a\u00020\u000bH\u0002J\u000e\u0010E\u001a\u0008\u0012\u0004\u0012\u00028\u00000FH\u0016J\u0016\u0010E\u001a\u0008\u0012\u0004\u0012\u00028\u00000F2\u0006\u0010!\u001a\u00020\u000bH\u0016J'\u0010G\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0010\u0010*\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u0007H\u0002¢\u0006\u0002\u0010HJ-\u0010I\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0006\u0010J\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010KJ\u0015\u0010L\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0007H\u0002¢\u0006\u0002\u0010\u0012J\u001f\u0010M\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u0008H\u0002¢\u0006\u0002\u0010NJ5\u0010O\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0006\u0010!\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010PJ?\u0010Q\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010R\u001a\u00020\u000b2\u0006\u0010S\u001a\u000206H\u0002¢\u0006\u0002\u0010TJ/\u0010U\u001a\u00020 2\u0010\u0010\u0010\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010VJM\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0010\u0010\u0010\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0014\u0010X\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00070-H\u0002¢\u0006\u0002\u0010YJE\u0010Z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0010\u0010\u0010\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0014\u00109\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00070\u0007H\u0002¢\u0006\u0002\u0010[J?\u0010\\\u001a\u00020 2\u0010\u0010\u0010\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u00072\u000e\u0010]\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u000e\u0010^\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0007H\u0002¢\u0006\u0002\u0010_J?\u0010`\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0010\u0010\u0010\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u00072\u000e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0006\u00104\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010aJu\u0010b\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0006\u0010e\u001a\u00020\u000b2\u0006\u0010f\u001a\u00020\u000b2\u0006\u0010g\u001a\u0002062\u0014\u0010h\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00070i2\u0014\u00109\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00070iH\u0002¢\u0006\u0002\u0010jJ\u001c\u0010k\u001a\u00020\u001d2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0dH\u0002JA\u0010k\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u000e\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0006\u0010e\u001a\u00020\u000b2\u0006\u0010g\u001a\u000206H\u0002¢\u0006\u0002\u0010lJ\u0016\u0010k\u001a\u00020\u001d2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000%H\u0016J,\u0010m\u001a\u00020\u000b2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0d2\u0006\u0010n\u001a\u00020\u000b2\u0006\u0010g\u001a\u000206H\u0002J\u001a\u0010o\u001a\u00020\u001d2\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u001d0dJ\u0015\u0010p\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000bH\u0016¢\u0006\u0002\u00100J=\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010S\u001a\u000206H\u0002¢\u0006\u0002\u0010TJ9\u0010r\u001a\u0004\u0018\u00010\u00082\u0010\u0010\u0010\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u00072\u0006\u0010R\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010sJ/\u0010t\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0006\u0010\u0018\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010KJ\u0008\u0010R\u001a\u00020\u000bH\u0002J\u001e\u0010u\u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010vJE\u0010w\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0006\u00104\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010x\u001a\u00028\u00002\u0006\u0010y\u001a\u000206H\u0002¢\u0006\u0002\u00107JU\u0010z\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0006\u0010{\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0007H\u0002¢\u0006\u0002\u0010|Jl\u0010}\u001a\u00020 2\u000c\u0010$\u001a\u0008\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010!\u001a\u00020\u000b2\u000e\u0010~\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u0006\u0010\u007f\u001a\u00020\u000b2\u0016\u00109\u001a\u0012\u0012\u000e\u0012\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u00070\u00072\u0006\u0010:\u001a\u00020\u000b2\u000e\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0007H\u0002¢\u0006\u0003\u0010\u0080\u0001J\u0008\u0010n\u001a\u00020\u000bH\u0002J\u0010\u0010n\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R4\u0010\u0010\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u00072\u0010\u0010\u000f\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u0007@BX\u0080\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\u0008\u0011\u0010\u0012R\u001a\u0010\n\u001a\u00020\u000bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015\"\u0004\u0008\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0019\u0010\u0015R0\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u00072\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0007@BX\u0080\u000e¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\u0008\u001b\u0010\u0012R\u0014\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0008\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00080\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0013¨\u0006\u0081\u0001", d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/PersistentVectorBuilder;", "E", "Lkotlin/collections/AbstractMutableList;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList$Builder;", "vector", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "vectorRoot", "", "", "vectorTail", "rootShift", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;[Ljava/lang/Object;[Ljava/lang/Object;I)V", "ownership", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "<set-?>", "root", "getRoot$runtime_release", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getRootShift$runtime_release", "()I", "setRootShift$runtime_release", "(I)V", "size", "getSize", "tail", "getTail$runtime_release", "add", "", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "", "bufferFor", "(I)[Ljava/lang/Object;", "build", "copyToBuffer", "buffer", "bufferIndex", "sourceIterator", "", "([Ljava/lang/Object;ILjava/util/Iterator;)[Ljava/lang/Object;", "get", "(I)Ljava/lang/Object;", "getModCount", "getModCount$runtime_release", "insertIntoRoot", "shift", "elementCarry", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;", "([Ljava/lang/Object;IILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "rightShift", "buffers", "nullBuffers", "nextBuffer", "(Ljava/util/Collection;II[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "insertIntoTail", "([Ljava/lang/Object;ILjava/lang/Object;)V", "isMutable", "([Ljava/lang/Object;)Z", "iterator", "", "leafBufferIterator", "", "listIterator", "", "makeMutable", "([Ljava/lang/Object;)[Ljava/lang/Object;", "makeMutableShiftingRight", "distance", "([Ljava/lang/Object;I)[Ljava/lang/Object;", "mutableBuffer", "mutableBufferWith", "(Ljava/lang/Object;)[Ljava/lang/Object;", "nullifyAfter", "([Ljava/lang/Object;II)[Ljava/lang/Object;", "pullLastBuffer", "rootSize", "tailCarry", "([Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)[Ljava/lang/Object;", "pullLastBufferFromRoot", "([Ljava/lang/Object;II)V", "pushBuffers", "buffersIterator", "([Ljava/lang/Object;IILjava/util/Iterator;)[Ljava/lang/Object;", "pushBuffersIncreasingHeightIfNeeded", "([Ljava/lang/Object;I[[Ljava/lang/Object;)[Ljava/lang/Object;", "pushFilledTail", "filledTail", "newTail", "([Ljava/lang/Object;[Ljava/lang/Object;[Ljava/lang/Object;)V", "pushTail", "([Ljava/lang/Object;[Ljava/lang/Object;I)[Ljava/lang/Object;", "recyclableRemoveAll", "predicate", "Lkotlin/Function1;", "bufferSize", "toBufferSize", "bufferRef", "recyclableBuffers", "", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;IILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;Ljava/util/List;Ljava/util/List;)I", "removeAll", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableList/ObjectRef;)I", "removeAllFromTail", "tailSize", "removeAllWithPredicate", "removeAt", "removeFromRootAt", "removeFromTailAt", "([Ljava/lang/Object;III)Ljava/lang/Object;", "retainFirst", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "setInRoot", "e", "oldElementCarry", "shiftLeafBuffers", "startLeafIndex", "(II[[Ljava/lang/Object;I[Ljava/lang/Object;)[Ljava/lang/Object;", "splitToBuffers", "startBuffer", "startBufferSize", "(Ljava/util/Collection;I[Ljava/lang/Object;I[[Ljava/lang/Object;I[Ljava/lang/Object;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PersistentVectorBuilder<E>  extends AbstractMutableList<E> implements PersistentList.Builder<E> {

    public static final int $stable = 8;
    private MutabilityOwnership ownership;
    private Object[] root;
    private int rootShift;
    private int size;
    private Object[] tail;
    private PersistentList<? extends E> vector;
    private Object[] vectorRoot;
    private Object[] vectorTail;
    static {
        final int i = 8;
    }

    public PersistentVectorBuilder(PersistentList<? extends E> vector, Object[] vectorRoot, Object[] vectorTail, int rootShift) {
        super();
        this.vector = vector;
        this.vectorRoot = vectorRoot;
        this.vectorTail = vectorTail;
        this.rootShift = rootShift;
        MutabilityOwnership mutabilityOwnership = new MutabilityOwnership();
        this.ownership = mutabilityOwnership;
        this.root = this.vectorRoot;
        this.tail = this.vectorTail;
        this.size = this.vector.size();
    }

    private final Object[] bufferFor(int index) {
        Object[] buffer;
        int shift;
        Object obj;
        String str;
        if (rootSize() <= index) {
            return this.tail;
        }
        Intrinsics.checkNotNull(this.root);
        shift = this.rootShift;
        while (shift > 0) {
            obj = buffer[UtilsKt.indexSegment(index, shift)];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            buffer = obj;
            shift += -5;
        }
        return buffer;
    }

    private final Object[] copyToBuffer(Object[] buffer, int bufferIndex, Iterator<? extends Object> sourceIterator) {
        int i2;
        int i;
        int next2;
        Object next;
        i2 = bufferIndex;
        while (i2 < 32) {
            if (sourceIterator.hasNext()) {
            }
            buffer[i2] = sourceIterator.next();
            i2 = i;
        }
        return buffer;
    }

    private final void insertIntoRoot(Collection<? extends E> elements, int index, int rightShift, Object[][] buffers, int nullBuffers, Object[] nextBuffer) {
        int i;
        Object objArr;
        if (this.root == null) {
        } else {
            int i5 = index >> 5;
            int i8 = nullBuffers;
            int i3 = i8;
            final int i10 = i3 - i;
            if (i10 < i3) {
                i = buffers[i10];
                Intrinsics.checkNotNull(i);
                objArr = i;
            } else {
                objArr = nextBuffer;
            }
            this.splitToBuffers(elements, index, this.shiftLeafBuffers(i5, rightShift, buffers, i8, nextBuffer), 32, buffers, i10, objArr);
        }
        int i2 = nullBuffers;
        int i4 = 0;
        IllegalStateException $i$a$CheckNotNullPersistentVectorBuilder$insertIntoRoot$1 = new IllegalStateException("root is null".toString());
        throw $i$a$CheckNotNullPersistentVectorBuilder$insertIntoRoot$1;
    }

    private final Object[] insertIntoRoot(Object[] root, int shift, int index, Object element, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef elementCarry) {
        Object obj3;
        int i;
        Object intoRoot;
        int i2;
        Object value;
        int obj12;
        final int indexSegment = UtilsKt.indexSegment(index, shift);
        if (shift == 0) {
            int i3 = 31;
            elementCarry.setValue(root[i3]);
            Object[] copyInto = ArraysKt.copyInto(root, makeMutable(root), indexSegment + 1, indexSegment, i3);
            copyInto[indexSegment] = element;
            return copyInto;
        }
        Object[] mutable = makeMutable(root);
        final int i5 = shift + -5;
        Object obj2 = mutable[indexSegment];
        final String str = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        Intrinsics.checkNotNull(obj2, str);
        i2 = index;
        value = element;
        final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef list = elementCarry;
        final int obj13 = i2;
        final Object obj14 = value;
        mutable[indexSegment] = this.insertIntoRoot((Object[])obj2, i5, i2, value, list);
        obj12 = indexSegment + 1;
        while (obj12 < 32) {
            if (mutable[obj12] != null) {
            }
            Object obj4 = mutable[obj12];
            Intrinsics.checkNotNull(obj4, str);
            mutable[obj12] = this.insertIntoRoot((Object[])obj4, i5, 0, list.getValue(), list);
            obj12++;
        }
        return mutable;
    }

    private final void insertIntoTail(Object[] root, int index, E element) {
        int i2;
        int mutableBufferWith;
        Object[] tail;
        int i;
        final int tailSize = tailSize();
        Object[] mutable = makeMutable(this.tail);
        if (tailSize < 32) {
            ArraysKt.copyInto(this.tail, mutable, index + 1, index, tailSize);
            mutable[index] = element;
            this.root = root;
            this.tail = mutable;
            this.size = size++;
        } else {
            int i4 = 31;
            ArraysKt.copyInto(this.tail, mutable, index + 1, index, i4);
            mutable[index] = element;
            pushFilledTail(root, mutable, mutableBufferWith(this.tail[i4]));
        }
    }

    private final boolean isMutable(Object[] buffer) {
        int length;
        int i;
        int ownership;
        if (buffer.length == 33 && buffer[32] == this.ownership) {
            i = buffer[32] == this.ownership ? 1 : 0;
        } else {
        }
        return i;
    }

    private final ListIterator<Object[]> leafBufferIterator(int index) {
        Object[] root = this.root;
        if (root == null) {
        } else {
            rootSize >>= 5;
            ListImplementation.checkPositionIndex$runtime_release(index, i);
            if (this.rootShift == 0) {
                SingleElementListIterator singleElementListIterator = new SingleElementListIterator(root, index);
                return (ListIterator)singleElementListIterator;
            }
            TrieIterator trieIterator = new TrieIterator(root, index, i, rootShift2 /= 5);
            return (ListIterator)trieIterator;
        }
        int root2 = 0;
        IllegalStateException $i$a$CheckNotNullPersistentVectorBuilder$leafBufferIterator$root$1 = new IllegalStateException("Invalid root".toString());
        throw $i$a$CheckNotNullPersistentVectorBuilder$leafBufferIterator$root$1;
    }

    private final Object[] makeMutable(Object[] buffer) {
        if (buffer == null) {
            return mutableBuffer();
        }
        if (isMutable(buffer)) {
            return buffer;
        }
        return ArraysKt.copyInto$default(buffer, mutableBuffer(), 0, 0, RangesKt.coerceAtMost(buffer.length, 32), 6, 0);
    }

    private final Object[] makeMutableShiftingRight(Object[] buffer, int distance) {
        final int i2 = 0;
        if (isMutable(buffer)) {
            return ArraysKt.copyInto(buffer, buffer, distance, i2, distance - 32);
        }
        return ArraysKt.copyInto(buffer, mutableBuffer(), distance, i2, distance - 32);
    }

    private final Object[] mutableBuffer() {
        Object[] arr = new Object[33];
        return arr;
    }

    private final Object[] mutableBufferWith(Object element) {
        Object[] arr = new Object[33];
        return arr;
    }

    private final Object[] nullifyAfter(Object[] root, int index, int shift) {
        int i;
        String $i$a$RequirePreconditionPersistentVectorBuilder$nullifyAfter$1;
        Object[] newRoot;
        int mutableBuffer;
        boolean mutable;
        int i2;
        int i3;
        int i4 = 0;
        i = shift >= 0 ? 1 : i4;
        int i5 = 0;
        if (i == 0) {
            int i6 = 0;
            PreconditionsKt.throwIllegalArgumentException("shift should be positive");
        }
        if (shift == 0) {
            return root;
        }
        int indexSegment = UtilsKt.indexSegment(index, shift);
        Object obj2 = root[indexSegment];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] nullifyAfter = nullifyAfter((Object[])obj2, index, shift + -5);
        newRoot = root;
        if (indexSegment < 31 && newRoot[indexSegment + 1] != null && isMutable(newRoot)) {
            if (newRoot[indexSegment + 1] != null) {
                if (isMutable(newRoot)) {
                    ArraysKt.fill(newRoot, 0, indexSegment + 1, 32);
                }
                newRoot = ArraysKt.copyInto(newRoot, mutableBuffer(), i4, i4, indexSegment + 1);
            }
        }
        if (nullifyAfter != newRoot[indexSegment]) {
            makeMutable(newRoot)[indexSegment] = nullifyAfter;
        }
        return newRoot;
    }

    private final Object[] pullLastBuffer(Object[] root, int shift, int rootSize, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef tailCarry) {
        int pullLastBuffer;
        int i;
        int indexSegment = UtilsKt.indexSegment(rootSize + -1, shift);
        int i4 = 0;
        if (shift == 5) {
            tailCarry.setValue(root[indexSegment]);
            pullLastBuffer = i4;
        } else {
            Object obj2 = root[indexSegment];
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            pullLastBuffer = pullLastBuffer((Object[])obj2, shift + -5, rootSize, tailCarry);
        }
        if (pullLastBuffer == 0 && indexSegment == 0) {
            if (indexSegment == 0) {
                return i4;
            }
        }
        Object[] mutable = makeMutable(root);
        mutable[indexSegment] = pullLastBuffer;
        return mutable;
    }

    private final void pullLastBufferFromRoot(Object[] root, int rootSize, int shift) {
        int i2;
        Object[] arr;
        int i;
        i2 = 0;
        i = 0;
        if (shift == 0) {
            this.root = i;
            arr = root == null ? new Object[i2] : root;
            this.tail = arr;
            this.size = rootSize;
            this.rootShift = shift;
        }
        ObjectRef objectRef = new ObjectRef(i);
        Intrinsics.checkNotNull(root);
        Object[] pullLastBuffer = pullLastBuffer(root, shift, rootSize, objectRef);
        Intrinsics.checkNotNull(pullLastBuffer);
        Object value = objectRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        this.tail = (Object[])value;
        this.size = rootSize;
        if (pullLastBuffer[1] == null) {
            this.root = (Object[])pullLastBuffer[i2];
            this.rootShift = shift + -5;
        } else {
            this.root = pullLastBuffer;
            this.rootShift = shift;
        }
    }

    private final Object[] pushBuffers(Object[] root, int rootSize, int shift, Iterator<Object[]> buffersIterator) {
        String $i$a$RequirePreconditionPersistentVectorBuilder$pushBuffers$1;
        int i2;
        int index;
        String $i$a$RequirePreconditionPersistentVectorBuilder$pushBuffers$2;
        Object[] pushBuffers;
        int next;
        int i;
        int i3 = 0;
        if (!buffersIterator.hasNext()) {
            int i5 = 0;
            PreconditionsKt.throwIllegalArgumentException("invalid buffersIterator");
        }
        int value$iv = 1;
        int i4 = 0;
        i2 = shift >= 0 ? value$iv : i4;
        int i6 = 0;
        if (i2 == 0) {
            int i7 = 0;
            PreconditionsKt.throwIllegalArgumentException("negative shift");
        }
        if (shift == 0) {
            return (Object[])buffersIterator.next();
        }
        Object[] mutable = makeMutable(root);
        index = UtilsKt.indexSegment(rootSize, shift);
        mutable[index] = pushBuffers((Object[])mutable[index], rootSize, shift + -5, buffersIterator);
        index += value$iv;
        while (index < 32) {
            if (buffersIterator.hasNext()) {
            }
            mutable[index] = pushBuffers((Object[])mutable[index], i4, shift + -5, buffersIterator);
            index += value$iv;
        }
        return mutable;
    }

    private final Object[] pushBuffersIncreasingHeightIfNeeded(Object[] root, int rootSize, Object[][] buffers) {
        Object[] mutableRoot;
        int i;
        int rootShift;
        Iterator iterator = ArrayIteratorKt.iterator((Object[])buffers);
        final int i4 = 1;
        if (rootSize >> 5 < i4 << rootShift3) {
            mutableRoot = pushBuffers(root, rootSize, this.rootShift, iterator);
        } else {
            mutableRoot = makeMutable(root);
        }
        while (iterator.hasNext()) {
            this.rootShift = rootShift4 += 5;
            pushBuffers(mutableBufferWith(mutableRoot), i4 << rootShift5, this.rootShift, iterator);
        }
        return mutableRoot;
    }

    private final void pushFilledTail(Object[] root, Object[] filledTail, Object[] newTail) {
        int i;
        int i2;
        final int i5 = 1;
        if (size >>= 5 > i5 << rootShift3) {
            this.root = pushTail(mutableBufferWith(root), filledTail, rootShift4 += 5);
            this.tail = newTail;
            this.rootShift = rootShift += 5;
            this.size = size2 += i5;
        } else {
            if (root == null) {
                this.root = filledTail;
                this.tail = newTail;
                this.size = size3 += i5;
            } else {
                this.root = pushTail(root, filledTail, this.rootShift);
                this.tail = newTail;
                this.size = size4 += i5;
            }
        }
    }

    private final Object[] pushTail(Object[] root, Object[] tail, int shift) {
        int pushTail;
        int i;
        int indexSegment = UtilsKt.indexSegment(size--, shift);
        final Object[] mutable = makeMutable(root);
        if (shift == 5) {
            mutable[indexSegment] = tail;
        } else {
            mutable[indexSegment] = pushTail((Object[])mutable[indexSegment], tail, shift + -5);
        }
        return mutable;
    }

    private final int recyclableRemoveAll(Function1<? super E, Boolean> predicate, Object[] buffer, int bufferSize, int toBufferSize, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef bufferRef, List<Object[]> recyclableBuffers, List<Object[]> buffers) {
        Object newToBuffer;
        int newToBufferSize;
        int index;
        Object obj;
        boolean booleanValue;
        Object mutableBuffer;
        if (isMutable(buffer)) {
            recyclableBuffers.add(buffer);
        }
        Object value = bufferRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        newToBuffer = value;
        newToBufferSize = toBufferSize;
        index = 0;
        while (index < bufferSize) {
            obj = buffer[index];
            if (!(Boolean)predicate.invoke(obj).booleanValue() && newToBufferSize == 32) {
            }
            index++;
            if (newToBufferSize == 32) {
            }
            newToBuffer[newToBufferSize] = obj;
            newToBufferSize = booleanValue;
            if (!(Collection)recyclableBuffers.isEmpty()) {
            } else {
            }
            mutableBuffer = mutableBuffer();
            newToBuffer = mutableBuffer;
            newToBufferSize = 0;
            mutableBuffer = recyclableBuffers.remove(size--);
        }
        bufferRef.setValue(newToBuffer);
        if ((Object[])value != bufferRef.getValue()) {
            buffers.add((Object[])value);
        }
        return newToBufferSize;
    }

    private final int removeAll(Function1<? super E, Boolean> predicate, Object[] buffer, int bufferSize, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef bufferRef) {
        Object[] newBuffer;
        int newBufferSize;
        int anyRemoved;
        int index;
        Object obj;
        boolean booleanValue;
        newBuffer = buffer;
        newBufferSize = bufferSize;
        anyRemoved = 0;
        index = 0;
        while (index < bufferSize) {
            obj = buffer[index];
            if ((Boolean)predicate.invoke(obj).booleanValue()) {
            } else {
            }
            if (anyRemoved != 0) {
            }
            index++;
            newBuffer[newBufferSize] = obj;
            newBufferSize = booleanValue;
            if (anyRemoved == 0) {
            }
            newBuffer = makeMutable(buffer);
            newBufferSize = index;
            anyRemoved = 1;
        }
        bufferRef.setValue(newBuffer);
        return newBufferSize;
    }

    private final boolean removeAll(Function1<? super E, Boolean> predicate) {
        Object obj;
        Function1 function1;
        int bufferSize;
        int i;
        ArrayList arrayList;
        Object next;
        int bufferSize2;
        Object[] root;
        int size;
        Object[] pushBuffers;
        int rootShift;
        int iterator;
        int tailSize = tailSize();
        rootShift = 0;
        ObjectRef objectRef = new ObjectRef(rootShift);
        final int i6 = 1;
        if (this.root == null && removeAllFromTail(predicate, tailSize, objectRef) != tailSize) {
            if (removeAllFromTail(predicate, tailSize, objectRef) != tailSize) {
                i = i6;
            }
            return i;
        }
        final ListIterator leafBufferIterator = leafBufferIterator(0);
        bufferSize = 32;
        iterator = 32;
        while (bufferSize == iterator) {
            if (leafBufferIterator.hasNext()) {
            }
            bufferSize = removeAll(predicate, (Object[])leafBufferIterator.next(), iterator, objectRef);
            iterator = 32;
        }
        CommonFunctionsKt.assert(next3 ^= i6);
        int allFromTail2 = removeAllFromTail(predicate, tailSize, objectRef);
        if (bufferSize == iterator && allFromTail2 == 0) {
            CommonFunctionsKt.assert(next3 ^= i6);
            allFromTail2 = removeAllFromTail(predicate, tailSize, objectRef);
            if (allFromTail2 == 0) {
                pullLastBufferFromRoot(this.root, size(), this.rootShift);
            }
            if (allFromTail2 != tailSize) {
                i = i6;
            }
            return i;
        }
        final int i8 = previousIndex << 5;
        ArrayList arrayList2 = new ArrayList();
        ArrayList list2 = arrayList2;
        arrayList = new ArrayList();
        ArrayList list = arrayList;
        bufferSize2 = bufferSize;
        for (Object[] bufferSize : leafBufferIterator) {
            bufferSize2 = this.recyclableRemoveAll(predicate, bufferSize, 32, bufferSize2, objectRef, (List)list, (List)list2);
        }
        int recyclableRemoveAll = this.recyclableRemoveAll(predicate, this.tail, tailSize, bufferSize2, objectRef, list, list2);
        Object value = objectRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        ArraysKt.fill((Object[])value, rootShift, recyclableRemoveAll, iterator);
        if (list2.isEmpty()) {
            Intrinsics.checkNotNull(this.root);
        } else {
            pushBuffers = pushBuffers(this.root, i8, this.rootShift, list2.iterator());
        }
        i4 += i8;
        this.root = retainFirst(pushBuffers, i5);
        this.tail = value;
        this.size = i5 + recyclableRemoveAll;
        return i6;
    }

    private final int removeAllFromTail(Function1<? super E, Boolean> predicate, int tailSize, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef bufferRef) {
        int i;
        int all = removeAll(predicate, this.tail, tailSize, bufferRef);
        if (all == tailSize) {
            i = bufferRef.getValue() == this.tail ? 1 : 0;
            CommonFunctionsKt.assert(i);
            return tailSize;
        }
        Object value = bufferRef.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        ArraysKt.fill((Object[])value, 0, all, tailSize);
        this.tail = value;
        this.size = size -= i4;
        return all;
    }

    private final Object[] removeFromRootAt(Object[] root, int shift, int index, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef tailCarry) {
        int removedElement;
        Object obj;
        int i2;
        Object[] fromRootAt;
        int i;
        final int indexSegment = UtilsKt.indexSegment(index, shift);
        if (shift == 0) {
            Object[] copyInto = ArraysKt.copyInto(root, makeMutable(root), indexSegment, indexSegment + 1, 32);
            copyInto[31] = tailCarry.getValue();
            tailCarry.setValue(root[indexSegment]);
            return copyInto;
        }
        if (root[31] == null) {
            removedElement = UtilsKt.indexSegment(rootSize--, shift);
        }
        Object[] mutable = makeMutable(root);
        int i3 = shift + -5;
        final int i7 = indexSegment + 1;
        final String str = "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>";
        if (i7 <= removedElement) {
        }
        Object obj3 = mutable[indexSegment];
        Intrinsics.checkNotNull(obj3, str);
        mutable[indexSegment] = removeFromRootAt((Object[])obj3, i3, index, tailCarry);
        return mutable;
    }

    private final Object removeFromTailAt(Object[] root, int rootSize, int shift, int index) {
        Object obj;
        int tail;
        int i;
        Object[] copyInto;
        int i2;
        int i3;
        size -= rootSize;
        int i5 = 0;
        tail = 1;
        i = index < i4 ? tail : i5;
        CommonFunctionsKt.assert(i);
        copyInto = 0;
        if (i4 == tail) {
            obj = this.tail[i5];
            pullLastBufferFromRoot(root, rootSize, shift);
        } else {
            obj = this.tail[index];
            copyInto = ArraysKt.copyInto(this.tail, makeMutable(this.tail), index, index + 1, i4);
            copyInto[i4 + -1] = 0;
            this.root = root;
            this.tail = copyInto;
            this.size = i7 -= tail;
            this.rootShift = shift;
        }
        return obj;
    }

    private final Object[] retainFirst(Object[] root, int size) {
        int i;
        String[] newRoot;
        String $i$a$RequirePreconditionPersistentVectorBuilder$retainFirst$1;
        String str;
        int i5 = 0;
        i = size & 31 == 0 ? 1 : i5;
        int i6 = 0;
        if (i == 0) {
            int i9 = 0;
            PreconditionsKt.throwIllegalArgumentException("invalid size");
        }
        if (size == 0) {
            this.rootShift = i5;
            return null;
        }
        int i3 = size + -1;
        newRoot = root;
        while (i3 >> rootShift2 == 0) {
            this.rootShift = rootShift3 += -5;
            $i$a$RequirePreconditionPersistentVectorBuilder$retainFirst$1 = newRoot[i5];
            Intrinsics.checkNotNull($i$a$RequirePreconditionPersistentVectorBuilder$retainFirst$1, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            newRoot = $i$a$RequirePreconditionPersistentVectorBuilder$retainFirst$1;
        }
        return nullifyAfter(newRoot, i3, this.rootShift);
    }

    private final int rootSize() {
        if (size() <= 32) {
            return 0;
        }
        return UtilsKt.rootSize(size());
    }

    private final Object[] setInRoot(Object[] root, int shift, int index, E e, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef oldElementCarry) {
        int i;
        final int indexSegment = UtilsKt.indexSegment(index, shift);
        final Object[] mutable = makeMutable(root);
        if (shift == 0 && mutable != root) {
            if (mutable != root) {
                this.modCount = modCount++;
            }
            oldElementCarry.setValue(mutable[indexSegment]);
            mutable[indexSegment] = e;
            return mutable;
        }
        Object obj2 = mutable[indexSegment];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        mutable[indexSegment] = this.setInRoot((Object[])obj2, shift + -5, index, e, oldElementCarry);
        return mutable;
    }

    private final Object[] shiftLeafBuffers(int startLeafIndex, int rightShift, Object[][] buffers, int nullBuffers, Object[] nextBuffer) {
        int bufferIndex;
        Object[] buffer;
        Object previous;
        int i;
        int i3;
        int i2;
        if (this.root == null) {
        } else {
            ListIterator leafBufferIterator = leafBufferIterator(rootSize >>= 5);
            bufferIndex = nullBuffers;
            buffer = nextBuffer;
            while (leafBufferIterator.previousIndex() != startLeafIndex) {
                previous = leafBufferIterator.previous();
                ArraysKt.copyInto((Object[])previous, buffer, 0, rightShift - 32, 32);
                buffers[bufferIndex--] = makeMutableShiftingRight(previous, rightShift);
            }
            return (Object[])leafBufferIterator.previous();
        }
        int leafCount = 0;
        IllegalStateException $i$a$CheckNotNullPersistentVectorBuilder$shiftLeafBuffers$1 = new IllegalStateException("root is null".toString());
        throw $i$a$CheckNotNullPersistentVectorBuilder$shiftLeafBuffers$1;
    }

    private final void splitToBuffers(Collection<? extends E> elements, int index, Object[] startBuffer, int startBufferSize, Object[][] buffers, int nullBuffers, Object[] nextBuffer) {
        int i3;
        Object[] mutableBuffer;
        int i4;
        String $i$a$RequirePreconditionPersistentVectorBuilder$splitToBuffers$1;
        Object[] newNextBuffer;
        int newNullBuffers;
        int i;
        int i2;
        Object[] objArr;
        int copyToBuffer;
        final int i5 = startBufferSize;
        final int i6 = nullBuffers;
        final int i7 = 0;
        int i8 = 1;
        i4 = i6 >= i8 ? i8 : i7;
        int i9 = 0;
        if (i4 == 0) {
            int i10 = 0;
            PreconditionsKt.throwIllegalArgumentException("requires at least one nullBuffer");
        }
        Object[] mutable = makeMutable(startBuffer);
        buffers[i7] = mutable;
        final int i11 = index & 31;
        i13 &= 31;
        final int i15 = i5 - i11;
        int i18 = 32;
        if (i14 + i15 < i18) {
            ArraysKt.copyInto(mutable, nextBuffer, i14 + 1, i11, i5);
            objArr = nextBuffer;
        } else {
            i17 += i8;
            if (i6 == i8) {
                newNextBuffer = mutableBuffer;
            } else {
                mutableBuffer = mutableBuffer();
                buffers[newNullBuffers--] = mutableBuffer;
                newNextBuffer = mutableBuffer;
            }
            ArraysKt.copyInto(mutable, nextBuffer, i7, i5 - i, i5);
            ArraysKt.copyInto(mutable, newNextBuffer, i14 + 1, i11, i5 - i);
        }
        Iterator iterator = elements.iterator();
        copyToBuffer(mutable, i11, iterator);
        i2 = 1;
        while (i2 < newNullBuffers) {
            buffers[i2] = copyToBuffer(mutableBuffer(), i7, iterator);
            i2++;
        }
        copyToBuffer(newNextBuffer, i7, iterator);
    }

    private final int tailSize() {
        return tailSize(size());
    }

    private final int tailSize(int size) {
        if (size <= 32) {
            return size;
        }
        return size - rootSize;
    }

    public void add(int index, E element) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        if (index == size()) {
            add(element);
        }
        this.modCount = modCount++;
        int rootSize = rootSize();
        if (index >= rootSize) {
            insertIntoTail(this.root, index - rootSize, element);
        }
        ObjectRef objectRef = new ObjectRef(0);
        final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef list = objectRef;
        final Object[] root2 = this.root;
        Intrinsics.checkNotNull(root2);
        insertIntoTail(this.insertIntoRoot(root2, this.rootShift, index, element, list), 0, list.getValue());
    }

    public boolean add(E element) {
        Object[] mutableBufferWith;
        int root;
        Object[] tail;
        final int i2 = 1;
        this.modCount = modCount += i2;
        int tailSize = tailSize();
        if (tailSize < 32) {
            mutableBufferWith = makeMutable(this.tail);
            mutableBufferWith[tailSize] = element;
            this.tail = mutableBufferWith;
            this.size = size += i2;
        } else {
            pushFilledTail(this.root, this.tail, mutableBufferWith(element));
        }
        return i2;
    }

    public boolean addAll(int index, Collection<? extends E> elements) {
        Object obj;
        Collection newTail2;
        int i2;
        int tail;
        int i;
        Object[][] tailSize;
        int buffersSize2;
        Object[] newTail3;
        Object[] newTail;
        int tailSize2;
        int buffersSize;
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        if (index == size()) {
            return addAll(elements);
        }
        i = 0;
        if (elements.isEmpty()) {
            return i;
        }
        final int i21 = 1;
        this.modCount = modCount += i21;
        final int i22 = i6 << 5;
        int i15 = i9 / 32;
        if (i15 == 0 && index >= rootSize()) {
            if (index >= rootSize()) {
                i = i21;
            }
            CommonFunctionsKt.assert(i);
            int i10 = index & 31;
            Object[] copyInto = ArraysKt.copyInto(this.tail, makeMutable(this.tail), i14 + 1, i10, tailSize());
            copyToBuffer(copyInto, i10, elements.iterator());
            this.tail = copyInto;
            this.size = size8 += size10;
            return i21;
        }
        newTail3 = i15;
        buffersSize2 = new Object[newTail3];
        int tailSize3 = tailSize();
        int tailSize4 = tailSize(size9 += size11);
        int i20 = 0;
        if (index >= rootSize()) {
            this.splitToBuffers(elements, index, this.tail, tailSize3, buffersSize2, newTail3, mutableBuffer());
            tailSize2 = tailSize3;
            tailSize = buffersSize2;
            buffersSize = newTail3;
        } else {
            tailSize2 = tailSize3;
            tailSize = buffersSize2;
            if (tailSize4 > tailSize2) {
                tail = tailSize4 - tailSize2;
                buffersSize2 = newTail3;
                newTail3 = mutableShiftingRight;
                this.insertIntoRoot(elements, index, tail, tailSize, buffersSize2, newTail3);
                buffersSize = buffersSize2;
                newTail = newTail3;
            } else {
                buffersSize = newTail3;
                newTail = ArraysKt.copyInto(this.tail, mutableBuffer(), i, tailSize2 - tailSize4, tailSize2);
                tail = i3 - 32;
                newTail3 = makeMutableShiftingRight(this.tail, tail);
                tailSize[buffersSize + -1] = newTail3;
                this.insertIntoRoot(elements, index, tail, tailSize, buffersSize + -1, newTail3);
            }
        }
        this.root = pushBuffersIncreasingHeightIfNeeded(this.root, i22, tailSize);
        this.tail = newTail;
        this.size = size3 += size4;
        return i21;
    }

    public boolean addAll(Collection<? extends E> elements) {
        int i;
        int size;
        int size2;
        int size3;
        int index;
        int copyToBuffer;
        int i3 = 0;
        if (elements.isEmpty()) {
            return i3;
        }
        final int i4 = 1;
        this.modCount = modCount += i4;
        int tailSize = tailSize();
        final Iterator iterator = elements.iterator();
        if (tailSize - 32 >= elements.size()) {
            this.tail = copyToBuffer(makeMutable(this.tail), tailSize, iterator);
            this.size = size4 += size;
        } else {
            i7 /= 32;
            size2 = new Object[size];
            size2[i3] = copyToBuffer(makeMutable(this.tail), tailSize, iterator);
            index = 1;
            while (index < size) {
                size2[index] = copyToBuffer(mutableBuffer(), i3, iterator);
                index++;
            }
            this.root = pushBuffersIncreasingHeightIfNeeded(this.root, rootSize(), size2);
            this.tail = copyToBuffer(mutableBuffer(), i3, iterator);
            this.size = size5 += size3;
        }
        return i4;
    }

    @Override // kotlin.collections.AbstractMutableList
    public PersistentCollection build() {
        return (PersistentCollection)build();
    }

    public PersistentList<E> build() {
        Object[] root;
        int i;
        PersistentList smallPersistentVector;
        Object[] vectorRoot;
        Object[] tail;
        int size;
        int rootShift;
        if (this.root == this.vectorRoot && this.tail == this.vectorTail) {
            if (this.tail == this.vectorTail) {
                smallPersistentVector = this.vector;
            } else {
                MutabilityOwnership mutabilityOwnership = new MutabilityOwnership();
                this.ownership = mutabilityOwnership;
                this.vectorRoot = this.root;
                this.vectorTail = this.tail;
                if (this.root == null) {
                    i = tail3.length == 0 ? 1 : 0;
                    if (i != 0) {
                        smallPersistentVector = UtilsKt.persistentVectorOf();
                    } else {
                        vectorRoot = Arrays.copyOf(this.tail, size());
                        Intrinsics.checkNotNullExpressionValue(vectorRoot, "copyOf(this, newSize)");
                        smallPersistentVector = new SmallPersistentVector(vectorRoot);
                    }
                } else {
                    vectorRoot = this.root;
                    Intrinsics.checkNotNull(vectorRoot);
                    smallPersistentVector = new PersistentVector(vectorRoot, this.tail, size(), this.rootShift);
                }
            }
        } else {
        }
        this.vector = smallPersistentVector;
        return this.vector;
    }

    public E get(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        return bufferFor(index)[index & 31];
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int getModCount$runtime_release() {
        return this.modCount;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object[] getRoot$runtime_release() {
        return this.root;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final int getRootShift$runtime_release() {
        return this.rootShift;
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.AbstractMutableList
    public final Object[] getTail$runtime_release() {
        return this.tail;
    }

    public Iterator<E> iterator() {
        return (Iterator)listIterator();
    }

    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    public ListIterator<E> listIterator(int index) {
        ListImplementation.checkPositionIndex$runtime_release(index, size());
        PersistentVectorMutableIterator persistentVectorMutableIterator = new PersistentVectorMutableIterator(this, index);
        return (ListIterator)persistentVectorMutableIterator;
    }

    public boolean removeAll(Collection<? extends Object> elements) {
        PersistentVectorBuilder.removeAll.1 anon = new PersistentVectorBuilder.removeAll.1(elements);
        return removeAllWithPredicate((Function1)anon);
    }

    public final boolean removeAllWithPredicate(Function1<? super E, Boolean> predicate) {
        int i;
        final boolean all = removeAll(predicate);
        if (all) {
            this.modCount = modCount++;
        }
        return all;
    }

    public E removeAt(int index) {
        ListImplementation.checkElementIndex$runtime_release(index, size());
        this.modCount = modCount++;
        int rootSize = rootSize();
        if (index >= rootSize) {
            return removeFromTailAt(this.root, rootSize, this.rootShift, index - rootSize);
        }
        int i3 = 0;
        ObjectRef objectRef = new ObjectRef(this.tail[i3]);
        Object[] root2 = this.root;
        Intrinsics.checkNotNull(root2);
        removeFromTailAt(removeFromRootAt(root2, this.rootShift, index, objectRef), rootSize, this.rootShift, i3);
        return objectRef.getValue();
    }

    public E set(int index, E element) {
        Object[] tail;
        ListImplementation.checkElementIndex$runtime_release(index, size());
        Object[] mutable = makeMutable(this.tail);
        if (rootSize() <= index && mutable != this.tail) {
            mutable = makeMutable(this.tail);
            if (mutable != this.tail) {
                this.modCount = modCount++;
            }
            int i = index & 31;
            mutable[i] = element;
            this.tail = mutable;
            return mutable[i];
        }
        ObjectRef mutableTail = new ObjectRef(0);
        final androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.ObjectRef list = mutableTail;
        final Object[] root = this.root;
        Intrinsics.checkNotNull(root);
        Object obj2 = this;
        obj2.root = obj2.setInRoot(root, this.rootShift, index, element, list);
        return list.getValue();
    }

    @Override // kotlin.collections.AbstractMutableList
    public final void setRootShift$runtime_release(int <set-?>) {
        this.rootShift = <set-?>;
    }
}
