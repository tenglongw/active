package com.mumway.active.exam.domain;

import java.util.Date;

public class AnswerResults {
    private Integer id;

    private Integer userId;

    private Integer questionId;

    private Integer value;

    private String questionAnswserOption;

    private String isCorrect;

    private Date updateTime;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getQuestionAnswserOption() {
        return questionAnswserOption;
    }

    public void setQuestionAnswserOption(String questionAnswserOption) {
        this.questionAnswserOption = questionAnswserOption == null ? null : questionAnswserOption.trim();
    }

    public String getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(String isCorrect) {
        this.isCorrect = isCorrect == null ? null : isCorrect.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}