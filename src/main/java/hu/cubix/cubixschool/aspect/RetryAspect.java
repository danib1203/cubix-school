package hu.cubix.cubixschool.aspect;

import hu.cubix.cubixschool.config.SchoolConfigProperties;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class RetryAspect {

    private final SchoolConfigProperties schoolConfigProperties;


    @Around("@annotation(hu.cubix.cubixschool.aspect.Retry)")
    public Object retryLogic(ProceedingJoinPoint joinPoint) throws Throwable {

        int attempt = 0;
        int maxAttempts = schoolConfigProperties.getRetry().getMaxAttempts();
        int delayInMillisecond = (int) schoolConfigProperties.getRetry().getDelayMs();

        while (attempt < maxAttempts) {

            try {
                return joinPoint.proceed();
            } catch (Exception e) {
                attempt++;
                if (attempt >= maxAttempts) {
                    throw e;
                }
                Thread.sleep(delayInMillisecond);
            }
        }
        return null;
    }
}
