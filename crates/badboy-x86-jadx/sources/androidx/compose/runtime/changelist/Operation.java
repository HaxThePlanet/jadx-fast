package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.OffsetApplier;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RecomposeScopeImpl.Companion;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.internal.Utils_jvmKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u00080\u0018\u00002\u00020\u0001:$\u001f !\"#$%&'()*+,-./0123456789:;<=>?@ABB\u001b\u0008\u0004\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J\u001e\u0010\u0012\u001a\u00020\t2\n\u0010\u000e\u001a\u0006\u0012\u0002\u0008\u00030\u0013H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0011J\u0008\u0010\u0015\u001a\u00020\tH\u0016J(\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\u0008\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0008\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u0007\u0082\u0001\"CDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcd\u0082\u0002\u0007\n\u0005\u0008¡\u001e0\u0001¨\u0006e", d2 = {"Landroidx/compose/runtime/changelist/Operation;", "", "ints", "", "objects", "(II)V", "getInts", "()I", "name", "", "getName", "()Ljava/lang/String;", "getObjects", "intParamName", "parameter", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "objectParamName-31yXWZQ", "toString", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "AdvanceSlotsBy", "AppendValue", "ApplyChangeList", "CopyNodesToNewAnchorLocation", "CopySlotTableToAnchorLocation", "DeactivateCurrentGroup", "DetermineMovableContentNodeIndex", "Downs", "EndCompositionScope", "EndCurrentGroup", "EndMovableContentPlacement", "EnsureGroupStarted", "EnsureRootGroupStarted", "InsertNodeFixup", "InsertSlots", "InsertSlotsWithFixups", "IntParameter", "MoveCurrentGroup", "MoveNode", "ObjectParameter", "PostInsertNodeFixup", "ReleaseMovableGroupAtCurrent", "Remember", "RemoveCurrentGroup", "RemoveNode", "ResetSlots", "SideEffect", "SkipToEndOfCurrentGroup", "TestOperation", "TrimParentValues", "UpdateAnchoredValue", "UpdateAuxData", "UpdateNode", "UpdateValue", "Ups", "UseCurrentNode", "Landroidx/compose/runtime/changelist/Operation$AdvanceSlotsBy;", "Landroidx/compose/runtime/changelist/Operation$AppendValue;", "Landroidx/compose/runtime/changelist/Operation$ApplyChangeList;", "Landroidx/compose/runtime/changelist/Operation$CopyNodesToNewAnchorLocation;", "Landroidx/compose/runtime/changelist/Operation$CopySlotTableToAnchorLocation;", "Landroidx/compose/runtime/changelist/Operation$DeactivateCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation$DetermineMovableContentNodeIndex;", "Landroidx/compose/runtime/changelist/Operation$Downs;", "Landroidx/compose/runtime/changelist/Operation$EndCompositionScope;", "Landroidx/compose/runtime/changelist/Operation$EndCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation$EndMovableContentPlacement;", "Landroidx/compose/runtime/changelist/Operation$EnsureGroupStarted;", "Landroidx/compose/runtime/changelist/Operation$EnsureRootGroupStarted;", "Landroidx/compose/runtime/changelist/Operation$InsertNodeFixup;", "Landroidx/compose/runtime/changelist/Operation$InsertSlots;", "Landroidx/compose/runtime/changelist/Operation$InsertSlotsWithFixups;", "Landroidx/compose/runtime/changelist/Operation$MoveCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation$MoveNode;", "Landroidx/compose/runtime/changelist/Operation$PostInsertNodeFixup;", "Landroidx/compose/runtime/changelist/Operation$ReleaseMovableGroupAtCurrent;", "Landroidx/compose/runtime/changelist/Operation$Remember;", "Landroidx/compose/runtime/changelist/Operation$RemoveCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation$RemoveNode;", "Landroidx/compose/runtime/changelist/Operation$ResetSlots;", "Landroidx/compose/runtime/changelist/Operation$SideEffect;", "Landroidx/compose/runtime/changelist/Operation$SkipToEndOfCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation$TestOperation;", "Landroidx/compose/runtime/changelist/Operation$TrimParentValues;", "Landroidx/compose/runtime/changelist/Operation$UpdateAnchoredValue;", "Landroidx/compose/runtime/changelist/Operation$UpdateAuxData;", "Landroidx/compose/runtime/changelist/Operation$UpdateNode;", "Landroidx/compose/runtime/changelist/Operation$UpdateValue;", "Landroidx/compose/runtime/changelist/Operation$Ups;", "Landroidx/compose/runtime/changelist/Operation$UseCurrentNode;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class Operation {

    public static final int $stable;
    private final int ints;
    private final int objects;

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000bJ(\u0010\u000c\u001a\u00020\r*\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\u0008\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0018\u0010\u0003\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0015", d2 = {"Landroidx/compose/runtime/changelist/Operation$AdvanceSlotsBy;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Distance", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "getDistance-jn0FJLE", "()I", "intParamName", "", "parameter", "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AdvanceSlotsBy extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.AdvanceSlotsBy INSTANCE;
        static {
            Operation.AdvanceSlotsBy advanceSlotsBy = new Operation.AdvanceSlotsBy();
            Operation.AdvanceSlotsBy.INSTANCE = advanceSlotsBy;
        }

        private AdvanceSlotsBy() {
            super(1, 0, 2, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            final int i = 0;
            slots.advanceBy($this$execute.getInt-w8GmfQM(Operation.IntParameter.constructor-impl(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getDistance-jn0FJLE() {
            final int i = 0;
            return Operation.IntParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName-w8GmfQM(int parameter) {
            String intParamName-w8GmfQM;
            Object obj = this;
            final int i = 0;
            if (Operation.IntParameter.equals-impl0(parameter, Operation.IntParameter.constructor-impl(0))) {
                intParamName-w8GmfQM = "distance";
            } else {
                intParamName-w8GmfQM = super.intParamName-w8GmfQM(parameter);
            }
            return intParamName-w8GmfQM;
        }
    }

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u00020\u000c2\n\u0010\r\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ(\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R \u0010\u0008\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0019", d2 = {"Landroidx/compose/runtime/changelist/Operation$AppendValue;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Anchor", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/Anchor;", "getAnchor-HpuvwBQ", "()I", "Value", "", "getValue-HpuvwBQ", "objectParamName", "", "parameter", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AppendValue extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.AppendValue INSTANCE;
        static {
            Operation.AppendValue appendValue = new Operation.AppendValue();
            Operation.AppendValue.INSTANCE = appendValue;
        }

        private AppendValue() {
            super(0, 2, 1, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            boolean wrapped;
            Object obj = this;
            int i = 0;
            Object obj2 = this;
            int i3 = 0;
            Object object-31yXWZQ2 = $this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(1));
            if (object-31yXWZQ2 instanceof RememberObserverHolder) {
                rememberManager.remembering((RememberObserverHolder)object-31yXWZQ2.getWrapped());
            }
            slots.appendSlot((Anchor)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(0)), object-31yXWZQ2);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getAnchor-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getValue-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            int i2;
            int i;
            Object obj = this;
            i2 = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "anchor";
            } else {
                Object obj2 = this;
                i2 = 0;
                if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(1))) {
                    objectParamName-31yXWZQ = "value";
                } else {
                    objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
                }
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u00020\u000c2\n\u0010\r\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ(\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R \u0010\u0008\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0019", d2 = {"Landroidx/compose/runtime/changelist/Operation$ApplyChangeList;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Changes", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/changelist/ChangeList;", "getChanges-HpuvwBQ", "()I", "EffectiveNodeIndex", "Landroidx/compose/runtime/internal/IntRef;", "getEffectiveNodeIndex-HpuvwBQ", "objectParamName", "", "parameter", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ApplyChangeList extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.ApplyChangeList INSTANCE;
        static {
            Operation.ApplyChangeList applyChangeList = new Operation.ApplyChangeList();
            Operation.ApplyChangeList.INSTANCE = applyChangeList;
        }

        private ApplyChangeList() {
            super(0, 2, 1, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            int element;
            Applier offsetApplier;
            Object obj = this;
            int i = 0;
            Object object-31yXWZQ = $this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(1));
            int i2 = 0;
            if ((IntRef)object-31yXWZQ != null) {
                element = (IntRef)object-31yXWZQ.getElement();
            } else {
                element = i2;
            }
            Object obj2 = this;
            final int i4 = 0;
            if (element > 0) {
                offsetApplier = new OffsetApplier(applier, element);
            } else {
                offsetApplier = applier;
            }
            (ChangeList)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(i2)).executeAndFlushAllPendingChanges(offsetApplier, slots, rememberManager);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getChanges-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getEffectiveNodeIndex-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            int i2;
            int i;
            Object obj = this;
            i2 = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "changes";
            } else {
                Object obj2 = this;
                i2 = 0;
                if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(1))) {
                    objectParamName-31yXWZQ = "effectiveNodeIndex";
                } else {
                    objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
                }
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000c\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010J(\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\n\u0010\u0014\u001a\u0006\u0012\u0002\u0008\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R\u001e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R&\u0010\u0008\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t0\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001a", d2 = {"Landroidx/compose/runtime/changelist/Operation$CopyNodesToNewAnchorLocation;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "EffectiveNodeIndex", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/internal/IntRef;", "getEffectiveNodeIndex-HpuvwBQ", "()I", "Nodes", "", "", "getNodes-HpuvwBQ", "objectParamName", "", "parameter", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CopyNodesToNewAnchorLocation extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.CopyNodesToNewAnchorLocation INSTANCE;
        static {
            Operation.CopyNodesToNewAnchorLocation copyNodesToNewAnchorLocation = new Operation.CopyNodesToNewAnchorLocation();
            Operation.CopyNodesToNewAnchorLocation.INSTANCE = copyNodesToNewAnchorLocation;
        }

        private CopyNodesToNewAnchorLocation() {
            super(0, 2, 1, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            int index$iv;
            Object obj;
            int i3;
            Object obj2;
            int i2;
            int i;
            Object obj3 = this;
            int i4 = 0;
            int element = (IntRef)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(0)).getElement();
            Object obj4 = this;
            int i6 = 0;
            Object obj5 = object-31yXWZQ2;
            int i8 = 0;
            index$iv = 0;
            while (index$iv < obj5.size()) {
                i3 = index$iv;
                obj2 = obj;
                i2 = 0;
                Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
                applier.insertBottomUp(element + i3, obj2);
                applier.insertTopDown(element + i3, obj2);
                index$iv++;
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getEffectiveNodeIndex-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getNodes-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            int i;
            int i2;
            Object obj = this;
            i = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "effectiveNodeIndex";
            } else {
                Object obj2 = this;
                i = 0;
                if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(1))) {
                    objectParamName-31yXWZQ = "nodes";
                } else {
                    objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
                }
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0010\u001a\u00020\u00112\n\u0010\u0012\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0013\u0010\u0014J(\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\n\u0010\u0018\u001a\u0006\u0012\u0002\u0008\u00030\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u001e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u001e\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0007R \u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u0007R\u001e\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001e", d2 = {"Landroidx/compose/runtime/changelist/Operation$CopySlotTableToAnchorLocation;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "From", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/MovableContentStateReference;", "getFrom-HpuvwBQ", "()I", "ParentCompositionContext", "Landroidx/compose/runtime/CompositionContext;", "getParentCompositionContext-HpuvwBQ", "ResolvedState", "Landroidx/compose/runtime/MovableContentState;", "getResolvedState-HpuvwBQ", "To", "getTo-HpuvwBQ", "objectParamName", "", "parameter", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CopySlotTableToAnchorLocation extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.CopySlotTableToAnchorLocation INSTANCE;
        static {
            Operation.CopySlotTableToAnchorLocation copySlotTableToAnchorLocation = new Operation.CopySlotTableToAnchorLocation();
            Operation.CopySlotTableToAnchorLocation.INSTANCE = copySlotTableToAnchorLocation;
        }

        private CopySlotTableToAnchorLocation() {
            super(0, 4, 1, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object movableContentStateResolve$runtime_release;
            Object obj = this;
            int i = 0;
            int i2 = 2;
            Object obj2 = this;
            int i3 = 0;
            Object obj3 = this;
            int i5 = 0;
            int i6 = 1;
            Object obj4 = this;
            int i7 = 0;
            if ((MovableContentState)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(0)) == null) {
                if ((CompositionContext)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(i6)).movableContentStateResolve$runtime_release((MovableContentStateReference)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(i2))) == null) {
                } else {
                }
                ComposerKt.composeRuntimeError("Could not resolve state for movable content");
                KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
                throw kotlinNothingValueException;
            }
            androidx.compose.runtime.ControlledComposition composition$runtime_release = (MovableContentStateReference)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(3)).getComposition$runtime_release();
            Intrinsics.checkNotNull(composition$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.RecomposeScopeOwner");
            RecomposeScopeImpl.Companion.adoptAnchoredScopes$runtime_release(slots, slots.moveIntoGroupFrom(i6, movableContentStateResolve$runtime_release.getSlotTable$runtime_release(), i2), (RecomposeScopeOwner)composition$runtime_release);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getFrom-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(2);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getParentCompositionContext-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getResolvedState-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getTo-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(3);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            int i2;
            int i;
            Object obj = this;
            i2 = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "resolvedState";
            } else {
                Object obj2 = this;
                i2 = 0;
                if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(1))) {
                    objectParamName-31yXWZQ = "resolvedCompositionContext";
                } else {
                    Object obj3 = this;
                    i2 = 0;
                    if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(2))) {
                        objectParamName-31yXWZQ = "from";
                    } else {
                        Object obj4 = this;
                        i2 = 0;
                        if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(3))) {
                            objectParamName-31yXWZQ = "to";
                        } else {
                            objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
                        }
                    }
                }
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000c", d2 = {"Landroidx/compose/runtime/changelist/Operation$DeactivateCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DeactivateCurrentGroup extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.DeactivateCurrentGroup INSTANCE;
        static {
            Operation.DeactivateCurrentGroup deactivateCurrentGroup = new Operation.DeactivateCurrentGroup();
            Operation.DeactivateCurrentGroup.INSTANCE = deactivateCurrentGroup;
        }

        private DeactivateCurrentGroup() {
            final int i3 = 0;
            super(i3, i3, 3, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            ComposerKt.deactivateCurrentGroup(slots, rememberManager);
        }
    }

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u00020\u000c2\n\u0010\r\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ(\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u001e\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0019", d2 = {"Landroidx/compose/runtime/changelist/Operation$DetermineMovableContentNodeIndex;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Anchor", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/Anchor;", "getAnchor-HpuvwBQ", "()I", "EffectiveNodeIndexOut", "Landroidx/compose/runtime/internal/IntRef;", "getEffectiveNodeIndexOut-HpuvwBQ", "objectParamName", "", "parameter", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class DetermineMovableContentNodeIndex extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.DetermineMovableContentNodeIndex INSTANCE;
        static {
            Operation.DetermineMovableContentNodeIndex determineMovableContentNodeIndex = new Operation.DetermineMovableContentNodeIndex();
            Operation.DetermineMovableContentNodeIndex.INSTANCE = determineMovableContentNodeIndex;
        }

        private DetermineMovableContentNodeIndex() {
            super(0, 2, 1, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            int i = 0;
            Object obj2 = this;
            int i4 = 0;
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            (IntRef)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(0)).setElement(OperationKt.access$positionToInsert(slots, (Anchor)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(1)), applier));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getAnchor-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getEffectiveNodeIndexOut-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            int i;
            int i2;
            Object obj = this;
            i = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "effectiveNodeIndexOut";
            } else {
                Object obj2 = this;
                i = 0;
                if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(1))) {
                    objectParamName-31yXWZQ = "anchor";
                } else {
                    objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
                }
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\rJ(\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\u0008\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R&\u0010\u0003\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0017", d2 = {"Landroidx/compose/runtime/changelist/Operation$Downs;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Nodes", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "", "", "getNodes-HpuvwBQ", "()I", "objectParamName", "", "parameter", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Downs extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.Downs INSTANCE;
        static {
            Operation.Downs downs = new Operation.Downs();
            Operation.Downs.INSTANCE = downs;
        }

        private Downs() {
            final int i = 1;
            super(0, i, i, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            int index;
            Object obj;
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            Object obj3 = this;
            int i = 0;
            Object object-31yXWZQ = $this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(0));
            index = 0;
            while (index < object-31yXWZQ.length) {
                applier.down((Object[])object-31yXWZQ[index]);
                index++;
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getNodes-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            Object obj = this;
            final int i = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "nodes";
            } else {
                objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000c\u001a\u00020\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000f\u0010\u0010J(\u0010\u0011\u001a\u00020\u0007*\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R*\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001e\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\t\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0019", d2 = {"Landroidx/compose/runtime/changelist/Operation$EndCompositionScope;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Action", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "", "getAction-HpuvwBQ", "()I", "Composition", "getComposition-HpuvwBQ", "objectParamName", "", "parameter", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "execute", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class EndCompositionScope extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.EndCompositionScope INSTANCE;
        static {
            Operation.EndCompositionScope endCompositionScope = new Operation.EndCompositionScope();
            Operation.EndCompositionScope.INSTANCE = endCompositionScope;
        }

        private EndCompositionScope() {
            super(0, 2, 1, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            int i = 0;
            Object obj2 = this;
            int i3 = 0;
            (Function1)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(0)).invoke((Composition)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(1)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getAction-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getComposition-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            int i;
            int i2;
            Object obj = this;
            i = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "anchor";
            } else {
                Object obj2 = this;
                i = 0;
                if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(1))) {
                    objectParamName-31yXWZQ = "composition";
                } else {
                    objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
                }
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000c", d2 = {"Landroidx/compose/runtime/changelist/Operation$EndCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class EndCurrentGroup extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.EndCurrentGroup INSTANCE;
        static {
            Operation.EndCurrentGroup endCurrentGroup = new Operation.EndCurrentGroup();
            Operation.EndCurrentGroup.INSTANCE = endCurrentGroup;
        }

        private EndCurrentGroup() {
            final int i3 = 0;
            super(i3, i3, 3, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            slots.endGroup();
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000c", d2 = {"Landroidx/compose/runtime/changelist/Operation$EndMovableContentPlacement;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class EndMovableContentPlacement extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.EndMovableContentPlacement INSTANCE;
        static {
            Operation.EndMovableContentPlacement endMovableContentPlacement = new Operation.EndMovableContentPlacement();
            Operation.EndMovableContentPlacement.INSTANCE = endMovableContentPlacement;
        }

        private EndMovableContentPlacement() {
            final int i3 = 0;
            super(i3, i3, 3, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            OperationKt.access$positionToParentOf(slots, applier, 0);
            slots.endGroup();
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0008\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cJ(\u0010\r\u001a\u00020\u000e*\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0016", d2 = {"Landroidx/compose/runtime/changelist/Operation$EnsureGroupStarted;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Anchor", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/Anchor;", "getAnchor-HpuvwBQ", "()I", "objectParamName", "", "parameter", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class EnsureGroupStarted extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.EnsureGroupStarted INSTANCE;
        static {
            Operation.EnsureGroupStarted ensureGroupStarted = new Operation.EnsureGroupStarted();
            Operation.EnsureGroupStarted.INSTANCE = ensureGroupStarted;
        }

        private EnsureGroupStarted() {
            final int i = 1;
            super(0, i, i, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            final int i = 0;
            slots.ensureStarted((Anchor)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getAnchor-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            Object obj = this;
            final int i = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "anchor";
            } else {
                objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000c", d2 = {"Landroidx/compose/runtime/changelist/Operation$EnsureRootGroupStarted;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class EnsureRootGroupStarted extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.EnsureRootGroupStarted INSTANCE;
        static {
            Operation.EnsureRootGroupStarted ensureRootGroupStarted = new Operation.EnsureRootGroupStarted();
            Operation.EnsureRootGroupStarted.INSTANCE = ensureRootGroupStarted;
        }

        private EnsureRootGroupStarted() {
            final int i3 = 0;
            super(i3, i3, 3, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            slots.ensureStarted(0);
        }
    }

    @Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0012\u0010\u0013J\u001e\u0010\u0014\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0013J(\u0010\u0016\u001a\u00020\u0017*\u00020\u00182\n\u0010\u0019\u001a\u0006\u0012\u0002\u0008\u00030\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016R&\u0010\u0003\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u001e\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\n0\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u0008R\u0018\u0010\u000c\u001a\u00020\r8Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u0008\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001f", d2 = {"Landroidx/compose/runtime/changelist/Operation$InsertNodeFixup;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Factory", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Lkotlin/Function0;", "", "getFactory-HpuvwBQ", "()I", "GroupAnchor", "Landroidx/compose/runtime/Anchor;", "getGroupAnchor-HpuvwBQ", "InsertIndex", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "getInsertIndex-jn0FJLE", "intParamName", "", "parameter", "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "objectParamName", "objectParamName-31yXWZQ", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class InsertNodeFixup extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.InsertNodeFixup INSTANCE;
        static {
            Operation.InsertNodeFixup insertNodeFixup = new Operation.InsertNodeFixup();
            Operation.InsertNodeFixup.INSTANCE = insertNodeFixup;
        }

        private InsertNodeFixup() {
            super(1, 2, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            int i = 0;
            int i2 = 0;
            Object invoke = (Function0)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(i2)).invoke();
            Object obj2 = this;
            int i3 = 0;
            Object obj3 = this;
            int i5 = 0;
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            Object obj4 = applier;
            slots.updateNode((Anchor)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(1)), invoke);
            obj4.insertTopDown($this$execute.getInt-w8GmfQM(Operation.IntParameter.constructor-impl(i2)), invoke);
            obj4.down(invoke);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getFactory-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getGroupAnchor-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getInsertIndex-jn0FJLE() {
            final int i = 0;
            return Operation.IntParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName-w8GmfQM(int parameter) {
            String intParamName-w8GmfQM;
            Object obj = this;
            final int i = 0;
            if (Operation.IntParameter.equals-impl0(parameter, Operation.IntParameter.constructor-impl(0))) {
                intParamName-w8GmfQM = "insertIndex";
            } else {
                intParamName-w8GmfQM = super.intParamName-w8GmfQM(parameter);
            }
            return intParamName-w8GmfQM;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            int i2;
            int i;
            Object obj = this;
            i2 = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "factory";
            } else {
                Object obj2 = this;
                i2 = 0;
                if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(1))) {
                    objectParamName-31yXWZQ = "groupAnchor";
                } else {
                    objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
                }
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000b\u001a\u00020\u000c2\n\u0010\r\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ(\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u001e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u001e\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0019", d2 = {"Landroidx/compose/runtime/changelist/Operation$InsertSlots;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Anchor", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/Anchor;", "getAnchor-HpuvwBQ", "()I", "FromSlotTable", "Landroidx/compose/runtime/SlotTable;", "getFromSlotTable-HpuvwBQ", "objectParamName", "", "parameter", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class InsertSlots extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.InsertSlots INSTANCE;
        static {
            Operation.InsertSlots insertSlots = new Operation.InsertSlots();
            Operation.InsertSlots.INSTANCE = insertSlots;
        }

        private InsertSlots() {
            super(0, 2, 1, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            int i = 0;
            Object object-31yXWZQ = $this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(1));
            Object obj2 = this;
            int i3 = 0;
            final int i4 = 0;
            slots.beginInsert();
            slots.moveFrom(object-31yXWZQ, (Anchor)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(i4)).toIndexFor((SlotTable)object-31yXWZQ), i4);
            slots.endInsert();
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getAnchor-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getFromSlotTable-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            int i;
            int i2;
            Object obj = this;
            i = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "anchor";
            } else {
                Object obj2 = this;
                i = 0;
                if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(1))) {
                    objectParamName-31yXWZQ = "from";
                } else {
                    objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
                }
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J(\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\n\u0010\u0016\u001a\u0006\u0012\u0002\u0008\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u001e\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0007R\u001e\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001c", d2 = {"Landroidx/compose/runtime/changelist/Operation$InsertSlotsWithFixups;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Anchor", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/Anchor;", "getAnchor-HpuvwBQ", "()I", "Fixups", "Landroidx/compose/runtime/changelist/FixupList;", "getFixups-HpuvwBQ", "FromSlotTable", "Landroidx/compose/runtime/SlotTable;", "getFromSlotTable-HpuvwBQ", "objectParamName", "", "parameter", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class InsertSlotsWithFixups extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.InsertSlotsWithFixups INSTANCE;
        static {
            Operation.InsertSlotsWithFixups insertSlotsWithFixups = new Operation.InsertSlotsWithFixups();
            Operation.InsertSlotsWithFixups.INSTANCE = insertSlotsWithFixups;
        }

        private InsertSlotsWithFixups() {
            super(0, 3, 1, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            int i = 0;
            Object object-31yXWZQ = $this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(1));
            Object obj2 = this;
            int i3 = 0;
            final int i4 = 0;
            Object obj3 = this;
            int i5 = 0;
            int i7 = 0;
            final SlotWriter writer = (SlotTable)object-31yXWZQ.openWriter();
            final int i8 = 0;
            int i9 = 0;
            int i10 = 0;
            (FixupList)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(2)).executeAndFlushAllPendingFixups(applier, writer, rememberManager);
            Unit writer3 = Unit.INSTANCE;
            int i11 = 0;
            writer.close(true);
            slots.beginInsert();
            slots.moveFrom(object-31yXWZQ, (Anchor)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(i4)).toIndexFor(object-31yXWZQ), i4);
            slots.endInsert();
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getAnchor-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getFixups-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(2);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getFromSlotTable-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            int i;
            int i2;
            Object obj = this;
            i = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "anchor";
            } else {
                Object obj2 = this;
                i = 0;
                if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(1))) {
                    objectParamName-31yXWZQ = "from";
                } else {
                    Object obj3 = this;
                    i = 0;
                    if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(2))) {
                        objectParamName-31yXWZQ = "fixups";
                    } else {
                        objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
                    }
                }
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\u0008\u0004\u0010\u0005J\u001a\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\u000b\u0010\u000cJ\u0010\u0010\r\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\u0008\u000e\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\u0008\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0013", d2 = {"Landroidx/compose/runtime/changelist/Operation$IntParameter;", "", "offset", "", "constructor-impl", "(I)I", "getOffset", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class IntParameter {

        private final int offset;
        private IntParameter(int offset) {
            super();
            this.offset = offset;
        }

        public static final androidx.compose.runtime.changelist.Operation.IntParameter box-impl(int i) {
            Operation.IntParameter intParameter = new Operation.IntParameter(i);
            return intParameter;
        }

        public static int constructor-impl(int i) {
            return i;
        }

        public static boolean equals-impl(int i, Object object2) {
            final int i3 = 0;
            if (!object2 instanceof Operation.IntParameter) {
                return i3;
            }
            if (i != (Operation.IntParameter)object2.unbox-impl()) {
                return i3;
            }
            return 1;
        }

        public static final boolean equals-impl0(int i, int i2) {
            int i3;
            i3 = i == i2 ? 1 : 0;
            return i3;
        }

        public static int hashCode-impl(int i) {
            return Integer.hashCode(i);
        }

        public static String toString-impl(int i) {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("IntParameter(offset=").append(i).append(')').toString();
        }

        public boolean equals(Object object) {
            return Operation.IntParameter.equals-impl(this.offset, object);
        }

        public final int getOffset() {
            return this.offset;
        }

        public int hashCode() {
            return Operation.IntParameter.hashCode-impl(this.offset);
        }

        public String toString() {
            return Operation.IntParameter.toString-impl(this.offset);
        }

        public final int unbox-impl() {
            return this.offset;
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000bJ(\u0010\u000c\u001a\u00020\r*\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\u0008\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0018\u0010\u0003\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0015", d2 = {"Landroidx/compose/runtime/changelist/Operation$MoveCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Offset", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "getOffset-jn0FJLE", "()I", "intParamName", "", "parameter", "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MoveCurrentGroup extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.MoveCurrentGroup INSTANCE;
        static {
            Operation.MoveCurrentGroup moveCurrentGroup = new Operation.MoveCurrentGroup();
            Operation.MoveCurrentGroup.INSTANCE = moveCurrentGroup;
        }

        private MoveCurrentGroup() {
            super(1, 0, 2, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            final int i = 0;
            slots.moveGroup($this$execute.getInt-w8GmfQM(Operation.IntParameter.constructor-impl(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getOffset-jn0FJLE() {
            final int i = 0;
            return Operation.IntParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName-w8GmfQM(int parameter) {
            String intParamName-w8GmfQM;
            Object obj = this;
            final int i = 0;
            if (Operation.IntParameter.equals-impl0(parameter, Operation.IntParameter.constructor-impl(0))) {
                intParamName-w8GmfQM = "offset";
            } else {
                intParamName-w8GmfQM = super.intParamName-w8GmfQM(parameter);
            }
            return intParamName-w8GmfQM;
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ(\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\n\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u0018\u0010\u0003\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0006R\u0018\u0010\t\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0019", d2 = {"Landroidx/compose/runtime/changelist/Operation$MoveNode;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Count", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "getCount-jn0FJLE", "()I", "From", "getFrom-jn0FJLE", "To", "getTo-jn0FJLE", "intParamName", "", "parameter", "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class MoveNode extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.MoveNode INSTANCE;
        static {
            Operation.MoveNode moveNode = new Operation.MoveNode();
            Operation.MoveNode.INSTANCE = moveNode;
        }

        private MoveNode() {
            super(3, 0, 2, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            int i = 0;
            Object obj2 = this;
            int i3 = 0;
            Object obj3 = this;
            int i5 = 0;
            applier.move($this$execute.getInt-w8GmfQM(Operation.IntParameter.constructor-impl(0)), $this$execute.getInt-w8GmfQM(Operation.IntParameter.constructor-impl(1)), $this$execute.getInt-w8GmfQM(Operation.IntParameter.constructor-impl(2)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getCount-jn0FJLE() {
            final int i = 0;
            return Operation.IntParameter.constructor-impl(2);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getFrom-jn0FJLE() {
            final int i = 0;
            return Operation.IntParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getTo-jn0FJLE() {
            final int i = 0;
            return Operation.IntParameter.constructor-impl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName-w8GmfQM(int parameter) {
            String intParamName-w8GmfQM;
            int i;
            int i2;
            Object obj = this;
            i = 0;
            if (Operation.IntParameter.equals-impl0(parameter, Operation.IntParameter.constructor-impl(0))) {
                intParamName-w8GmfQM = "from";
            } else {
                Object obj2 = this;
                i = 0;
                if (Operation.IntParameter.equals-impl0(parameter, Operation.IntParameter.constructor-impl(1))) {
                    intParamName-w8GmfQM = "to";
                } else {
                    Object obj3 = this;
                    i = 0;
                    if (Operation.IntParameter.equals-impl0(parameter, Operation.IntParameter.constructor-impl(2))) {
                        intParamName-w8GmfQM = "count";
                    } else {
                        intParamName-w8GmfQM = super.intParamName-w8GmfQM(parameter);
                    }
                }
            }
            return intParamName-w8GmfQM;
        }
    }

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0087@\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\u0008\u0005\u0010\u0006J\u001a\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\u0008\u000c\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\u0008\u000f\u0010\u0006J\u0010\u0010\u0010\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\u0008\u0012\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008\u0088\u0001\u0003¨\u0006\u0014", d2 = {"Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "T", "", "offset", "", "constructor-impl", "(I)I", "getOffset", "()I", "equals", "", "other", "equals-impl", "(ILjava/lang/Object;)Z", "hashCode", "hashCode-impl", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    @JvmInline
    public static final class ObjectParameter {

        private final int offset;
        private ObjectParameter(int offset) {
            super();
            this.offset = offset;
        }

        public static final androidx.compose.runtime.changelist.Operation.ObjectParameter box-impl(int i) {
            Operation.ObjectParameter objectParameter = new Operation.ObjectParameter(i);
            return objectParameter;
        }

        public static <T> int constructor-impl(int i) {
            return i;
        }

        public static boolean equals-impl(int i, Object object2) {
            final int i3 = 0;
            if (!object2 instanceof Operation.ObjectParameter) {
                return i3;
            }
            if (i != (Operation.ObjectParameter)object2.unbox-impl()) {
                return i3;
            }
            return 1;
        }

        public static final boolean equals-impl0(int i, int i2) {
            int i3;
            i3 = i == i2 ? 1 : 0;
            return i3;
        }

        public static int hashCode-impl(int i) {
            return Integer.hashCode(i);
        }

        public static String toString-impl(int i) {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("ObjectParameter(offset=").append(i).append(')').toString();
        }

        public boolean equals(Object object) {
            return Operation.ObjectParameter.equals-impl(this.offset, object);
        }

        public final int getOffset() {
            return this.offset;
        }

        public int hashCode() {
            return Operation.ObjectParameter.hashCode-impl(this.offset);
        }

        public String toString() {
            return Operation.ObjectParameter.toString-impl(this.offset);
        }

        public final int unbox-impl() {
            return this.offset;
        }
    }

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u000c2\n\u0010\r\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u000fJ(\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\n\u0010\u0015\u001a\u0006\u0012\u0002\u0008\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u001e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u0018\u0010\u0008\u001a\u00020\t8Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001b", d2 = {"Landroidx/compose/runtime/changelist/Operation$PostInsertNodeFixup;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "GroupAnchor", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/Anchor;", "getGroupAnchor-HpuvwBQ", "()I", "InsertIndex", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "getInsertIndex-jn0FJLE", "intParamName", "", "parameter", "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "objectParamName", "objectParamName-31yXWZQ", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PostInsertNodeFixup extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.PostInsertNodeFixup INSTANCE;
        static {
            Operation.PostInsertNodeFixup postInsertNodeFixup = new Operation.PostInsertNodeFixup();
            Operation.PostInsertNodeFixup.INSTANCE = postInsertNodeFixup;
        }

        private PostInsertNodeFixup() {
            final int i = 1;
            super(i, i, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            int i = 0;
            int i2 = 0;
            Object obj2 = this;
            int i3 = 0;
            applier.up();
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            applier.insertBottomUp($this$execute.getInt-w8GmfQM(Operation.IntParameter.constructor-impl(i2)), slots.node((Anchor)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(i2))));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getGroupAnchor-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getInsertIndex-jn0FJLE() {
            final int i = 0;
            return Operation.IntParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName-w8GmfQM(int parameter) {
            String intParamName-w8GmfQM;
            Object obj = this;
            final int i = 0;
            if (Operation.IntParameter.equals-impl0(parameter, Operation.IntParameter.constructor-impl(0))) {
                intParamName-w8GmfQM = "insertIndex";
            } else {
                intParamName-w8GmfQM = super.intParamName-w8GmfQM(parameter);
            }
            return intParamName-w8GmfQM;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            Object obj = this;
            final int i = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "groupAnchor";
            } else {
                objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J(\u0010\u0013\u001a\u00020\u0014*\u00020\u00152\n\u0010\u0016\u001a\u0006\u0012\u0002\u0008\u00030\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u001e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u001e\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0007R\u001e\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001c", d2 = {"Landroidx/compose/runtime/changelist/Operation$ReleaseMovableGroupAtCurrent;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Composition", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/ControlledComposition;", "getComposition-HpuvwBQ", "()I", "ParentCompositionContext", "Landroidx/compose/runtime/CompositionContext;", "getParentCompositionContext-HpuvwBQ", "Reference", "Landroidx/compose/runtime/MovableContentStateReference;", "getReference-HpuvwBQ", "objectParamName", "", "parameter", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ReleaseMovableGroupAtCurrent extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.ReleaseMovableGroupAtCurrent INSTANCE;
        static {
            Operation.ReleaseMovableGroupAtCurrent releaseMovableGroupAtCurrent = new Operation.ReleaseMovableGroupAtCurrent();
            Operation.ReleaseMovableGroupAtCurrent.INSTANCE = releaseMovableGroupAtCurrent;
        }

        private ReleaseMovableGroupAtCurrent() {
            super(0, 3, 1, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            int i = 0;
            Object obj2 = this;
            int i3 = 0;
            Object obj3 = this;
            int i5 = 0;
            OperationKt.access$releaseMovableGroupAtCurrent((ControlledComposition)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(0)), (CompositionContext)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(1)), (MovableContentStateReference)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(2)), slots);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getComposition-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getParentCompositionContext-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getReference-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(2);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            int i;
            int i2;
            Object obj = this;
            i = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "composition";
            } else {
                Object obj2 = this;
                i = 0;
                if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(1))) {
                    objectParamName-31yXWZQ = "parentCompositionContext";
                } else {
                    Object obj3 = this;
                    i = 0;
                    if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(2))) {
                        objectParamName-31yXWZQ = "reference";
                    } else {
                        objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
                    }
                }
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0008\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cJ(\u0010\r\u001a\u00020\u000e*\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0016", d2 = {"Landroidx/compose/runtime/changelist/Operation$Remember;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Value", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/RememberObserver;", "getValue-HpuvwBQ", "()I", "objectParamName", "", "parameter", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Remember extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.Remember INSTANCE;
        static {
            Operation.Remember remember = new Operation.Remember();
            Operation.Remember.INSTANCE = remember;
        }

        private Remember() {
            final int i = 1;
            super(0, i, i, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            final int i = 0;
            rememberManager.remembering((RememberObserver)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getValue-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            Object obj = this;
            final int i = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "value";
            } else {
                objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000c", d2 = {"Landroidx/compose/runtime/changelist/Operation$RemoveCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RemoveCurrentGroup extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.RemoveCurrentGroup INSTANCE;
        static {
            Operation.RemoveCurrentGroup removeCurrentGroup = new Operation.RemoveCurrentGroup();
            Operation.RemoveCurrentGroup.INSTANCE = removeCurrentGroup;
        }

        private RemoveCurrentGroup() {
            final int i3 = 0;
            super(i3, i3, 3, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            ComposerKt.removeCurrentGroup(slots, rememberManager);
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\rJ(\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\u0008\u00030\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0018\u0010\u0003\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0017", d2 = {"Landroidx/compose/runtime/changelist/Operation$RemoveNode;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Count", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "getCount-jn0FJLE", "()I", "RemoveIndex", "getRemoveIndex-jn0FJLE", "intParamName", "", "parameter", "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RemoveNode extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.RemoveNode INSTANCE;
        static {
            Operation.RemoveNode removeNode = new Operation.RemoveNode();
            Operation.RemoveNode.INSTANCE = removeNode;
        }

        private RemoveNode() {
            final int i3 = 2;
            super(i3, 0, i3, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            int i = 0;
            Object obj2 = this;
            int i3 = 0;
            applier.remove($this$execute.getInt-w8GmfQM(Operation.IntParameter.constructor-impl(0)), $this$execute.getInt-w8GmfQM(Operation.IntParameter.constructor-impl(1)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getCount-jn0FJLE() {
            final int i = 0;
            return Operation.IntParameter.constructor-impl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getRemoveIndex-jn0FJLE() {
            final int i = 0;
            return Operation.IntParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName-w8GmfQM(int parameter) {
            String intParamName-w8GmfQM;
            int i2;
            int i;
            Object obj = this;
            i2 = 0;
            if (Operation.IntParameter.equals-impl0(parameter, Operation.IntParameter.constructor-impl(0))) {
                intParamName-w8GmfQM = "removeIndex";
            } else {
                Object obj2 = this;
                i2 = 0;
                if (Operation.IntParameter.equals-impl0(parameter, Operation.IntParameter.constructor-impl(1))) {
                    intParamName-w8GmfQM = "count";
                } else {
                    intParamName-w8GmfQM = super.intParamName-w8GmfQM(parameter);
                }
            }
            return intParamName-w8GmfQM;
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000c", d2 = {"Landroidx/compose/runtime/changelist/Operation$ResetSlots;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ResetSlots extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.ResetSlots INSTANCE;
        static {
            Operation.ResetSlots resetSlots = new Operation.ResetSlots();
            Operation.ResetSlots.INSTANCE = resetSlots;
        }

        private ResetSlots() {
            final int i3 = 0;
            super(i3, i3, 3, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            slots.reset();
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000c\u0010\rJ(\u0010\u000e\u001a\u00020\u0006*\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R$\u0010\u0003\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00060\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0016", d2 = {"Landroidx/compose/runtime/changelist/Operation$SideEffect;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Effect", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Lkotlin/Function0;", "", "getEffect-HpuvwBQ", "()I", "objectParamName", "", "parameter", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "execute", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SideEffect extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.SideEffect INSTANCE;
        static {
            Operation.SideEffect sideEffect = new Operation.SideEffect();
            Operation.SideEffect.INSTANCE = sideEffect;
        }

        private SideEffect() {
            final int i = 1;
            super(0, i, i, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            final int i = 0;
            rememberManager.sideEffect((Function0)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getEffect-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            Object obj = this;
            final int i = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "effect";
            } else {
                objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000c", d2 = {"Landroidx/compose/runtime/changelist/Operation$SkipToEndOfCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class SkipToEndOfCurrentGroup extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.SkipToEndOfCurrentGroup INSTANCE;
        static {
            Operation.SkipToEndOfCurrentGroup skipToEndOfCurrentGroup = new Operation.SkipToEndOfCurrentGroup();
            Operation.SkipToEndOfCurrentGroup.INSTANCE = skipToEndOfCurrentGroup;
        }

        private SkipToEndOfCurrentGroup() {
            final int i3 = 0;
            super(i3, i3, 3, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            slots.skipToGroupEnd();
        }
    }

    @Metadata(d1 = "\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0007\u0018\u00002\u00020\u0001BA\u0008\u0007\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012$\u0008\u0002\u0010\u0005\u001a\u001e\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0007\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0002\u0010\u000bJ\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u0019\u001a\u00020\n*\u00020\u001a2\n\u0010\u001b\u001a\u0006\u0012\u0002\u0008\u00030\u00072\u0006\u0010\u001c\u001a\u00020\u00082\u0006\u0010\u001d\u001a\u00020\tH\u0016R-\u0010\u0005\u001a\u001e\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0007\u0012\u0004\u0012\u00020\u0008\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0017\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u001f\u0010\u0013\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00140\u000f¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0012¨\u0006\u001e", d2 = {"Landroidx/compose/runtime/changelist/Operation$TestOperation;", "Landroidx/compose/runtime/changelist/Operation;", "ints", "", "objects", "block", "Lkotlin/Function3;", "Landroidx/compose/runtime/Applier;", "Landroidx/compose/runtime/SlotWriter;", "Landroidx/compose/runtime/RememberManager;", "", "(IILkotlin/jvm/functions/Function3;)V", "getBlock", "()Lkotlin/jvm/functions/Function3;", "intParams", "", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "getIntParams", "()Ljava/util/List;", "objParams", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "", "getObjParams", "toString", "", "execute", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "slots", "rememberManager", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TestOperation extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable = 8;
        private final Function3<Applier<?>, SlotWriter, RememberManager, Unit> block;
        private final List<androidx.compose.runtime.changelist.Operation.IntParameter> intParams;
        private final List<androidx.compose.runtime.changelist.Operation.ObjectParameter<Object>> objParams;
        static {
            final int i = 8;
        }

        public TestOperation() {
            super(0, 0, 0, 7, 0);
        }

        public TestOperation(int ints, int objects, Function3<? super Applier<?>, ? super SlotWriter, ? super RememberManager, Unit> block) {
            int i;
            int box-impl2;
            androidx.compose.runtime.changelist.Operation.IntParameter box-impl;
            int i2;
            super(ints, objects, 0);
            this.block = block;
            ArrayList arrayList = new ArrayList(ints);
            box-impl2 = i;
            while (box-impl2 < ints) {
                i2 = 0;
                arrayList.add(Operation.IntParameter.box-impl(Operation.IntParameter.constructor-impl(box-impl2)));
                box-impl2++;
            }
            this.intParams = (List)arrayList;
            ArrayList arrayList2 = new ArrayList(objects);
            while (i < objects) {
                box-impl = 0;
                arrayList2.add(Operation.ObjectParameter.box-impl(Operation.ObjectParameter.constructor-impl(i)));
                i++;
            }
            this.objParams = (List)arrayList2;
        }

        public TestOperation(int i, int i2, Function3 function33, int i4, DefaultConstructorMarker defaultConstructorMarker5) {
            int obj2;
            int obj3;
            androidx.compose.runtime.changelist.Operation.TestOperation.1 obj4;
            final int i3 = 0;
            obj2 = i4 & 1 != 0 ? i3 : obj2;
            obj3 = i4 & 2 != 0 ? i3 : obj3;
            if (i4 &= 4 != 0) {
                obj4 = Operation.TestOperation.1.INSTANCE;
            }
            super(obj2, obj3, obj4);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            this.block.invoke(applier, slots, rememberManager);
        }

        public final Function3<Applier<?>, SlotWriter, RememberManager, Unit> getBlock() {
            return this.block;
        }

        public final List<androidx.compose.runtime.changelist.Operation.IntParameter> getIntParams() {
            return this.intParams;
        }

        public final List<androidx.compose.runtime.changelist.Operation.ObjectParameter<Object>> getObjParams() {
            return this.objParams;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("TestOperation(ints = ").append(getInts()).append(", objects = ").append(getObjects()).append(")@").append(Utils_jvmKt.identityHashCode(this)).toString();
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000bJ(\u0010\u000c\u001a\u00020\r*\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\u0008\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0018\u0010\u0003\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0015", d2 = {"Landroidx/compose/runtime/changelist/Operation$TrimParentValues;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Count", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "getCount-jn0FJLE", "()I", "intParamName", "", "parameter", "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class TrimParentValues extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.TrimParentValues INSTANCE;
        static {
            Operation.TrimParentValues trimParentValues = new Operation.TrimParentValues();
            Operation.TrimParentValues.INSTANCE = trimParentValues;
        }

        private TrimParentValues() {
            super(1, 0, 2, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            int slotIndex$iv;
            Object obj;
            int i;
            int i2;
            int i3;
            androidx.compose.runtime.RememberObserver wrapped;
            int i4;
            Object obj4;
            Object obj2 = this;
            int i5 = 0;
            int int-w8GmfQM = $this$execute.getInt-w8GmfQM(Operation.IntParameter.constructor-impl(0));
            int parent = slots.getParent();
            final SlotWriter writer = slots;
            final int i7 = 0;
            final int slotsEndIndex$runtime_release = writer.slotsEndIndex$runtime_release(parent);
            slotIndex$iv = Math.max(writer.slotsStartIndex$runtime_release(parent), slotsEndIndex$runtime_release - int-w8GmfQM);
            while (slotIndex$iv < slotsEndIndex$runtime_release) {
                obj = SlotWriter.access$getSlots$p(writer)[SlotWriter.access$dataIndexToDataAddress(writer, slotIndex$iv)];
                i2 = 0;
                if (obj instanceof RememberObserverHolder) {
                } else {
                }
                obj4 = rememberManager;
                if (obj instanceof RecomposeScopeImpl) {
                }
                slotIndex$iv++;
                (RecomposeScopeImpl)obj.release();
                i4 = -1;
                rememberManager.forgetting((RememberObserverHolder)obj.getWrapped(), slotsSize - i, i4, i4);
            }
            Object obj5 = rememberManager;
            slots.trimTailSlots(int-w8GmfQM);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getCount-jn0FJLE() {
            final int i = 0;
            return Operation.IntParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName-w8GmfQM(int parameter) {
            String intParamName-w8GmfQM;
            Object obj = this;
            final int i = 0;
            if (Operation.IntParameter.equals-impl0(parameter, Operation.IntParameter.constructor-impl(0))) {
                intParamName-w8GmfQM = "count";
            } else {
                intParamName-w8GmfQM = super.intParamName-w8GmfQM(parameter);
            }
            return intParamName-w8GmfQM;
        }
    }

    @Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u0012J\u001e\u0010\u0013\u001a\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0014\u0010\u0012J(\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\n\u0010\u0018\u001a\u0006\u0012\u0002\u0008\u00030\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016R\u001e\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u0018\u0010\u0008\u001a\u00020\t8Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0007R \u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000c0\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001e", d2 = {"Landroidx/compose/runtime/changelist/Operation$UpdateAnchoredValue;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Anchor", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Landroidx/compose/runtime/Anchor;", "getAnchor-HpuvwBQ", "()I", "GroupSlotIndex", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "getGroupSlotIndex-jn0FJLE", "Value", "", "getValue-HpuvwBQ", "intParamName", "", "parameter", "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "objectParamName", "objectParamName-31yXWZQ", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class UpdateAnchoredValue extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.UpdateAnchoredValue INSTANCE;
        static {
            Operation.UpdateAnchoredValue updateAnchoredValue = new Operation.UpdateAnchoredValue();
            Operation.UpdateAnchoredValue.INSTANCE = updateAnchoredValue;
        }

        private UpdateAnchoredValue() {
            super(1, 2, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            boolean wrapped2;
            boolean wrapped;
            boolean i2;
            Anchor after;
            Object obj8;
            int i;
            int priority$iv;
            int endRelativeAfter$iv;
            boolean slotsSize;
            int slotsEndAllIndex$runtime_release;
            int i3;
            Object obj;
            Object obj2 = $this$execute;
            final Object obj3 = slots;
            final Object obj4 = rememberManager;
            androidx.compose.runtime.changelist.Operation.UpdateAnchoredValue iNSTANCE = Operation.UpdateAnchoredValue.INSTANCE;
            int i4 = 0;
            int i5 = 0;
            Object object-31yXWZQ = obj2.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(i5));
            androidx.compose.runtime.changelist.Operation.UpdateAnchoredValue iNSTANCE2 = Operation.UpdateAnchoredValue.INSTANCE;
            int i6 = 0;
            androidx.compose.runtime.changelist.Operation.UpdateAnchoredValue iNSTANCE3 = Operation.UpdateAnchoredValue.INSTANCE;
            int i8 = 0;
            int int-w8GmfQM = obj2.getInt-w8GmfQM(Operation.IntParameter.constructor-impl(i5));
            if (object-31yXWZQ instanceof RememberObserverHolder) {
                obj4.remembering((RememberObserverHolder)object-31yXWZQ.getWrapped());
            }
            int anchorIndex = obj3.anchorIndex((Anchor)obj2.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(1)));
            Object obj6 = obj3.set(anchorIndex, int-w8GmfQM, object-31yXWZQ);
            if (obj6 instanceof RememberObserverHolder) {
                after = (RememberObserverHolder)obj6.getAfter();
                obj8 = slots;
                i = 0;
                priority$iv = -1;
                endRelativeAfter$iv = -1;
                if (after != null && after.getValid()) {
                    if (after.getValid()) {
                        endRelativeAfter$iv = slotsSize - slotsEndAllIndex$runtime_release;
                    }
                }
                i3 = 0;
                obj4.forgetting((RememberObserverHolder)obj6.getWrapped(), slotsSize2 -= slotIndexOfGroupSlotIndex, priority$iv, endRelativeAfter$iv);
            } else {
                if (obj6 instanceof RecomposeScopeImpl) {
                    (RecomposeScopeImpl)obj6.release();
                }
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getAnchor-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getGroupSlotIndex-jn0FJLE() {
            final int i = 0;
            return Operation.IntParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getValue-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName-w8GmfQM(int parameter) {
            String intParamName-w8GmfQM;
            androidx.compose.runtime.changelist.Operation.UpdateAnchoredValue iNSTANCE = Operation.UpdateAnchoredValue.INSTANCE;
            final int i = 0;
            if (Operation.IntParameter.equals-impl0(parameter, Operation.IntParameter.constructor-impl(0))) {
                intParamName-w8GmfQM = "groupSlotIndex";
            } else {
                intParamName-w8GmfQM = super.intParamName-w8GmfQM(parameter);
            }
            return intParamName-w8GmfQM;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            int i2;
            int i;
            androidx.compose.runtime.changelist.Operation.UpdateAnchoredValue iNSTANCE = Operation.UpdateAnchoredValue.INSTANCE;
            i2 = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "value";
            } else {
                androidx.compose.runtime.changelist.Operation.UpdateAnchoredValue iNSTANCE2 = Operation.UpdateAnchoredValue.INSTANCE;
                i2 = 0;
                if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(1))) {
                    objectParamName-31yXWZQ = "anchor";
                } else {
                    objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
                }
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0008\u001a\u00020\t2\n\u0010\n\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u000cJ(\u0010\r\u001a\u00020\u000e*\u00020\u000f2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R \u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0016", d2 = {"Landroidx/compose/runtime/changelist/Operation$UpdateAuxData;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Data", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "", "getData-HpuvwBQ", "()I", "objectParamName", "", "parameter", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class UpdateAuxData extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.UpdateAuxData INSTANCE;
        static {
            Operation.UpdateAuxData updateAuxData = new Operation.UpdateAuxData();
            Operation.UpdateAuxData.INSTANCE = updateAuxData;
        }

        private UpdateAuxData() {
            final int i = 1;
            super(0, i, i, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            final int i = 0;
            slots.updateAux($this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getData-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            Object obj = this;
            final int i = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "data";
            } else {
                objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0010\u0010\u0011J(\u0010\u0012\u001a\u00020\u0007*\u00020\u00132\n\u0010\u0014\u001a\u0006\u0012\u0002\u0008\u00030\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016R9\u0010\u0003\u001a#\u0012\u001f\u0012\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0008\u00080\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR \u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\n\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001a", d2 = {"Landroidx/compose/runtime/changelist/Operation$UpdateNode;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Block", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "Lkotlin/Function2;", "", "", "Lkotlin/ExtensionFunctionType;", "getBlock-HpuvwBQ", "()I", "Value", "getValue-HpuvwBQ", "objectParamName", "", "parameter", "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "execute", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class UpdateNode extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.UpdateNode INSTANCE;
        static {
            Operation.UpdateNode updateNode = new Operation.UpdateNode();
            Operation.UpdateNode.INSTANCE = updateNode;
        }

        private UpdateNode() {
            super(0, 2, 1, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Object obj = this;
            int i = 0;
            Object obj2 = this;
            int i3 = 0;
            (Function2)$this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(1)).invoke(applier.getCurrent(), $this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getBlock-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(1);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getValue-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            int i;
            int i2;
            Object obj = this;
            i = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "value";
            } else {
                Object obj2 = this;
                i = 0;
                if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(1))) {
                    objectParamName-31yXWZQ = "block";
                } else {
                    objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
                }
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u000fJ\u001e\u0010\u0010\u001a\u00020\u000c2\n\u0010\r\u001a\u0006\u0012\u0002\u0008\u00030\u0008H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\u0011\u0010\u000fJ(\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\n\u0010\u0015\u001a\u0006\u0012\u0002\u0008\u00030\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016R\u0018\u0010\u0003\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R \u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00088Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u001b", d2 = {"Landroidx/compose/runtime/changelist/Operation$UpdateValue;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "GroupSlotIndex", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "getGroupSlotIndex-jn0FJLE", "()I", "Value", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "", "getValue-HpuvwBQ", "intParamName", "", "parameter", "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "objectParamName", "objectParamName-31yXWZQ", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class UpdateValue extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.UpdateValue INSTANCE;
        static {
            Operation.UpdateValue updateValue = new Operation.UpdateValue();
            Operation.UpdateValue.INSTANCE = updateValue;
        }

        private UpdateValue() {
            final int i = 1;
            super(i, i, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            boolean wrapped;
            int i2;
            androidx.compose.runtime.RememberObserver wrapped2;
            int i;
            Object obj = this;
            int i3 = 0;
            int i4 = 0;
            Object object-31yXWZQ = $this$execute.getObject-31yXWZQ(Operation.ObjectParameter.constructor-impl(i4));
            Object obj2 = this;
            int i5 = 0;
            int int-w8GmfQM = $this$execute.getInt-w8GmfQM(Operation.IntParameter.constructor-impl(i4));
            if (object-31yXWZQ instanceof RememberObserverHolder) {
                rememberManager.remembering((RememberObserverHolder)object-31yXWZQ.getWrapped());
            }
            Object obj4 = slots.set(int-w8GmfQM, object-31yXWZQ);
            if (obj4 instanceof RememberObserverHolder) {
                i = -1;
                rememberManager.forgetting((RememberObserverHolder)obj4.getWrapped(), slotsSize -= slotIndexOfGroupSlotIndex, i, i);
            } else {
                if (obj4 instanceof RecomposeScopeImpl) {
                    (RecomposeScopeImpl)obj4.release();
                }
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getGroupSlotIndex-jn0FJLE() {
            final int i = 0;
            return Operation.IntParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getValue-HpuvwBQ() {
            final int i = 0;
            return Operation.ObjectParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName-w8GmfQM(int parameter) {
            String intParamName-w8GmfQM;
            Object obj = this;
            final int i = 0;
            if (Operation.IntParameter.equals-impl0(parameter, Operation.IntParameter.constructor-impl(0))) {
                intParamName-w8GmfQM = "groupSlotIndex";
            } else {
                intParamName-w8GmfQM = super.intParamName-w8GmfQM(parameter);
            }
            return intParamName-w8GmfQM;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String objectParamName-31yXWZQ(int parameter) {
            String objectParamName-31yXWZQ;
            Object obj = this;
            final int i = 0;
            if (Operation.ObjectParameter.equals-impl0(parameter, Operation.ObjectParameter.constructor-impl(0))) {
                objectParamName-31yXWZQ = "value";
            } else {
                objectParamName-31yXWZQ = super.objectParamName-31yXWZQ(parameter);
            }
            return objectParamName-31yXWZQ;
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\u0008\n\u0010\u000bJ(\u0010\u000c\u001a\u00020\r*\u00020\u000e2\n\u0010\u000f\u001a\u0006\u0012\u0002\u0008\u00030\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0018\u0010\u0003\u001a\u00020\u00048Æ\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006\u0015", d2 = {"Landroidx/compose/runtime/changelist/Operation$Ups;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "Count", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "getCount-jn0FJLE", "()I", "intParamName", "", "parameter", "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Ups extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.Ups INSTANCE;
        static {
            Operation.Ups ups = new Operation.Ups();
            Operation.Ups.INSTANCE = ups;
        }

        private Ups() {
            super(1, 0, 2, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            int i;
            int i2;
            int i3;
            Object obj = this;
            i = 0;
            while (i2 < $this$execute.getInt-w8GmfQM(Operation.IntParameter.constructor-impl(0))) {
                i = i2;
                i3 = 0;
                applier.up();
                i2++;
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public final int getCount-jn0FJLE() {
            final int i = 0;
            return Operation.IntParameter.constructor-impl(0);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public String intParamName-w8GmfQM(int parameter) {
            String intParamName-w8GmfQM;
            Object obj = this;
            final int i = 0;
            if (Operation.IntParameter.equals-impl0(parameter, Operation.IntParameter.constructor-impl(0))) {
                intParamName-w8GmfQM = "count";
            } else {
                intParamName-w8GmfQM = super.intParamName-w8GmfQM(parameter);
            }
            return intParamName-w8GmfQM;
        }
    }

    @Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\u0008\u00030\u00072\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\u000c", d2 = {"Landroidx/compose/runtime/changelist/Operation$UseCurrentNode;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", "", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class UseCurrentNode extends androidx.compose.runtime.changelist.Operation {

        public static final int $stable;
        public static final androidx.compose.runtime.changelist.Operation.UseCurrentNode INSTANCE;
        static {
            Operation.UseCurrentNode useCurrentNode = new Operation.UseCurrentNode();
            Operation.UseCurrentNode.INSTANCE = useCurrentNode;
        }

        private UseCurrentNode() {
            final int i3 = 0;
            super(i3, i3, 3, 0);
        }

        public void execute(androidx.compose.runtime.changelist.OperationArgContainer $this$execute, Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            final Object current = applier.getCurrent();
            Intrinsics.checkNotNull(current, "null cannot be cast to non-null type androidx.compose.runtime.ComposeNodeLifecycleCallback");
            (ComposeNodeLifecycleCallback)current.onReuse();
        }
    }
    static {
    }

    private Operation(int ints, int objects) {
        super();
        this.ints = ints;
        this.objects = objects;
    }

    public Operation(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        int obj3;
        final int i4 = 0;
        obj2 = i3 & 1 != 0 ? i4 : obj2;
        obj3 = i3 &= 2 != 0 ? i4 : obj3;
        super(obj2, obj3, 0);
    }

    public Operation(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(i, i2);
    }

    public abstract void execute(androidx.compose.runtime.changelist.OperationArgContainer operationArgContainer, Applier<?> applier2, SlotWriter slotWriter3, RememberManager rememberManager4);

    public final int getInts() {
        return this.ints;
    }

    public final String getName() {
        String simpleName;
        if (Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() == null) {
            simpleName = "";
        }
        return simpleName;
    }

    public final int getObjects() {
        return this.objects;
    }

    public String intParamName-w8GmfQM(int parameter) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("IntParameter(").append(parameter).append(')').toString();
    }

    public String objectParamName-31yXWZQ(int parameter) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ObjectParameter(").append(parameter).append(')').toString();
    }

    public String toString() {
        return getName();
    }
}
