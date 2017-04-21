package com.mumway.active.exam.domain;

public class UserWeixin {
    private String openid;

    private String nickname;

    private String headimgurl;

    private String unionid;

    private String fromUnionid;
    
    private String fromOpenid;

    public String getFromOpenid() {
		return fromOpenid;
	}

	public void setFromOpenid(String fromOpenid) {
		this.fromOpenid = fromOpenid;
	}

	public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    public String getFromUnionid() {
        return fromUnionid;
    }

    public void setFromUnionid(String fromUnionid) {
        this.fromUnionid = fromUnionid == null ? null : fromUnionid.trim();
    }
}