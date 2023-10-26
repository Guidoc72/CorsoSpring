package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.constructor.Dipendenza_B;
import com.example.constructor._02_ConstructorInjection;
import com.example.setter.Dipendenza_C;
import com.example.setter._03_SetterInjection;

@SpringBootApplication
public class SpringBootAutowired03Application {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBootAutowired03Application.class, args);
		
		for(String beanName : ctx.getBeanDefinitionNames()) {
			System.out.println("Bean ---->  " + beanName);
		}
//TEST ISTANZA DIPENDENZA		
//		Dipendenza_A da = ctx.getBean("dipendenza_A", Dipendenza_A.class);
//		System.out.println(da.getElemA());
		
//TEST FILED INJECTION		
//		_01_FieldInjection fi = new _01_FieldInjection(); se istanzio con "new" la DI non funziona!
//		_01_FieldInjection fi = ctx.getBean(_01_FieldInjection.class);	 //devo recuperare l'istanza presente nel context	
		//La riga seguente genera una  NullPointerException perché non siamo 
		//riusciti ad iniettare la dipendenza con la field Injection
//		System.out.println(fi.getDipA().getElemA() );
		
//TEST CONSTRUCTOR INJECTION
//		Dipendenza_B dB = ctx.getBean("dipendenza_B", Dipendenza_B.class);
//		System.out.println("B->"+dB.getElemB());		
//		_02_ConstructorInjection ci = ctx.getBean(_02_ConstructorInjection.class);
//		System.out.println(ci.getDipB().getElemB());
		
//TEST SETTER INJECTION		
		Dipendenza_C dC = ctx.getBean("dipendenza_C", Dipendenza_C.class);
		System.out.println("C->"+dC.getElemC());		
		_03_SetterInjection si = ctx.getBean(_03_SetterInjection.class);
		System.out.println(si.getDipC().getElemC());
		
		

		
	}

}
