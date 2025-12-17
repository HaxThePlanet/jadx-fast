package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class NullMediaHeaderBox extends com.coremedia.iso.boxes.AbstractMediaHeaderBox {

    public static final String TYPE = "nmhd";
    public NullMediaHeaderBox() {
        super("nmhd");
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    protected void getContent(ByteBuffer byteBuffer) {
        writeVersionAndFlags(byteBuffer);
    }

    @Override // com.coremedia.iso.boxes.AbstractMediaHeaderBox
    protected long getContentSize() {
        return 4;
    }
}
