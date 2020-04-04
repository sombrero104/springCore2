package sombrero.abstraction_data_binding.before_spring_3_0;

import java.beans.PropertyEditorSupport;

/**
 * [PropertyEditor 만들기]
 *
 * implements PropertyEditor를 해도 되지만 구현해야 할 메소드가 많음.
 * 때문에 extends PropertyEditorSupport로 상속받아서
 * 구현해야 될 메소드만 구현해서 사용할 수 있음.
 */
public class EventEditor extends PropertyEditorSupport {

    /**
     * 보통 아래 두 메소드를 구현해서 사용.
     *
     * PropertyEditor가 받은 객체를 getValue()로 가져올 수 있음.
     *
     * 주의) PropertyEditor가 가지고 있는 값은 서로 다른 스레드끼리 공유가 됨. (stateful(상태 유지), 상태 정보를 저장하고 있음.)
     * 스레드-세이프 하지 않음.
     * 때문에 PropertyEditor는 빈으로 등록하면 안됨. (여러 스레드가 공유하도록 사용하면 안됨.)
     * (1번 회원이 2번 회원의 정보를 변경하고, 2번 회원이 1번 회원의 정보를 변경하는 일이 발생.)
     * 때문에 절대로 PropertyEditor는 빈으로 등록해서 쓰면 안됨.
     * (한 스레드에서만 유효한 thread scope의 빈으로 만들어서 사용하는 것은 가능.)
     */
    @Override
    public String getAsText() {
        return null;
        /*Event event = (Event)getValue();
        return event.getId().toString();*/
    }

    /**
     * 들어오는 문자열 값을 숫자로 간주하도록 설정.
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        // setValue(new Event(Integer.parseInt(text)));
    }

}
