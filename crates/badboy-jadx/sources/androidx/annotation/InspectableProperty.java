package androidx.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
@Deprecated(message = "Replaced by the androidx.resourceinpsection package.")
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\u0008\u0087\u0002\u0018\u00002\u00020\u0001:\u0003\u0015\u0016\u0017BH\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u0012\u000e\u0008\u0002\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b\u0012\u000e\u0008\u0002\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000bR\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u000fR\u0015\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000c0\u000b¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0010R\u0015\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u0011R\u000f\u0010\u0006\u001a\u00020\u0007¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0012R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0013R\u000f\u0010\u0008\u001a\u00020\t¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\u0014¨\u0006\u0018", d2 = {"Landroidx/annotation/InspectableProperty;", "", "name", "", "attributeId", "", "hasAttributeId", "", "valueType", "Landroidx/annotation/InspectableProperty$ValueType;", "enumMapping", "", "Landroidx/annotation/InspectableProperty$EnumEntry;", "flagMapping", "Landroidx/annotation/InspectableProperty$FlagEntry;", "()I", "()[Landroidx/annotation/InspectableProperty$EnumEntry;", "()[Landroidx/annotation/InspectableProperty$FlagEntry;", "()Z", "()Ljava/lang/String;", "()Landroidx/annotation/InspectableProperty$ValueType;", "EnumEntry", "FlagEntry", "ValueType", "annotation"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Retention(AnnotationRetention.SOURCE)
@Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
public @interface InspectableProperty {

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0087\u0002\u0018\u00002\u00020\u0001B\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0006R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0007¨\u0006\u0008", d2 = {"Landroidx/annotation/InspectableProperty$EnumEntry;", "", "name", "", "value", "", "()Ljava/lang/String;", "()I", "annotation"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Retention(AnnotationRetention.SOURCE)
    @Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    public @interface EnumEntry {
        @Override // java.lang.annotation.Annotation
        public abstract String name();

        @Override // java.lang.annotation.Annotation
        public abstract int value();
    }

    @Retention(RetentionPolicy.SOURCE)
    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\u0008\u0087\u0002\u0018\u00002\u00020\u0001B\u001a\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005R\u000f\u0010\u0006\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\u0008\u0006\u0010\u0007R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0008R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\u0008\u0004\u0010\u0007¨\u0006\t", d2 = {"Landroidx/annotation/InspectableProperty$FlagEntry;", "", "name", "", "target", "", "mask", "()I", "()Ljava/lang/String;", "annotation"}, k = 1, mv = {1, 9, 0}, xi = 48)
    @Retention(AnnotationRetention.SOURCE)
    @Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CLASS})
    public @interface FlagEntry {
        @Override // java.lang.annotation.Annotation
        public abstract int mask() default 0;

        @Override // java.lang.annotation.Annotation
        public abstract String name();

        @Override // java.lang.annotation.Annotation
        public abstract int target();
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\t\u0008\u0086\u0081\u0002\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004j\u0002\u0008\u0005j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\t¨\u0006\n", d2 = {"Landroidx/annotation/InspectableProperty$ValueType;", "", "(Ljava/lang/String;I)V", "NONE", "INFERRED", "INT_ENUM", "INT_FLAG", "COLOR", "GRAVITY", "RESOURCE_ID", "annotation"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static enum ValueType {

        NONE,
        INFERRED,
        INT_ENUM,
        INT_FLAG,
        COLOR,
        GRAVITY,
        RESOURCE_ID;
        private static final androidx.annotation.InspectableProperty.ValueType[] $values() {
            return /* result */;
        }

        public static EnumEntries<androidx.annotation.InspectableProperty.ValueType> getEntries() {
            return InspectableProperty.ValueType.$ENTRIES;
        }
    }
    @Override // java.lang.annotation.Annotation
    public abstract int attributeId() default 0;

    @Override // java.lang.annotation.Annotation
    public abstract androidx.annotation.InspectableProperty.EnumEntry[] enumMapping() default {};

    @Override // java.lang.annotation.Annotation
    public abstract androidx.annotation.InspectableProperty.FlagEntry[] flagMapping() default {};

    @Override // java.lang.annotation.Annotation
    public abstract boolean hasAttributeId() default true;

    @Override // java.lang.annotation.Annotation
    public abstract String name() default "";

    @Override // java.lang.annotation.Annotation
    public abstract androidx.annotation.InspectableProperty.ValueType valueType() default InspectableProperty$ValueType.INFERRED;
}
