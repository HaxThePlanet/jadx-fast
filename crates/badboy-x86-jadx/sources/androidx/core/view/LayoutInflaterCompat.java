package androidx.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import java.lang.reflect.Field;

/* loaded from: classes5.dex */
public final class LayoutInflaterCompat {

    private static final String TAG = "LayoutInflaterCompatHC";
    private static boolean sCheckedField;
    private static Field sLayoutInflaterFactory2Field;

    static class Factory2Wrapper implements LayoutInflater.Factory2 {

        final androidx.core.view.LayoutInflaterFactory mDelegateFactory;
        Factory2Wrapper(androidx.core.view.LayoutInflaterFactory delegateFactory) {
            super();
            this.mDelegateFactory = delegateFactory;
        }

        @Override // android.view.LayoutInflater$Factory2
        public View onCreateView(View parent, String name, Context context, AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView(parent, name, context, attributeSet);
        }

        @Override // android.view.LayoutInflater$Factory2
        public View onCreateView(String name, Context context, AttributeSet attrs) {
            return this.mDelegateFactory.onCreateView(0, name, context, attrs);
        }

        @Override // android.view.LayoutInflater$Factory2
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            return stringBuilder.append(getClass().getName()).append("{").append(this.mDelegateFactory).append("}").toString();
        }
    }
    private static void forceSetFactory2(LayoutInflater inflater, LayoutInflater.Factory2 factory) {
        boolean sCheckedField;
        Field sLayoutInflaterFactory2Field2;
        String str2;
        Field sLayoutInflaterFactory2Field;
        String str;
        String name;
        str2 = "; inflation may have unexpected results.";
        final String str3 = "LayoutInflaterCompatHC";
        if (!LayoutInflaterCompat.sCheckedField) {
            sCheckedField = 1;
            LayoutInflaterCompat.sLayoutInflaterFactory2Field = LayoutInflater.class.getDeclaredField("mFactory2");
            LayoutInflaterCompat.sLayoutInflaterFactory2Field.setAccessible(sCheckedField);
            LayoutInflaterCompat.sCheckedField = sCheckedField;
        }
        if (LayoutInflaterCompat.sLayoutInflaterFactory2Field != null) {
            LayoutInflaterCompat.sLayoutInflaterFactory2Field.set(inflater, factory);
        }
    }

    @Deprecated
    public static androidx.core.view.LayoutInflaterFactory getFactory(LayoutInflater inflater) {
        final android.view.LayoutInflater.Factory factory = inflater.getFactory();
        if (factory instanceof LayoutInflaterCompat.Factory2Wrapper) {
            return factory2.mDelegateFactory;
        }
        return null;
    }

    @Deprecated
    public static void setFactory(LayoutInflater inflater, androidx.core.view.LayoutInflaterFactory factory) {
        LayoutInflaterCompat.Factory2Wrapper factory2Wrapper = new LayoutInflaterCompat.Factory2Wrapper(factory);
        inflater.setFactory2(factory2Wrapper);
    }

    public static void setFactory2(LayoutInflater inflater, LayoutInflater.Factory2 factory) {
        inflater.setFactory2(factory);
    }
}
