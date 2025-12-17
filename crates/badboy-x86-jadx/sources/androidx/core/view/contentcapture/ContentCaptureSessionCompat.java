package androidx.core.view.contentcapture;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewStructureCompat;
import androidx.core.view.autofill.AutofillIdCompat;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
public class ContentCaptureSessionCompat {

    private static final String KEY_VIEW_TREE_APPEARED = "TREAT_AS_VIEW_TREE_APPEARED";
    private static final String KEY_VIEW_TREE_APPEARING = "TREAT_AS_VIEW_TREE_APPEARING";
    private final View mView;
    private final Object mWrappedObj;

    private static class Api23Impl {
        static Bundle getExtras(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }
    }

    private static class Api29Impl {
        static AutofillId newAutofillId(ContentCaptureSession contentCaptureSession, AutofillId hostId, long virtualChildId) {
            return contentCaptureSession.newAutofillId(hostId, virtualChildId);
        }

        static ViewStructure newViewStructure(ContentCaptureSession contentCaptureSession, View view) {
            return contentCaptureSession.newViewStructure(view);
        }

        static ViewStructure newVirtualViewStructure(ContentCaptureSession contentCaptureSession, AutofillId parentId, long virtualId) {
            return contentCaptureSession.newVirtualViewStructure(parentId, virtualId);
        }

        static void notifyViewAppeared(ContentCaptureSession contentCaptureSession, ViewStructure node) {
            contentCaptureSession.notifyViewAppeared(node);
        }

        public static void notifyViewTextChanged(ContentCaptureSession contentCaptureSession, AutofillId id, java.lang.CharSequence charSequence) {
            contentCaptureSession.notifyViewTextChanged(id, charSequence);
        }

        static void notifyViewsDisappeared(ContentCaptureSession contentCaptureSession, AutofillId hostId, long[] virtualIds) {
            contentCaptureSession.notifyViewsDisappeared(hostId, virtualIds);
        }
    }

    private static class Api34Impl {
        static void notifyViewsAppeared(ContentCaptureSession contentCaptureSession, List<ViewStructure> list2) {
            contentCaptureSession.notifyViewsAppeared(list2);
        }
    }
    private ContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View host) {
        super();
        this.mWrappedObj = contentCaptureSession;
        this.mView = host;
    }

    public static androidx.core.view.contentcapture.ContentCaptureSessionCompat toContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View host) {
        ContentCaptureSessionCompat contentCaptureSessionCompat = new ContentCaptureSessionCompat(contentCaptureSession, host);
        return contentCaptureSessionCompat;
    }

    public AutofillId newAutofillId(long virtualChildId) {
        return ContentCaptureSessionCompat.Api29Impl.newAutofillId((ContentCaptureSession)this.mWrappedObj, (AutofillIdCompat)Objects.requireNonNull(ViewCompat.getAutofillId(this.mView)).toAutofillId(), virtualChildId);
    }

    public ViewStructureCompat newVirtualViewStructure(AutofillId parentId, long virtualId) {
        return ViewStructureCompat.toViewStructureCompat(ContentCaptureSessionCompat.Api29Impl.newVirtualViewStructure((ContentCaptureSession)this.mWrappedObj, parentId, virtualId));
    }

    public void notifyViewTextChanged(AutofillId id, java.lang.CharSequence text) {
        ContentCaptureSessionCompat.Api29Impl.notifyViewTextChanged((ContentCaptureSession)this.mWrappedObj, id, text);
    }

    public void notifyViewsAppeared(List<ViewStructure> list) {
        Object viewStructure2;
        int viewStructure;
        int i;
        Object mWrappedObj;
        String mWrappedObj2;
        int i2;
        String str;
        if (Build.VERSION.SDK_INT >= 34) {
            ContentCaptureSessionCompat.Api34Impl.notifyViewsAppeared((ContentCaptureSession)this.mWrappedObj, list);
        } else {
            viewStructure2 = ContentCaptureSessionCompat.Api29Impl.newViewStructure((ContentCaptureSession)this.mWrappedObj, this.mView);
            i2 = 1;
            ContentCaptureSessionCompat.Api23Impl.getExtras(viewStructure2).putBoolean("TREAT_AS_VIEW_TREE_APPEARING", i2);
            ContentCaptureSessionCompat.Api29Impl.notifyViewAppeared((ContentCaptureSession)this.mWrappedObj, viewStructure2);
            i = 0;
            while (i < list.size()) {
                ContentCaptureSessionCompat.Api29Impl.notifyViewAppeared((ContentCaptureSession)this.mWrappedObj, (ViewStructure)list.get(i));
                i++;
            }
            viewStructure = ContentCaptureSessionCompat.Api29Impl.newViewStructure((ContentCaptureSession)this.mWrappedObj, this.mView);
            ContentCaptureSessionCompat.Api23Impl.getExtras(viewStructure).putBoolean("TREAT_AS_VIEW_TREE_APPEARED", i2);
            ContentCaptureSessionCompat.Api29Impl.notifyViewAppeared((ContentCaptureSession)this.mWrappedObj, viewStructure);
        }
    }

    public void notifyViewsDisappeared(long[] virtualIds) {
        Object viewStructure;
        Object viewStructure2;
        Object mWrappedObj;
        int i;
        String str;
        if (Build.VERSION.SDK_INT >= 34) {
            ContentCaptureSessionCompat.Api29Impl.notifyViewsDisappeared((ContentCaptureSession)this.mWrappedObj, (AutofillIdCompat)Objects.requireNonNull(ViewCompat.getAutofillId(this.mView)).toAutofillId(), virtualIds);
        } else {
            viewStructure = ContentCaptureSessionCompat.Api29Impl.newViewStructure((ContentCaptureSession)this.mWrappedObj, this.mView);
            i = 1;
            ContentCaptureSessionCompat.Api23Impl.getExtras(viewStructure).putBoolean("TREAT_AS_VIEW_TREE_APPEARING", i);
            ContentCaptureSessionCompat.Api29Impl.notifyViewAppeared((ContentCaptureSession)this.mWrappedObj, viewStructure);
            ContentCaptureSessionCompat.Api29Impl.notifyViewsDisappeared((ContentCaptureSession)this.mWrappedObj, (AutofillIdCompat)Objects.requireNonNull(ViewCompat.getAutofillId(this.mView)).toAutofillId(), virtualIds);
            viewStructure2 = ContentCaptureSessionCompat.Api29Impl.newViewStructure((ContentCaptureSession)this.mWrappedObj, this.mView);
            ContentCaptureSessionCompat.Api23Impl.getExtras(viewStructure2).putBoolean("TREAT_AS_VIEW_TREE_APPEARED", i);
            ContentCaptureSessionCompat.Api29Impl.notifyViewAppeared((ContentCaptureSession)this.mWrappedObj, viewStructure2);
        }
    }

    public ContentCaptureSession toContentCaptureSession() {
        return (ContentCaptureSession)this.mWrappedObj;
    }
}
