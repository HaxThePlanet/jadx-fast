package androidx.compose.ui.layout;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0006\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\u0008\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000cÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/layout/IntrinsicMeasurable;", "", "parentData", "getParentData", "()Ljava/lang/Object;", "maxIntrinsicHeight", "", "width", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IntrinsicMeasurable {
    public abstract Object getParentData();

    public abstract int maxIntrinsicHeight(int i);

    public abstract int maxIntrinsicWidth(int i);

    public abstract int minIntrinsicHeight(int i);

    public abstract int minIntrinsicWidth(int i);
}
