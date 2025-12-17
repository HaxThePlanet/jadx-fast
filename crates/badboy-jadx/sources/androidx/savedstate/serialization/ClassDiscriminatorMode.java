package androidx.savedstate.serialization;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008Æ\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Landroidx/savedstate/serialization/ClassDiscriminatorMode;", "", "<init>", "()V", "ALL_OBJECTS", "", "POLYMORPHIC", "Definition", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClassDiscriminatorMode {

    public static final int ALL_OBJECTS = 1;
    public static final androidx.savedstate.serialization.ClassDiscriminatorMode INSTANCE = null;
    public static final int POLYMORPHIC = 2;

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = "\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\u0008\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002", d2 = {"Landroidx/savedstate/serialization/ClassDiscriminatorMode$Definition;", "", "savedstate_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @Retention(AnnotationRetention.SOURCE)
    public @interface Definition {
    }
    static {
        ClassDiscriminatorMode classDiscriminatorMode = new ClassDiscriminatorMode();
        ClassDiscriminatorMode.INSTANCE = classDiscriminatorMode;
    }
}
