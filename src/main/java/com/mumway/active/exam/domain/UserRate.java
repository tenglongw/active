package com.mumway.active.exam.domain;

public class UserRate {
    private Integer id;

    private String userName;

    private String phone;

    private Integer infantNurse;

    private Integer puerperaNurse;

    private Integer newbornNurse;

    private Integer lactagogue;

    private Integer nutrition;
    
    private String openid;

    public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getInfantNurse() {
        return infantNurse;
    }

    public void setInfantNurse(Integer infantNurse) {
        this.infantNurse = infantNurse;
    }

	public Integer getPuerperaNurse() {
		return puerperaNurse;
	}

	public void setPuerperaNurse(Integer puerperaNurse) {
		this.puerperaNurse = puerperaNurse;
	}

	public Integer getNewbornNurse() {
		return newbornNurse;
	}

	public void setNewbornNurse(Integer newbornNurse) {
		this.newbornNurse = newbornNurse;
	}

	public Integer getLactagogue() {
		return lactagogue;
	}

	public void setLactagogue(Integer lactagogue) {
		this.lactagogue = lactagogue;
	}

	public Integer getNutrition() {
		return nutrition;
	}

	public void setNutrition(Integer nutrition) {
		this.nutrition = nutrition;
	}

}