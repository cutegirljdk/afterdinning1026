package org.kosta.myproject.controller;

/*
 *  개별 컨트롤러 객체 생성을 전담하는 팩토리 객체 
 *  시스템 상에서 현 객체는 하나만 생성해서 공유해 사용하는것이 적합하므로 Singleton Design Pattern
 *  
 *  전달받은 컨트롤러 명을 이용해 실행시 객체를 자동 생성하기 위해 Reflection API 를 이용 ..
 */

public class HandlerMapping {
	private static HandlerMapping instance=new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() { 
		return instance;
	}
	public Controller create(String controllerName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//String packageInfo=this.getClass().getPackage().getName(); // 현재 패키지가 동적이게 나온대..
		//System.out.println("packageInfo"+packageInfo);
		//String classInfo=packageInfo+"."+controllerName;
		//System.out.println("classInfo"+classInfo);
		
		//String 과 StringBuilder 의 특징 : StringBuilder 는 자체가 변경되므로 자원을 절약할 수 있다
		
		 StringBuilder classInfo=new StringBuilder(this.getClass().getPackage().getName());
		classInfo.append(".").append(controllerName);		 
		return (Controller) Class.forName(classInfo.toString()).newInstance(); //클래스 정보로 객체 생성을 자동화 한다 
								
	}	
}
