package zendesk.messaging.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import zendesk.messaging.Attachment;
import zendesk.messaging.R.dimen;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;

/* loaded from: classes3.dex */
public class EndUserImageCellView extends LinearLayout implements zendesk.messaging.ui.Updatable<zendesk.messaging.ui.EndUserCellImageState> {

    private int cornerRadiusPx;
    private zendesk.messaging.ui.FileUploadProgressView fileUploadProgressView;
    private ImageView imageView;
    private TextView label;
    private zendesk.messaging.ui.MessageStatusView statusView;
    public EndUserImageCellView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init();
    }

    private void init() {
        setOrientation(1);
        setGravity(8388693);
        LinearLayout.inflate(getContext(), R.layout.zui_view_end_user_image_cell_content, this);
        this.cornerRadiusPx = getResources().getDimensionPixelSize(R.dimen.zui_cell_bubble_corner_radius);
    }

    private void loadImageIntoImageView(zendesk.messaging.ui.EndUserCellImageState endUserCellImageState) {
        UtilsEndUserCellView.getImageLoadingPlaceholder(getContext());
        endUserCellImageState.getAttachment().getFile();
        throw 0;
    }

    @Override // android.widget.LinearLayout
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.imageView = (ImageView)findViewById(R.id.zui_image_cell_image);
        this.fileUploadProgressView = (FileUploadProgressView)findViewById(R.id.zui_cell_file_upload_progress);
        this.statusView = (MessageStatusView)findViewById(R.id.zui_cell_status_view);
        this.label = (TextView)findViewById(R.id.zui_cell_label_message);
    }

    @Override // android.widget.LinearLayout
    public void update(Object object) {
        update((EndUserCellImageState)object);
        throw 0;
    }

    @Override // android.widget.LinearLayout
    public void update(zendesk.messaging.ui.EndUserCellImageState endUserCellImageState) {
        loadImageIntoImageView(endUserCellImageState);
        throw 0;
    }
}
