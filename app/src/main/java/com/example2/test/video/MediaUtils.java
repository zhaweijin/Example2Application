package com.example2.test.video;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;

import java.util.HashMap;

public class MediaUtils {

    private static MediaUtils             sMediaUtils;
    private MediaMetadataRetriever retriever;
    private        String                 fileLength;

    private MediaUtils() {

    }

    public static MediaUtils getInstance() {
        if (sMediaUtils == null) {
            sMediaUtils = new MediaUtils();
        }
        return sMediaUtils;
    }

    public void setSource(String filePath) {
        retriever = new MediaMetadataRetriever();
        retriever.setDataSource(filePath, new HashMap<String, String>());
        fileLength = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
    }

    /**
     * 获取视频某一帧	 * @param timeMs 毫秒	 * @param listener
     */
    public Bitmap decodeFrame(long timeMs) {
        if (retriever == null) {
            return null;
        }
        Bitmap bitmap = retriever.getFrameAtTime(timeMs * 1000, MediaMetadataRetriever.OPTION_CLOSEST);
        if (bitmap != null) {
            return bitmap;
        }
        return null;
    }


    public String getFileLength() {
        return fileLength;
    }

}
