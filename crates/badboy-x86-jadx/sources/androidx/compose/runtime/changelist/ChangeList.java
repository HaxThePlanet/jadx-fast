package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.ControlledComposition;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.internal.IntRef;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\"\u0010\u000b\u001a\u00020\n2\n\u0010\u000c\u001a\u0006\u0012\u0002\u0008\u00030\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0006J\u0018\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u001e\u0010\u001c\u001a\u00020\n2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u001e2\u0006\u0010\u001f\u001a\u00020 J(\u0010!\u001a\u00020\n2\u0008\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'J\u0006\u0010)\u001a\u00020\nJ\u0016\u0010*\u001a\u00020\n2\u0006\u0010+\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u0019J\u001b\u0010,\u001a\u00020\n2\u000e\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0-¢\u0006\u0002\u0010.J\"\u0010/\u001a\u00020\n2\u0012\u00100\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\n012\u0006\u00103\u001a\u000202J\u0006\u00104\u001a\u00020\nJ\u0006\u00105\u001a\u00020\nJ\u000e\u00106\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u00107\u001a\u00020\nJ\u001a\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\u00002\n\u0008\u0002\u0010\u001f\u001a\u0004\u0018\u00010 J\u0016\u0010:\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020;J\u001e\u0010:\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010&\u001a\u00020;2\u0006\u0010<\u001a\u00020=J\u000e\u0010>\u001a\u00020\n2\u0006\u0010?\u001a\u00020\u0006J\u001e\u0010@\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u0006J\u001e\u0010B\u001a\u00020\n2\u0006\u00103\u001a\u00020C2\u0006\u0010$\u001a\u00020%2\u0006\u0010D\u001a\u00020'J\u000e\u0010E\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020FJ\u0006\u0010G\u001a\u00020\nJ\u0016\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\u00062\u0006\u0010J\u001a\u00020\u0006J\u0006\u0010K\u001a\u00020\nJ\u0014\u0010L\u001a\u00020\n2\u000c\u0010M\u001a\u0008\u0012\u0004\u0012\u00020\n0NJ\u0006\u0010O\u001a\u00020\nJ\u000e\u0010P\u001a\u00020\n2\u0006\u0010A\u001a\u00020\u0006J \u0010Q\u001a\u00020\n2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010R\u001a\u00020\u0006J\u0010\u0010S\u001a\u00020\n2\u0008\u0010T\u001a\u0004\u0018\u00010\u001bJ>\u0010U\u001a\u00020\n\"\u0004\u0008\u0000\u0010V\"\u0004\u0008\u0001\u0010W2\u0006\u0010\u001a\u001a\u0002HW2\u001d\u0010X\u001a\u0019\u0012\u0004\u0012\u0002HV\u0012\u0004\u0012\u0002HW\u0012\u0004\u0012\u00020\n0Y¢\u0006\u0002\u0008Z¢\u0006\u0002\u0010[J\u0018\u0010\\\u001a\u00020\n2\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010R\u001a\u00020\u0006J\u000e\u0010]\u001a\u00020\n2\u0006\u0010A\u001a\u00020\u0006J\u0010\u0010^\u001a\u00020\n2\u0008\u0010_\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010`\u001a\u00020a2\u0006\u0010b\u001a\u00020aH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006c", d2 = {"Landroidx/compose/runtime/changelist/ChangeList;", "Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", "()V", "operations", "Landroidx/compose/runtime/changelist/Operations;", "size", "", "getSize", "()I", "clear", "", "executeAndFlushAllPendingChanges", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "isEmpty", "", "isNotEmpty", "pushAdvanceSlotsBy", "distance", "pushAppendValue", "anchor", "Landroidx/compose/runtime/Anchor;", "value", "", "pushCopyNodesToNewAnchorLocation", "nodes", "", "effectiveNodeIndex", "Landroidx/compose/runtime/internal/IntRef;", "pushCopySlotTableToAnchorLocation", "resolvedState", "Landroidx/compose/runtime/MovableContentState;", "parentContext", "Landroidx/compose/runtime/CompositionContext;", "from", "Landroidx/compose/runtime/MovableContentStateReference;", "to", "pushDeactivateCurrentGroup", "pushDetermineMovableContentNodeIndex", "effectiveNodeIndexOut", "pushDowns", "", "([Ljava/lang/Object;)V", "pushEndCompositionScope", "action", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "composition", "pushEndCurrentGroup", "pushEndMovableContentPlacement", "pushEnsureGroupStarted", "pushEnsureRootStarted", "pushExecuteOperationsIn", "changeList", "pushInsertSlots", "Landroidx/compose/runtime/SlotTable;", "fixups", "Landroidx/compose/runtime/changelist/FixupList;", "pushMoveCurrentGroup", "offset", "pushMoveNode", "count", "pushReleaseMovableGroupAtCurrent", "Landroidx/compose/runtime/ControlledComposition;", "reference", "pushRemember", "Landroidx/compose/runtime/RememberObserver;", "pushRemoveCurrentGroup", "pushRemoveNode", "removeFrom", "moveCount", "pushResetSlots", "pushSideEffect", "effect", "Lkotlin/Function0;", "pushSkipToEndOfCurrentGroup", "pushTrimValues", "pushUpdateAnchoredValue", "groupSlotIndex", "pushUpdateAuxData", "data", "pushUpdateNode", "T", "V", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "pushUpdateValue", "pushUps", "pushUseNode", "node", "toDebugString", "", "linePrefix", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ChangeList extends androidx.compose.runtime.changelist.OperationsDebugStringFormattable {

    public static final int $stable = 8;
    private final androidx.compose.runtime.changelist.Operations operations;
    static {
        final int i = 8;
    }

    public ChangeList() {
        super();
        Operations operations = new Operations();
        this.operations = operations;
    }

    public static void pushExecuteOperationsIn$default(androidx.compose.runtime.changelist.ChangeList changeList, androidx.compose.runtime.changelist.ChangeList changeList2, IntRef intRef3, int i4, Object object5) {
        int obj2;
        if (i4 &= 2 != 0) {
            obj2 = 0;
        }
        changeList.pushExecuteOperationsIn(changeList2, obj2);
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void clear() {
        this.operations.clear();
    }

    public final void executeAndFlushAllPendingChanges(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
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
    public final void pushAdvanceSlotsBy(int distance) {
        Object missingObjectCount$iv;
        int missingObjectCount$iv2;
        Object objectParamName-31yXWZQ;
        int i6;
        int i2;
        int i3;
        int this_$iv3;
        int str;
        int i10;
        int missingIntCount$iv;
        String string;
        String str2;
        int missingObjectCount$iv3;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i5;
        int i4;
        int i8;
        int i7;
        int i;
        androidx.compose.runtime.changelist.Operations this_$iv;
        int this_$iv2;
        int i9;
        objectParamName-31yXWZQ = missingObjectCount$iv.operations;
        final androidx.compose.runtime.changelist.Operation.AdvanceSlotsBy iNSTANCE = Operation.AdvanceSlotsBy.INSTANCE;
        final int i11 = 0;
        objectParamName-31yXWZQ.pushOp((Operation)iNSTANCE);
        int i12 = 0;
        androidx.compose.runtime.changelist.Operation.AdvanceSlotsBy iNSTANCE2 = Operation.AdvanceSlotsBy.INSTANCE;
        int i14 = 0;
        str = 0;
        Operations.WriteScope.setInt-A6tL2VI(Operations.WriteScope.constructor-impl(objectParamName-31yXWZQ), Operation.IntParameter.constructor-impl(str), distance);
        if (Operations.access$getPushedIntMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects())) {
            i2 = Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects()) ? 1 : str;
        } else {
        }
        int i13 = 0;
        if (i2 == 0) {
            i10 = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i16 = 0;
            i5 = str;
            i4 = 1;
            this_$iv3 = ", ";
            while (i5 < iNSTANCE.getInts()) {
                i8 = i5;
                i7 = 0;
                if (i18 &= this_$iv2 != 0 && missingIntCount$iv > 0) {
                }
                i5++;
                i4 = 1;
                this_$iv3 = ", ";
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i8)));
                missingIntCount$iv++;
                sb2.append(this_$iv3);
            }
            string = stringBuilder3.toString();
            str2 = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str2);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i8 = 0;
            missingObjectCount$iv2 = i17;
            missingObjectCount$iv3 = 0;
            while (missingObjectCount$iv3 < iNSTANCE.getObjects()) {
                i7 = missingObjectCount$iv3;
                i = 0;
                if (i19 &= i9 != 0) {
                } else {
                }
                this_$iv2 = objectParamName-31yXWZQ;
                missingObjectCount$iv3++;
                objectParamName-31yXWZQ = this_$iv2;
                if (missingIntCount$iv > 0) {
                }
                this_$iv2 = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i7)));
                missingObjectCount$iv2++;
                sb.append(this_$iv3);
            }
            this_$iv = objectParamName-31yXWZQ;
            objectParamName-31yXWZQ = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(objectParamName-31yXWZQ, str2);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(missingObjectCount$iv2).append(" object arguments (").append(objectParamName-31yXWZQ).append(").").toString());
        } else {
            this_$iv = objectParamName-31yXWZQ;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushAppendValue(Anchor anchor, Object value) {
        Object missingObjects$iv;
        int objectParamName-31yXWZQ;
        androidx.compose.runtime.changelist.Operations this_$iv;
        int i3;
        int i;
        int i4;
        int this_$iv3;
        int string;
        int append;
        String intParamName-w8GmfQM;
        int missingIntCount$iv;
        String str;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        androidx.compose.runtime.changelist.Operations this_$iv2;
        int i8;
        int i6;
        int i2;
        int i5;
        int i9;
        int i7;
        this_$iv = missingObjects$iv.operations;
        final androidx.compose.runtime.changelist.Operation.AppendValue iNSTANCE = Operation.AppendValue.INSTANCE;
        final int i10 = 0;
        this_$iv.pushOp((Operation)iNSTANCE);
        androidx.compose.runtime.changelist.Operations constructor-impl2 = Operations.WriteScope.constructor-impl(this_$iv);
        int i11 = 0;
        androidx.compose.runtime.changelist.Operation.AppendValue iNSTANCE2 = Operation.AppendValue.INSTANCE;
        int i13 = 0;
        string = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(string), anchor);
        androidx.compose.runtime.changelist.Operation.AppendValue iNSTANCE3 = Operation.AppendValue.INSTANCE;
        int i14 = 0;
        append = 1;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(append), value);
        if (Operations.access$getPushedIntMask$p(this_$iv) == Operations.access$createExpectedArgMask(this_$iv, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(this_$iv) == Operations.access$createExpectedArgMask(this_$iv, iNSTANCE.getObjects())) {
            i = Operations.access$getPushedObjectMask$p(this_$iv) == Operations.access$createExpectedArgMask(this_$iv, iNSTANCE.getObjects()) ? append : string;
        } else {
        }
        int i12 = 0;
        if (i == 0) {
            this_$iv3 = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i16 = 0;
            i8 = append;
            intParamName-w8GmfQM = ", ";
            while (string < iNSTANCE.getInts()) {
                i6 = string;
                i2 = 0;
                if (i17 &= i9 != 0 && missingIntCount$iv > 0) {
                }
                string++;
                append = i8;
                i8 = append;
                intParamName-w8GmfQM = ", ";
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i6)));
                missingIntCount$iv++;
                sb2.append(intParamName-w8GmfQM);
            }
            string = stringBuilder3.toString();
            String str2 = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str2);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i6 = 0;
            objectParamName-31yXWZQ = iNSTANCE.getObjects();
            this_$iv = i15;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < objectParamName-31yXWZQ) {
                i2 = missingObjectCount$iv;
                i5 = 0;
                if (i18 &= i7 != 0) {
                } else {
                }
                i9 = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = i9;
                if (missingIntCount$iv > 0) {
                }
                i9 = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i2)));
                this_$iv++;
                sb.append(intParamName-w8GmfQM);
            }
            String string2 = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string2, str2);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(this_$iv).append(" object arguments (").append(string2).append(").").toString());
        } else {
            this_$iv2 = this_$iv;
        }
    }

    public final void pushCopyNodesToNewAnchorLocation(List<? extends Object> nodes, IntRef effectiveNodeIndex) {
        Object missingObjects$iv;
        int objectParamName-31yXWZQ;
        Object missingObjectCount$iv2;
        androidx.compose.runtime.changelist.Operations operations;
        androidx.compose.runtime.changelist.Operation.CopyNodesToNewAnchorLocation iNSTANCE;
        int i10;
        int i12;
        int i3;
        int i4;
        int i7;
        int this_$iv;
        Object obj;
        int string;
        int i2;
        int append;
        String intParamName-w8GmfQM;
        int missingIntCount$iv;
        String str;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i5;
        int i;
        int i6;
        int i11;
        int i8;
        int i9;
        missingObjects$iv = nodes;
        if (!(Collection)missingObjects$iv.isEmpty()) {
            operations = missingObjectCount$iv2.operations;
            iNSTANCE = Operation.CopyNodesToNewAnchorLocation.INSTANCE;
            i10 = 0;
            operations.pushOp((Operation)iNSTANCE);
            androidx.compose.runtime.changelist.Operations constructor-impl2 = Operations.WriteScope.constructor-impl(operations);
            int i13 = 0;
            androidx.compose.runtime.changelist.Operation.CopyNodesToNewAnchorLocation iNSTANCE2 = Operation.CopyNodesToNewAnchorLocation.INSTANCE;
            int i14 = 0;
            string = 1;
            Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(string), missingObjects$iv);
            androidx.compose.runtime.changelist.Operation.CopyNodesToNewAnchorLocation iNSTANCE3 = Operation.CopyNodesToNewAnchorLocation.INSTANCE;
            int i15 = 0;
            append = 0;
            Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(append), effectiveNodeIndex);
            if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects())) {
                i3 = Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects()) ? string : append;
            } else {
            }
            i7 = 0;
            if (i3 == 0) {
                this_$iv = 0;
                missingIntCount$iv = 0;
                StringBuilder stringBuilder3 = new StringBuilder();
                StringBuilder sb2 = stringBuilder3;
                int i17 = 0;
                i5 = string;
                i2 = append;
                intParamName-w8GmfQM = ", ";
                while (i2 < iNSTANCE.getInts()) {
                    i6 = i2;
                    i11 = 0;
                    if (i20 &= i9 != 0 && missingIntCount$iv > 0) {
                    }
                    i2++;
                    append = 0;
                    intParamName-w8GmfQM = ", ";
                    if (missingIntCount$iv > 0) {
                    }
                    sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i6)));
                    missingIntCount$iv++;
                    sb2.append(intParamName-w8GmfQM);
                }
                string = stringBuilder3.toString();
                String str2 = "StringBuilder().apply(builderAction).toString()";
                Intrinsics.checkNotNullExpressionValue(string, str2);
                stringBuilder = new StringBuilder();
                sb = stringBuilder;
                i6 = 0;
                objectParamName-31yXWZQ = iNSTANCE.getObjects();
                missingObjectCount$iv2 = i16;
                missingObjectCount$iv = 0;
                while (missingObjectCount$iv < objectParamName-31yXWZQ) {
                    i = missingObjectCount$iv;
                    i11 = 0;
                    if (i18 &= i9 != 0) {
                    } else {
                    }
                    i8 = objectParamName-31yXWZQ;
                    missingObjectCount$iv++;
                    objectParamName-31yXWZQ = i8;
                    if (missingIntCount$iv > 0) {
                    }
                    i8 = objectParamName-31yXWZQ;
                    sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i)));
                    missingObjectCount$iv2++;
                    sb.append(intParamName-w8GmfQM);
                }
                String string2 = stringBuilder.toString();
                Intrinsics.checkNotNullExpressionValue(string2, str2);
                StringBuilder stringBuilder2 = new StringBuilder();
                PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(missingObjectCount$iv2).append(" object arguments (").append(string2).append(").").toString());
            }
        } else {
            obj = effectiveNodeIndex;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushCopySlotTableToAnchorLocation(MovableContentState resolvedState, CompositionContext parentContext, MovableContentStateReference from, MovableContentStateReference to) {
        Object missingObjects$iv;
        String objectParamName-31yXWZQ;
        Object operations;
        int $this$push_u24lambda_u246_u24lambda_u245$iv;
        StringBuilder sb2;
        int $i$f$push;
        int i5;
        int i;
        int i11;
        int this_$iv2;
        int string;
        int str;
        int i8;
        int missingIntCount$iv;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        String $this$push_u24lambda_u246_u24lambda_u245$iv2;
        int i6;
        int i7;
        int i4;
        androidx.compose.runtime.changelist.Operations this_$iv;
        int i9;
        int i10;
        int i12;
        int i3;
        int i2;
        operations = missingObjects$iv.operations;
        final androidx.compose.runtime.changelist.Operation.CopySlotTableToAnchorLocation iNSTANCE = Operation.CopySlotTableToAnchorLocation.INSTANCE;
        $i$f$push = 0;
        operations.pushOp((Operation)iNSTANCE);
        androidx.compose.runtime.changelist.Operations constructor-impl3 = Operations.WriteScope.constructor-impl(operations);
        int i13 = 0;
        androidx.compose.runtime.changelist.Operation.CopySlotTableToAnchorLocation iNSTANCE2 = Operation.CopySlotTableToAnchorLocation.INSTANCE;
        int i15 = 0;
        string = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl3, Operation.ObjectParameter.constructor-impl(string), resolvedState);
        androidx.compose.runtime.changelist.Operation.CopySlotTableToAnchorLocation iNSTANCE3 = Operation.CopySlotTableToAnchorLocation.INSTANCE;
        int i16 = 0;
        str = 1;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl3, Operation.ObjectParameter.constructor-impl(str), parentContext);
        androidx.compose.runtime.changelist.Operation.CopySlotTableToAnchorLocation iNSTANCE4 = Operation.CopySlotTableToAnchorLocation.INSTANCE;
        int i17 = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl3, Operation.ObjectParameter.constructor-impl(3), to);
        androidx.compose.runtime.changelist.Operation.CopySlotTableToAnchorLocation iNSTANCE5 = Operation.CopySlotTableToAnchorLocation.INSTANCE;
        int i19 = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl3, Operation.ObjectParameter.constructor-impl(2), from);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects())) {
            i = Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects()) ? str : string;
        } else {
        }
        int i14 = 0;
        if (i == 0) {
            this_$iv2 = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb3 = stringBuilder3;
            int i21 = 0;
            i7 = str;
            i8 = 0;
            while (i8 < iNSTANCE.getInts()) {
                i4 = i8;
                i9 = 0;
                if (i22 &= i12 != 0 && missingIntCount$iv > 0) {
                }
                i8++;
                missingObjects$iv = this;
                if (missingIntCount$iv > 0) {
                }
                sb3.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i4)));
                missingIntCount$iv++;
                sb3.append(", ");
            }
            string = stringBuilder3.toString();
            String str2 = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str2);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i4 = 0;
            $this$push_u24lambda_u246_u24lambda_u245$iv = iNSTANCE.getObjects();
            i6 = $i$f$push;
            $i$f$push = i20;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < $this$push_u24lambda_u246_u24lambda_u245$iv) {
                i10 = missingObjectCount$iv;
                i12 = 0;
                if (i23 &= i2 != 0) {
                } else {
                }
                i3 = $this$push_u24lambda_u246_u24lambda_u245$iv;
                sb2 = sb;
                $this$push_u24lambda_u246_u24lambda_u245$iv2 = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = $this$push_u24lambda_u246_u24lambda_u245$iv2;
                sb = sb2;
                $this$push_u24lambda_u246_u24lambda_u245$iv = i3;
                if (missingIntCount$iv > 0) {
                } else {
                }
                i3 = $this$push_u24lambda_u246_u24lambda_u245$iv;
                sb2 = sb;
                $this$push_u24lambda_u246_u24lambda_u245$iv2 = objectParamName-31yXWZQ;
                sb2.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i10)));
                $i$f$push++;
                i3 = $this$push_u24lambda_u246_u24lambda_u245$iv;
                sb.append(objectParamName-31yXWZQ);
            }
            StringBuilder $this$push_u24lambda_u246_u24lambda_u245$iv3 = sb;
            String string2 = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string2, str2);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append($i$f$push).append(" object arguments (").append(string2).append(").").toString());
        } else {
            this_$iv = operations;
            i6 = $i$f$push;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushDeactivateCurrentGroup() {
        this.operations.push((Operation)Operation.DeactivateCurrentGroup.INSTANCE);
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushDetermineMovableContentNodeIndex(IntRef effectiveNodeIndexOut, Anchor anchor) {
        Object missingObjects$iv;
        int objectParamName-31yXWZQ;
        androidx.compose.runtime.changelist.Operations this_$iv;
        int i8;
        int i4;
        int i;
        int this_$iv2;
        int string;
        int append;
        String intParamName-w8GmfQM;
        int missingIntCount$iv;
        String str;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        androidx.compose.runtime.changelist.Operations this_$iv3;
        int i3;
        int i2;
        int i6;
        int i7;
        int i9;
        int i5;
        this_$iv = missingObjects$iv.operations;
        final androidx.compose.runtime.changelist.Operation.DetermineMovableContentNodeIndex iNSTANCE = Operation.DetermineMovableContentNodeIndex.INSTANCE;
        final int i10 = 0;
        this_$iv.pushOp((Operation)iNSTANCE);
        androidx.compose.runtime.changelist.Operations constructor-impl2 = Operations.WriteScope.constructor-impl(this_$iv);
        int i11 = 0;
        androidx.compose.runtime.changelist.Operation.DetermineMovableContentNodeIndex iNSTANCE2 = Operation.DetermineMovableContentNodeIndex.INSTANCE;
        int i13 = 0;
        string = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(string), effectiveNodeIndexOut);
        androidx.compose.runtime.changelist.Operation.DetermineMovableContentNodeIndex iNSTANCE3 = Operation.DetermineMovableContentNodeIndex.INSTANCE;
        int i14 = 0;
        append = 1;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(append), anchor);
        if (Operations.access$getPushedIntMask$p(this_$iv) == Operations.access$createExpectedArgMask(this_$iv, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(this_$iv) == Operations.access$createExpectedArgMask(this_$iv, iNSTANCE.getObjects())) {
            i4 = Operations.access$getPushedObjectMask$p(this_$iv) == Operations.access$createExpectedArgMask(this_$iv, iNSTANCE.getObjects()) ? append : string;
        } else {
        }
        int i12 = 0;
        if (i4 == 0) {
            this_$iv2 = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i16 = 0;
            i3 = append;
            intParamName-w8GmfQM = ", ";
            while (string < iNSTANCE.getInts()) {
                i2 = string;
                i6 = 0;
                if (i17 &= i9 != 0 && missingIntCount$iv > 0) {
                }
                string++;
                append = i3;
                i3 = append;
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
            this_$iv = i15;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < objectParamName-31yXWZQ) {
                i6 = missingObjectCount$iv;
                i7 = 0;
                if (i18 &= i5 != 0) {
                } else {
                }
                i9 = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = i9;
                if (missingIntCount$iv > 0) {
                }
                i9 = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i6)));
                this_$iv++;
                sb.append(intParamName-w8GmfQM);
            }
            String string2 = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string2, str2);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(this_$iv).append(" object arguments (").append(string2).append(").").toString());
        } else {
            this_$iv3 = this_$iv;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushDowns(Object[] nodes) {
        Object missingObjectCount$iv;
        int missingObjectCount$iv2;
        int objectParamName-31yXWZQ;
        int append;
        String intParamName-w8GmfQM;
        int str2;
        androidx.compose.runtime.changelist.Operations operations;
        androidx.compose.runtime.changelist.Operation.Downs iNSTANCE;
        int i10;
        int i4;
        int i;
        int i5;
        int i12;
        int this_$iv;
        int missingIntCount$iv;
        String string;
        String str;
        int missingObjectCount$iv3;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i3;
        int i6;
        int i9;
        int i2;
        int i7;
        int i11;
        int i8;
        missingObjectCount$iv = nodes;
        append = 0;
        str2 = 1;
        objectParamName-31yXWZQ = missingObjectCount$iv.length == 0 ? str2 : append;
        if (objectParamName-31yXWZQ == 0) {
            operations = objectParamName-31yXWZQ.operations;
            iNSTANCE = Operation.Downs.INSTANCE;
            i10 = 0;
            operations.pushOp((Operation)iNSTANCE);
            int i13 = 0;
            androidx.compose.runtime.changelist.Operation.Downs iNSTANCE2 = Operation.Downs.INSTANCE;
            missingIntCount$iv = 0;
            Operations.WriteScope.setObject-DKhxnng(Operations.WriteScope.constructor-impl(operations), Operation.ObjectParameter.constructor-impl(append), missingObjectCount$iv);
            if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects())) {
                i4 = Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects()) ? str2 : append;
            } else {
            }
            i5 = 0;
            if (i4 == 0) {
                this_$iv = 0;
                missingIntCount$iv = 0;
                StringBuilder stringBuilder3 = new StringBuilder();
                StringBuilder sb2 = stringBuilder3;
                int i14 = 0;
                i3 = append;
                intParamName-w8GmfQM = ", ";
                while (i3 < iNSTANCE.getInts()) {
                    i9 = i3;
                    i2 = 0;
                    if (i16 &= i11 != 0 && missingIntCount$iv > 0) {
                    }
                    i3++;
                    append = 0;
                    intParamName-w8GmfQM = ", ";
                    if (missingIntCount$iv > 0) {
                    }
                    sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i9)));
                    missingIntCount$iv++;
                    sb2.append(intParamName-w8GmfQM);
                }
                string = stringBuilder3.toString();
                str = "StringBuilder().apply(builderAction).toString()";
                Intrinsics.checkNotNullExpressionValue(string, str);
                stringBuilder = new StringBuilder();
                sb = stringBuilder;
                i9 = 0;
                missingObjectCount$iv2 = i15;
                missingObjectCount$iv3 = 0;
                while (missingObjectCount$iv3 < iNSTANCE.getObjects()) {
                    i6 = missingObjectCount$iv3;
                    i7 = 0;
                    if (i17 &= i8 != 0 && missingIntCount$iv > 0) {
                    }
                    missingObjectCount$iv3++;
                    objectParamName-31yXWZQ = this;
                    if (missingIntCount$iv > 0) {
                    }
                    sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i6)));
                    missingObjectCount$iv2++;
                    sb.append(intParamName-w8GmfQM);
                }
                objectParamName-31yXWZQ = stringBuilder.toString();
                Intrinsics.checkNotNullExpressionValue(objectParamName-31yXWZQ, str);
                StringBuilder stringBuilder2 = new StringBuilder();
                PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(missingObjectCount$iv2).append(" object arguments (").append(objectParamName-31yXWZQ).append(").").toString());
            }
        }
    }

    public final void pushEndCompositionScope(Function1<? super Composition, Unit> action, Composition composition) {
        Object missingObjects$iv;
        int objectParamName-31yXWZQ;
        androidx.compose.runtime.changelist.Operations this_$iv3;
        int i4;
        int i5;
        int i6;
        int this_$iv2;
        int string;
        int append;
        String intParamName-w8GmfQM;
        int missingIntCount$iv;
        String str;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        androidx.compose.runtime.changelist.Operations this_$iv;
        int i3;
        int i2;
        int i;
        int i7;
        int i9;
        int i8;
        this_$iv3 = missingObjects$iv.operations;
        final androidx.compose.runtime.changelist.Operation.EndCompositionScope iNSTANCE = Operation.EndCompositionScope.INSTANCE;
        final int i10 = 0;
        this_$iv3.pushOp((Operation)iNSTANCE);
        androidx.compose.runtime.changelist.Operations constructor-impl2 = Operations.WriteScope.constructor-impl(this_$iv3);
        int i11 = 0;
        androidx.compose.runtime.changelist.Operation.EndCompositionScope iNSTANCE2 = Operation.EndCompositionScope.INSTANCE;
        int i13 = 0;
        string = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(string), action);
        androidx.compose.runtime.changelist.Operation.EndCompositionScope iNSTANCE3 = Operation.EndCompositionScope.INSTANCE;
        int i14 = 0;
        append = 1;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(append), composition);
        if (Operations.access$getPushedIntMask$p(this_$iv3) == Operations.access$createExpectedArgMask(this_$iv3, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(this_$iv3) == Operations.access$createExpectedArgMask(this_$iv3, iNSTANCE.getObjects())) {
            i5 = Operations.access$getPushedObjectMask$p(this_$iv3) == Operations.access$createExpectedArgMask(this_$iv3, iNSTANCE.getObjects()) ? append : string;
        } else {
        }
        int i12 = 0;
        if (i5 == 0) {
            this_$iv2 = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i16 = 0;
            i3 = append;
            intParamName-w8GmfQM = ", ";
            while (string < iNSTANCE.getInts()) {
                i2 = string;
                i = 0;
                if (i17 &= i9 != 0 && missingIntCount$iv > 0) {
                }
                string++;
                append = i3;
                i3 = append;
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
            this_$iv3 = i15;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < objectParamName-31yXWZQ) {
                i = missingObjectCount$iv;
                i7 = 0;
                if (i18 &= i8 != 0) {
                } else {
                }
                i9 = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = i9;
                if (missingIntCount$iv > 0) {
                }
                i9 = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i)));
                this_$iv3++;
                sb.append(intParamName-w8GmfQM);
            }
            String string2 = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string2, str2);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(this_$iv3).append(" object arguments (").append(string2).append(").").toString());
        } else {
            this_$iv = this_$iv3;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushEndCurrentGroup() {
        this.operations.push((Operation)Operation.EndCurrentGroup.INSTANCE);
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushEndMovableContentPlacement() {
        this.operations.push((Operation)Operation.EndMovableContentPlacement.INSTANCE);
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushEnsureGroupStarted(Anchor anchor) {
        Object missingObjectCount$iv;
        int missingObjectCount$iv2;
        Object objectParamName-31yXWZQ;
        int i10;
        int i7;
        int i2;
        int this_$iv3;
        int str;
        int i3;
        int missingIntCount$iv;
        String string;
        String str2;
        int missingObjectCount$iv3;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i4;
        int i;
        int i5;
        int i8;
        int i6;
        androidx.compose.runtime.changelist.Operations this_$iv2;
        int this_$iv;
        int i9;
        objectParamName-31yXWZQ = missingObjectCount$iv.operations;
        final androidx.compose.runtime.changelist.Operation.EnsureGroupStarted iNSTANCE = Operation.EnsureGroupStarted.INSTANCE;
        final int i11 = 0;
        objectParamName-31yXWZQ.pushOp((Operation)iNSTANCE);
        int i12 = 0;
        androidx.compose.runtime.changelist.Operation.EnsureGroupStarted iNSTANCE2 = Operation.EnsureGroupStarted.INSTANCE;
        int i14 = 0;
        str = 0;
        Operations.WriteScope.setObject-DKhxnng(Operations.WriteScope.constructor-impl(objectParamName-31yXWZQ), Operation.ObjectParameter.constructor-impl(str), anchor);
        if (Operations.access$getPushedIntMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects())) {
            i7 = Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects()) ? 1 : str;
        } else {
        }
        int i13 = 0;
        if (i7 == 0) {
            i3 = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i15 = 0;
            i4 = str;
            i = 1;
            this_$iv3 = ", ";
            while (i4 < iNSTANCE.getInts()) {
                i5 = i4;
                i8 = 0;
                if (i17 &= this_$iv != 0 && missingIntCount$iv > 0) {
                }
                i4++;
                i = 1;
                this_$iv3 = ", ";
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i5)));
                missingIntCount$iv++;
                sb2.append(this_$iv3);
            }
            string = stringBuilder3.toString();
            str2 = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str2);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i5 = 0;
            missingObjectCount$iv2 = i16;
            missingObjectCount$iv3 = 0;
            while (missingObjectCount$iv3 < iNSTANCE.getObjects()) {
                i8 = missingObjectCount$iv3;
                i6 = 0;
                if (i18 &= i9 != 0) {
                } else {
                }
                this_$iv = objectParamName-31yXWZQ;
                missingObjectCount$iv3++;
                objectParamName-31yXWZQ = this_$iv;
                if (missingIntCount$iv > 0) {
                }
                this_$iv = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i8)));
                missingObjectCount$iv2++;
                sb.append(this_$iv3);
            }
            this_$iv2 = objectParamName-31yXWZQ;
            objectParamName-31yXWZQ = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(objectParamName-31yXWZQ, str2);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(missingObjectCount$iv2).append(" object arguments (").append(objectParamName-31yXWZQ).append(").").toString());
        } else {
            this_$iv2 = objectParamName-31yXWZQ;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushEnsureRootStarted() {
        this.operations.push((Operation)Operation.EnsureRootGroupStarted.INSTANCE);
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushExecuteOperationsIn(androidx.compose.runtime.changelist.ChangeList changeList, IntRef effectiveNodeIndex) {
        Object missingObjects$iv;
        int objectParamName-31yXWZQ;
        androidx.compose.runtime.changelist.Operations this_$iv3;
        androidx.compose.runtime.changelist.Operation.ApplyChangeList iNSTANCE;
        int i4;
        int i6;
        int i11;
        int i5;
        int i;
        int this_$iv;
        Object obj;
        int string;
        Object obj2;
        int append;
        String intParamName-w8GmfQM;
        int missingIntCount$iv;
        String str;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        androidx.compose.runtime.changelist.Operations this_$iv2;
        int i8;
        int i2;
        int i7;
        int i9;
        int i3;
        int i10;
        if (changeList.isNotEmpty()) {
            this_$iv3 = missingObjects$iv.operations;
            iNSTANCE = Operation.ApplyChangeList.INSTANCE;
            i4 = 0;
            this_$iv3.pushOp((Operation)iNSTANCE);
            androidx.compose.runtime.changelist.Operations constructor-impl2 = Operations.WriteScope.constructor-impl(this_$iv3);
            int i12 = 0;
            androidx.compose.runtime.changelist.Operation.ApplyChangeList iNSTANCE2 = Operation.ApplyChangeList.INSTANCE;
            int i13 = 0;
            string = 0;
            Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(string), changeList);
            androidx.compose.runtime.changelist.Operation.ApplyChangeList iNSTANCE3 = Operation.ApplyChangeList.INSTANCE;
            int i14 = 0;
            append = 1;
            Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(append), effectiveNodeIndex);
            if (Operations.access$getPushedIntMask$p(this_$iv3) == Operations.access$createExpectedArgMask(this_$iv3, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(this_$iv3) == Operations.access$createExpectedArgMask(this_$iv3, iNSTANCE.getObjects())) {
                i6 = Operations.access$getPushedObjectMask$p(this_$iv3) == Operations.access$createExpectedArgMask(this_$iv3, iNSTANCE.getObjects()) ? append : string;
            } else {
            }
            i5 = 0;
            if (i6 == 0) {
                this_$iv = 0;
                missingIntCount$iv = 0;
                StringBuilder stringBuilder3 = new StringBuilder();
                StringBuilder sb2 = stringBuilder3;
                int i16 = 0;
                i8 = append;
                intParamName-w8GmfQM = ", ";
                while (string < iNSTANCE.getInts()) {
                    i2 = string;
                    i7 = 0;
                    if (i17 &= i3 != 0 && missingIntCount$iv > 0) {
                    }
                    string++;
                    append = i8;
                    i8 = append;
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
                this_$iv3 = i15;
                missingObjectCount$iv = 0;
                while (missingObjectCount$iv < objectParamName-31yXWZQ) {
                    i7 = missingObjectCount$iv;
                    i9 = 0;
                    if (i18 &= i10 != 0) {
                    } else {
                    }
                    i3 = objectParamName-31yXWZQ;
                    missingObjectCount$iv++;
                    objectParamName-31yXWZQ = i3;
                    if (missingIntCount$iv > 0) {
                    }
                    i3 = objectParamName-31yXWZQ;
                    sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i7)));
                    this_$iv3++;
                    sb.append(intParamName-w8GmfQM);
                }
                String string2 = stringBuilder.toString();
                Intrinsics.checkNotNullExpressionValue(string2, str2);
                StringBuilder stringBuilder2 = new StringBuilder();
                PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(this_$iv3).append(" object arguments (").append(string2).append(").").toString());
            } else {
                this_$iv2 = this_$iv3;
            }
        } else {
            obj = changeList;
            obj2 = effectiveNodeIndex;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushInsertSlots(Anchor anchor, SlotTable from) {
        Object missingObjects$iv;
        int objectParamName-31yXWZQ;
        androidx.compose.runtime.changelist.Operations this_$iv3;
        int i5;
        int i7;
        int i6;
        int this_$iv;
        int string;
        int append;
        String intParamName-w8GmfQM;
        int missingIntCount$iv;
        String str;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        androidx.compose.runtime.changelist.Operations this_$iv2;
        int i8;
        int i3;
        int i9;
        int i2;
        int i;
        int i4;
        this_$iv3 = missingObjects$iv.operations;
        final androidx.compose.runtime.changelist.Operation.InsertSlots iNSTANCE = Operation.InsertSlots.INSTANCE;
        final int i10 = 0;
        this_$iv3.pushOp((Operation)iNSTANCE);
        androidx.compose.runtime.changelist.Operations constructor-impl2 = Operations.WriteScope.constructor-impl(this_$iv3);
        int i11 = 0;
        androidx.compose.runtime.changelist.Operation.InsertSlots iNSTANCE2 = Operation.InsertSlots.INSTANCE;
        int i13 = 0;
        string = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(string), anchor);
        androidx.compose.runtime.changelist.Operation.InsertSlots iNSTANCE3 = Operation.InsertSlots.INSTANCE;
        int i14 = 0;
        append = 1;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(append), from);
        if (Operations.access$getPushedIntMask$p(this_$iv3) == Operations.access$createExpectedArgMask(this_$iv3, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(this_$iv3) == Operations.access$createExpectedArgMask(this_$iv3, iNSTANCE.getObjects())) {
            i7 = Operations.access$getPushedObjectMask$p(this_$iv3) == Operations.access$createExpectedArgMask(this_$iv3, iNSTANCE.getObjects()) ? append : string;
        } else {
        }
        int i12 = 0;
        if (i7 == 0) {
            this_$iv = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i16 = 0;
            i8 = append;
            intParamName-w8GmfQM = ", ";
            while (string < iNSTANCE.getInts()) {
                i3 = string;
                i9 = 0;
                if (i17 &= i != 0 && missingIntCount$iv > 0) {
                }
                string++;
                append = i8;
                i8 = append;
                intParamName-w8GmfQM = ", ";
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i3)));
                missingIntCount$iv++;
                sb2.append(intParamName-w8GmfQM);
            }
            string = stringBuilder3.toString();
            String str2 = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str2);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i3 = 0;
            objectParamName-31yXWZQ = iNSTANCE.getObjects();
            this_$iv3 = i15;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < objectParamName-31yXWZQ) {
                i9 = missingObjectCount$iv;
                i2 = 0;
                if (i18 &= i4 != 0) {
                } else {
                }
                i = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = i;
                if (missingIntCount$iv > 0) {
                }
                i = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i9)));
                this_$iv3++;
                sb.append(intParamName-w8GmfQM);
            }
            String string2 = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string2, str2);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(this_$iv3).append(" object arguments (").append(string2).append(").").toString());
        } else {
            this_$iv2 = this_$iv3;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushInsertSlots(Anchor anchor, SlotTable from, androidx.compose.runtime.changelist.FixupList fixups) {
        Object missingObjects$iv;
        String objectParamName-31yXWZQ;
        Object operations;
        int $i$f$push;
        int i8;
        int i4;
        int i7;
        int this_$iv;
        int string;
        int str;
        int i3;
        int missingIntCount$iv;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i;
        int i2;
        int i9;
        androidx.compose.runtime.changelist.Operations this_$iv2;
        int i5;
        int i10;
        int i11;
        String str2;
        int i6;
        operations = missingObjects$iv.operations;
        final androidx.compose.runtime.changelist.Operation.InsertSlotsWithFixups iNSTANCE = Operation.InsertSlotsWithFixups.INSTANCE;
        $i$f$push = 0;
        operations.pushOp((Operation)iNSTANCE);
        androidx.compose.runtime.changelist.Operations constructor-impl3 = Operations.WriteScope.constructor-impl(operations);
        int i12 = 0;
        androidx.compose.runtime.changelist.Operation.InsertSlotsWithFixups iNSTANCE2 = Operation.InsertSlotsWithFixups.INSTANCE;
        int i14 = 0;
        string = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl3, Operation.ObjectParameter.constructor-impl(string), anchor);
        androidx.compose.runtime.changelist.Operation.InsertSlotsWithFixups iNSTANCE3 = Operation.InsertSlotsWithFixups.INSTANCE;
        int i15 = 0;
        str = 1;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl3, Operation.ObjectParameter.constructor-impl(str), from);
        androidx.compose.runtime.changelist.Operation.InsertSlotsWithFixups iNSTANCE4 = Operation.InsertSlotsWithFixups.INSTANCE;
        int i16 = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl3, Operation.ObjectParameter.constructor-impl(2), fixups);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects())) {
            i4 = Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects()) ? str : string;
        } else {
        }
        int i13 = 0;
        if (i4 == 0) {
            this_$iv = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i18 = 0;
            i2 = str;
            i3 = 0;
            while (i3 < iNSTANCE.getInts()) {
                i9 = i3;
                i5 = 0;
                if (i19 &= i11 != 0 && missingIntCount$iv > 0) {
                }
                i3++;
                missingObjects$iv = this;
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i9)));
                missingIntCount$iv++;
                sb2.append(", ");
            }
            string = stringBuilder3.toString();
            String str3 = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str3);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i9 = 0;
            i = $i$f$push;
            $i$f$push = i17;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < iNSTANCE.getObjects()) {
                i10 = missingObjectCount$iv;
                i11 = 0;
                if (i20 &= i6 != 0) {
                } else {
                }
                str2 = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = str2;
                if (missingIntCount$iv > 0) {
                }
                str2 = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i10)));
                $i$f$push++;
                sb.append(objectParamName-31yXWZQ);
            }
            String string2 = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string2, str3);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append($i$f$push).append(" object arguments (").append(string2).append(").").toString());
        } else {
            this_$iv2 = operations;
            i = $i$f$push;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushMoveCurrentGroup(int offset) {
        Object missingObjectCount$iv3;
        int missingObjectCount$iv2;
        Object objectParamName-31yXWZQ;
        int i8;
        int i6;
        int i3;
        int this_$iv3;
        int str;
        int i4;
        int missingIntCount$iv;
        String string;
        String str2;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i10;
        int i5;
        int i9;
        int i2;
        int i;
        androidx.compose.runtime.changelist.Operations this_$iv;
        int this_$iv2;
        int i7;
        objectParamName-31yXWZQ = missingObjectCount$iv3.operations;
        final androidx.compose.runtime.changelist.Operation.MoveCurrentGroup iNSTANCE = Operation.MoveCurrentGroup.INSTANCE;
        final int i11 = 0;
        objectParamName-31yXWZQ.pushOp((Operation)iNSTANCE);
        int i12 = 0;
        androidx.compose.runtime.changelist.Operation.MoveCurrentGroup iNSTANCE2 = Operation.MoveCurrentGroup.INSTANCE;
        int i14 = 0;
        str = 0;
        Operations.WriteScope.setInt-A6tL2VI(Operations.WriteScope.constructor-impl(objectParamName-31yXWZQ), Operation.IntParameter.constructor-impl(str), offset);
        if (Operations.access$getPushedIntMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects())) {
            i6 = Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects()) ? 1 : str;
        } else {
        }
        int i13 = 0;
        if (i6 == 0) {
            i4 = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i16 = 0;
            i10 = str;
            i5 = 1;
            this_$iv3 = ", ";
            while (i10 < iNSTANCE.getInts()) {
                i9 = i10;
                i2 = 0;
                if (i18 &= this_$iv2 != 0 && missingIntCount$iv > 0) {
                }
                i10++;
                i5 = 1;
                this_$iv3 = ", ";
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i9)));
                missingIntCount$iv++;
                sb2.append(this_$iv3);
            }
            string = stringBuilder3.toString();
            str2 = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str2);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i9 = 0;
            missingObjectCount$iv2 = i17;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < iNSTANCE.getObjects()) {
                i2 = missingObjectCount$iv;
                i = 0;
                if (i19 &= i7 != 0) {
                } else {
                }
                this_$iv2 = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = this_$iv2;
                if (missingIntCount$iv > 0) {
                }
                this_$iv2 = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i2)));
                missingObjectCount$iv2++;
                sb.append(this_$iv3);
            }
            this_$iv = objectParamName-31yXWZQ;
            objectParamName-31yXWZQ = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(objectParamName-31yXWZQ, str2);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(missingObjectCount$iv2).append(" object arguments (").append(objectParamName-31yXWZQ).append(").").toString());
        } else {
            this_$iv = objectParamName-31yXWZQ;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushMoveNode(int to, int from, int count) {
        Object missingObjects$iv;
        String objectParamName-31yXWZQ;
        Object operations;
        int $i$f$push;
        int i10;
        int i7;
        int i6;
        int this_$iv2;
        int string;
        int str2;
        int missingIntCount$iv;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i3;
        int i5;
        int i8;
        androidx.compose.runtime.changelist.Operations this_$iv;
        int i;
        int i2;
        int i4;
        String str;
        int i9;
        operations = missingObjects$iv.operations;
        final androidx.compose.runtime.changelist.Operation.MoveNode iNSTANCE = Operation.MoveNode.INSTANCE;
        $i$f$push = 0;
        operations.pushOp((Operation)iNSTANCE);
        androidx.compose.runtime.changelist.Operations constructor-impl3 = Operations.WriteScope.constructor-impl(operations);
        int i11 = 0;
        androidx.compose.runtime.changelist.Operation.MoveNode iNSTANCE2 = Operation.MoveNode.INSTANCE;
        int i13 = 0;
        string = 1;
        Operations.WriteScope.setInt-A6tL2VI(constructor-impl3, Operation.IntParameter.constructor-impl(string), to);
        androidx.compose.runtime.changelist.Operation.MoveNode iNSTANCE3 = Operation.MoveNode.INSTANCE;
        int i15 = 0;
        str2 = 0;
        Operations.WriteScope.setInt-A6tL2VI(constructor-impl3, Operation.IntParameter.constructor-impl(str2), from);
        androidx.compose.runtime.changelist.Operation.MoveNode iNSTANCE4 = Operation.MoveNode.INSTANCE;
        int i17 = 0;
        Operations.WriteScope.setInt-A6tL2VI(constructor-impl3, Operation.IntParameter.constructor-impl(2), count);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects())) {
            i7 = Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects()) ? string : str2;
        } else {
        }
        int i12 = 0;
        if (i7 == 0) {
            this_$iv2 = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i20 = 0;
            i3 = string;
            while (str2 < iNSTANCE.getInts()) {
                i8 = str2;
                i = 0;
                if (i21 &= i4 != 0 && missingIntCount$iv > 0) {
                }
                str2++;
                missingObjects$iv = this;
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i8)));
                missingIntCount$iv++;
                sb2.append(", ");
            }
            string = stringBuilder3.toString();
            String str3 = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str3);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i8 = 0;
            i5 = $i$f$push;
            $i$f$push = i19;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < iNSTANCE.getObjects()) {
                i2 = missingObjectCount$iv;
                i4 = 0;
                if (i22 &= i9 != 0) {
                } else {
                }
                str = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = str;
                if (missingIntCount$iv > 0) {
                }
                str = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i2)));
                $i$f$push++;
                sb.append(objectParamName-31yXWZQ);
            }
            String string2 = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string2, str3);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append($i$f$push).append(" object arguments (").append(string2).append(").").toString());
        } else {
            this_$iv = operations;
            i5 = $i$f$push;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushReleaseMovableGroupAtCurrent(ControlledComposition composition, CompositionContext parentContext, MovableContentStateReference reference) {
        Object missingObjects$iv;
        String objectParamName-31yXWZQ;
        Object operations;
        int $i$f$push;
        int i;
        int i7;
        int i2;
        int this_$iv;
        int string;
        int str2;
        int i3;
        int missingIntCount$iv;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i10;
        int i11;
        int i4;
        androidx.compose.runtime.changelist.Operations this_$iv2;
        int i5;
        int i8;
        int i9;
        String str;
        int i6;
        operations = missingObjects$iv.operations;
        final androidx.compose.runtime.changelist.Operation.ReleaseMovableGroupAtCurrent iNSTANCE = Operation.ReleaseMovableGroupAtCurrent.INSTANCE;
        $i$f$push = 0;
        operations.pushOp((Operation)iNSTANCE);
        androidx.compose.runtime.changelist.Operations constructor-impl3 = Operations.WriteScope.constructor-impl(operations);
        int i12 = 0;
        androidx.compose.runtime.changelist.Operation.ReleaseMovableGroupAtCurrent iNSTANCE2 = Operation.ReleaseMovableGroupAtCurrent.INSTANCE;
        int i14 = 0;
        string = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl3, Operation.ObjectParameter.constructor-impl(string), composition);
        androidx.compose.runtime.changelist.Operation.ReleaseMovableGroupAtCurrent iNSTANCE3 = Operation.ReleaseMovableGroupAtCurrent.INSTANCE;
        int i15 = 0;
        str2 = 1;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl3, Operation.ObjectParameter.constructor-impl(str2), parentContext);
        androidx.compose.runtime.changelist.Operation.ReleaseMovableGroupAtCurrent iNSTANCE4 = Operation.ReleaseMovableGroupAtCurrent.INSTANCE;
        int i16 = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl3, Operation.ObjectParameter.constructor-impl(2), reference);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects())) {
            i7 = Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects()) ? str2 : string;
        } else {
        }
        int i13 = 0;
        if (i7 == 0) {
            this_$iv = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i18 = 0;
            i11 = str2;
            i3 = 0;
            while (i3 < iNSTANCE.getInts()) {
                i4 = i3;
                i5 = 0;
                if (i19 &= i9 != 0 && missingIntCount$iv > 0) {
                }
                i3++;
                missingObjects$iv = this;
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i4)));
                missingIntCount$iv++;
                sb2.append(", ");
            }
            string = stringBuilder3.toString();
            String str3 = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str3);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i4 = 0;
            i10 = $i$f$push;
            $i$f$push = i17;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < iNSTANCE.getObjects()) {
                i8 = missingObjectCount$iv;
                i9 = 0;
                if (i20 &= i6 != 0) {
                } else {
                }
                str = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = str;
                if (missingIntCount$iv > 0) {
                }
                str = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i8)));
                $i$f$push++;
                sb.append(objectParamName-31yXWZQ);
            }
            String string2 = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string2, str3);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append($i$f$push).append(" object arguments (").append(string2).append(").").toString());
        } else {
            this_$iv2 = operations;
            i10 = $i$f$push;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushRemember(RememberObserver value) {
        Object missingObjectCount$iv;
        int missingObjectCount$iv2;
        Object objectParamName-31yXWZQ;
        int i;
        int i4;
        int i9;
        int this_$iv2;
        int str;
        int i2;
        int missingIntCount$iv;
        String string;
        String str2;
        int missingObjectCount$iv3;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i10;
        int i5;
        int i6;
        int i8;
        int i3;
        androidx.compose.runtime.changelist.Operations this_$iv;
        int this_$iv3;
        int i7;
        objectParamName-31yXWZQ = missingObjectCount$iv.operations;
        final androidx.compose.runtime.changelist.Operation.Remember iNSTANCE = Operation.Remember.INSTANCE;
        final int i11 = 0;
        objectParamName-31yXWZQ.pushOp((Operation)iNSTANCE);
        int i12 = 0;
        androidx.compose.runtime.changelist.Operation.Remember iNSTANCE2 = Operation.Remember.INSTANCE;
        int i14 = 0;
        str = 0;
        Operations.WriteScope.setObject-DKhxnng(Operations.WriteScope.constructor-impl(objectParamName-31yXWZQ), Operation.ObjectParameter.constructor-impl(str), value);
        if (Operations.access$getPushedIntMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects())) {
            i4 = Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects()) ? 1 : str;
        } else {
        }
        int i13 = 0;
        if (i4 == 0) {
            i2 = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i15 = 0;
            i10 = str;
            i5 = 1;
            this_$iv2 = ", ";
            while (i10 < iNSTANCE.getInts()) {
                i6 = i10;
                i8 = 0;
                if (i17 &= this_$iv3 != 0 && missingIntCount$iv > 0) {
                }
                i10++;
                i5 = 1;
                this_$iv2 = ", ";
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i6)));
                missingIntCount$iv++;
                sb2.append(this_$iv2);
            }
            string = stringBuilder3.toString();
            str2 = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str2);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i6 = 0;
            missingObjectCount$iv2 = i16;
            missingObjectCount$iv3 = 0;
            while (missingObjectCount$iv3 < iNSTANCE.getObjects()) {
                i8 = missingObjectCount$iv3;
                i3 = 0;
                if (i18 &= i7 != 0) {
                } else {
                }
                this_$iv3 = objectParamName-31yXWZQ;
                missingObjectCount$iv3++;
                objectParamName-31yXWZQ = this_$iv3;
                if (missingIntCount$iv > 0) {
                }
                this_$iv3 = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i8)));
                missingObjectCount$iv2++;
                sb.append(this_$iv2);
            }
            this_$iv = objectParamName-31yXWZQ;
            objectParamName-31yXWZQ = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(objectParamName-31yXWZQ, str2);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(missingObjectCount$iv2).append(" object arguments (").append(objectParamName-31yXWZQ).append(").").toString());
        } else {
            this_$iv = objectParamName-31yXWZQ;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushRemoveCurrentGroup() {
        this.operations.push((Operation)Operation.RemoveCurrentGroup.INSTANCE);
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushRemoveNode(int removeFrom, int moveCount) {
        Object missingObjects$iv;
        int objectParamName-31yXWZQ;
        androidx.compose.runtime.changelist.Operations this_$iv;
        int i5;
        int i4;
        int i;
        int this_$iv2;
        int string;
        int append;
        String intParamName-w8GmfQM;
        int missingIntCount$iv;
        String str;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        androidx.compose.runtime.changelist.Operations this_$iv3;
        int i9;
        int i2;
        int i6;
        int i8;
        int i3;
        int i7;
        this_$iv = missingObjects$iv.operations;
        final androidx.compose.runtime.changelist.Operation.RemoveNode iNSTANCE = Operation.RemoveNode.INSTANCE;
        final int i10 = 0;
        this_$iv.pushOp((Operation)iNSTANCE);
        androidx.compose.runtime.changelist.Operations constructor-impl2 = Operations.WriteScope.constructor-impl(this_$iv);
        int i11 = 0;
        androidx.compose.runtime.changelist.Operation.RemoveNode iNSTANCE2 = Operation.RemoveNode.INSTANCE;
        int i13 = 0;
        string = 0;
        Operations.WriteScope.setInt-A6tL2VI(constructor-impl2, Operation.IntParameter.constructor-impl(string), removeFrom);
        androidx.compose.runtime.changelist.Operation.RemoveNode iNSTANCE3 = Operation.RemoveNode.INSTANCE;
        int i15 = 0;
        append = 1;
        Operations.WriteScope.setInt-A6tL2VI(constructor-impl2, Operation.IntParameter.constructor-impl(append), moveCount);
        if (Operations.access$getPushedIntMask$p(this_$iv) == Operations.access$createExpectedArgMask(this_$iv, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(this_$iv) == Operations.access$createExpectedArgMask(this_$iv, iNSTANCE.getObjects())) {
            i4 = Operations.access$getPushedObjectMask$p(this_$iv) == Operations.access$createExpectedArgMask(this_$iv, iNSTANCE.getObjects()) ? append : string;
        } else {
        }
        int i12 = 0;
        if (i4 == 0) {
            this_$iv2 = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i18 = 0;
            i9 = append;
            intParamName-w8GmfQM = ", ";
            while (string < iNSTANCE.getInts()) {
                i2 = string;
                i6 = 0;
                if (i19 &= i3 != 0 && missingIntCount$iv > 0) {
                }
                string++;
                append = i9;
                i9 = append;
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
            this_$iv = i17;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < objectParamName-31yXWZQ) {
                i6 = missingObjectCount$iv;
                i8 = 0;
                if (i20 &= i7 != 0) {
                } else {
                }
                i3 = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = i3;
                if (missingIntCount$iv > 0) {
                }
                i3 = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i6)));
                this_$iv++;
                sb.append(intParamName-w8GmfQM);
            }
            String string2 = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string2, str2);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(this_$iv).append(" object arguments (").append(string2).append(").").toString());
        } else {
            this_$iv3 = this_$iv;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushResetSlots() {
        this.operations.push((Operation)Operation.ResetSlots.INSTANCE);
    }

    public final void pushSideEffect(Function0<Unit> effect) {
        Object missingObjectCount$iv;
        int missingObjectCount$iv3;
        Object objectParamName-31yXWZQ;
        int i7;
        int i8;
        int i2;
        int this_$iv2;
        int str2;
        int i3;
        int missingIntCount$iv;
        String string;
        String str;
        int missingObjectCount$iv2;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i5;
        int i9;
        int i4;
        int i6;
        int i10;
        androidx.compose.runtime.changelist.Operations this_$iv;
        int this_$iv3;
        int i;
        objectParamName-31yXWZQ = missingObjectCount$iv.operations;
        final androidx.compose.runtime.changelist.Operation.SideEffect iNSTANCE = Operation.SideEffect.INSTANCE;
        final int i11 = 0;
        objectParamName-31yXWZQ.pushOp((Operation)iNSTANCE);
        int i12 = 0;
        androidx.compose.runtime.changelist.Operation.SideEffect iNSTANCE2 = Operation.SideEffect.INSTANCE;
        int i14 = 0;
        str2 = 0;
        Operations.WriteScope.setObject-DKhxnng(Operations.WriteScope.constructor-impl(objectParamName-31yXWZQ), Operation.ObjectParameter.constructor-impl(str2), effect);
        if (Operations.access$getPushedIntMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects())) {
            i8 = Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects()) ? 1 : str2;
        } else {
        }
        int i13 = 0;
        if (i8 == 0) {
            i3 = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i15 = 0;
            i5 = str2;
            i9 = 1;
            this_$iv2 = ", ";
            while (i5 < iNSTANCE.getInts()) {
                i4 = i5;
                i6 = 0;
                if (i17 &= this_$iv3 != 0 && missingIntCount$iv > 0) {
                }
                i5++;
                i9 = 1;
                this_$iv2 = ", ";
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i4)));
                missingIntCount$iv++;
                sb2.append(this_$iv2);
            }
            string = stringBuilder3.toString();
            str = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i4 = 0;
            missingObjectCount$iv3 = i16;
            missingObjectCount$iv2 = 0;
            while (missingObjectCount$iv2 < iNSTANCE.getObjects()) {
                i6 = missingObjectCount$iv2;
                i10 = 0;
                if (i18 &= i != 0) {
                } else {
                }
                this_$iv3 = objectParamName-31yXWZQ;
                missingObjectCount$iv2++;
                objectParamName-31yXWZQ = this_$iv3;
                if (missingIntCount$iv > 0) {
                }
                this_$iv3 = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i6)));
                missingObjectCount$iv3++;
                sb.append(this_$iv2);
            }
            this_$iv = objectParamName-31yXWZQ;
            objectParamName-31yXWZQ = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(objectParamName-31yXWZQ, str);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(missingObjectCount$iv3).append(" object arguments (").append(objectParamName-31yXWZQ).append(").").toString());
        } else {
            this_$iv = objectParamName-31yXWZQ;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushSkipToEndOfCurrentGroup() {
        this.operations.push((Operation)Operation.SkipToEndOfCurrentGroup.INSTANCE);
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushTrimValues(int count) {
        Object missingObjectCount$iv3;
        int missingObjectCount$iv2;
        Object objectParamName-31yXWZQ;
        int i9;
        int i;
        int i2;
        int this_$iv3;
        int str2;
        int i4;
        int missingIntCount$iv;
        String string;
        String str;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i5;
        int i6;
        int i8;
        int i7;
        int i10;
        androidx.compose.runtime.changelist.Operations this_$iv;
        int this_$iv2;
        int i3;
        objectParamName-31yXWZQ = missingObjectCount$iv3.operations;
        final androidx.compose.runtime.changelist.Operation.TrimParentValues iNSTANCE = Operation.TrimParentValues.INSTANCE;
        final int i11 = 0;
        objectParamName-31yXWZQ.pushOp((Operation)iNSTANCE);
        int i12 = 0;
        androidx.compose.runtime.changelist.Operation.TrimParentValues iNSTANCE2 = Operation.TrimParentValues.INSTANCE;
        int i14 = 0;
        str2 = 0;
        Operations.WriteScope.setInt-A6tL2VI(Operations.WriteScope.constructor-impl(objectParamName-31yXWZQ), Operation.IntParameter.constructor-impl(str2), count);
        if (Operations.access$getPushedIntMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects())) {
            i = Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects()) ? 1 : str2;
        } else {
        }
        int i13 = 0;
        if (i == 0) {
            i4 = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i16 = 0;
            i5 = str2;
            i6 = 1;
            this_$iv3 = ", ";
            while (i5 < iNSTANCE.getInts()) {
                i8 = i5;
                i7 = 0;
                if (i18 &= this_$iv2 != 0 && missingIntCount$iv > 0) {
                }
                i5++;
                i6 = 1;
                this_$iv3 = ", ";
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i8)));
                missingIntCount$iv++;
                sb2.append(this_$iv3);
            }
            string = stringBuilder3.toString();
            str = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i8 = 0;
            missingObjectCount$iv2 = i17;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < iNSTANCE.getObjects()) {
                i7 = missingObjectCount$iv;
                i10 = 0;
                if (i19 &= i3 != 0) {
                } else {
                }
                this_$iv2 = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = this_$iv2;
                if (missingIntCount$iv > 0) {
                }
                this_$iv2 = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i7)));
                missingObjectCount$iv2++;
                sb.append(this_$iv3);
            }
            this_$iv = objectParamName-31yXWZQ;
            objectParamName-31yXWZQ = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(objectParamName-31yXWZQ, str);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(missingObjectCount$iv2).append(" object arguments (").append(objectParamName-31yXWZQ).append(").").toString());
        } else {
            this_$iv = objectParamName-31yXWZQ;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushUpdateAnchoredValue(Object value, Anchor anchor, int groupSlotIndex) {
        Object missingObjects$iv;
        String objectParamName-31yXWZQ;
        Object operations;
        int $i$f$push;
        int i6;
        int i7;
        int i4;
        int this_$iv;
        int string;
        int str;
        int i10;
        int missingIntCount$iv;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i;
        int i5;
        int i11;
        androidx.compose.runtime.changelist.Operations this_$iv2;
        int i8;
        int i9;
        int i2;
        String str2;
        int i3;
        operations = missingObjects$iv.operations;
        final androidx.compose.runtime.changelist.Operation.UpdateAnchoredValue iNSTANCE = Operation.UpdateAnchoredValue.INSTANCE;
        $i$f$push = 0;
        operations.pushOp((Operation)iNSTANCE);
        androidx.compose.runtime.changelist.Operations constructor-impl3 = Operations.WriteScope.constructor-impl(operations);
        int i12 = 0;
        androidx.compose.runtime.changelist.Operation.UpdateAnchoredValue iNSTANCE2 = Operation.UpdateAnchoredValue.INSTANCE;
        int i14 = 0;
        string = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl3, Operation.ObjectParameter.constructor-impl(string), value);
        androidx.compose.runtime.changelist.Operation.UpdateAnchoredValue iNSTANCE3 = Operation.UpdateAnchoredValue.INSTANCE;
        int i15 = 0;
        str = 1;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl3, Operation.ObjectParameter.constructor-impl(str), anchor);
        androidx.compose.runtime.changelist.Operation.UpdateAnchoredValue iNSTANCE4 = Operation.UpdateAnchoredValue.INSTANCE;
        int i16 = 0;
        Operations.WriteScope.setInt-A6tL2VI(constructor-impl3, Operation.IntParameter.constructor-impl(string), groupSlotIndex);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects())) {
            i7 = Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects()) ? str : string;
        } else {
        }
        int i13 = 0;
        if (i7 == 0) {
            this_$iv = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i19 = 0;
            i5 = str;
            i10 = 0;
            while (i10 < iNSTANCE.getInts()) {
                i11 = i10;
                i8 = 0;
                if (i20 &= i2 != 0 && missingIntCount$iv > 0) {
                }
                i10++;
                missingObjects$iv = this;
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i11)));
                missingIntCount$iv++;
                sb2.append(", ");
            }
            string = stringBuilder3.toString();
            String str3 = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str3);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i11 = 0;
            i = $i$f$push;
            $i$f$push = i18;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < iNSTANCE.getObjects()) {
                i9 = missingObjectCount$iv;
                i2 = 0;
                if (i21 &= i3 != 0) {
                } else {
                }
                str2 = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = str2;
                if (missingIntCount$iv > 0) {
                }
                str2 = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i9)));
                $i$f$push++;
                sb.append(objectParamName-31yXWZQ);
            }
            String string2 = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string2, str3);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append($i$f$push).append(" object arguments (").append(string2).append(").").toString());
        } else {
            this_$iv2 = operations;
            i = $i$f$push;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushUpdateAuxData(Object data) {
        Object missingObjectCount$iv3;
        int missingObjectCount$iv2;
        Object objectParamName-31yXWZQ;
        int i5;
        int i;
        int i7;
        int this_$iv2;
        int str2;
        int i4;
        int missingIntCount$iv;
        String string;
        String str;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i6;
        int i2;
        int i8;
        int i9;
        int i10;
        androidx.compose.runtime.changelist.Operations this_$iv;
        int this_$iv3;
        int i3;
        objectParamName-31yXWZQ = missingObjectCount$iv3.operations;
        final androidx.compose.runtime.changelist.Operation.UpdateAuxData iNSTANCE = Operation.UpdateAuxData.INSTANCE;
        final int i11 = 0;
        objectParamName-31yXWZQ.pushOp((Operation)iNSTANCE);
        int i12 = 0;
        androidx.compose.runtime.changelist.Operation.UpdateAuxData iNSTANCE2 = Operation.UpdateAuxData.INSTANCE;
        int i14 = 0;
        str2 = 0;
        Operations.WriteScope.setObject-DKhxnng(Operations.WriteScope.constructor-impl(objectParamName-31yXWZQ), Operation.ObjectParameter.constructor-impl(str2), data);
        if (Operations.access$getPushedIntMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects())) {
            i = Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects()) ? 1 : str2;
        } else {
        }
        int i13 = 0;
        if (i == 0) {
            i4 = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i15 = 0;
            i6 = str2;
            i2 = 1;
            this_$iv2 = ", ";
            while (i6 < iNSTANCE.getInts()) {
                i8 = i6;
                i9 = 0;
                if (i17 &= this_$iv3 != 0 && missingIntCount$iv > 0) {
                }
                i6++;
                i2 = 1;
                this_$iv2 = ", ";
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i8)));
                missingIntCount$iv++;
                sb2.append(this_$iv2);
            }
            string = stringBuilder3.toString();
            str = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i8 = 0;
            missingObjectCount$iv2 = i16;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < iNSTANCE.getObjects()) {
                i9 = missingObjectCount$iv;
                i10 = 0;
                if (i18 &= i3 != 0) {
                } else {
                }
                this_$iv3 = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = this_$iv3;
                if (missingIntCount$iv > 0) {
                }
                this_$iv3 = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i9)));
                missingObjectCount$iv2++;
                sb.append(this_$iv2);
            }
            this_$iv = objectParamName-31yXWZQ;
            objectParamName-31yXWZQ = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(objectParamName-31yXWZQ, str);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(missingObjectCount$iv2).append(" object arguments (").append(objectParamName-31yXWZQ).append(").").toString());
        } else {
            this_$iv = objectParamName-31yXWZQ;
        }
    }

    public final <T, V> void pushUpdateNode(V value, Function2<? super T, ? super V, Unit> block) {
        Object missingObjects$iv;
        int objectParamName-31yXWZQ;
        Object missingObjectCount$iv2;
        int i5;
        int i2;
        int i;
        int this_$iv;
        int string;
        Object missingIntCount$iv;
        int append;
        String intParamName-w8GmfQM;
        String str;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i3;
        int i4;
        int i6;
        int i7;
        int i8;
        int i9;
        missingObjects$iv = block;
        final androidx.compose.runtime.changelist.Operations operations = missingObjectCount$iv2.operations;
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
            i2 = Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, iNSTANCE.getObjects()) ? append : string;
        } else {
        }
        int i12 = 0;
        if (i2 == 0) {
            this_$iv = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i17 = 0;
            i4 = append;
            intParamName-w8GmfQM = ", ";
            while (string < iNSTANCE.getInts()) {
                i6 = string;
                i7 = 0;
                if (i20 &= i9 != 0 && missingIntCount$iv > 0) {
                }
                string++;
                append = i4;
                i4 = append;
                intParamName-w8GmfQM = ", ";
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i6)));
                missingIntCount$iv++;
                sb2.append(intParamName-w8GmfQM);
            }
            string = stringBuilder3.toString();
            String str3 = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str3);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i6 = 0;
            objectParamName-31yXWZQ = iNSTANCE.getObjects();
            missingObjectCount$iv2 = i16;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < objectParamName-31yXWZQ) {
                i3 = missingObjectCount$iv;
                i7 = 0;
                if (i18 &= i9 != 0) {
                } else {
                }
                i8 = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = i8;
                if (missingIntCount$iv > 0) {
                }
                i8 = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i3)));
                missingObjectCount$iv2++;
                sb.append(intParamName-w8GmfQM);
            }
            String string2 = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string2, str3);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(missingObjectCount$iv2).append(" object arguments (").append(string2).append(").").toString());
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushUpdateValue(Object value, int groupSlotIndex) {
        Object missingObjects$iv;
        int objectParamName-31yXWZQ;
        androidx.compose.runtime.changelist.Operations this_$iv;
        int i10;
        int i11;
        int i9;
        int this_$iv2;
        int i3;
        int append;
        String intParamName-w8GmfQM;
        int i7;
        int missingIntCount$iv;
        String str;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i2;
        androidx.compose.runtime.changelist.Operations this_$iv3;
        int i;
        int i4;
        int i5;
        int i6;
        int i8;
        this_$iv = missingObjects$iv.operations;
        final androidx.compose.runtime.changelist.Operation.UpdateValue iNSTANCE = Operation.UpdateValue.INSTANCE;
        final int i12 = 0;
        this_$iv.pushOp((Operation)iNSTANCE);
        androidx.compose.runtime.changelist.Operations constructor-impl2 = Operations.WriteScope.constructor-impl(this_$iv);
        int i13 = 0;
        androidx.compose.runtime.changelist.Operation.UpdateValue iNSTANCE2 = Operation.UpdateValue.INSTANCE;
        int i15 = 0;
        append = 0;
        Operations.WriteScope.setObject-DKhxnng(constructor-impl2, Operation.ObjectParameter.constructor-impl(append), value);
        androidx.compose.runtime.changelist.Operation.UpdateValue iNSTANCE3 = Operation.UpdateValue.INSTANCE;
        int i16 = 0;
        Operations.WriteScope.setInt-A6tL2VI(constructor-impl2, Operation.IntParameter.constructor-impl(append), groupSlotIndex);
        if (Operations.access$getPushedIntMask$p(this_$iv) == Operations.access$createExpectedArgMask(this_$iv, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(this_$iv) == Operations.access$createExpectedArgMask(this_$iv, iNSTANCE.getObjects())) {
            i11 = Operations.access$getPushedObjectMask$p(this_$iv) == Operations.access$createExpectedArgMask(this_$iv, iNSTANCE.getObjects()) ? 1 : append;
        } else {
        }
        int i14 = 0;
        if (i11 == 0) {
            i7 = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i19 = 0;
            i3 = append;
            i2 = 1;
            intParamName-w8GmfQM = ", ";
            while (i3 < iNSTANCE.getInts()) {
                i = i3;
                i4 = 0;
                if (i20 &= i6 != 0 && missingIntCount$iv > 0) {
                }
                i3++;
                append = 0;
                intParamName-w8GmfQM = ", ";
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i)));
                missingIntCount$iv++;
                sb2.append(intParamName-w8GmfQM);
            }
            this_$iv2 = stringBuilder3.toString();
            String str2 = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(this_$iv2, str2);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i = 0;
            objectParamName-31yXWZQ = iNSTANCE.getObjects();
            this_$iv = i18;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < objectParamName-31yXWZQ) {
                i4 = missingObjectCount$iv;
                i5 = 0;
                if (i21 &= i8 != 0) {
                } else {
                }
                i6 = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = i6;
                if (missingIntCount$iv > 0) {
                }
                i6 = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i4)));
                this_$iv++;
                sb.append(intParamName-w8GmfQM);
            }
            String string = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, str2);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(this_$iv2).append(") and ").append(this_$iv).append(" object arguments (").append(string).append(").").toString());
        } else {
            this_$iv3 = this_$iv;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushUps(int count) {
        Object missingObjectCount$iv3;
        int missingObjectCount$iv2;
        Object objectParamName-31yXWZQ;
        int i;
        int i4;
        int i10;
        int this_$iv;
        int str2;
        int i8;
        int missingIntCount$iv;
        String string;
        String str;
        int missingObjectCount$iv;
        StringBuilder stringBuilder;
        StringBuilder sb;
        int i2;
        int i9;
        int i5;
        int i7;
        int i3;
        androidx.compose.runtime.changelist.Operations this_$iv2;
        int this_$iv3;
        int i6;
        objectParamName-31yXWZQ = missingObjectCount$iv3.operations;
        final androidx.compose.runtime.changelist.Operation.Ups iNSTANCE = Operation.Ups.INSTANCE;
        final int i11 = 0;
        objectParamName-31yXWZQ.pushOp((Operation)iNSTANCE);
        int i12 = 0;
        androidx.compose.runtime.changelist.Operation.Ups iNSTANCE2 = Operation.Ups.INSTANCE;
        int i14 = 0;
        str2 = 0;
        Operations.WriteScope.setInt-A6tL2VI(Operations.WriteScope.constructor-impl(objectParamName-31yXWZQ), Operation.IntParameter.constructor-impl(str2), count);
        if (Operations.access$getPushedIntMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getInts()) && Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects())) {
            i4 = Operations.access$getPushedObjectMask$p(objectParamName-31yXWZQ) == Operations.access$createExpectedArgMask(objectParamName-31yXWZQ, iNSTANCE.getObjects()) ? 1 : str2;
        } else {
        }
        int i13 = 0;
        if (i4 == 0) {
            i8 = 0;
            missingIntCount$iv = 0;
            StringBuilder stringBuilder3 = new StringBuilder();
            StringBuilder sb2 = stringBuilder3;
            int i16 = 0;
            i2 = str2;
            i9 = 1;
            this_$iv = ", ";
            while (i2 < iNSTANCE.getInts()) {
                i5 = i2;
                i7 = 0;
                if (i18 &= this_$iv3 != 0 && missingIntCount$iv > 0) {
                }
                i2++;
                i9 = 1;
                this_$iv = ", ";
                if (missingIntCount$iv > 0) {
                }
                sb2.append(iNSTANCE.intParamName-w8GmfQM(Operation.IntParameter.constructor-impl(i5)));
                missingIntCount$iv++;
                sb2.append(this_$iv);
            }
            string = stringBuilder3.toString();
            str = "StringBuilder().apply(builderAction).toString()";
            Intrinsics.checkNotNullExpressionValue(string, str);
            stringBuilder = new StringBuilder();
            sb = stringBuilder;
            i5 = 0;
            missingObjectCount$iv2 = i17;
            missingObjectCount$iv = 0;
            while (missingObjectCount$iv < iNSTANCE.getObjects()) {
                i7 = missingObjectCount$iv;
                i3 = 0;
                if (i19 &= i6 != 0) {
                } else {
                }
                this_$iv3 = objectParamName-31yXWZQ;
                missingObjectCount$iv++;
                objectParamName-31yXWZQ = this_$iv3;
                if (missingIntCount$iv > 0) {
                }
                this_$iv3 = objectParamName-31yXWZQ;
                sb.append(iNSTANCE.objectParamName-31yXWZQ(Operation.ObjectParameter.constructor-impl(i7)));
                missingObjectCount$iv2++;
                sb.append(this_$iv);
            }
            this_$iv2 = objectParamName-31yXWZQ;
            objectParamName-31yXWZQ = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(objectParamName-31yXWZQ, str);
            StringBuilder stringBuilder2 = new StringBuilder();
            PreconditionsKt.throwIllegalStateException(stringBuilder2.append("Error while pushing ").append(iNSTANCE).append(". Not all arguments were provided. Missing ").append(missingIntCount$iv).append(" int arguments (").append(string).append(") and ").append(missingObjectCount$iv2).append(" object arguments (").append(objectParamName-31yXWZQ).append(").").toString());
        } else {
            this_$iv2 = objectParamName-31yXWZQ;
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public final void pushUseNode(Object node) {
        boolean operations;
        androidx.compose.runtime.changelist.Operation.UseCurrentNode iNSTANCE;
        if (node instanceof ComposeNodeLifecycleCallback != null) {
            this.operations.push((Operation)Operation.UseCurrentNode.INSTANCE);
        }
    }

    @Override // androidx.compose.runtime.changelist.OperationsDebugStringFormattable
    public String toDebugString(String linePrefix) {
        int debugString;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb = stringBuilder;
        final int i = 0;
        sb.append("ChangeList instance containing ");
        sb.append(getSize());
        sb.append(" operations");
        debugString = (CharSequence)sb.length() > 0 ? 1 : 0;
        if (debugString != null) {
            sb.append(":\n");
            sb.append(this.operations.toDebugString(linePrefix));
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
