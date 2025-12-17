package kotlin.coroutines.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Target;

/* loaded from: classes5.dex */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0011\u0008\u0081\u0002\u0018\u00002\u00020\u0001B\\\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0008\u0002\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00050\t\u0012\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00050\t\u0012\u0008\u0008\u0002\u0010\u000b\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u000c\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\r\u001a\u00020\u0005R\u0011\u0010\r\u001a\u00020\u00058\u0007¢\u0006\u0006\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u00078\u0007¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\u0006\u001a\u0004\u0008\u0012\u0010\u0011R\u0017\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u00020\u00050\t8\u0007¢\u0006\u0006\u001a\u0004\u0008\u0013\u0010\u0014R\u0011\u0010\u000c\u001a\u00020\u00058\u0007¢\u0006\u0006\u001a\u0004\u0008\u0015\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\u0006\u001a\u0004\u0008\u0016\u0010\u000fR\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00050\t8\u0007¢\u0006\u0006\u001a\u0004\u0008\u0017\u0010\u0014R\u0011\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\u0006\u001a\u0004\u0008\u0018\u0010\u0019¨\u0006\u001a", d2 = {"Lkotlin/coroutines/jvm/internal/DebugMetadata;", "", "version", "", "sourceFile", "", "lineNumbers", "", "localNames", "", "spilled", "indexToLabel", "methodName", "className", "c", "()Ljava/lang/String;", "i", "()[I", "l", "n", "()[Ljava/lang/String;", "m", "f", "s", "v", "()I", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Target(allowedTargets = AnnotationTarget.CLASS)
public @interface DebugMetadata {
    @Override // java.lang.annotation.Annotation
    public abstract String c() default "";

    @Override // java.lang.annotation.Annotation
    public abstract String f() default "";

    @Override // java.lang.annotation.Annotation
    public abstract int[] i() default {};

    @Override // java.lang.annotation.Annotation
    public abstract int[] l() default {};

    @Override // java.lang.annotation.Annotation
    public abstract String m() default "";

    @Override // java.lang.annotation.Annotation
    public abstract String[] n() default {};

    @Override // java.lang.annotation.Annotation
    public abstract String[] s() default {};

    @Override // java.lang.annotation.Annotation
    public abstract int v() default 1;
}
