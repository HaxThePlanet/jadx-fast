package androidx.compose.ui.platform.coreshims;

import android.os.Bundle;
import android.view.ViewStructure;

/* loaded from: classes.dex */
public class ViewStructureCompat {

    private final Object mWrappedObj;

    private static class Api23Impl {
        static Bundle getExtras(ViewStructure viewStructure) {
            return viewStructure.getExtras();
        }

        static void setClassName(ViewStructure viewStructure, String string) {
            viewStructure.setClassName(string);
        }

        static void setContentDescription(ViewStructure viewStructure, java.lang.CharSequence charSequence) {
            viewStructure.setContentDescription(charSequence);
        }

        static void setDimens(ViewStructure viewStructure, int left, int top, int scrollX, int scrollY, int width, int height) {
            viewStructure.setDimens(left, top, scrollX, scrollY, width, height);
        }

        static void setId(ViewStructure viewStructure, int id, String packageName, String typeName, String entryName) {
            viewStructure.setId(id, packageName, typeName, entryName);
        }

        static void setText(ViewStructure viewStructure, java.lang.CharSequence charSequence) {
            viewStructure.setText(charSequence);
        }

        static void setTextStyle(ViewStructure viewStructure, float size, int fgColor, int bgColor, int style) {
            viewStructure.setTextStyle(size, fgColor, bgColor, style);
        }
    }
    private ViewStructureCompat(ViewStructure viewStructure) {
        super();
        this.mWrappedObj = viewStructure;
    }

    public static androidx.compose.ui.platform.coreshims.ViewStructureCompat toViewStructureCompat(ViewStructure contentCaptureSession) {
        ViewStructureCompat viewStructureCompat = new ViewStructureCompat(contentCaptureSession);
        return viewStructureCompat;
    }

    public Bundle getExtras() {
        return ViewStructureCompat.Api23Impl.getExtras((ViewStructure)this.mWrappedObj);
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

    public void setId(int id, String packageName, String typeName, String entryName) {
        ViewStructureCompat.Api23Impl.setId((ViewStructure)this.mWrappedObj, id, packageName, typeName, entryName);
    }

    public void setText(java.lang.CharSequence charSequence) {
        ViewStructureCompat.Api23Impl.setText((ViewStructure)this.mWrappedObj, charSequence);
    }

    public void setTextStyle(float size, int fgColor, int bgColor, int style) {
        ViewStructureCompat.Api23Impl.setTextStyle((ViewStructure)this.mWrappedObj, size, fgColor, bgColor, style);
    }

    public ViewStructure toViewStructure() {
        return (ViewStructure)this.mWrappedObj;
    }
}
