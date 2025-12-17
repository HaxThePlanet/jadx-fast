package androidx.compose.ui.focus;

import android.view.KeyEvent;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008`\u0018\u00002\u00020\u0001J2\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0014H&ø\u0001\u0000¢\u0006\u0004\u0008\u0015\u0010\u0016J\u001a\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H&ø\u0001\u0000¢\u0006\u0004\u0008\u001a\u0010\u001bJ*\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u00192\u000e\u0008\u0002\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u001eH&ø\u0001\u0000¢\u0006\u0004\u0008\u001f\u0010 J\u0010\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#H&J:\u0010$\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u000f0(H&ø\u0001\u0000¢\u0006\u0004\u0008*\u0010+J\n\u0010,\u001a\u0004\u0018\u00010&H&J\u0008\u0010-\u001a\u00020.H&J$\u0010/\u001a\u00020\u000f2\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0008\u00100\u001a\u0004\u0018\u00010&H&ø\u0001\u0000¢\u0006\u0002\u00081J\u0010\u00102\u001a\u00020.2\u0006\u00103\u001a\u000204H&J\u0010\u00102\u001a\u00020.2\u0006\u00103\u001a\u000205H&J\u0010\u00102\u001a\u00020.2\u0006\u00103\u001a\u00020)H&J$\u00106\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00142\u0008\u00100\u001a\u0004\u0018\u00010&H&ø\u0001\u0000¢\u0006\u0004\u00087\u00108R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u00069À\u0006\u0001", d2 = {"Landroidx/compose/ui/focus/FocusOwner;", "Landroidx/compose/ui/focus/FocusManager;", "focusTransactionManager", "Landroidx/compose/ui/focus/FocusTransactionManager;", "getFocusTransactionManager", "()Landroidx/compose/ui/focus/FocusTransactionManager;", "modifier", "Landroidx/compose/ui/Modifier;", "getModifier", "()Landroidx/compose/ui/Modifier;", "rootState", "Landroidx/compose/ui/focus/FocusState;", "getRootState", "()Landroidx/compose/ui/focus/FocusState;", "clearFocus", "", "force", "refreshFocusEvents", "clearOwnerFocus", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "clearFocus-I7lrPNg", "(ZZZI)Z", "dispatchInterceptedSoftKeyboardEvent", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "dispatchInterceptedSoftKeyboardEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "dispatchKeyEvent", "onFocusedItem", "Lkotlin/Function0;", "dispatchKeyEvent-YhN2O0w", "(Landroid/view/KeyEvent;Lkotlin/jvm/functions/Function0;)Z", "dispatchRotaryEvent", "event", "Landroidx/compose/ui/input/rotary/RotaryScrollEvent;", "focusSearch", "focusedRect", "Landroidx/compose/ui/geometry/Rect;", "onFound", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusTargetNode;", "focusSearch-ULY8qGw", "(ILandroidx/compose/ui/geometry/Rect;Lkotlin/jvm/functions/Function1;)Ljava/lang/Boolean;", "getFocusRect", "releaseFocus", "", "requestFocusForOwner", "previouslyFocusedRect", "requestFocusForOwner-7o62pno", "scheduleInvalidation", "node", "Landroidx/compose/ui/focus/FocusEventModifierNode;", "Landroidx/compose/ui/focus/FocusPropertiesModifierNode;", "takeFocus", "takeFocus-aToIllA", "(ILandroidx/compose/ui/geometry/Rect;)Z", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FocusOwner extends androidx.compose.ui.focus.FocusManager {
    public static boolean dispatchKeyEvent-YhN2O0w$default(androidx.compose.ui.focus.FocusOwner focusOwner, KeyEvent keyEvent2, Function0 function03, int i4, Object object5) {
        androidx.compose.ui.focus.FocusOwner.dispatchKeyEvent.1 obj2;
        if (object5 != null) {
        } else {
            if (i4 &= 2 != 0) {
                obj2 = FocusOwner.dispatchKeyEvent.1.INSTANCE;
            }
            return focusOwner.dispatchKeyEvent-YhN2O0w(keyEvent2, obj2);
        }
        UnsupportedOperationException obj0 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dispatchKeyEvent-YhN2O0w");
        throw obj0;
    }

    @Override // androidx.compose.ui.focus.FocusManager
    public abstract boolean clearFocus-I7lrPNg(boolean z, boolean z2, boolean z3, int i4);

    @Override // androidx.compose.ui.focus.FocusManager
    public abstract boolean dispatchInterceptedSoftKeyboardEvent-ZmokQxo(KeyEvent keyEvent);

    public abstract boolean dispatchKeyEvent-YhN2O0w(KeyEvent keyEvent, Function0<Boolean> function02);

    @Override // androidx.compose.ui.focus.FocusManager
    public abstract boolean dispatchRotaryEvent(RotaryScrollEvent rotaryScrollEvent);

    public abstract Boolean focusSearch-ULY8qGw(int i, Rect rect2, Function1<? super androidx.compose.ui.focus.FocusTargetNode, Boolean> function13);

    @Override // androidx.compose.ui.focus.FocusManager
    public abstract Rect getFocusRect();

    @Override // androidx.compose.ui.focus.FocusManager
    public abstract androidx.compose.ui.focus.FocusTransactionManager getFocusTransactionManager();

    @Override // androidx.compose.ui.focus.FocusManager
    public abstract Modifier getModifier();

    @Override // androidx.compose.ui.focus.FocusManager
    public abstract androidx.compose.ui.focus.FocusState getRootState();

    @Override // androidx.compose.ui.focus.FocusManager
    public abstract void releaseFocus();

    @Override // androidx.compose.ui.focus.FocusManager
    public abstract boolean requestFocusForOwner-7o62pno(androidx.compose.ui.focus.FocusDirection focusDirection, Rect rect2);

    @Override // androidx.compose.ui.focus.FocusManager
    public abstract void scheduleInvalidation(androidx.compose.ui.focus.FocusEventModifierNode focusEventModifierNode);

    @Override // androidx.compose.ui.focus.FocusManager
    public abstract void scheduleInvalidation(androidx.compose.ui.focus.FocusPropertiesModifierNode focusPropertiesModifierNode);

    @Override // androidx.compose.ui.focus.FocusManager
    public abstract void scheduleInvalidation(androidx.compose.ui.focus.FocusTargetNode focusTargetNode);

    @Override // androidx.compose.ui.focus.FocusManager
    public abstract boolean takeFocus-aToIllA(int i, Rect rect2);
}
