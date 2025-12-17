package androidx.core.view.insets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.core.R.id;
import androidx.core.graphics.Insets;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class ProtectionLayout extends FrameLayout {

    private static final Object PROTECTION_VIEW;
    private androidx.core.view.insets.ProtectionGroup mGroup;
    private final List<androidx.core.view.insets.Protection> mProtections;
    static {
        Object object = new Object();
        ProtectionLayout.PROTECTION_VIEW = object;
    }

    public ProtectionLayout(Context context) {
        super(context);
        ArrayList arrayList = new ArrayList();
        this.mProtections = arrayList;
    }

    public ProtectionLayout(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public ProtectionLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr, 0);
    }

    public ProtectionLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        ArrayList arrayList = new ArrayList();
        this.mProtections = arrayList;
    }

    public ProtectionLayout(Context context, List<androidx.core.view.insets.Protection> list2) {
        super(context);
        ArrayList arrayList = new ArrayList();
        this.mProtections = arrayList;
        setProtections(list2);
    }

    private void addProtectionView(Context context, int index, androidx.core.view.insets.Protection protection) {
        int width;
        int height;
        int i2;
        int i;
        final androidx.core.view.insets.Protection.Attributes attributes = protection.getAttributes();
        switch (side) {
            case 1:
                width = attributes.getWidth();
                height = -1;
                i2 = 3;
                break;
            case 2:
                width = -1;
                height = attributes.getHeight();
                i2 = 48;
                break;
            case 4:
                width = attributes.getWidth();
                height = -1;
                i2 = 5;
                break;
            case 8:
                width = -1;
                height = attributes.getHeight();
                i2 = 80;
                break;
            default:
                StringBuilder stringBuilder = new StringBuilder();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("Unexpected side: ").append(protection.getSide()).toString());
                throw illegalArgumentException;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(width, height, i2);
        final Insets margin = attributes.getMargin();
        layoutParams.leftMargin = margin.left;
        layoutParams.topMargin = margin.top;
        layoutParams.rightMargin = margin.right;
        layoutParams.bottomMargin = margin.bottom;
        View view = new View(context);
        view.setTag(ProtectionLayout.PROTECTION_VIEW);
        view.setTranslationX(attributes.getTranslationX());
        view.setTranslationY(attributes.getTranslationY());
        view.setAlpha(attributes.getAlpha());
        i = attributes.isVisible() ? 0 : 4;
        view.setVisibility(i);
        view.setBackground(attributes.getDrawable());
        ProtectionLayout.1 anon = new ProtectionLayout.1(this, layoutParams, view);
        attributes.setCallback(anon);
        addView(view, index, layoutParams);
    }

    private void addProtectionViews() {
        int i;
        androidx.core.view.insets.Protection protection;
        Context context;
        int i2;
        if (this.mProtections.isEmpty()) {
        }
        ProtectionGroup protectionGroup = new ProtectionGroup(getOrInstallSystemBarStateMonitor(), this.mProtections);
        this.mGroup = protectionGroup;
        i = 0;
        while (i < this.mGroup.size()) {
            addProtectionView(getContext(), i + childCount, this.mGroup.getProtection(i));
            i++;
        }
    }

    private androidx.core.view.insets.SystemBarStateMonitor getOrInstallSystemBarStateMonitor() {
        final View rootView = getRootView();
        Object tag = (ViewGroup)rootView.getTag(R.id.tag_system_bar_state_monitor);
        if (tag instanceof SystemBarStateMonitor) {
            return (SystemBarStateMonitor)tag;
        }
        SystemBarStateMonitor systemBarStateMonitor = new SystemBarStateMonitor(rootView);
        rootView.setTag(R.id.tag_system_bar_state_monitor, systemBarStateMonitor);
        return systemBarStateMonitor;
    }

    private void maybeUninstallSystemBarStateMonitor() {
        final View rootView = getRootView();
        Object tag = (ViewGroup)rootView.getTag(R.id.tag_system_bar_state_monitor);
        if (!tag instanceof SystemBarStateMonitor) {
        }
        Object obj = tag;
        if ((SystemBarStateMonitor)obj.hasCallback()) {
        }
        obj.detachFromWindow();
        rootView.setTag(R.id.tag_system_bar_state_monitor, 0);
    }

    private void removeProtectionViews() {
        androidx.core.view.insets.ProtectionGroup i;
        int i2;
        int size;
        int i3;
        androidx.core.view.insets.Protection.Attributes attributes;
        if (this.mGroup != null) {
            removeViews(childCount -= size2, this.mGroup.size());
            i2 = 0;
            i3 = 0;
            while (i2 < this.mGroup.size()) {
                this.mGroup.getProtection(i2).getAttributes().setCallback(i3);
                i2++;
                i3 = 0;
            }
            this.mGroup.dispose();
            this.mGroup = i3;
        }
    }

    @Override // android.widget.FrameLayout
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        int size;
        Object pROTECTION_VIEW;
        int obj4;
        if (child != null && child.getTag() != ProtectionLayout.PROTECTION_VIEW) {
            if (child.getTag() != ProtectionLayout.PROTECTION_VIEW) {
                if (this.mGroup != null) {
                    size = this.mGroup.size();
                } else {
                    size = 0;
                }
                childCount -= size;
                if (index <= pROTECTION_VIEW) {
                    if (index < 0) {
                        obj4 = pROTECTION_VIEW;
                    }
                } else {
                }
            }
        }
        super.addView(child, obj4, params);
    }

    @Override // android.widget.FrameLayout
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mGroup != null) {
            removeProtectionViews();
        }
        addProtectionViews();
        requestApplyInsets();
    }

    @Override // android.widget.FrameLayout
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeProtectionViews();
        maybeUninstallSystemBarStateMonitor();
    }

    public void setProtections(List<androidx.core.view.insets.Protection> list) {
        this.mProtections.clear();
        this.mProtections.addAll(list);
        if (isAttachedToWindow()) {
            removeProtectionViews();
            addProtectionViews();
            requestApplyInsets();
        }
    }
}
