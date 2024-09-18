package Org.onlineExam.client;

import java.util.ArrayList;
import java.util.Scanner;

import Org.onlineExam.model.ExamScheduleModel;
import Org.onlineExam.model.Question;
import Org.onlineExam.model.StudentModel;
import Org.onlineExam.service.ExamService;
import Org.onlineExam.service.QuestionService;

public class OnlineExamClientApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    QuestionService qService=new QuestionService();
    ExamService examservice =new ExamService();
    ExamScheduleModel model=null;
    do
    {
    	System.out.println("1:Add new question");
    	System.out.println("2:view all question");
    	System.out.println("3:create exam");
    	System.out.println("4:view question exam wise");
    	System.out.println("5:Attempt exam by student ");
    	Scanner xyz=new Scanner(System.in);
    	int choice=xyz.nextInt();
    	switch(choice)
    	{
    	case 1:	
    		xyz.nextLine();
    		System.out.println("enter questions and options with answers");
    		String qname=xyz.nextLine();
    		String op1=xyz.nextLine();
    		String op2=xyz.nextLine();
    		String op3=xyz.nextLine();
    		String op4=xyz.nextLine();
    		String answer=xyz.nextLine();
    		Question q=new Question(qname,op1,op2,op3,op4,answer);
    		
    		boolean b=qService.isAddQuestion(q);
    		if(b)
    		{
    			System.out.println("question added success");
    		}
    		else
    		{
    			System.out.println("some problem");
    		}
    		break;
    	case 2:
    		ArrayList al=qService.getAllQuestion();
    		if(al!=null)
    		{
    			for(Object obj:al)
    			{
    				Question ques=(Question)obj;
    				System.out.println(ques.getId()+"\t"+ques.getName()+"\t"+ques.getOp1()+"\t"+ques.getOp2()+"\t"+ques.getOp3()+"\t"+ques.getOp4()+"\t"+ques.getAnswer());
    			}
    		}
    		else
    		{
    			System.out.println("no data present in collection");
    		}
    		break;
    	case 3:
    		 System.out.println("enter exam id name date start time end time");
    		 int examId=xyz.nextInt();
    		 xyz.nextLine();
    		 String examName=xyz.nextLine();
    		 String examDate=xyz.nextLine();
    		 String startTime=xyz.nextLine();
    		 String endTime=xyz.nextLine();
    		 ExamScheduleModel examModel=new ExamScheduleModel();
    		examModel.setId1(examId);
    		examModel.setName(examName);
    		examModel.setDate(examDate);
    		examModel.setStartTime(startTime);
    		examModel.setEndTime(endTime);
    		
    		  b=examservice.scheduleExam(examModel);
    		  
    		 if(b)
    		 {
    			 System.out.println("exam schedule successfully............");
    		 }
    		 else
    		 {
    			 System.out.println("there is no question bank so no exam schedule");
    		 }
    		 break;
    	case 4: 
    		 model=examservice.getExamSchedule();
    		if(model!=null)
    		{
    			System.out.println(model.getId()+"\t"+model.getName()+"\t"+model.getDate()+"\t"+model.getStartTime()+"\t"+model.getEndTime());
    			al=model.getQuestionBank();
    			System.out.println("==============================================================");
    			for(Object obj:al)
    			{
    				 q=(Question)obj;
    				System.out.println(q.getId()+"\t"+q.getName()+"\t"+q.getOp1()+"\t"+q.getOp2()+"\t"+q.getOp3()+"\t"+q.getOp4()+"\t"+q.getAnswer());
    			}
    		}
    		else
    		{
    			System.out.println("there is no exam schedule");
    		}
    		break;
    	case 5:
    		xyz.nextLine();
    		StudentModel smodel=new StudentModel();
    		System.out.println("enter student id and name");
    		int sid=xyz.nextInt();
    		xyz.nextLine();
    		String sname=xyz.nextLine();
    		
    		smodel.setId(sid);
    		smodel.setName(sname);
    		if(model!=null)
    		{
    		smodel.setModel(model);
    		al=model.getQuestionBank();
    	     if(al.size()>0)
    	     {int index=0;
    	    	do
    	    	{
    	    	 Question q1=(Question)al.get(index);
    	    	 System.out.println("Question is :"+q1.getName());
    	    	 System.out.println("option1 is :"+q1.getOp1());
    	    	 System.out.println("option2 is :"+q1.getOp2());
    	    	 System.out.println("option3 is :"+q1.getOp3());
    	    	 System.out.println("option4 is :"+q1.getOp4());
    	    	 System.out.println("enter your answer :");
    	    	  answer=xyz.nextLine();
    	    	  if(answer.equals(q1.getAnswer()))
    	    	  {
    	    		q1.setStatus(true);  
    	    	  }
    	    	 ++index;
    	    	}while(index!=al.size());
    	    	System.out.println("print all question");
    	    	int count=0;
    	    	for(Object obj:al)
    	    	{
    	    		q=(Question)obj;
    	    		System.out.println(q.getId()+"\t"+q.getName()+"\t"+q.getOp1()+"\t"+q.getOp2()+"\t"+q.getOp3()+"\t"+q.getOp4()+"\t"+q.getAnswer()
    	    		+"\t"+q.isStatus());
    	    		if(q.isStatus())
    	    		{
    	    			++count;
    	    			
    	    		}
    	    	}
    	    	int wrongQuestion=al.size()-count;//3-2
    	    	float per=((float)((float)count/(float)al.size())*100);
    	    	System.out.println("hey student your total percentage is"+per);
    	    	System.out.println("total number of question"+al.size());
    	    	System.out.println("correct solved question count"+count);
    	    	System.out.println("wrong question count"+wrongQuestion);
    	     }
    	     else
    	     {
    	    	 System.out.println("wait for question paper");
    	     }
    		}
    		else
    		{
    			System.out.println("there is no exam");
    		}
    		break;
    	default:	
    		System.out.println("wrong choice");
    }
    }
    while(true);//infinite loop
    
	}

}
