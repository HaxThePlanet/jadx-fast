package androidx.compose.ui.platform.coreshims;

import android.os.Build.VERSION;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;

/* loaded from: classes.dex */
public class ViewCompatShims {

    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_AUTO = 0;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO = 2;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_NO_EXCLUDE_DESCENDANTS = 8;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES = 1;
    public static final int IMPORTANT_FOR_CONTENT_CAPTURE_YES_EXCLUDE_DESCENDANTS = 4;

    static class Api26Impl {
        public static AutofillId getAutofillId(View view) {
            return view.getAutofillId();
        }
    }

    private static class Api29Impl {
        static ContentCaptureSession getContentCaptureSession(View view) {
            return view.getContentCaptureSession();
        }
    }

    private static class Api30Impl {
        static void setImportantForContentCapture(View view, int mode) {
            view.setImportantForContentCapture(mode);
        }
    }
    public static androidx.compose.ui.platform.coreshims.AutofillIdCompat getAutofillId(View v) {
        return AutofillIdCompat.toAutofillIdCompat(ViewCompatShims.Api26Impl.getAutofillId(v));
    }

    public static androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat getContentCaptureSession(View v) {
        final ContentCaptureSession contentCaptureSession = ViewCompatShims.Api29Impl.getContentCaptureSession(v);
        if (contentCaptureSession == null) {
            return null;
        }
        return ContentCaptureSessionCompat.toContentCaptureSessionCompat(contentCaptureSession, v);
    }

    public static void setImportantForContentCapture(View v, int mode) {
        if (Build.VERSION.SDK_INT >= 30) {
            ViewCompatShims.Api30Impl.setImportantForContentCapture(v, mode);
        }
    }
}
