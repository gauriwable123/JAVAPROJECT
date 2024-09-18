package Org.onlineExam.service;

import Org.onlineExam.model.ExamScheduleModel;
import Org.onlineExam.repository.ExamRepository;

public class ExamService {
	ExamRepository examRepo=new ExamRepository();
public boolean scheduleExam(ExamScheduleModel model)
{
	
    return examRepo.scheduleExam(model);	
}
public ExamScheduleModel getExamSchedule()
{
	return examRepo.getExamSchedule();
	
}
}
