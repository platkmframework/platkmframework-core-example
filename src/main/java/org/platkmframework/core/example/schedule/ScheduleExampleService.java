package org.platkmframework.core.example.schedule;

import org.platkmframework.annotation.Service;
import org.platkmframework.annotation.timer.TimerFixeDelayScheduler;
import org.platkmframework.annotation.timer.TimerFixeRateScheduler;
import org.platkmframework.annotation.timer.TimerScheduler;

@Service
public class ScheduleExampleService {
	
	@TimerFixeDelayScheduler(period = "10000")
	public void timerFixeDelayScheduler() {
		System.out.println("@TimerFixeDelayScheduler, Con espera a la finalización de la ejecución anterior. Ejecutado siempre cada diez segundo");
	}
	
	@TimerFixeRateScheduler(delay = "", period = "10000")
	public void timerFixeRateScheduler() {
		System.out.println("@TimerFixeRateScheduler, Sin espera a la finalización de la ejecución anterior. Ejecutado siempre cada diez segundo");
	}
	
	
	@TimerScheduler(delay = "10000", time = "")
	public void timerScheduler() {
		System.out.println("@TimerScheduler, ejecutado después de espera de diez segundo");
	}
	
	
	@TimerScheduler(delay = "30000", time = "")
	public void stopAllScheduler() {
		System.out.println("30 segundos pasados, se finalizan todas las operaciones");
		System.exit(-1);
	}

}
