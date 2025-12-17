package zendesk.messaging.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.a;
import zendesk.commonui.d;
import zendesk.messaging.Attachment;
import zendesk.messaging.R.attr;
import zendesk.messaging.R.color;
import zendesk.messaging.R.drawable;
import zendesk.messaging.R.id;
import zendesk.messaging.R.layout;

/* loaded from: classes3.dex */
public class EndUserFileCellView extends LinearLayout implements zendesk.messaging.ui.Updatable<zendesk.messaging.ui.EndUserCellFileState> {

    private ImageView appIcon;
    private LinearLayout bubble;
    private Drawable defaultAppIcon;
    private TextView fileDescriptor;
    private TextView fileName;
    private zendesk.messaging.ui.FileUploadProgressView fileUploadProgressView;
    private TextView label;
    private zendesk.messaging.ui.MessageStatusView statusView;
    public EndUserFileCellView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init();
    }

    private void init() {
        setOrientation(1);
        setGravity(8388693);
        LinearLayout.inflate(getContext(), R.layout.zui_view_end_user_file_cell_content, this);
    }

    @Override // android.widget.LinearLayout
    protected void onFinishInflate() {
        Drawable drawable;
        int zui_ic_insert_drive_file;
        ImageView appIcon;
        super.onFinishInflate();
        this.bubble = (LinearLayout)findViewById(R.id.zui_cell_file_container);
        this.fileName = (TextView)findViewById(R.id.zui_file_cell_name);
        this.fileDescriptor = (TextView)findViewById(R.id.zui_cell_file_description);
        this.appIcon = (ImageView)findViewById(R.id.zui_cell_file_app_icon);
        this.fileUploadProgressView = (FileUploadProgressView)findViewById(R.id.zui_cell_file_upload_progress);
        this.statusView = (MessageStatusView)findViewById(R.id.zui_cell_status_view);
        this.label = (TextView)findViewById(R.id.zui_cell_label_message);
        drawable = a.f(getContext(), R.drawable.zui_ic_insert_drive_file);
        this.defaultAppIcon = drawable;
        if (drawable != null) {
            d.c(d.e(R.attr.colorPrimary, getContext(), R.color.zui_color_primary), this.defaultAppIcon, this.appIcon);
        }
    }

    @Override // android.widget.LinearLayout
    public void update(Object object) {
        update((EndUserCellFileState)object);
        throw 0;
    }

    @Override // android.widget.LinearLayout
    public void update(zendesk.messaging.ui.EndUserCellFileState endUserCellFileState) {
        UtilsEndUserCellView.setCellBackground(endUserCellFileState, this.bubble);
        UtilsEndUserCellView.setLabelErrorMessage(endUserCellFileState, this.label, getContext());
        UtilsEndUserCellView.setClickListener(endUserCellFileState, this);
        UtilsEndUserCellView.setLongClickListener(endUserCellFileState, this);
        this.statusView.setStatus(endUserCellFileState.getStatus());
        endUserCellFileState.getAttachment().getName();
        throw 0;
    }
}
