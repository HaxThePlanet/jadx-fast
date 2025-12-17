package androidx.compose.ui.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Element;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Deprecated(message = "Use FocusRequesterModifierNode instead")
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008g\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0006À\u0006\u0003", d2 = {"Landroidx/compose/ui/focus/FocusRequesterModifier;", "Landroidx/compose/ui/Modifier$Element;", "focusRequester", "Landroidx/compose/ui/focus/FocusRequester;", "getFocusRequester", "()Landroidx/compose/ui/focus/FocusRequester;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface FocusRequesterModifier extends Modifier.Element {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(androidx.compose.ui.focus.FocusRequesterModifier $this, Function1<? super Modifier.Element, Boolean> predicate) {
            return FocusRequesterModifier.access$all$jd($this, predicate);
        }

        @Deprecated
        public static boolean any(androidx.compose.ui.focus.FocusRequesterModifier $this, Function1<? super Modifier.Element, Boolean> predicate) {
            return FocusRequesterModifier.access$any$jd($this, predicate);
        }

        @Deprecated
        public static <R> R foldIn(androidx.compose.ui.focus.FocusRequesterModifier $this, R initial, Function2<? super R, ? super Modifier.Element, ? extends R> operation) {
            return FocusRequesterModifier.access$foldIn$jd($this, initial, operation);
        }

        @Deprecated
        public static <R> R foldOut(androidx.compose.ui.focus.FocusRequesterModifier $this, R initial, Function2<? super Modifier.Element, ? super R, ? extends R> operation) {
            return FocusRequesterModifier.access$foldOut$jd($this, initial, operation);
        }

        @Deprecated
        public static Modifier then(androidx.compose.ui.focus.FocusRequesterModifier $this, Modifier other) {
            return FocusRequesterModifier.access$then$jd($this, other);
        }
    }
    public static boolean access$all$jd(androidx.compose.ui.focus.FocusRequesterModifier $this, Function1 predicate) {
        return super.all(predicate);
    }

    public static boolean access$any$jd(androidx.compose.ui.focus.FocusRequesterModifier $this, Function1 predicate) {
        return super.any(predicate);
    }

    public static Object access$foldIn$jd(androidx.compose.ui.focus.FocusRequesterModifier $this, Object initial, Function2 operation) {
        return super.foldIn(initial, operation);
    }

    public static Object access$foldOut$jd(androidx.compose.ui.focus.FocusRequesterModifier $this, Object initial, Function2 operation) {
        return super.foldOut(initial, operation);
    }

    public static Modifier access$then$jd(androidx.compose.ui.focus.FocusRequesterModifier $this, Modifier other) {
        return super.then(other);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public abstract androidx.compose.ui.focus.FocusRequester getFocusRequester();
}
