package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.SlotWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u001c\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000 J2\u00020\u0001:\u0003JKLB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0006H\u0002J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J&\u0010\u001c\u001a\u00020\u00162\u001b\u0010\u001d\u001a\u0017\u0012\u0008\u0012\u00060\u001fR\u00020\u0000\u0012\u0004\u0012\u00020\u00160\u001e¢\u0006\u0002\u0008 H\u0086\u0008J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u0006H\u0002J\"\u0010#\u001a\u00020\u00162\n\u0010$\u001a\u0006\u0012\u0002\u0008\u00030%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J&\u0010*\u001a\u00020\u00162\u001b\u0010+\u001a\u0017\u0012\u0008\u0012\u00060\u001fR\u00020\u0000\u0012\u0004\u0012\u00020\u00160\u001e¢\u0006\u0002\u0008 H\u0086\u0008J\u0006\u0010,\u001a\u00020-J\u0006\u0010.\u001a\u00020-J\u0008\u0010/\u001a\u00020\rH\u0002J\u0006\u00100\u001a\u00020\u0016J\u000e\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u0000J\u000e\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\rJ7\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u00020\r2\u0017\u00105\u001a\u0013\u0012\u0004\u0012\u000206\u0012\u0004\u0012\u00020\u00160\u001e¢\u0006\u0002\u0008 H\u0086\u0008\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0002 \u0001J\u0010\u00107\u001a\u00020\u00162\u0006\u00104\u001a\u00020\rH\u0007J\u0010\u00108\u001a\u0002092\u0006\u0010:\u001a\u000209H\u0016J\u0008\u0010;\u001a\u000209H\u0017J\u001a\u0010<\u001a\u00020\u00062\u0006\u0010=\u001a\u00020>H\u0002ø\u0001\u0000¢\u0006\u0004\u0008?\u0010@J\u001e\u0010A\u001a\u00020\u00062\n\u0010=\u001a\u0006\u0012\u0002\u0008\u00030BH\u0002ø\u0001\u0000¢\u0006\u0004\u0008C\u0010@J\u0018\u0010D\u001a\u000209*\u00060\u001fR\u00020\u00002\u0006\u0010:\u001a\u000209H\u0002J\u0016\u0010E\u001a\u000209*\u0004\u0018\u00010\t2\u0006\u0010:\u001a\u000209H\u0002J\u000c\u0010F\u001a\u000209*\u000209H\u0002J \u0010G\u001a\u000209\"\u0004\u0008\u0000\u0010H*\u0008\u0012\u0004\u0012\u0002HH0I2\u0006\u0010:\u001a\u000209H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0008X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0008X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006M", d2 = {"Landroidx/compose/runtime/changelist/Operations;", "Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", "()V", "intArgs", "", "intArgsSize", "", "objectArgs", "", "", "[Ljava/lang/Object;", "objectArgsSize", "opCodes", "Landroidx/compose/runtime/changelist/Operation;", "[Landroidx/compose/runtime/changelist/Operation;", "opCodesSize", "pushedIntMask", "pushedObjectMask", "size", "getSize", "()I", "clear", "", "createExpectedArgMask", "paramCount", "determineNewSize", "currentSize", "requiredSize", "drain", "sink", "Lkotlin/Function1;", "Landroidx/compose/runtime/changelist/Operations$OpIterator;", "Lkotlin/ExtensionFunctionType;", "ensureIntArgsSizeAtLeast", "ensureObjectArgsSizeAtLeast", "executeAndFlushAllPendingOperations", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "forEach", "action", "isEmpty", "", "isNotEmpty", "peekOperation", "pop", "popInto", "other", "push", "operation", "args", "Landroidx/compose/runtime/changelist/Operations$WriteScope;", "pushOp", "toDebugString", "", "linePrefix", "toString", "topIntIndexOf", "parameter", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "topIntIndexOf-w8GmfQM", "(I)I", "topObjectIndexOf", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "topObjectIndexOf-31yXWZQ", "currentOpToDebugString", "formatOpArgumentToString", "indent", "toCollectionString", "T", "", "Companion", "OpIterator", "WriteScope", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class Operations extends androidx.compose.runtime.changelist.OperationsDebugStringFormattable {

    public static final int $stable = 0;
    public static final androidx.compose.runtime.changelist.Operations.Companion Companion = null;
    public static final int InitialCapacity = 16;
    private static final int MaxResizeAmount = 1024;
    private int[] intArgs;
    private int intArgsSize;
    private Object[] objectArgs;
    private int objectArgsSize;
    private androidx.compose.runtime.changelist.Operation[] opCodes;
    private int opCodesSize;
    private int pushedIntMask;
    private int pushedObjectMask;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Landroidx/compose/runtime/changelist/Operations$Companion;", "", "()V", "InitialCapacity", "", "MaxResizeAmount", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000c\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ&\u0010\u0010\u001a\u0002H\u0011\"\u0004\u0008\u0000\u0010\u00112\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u00110\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u00088F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\n\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006\u0017", d2 = {"Landroidx/compose/runtime/changelist/Operations$OpIterator;", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "(Landroidx/compose/runtime/changelist/Operations;)V", "intIdx", "", "objIdx", "opIdx", "operation", "Landroidx/compose/runtime/changelist/Operation;", "getOperation", "()Landroidx/compose/runtime/changelist/Operation;", "getInt", "parameter", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "getInt-w8GmfQM", "(I)I", "getObject", "T", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "getObject-31yXWZQ", "(I)Ljava/lang/Object;", "next", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class OpIterator implements androidx.compose.runtime.changelist.OperationArgContainer {

        private int intIdx;
        private int objIdx;
        private int opIdx;
        final androidx.compose.runtime.changelist.Operations this$0;
        public OpIterator(androidx.compose.runtime.changelist.Operations this$0) {
            this.this$0 = this$0;
            super();
        }

        @Override // androidx.compose.runtime.changelist.OperationArgContainer
        public int getInt-w8GmfQM(int parameter) {
            return Operations.access$getIntArgs$p(this.this$0)[intIdx += parameter];
        }

        public <T> T getObject-31yXWZQ(int parameter) {
            return Operations.access$getObjectArgs$p(this.this$0)[objIdx += parameter];
        }

        @Override // androidx.compose.runtime.changelist.OperationArgContainer
        public final androidx.compose.runtime.changelist.Operation getOperation() {
            androidx.compose.runtime.changelist.Operation operation = Operations.access$getOpCodes$p(this.this$0)[this.opIdx];
            Intrinsics.checkNotNull(operation);
            return operation;
        }

        @Override // androidx.compose.runtime.changelist.OperationArgContainer
        public final boolean next() {
            int i;
            if (this.opIdx >= Operations.access$getOpCodesSize$p(this.this$0)) {
                return 0;
            }
            androidx.compose.runtime.changelist.Operation operation = getOperation();
            this.intIdx = intIdx += ints;
            this.objIdx = objIdx += objects;
            int i6 = 1;
            this.opIdx = opIdx2 += i6;
            if (this.opIdx < Operations.access$getOpCodesSize$p(this.this$0)) {
                i = i6;
            }
            return i;
        }
    }

    @Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\u0008\u0011\u0010\u0012J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\u0008\u0018\u0010\u0019J,\u0010\u001a\u001a\u00020\u0014\"\u0004\u0008\u0000\u0010\u001b2\u000c\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u0002H\u001b0\u001c2\u0006\u0010\u0017\u001a\u0002H\u001bø\u0001\u0000¢\u0006\u0004\u0008\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020 HÖ\u0001¢\u0006\u0004\u0008!\u0010\"R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006#", d2 = {"Landroidx/compose/runtime/changelist/Operations$WriteScope;", "", "stack", "Landroidx/compose/runtime/changelist/Operations;", "constructor-impl", "(Landroidx/compose/runtime/changelist/Operations;)Landroidx/compose/runtime/changelist/Operations;", "operation", "Landroidx/compose/runtime/changelist/Operation;", "getOperation-impl", "(Landroidx/compose/runtime/changelist/Operations;)Landroidx/compose/runtime/changelist/Operation;", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/changelist/Operations;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/changelist/Operations;)I", "setInt", "", "parameter", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "value", "setInt-A6tL2VI", "(Landroidx/compose/runtime/changelist/Operations;II)V", "setObject", "T", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "setObject-DKhxnng", "(Landroidx/compose/runtime/changelist/Operations;ILjava/lang/Object;)V", "toString", "", "toString-impl", "(Landroidx/compose/runtime/changelist/Operations;)Ljava/lang/String;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class WriteScope {

        private final androidx.compose.runtime.changelist.Operations stack;
        private WriteScope(androidx.compose.runtime.changelist.Operations stack) {
            super();
            this.stack = stack;
        }

        public static final androidx.compose.runtime.changelist.Operations.WriteScope box-impl(androidx.compose.runtime.changelist.Operations operations) {
            Operations.WriteScope writeScope = new Operations.WriteScope(operations);
            return writeScope;
        }

        public static androidx.compose.runtime.changelist.Operations constructor-impl(androidx.compose.runtime.changelist.Operations operations) {
            return operations;
        }

        public static boolean equals-impl(androidx.compose.runtime.changelist.Operations operations, Object object2) {
            final int i2 = 0;
            if (!object2 instanceof Operations.WriteScope) {
                return i2;
            }
            if (!Intrinsics.areEqual(operations, (Operations.WriteScope)object2.unbox-impl())) {
                return i2;
            }
            return 1;
        }

        public static final boolean equals-impl0(androidx.compose.runtime.changelist.Operations operations, androidx.compose.runtime.changelist.Operations operations2) {
            return Intrinsics.areEqual(operations, operations2);
        }

        public static final androidx.compose.runtime.changelist.Operation getOperation-impl(androidx.compose.runtime.changelist.Operations arg0) {
            return Operations.access$peekOperation(arg0);
        }

        public static int hashCode-impl(androidx.compose.runtime.changelist.Operations operations) {
            return operations.hashCode();
        }

        public static final void setInt-A6tL2VI(androidx.compose.runtime.changelist.Operations arg0, int parameter, int value) {
            int i;
            String $i$a$CheckPreconditionOperations$WriteScope$setInt$1$1;
            StringBuilder append;
            String intParamName-w8GmfQM;
            final androidx.compose.runtime.changelist.Operations operations = arg0;
            final int i2 = 0;
            final int i5 = i << parameter;
            if (i6 &= i5 == 0) {
            } else {
                i = 0;
            }
            int i8 = 0;
            if (i == 0) {
                int i10 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                PreconditionsKt.throwIllegalStateException(stringBuilder.append("Already pushed argument ").append(Operations.WriteScope.getOperation-impl(arg0).intParamName-w8GmfQM(parameter)).toString());
            }
            Operations.access$setPushedIntMask$p(operations, i3 |= i5);
            Operations.access$getIntArgs$p(operations)[Operations.access$topIntIndexOf-w8GmfQM(operations, parameter)] = value;
        }

        public static final <T> void setObject-DKhxnng(androidx.compose.runtime.changelist.Operations arg0, int parameter, T value) {
            int i;
            String $i$a$CheckPreconditionOperations$WriteScope$setObject$1$1;
            StringBuilder append;
            String objectParamName-31yXWZQ;
            final androidx.compose.runtime.changelist.Operations operations = arg0;
            final int i2 = 0;
            final int i5 = i << parameter;
            if (i6 &= i5 == 0) {
            } else {
                i = 0;
            }
            int i8 = 0;
            if (i == 0) {
                int i10 = 0;
                StringBuilder stringBuilder = new StringBuilder();
                PreconditionsKt.throwIllegalStateException(stringBuilder.append("Already pushed argument ").append(Operations.WriteScope.getOperation-impl(arg0).objectParamName-31yXWZQ(parameter)).toString());
            }
            Operations.access$setPushedObjectMask$p(operations, i3 |= i5);
            Operations.access$getObjectArgs$p(operations)[Operations.access$topObjectIndexOf-31yXWZQ(operations, parameter)] = value;
        }

        public static String toString-impl(androidx.compose.runtime.changelist.Operations operations) {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("WriteScope(stack=").append(operations).append(')').toString();
        }

        public boolean equals(Object object) {
            return Operations.WriteScope.equals-impl(this.stack, object);
        }

        public int hashCode() {
            return Operations.WriteScope.hashCode-impl(this.stack);
        }

        public String toString() {
            return Operations.WriteScope.toString-impl(this.stack);
        }

        public final androidx.compose.runtime.changelist.Operations unbox-impl() {
            return this.stack;
        }
    }
    static {
        Operations.Companion companion = new Operations.Companion(0);
        Operations.Companion = companion;
        Operations.$stable = 8;
    }

    public Operations() {
        super();
        int i = 16;
        this.opCodes = new Operation[i];
        this.intArgs = new int[i];
        this.objectArgs = new Object[i];
    }

    public static final int access$createExpectedArgMask(androidx.compose.runtime.changelist.Operations $this, int paramCount) {
        return $this.createExpectedArgMask(paramCount);
    }

    public static final String access$formatOpArgumentToString(androidx.compose.runtime.changelist.Operations $this, Object $receiver, String linePrefix) {
        return $this.formatOpArgumentToString($receiver, linePrefix);
    }

    public static final int[] access$getIntArgs$p(androidx.compose.runtime.changelist.Operations $this) {
        return $this.intArgs;
    }

    public static final Object[] access$getObjectArgs$p(androidx.compose.runtime.changelist.Operations $this) {
        return $this.objectArgs;
    }

    public static final androidx.compose.runtime.changelist.Operation[] access$getOpCodes$p(androidx.compose.runtime.changelist.Operations $this) {
        return $this.opCodes;
    }

    public static final int access$getOpCodesSize$p(androidx.compose.runtime.changelist.Operations $this) {
        return $this.opCodesSize;
    }

    public static final int access$getPushedIntMask$p(androidx.compose.runtime.changelist.Operations $this) {
        return $this.pushedIntMask;
    }

    public static final int access$getPushedObjectMask$p(androidx.compose.runtime.changelist.Operations $this) {
        return $this.pushedObjectMask;
    }

    public static final androidx.compose.runtime.changelist.Operation access$peekOperation(androidx.compose.runtime.changelist.Operations $this) {
        return $this.peekOperation();
    }

    public static final void access$setPushedIntMask$p(androidx.compose.runtime.changelist.Operations $this, int <set-?>) {
        $this.pushedIntMask = <set-?>;
    }

    public static final void access$setPushedObjectMask$p(androidx.compose.runtime.changelist.Operations $this, int <set-?>) {
        $this.pushedObjectMask = <set-?>;
    }

    public static final int access$topIntIndexOf-w8GmfQM(androidx.compose.runtime.changelist.Operations $this, int parameter) {
        return $this.topIntIndexOf-w8GmfQM(parameter);
    }

    public static final int access$topObjectIndexOf-31yXWZQ(androidx.compose.runtime.changelist.Operations $this, int parameter) {
        return $this.topObjectIndexOf-31yXWZQ(parameter);
    }

    private final int createExpectedArgMask(int paramCount) {
        int i;
        int i2;
        if (paramCount == 0) {
            i = 0;
        } else {
            i = i2 >>> i3;
        }
        return i;
    }

    private final String currentOpToDebugString(androidx.compose.runtime.changelist.Operations.OpIterator $this$currentOpToDebugString, String linePrefix) {
        androidx.compose.runtime.changelist.Operation operation;
        int objects;
        StringBuilder stringBuilder;
        String string;
        StringBuilder sb2;
        int i4;
        int isFirstParam;
        String indent;
        int objects2;
        int constructor-impl;
        int i2;
        String int-w8GmfQM;
        int append;
        String str;
        String intParamName-w8GmfQM;
        StringBuilder sb;
        int i;
        androidx.compose.runtime.changelist.Operation operation3;
        androidx.compose.runtime.changelist.Operation operation2;
        int i3;
        final Object obj = this;
        final Object obj2 = $this$currentOpToDebugString;
        final String str2 = linePrefix;
        operation = obj2.getOperation();
        if (operation.getInts() == 0 && operation.getObjects() == 0) {
            if (operation.getObjects() == 0) {
                string = operation.getName();
                operation2 = operation;
            } else {
                stringBuilder = new StringBuilder();
                sb2 = stringBuilder;
                i4 = 0;
                sb2.append(operation.getName());
                sb2.append('(');
                int i6 = 0;
                isFirstParam = 1;
                indent = obj.indent(str2);
                i2 = 0;
                int-w8GmfQM = " = ";
                String str4 = ", ";
                str = "append('\\n')";
                while (i2 < operation.getInts()) {
                    i = 0;
                    constructor-impl = Operation.IntParameter.constructor-impl(i2);
                    if (isFirstParam == 0) {
                    } else {
                    }
                    isFirstParam = 0;
                    Intrinsics.checkNotNullExpressionValue(sb2.append('\n'), str);
                    sb2.append(indent);
                    sb2.append(operation.intParamName-w8GmfQM(constructor-impl));
                    sb2.append(int-w8GmfQM);
                    sb2.append(obj2.getInt-w8GmfQM(constructor-impl));
                    i2++;
                    int-w8GmfQM = " = ";
                    str4 = ", ";
                    str = "append('\\n')";
                    sb2.append(str4);
                }
                constructor-impl = 0;
                while (constructor-impl < operation.getObjects()) {
                    intParamName-w8GmfQM = 0;
                    int constructor-impl2 = Operation.ObjectParameter.constructor-impl(constructor-impl);
                    if (isFirstParam == 0) {
                    } else {
                    }
                    isFirstParam = 0;
                    Intrinsics.checkNotNullExpressionValue(sb2.append('\n'), str);
                    sb2.append(indent);
                    sb2.append(operation.objectParamName-31yXWZQ(constructor-impl2));
                    sb2.append(int-w8GmfQM);
                    sb2.append(obj.formatOpArgumentToString(obj2.getObject-31yXWZQ(constructor-impl2), indent));
                    constructor-impl++;
                    stringBuilder = sb;
                    i4 = i;
                    operation = operation3;
                    isFirstParam = i3;
                    sb2.append(str4);
                }
                operation2 = operation;
                i = i4;
                Intrinsics.checkNotNullExpressionValue(sb2.append('\n'), str);
                sb2.append(str2);
                sb2.append(")");
                Intrinsics.checkNotNullExpressionValue(stringBuilder.toString(), "StringBuilder().apply(builderAction).toString()");
            }
        } else {
        }
        return string;
    }

    private final int determineNewSize(int currentSize, int requiredSize) {
        return RangesKt.coerceAtLeast(currentSize + coerceAtMost, requiredSize);
    }

    private final void ensureIntArgsSizeAtLeast(int requiredSize) {
        int[] copyOf;
        String str;
        int length = intArgs.length;
        if (requiredSize > length) {
            copyOf = Arrays.copyOf(this.intArgs, determineNewSize(length, requiredSize));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.intArgs = copyOf;
        }
    }

    private final void ensureObjectArgsSizeAtLeast(int requiredSize) {
        Object[] copyOf;
        String str;
        int length = objectArgs.length;
        if (requiredSize > length) {
            copyOf = Arrays.copyOf(this.objectArgs, determineNewSize(length, requiredSize));
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.objectArgs = copyOf;
        }
    }

    private final String formatOpArgumentToString(Object $this$formatOpArgumentToString, String linePrefix) {
        String collectionString;
        if ($this$formatOpArgumentToString == null) {
            collectionString = "null";
        } else {
            if ($this$formatOpArgumentToString instanceof Object[]) {
                collectionString = toCollectionString(ArraysKt.asIterable((Object[])$this$formatOpArgumentToString), linePrefix);
            } else {
                if ($this$formatOpArgumentToString instanceof int[]) {
                    collectionString = toCollectionString(ArraysKt.asIterable((int[])$this$formatOpArgumentToString), linePrefix);
                } else {
                    if ($this$formatOpArgumentToString instanceof long[]) {
                        collectionString = toCollectionString(ArraysKt.asIterable((long[])$this$formatOpArgumentToString), linePrefix);
                    } else {
                        if ($this$formatOpArgumentToString instanceof float[]) {
                            collectionString = toCollectionString(ArraysKt.asIterable((float[])$this$formatOpArgumentToString), linePrefix);
                        } else {
                            if ($this$formatOpArgumentToString instanceof double[]) {
                                collectionString = toCollectionString(ArraysKt.asIterable((double[])$this$formatOpArgumentToString), linePrefix);
                            } else {
                                if ($this$formatOpArgumentToString instanceof Iterable) {
                                    collectionString = toCollectionString((Iterable)$this$formatOpArgumentToString, linePrefix);
                                } else {
                                    if ($this$formatOpArgumentToString instanceof OperationsDebugStringFormattable) {
                                        collectionString = (OperationsDebugStringFormattable)$this$formatOpArgumentToString.toDebugString(linePrefix);
                                    } else {
                                        collectionString = $this$formatOpArgumentToString.toString();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return collectionString;
    }

    private final String indent(String $this$indent) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append($this$indent).append("    ").toString();
    }

    private final androidx.compose.runtime.changelist.Operation peekOperation() {
        androidx.compose.runtime.changelist.Operation operation = this.opCodes[opCodesSize--];
        Intrinsics.checkNotNull(operation);
        return operation;
    }

    private final <T> String toCollectionString(Iterable<? extends T> $this$toCollectionString, String linePrefix) {
        Operations.toCollectionString.1 anon = new Operations.toCollectionString.1(this, linePrefix);
        return CollectionsKt.joinToString$default($this$toCollectionString, (CharSequence)", ", (CharSequence)"[", (CharSequence)"]", 0, 0, (Function1)anon, 24, 0);
    }

    private final int topIntIndexOf-w8GmfQM(int parameter) {
        return i += parameter;
    }

    private final int topObjectIndexOf-31yXWZQ(int parameter) {
        return i += parameter;
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void clear() {
        final int i = 0;
        this.opCodesSize = i;
        this.intArgsSize = i;
        ArraysKt.fill(this.objectArgs, 0, i, this.objectArgsSize);
        this.objectArgsSize = i;
    }

    public final void drain(Function1<? super androidx.compose.runtime.changelist.Operations.OpIterator, Unit> sink) {
        boolean opIterator;
        boolean next;
        final int i = 0;
        final androidx.compose.runtime.changelist.Operations operations = this;
        final int i2 = 0;
        if (operations.isNotEmpty()) {
            opIterator = new Operations.OpIterator(operations);
            sink.invoke(opIterator);
            while (!opIterator.next()) {
                sink.invoke(opIterator);
            }
        }
        clear();
    }

    public final void executeAndFlushAllPendingOperations(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
        boolean opIterator;
        boolean next;
        int i;
        androidx.compose.runtime.changelist.Operation operation;
        int i2;
        androidx.compose.runtime.changelist.Operations.OpIterator it;
        final androidx.compose.runtime.changelist.Operations operations = this;
        final int i3 = 0;
        final androidx.compose.runtime.changelist.Operations operations2 = operations;
        final int i4 = 0;
        if (operations2.isNotEmpty()) {
            opIterator = new Operations.OpIterator(operations2);
            androidx.compose.runtime.changelist.Operations.OpIterator it2 = opIterator;
            i = 0;
            i2 = 0;
            it2.getOperation().execute((OperationArgContainer)it2, applier, slots, rememberManager);
            while (!opIterator.next()) {
                it2 = opIterator;
                i = 0;
                i2 = 0;
                it2.getOperation().execute((OperationArgContainer)it2, applier, slots, rememberManager);
            }
        }
        operations.clear();
    }

    public final void forEach(Function1<? super androidx.compose.runtime.changelist.Operations.OpIterator, Unit> action) {
        boolean opIterator;
        boolean next;
        final int i = 0;
        if (isNotEmpty()) {
            opIterator = new Operations.OpIterator(this);
            action.invoke(opIterator);
            while (!opIterator.next()) {
                action.invoke(opIterator);
            }
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final int getSize() {
        return this.opCodesSize;
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final boolean isEmpty() {
        int i;
        i = getSize() == 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final boolean isNotEmpty() {
        int i;
        i = getSize() != 0 ? 1 : 0;
        return i;
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pop() {
        int i2;
        int i3;
        int i;
        int intArgs;
        Object[] intArgsSize;
        int objectArgsSize;
        if (isEmpty()) {
        } else {
            this.opCodesSize = opCodesSize--;
            androidx.compose.runtime.changelist.Operation operation = this.opCodes[this.opCodesSize];
            Intrinsics.checkNotNull(operation);
            int i6 = 0;
            this.opCodes[this.opCodesSize] = i6;
            int i5 = 0;
            i3 = i5;
            while (i3 < operation.getObjects()) {
                i = i3;
                intArgs = 0;
                this.objectArgsSize = objectArgsSize2--;
                this.objectArgs[this.objectArgsSize] = i6;
                i3++;
            }
            i2 = i5;
            while (i2 < operation.getInts()) {
                i3 = i2;
                i = 0;
                this.intArgsSize = intArgsSize2--;
                this.intArgs[this.intArgsSize] = i5;
                i2++;
            }
        }
        NoSuchElementException op = new NoSuchElementException("Cannot pop(), because the stack is empty.");
        throw op;
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void popInto(androidx.compose.runtime.changelist.Operations other) {
        int thisObjIdx;
        int otherObjIdx;
        int thisIntIdx;
        int otherIntIdx;
        int i;
        int i2;
        int i3;
        int i4;
        Object[] objectArgs;
        Object intArgs;
        int i5;
        if (isEmpty()) {
        } else {
            this.opCodesSize = opCodesSize--;
            androidx.compose.runtime.changelist.Operation operation = this.opCodes[this.opCodesSize];
            Intrinsics.checkNotNull(operation);
            int i9 = 0;
            this.opCodes[this.opCodesSize] = i9;
            other.pushOp(operation);
            int i7 = 0;
            thisObjIdx = this.objectArgsSize;
            int i8 = 0;
            otherObjIdx = other.objectArgsSize;
            int i12 = 0;
            i = i12;
            while (i < operation.getObjects()) {
                i2 = i;
                i4 = 0;
                thisObjIdx--;
                other.objectArgs[otherObjIdx--] = this.objectArgs[thisObjIdx];
                this.objectArgs[thisObjIdx] = i9;
                i++;
            }
            int i10 = 0;
            thisIntIdx = this.intArgsSize;
            int i11 = 0;
            otherIntIdx = other.intArgsSize;
            i3 = i12;
            while (i3 < operation.getInts()) {
                i4 = i3;
                objectArgs = 0;
                thisIntIdx--;
                other.intArgs[otherIntIdx--] = this.intArgs[thisIntIdx];
                this.intArgs[thisIntIdx] = i12;
                i3++;
            }
            this.objectArgsSize = objectArgsSize -= objects2;
            this.intArgsSize = intArgsSize -= ints2;
        }
        NoSuchElementException op = new NoSuchElementException("Cannot pop(), because the stack is empty.");
        throw op;
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void push(androidx.compose.runtime.changelist.Operation operation) {
        int objects;
        int i;
        String $i$a$RequirePreconditionOperations$push$1;
        StringBuilder append;
        String str;
        if (operation.getInts() == 0 && operation.getObjects() == 0) {
            i = operation.getObjects() == 0 ? 1 : 0;
        } else {
        }
        final int i2 = 0;
        if (i == 0) {
            int i3 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            PreconditionsKt.throwIllegalArgumentException(stringBuilder.append("Cannot push ").append(operation).append(" without arguments because it expects ").append(operation.getInts()).append(" ints and ").append(operation.getObjects()).append(" objects.").toString());
        }
        pushOp(operation);
    }

    public final void push(androidx.compose.runtime.changelist.Operation operation, Function1<? super androidx.compose.runtime.changelist.Operations.WriteScope, Unit> args) {
        Object missingObjects;
        int i7;
        int i10;
        int i;
        StringBuilder append;
        int missingObjectCount;
        int i2;
        int missingIntCount;
        String string;
        String str;
        int missingObjectCount2;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i8;
        String intParamName-w8GmfQM;
        int i9;
        int i4;
        int i6;
        int i5;
        int i11;
        int i3;
        missingObjects = this;
        final Object obj = operation;
        final int i12 = 0;
        pushOp(operation);
        args.invoke(Operations.WriteScope.box-impl(Operations.WriteScope.constructor-impl(missingObjects)));
        missingObjectCount = 1;
        if (Operations.access$getPushedIntMask$p(missingObjects) == Operations.access$createExpectedArgMask(missingObjects, obj.getInts()) && Operations.access$getPushedObjectMask$p(missingObjects) == Operations.access$createExpectedArgMask(missingObjects, obj.getObjects())) {
            i10 = Operations.access$getPushedObjectMask$p(missingObjects) == Operations.access$createExpectedArgMask(missingObjects, obj.getObjects()) ? missingObjectCount : 0;
        } else {
        }
        int i13 = 0;
        if (i10 == 0) {
            i2 = 0;
            missingIntCount = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i14 = 0;
            i8 = 0;
            intParamName-w8GmfQM = ", ";
            while (i8 < obj.getInts()) {
                i9 = i8;
                i4 = 0;
                if (i16 &= i5 != 0 && missingIntCount > 0) {
                }
                i8++;
                intParamName-w8GmfQM = ", ";
                if (missingIntCount > 0) {
                }
                sb2.append(obj.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i9)));
                missingIntCount++;
                sb2.append(intParamName-w8GmfQM);
            }
            string = stringBuilder3.toString();
            String str2 = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str2);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i9 = 0;
            missingObjectCount = i15;
            missingObjectCount2 = 0;
            while (missingObjectCount2 < obj.getObjects()) {
                i6 = missingObjectCount2;
                i5 = 0;
                if (i17 &= i3 != 0 && missingIntCount > 0) {
                }
                missingObjectCount2++;
                missingObjects = this;
                if (missingIntCount > 0) {
                }
                sb.append(obj.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i6)));
                missingObjectCount++;
                sb.append(intParamName-w8GmfQM);
            }
            String string2 = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string2, str2);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(obj).append(". Not all arguments were provided. Missing ").append(missingIntCount).append(" int arguments (").append(string).append(") and ").append(missingObjectCount).append(" object arguments (").append(string2).append(").").toString());
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushOp(androidx.compose.runtime.changelist.Operation operation) {
        int coerceAtMost;
        int copyOf;
        String str;
        int i = 0;
        this.pushedIntMask = i;
        this.pushedObjectMask = i;
        if (this.opCodesSize == opCodes2.length) {
            copyOf = Arrays.copyOf(this.opCodes, opCodesSize3 += coerceAtMost);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.opCodes = (Operation[])copyOf;
        }
        ensureIntArgsSizeAtLeast(resizeAmount += ints);
        ensureObjectArgsSizeAtLeast(objectArgsSize += objects);
        int opCodesSize2 = this.opCodesSize;
        this.opCodesSize = opCodesSize2 + 1;
        this.opCodes[opCodesSize2] = operation;
        this.intArgsSize = intArgsSize += ints2;
        this.objectArgsSize = objectArgsSize2 += objects2;
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public String toDebugString(String linePrefix) {
        int opNumber;
        boolean opIterator;
        androidx.compose.runtime.changelist.Operations.OpIterator it;
        int i;
        int i2;
        String str;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i3 = 0;
        int i4 = 0;
        opNumber = 1;
        final androidx.compose.runtime.changelist.Operations operations = this;
        final int i5 = 0;
        if (operations.isNotEmpty()) {
            opIterator = new Operations.OpIterator(operations);
            i = 0;
            sb.append(linePrefix);
            i2 = opNumber + 1;
            sb.append(opNumber);
            sb.append(". ");
            StringBuilder append = sb.append(currentOpToDebugString(opIterator, linePrefix));
            Intrinsics.checkNotNullExpressionValue(append, "append(value)");
            Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
            while (!opIterator.next()) {
                opNumber = i2;
                i = 0;
                sb.append(linePrefix);
                i2 = opNumber + 1;
                sb.append(opNumber);
                sb.append(". ");
                append = sb.append(currentOpToDebugString(opIterator, linePrefix));
                Intrinsics.checkNotNullExpressionValue(append, "append(value)");
                Intrinsics.checkNotNullExpressionValue(append.append('\n'), "append('\\n')");
            }
            opNumber = i2;
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Deprecated(message = "toString() will return the default implementation from Any. Did you mean to use toDebugString()?", replaceWith = @ReplaceWith(...))
    public String toString() {
        return super.toString();
    }
}
