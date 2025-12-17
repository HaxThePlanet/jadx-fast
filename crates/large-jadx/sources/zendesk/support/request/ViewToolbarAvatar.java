package zendesk.support.request;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.squareup.picasso.t;
import d.h.k.d;
import f.g.d.a;
import f.g.d.c;
import f.g.d.d;
import f.g.d.f;
import f.g.e.a;
import f.g.e.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import zendesk.support.UiUtils;
import zendesk.support.ZendeskAvatarView;

/* loaded from: classes3.dex */
class ViewToolbarAvatar extends FrameLayout {

    private static final int[] IMAGE_VIEW_IDS = null;
    static final int MAX_IMAGES = 5;
    private final List<ZendeskAvatarView> avatarViews;
    private int imageRadius;
    private int strokeColor;
    private int strokeWidth;
    private List<d<String, String>> userInfo;
    static {
        int[] iArr = new int[5];
        ViewToolbarAvatar.IMAGE_VIEW_IDS = iArr;
    }

    public ViewToolbarAvatar(Context context) {
        super(context, 0);
    }

    public ViewToolbarAvatar(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public ViewToolbarAvatar(Context context, AttributeSet attributeSet2, int i3) {
        int avatarViews;
        int obj2;
        Context obj3;
        super(context, attributeSet2, i3);
        final int obj4 = 5;
        obj3 = new ArrayList(obj4);
        this.avatarViews = obj3;
        obj3 = new ArrayList(obj4);
        this.userInfo = obj3;
        this.imageRadius = context.getResources().getDimensionPixelOffset(d.t);
        this.strokeWidth = context.getResources().getDimensionPixelOffset(d.u);
        this.strokeColor = UiUtils.themeAttributeToColor(a.b, getContext(), c.A);
        obj2 = 0;
        while (obj2 < obj4) {
            obj3 = createAndAddView(obj2);
            obj3.setVisibility(8);
            this.avatarViews.add(obj3);
            obj2++;
        }
    }

    private void bindData(t t) {
        int i;
        Object obj;
        int i2;
        boolean z;
        int imageRadius;
        final int i3 = 0;
        i = i3;
        while (i < this.avatarViews.size()) {
            obj = this.avatarViews.get(i);
            if (i < this.userInfo.size()) {
            } else {
            }
            (ZendeskAvatarView)obj.setVisibility(8);
            i++;
            Object obj2 = this.userInfo.get(i);
            if (g.c((String)obj2.a)) {
            } else {
            }
            obj.showUserWithName((String)obj2.b);
            obj.setVisibility(i3);
            obj.showUserWithAvatarImage(t, (String)obj2.a, (String)obj2.b, this.imageRadius);
        }
    }

    private ZendeskAvatarView createAndAddView(int i) {
        int sDK_INT;
        ZendeskAvatarView zendeskAvatarView = new ZendeskAvatarView(getContext());
        zendeskAvatarView.setId(ViewToolbarAvatar.IMAGE_VIEW_IDS[i]);
        zendeskAvatarView.setStroke(this.strokeColor, this.strokeWidth);
        imageRadius *= 2;
        obj5 *= i5;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i3);
        layoutParams.gravity = 8388613;
        if (Build.VERSION.SDK_INT >= 17) {
            layoutParams.setMarginEnd(obj5);
        } else {
            sDK_INT = 0;
            layoutParams.setMargins(sDK_INT, sDK_INT, obj5, sDK_INT);
        }
        addView(zendeskAvatarView, layoutParams);
        return zendeskAvatarView;
    }

    void setImageUrls(t t, List<d<String, String>> list2) {
        int size;
        List obj4;
        final int i = 5;
        if (list2.size() > i) {
            this.userInfo = list2.subList(0, i);
        } else {
            this.userInfo = a.c(list2);
        }
        Collections.reverse(this.userInfo);
        bindData(t);
    }
}
