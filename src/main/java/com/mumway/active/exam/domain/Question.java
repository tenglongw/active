package com.mumway.active.exam.domain;

import java.util.Date;
import java.util.List;

public class Question {
    private Integer id;

    private String name;

    private Integer questionTypeId;

    private Integer score;

    private Integer sort;

    private Date updateTime;

    private Date createTime;
    
    private List<QuestionAnswer> qAnswers;
    
    private String isAnswerCorrect;
    
    private Integer answerId;
    
    public Integer getAnswerId() {
		return answerId;
	}

	public void setAnswerId(Integer answerId) {
		this.answerId = answerId;
	}

	public String getIsAnswerCorrect() {
		return isAnswerCorrect;
	}

	public void setIsAnswerCorrect(String isAnswerCorrect) {
		this.isAnswerCorrect = isAnswerCorrect;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getQuestionTypeId() {
        return questionTypeId;
    }

    public void setQuestionTypeId(Integer questionTypeId) {
        this.questionTypeId = questionTypeId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

	public List<QuestionAnswer> getQAnswers() {
		return qAnswers;
	}

	public void setQAnswers(List<QuestionAnswer> qAnswers) {
		this.qAnswers = qAnswers;
	}
}