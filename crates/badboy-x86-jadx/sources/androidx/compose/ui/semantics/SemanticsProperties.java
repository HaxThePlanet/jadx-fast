package androidx.compose.ui.semantics;

import androidx.compose.ui.autofill.ContentDataType;
import androidx.compose.ui.autofill.ContentType;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.ImeAction;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0012\n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0007\n\u0002\u0008\u0004\u0008Ç\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0017\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0007R\u001a\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u0007R\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00100\u000f0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0007R\u001a\u0010\u0012\u001a\u0008\u0012\u0004\u0012\u00020\u00130\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0007R\u0017\u0010\u0015\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0017\u0010\u0007R\u0017\u0010\u0018\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u0007R\u0017\u0010\u001b\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u0007R\u0017\u0010\u001d\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001f\u0010\u0007R\u0017\u0010 \u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008!\u0010\u0007R\u0017\u0010\"\u001a\u0008\u0012\u0004\u0012\u00020#0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008$\u0010\u0007R\u0017\u0010%\u001a\u0008\u0012\u0004\u0012\u00020&0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008'\u0010\u0007R#\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020*0)0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008+\u0010\u0007R\"\u0010,\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008-\u0010\u0002\u001a\u0004\u0008.\u0010\u0007R \u0010/\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u00048FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u00080\u0010\u0002\u001a\u0004\u00081\u0010\u0007R\u0017\u00102\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00083\u0010\u0007R\u0017\u00104\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00085\u0010\u0007R\u0017\u00106\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00087\u0010\u0007R\u0017\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u00089\u0010\u0007R\u0017\u0010:\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008;\u0010\u0007R\u0017\u0010<\u001a\u0008\u0012\u0004\u0012\u00020=0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008>\u0010\u0007R\u0017\u0010?\u001a\u0008\u0012\u0004\u0012\u00020*0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008@\u0010\u0007R\u0017\u0010A\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008B\u0010\u0007R\u0017\u0010C\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008D\u0010\u0007R\u0017\u0010E\u001a\u0008\u0012\u0004\u0012\u00020F0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008G\u0010\u0007R\u0017\u0010H\u001a\u0008\u0012\u0004\u0012\u00020I0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008J\u0010\u0007R\u0017\u0010K\u001a\u0008\u0012\u0004\u0012\u00020\u00160\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008L\u0010\u0007R\u0017\u0010M\u001a\u0008\u0012\u0004\u0012\u00020\u001e0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008N\u0010\u0007R\u0017\u0010O\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008P\u0010\u0007R\u0017\u0010Q\u001a\u0008\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008R\u0010\u0007R\u001d\u0010S\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00190\u000f0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008T\u0010\u0007R\u0017\u0010U\u001a\u0008\u0012\u0004\u0012\u00020V0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008W\u0010\u0007R\u0017\u0010X\u001a\u0008\u0012\u0004\u0012\u00020\u00190\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008Y\u0010\u0007R\u0017\u0010Z\u001a\u0008\u0012\u0004\u0012\u00020[0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\\\u0010\u0007R\u0017\u0010]\u001a\u0008\u0012\u0004\u0012\u00020^0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008_\u0010\u0007R\u0017\u0010`\u001a\u0008\u0012\u0004\u0012\u00020#0\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008a\u0010\u0007¨\u0006b", d2 = {"Landroidx/compose/ui/semantics/SemanticsProperties;", "", "()V", "CollectionInfo", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/CollectionInfo;", "getCollectionInfo", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "CollectionItemInfo", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "getCollectionItemInfo", "ContentDataType", "Landroidx/compose/ui/autofill/ContentDataType;", "getContentDataType$ui_release", "ContentDescription", "", "", "getContentDescription", "ContentType", "Landroidx/compose/ui/autofill/ContentType;", "getContentType$ui_release", "Disabled", "", "getDisabled", "EditableText", "Landroidx/compose/ui/text/AnnotatedString;", "getEditableText", "Error", "getError", "Focused", "", "getFocused", "Heading", "getHeading", "HorizontalScrollAxisRange", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "getHorizontalScrollAxisRange", "ImeAction", "Landroidx/compose/ui/text/input/ImeAction;", "getImeAction", "IndexForKey", "Lkotlin/Function1;", "", "getIndexForKey", "InvisibleToUser", "getInvisibleToUser$annotations", "getInvisibleToUser", "IsContainer", "getIsContainer$annotations", "getIsContainer", "IsDialog", "getIsDialog", "IsEditable", "getIsEditable", "IsPopup", "getIsPopup", "IsShowingTextSubstitution", "getIsShowingTextSubstitution", "IsTraversalGroup", "getIsTraversalGroup", "LiveRegion", "Landroidx/compose/ui/semantics/LiveRegionMode;", "getLiveRegion", "MaxTextLength", "getMaxTextLength", "PaneTitle", "getPaneTitle", "Password", "getPassword", "ProgressBarRangeInfo", "Landroidx/compose/ui/semantics/ProgressBarRangeInfo;", "getProgressBarRangeInfo", "Role", "Landroidx/compose/ui/semantics/Role;", "getRole", "SelectableGroup", "getSelectableGroup", "Selected", "getSelected", "StateDescription", "getStateDescription", "TestTag", "getTestTag", "Text", "getText", "TextSelectionRange", "Landroidx/compose/ui/text/TextRange;", "getTextSelectionRange", "TextSubstitution", "getTextSubstitution", "ToggleableState", "Landroidx/compose/ui/state/ToggleableState;", "getToggleableState", "TraversalIndex", "", "getTraversalIndex", "VerticalScrollAxisRange", "getVerticalScrollAxisRange", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SemanticsProperties {

    public static final int $stable = 8;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.CollectionInfo> CollectionInfo;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.CollectionItemInfo> CollectionItemInfo;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<ContentDataType> ContentDataType;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<List<String>> ContentDescription;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<ContentType> ContentType;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Unit> Disabled;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<AnnotatedString> EditableText;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<String> Error;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Boolean> Focused;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Unit> Heading;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.ScrollAxisRange> HorizontalScrollAxisRange;
    public static final androidx.compose.ui.semantics.SemanticsProperties INSTANCE;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<ImeAction> ImeAction;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Function1<Object, Integer>> IndexForKey;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Unit> InvisibleToUser;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Unit> IsDialog;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Boolean> IsEditable;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Unit> IsPopup;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Boolean> IsShowingTextSubstitution;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Boolean> IsTraversalGroup;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.LiveRegionMode> LiveRegion;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Integer> MaxTextLength;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<String> PaneTitle;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Unit> Password;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.ProgressBarRangeInfo> ProgressBarRangeInfo;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.Role> Role;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Unit> SelectableGroup;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Boolean> Selected;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<String> StateDescription;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<String> TestTag;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<List<AnnotatedString>> Text;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<TextRange> TextSelectionRange;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<AnnotatedString> TextSubstitution;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<ToggleableState> ToggleableState;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<Float> TraversalIndex;
    private static final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.ScrollAxisRange> VerticalScrollAxisRange;
    static {
        SemanticsProperties semanticsProperties = new SemanticsProperties();
        SemanticsProperties.INSTANCE = semanticsProperties;
        SemanticsProperties.ContentDescription = SemanticsPropertiesKt.AccessibilityKey("ContentDescription", (Function2)SemanticsProperties.ContentDescription.1.INSTANCE);
        SemanticsProperties.StateDescription = SemanticsPropertiesKt.AccessibilityKey("StateDescription");
        SemanticsProperties.ProgressBarRangeInfo = SemanticsPropertiesKt.AccessibilityKey("ProgressBarRangeInfo");
        SemanticsProperties.PaneTitle = SemanticsPropertiesKt.AccessibilityKey("PaneTitle", (Function2)SemanticsProperties.PaneTitle.1.INSTANCE);
        SemanticsProperties.SelectableGroup = SemanticsPropertiesKt.AccessibilityKey("SelectableGroup");
        SemanticsProperties.CollectionInfo = SemanticsPropertiesKt.AccessibilityKey("CollectionInfo");
        SemanticsProperties.CollectionItemInfo = SemanticsPropertiesKt.AccessibilityKey("CollectionItemInfo");
        SemanticsProperties.Heading = SemanticsPropertiesKt.AccessibilityKey("Heading");
        SemanticsProperties.Disabled = SemanticsPropertiesKt.AccessibilityKey("Disabled");
        SemanticsProperties.LiveRegion = SemanticsPropertiesKt.AccessibilityKey("LiveRegion");
        SemanticsProperties.Focused = SemanticsPropertiesKt.AccessibilityKey("Focused");
        SemanticsProperties.IsTraversalGroup = SemanticsPropertiesKt.AccessibilityKey("IsTraversalGroup");
        SemanticsPropertyKey semanticsPropertyKey13 = new SemanticsPropertyKey("InvisibleToUser", (Function2)SemanticsProperties.InvisibleToUser.1.INSTANCE);
        SemanticsProperties.InvisibleToUser = semanticsPropertyKey13;
        SemanticsPropertyKey semanticsPropertyKey14 = new SemanticsPropertyKey("ContentType", (Function2)SemanticsProperties.ContentType.1.INSTANCE);
        SemanticsProperties.ContentType = semanticsPropertyKey14;
        SemanticsPropertyKey semanticsPropertyKey15 = new SemanticsPropertyKey("ContentDataType", (Function2)SemanticsProperties.ContentDataType.1.INSTANCE);
        SemanticsProperties.ContentDataType = semanticsPropertyKey15;
        SemanticsProperties.TraversalIndex = SemanticsPropertiesKt.AccessibilityKey("TraversalIndex", (Function2)SemanticsProperties.TraversalIndex.1.INSTANCE);
        SemanticsProperties.HorizontalScrollAxisRange = SemanticsPropertiesKt.AccessibilityKey("HorizontalScrollAxisRange");
        SemanticsProperties.VerticalScrollAxisRange = SemanticsPropertiesKt.AccessibilityKey("VerticalScrollAxisRange");
        SemanticsProperties.IsPopup = SemanticsPropertiesKt.AccessibilityKey("IsPopup", (Function2)SemanticsProperties.IsPopup.1.INSTANCE);
        SemanticsProperties.IsDialog = SemanticsPropertiesKt.AccessibilityKey("IsDialog", (Function2)SemanticsProperties.IsDialog.1.INSTANCE);
        SemanticsProperties.Role = SemanticsPropertiesKt.AccessibilityKey("Role", (Function2)SemanticsProperties.Role.1.INSTANCE);
        SemanticsPropertyKey semanticsPropertyKey22 = new SemanticsPropertyKey("TestTag", 0, (Function2)SemanticsProperties.TestTag.1.INSTANCE);
        SemanticsProperties.TestTag = semanticsPropertyKey22;
        SemanticsProperties.Text = SemanticsPropertiesKt.AccessibilityKey("Text", (Function2)SemanticsProperties.Text.1.INSTANCE);
        int i2 = 0;
        int i4 = 2;
        SemanticsPropertyKey semanticsPropertyKey24 = new SemanticsPropertyKey("TextSubstitution", i2, i4, i2);
        SemanticsProperties.TextSubstitution = semanticsPropertyKey24;
        SemanticsPropertyKey semanticsPropertyKey25 = new SemanticsPropertyKey("IsShowingTextSubstitution", i2, i4, i2);
        SemanticsProperties.IsShowingTextSubstitution = semanticsPropertyKey25;
        SemanticsProperties.EditableText = SemanticsPropertiesKt.AccessibilityKey("EditableText");
        SemanticsProperties.TextSelectionRange = SemanticsPropertiesKt.AccessibilityKey("TextSelectionRange");
        SemanticsProperties.ImeAction = SemanticsPropertiesKt.AccessibilityKey("ImeAction");
        SemanticsProperties.Selected = SemanticsPropertiesKt.AccessibilityKey("Selected");
        SemanticsProperties.ToggleableState = SemanticsPropertiesKt.AccessibilityKey("ToggleableState");
        SemanticsProperties.Password = SemanticsPropertiesKt.AccessibilityKey("Password");
        SemanticsProperties.Error = SemanticsPropertiesKt.AccessibilityKey("Error");
        SemanticsPropertyKey semanticsPropertyKey33 = new SemanticsPropertyKey("IndexForKey", i2, i4, i2);
        SemanticsProperties.IndexForKey = semanticsPropertyKey33;
        SemanticsPropertyKey semanticsPropertyKey34 = new SemanticsPropertyKey("IsEditable", i2, i4, i2);
        SemanticsProperties.IsEditable = semanticsPropertyKey34;
        SemanticsPropertyKey semanticsPropertyKey35 = new SemanticsPropertyKey("MaxTextLength", i2, i4, i2);
        SemanticsProperties.MaxTextLength = semanticsPropertyKey35;
        int i = 8;
    }

    public static void getInvisibleToUser$annotations() {
    }

    @Deprecated(message = "Use `isTraversalGroup` instead.", replaceWith = @ReplaceWith(...))
    public static void getIsContainer$annotations() {
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.CollectionInfo> getCollectionInfo() {
        return SemanticsProperties.CollectionInfo;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.CollectionItemInfo> getCollectionItemInfo() {
        return SemanticsProperties.CollectionItemInfo;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<ContentDataType> getContentDataType$ui_release() {
        return SemanticsProperties.ContentDataType;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<List<String>> getContentDescription() {
        return SemanticsProperties.ContentDescription;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<ContentType> getContentType$ui_release() {
        return SemanticsProperties.ContentType;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Unit> getDisabled() {
        return SemanticsProperties.Disabled;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<AnnotatedString> getEditableText() {
        return SemanticsProperties.EditableText;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<String> getError() {
        return SemanticsProperties.Error;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Boolean> getFocused() {
        return SemanticsProperties.Focused;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Unit> getHeading() {
        return SemanticsProperties.Heading;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.ScrollAxisRange> getHorizontalScrollAxisRange() {
        return SemanticsProperties.HorizontalScrollAxisRange;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<ImeAction> getImeAction() {
        return SemanticsProperties.ImeAction;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Function1<Object, Integer>> getIndexForKey() {
        return SemanticsProperties.IndexForKey;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Unit> getInvisibleToUser() {
        return SemanticsProperties.InvisibleToUser;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Boolean> getIsContainer() {
        return SemanticsProperties.IsTraversalGroup;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Unit> getIsDialog() {
        return SemanticsProperties.IsDialog;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Boolean> getIsEditable() {
        return SemanticsProperties.IsEditable;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Unit> getIsPopup() {
        return SemanticsProperties.IsPopup;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Boolean> getIsShowingTextSubstitution() {
        return SemanticsProperties.IsShowingTextSubstitution;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Boolean> getIsTraversalGroup() {
        return SemanticsProperties.IsTraversalGroup;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.LiveRegionMode> getLiveRegion() {
        return SemanticsProperties.LiveRegion;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Integer> getMaxTextLength() {
        return SemanticsProperties.MaxTextLength;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<String> getPaneTitle() {
        return SemanticsProperties.PaneTitle;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Unit> getPassword() {
        return SemanticsProperties.Password;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.ProgressBarRangeInfo> getProgressBarRangeInfo() {
        return SemanticsProperties.ProgressBarRangeInfo;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.Role> getRole() {
        return SemanticsProperties.Role;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Unit> getSelectableGroup() {
        return SemanticsProperties.SelectableGroup;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Boolean> getSelected() {
        return SemanticsProperties.Selected;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<String> getStateDescription() {
        return SemanticsProperties.StateDescription;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<String> getTestTag() {
        return SemanticsProperties.TestTag;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<List<AnnotatedString>> getText() {
        return SemanticsProperties.Text;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<TextRange> getTextSelectionRange() {
        return SemanticsProperties.TextSelectionRange;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<AnnotatedString> getTextSubstitution() {
        return SemanticsProperties.TextSubstitution;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<ToggleableState> getToggleableState() {
        return SemanticsProperties.ToggleableState;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<Float> getTraversalIndex() {
        return SemanticsProperties.TraversalIndex;
    }

    public final androidx.compose.ui.semantics.SemanticsPropertyKey<androidx.compose.ui.semantics.ScrollAxisRange> getVerticalScrollAxisRange() {
        return SemanticsProperties.VerticalScrollAxisRange;
    }
}
