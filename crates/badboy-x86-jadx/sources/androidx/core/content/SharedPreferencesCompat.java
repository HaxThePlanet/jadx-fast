package androidx.core.content;

import android.content.SharedPreferences.Editor;

/* loaded from: classes5.dex */
@Deprecated
public final class SharedPreferencesCompat {

    @Deprecated
    public static final class EditorCompat {

        private static androidx.core.content.SharedPreferencesCompat.EditorCompat sInstance;
        private final androidx.core.content.SharedPreferencesCompat.EditorCompat.Helper mHelper;
        private EditorCompat() {
            super();
            SharedPreferencesCompat.EditorCompat.Helper helper = new SharedPreferencesCompat.EditorCompat.Helper();
            this.mHelper = helper;
        }

        @Deprecated
        public static androidx.core.content.SharedPreferencesCompat.EditorCompat getInstance() {
            androidx.core.content.SharedPreferencesCompat.EditorCompat editorCompat;
            if (SharedPreferencesCompat.EditorCompat.sInstance == null) {
                editorCompat = new SharedPreferencesCompat.EditorCompat();
                SharedPreferencesCompat.EditorCompat.sInstance = editorCompat;
            }
            return SharedPreferencesCompat.EditorCompat.sInstance;
        }

        @Deprecated
        public void apply(SharedPreferences.Editor editor) {
            this.mHelper.apply(editor);
        }
    }
}
