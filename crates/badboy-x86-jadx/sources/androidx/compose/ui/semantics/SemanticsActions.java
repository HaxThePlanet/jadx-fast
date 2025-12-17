package androidx.compose.ui.semantics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR#\u0010\u000c\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\tR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\tR#\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\tR#\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0015\u0010\tR#\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\tR/\u0010\u0018\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\tR/\u0010\u001d\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001e0\u001a\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\tR)\u0010 \u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\"\u0010\tR,\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\tR#\u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010\tR#\u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010\tR#\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008*\u0010\tR#\u0010+\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008,\u0010\tR#\u0010-\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008.\u0010\tR#\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00080\u0010\tR#\u00101\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00082\u0010\tR#\u00103\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00084\u0010\tR.\u00105\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u00086\u0010\u0002\u001a\u0004\u00087\u0010\tR#\u00108\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010\tRM\u0010:\u001a>\u0012:\u00128\u00124\u00122\u0012\u0013\u0012\u00110\u001b¢\u0006\u000c\u0008<\u0012\u0008\u0008=\u0012\u0004\u0008\u0008(>\u0012\u0013\u0012\u00110\u001b¢\u0006\u000c\u0008<\u0012\u0008\u0008=\u0012\u0004\u0008\u0008(?\u0012\u0004\u0012\u00020\u00070;0\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008@\u0010\tRB\u0010A\u001a3\u0012/\u0012-\u0008\u0001\u0012\u0013\u0012\u00110B¢\u0006\u000c\u0008<\u0012\u0008\u0008=\u0012\u0004\u0008\u0008(C\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020B0D\u0012\u0006\u0012\u0004\u0018\u00010\u00010;0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008E\u0010\tR)\u0010F\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008H\u0010\tR8\u0010I\u001a)\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u001b¢\u0006\u000c\u0008<\u0012\u0008\u0008=\u0012\u0004\u0008\u0008(J\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008K\u0010\tR5\u0010L\u001a&\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070M0\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008N\u0010\tR)\u0010O\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008P\u0010\tR)\u0010Q\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008R\u0010\tR)\u0010S\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008T\u0010\t¨\u0006U", d2 = {"Landroidx/compose/ui/semantics/SemanticsActions;", "", "()V", "ClearTextSubstitution", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/AccessibilityAction;", "Lkotlin/Function0;", "", "getClearTextSubstitution", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Collapse", "getCollapse", "CopyText", "getCopyText", "CustomActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "getCustomActions", "CutText", "getCutText", "Dismiss", "getDismiss", "Expand", "getExpand", "GetScrollViewportLength", "Lkotlin/Function1;", "", "", "getGetScrollViewportLength", "GetTextLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "getGetTextLayoutResult", "InsertTextAtCursor", "Landroidx/compose/ui/text/AnnotatedString;", "getInsertTextAtCursor", "OnAutofillText", "getOnAutofillText$ui_release", "OnClick", "getOnClick", "OnImeAction", "getOnImeAction", "OnLongClick", "getOnLongClick", "PageDown", "getPageDown", "PageLeft", "getPageLeft", "PageRight", "getPageRight", "PageUp", "getPageUp", "PasteText", "getPasteText", "PerformImeAction", "getPerformImeAction$annotations", "getPerformImeAction", "RequestFocus", "getRequestFocus", "ScrollBy", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "x", "y", "getScrollBy", "ScrollByOffset", "Landroidx/compose/ui/geometry/Offset;", "offset", "Lkotlin/coroutines/Continuation;", "getScrollByOffset", "ScrollToIndex", "", "getScrollToIndex", "SetProgress", "progress", "getSetProgress", "SetSelection", "Lkotlin/Function3;", "getSetSelection", "SetText", "getSetText", "SetTextSubstitution", "getSetTextSubstitution", "ShowTextSubstitution", "getShowTextSubstitution", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SemanticsActions {

    public static final int $stable = 8;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> ClearTextSubstitution;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> Collapse;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> CopyText;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<List<androidx.compose.ui.semantics.CustomAccessibilityAction>> CustomActions;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> CutText;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> Dismiss;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> Expand;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<List<Float>, Boolean>>> GetScrollViewportLength;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<List<TextLayoutResult>, Boolean>>> GetTextLayoutResult;
    public static final androidx.compose.ui.semantics.SemanticsActions INSTANCE;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<AnnotatedString, Boolean>>> InsertTextAtCursor;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<AnnotatedString, Boolean>>> OnAutofillText;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> OnClick;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> OnImeAction;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> OnLongClick;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> PageDown;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> PageLeft;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> PageRight;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> PageUp;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> PasteText;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> PerformImeAction;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> RequestFocus;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function2<Float, Float, Boolean>>> ScrollBy;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Function2<Offset, Continuation<? super Offset>, Object>> ScrollByOffset;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<Integer, Boolean>>> ScrollToIndex;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<Float, Boolean>>> SetProgress;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function3<Integer, Integer, Boolean, Boolean>>> SetSelection;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<AnnotatedString, Boolean>>> SetText;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<AnnotatedString, Boolean>>> SetTextSubstitution;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<Boolean, Boolean>>> ShowTextSubstitution;
    static {
        SemanticsActions semanticsActions = new SemanticsActions();
        SemanticsActions.INSTANCE = semanticsActions;
        int i2 = 0;
        SemanticsActions.GetTextLayoutResult = SemanticsPropertiesKt.AccessibilityKey("GetTextLayoutResult", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i3 = 0;
        SemanticsActions.OnClick = SemanticsPropertiesKt.AccessibilityKey("OnClick", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i4 = 0;
        SemanticsActions.OnLongClick = SemanticsPropertiesKt.AccessibilityKey("OnLongClick", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i5 = 0;
        SemanticsActions.ScrollBy = SemanticsPropertiesKt.AccessibilityKey("ScrollBy", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i6 = 0;
        SemanticsPropertyKey semanticsPropertyKey = new SemanticsPropertyKey("ScrollByOffset", i6, 2, i6);
        SemanticsActions.ScrollByOffset = semanticsPropertyKey;
        int i7 = 0;
        SemanticsActions.ScrollToIndex = SemanticsPropertiesKt.AccessibilityKey("ScrollToIndex", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i8 = 0;
        SemanticsActions.OnAutofillText = SemanticsPropertiesKt.AccessibilityKey("OnAutofillText", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i9 = 0;
        SemanticsActions.SetProgress = SemanticsPropertiesKt.AccessibilityKey("SetProgress", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i10 = 0;
        SemanticsActions.SetSelection = SemanticsPropertiesKt.AccessibilityKey("SetSelection", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i11 = 0;
        SemanticsActions.SetText = SemanticsPropertiesKt.AccessibilityKey("SetText", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i12 = 0;
        SemanticsActions.SetTextSubstitution = SemanticsPropertiesKt.AccessibilityKey("SetTextSubstitution", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i13 = 0;
        SemanticsActions.ShowTextSubstitution = SemanticsPropertiesKt.AccessibilityKey("ShowTextSubstitution", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i14 = 0;
        SemanticsActions.ClearTextSubstitution = SemanticsPropertiesKt.AccessibilityKey("ClearTextSubstitution", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i15 = 0;
        SemanticsActions.InsertTextAtCursor = SemanticsPropertiesKt.AccessibilityKey("InsertTextAtCursor", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i16 = 0;
        SemanticsActions.OnImeAction = SemanticsPropertiesKt.AccessibilityKey("PerformImeAction", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i17 = 0;
        SemanticsActions.PerformImeAction = SemanticsPropertiesKt.AccessibilityKey("PerformImeAction", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i18 = 0;
        SemanticsActions.CopyText = SemanticsPropertiesKt.AccessibilityKey("CopyText", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i19 = 0;
        SemanticsActions.CutText = SemanticsPropertiesKt.AccessibilityKey("CutText", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i20 = 0;
        SemanticsActions.PasteText = SemanticsPropertiesKt.AccessibilityKey("PasteText", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i21 = 0;
        SemanticsActions.Expand = SemanticsPropertiesKt.AccessibilityKey("Expand", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i22 = 0;
        SemanticsActions.Collapse = SemanticsPropertiesKt.AccessibilityKey("Collapse", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i23 = 0;
        SemanticsActions.Dismiss = SemanticsPropertiesKt.AccessibilityKey("Dismiss", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i24 = 0;
        SemanticsActions.RequestFocus = SemanticsPropertiesKt.AccessibilityKey("RequestFocus", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        SemanticsActions.CustomActions = SemanticsPropertiesKt.AccessibilityKey("CustomActions");
        int i25 = 0;
        SemanticsActions.PageUp = SemanticsPropertiesKt.AccessibilityKey("PageUp", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i26 = 0;
        SemanticsActions.PageLeft = SemanticsPropertiesKt.AccessibilityKey("PageLeft", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i27 = 0;
        SemanticsActions.PageDown = SemanticsPropertiesKt.AccessibilityKey("PageDown", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i28 = 0;
        SemanticsActions.PageRight = SemanticsPropertiesKt.AccessibilityKey("PageRight", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i29 = 0;
        SemanticsActions.GetScrollViewportLength = SemanticsPropertiesKt.AccessibilityKey("GetScrollViewportLength", (Function2)SemanticsPropertiesKt.ActionPropertyKey.1.INSTANCE);
        int i = 8;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use `SemanticsActions.OnImeAction` instead.", replaceWith = @ReplaceWith(...))
    public static void getPerformImeAction$annotations() {
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getClearTextSubstitution() {
        return SemanticsActions.ClearTextSubstitution;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getCollapse() {
        return SemanticsActions.Collapse;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getCopyText() {
        return SemanticsActions.CopyText;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<List<androidx.compose.ui.semantics.CustomAccessibilityAction>> getCustomActions() {
        return SemanticsActions.CustomActions;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getCutText() {
        return SemanticsActions.CutText;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getDismiss() {
        return SemanticsActions.Dismiss;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getExpand() {
        return SemanticsActions.Expand;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<List<Float>, Boolean>>> getGetScrollViewportLength() {
        return SemanticsActions.GetScrollViewportLength;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<List<TextLayoutResult>, Boolean>>> getGetTextLayoutResult() {
        return SemanticsActions.GetTextLayoutResult;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<AnnotatedString, Boolean>>> getInsertTextAtCursor() {
        return SemanticsActions.InsertTextAtCursor;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<AnnotatedString, Boolean>>> getOnAutofillText$ui_release() {
        return SemanticsActions.OnAutofillText;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getOnClick() {
        return SemanticsActions.OnClick;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getOnImeAction() {
        return SemanticsActions.OnImeAction;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getOnLongClick() {
        return SemanticsActions.OnLongClick;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getPageDown() {
        return SemanticsActions.PageDown;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getPageLeft() {
        return SemanticsActions.PageLeft;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getPageRight() {
        return SemanticsActions.PageRight;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getPageUp() {
        return SemanticsActions.PageUp;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getPasteText() {
        return SemanticsActions.PasteText;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getPerformImeAction() {
        return SemanticsActions.PerformImeAction;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function0<Boolean>>> getRequestFocus() {
        return SemanticsActions.RequestFocus;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function2<Float, Float, Boolean>>> getScrollBy() {
        return SemanticsActions.ScrollBy;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Function2<Offset, Continuation<? super Offset>, Object>> getScrollByOffset() {
        return SemanticsActions.ScrollByOffset;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<Integer, Boolean>>> getScrollToIndex() {
        return SemanticsActions.ScrollToIndex;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<Float, Boolean>>> getSetProgress() {
        return SemanticsActions.SetProgress;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function3<Integer, Integer, Boolean, Boolean>>> getSetSelection() {
        return SemanticsActions.SetSelection;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<AnnotatedString, Boolean>>> getSetText() {
        return SemanticsActions.SetText;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<AnnotatedString, Boolean>>> getSetTextSubstitution() {
        return SemanticsActions.SetTextSubstitution;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.AccessibilityAction<Function1<Boolean, Boolean>>> getShowTextSubstitution() {
        return SemanticsActions.ShowTextSubstitution;
    }
}
