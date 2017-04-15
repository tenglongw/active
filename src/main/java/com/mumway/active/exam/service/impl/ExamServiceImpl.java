package com.mumway.active.exam.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mumway.active.exam.Mapper.QuestionMapper;
import com.mumway.active.exam.Mapper.QuestionTypeMapper;
import com.mumway.active.exam.domain.Question;
import com.mumway.active.exam.domain.QuestionType;
import com.mumway.active.exam.service.IExamService;

@Service
public class ExamServiceImpl implements IExamService {

	@Resource
	private QuestionMapper questionMapper;
	
	@Resource
	private QuestionTypeMapper questionTypeMapper;
	/**
	 * 查询考题
	 */
	public List<QuestionType> queryExamQuestions() {
		List<QuestionType> qtList = questionTypeMapper.queryExamQuestions();
//		List<QuestionType> resultList = new ArrayList<QuestionType>();
		for(QuestionType questionType: qtList){
			switch(questionType.getId()){
				case 1:
					//婴幼儿护理
					//获得婴儿护理题目
					List<Question> questionList1 = randomListByNum(questionType.getQuestions(), questionType.getQuestionNumber());
					questionType.setQuestions(questionList1);
				case 2:
					//产妇护理
					//获得婴儿护理题目
					List<Question> questionList2 = randomListByNum(questionType.getQuestions(), questionType.getQuestionNumber());
					questionType.setQuestions(questionList2);
				case 3:
					//新生儿护理
					//获得婴儿护理题目
					List<Question> questionList3 = randomListByNum(questionType.getQuestions(), questionType.getQuestionNumber());
					questionType.setQuestions(questionList3);
				case 4:
					//催乳
					//获得婴儿护理题目
					List<Question> questionList4 = randomListByNum(questionType.getQuestions(), questionType.getQuestionNumber());
					questionType.setQuestions(questionList4);
				default:
					//营养
					//获得婴儿护理题目
					List<Question> questionList = randomListByNum(questionType.getQuestions(), questionType.getQuestionNumber());
					questionType.setQuestions(questionList);
					
			}
		}
		return qtList;
	}
	
	/**
	 * 随机选取指定数量的题目
	 * @param QuestionList
	 * @param num
	 * @return
	 */
	private List<Question> randomListByNum(List<Question> questionList, int num){
		Random random = new Random();
		List<Question> resultList = new ArrayList<Question>();
		for(int i = 1; i <= num; i++){
			//获取随机数
			int index = random.nextInt(num);
			//取得随机数对应的题目
			resultList.add(questionList.get(index));
		}
		return resultList;
	}
	
	public QuestionType getQuestionTypeById(int id) {
		return questionTypeMapper.selectByPrimaryKey(id);
	}

}
