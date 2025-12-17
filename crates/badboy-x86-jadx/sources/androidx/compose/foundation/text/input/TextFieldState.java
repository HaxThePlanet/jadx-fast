package androidx.compose.foundation.text.input;

import androidx.compose.foundation.text.input.internal.ChangeTracker;
import androidx.compose.foundation.text.input.internal.EditingBuffer;
import androidx.compose.foundation.text.input.internal.undo.TextFieldEditUndoBehavior;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.Snapshot.Companion;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\r\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u000f\u0008\u0007\u0018\u00002\u00020\u0001:\u0002]^B\u001b\u0008\u0016\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\u0008\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\u0015\u00106\u001a\u0002072\u0006\u00108\u001a\u00020\u001fH\u0000¢\u0006\u0002\u00089J\u0010\u0010:\u001a\u0002072\u0006\u0010;\u001a\u00020<H\u0001J&\u0010=\u001a\u0002072\u0008\u0010>\u001a\u0004\u0018\u00010?2\u0008\u0008\u0002\u0010@\u001a\u00020\u000e2\u0008\u0008\u0002\u0010A\u001a\u00020BH\u0002J\"\u0010C\u001a\u0002072\u0017\u0010D\u001a\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u0002070E¢\u0006\u0002\u0008FH\u0086\u0008JE\u0010G\u001a\u0002072\u0008\u0010>\u001a\u0004\u0018\u00010?2\u0008\u0008\u0002\u0010@\u001a\u00020\u000e2\u0008\u0008\u0002\u0010A\u001a\u00020B2\u0017\u0010D\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002070E¢\u0006\u0002\u0008FH\u0080\u0008¢\u0006\u0002\u0008HJ'\u0010I\u001a\u0002072\u0017\u0010D\u001a\u0013\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u0002070E¢\u0006\u0002\u0008FH\u0080\u0008¢\u0006\u0002\u0008JJ\u0008\u0010K\u001a\u000207H\u0001J(\u0010L\u001a\u0002072\u0006\u0010M\u001a\u00020/2\u0006\u0010N\u001a\u00020/2\u0006\u0010O\u001a\u00020P2\u0006\u0010A\u001a\u00020BH\u0002J\u0015\u0010Q\u001a\u0002072\u0006\u00108\u001a\u00020\u001fH\u0000¢\u0006\u0002\u0008RJ\u0008\u0010S\u001a\u00020<H\u0001J2\u0010T\u001a\u0002072\u0006\u0010U\u001a\u00020<2\u0008\u0010V\u001a\u0004\u0018\u00010\u00052\u0006\u0010W\u001a\u00020\u000e2\u0006\u0010X\u001a\u00020\u000eH\u0001ø\u0001\u0000¢\u0006\u0002\u0008YJ\u0008\u0010Z\u001a\u00020\u0003H\u0016J \u0010[\u001a\u0002072\u0006\u0010\\\u001a\u00020/2\u0006\u0010;\u001a\u00020/2\u0006\u0010@\u001a\u00020\u000eH\u0002R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR+\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000e8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u000f\u0010\u0010\"\u0004\u0008\u0011\u0010\u0012R$\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\u0008\u0017\u0010\u0018\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010 \u001a\u00020\u00058Fø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\u0008%\u0010&R\u0014\u0010'\u001a\u00020\u0008X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u001c\u0010*\u001a\u00020+8GX\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008,\u0010\u0018\u001a\u0004\u0008-\u0010.R+\u00100\u001a\u00020/2\u0006\u0010\r\u001a\u00020/8@@BX\u0080\u008e\u0002¢\u0006\u0012\n\u0004\u00085\u0010\u0014\u001a\u0004\u00081\u00102\"\u0004\u00083\u00104\u0082\u0002\u000b\n\u0005\u0008¡\u001e0\u0001\n\u0002\u0008!¨\u0006_", d2 = {"Landroidx/compose/foundation/text/input/TextFieldState;", "", "initialText", "", "initialSelection", "Landroidx/compose/ui/text/TextRange;", "(Ljava/lang/String;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "initialTextUndoManager", "Landroidx/compose/foundation/text/input/TextUndoManager;", "(Ljava/lang/String;JLandroidx/compose/foundation/text/input/TextUndoManager;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "composition", "getComposition-MzsxiRA", "()Landroidx/compose/ui/text/TextRange;", "<set-?>", "", "isEditing", "()Z", "setEditing", "(Z)V", "isEditing$delegate", "Landroidx/compose/runtime/MutableState;", "mainBuffer", "Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "getMainBuffer$foundation_release$annotations", "()V", "getMainBuffer$foundation_release", "()Landroidx/compose/foundation/text/input/internal/EditingBuffer;", "setMainBuffer$foundation_release", "(Landroidx/compose/foundation/text/input/internal/EditingBuffer;)V", "notifyImeListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "selection", "getSelection-d9O1mEE", "()J", "text", "", "getText", "()Ljava/lang/CharSequence;", "textUndoManager", "getTextUndoManager$foundation_release", "()Landroidx/compose/foundation/text/input/TextUndoManager;", "undoState", "Landroidx/compose/foundation/text/input/UndoState;", "getUndoState$annotations", "getUndoState", "()Landroidx/compose/foundation/text/input/UndoState;", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "value", "getValue$foundation_release", "()Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "setValue", "(Landroidx/compose/foundation/text/input/TextFieldCharSequence;)V", "value$delegate", "addNotifyImeListener", "", "notifyImeListener", "addNotifyImeListener$foundation_release", "commitEdit", "newValue", "Landroidx/compose/foundation/text/input/TextFieldBuffer;", "commitEditAsUser", "inputTransformation", "Landroidx/compose/foundation/text/input/InputTransformation;", "restartImeIfContentChanges", "undoBehavior", "Landroidx/compose/foundation/text/input/internal/undo/TextFieldEditUndoBehavior;", "edit", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "editAsUser", "editAsUser$foundation_release", "editWithNoSideEffects", "editWithNoSideEffects$foundation_release", "finishEditing", "recordEditForUndo", "previousValue", "postValue", "changes", "Landroidx/compose/foundation/text/input/TextFieldBuffer$ChangeList;", "removeNotifyImeListener", "removeNotifyImeListener$foundation_release", "startEdit", "syncMainBufferToTemporaryBuffer", "textFieldBuffer", "newComposition", "textChanged", "selectionChanged", "syncMainBufferToTemporaryBuffer-TS3Rm5k$foundation_release", "toString", "updateValueAndNotifyListeners", "oldValue", "NotifyImeListener", "Saver", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextFieldState {

    public static final int $stable;
    private final MutableState isEditing$delegate;
    private EditingBuffer mainBuffer;
    private final MutableVector<androidx.compose.foundation.text.input.TextFieldState.NotifyImeListener> notifyImeListeners;
    private final androidx.compose.foundation.text.input.TextUndoManager textUndoManager;
    private final androidx.compose.foundation.text.input.UndoState undoState;
    private final MutableState value$delegate;

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\u0008à\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0008H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\tÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/text/input/TextFieldState$NotifyImeListener;", "", "onChange", "", "oldValue", "Landroidx/compose/foundation/text/input/TextFieldCharSequence;", "newValue", "restartImeIfContentChanges", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface NotifyImeListener {
        public abstract void onChange(androidx.compose.foundation.text.input.TextFieldCharSequence textFieldCharSequence, androidx.compose.foundation.text.input.TextFieldCharSequence textFieldCharSequence2, boolean z3);
    }

    @Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u0008Ç\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0003H\u0016J\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003*\u00020\u00082\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\t", d2 = {"Landroidx/compose/foundation/text/input/TextFieldState$Saver;", "Landroidx/compose/runtime/saveable/Saver;", "Landroidx/compose/foundation/text/input/TextFieldState;", "", "()V", "restore", "value", "save", "Landroidx/compose/runtime/saveable/SaverScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Saver implements Saver<androidx.compose.foundation.text.input.TextFieldState, Object> {

        public static final int $stable;
        public static final androidx.compose.foundation.text.input.TextFieldState.Saver INSTANCE;
        static {
            TextFieldState.Saver saver = new TextFieldState.Saver();
            TextFieldState.Saver.INSTANCE = saver;
        }

        @Override // androidx.compose.runtime.saveable.Saver
        public androidx.compose.foundation.text.input.TextFieldState restore(Object value) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<*>");
            Object obj = value;
            Object obj3 = (List)obj.get(0);
            Object obj4 = obj.get(1);
            Object obj5 = obj.get(2);
            Object obj2 = obj.get(3);
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            String str3 = "null cannot be cast to non-null type kotlin.Int";
            Intrinsics.checkNotNull(obj4, str3);
            Intrinsics.checkNotNull(obj5, str3);
            int i5 = 0;
            Intrinsics.checkNotNull(obj2);
            final androidx.compose.foundation.text.input.TextUndoManager restore = TextUndoManager.Companion.Saver.INSTANCE.restore(obj2);
            Intrinsics.checkNotNull(restore);
            TextFieldState textFieldState = new TextFieldState((String)obj3, TextRangeKt.TextRange((Integer)obj4.intValue(), (Integer)obj5.intValue()), obj8, restore, 0);
            return textFieldState;
        }

        @Override // androidx.compose.runtime.saveable.Saver
        public Object restore(Object value) {
            return restore(value);
        }

        @Override // androidx.compose.runtime.saveable.Saver
        public Object save(SaverScope $this$save, androidx.compose.foundation.text.input.TextFieldState value) {
            final int i = 0;
            return CollectionsKt.listOf(/* result */);
        }

        @Override // androidx.compose.runtime.saveable.Saver
        public Object save(SaverScope $this$save, Object value) {
            return save($this$save, (TextFieldState)value);
        }
    }

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal3;
            int ordinal;
            int ordinal2;
            int[] iArr = new int[values.length];
            iArr[TextFieldEditUndoBehavior.ClearHistory.ordinal()] = 1;
            iArr[TextFieldEditUndoBehavior.MergeIfPossible.ordinal()] = 2;
            iArr[TextFieldEditUndoBehavior.NeverMerge.ordinal()] = 3;
            TextFieldState.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
    }

    private TextFieldState(String initialText, long initialSelection) {
        int i = 0;
        TextUndoManager textUndoManager = new TextUndoManager(i, i, 3, i);
        super(initialText, initialSelection, obj3, textUndoManager, 0);
    }

    public TextFieldState(String string, long l2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        String obj1;
        long obj2;
        obj1 = defaultConstructorMarker4 & 1 != 0 ? "" : obj1;
        if (defaultConstructorMarker4 &= 2 != 0) {
            obj2 = TextRangeKt.TextRange(obj1.length());
        }
        super(obj1, obj2, i3, 0);
    }

    private TextFieldState(String initialText, long initialSelection, androidx.compose.foundation.text.input.TextUndoManager initialTextUndoManager) {
        super();
        this.textUndoManager = obj17;
        final int i4 = 0;
        long l = initialSelection;
        int i2 = 0;
        EditingBuffer editingBuffer = new EditingBuffer(initialText, TextRangeKt.coerceIn-8ffj60Q(l, obj7, i4), obj5, i2);
        this.mainBuffer = editingBuffer;
        final int i10 = 2;
        this.isEditing$delegate = SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(i4), i2, i10, i2);
        TextFieldCharSequence textFieldCharSequence = new TextFieldCharSequence((CharSequence)initialText, l, obj7, 0, 0, 12, 0);
        this.value$delegate = SnapshotStateKt.mutableStateOf$default(textFieldCharSequence, i2, i10, i2);
        UndoState undoState = new UndoState(this);
        this.undoState = undoState;
        int i = 0;
        int i5 = 0;
        MutableVector mutableVector = new MutableVector(new TextFieldState.NotifyImeListener[16], i4);
        this.notifyImeListeners = mutableVector;
    }

    public TextFieldState(String string, long l2, androidx.compose.foundation.text.input.TextUndoManager textUndoManager3, DefaultConstructorMarker defaultConstructorMarker4) {
        super(string, l2, textUndoManager3, defaultConstructorMarker4);
    }

    public TextFieldState(String string, long l2, DefaultConstructorMarker defaultConstructorMarker3) {
        super(string, l2, defaultConstructorMarker3);
    }

    public static final void access$commitEditAsUser(androidx.compose.foundation.text.input.TextFieldState $this, androidx.compose.foundation.text.input.InputTransformation inputTransformation, boolean restartImeIfContentChanges, TextFieldEditUndoBehavior undoBehavior) {
        $this.commitEditAsUser(inputTransformation, restartImeIfContentChanges, undoBehavior);
    }

    public static final void access$updateValueAndNotifyListeners(androidx.compose.foundation.text.input.TextFieldState $this, androidx.compose.foundation.text.input.TextFieldCharSequence oldValue, androidx.compose.foundation.text.input.TextFieldCharSequence newValue, boolean restartImeIfContentChanges) {
        $this.updateValueAndNotifyListeners(oldValue, newValue, restartImeIfContentChanges);
    }

    private final void commitEditAsUser(androidx.compose.foundation.text.input.InputTransformation inputTransformation, boolean restartImeIfContentChanges, TextFieldEditUndoBehavior undoBehavior) {
        int changeCount;
        boolean value$foundation_release;
        Object composition-MzsxiRA4;
        EditingBuffer mainBuffer;
        long textFieldCharSequence;
        androidx.compose.foundation.text.input.TextFieldCharSequence textFieldCharSequence-udt6zUU$foundation_release$default;
        String str;
        long selection-d9O1mEE;
        TextRange composition-MzsxiRA;
        int composition-MzsxiRA2;
        int composition-MzsxiRA3;
        kotlin.Pair highlight;
        int i;
        final androidx.compose.foundation.text.input.TextFieldCharSequence value$foundation_release2 = getValue$foundation_release();
        if (this.mainBuffer.getChangeTracker().getChangeCount() == 0 && TextRange.equals-impl0(value$foundation_release2.getSelection-d9O1mEE(), obj1)) {
            if (TextRange.equals-impl0(value$foundation_release2.getSelection-d9O1mEE(), obj1)) {
                if (Intrinsics.areEqual(value$foundation_release2.getComposition-MzsxiRA(), this.mainBuffer.getComposition-MzsxiRA())) {
                    if (!Intrinsics.areEqual(value$foundation_release2.getHighlight(), this.mainBuffer.getHighlight())) {
                        textFieldCharSequence = new TextFieldCharSequence((CharSequence)this.mainBuffer.toString(), this.mainBuffer.getSelection-d9O1mEE(), obj7, this.mainBuffer.getComposition-MzsxiRA(), this.mainBuffer.getHighlight(), 0);
                        updateValueAndNotifyListeners(getValue$foundation_release(), textFieldCharSequence, restartImeIfContentChanges);
                    }
                } else {
                }
            }
        }
        super((CharSequence)this.mainBuffer.toString(), this.mainBuffer.getSelection-d9O1mEE(), obj8, this.mainBuffer.getComposition-MzsxiRA(), this.mainBuffer.getHighlight(), 0);
        if (inputTransformation == null) {
            updateValueAndNotifyListeners(value$foundation_release2, textFieldCharSequence2, restartImeIfContentChanges);
            recordEditForUndo(value$foundation_release2, textFieldCharSequence2, (TextFieldBuffer.ChangeList)this.mainBuffer.getChangeTracker(), undoBehavior);
        }
        int i8 = 0;
        TextFieldBuffer textFieldBuffer = new TextFieldBuffer(textFieldCharSequence2, this.mainBuffer.getChangeTracker(), value$foundation_release2, 0, 8, i8);
        androidx.compose.foundation.text.input.TextFieldBuffer field2 = textFieldBuffer;
        int i3 = 0;
        inputTransformation.transformInput(field2);
        contentEquals ^= 1;
        equals-impl0 ^= 1;
        if (i2 == 0) {
            if (i4 != 0) {
                syncMainBufferToTemporaryBuffer-TS3Rm5k$foundation_release(field2, 0, i2, i4);
            } else {
                updateValueAndNotifyListeners(value$foundation_release2, TextFieldBuffer.toTextFieldCharSequence-udt6zUU$foundation_release$default(field2, 0, i8, textFieldCharSequence2.getComposition-MzsxiRA(), 1), restartImeIfContentChanges);
            }
        } else {
        }
        recordEditForUndo(value$foundation_release2, getValue$foundation_release(), field2.getChanges(), undoBehavior);
    }

    static void commitEditAsUser$default(androidx.compose.foundation.text.input.TextFieldState textFieldState, androidx.compose.foundation.text.input.InputTransformation inputTransformation2, boolean z3, TextFieldEditUndoBehavior textFieldEditUndoBehavior4, int i5, Object object6) {
        int obj2;
        TextFieldEditUndoBehavior obj3;
        if (i5 & 2 != 0) {
            obj2 = 1;
        }
        if (i5 &= 4 != 0) {
            obj3 = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        textFieldState.commitEditAsUser(inputTransformation2, obj2, obj3);
    }

    public static void editAsUser$foundation_release$default(androidx.compose.foundation.text.input.TextFieldState $this, androidx.compose.foundation.text.input.InputTransformation inputTransformation, boolean restartImeIfContentChanges, TextFieldEditUndoBehavior undoBehavior, Function1 block, int i6, Object object7) {
        int obj2;
        TextFieldEditUndoBehavior obj3;
        if (i6 & 2 != 0) {
            obj2 = 1;
        }
        if (i6 &= 4 != 0) {
            obj3 = TextFieldEditUndoBehavior.MergeIfPossible;
        }
        int obj5 = 0;
        $this.getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        block.invoke($this.getMainBuffer$foundation_release());
        TextFieldState.access$commitEditAsUser($this, inputTransformation, obj2, obj3);
    }

    public static void getMainBuffer$foundation_release$annotations() {
    }

    public static void getUndoState$annotations() {
    }

    private final boolean isEditing() {
        final int i = 0;
        final int i2 = 0;
        return (Boolean)(State)this.isEditing$delegate.getValue().booleanValue();
    }

    private final void recordEditForUndo(androidx.compose.foundation.text.input.TextFieldCharSequence previousValue, androidx.compose.foundation.text.input.TextFieldCharSequence postValue, androidx.compose.foundation.text.input.TextFieldBuffer.ChangeList changes, TextFieldEditUndoBehavior undoBehavior) {
        androidx.compose.foundation.text.input.TextUndoManager textUndoManager;
        int ordinal;
        switch (textUndoManager) {
            case 1:
                this.textUndoManager.clearHistory();
                break;
            case 2:
                TextUndoManagerKt.recordChanges(this.textUndoManager, previousValue, postValue, changes, true);
                break;
            case 3:
                TextUndoManagerKt.recordChanges(this.textUndoManager, previousValue, postValue, changes, false);
                break;
            default:
        }
    }

    private final void setEditing(boolean <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.isEditing$delegate.setValue(Boolean.valueOf(<set-?>));
    }

    private final void setValue(androidx.compose.foundation.text.input.TextFieldCharSequence <set-?>) {
        final int i = 0;
        final int i2 = 0;
        this.value$delegate.setValue(<set-?>);
    }

    private final void updateValueAndNotifyListeners(androidx.compose.foundation.text.input.TextFieldCharSequence oldValue, androidx.compose.foundation.text.input.TextFieldCharSequence newValue, boolean restartImeIfContentChanges) {
        int i$iv;
        Object[] content;
        Object obj;
        int i;
        setValue(newValue);
        finishEditing();
        final MutableVector notifyImeListeners = this.notifyImeListeners;
        final int i2 = 0;
        final int size = notifyImeListeners.getSize();
        if (size > 0) {
            i$iv = 0;
            i = 0;
            (TextFieldState.NotifyImeListener)notifyImeListeners.getContent()[i$iv].onChange(oldValue, newValue, restartImeIfContentChanges);
            while (i$iv++ >= size) {
                i = 0;
                (TextFieldState.NotifyImeListener)content[i$iv].onChange(oldValue, newValue, restartImeIfContentChanges);
            }
        }
    }

    public final void addNotifyImeListener$foundation_release(androidx.compose.foundation.text.input.TextFieldState.NotifyImeListener notifyImeListener) {
        this.notifyImeListeners.add(notifyImeListener);
    }

    public final void commitEdit(androidx.compose.foundation.text.input.TextFieldBuffer newValue) {
        int i;
        boolean textUndoManager;
        int i2 = 1;
        i = newValue.getChanges().getChangeCount() > 0 ? i2 : 0;
        if (i != 0) {
            this.textUndoManager.clearHistory();
        }
        syncMainBufferToTemporaryBuffer-TS3Rm5k$foundation_release(newValue, 0, i, i2 ^= textUndoManager);
    }

    public final void edit(Function1<? super androidx.compose.foundation.text.input.TextFieldBuffer, Unit> block) {
        final int i = 0;
        final androidx.compose.foundation.text.input.TextFieldBuffer edit = startEdit();
        block.invoke(edit);
        commitEdit(edit);
        finishEditing();
    }

    public final void editAsUser$foundation_release(androidx.compose.foundation.text.input.InputTransformation inputTransformation, boolean restartImeIfContentChanges, TextFieldEditUndoBehavior undoBehavior, Function1<? super EditingBuffer, Unit> block) {
        final int i = 0;
        getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        block.invoke(getMainBuffer$foundation_release());
        TextFieldState.access$commitEditAsUser(this, inputTransformation, restartImeIfContentChanges, undoBehavior);
    }

    public final void editWithNoSideEffects$foundation_release(Function1<? super EditingBuffer, Unit> block) {
        final int i = 0;
        getMainBuffer$foundation_release().getChangeTracker().clearChanges();
        block.invoke(getMainBuffer$foundation_release());
        TextFieldCharSequence textFieldCharSequence = new TextFieldCharSequence((CharSequence)getMainBuffer$foundation_release().toString(), getMainBuffer$foundation_release().getSelection-d9O1mEE(), obj5, getMainBuffer$foundation_release().getComposition-MzsxiRA(), 0, 8, 0);
        TextFieldState.access$updateValueAndNotifyListeners(this, getValue$foundation_release(), textFieldCharSequence, true);
    }

    public final void finishEditing() {
        setEditing(false);
    }

    public final TextRange getComposition-MzsxiRA() {
        return getValue$foundation_release().getComposition-MzsxiRA();
    }

    public final EditingBuffer getMainBuffer$foundation_release() {
        return this.mainBuffer;
    }

    public final long getSelection-d9O1mEE() {
        return getValue$foundation_release().getSelection-d9O1mEE();
    }

    public final java.lang.CharSequence getText() {
        return getValue$foundation_release().getText();
    }

    public final androidx.compose.foundation.text.input.TextUndoManager getTextUndoManager$foundation_release() {
        return this.textUndoManager;
    }

    public final androidx.compose.foundation.text.input.UndoState getUndoState() {
        return this.undoState;
    }

    public final androidx.compose.foundation.text.input.TextFieldCharSequence getValue$foundation_release() {
        final int i = 0;
        final int i2 = 0;
        return (TextFieldCharSequence)(State)this.value$delegate.getValue();
    }

    public final void removeNotifyImeListener$foundation_release(androidx.compose.foundation.text.input.TextFieldState.NotifyImeListener notifyImeListener) {
        this.notifyImeListeners.remove(notifyImeListener);
    }

    public final void setMainBuffer$foundation_release(EditingBuffer <set-?>) {
        this.mainBuffer = <set-?>;
    }

    public final androidx.compose.foundation.text.input.TextFieldBuffer startEdit() {
        int readObserver;
        int i;
        Snapshot.Companion companion = Snapshot.Companion;
        final int i5 = 0;
        final Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        if (currentThreadSnapshot != null) {
            readObserver = currentThreadSnapshot.getReadObserver();
        } else {
            readObserver = 0;
        }
        int i2 = 0;
        companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
        int i3 = 1;
        i = !isEditing() ? i3 : 0;
        if (i == 0) {
        } else {
            setEditing(i3);
            TextFieldBuffer textFieldBuffer = new TextFieldBuffer(getValue$foundation_release(), 0, 0, 0, 14, 0);
            return textFieldBuffer;
        }
        int i4 = 0;
        IllegalStateException $i$a$CheckTextFieldState$startEdit$1 = new IllegalStateException("TextFieldState does not support concurrent or nested editing.".toString());
        throw $i$a$CheckTextFieldState$startEdit$1;
    }

    public final void syncMainBufferToTemporaryBuffer-TS3Rm5k$foundation_release(androidx.compose.foundation.text.input.TextFieldBuffer textFieldBuffer, TextRange newComposition, boolean textChanged, boolean selectionChanged) {
        Object editingBuffer;
        EditingBuffer mainBuffer;
        String string;
        String composition-MzsxiRA;
        long selection-d9O1mEE;
        int i;
        final Object obj = newComposition;
        String string2 = this.mainBuffer.toString();
        int i4 = 8;
        selection-d9O1mEE = 0;
        TextFieldCharSequence textFieldCharSequence = new TextFieldCharSequence((CharSequence)string2, this.mainBuffer.getSelection-d9O1mEE(), obj5, this.mainBuffer.getComposition-MzsxiRA(), selection-d9O1mEE, i4, 0);
        int i3 = 1;
        if (textChanged) {
            editingBuffer = new EditingBuffer(textFieldBuffer.toString(), textFieldBuffer.getSelection-d9O1mEE(), i4, 0);
            this.mainBuffer = editingBuffer;
        } else {
            if (selectionChanged) {
                this.mainBuffer.setSelection(TextRange.getStart-impl(textFieldBuffer.getSelection-d9O1mEE()), TextRange.getEnd-impl(textFieldBuffer.getSelection-d9O1mEE()));
            }
        }
        if (obj != null) {
            if (TextRange.getCollapsed-impl(obj.unbox-impl())) {
                this.mainBuffer.commitComposition();
            } else {
                this.mainBuffer.setComposition(TextRange.getMin-impl(obj.unbox-impl()), TextRange.getMax-impl(obj.unbox-impl()));
            }
        } else {
        }
        if (!textChanged) {
            if (!selectionChanged && equal ^= i3 != 0) {
                if (equal ^= i3 != 0) {
                    this.mainBuffer.commitComposition();
                }
            }
        } else {
        }
        if (textChanged) {
            string = textFieldBuffer.toString();
        } else {
            string = string2;
        }
        TextFieldCharSequence textFieldCharSequence2 = new TextFieldCharSequence((CharSequence)string, this.mainBuffer.getSelection-d9O1mEE(), i, this.mainBuffer.getComposition-MzsxiRA(), 0, 8, 0);
        updateValueAndNotifyListeners(textFieldCharSequence, textFieldCharSequence2, i3);
    }

    public String toString() {
        Function1 readObserver;
        final Snapshot.Companion companion = Snapshot.Companion;
        final int i = 0;
        final Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        if (currentThreadSnapshot != null) {
            readObserver = currentThreadSnapshot.getReadObserver();
        } else {
            readObserver = 0;
        }
        final int i2 = 0;
        StringBuilder stringBuilder = new StringBuilder();
        companion.restoreNonObservable(currentThreadSnapshot, companion.makeCurrentNonObservable(currentThreadSnapshot), readObserver);
        return stringBuilder.append("TextFieldState(selection=").append(TextRange.toString-impl(getSelection-d9O1mEE())).append(", text=\"").append(getText()).append("\")").toString();
    }
}
