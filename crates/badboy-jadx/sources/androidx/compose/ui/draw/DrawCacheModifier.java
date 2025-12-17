package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.Modifier.Element;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0006À\u0006\u0003", d2 = {"Landroidx/compose/ui/draw/DrawCacheModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "onBuildCache", "", "params", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DrawCacheModifier extends androidx.compose.ui.draw.DrawModifier {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean all(androidx.compose.ui.draw.DrawCacheModifier $this, Function1<? super Modifier.Element, Boolean> predicate) {
            return DrawCacheModifier.access$all$jd($this, predicate);
        }

        @Deprecated
        public static boolean any(androidx.compose.ui.draw.DrawCacheModifier $this, Function1<? super Modifier.Element, Boolean> predicate) {
            return DrawCacheModifier.access$any$jd($this, predicate);
        }

        @Deprecated
        public static <R> R foldIn(androidx.compose.ui.draw.DrawCacheModifier $this, R initial, Function2<? super R, ? super Modifier.Element, ? extends R> operation) {
            return DrawCacheModifier.access$foldIn$jd($this, initial, operation);
        }

        @Deprecated
        public static <R> R foldOut(androidx.compose.ui.draw.DrawCacheModifier $this, R initial, Function2<? super Modifier.Element, ? super R, ? extends R> operation) {
            return DrawCacheModifier.access$foldOut$jd($this, initial, operation);
        }

        @Deprecated
        public static Modifier then(androidx.compose.ui.draw.DrawCacheModifier $this, Modifier other) {
            return DrawCacheModifier.access$then$jd($this, other);
        }
    }
    public static boolean access$all$jd(androidx.compose.ui.draw.DrawCacheModifier $this, Function1 predicate) {
        return super.all(predicate);
    }

    public static boolean access$any$jd(androidx.compose.ui.draw.DrawCacheModifier $this, Function1 predicate) {
        return super.any(predicate);
    }

    public static Object access$foldIn$jd(androidx.compose.ui.draw.DrawCacheModifier $this, Object initial, Function2 operation) {
        return super.foldIn(initial, operation);
    }

    public static Object access$foldOut$jd(androidx.compose.ui.draw.DrawCacheModifier $this, Object initial, Function2 operation) {
        return super.foldOut(initial, operation);
    }

    public static Modifier access$then$jd(androidx.compose.ui.draw.DrawCacheModifier $this, Modifier other) {
        return super.then(other);
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public abstract void onBuildCache(androidx.compose.ui.draw.BuildDrawCacheParams buildDrawCacheParams);
}
