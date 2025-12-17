package androidx.compose.ui.modifier;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Element;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0008g\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002R\u0018\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00028\u0000X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\nÀ\u0006\u0003", d2 = {"Landroidx/compose/ui/modifier/ModifierLocalProvider;", "T", "Landroidx/compose/ui/Modifier$Element;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "value", "getValue", "()Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface ModifierLocalProvider<T>  extends Modifier.Element {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> boolean all(androidx.compose.ui.modifier.ModifierLocalProvider<T> $this, Function1<? super Modifier.Element, Boolean> predicate) {
            return ModifierLocalProvider.access$all$jd($this, predicate);
        }

        @Deprecated
        public static <T> boolean any(androidx.compose.ui.modifier.ModifierLocalProvider<T> $this, Function1<? super Modifier.Element, Boolean> predicate) {
            return ModifierLocalProvider.access$any$jd($this, predicate);
        }

        @Deprecated
        public static <T, R> R foldIn(androidx.compose.ui.modifier.ModifierLocalProvider<T> $this, R initial, Function2<? super R, ? super Modifier.Element, ? extends R> operation) {
            return ModifierLocalProvider.access$foldIn$jd($this, initial, operation);
        }

        @Deprecated
        public static <T, R> R foldOut(androidx.compose.ui.modifier.ModifierLocalProvider<T> $this, R initial, Function2<? super Modifier.Element, ? super R, ? extends R> operation) {
            return ModifierLocalProvider.access$foldOut$jd($this, initial, operation);
        }

        @Deprecated
        public static <T> Modifier then(androidx.compose.ui.modifier.ModifierLocalProvider<T> $this, Modifier other) {
            return ModifierLocalProvider.access$then$jd($this, other);
        }
    }
    public static boolean access$all$jd(androidx.compose.ui.modifier.ModifierLocalProvider $this, Function1 predicate) {
        return super.all(predicate);
    }

    public static boolean access$any$jd(androidx.compose.ui.modifier.ModifierLocalProvider $this, Function1 predicate) {
        return super.any(predicate);
    }

    public static Object access$foldIn$jd(androidx.compose.ui.modifier.ModifierLocalProvider $this, Object initial, Function2 operation) {
        return super.foldIn(initial, operation);
    }

    public static Object access$foldOut$jd(androidx.compose.ui.modifier.ModifierLocalProvider $this, Object initial, Function2 operation) {
        return super.foldOut(initial, operation);
    }

    public static Modifier access$then$jd(androidx.compose.ui.modifier.ModifierLocalProvider $this, Modifier other) {
        return super.then(other);
    }

    public abstract androidx.compose.ui.modifier.ProvidableModifierLocal<T> getKey();

    public abstract T getValue();
}
