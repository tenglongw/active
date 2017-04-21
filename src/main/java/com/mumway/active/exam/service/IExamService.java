package com.mumway.active.exam.service;

import java.util.List;
import java.util.Map;

import com.mumway.active.exam.Mapper.UserRateMapper;
import com.mumway.active.exam.domain.Question;
import com.mumway.active.exam.domain.QuestionType;
import com.mumway.active.exam.domain.UserRate;

/**
 * 考试service
 * @author wtl
 *
 */
public interface IExamService {

	//查询考题
	public List<Question> queryExamQuestions();
	
	public QuestionType getQuestionTypeById(int id);
	
	/**保存答题信息
	 * @param answerResultsList
	 */
	public void saveQuestionAnswers(List<Map<String,Object>> answerResultsList);
	
	public void saveUserRate(Map<String,Object> userRate);
	
	/**判断用户是否关注
	 * @param openid
	 * @return
	 */
	public boolean isAttention(String openid);
	
	/**根据openid查询考生答题信息
	 * @param openid
	 * @return
	 */
	public List<Question> getExamInfoByOpenid(String openid);
	
	/**根据openid获取用户评级
	 * @param openid
	 * @return
	 */
	public UserRate getUserRateInfoByOpenid(String openid);
	
	public boolean isLogin(String openid);
}
