package androidx.compose.foundation.text;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0008`\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000¢\u0006\u0004\u0008\u0007\u0010\u0008J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H&ø\u0001\u0000¢\u0006\u0004\u0008\u000b\u0010\u0008J\u001a\u0010\u000c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H&ø\u0001\u0000¢\u0006\u0004\u0008\u000e\u0010\u0008J\u0008\u0010\u000f\u001a\u00020\u0003H&J\u0008\u0010\u0010\u001a\u00020\u0003H&ø\u0001\u0001\u0082\u0002\r\n\u0005\u0008¡\u001e0\u0001\n\u0004\u0008!0\u0001¨\u0006\u0011À\u0006\u0001", d2 = {"Landroidx/compose/foundation/text/TextDragObserver;", "", "onCancel", "", "onDown", "point", "Landroidx/compose/ui/geometry/Offset;", "onDown-k-4lQ0M", "(J)V", "onDrag", "delta", "onDrag-k-4lQ0M", "onStart", "startPoint", "onStart-k-4lQ0M", "onStop", "onUp", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TextDragObserver {
    public abstract void onCancel();

    public abstract void onDown-k-4lQ0M(long l);

    public abstract void onDrag-k-4lQ0M(long l);

    public abstract void onStart-k-4lQ0M(long l);

    public abstract void onStop();

    public abstract void onUp();
}
