package rebel.web.dao;

import java.util.List;

import rebel.web.model.JobsRegistration;
import rebel.web.model.Jobs;

public interface JobsDao {

	void addJob(Jobs job);
	List<Jobs> viewJobs();
	void deleteJob(int id);
	void updateJob(Jobs job);
	Jobs viewJob(int id);
	void registerJob(JobsRegistration jobsregistration);
	
}