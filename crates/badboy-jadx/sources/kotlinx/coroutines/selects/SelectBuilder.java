package kotlinx.coroutines.selects;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u0008v\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00002\u00020\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u001c\u0010\u0007\u001a\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0008H\u0017ø\u0001\u0000¢\u0006\u0002\u0010\nJ3\u0010\u000b\u001a\u00020\u0004*\u00020\u000c2\u001c\u0010\u0007\u001a\u0018\u0008\u0001\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0008H¦\u0002ø\u0001\u0000¢\u0006\u0002\u0010\rJE\u0010\u000b\u001a\u00020\u0004\"\u0004\u0008\u0001\u0010\u000e*\u0008\u0012\u0004\u0012\u0002H\u000e0\u000f2\"\u0010\u0007\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010H¦\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0011JY\u0010\u000b\u001a\u00020\u0004\"\u0004\u0008\u0001\u0010\u0012\"\u0004\u0008\u0002\u0010\u000e*\u000e\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u0002H\u00122\"\u0010\u0007\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010H¦\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0015JS\u0010\u000b\u001a\u00020\u0004\"\u0004\u0008\u0001\u0010\u0012\"\u0004\u0008\u0002\u0010\u000e*\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0012\u0012\u0004\u0012\u0002H\u000e0\u00132\"\u0010\u0007\u001a\u001e\u0008\u0001\u0012\u0004\u0012\u0002H\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00028\u00000\t\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0010H\u0096\u0002ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u0082\u0001\u0001\u0017\u0082\u0002\u0004\n\u0002\u0008\u0019¨\u0006\u0018", d2 = {"Lkotlinx/coroutines/selects/SelectBuilder;", "R", "", "onTimeout", "", "timeMillis", "", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(JLkotlin/jvm/functions/Function1;)V", "invoke", "Lkotlinx/coroutines/selects/SelectClause0;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Lkotlinx/coroutines/selects/SelectClause2;Lkotlin/jvm/functions/Function2;)V", "Lkotlinx/coroutines/selects/SelectImplementation;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SelectBuilder<R>  {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static <R, P, Q> void invoke(kotlinx.coroutines.selects.SelectBuilder<? super R> $this, kotlinx.coroutines.selects.SelectClause2<? super P, ? extends Q> $receiver, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> block) {
            $this.invoke($receiver, 0, block);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @ReplaceWith(...))
        public static <R> void onTimeout(kotlinx.coroutines.selects.SelectBuilder<? super R> $this, long timeMillis, Function1<? super Continuation<? super R>, ? extends Object> block) {
            OnTimeoutKt.onTimeout($this, timeMillis, block);
        }
    }
    public abstract void invoke(kotlinx.coroutines.selects.SelectClause0 selectClause0, Function1<? super Continuation<? super R>, ? extends Object> function12);

    public abstract <Q> void invoke(kotlinx.coroutines.selects.SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function22);

    public abstract <P, Q> void invoke(kotlinx.coroutines.selects.SelectClause2<? super P, ? extends Q> selectClause2, P p2, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function23);

    public abstract <P, Q> void invoke(kotlinx.coroutines.selects.SelectClause2<? super P, ? extends Q> selectClause2, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function22);

    @Deprecated(level = DeprecationLevel.ERROR, message = "Replaced with the same extension function", replaceWith = @ReplaceWith(...))
    public abstract void onTimeout(long l, Function1<? super Continuation<? super R>, ? extends Object> function12);
}
