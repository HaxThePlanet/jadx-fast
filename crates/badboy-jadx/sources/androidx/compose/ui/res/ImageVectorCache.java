package androidx.compose.ui.res;

import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import androidx.compose.ui.graphics.vector.ImageVector;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0000\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000c\u001a\u00020\u0005H\u0086\u0002J\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0019\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H\u0086\u0002R6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00070\u0006`\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Landroidx/compose/ui/res/ImageVectorCache;", "", "()V", "map", "Ljava/util/HashMap;", "Landroidx/compose/ui/res/ImageVectorCache$Key;", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/res/ImageVectorCache$ImageVectorEntry;", "Lkotlin/collections/HashMap;", "clear", "", "get", "key", "prune", "configChanges", "", "set", "imageVectorEntry", "ImageVectorEntry", "Key", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ImageVectorCache {

    public static final int $stable = 8;
    private final HashMap<androidx.compose.ui.res.ImageVectorCache.Key, WeakReference<androidx.compose.ui.res.ImageVectorCache.ImageVectorEntry>> map;

    @Metadata(d1 = "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0014", d2 = {"Landroidx/compose/ui/res/ImageVectorCache$ImageVectorEntry;", "", "imageVector", "Landroidx/compose/ui/graphics/vector/ImageVector;", "configFlags", "", "(Landroidx/compose/ui/graphics/vector/ImageVector;I)V", "getConfigFlags", "()I", "getImageVector", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ImageVectorEntry {

        public static final int $stable;
        private final int configFlags;
        private final ImageVector imageVector;
        static {
        }

        public ImageVectorEntry(ImageVector imageVector, int configFlags) {
            super();
            this.imageVector = imageVector;
            this.configFlags = configFlags;
        }

        public static androidx.compose.ui.res.ImageVectorCache.ImageVectorEntry copy$default(androidx.compose.ui.res.ImageVectorCache.ImageVectorEntry imageVectorCache$ImageVectorEntry, ImageVector imageVector2, int i3, int i4, Object object5) {
            ImageVector obj1;
            int obj2;
            if (i4 & 1 != 0) {
                obj1 = imageVectorEntry.imageVector;
            }
            if (i4 &= 2 != 0) {
                obj2 = imageVectorEntry.configFlags;
            }
            return imageVectorEntry.copy(obj1, obj2);
        }

        public final ImageVector component1() {
            return this.imageVector;
        }

        public final int component2() {
            return this.configFlags;
        }

        public final androidx.compose.ui.res.ImageVectorCache.ImageVectorEntry copy(ImageVector imageVector, int i2) {
            ImageVectorCache.ImageVectorEntry imageVectorEntry = new ImageVectorCache.ImageVectorEntry(imageVector, i2);
            return imageVectorEntry;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (!object instanceof ImageVectorCache.ImageVectorEntry) {
                return i2;
            }
            Object obj = object;
            if (!Intrinsics.areEqual(this.imageVector, obj.imageVector)) {
                return i2;
            }
            if (this.configFlags != obj.configFlags) {
                return i2;
            }
            return i;
        }

        public final int getConfigFlags() {
            return this.configFlags;
        }

        public final ImageVector getImageVector() {
            return this.imageVector;
        }

        public int hashCode() {
            return i2 += i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("ImageVectorEntry(imageVector=").append(this.imageVector).append(", configFlags=").append(this.configFlags).append(')').toString();
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\r\u0010\u000c\u001a\u00060\u0003R\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\u000c\u0008\u0002\u0010\u0002\u001a\u00060\u0003R\u00020\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u0015", d2 = {"Landroidx/compose/ui/res/ImageVectorCache$Key;", "", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "id", "", "(Landroid/content/res/Resources$Theme;I)V", "getId", "()I", "getTheme", "()Landroid/content/res/Resources$Theme;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Key {

        public static final int $stable = 8;
        private final int id;
        private final Resources.Theme theme;
        static {
            final int i = 8;
        }

        public Key(Resources.Theme theme, int id) {
            super();
            this.theme = theme;
            this.id = id;
        }

        public static androidx.compose.ui.res.ImageVectorCache.Key copy$default(androidx.compose.ui.res.ImageVectorCache.Key imageVectorCache$Key, Resources.Theme resources$Theme2, int i3, int i4, Object object5) {
            Resources.Theme obj1;
            int obj2;
            if (i4 & 1 != 0) {
                obj1 = key.theme;
            }
            if (i4 &= 2 != 0) {
                obj2 = key.id;
            }
            return key.copy(obj1, obj2);
        }

        public final Resources.Theme component1() {
            return this.theme;
        }

        public final int component2() {
            return this.id;
        }

        public final androidx.compose.ui.res.ImageVectorCache.Key copy(Resources.Theme resources$Theme, int i2) {
            ImageVectorCache.Key key = new ImageVectorCache.Key(theme, i2);
            return key;
        }

        public boolean equals(Object object) {
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i3 = 0;
            if (!object instanceof ImageVectorCache.Key) {
                return i3;
            }
            Object obj = object;
            if (!Intrinsics.areEqual(this.theme, obj.theme)) {
                return i3;
            }
            if (this.id != obj.id) {
                return i3;
            }
            return i;
        }

        public final int getId() {
            return this.id;
        }

        public final Resources.Theme getTheme() {
            return this.theme;
        }

        public int hashCode() {
            return i2 += i5;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append("Key(theme=").append(this.theme).append(", id=").append(this.id).append(')').toString();
        }
    }
    static {
        final int i = 8;
    }

    public ImageVectorCache() {
        super();
        HashMap hashMap = new HashMap();
        this.map = hashMap;
    }

    public final void clear() {
        this.map.clear();
    }

    public final androidx.compose.ui.res.ImageVectorCache.ImageVectorEntry get(androidx.compose.ui.res.ImageVectorCache.Key key) {
        Object obj;
        Object obj2 = this.map.get(key);
        if ((WeakReference)obj2 != null) {
            obj = (WeakReference)obj2.get();
        } else {
            obj = 0;
        }
        return obj;
    }

    public final void prune(int configChanges) {
        Object next;
        Object obj;
        boolean needNewResources;
        Iterator iterator = this.map.entrySet().iterator();
        while (iterator.hasNext()) {
            obj = (WeakReference)(Map.Entry)iterator.next().getValue().get();
            if ((ImageVectorCache.ImageVectorEntry)obj != null) {
            } else {
            }
            iterator.remove();
            if (Configuration.needNewResources(configChanges, (ImageVectorCache.ImageVectorEntry)obj.getConfigFlags())) {
            }
        }
    }

    public final void set(androidx.compose.ui.res.ImageVectorCache.Key key, androidx.compose.ui.res.ImageVectorCache.ImageVectorEntry imageVectorEntry) {
        WeakReference weakReference = new WeakReference(imageVectorEntry);
        (Map)this.map.put(key, weakReference);
    }
}
