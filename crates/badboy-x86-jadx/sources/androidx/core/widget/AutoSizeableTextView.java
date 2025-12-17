package androidx.core.widget;

/* loaded from: classes5.dex */
public interface AutoSizeableTextView {

    @Deprecated
    public static final boolean PLATFORM_SUPPORTS_AUTOSIZE = true;
    static {
        final int i = 1;
    }

    public abstract int getAutoSizeMaxTextSize();

    public abstract int getAutoSizeMinTextSize();

    public abstract int getAutoSizeStepGranularity();

    public abstract int[] getAutoSizeTextAvailableSizes();

    public abstract int getAutoSizeTextType();

    public abstract void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) throws java.lang.IllegalArgumentException;

    public abstract void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) throws java.lang.IllegalArgumentException;

    public abstract void setAutoSizeTextTypeWithDefaults(int i);
}
