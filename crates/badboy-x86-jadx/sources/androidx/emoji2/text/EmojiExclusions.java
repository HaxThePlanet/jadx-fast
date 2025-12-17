package androidx.emoji2.text;

import android.os.Build.VERSION;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes5.dex */
class EmojiExclusions {

    private static class EmojiExclusions_Api34 {
        static Set<int[]> getExclusions() {
            return EmojiExclusions.EmojiExclusions_Reflections.getExclusions();
        }
    }

    private static class EmojiExclusions_Reflections {
        static Set<int[]> getExclusions() {
            Object next;
            boolean z;
            try {
                int i = 0;
                Object invoke = Class.forName("android.text.EmojiConsistency").getMethod("getEmojiConsistencySet", new Class[i]).invoke(0, new Object[i]);
                if (invoke == null) {
                }
                return Collections.emptySet();
                Object obj = invoke;
                Iterator iterator = (Set)obj.iterator();
                for (Object next : iterator) {
                }
                if (!next instanceof int[]) {
                } else {
                }
                return Collections.emptySet();
                return obj;
                return Collections.emptySet();
            }
        }
    }
    static Set<int[]> getEmojiExclusions() {
        if (Build.VERSION.SDK_INT >= 34) {
            return EmojiExclusions.EmojiExclusions_Api34.getExclusions();
        }
        return EmojiExclusions.EmojiExclusions_Reflections.getExclusions();
    }
}
