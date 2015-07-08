package com.baobaotao.proxy;

public class ForumServiceImpl implements ForumService{

	@Override
	public void removeTopic(int topicId) {
		// TODO Auto-generated method stub
		PerformanceMonitor.begin("com.baobaotao.proxy.ForumServiceImpl.removeTopic");
		System.out.println("模拟删除Topic记录："+topicId);
		try{
			Thread.currentThread().sleep(20);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		PerformanceMonitor.end();
	}

	@Override
	public void removeForum(int forumId) {
		// TODO Auto-generated method stub
		PerformanceMonitor.begin("com.baobaotao.proxy.ForumServiceImpl.removeForum");
		System.out.println("模拟删除Topic记录："+forumId);
		try{
			Thread.currentThread().sleep(40);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		PerformanceMonitor.end();
	}

}
