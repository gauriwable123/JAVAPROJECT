package Org.onlineExam.service;

import java.util.ArrayList;

import Org.onlineExam.model.Question;
import Org.onlineExam.repository.QuestionRepository;

public class QuestionService {
    QuestionRepository qRepo=new QuestionRepository();
 
    public boolean isAddQuestion(Question q)
    {
    	int qid=qRepo.getId();
    	qid+=1;//qid=qid+1;
    	q.setId(qid);
    	boolean b=qRepo.isAddQuestion(q);
    	return b;
    }
    public ArrayList getAllQuestion()
    {
    
    	ArrayList al=qRepo.getAllQuestions();
		return al.size()>0?al:null;
    	}
}
