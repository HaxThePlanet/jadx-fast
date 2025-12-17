package androidx.compose.ui.semantics;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Element;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u00038VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u0004\u0010\u0005\u001a\u0004\u0008\u0006\u0010\u0007R\u0012\u0010\u0008\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000cÀ\u0006\u0003", d2 = {"Landroidx/compose/ui/semantics/SemanticsModifier;", "Landroidx/compose/ui/Modifier$Element;", "id", "", "getId$annotations", "()V", "getId", "()I", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SemanticsModifier extends Modifier.Element {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(androidx.compose.ui.semantics.SemanticsModifier $this, Function1<? super Modifier.Element, Boolean> predicate) {
            return SemanticsModifier.access$all$jd($this, predicate);
        }

        @Deprecated
        public static boolean any(androidx.compose.ui.semantics.SemanticsModifier $this, Function1<? super Modifier.Element, Boolean> predicate) {
            return SemanticsModifier.access$any$jd($this, predicate);
        }

        @Deprecated
        public static <R> R foldIn(androidx.compose.ui.semantics.SemanticsModifier $this, R initial, Function2<? super R, ? super Modifier.Element, ? extends R> operation) {
            return SemanticsModifier.access$foldIn$jd($this, initial, operation);
        }

        @Deprecated
        public static <R> R foldOut(androidx.compose.ui.semantics.SemanticsModifier $this, R initial, Function2<? super Modifier.Element, ? super R, ? extends R> operation) {
            return SemanticsModifier.access$foldOut$jd($this, initial, operation);
        }

        @Deprecated
        public static int getId(androidx.compose.ui.semantics.SemanticsModifier $this) {
            return SemanticsModifier.access$getId$jd($this);
        }

        @Deprecated(message = "SemanticsModifier.id is now unused and has been set to a fixed value. Retrieve the id from LayoutInfo instead.", replaceWith = @ReplaceWith(...))
        public static void getId$annotations() {
        }

        @Deprecated
        public static Modifier then(androidx.compose.ui.semantics.SemanticsModifier $this, Modifier other) {
            return SemanticsModifier.access$then$jd($this, other);
        }
    }
    public static boolean access$all$jd(androidx.compose.ui.semantics.SemanticsModifier $this, Function1 predicate) {
        return super.all(predicate);
    }

    public static boolean access$any$jd(androidx.compose.ui.semantics.SemanticsModifier $this, Function1 predicate) {
        return super.any(predicate);
    }

    public static Object access$foldIn$jd(androidx.compose.ui.semantics.SemanticsModifier $this, Object initial, Function2 operation) {
        return super.foldIn(initial, operation);
    }

    public static Object access$foldOut$jd(androidx.compose.ui.semantics.SemanticsModifier $this, Object initial, Function2 operation) {
        return super.foldOut(initial, operation);
    }

    public static int access$getId$jd(androidx.compose.ui.semantics.SemanticsModifier $this) {
        return super.getId();
    }

    public static Modifier access$then$jd(androidx.compose.ui.semantics.SemanticsModifier $this, Modifier other) {
        return super.then(other);
    }

    @Override // androidx.compose.ui.Modifier$Element
    public int getId() {
        return -1;
    }

    @Override // androidx.compose.ui.Modifier$Element
    public abstract androidx.compose.ui.semantics.SemanticsConfiguration getSemanticsConfiguration();
}
