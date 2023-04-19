package com.rlagus.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rlagus.validation.dto.StudentDto;

public class StudentValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {	
		// 검증할 객체(studentDto)의 클래스 타입 정보
		
		return StudentDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		StudentDto studentDto = (StudentDto) target;
		// 검증할 객체를 타겟으로 지정(Object 형 이므로 형변환 필요)
		
		String studentId = studentDto.getId();
		String studentPw = studentDto.getPw();
		
//		if(studentId == null || studentId.trim().isEmpty()) {
//								// trim()으로 공백을 제거하고도 비여있으면
//			errors.rejectValue("id", "trouble1");
//		} else if(studentPw == null || studentPw.trim().isEmpty()) {
//			errors.rejectValue("id", "trouble2");
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "trouble");
		
		if(studentPw == null || studentPw.trim().isEmpty()) {
			errors.rejectValue("pw", "trouble2");
		}
	}
}
