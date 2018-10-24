package ex02;

import java.beans.PropertyEditorSupport;

// String ==> java.util.Date 프로퍼티 값 변환기
//
public class CarPropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println(text);
    
        try {
            String[]values = text.split(",");
            Car car = new Car();
            car.setModel(values[0]);
            car.setMaker(values[1]);
            car.setAuto(Boolean.parseBoolean(values[2]));
            this.setValue(car);
        }catch(Exception e) {
            throw new IllegalArgumentException(e); 
        }
    }
    
    @Override
    public Object getValue() {
        // 이 메서드는 오버라이딩 할 필요가 없다.
        // 단지 예제에서 언제 호출되는지 확인하기 위해 오버라이딩 한 것이다.
        System.out.println("DatePropertyEditor.getValue()");
        
        return super.getValue();
    }
}










