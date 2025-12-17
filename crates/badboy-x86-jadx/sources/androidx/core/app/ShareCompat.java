package androidx.core.app;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class ShareCompat {

    public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
    public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
    public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
    private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";

    public static class IntentBuilder {

        private ArrayList<String> mBccAddresses;
        private ArrayList<String> mCcAddresses;
        private java.lang.CharSequence mChooserTitle;
        private final Context mContext;
        private final Intent mIntent;
        private ArrayList<Uri> mStreams;
        private ArrayList<String> mToAddresses;
        public IntentBuilder(Context launchingContext) {
            int activity;
            Object context;
            String packageName;
            boolean componentName;
            Intent mIntent;
            String str;
            super();
            this.mContext = (Context)Preconditions.checkNotNull(launchingContext);
            Intent intent = new Intent();
            this.mIntent = intent.setAction("android.intent.action.SEND");
            this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", launchingContext.getPackageName());
            this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", launchingContext.getPackageName());
            this.mIntent.addFlags(524288);
            activity = 0;
            context = launchingContext;
            while (context instanceof ContextWrapper) {
                if (context instanceof Activity != null) {
                    break;
                } else {
                }
                context = (ContextWrapper)context.getBaseContext();
            }
            if (activity != null) {
                componentName = activity.getComponentName();
                this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", componentName);
                this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", componentName);
            }
        }

        private void combineArrayExtra(String extra, ArrayList<String> arrayList2) {
            int length;
            int size;
            String[] stringArrayExtra = this.mIntent.getStringArrayExtra(extra);
            int i = 0;
            length = stringArrayExtra != null ? stringArrayExtra.length : i;
            String[] strArr = new String[size2 += length];
            arrayList2.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, i, strArr, arrayList2.size(), length);
            }
            this.mIntent.putExtra(extra, strArr);
        }

        private void combineArrayExtra(String extra, String[] add) {
            int length;
            final Intent intent = getIntent();
            final String[] stringArrayExtra = intent.getStringArrayExtra(extra);
            final int i = 0;
            length = stringArrayExtra != null ? stringArrayExtra.length : i;
            String[] strArr = new String[length2 += length];
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, i, strArr, i, length);
            }
            System.arraycopy(add, i, strArr, length, add.length);
            intent.putExtra(extra, strArr);
        }

        @Deprecated
        public static androidx.core.app.ShareCompat.IntentBuilder from(Activity launchingActivity) {
            ShareCompat.IntentBuilder intentBuilder = new ShareCompat.IntentBuilder(launchingActivity);
            return intentBuilder;
        }

        public androidx.core.app.ShareCompat.IntentBuilder addEmailBcc(String address) {
            ArrayList mBccAddresses;
            if (this.mBccAddresses == null) {
                mBccAddresses = new ArrayList();
                this.mBccAddresses = mBccAddresses;
            }
            this.mBccAddresses.add(address);
            return this;
        }

        public androidx.core.app.ShareCompat.IntentBuilder addEmailBcc(String[] addresses) {
            combineArrayExtra("android.intent.extra.BCC", addresses);
            return this;
        }

        public androidx.core.app.ShareCompat.IntentBuilder addEmailCc(String address) {
            ArrayList mCcAddresses;
            if (this.mCcAddresses == null) {
                mCcAddresses = new ArrayList();
                this.mCcAddresses = mCcAddresses;
            }
            this.mCcAddresses.add(address);
            return this;
        }

        public androidx.core.app.ShareCompat.IntentBuilder addEmailCc(String[] addresses) {
            combineArrayExtra("android.intent.extra.CC", addresses);
            return this;
        }

        public androidx.core.app.ShareCompat.IntentBuilder addEmailTo(String address) {
            ArrayList mToAddresses;
            if (this.mToAddresses == null) {
                mToAddresses = new ArrayList();
                this.mToAddresses = mToAddresses;
            }
            this.mToAddresses.add(address);
            return this;
        }

        public androidx.core.app.ShareCompat.IntentBuilder addEmailTo(String[] addresses) {
            combineArrayExtra("android.intent.extra.EMAIL", addresses);
            return this;
        }

        public androidx.core.app.ShareCompat.IntentBuilder addStream(Uri streamUri) {
            ArrayList arrayList;
            if (this.mStreams == null) {
                arrayList = new ArrayList();
                this.mStreams = arrayList;
            }
            this.mStreams.add(streamUri);
            return this;
        }

        public Intent createChooserIntent() {
            return Intent.createChooser(getIntent(), this.mChooserTitle);
        }

        Context getContext() {
            return this.mContext;
        }

        public Intent getIntent() {
            Object mToAddresses;
            Object mCcAddresses;
            Object mBccAddresses2;
            ArrayList mStreams3;
            Intent mIntent;
            int mStreams4;
            ArrayList mBccAddresses;
            Object mStreams;
            int i;
            ArrayList mStreams2;
            String str;
            int i2 = 0;
            if (this.mToAddresses != null) {
                combineArrayExtra("android.intent.extra.EMAIL", this.mToAddresses);
                this.mToAddresses = i2;
            }
            if (this.mCcAddresses != null) {
                combineArrayExtra("android.intent.extra.CC", this.mCcAddresses);
                this.mCcAddresses = i2;
            }
            if (this.mBccAddresses != null) {
                combineArrayExtra("android.intent.extra.BCC", this.mBccAddresses);
                this.mBccAddresses = i2;
            }
            int i3 = 0;
            if (this.mStreams != null && this.mStreams.size() > 1) {
                if (this.mStreams.size() > 1) {
                } else {
                    i = i3;
                }
            } else {
            }
            String str2 = "android.intent.extra.STREAM";
            if (i == 0) {
                this.mIntent.setAction("android.intent.action.SEND");
                if (this.mStreams != null && !this.mStreams.isEmpty()) {
                    if (!this.mStreams.isEmpty()) {
                        this.mIntent.putExtra(str2, (Parcelable)this.mStreams.get(i3));
                        ShareCompat.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
                    } else {
                        this.mIntent.removeExtra(str2);
                        this.mIntent.setClipData(i2);
                        this.mIntent.setFlags(flags &= -2);
                    }
                } else {
                }
            } else {
                this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
                this.mIntent.putParcelableArrayListExtra(str2, this.mStreams);
                ShareCompat.migrateExtraStreamToClipData(this.mIntent, this.mStreams);
            }
            return this.mIntent;
        }

        public androidx.core.app.ShareCompat.IntentBuilder setChooserTitle(int resId) {
            return setChooserTitle(this.mContext.getText(resId));
        }

        public androidx.core.app.ShareCompat.IntentBuilder setChooserTitle(java.lang.CharSequence title) {
            this.mChooserTitle = title;
            return this;
        }

        public androidx.core.app.ShareCompat.IntentBuilder setEmailBcc(String[] addresses) {
            this.mIntent.putExtra("android.intent.extra.BCC", addresses);
            return this;
        }

        public androidx.core.app.ShareCompat.IntentBuilder setEmailCc(String[] addresses) {
            this.mIntent.putExtra("android.intent.extra.CC", addresses);
            return this;
        }

        public androidx.core.app.ShareCompat.IntentBuilder setEmailTo(String[] addresses) {
            ArrayList mToAddresses;
            if (this.mToAddresses != null) {
                this.mToAddresses = 0;
            }
            this.mIntent.putExtra("android.intent.extra.EMAIL", addresses);
            return this;
        }

        public androidx.core.app.ShareCompat.IntentBuilder setHtmlText(String htmlText) {
            boolean extra;
            this.mIntent.putExtra("android.intent.extra.HTML_TEXT", htmlText);
            if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
                setText(Html.fromHtml(htmlText));
            }
            return this;
        }

        public androidx.core.app.ShareCompat.IntentBuilder setStream(Uri streamUri) {
            this.mStreams = 0;
            if (streamUri != null) {
                addStream(streamUri);
            }
            return this;
        }

        public androidx.core.app.ShareCompat.IntentBuilder setSubject(String subject) {
            this.mIntent.putExtra("android.intent.extra.SUBJECT", subject);
            return this;
        }

        public androidx.core.app.ShareCompat.IntentBuilder setText(java.lang.CharSequence text) {
            this.mIntent.putExtra("android.intent.extra.TEXT", text);
            return this;
        }

        public androidx.core.app.ShareCompat.IntentBuilder setType(String mimeType) {
            this.mIntent.setType(mimeType);
            return this;
        }

        public void startChooser() {
            this.mContext.startActivity(createChooserIntent());
        }
    }

    public static class IntentReader {

        private static final String TAG = "IntentReader";
        private final ComponentName mCallingActivity;
        private final String mCallingPackage;
        private final Context mContext;
        private final Intent mIntent;
        private ArrayList<Uri> mStreams;
        public IntentReader(Activity activity) {
            super((Context)Preconditions.checkNotNull(activity), activity.getIntent());
        }

        public IntentReader(Context context, Intent intent) {
            super();
            this.mContext = (Context)Preconditions.checkNotNull(context);
            this.mIntent = (Intent)Preconditions.checkNotNull(intent);
            this.mCallingPackage = ShareCompat.getCallingPackage(intent);
            this.mCallingActivity = ShareCompat.getCallingActivity(intent);
        }

        @Deprecated
        public static androidx.core.app.ShareCompat.IntentReader from(Activity activity) {
            ShareCompat.IntentReader intentReader = new ShareCompat.IntentReader(activity);
            return intentReader;
        }

        public ComponentName getCallingActivity() {
            return this.mCallingActivity;
        }

        public Drawable getCallingActivityIcon() {
            if (this.mCallingActivity == null) {
                return null;
            }
            return this.mContext.getPackageManager().getActivityIcon(this.mCallingActivity);
        }

        public Drawable getCallingApplicationIcon() {
            if (this.mCallingPackage == null) {
                return null;
            }
            return this.mContext.getPackageManager().getApplicationIcon(this.mCallingPackage);
        }

        public java.lang.CharSequence getCallingApplicationLabel() {
            if (this.mCallingPackage == null) {
                return null;
            }
            PackageManager packageManager = this.mContext.getPackageManager();
            return packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.mCallingPackage, 0));
        }

        public String getCallingPackage() {
            return this.mCallingPackage;
        }

        public String[] getEmailBcc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
        }

        public String[] getEmailCc() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
        }

        public String[] getEmailTo() {
            return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
        }

        public String getHtmlText() {
            String result;
            Object text;
            boolean charSequence;
            if (this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT") == null) {
                text = getText();
                if (text instanceof Spanned) {
                    result = Html.toHtml((Spanned)text);
                } else {
                    if (text != null) {
                        result = Html.escapeHtml(text);
                    }
                }
            }
            return result;
        }

        public Uri getStream() {
            return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
        }

        public Uri getStream(int index) {
            ArrayList parcelableArrayListExtra;
            String str = "android.intent.extra.STREAM";
            if (this.mStreams == null && isMultipleShare()) {
                if (isMultipleShare()) {
                    this.mStreams = this.mIntent.getParcelableArrayListExtra(str);
                }
            }
            if (this.mStreams != null) {
                return (Uri)this.mStreams.get(index);
            }
            if (index != 0) {
            } else {
                return (Uri)this.mIntent.getParcelableExtra(str);
            }
            StringBuilder stringBuilder = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("Stream items available: ").append(getStreamCount()).append(" index requested: ").append(index).toString());
            throw indexOutOfBoundsException;
        }

        public int getStreamCount() {
            ArrayList parcelableArrayListExtra;
            final String str = "android.intent.extra.STREAM";
            if (this.mStreams == null && isMultipleShare()) {
                if (isMultipleShare()) {
                    this.mStreams = this.mIntent.getParcelableArrayListExtra(str);
                }
            }
            if (this.mStreams != null) {
                return this.mStreams.size();
            }
            return this.mIntent.hasExtra(str);
        }

        public String getSubject() {
            return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
        }

        public java.lang.CharSequence getText() {
            return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
        }

        public String getType() {
            return this.mIntent.getType();
        }

        public boolean isMultipleShare() {
            return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
        }

        public boolean isShareIntent() {
            int i;
            boolean equals;
            String action = this.mIntent.getAction();
            if (!"android.intent.action.SEND".equals(action)) {
                if ("android.intent.action.SEND_MULTIPLE".equals(action)) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
            return i;
        }

        public boolean isSingleShare() {
            return "android.intent.action.SEND".equals(this.mIntent.getAction());
        }
    }
    @Deprecated
    public static void configureMenuItem(Menu menu, int menuItemId, androidx.core.app.ShareCompat.IntentBuilder shareIntent) {
        final MenuItem item = menu.findItem(menuItemId);
        if (item == null) {
        } else {
            ShareCompat.configureMenuItem(item, shareIntent);
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Could not find menu item with id ").append(menuItemId).append(" in the supplied menu").toString());
        throw illegalArgumentException;
    }

    @Deprecated
    public static void configureMenuItem(MenuItem item, androidx.core.app.ShareCompat.IntentBuilder shareIntent) {
        Object provider;
        Context context;
        final android.view.ActionProvider actionProvider = item.getActionProvider();
        if (actionProvider instanceof ShareActionProvider == null) {
            provider = new ShareActionProvider(shareIntent.getContext());
        } else {
            provider = actionProvider;
        }
        StringBuilder stringBuilder = new StringBuilder();
        provider.setShareHistoryFileName(stringBuilder.append(".sharecompat_").append(shareIntent.getContext().getClass().getName()).toString());
        provider.setShareIntent(shareIntent.getIntent());
        item.setActionProvider(provider);
    }

    public static ComponentName getCallingActivity(Activity calledActivity) {
        ComponentName result;
        if (calledActivity.getCallingActivity() == null) {
            result = ShareCompat.getCallingActivity(calledActivity.getIntent());
        }
        return result;
    }

    static ComponentName getCallingActivity(Intent intent) {
        android.os.Parcelable result;
        android.os.Parcelable parcelableExtra;
        if ((ComponentName)intent.getParcelableExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY") == null) {
            result = parcelableExtra;
        }
        return result;
    }

    public static String getCallingPackage(Activity calledActivity) {
        String result;
        final Intent intent = calledActivity.getIntent();
        if (calledActivity.getCallingPackage() == null && intent != null) {
            if (intent != null) {
                result = ShareCompat.getCallingPackage(intent);
            }
        }
        return result;
    }

    static String getCallingPackage(Intent intent) {
        String result;
        String str;
        if (intent.getStringExtra("androidx.core.app.EXTRA_CALLING_PACKAGE") == null) {
            result = intent.getStringExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE");
        }
        return result;
    }

    static void migrateExtraStreamToClipData(Intent intent, ArrayList<Uri> arrayList2) {
        int i;
        Object obj;
        int item;
        final int i2 = 1;
        String[] strArr = new String[i2];
        int i3 = 0;
        strArr[i3] = intent.getType();
        item = 0;
        ClipData.Item item2 = new ClipData.Item(intent.getCharSequenceExtra("android.intent.extra.TEXT"), intent.getStringExtra("android.intent.extra.HTML_TEXT"), item, (Uri)arrayList2.get(i3));
        ClipData clipData = new ClipData(item, strArr, item2);
        i = 1;
        while (i < arrayList2.size()) {
            item = new ClipData.Item((Uri)arrayList2.get(i));
            clipData.addItem(item);
            i++;
        }
        intent.setClipData(clipData);
        intent.addFlags(i2);
    }
}
