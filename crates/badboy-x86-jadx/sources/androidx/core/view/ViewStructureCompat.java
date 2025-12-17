package androidx.core.view;

import android.view.ViewStructure;

/* loaded from: classes5.dex */
public class ViewStructureCompat {

    private final Object mWrappedObj;

    private static class Api23Impl {
        static void setClassName(ViewStructure viewStructure, String string) {
            viewStructure.setClassName(string);
        }

        static void setContentDescription(ViewStructure viewStructure, java.lang.CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        static void setDimens(ViewStructure viewStructure, int left, int top, int scrollX, int scrollY, int width, int height) {
            viewStructure.setDimens(left, top, scrollX, scrollY, width, height);
        }

        static void setText(ViewStructure viewStructure, java.lang.CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }
    }
    private ViewStructureCompat(ViewStructure viewStructure) {
        super();
        this.mWrappedObj = viewStructure;
    }

    public static androidx.core.view.ViewStructureCompat toViewStructureCompat(ViewStructure contentCaptureSession) {
        ViewStructureCompat viewStructureCompat = new ViewStructureCompat(contentCaptureSession);
        return viewStructureCompat;
    }

    public void setClassName(String string) {
        ViewStructureCompat.Api23Impl.setClassName((ViewStructure)this.mWrappedObj, string);
    }

    public void setContentDescription(java.lang.CharSequence charSequence) {
        ViewStructureCompat.Api23Impl.setContentDescription((ViewStructure)this.mWrappedObj, charSequence);
    }

    public void setDimens(int left, int top, int scrollX, int scrollY, int width, int height) {
        ViewStructureCompat.Api23Impl.setDimens((ViewStructure)this.mWrappedObj, left, top, scrollX, scrollY, width, height);
    }

    public void setText(java.lang.CharSequence charSequence) {
        ViewStructureCompat.Api23Impl.setText((ViewStructure)this.mWrappedObj, charSequence);
    }

    public ViewStructure toViewStructure() {
        return (ViewStructure)this.mWrappedObj;
    }
}
