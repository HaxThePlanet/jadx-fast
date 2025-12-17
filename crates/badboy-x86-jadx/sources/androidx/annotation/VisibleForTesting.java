package androidx.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Retention;

/* loaded from: classes.dex */
@Documented
@Retention(RetentionPolicy.CLASS)
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0087\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\n\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0004¨\u0006\u0006", d2 = {"Landroidx/annotation/VisibleForTesting;", "", "otherwise", "", "()I", "Companion", "annotation"}, k = 1, mv = {1, 9, 0}, xi = 48)
@MustBeDocumented
@Retention(AnnotationRetention.BINARY)
public @interface VisibleForTesting {

    public static final androidx.annotation.VisibleForTesting.Companion Companion = null;
    public static final int NONE = 5;
    public static final int PACKAGE_PRIVATE = 3;
    public static final int PRIVATE = 2;
    public static final int PROTECTED = 4;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Landroidx/annotation/VisibleForTesting$Companion;", "", "()V", "NONE", "", "PACKAGE_PRIVATE", "PRIVATE", "PROTECTED", "annotation"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        static final androidx.annotation.VisibleForTesting.Companion $$INSTANCE = null;
        public static final int NONE = 5;
        public static final int PACKAGE_PRIVATE = 3;
        public static final int PRIVATE = 2;
        public static final int PROTECTED = 4;
        static {
            VisibleForTesting.Companion companion = new VisibleForTesting.Companion();
            VisibleForTesting.Companion.$$INSTANCE = companion;
        }
    }
    static {
        VisibleForTesting.Companion = VisibleForTesting.Companion.$$INSTANCE;
    }

    @Override // java.lang.annotation.Annotation
    public abstract int otherwise() default 2;
}
