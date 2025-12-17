package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.SlotWriter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ&\u0010\u000c\u001a\u00020\u000b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000bJ\"\u0010\u0014\u001a\u00020\u000b2\n\u0010\u0015\u001a\u0006\u0012\u0002\u0008\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010\u001d\u001a\u00020\u001cJ\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0016J>\u0010!\u001a\u00020\u000b\"\u0004\u0008\u0000\u0010\"\"\u0004\u0008\u0001\u0010#2\u0006\u0010$\u001a\u0002H\"2\u001d\u0010%\u001a\u0019\u0012\u0004\u0012\u0002H#\u0012\u0004\u0012\u0002H\"\u0012\u0004\u0012\u00020\u000b0&¢\u0006\u0002\u0008'¢\u0006\u0002\u0010(R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\t¨\u0006)", d2 = {"Landroidx/compose/runtime/changelist/FixupList;", "Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", "()V", "operations", "Landroidx/compose/runtime/changelist/Operations;", "pendingOperations", "size", "", "getSize", "()I", "clear", "", "createAndInsertNode", "factory", "Lkotlin/Function0;", "", "insertIndex", "groupAnchor", "Landroidx/compose/runtime/Anchor;", "endNodeInsert", "executeAndFlushAllPendingFixups", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "isEmpty", "", "isNotEmpty", "toDebugString", "", "linePrefix", "updateNode", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FixupList extends androidx.compose.runtime.changelist.OperationsDebugStringFormattable {

    public static final int $stable = 8;
    private final androidx.compose.runtime.changelist.Operations operations;
    private final androidx.compose.runtime.changelist.Operations pendingOperations;
    static {
        final int i = 8;
    }

    public FixupList() {
        super();
        Operations operations = new Operations();
        this.operations = operations;
        Operations operations2 = new Operations();
        this.pendingOperations = operations2;
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void clear() {
        this.pendingOperations.clear();
        this.operations.clear();
    }

    public final void createAndInsertNode(Function0<? extends Object> factory, int insertIndex, Anchor groupAnchor) {
        Object missingInts$iv;
        int $this$push_u24lambda_u246_u24lambda_u243$iv4;
        StringBuilder sb3;
        int missingIntCount$iv;
        Object missingObjects$iv;
        Object pendingOperations;
        int this_$iv;
        int $this$push_u24lambda_u246_u24lambda_u245$iv3;
        StringBuilder sb4;
        int $this$push_u24lambda_u246_u24lambda_u245$iv2;
        StringBuilder sb6;
        Object this_$iv4;
        int string;
        int $i$f$push;
        int $this$push_u24lambda_u246_u24lambda_u243$iv;
        StringBuilder sb;
        int i5;
        int value$iv$iv2;
        int i9;
        int value$iv$iv;
        int i6;
        int append;
        int i12;
        int $i$f$checkPrecondition;
        int objectParamName-31yXWZQ;
        Object $i$f$getFactoryHpuvwBQ;
        int this_$iv2;
        int i2;
        androidx.compose.runtime.changelist.Operations this_$iv3;
        int stringBuilder;
        int missingIntCount$iv2;
        StringBuilder sb7;
        int $this$push_u24lambda_u246_u24lambda_u245$iv;
        int $this$push_u24lambda_u246_u24lambda_u243$iv3;
        StringBuilder stringBuilder2;
        StringBuilder sb2;
        StringBuilder sb5;
        int $this$push_u24lambda_u246_u24lambda_u245$iv4;
        int $this$push_u24lambda_u246_u24lambda_u243$iv2;
        int i8;
        int i13;
        int $i$f$push2;
        int i11;
        int i;
        int i4;
        int i7;
        int i10;
        int i3;
        Object obj = this;
        missingIntCount$iv = insertIndex;
        androidx.compose.runtime.changelist.Operations operations = obj.operations;
        androidx.compose.runtime.changelist.Operation.InsertNodeFixup iNSTANCE = Operation.InsertNodeFixup.INSTANCE;
        string = 0;
        operations.pushOp((Operation)iNSTANCE);
        androidx.compose.runtime.changelist.Operations constructor-impl2 = Operations.WriteScope.constructor-impl(operations);
        int i15 = 0;
        androidx.compose.runtime.changelist.Operation.InsertNodeFixup iNSTANCE3 = Operation.InsertNodeFixup.INSTANCE;
        int i20 = 0;
        int i21 = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(i21), factory);
        androidx.compose.runtime.changelist.Operation.InsertNodeFixup iNSTANCE4 = Operation.InsertNodeFixup.INSTANCE;
        int i22 = 0;
        Operations.WriteScope.setInt-A6tL2VI(constructor-impl2, Operation.IntParameter.constructor-impl(i21), missingIntCount$iv);
        androidx.compose.runtime.changelist.Operation.InsertNodeFixup iNSTANCE5 = Operation.InsertNodeFixup.INSTANCE;
        int i23 = 0;
        int i24 = 1;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(i24), groupAnchor);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects())) {
            value$iv$iv2 = Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects()) ? i24 : i21;
        } else {
        }
        append = 0;
        String str = ").";
        String str3 = " object arguments (";
        final String str5 = ") and ";
        final String str6 = " int arguments (";
        final String str7 = ". Not all arguments were provided. Missing ";
        int i25 = i21;
        String str2 = "Error while pushing ";
        final int i26 = i24;
        String str4 = ", ";
        androidx.compose.runtime.changelist.Operations operations2 = operations;
        this_$iv4 = "StringBuilder().apply(builderAction).toString()";
        if (value$iv$iv2 == 0) {
            stringBuilder = 0;
            StringBuilder stringBuilder6 = new StringBuilder();
            sb5 = stringBuilder6;
            int i33 = 0;
            $i$f$push2 = string;
            $this$push_u24lambda_u246_u24lambda_u243$iv = iNSTANCE.getInts();
            i11 = value$iv$iv2;
            value$iv$iv2 = i30;
            missingIntCount$iv2 = append;
            $i$f$checkPrecondition = i25;
            while ($i$f$checkPrecondition < $this$push_u24lambda_u246_u24lambda_u243$iv) {
                i = $i$f$checkPrecondition;
                i4 = 0;
                if (i40 &= i10 != 0) {
                } else {
                }
                i7 = $this$push_u24lambda_u246_u24lambda_u243$iv;
                sb = sb5;
                $this$push_u24lambda_u246_u24lambda_u243$iv2 = $i$f$checkPrecondition;
                $i$f$checkPrecondition = $this$push_u24lambda_u246_u24lambda_u243$iv2 + 1;
                sb5 = sb;
                $this$push_u24lambda_u246_u24lambda_u243$iv = i7;
                if (value$iv$iv2 > 0) {
                } else {
                }
                i7 = $this$push_u24lambda_u246_u24lambda_u243$iv;
                sb = sb5;
                $this$push_u24lambda_u246_u24lambda_u243$iv2 = $i$f$checkPrecondition;
                sb.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i)));
                value$iv$iv2++;
                i7 = $this$push_u24lambda_u246_u24lambda_u243$iv;
                sb5.append(str4);
            }
            StringBuilder $this$push_u24lambda_u246_u24lambda_u243$iv6 = sb5;
            string = stringBuilder6.toString();
            Intrinsics.checkNotNullExpressionValue(string, this_$iv4);
            stringBuilder2 = new StringBuilder();
            sb2 = stringBuilder2;
            i8 = 0;
            objectParamName-31yXWZQ = iNSTANCE.getObjects();
            $this$push_u24lambda_u246_u24lambda_u245$iv2 = i25;
            $i$f$getFactoryHpuvwBQ = i;
            while ($this$push_u24lambda_u246_u24lambda_u245$iv2 < objectParamName-31yXWZQ) {
                i = $this$push_u24lambda_u246_u24lambda_u245$iv2;
                i4 = 0;
                if (i38 &= i10 != 0) {
                } else {
                }
                i7 = $this$push_u24lambda_u246_u24lambda_u245$iv2;
                sb6 = sb2;
                $this$push_u24lambda_u246_u24lambda_u245$iv4 = objectParamName-31yXWZQ;
                sb2 = sb6;
                $this$push_u24lambda_u246_u24lambda_u245$iv2 = i19;
                objectParamName-31yXWZQ = i3;
                if (value$iv$iv2 > 0) {
                } else {
                }
                i7 = $this$push_u24lambda_u246_u24lambda_u245$iv2;
                sb6 = sb2;
                $this$push_u24lambda_u246_u24lambda_u245$iv4 = objectParamName-31yXWZQ;
                sb6.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i)));
                $i$f$getFactoryHpuvwBQ++;
                i7 = $this$push_u24lambda_u246_u24lambda_u245$iv2;
                sb2.append(str4);
            }
            StringBuilder $this$push_u24lambda_u246_u24lambda_u245$iv6 = sb2;
            String string3 = stringBuilder2.toString();
            Intrinsics.checkNotNullExpressionValue(string3, this_$iv4);
            StringBuilder stringBuilder4 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder4.append(str2).append(iNSTANCE).append(str7).append(value$iv$iv2).append(str6).append(string).append(str5).append($i$f$getFactoryHpuvwBQ).append(str3).append(string3).append(str).toString());
        } else {
            $i$f$push2 = string;
            i11 = value$iv$iv2;
            missingIntCount$iv2 = append;
        }
        pendingOperations = obj.pendingOperations;
        androidx.compose.runtime.changelist.Operation.PostInsertNodeFixup iNSTANCE2 = Operation.PostInsertNodeFixup.INSTANCE;
        $i$f$push = 0;
        pendingOperations.pushOp((Operation)iNSTANCE2);
        androidx.compose.runtime.changelist.Operations constructor-impl3 = Operations.WriteScope.constructor-impl(pendingOperations);
        int i16 = 0;
        androidx.compose.runtime.changelist.Operation.PostInsertNodeFixup iNSTANCE6 = Operation.PostInsertNodeFixup.INSTANCE;
        int i27 = 0;
        Operations.WriteScope.setInt-A6tL2VI(constructor-impl3, Operation.IntParameter.constructor-impl(i25), missingIntCount$iv);
        androidx.compose.runtime.changelist.Operation.PostInsertNodeFixup iNSTANCE7 = Operation.PostInsertNodeFixup.INSTANCE;
        int i28 = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl3, Operation.ObjectParameter.constructor-impl(i25), groupAnchor);
        if (Operations.access$getPushedIntMask$p(pendingOperations) == Operations.access$createExpectedArgMask(pendingOperations, iNSTANCE2.getInts()) && Operations.access$getPushedObjectMask$p(pendingOperations) == Operations.access$createExpectedArgMask(pendingOperations, iNSTANCE2.getObjects())) {
            value$iv$iv = Operations.access$getPushedObjectMask$p(pendingOperations) == Operations.access$createExpectedArgMask(pendingOperations, iNSTANCE2.getObjects()) ? i26 : i25;
        } else {
        }
        int i17 = 0;
        if (value$iv$iv == 0) {
            this_$iv2 = 0;
            StringBuilder stringBuilder5 = new StringBuilder();
            sb7 = stringBuilder5;
            int i31 = 0;
            $this$push_u24lambda_u246_u24lambda_u243$iv4 = iNSTANCE2.getInts();
            missingIntCount$iv = i29;
            this_$iv3 = pendingOperations;
            this_$iv = i25;
            while (this_$iv < $this$push_u24lambda_u246_u24lambda_u243$iv4) {
                sb2 = this_$iv;
                i8 = 0;
                if (i34 &= i11 != 0) {
                } else {
                }
                $i$f$push2 = $this$push_u24lambda_u246_u24lambda_u243$iv4;
                sb3 = sb7;
                $this$push_u24lambda_u246_u24lambda_u243$iv3 = this_$iv;
                this_$iv = $this$push_u24lambda_u246_u24lambda_u243$iv3 + 1;
                sb7 = sb3;
                $this$push_u24lambda_u246_u24lambda_u243$iv4 = $i$f$push2;
                if (missingIntCount$iv > 0) {
                } else {
                }
                $i$f$push2 = $this$push_u24lambda_u246_u24lambda_u243$iv4;
                sb3 = sb7;
                $this$push_u24lambda_u246_u24lambda_u243$iv3 = this_$iv;
                sb3.append(iNSTANCE2.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(sb2)));
                missingIntCount$iv++;
                $i$f$push2 = $this$push_u24lambda_u246_u24lambda_u243$iv4;
                sb7.append(str4);
            }
            StringBuilder $this$push_u24lambda_u246_u24lambda_u243$iv5 = sb7;
            String string2 = stringBuilder5.toString();
            Intrinsics.checkNotNullExpressionValue(string2, this_$iv4);
            stringBuilder = new StringBuilder();
            missingIntCount$iv2 = stringBuilder;
            stringBuilder2 = 0;
            $this$push_u24lambda_u246_u24lambda_u245$iv3 = iNSTANCE2.getObjects();
            i2 = value$iv$iv;
            value$iv$iv = i32;
            i13 = $i$f$push;
            $i$f$push = sb2;
            while (value$iv$iv < $this$push_u24lambda_u246_u24lambda_u245$iv3) {
                sb2 = value$iv$iv;
                $i$f$push2 = 0;
                if (i36 &= i != 0) {
                } else {
                }
                i11 = $this$push_u24lambda_u246_u24lambda_u245$iv3;
                sb4 = missingIntCount$iv2;
                $this$push_u24lambda_u246_u24lambda_u245$iv = value$iv$iv;
                value$iv$iv = $this$push_u24lambda_u246_u24lambda_u245$iv + 1;
                missingIntCount$iv2 = sb4;
                $this$push_u24lambda_u246_u24lambda_u245$iv3 = i11;
                if (missingIntCount$iv > 0) {
                } else {
                }
                i11 = $this$push_u24lambda_u246_u24lambda_u245$iv3;
                sb4 = missingIntCount$iv2;
                $this$push_u24lambda_u246_u24lambda_u245$iv = value$iv$iv;
                sb4.append(iNSTANCE2.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(sb2)));
                $i$f$push++;
                i11 = $this$push_u24lambda_u246_u24lambda_u245$iv3;
                missingIntCount$iv2.append(str4);
            }
            StringBuilder $this$push_u24lambda_u246_u24lambda_u245$iv5 = missingIntCount$iv2;
            pendingOperations = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(pendingOperations, this_$iv4);
            StringBuilder stringBuilder3 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder3.append(str2).append(iNSTANCE2).append(str7).append(missingIntCount$iv).append(str6).append(string2).append(str5).append($i$f$push).append(str3).append(pendingOperations).append(str).toString());
        } else {
            this_$iv3 = pendingOperations;
            i13 = $i$f$push;
            i2 = value$iv$iv;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void endNodeInsert() {
        String $i$a$RuntimeCheckFixupList$endNodeInsert$1;
        int i = 0;
        if (!this.pendingOperations.isNotEmpty()) {
            int i2 = 0;
            ComposerKt.composeImmediateRuntimeError("Cannot end node insertion, there are no pending operations that can be realized.");
        }
        this.pendingOperations.popInto(this.operations);
    }

    public final void executeAndFlushAllPendingFixups(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
        String $i$a$RuntimeCheckFixupList$executeAndFlushAllPendingFixups$1;
        final int i = 0;
        if (!this.pendingOperations.isEmpty()) {
            int i2 = 0;
            ComposerKt.composeImmediateRuntimeError("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
        }
        this.operations.executeAndFlushAllPendingOperations(applier, slots, rememberManager);
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final int getSize() {
        return this.operations.getSize();
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final boolean isEmpty() {
        return this.operations.isEmpty();
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final boolean isNotEmpty() {
        return this.operations.isNotEmpty();
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public String toDebugString(String linePrefix) {
        int string;
        String debugString;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i = 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        sb.append(stringBuilder2.append("FixupList instance containing ").append(getSize()).append(" operations").toString());
        string = (CharSequence)sb.length() > 0 ? 1 : 0;
        if (string != null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            sb.append(stringBuilder3.append(":\n").append(this.operations.toDebugString(linePrefix)).toString());
        }
        String string2 = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string2, "StringBuilder().apply(builderAction).toString()");
        return string2;
    }

    public final <V, T> void updateNode(V value, Function2<? super T, ? super V, Unit> block) {
        Object missingObjects$iv;
        int objectParamName-31yXWZQ;
        Object missingObjectCount$iv;
        int i6;
        int i8;
        int i7;
        int this_$iv;
        int string;
        Object missingIntCount$iv;
        int append;
        String intParamName-w8GmfQM;
        String str;
        int missingObjectCount$iv2;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i9;
        int i4;
        int i2;
        int i5;
        int i;
        int i3;
        missingObjects$iv = block;
        final androidx.compose.runtime.changelist.Operations operations = missingObjectCount$iv.operations;
        final androidx.compose.runtime.changelist.Operation.UpdateNode iNSTANCE = Operation.UpdateNode.INSTANCE;
        final int i10 = 0;
        operations.pushOp((Operation)iNSTANCE);
        androidx.compose.runtime.changelist.Operations constructor-impl2 = Operations.WriteScope.constructor-impl(operations);
        int i11 = 0;
        androidx.compose.runtime.changelist.Operation.UpdateNode iNSTANCE2 = Operation.UpdateNode.INSTANCE;
        int i13 = 0;
        string = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(string), value);
        androidx.compose.runtime.changelist.Operation.UpdateNode iNSTANCE3 = Operation.UpdateNode.INSTANCE;
        int i14 = 0;
        append = 1;
        Intrinsics.checkNotNull(missingObjects$iv, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(append), (Function2)TypeIntrinsics.beforeCheckcastToFunctionOfArity(missingObjects$iv, 2));
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects())) {
            i8 = Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects()) ? append : string;
        } else {
        }
        int i12 = 0;
        if (i8 == 0) {
            this_$iv = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i17 = 0;
            i4 = append;
            intParamName-w8GmfQM = ", ";
            while (string < iNSTANCE.getInts()) {
                i2 = string;
                i5 = 0;
                if (i20 &= i3 != 0 && missingIntCount$iv > 0) {
                }
                string++;
                append = i4;
                i4 = append;
                intParamName-w8GmfQM = ", ";
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i2)));
                missingIntCount$iv++;
                sb2.append(intParamName-w8GmfQM);
            }
            string = stringBuilder3.toString();
            String str2 = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str2);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i2 = 0;
            objectParamName-31yXWZQ = iNSTANCE.getObjects();
            missingObjectCount$iv = i16;
            missingObjectCount$iv2 = 0;
            while (missingObjectCount$iv2 < objectParamName-31yXWZQ) {
                i9 = missingObjectCount$iv2;
                i5 = 0;
                if (i18 &= i3 != 0) {
                } else {
                }
                i = objectParamName-31yXWZQ;
                missingObjectCount$iv2++;
                objectParamName-31yXWZQ = i;
                if (missingIntCount$iv > 0) {
                }
                i = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i9)));
                missingObjectCount$iv++;
                sb.append(intParamName-w8GmfQM);
            }
            String string2 = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string2, str2);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(missingObjectCount$iv).append(" object arguments (").append(string2).append(").").toString());
        }
    }
}
