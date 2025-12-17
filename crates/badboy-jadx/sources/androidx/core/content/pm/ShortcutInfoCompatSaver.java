package androidx.core.content.pm;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class ShortcutInfoCompatSaver<T>  {

    public static class NoopImpl extends androidx.core.content.pm.ShortcutInfoCompatSaver<Void> {
        public Object addShortcuts(List list) {
            return addShortcuts(list);
        }

        public Void addShortcuts(List<androidx.core.content.pm.ShortcutInfoCompat> list) {
            return null;
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        public Object removeAllShortcuts() {
            return removeAllShortcuts();
        }

        @Override // androidx.core.content.pm.ShortcutInfoCompatSaver
        public Void removeAllShortcuts() {
            return null;
        }

        public Object removeShortcuts(List list) {
            return removeShortcuts(list);
        }

        public Void removeShortcuts(List<String> list) {
            return null;
        }
    }
    public abstract T addShortcuts(List<androidx.core.content.pm.ShortcutInfoCompat> list);

    public List<androidx.core.content.pm.ShortcutInfoCompat> getShortcuts() throws Exception {
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    public abstract T removeAllShortcuts();

    public abstract T removeShortcuts(List<String> list);
}
