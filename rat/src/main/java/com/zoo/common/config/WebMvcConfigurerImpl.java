package com.zoo.common.config;

// Spring의 Configuration 어노테이션을 임포트
import org.springframework.context.annotation.Configuration;
// 인터셉터 등록을 위한 WebMvcConfigurer 임포트
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 인터셉터 클래스를 임포트
import com.zoo.common.interceptor.CheckLoginSessionInterceptor;

// Spring의 설정 클래스로 지정
@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer {

	// 인터셉터 등록 메서드 오버라이드
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// CheckLoginSessionInterceptor 인스턴스를 인터셉터로 추가
		registry.addInterceptor(new CheckLoginSessionInterceptor())
				// 인터셉터의 실행 순서를 설정 (낮은 숫자일수록 먼저 실행됨)
				.order(1) // 이 인터셉터는 다른 인터셉터들보다 먼저 실행됨
				// 인터셉터가 적용될 URL 패턴 지정
				.addPathPatterns("/xdm/v1/infra/**")
				// 인터셉터에서 제외할 URL 패턴 지정
				.excludePathPatterns("/resources/**", // resources 폴더 하위의 모든 경로 제외
						"/xdm/v1/**", 
						"/xdm/v1/infra/member/membersigninXdmForm", // 로그인 페이지 제외
						"/xdm/v1/infra/member/membersigninXdmProc" // 로그인 처리 페이지 제외
				);
	}
}