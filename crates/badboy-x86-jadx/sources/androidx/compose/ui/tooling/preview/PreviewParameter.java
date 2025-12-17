package androidx.compose.ui.tooling.preview;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Retention(RetentionPolicy.RUNTIME)
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0002\u0018\u00002\u00020\u0001B\u001e\u0012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\u00040\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006R\u000f\u0010\u0005\u001a\u00020\u0006¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0007R\u001b\u0010\u0002\u001a\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\u00040\u0003¢\u0006\u0006\u001a\u0004\u0008\u0002\u0010\u0008¨\u0006\t", d2 = {"Landroidx/compose/ui/tooling/preview/PreviewParameter;", "", "provider", "Lkotlin/reflect/KClass;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "limit", "", "()I", "()Ljava/lang/Class;", "ui-tooling-preview_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public @interface PreviewParameter {
    @Override // java.lang.annotation.Annotation
    public abstract int limit() default 2147483647;

    public abstract Class<? extends androidx.compose.ui.tooling.preview.PreviewParameterProvider<?>> provider();
}
