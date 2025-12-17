package kotlin;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Target;

/* loaded from: classes5.dex */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({})
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0087\u0002\u0018\u00002\u00020\u0001B\u0008\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0004¨\u0006\u0005", d2 = {"Lkotlin/ContextFunctionTypeParams;", "", "count", "", "()I", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@MustBeDocumented
@Target(allowedTargets = AnnotationTarget.TYPE)
public @interface ContextFunctionTypeParams {
    @Override // java.lang.annotation.Annotation
    public abstract int count();
}
