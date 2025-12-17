package androidx.core.content;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import androidx.core.util.Predicate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes5.dex */
public class IntentSanitizer {

    private static final String TAG = "IntentSanitizer";
    private boolean mAllowAnyComponent;
    private boolean mAllowClipDataText;
    private boolean mAllowIdentifier;
    private boolean mAllowSelector;
    private boolean mAllowSourceBounds;
    private Predicate<String> mAllowedActions;
    private Predicate<String> mAllowedCategories;
    private Predicate<ClipData> mAllowedClipData;
    private Predicate<Uri> mAllowedClipDataUri;
    private Predicate<ComponentName> mAllowedComponents;
    private Predicate<Uri> mAllowedData;
    private Map<String, Predicate<Object>> mAllowedExtras;
    private int mAllowedFlags;
    private Predicate<String> mAllowedPackages;
    private Predicate<String> mAllowedTypes;

    private static class Api29Impl {
        static String getIdentifier(Intent intent) {
            return intent.getIdentifier();
        }

        static Intent setIdentifier(Intent intent, String identifier) {
            return intent.setIdentifier(identifier);
        }
    }

    private static class Api31Impl {
        static void checkOtherMembers(int i, ClipData.Item item, Consumer<String> consumer3) {
            Object textLinks;
            String str;
            if (item.getHtmlText() == null && item.getIntent() == null) {
                if (item.getIntent() == null) {
                    if (item.getTextLinks() != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        consumer3.accept(stringBuilder.append("ClipData item at position ").append(i).append(" contains htmlText, textLinks or intent: ").append(item).toString());
                    }
                } else {
                }
            } else {
            }
        }
    }

    public static final class Builder {

        private static final int HISTORY_STACK_FLAGS = 2112614400;
        private static final int RECEIVER_FLAGS = 2015363072;
        private boolean mAllowAnyComponent;
        private boolean mAllowClipDataText = false;
        private boolean mAllowIdentifier;
        private boolean mAllowSelector;
        private boolean mAllowSomeComponents;
        private boolean mAllowSourceBounds;
        private Predicate<String> mAllowedActions;
        private Predicate<String> mAllowedCategories;
        private Predicate<ClipData> mAllowedClipData;
        private Predicate<Uri> mAllowedClipDataUri;
        private Predicate<ComponentName> mAllowedComponents;
        private Predicate<Uri> mAllowedData;
        private Map<String, Predicate<Object>> mAllowedExtras;
        private int mAllowedFlags;
        private Predicate<String> mAllowedPackages;
        private Predicate<String> mAllowedTypes;
        public static boolean $r8$lambda$DvjTS4tHjUqRA2QfyccBu7fhDzE(String string, Object object2) {
            return string.equals(object2);
        }

        public static boolean $r8$lambda$HF7enmHP1Z3cPiyI1KCE8M8gPts(ComponentName componentName, Object object2) {
            return componentName.equals(object2);
        }

        public Builder() {
            super();
            IntentSanitizer.Builder$$ExternalSyntheticLambda10 externalSyntheticLambda10 = new IntentSanitizer.Builder$$ExternalSyntheticLambda10();
            this.mAllowedActions = externalSyntheticLambda10;
            IntentSanitizer.Builder$$ExternalSyntheticLambda11 externalSyntheticLambda11 = new IntentSanitizer.Builder$$ExternalSyntheticLambda11();
            this.mAllowedData = externalSyntheticLambda11;
            IntentSanitizer.Builder$$ExternalSyntheticLambda12 externalSyntheticLambda12 = new IntentSanitizer.Builder$$ExternalSyntheticLambda12();
            this.mAllowedTypes = externalSyntheticLambda12;
            IntentSanitizer.Builder$$ExternalSyntheticLambda13 externalSyntheticLambda13 = new IntentSanitizer.Builder$$ExternalSyntheticLambda13();
            this.mAllowedCategories = externalSyntheticLambda13;
            IntentSanitizer.Builder$$ExternalSyntheticLambda14 externalSyntheticLambda14 = new IntentSanitizer.Builder$$ExternalSyntheticLambda14();
            this.mAllowedPackages = externalSyntheticLambda14;
            IntentSanitizer.Builder$$ExternalSyntheticLambda15 externalSyntheticLambda15 = new IntentSanitizer.Builder$$ExternalSyntheticLambda15();
            this.mAllowedComponents = externalSyntheticLambda15;
            HashMap hashMap = new HashMap();
            this.mAllowedExtras = hashMap;
            int i = 0;
            IntentSanitizer.Builder$$ExternalSyntheticLambda16 externalSyntheticLambda16 = new IntentSanitizer.Builder$$ExternalSyntheticLambda16();
            this.mAllowedClipDataUri = externalSyntheticLambda16;
            IntentSanitizer.Builder$$ExternalSyntheticLambda17 externalSyntheticLambda17 = new IntentSanitizer.Builder$$ExternalSyntheticLambda17();
            this.mAllowedClipData = externalSyntheticLambda17;
        }

        static boolean lambda$allowAnyComponent$10(ComponentName v) {
            return 1;
        }

        static boolean lambda$allowClipDataUriWithAuthority$11(String authority, Uri v) {
            return authority.equals(v.getAuthority());
        }

        static boolean lambda$allowComponentWithPackage$9(String packageName, ComponentName v) {
            return packageName.equals(v.getPackageName());
        }

        static boolean lambda$allowDataWithAuthority$8(String authority, Uri v) {
            return authority.equals(v.getAuthority());
        }

        static boolean lambda$allowExtra$12(Object v) {
            return 1;
        }

        static boolean lambda$allowExtra$13(Class clazz, Predicate valueFilter, Object v) {
            boolean instance;
            int i;
            if (clazz.isInstance(v) && valueFilter.test(clazz.cast(v))) {
                i = valueFilter.test(clazz.cast(v)) ? 1 : 0;
            } else {
            }
            return i;
        }

        static boolean lambda$allowExtra$14(Object v) {
            return 0;
        }

        static boolean lambda$allowExtraOutput$16(String uriAuthority, Uri v) {
            return uriAuthority.equals(v.getAuthority());
        }

        static boolean lambda$allowExtraStreamUriWithAuthority$15(String uriAuthority, Uri v) {
            return uriAuthority.equals(v.getAuthority());
        }

        static boolean lambda$new$0(String v) {
            return 0;
        }

        static boolean lambda$new$1(Uri v) {
            return 0;
        }

        static boolean lambda$new$2(String v) {
            return 0;
        }

        static boolean lambda$new$3(String v) {
            return 0;
        }

        static boolean lambda$new$4(String v) {
            return 0;
        }

        static boolean lambda$new$5(ComponentName v) {
            return 0;
        }

        static boolean lambda$new$6(Uri v) {
            return 0;
        }

        static boolean lambda$new$7(ClipData v) {
            return 0;
        }

        public androidx.core.content.IntentSanitizer.Builder allowAction(Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedActions = this.mAllowedActions.or(predicate);
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowAction(String action) {
            Preconditions.checkNotNull(action);
            Objects.requireNonNull(action);
            IntentSanitizer.Builder$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new IntentSanitizer.Builder$$ExternalSyntheticLambda1(action);
            allowAction(externalSyntheticLambda1);
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowAnyComponent() {
            this.mAllowAnyComponent = true;
            IntentSanitizer.Builder$$ExternalSyntheticLambda6 externalSyntheticLambda6 = new IntentSanitizer.Builder$$ExternalSyntheticLambda6();
            this.mAllowedComponents = externalSyntheticLambda6;
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowCategory(Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedCategories = this.mAllowedCategories.or(predicate);
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowCategory(String category) {
            Preconditions.checkNotNull(category);
            Objects.requireNonNull(category);
            IntentSanitizer.Builder$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new IntentSanitizer.Builder$$ExternalSyntheticLambda1(category);
            return allowCategory(externalSyntheticLambda1);
        }

        public androidx.core.content.IntentSanitizer.Builder allowClipData(Predicate<ClipData> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedClipData = this.mAllowedClipData.or(predicate);
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowClipDataText() {
            this.mAllowClipDataText = true;
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowClipDataUri(Predicate<Uri> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedClipDataUri = this.mAllowedClipDataUri.or(predicate);
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowClipDataUriWithAuthority(String authority) {
            Preconditions.checkNotNull(authority);
            IntentSanitizer.Builder$$ExternalSyntheticLambda7 externalSyntheticLambda7 = new IntentSanitizer.Builder$$ExternalSyntheticLambda7(authority);
            return allowClipDataUri(externalSyntheticLambda7);
        }

        public androidx.core.content.IntentSanitizer.Builder allowComponent(ComponentName component) {
            Preconditions.checkNotNull(component);
            Objects.requireNonNull(component);
            IntentSanitizer.Builder$$ExternalSyntheticLambda5 externalSyntheticLambda5 = new IntentSanitizer.Builder$$ExternalSyntheticLambda5(component);
            return allowComponent(externalSyntheticLambda5);
        }

        public androidx.core.content.IntentSanitizer.Builder allowComponent(Predicate<ComponentName> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowSomeComponents = true;
            this.mAllowedComponents = this.mAllowedComponents.or(predicate);
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowComponentWithPackage(String packageName) {
            Preconditions.checkNotNull(packageName);
            IntentSanitizer.Builder$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new IntentSanitizer.Builder$$ExternalSyntheticLambda2(packageName);
            return allowComponent(externalSyntheticLambda2);
        }

        public androidx.core.content.IntentSanitizer.Builder allowData(Predicate<Uri> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedData = this.mAllowedData.or(predicate);
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowDataWithAuthority(String authority) {
            Preconditions.checkNotNull(authority);
            IntentSanitizer.Builder$$ExternalSyntheticLambda3 externalSyntheticLambda3 = new IntentSanitizer.Builder$$ExternalSyntheticLambda3(authority);
            allowData(externalSyntheticLambda3);
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowExtra(String key, Predicate<Object> predicate2) {
            Object allowedExtra;
            androidx.core.content.IntentSanitizer.Builder$$ExternalSyntheticLambda8 externalSyntheticLambda8;
            Preconditions.checkNotNull(key);
            Preconditions.checkNotNull(predicate2);
            if ((Predicate)this.mAllowedExtras.get(key) == null) {
                externalSyntheticLambda8 = new IntentSanitizer.Builder$$ExternalSyntheticLambda8();
                allowedExtra = externalSyntheticLambda8;
            }
            this.mAllowedExtras.put(key, allowedExtra.or(predicate2));
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowExtra(String key, Class<?> class2) {
            IntentSanitizer.Builder$$ExternalSyntheticLambda18 externalSyntheticLambda18 = new IntentSanitizer.Builder$$ExternalSyntheticLambda18();
            return allowExtra(key, class2, externalSyntheticLambda18);
        }

        public <T> androidx.core.content.IntentSanitizer.Builder allowExtra(String key, Class<T> class2, Predicate<T> predicate3) {
            Preconditions.checkNotNull(key);
            Preconditions.checkNotNull(class2);
            Preconditions.checkNotNull(predicate3);
            IntentSanitizer.Builder$$ExternalSyntheticLambda4 externalSyntheticLambda4 = new IntentSanitizer.Builder$$ExternalSyntheticLambda4(class2, predicate3);
            return allowExtra(key, externalSyntheticLambda4);
        }

        public androidx.core.content.IntentSanitizer.Builder allowExtraOutput(Predicate<Uri> predicate) {
            allowExtra("output", Uri.class, predicate);
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowExtraOutput(String uriAuthority) {
            IntentSanitizer.Builder$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new IntentSanitizer.Builder$$ExternalSyntheticLambda0(uriAuthority);
            allowExtra("output", Uri.class, externalSyntheticLambda0);
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowExtraStream(Predicate<Uri> predicate) {
            allowExtra("android.intent.extra.STREAM", Uri.class, predicate);
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowExtraStreamUriWithAuthority(String uriAuthority) {
            Preconditions.checkNotNull(uriAuthority);
            IntentSanitizer.Builder$$ExternalSyntheticLambda9 externalSyntheticLambda9 = new IntentSanitizer.Builder$$ExternalSyntheticLambda9(uriAuthority);
            allowExtra("android.intent.extra.STREAM", Uri.class, externalSyntheticLambda9);
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowFlags(int flags) {
            this.mAllowedFlags = mAllowedFlags |= flags;
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowHistoryStackFlags() {
            this.mAllowedFlags = mAllowedFlags |= i2;
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowIdentifier() {
            this.mAllowIdentifier = true;
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowPackage(Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedPackages = this.mAllowedPackages.or(predicate);
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowPackage(String packageName) {
            Preconditions.checkNotNull(packageName);
            Objects.requireNonNull(packageName);
            IntentSanitizer.Builder$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new IntentSanitizer.Builder$$ExternalSyntheticLambda1(packageName);
            return allowPackage(externalSyntheticLambda1);
        }

        public androidx.core.content.IntentSanitizer.Builder allowReceiverFlags() {
            this.mAllowedFlags = mAllowedFlags |= i2;
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowSelector() {
            this.mAllowSelector = true;
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowSourceBounds() {
            this.mAllowSourceBounds = true;
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowType(Predicate<String> predicate) {
            Preconditions.checkNotNull(predicate);
            this.mAllowedTypes = this.mAllowedTypes.or(predicate);
            return this;
        }

        public androidx.core.content.IntentSanitizer.Builder allowType(String type) {
            Preconditions.checkNotNull(type);
            Objects.requireNonNull(type);
            IntentSanitizer.Builder$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new IntentSanitizer.Builder$$ExternalSyntheticLambda1(type);
            return allowType(externalSyntheticLambda1);
        }

        public androidx.core.content.IntentSanitizer build() {
            boolean mAllowSomeComponents;
            if (this.mAllowAnyComponent && !this.mAllowSomeComponents) {
                if (this.mAllowSomeComponents) {
                } else {
                    if (!this.mAllowAnyComponent) {
                        if (!this.mAllowSomeComponents) {
                        } else {
                        }
                    }
                }
                SecurityException securityException = new SecurityException("You must call either allowAnyComponent or one or more of the allowComponent methods; but not both.");
                throw securityException;
            } else {
            }
            IntentSanitizer intentSanitizer = new IntentSanitizer(0);
            IntentSanitizer.access$102(intentSanitizer, this.mAllowedFlags);
            IntentSanitizer.access$202(intentSanitizer, this.mAllowedActions);
            IntentSanitizer.access$302(intentSanitizer, this.mAllowedData);
            IntentSanitizer.access$402(intentSanitizer, this.mAllowedTypes);
            IntentSanitizer.access$502(intentSanitizer, this.mAllowedCategories);
            IntentSanitizer.access$602(intentSanitizer, this.mAllowedPackages);
            IntentSanitizer.access$702(intentSanitizer, this.mAllowAnyComponent);
            IntentSanitizer.access$802(intentSanitizer, this.mAllowedComponents);
            IntentSanitizer.access$902(intentSanitizer, this.mAllowedExtras);
            IntentSanitizer.access$1002(intentSanitizer, this.mAllowClipDataText);
            IntentSanitizer.access$1102(intentSanitizer, this.mAllowedClipDataUri);
            IntentSanitizer.access$1202(intentSanitizer, this.mAllowedClipData);
            IntentSanitizer.access$1302(intentSanitizer, this.mAllowIdentifier);
            IntentSanitizer.access$1402(intentSanitizer, this.mAllowSelector);
            IntentSanitizer.access$1502(intentSanitizer, this.mAllowSourceBounds);
            return intentSanitizer;
        }
    }
    IntentSanitizer(androidx.core.content.IntentSanitizer.1 x0) {
        super();
    }

    static boolean access$1002(androidx.core.content.IntentSanitizer x0, boolean x1) {
        x0.mAllowClipDataText = x1;
        return x1;
    }

    static int access$102(androidx.core.content.IntentSanitizer x0, int x1) {
        x0.mAllowedFlags = x1;
        return x1;
    }

    static Predicate access$1102(androidx.core.content.IntentSanitizer x0, Predicate x1) {
        x0.mAllowedClipDataUri = x1;
        return x1;
    }

    static Predicate access$1202(androidx.core.content.IntentSanitizer x0, Predicate x1) {
        x0.mAllowedClipData = x1;
        return x1;
    }

    static boolean access$1302(androidx.core.content.IntentSanitizer x0, boolean x1) {
        x0.mAllowIdentifier = x1;
        return x1;
    }

    static boolean access$1402(androidx.core.content.IntentSanitizer x0, boolean x1) {
        x0.mAllowSelector = x1;
        return x1;
    }

    static boolean access$1502(androidx.core.content.IntentSanitizer x0, boolean x1) {
        x0.mAllowSourceBounds = x1;
        return x1;
    }

    static Predicate access$202(androidx.core.content.IntentSanitizer x0, Predicate x1) {
        x0.mAllowedActions = x1;
        return x1;
    }

    static Predicate access$302(androidx.core.content.IntentSanitizer x0, Predicate x1) {
        x0.mAllowedData = x1;
        return x1;
    }

    static Predicate access$402(androidx.core.content.IntentSanitizer x0, Predicate x1) {
        x0.mAllowedTypes = x1;
        return x1;
    }

    static Predicate access$502(androidx.core.content.IntentSanitizer x0, Predicate x1) {
        x0.mAllowedCategories = x1;
        return x1;
    }

    static Predicate access$602(androidx.core.content.IntentSanitizer x0, Predicate x1) {
        x0.mAllowedPackages = x1;
        return x1;
    }

    static boolean access$702(androidx.core.content.IntentSanitizer x0, boolean x1) {
        x0.mAllowAnyComponent = x1;
        return x1;
    }

    static Predicate access$802(androidx.core.content.IntentSanitizer x0, Predicate x1) {
        x0.mAllowedComponents = x1;
        return x1;
    }

    static Map access$902(androidx.core.content.IntentSanitizer x0, Map x1) {
        x0.mAllowedExtras = x1;
        return x1;
    }

    private static void checkOtherMembers(int i, ClipData.Item item, Consumer<String> consumer3) {
        Object htmlText;
        String str;
        if (item.getHtmlText() == null) {
            if (item.getIntent() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                consumer3.accept(stringBuilder.append("ClipData item at position ").append(i).append(" contains htmlText, textLinks or intent: ").append(item).toString());
            }
        } else {
        }
    }

    static void lambda$sanitizeByFiltering$0(String msg) {
    }

    static void lambda$sanitizeByThrowing$1(String msg) {
        SecurityException securityException = new SecurityException(msg);
        throw securityException;
    }

    private void putExtra(Intent intent, String key, Object value) {
        Object extras;
        int i;
        if (value == null) {
            intent.getExtras().putString(key, 0);
        } else {
            if (value instanceof Parcelable) {
                intent.putExtra(key, (Parcelable)value);
            } else {
                if (value instanceof Parcelable[]) {
                    intent.putExtra(key, (Parcelable[])value);
                } else {
                    if (!value instanceof Serializable) {
                    } else {
                        intent.putExtra(key, (Serializable)value);
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Unsupported type ").append(value.getClass()).toString());
        throw illegalArgumentException;
    }

    static void sanitizeClipData(Intent in, Intent out, Predicate<ClipData> predicate3, boolean mAllowClipDataText, Predicate<Uri> predicate5, Consumer<String> consumer6) {
        int newClipData;
        boolean i;
        ClipData.Item itemCount;
        int itemText;
        int itemUri;
        java.lang.CharSequence string2;
        java.lang.CharSequence string;
        ClipData clipData;
        android.content.ClipDescription stringBuilder;
        ClipData.Item item;
        final ClipData clipData2 = in.getClipData();
        if (clipData2 == null) {
        }
        newClipData = 0;
        if (predicate3 != null && predicate3.test(clipData2)) {
            if (predicate3.test(clipData2)) {
                out.setClipData(clipData2);
            } else {
                i = 0;
                while (i < clipData2.getItemCount()) {
                    itemCount = clipData2.getItemAt(i);
                    if (Build.VERSION.SDK_INT >= 31) {
                    } else {
                    }
                    IntentSanitizer.checkOtherMembers(i, itemCount, consumer6);
                    itemText = 0;
                    if (mAllowClipDataText) {
                    } else {
                    }
                    if (itemCount.getText() != null) {
                    }
                    itemUri = 0;
                    string = ". URI: ";
                    clipData = "Item URI is not allowed. Item position: ";
                    if (predicate5 == null) {
                    } else {
                    }
                    if (itemCount.getUri() != null) {
                    } else {
                    }
                    itemUri = itemCount.getUri();
                    if (itemText == 0) {
                    } else {
                    }
                    string = 0;
                    if (newClipData == null) {
                    } else {
                    }
                    clipData = new ClipData.Item(itemText, string, itemUri);
                    newClipData.addItem(clipData);
                    i++;
                    item = new ClipData.Item(itemText, string, itemUri);
                    clipData = new ClipData(clipData2.getDescription(), item);
                    newClipData = clipData;
                    if (itemUri != 0) {
                    }
                    if (predicate5.test(itemCount.getUri())) {
                    } else {
                    }
                    stringBuilder = new StringBuilder();
                    consumer6.accept(stringBuilder.append(clipData).append(i).append(string).append(itemCount.getUri()).toString());
                    if (itemCount.getUri() != null) {
                    }
                    stringBuilder = new StringBuilder();
                    consumer6.accept(stringBuilder.append(clipData).append(i).append(string).append(itemCount.getUri()).toString());
                    StringBuilder stringBuilder2 = new StringBuilder();
                    consumer6.accept(stringBuilder2.append("Item text cannot contain value. Item position: ").append(i).append(". Text: ").append(itemCount.getText()).toString());
                    itemText = itemCount.getText();
                    IntentSanitizer.Api31Impl.checkOtherMembers(i, itemCount, consumer6);
                }
                if (newClipData != null) {
                    out.setClipData(newClipData);
                }
            }
        } else {
        }
    }

    public Intent sanitize(Intent in, Consumer<String> consumer2) {
        boolean mAllowAnyComponent;
        String string;
        Object iterator;
        String identifier;
        Object selector;
        Object sourceBounds;
        String str;
        String mAllowedFlags;
        Object mAllowedClipData;
        String string2;
        boolean equals;
        boolean equals2;
        String str2;
        String string3;
        String str3;
        final Object obj = this;
        final Consumer consumer = consumer2;
        Intent intent2 = new Intent();
        final ComponentName component = in.getComponent();
        if (obj.mAllowAnyComponent) {
            if (component != null) {
                if (obj.mAllowedComponents.test(component)) {
                    intent2.setComponent(component);
                } else {
                    StringBuilder stringBuilder9 = new StringBuilder();
                    consumer.accept(stringBuilder9.append("Component is not allowed: ").append(component).toString());
                    mAllowAnyComponent = new ComponentName("android", "java.lang.Void");
                    intent2.setComponent(mAllowAnyComponent);
                }
            } else {
            }
        } else {
        }
        final String package = in.getPackage();
        if (package != null) {
            if (obj.mAllowedPackages.test(package)) {
                intent2.setPackage(package);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                consumer.accept(stringBuilder.append("Package is not allowed: ").append(package).toString());
            }
        } else {
        }
        if (mAllowedFlags2 |= flags == obj.mAllowedFlags) {
            intent2.setFlags(in.getFlags());
        } else {
            intent2.setFlags(mAllowedFlags3 &= flags2);
            StringBuilder stringBuilder2 = new StringBuilder();
            consumer.accept(stringBuilder2.append("The intent contains flags that are not allowed: 0x").append(Integer.toHexString(flags3 &= string2)).toString());
        }
        final String action = in.getAction();
        if (action != null) {
            if (obj.mAllowedActions.test(action)) {
                intent2.setAction(action);
            } else {
                StringBuilder stringBuilder8 = new StringBuilder();
                consumer.accept(stringBuilder8.append("Action is not allowed: ").append(action).toString());
            }
        } else {
        }
        final Uri data = in.getData();
        if (data != null) {
            if (obj.mAllowedData.test(data)) {
                intent2.setData(data);
            } else {
                StringBuilder stringBuilder7 = new StringBuilder();
                consumer.accept(stringBuilder7.append("Data is not allowed: ").append(data).toString());
            }
        } else {
        }
        final String type = in.getType();
        if (type != null) {
            if (obj.mAllowedTypes.test(type)) {
                intent2.setDataAndType(intent2.getData(), type);
            } else {
                StringBuilder stringBuilder3 = new StringBuilder();
                consumer.accept(stringBuilder3.append("Type is not allowed: ").append(type).toString());
            }
        } else {
        }
        final Set categories = in.getCategories();
        if (categories != null) {
            iterator = categories.iterator();
            while (iterator.hasNext()) {
                mAllowedFlags = iterator.next();
                if (obj.mAllowedCategories.test((String)mAllowedFlags)) {
                } else {
                }
                StringBuilder stringBuilder10 = new StringBuilder();
                consumer.accept(stringBuilder10.append("Category is not allowed: ").append(mAllowedFlags).toString());
                intent2.addCategory(mAllowedFlags);
            }
        }
        final Bundle extras = in.getExtras();
        if (extras != null) {
            iterator = extras.keySet().iterator();
            while (iterator.hasNext()) {
                mAllowedFlags = iterator.next();
                if ((String)mAllowedFlags.equals("android.intent.extra.STREAM") && mAllowedFlags6 &= 1 == 0) {
                } else {
                }
                if (mAllowedFlags.equals("output") && i4 &= 3 != 0) {
                } else {
                }
                string2 = extras.get(mAllowedFlags);
                str2 = obj.mAllowedExtras.get(mAllowedFlags);
                if (str2 != null && (Predicate)str2.test(string2)) {
                } else {
                }
                StringBuilder stringBuilder11 = new StringBuilder();
                consumer.accept(stringBuilder11.append("Extra is not allowed. Key: ").append(mAllowedFlags).append(". Value: ").append(string2).toString());
                if (str2.test(string2)) {
                } else {
                }
                obj.putExtra(intent2, mAllowedFlags, string2);
                if (i4 &= 3 != 0) {
                } else {
                }
                consumer.accept("Allowing Extra Output requires also allowing FLAG_GRANT_READ_URI_PERMISSION and FLAG_GRANT_WRITE_URI_PERMISSION Flags.");
                if (mAllowedFlags6 &= 1 == 0) {
                } else {
                }
                consumer.accept("Allowing Extra Stream requires also allowing at least  FLAG_GRANT_READ_URI_PERMISSION Flag.");
            }
        }
        IntentSanitizer.sanitizeClipData(in, intent2, obj.mAllowedClipData, obj.mAllowClipDataText, obj.mAllowedClipDataUri, consumer);
        if (obj.mAllowIdentifier) {
            IntentSanitizer.Api29Impl.setIdentifier(intent2, IntentSanitizer.Api29Impl.getIdentifier(in));
        } else {
            if (IntentSanitizer.Api29Impl.getIdentifier(in) != null) {
                StringBuilder stringBuilder6 = new StringBuilder();
                consumer.accept(stringBuilder6.append("Identifier is not allowed: ").append(IntentSanitizer.Api29Impl.getIdentifier(in)).toString());
            }
        }
        if (obj.mAllowSelector) {
            intent2.setSelector(in.getSelector());
        } else {
            if (in.getSelector() != null) {
                StringBuilder stringBuilder4 = new StringBuilder();
                consumer.accept(stringBuilder4.append("Selector is not allowed: ").append(in.getSelector()).toString());
            }
        }
        if (obj.mAllowSourceBounds) {
            intent2.setSourceBounds(in.getSourceBounds());
        } else {
            if (in.getSourceBounds() != null) {
                StringBuilder stringBuilder5 = new StringBuilder();
                consumer.accept(stringBuilder5.append("SourceBounds is not allowed: ").append(in.getSourceBounds()).toString());
            }
        }
        return intent2;
    }

    public Intent sanitizeByFiltering(Intent in) {
        IntentSanitizer$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new IntentSanitizer$$ExternalSyntheticLambda1();
        return sanitize(in, externalSyntheticLambda1);
    }

    public Intent sanitizeByThrowing(Intent in) {
        IntentSanitizer$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new IntentSanitizer$$ExternalSyntheticLambda0();
        return sanitize(in, externalSyntheticLambda0);
    }
}
