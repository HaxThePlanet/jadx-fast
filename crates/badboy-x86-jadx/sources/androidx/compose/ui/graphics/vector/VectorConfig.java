package androidx.compose.ui.graphics.vector;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u0002H\u0003\"\u0004\u0008\u0000\u0010\u00032\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u00052\u0006\u0010\u0006\u001a\u0002H\u0003H\u0016¢\u0006\u0002\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0008À\u0006\u0003", d2 = {"Landroidx/compose/ui/graphics/vector/VectorConfig;", "", "getOrDefault", "T", "property", "Landroidx/compose/ui/graphics/vector/VectorProperty;", "defaultValue", "(Landroidx/compose/ui/graphics/vector/VectorProperty;Ljava/lang/Object;)Ljava/lang/Object;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface VectorConfig {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> T getOrDefault(androidx.compose.ui.graphics.vector.VectorConfig $this, androidx.compose.ui.graphics.vector.VectorProperty<T> property, T defaultValue) {
            return VectorConfig.access$getOrDefault$jd($this, property, defaultValue);
        }
    }
    public static Object access$getOrDefault$jd(androidx.compose.ui.graphics.vector.VectorConfig $this, androidx.compose.ui.graphics.vector.VectorProperty property, Object defaultValue) {
        return super.getOrDefault(property, defaultValue);
    }

    public <T> T getOrDefault(androidx.compose.ui.graphics.vector.VectorProperty<T> property, T defaultValue) {
        return defaultValue;
    }
}
