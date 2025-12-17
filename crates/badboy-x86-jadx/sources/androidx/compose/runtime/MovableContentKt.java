package androidx.compose.runtime;

import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\u001a)\u0010\u0002\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0008\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0008\u0005¢\u0006\u0002\u0010\u0007\u001a;\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\u0005\"\u0004\u0008\u0000\u0010\t2\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\u0005¢\u0006\u0002\u0010\n\u001aM\u0010\u0002\u001a\u0019\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\u0008\u0005\"\u0004\u0008\u0000\u0010\u000c\"\u0004\u0008\u0001\u0010\r2\u001d\u0010\u0006\u001a\u0019\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\u0008\u0005¢\u0006\u0002\u0010\u000e\u001a_\u0010\u0002\u001a\u001f\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\u0008\u0005\"\u0004\u0008\u0000\u0010\u000c\"\u0004\u0008\u0001\u0010\r\"\u0004\u0008\u0002\u0010\u00102#\u0010\u0006\u001a\u001f\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\u0008\u0005¢\u0006\u0002\u0010\u0011\u001aq\u0010\u0002\u001a%\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0002\u0008\u0005\"\u0004\u0008\u0000\u0010\u000c\"\u0004\u0008\u0001\u0010\r\"\u0004\u0008\u0002\u0010\u0010\"\u0004\u0008\u0003\u0010\u00132)\u0010\u0006\u001a%\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0002\u0008\u0005¢\u0006\u0002\u0010\u0014\u001aE\u0010\u0015\u001a\u0018\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\u0005¢\u0006\u0002\u0008\u0017\"\u0004\u0008\u0000\u0010\u00162\u001c\u0010\u0006\u001a\u0018\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u00020\u00040\u0008¢\u0006\u0002\u0008\u0005¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0010\n\u001aW\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\u0008\u0005¢\u0006\u0002\u0008\u0017\"\u0004\u0008\u0000\u0010\u0016\"\u0004\u0008\u0001\u0010\t2\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\u0008\u0005¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0010\u000e\u001ai\u0010\u0015\u001a$\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\u0008\u0005¢\u0006\u0002\u0008\u0017\"\u0004\u0008\u0000\u0010\u0016\"\u0004\u0008\u0001\u0010\u000c\"\u0004\u0008\u0002\u0010\r2(\u0010\u0006\u001a$\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\u0008\u0005¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0010\u0011\u001a{\u0010\u0015\u001a*\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0002\u0008\u0005¢\u0006\u0002\u0008\u0017\"\u0004\u0008\u0000\u0010\u0016\"\u0004\u0008\u0001\u0010\u000c\"\u0004\u0008\u0002\u0010\r\"\u0004\u0008\u0003\u0010\u00102.\u0010\u0006\u001a*\u0012\u0004\u0012\u0002H\u0016\u0012\u0004\u0012\u0002H\u000c\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u00040\u0012¢\u0006\u0002\u0008\u0005¢\u0006\u0002\u0008\u0017¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"movableContentKey", "", "movableContentOf", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "content", "(Lkotlin/jvm/functions/Function2;)Lkotlin/jvm/functions/Function2;", "Lkotlin/Function1;", "P", "(Lkotlin/jvm/functions/Function3;)Lkotlin/jvm/functions/Function3;", "Lkotlin/Function2;", "P1", "P2", "(Lkotlin/jvm/functions/Function4;)Lkotlin/jvm/functions/Function4;", "Lkotlin/Function3;", "P3", "(Lkotlin/jvm/functions/Function5;)Lkotlin/jvm/functions/Function5;", "Lkotlin/Function4;", "P4", "(Lkotlin/jvm/functions/Function6;)Lkotlin/jvm/functions/Function6;", "movableContentWithReceiverOf", "R", "Lkotlin/ExtensionFunctionType;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class MovableContentKt {

    public static final int movableContentKey = 126665345;
    public static final Function2<androidx.compose.runtime.Composer, Integer, Unit> movableContentOf(Function2<? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        MovableContentKt.movableContentOf.movableContent.1 anon = new MovableContentKt.movableContentOf.movableContent.1(content);
        final int i3 = 1;
        MovableContent movableContent = new MovableContent((Function3)ComposableLambdaKt.composableLambdaInstance(-1079330685, i3, anon));
        MovableContentKt.movableContentOf.1 anon2 = new MovableContentKt.movableContentOf.1(movableContent);
        return (Function2)ComposableLambdaKt.composableLambdaInstance(-642339857, i3, anon2);
    }

    public static final <P> Function3<P, androidx.compose.runtime.Composer, Integer, Unit> movableContentOf(Function3<? super P, ? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        MovableContent movableContent = new MovableContent(content);
        MovableContentKt.movableContentOf.2 anon = new MovableContentKt.movableContentOf.2(movableContent);
        return (Function3)ComposableLambdaKt.composableLambdaInstance(-434707029, true, anon);
    }

    public static final <P1, P2> Function4<P1, P2, androidx.compose.runtime.Composer, Integer, Unit> movableContentOf(Function4<? super P1, ? super P2, ? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        MovableContentKt.movableContentOf.movableContent.2 anon = new MovableContentKt.movableContentOf.movableContent.2(content);
        final int i3 = 1;
        MovableContent movableContent = new MovableContent((Function3)ComposableLambdaKt.composableLambdaInstance(1849814513, i3, anon));
        MovableContentKt.movableContentOf.3 anon2 = new MovableContentKt.movableContentOf.3(movableContent);
        return (Function4)ComposableLambdaKt.composableLambdaInstance(-1200019734, i3, anon2);
    }

    public static final <P1, P2, P3> Function5<P1, P2, P3, androidx.compose.runtime.Composer, Integer, Unit> movableContentOf(Function5<? super P1, ? super P2, ? super P3, ? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        MovableContentKt.movableContentOf.movableContent.3 anon = new MovableContentKt.movableContentOf.movableContent.3(content);
        final int i3 = 1;
        MovableContent movableContent = new MovableContent((Function3)ComposableLambdaKt.composableLambdaInstance(-284417101, i3, anon));
        MovableContentKt.movableContentOf.4 anon2 = new MovableContentKt.movableContentOf.4(movableContent);
        return (Function5)ComposableLambdaKt.composableLambdaInstance(-1083870185, i3, anon2);
    }

    public static final <P1, P2, P3, P4> Function6<P1, P2, P3, P4, androidx.compose.runtime.Composer, Integer, Unit> movableContentOf(Function6<? super P1, ? super P2, ? super P3, ? super P4, ? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        MovableContentKt.movableContentOf.movableContent.4 anon = new MovableContentKt.movableContentOf.movableContent.4(content);
        final int i3 = 1;
        MovableContent movableContent = new MovableContent((Function3)ComposableLambdaKt.composableLambdaInstance(1876318581, i3, anon));
        MovableContentKt.movableContentOf.5 anon2 = new MovableContentKt.movableContentOf.5(movableContent);
        return (Function6)ComposableLambdaKt.composableLambdaInstance(-1741877681, i3, anon2);
    }

    public static final <R> Function3<R, androidx.compose.runtime.Composer, Integer, Unit> movableContentWithReceiverOf(Function3<? super R, ? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        MovableContentKt.movableContentWithReceiverOf.movableContent.1 anon = new MovableContentKt.movableContentWithReceiverOf.movableContent.1(content);
        final int i3 = 1;
        MovableContent movableContent = new MovableContent((Function3)ComposableLambdaKt.composableLambdaInstance(250838178, i3, anon));
        MovableContentKt.movableContentWithReceiverOf.1 anon2 = new MovableContentKt.movableContentWithReceiverOf.1(movableContent);
        return (Function3)ComposableLambdaKt.composableLambdaInstance(506997506, i3, anon2);
    }

    public static final <R, P> Function4<R, P, androidx.compose.runtime.Composer, Integer, Unit> movableContentWithReceiverOf(Function4<? super R, ? super P, ? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        MovableContentKt.movableContentWithReceiverOf.movableContent.2 anon = new MovableContentKt.movableContentWithReceiverOf.movableContent.2(content);
        final int i3 = 1;
        MovableContent movableContent = new MovableContent((Function3)ComposableLambdaKt.composableLambdaInstance(812082854, i3, anon));
        MovableContentKt.movableContentWithReceiverOf.2 anon2 = new MovableContentKt.movableContentWithReceiverOf.2(movableContent);
        return (Function4)ComposableLambdaKt.composableLambdaInstance(627354118, i3, anon2);
    }

    public static final <R, P1, P2> Function5<R, P1, P2, androidx.compose.runtime.Composer, Integer, Unit> movableContentWithReceiverOf(Function5<? super R, ? super P1, ? super P2, ? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        MovableContentKt.movableContentWithReceiverOf.movableContent.3 anon = new MovableContentKt.movableContentWithReceiverOf.movableContent.3(content);
        final int i3 = 1;
        MovableContent movableContent = new MovableContent((Function3)ComposableLambdaKt.composableLambdaInstance(-1322148760, i3, anon));
        MovableContentKt.movableContentWithReceiverOf.3 anon2 = new MovableContentKt.movableContentWithReceiverOf.3(movableContent);
        return (Function5)ComposableLambdaKt.composableLambdaInstance(583402949, i3, anon2);
    }

    public static final <R, P1, P2, P3> Function6<R, P1, P2, P3, androidx.compose.runtime.Composer, Integer, Unit> movableContentWithReceiverOf(Function6<? super R, ? super P1, ? super P2, ? super P3, ? super androidx.compose.runtime.Composer, ? super Integer, Unit> content) {
        MovableContentKt.movableContentWithReceiverOf.movableContent.4 anon = new MovableContentKt.movableContentWithReceiverOf.movableContent.4(content);
        final int i3 = 1;
        MovableContent movableContent = new MovableContent((Function3)ComposableLambdaKt.composableLambdaInstance(838586922, i3, anon));
        MovableContentKt.movableContentWithReceiverOf.4 anon2 = new MovableContentKt.movableContentWithReceiverOf.4(movableContent);
        return (Function6)ComposableLambdaKt.composableLambdaInstance(1468683306, i3, anon2);
    }
}
