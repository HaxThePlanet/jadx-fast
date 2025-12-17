package kotlinx.serialization;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.MustBeDocumented;
import kotlin.annotation.Target;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* loaded from: classes5.dex */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({})
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0005B\n\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0004¨\u0006\u0006", d2 = {"Lkotlinx/serialization/EncodeDefault;", "", "mode", "Lkotlinx/serialization/EncodeDefault$Mode;", "()Lkotlinx/serialization/EncodeDefault$Mode;", "Mode", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
@MustBeDocumented
@Target(allowedTargets = AnnotationTarget.PROPERTY)
@ExperimentalSerializationApi
public @interface EncodeDefault {

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0005\u0008\u0087\u0081\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\t\u0008\u0002¢\u0006\u0004\u0008\u0002\u0010\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005¨\u0006\u0006", d2 = {"Lkotlinx/serialization/EncodeDefault$Mode;", "", "<init>", "(Ljava/lang/String;I)V", "ALWAYS", "NEVER", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @ExperimentalSerializationApi
    public static enum Mode {

        ALWAYS,
        NEVER;
        private static final kotlinx.serialization.EncodeDefault.Mode[] $values() {
            return /* result */;
        }

        public static EnumEntries<kotlinx.serialization.EncodeDefault.Mode> getEntries() {
            return EncodeDefault.Mode.$ENTRIES;
        }
    }
    @Override // java.lang.annotation.Annotation
    public abstract kotlinx.serialization.EncodeDefault.Mode mode() default EncodeDefault$Mode.ALWAYS;
}
