package zendesk.messaging.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.t;
import com.squareup.picasso.x;
import zendesk.commonui.b;
import zendesk.commonui.d;
import zendesk.messaging.R.array;
import zendesk.messaging.R.attr;
import zendesk.messaging.R.color;
import zendesk.messaging.R.dimen;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;
import zendesk.messaging.R.styleable;

/* loaded from: classes3.dex */
public class AvatarView extends FrameLayout {

    private final int avatarSize;
    private final int[] colorPalette;
    private final ImageView imageView;
    private final int outlineColor;
    private final int outlineSize;
    private final TextView textView;
    public AvatarView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 0);
    }

    public AvatarView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        FrameLayout.inflate(context, R.layout.zui_view_avatar, this);
        Resources obj8 = getResources();
        this.imageView = (ImageView)findViewById(R.id.zui_avatar_image);
        android.view.View viewById2 = findViewById(R.id.zui_avatar_letter);
        this.textView = (TextView)viewById2;
        this.avatarSize = obj8.getDimensionPixelSize(R.dimen.zui_avatar_view_size);
        final TypedArray obj6 = context.obtainStyledAttributes(attributeSet2, R.styleable.AvatarView);
        this.colorPalette = obj8.getIntArray(obj6.getResourceId(R.styleable.AvatarView_colorPalette, R.array.zui_avatar_view__background_color_palette));
        this.outlineSize = obj6.getDimensionPixelSize(R.styleable.AvatarView_outlineSize, obj8.getDimensionPixelOffset(R.dimen.zui_avatar_view_outline));
        this.outlineColor = obj6.getColor(R.styleable.AvatarView_outlineColor, d.e(R.attr.colorPrimary, context, R.color.zui_color_primary));
        viewById2.setTextColor(obj6.getColor(R.styleable.AvatarView_textColor, obj8.getColor(R.color.zui_color_white_80)));
        obj6.recycle();
    }

    private Drawable generateBackground(Object object) {
        OvalShape ovalShape = new OvalShape();
        ShapeDrawable shapeDrawable = new ShapeDrawable(ovalShape);
        shapeDrawable.getPaint().setColor(this.colorPalette[Math.abs(obj7 %= length)]);
        if (this.outlineSize > 0) {
            OvalShape ovalShape2 = new OvalShape();
            ShapeDrawable obj7 = new ShapeDrawable(ovalShape2);
            Paint paint2 = obj7.getPaint();
            paint2.setStyle(Paint.Style.STROKE);
            int i = 1;
            paint2.setAntiAlias(i);
            paint2.setColor(this.outlineColor);
            paint2.setStrokeWidth((float)outlineSize);
            int i2 = 2;
            final Drawable[] arr = new Drawable[i2];
            arr[0] = shapeDrawable;
            InsetDrawable insetDrawable = new InsetDrawable(obj7, outlineSize2 /= i2);
            arr[i] = insetDrawable;
            LayerDrawable layerDrawable = new LayerDrawable(arr);
            return layerDrawable;
        }
        return shapeDrawable;
    }

    @Override // android.widget.FrameLayout
    public void showDefault(int i, Object object2) {
        setBackground(generateBackground(object2));
        this.imageView.setImageResource(i);
        this.textView.setVisibility(8);
        this.imageView.setVisibility(0);
    }

    @Override // android.widget.FrameLayout
    public void showDrawable(int i) {
        setBackground(0);
        this.imageView.setImageResource(i);
        this.textView.setVisibility(8);
        this.imageView.setVisibility(0);
    }

    @Override // android.widget.FrameLayout
    public void showImage(t t, String string2) {
        int outlineColor;
        int outlineSize;
        x obj3;
        Object obj4;
        if (avatarSize -= outlineSize > 0) {
            setBackground(0);
            this.imageView.setImageResource(R.color.zui_color_transparent);
            this.imageView.setVisibility(0);
            this.textView.setVisibility(8);
            obj3 = t.l(string2);
            obj4 = this.avatarSize;
            int outlineSize2 = this.outlineSize;
            obj3.k(obj4 - outlineSize2, obj4 -= outlineSize2);
            obj3.a();
            obj3.j();
            obj3.l(b.a(this.avatarSize, this.outlineColor, this.outlineSize));
            obj3.f(this.imageView);
        }
    }

    @Override // android.widget.FrameLayout
    public void showLetter(String string, Object object2) {
        setBackground(generateBackground(object2));
        this.textView.setText(string);
        this.textView.setVisibility(0);
        this.imageView.setVisibility(8);
    }
}
