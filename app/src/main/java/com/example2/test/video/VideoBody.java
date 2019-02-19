package com.example2.test.video;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class VideoBody implements Parcelable {

    private int resume;
    private int loop;
    private int startpoint;

    private List<String> url;

    private String mac;
    private String relate_cmd;
    /*是否需要请求视频相关联的二维码*/
    private int qrcode;
    /*请求二维码位置的接口*/
    private String qrapi;

    /**
     * @Description 0是直接播放 1大麦点播调度 2是全国直播流调度播放 3.爱奇艺内容，需走爱奇艺播放器
     */
    private int dispatch;

    public int getDispatch() {
        return dispatch;
    }

    public void setDispatch(int dispatch) {
        this.dispatch = dispatch;
    }

    public int getResume() {
        return resume;
    }

    public void setResume(int resume) {
        this.resume = resume;
    }

    public int getLoop() {
        return loop;
    }

    public void setLoop(int loop) {
        this.loop = loop;
    }

    public int getStartpoint() {
        return startpoint;
    }

    public void setStartpoint(int startpoint) {
        this.startpoint = startpoint;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getRelate_cmd() {
        return relate_cmd;
    }

    public void setRelate_cmd(String relate_cmd) {
        this.relate_cmd = relate_cmd;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.resume);
        dest.writeInt(this.loop);
        dest.writeInt(this.startpoint);
        dest.writeStringList(this.url);
        dest.writeString(this.mac);
        dest.writeString(this.relate_cmd);
        dest.writeString(this.qrapi);
        dest.writeInt(this.qrcode);
        dest.writeInt(this.dispatch);
    }

    public VideoBody() {
    }

    protected VideoBody(Parcel in) {
        this.resume = in.readInt();
        this.loop = in.readInt();
        this.startpoint = in.readInt();
        this.url = in.createStringArrayList();
        this.mac = in.readString();
        this.relate_cmd = in.readString();
        this.qrapi = in.readString();
        this.qrcode = in.readInt();
        this.dispatch = in.readInt();
    }

    public static final Creator<VideoBody> CREATOR = new Creator<VideoBody>() {
        @Override
        public VideoBody createFromParcel(Parcel source) {
            return new VideoBody(source);
        }

        @Override
        public VideoBody[] newArray(int size) {
            return new VideoBody[size];
        }
    };

    public int getQrcode() {
        return qrcode;
    }

    public void setQrcode(int qrcode) {
        this.qrcode = qrcode;
    }

    public String getQrapi() {
        return qrapi;
    }

    public void setQrapi(String qrapi) {
        this.qrapi = qrapi;
    }
}
