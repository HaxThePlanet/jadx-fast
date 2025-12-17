package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B-\u0012&\u0010\u0003\u001a\"\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004¢\u0006\u0002\u0008\t¢\u0006\u0002\u0010\nR3\u0010\u0003\u001a\"\u0012\u0013\u0012\u00118\u0000¢\u0006\u000c\u0008\u0005\u0012\u0008\u0008\u0006\u0012\u0004\u0008\u0008(\u0007\u0012\u0004\u0012\u00020\u00080\u0004¢\u0006\u0002\u0008\t¢\u0006\n\n\u0002\u0010\r\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u000e", d2 = {"Landroidx/compose/runtime/MovableContent;", "P", "", "content", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "parameter", "", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function3;)V", "getContent", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class MovableContent<P>  {

    public static final int $stable;
    private final Function3<P, androidx.compose.runtime.Composer, Integer, Unit> content;
    static {
    }

    public MovableContent(Function3<? super P, ? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        super();
        this.content = content;
    }

    public final Function3<P, androidx.compose.runtime.Composer, Integer, Unit> getContent() {
        return this.content;
    }
}
