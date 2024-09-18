package Org.onlineExam.repository;
import java.util.*;

import Org.onlineExam.model.Question;
public class QuestionRepository {

	static ArrayList al=new ArrayList();//it is my temporary database
	public int getId()
	{
		return al.size();
	}
	public boolean isAddQuestion(Question q)
	{
		
		boolean b=al.add(q);
		return b;
	}
	public ArrayList getAllQuestions()
	{
		return al;
	}
}
