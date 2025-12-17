package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0008H\u0007\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00082\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0008\u0006H\u0007¨\u0006\t", d2 = {"focusOrder", "Landroidx/compose/ui/Modifier;", "focusOrderReceiver", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusOrder;", "", "Lkotlin/ExtensionFunctionType;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class FocusOrderModifierKt {
    @Deprecated(message = "Use focusRequester() instead", replaceWith = @ReplaceWith(...))
    public static final Modifier focusOrder(Modifier $this$focusOrder, androidx.compose.ui.focus.FocusRequester focusRequester) {
        return FocusRequesterModifierKt.focusRequester($this$focusOrder, focusRequester);
    }

    @Deprecated(message = "Use focusProperties() and focusRequester() instead", replaceWith = @ReplaceWith(...))
    public static final Modifier focusOrder(Modifier $this$focusOrder, androidx.compose.ui.focus.FocusRequester focusRequester, Function1<? super androidx.compose.ui.focus.FocusOrder, Unit> focusOrderReceiver) {
        FocusOrderToProperties focusOrderToProperties = new FocusOrderToProperties(focusOrderReceiver);
        FocusOrderModifierKt.focusOrder.2 anon = new FocusOrderModifierKt.focusOrder.2(focusOrderToProperties);
        return FocusPropertiesKt.focusProperties(FocusRequesterModifierKt.focusRequester($this$focusOrder, focusRequester), (Function1)anon);
    }

    @Deprecated(message = "Use focusProperties() instead", replaceWith = @ReplaceWith(...))
    public static final Modifier focusOrder(Modifier $this$focusOrder, Function1<? super androidx.compose.ui.focus.FocusOrder, Unit> focusOrderReceiver) {
        FocusOrderToProperties focusOrderToProperties = new FocusOrderToProperties(focusOrderReceiver);
        FocusOrderModifierKt.focusOrder.1 anon = new FocusOrderModifierKt.focusOrder.1(focusOrderToProperties);
        return FocusPropertiesKt.focusProperties($this$focusOrder, (Function1)anon);
    }
}
