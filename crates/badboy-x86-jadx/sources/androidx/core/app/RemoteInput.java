package androidx.core.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class RemoteInput {

    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private static final String EXTRA_RESULTS_SOURCE = "android.remoteinput.resultsSource";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT;
    private final boolean mAllowFreeFormTextInput;
    private final Set<String> mAllowedDataTypes;
    private final java.lang.CharSequence[] mChoices;
    private final int mEditChoicesBeforeSending;
    private final Bundle mExtras;
    private final java.lang.CharSequence mLabel;
    private final String mResultKey;

    static class Api20Impl {
        static void addResultsToIntent(Object remoteInputs, Intent intent, Bundle results) {
            RemoteInput.addResultsToIntent((RemoteInput[])remoteInputs, intent, results);
        }

        public static RemoteInput fromCompat(androidx.core.app.RemoteInput src) {
            Iterator iterator;
            Object next;
            int i;
            RemoteInput.Builder builder = new RemoteInput.Builder(src.getResultKey());
            RemoteInput.Builder extras = builder.setLabel(src.getLabel()).setChoices(src.getChoices()).setAllowFreeFormInput(src.getAllowFreeFormInput()).addExtras(src.getExtras());
            Set allowedDataTypes = src.getAllowedDataTypes();
            if (allowedDataTypes != null) {
                iterator = allowedDataTypes.iterator();
                for (String next : iterator) {
                    RemoteInput.Api26Impl.setAllowDataType(extras, next, true);
                }
            }
            RemoteInput.Api29Impl.setEditChoicesBeforeSending(extras, src.getEditChoicesBeforeSending());
            return extras.build();
        }

        static androidx.core.app.RemoteInput fromPlatform(Object srcObj) {
            Iterator iterator;
            Object next;
            int i;
            final Object obj = srcObj;
            RemoteInput.Builder builder = new RemoteInput.Builder((RemoteInput)obj.getResultKey());
            androidx.core.app.RemoteInput.Builder extras = builder.setLabel(obj.getLabel()).setChoices(obj.getChoices()).setAllowFreeFormInput(obj.getAllowFreeFormInput()).addExtras(obj.getExtras());
            Set allowedDataTypes = RemoteInput.Api26Impl.getAllowedDataTypes(obj);
            if (allowedDataTypes != null) {
                iterator = allowedDataTypes.iterator();
                for (String next : iterator) {
                    extras.setAllowDataType(next, true);
                }
            }
            extras.setEditChoicesBeforeSending(RemoteInput.Api29Impl.getEditChoicesBeforeSending(obj));
            return extras.build();
        }

        static Bundle getResultsFromIntent(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    static class Api26Impl {
        static void addDataResultToIntent(androidx.core.app.RemoteInput remoteInput, Intent intent, Map<String, Uri> map3) {
            RemoteInput.addDataResultToIntent(RemoteInput.fromCompat(remoteInput), intent, map3);
        }

        static Set<String> getAllowedDataTypes(Object remoteInput) {
            return (RemoteInput)remoteInput.getAllowedDataTypes();
        }

        static Map<String, Uri> getDataResultsFromIntent(Intent intent, String remoteInputResultKey) {
            return RemoteInput.getDataResultsFromIntent(intent, remoteInputResultKey);
        }

        static RemoteInput.Builder setAllowDataType(RemoteInput.Builder builder, String mimeType, boolean doAllow) {
            return builder.setAllowDataType(mimeType, doAllow);
        }
    }

    static class Api28Impl {
        static int getResultsSource(Intent intent) {
            return RemoteInput.getResultsSource(intent);
        }

        static void setResultsSource(Intent intent, int source) {
            RemoteInput.setResultsSource(intent, source);
        }
    }

    static class Api29Impl {
        static int getEditChoicesBeforeSending(Object remoteInput) {
            return (RemoteInput)remoteInput.getEditChoicesBeforeSending();
        }

        static RemoteInput.Builder setEditChoicesBeforeSending(RemoteInput.Builder builder, int editChoicesBeforeSending) {
            return builder.setEditChoicesBeforeSending(editChoicesBeforeSending);
        }
    }

    public static final class Builder {

        private boolean mAllowFreeFormTextInput = true;
        private final Set<String> mAllowedDataTypes;
        private java.lang.CharSequence[] mChoices;
        private int mEditChoicesBeforeSending = 0;
        private final Bundle mExtras;
        private java.lang.CharSequence mLabel;
        private final String mResultKey;
        public Builder(String resultKey) {
            super();
            HashSet hashSet = new HashSet();
            this.mAllowedDataTypes = hashSet;
            Bundle bundle = new Bundle();
            this.mExtras = bundle;
            int i = 1;
            int i2 = 0;
            if (resultKey == null) {
            } else {
                this.mResultKey = resultKey;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Result key can't be null");
            throw illegalArgumentException;
        }

        public androidx.core.app.RemoteInput.Builder addExtras(Bundle extras) {
            Bundle mExtras;
            if (extras != null) {
                this.mExtras.putAll(extras);
            }
            return this;
        }

        public androidx.core.app.RemoteInput build() {
            RemoteInput remoteInput = new RemoteInput(this.mResultKey, this.mLabel, this.mChoices, this.mAllowFreeFormTextInput, this.mEditChoicesBeforeSending, this.mExtras, this.mAllowedDataTypes);
            return remoteInput;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }

        public androidx.core.app.RemoteInput.Builder setAllowDataType(String mimeType, boolean doAllow) {
            Set mAllowedDataTypes;
            if (doAllow) {
                this.mAllowedDataTypes.add(mimeType);
            } else {
                this.mAllowedDataTypes.remove(mimeType);
            }
            return this;
        }

        public androidx.core.app.RemoteInput.Builder setAllowFreeFormInput(boolean allowFreeFormTextInput) {
            this.mAllowFreeFormTextInput = allowFreeFormTextInput;
            return this;
        }

        public androidx.core.app.RemoteInput.Builder setChoices(java.lang.CharSequence[] choices) {
            this.mChoices = choices;
            return this;
        }

        public androidx.core.app.RemoteInput.Builder setEditChoicesBeforeSending(int editChoicesBeforeSending) {
            this.mEditChoicesBeforeSending = editChoicesBeforeSending;
            return this;
        }

        public androidx.core.app.RemoteInput.Builder setLabel(java.lang.CharSequence label) {
            this.mLabel = label;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface EditChoicesBeforeSending {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Source {
    }
    RemoteInput(String resultKey, java.lang.CharSequence label, java.lang.CharSequence[] choices, boolean allowFreeFormTextInput, int editChoicesBeforeSending, Bundle extras, Set<String> set7) {
        int editChoicesBeforeSending2;
        super();
        this.mResultKey = resultKey;
        this.mLabel = label;
        this.mChoices = choices;
        this.mAllowFreeFormTextInput = allowFreeFormTextInput;
        this.mEditChoicesBeforeSending = editChoicesBeforeSending;
        this.mExtras = extras;
        this.mAllowedDataTypes = set7;
        if (getEditChoicesBeforeSending() == 2) {
            if (!getAllowFreeFormInput()) {
            } else {
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
            throw illegalArgumentException;
        }
    }

    public static void addDataResultToIntent(androidx.core.app.RemoteInput remoteInput, Intent intent, Map<String, Uri> map3) {
        RemoteInput.Api26Impl.addDataResultToIntent(remoteInput, intent, map3);
    }

    public static void addResultsToIntent(androidx.core.app.RemoteInput[] remoteInputs, Intent intent, Bundle results) {
        RemoteInput.Api20Impl.addResultsToIntent(RemoteInput.fromCompat(remoteInputs), intent, results);
    }

    static RemoteInput fromCompat(androidx.core.app.RemoteInput src) {
        return RemoteInput.Api20Impl.fromCompat(src);
    }

    static RemoteInput[] fromCompat(androidx.core.app.RemoteInput[] srcArray) {
        int i;
        RemoteInput compat;
        if (srcArray == null) {
            return null;
        }
        RemoteInput[] arr = new RemoteInput[srcArray.length];
        i = 0;
        for (Object obj : srcArray) {
            arr[i] = RemoteInput.fromCompat(obj);
        }
        return arr;
    }

    static androidx.core.app.RemoteInput fromPlatform(RemoteInput src) {
        return RemoteInput.Api20Impl.fromPlatform(src);
    }

    private static Intent getClipDataIntentFromIntent(Intent intent) {
        final ClipData clipData = intent.getClipData();
        int i = 0;
        if (clipData == null) {
            return i;
        }
        final ClipDescription description = clipData.getDescription();
        if (!description.hasMimeType("text/vnd.android.intent")) {
            return i;
        }
        if (!description.getLabel().toString().contentEquals("android.remoteinput.results")) {
            return i;
        }
        return clipData.getItemAt(0).getIntent();
    }

    public static Map<String, Uri> getDataResultsFromIntent(Intent intent, String remoteInputResultKey) {
        return RemoteInput.Api26Impl.getDataResultsFromIntent(intent, remoteInputResultKey);
    }

    private static String getExtraResultsKeyForData(String mimeType) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("android.remoteinput.dataTypeResultsData").append(mimeType).toString();
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        return RemoteInput.Api20Impl.getResultsFromIntent(intent);
    }

    public static int getResultsSource(Intent intent) {
        return RemoteInput.Api28Impl.getResultsSource(intent);
    }

    public static void setResultsSource(Intent intent, int source) {
        RemoteInput.Api28Impl.setResultsSource(intent, source);
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    public Set<String> getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    public java.lang.CharSequence[] getChoices() {
        return this.mChoices;
    }

    public int getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public java.lang.CharSequence getLabel() {
        return this.mLabel;
    }

    public String getResultKey() {
        return this.mResultKey;
    }

    public boolean isDataOnly() {
        int i;
        boolean allowFreeFormInput;
        if (!getAllowFreeFormInput()) {
            if (getChoices() != null) {
                if (choices.length == 0 && getAllowedDataTypes() != null && !getAllowedDataTypes().isEmpty()) {
                    if (getAllowedDataTypes() != null) {
                        i = !getAllowedDataTypes().isEmpty() ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
