package sombrero.abstraction_validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class EventValidator implements Validator {

    /**
     * 검증할 클래스가 검증할 수 있는(검증하려고 하는) 클래스인지 확인.
     */
    @Override
    public boolean supports(Class<?> aClass) {
        return Event.class.equals(aClass);
    }

    /**
     * Event 클래스의 title이 비어있으면 에러 발생.
     *
     * 에러 메세지의 키값 역할을 하는 errorCode와
     * 에러 메세지인 defaultMessage를 임의로 작성.
     * - errorCode: "notempty"
     * - defaultMessage: "Empty title is not allowed."
     */
    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "notempty", "Empty title is not allowed.");
    }

}
