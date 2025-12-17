package androidx.core.view.inputmethod;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.ContentInfoCompat.Builder;
import androidx.core.view.ViewCompat;

/* loaded from: classes5.dex */
public final class InputConnectionCompat {

    private static final String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String EXTRA_INPUT_CONTENT_INFO = "androidx.core.view.extra.INPUT_CONTENT_INFO";
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;
    private static final String LOG_TAG = "InputConnectionCompat";

    public interface OnCommitContentListener {
        public abstract boolean onCommitContent(androidx.core.view.inputmethod.InputContentInfoCompat inputContentInfoCompat, int i2, Bundle bundle3);
    }

    static class Api25Impl {
        static boolean commitContent(InputConnection inputConnection, InputContentInfo inputContentInfo, int i, Bundle bundle) {
            return inputConnection.commitContent(inputContentInfo, i, bundle);
        }
    }
    public static boolean commitContent(InputConnection inputConnection, EditorInfo editorInfo, androidx.core.view.inputmethod.InputContentInfoCompat inputContentInfo, int flags, Bundle opts) {
        return InputConnectionCompat.Api25Impl.commitContent(inputConnection, (InputContentInfo)inputContentInfo.unwrap(), flags, opts);
    }

    private static androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener createOnCommitContentListenerUsingPerformReceiveContent(View view) {
        Preconditions.checkNotNull(view);
        InputConnectionCompat$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new InputConnectionCompat$$ExternalSyntheticLambda0(view);
        return externalSyntheticLambda0;
    }

    public static InputConnection createWrapper(View view, InputConnection inputConnection, EditorInfo editorInfo) {
        return InputConnectionCompat.createWrapper(inputConnection, editorInfo, InputConnectionCompat.createOnCommitContentListenerUsingPerformReceiveContent(view));
    }

    @Deprecated
    public static InputConnection createWrapper(InputConnection inputConnection, EditorInfo editorInfo, androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener onCommitContentListener) {
        ObjectsCompat.requireNonNull(inputConnection, "inputConnection must be non-null");
        ObjectsCompat.requireNonNull(editorInfo, "editorInfo must be non-null");
        ObjectsCompat.requireNonNull(onCommitContentListener, "onCommitContentListener must be non-null");
        InputConnectionCompat.1 anon = new InputConnectionCompat.1(inputConnection, 0, onCommitContentListener);
        return anon;
    }

    static boolean handlePerformPrivateCommand(String action, Bundle data, androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener onCommitContentListener) {
        int i2;
        int i;
        int result;
        String str6;
        String str2;
        String str3;
        String str;
        String str5;
        String str4;
        androidx.core.view.inputmethod.InputContentInfoCompat inputContentInfoCompat;
        boolean onCommitContent;
        i2 = 0;
        if (data == null) {
            return i2;
        }
        if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", action)) {
            i = 0;
            int i3 = 0;
            result = 0;
            str6 = i != 0 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
            android.os.Parcelable resultReceiver = parcelable;
            str2 = i != 0 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
            android.os.Parcelable parcelable2 = data.getParcelable(str2);
            str3 = i != 0 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
            android.os.Parcelable parcelable3 = data.getParcelable(str3);
            str = i != 0 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
            str5 = i != 0 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
            str4 = i != 0 ? "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS" : "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
            if ((Uri)parcelable2 != null && (ClipDescription)parcelable3 != null) {
                if ((ClipDescription)parcelable3 != null) {
                    inputContentInfoCompat = new InputContentInfoCompat((Uri)parcelable2, (ClipDescription)parcelable3, (Uri)data.getParcelable(str));
                    result = onCommitContent;
                }
            }
            if (resultReceiver != null && result != null) {
                try {
                    if (result != null) {
                    }
                    i2 = 1;
                    resultReceiver.send(i2, 0);
                    return result;
                    if (obj2 == null) {
                    } else {
                    }
                    obj2.send(obj3, obj4);
                    throw th;
                    return i2;
                }
            }
        } else {
            if (TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", action)) {
                i = 1;
            }
        }
    }

    static boolean lambda$createOnCommitContentListenerUsingPerformReceiveContent$0(View view, androidx.core.view.inputmethod.InputContentInfoCompat inputContentInfo, int flags, Bundle opts) {
        Bundle extras;
        int unwrap;
        int i;
        String str;
        extras = opts;
        i = 0;
        if (flags & 1 != 0) {
            inputContentInfo.requestPermission();
            if (opts == null) {
                Bundle bundle = new Bundle();
            } else {
                super(opts);
            }
            bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", (Parcelable)inputContentInfo.unwrap());
        }
        try {
            ClipData.Item item = new ClipData.Item(inputContentInfo.getContentUri());
            ClipData e = new ClipData(inputContentInfo.getDescription(), item);
            ContentInfoCompat.Builder builder = new ContentInfoCompat.Builder(e, 2);
            if (ViewCompat.performReceiveContent(view, builder.setLinkUri(inputContentInfo.getLinkUri()).setExtras(extras).build()) == null) {
            }
            i = 1;
            return i;
        }
    }
}
