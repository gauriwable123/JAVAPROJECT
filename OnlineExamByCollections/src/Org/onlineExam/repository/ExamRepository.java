package Org.onlineExam.repository;
import java.util.*;
import Org.onlineExam.model.ExamScheduleModel;
public class ExamRepository {
	static  QuestionRepository questRepo=new QuestionRepository();	
	ExamScheduleModel model=null;
 public boolean scheduleExam(ExamScheduleModel model)
 {this.model=model;
	
	ArrayList al=questRepo.getAllQuestions();
	if(al.size()>0)
	{
		model.setQuestionBank(al);	
		return true;
	}
	else
	{
	  return false;
	}
 }
 
 public ExamScheduleModel getExamSchedule()
 {
	 return model!=null?model:null;
 }
}
