package androidx.appcompat.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

/* loaded from: classes.dex */
class k0 extends Resources {

    private final Resources a;
    public k0(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.a = resources;
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getAnimation(int i) {
        return this.a.getAnimation(i);
    }

    @Override // android.content.res.Resources
    public boolean getBoolean(int i) {
        return this.a.getBoolean(i);
    }

    @Override // android.content.res.Resources
    public int getColor(int i) {
        return this.a.getColor(i);
    }

    @Override // android.content.res.Resources
    public ColorStateList getColorStateList(int i) {
        return this.a.getColorStateList(i);
    }

    @Override // android.content.res.Resources
    public Configuration getConfiguration() {
        return this.a.getConfiguration();
    }

    @Override // android.content.res.Resources
    public float getDimension(int i) {
        return this.a.getDimension(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelOffset(int i) {
        return this.a.getDimensionPixelOffset(i);
    }

    @Override // android.content.res.Resources
    public int getDimensionPixelSize(int i) {
        return this.a.getDimensionPixelSize(i);
    }

    @Override // android.content.res.Resources
    public DisplayMetrics getDisplayMetrics() {
        return this.a.getDisplayMetrics();
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        return this.a.getDrawable(i);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i, Resources.Theme resources$Theme2) {
        return this.a.getDrawable(i, theme2);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i, int i2) {
        return this.a.getDrawableForDensity(i, i2);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawableForDensity(int i, int i2, Resources.Theme resources$Theme3) {
        return this.a.getDrawableForDensity(i, i2, theme3);
    }

    @Override // android.content.res.Resources
    public float getFraction(int i, int i2, int i3) {
        return this.a.getFraction(i, i2, i3);
    }

    @Override // android.content.res.Resources
    public int getIdentifier(String string, String string2, String string3) {
        return this.a.getIdentifier(string, string2, string3);
    }

    @Override // android.content.res.Resources
    public int[] getIntArray(int i) {
        return this.a.getIntArray(i);
    }

    @Override // android.content.res.Resources
    public int getInteger(int i) {
        return this.a.getInteger(i);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getLayout(int i) {
        return this.a.getLayout(i);
    }

    @Override // android.content.res.Resources
    public Movie getMovie(int i) {
        return this.a.getMovie(i);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2) {
        return this.a.getQuantityString(i, i2);
    }

    @Override // android.content.res.Resources
    public String getQuantityString(int i, int i2, Object... object3Arr3) {
        return this.a.getQuantityString(i, i2, object3Arr3);
    }

    @Override // android.content.res.Resources
    public java.lang.CharSequence getQuantityText(int i, int i2) {
        return this.a.getQuantityText(i, i2);
    }

    @Override // android.content.res.Resources
    public String getResourceEntryName(int i) {
        return this.a.getResourceEntryName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceName(int i) {
        return this.a.getResourceName(i);
    }

    @Override // android.content.res.Resources
    public String getResourcePackageName(int i) {
        return this.a.getResourcePackageName(i);
    }

    @Override // android.content.res.Resources
    public String getResourceTypeName(int i) {
        return this.a.getResourceTypeName(i);
    }

    @Override // android.content.res.Resources
    public String getString(int i) {
        return this.a.getString(i);
    }

    @Override // android.content.res.Resources
    public String getString(int i, Object... object2Arr2) {
        return this.a.getString(i, object2Arr2);
    }

    @Override // android.content.res.Resources
    public String[] getStringArray(int i) {
        return this.a.getStringArray(i);
    }

    @Override // android.content.res.Resources
    public java.lang.CharSequence getText(int i) {
        return this.a.getText(i);
    }

    @Override // android.content.res.Resources
    public java.lang.CharSequence getText(int i, java.lang.CharSequence charSequence2) {
        return this.a.getText(i, charSequence2);
    }

    @Override // android.content.res.Resources
    public java.lang.CharSequence[] getTextArray(int i) {
        return this.a.getTextArray(i);
    }

    @Override // android.content.res.Resources
    public void getValue(int i, TypedValue typedValue2, boolean z3) {
        this.a.getValue(i, typedValue2, z3);
    }

    @Override // android.content.res.Resources
    public void getValue(String string, TypedValue typedValue2, boolean z3) {
        this.a.getValue(string, typedValue2, z3);
    }

    @Override // android.content.res.Resources
    public void getValueForDensity(int i, int i2, TypedValue typedValue3, boolean z4) {
        this.a.getValueForDensity(i, i2, typedValue3, z4);
    }

    @Override // android.content.res.Resources
    public XmlResourceParser getXml(int i) {
        return this.a.getXml(i);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] i2Arr2) {
        return this.a.obtainAttributes(attributeSet, i2Arr2);
    }

    @Override // android.content.res.Resources
    public TypedArray obtainTypedArray(int i) {
        return this.a.obtainTypedArray(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i) {
        return this.a.openRawResource(i);
    }

    @Override // android.content.res.Resources
    public InputStream openRawResource(int i, TypedValue typedValue2) {
        return this.a.openRawResource(i, typedValue2);
    }

    @Override // android.content.res.Resources
    public AssetFileDescriptor openRawResourceFd(int i) {
        return this.a.openRawResourceFd(i);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtra(String string, AttributeSet attributeSet2, Bundle bundle3) {
        this.a.parseBundleExtra(string, attributeSet2, bundle3);
    }

    @Override // android.content.res.Resources
    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle2) {
        this.a.parseBundleExtras(xmlResourceParser, bundle2);
    }

    @Override // android.content.res.Resources
    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics2) {
        super.updateConfiguration(configuration, displayMetrics2);
        final Resources resources = this.a;
        if (resources != null) {
            resources.updateConfiguration(configuration, displayMetrics2);
        }
    }
}
