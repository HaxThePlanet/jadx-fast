package androidx.compose.material;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010\u0007\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\t\u0008a\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002J\u0017\u0010\u0007\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0008\u001a\u00020\tH&¢\u0006\u0002\u0010\nJ\u001f\u0010\u0007\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u000cH&¢\u0006\u0002\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u000c2\u0006\u0010\u000f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0010J\u0008\u0010\u0011\u001a\u00020\tH&J\u0008\u0010\u0012\u001a\u00020\tH&J\u0015\u0010\u0013\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0014R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0015À\u0006\u0001", d2 = {"Landroidx/compose/material/DraggableAnchors;", "T", "", "size", "", "getSize", "()I", "closestAnchor", "position", "", "(F)Ljava/lang/Object;", "searchUpwards", "", "(FZ)Ljava/lang/Object;", "hasAnchorFor", "value", "(Ljava/lang/Object;)Z", "maxAnchor", "minAnchor", "positionOf", "(Ljava/lang/Object;)F", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DraggableAnchors<T>  {
    public abstract T closestAnchor(float f);

    public abstract T closestAnchor(float f, boolean z2);

    public abstract int getSize();

    public abstract boolean hasAnchorFor(T t);

    public abstract float maxAnchor();

    public abstract float minAnchor();

    public abstract float positionOf(T t);
}
