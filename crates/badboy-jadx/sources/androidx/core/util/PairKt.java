package androidx.core.util;

import android.util.Pair;
import kotlin.Metadata;
import kotlin.Pair;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001\"\u0004\u0008\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\n¢\u0006\u0002\u0010\u0004\u001a*\u0010\u0000\u001a\u0002H\u0001\"\u0004\u0008\u0000\u0010\u0001\"\u0004\u0008\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n¢\u0006\u0002\u0010\u0006\u001a*\u0010\u0007\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0001\"\u0004\u0008\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\n¢\u0006\u0002\u0010\u0004\u001a*\u0010\u0007\u001a\u0002H\u0002\"\u0004\u0008\u0000\u0010\u0001\"\u0004\u0008\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\n¢\u0006\u0002\u0010\u0006\u001a1\u0010\u0008\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\u0008\u0000\u0010\u0001\"\u0004\u0008\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0008\u001a1\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\u0008\u0000\u0010\u0001\"\u0004\u0008\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0008\u001a1\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\t\"\u0004\u0008\u0000\u0010\u0001\"\u0004\u0008\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0008\u001a1\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\t\"\u0004\u0008\u0000\u0010\u0001\"\u0004\u0008\u0001\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086\u0008¨\u0006\u000c", d2 = {"component1", "F", "S", "Landroid/util/Pair;", "(Landroid/util/Pair;)Ljava/lang/Object;", "Landroidx/core/util/Pair;", "(Landroidx/core/util/Pair;)Ljava/lang/Object;", "component2", "toAndroidPair", "Lkotlin/Pair;", "toAndroidXPair", "toKotlinPair", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PairKt {
    public static final <F, S> F component1(Pair<F, S> $this$component1) {
        final int i = 0;
        return $this$component1.first;
    }

    public static final <F, S> F component1(androidx.core.util.Pair<F, S> $this$component1) {
        final int i = 0;
        return $this$component1.first;
    }

    public static final <F, S> S component2(Pair<F, S> $this$component2) {
        final int i = 0;
        return $this$component2.second;
    }

    public static final <F, S> S component2(androidx.core.util.Pair<F, S> $this$component2) {
        final int i = 0;
        return $this$component2.second;
    }

    public static final <F, S> Pair<F, S> toAndroidPair(Pair<? extends F, ? extends S> $this$toAndroidPair) {
        final int i = 0;
        Pair pair = new Pair($this$toAndroidPair.getFirst(), $this$toAndroidPair.getSecond());
        return pair;
    }

    public static final <F, S> androidx.core.util.Pair<F, S> toAndroidXPair(Pair<? extends F, ? extends S> $this$toAndroidXPair) {
        final int i = 0;
        Pair pair = new Pair($this$toAndroidXPair.getFirst(), $this$toAndroidXPair.getSecond());
        return pair;
    }

    public static final <F, S> Pair<F, S> toKotlinPair(Pair<F, S> $this$toKotlinPair) {
        final int i = 0;
        Pair pair = new Pair($this$toKotlinPair.first, $this$toKotlinPair.second);
        return pair;
    }

    public static final <F, S> Pair<F, S> toKotlinPair(androidx.core.util.Pair<F, S> $this$toKotlinPair) {
        final int i = 0;
        Pair pair = new Pair($this$toKotlinPair.first, $this$toKotlinPair.second);
        return pair;
    }
}
