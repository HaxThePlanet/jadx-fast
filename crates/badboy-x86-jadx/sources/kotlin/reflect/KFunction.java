package kotlin.reflect;

import kotlin.Function;
import kotlin.Metadata;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000c\u0008f\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u0008\u0012\u0004\u0012\u0002H\u00010\u0003R\u001a\u0010\u0004\u001a\u00020\u00058&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u0006\u0010\u0007\u001a\u0004\u0008\u0004\u0010\u0008R\u001a\u0010\t\u001a\u00020\u00058&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\n\u0010\u0007\u001a\u0004\u0008\t\u0010\u0008R\u001a\u0010\u000b\u001a\u00020\u00058&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u000c\u0010\u0007\u001a\u0004\u0008\u000b\u0010\u0008R\u001a\u0010\r\u001a\u00020\u00058&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u000e\u0010\u0007\u001a\u0004\u0008\r\u0010\u0008R\u001a\u0010\u000f\u001a\u00020\u00058&X§\u0004¢\u0006\u000c\u0012\u0004\u0008\u0010\u0010\u0007\u001a\u0004\u0008\u000f\u0010\u0008¨\u0006\u0011", d2 = {"Lkotlin/reflect/KFunction;", "R", "Lkotlin/reflect/KCallable;", "Lkotlin/Function;", "isExternal", "", "isExternal$annotations", "()V", "()Z", "isInfix", "isInfix$annotations", "isInline", "isInline$annotations", "isOperator", "isOperator$annotations", "isSuspend", "isSuspend$annotations", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface KFunction<R>  extends kotlin.reflect.KCallable<R>, Function<R> {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void isExternal$annotations() {
        }

        public static void isInfix$annotations() {
        }

        public static void isInline$annotations() {
        }

        public static void isOperator$annotations() {
        }

        public static void isSuspend$annotations() {
        }
    }
    @Override // kotlin.reflect.KCallable
    public abstract boolean isExternal();

    @Override // kotlin.reflect.KCallable
    public abstract boolean isInfix();

    @Override // kotlin.reflect.KCallable
    public abstract boolean isInline();

    @Override // kotlin.reflect.KCallable
    public abstract boolean isOperator();

    @Override // kotlin.reflect.KCallable
    public abstract boolean isSuspend();
}
