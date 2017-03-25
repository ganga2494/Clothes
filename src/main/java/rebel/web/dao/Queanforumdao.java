package rebel.web.dao;

import java.util.List;

import rebel.web.model.Queanforum;

public interface Queanforumdao {
	void addQuestion(Queanforum forum);
	List<Queanforum> viewQuestions();
	void updateQuestion(Queanforum forum);
	void deleteQuestion(int qid);
	Queanforum getQuestion(int qid);
}