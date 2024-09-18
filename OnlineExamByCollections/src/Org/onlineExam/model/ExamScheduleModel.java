package Org.onlineExam.model;

import java.util.ArrayList;

public class ExamScheduleModel {
   private int id;
   private String name;
   private String date;
   private String startTime,endTime;
   private ArrayList questionBank;
public int getId() {
	return id;
}
public void setId1(int examId) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getStartTime() {
	return startTime;
}
public void setStartTime(String startTime) {
	this.startTime = startTime;
}
public String getEndTime() {
	return endTime;
}
public void setEndTime(String endTime) {
	this.endTime = endTime;
}
public ArrayList getQuestionBank() {
	return questionBank;
}
public void setQuestionBank(ArrayList questionBank) {
	this.questionBank = questionBank;
}


}
