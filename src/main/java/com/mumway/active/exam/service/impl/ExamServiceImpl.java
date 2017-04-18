package com.mumway.active.exam.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mumway.active.exam.Mapper.AnswerResultsMapper;
import com.mumway.active.exam.Mapper.QuestionMapper;
import com.mumway.active.exam.Mapper.QuestionTypeMapper;
import com.mumway.active.exam.Mapper.UserRateMapper;
import com.mumway.active.exam.Mapper.UserWeixinLbqMapper;
import com.mumway.active.exam.Mapper.UserWeixinMapper;
import com.mumway.active.exam.domain.Question;
import com.mumway.active.exam.domain.QuestionType;
import com.mumway.active.exam.domain.UserRate;
import com.mumway.active.exam.domain.UserWeixin;
import com.mumway.active.exam.service.IExamService;

@Service
public class ExamServiceImpl implements IExamService {

	@Resource
	private QuestionMapper questionMapper;
	
	@Resource
	private QuestionTypeMapper questionTypeMapper;
	
	@Resource
	private AnswerResultsMapper answerResultsMapper;
	
	@Resource
	private UserRateMapper userRateMapper;
	
	@Resource
	private UserWeixinMapper userWeixinMapper;
	
	@Resource
	private UserWeixinLbqMapper userWeixinLbqMapper;
	/**
	 * 查询考题
	 */
	public List<Question> queryExamQuestions() {
		List<QuestionType> qtList = questionTypeMapper.queryExamQuestions();
		List<Question> resultList = new ArrayList<Question>();
		for(QuestionType questionType: qtList){
			switch(questionType.getId()){
				case 1:
					//婴幼儿护理
					List<Question> questionList1 = randomListByNum(questionType.getQuestions(), questionType.getQuestionNumber());
//					questionType.setQuestions(questionList1);
					resultList.addAll(questionList1);
//					System.out.println("婴幼儿护理="+resultList.size());
					break;
				case 2:
					//产妇护理
					List<Question> questionList2 = randomListByNum(questionType.getQuestions(), questionType.getQuestionNumber());
//					questionType.setQuestions(questionList2);
					resultList.addAll(questionList2);
//					System.out.println("产妇护理="+resultList.size());
					break;
				case 3:
					//新生儿护理
					List<Question> questionList3 = randomListByNum(questionType.getQuestions(), questionType.getQuestionNumber());
//					questionType.setQuestions(questionList3);
					resultList.addAll(questionList3);
//					System.out.println("新生儿护理="+resultList.size());
					break;
				case 4:
					//催乳
					List<Question> questionList4 = randomListByNum(questionType.getQuestions(), questionType.getQuestionNumber());
//					questionType.setQuestions(questionList4);
					resultList.addAll(questionList4);
//					System.out.println("催乳="+resultList.size());
					break;
				default:
					//营养
					List<Question> questionList = randomListByNum(questionType.getQuestions(), questionType.getQuestionNumber());
//					questionType.setQuestions(questionList);
					resultList.addAll(questionList);
//					System.out.println("营养="+resultList.size());
					break;
					
			}
		}
		return resultList;
	}
	
	/**
	 * 随机选取指定数量的题目
	 * @param QuestionList
	 * @param num
	 * @return
	 */
	private List<Question> randomListByNum(List<Question> questionList, int num){
		Random random = new Random();
		Set<Integer> indexSet = new HashSet<Integer>();
		List<Question> resultList = new ArrayList<Question>();
		while(indexSet.size() < num){
			//获取随机数
			int index = random.nextInt(questionList.size());
			indexSet.add(index);
		}
		for(Integer index : indexSet){
			//取得随机数对应的题目
//			System.out.println("题目=="+questionList.get(index).getName()+"题目ID"+questionList.get(index).getId());
			resultList.add(questionList.get(index));
		}
		return resultList;
	}
	
	public void saveQuestionAnswers(List<Map<String,Object>> answerResultsList){
		for(Map<String,Object> answerResults : answerResultsList){
			answerResultsMapper.insertMap(answerResults);
		}
	}
	
	public QuestionType getQuestionTypeById(int id) {
		return questionTypeMapper.selectByPrimaryKey(id);
	}

	public void saveUserRate(Map<String, Object> userRate) {
		// TODO Auto-generated method stub
		userRateMapper.insertMap(userRate);
	}

	public boolean isAttention(String openid) {
		return false;
	}

	/**
	 * 根据openid查询考生答题信息
	 */
	public List<Question> getExamInfoByOpenid(String openid) {
		
		return questionMapper.getExamInfoByOpenid(openid);
	}

	public UserRate getUserRateInfoByOpenid(String openid) {
		// TODO Auto-generated method stub
		return userRateMapper.selectByOpenid(openid);
	}

}
