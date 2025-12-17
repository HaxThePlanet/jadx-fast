package androidx.compose.animation;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.ContentScale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0080\u0008\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0018\u0010\u000b\u001a\u0006\u0012\u0002\u0008\u00030\u000c8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u001b", d2 = {"Landroidx/compose/animation/ContentScaleTransitionEffect;", "Landroidx/compose/animation/TransitionEffect;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alignment", "Landroidx/compose/ui/Alignment;", "(Landroidx/compose/ui/layout/ContentScale;Landroidx/compose/ui/Alignment;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "getContentScale", "()Landroidx/compose/ui/layout/ContentScale;", "key", "Landroidx/compose/animation/TransitionEffectKey;", "getKey$animation_release", "()Landroidx/compose/animation/TransitionEffectKey;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "Key", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContentScaleTransitionEffect extends androidx.compose.animation.TransitionEffect {

    public static final int $stable;
    public static final androidx.compose.animation.ContentScaleTransitionEffect.Key Key;
    private final Alignment alignment;
    private final ContentScale contentScale;

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Landroidx/compose/animation/ContentScaleTransitionEffect$Key;", "Landroidx/compose/animation/TransitionEffectKey;", "Landroidx/compose/animation/ContentScaleTransitionEffect;", "()V", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Key implements androidx.compose.animation.TransitionEffectKey<androidx.compose.animation.ContentScaleTransitionEffect> {
        public Key(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }
    static {
        ContentScaleTransitionEffect.Key key = new ContentScaleTransitionEffect.Key(0);
        ContentScaleTransitionEffect.Key = key;
    }

    public ContentScaleTransitionEffect(ContentScale contentScale, Alignment alignment) {
        super(0);
        this.contentScale = contentScale;
        this.alignment = alignment;
    }

    public static androidx.compose.animation.ContentScaleTransitionEffect copy$default(androidx.compose.animation.ContentScaleTransitionEffect contentScaleTransitionEffect, ContentScale contentScale2, Alignment alignment3, int i4, Object object5) {
        ContentScale obj1;
        Alignment obj2;
        if (i4 & 1 != 0) {
            obj1 = contentScaleTransitionEffect.contentScale;
        }
        if (i4 &= 2 != 0) {
            obj2 = contentScaleTransitionEffect.alignment;
        }
        return contentScaleTransitionEffect.copy(obj1, obj2);
    }

    @Override // androidx.compose.animation.TransitionEffect
    public final ContentScale component1() {
        return this.contentScale;
    }

    @Override // androidx.compose.animation.TransitionEffect
    public final Alignment component2() {
        return this.alignment;
    }

    @Override // androidx.compose.animation.TransitionEffect
    public final androidx.compose.animation.ContentScaleTransitionEffect copy(ContentScale contentScale, Alignment alignment2) {
        ContentScaleTransitionEffect contentScaleTransitionEffect = new ContentScaleTransitionEffect(contentScale, alignment2);
        return contentScaleTransitionEffect;
    }

    @Override // androidx.compose.animation.TransitionEffect
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof ContentScaleTransitionEffect) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.contentScale, obj.contentScale)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.alignment, obj.alignment)) {
            return i2;
        }
        return i;
    }

    @Override // androidx.compose.animation.TransitionEffect
    public final Alignment getAlignment() {
        return this.alignment;
    }

    @Override // androidx.compose.animation.TransitionEffect
    public final ContentScale getContentScale() {
        return this.contentScale;
    }

    public androidx.compose.animation.TransitionEffectKey<?> getKey$animation_release() {
        return (TransitionEffectKey)ContentScaleTransitionEffect.Key;
    }

    @Override // androidx.compose.animation.TransitionEffect
    public int hashCode() {
        return i2 += i4;
    }

    @Override // androidx.compose.animation.TransitionEffect
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ContentScaleTransitionEffect(contentScale=").append(this.contentScale).append(", alignment=").append(this.alignment).append(')').toString();
    }
}
