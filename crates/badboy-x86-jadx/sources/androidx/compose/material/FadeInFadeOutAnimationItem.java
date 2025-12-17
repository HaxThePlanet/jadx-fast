package androidx.compose.material;

import androidx.compose.runtime.Composer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000c\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002BD\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u00125\u0010\u0004\u001a1\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0008\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\u000c¢\u0006\u0002\u0008\u0008¢\u0006\u0002\u0010\rJ\u000e\u0010\u0014\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000fJ=\u0010\u0015\u001a1\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0008\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\u000c¢\u0006\u0002\u0008\u0008HÆ\u0003¢\u0006\u0002\u0010\u0012JW\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002\u0008\u0008\u0002\u0010\u0003\u001a\u00028\u000027\u0008\u0002\u0010\u0004\u001a1\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0008\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\u000c¢\u0006\u0002\u0008\u0008HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\u0008\u000e\u0010\u000fRB\u0010\u0004\u001a1\u0012\u001e\u0012\u001c\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0008\u0008¢\u0006\u000c\u0008\t\u0012\u0008\u0008\n\u0012\u0004\u0008\u0008(\u000b\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\u000c¢\u0006\u0002\u0008\u0008¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006\u001f", d2 = {"Landroidx/compose/material/FadeInFadeOutAnimationItem;", "T", "", "key", "transition", "Lkotlin/Function1;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "Lkotlin/ParameterName;", "name", "content", "Landroidx/compose/material/FadeInFadeOutTransition;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTransition", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "component1", "component2", "copy", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Landroidx/compose/material/FadeInFadeOutAnimationItem;", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class FadeInFadeOutAnimationItem<T>  {

    private final T key;
    private final Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> transition;
    public FadeInFadeOutAnimationItem(T key, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> transition) {
        super();
        this.key = key;
        this.transition = transition;
    }

    public static androidx.compose.material.FadeInFadeOutAnimationItem copy$default(androidx.compose.material.FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem, Object object2, Function3 function33, int i4, Object object5) {
        Object obj1;
        Function3 obj2;
        if (i4 & 1 != 0) {
            obj1 = fadeInFadeOutAnimationItem.key;
        }
        if (i4 &= 2 != 0) {
            obj2 = fadeInFadeOutAnimationItem.transition;
        }
        return fadeInFadeOutAnimationItem.copy(obj1, obj2);
    }

    public final T component1() {
        return this.key;
    }

    public final Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> component2() {
        return this.transition;
    }

    public final androidx.compose.material.FadeInFadeOutAnimationItem<T> copy(T t, Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit> function32) {
        FadeInFadeOutAnimationItem fadeInFadeOutAnimationItem = new FadeInFadeOutAnimationItem(t, function32);
        return fadeInFadeOutAnimationItem;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof FadeInFadeOutAnimationItem) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.key, obj.key)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.transition, obj.transition)) {
            return i2;
        }
        return i;
    }

    public final T getKey() {
        return this.key;
    }

    public final Function3<Function2<? super Composer, ? super Integer, Unit>, Composer, Integer, Unit> getTransition() {
        return this.transition;
    }

    public int hashCode() {
        int i;
        if (this.key == null) {
            i = 0;
        } else {
            i = this.key.hashCode();
        }
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("FadeInFadeOutAnimationItem(key=").append(this.key).append(", transition=").append(this.transition).append(')').toString();
    }
}
